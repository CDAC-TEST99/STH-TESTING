<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hislogin.config.HISLoginConfig"%>

<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Cache-Control" Content="no-store" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store");
%>
<link href="/HIS/hisglobal/css/login/dwh.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/control.css" rel="stylesheet" type="text/css">

<link href="/HIS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/layout.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jqueryExtValidationToolTip.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/easyui.css" rel="stylesheet" type="text/css">

<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/his-jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery.easyui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jqueryExtValidation.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/commonFunctions.js"></script>
<script type="text/javascript" src="/AHIMSG5/hislogin/transactions/js/security.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script>

 /* function onUploadedFileName(obj,fileId)
{
	
		if(fileId!='' && fileId.length > 0 && fileId !=null && fileId!='NA')
		{
			document.forms[0].hmode.value="GETUPLOADEDFILE";			
			document.forms[0].strUploadFileId.value=fileId;
			document.forms[0].action = "/HBIMS/mms/transactions/MmsCNT.cnt";
			//document.forms[0].target = "_blank";
			document.forms[0].submit();
		}
		else
		{
			alert("No File to Down-Load!!");			
		}
	
}  */
 
function getCircularDetails(){	

	
	 var mode = "GetCircularDtl"; 
	 var myurl= "/HBIMS/mms/transactions/MmsCNT.cnt?hmode="+mode+"&pathvalue=1";
	 myurl = createFHashAjaxQuery(myurl);
		$.ajax({
			  url: myurl,
			  success:function(data){
			    $("#inline2").html(data);
				  }
			});
	}
function getAjaxResponse(res, mode) {

		if (mode == "1") {
			alert('here');
			//document.getElementById("captchaDiv").innerHTML ='<img id="imageid" src="data:image/png;base64,' + res + '"  class="captcha"><img src="/HIS/hisglobal/images/reload.png" alt="Refresh"  onClick="captchaReset();" style="margin:-16px 0 0 128px;cursor: pointer;"/>';								
		}
	} 
</script>

<style type="text/css">
.linenew::before {
    background: rgba(0, 0, 0, 0) linear-gradient(to bottom, #1271aa, #0e517d) no-repeat scroll center center / 98% 0.15em;
    content: "";
    display: table-cell;
    width: 2%;
}

 .NEWTABLEWIDTH {
    border-collapse: collapse;
    width: 100%;
}

 .formbg {
    background: rgba(0, 0, 0, 0) url("../images/form_bg.png") repeat-x scroll center center / auto 100%;
}
    
  
    </style>

</head>
<body onload="getCircularDetails();">
<center>


<div class="wrapper rounded">

<s:form action="LgnFtr">
  
	<div id="inline2">
			 
    </div>
		
	
	<div class="div-table-button" style='margin:0;'>
		<div class="div-table-row footerBar" >
			<div class="div-table-col"> </div>
		</div>
		
		
	</div>
	<s:hidden name="varUserName"></s:hidden>

<div id="divElementErrorsId" class="alertMessage"><s:actionerror/></div>
<input type="hidden" name="strUploadFileId" />
<input type="hidden" name="hmode" />

</s:form>



</div>
</center>
</body>
</html>