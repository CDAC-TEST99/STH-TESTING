package thirdpartyservices.pan.varification.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import thirdpartyservices.pan.varification.digitalsign.PANJsonSigner;
import thirdpartyservices.pan.varification.digitalsign.PanConstants;
import thirdpartyservices.pan.varification.model.PANRequestData;
import thirdpartyservices.pan.varification.model.PanResult;

@Path("/pan/verification/v1")
public class PanVerficationRestApi {

	@POST
	@Path("/inquiry")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getPanVerficationResponse(String filters) throws ParseException, UnsupportedEncodingException {
	//	System.out.println("Filter::" + filters);
		String errMsg = StringUtils.EMPTY;
		JSONObject jsonRespObject = new JSONObject();

		SimpleDateFormat reqDateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

		try {
			defaultSslConnection();

			JSONObject objFilterJson = new JSONObject(filters);
			String panNumber = objFilterJson.getString("pan");
			String panName = objFilterJson.getString("name");
			String panFatherName = objFilterJson.getString("fathername");
			String panDob = objFilterJson.getString("dob");
	
			PANRequestData panRequest = new PANRequestData();
			panRequest.setPan(panNumber);
			panRequest.setName(panName);
			panRequest.setFathername(panFatherName);
			panRequest.setDob(panDob.replace("-", "/"));
			
			//System.out.println("Before Calling PAN API for verification = "+panDob.replace("/", "-"));

			HttpsURLConnection httpClient = (HttpsURLConnection) new URL(PanConstants.PROD_URL).openConnection();
			httpClient.setConnectTimeout(60000);
			httpClient.setRequestMethod("POST");
			httpClient.setRequestProperty("Version", "4");
			httpClient.setRequestProperty("User_ID", PanConstants.PROD_USER_ID);
			httpClient.setRequestProperty("Records_count", "1");
			httpClient.setRequestProperty("Request_time", reqDateformat.format(new Date()));
			httpClient.setRequestProperty("Transaction_ID", PanConstants.PROD_USER_ID + ":" + Calendar.getInstance().getTimeInMillis());
			httpClient.setRequestProperty("Content-Type", "application/json");

			PANJsonSigner jsonSigner = new PANJsonSigner();
			JSONObject signedJson = new JSONObject(jsonSigner.sign(panRequest));
			
			//System.out.println("SIGNED JSON --->>> " + signedJson.toString());
			
			// Send post request
			httpClient.setDoOutput(true);
			httpClient.setDoInput(true);
			try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
				wr.writeBytes(signedJson.toString());
				wr.flush();
			}

			int responseCode = httpClient.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
			//	System.out.println("OK");
				//Read the response from the input stream
				BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));        
				String inputLine;        
				StringBuffer response = new StringBuffer();         
				while ((inputLine = in.readLine()) != null) 
				{             
					response.append(inputLine);         
				}         
				in.close();         
				
				//print the response 
				//System.out.println(response.toString());
	            Gson gson = new GsonBuilder().create();
	            PanResult p = gson.fromJson(response.toString(), PanResult.class);

				return Response.ok().entity(p).build();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonRespObject.put("httpStatus", Status.INTERNAL_SERVER_ERROR.name());
		jsonRespObject.put("errorMsg", errMsg);
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(jsonRespObject.toString()).build();

	}

	private static void defaultSslConnection() throws Exception {
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };

		// Install the all-trusting trust manager
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

	}
}
