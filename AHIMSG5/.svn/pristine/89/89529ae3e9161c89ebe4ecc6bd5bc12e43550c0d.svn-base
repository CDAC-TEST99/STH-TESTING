<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="hisglobal.security.SecureHashAlgorithm"%>
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

<style>
        .form-heading {
            font-family: Verdana, Arial, Helvetica, sans-serif;
            font-weight: bold;
            color: white;
            background-color: #36304a !important;
            border-radius: 10px;
            padding: 10px;
        }
        .label-text {
            color: #36304a;
        }
        .text-danger {
            color: red;
        }
        .custom-background {
            background-color: #36304a !important;
        }
        .custom-background span {
            color: white;
        }
         .footerBar {
            background-color: #36304a !important;
        }
    </style>
<link href="/HIS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/layout.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jqueryExtValidationToolTip.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/easyui.css" rel="stylesheet" type="text/css">

<!--   Added Css links
 -->  <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css">
      <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">

 <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">  
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.css">
   <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/select2/css/select2.min.css">   
  <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/cdac_preset1.css">
 
  <!--  DataTables -->
   
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/dataTableNew/datatables.min.css">
  
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/css/buttons.dataTables.min.css"> 
 
  <link href="/HIS/hisglobal/cdac_awesome/css/animate.min.css" rel="stylesheet" >
  <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
  <link href="/HIS/hisglobal/images/logo.ico" rel="icon"  type="image/x-icon">

<!-- Added for Security Start-->
 <script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/avai/validation.js"></script> 
<!-- Added for Security End-->

<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/his-jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery.easyui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jqueryExtValidation.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/commonFunctions.js"></script>
<script type="text/javascript" src="/HIS/hisglobal/js/multilingual.js"></script> 
<script type="text/javascript" src="/AHIMSG5/hislogin/transactions/js/md5.js"></script>
<%-- <script type="text/javascript" src="/AHIMSG5/hislogin/transactions/js/security.js"></script> --%>
<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>



</head>
<body onload="document.getElementsByName('varOldPassword')[0].focus();capchaReload();">
<center>


<div class="wrapper rounded">

<s:form action="saveChangePasswordLgnFtr" method="POST">
  
	<div class="div-table" >
		<div class="row mb-4">
            <div class="col-9">
                <h5 class="form-heading p-2">Change Password Details</h5>
            </div>
        </div>

		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='old-password'>Old Password</span>
			</div>
			<div class="div-table-col width60 control" >
				<input type="password" name="varOldPassword" tabindex="1" value="" maxlength="25" id="varOldPassword" autocomplete="off">
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='new-password'>New Password</span>
			</div>
			<div class="div-table-col width60 control" >
				<input type="password" name="varPassword" tabindex="1" value="" maxlength="25" id="varPassword" autocomplete="off">
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='confirm-new-password'>Confirm New Password</span>
			</div>
			<div class="div-table-col width60 control" >
				<input type="password" name="varConfirmPassword" tabindex="1" value="" maxlength="25" id="varConfirmPassword" autocomplete="off">
				<input type="hidden" name="varRefPass" tabindex="1" value="" maxlength="25" id="varRefPass">
			</div>
		</div>
		
		<!-- Added By Deepti for STH 05.06.2020 -->
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='enter-capcha'>Enter Capcha</span>
			</div>
			<div class="div-table-col width30 control" >
				<input type="text" tabindex="1" class="captcha-Text"  maxlength="8" name="captchaResponse_passwordChange" placeholder="Enter Captcha" autocomplete="off"/>
			
			</div>
			 <div class="div-table-col width30" style="margin-left: -16%;padding-left: 5px;margin-top: -6px;">
				
 				 <img id="captchaImg" src="/AHIMSG5/hislogin/captchaLgnFtr?id="<%=Math.random() %> alt="Captcha Image" style="width:30%;" height="40">
				<img src="/HIS/hisglobal/images/buttons/refresh.png" alt="Reload" onclick="capchaReload();" style="cursor:pointer;margin-bottom: 10px;"> 
			
			
			</div>
		</div>
		 
			
		<div class="div-table-row ">
			<div class="div-table-col width100 label" >
				<font color='red'>
		     		<span key='the-password-is-case-sensitive'>The Password is case sensitive.</span>
		     	</font>
		     </div>
		</div>
	</div>
	
	<div class="div-table-button">
		<div class="div-table-row footerBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row emptyBar">
			<div class="div-table-col"> </div>
		</div>
		<%-- <div class="div-table-row" align="center">
			<a href="#" class="button" tabindex="1" id="idSave" ><span class="save" key="save">Save</span></a>
			<a href="#" class="button" tabindex="1" id="idClear"><span class="clear" key="clear">Clear</span></a>
			<a href="#" class="button" tabindex="1" id="idCancel"><span class="cancel" key="cancel">Cancel</span></a>
		</div> --%>
		<div class="legend2">
    <span class="btn btn-his-sm btn-sm" id="idSave">
        <i class="fas fa-save"></i> &nbsp; Save
    </span>
        <span   class="btn-his-outline-sm" id="idClear">
        <i class="fas fa-save"></i> &nbsp; Clear
     </span>
    <%-- <span  class="btn-his-outline-sm" id="idCancel">
        <i class="fas fa-times"></i> Cancel
      </span> --%>
</div>
	</div>
	<s:hidden name="varUserName"></s:hidden>
<input type="hidden" id="changepwd" value="1">	
<div id="divElementErrorsId" class="alertMessage"><s:actionerror/></div>
 <input type="hidden" name="x-auth-token" id="x-auth-token" value="<%=SecureHashAlgorithm.generateRandom(request)%>" />

</s:form>

