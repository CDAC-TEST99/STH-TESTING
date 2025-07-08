<%-- JSP Script created by Naman Verma on 21st November 2024 --%>
<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<title>Organisation Dept Approval</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/OrganistnDeptApproval.js"></script>

<style>
.btn-right {
	float: right;
	color: lightgreen;
}

.zoom:hover {
	transform: scale(2);
}

.blue-top-line {
  border: 0;
  height: 3px;
  background-color: #000214;
  margin: 0 0 20px 0;
}

</style>
</head>


<%
FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
  String isGlobal=fb.getIsGlobal(); 
		if(isGlobal==null)
 		isGlobal="0";
%>



<body>




	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">

		<fieldset class='hideData' id="LISTPAGE"
			style="width: 98%; margin-left: 0; padding: 0"></fieldset>
		<!-- <div class='card hideData' id="LISTPAGE"></div> -->


		<fieldset class='hideData' id="ENTRYFORM">

			<legend class="w-auto px-2 legendcss" id='formTitle'>Registration of Organisation
				</legend>

			<div class="legend2 ">


				<button class="btn btn-his-sm  btn-sm" id="btnsave">
					<i class="fas fa-save"></i> &nbsp; Save
				</button>
				<button class="btn-his-outline-sm" id="btnclear">
					<i class="fas fa-save"></i> &nbsp; Clear
				</button>
				<button class="btn-his-outline-sm" id="cancelForm" onClick="backToListPage()">
					<i class="fas fa-times"></i> Cancel
				</button>

			</div>
			<div id="ticketDiv" class='accordion'>
				<div class="accordion-item mt-1" id=ticketDtlDiv>

					<h2 class="accordion-header" id="ticketDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseTicketDtl"
							aria-expanded="true" aria-controls="collapseTicketDtl">
							New Registration</button>
					</h2>
					<div id="collapseTicketDtl"
						class="accordion-collapse collapse show"
						aria-labelledby="ticketDtlHeading" data-bs-parent="ticketDiv">
						<div class="accordion-body">
							<div class="row">
								
<!-- 								start div 
 -->							
 								
 								  <div class="row">
    <!--  <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="orgType">Organisation Type :</label>
        <input type="text" class="form-control form-control-sm" id="orgType" name="orgType" placeholder="Type Of Organisation" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div> -->
    
    
    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="frstNm">First Name :</label>
        <input type="text" class="form-control form-control-sm" id="frstNm" name="frstNm" placeholder="First Name" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="lastNm">Last Name :</label>
        <input type="text" class="form-control form-control-sm" id="lastNm" name="lastNm" placeholder="Last Name" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
         
    <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="dob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='dob' name='dob'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
    
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="dtofretnmt">Date Of Retirement :</label>
		  <input type="text" class="form-control form-control-sm"  id='Patdorpensioner' name='dtofretnmt' placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
    
    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="dsgnatn">Designation :</label>
        <input type="text" class="form-control form-control-sm" id="dsgnatn" name="dsgnatn" placeholder="Designation" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    
   
        
     <!-- <div class="col-lg-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="orgTypedrpDwn">Organisation Type :</label>
          <select class="form-control form-control-sm select2" id="orgTypedrpDwn" name="orgTypedrpDwn" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
         </div>
    

    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="orgName">Organisation Name :</label>
        <input type="text" class="form-control form-control-sm" id="orgName" name="orgName" placeholder="Organisation Name" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div> -->

    <!-- <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="orgCity">Organisation City :</label>
        <input type="text" class="form-control form-control-sm" id="orgCity" name="orgCity" placeholder="Organisation City" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div> -->
    
<hr style="border: 2px solid #003366; margin-top: 20px; margin-bottom: 20px;">
    
								<div class="row">
                                    <div class="col-lg-4">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubdepartment">Organization Name(DDO Code) :</label>
          <select class="form-control form-control-sm select2" id="patsubdepartment" name="patsubdepartment" data-validation="mandatory" onchange="extractAfterDollar()">
            <option value="">Select Organization Name(DDO Code)</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
       
      </div>
             <div class="col-lg-4">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartment"> Organization Type :</label>
          <select class="form-control form-control-sm select2" id="patdepartment" name="patdepartment" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
                </div>
        
       
      </div>
      
      
  <div class="col-12">
  
  <!-- <div class="form-group">
  <div class="form-check mt-2">
    <input class="form-check-input" type="checkbox" id="ddoPaoAvailable" onchange="handleDdoPaoCheckbox(this)">
    <label class="form-check-label col-form-label-md" for="ddoPaoAvailable" style="font-size: 1.0rem;">
      DDO & PAO CODE Available
    </label>
  </div>
  <div id="wordHide">
<small class="form-text mt-2" style="color: #003366; font-weight: bold; font-size: 0.85rem;">
  Note: - DDO & PAO Code will be system generated, Kindly Enter the PAO AND DDO CODE IF Available
</small>
</div>
</div> -->
  
  <div class="row"  id="ddoCodeContainer">
 <div class="col-lg-4">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="ddoCd">DDO CODE :</label>
        <input type="text" class="form-control form-control-sm" id="ddoCd" name="ddoCd" placeholder="DDO CODE" maxlength="10">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class="col-lg-4">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="paoCode">PAO CODE :</label>
        <input type="text" class="form-control form-control-sm" id="paoCode" name="paoCode" placeholder="PAO CODE" maxlength="10">
        <div class="invalid-feedback"></div>
      </div>
    </div>
             </div>
    
     </div>
     
     <div class="col-lg-3">
  <div class="form-group">
    <label class="col-form-label col-form-label-md" for="funcDesgn">Whether this user will update existing user :</label>
    <select class="form-control form-control-sm select2" id="funcDesgn" name="funcDesgn" data-validation="mandatory">
      <option value="">--Select--</option>
      <option value="Y">YES</option>
      <option value="N">NO</option>
      </select>
    <div class="invalid-feedback"></div>
  </div>
