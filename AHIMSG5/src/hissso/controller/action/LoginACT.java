package hissso.controller.action;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.log.SysoCounter;

import hisglobal.config.HISConfig;
import hisglobal.utility.SecurityUtil;
import hissso.config.HISSSOConfig;
import hissso.controller.actionsupport.LoginSUP;
import hissso.controller.data.LoginDATA;
import hissso.controller.util.LoginUTL;
import vo.hissso.LoginVO;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.UserMasterVO;

//import sun.misc.BASE64Encoder;
public class LoginACT extends LoginSUP {
	private static final long serialVersionUID = 0L;
	// private static final String PAGE_INITIAL = "INITIAL"; // Only SSO Part
	private static final String PAGE_MAIN = "MAIN";
	//private static final String PAGE_PORTAL = "PORTAL";
	private static final String PAGE_HIS_LOGIN_DESK = "DESK";
	private static final String PAGE_HIS_SEAT = "SEAT";
	private static final String PAGE_ERROR = "ERROR";
	private static final String PAGE_HIS_LOGIN_CHANGE_PASSWORD = "CHNAGEPASSWORD";
	private static final String PAGE_HIS_FIRST_LOGIN = "FIRSTLOGIN";
	private static final String PAGE_HIS_FIRST_BEN_LOGIN = "FIRSTBENLOGIN";
	private static final String PAGE_HIS_SAVE_BEN_PASSWORD = "SAVEBENPASSWORD";
	private static final String PAGE_HIS_CGHS_LOGIN = "CGHSLOGIN";
	private static final String PAGE_HIS_EMPENALMENT = "EMPENALMENT";
	private static final String PAGE_HIS_CGHSWC = "CGHSWC";
	private static final String PAGE_HIS_RM = "RESTRICTEDMEDICINE";
	private static final String PAGE_HIS_BEN_LOGIN = "BENLOGIN";
	private static final String PAGE_HIS_FORGET_PASSWORD = "FORGETPASSWORD";
	private static final String PAGE_HIS_FORGET_PASSWORD_BEN = "FORGETBENPASSWORD"; 
	private static final String PAGE_HIS_REGISTER_BEN_PASSWORD = "REGISTERBENPASSWORD";
	private static final String PAGE_HIS_UNLOCK_USER = "UNLOCKUSER";
	
	
	

	public String execute() throws Exception {

		// System.out.println(objRequest.getRequestURL()+"---------------------
		// execute");

		return init();
	}

	public String init() throws Exception {

//	    HttpServletRequest request = ServletActionContext.getRequest();
//	    String urlPath = request.getRequestURI();
//	    
//	    String deviceType = isDeviceMobile(request);
//	    String hitCount = "1";
//
//	    System.out.println("urlPath::::::::::: \n" + urlPath + " | " + hitCount  + " | " +  deviceType   + " | " + request.getHeader("USER-AGENT"));
//
//	    String hitResponse = null;
//	    JSONObject getResponse = null;
	    if (LoginUTL.setInititals(this, objRequest, objResponse)) {
	        // Optional: You might want to insert HIT count here if needed
	  //  	hitResponse = LoginUTL.insertHITCount(urlPath, hitCount ,deviceType);
	         
	   //      JSONObject jsonResponse = new JSONObject(hitResponse);
	         
//	         if ("1".equals(jsonResponse.optString("status", "0"))) {
//
//	        	 getResponse = LoginUTL.getHITCount();
//	        	 
//	        	} else {
//	        	    // status is not 1, log the error
//	        	    String error = jsonResponse.optString("error", "Unknown error");
//	        	    System.err.println("Critical HIT count failure: " + error);
//	        	}
	         
	        return PAGE_MAIN;
	    } else {
	        return PAGE_ERROR;
	    }
	}
	
	
	/*
	 * public static String isDeviceMobile(HttpServletRequest request) { String
	 * userAgent = request.getHeader("USER-AGENT"); String deviceName
	 * ="Android|webOS|iPhone|iPad|BlackBerry|IEMobile|Opera Mini"; Pattern pattern;
	 * Matcher matcher;
	 * 
	 * pattern = Pattern.compile(deviceName); matcher = pattern.matcher(userAgent);
	 * 
	 * if (matcher.find()) { return "M"; // Mobile device detected } else { return
	 * "D"; // Desktop device } }
	 */
	
	/*
	 * public String portal() throws Exception{
	 * 
	 * System.out.println("portal >>>>..");
	 * 
	 * return PAGE_PORTAL;// PAGE_INITIAL;
	 * 
	 * }
	 */

	public String cghs() {

		objRequest.getSession().setAttribute("mstatus", "");
		objRequest.getSession().setAttribute("otpValidationKey", "");
		objRequest.getSession().setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		objRequest.setAttribute("message", "");
		objRequest.setAttribute("error", "");
		LoginUTL.setInititals(this, objRequest, objResponse);
		return PAGE_HIS_CGHS_LOGIN;
	}

	public String empanelled() {
		//System.out.println("empanelled  >>>     >    ");
		return PAGE_HIS_EMPENALMENT;
	}
	
	public String cghsWC() {
		//System.out.println("CGHSWC  >>>     >    ");
		return PAGE_HIS_CGHSWC;
	}
	
	public String restMedicine() {
		//System.out.println("CGHSWC  >>>     >    ");
		return PAGE_HIS_RM;
	}
	public String ben() {

		objRequest.getSession().setAttribute("mstatus", "");
		objRequest.getSession().setAttribute("otpValidationKey", "");
		objRequest.getSession().setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		objRequest.setAttribute("message", "");
		objRequest.setAttribute("error", "");
		LoginUTL.setInititals(this, objRequest, objResponse);
		return PAGE_HIS_BEN_LOGIN;
	}

