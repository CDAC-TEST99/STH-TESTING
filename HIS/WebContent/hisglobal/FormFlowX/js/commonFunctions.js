var debug=true;
function checkQueryDetails(query)
{
		if(!query.toUpperCase().match(/UPDATE TABLE.*/) && !query.toUpperCase().match(/DELETE FROM.*/) && !query.toUpperCase().match(/INSERT INTO.*/) && !query.toUpperCase().match(/ALTER TABLE.*/) && !query.toUpperCase().match(/DROP TABLE.*/) && !query.toUpperCase().match(/TRUNCATE TABLE.*/) ){
			return true;
		}
		else
			return false;
	
}
function getType(p) {
    if (Array.isArray(p)) return 'array';
    else if (typeof p == 'string') return 'string';
    else if (p != null && typeof p == 'object') return 'object';
    else return 'other';
}
function submitPage(mode){
	
    	
	document.forms[0].mode.value=mode;
	document.forms[0].submit();
}

function submitForm(hmode)
{
//	alert($('#isGlobal').val());
    if($('#isGlobal').val()=="1"){
    	document.forms[0].action=document.forms[0].action+"?isGlobal=1";
    }
	document.forms[0].hmode.value=hmode;
	document.forms[0].submit();
}
function resetFormBeforeSubmit(){
	 $('form').find("input[type=text], textarea").val("");
}
function submitFormWithResetTextField(hmode)
{
	resetFormBeforeSubmit();
	submitForm(hmode);
}


function viewComboText(comboobj){
if(comboobj.options.length>0 && comboobj.value!="-1"){
	for(var i=0;i<comboobj.options.length;i++)
		if(comboobj.options[i].value==comboobj.value){
			comboobj.title=comboobj.options[i].text;
			break;
		}
	}
}

function getUniqueId()
{
     var dateObject = new Date();
    var uniqueId =dateObject.getHours()+'-'+dateObject.getMinutes()+'-'+dateObject.getSeconds();
     return uniqueId;
}

//create table data
function createTableData(str,width,style,height){
	var tdata;
	tdata=document.createElement("TD");
	tdata.innerHTML=str;
	tdata.className=style;		
	tdata.width=width;
	tdata.height=height;
	return tdata;
}

//function to create multiple row within table 
function createMultyRow(tableId,tdobj,rowId){
var tableObj=document.getElementById(tableId);
var numRows=tableObj.rows.length;
var tabRow1=tableObj.insertRow(numRows);
tabRow1.id= rowId;		
for(var i=0;i<tdobj.length;i++)
{
	tabRow1.appendChild(tdobj[i]);		
}

}

//function to delete row form table
function deleteMultyRow(tableId, rowId) {
	var tableObj = document.getElementById(tableId);
	var rowCount = document.getElementsByName("tr").length;
	rowCount = $('#' + tableId + ' tr').length; // row count including header row
	if (rowCount - 1 < 2) {
		alert('One row must be there.');
	} else {
		var tr1;
		tr1 = document.getElementById(rowId);
		tabRow = tableObj.deleteRow(tr1.rowIndex);
	}
}

//function to move data from one combo to another
	function deleteThis(srcMenuObj,targetMenuObj)
	{	
		var t =0;
		var val1 = "";
		var val2 = "";		
		var len  = targetMenuObj.length;
		var len2 = srcMenuObj.length;					
		var a1 = new Array(len);
		var a2 = new Array(len);	
		var a3 = new Array(len2);	
	
	for(var i=0;i<len;i++)
	{		
		a1[i]= targetMenuObj.options[i].value;
		a2[i]= targetMenuObj.options[i].text;					
	}	
	
	for( i=0;i<len2;i++)
	{		
		a3[i]= srcMenuObj.options[i].value;
	}
		
	targetMenuObj.length = 0;	
	var counter = 0;	
	var k = 0;	
	var flag = 0;
			
	for(i=0;i<len;i++)
	{		
			flag = 0;
		for(k=0;k<len2;k++)
		{		
			if(a1[i]==a3[k])
			{	
				flag = 1;					
			}					
		}		
		if(flag==0)
		{
			targetMenuObj.length = (counter+1);
			targetMenuObj.options[counter].value = a1[i];
			targetMenuObj.options[counter].text  = a2[i]; 
			counter++;			
		}		
	}
	
}

function moveSingle(firstName,secondName)
{
	//alert("m here move single in common function");
	var firstMenuObj=document.getElementsByName(firstName)[0];
	var secondMenuObj=document.getElementsByName(secondName)[0];
	
	//alert(firstName +"--"+firstMenuObj);
	//alert(secondName + "-"+secondMenuObj);
	var val1 = "";
	var val2 = "";
	var t1 = 0;
	var totalElement=firstMenuObj.options.length;
	var flag=0;
	for(var i=0;i<totalElement;i++)
	{
		if(firstMenuObj.options[i].selected)
		{
			flag=1;
			val1 = firstMenuObj.options[i].value;
			val2 = firstMenuObj.options[i].text;			
		
			t1 = secondMenuObj.length;							
			secondMenuObj.length = (t1+1);	
			
			secondMenuObj.options[t1].value = val1;
			secondMenuObj.options[t1].text  = val2;			
		}               
    }
    if(flag==0){
    	//alert("Please select the data in list to move ");
    	firstMenuObj.focus();
    	return;
    }
    
  deleteThis(secondMenuObj,firstMenuObj);			
}


function moveAll(firstName,secondName)
{
	//alert("m here move single in common function");
	var firstMenuObj=document.getElementsByName(firstName)[0];
	var secondMenuObj=document.getElementsByName(secondName)[0];
	
	//alert(firstName +"--"+firstMenuObj);
	//alert(secondName + "-"+secondMenuObj);
	var val1 = "";
	var val2 = "";
	var t1 = 0;
	var totalElement=firstMenuObj.options.length;
	for(var i=0;i<totalElement;i++)
	{
		val1 = firstMenuObj.options[i].value;
		val2 = firstMenuObj.options[i].text;			
		
		t1 = secondMenuObj.length;							
		secondMenuObj.length = (t1+1);	
			
		secondMenuObj.options[t1].value = val1;
		secondMenuObj.options[t1].text  = val2;			
	}
   
    
  			
}


function emptycombo(comboobj){
  if(comboobj){
  comboobj.options.length=0;
  comboobj.options.length=1;
  comboobj.options[0].value="-1";
  comboobj.options[0].text="--Select Value--";
  comboobj.value="-1";
  }    
} 
function toggle(allids,status) {
	 //alert("inside toggle" + allids);
	 var arrId=allids.split('$$');
	 var display="";
	 if(status==0)
		 display="none";		 
	 else
		 display="";
		 
	 for(var i=0;i<arrId.length;i++){
		 //alert(arrId[i]);
		 if(document.getElementById(arrId[i])){
		//	 alert("inside " + arrId[i])
			document.getElementById(arrId[i]).style.display=display;
		 }
	 }	 
}

//toggle Id passed if length of optioins in combo passed is 0 or more
function toggleParameters(parameterComboName, idToToggle){
	var combo= document.getElementsByName(parameterComboName)[0];
	if(combo.options.length==0){
		$("#"+idToToggle).hide();
		
	}else{
		$("#"+idToToggle).show();
	}
}
		
		

function validateNumericOnly(obj,evnt)
{// Ascii Code 0 - 48 To 9 - 57 , for . - 46
	try
	{
		var flag = true;
		var key =0 ,char;
		if( typeof evnt.charCode != 'undefined')
				{	
					key = evnt.keyCode;
					char = evnt.charCode;
				}
				else 
					char=evnt.keyCode;
				var pattern=/\./;
				if( key!=0 || ( !pattern.test(obj.value) && char==46) ||(obj.value.length==0 && char==45) || (char>=48 && char<= 57))
					return true;
				else
					return false;
			}
			catch(e)
			{
				alert("Error Message -> "+e.message);
			}
		}		


function validateAlphaOnly(obj,evnt)
{// Ascii Code 0 - 48 To 9 - 57,A-65, Z-90, a-97, z-122, Space- 32, . -46, for , - 44
	try
	{
		var flag = true;
		
		var key =0 ,char;
		if( typeof evnt.charCode != 'undefined')
		{	
			key = evnt.keyCode;
			char = evnt.charCode;
		}
		else 
			char=evnt.keyCode;
		if( key!=0 || char==32 || char==46 || (char>=65 && char<=90) || (char>=97 && char<=122) )
			return true;
		else
			return false;
	}
	catch(e)
	{
		alert("Error Message -> "+e.message);
	}
}



function validateNumericOnly(obj,evnt)
{// Ascii Code 0 - 48 To 9 - 57 , for . - 46
	try
	{
		var flag = true;
		var key =0 ,char;
		if( typeof evnt.charCode != 'undefined')
				{	
					key = evnt.keyCode;
					char = evnt.charCode;
				}
				else 
					char=evnt.keyCode;
				var pattern=/\./;
				if( key!=0 || ( !pattern.test(obj.value) && char==46) ||(obj.value.length==0 && char==45) || (char>=48 && char<= 57))
					return true;
				else
					return false;
			}
			catch(e)
			{
				alert("Error Message -> "+e.message);
			}
		}		


function validateAlphaOnly(obj,evnt)
{// Ascii Code 0 - 48 To 9 - 57,A-65, Z-90, a-97, z-122, Space- 32, . -46, for , - 44
	try
	{
		var flag = true;
		
		var key =0 ,char;
		if( typeof evnt.charCode != 'undefined')
		{	
			key = evnt.keyCode;
			char = evnt.charCode;
		}
		else 
			char=evnt.keyCode;
		if( key!=0 || char==32 || char==46 || (char>=65 && char<=90) || (char>=97 && char<=122) )
			return true;
		else
			return false;
	}
	catch(e)
	{
		alert("Error Message -> "+e.message);
	}
}


function validateAlphaNumOnly(obj,evnt)
{ // Ascii Code 0 - 48 To 9 - 57,A-65, Z-90, a-97, z-122, Space- 32, for , - 44
	try
	{
		var flag = true;
		
		var key =0 ,char;
		if( typeof evnt.charCode != 'undefined')
		{	
			key = evnt.keyCode;
			char = evnt.charCode;
		}
		else 
			char=evnt.keyCode;
		if( key!=0 || char==44 || char==32 || char==46 || (char>=48 && char<=57) || (char>=65 && char<=90) || (char>=97 && char<=122) )
			return true;
		else
			return false;
	}
	catch(e)
	{
		alert("Error Message -> "+e.message);
	}
}


function changeFrameSize()
{	
	try{
	//alert("in menu hide");
		if(parent.document.getElementById("fs2")!=undefined){
				parent.document.getElementById("fs2").cols = "0,*";
				parent.document.getElementById("f7").contentDocument.getElementById("Image").src="/EPradarshakClient/hisglobal/images/arrsingle-right.png";			
		}
	}catch(e)
		{
			
		}
		  
}


// function for opening popup in case of masters
function openModal(src,  height){
	var windowHeight = $(window).height()*(height) ;					
	document.getElementById("iframeForModal").width="100%";
	document.getElementById("iframeForModal").height=windowHeight;
	document.getElementById("iframeForModal").src=src;
	$('#divForModal').modal('show');	
}

