<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
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
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/cardrenwal.js"></script>
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
 <!-- <div class="container-fluid">
<div class="row" id='divTrackingIdEntry' style="display: none;">
    Column for Tracking ID input
    <div class="col-md-3">
        <div class="form-group">
            <label class="col-form-label col-form-label-md" for="Benid">Ben Id :</label>
            <input type="text" class="form-control form-control-sm" id="Benid" name="Benid" 
                placeholder="Enter BenId ID" data-validation="mandatory,numeric" maxlength="15" >
            <div class="invalid-feedback"></div>
       </div>
    </div>
    

    Column for Search Button
    <div class="col-lg-6 mt-4" >
        <div class="form-group">            
         <button class='btn btn-his ' id="BTNNEXT"  onclick="getBeneficiarydetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Search</button>	
            <div class="invalid-feedback"></div>
        </div>
 	</div>
</div> -->

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
          <input type="text" class="form-control form-control-sm" id="patName" name="patName" placeholder="Enter Name"  data-validation="mandatory,alphabetOnly" maxlength="100" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 2: Name in Hindi -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patNameHindi">Name in Hindi:</label>
          <input type="text" class="form-control form-control-sm" id="patNameHindi" name="patNameHindi" placeholder="Enter Name" data-validation="mandatory" maxlength="100" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 3: Date of Birth -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patDOB">Date Of Birth :</label>
          <input type="text" class="form-control form-control-sm datepickerdob" id="patDOB" name="patDOB" placeholder="dd-Mon-yyyy" data-validation="mandatory"  readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 4: Gender -->
    <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patGender">Gender :</label>
              <select class="form-control form-control-sm" id="patGender"    name="patGender" data-validation="mandatory" disabled>
                <option value="">Select Gender</option>
                      </select>
              <div class="invalid-feedback"></div>
      </div>
      
 </div>
    
     
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patMobileNo">Mobile No.:</label>
              <input type="text" class="form-control form-control-sm" id="patMobileNo" name="patMobileNo" data-validation=""  value="" maxlength="10" readonly="readonly" placeholder=""'>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patEmail">E-mail Address:</label>
              <input type="email" class="form-control form-control-sm" id="patEmail" name="patEmail" data-validation="email"   placeholder="Enter E-mail Address">
              <div class="invalid-feedback"></div>
            </div>
          </div>
            <div class="col-lg-3">
           <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patresaddress">Residential  Address:</label>
              <input type="text" class="form-control form-control-sm" id="patresaddress" name="patresaddress" data-validation="mandatory,address"  placeholder="Enter Official Address">
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
         
        <div class='col-lg-3'>
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for=stateCode">State
									:</label> <select class="form-control form-control-sm select2"
									id='stateCode' name="stateCode" data-validation="mandatory">
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
						
						  <div class="col-sm-3">
				    <div class="form-group">
				          <label class="col-form-label col-form-label-md" for="patpincodeserving">Pin Code</label>
				          <input type="text" class="form-control form-control-sm" id="patpincodeserving" name="patpincodeserving" data-validation="mandatory,numeric" maxlength="6" placeholder="Pin Code">
				          <div class="invalid-feedback"></div>
				        </div>
        </div>  
            
        <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientCghsCity">CGHS City(where Card Applied)</label>
          <select class="form-control form-control-sm select1" id="PatientCghsCity" name="PatientCghsCity"  data-validation="mandatory" disabled="true">
            <option value="">Select City</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
                
      </div>
           <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patadcity">AD City of satellite City</label>
          <input type="text" class="form-control form-control-sm" id="patadcity" name="patadcity" data-validation="mandatory"  maxlength="" placeholder="" disabled="true">
         
          <div class="invalid-feedback"></div>
        </div>
        </div>
    
          <div class="col-lg-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patientwc">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="patientwc" name="patientwc" data-validation="mandatory" disabled="true">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      	</div>
      	<!--  file upload starts -->
      	
      	
      	   <!-- For address proof -->
      	   <div class="col-sm-4"  id="Fileuploadaddressproof" >
		           
							<input type="hidden" name="mainchidproof"
								id="filename19" value="" /> 
								<label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Address Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile19" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;">
									<!-- <span class="btn btn-his"> -->
									<span class="btn btn-his" style="background-color: #007bff; color: white;">Choose File<input
										type="file" style="display: none;" id="19" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon19" style="float: left; margin-right: 2px;">
								<a class="btn btn-his" id="faUpload19"
									onclick="uploadDoc(19,'CARDDOCUMENT','1');" style="background-color: #007bff; color: white;">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>
		          
		          
		          
		          <!-- salary slip -->
		          
		          
		          <div class="col-sm-4"  id="Fileuploadsalaryslipproof" >
		           
							<input type="hidden" name="mainchidproof"
								id="filename20" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Recent Salry Slip (Within Last 3 months)<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile20" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn btn-his" style="background-color: #007bff; color: white;">Choose File<input
										type="file" style="display: none;" id="20" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon20" style="float: left; margin-right: 2px;">
								<a class="btn btn-his" id="faUpload20"
									onclick="uploadDoc(20,'CARDDOCUMENT','1');" style="background-color: #007bff; color: white;">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>
      	
      	
      	<!-- file upload section ends  -->
      	
      	<!-- upload main card holder image -->
      	
      	   <!--            <div class="col-lg-3">
		      <div class="form-group">
		      <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview' , 'mainPhotoId' );">Upload your passport size photo</button>
		      <input type='text' id='mainPhotoId' data-validation="mandatory"  name="mainPhotoId" style="display: none;"/>
		 	 <div style='color: red;' id='mainPhotoIdFeedBack'></div>
		      </div>
		      <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 50 KB.</div>
   		 </div>
   		 <div class="col-lg-2">
           <div class="form-group">
          	<img id="preview" src="#" alt="Preview" style="display:none; width: 70px;"/>
         	<div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
			
            </div>
          </div>   -->
      	
      	
      		<!-- END upload main card holder image -->
      	
         <div class="col-lg-3" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="patbloodgroup">Bloodgroup :</label>
		            <input type="text" class="form-control form-control-sm" id="patbloodgroup" name="patbloodgroup" value=""  data-validation="mandatory" >
		                
		              <div class="invalid-feedback"></div>
		            </div>
		
		
		
		          </div>
   
