<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@page import="com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager.Property"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>

<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hislogin.config.HISLoginConfig"%>

<html>
<head>
<script language="JavaScript" type="text/javascript"
	src="/HIS/hisglobal/bootstrap/jquery.min.js"></script>
<script language="JavaScript" type="text/javascript"
	src="/HIS/hisglobal/bootstrap/bootstrap.min.js"></script>
<link href="/HIS/hisglobal/bootstrap/bootstrap.min.css" rel="stylesheet"
	type="text/css" />

<link href="/HIS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/layout.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jqueryExtValidationToolTip.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/easyui.css" rel="stylesheet" type="text/css">

<!-- Added for Security Start-->
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/avai/validation.js"></script>
<!-- Added for Security End-->

<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/his-jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery.easyui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/jqueryExtValidation.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/utilityFunctions.js"></script>
<script type="text/javascript" src="/HIS/hisglobal/js/multilingual.js"></script>

<style type="text/css">
.label{color:#013157;}


</style>

</head>
<body onload="pageOnLoad()">
<center>

<div class="wrapper rounded">

<s:form action="LgnFtr">

<s:if test="%{varStatus == 'INITIAL'}">
	<div class="div-table" >
		<div class="div-table-row " >
			<div class="div-table-col title width100 " >
					<span key='add-update-mobile-no'>Add/Update Mobile No.</span>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='password'>Password</span>
			</div>
			<div class="div-table-col width60 control" >
				<input type="password" name="varPassword" tabindex="1" maxlength="20" autocomplete="off">
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width100 label" >
				<font color='red'>
					<br>
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
		<div class="div-table-row" align="center">
			<a href="#" class="button" tabindex="1" id="idGo"><span class="next" key='go'>Go</span></a>
			<a href="#" class="button" tabindex="1" id="idCancel"><span class="cancel" key='cancel'>Cancel</span></a>
		</div>
	</div>
</s:if>

<s:elseif  test="%{varStatus == 'ADD_UPDATE_MOBILE_NO'}">
<div class="div-table" >
		<div class="div-table-row " >
			<div class="div-table-col title width100 " >
				<span key='add-update-mobile-no'>Add/Update Mobile No.</span>
			</div>
		</div>
 		<div class="div-table-row " >
			<div class="div-table-col subtitle width100 " >
					<span key='user-details'>User Details</span>
			</div>
		</div>      
		
	    <div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<span key='user-name'>User Name</span> 
			</div>
			<div class="div-table-col width60 control" >
				<s:property value="varUsrName"/>
			</div>
		</div>
		
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red"></font><span key='mobile-no'>Existing Mobile No.</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" id="varMobileNumber" name="varMobileNumber" tabindex="1" maxlength="10" value="<s:property value="varMobileNumber"/>" disabled>
			</div>
		</div>
		<div class="div-table-row">
		<div class="div-table-col width40 label" >
				</div>
			<div class="div-table-col width60 label" style="text-align:left;" >
				<input type="checkbox" id="addUpdateMobile" onclick="showAddUpdateMobile(this)"/>&nbsp;<span key='update-mobile-no'>Update Mobile No.</span>
			  </div> 
		</div>
		<%-- <div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red"></font><span key='mobile-no'>Existing Mobile No.</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" name="varMobileNumber" tabindex="1" maxlength="10" pattern=".*[^\d]\d{4}\s*$" value="<s:property value="varMobileNumber"/>"  disabled>
			</div>
		</div> --%>
		
		<div id="addUpdateMobileNo" class="div-table" style="display:none;" >
		 <div class="div-table-row " >
			<div class="div-table-col subtitle width100 " >
				 <span key='add-update-mobile-no'>Add/Update Mobile No.</span>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='new-mobile-no'>New Mobile No.</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" name="varNewMobileNumber" id="varNewMobileNumber" tabindex="1" maxlength="10">
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='confirm-new-mobile-no'>Confirm New Mobile No.</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" name="varConfirmMobileNumber" id="varConfirmMobileNumber" tabindex="1" maxlength="10" >
			</div>
		</div>
		
		<%-- <div class="div-table-row ">
			<div class="div-table-col width80 label" >
				<font color="red"></font><span key='otp-verification'>Kindly enter valid Mobile Number. Click on "Send OTP" button to continue. An OTP will be sent to verify the Mobile number before saving changes.</span> 
			</div>
			
		</div>
		 --%>
		</div> 
		
		
	</div>
	<div class="div-table-button">
		<div class="div-table-row footerBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row emptyBar">
			<div class="div-table-col"> </div>
		</div>
		<div class="div-table-row" align="center">
			<a href="#" class="button" tabindex="1" id="idSave"><span class="save" key="save">Save</span></a>
			<a href="#" class="button" tabindex="1" id="idClear"><span class="clear" key="clear">Clear</span></a>
			<a href="#" class="button" tabindex="1" id="idCancel"><span class="cancel" key="cancel">Cancel</span></a>
		</div>
	</div>

</s:elseif>		
<s:hidden name="varUserName"></s:hidden>
<s:hidden name="varStatus"></s:hidden>
<s:hidden id="mobileNoFormat" name="mobileNoFormat" value="%{varMobileNumber}"></s:hidden>
 
	<div class="modal fade" id="registrationStatus" role="dialog"
		data-keyboard="false" data-backdrop="static">
		<div class="modal-dialog modal-md" style="margin-top: 141px;">
			<div class="modal-content">
				<div class="modal-header">
					<span key='verify-and-confirm-your-mobile-no'>Verify and confirm your mobile number</span>		
					<button type="button" id="closeBtn" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<input type="password" name="otp" id="otp" class="form-control"
								onkeypress="return validateNumeric(event)" maxlength="8"
								size="15" placeholder="Enter OTP" key-placeholder='enter-otp'></input>

							<div align="center">
								<div id="lable1" class="alertMessage label1Class"></div>
							</div>
							</br> 
							<center>
								<button type="button" class="btn btn-primary" id="btnsave"
									onclick="proceedOld()"><span key='submit-otp'>Submit OTP</span></button>
								<button type="button" disabled="disabled"
									class="btn btn-primary" id="btnresend" onclick="resendOTP()"><span key='resend-otp'>Resend
									OTP</span></button>
							</center>


							<div id="countdown">
								<div id="countdown"></div>
								<div id="countdown2"></div>
								<div id="countdown"></div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>


	<button type="button" id='popupLaunch' class="btn btn-primary"
		style="display: none;" data-toggle="modal"
		data-target="#registrationStatus"></button> 
 
 
<div id="divElementErrorsId" class="alertMessage"><s:actionerror /></div>
<div style="display: none;">
      <span id="faced-some-unknown-problem-please-try-again" key='faced-some-unknown-problem-please-try-again'>Faced Some Unknown Problem. Please try Again!</span>
   <span id="otp-verified-successfully" key='otp-verified-successfully'>OTP verified successfully.</span>
	<span id="incorrect-otp-entered-enter-otp-again" key='incorrect-otp-entered-enter-otp-again'>Incorrect OTP Entered. Enter OTP Again.</span>
	<span id="otp-has-expired-click-on-resend-otp-button" key='otp-has-expired-click-on-resend-otp-button'>OTP has expired. Click on Resend OTP button.</span>
  <span id="resend-otp" key='resend-otp'>Resend OTP</span>
  <span id="an-otp-has-been-sent" key='an-otp-has-been-sent'>An OTP has been sent</span>
	<span id="to-your-registered-mobile-no" key='to-your-registered-mobile-no'>to your registered mobile no.</span>
	<span id="no-to" key='no-to'></span>
	
    </div>
</s:form>
<script type="text/javascript">

$('[name="varNewMobileNumber"]').validatebox({
	required: true,
	validType : [ 'numericwithoutspace', 'equalLengthNumeric[10]','DisableAllZero','mobileNostartwithseven', 'notEqualTo["#mobileNoFormat","New Mobile No","Existing Mobile No"]']
});
$('[name="varConfirmMobileNumber"]').validatebox({
	required: true,
	validType : [ 'numericwithoutspace', 'equalLengthNumeric[10]','DisableAllZero','mobileNostartwithseven', 'equalTo["#varNewMobileNumber","Confirm New Mobile No","New Mobile No"]' ]
});
function pageOnLoad()
{
	if(document.getElementsByName('varPassword')[0])	document.getElementsByName('varPassword')[0].focus();
	var str=document.getElementsByName("mobileNoFormat")[0].value;
	var str=str.replace(/.(?=.{4})/g, 'x');
	//console.log("str-> "+str);
	document.getElementById("varMobileNumber").value=str;
	
}
function showAddUpdateMobile(elem)
{
	if(elem.checked)
document.getElementById("addUpdateMobileNo").style.display="inline-table";
	else
		document.getElementById("addUpdateMobileNo").style.display="none";
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

function generateOtp()
{
	var urlNew="/AHIMSG5/hislogin/transactions/action/SENDOTPLgnFtr";
	var data="varNewMobileNumber="+$('#varNewMobileNumber').val();
	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	
	data = "";
	$.ajax({url:urlNew,type:'POST',data:data,async: false,success:function(result)
		{
			//alert(result);
		var displayMobNo= $('#varNewMobileNumber').val().substring(6,10);
		$(".label1Class").html($("#an-otp-has-been-sent").html()+" "+$("#to-your-registered-mobile-no").html()+"- "+"xxxxxx"+displayMobNo+$("#no-to").html());
		//$(".label1Class").html("OTP has been sent to your Mobile No. ******"+displayMobNo);
	
	$("#popupLaunch").click();
	setTimerForOTP();
		}
	});
   		
}

function proceedOld(){
	var urlNew="/AHIMSG5/hislogin/transactions/action/VALIDATEOTPLgnFtr";
	var data="varNewMobileNumber="+$('#varNewMobileNumber').val()+"&otp="+$("#otp").val();
	
	//var data="mode=VALIDATEOTP&crNo="+$("#crno").val()+"&otp="+$("#otp").val();

	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
		
	data = "";
	
	$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
		{
		if(result=="1")
			{
 
			//window.open('/HISInvestigationG5/HISPreregistration_onlineAppointment/LabRptRegistrationoldServlet.lab','_self');
			//document.getElementById("tr2").style.display="none";
			//document.getElementById("OldNext").style.display="none";
			//document.getElementById("OldOTP").style.display="";
		//	document.getElementById("patType").value="1";
			//$(".label1Class").html("OTP verified successfully.");
			$(".label1Class").html($("#otp-verified-successfully").html());
			
		//	document.getElementById("varNewMobileNumber").value="";
			//document.getElementById("otp").value="";
			document.getElementById("otp").disabled=true;
			$("#closeBtn").click();
			document.getElementById("varNewMobileNumber").disabled=true;
			document.getElementById("varConfirmMobileNumber").disabled=true;
			addUpdateMobileNo.submitOnSave();
			
			//redirect();
			}
	 	else if(result=="2")
		{
			//$(".label1Class").html("Incorrent OTP Entered. Enter OTP Again.");
	 		$(".label1Class").html($("incorrect-otp-entered-enter-otp-again").html());
			
		}
		else if(result=="3")
		{
			//$(".label1Class").html("OTP has expired. Click on Resend OTP button.");
			$(".label1Class").html($("otp-has-expired-click-on-resend-otp-button").html());
			
		}	 
		}
	});
		

}


