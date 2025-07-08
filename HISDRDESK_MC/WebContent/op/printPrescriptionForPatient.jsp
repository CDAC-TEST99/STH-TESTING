<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
response.setHeader("Cache-Control", "public, max-age=86400"); // Cache for 1 day
response.setHeader("Expires", new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(new Date(System.currentTimeMillis() + 86400000)));
%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>Print Prescription</title>
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/all.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/fontawesome.min.css">
	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/bootstrap/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="/HIS/hisglobal/drDeskAssets/jquery/jquery-3.3.1.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
	<script src="/HIS/hisglobal/drDeskAssets/qrcodejs/qrcode.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/FormFlowX/js/base64.js"></script>
	  
	
	<style type="text/css">
			table { display: table; width:100%;background-color: transparent;border-collapse: collapse;border-spacing: 0;page-break-inside:auto; }
			tr{ page-break-inside:auto; }
			tbody td    { border:1px solid #e0e0e0; padding:5px;}
			thead th    { border:1px solid #e0e0e0;background: #e0e0e0;padding:5px; }
			thead td    { padding:5px; }
			.sectiontitle {font-weight: bold;  margin-top: 20px;  margin-bottom: 10px;}
			
			.line{
				margin-top:5px;margin-bottom:16px; border-bottom: 3px solid #265919;
			}
			
			.page-break {
			  page-break-before: always;
			  break-before: always; 
			}
			
	</style>
</head>
<body id="printPrescFrameBody" onload="">
		<div style="width: 100%;text-align: right;">
			<button class="btn btn-info prescBtn" id="prescPrintBtn" style="z-index:9999;" type="button" onclick="">Print Prescription</button>
		</div>
	  <div style="width:90%" id='divPrescription'>	
		  <div style="width:100%;padding:10px;color:#000;page-break-inside:auto;" id='divPrintable'> 
		  </div>
		  <div style="width:100%;padding:10px;color:#000;page-break-inside:auto;" id='referPrintData'> 
		  </div>
	  </div>	
		
	<script>
	var myJSON=null;
	$(document).ready(function(){
		var key=$('#key').val();
		if(key.trim()!=""){
			var json=JSON.parse(key);
			myJSON=json;
			var printData =json["printData"];
			 try {
				    var  html =decryptBase64(printData);
				    $('#divPrintable').html(html);
				    var referPrintData=json["referPrintData"];
				    if(referPrintData!=undefined && referPrintData!=""){
				      	html =decryptBase64(referPrintData);
				    	$('#referPrintData').html(html);
				    }
				    else{
					    $('#referPrintData').remove();	
					 }
				    
				   
			  } catch (error) {
			    console.error("Error decoding Base64 string:", error);
			  }
		}

		$('#prescPrintBtn').click(function(){
			$('.prescBtn').hide();
			if(myJSON!=null){
				document.title=myJSON.CR_No;
				window.print();
				$('.prescBtn').show();
			}
		});
		
	});

	
	</script>
	


<input type="hidden" name="key" id='key' value='${DoctorDeskFB.key}'/>
  
</body>
</html>
