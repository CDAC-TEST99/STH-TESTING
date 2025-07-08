<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
c
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
  <title>seach by Trackingid</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
   <style>
        .highlight {
            background-color: yellow; /* Change this to your preferred highlight color */
        }
    </style>
  <style>
  .button-container {
    display: flex; /* Use flexbox to align buttons horizontally */
    gap: 10px; /* Optional: Add space between buttons */
    justify-content: center; /* Center the buttons horizontally */
    margin-top: 20px; /* Optional: Add some space above the buttons */
  }

  /* Styling for buttons */
  .button {
    padding: 10px 20px; /* Adjust padding to make buttons bigger */
    font-size: 16px; /* Adjust font size */
    cursor: pointer; /* Change cursor to pointer for better UX */
    border: none; /* Remove default button border */
    border-radius: 5px; /* Optional: Rounded corners for buttons */
  }

  /* Yes button style */
  .yes-button {
    background-color: #4CAF50; /* Green background for Yes */
    color: white;
  }

  /* No button style */
  .no-button {
    background-color: #f44336; /* Red background for No */
    color: white;
  }

  /* Hover effects for the buttons */
  .yes-button:hover {
    background-color: #45a049;
  }

  .no-button:hover {
    background-color: #e53935;
  }
  
#dialogOverlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* Black background with opacity */
  display: none; /* Hidden by default */
  z-index: 1000; /* Ensure the overlay is above other elements */
  justify-content: center;
  align-items: center;
  display: flex; /* Use flexbox to center the dialog */
}

/* Dialog box styling */
#dialogBox {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  width: 650px;
  text-align: center;
}

/* Question text styling */
#dialogBox p {
  font-size: 16px;
  margin-bottom: 20px;
  text-align: left;
}

 
     .preview-img {
      max-width: 20%;
      height: auto;
      display: none;
      border: 1px solid #ced4da;
      margin-top: 10px;
      padding: 5px;
    }
    .btn-custom {
      margin-top: 10px;
    }
    
      .highlight {
            background-color: yellow; /* Highlight color */
        }
      .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 1px solid #ccc;
            background-color: #fff;
            padding: 20px;
            z-index: 1000;
			width:30%;
        }
        .popup .option {
            margin-bottom: 10px;
			cursor: pointer;
			margin-left: 25px;
			text-align:center;
        }
        .popup .option img {
            width: 60px;
			height: 60px;
			margin-left: 15px;
        }
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 500;
        }
		
		.option:hover {background-color: gray;}
  </style>
<head>


<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/ADOnlineVerify.js"></script>
<script type="text/javascript" src="/CGHSCardMgmt/global/js/security.js"></script>
  <script type="text/javascript">

   
    </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  
<body>

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
<fieldset  class='p-5' id="ENTRYFORM">
 <div class="container-fluid">
<div class="row" id='divTrackingIdEntry' style="display: none;">
    <!-- Column for Tracking ID input -->
    <div class="col-lg-6">
        <div class="form-group">
            <label class="col-form-label col-form-label-md" for="PatTrackingid">Tracking Id :</label>
            <input type="text" class="form-control form-control-sm" id="PatTrackingid" name="PatTrackingid" 
                placeholder="Enter Tracking ID" data-validation="mandatory,numeric" maxlength="15" >
            <div class="invalid-feedback"></div>
       </div>
    </div>
    

    <!-- Column for Search Button -->
    <div class="col-lg-6 mt-4" >
        <div class="form-group">            
         <button class='btn btn-his ' id="BTNNEXT"  onclick="gettrackingid()"><i class='fas fa-save fa-fw'></i>&nbsp;Search</button>	
            <div class="invalid-feedback"></div>
        </div>
 	</div>
</div>

	<h5 class="fw-bold text-primary " id="PatTrackingidLbl"></h5>
	<hr>