function resendOTP()
{ 



	var urlNew="/AHIMSG5/hislogin/transactions/action/SENDOTPLgnFtr";
	var data="mode=SENDOTP"+"&varNewMobileNumber="+$('#varNewMobileNumber').val();
	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	
	data = "";
	$.ajax({url:urlNew,type:'POST',data:data,async: false,success:function(result)
		{
			
		var displayMobNo= $('#varNewMobileNumber').val().substring(6,10);
		//$(".label1Class").html("OTP has been sent to your Mobile No. ******"+displayMobNo);
		$(".label1Class").html($("#an-otp-has-been-sent").html()+" "+$("#to-your-registered-mobile-no").html()+"- "+"xxxxxx"+displayMobNo+$("#no-to").html());
		
	
	//$("#popupLaunch").click();
	setTimerForOTP();
		}
	});
   	     }


function setTimerForOTP(){


  
   
   document.getElementById("btnresend").disabled = true;
   document.getElementById("btnsave").disabled = false;
   
// Set the date we're counting down to
   var countDownDate = new Date(new Date().getTime() + 1*60000);

   // Update the count down every 1 second
   var x = setInterval(function() {

     // Get today's date and time
     var now = new Date().getTime();
       
     // Find the distance between now and the count down date
     var distance = countDownDate - now;
       
     // Time calculations for days, hours, minutes and seconds
     var days = Math.floor(distance / (1000 * 60 * 60 * 24));
     var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
     var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
     var seconds = Math.floor((distance % (1000 * 60)) / 1000);
       
     // Output the result in an element with id="demo"
     document.getElementById("btnresend").innerHTML =  $("#resend-otp").html()+ "( "+seconds + "s )";
       
     // If the count down is over, write some text 
     if (distance < 0) {
       clearInterval(x);
       document.getElementById("btnresend").innerHTML =  $("#resend-otp").html();
       document.getElementById("btnresend").disabled = false;
       document.getElementById("btnsave").disabled = true;
       
       
     }
   }, 1000);
   
   
   }

