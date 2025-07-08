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
<!--  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
   -->
<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>


<style>
.error {
	color: red;
}

.self-relation {
    background-color: #f2f2f2;
}

.checkbox-group {
	margin-bottom: 15px;
}

.checkbox-group input {
	margin-right: 10px;
}

.checkbox-group label {
	font-size: 14px;
}

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
	margin-top: 30px;
	text-align: right;
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
tr.highlight {
  background-color: #b0f1f5; /* Light Blue background for the highlighted row */
}
</style>


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

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/DAPensionersinglepage.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />


<script type="application/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="application/javascript">
	
	
	
        // Load the transliteration package
        google.charts.load('current', {
            packages: ['transliteration']
        });

        // Callback function to run when Google Charts API is loaded
        function onLoad() {
           // alert("111111111");
            // Define options for the transliteration control
            var options = {
                sourceLanguage: google.elements.transliteration.LanguageCode.ENGLISH, // Source language is English
                destinationLanguage: [google.elements.transliteration.LanguageCode.HINDI], // Destination language is Hindi
                shortcutKey: 'ctrl+g',  // Optional, user can press Ctrl+G to toggle transliteration
                transliterationEnabled: true // Enable transliteration
            };

            // Create the TransliterationControl object
            var control = new google.elements.transliteration.TransliterationControl(options);

            // Make the input field 'patNameHindi' transliterable
            control.makeTransliteratable(['patNameHindi']);
        }

        // Set the callback to run when the Google Charts library is loaded
        google.charts.setOnLoadCallback(onLoad);
    


</script>

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

#pan-box {
	display: none; /* Hide the pan box initially */
}
</style>
</head>
<%

FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");

	String cardtypevalue = "";
	cardtypevalue = request.getParameter("hiddenId12");
	//System.out.println("value of cardtypevalue" + cardtypevalue);
	String buttonvaluenominee = "";

	buttonvaluenominee = request.getParameter("addnaltomineehidden");
	//System.out.println("value of buttonvaluenominee" + buttonvaluenominee);

	String isalternatenominee = request.getParameter("isnomineeadd");
	//System.out.println("value of isalternatenominee" + isalternatenominee);

	String userMobile = request.getParameter("hiddenmobile");
	//System.out.println("value of hiddenmobile" + userMobile);
	String redirectBhavishya = request.getParameter("isBhavishyaRedirect");
	
	String panNumber = request.getParameter("request");
	if (panNumber == null) {
		panNumber = null;
	} else {	
		String panNumberForRequestParam = thirdpartyservices.bhavishya.util.AESEncrytionDecryption.decrypt(panNumber.toString()).trim();
		panNumber = panNumberForRequestParam.substring(0, 10);
	}
	//System.out.println("Value of Redirect Pan Number = "+panNumber);
	
	
	// If Above Pan Number is not set by Redirect URL then we will set PanNumber using FormBean
	if(panNumber == null) {
	//	System.out.println("Pan Number Set By FormBean = "+panNumber);
		panNumber = fb.getPanNumber();
	}
	
	
	String isGlobal = fb.getIsGlobal();
	if (isGlobal == null)
		isGlobal = "0";

		
%>



