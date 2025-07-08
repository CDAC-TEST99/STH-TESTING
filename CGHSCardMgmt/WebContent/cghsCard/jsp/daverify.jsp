<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
  <title>Online Plastic Card</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  
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
  

<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/daverify.js"></script>
<style>
         .close-icon {
            position: relative;
            top: 25px;
            right: -75px;
            background: rgba(255, 255, 255, 0.7);
            border: none;
            cursor: pointer;
            font-size: 20px;
        }
    </style>
 

<script>

function uploaddocstep(){
	if($('#maincardtype').val()=='S'){
    		
       		$('#deptinfoserving').hide();
       		$('#uploaddocument').show();
    	    		
    	}
    	else
    		{
    		$('#uploaddocument').show();
    		$('#deptinfopensioner').hide();
    		
    	
    		}  
  }

</script>
  

  <script>

 
</script>
</head>
<%
String cardtypevalue="";
 cardtypevalue=request.getParameter("hiddenId12");
//System.out.println("value of button"+cardtypevalue);
String buttonvaluenominee="";

buttonvaluenominee=request.getParameter("addnaltomineehidden");
//System.out.println("value of button"+buttonvaluenominee);

String isalternatenominee=request.getParameter("isnomineeadd");
//System.out.println("value of button111111111111111111111111111"+isalternatenominee);

String userMobile=request.getParameter("hiddenmobile");
//System.out.println("value of mobileno" + userMobile);


%>

  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  


<body>

 
<section class="p-0 ">
 
