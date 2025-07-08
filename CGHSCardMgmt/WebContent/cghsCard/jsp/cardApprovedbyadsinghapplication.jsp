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
<title>Modify User Master</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>
<style>
.custom-file-upload {
	border: 1px solid #ced4da;
	display: inline-block;
	padding: 6px 12px;
	cursor: pointer;
	border-radius: 4px;
	background-color: #fff;
	width: 100%;
	text-align: center;
}

.preview-img {
	max-width: 50%;
	height: auto;
	display: none;
	border: 1px solid #ced4da;
	margin-top: 10px;
	padding: 5px;
}

.btn-custom {
	margin-top: 10px;
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
	width: 30%;
}

.popup .option {
	margin-bottom: 10px;
	cursor: pointer;
	margin-left: 25px;
	text-align: center;
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

.option:hover {
	background-color: gray;
}

.btn-circle {
	width: 40px;
	height: 40px;
	padding: 6px 0;
	border-radius: 50%;
	text-align: center;
	font-size: 20px;
	line-height: 1.42857;
	display: inline-block;
	background-color: #28a745;
	color: white;
	border: none;
	margin-left: 10px;
}

.btn-circle:hover {
	background-color: #218838;
	color: white;
	text-decoration: none;
}

.select2+.btn-circle {
	margin-left: 0px;
}

.close-icon {
	position: relative;
	top: 25px;
	right: -75px;
	background: rgba(255, 255, 255, 0.7);
	border: none;
	cursor: pointer;
	font-size: 20px;
}

#detailsTable th, #detailsTable td {
	text-align: center;
	vertical-align: middle;
}

.btn-circle {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 30px;
	margin-left: 0;
	font-size: 16px;
}

#detailsTable td {
	padding: 10px;
}
</style>


<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/cardApprovedbyadsinghapplication.js"></script>
<script type="text/javascript" src="/CGHSCardMgmt/global/js/security.js"></script>

<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>

</head>


<%
FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");
String isGlobal = fb.getIsGlobal();
if (isGlobal == null)
	isGlobal = "0";

String val = request.getParameter("primaryKeys");
%>
<body>


	<section class="p-0">
		<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
			method="post">
			<fieldset id="ENTRYFORM">
	<div class="row" id='divTrackingIdEntry' style="display: block;">
    <!-- Column for Tracking ID input -->
    <h4>Card Approval BY Additional Director</h4>
    <div class="col-md-3">
        <div class="form-group">
            <label class="col-form-label col-form-label-md" for="Benid">Enter Main Cardholder's Ben Id :</label>
            <input type="text" class="form-control form-control-sm" id="Benid" name="Benid" 
                placeholder="Enter BenId ID" data-validation="mandatory,numeric" maxlength="15" >
            <div class="invalid-feedback"></div>
       </div>
    </div>
    

    <!-- Column for Search Button -->
    <div class="col-lg-6 mt-4" >
        <div class="form-group">            
         <button class='btn btn-his ' id="BTNNEXT"  onclick="getBeneficiarydetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Search</button>	
            <div class="invalid-feedback"></div>
        </div>
 	</div>