</div>
   
  <div class="container-fluid p-4" id="displayuserinfo" style="display:none">
       <div class="row">
      <!-- Column 1: Name -->
      <h5> Personal Information</h5>
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patName">Name :</label>
          <input type="text" class="form-control form-control-sm" id="patName" name="patName" placeholder="Enter Name" readonly="true" data-validation="mandatory,alphabetOnly" maxlength="100">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 2: Name in Hindi -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patNameHindi">Name in Hindi:</label>
          <input type="text" class="form-control form-control-sm" id="patNameHindi" name="patNameHindi" placeholder="Enter Name" readonly="true" data-validation="mandatory" maxlength="100">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 3: Date of Birth -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patDOB">Date Of Birth :</label>
          <input type="text" class="form-control form-control-sm datepickerdob" id="patDOB" name="patDOB" placeholder="dd-Mon-yyyy" readonly="true" data-validation="mandatory"  readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 4: Gender -->
    <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patGender">Gender :</label>
              <select class="form-control form-control-sm" id="patGender" disabled="true"   name="patGender" data-validation="mandatory">
                <option value="">Select Gender</option>
                      </select>
              <div class="invalid-feedback"></div>
      </div>
      
 </div>
        <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patPANNo">PAN Number:</label>
              <input type="text" class="form-control form-control-sm" id="patPANNo" name="patPANNo" placeholder="Enter PAN Number" data-validation="" maxlength="10">
              <div class="invalid-feedback"></div>
            </div>
          </div>
     
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patMobileNo">Mobile No.:</label>
              <input type="text" class="form-control form-control-sm" id="patMobileNo" name="patMobileNo" data-validation="" readonly="true" value="" maxlength="10" placeholder=""'>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patEmail">E-mail Address:</label>
              <input type="email" class="form-control form-control-sm" id="patEmail" name="patEmail" data-validation="email" placeholder="Enter E-mail Address">
              <div class="invalid-feedback"></div>
            </div>
          </div>
            <div class="col-lg-3">
           <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patresaddress">Residential  Address:</label>
              <input type="text" class="form-control form-control-sm" id="patresaddress" name="patresaddress" readonly="true" data-validation="mandatory,address" placeholder="Enter Official Address">
              <div class="invalid-feedback"></div>
            </div>
          </div>
          
             <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="patrelation">Relation :</label>
		                   <select class="form-control form-control-sm select1" id="patrelation" name="patrelation" disabled="true"  data-validation="">
                <option value="">Select Relation</option>
              </select>
		                	                
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
         
        	          
		         <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpincodeserving">Pin Code</label>
          <input type="text" class="form-control form-control-sm" id="patpincodeserving" name="patpincodeserving" data-validation="mandatory,numeric" maxlength="6" placeholder="Pin Code">
          <div class="invalid-feedback"></div>
        </div>
        </div>  
        
              <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="stateCode">State :</label>
              <select class="form-control form-control-sm select1" id="stateCode" name="stateCode" data-validation="mandatory">
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
									data-validation="mandatory">
									<option value="">Select District</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div> 
        <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientCghsCity">CGHS Covered City</label>
          <select class="form-control form-control-sm select1" id="PatientCghsCity" name="PatientCghsCity" disabled="true"  data-validation="mandatory">
            <option value="">Select City</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
                
      </div>
           <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patadcity">Concerned AD's Office</label>
          <input type="text" class="form-control form-control-sm" id="patadcity" name="patadcity" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
        
         <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patientwc">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="patientwc" name="patientwc" data-validation="mandatory">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
        </div>
        
         <!--         <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="statecode">State</label>
          <input type="text" class="form-control form-control-sm" id="statecode" name="statecode" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div> -->
     
        
      <!--    <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="imagetest">View Document</label>
         <div id="imagetest"></div>
          <div class="invalid-feedback"></div>
        </div>
                
      </div> -->
         <div class="col-lg-3" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="patbloodgroup">Bloodgroup :</label>
		            <input type="text" class="form-control form-control-sm" id="patbloodgroup" name="patbloodgroup" value="" readonly="true" data-validation="mandatory" >
		                
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
   
