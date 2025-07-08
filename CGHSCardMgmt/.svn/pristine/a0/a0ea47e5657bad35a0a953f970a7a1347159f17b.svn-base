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
import java.util.ArrayList;
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
import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

@SuppressWarnings("deprecation")
public class SendSMSUtil {
	// Common Function to send SMS
	public void sendSMS(String mobile, String templateId, String message)  {
 
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_STATUS");

		if (smsService.equals("ENABLED")) {

			new Thread(new Runnable() {
				public void run() {
	

					String apiResponse = "";

					String logMessage = "";

					String logtype = "2";

					try {
						apiResponse = new SendSMSUtil().sendUnicodeSMS(templateId, message, mobile);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logtype = "1";
						logMessage = e.getMessage();
						apiResponse = null;

					} finally {
						if (logMessage.equals("") && (apiResponse == null || apiResponse.equals(""))) {
							logMessage = "Response retured in blank";
						} else if (apiResponse.contains("401")) {
							logtype = "1";
							logMessage = "401 Credentials Error, may be invalid username or password";
						} else if (apiResponse.contains("402")) {
							logtype = "2";
							logMessage = "402 Messages submitted successfully";
						} else if (apiResponse.contains("403")) {
							logtype = "1";
							logMessage = "403 Credits not available";
						} else if (apiResponse.contains("404")) {
							logtype = "1";
							logMessage = "404 Internal Database Error";
						} else if (apiResponse.contains("405")) {
							logtype = "1";
							logMessage = "405 Internal Networking Error";
						} else if (apiResponse.contains("406")) {
							logtype = "1";
							logMessage = "406 Invalid or Duplicate numbers";
						} else if (apiResponse.contains("407")) {
							logtype = "1";
							logMessage = "407 Network Error on SMSC";
						} else if (apiResponse.contains("408")) {
							logtype = "1";
							logMessage = "408 Network Error on SMSC";
						} else if (apiResponse.contains("409")) {
							logtype = "1";
							logMessage = "409 SMSC response timed out, message will be submitted";
						} else if (apiResponse.contains("410")) {
							logtype = "1";
							logMessage = "410 Internal Limit Exceeded, Contact support";
						} else if (apiResponse.contains("410")) {
							logtype = "1";
							logMessage = "410 Internal Limit Exceeded, Contact support";
						} else if (apiResponse.contains("411")) {
							logtype = "1";
							logMessage = "411 Sender ID not approved.";
						} else if (apiResponse.contains("412")) {
							logtype = "1";
							logMessage = "412 Sender ID not approved.";
						} else if (apiResponse.contains("413")) {
							logtype = "1";
							logMessage = "413 Suspect Spam, we do not accept these messages.";
						} else if (apiResponse.contains("414")) {
							logtype = "1";
							logMessage = "414 Rejected by various reasons by the operator such as DND, SPAM etc";
						}

						else if (apiResponse.contains("415")) {
							logtype = "1";
							logMessage = "415 Secure Key not available";
						} else if (apiResponse.contains("416")) {
							logtype = "1";
							logMessage = "416 Hash doesnâ€™t match";
						} else if (apiResponse.contains("418")) {
							logtype = "1";
							logMessage = "416  Daily Limit Exceeded";
						}

						JSONObject jsonForProcedure = new JSONObject();
						try {
							jsonForProcedure.put("mode", "UPDATE");
							// jsonForProcedure.put("id", id);
							// jsonForProcedure.put("crc32", crc);
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
	public void sendCGHLTHSMS(String mobile, String templateId, String message) {

		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_STATUS");
	//	System.out.println("cghlth SenderId");
		if (smsService.equals("ENABLED")) {

			new Thread(new Runnable() {
				public void run() {

					String apiResponse = "";

					String logMessage = "";

					String logtype = "2";

					try {
						apiResponse = new SendSMSUtil().sendCGHLTHUnicodeSMS(templateId, message, mobile);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						logtype = "1";
						logMessage = e.getMessage();
						apiResponse = null;

					} finally {
						if (logMessage.equals("") && (apiResponse == null || apiResponse.equals(""))) {
							logMessage = "Response retured in blank";
						} else if (apiResponse.contains("401")) {
							logtype = "1";
							logMessage = "401 Credentials Error, may be invalid username or password";
						} else if (apiResponse.contains("402")) {
							logtype = "2";
							logMessage = "402 Messages submitted successfully";
						} else if (apiResponse.contains("403")) {
							logtype = "1";
							logMessage = "403 Credits not available";
						} else if (apiResponse.contains("404")) {
							logtype = "1";
							logMessage = "404 Internal Database Error";
						} else if (apiResponse.contains("405")) {
							logtype = "1";
							logMessage = "405 Internal Networking Error";
						} else if (apiResponse.contains("406")) {
							logtype = "1";
							logMessage = "406 Invalid or Duplicate numbers";
						} else if (apiResponse.contains("407")) {
							logtype = "1";
							logMessage = "407 Network Error on SMSC";
						} else if (apiResponse.contains("408")) {
							logtype = "1";
							logMessage = "408 Network Error on SMSC";
						} else if (apiResponse.contains("409")) {
							logtype = "1";
							logMessage = "409 SMSC response timed out, message will be submitted";
						} else if (apiResponse.contains("410")) {
							logtype = "1";
							logMessage = "410 Internal Limit Exceeded, Contact support";
						} else if (apiResponse.contains("410")) {
							logtype = "1";
							logMessage = "410 Internal Limit Exceeded, Contact support";
						} else if (apiResponse.contains("411")) {
							logtype = "1";
							logMessage = "411 Sender ID not approved.";
						} else if (apiResponse.contains("412")) {
							logtype = "1";
							logMessage = "412 Sender ID not approved.";
						} else if (apiResponse.contains("413")) {
							logtype = "1";
							logMessage = "413 Suspect Spam, we do not accept these messages.";
						} else if (apiResponse.contains("414")) {
							logtype = "1";
							logMessage = "414 Rejected by various reasons by the operator such as DND, SPAM etc";
						}

						else if (apiResponse.contains("415")) {
							logtype = "1";
							logMessage = "415 Secure Key not available";
						} else if (apiResponse.contains("416")) {
							logtype = "1";
							logMessage = "416 Hash doesnâ€™t match";
						} else if (apiResponse.contains("418")) {
							logtype = "1";
							logMessage = "416  Daily Limit Exceeded";
						}

						JSONObject jsonForProcedure = new JSONObject();
						try {
							jsonForProcedure.put("mode", "UPDATE");
							// jsonForProcedure.put("id", id);
							// jsonForProcedure.put("crc32", crc);
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
 
	public static HttpClient verifiedClient(HttpClient base) {
		try {
			SSLContext ctx = SSLContext.getInstance("SSL");
			X509TrustManager tm = new X509TrustManager() {
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}

				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}
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

	public String sendUnicodeSMS(String templateId, String message, String mobileNumber) throws Exception {
 

		String username = "cghs";
		String password = "CGHS@123!@$";
		String senderId = "CGHSDL";
		String secureKey = "66496730-adcf-4590-8597-fa8fff37e886";
		String apiUrl = "https://msdgweb.mgov.gov.in/esms/sendsmsrequestDLT";
		//System.out.println("MESSAGE =>  "+ message);
		String finalmessage = "";
		message = message.trim();
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			int j = (int) ch;
			String sss = "&#" + j + ";";
			finalmessage = finalmessage + sss;
		}

		//System.out.println("final message >> " + finalmessage);

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
			encryptedPassword = sha1(password);
			String genratedhashKey = hashGenerator(username, senderId, finalmessage, secureKey);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("bulkmobno", mobileNumber));
			nameValuePairs.add(new BasicNameValuePair("senderid", senderId));
			nameValuePairs.add(new BasicNameValuePair("content", finalmessage));
			nameValuePairs.add(new BasicNameValuePair("templateid", templateId));
			nameValuePairs.add(new BasicNameValuePair("smsservicetype", "unicodemsg"));
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", encryptedPassword));
			nameValuePairs.add(new BasicNameValuePair("key", genratedhashKey));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = client.execute(post);
			//System.out.println("Resonse>>> " + response);
			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = bf.readLine()) != null) {
				responseString = responseString + line;
			}

		//	System.out.println("Response string " + responseString);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> NoSuchAlgorithmException==" + e.getMessage());
			throw e;
		} catch (KeyManagementException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> KeyManagementException==" + e.getMessage());
			throw e;
		} catch (UnsupportedEncodingException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
			throw e;
		} catch (ClientProtocolException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
			throw e;
		} catch (IOException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
			throw e;
		}
		return responseString;
	}
	public String sendCGHLTHUnicodeSMS(String templateId, String message, String mobileNumber) throws Exception {

		String username = "cghs";
		String password = "CGHS@123!@$";
		String senderId = "CGHLTH"; 
		String secureKey = "66496730-adcf-4590-8597-fa8fff37e886";
		String apiUrl = "https://msdgweb.mgov.gov.in/esms/sendsmsrequestDLT";
		//System.out.println("MESSAGE =>  " + message);
		String finalmessage = "";
		message = message.trim();
		for (int i = 0; i < message.length(); i++) {
			char ch = message.charAt(i);
			int j = (int) ch;
			String sss = "&#" + j + ";";
			finalmessage = finalmessage + sss;
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
			encryptedPassword = sha1(password);
			String genratedhashKey = hashGenerator(username, senderId, finalmessage, secureKey);
			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("bulkmobno", mobileNumber));
			nameValuePairs.add(new BasicNameValuePair("senderid", senderId));
			nameValuePairs.add(new BasicNameValuePair("content", finalmessage));
			nameValuePairs.add(new BasicNameValuePair("templateid", templateId));
			nameValuePairs.add(new BasicNameValuePair("smsservicetype", "unicodemsg"));
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", encryptedPassword));
			nameValuePairs.add(new BasicNameValuePair("key", genratedhashKey));
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = client.execute(post);
			//System.out.println("Resonse>>> " + response);
			BufferedReader bf = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line = "";
			while ((line = bf.readLine()) != null) {
				responseString = responseString + line;
			}

			//System.out.println("Response string " + responseString);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> NoSuchAlgorithmException==" + e.getMessage());
			throw e;
		} catch (KeyManagementException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> KeyManagementException==" + e.getMessage());
			throw e;
		} catch (UnsupportedEncodingException e) {
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
			throw e;
		} catch (ClientProtocolException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
			throw e;
		} catch (IOException e) {
			System.out.println("final message >> " + finalmessage);
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
			throw e;
		}
		return responseString;
	}

	public String sendSingleSMS(String message, String mobileNumber, boolean isUnicode, String templateId)
			throws Exception {

		// System.out.println("inside sendSingleSMS=====");

		String username = "";
		String password = "";
		String senderId = "";
		String secureKey = "";
		String apiUrl = "";

		try {

			username = HisUtil.getParameterFromHisPathXML("SMS_USERNAME");
			password = HisUtil.getParameterFromHisPathXML("SMS_PASSWORD");
			senderId = HisUtil.getParameterFromHisPathXML("SMS_SENDERID");
			secureKey = HisUtil.getParameterFromHisPathXML("SMS_SECUREKEY");
			apiUrl = HisUtil.getParameterFromHisPathXML("SMS_API_URL");

			// System.out.println("username==" + username);
			// System.out.println("password==" + password);
			// System.out.println("senderId==" + senderId);
			// System.out.println("apiUrl==" + apiUrl);
			/*
			 * System.out.println("mobileNumber==" + mobileNumber);
			 * System.out.println("isUnicode==" + isUnicode); System.out.println("message=="
			 * + message);
			 */

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

			// encryptedPassword = MD5(password);
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

			if (isUnicode)
				nameValuePairsNew.add(new BasicNameValuePair("smsservicetype", "unicodemsg"));
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
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> NoSuchAlgorithmException==" + e.getMessage());
			throw e;
		} catch (KeyManagementException e) {
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> KeyManagementException==" + e.getMessage());
			throw e;
		} catch (UnsupportedEncodingException e) {
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> UnsupportedEncodingException==" + e.getMessage());
			throw e;
		} catch (ClientProtocolException e) {
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> ClientProtocolException==" + e.getMessage());
			throw e;
		} catch (IOException e) {
			System.out.println("SendSMSUtil::sendSingleSMS>>>>> IOException==" + e.getMessage());
			throw e;
		}
//		System.out.println("SendSMSUtil::sendSingleSMS>>>>> responseString::" + responseString);
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
 
 

	public static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

	public static String getCRC32(String id) {
		byte[] data = id.getBytes();
		CRC32 fileCRC32 = new CRC32();
		fileCRC32.update(data);
		return String.format(Locale.US, "%08X", fileCRC32.getValue());
	}

	public JSONObject callDMLProcedure(String procedureName, JSONObject objInputJson) throws Exception {

		JSONObject objDataJson = null;
		HisDAO hisDao = null;
		String callString=null;
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

				hisDao.setProcInValue(procIndex, "inputJson", (objInputJson != null ? objInputJson.toString() : null));
				hisDao.setProcOutValue(procIndex, "p_ReturnValue", 1);
				hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1);
				hisDao.setProcOutValue(procIndex, "p_ErrCode", 1);

				 callString = "declare";
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
				//System.out.println(callString);
				objDataJson.put("calledqueryOrfunction", callString);

				long startTime = System.currentTimeMillis();

				hisDao.executeProcedure(procIndex);
				String returnValue = hisDao.getString(procIndex, "p_ReturnValue");
				String errMsg = hisDao.getString(procIndex, "p_ErrMsg");
				String errMsgCode = hisDao.getString(procIndex, "p_ErrCode");

				long endTime = System.currentTimeMillis();

				String Execution_time_in_milisec = (endTime - startTime) + "";
				objDataJson.put("Execution_time_in_milisec", Execution_time_in_milisec);
				objDataJson.put("errMsgCode", errMsgCode);
				objDataJson.put("message", errMsg);
				objDataJson.put("returnValue", returnValue);

			}

			// System.out.println("serviceName=="+serviceName+" query--" + fetchQuery);

		} catch (Exception e) {
			System.out.println(callString);
			e.printStackTrace();
			System.out.println("Exception in DataWebServiceDAO.callDMLProcedure--> " + e.getMessage());
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
		String Patient_Name = object.getString("pat_Name");
		String CR_No = object.getString("CR_No");
		String EpisodeCode = object.getString("episodeCode");
		String EpisodeVisitNo = object.getString("episodeVisitNo");
		String CurrentVisitDate = object.getString("currentVisitDate");
		String seatId = object.getString("seatId");
		String hosp_code = object.getString("hosp_code");

		String PatCompleteGeneralDtl = object.getString("PatCompleteGeneralDtl");
		final String mobileNumber = PatCompleteGeneralDtl.split("#")[14];
		String id = "";
		String crc = "";
		String logtype = "0";
		try {
			JSONObject objjson = new JSONObject();
			objjson.put("CrNo", CR_No);
			objjson.put("Patient_Name", Patient_Name);
			objjson.put("episodeCode", EpisodeCode);
			objjson.put("visitNo", EpisodeVisitNo);
			objjson.put("Entrydate", CurrentVisitDate);
			objjson.put("hosp_code", hosp_code);
			objjson.put("seatId", seatId);

			JSONObject jsonForProcedure = new JSONObject();
			jsonForProcedure.put("mode", "NEW");
			jsonForProcedure.put("hospitalCode", hosp_code);
			jsonForProcedure.put("patientdetaljson", objjson.toString());
			jsonForProcedure.put("mobilenumber", mobileNumber);
			jsonForProcedure.put("logtype", logtype);

			JSONObject resultJsonFromProcedure = callDMLProcedure("dml_sms_service_log_dtl", jsonForProcedure);
			id = resultJsonFromProcedure.getString("returnValue");
			System.out.println(id);
			crc = getCRC32(id);
			// System.out.println("crc====" + crc);
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
		return object.toString();

	}

}