</div>

				<div class="container-fluid p-4" id="displayuserinfo"
					style="display: none">
					<div class="row">
						<!-- Column 1: Name -->
						<h5>Personal Information</h5>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patName">Name
									:</label> <input type="text" class="form-control form-control-sm"
									id="patName" name="patName" placeholder="Enter Name"
									data-validation="mandatory,alphabetOnly" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<!-- Column 2: Name in Hindi -->
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patNameHindi">Name in Hindi:</label> <input type="text"
									class="form-control form-control-sm" id="patNameHindi"
									name="patNameHindi" placeholder="Enter Name"
									data-validation="mandatory" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<!-- Column 3: Date of Birth -->
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patDOB">Date
									Of Birth :</label> <input type="text"
									class="form-control form-control-sm datepickerdob" id="patDOB"
									name="patDOB" placeholder="dd-Mon-yyyy"
									data-validation="mandatory" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<!-- Column 4: Gender -->
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patGender">Gender
									:</label> <select class="form-control form-control-sm" id="patGender"
									name="patGender" data-validation="mandatory">
									<option value="">Select Gender</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>

						</div>


						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patMobileNo">Mobile No.:</label> <input type="text"
									class="form-control form-control-sm" id="patMobileNo"
									name="patMobileNo" data-validation="" value="" maxlength="10"
									placeholder=""'>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patEmail">E-mail
									Address:</label> <input type="email"
									class="form-control form-control-sm" id="patEmail"
									name="patEmail" data-validation="email"
									placeholder="Enter E-mail Address">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patresaddress">Residential Address:</label> <input
									type="text" class="form-control form-control-sm"
									id="patresaddress" name="patresaddress"
									data-validation="mandatory,address"
									placeholder="Enter Official Address">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patrelation">Relation :</label> <select
									class="form-control form-control-sm select1" id="patrelation"
									name="patrelation" disabled="true" data-validation="">
									<option value="">Select Relation</option>
								</select>

								<div class="invalid-feedback"></div>
							</div>
						</div>



						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="PatientCghsCity">CGHS City(where Card Applied)</label> <select
									class="form-control form-control-sm select1"
									id="PatientCghsCity" name="PatientCghsCity"
									data-validation="mandatory">
									<option value="">Select City</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>

						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patadcity">AD
									City of satellite City</label> <input type="text"
									class="form-control form-control-sm" id="patadcity"
									name="patadcity" data-validation="mandatory" maxlength=""
									placeholder="">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patientwc">Wellness
									Center</label>
									 <!-- <select class="form-control form-control-sm select1"
									id="patientwc" name="patientwc" data-validation="mandatory">
									<option value="">Select Wellness Center</option>
								</select> -->
								<input type="text"
									class="form-control form-control-sm" id="patientwc"
									name="patientwc" data-validation="mandatory" maxlength=""
									placeholder="">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3" style="display: none;">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patbloodgroup">Bloodgroup :</label> <input type="text"
									class="form-control form-control-sm" id="patbloodgroup"
									name="patbloodgroup" value="" data-validation="mandatory">

								<div class="invalid-feedback"></div>
							</div>



						</div>

					</div>
				</div>

				<input type="hidden" name="tracking" id="tracking" value="" />

				<!--   <div class="container-fluid p-4" id="servingdept" style="display:none">
       <div class="row">
           <h5> Department Information</h5>
            <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardtypeS">Card Type :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardtypeS" name="PatCardtypeS" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
               <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatsubCardtypeS">Card Type :</label>
         <input type="text" class="form-control form-control-sm" id="PatsubCardtypeS" name="PatsubCardtypeS" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
             <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartment">Department :</label>
          <select class="form-control form-control-sm select2" id="patdepartment" name="patdepartment" data-validation="mandatory">
            <option value="">Select Department</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
       
      </div>
     <div class="col-lg-3">
      <div class="form-group">
          <label class="col-form-label col-form-label-md" for="payscale">Pay Scale :</label>
          <select class="form-control form-control-sm select1" id="payscale" name="payscale" data-validation="mandatory,numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
           </div>
      
      
               <div class="col-lg-3">
                <div class="form-group">
          <label class="col-form-label col-form-label-md" for="entitlementS">Ward Entitlement :</label>
          <select class="form-control form-control-sm select1" id="entitlementS" name="entitlementS" data-validation="mandatory">
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
      
         <div class="col-lg-3">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="Presentpay">Present Pay</label>
         <input type="text" class="form-control form-control-sm" id="Presentpay" name="Presentpay" data-validation="mandatory,numeric" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
      
      
       <div class="col-lg-3">
       
        <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patdesignationserving">Designation :</label>
          <select class="form-control form-control-sm" id="patdesignationserving" name="patdesignationserving" data-validation="mandatory" placeholder="Designation">
            
          </select>
                  
          <div class="invalid-feedback"></div>
        </div>
        </div>
      
  
     <div class="col-sm-3 "  id="showdepyeardiv" style="display:none;">
	         <div class="form-group">
        	  	<label class="col-form-label col-form-label-md" for="patDeputationyear">Period of completion of Deputation</label>
          		<input type="text" class="form-control form-control-sm" id="patDeputationyear" name="patDeputationyear" data-validation="mandatory,numeric" maxlength="2" placeholder=" Deputation Years">
          		
          		<label class="col-form-label col-form-label-md" for="patDeputationenddate">Enter End Date of Deputation :</label>
				<input type="text" class="form-control form-control-sm"  id='patDeputationenddate' name='patDeputationenddate'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          		<div class="invalid-feedback"></div>
        	</div>
	     </div>
      </div>
       </div> -->

				<div class="container-fluid" style="display: none;" id="servingdept">
					<h3 class='mt-4'>Beneficiary Serving Department Details</h3>
					<hr />
					<div class="row">

						<div class="col-lg-3">

							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="PatCardtypeS">Card Type :</label> <input type="text"
									class="form-control form-control-sm" id="PatCardtypeS"
									name="PatCardtypeS" data-validation="mandatory" value="">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patcardcategoryserving">Card Category:</label> <select
									class="form-control form-control-sm"
									id="patcardcategoryserving" name="patcardcategoryserving"
									data-validation="mandatory">
									<option value="">Select Card Type</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patsubcardtypeserving">Card SubCategory:</label> <select
									class="form-control form-control-sm" id="patsubcardtypeserving"
									name="patsubcardtypeserving" data-validation="mandatory">
									<option value="">Select Card Type</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
					<!-- 	<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patdeptserving">Organization Name :</label> <select
									class="form-control form-control-sm select2"
									id="patdeptserving" name="patdeptserving"
									data-validation="mandatory">
									<option value="">Select Organization Name</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div> -->
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patsubdeptserving">Organization Name(DDO Code):</label> <select
									class="form-control form-control-sm select2"
									id="patsubdeptserving" name="patsubdeptserving"
									data-validation="mandatory">
									<option value="">Select Organization Name(DDO code)</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						 <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdeptserving">Organization Name :</label>
          <select class="form-control form-control-sm select2" id="patdeptserving" name="patdeptserving" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> 
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patofcadrserving">Offical Address:</label> <input
									type="text" class="form-control form-control-sm"
									id="patofcadrserving" name="patofcadrserving"
									data-validation="mandatory,address"
									placeholder="Office Address">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patpayscaleserving">Pay Level:</label> <select
									class="form-control form-control-sm select1"
									id="patpayscaleserving" name="patpayscaleserving"
									data-validation="mandatory,numeric">
									<option value="">Pay Scale* (in Rs.)</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<!-- 	<div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpresentpayserving">Present Pay (For Service)* (in Rs.) :</label>
          <input type="text" class="form-control form-control-sm" id="patpresentpayserving" name="patpresentpayserving" data-validation="mandatory,numeric" placeholder="Present Pay">
          <div class="invalid-feedback"></div>
        </div>
      </div> -->



						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patpayscalevalueserving">Basic Pay:</label> <select
									class="form-control form-control-sm select1"
									id="patpayscalevalueserving" name="patpayscalevalueserving"
									data-validation="mandatory,numeric">
									<option value="">Pay Scale Value</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patBasicpayserving">Basic pay Level :</label> <select
									class="form-control form-control-sm select1"
									id="patBasicpayserving" name="patBasicpayserving"
									data-validation="mandatory">
									<option value="">Select Basic Pay Level</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patentitlementserving">Ward Entitlement :</label> <select
									class="form-control form-control-sm select1"
									id="patentitlementserving" name="patentitlementserving"
									data-validation="mandatory">
									<option value="">Select Entitlement</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patcardvalidto">Valid upto:</label> <input type="text"
									class="form-control form-control-sm" id='patcardvalidto'
									name='patcardvalidto' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11">
								<div class="invalid-feedback"></div>
							</div>
						</div>



						<!--     <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayserving">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayserving" name="patBasicpayserving" data-validation="mandatory">
            <option value="">Select Basic Pay Level</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> -->
						<!-- 
      <div class="col-sm-3"> 
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatTransferablecityflag">service transferable to another city:</label>
         <input type="text" class="form-control form-control-sm" id="PatTransferablecityflag" readonly="true" name="PatTransferablecityflag" data-validation="mandatory" value="">
         
         
          <div class="invalid-feedback"></div>
        </div> 
      </div> -->
						<!--       <div class="col-sm-3 ">
	         <div class="form-group">
        	  	<label class="col-form-label col-form-label-md" for="patDeputationyear">Period of completion of Deputation</label>
          		<input type="text" class="form-control form-control-sm" id="patDeputationyear" name="patDeputationyear" data-validation="mandatory,numeric" maxlength="2" placeholder=" Deputation Years">
          		
          		<label class="col-form-label col-form-label-md" for="Deputationenddate"> End Date of Deputation :</label>
				<input type="text" class="form-control form-control-sm"  id='Deputationenddate' name='Deputationenddate'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          		<div class="invalid-feedback"></div>
        	</div>
	     </div>
      
     -->
						<!--   <div class="col-sm-3">
	          <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidfrom">Issued from :</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidfrom' name='patcardvalidfrom' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidto">Valid upto:</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidto' name='patcardvalidto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div> -->

						<!--      <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientWc">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="PatientWc" name="PatientWc"  data-validation="mandatory">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
                
      </div> -->
						<!--      <div class="col-sm-3 mt-5 ">
	        <div  class="form-check form-switch">
	          <input class="form-check-input" type="checkbox" id="deputationflag" onclick="ShowDeputationyear()"/>
			  <h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Are you on Deputation ?</h5>
			 
	    	</div>
	   </div> -->


					</div>
				</div>

				<!-- --Pensioner Div -->
				<!--   <div class="container-fluid p-4" id="pensionerdept" style="display:none">
     <div class="row">
      <h5> Department Information</h5>
        <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardtypeP">Card Type :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardtypeP" name="PatCardtypeP" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
               <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatsubCardtypeP">Sub Card Type :</label>
         <input type="text" class="form-control form-control-sm" id="PatsubCardtypeP" name="PatsubCardtypeP" data-validation="mandatory" value="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
            <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartmentP">Department :</label>
          <select class="form-control form-control-sm select2" id="patdepartmentP" name="patdepartmentP" data-validation="mandatory">
            <option value="">Select Department</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>   
    
     <div class="col-lg-3">
               
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="payscale">Pay Scale :</label>
          <select class="form-control form-control-sm select1" id="payscaleP" name="payscaleP" data-validation="mandatory,numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
     
              
      </div>
      </div>
      
       <div class="col-lg-3">
                <div class="form-group">
          <label class="col-form-label col-form-label-md" for="entitlementP">Ward Entitlement :</label>
          <select class="form-control form-control-sm select1" id="entitlementP" name="entitlementP" data-validation="mandatory">
            <option value="">Select Entitlement</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
             </div>  
      
             
       
      <div class="col-lg-3">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="LastPayP">LastPay</label>
         <input type="text" class="form-control form-control-sm" id="LastPayP" name="LastPayP" data-validation="mandatory" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
     
         <div class="col-lg-3">
        <div class="form-group">
                         
         <label class="col-form-label col-form-label-md" for="FmaP">Fixed Medical Allowance:</label>
          <select class="form-control form-control-sm select1" id="FmaP" name="FmaP" data-validation="mandatory">
            <option value="">Fixed Medical Allowance</option>
          </select>
                  <div class="invalid-feedback"></div>
        </div>
      </div>
         
         	<div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmafacilitypensioner">Facility :</label>
	          <select class="form-control form-control-sm " id="patfmafacilitypensioner" name="patfmafacilitypensioner" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
         <div class="col-lg-3">
        <div class="form-group">
        
        <label class="col-form-label col-form-label-md" for="CardApplyvalidity">Card Apply Validity :</label>
          <select class="form-control form-control-sm select1" id="CardApplyvalidity" name="CardApplyvalidity" data-validation="mandatory">
            <option value="">Select Card Apply Validity</option>
          </select>
             <div class="invalid-feedback"></div>
        </div>
      </div>
        
          <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatDOR">Date Of Retirement :</label>
          <input type="text" class="form-control form-control-sm datepickerdob" id="PatDOR" name="PatDOR" placeholder="dd-Mon-yyyy" data-validation="mandatory"  readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
     
      
      
      
      
      <div class="col-lg-3">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="PensionerPPO">PPO NO</label>
         <input type="text" class="form-control form-control-sm" id="PensionerPPO" name="PensionerPPO" data-validation="" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
      
       <div class="col-lg-3">
        <div class="form-group">
                   <label class="col-form-label col-form-label-md" for="Existingbenid">Any Existing CGHs BenId</label>
         <input type="text" class="form-control form-control-sm" id="Existingbenid" name="Existingbenid" data-validation="" value="">
                  <div class="invalid-feedback"></div>
        </div>
      </div>
      
       <div class="col-lg-3">
      </div>
      
      
      
   </div>
    </div>
   -->

				<div class="container-fluid" style="display: none;"
					id="pensionerdept">
					<h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
					<hr />
					<div class="row">

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patcardtypecategorypen">Card Category</label> <select
									class="form-control form-control-sm"
									id="patcardtypecategorypen" name="patcardtypecategorypen"
									data-validation="mandatory">
									<option value="">Card Category:</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patsubcardtypepensioner">Card SubCategory:</label> <select
									class="form-control form-control-sm"
									id="patsubcardtypepensioner" name="patsubcardtypepensioner"
									data-validation="mandatory">
									<option value="">Select Card SubCategory</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patsubdepartmentP">Organization Name(DDO Code):</label> <select
									class="form-control form-control-sm select2"
									id="patsubdepartmentP" name="patsubdepartmentP"
									data-validation="mandatory">
									<option value="">Select Organization Name(DDO Code)</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patdepartmentP"> Organization Name :</label> <select
									class="form-control form-control-sm select2"
									id="patdepartmentP" name="patdepartmentP"
									data-validation="mandatory">
									<option value="">Select Organization Name</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>







						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patpayscalelevelP">Pay Level:</label> <select
									class="form-control form-control-sm select1"
									id="patpayscalelevelP" name="patpayscalelevelP"
									data-validation="mandatory,numeric">
									<option value="">Pay Scale* (in Rs.)</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>




						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patpayscalevalueP">Basic Pay:</label> <select
									class="form-control form-control-sm select1"
									id="patpayscalevalueP" name="patpayscalevalueP"
									data-validation="mandatory,numeric">
									<option value="">Basic pay</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patBasicpayP">Basic pay Level :</label> <select
									class="form-control form-control-sm select1" id="patBasicpayP"
									name="patBasicpayP" data-validation="mandatory">
									<option value="">Select Basic Pay Level</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patentitlementP">Ward Entitlement :</label> <select
									class="form-control form-control-sm select1"
									id="patentitlementP" name="patentitlementP"
									data-validation="mandatory">
									<option value="">Select Entitlement</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patfmapensioner">Fixed Medical Allowances :</label> <select
									class="form-control form-control-sm " id="patfmapensioner"
									name="patfmapensioner" data-validation="mandatory">

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patfmafacilitypensioner">Fixed Medical Allowances
									:</label> <select class="form-control form-control-sm "
									id="patfmafacilitypensioner" name="patfmafacilitypensioner"
									data-validation="mandatory">

								</select>
								<div class="invalid-feedback"></div>

							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patCardApplyValidity">Card Apply Validity :</label> <select
									class="form-control form-control-sm select1"
									id="patCardApplyValidity" name="patCardApplyValidity"
									data-validation="mandatory">
									<option value="">Select Card Apply Validity</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="Patppopensioner">PPO Number:</label> <input type="text"
									class="form-control form-control-sm" id="Patppopensioner"
									name="Patppopensioner" maxlength="20" placeholder="PPO Number"
									onblur="ValidatePPO()">
								<div class="invalid-feedback"></div>
							</div>
						</div>




						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="Patdorpensioner">Date Of Retirement :</label> <input
									type="text" class="form-control form-control-sm"
									id='Patdorpensioner' name='Patdorpensioner' readonly="true"
									placeholder="dd-Mon-yyyy" data-validation="mandatory"
									maxlength="11" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-sm-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patcardvalidtoP">Valid upto:</label> <input type="text"
									class="form-control form-control-sm" id='patcardvalidtoP'
									name='patcardvalidtoP' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11" value="">
								<div class="invalid-feedback"></div>
							</div>
						</div>


					</div>


				</div>

				<div class="table-responsive" id="AutoNumber1"
					style="display: none;">
					<h4>Family Details</h4>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="width: 5%"><b>S.No</b></th>
								<th style="width: 10%">BenId</th>
								<th style="width: 10%">Name</th>
								<th style="width: 10%">Date of Birth</th>
								<th style="width: 10%">Relationship</th>
								<th style="width: 10%">Gender</th>
								<!--   <th style="width:10%">Wellness Center</th> -->
								<!--         <th style="width:10%">Card Type</th> -->
								<th style="width: 10%">Card ValidUpto</th>
								<th style="width: 10%">Card Status</th>
								<th style="width: 10%">Photo</th>
								<th style="width: 15%">Action</th>
								<!--   <th>Action</th> -->

							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>

				<div class="table-responsive" id="PaymentDetail"
					style="display: none;">
					<h4>Payment Details</h4>
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th style="width: 5%"><b>S.No</b></th>
								<th style="width: 15%">BenId</th>
								<th style="width: 15%">BharatKosh Reference No</th>
								<th style="width: 10%">Payment valid From</th>
								<th style="width: 10%">Payment valid to</th>
								<th style="width: 15%">Amount</th>
								<th style="width: 10%">Payment Receipt</th>


							</tr>
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>

				<div class="legend3">
					<button class='btn btn-his-outline btn-sm' id="BTNMODIFY"
						onclick="saveData1();">
						<i class='fas fa-save fa-fw'></i>&nbsp;Modify
					</button>


				</div>

				<div class="row" id="selectedaction" style="display: none;">
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="deptaction">Action
								:</label> <select class="form-control form-control-sm select1"
								id="deptaction" name="deptaction" data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3" id="remarksbox" style="display: none">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="Rejectremarks">Enter Remarks :</label> <input
								type="textarea" class="form-control form-control-sm"
								id="Rejectremarks" name="Rejectremarks"
								placeholder="Enter Remarks"
								data-validation="mandatory,alphabetOnly" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="legend3" id="approvestatus" style="display: none;">
						<button class='btn btn-his-outline btn-sm' id="BTNSUBMIT"
							onclick="Approve();">
							<i class='fas fa-save fa-fw'></i>&nbsp;Submit
						</button>


					</div>


				</div>

				<div class="legend3" id="approvestatus" style="display: none;">
					<button class='btn btn-his-outline btn-sm' id="BTNSUBMIT"
						onclick="Approve();">
						<i class='fas fa-save fa-fw'></i>&nbsp;Submit
					</button>


				</div>

				<div class="container-fluid" style="display: none;"
					id="divDependentInfo">
					<h3 class='mt-4' id='dependentTitle'>Edit Dependent Details</h3>
					<hr />
					<div class="row" id='divDependentEntry'>


						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="Newdepname">Dependent
									BenId :</label> <input type="text" class="form-control form-control-sm"
									id="NewdepBenid" name="NewdepBenid" readonly="true"
									data-validation="mandatory,numeric" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="Newdepname">Dependent
									Name :</label> <input type="text" class="form-control form-control-sm"
									id="Newdepname" name="Newdepname" placeholder="Enter Name"
									data-validation="mandatory,alphabetOnly" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="Newdeptrelation">Relation :</label> <select
									class="form-control form-control-sm" id="Newdeptrelation"
									name="Newdeptrelation" data-validation="mandatory">
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="NewdepDob">Date
									Of Birth :</label> <input type="text"
									class="form-control form-control-sm datepickerdob"
									id='NewdepDOB' name='NewdepDOB' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="newdepgender">Gender :</label> <select
									class="form-control form-control-sm" id="Newdepgender"
									name="Newdepgender" data-validation="mandatory">
									<option value="">Select Gender</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="NewdepvalidUpto">Valid upto :</label> <input type="text"
									class="form-control form-control-sm datepickerdob"
									id='NewdepvalidUpto' name='NewdepvalidUpto'
									placeholder="dd-Mon-yyyy" data-validation="mandatory"
									maxlength="11" readonly="readonly">

								<div class="invalid-feedback"></div>
							</div>
						</div>
						<!-- Blood Group Dropdown -->
						<div class="col-lg-3" style="display: none;">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="NewdepBloodGroup">Blood Group:</label> <select
									class="form-control form-control-sm" id="NewdepBloodGroup"
									name="NewdepBloodGroup" data-validation="mandatory">
									<option value="">Select</option>
									<option value="A+">A+</option>
									<option value="B+">B+</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>



						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="">Photo:</label>

								<img id="editPhoto" src="" alt="Edit Photo"
									style='width: 90px; height: 90px'>
								<div class="overlay" id="overlay" onclick="hidePopup()"></div>
								<br> <input type='hidden' id='editPhoto' name="editPhoto" />
								<div class="invalid-feedback"></div>
							</div>
						</div>
					</div>

					<div>
						<button class='btn btn-his' id="BTNAPPROVE"
							onclick="UpdateDetails()">
							<i class='fas fa-save fa-fw'></i>&nbsp;Save Details
						</button>
					</div>
				</div>

				<div class="popup" id="popup">
					<table style='width: 100%'>
						<tr>
							<td>
								<div class="option" onclick="uploadPhoto()">
									<img src="/CGHSCardMgmt/global/images/upload-icon.png"
										alt="Upload Icon"><br> Upload Photo
								</div>
							</td>
							<td>Or</td>
							<td>
								<div class="option" onclick="capturePhoto()">
									<img src="/CGHSCardMgmt/global/images/capture-icon.png"
										alt="Capture Icon"><br> Capture Photo
								</div>
							</td>
						</tr>
					</table>



					<!-- Modal for Viewing Documents -->
					<div class="modal fade" id="viewDocumentsModal" tabindex="-1"
						aria-labelledby="viewDocumentsModalLabel" aria-hidden="true">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">
								<div class="modal-header">
									<h5 class="modal-title" id="viewDocumentsModalLabel">View
										Documents</h5>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div id="documentsList"></div>
									<!-- List of documents will be populated here -->
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
								</div>
							</div>
						</div>
					</div>

					<input type="file" accept="image/*" id="fileInput" capture="camera"
						style="display: none;">
					<video id="video" width="320" height="240" autoplay
						style="display: none;"></video>
					<button id="capture" style="display: none;"
						onclick='captureActualPhoto(event);'>Capture</button>
					<canvas id="canvas" width="320" height="240" style="display: none;"></canvas>


				</div>

				<input type="hidden" name="editRowIndex" id="editRowIndex" /> <input
					type='hidden' name="fileUploadFlag" id='fileUploadFlag' /> <input
					type="hidden" name="isdisablityvaluehidden"
					id="isdisablityvaluehidden" value="" /> <input type="hidden"
					name="cardtypevaluehidden" id="cardtypevaluehidden" value="" /> <input
					type="hidden" name="statusflag" id=statusflag value="" /> 
					
<!-- 					<input type='hidden' name="Benidvalue" id='Benidvalue' value="" />
 -->					
					<!-- <input type='hidden' name="Benid" id='Benid' value="" /> -->
					 <input	type='hidden' name="cardnovalue" id='cardnovalue' value="" /> <input
					type='hidden' name="parentcitycodehidden" id='parentcitycodehidden'
					value="" /> <input type="hidden" name="hiddenUserId"
					id="hiddenUserId" />

			</fieldset>


			<input type='hidden' name="hmode" id="hmode" /> <input type="hidden"
				name="masterKey" id="masterKey" /> <input type="hidden"
				name="isGlobal" id="isGlobalLocalVar" value="<%=isGlobal%>" /> <input
				type="hidden" name="tid" id="tid" /> <input type="hidden"
				name="initMode" id="initMode" /> <input type="hidden"
				name="primaryKeys" id="primaryKeys" value="<%=val%>" />
		</form>
	</section>
</body>