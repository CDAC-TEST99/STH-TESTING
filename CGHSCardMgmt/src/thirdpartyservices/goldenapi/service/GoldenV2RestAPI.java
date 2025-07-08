package thirdpartyservices.goldenapi.service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.HisUtil;
import hisglobal.utility.Usefulmethods;

@Path("/nha-tms-esic/v2/beneficiary")
public class GoldenV2RestAPI {

	@POST
	@Path("/getrecord")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBeneficiaryDetails(String filters) {

	//	System.out.println("iiiiiinnn method>>>");
		JSONObject familySearchDetails = new JSONObject();

		JSONObject objFilterJson = null;
		JSONObject objResponse = new JSONObject();
		JSONObject familydetails = new JSONObject();
		// JSONObject response = new JSONObject();
		JSONObject header = new JSONObject();
		// JSONObject modifiedFamilyDetails = new JSONObject();
		JSONObject combinedResponse = new JSONObject();
		JSONObject beneficiaryDetails = new JSONObject();
		JSONObject address = new JSONObject();
		// JSONArray family = new JSONArray();
		JSONArray familyArray = new JSONArray();
		JSONObject familyMember = new JSONObject();
		JSONArray familyMembers = new JSONArray();
		try {
			objFilterJson = new JSONObject(filters);
			if (objFilterJson.has("benId") == false) {
				return Response.status(Response.Status.BAD_REQUEST).entity(String.format("benId Not valid !")).build();
			}

			String pk0 = (String) objFilterJson.get("benId");
			objFilterJson.put("pk0", pk0);
			objFilterJson.put("processName", "/nha-tms/v1/BenDetails/getbeneficiarydetailstms");
		} catch (Exception e) {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(String.format("please provide valid request body!")).build();
		}

		if (objFilterJson.length() == 0) {
			objFilterJson = null; // setting to null so that filter is not used in query
		}

		try {
			Usefulmethods objUsefulmethods = new Usefulmethods();

			// Initialize the combined response with default values
			combinedResponse.put("status", true);
			combinedResponse.put("operation", "");
			combinedResponse.put("errorcode", "0");
			combinedResponse.put("errorMessage", "");

			// Fetch Beneficiary Details
			String strServiceName1 = "service/getbeneficiarydetailstms";
			objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

			// Check if objResponse is not null
			if (objResponse != null) {
				// Log the objResponse for debugging
				//System.out.println("objResponse>>>>> " + objResponse);

				// Get the "data" array from objResponse
				JSONArray dataArray = objResponse.optJSONArray("data");

				// Check if dataArray is not null and has at least one element
				if (dataArray != null && dataArray.length() > 0) {
					for (int i = 0; i < dataArray.length(); i++) {
						// Get the JSONObject at the current index 'i'
						JSONObject dataObject = dataArray.optJSONObject(i);

						// Check if the JSONObject is not null
						if (dataObject != null) {
							// Extract a variable from this specific object by its key
							String mobileNumber = dataObject.optString("Mobileno"); // Example field
							String addressben = dataObject.optString("resdaddress");
							String BenIdmem = dataObject.optString("BenId");
							String statelgdcode = dataObject.optString("gnum_lgd_state_code");
							String pincode = dataObject.optString("pincode");

							// Print the mobileNumber for debugging
						//	System.out.println("mobileNumber: " + mobileNumber);

							// Create a new JSONObject to hold the beneficiary details
							beneficiaryDetails.put("mobileNumber", mobileNumber);
							beneficiaryDetails.put("uuid", BenIdmem);
							beneficiaryDetails.put("familyType", "");
							beneficiaryDetails.put("health_id", "");

							address.put("statelgdCode", statelgdcode);
							// Adding address details (example)
							address.put("address", addressben); // Example address
							address.put("pinCode", pincode);
							familyMember.put("address", address);

							// Add beneficiaryDetails to the header
							header.put("beneficiaryDetails", beneficiaryDetails);
						} else {
							System.out.println("No valid data object found in the 'data' array.");
						}
					}
				} else {
					System.out.println("'data' array is empty or null.");
				}
			}

			// Fetch family members' details
			String strServiceName2 = "service/getfamilymembersDetailsTMS";
			familydetails = objUsefulmethods.callService(objFilterJson, strServiceName2);

			if (familydetails != null) {
				JSONArray dataArrayfamily = familydetails.optJSONArray("data");
			//	System.out.println("dataArrayfamily>>>" + dataArrayfamily);
				if (dataArrayfamily != null && dataArrayfamily.length() > 0) {

					for (int i = 0; i < dataArrayfamily.length(); i++) {
						{
							JSONObject dataObjectfamily = dataArrayfamily.optJSONObject(i);
							if (dataObjectfamily != null) {
								// Extract a variable from this specific object by its key
								String memberName = dataObjectfamily.optString("memberName"); // Example field
								String gendermem = dataObjectfamily.optString("gender");
								String Yearofbirthmem = dataObjectfamily.optString("yearOfBirth");
								String member_idmam = dataObjectfamily.optString("memberid");
								String memberself = member_idmam + "_self";
								String Photonamedep = dataObjectfamily.optString("Photoname");
							//	System.out.println("PhotonamedepPhotonamedep>>>>>>>" + Photonamedep);
								String Photonamedepbase64 = getImageAsBase64(Photonamedep);
								//System.out.println("Photonamedepbase64>>>>>>>" + Photonamedepbase64);
								String Dobmem = dataObjectfamily.optString("Dob");

								familyMember.put("memberName", memberName);
								familyMember.put("photo", Photonamedepbase64);

								familyMember.put("gender", gendermem);
								familyMember.put("yearOfBirth", Yearofbirthmem);
								familyMember.put("venderToken",
										"01111481fdkw8sBJKiPJTWQRVme8HYt9S7lz1m2SRGkBBMMw2WEZFSQKY0bvrnujanhkA5Oz");
								familyMember.put("tempId", "");
								familyMember.put("dependent_flag", "S");
								familyMember.put("member_id", memberself);
								familyMember.put("dateofbirth", Dobmem);
								familyMember.put("agegroup", "");
								familyMember.put("card_delivery_status", "");
								familyMember.put("card_delivery_date", "");
								familyMember.put("health_id", "");
								familyMember.put("aaa_URN", "");
								familyMember.put("aaa_enrollment_date", "");
								familyMember.put("aaa_expiry_date", "");
								familyMember.put("aaa_flag", "NA");
								familyMember.put("s_flag", "");
								familyMember.put("familyDocTyp", "1");
								familyMember.put("familyDocId", "424151231521");
								familyMember.put("nhaid", "PB7Q84SW");

								familyMembers.put(familyMember);
								//System.out.println("familyMembers>>>>>>>>>>>" + familyMembers);

							} else {
								System.out.println("No valid data object found in the 'data' array.");
							}
						}

					}

				} else {
					System.out.println("No valid data object found in the 'data' array.");
				}

			}

			header.put("errorCode", "");
			header.put("version", "1.1.1");

			JSONObject familyDetails = new JSONObject();
			familyDetails.put("hhid", "ITIT000020011");
			familyDetails.put("scode", "91");
			familyDetails.put("bentype", "T");
			familyDetails.put("hhdtype", "IT");
			familyDetails.put("stateName", "CAPF");
			familyDetails.put("familyMember", familyMembers);

			familyArray.put(familyDetails);

			familySearchDetails.put("family", familyArray);

			// Add familySearchDetails to the response object

			combinedResponse.put("familySearchDetails", familySearchDetails);
			// Add the header to the combined response
			combinedResponse.put("header", header);

			// Return the final combined response as a string
			return Response.ok(combinedResponse.toString()).build();

		} catch (Exception e) {
			e.printStackTrace();
			combinedResponse.put("status", false);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(String.format("Problem in service!"))
					.build();
		}
	}

	

