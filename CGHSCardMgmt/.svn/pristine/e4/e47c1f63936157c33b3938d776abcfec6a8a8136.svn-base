<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="hissso.config.HISSSOConfig"%>


<html lang="en">
<head>
<title>seach by Trackingid</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.3/xlsx.full.min.js"></script>

<script src="script.js"></script>
<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<style>
.highlight {
	background-color: yellow;
	/* Change this to your preferred highlight color */
}
</style>
<head>
<script>
	
</script>
<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/cardtransfer.js"></script>
<script type="text/javascript">
	
</script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<%
FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");

String isGlobal = fb.getIsGlobal();
if (isGlobal == null)
	isGlobal = "0";
String benId = session.getAttribute("SEATID").toString().split("^")[0];
%>


<body>

	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">
		<fieldset class='p-5' id="ENTRYFORM">

			<!-- <div class="row" id='divTrackingIdEntry' style="display: none;">
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
         <button class='btn btn-his ' id="BTNNEXT"  onclick="getfamilydetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Search</button>	
            <div class="invalid-feedback"></div>
        </div>
 	</div>
</div>
 -->

			<div id='benficDiv' class='hideData'>
				<div class='row'>
				
					<div id='patimgDiv' class='col-sm-1'
						style="background: #fff; padding: 2px; border: 1px solid #000; border-radius: 10px; margin-left: 10px;"></div>
					<div class='col-sm-10' style="margin-top: 5px;font-weight:400px;">
						<div class='row'>
							<div class='col-sm-4'>
								<h2
									style="padding: 0px; color: #fff; text-align: left !important;">
									<font id="patNamePrescriptionPanel"> </font>
								</h2>
							</div>
							<div class='col-sm-4'>
								<h2
									style="padding: 0px; color: #fff; text-align: left !important;">
									Ben ID: - <font id="patCrNoPrescriptionPanel"> </font>
								</h2>


							</div>
							<div class='col-sm-3 hideData'>
								<h3
									style="padding: 0px; color: #fff; text-align: left !important;">
									<font id="patPatientConditon"> </font>
								</h3>
							</div>
						</div>
						<div class='row'>
							<div class='col-sm-4 ' >
							<!-- class='patienttiledata' -->
								<font id="patGenAgeCatPrescriptionPanel" ></font>
							</div>
							<div class='col-sm-4 '>
								Card Type :-<font id="cardType"></font>
							</div>
						</div>
						<div class='row'>
							<div class='col-sm-4 '>
								  Relation :- <font id="relation"></font>
							</div>
							<div class='col-sm-4 '>
								Card Expiry Date :-<font id="cardValidityDate"></font>
							</div>
						</div>
					</div>
				</div>
			</div>


	<div class="accordion-item mt-1" id=otherBenfDtlDivHeading >

					<h2 class="accordion-header" id="otherBenDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseOtherBentDtlHeading"
							aria-expanded="true" aria-controls="collapseOtherBentDtlHeading" style="height:40px;">
							&nbsp;&nbsp;&nbsp;Dependent Detail</button>
					</h2>
