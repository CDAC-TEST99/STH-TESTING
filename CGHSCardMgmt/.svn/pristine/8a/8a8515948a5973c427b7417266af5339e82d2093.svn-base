package thirdpartyservices.bhavishya.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bhavishya.model.BaseResponse;
import thirdpartyservices.bhavishya.model.BhavishyaResponse;
import thirdpartyservices.bhavishya.util.AESEncrytionDecryption;
import thirdpartyservices.bhavishya.util.BhavishyaUtil;
import thirdpartyservices.digilocker.util.HtmlToPdfConvertor;
import thirdpartyservices.parliament.CghsParliamentAPIs;

public class BhavishyaIntegrationService {
	
	static String logsType = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
			"cghs.bhavishya.save.logs");

	public static String getBhavishyaLoginJWTToken() throws Exception {
		defaultSslConnection();
		String bhavishyaBaseUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"cghs.bhavishya.base.url");
		String bhavishyaLoginUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"cghs.bhavishya.login.url");
		String bhavishyaUsername = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"bhavishya.login.username");
		String bhavishyaPassword = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"bhavishya.login.password");
		String bhavishySecretKey = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
				"bhavishya.login.secret.key");
		
		long timestamp = new Date().getTime();
		String shaToken = Usefulmethods.getBhavishyaLoginSha512String(bhavishyaPassword, bhavishySecretKey, timestamp);
		String bhavishyaJwtToken = "";

		Gson gson = new Gson();
		String finalLoginUrl = bhavishyaBaseUrl + bhavishyaLoginUrl;
		Map<String, String> loginCredMap = new HashMap<>();
		loginCredMap.put("username", bhavishyaUsername);
		loginCredMap.put("password", bhavishyaPassword);
		loginCredMap.put("timestamp", "" + timestamp);

		String loginRequestJsonStr = gson.toJson(loginCredMap);
		Map<String, String> loginRequestMap = new HashMap<>();
		String loginEncryptString = AESEncrytionDecryption.encrypt(loginRequestJsonStr);
		//System.out.println("Login Request = " + loginEncryptString);
		loginRequestMap.put("request", loginEncryptString);
		loginRequestMap.put("token", shaToken);
		String loginReqMapJsonStr = gson.toJson(loginRequestMap);
		//System.out.println("Final Login Request Body = " + loginReqMapJsonStr);

		URL url = new URL(finalLoginUrl);
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		connection.setDoInput(true);
		connection.setDoOutput(true);
		
		//System.out.println("Bhavishya Login URL = "+finalLoginUrl);

		try (OutputStream outputStream = connection.getOutputStream()) {
			outputStream.write(loginReqMapJsonStr.getBytes());
		}

		int loginResponse = connection.getResponseCode();
		
		//System.out.println("Http Bhavishya Login Response Status Code = "+loginResponse);

		// Login API calling status checking.
		if (loginResponse == HttpURLConnection.HTTP_OK) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuilder responseContent = new StringBuilder("");
			String line;
			while ((line = reader.readLine()) != null) {
				responseContent.append(line);
			}
			reader.close();

		//	System.out.println("Bhavishya Login ResponseContent >> "+responseContent.toString());
			
			
			BaseResponse baseResp = gson.fromJson(responseContent.toString(), BaseResponse.class);
			int loginStatusCode = baseResp.getStatusCode();
			
			//System.out.println("Bhavishya Login Response Code = "+loginStatusCode);

			// Login API Request Data Status Code Checking means JWT token created or not
			BaseResponse loginJwtResponse = null;
			if (loginStatusCode == 200) {
				
				loginJwtResponse = gson.fromJson(AESEncrytionDecryption.decrypt(baseResp.getData()),
						BaseResponse.class);
				bhavishyaJwtToken = loginJwtResponse.getToken();

			//	System.out.println("Bhavishya JWT Token = " + bhavishyaJwtToken);

			}
			
			if(bhavishyaJwtToken.length() > 0)
				BhavishyaUtil.insertBhavishyaLogs(loginRequestJsonStr, loginJwtResponse.toString(), loginEncryptString, 
					responseContent.toString(), "BHAVISHYA LOGIN API", "SUCCESS", "JWT TOKEN RECEIVED.");
			else 
				BhavishyaUtil.insertBhavishyaLogs(loginRequestJsonStr, loginJwtResponse.toString(), loginEncryptString, 
						responseContent.toString(), "BHAVISHYA LOGIN API", "FAILED", "JWT TOKEN NOT RECEIVED.");
		}

		return bhavishyaJwtToken;
	}

	public static BhavishyaResponse getRetireeDataFromBhavishya(String panNumber) throws Exception {
		BhavishyaResponse response = null;
		try {
			
			defaultSslConnection();

			// Call the Login API of Bhavishya Service
			String bhavishyaJwtToken = getBhavishyaLoginJWTToken();

			String bhavishyaBaseUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"cghs.bhavishya.base.url");
			String bhavishyaDataUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"cghs.bhavishya.get.data.url");
			Gson gson = new Gson();

			String finalDataUrl = bhavishyaBaseUrl + bhavishyaDataUrl;

			String bhavishyaCghsData = "";

			//System.out.println("JWT Token = " + bhavishyaJwtToken);

			Map<String, String> dataMap = new HashMap<>();
			Map<String, String> dateRequestMap = new HashMap<>();
			
			Date date = new Date();
			
			String request = ""+panNumber.toUpperCase() + date.getTime();
			dateRequestMap.put("request", request);
			
			String dataLogRequest = new JSONObject(dateRequestMap).toString();
			
			dataMap.put("request", AESEncrytionDecryption.encrypt(request));
			String dataMapJsonStr = new JSONObject(dataMap).toString();

			if (bhavishyaJwtToken != null && bhavishyaJwtToken.trim().length() > 0) {

				// Now setting the URL for fetching Bhavishya Pensioner Data using PAN number
				URL url = new URL(finalDataUrl);
				HttpsURLConnection dataConnection = (HttpsURLConnection) url.openConnection();
				dataConnection.setRequestMethod("POST");
				dataConnection.setRequestProperty("Accept", "application/json");
				dataConnection.setRequestProperty("Content-Type", "application/json");
				dataConnection.setRequestProperty("Authorization", "Bearer " + bhavishyaJwtToken);
				dataConnection.setDoInput(true);
				dataConnection.setDoOutput(true);

			//	System.out.println("CGHS BHAVISHYA DATA REQUEST = " + dataMapJsonStr);

//		          Write parameters to the request body
				try (OutputStream outputStream = dataConnection.getOutputStream()) {
					outputStream.write(dataMapJsonStr.getBytes());
				}

//		            Now calling the API for getting the details of Retiree using PAN card in encrypted form with JWT token in header
		            
				int dataResponse = dataConnection.getResponseCode();

				if (dataResponse == HttpURLConnection.HTTP_OK) {
					BufferedReader dataReader = new BufferedReader(
							new InputStreamReader(dataConnection.getInputStream()));
					StringBuilder responseData = new StringBuilder("");
					String responseLine;
					while ((responseLine = dataReader.readLine()) != null) {
						responseData.append(responseLine);
					}
					bhavishyaCghsData = responseData.toString();
					dataReader.close();

					BaseResponse bhavishyaDataResponse = gson.fromJson(bhavishyaCghsData, BaseResponse.class);
					int bhavishyaDataStatusCode = bhavishyaDataResponse.getStatusCode();
					if (bhavishyaDataStatusCode == 200) {
						response = gson.fromJson(AESEncrytionDecryption.decrypt(bhavishyaDataResponse.getData()),
								BhavishyaResponse.class);
						
						String validResponse = BhavishyaUtil.validateBhavishyaData(response);
						//System.out.println("For Validating Retiree Data = "+validResponse);
						if(validResponse != null && validResponse.trim().length() > 0) {
						//	System.out.println("Data Is Not Complete. So I am rejecting the data to save.");
							
							BhavishyaUtil.insertBhavishyaLogs(dataLogRequest, response.toString(), dataMapJsonStr, 
									bhavishyaDataResponse.toString(), "GET BHAVISHYA DATA", "ERROR", "MISSING MANDATORY DATA");
							
							response = new BhavishyaResponse();
							response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
							response.setMessage(validResponse);
							response.setData(null);
							return response;
						}
						JSONObject objRequest = new JSONObject();
						objRequest.put("pk0", response.getFmaCode());
						JSONObject objResponse = null;
						//
						
						Usefulmethods objUsefulmethods = new Usefulmethods();
				        String strServiceName = "service/getfacilitybasedonfmabhavishya";
				        
				        // Call the service and get the response
				         objResponse = objUsefulmethods.callService(objRequest, strServiceName);
				        // System.out.println("Bhavishya FMA Code Details = "+objResponse.toString());
				         JSONArray data = null;
				         if(objResponse.has("data")) {
				        	 data = (JSONArray)objResponse.get("data");
				         } else {
				        	 data = new JSONArray();
				         }

				      //   System.out.println("JSON Data using FMA Code of Bhavishya = "+data.toString());
				         if(data.isEmpty() == false) {
				        	 JSONObject fmaObj = (JSONObject)(data.get(0));
				        	 response.setFmaFacility(fmaObj.getString("optionText"));
				         } 
				         
						if ("DEBUG".equalsIgnoreCase(logsType)) {
							BhavishyaUtil.insertBhavishyaLogs(dataLogRequest, response.toString(), dataMapJsonStr,
									bhavishyaDataResponse.toString(), "GET BHAVISHYA DATA", "SUCCESS",
									"BHAVISHYA DATA RECEIVED");
						}
						
						response.setStatusCode(bhavishyaDataStatusCode);
					} else {
						//System.out.println("For Getting Retiree Data - Bhavishya Data Status Code = "+bhavishyaDataStatusCode);
						//System.out.println("Data Not Found.");
						response = gson.fromJson(AESEncrytionDecryption.decrypt(bhavishyaDataResponse.getData()),
								BhavishyaResponse.class);
						BhavishyaUtil.insertBhavishyaLogs(dataLogRequest, response.toString(), dataMapJsonStr,
								bhavishyaDataResponse.toString(), "GET BHAVISHYA DATA", "ERROR",
								"BHAVISHYA DATA NOT RECEIVED");
						
						
						response = new BhavishyaResponse();
						response.setStatusCode(bhavishyaDataStatusCode);
					}
					
				} else {
					BhavishyaUtil.insertBhavishyaLogs(dataLogRequest, null, dataMapJsonStr,
							null, "GET BHAVISHYA DATA", "ERROR",
							"BHAVISHYA DATA NOT RECEIVED");
					response = new BhavishyaResponse();
					//System.out.println("For Getting Retiree Data - Bhavishya Data Status Code = "+dataResponse);
					response.setStatusCode(dataResponse);
					// Write code for sending error message
				}
			} else {
				response = new BhavishyaResponse();
				//System.out.println("Bhavishya JWT Token not received.");
				response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
			}

		} catch (Exception e) {
			response = new BhavishyaResponse();
			System.err.println("Exception = " + e.getMessage());
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	public static BaseResponse getBhavishyaRetireeCardDetailListByPanNumber(String panNumber) {
		BaseResponse response = new BaseResponse();
		try {
			//System.out.println("Method - getBhavishyaRetireeCardDetailListByPanNumber - Pan Number = "+panNumber);
			JSONObject objRequest = new JSONObject();
			objRequest.put("pk0", panNumber);
			JSONObject objResponse = null;
			
			Usefulmethods objUsefulmethods = new Usefulmethods();
	        String strServiceName = "service/getBeneficiaryCardListBhavishya";
	        
	        // Call the service and get the response
	         objResponse = objUsefulmethods.callService(objRequest, strServiceName);
	       //  System.out.println(objResponse.toString());
	         
	         JSONArray data = (JSONArray)objResponse.get("data");
	        // System.out.println("JSON Data using PAN  = "+data.toString());
	         if(data.isEmpty() == true) {
	        	 response.setData(null);
	        	 response.setMessage("Data Doesn't Exist.");
	             response.setStatusCode(417);
	         } else {
	        	 String encryptedData = AESEncrytionDecryption.encrypt(data.toString());
	        	 response.setData(encryptedData);
	        	 response.setMessage("Data Successfully Fetched.");
	             response.setStatusCode(200);
	         }
		} catch(Exception e) {
			response.setStatusCode(500);
			response.setData(null);
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	public static BaseResponse getBhavishyaRetireeCardBase64StringByBenId(long beneficiaryId) {
		BaseResponse response = new BaseResponse();
		JSONObject objFilterJson=new JSONObject();
		objFilterJson.put("benId", ""+beneficiaryId);
		
		JSONObject objResponse=new JSONObject();
		JSONObject result=new JSONObject();
	
      
		// getBenIdWiseDtl
		  try {
//			   objFilterJson   = new JSONObject(filters);
	         //   System.out.println("objFilterJson>>>>"+objFilterJson);
	            if (objFilterJson.has("benId") == false) {
	            	response.setMessage("Invalid Beneficiary Id.");
					response.setStatusCode(400);
					return response;
	            }

	            String pk0 = (String) objFilterJson.get("benId");
	            objFilterJson.put("pk0", pk0);
	            objFilterJson.put("processName", "/parliament/v1/BenDetails/getBeneficiaryCard");
	        } catch (Exception e) {
	        	response.setMessage("Method : getBhavishyaRetireeCardBase64StringByBenId "+e.getMessage());
				response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
				return response;
	        }

	        if (objFilterJson.length() == 0) {
	            objFilterJson = null; // setting to null so that filter is not used in query
	        }
		
			
			 try {
		           
		            Usefulmethods objUsefulmethods = new Usefulmethods();
		            String strServiceName = "service/beneficiaryDetails";

		            // Call the service and get the response
		             objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
		          	String filePath = "";
		        	String osType = System.getProperties().getProperty("os.name");

		    		if (osType.startsWith("Win")) {
		    			filePath = "C:/CGHS/FileHandling/CardManagement/";
		    		} else {
		    			filePath = "/opt/Arunachal_PHDM/FileHandling/prescriptions/";
		    		}
		    		String pdfbase64=null;
		         

		            // Check if objResponse is not null
		            if (objResponse != null) {
		                // Log the objResponse for debugging
		              //  System.out.println("objResponse >>>>> " + objResponse);

		                // Get the "data" array from objResponse
		                JSONArray dataArray = objResponse.optJSONArray("data");

		                // Check if dataArray is not null and has at least one element
		                if (dataArray != null && dataArray.length() > 0) {
		                    // Create an array to hold the final beneficiary details
		                  

		                    // Loop through each item in the dataArray
		                    for (int i = 0; i < dataArray.length(); i++) {
		                        // Get the JSONObject at the current index 'i'
		                        JSONObject dataObject = dataArray.optJSONObject(i);

		                        // Check if the JSONObject is not null
		                        if (dataObject != null) {
		                            // Extract a variable from this specific object by its key
		                            //String BeneficiaryId = dataObject.optString("BenId"); // Example field
		                      //      String cardno = dataObject.optString("cardno");
		                            String cardType = dataObject.optString("cardtype");
		                    //        String mobileNo = dataObject.optString("mobileno");
		                   //         String emailId = dataObject.optString("emailid");
		                            String name = dataObject.optString("name");
		                 //           String relation = dataObject.optString("relation");
		                            String dob = dataObject.optString("Dob");
		                     //       String gender = dataObject.optString("gender");
		                            String BenId = dataObject.optString("BenId");
		                            String gender=dataObject.optString("gender");
		                            String Entitlement = dataObject.optString("gnum_short_nm");
		                            String hindientitlement = dataObject.optString("hindientitlement");
		                            String validto = dataObject.optString("validto");
		                            String hindicardtype = dataObject.optString("hindicardtype");
		                            String base64Imagefront=dataObject.optString("card_front_header_base64");
		                            String base64Imageback=dataObject.optString("card_back_base64");
		                            String relationname=dataObject.optString("gstr_relation_name");
		                            String cardvalidto=dataObject.optString("validto");
		                            
		                          String color="red";
		                          String Photonamedep="10013585.jpg";
                            //      System.out.println("PhotonamedepPhotonamedep>>>>>>>"+Photonamedep);
                                  String Photonamedepbase64=BhavishyaUtil.getImageAsBase64(Photonamedep);
                               //System.out.println("Photonamedepbase64>>>>>>>"+Photonamedepbase64);
		                			//filePath = filePath  + crNo.replace("/", "-") + "_"+episodeCode+"_"+visitNo+ ".pdf";
		                			filePath = filePath  + BenId+ ".pdf";
		                            // Initialize a StringBuilder to construct the HTML content
		                			
		                			String imagebase64=dataObject.optString("photo");
		                			
		                	       // String data = "BenId: " +2025+ BenId;

		                			 //   System.out.println("imagebase64>>>>>>"+imagebase64);
		                			              					
		                			    String data = "BenId: " + BenId + ", Name: " + name + ", gender: " + gender;

		                		            // Generate the QR code image and get the Base64 string
		                		            String base64QRCode = BhavishyaUtil.generateQRCodeBase64(data, 350, 350);
		                		            
		                		            String base64QRCodefinal = "data:image/png;base64," + base64QRCode;


		                		            // Create HTML string with Base64 QR code embedded inside a div
		                		           /* String htmlContent = "<div id='qrCodeDiv'>" +
		                		                    "<img id='qrCodeImage' src='data:image/png;base64," + base64QRCode + "' alt='QR Code' />" +
		                		                    "</div>";*/

		                		            // Print or return the HTML content
		                		            //System.out.println(base64QRCode);
		                		    
		                            StringBuilder htmlContent = new StringBuilder();
		                            htmlContent.append("<div class=\"card cghs-card\" id='cghsCard' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px; 	border: 1px solid #000;  background-image: url(\"data:image/png;base64," + base64Imagefront + "\"); background-size: cover; background-position: center;'>")
		                            .append("<div class=\"card-body\">")
		                            .append("<div class=\"card-content\">")
		                            .append("<div class=\"card-image\"  style=\"\">")
		                         
		                            .append("<img id=\"photo\" src=\"data:image/png;base64," + Photonamedepbase64 + "\" alt=\"Profile Photo\" style=\"border-radius: 10px; margin-right: 15px; margin-top: 100px; height: 100px; width: 80px; object-fit: cover; border:1px solid #ddd9d9 !important;\">")
		                            .append("</div>")
		                            .append("<div class=\"\" style=\"margin-top: -109px;margin-left: 127px;  flex-grow: 1;\">")
		                            .append("<table>")
		                            .append("<tr>")
		                            .append("<td style='width:40%; font-size: small; padding:5px; color:#1F6780;font-weight: bold; text-transform: capitalize; letter-spacing: 0.040rem; white-space: nowrap;'>")
		                            .append("<p style='margin: 0; padding: 0; text-align:left;'>")
		                            .append("NAME: " + name)
		                            .append("</p>")
		                            .append("<p style='margin: 0; padding: 0;'>DOB/GENDER: " + dob + "/" + gender + "</p>")
		                            .append("<p class=\"card-text\" style='margin: 0; padding: 0;'>CATEGORY: " + cardType + "</p>")
		                            .append("<p style='margin: 0; padding: 0;'>RELATION: " + relationname + "</p>")
		                            .append("<p style='margin: 0; padding: 0;'>ENTITLEMENT: " + Entitlement + "</p>")
		                            .append("<p style='margin: 0; padding: 0;'>VALID UPTO: " + cardvalidto + "</p>")
		                            .append("</td>")

		                            .append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCode\"><img src='" + base64QRCodefinal + "' alt='QR Code' style='width: 100px; height: 100px;'/></td>")		                           
		                            .append("</tr>")
		                            .append("<tr>")
		                            .append("<td colspan=\"2\" style=\"text-align: right; padding-right: 18px; padding-top: 61px;letter-spacing: 0.040rem;font-weight: bold;\">&#x928;&#x93F;&#x930;&#x94D;&#x926;&#x947;&#x936;&#x915;/Director</td>")
		                            .append("</tr>")
		                            .append("</table>")
		                            .append("<div style='margin-top: -27px;margin-left: -118px; font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "+BenId+" </div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("<div class=\"card cghs-card\" id='cghsCardBack' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px; 	border: 1px solid #000; background-image: url(\"data:image/png;base64," + base64Imageback + "\"); background-size: cover; background-position: center;'>")
		                            .append("<div class=\"card-body\">")
		                            .append("<div class=\"card-content\">")
		                            .append("<div class=\"card-details\" style=\"margin-top: 76px;\">")
		                            .append("<table>")
		                            .append("<tr>")
		                            .append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCodeBack\"></td>")
		                            .append("<td style='width:70%; padding:5px;color:#1F6780;font-weight: bold; text-transform: capitalize;letter-spacing: 0.040rem;'>")
		                            .append("</td>")
		                            .append("</tr>")
		                            .append("</table>")
		                            .append("<div style='margin-top: 168px;margin-left: 9px;font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "+BenId+" </div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("</div>")
		                            .append("</div>");
		                            htmlContent.append("</body>");
		                            htmlContent.append("</html>");

		                            try {
		            					//System.out.println("before  convert?>>> ");
		            					 String finalHTML = htmlContent.toString();
		            					 // System.out.println(finalHTML);
		            			      	HtmlToPdfConvertor.convert(htmlContent.toString() , filePath);
		            					//System.out.println("after  convert?>>> ");
		            					pdfbase64 =HtmlToPdfConvertor.convertPDFToBase64(filePath);
		            					//System.out.println("pdfbase64>>>" + pdfbase64);
		            					
		            					//  System.out.println(base64QRCode);
		            					//  System.out.println("Photonamedepbase64>>>>>>>"+Photonamedepbase64);
		            					//   return pdfbase64;
		            				} catch (Exception e) {
		            					// TODO Auto-generated catch block
		            					e.printStackTrace();
		            					response.setMessage("Method : After Html Conversion - "+e.getMessage());
		            					response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		            					return response;
		            				}
		            			
		                            // Create a new JSONObject to store the beneficiary details
		                         
		                            // Add this beneficiary's details to the beneficiaryDetailsArray
		                           // beneficiaryDetailsArray.put(beneficiaryDetails);
		                        } else {
		                            System.out.println("No valid data object found in the 'data' array.");
		                        }
		                    }

		                    // Add the beneficiaryDetailsArray to the result
		                    
		                    response.setData(AESEncrytionDecryption.encrypt(pdfbase64));
		                    response.setMessage("Card Successfully Fetched.");
		    				response.setStatusCode(HttpStatus.SC_OK);
		    				return response;
		                } else {
		                	System.out.println("'data' array is empty or null.");
		                	response.setData(pdfbase64);
		                    response.setMessage("Card Data Not Available.");
		    				response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
		    				return response;
		                    
		                }
		            }

		            // Return the final response with the result
		         
		           return response;

		        } catch (Exception e) {
		            // Log the exception
		            e.printStackTrace();
                    response.setMessage(e.getMessage());
    				response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    				return response;
		            // Return a response with an error status
		        
		    }
	}
	
	public static void getCurrentDayBhavishyaRetireeCardIssuerDetails(String encryptedData) {
	//	System.out.println("Sending Bhavishya Retiree Card Issuer Details into Bhavishya DB");
		try {
			String bhavishyaJwtToken = getBhavishyaLoginJWTToken();// Need to get permanent JWT token PAN Number for this API
			
			String bhavishyaBaseUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"cghs.bhavishya.base.url");
			String sendDataUrl = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"cghs.bhavishya.send.card.data.url");
			
			String finalUrl = bhavishyaBaseUrl+sendDataUrl;
			
			//System.out.println("Final Url for Sending Card Details into Bhavishya Portal..."+finalUrl);
			
			Map<String, String> dataMap = new HashMap<>();

			dataMap.put("request", encryptedData);
			String dataMapJsonStr = new JSONObject(dataMap).toString();
			//System.out.println("CGHS BHAVISHYA CARD DETAILS SAVE REQUEST = " + dataMapJsonStr);

			if (bhavishyaJwtToken != null && bhavishyaJwtToken.trim().length() > 0) {

				// Now setting the URL for sending card details to Bhavishya portal
				URL url = new URL(finalUrl);
				HttpsURLConnection dataConnection = (HttpsURLConnection) url.openConnection();
				dataConnection.setRequestMethod("POST");
				dataConnection.setRequestProperty("Accept", "application/json");
				dataConnection.setRequestProperty("Content-Type", "application/json");
				dataConnection.setRequestProperty("Authorization", "Bearer " + bhavishyaJwtToken);
				dataConnection.setDoInput(true);
				dataConnection.setDoOutput(true);

				//System.out.println("Now Calling Bhavishya API To Save Card Status...");

//		          Write parameters to the request body
				try (OutputStream outputStream = dataConnection.getOutputStream()) {
					outputStream.write(dataMapJsonStr.getBytes());
				}
//		            
				int dataResponse = dataConnection.getResponseCode();

				if (dataResponse == HttpURLConnection.HTTP_OK) {
					BufferedReader dataReader = new BufferedReader(
							new InputStreamReader(dataConnection.getInputStream()));
					StringBuilder responseData = new StringBuilder("");
					String responseLine;
					while ((responseLine = dataReader.readLine()) != null) {
						responseData.append(responseLine);
					}
					String bhavishyaCghsData = responseData.toString();
					dataReader.close();
					Gson gson = new Gson();

					BaseResponse bhavishyaDataResponse = gson.fromJson(bhavishyaCghsData, BaseResponse.class);
					int bhavishyaDataStatusCode = bhavishyaDataResponse.getStatusCode();
					if (bhavishyaDataStatusCode == 200) {
						String panCardInsertionResponse = AESEncrytionDecryption.decrypt(bhavishyaDataResponse.getData());
					//	System.out.println("PAN Card Status Insertion Response = "+panCardInsertionResponse.toString());
					//	System.out.println("Card Issuer Details Successfully Sent to Bhavishya Portal");
					} else {
						System.out.println("Card Issuer Details Sent Failed to Bhavishya Portal");
					}

				} else {
					System.out.println("Data Failed to Save in Bhavishya Portal. Response Code = "+dataResponse);
				}
			} else {
				System.out.println("Bhavishya JWT Token not received.");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
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
