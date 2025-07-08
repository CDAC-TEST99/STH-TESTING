package thirdpartyservices.parliament;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.WriterException;

import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import thirdpartyservices.digilocker.util.HtmlToPdfConvertor;

@Path("/parliament/v1/BenDetails")
public class CghsParliamentAPIs {

	@POST
	@Path("/getanybeneficiaryDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getAnyBeneficiaryDetails(String filters) {

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject result = new JSONObject();
		// JSONObject familyDetails=new JSONObject();
		JSONArray beneficiaryDetailsArray = new JSONArray();
		// JSONObject cardHolderAddress = new JSONObject();
		// JSONObject mainCardHolder = new JSONObject();
		// JSONObject indexCard = new JSONObject();
		// JSONArray members = new JSONArray();
		// JSONObject familyMember = new JSONObject();
		JSONObject beneficiaryDetails = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);

		// getBenIdWiseDtl
		try {
			objFilterJson = new JSONObject(filters);

			// System.out.println("Incoming Request JSON: " + objFilterJson.toString(4));
			if (objFilterJson.has("benId") == false) {
				return Response.status(Response.Status.BAD_REQUEST).entity(String.format("benId Not valid !")).build();
			}

			String pk0 = (String) objFilterJson.get("benId");
			objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/getanybeneficiaryDetails");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			// Instantiate Usefulmethods object to call the external service
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/beneficiaryDetails";

			// Call the service and get the response
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);