// function to validate one selection of primary key incase of master 
// return selectd primary key or zero 
function validateAndGetPrimaryKey(){
	var primarykey=0;
	
	var count=0;

	if(document.getElementsByName("pk").length>0){
		for(var i=0;i<document.getElementsByName("pk").length;i++){
			if(document.getElementsByName("pk")[i].checked){
				primarykey=document.getElementsByName("pk")[i].value;
				count++;
			}
		}
		if(count==0){
			alert("Please select a record !");
		 	return 0;
		}
		if(count>1){
		 	alert("Please select only one record for modification !");
		 	return 0;
		}
		
	}	
	else{
		alert("No data found for modification !");
		return 0;
	}
	
	return primarykey;
}


function is_numeric(val){
    return val && /^-?\d+(\.\d+)?$/.test(val + '');
}



function isIntegerVal(value) {
	//alert(value);
    var er = /^-?[0-9]+$/;    
    return er.test(value);
    
}

function replaceAll(str, find, replace) {
    return str.replace(new RegExp(find, 'g'), replace);
}


//function to check if variable m (argument) is of type  object . if return false then it means it is string type
 function checkJSON(m) {

	   if (typeof m == 'object') { 
	      try{ m = JSON.stringify(m); }
	      catch(err) { return false; } }

	   if (typeof m == 'string') {
	      try{ m = JSON.parse(m); }
	      catch (err) { return false; } }

	   if (typeof m != 'object') { return false; }
	   return true;

	}
 
 

 function callService(configJson){
	 //alert("service>>>>"+configJson["serviceName"]);
	 
	 var data={
			 hmode:"callService",
			 serviceName:configJson["serviceName"],	
			 isGlobal: $('#isGlobal').val()
	 }
	 if(configJson["inputData"]!=undefined){
		 var inputData=configJson["inputData"];
		 inputData["hospitalcode"]=$('#hospitalCode').val();
		 inputData["hospitalCode"]=$('#hospitalCode').val();
		 
		 if($('#healthFacilityCode').val()!="");
		 	inputData["facilityID"]=$('#healthFacilityCode').val();
		 
		 data.inputData=JSON.stringify(inputData);
		 //alert(JSON.stringify(data.inputData));
	 }
	 
	 if(configJson["primaryKeys"]!=undefined){
		 data.primaryKeys= configJson["primaryKeys"]		
	 }
	 if(configJson["initMode"]!=undefined){
		 data.initMode= configJson["initMode"]
	 }
	 if(configJson["fileUploadFlag"]!=undefined){
		 data.fileUploadFlag= configJson["fileUploadFlag"]
		 var filesPk=new Array();
		$('.fileUploadHidden').each(function(i, obj) {
		
		if($(obj).val()!=''){
			//alert($(obj).val())
			filesPk.push($(obj).val());
		}
		
	    
	});
	data.fileNames=filesPk;
	 }
	
	 
	 
	 
	 //alert($('#varSSOTicketGrantingTicket').val());
	 data.varSSOTicketGrantingTicket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	 data.tid=$('#tid').length>0?$('#tid').val():"";
	 var processName=$('#processName').val();
	 if($('#processName').length==0 || processName==undefined ||  processName==null || processName=='null'){
		 alert('process name field missing or undefined!' )
		 return;
	 }
	
	 data.processName=processName;
	 data.seatId=$('#seatId').length>0?$('#seatId').val():"";
	 data.hospitalCode=$('#hospitalCode').length>0?$('#hospitalCode').val():"";
	 //alert("tid in callService--" + $('#tid').val());
	 if(debug==true){
			console.log("inside callservice serviceName >>"+configJson["serviceName"] +" payload  " + JSON.stringify(data));
	 }
	
	 
	 //data=initSecurityParameterFromajaxjson(data);
	 //console.log(JSON.stringify(data))
	 
	 //data.serviceName="test123";
	var url= document.forms[0].action;
	
	// alert(url);
	if(url==undefined){
		alert("Form url not found")
		return;
	}
	if(configJson["serviceName"].indexOf("DMLService")>=0)
		showPreloader();
		
	 $.ajax({
		 	type: 'POST',
			url : url,
			data : data,
			dataType : "json",
			success : function(returnStr) {
				//alert(JSON.stringify(returnStr));
				
				hidePreloader();
				/*if(returnStr.indexOf("page-error")>=0){
					$('body').html(returnStr);
				}				
				else if(configJson["callBackFunctionName"]!=undefined)*/
				if(debug==true){
					console.log("Response received>>" +JSON.stringify(returnStr));
				}
				eval(configJson["callBackFunctionName"])(configJson, returnStr);
				
						
			},
			error: function (jqXHR, exception) {
				
				
				  console.log(jqXHR);
				
				  console.log(exception);
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        hidePreloader();
		        console.log(msg);
		        //alert("Some Problem Occured");
		    },
			fail : function() {
				hidePreloader();
				alert("error occured");
			}
		});
	
 }

 function getTodayDateAndTimeSMS() {
    const now = new Date();
    
    const day = now.getDate().toString().padStart(2, '0');
    const month = now.toLocaleString('default', { month: 'short' }).toLowerCase();
    const year = now.getFullYear();
    
    const hours = now.getHours().toString().padStart(2, '0');
    const minutes = now.getMinutes().toString().padStart(2, '0');
    
    const dateString = `${day}-${month}-${year}`;
    const timeString = `${hours}:${minutes}`;
    
    return `${dateString} # ${timeString}`;
}


function getTemplateMessageandSendSMS(configJson){
	callService(configJson);
} 

function callbackSendSMSAJAX(configJson,dataJson){
	
	//	console.log("SMS ConfigJson>>>> ", configJson);
	//console.log("SMS dataJson>>>> ",dataJson);
	//configJson["message"]=dataJson.data[0].message;
	jsonObject={
      	              "data":[],
      	              "mobileNumbers":[],
      	              "message":"", 			// Add template id and message fromm Table
      	              "templateId":"",
      	      } 
    jsonObject.data= configJson.inputData.data;
    jsonObject.mobileNumbers= configJson.inputData.mobileNumbers;
    jsonObject.message= dataJson.data[0].message;
    jsonObject.templateId = configJson.inputData.templateId;
    
	 var inputData = JSON.stringify(jsonObject);
   var configJsonNew = {
		//serviceName : "MobileVerificationOTP",
		serviceName:"SENDSMS",
		inputData:inputData,
	}
	sendAjaxSMS(configJsonNew);
}

function sendAjaxSMS(configJson){
		 var data={
			 hmode:"sendSMS",
			 serviceName:configJson["serviceName"],	
			 isGlobal: $('#isGlobal').val()
	 };
	 
	 console.log("configjson in sendAJAX SMS>>> ", configJson["inputData"]);
	 if(configJson["inputData"]!=undefined){
		 var inputData = configJson["inputData"] // JSON.stringify();
		  data.inputData=inputData;
	 }

	 var fhttfCode = getHexaCode(getJsonParameters(data));
	 data.fhttf=fhttfCode;
	//   data.varSSOTicketGrantingTicket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	
	var url= document.forms[0].action;
	console.log("url>>", url);

    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        success: function(response) {
            console.log("Response: " + response);
             // Show success message
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
            //alert("Failed to send OTP");
        }
    });
}

function callbackSendSMSAJAXforBulkSMS(configJson,dataJson){
	
	var FfMode = configJson.FfMode;
	jsonObject={
      	              "data":[],
      	              "message":"", 			// Add template id and message fromm Table
      	              "templateId":"",
      	      } 
    jsonObject.data= configJson.inputData;
    //jsonObject.mobileNumbers= configJson.inputData.mobileNumbers;
    jsonObject.message= dataJson.data[0].message;
    jsonObject.templateId = configJson.inputData.templateId;
    
   var inputData = JSON.stringify(jsonObject);
   var configJsonNew = {
		//serviceName : "MobileVerificationOTP",
		serviceName:"SENDSMS",
		inputData:inputData,
		hmode:FfMode,
	}
//	console.log(configJsonNew);

	sendAjaxSMSNew(configJsonNew);
}

function sendAjaxSMSNew(configJson){
		 var data={
			 hmode:configJson["hmode"],
			 serviceName:configJson["serviceName"],	
			 isGlobal: $('#isGlobal').val()
	 };
	 
	 console.log("configjson in sendAJAX SMS NEw>>> ", configJson["inputData"]);
	 if(configJson["inputData"]!=undefined){
		 var inputData = configJson["inputData"] // JSON.stringify();
		  data.inputData=inputData;
	 }

	 var fhttfCode = getHexaCode(getJsonParameters(data));
	 data.fhttf=fhttfCode;
	//   data.varSSOTicketGrantingTicket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	
	var url= document.forms[0].action;
	console.log("url>>", url);

    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        success: function(response) {
            console.log("Response: " + response);
             // Show success message
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
            //alert("Failed to send OTP");
        }
    });
}


