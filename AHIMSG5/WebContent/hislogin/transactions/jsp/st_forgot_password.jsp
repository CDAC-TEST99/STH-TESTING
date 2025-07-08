<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hislogin.config.HISLoginConfig"%>

<html>
<head>
<title>Password Assistance</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Cache-Control" Content="no-store" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store");
%>

<script language="JavaScript" type="text/javascript"
	src="/HIS/hisglobal/bootstrap/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript"
	src="/HIS/hisglobal/bootstrap/bootstrap.min.js"></script>
<link href="/HIS/hisglobal/bootstrap/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
  -->
	 <link rel="stylesheet" href="/HIS/hisglobal/css/login/font-awesome.min.css">
  
	

<link href="/HIS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/layout.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jqueryExtValidationToolTip.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/easyui.css" rel="stylesheet" type="text/css">

<!-- Added for Security Start-->
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/avai/validation.js"></script>
<!-- Added for Security End-->


<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/his-jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery.easyui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jqueryExtValidation.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/commonFunctions.js"></script>
<script type="text/javascript" src="/HIS/hisglobal/js/multilingual.js"></script>

<style type="text/css">
.label{color:#013157;}
.msg{color:#013157;}
.helpMsg{color:red;font-size:15px; font-weight:bold;}
.subHelpMsg{color:#013157;font-size:12px; font-weight:regular;}
.form-gap {
    padding-top: 50px;
}

</style>


</head>
<body onload="pageOnLoad()">
<center>


<div class="form-gap"></div>

<div class="container"><div class="row">
<div class="col-md-4 col-md-offset-4">
<!-- <img src="/HIS/hisglobal/images/headerImage.png" width="360px" height="50px" >
 -->
<s:form action="LgnFtr">

<s:if test="%{varStatus == 'INITIAL'}">
  <div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
           <h3><i class="fa fa-lock fa-4x"></i></h3>
                 <h2 class="text-center title width100"><span key='forgot-password'>Forgot Password?</span></h2><br>
                 <!--  <p class="label">Kindly enter your User ID.</p>
                  --> 
                 <!--  <div class="panel-body">
      -->
               
	<div class="div-table" >
		
		<div class="div-table-row ">
			
		</div>
			<br>
	
		<div class="div-table-row ">
		<div class="form-group">
                        <div class="input-group" style="padding-left:20px;padding-right:20px;">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-user color-blue"></i></span>
                          <input id="varUserName" name="varUserName" placeholder="Enter your User ID" key-placeholder='enter-your-user-name'  class="form-control" tabindex="1" maxlength="20" autocomplete="off">
                        </div>
                      </div>
                      
			
		</div>
		
	</div>
	
	<div class="div-table-button">
		<div class="div-table-row footerBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row emptyBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="form-group" style="padding-left:20px;padding-right:20px; font-weight:bold;">
                        <a href="#" id="idNext" tabindex="1" class="button btn-primary" style="font-weight:bold;"><span class="next" key='continue'>Continue</span></a>
                        <a href="#" id="idCancel" tabindex="1" class=" btn-primary button " style="font-weight:bold;"><span class="cancel" key='cancel'>Cancel</span></a>
                      </div>
                      
		
	<!-- </div>
	 --></div></div></div></div>
	
	 <div class="modal fade" id="registrationStatus" role="dialog"
		data-keyboard="false" data-backdrop="static">
		<div class="modal-dialog modal-md" style="margin-top: 141px;">
			<div class="modal-content">
				<div class="modal-header" style="background:linear-gradient(to bottom, #135d8c 0%,#1277b5 0%,#1277b5 32%,#135d8c 100%); color:white;font-weight:bold;">
					<span key='authetication-required'>Authentication Required</span>		
					  <button type="button" id="closeBtn" class="close btn" style="color:white;"  data-dismiss="modal">&times;</button> 
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group msg">
						<div class="text-center" id="frstMsg"><!-- For your security, we need to authenticate your request. An OTP will be sent to your registered mobile no.  Please enter it below to complete the verification. -->	</div>
						<br>
						<input type="text" name="otp" id="otp" class="form-control" autocomplete="off"
								 maxlength="6"
								size="15" placeholder="Enter OTP" key-placeholder='enter-otp'   ></input>
								
								<input type="text" name="emailId" id="emailId" />

							 <div align="center">
								<div id="lable1" class="alertMessage label1Class"></div>
							</div> 
													</div>
													
													<center>
								<button type="button" class="btn btn-primary" id="btnsave"
									onclick="proceedOld()"><span key='submit-otp'>Submit OTP</span></button>
									
									
								<button type="button" disabled="disabled"
									class="btn btn-primary" id="btnresend" onclick="resendOTP()"><span key='resend-otp'>Resend
									OTP</span></button>
							</center>


							<div id="countdown">
								<div id="countdown"></div>
								<div id="countdown2"></div>
								<div id="countdown"></div>
							</div>
													
					</form>
				</div><br>
				<div class="modal-footer"><div class="form-group alignLeft">
						<div class="helpMsg"><span key='is-your-mobile-no-not-registered'>Is your mobile no. not registered with the application or has changed lately? </span></div>
						<div class="form-group subHelpMsg ftrMsg" id="ftrMsg"><span key='if-your-mobile-no-has-changed'>If your mobile no. is not registered with the application or has changed after account registration, kindly contact your Hospital System Admin for help restoring your password.</span>
	
							</div></div>
						

							
				</div>
			</div>
		</div>
	</div>


	<button type="button" id='popupLaunch' class="btn btn-primary"
		style="display: none;" data-toggle="modal"
		data-target="#registrationStatus"></button> 
 	
	
</s:if>

  
<s:elseif  test="%{varStatus == 'NEW_PASSWORD'}">
<img src="/HIS/hisglobal/images/headerImage.png" width="360px" height="50px" >

<div class="panel panel-default">
              <div class="panel-body">
                <div class="text-center">
           <h3><i class="fa fa-lock fa-4x"></i></h3>
                 <h2 class="text-center title width100"><span key='create-new-password'>Create New Password</span></h2><br>
                  <p class="subHelpMsg"><span key='well-ask-for-this-pwd'>We'll ask for this password whenever you login.</span></p>
                 
                  
                 <!--  <div class="panel-body">
   -->
	<div class="div-table" >
		
		<div class="div-table-row ">
		<div class="form-group">
                        <div class="input-group" style="padding-left:20px;padding-right:20px;">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                          <input type="password" id="varPassword" name="varPassword" placeholder="Enter new nassword" key-placeholder='enter-new-password' value="" class="form-control" tabindex="1" maxlength="10" autocomplete="off">
                        </div>
                       
                      </div>
        
			
		</div>
		<div class="div-table-row ">
		<div class="form-group">
		 <div class="input-group" style="padding-left:20px;padding-right:20px;">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-lock color-blue"></i></span>
                          <input type="password" id="varConfirmPassword" name="varConfirmPassword" placeholder="Confirm new password" key-placeholder='confirm-new-password' value="" class="form-control" tabindex="1" maxlength="10" autocomplete="off">
                        </div>
                        </div>
			
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width100 label" >
				<font color='red'>
					<br>
		     		*<span key='the-password-is-case-sensitive'>The Password is case sensitive.</span>
		     	</font>
		     </div>
		</div>
	</div>
	
	<div class="div-table-button">
		<div class="div-table-row footerBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row emptyBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row" >
                        <a href="#" id="idSave" tabindex="1" class="button" style="font-weight:bold;"><span class="save" key='continue'>Save</span></a>
                        <a href="#" class="button" tabindex="1" id="idClear" style="font-weight:bold;"><span class="clear" key="clear">Clear</span></a>
                        <a href="#" id="idCancel" tabindex="1" class="button " style="font-weight:bold;"><span class="cancel" key='cancel'>Cancel</span></a>
                      </div>
        
		
	
	<!-- </div>
	 --></div></div></div></div>
	
	<s:hidden name="varUserName" ></s:hidden>
	  
</s:elseif>

<s:hidden name="varStatus"></s:hidden>
<s:hidden id="mobileNoFormat" name="mobileNoFormat" value=""></s:hidden>
 

<div style="display: none;">
   
    <span id="faced-some-unknown-problem-please-try-again" key='faced-some-unknown-problem-please-try-again'>Faced Some Unknown Problem. Please try Again!</span>
    <span id="no-user-with-provided-username-found" key='no-user-with-provided-username-found'>Invalid Details. No user with provided User ID found.</span>
    <span id="no-mobile-number-registered-with-this-username" key='no-mobile-number-registered-with-this-username'>No mobile number registered with this User ID. Kindly contact your Hospital's System Administrator.</span>
    <span id="invalid-mobile-number" key='invalid-mobile-number'>Invalid Mobile Number.</span>
    <span id="otp-verified-successfully" key='otp-verified-successfully'>OTP verified successfully.</span>
	<span id="incorrect-otp-entered-enter-otp-again" key='incorrect-otp-entered-enter-otp-again'>Incorrect OTP Entered. Enter OTP Again.</span>
	<span id="otp-has-expired-click-on-resend-otp-button" key='otp-has-expired-click-on-resend-otp-button'>OTP has expired. Click on Resend OTP button.</span>
	<span id="faced-some-unknown-problem-please-try-again" key='faced-some-unknown-problem-please-try-again'>Faced Some Unknown Problem. Please Try Again.</span>
	<span id="resend-otp" key='resend-otp'>Resend OTP</span>
	<span id="for-your-security" key='for-your-security'>For your security, we need to authenticate your request.</span>
	<span id="please-enter-it-below" key='please-enter-it-below'>Please enter it below to complete the verification.</span>
	<span id="an-otp-has-been-sent" key='an-otp-has-been-sent'>An OTP has been sent</span>
	<span id="to-your-registered-mobile-no" key='to-your-registered-mobile-no'>to your registered mobile no.</span>
	<span id="no-to" key='no-to'>.&nbsp;</span>
	<span id="if-your-mobile-no-has-changed" key='if-your-mobile-no-has-changed'>If your mobile no. is not registered with the application or has changed after account registration, kindly contact your <b><u>Hospital System Admin</u></b> for help restoring your password.</span>
		
    </div>
</s:form>
<div id="divElementErrorsId" class="alertMessage"><s:actionerror /></div>
<s:elseif  test="%{varStatus == 'DONE'}">
<br><div class="label"><span key='kindly-wait'>Kindly wait, you will be directed to Login Page shortly. </span></div>
</s:elseif>

<script type="text/javascript">

var sessionToken = "<%=session.getAttribute(HISSSOServerConfig.LOGIN_FEATURES_SESSION_SALT)%>";
var passwordStrength = "<%=HISLoginConfig.PASSWORD_STRENGTH%>";
var mobileNo="";


function setPasswordStrength()
{
	$('[name="varPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[10]', 'passwordStrength['+passwordStrength+']']
	});
}

function pageOnLoad()
{
	//location.reload(true);
	if(document.getElementsByName('varStatus')[0].value=="DONE")
	{
		//window.setTimeout(function(){parent.closeModal()},2000);
		window.open("https://hmisar.dcservices.in","_parent");
		//window.close();
	}

	

	if(document.getElementsByName('varUserName')[0])	document.getElementsByName('varUserName')[0].focus();
	if(document.getElementsByName('varPassword')[0])	document.getElementsByName('varPassword')[0].focus();
	setPasswordStrength();

	
	
}


function generateOtp()
{

	  if(document.getElementsByName("varUserName")[0].value!=''){
	
		var urlNew="/AHIMSG5/hislogin/transactions/action/CHECKLOGINIDLgnFtr"
			var data="varUserName="+document.getElementsByName('varUserName')[0].value;
		urlNew = createFHashAjaxQuery(urlNew+"?"+data);
		//urlNew = urlNew+"?"+data;
		

		$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
			{
		
			      var statusArr= result.split("#");
			      var status=statusArr[0];
			      var emailId=statusArr[1];
			      
			      //var mobNo=statusArr[1];
			     // mobileNo=mobNo;
			    //  document.getElementById("mobileNoFormat").value=mobNo;
			     document.getElementById("emailId").value=emailId;

				  //$("#frstMsg").html($("#for-your-security").html()+"&nbsp;"+$("#an-otp-has-been-sent").html()+" "+$("#to-your-registered-mobile-no").html()+"- <b><u>"+"xxxxxx"+mobNo.substring(6,10)+"</b></u>"+$("#no-to").html()+" "+$("#please-enter-it-below").html());
				  $("#frstMsg").html($("#for-your-security").html()+"&nbsp;"+$("#an-otp-has-been-sent").html()+" "+$("#to-your-registered-mail-id").html()+"- <b><u>"+emailId+"</b></u>"+$("#no-to").html()+" "+$("#please-enter-it-below").html());

					      
			     if(status=="0"){ 
    				$("#divElementErrorsId").html($("#no-user-with-provided-username-found").html());
    				document.getElementsByName("varUserName")[0].focus();
    			}else if(status=="1"){ 
    				//alert(mobNo.length);
    				$("#divElementErrorsId").html("");
    				
    				$(".label1Class").html("");
    				
    		 		/*  if(mobNo=="0")
    					{
    					$(".label1Class").html($("#no-mobile-number-registered-with-this-username").html());
    					}
    				else if(mobNo==""){
    					$("#divElementErrorsId").html($("#no-mobile-number-registered-with-this-username").html());
        				
        				}
    				else{
    					 if(mobNo.length<=9||mobNo.length>=11)
    					{
    						$(".label1Class").html($("#invalid-mobile-number").html());
    					}  */
    					
    					 if(emailId=="")
        					 {
    	    					$("#divElementErrorsId").html($("#no-mail-registered-with-this-username").html());
    	        				
    	        				}
    					else
    					{
    						var urlNew="/AHIMSG5/hislogin/transactions/action/SENDOTPFgtPwdLgnFtr";
    						//var urlNew="/AHIMSG5/hislogin/transactions/action/SENDOTPLoginFtr";
    						
    							//var data="varNewMobileNumber="+mobNo;
    							var data="emailId="+emailId;
    						
    							urlNew = createFHashAjaxQuery(urlNew+"?"+data);
    							
    							//alert('urlNew'+urlNew);
    							$.ajax({url:urlNew,type:'POST',data:data,async: false,success:function(result)
    	    	    			{
        	    	    			var emailid=emailId;
        	    	    		
    	    	    			//var displayMobNo= mobNo.substring(6,10);
    	    	    			//$(".label1Class").html("OTP has been sent to your registered Mobile No. ******"+displayMobNo);

    	    	    			$("#popupLaunch").click();
								
							setTimerForOTP();
							
    	    	    			} 
    	    	    		});
    	    	    		
    				    }
    					} 
    			} 
    		
		});
	
		
		} 
  
}

