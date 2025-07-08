package thirdpartyservices.bharatkosh.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;
import java.text.ParseException;

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

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import thirdpartyservices.bharatkosh.client.digitalsign.Constants;

@Path("/bharatkosh/v1")
public class BharatkoshClientRestApi {

	@POST
	@Path("/ntrp/bkpaystatus")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response trackBKPayStatus(String filters) throws ParseException, UnsupportedEncodingException {
		//System.out.println("Filter::" + filters);
		String errMsg = StringUtils.EMPTY;
		JSONObject jsonRespObject = new JSONObject();
		JSONArray jsonRespArray = new JSONArray();
		jsonRespObject.put("data", jsonRespArray);
		
		try {
			defaultSslConnection();

			JSONObject objFilterJson = new JSONObject(filters);
			JSONArray jsonArray = objFilterJson.optJSONArray("data");

			
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.optJSONObject(i);
				String trackingId = jsonObject.optString("trackingId");
				String orderId = jsonObject.optString("orderId");
				String purposeId = jsonObject.optString("purposeId");

				String queryString = "OrderId=" + orderId + "&PurposeId=" + purposeId;
				final String params = 
						"OrderId=" + URLEncoder.encode(orderId, "UTF-8") 
						+ "&PurposeId=" + URLEncoder.encode(purposeId, "UTF-8") 
						;
				//	System.out.println("Sending request:" + params);
					final byte[] postData = params.getBytes( Charset.forName("UTF-8") );
				
				//System.out.println("TrackBKPayStatus -> "+ queryString);
			HttpsURLConnection httpClient = (HttpsURLConnection) new URL(Constants.PROD_GetStatusBK_URL).openConnection();
		//		HttpsURLConnection httpClient = (HttpsURLConnection) new URL(Constants.UAT_GetStatusBK_URL).openConnection();
				httpClient.setConnectTimeout(60000);
				httpClient.setRequestMethod("POST");
				httpClient.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
				
				// Send post request
				httpClient.setDoOutput(true);
				httpClient.setDoInput(true);

				try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream())) {
					wr.write(postData);
					wr.flush();
				}


				int responseCode = httpClient.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					//System.out.println("OK");
					// Read the response from the input stream
					BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
					String inputLine;
					StringBuffer response = new StringBuffer();
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					// print the response
					//System.out.println(response.toString());

					String[] responseBKStatus = response.toString().split("\\|");
					jsonRespArray.put(jsonObject);
					if(ArrayUtils.isNotEmpty(responseBKStatus)) {
						jsonObject.put("txnId", responseBKStatus[0]);
						jsonObject.put("bkpayStatus", responseBKStatus[1]);
						jsonObject.put("bkPayUTRNo", responseBKStatus[2]);
						
						if(responseBKStatus.length > 2 & (StringUtils.equalsIgnoreCase(responseBKStatus[1], "No Record Found") || StringUtils.equalsIgnoreCase(responseBKStatus[2], "NA"))) {
							new BharatkoshClient().updateBharatkoshResp(trackingId, responseBKStatus[2], "NoRecordFound", StringUtils.EMPTY);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			jsonRespObject.put("httpStatus", Status.INTERNAL_SERVER_ERROR.name());
			jsonRespObject.put("errorMsg", errMsg);
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(jsonRespObject.toString()).build();
		}
		return Response.status(Status.OK).entity(jsonRespObject.toString()).build();

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
