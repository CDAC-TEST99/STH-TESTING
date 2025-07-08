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
	src="/CGHSUserMgmt/cghsUsm/js/ModifyUserMaster.js?v=1.0"></script>
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
		<form action="/CGHSUserMgmt/FormFlowXACTION" name="FormFlowXACTION"
			method="post">
			<fieldset id="ENTRYFORM">
				<legend class="w-auto px-2 legendcss" id='formTitle'>Modify
					User Master</legend>

				<div class="legend2 ">


					<button class="btn-his-sm" id="saveBtnId" onclick="updateUser()">
						<i class="fas fa-save"></i> &nbsp; Save
					</button>
					<button class='btn-his-outline-sm' id="clearForm">
						<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear
					</button>
					<button class="btn-his-outline-sm" id="cancelForm">
						<i class="fas fa-times"></i> Cancel
					</button>

				</div>
				<!-- First Accordion: Modify User Details -->
				<div class="accordion" id="modifyUserAccordion">
					<div class="accordion-item">
						<h2 class="accordion-header" id="modifyUserHeading">
							<button class="accordion-button bg-light" type="button"
								data-bs-toggle="collapse" data-bs-target="#modifyUserCollapse"
								aria-expanded="true" aria-controls="modifyUserCollapse">
								Modify User Details</button>
						</h2>
						<div id="modifyUserCollapse"
							class="accordion-collapse collapse show"
							aria-labelledby="modifyUserHeading"
							data-bs-parent="#modifyUserAccordion">
							<div class="accordion-body">
								<div class="container-fluid" id="perinfo">

									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md">User
													Type:</label>&nbsp;<label
													class="col-form-label col-form-label-md lbldata"
													id="userTypeLable" for="userTypeLable"></label>
												<!-- <input type="text"
													class="form-control form-control-sm" id="userType"
													name="userType" placeholder="User Type" readonly
													data-validation=""> -->
											</div>
										</div>

										<div id="isContractualDiv" class="col-sm-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													>Is Contractual :</label> <label> <input
													type="radio" id="notEmployee" name="isEmployee"
													onclick="checkNotEmployee(this);" value="0"> Yes
												</label> <label> <input type="radio" id="isEmployee"
													name="isEmployee" onclick="checkIsEmployee(this);"
													value="1"> No
												</label>
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div id="govEmailChkDiv" class="col-sm-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													>GOV Email Available :</label> <input
													class="form-check-input" type="checkbox" value="1"
													id="govEmailCheck" name="govEmailCheck"
													style="margin-top: 10px;">
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="col-sm-3" id='hprDrDiv'>
											<div class="form-group">
												<label class="col-form-label col-form-label-md" for="hprId">HPR
													ID :</label> <input type="text"
													class="form-control form-control-sm" id="hprId"
													name="hprId" placeholder="Enter HPR" maxlength="100"
													data-validation="mandatory,alphanumeric">
											</div>
										</div>
										<div class="col-lg-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													for="userName">Name :</label> <input type="text"
													class="form-control form-control-sm" id="userName"
													name="userName" placeholder="Enter Name" maxlength="100"
													data-validation="mandatory">
											</div>
										</div>
										<div class='col-lg-3 '>
											<div class="form-group">

												<label class="col-form-label col-form-label-sm" for="dob"
													data-langtag="DOB">DOB</label> <input
													class="form-control form-control-sm jqueryDatePicker"
													type="text" id="dob" name="dob" maxlength="50"
													data-validation="mandatory" readonly>
												<!-- onchange='populateContDate()' cntrDate -->
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													for="usertype">Designation:</label> <select
													class="form-control form-control-sm select2" id="desigId"
													name="desigId" data-validation="mandatory">
													<option value="">Select User Type</option>
												</select>
												<div class="invalid-feedback"></div>
											</div>
										</div>

										<div class="col-lg-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													for="patEmail">E-mail/Login:</label> <input type="email"
													class="form-control form-control-sm" id="patEmail"
													name="patEmail" data-validation="mandatory,govemail"
													placeholder="Enter E-mail Address">
												<div class="invalid-feedback"></div>
											</div>
										</div>
										<div class="col-lg-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md"
													for="patMobileNo">Mobile No.:</label> <input type="text"
													class="form-control form-control-sm" id="patMobileNo"
													name="patMobileNo" maxlength="10"
													placeholder="Enter Mobile No.">
											</div>
										</div>

										<div class="col-lg-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md" for="panNo">PAN
													No.:</label> <input type="text"
													class="form-control form-control-sm" id="panNo"
													name="panNo" data-validation="mandatory,pan" maxlength="10"
													placeholder="Enter Pan No." value=''>
												<div class="invalid-feedback"></div>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- Second Accordion: Role Details -->
				<div class="accordion mt-4" id="roleDetailsAccordion">
					<div class="accordion-item">
						<h2 class="accordion-header" id="roleDetailsHeading">
							<button class="accordion-button bg-light" type="button"
								data-bs-toggle="collapse" data-bs-target="#roleDetailsCollapse"
								aria-expanded="true" aria-controls="roleDetailsCollapse">
								Role Details</button>
						</h2>
						<div id="roleDetailsCollapse"
							class="accordion-collapse collapse show"
							aria-labelledby="roleDetailsHeading"
							data-bs-parent="#roleDetailsAccordion">
							<div class="accordion-body">
								<div class="row">
									<div class="col-lg-2">
										<div class="form-group">
											<label class="col-form-label col-form-label-md" for="cityId">City
												:</label> <select class="form-control form-control-sm select2"
												id="cityId" name="city">
												<option value="">Select City</option>
											</select>
										</div>
									</div>
									<div class="col-lg-2">
										<div class="form-group">
											<label class="col-form-label col-form-label-md"
												for="hospitalId">Hospital :</label> <select
												class="form-control form-control-sm select2" id="hospitalId"
												name="hospital">
												<option value="">Select Hospital</option>
											</select>
										</div>
									</div>
									<div class="col-lg-2">
										<div class="form-group">
											<label class="col-form-label col-form-label-md"
												for="userSeatId">Role :</label> <select
												class="form-control form-control-sm select2" id="userSeatId"
												name="userSeatId">
												<option value="">Select Role</option>
											</select>
										</div>
									</div>
									<div class='col-lg-2 '>
										<div class="form-group">

											<label class="col-form-label col-form-label-sm"
												for="efectiveFrom" data-langtag="Efective From Date">Effective
												From</label> <input class="form-control form-control-sm" type="text"
												id="efectiveFrom" name="efectiveFrom" maxlength="50"
												readonly>
											<!-- onchange='populateContDate()' cntrDate -->
											<div class="invalid-feedback"></div>
										</div>
									</div>
									<div class='col-lg-2 '>
										<div class="form-group">

											<label class="col-form-label col-form-label-sm"
												for="efectiveTo" data-langtag="Efective To Date">Effective
												To</label> <input class="form-control form-control-sm" type="text"
												id="efectiveTo" name="efectiveTo" maxlength="50"
												data-validation="" readonly>
											<!-- onchange='populateContDate()' cntrDate -->
											<div class="invalid-feedback"></div>
										</div>
									</div>
									<div class="col-sm-2">
										<!-- <div class="form-group"> -->
										<div class='row'>
											<label> <input type="radio" id="allday"
												name="daysRun" checked value="1"
												onclick="allDaysFunc(this);"> All Days
											</label><input type="hidden" name="hiddenDays" id="hiddenDays" />
										</div>
										<div class='row'>
											<label> <input type="radio" id="selectDays"
												name="daysRun" value="0" onclick="selectDaysFunc(this);">
												Specific Days
											</label>
										</div>
										<input type="hidden" name="hiddenDays" id="hiddenDays" />
									</div>

									<div class="col-lg-6 hideData" id="seatRunDiv">

										<div class="form-group">
											<label class="col-form-label col-form-label-md" for="">Seat
												Run :</label>
											<table class="table table-bordered">
												<thead>
													<tr style="background-color: lightgrey">
														<th>MON</th>
														<th>TUES</th>
														<th>WED</th>
														<th>THUR</th>
														<th>FRI</th>
														<th>SAT</th>
														<th>SUN</th>
													</tr>
												</thead>
												<tr style="justify-content: center">
													<th><input type="checkbox" id="edit_monday"></th>
													<th><input type="checkbox" id="edit_tuesday"></th>
													<th><input type="checkbox" id="edit_wednesday"></th>
													<th><input type="checkbox" id="edit_thursday"></th>
													<th><input type="checkbox" id="edit_friday"></th>
													<th><input type="checkbox" id="edit_saturday"></th>
													<th><input type="checkbox" id="edit_sundday"></th>
												</tr>
											</table>
										</div>
									</div>
									<div class="col-lg-1">
										<button class="btn btn-his-sm  btn-sm" id="addRowBtn"
											style="margin-top: 40px;" title="Add">
											<i class="fas fa-plus"></i> &nbsp; Add
										</button>
									</div>
								</div>
								<div class="table-responsive mt-3">
									<table id="detailsTable" class="table table-bordered">
										<thead>
											<tr>
												<th>City</th>
												<th>Hospital</th>
												<th>Seat</th>
												<th>Default</th>
												<th>Seat Run</th>
												<th>Effective From</th>
												<th>Effective To</th>
												<th>Actions</th>
											</tr>
										</thead>
										<tbody>
											<!-- Dynamic rows added here -->
										</tbody>
									</table>
								</div>
								<input type="hidden" id="hiddenFieldId"
									name="tableDataHiddenField" value=""> <input
									type="hidden" id="refPass" name="refPass" value="" />
									<input
									type="hidden" id="password" name="password" value="" />
							</div>
						</div>
					</div>
				</div>
				<input type="hidden" name="hiddenUserId" id="hiddenUserId" />
			</fieldset>

			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type='hidden' name="hmode" id="hmode" /> <input type="hidden"
				name="masterKey" id="masterKey" /> <input type="hidden"
				name="isGlobal" id="isGlobalLocalVar" value="<%=isGlobal%>" /> <input
				type="hidden" name="tid" id="tid" /> <input type="hidden"
				name="initMode" id="initMode" /> <input type="hidden"
				name="primaryKeys" id="primaryKeys" value="<%=val%>" />
		</form>
	</section>


</body>
</html>