	public String benlogin() throws Exception {

		objRequest.getSession().setAttribute("mstatus", "");
		objRequest.getSession().setAttribute("otpValidationKey", "");
		objRequest.getSession().setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		objRequest.setAttribute("message", "");
		objRequest.setAttribute("error", "");

		HttpSession objSession = objRequest.getSession();

		// Check if the session login token is valid
		if (this.varUserName != null) {
			//System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));

			if (this.sessionLoginToken != null
					&& this.sessionLoginToken.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
			} else {
				//System.out.println("token validate not a valid request");
				objRequest.setAttribute("message", "Not a Valid Request !");
				objRequest.setAttribute("error", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_BEN_LOGIN;
			}
		}

		// Validate the username if provided
		if (this.varUserName != null && !this.varUserName.isEmpty() && !this.varUserName.matches("[A-Za-z0-9_]+")
				|| this.varUserName.length() > 100) {
			objRequest.setAttribute("error", "Invalid BEN. ID or Password !");
			return PAGE_HIS_BEN_LOGIN;
		}

		// Handling login based on username or mobile number
		if ((this.varUserName != null && !this.varUserName.isEmpty() && this.varPassword != null
				&& !this.varPassword.isEmpty())) {

			// CAPTCHA validation if enabled
			if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {
				String parm = this.getCaptchaResponse();
				if (parm == null) {

					objRequest.setAttribute("error", "Captcha is Empty! Please enter captcha!");
					return PAGE_HIS_BEN_LOGIN;
				}
				String c = (String) objSession.getAttribute("CAPTCHA_KEY");

				if (!parm.equals(c.trim())) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objRequest.setAttribute("error", "Invalid Captcha! Please try again!");
					return PAGE_HIS_BEN_LOGIN;
				}
			}

			// Check if the request is a POST request for login
			if ("POST".equalsIgnoreCase(objRequest.getMethod())) {
				String res = LoginUTL.loginBen(this, objRequest, objResponse);
				if ("1".equals(res)) {
					return PAGE_HIS_LOGIN_DESK;
				}else if ("4".equals(res)) {
					return PAGE_HIS_BEN_LOGIN;
				}else if ("6".equals(res)) {
					objRequest.setAttribute("error", "Invalid Mobile Number! Please update your Mobile Number to Login!");
					return PAGE_HIS_BEN_LOGIN;
				}else if ("7".equals(res)) {
					objRequest.setAttribute("error", "Invalid / Unregistered or Not a Main Card Holder!");
					return PAGE_HIS_BEN_LOGIN;
				}else {
					String errorMsg = "Invalid User Name or Password !";

					if (res.split("#")[0].equals("3"))
						errorMsg = res.split("#")[1];
					
					
					if(errorMsg.equals("Change Password")) {
						//System.out.println("inside change password>>>> "+ this.varUserName );
						objSession.setAttribute("benIdCP",this.varUserName);
						return PAGE_HIS_FIRST_BEN_LOGIN;
						
					}

					LoginUTL.setInititals(this, objRequest, objResponse);
					objRequest.setAttribute("error", errorMsg);
					
					return PAGE_HIS_BEN_LOGIN;
				}
			} else {

				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("message", "Not a Valid Request !");
				objRequest.setAttribute("error", "Not a Valid Request !");
				return PAGE_HIS_BEN_LOGIN;

			}
		} else {
			// If neither username nor mobile number is provided, re-initialize the login
			// page
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "");
			return PAGE_HIS_BEN_LOGIN;
		}
	}

	public String login() throws Exception {
		HttpSession objSession = objRequest.getSession();

		objRequest.setAttribute("message", "");
		objRequest.setAttribute("error", "");
		objRequest.getSession().setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		objSession.setAttribute("mstatus", "");
		objSession.setAttribute("otpValidationKey", "");

		// Check if the session login token is valid
		if (this.varUserName != null) {
			//System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));

			if (this.sessionLoginToken != null
					&& this.sessionLoginToken.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
			} else {
			//	System.out.println("token validate not a valid request");
				
				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("message", "Not a Valid Request !");
				objRequest.setAttribute("error", "Kindly refresh the page.");
				return PAGE_HIS_CGHS_LOGIN;

			}
		}

		// Validate the username if provided
		if (this.varUserName != null && !this.varUserName.isEmpty() && !(this.varUserName.matches("[A-Za-z0-9_]+") || this.varUserName.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$"))
				|| this.varUserName.length() > 50) {

			objRequest.setAttribute("error", "Invalid User Name or Password!");
			return PAGE_HIS_CGHS_LOGIN;

		}

		// Handling login based on username or mobile number
		if ((this.varUserName != null && !this.varUserName.isEmpty() && this.varPassword != null
				&& !this.varPassword.isEmpty())) {

			// CAPTCHA validation if enabled
			if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {
				String parm = this.getCaptchaResponse();
				if (parm == null) {

					objRequest.setAttribute("error", "Captcha is Empty! Please enter captcha!");
					return PAGE_HIS_CGHS_LOGIN;

				}
				String c = (String) objSession.getAttribute("CAPTCHA_KEY");

				if (!parm.equals(c.trim())) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objRequest.setAttribute("error", "Invalid Captcha! Please try again!");
					return PAGE_HIS_CGHS_LOGIN;
				}
			}

			// Check if the request is a POST request for login
			if ("POST".equalsIgnoreCase(objRequest.getMethod())) {

				String res = LoginUTL.loginUser(this, objRequest, objResponse);
				//System.out.println("res>>>"+ res);
				if ("1".equals(res)) {
					return PAGE_HIS_LOGIN_DESK;
				} else if ("2".equals(res)) {
					return PAGE_HIS_SEAT;
				} else if ("4".equals(res)) {
					return PAGE_HIS_CGHS_LOGIN;
				}
				else if ("6".equals(res)) {
					objRequest.setAttribute("error", "Invalid Mobile Number! Please update your Mobile Number to Login!");
					return PAGE_HIS_CGHS_LOGIN;
				}
				else {
					
					String errorMsg = "Invalid User Name or Password !";

					if (res.split("#")[0].equals("3"))
						errorMsg = res.split("#")[1];

					if(errorMsg.equals("Change Password")) {
						 
						
						return PAGE_HIS_FIRST_LOGIN;
						
					}
					
					
					LoginUTL.setInititals(this, objRequest, objResponse);
					objRequest.setAttribute("error", errorMsg);
					return PAGE_HIS_CGHS_LOGIN;
				}
			} else {

				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("message", "Not a Valid Request !");
				objRequest.setAttribute("error", "Not a Valid Request !");
				return PAGE_HIS_CGHS_LOGIN;

			}
		} else {
			// If neither username nor mobile number is provided, re-initialize the login
			// page
			 
			return logout();
		}
	}

	public String switchRole() throws Exception {

		UserMasterVO voUser = (UserMasterVO) objRequest.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);

		if (voUser != null && voUser.getVarUserId() != null && voUser.getVarUserId().trim().length() > 2) {

			String seatPageData = LoginUTL.seatDetails(voUser, "selectRole"); // , "switchRole");

			objRequest.getSession().setAttribute("seatPageData", seatPageData);

			return PAGE_HIS_SEAT;

		} else {

			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;
		}

	}

	public String role() {
		HttpSession objSession = objRequest.getSession();

		LoginVO voLogin = (LoginVO) objSession.getAttribute("preLoginDtls");
		UserMasterVO voUser = (UserMasterVO) objSession.getAttribute("preUserDtls");

		try {
			if (voUser != null && voUser.getVarUserId() != null && voUser.getVarUserId().trim().length() > 2) {

				if (objRequest.getParameter("varSeatId") != null) {

					String seat = objRequest.getParameter("varSeatId");
					String seatName = objRequest.getParameter("varSeatName");

					voUser.setVarUserId(seat.split(",")[0] + "^" + seat.split(",")[1]);

					voUser.setVarSeatId(seat.split(",")[1]);
					voUser.setVarUserSeatId(seat.split(",")[1]);
					voUser.setVarHospitalCode(seat.split(",")[2]);
					voUser.setVarSeatName(seatName);

				}

				List<HospitalMasterVO> lstHospital = LoginDATA.getHospitalVos(voUser.getVarHospitalCode());

				voUser.setVoHospital(lstHospital.get(0));

				LoginUTL.loginUserWithSeat(this, objRequest, objResponse, objSession, voLogin, voUser);

				return PAGE_HIS_LOGIN_DESK;

			} else {

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_MAIN;
			}

		} catch (Exception e) {
			e.printStackTrace();

			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;

		}
	}

	/*
	 * ///MObileLogin
	 */

	public String mbenlogin() throws Exception {
		System.out.println("mbenlogin");
		HttpSession objSession = objRequest.getSession();

		if(objSession.getAttribute("BenMobileNumber") == null) {
			
			objSession.setAttribute("mstatus", "motp");
		}
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		String mobileNumber = objRequest.getParameter("varMobileNumber");
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
		System.out.println("9");
		if (mobileNumber != null) {
			//System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			//System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + mobileNumber) != null
						&& objSession.getAttribute("otpCount_" + mobileNumber).toString().length() > 0
								? objSession.getAttribute("otpCount_" + mobileNumber).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + mobileNumber, "");

					objRequest.setAttribute("LoginError", "Maximum OTP Count Reached");
					return PAGE_HIS_BEN_LOGIN;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.mLoginBenByMobile(this, objRequest, objResponse, mobileNumber, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_BEN_LOGIN;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_BEN_LOGIN;

			} else {
				System.out.println("14");
				objRequest.setAttribute("message", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_BEN_LOGIN;
			}
		} else {
			System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_BEN_LOGIN;
		}
	}

	public String mbenloginValidateOtp() throws Exception {

		//System.out.println("Inside by mValidateOtp");

		HttpSession objSession = objRequest.getSession();

		objSession.setAttribute("mstatus", "motp");

		String mobileNumber = objRequest.getParameter("varMobileNumber");
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		String userOtp = objRequest.getParameter("varOtp");

		// Step 1: Check session login token
		if (sessionLoginTokenFromPage != null
				&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;

			// Step 3: Validate OTP if provided
			if (userOtp != null && !userOtp.trim().isEmpty()) {
				//System.out.println("userOtp>>> " + userOtp);
				int otpStatus = LoginUTL.mValidateOtpForBen2(mobileNumber, userOtp, objRequest);
				//System.out.println("otpStatus>>>" + otpStatus);

				switch (otpStatus) {
				case 1:

					String res = LoginUTL.mloginBenFinal(this, objRequest, objResponse, mobileNumber);

					if ("1".equals(res)) {
						return PAGE_HIS_LOGIN_DESK;
					} else {
 
						String errorMsg = "Invalid User Name or Password !";

						if (res.split("#")[0].equals("3"))
							errorMsg = res.split("#")[1];

						LoginUTL.setInititals(this, objRequest, objResponse);
						objRequest.setAttribute("error", errorMsg);
						
						return PAGE_HIS_BEN_LOGIN;
					}

				case 2:
					objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");

					/* this.addActionMessage("Invalid OTP. Please try again."); */
					return PAGE_HIS_BEN_LOGIN;

				case 3:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("OTP has expired. Please request a new one."); */
					return PAGE_HIS_BEN_LOGIN;

				default:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("An unknown error occurred while validating OTP."); */
					return PAGE_HIS_BEN_LOGIN;
				}
			} else {
				objSession.setAttribute("LoginError", "OTP is required!");
				/* this.addActionMessage("OTP is required!"); */
				return PAGE_HIS_BEN_LOGIN;
			}

		} else {

			objRequest.setAttribute("message", "Not a Valid Request !");
			// objSession.setAttribute("LoginError", "Kindly refresh the page.");
			
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;
		}

	}

	public String mlogin() throws Exception {
		HttpSession objSession = objRequest.getSession();

		if(objSession.getAttribute("PatmobileNumber") == null) {
		
			objSession.setAttribute("mstatus", "motp");
		}
		
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");

		String mobileNumber = objRequest.getParameter("varMobileNumber");
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
	//	System.out.println("999");
	//	System.out.println("9");
		if (mobileNumber != null) {
			//System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			//System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + mobileNumber) != null
						&& objSession.getAttribute("otpCount_" + mobileNumber).toString().length() > 0
								? objSession.getAttribute("otpCount_" + mobileNumber).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + mobileNumber, "");
					objSession.setAttribute("otpRefNo_" + mobileNumber, "" );

					objRequest.setAttribute("LoginError", "Maximum OTP Count Reached");
					return PAGE_HIS_CGHS_LOGIN;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.mLoginUserByMobile(this, objRequest, objResponse, mobileNumber, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_CGHS_LOGIN;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_CGHS_LOGIN;

			} else {
				//System.out.println("14");
				objRequest.setAttribute("message", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_CGHS_LOGIN;
			}
		} else {
			//System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_CGHS_LOGIN;
		}
	}

	public String mloginValidateOtp() throws Exception {

		//System.out.println("Inside by mValidateOtp");

		HttpSession objSession = objRequest.getSession();

		objSession.setAttribute("mstatus", "motp");

		String mobileNumber = objRequest.getParameter("varMobileNumber");
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		String userOtp = objRequest.getParameter("varOtp");
		
		// Step 1: Check session login token
		if (sessionLoginTokenFromPage != null
				&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;

			// Step 3: Validate OTP if provided
			if (userOtp != null && !userOtp.trim().isEmpty()) {
			//	System.out.println("userOtp>>> " + userOtp);
				int otpStatus = LoginUTL.mValidateOtp2(mobileNumber, userOtp, objRequest);
			//	System.out.println("otpStatus>>>" + otpStatus);

				switch (otpStatus) {
				case 1:

					String res = LoginUTL.mloginUserFinal(this, objRequest, objResponse, mobileNumber);

					if ("1".equals(res)) {
						return PAGE_HIS_LOGIN_DESK;
					} else if ("2".equals(res)) {
						return PAGE_HIS_SEAT;
					} else {

						String errorMsg = "Invalid User Name or Password !";

						if (res.split("#")[0].equals("3"))
							errorMsg = res.split("#")[1];

						LoginUTL.setInititals(this, objRequest, objResponse);
						objRequest.setAttribute("error", errorMsg);
						return PAGE_HIS_CGHS_LOGIN;
					}

				case 2:
					objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");

					/* this.addActionMessage("Invalid OTP. Please try again."); */
					return PAGE_HIS_CGHS_LOGIN;

				case 3:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("OTP has expired. Please request a new one."); */
					return PAGE_HIS_CGHS_LOGIN;

				default:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("An unknown error occurred while validating OTP."); */
					return PAGE_HIS_CGHS_LOGIN;
				}
			} else {
				objSession.setAttribute("LoginError", "OTP is required!");
				/* this.addActionMessage("OTP is required!"); */
				return PAGE_HIS_CGHS_LOGIN;
			}

		} else {

			objRequest.setAttribute("message", "Not a Valid Request !");
			// objSession.setAttribute("LoginError", "Kindly refresh the page.");

			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;
		}

	}

	public String logout() throws Exception {
		System.out.println("Logging out");
		if (LoginUTL.logoutUser(this, objRequest, objResponse)) {
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;// PAGE_INITIAL;
		} else
			return PAGE_MAIN;// PAGE_INITIAL;
	}

	public String desk() throws Exception {
		return PAGE_HIS_LOGIN_DESK;
	}

	public String firstLogin() throws Exception {
		if (LoginUTL.setEssentialforFirstLogin(this, objRequest, objResponse))
			return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
		else
			return PAGE_ERROR;
	}

	
	public String changePasswordFirst() throws Exception {
		

		HttpSession objSession = objRequest.getSession();
		
		
		if (this.sessionLoginToken != null
				&& this.sessionLoginToken.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;
		} else {
			//System.out.println("token validate not a valid request");

			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("message", "Not a Valid Request !");
			objRequest.setAttribute("error", "Kindly refresh the page.");
			return PAGE_HIS_FIRST_LOGIN;

		}
		
		
		
		if ((this.varUserName != null && !this.varUserName.isEmpty() && this.varPassword != null
				&& !this.varPassword.isEmpty())) {

			// CAPTCHA validation if enabled
			if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {
				String parm = this.getCaptchaResponse();
				if (parm == null) {

					LoginUTL.setInititals(this, objRequest, objResponse);
					objRequest.setAttribute("error", "Captcha is Empty! Please enter captcha!");
					return PAGE_HIS_FIRST_LOGIN;

				}
				String c = (String) objSession.getAttribute("CAPTCHA_KEY");

				if (!parm.equals(c.trim())) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objRequest.setAttribute("error", "Invalid Captcha! Please try again!");
					return PAGE_HIS_FIRST_LOGIN;
				}
			}

			// Check if the request is a POST request for login
			if ("POST".equalsIgnoreCase(objRequest.getMethod())) {
		
		
		
		if(this.getVarPassword().equals(this.getVarOldPassword())) {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Old Password and New Password cannot be Same");
			return PAGE_HIS_FIRST_LOGIN;
		}
		
		
		if(!this.getVarPassword().equals(this.getVarConfirmPassword())) {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "New Password and Confirm Password must be Same");
			return PAGE_HIS_FIRST_LOGIN;
		}
		 
		
		if(LoginUTL.changePasswordFirst(this, objRequest, objResponse)) {
			
			objSession.setAttribute("LoginSuccess", "Password Reset Successful");
			return PAGE_HIS_CGHS_LOGIN;
			//return logout();
			
		}else {
			
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Error Occured, Please try Again");
			return PAGE_HIS_FIRST_LOGIN;
			
		}
		
		
		
		
			}else {
				
				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("error", "Not a Valid Request");
				return PAGE_HIS_FIRST_LOGIN;
				
			}
			
		}else {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Please Enter the Mandatory Fields");
			return PAGE_HIS_FIRST_LOGIN;
		}
		
				 
	}
	
	
