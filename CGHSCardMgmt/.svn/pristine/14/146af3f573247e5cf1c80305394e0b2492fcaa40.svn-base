package thirdpartyservices.digilocker.util;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import com.itextpdf.text.pdf.security.CertificateUtil;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.digilocker.vo.DocDetailsDoc;
import thirdpartyservices.digilocker.vo.PullDocRequest;
import thirdpartyservices.digilocker.vo.PullDocResponse;
import thirdpartyservices.digilocker.vo.ResponseStatus;



public class DigiLockerPullURIDocUtil {

	
	public static PullDocResponse getPullDoc(PullDocRequest objPullDocRequest) {
		PullDocResponse objPullDocResponse= new PullDocResponse();
		ResponseStatus responseStatus= new ResponseStatus();
		responseStatus.setStatus("0");
		
		String uri=objPullDocRequest.getDocDetails().getUri();
		String digiLockerId=objPullDocRequest.getDocDetails().getDigiLockerId();
		
		if(uri!=null && digiLockerId!=null) {
			String benId =uri.split("-")[2];
			
			JSONObject inputjson= new JSONObject();  
			
			inputjson.put("benid", benId);
			
			inputjson.put("digiLockerId", digiLockerId);
			
			inputjson.put("mode", "2");
			
			
			String serviceName="digilocker/getBeneficiaryDetailsDgLocker";
			
			Usefulmethods objUsefulmethods = new Usefulmethods();
			JSONObject objDataJson = objUsefulmethods.callService(inputjson, serviceName);
			if(objDataJson.has("data") && objDataJson.getJSONArray("data").length()>0) {
				JSONArray objarr=  objDataJson.getJSONArray("data");
				JSONObject objData=(JSONObject) objarr.get(0);
				DocDetailsDoc objDocDetails= new DocDetailsDoc();
				String certificatebase64xml=thirdpartyservices.digilocker.vo.certificate.CertificateUtil.generateBase64CertificateXmlFile(objData);
				
			    if(certificatebase64xml!=null) {
					responseStatus.setStatus("1");
					responseStatus.setTimestamp(new Date().toString());
					responseStatus.setTransactionId("093bea782333d06e68d84aba50ac8173");
				    objPullDocResponse.setResponseStatus(responseStatus);
				    objDocDetails.setDataContent(certificatebase64xml);
				    objDocDetails.setDocContent("");
				    objPullDocResponse.setDocDetails(objDocDetails);				       
			    }
			
		}
		
		}
		
       
        
        
		return objPullDocResponse;
	}
	
}
