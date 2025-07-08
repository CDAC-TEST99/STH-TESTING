package thirdpartyservices.bharatkosh.client.digitalsign;

import java.util.Base64;

/**
 * Represents a signed XML
 */
public class SignedXml {

	private String content;

	public SignedXml(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}
	

	public String toBase64() {
		String base64Xml = Base64.getEncoder().encodeToString(content.getBytes());
		return base64Xml;
	}
	
	public String decodeBase64(String base64) {
		byte[] decodedBytes = Base64.getDecoder().decode(base64);
		return new String(decodedBytes);

	}
}