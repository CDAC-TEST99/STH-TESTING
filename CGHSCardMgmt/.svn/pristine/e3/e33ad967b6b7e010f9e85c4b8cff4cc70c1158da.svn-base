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


<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
   
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>
 <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/onlineapplyplasticcard.js"></script>
 
 
  <script>
        async function translateText() {
            const text = document.getElementById('patName').value;
          //  alert("text>>>>>>>>>>>"+text);
            const url = 'https://translate.googleapis.com/translate_a/single?client=gtx&sl=english&tl=hi&dt=t&q='+text;

            const response = await fetch(url);
            const data = await response.json();
		//	console.log(data)
            const translatedText = data[0][0][0];
         //   alert("translatedText>>>>>>>>>>>"+translatedText);
			
           document.getElementById('patNameHindi').value = translatedText;
           
        }
    </script>

  <style>
/* Overlay background (semi-transparent) */


    .checkbox-group input[type="checkbox"],
    .checkbox-group label {
        display: inline; /* Ensure checkbox and label appear on the same line */
        vertical-align: middle; /* Align vertically */
    }

  .form-check-input {
    transform: scale(1.5); /* Adjust scale as needed */
    margin-right: 10px;
  }
    .checkbox-group input[type="checkbox"] {
        margin-right: 10px; /* Adds space between the checkbox and the text */
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
  width: 514px;
  text-align: center;
}

/* Question text styling */
#dialogBox p {
  font-size: 16px;
  margin-bottom: 20px;
}

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

        .error {
            color: red;
        }
  
   /*  .checkbox-group {
            margin-bottom: 15px;
        }
        .checkbox-group input {
            margin-right: 10px;
        }
        .checkbox-group label {
            font-size: 14px;
        }
        */
        .error {
            color: red;
            font-size: 14px;
        }
   .content {
            line-height: 1.6;
        }
        .content ul {
            
            margin-left: 20px;
        }
        .content li {
            margin-bottom: 10px;
        }
        .signature {
           
        }
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
System.out.println("value of mobileno" + userMobile);


%>

  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  