<body onload="loadDataByPan();">

	<form id="form-wrapper" class='p-2' method="post" name="form-wrapper">
		<h3 id='formTitle' class='text-center  p-2  bg-opacity-10'></h3>

		<!-- <div id="stepsWizzard" class="container mt-3 mb-3"  style="display: none;">
					<div class="mt-1 mb-2  text-center">
						<h4 id='stepTitle' class="text-primary"></h4>
					</div>
					
					<ul class="step d-flex flex-nowrap" id="stepUL">
					  			 	  
					</ul>
					<input type="hidden" name="currentStepNo" id="currentStepNo" value="1">		
			</div>   -->
		<fieldset id="ENTRYFORM">



			<div class="container-fluid" style="margin-left: -20px;" id="perinfo">
				<h3 class='mt-4'>Main CardHolder's Personal Information</h3>
				<hr />
				<div class="row">
					<div class="row">
					<!-- 	<div class="col-sm-6">
							<div class="form-check form-switch mt-4">
								<input class="form-check-input" type="checkbox"
									id="CGHSholdserviceflag" onclick="showalreadycghsbenid()" /> <label
									class="form-check-label" for="formSwitchCheckDefault"
									style="color: Blue; font-size: 20px">Did you hold a
									CGHS card at any point of your service?</label>
							</div>
						</div> -->

						<div class="col-sm-3" id="enterbenidifexist"
							style="display: none;">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="PatPensionerBenid">Enter Benid</label> <input type="text"
									class="form-control form-control-sm" id="PatPensionerBenid"
									name="PatPensionerBenid" data-validation="mandatory,numeric"
									maxlength="6" placeholder="Enter Benid">
								<div class="invalid-feedback"></div>
							</div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patName">Name
								:</label> <input type="text" class="form-control form-control-sm"
								id="patName" name="patName" placeholder="Enter Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<!-- <div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patNameHindi">Name in Hindi:</label> <input type="text"
								class="form-control form-control-sm" id="patNameHindi"
								name="patNameHindi" placeholder="Enter Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div> -->
					<div class="col-lg-2">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patDOB">Date
								Of Birth :</label> <input type="text"
								class="form-control form-control-sm" id='patDOB' name='patDOB'
								placeholder="dd-MM-yyyy" data-validation="mandatory"
								maxlength="11" readonly="readonly">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patrelation">Relation
								:</label> <select class="form-control form-control-sm select1"
								id="patrelation" name="patrelation" data-validation="mandatory">
								<option value="">Select Relation</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patgenderhidden">genderrelationhidden
								:</label> <select class="form-control form-control-sm select1"
								id="patgenderhidden" name="patgenderhidden" data-validation="mandatory">
								<option value="">Select gender</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patrelationhidden">genderrelationhidden
								:</label> <select class="form-control form-control-sm select1"
								id="patrelationhidden" name="patrelationhidden" data-validation="mandatory">
								<option value="">Select Relation</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patGender">Gender
								:</label> <select class="form-control form-control-sm" id="patGender"
								name="patGender" data-validation="mandatory">
								<option value="">Select Gender</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patBloodGroup">Blood Group :</label> <select
								class="form-control form-control-sm" id="patBloodGroup"
								name="patBloodGroup" data-validation="mandatory">
								<option value="">Select</option>
								<option value="A+">A+</option>
								<option value="B+">B+</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patMobileNo">Mobile
								No.:</label> <input type="text" class="form-control form-control-sm"
								id="patMobileNo" name="patMobileNo"
								data-validation="mobile,numeric" maxlength="10"
								placeholder="Enter Mobile No." value=''>
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
								type="textarea" class="form-control form-control-sm"
								id="patresaddress" name="patresaddress"
								data-validation="mandatory,address"
								placeholder="Enter Residential Address">

							<div class="invalid-feedback"></div>
						</div>
					</div>
					
					  
             <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patPANNo">PAN Number:</label>
              <input type="text" class="form-control form-control-sm" id="patPANNo" name="patPANNo"    placeholder="Enter PAN Number" onblur="validatepancheck()" data-validation="mandatory" maxlength="10">
              <div class="invalid-feedback"></div>
          <div id="error-message" class="error"></div>
            </div>
          </div>
					<!--  
          <div class="col-lg-3">
           <div class="form-group">
           <label class="col-form-label col-form-label-md" for="patresaddress1">Residential  Address(address2):</label>
              <input type="text" class="form-control form-control-sm" id="patresaddress1" name="patresaddress1" data-validation="mandatory,address" placeholder="Enter Residential Address">
           
              <div class="invalid-feedback"></div>
            </div>
          </div>  -->


					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patpincodeserving">Pin Code</label> <input type="text"
								class="form-control form-control-sm" id="patpincodeserving"
								name="patpincodeserving" data-validation="mandatory,numeric"
								maxlength="6" placeholder="Pin Code">
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
							<label class="col-form-label col-form-label-md"
								for="PatientCghsCity">CGHS Covered City</label> <select
								class="form-control form-control-sm select1"
								id="PatientCghsCity" name="PatientCghsCity">
								<option value="">Select City</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patadcity">Concerned
								AD's Office</label> <input type="text"
								class="form-control form-control-sm" id="patadcity"
								name="patadcity" data-validation="mandatory" readonly="readonly"
								maxlength="" placeholder="">
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




					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="mainchdoctypeid">ID Proof Type:</label> <select
								class="form-control form-control-sm" id="mainchdoctypeid"
								name="mainchdoctypeid" data-validation="mandatory">
								<option value="">Select ID Proof</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3" id="Fileuploadmainchidproof">

						<input type="hidden" name="mainchidproof" id="filename19" value="" />
						<label class="col-form-label col-form-label-sm" for="ID Proof"
							data-langtag="ID Proof">ID Proof<span
							class="star text-danger"> *</span>
						</label>

						<div id="displayFile19" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patresdoctypeid">Residence Proof Type:</label> <select
								class="form-control form-control-sm" id="patresdoctypeid"
								name="patresdoctypeid" data-validation="mandatory">
								<option value="">Select Residence Proof</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-sm-3" id="Fileupload3">

						<input type="hidden" name="ResAddressproof" id="filename13"
							value="" /> <label class="col-form-label col-form-label-sm"
							for="installationCertiFicate"
							data-langtag="Residential Address Proof">Residential
							Address Proof <span class="star text-danger"> *</span>
						</label>

						<div id="displayFile13" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>

			<!-- 		<div class="col-lg-4">
						<div class="form-group mt-4">
							<button class='btn btn-his-outline'
								onclick="showPopup('fileInput','preview' , 'mainPhotoId' );">Upload
								your photo</button>
							<input type='text' id='mainPhotoId' data-validation="mandatory"
								name="mainPhotoId" style="display: none;" />
							<div style='color: red;' id='mainPhotoIdFeedBack'></div>
						</div>
						<div class="text-primary">Please upload photos in JPG or PNG
							format, with a maximum file size of 10 KB.</div>
					</div> -->
					<div class="col-lg-2">
						<div class="form-group">
							<img id="preview" src="#" alt="Preview"
								style="display: block; width: 70px;" />
							<div class="overlay" id="overlay" onclick="hidePopup()"></div>
							<br>
                   <input type='hidden' id='mainPhotoId' data-validation="mandatory"
								name="mainPhotoId" value="" style="display: none;" />
						</div>
					</div>

				</div>
				<!-- 	<div class="legend3">
			<button class='btn btn-his-outline' id="BTNCLEAR1" onclick="clearvaluesperinfo()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="nextStep()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>			
		</div> -->

			</div>



			<!-- -end div for department information -->

			<!-- -departmentdivfor pensioner -->

			<!-- -div for department information pensioner -->
			<div class="container-fluid" style="display: block;"
				id="deptinfopensioner">
				<h3 class='mt-4'>Beneficiary Pensioner Department Details</h3>
				<hr />
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
							<label class="col-form-label col-form-label-md"
								for="patdeptpensioner">Organization Name :</label> <select
								class="form-control form-control-sm select2"
								id="patdeptpensioner" name="patdeptpensioner"
								data-validation="mandatory">
								<option value="">Select Organization</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-sm-4">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patsubdeptpensioner">Organization Name (DDO Code):</label>
							<select class="form-control form-control-sm select2"
								id="patsubdeptpensioner" name="patsubdeptpensioner"
								data-validation="mandatory">
								<option value="">Select Organization Name (DDO Code)</option>
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
							<label class="col-form-label col-form-label-md"
								for="patcardtypepensioner">Card Type:</label> <input type="text"
								class="form-control form-control-sm" id="patcardtypepensioner"
								name="patcardtypepensioner" value="Pensioner" readonly="true"
								data-validation="mandatory" placeholder="">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patcardtypecategorypen">Card Category</label> <select
								class="form-control form-control-sm" id="patcardtypecategorypen"
								name="patcardtypecategorypen" data-validation="mandatory">
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

					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patpayscalepensioner">Pay Level :</label> <select
								class="form-control form-control-sm select1"
								id="patpayscalepensioner" name="patpayscalepensioner"
								data-validation="mandatory,numeric">
								<option value="">Pay Scale</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patpayscalevaluepensioner"> Last Basic Pay (in
								Rs.):</label> <select class="form-control form-control-sm select1"
								id="patpayscalevaluepensioner" name="patpayscalevaluepensioner"
								data-validation="mandatory,numeric">
								<option value="">Pay Scale Value</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patBasicpayPensioner">Basic pay Level :</label> <select
								class="form-control form-control-sm select1"
								id="patBasicpayPensioner" name="patBasicpayPensioner"
								data-validation="mandatory">
								<option value="">Select Basic Pay Level</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patentitlementpensioner">Ward Entitlement :</label> <select
								class="form-control form-control-sm select1"
								id="patentitlementpensioner" name="patentitlementpensioner"
								data-validation="mandatory">
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
							<label class="col-form-label col-form-label-md"
								for="patfmapensioner">Fixed Medical Allowances (FMA)</label> <select
								class="form-control form-control-sm " id="patfmapensioner"
								name="patfmapensioner" data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patfmafacilitypensioner">Facility :</label> <select
								class="form-control form-control-sm "
								id="patfmafacilitypensioner" name="patfmafacilitypensioner"
								data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patppodoctypeid">Pension proof :</label> <select
								class="form-control form-control-sm " id="patppodoctypeid"
								name="patppodoctypeid" data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="patCardApplyValidity">Card Apply Validity :</label> <select
								class="form-control form-control-sm" id="patCardApplyValidity"
								name="patCardApplyValidity" data-validation="mandatory"
								placeholder="select CardValidity">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="Patppopensioner">PPO Number:</label> <input type="text"
								class="form-control form-control-sm" id="Patppopensioner"
								name="Patppopensioner" data-validation="numeric" data-minlength="12"
								maxlength="12"  placeholder="PPO Number">
							<div class="invalid-feedback"></div>
						</div>
					</div>


					<div class="col-sm-3" id="Fileupload2">

						<input type="hidden" name="PPOCertificate" id="filename12"
							value="" /> <label class="col-form-label col-form-label-sm"
							for="installationCertiFicate"
							data-langtag="PPO Certificate/Last Pay">Upload Pension
							Proof: <span class="star text-danger"> *</span>
						</label>

						<div id="displayFile12" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>




					<div class="col-sm-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="Patdorpensioner">Date Of Retirement :</label> <input
								type="text" class="form-control form-control-sm"
								id='Patdorpensioner' name='Patdorpensioner'
								placeholder="dd-mm-yyyy" data-validation="mandatory"
								maxlength="11" readonly="readonly">
							<div class="invalid-feedback"></div>
						</div>
					</div>




					<div class="row">
						<div class="col-sm-6">
							<div class="form-check form-switch  mt-3">
								<input class="form-check-input" type="checkbox"
									id="customCheck12"
									style='width: 62px; height: 30px; margin-right: 10px;'
									onclick="showdependentpensioner()" /> <label
									class="form-check-label" for="formSwitchCheckDefault"
									style="color: Blue; font-size: 20px; margin-top: 8px">Do
									You Want to Add Dependent Details?</label>
							</div>
						</div>
					</div>
				</div>
			</div>







			<!-- --Dependent Form -->
			<div class="container-fluid" style="display: none;"
				id="dependentinfo">
				<h3 class='mt-4'>Add Dependent Details</h3>
				<hr />
				<div class="row" id='divDependentEntry'>
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="depname">Dependent
								Name :</label> <input type="text" class="form-control form-control-sm"
								id="depname" name="depname" placeholder="Enter Name"
								data-validation="mandatory,alphabetOnly" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="depDOB">Date
								Of Birth :</label> <input type="text"
								class="form-control form-control-sm" id='depDOB' name='depDOB'
								placeholder="dd-Mon-yyyy" data-validation="mandatory"
								maxlength="11" readonly="readonly"> <
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depentrelation">Relation :</label> <select
								class="form-control form-control-sm" id="depentrelation"
								name="depentrelation" data-validation="mandatory">
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>


					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="depgender">Gender
								:</label> <select class="form-control form-control-sm" id="depgender"
								name="depgender" data-validation="mandatory">
								<option value="">Select Gender</option>

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<!-- Blood Group Dropdown -->
					<div class="col-lg-3" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depBloodGroup">Blood Group:</label> <select
								class="form-control form-control-sm" id="depBloodGroup"
								name="depBloodGroup" data-validation="mandatory">
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
								<button class='btn btn-his-outline'
									onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload
									dependent's photo</button>
							</div>
							<div class="text-primary">Please upload photos in JPG or
								PNG format, with a maximum file size of 10 KB.</div>
							<input type='text' data-validation="mandatory"
								name="fileContent2" style="display: none;" />
							<div style='color: red;' id='DepPhotoIdFeedBack'></div>
						</div>
					</div>
					<div class="col-lg-2">
						<div class="form-group">
							<img id="preview2" src="#" alt="Preview2"
								style="display: none; width: 70px" />
							<div class="overlay" id="overlay" onclick="hidePopup()"></div>
							<br> <input type='hidden' id='fileContent2' />
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depidproofdoctypeid">Dependent Proof Type :</label> <select
								class="form-control form-control-sm" id="depidproofdoctypeid"
								name="depidproofdoctypeid" data-validation="mandatory">
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3" id="fileuploaddepidproof">

						<input type="hidden" name="depidproof" id="filename20" value="" />
						<label class="col-form-label col-form-label-sm" for="ID Proof"
							data-langtag="ID Proof">Dependent ID Proof<span
							class="star text-danger"> *</span>
						</label>

						<div id="displayFile20" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>

					<div class="col-lg-3" id="depageprooftype" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depagedoctypeid">Dependent Age Proof Type :</label> <select
								class="form-control form-control-sm" id="depagedoctypeid"
								name="depagedoctypeid" data-validation="mandatory">
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3" id="fileuploadageproof"
						style="display: none;">

						<input type="hidden" name="depageproof" id="filename24" value="" />
						<label class="col-form-label col-form-label-sm" for="ID Proof"
							data-langtag="ID Proof">Dependent Age Proof<span
							class="star text-danger"> *</span>
						</label>

						<div id="displayFile24" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>

					<div class="col-lg-3" id="depmarprooftype" style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depmardoctypeid">Dependent Marriage Proof Type :</label> <select
								class="form-control form-control-sm" id="depmardoctypeid"
								name="depmardoctypeid" data-validation="mandatory">
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-sm-3" id="fileuploadmarriagedoc"
						style="display: none;">

						<input type="hidden" name="depmarproof" id="filename25" value="" />
						<label class="col-form-label col-form-label-sm" for="ID Proof"
							data-langtag="ID Proof">Dependent Marriage Proof<span
							class="star text-danger"> *</span>
						</label>

						<div id="displayFile25" class="file-group">
							<label class="div-inline" style="float: left; margin-right: 2px;"><span
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

						<br /> <br /> <span style="color: red;">(Only .pdf, .jpg,
							.jpeg, .png, Files are allowed upto 200 KB)</span>

					</div>

					<div class="col-lg-3" id="spousedoctype" style="display: none">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depspousedoctypeid">Spouse Proof Type :</label> <select
								class="form-control form-control-sm" id="depspousedoctypeid"
								name="depspousedoctypeid" data-validation="mandatory">
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3" id="fileuploadspousecertificate"
						style="display: none">
						<div class="form-group">
							<input type="hidden" name="Jointdeclartionproof" id="filename14"
								value="" /> <label class="col-form-label col-form-label-sm"
								for="installationCertiFicate" data-langtag="Joint Certificate">Joint
								Declaration: <span class="star text-danger"> *</span>
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

							<br /> <br /> <span style="color: red;">(Only .pdf,
								.jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>



							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group mt-3" id="disablecheck"
							style="display: none">
							<div class="form-check form-switch">
								<input class="form-check-input" type="checkbox"
									id="customCheckdisable" onclick="uploaddisabledocument()">
								<label class="form-check-label" for="customCheckdisable"
									style="color: Blue; font-size: 20px;">Is Disable?</label>
							</div>
						</div>
						<div class="invalid-feedback"></div>
					</div>


					<div class="col-sm-3" id="disabledoctype" style="display: none">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depdisdoctypeid">Disability proof Type:</label> <select
								class="form-control form-control-sm " id="depdisdoctypeid"
								name="depdisdoctypeid" data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3" id="fileuploaddisablecertificate"
						style="display: none">
						<div class="form-group">
							<input type="hidden" name="Disabilitycertificate" id="filename11"
								value="" /> <label class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Disability
								Certificate: <span class="star text-danger"> *</span>
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

							<br /> <br /> <span style="color: red;">(Only .pdf,
								.jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>



							<div class="invalid-feedback"></div>
						</div>
					</div>


					<div class="col-sm-3" id="incomestatusdoctype"
						style="display: none">
						<div class="form-group">
							<label class="col-form-label col-form-label-md"
								for="depincomestatusdoctypeid">Income proof Type:</label> <select
								class="form-control form-control-sm "
								id="depincomestatusdoctypeid" name="depincomestatusdoctypeid"
								data-validation="mandatory">

							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3" id="fileuploadIncomestatus"
						style="display: none">
						<div class="form-group">
							<input type="hidden" name="incomestatuscertificate"
								id="filename26" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Income Status
								Certificate: <span class="star text-danger"> *</span>
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

							<br /> <br /> <span style="color: red;">(Only .pdf,
								.jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>



							<div class="invalid-feedback"></div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-12 text-center">
						<button class='btn btn-his' id="BTNADDDEP" onclick="adddepinfo()">
							<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Add Details
						</button>
					</div>
				</div>
				</div>
				<div id="depinfo">
				<div class="row">
					<div class="col-lg-12">
						<table class="table table-striped" id="dependenttable">
							<thead>
								<h3>Dependent Details</h3>
							</thead>
							<thead class="tableHeading">
								<tr>
									<th>Sr. No.</th>
									<th>Name</th>
									<th>DOB</th>
									<th>Gender</th>
									<th>Relation</th>
									<!-- <th style="display: none;">Blood Group</th> -->
									<th>Photo</th>
									<th>Document</th>
									<th>Action</th>
									<th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
</div>
				<div class="row">
					<!--  <div class="legend3">
		        <button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
		        <button class='btn btn-his-outline ' id="BTNPREV"  onclick="prevStep3()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
				<button class='btn btn-his' id="BTNNEXT4"    onclick="addnominee()"><i class='fas fa-save fa-fw'></i>&nbsp;Next</button>
				<button class='btn btn-his' id="BTNPreviewDependent"    onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;UnderTaking</button>	
	      		  <button class='btn btn-his' id="BTNUNDERTAKINGServing"   onclick="UnderTakingServing()"><i class='fas fa-save fa-fw'></i>&nbsp;Undertaking</button> 
 -->
					<!-- 				<button class='btn btn-his' id="BTNPreviewDependent"    onclick="Previewform()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>							
		 </div> -->
				</div>
			

			<!-- --Nominee Form -->
			<div class="container-fluid" style="display: block;" id="Nomineeinfo">
				<h3 class='mt-4'>Add Nominee Details</h3>
				<hr />
				<div class="row">
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomname">Nominee
								Name :</label> <input type="text" class="form-control form-control-sm"
								id="nomname" name="nomname" placeholder="Enter Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomdob">Date
								Of Birth :</label> <input type="text"
								class="form-control form-control-sm datepickerdob" id='nomdob'
								name='nomdob' placeholder="dd-mm-yyyy"
								data-validation="mandatory" maxlength="11" readonly="readonly">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomrelation">Relation
								:</label> <select class="form-control form-control-sm" id="nomrelation"
								name="nomrelation" data-validation="mandatory">
								<option value="">Select</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>

					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomgender">Gender
								:</label> <select class="form-control form-control-sm" id="nomgender"
								name="nomgender" data-validation="mandatory">
								<option value="">Select Gender</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div>


					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nommobile">Mobile
								No:</label> <input type="text" class="form-control form-control-sm"
								id="nommobile" name="nommobile" placeholder="Enter Mobile"
								data-validation="mandatory,mobile,numeric" maxlength="10">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<!-- <div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nombenid">CGHS
								Ben Id(if exist)</label> <input type="text"
								class="form-control form-control-sm" id="nombenid"
								name="nombenid" placeholder="Enter BenId"
								data-validation="numeric" maxlength="5">
							<div class="invalid-feedback"></div>
						</div>
					</div> -->


					<div class="col-lg-3">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomaddress">Address
								:</label> <input type="text" class="form-control form-control-sm"
								id="nomaddress" name="nomaddress" placeholder="Enter Address"
								data-validation="mandatory,address" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<!-- <div class="col-lg-3" style="display: none">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nomaadhar">Aadhar
								No.(optional)</label> <input type="text"
								class="form-control form-control-sm" id="nomaadhar"
								name="nomaadhar" placeholder="Enter Adhar"
								data-validation="aadhaar" maxlength="16">
							<div class="invalid-feedback"></div>
						</div>
					</div> -->


					<div class="col-lg-3" id="filenomineeform">
						<div class="form-group">
							<input type="hidden" name="NomineeProof" id="filename15" value="" />
							<label class="col-form-label col-form-label-sm"
								for="installationCertiFicate" data-langtag="Nominee Proof">Nominee Declaration
								Proof: <span class="star text-danger"> *</span>
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

							<br /> <br /> <span style="color: red;">(Only .pdf,
								.jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>



							<div class="invalid-feedback"></div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-12">
						<div class="form-group mt-4">
							<div class="form-check form-switch">
								<input class="form-check-input" type="checkbox"
									id="isnomineeaddvalue" onclick="Addanothernominee()">
								<h5 class="form-check-label text-primary"
									for="customCheckdisable">Alternate Nominee Details (if
									any)</h5>
							</div>
						</div>

					</div>
				</div>


				<div class="mt-5" id="alternamenominee" style="display: none">
					<h3 class='mt-4'>Alternate Nominee Details</h3>
					<hr />
					<div class="row">
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="altnomname">Nominee
									Name :</label> <input type="text" class="form-control form-control-sm"
									id="altnomname" name="altnomname" placeholder="Enter Name"
									data-validation="mandatory,alphabetOnly" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="altnomdob">Date
									Of Birth :</label> <input type="text"
									class="form-control form-control-sm datepickerdob"
									id='altnomdob' name='altnomdob' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11" readonly="readonly">

								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="nomrelation">Relation :</label> <select
									class="form-control form-control-sm" id="altnomrelation"
									name="altnomrelation" data-validation="mandatory">
									<option value="">Select</option>

								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="nomgender">Gender
									:</label> <select class="form-control form-control-sm"
									id="altnomgender" name="altnomgender"
									data-validation="mandatory">
									<option value="">Select Gender</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="altnommobile">Mobile No:</label> <input type="text"
									class="form-control form-control-sm" id="altnommobile"
									name="altnommobile" placeholder="Enter Mobile"
									data-validation="mandatory,mobile,numeric" maxlength="10">
								<div class="invalid-feedback"></div>
							</div>
						</div>




						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="nombenid">CGHS
									Ben Id(if exist)</label> <input type="text"
									class="form-control form-control-sm" id="altnombenid"
									name="altnombenid" placeholder="Enter Benid"
									data-validation="numeric" maxlength="10">
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class="col-lg-3">
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="nomaddress">Address
									:</label> <input type="text" class="form-control form-control-sm"
									id="altnomaddress" name="altnomaddress"
									placeholder="Enter Address" data-validation="address"
									maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class="col-lg-3" style="display: none">
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="altnomaadhar">Aadhar No.(optional)</label> <input
									type="text" class="form-control form-control-sm"
									id="altnomaadhar" name="altnomaadhar"
									placeholder="Enter Aadhar" data-validation="aadhaar"
									maxlength="16">
								<div class="invalid-feedback"></div>
							</div>
						</div>
					</div>


					<div class="col-lg-3" id="filealternomineeform">
						<div class="form-group">
							<input type="hidden" name="AlternamteNomineeProof"
								id="filename17" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate" data-langtag="Nominee Proof">Alternate
								Nominee Proof: <span class="star text-danger"> *</span>
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

							<br /> <br /> <span style="color: red;">(Only .pdf,
								.jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>



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
				<!-- <div class="row">
						<div class="legend3">
							<button class='btn btn-his-outline'  id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>
			<button class='btn btn-his-outline ' id="BTNPREV"    onclick="prevStep4()"><i class='fas fa-save fa-fw'></i>&nbsp;Previous</button>
							<button class='btn btn-his' id="BTNNEXT"    onclick="Previewform()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>	
							<button class='btn btn-his' id="BTNUNDERTAKING"
								onclick="UnderTaking()">
								<i class='fas fa-save fa-fw'></i>&nbsp;Next
							</button>
						</div>
					</div> -->
			</div>

		<div class="container-fluid" style="display: none;" id="cghsundertakingwithdependent">
      <h3 class='mt-4'>Undertaking by Applicant</h3>
      <hr/>
 	  <div class="row">
    <p>I, <strong><span id="mainchname"></span></strong>, solemnly affirm and declare as follows:</p>

        <!-- Checkbox Statements -->
        
      <label>
      <input type="checkbox" id="select-all"> Select All  Undertaking
      </label>
        <div class="checkbox-group" id="income" >
            <input type="checkbox" id="income"  name="undertakingChk">
            <label for="income">
                That the combined monthly income (from all sources including income accruing from house/other immovable property/fixed deposit etc) of any of my dependents (spouse excluded) is less than Rs 9000/- plus DA.
            </label>
        </div>

        <div class="checkbox-group"  id="parentinlaw" style=display:none;>
            <input type="checkbox" id="parents" name="undertakingChk">
            <label for="parents">
                That my parents or parents-in-law (father/mother or both) do not draw any pension from Central Govt/State Govt/PSUs/any Private Organisation and are normally residing with me.
            </label>
        </div>

        <div class="checkbox-group" id="daughtersister" style=display:none;>
            <input type="checkbox" id="daughters" name="undertakingChk">
            <label for="daughters">
                That my daughter(s)/sister(s) is/are NOT married or is divorced or is widowed and fully dependent on me.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="incomeChange" name="undertakingChk">
            <label for="incomeChange">
                I shall inform the CGHS immediately of any dependent earning more than Rs 9000/- plus DA (monthly income).
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="statusChange" name="undertakingChk">
            <label for="statusChange">
                That in case of any change in the status of my dependents (due to death, marriage, employment), I will inform CGHS at the earliest and will stop use of CGHS facilities by such dependent. I will refund in full, the cost of any treatment that my dependent may have received after he/she became ineligible. I shall be liable for civil/criminal action should I fail to do so.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="medicalScheme" name="undertakingChk">
            <label for="medicalScheme">
                That I am NOT a member of any other medical scheme funded by Central Govt, PSU or any other Govt undertaking.
            </label>
        </div>

        <div class="checkbox-group"  id="spousecondn" style=display:none;>
            <input type="checkbox" id="spouseScheme" name="undertakingChk">
            <label for="spouseScheme">
                That my spouse is NOT a member of CGHS or any other Govt Scheme.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="incorrectInfo" name="undertakingChk">
            <label for="incorrectInfo">
                I understand that in case I have submitted any incorrect information, or if my or my dependents CGHS Card is misused or used by any unauthorized person, my membership will be cancelled without any notice or further hearing. In addition, I will forfeit my contribution and I will pay the entire cost of expenditure incurred on such unauthorized person(s). I will also be liable for legal action by the CGHS organization. I will also immediately report the loss of my CGHS membership card to the nearest CGHS unit.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="misuseCard" name="undertakingChk">
            <label for="misuseCard">
                That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="misbehavior" name="undertakingChk">
            <label for="misbehavior">
                I undertake that in case of any misbehavior, on my part with any CGHS employee, my membership may be suspended/canceled/terminated, if proven.
            </label>
        </div>

        <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable" name="undertakingChk">
            <label for="nonRefundable">
                I understand that the CGHS subscription/contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of the CGHS Scheme.
            </label>
        </div>

  
</div>


<div class="row">
 <div class="legend3">
        <!-- Submit Button -->
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="saveundertakingwithDep()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
   <!--      <button type="button" class="submit-btn" onclick="submitForm()">Submit Undertaking</button> -->
        </div>
        </div>
</div>	


<!-- <div class="row">
 <div class="legend3">
        Submit Button
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="saveundertakingwithDep()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
        <button type="button" class="submit-btn" onclick="submitForm()">Submit Undertaking</button>
        </div>
        </div>
</div>	
 -->


<div class="container-fluid" style="display: none;" id="cghsundertakingwithOutdependent">
      <h3 class='mt-4'>CGHS Undertaking</h3>
      <hr/>
 	  <div class="row">
 	      <p>I, <strong><span id="mainchnamewithotdep"></span>, solemnly affirm and declare as follows:</p>
 	  
 	  <label>
      <input type="checkbox" id="select-all1"> Select All  Undertaking
      </label>
 	  <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable" name="undertakingChk1">
            <label for="nonRefundable">
              That in case of any misuse of my CGHS card or tampering with bills or attempt to defraud, once I become a member, I will forfeit my membership automatically.
            </label>
        </div>
         <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable" name="undertakingChk1">
            <label for="nonRefundable">
            I undertake that in case of any misbehaviour, on my part with any CGHS employee, my membership may be suspended/cancelled/ terminated.
            </label>
        </div>

   <div class="checkbox-group">
            <input type="checkbox" id="nonRefundable" name="undertakingChk1">
            <label for="nonRefundable">
I understand that the CGHS subscription/ contribution I am making is not refundable even if I do not make use of any CGHS facility or opt out of CGHS Scheme. </label>
        </div>
</div>
<div class="row">
 <div class="legend3">
        <!-- Submit Button -->
         <button class='btn btn-his' id="BTNUNDERTAKING"    onclick="saveundertakingwithoutDep()"><i class='fas fa-save fa-fw'></i>&nbsp;Preview</button>
   <!--      <button type="button" class="submit-btn" onclick="submitForm()">Submit Undertaking</button> -->
        </div>
        </div>
</div>

			<p id="errorMessage" class="error"></p>


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


				<input type="file" accept="image/*" id="fileInput" capture="camera"
					style="display: none;">
				<video id="video" width="320" height="240" autoplay
					style="display: none;"></video>
				<button id="capture" style="display: block;"
					onclick='captureActualPhoto(event);'>Capture</button>
				<canvas id="canvas" width="320" height="240" style="display: none;"></canvas>


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

			<div class="modal fade" id="myModalcghsform" tabindex="-1"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title text-danger" id="myModalLabel">Please
								Review Below Application and Click Save to submit application</h4>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="container mr-t10 mr-b20">
								<div class="text-right"></div>
								<div class="row" id="onlineplasticformhtml">
									<div class="col-12">
										<div class="applyCardForm">


											<h2 class="text-center">APPLICATION FOR NEW CGHS CARD</h2>
<!-- 											<h4 class="text-center"> -->
<!-- 												Acknowledgement No. :- #trackingId#<strong></strong> -->
<!-- 											</h4> -->

											<ol><li>Name of the Applicant:-&nbsp;&nbsp;<b> <span
														id="dialogName"></span></b> 
												</li>
												<li>Category/Subcategory:-&nbsp;&nbsp;<b><span
														id="dialogcardtypeBhavishya"></span>/<span id="dialogsubcardtype"></span></b></li>

												<li>Mobile:-&nbsp;&nbsp;<b><span id="dialogemob"></span></b></li>
												<li>E-mail Id:-&nbsp;&nbsp;<b><span id="dialogemail"></span></b></li>
												<li>Residential Address:-&nbsp;&nbsp;<b> <span
														id="dialogoresadress"></span></b></li>
												<li>PinCode:-&nbsp;&nbsp;<b> <span id="dialogpincode"></span></b></li>
												<li>State:-&nbsp;&nbsp;<b> <span id="dialogstate"></span></b> /<span
													id="dialogdistrict"></span>
												</li>
												<li>CGHS City:-&nbsp;&nbsp;<b> <span id="dialogcghscity"></span></b></li>

												<li>Last Basic Pay:-&nbsp;&nbsp;<b><span id="dialogpreslastpay"></span></b>
												</li>
												<li>Scale of Pay:-&nbsp;&nbsp;<span id="diagogpayscale"></span></li>
												<li>Date of retirement/superannuation:-&nbsp;&nbsp;<span
													id="dialogdateofret"></span></li>
												<li>Pension related:
													<ol>Do you have PPO ? &nbsp;&nbsp;<span id="patPpoStatus"></span>
													</ol>
													<ol>PPO number:-&nbsp;&nbsp;<span id="patPpoNumber"></span>
													</ol>
													<ol>Are you availing Fixed medical allowance (FMA) ? &nbsp;&nbsp;<span id="dialogfma"></span>
													</ol> 
												</li>
												<li>Card Validity: As chosen by applicant from drop
													down- <span id="dialogcardvalidity"></span>
												</li>
												<li>Eligible for:-&nbsp;&nbsp;<span id="dialogFmaFacilityBhavishya"></span></li>

												<li>Details of Family

													<div class="table-responsive">
														<table class="table table-bordered table-striped"
															id="AutoNumber1">
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

												<li id='liNominee'><b>Details of Nominee</b>
													<div class="table-responsive">
														<table class="table table-bordered table-striped"
															id="AutoNumber3">
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

													<p class="font-14 cr-red">{# Please attach Nominee
														form}</p></li>
											</ol>

											<h1>CGHS Undertaking by Main Card Holder</h1>

											<div class="content">
												<p>
													I, <span id="mainchnameform"></span>, solemnly affirm and
													declare as follows:
												</p>
												<ul>
													<li>&#10004; That the combined monthly income (from
														all sources including income accruing from house/other
														immovable property/fixed deposit etc) of any of my
														dependant (spouse excluded) is less than Rs 9000/- plus
														DA.</li>
													<li>&#10004; I shall inform the CGHS immediately of
														any dependent earning more than Rs 9000/- plus DA (monthly
														income).</li>
													<li>&#10004; That in case of any change in the status
														of my dependents (due to death, marriage, employment), I
														will inform CGHS at the earliest and will stop use of CGHS
														facilities by such dependant. I will refund in full, the
														cost of any treatment that my dependent may have received
														after he/she became ineligible. I shall be liable for
														civil/criminal action should I fail to do so.</li>
													<li>&#10004; That I am NOT a member of any other
														medical scheme funded by Central Govt, PSU or any other
														Govt undertaking.</li>
													<li>&#10004; That my spouse is NOT a member CGHS or
														any other Govt Scheme.</li>
													<li>&#10004; I understand that in case I have
														submitted any incorrect information, or if my or my
														dependents Card is misused or used by any unauthorised
														person, my membership will be cancelled without any notice
														or further hearing. In addition, I will forfeit my
														contribution and I will pay the entire cost of expenditure
														incurred on such unauthorised person(s). I will also be
														liable for legal action by the CGHS organisation. I will
														also immediately report the loss of my CGHS membership
														card to the nearest CGHS unit.</li>
													<li>&#10004; That in case of any misuse of my CGHS
														card or tampering with bills or attempt to defraud, once I
														become a member, I will forfeit my membership
														automatically.</li>
													<li>&#10004; I undertake that in case of any
														misbehaviour, on my part with any CGHS employee, my
														membership may be suspended/cancelled/terminated, if
														proven.</li>
													<li>&#10004; I understand that the CGHS subscription/
														contribution I am making is not refundable even if I do
														not make use of any CGHS facility or opt out of CGHS
														Scheme.</li>
												</ul>
											</div>



											<div id="sponsoringauthpensioner" style="display: none">

												UNDERTAKING BY SPONSORING AUTHORITY
												<li>&#10004; To be filled by Head of Department where
													CGHS card applicant is posted) (Please tick () checkboxes
													as applicable) The information furnished by the applicant
													has been verified and found to be correct. It is
													recommended that a CGHS Card be issued to
													Shri/Smt./Kumari-insert name of main card holder, at basic
													pay -insert from application and Pay level -insert from
													application-in this Ministry/Department/Organization.</li>

												<li>Instructions are issued to the concerned Division
													to start deducting CGHS Subscriptions every month from the
													salary of the applicant/CGHS Subscriptions are deducted
													every month from the salary of the applicant.</li>


												<li>I am the authorized sponsoring authority for the
													issue of CGHS Card and approval of the Competent Authority
													has been obtained</li>


											</div>

										</div>
									</div>
								</div>
							</div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								onclick="saveData()" id="SAVEPREVIEW" data-bs-dismiss="modal">Save</button>
						</div>
					</div>
				</div>
			</div>






			<div class="modal fade" id="myModalcghsformservingdeptonline"
				tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog modal-xl">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title text-danger" id="myModalLabel">Please
								Review Below Application and Click Save to submit application</h4>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="container mr-t10 mr-b20">
								<div class="text-right"></div>
								<div class="row" id="onlineplasticformhtmlservingdeptonline">
									<div class="col-12">
										<div class="applyCardForm">


											<h2 class="text-center">APPLICATION FOR NEW CGHS CARD</h2>
											<h4 class="text-center">
												Acknowledgement No. :- #trackingId#<strong></strong>
											</h4>

											<ol>
												<li>Name of the Applicant:&nbsp;&nbsp;<b> <span
														id="dialogNameservindeo"></b> </span>
												</li>
												<li>Category /Subcategory:&nbsp;&nbsp;<b><span
														id="dialogcardtypedeo"/>/<span
															id="dialogsubcardtypedeo"></span></b></li>

												<li>Mobile:&nbsp;&nbsp;<b><span
														id="dialogemobdepon"></span></b></li>
												<li>E-mail Id:- <b><span id="dialogemaildepon"></span></b></li>
												<li>Residential Address:- <b> <span
														id="dialogoresadressdepon"></span></b></li>
												<li>PinCode:- <b> <span id="dialogpincode"></span></b></li>
												<li>State:- <b> <span id="dialogstatedepon"></span></b>
													/<span id="dialogdistrictdepon"></span>
												</li>
												<li>CGHS City:- <b> <span id="dialogcghscitydepon"></span></b></li>

												<li>Basic Pay (in Rs.):- <b><span
														id="dialogbasicpaydepo"></span></b></li>
												<li>Scale of Pay: <span id="diagogpayscaledepon"></span></li>
												<li>Employment related:
													<ol>
														Department:
														<span id="dialogdeptserving"></span>
													</ol>
													<ol>Are you under Deputation.
													</ol> <span id="dialogdepflag"></span>
											</ol>
											<ol>End Date of Deputation.
											</ol>
											<span id="dialogdepdate"></span>
											</ol>
											</li>

											<li>Details of Family

												<div class="table-responsive">
													<table class="table table-bordered table-striped"
														id="AutoNumber1">
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
												<p>
													I, <span id="mainchnameformdepon"></span>, solemnly affirm
													and declare as follows:
												</p>
												<ul>
													<li>&#10004; That the combined monthly income (from
														all sources including income accruing from house/other
														immovable property/fixed deposit etc) of any of my
														dependant (spouse excluded) is less than Rs 9000/- plus
														DA.</li>
													<li>&#10004; I shall inform the CGHS immediately of
														any dependent earning more than Rs 9000/- plus DA (monthly
														income).</li>
													<li>&#10004; That in case of any change in the status
														of my dependents (due to death, marriage, employment), I
														will inform CGHS at the earliest and will stop use of CGHS
														facilities by such dependant. I will refund in full, the
														cost of any treatment that my dependent may have received
														after he/she became ineligible. I shall be liable for
														civil/criminal action should I fail to do so.</li>

													<li>&#10004;That I am NOT a member of any other
														medical scheme funded by Central Govt, PSU or any other
														Govt undertaking.</li>
													<li>&#10004; That my spouse is NOT a member CGHS or
														any other Govt Scheme.</li>

													<li>&#10004; I understand that in case I have
														submitted any incorrect information, or if my or my
														dependents Card is misused or used by any unauthorised
														person, my membership will be cancelled without any notice
														or further hearing. In addition, I will forfeit my
														contribution and I will pay the entire cost of expenditure
														incurred on such unauthorised person(s). I will also be
														liable for legal action by the CGHS organisation. I will
														also immediately report the loss of my CGHS membership
														card to the nearest CGHS unit.</li>
													<li>&#10004; That in case of any misuse of my CGHS
														card or tampering with bills or attempt to defraud, once I
														become a member, I will forfeit my membership
														automatically.</li>
													<li>&#10004; I undertake that in case of any
														misbehaviour, on my part with any CGHS employee, my
														membership may be suspended/cancelled/terminated, if
														proven.</li>
													<li>&#10004; I understand that the CGHS subscription/
														contribution I am making is not refundable even if I do
														not make use of any CGHS facility or opt out of CGHS
														Scheme.</li>
												</ul>
											</div>



											<div id="sponsoringauthservingdept" style="display: none">

												UNDERTAKING BY SPONSORING AUTHORITY
												<li>&#10004; To be filled by Head of Department where
													CGHS card applicant is posted) (Please tick () checkboxes
													as applicable) The information furnished by the applicant
													has been verified and found to be correct. It is
													recommended that a CGHS Card be issued to
													Shri/Smt./Kumari-insert name of main card holder, at basic
													pay -insert from application and Pay level -insert from
													application-in this Ministry/Department/Organization.</li>

												<li>Instructions are issued to the concerned Division
													to start deducting CGHS Subscriptions every month from the
													salary of the applicant/CGHS Subscriptions are deducted
													every month from the salary of the applicant.</li>


												<li>I am the authorized sponsoring authority for the
													issue of CGHS Card and approval of the Competent Authority
													has been obtained</li>


												<!-- 
<li>Instructions to card applicant:
i.Take Print out of the duly filled form. 
ii.Attach self-attested copies of all supporting documents that were uploaded online.
iii.Request sponsoring authority of your concerned department to do the needful with respect to Pg.3 ie "Undertaking by Sponsoring authority."
iv.Please submit the duly filed and department forwarded CGHS card application form along with supporting documents to the O/o Additional Director of CGHS in your city. 
v.Kindly note down the Acknowledgement number at the top of the form. This Acknowledgement number shall enable you to track the status of your card application.
</li> -->
												<ul>
													<li>Instructions to card applicant:</li>
													<li>i. Take printout of the duly filled form.</li>
													<li>ii. Attach self-attested copies of all supporting
														documents that were uploaded online.</li>
													<li>iii. Request sponsoring authority of your
														concerned department to do the needful with respect to
														Pg.3 i.e., "Undertaking by Sponsoring authority."</li>
													<li>iv. Please submit the duly filled and department
														forwarded CGHS card application form along with supporting
														documents to the O/o Additional Director of CGHS in your
														city.</li>
													<li>v. Kindly note down the Acknowledgement number at
														the top of the form. This Acknowledgement number shall
														enable you to track the status of your card application.</li>
													<li>Acknowledgment Number: ${acknowledgmentNumber}</li>
													<!-- Dynamic content -->
												</ul>

											</div>

										</div>
									</div>
								</div>
							</div>


						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								onclick="saveData()" id="SAVEPREVIEW" data-bs-dismiss="modal">Submit</button>
						</div>
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


			<input type="hidden" name="departmentonoffhiddenflag"	id="departmentonoffhiddenflag" value="" />
						<input type="hidden" name="genderbhaviysacodehidden"	id="genderbhaviysacodehidden" value="" />
						<input type="hidden" name="genderbhaviysanamehidden"	id="genderbhaviysanamehidden" value="" />
			
			 <input type="hidden"
				name="addnaltomineehidden" id="addnaltomineehidden" value="" /> <input
				type="hidden" name="cardtypevaluehidden" id="cardtypevaluehidden"
				value="P" /> <input type="hidden" name="isdisablityvaluehidden"
				id="isdisablityvaluehidden" value="" /> <input type="hidden"
				name="isnomineeadd" id="isnomineeadd" value="" /> <input
				type="hidden" name="deputationflaghidden" id="deputationflaghidden"
				value="" /> <input type="hidden" name="cghsbenidexistflag"
				id="cghsbenidexistflag" value="" />  <input
				type="hidden" name="onlineapplicationhidden"
				id="onlineapplicationhidden" value="" />
				 <input type="hidden"  name="isdependentaddbhavisya" id="isdependentaddbhavisya" value="" /> 
				 <input
				type='hidden' name="fileUploadFlag" id='fileUploadFlag' /> <input
				type="hidden" name="parentcitycode" id="parentcitycode" value="" />

			<input type="hidden" name="userMobile" id="userMobile" value="<%=userMobile%>" />
			<input type="hidden" name="panNumber" id="panNumber" value="<%=panNumber%>" />
			<input type="hidden" name="redirectBhavishya" id="redirectBhavishya" value="<%=redirectBhavishya%>" />
			

		</fieldset>


		<input type="hidden" name="masterKey" id="masterKey" /> 
		<input type='hidden' name="hmode" id="hmode" /> 
		<input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>" /> 
		<input type='hidden' name="tid" id='tid' /> 
		<input type='hidden' name="initMode" id='initMode' /> 
		<input type='hidden' name="primaryKeys" id='primaryKeys' /> 
		
			
		<select id="genderMasterForBhavishya" type="hidden" />
		<select id="relationMasterForBhavishya" type="hidden" />


	</form>



</body>
</html>