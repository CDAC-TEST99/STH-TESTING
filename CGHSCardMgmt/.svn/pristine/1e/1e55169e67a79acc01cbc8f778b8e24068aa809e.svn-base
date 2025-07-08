<!DOCTYPE html>
<%@page import="thirdpartyservices.bharatkosh.client.resp.PaymentService"%>
<%@page import="java.util.Base64"%>
<%@page import="thirdpartyservices.bharatkosh.client.digitalsign.SignedXml"%>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<title>Bharatkosh Payment</title>
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
</style>


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
            alert("111111111");
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
%>

<%
	FormFlowXCommonFB fb = (FormFlowXCommonFB) request.getAttribute("FORMBEAN");
	String isGlobal = fb.getIsGlobal();
	if (isGlobal == null)
		isGlobal = "0";
%>



<body>

	<div id="pan-box" class="col-lg-3">
		<div class="form-group">
			<label class="col-form-label col-form-label-md" for="patPANNo">PAN
				Number:</label> <input type="text" class="form-control form-control-sm"
				id="patPANNo" name="patPANNo" placeholder="Enter PAN Number"
				onblur="validatepancheck()" data-validation="mandatory"
				maxlength="10">
			<div class="invalid-feedback"></div>
			<div id="error-message" class="error"></div>
		</div>
	</div>


		<form id="form-wrapper" class='p-2' method="post" name="form-wrapper">
			<h3 id='formTitle' class='text-center  p-2  bg-opacity-10'></h3>
			<fieldset id="ENTRYFORM">

				<div class="container-fluid" style="display: block;"
					id="paymentInfo">
					<h3 class='mt-4'>Bharatkosh Payment</h3>
					<% PaymentService paymentService = (PaymentService) request.getAttribute("BKPAYRESPONSE"); %>
					<div>
						<table class="table table-striped border text-center">
							<thead>
					          <tr>
					            <th colspan="3"> <h3>Bharatkosh Payment Status</h3></th>
					          </tr>
					        </thead>
					        <thead class="information">
							<tr class="tableHeading">
								<td>Order Code</td>
								<td>Status</td>
								<td>UTR No.</td>
							</tr>
							<tbody>
								<tr>
									<td><%=paymentService.getReply().getOrderStatus().getOrderCode()%></td>
									<td><%=paymentService.getReply().getOrderStatus().getStatus()%></td>
									<td><%=paymentService.getReply().getOrderStatus().getReference().getId()%></td>
								</tr>
							</tbody>
						</table>
					</div>
					<p id="errorMessage" class="error">
						<%=(request.getAttribute("BKRESPONSEERRMSG")==null?"":request.getAttribute("BKRESPONSEERRMSG"))%>
					</p>
				</div>	
			</fieldset>	
		</form>



</body>
</html>