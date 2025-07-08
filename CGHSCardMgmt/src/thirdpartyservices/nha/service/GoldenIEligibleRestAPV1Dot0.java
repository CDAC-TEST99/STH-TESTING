package thirdpartyservices.nha.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.nha.eligibility.model.NHAEliRequest;
import thirdpartyservices.nha.eligibility.model.NHAEliResponse;

@Path("/nha/tms/v1.0/benificary")
public class GoldenIEligibleRestAPV1Dot0 {

	@POST
	@Path("/eligibility")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBeneficiaryEligibilty(NHAEliRequest nhaEliRequest) {
		//System.out.println("inside eligibility api");
		//System.out.println("NHA Eligibility-->>" + nhaEliRequest.toString());
		JSONObject objFilterJson = new JSONObject();
		
		NHAEliResponse response = new NHAEliResponse();
		response.setSourceId(nhaEliRequest.getMember_id());
		//System.out.println("nhaEliRequest.getMember_id()---"+nhaEliRequest.getMember_id());
		String uuid = nhaEliRequest.getMember_id();
		String regex = "\\d+";

		if (StringUtils.isBlank(uuid) || !uuid.matches(regex)) {
			response.setErrorCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
			response.setErrorMessage("The CGHS ID provided is either incorrect, does not exist, or does not belong to the Pensioner, Ex-MP or Freedom Fighter Card Category or Relationship with primary cardholder is not available in CGHS records. Please check and try again! In case the error persists. Please ask beneficiary to Contact Card Section of CGHS");
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}

		objFilterJson.put("pk0", uuid);
		objFilterJson.put("processName", "/nha/tms/v1.0/benificary/getNHAbeneficiaryeligibility");

		try {

			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/getNHAbeneficiaryeligibility";
			JSONObject objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
			
			if (objResponse != null) {
				
				
				// Log the objResponse for debugging
				//System.out.println("objResponse>>>>> " + objResponse);

				// Get the "data" array from objResponse
				JSONArray dataArray = objResponse.optJSONArray("data");

				if (objResponse == null || dataArray.length() <= 0) {
					response.setErrorCode(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()));
					response.setErrorMessage("The CGHS ID provided is either incorrect, does not exist, or does not belong to the Pensioner, Ex-MP or Freedom Fighter Card Category. Please check and try again! In case the error persists. Please ask beneficiary to Contact Card Section of CGHS");
					return Response.status(Response.Status.NOT_FOUND).entity(response).build();

				}
				
				response.setSourceId(uuid);
				response.setSourceType("CGHS");
				response.setErrorCode(String.valueOf(Response.Status.OK.getStatusCode()));
				response.setErrorMessage("SUCCESS!");
				response.setNhaid(StringUtils.EMPTY);
				response.setHhdtype(StringUtils.EMPTY);
				response.setHhid(StringUtils.EMPTY);
				response.setBankName(StringUtils.EMPTY);
				response.setAccountHolderName(StringUtils.EMPTY);
				response.setBankAccountNumber(StringUtils.EMPTY);
				response.setDeathDate(StringUtils.EMPTY);
				response.setIfscCode(StringUtils.EMPTY);

				// Get the JSONObject at the current index 'i'
				JSONObject dataObject = dataArray.optJSONObject(0);

				// Check if the JSONObject is not null
				if (dataObject != null) {
					String eligibility = "Y";
					// Extract a variable from this specific object by its key
					String DOB = dataObject.optString("DOB");
					String relation = dataObject.optString("relation");
					String cardtype = dataObject.optString("cardtype");
					String validupto = dataObject.optString("validupto");
					String wardid = StringUtils.isNotBlank(dataObject.optString("wardId")) ? dataObject.optString("wardId") : "1";
					

					int age = calculateAge(DOB);
					//System.out.println("DOB: " + age);
				//	System.out.println("relation: " + relation);
					
					if (relation == null ) {
						response.setErrorCode(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()));
						response.setErrorMessage("Relationship with primary cardholder is not available in CGHS records. Please contact the CGHS Card Section for necessary update.");
						return Response.status(Response.Status.NOT_FOUND).entity(response).build();

					}
					// patient_cat_code
					/*
					 * if (cardtype.equals("S") || cardtype.equals("J") || cardtype.equals("L") ||
					 * cardtype.equals("R")) { eligibility = "N"; }
					 */
					// if son's age is greater than 25 then not eligible
					if (age > 25 && relation.equals("5")) {

						eligibility = "N";
						response.setErrorMessage("The son’s age is greater than 25, making them ineligible for CGHS benefits. Please verify the relationship and age details.");

					}
					
					if (age > 18 && relation.equals("22")) {

						eligibility = "N";
						response.setErrorMessage("The minor brother’s age is greater than 18, making him ineligible for CGHS benefits. Please verify the relationship and age details.");

					}
					//Adopted Son's age is greater than 25 then not eligible
					if (age > 25 && relation.equals("28")) {

						eligibility = "N";
						response.setErrorMessage("The adopted son's age is greater than 25, making him ineligible for CGHS benefits. Please verify the relationship and age details.");

					}
					//Minor Son of Separated/Widowed/Divorced Daughter  age is greater than 18 then not eligible
					if (age > 18 && relation.equals("33")) {

						eligibility = "N";
						response.setErrorMessage("The minor son of a separated, widowed, or divorced daughter is greater than 18, making him ineligible for CGHS benefits. Please verify the relationship and age details.");

					}
					//Minor Daughter of Separated/Widowed/Divorced Daughter(Dependant and Unmarried)
					if (age > 18 && relation.equals("32")) {

						eligibility = "N";
						response.setErrorMessage("The minor daughter of a separated, widowed, or divorced daughter (dependent and unmarried) is ineligible for CGHS benefits. Please verify the relationship and age details.");

					}
					//expired
					if (relation.equals("99")) {

						eligibility = "N";
						response.setErrorMessage("The person associated with the CGHS ID has expired, and is therefore ineligible for CGHS benefits. Please verify the details.");

					}
					/*if(eligibility.equals("N")) {
						response.setErrorMessage("The CGHS ID entered is either incorrect, does not exist, or is not linked to a Pensioner, Ex-MP, or Freedom Fighter category or Relationship with primary cardholder is not available in CGHS records. Please verify the ID and try again. If the issue persists, the beneficiary may contact the CGHS Card Section for assistance.");
						
					}*/
					response.setEligible(eligibility);
					response.setExpiryDate(validupto);
					response.setGrade(wardid);

				}
			}
			return Response.ok(response).build();

		} catch (Exception e) {
			e.printStackTrace();
			response.setErrorCode(Response.Status.INTERNAL_SERVER_ERROR.name());
			response.setErrorMessage(e.toString());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}

	}

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
