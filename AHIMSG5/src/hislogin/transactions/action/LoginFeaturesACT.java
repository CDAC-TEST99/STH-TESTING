package hislogin.transactions.action;


 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.rowset.WebRowSet;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.opensymphony.xwork2.Action;

import hisglobal.config.SaveFileInFtpGlobal;
import hisglobal.exceptions.old.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import hisglobal.utility.HtmlToPdf;
import hisglobal.utility.SMSServices;
import hisglobal.utility.SMSSender.config.SMSConfig;
import hisglobal.utility.helper.DateHelperMethods;
import hislogin.transactions.actionsupport.LoginFeatureSUP;
import hislogin.transactions.utl.LoginFeaturesUTL;
import hislogin.transactions.utl.XORUtil;
import hissso.config.HISSSOConfig;
import hissso.controller.util.LoginUTL;
import vo.usermgmt.UserMasterVO;

public class LoginFeaturesACT extends LoginFeatureSUP {
	private static final long serialVersionUID = 0L;
	private static final String PAGE_HIS_LOGIN_FORGET_PASSWORD = "FORGETPASSWORD";
	private static final String PAGE_HIS_LOGIN_FIRST_LOGIN = "FIRSTLOGIN";
	private static final String PAGE_HIS_LOGIN_CHANGE_PASSWORD = "CHANGEPASSWORD";
	private static final String PAGE_HIS_LOGIN_CHANGE_USER_DETAILS = "CHANGEUSERDETAILS";
	private static final String PAGE_HIS_LOGIN_ADD_UPDATE_MOBILE_NO = "ADDUPDATEMOBILENO";
	private static final String PAGE_HIS_USER_LOG_DETAILS = "USERLOGDETAILS";

	private static final String PAGE_NEW_HOSP_REG = "NEWHOSPREG";

	private static final String PAGE_NEW_CONTACT_US = "NEWCONTACTUS";

	private static final String PAGE_NEW_TRAIL = "NEWTRAIL";

	private static final Map<String , String> emailOTPMap = new HashMap<String , String>();
	
	private static final ConcurrentMap<String, AtomicInteger> hitCounts = new ConcurrentHashMap<>();
	
	public String execute() throws Exception {
		return null;
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mode = request.getParameter("mode");

		if (mode.equalsIgnoreCase("SENDOTP")) {
			// SENDOPT(request, response);
		} else if (mode.equalsIgnoreCase("SENDOTP1")) {
			// SENDOPT1(request, response);
		} else if (mode.equalsIgnoreCase("EXPIREOTP")) {
			// EXPIREOTP(request, response);
		} else if (mode.equalsIgnoreCase("VALIDATEOTP")) {
			// VALIDATEOTP(request, response);
		} //
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mode = request.getParameter("mode");
		if (mode == null) {
			// getPDFdeatils(request, response);
		}
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		processRequest(request, response);
	}

