<!DOCTYPE html>
<html lang="en">


<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CGHS-Mobile Verification</title>
    
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <style>
    
    </style>
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Mobileotppaymentstatus.js"></script>
        <script type="text/javascript" src="/CGHSCardMgmt/global/js/security.js"></script>
    
</head>


  <%
          	  String isGlobal="1"; 
           		 
          %>
  

<body>
<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" class="bannersection" style="min-height: 100vh;">
  
<div class="container pb-2 text-dark bordercontainer"  id="ENTRYFORM"  style="display: none;" >
<h1 class="m-5 text-center">Mobile Verification</h1>
	<div class="row">
		<div class="col-12 col-md-6 col-lg-6 col-xl-6 col-xxl-6 mt-3" style="min-height: 60vh;">
			  <h1 class="m-5 text-center">Step 1.</h1>
			  <div class="row">
			  	<div class="col-lg-8 " >
			  		<div class="form-group">
				    	<label class="col-form-label col-form-label-md" for="patName">Mobile No. of Applicant</label>
				        <div class="input-group">
					  		<input type="text"  id="userMobile" name="userMobile" class="form-control form-control-lg" placeholder="Enter Mobile No." maxlength="10" data-validation="mandatory,mobile">
					  		<span class="input-group-text" id="input-group-right-example"><i class='fa-solid fa-mobile-screen-button fa-xl' ></i></span>
					  		<div class="invalid-feedback"></div>
						</div>	
			 	  	</div>
			  	</div>
			  </div>	
			  <div class="row" id='OTPRow' style="display: none;">
			  	<div class="col-lg-8 " >
			  		<div class="form-group">
				    	<label class="col-form-label col-form-label-md" for="patName">OTP :</label>
				        <div class="input-group">
					  		<input type="text"  id="userOTP" name="userOTP" class="form-control form-control-lg" placeholder="Enter OTP" maxlength="4" data-validation="mandatory,positiveNumeric">
					  		<span class="input-group-text" id="input-group-right-example"><i class='fa-solid fa-comment-sms fa-xl' ></i></span>
					  		<div class="invalid-feedback"></div>
						</div>	
			 	  	</div>
			  	</div>
				</div>
				 <div class="row" >
				<div class="col-lg-12  mt-3 text-center" >
					 <button class="btn btn-his" id="generateBtn" >Verify</button>
		             <button class="btn btn-his" style="display:none" id="validateBtn" >Validate OTP</button>
		          
		             <button class="btn btn-his-outline" id="Reset">Reset</button>
		             <br>
					<button class="btn btn-his-outline" style="display:none" id="resendBtn" >Resend OTP</button>
	             </div> 
	             </div> 
		</div>	 
		<div class="col-6 d-lg-block d-none mobileOTPimg"  style="margin-top: 60px;">&nbsp;</div>
	</div>	    
				                       
		
        
</div>

<input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />
	     <input type="hidden" name="hiddenId" value="hiddenId"/>
	     <input type="hidden" name="hiddenmobile" id="hiddenmobile" value=""/>
	     <input type="hidden"  id="resendClickCount" value="0"/>
	     <input type="hidden"  id="otpGen" value="0"/>
	     

</section>	     
	     </form>

	     
</body>

</html>
