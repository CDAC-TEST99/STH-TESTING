
<!doctype html>
<html class="no-js" lang="en">
<%@page import="org.json.JSONObject"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page import="hisglobal.vo.UserVO"%>

<%@page import="hislogin.transactions.utl.UserDeskUTL"%>
<%@page import="java.awt.Toolkit"%>
<%@page import="java.awt.Dimension"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page
	import="hissso.validation.credentails.authentication.AuthenticationCredentials"%>
<%@page import="vo.usermgmt.MenuMasterVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="hislogin.config.HISLoginConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page	import="hissso.validation.credentails.authorization.AuthorizationCredentials"%>
<%@page import="java.util.*"%>
<%@page import="hisglobal.utility.HisUtil"%>
<%@page import="hisglobal.utility.Entry"%>
<%@page import="vo.usermgmt.UserMasterVO"%>
<%@page import="application.filters.Base64Utils"%>


<head>
<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<META Http-Equiv="Cache-Control" Content="no-cache" />
	<META Http-Equiv="Cache-Control" Content="no-store" />
	<META Http-Equiv="Pragma" Content="no-cache" />
	<META Http-Equiv="Expires" Content="0" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="CGHS">
	<meta name="author" content="CDAC">
	<meta name="keywords" content="CGHS,HMIS,cdac">
	<meta name="keywords" content="CGHS,Central Government Health Scheme,Ministry of Health & Family Welfare,mohfw, cdac">
	
	
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store");
%>
	
	
	