function sendAjaxEmail(configJson){
		 var data={
			 hmode:"sendEmail",
			 serviceName:configJson["serviceName"],	
			 isGlobal: $('#isGlobal').val()
	 };
	 
	 console.log("configjson in sendAJAX Email>>> ", configJson["inputData"]);
	 if(configJson["inputData"]!=undefined){
		 var inputData = configJson["inputData"] // JSON.stringify();
		  data.inputData=inputData;
	 }

	 var fhttfCode = getHexaCode(getJsonParameters(data));
	 data.fhttf=fhttfCode;
	//   data.varSSOTicketGrantingTicket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	
	var url= document.forms[0].action;
	console.log("url>>", url);

    $.ajax({
        url: url,
        type: 'POST',
        data: data,
        success: function(response) {
            console.log("Response: " + response);
             // Show success message
        },
        error: function(xhr, status, error) {
            console.error("Error: " + error);
            //alert("Failed to send OTP");
        }
    });
}



 function submitFormMaster(masterKey,initMode)
 {	
	 showPreloader();
	 //alert("masterkey");
	 $('#masterKey').val(masterKey);	 
	 $('#initMode').val(initMode);	 
	 $('#hmode').val("CallMasterPage");
	 //alert($('#varSSOTicketGrantingTicket').val());
	 document.forms[0].submit();
 }
 
 

 var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9\+\/\=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/\r\n/g,"\n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}

 function encrypt(val){
 	var encodedString  = Base64.encode(val);
 	return encodedString ;
 }

 function decrypt(encodedString){
 	var decodedString = Base64.decode(encodedString);
 	return decodedString;
 }
 
 /*var dialogConfigJson={callOnOK:"function name here","parameterJson":{}}*/
 function showMsg(txt,dialogConfigJson){
	 flagDialog=false;
	 
	 var msghtml="<i class='fa-solid fa-triangle-exclamation text-warning' style='font-size:290%'></i><br/>";
	 
	    if(txt.indexOf("SUCCESS:")>=0){
	    	msghtml="<i class='fa-solid fa-circle-check text-success' style='font-size:290%'></i><br/>";
	    	txt=txt.replace("SUCCESS:","");
	    	msghtml="<p style='text-align:center !important;'>"+msghtml+"<h6 class='text-success' style='text-align:center !important;' data-lang='"+txt+ "'>"+txt+ "</h6></p>";
	    }
	    else if(txt.indexOf("ERROR:")>=0){
	    	msghtml="<i class='fa-solid fa-circle-xmark text-danger' style='font-size:290%'></i><br/>";	    
	    	txt=txt.replace("ERROR:","");
	    	msghtml="<p style='text-align:center !important;'>"+msghtml+"<h6 class='text-danger' style='text-align:center !important;' data-lang='"+txt+ "'>"+txt+ "</h6></p>";
	    }
	    else{
	    	msghtml="<p style='text-align:center !important;'>"+msghtml+"<h6 class='text-dark' style='text-align:center !important;' data-lang='"+txt+ "'>"+txt+ "</h6></p>";
	    }
	    
	    
	 $("#dialog-message").html(msghtml);
	 $( "#dialog-message" ).dialog({
	        modal: true,
	        buttons: {
	          Ok: function() {
	            $( this ).dialog( "close" );
	            if (dialogConfigJson!=null && dialogConfigJson!=undefined && dialogConfigJson["callOnOK"]!=undefined){
	        	   if(dialogConfigJson["parameterJson"]!=undefined)
	        		   eval(dialogConfigJson["callOnOK"])(dialogConfigJson["parameterJson"]);
	        	   else{
	        		   eval(dialogConfigJson["callOnOK"])();
	        		   //alert("after eval");
	        	   }
	           }
	          }
	        },
	    	classes: {"ui-dialog": "alerteUpkaran",  "ui-dialog-titlebar": "alerteUpkaranTitlebar"},
	        
	      });
	    $('.ui-dialog-titlebar-close').hide();
	    $('.ui-dialog-buttonset button').addClass('okBtn');
	    //$('.alerteUpkaran').css('z-index: 9999');
	    
	   // var ht= $(window).height()*0.2;
	     
	    //$('.alerteUpkaran').css("top",ht+'px');
	    
	    //$('.alerteUpkaran').css("top")
	    
	    /* var isErrorFound=false;
     var msghtml="";
    
     

     const Toast = Swal.mixin();
	
	
     if(msg.indexOf("SUCCESS:")>=0){
    	 msg=msg.replace("SUCCESS:","");
    	 
           Toast.fire({
    		 type: 'success',
    	   	  text: msg,
    	   	  showConfirmButton: true, 
    	   	  confirmButtonText: 'OK'
    	      });             
      }
      else if(msg.indexOf("ERROR:")>=0){
    	  msg=msg.replace("ERROR:","");
    	  Toast.fire({
     		 type: 'error',
     	   	  text: msg,
     	   	  showConfirmButton: true, 
     	   	  confirmButtonText: 'OK'
     	      });    	  
      }
      else{
          	 Toast.fire({
      		  type: 'error',
      	   	  text: msg,
      	   	  showConfirmButton: true, 
      	   	  confirmButtonText: 'OK'
      	      });       	    
      }*/
      
}
 
 
 
 
 function commonResetFields(initInputJson){
	 //alert(initInputJson);
	 	//alert("inside commonResetFields")
		//console.log(initInputJson);
	 	var tid=$('#tid').val();
		if(initInputJson!=null){
			var name="";
			var i=0;
			$.each(initInputJson, function(k,inputobj){
				if(name==""){
					name=inputobj["name"];
					i=0;
				}
				else if(name==inputobj["name"]){
					//for more than one object with same name 
					i++;
				}
				else if(name!=inputobj["name"]){
					name=inputobj["name"];
					i=0;
				}
				var inputType = $($('[name='+name+']')[i]).prop("tagName").toLowerCase() != 'input' ? $($('[name='+name+']')[i]).prop("tagName").toLowerCase() : $($('[name='+name+']')[i]).prop("type").toLowerCase();
				
				if(inputType== "radio"){
					//alert(name);
					$($('[name='+name+']')).each(function(){
						if(this.value==inputobj["value"])
							this.checked=true;
					});
				}				
				else{
					if($($('[name='+name+']')[i]).is('select') && $($('[name='+name+']')[i]).hasClass('select2')){
						$($('[name='+name+']')[i]).select2({width: '100%'});
					}
				}
			});
		}
		resetWizzardView($('#enableWizzardView').val());
		//alert("tid in common reset--" + tid);
		$('#tid').val(tid);
	}
 
 function processSerializeArray(divId){
		var inputjson=$('#'+divId +' :input').serializeArray();
		var finalJson={}; 
		$.each(inputjson,function(k,vobj){
			var key=vobj["name"];
			var value=vobj["value"];
			
			if(finalJson[key]==undefined){
			
				finalJson[key]=value;
			}
			else{
				
				var arrVal=new Array();
				//alert(arrVal.length);
				
				 if(Array.isArray(finalJson[key])){
					
					 arrVal=finalJson[key];
				 }
				 if(arrVal.length==0){
					 arrVal.push(finalJson[key]);
					
				}
				 
				
				 arrVal.push(value);
				 finalJson[key]=arrVal;
			}
		});
		//alert(JSON.stringify(finalJson));
		return finalJson
}
 
 
function initValidation(containerDivId){
	$('#'+containerDivId).find("[data-validation]").each(function(){
		//var arrValidation=$(this).attr("data-validation").split(",");
		if($(this).attr("data-validation").indexOf("mandatory")>=0){
			if($(this).closest('.form-group').find('.star').length==0)
				$(this).closest('.form-group').find('.col-form-label').after("<span  class='star text-danger'> *</span>");
		}
		
		
		if($(this).hasClass('select2')){
			$(this).change(function(){
				if(this.value !=""){
					showValidationMsg(this, "",true);
				}
						 
			});
		}
		else{
			$(this).blur(function(){	
				return validateFormData(this);		 
			});
		}
		//alert(arrValidation);
	});
} 


function removeValidation(containerDivId){
		$('#'+containerDivId).find("[data-validation]").each(function(){
		$(this).removeAttr("data-validation").removeClass('is-invalid');
		$(this).closest('.form-group').find('.star').remove('.star');
		$(this).closest('.form-group').find('.invalid-feedback').html('');
		$(this).unbind( "blur" );		
	});
} 
function showValidationMsg(obj,msg, flag){
	 if(flag==false){
		  //alert($(obj).attr('id') + "===" + msg )
		  $(obj).addClass('is-invalid');
		  $(obj).closest('.form-group').addClass('has-danger');			  
		  $(obj).closest('.form-group').find('.invalid-feedback').html(msg);
		  if($(obj).hasClass('select2')){
			  $(obj).closest('.form-group').find('.select2-selection').css("border", "solid #dc3545 1px");
		  }		  
		  return false;
	  }
	  else{
		  $(obj).removeClass('is-invalid');
		  $(obj).closest('.form-group').removeClass('has-danger');			  
		  $(obj).closest('.form-group').find('.invalid-feedback').html("");
		  if($(obj).hasClass('select2')){
			  $(obj).closest('.form-group').find('.select2-selection').css("border", "solid #495057 1px");
		  }
	  }
}
function validateFormData(obj){
	var flag=false;
	flag=checkHTMLTags(obj);
	if(flag==false){
		  showValidationMsg(obj, "Not a valid input !",flag);		  
		  return false;
	}
	else{
		  showValidationMsg(obj, "",flag);
	}
	var validation=$(obj).attr("data-validation");
	if(validation==undefined)
		return;
	if(validation.indexOf("mandatory")>=0){
		  flag=ValidateForMandatory(obj);
		 
		  if(flag==false){
			  showValidationMsg(obj, "This field is required !",flag);		  
			  return false;
		  }
		  else{
			  showValidationMsg(obj, "",flag);		
		  }
	 }
	
	 var arrValidation=validation.split(","); // splitting for multiple validations
	 //alert(arrValidation);
	 for(var i=0;i<arrValidation.length;i++){
		 if(arrValidation[i]!="mandatory" &&   arrValidation[i]!="checkDuplicate"){
			 var msg=validateByRegExprestion(obj.value,arrValidation[i]);
			 
			 if(msg!=""){
				 showValidationMsg(obj, msg,false);				 
				 return false;
			 }
			 else{
				 showValidationMsg(obj, "",true);
			 }
		 }
	 }
	/*if(finalReturnflag){
 		$('#'+containerDivId).find("[data-minlength]").each(function(){
 	 		var flag=validateMinlength(this)
 	 		if(flag==false){
 	 			finalReturnflag=false;
 	 		}
 	 	});
 	}
 	if(finalReturnflag){
 		$('#'+containerDivId).find("[data-range]").each(function(){
 	 		var flag=validateRange(this)
 	 		if(flag==false){
 	 			finalReturnflag=false;
 	 		}
 	 	});
 	}*/
	return true;
} 

//function for validating minimum length textbox/textarea
function validateMinlength(obj){
	var minlength =$(obj).attr("data-minlength");
	 if(minlength!=undefined){
		 minlength=parseInt(minlength);
		 if(obj.value!="" && obj.value.length<minlength){
			 showValidationMsg(obj, "Minimum length entered should be of :<b>"+ minlength +"</b>",false);				 
			 return false;
		 }
		 else{
			 showValidationMsg(obj, "",true);
		 }
	 }
	 return true;
}

//function for validating range of value . will work on numeric type only. eg attribute-- data-range="1-1000"
function validateRange(obj){
	var range =$(obj).attr("data-range");
	var val =obj.value.trim();
	//alert("inside validateRange");
	 if(val!="" && range!=undefined){
		 var rangeStart=parseFloat(range.split("-")[0]);
		 var rangeEnd=parseFloat(range.split("-")[1]);
		 
		 val=parseFloat(val);
		 //alert(obj.id +"==="+ val);
		 //alert(isNaN(val));
		 if (isNaN(val)) {
			showValidationMsg(obj, "Data entered should be numeric only !",false);
		    return false;
		 }
		 if(val<rangeStart || val>rangeEnd){
			 showValidationMsg(obj, "Value should be between  :<b>"+ rangeStart +" and "+rangeEnd +"</b>",false);
			 return false;
		 }
		 else{
			 showValidationMsg(obj, "",true);
		 }		 
	 }
	 return true;
}


//function to validate single mandatory field on form-- can be used on blur of field 
function ValidateForMandatory(obj){
		var flag=true;
		//alert(obj.id + "@@@@@" + obj.value);
		if ($(obj).is("input")) {
	    	if($(obj).attr("type")=="radio" || $(obj).attr("type")=="checkbox"){
	    		var radioName=$(obj).attr("name");
	    		var checked=false;
	    		//alert(radioName);
	    		for(var i=0;i<document.getElementsByName(radioName).length;i++){			    			
	    			if(document.getElementsByName(radioName)[i].checked){
	    				checked=true;
	    				break;
	    			}
	    		}
	    		//alert(checked);
	    		if(checked==false)
	    			flag=false;			    		
	    	}
	    	else{			    		
	    		if($(obj).val().trim()==""){			    			
		    		flag=false;			    		
		    	} 	
	    	}
	    } else if ($(obj).is("select")) {
	    	//alert(obj.id +" @@@@ " + $("#"+obj.id + " option:selected").length);
	    	if( $("#"+obj.id + " option:selected").length==0){
	    	//if($(obj).val()==""|| $(obj).val()=="-1"){
	    		flag=false;			    		
	    	}
	    	else{
	    		if($("#"+obj.id + " option:selected").length==1 && $("#"+obj.id + " option:selected").val()==""){
	    			return false;
	    		}
	    	}
	    	
	    } else if ($(obj).is("textarea")) {
	    	//alert("textarea");
	    	if($(obj).val().trim()==""){
	    		flag=false;			    		
	    	}
	    }
		
	return flag;	
}


