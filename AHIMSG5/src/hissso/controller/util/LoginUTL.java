package hissso.controller.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.util.TokenHelper;
import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionContext;

import HisWeb.util.SMSClient;
import hisglobal.config.HISConfig;
import hisglobal.exceptions.old.HisException;
import hisglobal.security.SecureCryptAlgorithm;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import hisglobal.utility.helper.DateHelperMethods;
import hislogin.config.HISLoginConfig;
import hissso.config.HISSSOConfig;
import hissso.config.HISSSOServerConfig;
import hissso.config.HISSSOSupport;
import hissso.controller.actionsupport.LoginSUP;
import hissso.controller.data.LoginDATA;
import hissso.security.SecureHashAlgorithm;
import hissso.ticket.HISTicketGrantingTicket;
import hissso.ticket.TicketGrantingTicket;
import hissso.ticket.expiration.HISExpiration;
import hissso.ticket.expiration.TicketGrantingTicketExpiration;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;
import usermgmt.config.UserManagementConfig;
import vo.hissso.LoginVO;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserLoginLogVO;
import vo.usermgmt.UserMasterVO;
import vo.usermgmt.UserSeatVO;

public class LoginUTL {
	public static boolean setInititals(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		boolean flg = true;
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			// Change Session Salt
			String randomSessionSalt = SecureHashAlgorithm
					.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
			objSession.setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);

			// Setting Dashborad hospital Combo
			// getHospitalList(objRequest, objResponse);

			String token = SecureCryptAlgorithm.generateKeyAES();
			objSession.setAttribute("sessionLoginToken", token);

			// Clearing Form Data
			objActionSupport.clear();

			objActionSupport.setSessionLoginToken(token);

			setclientDetailsInSession(objRequest);

