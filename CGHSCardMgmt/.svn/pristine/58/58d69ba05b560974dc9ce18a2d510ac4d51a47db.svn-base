package thirdpartyservices.pan.varification.digitalsign;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.CertStore;
import java.security.cert.Certificate;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Enumeration;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;

import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import thirdpartyservices.pan.varification.model.PANRequestBody;
import thirdpartyservices.pan.varification.model.PANRequestData;

public class PANJsonSigner {

	public PANRequestBody sign(PANRequestData panRequestData) throws Exception {

		// access & read file only by server (not include anywhere in client request).
		// ----------------------- Path to pfx file ----------
		File privateKeyFile = new File(PANJsonSigner.class.getResource(PanConstants.PROD_PVT_SIGN_KEY).getFile());

		XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
		Reference ref = fac.newReference("", fac.newDigestMethod(DigestMethod.SHA1, null),
				Collections.singletonList(fac.newTransform(Transform.ENVELOPED, (TransformParameterSpec) null)), null,
				null);

		SignedInfo si = fac.newSignedInfo(
				fac.newCanonicalizationMethod(CanonicalizationMethod.INCLUSIVE, (C14NMethodParameterSpec) null),
				fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null), Collections.singletonList(ref));

		KeyStore p12 = KeyStore.getInstance("pkcs12");

//---- getting the private key out of pfx
		p12.load(new FileInputStream(privateKeyFile), PanConstants.PROD_PVT_KEY_PASS.toCharArray());
		Enumeration e = p12.aliases();
		String alias = (String) e.nextElement();
		KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) p12.getEntry(alias,
				new KeyStore.PasswordProtection(PanConstants.PROD_PVT_KEY_PASS.toCharArray()));

		// Load the KeyStore and get the signing key and certificate.
		X509Certificate cert = (X509Certificate) keyEntry.getCertificate();
		
		
		CMSSignedDataGenerator sgen = new CMSSignedDataGenerator();
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider ());
		sgen.addSigner(keyEntry.getPrivateKey(), cert, CMSSignedDataGenerator.DIGEST_SHA1);
		
		//Retrieve the certificate chain and add it to the Cms generator
		Certificate[] certChain =p12.getCertificateChain(alias);
		ArrayList certList = new ArrayList();
		CertStore certs = null;
		for (int i=0; i < certChain.length; i++)
			certList.add(certChain[i]); 
		sgen.addCertificatesAndCRLs(CertStore.getInstance("Collection", new CollectionCertStoreParameters(certList), "BC"));
		
		/*************************************/
		/*
		 * JSON Object created for creating a signature.
		 */
		/*************************************/
		//Creating a object of the input bean file
		PANRequestData inputdataBean = new PANRequestData();
		ArrayList<PANRequestData> inputdataBeanList = new ArrayList();
		inputdataBeanList.add(panRequestData);
		
		//Creating a object of GsonBuilder using disableHtmlEscaping we are using disableHtmlEscaping because this will accept the value of special characters as it is.
		
		GsonBuilder builder = new GsonBuilder().disableHtmlEscaping(); 
	    Gson gson = builder.create(); 
	    //Gson gson = new Gson();  
		//Creating the Json from the GSON so that the input format and the request order will not changed during the generation.
	    String inputdataBeanJson = gson.toJson(inputdataBeanList);
		
	    //System.out.print(inputdataBeanJson); 
	   
	    //taking data what needs to be signed
	    byte[] dataToSign=inputdataBeanJson.getBytes();  
		
		//Generating the signature with the values which are set in the bean file
		CMSSignedData csd = sgen.generate(new CMSProcessableByteArray(dataToSign),true, "BC");
		byte[] signedData = csd.getEncoded();
		byte[] signedData64 = Base64.getEncoder().encode(signedData); 		
		ByteArrayOutputStream byteArrayOutStr = new ByteArrayOutputStream();
		byteArrayOutStr.write(signedData64);

		/*
		 * Create Request Body of HIT
		 */
		 //Creating a new bean file RequestBodyBean which contains the whole input data Json and Signature
		//Setting the value of signature and Input data in the bean file
		PANRequestBody requestBody=new PANRequestBody();
		requestBody.setInputData(inputdataBeanList);
		requestBody.setSignature(byteArrayOutStr.toString());

		
		return requestBody;
	}

}