</div>

			<div class="table-responsive">
				<table class="table table-bordered table-striped" id="AutoNumber1">
					<thead>
						<tr>
							<th style="width: 5%"><b>#</b></th>
							<th style="width: 10%">BenId</th>
							<th style="width: 10%">Date of Birth</th>
							<th style="width: 10%">Name</th>
							<th style="width: 5%">Gender</th>
							<th style="width: 10%">Relationship</th>
							<th style="width: 10%">Mobile</th>
							  <th style="width:10%">Photo</th> 

							



						</tr>
					</thead>
					<tbody>
	<!-- <div id='patimgDivNew' class='col-sm-1'
						style="background: #fff; padding: 2px; border: 1px solid #000; border-radius: 10px; margin-left: 10px;"></div> -->
					</tbody>
				</table>
			</div>


			<hr>

			<div id="otherDtlDiv" class='accordion hideData'>



				<div class="accordion-item mt-1" id=otherBenfDtlDiv>

					<h2 class="accordion-header" id="otherBenDtlHeading">
						<button class="accordion-button bg-light" type="button"
							data-bs-toggle="collapse" data-bs-target="#collapseOtherBentDtl"
							aria-expanded="true" aria-controls="collapseOtherBentDtl">
							Transfer Request</button>
					</h2>

					<div id="collapseOtherBentDtl"
						class="accordion-collapse collapse show"
						aria-labelledby="otherBenDtlHeading" data-bs-parent="otherDtlDiv">
						<div class="accordion-body">
							<div class="row ">

								<div class="col-sm-6 d-flex align-items-center">
									<label class="col-form-label col-form-label-md me-2">Transfer
										Type:</label>

									<div class="form-check me-3">
										<input class="form-check-input" type="radio" id="withinCity"
											name="transferType" checked value="1"
											onclick="toggleUploadOption();"> <label
											class="form-check-label" for="withinCity">Within City</label>
									</div>

									<div class="form-check me-3">
										<input class="form-check-input" type="radio" id="interCity"
											name="transferType" value="0" onclick="toggleUploadOption();">
										<label class="form-check-label" for="interCity">Outside
											City</label>
									</div>

								</div>
								<div class="col-sm-6 d-flex align-items-center">
									<label id="uploadLabel"
										class="col-form-label col-form-label-md me-2">Upload
										Address Proof:</label>
									<!-- File Upload Section -->
									<div class="d-flex align-items-center" id="uploadSection"
										style="display: none;">
										<input type="file" id="fileUpload" name="fileUpload"
											class="form-control form-control-sm" style="width: 250px;">
									</div>
								</div>
								<br/>
									<br/>
								
									<div class="col-sm-1 d-flex align-items-center">
								<label id="lblRemark" class="col-form-label col-form-label-md me-2">Remarks:</label> 
								</div>
									<div class="col-sm-6 d-flex align-items-center">
									
									<form:textarea name="strRemarks" path="strRemarks"
										id="strRemarks"
										style="height: 200px !important; width:350px !important;"
										class="form-control" placeholder="Enter Remarks">
									
										</form:textarea>
								</div>
								<br/>
							<div class="col-sm-6 d-flex align-items-center"></div>
								<div class="col-sm-6 d-flex align-items-center">
								<button class="btn btn-his-sm  btn-sm" id="saveBtn"
											style="margin-top: 32px;" title="Save" onclick="save()">
											&nbsp; Save</button>
											</div>

								<script>
									function toggleUploadOption() {
										let transferType = document
												.querySelector('input[name="transferType"]:checked').value;
										
										let cardTypeId = document
												.getElementById("cardTypeId").value;
										//alert('cardTypeId' + cardTypeId);
										let uploadLabel = document
												.getElementById("uploadLabel");
										let uploadSection = document
												.getElementById("uploadSection");

										// Always show the upload section
										uploadSection.style.display = "flex";

										// Update the upload label based on the transfer type and card type
										if (transferType === "1") { // Within City
											uploadLabel.innerText = "Upload Address Proof:";
										} else { // Outside City
											if (cardTypeId === "18"
													|| cardTypeId === "24") { // Serving
												uploadLabel.innerText = "Upload Transfer Order:";
											} else {
												uploadLabel.innerText = "Upload Address Proof:";
											}
										}
									}
								</script>

					

							</div>
						</div>
					</div>
				</div>
			</div>


			<hr>

			<div>
				<!-- <button class='btn btn-his' id="BTNAPPROVE" onclick="DownloadExcel()"><i class='fas fa-save fa-fw' ></i>&nbsp;Download Data in Excel</button> -->
			</div>


			<input type="hidden" name="BenId" id="BenId" /> <input type="hidden"
				name="cardTypeId" id="cardTypeId" />
		</fieldset>

		<input type="hidden" name="masterKey" id="masterKey" /> 
		<input
			type='hidden' name="hmode" id="hmode" /> <input type="hidden"
			name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>" /> <input
			type='hidden' name="tid" id='tid' /> <input type='hidden'
			name="initMode" id='initMode' /> 
			<input type='hidden'
			name="primaryKeys" id='primaryKeys' />
			
				<input type='hidden' name="benId" id='benId'  value=<%=session.getAttribute("SEATID").toString().split("^")[0] %>/>
			
		<%
		String primaryKeyFromListPage = request.getParameter("primaryKey");
		if (primaryKeyFromListPage == null) {
			primaryKeyFromListPage = "";
		}
		%>
		<input type='hidden' name="primaryKeyFromListPage"
			id='primaryKeyFromListPage' value="<%=primaryKeyFromListPage %>" />
	</form>