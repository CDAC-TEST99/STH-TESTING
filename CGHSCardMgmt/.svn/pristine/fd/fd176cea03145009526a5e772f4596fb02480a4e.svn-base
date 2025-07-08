package thirdpartyservices.bharatkosh.service;

import org.json.JSONObject;

public interface IBharatkoshClient {

	public String sign(String trackingId, String timestamp, String paymentMaskCode) throws Exception;

	public String sign(String trackingId, String timestamp) throws Exception;
	
	public void updateBharatkoshResp(String trackingId, String utrStr, String paymentStatus, String respXml);
	
	public JSONObject getBKPaymentStatus(String trackingId);
	
	public JSONObject trackBKPaymentStatus(String trackingId);
}
