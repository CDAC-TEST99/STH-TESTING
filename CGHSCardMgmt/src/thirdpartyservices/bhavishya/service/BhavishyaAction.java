package thirdpartyservices.bhavishya.service;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import hissso.config.HISSSOConfig;
import thirdpartyservices.bhavishya.util.AESEncrytionDecryption;

@SuppressWarnings("serial")
public class BhavishyaAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest objRequest, HttpServletResponse response)
			throws ServletException, IOException {

	//	System.out.println("Bhavishya Action Called For Redirect URL.");

		Map<String, String[]> queryMap = objRequest.getParameterMap();
		String panNumber = null;
		long timestamp = 0;
		String panNumberForRequestParam = null;
		String token = null;
		for (Map.Entry<String, String[]> obj : queryMap.entrySet()) {
			String key = obj.getKey();
		//	System.out.println("######### Card Mgmt HISSSOClientRequestFilter Key = " + key + "\t ######### Value = "
			//		+ obj.getValue()[0].toString());
			if ("token".equalsIgnoreCase(key)) {
				token = obj.getValue()[0].toString();
			} else if ("request".equalsIgnoreCase(key)) {
				try {
					//System.out.println("Before Decoding Request Value = " + obj.getValue()[0].toString());
					String urlParamDecoded = URLDecoder.decode(obj.getValue()[0].toString(),
							StandardCharsets.UTF_8.toString());
					//System.out.println("After Decoding Request Value = " + urlParamDecoded);
					panNumberForRequestParam = AESEncrytionDecryption.decrypt(obj.getValue()[0].toString()).trim();
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("Exception Occured in Decryption of AES String = " + e.getMessage());
					RequestDispatcher rd = null;
					rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
					rd.forward(objRequest, response);
					return;
				}
				panNumber = panNumberForRequestParam.substring(0, 10);
				timestamp = Long.parseLong(panNumberForRequestParam.substring(10, panNumberForRequestParam.length()));
			}
			if (token != null && token.length() > 0 && panNumber != null && panNumber.length() > 0) {
				try {
					String bhavishySecretKey = Usefulmethods.getQuery(
							"thirdpartyservices.bhavishya.service.cghs-bhavishya", "bhavishya.login.secret.key");
					String shaToken = Usefulmethods.getBhavishyaLoginSha512String(panNumber.toUpperCase(),
							bhavishySecretKey, timestamp);
					//System.out.println(
					//		"PAN Number in Redirecting URL for Bhavishya Portal = " + panNumberForRequestParam);
					//System.out.println("SHA Token Matched or Not = " + (token.equalsIgnoreCase(shaToken)));

					if (token.equalsIgnoreCase(shaToken)) {
						//System.out.println(
						//		"########## SUCCESS - SHA Token From Bhavishya Portal Redirect URL Successfully Matched.");
//
						

						JSONObject panObject = new JSONObject();
						panObject.put("pk0", panNumber);
						JSONObject statusObj = null;

						Usefulmethods objUsefulmethods = new Usefulmethods();
						String strServiceName = "service/getPensionerApplicationStatus";

						// Call the service and get the status for PAN
						statusObj = objUsefulmethods.callService(panObject, strServiceName);
						//System.out.println("Bhavishya FMA Code Details = " + statusObj.toString());
						JSONArray data = null;
						if(statusObj.has("data")) {
							data = (JSONArray) statusObj.get("data");
						} else {
							data = new JSONArray();
						}
						//System.out.println("JSON Data using PAN Number of Bhavishya = " + data.toString());
						if (data.isEmpty() == false) {
							JSONObject status = (JSONObject) (data.get(0));
							int appStatusCode = status.getInt("applicationstatus");
							String name = status.getString("username");
							String trackingId = status.getString("trackingid");
							String appStatus = status.getString("status");
						//	System.out.println("Bhavishya Application Status for Pan Number("+panNumber+") = "+appStatusCode);
						//	System.out.println("Bhavishya Application Tracking Id = "+trackingId);
							if (appStatusCode >=1 && appStatusCode <=6) {  // Redirect to Ben Login Page for Downloading the CGHS Card
								RequestDispatcher rd = null;

								String page = "/FormFlowXACTION?isGlobal=1&masterKey=bhavishyaCghsCardStatus&bhavishyaApplicationStatusCode="+appStatusCode
										+"&bhavishyaUserName="+name+"&bhavishyaApplicationStatus="+appStatus+"&bhavishyaApplicationTrackingId="+trackingId;
								//System.out.println("Redirect URL = " + page);
								rd = objRequest.getRequestDispatcher(page);
								rd.forward(objRequest, response);
							}  else { // Redirect to Application Form Submission Page whether application is rejected or returned or new pensioner
								
							//	System.out.println("Redirect the Pensioner ("+panNumber+") to Application Form");
								
								RequestDispatcher rd = null;
								String page = "/FormFlowXACTION?isGlobal=1&masterKey=DAOnlinePensioner&panNumber="
										+ panNumber + "&isBhavishyaRedirect=Y";
								//System.out.println("Redirect URL = " + page);
								rd = objRequest.getRequestDispatcher(page);
								rd.forward(objRequest, response);
							}

						} else { // Redirect to Application Form Submission Page whether application is rejected or returned or new pensioner
							
							//System.out.println("Redirect the Pensioner ("+panNumber+") to Application Form");
							
							RequestDispatcher rd = null;
							String page = "/FormFlowXACTION?isGlobal=1&masterKey=DAOnlinePensioner&panNumber="
									+ panNumber + "&isBhavishyaRedirect=Y";
							///ln("Redirect URL = " + page);
							rd = objRequest.getRequestDispatcher(page);
							rd.forward(objRequest, response);
						}

					} else {
						//System.out.println("########## FAILED - Invalid SHA Token From Bhavishya Portal Redirect URL.");
						//System.out.println(
					//			"Redirect URL For Error Page = " + HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
						RequestDispatcher rd = null;
						rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
						rd.forward(objRequest, response);
						return;
					}

				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("#### Redirecting URL from Bhavishya - Decryption Error of Request Param = "
							+ e.getMessage());
				}
			}
		}

	}

}
