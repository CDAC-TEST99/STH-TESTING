package thirdpartyservices.bharatkosh.service;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.json.JSONObject;

import hisglobal.utility.Usefulmethods;
import thirdpartyservices.bharatkosh.client.digitalsign.SignedXml;
import thirdpartyservices.bharatkosh.client.digitalsign.XmlSigner;
import thirdpartyservices.bharatkosh.client.req.BharatKoshPayment;

public class BharatkoshClient implements IBharatkoshClient{

	@Override
	public String sign(String trackingId, String timestamp) throws Exception {
		return sign(trackingId, timestamp, new CGHSBharatkoshVO().getPaymentTypeOnline());
	}
	
	@Override
	public String sign(String trackingId, String timestamp, String paymentMaskCode) throws Exception {
		System.out.println("BharatkoshClient>sign>TrackingID::" + trackingId+", paymentMaskCode::"+paymentMaskCode);
		BharatKoshPayment payment = new BharatkoshPaymentBuilder(
				buildCGHSBharatkoshPaymentVO(getBharatkoshPaymentDetails(trackingId))).build(paymentMaskCode);
		//String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
		StringBuilder txnId = new StringBuilder().append(trackingId).append("-").append(timestamp);
		payment.getSubmit().getOrderBatch().setMerchantBatchCode(txnId.toString());
		payment.getSubmit().getOrderBatch().getOrder().setOrderCode(txnId.toString());

		JAXBContext jaxbContext = JAXBContext.newInstance(BharatKoshPayment.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		// output pretty printed
		// jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		StringWriter sw = new StringWriter();
		jaxbMarshaller.marshal(payment, sw);
		String xmlString = sw.toString();

		
		
		SignedXml signedXml = new XmlSigner().withXml(xmlString).sign();
		System.out.println("signedXml\n" + signedXml);
		String content = signedXml.getContent();
		//System.out.println("\n" + content); // just prints the result

		String base64 = signedXml.toBase64();
		//System.out.println("\n" + base64); // just prints the result

		updateBharatkoshReq(trackingId, txnId.toString(), payment.toString(), paymentMaskCode ); //, base64);
		
		return base64;
	}
	
	private void updateBharatkoshReq(String trackingId, String txnId, String reqXml, String paymentMaskCode){ // , String signedXml) {
		//System.out.println("updateBharatkoshReq-->>"+trackingId);
		JSONObject objResponse = new JSONObject();

		JSONObject objFilterJson = new JSONObject();
		objFilterJson.put("tracking_id", trackingId);
		objFilterJson.put("txn_id", txnId);
		objFilterJson.put("bkReqXml", reqXml);
		objFilterJson.put("bkTxnType", paymentMaskCode);
		objFilterJson.put("txnType", "BKREQ");
		objFilterJson.put("bkTxnType", paymentMaskCode);
		//objFilterJson.put("signedXml", signedXml);
		
		Usefulmethods objUsefulmethods = new Usefulmethods();

		// Fetch Bharatkosh Payment Details
		String strServiceName1 = "service/updateBharatkoshReqResp";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

		//System.out.println(objResponse.toString());
	}
	
	@Override
	public void updateBharatkoshResp(String trackingId, String utrStr, String paymentStatus, String respXml) {
	System.out.println("updateBharatkoshResp-->>"+trackingId);
		JSONObject objResponse = new JSONObject();

		JSONObject objFilterJson = new JSONObject();
		objFilterJson.put("tracking_id", trackingId);
		objFilterJson.put("utrStr", utrStr);
		objFilterJson.put("bkRespXml", respXml);
		objFilterJson.put("txnType", "BKRESP");
		objFilterJson.put("paymentStatus", paymentStatus);
		
		
		Usefulmethods objUsefulmethods = new Usefulmethods();

		// Fetch Bharatkosh Payment Details
		String strServiceName1 = "service/updateBharatkoshReqResp";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

		//System.out.println(objResponse.toString());
		
	}

	private JSONObject getBharatkoshPaymentDetails(String trackingId) {
		JSONObject objFilterJson = new JSONObject();
		objFilterJson.put("pk0", trackingId);

		JSONObject objResponse = new JSONObject();

		Usefulmethods objUsefulmethods = new Usefulmethods();

		// Fetch Bharatkosh Payment Details
		String strServiceName1 = "service/getpaymentdetailsforbeneficiary";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

		/*
		 * System.out.println( "getBharatkoshPaymentDetails-->" +
		 * objResponse.toString());
		 */
		return (JSONObject) objResponse.optJSONArray("data").get(0);
	}

	private CGHSBharatkoshVO buildCGHSBharatkoshPaymentVO(JSONObject jsonObject) {

		CGHSBharatkoshVO bharatkoshVO = new CGHSBharatkoshVO();
		bharatkoshVO.setDepartmentCode(jsonObject.getString("departmentCode"));
		bharatkoshVO.setInstallationId(jsonObject.getString("installationId"));
		bharatkoshVO.setPaymentTypeId(jsonObject.getString("paymentTypeId"));
		bharatkoshVO.setPAOCode(jsonObject.getString("paoCode"));
		bharatkoshVO.setDDOCode(jsonObject.getString("ddoCode"));
		bharatkoshVO.setOrderContent(jsonObject.getString("orderContent"));
		bharatkoshVO.setPaymentTypeId(jsonObject.getString("paymentTypeId"));
		bharatkoshVO.setDescription(jsonObject.getString("description"));
		bharatkoshVO.setTotalAmount(jsonObject.getString("Amount"));
		String[] amount = jsonObject.getString("Amount").split("\\.");
		bharatkoshVO.setAmountValue(amount[0]);
		bharatkoshVO.setAmountExponent((amount.length > 1 ? amount[1] : "0"));
		bharatkoshVO.setEmailId(jsonObject.getString("emailId"));
		bharatkoshVO.setAddress1(jsonObject.getString("address1"));
		bharatkoshVO.setCity(jsonObject.getString("adcityname"));
		String[] patientName = jsonObject.getString("patname").split("\\s");
		bharatkoshVO.setFirstName(patientName[0]);
		bharatkoshVO.setLastName(patientName.length > 1 ? patientName[1] : "NA");
		bharatkoshVO.setMobileNumber(jsonObject.getString("mobileno"));
		return bharatkoshVO;
	}
	
	@Override
	public JSONObject getBKPaymentStatus(String trackingId) {
		JSONObject objFilterJson = new JSONObject();
		objFilterJson.put("pk0", trackingId);

		JSONObject objResponse = new JSONObject();

		Usefulmethods objUsefulmethods = new Usefulmethods();

		// Fetch Bharatkosh Payment Details
		String strServiceName1 = "service/getBKPaymentStatus";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

		/*
		 * System.out.println( "getBKPaymentStatus-->" + objResponse.toString());
		 */
		JSONObject objResult = (JSONObject) objResponse.optJSONArray("data").get(0);
		objResult.put("tracking_id", trackingId);
		return objResult;
	}
	
	@Override
	public JSONObject trackBKPaymentStatus(String trackingId) {
		JSONObject objFilterJson = new JSONObject();
		objFilterJson.put("pk0", trackingId);

		JSONObject objResponse = new JSONObject();

		Usefulmethods objUsefulmethods = new Usefulmethods();

		// Fetch Bharatkosh Payment Details
		String strServiceName1 = "service/trackBKPaymentStatus";
		objResponse = objUsefulmethods.callService(objFilterJson, strServiceName1);

		/*
		 * System.out.println( "trackBKPaymentStatus-->" + objResponse.toString());
		 */
		JSONObject objResult = new JSONObject();
		objResult.put("data", objResponse.optJSONArray("data"));
		return objResult;
	}
}