<body>
 
 
<section class="p-0 ">
<form  id="form-wrapper" class='p-2' method="post" name="form-wrapper">
	<h3 id='formTitle' class='text-center  p-2  bg-opacity-10'></h3>
	          
  <fieldset  id="ENTRYFORM">          
  
  
   
    <div class="container-fluid"  id="perinfo" style="padding: 0">
      <h3 class='mt-4'>Main CardHolder's Personal Information</h3>
      <hr/>
        <div class="row">
          <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patName">Name :</label>
              <input type="text" class="form-control form-control-sm" id="patName" name="patName"  onblur="translateText()" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100" >
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
				<input type="text" class="form-control form-control-sm"  id='patDOB' name='patDOB'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
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
              <input type="text" class="form-control form-control-sm" id="patMobileNo" name="patMobileNo" readonly="readonly" data-validation="mandatory,mobile,numeric" maxlength="10" placeholder="Enter Mobile No." value='<%=userMobile%>'>
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
              <input type="textarea" class="form-control form-control-sm" id="patresaddress" name="patresaddress" data-validation="mandatory,address" placeholder="Enter Residential Address">
             
              <div class="invalid-feedback"></div>
            </div>
          </div> 
  
          
             <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patPANNo">PAN Number:</label>
              <input type="text" class="form-control form-control-sm" id="patPANNo" name="patPANNo"    placeholder="Enter PAN Number" onblur="validatepancheck()" data-validation="" maxlength="10">
              <div class="invalid-feedback"></div>
          <div id="error-message" class="error"></div>
            </div>
          </div>
             <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpincodeserving">Pin Code</label>
          <input type="text" class="form-control form-control-sm" id="patpincodeserving" name="patpincodeserving" data-validation="mandatory,numeric" maxlength="6" placeholder="Pin Code">
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
          <label class="col-form-label col-form-label-md" for="PatientCghsCity">CGHS Covered City</label>
          <select class="form-control form-control-sm select2" id="PatientCghsCity" name="PatientCghsCity" data-validation="mandatory">
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
        <!--   <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="stateCode">State :</label>
              <select class="form-control form-control-sm select1" id="stateCode" name="stateCode" data-validation="mandatory">
                <option value="">Select State</option>
              </select>
              <div class="invalid-feedback"></div>
            </div>
          </div> -->
      	<div class="col-lg-4">
		      <div class="form-group mt-4">
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
          </div>
       </div>
   		 
         
           <div class="row">
         
            <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="mainchdoctypeid">ID Proof Type:</label>
              <select class="form-control form-control-sm" id="mainchdoctypeid" name="mainchdoctypeid" data-validation="mandatory">
                <option value="">Select ID Proof</option>
                      </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
          
         
            <div class="col-sm-6"  id="Fileuploadmainchidproof" >
		           
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
								.png, Files are allowed upto 2 MB)</span>

		          </div>
		     </div>     
		     <div class="row">     
		     <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patresdoctypeid">Residence Proof Type:</label>
              <select class="form-control form-control-sm" id="patresdoctypeid" name="patresdoctypeid" data-validation="mandatory">
                <option value="">Select Residence Proof</option>
                      </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
		          
		            <div class="col-sm-6"  id="Fileupload3" >
		           
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
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg, .png, Files are allowed upto 2 MB)</span>

		          </div>
  
     
   		 
	<!-- 	<div class="legend3">
			<button class='btn btn-his-outline' id="BTNCLEAR1" onclick="clearvaluesperinfo()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="nextStep()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>			
		</div> -->

      </div>
   </div>
  
   

   <!-- -div for department information Serving -->
    <div class="container-fluid" style="display: none;padding: 0" id="deptinfoserving" >
      <h3 class='mt-4'>Beneficiary Serving Department Details</h3>
      <hr/>
      <div class="row">
      
            <div class="col-sm-4">
        <div class="form-group">
                    <label class="col-form-label col-form-label-md" for="patsubdeptserving">Organization Name(DDO Code):</label>
          <select class="form-control form-control-sm select2" id="patsubdeptserving" name="patsubdeptserving" data-validation="mandatory">
            <option value="">Select Organization Name(DDO code)</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
    <div class="col-sm-4">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdeptserving">Organization Name :</label>
          <select class="form-control form-control-sm select2" id="patdeptserving" name="patdeptserving" data-validation="mandatory">
            <option value="">Select Organization Name</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> 

  <!--  
     <div class="col-sm-4">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patdeptorgserving">Organization :</label>
          <select class="form-control form-control-sm select1" id="patdeptorgserving" name="patdeptorgserving" data-validation="mandatory">
            <option value="">Select Organizaton</option>
         
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div> -->
   
    
       <div class="col-sm-3">
        <div class="form-group">
       <label class="col-form-label col-form-label-md" for="patcardtypeserving">Card Applying for:</label>
	          <input type="text" class="form-control form-control-sm" id="patcardtypeserving" name="patcardtypeserving" value="Serving" readonly="true" data-validation="mandatory" placeholder="">
       <div class="invalid-feedback"></div>
        </div>
      </div>
      
      
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patcardcategoryserving">Card Category:</label>
          <select class="form-control form-control-sm" id="patcardcategoryserving" name="patcardcategoryserving" data-validation="mandatory">
            <option value="">Select Card Type</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patsubcardtypeserving">Card SubCategory:</label>
          <select class="form-control form-control-sm" id="patsubcardtypeserving" name="patsubcardtypeserving" data-validation="mandatory">
            <option value="">Select Card Type</option>
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
      
      
          <div class="col-sm-6"  id="Fileupload35" >
		           
							<input type="hidden" name="Payslip"
								id="filename35" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Pay Slip">Upload Pay Slip: <span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile35" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="35" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon35" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload35"
									onclick="uploadDoc(35,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>

    
        <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patdorserving">Date Of Retirement/End Date of Deputation :</label>
		  <input type="text" class="form-control form-control-sm"  id='Patdorserving' name='Patdorserving' placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" >
          <div class="invalid-feedback"></div>
        </div>
      </div>
    
      
      <div class="row">
      <h5>Are you on Deputation ?</h5>
       <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="depuflag1"  name="depuflag" value="1" onclick="ShowDeputationyear()" data-validation="mandatory">
            <label class="col-form-label col-form-label-md" for="Yes">Yes</label>
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
				
	
				
				 <div class="col-lg-3">
		            <div class="form-group">
		     <input type="radio" id="depuflag2" id="No" name="depuflag" value="2" checked onclick="ShowDeputationyearNo()" data-validation="mandatory">
            <label class="col-form-label col-form-label-md" for="No">No</label>
            		          
		              <div class="invalid-feedback"></div>
		            </div>
		   </div>  
		   
		
      </div>
      <!-- <div class="col-sm-3 mt-5 ">
	        <div  class="form-check form-switch">
	          <input class="form-check-input" type="checkbox" id="deputationflag" onclick="ShowDeputationyear()"/>
			  <h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Are you on Deputation ?</h5>
			 
	    	</div>
	   </div>-->
	   <div class="col-sm-3 "  id="showdepyeardiv" style="display:none;">
	         <div class="form-group">
        	
          		<label class="col-form-label col-form-label-md" for="patDeputationenddate">Expected end date of Deputation' :</label>
				<input type="text" class="form-control form-control-sm"  id='patDeputationenddate' name='patDeputationenddate'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          		<div class="invalid-feedback"></div>
        	</div>
	     </div> 
	<!--    <div class="col-sm-12">
        	<div  class="form-check form-switch mt-3">
           		<input class="form-check-input" type="checkbox" id="chkDependent1" style='width: 62px;height: 30px;margin-right: 10px;' onclick="showdependentserving()"/>
  				<h5 class="form-check-label text-primary" for="formSwitchCheckDefault" >Do You Want to Add Dependent Details ?</h5>
       		</div>
    	</div> -->
   
    
  <div class="row">
  <div class="col-sm-6">
    <div class="form-check mt-3">
      <input class="form-check-input" type="checkbox" id="chkDependent1" onclick="showdependentserving()">
      <label class="form-check-label" for="chkDependent1" style="color: Blue; font-size: 16px;">
        Do you want to add dependent details?
      </label>
    </div>
  </div>
