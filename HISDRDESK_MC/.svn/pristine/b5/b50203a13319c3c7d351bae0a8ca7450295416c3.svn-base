package HisWeb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.zip.CRC32;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import application.filters.Base64Utils;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class SendSMSUtil {
	public static void main(String arg[]) {
		
		String message="";
		String templateId= "";
		
		try {
			templateId= "1407169319789633992";
			message= "à¨¸à¨¿à¨¹à¨¤ à¨µà¨¿à¨­à¨¾à¨—, à¨ªà©°à¨œà¨¾à¨¬ AAC à¨µà¨¿à©±à¨š à¨†à¨‰à¨£ à¨²à¨ˆ à¨¤à©�à¨¹à¨¾à¨¡à¨¾ à¨§à©°à¨¨à¨µà¨¾à¨¦ à¨•à¨°à¨¦à¨¾ à¨¹à©ˆ, à¨¤à©�à¨¹à¨¾à¨¡à¨¾ CR à¨¨à©°à¨¬à¨° 860012300054345  à¨¹à©ˆ, à¨¤à©�à¨¸à©€à¨‚ à¨¡à¨¾à¨•à¨Ÿà¨° à¨¦à©�à¨†à¨°à¨¾ à¨¦à¨¿à©±à¨¤à©€ à¨—à¨ˆ à¨ªà¨°à¨šà©€ à¨¨à©‚à©° à¨¡à¨¾à¨Šà¨¨à¨²à©‹à¨¡ à¨•à¨°à¨¨ à¨²à¨ˆ à¨²à¨¿à©°à¨• 'à¨¤à©‡ à¨•à¨²à¨¿à©±à¨• à¨•à¨° à¨¸à¨•à¨¦à©‡ à¨¹à©‹à¥¤ hmispb.in/ST/su?key=82FC9745";
			
			
			 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String mobileNumber = "8130135196";// PatCompleteGeneralDtl.split("#")[14];
		
		//String mobileNumber = "9811399396";
		////System.out.println("message===" + message );
		boolean isUnicode=false;
		
		try {
			//System.out.println("response >> "+ new SendSMSUtil().sendUnicodeSMS(templateId, message, mobileNumber));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private static String todayDateAndTime() {
		Date now = new Date();

		// Define the desired date and time formats
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

		// Format the date and time
		String formattedDate = dateFormat.format(now);
		String formattedTime = timeFormat.format(now);
		//System.out.println("dateFormat " + formattedDate ) ;
		return formattedDate + "#" + formattedTime;

	}
	public void sendSMSToPatient(String JsonData)  throws JSONException {
		
		
			//System.out.println(" inside sendSMSToPatient ");
		  JSONObject object = new JSONObject(JsonData); 
		  final String CR_No= object.getString("CR_No");
		  final String hospName= object.getString("hospName");
		  String PatCompleteGeneralDtl=  object.getString("PatCompleteGeneralDtl");
		  final String mobileNumber=PatCompleteGeneralDtl.split("#")[14];
		  final String id=object.getString("idForCRC");
  	   	  final String crc=object.getString("crc");
  	   	  final	String url= object.getString("urlForQR");
		  

		  
  	   	  	String reffID = object.getString("referralId");

		   JSONArray DrugJsonArray = object.getJSONArray("DrugJsonArray"); 
		   //JSONArray EndorsmentDtl = object.getJSONArray("strEndorsmentDtl"); 

		  JSONObject json = new JSONObject();
			//if (object.has("referralId")) {
		  if (object.has("referralId") && reffID!=null && reffID !="" && reffID.length()  > 0 ) {
			//	System.out.println("referal Id present");
			//	System.out.println("ReferralId exists: " + object.getString("referralId"));

				String[] mobileNumbers = { mobileNumber };
				json.put("mobileNumbers", mobileNumbers);
				json.put("templateId", "1107174479983719799");
				String message;
				
		/*		if (object.has("strEndorsmentDtl") && EndorsmentDtl!=null  && EndorsmentDtl.length()  > 0 ) {
					System.out.println( "endorement present");
					message = "Sir/Madam, Referral ID {#var#} has been generated for Ben ID {#var#} on {#var#} in WC- {#var#} . "
							+ "In case the above referral has not been requested by you, kindly alert the CMO I/C of the "
							+ "Wellness Centre immediately using contact details given in cghs.mohfw.gov.in or myCGHS"
							+ " mobile app available for Android and iOS devices -CGHS";
					
						String var = todayDateAndTime();
						json.put("message", message);
						String[] data = { reffID +" (Endorsment)",CR_No,var.split("#")[0] ,hospName};
						json.put("data", data);
					
				}else {*/
					//System.out.println( "endorement not present");
				message = "Sir/Madam, Referral ID {#var#} has been generated for Ben ID {#var#} on {#var#} in WC- {#var#} . "
						+ "In case the above referral has not been requested by you, kindly alert the CMO I/C of the "
						+ "Wellness Centre immediately using contact details given in cghs.mohfw.gov.in or myCGHS"
						+ " mobile app available for Android and iOS devices -CGHS";
				
					String var = todayDateAndTime();
					json.put("message", message);
					String[] data = { reffID,CR_No,var.split("#")[0] ,hospName};
					json.put("data", data);
			/* } */

				
	            
	            new SMSClient().SendSMSClient(json.toString());
	            
	        }
		  
		  if (DrugJsonArray != null && DrugJsonArray.length() > 0) {
	        	//System.out.println("referal Id not present");
				String[] mobileNumbers = { mobileNumber };
				json.put("mobileNumbers", mobileNumbers);
				json.put("templateId", "1107174359018055896");

				String message = "Sir/Madam, Medicines have been prescribed on {#var#} for Ben Id {#var#} in WC- {#var#} ."
						+ " In case the above issue/indent has not been requested by you, kindly alert the CMO I/C of the"
						+ " Wellness Centre immediately - using contact details given in 'Contact Us' tab in  "
						+ " cghs.mohfw.gov.in -CGHS";


				json.put("message", message);
				String var = todayDateAndTime();
				String[] data = { var.split("#")[0],CR_No, hospName };
				json.put("data", data);
				new SMSClient().SendSMSClient(json.toString());
				
	            
	        }
			
	        
	       
  	   	  
		
	}
	

	public static HttpClient verifiedClient(HttpClient base) {  
	    try {  
	        SSLContext ctx = SSLContext.getInstance("SSL");  
	        X509TrustManager tm = new X509TrustManager() {
	            public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
	                return null;  
	            }  
	            @Override  
	            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	            @Override  
	            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}  
	        };

	        ctx.init(null, new TrustManager[] { tm }, null); 
	        SSLSocketFactory ssf = new SSLSocketFactory(ctx, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); 
	        ClientConnectionManager mgr = base.getConnectionManager();
	        SchemeRegistry registry = mgr.getSchemeRegistry(); 
	        registry.register(new Scheme("https", 443, ssf)); 
	        return new DefaultHttpClient(mgr, base.getParams());  
	    } catch (Exception ex) {  
	        ex.printStackTrace();  
	        
	        return null;  
	    }  
	}  
	
	
	public String sendUnicodeSMS( String templateId , String message , String mobileNumber) throws Exception{
		
			String username="dogrpunjab-nhm";
			String password="ITcellnhm@38";
			String senderId="PBGOVT"; 		
			String secureKey="259ba52f-0bd1-4cfd-8efe-e6c025d92432";
			String apiUrl="https://msdgweb.mgov.gov.in/esms/sendsmsrequestDLT";
			
		
			String finalmessage = "";
			message = message.trim();
			for(int i = 0 ; i< message.length();i++){
			char ch = message.charAt(i);
			int j = (int) ch;
			String sss = "&#"+j+";";
			finalmessage = finalmessage+sss;
			}
			
			
			////System.out.println("final message >> "+finalmessage);
			
			String responseString = ""; SSLSocketFactory sf=null; 
			SSLContext context=null;
			String encryptedPassword;
			try {
				context=SSLContext.getInstance("TLSv1.2");
				context.init(null, null, null);
				sf=new SSLSocketFactory(context,
				SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
				Scheme scheme=new Scheme("https",443,sf);
				HttpClient client=new DefaultHttpClient();
				client.getConnectionManager().getSchemeRegistry().register(scheme);
				client = verifiedClient(client);
				HttpPost post=new
				HttpPost(apiUrl);
				encryptedPassword = sha1(password);
				String genratedhashKey = hashGenerator(username, senderId,finalmessage, secureKey);
				List<NameValuePair> nameValuePairs=new ArrayList<NameValuePair>(1);
				nameValuePairs.add(new BasicNameValuePair("bulkmobno",mobileNumber));
				nameValuePairs.add(new BasicNameValuePair("senderid",senderId));
				nameValuePairs.add(new BasicNameValuePair("content",finalmessage));
				nameValuePairs.add(new BasicNameValuePair("templateid", templateId));;
				nameValuePairs.add(new BasicNameValuePair("smsservicetype","unicodemsg"));
				nameValuePairs.add(new BasicNameValuePair("username",username));
				nameValuePairs.add(new BasicNameValuePair("password",encryptedPassword));
				nameValuePairs.add(new BasicNameValuePair("key",genratedhashKey));
				post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
				HttpResponse response=client.execute(post);
				BufferedReader bf=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line=""; while((line=bf.readLine())!=null){
					responseString = responseString+line;
				}
				////System.out.println(responseString);
			} catch (NoSuchAlgorithmException e) {
				//System.out.println("SendSMSUtil::sendSingleSMS>>>>> NoSuchAlgorithmException==" + e.getMessage());
				throw e;
			} catch (KeyManagementException e) {
				//System.out.println("SendSMSUtil::sendSingleSMS>>>>> KeyManagementException==" + e.getMessage());
				throw e;
			} catch (UnsupportedEncodingException e) {
				//System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
				throw e;
			} catch (ClientProtocolException e) {
				//System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
				throw e;
			} catch (IOException e) {
				//System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
				throw e;
			}
				return responseString;
			}
	
	
	public String sendSingleSMS(String message, String mobileNumber, boolean isUnicode,String templateId) throws Exception {
		
		////System.out.println("inside sendSingleSMS=====");
		
	
		
		String username="";
		String password="";		
		String senderId="";
		String secureKey="";
		String apiUrl="";
		
		try {
			
			
			username = HisUtil.getParameterFromHisPathXML("SMS_USERNAME");
			password= HisUtil.getParameterFromHisPathXML("SMS_PASSWORD");
			senderId= HisUtil.getParameterFromHisPathXML("SMS_SENDERID");
			secureKey= HisUtil.getParameterFromHisPathXML("SMS_SECUREKEY");
			apiUrl = HisUtil.getParameterFromHisPathXML("SMS_API_URL");
			
			////System.out.println("username==" + username);
			////System.out.println("password==" + password);
			////System.out.println("senderId==" + senderId);
			////System.out.println("apiUrl==" + apiUrl);
			//System.out.println("mobileNumber==" + mobileNumber);
			//System.out.println("isUnicode==" + isUnicode);
			//System.out.println("message==" + message);
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			throw e1;
		}
	
		String responseString = "";
		SSLSocketFactory sf = null;
		SSLContext context = null;
		String encryptedPassword;
		try {
			context = SSLContext.getInstance("TLSv1.2");
			context.init(null, null, null);
			sf = new SSLSocketFactory(context, SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
			Scheme scheme = new Scheme("https", 443, sf);
			HttpClient client = new DefaultHttpClient();
			client.getConnectionManager().getSchemeRegistry().register(scheme);
			
			client = verifiedClient(client);
			
			HttpPost post = new HttpPost(apiUrl);
			 
			//encryptedPassword = MD5(password);
			encryptedPassword = sha1(password);
			//System.out.println("encryptedPassword===" + encryptedPassword);
			message = message.trim();
			String genratedhashKey = hashGenerator(username, senderId, message, secureKey);
			// List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

			List<NameValuePair> nameValuePairsNew = new ArrayList<NameValuePair>(1);
			nameValuePairsNew.add(new BasicNameValuePair("mobileno", mobileNumber));
			nameValuePairsNew.add(new BasicNameValuePair("senderid", senderId));
			nameValuePairsNew.add(new BasicNameValuePair("templateid", templateId));
			
			nameValuePairsNew.add(new BasicNameValuePair("content", message));
			
			if(isUnicode)
				nameValuePairsNew.add(new BasicNameValuePair("smsservicetype","unicodemsg"));
			else	
				nameValuePairsNew.add(new BasicNameValuePair("smsservicetype", "singlemsg"));
			
			nameValuePairsNew.add(new BasicNameValuePair("username", username));
			nameValuePairsNew.add(new BasicNameValuePair("password", encryptedPassword));
			nameValuePairsNew.add(new BasicNameValuePair("key", genratedhashKey));

			post.setEntity(new UrlEncodedFormEntity(nameValuePairsNew));
			HttpResponse response = client.execute(post);
			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = bf.readLine()) != null) {
				responseString = responseString + line;
			}
			//System.out.println(responseString);
		} catch (NoSuchAlgorithmException e) {
			//System.out.println("SendSMSUtil::sendSingleSMS>>>>> NoSuchAlgorithmException==" + e.getMessage());
			throw e;
		} catch (KeyManagementException e) {
			//System.out.println("SendSMSUtil::sendSingleSMS>>>>> KeyManagementException==" + e.getMessage());
			throw e;
		} catch (UnsupportedEncodingException e) {
			//System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
			throw e;
		} catch (ClientProtocolException e) {
			//System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
			throw e;
		} catch (IOException e) {
			//System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
			throw e;
		}
//		//System.out.println("SendSMSUtil::sendSingleSMS>>>>> responseString::" + responseString);
		return responseString;
	}

	
	
	
	protected String hashGenerator(String userName, String senderId, String content, String secureKey) {
		// TODO Auto-generated method stub
		StringBuffer finalString = new StringBuffer();
		finalString.append(userName.trim()).append(senderId.trim()).append(content.trim()).append(secureKey.trim());
		String hashGen = finalString.toString();
		StringBuffer sb = new StringBuffer();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-512");
			md.update(hashGen.getBytes());
			byte byteData[] = md.digest();
			// convert the byte to hex format method 1 sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
		return sb.toString();
	}

	private static String MD5(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md;
		md = MessageDigest.getInstance("SHA-1");
		byte[] md5 = new byte[64];
		md.update(text.getBytes("iso-8859-1"), 0, text.length());
		md5 = md.digest();

		return convertedToHex(md5);
	}

	private static String convertedToHex(byte[] data) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) {
			int halfOfByte = (data[i] >>> 4) & 0x0F;
			int twoHalfBytes = 0;
			do {
				if ((0 <= halfOfByte) && (halfOfByte <= 9)) {
				} else {
				}
				buf.append((char) ('0' + halfOfByte));
				buf.append((char) ('a' + (halfOfByte - 10)));
				halfOfByte = data[i] & 0x0F;
			} while (twoHalfBytes++ < 1);
		}
		return buf.toString();
	}
	public static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
					.substring(1));
		}

		return sb.toString();
	}

	public static String getCRC32(String id){
		byte[] data=id.getBytes();
        CRC32 fileCRC32 = new CRC32();
        fileCRC32.update(data);
        return String.format(Locale.US,"%08X", fileCRC32.getValue());
    }
	
	
	public JSONObject callDMLProcedure(String procedureName, JSONObject objInputJson) throws Exception {
		
		
		JSONObject objDataJson = null;
		HisDAO hisDao = null;

		try {
			hisDao = new HisDAO("SendSMSUtil", procedureName);
			if (objInputJson != null) {
				if (objInputJson != null && objInputJson.length() > 0) {
					objDataJson = new JSONObject(objInputJson.toString());
					;
				} else {
					objDataJson = new JSONObject();
				}
				
				int procIndex = hisDao.setProcedure("{call " + procedureName + "(?,?,?,?)}");
				
				hisDao.setProcInValue(procIndex, "inputJson", (objInputJson != null ? objInputJson.toString() : null),1);
				hisDao.setProcOutValue(procIndex, "p_ReturnValue", 1,2);
				hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1,3);
				hisDao.setProcOutValue(procIndex, "p_ErrCode", 1,4);
				

				String callString = "declare";
				callString += "\n p_ReturnValue character varying;";
				callString += "\n p_ErrMsg character varying;";
				callString += "\n p_ErrCode character varying;";
				callString += "\n begin";
				callString += "\n" + procedureName + "(";

				callString += "'" + objInputJson.toString() + "',";
				
				callString += "p_ReturnValue,";
				callString += "p_ErrMsg,";
				callString += "p_ErrCode);";

				callString += "\ndbms_output.put_line('p_ErrMsg--' || p_ErrMsg);";
				callString += "\ndbms_output.put_line('p_ErrCode--' || p_ErrCode);";
				callString += "\n end;";
				System.out.println(callString);
				objDataJson.put("calledqueryOrfunction", callString);

				long startTime = System.currentTimeMillis();
				
				
				hisDao.executeProcedureByPosition(procIndex);
				String returnValue = hisDao.getString(procIndex, "p_ReturnValue");
				String errMsg  = hisDao.getString(procIndex, "p_ErrMsg");
				String errMsgCode  = hisDao.getString(procIndex, "p_ErrCode");

				
				long endTime = System.currentTimeMillis();

				String Execution_time_in_milisec = (endTime - startTime) + "";
				objDataJson.put("Execution_time_in_milisec", Execution_time_in_milisec);
				objDataJson.put("errMsgCode", errMsgCode);
				objDataJson.put("message", errMsg);
				objDataJson.put("returnValue", returnValue);
				

			}

			// //System.out.println("serviceName=="+serviceName+" query--" + fetchQuery);

		} catch (Exception e) {
			e.printStackTrace();			
			//System.out.println("Exception in DataWebServiceDAO.callDMLProcedure--> "+ e.getMessage());
		} finally {

			if (hisDao != null) {
				hisDao.free();
				hisDao = null;
			}

		}

		return objDataJson;

	}
	
	public String generateCRC(String JsonData) throws JSONException {

		JSONObject object = new JSONObject(JsonData);
		//String Patient_Name = object.getString("pat_Name");
		String CR_No = object.getString("CR_No");
		String EpisodeCode = object.getString("episodeCode");
		String EpisodeVisitNo = object.getString("episodeVisitNo");
		//String CurrentVisitDate = object.getString("currentVisitDate");
		//String seatId = object.getString("seatId");
		String hosp_code = object.getString("hosp_code");

		//String PatCompleteGeneralDtl = object.getString("PatCompleteGeneralDtl");
	//	final String mobileNumber = PatCompleteGeneralDtl.split("#")[14];
		String id = "";
		String crc = "";
		
		try {
			id=CR_No+EpisodeCode+EpisodeVisitNo+hosp_code;
			//System.out.println("id>>>>" +id);
			crc = getCRC32(id);
			System.out.println("crc====" + crc);
			object.put("crc", crc);
			object.put("idForCRC", id);
			String url = HisUtil.getParameterFromHisPathXML("SMS_OPD_URL_IN_TEXT") + "key=" + crc;
			object.put("urlForQR", url);
			object.put("message", "");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("SendSMSUtil::generateCRC>>>>> Exception==" + e.getMessage());
			object.put("message", "ERROR");
		}
		//System.out.println("object.toString()>>" +object.toString());
		return object.toString();

	}

	public void sendSMSToPatientForInvestigationReport(String CRNo,String hosp_code, String JsonData, String location,String mobileNumber  )  throws JSONException {
		 
		
		  JSONObject object = new JSONObject(JsonData); 
		  
			String smsService= HisUtil.getParameterFromHisPathXML("SMS_SERVICE_STATUS_FOR_INVESTIGATION_REPORT_WIN");
			if(smsService ==null && !smsService.equals("ENABLED")) {
				//System.out.println("SendSMSUtil::sendSMSToPatient>>>>>SMS SERVICE IS DISBALED" );
				return;
			}
			
			  
			new Thread( new Runnable() {
		           public void run(){
		        	   
		        	  String id="";
		 			  String crc="";
		 	    	  String logtype="0";
		 	    	  String url="";
		 			  try {
		 				 	JSONObject jsonForProcedure= new JSONObject();
		 		  			jsonForProcedure.put("mode", "NEW");
		 		  			jsonForProcedure.put("hospitalCode", hosp_code);
		 		  			jsonForProcedure.put("patientdetaljson", JsonData);
		 		  			jsonForProcedure.put("mobilenumber", mobileNumber);
		 		  			jsonForProcedure.put("logtype", logtype);
		 				  			
		 				  	JSONObject resultJsonFromProcedure= callDMLProcedure("dml_sms_service_log_dtl", jsonForProcedure);
		 	  				id=resultJsonFromProcedure.getString("returnValue");
		 			  		//System.out.println(id);
		 			  		crc=getCRC32(id);
		 			  		//System.out.println("crc====" + crc);
		 			  		object.put("crc", crc);
		 			  		object.put("idForCRC", id);
		 				  	url=HisUtil.getParameterFromHisPathXML("SMS_OPD_URL_IN_TEXT")+ "key="+crc;
		 				  	object.put("urlForQR", url);
		 				  	object.put("message","");
		 			  } catch (Exception e) {
		 			  		e.printStackTrace();
		 			   		//System.out.println("SendSMSUtil::generateCRC>>>>> Exception==" + e.getMessage());		 			   		
		 			   }
		 			
		        	   
		        	   String message="";
		        	   String  templateId= "1407170202403851135";
		        	   
		        	   String apiResponse="";
		        	  
		        	   String logMessage="";
		        	   
		        	    logtype="2";
		        	   try {
		        		   //System.out.println("url===" +url);
		   				   message="à¨¸à¨¿à¨¹à¨¤ à¨µà¨¿à¨­à¨¾à¨— à¨ªà©°à¨œà¨¾à¨¬ à¨¸à¨¿à¨µà¨² à¨¹à¨¸à¨ªà¨¤à¨¾à¨² "+location+" à¨†à¨‰à¨£ à¨²à¨ˆ à¨¤à©�à¨¹à¨¾à¨¡à¨¾ à¨§à©°à¨¨à¨µà¨¾à¨¦ à¨•à¨°à¨¦à¨¾ à¨¹à©ˆ, à¨¤à©�à¨¹à¨¾à¨¡à¨¾ CR à¨¨à©°à¨¬à¨°   "+CRNo+"  à¨¹à©ˆ, à¨¤à©�à¨¸à©€à¨‚ à¨¦à¨¿à©±à¨¤à©‡ à¨²à¨¿à©°à¨• 'à¨¤à©‡ à¨•à¨²à¨¿à©±à¨• à¨•à¨°à¨•à©‡ à¨†à¨ªà¨£à©€à¨†à¨‚ à¨Ÿà©ˆà¨¸à¨Ÿ à¨°à¨¿à¨ªà©‹à¨°à¨Ÿà¨¾à¨‚ à¨¡à¨¾à¨Šà¨¨à¨²à©‹à¨¡ à¨•à¨° à¨¸à¨•à¨¦à©‡ à¨¹à©‹à¥¤ "+url;
		   				   //System.out.println("message=====" + message);
		   			} catch (Exception e) {
		   				// TODO Auto-generated catch block
		   				e.printStackTrace();
		   				//System.out.println("SendSMSUtil::sendSMSToPatient>>>>>Inside Runnable() Exception==" + e.getMessage());
		   				logtype="1";
		   				logMessage=e.getMessage();
		   			}

		        	 try {
			        	  if(!logtype.equals("1")) {// if no error existin in above code
			        		  apiResponse=new SendSMSUtil().sendUnicodeSMS(templateId, message, mobileNumber);
			        		  logtype="2";
			        	  }
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logMessage=e.getMessage();
						apiResponse=null;
						
					}
		        	 finally {
		        		 if(logMessage.equals("")&&( apiResponse==null || apiResponse.equals(""))) {
		        			 logMessage="Response retured in blank";
		        		 }
		        		 else if(apiResponse.contains("401")) {
		        				 logtype="1";
		        				 logMessage="401 Credentials Error, may be invalid username or password";
		        			 }
		        			 else if(apiResponse.contains("402")) {
		        				 logtype="2";
		        				 logMessage="402 Messages submitted successfully";
		        			 }
		        			 else if(apiResponse.contains("403")) {
		        				 logtype="1";
		        				 logMessage="403 Credits not available";
		        			 }
		        			 else if(apiResponse.contains("404")) {
		        				 logtype="1";
		        				 logMessage="404 Internal Database Error";
		        			 }
		        			 else if(apiResponse.contains("405")) {
		        				 logtype="1";
		        				 logMessage="405 Internal Networking Error";
		        			 }
		        			 else if(apiResponse.contains("406")) {
		        				 logtype="1";
		        				 logMessage="406 Invalid or Duplicate numbers";
		        			 }
		        			 else if(apiResponse.contains("407")) {
		        				 logtype="1";
		        				 logMessage="407 Network Error on SMSC";
		        			 }
		        			 else if(apiResponse.contains("408")) {
		        				 logtype="1";
		        				 logMessage="408 Network Error on SMSC";
		        			 }
		        			 else if(apiResponse.contains("409")) {
		        				 logtype="1";
		        				 logMessage="409 SMSC response timed out, message will be submitted";
		        			 }
		        			 else if(apiResponse.contains("410")) {
		        				 logtype="1";
		        				 logMessage="410 Internal Limit Exceeded, Contact support";
		        			 }
		        			 else if(apiResponse.contains("410")) {
		        				 logtype="1";
		        				 logMessage="410 Internal Limit Exceeded, Contact support";
		        			 }
		        			 else if(apiResponse.contains("411")) {
		        				 logtype="1";
		        				 logMessage="411 Sender ID not approved.";
		        			 }
		        			 else if(apiResponse.contains("412")) {
		        				 logtype="1";
		        				 logMessage="412 Sender ID not approved.";
		        			 }
		        			 else if(apiResponse.contains("413")) {
		        				 logtype="1";
		        				 logMessage="413 Suspect Spam, we do not accept these messages.";
		        			 }
		        			 else if(apiResponse.contains("414")) {
		        				 logtype="1";
		        				 logMessage="414 Rejected by various reasons by the operator such as DND, SPAM etc";
		        			 }

		        			 else if(apiResponse.contains("415")) {
		        				 logtype="1";
		        				 logMessage="415 Secure Key not available";
		        			 }
		        			 else if(apiResponse.contains("416")) {
		        				 logtype="1";
		        				 logMessage="416 Hash doesnâ€™t match";
		        			 }
		        			 else if(apiResponse.contains("418")) {
		        				 logtype="1";
		        				 logMessage="416  Daily Limit Exceeded";
		        			 }
		        		 
		        		JSONObject jsonForProcedure= new JSONObject();
				  		try {
							jsonForProcedure.put("mode", "UPDATE");
							jsonForProcedure.put("id", id);
				  			jsonForProcedure.put("crc32", crc);
				  			jsonForProcedure.put("message", message);
				  			jsonForProcedure.put("log_msg", logMessage);
				  			jsonForProcedure.put("templateid", templateId);
				  			jsonForProcedure.put("logtype", logtype);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  			
				  			
				  			
				  			try {
								callDMLProcedure("dml_sms_service_log_dtl", jsonForProcedure);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		        	 }
		        	   return; // to stop the thread
	                }
	         }).start();	
		 
	}
	
	
	
	
}
