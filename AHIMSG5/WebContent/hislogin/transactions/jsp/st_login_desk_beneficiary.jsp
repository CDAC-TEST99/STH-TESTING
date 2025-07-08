
<!doctype html>
<html class="no-js" lang="en">
<%@page import="org.json.JSONObject"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

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
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Cache-Control" Content="no-store" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="eSushrut@Clinic">
	<meta name="author" content="CDAC">
	<meta name="keywords" content="eSushrut,Clinic,eSushrut@Clinic, cdac">
	
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
		  //System.out.println("zeroLevelModules>>>>" + zeroLevelModules);
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
	

    <meta content="width=device-width, initial-scale=1" name="viewport" />     
    <title>Central Government Health Scheme</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<!--     <link href="/HIS/hisglobal/cdac_main/images/logo.jpg" rel="icon">
    <link href="/HIS/hisglobal/cdac_main/css/style.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_main/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet"    href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/fontawesome.min.css"> -->
    
    
    
    <link href="/HIS/hisglobal/images/e-clinic/img/icons/logo.ico" rel="icon"  type="image/x-icon">
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/aos/aos.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/css2.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/desk.css" rel="stylesheet">
    
    
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
        
        <script src="/AHIMSG5/hislogin/transactions/js/beneficiaryDesk.js"></script>
      
           
           <script type="text/javascript">
           		

           		function initMenuListing(){
					var moduleWiseLeafMenu =$('#moduleWiseLeafMenu').html();
					if(moduleWiseLeafMenu!=""){
						moduleWiseLeafMenu=JSON.parse(moduleWiseLeafMenu);
						$('#divMainContainer').html("<div class='row'>");
						/* $.each(moduleWiseLeafMenu,function(key, jsonArr){
							$.each(jsonArr, function(indx, objMenu){
								var moduleName=objMenu["moduleName"];
								var <div class="col-lg-2 col-md-3 col-sm-6 col20">
		                        <div class="info-box" title="OPD Income">
	                            <a href="https://demo.smart-hospital.in/admin/patient/search">
	                                <span class="info-box-icon bg-green"><i class="fas fa-stethoscope"></i></span>
	                                <div class="info-box-content">
	                                    <span class="info-box-text">OPD Income</span>
	                                    <span class="info-box-number">₹8,175.60</span>
	                                </div>
	                            </a>
	                        </div>
	                   </div>
	                   
   		
	    		
								$('#divMainContainer').append()

							}); 

						});*/

					}

               	}
           		
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
           
           
    
<style>
 

 
    </style>
    
</head>

<body>

<!-- Preloader Start -->
     <div id="preloader">
		  <div id="loader">   
		  </div>
		  <span class='midtext'><img src="/HIS/hisglobal/images/cghs_logo.png" ></span>
		</div>   
    <!-- Preloader Ends -->
   <div id="topbar" class="container-fluid">&nbsp;</div>
   <nav class="navbar navbar-expand-lg navbar-light  bg-white w-100" style="padding: 10px;border-bottom: 1px solid #e0e0e0;z-index:999;">
	<div class='row' style="width: 100%;">
	<div class='col-lg-3 col-md-12 col-sm-12 col-12 ' style="padding-left: 27px;">
	<a class="navbar-brand" href="/AHIMSG5/hissso/Login">
    	<img src='/HIS/hisglobal/images/cghs_logo_big.png' style='width:100%'>    	
    </a>
    </div>
    
    	
    <div class='col-lg-5 col-md-12 col-sm-12 col-12 ' style="text-align: center;">
    		<span class='clientHeading'>beneficiary</span>			
	</div>
	<div class='col-lg-2 col-md-4 col-sm-4 col-4 ' style="text-align: right;padding-top: 14px;">
  				<button type="button" class="btn-his-sm " id='btnShowMenu' style="display: none;" onclick="showHideMenuPage(1)" title="Menus" ><i class='fa-classic fa-solid fa-bars fa-xl'></i></button>
  				<button type="button" class="btn-his-sm"  style="display: none;" id="btnRefreshFrame"  title="Refresh Page"><i class='fa-classic fa-solid fa-arrows-rotate fa-xl'></i></button>
  				<button type="button" class="btn-his-sm"  style="display: none;" id='btnShowIFrame' title='Show Current Open' onclick="showHideMenuPage(0)" ><i class='fa-classic fa-regular fa-circle-left fa-xl'></i></button>
	</div>
    <div class='col-lg-2 col-md-8 col-sm-8 col-8' style="text-align: right;padding-top: 14px;">
		<div class="dropdown" >
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
	                   
	                   
	                   
					  <li class='userdropdownli'><a class="dropdown-item menutextusm menu" onclick="openLeafMenu();" data-menuId='ChangeUserDetails' data-url='/AHIMSG5/hislogin/initChangeUserDetailsLgnFtr' title='Change User Details' href="#" style="display:none">Change User Details </a></li>
					  <!-- <li class='userdropdownli'><a class="dropdown-item menutextusm menu" data-menuId='ChangePassword' data-url='/AHIMSG5/hislogin/initChangePasswordLgnFtr' title='Change Password' href="#">Change Password</a></li> -->
					  <li class='userdropdownli'><a class="dropdown-item menutextusm" onclick="submitChangePass('/AHIMSG5/hislogin/initChangePasswordLgnFtr');"   title='Change Password' href="#">Change Password</a></li>
						<%  if(userVO.getUserSeatsDtl() != null && userVO.getUserSeatsDtl().size() > 1){ %>
					
					  <li class='userdropdownli'><a class="dropdown-item menutextusm" onclick="submitFormRole('/AHIMSG5/hissso/switchRoleLogin');"   title='Change Role' href="#">Change Role</a></li>
					
					<% } %>
					
					  <li class='userdropdownli' ><a class="dropdown-item btn" href="#"  id='btnlogout' onclick="callLogOut()"><span class='btn' style='width:100%'><i class='fas fa-right-from-bracket fa-fw'></i> &nbsp; &nbsp;Sign Out</span></a></li>				  
				  </ul>			    
	  
		</div> 
		</div>
		 
		
		
		</div>
		
	