</div>
</div>

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
      <hr/>
      <div class="row">
      
       <div class="col-lg-3">
        
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatCardtypeS">Card Type :</label>
         <input type="text" class="form-control form-control-sm" id="PatCardtypeS" name="PatCardtypeS"  data-validation="mandatory" value="" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
          <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardcategoryserving">Card Category:</label>
          <select class="form-control form-control-sm" id="patcardcategoryserving" name="patcardcategoryserving" data-validation="mandatory" >
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubcardtypeserving">Card SubCategory:</label>
          <select class="form-control form-control-sm" id="patsubcardtypeserving" name="patsubcardtypeserving" data-validation="mandatory" >
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
       <div class="col-sm-3">
        <div class="form-group">
                    <label class="col-form-label col-form-label-md" for="patsubdeptserving">Organization Name(DDO Code):</label>
          <select class="form-control form-control-sm select2" id="patsubdeptserving" name="patsubdeptserving" data-validation="mandatory">
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
          <label class="col-form-label col-form-label-md" for="patofcadrserving">Offical Address:</label>
          <input type="text" class="form-control form-control-sm" id="patofcadrserving" name="patofcadrserving" data-validation="mandatory,address" placeholder="Office Address">
          <div class="invalid-feedback"></div>
        </div>
    </div>
   <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscaleserving">Pay Level:</label>
          <select class="form-control form-control-sm select1" id="patpayscaleserving" name="patpayscaleserving" data-validation="mandatory,numeric">
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
          <label class="col-form-label col-form-label-md" for="patpayscalevalueserving">Basic Pay:</label>
          <select class="form-control form-control-sm select1" id="patpayscalevalueserving" name="patpayscalevalueserving" data-validation="mandatory,numeric">
            <option value="">Pay Scale Value</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayserving">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayserving" name="patBasicpayserving" data-validation="mandatory">
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
          <label class="col-form-label col-form-label-md" for="PatRetirmentDate">Date Of Retirement / Ending of Deputation :</label>
         <input type="text" class="form-control form-control-sm" id="PatRetirmentDate" name="PatRetirmentDate"  data-validation="mandatory" maxlength="11">
          <div class="invalid-feedback"></div>
        </div>
        </div>
           
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidto">Validity After Renewal:</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidto' name='patcardvalidto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" >
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
    
    <div class="container-fluid" style="display: none;" id="pensionerdept">
      <h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
      <hr/>
 	  <div class="row">
 	  
 	          <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardtypecategorypen">Card Category</label>
          <select class="form-control form-control-sm" id="patcardtypecategorypen" name="patcardtypecategorypen" data-validation="mandatory">
            <option value="">Card Category:</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubcardtypepensioner">Card SubCategory:</label>
          <select class="form-control form-control-sm" id="patsubcardtypepensioner" name="patsubcardtypepensioner"  data-validation="mandatory">
            <option value="">Select Card SubCategory</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
    <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdepartmentP"> Organization Name :</label>
          <select class="form-control form-control-sm select2" id="patdepartmentP" name="patdepartmentP" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>   
    
         <div class="col-lg-3">
               <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubdepartmentP">Organization Name(DDO Code):</label>
          <select class="form-control form-control-sm select2" id="patsubdepartmentP" name="patsubdepartmentP" data-validation="mandatory">
            <option value="">Select Organization Name(DDO Code)</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>  
 	  
           
 	
         

      
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalelevelP">Pay Level:</label>
          <select class="form-control form-control-sm select1" id="patpayscalelevelP" name="patpayscalelevelP" data-validation="mandatory,numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>


   
   
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalevalueP">Basic Pay:</label>
          <select class="form-control form-control-sm select1" id="patpayscalevalueP" name="patpayscalevalueP" data-validation="mandatory,numeric">
            <option value="">Basic pay</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayP">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayP" name="patBasicpayP" data-validation="mandatory">
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
      <div class="col-lg-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmapensioner">Fixed Medical Allowances :</label>
	          <select class="form-control form-control-sm " id="patfmapensioner" name="patfmapensioner" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
  <div class="col-lg-3">
	        <div class="form-group">
	       <label class="col-form-label col-form-label-md" for="patfmafacilitypensioner">Fixed Medical Allowances :</label>
	          <select class="form-control form-control-sm " id="patfmafacilitypensioner" name="patfmafacilitypensioner" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	         
	        </div>
      	</div>
      
      <div class="col-lg-3">
        <div class="form-group">
         <label class="col-form-label col-form-label-md" for="patCardApplyValidity">Card Apply Validity :</label>
        <select class="form-control form-control-sm select1" id="patCardApplyValidity" name="patCardApplyValidity" data-validation="mandatory">
            <option value="">Select Card Apply Validity</option>
          </select>
             <div class="invalid-feedback"></div>
        </div>
      </div>
    <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patppopensioner">PPO Number:</label>
          <input type="text" class="form-control form-control-sm" id="Patppopensioner" name="Patppopensioner" data-validation="numeric" maxlength="11" placeholder="PPO Number">
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
   
    
    
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patdorpensioner">Date Of Retirement :</label>
		  <input type="text" class="form-control form-control-sm"  id='Patdorpensioner' name='Patdorpensioner' readonly="true" placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
      
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidtoP">Valid upto:</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidtoP' name='patcardvalidtoP' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" value="">
          <div class="invalid-feedback"></div>
        </div>
      </div> 


	  </div>
	 
 
