<%@page import="hisglobal.security.SecureHashAlgorithm"%>
<%@page import="hisglobal.utility.SecurityUtil"%>
<%@page import="hisglobal.config.HISConfig"%>

<%@page import="hissso.config.HISSSOServerConfig"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<!doctype html>
<html class="no-js" lang="en">
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

    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet"> 
    <title>CGHS</title>
    <title>Central Government Health Scheme</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HIS/hisglobal/cdac_main/images/logo.jpg" rel="icon">
    <link href="/HIS/hisglobal/cdac_main/css/style.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_main/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/fontawesome.min.css">

</head>
<body>	



<nav class="navbar navbar-expand-lg navbar-light  bg-white w-100" style="padding: 0px;border-bottom: 1px solid #e0e0e0;">
	<div class="container-fluid" style='padding-left: 10px'>
	<a class="navbar-brand  mb-1" href="/AHIMSG5/hissso/Login" style="width: 50%;">
    	<div class="d-flex flex-row">
    		<div ><img src='/HIS/hisglobal/images/cghs_logo_big.png' style='width: 50%'></div>
    		
		</div>
    </a>
   </div>
   </nav> 
    <div id="slider" class="position-relative mt-2">
        <div class="container-fluid position-absolute start-0 end-0  main-menu px-md-3 mt-3">
        </div>
        <div class="slider-one">
            <div class="slider-seat-image">           
            
            
            </div>
            
            
        </div>



   


