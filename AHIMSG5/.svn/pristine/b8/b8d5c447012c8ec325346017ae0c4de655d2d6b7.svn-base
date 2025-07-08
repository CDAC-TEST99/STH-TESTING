package HisWeb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import org.apache.http.client.ClientProtocolException;

import hisglobal.utility.HisUtil;

public class SMSClient {

	public void SendSMSClient(String inputData ) {		
	
		new Thread(new Runnable() {
			public void run() {
				System.out.println("Inside SMS client File >>>");
				String apiResponse = "";
				String logMessage = "";
				try {
					apiResponse = sendSMS(inputData); // code from here
		
				} catch (Exception e) {
					
					e.getMessage();
					logMessage = e.getMessage();
				//	apiResponse = null;
					}
				
				 finally {
						if (logMessage !=null && logMessage.equals("") && (apiResponse == null || apiResponse.equals(""))) {
							logMessage = "Response retured in blank";
						 
						} else if (apiResponse.contains("404")) {
							
							logMessage = "404 Internal Database Error";
							System.out.println("Error Here>> "+logMessage);
							
						} else if (apiResponse.contains("405")) {
							
							logMessage = "405 Internal Networking Error";
							System.out.println("Error Here>> "+logMessage);
						} 	
					}
				 
						//System.out.println("Log Message>>>" + logMessage );
						 
					}
			
				}).start();
	}
	
	
	public String sendSMS(String content)  throws Exception{				// Forward Request to SMSUtil Module
		
		//System.out.println("inside sendsms in client AHIMS" + content );
		final String charset = "UTF-8";
		
		String SMSUtilUrl = HisUtil.getParameterFromHisPathXML("SMSUTIL_WAR_URL");
		
		
		String encodedContent = Base64.getEncoder().encodeToString(content.getBytes(charset));
		String urlEncodedContent = URLEncoder.encode(encodedContent, "UTF-8");
		String urlParameters = "hmode=sendSMS&inputData=" + urlEncodedContent;
		/*
		 * String encodedContent =
		 * Base64.getEncoder().encodeToString(content.getBytes(charset));
		 * 
		 * String urlParameters = "hmode=sendSMS&inputData=" + encodedContent;
		 */
		
		
		StringBuffer response = new StringBuffer();
		try {
		
		 HttpURLConnection connection = (HttpURLConnection) new URL(SMSUtilUrl).openConnection();
		 connection.setRequestMethod("POST");
		 connection.setDoOutput(true);			
		 connection.setRequestProperty("Accept-Charset", charset );
	
		 connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		 
		 OutputStream output = connection.getOutputStream();			
		    output.write(urlParameters.getBytes(charset));
		    output.close();
		 
		    InputStream inputStream = connection.getErrorStream();
		    if (inputStream == null)
		        inputStream = connection.getInputStream();
		    BufferedReader responseReader=null ;
		    try {
		    	 
		    	responseReader = new BufferedReader(new InputStreamReader(inputStream, charset));

			    String inputLine;
			    

			    while ((inputLine = responseReader.readLine()) != null) {
			        response.append(inputLine);
			    }
			    responseReader.close();
			   
		    }catch(Exception e) {
		    	e.printStackTrace();
		    }
		} catch (UnsupportedEncodingException e) {
			System.out.println("content "+ content );
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
			throw e;
		} catch (ClientProtocolException e) {
			System.out.println("content "+ content );
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
			throw e;
		} catch (IOException e) {
			System.out.println("content "+ content );
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
			throw e;
		}
		 return response.toString();
		    
	}
	
	
}