<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" >

	       
  <fieldset  id="ENTRYFORM">          
  <div  class="container-fluid" style="margin-left: -20px;" id="">
  <div class="row">
  
  <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="maincardtype">Card Type :</label>
          <select class="form-control form-control-sm" id="maincardtype" name="maincardtype" data-validation="mandatory">
           <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="subcardtype">Sub Card Type :</label>
          <select class="form-control form-control-sm" id="subcardtype" name="subcardtype" data-validation="mandatory">
            <option value="">Select Sub Card Type</option>
             
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
  </div>
  </div>
  
   <div class="container-fluid" style="margin-left: -20px;" id="perinfo">
      <h3 class='mt-4'>Main CardHolder's Personal Information</h3>
      <hr/>
        <div class="row">
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patName">Name :</label>
              <input type="text" class="form-control form-control-sm" id="patName" name="patName" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
              <div class="invalid-feedback"></div>
            </div>
          </div>

          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patNameHindi">Name in Hindi:</label>
              <input type="text" class="form-control form-control-sm" id="patNameHindi" name="patNameHindi" placeholder="Enter Name" data-validation="mandatory" maxlength="100">
              <div class="invalid-feedback"></div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="form-group">
             	<label class="col-form-label col-form-label-md" for="patDOB">Date Of Birth :</label>
				<input type="text" class="form-control form-control-sm datepickerdob"  id='patDOB' name='patDOB'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
              <div class="invalid-feedback"></div>
            </div>
          </div>
              <div class="col-lg-3" style="display:none;">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patrelation">Relation :</label>
        	   <select class="form-control form-control-sm select1" id="patrelation" name="patrelation" data-validation="mandatory">
                <option value="">Select Relation</option>
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patGender">Gender :</label>
              <select class="form-control form-control-sm" id="patGender" name="patGender" data-validation="mandatory">
                <option value="">Select Gender</option>
                      </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          
          <div class="col-lg-3" style="display: none;">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patBloodGroup">Blood Group :</label>
              <select class="form-control form-control-sm" id="patBloodGroup" name="patBloodGroup" data-validation="mandatory">
                <option value="">Select</option>
                <option value="A+">A+</option>
                <option value="B+">B+</option>
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patMobileNo">Mobile No.:</label>
              <input type="text" class="form-control form-control-sm" id="patMobileNo" name="patMobileNo"  data-validation="mobile,numeric" maxlength="10" placeholder="Enter Mobile No." value=''>
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
              <input type="text" class="form-control form-control-sm" id="patresaddress" name="patresaddress" data-validation="mandatory,address" placeholder="Enter Residential Address">
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
          <div class="col-sm-3" style="display:none;">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientCghsCity">CGHS City(where Card Applied)</label>
          <select class="form-control form-control-sm select1" id="PatientCghsCity" name="PatientCghsCity" data-validation="mandatory">
            <option value="">Select City</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      	</div>
      	     <div class="col-sm-3" style="display:none;">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patadcity">AD City of satellite City</label>
          <input type="text" class="form-control form-control-sm" id="patadcity" name="patadcity" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
      	
        <!--   <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="stateCode">State :</label>
              <select class="form-control form-control-sm select1" id="stateCode" name="stateCode" data-validation="mandatory">
                <option value="">Select State</option>
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div> -->
      
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
						
						<div class="col-lg-3">
           <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientWc">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="PatientWc" name="PatientWc"  data-validation="mandatory">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
                
      </div>
          
          <div class="col-lg-4">
		      <div class="form-group mt-4">
		      <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview' , 'mainPhotoId' );">Upload your photo</button>
		      </div>
		      <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 3 MB.</div>
   		 </div>
   		 <div class="col-lg-2">
           <div class="form-group">
          	<img id="preview" src="#" alt="Preview" style="display:none; width: 70px;"/>
         	<div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
			<input type='hidden' id='mainPhotoId'  name="mainPhotoId"/>
		 	 <div class="invalid-feedback"></div>
            </div>
          </div>
          
            <div class="col-sm-3"  id="Fileuploadmainchidproof">
		           
							<input type="hidden" name="mainchidproof"
								id="filename19" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">ID Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile19" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="19" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon19" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload19"
									onclick="uploadDoc(19,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
		            <div class="col-sm-3"  id="Fileupload3">
		           
							<input type="hidden" name="ResAddressproof"
								id="filename13" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Residential Address Proof">Residential Address Proof <span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile13" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="13" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon13" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload13"
									onclick="uploadDoc(13,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
  
  
    
          
       </div>
		<!-- <div class="legend3">
			<button class='btn btn-his-outline' id="BTNCLEAR1" onclick="clearvaluesperinfo()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="nextStep()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>			
		</div> -->

      </div>
   
  
  <div class="container-fluid" style="display: none;" id="deptinfoserving">
      <h3 class='mt-4'>Beneficiary Serving Department Details</h3>
      <hr/>
      <div class="row">
        <div class="col-sm-6">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdeptserving">Department :</label>
          <select class="form-control form-control-sm select2" id="patdeptserving" name="patdeptserving" data-validation="mandatory">
            <option value="">Select Department</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
    
   
     <!--  <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardtypeserving">Card Type :</label>
          <select class="form-control form-control-sm" id="patcardtypeserving" name="patcardtypeserving" data-validation="mandatory">
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
                  </div>
      </div> -->
      <!--  <div class="col-sm-3">
        <div class="form-group">
       <label class="col-form-label col-form-label-md" for="patcardtypeserving">Card Type ::</label>
	          <input type="text" class="form-control form-control-sm" id="patcardtypeserving" name="patcardtypeserving" value="Serving" readonly="true" data-validation="mandatory" placeholder="">
       <div class="invalid-feedback"></div>
        </div>
      </div> -->
      
      <!-- <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubcardtypeserving">Sub Card Type :</label>
          <select class="form-control form-control-sm" id="patsubcardtypeserving" name="patsubcardtypeserving" data-validation="mandatory">
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> -->
   
      <div class="col-sm-3">
        <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patdesignationserving">Designation :</label>
          <select class="form-control form-control-sm" id="patdesignationserving" name="patdesignationserving" data-validation="mandatory" placeholder="Designation">
            <option value="">Select </option>
            <option value="G">Gazetted</option>
            <option value="NG"> Non-Gazetted</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
   <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscaleserving">Pay Scale :</label>
          <select class="form-control form-control-sm select1" id="patpayscaleserving" name="patpayscaleserving" data-validation="mandatory,numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
    </div>
	<div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpresentpayserving">Present Pay (For Service)* (in Rs.) :</label>
          <input type="text" class="form-control form-control-sm" id="patpresentpayserving" name="patpresentpayserving" data-validation="mandatory,numeric" placeholder="Present Pay">
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
      
      
      <div class="col-sm-3"> 
         <div class="form-group">
        <label class="col-form-label col-form-label-md" for="PatTransferablecityflag">Is your service transferable to another city :</label>
          <select class="form-control form-control-sm" id="PatTransferablecityflag" name="PatTransferablecityflag" data-validation="mandatory" placeholder="Designation">
            <option value="">Select </option>
            <option value="Y">Yes</option>
            <option value="N"> No</option>
          </select>
          <div class="invalid-feedback"></div>
        </div> 
      </div>
      
    
	     <div class="col-sm-3">
	          <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidfromserving">Issued from :</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidfromserving' name='patcardvalidfromserving' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
    <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardvalidtoserving">Valid upto:</label>
		  <input type="text" class="form-control form-control-sm"  id='patcardvalidtoserving' name='patcardvalidtoserving' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
        <div class="col-sm-3 mt-5 ">
	        <div  class="form-check form-switch">
	          <input class="form-check-input" type="checkbox" id="deputationflag" onclick="ShowDeputationyear()"/>
			  <h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Are you on Deputation ?</h5>
			 
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
	   <div class="col-sm-12">
        	<div  class="form-check form-switch">
           		<input class="form-check-input" type="checkbox" id="customCheck11" onclick="showdependentserving()"/>
  				<h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Do You Want to Add Dependent Details ?</h5>
       		</div>
    	</div>
   
    
    	<div class="row">
	    <div class="legend3">
			<button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his-outline ' id="BTNPREV"    onclick="prevStep4()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
			<button class='btn btn-his' id="BTNNEXT"    onclick="Previewformindexcard()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>		    			
		</div>
    </div>	
     </div> 
   </div>
  
      <!-- -div for department information pensioner -->
  <div class="container-fluid" style="display: none;" id="deptinfopensioner">
      <h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
      <hr/>
 	  <div class="row">
 	  
 	   <div class="row">
      <div class="col-sm-6">
        <div  class="form-check form-switch mt-4">
   			<input class="form-check-input" type="checkbox" id="CGHSholdserviceflag" onclick="showalreadycghsbenid()"/>
    		<label class="form-check-label" for="formSwitchCheckDefault" style="color: Blue;font-size:20px" >Did you hold a CGHS card at any point of your service?</label>
       	</div>
      </div>
      
  		<div class="col-sm-3"  id="enterbenidifexist" style="display:none;">
	         <div class="form-group">
         		 <label class="col-form-label col-form-label-md" for="PatPensionerBenid">Enter Benid</label>
         		 <input type="text" class="form-control form-control-sm" id="PatPensionerBenid" name="PatPensionerBenid" data-validation="mandatory,numeric" maxlength="6" placeholder="Enter Benid">
          		 <div class="invalid-feedback"></div>
       		 </div>
	     </div>
      </div>
    	     <div class="col-sm-6">
		        <div class="form-group">
		          <label class="col-form-label col-form-label-md" for="patdeptpensioner">Department :</label>
		          <select class="form-control form-control-sm select2" id="patdeptpensioner" name="patdeptpensioner" data-validation="mandatory">
		           <option value="">Select Department</option>
		           </select>
		          <div class="invalid-feedback"></div>
		        </div>
		      </div>
     
    
      
     <!--  <div class="col-sm-3">
        <div class="form-group">
       <label class="col-form-label col-form-label-md" for="patcardtypepensioner">Card Type ::</label>
	          <input type="text" class="form-control form-control-sm" id="patcardtypepensioner" name="patcardtypepensioner" value="Pensioner" readonly="true" data-validation="mandatory" placeholder="">
       <div class="invalid-feedback"></div>
        </div>
      </div> -->
     <!--  <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubcardtypepensioner">Sub Card Type :</label>
          <select class="form-control form-control-sm" id="patsubcardtypepensioner" name="patsubcardtypepensioner" value="Pensioner" data-validation="mandatory">
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> -->
       <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patBasicpayPensioner">Basic pay Level :</label>
          <select class="form-control form-control-sm select1" id="patBasicpayPensioner" name="patBasicpayPensioner" data-validation="mandatory">
            <option value="">Select Basic Pay Level</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
 	  <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patentitlementpensioner">Ward Entitlement :</label>
          <select class="form-control form-control-sm select1" id="patentitlementpensioner" name="patentitlementpensioner" data-validation="mandatory">
            <option value="">Select Entitlement</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalepensioner">Pay Scale :</label>
          <select class="form-control form-control-sm select1" id="patpayscalepensioner" name="patpayscalepensioner" data-validation="mandatory,numeric">
            <option value="">Pay Scale* (in Rs.)</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      
        <div class="col-sm-3">
	        <div class="form-group" id="patlastpaypensioner">
	          <label class="col-form-label col-form-label-md" for="patlastpaypensioner">Last Pay (For Pensioner)* (in Rs.) :</label>
	          <input type="text" class="form-control form-control-sm" id="patlastpaypensioner" name="patlastpaypensioner" data-validation="mandatory,numeric" placeholder="Last Pay">
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
      	<div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmapensioner">Fixed Medical Allowances :</label>
	          <select class="form-control form-control-sm " id="patfmapensioner" name="patfmapensioner" data-validation="mandatory">
	            
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
      	<div class="col-sm-3">
        <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patCardApplyValidity">Card Apply Validity :</label>
          <select class="form-control form-control-sm" id="patCardApplyValidity" name="patCardApplyValidity" data-validation="mandatory" placeholder="validity">
            <option value="">Select </option>
            <option value="1">One Year</option>
            <option value="2"> 5 Year</option>
            <option value="3"> Life Time</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patppopensioner">PPO Number:</label>
          <input type="text" class="form-control form-control-sm" id="Patppopensioner" name="Patppopensioner" data-validation="mandatory,numeric" maxlength="11" placeholder="PPO Number">
          <div class="invalid-feedback"></div>
        </div>
      </div>
   
     
    <div class="col-sm-3"  id="Fileupload2"  >
		           
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
		  <input type="text" class="form-control form-control-sm"  id='Patdorpensioner' name='Patdorpensioner' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

    <div class="col-sm-3">
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
      </div>
      
      <div class="row" style="display:none;">
	      <div class="col-sm-6">
	        <div  class="form-check form-switch">
			   <input class="form-check-input" type="checkbox" id="customCheck12" onclick="adddepserving()"/>
	  		   <label class="form-check-label" for="formSwitchCheckDefault" style="color: Blue;font-size:20px" >Do You Want to Add Dependent Details?</label>
	        </div>
	       </div>
	  </div>
	  </div>
	   <!-- Buttons Row -->
   <div class="row">
    <div class="legend3">
          <!--  <button class='btn btn-his-outline ' id="BTNPREV"  onclick="prevStep()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
 			<button class='btn btn-his' id="BTNNEXT3"    style="display:none" onclick="adddependentdetail()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button> -->
			<button class='btn btn-his'  id="BTNSAVEFINISH2" onclick="shownomineepensioner()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Proceed</button>
      </div>
    </div> 
