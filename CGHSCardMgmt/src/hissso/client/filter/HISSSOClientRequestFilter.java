package hissso.client.filter;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hisglobal.config.HISConfig;
import hisglobal.utility.Usefulmethods;
import hisglobal.vo.HospitalMstVO;
import hisglobal.vo.UserVO;
import hissso.config.HISSSOClientConfig;
import hissso.config.HISSSOConfig;
import hissso.config.HISSSOSupport;
import hissso.services.HISSSOServiceCLN;
import hissso.ticket.HISServiceGrantTicket;
import hissso.ticket.HISServiceTicket;
import hissso.ticket.registry.HISTicketRegistry;
import hissso.validation.credentails.authorization.HISService;
import thirdpartyservices.bhavishya.util.AESEncrytionDecryption;
import vo.usermgmt.HospitalMasterVO;
import vo.usermgmt.UserMasterVO;

public class HISSSOClientRequestFilter implements Filter
{
	
	// private FilterConfig objFilterConfig;
	//"//HIS//",
	public  String []arrSkipURL= {"BhavishyaAction", "//HIS//",".js",".css","image",".pdf",".woff2" ,".ttf" ,"/services/"};
	public void init(FilterConfig objFilterConfig)
	{
		// this.objFilterConfig = objFilterConfig;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		
	//	System.out.println("inside CGHSCardMgmt HISSSOClientRequestFilter doFilter");
		HttpServletRequest objRequest = (HttpServletRequest) request;
		HttpServletResponse objResponse = (HttpServletResponse) response;
		boolean authenticate = false, authenticatioRequired = true;
		HISServiceTicket objHISServiceTicket = null;
		String isAjaxRequest=objRequest.getParameter("isAjaxRequest");
		try
		{
			String strURI = objRequest.getRequestURI(); 
			//System.out.println("CGHSCardMgmt strURI---" + strURI);
			
			

			
			/*String hmode=objRequest.getParameter("hmode");
			if(hmode!=null && (hmode.equals("fileTempDownload")|| hmode.equals("ftpFileDownload"))) {
				chain.doFilter(request, response);
				return;
			}*/
			String isGlobal	=validateIsGlobal(objRequest, strURI);
			boolean skipped=false;
			for(int i=0;i<arrSkipURL.length;i++){
				if (strURI.contains(arrSkipURL[i])){
					skipped=true;
					break;
									
				}
			}
			//System.out.println("skipped---" + skipped);
		//	System.out.println("isGlobal---" + isGlobal);
			if(isGlobal!=null && isGlobal.equals("1") || skipped) {
			//	System.out.println("do filter---");
				chain.doFilter(request, response);
				return;
			}
			
			if (HISSSOClientConfig.SSO_ST_SERVICE_URL!=null &&  strURI.contains(HISSSOClientConfig.SSO_ST_SERVICE_URL) )
			{
				// Forward as-it-is
				////System.out.println("inside if block strURI contains "+ HISSSOClientConfig.SSO_ST_SERVICE_URL);
				chain.doFilter(request, response);
			}
			else
			{
				//System.out.println("inside HISSSOClientRequestFilter else");
				boolean isURLAuthenticationRequired=true;
				
				
				
				
				//System.out.println("isURLAuthenticationRequired="+isURLAuthenticationRequired +" CGHSCardMgmt :: HisRequestLoginFilter");
				if(isURLAuthenticationRequired){
					
				
					
					
					//System.out.println("Referer===" + objRequest.getHeader("Referer"));
					if(!(objRequest.getHeader("Referer") != null && objRequest.getHeader("Referer").trim().length() > 0))
		            {
		                RequestDispatcher rd = null;
		                rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
		                rd.forward(objRequest, objResponse);
		                
		                return;
		            }
					// Fetch Module ST Registry
					HISTicketRegistry registry = HISSSOSupport.getSSORegister(objRequest);
	
					String strServiceTicketId = "";
					// Check Session Validation
					HttpSession session = objRequest.getSession(false);
				//	System.out.println("session==" + session);
					if (session != null)
					{
						//System.out.println("session is not NULL");
						// If Session Already Exists
						// Fetch ST Id from Session
						strServiceTicketId = (String) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_SERVICE_TICKET_ID);
					//	System.out.println("Session::strServiceTicketId :" + strServiceTicketId);
	
						// Check the same in Registry
						if (strServiceTicketId == null || registry.getTicket(strServiceTicketId) == null)
						{
							authenticate = false;
							authenticatioRequired = true;
						}
						else
						{
							objHISServiceTicket = (HISServiceTicket) registry.getTicket(strServiceTicketId);
	
							String reqGrantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
						//	System.out.println("Session::reqGrantingTicketId ----:" + reqGrantingTicketId);
	
							if(reqGrantingTicketId!=null && !reqGrantingTicketId.equals("") && !reqGrantingTicketId.equals(objHISServiceTicket.getGrantingTicketId()))
							{
							//	System.out.println("Here------------");
								authenticate = false;
								authenticatioRequired = true;
							}
							else
							{
								// If get ticket then update ticket and go ahead
								// Authenticate
								authenticate = true;
								authenticatioRequired = false;
		
								// if expired
								if (objHISServiceTicket.isExpired())
								{
									// create new session
									//objRequest.getSession().invalidate();
									session = objRequest.getSession();
		
									// Set TGT inSession
									session.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, objHISServiceTicket.getGrantingTicketId());
		
									// associate with ST
									objHISServiceTicket.associateServiceAtClient(session);
								}
							}
						}
					}
					else
					{
						// If session not exists
						// Get TGT ID from Request
						// If found check from SSO
	
						//System.out.println("session is  NULL");
						String grantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
						//System.out.println("grantingTicketId :" + grantingTicketId);
	
						if (grantingTicketId == null)
						{
							authenticate = false;
							authenticatioRequired = false;
						}
						else
						{
							authenticate = false;
							authenticatioRequired = true;
						}
					}
					//System.out.println("authenticatioRequired--" + authenticatioRequired);
					if (authenticatioRequired)
					{
						////System.out.println("inside if(authenticatioRequired)");
						String grantingTicketId = (String) objRequest.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
	
						HISService objHISService = HISSSOSupport.getHISServiceObject(objRequest);
	
						// REquest SSO Service for Valid ST
						HISServiceGrantTicket objGrantTicket = authenticateAccess(grantingTicketId, objHISService, objRequest);
						////System.out.println("objGrantTicket---" + objGrantTicket);
						if (objGrantTicket != null)
						{
							////System.out.println("GrantTicket ID :" + objGrantTicket.getTicketId());
							authenticate = true;
	
							// Check Is User Already have a Service Ticket based on
							// UserId, IP Address
							HISServiceTicket objST = (HISServiceTicket) registry.getTicketBasedOn(objGrantTicket.getAuthentication().getVarUserId(), objGrantTicket.getAuthentication().getVoUser().getVarIPAddress());
							// If ticket exist, logout and delete the old ticket
							if (objST != null)
							{
								objST.logout();
								registry.deleteTicket(objST.getTicketId());
							}
	
							// Setting Session Credentials, New Session, Session Expiration,
							// Creating New Session
							//objRequest.getSession().invalidate();
							HttpSession objSession = objRequest.getSession();
	
							// Set TGT inSession
							objSession.setAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID, grantingTicketId);
	
							// Set Session Detail in ST
							objHISServiceTicket = new HISServiceTicket(objGrantTicket, objSession);
	
							// Register ST in Registry
							registry.addTicket(objHISServiceTicket);
	
							// Set Credentials in Session
							setCredentialsInSession(objSession, objHISServiceTicket);
						}
						else
						{
							// If User Not Authenticated by WS, then not valid
							authenticate = false;
						}
					}
					//System.out.println("authenticate===="+authenticate);	
					if (authenticate)
					{
						
						 isGlobal	=validateIsGlobal(objRequest, strURI);
						
						// Check for URI Authorization here If not set -------
						if ( isGlobal.equals("1") || objHISServiceTicket.getAuthorization().isAuthorizedURL(strURI))
						{
							
							chain.doFilter(request, response);
						}
						else
						{
							RequestDispatcher rd = null;
							rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHORIZATION_ERROR_PAGE_URL);
							rd.forward(objRequest, objResponse);
						}
					}
					else
					{
						 isGlobal	=validateIsGlobal(objRequest, strURI);
						if ( isGlobal.equals("1"))
						{
							chain.doFilter(request, response);
						}else {
							
							if(isAjaxRequest!=null){
								try {
									if(isAjaxRequest.equals("1")){
										response.flushBuffer();
										PrintWriter writer = response.getWriter();
										writer.write("EXPIRED");
									}else if(isAjaxRequest.equals("2")){	
										response.flushBuffer();
										response.setContentType("application/json");
										PrintWriter writer = response.getWriter();
										writer.write("{\"msg\":\"EXPIRED\"");
										
									}
							
								} catch (IOException e1) {
									e1.printStackTrace();
								}
							}
							else{
								RequestDispatcher rd = null;
								rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_AUTHENTICATION_ERROR_PAGE_URL);
								rd.forward(objRequest, objResponse);
							}
						}
					}
				}
				else {
					//System.out.println("Chain .dofilter");
					chain.doFilter(request, response);
				}
			}
		}
		catch (IllegalStateException ie){
			ie.printStackTrace();
			RequestDispatcher rd = null;
			rd = objRequest.getRequestDispatcher("/application/jsp/IllegalStateApp_error_under.jsp");
			rd.forward(objRequest, objResponse);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			////System.out.println("isAjaxRequest---" + isAjaxRequest);
			if(isAjaxRequest!=null && isAjaxRequest.equals("1")){
				
					try {
						response.flushBuffer();
						PrintWriter writer = response.getWriter();
						writer.write("EXPIRED");

					} catch (IOException e1) {
						e1.printStackTrace();
					}
			}
			else{
				RequestDispatcher rd = null;
				rd = objRequest.getRequestDispatcher(HISSSOConfig.SSO_UNKNOWN_ERROR_PAGE_URL);
				rd.forward(objRequest, objResponse);
			}
		}

	}

	public void destroy()
	{

	}

	// Authenticate User By Calling Authenticate SSO Service
	private HISServiceGrantTicket authenticateAccess(String strGrantingTicketId_p, HISService objService_p, HttpServletRequest request)
	{
		HISServiceGrantTicket objGrantTicket = null;
		try
		{
			HISSSOServiceCLN objHISSSOServiceClient = new HISSSOServiceCLN();
			objGrantTicket = objHISSSOServiceClient.authenticate(strGrantingTicketId_p, objService_p, request);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			objGrantTicket = null;
		}
		return objGrantTicket;
	}

	// Setting Credential in Session
	private boolean setCredentialsInSession(HttpSession objSession_p, HISServiceTicket objST_p)
	{
		
		////System.out.println("inside setCredentialsInSession--");
		boolean flg = true;
		try
		{
			// User VO
			UserMasterVO voUser = objST_p.getAuthentication().getVoUser();
			////System.out.println("setCredentialsInSession--"+ voUser.getVarUserId());
			UserVO voGlobalUser = new UserVO();
			populateData(voGlobalUser, voUser);
			voGlobalUser.setUserEmpID(voUser.getVarEmpNo());
			objSession_p.setAttribute(HISConfig.USER_VO, voGlobalUser);
			objSession_p.setAttribute("SEATID", voGlobalUser.getUserId());
			objSession_p.setAttribute("IP_ADDR", voGlobalUser.getIpAddress());

			// Hospital VO
			HospitalMasterVO voHospital = objST_p.getAuthentication().getVoHostpital();
			HospitalMstVO voGlobalHospital = new HospitalMstVO();
			populateData(voGlobalHospital, voHospital);
			objSession_p.setAttribute(HISConfig.HOSPITAL_VO, voGlobalHospital);
			objSession_p.setAttribute("HOSPITAL_CODE", voGlobalHospital.getHospitalCode());
			//System.out.println("voUser.getVarUserName()================" + voUser.getVarUserName());
			objSession_p.setAttribute("USER_FULL_NAME", voUser.getVarUsrName());
			
			
			objSession_p.setAttribute(HISConfig.SYSDATEOBJECT, objST_p.getAuthentication().getVoUserLog().getVarUserLoginDate());
			////System.out.println("-------date----" + objST_p.getAuthentication().getVoUserLog().getVarUserLoginDate());
		}
		catch (Exception ee)
		{
			flg = false;
		}
		return flg;
	}

	private void populateData(Object objTarget, Object objSource)
	{
		if (objSource instanceof UserMasterVO && objTarget instanceof UserVO)
		{
			UserMasterVO objSrc = (UserMasterVO) objSource;
			UserVO objTar = (UserVO) objTarget;
			objTar.setUserId(objSrc.getVarUserId());			// User ID
			objTar.setSeatId(objSrc.getVarUserId());			// User ID
			objTar.setUserSeatId(objSrc.getVarUserSeatId());	// Seat ID
			objTar.setHospitalCode(objSrc.getVarHospitalCode());
			objTar.setIpAddress(objSrc.getVarIPAddress());
			objTar.setUserEmpID(objSrc.getVarEmpNo());
			objTar.setUserLevel(objSrc.getVarUserLevel());
			objTar.setUsrName(objSrc.getVarUsrName());
			objTar.setUserName(objSrc.getVarUserName());		// Login User Name
			objTar.setDesignation(objSrc.getVarDesignation());
			objTar.setDistrictCode(objSrc.getVarDistrictId());
			objTar.setEmailId(objSrc.getVarEmailId());
			objTar.setMobileNo(objSrc.getVarMobileNumber());
			objTar.setDistrictName(objSrc.getVarDistrictName());
			objTar.setIsBen(objSrc.getVarIsBen());
			// Other User Details
			objTar.setUserType(objSrc.getVarUserTypeId());
			objTar.setSwapcardNo(objSrc.getVarSwapcardNumber());
		}
		else if (objSource instanceof HospitalMasterVO && objTarget instanceof HospitalMstVO)
		{
			HospitalMasterVO objSrc = (HospitalMasterVO) objSource;
			HospitalMstVO objTar = (HospitalMstVO) objTarget;
			objTar.setHospitalCode(objSrc.getVarHospitalCode());
			objTar.setHospitalName(objSrc.getVarHospitalName());
			objTar.setHospitalShortName(objSrc.getVarHospitalShortName());

			objTar.setAddress1(objSrc.getVarHospitalAddress1());
			objTar.setAddress2(objSrc.getVarHospitalAddress2());
			objTar.setCity(objSrc.getVarCity());
			objTar.setEmail(objSrc.getVarEmail());
			objTar.setPhone(objSrc.getVarPhone());
			objTar.setFax(objSrc.getVarFax());
			objTar.setDistrictCode(objSrc.getVarDistrictId());
			objTar.setState(objSrc.getVarStateCode());
			objTar.setPinCode(objSrc.getVarPinCode());
			objTar.setDistrictName(objSrc.getVarDistrictName());
			objTar.setStateName(objSrc.getVarStateName());

			objTar.setLanguageCode(objSrc.getVarLanguageCode());
			objTar.setLocalLangCode(objSrc.getVarLocalLangCode());
			objTar.setLanguageName(objSrc.getVarLanguageName());
			objTar.setLocalLangName(objSrc.getVarLocalLangName());

			// Other Hospital Details
			objTar.setContactPerson(objSrc.getVarContactPerson());
			objTar.setHospitalTypeCode(objSrc.getVarHospitalType());
			objTar.setHospitalTypeName(objSrc.getVarHospitalTypeName());
			objTar.setBedCapacity(objSrc.getVarBedCapacity());
			objTar.setBusRouteNo(objSrc.getVarBusRouteNo());
			objTar.setHospitalCategory(objSrc.getVarHospitalCategory());
			objTar.setIsAssociated(objSrc.getVarIsAssociated());
			objTar.setLunchTimings(objSrc.getVarLunchBreak());
			objTar.setOrgType(objSrc.getVarOrganizationType());
			objTar.setRemarks(objSrc.getVarRemarks());
			objTar.setSaturdayTimings(objSrc.getVarSaturdayTimings());
			objTar.setWeekdayTimings(objSrc.getVarWeekdaysTimings());
			objTar.setPanNo(objSrc.getVarPANNo());
			objTar.setTanNo(objSrc.getVarTANNo());
			objTar.setUserLiscenceAllowed(objSrc.getVarUserLicenceAllowed());
		}
	}
	public String validateIsGlobal(HttpServletRequest objRequest,String strURI) {
		 
		String isGlobal=objRequest.getParameter("isGlobal");
		if(isGlobal==null || isGlobal.equals("")) 
			isGlobal="0";
		
		
		/*
		 * if("1".equalsIgnoreCase(isGlobal)) { objRequest.getSession().invalidate();
		 * objRequest.getSession().invalidate(); objRequest.getSession(false); }
		 */ 
		
		
		String hospitalCode=(String) objRequest.getSession().getAttribute("HOSPITAL_CODE");
		//System.out.println("HISSSOClientRequestFilter HOSPITAL_CODE::"+  objRequest.getSession().getAttribute("HOSPITAL_CODE"));
		if("0".equals(isGlobal) && hospitalCode!=null)
			isGlobal="0";
		
		
		
		//if(strURI.contains("QMSDISPLAYBOARDACTION") || strURI.contains("QMSProcessACTION") ||  strURI.contains("ABHACreation")){
			
			//System.out.println("isGlobal in doFilter--" + isGlobal);
			if(isGlobal!=null && !isGlobal.equals(""))
			{
				// since url is authenticated 2 time  and hospital code is null for second time so setting hospital code in session
				//System.out.println("setting isglobal value in session isGlobal==" +isGlobal);
				objRequest.getSession().setAttribute("isGlobal", isGlobal);
			}
			else{
				isGlobal=(String) objRequest.getSession().getAttribute("isGlobal");
				// if isglobal is not send by url the setting isglobal to 0
				
				//System.out.println("else isGlobal==" +isGlobal);
				if(isGlobal==null || isGlobal.equals(""))
					isGlobal="0";
				
				//System.out.println("else check 2 isGlobal==" +isGlobal);
				objRequest.getSession().setAttribute("isGlobal", isGlobal);
				objRequest.setAttribute("isGlobal", isGlobal);
			}
		//}
		return isGlobal;
		
	}

	
}