</div>


 <div class="table-responsive" id="AutoNumber1" style="display:none;">
 <h4>Family Details</h4>
 <!-- <div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="AddDependent()"><i class='fas fa-save fa-fw' ></i>&nbsp;ADD Dependent</button>
</div>  -->
  <table class="table table-bordered table-striped" >
  <thead>
    <tr>
     <th style="width:5%"><b>S.No</b></th>
       <th style="width:10%">BenId</th>
      <th style="width:10%">Name</th>
       <th style="width:10%">Date of Birth</th>
       <th style="width:10%">Relationship</th>
        <th style="width:10%">Gender</th>
      <!--   <th style="width:10%">Wellness Center</th> -->
<!--         <th style="width:10%">Card Type</th> -->
         <!-- <th style="width:10%">Card ValidUpto</th> -->
         <th style="width:10%">Current Card Validity</th>
        <th style="width:10%">Card Status</th>
        <th style="width:10%">Existing Photo</th>
        <th style="width:10%">Is Renewal Required</th>
        
        <th style="width:10%">Upload New Image</th>
        
<!--         <th style="width:10%">Photo</th>
 -->        
 <!-- <th style="width:15%">Action</th>-->
            <!--   <th>Action</th> -->
	
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
		
  
		  
    
    
     <div class="container-fluid" style="display: none;" id="divDependentInfo">
      <h3 class='mt-4' id='dependentTitle'>Edit Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>

          
           <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepname">Dependent BenId :</label>
	              <input type="text" class="form-control form-control-sm" id="NewdepBenid" name="NewdepBenid" readonly="true" data-validation="mandatory,numeric" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
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
		       
		            <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NewdepvalidUpto">Valid upto :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepvalidUpto' name='NewdepvalidUpto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		               
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

  
  
		   <div class="col-lg-3">
    <!-- <div class="form-group">
      <label class="col-form-label col-form-label-md" for="">Photo:</label>
           
    <img id="editPhoto" src="" alt="Edit Photo" style='width:90px;height:90px'>
    <div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
               	 <div class="invalid-feedback"></div>
    </div> -->
    
    
    </div>
    </div>

  <!--    <div class="col-lg-3">
           <div class="form-group">
          	<img id="editPhoto" src="#" alt="editPhoto" style="display:none; width:90px;height:90px"/>
         	<div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
		 	 	 <div class="invalid-feedback"></div>
            </div>
       <div class="invalid-feedback"></div>
    </div>
 -->

