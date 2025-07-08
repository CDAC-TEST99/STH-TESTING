package thirdpartyservices.apisetu.digilocker.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

import thirdpartyservices.apisetu.digilocker.service.DigiConstant;

public class DigiUtil {

	private static String bytesToHex(byte[] hash) {
	    StringBuilder hexString = new StringBuilder(2 * hash.length);
	    for (int i = 0; i < hash.length; i++) {
	        String hex = Integer.toHexString(0xff & hash[i]);
	        if(hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
	private static String hashFunction(String stringToHash) throws Exception {

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		byte[] encodedhash = messageDigest.digest(
				stringToHash.getBytes(StandardCharsets.UTF_8));
		String stringHash = bytesToHex(messageDigest.digest());
		
		//System.out.println("stringHash::"+stringHash);
		return stringHash;
		
	}
	
	public static String getKeyHash() throws Exception {
		String stringToHash = DigiConstant.APP_ID + getTimestamp();
		return DigiUtil.hashFunction(stringToHash);
	}
	
	public static String getTimestamp() {
	    ZoneId  india = ZoneId.of("Asia/Kolkata");   
	    ZonedDateTime zone1  = ZonedDateTime.of(LocalDateTime.now(), india);   
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
	//	System.out.println(formatter.format(zone1));
		return formatter.format(zone1);

	}
	
	public static String getTxnId() {
		String txnId = UUID.randomUUID().toString();
		//System.out.println(txnId);
		return txnId;
	}
	
	public static String getURI(String benId) {
		return DigiConstant.IssuerID_MUDIT_SIR + "-" + DigiConstant.DoctType_MUDIT_SIR + "-" + benId;
	}
	
	public static void main(String[] args) throws Exception {
		String stringToHash = DigiConstant.IssuerID_MUDIT_SIR + "#" + DigiConstant.DoctType_MUDIT_SIR + "#" + new Date().getTime();
		DigiUtil.hashFunction(stringToHash);
		getTimestamp();
		getTxnId();
	}
}
