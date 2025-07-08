package thirdpartyservices.nha.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
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

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.nha.referral.model.BeneficiaryDetails;
import thirdpartyservices.nha.referral.model.ComponentItem;
import thirdpartyservices.nha.referral.model.NHARefRequest;
import thirdpartyservices.nha.referral.model.NHARefResponse;
import thirdpartyservices.nha.referral.model.ResultsItem;

@Path("/nha/tms/v1.0/benificary")
public class AirIndiaReferral { 

	@POST
	@Path("/airindiareferral")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response getBeneficiaryEligibilty(NHARefRequest nhaRefRequest) {// System.out.println("inside referral api");
		JSONObject objFilterJson = new JSONObject();
		NHARefResponse response = new NHARefResponse();
		//System.out.println("Referral ID being sent to service: " + nhaRefRequest.getReferralId());
		//String eligibility = "Y";
		response.setReferralId(nhaRefRequest.getReferralId());
		
		if (StringUtils.isBlank(nhaRefRequest.getReferralId())) {
			response.setStatus(Boolean.FALSE);
			response.setResponseCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
			response.setResponseMessage("Bad Request: Referral Id Not Valid !");
			return Response.status(Response.Status.BAD_REQUEST).entity(response).build();
		}

		
		String refIds ="";
		refIds=nhaRefRequest.getReferralId();
		
		//System.out.println(refIds);
		objFilterJson.put("pk0", refIds);
		objFilterJson.put("processName", "/nha/tms/v1.0/benificary/getairindiaBeneficiaryRef");

		try {

			Usefulmethods objUsefulmethods = new Usefulmethods();
			String strServiceName = "service/getairindiaBeneficiaryRef";
			JSONObject objResponse = objUsefulmethods.callService(objFilterJson, strServiceName);
			if (objResponse != null) {
				// Log the objResponse for debugging
				//System.out.println("objResponse>>>>> " + objResponse);

				// Get the "data" array from objResponse
				JSONArray dataArray = objResponse.optJSONArray("data");
				System.out.println("dataArray: " + dataArray);
				if (dataArray == null || dataArray.length() <= 0) {
					response.setStatus(Boolean.FALSE);
					response.setResponseCode(String.valueOf(Response.Status.NOT_FOUND.getStatusCode()));
					response.setResponseMessage("Air India employee Referral ID provided is either incorrect, does not exist, may have been deleted, or does not belong to you. Please check and try again!");
					return Response.status(Response.Status.NOT_FOUND).entity(response).build();
				}

				response.setStatus(Boolean.TRUE);
				response.setResponseCode(String.valueOf(Response.Status.OK.getStatusCode()));
				response.setResponseMessage("SUCCESS!");

				JSONObject commonDataObject = dataArray.optJSONObject(0);
				BeneficiaryDetails beneficiaryDetails = new BeneficiaryDetails();
				
				if (commonDataObject.optString("benId").equals("0")) {
					response.setStatus(Boolean.FALSE);
					response.setResponseCode(String.valueOf(Response.Status.BAD_REQUEST.getStatusCode()));
					response.setResponseMessage("Air India employee Referral ID provided is  does not exist. Please check and try again!");
					return Response.status(Response.Status.BAD_REQUEST ).entity(response).build();
				}
				if (commonDataObject.optString("benId").equals("-1")) {
					response.setStatus(Boolean.FALSE);
					response.setResponseCode(String.valueOf(Response.Status.FORBIDDEN .getStatusCode()));
					response.setResponseMessage("Referral ID exists, but it does not belong to an Air India employee. Please check the details and try again!");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				}
				
				String DOB = sanitizeUnicodeString(commonDataObject.optString("DOB"));
				String relation = sanitizeUnicodeString(commonDataObject.optString("relation"));
				
				
				int age = calculateAge(DOB);
			System.out.println("DOB: " + age);
				System.out.println("relation: " + relation);
				
				if (relation == null ) {
					response.setStatus(Boolean.FALSE);
					response.setResponseCode(String.valueOf(Response.Status.NOT_FOUND .getStatusCode()));
					response.setResponseMessage("Relationship with primary cardholder is not available in CGHS records. Please contact the CGHS Card Section for necessary update.");
					return Response.status(Response.Status.NOT_FOUND).entity(response).build();

				}
				// if son's age is greater than 25 then not eligible
				if (age > 25 && relation.equals("5")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The son’s age is greater than 25, making them ineligible for CGHS benefits. Please verify the relationship and age details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();

				}
				
				if (age > 18 && relation.equals("22")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The minor brother’s age is greater than 18, making him ineligible for CGHS benefits. Please verify the relationship and age details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				
				}
				//Adopted Son's age is greater than 25 then not eligible
				if (age > 25 && relation.equals("28")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The adopted son's age is greater than 25, making him ineligible for CGHS benefits. Please verify the relationship and age details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				
				}
				//Minor Son of Separated/Widowed/Divorced Daughter  age is greater than 18 then not eligible
				if (age > 18 && relation.equals("33")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The minor son of a separated, widowed, or divorced daughter is greater than 18, making him ineligible for CGHS benefits. Please verify the relationship and age details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				}
				//Minor Daughter of Separated/Widowed/Divorced Daughter(Dependant and Unmarried)
				if (age > 18 && relation.equals("32")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The minor daughter of a separated, widowed, or divorced daughter (dependent and unmarried) is ineligible for CGHS benefits. Please verify the relationship and age details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				}
				//expired
				if (relation.equals("99")) {

					response.setStatus(Boolean.FALSE);
				    response.setResponseCode("AI_REFERRAL_NOT_ELIGIBLE");
					response.setResponseMessage("The person associated with the CGHS ID has expired, and is therefore ineligible for CGHS benefits. Please verify the details.");
					return Response.status(Response.Status.FORBIDDEN).entity(response).build();
				}
				beneficiaryDetails.setBenId(sanitizeUnicodeString(commonDataObject.optString("benId")));
				beneficiaryDetails.setBenName(sanitizeUnicodeString(commonDataObject.optString("benName")));
				beneficiaryDetails.setDispensaryCode(sanitizeUnicodeString(commonDataObject.optString("dispensaryCode")));
				beneficiaryDetails.setDispensaryName(sanitizeUnicodeString(commonDataObject.optString("dispensaryName")));
				response.setBeneficiaryDetails(beneficiaryDetails);

				List<ResultsItem> resultsItems = new ArrayList<ResultsItem>();
				List<ComponentItem> componentItems = new ArrayList<ComponentItem>();
				response.setResults(resultsItems);
				Map<String, StringBuilder>  refType = new HashMap<String, StringBuilder>();
				Map<String, StringBuilder>  refCompDetails = new HashMap<String, StringBuilder>();
				Map<String, StringBuilder> refCompDetailsCode = new HashMap<String, StringBuilder>();
				Map<String, StringBuilder> refCompQuantity = new HashMap<String, StringBuilder>();
				Map<String, StringBuilder> refCompRemarks = new HashMap<String, StringBuilder>();
				Map<String, StringBuilder> refCompValidTo = new HashMap<String, StringBuilder>();

				// Check if dataArray is not null and has at least one element
				if (dataArray != null && dataArray.length() > 0) {
					for (int i = 0; i < dataArray.length(); i++) {
						// Get the JSONObject at the current index 'i'
						JSONObject dataObject = dataArray.optJSONObject(i);

						// Check if the JSONObject is not null
						if (dataObject != null) {

							if (i == 0) {
								ResultsItem resultsItem = new ResultsItem();
								resultsItem.setProcedureType("list");
								resultsItem.setReferralType("OPD Consultation");
								resultsItem.setComponent(componentItems);
								resultsItem.setRefCityCode(StringUtils.EMPTY);
								resultsItem.setRefStatus(StringUtils.equalsIgnoreCase(dataObject.optString("refStatus"), "3") ? "E" : "R");
								resultsItem.setRefHospitalName(sanitizeUnicodeString(commonDataObject.optString("dispensaryName")));
								resultsItem.setRefDocterName(StringUtils.EMPTY);
								resultsItem.setRefDate(dataObject.optString("refDate"));
								resultsItem.setRefTime(dataObject.optString("refTime"));
								resultsItem.setRefRemarks(sanitizeUnicodeString(dataObject.optString("refRemarks")));
								resultsItem.setCghsDoctor(StringUtils.isNotBlank(dataObject.optString("cghsDoctor")) ? dataObject.optString("cghsDoctor") : StringUtils.EMPTY);
								resultsItems.add(resultsItem);
							}
							
							String refTypeCode = dataObject.optString("refTypeCode");
							if(refCompDetails.get(refTypeCode) == null) {
								refType.put(refTypeCode, new StringBuilder(dataObject.optString("referralType")));
								refCompDetails.put(refTypeCode, new StringBuilder());
								refCompDetailsCode.put(refTypeCode, new StringBuilder());
								refCompQuantity.put(refTypeCode, new StringBuilder());
								refCompRemarks.put(refTypeCode, new StringBuilder());
								refCompValidTo.put(refTypeCode, new StringBuilder());
								
							}

							
							if(StringUtils.isNotBlank(refCompDetails.get(refTypeCode).toString())) {
								refCompDetails.get(refTypeCode).append(" || ");
								refCompDetailsCode.get(refTypeCode).append(" || ");
								refCompQuantity.get(refTypeCode).append(" || ");
								refCompRemarks.get(refTypeCode).append(" || ");
								refCompValidTo.get(refTypeCode).append(" || ");
							}
							String refCompCode = StringUtils.isNotBlank(dataObject.optString("refCompCode")) && StringUtils.containsNone(dataObject.optString("refCompCode") , "_") ? "_"+dataObject.optString("refCompCode") : dataObject.optString("refCompCode");
							if(StringUtils.isBlank(refCompCode) && StringUtils.equalsIgnoreCase("1", dataObject.optString("refTypeCode"))){
								refCompCode = "_OC001A";
							}
							refCompDetails.get(refTypeCode).append(sanitizeUnicodeString(dataObject.optString("refComp")));
							refCompDetailsCode.get(refTypeCode).append(StringUtils.isNotBlank(refCompCode) ? refCompCode.split("\\_")[1] : "NA");
							refCompQuantity.get(refTypeCode).append(dataObject.optString("refCompQuantity"));
							refCompRemarks.get(refTypeCode).append(StringUtils.isNotBlank(sanitizeUnicodeString(dataObject.optString("refCompRemarks"))) ? sanitizeUnicodeString(dataObject.optString("refCompRemarks")) : "NA");
							refCompValidTo.get(refTypeCode).append(dataObject.optString("refCompValidTo"));

						}
					}
				}
				
				for(String key : refCompDetails.keySet()) {
					ComponentItem componentItem = new ComponentItem();
					//String refType = StringUtils.equalsIgnoreCase("1", dataObject.optString("refTypeCode")) ? "OPD Consultation" : dataObject.optString("referralType"); 
					componentItem.setRefComp(refType.get(key).toString());
					componentItem.setRefCompDetails(refCompDetails.get(key).toString());
					componentItem.setRefCompDetailsCode(refCompDetailsCode.get(key).toString());
					componentItem.setRefCompQuantity(refCompQuantity.get(key).toString());
					componentItem.setRefCompRemarks(refCompRemarks.get(key).toString());
					componentItem.setRefCompValidTo(refCompValidTo.get(key).toString());
					componentItems.add(componentItem);
				}
			}
			return Response.ok(response).build();
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Boolean.FALSE);
			response.setResponseCode(String.valueOf(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()));
			response.setResponseMessage(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}

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
	
	
	public static String sanitizeUnicodeString(String input) {
        if (input == null) return null;

        // Step 1: Replace all Unicode escape sequences with actual characters
        Pattern unicodePattern = Pattern.compile("\\\\u([0-9A-Fa-f]{4})");
        Matcher matcher = unicodePattern.matcher(input);
        StringBuffer decoded = new StringBuffer();

        while (matcher.find()) {
            int code = Integer.parseInt(matcher.group(1), 16);
            matcher.appendReplacement(decoded, Character.toString((char) code));
        }
        matcher.appendTail(decoded);

        // Step 2: Remove all non-ASCII characters (retain only 0x20 to 0x7E)
        return decoded.toString().replaceAll("[^\\x20-\\x7E]", "");
    }

}