<div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="SaveChanges()"><i class='fas fa-save fa-fw' ></i>&nbsp;Save Details</button>
</div> 
</div>
    
    
 <!--  <div class="legend3">
    	<!-- <button class='btn btn-his-outline btn-sm' id="BTNMODIFY" onclick="saveData1();"><i class='fas fa-save fa-fw'></i>&nbsp;Modify</button> </div>-->
    	
    	
    	 
      <div class="row">
 <div class="legend3">
        <!-- Submit Button -->
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="Previewform()" style="background-color: #007bff; color: white;"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
        </div>
        </div>
    
    
     <div class="container-fluid" style="display: none;" id="divDependentAddInfo">
      <h3 class='mt-4' id='dependentTitle'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>

    
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepnameadd">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="Newdepnameadd" name="Newdepnameadd" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
		  	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdeptrelationadd">Relation :</label>
		              <select class="form-control form-control-sm" id="Newdeptrelationadd" name="Newdeptrelationadd" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		      <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NewdepDOBadd">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepDOBadd' name='NewdepDOBadd' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="newdepgender">Gender :</label>
		              <select class="form-control form-control-sm" id="Newdepgenderadd" name="Newdepgenderadd" data-validation="mandatory">
		                <option value="">Select Gender</option>
		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		       
		            <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NewdepvalidUpto">Valid upto :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepvalidUptoadd' name='NewdepvalidUptoadd' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		               
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
	    		    <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload dependent's passport size photo</button>
	    			</div>
	    			 <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of  50 KB.</div>
		    			  <input type='text'  data-validation="mandatory"  name="fileContent2" style="display: none;"/>
		 	             <div style='color: red;' id='DepPhotoIdFeedBack'></div>
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
    </div>

  

<div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="AddDepDetails()"><i class='fas fa-save fa-fw' ></i>&nbsp;Save Details</button>
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
		
		 <input type="file" accept="image/*" id="fileInput" capture="camera" style="display:none;">
	  <video id="video" width="320" height="240" autoplay style="display:none;"></video>
    <button id="capture" style="display:none;" onclick='captureActualPhoto(event);'>Capture</button>
    <canvas id="canvas" width="320" height="240" style="display:none;"></canvas>
		
		
    </div>
    