</div>
</div>
  <div class="container-fluid p-4" id="servingdept" style="display:none">
       <div class="row">
           <h5> Department Information</h5>
                
                
                     <div class="col-lg-4">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubdepartment">Organization Name(DDO Code) :</label>
          <select class="form-control form-control-sm select2" id="patsubdepartment" name="patsubdepartment" data-validation="mandatory">
            <option value="">Select SubDepartment</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
       
      </div>
             <div class="col-lg-4">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartment"> Organization Name :</label>
          <select class="form-control form-control-sm select2" id="patdepartment" name="patdepartment" data-validation="mandatory">
            <option value="">Select Department</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
       
      </div>
   
          <!--  <div class="col-lg-4">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartmentorg">Organization :</label>
          <select class="form-control form-control-sm select2" id="patdepartmentorg" name="patdepartmentorg" data-validation="mandatory">
            <option value="">Select Organization</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
       
      </div> -->
      <div class="col-lg-3">
                   <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardtype">Apply Card For :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardtype" name="PatCardtype" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
      
      
      
        <div class="col-lg-3">
                   <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardcategory">Card  Category :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardcategory" name="PatCardcategory" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
          <div class="col-lg-3">
                   <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardsubtype">Card Sub Category :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardsubtype" name="PatCardsubtype" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscaleserving">Pay Level:</label>
          <select class="form-control form-control-sm select1" id="patpayscaleserving" name="patpayscaleserving" data-validation="numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>

   
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalevalueserving">Basic Pay:</label>
          <select class="form-control form-control-sm select1" id="patpayscalevalueserving" name="patpayscalevalueserving" data-validation="numeric">
            <option value="">Basic pay</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayserving">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayserving" name="patBasicpayserving" data-validation="">
            <option value="">Select Basic Pay Level</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
    <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patentitlementserving">Ward Entitlement :</label>
          <select class="form-control form-control-sm select1" id="patentitlementserving" name="patentitlementserving" data-validation="mandatory">
            <option value="">Select Entitlement</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> 
         
        
        <div class="col-lg-3">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="OfficeAddress">Office Address</label>
         <input type="text" class="form-control form-control-sm" id="OfcAdress" name="OfcAdress" data-validation="mandatory" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
  
      <div class="col-lg-3" id="depdatediv" style="display:none;">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="Deputationenddate">Deputation Date</label>
         <input type="text" class="form-control form-control-sm" id="Deputationenddate" name="Deputationenddate" data-validation="" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
      </div>
       </div>   
    
    <div class="container-fluid" style="display: none;" id="pensionerdept">
      <h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
      <hr/>
 	  <div class="row">
 	      
 	        <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardtypeP">Card Apply For :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardtypeP" name="PatCardtypeP" readonly="true" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
          
           
                  <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardcategoryP">Card Category :</label>
         <input type="text" class="form-control form-control-sm" id="patcardcategoryP" name="patcardcategoryP" readonly="true" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
               <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatsubCardtypeP">Card SubCategory :</label>
         <input type="text" class="form-control form-control-sm" id="PatsubCardtypeP" name="PatsubCardtypeP" readonly="true" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
           
 	 <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubdepartmentP">Organization Name(DDO Code) :</label>
          <select class="form-control form-control-sm select2" id="patsubdepartmentP" name="patsubdepartmentP" data-validation="mandatory">
            <option value="">Select Organization Name(DDO Code)</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div> 
         
