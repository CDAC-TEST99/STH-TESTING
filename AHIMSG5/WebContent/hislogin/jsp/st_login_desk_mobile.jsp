
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
	int ellipseAfter=25;
	int ellipseAfterForSecondLevelMenu=20;
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
	String clientShort=session.getAttribute("CLIENT_SHORT_NAME").toString();
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
    
        
</head>
<body>
 <!-- Preloader Start -->
 <div id="preloader">
  <div id="loader">   
  </div>
  <span class='midtext'><img src="/HIS/hisglobal/images/e-clinic/img/eshurut_clinic_logo_shiled.png" ></span>
</div>   
    <!-- Preloader Ends -->

    <div class="wrapper"> 
        <!-- Start of header area -->
        <header class="header-area header-wrapper">
            <div class="container-fluid" id="sticky-header" ">
                <div class=" full-width-mega-dropdown">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-xl-2 col-md-3 col-sm-5 col-5"> 
                    <a href="/AHIMSG5/hissso/Login">
                            <div class="logo"> 
                            <img src='<%=objContent.getString("clientLogoImage") %>' class='img-fluid'> </div> 
                            
                            
                            
                        </a> </div>
                        <div class="col-lg-6 col-xl-7 col-md-8 col-sm-5 col-5  d-flex align-items-center d-none d-sm-block d-lg-block d-md-block d-xl-block">
                        	<% if(clientShort != null ){ %>    
	    						&nbsp; <span class='eshusrut-brandName-color'> <%= clientShort%></span>
		         				<% if(session.getAttribute("HOSPITAL_NAME") != null &&  session.getAttribute("HOSPITAL_CODE") != null  &&  !session.getAttribute("CLIENT_CODE").toString().equals(session.getAttribute("HOSPITAL_CODE").toString()) ){ %>
		    							&nbsp; <span class='eshusrut-brandName-color'> | </span> <span class='eshusrut-brandName-color'> <%=session.getAttribute("HOSPITAL_NAME").toString() %></span>	 
		    					<% } %>
		    				<% } %>
                        </div>
                    <%-- <div class="col-lg-9 col-xl-7 col-md-1 col-1 d-flex justify-content-end">
                        <nav id="primary-menu">
                            <ul class="main-menu menu-eff">
                                <li class="active"><a href="/AHIMSG5/hissso/Login"><span></span> <span>Home</span></a></li>
                                <li><a href="#aboutcdac"><span></span> <span>About Us</span></a></li>
                                <li><a href="#features"><span></span> <span>Features</span></a></li>
                                <li><a href="#quotation"><span></span> <span>Services</span></a></li>
                                <!-- <li><a href="pricing.html"><span></span> <span>Pricing</span></a></li> -->
                                <li><a href="#clientele"><span></span> <span>Our Clients</span></a></li>
                               
                            </ul>
                        </nav>
                    </div> --%>
                     <div class="col-lg-2 col-xl-3 col-md-1 col-sm-6 col-6  d-flex align-items-center justify-content-end">
	                    <div class="dropdown">
							  <button class="buttons px-4 py-2 mt-0 dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
							   Welcome <s:property value="varUsrName" />
							  </button>
							  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							    <li><a class="dropdown-item" href="#">Change User Details</a></li>
							    <li><a class="dropdown-item" href="#">Change Password</a></li>
							    <li><a class="dropdown-item" href="#"><span class='btn buttons' style='width:100%'><i class='fas fa-right-from-bracket fa-fw'></i> &nbsp; &nbsp;Sign Out</span></a></li>
							  </ul>
						</div>
					</div>
					<div class="col-sm-12 col-12  d-flex align-items-center d-block d-sm-none d-lg-none d-md-none d-xl-none" style="text-align: center;">
                        	<% if(clientShort != null ){ %>    
	    						&nbsp; <span class='eshusrut-brandName-color'> <%= clientShort%></span>
		         				<% if(session.getAttribute("HOSPITAL_NAME") != null &&  session.getAttribute("HOSPITAL_CODE") != null  &&  !session.getAttribute("CLIENT_CODE").toString().equals(session.getAttribute("HOSPITAL_CODE").toString()) ){ %>
		    							&nbsp; <span class='eshusrut-brandName-color'> | </span> &nbsp; <span class='eshusrut-brandName-color '> <%=session.getAttribute("HOSPITAL_NAME").toString() %></span>	 
		    					<% } %>
		    				<% } %>
                        </div>
                   <!--  <div
                        class="col-lg-12 col-xl-3 col-md-5 col-sm-6 col-6  d-flex align-items-center justify-content-end">                        
                        <div class="buttons px-4 py-2 mt-0"><a style="cursor: pointer"><i class="fa-solid fa-user-tie"></i></a></div>
                    </div> -->
                </div>
            </div>
    </div>
    </header>
    <section class="p-0">
        <div class="modulesection p-1">
        <%
			String defaultMenuId= userVO.getVarMenuId();
			boolean flagDefaultMenuExist=false;
			if(zeroLevelModules!=null){
				Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
	
      	%>
          <div class="row align-items-center mt-3">
          	<%int i=0;
				  	for (Map.Entry set : moduleSet ) {
				  		
				  		//System.out.println("Key===" +set.getKey());
				  		String[] arrModData=set.getKey().toString().split("#");
				  		String moduleName=arrModData[0];
				  		
				  		String moduleNameWithoutSpace=moduleName.trim().replaceAll("\\s+", ""); 
				  		//System.out.println("moduleNameWithoutSpace===" +moduleNameWithoutSpace);
				  		String moduleImageName=(1 >= 0 && 1 < arrModData.length)?arrModData[1]:"/HIS/hisglobal/images/e-clinic/module_img/defaultHealthImage.png";
				  		String moduleDescription=(2 >= 0 && 2 < arrModData.length)?arrModData[2]:"" ;
			%>
          
          
          
                  <div class=" col-xl-1 col-lg-1 col-md-2 col-sm-2 col-4 modcol mb-4 "  id='module_<%= moduleNameWithoutSpace%>'> 
                  		<div  class="row ">
			  			 <div  class="col-12 text-center"> 
				  			  <span class='modbox'>
				  					<img src='<%= moduleImageName%>' />
				  			  </span>
			  			  </div>
			  			  <div  class="col-12 mt-3 text-center modtext ">
			  			  	<%=moduleName %>
			  			  </div>		
			  			</div>
              	  </div>
              	  
              	   <% }// for ends
	  	} // if ends%>  
	         </div>       
        </div>
         <div class="recentmenusection p-1">
         	recent menu here
         </div>
         
         
          		
				<%
					if(zeroLevelModules!=null){
						Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
			        	int i=0;
			          	for (Map.Entry set : moduleSet ) {
			          		//System.out.println("Key===" +set.getKey());
	          	    		String[] arrModData=set.getKey().toString().split("#");
	          	     		String moduleName=arrModData[0];
	          	     		String moduleNameWithoutSpace=moduleName.trim().replaceAll("\\s+", ""); 
	          	     		//System.out.println("moduleNameWithoutSpace===" +moduleNameWithoutSpace);
	          	     		String moduleImageName=(1 >= 0 && 1 < arrModData.length)?arrModData[1]:"/HIS/hisglobal/images/e-clinic/module_img/defaultHealthImage.png";
	          	     		String moduleDescription=(2 >= 0 && 2 < arrModData.length)?arrModData[2]:"" ;
	          	     	%>
	          	     	<div class='row'  id='moduledtl_<%=moduleNameWithoutSpace %>' >
			          		<div class='col-12' >
								<div class='row align-items-center modulesection'>
									<div class='col-xl-1 col-lg-1 col-md-2 col-sm-2 col-4 m-2' > 
										<div class='w-100'>
										<img src="<%=moduleImageName %>" class="imgmoduleicon" >
										</div>
										<div class='w-100 text-center'>
										<%=moduleName %>
										</div>
									</div>	
									<div class='col-xl-8 col-lg-8 col-md-7 col-sm-7 col-7 mb-4 ' >	
										<%=moduleDescription %>
									</div>
								</div>
								<div class='row align-items-center'>
										<div class='col-12 module_menu' id='modMenu_<%=moduleNameWithoutSpace %>' >
										<div class="row menusection p-2">
										<%
										if (set.getValue() instanceof HashMap) {
											HashMap columnHeadingMap=(HashMap)set.getValue();
											Set<Map.Entry> columnHeadingSet = columnHeadingMap.entrySet();
											for (Map.Entry columnHeadinigMapSet : columnHeadingSet) {
												//System.out.println( columnHeadinigMapSet.getKey().toString());
												String processType=columnHeadinigMapSet.getKey().toString();
												HashMap columnMapFirstLevel=(HashMap) columnHeadinigMapSet.getValue();
												Set<Map.Entry> columnFirstLevelSet = columnMapFirstLevel.entrySet();
												%>
												
											<%-- 	<div class="col-12 p-1">
													<h6 class="modtxt float-start"><%=processType %> </h6>
												</div> --%>
												
														<%
														for (Map.Entry firstLevelSet : columnFirstLevelSet){
															String menuName=firstLevelSet.getKey().toString();
															String menuNameDisplay=menuName.length()>ellipseAfter?menuName.substring(0,ellipseAfter)+"...":menuName; ;
															String menuid=menuName.trim().replaceAll("\\s+", "");
															if(firstLevelSet.getValue()  instanceof String){
																//System.out.println("key===" + firstLevelSet.getKey() + " Value==" + firstLevelSet.getValue() );
																org.json.JSONObject leafJson=new org.json.JSONObject(firstLevelSet.getValue().toString());
																String font_icon_name=leafJson.getString("menuClassId")!=null && !leafJson.getString("menuClassId").equals("")?leafJson.getString("menuClassId"):"fas fa-file-medical";
																menuid=leafJson.getString("menuId");
						   										String url=leafJson.getString("url");
						   										if(defaultMenuId!=null && !defaultMenuId.equals("") && defaultMenuId.equals(menuid)){
						   											flagDefaultMenuExist=true;
							          	   						}
						   										%>
						   										<div class=" col-xl-1 col-lg-1 col-md-2 col-sm-2 col-4 modcol mb-4 " title='<%=menuName %>' data-url='<%=url %>' data-menuId="<%=menuid%>"> 
											                  		<div  class="row ">
														  			 <div  class="col-12 text-center"> 
															  			  <span class='modbox'>
															  					<i class="<%=font_icon_name %> fa-fw fa-2x mt-1" aria-hidden="true" ></i>
															  			  </span>
														  			  </div>
														  			  <div  class="col-12 mt-4 text-center modtext ">
														  			  	<%=menuNameDisplay %>
														  			  </div>		
														  			</div>
														  		</div>	
						   									<%}// if ends
						   									
						   								}// for columnFirstLevelSet ends
														
														%>
													
														
												<%
												
											}// for columnHeadingSet ends 
										}
										%>
									</div>	
								</div>
							</div>
						</div>
									
								</div>
			          	     		
			          	     	<%	
			          	     
			          	     	}// for moduleSet sends
							}// if zeroLevelModules ends
							
							%>
						
						
			
       
          
         </section>
         </div>
         
  
                
            
            <!-- jquery latest version -->
            <script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/js/popper.min.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/js/menu.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/aos/aos.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/js/purecounter_vanilla.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/js/main.js"></script>
            <script type="text/javascript">
				
				$(document).ready(function() {
					 $('#preloader').delay(450).fadeOut('slow');
					 $( "button" )
						.click(function( event ) {
						event.preventDefault();
						});
						$( "input[type=button], button" )
							.click(function( event ) {
							event.preventDefault();
						});
					$('.modcol').click(function(){
						$('.modcol').removeClass("active");
						$(this).addClass("active");
						
					});
						
					
				});
							
			</script>
            
</body>
</html>