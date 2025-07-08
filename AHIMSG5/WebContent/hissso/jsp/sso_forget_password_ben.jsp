<%@page import="hisglobal.security.SecureHashAlgorithm"%>
<%@page import="hisglobal.utility.SecurityUtil"%>
<%@page import="hisglobal.config.HISConfig"%>

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
 

   <div class="container-fluid position-absolute mt-5" id="seatBox">
        <div class="row">
            
            <div class="col-md-12 col-xl-12 col-12 p-0  mt-2">
                
              <!-- =============================start -->
             
		<div class="modal-content modal-content-bg">
            <div class="modal-body" style="height: 50%;">
                <div class='row'>
             		<div class='col-md-12 col-xl-6 welcomebg' >
             			<div class='row mt-5'>
							 		<div class="col-12 text-center mt-3">
							 			<img src="/AHIMSG5/hissso/portal/images/logo.jpg" style="width:75px;">
							 		</div>							 	
							 		<div class="col-12 text-center mt-1">
							 			<h1 class="mb-4 text-warning">Welcome to Reset Password </h1>
							 			<h5 class="text-center mb-4 text-white">Please Reset your Password</h5>
							 		</div>
							 		
							 	</div>	
             		</div>
             		<div class='col-md-12 col-xl-6'>
                
                
                       <form method="post">
							<section class="p-0 mt-5" style="width: 81%;margin-left:30px">
								
							 
							 
							 <div class="modal-body" style="height: 50%;">
							 	 
                <div class="tab-content" id="nav-tabContent">

    <!-- User Login Tab --> 
                    <div class="tab-pane fade-tab active show" id="navUser" role="tabpanel" aria-labelledby="nav-user-tab">
             <%--        <% if ( session.getAttribute("LoginError") != null) {
                    	session.removeAttribute ("LoginError");
                    	}  %> --%>
                    
                      
                             
                             	<% if(request.getSession().getAttribute("otpValidationKey") != null && request.getSession().getAttribute("otpValidationKey").toString().length() > 0 ){  %>
							 
							 <div class="row justify-content-center mb-3">
					
							     
							        <div class="col-12">
	                               		<div class="group" style="display: none;">
	                               			<i class="fas fa-mobile icon" ></i>
	                               			
	                               			<input class="input" type="text"  readonly name="varUserId" id="varUserId" value="<%=request.getSession().getAttribute("otpValidationKey").toString() %>"  placeholder="Enter BenId" maxlength="50" data-validation="mandatory">
	                               		 	</div>                                   
                               		 </div>
							    </div>
							    
							    <div class="row justify-content-center mb-3" id="mobileNumId" style="display: ;">
							    	<div class="col-12">
	                               		<div class="group">
	                               			<i class="fas fa-mobile icon" ></i>
											<input class="input" readonly name="mobileNum" id="mobileNum" value= <%= "******" +(session.getAttribute("PatmobileNumber") ).toString().substring((session.getAttribute("PatmobileNumber") ).toString().length() - 4) %>  data-validation="mandatory,positiveNumeric">
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
	                               		 <button class="btn-his"  id="resendButton" onclick="return submitFormOnValidate2(validate(),'forgetPasswordOtpLogin');">Resend OTP</button>                        
                              			 <div id='otpCountDisplay'></div>	
                              		 </div>
							         
							       
							    </div>
							    
							
							
							<% } else {  %>
														 							
							    <div class="row justify-content-center mb-3">
							    <div class="col-12">
							     
	                               		<div class="group">
	                               			<i class="fas fa-user icon" ></i>
											<input class="input" type="text" name="varUserId" id="varUserId" placeholder="Enter Ben Id" maxlength="50" data-validation="mandatory">
												
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
								
									 <%
								}else{
							    %>
							    <div id="divElementErrorsMobileId"></div>
							    <% 
							    }
							    %>
							 
							 <div class="text-center mt-4">
  
    
    <% if(request.getSession().getAttribute("otpValidationKey") != null && request.getSession().getAttribute("otpValidationKey").toString().length() > 0 ){  %>
							
							 <div style="font-size: 12px;margin-left: 10px;">OTP will be received to Registered Mobile No.</div>
							
    
      <button class="btn-his"   id="validateButtonBen" >Submit OTP</button>
  
      
      <%}else{
    	 %> 
    	    <button class="btn-his"  style="width: 30%;" type="button" tabindex="4" value="Verify" id="generateButtonBen" >Get OTP</button>
     <% }
    %>
      	<button class="btn-his-outline" type="button"   style="width: 30%;"  tabindex="4" value="Home" id="homeid" >Home</button>
      <!-- <button class="btn btn-lg fancy" id="Reset">Reset</button> -->
  </div>
  
   <input type="hidden"  id="resendClickCount" value="0"/>
							     <input type="hidden" name="sessionLoginToken"	value='<%=session.getAttribute("sessionLoginToken")%>'>
                             
									<br>			 
                          
                    </div>
 
                             
                        
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
    
    		<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
			<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/util.js"></script>
    
    
    
    	<script type="text/javascript">
				
			 

				var IS_CAPTCHA_REQ = "<%=HISConfig.CAPTCHA_IMPLEMENTATION%>";
				 

				var sendCountVal = "<%=(session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")) != null && session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString().length() > 0 ? session.getAttribute("otpCount_"+request.getSession().getAttribute("otpValidationKey")).toString() : "0" )%>";
			

				var loginPage = 'cghs';
				
		  

 $(document).ready(function(event){

 
 
	 	$("#homeid").click(function(event) {
	 	   	 		
	 	   goTo('logout');

	 	 return false;
			 
		 });

	   

	 	$("#generateButtonBen").click(function(event) {
	 	   	 	     
			if($("#varUserId").val().trim() == ""){
					$("#divElementErrorsId").html($("#varUserId").attr("placeholder"));
					$("#varUserId").focus();
					return false;
			}
			
   			  

			$("#varUserId").val(window.btoa($("#varUserId").val()));
		 
			
				goTo('forgetPasswordOtpBen');

			return false;
			 
			 });



		$("#validateButtonBen").click(function(event) {
   	 	     
			if($("#varUserId").val().trim() == ""){
					$("#divElementErrorsId").html($("#varUserId").attr("placeholder"));
					$("#varUserId").focus();
					return false;
			}


			if($("#varOtp").val().trim() == ""){
				$("#divElementErrorsId").html($("#varOtp").attr("placeholder"));
				$("#varOtp").focus();
				return false;
		}
		
			$("#varUserId").val(window.btoa($("#varUserId").val()));
			 
			
				goTo('resetPasswordBen');

			return false;
			 
			 });




		var minutes = 0, seconds = 59;
		var minutesDisplay = "0";
		var secondsDisplay = "59";
		$(function() {

			if (parseInt(sendCountVal) < 3) {
				
				$("#resendButton").hide();
				$("#otpCountDisplay").hide();

				$("#countDownOTP").html(" Resend OTP in <b>"+minutesDisplay + ":" + secondsDisplay+" sec </b>");
				var countInt = setInterval(function() {
					if (parseInt(minutes) < 0) {
						clearInterval(countInt);
						$("#countDownOTP").hide();
						$("#resendButton").show();
						$("#otpCountDisplay").html("OTP Send Count : "+$("#otpCountValId").html());
						$("#otpCountDisplay").show();
						
						return;
					} else {
						$("#countDownOTP").html("Resend OTP in <b>"+minutesDisplay + ":" + secondsDisplay+" sec </b>");
						
						if(parseInt(minutes) < 10){
							minutesDisplay = "0" + minutes;
						}
						
						if (seconds == 0) {
							minutes--;
							if (minutes < 10)
								minutesDisplay = "0" + minutes;
							seconds = 59;
						}
						seconds--;
						secondsDisplay = seconds;
						if (seconds < 10)
							secondsDisplay = "0" + seconds;
					}
				}, 1000);

			}else{
				
				$("#resendButton").hide();
				$("#otpCountDisplay").hide();
			}
		});
				
		 
 

	 	 event.preventDefault();
	 	
			
 });
			 

			 function goTo(mode){

			if(mode != 'logout'){

   					 
			    	var strSecureCode=$("#captchaResponse").val()+$("#varConfirmPassword").val()+$("#varNewPassword").val()+$("#varOldPassword").val()+$("#varUserId").val()+$("#varUserName").val();
			    
			   // 	alert("sec code >> "+strSecureCode.replace(/ /g,"_"));
			    	
			    	var fhttf=hex_md5(strSecureCode.replace(/ /g,"_"));
			    	
			    //	 alert("fhttf >> "+fhttf);
			    	
				    document.forms[0].fhttf.value=fhttf;
			}
				  
		    		document.forms[0].action = '/AHIMSG5/hissso/'+mode+'Login';
		    		document.forms[0].submit();
		    		
		        }
		
			</script>
</body>
</html>