<!--     <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartmentP">Organization Name :</label>
          <select class="form-control form-control-sm select2" id="patdepartmentP" name="patdepartmentP" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>   
     -->
         
    
    <!--    <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patorganizationp">Organization :</label>
          <select class="form-control form-control-sm select2" id="patorganizationp" name="patorganizationp" data-validation="mandatory">
            <option value="">Select Department</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div> 
     -->
  
      
      
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalelevelP">Pay Level:</label>
          <select class="form-control form-control-sm select1" id="patpayscalelevelP" name="patpayscalelevelP" data-validation="numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>


   
   
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalevalueP">Basic Pay:</label>
          <select class="form-control form-control-sm select1" id="patpayscalevalueP" name="patpayscalevalueP" data-validation="numeric">
            <option value="">Basic pay</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayP">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayP" name="patBasicpayP" data-validation="">
            <option value="">Select Basic Pay Level</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
    <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patentitlementP">Ward Entitlement :</label>
          <select class="form-control form-control-sm select1" id="patentitlementP" name="patentitlementP" data-validation="mandatory">
            <option value="">Select Entitlement</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> 
         
      	<div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmapensioner">Fixed Medical Allowances :</label>
	          <select class="form-control form-control-sm " id="patfmapensioner" name="patfmapensioner"  data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
     	<div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmafacilitypensioner">Facility :</label>
	             <input type="text" class="form-control form-control-sm" id="patfmafacilitypensioner" name="patfmafacilitypensioner"  readonly="true" data-validation="mandatory" placeholder="">
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
     
       
       <div class="col-lg-3">
        <div class="form-group">
         <label class="col-form-label col-form-label-md" for="patCardApplyValidity">Card Apply Validity (in Years):</label>
                   <input type="text" class="form-control form-control-sm" id="patCardApplyValidity" name="patCardApplyValidity" readonly="true" data-validation="mandatory,numeric" >
         
       
             <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patppopensioner">PPO Number:</label>
          <input type="text" class="form-control form-control-sm" id="Patppopensioner" name="Patppopensioner" readonly="true"data-validation="mandatory,numeric" maxlength="11" placeholder="PPO Number">
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
     
    <div class="col-sm-3"  id="Fileupload2"  style="display:none">
		           
							<input type="hidden" name="PPOCertificate"
								id="filename12" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="PPO Certificate/Last Pay">PPO Certificate/Last Pay <span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile12" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="12" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon12" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload12"
									onclick="uploadDoc(12,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>

    
    
    
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patdorpensioner">Date Of Retirement :</label>
		  <input type="text" class="form-control form-control-sm"  id='Patdorpensioner' name='Patdorpensioner' readonly="true" placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

 
   
	  </div>
	 
 
</div>
 
    <div class="table-responsive p-4" id="Deptable" style="display:none;" >
   <div class="row">
  <div class="col-lg-12 text-right">