function proceedOld(){
	var urlNew="/AHIMSG5/hislogin/transactions/action/VALIDATEOTPFgtPwdLgnFtr";
	//var data="varNewMobileNumber="+mobileNo+"&otp="+$("#otp").val();
	
	var data="emailId="+$("#emailId").val()+"&otp="+$("#otp").val();
	
	
	//var data="mode=VALIDATEOTP&crNo="+$("#crno").val()+"&otp="+$("#otp").val();

	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	
	//alert('urlproceedOld'+urlNew);
	
		
	data = "";
	
	$.ajax({url:urlNew,tpye:'POST',data:data,async: false,
		success:function(result)
		{
			  //alert('result'+result);
					 try{

							result = window.atob(result); 

							result = result.split(',')[0];

							 }catch(err){

								 result = "2";

								 }

					//alert(result);
	
	//result = result.substring(0, 1);
	
	

    /* var statusArr= result.split("@");
    alert('statusArr'+statusArr);
    var result=statusArr[0];
    alert('resultval'+result); */

		/* if(result.substring()=="1") */
		if(result=="1")
			{
 
			$(".label1Class").html($("#otp-verified-successfully").html());
			document.getElementById("otp").disabled=true;
			loginForgotPassword.submitOnNext();
			}
	 	else if(result=="2")
		{
			//alert("in here");
			$(".label1Class").html($("#incorrect-otp-entered-enter-otp-again").html());
		}
		else if(result=="3")
		{
			$(".label1Class").html($("#otp-has-expired-click-on-resend-otp-button").html());
		}	 
		}
	});
		

}


