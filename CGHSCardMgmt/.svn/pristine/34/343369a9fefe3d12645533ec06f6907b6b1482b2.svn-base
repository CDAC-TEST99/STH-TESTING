<%@page import="formFlowX.fb.FormFlowXCommonFB"%>

<%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>

<html>

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/PanVerification.js"></script>

<style type="text/css">
</style>



</head>
<body>

	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" class='bannersection'	method="post">

		<fieldset id="ENTRYFORM">


			<div class="container-fluid text-center"><h1>PAN Verification</h1><br/>
				<h2 class='text-primary text-center mb-3'>Welcome! Please enter your PAN details carefully to ensure smooth verification</h2>
			
			</div>

			

				<div class="row">
					<div class='col-lg-3'>
						<div class="form-group ">
							<label class="col-form-label col-form-label-md" for=stateCode">PAN
								Number :</label> <input type="text"
								class="form-control form-control-sm form-control" id='patPanno'
								name='patPanno' placeholder="Enter PAN Number"
								data-validation="mandatory" maxlength="10"
								onblur="validatepancheck()">
							<div class="invalid-feedback"></div>
							<div id="error-message" class="error"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patName">
								Name :</label> <input type="text" class="form-control form-control-sm"
								id='patName' name='patName' placeholder="Enter Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3' style="display: none;">
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patfather">
								Father Name :</label> <input type="text"
								class="form-control form-control-sm" id='patfather'
								name='patfather' placeholder="Enter father Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patDOB">Date
								Of Birth :</label> <input type="text"
								class="form-control form-control-sm datepickerdob" id='patDOB'
								name='patDOB' placeholder="dd-mm-yyyy"
								data-validation="mandatory" maxlength="11" readonly="readonly">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<!-- 						<div class='col-lg-3'> -->
					<!-- 							<div class="form-group"> -->
					<!-- 								<label class="col-form-label col-form-label-md" for="patGender">Gender -->
					<!-- 									:</label> <select class="form-control form-control-sm" id='patGender' -->
					<!-- 									name="patGender" data-validation="mandatory"> -->
					<!-- 									<option value="">Select Gender</option> -->
					<!-- 								</select> -->
					<!-- 								<div class="invalid-feedback"></div> -->
					<!-- 							</div> -->
					<!-- 						</div> -->

					<!-- <div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="patcardtype">Card
								Type :</label> <select class="form-control form-control-sm"
								id='patcardtype' name="patcardtype" data-validation="mandatory">
								<option value="">Select CardType</option>
								<option value="S">Serving</option>
								<option value="P">Pensioner</option>
								<option value="SA">Superannuate(in 6 months)</option>
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div> -->
					
					<!-- <div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="applicationType">
								Apply Card for  :</label> 
							<select class="form-control form-control-sm"
								id='applicationType' name="applicationType" data-validation="mandatory">
								<option value="">Select Application Type</option>
								<option value="DAOnlinePensioner">Retiring within 6 Months</option>
								<option value="Mobileotp">Serving/Retired</option>								
							</select>
							<div class="invalid-feedback"></div>
						</div>
					</div> -->
					</div>
					<!-- 	<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md"
									for="patMobileNoDemo">Mobile No.:</label> <input type="text"
									class="form-control form-control-sm" id='patMobileNoDemo'
									name='patMobileNoDemo' data-validation="mandatory,mobile"
									placeholder="Enter Mobile No.">
								<div class="invalid-feedback"></div>
							</div>
						</div> -->


			<div class="row">
					<div class='col-lg-12 text-center mt-4'>
					
					<!-- 	<button class='btn btn-his-outline ' id="BTNVerify" onclick="openpage();">
							<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Verify
						</button> -->

						
						<button class='btn btn-his' id="BTNVerify"	onclick="verifyPAN();">
							<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Verify
						</button>
					
				</div>
			</div>
			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type='hidden' name="hmode" id="hmode" /> <input type='hidden'
				name="tid" id='tid' /> <input type='hidden' name="initMode"
				id='initMode' /> <input type='hidden' name="primaryKeys"
				id='primaryKeys' /> <input type='hidden' name="fileUploadFlag"
				id='fileUploadFlag' /> <input type='hidden'
				name="cardtypevaluehidden" id='cardtypevaluehidden' value="" /> <input
				type='hidden' name="hiddenId12" id='hiddenId12' value="" /> <input
				type="hidden" name="isGlobal" id='isGlobalLocalVar'
				value="<%=isGlobal%>" /> <input type="hidden" name="panNumber"
				id="panNumber" />

		</fieldset>





	</form>
</body>
</html>
