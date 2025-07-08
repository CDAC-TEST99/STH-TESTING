<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
c
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/agentverify.js"></script>
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
          <input type="text" class="form-control form-control-sm" id="patName" name="patName" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
          <div class="invalid-feedback"></div>
        </div>
      </div>

      <!-- Column 2: Name in Hindi -->
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patNameHindi">Name in Hindi:</label>
          <input type="text" class="form-control form-control-sm" id="patNameHindi" name="patNameHindi" placeholder="Enter Name" data-validation="mandatory" maxlength="100">
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
              <select class="form-control form-control-sm" id="patGender" name="patGender" data-validation="mandatory">
                <option value="">Select Gender</option>
                      </select>
              <div class="invalid-feedback"></div>
      </div>
      
 </div>
    
     
      <div class="col-lg-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patMobileNo">Mobile No.:</label>
              <input type="text" class="form-control form-control-sm" id="patMobileNo" name="patMobileNo" data-validation="" value="" maxlength="10" placeholder=""'>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patEmail">E-mail Address:</label>
              <input type="email" class="form-control form-control-sm" id="patEmail" name="patEmail" data-validation="mandatory,email" placeholder="Enter E-mail Address">
              <div class="invalid-feedback"></div>
            </div>
          </div>
            <div class="col-lg-3">
           <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patresaddress">Residential  Address:</label>
              <input type="text" class="form-control form-control-sm" id="patresaddress" name="patresaddress" data-validation="mandatory,address" placeholder="Enter Official Address">
              <div class="invalid-feedback"></div>
            </div>
          </div>
          
             <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="patrelation">Relation :</label>
		                   <select class="form-control form-control-sm select1" id="patrelation" name="patrelation" data-validation="">
                <option value="">Select Relation</option>
              </select>
		                	                
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
            <div class="col-lg-3" style="display:none">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="stateCode">State :</label>
              <select class="form-control form-control-sm select1" id="stateCode" name="stateCode" data-validation="mandatory">
                <option value="">Select State</option>
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
        
            
        <div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientCghsCity">CGHS City(where Card Applied)</label>
          <select class="form-control form-control-sm select1" id="PatientCghsCity" name="PatientCghsCity" data-validation="mandatory">
            <option value="">Select City</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
                
      </div>
           <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patadcity">AD City of satellite City</label>
          <input type="text" class="form-control form-control-sm" id="patadcity" name="patadcity" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
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
        	 <!--  	<label class="col-form-label col-form-label-md" for="patDeputationyear">Period of completion of Deputation</label>
          		<input type="text" class="form-control form-control-sm" id="patDeputationyear" name="patDeputationyear" data-validation="mandatory,numeric" maxlength="2" placeholder=" Deputation Years"> -->
          		
          		<label class="col-form-label col-form-label-md" for="patDeputationenddate">Enter End Date of Deputation :</label>
				<input type="text" class="form-control form-control-sm"  id='patDeputationenddate' name='patDeputationenddate'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          		<div class="invalid-feedback"></div>
        	</div>
	     </div>
      </div>
       </div>
      <!-- --Pensioner Div -->
      <div class="container-fluid p-4" id="pensionerdept" style="display:none">
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
         
         	<!-- <div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmafacilitypensioner">Facility :</label>
	          <select class="form-control form-control-sm " id="patfmafacilitypensioner" name="patfmafacilitypensioner" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div> -->
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
      <th>Name</th>
      <th>DOB</th>
        <th>Gender</th>
          <th>Relation</th>
            <th>Photo</th>
                       <th>View Id Proof</th>
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
		          
		           <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="spouse">Spouse Joint Declaration:</label>
		             <div id="imagetest2"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
				</div>
				</div>
				
				<div class="row">
				 		          
		     
				</div>
    <!-- <div style="text-align:right;">
    	<button class='btn btn-his' id="BTNMODIFY"><i class='fas fa-save fa-fw' onclick="saveData()"></i>&nbsp;Save Changes</button>
    </div> -->
    
    <div>
    <div class="row">
    
          <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="approve" name="decision" value="approve" onclick="handleDecision()">
            <label class="col-form-label col-form-label-md" for="Approve">Approve</label>
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
				
	
				
				 <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="reject" name="decision" value="reject" onclick="handleDecision()">
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
            		          
		              <div class="invalid-feedback"></div>
		              	 <div class="col-lg-3">
		            <div class="form-group">
		           	      <button class='btn btn-his' id="BTNMODIFY"><i class='fas fa-save fa-fw' onclick="saveData()"></i>&nbsp;Submit</button>
	                       <div class="invalid-feedback"></div>
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
		
		
	 <input type="file" accept="image/*" id="fileInput" capture="camera" style="display:none;">
	  <video id="video" width="320" height="240" autoplay style="display:none;"></video>
    <button id="capture" style="display:none;" onclick='captureActualPhoto(event);'>Capture</button>
    <canvas id="canvas" width="320" height="240" style="display:none;"></canvas>
		
		
    </div>
    
    <input type="hidden" name="editRowIndex" id="editRowIndex"/>
       <input type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
            <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
            <input type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden" value=""/>
              <input type="hidden" name="statusflag" id=statusflag value=""/>
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