			// dashBoardData(objRequest, objResponse);
			// dashBoardData1(objRequest, objResponse);

		} catch (IllegalStateException e) {
			try {
				flg = true;
				// Change Session Salt
				String randomSessionSalt = SecureHashAlgorithm
						.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
				objRequest.getSession().setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);
			} catch (Exception ee) {
				flg = false;
				// Log or Populate Error Here
				// Set Error Message
				// objActionSupport.addActionError("Unknown Problem Occured!");
				e.printStackTrace();// Hide This for Production
			}
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static void getHospitalList(HttpServletRequest objRequest, HttpServletResponse objResponse) {
		List HospitalList = new ArrayList();
		HttpSession objSession = null;
		objSession = objRequest.getSession();
		HospitalList = LoginDATA.getHospitalList();
		objSession.setAttribute(HISSSOServerConfig.LOGIN_HOSPITAL_LIST_KEY, HospitalList);
	}

	private static final int OTP_MAX_LENGTH = 6;
	private static final int REFNO_MAX_LENGTH = 4;
	private static final LinkedHashMap<String, OTPData> otpmap = new LinkedHashMap<>();
	private static final LinkedHashMap<String, OTPData> otpmapBen = new LinkedHashMap<>();
	private static final LinkedHashMap<String, OTPData> otpforgetPass = new LinkedHashMap<>();
	private static final LinkedHashMap<String, OTPData> otpforgetPassBen = new LinkedHashMap<>();
	private static final LinkedHashMap<String, OTPData> otpRegisterPassBen = new LinkedHashMap<>();
	private static final LinkedHashMap<String, OTPData> otpUnlockUser = new LinkedHashMap<>();
	private static final long OTP_EXPIRATION_TIME = 900000; 

	// Generate and store OTP for a mobile number
	public static String generateAndStoreOTPForForgetPass(String mobileNumber, String userId) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));
		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */

		otpforgetPass.put(mobileNumber, new OTPData(otp, currentTime, refNo));

		return refNo + "#" + otp;
	}
	public static String generateAndStoreOTPForForgetPassBen(String mobileNumber, String userId) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));
		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */

		otpforgetPassBen.put(mobileNumber, new OTPData(otp, currentTime, refNo));

		return refNo + "#" + otp;
	}
	
	public static String generateAndStoreOTPForUnlockBen(String mobileNumber, String userId) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));
		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */

		otpUnlockUser.put(mobileNumber, new OTPData(otp, currentTime, refNo));

		return refNo + "#" + otp;
	}
	public static String generateAndStoreOTPForRegisterPassBen(String mobileNumber, String userId) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));
		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */
		
		otpRegisterPassBen.put(mobileNumber, new OTPData(otp, currentTime, refNo));

		return refNo + "#" + otp;
	}

	// Generate and store OTP for a mobile number
	public static String generateAndStoreOTP(String mobileNumber) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));
		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */
		
		otpmap.put(mobileNumber.trim(), new OTPData(otp, currentTime, refNo));
		return refNo + "#" + otp;
	}

	// Generate and store OTP for a mobile number
	public static String generateAndStoreOTPForBen(String mobileNumber) {
		SecureRandom random = new SecureRandom();

		String otp = String.format("%0" + OTP_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, OTP_MAX_LENGTH)));

		String refNo = String.format("%0" + REFNO_MAX_LENGTH + "d", random.nextInt((int) Math.pow(10, REFNO_MAX_LENGTH)));

		// should be removed later
		// otp = "1234";

		long currentTime = System.currentTimeMillis();
		/*
		 * otpmap.put(mobileNumber, otp);
		 */

		otpmapBen.put(mobileNumber, new OTPData(otp, currentTime, refNo));

		return refNo + "#" + otp;
	}

	static class OTPData {
		String otp;
		String refNo;
		long timestamp;

		OTPData(String otp, long timestamp, String refNo) {
			this.otp = otp;
			this.refNo = refNo;
			this.timestamp = timestamp;
		}
	}

	// Main Login Handler
	public static boolean mLoginUserByMobile(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, String mobileNumber, String otpCount) {
		boolean isSuccess = true;
		HttpSession session;
		HttpSession objSession = objRequest.getSession();

		try {
			session = objRequest.getSession();

			if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
				objSession.setAttribute("LoginError", "Mobile number is required!");

				return false;
			}

			String mobileStatus = checkMobileNum(mobileNumber, objRequest, objResponse);
			int mobileS = Integer.parseInt(mobileStatus);
			if(mobileS > 1) {
				objSession.setAttribute("LoginError", "Mobile Number Registered for more than One User. Cannot Login!");
				return false;
			}
			else if (!"1".equals(mobileStatus)) {
				System.out.println("action message");

				objSession.setAttribute("LoginError", "Invalid or unregistered mobile number!");
				/*
				 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
				 */
				return false;
			}

			String otp = generateAndStoreOTP(mobileNumber);

			sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
			objSession.setAttribute("LoginError", "");

			session.setAttribute("otpValidationKey", mobileNumber);

			session.setAttribute("otpCount_" + mobileNumber, (Integer.valueOf(otpCount) + 1));

			session.setAttribute("otpRefNo_" + mobileNumber, otp.split("#")[0]);

		} catch (Exception e) {

			objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

			isSuccess = false;
			e.printStackTrace();
		}

		return isSuccess;
	}

	private static String checkMobileNum(String mobileNumber, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
		String status = null;
		WebRowSet wb = null;
		try {
			String query = "SELECT count(gnum_isvalid) FROM UMMT_USER_MST WHERE gnum_mobile_number = '" + mobileNumber
					+ "' AND gnum_isvalid = 1";
			int nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			if (wb.next()) {
				status = wb.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// Main Login Handler
	public static boolean mLoginBenByMobile(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, String mobileNumber, String otpCount) {
		boolean isSuccess = true;
		HttpSession session;
		HttpSession objSession = objRequest.getSession();

		try {
			session = objRequest.getSession();

			if (mobileNumber == null || mobileNumber.trim().isEmpty()) {
				objSession.setAttribute("LoginError", "Mobile number is required!");

				return false;
			}

			String mobileStatus = checkBenMobileNum(mobileNumber, objRequest, objResponse);
			int mobileS = Integer.parseInt(mobileStatus);
			if(mobileS > 1) {
				objSession.setAttribute("LoginError", "Mobile Number Registered for more than One User. Cannot Login!");
				return false;
			}
			if (!"1".equals(mobileStatus)) {
				System.out.println("action message");

				objSession.setAttribute("LoginError",
						"Invalid / Unregistered or Not a Main Card Holder Mobile number!");
				/*
				 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
				 */
				return false;
			}

			String otp = generateAndStoreOTPForBen(mobileNumber);

			sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
			objSession.setAttribute("LoginError", "");

			session.setAttribute("otpValidationKey", mobileNumber);

			session.setAttribute("otpCount_" + mobileNumber, (Integer.valueOf(otpCount) + 1));

			session.setAttribute("otpRefNo_" + mobileNumber, otp.split("#")[0]);

		} catch (Exception e) {

			objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

			isSuccess = false;
			e.printStackTrace();
		}

		return isSuccess;
	}

	private static String checkBenMobileNum(String mobileNumber, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
		String status = null;
		WebRowSet wb = null;
		try {
			String query = "SELECT count(gnum_isvalid) FROM hrgt_patient_dtl WHERE hrgstr_mobile_no = '" + mobileNumber
					+ "' AND gnum_isvalid = 1 and is_main_card_holder = 1 ";
			int nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			if (wb.next()) {
				status = wb.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	private static String getMobileNoByUserId(String userId, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
		String status = "";
		WebRowSet wb = null;
		try {
			String query = "select gnum_mobile_number from ummt_user_mst where gnum_isvalid = 1 and gstr_login_id ='"
					+ userId + "' ";
			int nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			if (wb.next()) {
				status = wb.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	private static String getMobileNoByBenId(String userId, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
		String status = "";
		WebRowSet wb = null;
		try {
			String query = "select hrgstr_mobile_no from hrgt_patient_dtl where gnum_isvalid = 1 and hrgnum_puk ='"
					+ userId + "' ";
			int nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			if (wb.next()) {
				status = wb.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

	private static String todayDateAndTime() {
		Date now = new Date();

		// Define the desired date and time formats
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

		// Format the date and time
		String formattedDate = dateFormat.format(now);
		String formattedTime = timeFormat.format(now);

		return formattedDate + "#" + formattedTime;

	}

	// Helper Method to Send OTP via SMS
	private static void sendOtpSMS(String mobileNumber, String otp, String refNo) {					//Login otp
		JSONObject json = new JSONObject();
		try {
			String[] mobileNumbers = { mobileNumber };
			json.put("mobileNumbers", mobileNumbers);
			json.put("templateId", "1107174358317715752");

			String message = "OTP for cghs.mohfw.gov.in login is {#var#} Reference No. {#var#} . Please keep it safe for 5 minutes."
					+ "(Generated at {#var#} {#var#}) - CGHS";

			json.put("message", message);
			String var = todayDateAndTime();
			String[] data = { otp, refNo, var.split("#")[0], var.split("#")[1] };
			json.put("data", data);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		new SMSClient().SendSMSClient(json.toString());

	}
	
	private static void sendGeneralOtpSMS(String mobileNumber, String otp, String refNo) {
		JSONObject json = new JSONObject();
		try {
			String[] mobileNumbers = { mobileNumber };
			json.put("mobileNumbers", mobileNumbers);
			json.put("templateId", "1107174437151309736");

			String message = "Your OTP is {#var#}. Use it within {#var#}. For security reasons, do not share the OTP. -CGHS";

			json.put("message", message);
			String var = todayDateAndTime();
			String[] data = { otp, "5 mins" };
			json.put("data", data);

		} catch (JSONException e) {

			e.printStackTrace();
		}

		new SMSClient().SendSMSClient(json.toString());

	}

	// Validate the OTP for a mobile number
	/* @SuppressWarnings("null") */
	public static int mValidateOtp2(String mobileNumber, String userOtp, HttpServletRequest objRequest) {

		System.out.println("Inside by mValidateOTP2 USER");
		
		OTPData correctOTP = otpmap.get(mobileNumber);
		// System.out.println("correct OTP>>>>"+ correctOTP+ "user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;

		}
		//String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		

		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpmap.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}

		else if (correctOTP.otp.equals(userOtp) ) {
			otpmap.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}
	public static int mValidateOtp(String mobileNumber, String userOtp, HttpServletRequest objRequest) {

		System.out.println("Inside by mValidateOTP USER");
		
		OTPData correctOTP = otpmap.get(mobileNumber);
		// System.out.println("correct OTP>>>>"+ correctOTP+ "user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;

		}
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		

		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpmap.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}

		else if (correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService) ) {
			otpmap.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}

	public static int mValidateOtpForBen(String mobileNumber, String userOtp, HttpServletRequest objRequest) {

		System.out.println("Inside by mValidateOTP BEN");

		OTPData correctOTP = otpmapBen.get(mobileNumber);
		if (correctOTP == null) {
			return 3;

		}
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpmapBen.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}
		
		else if (correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService) ) {
			otpmapBen.remove(mobileNumber);

			return 1; 
		} else {
			return 2;
		}
	}
	public static int mValidateOtpForBen2(String mobileNumber, String userOtp, HttpServletRequest objRequest) {

		System.out.println("Inside by mValidateOTP BEN");

		OTPData correctOTP = otpmapBen.get(mobileNumber);
		if (correctOTP == null) {
			return 3;

		}
		//String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpmapBen.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}
		
		else if (correctOTP.otp.equals(userOtp)  ) {
			otpmapBen.remove(mobileNumber);

			return 1; 
		} else {
			return 2;
		}
	}

	/*
	 * // Method to fetch user by mobile number public static UserMasterVO
	 * getValidUserMobileDetail(String mobileNumber) { try { return
	 * LoginDATA.getValidUserMobileDetail(mobileNumber); } catch (Exception e) {
	 * e.printStackTrace(); return null; } }
	 */

	public static String loginUser(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {											// Check UserName, Password -> the send the otp to its Registered mobileNumber  
		String flg = "0";
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			String strSessionSalt = (String) objSession.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT);

			if (strSessionSalt == null || strSessionSalt.equalsIgnoreCase("")) {
				flg = "0";
				objActionSupport.addActionError("Page is expired kindly refresh the page!");
			} else {

				LoginVO voLogin = new LoginVO();
				BeanUtils.copyProperties(voLogin, objActionSupport);
				voLogin.setVarLoginSessionSalt(strSessionSalt);

				if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

					voLogin.setVarIPAddress(
							new String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

				} else {

					voLogin.setVarIPAddress(objRequest.getRemoteAddr());

				}

				UserMasterVO voUser = LoginDATA.getValidUserDetail(voLogin);
				
				System.out.println("skip otp Flag >>>> "+voUser.getVarSkipOtp());
				
				if(voUser !=null &&  voUser.getVarLoggedIn() != null  && voUser.getVarLoggedIn().equals(HISConfig.YES) && voUser.getVarSkipOtp().equals("0") ){ 
					
					String mobileNumber = voUser.getVarMobileNumber();
					String userIdd = voUser.getVarUserId();
					
					objSession.setAttribute("userIdd", userIdd);
					
					if(mobileNumber == null || ( mobileNumber != null && mobileNumber.trim().length() < 10 )) {
						objRequest.setAttribute("LoginError", "Invalid Mobile Number! Please update your Mobile Number to Login!");
						return "6";
					}
					
					String otp = generateAndStoreOTP(mobileNumber);
					sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
					
					String otpCount = (objSession.getAttribute("otpCount_" + mobileNumber) != null
							&& objSession.getAttribute("otpCount_" + mobileNumber).toString().length() > 0
									? objSession.getAttribute("otpCount_" + mobileNumber).toString()
									: "0");
					
					//System.out.println("otpCount>>>> " + otpCount );
					
					if (Integer.valueOf(otpCount) > 2) {

						objSession.setAttribute("otpValidationKey", "");

						objSession.setAttribute("otpCount_" + mobileNumber, "");
						objSession.setAttribute("otpRefNo_" + mobileNumber, "" );

						objRequest.setAttribute("LoginError", "Maximum OTP Count Reached");
						return "5";
						
					}
					objSession.setAttribute("LoginError", "");
					objSession.setAttribute("PatmobileNumber", mobileNumber.trim()); 
					objSession.setAttribute("USERlOGIN", "1"); 
					objSession.setAttribute("otpValidationKey", mobileNumber.trim());

					objSession.setAttribute("otpCount_" + mobileNumber, (Integer.valueOf(otpCount) + 1));

					objSession.setAttribute("otpRefNo_" + mobileNumber, otp.split("#")[0]);
					
					return "4";
				}
				else if(voUser !=null &&  voUser.getVarLoggedIn() != null  && voUser.getVarLoggedIn().equals(HISConfig.YES) && voUser.getVarSkipOtp().equals("1")) {
					
				
					if (voUser.getUserSeatsDtl() != null && voUser.getUserSeatsDtl().size() == 1) {

						flg = "1";

						voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());
						voUser.setVarHospitalCode(voUser.getUserSeatsDtl().get(0).getVarSeatHospitalId());

						List<HospitalMasterVO> lstHospital = LoginDATA.getHospitalVos(voUser.getVarHospitalCode());

						voUser.setVoHospital(lstHospital.get(0));
						
						if (!voUser.getVarUserId().contains("^")) {
							voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());
							voUser.setVarUserSeatId("0");
						} else {
							voUser.setVarUserId(voUser.getVarUserId().replace("^", "#").split("#")[0] + "^"
									+ voUser.getVarSeatId());
							
							voUser.setVarUserSeatId("0");
							
						}

						if (loginUserWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

							return "1";
						} else {

							return "0";
						}

					} else {
						objSession.setAttribute("preUserDtls", voUser);
						objSession.setAttribute("preLoginDtls", voLogin);

						String seatPageData = seatDetails(voUser, "selectRole");

						objSession.setAttribute("seatPageData", seatPageData);

						flg = "2";
					}

				
					
					
				
				
				}
				
				if (voUser != null && voUser.getVarLoginMessage() != null
						&& voUser.getVarLoginMessage().trim().length() > 0) {

					objRequest.getSession().setAttribute("userDtls",
							voUser.getVarUserId() + "#" + voUser.getVarUserName() + "#" + voUser.getVarUsrName());
				//	System.out.println("INSIDE 3#");
					return "3#" + voUser.getVarLoginMessage();
				}

				if (voUser != null && voUser.getVarLoggedIn() != null  && voUser.getVarLoggedIn().equals(HISConfig.YES)) {

					if (!voUser.getVarUserId().contains("^"))
						voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarUserSeatId());

					if (voUser.getUserSeatsDtl() != null && voUser.getUserSeatsDtl().size() == 1) {

						flg = "1";

						voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());
						voUser.setVarHospitalCode(voUser.getUserSeatsDtl().get(0).getVarSeatHospitalId());

						List<HospitalMasterVO> lstHospital = LoginDATA.getHospitalVos(voUser.getVarHospitalCode());

						voUser.setVoHospital(lstHospital.get(0));

						if (!voUser.getVarUserId().contains("^")) {
							voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());
						} else {
							voUser.setVarUserId(voUser.getVarUserId().replace("^", "#").split("#")[0] + "^"
									+ voUser.getVarSeatId());
						}

						if (loginUserWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

							return "1";
						} else {

							return "0";
						}

					} else {
						objSession.setAttribute("preUserDtls", voUser);
						objSession.setAttribute("preLoginDtls", voLogin);

						String seatPageData = seatDetails(voUser, "selectRole");

						objSession.setAttribute("seatPageData", seatPageData);

						flg = "2";
					}

				}

			}

		} catch (Exception e) {
			flg = "0";
			e.printStackTrace();

		}

		return flg;
	}

	public static String mloginUserFinal(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, String mobileNo) {
		String flg = "0";
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();

			LoginVO voLogin = new LoginVO();
			BeanUtils.copyProperties(voLogin, objActionSupport);

			if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

				voLogin.setVarIPAddress(new String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

			} else {

				voLogin.setVarIPAddress(objRequest.getRemoteAddr());

			}
			Object userIddObj = objSession.getAttribute("userIdd");
			String userIdd = (userIddObj != null) ? userIddObj.toString() : ""; ;
		
			if( userIdd != null || userIdd != "" ) {
				voLogin.setVarUserId(userIdd);
			}
			else {
				voLogin.setVarUserId("");
			}
			voLogin.setVarMobileNumber(mobileNo);

			/*-------------------------------------------------------------------*/
			// Checking Valid User Detail from DB
			// Fetching/Setting User Specific Details (User/Hospital Data,
			// Custom Desk, First Process etc.)
			UserMasterVO voUser = LoginDATA.getmValidUserDetail(voLogin);
			voUser.setActiveSessionFlag(voLogin.getActiveSessionFlag());

			if (voUser != null && voUser.getVarLoginMessage() !=null && voUser.getVarLoginMessage().trim().length() > 0 ) {
				objRequest.getSession().removeAttribute("otpValidationKey");
				return "3#" + voUser.getVarLoginMessage();
			}

			if (voUser != null && voUser.getVarLoggedIn().equals(HISConfig.YES)) {

				/*
				 * if(!voUser.getVarUserId().contains("^"))
				 * voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarUserSeatId());
				 */

				if (voUser.getUserSeatsDtl() != null && voUser.getUserSeatsDtl().size() == 1) {

					flg = "1";

					voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());
					voUser.setVarHospitalCode(voUser.getUserSeatsDtl().get(0).getVarSeatHospitalId());

					List<HospitalMasterVO> lstHospital = LoginDATA.getHospitalVos(voUser.getVarHospitalCode());

					voUser.setVoHospital(lstHospital.get(0));
					
					if (!voUser.getVarUserId().contains("^")) {
						voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());
						voUser.setVarUserSeatId("0");
					} else {
						voUser.setVarUserId(voUser.getVarUserId().replace("^", "#").split("#")[0] + "^"
								+ voUser.getVarSeatId());
						
						voUser.setVarUserSeatId("0");
						
					}

					if (loginUserWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

						return "1";
					} else {

						return "0";
					}

				} else {
					objSession.setAttribute("preUserDtls", voUser);
					objSession.setAttribute("preLoginDtls", voLogin);

					String seatPageData = seatDetails(voUser, "selectRole");

					objSession.setAttribute("seatPageData", seatPageData);

					flg = "2";
				}

			}

		} catch (Exception e) {
			flg = "0";
			e.printStackTrace();

		}

		return flg;
	}

	public static String mloginBenFinal(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, String mobileNo) {
		String flg = "0";
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();

			LoginVO voLogin = new LoginVO();
			BeanUtils.copyProperties(voLogin, objActionSupport);

			if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

				voLogin.setVarIPAddress(new String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

			} else {

				voLogin.setVarIPAddress(objRequest.getRemoteAddr());

			}

			voLogin.setVarMobileNumber(mobileNo);
			String benIdd ="";
			if(objSession.getAttribute("benIdd") != null ) {
				benIdd = (objSession.getAttribute("benIdd")).toString() ;
			}
			if( benIdd != null || benIdd != "" ) {
				voLogin.setVarUserName(benIdd);
			}
			else {
				voLogin.setVarUserName("");
			}

			/*-------------------------------------------------------------------*/
			// Checking Valid User Detail from DB
			// Fetching/Setting User Specific Details (User/Hospital Data,
			// Custom Desk, First Process etc.)
			UserMasterVO voUser = LoginDATA.getmValidBenDetail(voLogin);
			voUser.setActiveSessionFlag(voLogin.getActiveSessionFlag());

			if (voUser != null && voUser.getVarLoginMessage() != null
					&& voUser.getVarLoginMessage().trim().length() > 0) {
				return "3#" + voUser.getVarLoginMessage();
			}

			if (voUser != null && voUser.getVarLoggedIn().equals(HISConfig.YES)) {

				if(voUser.getVarUserId().contains("^")) {
					voUser.setVarUserId(voUser.getVarUserId().replace("^", "#").split("#")[0] + "^" + voUser.getVarUserSeatId());
				}else {
					voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarUserSeatId());
				}
				 
				if (voUser.getUserSeatsDtl() != null && voUser.getUserSeatsDtl().size() == 1) {

					flg = "1";

					voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());

					if(voUser.getVarUserId().contains("^")) {
						voUser.setVarUserId(voUser.getVarUserId().replace("^", "#").split("#")[0] + "^" + voUser.getVarSeatId());
					}else {
						voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());
					}
					
					

					if (loginBenWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

						return "1";
					} else {

						return "0";
					}

				} else {
					objSession.setAttribute("preUserDtls", voUser);
					objSession.setAttribute("preLoginDtls", voLogin);

					String seatPageData = seatDetails(voUser, "selectRole");

					objSession.setAttribute("seatPageData", seatPageData);

					flg = "2";
				}

			}

		} catch (Exception e) {
			flg = "0";
			e.printStackTrace();

		}

		return flg;
	}

	public static String seatDetails(UserMasterVO voUser, String mode) {

		String seatPageData = "<div class='col-12'><h5 class=\"text-center mb-4 text-primary\">Welcome "
				+ voUser.getVarUsrName() + " (" + voUser.getVarUserName() + ")</h5></div>";
		if (voUser.getVarSeatName() != null && voUser.getVarSeatName().trim().length() > 0) {
			seatPageData = seatPageData
					+ "<div class='col-12'><p class=\"text-success fw-bold text-center\"> User Current Role : "
					+ voUser.getVarSeatName() + " <input type='hidden' name='varPreviousSeatId' value='"
					+ voUser.getVarSeatId() + "'></p></div>";
		}

		if (voUser.getUserSeatsDtl() != null && voUser.getUserSeatsDtl().size() == 0) {
			seatPageData = seatPageData + "<div class='col-12 text-danger  text-center mb-5'>No Role Available.</div> ";
			seatPageData = seatPageData
					+ "<div class='col-12 text-center mb-5'><button class=\"btn-his-outline\" onClick='goTo(\"logout\");'>Home</button></div>";
		} else {
			/*
			 * if("switchRole".equalsIgnoreCase(mode)) { seatPageData = seatPageData+
			 * "<div class='col-12'>  Other Roles : "; }else { seatPageData = seatPageData+
			 * "<br><div>  Available Roles : "; }
			 */

			seatPageData = seatPageData
					+ "<div class='col-12 p-5'><h6 class='mb-3 text-center text-dark'>Please select your login role to continue</h6>";

			// "</div>

			// seatPageData = seatPageData+ " <span><select name=''><option value=''>Select
			// Role</otpion>";

			List<UserSeatVO> userSeatVos = voUser.getUserSeatsDtl();
			String checked = "";
			if (userSeatVos.size() == 1)
				checked = "checked='checked'";

			for (UserSeatVO userSeatVO : userSeatVos) {
				seatPageData = seatPageData + "<div class='form-check mb-2'>";
				seatPageData = seatPageData + "<input class='form-check-input' type='radio' " + checked
						+ " name='varSeatId' data-seatName='" + userSeatVO.getVarDisplaySeatName() + "'  value="
						+ userSeatVO.getVarUserId() + "," + userSeatVO.getVarSeatId() + ","
						+ userSeatVO.getVarSeatHospitalId() + "  id='varSeatId" + userSeatVO.getVarSeatId() + "'>";
				seatPageData = seatPageData + "<label class='form-check-label' for='varSeatId"
						+ userSeatVO.getVarSeatId() + "'>" + userSeatVO.getVarDisplaySeatName() + "</label>";
				seatPageData = seatPageData + "</div>";
				/*
				 * if("switchRole".equalsIgnoreCase(mode)) {
				 * 
				 * if(!userSeatVO.getVarSeatId().equals(voUser.getVarUserSeatId())) seatPageData
				 * = seatPageData +
				 * "<option value='"+userSeatVO.getVarUserId()+","+userSeatVO.getVarSeatId()+
				 * "'>"+userSeatVO.getVarDisplaySeatName()+"</option>";
				 * 
				 * }else {
				 * 
				 * seatPageData = seatPageData +
				 * "<option value='"+userSeatVO.getVarUserId()+","+userSeatVO.getVarSeatId()+
				 * "'>"+userSeatVO.getVarDisplaySeatName()+"</option>"; }
				 */

			}
			seatPageData = seatPageData + "</div>";
			// seatPageData = seatPageData + "</select></span></div> <br> <br> "
			seatPageData = seatPageData + "<div class='col-12 text-center mb-3'>";
			seatPageData = seatPageData
					+ "<button class='btn-his'   onClick='goTo(\"role\");' >Go To Desk</button>  <button class='btn-his-outline' onClick='goTo(\"logout\");'>Logout</button> ";
			seatPageData = seatPageData + "</div>";

		}

		return seatPageData;

	}

	public static boolean loginUserWithSeat(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, HttpSession objSession, LoginVO voLogin, UserMasterVO voUser) {
		boolean flg = true;

		try {

			String downloadTokenName = TokenHelper.getTokenName();
			String downloadToken = TokenHelper.getToken(downloadTokenName);

			if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

				// voLogin.setVarIPAddress(new
				// String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

			} else {

				voLogin.setVarIPAddress(objRequest.getRemoteAddr());

			}

			voUser.setActiveSessionFlag(voLogin.getActiveSessionFlag());

			voUser.setVarIPAddress(voLogin.getVarIPAddress());

			if (voUser == null || voUser.getVarLoggedIn().equals(HISConfig.NO)) {
				// If userVO is null, means no valid user found against User Credentials.
				flg = false;

				// Setting Error Message
				if (voUser != null)
					objActionSupport.addActionError(voUser.getVarLoginMessage());
				else
					objActionSupport.addActionError("Invalid User Name/Password!");
			} else {
				// If Valid user
				flg = true;

				// If required... Taking Action based User Previous Login, Already Loin
				// somewhere else
				// Details (Future)....... -----
				// Already Login Some where else ???????

				// Get TGT Register
				HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);

				// Check Is User Already have a Ticket based on UserId, IP Address, Session ID,
				// User-Agent
				HISTicketGrantingTicket objTGT = (HISTicketGrantingTicket) registry.getTicketBasedOn(
						voUser.getVarUserId(), voUser.getVarIPAddress(), objRequest.getSession().getId());
				// If ticket exist, logout and delete the old ticket
				if (objTGT != null) {
					objTGT.logout();
					registry.deleteTicket(objTGT.getTicketId());//
					// DB Logout Entry
					UserLoginLogVO voUserLog = objTGT.getAuthentication().getVoUserLog();
					voUserLog.setVarUserLogoutDate(DateHelperMethods.getDateString(System.currentTimeMillis()));
					LoginDATA.logUserLogoutDetail(voUserLog);
					// System.out.println("login date & time in
					// utill=="+voUserLog.getVarUserLoginDate());
				}

				String strInitClientCode = "";
				JSONObject clientContent = null;

				if (objRequest.getSession().getAttribute("strInitClientCode") != null) {

					strInitClientCode = objRequest.getSession().getAttribute("strInitClientCode").toString();
					clientContent = (JSONObject) objRequest.getSession().getAttribute("content");

				}

				// Setting Session Credentials, New Session, Session Expiration,
				// Creating New Session
				// Commented for introducing session token in login page
				// objRequest.getSession().invalidate();
				// objSession = objRequest.getSession();

				// Added for introducing session token in login page--Start
				SessionMap session = (SessionMap) ActionContext.getContext().getSession();

				// invalidate
				session.invalidate();

				// renew servlet session
				session.put("renewServletSession", null);
				session.remove("renewServletSession");

				// populate the struts session
				session.entrySet();

				objSession = objRequest.getSession();

				// Added for introducing session token in login page--End

				objRequest.getSession().setAttribute("strInitClientCode", strInitClientCode);
				objRequest.getSession().setAttribute("content", clientContent);

				voUser.setVarIsBen("0");

				objSession.setAttribute("preUserDtls", voUser);
				objSession.setAttribute("preLoginDtls", voLogin);

				Cookie cookie = new Cookie(objRequest.getServerName() + "."
						+ objRequest.getServerPort() + ".SSO",
						objSession.getId());
				cookie.setMaxAge(30 * 60);
				objResponse.addCookie(cookie);

				// Setting Key for blocking multiple tab
				objSession.setAttribute(HISSSOServerConfig.LOGIN_TAB_KEY, voLogin.getVarLoginSessionSalt());
				// String strSessionId = objSession.getId();

				TokenHelper.setSessionToken(downloadTokenName, downloadToken);

				// Preparing Authentication Credentials Object
				AuthenticationCredentials objAuthentictaion = new AuthenticationCredentials();
				// User DB Details
				BeanUtils.copyProperties(objAuthentictaion, voUser);
				// User Browser Detail
				objAuthentictaion.setVarAccessURL(objRequest.getRequestURL().toString());
				objAuthentictaion.setVarUserLoginUserAgent(objRequest.getHeader("User-Agent"));
				// User Session Details
				// objAuthentictaion.setVarUserLoginSessionId(strSessionId);

				// VOs
				objAuthentictaion.setVoUser(voUser);
				objAuthentictaion.setVoHostpital(voUser.getVoHospital());
				// System.out.println("LoginUTL->
				// "+objAuthentictaion.getVoHostpital().getVarIsLogoRequired()+"\n"+objAuthentictaion.getVoHostpital().getVarLogoType()+"\n"+objAuthentictaion.getVoHostpital().getVarStrLogoFileName());
				// objAuthentictaion.setVoHolidays(holidayList);

				// Preparing Expiration Object
				HISExpiration objExpiration = new TicketGrantingTicketExpiration(objSession);

				// Create TGT
				objTGT = new HISTicketGrantingTicket(objAuthentictaion, objExpiration);
				String grantingTicketId = objTGT.getTicketId();

				// Setting User Login Detail into DB
				UserLoginLogVO voUserLog = new UserLoginLogVO();
				BeanUtils.copyProperties(voUserLog, voUser);
				voUserLog.setVarSeatId(voUser.getVarUserSeatId());
				// voUserLog.setVarIPAddress(objRequest.getRemoteAddr());
				/*-------------------------added by sneha on 19/12/2019-----------------------------------------------*/

				voUserLog.setDesktopSystemInfo(voLogin.getDesktopSystemInfo());
				voUserLog.setBrowserInfo(voLogin.getBrowserInfo());
				voUserLog.setVarIPAddress(voLogin.getVarIPAddress());

				/*----------------------------------------------------------------------------*/
				voUserLog.setVarUserLoginDate(DateHelperMethods.getDateString(objTGT.getCreationTime()));
				objAuthentictaion.setVoUserLog(voUserLog);

				/*
				 * if(!voLogin.getDesktopSystemInfo().equals("")){
				 * LoginDATA.saveDesktopClientInfo(voUserLog); }
				 */

				// System.out.println("skandyyyyyy"+objRequest.getServerName()+":"+objRequest.getServerPort());

				voUserLog.setVarServerIp(objRequest.getLocalAddr() + ":" + objRequest.getLocalPort());

				// Log User Login Detail
				// Log User Detail
				// Fetch menu List, Favorite List
				// If Already Login somewhere else take action here means update DB etc.
				Map<String, Object> mpData = LoginDATA.logUserLoginDetail(voUserLog);
				LoginDATA.updateActiveSessionFlag(voUser);

				// Get and Set User Authorization Detail
				// Fetching/Setting User authorization Details and Menu List

				List<MenuMasterVO> lstMenus = (List<MenuMasterVO>) mpData.get(UserManagementConfig.KEY_USER_MENU_LIST); // LoginDATA.getUserAuthorizationDetail(voUser);
				List<MenuMasterVO> lstManuals = (List<MenuMasterVO>) mpData
						.get(UserManagementConfig.KEY_USER_MANUAL_LIST);
				List<MenuMasterVO> lstAllowedMenuURLs = (List<MenuMasterVO>) mpData
						.get(UserManagementConfig.KEY_USER_ALLOWED_MENU_LIST);
				AuthorizationCredentials objAuthorization = new AuthorizationCredentials(lstMenus, lstManuals,
						lstAllowedMenuURLs);

				voUser.setCheckBackDateDayEndFlag(
						(String) mpData.get(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED));
				objAuthentictaion.setVoUser(voUser);

				// language set (later change this through combo)
				objRequest.getSession().setAttribute("LANGUAGE", objActionSupport.getVarLanguage());

				objAuthentictaion.setVarLanguage(objActionSupport.getVarLanguage());

				objTGT.setAuthorization(objAuthorization);

				// Register TGT
				// registry.addTicket(objTGT);

				registry.addTicket(objTGT, objRequest.getHeader("User-Agent").toLowerCase());

				// Setting USER VO, HOSPITAL VO, USER CUSTOM DETAIL, SYSDATE in Session, Login
				// IP Address
				setLoginDetailsInSession(objRequest.getSession(), objTGT, mpData);

				// Setting User TGT Id into the Session(Already) and request
				objActionSupport.setVarSSOTicketGrantingTicket(grantingTicketId);
			}

		} catch (NullPointerException e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured While Trying to
			// Login!");
			e.printStackTrace();// Hide This for Production
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			objActionSupport.addActionError("Unknown Problem Occured While Trying to Login!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static boolean loginBenWithSeat(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, HttpSession objSession, LoginVO voLogin, UserMasterVO voUser) {
		boolean flg = true;

		try {

			String downloadTokenName = TokenHelper.getTokenName();
			String downloadToken = TokenHelper.getToken(downloadTokenName);

			if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

				// voLogin.setVarIPAddress(new
				// String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

			} else {

				voLogin.setVarIPAddress(objRequest.getRemoteAddr());

			}

			voUser.setActiveSessionFlag(voLogin.getActiveSessionFlag());

			voUser.setVarIPAddress(voLogin.getVarIPAddress());

			if (voUser == null || voUser.getVarLoggedIn().equals(HISConfig.NO)) {
				// If userVO is null, means no valid user found against User Credentials.
				flg = false;

				// Setting Error Message
				if (voUser != null)
					objActionSupport.addActionError(voUser.getVarLoginMessage());
				else
					objActionSupport.addActionError("Invalid User Name/Password!");
			} else {
				// If Valid user
				flg = true;

				// If required... Taking Action based User Previous Login, Already Loin
				// somewhere else
				// Details (Future)....... -----
				// Already Login Some where else ???????

				// Get TGT Register
				HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);

				// Check Is User Already have a Ticket based on UserId, IP Address, Session ID,
				// User-Agent
				HISTicketGrantingTicket objTGT = (HISTicketGrantingTicket) registry.getTicketBasedOn(
						voUser.getVarUserId(), voUser.getVarIPAddress(), objRequest.getSession().getId());
				// If ticket exist, logout and delete the old ticket
				if (objTGT != null) {
					objTGT.logout();
					registry.deleteTicket(objTGT.getTicketId());//
					// DB Logout Entry
					UserLoginLogVO voUserLog = objTGT.getAuthentication().getVoUserLog();
					voUserLog.setVarUserLogoutDate(DateHelperMethods.getDateString(System.currentTimeMillis()));
					LoginDATA.logBenLogoutDetail(voUserLog);
					// System.out.println("login date & time in
					// utill=="+voUserLog.getVarUserLoginDate());
				}

				String strInitClientCode = "";
				JSONObject clientContent = null;

				if (objRequest.getSession().getAttribute("strInitClientCode") != null) {

					strInitClientCode = objRequest.getSession().getAttribute("strInitClientCode").toString();
					clientContent = (JSONObject) objRequest.getSession().getAttribute("content");

				}

				// Setting Session Credentials, New Session, Session Expiration,
				// Creating New Session
				// Commented for introducing session token in login page
				// objRequest.getSession().invalidate();
				// objSession = objRequest.getSession();

				// Added for introducing session token in login page--Start
				SessionMap session = (SessionMap) ActionContext.getContext().getSession();

				// invalidate
				session.invalidate();

				// renew servlet session
				session.put("renewServletSession", null);
				session.remove("renewServletSession");

				// populate the struts session
				session.entrySet();

				objSession = objRequest.getSession();

				// Added for introducing session token in login page--End

				objRequest.getSession().setAttribute("strInitClientCode", strInitClientCode);
				objRequest.getSession().setAttribute("content", clientContent);

				voUser.setVarIsBen("1");

				objSession.setAttribute("preUserDtls", voUser);
				objSession.setAttribute("preLoginDtls", voLogin);

				Cookie cookie = new Cookie(objRequest.getServerName() + "."
						+ objRequest.getServerPort() + ".SSO",
						objSession.getId());
				cookie.setMaxAge(30 * 60);
				objResponse.addCookie(cookie);

				// Setting Key for blocking multiple tab
				objSession.setAttribute(HISSSOServerConfig.LOGIN_TAB_KEY, voLogin.getVarLoginSessionSalt());
				// String strSessionId = objSession.getId();

				TokenHelper.setSessionToken(downloadTokenName, downloadToken);

				// Preparing Authentication Credentials Object
				AuthenticationCredentials objAuthentictaion = new AuthenticationCredentials();
				// User DB Details
				BeanUtils.copyProperties(objAuthentictaion, voUser);
				// User Browser Detail
				objAuthentictaion.setVarAccessURL(objRequest.getRequestURL().toString());
				objAuthentictaion.setVarUserLoginUserAgent(objRequest.getHeader("User-Agent"));
				// User Session Details
				// objAuthentictaion.setVarUserLoginSessionId(strSessionId);

				// VOs
				objAuthentictaion.setVoUser(voUser);
				objAuthentictaion.setVoHostpital(voUser.getVoHospital());
				// System.out.println("LoginUTL->
				// "+objAuthentictaion.getVoHostpital().getVarIsLogoRequired()+"\n"+objAuthentictaion.getVoHostpital().getVarLogoType()+"\n"+objAuthentictaion.getVoHostpital().getVarStrLogoFileName());
				// objAuthentictaion.setVoHolidays(holidayList);

				// Preparing Expiration Object
				HISExpiration objExpiration = new TicketGrantingTicketExpiration(objSession);

				// Create TGT
				objTGT = new HISTicketGrantingTicket(objAuthentictaion, objExpiration);
				String grantingTicketId = objTGT.getTicketId();

				// Setting User Login Detail into DB
				UserLoginLogVO voUserLog = new UserLoginLogVO();
				BeanUtils.copyProperties(voUserLog, voUser);
				voUserLog.setVarSeatId(voUser.getVarUserSeatId());
				// voUserLog.setVarIPAddress(objRequest.getRemoteAddr());
				/*-------------------------added by sneha on 19/12/2019-----------------------------------------------*/

				voUserLog.setDesktopSystemInfo(voLogin.getDesktopSystemInfo());
				voUserLog.setBrowserInfo(voLogin.getBrowserInfo());
				voUserLog.setVarIPAddress(voLogin.getVarIPAddress());

				/*----------------------------------------------------------------------------*/
				voUserLog.setVarUserLoginDate(DateHelperMethods.getDateString(objTGT.getCreationTime()));
				objAuthentictaion.setVoUserLog(voUserLog);

				/*
				 * if(!voLogin.getDesktopSystemInfo().equals("")){
				 * LoginDATA.saveDesktopClientInfo(voUserLog); }
				 */

				// System.out.println("skandyyyyyy"+objRequest.getServerName()+":"+objRequest.getServerPort());

				voUserLog.setVarServerIp(objRequest.getLocalAddr() + ":" + objRequest.getLocalPort());

				// Log User Login Detail
				// Log User Detail
				// Fetch menu List, Favorite List
				// If Already Login somewhere else take action here means update DB etc.
				Map<String, Object> mpData = LoginDATA.logBenLoginDetail(voUserLog);
				LoginDATA.updateActiveSessionFlagBen(voUser);

				// Get and Set User Authorization Detail
				// Fetching/Setting User authorization Details and Menu List

				List<MenuMasterVO> lstMenus = (List<MenuMasterVO>) mpData.get(UserManagementConfig.KEY_USER_MENU_LIST); // LoginDATA.getUserAuthorizationDetail(voUser);
				List<MenuMasterVO> lstManuals = (List<MenuMasterVO>) mpData
						.get(UserManagementConfig.KEY_USER_MANUAL_LIST);
				List<MenuMasterVO> lstAllowedMenuURLs = (List<MenuMasterVO>) mpData
						.get(UserManagementConfig.KEY_USER_ALLOWED_MENU_LIST);
				AuthorizationCredentials objAuthorization = new AuthorizationCredentials(lstMenus, lstManuals,
						lstAllowedMenuURLs);

				voUser.setCheckBackDateDayEndFlag(
						(String) mpData.get(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED));
				objAuthentictaion.setVoUser(voUser);

				// language set (later change this through combo)
				objRequest.getSession().setAttribute("LANGUAGE", objActionSupport.getVarLanguage());

				objAuthentictaion.setVarLanguage(objActionSupport.getVarLanguage());

				objTGT.setAuthorization(objAuthorization);

				// Register TGT
				// registry.addTicket(objTGT);

				registry.addTicket(objTGT, objRequest.getHeader("User-Agent").toLowerCase());

				// Setting USER VO, HOSPITAL VO, USER CUSTOM DETAIL, SYSDATE in Session, Login
				// IP Address
				setLoginDetailsInSession(objRequest.getSession(), objTGT, mpData);

				// Setting User TGT Id into the Session(Already) and request
				objActionSupport.setVarSSOTicketGrantingTicket(grantingTicketId);
			}

		} catch (NullPointerException e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured While Trying to
			// Login!");
			e.printStackTrace();// Hide This for Production
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			objActionSupport.addActionError("Unknown Problem Occured While Trying to Login!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static String loginBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		String flg = "0";
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			String strSessionSalt = (String) objSession.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT);

			if (strSessionSalt == null || strSessionSalt.equalsIgnoreCase("")) {
				flg = "0";
				objActionSupport.addActionError("Page is expired kindly refresh the page!");
			} else {

				LoginVO voLogin = new LoginVO();

				BeanUtils.copyProperties(voLogin, objActionSupport);
				voLogin.setVarLoginSessionSalt(strSessionSalt);

				if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

					// voLogin.setVarIPAddress(new
					// String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

				} else {

					voLogin.setVarIPAddress(objRequest.getRemoteAddr());

				}
				
				UserMasterVO voUser = LoginDATA.getValidBenDetail(voLogin);			// username is BenID
				//System.out.println("voUser.getVarLoggedIn()" + voUser.getVarLoggedIn() );
				if(voUser !=null && (HISConfig.YES).equals(voUser.getVarLoggedIn() )  ){
					
					
					if( voUser.getVarMainCardHolder()==null || voUser.getVarMainCardHolder() !=null && "0".equals( voUser.getVarMainCardHolder() ) || voUser.getVarMainCardHolder() !=null && "2".equals( voUser.getVarMainCardHolder() ) ) {
						return "7";
					}
					
					String mobileNumber = voUser.getVarMobileNumber();
					String benIdd = voLogin.getVarUserName() ;					// BendId stored in session
					objSession.setAttribute("benIdd", benIdd);
					
					if(mobileNumber == null || ( mobileNumber != null && mobileNumber.trim().length() < 10 )) {
						objRequest.setAttribute("LoginError", "Invalid Mobile Number! Please update your Mobile Number to Login!");
						return "6";
					}
					
					String otp = generateAndStoreOTPForBen(mobileNumber);
					sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
					
					String otpCount = (objSession.getAttribute("otpCount_" + mobileNumber) != null
							&& objSession.getAttribute("otpCount_" + mobileNumber).toString().length() > 0
									? objSession.getAttribute("otpCount_" + mobileNumber).toString()
									: "0");
					
					//System.out.println("otpCount>>>> " + otpCount );
					
					if (Integer.valueOf(otpCount) > 2) {

						objSession.setAttribute("otpValidationKey", "");

						objSession.setAttribute("otpCount_" + mobileNumber, "");
						objSession.setAttribute("otpRefNo_" + mobileNumber, "" );

						objRequest.setAttribute("LoginError", "Maximum OTP Count Reached");
						return "5";
						
					}
					objSession.setAttribute("LoginError", "");
					objSession.setAttribute("BenMobileNumber", mobileNumber.trim()); 
					objSession.setAttribute("BenUserLogin", "1"); 
					objSession.setAttribute("otpValidationKey", mobileNumber.trim());

					objSession.setAttribute("otpCount_" + mobileNumber, (Integer.valueOf(otpCount) + 1));

					objSession.setAttribute("otpRefNo_" + mobileNumber, otp.split("#")[0]);
					
					return "4";
				}
				
				
				if (voUser != null && voUser.getVarLoginMessage() != null
						&& voUser.getVarLoginMessage().trim().length() > 0) {
					return "3#" + voUser.getVarLoginMessage();
				}

				if (voUser != null && voUser.getVarLoggedIn().equals(HISConfig.YES)) {

					flg = "1";

					voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());

					voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());

					if (loginBenWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

						return "1";
					} else {

						return "0";
					}

				}

			}

		} catch (Exception e) {
			flg = "0";
			e.printStackTrace();

		}

		return flg;
	}

	public static String mloginBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		String flg = "0";
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			String strSessionSalt = (String) objSession.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT);

			if (strSessionSalt == null || strSessionSalt.equalsIgnoreCase("")) {
				flg = "0";
				objActionSupport.addActionError("Page is expired kindly refresh the page!");
			} else {

				LoginVO voLogin = new LoginVO();

				BeanUtils.copyProperties(voLogin, objActionSupport);
				voLogin.setVarLoginSessionSalt(strSessionSalt);

				if (voLogin.getVarIPAddress() != null && voLogin.getVarIPAddress().trim().length() > 2) {

					// voLogin.setVarIPAddress(new
					// String(Base64.getDecoder().decode(voLogin.getVarIPAddress().getBytes())));

				} else {

					voLogin.setVarIPAddress(objRequest.getRemoteAddr());

				}

				UserMasterVO voUser = LoginDATA.getValidBenMobileDetail(voLogin);

				if (voUser != null && voUser.getVarLoggedIn().equals(HISConfig.YES)) {

					flg = "1";

					voUser.setVarSeatId(voUser.getUserSeatsDtl().get(0).getVarSeatId());

					voUser.setVarUserId(voUser.getVarUserId() + "^" + voUser.getVarSeatId());

					if (loginBenWithSeat(objActionSupport, objRequest, objResponse, objSession, voLogin, voUser)) {

						return "1";
					} else {

						return "0";
					}

				}

			}

		} catch (Exception e) {
			flg = "0";
			e.printStackTrace();

		}

		return flg;
	}

	public static boolean logoutUser(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		boolean flg = true;
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			if (objActionSupport.getVarSSOTicketGrantingTicket() == null
					|| objActionSupport.getVarSSOTicketGrantingTicket().equals(""))
				objActionSupport.setVarSSOTicketGrantingTicket(
						(String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID));

			// Fetching TGT from Registry
			HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);
			TicketGrantingTicket objTGT = (TicketGrantingTicket) registry
					.getTicket(objActionSupport.getVarSSOTicketGrantingTicket());

			// Logout the TGT and all related ST
			objTGT.logout();

			Cookie loginCookie = null;
			Cookie[] cookies = objRequest.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {

					if (cookie.getName().equals(objRequest.getServerName() + "." + objRequest.getServerPort())) {
						loginCookie = cookie;
						break;
					}

				}
			}
			if (loginCookie != null) {
				loginCookie.setMaxAge(0);
				objResponse.addCookie(loginCookie);
			}

			// Updating Logout Status from DB
			UserLoginLogVO voUserLog = objTGT.getAuthentication().getVoUserLog();
			voUserLog.setVarUserLogoutDate(DateHelperMethods.getDateString(System.currentTimeMillis()));
			LoginDATA.logUserLogoutDetail(voUserLog);
			LoginDATA.updateActiveSessionFlagLogout(voUserLog);

			// Delete Ticket from Registry
			registry.deleteTicket(objActionSupport.getVarSSOTicketGrantingTicket());

			// Removing Token And User Details form Request
			objActionSupport.setVarSSOTicketGrantingTicket(null);

			objRequest.getSession().invalidate();
			objRequest.getSession().invalidate();

			// Redirecting to User Login Page
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured While Trying to
			// Logout!");
			// e.printStackTrace();// Hide This for Production
		}

		System.out.println("logout >>>>>>>>>>>>>>>>>>>>>>>>>>>>> flg >>>>>>>>>>>>>>>>>>>>> " + flg);

		return flg;
	}

	public static boolean changePasswordFirst(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {

		try {
			LoginVO voLogin = new LoginVO();

			BeanUtils.copyProperties(voLogin, objActionSupport);

			return LoginDATA.changePasswordFirst(voLogin);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	
	public static boolean changePasswordFirstBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {

		try {
			LoginVO voLogin = new LoginVO();

			BeanUtils.copyProperties(voLogin, objActionSupport);
			
			return LoginDATA.changePasswordFirstBen(voLogin);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
	public static boolean registerPasswordBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {

		try {
			LoginVO voLogin = new LoginVO();

			BeanUtils.copyProperties(voLogin, objActionSupport);
			
			return LoginDATA.RegistersaveBenPassword(voLogin);
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

	public static boolean setEssentialforFirstLogin(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		boolean flg = true;
		// HttpSession objSession = null;
		try {
			// objSession = objRequest.getSession();
			// Setting First Login Info
		} catch (IllegalStateException e) {
			try {
				flg = true;
				// Change Session Salt
				String randomSessionSalt = SecureHashAlgorithm
						.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
				objRequest.getSession().setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);

				String token = SecureCryptAlgorithm.generateKeyAES();
				objRequest.getSession().setAttribute("sessionLoginToken", token);

			} catch (Exception ee) {
				flg = false;
				// Log or Populate Error Here
				// Set Error Message
				// objActionSupport.addActionError("Unknown Problem Occured!");
				e.printStackTrace();// Hide This for Production
			}
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	// private static boolean generateTGT()
	// {
	// boolean flg = true;
	//
	// return flg;
	// }

	private static boolean setLoginDetailsInSession(HttpSession objSession_p, HISTicketGrantingTicket objTGT_p,
			Map<String, Object> mapData_p) {
		boolean flg = true;
		try {
			UserMasterVO voSysDate = (UserMasterVO) mapData_p.get(UserManagementConfig.KEY_SYSTEM_DATETIME);

			// User VO
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_USER_VO, objTGT_p.getAuthentication().getVoUser());
			// Hospital VO
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_HOSPITALVO, objTGT_p.getAuthentication().getVoHostpital());
			// Current Year

			UserMasterVO voUser = objTGT_p.getAuthentication().getVoUser();
			HospitalMasterVO voGlobalHospital = objTGT_p.getAuthentication().getVoHostpital();

			objSession_p.setAttribute("HOSPITAL_CODE", voGlobalHospital.getVarHospitalCode());
			objSession_p.setAttribute("HOSPITAL_NAME", voGlobalHospital.getVarHospitalName());

			objSession_p.setAttribute("SEATID", voUser.getVarUserId());

			objSession_p.setAttribute("CLIENT_CODE", voUser.getVarClientId());
			objSession_p.setAttribute("CLIENT_NAME", voUser.getVarClientName());
			objSession_p.setAttribute("CLIENT_SHORT_NAME", voUser.getVarClientShort());
			objSession_p.setAttribute("CLIENT_START_YEAR", voUser.getVarClientStartYear());

			// System.out.println("voUser.getVarClientJson() >>
			// "+voUser.getVarClientJson());

			// objSession_p.setAttribute("content", new
			// JSONObject(voUser.getVarClientJson()) );

			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_CURRENT_YEAR, voSysDate.getVarCurrentYear());
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_CURRENT_MONTH, voSysDate.getVarCurrentMonth());

			String strDate = voSysDate.getVarCurrentDate() + "-" + voSysDate.getVarCurrentMonth() + "-"
					+ voSysDate.getVarCurrentYear() + " " + voSysDate.getVarCurrentHour() + ":"
					+ voSysDate.getVarCurrentMinute() + ":" + voSysDate.getVarCurrentSecond();
			// dd-MMM-yyyy HH:mm:ss
			Date objSysDate = DateHelperMethods.getDateObject(strDate);

			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_STRING, strDate);
			objSession_p.setAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_OBJECT, objSysDate);

			// For User Desk
			objSession_p.setAttribute(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST,
					mapData_p.get(UserManagementConfig.KEY_USER_FAVORITE_MENU_LIST));

			objSession_p.setAttribute(HISSSOConfig.KEY_CASH_COLLECTION_ALLOWED,
					mapData_p.get(UserManagementConfig.KEY_CASH_COLLECTION_ALLOWED));
			// System.out.println("In LoginUTL.setLoginDetailsInSession ::: Back Date Day
			// End Check Flag :::value
			// :::"+objSession_p.getAttribute(HISSSOConfig.KEY_CASH_COLLECTION_ALLOWED));

		} catch (Exception ee) {
			flg = false;
		}
		return flg;
	}

	/*
	 * private static boolean setAuthorization() { boolean flg = true;
	 * 
	 * return flg; }
	 */
	public static void setCaptcha(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) throws ServletException, IOException {
		int width = 160;
		int height = 58;
		try {
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

			Graphics2D graphics2D = image.createGraphics();

			// char data[][] = getCaptcheDatas();

			String ch = generateCaptchaString(); // String.copyValueOf(data[0]);

			String captchDisplay = ch.split("=")[0];
			String captchSession = ch.split("=")[1];

			Color c = new Color(0.0f, 0.0f, 0.0f);

			graphics2D.setColor(Color.decode("#FFFFFF"));
			graphics2D.fillRect(0, 0, image.getWidth(), image.getHeight());

			// Color c = new Color(0,0,255);
			GradientPaint gp = new GradientPaint(30, 30, c, 15, 25, Color.black, true);
			graphics2D.setPaint(gp);
			Font font = new Font("Verdana", Font.CENTER_BASELINE, 20);
			graphics2D.setFont(font);
			graphics2D.drawString(captchDisplay, 10, 40);
			graphics2D.dispose();

			HttpSession session = objRequest.getSession(true);

			session.setAttribute("CAPTCHA_KEY", captchSession);

			OutputStream outputStream = objResponse.getOutputStream();
			ImageIO.write(image, "jpeg", outputStream);
			outputStream.close();
		} catch (Exception ee) {
			objActionSupport.addActionError("Unknown Problem Occured While Trying to fetch Captcha!");
		}
	}

	public static String generateCaptchaString() {

		String tokenNo = "";

		Double num1 = Math.floor(Math.random() * 89.0) + 10;
		Double num2 = Math.floor(Math.random() * 10.0) + 1;

		Double num3 = Math.floor(Math.random() * 10);

		Integer answer = num1.intValue() + num2.intValue();

		tokenNo = num1.intValue() + " + " + num2.intValue() + " = " + answer;

		if (num3.intValue() % 2 == 1) {
			answer = num1.intValue() - num2.intValue();
			tokenNo = num1.intValue() + " - " + num2.intValue() + " = " + answer;
		}

		return tokenNo;
	}

	public static WebRowSet dashBoardData(HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		HisDAO hisdao = new HisDAO("LoginPageDashBoard", "dashBoardData()");
		int nIndex;
		WebRowSet wb = null;
		WebRowSet wb1 = null;
		WebRowSet wb2 = null;
		WebRowSet wb3 = null;
		WebRowSet wb4 = null;
		WebRowSet wb5 = null;
		WebRowSet wb6 = null;
		WebRowSet wb7 = null;
		WebRowSet wb8 = null;

		int i;
		try {
			String query = "SELECT Count(HRGNUM_EPISODE_CODE)  FROM hrgt_daily_patient_dtl WHERE TRUNC(GDT_ENTRY_DATE)=TRUNC(SYSDATE) and gnum_isvalid=1";
			nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb.size());

			if (wb.next()) {
				// System.out.println("OPD Count "+wb.getString(1));
				request.setAttribute("OPD_COUNT", wb.getString(1));
				request.getSession().setAttribute("OPD_COUNT", wb.getString(1));

				// request.getAtrribute("OPD_COUNT").toString();
			}

			String query4 = "SELECT Count(hrgnum_puk)  FROM HIPT_PATADMISSION_DTL WHERE TRUNC(HIPDT_ADMDATETIME)=TRUNC(SYSDATE) and gnum_isvalid=1";
			nIndex = hisdao.setQuery(query4);
			wb4 = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb4.size());

			if (wb4.next()) {
				// System.out.println("IPD Count "+wb4.getString(1));
				request.setAttribute("IPD_COUNT", wb4.getString(1));
				request.getSession().setAttribute("IPD_COUNT", wb4.getString(1));

				// request.getAtrribute("OPD_COUNT").toString();
			}

			String query5 = "SELECT Count(hivtnum_req_dno)  FROM HIVT_REQUISITION_DTL WHERE TRUNC(HIVT_ENTRY_DATE)=TRUNC(SYSDATE)";
			nIndex = hisdao.setQuery(query5);
			wb5 = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb5.size());

			if (wb5.next()) {
				// System.out.println("INV_COUNT "+wb5.getString(1));
				request.setAttribute("INV_COUNT", wb5.getString(1));
				request.getSession().setAttribute("INV_COUNT", wb5.getString(1));

				// request.getAtrribute("OPD_COUNT").toString();
			}

			String query3 = "select Count(GNUM_USERID) from GBLT_USER_LOG where TRUNC(GDT_LOGIN_DATE)= TRUNC(SYSDATE) and GDT_LOGUTT_DATE is null";
			nIndex = hisdao.setQuery(query3);

			wb3 = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb3.size());
			if (wb3.next()) {
				// System.out.println("Cur_User_Count "+wb3.getString(1));
				request.setAttribute("Cur_User_Count", wb3.getString(1));
				request.getSession().setAttribute("Cur_User_Count", wb3.getString(1));
			}

			String query7 = "SELECT count(HRGNUM_TEMP_REG_NO) FROM hrgt_portal_regist_dtl";
			nIndex = hisdao.setQuery(query7);

			wb7 = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb7.size());
			if (wb7.next()) {
				// System.out.println("ONLINE_TEMP_REGISTRATION "+wb7.getString(1));
				request.setAttribute("MOBILE_REG_DATA_TOTAL", wb7.getString(1));
				request.getSession().setAttribute("MOBILE_REG_DATA_TOTAL", wb7.getString(1));
			}
			String query8 = "SELECT count(HRGNUM_TEMP_PUK) FROM hrgt_patient_temp_dtl";
			nIndex = hisdao.setQuery(query8);

			wb8 = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb8.size());
			if (wb8.next()) {
				// System.out.println("ONLINE_TEMP_REGISTRATION "+wb7.getString(1));
				request.setAttribute("ONLINE_REGISTRATION_TOTAL", wb8.getString(1));
				request.getSession().setAttribute("ONLINE_REGISTRATION_TOTAL", wb8.getString(1));
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			throw new HisException(e.getMessage());
		} finally {

		}
		return wb;

	}

	public static WebRowSet dashBoardData1(HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		HisDAO hisdao = new HisDAO("LoginPageDashBoard", "dashBoardData()");
		int nIndex;
		WebRowSet wb = null;
		WebRowSet wb1 = null;
		WebRowSet wb2 = null;
		WebRowSet wb3 = null;
		WebRowSet wb4 = null;
		WebRowSet wb5 = null;
		WebRowSet wb6 = null;
		int i;
		try {
			String query = "SELECT nvl(TOTAL_OPD_STATS,0), nvl(TOTAL_IPD_STATS,0), nvl(TOTAL_LABTEST_STATS,0) FROM HDST_LOGIN_DASHBOARD_DATA";
			nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);

			// System.out.println("WB"+wb.size());

			if (wb.next()) {
				int OPD_COUNT_TOTAL = Integer.parseInt(request.getAttribute("OPD_COUNT").toString())
						+ Integer.parseInt(wb.getString(1));
				int IPD_COUNT_TOTAL = Integer.parseInt(request.getAttribute("IPD_COUNT").toString())
						+ Integer.parseInt(wb.getString(2));
				int INV_COUNT_TOTAL = Integer.parseInt(request.getAttribute("INV_COUNT").toString())
						+ Integer.parseInt(wb.getString(3));
				// System.out.println("OPD Count_TOTAL"+OPD_COUNT_TOTAL);
				// System.out.println("IPD Count_TOTAL"+IPD_COUNT_TOTAL);
				// System.out.println("INV Count_TOTAL"+INV_COUNT_TOTAL);
				request.setAttribute("OPD_COUNT_TOTAL", OPD_COUNT_TOTAL);
				request.setAttribute("IPD_COUNT_TOTAL", IPD_COUNT_TOTAL);
				request.setAttribute("INV_COUNT_TOTAL", INV_COUNT_TOTAL);
				request.getSession().setAttribute("OPD_Count_TOTAL1", OPD_COUNT_TOTAL);
				request.getSession().setAttribute("IPD_COUNT_TOTAL1", IPD_COUNT_TOTAL);
				request.getSession().setAttribute("INV_COUNT_TOTAL1", INV_COUNT_TOTAL);

				// request.getAtrribute("OPD_COUNT").toString();
			}
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new HisException(e.getMessage());
		} finally {

		}
		return wb;

	}

	public static boolean setInititalsClient(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse) {
		boolean flg = true;
		HttpSession objSession = null;
		try {
			objSession = objRequest.getSession();
			// Change Session Salt
			String randomSessionSalt = SecureHashAlgorithm
					.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
			objSession.setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);

			// Setting Dashborad hospital Combo
			// getHospitalList(objRequest, objResponse);

			String token = SecureCryptAlgorithm.generateKeyAES();
			objSession.setAttribute("sessionLoginToken", token);

			// Clearing Form Data
			objActionSupport.clear();

			objActionSupport.setSessionLoginToken(token);

			if (objRequest.getParameter("client") != null) {
				String strInitClientCode = objRequest.getParameter("client").toString();

				objRequest.getSession().setAttribute("strInitClientCode", strInitClientCode);
			}

			// dashBoardData(objRequest, objResponse);
			// dashBoardData1(objRequest, objResponse);

			setclientDetailsInSession(objRequest);

		} catch (IllegalStateException e) {
			try {
				flg = true;
				// Change Session Salt
				String randomSessionSalt = SecureHashAlgorithm
						.getRandomSalt(HISSSOServerConfig.LOGIN_SESSION_SALT_BYTE_SIZE);
				objRequest.getSession().setAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT, randomSessionSalt);
			} catch (Exception ee) {
				flg = false;
				// Log or Populate Error Here
				// Set Error Message
				// objActionSupport.addActionError("Unknown Problem Occured!");
				e.printStackTrace();// Hide This for Production
			}
		} catch (Exception e) {
			flg = false;
			// Log or Populate Error Here
			// Set Error Message
			// objActionSupport.addActionError("Unknown Problem Occured!");
			e.printStackTrace();// Hide This for Production
		}
		return flg;
	}

	public static void setclientDetailsInSession(HttpServletRequest objRequest) {

		if (objRequest.getSession().getAttribute("content") == null) {

			String strInitClientCode = "";

			if (objRequest.getSession().getAttribute("strInitClientCode") != null) {

				strInitClientCode = objRequest.getSession().getAttribute("strInitClientCode").toString();

			} else {

				if (objRequest.getParameter("client") != null) {
					strInitClientCode = objRequest.getParameter("client").toString();

					objRequest.getSession().setAttribute("strInitClientCode", strInitClientCode);
				}

			}

			HisDAO hisdao = new HisDAO("LoginPageDashBoard", "dashBoardData()");
			int nIndex;
			WebRowSet wb = null;

			JSONObject objContent = new JSONObject();
			try {

				String query = "SELECT gnum_client_code, gstr_client_name, gstr_client_short_name,  "
						+ "gstr_client_add1, gstr_client_add2  "
						+ "	FROM usm.gblt_client_mst where gnum_isvalid = 1 "
						+ "	and gstr_client_short_name = 'cdac'";
				nIndex = hisdao.setQuery(query);
				wb = hisdao.executeQry(nIndex);

				// System.out.println("WB"+wb.size());

				String clientId = "";
				String clientName = "";
				String clientShortName = "";

				if (wb.next()) {

					clientId = wb.getString(1);
					clientName = wb.getString(2);
					clientShortName = wb.getString(3);
				}

				objContent.put("clientId", clientId);
				objContent.put("sushrutlogo",
						"<span class='eshusrut-brandName eshusrut-brandName-color1'>MUHS GeneHealth Clinic</span>"
								+ "<span class='eshusrut-brandName eshusrut-brandName-color2'> | </span>");
				objContent.put("clientName", clientName);
				objContent.put("clientShortName", clientShortName);
				objContent.put("themeFileName", "cdac_preset2.css");
				objContent.put("clientLogoImage", "/HIS/hisglobal/images/e-clinic/MUHS_logo.png");
				objContent.put("clientWelcomePageImage", "/HIS/hisglobal/images/e-clinic/muhsbg.jpg");

				// objContent.put("clientName", "Maharastra University of Health Sciences,
				// Nashik");
				objContent.put("clientWelcomeText", clientName);
				objContent.put("clientWelcomeSubText", "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if (wb != null) {
					try {
						wb.close();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					wb = null;
				}
				if (hisdao != null) {

					hisdao.free();
					hisdao = null;

				}
			} finally {

				try {
					if (wb != null) {
						wb.close();
						wb = null;
					}

					if (hisdao != null) {

						hisdao.free();
						hisdao = null;

					}

				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

			objRequest.getSession().setAttribute("content", objContent);
		}

	}

	// Main Login Handler
	public static boolean sendForgotPasswordOtp(LoginSUP objActionSupport, HttpServletRequest objRequest,
			HttpServletResponse objResponse, String userId, String otpCount) {
		boolean isSuccess = true;
		HttpSession session;
		HttpSession objSession = objRequest.getSession();

		try {
			session = objRequest.getSession();

			if (userId == null || userId.trim().isEmpty()) {
				objSession.setAttribute("error", "User Id is required!");

				return false;
			}

			String mobileNumber = getMobileNoByUserId(userId, objRequest, objResponse);
			System.out.println("mobileNumber> > > " + mobileNumber);

			if ("".equals(mobileNumber)) {
				System.out.println("action message");

				objSession.setAttribute("error", "Invalid User Id");
				/*
				 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
				 */
				return false;
			}

			if (mobileNumber.trim().length() < 10) {
				objSession.setAttribute("error", "Invalid User Id / Mobile No. Not Registered");
				return false;
			}

			objSession.setAttribute("PatUserId", userId);
			objSession.setAttribute("PatmobileNumber", mobileNumber);
			String otp = generateAndStoreOTPForForgetPass(mobileNumber, userId);

			sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
			objSession.setAttribute("LoginError", "");

			session.setAttribute("otpValidationKey", userId);

			session.setAttribute("otpCount_" + userId, (Integer.valueOf(otpCount) + 1));

			session.setAttribute("otpRefNo_" + userId, otp.split("#")[0]);

		} catch (Exception e) {

			objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

			isSuccess = false;
			e.printStackTrace();
		}

		return isSuccess;
	}

	// Main Login Handler
		public static boolean sendForgotPasswordOtpBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
				HttpServletResponse objResponse, String userId, String otpCount) {
			boolean isSuccess = true;
			HttpSession session;
			HttpSession objSession = objRequest.getSession();

			try {
				session = objRequest.getSession();

				if (userId == null || userId.trim().isEmpty()) {
					objSession.setAttribute("LoginError", "Ben Id is required!");

					return false;
				}

				String mobileNumber = getMobileNoByBenId(userId, objRequest, objResponse);
				System.out.println("mobileNumber> > > " + mobileNumber);

				if ("".equals(mobileNumber)) {
					System.out.println("action message");

					objSession.setAttribute("LoginError", "Invalid Ben Id");
					/*
					 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
					 */
					return false;
				}

				if (mobileNumber.trim().length() < 10) {
					objSession.setAttribute("LoginError", "Invalid Mobile No. OR  Mobile No. Not Registered");
					return false;
				}

				objSession.setAttribute("PatUserId", userId);
				objSession.setAttribute("PatmobileNumber", mobileNumber);
				String otp = generateAndStoreOTPForForgetPassBen(mobileNumber, userId);

				sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
				objSession.setAttribute("LoginError", "");

				session.setAttribute("otpValidationKey", userId);

				session.setAttribute("otpCount_" + userId, (Integer.valueOf(otpCount) + 1));

				session.setAttribute("otpRefNo_" + userId, otp.split("#")[0]);

			} catch (Exception e) {

				objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

				isSuccess = false;
				e.printStackTrace();
			}

			return isSuccess;
		}
		
		
		public static boolean sendUnlockUserBenOtp(LoginSUP objActionSupport, HttpServletRequest objRequest,
				HttpServletResponse objResponse, String userId, String otpCount) {
			boolean isSuccess = true;
			HttpSession session;
			HttpSession objSession = objRequest.getSession();

			try {
				session = objRequest.getSession();

				if (userId == null || userId.trim().isEmpty()) {
					objSession.setAttribute("LoginError", "Ben Id is required!");

					return false;
				}

				String mobileNumber = getMobileNoByBenId(userId, objRequest, objResponse);
				System.out.println("mobileNumber> > > " + mobileNumber);

				if ("".equals(mobileNumber)) {
					System.out.println("action message");

					objSession.setAttribute("LoginError", "Invalid Ben Id");
					/*
					 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
					 */
					return false;
				}

				if (mobileNumber.trim().length() < 10) {
					objSession.setAttribute("LoginError", "Invalid Mobile No. OR  Mobile No. Not Registered");
					return false;
				}

				objSession.setAttribute("PatUserId", userId);
				objSession.setAttribute("PatmobileNumber", mobileNumber);
				String otp = generateAndStoreOTPForUnlockBen(mobileNumber, userId);

				sendGeneralOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);				//change the template
				objSession.setAttribute("LoginError", "");

				session.setAttribute("otpValidationKey", userId);

				session.setAttribute("otpCount_" + userId, (Integer.valueOf(otpCount) + 1));

				session.setAttribute("otpRefNo_" + userId, otp.split("#")[0]);

			} catch (Exception e) {

				objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

				isSuccess = false;
				e.printStackTrace();
			}

			return isSuccess;
		}
		
		public static boolean sendRegisterOtpBen(LoginSUP objActionSupport, HttpServletRequest objRequest,
				HttpServletResponse objResponse, String userId, String otpCount) {
			boolean isSuccess = true;
			HttpSession session;
			HttpSession objSession = objRequest.getSession();

			try {
				session = objRequest.getSession();
				
				if (userId == null || userId.trim().isEmpty()) {
					objSession.setAttribute("LoginError", "Ben Id is required!");

					return false;
				}

				String mobileNumber = getMobileNoByBenId(userId, objRequest, objResponse);
				System.out.println("mobileNumber> > > " + mobileNumber);

				if ("".equals(mobileNumber)) {
					System.out.println("action message");

					objSession.setAttribute("LoginError", "Invalid Ben Id");
					/*
					 * objActionSupport.addActionMessage("Invalid or unregistered mobile number!");
					 */
					return false;
				}

				if (mobileNumber.trim().length() < 10) {
					objSession.setAttribute("LoginError", "Invalid Mobile No. OR  Mobile No. Not Registered");
					return false;
				}

				objSession.setAttribute("PatUserId", userId);
				objSession.setAttribute("PatmobileNumber", mobileNumber);
				String otp = generateAndStoreOTPForRegisterPassBen(mobileNumber, userId);

				sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
				objSession.setAttribute("LoginError", "");

				session.setAttribute("otpValidationKey", userId);

				session.setAttribute("otpCount_" + userId, (Integer.valueOf(otpCount) + 1));

				session.setAttribute("otpRefNo_" + userId, otp.split("#")[0]);

			} catch (Exception e) {

				objSession.setAttribute("LoginError", "An error occurred during login: " + e.getMessage());

				isSuccess = false;
				e.printStackTrace();
			}

			return isSuccess;
		}
	
	
	public static int validateOTPforgetPassword(String mobileNumber, String userOtp, String userId,
			HttpServletRequest objRequest) { // 811
		System.out.println("userId>>>____ "+ userId);
		System.out.println("Inside by validateOTPforgetPassword");
		System.out.println("optMAP>>>> " + otpforgetPass);
		OTPData correctOTP = otpforgetPass.get(mobileNumber);
		// System.out.println("correct OTP>>>>"+ correctOTP+ "user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;
		}

		long currentTime = System.currentTimeMillis();
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpforgetPass.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}
		
		

		else if (correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService) ) {
			otpforgetPass.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}
	
	
	public static int validateOTPforgetPasswordBen(String mobileNumber, String userOtp, String userId,
			HttpServletRequest objRequest) { // 811
		System.out.println("userId>>>____ "+ userId);
		//System.out.println("Inside validateOTPforgetPassword Ben");
		//System.out.println("optMAP>>>> " + otpforgetPassBen);
		OTPData correctOTP = otpforgetPassBen.get(mobileNumber);
		// System.out.println("correct OTP>>>>"+ correctOTP+ "user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;
		}
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpforgetPassBen.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}

		else if ( correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService)  ) {
			otpforgetPassBen.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}
	
	public static int validateOTPunlockBen(String mobileNumber, String userOtp, String userId,
			HttpServletRequest objRequest) { // 811
		System.out.println("userId>>>____ "+ userId);
		//System.out.println("Inside validateOTPforgetPassword Ben");
		//System.out.println("optMAP>>>> " + otpforgetPassBen);
		OTPData correctOTP = otpUnlockUser.get(mobileNumber);
		// System.out.println("correct OTP>>>>"+ correctOTP+ "user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;
		}
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpUnlockUser.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}

		else if ( correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService)  ) {
			otpUnlockUser.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}
	
	public static int validateOTPregisterPasswordBen(String mobileNumber, String userOtp, String userId,
			HttpServletRequest objRequest) { // 811
		//System.out.println("userId>>>____ "+ userId);
		System.out.println("Inside validateOTPregisterPasswordBen Ben");
		//System.out.println("optMAP>>>> " + otpforgetPassBen);
		OTPData correctOTP = otpRegisterPassBen.get(mobileNumber);
		 System.out.println("correct OTP>>>>"+ correctOTP.otp+ "   user otp>>>> "+ userOtp);
		if (correctOTP == null) {
			return 3;
		}
		String smsService = HisUtil.getParameterFromHisPathXML("SMS_SERVICE_OTP");
		long currentTime = System.currentTimeMillis();

		// Check if OTP has expired
		if (currentTime - correctOTP.timestamp > OTP_EXPIRATION_TIME) {
			otpRegisterPassBen.remove(mobileNumber);

			HttpSession objSession = objRequest.getSession();
			objSession.setAttribute("LoginError", "OTP has expired!");
			return 4;
		}

		else if ( correctOTP.otp.equals(userOtp) || smsService!= null && userOtp.equals(smsService)  ) {
			otpRegisterPassBen.remove(mobileNumber);

			return 1;
		} else {
			return 2;
		}
	}

	public static void resetPasswordUTL(String userId ) {
		
		try {
			String NewPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
			
			String userIdDecoded = new String(Base64.getDecoder().decode( userId  ));
			System.out.println("UserIDDD " + userIdDecoded);
			System.out.println("New Random Generated Password " + NewPassword);
			LoginDATA.changePasswordReset(NewPassword, userIdDecoded);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	public static void resetPasswordBenUTL(String userId ) { 
		
		try {
			String NewPassword = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
			
			String userIdDecoded = new String(Base64.getDecoder().decode( userId  ));
			System.out.println("UserIDDD " + userIdDecoded);
			System.out.println("New Random Generated Password " + NewPassword);
			LoginDATA.changePasswordResetBen(NewPassword, userIdDecoded);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
public static void unlockBenUTL(String userId ) { 
		
		try {
			
			
			String userIdDecoded = new String(Base64.getDecoder().decode( userId  ));
			
			LoginDATA.unlockBenProc(userIdDecoded);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// Main Login Handler 
	public static boolean checkUserNamePassword(LoginSUP
	objActionSupport, HttpServletRequest objRequest, HttpServletResponse
	objResponse, String userId, String password) {
	  boolean isSuccess = true;
	  HttpSession session;
	  HttpSession objSession = objRequest.getSession();

	  try {
	    session = objRequest.getSession();

	    if (userId == null || userId.trim().isEmpty()) {
	      objSession.setAttribute("error", "User Id is required!");

	      return false;
	    }

	    if (password == null || password.trim().isEmpty()) {
	      objSession.setAttribute("error", "Password is required!");
	      return false;
	    }

	  //  boolean userExists = checkUsernamePass(userId, password);
	    String mobileNumber =
	      getMobileNoByUserId(userId, objRequest, objResponse);
	    System.out.println("mobileNumber> > > " + mobileNumber);

	    if ("".equals(mobileNumber)) {
	      System.out.println("action message");

	      objSession.setAttribute("error", "Invalid User Id");

	      objActionSupport.addActionMessage("Invalid or unregistered mobile number!");

	      return false;
	    }

	    if (mobileNumber.trim().length() < 10) {
	      objSession.setAttribute("error",
	        "Invalid User Id / Mobile No. Not Registered");
	      return false;
	    }

	    objSession.setAttribute("PatUserId", userId);
	    objSession.setAttribute("PatmobileNumber", mobileNumber);
	    String otp =
	      generateAndStoreOTPForForgetPass(mobileNumber, userId);

	    sendOtpSMS(mobileNumber, otp.split("#")[1], otp.split("#")[0]);
	    objSession.setAttribute("LoginError", "");

	    session.setAttribute("otpValidationKey", userId);

	  //  session.setAttribute("otpCount_" + userId, (Integer.valueOf(otpCount) + 1));

	    session.setAttribute("otpRefNo_" + userId, otp.split("#")[0]);

	  } catch (Exception e) {

	    objSession.setAttribute("LoginError", "An error occurred during login: " +
	      e.getMessage());

	    isSuccess = false;
	    e.printStackTrace();
	  }

	  return isSuccess;
	}

	private static String checkUsernamePass(String userId, String Password) {
	  HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
	  String status = "";
	  WebRowSet wb = null;
	  try {
	    String encodedPassword =
	      Base64.getEncoder().encodeToString(Password.getBytes());
	    String query =
	      "select gnum_mobile_number from ummt_user_mst where gnum_isvalid = 1 and gstr_login_id ='" +
	      userId + "' ";
	    int nIndex = hisdao.setQuery(query);
	    wb =
	      hisdao.executeQry(nIndex);

	    if (wb.next()) {
	      status = wb.getString(1);
	    }
	  } catch (Exception e) {
	    e.printStackTrace();
	  }
	  return status;
	}
	

}