function checkHTMLTags(obj){
	if ($(obj).is('input:text') ||$(obj).is('textarea')){
		var val=$(obj).val().trim();
		regExp =/<\/?[a-z][^>]*>/ig;
		
		if(regExp.test(val)){
			return false; 
		}
		
		if(val.indexOf('$')>=0){
			return false;
		}
		if(val.indexOf('?')>=0){
			return false;
		}
		if(val.indexOf('/')>=0){
			return false;
		}
		return true
		
	}else{
		 return true;
	}
}

function validateByRegExprestion(val,validationType){
	
	 var regExp=null;
	 var msg="";
	 if(val!=undefined && val.trim()==""  ){
		 return msg;
	 }
	// console.log("validationType===" + validationType);
	 switch(validationType)
		{
		case "alphabetOnly":
			regExp = /[^a-zA-Z_ ]/ ;
			if(regExp.test(val)==true)
				 return "Data should be alphabets only!";
			break;
		case "numeric":
			regExp = /[^0-9.-]/ ;
			if(regExp.test(val)==true)
				 return "Data should be numeric only!";
			break;
		case "positiveNumeric":
			regExp = /[^0-9.]/ ;
			if(regExp.test(val)==true)
				return "Data should be positive number only!";
			break;
		case "positiveNumberWithSpaceAndComma":
			regExp = /[^0-9, ]/ ;
			//alert(regExp.test(val));
			if(regExp.test(val)==true)
				return "Data should be positive number only!";
			break;
				
		case "alphaNumeric":
			regExp = /[^a-zA-Z0-9 _-]/ ;
			if(regExp.test(val)==true)
				return "Data should be alphabets and numbers  only!";
			break;
			
		case "alphaNumericWithSpace":
			regExp = /[^a-zA-Z0-9 _.-]/ ;
			if(regExp.test(val)==true)
				return "Data should be alphabets and numbers  only!";
			break;
		case "email":
			regExp =/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			if(regExp.test(val)==false)
				return "Valid email Id required!";
			break;
		case "govemail":
			regExp =/^[a-zA-Z0-9._-]+@(gov\.in|nic\.in|cghs\.nic\.in|rmlh\.nic\.in|delhi\.gov\.in|ofb\.gov\.in)$/;
			if(regExp.test(val)==false)
				return "Valid email Id required!";
			break;	
		case "telephone":
			regExp =/^[(]{0,1}[0-9]{3}[)]{0,1}[-\s\.]{0,1}[0-9]{3}[-\s\.]{0,1}[0-9]{4}$/;
			if(regExp.test(val)==false)
				return "Valid phone/mobile no. required!";
			break;
		case "address":
			regExp = /^[a-zA-Z0-9\s,.'-]{3,}$/ ;
			if(regExp.test(val)==false)
				return "Invalid character found !";
			break;
		case "currency":
			regExp = /^(?:0|[1-9]\d*)(?:\.(?!.*000)\d+)?$/;
			if(regExp.test(val)==false)
				return "Invalid Currency!";
			break;
		case "pan":
			regExp = /[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}/g;
			if(regExp.test(val)==false)
				return "Invalid PAN detail!";
			break;
		case "gstin":
			regExp = /^([0]{1}[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-7]{1})([a-zA-Z]{5}[0-9]{4}[a-zA-Z]{1}[1-9a-zA-Z]{1}[zZ]{1}[0-9a-zA-Z]{1})+$/g;
			if(regExp.test(val)==false)
				return "Invalid GSTIN detail!";
			break;
		case "mobile":
			regExp = /^[0]?[6-9]\d{9}$/;
			if(regExp.test(val)==false)
				return "Please enter a valid mobile number !";
			break;
		case "ifsc":
			regExp = /^[A-Z]{4}0[A-Z0-9]{6}$/;
			if(regExp.test(val)==false)
				return "Invalid IFCS detail!";
			break;
		case "bankAccountNo":
			regExp = /[0-9]{9,18}/ ;
			if(regExp.test(val)==true)
				return "not a valid bank account no.!";
			break;	
		case "integer":
			regExp = /[^0-9]/  ;
			if(regExp.test(val)==true)
				 return "Data should be positive value without period character (.)!";
			break;	
		case "tax":
			regExp = /(^100([.]0{1,2})?)$|(^\d{1,2}([.]\d{1,2})?)$/i ;
			if(regExp.test(val)==false)
				 return "Tax should be less than 100 !";
			break;
		case "aadhaar":
			//console.log('val===='+val);
			regExp = /^[2-9]{1}[0-9]{11}$/;
			if(regExp.test(val)==false)
				 return "Please enter a valid Aadhaar no.!";
			break;
		case "abhaAddress":{
			regExp = /[^a-zA-Z0-9_.]/ ;
			if(regExp.test(val)==true)
				return "ABHA addresses should consist of alphabets, numbers, dots, and underscores only, without any spaces.";
			
			
			if (val.startsWith('.') || val.endsWith('.') ||      val.startsWith('_') || val.endsWith('_')) {
			    return "Dot and underscore characters are permitted within the string but are not allowed at the beginning or end.";
			}
			
			var dotCount = (val.match(/\./g) || []).length;
			var underScoreCount = (val.match(/\_/g) || []).length;
			if (dotCount>1 ||underScoreCount>1 ) {
			    return "number of dot and underscore characters must not exceed one";
			}
			break;
		}
		case "beneficiaryId" :{
			regExp = /[^0-9]/ ;
			if(regExp.test(val)==true)
				return "Beneficiary ID should be positive number only!";
			
			if(val.length<1){
				return "Please Enter Valid Beneficiary Id!";
			}
			break;
		}
		case "dot":
			//console.log('val===='+val);
			
			if(val.includes("."))
				 return "";
			break;
	 }
	 return "";
}

function ValidateForAll(containerDivId){
	
	var finalReturnflag=true;
	
	if($('.file-group').length>0){
 		$('.file-group').find('input[type=text]').each(function(){
 			if(this.value!=""){
	 			finalReturnflag=false;
	 			showValidationMsg(this, "File is not uploaded !",false);	
	 		}else{
	 		  showValidationMsg(this, "",true);
	 		}
	 	});
 		if(finalReturnflag==false){
	 		showMsg("Selected File is not uploaded. Please click on upload button near textbox!");
	 		return false;
	 	}
	 	
 	}
	
	
	$('.accPanel').removeClass("hideData");
	//alert($('#'+containerDivId).find("[data-validation]").length);
 	$('#'+containerDivId).find("[data-validation]").each(function(){
 		
 		var flag=validateFormData(this);
 		if(flag==false){
 			finalReturnflag=false;
 		}
 	});
 	if(finalReturnflag==false){
 		
 		showAlertMsg("Kindly enter mandatory and valid data!", "danger");
 		return false;
 	}
 	
 	if(finalReturnflag){
 		$('#'+containerDivId).find("[data-minlength]").each(function(){
 	 		var flag=validateMinlength(this)
 	 		if(flag==false){
 	 			finalReturnflag=false;
 	 		}
 	 	});
 	}
 	if(finalReturnflag==false){
 		showAlertMsg("Kindly enter minimum length in field!", "danger","alertMsgCreateAbha");
 		
 		return false;
 	}
 	if(finalReturnflag){
 		$('#'+containerDivId).find("[data-range]").each(function(){
 	 		var flag=validateRange(this)
 	 		if(flag==false){
 	 			finalReturnflag=false;
 	 		}
 	 	});
 	}
 	if(finalReturnflag==false){
 		showAlertMsg("Kindly enter valid range in field!", "danger","alertMsgCreateAbha");
 		
 		return false;
 	}
 	
 	return finalReturnflag;	
 }

function ValidateForAllVisible(containerDivId){
	
	var finalReturnflag=true;
	if($('.file-group').length>0){
 		$('.file-group').find('input[type=text]').each(function(){
 			if(this.value!=""){
	 			finalReturnflag=false;
	 			showValidationMsg(this, "File is not uploaded !",false);	
	 		}else{
	 		  showValidationMsg(this, "",true);
	 		}
	 	});
 		if(finalReturnflag==false){ 			
	 		showMsg("Selected File is not uploaded. Please click on upload button near textbox!");
	 		return false;
	 	}
	 	
 	}

	
	
	$('.accPanel').removeClass("hideData");
 	$('#'+containerDivId).find("[data-validation]").each(function(){
 		if($(this).is(":visible")){
	 		var flag=validateFormData(this);
	 		if(flag==false){
	 			finalReturnflag=false;
	 		}
 		}
 	});
 	if(finalReturnflag==false){
 		showAlertMsg("Kindly enter mandatory and valid data!", "danger","alertMsgCreateAbha");
 		
 		return false;
 	}

 	
 	if(finalReturnflag){
 		$('#'+containerDivId).find("[data-minlength]").each(function(){
 			if($(this).is(":visible")){
	 			$(this).attr("data-minlength");
	 	 		var flag=validateMinlength(this)
	 	 		if(flag==false){
	 	 			finalReturnflag=false;
	 	 		}
 			}
 	 	});
 	}
 	if(finalReturnflag==false){
 		showAlertMsg("Kindly enter minimum length in field!", "danger","alertMsgCreateAbha");
 		
 		return false;
 	}
 	if(finalReturnflag){
 		$('#'+containerDivId).find("[data-range]").each(function(){
 			if($(this).is(":visible")){
	 			var flag=validateRange(this)
	 	 		if(flag==false){
	 	 			finalReturnflag=false;
	 	 		}
 			}
 	 	});
 	}
 	if(finalReturnflag==false){
 		showAlertMsg("Kindly enter valid range in field!", "danger","alertMsgCreateAbha");
 		
 		return false;
 	}
 	
 	return finalReturnflag;	
 }


function commonPopulateForm(configJson,dataJson){
	try{
		var field;
		//alert(JSON.stringify(dataJson));
		if(dataJson!=null && dataJson!=undefined){
			$.each(dataJson["data"], function(indx, rowJson){
				
			$.each(rowJson,function(key,value){
				
				//alert("key>>"+key + " Value>>"+value);
				field=value;
				if(value.trim()!=""){
					var objField=null;
					if($("[name="+key+"]").length>0){
						
						objField=$("[name="+key+"]");
						}
					else if($("#"+key).length>0){
						
						objField=$("#"+key);
					}
						
					
					var val=value;
					var inputType = $(objField).prop("tagName").toLowerCase() != 'input' ? $(objField).prop("tagName").toLowerCase() : $(objField).prop("type").toLowerCase();
					
					
					/*if(inputType=='date'){
						
					}*/
					
					
					if($(objField).is( "div" ) || $(objField).is( "label" ) || $(objField).is( "span" )){
						$(objField).html(val);
					}
					else if (inputType=="radio" || inputType=="checkbox"){
						//alert("value---"+ value + " inputType=="+inputType + "==="+ $(objField).attr("id"));
						//alert(inputType);
						$("[name='"+key+"']").each(function(){
							//alert(this.value+"=="+val)
							if(this.value==val){
								$(this).prop("checked", true);
								if($(this).hasClass('switchchk'))
									this.switchButton('on');
							}
								
						});
					}
					else if (inputType=="textarea" ||inputType=="text" )
						$(objField).val(val);
					else{
						$(objField).val(val);	
						if($(objField).is('select') && $(objField).hasClass('select2')){
							$(objField).select2({width: '100%'});
							$(objField).trigger('change.select2');
						}
					}
				}else{
					var objField=null;
					if($("[name="+key+"]").length>0)
						objField=$("[name="+key+"]");
					else if($("#"+key).length>0)
						objField=$("#"+key);
					
					
					var val=value;
					var inputType = $(objField).prop("tagName").toLowerCase() != 'input' ? $(objField).prop("tagName").toLowerCase() : $(objField).prop("type").toLowerCase();
					console.log(inputType)
					console.log(val)
					if (inputType=="textarea" ||inputType=="text" )
						$(objField).val(val);
					
				}
				
			});
			
			 });
			
			var functionAfterPopulating=configJson["functionAfterPopulating"];
			
			if(functionAfterPopulating!=undefined || functionAfterPopulating!='undefined' ||functionAfterPopulating!=''){
				//alert(functionAfterPopulating);
				//();
				
				window[functionAfterPopulating]();
			}
			
		}
		
	}catch(err){
		console.log("Problem in populateFormData===" +  err.message+field)
	}
}
function commonPopulateFormField(dataJson,fieldName){
	try{
		if(dataJson!=null && dataJson!=undefined){
			$.each(dataJson["dataHeading"],function(key,value){
				//alert("frmId>>"+value);
				
				if(fieldName==value){
					if($("[name="+value+"]").length>0){
						var val=dataJson["dataValue"][0][key];
						//alert("field Name==" + value + " value==" + val);
						
						var objField=null;
						if($("[name="+value+"]").length>0)
							objField=$("[name="+value+"]");
						else if($("#"+value).length>0)
							objField=$("#"+value);
						
						
						
						var inputType = $(objField).prop("tagName").toLowerCase() != 'input' ? $(objField).prop("tagName").toLowerCase() : $(objField).prop("type").toLowerCase();
							//$("[name='"+value+"']").attr('type');
						
						if(inputType=="radio" || inputType=="checkbox"){
							$("[name="+value+"]").each(function(){
								if(this.value==val)
									$(this).prop("checked", true);
							});
						}
						else{
							//console.log($(objField).html());
							//alert(val);
							
							$(objField).val(val);		
							//alert("inputType== " + inputType + " name==" + $(objField).attr("name")+ "=="+ $(objField).val());
							if($(objField).is('select') && $(objField).hasClass('select2')){
								$(objField).select2({width: '100%'});
								$(objField).trigger('change.select2');
							}
							
						}						
					}
				}
			});
			
			
		}
		
	}catch(err){
		console.log("Problem in populateFormData===" +  err.message)
	}
}


function createSummmerNoteEditor(textareaName,textareaValue,summernoteDivId, height,isMandatory){
	var mandatoy="";
	//alert(isMandatory);
	//alert(summernoteDivId);
	
	if(height==undefined)
		height=150;
	if(isMandatory)
		mandatoy='data-validation="mandatory"';
		
	$('#'+summernoteDivId).html('<textarea class="form-control form-control-sm summernote" style="display:none;"  id="'+textareaName+'" name="'+textareaName+'" '+mandatoy+' >'+textareaValue+'</textarea>');
	//alert(textareaValue);
	$("#"+textareaName).summernote({		
		height: height	
	});	
}
function commonPopulateCombo(configJson, dataJson){
    //alert(JSON.stringify(dataJson));
            var comboId=configJson["comboId"];
            
            if(comboId==undefined){
                  alert("please specify comboId in config json ")
            }
            var objdefaultOption= configJson["defaultOption"];
            var objother= configJson["otherOption"];
            var isHashDefaultOptionFound=false;
            var isDefaultOptionFound=false;
            var isOtherOption=false;
            var filterhtml="";
            var triggerChange=configJson["triggerChange"];
            var setValue=configJson["setValue"];
            var dropdownModal=configJson["dropdownModal"];
           
            $('#'+ comboId).html("");
            if(dataJson!=undefined && dataJson["data"]!=undefined){
            	//alert(dataJson["data"].length);
	            if(dataJson["data"].length == 1){
	            	 var i=1;
	            	 var data=dataJson["data"][0];
	            	 var optionValue=data["optionValue"];
	            	 var optionText=data["optionText"];            	 
	            	
	            	filterhtml="<option value='"+optionValue+"' selected>"+optionText+"</option>";
	            	triggerChange="Yes";
	            	isHashDefaultOptionFound=true;
	            	
	            }
	            else{
	            	
	            	$.each(dataJson["data"],function(indx,objdata){
	            		var selected="";
	            		var optionValue=objdata["optionValue"];
		            	var optionText=objdata["optionText"]; 
		            	//alert(optionValue +"====" +optionText );
		            	if(objdata["isDefault"]!=undefined && objdata["isDefault"]=="1"){
		            		selected="selected='selected'";
		            		isHashDefaultOptionFound=true;
		            	}
		            	
		            	else if(objdefaultOption!=undefined && optionValue==objdefaultOption["optionValue"]){ 
		            		 //  checking for default option available in data given by query
                            isDefaultOptionFound=true;
	                    }
		            	filterhtml+="<option value='"+optionValue+"' "+selected+">"+optionText+"</option>";
		            	
		            	
		            	
	            	});
	            }
	            //alert(filterhtml);
	            $('#'+ comboId).html(filterhtml);
            	
           
          }
        if(isHashDefaultOptionFound==false){
                if(isDefaultOptionFound==true){
                        $('#'+ comboId).val(objdefaultOption["optionValue"]);
                }
                else if(objdefaultOption!=undefined && $('#'+ comboId).attr("multiple")==undefined){
                	
                        $('#'+ comboId).prepend("<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>");
                }
        }
            
        if(objother!=undefined){
                $('#'+ comboId).append("<option  value='"+objother["optionValue"]+"'>"+objother["optionText"]+"</option>");
        }
    
   // alert("comboId===" + comboId)
    if( $('#'+ comboId).hasClass("select2"))
    	$('#'+ comboId).select2({"width":"100%"});
    	
    if($('#'+ comboId).hasClass("select2") && dropdownModal!=undefined)
    	$('#'+ comboId).select2({"width":"100%",dropdownParent: $("#"+dropdownModal)});
    	
    
    //alert(comboId + " ==== triggerChange===" + triggerChange);
    if(triggerChange!=undefined){
    	//alert(triggerChange);
    	if(triggerChange=="Yes")
    		$('#'+ comboId).trigger('change');
    }
    if(setValue!=undefined){
		//alert('set Val >>>'+setValue);
		//alert(comboId + " ==== triggerChange===" + triggerChange);
    if(triggerChange!=undefined){
    	//alert(triggerChange);
    	if(triggerChange=="Yes")
    		$('#'+ comboId).val(setValue).trigger('change');
    }
    else{
		$('#'+ comboId).val(setValue).trigger('change.select2');
	}
		
	}
   
    
}

/*function commonPopulateCombo(configJson, datastr){
    //alert(datastr);
    if(datastr!=""){
            var dataJson=JSON.parse(datastr);
            var comboId=configJson["comboId"];
            
            if(comboId==undefined){
                    alert("please specify comboId in config json ")
            }
            var objdefaultOption= configJson["defaultOption"];
            var objother= configJson["otherOption"];
            var isHashDefaultOptionFound=false;
            var isDefaultOptionFound=false;
            var isOtherOption=false;
            var filterhtml="";
            var triggerChange=configJson["triggerChange"];
            $.each(dataJson["dataValue"],function(k,vobj){
                    var selected="";
                    var val=vobj[0];
                    //alert("val>>"+val);
                    //  checking for default option available in query
                    if(val.indexOf('#DEFAULT')>=0)
                    {
                            val=val.split("#")[0];
                            selected="selected";
                            isHashDefaultOptionFound=true;
                    }                        
                    else if(objdefaultOption!=undefined && val==objdefaultOption["optionValue"]){                        //  checking for default option available in data given by query
                            isDefaultOptionFound=true;
                    }
                    filterhtml+="<option value='"+val+"' "+selected+">"+vobj[1]+"</option>";
                    
                    if(objother!=undefined){
                            filterhtml+="<option value='"+vobj[0]+"' "+selected+">"+vobj[1]+"</option>";
                    }
                    
            });
            //alert(filterhtml)
            $('#'+ comboId).html(filterhtml);
            if(isHashDefaultOptionFound==false){
                    if(isDefaultOptionFound==true){
                            $('#'+ comboId).val(objdefaultOption["optionValue"]);
                    }
                    else if(objdefaultOption!=undefined && $('#'+ comboId).attr("multiple")==undefined){
                    	
                            $('#'+ comboId).prepend("<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>");
                    }
            }
            
            if(objother!=undefined){
                    $('#'+ comboId).append("<option  value='"+objother["optionValue"]+"'>"+objother["optionText"]+"</option>");
            }
    }
   // alert("comboId===" + comboId)
    if( $('#'+ comboId).hasClass("select2"))
    	$('#'+ comboId).select2({"width":"100%"});
    
    if(triggerChange!=undefined){
    	//alert(triggerChange);
    	if(triggerChange=="Yes")
    	$('#'+ comboId).trigger('change');
    }
    
}*/

function commonDualListPopulate(configJsonDualList){
	
	
	var comboId=configJsonDualList["comboId"];
	var configJson={
			serviceName:configJsonDualList["serviceNameLeftList"],
			comboId:comboId,
			callBackFunctionName:"populateLeftList",
			primaryKeys:configJsonDualList["primaryKeysLeftList"],
			configJsonDualList:configJsonDualList			
		}
	//console.log(configJson);
	callService(configJson);
	
	
}



function populateLeftList(configJson, dataJson){
	//var dataJson=JSON.parse(dataStr);
	//alert(JSON.stringify(dataJson));
	var comboId=configJson["comboId"];
	/*$("#"+comboId).empty();
	$("#"+comboId).append("<option selected value=''></option>")
	$.each(dataJson["data"],function(k,vobj){
		$("#"+comboId).append("<option value='"+vobj["optionValue"]+"'>"+vobj["optionText"]+"</option>")
	});	
	
	$('#'+ comboId).bootstrapDualListbox({
		 nonSelectedListLabel: 'Non-selected',
		  selectedListLabel: 'Selected',
		  preserveSelectionOnMove: 'moved',
		  moveOnSelect: false,
	});
	$('#'+ comboId).bootstrapDualListbox('refresh', true);*/
	
	commonPopulateCombo(configJson, dataJson);
	
	$('#'+ comboId).bootstrapDualListbox({
		  nonSelectedListLabel: 'Available Records',
		  selectedListLabel: 'Selected Records',
		  moveOnSelect: false
	});
	
	$('#'+comboId).bootstrapDualListbox('refresh', true);

	
var configJsonDualList=configJson["configJsonDualList"]
	
	if(configJsonDualList["serviceNameRightList"] !=undefined){
		var configJson={
				serviceName:configJsonDualList["serviceNameRightList"],
				comboId:comboId,
				callBackFunctionName:"populateRightList",
				primaryKeys:configJsonDualList["primaryKeysRightList"]		
				
			}
		callService(configJson);
	}
	
}


function populateRightList(configJson,dataJson){
	//var dataJson=JSON.parse(dataStr);
	var comboId=configJson["comboId"];
	$.each(dataJson["data"],function(k,vobj){
		$("#"+comboId).append("<option value='"+vobj["optionValue"]+"'>"+vobj["optionText"]+"</option>");
	});
	$('#'+comboId).bootstrapDualListbox('refresh', true);	
}
function showPreloader(text){
	if(text!=undefined && text!=null){
		$('#msgpreloader').html(text);
	}
	else{
		$('#msgpreloader').html("Please Wait..");
	}
	$('#preloader').show();
}
function hidePreloader(){
	 $('#preloader').delay(450).fadeOut('slow');
     $('body').delay(450).css({
      'overflow': 'visible'
    });  
}




/*function to enable /disable wizzard view */
function enableDisableWizzardView(enableStatus){
	  if(enableStatus==undefined)
		  enableStatus="0";
	  //alert(enableStatus);
	  resetWizzardView(enableStatus);
	  if(enableStatus=="1"){
		$('.sw-btn-prev').click(function(){
			if($(this).hasClass('disabled'))
				return;
			callOnWizzardButton(-1)
		});
		
		$('.sw-btn-next').click(function(){
			if($(this).hasClass('disabled'))
				return;
			var validationFlag=true;
			$('.sw-container:visible').each(function(){
				//alert(this.id);
				validationFlag=ValidateForAllVisible(this.id);
			});
			if(validationFlag)
				callOnWizzardButton(1);
			else
				showMsg("Field validation failed !");	
				
		});
		$('.sw-btn-final').click(function(){
			$('.callOnSaveClick').trigger('click');
		});
		
		$('.step-anchor').find('.nav-link').click(callonTabLinkClick);
	  	
	  }	
}

// reset function for wizzard view	  
function resetWizzardView(enableStatus){
	  if($('#smartwizard').is(":visible")){
		  
		  if(enableStatus=="1"){
			 
			if($('#initMode').val()=="MODIFY"){
				$('.step-anchor .nav-item').addClass("done");				 
			}  
			else{
				$('.step-anchor .nav-item').removeClass("done");
			}
			$('.step-anchor .nav-item').removeClass("active");
			$('.step-anchor .nav-item:first').addClass("active");
			$('.sw-toolbar').removeClass('hideData');  
		  	$('.sw-container').addClass('hideData');
		  	$('.sw-container:first').removeClass('hideData');
		  	$('.step-anchor').removeClass('hideData');
		  	$('.sw-btn-prev').addClass('disabled');
		  	$('.sw-btn-final').addClass('hideData');
		  	$('.hideInWizzardView').addClass('hideData');
			$('.callOnSaveClick').hide();
		  	
		  }
		  else{
			  $('.sw-toolbar').addClass('hideData');
			  $('.sw-container').removeClass('hideData');
			  $('.step-anchor').addClass('hideData');
			  $('.callOnSaveClick').show();
		  }
	  }
} 
/*call on click of  tab  button in wizzard view */
 function callonTabLinkClick(){
	  if(!$(this).closest('.nav-item').hasClass('done')){
			return;
	  }
	  var validationFlag=true;
		$('.sw-container:visible').each(function(){
			//alert(this.id);
			validationFlag=ValidateForAllVisible(this.id);
		});
		if(validationFlag==false){
			showMsg("Field validation failed !");
			return;
		}
	  
	  
	  var id=$(this).attr('href');	
	  var currentIndex=parseInt(id.split('-')[1]);
	  var nextIndex=currentIndex+1;
	  var previousIndex=currentIndex-1;
	  var totalContainer=$('.sw-container').length;
	  $('.step-anchor').find('.nav-item').each(function(){
		  if($(this).hasClass('active')){
			  $(this).removeClass('active');
			  $(this).addClass('done');
		  }
	  });
	 
	  $('.sw-container').addClass('hideData');
	  $('#step-'+currentIndex).removeClass('hideData');
	  
	  $("[href='#step-"+currentIndex+"']").closest('.nav-item').addClass('active');
	  $("[href='#step-"+currentIndex+"']").closest('.nav-item').removeClass('done');
	  
	  $('.sw-btn-next').removeClass('disabled');
	  $('.sw-btn-prev').removeClass('disabled');
	  $('.sw-btn-final').addClass('hideData'); 
	  
	  if(currentIndex==totalContainer){
		  $('.sw-btn-next').addClass('disabled');
		  $('.sw-btn-final').removeClass('hideData'); 
	  }
	  if(currentIndex==1){
		  $('.sw-btn-prev').addClass('disabled');
	  }  
	  $(window).scrollTop(0);
	  
} 
/*calling next previous button in wizzard view */
function callOnWizzardButton(plusMinusVal){
		 
			var currentIndex=0;
			$('.sw-container').each(function(){
				if(!$(this).hasClass('hideData')){
					currentIndex=parseInt(this.id.split('-')[1]);			
				} 	
			});
			 $('.sw-container').addClass('hideData');
			
			 $('.sw-btn-next').removeClass('disabled');
			 $('.sw-btn-prev').removeClass('disabled');
			 $('.sw-btn-final').addClass('hideData'); 
			
		 	var totalContainer=$('.sw-container').length;	
			var indx=0;
			//alert("current visible index=="+  currentIndex);
			indx=currentIndex+ plusMinusVal;
			
			if(indx==totalContainer){
				  $('.sw-btn-next').addClass('disabled');
				  $('.sw-btn-final').removeClass('hideData'); 
			}
			
			if(indx<=1){
			  $('.sw-btn-prev').addClass('disabled');
			} 
			//alert("nextindex =="+  indx);
			$('#step-'+indx).removeClass('hideData');
			 $("[href='#step-"+indx+"']").closest('.nav-item').addClass('active');
			 $("[href='#step-"+indx+"']").closest('.nav-item').removeClass('done');
			 $("[href='#step-"+currentIndex+"']").closest('.nav-item').addClass('done');
			 $("[href='#step-"+currentIndex+"']").closest('.nav-item').removeClass('active');
			 
			 $(window).scrollTop(0);
			
	 }


function checkZero(data){
    if(data.length == 1){
      data = "0" + data;
    }
    return data;
  }
    
function getCurrentDateString(){
	var today = new Date();
		var day = today.getDate() + "";
		var month = (today.getMonth() + 1) + "";
		var year = today.getFullYear() + "";
		var hour = today.getHours() + "";
		var minutes = today.getMinutes() + "";
		var seconds = today.getSeconds() + "";

		day = checkZero(day);
		month = checkZero(month);
		year = checkZero(year);
		hour = checkZero(hour);
		mintues = checkZero(minutes);
		seconds = checkZero(seconds);
		var date = day + "/" + month + "/" + year + " " + hour + ":" + minutes + ":" + seconds
		return date;
}
  /*function for creating html to be used for printing and creating pdf*/
  function createHTMLFromTable(configjson)
  {
  	try{
  		
  		var divId= configjson["divId"];
  		var reportName=configjson["reportName"]
  		
  		
  		var divHTML= "";
  		if($('#'+ divId).length==0){
  			divHTML=$('body').html();
  		}
  		else{
  			divHTML=$('#'+divId).html();
  		}
  		

  		var date = getCurrentDateString();
  		//	 var w = window.open("about:blank");
  		var strHTML="";
  		
  		/*var h1="Tamil Nadu Medical Services Corporation Limited";
  		var h2="(A Government of Tamil Nadu Undertaking)";
  		var h3="No. 417, Pantheon Road, Egmore,Chennai - 600 008, India";*/
  		var h4=reportName;
  		var	h5="";
  		var logoPosition = "left";
  		var headingAlignment = "left";
  	    var html = document.createElement( 'html' );
  		var pdfTableFontSize="10";
  		var theme=$('#theme').val();
  		var strHTML='<html><head><title></title><link rel="stylesheet" href="/HIS/hisglobal/eUpkaranTemplate/dist/css/adminlte.min.css">';
  		strHTML+='<link rel="stylesheet" href="/HIS/hisglobal/eUpkaranTemplate/dist/css/Theme/'+theme+'.css">';  
  		strHTML+='<style>';
  		
  		strHTML+='.accordion, accActive, .accordion:hover { background: #fff !important;border-bottom:1px solid #000;color:#000 !important;border-radius: 0 !important;}';
  		strHTML+='.accPanel {box-shadow: none !important;}';
  		strHTML+='.tbl-listing tr:nth-child(2n+1) {';
  		strHTML+='	background-color: white !important;';
  		strHTML+='fill: #333333;';
  		strHTML+='padding: 5px;';
  		strHTML+='}';

  		strHTML+='.tbl-listing tr:nth-child(2n) {';
  		strHTML+='background-color: white !important;'
  		strHTML+='fill: #333333;';
  		strHTML+='padding: 5px;';
  		strHTML+='}';
  		strHTML+='table{margin-top:0px}';
  		
  		 strHTML+='@media print {';
  			strHTML+='.make-grid(print);';  			
  		strHTML+='}';
  		/*strHTML+='.rows-print-as-pages .row {page-break-before: always;}';*/
  		  
  		strHTML+='</style>';
  		
  		
  		strHTML+='</head><body >';
  		strHTML+='<table width="100%">'; 
  		strHTML+='<tbody>';
  		strHTML+='<tr>';
		strHTML+='<td  valign="top" align="center" width="100%">';
		//strHTML+='<img src="/HIS/hisglobal/images/reportHeader.png" style="width: 90%;" ></td>'; 
		strHTML+='</tr>'; 
  		if(logoPosition == "left")
  		 {
			
			/*	  
			strHTML+='<tr>'; 
			strHTML+='<td id="rpt_head1" style=" padding-left: 8px; ">'; 
			strHTML+='<font size="4"><b>'+ h1 +'</b></font>'; 
			strHTML+='</td>'; 
			strHTML+='</tr>'; 
			
			
			strHTML+='<tr>'; 
			strHTML+='<td id="rpt_head2" style=" padding-left: 5px; ">'; 
			strHTML+='<font size="4"><b>'+ h2 +'</b></font>'; 
			strHTML+='</td>'; 
			strHTML+='</tr>'; 
			
			strHTML+='<tr>'; 
			strHTML+='<td id="rpt_head3" style=" padding-left: 5px; "  >'; 
			strHTML+='<font size="4"><b>'+ h3 +'</b></font>'; 
			strHTML+= '</td>'; 
			strHTML+='</tr>'; */
			if(h4!=""){
				strHTML+='<tr>'; 
				strHTML+='<td width="90%" align="center" >'; 
				strHTML+='<font style="font-size: 1em;	font-weight: bold;text-decoration: underline;">'+ h4 +'</font>'; 
				strHTML+='</td>'; 
				strHTML+='</tr>';
			}
			if(h5!=""){
				strHTML+='<tr>'; 
				strHTML+='<td  width="90%" align="center" >'; 
				strHTML+='<font style="font-size: 1em;	font-weight: bold;text-decoration: underline;"><b>'+ h5 +'</b></font>'; 
				strHTML+='</td>'; 
				strHTML+='</tr>';
			}
  		 }else if(logoPosition == "top")
  		 {
			  if(h4!=""){	
				   strHTML+='<tr>'; 
				   strHTML+='<td  width="90%" align="center">'; 
				   strHTML+='<font style="font-size: 1em;	font-weight: bold;text-decoration: underline;">'+ h4 +'</font>'; 
				   strHTML+='</td>'; 
				   strHTML+='</tr>';
			   }
			   if(h5!=""){
				   strHTML+='<tr>'; 
				   strHTML+='<td  width="90%" align="center">'; 
				   strHTML+='<font style="font-size: 1em;	font-weight: bold;text-decoration: underline;">'+ h5 +'</font>'; 
				   strHTML+='</td>'; 
				   strHTML+='</tr>';
			   }
  			}
		   strHTML+='<tr>'; 
		   strHTML+='<td align="right"> ';
		  /* strHTML+='<br/><font style="font-size: 0.8em;">Report Date :'+date+'</font>'; */
		   strHTML+='</td>'; 
		   strHTML+='</tr>';
  		   strHTML+='</tbody></table>';
   		 strHTML+='<hr/>'; 
  		//   w.document.write('<h1><center>'+reportName+'</center></h1>');  
  		//var html= document.createElement( 'html' );
  		//html.innerHTML =$('#'+ divId).html();
  		//$(html ' .accPanel').each(function(){Array});
  			strHTML+="<div style='width:100%;border-collapse: initial;page-break-inside: auto;' id='divmainData'>"+divHTML+"</div>";
  		     
  		   strHTML+='</body></html>';  
  		   
  		   strHTML=strHTML.replace("table-striped","");
  		   strHTML=strHTML.replace("table-bordered","");
  		   strHTML=strHTML.replace("dt-responsive","");
  		   strHTML=strHTML.trim();
			
  		}catch(err){
  			alert(err.message);
  		}
  		//alert(strHTML);
  		return strHTML;
  }


  
 // var configjson={divId:"Your dive Name",reportName:"Report name here " };
  function printHTML(configjson)
  {
  	try{
  		if(configjson["divId"]==undefined || $('#'+configjson["divId"]).length==0){
  	  	  	console.log("printHTML >>>>container div Id required");  	  	  	
  		 }
  		
  		var strHTML=createHTMLFromTable(configjson);
  		strHTML=strHTML.replace('<html>','<html><page size="A4" style= "background: white;  width: 250mm; height: 297mm; display: block; margin: 0mm 35mm 0mm 3mm; padding: 0.2cm; background: white; box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);">');
  		strHTML=strHTML.replace('</html>','</page></html>');
  		var w = window.open("about:blank");		
  		w.document.write(strHTML);
  		 w.document.close(); 
  		 
  	    if (navigator.appName == 'Microsoft Internet Explorer')
  	    	window.print();
  	    else 
  	    	w.print();
  	}catch(err){
  		alert(err.message);
  	}
  }

/* var configjson={divId:"Your dive Name",reportName:"Report name here ", pdfOrientation:"landscape or portrate" };  margin-bottom: 0.5cm;*/
  function printPDF(configjson){
  	
  	if(configjson["divId"]==undefined || $('#'+configjson["divId"]).length==0){
  		console.log("printPDF >>>>container div Id required"); 
  	  
	 }
  	
  	var reportName=configjson["reportName"]==undefined?"":configjson["reportName"];
  	var printpdfin= configjson["pdfOrientation"]==undefined?"portrait":configjson["pdfOrientation"].toLowerCase();
  	var filename=configjson["reportName"]==undefined?"Report.pdf":configjson["reportName"];
	
  	var strHTML=createHTMLFromTable(configjson);
  	var newHTML= strHTML.split("BreakHTML");
  	var count =newHTML.length;
  		
  	if(count>1)
  	{
  		for(var i=0;i<count;i++)
  		{
			var HTML= newHTML[i];
			var doc = new DOMParser().parseFromString(HTML, "text/html")
			var reportname = doc.getElementById("REPORTNAME").value+"_Part -"+(i+1) ;
			filename = reportname;
			//alert(filename)
			var opt = {
					  margin:       2,
					  filename:    filename,
					  /*image:        { type: 'jpeg', quality: 0.98 },*/
					 /* html2canvas:  { scale: 2 },*/
					  jsPDF:        { orientation: printpdfin },
					  //pdfCallback: pdfCallback
					  /*jsPDF:        { unit: 'in', format: 'letter', orientation: 'landscape' }*/
					};
			
			html2pdf().set(opt).from(HTML).save();    
		 }
  	 }
  	else
  	{
  		var opt = {
  				  margin:       10,
  				  filename:    filename,
  					  /*image:        { type: 'jpeg', quality: 0.98 },*/
  					 /* html2canvas:  { scale: 2 },*/
  					  jsPDF:        { orientation: printpdfin },
  					  //pdfCallback: pdfCallback
  					  /*jsPDF:        { unit: 'in', format: 'letter', orientation: 'landscape' }*/
  					};
  			
  		html2pdf().set(opt).from(strHTML).save(); 
  	}
 }	
  
  
  
  
  
  
  function callScheduler(configJson){
		 alert("config>>>>"+configJson);
		 var data={
				 hmode:"callScheduler",
				 serviceName:configJson["serviceName"],			
		 }
		 if(configJson["inputData"]!=undefined){
			 data.inputData=JSON.stringify(configJson["inputData"])
			 //alert(JSON.stringify(data.inputData));
		 }
		 
		 if(configJson["primaryKeys"]!=undefined){
			 data.primaryKeys= configJson["primaryKeys"]
		 }
		 if(configJson["initMode"]!=undefined){
			 data.initMode= configJson["initMode"]
		 }
		 if(configJson["fileUploadFlag"]!=undefined){
			 data.fileUploadFlag= configJson["fileUploadFlag"]
		 }
		var url= document.forms[0].action; 
		if(url==undefined){
			alert("Form url not found")
			return;
		}
			
		 $.ajax({
			 	type: 'POST',
				url : url,
				data : data,
				dataType : "html",
				success : function(returnStr) {
					//alert(returnStr);
					if(configJson["callBackFunctionName"]!=undefined)
						eval(configJson["callBackFunctionName"])(configJson, returnStr);
					
							
				},
				fail : function() {
					alert("error occured");
				}
			});
		
	 }

  function closeModal(modalName){
  	$('#'+modalName).modal('hide');
  }
  
  function isNumber(evt) {
	    evt = (evt) ? evt : window.event;
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }
	    return true;

	}
  
  
  
  
  /*
   * var configJsonexample={
  			serviceName : "/EMMSComplaintDataWebService/getDataService/getComponentHtml",
  			primaryKeys : '1189,1190',
  			containerdivId : 'SanctionGenerationDtls',			
  			componentDataArray:configJson.componentDataArray
  		}
  		use #varname# in component for variable
  		use class='tbldatavo<componentIndexno>' for table in which loop of data required  
  		use @varname@ in component for variable to be in every row inside table -tbldatavo<componentIndexno> 
  		
   * 
   * */
  function getComponentHtml(configJson){
  	
  	 var configJsonComponent={
  				serviceName : configJson.serviceName,
  				callBackFunctionName : "populateComponentHtmlWithData",
  				primaryKeys : configJson.primaryKeys,
  				containerdivId : configJson.containerdivId,
  				componentDataArray : configJson.componentDataArray
  				
  			}
  	 
  	 
  		callService(configJsonComponent);
  	 
  }


  function populateComponentHtmlWithData(configJson,dataStr){
  	
  	//alert(JSON.stringify(configJson));
  	//alert(dataStr);
  	
  	var dataJson=JSON.parse(dataStr);
  	var componentDataArray= configJson.componentDataArray;
  	var containerdivId=configJson.containerdivId;
  	//getting coponent html and decrepting 
  	$.each(dataJson["dataValue"], function(i,vobj){
  		var ComponentHTML= atob(vobj[0]);
  		//getting multiple Data Array
  		$.each(componentDataArray, function(arrIndx,data){
  			var dataHeading= data["dataHeading"];
  			var dataValue=data["dataValue"];
  			
  			
  			//populating values in ComponentHTML
  			$.each(dataValue, function(rowIndx,valArr){
  				$.each(valArr, function(colIndx,finalVal){
  					//alert(dataHeading[colIndx]  +"====" +finalVal)
  					ComponentHTML=ComponentHTML.replaceAll("#"+dataHeading[colIndx]+"#", finalVal);
  				});				
  			});
  		});
  		
  		//alert(ComponentHTML);
  		$("#"+containerdivId).append(ComponentHTML).removeClass('hideData');
  	});
  	
  	$.each(componentDataArray, function(arrIndx,data){
  		if($('.tbldatavo'+arrIndx).length>0){
  			var dataHeading= data["dataHeading"];
  			var dataValue=data["dataValue"];
  			$('.tbldatavo'+arrIndx).each(function(){
  				var tabbeobj=this;
  				var componenttrhtml=$(tabbeobj).find('tbody')[0].innerHTML;
  				$(tabbeobj).find('tbody').html("");
  				//alert(trhtml);
  				
  				//populating values in trhtml
  				$.each(dataValue, function(rowIndx,valArr){
  					var trhtml=componenttrhtml;
  					$.each(valArr, function(colIndx,finalVal){
  						//alert(dataHeading[colIndx]  +"====" +finalVal)
  						trhtml=trhtml.replaceAll("@"+dataHeading[colIndx]+"@", finalVal);
  					});
  					$(tabbeobj).find('tbody').append(trhtml);
  					
  				});
  			});
  		}
  		
  	});
  
	
	}
  
  
  function RsPaise(n)
  {
  	//alert(n);
  	var no= n;	
  	var nums;
  	var op;
  	if(n > 999999999.99)
  	{
  		op='Oops!!! The amount is too big to convert';
  		//document.getElementById('word').innerHTML= "&#8377" +"  " + op;
  	}
  	else
  	{
  		nums = no.toString().split('.')
  		var whole = Rs(nums[0])
  		if(nums[1]==null)nums[1]=0;
  		if(nums[1].length == 1 )nums[1]=nums[1]+'0';
  		if(nums[1].length> 2){nums[1]=nums[1].substring(2,length - 1)}
  		if(nums.length == 2)
  		{
  			if(nums[0]<=9){nums[0]=nums[0]*10} else {nums[0]=nums[0]};
  			var fraction = Rs(nums[1])
  			if(whole=='' && fraction==''){op= 'Zero only';}
  			if(whole=='' && fraction!=''){op= + fraction + ' paise only';}
  			if(whole!='' && fraction==''){op='Rupees ' + whole + ' only';} 
  			if(whole!='' && fraction!=''){op='Rupees ' + whole + 'and ' + fraction + ' paise only';}
  			// amt=document.getElementById('amt').value;
  			
  			// if(isNaN(amt) == true ){op='Error : Amount in number appears to
  			// be
  			// incorrect. Please Check.';}
  			// document.getElementById('op').innerHTML=op;
  		
  		//document.getElementById('word').innerHTML= "&#8377" +"  " + op;
  		}
  	}
  		return op;
  	//alert(op);
  }

  function Rs(amount){
  	var words = new Array();
  	words[0] = 'Zero';words[1] = 'One';words[2] = 'Two';words[3] = 'Three';words[4] = 'Four';words[5] = 'Five';words[6] = 'Six';words[7] = 'Seven';words[8] = 'Eight';words[9] = 'Nine';words[10] = 'Ten';words[11] = 'Eleven';words[12] = 'Twelve';words[13] = 'Thirteen';words[14] = 'Fourteen';words[15] = 'Fifteen';words[16] = 'Sixteen';words[17] = 'Seventeen';words[18] = 'Eighteen';words[19] = 'Nineteen';words[20] = 'Twenty';words[30] = 'Thirty';words[40] = 'Forty';words[50] = 'Fifty';words[60] = 'Sixty';words[70] = 'Seventy';words[80] = 'Eighty';words[90] = 'Ninety';var op;
  	amount = amount.toString();
  	var atemp = amount.split(".");
  	var number = atemp[0].split(",").join("");
  	var n_length = number.length;
  	var words_string = "";
  	if(n_length <= 9){
  	var n_array = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0);
  	var received_n_array = new Array();
  	for (var i = 0; i < n_length; i++){
  	received_n_array[i] = number.substr(i, 1);}
  	for (var i = 9 - n_length, j = 0; i < 9; i++, j++){
  	n_array[i] = received_n_array[j];}
  	for (var i = 0, j = 1; i < 9; i++, j++){
  	if(i == 0 || i == 2 || i == 4 || i == 7){
  	if(n_array[i] == 1){
  	n_array[j] = 10 + parseInt(n_array[j]);
  	n_array[i] = 0;}}}
  	value = "";
  	for (var i = 0; i < 9; i++){
  	if(i == 0 || i == 2 || i == 4 || i == 7){
  	value = n_array[i] * 10;} else {
  	value = n_array[i];}
  	if(value != 0){
  	words_string += words[value] + " ";}
  	if((i == 1 && value != 0) || (i == 0 && value != 0 && n_array[i + 1] == 0)){
  	words_string += "Crores ";}
  	if((i == 3 && value != 0) || (i == 2 && value != 0 && n_array[i + 1] == 0)){
  	words_string += "Lakhs ";}
  	if((i == 5 && value != 0) || (i == 4 && value != 0 && n_array[i + 1] == 0)){
  	words_string += "Thousand ";}
  	if(i == 6 && value != 0 && (n_array[i + 1] != 0 && n_array[i + 2] != 0)){
  	words_string += "Hundred and ";} else if(i == 6 && value != 0){
  	words_string += "Hundred ";}}
  	words_string = words_string.split(" ").join(" ");
  	}
  	return words_string;
  	
  }