<!--     <div> <button class='btn btn-his'  id="BTNSAVEFINISH2" onclick="addRowToTable()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;ADD Dependent</button></div>
 -->  </div>
  </div>
  <table class="table table-bordered table-striped"  >
  <h5> Dependent Information</h5>
  <thead>
    <tr>
    <th>Sr. No.</th>
    <th>Ben Id</th>
      <th>Name</th>
      <th>DOB</th>
        <th>Gender</th>
          <th>Relation</th>
            <th>Photo</th>
                       <th>View Id Proof</th>
                           <th>Card validity</th>
	        <!-- <th>Action</th> -->
    </tr>
	</thead>
	<tbody>
   
	</tbody>
	
   </table>
   </div>
    
    
    
     <div class="container-fluid" style="display: none;" id="newadddependentinfo">
      <h3 class='mt-4'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepname">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="Newdepname" name="Newdepname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
		  	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdeptrelation">Relation :</label>
		              <select class="form-control form-control-sm" id="Newdeptrelation" name="Newdeptrelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		      <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NewdepDob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepDOB' name='NewdepDOB' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="newdepgender">Gender :</label>
		              <select class="form-control form-control-sm" id="Newdepgender" name="Newdepgender" data-validation="mandatory">
		                <option value="">Select Gender</option>
		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		      <!-- Blood Group Dropdown -->
			  <div class="col-lg-3" style="display: none;" >
			    <div class="form-group">
			      <label class="col-form-label col-form-label-md" for="NewdepBloodGroup">Blood Group:</label>
			      <select class="form-control form-control-sm" id="NewdepBloodGroup" name="NewdepBloodGroup" data-validation="mandatory">
			        <option value="">Select</option>
			        <option value="A+">A+</option>
			        <option value="B+">B+</option>
			      </select>
			      <div class="invalid-feedback"></div>
			    </div>
			  </div>

  
  
    	
		   <div class="col-lg-4">
	            <div class="form-group">
	              <div class="mt-3">
	    		    <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload dependent's photo</button>
	    			</div>
	    			 <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 3 MB.</div>
	    		</div>
    		</div>
    		<div class="col-lg-2">
        	    <div class="form-group">
        	      	<img id="preview2" src="#" alt="Preview2" style="display:none;width:70px"/>
         			<div class="overlay" id="overlay" onclick="hidePopup()"></div>
					<br>
					<input type='hidden' id='fileContent2' />
            		<div class="invalid-feedback"></div>
            	</div>
            </div>
		  
		  <div class="col-lg-3">
			    <div class="form-group mt-3">
			      <div class="form-check form-switch">
			        <input class="form-check-input" type="checkbox" id="customCheckdisable" onclick="uploaddisabledocument()">
			        <label class="form-check-label" for="customCheckdisable" style="color: Blue; font-size: 20px;">Is Disable?</label>
			      </div>
			    </div>
        		<div class="invalid-feedback"></div>
          </div>
        <div class="col-lg-3"  id="fileupload" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="installationCertiFicateDoc"
								id="filename11" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Satisfactory Installation Certificate(SIC)">Disability Certificate : <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile11" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="11" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon11" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload11"
									onclick="uploadDoc(11,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
  	</div> 	
		        
    <div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNADDDEP" onclick="adddepinfo()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Add Details</button>
      </div>
    </div>
    </div>
      <div class="container-fluid p-4" id="dependentinfomodify" style="display:none">
		    <div class="row">
		          <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="DepName">Name :</label>
		              <input type="text" class="form-control form-control-sm" id="DepName" name="DepName" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
				
				
				 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="DepRelation">Relation :</label>
		              <select class="form-control form-control-sm" id="DepRelation" name="DepRelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
	
		
		

		        <!-- Row 2: Date of Birth and Gender -->
		      
		          <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="DepDob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='DepDob' name='DepDob' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-3">
		            <div class="form-group">
		             
		           <label class="col-form-label col-form-label-md" for="DepGender">Gender:</label>
              <input type="text" class="form-control form-control-sm" id="DepGender" name="DepGender" data-validation="" value="" maxlength="10" placeholder="Enter Mobile No."'>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		     
		
		    <div class="col-lg-3">
    <div class="form-group">
      <label class="col-form-label col-form-label-md" for="">Photo:</label>
           
    <img id="editPhoto" src="" alt="Edit Photo" style='width:90px;height:90px'>
    <div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
               	 <div class="invalid-feedback"></div>
    </div>
    </div>
     <div class="col-lg-3">
           <div class="form-group">
          	<img id="editPhoto" src="#" alt="editPhoto" style="display:none; width:90px;height:90px"/>
         	<div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
		 	 	 <div class="invalid-feedback"></div>
            </div>
       <div class="invalid-feedback"></div>
    </div> 
    <div class="col-lg-3">
      <div class="form-group mt-4">
		      <button class='btn btn-his-outline' onclick="showPopup('fileInput','editPhoto' , 'editPhoto' );">Upload your photo</button>
		      </div>
		      <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 3 MB.</div>
   		
</div>

<div class="col-lg-3">
    <div class="form-group">
      <label class="col-form-label col-form-label-md" for="">File:</label>
            <div ><a target='' href='' id="viewfileedit" style="color: red"></a></div>
       <div class="invalid-feedback"></div>
    </div>
  </div>


<!-- <div class="col-lg-3">
                <div class="form-group">
          <label class="col-form-label col-form-label-md" for="disflag">Disability</label>
                        <input type="text" class="form-control form-control-sm" id="disflag" name="disflag" data-validation="" value="" maxlength="10">
                      
          <div class="invalid-feedback"></div>
        </div>
             </div>  --> 

  <!-- Checkbox for "Is Disable?" -->
  
    <div class="col-lg-3"  id="fileupload" style="display:none">
		            <div class="form-group">
		                <button class="btn btn-primary" onclick="uploadFile(2)">Upload</button>	
                       <input type="file" class="form-control" id="fileUpload2">	
                 
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>


		      <div class="row">
		        
		  <div class="col-lg-6" style="display:none" id="disablitycheckbox">
    <div class="form-group">
      <div class="form-check form-switch" >
        <input class="form-check-input" type="checkbox" id="customCheckdisable" onclick="uploaddisabledocument()">
        <label class="form-check-label" for="customCheckdisable" style="color: Blue; font-size: 20px;">Is Disable?</label>
      </div>
    </div>
        <div class="invalid-feedback"></div>
  </div>
		        </div> 	
		        
		           <div class="row">
		            <div class="col-lg-6">
   
        </div>
        </div>
	
	  <div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNADDDEP" onclick="saveChanges()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Modify</button>
      </div>
    </div>
	
    </div>
  </div>
		
		
		 <div class="container-fluid p-4" id="Nomtable" style="display:none">
