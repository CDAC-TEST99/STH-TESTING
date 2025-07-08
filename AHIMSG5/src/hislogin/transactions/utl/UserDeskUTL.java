package hislogin.transactions.utl;

import hisglobal.config.HISConfig;
import hisglobal.utility.HisUtil;
import hisglobal.utility.helper.DateHelperMethods;
import hisglobal.vo.CommonAlertVO;
import hislogin.config.HISLoginConfig;
import hislogin.transactions.actionsupport.UserDeskSUP;
import hislogin.transactions.data.UserDeskDATA;
import hissso.config.HISSSOConfig;
import hissso.validation.credentails.authentication.AuthenticationCredentials;
import hissso.validation.credentails.authorization.AuthorizationCredentials;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.usermgmt.MenuMasterVO;
import vo.usermgmt.UserMasterVO;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class UserDeskUTL
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean setDeskInititals(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		boolean flg = true;
		HttpSession objSession = null;
		try
		{
			objSession = objRequest.getSession();
			String grantingTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (grantingTicketId == null) return false;
			AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
			if (objAuthenticate == null) return false;
			String userHashSalt = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_HASH_SALT);
			if (userHashSalt == null) return false;

			Date objSysDate = (Date) objSession.getAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_OBJECT);
			String strDate = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_SYSDATE_STRING);
			if(objSysDate!=null)
				strDate = DateHelperMethods.getDateString(objSysDate,"dd-MM-yyyy HH:mm"); // in format dd-MM-yyyy HH:mm

			objActionSupport.setVarSSOTicketGrantingTicket(grantingTicketId);
			objActionSupport.setVarUserName(objAuthenticate.getVoUser().getVarUserName());
			objActionSupport.setVarUsrName(objAuthenticate.getVoUser().getVarUsrName());
			objActionSupport.setVarDefaultMenuURL(objAuthenticate.getVoUser().getVarDefaultMenuURL());
			objActionSupport.setVarCurrentDate(strDate);
			objActionSupport.setVarIsAutoRefresh(objAuthenticate.getVoUser().getVarIsAutoRefresh());
			
			if(objAuthenticate.getVoUser().getVarQuestionId()==null || objAuthenticate.getVoUser().getVarQuestionId().equals(""))
			{
				objActionSupport.setVarIsFirstTimeLogin(HISConfig.YES);
			}
			
			// Get & Set Authorization Detail
			AuthorizationCredentials objAuthorize = (AuthorizationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
			if (objAuthorize == null) return false;
			
			//To Fetch the Alerts Count Added by Singaravelan on 21-Nov-2014
			CommonAlertVO[] _commonAlertVO=null;		
			UserDeskDATA _usrDskData=new UserDeskDATA();
			int alertCount=0;
			StringBuffer mrqString=new StringBuffer();
 			//_commonAlertVO=_usrDskData.getAllAutomaticAlertBySeatID(objAuthenticate.getVoUser());
						
			/*
			 * if(_commonAlertVO!=null && _commonAlertVO.length > 0) { for(int i=0 ; i<
			 * _commonAlertVO.length ; i++){
			 * if(_commonAlertVO[i].getAlertAction().equals("1")) alertCount ++;
			 * if(_commonAlertVO[i].getIsMarquee()!=null&&_commonAlertVO[i].getIsMarquee().
			 * equals("1")){ mrqString.append(_commonAlertVO[i].getAlertMsg());
			 * if(i!=_commonAlertVO.length-1){ for(int y=0;y<350;y++)
			 * mrqString.append("&nbsp;"); } } } }
			 */
			objSession.setAttribute(HISSSOConfig.DESK_ALERT_COUNT, alertCount);
			objSession.setAttribute(HISSSOConfig.DESK_MARQUEE_MSG, mrqString.toString());
			
			//Set the Flag in Session to Show User wise Cash Collection Detail in desk Added by Singaravelan on 02-Jun-2015
			Map zeroLevelModules = objAuthorize.getMenusHirarchyMap();
			if(zeroLevelModules!=null)
			{
			Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();		
			//System.out.println("moduleSet size "+moduleSet.size());	
			Iterator mapItr=moduleSet.iterator();
			while(mapItr.hasNext())
			{
				Map.Entry menuMapEntry=(Map.Entry)mapItr.next();
				//System.out.println("menu map ------ "+menuMapEntry.getKey());	
				if(menuMapEntry != null && menuMapEntry.getKey() != null && ( menuMapEntry.getKey().toString().equalsIgnoreCase("Registration")||menuMapEntry.getKey().toString().equalsIgnoreCase("Emergency")||menuMapEntry.getKey().toString().equalsIgnoreCase("Billing")))
					objSession.setAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL, "1");	
				else if (menuMapEntry != null && menuMapEntry.getKey() != null && menuMapEntry.getKey().toString().equalsIgnoreCase("Alert Management"))
					objSession.setAttribute(HISSSOConfig.IS_ALERT_ROLE_ASSIGNED, "1");	
			}
			}
			else
				objSession.setAttribute(HISSSOConfig.SHOW_MENU, "0");
			
			/*
			 * if(objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL)!=
			 * null &&
			 * objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL).equals
			 * ("1")) getUserWiseAmountCollected(objAuthenticate.getVoUser(), objRequest,
			 * objResponse);
			 */
			
			/*String manualName=objActionSupport.getVarUserChoiceMenu();
			//Set the flag in session to show manuals list of registration on loading for the first time- Added by Anjali-28-04-2020
			Map zeroLevelModules1=objAuthorize.getManualsHirarchyMap();
			if(zeroLevelModules1!=null) {
				Set<Map.Entry> manualSet=zeroLevelModules1.entrySet();
				Iterator manualItr=manualSet.iterator();
				while(manualItr.hasNext()) {
					Map.Entry manualMapEntry=(Map.Entry)manualItr.next();
					if(manualMapEntry.getKey().toString().equalsIgnoreCase("Registration"))
						{
					//Map manualMap=parseManualMap(zeroLevelModules1,manualName,objRequest);//Added by Anjali
					//System.out.println("In case: "+manualMap);
					objSession.setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUAL_PROCESS_LIST,zeroLevelModules1);//Added by Anjali
						}
				}
			}*/
			/*else
				objSession.setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUAL_PROCESS_LIST, zeroLevelModules1);*/
			// Fetch Favorite List Here
			//List<MenuMasterVO> lstFavourite =  (List<MenuMasterVO>)objSession.getAttribute(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST)
			//mapSession.put(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST, lstFavourite);
			
		}
		catch (Exception e)
		{
			flg = false;
			e.printStackTrace();
			objSession.setAttribute(HISSSOConfig.DESK_ALERT_COUNT, "0");
		}
		return flg;
	}
	
	/**
	 * To Fetch the User Wise Total Cash Collected Details to Show in the Login Desk, Added by Singaravelan on 02-Jun-2015
	 * @param userVo
	 * @param objRequest
	 * @param objResponse
	 */
	@SuppressWarnings({ "rawtypes"})
	public static boolean fetchUserWiseCashCollected(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		
		boolean flg = true;
		HttpSession objSession = null;
		StringBuffer userDetails=new StringBuffer();
		try
		{
			objSession = objRequest.getSession();
			String grantingTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (grantingTicketId == null) return false;
			AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
			if (objAuthenticate == null) return false;
			if(objSession.getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED_DTL_MAP)!=null){
				getUserWiseAmountCollected(objAuthenticate.getVoUser(), objRequest, objResponse);			
				Map _mapData=(Map)objSession.getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED_DTL_MAP);
				userDetails.append("<span key='user-name'>User Name :</span>"+(String)(_mapData.get("userName")==null?"--":_mapData.get("userName"))+"</br>");
				userDetails.append("<span key='no-of-bills'>No. of Bills :</span>"+(String)(_mapData.get("billCount")==null?"0":_mapData.get("billCount"))+"</br>");
				userDetails.append("<span key='amount-received'>Amount Received :</span><img alt='Rs.' src='/HIS/hisglobal/images/INR-blue.png'/>"+(String)(_mapData.get("receivedAmount")==null?"0.00":_mapData.get("receivedAmount"))+"</br>");
				userDetails.append("<span key='amount-refunded'>Amount Refunded :</span><img alt='Rs.' src='/HIS/hisglobal/images/INR-blue.png'/>"+(String)(_mapData.get("refundAmount")==null?"0.00":_mapData.get("refundAmount"))+"</br>");
				userDetails.append("<span key='net-amount'>Net Amount :</span><img alt='Rs.' src='/HIS/hisglobal/images/INR-blue.png'/>"+(String)(_mapData.get("netAmount")==null?"0.00":_mapData.get("netAmount"))+"</br>");
			}
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flg = false;
			objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED, "0.00");
			objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED_DTL_MAP, new HashMap());

		}
		try
		{
			PrintWriter writer=objResponse.getWriter();
			writer.write(userDetails.toString());			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return flg;
		
	}
	
	@SuppressWarnings({ "rawtypes" })
	public static boolean reloadUserWiseCashCollected(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		
		boolean flg = true;
		HttpSession objSession = null;
		String reloadedAmt="0.00";
		objSession = objRequest.getSession();
		AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
		try
		{
			String grantingTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (grantingTicketId == null) return false;			
			if (objAuthenticate == null) return false;
			getUserWiseAmountCollected(objAuthenticate.getVoUser(), objRequest, objResponse);
			reloadedAmt=(String)objSession.getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flg = false;
			objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED, "0.00");
			objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED_DTL_MAP, new HashMap());

		}
		try
		{
			PrintWriter writer=objResponse.getWriter();
			if(objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL)!=null && objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL).equals("1")){
										
				if(reloadedAmt==null)
					writer.write( "<font size='4 px' color='#F2BC34'><span key='cash-in-hand'>Cash in Hand : </span><img alt='Rs.' src='/HIS/hisglobal/images/INR.png'/>0.00</font>");						
				else if(reloadedAmt.equalsIgnoreCase("error"))
					writer.write( "<font size='4 px' color='red'><span key='cash-in-hand-error'>Cash in Hand : Error</span></font>");
				else
					writer.write( "<font size='4 px' color='#F2BC34'><span key='cash-in-hand'>Cash in Hand : </span><img alt='Rs.' src='/HIS/hisglobal/images/INR.png'/>"+reloadedAmt+"</font>");
				
					
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return flg;

		
	}
	
	/**
	 * To get the User Wise Total Cash Collected Details to Show in the Login Desk, Added by Singaravelan on 02-Jun-2015
	 * @param userVo
	 * @param objRequest
	 * @param objResponse
	 */
	@SuppressWarnings("rawtypes")
	public static void getUserWiseAmountCollected(UserMasterVO userVo, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		
		HttpSession objSession = null;	
		UserDeskDATA _usrDskData=new UserDeskDATA();
		try
		{
			objSession = objRequest.getSession();
			if(objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL)!=null && objSession.getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL).equals("1")){
				Map cashCollectedDtl=_usrDskData.getUserWiseCashCollected(userVo);
				String totAmt=(String)cashCollectedDtl.get("netAmount");
				//System.out.println(" User wise Total Cash in Hand :::"+totAmt);	
				objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED, totAmt);
				objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED_DTL_MAP, cashCollectedDtl);

			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			objSession.setAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED, "Error");
		}

		
	}
	
	/**
	 * To Refresh the Home Tab Menu Contents in Login Desk, Added by Singaravelan on 04-Aug-2015
	 * @param objActionSupport
	 * @param objRequest
	 * @param objResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void refreshHomeTab(UserDeskSUP objActionSupport,HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		String menuName=objActionSupport.getVarUserChoiceMenu();
		String manualName=objActionSupport.getVarUserChoiceMenu();	
		try{
		AuthorizationCredentials objAuthorize = (AuthorizationCredentials) objRequest.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
		if(objAuthorize!=null && objAuthorize.getMenusHirarchyMap()!=null && menuName!=null) { /*&& objAuthorize.getManualsHirarchyMap()!=null){*/
			Map zeroLevelModules = objAuthorize.getMenusHirarchyMap();
			Map zeroLevelModules1=objAuthorize.getManualsHirarchyMap();
			
			Map processedMap=parseMap(zeroLevelModules, menuName ,objRequest);
			addFavouritesInProcessedMap(processedMap, objRequest);			
			objRequest.getSession().setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MENU_PROCESS_LIST, processedMap);
			Map manualMap=parseManualMap(zeroLevelModules1,menuName,objRequest);//Added by Anjali
			objRequest.getSession().setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUAL_PROCESS_LIST,manualMap);//Added by Anjali
				
			addFavouritesInProcessedMap(processedMap, objRequest);		
						
			objResponse.setContentType("plain/text");
		 
		}
		}catch(Exception e){
		}
		finally{
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,List> parseMap(Map menuMap,String menuName,HttpServletRequest objRequest)
	{
		 Map processedMap=new LinkedHashMap();
		 Map selectedModule = (Map)menuMap.get(menuName);
		 int _brCount=0;
		 Set<Map.Entry> processSet = selectedModule.entrySet();
		 for (Map.Entry set : processSet) 
		 {	
			 _brCount++;
			 processedMap.put(set.getKey(), set.getValue());
		 }		 
		 objRequest.getSession().setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MENUS_TYPE_COUNT, _brCount);
		 return processedMap;
	}
	
	/*To parse manual Map according to selected menu-Added by Anjali- 20-02-2020*/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<String,List> parseManualMap(Map manMap,String manualName,HttpServletRequest objRequest)
	{
		 Map manualsMap=new LinkedHashMap();
		 Map selectedModule= new LinkedHashMap();
		 if(manMap.containsKey(manualName))
		  selectedModule = (Map)manMap.get(manualName);
		 else
			 selectedModule.put(manualName,"No manuals available."); 
		 
		 int _brCount=0;
			Set<Map.Entry> processSet = selectedModule.entrySet();
			for (Map.Entry set : processSet) {
				_brCount++;
				manualsMap.put(set.getKey(), set.getValue());
			}

		 objRequest.getSession().setAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUALS_TYPE_COUNT, _brCount);
		 return manualsMap;
	}
	//
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addFavouritesInProcessedMap(Map _map,HttpServletRequest objRequest){
		
		List<MenuMasterVO> lstFavourite =  (List<MenuMasterVO>)objRequest.getSession().getAttribute(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST);
		
		Map favMap=new HashMap();
		for(MenuMasterVO _menuMastrVo:lstFavourite){
			favMap.put(_menuMastrVo.getVarMenuName(), _menuMastrVo.getVarURL());
		}
		
		if(favMap.size()>0){
			//System.out.println("Favourite List:::"+favMap.toString());
			_map.put("Favourites", favMap);
		}
	}
	
	//Added by Anjali
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addFavoritesInManualMap(Map _map,HttpServletRequest objRequest){
		
		List<MenuMasterVO> lstManual =  (List<MenuMasterVO>)objRequest.getSession().getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUAL_PROCESS_LIST);
		
		Map favMap=new HashMap();
		for(MenuMasterVO _menuMastrVo:lstManual){
			favMap.put(_menuMastrVo.getVarMenuName(), _menuMastrVo.getVarManualFileName());
		}
		
		if(favMap.size()>0){
			//System.out.println("Favourite List:::"+favMap.toString());
			_map.put("Manuals", favMap);
		}
	}
	//
	
	public static String recursiveParseMenuMap(Map menuMap,int i,int j)
	{
		StringBuffer _str=new StringBuffer();
		Set<Map.Entry> subProcessSet = menuMap.entrySet();
		i++;j++;
		for (Map.Entry subset : subProcessSet) 
		{
			 if(subset.getValue() instanceof String){
				 String url2=subset.getValue().toString().trim();
				 
				 System.out.println("url2  >>>>>>>>>   "+url2);
				 
				 String url=url2.split("#")[0];
				// String url=subset.getValue().toString().trim();
				 String menu=subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY");
				 String menu2 = menu;
				 menu="'"+menu+"'";
				  
				 //System.out.println("Menu Name ::" +menu+" Url ::'"+url+"'");
				 //url="'"+new String(Base64.encodeBase64(url.getBytes()))+"'";
				 url="'"+url+"'";
				 _str.append("<li class='level_"+i+"'><a key='"+subset.getKey().toString().toLowerCase().replaceAll(" ", "-")+"' id="+menu+" class='menu_links' onclick=callMenu("+url+","+menu+");>");
				 _str.append(subset.getKey());
				 String menuId2 = menu2+"_MENU_ID";
				 
				 if(url2.split("#").length > 1 )
				 _str.append("</a>"
						 +"<input type='hidden' id="+menuId2+" value="+url2.split("#")[1]+" >"
				 		+ "</li>");
			 }
			 
			 else{
				 String _mnName="'"+subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY")+"_"+j+"_collapse'";
				 _str.append("<div onclick=expandDiv("+_mnName+")>");
				 _str.append("<li key='"+subset.getKey().toString().toLowerCase().replaceAll(" ", "-")+"' id='"+subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY")+"_"+j+"_collapse_wrapper' class='subwrapper'>");
				 _str.append(subset.getKey());
				 _str.append("</li>");
				 _str.append("</div>");
			 
				 _str.append("<div id="+_mnName+" class='collapse'><ul id='sortable'>");
				 _str.append(UserDeskUTL.recursiveParseMenuMap((Map)subset.getValue(),i,j));
				 _str.append("</ul></div>");
	
			 }
			 
		 }		
		
		return _str.toString();	
		
	}
	 
	
	//Added by Anjali
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String recursiveParseManualMap(Map manualMap,int i,int j)
	{
		StringBuffer _str=new StringBuffer();
		Set<Map.Entry> subProcessSet = manualMap.entrySet();
		i++;j++;
		for (Map.Entry subset : subProcessSet) 
		{
			 if(subset.getValue() instanceof String){
				 String manual=subset.getValue().toString().trim();
					String menu=subset.getKey().toString().trim().replaceAll("\\s","_").replaceAll("\\&","XXX").replaceAll("\\/", "XXY");
					menu="'"+menu+"'";
					manual="'"+manual+"'";
					if(subset.getValue().toString().equals("No_Manual")) {
						_str.append("<li style='width:225px;'>"+"<a style='color:#b40000;' class='symbol' id="+manual+" title='Not uploaded' >"+subset.getKey()+"</a></li>");
					}
					else
					_str.append("<li style='width:225px;'>"+"<a class='symbol' id="+manual+" onclick=openManual("+manual+","+menu+"); data-toggle='modal' data-target='#myModal' >"+subset.getKey()+"</a></li>");
			 }
			 
			 else{
				 String _mnName=subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY");
				 _str.append("<li style='width:225px;color:#230161;' id="+_mnName+"><a style='font-weight:bolder;color:#230161;' class='caret1' >"+subset.getKey()+"</a>");
				 _str.append("<ul class='nested'>");
				 _str.append(UserDeskUTL.recursiveParseManualMap((Map)subset.getValue(),i,j));
				 //System.out.println("After recursiveParseMenuMap= "+subset.getKey()+" "+UserDeskUTL.recursiveParseManualMap((Map)subset.getValue(),i,j));
				 _str.append("</ul>");
				
			 }
			 _str.append("</li>");
			 
		 }		
		
		return _str.toString();	
		
	}
	//
	
	/**
	 * To Generate the Manual List for the selected Menu, Added by Anjali on 20-02-2020
	 * @param menuMap
	 */
	public static StringBuffer generateManualList(HttpSession session) {
		StringBuffer str=new StringBuffer();
		
		Map manualMap=(Map)session.getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUAL_PROCESS_LIST);
		if(manualMap.containsKey("Services")||manualMap.containsKey("Setup")||manualMap.containsKey("Reports")) {
		Set<Map.Entry> processSet=manualMap.entrySet();
		int i=1,j=1;
		int brCount=(Integer)session.getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MANUALS_TYPE_COUNT);
		for(Map.Entry set:processSet) {		 
			str.append("<ul class='myUL'>");
			str.append("<li style='color:black; width:230px;'><a style='font-weight:bolder' class='caret1' >"+set.getKey()+"</a>");
			//System.out.println("Before: "+set.getKey());
		j++;
		
		Map subManualMap=(Map)set.getValue();
		//System.out.println("subManualMap= "+subManualMap);
		
		Set<Map.Entry> subProcessSet=subManualMap.entrySet();
		str.append("<ul class='nested'>");
		for(Map.Entry subset:subProcessSet) {
			if(subset.getValue() instanceof String) {
				String manual=subset.getValue().toString().trim();
			String menu=subset.getKey().toString().trim().replaceAll("\\s","_").replaceAll("\\&","XXX").replaceAll("\\/", "XXY");
			menu="'"+menu+"'";
			manual="'"+manual+"'";
			//System.out.println("UserDeskUTL-> "+menu+" -> "+manual);
			if(subset.getValue().toString().equals("No_Manual")) {
				str.append("<li style='width:225px;'>"+"<a style='color:#b40000;' class='symbol' id="+manual+" title='Not uploaded' >"+subset.getKey()+"</a></li>");
			}else
			str.append("<li style='width:225px;'>"+"<a class='symbol' id="+manual+" onclick=openManual("+manual+","+menu+"); data-toggle='modal' data-target='#myModal' >"+subset.getKey()+"</a></li>");
		}else {
			String _mnName=subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY");
			 str.append("<li style='width:225px;color:#230161;' id="+subset.getKey()+"><a style='font-weight:bolder;color:#230161;' class='caret1' >"+subset.getKey()+"</a>");
			 str.append("<ul class='nested'>");
			 str.append(UserDeskUTL.recursiveParseManualMap((Map)subset.getValue(),i,j));
			 //System.out.println("After recursiveParseMenuMap= "+subset.getKey()+" "+UserDeskUTL.recursiveParseManualMap((Map)subset.getValue(),i,j));
			 str.append("</ul>");
			
		}		
			 str.append("</li>");
		}
			str.append("</ul>");
			str.append("</li>");
			str.append("</ul>");
		}	
	}else
			str.append("No manuals uploaded");
		return str;
	}
	
	/**
	 * To Generate the Menus from Menu Map in the Home Tab, Added by Singaravelan on 09-Oct-2015
	 * @param menuMap
	 */
	public static StringBuffer generateMenuList(HttpSession session){
		StringBuffer str=new StringBuffer();
		Map menuMap=(Map)session.getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MENU_PROCESS_LIST);
		Set<Map.Entry> processSet = menuMap.entrySet();
		int width=90/processSet.size();
		int i=1,j=1;
		int brCount=(Integer)session.getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MENUS_TYPE_COUNT);
		for (Map.Entry set : processSet) 
		{
			str.append("<div class='rcorners' key='"+set.getKey().toString().trim().toLowerCase().replaceAll(" ", "-")+"'  id='"+set.getKey()+"_menuId' style='width:"+width+"%;height:80%;padding:4px;'>");
			str.append("<h2>");
			str.append("<span class='heading1'><img src='/HIS/hisglobal/images/tabmenu/"+set.getKey()+".png' alt=''>&nbsp;");
			str.append(set.getKey());	
			str.append("</span>");
			str.append("</h2>");
			j++;
			 
			Map subMenuMap=(Map)set.getValue();
			Set<Map.Entry> subProcessSet = subMenuMap.entrySet();
			str.append("<ul id='scrollable' class='scrollable'>");
			for (Map.Entry subset : subProcessSet) 
			{
				 if(subset.getValue() instanceof String){
				 
					 try {
					 String url2=subset.getValue().toString().trim();
					  System.out.println("url2-> "+url2);
					 String url=url2.split("#")[0];
					// String url=subset.getValue().toString().trim();
					 String menu=subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY");
					 String menu2 = menu;
					 menu="'"+menu+"'";
					  
					// System.out.println("Menu Name ::" +menu2+" Url ::'"+url2+"'");
					 //System.out.println("Menu Name ::" +menu+" Url ::'"+url+"'");
					 //url="'"+new String(Base64.encodeBase64(url.getBytes()))+"'";
					 url="'"+url+"'";
					 str.append("<li class='level_"+i+"'><a key='"+subset.getKey().toString().toLowerCase().replaceAll(" ", "-")+"' id="+menu+" class='menu_links' onclick=callMenu("+url+","+menu+"); tabindex='1' onkeypress=clickMenu("+url+","+menu+",event);>");
					 str.append(subset.getKey());
					 String menuId2 = menu2+"_MENU_ID";
					/* str.append("</a>"
							 +"<input type='hidden' id="+menuId2+" value="+url2.split("#")[1]+" >"
					 		+ "</li>");*/
					 
					 }catch(Exception e) {
						 e.printStackTrace();
					 }
					 
				 }
				 
				 else{
					 String _mnName="'"+subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY")+"_"+j+"_collapse'";
					 str.append("<div onclick=expandDiv("+_mnName+") title='Click to Expand'>");
					 str.append("<li key='"+subset.getKey().toString().toLowerCase().replaceAll(" ", "-")+"'  id='"+subset.getKey().toString().trim().replaceAll("\\s", "_").replaceAll("\\&", "XXX").replaceAll("\\/", "XXY")+"_"+j+"_collapse_wrapper' class='subwrapper'>");
					 str.append(subset.getKey());
					 str.append("</li>");
					 str.append("</div>");
					 str.append("<div id="+_mnName+" class='collapse'><ul id='sortable'>");
		
					 str.append(UserDeskUTL.recursiveParseMenuMap((Map)subset.getValue(),i,j));
					 str.append("</ul></div>");
				 }
				 
			 }				
			 str.append("</ul>");
			 str.append("</div>");
		
		 }			
		
		return str;
	}
	
	
	/**
	 * To Check the Default is Accessible in the Home Tab, Added by Singaravelan on 09-Oct-2015
	 * @param objActionSupport
	 * @param objRequest
	 * @param objResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean isDefaultURLAuthorized(String strDefaultURL, String strDefaultURLName, String strDefaultURLModule, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{		
		String menuName=strDefaultURLModule;		
		try{
		AuthorizationCredentials objAuthorize = (AuthorizationCredentials) objRequest.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
		if(objAuthorize!=null && objAuthorize.getMenusHirarchyMap()!=null && menuName!=null){
			Map zeroLevelModules = objAuthorize.getMenusHirarchyMap();
			Map processedMap=parseMap(zeroLevelModules, menuName,objRequest);
			
		}
		}catch(Exception e){
			return false;
		}
		finally{
		}
		return true;
	}
	
	/**
	 * To Set the Alert Dtls in the the Desk, Added by Singaravelan on 29-Oct-2015
	 * @param objActionSupport
	 * @param objRequest
	 * @param objResponse
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean getAlertDtls(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{	
		
		HttpSession objSession = null;
		int alertCount=0;StringBuffer mrqString=new StringBuffer();
		try{
		CommonAlertVO[] _commonAlertVO=null;
		objSession = objRequest.getSession();
		UserDeskDATA _usrDskData=new UserDeskDATA();
		AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
		objSession.removeAttribute(HISSSOConfig.DESK_ALERT_COUNT);objSession.removeAttribute(HISSSOConfig.DESK_MARQUEE_MSG);
			/*
			 * _commonAlertVO=_usrDskData.getAllAutomaticAlertBySeatID(objAuthenticate.
			 * getVoUser());
			 * 
			 * if(_commonAlertVO!=null && _commonAlertVO.length > 0) { for(int i=0 ; i<
			 * _commonAlertVO.length ; i++){
			 * if(_commonAlertVO[i].getAlertAction().equals("1")) alertCount ++;
			 * if(_commonAlertVO[i].getIsMarquee().equals("1")){
			 * mrqString.append(_commonAlertVO[i].getAlertMsg());
			 * if(i!=_commonAlertVO.length-1){ for(int y=0;y<350;y++)
			 * mrqString.append("&nbsp;"); } } } }
			 */
		
		objSession.setAttribute(HISSSOConfig.DESK_ALERT_COUNT, alertCount);
		objSession.setAttribute(HISSSOConfig.DESK_MARQUEE_MSG, mrqString.toString());
		}catch(Exception e){			
			objSession.setAttribute(HISSSOConfig.DESK_ALERT_COUNT, "0");
			objSession.setAttribute(HISSSOConfig.DESK_MARQUEE_MSG, "");
			return false;
		}
		finally{
		}
		
		try
		{
			PrintWriter writer=objResponse.getWriter();
			StringBuffer toWrite=new StringBuffer();
			if(objSession.getAttribute(HISSSOConfig.DESK_ALERT_COUNT)!=null)		
				toWrite.append( "<font color='#FFFF00' size='2'><b>("+objSession.getAttribute(HISSSOConfig.DESK_ALERT_COUNT)+")</b></font>");	
			toWrite.append("$");
			if(objSession.getAttribute(HISSSOConfig.DESK_MARQUEE_MSG)!=null)			
				toWrite.append( "<font color='#1277B5' style='font-weight: bold;font-style: italic;'>"+objSession.getAttribute(HISSSOConfig.DESK_MARQUEE_MSG)+"</font>");
			
			writer.write(toWrite.toString());
				
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return true;
	}
	/*
	 * Added For High Priority Automatic Alert Data By Raj Kumar
	 */
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String getAlertDtlsData(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{	
		String jsonInString="";
		HttpSession objSession = null;
		int alertCount=0;StringBuffer mrqString=new StringBuffer();
		try{
		CommonAlertVO[] _commonAlertVO=null;
		objSession = objRequest.getSession();
		UserDeskDATA _usrDskData=new UserDeskDATA();
		AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
		_commonAlertVO=_usrDskData.getAllAutomaticAlertBySeatID(objAuthenticate.getVoUser());
		ObjectMapper mapper = new ObjectMapper();
		
		if(_commonAlertVO!=null && _commonAlertVO.length > 0)
		{
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			jsonInString = ow.writeValueAsString(_commonAlertVO);
			
		
		}
		
		
		}catch(Exception e){			
		System.out.println("Data Not Found");	
		}
	
		
		return jsonInString;
	}

	
	@SuppressWarnings({ "rawtypes" })
	public static boolean logMenuDtl(UserDeskSUP objActionSupport, HttpServletRequest objRequest, HttpServletResponse objResponse)
	{
		System.out.println("inside logMenuDtl");
		boolean flg = true;
		HttpSession objSession = null;
		objSession = objRequest.getSession();
		AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
		
		String strTransId="0";
		try
		{
			String menuId = objRequest.getParameter("menuId");
			String grantingTicketId = (String) objSession.getAttribute(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID);
			if (grantingTicketId == null) return false;			
			if (objAuthenticate == null) return false;
			if(objRequest.getParameter("logType").equals("1"))//Start Log
			{
				strTransId=HisUtil.logMenuStart(menuId, objRequest.getParameter("menu"), "0",objRequest,"0",objAuthenticate.getVoUser());
				//System.out.println("strTransId"+strTransId);
			}
			else
			{
				//System.out.println("menu"+objRequest.getParameter("menu"));
				//System.out.println("id"+objRequest.getParameter("id"));
				HisUtil.logMenuEnd(menuId, objRequest.getParameter("menu"),"1", objRequest,"0", objAuthenticate.getVoUser());
			}
			//reloadedAmt=(String)objSession.getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			flg = false;
		}
		
		/*
		 * try { PrintWriter writer=objResponse.getWriter(); writer.write(strTransId);
		 * 
		 * } catch(IOException e) { e.printStackTrace(); }
		 */
		return flg;

		
	}	
	
	
}