<%--  <div class="popup" id="popup">
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
		
		
    </div> --%>
    
    <input type="hidden" name="editRowIndex" id="editRowIndex"/>
       <input type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
            <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
            <input type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden" value=""/>
              <input type="hidden" name="statusflag" id=statusflag value=""/>
   <input type='hidden' name="Benidvalue" id='Benidvalue' value=""  />  
   	             <input type='hidden' name="cardnovalue" id='cardnovalue' value=""  /> 
   	     <input type='hidden' name="parentcitycodehidden" id='parentcitycodehidden' value=""  /> 
   	             
   	             
  </fieldset>    
                
            <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	   <%String primaryKeyFromListPage=(String) request.getSession().getAttribute("SEATID");
	       if(primaryKeyFromListPage==null){
	    	   primaryKeyFromListPage="";
	       }	     	
	     %>
	     <input type='hidden' name="primaryKeyFromListPage" id='primaryKeyFromListPage' value="<%=primaryKeyFromListPage %>"  />  
	     
</form>   



<!-- model for preview renewal form Starts -->

     <div class="modal fade" id="myModalcghsformservingdeptonline" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title text-danger" id="myModalLabel">Please Review Below Application and Click Save to submit application</h4>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                				        	
<div class="container mr-t10 mr-b20">
	<div class="text-right">
	 
	</div>
<div class="row"  id="onlineplasticformhtmlservingdeptonline">
<div class="col-12">
<div class="applyCardForm">
 
	
   <h2 class="text-center">APPLICATION FOR RENEWAL CGHS CARD</h2>	
	<h2 class="text-left">Personal Information</h2>	
   
  <ol>
  <li>Name:-&nbsp;&nbsp;<b> <span id="prevw_name"></b> </span> </li>
    <li>Name in Hindi:-&nbsp;&nbsp;<b><span id="prevw_nameh"></span></b></span></li>
     
   <li>Date Of Birth:-&nbsp;&nbsp;<b><span id="prevw_dob"></span></b></li>
    <li>Gender:- <b><span id="prevw_gender"></span></b></li>
	<li>Mobile:- <b> <span id="prevw_mob"></span></b></li>
	<li>E-mail Id:- <b> <span id="prevw_mail"></span></b></li>
	<li>Residential Address:- <b> <span id="prevw_addr"></b>   </li>
	<li>Relation:- <b> <span id="prevw_relation"></span></b></li>
	<li>State:- <b> <span id="prevw_state"></span></b></li>
	<li>District:- <b> <span id="prevw_district"></span></b></li>
	<li>Pin Code:- <b> <span id="prevw_pin"></span></b></li>
	<li>CGHS City(where Card Applied):- <b><span id="prevw_cghs_city"></span></b></li>
	<li>AD City of satellite City :- <span id="prevw_ad_city"></span></li>
	<li>Wellness Center :- <span id="prevw_wc"></span></li>
	
	<h2 class="text-left">Beneficiary Serving Department Details</h2>
      <li>Card Type:-&nbsp;&nbsp;<b> <span id="prevw_card_type"></b> </span> </li>
      <li>Card Category:-&nbsp;&nbsp;<b> <span id="prevw_card_cat"></b> </span> </li>
      <li>Card SubCategory:-&nbsp;&nbsp;<b> <span id="prevw_card_subcat"></b> </span> </li>
      <li>Organization Name:-&nbsp;&nbsp;<b> <span id="prevw_org_name"></b> </span> </li>
      <li>Organization Name(DDO Code):-&nbsp;&nbsp;<b> <span id="prevw_org_ddo"></b> </span> </li>
      <li>Offical Address:-&nbsp;&nbsp;<b> <span id="prevw_org_ofc_addr"></b> </span> </li>
      <li>Pay Level:-&nbsp;&nbsp;<b> <span id="prevw_pay"></b> </span> </li>
      <li>Basic Pay:-&nbsp;&nbsp;<b> <span id="prevw_basic_pay"></b> </span> </li>
      <li>Basic pay Level:-&nbsp;&nbsp;<b> <span id="prevw_basic_pay_lvl"></b> </span> </li>
      <li>Ward Entitlement:-&nbsp;&nbsp;<b> <span id="prevw_entitlement"></b> </span> </li>
      <li>Date Of Retirement / Ending of Deputation :-&nbsp;&nbsp;<b> <span id="prevw_dor"></b> </span> </li>
      <li>Valid upto:-&nbsp;&nbsp;<b> <span id="prevw_card_validto"></b> </span> </li>

  <!-- <li>Family Details -->
