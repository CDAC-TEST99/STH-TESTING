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
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Mobileotp.js"></script>
        <script type="text/javascript" src="/CGHSCardMgmt/global/js/security.js"></script>
    
</head>


  <%
          	  String isGlobal="1"; 
           		 
          %>
  

<body>
<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" class="bannersection" style="min-height: 100vh;">
  
<section class="p-0 ">
		
     	<div id='instruction' class="container p-0 text-dark bordercontainer"  >
     			<div class='container-fluid text-center'><h1>Instruction For Filling Application</h1></div>
				<div class="accordion mb-2" id="accordionBasic">
					  <div class="accordion-item">
					    <h1 class="accordion-header w-100" id="headingOne">
					      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
					        Click here for instructions for all applying Serving beneficiaries
					      </button>
					    </h1>
					    <div id="collapseOne" class="accordion-collapse collapse " aria-labelledby="headingOne" data-bs-parent="#accordionBasic">
					      <div class="accordion-body">
					       <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Copy of ID proof of dependent family members (Passport, PAN Card, Masked Aadhar, voter ID card etc.)</p>
					                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Passport size photograph of all dependent family members.</p>
					                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Pay slip of serving employee showing deduction of CGHS amount.</p>
					                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp; Proof of Residential Address.</p>
					                         <p><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;PAN Not available declaration  <a href="/CGHSCardMgmt/cghsCard/jsp/PAN Card Non-Availability Declaration specifically.pdf" download="PAN Card Non-Availability Declaration specifically.pdf" style="color:blue">Click to Download PAN Not available Declartion Form</a><p>
					                
					                <!-- Dependent Section -->
					                <h5>If dependent is son or minor brother</h5>
					                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;All above and Proof of Age of Son/ Brother.</p>
					                
					                <h5>If dependent is Disabled Son or Disabled brother</h5>
					                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;All above and Proof of Disability of Dependent Son or Brother.</p>
					       
					      </div>
					    </div>
		 		 </div>
				  <div class="accordion-item">
				    <h1 class="accordion-header w-100" id="headingTwo">
				      <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
				       Click here for instructions for all applying Pensioner beneficiaries				        
				      </button>
				    </h1>
				    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionBasic">
				      <div class="accordion-body">
				         <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Copy of ID proof of dependent family members (Passport, PAN Card, Masked Aadhar, voter ID card etc.)</p>
				                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Passport size photograph of all dependent family members.</p>
				                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Self-attested PPO or Provisional PPO or Last pay certificate.</p>
				                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp; Copy of Bharatkosh Challan for CGHS subscription paid.</p>
				                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp; Proof of availing/non-availing FMA.</p>
				                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Proof of Residential address.</p>
				                <br/>
				                <p><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;Duly filled and signed Nomination form/Nominee declaration. <a href="/CGHSCardMgmt/cghsCard/jsp/CGHS_nomination_form.pdf" download="CGHS_nomination_form.pdf" style="color:blue">Click to Download Nominee Form</a><p>
					                         <p><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;PAN Not available declaration  <a href="/CGHSCardMgmt/cghsCard/jsp/PAN Card Non-Availability Declaration specifically.pdf" download="PAN Card Non-Availability Declaration specifically.pdf" style="color:blue">Click to Download PAN Not available Declartion Form</a><p>
                      
				                
				     	 </div>
				    </div>
				  </div>
		  		</div>
		       <div class="card mb-5">
					  <div class="card-body">
					            
		                <!-- Pensioner Dependent Section -->
		                <h5>If dependent is son or minor brother</h5>
		                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;All above and Proof of Age of Son/Brother.</p>
		
		                <h5>If dependent is Disabled Son or Disabled brother</h5>
		                <p ><i class='fa-solid fa-file-circle-check fa-xl text-muted'></i>&nbsp;All above and Proof of Disability - Self-attested copy of Disability certificate issued by Medical Board of Government hospital.</p>
					  </div>
					  <div class="card-footer text-center ">
					    <button type="button" class="btn btn-his" id="confirmBtn" onclick="openMobileotp()">Continue</button>
					  </div>
				</div>
               
		</div>

      
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
				<div class="col-lg-12  mt-3 text-center mb-5" >
					 <button class="btn btn-his" id="generateBtn" >Verify</button>
		             <button class="btn btn-his" style="display:none" id="validateBtn" >Validate OTP</button>
		             <button class="btn btn-his-outline" id="Reset">Reset</button>
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