function countdown( elementName, minutes, seconds )
{

var element, endTime, hours, mins, msLeft, time;

function twoDigits( n )
{
return (n <= 9 ? "0" + n : n);
}

function updateTimer()
{
msLeft = endTime - (+new Date);
if ( msLeft < 1000 ) {


var patContactNo=$('[name="patContactNo"]').val();
var action="";
	<%--  var action="<%=context_path%>LabRptRegistrationServlet"; --%>
	var urlNew="/AHIMSG5/hislogin/transactions/action/EXPIREOTPLgnFtr";
	var data="mode=SENDOTP"+"&varNewMobileNumber="+$('#varNewMobileNumber').val();
	urlNew = createFHashAjaxQuery(urlNew+"?"+data);
	
	
  // var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
	$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
	{
	if(result=="1")
	{
	$("#lable2").html("Time Over Please Resend OTP");
    element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
  	}	   	
	} 
	});
	  } else {
    time = new Date( msLeft );
    hours = time.getUTCHours();
    mins = time.getUTCMinutes();
    element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
    setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );

    alert("time"+time);
}
}

element = document.getElementById( elementName );
endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
alert("endtime"+endTime);
updateTimer();

}
<%-- countdown( "countdown", <%=AppointmentConfig.COUNTDOWN_TIME_LIMIT%>, 5 );	   --%>      