<h2 class="text-left">Family Details</h2>	
  <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber2">
  <thead>
    <tr>
      <th>S.No</b></th>
      <th>BenId</th>
       <th>Name</th>
       <th>Date of Birth</th>
        <th>Relationship</th>
          <th>Gender</th>
          <!-- <th>Card ValidUpto</th> -->
          <th>Current Card Validity</th>
         <!--  <th>Existing Photo</th> -->
         <th>Uploaded Image</th>
          <th>Is Renewal Required</th>
         <!--  <th>Upload New Image</th> -->
	  
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
<!-- </li>  -->


</ol>

    <h1>CGHS Undertaking by Main Card Holder</h1>

    <div class="content">
        <p>I, <span id="mainchnameformdepon"></span>, solemnly affirm and declare as follows:</p>
         <ul id='ulundertakingwithoutdependent'>
	         <!--    <li>&#10004; That the combined monthly income (from all sources including income accruing from house/other immovable property/fixed deposit etc) of any of my dependant (spouse excluded) is less than Rs 9000/- plus DA.</li>
	            <li>&#10004; I shall inform the CGHS immediately of any dependent earning more than Rs 9000/- plus DA (monthly income).</li>
	            <li>&#10004; That in case of any change in the status of my dependents (due to death, marriage, employment), I will inform CGHS at the earliest and will stop use of CGHS facilities by such dependant. I will refund in full, the cost of any treatment that my dependent may have received after he/she became ineligible. I shall be liable for civil/criminal action should I fail to do so.</li>
	           <li>&#10004;That I am NOT a member of any other medical scheme funded by Central Govt, PSU or any other Govt undertaking.</li>
	            <li>&#10004; That my spouse is NOT a member CGHS or any other Govt Scheme.</li>
				
	            <li>&#10004; I understand that in case I have submitted any incorrect information, or if my or my dependents Card is misused or used by any unauthorised person, my membership will be cancelled without any notice or further hearing. In addition, I will forfeit my contribution and I will pay the entire cost of expenditure incurred on such unauthorised person(s). I will also be liable for legal action by the CGHS organisation. I will also immediately report the loss of my CGHS membership card to the nearest CGHS unit.</li>-->
	            <li>&#10004; That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.</li>
	            <li>&#10004; I undertake that in case of any misbehaviour, on my part with any CGHS employee, my membership may be suspended/cancelled/terminated, if proven.</li>
	            <li>&#10004; I understand that the CGHS subscription/ contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of CGHS Scheme.</li> 
        </ul>
    </div>
    
     <div style=" margin-bottom:30px; text-align: right;">
        <p>Signature of the Applicant</p>
        <p>Date: ________________</p>
    </div> 


<div id="sponsoringauthservingdept" >
  <p><strong>UNDERTAKING BY SPONSORING AUTHORITY</strong></p>

  <ul>
    <li>
      The information furnished by the applicant has been verified and found to be correct. It is recommended that a CGHS Card be issued to Shri/Smt./Kumari 
      <span id="mainchnameformdeponundertaking"></span>, at basic pay 
      <span id="dialogbasicpaydepoundertaking"></span> and Pay level 
      <span id="diagogpayscaledeponundertaking"></span> in this Ministry/Department/Organization.
    </li>
    <li>
      Instructions are issued to the concerned Division to start deducting CGHS Subscriptions every month from the salary of the applicant /
      CGHS Subscriptions are deducted every month from the salary of the applicant.
    </li>
    <li >
      I am the authorized sponsoring authority for the issue of CGHS Card and approval of the Competent Authority has been obtained.
    </li>
  </ul>
</div>



    <div style=" margin-bottom:100px; text-align: right;">
       
<p style="margin-top: 2em;">Signature & Name of the Sponsoring Authority</p>
<p>Designation with stamp with Telephone</p>
    </div> 