public String changePasswordFirstBen() throws Exception {
		

		HttpSession objSession = objRequest.getSession();
		
		//System.out.println("inside changePasswordFirstBen"); 
		if (this.sessionLoginToken != null
				&& this.sessionLoginToken.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;
		} else {
			//System.out.println("token validate not a valid request");

			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("message", "Not a Valid Request !");
			objRequest.setAttribute("error", "Kindly refresh the page.");
			return PAGE_HIS_FIRST_BEN_LOGIN;

		}
		//System.out.println("username>>> " +  this.varUserName );
		
		String username = (String) objSession.getAttribute("benIdCP");
	//	System.out.println("username123>>> " +  username );
		//System.out.println("varPassword>>> " +  this.varPassword );
		this.varUserName = username;
		
		if ( (this.varUserName != null && !this.varUserName.isEmpty() && this.varPassword != null
				&& !this.varPassword.isEmpty()) ) {

			// CAPTCHA validation if enabled
			if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {
				String parm = this.getCaptchaResponse();
				if (parm == null) {

					LoginUTL.setInititals(this, objRequest, objResponse);
					objRequest.setAttribute("error", "Captcha is Empty! Please enter captcha!");
					return PAGE_HIS_FIRST_BEN_LOGIN;

				}
				String c = (String) objSession.getAttribute("CAPTCHA_KEY");

				if (!parm.equals(c.trim())) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objRequest.setAttribute("error", "Invalid Captcha! Please try again!");
					return PAGE_HIS_FIRST_BEN_LOGIN;
				}
			}

			// Check if the request is a POST request for login
			if ("POST".equalsIgnoreCase(objRequest.getMethod())) {
		
		
		
		if(this.getVarPassword().equals(this.getVarOldPassword())) {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Old Password and New Password cannot be Same");
			return PAGE_HIS_FIRST_BEN_LOGIN;
		}
		
		
		if(!this.getVarPassword().equals(this.getVarConfirmPassword())) {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "New Password and Confirm Password must be Same");
			return PAGE_HIS_FIRST_BEN_LOGIN;
		}
		 
		
		if(LoginUTL.changePasswordFirstBen(this, objRequest, objResponse)) {
			
			objSession.setAttribute("LoginSuccess", "Password Reset Successful");
			return PAGE_HIS_BEN_LOGIN;
			//return logout();
			
		}else {
			
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Error Occured, Please try Again");
			return PAGE_HIS_FIRST_BEN_LOGIN;
			
		}
		
		
		
		
			}else {
				
				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("error", "Not a Valid Request");
				return PAGE_HIS_FIRST_BEN_LOGIN;
				
			}
			
		}else {
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Please Enter the Mandatory Fields");
			return PAGE_HIS_FIRST_BEN_LOGIN;
		}
		
				 
	}
	
	

