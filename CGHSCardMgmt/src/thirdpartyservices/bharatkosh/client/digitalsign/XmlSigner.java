package thirdpartyservices.bharatkosh.client.digitalsign;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.xml.crypto.dsig.CanonicalizationMethod;
import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.Reference;
import javax.xml.crypto.dsig.SignatureMethod;
import javax.xml.crypto.dsig.SignedInfo;
import javax.xml.crypto.dsig.Transform;
import javax.xml.crypto.dsig.XMLSignature;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.dom.DOMSignContext;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509IssuerSerial;
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;
import javax.xml.crypto.dsig.spec.TransformParameterSpec;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;

/**
 * Responsible for signing a specific XML using private key certificate
 */
public class XmlSigner {

	private InputStream sourceXml;

	/**
	 * Signs a specific XML using a private key via Java Key Store format
	 *
	 * More information:
	 * https://gist.github.com/rponte/4039958
	 * https://github.com/SUNET/eduid-mm-service/tree/master/src/main/java/se/gov/minameddelanden/common
	 * https://stackoverflow.com/questions/5330049/java-equivalent-of-c-sharp-xml-signing-method
	 */
	public SignedXml sign() throws Exception {


        // access & read file only by server (not include anywhere in client request).
		//  ----------------------- Path to pfx file ----------
       File privateKeyFile = new File(XmlSigner.class.getResource(Constants.PROD_PVT_KEY).getFile());
       // File privateKeyFile = new File(XmlSigner.class.getResource(Constants.UAT_PVT_KEY).getFile());

        
        XMLSignatureFactory fac = XMLSignatureFactory.getInstance("DOM");
        Reference ref = fac.newReference
                ("", fac.newDigestMethod(DigestMethod.SHA1, null),
                        Collections.singletonList
                                (fac.newTransform
                                        (Transform.ENVELOPED, (TransformParameterSpec) null)),
                        null, null);

        SignedInfo si = fac.newSignedInfo
                (fac.newCanonicalizationMethod
                                (CanonicalizationMethod.INCLUSIVE,
                                        (C14NMethodParameterSpec) null),
                        fac.newSignatureMethod(SignatureMethod.RSA_SHA1, null),
                        Collections.singletonList(ref));

        KeyStore p12 = KeyStore.getInstance("pkcs12");

 

//---- getting the private key out of pfx
       p12.load(new FileInputStream(privateKeyFile),Constants.PROD_PVT_KEY_PASS.toCharArray());
        //p12.load(new FileInputStream(privateKeyFile),Constants.UAT_PVT_KEY_PASS.toCharArray());
        Enumeration e = p12.aliases();
        String alias = (String) e.nextElement();
        KeyStore.PrivateKeyEntry keyEntry = (KeyStore.PrivateKeyEntry) p12.getEntry(alias,
               new KeyStore.PasswordProtection(Constants.PROD_PVT_KEY_PASS.toCharArray()));
      //  new KeyStore.PasswordProtection(Constants.UAT_PVT_KEY_PASS.toCharArray()));

        // Load the KeyStore and get the signing key and certificate.
        X509Certificate cert = (X509Certificate) keyEntry.getCertificate();

        // Create the KeyInfo containing the X509Data.
        KeyInfoFactory kif = fac.getKeyInfoFactory();

        ArrayList x509Content = new ArrayList();

        // according to third party API implementation document.
        String dn = cert.getIssuerDN().toString();
        BigInteger sn = cert.getSerialNumber();
        BigInteger bigsn2 = new BigInteger (1, sn.toByteArray());
        X509IssuerSerial xd1 = kif.newX509IssuerSerial(dn, bigsn2);
        x509Content.add(xd1);
        x509Content.add(cert);

        javax.xml.crypto.dsig.keyinfo.X509Data xd = kif.newX509Data(x509Content);
        javax.xml.crypto.dsig.keyinfo.KeyInfo ki = kif.newKeyInfo(Collections.singletonList(xd));

        ByteArrayInputStream xmlStream = new ByteArrayInputStream(IOUtils.toByteArray(sourceXml));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.setNamespaceAware(true);
        dbf.setIgnoringElementContentWhitespace(false);
        dbf.setValidating(true);

        Document doc = dbf.newDocumentBuilder().parse(xmlStream );

        doc.setXmlStandalone(true);

        DOMSignContext dsc = new DOMSignContext(keyEntry.getPrivateKey(), doc.getDocumentElement());

        XMLSignature signature = fac.newXMLSignature(si, ki);

        signature.sign(dsc);

//         Output the resulting document.
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer trans = tf.newTransformer();
        trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        trans.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter writer = new StringWriter();
        trans.transform(new DOMSource(doc), new StreamResult(writer));
        String rawSignedXml = writer.getBuffer().toString().replaceAll("\n|\r", "");

		SignedXml xml = new SignedXml(rawSignedXml);

        return xml;

    }
	
	public XmlSigner withXml(InputStream sourceXml) {
		
		if (sourceXml == null)
			throw new XmlSigningException("XML can not be null");
		
		this.sourceXml = sourceXml;
		return this;
	}
	
	public XmlSigner withXml(String sourceXml) {
		InputStream input = IOUtils.toInputStream(sourceXml, StandardCharsets.UTF_8);
		return withXml(input);
	}

}