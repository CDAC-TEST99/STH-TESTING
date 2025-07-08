<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%
	try{
	FormFlowXCommonFB fb=(FormFlowXCommonFB) request.getAttribute("FORMBEAN");
	if(fb!=null){
		
%>

<html>

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/testProcess.js"></script>

<style type="text/css">
</style>
</head>
<body>

	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">

		<fieldset id="ENTRYFORM">

			<legend class="w-auto px-2 legendcss" id='formTitle'>JAI
				SHRI GANESH JI MAHARAJ</legend>
			<br />
			<br />



			<div class="legend2 ">
				<button class='btn btn-his-sm  btn-sm ' id="BTNSAVE">
					<i class='fas fa-save fa-fw'></i>&nbsp;Save
				</button>
				<button class='btn btn-his-sm  btn-sm ' id="BTNCANCEL">
					<i class='fa-solid fa-circle-xmark fa-fw'></i>&nbsp;Cancel
				</button>
				<button class='btn btn-his-sm  btn-sm ' id="BTNCLEAR">
					<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear
				</button>
			</div>

			<div class="container-fluid">
				<div id="stepsWizzard" class="container mt-3 mb-3"
					style="display: none;">
					<div class="mt-1 mb-2  text-center">
						<h4 id='stepTitle' class="text-primary"></h4>
					</div>

					<ul class="step d-flex flex-nowrap" id="stepUL">

					</ul>
					<input type="hidden" name="currentStepNo" id="currentStepNo"
						value="1">
				</div>
				<div class="alert alert-success fw-bold" role="alert"
					id='alertMsgCreateAbha' style="display: none;"></div>


				<div class="row  rowborder bg-white p-2 text-dark bg-opacity-10 "
					style="padding-top: 5px;">
					<div class='col-lg-12 bordertext'>
						<h4 class='text-primary'>This is a demo form</h4>
						<p class=''>Kindly take reference from this Page for
							development of forms</p>
					</div>
					<div class="row">
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patName">Patient
									Name :</label> <input type="text" class="form-control form-control-sm"
									id='patName' name='patName' placeholder="Enter Name"
									data-validation="mandatory" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patDOB">Date
									Of Birth :</label> <input type="text"
									class="form-control form-control-sm datepickerdob" id='patDOB'
									name='patDOB' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patGender">Gender
									:</label> <select class="form-control form-control-sm" id='patGender'
									name="patGender" data-validation="mandatory">
									<option value="">Select Gender</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>

						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patMobileNoDemo">Mobile No.:</label> <input type="text"
									class="form-control form-control-sm" id='patMobileNoDemo'
									name='patMobileNoDemo' data-validation="mandatory,mobile"
									placeholder="Enter Mobile No.">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="aadharNo">OTP:</label>
								<input type="text" class="form-control form-control-sm"
									id='OTPDemo' name='OTPDemo'
									data-validation="mandatory,positiveNumeric" maxlength="6"
									placeholder="_ _ _ _ _ _">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class='col-lg-3'>
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for=stateCode">Address
									:</label> <input type="text"
									class="form-control form-control-sm form-control"
									id='patAddress' name='patAddress' placeholder="Enter Address"
									data-validation="mandatory" maxlength="500">
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

						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="aadharNoDemo">Pincode :</label> <input type="text"
									class="form-control form-control-sm" id='pinCode'
									name='pinCode' data-validation="mandatory,positiveNumeric"
									data-minlength="6" placeholder="">
								<div class="invalid-feedback"></div>
							</div>
						</div>




					</div>
					<div class='row'>
						<div class='col-lg-4'>



							<input type="hidden" name="installationCertiFicateDoc"
								id="filename11" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Satisfactory Installation Certificate(SIC)">Satisfactory
								Installation Certificate(SIC) : <span class="star text-danger">
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
									onclick="uploadDoc(11,'TESTF','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



						</div>

						<div class='col-lg-4'>



							<input type="hidden" name="testDoc"
								id="filename12" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Satisfactory Installation Certificate(SIC)">Test : <span class="star text-danger">
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
									onclick="uploadDoc(12,'TESTF','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



						</div>

					</div>
				</div>
			</div>
			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type='hidden' name="hmode" id="hmode" /> <input type='hidden'
				name="tid" id='tid' /> <input type='hidden' name="initMode"
				id='initMode' /> <input type='hidden' name="primaryKeys"
				id='primaryKeys' />
				<input
						type='hidden' name="fileUploadFlag" id='fileUploadFlag' />


		</fieldset>





	</form>
</body>
</html>
<%}
else{
	System.out.println("Form bean is null");	
}
	
}catch(Exception e){
	e.printStackTrace();
}%>