public String SaveBenPassword() throws Exception {   					// This should be the saved password
	
	
	HttpSession objSession = objRequest.getSession();
	String userId = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
	System.out.println("inside SaveBenPassword >> " + userId); 
	if (this.sessionLoginToken != null
			&& this.sessionLoginToken.equals(objSession.getAttribute("sessionLoginToken"))) {
		objSession.setAttribute("sessionLoginToken", "");
		this.sessionLoginToken = null;
	} else {
		//System.out.println("token validate not a valid request");

		LoginUTL.setInititals(this, objRequest, objResponse);
		objRequest.setAttribute("message", "Not a Valid Request !");
		objRequest.setAttribute("error", "Kindly refresh the page.");
		return PAGE_HIS_SAVE_BEN_PASSWORD;

	}
	//System.out.println("username>>> " +  this.varUserName );
	
	String username = (String) objSession.getAttribute("varUserID");
//	System.out.println("username123>>> " +  username );
	//System.out.println("varPassword>>> " +  this.varPassword );
	this.varUserName = username;
	
	if ( (userId != null && !userId.isEmpty() && this.varPassword != null
			&& !this.varPassword.isEmpty()) ) {

		// CAPTCHA validation if enabled
		if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {
			String parm = this.getCaptchaResponse();
			if (parm == null) {

				LoginUTL.setInititals(this, objRequest, objResponse);
				objRequest.setAttribute("error", "Captcha is Empty! Please enter captcha!");
				return PAGE_HIS_SAVE_BEN_PASSWORD;

			}
			String c = (String) objSession.getAttribute("CAPTCHA_KEY");

			if (!parm.equals(c.trim())) {
				LoginUTL.setInititals(this, objRequest, objResponse);

				objRequest.setAttribute("error", "Invalid Captcha! Please try again!");
				return PAGE_HIS_SAVE_BEN_PASSWORD;
			}
		}

		// Check if the request is a POST request for login
		if ("POST".equalsIgnoreCase(objRequest.getMethod())) {

	
	System.out.println("new password entered>>>> "+ this.getVarPassword()  );
	if(!this.getVarPassword().equals(this.getVarConfirmPassword())) {
		LoginUTL.setInititals(this, objRequest, objResponse);
		objRequest.setAttribute("error", "New Password and Confirm Password must be Same");
		return PAGE_HIS_SAVE_BEN_PASSWORD;
	}
	 
	
	if(LoginUTL.registerPasswordBen(this, objRequest, objResponse)) {
		
		objSession.setAttribute("LoginSuccess", "Password Reset Successful");
		return PAGE_HIS_BEN_LOGIN;
		//return logout();
		
	}else {
		
		LoginUTL.setInititals(this, objRequest, objResponse);
		objRequest.setAttribute("error", "Error Occured, Please try Again");
		return PAGE_HIS_SAVE_BEN_PASSWORD;
		
	}
	
	
	
	
		}else {
			
			LoginUTL.setInititals(this, objRequest, objResponse);
			objRequest.setAttribute("error", "Not a Valid Request");
			return PAGE_HIS_SAVE_BEN_PASSWORD;
			
		}
		
	}else {
		LoginUTL.setInititals(this, objRequest, objResponse);
		objRequest.setAttribute("error", "Please Enter the Mandatory Fields");
		return PAGE_HIS_SAVE_BEN_PASSWORD;
	}
	
			 
}


	
	public void captcha() throws ServletException, IOException {
		// System.out.println("inside captcha method");
		LoginUTL.setCaptcha(this, objRequest, objResponse);

	}

	public String sessionCheck() throws ServletException, IOException {

		String sessionValid = "false:" + new Date();

		try {
			if (objRequest.getSession().getAttribute("HOSPITAL_CODE") != null) {

				sessionValid = "true:" + new Date();

			}

		} catch (Exception e) {
			System.err.println(e);
		}

		return Base64.getEncoder().encodeToString(sessionValid.getBytes());

	}

	public String getToken() throws IOException {
		new SecurityUtil();
		// System.out.println("getToken");
		String tokenVal = SecurityUtil.sha1(new Date().toString());

		objResponse.setHeader("Cache-Control", "no-cache");
		objResponse.getWriter().print(tokenVal);

		return null;

	}
	
	public String construction() throws Exception {
		return "CONSTRUCTION";
	}

	
	public String forgetPassword() throws Exception {
		return PAGE_HIS_FORGET_PASSWORD;
	}
	
	public String forgetPasswordBen() throws Exception {
		
		return PAGE_HIS_FORGET_PASSWORD_BEN;
	}
	
	public String unlockben() throws Exception {
		
		return PAGE_HIS_UNLOCK_USER;
	}
	
	
