package hissso.controller.actionsupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.action.ServletRequestAware;
import org.apache.struts2.action.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;




public abstract class LoginSUP extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1L;

	protected HttpServletRequest objRequest;
	protected HttpServletResponse objResponse;

	protected String varUserName;
	protected String varPassword;
	protected String varMobileNumber; 
	protected String varOtp;
	protected String varMobile;
	protected String varLanguage;
	protected String varSSOTicketGrantingTicket;
	protected String captchaResponse;
/*	 Added by sneha on 19/12/2019 */
	protected String varIPAddress;
	protected String desktopSystemInfo;
	protected String browserInfo;
//	protected String isPatient ;
	
	protected String varUserId;
	protected String varOldPassword;
	protected String varConfirmPassword;
		
	
	//Changes done by Garima for Security Token Issue on Login Page on 26th March 2018
	protected String sessionLoginToken;
	public String getSessionLoginToken() {
		return sessionLoginToken;
	}

	public void setSessionLoginToken(String sessionLoginToken) {
		this.sessionLoginToken = sessionLoginToken;
	}
	
	protected String cid;
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public LoginSUP()
	{
		varUserName = "";
		varPassword = "";
		varMobileNumber ="";
		varOtp="";
		varSSOTicketGrantingTicket = "";
	}

	public void clear()
	{
		varUserName = "";
		varPassword = "";
		varMobileNumber ="";
		varOtp="";
		varSSOTicketGrantingTicket = "";
	}

	public HttpServletRequest getObjRequest()
	{
		return objRequest;
	}

	public void setObjRequest(HttpServletRequest objRequest)
	{
		this.objRequest = objRequest;
	}

	public HttpServletResponse getObjResponse()
	{
		return objResponse;
	}

	public void setObjResponse(HttpServletResponse objResponse)
	{
		this.objResponse = objResponse;
	}

	public String getVarUserName()
	{
		return varUserName;
	}

	public void setVarUserName(String varUserName)
	{
		this.varUserName = varUserName;
	}

	public String getVarPassword()
	{
		return varPassword;
	}

	public void setVarPassword(String varPassword)
	{
		this.varPassword = varPassword;
	}
	public String varMobile()
	{
		return varMobile;
	}

	public void varMobile(String varMobile)
	{
		this.varMobile = varMobile;
	}
	/*----------------------------------Added by sneha on 19/12/2019-----------------------------*/
	
	public String getVarIPAddress() {
		return varIPAddress;
	}

	public void setVarIPAddress(String varIpAddress) {
		this.varIPAddress = varIpAddress;
	}
	/*--------------------------------------------------------------------------------------------*/
	/*
	 * @Override public CountryModel getModel() {
	 * System.out.println("Inside CountryAction ::: getModel()"); return
	 * modelCountry; }
	 */

	public String getVarLanguage() {
		return varLanguage;
	}

	public void setVarLanguage(String varLanguage) {
		this.varLanguage = varLanguage;
	}

	@Override
    public void withServletRequest(HttpServletRequest request)
    {
            this.objRequest = request;
    }

    @Override
    public void withServletResponse(HttpServletResponse response)
    {
            this.objResponse = response;
    }
    

	public String getVarSSOTicketGrantingTicket()
	{
		return varSSOTicketGrantingTicket;
	}

	public void setVarSSOTicketGrantingTicket(String varSSOTicketGrantingTicket)
	{
		this.varSSOTicketGrantingTicket = varSSOTicketGrantingTicket;
	}
	public String getCaptchaResponse()
	{
		return captchaResponse;
	}

	public void setCaptchaResponse(String captchaResponse)
	{
		this.captchaResponse = captchaResponse;
	}

	public String getDesktopSystemInfo() {
		return desktopSystemInfo;
	}

	public void setDesktopSystemInfo(String desktopSystemInfo) {
		this.desktopSystemInfo = desktopSystemInfo;
	}

	public String getBrowserInfo() {
		return browserInfo;
	}

	public void setBrowserInfo(String browserInfo) {
		this.browserInfo = browserInfo;
	}

	public String getVarOldPassword() {
		return varOldPassword;
	}

	public void setVarOldPassword(String varOldPassword) {
		this.varOldPassword = varOldPassword;
	}

	public String getVarConfirmPassword() {
		return varConfirmPassword;
	}

	public void setVarConfirmPassword(String varConfirmPassword) {
		this.varConfirmPassword = varConfirmPassword;
	}

	public String getVarUserId() {
		return varUserId;
	}

	public void setVarUserId(String varUserId) {
		this.varUserId = varUserId;
	}

	public String getVarMobileNumber() {
		return varMobileNumber;
	}

	public void setVarMobileNumber(String varMobileNumber) {
		this.varMobileNumber = varMobileNumber;
	}

	public String getVarOtp() {
		return varOtp;
	}

	public void setVarOtp(String varOtp) {
		this.varOtp = varOtp;
	}

	public String getVarMobile() {
		return varMobile;
	}

	public void setVarMobile(String varMobile) {
		this.varMobile = varMobile;
	}
	
	

}
