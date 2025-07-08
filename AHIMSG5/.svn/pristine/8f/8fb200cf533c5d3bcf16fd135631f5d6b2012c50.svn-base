<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@page import="com.sun.org.apache.xalan.internal.utils.XMLSecurityPropertyManager.Property"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="hisglobal.security.SecureHashAlgorithm"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hislogin.config.HISLoginConfig"%>

<html>
<head>

<link href="/HIS/hisglobal/css/buttons.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/layout.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jquery-ui.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/jqueryExtValidationToolTip.css" rel="stylesheet" type="text/css">
<link href="/HIS/hisglobal/css/easyui.css" rel="stylesheet" type="text/css">

<!-- Added for Security Start-->
<%-- <script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/avai/validation.js"></script> --%>

<!-- Added for Security End-->

<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/his-jquery.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery.easyui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery-ui.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jqueryExtValidation.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/commonFunctions.js"></script>
<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/utilityFunctions.js"></script>
<script type="text/javascript" src="/HIS/hisglobal/js/multilingual.js"></script>
<script type="text/javascript" src="/AHIMSG5/hislogin/transactions/js/md5.js"></script>
<script type="text/javascript" src="/AHIMSG5/hislogin/transactions/js/security.js"></script>
</head>
<body onload="pageOnLoad()">
<center>

<div class="wrapper rounded">

<s:form action="LgnFtr" method="POST">

<s:if test="%{varStatus == 'INITIAL'}">
	<div class="div-table" >
		<div class="div-table-row " >
			<div class="div-table-col title width100 " >
					<span key='change-user-details'>Change User Details</span>
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
	<input type="hidden" id="validateUserDet" value="1">	
</s:if>

<s:elseif  test="%{varStatus == 'CHANGE_USER_DETAILS'}">
<div class="div-table" >
		<div class="div-table-row " >
			<div class="div-table-col title width100 " >
					<span key='change-user-details'>Change User Details</span>
			</div>
		</div>
 		<div class="div-table-row " >
			<div class="div-table-col subtitle width100 " >
					<sapn key='user-details'>User Details</sapn>
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
				<font color="red">*</font><span key='hint-question'>Hint Question</span> 
			</div>
			<div class="div-table-col width60 control" >
				<s:if test="%{#session.keyQuestionList != null}">
					<s:select name="varQuestionId" tabindex="1" cssStyle="width:150px" headerKey="-1" list="#session.keyQuestionList" headerValue="Select Question"  listKey="value" listValue="label" />
				</s:if>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red">*</font><span key='answer'>Answer</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="password" name="varHintAnswer" tabindex="1"   maxlength="10"  id="varHintAnswerId"  <%-- value="<s:property value="varHintAnswer"/>"  --%>autocomplete="off"/>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red"></font><span key='mobile-no'>Mobile No.</span> 
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" name="varMobileNumber" id="varMobileNumber" tabindex="1"   maxlength="10" onkeypress="return validateData(event,5)" autocomplete="off">
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<font color="red"></font><span key='e-mail'>E-mail </span>
			</div>
			<div class="div-table-col width60 control" >
				<input type="text" name="varEmailId" tabindex="1" maxlength="20"  id="varEmailId" autocomplete="off" value="<s:property value="varEmailId"/>">
			</div>
		</div>
		<div class="div-table-row " >
			<div class="div-table-col subtitle width100 " >
				 <span key='default-menu'>Default Menu</span>
			</div>
		</div>
		 <div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<span key='default-menu'>Default Menu</span>
			</div>
			<div class="div-table-col width60 control" >
				<s:if test="%{#session.keyMenuList!= null}">
					<s:select name="varMenuId" id="idMenu" tabindex="1" cssStyle="width:150px" headerKey="" list="#session.keyMenuList" headerValue="Select Menu"  listKey="value" listValue="label"/>
				</s:if>
			</div>
		</div>
		<div class="div-table-row " >
			<div class="div-table-col subtitle width100 " >
				 <span key='favourite-menus'>Favourite Menus</span>
			</div>
		</div>
		 <div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<sapn key='module'>Module</sapn>
			</div>
			<div class="div-table-col width60 control" >
				<s:if test="%{#session.keyMenuList!= null}">
					<s:select name="varModuleId" id="idModule" tabindex="1" cssStyle="width:150px" headerKey="-1" list="#session.keyModuleList" headerValue="Select Module"  listKey="value" listValue="label"/>
				</s:if>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<span key='module-menu'>Module Menu</span>
			</div>
			<div class="div-table-col width20 label" >
			</div>
			<div class="div-table-col width40 label" style="text-align: left;" >
				<sapn key='favourite-menu'>Favourite Menu</sapn>
			</div>
		</div>
		<div class="div-table-row ">
			<div class="div-table-col width40 label" >
				<s:if test="%{#session.keyMenuList!= null}">
					<s:select multiple="true" name="varModuleMenuId" id="idModuleMenu" tabindex="1" cssStyle="width:150px" list="#session.keyModuleMenuList"  listKey="value" listValue="label"/>
				</s:if>
			</div>
			<div class="div-table-col width20 label" style="text-align: center;">
				<input type="button" name="add" value=">" onclick="if(checkForMaxFavLimitWhileMov(false)) moveSingle(varModuleMenuId,varFavMenuId)"/>
				<input type="button" name="add2" value=">>" onclick="if(checkForMaxFavLimitWhileMov(true)) moveAll(varModuleMenuId,varFavMenuId)"/>
				<br>
				<input type="button" name="add3" value="<"onclick="moveSingle(varFavMenuId,varModuleMenuId)"/>
				<input type="button" name="add4" value="<<"onclick="moveAll(varFavMenuId,varModuleMenuId)"/>
			</div>

			<div class="div-table-col width40 control" >
				<s:if test="%{#session.keyMenuList!= null}">
					<s:select multiple="true" name="varFavMenuId" id="idFavMenu" tabindex="1" cssStyle="width:150px" list="#session.keyFavouriteList"  listKey="value" listValue="label"/>
				</s:if>
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
			<a href="#" class="button" tabindex="1" id="idSave"><span class="save" key="save">Save</span></a>
			<a href="#" class="button" tabindex="1" id="idClear"><span class="clear" key="clear">Clear</span></a>
			<a href="#" class="button" tabindex="1" id="idCancel"><span class="cancel" key="cancel">Cancel</span></a>
		</div>
	</div>