</nav>
	<div class='ifcontainer'   id='divForIframe_1' >
		<iframe  src='' class='iframecss'  wmode='transparent' frameborder='0' id='iframecss_1'></iframe>
	</div>
	<section class="p-0"  id='display:none' id='sectionallbenIds'>
		<div class='row mt-4' id='allbenIds'>
		</div>
	</section>
    <section class="p-0" id='sectionModules' id='display:none'> 		
 		<div class='row'>
 		<!-- side ben photos here -->
	    <div class='col-1 d-none d-md-block' id='modules' style="border-right: 1px solid #e0e0e0;">
	    </div>
	    <!-- side ben photos here ends-->
	    <!-- detail section  starts here -->
	    <div class='col-lg-11 col-md-12 col-sm-12 col-12 '>
	    	<div class='container-fluid'  id='divDeskListingContainer'  style="display: none;"></div>
	    	<div class='container-fluid mt-3 mb-2 d-block d-md-none' id='benlist' >
	    		<label> Select Beneficiary</label>
	    		<select class="form-select" id="moduleId" name="moduleId">
				  
				</select>
	    	</div>
	    	<div class='container-fluid' >
	    		<div class="card">
                    <div class="card-body pt-3" id='benDtl' style="width: 100% !important">
                        	
                    </div>
                </div>
	    	</div>
	    	<div class='container-fluid'  style="padding-right: 35px;">
	    	<div id="mainContainer" class='row moduleContainer'>
	    		
		    </div>
		    </div>
	    	</div>
	    </div>
	    <!-- detail section  ends here -->	    	
  	  
    </section>    
        <%
			String defaultMenuId= userVO.getVarMenuId();
    		String defaultMenuURL= "";
			boolean flagDefaultMenuExist=false;
			org.json.JSONArray arrModule= new org.json.JSONArray();
			org.json.JSONObject objModuleWiseIntermediateMenu= new org.json.JSONObject();
			org.json.JSONObject objModuleWiseLeafMenu= new org.json.JSONObject();
			//int totalNoOfMenuLeaf=0;
			if(zeroLevelModules!=null){
				Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
				//System.out.println("moduleSet>>>>" + moduleSet);
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
			  		//int noOfLeafNodeInModule=0;
			  		
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
									String font_icon_name=leafJson.getString("menuClassId")!=null && !leafJson.getString("menuClassId").equals("")?leafJson.getString("menuClassId"):"";
										menuid=leafJson.getString("menuId");
										String url=leafJson.getString("url");
										//noOfLeafNodeInModule++;
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
									objJsonMenu.put("font_icon_name", "");
									objJsonMenu.put("url", "");
									objModuleWiseIntermediateMenu.accumulate(moduleNameWithoutSpace, objJsonMenu);
									 for (Map.Entry secondLevelSet : columnSecondLevelSet){
											//System.out.println("key===" + secondLevelSet.getKey().toString() + " Value==" + secondLevelSet.getValue() );
											org.json.JSONObject objJsonMenuLevel2= new org.json.JSONObject();
											 if(secondLevelSet.getValue()  instanceof String){
												org.json.JSONObject leafJsonsecondLevel=new org.json.JSONObject(secondLevelSet.getValue().toString());
												String font_icon_nameSecond=leafJsonsecondLevel.getString("menuClassId")!=null && !leafJsonsecondLevel.getString("menuClassId").equals("")?leafJsonsecondLevel.getString("menuClassId"):"";
												String menuNameSecond=leafJsonsecondLevel.getString("menuName");
												String menuNameDisplaySecond=menuNameSecond.length()>ellipseAfter?menuNameSecond.substring(0,ellipseAfter)+"...":menuNameSecond; ;
												String menuIdSecond=leafJsonsecondLevel.getString("menuId");
												String url=leafJsonsecondLevel.getString("url");
												//noOfLeafNodeInModule++;
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
												objJsonMenu.accumulate("MenuLevel2",objJsonMenuLevel2);
											 }
									 }
								}
								objModule.accumulate("MenuLevel1", objJsonMenu);
								
							}//for columnFirstLevelSet
					  		
						}// columnHeadingSet
			  		}// if
			  		
			  		//objModule.put("noOfLeafNodeInModule", noOfLeafNodeInModule); 
			  						
			  		arrModule.put(objModule);
				}// for moduleSet
			} //if zeroLevelModules
			
		//System.out.println("arrModule>>" + arrModule.toString());		
	
      	%>
      	
      	<span id='moduleJson' style="display:none;" ><%=arrModule.toString() %></span>
      	<span id='deskIntermediateMenuList' style="display:none;" ></span>
         
         <div class="container-fluid" id='allIframeContainer' style="display: none;padding-left: 14px;padding-right: 23px;">
</div>
  
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
	<input type="hidden" name="selectedMenuJson" id="selectedMenuJson" value="">
	
	
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
	<input type="hidden" name="selectedBenId" id="selectedBenId" value="">
	
	
	
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