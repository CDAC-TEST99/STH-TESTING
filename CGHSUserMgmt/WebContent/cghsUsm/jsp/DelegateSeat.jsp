<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Delegate Role</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>

<style>
/* Button Styling */
.btn-action {
	margin-right: 5px;
}

.table thead th, .table tbody td {
	text-align: center;
	vertical-align: middle;
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
	src="/CGHSUserMgmt/cghsUsm/js/delegateSeat.js"></script>
</head>
<%
FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");
String isGlobal = fb.getIsGlobal();
if (isGlobal == null)
	isGlobal = "0";
%>


<section class="p-0">

	<form action="/CGHSUserMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">

		<fieldset class='hideData' id="LISTPAGE" style="width: 98%;  margin-left: 0;padding: 0">
			</fieldset>


		<fieldset class='hideData' id="ENTRYFORM">

			<legend class="w-auto px-2 legendcss" id='formTitle'>Deligate
				Role</legend>

			<div class="legend2 ">


				<button class="btn btn-his-sm  btn-sm" id="saveTransferBtn"
					onclick="saveDelegate()">
					<i class="fas fa-save"></i> &nbsp; Save
				</button>
				<button class='btn btn-his-sm  btn-sm ' id="clearTransferBtn">
					<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear
				</button>
				<button class="btn btn-his-sm  btn-sm" id="cancelTransferBtn">
					<i class="fas fa-times"></i> Cancel
				</button>

			</div>
			
			
			<div id="delegateFromDiv" class='accordion'>



				<div class="accordion-item mt-1" id=delegateFromDtlDiv>

					<h2 class="accordion-header" id="delegateFromDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseDeligateFromDtl"
							aria-expanded="true" aria-controls="collapseDeligateFromDtl">
							Deligate From Details</button>
					</h2>
					<div id="collapseDeligateFromDtl"
						class="accordion-collapse collapse show"
						aria-labelledby="delegateFromDtlHeading"
						data-bs-parent="delegateFromDiv">
						<div class="accordion-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="cityDropdown">Delegate From City:</label> <select
											id="fromcityDropdown" name="fromcityDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select City</option>
										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="hospitalDropdown">Delegate From Hospital:</label> <select
											id="fromhospitalDropdown" name="fromhospitalDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select Hospital</option>
										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="userDropdown">Delegate From User:</label> <select
											id="fromuserDropdown" name="fromuserDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select User</option>
										</select>
									</div>
								</div>
							</div>

						</div>
					</div>


				</div>
			</div>
			
			
			
			<div id="seatAvlDiv" class='accordion hideData'>



				<div class="accordion-item mt-1" id=seatAvlDtlDiv>

					<h2 class="accordion-header" id="seatAvlDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseSeatAvlDtl"
							aria-expanded="true" aria-controls="collapseSeatAvlDtl">
							Seats Availaible To Deligate</button>
					</h2>
					<div id="collapseSeatAvlDtl"
						class="accordion-collapse collapse show"
						aria-labelledby="seatAvlDtlHeading" data-bs-parent="seatAvlDiv">
						<div class="accordion-body">
							<div class="col-md-12  no-more-tables">
								<table class="table table-striped border" id='myDetailsTable'>
									<thead>
										<tr>
											<th></th>
											<th>Seats</th>
										</tr>
									</thead>
									<tbody></tbody>
								</table>
							</div>
						</div>


					</div>
				</div>
			</div>
			
			 <div id="roleDiv" class='accordion hideData'>

				<div class="accordion-item mt-1" id="seatDtlDiv">
					<h2 class="accordion-header" id="seatDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseRoleDetails"
							aria-expanded="true" aria-controls="collapseRoleDetails">
							Menu Details</button>
					</h2>
					<div id="collapseRoleDetails"
						class="accordion-collapse collapse show"
						aria-labelledby="seatDtlHeading" data-bs-parent="roleDiv">
						<div class="accordion-body">

							<div class="row">
								<div class='col-lg-12'>
									<div class="form-group">

										<select id="menuIds" name="menuIds" multiple size="10" data-validation="mandatory">

										</select>
										<div class="invalid-feedback"></div>
									</div>
								</div>


							</div>

						</div>
					</div>
				</div>
			</div>
			
			
			



			<div id="delegateToDiv" class='accordion hideData'>



				<div class="accordion-item mt-1" id=delegateDtlDiv>

					<h2 class="accordion-header" id="delegateDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseDeligateDtl"
							aria-expanded="true" aria-controls="collapseDeligateDtl">
							Deligate To Details</button>
					</h2>
					<div id="collapseDeligateDtl"
						class="accordion-collapse collapse show"
						aria-labelledby="delegateDtlHeading"
						data-bs-parent="delegateToDiv">
						<div class="accordion-body">
							<div class="row">
								<div class="col-md-4">
									<div class="form-group">
										<label for="cityDropdown">Delegate To City:</label> <select
											id="cityDropdown" name="cityDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select City</option>
										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="hospitalDropdown">Delegate To Hospital:</label> <select
											id="hospitalDropdown" name="hospitalDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select Hospital</option>
										</select>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<label for="userDropdown">Delegate To User:</label> <select
											id="userDropdown" name="userDropdown" class="form-control form-control-sm select2" data-validation="mandatory">
											<option value="">Select User</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
							
									<div class='col-lg-4 '>
										<div class="form-group">

											<label class="col-form-label col-form-label-sm"
												for="efectiveTo"
												data-langtag="Efective To Date">Efective
												To Date</label> <input
												class="form-control form-control-sm"
												type="text" id="efectiveTo" name="efectiveTo" maxlength="50"
												data-validation="mandatory" readonly>
											<!-- onchange='populateContDate()' cntrDate -->
											<div class="invalid-feedback"></div>
										</div>
									</div>
							
							
							</div>

						</div>
					</div>


				</div>
			</div>


			


			<!-- Hidden field to store selected seat IDs -->
			<input type="hidden" id="hiddenSeatIds" name="hiddenSeatIds" value="">



			<!-- <input type="hidden" id="hiddenCityId" name="hiddenCityId" value="">
			<input type="hidden" id="hiddenHospitalId" name="hiddenHospitalId"
				value=""> --> <input type="hidden" id="hiddenUserId"
				name="hiddenUserId" value="">
			<!-- Transaction Details Modal -->
			<div class="modal fade" id="transactionModal" tabindex="-1"
				aria-labelledby="transactionModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="transactionModalLabel">Transaction
								Details</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<!-- Transaction details will be populated here -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>

		</fieldset>
		<input type='hidden' name="hmode" id="hmode" /> <input type="hidden"
			name="masterKey" id="masterKey" /> <input type="hidden"
			name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>" /> <input
			type='hidden' name="tid" id='tid' /> <input type='hidden'
			name="initMode" id='initMode' /> <input type='hidden'
			name="primaryKeys" id='primaryKeys' />
	</form>
</section>
</body>
</html>