function resendOTP()
{ 


	$('#otp').val('');
	var urlNew="/AHIMSG5/hislogin/transactions/action/SENDOTPFgtPwdLgnFtr";
	var data="mode=SENDOTP"+"&varNewMobileNumber="+mobileNo;
	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	//console.log(urlNew);
	
	data = "";
	$.ajax({url:urlNew,type:'POST',data:data,async: false,success:function(result)
		{
			
		var displayMobNo= mobileNo.substring(6,10);
	//	$(".label1Class").html("OTP has been sent to your Mobile No. ******"+displayMobNo);
	
	//$("#popupLaunch").click();
	setTimerForOTP();
		}
	});
   	     }


function setTimerForOTP(){


  
   
   document.getElementById("btnresend").disabled = true;
   document.getElementById("btnsave").disabled = false;
   
// Set the date we're counting down to
   var countDownDate = new Date(new Date().getTime() + 1*60000);

   // Update the count down every 1 second
   var x = setInterval(function() {

     // Get today's date and time
     var now = new Date().getTime();
       
     // Find the distance between now and the count down date
     var distance = countDownDate - now;
       
     // Time calculations for days, hours, minutes and seconds
     var days = Math.floor(distance / (1000 * 60 * 60 * 24));
     var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
     var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
     var seconds = Math.floor((distance % (1000 * 60)) / 1000);
       
     // Output the result in an element with id="demo"
     document.getElementById("btnresend").innerHTML =  $("#resend-otp").html()+"( "+seconds + "s )";
       
     // If the count down is over, write some text 
     if (distance < 0) {
       clearInterval(x);
       document.getElementById("btnresend").innerHTML =  $("#resend-otp").html();
       document.getElementById("btnresend").disabled = false;
       document.getElementById("btnsave").disabled = true;
       
       
     }
   }, 1000);
   
   
   }

