package hissso.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class HISSSOServerConfig extends HISSSOConfig
{
	// Configuration Settings
		// Secure Key Sizes
	public static int LOGIN_PASSWORD_HASH_BYTE_SIZE = 24;	// Good Size
	public static int LOGIN_SESSION_SALT_BYTE_SIZE = 24;	// Good Size
	
	public static int SSO_TICKET_EXPIRY_IN_SECONDS_TGT = 900;		// 5 Hours
	public static int SSO_TICKET_EXPIRY_IN_SECONDS_ST = 900;
	
		// Ticket Essentials
	//public static String SSO_LOGGEDIN_USERDESK_URL = "/hislogin/loadUserDesk.action";
	//Changed by Garima for extension change
	public static String SSO_LOGGEDIN_USERDESK_URL = "/hislogin/loadUserDesk";
	public static String SSO_ST_SERVICE_URL = "/HISSSO_STService";
	
	// Keys
		// For Login
	public static String LOGIN_SESSION_SALT = "keyLoginSessionSalt";
	public static String LOGIN_FEATURES_SESSION_SALT = "keyLoginFeaturesSessionSalt";

	public static String LOGIN_TAB_KEY = "keyLoginTab";
	
	public static String LOGIN_HOSPITAL_LIST_KEY = "keyLoginHospitalList";
	
	private static Set<String> setAllowedActionURIs;
	
	// Initializing HISSSO Configurations  
	public static void initializeSSOServer(ServletContext objContext)
	{
		// Set SSO TGT Register
		HISSSOSupport.initializeSSORegister(objContext);

		// Set Ticket Expiration From Context
		if(objContext.getInitParameter("SSO_TICKET_EXPIRATION_TGT_SECONDS")!=null)
			SSO_TICKET_EXPIRY_IN_SECONDS_TGT = Integer.parseInt(objContext.getInitParameter("SSO_TICKET_EXPIRATION_TGT_SECONDS"));

		if(objContext.getInitParameter("SSO_TICKET_EXPIRATION_ST_SECONDS")!=null)
			SSO_TICKET_EXPIRY_IN_SECONDS_ST = Integer.parseInt(objContext.getInitParameter("SSO_TICKET_EXPIRATION_ST_SECONDS"));
	
		// Set Service Ticket
		HISSSOSupport.initHISServiceObject(objContext);

		// Set Set of Allowed URIs (Patterns)
		setAllowedActionURIs = new HashSet<String>();
		//setAllowedActionURIs.add("/AHIMSG5/hissso/Login.action"); 
		//setAllowedActionURIs.add("/AHIMSG5/hissso/initLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/loginLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hislogin/[a-zA-Z]*ForgetPasswordLgnFtr.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/captchaLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hislogin/captchaLgnFtr.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/fileDownloadLogin.action");
		
		//Changed by Garima for extension change
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/Login"); 
		setAllowedActionURIs.add("/AHIMSG5/hissso/initLogin");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/portalLogin");
		
		// cghs employee login 
		setAllowedActionURIs.add("/AHIMSG5/hissso/cghsLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/loginLogin");
		
		// Portal Features
		setAllowedActionURIs.add("/AHIMSG5/hissso/empanelledLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/cghsWCLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/restMedicineLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/restMedicineDetailLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/downloadManualLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/getCityNamesLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/getHospitalsByCityLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/fetchWellnessCenterByCityLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/viewerHITCountLgnFtr");
		
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/mlogin"); 
		setAllowedActionURIs.add("/AHIMSG5/hissso/mloginLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/mloginValidateOtp");
		setAllowedActionURIs.add("/AHIMSG5/hissso/mloginValidateOtpLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/NewloginValidateOTP");
		setAllowedActionURIs.add("/AHIMSG5/hissso/NewloginValidateOTPLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/beneficiarylogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/beneficiaryloginLogin");
		
		// multi role login for cghs employees 
		setAllowedActionURIs.add("/AHIMSG5/hissso/roleLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/switchRoleLogin");

	
		// ben login with ben id 
		setAllowedActionURIs.add("/AHIMSG5/hissso/benLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/benloginLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/benLoginLogin");
		
		// ben (main card holder)  login with mobile number 
		setAllowedActionURIs.add("/AHIMSG5/hissso/mbenlogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/mbenloginLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/mbenloginValidateOtp");
		setAllowedActionURIs.add("/AHIMSG5/hissso/mbenloginValidateOtpLogin");
		 
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/changePasswordFirst");
		setAllowedActionURIs.add("/AHIMSG5/hissso/changePasswordFirstLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/changePasswordFirstBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/changePasswordFirstBenLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockben");
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockbenLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockbeneficiary");
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockbeneficiaryLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockBenvalidate");
		setAllowedActionURIs.add("/AHIMSG5/hissso/unlockBenvalidateLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPassword");
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/registerPasswordBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/registerPasswordBenLogin"); 
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/regPassBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/regPassBenLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/SaveBenPassword");
		setAllowedActionURIs.add("/AHIMSG5/hissso/SaveBenPasswordLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordBenLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/regPassBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/regPassBenLogin");  
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordOtpBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordOtpBenLogin");  
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/registerPasswordOtpBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/registerPasswordOtpBenLogin"); 
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordOtp");
		setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordOtpLogin");
		
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/resetPasswordBen");
		setAllowedActionURIs.add("/AHIMSG5/hissso/resetPasswordBenLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/resetPassword");
		setAllowedActionURIs.add("/AHIMSG5/hissso/resetPasswordLogin");
		
		setAllowedActionURIs.add("/AHIMSG5/hislogin/[a-zA-Z]*ForgetPasswordLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hissso/captchaLogin");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/captchaLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hissso/fileDownloadLogin");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/transactions/action/[a-zA-Z]*OTPFgtPwdLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/transactions/action/CHECKLOGINIDLgnFtr");
		
		setAllowedActionURIs.add("/AHIMSG5/hislogin/newHospitalRegModalLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/newContactUsModalLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/newTrailRequestModalLgnFtr");
		
		setAllowedActionURIs.add("/AHIMSG5/hislogin/getDistrictListLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/getPatientHandlingChargeLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/saveHospitalRegistrationLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/saveContactUsLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/saveTrailRequestLgnFtr");
		
		setAllowedActionURIs.add("/AHIMSG5/hislogin/genOTPLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/validateRegOTPLgnFtr");
		
		
		/*
		 * setAllowedActionURIs.add("/AHIMSG5/hissso/ClientSignIn");
		 * setAllowedActionURIs.add("/AHIMSG5/hissso/initClientSignIn");
		 * setAllowedActionURIs.add("/AHIMSG5/hissso/loginClientSignIn");
		 */
		setAllowedActionURIs.add("/AHIMSG5/hissso/constructionLogin");
		
		

		
		//setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordLogin.action");
	}

	// Check Allowed Request 
	public static boolean onServerCheckAllowedRequest(HttpServletRequest objRequest)
	{
		String strURI = objRequest.getRequestURI();
		for(String str : setAllowedActionURIs)
		{
			if(strURI.matches(str))
			{
				return true;
			}
		}
		return false;
	}

	// Authenticate Request 
	public static boolean onServerCheckAuthenticateRequest(HttpServletRequest objRequest)
	{
		return HISSSOSupport.onServerCheckAuthenticateRequest(objRequest);
	}

	// Call on Session SSO TGT Expiration 
	public static void onSessionExpiration(HttpSession objSession)
	{
		HISSSOSupport.onSSOTGTSessionExpiration(objSession);
	}
}
