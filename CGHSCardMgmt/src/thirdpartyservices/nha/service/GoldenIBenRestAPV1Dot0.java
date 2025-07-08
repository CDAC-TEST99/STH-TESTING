package thirdpartyservices.nha.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;
import thirdpartyservices.cardapi.CghsCardApi;
import thirdpartyservices.nha.ben.model.Address;
import thirdpartyservices.nha.ben.model.BeneficiaryDetails;
import thirdpartyservices.nha.ben.model.FamilyItem;
import thirdpartyservices.nha.ben.model.FamilyMemberItem;
import thirdpartyservices.nha.ben.model.FamilySearchDetails;
import thirdpartyservices.nha.ben.model.Header;
import thirdpartyservices.nha.ben.model.NHABenRequest;
import thirdpartyservices.nha.ben.model.NHABenResponse;
import thirdpartyservices.nha.ben.model.RationCardDetails;

@Path("/nha/tms/v1.0/benificary")
public class GoldenIBenRestAPV1Dot0 {

	@POST
	@Path("/details")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBeneficiaryDetails(NHABenRequest nhaBenRequest) {
		NHABenResponse nhaBenResponse = new NHABenResponse();
		//System.out.println("BenGoldenV1RestAPI-->>getBeneficiaryDetails method-->>" + nhaBenRequest.toString());
		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject familydetails = new JSONObject();

		String uuidReq = nhaBenRequest.getBeneficiaryDetails().getUuid();
		String hhidReq = nhaBenRequest.getBeneficiaryDetails().getHhId();
		String mobileNumberReq = nhaBenRequest.getBeneficiaryDetails().getMobileNumber();
		String regex = "\\d+";

		
		String uuid = (StringUtils.isNotBlank(uuidReq) ? uuidReq : hhidReq);
		if (StringUtils.isBlank(uuid) || !uuid.matches(regex)) {
			nhaBenResponse.setStatus(Boolean.FALSE);
			nhaBenResponse.setOperation(StringUtils.EMPTY);
			nhaBenResponse.setErrorcode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
			nhaBenResponse.setErrorMessage("uuid/hhid Not valid!");
			return Response.status(Response.Status.BAD_REQUEST).entity(nhaBenResponse).build();
		}

		objFilterJson = new JSONObject();
		objFilterJson.put("uuid", uuid);
		objFilterJson.put("mobileNumber", mobileNumberReq);
		objFilterJson.put("processName", "/nha/tms/v1.0/benificary/getNhaBeneficiarydetails");

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();

			// Fetch Beneficiary Details
			String strServiceName1 = "service/getNhaBeneficiarydetails";
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

			//System.out.println("objResponse>>>>> " + objResponse);
			// Get the "data" array from objResponse
			JSONArray dataArray = objResponse.optJSONArray("data");
			//System.out.println("length od dataArray----"+dataArray.length());
			// Check if objResponse is not null
			if (objResponse == null || dataArray.length() <= 0) {
				nhaBenResponse.setStatus(Boolean.FALSE);
				nhaBenResponse.setOperation(StringUtils.EMPTY);
				nhaBenResponse.setErrorcode(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()));
				nhaBenResponse.setErrorMessage("The CGHS ID provided is either incorrect, does not exist, or does not belong to the Pensioner, Ex-MP or Freedom Fighter Card Category. Please check and try again! In case the error persists. Please ask beneficiary to Contact Card Section of CGHS");
				return Response.status(Response.Status.NOT_FOUND).entity(nhaBenResponse).build();

			}

			// Get the JSONObject at the current index 'i'
			JSONObject dataObject = dataArray.optJSONObject(0);