<script type="text/javascript">
var passwordStrength = "<%=HISLoginConfig.PASSWORD_STRENGTH_LOW%>";

function setPasswordStrength()
{
	$('[name="varPassword"]').validatebox({
		required: true,
		validType : [ 'minLength[6]', 'maxLength[25]', 'notEqualTo["#varOldPassword","Old Password","New Password"]', 'passwordStrength['+passwordStrength+']']
	});
	$('[name="varConfirmPassword"]').validatebox({
		required: true,
		validType : [  'minLength[6]', 'maxLength[25]', 'equalTo["#varPassword","New Password","Confirm Password"]' ]
	});
}

function callMenu(url)
{
	//alert('menu called with url: '+ url);
	var targetURL = url;// + "?varSSOTicketGrantingTicket=" + document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
	
	
	var elemFrame = parent.document.getElementById("frmMain");
	if(elemFrame!=null){
		elemFrame.src=targetURL;
		elemFrame.refresh();
	}
	else{
		if(typeof $('#tabframe')!='undefined'){
			var tab = window.parent.$('#tabframe').tabs('getSelected');
			var index = window.parent.$('#tabframe').tabs('getTabIndex',tab);
			window.parent.$('#tabframe').tabs('select',index-1);	
			window.parent.$('#tabframe').tabs('close',index);	

		}
	}
}

var changePasswordDetail = {
		clearForm : function()
		{
			document.getElementsByName("varOldPassword")[0].value = "";
			document.getElementsByName("varPassword")[0].value = "";
			document.getElementsByName("varConfirmPassword")[0].value = "";
			document.getElementsByName("captchaResponse_passwordChange")[0].value = "";
		},
		submitOnSave : function(e)
		{
		//	console.log(!changePasswordDetail.secureOldPassword()+ " " +!changePasswordDetail.securePassword() )
			if(!changePasswordDetail.secureOldPassword() || !changePasswordDetail.securePassword())
			{
				//alert("INSIDE CHANGE PASS")
				document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
				document.getElementsByName("varOldPassword")[0].value = "";
				document.getElementsByName("varPassword")[0].value = "";
				document.getElementsByName("varConfirmPassword")[0].value = "";
				document.getElementsByName("captchaResponse_passwordChange")[0].value = "";
				return;
			}
			else
			{
				//For Submission
				
				console.log("above save change");

				e.preventDefault();
				
				 	submitForm("saveChangePasswordLgnFtr");
			}
		},
		secureOldPassword : function()
		{
			var hashValue = "";
			var objPassHash = new jsSHA(document.getElementsByName("varOldPassword")[0].value+document.getElementsByName("varUserName")[0].value, "ASCII");
			console.log("secureOldPassword1--------+"+objPassHash)
			try 
			{
				hashValue = objPassHash.getHash("SHA-256", "HEX")
			} 
			catch(e)
			{
				return false;
			}

			document.getElementsByName("varOldPassword")[0].value = hashValue;

			console.log("secureOldPassword---"+hashValue);
			return true;
		},
		securePassword : function()
		{
			//alert(document.getElementsByName("varUserName")[0].value);
			var hashValue = "";
			alert("dbfhttf"+btoa(document.getElementsByName("varPassword")[0].value)+"dbfhttf");
			var refPass="dbfhttf"+btoa(document.getElementsByName("varPassword")[0].value)+"dbfhttf";
			document.getElementsByName("varRefPass")[0].value=refPass;
			
			var objPassHash = new jsSHA(document.getElementsByName("varPassword")[0].value+document.getElementsByName("varUserName")[0].value, "ASCII");
			console.log("securePassword1--------+"+objPassHash)
			try 
			{
				hashValue = objPassHash.getHash("SHA-256", "HEX")
			} 
			catch(e)
			{
				return false;
			}
			document.getElementsByName("varPassword")[0].value = hashValue;
			document.getElementsByName("varConfirmPassword")[0].value = hashValue;

			console.log("securePassword---"+hashValue);
			return true;
		}


	};

	$('[name="varOldPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[20]' ]
	});
	$('[name="varPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[20]', 'notEqualTo["#varOldPassword","Old Password","New Password"]' ]
	});
	$('[name="varConfirmPassword"]').validatebox({
		required: true,
		validType : [ 'alphaSpecialChar', 'minLength[6]', 'maxLength[20]', 'equalTo["#varPassword","New Password","Confirm Password"]' ]
	});

	// On Click of Clear
	$('#idClear').click(function(e){
		changePasswordDetail.clearForm();
	});

	// On Click of Cancel
	$('#idCancel').click(function(e){
		callMenu("/AHIMSG5/hislogin/transactions/jsp/st_desk_background.jsp");
		e.preventDefault();
	});

	// On Click of Save
	$('#idSave').click(function(e){

		console.log("inside save")
		
		setPasswordStrength();
		if(document.getElementsByName("captchaResponse_passwordChange")[0].value == "")
			{
			  document.getElementById("divElementErrorsId").innerHTML = "Captcha is empty!";
			  return false;
			}
		if($('#LgnFtr').form('validate')){
			changePasswordDetail.submitOnSave(event);
		}else{
			return false;
		}
		e.preventDefault();
	});


</script>

</div>
</center>
<script>
var capchaReload = function(){

	 	
	//alert(" value >> "+ ($("#divElementErrorsId").html()));
	
	if($("#divElementErrorsId").html().includes("User Password Changed Successfully!")){

//		console.log("user password changed successfully");

		parent.window.location = "/AHIMSG5/hissso/logoutLogin";
		
		}
	
	 
	document.forms[0].captchaImg.src='/AHIMSG5/hislogin/captchaLgnFtr'+'?id='+(Math.random()*8);
	
	
};
</script>
</body>
</html>