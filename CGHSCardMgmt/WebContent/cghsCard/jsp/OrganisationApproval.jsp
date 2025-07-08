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
<title>Organisation Dept Approval</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/OrganisationApproval.js"></script>
	    <script src="https://cdnjs.cloudflare.com/ajax/libs/jsSHA/3.2.0/sha.js"></script>
	
<style>
.btn-right {
	float: right;
	color: lightgreen;
}

.zoom:hover {
	transform: scale(2);
}

</style>
</head>

<%
FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
  String isGlobal=fb.getIsGlobal(); 
		if(isGlobal==null)
 		isGlobal="0";
		
		String val = request.getParameter("primaryKeys");

		
          %>
<body>

	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">

		<fieldset id="ENTRYFORM">


			<br /> <br />




			<div class="row  rowborder bg-white p-2 text-dark bg-opacity-10 "
				style="padding-top: 5px;">
				<div class='col-lg-12 bordertext'>
					<h4 class='text-primary' style="text-align: center;">Approval Organisation Desk
					</h4>

				</div>
				
					<div class="row mt-5">
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="orgType">
								Organisation Type :</label> <input type="text" class="form-control form-control-sm"
								id='orgType' name='orgType' placeholder="Type Of Organisation"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="orgName">
								Organisation Name :</label> <input type="text"
								class="form-control form-control-sm" id='orgName'
								name='orgName' placeholder="Organisation Name"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="orgCity">
								Organisation City :</label> <input type="text"
								class="form-control form-control-sm" id='orgCity'
								name='orgCity' placeholder="Organisation City"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="ddoCd">
								DDO CODE :</label> <input type="text"
								class="form-control form-control-sm" id='ddoCd'
								name='ddoCd' placeholder="Organisation City"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="orgAddress">
								Organisation Address :</label> <input type="text"
								class="form-control form-control-sm" id='orgAddress'
								name='orgAddress' placeholder="Organisation Address"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="nodalOfficer">
								Nodal Officer :</label> <input type="text"
								class="form-control form-control-sm" id='nodalOfficer'
								name='nodalOfficer' placeholder="Nodal Officer"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="contactNo">
								Contact No :</label> <input type="text"
								class="form-control form-control-sm" id='contactNo'
								name='contactNo' placeholder="Contact No"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<div class='col-lg-3'>
						<div class="form-group">
							<label class="col-form-label col-form-label-md" for="emailId">
								Email Id / Login Id:</label> <input type="email"
								class="form-control form-control-sm" id='emailId'
								name='emailId' placeholder="email Id"
								data-validation="mandatory" maxlength="100">
							<div class="invalid-feedback"></div>
						</div>
					</div>
				
					<div class="col-lg-12 mt-4">
  <div class="d-flex gap-2">
    <button class="btn btn-sm btn-his-outline" id="BTNApprove" onclick="saveAction('approve');">
      <i class="fa-solid fa-broom fa-fw"></i>&nbsp;Approved
    </button>

    <button class="btn btn-sm btn-his-outline" id="BTNReject" onclick="saveAction('reject');">
      <i class="fa-solid fa-broom fa-fw"></i>&nbsp;Reject
    </button>
    
    <button class="btn btn-sm btn-his-outline" id="BTNReject" onclick="resetPage();">
      <i class="fa-solid fa-broom fa-fw"></i>&nbsp;Cancel
    </button>
  </div>
</div>

						
<!-- 						<button class='btn btn-his-outline ' id="BTNVerify"	onclick="verifyPAN();"> -->
<!-- 							<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Verify -->
<!-- 						</button> -->
					</div>
				</div>
				<input type="hidden" name="orgDtlId" id="orgDtlId" value='<%=val%>' />
								<input type="hidden" name="hashPassword" id="hashPassword" value="" />
				
						<input type="hidden" name="flag_type" id="flag_type" value="" />
			
				</fieldset>
		
			
    <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	     <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' value="<%=val%>" />   
	</form>
</body>
</html>