function openPopup(src){
	var ticketid=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	if(src.indexOf('?')>=0)
		src= src+"&varSSOTicketGrantingTicket=" +ticketid;
	else
		src= src+"?varSSOTicketGrantingTicket=" +ticketid;
	var width = $(window).width();
	var height = $(window).height();
	window.open(src, "", "toolbar=yes,scrollbars=yes,resizable=yes,top=100,left=100,width="+width+",height="+height);
	
}

function checkHTMLOnButtonClick(){
	var overallFlag=true;
	 $('input[type="text"],textarea').each(function(){
		  var flag=checkHTMLTags(this);
		  if(flag==false){
			  showValidationMsg(this, "Not a valid input !",flag);	
			  overallFlag=false;
			  return false;
		}
		else{
			  showValidationMsg(this, "",flag);
		}
	 });
	
	return overallFlag;
}





var myInterval =null;
function showAlertMsg(message, messageType, alertDivId){
	if(myInterval!=null)
		clearInterval(myInterval); 
	if(alertDivId==undefined ||$('#'+alertDivId).length==0)
		alertDivId='alertMsg';
	$('#' + alertDivId).removeClass("alert-success");
	$('#'+alertDivId).removeClass("alert-danger");
	$('#'+alertDivId).removeClass("alert-info");
	
	if(messageType=="success"){
		$('#'+alertDivId).addClass('alert-success');		
		message="<span style='float: left;font-size: 41px;margin-top: -10px;margin-right: 10px;'><i class='fa-solid fa-circle-check'></i></span> &nbsp;&nbsp;&nbsp;<span style='float:left;font-size: 13px;'>"+message+"</span>";
	}
	else if(messageType=="danger"){
		$('#'+alertDivId).addClass('alert-danger');
		message="<span style='float: left;font-size: 41px;margin-top: -10px;margin-right: 10px;'><i class='fa-solid fa-triangle-exclamation'></i></span> &nbsp;&nbsp;&nbsp;<span style='float:left;font-size: 13px;'>"+message+"</span>";
		
	}
	else{
		message="<span style='float: left;font-size: 41px;margin-top: -10px;margin-right: 10px;'><i class='fa-solid fa-circle-info'></i></span> &nbsp;&nbsp;&nbsp;<span style='float:left;font-size: 13px;'>"+message+"</span>";
		$('#'+alertDivId).addClass('alert-info');
	}
	message=message + "<a type='button' class='btn-close' data-bs-dismiss='alert' style='float: right;' aria-label='Close'></a>";
	
	$('#'+alertDivId).html(message).show();
	myInterval=setInterval(function(){ $("#"+alertDivId).fadeOut(); }, 10000);
	$('body').scrollTop(0);
	
}