</div>
 
     <!-- --Nominee Form -->
   <div class="container-fluid" style="display: none;" id="Nomineeinfo">
      <h3 class='mt-4'>Add Nominee Details</h3>
      <hr/>  
  	    <div class="row">
		          <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="nomname">Nominee Name :</label>
		              <input type="text" class="form-control form-control-sm" id="nomname" name="nomname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="nomdob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='nomdob' name='nomdob'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		        <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="nomrelation">Relation :</label>
		              <select class="form-control form-control-sm" id="nomrelation" name="nomrelation" data-validation="mandatory">
		                <option value="">Select</option>
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="nomgender">Gender :</label>
		              <select class="form-control form-control-sm" id="nomgender" name="nomgender" data-validation="mandatory">
		                <option value="">Select Gender</option>
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		       
		        		
		        <div class="col-lg-3">
		            <div class="form-group">
		            <label class="col-form-label col-form-label-md" for="nommobile">Mobile No:</label>
		              <input type="text" class="form-control form-control-sm" id="nommobile" name="nommobile" placeholder="Enter Mobile" data-validation="mandatory,mobile,numeric" maxlength="10">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		           <div class="col-lg-3">
		            <div class="form-group">
		             <label class="col-form-label col-form-label-md" for="nombenid">CGHS Ben Id(if exist)</label>
		              <input type="text" class="form-control form-control-sm" id="nombenid" name="nombenid" placeholder="Enter BenId" data-validation="numeric" maxlength="5">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		       
		        		
		        <div class="col-lg-3">
		            <div class="form-group">
		            <label class="col-form-label col-form-label-md" for="nomaddress">Address :</label>
		              <input type="text" class="form-control form-control-sm" id="nomaddress" name="nomaddress" placeholder="Enter Address" data-validation="mandatory,address" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		           <div class="col-lg-3" style="display:none">
		            <div class="form-group">
		             <label class="col-form-label col-form-label-md" for="nomaadhar">Aadhar No.(optional)</label>
		              <input type="text" class="form-control form-control-sm" id="nomaadhar" name="nomaadhar" placeholder="Enter Adhar" data-validation="aadhaar" maxlength="16">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          
		          
		            <div class="col-lg-3"  id="filenomineeform" >
		            <div class="form-group">
		              	<input type="hidden" name="NomineeProof"
								id="filename15" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Nominee Proof">Nominee Proof: <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile15" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="15" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon15" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload15"
									onclick="uploadDoc(15,'CARDDOCUMENT','1');">Upload</a>

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
		 <div class="col-lg-12">     
			 <div class="form-group mt-4">
			      <div class="form-check form-switch">
			        <input class="form-check-input" type="checkbox" id="isnomineeaddvalue" onclick="Addanothernominee()">
			        <h5 class="form-check-label text-primary" for="customCheckdisable" >Alternate Nominee Details (if any)</h5>
			      </div>
    		</div>
							
		</div>
    </div>
   
    
   <div class="mt-5"  id="alternamenominee"  style="display:none">
 		<h3 class='mt-4'>Alternate Nominee Details</h3>
      	<hr/>  
 		<div class="row">
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="altnomname">Nominee Name :</label>
              <input type="text" class="form-control form-control-sm" id="altnomname" name="altnomname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
              <div class="invalid-feedback"></div>
            </div>
          </div>

          <div class="col-lg-3">
            <div class="form-group">
             	<label class="col-form-label col-form-label-md" for="altnomdob">Date Of Birth :</label>
				                	<input type="text" class="form-control form-control-sm datepickerdob"  id='altnomdob' name='altnomdob'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">

              <div class="invalid-feedback"></div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="nomrelation">Relation :</label>
              <select class="form-control form-control-sm" id="altnomrelation" name="altnomrelation" data-validation="mandatory">
                <option value="">Select</option>
                		                     
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="nomgender">Gender :</label>
              <select class="form-control form-control-sm" id="altnomgender" name="altnomgender" data-validation="mandatory">
                <option value="">Select Gender</option>
              		              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
		  <div class="col-lg-3">
            <div class="form-group">
            <label class="col-form-label col-form-label-md" for="altnommobile">Mobile No:</label>
              <input type="text" class="form-control form-control-sm" id="altnommobile" name="altnommobile" placeholder="Enter Mobile" data-validation="mandatory,mobile,numeric" maxlength="10">
              <div class="invalid-feedback"></div>
            </div>
          </div>
		
		          
		      
		        
          <div class="col-lg-3">
            <div class="form-group">
             <label class="col-form-label col-form-label-md" for="nombenid">CGHS Ben Id(if exist)</label>
              <input type="text" class="form-control form-control-sm" id="altnombenid" name="altnombenid" placeholder="Enter Benid" data-validation="numeric" maxlength="10">
              <div class="invalid-feedback"></div>
            </div>
          </div>
        
        <div class="col-lg-3">
            <div class="form-group">
            <label class="col-form-label col-form-label-md" for="nomaddress">Address :</label>
              <input type="text" class="form-control form-control-sm" id="altnomaddress" name="altnomaddress" placeholder="Enter Address" data-validation="address" maxlength="100">
              <div class="invalid-feedback"></div>
            </div>
          </div>
           <div class="col-lg-3" style="display:none">
            <div class="form-group">
             <label class="col-form-label col-form-label-md" for="altnomaadhar">Aadhar No.(optional)</label>
              <input type="text" class="form-control form-control-sm" id="altnomaadhar" name="altnomaadhar" placeholder="Enter Aadhar" data-validation="aadhaar" maxlength="16">
              <div class="invalid-feedback"></div>
            </div>
		  </div>
	  </div>
	  
	  
		            <div class="col-lg-3"  id="filealternomineeform" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="AlternamteNomineeProof"
								id="filename17" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Nominee Proof">Alternate Nominee Proof: <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile17" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="17" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon17" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload17"
									onclick="uploadDoc(17,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
	  
	</div>
		   <div class="col-sm-12">
        	<div  class="form-check form-switch">
           		<input class="form-check-input" type="checkbox" id="chkDependent1" onclick="adddeppensioner()"/>
  				<h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Do You Want to Add Dependent Details ?</h5>
       		</div>
    	</div>
	<div class="row">
	    <div class="legend3">
			<button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his-outline ' id="BTNPREV"    onclick="prevStep4()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
			<button class='btn btn-his' id="BTNNEXT"    onclick="Previewformindexcard()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>		    			
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
	
            
       
    <div class="modal fade" id="mymodalprintindexcard" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title" id="myModalLabel"></h2>
                        <button type="button" class="btn btn-primary" onclick="saveData()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Save</button>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                    <div id="printindexcardhtml">
        
