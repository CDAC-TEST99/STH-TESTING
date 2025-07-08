package thirdpartyservices.digilocker.vo.certificate;

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

import hisglobal.utility.Usefulmethods;

public class CertificateUtil {

	public static String generateBase64CertificateXmlFile(JSONObject objData) {
		String base64="";
		
		
		Organization objOrganization= new Organization();
		objOrganization.setCode(objData.getString("orgCode"));
		objOrganization.setName("Central Govenment Health Scheme");
		objOrganization.setTin("");
		objOrganization.setType("CS");
		objOrganization.setUid("");
		
		Address objOrgAddress= new Address();
		objOrgAddress.setType("");
		objOrgAddress.setLine1(objData.getString("orgAddressLine1"));
		objOrgAddress.setLine2(objData.getString("orgAddressLine2"));
		objOrgAddress.setHouse("");
		objOrgAddress.setLandmark("");
		objOrgAddress.setLocality("");
		objOrgAddress.setVtc("");// what we have to fill??
		objOrgAddress.setDistrict(objData.getString("orgDistName"));
		objOrgAddress.setPin(objData.getString("orgPin"));
		objOrgAddress.setState(objData.getString("orgState"));
		objOrgAddress.setCountry("India");
		objOrganization.setAddress(objOrgAddress);
		
		IssuedBy objIssuedBy= new IssuedBy();
		objIssuedBy.setOrganization(objOrganization);
		
		
		Person objPerson= new Person();
		objPerson.setUid("");
		objPerson.setTitle("");
		objPerson.setName(objData.getString("FirstName"));
		objPerson.setDob(objData.getString("DOB"));
		objPerson.setAge("");
		objPerson.setSwd("");
		objPerson.setSwdIndicator("");
		objPerson.setMotherName("");
		objPerson.setGender(objData.getString("gender"));
		objPerson.setMaritalStatus("");
		objPerson.setRelationWithHof("");
		objPerson.setDisabilityStatus(objData.getString("disabilityStatus"));
		objPerson.setCategory("");
		objPerson.setReligion("");
		objPerson.setPhone(objData.getString("mobile"));
		objPerson.setEmail(objData.getString("email"));
		objPerson.setEmail(objData.getString("email"));
		Address objPersonAddress= new Address();
		objPersonAddress.setType("");
		objPersonAddress.setLine1(objData.getString("addressline_1"));
		objPersonAddress.setLine2("");
		objPersonAddress.setHouse("");
		objPersonAddress.setLandmark("");
		objPersonAddress.setLocality("");
		objPersonAddress.setVtc("");
		objPersonAddress.setDistrict(objData.getString("district"));
		objPersonAddress.setPin(objData.getString("pincode"));
		objPersonAddress.setState(objData.getString("state"));
		objPersonAddress.setCountry("India");
		
		Photo objPhoto= new Photo();
		objPhoto.setFormat("JPG");
		
		IssuedTo objIssuedTo= new IssuedTo();
		objIssuedTo.setPerson(objPerson);
		objIssuedTo.setAddress(objPersonAddress);
		objIssuedTo.setPhoto(objPhoto);
		
		
		
		
		
		CghsCard objCghsCard= new CghsCard();
		objCghsCard.setDate("");
		objCghsCard.setPlace("");
		objCghsCard.setOfficerName("");
		
		Card objCard= new Card();
		objCard.setWard(objData.getString("ward"));
		objCard.setBloodGroup("");
		objCghsCard.setCard(objCard);
		
		CertificateData objCertificateData= new CertificateData();
		objCertificateData.setCghsCard(objCghsCard);
		
		// setting all above objects in certificate 
		Certificate objCertificate= new Certificate();
		
		objCertificate.setLanguage("99");
		objCertificate.setName("Government Id Card");
		objCertificate.setType("GovtId");
		objCertificate.setNumber(objData.getString("benid"));
		objCertificate.setPrevNumber("");
		objCertificate.setExpiryDate(objData.getString("expiryDate"));
		objCertificate.setIssuedAt("");
		objCertificate.setIssueDate(objData.getString("issueDate"));
		objCertificate.setStatus("");
		objCertificate.setIssuedBy(objIssuedBy);		
		objCertificate.setIssuedTo(objIssuedTo);
		objCertificate.setCertificateData(objCertificateData);
		
		String xmlString=ObjectToXMLStringConversion(objCertificate);
		//System.out.println("xmlString>>>" + xmlString);
		if(xmlString!=null) {			
			base64=xmlStringToBase64String( xmlString, objData.getString("benid"));
		}
		
		return base64;
	}
	public static String ObjectToXMLStringConversion(Certificate objCertificate) {
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
         //   System.out.println(xmlString);

        } catch (JAXBException e) {
            e.printStackTrace();
            xmlString=null;
        }
		return xmlString;
	}
	
	public static String xmlStringToBase64String(String xmlString, String benId) {
		String base64String=null;
		String configFilename="config.Configuration";
		String filePath = "";
		String osType = System.getProperties().getProperty("os.name");
		try { 
			if (osType.startsWith("Win")) {
				filePath =  Usefulmethods.getQuery(configFilename, "DIGILOCKER_CERTIFICATE_PATH_WINDOWS");
			} else {
				filePath = Usefulmethods.getQuery(configFilename, "DIGILOCKER_CERTIFICATE_PATH_LINUX");
	
			}
			String fileName=filePath + benId + ".xml";
			//System.out.println("fileName>>>>" + fileName);
			// Write the XML string to a file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(xmlString);
            }
            
            // Step 2: Read the file contents into a byte array
            File file = new File(fileName);
            byte[] fileContent = new byte[(int) file.length()];
            try (FileInputStream fis = new FileInputStream(file)) {
                fis.read(fileContent);
            }

            // Step 3: Encode the byte array to Base64
            base64String = Base64.getEncoder().encodeToString(fileContent);

            // Output the Base64 string
           // System.out.println("Base64 Encoded String:");
            //System.out.println(base64String);

            // Step 4: Delete the XML file
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete the file.");
            }


			
		}catch (IOException e) {
            e.printStackTrace();
        }
		
		return base64String;
	}

}
