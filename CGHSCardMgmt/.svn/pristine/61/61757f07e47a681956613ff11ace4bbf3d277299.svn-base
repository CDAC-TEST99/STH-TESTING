package formFlowX.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.utility.Base64Utils;
 

public class WsHttpsClient {
	
	//WsHttpsClient objWsHttpsClient= new WsHttpsClient();
	//json=objWsHttpsClient.postAndGet(uri, requestContent, serviceuserName, servicePassword);
	
	public static String postAndGet(String url, String requestContent,
			String userName, String password) throws Exception {

		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		URL object = new URL( url);

		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-type","application/json;charset=UTF-8");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "
							+ String.valueOf(Base64Utils.encode((userName + ":" + password))));
		}

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestContent.toString());
		wr.flush();

		// display what returns the POST request

		StringBuilder sb = new StringBuilder("");

		int HttpResult = con.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			//System.out.println("" + sb.toString());
		} /*
			 * else { System.out.println(con.getResponseMessage()); }
			 */

		return sb.toString();

	}

	public static String get(String url, String userName, String password)
			throws Exception {
		StringBuilder sb = new StringBuilder("");
		URL object = null;
		try {

			java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
			 object = new URL( url);

			HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			// con.setRequestProperty("Content-Type", "text/plain");
			con.setRequestProperty("Accept", "application/json");
			con.setRequestMethod("GET");

			SSLSocketFactory sslSocketFactory = createSslSocketFactory();
			con.setSSLSocketFactory(sslSocketFactory);
			
			
			if (userName != null && userName.trim().length() > 0) {
				con.setRequestProperty(
						"Authorization",
						"Basic "
								+ Base64Utils.encode((userName + ":" + password)));
			}

			con.connect();
			int responseCode = con.getResponseCode();

			//System.out.println("\nURL GlobalVariable:-->" + url);
		//	System.out.println("\nResponse Code :--> " + responseCode);

			int HttpResult = con.getResponseCode();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				//System.out.println("" + sb.toString());
			} else {
				//System.out.println(con.getResponseMessage());
				
			}

		} catch (Exception e) {

			throw e ;
		}

		return sb.toString();
	}	

	
	public static  boolean isValidJson(String json) {
	    try {
	        new JSONObject(json);
	    } catch (JSONException e) {
	        return false;
	    }
	    return true;
	}
	
	private static SSLSocketFactory createSslSocketFactory() throws Exception {

		TrustManager[] byPassTrustManagers = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] x509Certificates,
					String s) {

			}

			@Override
			public void checkServerTrusted(X509Certificate[] x509Certificates,
					String s) {

			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

		} };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, byPassTrustManagers, new SecureRandom());
		return sslContext.getSocketFactory();
	}
	
}
