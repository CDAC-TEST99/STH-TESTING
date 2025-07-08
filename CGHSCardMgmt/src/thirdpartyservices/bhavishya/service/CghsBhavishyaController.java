package thirdpartyservices.bhavishya.service;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.http.HttpStatus;
import org.json.JSONObject;

import com.google.gson.Gson;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bhavishya.model.BaseResponse;
import thirdpartyservices.bhavishya.model.BhavishyaRequest;
import thirdpartyservices.bhavishya.model.BhavishyaResponse;
import thirdpartyservices.bhavishya.util.AESEncrytionDecryption;
import thirdpartyservices.bhavishya.util.BhavishyaUtil;

@Path("/bhavishya")
public class CghsBhavishyaController {
	
	static String logsType = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
			"cghs.bhavishya.save.logs");

	@POST
	@Path("/getBhavishyaData")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBhavishyaData(String request) {

		JSONObject objFilterJson = null;
		BhavishyaResponse data = null;
		// getBenIdWiseDtl
		try {
			objFilterJson = new JSONObject(request);
			if (objFilterJson.has("panNumber") == false) {
				return Response.status(Response.Status.BAD_REQUEST).entity(String.format("Please Provide PAN Number"))
						.build();
			}

			String panNumber = (String) objFilterJson.get("panNumber");
			boolean panValid = panNumber != null && !"".equalsIgnoreCase(panNumber)
					? Usefulmethods.isValidPAN(panNumber.toUpperCase())
					: false;
			if (panValid) {
				try {
					data = BhavishyaIntegrationService.getRetireeDataFromBhavishya(panNumber);
				} catch (Exception e) {
					e.printStackTrace();
					return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
				}
			} else {
				System.out.println("Invalid PAN Number = " + panNumber);
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Invalid PAN Number").build();
			}
			return Response.ok(data).build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(String.format(e.getMessage())).build();
		}
	}
	
	@POST
	@Path("/getRetireeDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public BaseResponse getRetireeDetails(String request) {
		BaseResponse response = new BaseResponse();
		JSONObject requestJson = null;
		BhavishyaRequest bhavishyaRequest = null;
		BaseResponse data = null;
		String task = "";
		try {
			requestJson = new JSONObject(request);
			String requestStr = requestJson.getString("request");
			String token = requestJson.getString("token");
			
			String decryptedJsonStr = AESEncrytionDecryption.decrypt(requestStr);
			bhavishyaRequest = new Gson().fromJson(decryptedJsonStr, BhavishyaRequest.class);
			
			String panNumber = bhavishyaRequest.getPan();
//			String panNumber = (String) requestJson.get("pan");
			long timestamp = Long.parseLong(panNumber.substring(10, panNumber.length()));
			
			long currentTimestamp = new Date().getTime();
			
			long diff = currentTimestamp - timestamp;
			
			int requestTimeout = Integer.parseInt(Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"cghs.bhavishya.request.timeout"));
			
			System.out.println("############# 4th API Bhavishya Request Time Difference = "+diff);
			if(diff >= requestTimeout) { // Check request time, it is greater than or equal to 10 minutes then reject it.
				response.setMessage("Request Timeout.");
				response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
				BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), request, 
						null, "RETIREE DETAILS API", "ERROR", "REQUEST TIMEOUT");
				
				return response;
			}
			
			String bhavishyaPassword = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"bhavishya.login.password");
			String bhavishySecretKey = Usefulmethods.getQuery("thirdpartyservices.bhavishya.service.cghs-bhavishya",
					"bhavishya.login.secret.key");
			String shaToken = Usefulmethods.getBhavishyaLoginSha512String(bhavishyaPassword, bhavishySecretKey, timestamp);
			
			if(shaToken.equalsIgnoreCase(token)) {
				
				if ( (bhavishyaRequest.getBeneficiaryId() == null || "".equalsIgnoreCase(bhavishyaRequest.getBeneficiaryId()))
						&& (bhavishyaRequest.getPan() == null || "".equalsIgnoreCase(bhavishyaRequest.getPan()))	) {
					response.setMessage("Please Provide PAN Number or Beneficiary Id.");
					response.setStatusCode(400);
					BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), request, 
							null, "RETIREE DETAILS API", "ERROR", "PAN OR BENEFICIARY DETAILS MISSING");
					
					return response;
				} else if(bhavishyaRequest.getBeneficiaryId() != null && !"".equalsIgnoreCase(bhavishyaRequest.getBeneficiaryId())) {
					task = "CARD";  // Flag value for fetching Card in Base64 String using beneficiary ID.
				}  else if(bhavishyaRequest.getPan() != null || !"".equalsIgnoreCase(bhavishyaRequest.getPan()) ) {
					task = "LIST";  // Flag value for deciding to fetch which records. Used for fetching Retiree and it's relation card details with beneficiary ID
				} 
				
				System.out.println("Timestamp Along With Pan Number = "+timestamp);
				System.out.println("Retiree Data Getting For = "+task);
				
				if("LIST".equalsIgnoreCase(task)) {
					String actualPanNumber = panNumber.substring(0, 10);
					
					boolean panValid = actualPanNumber != null && !"".equalsIgnoreCase(actualPanNumber)
							? Usefulmethods.isValidPAN(actualPanNumber.toUpperCase())
							: false;
							
					if (panValid) {
						try {
							data = BhavishyaIntegrationService.getBhavishyaRetireeCardDetailListByPanNumber(actualPanNumber);
							
							if("DEBUG".equalsIgnoreCase(logsType)) {
								BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, null, requestStr, 
										data.toString(), "RETIREE DETAILS API - LIST", "SUCCESS", 
										"BENFICIARY LIST SUCCESSFULLY FETCHED BY BHAVISHYA");
							}
							
							return data;
						} catch (Exception e) {
							e.printStackTrace();
							response.setMessage(e.getMessage());
							response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
							
							BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), requestStr, 
									null, "RETIREE DETAILS API - LIST", "FAILED", e.getMessage());
						}
					} else {
						response.setMessage("Invalid PAN Number.");
						response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
						
						BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), requestStr, 
								null, "RETIREE DETAILS API - LIST", "FAILED", "INVALID PAN NUMBER");
						
					}
					
				} else if("CARD".equalsIgnoreCase(task)) {
					long beneficiaryId = Long.parseLong(bhavishyaRequest.getBeneficiaryId());
					boolean beneficiaryIdValid = beneficiaryId != 0 ? true : false;
					if(beneficiaryIdValid) {
						response = BhavishyaIntegrationService.getBhavishyaRetireeCardBase64StringByBenId(beneficiaryId);
						
						if("DEBUG".equalsIgnoreCase(logsType)) {
							BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, null, requestStr, response.toString(), 
									"RETIREE DETAILS API - CARD", "SUCCESS", "BENEFICIARY CARD SUCCESSFULLY SENT.");
						}
						
					} else {
						System.out.println("Invalid Beneficiary ID = " + beneficiaryId);
	                    response.setMessage("Invalid Beneficiary ID");
	    				response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
	    				BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), requestStr, 
								null, "RETIREE DETAILS API - CARD", "FAILED", "INVALID BENEFICIARY ID");
					}
				}
			} else {
				response.setMessage("Invalid Token");
				response.setStatusCode(HttpStatus.SC_EXPECTATION_FAILED);
				
				BhavishyaUtil.insertBhavishyaLogs(decryptedJsonStr, response.toString(), requestStr, 
						null, "RETIREE DETAILS API", "FAILED", "INVALID TOKEN");
				
			}
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
			
			BhavishyaUtil.insertBhavishyaLogs(null, response.toString(), request, 
					null, "RETIREE DETAILS API", "FAILED", e.getMessage());
		}
		return response;
		
	}
		
}