var addUpdateMobileNo = {
		clearForm : function()
		{
			
			
			if(document.getElementsByName("varNewMobileNumber")[0])	document.getElementsByName("varNewMobileNumber")[0].value = "";
			if(document.getElementsByName("varConfirmMobileNumber")[0])	document.getElementsByName("varConfirmMobileNumber")[0].value = "";
			
		},
		submitOnGo : function()
		{
			if(!addUpdateMobileNo.securePassword())
			{
				//console.log("in if");
				//document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
				document.getElementById("divElementErrorsId").innerHTML = $("#faced-some-unknown-problem-please-try-again").html();
				document.getElementsByName("varPassword")[0].value = "";
				return;
			}
			else
			{
			//	console.log("in else");
				//For Submission
			  	submitForm("validateAddUpdateMobileNoLgnFtr");
			}
		},
		securePassword : function()
		{
			
			//if(document.getElementsByName("varPassword")[0].value==document.getElementsByName("varOldPassword")[0].value)
			//	{
			var hashValue = "";
			var objPassHash = new jsSHA(document.getElementsByName("varPassword")[0].value+document.getElementsByName("varUserName")[0].value, "ASCII");
			try 
			{
				hashValue = objPassHash.getHash("SHA-1", "HEX");
			} 
			catch(e)
			{
				return false;
			}

			document.getElementsByName("varPassword")[0].value = hashValue;
			return true;
			
		},
		submitOnSave : function()
		{
			//alert("avsfskhlhjhghh");
			
			/* if(!addUpdateMobileNo.securePassword())
			{
				//document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
				if(document.getElementsByName("varMobileNumber")[0])	document.getElementsByName("varMobileNumber")[0].value = "";
				return;
			}
			else
			{
			 */	//For Submission
				submitForm(createFHashAjaxQuery("saveAddUpdateMobileNoLgnFtr?varNewMobileNumber="+$("#varNewMobileNumber").val()));
			//}
		},
		/* generateOTP: function(){
		submitForm("generateOTPLgnFtr");
		}
	 */
		
		
	};

	
	$('[name="varPassword"]').validatebox({
		required: true
	});
	// On Enter of Password Textbox
	$('[name="varPassword"]').keypress(function(e){
		if(e.keyCode==13)
		{
			if($('#LgnFtr').form('validate')){
				addUpdateMobileNo.submitOnGo();
			}else{
				return false;
			}
		}
		else return true;
		e.preventDefault();
	});
	// On Click of Go
	$('#idGo').click(function(e){
		if($('#LgnFtr').form('validate')){
			//console.log("true");
			addUpdateMobileNo.submitOnGo();
		}else{
			//console.log("false");
			return false;
		}
		e.preventDefault();
	});

	// On Click of Clear
	$('#idClear').click(function(e){
		addUpdateMobileNo.clearForm();
	});

	// On Click of Cancel
	$('#idCancel').click(function(e){
		callMenu("/AHIMSG5/hislogin/transactions/jsp/st_desk_background.jsp");
		e.preventDefault();
	});

	// On Click of Save
	$('#idSave').click(function(e){
		if($('#LgnFtr').form('validate')){
			generateOtp();
			//addUpdateMobileNo.submitOnSave();
		}else{
			return false;
		}
		e.preventDefault();
	});
	// On Change of MenuId
	
	// On Change of moduleMenu
	/*$('#idModuleMenu').change(function(e){
		if($('#LgnFtr').form('validate')){
			changeUserDetails.submitOnSave();
		}else{
			return false;
		}
		
		alert("sdhhfgkwehfL");
		e.preventDefault();
	});*/
	
</script>

</div>
</center>
</body>
</html>