/*name comarizon------------------------------*/

//Function to calculate Soundex code for a given name
function soundex(name) {
  const soundexChars = [' ', 'B', 'C', 'D', ' ', 'F', 'G', 'H', ' ', 'J', 'K', 'L', 'M', 'N', ' ', 'P', 'Q', 'R', 'S', 'T', ' ', 'V', ' ', 'X', 'Y', 'Z'];
  const ignoreChars = ['A', 'E', 'I', 'O', 'U', 'H', 'W', 'Y'];

  name = name.toUpperCase();
  let soundexCode = name.charAt(0);
  let prevCode = getCode(name.charAt(0));

  for (let i = 1; i < name.length; i++) {
      let code = getCode(name.charAt(i));
      if (code !== ' ' && code !== prevCode) {
          soundexCode += code;
      }
      prevCode = code;
  }

  soundexCode = soundexCode.replace(/0/g, '');
  soundexCode = soundexCode.substr(0, 4).padEnd(4, '0');

  return soundexCode;

  function getCode(char) {
      const charCode = char.charCodeAt(0);
      if (ignoreChars.includes(char)) {
          return ' ';
      } else if (charCode >= 65 && charCode <= 90) {
          return soundexChars[charCode - 65];
      } else {
          return ' ';
      }
  }
}


