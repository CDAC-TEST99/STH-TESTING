package hisglobal.FormFlowX.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.utility.HisUtil;

 

public class WsHttpsClient {

	
	
	public static JSONObject postRequestToABHA(JSONObject filtervo,String url) throws IOException, ParseException, JSONException
	{
		System.out.println("inside verifyPatHealthId");
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		String hip_url = HisUtil.getParameterFromHisPathXML("ABDM_HIP_PATH");
		String hip_auth_key = HisUtil.getParameterFromHisPathXML("ABDM_HIP_AUTH_KEY");
	    JSONObject objResult= new JSONObject() ;
		
		URL obj = new URL(hip_url+ url);
		System.out.println("URL obj-------------------"+obj);
		HttpURLConnection postConnection = (HttpURLConnection)obj.openConnection();
		//URLConnection postConnection = obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-type","application/json;charset=UTF-8");
		postConnection.setRequestProperty("Accept", "application/json");
		postConnection.addRequestProperty("HIS-AUTH-KEY", hip_auth_key);
		
		
		//initRequest.put("healthId",pathealthid);
		String jsonInputString = filtervo.toString();
		byte[] out = jsonInputString.getBytes("utf-8");
		//System.out.println("verifyPatHealthId sending data===================="+jsonInputString);
		postConnection.setDoOutput(true);
		try(OutputStream os = postConnection.getOutputStream()) {
			os.write(out);
		}
		int responseCode = postConnection.getResponseCode();
		//System.out.println("responseCode>>>" + responseCode);
		if (responseCode == 202) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					postConnection.getInputStream()));
			String inputLine;
			StringBuffer responses = new StringBuffer();
			while ((inputLine = in .readLine()) != null) {
				responses.append(inputLine);
			} in .close();
			System.out.println(responses);
			try {
					
			objResult = new JSONObject(responses.toString());
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		} else {
			//System.out.println("responseCode >> "+responseCode+"  " +postConnection.getResponseMessage());
			objResult.put("responseCode", responseCode);
			objResult.put("responseMessage", postConnection.getResponseMessage());
			
		}
		return objResult;
	
		
	}
	
}