</div>
    <p>Dependents can only be added after the primary card holder's details are completely filled, including the uploading of recent photograph and all required supporting documents. Do not click on Submit button before adding dependent details as the applications cannot be edited after submission</p>
       <!-- Buttons Row -->
    <div class="row">
    <div class="legend3">
				<button class='btn btn-his-outline ' id="BTNCLEARDEPTSERVING" onclick="clearvaluesdeptserving()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
	        	<button class='btn btn-his-outline btn-sm ' id="BTNPREV2"    onclick="prevStep()"><i class='fas fa-save fa-fw'></i>Previous</button>
	      		<button class='btn btn-his' id="BTNNEXT2" style="display:none" onclick="adddependentdetail()" ><i class='fas fa-save fa-fw'></i>Next</button>
	      		  <button class='btn btn-his' id="BTNPreviewDept"   onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button> 
 	      		
	      </div>
    </div>
     </div> 
   </div>
  
    <!-- -end div for department information -->
    
    <!-- -departmentdivfor pensioner -->
    
      <!-- -div for department information pensioner -->
  <div class="container-fluid" style="display: none;padding: 0" id="deptinfopensioner">
      <h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
      <hr/>
 	  <div class="row">
 	  
 	  <!--  <div class="row">
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
      </div> -->
      
           <div class="col-sm-4">
		        <div class="form-group">
		          <label class="col-form-label col-form-label-md" for="patsubdeptpensioner">Organization Name (DDO Code):</label>
		          <select class="form-control form-control-sm select2" id="patsubdeptpensioner" name="patsubdeptpensioner" data-validation="mandatory">
		           <option value="">Select Organization Name (DDO Code)</option>
		           </select>
		          <div class="invalid-feedback"></div>
		        </div>
		      </div>
    	     <div class="col-sm-4">
		        <div class="form-group">
		          <label class="col-form-label col-form-label-md" for="patdeptpensioner">Organization Name :</label>
		          <select class="form-control form-control-sm select2" id="patdeptpensioner" name="patdeptpensioner" data-validation="mandatory">
		           <option value="">Select Organization</option>
		           </select>
		          <div class="invalid-feedback"></div>
		        </div>
		      </div> 
     
    
		      <!-- 
		       <div class="col-sm-4">
		        <div class="form-group">
		          <label class="col-form-label col-form-label-md" for="patorgpensioner">Organization :</label>
		          <select class="form-control form-control-sm select2" id="patorgpensioner" name="patorgpensioner" data-validation="mandatory">
		           <option value="">Select Department</option>
		           </select>
		          <div class="invalid-feedback"></div>
		        </div>
		      </div> -->
      
      <div class="col-sm-3">
        <div class="form-group">
       <label class="col-form-label col-form-label-md" for="patcardtypepensioner">Card Type:</label>
	          <input type="text" class="form-control form-control-sm" id="patcardtypepensioner" name="patcardtypepensioner" value="Pensioner" readonly="true" data-validation="mandatory" placeholder="">
       <div class="invalid-feedback"></div>
        </div>
      </div>
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
     
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalepensioner">Pay Level :</label>
          <select class="form-control form-control-sm select1" id="patpayscalepensioner" name="patpayscalepensioner" data-validation="mandatory,numeric">
            <option value="">Pay Scale</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      
         <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patpayscalevaluepensioner"> Last Basic Pay (in Rs.):</label>
          <select class="form-control form-control-sm select1" id="patpayscalevaluepensioner" name="patpayscalevaluepensioner" data-validation="mandatory,numeric">
            <option value="">Pay Scale Value</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
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
      
      
       <!--  <div class="col-sm-3">
	        <div class="form-group" >
	          <label class="col-form-label col-form-label-md" for="patlastpaypensioner">Last Pay (For Pensioner)* (in Rs.) :</label>
	          <input type="text" class="form-control form-control-sm" id="patlastpaypensioner" name="patlastpaypensioner" data-validation="mandatory,numeric" placeholder="Last Pay">
	          <div class="invalid-feedback"></div>
	        </div>
      	</div> -->
      	<div class="col-sm-3">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="patfmapensioner">Fixed Medical Allowances (FMA)</label>
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
	        <label class="col-form-label col-form-label-md" for="patppodoctypeid">Pension proof :</label>
	          <select class="form-control form-control-sm " id="patppodoctypeid" name="patppodoctypeid" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
      	<div class="col-sm-3">
        <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patCardApplyValidity">Card Apply Validity :</label>
          <select class="form-control form-control-sm" id="patCardApplyValidity" name="patCardApplyValidity" data-validation="mandatory" placeholder="select CardValidity">
           
          </select>
          <div class="invalid-feedback"></div>
        </div>
      </div>
      <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patppopensioner">PPO Number:</label>
          <input type="text" class="form-control form-control-sm" id="Patppopensioner" name="Patppopensioner"  maxlength="" placeholder="PPO Number" onblur="ValidatePPO()">
          <div class="invalid-feedback"></div>
        </div>
      </div>
    
     
    <div class="col-sm-6"  id="Fileupload2" >
		           
							<input type="hidden" name="PPOCertificate"
								id="filename12" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="PPO Certificate/Last Pay">Upload Pension Proof(VRS/PPO/Last payslip): <span class="star text-danger">
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
								.png, Files are allowed upto 2 MB)</span>

		          </div>

    
    
    
       <div class="col-sm-3">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patdorpensioner">Date Of Retirement :</label>
		  <input type="text" class="form-control form-control-sm"  id='Patdorpensioner' name='Patdorpensioner' placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>

   </div>
   
      

	       <!--  <div  class="form-check form-switch  mt-3"> -->
			   <!-- <input class="form-check-input" type="checkbox" id="customCheck12" style='width: 62px;height: 30px;margin-right: 10px;' onclick="showdependentpensioner()"/>
	  		   <label class="form-check-label" for="formSwitchCheckDefault" style="color: Blue;font-size:20px;margin-top:8px" >Do You Want to Add Dependent Details?</label> -->
	             <div class="row">
	      <div class="col-sm-6">
	        <div class="form-check mt-3">
	           <input class="form-check-input" type="checkbox" id="customCheck12" onclick="showdependentpensioner()">
      <label class="form-check-label" for="customCheck12" style="color: Blue; font-size: 16px;">
        Do you want to add dependent details?</label>
	        </div>
	       </div>
	  </div>
	  
	<!--   
	    <div class="row">
  <div class="col-sm-6">
    <div class="form-check mt-3">
      <input class="form-check-input" type="checkbox" id="chkDependent1" onclick="showdependentserving()">
      <label class="form-check-label" for="chkDependent1" style="color: Blue; font-size: 16px;">
        Do you want to add dependent details?
      </label>
    </div>
  </div>
</div> -->
	  
	      <p>Dependents can only be added after the primary card holder's details are completely filled, including the uploading of recent photograph and all required supporting documents. Do not click on Submit button before adding dependent details as the applications cannot be edited after submission</p>
	  
	  </div>
	 

 
    
    
    
    
    
    
    <!-- --Dependent Form -->
    <div class="container-fluid" style="display: none;padding: 0" id="dependentinfo">
      <h3 class='mt-4'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="depname">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="depname" name="depname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
	          
	           	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depentrelation">Relation :</label>
		              <select class="form-control form-control-sm" id="depentrelation" name="depentrelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
	           <div class="col-lg-3">
		            <div class="form-group">
		            <label class="col-form-label col-form-label-md" for="depDOB">Date Of Birth :</label>
				<input type="text" class="form-control form-control-sm"  id='depDOB' name='depDOB'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		             
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		 
		     
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depgender">Gender :</label>
		              <select class="form-control form-control-sm" id="depgender" name="depgender" data-validation="mandatory">
		                <option value="">Select Gender</option>
		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		       
		          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="depmobile">Dependent Mobile :</label>
	              <input type="text" class="form-control form-control-sm" id="depmobile" name="depmobile" placeholder="Enter Mobile" data-validation="mandatory,mobile,numeric" maxlength="10">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
		      <!-- Blood Group Dropdown -->
			  <div class="col-lg-3" style="display: none;" >
			    <div class="form-group">
			      <label class="col-form-label col-form-label-md" for="depBloodGroup">Blood Group:</label>
			      <select class="form-control form-control-sm" id="depBloodGroup" name="depBloodGroup" data-validation="mandatory">
			        <option value="">Select</option>
			        <option value="A+">A+</option>
			        <option value="B+">B+</option>
			      </select>
			      <div class="invalid-feedback"></div>
			    </div>
			  </div>