<s:hidden name="varOldHintAnswer"></s:hidden>
<input type="hidden" id="saveUserDet" value="1">
</s:elseif>		
<s:hidden name="varUserName"></s:hidden>
<s:hidden name="varStatus"></s:hidden>
 <s:hidden name="mobileNoFormat" value="%{varMobileNumber}"></s:hidden>
 
 <input type="hidden" name="x-auth-token" id="x-auth-token" value="<%=SecureHashAlgorithm.generateRandom(request)%>" />
 
 <div id="divElementErrorsId" class="alertMessage"><s:actionerror /></div>
<div style="display: none;">
    <span id="favourite-menus-should-be-less-than-or-equal-to-12" key='favourite-menus-should-be-less-than-or-equal-to-12'>Favourite Menus should be less than or equal to 12.</span>
    <span id="faced-some-unknown-problem-please-try-again" key='faced-some-unknown-problem-please-try-again'>Faced Some Unknown Problem. Please try Again!</span>
    
    </div>
</s:form>
<script type="text/javascript">




function validateEmail(obj){

	 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#varEmailId').val()))
	  {
	    return (true)
	  }else{
		  alert("Please enter valid email address!");
		  }
	/* alert("ghfhfgh"); 
	
	var testresults;
	if(trimSpec(obj.value)!="")
	{
	 var str=obj.value
	 var filter=/^.+@.+\..{2,3}$/

	 if (filter.test(str))
	    testresults=true
	 else {
	    alert("Please enter valid email address!")
	    testresults=false
	}
	}
	else
	{
		testresults=true;
	}
	 return (testresults) */
	} 