<%
	UserMasterVO userVO = (UserMasterVO) request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);
	String key = (String) session.getAttribute(HISSSOServerConfig.LOGIN_TAB_KEY);
	
	String userId="";
	AuthorizationCredentials objAuthorize = (AuthorizationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
	AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
	String varSSOTicketGrantingTicket=  (String) request.getAttribute("varSSOTicketGrantingTicket");
	Map zeroLevelModules=null;
	int ellipseAfter=35;
	int ellipseAfterForSecondLevelMenu=35;
	if(objAuthorize!=null && objAuthorize.getMenusHirarchyMap()!=null){
		 userId=objAuthenticate.getVoUser().getVarUserId();
		  zeroLevelModules = objAuthorize.getMenusHirarchyMap();
	}
	JSONObject objContent =(JSONObject)request.getSession().getAttribute("content");
	
	if(objContent==null){
		objContent= new JSONObject();
		objContent.put("clientId", "0");
		objContent.put("sushrutlogo", "" + 
				"" + 
				""+
				"" 
				);
		objContent.put("clientName", "");
		objContent.put("clientShortName", "");		
		objContent.put("clientLogoImage", "/HIS/hisglobal/images/cghs_logo_big.png");
		
	}
	String clientShort=(String)session.getAttribute("CLIENT_SHORT_NAME");
	if(clientShort==null)
		clientShort="eSushrut-Clinic";
	
	String hospitalCode=session.getAttribute("HOSPITAL_CODE").toString();
%>
	

<title><%=clientShort %></title>
    
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link href="/HIS/hisglobal/images/e-clinic/img/icons/logo.ico" rel="icon"  type="image/x-icon">
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/aos/aos.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/css2.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/responsive.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.css">
    
        
    
      <script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"></script>
      <script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
      <script src="/HIS/hisglobal/cdac_awesome/js/popper.min.js"></script>
      <script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.js"></script>
      
      <script src="/HIS/hisglobal/cdac_awesome/js/menu.js"></script>
      <script src="/HIS/hisglobal/cdac_awesome/aos/aos.js"></script>
      <script src="/HIS/hisglobal/cdac_awesome/js/purecounter_vanilla.js"></script>
      <script src="/HIS/hisglobal/cdac_awesome/js/main.js"></script>
      <script src="/HIS/hisglobal/FormFlowX/js/commonFunctions.js"></script>
      
      
       <script src="/AHIMSG5/hislogin/transactions/js/md5.js"></script>
       <script src="/AHIMSG5/hislogin/transactions/js/security.js"></script>
      <script src="/AHIMSG5/hislogin/transactions/js/clientdesk.js"></script>
      
           
           <script type="text/javascript">
 
		    	function startTimer(){
		    		  			    	
		    	setInterval(function() {
 
		    	 
		    				  if(!checkURL('/AHIMSG5/hissso/sessionCheckLogin')) {
		    					    alert("Your session has expired. Kindly login again.")
		    				    	window.parent.document.forms[0].action = "logoutLogin" ;
		    				    	window.parent.document.forms[0].submit();
		    		  } 
		    			    
		    	 
		    			}, 930000); 
		    	
		    	}

		    	startTimer();
           
           </script>
           
           
    
</head>
<body>

<!-- Preloader Start -->
     <div id="preloader">
		  <div id="loader">   
		  </div>
		  <span class='midtext'><img src="/HIS/hisglobal/images/cghs_logo.png" ></span>
		</div>   
    <!-- Preloader Ends -->

   <nav class="navbar navbar-expand-lg navbar-light  bg-white w-100" style="padding: 0px;border-bottom: 1px solid #e0e0e0;">
	<div class="container-fluid" style='padding-left: 10px'>
	<a class="navbar-brand  mb-1" href="/AHIMSG5/hissso/Login" style="width: 50%;">
    	<div class="d-flex flex-row">
    		<div ><img src='/HIS/hisglobal/images/cghs_logo_big.png' style='width: 50%'></div>
    		
		</div>
    </a>
    
    	<% 
    			String clientHeading="";
    				 if(session.getAttribute("CLIENT_NAME") != null ){ 
    				 clientHeading=session.getAttribute("CLIENT_NAME").toString();
        			 if(session.getAttribute("HOSPITAL_NAME") != null &&  session.getAttribute("HOSPITAL_CODE") != null  
        			 &&  !session.getAttribute("CLIENT_CODE").toString().equals(session.getAttribute("HOSPITAL_CODE").toString()) ){
        				 clientHeading=clientHeading+ " | " + session.getAttribute("HOSPITAL_NAME").toString();
        				 
        				 
        				 }} 
        				 
        				 if(clientHeading.equals(""))
        					 clientHeading="C-DAC";
        				 
        				 %>
   
	
	<div style="text-align:right;width: 50%;" >
	<div style="float: right;" >&nbsp;&nbsp; 
	    <a type="button" class="btn btn-sm btn-success btnMenuClick" id="btnRefreshFrame" style="display:none;" title="Refresh Menu"><i class=" fas fa-arrows-rotate fa-fw" aria-hidden="true"></i></a>
	    <a type="button" class="btn btn-sm btn-primary btnMenuClick" style="display:none;" onclick="showMenuPage()" title="Home page"><i class="fas fa-house fa-fw" aria-hidden="true"></i></a>	 
	   <!-- &nbsp;<a  data-bs-toggle="dropdown" data-toggle="tooltip" data-placement="bottom" title="" class="menuButton btnMenuClick" data-bs-original-title="Refresh page" aria-label="Refresh page"><i class="fa-2x fas fa-arrows-rotate fa-fw" aria-hidden="true"></i></a>
		 &nbsp;<a id='btnHomePage' class="menuButton btnMenuClick" style="display:none;" data-bs-toggle="dropdown" data-toggle="tooltip" data-placement="bottom" title="" onclick="showMenuPage()" data-bs-original-title="Show home menus" aria-label="Show home menus"><i class="fa-2x fas fa-house fa-fw" aria-hidden="true"></i></a>&nbsp; -->
		</div> 	
		<div class='clientHeading' style="float: right" >&nbsp;@ &nbsp;<%=clientHeading %></div>
		<div class="dropdown" style="float: right;padding:0px">
			  <button class="btn  dropdown-toggle menutextusm" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false" style="font-size: 12px;padding: 0;">
			    <img src="/HIS/hisglobal/images/e-clinic/module_img/user.png" class="img-thumbnail" style="width: 30px;" >&nbsp;<s:property value="varUsrName" />&nbsp;
			  </button>
	  			<ul class="dropdown-menu  dropdown-menu-end" aria-labelledby="dropdownMenuButton">
					  <li class='userdropdownli'>
					  	<div class="text-center">
	                      	<h6 class='px-3 mb-2'>
	                      		<img src="/HIS/hisglobal/images/e-clinic/module_img/user.png" class="img-thumbnail rounded-circle" style="width: 80px;" >
	                      		
	                      			<%  if(userVO.getUserSeatsDtl() != null && userVO.getUserSeatsDtl().size() > 0){ 
	                      			
	                      			
	                      				if(userVO.getUserSeatsDtl().size() == 1 ){
	                      					
	                      					%>
	                      					 
	                      					
	    				 					<div> Role : <%=userVO.getUserSeatsDtl().stream().findFirst().get().getVarSeatName() %></div>
	    				
	    								<%
	                      					
	                      					
	                      				}else{
	                      					
	                      					%>
	                      					 
	                      					
	    				 					<div> Role : <%=userVO.getUserSeatsDtl().stream().filter(u -> u.getVarSeatId().equals(userVO.getVarUserSeatId()) ).findFirst().get().getVarSeatName() %></div>
	    				
	    								<%
	                      					
	                      				}
	                      				
	                      			 } %>
	                      		
	                      		
	                      		<div id='userName' class='userName'></div>
	                      	</h6>
	                      </div>
	                   </li>
	                   
	                   
	                   
					  <li class='userdropdownli'><a class="dropdown-item menutextusm menu" data-menuId='ChangeUserDetails' data-url='/AHIMSG5/hislogin/initChangeUserDetailsLgnFtr' title='Change User Details' href="#" style="display:none">Change User Details </a></li>
					  <li class='userdropdownli'><a class="dropdown-item menutextusm menu"  data-menuId='ChangePassword' data-url='/AHIMSG5/hislogin/initChangePasswordLgnFtr' title='Change Password' href="#">Change Password</a></li>
					
						<%  if(userVO.getUserSeatsDtl() != null && userVO.getUserSeatsDtl().size() > 1){ %>
					
					  <li class='userdropdownli'><a class="dropdown-item menutextusm" onclick="submitFormRole('/AHIMSG5/hissso/switchRoleLogin');"   title='Change Role' href="#">Change Role</a></li>
					
					<% } %>
					
					  <li class='userdropdownli' ><a class="dropdown-item btn" href="#"  id='btnlogout' onclick="callLogOut()"><span class='btn' style='width:100%'><i class='fas fa-right-from-bracket fa-fw'></i> &nbsp; &nbsp;Sign Out</span></a></li>				  
				  </ul>			    
	  
		</div> 
	</div>	
</div> <!-- container-fluid.// -->
</nav>
<div class="topbar"  data-aos="fade-right" ></div>

    <section class="p-0">
        
        <%
			String defaultMenuId= userVO.getVarMenuId();
    		String defaultMenuURL= "";
			boolean flagDefaultMenuExist=false;
			org.json.JSONArray arrModule= new org.json.JSONArray();
			org.json.JSONObject objModuleWiseIntermediateMenu= new org.json.JSONObject();
			org.json.JSONObject objModuleWiseLeafMenu= new org.json.JSONObject();
			
			if(zeroLevelModules!=null){
				Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
				for (Map.Entry set : moduleSet ) {
					org.json.JSONObject objModule= new org.json.JSONObject(); 
			  		//System.out.println("Key===" +set.getKey());
			  		String[] arrModData=set.getKey().toString().split("#");
			  		String moduleName=arrModData[0];
			  		
			  		String moduleNameWithoutSpace=moduleName.trim().replaceAll("\\s+", ""); 
			  		//System.out.println("moduleNameWithoutSpace===" +moduleNameWithoutSpace);
			  		String moduleImageName=(1 >= 0 && 1 < arrModData.length)?arrModData[1]:"/HIS/hisglobal/images/e-clinic/module_img/defaultHealthImage.png";
			  		String moduleDescription=(2 >= 0 && 2 < arrModData.length)?arrModData[2]:"" ;
			  		objModule.put("moduleName", moduleName);
			  		objModule.put("moduleNameWithoutSpace", moduleNameWithoutSpace);
			  		objModule.put("moduleImageName", moduleImageName);
			  		objModule.put("moduleDescription", moduleDescription);
			  		arrModule.put(objModule);
			  		
			  		if (set.getValue() instanceof HashMap) {
						HashMap columnHeadingMap=(HashMap)set.getValue();
						Set<Map.Entry> columnHeadingSet = columnHeadingMap.entrySet();
						for (Map.Entry columnHeadinigMapSet : columnHeadingSet) {
							//System.out.println( columnHeadinigMapSet.getKey().toString());
							String processType=columnHeadinigMapSet.getKey().toString();
							HashMap columnMapFirstLevel=(HashMap) columnHeadinigMapSet.getValue();
							Set<Map.Entry> columnFirstLevelSet = columnMapFirstLevel.entrySet();
						
					  		for (Map.Entry firstLevelSet : columnFirstLevelSet){
					  			org.json.JSONObject objJsonMenu= new org.json.JSONObject();
								String menuName=firstLevelSet.getKey().toString();
								String menuNameDisplay=menuName.length()>ellipseAfter?menuName.substring(0,ellipseAfter)+"...":menuName; ;
								String menuid=menuName.trim().replaceAll("\\s+", "");
								objJsonMenu.put("menuNameDisplay", menuNameDisplay);
								objJsonMenu.put("menuid", menuid);
								objJsonMenu.put("menuName", menuName);
								objJsonMenu.put("processType", processType);
								objJsonMenu.put("moduleName", moduleName);
								objJsonMenu.put("moduleNameWithoutSpace", moduleNameWithoutSpace);
								
								if(firstLevelSet.getValue()  instanceof String){
									//System.out.println("key===" + firstLevelSet.getKey() + " Value==" + firstLevelSet.getValue() );
									org.json.JSONObject leafJson=new org.json.JSONObject(firstLevelSet.getValue().toString());
									String font_icon_name=leafJson.getString("menuClassId")!=null && !leafJson.getString("menuClassId").equals("")?leafJson.getString("menuClassId"):"fas fa-file-medical";
									menuid=leafJson.getString("menuId");
										String url=leafJson.getString("url");
										if(defaultMenuId!=null && !defaultMenuId.equals("") && defaultMenuId.equals(menuid)){
											flagDefaultMenuExist=true;
											defaultMenuURL=url;
		  	   							}
										objJsonMenu.put("menuid", menuid);
										objJsonMenu.put("font_icon_name", font_icon_name);
										objJsonMenu.put("url", url);
										objJsonMenu.put("parentMenuId", "0");
										objModuleWiseLeafMenu.accumulate(moduleNameWithoutSpace, objJsonMenu);	
								}
								else if (firstLevelSet.getValue() instanceof HashMap) {
									HashMap columnMapSecondLevel=(HashMap) firstLevelSet.getValue();
									Set<Map.Entry> columnSecondLevelSet = columnMapSecondLevel.entrySet();
									objJsonMenu.put("font_icon_name", "fas fa-file-medical");
									objJsonMenu.put("url", "");
									objModuleWiseIntermediateMenu.accumulate(moduleNameWithoutSpace, objJsonMenu);
									 for (Map.Entry secondLevelSet : columnSecondLevelSet){
											//System.out.println("key===" + secondLevelSet.getKey().toString() + " Value==" + secondLevelSet.getValue() );
											org.json.JSONObject objJsonMenuLevel2= new org.json.JSONObject();
											 if(secondLevelSet.getValue()  instanceof String){
												org.json.JSONObject leafJsonsecondLevel=new org.json.JSONObject(secondLevelSet.getValue().toString());
												String font_icon_nameSecond=leafJsonsecondLevel.getString("menuClassId")!=null && !leafJsonsecondLevel.getString("menuClassId").equals("")?leafJsonsecondLevel.getString("menuClassId"):"fas fa-file-medical";
												String menuNameSecond=leafJsonsecondLevel.getString("menuName");
												String menuNameDisplaySecond=menuNameSecond.length()>ellipseAfter?menuNameSecond.substring(0,ellipseAfter)+"...":menuNameSecond; ;
												String menuIdSecond=leafJsonsecondLevel.getString("menuId");
												String url=leafJsonsecondLevel.getString("url");
												if(defaultMenuId!=null && !defaultMenuId.equals("") && defaultMenuId.equals(menuIdSecond)){
													flagDefaultMenuExist=true;
													defaultMenuURL=url;
			         	   						}
												
												objJsonMenuLevel2.put("menuNameDisplay", menuNameDisplaySecond);
												objJsonMenuLevel2.put("menuid", menuIdSecond);
												objJsonMenuLevel2.put("menuName", menuNameSecond);
												objJsonMenuLevel2.put("font_icon_name", font_icon_nameSecond);
												objJsonMenuLevel2.put("url", url);
												objJsonMenuLevel2.put("parentMenuId", menuid);
												objJsonMenuLevel2.put("processType", processType);
												objJsonMenuLevel2.put("moduleName", moduleName);
												objJsonMenuLevel2.put("moduleNameWithoutSpace", moduleNameWithoutSpace);
												objModuleWiseLeafMenu.accumulate(moduleNameWithoutSpace, objJsonMenuLevel2);	
											 }
									 }
								}
							}//for columnFirstLevelSet
						}// columnHeadingSet
			  		}// if
				}// for moduleSet
			} //if zeroLevelModules
			
       		 
       		
       		String isBen ="0";
       		
       		if(userVO != null && userVO.getVarIsBen() != null){
       			isBen = userVO.getVarIsBen();
       		}
				
	
      	%>
      	<span id='moduleJson' style="display:none;" ><%=arrModule.toString() %></span>
      	<span id='moduleListForListing' style="display:none;" ></span>
      <!-- 	<br/>======================objModuleWiseIntermediateMenu <br/>
      	 -->
      	<span id='moduleWiseIntermediateMenu' style="display:none;" ><%=objModuleWiseIntermediateMenu.toString() %></span>
      	
      	<!-- <br/>======================moduleWiseLeafMenu <br/> -->
      	
      	<span id='moduleWiseLeafMenu'  style="display:none;"><%=objModuleWiseLeafMenu.toString() %></span>
      	
      	<div id="divMainPageContainer" style="width: 99%;">
      	</div>	
            
                  
         </section>
         
         
  
          <s:form action="UserDesk"  id="UserDesk" method="POST">
  	<input type="hidden" name="varSSOTicketGrantingTicket" id='varSSOTicketGrantingTicket' value="<%=varSSOTicketGrantingTicket%>">
	<input type="hidden" name="varIsFirstTimeLogin" id="varIsFirstTimeLogin" value="<s:property value="varIsFirstTimeLogin" />">
	<input type="hidden" name="varUserName" id="varUserName" value="<s:property value="varUserName" />">
	<input type="hidden" name="userId" id="userId" value="<%=userId%>">
	<input type="hidden" name="hospitalCode" id="hospitalCode" value="<%=hospitalCode%>">
	<input type="hidden" name="varUsrName" id="varUsrName" value="<s:property value="varUsrName" />">
	<input type="hidden" name="selectedMenuUrl" id="selectedMenuUrl" value="<s:property value="varUsrName" />">
	<input type="hidden" name="selectedModuleId" id="selectedModuleId" value="">
	<input type="hidden" name="selectedModuleWiseMenu_open_with_pk" id="selectedModuleWiseMenu_open_with_pk" value="">
	<input type='hidden' name="isBen" id='isBen' value="<%= isBen %>"/>
	
	<span id='buttonHtmlPKBased' style="display:none;"></span>
	<%
		if(flagDefaultMenuExist==false){
			defaultMenuId="";	
			defaultMenuURL="";
		}
	%>
	<input type="hidden" name="defaultMenuId" id="defaultMenuId" value="<%=defaultMenuId%>">
	<input type="hidden" name="defaultMenuURL" id="defaultMenuURL" value="<%=defaultMenuURL%>">
	<input type="hidden" name="clientId" id="clientId" value="<%=objContent.get("clientId")%>">
	<input type="hidden" name="selectedModuleName" id="selectedModuleName" value="">

	
	
 </s:form>
 
 
 <div class="modal" tabindex="-1" id="modalFullScreen">
  <div class="modal-dialog modal-fullscreen">
    <div class="modal-content">
      <div class="modal-header" style="padding: 0;">
        <div class="d-flex bd-highlight " style="border-bottom: 1px solid #d0cccc;width: 100%;">
  			<div class="flex-grow-1 p-1 bd-highlight">
  				 <div class="row align-items-center">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11" style="padding-left: 25px;">
  						<img src='/HIS/hisglobal/images/cghs_logo_big.png' class='img-fluid'>
  					</div>	
  					<div class="col-lg-6 col-xl-6 col-md-4 col-sm-4 col-11" style="padding-left: 25px;">
  						<p class='menuModaltitle' id='modalMenuName'></p>
  					</div>	
  				</div>
  			</div>
  			<div class="p-1">
  			<button type="button" id='closeFullScreenModal' class="float-end mt-2 btn btn-sm btn-danger" data-bs-dismiss="offcanvas" onclick="closeFullScreenModal()">Close</button>
  			<!-- <button type="button" id='closeFullScreenModal' class="float-end mt-2 btn btn-sm btn-danger"  onclick="closeFullScreenModal()">Close</button> -->
  			</div>
  		</div>
      </div>
      <div class="modal-body">
      	<iframe src=""  id="iframeModalFullScreen" style="width: 100%;height: 100%"></iframe>
     </div>
    </div>
  </div>
</div>
 
 
   
            
</body>
</html>