//Function to compare two names based on their Soundex codes
function compareNames(name1, name2) {
const soundex1 = soundex(name1);
const soundex2 = soundex(name2);

return soundex1 === soundex2;
}
/*name comparizon ends---------------------------------------*/

function convertDateToStringWithZero(d)
{
	var val=parseInt(d);
return ((val < 10 ? '0' : '') + val).trim();
}

/* JSON FORMAT
 	var json ={
			"stepTitle":"Test Title here",
			"steps":[
				{"step":"step-One", "stepIcon":"1"},
				{"step":"step-Two" "stepIcon":"2"},
				{"step":"step-Three" "stepIcon":"3"},
			],
			"activeStep":"step-One"				
	}; 
 
 * */

function createWizard(json){
	
	$('#stepsWizzard').show();	
	$('#stepUL').empty();
	$('#stepTitle').hide();
	if(json==undefined){
		alert("cannot create wizzard")
		return;		
	}
	if(json["activeStepNo"]==undefined){
		alert("Active Step No. should be defined")
		return;
	}
	
	if(json["steps"]==undefined || json["steps"].length<=0){
		alert("Steps should be defined");
		return;
	}
	
	if(json["stepTitle"]!=undefined && json["stepTitle"]!="" ) {
		$('#stepTitle').text(json["stepTitle"]).show();
	}
	
	var totalSteps= json["steps"].length;
	var activeStepNo=parseInt(json["activeStepNo"]);
	$.each(json["steps"], function(indx, objjson){
		var className="";
		if(indx+1<activeStepNo )
			className="step-complete";		
		else if(indx+1==activeStepNo )
			className="step-pending pulse";
		else  if(indx+1>activeStepNo )
			className="step-disabled";
		var icon="";
		if(objjson["stepIcon"]!=undefined){
			if(isNaN(objjson["stepIcon"]))
				icon= "<i class='"+objjson["stepIcon"]+"'></i>";
			else
				icon= objjson["stepIcon"];
		}
		
		$('#stepUL').append("<li class=' step-item "+className+"' id='step-"+(indx+1)+"'><span class='mt-2 mb-1 icon' >"+icon+"</span><span class='text'>"+objjson["step"]+"</span></li>");
		if(indx<(totalSteps-1))
			$('#stepUL').append("<li class='step-item-space' ><hr></li>");
	});
	resizeFn();
}
function resizeFn() {
	
	if($('#stepsWizzard li').length>0){
		if(window.innerHeight > window.innerWidth && window.innerWidth<500){
			$('#stepsWizzard').hide();		
		}
		else{
			$('#stepsWizzard').show();	
		}
	}
}


