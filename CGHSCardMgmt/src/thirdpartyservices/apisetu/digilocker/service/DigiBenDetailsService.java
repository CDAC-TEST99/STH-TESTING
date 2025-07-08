package thirdpartyservices.apisetu.digilocker.service;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.apisetu.digilocker.client.req.PullURIRequest;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.DocDetails;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.DocDetails.IssuedTo;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.DocDetails.IssuedTo.Persons;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.DocDetails.IssuedTo.Persons.Person;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.DocDetails.IssuedTo.Persons.Person.Photo;
import thirdpartyservices.apisetu.digilocker.client.resp.PullURIResponse.ResponseStatus;
import thirdpartyservices.apisetu.digilocker.util.DigiUtil;

public class DigiBenDetailsService {

	private void getBenDetails(String benId, String digiLockerId, DocDetails objDocDetails) throws Exception {
		JSONObject inputjson= new JSONObject();  
		inputjson.put("benid", benId);
		//inputjson.put("digiLockerId", digiLockerId);
		//inputjson.put("mode", "2");
		
		
		String serviceName="digilocker/getBeneficiaryDetailsDgLocker";
		Usefulmethods objUsefulmethods = new Usefulmethods();
		JSONObject objDataJson = objUsefulmethods.callService(inputjson, serviceName);
		if(objDataJson.has("data") && objDataJson.getJSONArray("data").length()>0) {
			JSONArray objarr=  objDataJson.getJSONArray("data");
			JSONObject objData=(JSONObject) objarr.get(0);
		    objDocDetails.setDataContent(DigiRespDataContentBuilder.builder().build().buildBase64DataContne(objData));

			
			Persons persons = new Persons();
			
			Person person=new Person();
	        person.setName(objData.getString("FirstName"));
	        person.setDob(objData.getString("DOB") );
	        person.setGender(objData.getString("gender"));
	        person.setPhone(objData.getString("mobile"));
	        
	        Photo photo= new Photo();
	        photo.setFormat("JPG");
			person.setPhoto(photo);
			
	        persons.getPerson().add(person);
	       
	        
	        IssuedTo objIssuedTo= new IssuedTo();
	        objIssuedTo.setPersons(persons);
	        objDocDetails.setIssuedTo(objIssuedTo);
	        objDocDetails.setURI(DigiUtil.getURI(benId));
	        
		
		}else {
			throw new Exception("No Ben Details Found!!!");
		}
	}
	
	private String fetchBenCGHSCard(String benId) throws Exception {
		return DigiRespDocContentBuilder.builder().build().fetchBase64BenCard(benId);
	}
	
	
	public PullURIResponse buildDigiResponse(PullURIRequest request) {
		PullURIResponse response = new PullURIResponse();
		ResponseStatus responseStatus= new ResponseStatus();
		responseStatus.setStatus("1");
		responseStatus.setTs(request.getTs());
		responseStatus.setTxn(request.getTxn());
		responseStatus.setValue("1");
	    response.setResponseStatus(responseStatus);
		
		try {
			DocDetails docDetails= new DocDetails();
			String benId = request.getDocDetails().getUDF1();
			String digiLockerId = request.getDocDetails().getDigiLockerId();
			getBenDetails(benId, digiLockerId, docDetails);
		    docDetails.setDocContent(fetchBenCGHSCard(benId));
		    response.setDocDetails(docDetails);				       
			
		}catch (Exception e) {
			responseStatus.setValue("0");
			responseStatus.setStatus("0");
		}

		return response;
	}
	
}