<p align="center"><b><font size="2">&#2360;&#2370;&#2330;&#2325;&#0032;&#2325;&#2366;&#2352;&#2381;&#2337;/INDEX CARD<br>&#2349;&#2366;&#2352;&#2340;&#0032;&#2360;&#2352;&#2325;&#2366;&#2352;/GOVERNMENT OF INDIA<br>&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2319;&#2357;&#2306; &#0032;&#2346;&#2352;&#2367;&#2357;&#2366;&#2352;&#0032;&#2325;&#2354;&#2381;&#2351;&#2366;&#2339;&#0032;&#2350;&#2306;&#2340;&#2381;&#2352;&#2366;&#2354;&#2351;/MINISTRY OF HEALTH AND FAMILY WELFARE<br> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#2325;&#2375;&#2344;&#2381;&#2342;&#2381;&#2352;&#2368;&#2351; &#0032;&#2360;&#2352;&#2325;&#2366;&#2352;&#0032;&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2351;&#2379;&#2332;&#2345;&#2366;/CENTRAL GOVERNMENT HEALTH SCHEME</font><font size="2" color="#FF0000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</b><a href="#" onClick="return print()">Print</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:history.go(-1)">Back</a></p>
<div class="table-responsive">
    <table border="0" width="100%">
        <tr>
            <td width="57" align="center"><b><font size="2">1.</font></b></td>
            <td width="515">
                <b>
                    <font size="2">
                       Card Type/Sub CardType
                    </font>
                </b>
            </td>
            <td width="239"><font size="2"> <span id="BenCardType"></span>/<span id="BensubCardType"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">2.</font></b></td>
            <td width="515">
                <b>
                    <font size="2">
                       &#2360;&#2352;&#2325;&#2366;&#2352;&#2368; &#0032;&#2325;&#2352;&#2381;&#2350;&#2330;&#2366;&#2352;&#2368; &#0032;&#2325;&#2366;&#0032;&#2344;&#2366;&#2350;
                        /Name of The Govt Employee
                    </font>
                </b>
            </td>
            <td width="239"><font size="2"> <span id="govEmployeeName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">3.</font></b></td>
            <td width="515">
                <b><font size="2">&#2310;&#2357;&#2366;&#2360;&#2368;&#2351;&#0032;&#2346;&#2340;&#2366;Residential Address</font></b>
            </td>
            <td width="239"><font size="2"><span id="residentialAddress"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">4.</font></b></td>
            <td width="515">
                <b><font size="2">CGHS Wellness Centre:</font></b></td>
            <td width="239"><font size="2"><span id="wellnessCentre"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">5.</font></b></td>
            <td width="515">
                <b><font size="2">Issue Date / Valid Upto:</font></b></td>
            <td width="239"><font size="2">&nbsp;/&nbsp;<span id="issueDate"></span></font>&nbsp;</td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">6.</font></b></td>
            <td width="515">
                <b><font size="2">Entitlement:</font></b></td>
            <td width="239"><font size="2"><span id="entitlement"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">7.</font></b></td>
            <td width="515">
                <b><font size="2">Department Name:</font></b></td>
            <td width="239"><font size="2"><span id="departmentName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">8.</font></b></td>
            <td width="515">
                <b><font size="2"><span id="familyMemberDetails">Family Member Details</span>:</font></b></td>
            <td width="239">&nbsp;</td>
        </tr>
    </table>
