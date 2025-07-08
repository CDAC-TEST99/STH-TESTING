package thirdpartyservices.digilocker.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.digilocker.vo.DocDetailsURI;
import thirdpartyservices.digilocker.vo.PullURIRequest;
import thirdpartyservices.digilocker.vo.PullURIResponse;
import thirdpartyservices.digilocker.vo.PullURIResponse.IssuedTo;
import thirdpartyservices.digilocker.vo.PullURIResponse.Person;
import thirdpartyservices.digilocker.vo.PullURIResponse.Persons;
import thirdpartyservices.digilocker.vo.ResponseStatus;

public class DigiLockerPullURIUtil {

	public static PullURIResponse getPullUriData(PullURIRequest objPullURIRequest) {
		PullURIResponse objPullURIResponse= new PullURIResponse();
		PullURIRequest.DocDetails objDocDetails =objPullURIRequest.getDocDetails();
		JSONObject inputjson= new JSONObject();  
		String dob=objDocDetails.getDateOfBirth();
		String benid=objDocDetails.getBeneficiaryId();
		String digilockerId=objDocDetails.getDigiLockerId();
		
		inputjson.put("benid", benid);
		
		inputjson.put("dob", dob);
		
		inputjson.put("digilockerId", digilockerId);
		
		inputjson.put("mode", "1");
		
		
		String serviceName="digilocker/getBeneficiaryDetailsDgLocker";
		
		Usefulmethods objUsefulmethods = new Usefulmethods();
		JSONObject objDataJson = objUsefulmethods.callService(inputjson, serviceName);
		ResponseStatus responseStatus= new ResponseStatus();
        responseStatus.setStatus("0");
        List<Person> personList= new ArrayList<Person>();
        DocDetailsURI objResponseDocDetails= new DocDetailsURI();
		if(objDataJson.has("data") && objDataJson.getJSONArray("data").length()>0) {
			JSONArray objarr=  objDataJson.getJSONArray("data");
			JSONObject objData=(JSONObject) objarr.get(0);
			String certificatebase64xml=thirdpartyservices.digilocker.vo.certificate.CertificateUtil.generateBase64CertificateXmlFile(objData);
		    objResponseDocDetails.setDataContent(certificatebase64xml);
			if(certificatebase64xml!=null) {
				responseStatus.setStatus("1");
				responseStatus.setTimestamp(new Date().toString());
		        PullURIResponse.Person person=new PullURIResponse.Person();
		        responseStatus.setTransactionId("093bea782333d06e68d84aba50ac8173");
		        person.setName(objData.getString("FirstName"));
		        person.setDateOfBirth(objData.getString("DOB") );
		        person.setGender(objData.getString("gender"));
		        person.setPhone(objData.getString("mobile"));
		        personList.add(person);
		       
		        
		        Persons objPersons= new Persons();
		        objPersons.setPersonList(personList);
		        
		        IssuedTo objIssuedTo= new IssuedTo();
		        objIssuedTo.setPersons(objPersons);
		        objResponseDocDetails.setIssuedTo(objIssuedTo);
		        objResponseDocDetails.setUri("in.gov.cghs-GOVID-"+ objDocDetails.getBeneficiaryId());
		        
		        // updating digilocker id to beneficiary id
		        serviceName="digilocker/updateDigilockerIdToBenId";
		        objDataJson = objUsefulmethods.callService(inputjson, serviceName);
			}
			else {
				objResponseDocDetails.setDocContent("Certificate Detail invalid");	
			}
		}
		else {
			objResponseDocDetails.setDocContent("Data Not Found");	
		}
		objPullURIResponse.setResponseStatus(responseStatus);
        objPullURIResponse.setDocDetails(objResponseDocDetails);        
        
        return objPullURIResponse;
	}
	
		
}