function callRegistrationService(configJson){
	// alert("service>>>>"+configJson["serviceName"]);
	 
	 var data={			
			 serviceName:configJson["serviceName"],	
			 isGlobal: "1"
	 }
	 if(configJson["inputData"]!=undefined){
		 data.inputData=JSON.stringify(configJson["inputData"])
		// alert("JSON.stringify(data.inputData)::"+JSON.stringify(data.inputData));
	 }
	 //data=initSecurityParameterFromajaxjson(data);
	// alert("configJson[serviceType]::"+configJson["serviceType"]);
	var url= "/HISRegistration_MC/registration/transactions/"
	if(configJson["serviceType"]=="saveDataService"){	
		url=url + "saveDataServiceOnlineAppoitment.action";
		//showPreloader();
	}
	else 
		url=url + "getDataServiceOnlineAppoitment.action";
	//alert(url);	
	 $.ajax({
		 	type: 'POST',
			url : url,
			data : data,
			dataType : "json",
			success : function(returnStr) {
				//hidePreloader();
				eval(configJson["callBackFunctionName"])(configJson, returnStr);
			},
			error: function (jqXHR, exception) {
				  console.log(jqXHR);
				  console.log(exception);
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		       // hidePreloader();
		        console.log(msg);
		        //alert("Some Problem Occured");
		    },
			fail : function() {
				//hidePreloader();
				alert("error occured");
			}
		});
	
}