<div class="row">
    
    <div class="table-responsive" >
  <table class="table table-bordered table-striped"  >
  <h5> Nominee Information</h5>
  <thead>
    <tr>
      <th>Name</th>
      <th>DOB</th>
        <th>Gender</th>
          <th>Relation</th>
           <th>View Nominee Form</th>
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
    </div>
    </div>
    
 
		 <div class="container-fluid p-4" id="Nomtablemodify" style="display:none">
		    <div class="row" id="NomtableModify" style="display:none">
		          <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NomName">Name :</label>
		              <input type="text" class="form-control form-control-sm" id="NomName" name="NomName" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
				
				
				 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NomRelation">Relation :</label>
		              <select class="form-control form-control-sm" id="NomRelation" name="NomRelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
	
		
		

		        <!-- Row 2: Date of Birth and Gender -->
		      
		          <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NomDob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NomDob' name='NomDob' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-3">
		            <div class="form-group">
		             
		           <label class="col-form-label col-form-label-md" for="NomGen">Gender:</label>
              <input type="text" class="form-control form-control-sm" id="NomGen" name="NomGen" data-validation="" value="" maxlength="10" placeholder="Enter Mobile No."'>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		     
			<div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNADDDEP" onclick="saveChangesnominee()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Modify</button>
      </div>
    </div>
  </div>
  </div>
  <div class="container-fluid p-4" id="Uploaddocumentview">
   <h2> View Uploaded Documents</h2>
		    <div class="row" id="Uploaddocumentview" >
		          <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NomName">Residential Proof :</label>
		             <div id="imagetest"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		         		          
		           <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="PPO">PPO Proof :</label>
		             <div id="imagetest1"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
		         <div class="col-lg-3" id="addressporoofrenewal" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="addressporoofrenewal">Address Proof :</label>
		             <div id="imagetest5"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
		          <div class="col-lg-3" id="salaryporoofrenewal" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="salaryporoofrenewal">Salary Proof :</label>
		             <div id="imagetest6"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
		          
		          
				</div>
				</div>
   
    <div class="container-fluid p-4" id="paymententerdetails" style="display:none">
       <div class="row">
      <!-- Column 1: Name -->
      <h5> Payment Details</h5>
   
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="BankName">Bank Name :</label>
          		              <select class="form-control form-control-sm" id="BankName" name="BankName" data-validation="">
          		            <option value="101" selected>Bharatkosh</option>
                         </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>


      <!-- Column 3: Date of Birth -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patbkref">Bharat Kosh Reference No.:</label>
          <input type="text" class="form-control form-control-sm" id="patbkref" name="patbkref"  value="" data-validation="mandatory,numeric" maxlength="100">
          <div class="invalid-feedback"></div>
        </div>
      </div>
  <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayamount">Amount:</label>
          <input type="text" class="form-control form-control-sm" id="patpayamount" name="patpayamount"  value=""  data-validation="mandatory,numeric" maxlength="100">
          <div class="invalid-feedback"></div>
        </div>
      </div>
    
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="paymentfrom">Payment From :</label>
		  <input type="text" class="form-control form-control-sm"  id='paymentfrom' name='paymentfrom' readonly="true" placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" >
          <div class="invalid-feedback"></div>
        </div>
      </div>
	  
	  
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="paymentto">Payment to :</label>
		  <input type="text" class="form-control form-control-sm"  id='paymentto' name='paymentto' readonly="true" placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" >
          <div class="invalid-feedback"></div>
        </div>
      </div>
      
         <div class="col-sm-3"  id="fileuploadpaymentreceipt" >
		           
							<input type="hidden" name="patpaymentreceipt"
								id="filename1" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="Payment Receipt">Payment receipt<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile1" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="1" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 50%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon1" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload1"
									onclick="uploadDoc(1,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
       
   
