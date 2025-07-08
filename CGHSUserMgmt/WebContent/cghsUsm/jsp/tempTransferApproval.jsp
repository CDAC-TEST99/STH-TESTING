<%-- JSP Script created on 28th November 2024 --%>
<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<title>Temporary Transfer Acceptance</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<style>
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

#detailsTable th, #detailsTable td {
	text-align: center;
	vertical-align: middle;
}

.action-icon {
	font-size: 40px;
	cursor: pointer;
	margin: 0 5px;
}

.accept-icon {
	color: green;
}

.accept-icon:hover {
	color: darkgreen;
}

.reject-icon {
	color: red;
}

.reject-icon:hover {
	color: darkred;
}
</style>
<script type="text/javascript"
	src="/CGHSUserMgmt/cghsUsm/js/tempTransferApproval.js"></script>
</head>
<%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>

<body>

	<section class="p-0">
		<form action="/CGHSUserMgmt/FormFlowXACTION" name="FormFlowXACTION"
			method="post">
			<fieldset id="ENTRYFORM">
				<legend class="w-auto px-2 legendcss" id="formTitle">Temporary Transfer
					Acceptance</legend>

				<!-- Accordion -->
				<div class="accordion" id="roleAcceptanceAccordion">
					<div class="accordion-item">
						<h2 class="accordion-header" id="roleAcceptanceHeading">
							<button class="accordion-button bg-light" type="button"
								data-bs-toggle="collapse"
								data-bs-target="#roleAcceptanceCollapse" aria-expanded="true"
								aria-controls="roleAcceptanceCollapse">Role Acceptance
								Details</button>
						</h2>
						<div id="roleAcceptanceCollapse"
							class="accordion-collapse collapse show"
							aria-labelledby="roleAcceptanceHeading"
							data-bs-parent="#roleAcceptanceAccordion">
							<div class="accordion-body">
								<!-- Action Buttons -->
								<div class="legend2">
									<button class="btn btn-his-sm btn-sm" id="saveTransferBtn"
										onclick="saveTransfer()">
										<i class="fas fa-save"></i> &nbsp; Save
									</button>
									<button class="btn-his-outline-sm" id="clearTransferBtn">
										<i class="fa-solid fa-broom fa-fw"></i>&nbsp;Clear
									</button>
									<button class="btn-his-outline-sm" id="cancelTransferBtn">
										<i class="fas fa-times"></i> Cancel
									</button>
								</div>

								<!-- Select Transfer Acceptance Details -->
								<!-- <div class="container-fluid mt-4" id="acceptanceDetailsSection">
                                
                                <div class="row">
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="toCityDropdown" class="col-form-label col-form-label-md">To City:</label>
                                            <select id="toCityDropdown" name="toCity" class="form-control form-control-sm">
                                                <option value="">Select City</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="toHospitalDropdown" class="col-form-label col-form-label-md">To Hospital:</label>
                                            <select id="toHospitalDropdown" name="toHospital" class="form-control form-control-sm">
                                                <option value="">Select Hospital</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div> -->

								<!-- Transfer Details Table -->
								<!--  <br><br> -->

								<div id='transferDetailTableDiv'
									class="col-md-12  no-more-tables hideData">

									<!--  <h3>Transfer Details</h3>
                                <hr/> -->
									<table id="detailsTable" class="table table-bordered">
										<thead>
											<tr>
												<th>Select</th>
												<th>Reference Order No</th>
												<th>Order Date</th>
												<th>From City</th>
												<th>From Hospital</th>
												<th>Username</th>
												<th>Status</th>
											</tr>
										</thead>
										<tbody>
											<!-- Rows dynamically added here -->
										</tbody>
									</table>
								</div>
								<!-- <div class="row mt-4" id="transferDetailsSection" style="display: none;">
                                    <div class="col text-center">
                                        <button type="button" id="acceptButton" class="btn btn-success mx-2">Accept</button>
                                        <button type="button" id="rejectButton" class="btn btn-danger mx-2">Reject</button>
                                    </div>
                                </div> -->


								<!-- Acceptance Details Section -->
								<div class="container-fluid mt-4 hideData" id="acceptanceDetailsSections">
									<h3>Acceptance/Rejection Details</h3>
									<hr />

									<div class="row">
										<div class="col-sm-3">
											<div class="form-group">
												<label class="col-form-label col-form-label-md" for="status">Status</label>
												<label> <input type="radio" id="accepted"
													name="status" checked value="1"> Accepted
												</label> <label> <input type="radio" id="rejected"
													name="status" value="0"> Rejected
												</label>
												<div class="invalid-feedback"></div>
											</div>
										</div>
										
										<div class="col-lg-3 acceptClass">
                                        <div class="form-group">
                                            <label for="toHosp" class="col-form-label col-form-label-md">Wellness Center:</label>
                                            <select id="toHosp" name="toHosp" class="form-control form-control-sm select2" data-validation="mandatory">
                                                <option value="">Select Wellness Center</option>
                                            </select>
                                        </div>
                                    	</div>
                                    	
                                    	<div class="col-lg-3 acceptClass">
											<div class="form-group">
												<label for="joiningDate"
													class="col-form-label col-form-label-md">Joining
													Date:</label> <input type="date" id="joiningDate"
													name="joiningDate" class="form-control form-control-sm"
													data-validation="mandatory">
											</div>
										</div>

									</div>

									<div id='acceptedDtls' class="row">
									
										

										<div class="col-lg-3">
											<div class="form-group">
												<label for="acceptSeatDropdown" class="col-form-label">Seat:</label>
												<select id="acceptSeatDropdown" class="form-control form-control-sm select2">
													<option value="">Select Seat</option>
												</select>
											</div>
										</div>

										<div class="col-lg-3">
											<div class="form-group">
												<label for="joiningDate"
													class="col-form-label col-form-label-md">Efective To
													Date(For Non Default Seat):</label> <input type="date" id="effectiveTo"
													name="effectiveTo" class="form-control form-control-sm"
													>
											</div>
										</div>
										
										
										<div class="col-lg-3">
											<div class="form-group">
												<label for="defaultFlag" class="col-form-label">Default:</label>
												<select id="defaultFlag" class="form-control form-control-sm select2">
													<option selected value="1">Yes</option>
													<option value="0">No</option>
												</select>
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
											<!-- <button type="button" class="btn btn-circle btn-success"
												id="addRowBtn" title="Add">
												<i class="fas fa-plus"></i>
											</button> -->

											<button class="btn btn-his-sm  btn-sm" id="addDetailsIcon"
												style="margin-top: 40px;" title="Add Details">
												<i class="fas fa-plus"></i> &nbsp; Add
											</button>

										</div>

									</div>

									<div id='rejectDtls' class="row hideData">

										<div class="col-lg-6">
											<div class="form-group" id='remarksDiv'>
												<label for="joiningDate"
													class="col-form-label col-form-label-md">Remarks:</label>
												<textarea id="rejectionRemarks" name="rejectionRemarks" class="form-control"
													rows="3"></textarea>
											</div>
										</div>

									</div>


									<!-- <div class="row mt-3">
                                    <div class="col-lg-4">
                                        <div class="form-group">
                                            <label for="joiningDate" class="col-form-label">Joining Date:</label>
                                            <input type="date" id="joiningDate" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-lg-4">
                                        <i class="fa fa-plus-circle text-success ml-3" id="addDetailsIcon" style="font-size: 40px; cursor: pointer;" title="Add Details"></i>
                                    </div>
                                </div>
                                
                                
                                
 -->
 								<br>
 									<div id='acceptanceDetailsTableDiv'
									class="col-md-12  no-more-tables hideData">
 

										<table id="acceptanceDetailsTable" class="table table-bordered">
											<thead>
												<tr>
													<th>Seat</th>
													<th>Efective To Date(For Non Default Seat)</th>
													<th>Default</th>
													<th>Seat Run</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<!-- Rows dynamically added here -->
											</tbody>
										</table>
									</div>
								</div>

								 <!-- Rejection Details Section -->
								<!-- <div class="container-fluid mt-4" id="rejectionDetailsSection"
									style="display: none;">
									<h3>Rejection Details</h3>
									<hr />
									<div class="form-group">
										<label for="rejectionRemarks" class="col-form-label">Remarks:</label>
										<textarea id="rejectionRemarks" class="form-control" rows="3"></textarea>
									</div>
								</div>
								-->
							</div>
						</div>
					</div>
				</div>
				
				<input type="hidden" id="acceptanceHiddenField" name="acceptanceDataHiddenField" value="">
			<input type="hidden" name="orderId" id="orderId" />
			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type="hidden" name="hmode" id="hmode" /> <input type="hidden"
				name="isGlobal" id="isGlobalLocalVar" value="<%=isGlobal%>" /> <input
				type="hidden" name="tid" id="tid" /> <input type="hidden"
				name="initMode" id="initMode" /> <input type="hidden"
				name="primaryKeys" id="primaryKeys" />
				
			</fieldset>
			
		</form>
	</section>


</body>
</html>
<%-- JSP Script created on 28th November 2024 --%>