<div class="col-lg-3" id="DepPAN" style="display: none;">
    <div class="form-group">
        <label class="col-form-label col-form-label-md" for="DepPANNo">PAN Number:</label>
        <input type="text" class="form-control form-control-sm" id="DepPANNo" name="DepPANNo" placeholder="Enter PAN Number" onblur="validatepancheckDependent()" data-validation="" maxlength="10">
        <div class="invalid-feedback"></div>
        <div id="error-message" class="error"></div>
    </div>

    <!-- Checkbox inside DepPAN div -->
    <div class="form-group">
        <div class="form-check">
            <input type="checkbox" class="form-check-input" id="checkBoxPAN" name="checkBoxPANNo" onclick="uploaddeclartion()">
            <label class="form-check-label" for="checkBox">PAN Not Available</label>
        </div>
    </div>
</div>

      <div class="col-sm-3"  id="fileuploadPANNotavailble" style="display:none">
		           
							<input type="hidden" name="depidproof"
								id="filename29" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Undertaking(PAN not Available)<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile29" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="29" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon29" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload29"
									onclick="uploadDoc(29,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

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
		  
		   <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depidproofdoctypeid">Dependent ID Proof Type:</label>
		              <select class="form-control form-control-sm" id="depidproofdoctypeid" name="depidproofdoctypeid" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		   <div class="col-sm-3"  id="fileuploaddepidproof">
		           
							<input type="hidden" name="depidproof"
								id="filename20" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Dependent ID Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile20" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="20" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon20" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload20"
									onclick="uploadDoc(20,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>
		  
		     <div class="col-lg-3" id="depageprooftype" style="display:none;">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depagedoctypeid">Dependent Age Proof Type :</label>
		              <select class="form-control form-control-sm" id="depagedoctypeid" name="depagedoctypeid" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		   <div class="col-sm-3"  id="fileuploadageproof" style="display:none;">
		           
							<input type="hidden" name="depageproof"
								id="filename24" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Dependent Age Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile24" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="24" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon24" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload24"
									onclick="uploadDoc(24,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>
		  
		    <div class="col-lg-3" id="depmarprooftype" style="display:none;">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depmardoctypeid">Dependent Marriage Proof Type :</label>
		              <select class="form-control form-control-sm" id="depmardoctypeid" name="depmardoctypeid" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		   <div class="col-sm-3"  id="fileuploadmarriagedoc" style="display:none;">
		           
							<input type="hidden" name="depmarproof"
								id="filename25" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Dependent Marriage Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile25" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="25" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon25" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload25"
									onclick="uploadDoc(25,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>

		          </div>
		 
		  <div class="col-lg-3" id="spousedoctype" style="display:none">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="depspousedoctypeid">Spouse Proof Type :</label>
		              <select class="form-control form-control-sm" id="depspousedoctypeid" name="depspousedoctypeid" value="Joint Declaration" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div> 
		  
  <div class="col-lg-3"  id="fileuploadspousecertificate" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="Jointdeclartionproof"
								id="filename14" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Joint Certificate">Joint Declaration: <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile14" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="14" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon14" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload14"
									onclick="uploadDoc(14,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
		  
		  <div class="col-lg-3">
			    <div class="form-group mt-3" id="disablecheck" style="display:none">
			      <div class="form-check form-switch">
			        <input class="form-check-input" type="checkbox" id="customCheckdisable" onclick="uploaddisabledocument()">
			        <label class="form-check-label" for="customCheckdisable" style="color: Blue; font-size: 20px;">Is Disable?</label>
			      </div>
			    </div>
        		<div class="invalid-feedback"></div>
          </div>
          
          
          <div class="col-sm-3" id="disabledoctype" style="display:none">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="depdisdoctypeid">Disability proof Type:</label>
	          <select class="form-control form-control-sm " id="depdisdoctypeid" name="depdisdoctypeid" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
          
          <div class="col-lg-3"  id="fileuploaddisablecertificate" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="Disabilitycertificate"
								id="filename11" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Disability Certificate: <span class="star text-danger">
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
									onclick="uploadDoc(11,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
		   
		   
		   <div class="col-sm-3" id="incomestatusdoctype" style="display:none">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="depincomestatusdoctypeid">Income proof Type:</label>
	          <select class="form-control form-control-sm " id="depincomestatusdoctypeid" name="depincomestatusdoctypeid" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
		        <div class="col-lg-3"  id="fileuploadIncomestatus" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="incomestatuscertificate"
								id="filename26" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Income Status Certificate: <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile26" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="26" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon26" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload11"
									onclick="uploadDoc(26,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
		    <div class="col-sm-3" id="adoptionprooftype" style="display:none">
	        <div class="form-group">
	        <label class="col-form-label col-form-label-md" for="adoptiondoctypeid">Adoption Proof:</label>
	          <select class="form-control form-control-sm " id="adoptiondoctypeid" name="adoptiondoctypeid" data-validation="mandatory">
	            
	          </select>
	          <div class="invalid-feedback"></div>
	        </div>
      	</div>
		   
		  <div class="col-lg-3"  id="fileuploadAdoption" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="adoptioncertificate"
								id="filename30" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Adoption Proof: <span class="">
									*</span>
							</label>


							<div id="displayFile30" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="30" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="">

							</div>

							<div id="divFaIcon30" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload11"
									onclick="uploadDoc(30,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 2 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>  
		   
		   
		   
		   
  	</div> 	
		        
    <div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNADDDEP" onclick="adddepinfo()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Add Details</button>
      </div>
    </div>
    <div class="row">
       <div class="col-lg-12">
    	 <table class="table table-striped" id="dependenttable">
        	<thead ><h3>Self and Dependent's Details</h3></thead>
           <thead class="tableHeading">
                <tr>
		          <th>Sr. No.</th>
		          <th>Name</th>
		          <th>DOB</th>
		          <th>Gender</th>
		          <th>Relation</th>
		        <th >Mobile</th>
		          <th>Photo</th>
		           <th>View Document</th>
		            <th>Action</th>
		          <th>
		          </tr>
		      </thead>
		      <tbody></tbody>
         </table>
         </div>
    </div>           
    <div class="legend3" id="undertakingbtnserving" style="display:none;">
  <button class='btn btn-his' id="BTNUNDERTAKINGServing"   onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;Undertaking</button> 
  </div>  
		        