function countdown( elementName, minutes, seconds )
{

var element, endTime, hours, mins, msLeft, time;

function twoDigits( n )
{
return (n <= 9 ? "0" + n : n);
}

function updateTimer()
{
msLeft = endTime - (+new Date);
if ( msLeft < 1000 ) {


var patContactNo=$('[name="patContactNo"]').val();
var action="";
	<%--  var action="<%=context_path%>LabRptRegistrationServlet"; --%>
	var urlNew="/AHIMSG5/hislogin/transactions/action/EXPIREOTPFgtPwdLgnFtr";
	var data="mode=EXPIREOTP"+"&varNewMobileNumber="+mobileNo;
	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	
	
  // var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
	$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
	{
	if(result=="1")
	{
	$("#lable2").html("Time Over. Please Resend OTP");
    element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
  	}	   	
	} 
	});
	  } else {
    time = new Date( msLeft );
    hours = time.getUTCHours();
    mins = time.getUTCMinutes();
    element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
    setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );

   // alert("time"+time);
}
}

element = document.getElementById( elementName );
endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
//alert("endtime"+endTime);
updateTimer();

}
<%-- countdown( "countdown", <%=AppointmentConfig.COUNTDOWN_TIME_LIMIT%>, 5 );	   --%>      


var loginForgotPassword = {
		clearForm : function()
		{
			if(document.getElementsByName("varUserName")[0])	document.getElementsByName("varUserName")[0].value = "";
			if(document.getElementsByName("varPassword")[0])	document.getElementsByName("varPassword")[0].value = "";
			if(document.getElementsByName("varConfirmPassword")[0])	document.getElementsByName("varConfirmPassword")[0].value = "";
		},
		submitOnNext : function()
		{
		//alert("submitONNext");	
			/* if(!loginForgotPassword.secureAnswer())
			{
				document.getElementById("divElementErrorsId").innerHTML = $("#faced-some-unknown-problem-please-try-again").html();
				document.getElementsByName("varUserName")[0].value = "";
				//document.getElementsByName("varQuestionId")[0].value = "-1";
				//document.getElementsByName("varHintAnswer")[0].value = "";
				return;
			}
			else
			{ */
				//For Submission
			  	submitForm("validateForgetPasswordLgnFtr");
			//generateOtp();
			
			//}
		},
				submitOnSave : function()
		{
			if( !loginForgotPassword.securePassword())
			{
				//alert("saveForgetPasswordLgnFtr>>insideif");
				document.getElementById("divElementErrorsId").innerHTML = $("faced-some-unknown-problem-please-try-again").html;
				document.getElementsByName("varPassword")[0].value = "";
				document.getElementsByName("varConfirmPassword")[0].value = "";
				return;
			}
			else
			{
				//alert("saveForgetPasswordLgnFtr>>insideelse");
				//For Submission
			
				
			  	submitForm("saveForgetPasswordLgnFtr");
			}
		},
		submitOnOTPVerification:function(){
			submitForm("validateForgetPassword1LgnFtr")
			},
		securePassword : function()
		{
			
			var hashValue = "";
			var objPassHash = new jsSHA(document.getElementsByName("varPassword")[0].value+document.getElementsByName("varUserName")[0].value, "ASCII");
			try 
			{
				hashValue = objPassHash.getHash("SHA-1", "HEX");
			} 
			catch(e)
			{
				return false;
			}
			document.getElementsByName("varPassword")[0].value = hashValue;
			document.getElementsByName("varConfirmPassword")[0].value = hashValue;
			return true;
		}


	};

	$('[name="varUserName"]').validatebox({
		required: true,
		validType : [ 'alphaNumWithUnderscore', 'maxLength[20]' ]
	});
	$('[name="varPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[10]','passwordStrength['+passwordStrength+']' ]
	});
	$('[name="varConfirmPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[10]', 'equalTo["#varPassword","New Password","Confirm Password"]' ]
	});

	// On Click of Next
	$('#idNext').click(function(e){
		if($('#LgnFtr').form('validate')){
			//alert("yes");
			//alert("inside validate");
			//loginForgotPassword.submitOnNext();
			//getclientmailid();
			generateOtp();
			
			//loginForgotPassword.submitOnNext();
		}else{
			//alert("no");
			//$('#no-user-with-provided-username-found').val('');
			$('#divElementErrorsId').html('');
			return false;
		}
		//}
		e.preventDefault();
	});

	// On Click of Clear
	$('#idClear').click(function(e){
		loginForgotPassword.clearForm();
	});

	// On Click of Cancel
	$('#idCancel').click(function(e){
	//	parent.closeModal();
	window.close();
		e.preventDefault();
	});

	 $('#idNext1').click(function(e){
		if($('#LgnFtr').form('validate')){
			generateOtp();
			//loginForgotPassword.submitOnOTPVerification();
			//addUpdateMobileNo.submitOnSave();
		}else{
			return false;
		}
		e.preventDefault();
	}); 
	

	// On Click of Save
	$('#idSave').click(function(e){
		if($('#LgnFtr').form('validate')){
			loginForgotPassword.submitOnSave();
		}else{
			return false;
		}
		e.preventDefault();
	});
	







	
/* 	function clientemaildetail()
	{
		var urlNew="/AHIMSG5/hislogin/transactions/action/EXPIREOTPFgtPwdLgnFtr";
		var data="mode=EXPIREOTP"+"&varNewMobileNumber="+mobileNo;
		urlNew = createFHashAjaxQuery(urlNew+"?"+data);
		
		
	  // var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
		$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
		{
		if(result=="1")
		{
		$("#lable2").html("Time Over. Please Resend OTP");
	    element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
	  	}	   	
		} 
		});
		
		}
 */


	
		    



 




 
</script>
</div>
</div>
</div>
</center>
</body>
</html>