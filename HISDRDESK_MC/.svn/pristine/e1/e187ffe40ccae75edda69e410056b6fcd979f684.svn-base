package HisWeb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import HisWeb.dao.opdDrDeskDao;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class opdDrDeskUtil {
	public static final int SMS_SENT_SUCCESSFULLY = 1;
	public static final int ERROR_NO_NUMBER = 2;
	public static final int ERROR_SMS_SENT = 3;
	public static final int ERROR_NO_STORE = 4;
	public static final int ERROR_NO_MESSAGE = 5;
	public static final int SMS_SERVICE_DOWN = 6;
	public static final int SMS_FAILED = 7;

	public static boolean SaveDrDesk(String JsonData) throws JSONException, ParseException {

		boolean flag=false;
		
		HisDAO dao = null;
		
		
		try {
			
			JSONObject object = new JSONObject(JsonData);
			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			opdDrDeskDao.deletePreviousDataData(JsonData , dao);
			
			opdDrDeskDao.SaveDrugAdviceData(JsonData , dao);
			opdDrDeskDao.drugFinalSaveDtl( JsonData,  dao);
			opdDrDeskDao.SaveInvData(JsonData , dao);
			 
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
				
			opdDrDeskDao.SaveGenralData(JsonData , dao);
			//opdDrDeskDao.SaveVisitReasonData(JsonData , dao);
			//opdDrDeskDao.FollowUpDTL(JsonData , dao);
			opdDrDeskDao.SaveFollowUpVisitReasonData(JsonData , dao);
			 opdDrDeskDao.SaveEHRData(JsonData , dao);

			opdDrDeskDao.saveProcdureData(JsonData , dao);
			// System.out.println("PatCompleteGeneralDtl.split('0')[18]"+PatCompleteGeneralDtl.split("#")[18]);
			if (PatCompleteGeneralDtl.split("#")[18].equals("1")) {
				opdDrDeskDao.SaveEConsultancyData(JsonData , dao);
			}
			// System.out.println(":::::::::::::::"+((JSONArray)
			// object.get("strReferal")).length());
			if (((JSONArray) object.get("strReferal")).length() > 0) {
				opdDrDeskDao.saveReferPatientDetails(JsonData , dao);
			}
			
			int lenstrEndorsmentDtl=0;
			int lenexternalConsultantReferalDtl=0;
			int lenexternalInvestigationReferalDtl=0;
			int lenexternalProcedureReferalDtl=0;
			int lenexternalFollowupReferalDtl=0;
			if(object.has("strEndorsmentDtl") && object.getJSONArray("strEndorsmentDtl").length()>0) {
				lenstrEndorsmentDtl=object.getJSONArray("strEndorsmentDtl").length();
			}
			else {
				object.remove("strEndorsmentDtl");
			}
			if(object.has("externalConsultantReferalDtl") && object.getJSONArray("externalConsultantReferalDtl").length()>0) {
				lenexternalConsultantReferalDtl=object.getJSONArray("externalConsultantReferalDtl").length();
			}
			if(object.has("externalInvestigationReferalDtl") && object.getJSONArray("externalInvestigationReferalDtl").length()>0) {
				lenexternalInvestigationReferalDtl=object.getJSONArray("externalInvestigationReferalDtl").length();
			}
			if(object.has("externalProcedureReferalDtl") && object.getJSONArray("externalProcedureReferalDtl").length()>0) {
				lenexternalProcedureReferalDtl=object.getJSONArray("externalProcedureReferalDtl").length();
			}
			if(object.has("externalFollowupReferalDtl") && object.getJSONArray("externalFollowupReferalDtl").length()>0) {
				lenstrEndorsmentDtl=object.getJSONArray("externalFollowupReferalDtl").length();
			}
			
			if(lenexternalConsultantReferalDtl>0 || lenexternalInvestigationReferalDtl>0 
					|| lenexternalProcedureReferalDtl>0 || lenexternalFollowupReferalDtl>0) {
				opdDrDeskDao.saveExternalRefferral(object.toString() , dao);
			}
			

			// System.out.println(":::::::::::::::"+((JSONArray)
			// object.get("strReferal")).length());
			if (((JSONArray) object.get("strDrugAllergy")).length() > 0) {
				opdDrDeskDao.SaveAllergyData(JsonData , dao);
			}

			if (((JSONArray) object.get("strChronicDisease")).length() > 0) {
				opdDrDeskDao.SaveChronicData(JsonData , dao);
			}

			opdDrDeskDao.SaveHistoryOfPresentIllNess(JsonData , dao);

			opdDrDeskDao.SaveCompleteHistoryData(JsonData , dao);

			opdDrDeskDao.SaveExamniationData(JsonData , dao);

			//opdDrDeskDao.saveClinicalProcedure(JsonData , dao);
			
		 
			
			dao.fire();
			flag=true;
			
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}finally {
			
			if(dao != null) {
				dao.free();
				dao = null;
			}
			
		}
		
		return flag;
		

	}

	public static void referPatient(String JsonData) throws JSONException, ParseException {
		// opdDrDeskDao.saveReferPatientDetails(JsonData);
	}

	public static String saveVitalData(String JsonData) throws JSONException, ParseException {

		String RetValue = opdDrDeskDao.SaveVitalData(JsonData);
		String RetValue1 = opdDrDeskDao.SaveEMRVitalData(JsonData);
		return RetValue;
	}

	public static String savePrescriptionProfileData(String JsonData) throws JSONException, ParseException {

		String RetValue = opdDrDeskDao.savePrecriptionProfileData(JsonData);
		// String RetValue1=opdDrDeskDao.SaveEMRVitalData(JsonData);
		return RetValue;
	}

	public static String getModifyVitalData(String JsonData) throws JSONException, ParseException {

		String RetValue = opdDrDeskDao.getModifyVitalData(JsonData);
		return RetValue;
	}

	public static void SaveDrDeskFormattedData(String jsonData) throws JSONException {
		JSONObject object = new JSONObject(jsonData);
		JSONObject js = new JSONObject(jsonData);
		String deptflg = object.getString("strDeptIdflg");
		String AllDeptFgl = object.getString("strAllDeptIdflg");
		String strPresCriptionBookmarkNameval = object.getString("strPresCriptionBookmarkNameval");

		js.remove("Patient_Name");
		js.remove("CR_No");
		js.remove("EpisodeCode");
		js.remove("EpisodeVisitNo");
		js.remove("CurrentVisitDate");
		js.remove("PatVisitType");
		js.remove("LastVisitDate");
		// js.remove("PatientGender");
		// js.remove("PatientAge");

		js.remove("PatientCat");
		js.remove("PatientQueueNo");
		js.remove("hrgnum_is_docuploaded");
		js.remove("patGaurdianName");

		/* System.out.println("After Remove All Data"); */
		// System.out.println(js.toString());

		opdDrDeskDao.SaveGenralDataFormattedData(jsonData);
		if (deptflg.equals("1"))
			opdDrDeskDao.SavePrescriptionBookMarkData(js.toString());

	}

	public static void SaveDrDeskFormattedData1(String jsonData, String DeptUnitName) throws JSONException {
		JSONObject object = new JSONObject(jsonData);
		JSONObject js = new JSONObject(jsonData);
		String deptflg = object.getString("strDeptIdflg");
		String AllDeptFgl = object.getString("strAllDeptIdflg");
		String strPresCriptionBookmarkNameval = object.getString("strPresCriptionBookmarkNameval");

		js.remove("Patient_Name");
		js.remove("CR_No");
		js.remove("EpisodeCode");
		js.remove("EpisodeVisitNo");
		js.remove("CurrentVisitDate");
		js.remove("PatVisitType");
		js.remove("LastVisitDate");
		// js.remove("PatientGender");
		// js.remove("PatientAge");

		js.remove("PatientCat");
		js.remove("PatientQueueNo");
		js.remove("hrgnum_is_docuploaded");
		js.remove("patGaurdianName");

		/* System.out.println("After Remove All Data"); */
		// System.out.println(js.toString());

		opdDrDeskDao.SavePrescriptionBookMarkDataFromPB(js.toString(), DeptUnitName);

	}

	public static String saveOfflinePatCountDtl(String JsonData) throws JSONException, ParseException {

		String RetValue = opdDrDeskDao.saveOfflinePatCountDtl(JsonData);
		return RetValue;
	}

	
	

	
	public static int sendSMSToPatient() {
		/*
		 * JSONObject object= new JSONObject(); String Patient_Name=
		 * object.getString("Patient_Name"); String CR_No= object.getString("CR_No");
		 * String EpisodeCode= object.getString("EpisodeCode"); String EpisodeVisitNo=
		 * object.getString("EpisodeVisitNo"); String PatCompleteGeneralDtl=
		 * object.getString("PatCompleteGeneralDtl");
		 */

		String mobileNumber = "8130135196";// PatCompleteGeneralDtl.split("#")[14];
		String url = "https://msdgweb.mgov.gov.in/esms/sendsmsrequest";
		String message = "OTP for station allotment is 1234, NHM, DHFW Punjab.";
		String senderId = "PBGOVT";
		String secureKey = "259ba52f-0bd1-4cfd-8efe-e6c025d92432";

		// message=message.replace("#CRNO#", CR_No);
		// message=message.replace("#LINK#", "https://hmispb.in/");

		HttpURLConnection conn = null;
		try {
			if (mobileNumber == null || mobileNumber.equals(""))
				return ERROR_NO_NUMBER;
			if (message == null || message.isEmpty())
				return ERROR_NO_MESSAGE;

			String serviceFLag = "1";// 1-Up,0-Down
			String tlsVersion = "TLSv1.2";
			message = message.replaceAll(" ", "%20");

			String urlWithParam = url + "?ver=" + tlsVersion + "&key=" + secureKey + "&dest=" + mobileNumber + "&send="
					+ senderId + "&text=" + message;

			//System.out.println(urlWithParam);

			URL urls = new URL(urlWithParam);
			//// System.out.println(urls);

			if (serviceFLag != null && serviceFLag.equals("1")) {
				conn = (HttpURLConnection) urls.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "text/plain;charset=ISO-8859-1");
				if (conn.getResponseCode() != 200) {
					throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseMessage());
				}
			} else
				return SMS_SERVICE_DOWN;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				conn.disconnect();
		}
		return SMS_SENT_SUCCESSFULLY;
	}

	public static void syncPrescriptionToABHA(String jsonData) throws JSONException {
		final JSONObject js = new JSONObject(jsonData);
		JSONObject jsonforABHA = new JSONObject(); 
		String currentVisitDate=js.getString("currentVisitDate");
		
		
		
	     SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
	        Date visitdateDate = null;
	        try{ 
	            visitdateDate = parser.parse(currentVisitDate);
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	      
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	        String   visitdate = formatter.format(visitdateDate);

		
		//System.out.println("visitdate-----" + visitdate);
		 
		
	    jsonforABHA.put("cr_no", js.getString("CR_No"));
	    jsonforABHA.put("hospital_code", js.getString("hosp_code"));
	    jsonforABHA.put("episode_code", js.getString("episodeCode"));
	    jsonforABHA.put("visit_no", js.getString("episodeVisitNo"));		      
	    jsonforABHA.put("admission_no", "0");
	    jsonforABHA.put("visit_date", visitdate);
	    jsonforABHA.put("department", js.getString("patDept"));
	    jsonforABHA.put("mobileNo",js.getString("PatCompleteGeneralDtl").split("#")[14]);
	    
	    
		new Thread( new Runnable() {
	    public void run(){
				try {
					String url="/ABDM_QMS/services/restful/ABHAService/syncPrescriptionToABHA";
					postTOABDM_QMS(jsonforABHA,url);
				} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  
	     } 
	    }).start();
		
		
	}
	
	
	
	/*
	 * public static void syncPrescriptionToABHA(String jsonData) throws
	 * JSONException { JSONObject js = new JSONObject(jsonData); JSONObject
	 * jsonforABHA = new JSONObject(); jsonforABHA.put("cr_no",
	 * js.getString("CR_No")); jsonforABHA.put("hospital_code",
	 * js.getString("hosp_code")); jsonforABHA.put("episode_code",
	 * js.getString("episodeCode")); jsonforABHA.put("visit_no",
	 * js.getString("episodeVisitNo")); jsonforABHA.put("admission_no", "0");
	 * jsonforABHA.put("visit_date", js.getString("currentVisitDate"));
	 * jsonforABHA.put("department", js.getString("patDept")); String
	 * url="/HISNDHMService/restapi/care-context/link-direct"; new Thread( new
	 * Runnable() { public void run(){ try {
	 * 
	 * JSONObject responseJson=postRequestToABHA(jsonforABHA, url);
	 * System.out.println("responseJson====" + responseJson.toString()); } catch
	 * (JSONException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * catch (IOException | ParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }).start();
	 * 
	 * 
	 * }
	 */
	
	
	public static void postTOABDM_QMS(JSONObject objJson,String url) {
		StringBuffer responses = new StringBuffer();	
	//	System.out.println("Inside postTOABDM_QMS");
		try {
		
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		String serverIpPort="http://"+HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_IP")+":"+HisUtil.getParameterFromHisPathXML("HIS_APPSERVER_APPPORT");
		//System.out.println( serverIpPort+url);
		URL obj = new URL(serverIpPort +url);

		try {
			if (obj.toString().toUpperCase().startsWith("HTTPS:")) {
				SSLContext context = SSLContext.getInstance("TLSv1.2");
				TrustManager[] trustManager = new TrustManager[] { new X509TrustManager() {
					public X509Certificate[] getAcceptedIssuers() {
						return new X509Certificate[0];
					}

					public void checkClientTrusted(X509Certificate[] certificate, String str) {
					}

					public void checkServerTrusted(X509Certificate[] certificate, String str) {
					}
				} };
				context.init(null, trustManager, new SecureRandom());
				HttpsURLConnection.setDefaultSSLSocketFactory(context.getSocketFactory());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		

		HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
		postConnection.setRequestMethod("POST");
		postConnection.setRequestProperty("Content-type", "application/json;charset=UTF-8");
		postConnection.setRequestProperty("Accept", "application/json");
		

		String jsonInputString = objJson.toString();
		// String jsonInputString=null;

		// // jsonInputString = "{\"patNdhmHealthId\":\""+hid+"\"}";
		// jsonInputString = "{\"healthId\":\""+hid+"\"}";

		//System.out.println("sending data--------------------------------" + jsonInputString);
		byte[] out = jsonInputString.getBytes("utf-8");
		postConnection.setDoOutput(true);
		try (OutputStream os = postConnection.getOutputStream()) {
			os.write(out);
		}

		int responseCode = postConnection.getResponseCode();

		if (responseCode == 200) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				responses.append(inputLine);
			}
			in.close();
		
		} else {
			//System.out.println(responseCode + "POST NOT WORKED");
			BufferedReader in = new BufferedReader(new InputStreamReader(postConnection.getErrorStream()));
			String inputLine;
			
			while ((inputLine = in.readLine()) != null) {
				responses.append(inputLine);
			}
			in.close();
			//System.out.println(responses);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
}
	

	
	
	public static JSONObject postRequestToABHA(JSONObject filtervo,String url) throws IOException, ParseException, JSONException
	{
		//System.out.println("inside verifyPatHealthId");
		System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		String hip_url = HisUtil.getParameterFromHisPathXML("ABDM_HIP_PATH");
		String hip_auth_key = HisUtil.getParameterFromHisPathXML("ABDM_HIP_AUTH_KEY");
	    JSONObject objResult= new JSONObject() ;
		
		URL obj = new URL(hip_url+ url);
		//System.out.println("URL obj-------------------"+obj);
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
			//System.out.println(responses);
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
	
	public static String getAllPreviousVitalDtls(String JsonData) throws JSONException, ParseException {

		String RetValue = opdDrDeskDao.getAllPreviousVitalDtls(JsonData);
		return RetValue;
	}

	public static boolean  ReferralVisitStamping(String jsonData) {

		
		boolean RetValue=false;
		
		try {
			
			
			 RetValue = opdDrDeskDao.ReferralVisitStamping(jsonData);
					
			
		} catch (Exception e) {			
			e.printStackTrace();
			RetValue=false;
		}
		return RetValue;
	}

	public static JSONObject blockReleaseStoreQuantity(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			JSONObject object = new JSONObject(jsonData);
			String  drugQuan=null;
			if(object.has("drugQuan"))
				drugQuan =object.getString("drugQuan");
			
			//System.out.println("drugQuan from json >>>>" + drugQuan);
			if(drugQuan==null || drugQuan.equals("")  || drugQuan.equals("-1")) {
				drugQuan =opdDrDeskDao.get_stock_qty(object);
				if(drugQuan==null)
					drugQuan="0";
				object.put("drugQuan", drugQuan);
				//System.out.println("drugQuan from db >>>>" + drugQuan);
			}
			
			resultObject = opdDrDeskDao.blockReleaseStoreQuantity(object);		
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}

	public static JSONObject savePatientReview(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			resultObject = opdDrDeskDao.savePatientReview(jsonData);
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}
	
	public static JSONObject AcceptPatientFromPoolSmartQMS(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			resultObject = opdDrDeskDao.AcceptPatientFromPoolSmartQMS(jsonData);
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}

	public static JSONObject saveSectionBookmark(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			resultObject = opdDrDeskDao.saveSectionBookmark(jsonData);
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}

	public static JSONObject UpdateQueueStatus_For_Withoutsmartqueue(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			resultObject = opdDrDeskDao.UpdateQueueStatus_For_Withoutsmartqueue(jsonData);
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}
	
	public static JSONObject UpdateQueueStatus_For_WithoutsmartqueueForApt(String jsonData) {
		JSONObject resultObject= new JSONObject();
		try {
			
			resultObject = opdDrDeskDao.UpdateQueueStatus_For_WithoutsmartqueueForApt(jsonData);
			
		} catch (Exception e) {	
			try {
				resultObject.put("status", "ERROR");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}
		return resultObject;
	}
	
	public static boolean saveReferralData(String JsonData) throws JSONException, ParseException {

		boolean flag=false;
		
		HisDAO dao = null;
		
		
		try {
			
			JSONObject object = new JSONObject(JsonData);
			
			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.saveReferralData()");
			
						
			int lenstrEndorsmentDtl=0;
			int lenexternalConsultantReferalDtl=0;
			int lenexternalInvestigationReferalDtl=0;
			int lenexternalProcedureReferalDtl=0;
			int lenexternalFollowupReferalDtl=0;
			if(object.has("strEndorsmentDtl") && object.getJSONArray("strEndorsmentDtl").length()>0) {
				lenstrEndorsmentDtl=object.getJSONArray("strEndorsmentDtl").length();
			}
			else {
				object.remove("strEndorsmentDtl");
			}
			if(object.has("externalConsultantReferalDtl") && object.getJSONArray("externalConsultantReferalDtl").length()>0) {
				lenexternalConsultantReferalDtl=object.getJSONArray("externalConsultantReferalDtl").length();
			}
			if(object.has("externalInvestigationReferalDtl") && object.getJSONArray("externalInvestigationReferalDtl").length()>0) {
				lenexternalInvestigationReferalDtl=object.getJSONArray("externalInvestigationReferalDtl").length();
			}
			if(object.has("externalProcedureReferalDtl") && object.getJSONArray("externalProcedureReferalDtl").length()>0) {
				lenexternalProcedureReferalDtl=object.getJSONArray("externalProcedureReferalDtl").length();
			}
			if(object.has("externalFollowupReferalDtl") && object.getJSONArray("externalFollowupReferalDtl").length()>0) {
				lenstrEndorsmentDtl=object.getJSONArray("externalFollowupReferalDtl").length();
			}
			
			if(lenexternalConsultantReferalDtl>0 || lenexternalInvestigationReferalDtl>0 
					|| lenexternalProcedureReferalDtl>0 || lenexternalFollowupReferalDtl>0) {
				opdDrDeskDao.saveExternalRefferral(object.toString() , dao);
			}
			

			
			dao.fire();
			flag=true;
			
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}finally {
			
			if(dao != null) {
				dao.free();
				dao = null;
			}
			
		}
		
		return flag;
		

	}


	
}