	public void SENDOTPFgtPwd() throws ServletException, IOException {
		System.out.println("inside");

		try {
			String varNewMobileNo;
			//varNewMobileNo = objRequest.getParameter("varNewMobileNumber");
		// String varEmailId= objRequest.getParameter("varEmailId");
			//System.out.println("varEmailId"+varEmailId);
			
			String otp = LoginFeaturesUTL.getOTP();
			
			// String otp="12345678";
			// String msg="Your OTP for booking an appointment is "+otp;
			String msg = "OTP is " + otp;
			System.out.println(msg);
			System.out.println("OTP:- " + otp);

		//	LoginFeaturesUTL.saveRegOTP(this, objRequest, objResponse, otp);

			String emailId = objRequest.getParameter("emailId") ;
			
			emailOTPMap.put(emailId, otp + "," + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
			 
			 
			/*
			 * LoginFeaturesUTL.addOtpToValidationMap(varNewMobileNo, otp); SMSConfig
			 * objSMSConfig = new SMSConfig();
			 * 
			 * // for sending OTP through SMS String smsDtls =
			 * HisUtil.getConfigParamValue("1", "100", "SMS_CONFIG");
			 * 
			 * String smsDtlVals[] = smsDtls.split("\\$");
			 * System.out.println("smsDtlVals[0]::" + smsDtlVals[0]);
			 * System.out.println("smsDtlVals[1]::" + smsDtlVals[1]);
			 * System.out.println("smsDtlVals[2]::" + smsDtlVals[2]);
			 * SMSServices.sendBulkSMS(smsDtlVals[0], smsDtlVals[1],
			 * "OTP to reset Password- " + otp +
			 * ". For security reasons, DONOT share this OTP with anyone. \n----------------\nDepartment of Health and Family Welfare , Andhra Pradesh"
			 * , smsDtlVals[2], varNewMobileNo, "5689f049-40ee-444b-9a73-3d1a6e13cdda");
			 */

			// SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
			// objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
			// patContactNo, msg);
			// SMSGateway.sendSingleSMSThroughSMSGateway(RegistrationConfig.smsusername,
			// RegistrationConfig.smspassword, RegistrationConfig.smssenderid,
			// patContactNo, msg);
			String status = emailId;
			PrintWriter writerObj = objResponse.getWriter();
			writerObj.write(status);
			HttpSession sess = objRequest.getSession();
			//sess.setAttribute("varNewMobileNo", varNewMobileNo);
			sess.setAttribute("varEmailId", emailId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void EXPIREOTPFgtPwd() throws ServletException, IOException {

		// System.out.println("Inside the SENDOTP");
		ResultSet rs = null;
		Connection dbc = null;
		HisDAO ob = new HisDAO("PreRegistrationSERVLET", "EXPIREOTP()");
		try {
			/*
			 * dbc=ob.co stmt=dbc.createStatement();
			 */
			String varNewMobileNo, otp;
			varNewMobileNo = objRequest.getParameter("varNewMobileNumber");

			otp = objRequest.getParameter("otp");
			String status = Integer.toString(LoginFeaturesUTL.getexpireotpajax(varNewMobileNo, otp));

			PrintWriter writerObj = objResponse.getWriter();
			writerObj.write(status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VALIDATEOTPFgtPwd() throws ServletException, IOException {

		ResultSet rs = null;
		Connection dbc = null;
		HisDAO ob = new HisDAO("PreRegistrationSERVLET", "SENDOPT()");
		try {
			/*
			 * dbc=ob.co stmt=dbc.createStatement();
			 */
			String varNewMobileNo, otp,emailId;
			//varNewMobileNo = objRequest.getParameter("varNewMobileNumber");// patContactNo
			emailId = objRequest.getParameter("emailId");// patContactNo
			otp = objRequest.getParameter("otp");
			System.out.println("emailId"+emailId+"otp"+otp);
			//String status = Integer.toString(LoginFeaturesUTL.getOTPValidationStatus(varNewMobileNo, otp));
			String status = Integer.toString(getOTPValidationStatusEmail(emailId, otp));
			/*
			 * System.out.println("status-> " + new
			 * Sim
			 * 
			 * pleDateFormat("ssmm")+"#"+status+"@"+new SimpleDateFormat("ssmm"));
			 */
			
			//status=status+"@"+new SimpleDateFormat("ssmm");
			//status=status.split("@")[0];
			System.out.println("statuskkhjk-> " +status);
			
			
			PrintWriter writerObj = objResponse.getWriter();
			status = Base64.getEncoder().encodeToString(new String(status+","+new Date()).getBytes());
			//writerObj.write(status+new SimpleDateFormat("HHmmss").format(new Date()));
			writerObj.write(status);
			
			
		

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static int getOTPValidationStatusEmail(String emailId, String otp){
		int status=2;
		
		System.out.println("emailId"+emailId+"otp"+otp);
		
		String correctOTP=emailOTPMap.get(emailId);
		
		// otpString = emailOTPMap.get(toEmailAddress);
		System.out.println("correctOTP=====>>>"+correctOTP);
		if(correctOTP==null)
			status=3; // otp has expired
		else if(correctOTP.split(",")[0].equalsIgnoreCase(otp))
			status=1; // otp is valid
		
		else 
			status=2; // otp is invalid*/
		
		System.out.println("status"+status);
		 
		return status;
	}
	

	public void CHECKLOGINID() throws ServletException, IOException {
//System.out.println("CHECKLOGINID");
		HisDAO hisdao = new HisDAO("LabRptRegistrationServlet", "CHECKCRNO()");
		int nIndex;
		String status;
		String status1;
		String status2;
		WebRowSet wb = null;
		HttpSession sess = objRequest.getSession(false);

		try {
			String loginID, patContactNo, ContactNo;
			loginID = objRequest.getParameter("varUserName").toString();
			// System.out.println("crNo::CHECKCRNO");
			String query = "Select count(*) from UMMT_USER_MST  where GSTR_LOGIN_ID= '" + loginID + "'";
			nIndex = hisdao.setQuery(query);
			wb = hisdao.executeQry(nIndex);
			// System.out.println("patientCountQuery===" + query);
			String mobNo = "";
			String emailId = "";
			while (wb.next()) {
				status1 = wb.getString(1).toString();
				LoginFeaturesUTL abc = new LoginFeaturesUTL();
				mobNo = LoginFeaturesUTL.CheckLoginID(loginID);

				status = status1 + "#" + mobNo;
				System.out.println("status"+status);
				objResponse.getWriter().write(status);
				PrintWriter writerObj = objResponse.getWriter();
				HttpSession sess1 = objRequest.getSession();
				sess1.setAttribute("varUserName", loginID);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SENDOTP() throws ServletException, IOException {

		try {
			String varNewMobileNo;
			varNewMobileNo = objRequest.getParameter("varNewMobileNumber");
			String otp = LoginFeaturesUTL.getOTP();
			// String otp="12345678";
			// String msg="Your OTP for booking an appointment is "+otp;
			String msg = "OTP is " + otp;
			System.out.println(msg);
			System.out.println("OTP:- " + otp);
			LoginFeaturesUTL.addOtpToValidationMap(varNewMobileNo, otp);
			SMSConfig objSMSConfig = new SMSConfig();

			// for sending OTP through SMS
			String smsDtls = HisUtil.getConfigParamValue("1", "100", "SMS_CONFIG");

			String smsDtlVals[] = smsDtls.split("\\$");
			System.out.println("smsDtlVals[0]::" + smsDtlVals[0]);
			System.out.println("smsDtlVals[1]::" + smsDtlVals[1]);
			System.out.println("smsDtlVals[2]::" + smsDtlVals[2]);
			SMSServices.sendBulkSMS(smsDtlVals[0], smsDtlVals[1], "OTP to update Mobile No.- " + otp
					+ ". For security reasons, DONOT share this OTP with anyone. \n----------------\nDepartment of Health and Family Welfare , Arunachal Pradesh",
					smsDtlVals[2], varNewMobileNo, "5689f049-40ee-444b-9a73-3d1a6e13cdda");

			// SMSHttpPostClient.sendSingleSMSThroughSMSGateway(objSMSConfig.sms_username,
			// objSMSConfig.sms_password,objSMSConfig.sms_senderId,objSMSConfig.sms_url,
			// patContactNo, msg);
			// SMSGateway.sendSingleSMSThroughSMSGateway(RegistrationConfig.smsusername,
			// RegistrationConfig.smspassword, RegistrationConfig.smssenderid,
			// patContactNo, msg);
			String status = varNewMobileNo;
			PrintWriter writerObj = objResponse.getWriter();
			writerObj.write(status);
			HttpSession sess = objRequest.getSession();
			sess.setAttribute("varNewMobileNo", varNewMobileNo);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void EXPIREOTP() throws ServletException, IOException {

		// System.out.println("Inside the SENDOTP");
		ResultSet rs = null;
		Connection dbc = null;
		HisDAO ob = new HisDAO("PreRegistrationSERVLET", "EXPIREOTP()");
		try {
			/*
			 * dbc=ob.co stmt=dbc.createStatement();
			 */
			String varNewMobileNo, otp;
			varNewMobileNo = objRequest.getParameter("varNewMobileNumber");

			otp = objRequest.getParameter("otp");
			String status = Integer.toString(LoginFeaturesUTL.getexpireotpajax(varNewMobileNo, otp));

			PrintWriter writerObj = objResponse.getWriter();
			writerObj.write(status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void VALIDATEOTP() throws ServletException, IOException {

		ResultSet rs = null;
		Connection dbc = null;
		HisDAO ob = new HisDAO("PreRegistrationSERVLET", "SENDOPT()");
		try {
			/*
			 * dbc=ob.co stmt=dbc.createStatement();
			 */
			String varNewMobileNo, otp;
			varNewMobileNo = objRequest.getParameter("varNewMobileNumber");// patContactNo
			otp = objRequest.getParameter("otp");
			String status = Integer.toString(LoginFeaturesUTL.getOTPValidationStatus(varNewMobileNo, otp));

			PrintWriter writerObj = objResponse.getWriter();
			writerObj.write(status);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Initializing Forgot Password Session
	public String initForgetPassword() throws Exception {
		LoginFeaturesUTL.initForgotPassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_FORGET_PASSWORD;
	}

	public String validateForgetPassword() throws Exception {
		System.out.println("validatepassword>>action");
		LoginFeaturesUTL.validateForgotPassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_FORGET_PASSWORD;
	}

	public String saveForgetPassword() throws Exception {
		System.out.println("savepassword>>action");
		LoginFeaturesUTL.saveForgotPassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_FORGET_PASSWORD;
	}

	public String initFirstLogin() throws Exception {
		LoginFeaturesUTL.initFirstLogin(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_FIRST_LOGIN;
	}

	public String saveFirstLogin() throws Exception {
		LoginFeaturesUTL.saveFirstLogin(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_FIRST_LOGIN;
	}

	public String initChangePassword() throws Exception {
		System.out.println("in initChangePassword >>> ");
		LoginFeaturesUTL.initChangePassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
	}

	public String saveChangePassword() throws Exception {
		HttpSession objSession = null;
		objSession = objRequest.getSession();

		String parm = this.getCaptchaResponse_passwordChange();
		if (parm == null) {
			addActionError("Captcha is Empty! Please enter captcha!");
			return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
		}
		String c = (String) objSession.getAttribute("PASSWORD_CAPTCHA_KEY");
		if (!parm.equals(c)) {
			LoginFeaturesUTL.initChangePassword(this, objRequest, objResponse);
			addActionError("Invalid Captcha! Please try again!");
			return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
		}
		LoginFeaturesUTL.saveChangePassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
	}

	public String initChangeUserDetails() throws Exception {
		System.out.println("scdsds");
		LoginFeaturesUTL.initChangeUserDetails(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_CHANGE_USER_DETAILS;
	}

	public String validateChangeUserDetails() throws Exception {
		
		HttpSession objSession = null;
		objSession = objRequest.getSession();
		String parm = this.getCaptchaResponse_passwordChange();
		if (parm == null) {
			addActionError("Captcha is Empty! Please enter captcha!");
			return PAGE_HIS_LOGIN_CHANGE_USER_DETAILS;
		}
		String c = (String) objSession.getAttribute("PASSWORD_CAPTCHA_KEY");
		if (!parm.equals(c)) {
			LoginFeaturesUTL.initChangeUserDetails(this, objRequest, objResponse);
			addActionError("Invalid Captcha! Please try again!");
			return PAGE_HIS_LOGIN_CHANGE_USER_DETAILS;
		}
		
		LoginFeaturesUTL.validatePassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_CHANGE_USER_DETAILS;
	}

	public String saveChangeUserDetails() throws Exception {
		LoginFeaturesUTL.saveChangeUserDetails(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_CHANGE_USER_DETAILS;
	}

	/*
	 * Added by Anjali- 12-10-2020- to update Mobile No for Forgot Password
	 * functionality
	 */
	public String initAddUpdateMobileNo() throws Exception {
		System.out.println("scdsds");
		LoginFeaturesUTL.initAddUpdateMobileNo(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_ADD_UPDATE_MOBILE_NO;
	}

	public String validateAddUpdateMobileNo() throws Exception {
		LoginFeaturesUTL.validateAddUpdatePassword(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_ADD_UPDATE_MOBILE_NO;
	}

	public String saveAddUpdateMobileNo() throws Exception {
		LoginFeaturesUTL.saveAddUpdateMobileNo(this, objRequest, objResponse);
		return PAGE_HIS_LOGIN_ADD_UPDATE_MOBILE_NO;
	}

	public void getManualList() {
		LoginFeaturesUTL.getManualList(objRequest, objResponse);// Added by Anjali
	}

	public void getMenuList() {
		LoginFeaturesUTL.getMenuList(objRequest, objResponse);
	}

	public String initUserLogDetails() throws Exception {
		LoginFeaturesUTL.inituserLogDetails(this, objRequest, objResponse, null, null);
		return PAGE_HIS_USER_LOG_DETAILS;
	}

	public String allUserLogDetails() throws Exception {

		HttpSession objSession = objRequest.getSession();
		Date objSysDate = (Date) objSession.getAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_OBJECT);
		frDate = DateHelperMethods.getDateString(objSysDate, "dd-MMM-yyyy");
		toDate = DateHelperMethods.getDateString(objSysDate, "dd-MMM-yyyy");
		System.out.println("in act fdate" + frDate + " " + toDate);
		LoginFeaturesUTL.allUserLogDetails(this, objRequest, objResponse, frDate, toDate);

		return PAGE_HIS_USER_LOG_DETAILS;
	}

	public String datewiseUserLogDetails() throws Exception { // System.out.println("in datewise act fdate"+frDate+"
																// "+toDate);
		LoginFeaturesUTL.datewiseUserLogDetails(this, objRequest, objResponse, frDate, toDate);
		// System.out.println("in datewise act fdate 2"+frDate+" "+toDate);
		return PAGE_HIS_USER_LOG_DETAILS;
	}

	// Added By Deepti for STH 05.06.2020
	public String captcha() throws ServletException, IOException {
		// System.out.println("inside captcha method of login ftr act");
		LoginFeaturesUTL.setCaptcha(this, objRequest, objResponse);
		return null;
	}

	public String newContactUsModal() throws Exception {

		LoginFeaturesUTL.getHospitalRegTypeList(this, objRequest, objResponse);

		return PAGE_NEW_CONTACT_US;
	}

	public String newTrailRequestModal() throws Exception {

		LoginFeaturesUTL.getHospitalRegTypeList(this, objRequest, objResponse);

		return PAGE_NEW_TRAIL;
	}

	public String saveContactUs() throws Exception {
		System.out.println("1+++++");
		String regId = "";

		regId = LoginFeaturesUTL.saveContactUs(this, objRequest, objResponse);

		PrintWriter out = objResponse.getWriter();
		out.write(regId);

		return null;

	}

	public String saveTrailRequest() throws Exception {
		System.out.println("1+++++>>");
		String regId = "";
		regId = LoginFeaturesUTL.saveTrailRequest(this, objRequest, objResponse);

		PrintWriter out = objResponse.getWriter();
		out.write(regId);

		return null;

	}

	public String newHospitalRegModal() throws Exception {

		LoginFeaturesUTL.getStateList(this, objRequest, objResponse);
		LoginFeaturesUTL.getHospitalRegTypeList(this, objRequest, objResponse);

		return PAGE_NEW_HOSP_REG;
	}

	public String getDistrictList() throws Exception {
		PrintWriter out = objResponse.getWriter();
		out.write(LoginFeaturesUTL.getDistrictList(this, objRequest, objResponse));
		return null;
	}

	public String getPatientHandlingCharge() throws Exception {
		PrintWriter out = objResponse.getWriter();
		out.write(LoginFeaturesUTL.getPatHandleRateList(this, objRequest, objResponse));
		return null;
	}

	public void genOTP() throws Exception {
	
		   int count = getOTPCount();
		   
		   if (count < 4) {
		   
		    String otp= new DecimalFormat("000000").format(new Random().nextInt(999999));
		System.out.println("otp"+otp);
		  String varCUserId = objRequest.getParameter("varCUserId");
		    String varCHospCode = objRequest.getParameter("varCHospCode");
		    String varCUserName = objRequest.getParameter("varCUserName");
		    String emailType="otp";
 
		LoginFeaturesUTL.saveRegOTP(this, objRequest, objResponse, otp);
		LoginFeaturesUTL.addCountForOTP(this, objRequest, objResponse, emailType, varCUserId,varCHospCode,varCUserName);
		
		String emailId = objRequest.getParameter("emailId") ;
		emailOTPMap.put(emailId, otp + "," + new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date()));
		 		
		objResponse.getWriter().write("");
		   }
		else {
			objResponse.getWriter().write("Maximum Email Reached; Try Again After 20 Min");
	    }
		 
	}
	
	public int addCountForOTP() throws Exception {
		
		int count=0;
		  String varCUserId = objRequest.getParameter("varCUserId");
		    String varCHospCode = objRequest.getParameter("varCHospCode");
		    String varCUserName = objRequest.getParameter("varCUserName");
		    String emailType="OTP";
		     

		LoginFeaturesUTL.addCountForOTP(this, objRequest, objResponse, emailType, varCUserId,varCHospCode,varCUserName);	
		return count;

	}
	
	
public int getOTPCount() throws Exception {
		
	 int count = 0;
		  String varCUserId = objRequest.getParameter("varCUserId");
		    String varCHospCode = objRequest.getParameter("varCHospCode");
		 //   String varCUserName = objRequest.getParameter("varCUserName");
		    String emailType="OTP";
		     
		 
		LoginFeaturesUTL.getOTPCount(this, objRequest, objResponse, emailType, varCUserId,varCHospCode);
		
		 String countStr = LoginFeaturesUTL.getOTPCount(this, objRequest, objResponse, emailType, varCUserId, varCHospCode);
		    
		   
		    try {
		        count = Integer.parseInt(countStr);  
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		       
		    }
		return count;

	}

	
	 
	public String validateRegOTP() throws Exception {
		String otpString="";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		
		String res = "invalid";
		
		String toEmailAddress = objRequest.getParameter("emailId") ;
		String receivedOtp = objRequest.getParameter("otp");
		System.out.println("toEmailAddress"+toEmailAddress);
		System.out.println("receivedOtp"+receivedOtp);
		
	 	
		 otpString = emailOTPMap.get(toEmailAddress);
		 System.out.println("otpString==>> "+otpString);
	 	
		if(otpString != null) {
		
		
		String[] otpDetails = otpString.split(",");
		System.out.println("otpDetails"+otpDetails);
		System.out.println("otpDetailsval"+otpDetails[1]);
		System.out.println("otpDetailsvalzero"+otpDetails[0]);
		System.out.println("receivedOtp"+receivedOtp);

		try {

			Date otpDate = sdf.parse(otpDetails[1]);
			System.out.println("otpDate"+otpDate);

			long diff = new Date().getTime() - otpDate.getTime();
			System.out.println("diff"+diff);
			long diffMinutes = diff / (60 * 1000) % 60;
			System.out.println("diffMinutes"+diffMinutes);

			if (diffMinutes > 9) {
				
				System.out.println("INSIDE if >9");
				
				emailOTPMap.remove(toEmailAddress);
				
				res =  "invalid";
			} else {
				
				System.out.println("INSIDE else >9");

				if (receivedOtp.equals(otpDetails[0])) {
					
					System.out.println("INSIDE else ---> if ---->9");
					
					emailOTPMap.remove(toEmailAddress);
					
					res =  "valid";
				} else {
					
					System.out.println("INSIDE else ---> else ---->9");

					res =  "invalid";
				}

			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
		}
		// Encrypt the response using XOR
	    System.out.println("MYRESPONSE before encryption: " + res);
	    String encryptedResponse = XORUtil.xorEncrypt(res + "," + new Date());
	    System.out.println("MYRESPONSE after encryption: " + encryptedResponse);

	    // Sending the response back
	    PrintWriter out = ServletActionContext.getResponse().getWriter();
	    out.write(encryptedResponse);
	    return Action.NONE;
	        
		
	}

	public String saveHospitalRegistration() throws Exception {

		String regId = "";

		regId = LoginFeaturesUTL.saveHospitalRegistration(this, objRequest, objResponse);

		String formContent = getFormContent(this, regId);

		
		String osType = System.getProperties().getProperty("os.name");
		String filePath = "";
		if (osType.startsWith("Win")) {
			filePath = "C:/eSushrut_Clinic/FileHandling/downloaded/";
		} else {
			filePath = "/opt/eSushrut_Clinic/FileHandling/downloaded/";
		}
		
		  filePath = filePath  + regId + ".pdf";
		
		HtmlToPdf.convert(formContent, filePath);

		PrintWriter out = objResponse.getWriter();
		out.write(regId);

		return null;
	}

	private String getFormContent(LoginFeaturesACT loginFeaturesACT, String regId) {

		String p_hospital_name = objRequest.getParameter("hname");
		String p_hosp_short_name = objRequest.getParameter("hshortname");
		String p_hospital_add1 = objRequest.getParameter("haddress");
		String p_hospital_add2 = objRequest.getParameter("haddress2");
		String p_city = objRequest.getParameter("city");
		String p_dist_id = objRequest.getParameter("district");
		String p_state_code = objRequest.getParameter("state");
		String p_pin_code = objRequest.getParameter("pincode");
		String p_phone = objRequest.getParameter("phone");
		String p_fax = "-";
		String p_email = objRequest.getParameter("email");
		String p_contact_person = objRequest.getParameter("uname");
		//String p_payable_amount = objRequest.getParameter("hpatlimit").replace("^", "#").split("#")[1];
		//String p_pat_handle_id = objRequest.getParameter("hpatlimit").replace("^", "#").split("#")[0];
		//String p_hospital_type = objRequest.getParameter("htype");
		String p_gst_no = objRequest.getParameter("gst");

		String p_districtName = objRequest.getParameter("districtName");
		String p_stateName = objRequest.getParameter("stateName");
	//	String p_htypeName = objRequest.getParameter("htypeName");
		//String p_hpatlimitName = objRequest.getParameter("hpatlimitName");

		return "<html> " + "<body > " + "<center> "
				+ "<table width=\"85%\"   border=\"1\" style='border-collapse:collapse'  >  " + " <tbody> " + "  "
				+ "  <tr >  " + " " + "    <td colspan=\"4\"  ><center><h3>CGHS</h3></center></td> "
				+ "  </tr> " + "  " + " <tr >  " + " "
				+ "    <td colspan=\"4\"><h4>Institute Registration Details<h4></td> " + "  </tr> " + "  <tr>  "
				+ "    <td  width=\"25%\"> Institute Registration ID </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\"><b>" + regId + "</b>  " + "     " + "    </td> " + "    "
				+ "    <td  width=\"25%\"> Registration Date </td> " + "    <td class=\"CONTROL\" width=\"25%\">"
				+ new SimpleDateFormat("dd-MMM-yyyy HH:mm").format(new Date()) + " </td> " + "  </tr> " + "   "
				+ "   <tr>  "+ "   "
				+ "    <td  width=\"25%\"> GST No. </td> " + "    <td colspan=\"3\" class=\"CONTROL\" width=\"75%\">" + p_gst_no
				+ " </td> " + "  </tr> " + "   " + "  <tr>  " + "    <td  width=\"25%\"> Institute Name </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_hospital_name + " </td> " + "   "
				+ "    <td  width=\"25%\"> Institute Short Name </td> " + "    <td class=\"CONTROL\" width=\"25%\">"
				+ p_hosp_short_name + " </td> " + "  </tr> " + "   " + "  <tr>  "
				+ "    <td  width=\"25%\"> Institute Address Line 1 </td> " + "    <td class=\"CONTROL\" width=\"25%\">"
				+ p_hospital_add1 + " </td> " + "    " + "    <td  width=\"25%\"> Institute Address Line 2 </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_hospital_add2 + " </td> " + "  </tr> " + "   "
				+ "  <tr>  " + "    <td  width=\"25%\"> Pin Code </td> " + "    <td class=\"CONTROL\" width=\"25%\">"
				+ p_pin_code + " </td> " + "   " + "    <td  width=\"25%\"> City </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_city + " </td> " + "  </tr> " + "   " + "   <tr>  "
				+ "    <td  width=\"25%\"> District </td> " + "    <td class=\"CONTROL\" width=\"25%\">"
				+ p_districtName + " </td> " + "    " + "    <td  width=\"25%\"> State </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_stateName + " </td> " + "  </tr> " + "   " + "   "
				+ "   <tr>  " + "    <td  width=\"25%\"> Contact Person </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_contact_person + " </td> " + "    "
				+ "    <td  width=\"25%\"> Phone No. </td> " + "    <td class=\"CONTROL\" width=\"25%\">" + p_phone
				+ " </td> " + "  </tr> " + "   " + "   <tr>  " + "    <td  width=\"25%\"> Fax No. </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">" + p_fax + " </td> " + "    "
				+ "    <td  width=\"25%\"> Email </td> " + "    <td class=\"CONTROL\" width=\"25%\">" + p_email
				+ "</td> " + "  </tr> " + "   "   + "   " + "    " + "     " + "</tbody></table> " + " "
				+ "<br/> " + "<br/> " + " "
				+ "<table width='85%'    border=\"1\" style=\"border-collapse:collapse;height:80px;\"  >  "
				+ " <tbody> " + "  " + " <tr>  " + "    <td  width=\"25%\">  Signature  </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\"> ........................</td> " + "    "
				+ "    <td  width=\"25%\"> Date & Place </td> "
				+ "    <td class=\"CONTROL\" width=\"25%\">......................... </td> " + "  </tr> " + "     "
				+ "</tbody></table> " + "</center> " + "<body> </html>";

	}
	
	public String fetchCircularDetails() {
	   // System.out.println("Inside fetchCircularDetails");

	    String groupId = objRequest.getParameter("groupId");
	    String subGroupId = objRequest.getParameter("subGroupId");
	    
	   // System.out.println("Received groupId: " + groupId);
	    //System.out.println("Received subGroupId: " + subGroupId);
	    
	    if (groupId == null || groupId.trim().isEmpty()) {
	        System.out.println("Invalid groupId provided.");
	        objResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        try {
	            objResponse.getWriter().write("Invalid groupId");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    if (subGroupId == null || subGroupId.trim().isEmpty()) {
	        System.out.println("Invalid subGroupId provided.");
	        objResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        try {
	            objResponse.getWriter().write("Invalid subGroupId");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    JSONArray circularDetails = LoginFeaturesUTL.fetchCircularDetailsDTL(objRequest, objResponse, groupId, subGroupId);

	    try {
	        if (circularDetails != null && circularDetails.length() > 0) {
	           // System.out.println("Circular details fetched: " );
	            objResponse.setContentType("application/json");
	            objResponse.getWriter().write(circularDetails.toString());
	        } else {
	          //  System.out.println("No circulars found for groupId: " + groupId + " and subGroupId: " + subGroupId);
	            objResponse.setContentType("application/json");
	            objResponse.getWriter().write("[]");
	        }
	    } catch (IOException e) {
	        System.err.println("Error while writing response: " + e.getMessage());
	        e.printStackTrace();
	    }

	    return null;
	}
	
	   public String getHospitalsByCity() {
		    //  System.out.println("Inside getHospitalsByCityLgnFtr ");
		      String cityId = this.objRequest.getParameter("cityId");
		      if (cityId != null && !cityId.trim().isEmpty()) {
		         JSONObject hospitalDtl = LoginFeaturesUTL.getHospitalDTL(this.objRequest, this.objResponse, cityId);

		         try {
		            if (hospitalDtl != null && hospitalDtl.length() > 0) {
		               this.objResponse.setContentType("application/json");
		               this.objResponse.getWriter().write(hospitalDtl.toString());
		            } else {
		               this.objResponse.setContentType("application/json");
		               this.objResponse.getWriter().write("[]");
		            }
		         } catch (IOException var5) {
		            System.err.println("Error while writing response: " + var5.getMessage());
		            var5.printStackTrace();
		         }

		         return null;
		      } else {
		         System.out.println("Invalid cityId provided.");
		         this.objResponse.setStatus(400);

		         try {
		            this.objResponse.getWriter().write("Invalid cityId");
		         } catch (IOException var4) {
		            var4.printStackTrace();
		         }

		         return null;
		      }
		   }
	   
	   public String fetchWellnessCenterByCity() {
		    //  System.out.println("Inside getHospitalsByCityLgnFtr ");
		      String cityId = this.objRequest.getParameter("cityId");
		      if (cityId != null && !cityId.trim().isEmpty()) {
		         JSONObject hospitalDtl = LoginFeaturesUTL.fetchWellnessCenterByCityUTL(this.objRequest, this.objResponse, cityId);

		         try {
		            if (hospitalDtl != null && hospitalDtl.length() > 0) {
		               this.objResponse.setContentType("application/json");
		               this.objResponse.getWriter().write(hospitalDtl.toString());
		            } else {
		               this.objResponse.setContentType("application/json");
		               this.objResponse.getWriter().write("[]");
		            }
		         } catch (IOException var5) {
		            System.err.println("Error while writing response: " + var5.getMessage());
		            var5.printStackTrace();
		         }

		         return null;
		      } else {
		         System.out.println("Invalid cityId provided.");
		         this.objResponse.setStatus(400);

		         try {
		            this.objResponse.getWriter().write("Invalid cityId");
		         } catch (IOException var4) {
		            var4.printStackTrace();
		         }

		         return null;
		      }
		   }
	   		
		   public String getCityNames() {
		      JSONObject cityNamesDtl = LoginFeaturesUTL.getCityNamesDTL();

		      try {
		         if (cityNamesDtl != null && cityNamesDtl.length() > 0) {
		            this.objResponse.setContentType("application/json");
		            this.objResponse.getWriter().write(cityNamesDtl.toString());
		         } else {
		            this.objResponse.setContentType("application/json");
		            this.objResponse.getWriter().write("[]");
		         }
		      } catch (IOException var3) {
		        // System.err.println("Error while writing response: " + var3.getMessage());
		         var3.printStackTrace();
		      }

		      return null;
		   }
		   
		   public String restMedicineDetail() {
			    //  System.out.println("Inside getHospitalsByCityLgnFtr ");
			      String flag = this.objRequest.getParameter("flag");
			      if (flag != null && !flag.trim().isEmpty()) {
			         JSONObject hospitalDtl = LoginFeaturesUTL.restMedicineUTL(this.objRequest, this.objResponse, flag);

			         try {
			            if (hospitalDtl != null && hospitalDtl.length() > 0) {
			               this.objResponse.setContentType("application/json");
			               this.objResponse.getWriter().write(hospitalDtl.toString());
			            } else {
			               this.objResponse.setContentType("application/json");
			               this.objResponse.getWriter().write("[]");
			            }
			         } catch (IOException var5) {
			            System.err.println("Error while writing response: " + var5.getMessage());
			            var5.printStackTrace();
			         }

			         return null;
			      } else {
			         System.out.println("Invalid cityId provided.");
			         this.objResponse.setStatus(400);

			         try {
			            this.objResponse.getWriter().write("Invalid cityId");
			         } catch (IOException var4) {
			            var4.printStackTrace();
			         }

			         return null;
			      }
			   }
		   
		   
		   
		public String viewerHITCount() throws JSONException {
			    HttpServletRequest request = ServletActionContext.getRequest();
			    String urlPath = request.getRequestURI();
			    
			    String deviceType = isDeviceMobile(request);
			    String hitCount = "1";

			 //   System.out.println("urlPath::::::::::: \n" + urlPath + " | " + hitCount  + " | " +  deviceType   + " | " + request.getHeader("USER-AGENT"));

			    String hitResponse = null;
			    JSONObject getResponse = null;
			    String status = objRequest.getParameter("status");
			 //   System.out.println("status  "+ status);
						if (status.equals("1")) { 
						        // Optional: You might want to insert HIT count here if needed
						    	hitResponse = LoginFeaturesUTL.insertHITCount(urlPath, hitCount ,deviceType);
						         
						        // JSONObject jsonResponse = new JSONObject(hitResponse);
						         
						}

			        	 getResponse = LoginFeaturesUTL.getHITCount();
			        	 
			        	   try {
			  		         if (getResponse != null && getResponse.length() > 0) {
			  		            this.objResponse.setContentType("application/json");
			  		            this.objResponse.getWriter().write(getResponse.toString());
			  		         } else {
			  		            this.objResponse.setContentType("application/json");
			  		            this.objResponse.getWriter().write("[]");
			  		         }
			  		      } catch (IOException var3) {
			  		       //  System.err.println("Error while writing response: " + var3.getMessage());
			  		         var3.printStackTrace();
			  		      }
			        
			        
			    return null;
			   }
		   
			
			public static String isDeviceMobile(HttpServletRequest request) {
				String userAgent = request.getHeader("USER-AGENT");
				String deviceName ="Android|webOS|iPhone|iPad|BlackBerry|IEMobile|Opera Mini";
				Pattern pattern;
				Matcher matcher;
				
				pattern = Pattern.compile(deviceName);
			    matcher = pattern.matcher(userAgent);

				    if (matcher.find()) {
				        return "M";  // Mobile device detected
				    } else {
				        return "D";  // Desktop device
				    }
			}
		   
		 
}
	

