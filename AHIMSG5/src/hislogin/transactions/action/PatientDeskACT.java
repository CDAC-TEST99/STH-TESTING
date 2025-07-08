package hislogin.transactions.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hislogin.transactions.actionsupport.UserDeskSUP;
import hislogin.transactions.utl.UserDeskUTL;
import hissso.config.HISSSOConfig;

public class PatientDeskACT extends UserDeskSUP {
	
	private static final long serialVersionUID = 1L;
	private static final String PAGE_HIS_LOGIN_DESK = "SUCCESS";
	private static final String PAGE_HIS_ERROR = "ERROR";

	public String execute() throws Exception
	{
		return load();
	}

	@SuppressWarnings("unchecked")
	public String load() throws Exception
	{		
		return PAGE_HIS_LOGIN_DESK; 
	}
	
}