<!-- 	<div class="row">
		 <div class="legend3">
		        <button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
		        <button class='btn btn-his-outline ' id="BTNPREV"  onclick="prevStep3()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
				<button class='btn btn-his' id="BTNNEXT4"    onclick="addnominee()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>
				<button class='btn btn-his' id="BTNPreviewDependent"    onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>	
	      		  <button class='btn btn-his' id="BTNUNDERTAKINGServing"   onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;Undertaking</button> 
 --><!-- 				<button class='btn btn-his' id="BTNPreviewDependent"    onclick="Previewform()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>							
		 </div>
	</div>	 -->
 </div> 
  
   <!-- --Nominee Form -->
   <div class="container-fluid" style="display: none;padding: 0" id="Nomineeinfo">
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
						<input type="text" class="form-control form-control-sm datepickerdob"  id='nomdob' name='nomdob'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
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
		          
		          
		            <div class="col-lg-3" id='OTPRow' style="display: none;">
			  	
			  		<div class="form-group">
				    	<label class="col-form-label col-form-label-md" for="otp">OTP :</label>
				       	<input type="text"  id="userOTP" name="userOTP" class="form-control form-control-lg" placeholder="Enter OTP" maxlength="4" data-validation="mandatory,positiveNumeric">
					  		<span class="input-group-text" id="input-group-right-example"><i class='fa-solid fa-comment-sms fa-xl' ></i></span>
					  		<div class="invalid-feedback"></div>
						
			 	  	</div>
			  
				</div>
			<div class="col-lg-3" >
				
					 <button class="btn btn-his" id="generateBtn" >Verify</button>
		             <button class="btn btn-his" style="display:none" id="validateBtn" >Validate OTP</button>
		          
		             <button class="btn btn-his-outline" id="Reset">Reset</button>
		             <br>
					<button class="btn btn-his-outline" style="display:none" id="resendBtn" >Resend OTP</button>
	            
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
		          
		          
		            <div class="col-lg-3"  id="filenomineeform">
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
								.png, Files are allowed upto 2 MB)</span>



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
				                	<input type="text" class="form-control form-control-sm datepickerdob"  id='altnomdob' name='altnomdob'  placeholder="dd-mm-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">

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
            <label class="col-form-label col-form-label-md" for="nomaddress">Address :</label>
              <input type="text" class="form-control form-control-sm" id="altnomaddress" name="altnomaddress" placeholder="Enter Address" data-validation="mandatory,aaddress" maxlength="100">
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
	  
	  
		            <div class="col-lg-3"  id="filealternomineeform">
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
								.png, Files are allowed upto 2 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
	  
	</div>
	<div class="row">
	    <div class="legend3">
			<button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his-outline ' id="BTNPREV"    onclick="prevStep4()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
			<!-- <button class='btn btn-his' id="BTNNEXT"    onclick="Previewform()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>	 -->	 
			 <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="UnderTaking()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>	   			
		</div>
    </div>	
  </div>
			  	<div class="container-fluid" style="display:none;padding: 0" id="cghsundertakingwithdependent">
      <h3 class='mt-4'>Undertaking by Applicant</h3>
      <hr/>
 	  <div class="row">
    <p>I, <strong><span id="mainchname"></span></strong>, solemnly affirm and declare as follows:</p>

        <!-- Checkbox Statements -->
        
      <label>
      <input type="checkbox" id="select-all"> Select All  Undertaking
      </label>
        <div class="checkbox-group" id="income" >
            <input type="checkbox" id="withdepdent_1"  name="undertakingChk">
             <label for="withdepdent_1" id='withdepdentlbl_1'>
            
              
                That the combined monthly income (from all sources including income accruing from house/other immovable property/fixed deposit etc) of any of my dependents (spouse excluded) is less than Rs 9000/- plus DA.
            </label>
        </div>

        <div class="checkbox-group"  id="parentinlaw" style=display:none;>
            <input type="checkbox" id="withdepdent_2" name="undertakingChk">
           <label for="withdepdent_2" id='withdepdentlbl_2'>
                That my parents or parents-in-law (father/mother or both) do not draw any pension from Central Govt/State Govt/PSUs/any Private Organisation and are normally residing with me.
            </label>
        </div>

        <div class="checkbox-group" id="daughtersister" style=display:none;>
            <input type="checkbox" id="withdepdent_3" name="undertakingChk">
             <label for="withdepdent_3" id='withdepdentlbl_3'>
                That my daughter(s)/sister(s) is/are NOT married or is divorced or is widowed and fully dependent on me.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_4" name="undertakingChk">
              <label for="withdepdent_4" id='withdepdentlbl_4'>
                I shall inform the CGHS immediately of any dependent earning more than Rs 9000/- plus DA (monthly income).
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_5" name="undertakingChk">
            <label for="withdepdent_5" id='withdepdentlbl_5'>
                That in case of any change in the status of my dependents (due to death, marriage, employment), I will inform CGHS at the earliest and will stop use of CGHS facilities by such dependent. I will refund in full, the cost of any treatment that my dependent may have received after he/she became ineligible. I shall be liable for civil/criminal action should I fail to do so.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_6" name="undertakingChk">
               <label for="withdepdent_6" id='withdepdentlbl_6'>
                That I am NOT a member of any other medical scheme funded by Central Govt, PSU or any other Govt undertaking.
            </label>
        </div>

        <div class="checkbox-group"  id="spousecondn" style=display:none;>
            <input type="checkbox" id="withdepdentlbl_7" name="undertakingChk">
            <label for="withdepdent_7" id='withdepdent_7'>
                That my spouse is NOT a member of CGHS or any other Govt Scheme.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_8" name="undertakingChk">
             <label for="withdepdent_8" id='withdepdentlbl_8'>
                I understand that in case I have submitted any incorrect information, or if my or my dependents CGHS Card is misused or used by any unauthorized person, my membership will be cancelled without any notice or further hearing. In addition, I will forfeit my contribution and I will pay the entire cost of expenditure incurred on such unauthorized person(s). I will also be liable for legal action by the CGHS organization. I will also immediately report the loss of my CGHS membership card to the nearest CGHS unit.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_9" name="undertakingChk">
            <label for="withdepdent_9" id='withdepdentlbl_9'>
                That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_10" name="undertakingChk">
            <label for="withdepdent_10" id='withdepdentlbl_10'>
                I undertake that in case of any misbehavior, on my part with any CGHS employee, my membership may be suspended/canceled/terminated, if proven.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="withdepdent_11" name="undertakingChk">
            <label for="withdepdent_11" id='withdepdentlbl_11'>
                I understand that the CGHS subscription/contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of the CGHS Scheme.
            </label>
        </div>

  