<div class="container-fluid position-absolute mt-2" id="seatBox">
        <div class="row">
            
             <div class="col-md-12 col-xl-12 col-12 p-0  mt-5">
                
              <!-- =============================start -->
                
                
		<div class="modal-content modal-content-bg">
            <div class="modal-body" style="height: 50%;">
                <div class='row'>
             		<div class='col-md-12 col-xl-6 welcomebg' >
             			<div class='row mt-5'>
							 		<div class="col-12 text-center mt-3">
							 			<img src="/AHIMSG5/hissso/portal/images/logo.jpg"  style='width:75px;'>
							 		</div>							 	
							 		<div class="col-12 text-center mt-1">
							 			<h1 class="mb-4 text-warning">Welcome to <br/> CGHS Beneficiary Login</h1>
							 			<h5 class="text-center mb-4 text-white">Please Sign-In to Access Your Account</h5>
							 		</div>
							 		
							 	</div>	
             		</div>
             		<div class='col-md-12 col-xl-6'>
                
                
                       <form method="post">
							<section class="p-0 mt-5" style="width: 81%;margin-left:30px;">								
							 <div class="modal-body" style="height: 50%;">
              					  
                <nav>
                    <div class="nav nav-tabs mb-3" id="nav-tab" role="tablist">
                        <% 
                     if(session.getAttribute("mstatus") == null || session.getAttribute("mstatus").toString().trim().length() == 0){     %>
                    
                        <button class="nav-link active" id="nav-user-tab" data-bs-toggle="tab" data-bs-target="#navUser" type="button" role="tab" aria-controls="navUser" aria-selected="false">Ben. Login</button>
                         	<% } %>
                         <% 
                   if(session.getAttribute("BenMobileNumber") == null || session.getAttribute("BenMobileNumber").toString().trim().length() == 0){   
                	   //System.out.println("inside 789");
                	   %>
                  
                        <button class="nav-link" id="nav-mobile-tab" data-bs-toggle="tab" data-bs-target="#navMobile" type="button" role="tab" aria-controls="navMobile" aria-selected="true">Mobile Login</button>
						<% } %>
						
                    </div>
                </nav>
				
                <div class="tab-content" id="nav-tabContent">

    <!-- User Login Tab --> 
     <% 
      if(session.getAttribute("mstatus") == null || session.getAttribute("mstatus").toString().trim().length() == 0){  %> 
    
                    <div class="tab-pane fade-tab active show" id="navUser" role="tabpanel" aria-labelledby="nav-user-tab">
             <%--        <% if ( session.getAttribute("LoginError") != null) {
                    	session.removeAttribute ("LoginError");
                    	}  %> --%>
                    
                       <s:form action="beneficiaryloginLogin" method="post" id="loginForm" class="form">
                        <% if(request.getSession().getAttribute("otpValidationKey") != null && request.getSession().getAttribute("otpValidationKey").toString().length() > 0 && request.getSession().getAttribute("BenUserLogin") != null ){  %>
                      		<div class="row justify-content-center mb-3">
					
							       <div class="col-12">
	                               		<div class="group" style="display: none;">
	                               			<i class="fas fa-mobile icon" ></i>
	                               			
	                               			<input class="input" type="text"  readonly name="varUserId" id="varUserId" value="<%=request.getSession().getAttribute("otpValidationKey").toString() %>"  placeholder="Enter Email Id / User Id" maxlength="50" data-validation="mandatory">
	                               		 	</div>                                   
                               		 </div>
							   <div class="col-12">
	                               		<div class="group" style="display: none;">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" type="text" readonly name="varMobileNumber" value="<%=request.getSession().getAttribute("otpValidationKey").toString() %>"  placeholder="Enter Mobile No." maxlength="10" data-validation="mandatory,mobile">
										</div>                                   
                               		 </div>
							    </div>
							    
							     <div class="row justify-content-center mb-3" id="mobileNumId" style="display: ;">
							    	<div class="col-12">
	                               		<div class="group">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" readonly name="mobileNum" id="mobileNum" value= <%= "******" +(session.getAttribute("BenMobileNumber") ).toString().substring((session.getAttribute("BenMobileNumber") ).toString().length() - 4) %>  data-validation="mandatory,positiveNumeric">
										</div>                                   
                              		 </div>
                              		 <!-- ReferenceNumber -->
							       
							    </div>
							    
							    
							     <div class="row justify-content-center mb-3" id="otPRow" style="display: ;">
							    	<div class="col-12">
	                               		<div class="group">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" type="password" name="varOtp" id="varOtp" placeholder="Enter OTP" maxlength="6" data-validation="mandatory,positiveNumeric">
										</div>                                   
                              		 </div>
							         <div><%= (session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? "Reference No : "+session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")).toString() : "" ) %></div>
							       
							    </div>
							    
							    <div class="row justify-content-center mb-3" id="otPRow" style="display: ;">
							    	<div class="col-6">
	                               		<div style="text-align: right;margin-top: 8px;color:blue;" id="countDownOTP"></div> 
	                               		   
	                               		<div id='otpCountValId' style="display: none;"><%= (session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString() : "0" ) %></div>                        		                                  
                              		 </div>
                              		 
                              		 <div class="col-6">
	                               		  <button class="btn-his"  id="resendButton" onclick="submitLoginForm1('mbenloginLogin',event);">Resend OTP</button>                  
                              			 <div id='otpCountDisplay'></div>	
                              		 </div>
							    </div>
							    <div class="text-center">
										 <button class="btn-his"   id="validateButton" onclick="submitFormOnValidateOtp1(submitValidateOtpUserLogin(),'beneficiaryloginLogin');" >Submit OTP</button>
										<button class="btn-his-outline" type="button"   style="width: 30%;"  tabindex="4" value="Home" id="loginid" onclick="return submitFormOnValidate(true,'Login');">Home</button>
																		  
																	  
		                                <input type="hidden" name="sessionLoginToken"	value='<%=session.getAttribute("sessionLoginToken")%>'>
									 
										<input type="hidden" name="x-auth-token" id="x-auth-token" value="<%=SecureHashAlgorithm.generateRandom(request)%>" />	
									</div>	
                      
                      <% } 
							else{  %>
                       <div class="row justify-content-center mb-3">
                                <div class="col-12">
                                	<p class="text-primary">Main Card Holder Ben. Id Only</p>
                               		<div class="group">
                               			<i class="fas fa-user icon" ></i>
										<input class="input" type="text" name="varUserName" oninput="this.value = this.value.replace(/[^0-9]/g, '')" id="varUserName" maxlength="10" placeholder="Enter BEN. ID" required autocomplete="off" data-validation="mandatory,positiveNumeric">
									</div>                                   
                                </div>
                            </div>
                       			

							<div class="row justify-content-center mb-3">
                                <div class="col-12">
                                	<div class="group">
                               			<i class="fa-solid fa-lock icon" ></i>
										<input class="input" type="password" name="varPassword" id="varPassword" maxlength="50" placeholder="Enter Password"  data-msg="Please enter at least 4 chars"  required autocomplete="off">
									</div> 
                                </div>
                            </div>
									

                                  
						<%	if (HISConfig.CAPTCHA_IMPLEMENTATION.equals("ON")) {%>
									     
									     
							  <div class="row justify-content-center mb-3">
							  <div class="col-3 group">
									<div id='captchaDiv' class="captcha" style="margin-right: -55px;">
										<img id="imageid" name='captchaImg' src="/AHIMSG5/hissso/captchaLogin" style='width:55%;height: 42px;border-radius: 10px;'> 
										<i class="fas fa-refresh text_captcha" aria-hidden="true" onclick="document.forms[0].captchaImg.src='/AHIMSG5/hissso/captchaLogin'+'?id='+Math.random();refreshTxtBox();"></i>
									</div>
								</div>	
                                <div class="col-9">
                                	<div class="group">
                               			<i class="fa-solid fa-equals icon" ></i>
										<input class="input" oninput="this.value = this.value.replace(/[^0-9]/g, '')" type="text" name="captchaResponse" id="captchaResponse" maxlength="3" placeholder="Enter Captcha"   required autocomplete="off">
									</div> 
								</div>	
								
                                    
                                   
                                
                            </div>
									       
										<%} %> 
										
										
								  	<div class="text-center">
										<button class="btn-his" type="button"   style="width: 30%;"  tabindex="4"   value="Login" id="loginid" onclick="return submitFormOnValidate(validate(),'benloginLogin');">Login</button>
										<button class="btn-his-outline" type="button"   style="width: 30%;"  tabindex="4" value="Home" id="loginid" onclick="return submitFormOnValidate(true,'Login');">Home</button>
																		  
																	  
		                                <input type="hidden" name="sessionLoginToken"	value='<%=session.getAttribute("sessionLoginToken")%>'>
									 
										<input type="hidden" name="x-auth-token" id="x-auth-token" value="<%=SecureHashAlgorithm.generateRandom(request)%>" />	
									</div>			
								
										 
							
							 <% } %>
                                
                                			
 								<% if(request.getAttribute("error") != null && request.getAttribute("error").toString().trim().length() > 1){ %>
                                
                                				<div id="divElementErrorsId" class=" alert alert-danger alert-dismissible fade show " style='font-size: 12px;'>
														 <%=request.getAttribute("error").toString() %>
												  </div>	
												  
								<% }  else if( request.getSession().getAttribute("LoginError") != null && request.getSession().getAttribute("LoginError").toString().length() > 1) {
									System.out.println("session inside Login Error>> " + request.getSession().getAttribute("LoginError") );
                       			 %>
                       			 <div id="divElementErrorsId" class=" alert alert-danger alert-dismissible fade show " style='font-size: 12px;'>
														<%--  <%=request.getAttribute("LoginError").toString() %> --%>
														 <label type="show" name="LoginError" id='LoginError'><%=( session.getAttribute("LoginError") != null ? session.getAttribute("LoginError") : "" )%></label>
												  </div>	
                       			 
                                <%} else if( request.getSession().getAttribute("LoginSuccess") != null && request.getSession().getAttribute("LoginSuccess").toString().length() > 1) {
                        			
                       			 %>
                       			 
                 
                       			  
                       			<div id="divElementErrorsId" class=" alert alert-success alert-dismissible fade show" style="display:;">
                       				
                       				 <label type="show" name="LoginSuccess" id='LoginSuccess'><%=( session.getAttribute("LoginSuccess") != null ? session.getAttribute("LoginSuccess") : "" )%></label>	
                       		 </div>	
                       	<%} else{ %>
                                
                                <div id="divElementErrorsId" ></div>	
                                
                                <%} %>  
                                
                                
                                <div class="mt-4" style="text-align: right;">
									
										<span id='forgetPassBen' style="color: blue;cursor:pointer;" title="Click Here to Reset Password" >Forgot Password?  </span>
										<span id='' style="color: blue;cursor:pointer;" title="Click Here to Reset Password" > / </span>
										<span id='registerPasswordBen' style="color: blue;cursor:pointer;" title="Click Here to Reset Password" >Register Ben Password</span>
									
									</div>
									<div class="mt-4" style="text-align: right;">
									
										<span id='unlockBen' style="color: blue;cursor:pointer;" title="Click Here to Unlock Ben" > Unlock Ben  </span>
										
									
									</div>
                                
                                <%-- 	<div class="mt-4" style="text-align: right;">
									
										<span id='forgetPass' style="color: blue;cursor:pointer;" title="Click Here to Reset Password" >Forget Password</span>
									
									</div> --%>

									
									<br>				 
                         </s:form>  
                    </div>

    <% } if(session.getAttribute("BenMobileNumber") == null || session.getAttribute("BenMobileNumber").toString().trim().length() == 0){  %>
                                       
                        <!-- Mobile Login Tab -->
							<div class="tab-pane fade" id="navMobile" role="tabpanel" aria-labelledby="nav-mobile-tab">
							<s:form action="mloginLogin" method="post" id="loginForm" class="form">
							
							<% if(request.getSession().getAttribute("otpValidationKey") != null && request.getSession().getAttribute("otpValidationKey").toString().length() > 0 ){  %>
							 
							 <div class="row justify-content-center mb-3">
					
							     
							   <div class="col-12">
	                               		<div class="group" style="display: ;">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" type="text" readonly name="varMobileNumber" value="<%=request.getSession().getAttribute("otpValidationKey").toString() %>"  placeholder="Enter Mobile No." maxlength="10" data-validation="mandatory,mobile">
										</div>                                   
                               		 </div>
							    </div>
							    
							    
							     <div class="row justify-content-center mb-3" id="otPRow" style="display: ;">
							    	<div class="col-12">
	                               		<div class="group">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" type="password" name="varOtp" id="varOtp" placeholder="Enter OTP" maxlength="6" data-validation="mandatory,positiveNumeric">
										</div>                                   
                              		 </div>
							         <div><%= (session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? "Reference No : "+session.getAttribute("otpRefNo_"+request.getSession().getAttribute("otpValidationKey")).toString() : "" ) %></div>
							       
							    </div>
							    
							    <div class="row justify-content-center mb-3" id="otPRow" style="display: ;">
							    	<div class="col-6">
	                               		<div style="text-align: right;margin-top: 8px;color:blue;" id="countDownOTP"></div> 
	                               		
	                               		<div id='otpCountValId' style="display: none;"><%= (session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString() : "0" ) %></div>                        		                                  
                              		 </div>
                              		 
                              		 <div class="col-6">
	                               		 <button class="btn-his"  id="resendButton" onclick="return submitFormOnValidate2(validate(),'mbenloginLogin');">Resend OTP</button>                        
                              			 <div id='otpCountDisplay'></div>	
                              		 </div>
							         
							       
							    </div>
							    
								
							<% } else {  %>
														 							
							    <div class="row justify-content-center mb-3">
							    <div class="col-12">
							    <div style="font-size: 12px;margin-left: 10px;">Main Card Holder Registered Mobile No. Only</div>
	                               		<div class="group">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" type="text" name="varMobileNumber" id="varMobileNumber" placeholder="Enter Mobile No." maxlength="10" data-validation="mandatory,mobile">
												
										</div>      
										                             
                              		 </div>
						      </div>
						      
						       <div class="row justify-content-center mb-3" id="otPRow" style="display:none ;">
							    	<div class="col-12">
	                               		<div class="group">
	                               			<i class="fa-solid fa-lock icon" ></i>
											<input class="input" type="password" name="varOtp" id="varOtp" placeholder="Enter OTP" maxlength="4" data-validation="mandatory,positiveNumeric">
										</div>                                   
                              		 </div>
						      </div>
						      
							<% }    %>
						 
						 
								<!-- Temp commented-->
						 		<!-- <div class="text-dark" role="alert" id='alertMsgMobile' style="display: none;"></div> -->
						 		
						 		
							   
							    <div class="alert alert-danger" role="alert" id='alertMsgMobile' style="display: none;"></div>
							
								<%-- <div id="divElementErrorsMobileId" class=" alert alert-danger alert-dismissible fade show " style="display: none;">
														<s:actionerror />
												  </div>	
							 --%>
							 
							  <% if ( session.getAttribute("LoginError") != null && session.getAttribute("LoginError").toString().length() > 1) { %>
							    	 
								     <div id="divElementErrorsMobileId" class=" alert alert-danger alert-dismissible fade show " style="display:;">
										
										 <label type="show" name="LoginError" id='LoginError'><%=( session.getAttribute("LoginError") != null ? session.getAttribute("LoginError") : "" )%></label>	
								 </div>	
								<% } else {
									
									 %>
									  
									<div id="divElementErrorsMobileId"></div>
									 
									 <%
									
								}
							    %>
							 
							 <div class="text-center mt-4">
  
    
    <% if(request.getSession().getAttribute("otpValidationKey") != null && request.getSession().getAttribute("otpValidationKey").toString().length() > 0 ){  %>
							
    
      <button class="btn-his"   id="validateButton" onclick="return submitFormOnValidateOtp(submitValidateOtpTest(),'mbenloginValidateOtpLogin');" >Submit OTP</button>
  
      
      <%}else{
    	 %> 
    	    <button class="btn-his"  style="width: 30%;" type="button" tabindex="4" value="Verify" id="generateButton" onclick="return submitFormOnValidate2(validate(),'mbenloginLogin');">Get OTP</button>
     <% }
    %>
      	<button class="btn-his-outline" type="button"   style="width: 30%;"  tabindex="4" value="Home" id="loginid" onclick="return submitFormOnValidate(true,'Login');">Home</button>
      <!-- <button class="btn btn-lg fancy" id="Reset">Reset</button> -->
  </div>
  
   <input type="hidden"  id="resendClickCount" value="0"/>
							 
							 
    
								
							    <input type="hidden" name="mstatus" id='mstatus'	value='<%=( session.getAttribute("mstatus") != null ? session.getAttribute("mstatus") : "" )%>'>
							    <input type="hidden" name="sessionLoginToken"	value='<%=session.getAttribute("sessionLoginToken")%>'>
									 
							     
							      </s:form> 
							    
							</div>
							                            
                   <% } %>  
                             
                        
                    <!-- </div> -->
                                </div>
                                

                </div>
							 
							 
								
							</section>
						 
							</form>
					</div>
					</div>		 
                    </div>

  		</div>           
            
              <!-- ===================================end -->  
            </div>
        </div>
    </div>
</div>

    
       <!-- jquery latest version -->
		    <script src="/HIS/hisglobal/cdac_main/js/jquery-3.7.1.min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/bootstrap-min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/scripts.js"></script>
    
    
            <script src="/HIS/hisglobal/cdac_awesome/js/main.js"></script> 
    
    		<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
			<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/util.js"></script>
                               
			<script type="text/javascript" src="/AHIMSG5/hissso/js/ssoLogin.js"></script>
    
    
			
			<script type="text/javascript">
				
			 

				var IS_CAPTCHA_REQ = "<%=HISConfig.CAPTCHA_IMPLEMENTATION%>";
				
				
				var sessionToken = "<%=session.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT)%>";

				var sendCountVal = "<%=(session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString() : "0" )%>";
				var loginPage = 'ben';
		
			</script>
</body>
</html>

