<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="vo.usermgmt.MenuMasterVO"%>
<%@page import="hislogin.transactions.utl.UserDeskUTL"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator" %>
<%@page import="java.util.Set" %>
<%@page import="java.util.Map" %>
<%@page import="java.util.*"%>
<%@page import="hisglobal.utility.Entry"%>
<%@page import="hislogin.config.HISLoginConfig"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

	
<script type="text/javascript">


	var homeClick = function() {

		addTab('Home Menu', 'homemenuTabId');

	};


	function getLangList() {

		
		var url = "/UserMgmt_HIS/MultilingualServlet?mode=langlist&t=" + new Date().getTime();
		ajaxFunction(url, "2");

	}

	function getAjaxResponse(res, mode) {

		
		
		if (mode == "2") {
			document.getElementById("selectLanguage").innerHTML =  res;

			var  language = localStorage.getItem('language');

			if(language == null)
				language = "english";
			
			document.getElementById("selectLanguage").value = language;
			
			
		}
	}
</script>

<div class="header">
	<div class="headerImage">
		<img src="/HIS/hisglobal/images/headerImage.png">
	</div>
	<%
		String varMenuAssigned="";
		if(request.getSession().getAttribute(HISSSOConfig.SHOW_MENU)!=null && request.getSession().getAttribute(HISSSOConfig.SHOW_MENU).equals("0"))
			varMenuAssigned="none";
		String varAlertRoleAssigned="";
		if(request.getSession().getAttribute(HISSSOConfig.IS_ALERT_ROLE_ASSIGNED)!=null && request.getSession().getAttribute(HISSSOConfig.IS_ALERT_ROLE_ASSIGNED).equals("1"))
			varAlertRoleAssigned="";
					
	%>
	 <div class="logoutTag">
		<table>
		<tr style="height: 25px;">
		<td width="23%" style="display: <%=varMenuAssigned %>; ">
		<a><img width="20px" height="20px" src="/HIS/hisglobal/images/menuSearch.png" alt="Search Menu"
			 title="Search Menu" key-title="search-menu" onclick="searchMenu()" >
		</a>	 
		</td>
		<!-- Alert Added by Garima -->
		<td width="57%" id="tdAlert"  onclick="callMenu('/AHIMSG5/hislogin/transactions/jsp/myAlerts.jsp','Alert Desk')" style="display: <%=varAlertRoleAssigned %>; ">
		<img src="/HIS/hisglobal/images/alert_button.png" alt="Alert Desk" id="alertBellId"
			width="20px" height="20px" title="Alert Desk" key-title="alert-desk">
		</td>
		<!-- End Alert Tab-->
		
		<td width="20%" onclick="callMenu('/AHIMSG5/hislogin/transactions/jsp/strCircularList.jsp','Cirular Desk')"> 
		<img src="/HIS/hisglobal/images/circular.png" alt="Cirular Desk" id="alertBellId"
			width="20px" height="20px" title="Cirular Desk" key-title="cirular-desk">
			<span class="alertCount" id="alertCountId" title="Task Desk" key-title="task-desk"></span>
		</td>
		
		<td width="20%">
		<input type='hidden' id='bypassVal' value='1' />
		<img src="/HIS/hisglobal/images/logoutIcon.png" alt="logout"
			width="20px" height="20px" title="Logout"  key-title="logout" onclick="callLogOut(event)">	
		</td>
		</tr>
		</table>
	</div>

	<div class="headerMenu">
		<ul id="menu" style="border: 0; box-shadow: none; background: none;">

				<!-- <li id="lastSeenMenusIcon"><a href="https://uatphdmaha.dcservices.in/PHDM_MANUALS/phdmmanuals.html"  target="_blank"> <img src="/HIS/hisglobal/images/manual.png" width="23px"
				height="20px" alt="Last Seen" title="User Manual"></a>
				</li> -->
				 
				 <!-- Added by Anjali -->
				<li style="background: none; "><img src="/HIS/hisglobal/images/userManual301.png" width="20px"
				height="20px" alt="Last Seen" title="Manuals">
			 	 <%
		
		 StringBuffer str=new StringBuffer();
		 if(session.getAttribute(HISLoginConfig.LOGGEDIN_USER_SELECTED_MENU_PROCESS_LIST)!=null)
		 {
			 str.append(UserDeskUTL.generateManualList(session));	
			 //System.out.println("Manual list from here");
		 }else
			 str.append(" ");
		 		    
	%>  
				<div id= "manualdivId" class="dropdown_1column align_right" style="width:250px;">
					
				</div></li> 
				
		<!-- 	<li id="lastSeenMenusIcon"><a style="display:block;"> <img src="/HIS/hisglobal/images/lastSeenIcon.png" width="23px"  
				height="20px" alt="Last Seen" title="Last Seen"></a> 
				<div class="dropdown_1column align_right"> 
 					<div class="col_1"> 
						<h3>Last Seen</h3>
						
						<ul id="lastSeenMenusID"> 
 						</ul>
					</div> 
				</div></li>  -->
				
		<%-- 	<li><a style="display:none;" onclick="callMenu('/AHIMSG5/hislogin/transactions/jsp/st_desk_favourites_page.jsp','Favourites')"><img src="/HIS/hisglobal/images/starIcon.png" width="20px"
				height="20px" alt="favourites" title="Favourites"></a>
				<div class="dropdown_1column align_right">
					<div class="col_1">
						<h3>Favourites</h3>
						<ul>
							<%List<MenuMasterVO> lstFavMenus = (List<MenuMasterVO>) session.getAttribute(HISLoginConfig.LOGGEDIN_USER_FAVAOURITE_LIST); 
								Iterator favIterator= lstFavMenus.iterator();
								while(favIterator.hasNext()){
									MenuMasterVO voMenu= (MenuMasterVO)favIterator.next();
								%>
							<li><a onclick="callMenu('<%=voMenu.getVarURL()%>','<%=voMenu.getVarMenuName()%>')"
								style='cursor: pointer;'><%=voMenu.getVarMenuName()%></a></li>
							<%} %>
						</ul>
					</div>
				</div></li> --%>
			<li><img src="/HIS/hisglobal/images/settingsIcon.png" width="20px"
				height="20px" alt="settings" title="Settings" key-title="settings-1">
				<div class="dropdown_1column align_right">
					<div class="col_1">
						<h3><font color="black"><b><span key='settings'>Settings</span></b><font></h3>
						<ul>
							<li><a onclick="callMenu('/AHIMSG5/hislogin/initChangePasswordLgnFtr','Change Password')"><span key='change-password'>Change Password</span></a></li>
							<li><a onclick="callMenu('/AHIMSG5/hislogin/initChangeUserDetailsLgnFtr','Change User Details')"><span key='change-user-details' style="display:none;">Change User Details</span></a></li>
							<li><a onclick="callMenu('/AHIMSG5/hislogin/initAddUpdateMobileNoLgnFtr','Add/Update Mobile No')"><span key='add-update-mobile-no'>Add/Update Mobile No.</span></a></li>
							<li><a onclick="callMenu('/AHIMSG5/hislogin/initUserLogDetailsLgnFtr','User Log Report')"><span key='user-log-report'>User Log Report</span></a></li>
							<li><a onclick="showHomeTab()"><span key='home'>Home</span></a></li>
							
						</ul>
					</div>
				</div></li>		

		</ul>
	</div>
	
	<!-- <!--  Modal popup- Added by Anjali
	  <div id="myModal" class="modal">
	 
	 </div>  -->
    <div class="modal fade" id="myModal" role="dialog">
   <!--  <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
        <h4 class="modal-title" id="modal-title">Title here</h4>
         <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" id="myModalBody">
          Some content here
        </div>
        <div class="modal-footer">
           <button type="button" class="btn btn-default" data-dismiss="modal"><span key="close">Close</span></button>
        </div>
      </div>
      
    </div> -->
  </div>   
  
	
	
	<!-- <p id='expTime' style="position: absolute;margin-left: 45%;font-size: 18px;" ></p> -->
	
	<!-- Cash In Hand Dtl Added by Singaravelan on 02-Jun-2015-->
	<%
		String display="none",cashInHand="0.00";
		if(request.getSession().getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL)!=null && request.getSession().getAttribute(HISSSOConfig.SHOW_USERWISE_CASH_COLLECTED_DTL).equals("1"))
			display="";
		if(request.getSession().getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED)!=null)
			cashInHand=(String)request.getSession().getAttribute(HISSSOConfig.USERWISE_TOTAL_CASH_COLLECTED);
				
	%>
	
	<span id='normalMsg' style="display:none;" ></span>
                            <span key='language' style="color:white;">Language</span> 
                            <select name="selectLanguage" id="selectLanguage" onchange="setLanguage(this.value)"></select>
	
	<div class="welcomeTag">
		<span><span key='welcome-1'>Welcome,</span><s:property value="varUsrName" /></span>
		<div id="cashCollectedDiv" style="cursor:pointer; display:<%=display %>;"><font size='4 px' color='#F2BC34'><span key='cash-in-hand'>Cash in Hand : </span><img alt="Rs." src="/HIS/hisglobal/images/INR.png"/><%=cashInHand %></font></div>			
	</div>	
	<div class="dateTag" id="dateTdId" style="color:white;"></div>
		
		<input type="hidden" name ="varMenuAssigned"  value="<%=varMenuAssigned %>">
		 <input type="hidden" name ="varManual" id="varManual" value="<%=str%>"> 
	</div>