</div>

	<br>
 <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber1">
  <thead>
    <tr>
    <th>S.No</b></th>
      <th>Name of Family Member</th>
       <th>Date of Birth</th>
       <th>Relationship</th>
        <th>Gender</th>
          <!-- <th>Blood Group</th> -->
          <th>Photo</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
	<p align="justify" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b></p>

<p align="left" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. &#2351;&#2361; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368;
&#2346;&#2381;&#2354;&#2366;&#2360;&#2381;&#2335;&#2367;&#2325; &#0032;&#2325;&#2366;&#2352;&#2381;&#2337;&#0032;&#2332;&#2366;&#2352;&#2368; &#0032;&#2361;&#2379;&#2344;&#2375; &#0032;&#2340;&#2325;&#0032;&#2357;&#2376;&#2343;&#0032;&#2352;&#2361;&#2375;&#2327;&#2368; &#0032;&#2340;&#2341;&#2366; &#0032;&#2325;&#2375;.&#2360;.&#2360;&#2381;&#2357;&#2366;&#2351;&#2379; &#0032;&#2325;&#2375;&#0032;&#2344;&#2366;&#2350;&#2367;&#2325;&#2366;&#2327;&#2340;&nbsp; &#2344;&#2367;&#2332;&#2368; &#0032;&#2309;&#2360;&#2381;&#2346;&#2340;&#2366;&#2354;&#2379;&#2306; &#0032;&#2350;&#2375;&#2306;&#0032;&#2313;&#2346;&#2330;&#2366;&#2352;&#0032;&#2361;&#2375;&#2340;&#2369; &#0032;&#2349;&#2368;&#0032;&#2357;&#2376;&#2343;&#0032;&#2361;&#2379;&#2327;&#2368; &#0032;|<br>/This Slip is valid till issue of Plastic Card&nbsp;and valid for treatment in CGHS empanelled private hospitals also.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.&#2346;&#2335;&#2354;&#0032;&#2331;&#2379;&#2337;&#2364;&#2344;&#2375; &#0032;&#2360;&#2375;&#0032;&#2346;&#2370;&#2352;&#2381;&#2357;&#0032;&#2325;&#2371;&#2346;&#2351;&#2366; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368 &#0032;&#2350;&#2375;&#2306;&#0032;&#2342;&#2368;&#0032;&#2327;&#2312;&#0032;&#2360;&#2350;&#2360;&#2381;&#2340;&#0032;&#2332;&#2366;&#2344;&#2325;&#2366;&#2352;&#2368; &#0032;&#2325;&#2368;&#0032;&#2332;&#2366;&#2305;&#2330;&#0032;&#2325;&#2352;&#0032;&#2354;&#2375;&#2306;&#0032;|/Please Check the data before leaving the counter.</b></p>