public String registerPasswordBen() throws Exception {
		//System.out.println("beneficiary password reset");
		return PAGE_HIS_REGISTER_BEN_PASSWORD;
	}

	public String resetPassword() throws Exception {
		HttpSession objSession = objRequest.getSession();
		System.out.println(this.getVarUserId()+ " >> "+this.getVarOtp() ); 
		// Get mobile number from session
		// Get correct otp from OTP map
		String userId = this.getVarUserId().toString();
		String mobileNumber = objSession.getAttribute("PatmobileNumber").toString() ; 	
		
		int res= LoginUTL.validateOTPforgetPassword(mobileNumber, this.getVarOtp() , this.getVarUserId() ,objRequest );
	//	System.out.println("res>>> " + res);
		switch(res) {
		case 1: 
			objSession.removeAttribute("otpValidationKey"); 
			LoginUTL.resetPasswordUTL(userId);
			objSession.setAttribute("LoginSuccess", "Password Reset Successful. Check Registered Email Id for Login Credentials");	
			return PAGE_HIS_CGHS_LOGIN;
		
		case 2: 
			objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");
			System.out.println("Invalid OTP. Please try again.");
			return PAGE_HIS_FORGET_PASSWORD;
		
		case 3: 
			objSession.setAttribute("LoginError", "Please Try Again");
			return PAGE_HIS_FORGET_PASSWORD;
			
		case 4: 
			objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
			return PAGE_HIS_FORGET_PASSWORD;
			
		}
		return "NULL";
		
	}

	public String resetPasswordBen() throws Exception {
		//System.out.println("inside reset password ben");
		HttpSession objSession = objRequest.getSession();
		System.out.println(this.getVarUserId()+ " >> "+this.getVarOtp() ); 
		// Get mobile number from session
		// Get correct otp from OTP map
		String userId = this.getVarUserId().toString();
		String mobileNumber = objSession.getAttribute("PatmobileNumber").toString(); 	
		
		int res= LoginUTL.validateOTPforgetPasswordBen(mobileNumber, this.getVarOtp() , this.getVarUserId() ,objRequest );
		//System.out.println("res>>> " + res);
		switch(res) {
		case 1: 
			
			objSession.removeAttribute("otpValidationKey"); 
			LoginUTL.resetPasswordBenUTL(userId);
			objSession.setAttribute("LoginSuccess", "Password Reset Successful. Kindly use \"123456\" as your password to Login.");	
			return PAGE_HIS_BEN_LOGIN;
		
		case 2: 
			objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");
			System.out.println("Invalid OTP. Please try again.");
			return PAGE_HIS_FORGET_PASSWORD_BEN;
		
		case 3: 
			objSession.setAttribute("LoginError", "Please Try Again");
			return PAGE_HIS_FORGET_PASSWORD_BEN;
			
		case 4: 
			objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
			return PAGE_HIS_FORGET_PASSWORD_BEN;
			
		}
		return "NULL";
		
	}
	
	public String unlockBenvalidate() throws Exception {
		//System.out.println("inside reset password ben");
		HttpSession objSession = objRequest.getSession();
		System.out.println(this.getVarUserId()+ " >> "+this.getVarOtp() ); 
		// Get mobile number from session
		// Get correct otp from OTP map
		String userId = this.getVarUserId().toString();
		String mobileNumber = objSession.getAttribute("PatmobileNumber").toString(); 	
		
		int res= LoginUTL.validateOTPunlockBen(mobileNumber, this.getVarOtp() , this.getVarUserId() ,objRequest );
		//System.out.println("res>>> " + res);
		switch(res) {
		case 1: 
			objSession.removeAttribute("otpValidationKey"); 
			LoginUTL.unlockBenUTL(userId);
			objSession.setAttribute("LoginSuccess", "Beneficiary Unlocked");
			objSession.setAttribute("LoginError", "");	
			return PAGE_HIS_BEN_LOGIN;
		
		case 2: 
			objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");
			System.out.println("Invalid OTP. Please try again.");
			return PAGE_HIS_UNLOCK_USER ;
		
		case 3: 
			objSession.setAttribute("LoginError", "Please Try Again");
			return PAGE_HIS_UNLOCK_USER;
			
		case 4: 
			objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
			return PAGE_HIS_UNLOCK_USER;
			
		}
		return "NULL";
		
	}
	
	public String regPassBen() throws Exception {
		//System.out.println("inside reset password ben");
		System.out.println("inside regPassBen");
		HttpSession objSession = objRequest.getSession();
		objSession.setAttribute("LoginError", "");
		System.out.println(this.getVarUserId()+ " >> "+this.getVarOtp() ); 
		// Get mobile number from session
		// Get correct otp from OTP map
		String userId = this.getVarUserId().toString();
		String mobileNumber = objSession.getAttribute("PatmobileNumber").toString(); 	
		
		int res= LoginUTL.validateOTPregisterPasswordBen(mobileNumber, this.getVarOtp() , this.getVarUserId() ,objRequest );
		System.out.println("res>>> " + res);
		switch(res) {
		case 1: 
			
			objSession.removeAttribute("otpValidationKey"); 
			//LoginUTL.resetPasswordBenUTL(userId); // remove this things and now redirect to enter new password page.
			//objSession.setAttribute("LoginSuccess", "Password Reset Successful. Kindly use \"123456\" as your password to Login.");	
			return PAGE_HIS_SAVE_BEN_PASSWORD;
		
		case 2: 
			objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");
			System.out.println("Invalid OTP. Please try again.");
			return PAGE_HIS_REGISTER_BEN_PASSWORD;
		
		case 3: 
			objSession.setAttribute("LoginError", "Please Try Again");
			return PAGE_HIS_REGISTER_BEN_PASSWORD;
			
		case 4: 
			objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
			return PAGE_HIS_REGISTER_BEN_PASSWORD;
			
		}
		return "NULL";
		
	}

	
	public String forgetPasswordOtp() {
		HttpSession objSession = objRequest.getSession();
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		
		System.out.println("UserId:::: " + this.getVarUserId());
		System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
		if (objSession.getAttribute("varUserID") == null ) {
			System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
			objSession.setAttribute("varUserID", this.getVarUserId() );
		}
		String userId = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
		System.out.println("9");
		if (userId != null) {
			//System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			//System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + userId) != null
						&& objSession.getAttribute("otpCount_" + userId).toString().length() > 0
								? objSession.getAttribute("otpCount_" + userId).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + userId, "");

					objRequest.setAttribute("error", "Maximum OTP Count Reached");
					return PAGE_HIS_FORGET_PASSWORD;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.sendForgotPasswordOtp(this, objRequest, objResponse, userId, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_FORGET_PASSWORD;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_FORGET_PASSWORD;

			} else {
				System.out.println("14");
				objRequest.setAttribute("error", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_FORGET_PASSWORD;
			}
		} else {
			System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_FORGET_PASSWORD;
		}
		
	}
	

	public String forgetPasswordOtpBen() {
		HttpSession objSession = objRequest.getSession();
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		
		System.out.println("UserId:::: " + this.getVarUserId());
		System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
		if (objSession.getAttribute("varUserID") == null ) {
			System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
			objSession.setAttribute("varUserID", this.getVarUserId() );
		}
		String userId = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
		System.out.println("9");
		if (userId != null) {
			System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + userId) != null
						&& objSession.getAttribute("otpCount_" + userId).toString().length() > 0
								? objSession.getAttribute("otpCount_" + userId).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + userId, "");

					objRequest.setAttribute("error", "Maximum OTP Count Reached");
					return PAGE_HIS_FORGET_PASSWORD_BEN;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.sendForgotPasswordOtpBen(this, objRequest, objResponse, userId, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_FORGET_PASSWORD_BEN;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_FORGET_PASSWORD_BEN;

			} else {
				System.out.println("14");
				objRequest.setAttribute("error", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_FORGET_PASSWORD_BEN;
			}
		} else {
			System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_FORGET_PASSWORD_BEN;
		}
		
	}
	
	
	public String unlockbeneficiary() {
		System.out.println("unlock uer");
		HttpSession objSession = objRequest.getSession();
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		
		System.out.println("UserId:::: " + this.getVarUserId());
		System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
		/*
		 * if (objSession.getAttribute("varUserID") == null ) { System.out.println(
		 * "OBJ Session>> "+objSession.getAttribute("varUserID"));
		 * objSession.setAttribute("varUserID", this.getVarUserId() ); }
		 */
		objSession.setAttribute("varUserID", this.getVarUserId() );
		String userId = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
	
		if (userId != null) {
			System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + userId) != null
						&& objSession.getAttribute("otpCount_" + userId).toString().length() > 0
								? objSession.getAttribute("otpCount_" + userId).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + userId, "");

					objRequest.setAttribute("error", "Maximum OTP Count Reached");
					return PAGE_HIS_UNLOCK_USER;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.sendUnlockUserBenOtp(this, objRequest, objResponse, userId, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_UNLOCK_USER;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_UNLOCK_USER;

			} else {
				System.out.println("14");
				objRequest.setAttribute("error", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_UNLOCK_USER;
			}
		} else {
			System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_UNLOCK_USER;
		}
		
	}
	
	
	public String registerPasswordOtpBen() {
		System.out.println("inside registerPasswordOtpBen");
		
		HttpSession objSession = objRequest.getSession();
		objSession.setAttribute("otpValidationKey", "");
		objRequest.setAttribute("LoginError", "");
		objRequest.getSession().setAttribute("LoginSuccess" , "");
		String userIdFinal = new String(Base64.getDecoder().decode(  this.getVarUserId() ));
		System.out.println("userIdFinal>> " + userIdFinal );
		
		 
		//System.out.println("UserId:::: " + this.getVarUserId());
		//String userId123 = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
		//System.out.println("userId today1 " + userId123);
		//System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
	//	if (objSession.getAttribute("varUserID") == null ) {
		
			System.out.println(  "OBJ Session>> "+objSession.getAttribute("varUserID"));
			objSession.setAttribute("varUserID", this.getVarUserId() );
		//}
		String userId = new String(Base64.getDecoder().decode( objSession.getAttribute("varUserID").toString()  ));
		System.out.println("userId today1 " + userId);
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		// String userOtp = objRequest.getParameter("varOtp");
		System.out.println("9New");
		if (userId != null) {
			System.out.println(this.sessionLoginToken + "===========" + objSession.getAttribute("sessionLoginToken"));
			System.out.println("10");
			// Step 1: Check session login token
			if (sessionLoginTokenFromPage != null
					&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
				objSession.setAttribute("sessionLoginToken", "");
				this.sessionLoginToken = null;
				System.out.println("11");

				String otpCount = (objSession.getAttribute("otpCount_" + userId) != null
						&& objSession.getAttribute("otpCount_" + userId).toString().length() > 0
								? objSession.getAttribute("otpCount_" + userId).toString()
								: "0");

				if (Integer.valueOf(otpCount) > 2) {
					LoginUTL.setInititals(this, objRequest, objResponse);

					objSession.setAttribute("otpValidationKey", "");

					objSession.setAttribute("otpCount_" + userId, "");

					objRequest.setAttribute("error", "Maximum OTP Count Reached");
					return PAGE_HIS_REGISTER_BEN_PASSWORD ;
				}

				// Step 2: Attempt to log in user
				if (LoginUTL.sendRegisterOtpBen(this, objRequest, objResponse, userId, otpCount)) {

					System.out.println("12");
					return PAGE_HIS_REGISTER_BEN_PASSWORD;
				}

				System.out.println("13");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_REGISTER_BEN_PASSWORD;

			} else {
				System.out.println("14");
				objRequest.setAttribute("error", "Not a Valid Request !");
				// objRequest.setAttribute("LoginError", "Kindly refresh the page.");

				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_HIS_REGISTER_BEN_PASSWORD;
			}
		} else {
			System.out.println("15");
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_HIS_REGISTER_BEN_PASSWORD;
		}
		
	}

	public String NewloginValidateOTP() throws Exception {

		//System.out.println("Inside by NewloginValidateOTP");

		HttpSession objSession = objRequest.getSession();

		//objSession.setAttribute("mstatus", "motp");

	
		
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");

		// Step 1: Check session login token
		if (sessionLoginTokenFromPage != null
				&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;

			//String mobileNumber = objRequest.getParameter("varMobileNumber");
			String mobileNumber = objSession.getAttribute("PatmobileNumber").toString();
			
			String userOtp = objRequest.getParameter("varOtp");
			
			// Step 3: Validate OTP if provided
			if (userOtp != null && !userOtp.trim().isEmpty()) {
				//System.out.println("userOtp>>> " + userOtp);				
				int otpStatus = LoginUTL.mValidateOtp(mobileNumber, userOtp, objRequest);
				//System.out.println("otpStatus>>>" + otpStatus); 

				switch (otpStatus) {
				case 1:
					
					String res = LoginUTL.mloginUserFinal(this, objRequest, objResponse, mobileNumber);
					
					
					if ("1".equals(res)) {
						
						return PAGE_HIS_LOGIN_DESK;
					} else if ("2".equals(res)) {
						return PAGE_HIS_SEAT;
					} else {

						String errorMsg = "Invalid User Name or Password !";
						
						if (res.split("#")[0].equals("3"))
							errorMsg = res.split("#")[1];
						
						LoginUTL.setInititals(this, objRequest, objResponse);
						objRequest.setAttribute("error", errorMsg);
						return PAGE_HIS_CGHS_LOGIN;
					}

				case 2:
					
					objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");

					// this.addActionMessage("Invalid OTP. Please try again."); 
					return PAGE_HIS_CGHS_LOGIN;

				case 3:
					
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
				//	 this.addActionMessage("OTP has expired. Please request a new one."); 
					return PAGE_HIS_CGHS_LOGIN;

				default:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
			//		 this.addActionMessage("An unknown error occurred while validating OTP."); 
					return PAGE_HIS_CGHS_LOGIN;
				}
			} else {
				objSession.setAttribute("LoginError", "OTP is required!");
				 this.addActionMessage("OTP is required!"); 
				return PAGE_HIS_CGHS_LOGIN;
			}

		} else {

			objRequest.setAttribute("message", "Not a Valid Request !");
			// objSession.setAttribute("LoginError", "Kindly refresh the page.");

			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;
		}

	}
	

	public String beneficiarylogin() throws Exception {							// Validate OTP from BEN user login

		//System.out.println("Inside by beneficiarylogin validate OTP");

		HttpSession objSession = objRequest.getSession();

		

		String mobileNumber = objRequest.getParameter("varMobileNumber");
		String sessionLoginTokenFromPage = objRequest.getParameter("sessionLoginToken");
		String userOtp = objRequest.getParameter("varOtp");

		// Step 1: Check session login token
		if (sessionLoginTokenFromPage != null
				&& sessionLoginTokenFromPage.equals(objSession.getAttribute("sessionLoginToken"))) {
			objSession.setAttribute("sessionLoginToken", "");
			this.sessionLoginToken = null;
			//System.out.println("userOTP>>> "+ userOtp);
			// Step 3: Validate OTP if provided
			if (userOtp != null && !userOtp.trim().isEmpty()) {
				//System.out.println("userOtp>>> " + userOtp);
				int otpStatus = LoginUTL.mValidateOtpForBen(mobileNumber, userOtp, objRequest);
				//System.out.println("otpStatus>>>" + otpStatus);

				switch (otpStatus) {
				case 1:

					String res = LoginUTL.mloginBenFinal(this, objRequest, objResponse, mobileNumber);

					if ("1".equals(res)) {
						return PAGE_HIS_LOGIN_DESK;
					} else {
 
						String errorMsg = "Invalid User Name or Password !";

						if (res.split("#")[0].equals("3"))
							errorMsg = res.split("#")[1];

						LoginUTL.setInititals(this, objRequest, objResponse);
						objRequest.setAttribute("error", errorMsg);
						
						return PAGE_HIS_BEN_LOGIN;
					}

				case 2:
					objSession.setAttribute("LoginError", "Invalid OTP. Please try again.");

					/* this.addActionMessage("Invalid OTP. Please try again."); */
					return PAGE_HIS_BEN_LOGIN;

				case 3:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("OTP has expired. Please request a new one."); */
					return PAGE_HIS_BEN_LOGIN;

				default:
					objSession.setAttribute("LoginError", "OTP has expired. Please request a new one.");
					/* this.addActionMessage("An unknown error occurred while validating OTP."); */
					return PAGE_HIS_BEN_LOGIN;
				}
			} else {
				objSession.setAttribute("LoginError", "OTP is required!");
				/* this.addActionMessage("OTP is required!"); */
				return PAGE_HIS_BEN_LOGIN;
			}

		} else {

			objRequest.setAttribute("message", "Not a Valid Request !");
			// objSession.setAttribute("LoginError", "Kindly refresh the page.");
			
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;
		}

	}
	
	
	


	
	
}