    @POST
    @Path("/getBeneficiaryEligibilty")
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public Response getBeneficiaryEligibilty(String filters) {

    	JSONObject objFilterJson=null;
		JSONObject objResponse=new JSONObject();
		JSONObject result=new JSONObject();
	//	  JSONArray beneficiaryDetailsArray = new JSONArray();
		  JSONObject beneficiaryDetails = new JSONObject();
		  String Eligibility="";
		// getBenIdWiseDtl
		  try {
	            objFilterJson = new JSONObject(filters);
	            if (objFilterJson.has("benId") == false) {
	                return Response
	                        .status(Response.Status.BAD_REQUEST)
	                        .entity(String.format("benId Not valid !"))
	                        .build();
	            }

	            String pk0 = (String) objFilterJson.get("benId");
	            objFilterJson.put("pk0", pk0);
	            objFilterJson.put("processName", "/nha-tms/v1/BenDetailsEligibilty/getbeneficiaryEligibilitytms");
	        } catch (Exception e) {
	            return Response
	                    .status(Response.Status.BAD_REQUEST)
	                    .entity(String.format("please provide valid request body!"))
	                    .build();
	        }

	        if (objFilterJson.length() == 0) {
	            objFilterJson = null; // setting to null so that filter is not used in query
	        }
		
			
		
		
		try {
		
			 Usefulmethods objUsefulmethods = new Usefulmethods(); String
			 strServiceName="service/getbeneficiaryEligibilitytms"; 
			objResponse=objUsefulmethods.callService(objFilterJson, strServiceName);
			 if (objResponse != null) {
	                // Log the objResponse for debugging
	               // System.out.println("objResponse>>>>> " + objResponse);

	                // Get the "data" array from objResponse
	                JSONArray dataArray = objResponse.optJSONArray("data");

	                // Check if dataArray is not null and has at least one element
	                if (dataArray != null && dataArray.length() > 0) {
	                    for (int i = 0; i < dataArray.length(); i++) {
	                        // Get the JSONObject at the current index 'i'
	                        JSONObject dataObject = dataArray.optJSONObject(i);

	                        // Check if the JSONObject is not null
	                        if (dataObject != null) {
	                            // Extract a variable from this specific object by its key
	                            String BeneficiaryId = dataObject.optString("BenId"); // Example field
	                            String DOB = dataObject.optString("DOB");
	                            String relation = dataObject.optString("relation");
	                            String cardtype = dataObject.optString("cardtype");
	                            String validupto = dataObject.optString("validupto");
	                            
	                            // Print the mobileNumber for debugging
	                          //  System.out.println("BeneficiaryId: " + BeneficiaryId+"relation"+relation);
	                          //  System.out.println("DOB: " + DOB);

	                            int age = calculateAge(DOB);
	                          //  System.out.println("DOB: " + age);
	                            if(cardtype.equals("S") || cardtype.equals("J") || cardtype.equals("L") ||  cardtype.equals("R") )
	                            {
	                            	Eligibility="N";
	                            }
	                            
	                            
	                            if(age>25 && relation.equals("5")) {
	                            	
	                            	Eligibility="N";
	                            }
                            if(age>18 && relation.equals("7")) {
	                            	
                            	
	                            	Eligibility="N";
	                            }
	                            beneficiaryDetails.put("CGHS BenId", BeneficiaryId);
	                            beneficiaryDetails.put("DOB", DOB);
	                            beneficiaryDetails.put("eligible", Eligibility);
	                   	        beneficiaryDetails.put("expiryDate", validupto);
	                            
	                            // Add the details to the array
	                          //  beneficiaryDetailsArray.put(beneficiaryDetails);
	                         
	                        } else {
	                            System.out.println("No valid data object found in the 'data' array.");
	                        }
	                    }
	                } else {
	                    System.out.println("'data' array is empty or null.");
	                }
	            }

			 result.put("beneficiary", beneficiaryDetails);
			
			return Response.ok(result.toString()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response
	                .status(Response.Status.INTERNAL_SERVER_ERROR)
	                .entity(
	                String.format("Problem in service !"))
	                .build();
		} 
			
	}
	 
	
    private static int calculateAge(String dobString) {
        // Define the formatter for the date format "dd-MMM-yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

        // Parse the DOB string to a LocalDate object
        LocalDate dob = LocalDate.parse(dobString, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the period between the DOB and current date
        Period period = Period.between(dob, currentDate);

        // Return the age (in years)
        return period.getYears();
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