<br>
</div>
</div>
 </div>
</div>
</div>
   
    
        <!--  <input type="hidden" name="addnaltomineehidden" id="addnaltomineehidden" value=""/> -->
               <input type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden" value=""/>
           <!--       <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
                       <input type="hidden" name="isnomineeadd" id="isnomineeadd" value=""/>
                      
                  <input type="hidden" name="cghsbenidexistflag" id="cghsbenidexistflag" value=""/> -->
                    <%--    <input type="hidden" name="userMobile" id="userMobile" value="<%=userMobile%>"/> --%>
                       <!--  <input type="hidden" name="onlineapplicationhidden" id="onlineapplicationhidden" value=""/>-->
                          <input type="hidden" name="isdependentadd" id="isdependentadd" value=""/> 
                         <input type="hidden" name="printindexcardhidden" id="printindexcardhidden" value=""/>
                              <input type="hidden" name="cghsbenidexistflag" id="cghsbenidexistflag" value=""/>
                            <input type="hidden" name="deputationflaghidden" id="deputationflaghidden" value=""/>
                      
               
    
</fieldset>    
                
  
                  <input type="hidden" name="masterKey" id="masterKey" />
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' value=""/>     
	     
	      <input type='hidden' name="primaryKeyFromDelingoffline" id='primaryKeyFromDelingoffline' value=""  /> 
	            <input type='hidden' name="Benidvalue" id='Benidvalue' value=""  />  
	             <input type='hidden' name="cardnovalue" id='cardnovalue' value=""  />  
	       
</form>    
</section>
      


</body>
</html>