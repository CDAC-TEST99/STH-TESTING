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


<%
		String userId = "";
		String userName = "";
		String userFullName = "";

		if(session.getAttribute("userDtls") != null && session.getAttribute("userDtls").toString().length() > 0){
			
			String[] userDtls = session.getAttribute("userDtls").toString().split("#");
			
			userId = userDtls[0];
			userName = userDtls[1];
			userFullName = userDtls[2];
		}
		
		if(session.getAttribute("benIdCP") != null && session.getAttribute("benIdCP").toString().length() > 0){
			userName = (String) session.getAttribute("benIdCP") ;
		}



%>


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
							 			<img src="/AHIMSG5/hissso/portal/images/logo.jpg" style="width:75px;" >
							 		</div>							 	
							 		<div class="col-12 text-center mt-1">
							 			<h1 class="mb-4 text-warning">Welcome Beneficiary</h1>
							 			
							 			<h5 class="text-center mb-4 text-white">Please Change your Default Password</h5>
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
                    
                       <form >
                       <div class="row justify-content-center mb-3">
                                <div class="col-12">
                               		<div class="group">
                               		<%
                               			if(session.getAttribute("benIdCP") !=null ){ %>
                               				
                               				<i class="fas fa-user icon" ></i>
                               			<span style="margin-left: 10%;"><%=userName %></span>
                               				
                               	<%		}   %>

										<input  type="hidden" name="varUserId" id="varUserId" value='<%=userId %>' >
										<input  type="hidden" name="varUserName" id="varUserName" value='<%=userName %>' >
									</div>                                   
                                </div>
                            </div>
                       			
                       		
                       		<div class="row justify-content-center mb-3">
                                <div class="col-12">
                                	<div class="group">
                               			<i class="fa-solid fa-lock icon" ></i>
										<input class="input" type="password" name="varOldPassword" id="varOldPassword" maxlength="50" placeholder="Enter Old / Temporary Password"  data-msg="Please enter at least 4 chars"  required autocomplete="off">
									</div> 
                                </div>
                            </div>
                            
                            
                            <div class="row justify-content-center mb-3">
                                <div class="col-12">
                                	<div class="group">
                               			<i class="fa-solid fa-lock icon" ></i>
										<input class="input" type="password" name="varPassword" id="varPassword" maxlength="50" placeholder="Enter New Password"  data-msg="Please enter at least 4 chars"  required autocomplete="off">
									</div> 
                                </div>
                            </div>	
                       			

							<div class="row justify-content-center mb-3">
                                <div class="col-12">
                                	<div class="group">
                               			<i class="fa-solid fa-lock icon" ></i>
										<input class="input" type="password" name="varConfirmPassword" id="varConfirmPassword" maxlength="50" placeholder="Enter Confirm Password"  data-msg="Please enter at least 4 chars"  required autocomplete="off">
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
										<input class="input" type="text" name="captchaResponse" id="captchaResponse" maxlength="3" placeholder="Enter Captcha" onclick="return submitFormOnValidate(validate(),'loginLogin');"  required autocomplete="off">
									</div> 
								</div>	
								
                                    
                                   
                                
                            </div>
									       
										<%} %>  
                                
                                
                                <% if(request.getAttribute("error") != null && request.getAttribute("error").toString().trim().length() > 1){ %>
                                
                                				<div id="divElementErrorsId" class="alert alert-danger alert-dismissible fade show" style='font-size: 12px;'>
														 <%=request.getAttribute("error").toString() %>
												  </div>	
                                <%} else{ %>
                                
                                <div id="divElementErrorsId" ></div>	
                                
                                <%} %>  
                                

								

									<div class="text-center">
										<button class="btn-his" type="button"   style="width: 30%;"  tabindex="4"  value="Login" id="loginid"  >Save Password</button>
										<button class="btn-his-outline" type="button"   style="width: 30%;"  tabindex="4" value="Home" id="homeid" >Home</button>
																		  
																	  
		                                <input type="hidden" name="sessionLoginToken"	value='<%=session.getAttribute("sessionLoginToken")%>'>
									 
										<input type="hidden" name="x-auth-token" id="x-auth-token" value="<%=SecureHashAlgorithm.generateRandom(request)%>" />	
									</div>		
									<br>			 
                         </form>  
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
				

 $(document).ready(function(event){


	 
  
 
	 	$("#homeid").click(function(event) {
	 	   	 		
	 	   goTo('logout');

	 	 return false;
			 
		 });

	   

	 	$("#loginid").click(function(event) {
	 	   	 	     
			if($("#varOldPassword").val().trim() == ""){
					$("#divElementErrorsId").html($("#varOldPassword").attr("placeholder"));
					$("#varOldPassword").focus();
					return false;
			}
			

			if($("#varPassword").val().trim() == ""){
				$("#divElementErrorsId").html($("#varPassword").attr("placeholder"));
				$("#varPassword").focus();
				return false;
		}


			if($("#varPassword").val() == $("#varOldPassword").val()){

				$("#divElementErrorsId").html("Old Password and New Password cannot be Same");
				$("#varPassword").focus();
					return false;
				
				}

			

			if($("#varConfirmPassword").val().trim() == ""){
				$("#divElementErrorsId").html($("#varConfirmPassword").attr("placeholder"));
				$("#varConfirmPassword").focus();
				return false;
		}


			if($("#varPassword").val() != $("#varConfirmPassword").val()){

				$("#divElementErrorsId").html("New Password and Confirm Password Should be Same");
				$("#varConfirmPassword").focus();
					return false;
				
				}

			
			if($("#captchaResponse").length > 0 && $("#captchaResponse").val().trim() == ""){
				$("#divElementErrorsId").html($("#captchaResponse").attr("placeholder"));
				$("#captchaResponse").focus();
				return false;
		}


			

			$("#varUserId").val(window.btoa($("#varUserId").val()));
			$("#varUserName").val(window.btoa($("#varUserName").val()));
			$("#varOldPassword").val(window.btoa($("#varOldPassword").val()));
			$("#varPassword").val(window.btoa($("#varPassword").val()));
			$("#varConfirmPassword").val(window.btoa($("#varConfirmPassword").val()));
			
				goTo('changePasswordFirstBen');

			return false;
			 
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