function pageOnLoad()
{
	if(document.getElementsByName('varPassword')[0])	document.getElementsByName('varPassword')[0].focus();
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
function isAlreadyAdded(menuId)
{   var source=document.getElementsByName('varFavMenuId')[0];
	var totalElement = source.length;
	
	for(var i=0;i<totalElement;i++)
	{
		 //alert(menuId+"and"+source.options[i].value);
		if(source.options[i].value==menuId)
		    {
				//alert(menuId);
				return true;
			}
	}
				return false;
	
}

function checkForMaxFavLimitWhileMov(isMoveAll)
{
	var source=document.getElementsByName("varModuleMenuId")[0];
	var sourceSel=0;
	if(isMoveAll)	sourceSel = source.options.length;
	else
	{
		for(var i=0;i<source.options.length;i++)
		{
			if(source.options[i].selected==true)
				sourceSel++;
		}
	}
	
	var target=document.getElementsByName("varFavMenuId")[0];
	if((sourceSel+target.options.length)>12)
	{
		//alert("Favourite Menus should be less than or equal to 12.");
		alert($("#favourite-menus-should-be-less-than-or-equal-to-12").html() );
		source.focus();
		return false;
	}
	return true;
}
function checkForMaxFavLimit()
{
	var source=document.getElementsByName('varFavMenuId')[0];
	if(source.options.length>12)
	{
		//alert("Favourite Menus should be less than or equal to 12.");
		alert($("#favourite-menus-should-be-less-than-or-equal-to-12").html() );
		source.focus();
		return false;
	}
	return true;
}
function makeFavListSelected()
{
	var source=document.getElementsByName('varFavMenuId')[0];	
	// Check for 
	if(!checkForMaxFavLimit())
	{
		return false;
	}
	var totalElement = source.length;
	for(var i=0;i<totalElement;i++)
	{
		source.options[i].selected=true;
	}
	if(document.getElementsByName("varMenuId")[0].value=='-1')
		document.getElementsByName("varMenuId")[0].value='';
	return true;
}
function checkMaliciousScript(dataVal){
	 
	var malchar = ["<script>", "<", "%",">","&", "|","*","$","\0","\'","\"","\b","\n","\r","\t","\Z","\\","\%"];//!(/^[A-z&#209;&#241;0-9]*$/i).test(f.value)?f.value = f.value.replace(/[^A-z&#209;&#241;0-9]/ig,''):null;

	var flag=true;
	for(var i=0;i<malchar.length;i++){
		if(dataVal.indexOf(malchar[i])!=-1){
			alert("Invalid character is found");
			flag=false;
			break;
		}
	}
//	flag=true;
	return flag;
} 
var changeUserDetails = {
		clearForm : function()
		{
			
			
			if(document.getElementsByName("varQuestionId")[0])	document.getElementsByName("varQuestionId")[0].value = "-1";
			if(document.getElementsByName("varHintAnswer")[0])	document.getElementsByName("varHintAnswer")[0].value = "";
			if(document.getElementsByName("varMobileNumber")[0])	document.getElementsByName("varMobileNumber")[0].value = "";
			if(document.getElementsByName("varEmailId")[0])	document.getElementsByName("varEmailId")[0].value = "";
			if(document.getElementsByName("varMenuId")[0])	document.getElementsByName("varMenuId")[0].value = "";
			/*alert(document.getElementsByName("varFavMenuId")[0].options[0].value);
			alert(document.getElementsByName("varFavMenuId")[0].options[1].value);
			alert(document.getElementsByName("varFavMenuId")[0].options[2].value);
			*/
		},
		submitOnGo : function()
		{
			if(!changeUserDetails.securePassword())
			{
				//document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
				document.getElementById("divElementErrorsId").innerHTML = $("#faced-some-unknown-problem-please-try-again").html();
				document.getElementsByName("varPassword")[0].value = "";
				return;
			}
			else
			{
				
				//For Submission
			  	submitForm("validateChangeUserDetailsLgnFtr");
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
		secureAnswer : function()
		{
			if(document.getElementsByName("varHintAnswer")[0].value==document.getElementsByName("varOldHintAnswer")[0].value) return true;
			var hashValue = "";
			var objPassHash = new jsSHA(document.getElementsByName("varHintAnswer")[0].value+document.getElementsByName("varQuestionId")[0].value, "ASCII");
			try 
			{
				hashValue = objPassHash.getHash("SHA-1", "HEX");
			} 
			catch(e)
			{
				return false;
			}
			document.getElementsByName("varHintAnswer")[0].value = hashValue;
			return true;
		},
		submitOnSave : function()
		{
			//alert("avsfskhlhjhghh");
			
			if(!changeUserDetails.secureAnswer())
			{
				//document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
				document.getElementById("divElementErrorsId").innerHTML = $("#faced-some-unknown-problem-please-try-again").html();
				if(document.getElementsByName("varQuestionId")[0])	document.getElementsByName("varQuestionId")[0].value = "-1";
				if(document.getElementsByName("varHintAnswer")[0])	document.getElementsByName("varHintAnswer")[0].value = "";
				if(document.getElementsByName("varMobileNumber")[0])	document.getElementsByName("varMobileNumber")[0].value = "";
				if(document.getElementsByName("varEmailId")[0])	document.getElementsByName("varEmailId")[0].value = "";
				if(document.getElementsByName("varMenuId")[0])	document.getElementsByName("varMenuId")[0].value = "";
				return;
			}
			else
			{
				//For Submission
				if(!makeFavListSelected())	return;
			  	submitForm("saveChangeUserDetailsLgnFtr");
			}
		},
		
		getMenuList:function()
		{
			var action="";
			var moduleId= $("#idModule").val();
			var action 	= "/AHIMSG5/hislogin/transactions/action/getMenuListLgnFtr?moduleId="+moduleId;

				$.ajax({url: action,type:"POST",async:false,dataType:"json" ,success:function(data){

					alert(data);
					
				menuListJsonObj=data;
				var strOptions="";
				
				for(var menuId in menuListJsonObj){
					//alert(isAlreadyAdded(menuId));
				
					if(!isAlreadyAdded(menuId))
					{
					strOptions+="<option value='"+menuId+"'>"+menuListJsonObj[menuId]+"</option>";
					}
			}
			$("#idModuleMenu").html(strOptions);
			},error: function(errorMsg,textstatus,errorthrown) {
			//alert('getMenuList '+errorMsg+" textstatus::"+textstatus+" errorthrown::"+errorthrown);			
			}
			});
		}


	};

	$("#idModule").change(function(){
		changeUserDetails.getMenuList();
	});

	$('[name="varPassword"]').validatebox({
		required: true
	});
	// On Enter of Password Textbox
	$('[name="varPassword"]').keypress(function(e){
		if(e.keyCode==13)
		{
			if($('#LgnFtr').form('validate')){
				changeUserDetails.submitOnGo();
			}else{
				return false;
			}
		}
		else return true;
		e.preventDefault();
	});
	$('[name="varHintAnswer"]').validatebox({
		required: true,
		validType: ['alphaSpecialChar','minLength[8]', 'maxLength[15]']
	});
	$('[name="varMobileNumber"]').validatebox({
		required: false,
		validType: ['numeric','minLength[10]', 'maxLength[10]']
	});
	// On Click of Go
	$('#idGo').click(function(e){
		//setHintAnswerStrength();
		$('[name="varHintAnswer"]').validatebox({
		required: true,
		validType: ['alphaSpecialChar','minLength[8]', 'maxLength[15]']
	});
		 
		if($('#LgnFtr').form('validate')){
			changeUserDetails.submitOnGo();
		}else{
			return false;
		}
		e.preventDefault();
	});

	// On Click of Clear
	$('#idClear').click(function(e){
		changeUserDetails.clearForm();
	});

	// On Click of Cancel
	$('#idCancel').click(function(e){
		callMenu("/AHIMSG5/hislogin/transactions/jsp/st_desk_background.jsp");
		e.preventDefault();
	});

	// On Click of Save
	$('#idSave').click(function(e){
		 //setHintAnswerStrength();
		var flag=false;
		var fn = $("#varHintAnswerId").val();
		flag=checkMaliciousScript(fn);
		if(flag==false)
			return false;
		if(($('#LgnFtr').form('validate'))&& flag==true){

			 if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test($('#varEmailId').val()))
			  {  	

				 
					  changeUserDetails.submitOnSave(); 
					 
			  }
			  else{
				  alert("Please enter valid email address!");
				  }
			
		}else{
			return false;
		}
		
		/* return false;
		} */
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