package hislogin.transactions.action;

import hislogin.transactions.actionsupport.UserDeskSUP;
import hisglobal.utility.HisUtil;
import hisglobal.vo.UserVO;
import vo.usermgmt.UserMasterVO;
import hislogin.transactions.utl.UserDeskUTL;
import hissso.config.HISSSOConfig;
import java.io.File;
import hisglobal.config.SaveFileInFtpGlobal;
import java.io.IOException;
import java.io.PrintWriter;



import java.io.BufferedReader;
import java.io.FileReader;
public class UserDeskACT extends UserDeskSUP
{
	private static final long serialVersionUID = 1L;
	private static final String PAGE_HIS_LOGIN_DESK = "SUCCESS";
	private static final String PAGE_HIS_LOGIN_DESK_CLIENT = "SUCCESS_CLENT";
	private static final String PAGE_HIS_SUCCESS_BENIFICIARY = "SUCCESS_BENIFICIARY";
	
	private static final String PAGE_HIS_ERROR = "ERROR";

	public String execute() throws Exception
	{
		return load();
	}

	@SuppressWarnings("unchecked")
	public String load() throws Exception
	{
		
		//String varUserType="Beneficiary";
		String varUserType="client";
		if(UserDeskUTL.setDeskInititals(this, objRequest, objResponse))
			if(varUserType.equals("Beneficiary"))
				return PAGE_HIS_SUCCESS_BENIFICIARY;
			else
				return PAGE_HIS_LOGIN_DESK_CLIENT;
		else
			return PAGE_HIS_ERROR;
	}
	
	@SuppressWarnings("unchecked")
	public String cashCollectionDtl() throws Exception
	{
		UserDeskUTL.fetchUserWiseCashCollected(this, objRequest, objResponse);
		return null;	
		
	}
	
	@SuppressWarnings("unchecked")
	public String getAlertDtl() throws Exception
	{
		//UserDeskUTL.getAlertDtls(this, objRequest, objResponse);
		return null;	
		
	}
	
	public String reloadCash() throws Exception
	{
		if(super.getObjRequest().getSession().getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL)!=null && super.getObjRequest().getSession().getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL).equals("1"))
		{
			//System.out.println("Inside the Cash Refresh");
			UserDeskUTL.reloadUserWiseCashCollected(this, objRequest, objResponse);
		}
		else
		{
			//System.out.println("No Cash Refresh Needed");
		}
	    return null;
	}
	
	public String refreshHome() throws Exception
	{		
		UserDeskUTL.refreshHomeTab(this,objRequest, objResponse);
		return null;
	}
	
	
	/*To dynamically generate manual list- Added by Anjali- 29-04-2020*/
	public String reloadManualDtl() throws Exception
	{		
		StringBuffer menuList = UserDeskUTL.generateManualList(objRequest.getSession());
		
		objResponse.setContentType("plain/text");	
		objResponse.setHeader("Cache-Control", "no-cache");
		
		if(menuList != null) {
			objResponse.getWriter().print(menuList.toString());
		}else {
			objResponse.getWriter().print("No Manual Aavaialble");
		}
		return null;
	}
	
	/*To dynamically inclide Hospital name & information on top of the manual*/
	public String hospitalHeader() throws Exception
	{
		UserMasterVO userVO = (UserMasterVO)objRequest.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);
		String hosCode =userVO.getVarHospitalCode();
		HisUtil hisUtil = new HisUtil("manual", "Modules");
		String uri = objRequest.getScheme() + "://" +objRequest.getServerName() + ("http".equals(objRequest.getScheme()) && objRequest.getServerPort() == 80 
	    		|| "https".equals(objRequest.getScheme()) && objRequest.getServerPort() == 443 ? "" : ":" + objRequest.getServerPort() );
		
		final String strHeader = hisUtil.getHospitalHeader2(hosCode, 1, "html",uri);
		objResponse.setContentType("plain/text");	
		objResponse.setHeader("Cache-Control", "no-cache");
		
		if(strHeader != null) {
			objResponse.getWriter().print(strHeader.toString());
		}else {
			objResponse.getWriter().print("No Header");
		}
		return null;
	}
	
	/*To read downloaded file's content- Added by Anjali- 29-04-2020*/
	private static String readFile(String filePath) 
    {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) 
        {
 
            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) 
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }
	
	/*To download manual from FTP- Added by Anjali- 29-04-2020*/
	public String downloadManual() throws Exception
	{
		UserMasterVO userVO = (UserMasterVO)objRequest.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);	
		String hosCode =userVO.getVarHospitalCode();
		File downFile=null;
		//System.out.println("hosCode= "+hosCode+" File Name="+varManualFileName);
		
		downFile=SaveFileInFtpGlobal.downloadFileFromLocation(hosCode, varManualFileName);
		String finalFile=readFile(downFile.toString());
		//System.out.println("finalFile-> "+finalFile);
		
		objResponse.setContentType("text/html");
		objResponse.setHeader("Cache-Control", "no-cache");
		
		if(finalFile != null) {
			objResponse.getWriter().print(finalFile);
		}else {
			objResponse.getWriter().print("No content");
		}
		//System.out.println(finalFile);
		return null;
		
	}
	
	// Added For getting High Priority Alert By Raj Kumar
		@SuppressWarnings("unchecked")
		public String getHighPriorityAlert() throws Exception
		{
			String jsonAlertString=UserDeskUTL.getAlertDtlsData(this, objRequest, objResponse);
			
			objResponse.setContentType("application/json");
			PrintWriter pw = objResponse.getWriter();
			if(jsonAlertString==null || jsonAlertString.equals(""))
				jsonAlertString="{}";
			
			pw.write(jsonAlertString);
			
			return null;	
					
		}
		public String logMenuDtl() throws Exception
		{
			UserDeskUTL.logMenuDtl(this, objRequest, objResponse);
			return null;
		}	
	
	
	
	
	

	//	@SuppressWarnings("unchecked")
//	public String login() throws Exception
//	{
//		if(LoginUTL.validateUser(this, objRequest, objResponse, mapSession))
//			return PAGE_HIS_LOGIN_DESK;
//		else
//			return PAGE_INITIAL;
//	}
//
//	@SuppressWarnings("unchecked")
//	public String logout() throws Exception
//	{
//		LoginUTL.logoutUser(this, objRequest, objResponse, mapSession);
//		LoginUTL.setInititals(this, objRequest, objResponse, mapSession);
//		return PAGE_INITIAL;
//	}
}