</div>


<div class="row">
 <div class="legend3">
        <!-- Submit Button -->
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="saveundertakingwithDep()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
        </div>
        </div>
</div>	





<div class="container-fluid" style="display: none;padding: 0" id="cghsundertakingwithOutdependent">
      <h3 class='mt-4'>CGHS Undertaking</h3>
      <hr/>
 	  <div class="row">
 	      <p>I, <strong><span id="mainchnamewithotdep"></span>, solemnly affirm and declare as follows:</p>
 	  
 	  <label>
      <input type="checkbox" id="select-all1"> Select All  Undertaking
      </label>
 	  <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable_1" name="undertakingChk1">
            <label for="nonRefundable" id='nonRefundablelbl_1'>
              That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.
            </label>
        </div>
         <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable_2" name="undertakingChk1">
            <label for="nonRefundable_2" id='nonRefundablelbl_2'>
            I undertake that in case of any misbehaviour, on my part with any CGHS employee, my membership may be suspended/cancelled/ terminated.
            </label>
        </div>

   <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable_3" name="undertakingChk1">
            <label for="nonRefundable_3" id='nonRefundablelbl_3'>
I understand that the CGHS subscription/ contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of CGHS Scheme. </label>
        </div>
</div>
<div class="row">
 <div class="legend3">
        <!-- Submit Button -->
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="saveundertakingwithoutDep()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
         
        </div>
        </div>
</div>
       
       
<p id="errorMessage" class="error"></p>
    
  
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
<!-- ----Payment DEtails for Pensioner-->


 <!-- <div class="row" style="margin-left: -20px;display:none" id="Paymentinfo" > 
      <div class="col-lg-6 instruction" >
               <h2>CGHS</h2>
		       <h3>Online Apply Plastic Form</h3>
		     <div class="container mt-4">
		    <h2>ADD Payment</h2>
		      <h3>Instructions</h3>
		      	        	      
		     
		        <ol>
		            <li>CGHS Payment through Bharatkosh Portal</li>
		         
		        </ol>

			  </div>
      </div>     
      <div class="col-lg-6 information">
 		 <h4>Payment Details</h4>
  		<div class="form-check ps-0 q-box">
    
		    <div class="row">
		          <div class="col-lg-6">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Bankname">Bank Name :</label>
		              <input type="text" class="form-control form-control-sm" id="Bankname" name="Bankname" placeholder="Enter Name" data-validation="mandatory" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-6">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="paymentmode">Payment Mode</label>
		              <input type="text" class="form-control form-control-sm" id="paymentmode" name="paymentmode" placeholder="payment mode" data-validation="mandatory" maxlength="100">
		
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		        </div>
		
		        <!-- Row 2: DD No -->
		       <!--  <div class="row">
		           <div class="col-lg-6">
		            <div class="form-group">
		            	<label class="col-form-label col-form-label-md" for="draftno">DD No.</label>
		              <input type="text" class="form-control form-control-sm" id="draftno" name="draftno" placeholder="Enter Draft No." data-validation="mandatory" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		
		          <div class="col-lg-6">
		            <div class="form-group">
		           	<label class="col-form-label col-form-label-md" for="amount">Amount</label>
		              <input type="text" class="form-control form-control-sm" id="amount" name="amount" placeholder="Enter Amount" data-validation="mandatory" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		        </div> -->
		
		        <!-- Row 3: Blood Group and Mobile Number -->
		       <!--   <div class="row">
		           <div class="col-lg-6">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="paymentfrom">Payment from:</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='paymentfrom' name='paymentfrom'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		          </div>
		
		        <div class="col-lg-6">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="paymentto">Payment to:</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='paymentto' name='paymentto'  placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		        </div>-->
		
		        
		     <!--    <div class="row">
		      
		       		
		<div class="legend3">
			
			    <button class='btn btn-his-outline' id="BTNPREV5"  onclick="prevstep5()"><i class='fas fa-save fa-fw'></i>&nbsp;PREV</button>
				<button class='btn btn-his' id="BTNNEXT"    onclick=""><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>
					<button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>	
					
						<button class='btn btn-his-outline'  id="BTNPREVIEW" onclick="Previewform()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Preview</button>
							
		</div>
     
    </div>
    </div>
  </div>
