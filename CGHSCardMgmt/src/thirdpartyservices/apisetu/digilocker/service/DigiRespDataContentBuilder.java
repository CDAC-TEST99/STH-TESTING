package thirdpartyservices.apisetu.digilocker.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.json.JSONObject;

import lombok.Builder;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.CertificateData;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.CertificateData.CghsCard;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedBy;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedBy.Address;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedBy.Organization;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedTo;
import thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedTo.Person;


@Builder
public class DigiRespDataContentBuilder {

	
	public String buildBase64DataContne(JSONObject objData) {
		
		Organization issuedByOrg= new Organization();
		issuedByOrg.setCode(objData.optString("orgCode"));
		issuedByOrg.setName("Central Govenment Health Scheme");
		issuedByOrg.setTin("");
		issuedByOrg.setType("CS");
		issuedByOrg.setUid("");
		
		Address issuedByAddress= new Address();
		issuedByAddress.setType("");
		issuedByAddress.setLine1(objData.optString("orgAddressLine1"));
		issuedByAddress.setLine2(objData.optString("orgAddressLine2"));
		issuedByAddress.setHouse("");
		issuedByAddress.setLandmark("");
		issuedByAddress.setLocality("");
		issuedByAddress.setVtc("");// what we have to fill??
		issuedByAddress.setDistrict(objData.optString("orgDistName"));
		issuedByAddress.setPin(objData.optString("orgPin"));
		issuedByAddress.setState(objData.optString("orgState"));
		issuedByAddress.setCountry("India");
		
		IssuedBy objIssuedBy= new IssuedBy();
		objIssuedBy.setOrganization(issuedByOrg);
		objIssuedBy.setAddress(issuedByAddress);
		
		Person issuedToPerson= new Person();
		issuedToPerson.setUid("");
		issuedToPerson.setTitle("");
		issuedToPerson.setName(objData.optString("FirstName"));
		issuedToPerson.setDob(objData.optString("DOB"));
		issuedToPerson.setAge("");
		issuedToPerson.setSwd("");
		issuedToPerson.setSwdIndicator("");
		issuedToPerson.setMotherName("");
		issuedToPerson.setGender(objData.optString("gender"));
		issuedToPerson.setMaritalStatus("");
		issuedToPerson.setRelationWithHof("");
		issuedToPerson.setDisabilityStatus(objData.optString("disabilityStatus"));
		issuedToPerson.setCategory("");
		issuedToPerson.setReligion("");
		issuedToPerson.setPhone(objData.optString("mobile"));
		issuedToPerson.setEmail(objData.optString("email"));
		issuedToPerson.setEmail(objData.optString("email"));
		
		thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedTo.Address issuedToAddress 
				= new thirdpartyservices.apisetu.digilocker.client.xmldata.Certificate.IssuedTo.Address();
		issuedToAddress.setType("");
		issuedToAddress.setLine1(objData.optString("addressline_1"));
		issuedToAddress.setLine2("");
		issuedToAddress.setHouse("");
		issuedToAddress.setLandmark("");
		issuedToAddress.setLocality("");
		issuedToAddress.setVtc("");
		issuedToAddress.setDistrict(objData.optString("district"));
		issuedToAddress.setPin(objData.optString("pincode"));
		issuedToAddress.setState(objData.optString("state"));
		issuedToAddress.setCountry("India");
		
		IssuedTo objIssuedTo= new IssuedTo();
		objIssuedTo.setPerson(issuedToPerson);
		objIssuedTo.setAddress(issuedToAddress);
		
		CghsCard objCghsCard= new CghsCard();
		objCghsCard.setDate("");
		objCghsCard.setPlace("");
		objCghsCard.setName("");
		
		CertificateData objCertificateData= new CertificateData();
		objCertificateData.setCghsCard(objCghsCard);
		
		// setting all above objects in certificate 
		Certificate objCertificate= new Certificate();
		
		objCertificate.setLanguage("99");
		objCertificate.setName("Government Id Card");
		objCertificate.setType("GovtId");
		objCertificate.setNumber(objData.optString("benid"));
		objCertificate.setPrevNumber("");
		objCertificate.setExpiryDate(objData.optString("expiryDate"));
		objCertificate.setIssuedAt("");
		objCertificate.setIssueDate(objData.optString("issueDate"));
		objCertificate.setStatus("");
		objCertificate.setIssuedBy(objIssuedBy);		
		objCertificate.setIssuedTo(objIssuedTo);
		objCertificate.setCertificateData(objCertificateData);
		
		String xmlString=toXmlString(objCertificate);
		//System.out.println("DigiRespDataContentBuilder>>>xmlString>>>" + xmlString);
		return toBase64(xmlString);
	}
	
	private String toBase64(String content) {
		String base64Xml = Base64.getEncoder().encodeToString(content.getBytes());
		return base64Xml;
	}
	
	private String toXmlString(Certificate objCertificate) {
		String xmlString=null;
		try {
         
            // Convert to XML
            JAXBContext jaxbContext = JAXBContext.newInstance(Certificate.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            // For pretty-printing XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Write to StringWriter
            StringWriter writer = new StringWriter();
            marshaller.marshal(objCertificate, writer);

            // Print XML String
            xmlString = writer.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
            xmlString=null;
        }
		return xmlString;
	}

}
