package thirdpartyservices.bharatkosh.client.digitalsign;


import java.io.File;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.io.FileUtils;

import thirdpartyservices.bharatkosh.client.req.BharatKoshPayment;
import thirdpartyservices.bharatkosh.service.BharatkoshPaymentBuilder;
import thirdpartyservices.bharatkosh.service.CGHSBharatkoshVO;


/**
 * How to use XmlSigner
 */
public class XmlSignerTest {
	


	public static void main(String[] args) throws Exception {
		XmlSignerTest test = new XmlSignerTest();
		//System.out.println(Calendar.getInstance().getTimeInMillis());
		test.shouldSignXmlUningAJavaKeyStoreBK();
		//test.shouldSignXmlUsingAJavaKeyStore();
	}
	
	public void shouldSignXmlUningAJavaKeyStoreBK() throws Exception {
		File xml = new File(XmlSigner.class.getResource("/thirdpartyservices/bharatkosh/client/digitalsign/BharatKoshPayment-Sample.xml").getFile());
		
		String xmlStr = FileUtils.readFileToString(xml, StandardCharsets.UTF_8);

		BharatKoshPayment payment = new BharatkoshPaymentBuilder(new CGHSBharatkoshVO())
				.build(new CGHSBharatkoshVO().getPaymentMaskCode_ONLINE());

		JAXBContext jaxbContext = JAXBContext.newInstance(BharatKoshPayment.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		//jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(payment, sw);
		String xmlString = sw.toString();
		

		SignedXml signedXml = new XmlSigner()
				.withXml(xmlString)
				.sign();

		String content = signedXml.getContent();
		//System.out.println("\n" + content); // just prints the result

		signedXml = new XmlSigner()
						.withXml(xmlStr)
						.sign();

		content = signedXml.getContent();
		//System.out.println("\n" + content); // just prints the result

		String base64 = signedXml.toBase64();
		//System.out.println("\n" + base64); // just prints the result
		
		byte[] decodedBytes = Base64.getDecoder().decode(base64);
		String decodedString = new String(decodedBytes);
		//System.out.println("\n" + decodedString);
	}
	
	public void shouldSignXmlUsingAJavaKeyStore() throws Exception {
		// scenario
		File xml = new File(XmlSigner.class.getResource("/thirdpartyservices/bharatkosh/digitalsign/BharatKoshPayment-Sample.xml").getFile());
		
		
		String xmlStr = FileUtils.readFileToString(xml, StandardCharsets.UTF_8);
		
		// action
		SignedXml signedXml = new XmlSigner()
					.withXml(xmlStr)  // it supports InputStream as well
					.sign();
		
		// validation
		String content = signedXml.getContent();
		//System.out.println("\n" + content); // just prints the result
		
		String base64 = signedXml.toBase64();
		//System.out.println("\n" + base64); // just prints the result
		
	}
}