			// Check if objResponse is not null
			if (objResponse != null) {
				// Log the objResponse for debugging
				// System.out.println("objResponse >>>>> " + objResponse);

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
							// String BeneficiaryId = dataObject.optString("BenId"); // Example field
							String cardno = dataObject.optString("cardno");
							String cardType = dataObject.optString("cardtype");
							String mobileNo = dataObject.optString("mobileno");
							String emailId = dataObject.optString("emailid");
							String name = dataObject.optString("name");
							String relation = dataObject.optString("relation");
							String dob = dataObject.optString("Dob");
							String gender = dataObject.optString("gender");

							// Create a new JSONObject to store the beneficiary details
							beneficiaryDetails.put("card_no", cardno); // Card number
							beneficiaryDetails.put("card_type", cardType); // Card type
							beneficiaryDetails.put("dispensary_code", "PHA"); // Example dispensary code
							beneficiaryDetails.put("name", name);
							beneficiaryDetails.put("sex", gender);
							beneficiaryDetails.put("relation", relation);
							beneficiaryDetails.put("blood_group", "O+"); // Example blood group
							beneficiaryDetails.put("date_of_birth", dob);
							beneficiaryDetails.put("mobile", mobileNo);
							beneficiaryDetails.put("e_mail", emailId);

							// Add this beneficiary's details to the beneficiaryDetailsArray
							beneficiaryDetailsArray.put(beneficiaryDetails);
							apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "S");
							apiDetails.put("message", "Success");

						} else {
							apiDetails.put("apiVersion", "v1");
							apiDetails.put("timeStamp", currentTimestamp);
							apiDetails.put("statusCode", "F");
							apiDetails.put("message", "failed");
							result.put("result", "null");
							result.put("apiDetails", apiDetails);
							System.out.println("No valid data object found in the 'data' array.");
						}
					}

					// Add the beneficiaryDetailsArray to the result
					result.put("result", beneficiaryDetailsArray);
					result.put("apiDetails", apiDetails);

				} else {
					apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "F");
					apiDetails.put("message", "failed");
					result.put("result", "null");
					result.put("apiDetails", apiDetails);
					result.put("result", "null");
					result.put("apiDetails", apiDetails);
					System.out.println("No records found");
				}
			} else {
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");
				result.put("result", "null");
				result.put("apiDetails", apiDetails);
				System.out.println("No records found in service");
			}

			// Return the final response with the result
			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return a response with an error status
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

		}
	}
	/*
	 * @POST
	 * 
	 * @Path("/SAVE/{serviceInternalName}")
	 * 
	 * @Produces({ MediaType.APPLICATION_JSON })
	 * 
	 * @Consumes({ MediaType.APPLICATION_JSON }) public Response
	 * DMLSAVE(@PathParam("serviceInternalName") String serviceInternalName,String
	 * inputjson ) { //CommonService objCommonService= new CommonService(); return
	 * objCommonService.DMLSAVE(serviceInternalName, inputjson,moduleName); }
	 */

	@POST
	@Path("/addfamilymember")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addFamilyMember(String filters) {
		System.out.println("inside addfamilymember");

		// System.out.println("iiiinnnn method");
		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		String msg_type = "S";
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			// DEBUG: Print incoming request
			//System.out.println("Incoming Request JSON: " + objFilterJson.toString(4));

			objFilterJson.put("processName", "/parliament/v1/BenDetails/addfamilymember");
		} catch (Exception e) {
			System.out.println("Invalid Request Body: " + e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/addfamilymember";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

			// JSONObject responseJson = new JSONObject(objResponse);

			// DEBUG: Print response from service
			System.out.println("Service Response JSON: " + objResponse.toString(4));
			// Retrieve the message key from the JSON response

			if (objResponse != null) {
				String message = objResponse.getString("message");
				System.out.println("message>>>>>" + message);
				// console.log(message);

				String jsonResponse = message.substring(message.indexOf("{"));

				// Step 2: Parse the JSON string into a JSONObject
				try {

					JSONObject jsonObject = new JSONObject(jsonResponse);

					// DEBUG: Print parsed response object
					System.out.println("Parsed JSON Response: " + jsonObject.toString(4));

					// Step 3: Extract the values of benId and cardNo
					int benId = jsonObject.optInt("benId");
					long cardNo = jsonObject.optLong("cardNo");
					String Name = jsonObject.optString("Depname");
					String msg = jsonObject.optString("message");
					System.out.println("msg---"+msg);
					if(msg.equalsIgnoreCase("MainCardHolder Deleted, Data Not Inserted.")) {
						msg_type = "F";
					}
					//System.out.println("msg_type>>"+msg_type);
					int Relation = jsonObject.optInt("Deprelation");

					Dependentdetails.put("name", Name);
					Dependentdetails.put("benId", benId);
					Dependentdetails.put("relation", Relation);
					Dependentdetails.put("message", msg);
					// Output the extracted values
					// System.out.println("benId: " + benId);
					// System.out.println("cardNo: " + cardNo);

					DependentmemberArray.put(Dependentdetails);
				} catch (Exception e) {
					// Handle errors if JSON parsing fails
					System.out.println("Error parsing JSON: " + e.getMessage());
				}

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				if(msg_type.equalsIgnoreCase("S")) {
				 apiDetails.put("statusCode", "S");
				 apiDetails.put("message", "Success");
				}else {
					apiDetails.put("statusCode", "F");
					 apiDetails.put("message", "Fail");
				}
				result.put("result", DependentmemberArray);
				result.put("apiDetails", apiDetails);

			} else {
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "Failed");
				System.out.println("No Records found");
				result.put("result", "null");
				result.put("apiDetails", apiDetails);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

		// DEBUG: Final response being returned
		System.out.println("Final Response: " + result.toString(4));

		return Response.ok(result.toString()).build();
	}

	@POST
	@Path("/updateBeneficiary")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateBeneficiary(String filters) {

		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			System.out.println("updateBeneficiary-----objFilterJson>>>>>>>: " + objFilterJson);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/updateBeneficiary");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/updateBeneficiary";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			if (objResponse != null) {
				String message = objResponse.getString("message");
				// System.out.println("message>>>>>" + message);

				DependentmemberArray.put(message);

				// Return the message as part of the Response
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "S");
				apiDetails.put("message", "Success");
				result.put("result", DependentmemberArray);
				result.put("apiDetails", apiDetails);
				// return Response.ok(result.toString()).build();
			} else {
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");
				result.put("result", "null");
				result.put("apiDetails", apiDetails);
			}
			return Response.ok(result.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/deleteBeneficiary")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response deleteBeneficiary(String filters) {

		// System.out.println("iiiinnnn method");
		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			String pk0 = (String) objFilterJson.get("ben_id");
			objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/deleteBeneficiary");

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/deleteBeneficiary";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			// System.out.println("objResponseobjResponse>>>>>" + objResponse);
			if (objResponse != null) {
				String message = objResponse.getString("message");
				// System.out.println("message>>>>>" + message);

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "S");
				apiDetails.put("message", "Success");

				DependentmemberArray.put(message);

				// Return the message as part of the Response

				result.put("result", DependentmemberArray);
				result.put("apiDetails", apiDetails);
			} else {
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");
				result.put("result", "null");
				result.put("apiDetails", apiDetails);
			}
			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/deleteAllFamily")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response deleteAllFamily(String filters) {

		// System.out.println("iiiinnnn method");
		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			// String pk0 = (String) objFilterJson.get("mainCardHolderBenId");
			// objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/deleteAllFamily");

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/deleteallfamily";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			// System.out.println("objResponseobjResponse>>>>>" + objResponse);
			if (objResponse != null) {
				String message = objResponse.getString("message");
				// System.out.println("message>>>>>" + message);

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "S");
				apiDetails.put("message", "Success");

				DependentmemberArray.put(message);

				// Return the message as part of the Response

				result.put("result", DependentmemberArray);
				result.put("apiDetails", apiDetails);
			} else {
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");
				result.put("result", "null");
				result.put("apiDetails", apiDetails);
			}
			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/endOfMPtenure")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response endOfMPtenure(String filters) {

		// System.out.println("iiiinnnn method");
		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			// String pk0 = (String) objFilterJson.get("mainCardHolderBenId");
			// objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/nha-tms/v1/BenDetails/endOfMPtenure");

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/EndofMPTenure";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			// System.out.println("objResponseobjResponse>>>>>"+objResponse);

			String message = objResponse.getString("message");
			// System.out.println("message>>>>>"+message);

			DependentmemberArray.put(message);

			// Return the message as part of the Response

			result.put("result", DependentmemberArray);

			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/beneficiaryDetails")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBendtlsEligibility(String filters) {

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject result = new JSONObject();
		JSONObject familyDetails = new JSONObject();
		// JSONArray beneficiaryDetailsArray = new JSONArray();
		JSONObject cardHolderAddress = new JSONObject();
		JSONObject mainCardHolder = new JSONObject();
		JSONObject indexCard = new JSONObject();
		JSONArray members = new JSONArray();
		JSONObject apiDetails = new JSONObject();
		JSONArray resultArray = new JSONArray();
		JSONObject finalResult = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		// String timestamp =
		// LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss
		// zzz yyyy"));

		String nullResult = null;

		// JSONObject apiDetails = new JSONObject();
		// getBenIdWiseDtl
		try {
			objFilterJson = new JSONObject(filters);
			if (objFilterJson.has("benId") == false) {
				return Response.status(Response.Status.BAD_REQUEST).entity(String.format("benId Not valid !")).build();
			}

			String pk0 = (String) objFilterJson.get("benId");
			objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/beneficiaryDetails");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {

			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/beneficiaryDetails";
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);

			// Create the root result object to store the final response

			// First Service: Beneficiary Details (Main Card Holder)
			if (objResponse != null) {
				// Log the objResponse for debugging
				// System.out.println("objResponse >>>>> " + objResponse);

				// Get the "data" array from objResponse
				JSONArray dataArray = objResponse.optJSONArray("data");

				if (dataArray != null && dataArray.length() > 0) {
					// Process main cardholder data
					JSONObject dataObject = dataArray.optJSONObject(0); // Assuming only one main cardholder
					if (dataObject != null) {
						// Extract values
						String address = dataObject.optString("addressline_1");
						String cityCode = dataObject.optString("citycode");
						String pinCode = dataObject.optString("pincode");
						String mobileNo = dataObject.optString("mobileno");
						String district = dataObject.optString("district");
						String emailId = dataObject.optString("emailid");
						String residencePhoneNo = dataObject.optString("residencephoneno");
						String name = dataObject.optString("name");
						String cardType = dataObject.optString("cardtype");
						String relation = dataObject.optString("relation");
						String dob = dataObject.optString("Dob");
						String gender = dataObject.optString("gender");
						String validfrom = dataObject.optString("validfrom");
						String validto = dataObject.optString("validto");
						String deptcode = dataObject.optString("department");
						String zone = dataObject.optString("zone");

						// Set card holder address
						cardHolderAddress.put("address_1", address);
						cardHolderAddress.put("address_2", address); // Assuming same for now
						cardHolderAddress.put("city_code", cityCode);
						cardHolderAddress.put("pin_code", pinCode);
						cardHolderAddress.put("residence_phone_no", residencePhoneNo);
						cardHolderAddress.put("mobile_no", mobileNo);
						cardHolderAddress.put("district", district);
						cardHolderAddress.put("e_mail", emailId);

						// Set main card holder details
						mainCardHolder.put("name", name);
						mainCardHolder.put("card_type", cardType);
						mainCardHolder.put("dispensary_code", "PHA"); // Static value
						mainCardHolder.put("relation", relation);
						mainCardHolder.put("date_of_birth", dob);
						mainCardHolder.put("sex", gender);
						mainCardHolder.put("mobile", mobileNo);
						mainCardHolder.put("e_mail", emailId);

						indexCard.put("valid_from", validfrom);
						indexCard.put("validto", validto);
						indexCard.put("department_code", deptcode);
						indexCard.put("zone", zone);

					}

					apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "S");
					apiDetails.put("message", "Success");

					// Second Service: Family Members' Details
					String strServiceName2 = "service/getBeneficiaryDetailsDependent";
					JSONObject familyDetailsResponse = objUsefulmethods.callService(objFilterJson, strServiceName2);

					if (familyDetailsResponse != null) {
						// Get the "data" array from family details response
						JSONArray familyDataArray = familyDetailsResponse.optJSONArray("data");

						if (familyDataArray != null && familyDataArray.length() > 0) {
							// Loop through family members
							for (int i = 0; i < familyDataArray.length(); i++) {
								JSONObject familyMember = new JSONObject();
								JSONObject familyMemberData = familyDataArray.optJSONObject(i);
								// System.out.println("familyMemberData>>>>>>" + familyMemberData);
								if (familyMemberData != null) {
									// Extract member details
									String benID = familyMemberData.optString("BenId");
									String memberName = familyMemberData.optString("name");
									String gender = familyMemberData.optString("gender");

									String dob = familyMemberData.optString("Dob");
									String relation = familyMemberData.optString("relation");
									String mobile = familyMemberData.optString("mobileno");

									// Create JSON object for each family member

									// System.out.println("memberName>>>>>>" + memberName);
									familyMember.put("benID", benID);
									familyMember.put("name", memberName);
									familyMember.put("sex", gender);
									familyMember.put("date_of_birth", dob);
									familyMember.put("mobile", mobile);
									familyMember.put("relation", relation);

									// Add family member to the members array
									members.put(familyMember);
									// System.out.println("members>>>>>>" + members);
									familyDetails.put("members", members);
								}
							}

							// Add the family members to the familyDetails object

						}
						familyDetails.put("mainCardHolder", mainCardHolder);
						familyDetails.put("members", members);

						result.put("cardHolderAddress", cardHolderAddress);
						result.put("indexCard", indexCard);
						result.put("familyDetails", familyDetails);

						// Final response

						finalResult.put("apiDetails", apiDetails);
						finalResult.put("result", resultArray.put(result));

					}

				} else {

					apiDetails.put("apiVersion", "v1");
					apiDetails.put("timeStamp", currentTimestamp);
					apiDetails.put("statusCode", "F");
					apiDetails.put("message", "failed");
					// System.out.println("no record found");
					finalResult.put("apiDetails", apiDetails);
					finalResult.put("result", "null");
				}
			} else {

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");
				System.out.println("no record found");
				finalResult.put("apiDetails", apiDetails);
				finalResult.put("result", "null");
			}

			return Response.ok(finalResult.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/updateDispensaryCode")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateDispensaryCode(String filters) {

		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			// String pk0 = (String) objFilterJson.get("mainCardHolderBenId");
			// objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/nha-tms/v1/BenDetails/updateDispensaryCode");

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/UpdateDispensaryCodePHA";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			// System.out.println("objResponseobjResponse>>>>>"+objResponse);

			String message = objResponse.getString("message");
			// System.out.println("message>>>>>"+message);

			DependentmemberArray.put(message);

			// Return the message as part of the Response

			result.put("result", DependentmemberArray);

			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/insertcghscard")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response insertCghsCard(String filters) {
		System.out.println("called insertcghscard");

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject apiDetails = new JSONObject();
		JSONObject finalResult = new JSONObject();
		JSONObject finalResponse = new JSONObject();
		JSONArray resultArray = new JSONArray();
		// String timestamp =
		// LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss
		// zzz yyyy"));
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object
			
			System.out.println("InsertCghsCard objFilterJson>>>>>>>: " + objFilterJson.toString(4));
			objFilterJson.put("processName", "/parliament/v1/BenDetails/insertcardParliament");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {

			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/insertcardParliament";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			if (objResponse != null) {
				// String message = objResponse.getString("message");
				// String timestamp =
				// LocalDateTime.now().format(DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss
				// zzz yyyy"));

				System.out.println("objResponse>>>>>>>>>>" + objResponse);
				String message = objResponse.getString("message");
				System.out.println("message>>>>>>>>>>>" + message);
				// Create the response object for card insertion/updation
				String jsonString = message.split(":", 2)[1].trim();

				// Step 2: Parse the remaining JSON string
				JSONObject jsonObject = new JSONObject(jsonString);

				// Step 3: Extract values from the parsed JSON
				String cardInsertionUpdationResponse = jsonObject.getString("cardInsertionUpdationResponse");
				long benId = jsonObject.getLong("ben_id");
				long cardNo = jsonObject.getLong("card_no");
				long skipped_member_count = jsonObject.getLong("skipped_member_count");
				String skipped_member_message = jsonObject.getString("skipped_member_message");
				JSONObject cardInsertionResponse = new JSONObject();
				cardInsertionResponse.put("cardInsertionUpdationResponse", cardInsertionUpdationResponse);
				cardInsertionResponse.put("ben_id", benId);
				cardInsertionResponse.put("card_no", cardNo);
				cardInsertionResponse.put("card_no", cardNo);
				cardInsertionResponse.put("skipped_member_count", skipped_member_count);
				cardInsertionResponse.put("skipped_member_message", skipped_member_message);

				// Add the response object to the result array
				resultArray.put(cardInsertionResponse);

				// Create the final response object to wrap the result array

				finalResponse.put("result", resultArray);

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "S");
				apiDetails.put("message", "Success");

				finalResponse.put("apiDetails", apiDetails);
				// Return the response
				return Response.ok(finalResponse.toString()).build();

			} else {

				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", "failed");

				finalResponse.put("apiDetails", apiDetails);
				// Return the response
				return Response.ok(finalResponse.toString()).build();
				// return Response.status(Response.Status.NO_CONTENT).entity("No data received
				// from the service").build();

			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/markDeathMaincardHolder")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response markDeathMaincardHolder(String filters) {

		JSONArray DependentmemberArray = new JSONArray();
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		// JSONObject Dependentdetails = new JSONObject();
		JSONObject result = new JSONObject();
		try {

			objFilterJson = new JSONObject(filters);
			// Extract values from the "indexCard" object

			// String pk0 = (String) objFilterJson.get("mainCardHolderBenId");
			// objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/markDeathMaincardHolder");

		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName1 = "service/markDeathMaincardHolder";
			// String inputJson = objFilterJson.toString();

			// Pass the inputJson as a parameter to callService
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);
			// System.out.println("objResponseobjResponse>>>>>" + objResponse);

			String message = objResponse.getString("message");
			// System.out.println("message>>>>>" + message);

			DependentmemberArray.put(message);

			// Return the message as part of the Response

			result.put("result", DependentmemberArray);

			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service !"))
					.build();
		}

	}

	@POST
	@Path("/getBeneficiaryCard")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getanyBeneficiaryDetails(String filters) { //System.out.println("inside getBeneficiaryCard");

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject result = new JSONObject();

		// getBenIdWiseDtl
		try {
			objFilterJson = new JSONObject(filters);
			 //System.out.println("objFilterJson>>>>"+objFilterJson);
			if (objFilterJson.has("benId") == false) {
				return Response.status(Response.Status.BAD_REQUEST).entity(String.format("benId Not valid !")).build();
			}

			String pk0 = (String) objFilterJson.get("benId");
			objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/parliament/v1/BenDetails/getBeneficiaryCard");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {

			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/getmaincardholderdetails";

			// Call the service and get the response
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
			String filePath = "";
			String osType = System.getProperties().getProperty("os.name");
			//System.out.println("osType---"+osType);

			if (osType.startsWith("Win")) {
				filePath = "C:/CGHS/FileHandling/CardManagement/";
			} else {
				filePath = "/opt/Arunachal_PHDM/FileHandling/prescriptions/";
			}
			String pdfbase64 = null;

			// Check if objResponse is not null
			if (objResponse != null) {
				// Log the objResponse for debugging
				 System.out.println("objResponse >>>>> " + objResponse);

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
							// String BeneficiaryId = dataObject.optString("BenId"); // Example field
							// String cardno = dataObject.optString("cardno");
							String cardType = dataObject.optString("gstr_cardtype_name");

							String name = dataObject.optString("FirstName");
							String dob = dataObject.optString("DOB");
							String BenId = dataObject.optString("BenId");
							String gender = dataObject.optString("gender");
							String Entitlement = dataObject.optString("gnum_short_nm");
							String hindientitlement = dataObject.optString("gstr_entitlement_hindi");
							String validto = dataObject.optString("validto");
							String hindicardtype = dataObject.optString("gstr_card_hindi_name");
							String base64Imagefront = dataObject.optString("card_front_header_base64");
							String base64Imageback = dataObject.optString("card_back_base64");
							String relationname = dataObject.optString("gstr_relation_name");
							String cardvalidto = dataObject.optString("validupto");
							String Photonamedep = dataObject.optString("photo");
							String facility = dataObject.optString("gstr_fma_facility");
							// String color="red";
							// String Photonamedep="10013585.jpg";
							// System.out.println("PhotonamedepPhotonamedep>>>>>>>"+Photonamedep);
							String Photonamedepbase64 = getImageAsBase64(Photonamedep);
							// System.out.println("Photonamedepbase64>>>>>>>"+Photonamedepbase64);
							// filePath = filePath + crNo.replace("/", "-") + "_"+episodeCode+"_"+visitNo+
							// ".pdf";
							filePath = filePath + BenId + ".pdf";
							// Initialize a StringBuilder to construct the HTML content

							// String imagebase64=dataObject.optString("photo");

							// String data = "BenId: " +2025+ BenId;

							// System.out.println("imagebase64>>>>>>"+imagebase64);

							String data = "BenId: " + BenId + ", Name: " + name + ", gender: " + gender;

							// Generate the QR code image and get the Base64 string
							String base64QRCode = generateQRCodeBase64(data, 350, 350);

							String base64QRCodefinal = "data:image/png;base64," + base64QRCode;

							// Create HTML string with Base64 QR code embedded inside a div
							/*
							 * String htmlContent = "<div id='qrCodeDiv'>" +
							 * "<img id='qrCodeImage' src='data:image/png;base64," + base64QRCode +
							 * "' alt='QR Code' />" + "</div>";
							 */

							// Print or return the HTML content
							// System.out.println(base64QRCode);

							StringBuilder htmlContent = new StringBuilder();
							htmlContent.append(
									"<div class=\"card cghs-card\" id='cghsCard' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px;; 	border: 1px solid #000;  background-image: url(\"data:image/png;base64,"
											+ base64Imagefront
											+ "\"); background-size: cover; background-position: center;'>")
									.append("<div class=\"card-body\">").append("<div class=\"card-content\">")
									.append("<div class=\"card-image\"  style=\"\">")

									.append("<img id=\"photo\" src=\"data:image/png;base64," + Photonamedepbase64
											+ "\" alt=\"Profile Photo\" style=\"border-radius: 10px; margin-right: 15px; margin-top: 100px; height: 100px; width: 80px; object-fit: cover; border:1px solid #ddd9d9 !important;\">")
									.append("</div>")
									.append("<div class=\"\" style=\"margin-top: -109px;margin-left: 127px;  flex-grow: 1;\">")
									.append("<table>").append("<tr>")
									.append("<td style='width:40%; font-size: small; padding:5px; color:#1F6780;font-weight: bold; text-transform: capitalize; letter-spacing: 0.040rem; white-space: nowrap;'>")
									.append("<p style='margin: 0; padding: 0; text-align:left;'>")
									.append("NAME: " + name).append("</p>")
									.append("<p style='margin: 0; padding: 0;'>DOB/GENDER: " + dob + "/" + gender
											+ "</p>")
									.append("<p class=\"card-text\" style='margin: 0; padding: 0;'>CATEGORY: "
											+ cardType + " / " + hindicardtype + "</p>")
									.append("<p style='margin: 0; padding: 0;'>RELATION: " + relationname + "</p>")
									.append("<p style='margin: 0; padding: 0;'>FACILITY: " + facility + "</p>")
									.append("<p style='margin: 0; padding: 0;'>ENTITLEMENT: " + Entitlement + "</p>")
									.append("<p style='margin: 0; padding: 0;'>VALID UPTO: " + cardvalidto + "</p>")
									.append("</td>")

									.append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCode\"><img src='"
											+ base64QRCodefinal
											+ "' alt='QR Code' style='width: 100px; height: 100px;'/></td>")
									.append("</tr>").append("<tr>")
									.append("<td colspan=\"2\" style=\"text-align: right; padding-right: 18px; padding-top: 61px;letter-spacing: 0.040rem;font-weight: bold;\">&#x928;&#x93F;&#x930;&#x94D;&#x926;&#x947;&#x936;&#x915;/Director</td>")
									.append("</tr>").append("</table>")
									.append("<div style='margin-top: -27px;margin-left: -118px; font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "
											+ BenId + " </div>")
									.append("</div>").append("</div>").append("</div>").append("</div>")
									.append("</div>")
									.append("<div class=\"card cghs-card\" id='cghsCardBack' style='background-repeat: no-repeat;  border-radius: 8px;  border: 1px solid #ddd;   margin: 20px auto;  height: 300px; width: 500px; 	border: 1px solid #000; background-image: url(\"data:image/png;base64,"
											+ base64Imageback
											+ "\"); background-size: cover; background-position: center;'>")
									.append("<div class=\"card-body\">").append("<div class=\"card-content\">")
									.append("<div class=\"card-details\" style=\"margin-top: 76px;\">")
									.append("<table>").append("<tr>")
									.append("<td style=\"width: 30%; text-align: right; padding-left: 15px;\" id=\"qrCodeBack\"></td>")
									.append("<td style='width:70%; padding:5px;color:#1F6780;font-weight: bold; text-transform: capitalize;letter-spacing: 0.040rem;'>")
									.append("</td>").append("</tr>").append("</table>")
									.append("<div style='margin-top: 168px;margin-left: 9px;font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : "
											+ BenId + " </div>")
									.append("</div>").append("</div>").append("</div>").append("</div>");
							htmlContent.append("</body>");
							htmlContent.append("</html>");

							try {
								// System.out.println("before convert?>>> ");
								HtmlToPdfConvertor.convert(htmlContent.toString(), filePath);
								// System.out.println("after convert?>>> ");
								pdfbase64 = HtmlToPdfConvertor.convertPDFToBase64(filePath);
								// System.out.println("pdfbase64>>>" + pdfbase64);
								String finalHTML = htmlContent.toString();
								/*
								 * System.out.println(finalHTML); System.out.println(base64QRCode);
								 * System.out.println("Photonamedepbase64>>>>>>>"+Photonamedepbase64); S
								 * System.out.println("base64Imageback>>>>>>>>>"+base64Imageback);
								 */
								// return pdfbase64;
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							// Create a new JSONObject to store the beneficiary details

							// Add this beneficiary's details to the beneficiaryDetailsArray
							// beneficiaryDetailsArray.put(beneficiaryDetails);
						} else {
							System.out.println("No valid data object found in the 'data' array.");
						}
					}

					// Add the beneficiaryDetailsArray to the result
					result.put("result", pdfbase64);
				} else {
					System.out.println("'data' array is empty or null.");
				}
			}

			// Return the final response with the result

			return Response.ok(result.toString()).build();

		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();

			// Return a response with an error status
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Problem in service!").build();

		}
	}

	@POST
	@Path("/uploadImage")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces({ MediaType.APPLICATION_JSON })
	/*
	 * public Response uploadFile(@Context HttpServletRequest
	 * request, @FormParam("benId") String benId) {
	 * 
	 * 
	 * //System.out.println("inside upload image"); //
	 * System.out.println("benId from @FormParam----" + benId);
	 * //System.out.println("request----"+request);
	 * 
	 * if (!ServletFileUpload.isMultipartContent(request)) { return
	 * Response.status(Response.Status.BAD_REQUEST).entity("Invalid form data").
	 * build(); }
	 * 
	 * try { DiskFileItemFactory factory = new DiskFileItemFactory();
	 * ServletFileUpload upload = new ServletFileUpload(factory);
	 * 
	 * List<FileItem> items = upload.parseRequest(request);
	 * 
	 * File uploadedFile = null;
	 * 
	 * for (FileItem item : items) {
	 * System.out.println("item name ---"+item.getName()); if (!item.isFormField())
	 * { uploadedFile = new File("e:/uploads/" + item.getName());
	 * item.write(uploadedFile); } }
	 * 
	 * for (FileItem item : items) { // System.out.println("item name ---" +
	 * item.getFieldName()); // Print the field name if (item.isFormField()) { //
	 * System.out.println("Form field name: " + item.getFieldName() + ", value: " +
	 * item.getString()); if ("benId".equals(item.getFieldName())) { benId =
	 * item.getString(); // Manually assign benId from form field } } else {
	 * //uploadedFile = new File("e:/uploads/" + item.getName()); uploadedFile = new
	 * File("d:/uploads/" + item.getName()); item.write(uploadedFile); } }
	 * 
	 * System.out.println("benId after processing form: " + benId); // Check benId
	 * value after form processing System.out.println("uploadedFile----" +
	 * uploadedFile);
	 * 
	 * if (benId == null || uploadedFile == null) { return
	 * Response.status(Response.Status.BAD_REQUEST).entity("Missing form data").
	 * build(); }
	 * 
	 * String responseMessage = "File uploaded successfully. benId: " + benId;
	 * return Response.status(Response.Status.OK).entity(responseMessage).build();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); return
	 * Response.status(Response.Status.INTERNAL_SERVER_ERROR).
	 * entity("Error uploading file").build(); } }
	 */
	
	public Response uploadFile(@Context HttpServletRequest request) { System.out.println("request---"+request);
    if (!ServletFileUpload.isMultipartContent(request)) {
        return Response.status(Response.Status.BAD_REQUEST).entity("Invalid form data").build();
    }
    JSONObject objFilterJson=null;
     objFilterJson = new JSONObject();
    JSONObject objResponse = new JSONObject();
    FTPClient ftpClient = new FTPClient();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String responseMessage="";
    JSONObject apiDetails = new JSONObject();
    JSONObject result = new JSONObject();
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String currentTimestamp = currentDateTime.format(formatter);
    String remoteFilePath = "";
    String workingDirectory = "";
    try {
        // Retrieve FTP server credentials from XML configuration
        String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
        String server = ftpUrl.split("@")[1];  // FTP server address

        // FTP credentials
        String ftpUser = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
        String ftpPass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

        // Connect to FTP server
        ftpClient.connect(server, 21); // Default FTP port 21
        if (!ftpClient.isConnected()) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Failed to connect to FTP server").build();
        }

        ftpClient.login(ftpUser, ftpPass);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Set binary mode for file transfer
        ftpClient.enterLocalPassiveMode(); // Set passive mode for FTP

        // Check FTP server response code after login
        int replyCode = ftpClient.getReplyCode();
        if (!FTPReply.isPositiveCompletion(replyCode)) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("FTP login failed, reply code: " + replyCode).build();
        }

        List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        String benId = null;
        String folderName = "CGHS_PROFILE_PICS";  // Folder name for the file upload

        for (FileItem item : items) {
            if (item.isFormField()) {
                // Extract benId from form field
                if ("benId".equals(item.getFieldName())) {
                    benId = item.getString();
                }
            } else {
                // Prepare file for upload
                String fileName = item.getName();
       
                String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

                // Validate file type (only allow jpg)
                if (!"jpg".equals(fileExtension)) {
                	
                	responseMessage = "File is not image type";
              	  apiDetails.put("apiVersion", "v1");
  	               apiDetails.put("timeStamp",currentTimestamp);
  	                apiDetails.put("statusCode", "F");
  	                apiDetails.put("message", responseMessage);
  	                result.put("result", "null");
	                  result.put("apiDetails", apiDetails);
	                  return Response.ok(result.toString()).build();
                    //return Response.status(Response.Status.BAD_REQUEST) .entity("Only .jpg files are allowed.").build();
                }
                
                try {
                    //   String pk0 = (String) objFilterJson.get("fileName");
                    
                       objFilterJson.put("benId", benId);
                       objFilterJson.put("processName", "/parliament/v1/BenDetails/getHospShortName");//proc_HospShortName
                   } catch (Exception e) {
                       return Response.status(Response.Status.BAD_REQUEST)
                                      .entity("Please provide valid request body1!")
                                      .build();
                   }
                
                String strServiceNamecode = "service/getHospShortName";
                // Call the service and get the response
                Usefulmethods objUsefulmethods1 = new Usefulmethods();
                objResponse = objUsefulmethods1.callService(objFilterJson, strServiceNamecode);
                try {
                	
                     System.out.println("objResponse---in uppload image---"+objResponse);
                     
                     if (objResponse != null) {
                    	 String message = objResponse.getString("message");
         				System.out.println("message>>>>>" + message);
         				 remoteFilePath = "/FTP/" + folderName + "/" + fileName;  // Construct remote file path
                         workingDirectory = "/FTP/" + folderName;
                    	 
                     }
                	
                }catch (Exception e) {
                    e.printStackTrace();
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                   .entity("Error reading uploaded file").build();
                }
                

                // Get InputStream directly from the FileItem
                
                try (InputStream fileInputStream = item.getInputStream()) {

                    // Check if the folder exists on the FTP server
                    boolean folderExists = ftpClient.changeWorkingDirectory(workingDirectory);
                    if (!folderExists) {
                        System.out.println("Folder does not exist, attempting to create: " + workingDirectory);
                        boolean folderCreated = ftpClient.makeDirectory("/" + folderName);
                        if (!folderCreated) {
                        	
                            //return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to create folder on FTP server").build();
                        }
                    }

                    // Upload file to FTP server
                    boolean success = ftpClient.storeFile(remoteFilePath, fileInputStream);

                    // Check FTP upload success
                    if (!success) {
                        int uploadReplyCode = ftpClient.getReplyCode();
                        
                        responseMessage="Failed to upload file to FTP server.";
                     //   return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to upload file to FTP server. FTP reply code: " + uploadReplyCode).build();
                        result.put("result", responseMessage);
                    } else {
                        // If the file upload is successful, execute the database update query
                        objFilterJson = new JSONObject();
                        objFilterJson.put("fileName", fileName);

                        if (!objFilterJson.has("fileName")) {
                            return Response.status(Response.Status.BAD_REQUEST)
                                           .entity("benId Not valid !")
                                           .build();
                        }

                        try {
                         //   String pk0 = (String) objFilterJson.get("fileName");
                            objFilterJson.put("pk0", fileName);
                            objFilterJson.put("benId", benId);
                            objFilterJson.put("processName", "/parliament/v1/BenDetails/updatephotofilename");
                        } catch (Exception e) {
                            return Response.status(Response.Status.BAD_REQUEST)
                                           .entity("Please provide valid request body2!")
                                           .build();
                        }

                        try {
                            String strServiceName = "service/updatephotofilename";
                            // Call the service and get the response
                            Usefulmethods objUsefulmethods = new Usefulmethods();
                            objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
                                    System.out.println("objResponse>>>>>>>"+objResponse);
                                    
                                    if (objResponse != null) {
                                     
                                        System.out.println("objResponse>>>>>>>>>>"+objResponse);
                                         responseMessage = objResponse.getString("message");
                                        System.out.println("message>>>>>>>>>>>"+responseMessage);
                                        apiDetails.put("apiVersion", "v1");
 		            	               apiDetails.put("timeStamp",currentTimestamp);
 		            	                apiDetails.put("statusCode", "S");
 		            	                apiDetails.put("message", "Success");
 		            	                result.put("result", responseMessage);
 					                    result.put("apiDetails", apiDetails);
                                    }else
                                    {
                                    	  responseMessage = "Not updated";
                                    	  apiDetails.put("apiVersion", "v1");
    		            	               apiDetails.put("timeStamp",currentTimestamp);
    		            	                apiDetails.put("statusCode", "F");
    		            	                apiDetails.put("message", "Failed");
    		            	                result.put("result", responseMessage);
    					                    result.put("apiDetails", apiDetails);
                                    	  
                                    }
                          
                        } catch (Exception e) {
                            e.printStackTrace();
                            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                           .entity("Error reading uploaded file").build();
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                    return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                                   .entity("Error Inputstream file").build();
                }
            }
        }

        // If benId is missing
        if (benId == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Missing benId form data").build();
        }

        //String responseMessage = "File uploaded successfully to FTP. benId: " + benId;
       return Response.ok(result.toString()).build();
     //   return Response.status(Response.Status.OK).entity(result).build();

    } catch (Exception e) {
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                       .entity("Error uploading file to FTP").build();
    } finally {
        // Disconnect from FTP server
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

	@POST
	@Path("/gettestimg")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String getImageAsBase64New(String filters) {

		JSONObject objFilterJson = null;

		objFilterJson = new JSONObject(filters);

		if (objFilterJson.has("filename") == false) {
			return "filename Not valid !";
		}

		String strFileName = (String) objFilterJson.get("filename");

		URL urlftp = null;
		URLConnection urlc = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String base64Image = null;
		String folderName = "CGHS_PROFILE_PICS";
		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
		InputStream inputStream = null;
		try {
			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
			urlc = urlftp.openConnection();
			inputStream = urlc.getInputStream();
			// System.out.println("inputStreaminputStreaminputStream"+inputStream) ;
			if (inputStream != null) {
				// System.out.println("inputStreamiiii");
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				// Convert the image bytes to Base64
				base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());

				inputStream.close();

			} else {
				System.out.println("Failed to retrieve file: " + ftpUrl + "/" + folderName + "/" + strFileName);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {

					inputStream.close();
					inputStream = null;

				}

				urlftp = null;
				urlc = null;

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return base64Image;
	}

	public static String getImageAsBase64(String strFileName) {
		// System.out.println("strFileName>>>>>>>>>>"+strFileName);
		URL urlftp = null;
		URLConnection urlc = null;
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		String base64Image = null;
		String folderName = "CGHS_PROFILE_PICS";
		String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
		InputStream inputStream = null;
		try {
			urlftp = new URL(ftpUrl + "/" + folderName + "/" + strFileName);
			urlc = urlftp.openConnection();
			inputStream = urlc.getInputStream();
			// System.out.println("inputStreaminputStreaminputStream"+inputStream);
			if (inputStream != null) {
				// System.out.println("inputStreamiiii");
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}

				// Convert the image bytes to Base64
				base64Image = Base64.getEncoder().encodeToString(outputStream.toByteArray());

				inputStream.close();

			} else {
				System.out.println("Failed to retrieve file: " + ftpUrl + "/" + folderName + "/" + strFileName);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {

					inputStream.close();
					inputStream = null;

				}

				urlftp = null;
				urlc = null;

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return base64Image;
	}

	public static String generateQRCodeBase64(String data, int width, int height) throws WriterException, IOException {
		// Set encoding parameters (error correction level and character encoding)
		Hashtable<EncodeHintType, Object> hintMap = new Hashtable<>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L); // Low error correction level
		hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8"); // Character set

		// Generate the QR code as a BitMatrix
		BitMatrix bitMatrix = new MultiFormatWriter().encode(data, BarcodeFormat.QR_CODE, width, height, hintMap);

		// Convert the BitMatrix to a BufferedImage

		BufferedImage image = toBufferedImage(bitMatrix);

		// Convert BufferedImage to Base64 string
		return imageToBase64(image);
	}

	// Method to convert the BitMatrix to a BufferedImage
	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		// Set pixels to black or white depending on BitMatrix values
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				image.setRGB(x, y, matrix.get(x, y) ? 0x000000 : 0xFFFFFF); // Black for true, White for false
			}
		}

		return image;
	}

	// Method to convert BufferedImage to Base64 string
	private static String imageToBase64(BufferedImage image) throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ImageIO.write(image, "PNG", byteArrayOutputStream); // Write the image as PNG
		byte[] imageBytes = byteArrayOutputStream.toByteArray();
		return Base64.getEncoder().encodeToString(imageBytes); // Convert the byte array to Base64
	}

	@POST
	@Path("/getconvertimageBase64tofile")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response convertBase64ToImage(String filters) {
		JSONObject objFilterJson = new JSONObject(filters);

		// Check if "Base64imagefile" and "benid" are present in the input JSON
		if (!objFilterJson.has("Base64imagefile") || !objFilterJson.has("benid")) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("{\"message\": \"Base64imagefile or benid Not found!\"}").build();
		}

		String base64String = objFilterJson.getString("Base64imagefile");
		String benIdvalue = objFilterJson.getString("benid");
		String UserIdvalue = objFilterJson.getString("useridvalue");
		// System.out.println("base64String>>>>>>>>>>"+base64String);
		// System.out.println("benIdvalue>>>>>>>>>>"+benIdvalue);
		// System.out.println("UserIdvalue>>>>>>>>>>"+UserIdvalue);

		// Remove the "data:image/png;base64," prefix if it exists
		if (base64String != null && base64String.startsWith("data:image")) {
			base64String = base64String.split(",")[1]; // Split the string and take the part after the comma
		}

		String outputPath = benIdvalue + ".jpg"; //

		try {
			// Decode the Base64 string into a byte array
			byte[] imageBytes = Base64.getDecoder().decode(base64String);

			// Create a File object where the image will be saved
			File outputFile = new File(outputPath);

			// Write the decoded bytes to the file
			try (FileOutputStream fos = new FileOutputStream(outputFile)) {
				fos.write(imageBytes);
			}

			boolean b = uploadFileOnFtp(outputFile, benIdvalue, UserIdvalue);
			if (b) {
				return Response.status(Response.Status.OK)
						.entity("{\"status\": \"success\", \"filePath\": \"" + outputFile.getPath() + "\"}").build();
			} else {
				return Response.status(Response.Status.OK)
						.entity("{\"status\": \"failed\", \"filePath\": \"" + outputFile.getPath() + "\"}").build();
			}

		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity("{\"status\": \"error\", \"message\": \"Failed to convert base64 to image.\"}").build();
		}
	}

	public static boolean uploadFileOnFtp(File file, String benId, String UserIdvalue) {
		try {
			if (file != null && file.exists()) {
				// Create FileInputStream from the image file
				try (FileInputStream fileInputStream = new FileInputStream(file)) {
					// Get the file name (you can use imageFile.getName() or customize it)
					String fileName = file.getName();
					// System.out.println("fileName: " + fileName);
					// Call the uploadFile method with FileInputStream and other data
					Response response1 = uploadFile(benId, new FileInputStream(file), fileName, UserIdvalue);

					// Handle the response (you can log or process it as needed)
					// System.out.println("Upload response: " + response1.getStatus());
					return true;
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("Error opening file input stream for image.");
					return false;
				}
			} else {
				System.out.println("Failed to create the image file from Base64 string.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public static Response uploadFile(String benId, InputStream fileInputStream, String fileName, String UserIdvalue) {
		JSONObject objResponse = new JSONObject();
		FTPClient ftpClient = new FTPClient();
		String responseMessage = "";
		JSONObject apiDetails = new JSONObject();
		JSONObject result = new JSONObject();
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTimestamp = currentDateTime.format(formatter);

		try {
			// Retrieve FTP server credentials from XML configuration
			String ftpUrl = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_URL");
			String server = ftpUrl.split("@")[1]; // FTP server address

			// FTP credentials
			String ftpUser = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_USERNAME");
			String ftpPass = HisUtil.getParameterFromHisPathXML("HIS_FTPSERVER_PASSWORD");

			// Connect to FTP server
			ftpClient.connect(server, 21); // Default FTP port 21
			if (!ftpClient.isConnected()) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Failed to connect to FTP server")
						.build();
			}

			ftpClient.login(ftpUser, ftpPass);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // Set binary mode for file transfer
			ftpClient.enterLocalPassiveMode(); // Set passive mode for FTP

			// Check FTP server response code after login
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
						.entity("FTP login failed, reply code: " + replyCode).build();
			}

			String folderName = "CGHS_PROFILE_PICS"; // Folder name for the file upload
			String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();

			// Validate file type (only allow jpg)
			if (!"jpg".equals(fileExtension)) {
				responseMessage = "File is not image type";
				apiDetails.put("apiVersion", "v1");
				apiDetails.put("timeStamp", currentTimestamp);
				apiDetails.put("statusCode", "F");
				apiDetails.put("message", responseMessage);
				// result.put("result", "null");
				// result.put("apiDetails", apiDetails);
				result.put("result", responseMessage);
				return Response.ok().build();
			}

			String remoteFilePath = "/FTP/" + folderName + "/" + fileName; // Construct remote file path
			String workingDirectory = "/FTP/" + folderName;

			// Check if the folder exists on the FTP server
			boolean folderExists = ftpClient.changeWorkingDirectory(workingDirectory);
			if (!folderExists) {
				System.out.println("Folder does not exist, attempting to create: " + workingDirectory);
				boolean folderCreated = ftpClient.makeDirectory("/" + folderName);
				if (!folderCreated) {
					// Handle folder creation failure
				}
			}

			// Upload file to FTP server
			boolean success = ftpClient.storeFile(remoteFilePath, fileInputStream);

			// Check FTP upload success
			if (!success) {
				int uploadReplyCode = ftpClient.getReplyCode();
				responseMessage = "Failed to upload file to FTP server.";
				result.put("result", responseMessage);
			} else {
				// If the file upload is successful, execute the database update query
				JSONObject objFilterJson = new JSONObject();
				objFilterJson.put("fileName", fileName);
				objFilterJson.put("benId", benId);
				objFilterJson.put("UserIdvalue", UserIdvalue);

				objFilterJson.put("processName", "/parliament/v1/BenDetails/updatephotofilename");
				String strServiceName = "service/updatephotofilename";
				Usefulmethods objUsefulmethods = new Usefulmethods();
				objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
				// System.out.println("objResponse>>>>>>>"+objResponse);

				if (objResponse != null) {

					// System.out.println("objResponse>>>>>>>>>>"+objResponse);
					responseMessage = objResponse.getString("message");

					// result.put("result", responseMessage);
					// result.put("apiDetails", apiDetails);
				} else {
					responseMessage = "Name Not updated";

					result.put("result", responseMessage);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error uploading file to FTP").build();
		} finally {
			// Disconnect from FTP server
			if (ftpClient.isConnected()) {
				try {
					ftpClient.logout();
					ftpClient.disconnect();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return Response.ok(result.toString()).build();
	}
	
	
	
	//calculate age
		private static int calculateAge(String dobString) {
			// Define the formatter for the date format "dd-MMM-yyyy"
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			// Parse the DOB string to a LocalDate object
			LocalDate dob = LocalDate.parse(dobString, formatter);

			// Get the current date
			LocalDate currentDate = LocalDate.now();

			// Calculate the period between the DOB and current date
			Period period = Period.between(dob, currentDate);

			// Return the age (in years)
			return period.getYears();
		}


}