</div> -->

	
        <div class="modal fade" id="myModalcghsform" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
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
<div class="row"  id="onlineplasticformhtml">
<div class="col-12">
<div class="applyCardForm">
 
	
   <h2 class="text-center">APPLICATION FOR NEW CGHS CARD</h2>	
	<h4 class="text-center">Acknowledgement No.  :- #trackingId#<strong></strong></h4>
   
  <ol>
  <li>Name of the Applicant:&nbsp;&nbsp;<b> <span id="dialogName"> </span></b> </li>
    <li>Category /Subcategory:&nbsp;&nbsp;<b><span id="dialogcardtype"></span>/<span id="dialogsubcardtype"></span></b></li>
     
   <li>Mobile:&nbsp;&nbsp;<b><span id="dialogemob"></span></b></li>
    <li>E-mail Id:- <b><span id="dialogemail"></span></b></li>
	<li>Residential Address:- <b> <span id="dialogoresadress"></span></b></li>
	<li>PinCode:- <b> <span id="dialogpincode"></span></b></li>
	<li>State:- <b> <span id="dialogstate"></span></b>  /District:- <span id="dialogdistrict"></span>  </li>
	<li>CGHS City:- <b> <span id="dialogcghscity"></span></b></li>
	
	<li>Last Pay / Basic Pension (in case of Pensioners):- <b><span id="dialogpreslastpay"></span></b></li>
	<li>Scale of Pay: <span id="diagogpayscale"></span></li>
	<li>Date of retirement/superannuation: <span id="dialogdateofret"></span>></li>
    <li>Pension related:
    <ol>Do you have PPO? <span id="dialogppostatus"> </span></ol>
    <ol>PPO number: <span id="dialogppono"></span></ol>
	<ol>Are u availing Fixed medical allowance (FMA):</ol> <span id="dialogfma"></span></li>
	<li>Card validity:  <span id="dialogcardvalidity"></span></li>
    <li>Eligible for:<span id="dialogfmaeligible"></li>
 
  <li>Details of Family

  <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber1">
  <thead>
    <tr>
      <th>S.No</b></th>
      <th>Name of Family Member</th>
       <th>Date of Birth</th>
       <th>Relationship</th>
        <th>Gender</th>
          <th>Photo</th>
          <!-- <th>Blood Group</th> -->
          <th>View Document</th>
	  
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
</li>

 <li id='liNominee'><b>Details of Nominee</b>
    <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber3">
  <thead>
    <tr>
      <th>S.No</b></th>
      <th>Name of Nominee</th>
       <th>Date of Birth</th>
       <th>Relationship</th>
        <th>Gender</th>
          <th>Mobile No.</th>
	     </tr>
	</thead>
	<tbody>
   
     
	</tbody>
   </table>
   </div>
   
</li>
<li>
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
		              <label class="col-form-label col-form-label-md" for="PPO">Pay Slip :</label>
		             <div id="imagetest2"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>             
		          		          
				</div>
				</div>
</li>
</ol>

    <h1>CGHS Undertaking by Main Card Holder</h1>

    <div class="content">
        <p>I, <span id="mainchnameform"></span>, solemnly affirm and declare as follows:</p>
           <ul  id='ulundertakingwithoutdependentpensioner'>
            <li>&#10004; I shall inform the CGHS immediately of any dependent earning more than Rs 9000/- plus DA (monthly income).</li>
            <li>&#10004; That in case of any change in the status of my dependents (due to death, marriage, employment), I will inform CGHS at the earliest and will stop use of CGHS facilities by such dependant. I will refund in full, the cost of any treatment that my dependent may have received after he/she became ineligible. I shall be liable for civil/criminal action should I fail to do so.</li>
            <li>&#10004; That I am NOT a member of any other medical scheme funded by Central Govt, PSU or any other Govt undertaking.</li>
            <li>&#10004; That my spouse is NOT a member CGHS or any other Govt Scheme.</li>
            <li>&#10004; I understand that in case I have submitted any incorrect information, or if my or my dependents Card is misused or used by any unauthorised person, my membership will be cancelled without any notice or further hearing. In addition, I will forfeit my contribution and I will pay the entire cost of expenditure incurred on such unauthorised person(s). I will also be liable for legal action by the CGHS organisation. I will also immediately report the loss of my CGHS membership card to the nearest CGHS unit.</li>
            <li>&#10004; That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.</li>
            <li>&#10004; I undertake that in case of any misbehaviour, on my part with any CGHS employee, my membership may be suspended/cancelled/terminated, if proven.</li>
            <li>&#10004; I understand that the CGHS subscription/ contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of CGHS Scheme.</li>
        </ul>
    </div>



<!-- <div id="sponsoringauthpensioner" style="display:none">

UNDERTAKING BY SPONSORING AUTHORITY
<li>&#10004; To be filled by Head of Department where CGHS card applicant is posted)
(Please tick () checkboxes as applicable)
The information furnished by the applicant has been verified and found to be correct. It is recommended that a CGHS Card be issued to Shri/Smt./Kumari-insert name of main card holder, at basic pay -insert from application and Pay level -insert from application-in this Ministry/Department/Organization.</li>

<li>Instructions are issued to the concerned Division to start deducting CGHS Subscriptions every month from the salary of the applicant/CGHS Subscriptions are deducted every month from the salary of the applicant.
</li>


<li>I am the authorized sponsoring authority for the issue of CGHS Card and approval of the Competent Authority has been obtained
</li>




</div> -->
<!-- 
    <div class="signature">
        <p>Signature of the Card Holder</p>
        <p>Date: ________________</p>
    </div> -->
</div>
	</div>
	</div>
</div>

       
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn btn-primary" onclick="saveData()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Save</button>                        
                    </div>
                </div>
            </div>
        </div>
        
     
     
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
 
	
   <h2 class="text-center">APPLICATION FOR NEW CGHS CARD</h2>	
	<h4 class="text-center">Acknowledgement No.  :- #trackingId#<strong></strong></h4>
   
  <ol>
  <li>Name of the Applicant:&nbsp;&nbsp;<b> <span id="dialogNameservindeo"></b> </span> </li>
    <li>Category /Subcategory:&nbsp;&nbsp;<b><span id="dialogcardtypedeo"></span>/<span id="dialogsubcardtypedeo"></span></b></li>
     
   <li>Mobile:&nbsp;&nbsp;<b><span id="dialogemobdepon"></span></b></li>
    <li>E-mail Id:- <b><span id="dialogemaildepon"></span></b></li>
	<li>Residential Address:- <b> <span id="dialogoresadressdepon"></span></b></li>
	<li>PinCode:- <b> <span id="dialogpincodedepon"></span></b></li>
	<li>State:- <b> <span id="dialogstatedepon"></span></b>  /<span id="dialogdistrictdepon"></span>  </li>
	<li>CGHS City:- <b> <span id="dialogcghscitydepon"></span></b></li>
	
	<li>Basic Pay (in Rs.):- <b><span id="dialogbasicpaydepo"></span></b></li>
	<li>Scale of Pay: <span id="diagogpayscaledepon"></span></li>
   <li>Employment related:
  <ul>
    <li>Department: <span id="dialogdeptserving"></span> / <span id="dialogsubdeptserving"></span></li>
    <li>Are you under Deputation: <span id="dialogdepflag"></span></li>
    <li>End Date of Deputation: <span id="dialogdepdate"></span></li>
  </ul>
