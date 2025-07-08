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
<title>Skip Otp</title>
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

<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script type="text/javascript"
	src="/CGHSUserMgmt/cghsUsm/js/skipOtp.js"></script>


</head>


<%
FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");
String isGlobal = fb.getIsGlobal();
if (isGlobal == null)
	isGlobal = "0";
%>



<body>


	<section class="p-0 ">

		<form action="/CGHSUserMgmt/FormFlowXACTION" name="FormFlowXACTION"
			method="post">

			<fieldset class='hideData' id="LISTPAGE"
				style="width: 98%; margin-left: 0; padding: 0"></fieldset>
			<!-- <div class='card hideData' id="LISTPAGE"></div> -->


			


			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type='hidden' name="hmode" id="hmode" /> <input type="hidden"
				name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>" /> <input
				type='hidden' name="tid" id='tid' /> <input type='hidden'
				name="initMode" id='initMode' /> <input type='hidden'
				name="primaryKeys" id='primaryKeys' value="" /> <input
				type='hidden' name="primaryKeyFromDelingoffline"
				id='primaryKeyFromDelingoffline' value="" />


		</form>
	</section>

	<div class='modal' id='divUserView' tabindex='-1' role='dialog'
		aria-labelledby='divViewLabel' aria-hidden='true'>
		<div class='modal-dialog modal-xl' role='document'>
			<div class='modal-content'>
				<div class="modal-header">
					<h2 class="modal-title">USER VIEW</h2>
					<button type="button" class="btn-close" id='xButton'
						data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class='modal-body container border' id='divUserViewBody'>

					<div id="userModalDiv" class='accordion'>
						<div class="accordion-item mt-1" id=userModalDtlDiv>

							<h2 class="accordion-header" id="userModalDtlHeading">
								<button class="accordion-button bg-light" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#collapseUserModalDtl" aria-expanded="true"
									aria-controls="collapseUserModalDtl">User Details</button>
							</h2>
							<div id="collapseUserModalDtl"
								class="accordion-collapse collapse show"
								aria-labelledby="userModalDtlHeading"
								data-bs-parent="userModalDiv">
								<div class="accordion-body">

									<div id='userDtl'></div>
								</div>
							</div>
						</div>
					</div>

					<div id="roleModalDiv" class='accordion'>

						<div class="accordion-item mt-1" id="seatModalDtlDiv">
							<h2 class="accordion-header" id="seatModalDtlHeading">
								<button class="accordion-button bg-light" type="button"
									data-bs-toggle="collapse"
									data-bs-target="#collapseRoleModalDetails" aria-expanded="true"
									aria-controls="collapseRoleModalDetails">Role Details</button>
							</h2>
							<div id="collapseRoleModalDetails"
								class="accordion-collapse collapse show"
								aria-labelledby="seatDtlModalHeading"
								data-bs-parent="roleModalDiv">
								<div class="accordion-body">


									<div id='userSeatDtl'></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
<%-- JSP Script created by Naman Verma on 21st November 2024 --%>