			// Check if the JSONObject is not null
			if (dataObject != null) { //System.out.println("inside data exist");
				// Log the objResponse for debugging
				nhaBenResponse.setStatus(Boolean.TRUE);
				nhaBenResponse.setOperation(StringUtils.EMPTY);
				nhaBenResponse.setErrorcode(String.valueOf(Response.Status.OK.getStatusCode()));
				nhaBenResponse.setErrorMessage("SUCCESS!");

				Header header = Header.builder()
						.version(NHAConstants.version)
						.errorCode(StringUtils.EMPTY)
						.build();
				nhaBenResponse.setHeader(header);

				BeneficiaryDetails beneficiaryDetails = BeneficiaryDetails.builder()
						.ahlTinId(StringUtils.EMPTY)
						.uuid(StringUtils.isNotBlank(uuidReq) ? uuidReq : StringUtils.EMPTY )
						.hhId(StringUtils.isNotBlank(hhidReq) ? hhidReq : StringUtils.EMPTY )
						.mobileNumber(getNotNullValue(mobileNumberReq))
						.aadharToken(StringUtils.EMPTY)
						.familyType(dataObject.optString("cardtype"))
						.healthId(dataObject.optString("cardNo"))
						.rationCardDetails(
								RationCardDetails.builder()
								.rationCard(StringUtils.EMPTY)
								.stateCode(NHAConstants.stateCode)
								.build())
						.build();

				String benType = dataObject.optString("benType");
				String wardId = dataObject.optString("wardId");
				header.setBeneficiaryDetails(beneficiaryDetails);

				FamilySearchDetails details = FamilySearchDetails.builder().build();
				nhaBenResponse.setFamilySearchDetails(details);
				List<FamilyItem> listFamilyItems = new ArrayList<FamilyItem>();
				details.setFamily(listFamilyItems);

				// Fetch family members' details
				String strServiceName2 = "service/getNhaBeneficiaryFamilydetails";
				familydetails = objUsefulmethods.callService(objFilterJson, strServiceName2);

				if (familydetails != null) {
					JSONArray dataArrayfamily = familydetails.optJSONArray("data");
					FamilyItem familyItem = FamilyItem.builder().build();
					details.getFamily().add(familyItem);
					familyItem.setHhid(uuidReq);
					familyItem.setBentype("T");//getBenType(benType, wardId)
					familyItem.setScode(String.valueOf(NHAConstants.stateCode));
					familyItem.setHhdtype(NHAConstants.hhdtype);
					familyItem.setStateName(NHAConstants.stateName);
					List<FamilyMemberItem> listFamilyMemberItems = new ArrayList<>();
					familyItem.setFamilyMember(listFamilyMemberItems);
					if (dataArrayfamily != null && dataArrayfamily.length() > 0) {

						for (int i = 0; i < dataArrayfamily.length(); i++) {
							{
								JSONObject dataObjectfamily = dataArrayfamily.optJSONObject(i);
								if (dataObjectfamily != null) {

									//if(StringUtils.isNotBlank(hhidReq) || (StringUtils.isNotBlank(uuidReq) && StringUtils.equalsIgnoreCase(uuidReq, dataObjectfamily.optString("memberId")))){
										// Extract a variable from this specific object by its key
										String photo = dataObjectfamily.optString("photo");
										
										String hospShortName = dataObjectfamily.optString("gstr_hosp_short_name");
										//String photoBase64 = getImageAsBase64(photo);
										String photoBase64 = CghsCardApi.getImageAsBase64withshortdispname(photo, hospShortName);
										// System.out.println("photoBase64:"+photoBase64);
										// Check if photoBase64 is null or empty
										
										  if (StringUtils.isBlank(photoBase64)) { 
											  // Set the response to indicate photo not found nhaBenResponse.setStatus(Boolean.FALSE);
										  nhaBenResponse.setOperation(StringUtils.EMPTY);
										  //nhaBenResponse.setErrorcode("PHOTO_NOT_FOUND");
										  nhaBenResponse.setErrorcode(String.valueOf(Response.Status.NOT_FOUND.
										  getStatusCode())); nhaBenResponse.
										  setErrorMessage("Photograph not retrievable from CGHS system. Although it may appear on the physical card, kindly contact the CGHS Card Section to verify and update records digitally."
										  );
										  
										  // Add "header" and "familySearchDetails" as null in nhaBenResponse
										  nhaBenResponse.setHeader(null); nhaBenResponse.setFamilySearchDetails(null);
										  
										  // Return the response with status 404 (NOT_FOUND) return
										  Response.status(Response.Status.NOT_FOUND).entity(nhaBenResponse).build(); 
										  
										  }
										 
										FamilyMemberItem familyMemberItem = FamilyMemberItem.builder().build();
										familyMemberItem.setCareOfTypeDec(dataObjectfamily.optString("careOfTypeDec"));
										familyMemberItem.setCareOfDec(dataObjectfamily.optString("careOfDec"));
										familyMemberItem.setMemberName(dataObjectfamily.optString("memberName"));
										familyMemberItem.setFatherName(StringUtils.EMPTY);
										familyMemberItem.setMemberId(dataObjectfamily.optString("memberId"));
										familyMemberItem.setPhoto(photoBase64);
										familyMemberItem.setGender(dataObjectfamily.optString("gender"));
										familyMemberItem
												.setYearOfBirth(dataObjectfamily.optString("yearOfBirth").split("\\.")[0]);
										
										
										familyMemberItem.setMobileNumber(dataObjectfamily.optString("mobileNumber"));

										Address address = new Address();
										address.setStatelgdCode(NHAConstants.statelgdCode);
										
										//check for lgd code
										 if (StringUtils.isBlank(NHAConstants.statelgdCode)) { 
											 // Set the response to indicate photo not found nhaBenResponse.setStatus(Boolean.FALSE);
										  nhaBenResponse.setOperation(StringUtils.EMPTY);
										  //nhaBenResponse.setErrorcode("PHOTO_NOT_FOUND");
										  nhaBenResponse.setErrorcode(String.valueOf(Response.Status.NOT_FOUND.
										  getStatusCode())); nhaBenResponse.
										  setErrorMessage("Location validation failed: LGD Code not available or not mapped to CGHS unit. Please write to MCTC CGHS at mctc@cghs.nic.in for correction."
										  );
										  
										  // Add "header" and "familySearchDetails" as null in nhaBenResponse
										  nhaBenResponse.setHeader(null); nhaBenResponse.setFamilySearchDetails(null);
										  
										  // Return the response with status 404 (NOT_FOUND) return
										  Response.status(Response.Status.NOT_FOUND).entity(nhaBenResponse).build(); 
										  
										 }
										 
										address.setDistrictlgdCode(NHAConstants.districtlgdCode);
										address.setSubdistrictlgdCode("0");
										address.setBenstatelgdCode(dataObjectfamily.optString("benstatelgdcode"));
										address.setBendistrictlgdCode(dataObjectfamily.optString("bendistrictlgdcode"));
										address.setAddress(dataObjectfamily.optString("resdaddress"));
										address.setVillageTownlgdCode("0");
										address.setRuralUrban(StringUtils.EMPTY);
										address.setPinCode(getNotNullValue(dataObjectfamily.optString("pincode")));
										familyMemberItem.setAddress(address);

										familyMemberItem.setVenderToken(StringUtils.EMPTY);
										familyMemberItem.setTempId(StringUtils.EMPTY);
										familyMemberItem.setDependentFlag(
												(StringUtils.equals(dataObjectfamily.optString("relationCode"), "1") ? "S"
														: "D"));
											// check for dob
										
										if (StringUtils.isBlank(dataObjectfamily.optString("dateofbirth"))) { 
											 // Set the response to indicate photo not found nhaBenResponse.setStatus(Boolean.FALSE);
										  nhaBenResponse.setOperation(StringUtils.EMPTY);
										  //nhaBenResponse.setErrorcode("PHOTO_NOT_FOUND");
										  nhaBenResponse.setErrorcode(String.valueOf(Response.Status.NOT_FOUND.
										  getStatusCode())); nhaBenResponse.
								setErrorMessage("Date of Birth is missing or not in the required format (YYYY-MM-DD). Please contact the CGHS Card Section for correction." );
										  
										  // Add "header" and "familySearchDetails" as null in nhaBenResponse
										  nhaBenResponse.setHeader(null); nhaBenResponse.setFamilySearchDetails(null);
										  
										  // Return the response with status 404 (NOT_FOUND) return
										  Response.status(Response.Status.NOT_FOUND).entity(nhaBenResponse).build(); 
										  
										 }
										
											
										familyMemberItem.setDateofbirth(dataObjectfamily.optString("dateofbirth"));
										familyMemberItem.setAgegroup(StringUtils.EMPTY);
										familyMemberItem.setCardDeliveryStatus(StringUtils.EMPTY);
										familyMemberItem.setCardDeliveryDate(StringUtils.EMPTY);
										familyMemberItem.setHealthId(dataObjectfamily.optString("health_id"));
										familyMemberItem.setAaaURN(StringUtils.EMPTY);
										familyMemberItem.setAaaEnrollmentDate(StringUtils.EMPTY);
										familyMemberItem.setAaaExpiryDate(dataObjectfamily.optString("aaa_expiry_date"));
										familyMemberItem.setAaaFlag(StringUtils.EMPTY);
										familyMemberItem.setFamilyDocId(StringUtils.EMPTY);
										familyMemberItem.setFamilyDocTyp(StringUtils.EMPTY);
										familyMemberItem.setNhaid(uuidReq);
										familyMemberItem.setMotherName(StringUtils.EMPTY);
										familyMemberItem.setSFlag(StringUtils.EMPTY);
										familyItem.getFamilyMember().add(familyMemberItem);
									//}
								}
							}

						}

					}
					else {
						nhaBenResponse.setErrorMessage("The CGHS ID provided is either incorrect, does not exist, or does not belong to the Pensioner, Ex-MP or Freedom Fighter Card Category. Please check and try again! In case the error persists. Please ask beneficiary to Contact Card Section of CGHS");
						return Response.status(Response.Status.NOT_FOUND).entity(nhaBenResponse).build();
					}
				}
			}

			// Return the final combined response as a string
			return Response.ok(nhaBenResponse).build();
		} catch (Exception e) {
			e.printStackTrace();
			nhaBenResponse.setStatus(Boolean.FALSE);
			nhaBenResponse.setOperation(StringUtils.EMPTY);
			nhaBenResponse.setErrorcode(Response.Status.INTERNAL_SERVER_ERROR.name());
			nhaBenResponse.setErrorMessage(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(nhaBenResponse).build();
		}

	}

	private static String getNotNullValue(String value) {
		return StringUtils.isBlank(value) ? StringUtils.EMPTY : value;
	}

	private static String getBenType(String value, String wardId) {
		return StringUtils.equalsIgnoreCase(value, "PRIVATE") || StringUtils.equalsIgnoreCase(wardId, "3") ? "PRV"
				: (StringUtils.equalsIgnoreCase(value, "SEMI-PRIVATE") || StringUtils.equalsIgnoreCase(wardId, "2")
						? "SEMI"
						: "GEN");

	}

	private static String getImageAsBase64(String strFileName) {
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
			//System.out.println("inputStreaminputStreaminputStream" + inputStream);
			if (inputStream != null) {
				//System.out.println("inputStreamiiii");
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
	
	
	
}