</li>

  <li>Details of Family

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
          <th></th>
	  
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
</li>


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
				
	            <li>&#10004; I understand that in case I have submitted any incorrect information, or if my or my dependents Card is misused or used by any unauthorised person, my membership will be cancelled without any notice or further hearing. In addition, I will forfeit my contribution and I will pay the entire cost of expenditure incurred on such unauthorised person(s). I will also be liable for legal action by the CGHS organisation. I will also immediately report the loss of my CGHS membership card to the nearest CGHS unit.</li>
	            <li>&#10004; That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.</li>
	            <li>&#10004; I undertake that in case of any misbehaviour, on my part with any CGHS employee, my membership may be suspended/cancelled/terminated, if proven.</li>
	            <li>&#10004; I understand that the CGHS subscription/ contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of CGHS Scheme.</li> -->
        </ul>
    </div>
    
     <div style=" margin-bottom:30px; text-align: right;">
        <p>Signature of the Applicant</p>
        <p>Date: ________________</p>
    </div> 


<div id="sponsoringauthservingdept" style="display:none">
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
    <li>
      I am the authorized sponsoring authority for the issue of CGHS Card and approval of the Competent Authority has been obtained.
    </li>
  </ul>
</div>



    <div style=" margin-bottom:100px; text-align: right;">
       
<p>Signature & Name of the Sponsoring Authority</p>
<p>Designation with stamp with Telephone</p>
    </div> 
</div>
	</div>
	</div>
</div>

       
                    </div>
                    <div class="modal-footer">
                    	<button type="button" class="btn btn-primary" onclick="saveData()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Submit</button>                        
                    </div>
                </div>
            </div>
        </div>
        
       <div id="dialogOverlay" style="display:none;">
  <div id="dialogBox">
    <p>Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?</p>

    <!-- Buttons in a container -->
    <div class="button-container">
      <button class="button yes-button" onclick="handleResponse(true)">
        <i class='fas fa-save fa-fw'></i>&nbsp;Yes
      </button>
      <button class="button no-button" onclick="handleResponse(false)">
        <i class='fas fa-save fa-fw'></i>&nbsp;No
      </button>
    </div>
  </div>
</div>
       
      
 

        <div id="dialogOverlayconfirmpreview" style="display:none;">
  <div id="dialogBox">
    <p>Form cannot be edited or modified after submitting</p>

    <!-- Buttons in a container -->
    <div class="button-container">
      <button class="button yes-button" onclick="handleResponsepreview(true)">
        <i class='fas fa-save fa-fw'></i>&nbsp;OK
      </button>
      <button class="button no-button" onclick="handleResponsepreview(false)">
        <i class='fas fa-save fa-fw'></i>&nbsp;Cancel
      </button>
    </div>
  </div>
</div> 

   <!--     
<div class="table-responsive">
<table class="table table-bordered" id="AutoNumber2" height="310">
	<tbody>
		<tr>
			<td  width="20%" height="133" id='AutoNumber2Iimg1'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg2'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg3'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg4'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg5'></td>
		</tr>
		<tr>
			<td width="20%" height="19" id='AutoNumber2ISno1' ></td>
			<td width="20%" height="19" id='AutoNumber2ISno2' ></td>
			<td width="20%" height="19" id='AutoNumber2ISno3' ></td>
			<td width="20%" height="19"  id='AutoNumber2ISno4' ></td>
			<td width="20%" height="19"  id='AutoNumber2ISno5' ></td>
		</tr>
		<tr>
			<td  width="20%" height="133" id='AutoNumber2Iimg6'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg7'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg8'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg9'></td>
			<td  width="20%" height="133" id='AutoNumber2Iimg10'></td>
		</tr>
		<tr>
			<td width="20%" height="19" id='AutoNumber2ISno6' ></td>
			<td width="20%" height="19" id='AutoNumber2ISno7' ></td>
			<td width="20%" height="19"  id='AutoNumber2ISno8' ></td>
			<td width="20%" height="19"  id='AutoNumber2ISno9' ></td>
			<td width="20%" height="19" id='AutoNumber2ISno10' ></td>
		</tr>
		
	
  </tbody>
</table>
</div> -->
            
   
        <input type="hidden" name="departmentonoffhiddenflag" id="departmentonoffhiddenflag" value=""/>
         <input type="hidden" name="addnaltomineehidden" id="addnaltomineehidden" value=""/>
               <input type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden" value="<%=cardtypevalue%>"/>
                 <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
                       <input type="hidden" name="isnomineeadd" id="isnomineeadd" value=""/>
                         <input type="hidden" name="deputationflaghidden" id="deputationflaghidden" value=""/>
                  <input type="hidden" name="cghsbenidexistflag" id="cghsbenidexistflag" value=""/>
                       <input type="hidden" name="userMobile" id="userMobile" value="<%=userMobile%>"/>                        <input type="hidden" name="onlineapplicationhidden" id="onlineapplicationhidden" value=""/>
                          <input type="hidden" name="isdependentadd" id="isdependentadd" value=""/>
                      <input type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
                                     <input type="hidden" name="formflag" id="formflag" value="0"/>
                      
                        <input type="hidden" name="parentcitycode" id="parentcitycode" value=""/>
                      
               
    
</fieldset>    
                
  
                  <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	      <input type="hidden"  id="otpGen" value="0"/>
	          <input type="hidden"  id="resendClickCount" value="0"/>
</form>    
</section>
      


</body>
</html>