package HisWeb.util;

import org.json.JSONObject;

public class CghsSmsManager {


	public static void sendMobileVerificationOTP(String inputData) {			// SMS to send otp while applying for plastic card
		//System.out.println("inside cghs sms manager");
		String templateId = "1007161198693363688";
		JSONObject object = new JSONObject(inputData);
	//	System.out.println("Object>>>> " + object);

		final String otp = object.getString("otp");
		//final String refNo = object.getString("refNo");
		final String mobileNumber = object.getString("mobile");
		//System.out.println("otp>>>" + otp + " mobileNumber>>>>" + mobileNumber);
		
		String message = "One Time Password (OTP) for Apply plastic card is:"+otp+". - CGHS";
				
		  
		  new SendSMSUtil().sendCGHLTHSMS(mobileNumber, templateId, message);
	
		//System.out.println("Function called using dynamic formflowx function");
	}
	


}
