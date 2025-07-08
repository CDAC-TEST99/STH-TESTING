package hislogin.transactions.actionsupport;

import hisglobal.config.HISConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.action.ServletRequestAware;
import org.apache.struts2.action.ServletResponseAware;
import org.apache.struts2.action.SessionAware;
import org.apache.struts2.action.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class UserDeskSUP extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1L;

	protected HttpServletRequest objRequest;
	protected HttpServletResponse objResponse;

	protected String varUserName;
	protected String varUsrName;
	protected String varSSOTicketGrantingTicket;
	protected String varOldPassword;

	protected String varIsFirstTimeLogin;
	protected String varCurrentDate;
	protected String varDefaultMenuURL;
	protected String varDefaultMenuName;
	protected String varDefaultMenuModule;
	
	protected String varUserChoiceURL;
	protected String varUserChoiceMenu;
	protected String varManualFileName;//Added by Anjali
	protected String varManualFileURL;//Added by Anjali
	protected String varManualUploadDate;//Added by Anjali
	protected String varIsAutoRefresh;
	protected String varMenuAssigned;
	
	protected String varUserId; //Added by Deepti
	protected String  varUserSeatId; //Added by Deepti
	
	protected String varUserType; //Added by Deepti
	
	public String getVarUserId() {//Added by Deepti
		return varUserId;
	}

	public void setVarUserId(String varUserId) {//Added by Deepti
		this.varUserId = varUserId;
	}
	
	public String getVarUserSeatId() {//Added by Deepti
		return varUserId;
	}

	public void setVarUserSeatId(String varUserId) {//Added by Deepti
		this.varUserId = varUserId;
	}

	public String getVarManualUploadDate() {//Added by Anjali
		return varManualUploadDate;
	}

	public void setVarManualUploadDate(String varManualUploadDate) {//Added by Anjali
		this.varManualUploadDate = varManualUploadDate;
	}


	public String getVarManualFileURL() {//Added by Anjali
		return varManualFileURL;
	}

	public void setVarManualFileURL(String varManualFileURL) {//Added by Anjali
		this.varManualFileURL = varManualFileURL;
	}

	public String getVarManualFileName() {//Added by Anjali
		return varManualFileName;
	}

	public void setVarManualFileName(String varManualFileName) {//Added by Anjali
		this.varManualFileName = varManualFileName;
	}

	public UserDeskSUP()
	{
		varUserName = "";
		varUsrName = "";
		varSSOTicketGrantingTicket = "";
		varIsFirstTimeLogin = HISConfig.NO;
		varCurrentDate = "";
		varDefaultMenuURL = "";
		varDefaultMenuModule="";
		varManualFileName="";//Added by Anjali
		varManualUploadDate="";//Added by  Anjali
	}

	public void clear()
	{
		varUserName = "";
		varUsrName = "";
		varSSOTicketGrantingTicket = "";
		varIsFirstTimeLogin = HISConfig.NO;
		varCurrentDate = "";
		varDefaultMenuURL = "";
		varDefaultMenuModule="";
		varManualFileName="";//Added by Anjali
		varManualUploadDate="";//Added by  Anjali
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

	public String getVarSSOTicketGrantingTicket()
	{
		return varSSOTicketGrantingTicket;
	}

	public void setVarSSOTicketGrantingTicket(String varSSOTicketGrantingTicket)
	{
		this.varSSOTicketGrantingTicket = varSSOTicketGrantingTicket;
	}

	/*
	 * @Override public CountryModel getModel() {
	 * System.out.println("Inside CountryAction ::: getModel()"); return
	 * modelCountry; }
	 */

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
    

	public String getVarUsrName()
	{
		return varUsrName;
	}

	public void setVarUsrName(String varUsrName)
	{
		this.varUsrName = varUsrName;
	}

	public String getVarIsFirstTimeLogin()
	{
		return varIsFirstTimeLogin;
	}

	public void setVarIsFirstTimeLogin(String varIsFirstTimeLogin)
	{
		this.varIsFirstTimeLogin = varIsFirstTimeLogin;
	}

	public String getVarDefaultMenuURL()
	{
		return varDefaultMenuURL;
	}

	public void setVarDefaultMenuURL(String varDefaultMenuURL)
	{
		this.varDefaultMenuURL = varDefaultMenuURL;
	}

	public String getVarOldPassword() {
		return varOldPassword;
	}

	public void setVarOldPassword(String varOldPassword) {
		this.varOldPassword = varOldPassword;
	}

	public String getVarCurrentDate()
	{
		return varCurrentDate;
	}

	public void setVarCurrentDate(String varCurrentDate)
	{
		this.varCurrentDate = varCurrentDate;
	}

	public String getVarUserChoiceURL() {
		return varUserChoiceURL;
	}

	public void setVarUserChoiceURL(String varUserChoiceURL) {
		this.varUserChoiceURL = varUserChoiceURL;
	}

	public String getVarUserChoiceMenu() {
		return varUserChoiceMenu;
	}

	public void setVarUserChoiceMenu(String varUserChoiceMenu) {
		this.varUserChoiceMenu = varUserChoiceMenu;
	}

	public String getVarDefaultMenuModule() {
		return varDefaultMenuModule;
	}

	public void setVarDefaultMenuModule(String varDefaultMenuModule) {
		this.varDefaultMenuModule = varDefaultMenuModule;
	}

	public String getVarDefaultMenuName() {
		return varDefaultMenuName;
	}

	public void setVarDefaultMenuName(String varDefaultMenuName) {
		this.varDefaultMenuName = varDefaultMenuName;
	}

	public String getVarIsAutoRefresh() {
		return varIsAutoRefresh;
	}

	public void setVarIsAutoRefresh(String varIsAutoRefresh) {
		this.varIsAutoRefresh = varIsAutoRefresh;
	}
	public String getVarMenuAssigned() {
		return varMenuAssigned;
	}

	public void setVarMenuAssigned(String varMenuAssigned) {
		this.varMenuAssigned = varMenuAssigned;
	}

	public String getVarUserType() {
		return varUserType;
	}

	public void setVarUserType(String varUserType) {
		this.varUserType = varUserType;
	}
	
	
	
}
