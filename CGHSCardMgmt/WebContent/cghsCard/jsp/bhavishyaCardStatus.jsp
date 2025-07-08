<!DOCTYPE html>
<%@page import="hisglobal.utility.HisUtil"%>
<%@page import="thirdpartyservices.bharatkosh.service.BharatkoshClient"%>
<html lang="en">

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CGHS Pensioner Card Status</title>
<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">


<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/bhavishyaCardStatus.js"></script>

</head>


<%
	FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");
	String isGlobal = fb.getIsGlobal();
	if (isGlobal == null)
		isGlobal = "0";

	String trackingId = fb.getBhavishyaApplicationTrackingId();
	String status = fb.getBhavishyaApplicationStatus();
	String name = fb.getBhavishyaUserName();
	String statusCode = fb.getBhavishyaApplicationStatusCode();
	
%>

<body>

	<div style="margin-left: -20px;" id="bhavishyaCghsCardStatusPendingDiv">
		<table class="table table-striped border text-center">
			<thead>
				<tr>
					<th colspan="9">
						<h3>CGHS Card Status</h3>
					</th>
				</tr>
			</thead>
			<thead class="information">
				<tr class="tableHeading">
					<th style="width: 10%">Tracking Id</th>
					<th style="width: 15%">Name</th>
					<th style="width: 15%">Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=trackingId%></td>
					<td><%=name%></td>
					<td><%=status%></td>
				</tr>
			</tbody>
		</table>
	</div>

	<div style="margin-left: -20px;" id="bhavishyaCghsCardStatusApprovedDiv">
		<table class="table table-striped border text-center">
			<thead>
				<tr>
					<th colspan="9">
						<h3>CGHS Card Status</h3>
					</th>
				</tr>
			</thead>
			<thead class="information">
				<tr class="tableHeading">
					<th style="width: 10%">Tracking Id</th>
					<th style="width: 15%">Name</th>
					<th style="width: 15%">Status</th>
					<th style="width: 10%">Action</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=trackingId%></td>
					<td><%=name%></td>
					<td><%=status%></td>
					<td><a href="<%=HisUtil.getParameterFromHisPathXML("HIS_GLOBAL_URL") %>/AHIMSG5/hissso/benLogin" style="color:#0e4d5b" target="_blank">Click Here</a></td>

				</tr>
			</tbody>
		</table>
	</div>
	
	<input type="hidden" id="statusCode" value="<%=statusCode%>" />
	
</body>

</html>