</div>
</div>
      <div id="dialogOverlay" style="display:none;">
  <div id="dialogBox">
    <!-- Display dynamic content inside paragraphs -->
    <p style="display:none;" id="paymentlabel">Payment to be made: <span id="paymentpopup"></span></p>
    <p style="display:none;" id="payscalelabel">Pay Scale: <span id="payscalepopup"></span></p>
    <p>Card Validity: <span id="cardvaliditypopup"></span> years</p>
  
    <!-- Buttons in a container -->
    <div class="button-container">
      <button class="button yes-button" onclick="handleResponse(true)">
        <i class="fas fa-save fa-fw"></i>&nbsp;Confirm Payment
      </button>
      <button class="button no-button" onclick="handleResponse(false)">
        <i class="fas fa-save fa-fw"></i>&nbsp;No
      </button>
    </div>
  </div>
</div>
       
                    
				
				
    <!-- <div style="text-align:right;">
    	<button class='btn btn-his' id="BTNMODIFY"><i class='fas fa-save fa-fw' onclick="saveData()"></i>&nbsp;Save Changes</button>
    </div> -->
    
 
    
        <div class="row" id="selectedaction" style="display:none;">
     <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="deptaction">Action :</label>
              <select class="form-control form-control-sm select1" id="deptaction" name="deptaction" data-validation="mandatory">
             
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          
             <div class="col-lg-3" id="remarksbox" style="display:none">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Rejectremarks">Enter Remarks :</label>
		              <input type="textarea" class="form-control form-control-sm" id="Rejectremarks" name="Rejectremarks" placeholder="Enter Remarks" data-validation="mandatory,address" maxlength="200">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div> 
						          
						       <div class="col-lg-3" id="intimatepayment" style="display:none">
				  <div class="form-group">
				    <label class="col-form-label col-form-label-md" for="intimatepayment">Intimate for Payment :</label>
				    <!-- Changed input[type="button"] to button -->
				    <button type="button" id="intimatepayment" name="intimatepayment" class="btn btn-primary" onclick="showpaymentmodal()">
				      Intimate for Payment
				    </button>
				    <div class="invalid-feedback"></div>
				  </div>
				</div>
				   <div class="col-lg-3" id="amountbox" style="display:none">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="amountenterebyad">Enter Amount :</label>
		              <input type="text" class="form-control form-control-sm" id="amountenterebyad" name="amountenterebyad" placeholder="Enter Amount" data-validation="mandatory,numeric" maxlength="6">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div> 
		          
		         
		          
 </div>
 
 
 
 <div class="legend3">
  <button class='btn btn-his' id="BTNSAVESERVING" onclick="saveData()" style="display:none;"><i class='fas fa-save fa-fw'></i>&nbsp;Generate-eCard</button>
    <button class='btn btn-his' id="BTNSAVEPENSIONER"  onclick="saveData1()" style="display:none;"><i class='fas fa-save fa-fw' ></i>&nbsp;Submit</button>
      <button class='btn btn-his' id="BTNSAVEPENSIONERREJECTREMARKS"  onclick="UpdateRemarks()" style="display:none;"><i class='fas fa-save fa-fw' ></i>&nbsp;Submit</button>
      <button class='btn btn-his' id="BTNAPPROVERENEWAL"  onclick="SaveRenewal()" style="display:none;"><i class='fas fa-save fa-fw' ></i>&nbsp;Approve Renewal</button>
  
  </div>
 	     
 
 
    
  <!--   <div class="row">
    
          <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="approve" name="decision" value="approve" onclick="handleDecision()" data-validation="mandatory">
            <label class="col-form-label col-form-label-md" for="Approve">Approve</label>
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
				
	
				
				 <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="reject" name="decision" value="reject" onclick="handleDecision()" data-validation="mandatory">
            <label class="col-form-label col-form-label-md" for="Reject">Reject</label>
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		   </div>       
		   
		   
		       <div class="col-lg-3" id="remarksbox" style="display:none">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Rejectremarks">Enter Remarks :</label>
		              <input type="text" class="form-control form-control-sm" id="Rejectremarks" name="Rejectremarks" placeholder="Enter Remarks" data-validation="mandatory,alphabetOnly" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
			 <div class="col-lg-3">
		            <div class="form-group">
		           
	      <button class='btn btn-his' id="BTNMODIFY" style="display:none"><i class='fas fa-save fa-fw' onclick="saveData()"></i>&nbsp;GenerateBenid</button>
	       <button class='btn btn-his' id="BTNPayment" style="display:none" onclick="saveData1()"><i class='fas fa-save fa-fw' ></i>&nbsp;Verify</button>
	           
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		   </div>  
		
            		          
		              <div class="invalid-feedback"></div>
		            </div> -->
		 
    </div>
    <div class="modal" id="paymentModal" tabindex="-1" role="dialog" aria-labelledby="paymentModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="paymentModalLabel">Payment Intimation</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- Content of the modal -->
        <p>Are you sure you want to intimate for payment?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Confirm Payment</button>
      </div>
    </div>
  </div>