</div> 
   <div class="col-lg-3" id="loginContainer">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="exstLogin">Mention Existing(Login Id) :</label>
        <input type="text" class="form-control form-control-sm" id="exstLogin" name="exstLogin" placeholder="Enter Login-Id" maxlength="10">
        <div class="invalid-feedback"></div>
      </div>
    </div>
   
<div class="col-12">
  <div style="border: 3px solid #ccc; padding: 15px; margin-top: 20px; border-radius: 8px;">
    <h5 style="margin-bottom: 20px;">Address & Contact Details</h5>
    <div class="row">

    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="orgAddress">Official Address :</label>
        <input type="text" class="form-control form-control-sm" id="orgAddress" name="orgAddress" placeholder="Organisation Address" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class='col-lg-3'>
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for=stateCode">State
									:</label> <select class="form-control form-control-sm select2"
									id='stateCode' name="stateCode" data-validation="mandatory" onchange="captureState()">
									<option value="">Select State</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class='col-lg-3'>
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for=districtCode">District
									:</label> <select class="form-control form-control-sm select2"
									id='districtCode' name="districtCode"
									data-validation="mandatory" onchange="captureCity()">
									<option value="">Select District</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

    <div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="city">City :</label>
        <input type="text" class="form-control form-control-sm" id="city" name="city" placeholder="Enter your City" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
     <div class="col-lg-3">
  <div class="form-group">
    <label class="col-form-label col-form-label-md" for="pincode">Pin Code :</label>
    <input type="tel" class="form-control form-control-sm"
           id="pincode"
           name="pincode"
           data-validation="mandatory"
           placeholder="Contact No"
           pattern="^\d{10}$"maxlength="10"      
           required
           oninput="validatePhoneNumber(this)" /> <!-- Call JavaScript to ensure only digits are entered -->
    <div class="invalid-feedback">Please enter a valid 10-digit phone number.</div>
  </div>
</div>

    <div class="col-lg-3">
  <div class="form-group">
    <label class="col-form-label col-form-label-md" for="contactNo">Phone No :</label>
    <input type="tel" class="form-control form-control-sm"
           id="contactNo"
           name="contactNo"
           data-validation="mandatory"
           placeholder="Contact No"
           pattern="^\d{10}$"maxlength="10"      
           required
           oninput="validatePhoneNumber(this)" /> <!-- Call JavaScript to ensure only digits are entered -->
    <div class="invalid-feedback">Please enter a valid 10-digit phone number.</div>
  </div>
</div>

<div class="col-lg-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="emailId">Email Id / Login ID:</label>
        <input type="email" class="form-control form-control-sm" id="emailId" name="emailId" placeholder="Email Id" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>

</div>
  </div>
</div>
<!-- End bordered address/contact section -->

        
     <div class="col-lg-3">
      <div class="form-group">
<!--         <label class="col-form-label col-form-label-md" for="ddoCd">DDO CODE :</label>
 -->       <input type='hidden' name="nodalOfficer" id="nodalOfficer"/>
	     	     <input type='hidden' name="stateTxt" id='stateTxt' />    
	     	     <input type='hidden' name="distTxt" id='distTxt' />    
	     	     	     	     <input type='hidden' name="updDddoCd" id='updDddoCd' />    
	     
<!--    <input type="hidden" class="form-control form-control-sm" id="ddoCd" name="ddoCd" placeholder="DDO CODE" maxlength="100">
 -->        <div class="invalid-feedback"></div>
      </div>
    </div>

			<input type='hidden' name="saveType" id='saveType' value="" />

       </div>
 
                                    <!-- End Div -->
				           
								
  <!-- <div class="form-group">
    <label class="col-form-label col-form-label-md">
      <a href="#" id="applyNewOrgLink" class="text-warning" style="text-decoration: underline; font-size: 1.0rem;">
        Update Organisation Details
      </a>
    </label>
    <label class="col-form-label col-form-label-md mt-0">
      <a href="#" id="registerNewOrgLink" class="text-primary" style="text-decoration: underline; font-size: 1.0rem;">
        Register New Organisation
      </a>
    </label>
  </div> -->
</div>
</div>
</div>
</div>
</div>
						
<!--                                      form div start here
 -->
 
							
								
<!-- <div class="container-fluid" id="EntryFormsId" style="display: none;">
<div id="ticketDivs" class='accordion'>
				<div class="accordion-item mt-1" id=fileUploadDtlDiv>

					<h2 class="accordion-header" id="fileUploadDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseFileUploadDetails"
							aria-expanded="true" aria-controls="collapseFileUploadDetails">
							New Registration</button>
					</h2>
					<div id="collapseFileUploadDetails"
							class="accordion-collapse collapse show"
							aria-labelledby="fileUploadDtlHeading"
							data-bs-parent="fileUploadDiv">
							<div class="accordion-body">

					</div>
				</div>
								</div>
</div>  upside this 
    add more fields here as needed
</div> -->
									
<!-- 						div end here form for 			
 -->								
			<input type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
		</fieldset>


		
			<input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	     <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />    
	    	     
	     
	     </form>


</body> 
</html>
