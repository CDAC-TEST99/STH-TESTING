package HisWeb.util;

import java.util.Calendar;


public class CghsSmsManager {
	
	public static String getTodayDateAndTime() {				// Common Function to get today's date and time
	    Calendar now = Calendar.getInstance();
	    int year = now.get(Calendar.YEAR) % 100; 
	    int month = now.get(Calendar.MONTH) + 1;  
	    int day = now.get(Calendar.DAY_OF_MONTH);  
	    int hour = now.get(Calendar.HOUR_OF_DAY);  
	    int minute = now.get(Calendar.MINUTE); 

	    String formattedDate = String.format("%02d-%02d-%02d", day, month, year);  
	    String formattedTime = String.format("%02d:%02d", hour, minute);

	    return formattedDate + " " + formattedTime;
	}
	
	public void sendOTPSMS(String mobile, String otp, String refNo) {
		String templateId = "1007164446925502675";
        String res = getTodayDateAndTime();
        System.out.println("dateTime" + res);
        String[] result = res.split(" ");
        System.out.println("dateTime" + result[1]);
		String message = "OTP for cghs.gov.in login is" + " " + otp + " " + "Reference No. " + refNo
				+ ". Please keep it safe for 5 minutes.(Generated at " + result[0] + " " + result[1] + ") - CGHS";

		new SendSMSUtil().sendSMS(mobile, templateId, message);
	}


}