</div>



    
 <div class="popup" id="popup">
	<table style='width:100%'>
	<tr>
	<td>
        <div class="option" onclick="uploadPhoto()">
            <img src="/CGHSCardMgmt/global/images/upload-icon.png" alt="Upload Icon"><br>
             Upload Photo 
        </div>
	</td>	
	 <td>Or</td>
	<td>
        <div class="option" onclick="capturePhoto()">
            <img src="/CGHSCardMgmt/global/images/capture-icon.png" alt="Capture Icon"><br>
             Capture Photo 
        </div>
		</td>
		</tr>
		</table>
		
	
	
	<!-- Modal for Viewing Documents -->
<div class="modal fade" id="viewDocumentsModal" tabindex="-1" aria-labelledby="viewDocumentsModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="viewDocumentsModalLabel">View Documents</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div id="documentsList"></div> <!-- List of documents will be populated here -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
		
	 <input type="file" accept="image/*" id="fileInput" capture="camera" style="display:none;">
	  <video id="video" width="320" height="240" autoplay style="display:none;"></video>
    <button id="capture" style="display:none;" onclick='captureActualPhoto(event);'>Capture</button>
    <canvas id="canvas" width="320" height="240" style="display:none;"></canvas>
		
		
    </div>
        <input type="hidden" name="paymententryflag" id="paymententryflag" value=""/>
    
    <input type="hidden" name="cardsubcategoryhidden" id="cardsubcategoryhidden" value=""/>
          <input type="hidden" name="payamounthidden" id="payamounthidden" value=""/>
                  <input type="hidden" name="cardvalidityhidden" id="cardvalidityhidden" value=""/>
        <input type='hidden' name="Deputationenddatehidden" id='Deputationenddatehidden' value=""  /> 
      <input type="hidden" name="cpchiddenvalue" id="cpchiddenvalue" value=""/>
         <input type="hidden" name="amountautonoumshidden" id="amountautonoumshidden" value=""/>
    <input type="hidden" name="editRowIndex" id="editRowIndex"/>
       <input type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
            <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
            <input type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden" value=""/>
              <input type="hidden" name="statusflag" id=statusflag value=""/>
                <input type='hidden' name="Benidvalue" id='Benidvalue' value=""  />  
	             <input type='hidden' name="cardnovalue" id='cardnovalue' value=""  /> 
	              <input type='hidden' name="adcitycodehidden" id='adcitycodehidden' value=""  /> 
	                   <input type='hidden' name="formstatusflaghidden" id="formstatusflaghidden" value=""  /> 
	                   <input type='hidden' name="formrenewalflaghidden" id="formrenewalflaghidden" value=""  /> 
	             
  </fieldset>    
                
            <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	    <%String primaryKeyFromListPage= request.getParameter("primaryKey");
	       if(primaryKeyFromListPage==null){
	    	   primaryKeyFromListPage="";
	       }
	     %>
	     <input type='hidden' name="primaryKeyFromListPage" id='primaryKeyFromListPage' value="<%=primaryKeyFromListPage %>"  />  
	     
</form>    
      
</body>
</html>