</div>
	</div>
	</div>
</div>

       
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn btn-primary" onclick="SaveChanges()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Submit</button>                        
                    </div>
                </div>
            </div>
        </div>


<!-- Hidden Personl Info -->

<input type="hidden" id="hiddenPatName" name="hiddenPatName" />
<input type="hidden" id="hiddenpatNameHindi" name="hiddenpatNameHindi" />
<input type="hidden" id="hiddenpatDOB" name="hiddenpatDOB" />
<input type="hidden" id="hiddenpatGender" name="hiddenpatGender" />
<input type="hidden" id="hiddenpatMobile" name="hiddenpatMobile" />
<input type="hidden" id="hiddenpatEmail" name="hiddenpatEmail" />
<input type="hidden" id="hiddenpatresaddress" name="hiddenpatresaddress" />
<input type="hidden" id="hiddenpatrelation" name="hiddenpatrelation" />
<input type="hidden" id="hiddenPatientCghsCity" name="hiddenPatientCghsCity" />
<input type="hidden" id="hiddenpatadcity" name="hiddenpatadcity" />
<input type="hidden" id="hiddenpatientwc" name="hiddenpatientwc" />

<!-- Hidden Department Info -->
<input type="hidden" id="hiddenPatCardtypeS" name="hiddenPatCardtypeS" />
<input type="hidden" id="hiddenpatcardcategoryserving" name="hiddenpatcardcategoryserving" />
<input type="hidden" id="hiddenpatsubcardtypeserving" name="hiddenpatsubcardtypeserving" />
<input type="hidden" id="hiddenpatsubdeptserving" name="hiddenpatsubdeptserving" />
<input type="hidden" id="hiddenpatdeptserving" name="hiddenpatdeptserving" />
<input type="hidden" id="hiddenpatofcadrserving" name="hiddenpatofcadrserving" />
<input type="hidden" id="hiddenpatpayscaleserving" name="hiddenpatpayscaleserving" />
<input type="hidden" id="hiddenpatpayscalevalueserving" name="hiddenpatpayscalevalueserving" />
<input type="hidden" id="hiddenpatBasicpayserving" name="hiddenpatBasicpayserving" />
<input type="hidden" id="hiddenpatentitlementserving" name="hiddenpatentitlementserving" />
<input type="hidden" id="hiddenpatcardvalidto" name="hiddenpatcardvalidto" />
<input type="hidden" id="hiddenpataddressproof" name="hiddenpataddressproof" />
<input type="hidden" id="hiddenpatsalaryproof" name="hiddenpatsalaryproof" />
<input type="hidden" id="hiddenpatstateCode" name="hiddenpatstateCode" />
<input type="hidden" id="hiddenpatdistrictCode" name="hiddenpatdistrictCode" />
<input type="hidden" id="hiddenPatRetirmentDate" name="hiddenPatRetirmentDate" />
<input type="hidden" id="hiddenpatpincodeserving" name="hiddenpatpincodeserving" />
<input type="hidden" id="onlineapplicationhidden" name="onlineapplicationhidden" />
<input type="hidden" id="renewalhidden" name="renewalhidden" />

 

  
     <div style="margin-left: -20px;display:none;" id="getstatusrenewal">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Online Renewal Status</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
        <th style="width: 10%">Sr. No.</th>
        <th style="width: 15%">Tracking No.</th>
        <th style="width: 15%">FirstName</th>
        <th style="width: 10%">ApplyDate</th>
        <th style="width: 10%">CardType</th>
        <th style="width: 10%">Sub CardType</th>
        <th style="width: 10%">Mobile No.</th>
        <th style="width: 15%">Status</th>
<!--           <th style="width: 15%">Remarks</th> -->
                <th style="width: 10%" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
  <div style="text-align: left;">
  <h6>
    If you believe you are eligible as per CGHS rules, please review your details and re-apply with correct and complete information.
  </h6>
  <p>
    For more details on eligibility under CGHS, kindly refer to the FAQs section on the CGHS website.
  </p>
</div>

</div>




<!-- model for preview renewal form Ends --> 
      
</body>
</html>