<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/dateTag.tld" prefix="dateTag"%>
<%@ taglib uri="/WEB-INF/crNo.tld" prefix="crNo"%>


<html>
<head>
<meta>
<title>Path Care Lab Report</title>
<link href="../../hisglobal/css/master.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/tab.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/popup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/newpopup.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/css/buttons.css" rel="stylesheet" type="text/css">

<link href="../../hisglobal/bootstrap4.0_newgui/css/bootstrap.css" rel="stylesheet" />
<link href="../../hisglobal/bootstrap4.0_newgui/font-awesome/css/all.css" rel="stylesheet">
<link href="../../hisglobal/css/newlayout.css" rel="stylesheet" type="text/css">
<link href="../../hisglobal/bootstrap4.0_newgui/datetimepicker/css/gijgo.min.css" rel="stylesheet" type="text/css">


<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/jquery-3.3.1.min.js"></script>

<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../../hisglobal/bootstrap4.0_newgui/datetimepicker/js/gijgo.min.js"></script>


<script language="JavaScript" src="../../hisglobal/masterutil/js/master.js"></script>
<!-- <script language="JavaScript" src="../../hisglobal/js/tab.js"></script>
 --><script language="JavaScript" src="../../hisglobal/js/calendar.js"></script>
<script language="Javascript" src="../../hisglobal/js/validation.js"></script>
<script language="Javascript" src="../../hisglobal/js/util.js"></script>
<script language="Javascript" src="../../hisglobal/js/popup.js"></script>
<script language="Javascript" src="../../hisglobal/js/newpopup.js"></script>

 --><script language="JavaScript" src="../../hisglobal/js/pdf.min.js"></script>


<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script type="text/javascript">

function onSave()
{
	var count=0;
	var hiddenDtl="";
	
	$('input[name=chkHardCopyRecd]').each(function (i) {		
		
		//alert("i="+i+"::::"+$("input[name=chkHardCopyRecd]")[i].checked);
		
		if (this.checked) {
			$("input[name=strIsHardCopyRecd]")[i].value="1";			
		}
		else{
			$("input[name=strIsHardCopyRecd]")[i].value="0";			
		}
		
		//crNo^requisitionNo^fileName^isHardCopyRecd^strTestCodes
		hiddenDtl = $("input[name=strHiddenDtl]")[i].value;
		//alert("hiddenDtl::"+hiddenDtl);
			 if (hiddenDtl.split("^")[3]!= $("input[name=strIsHardCopyRecd]")[i].value) {
				 $("input[name=strIsHardCopyRecd]")[i].disabled = false;
				 $("input[name=strHiddenDtl]")[i].disabled = false;
				 count++;
			 }
			 else
			 {
				 $("input[name=strIsHardCopyRecd]")[i].disabled = true;
				 $("input[name=strHiddenDtl]")[i].disabled = true;
			 }	 
		// alert("count::"+count);
	}); 
	
	
	/* $('input[name=strIsHardCopyRecd]').each(function (i) {			
		alert($("input[name=strIsHardCopyRecd]")[i].value); 
		alert($(this).is(':disabled'));
	}); */
	
	if(count>0){
		//$('#mainDeskLoadingMsgDiv').show();	 
		 document.forms[0].hmode.value="saveHardCopyRecdDetails";						  
	     document.forms[0].submit();
	}
	else{
		alert("Please Check/Uncheck Atleast one record to Save!!");
		
		$('input[name=strIsHardCopyRecd]').each(function (i) {			
					 $("input[name=strIsHardCopyRecd]")[i].disabled = false;
					 $("input[name=strHiddenDtl]")[i].disabled = false;
		}); 
	}
	
}

function onClickHardCopyRecd(index)
{
	var isHardCopyRecd = "0";
// 	alert("index::"+index);
// 	alert("strIsHardCopyRecd::"+$("input[name=strIsHardCopyRecd]")[index].value);
// 	alert("strIsHardCopyRecd checked::"+$("input[name=strIsHardCopyRecd]")[index].checked);


		if($("input[name=strIsHardCopyRecd]")[index].checked)
		{	
			var isHardCopyRecd = "1";
		}
		
			var hiddenOtherDtl = $("input[name=strHiddenDtl]")[index].value+"^"+$("input[name=strIsHardCopyRecd]")[index].value+"^"+isHardCopyRecd+"^"+index;
			//crNo^requisitionNo^fileName^isHardCopyRecd
			//alert("hiddenOtherDtl::"+hiddenOtherDtl);
			var url1="/HISDRDESK_MC/new_opd/transaction/MCPathLabReportDetailCNT.cnt?hmode=saveHardCopyRecdDetails&hiddenOtherDtl="+window.btoa(hiddenOtherDtl); 
		
			$.ajax({
				  url: url1,
				  success:function(data){
// 					  alert("Hard Copy Received."+data);
					  var dataReceived = [];
					  dataReceived = data.split("^");
// 					  alert("Hard Copy Received 0::"+dataReceived[0]);
// 					  alert("Hard Copy Received 1::"+dataReceived[1]);
// 					  alert("Hard Copy Received 2::"+dataReceived[2]);
					  	if(dataReceived[0])
					  	{	
					  		if(dataReceived[1]=='1'){
								$('#recdId-'+dataReceived[2]).show();
								$('#nRecdId-'+dataReceived[2]).hide();
					  		}
					  		else
					  		{
					  			$('#recdId-'+dataReceived[2]).hide();
								$('#nRecdId-'+dataReceived[2]).show();
					  		}	
					  	}	
					  }
				});
}



function view_Print_Slip(obj,fileId)
{
		if(fileId!='' && fileId.length > 0 && fileId !=null && fileId!='NA')
		{
			document.forms[0].hmode.value="getuploadedfile"; 
			document.forms[0].strUploadFileId.value=fileId;
			//document.forms[0].target = "_blank";
			document.forms[0].submit();
		}
		else
		{
			alert("No File to Down-Load!!");			
		}
}



function openPDF(pdfUrl) {
	alert(pdfUrl);
    window.open(pdfUrl);
    
}

function printreport(e,pdfName)
{

//	alert("printt"+pdfName);

// 	var clss=document.getElementsByClassName("reportss");
// 	var repp="";
// 	var tridmap=new Map();
// 	for(var d=0;d<clss.length;d++)
// 		{
		
// 		if(document.getElementsByClassName("reportss")[d].checked)
// 			{
			
// 			var idg=document.getElementsByClassName("reportss")[d].id;
// 			tridmap.set(idg,idg);
			
// 		var rep=document.getElementsByClassName("reportss")[d].value;
// 		repp+=rep+"@@";
		
// 			}
		
// 		}
	
	
// 	var pdfName=repp;

// 	console.log("pdfName"+pdfName);
	
 
//     alert("1.4");  
	var _mode = "AjaxGetPDFReport";
	//var url="/HISDRDESK_MC/new_opd/tranaction/controller/action/InvestigationTrackingReport.cnt?hmode="+_mode+"&selectedPDFName="+pdfName;
  //  var url1="/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?hmode=getPrescribedTestDtl&hiddenOtherDtl="+window.btoa(hiddenOtherDtl);  
       //var url="/HISDRDESK_MC/new_opd/transaction/MCPathLabReportDetailCNT.cnt?selectedPDFName="+pdfName;

       var url = "MCPathLabReportDetailCNT.cnt?hmode=AjaxGetPDFReport%26selectedPDFName="+ pdfName;


     //  openPDF(url);
        	        //ajaxFunction(url, "1");

        	    //    document.forms[0].action = url;
        	    //    document.forms[0].target = '_blank';
        	    //    	document.forms[0].submit();
        	        	
        	       // 	return false;

	if($('#showReportPdfModalIframe'))
	$('#showReporStPdfModalIframe').remove();
	
	$('#showReportPdfModal .modal-body').html("");
	
	$('#showReportPdfModal .modal-body').prepend('');

	// https://docs.google.com/gview?url=https://www.isaaa.org/kc/inforesources/publications/didyouknow/did_you_know-booklet.pdf&embedded=true
	
	//$('#showReportPdfModal .modal-body').prepend('<iframe title="aa.pdf" id="showReportPdfModalIframe" style="width:100%;height:75vh;" src="'+ url+'" ></iframe>');

	url = url.replace("MCPathLabReportDetailCNT.cnt" , document.forms[0].action);

	//url = 'https://tfri.icfre.org/VanSangyan/may%202014%20issue.pdf';
	
	//alert("url >> "+url);
	
	$('#showReportPdfModal .modal-body').prepend('<iframe title="aa.pdf" id="showReportPdfModalIframe" style="width:100%;height:75vh;" src="https://docs.google.com/gview?url='+ url+'&embedded=true" ></iframe>');

	$('#showReportPdfModal').modal('show');
	var flg=false;
	 

}

        function getAjaxResponse(res, mode) {
       	 
         	if (mode == "1") {alert(res);

         	$('#showReportPdfModal .modal-body').html("");
        	
        	$('#showReportPdfModal .modal-body').prepend('');
        	$('#showReportPdfModal .modal-body').prepend('<iframe title="aa.pdf" id="showReportPdfModalIframe" style="width:100%;height:75vh;" src="'+ res+'" ></iframe>');
        	$('#showReportPdfModal').modal('show');
         	}
         }

function initGoFunc(eve) {
	var flag = validateData(eve, 5);
	if (flag) {
		if (eve.keyCode == 13) {
			onGoButton(eve);
		}
	} else {
		return false;
	}

}

function goFuncOnEnter(e) {
	if (e.keyCode == 13) {
		onGoButton(eve);
	} else {
		return false;
	}
}


function onGoButton(event) {

	event.preventDefault();
	  
		$('#mainDeskLoadingMsgDiv').show();
			

	  		  
		if (document.forms[0].strCrNo.value.length > 14) 
		{
			
			document.forms[0].hmode.value = "issueToPatGo";
			document.forms[0].submit();
	
		} else {

			alert("Please Enter Valid Cr No.");
			
			$('#mainDeskLoadingMsgDiv').hide();
			return false;
		}
	 
}


	function openIssueDtl(index){
	 
		$('#mainDeskLoadingMsgDiv').show();
		
		let strHiddenDtl = $("#strHiddenDtl"+index).val();
		document.forms[0].crNo.value = strHiddenDtl.split("^")[0];
		document.forms[0].strCrNo.value = strHiddenDtl.split("^")[0];
		
		if (document.forms[0].strCrNo.value.length > 14) 
		{
			$("#strHiddenPatDtls").val(strHiddenDtl);
			document.forms[0].hmode.value = "issueToPatGo";
			document.forms[0].submit();
		
		} else {
			alert("Please Enter Valid Cr No.");
			$('#mainDeskLoadingMsgDiv').hide();
			return false;
		}
	}

	function getPatDtls(){
        
		$('#mainDeskLoadingMsgDiv').show();
		document.forms[0].hmode.value = "unspecified";
		document.forms[0].submit();
	}


	function cancelPageFunc()
	{
		document.forms[0].hmode.value="unspecified";						  
	    document.forms[0].submit();
	}


</script>
<style>
     
     .example {
            page-break-after: always;
        }
        
@media print {
 body  {
                visibility: hidden;
            }

#printSection {
 	visibility: visible;
	width:auto;
	left:150px;

}}

 .prescriptionTile { 
 	font-size : 14px; 
 } 
.table{
	color: black;
}
    </style>
    
</head>
<body >
<div id="mainDeskLoadingMsgDiv" style="display:none;width:100vw;height:100vh;position:fixed;z-index:99999; background-color:rgba(0,0,0,0.6)">
	<h2 class="text-center" style="color:white; margin-top:13%"><i class="fa fa-spinner fa-spin"></i> Loading...</h2>
</div>

<html:form name="mcPathLabReportDetailBean" action="/transaction/MCPathLabReportDetailCNT" type="new_opd.transaction.controller.fb.MCPathLabReportDetailFB">
	<fieldset>
<div class="prescriptionTile">
<center>
		<div id="errMsg" class="errMsg"><bean:write name="mcPathLabReportDetailBean" property="strErrMsg" /></div>
		<div class="warningMsg"><bean:write name="mcPathLabReportDetailBean" property="strWarningMsg" /></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="mcPathLabReportDetailBean" property="strNormalMsg" /></div>	
	
		<%--< tag:tab tabLabel="Store Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>
</center>
</div>
	
		<legend class='legendHeader' id='nonPrintableLegend'>Path Care Lab Report Details</legend>
		 <div class="legend2" id='nonPrintableLegend2'>
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelPageFunc();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Clear/Cancel"></i>
		<span class="popuptextToast">Cancel</span>
		</div>
		</button>	
<!-- 		<button  id="printbutton" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" data-toggle="modal" data-target="" style="background-color:#2e79b4;" onClick="showSlip();" > -->
<!-- 			<div class="popupToast"><i class="fa fa-print iround"  title="Print Last Voucher"></i> <span class="popuptextToast">Print</span></div> -->
<!-- 		</button>		 -->
	    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return  onSave();"   data-toggle="" data-target="#previewModal" >					
			<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save HardCopy Received</span></div>
		</button>												                 
  </div>
	
	<%if(request.getAttribute("strErrMsg") != null){ %>
	<div class="alert alert-danger  alert-dismissible fade show" id="errID" style="display: ;"><%=request.getAttribute("strErrMsg") %></div>
	<% } %>
	
	<%if(request.getAttribute("strWarningMsg") != null){ %>
	<div class="alert alert-warning  alert-dismissible fade show" id="wrnID" style="display: ;"><%=request.getAttribute("strWarningMsg") %></div>
	<% } %>
	
	<%if(request.getAttribute("strNormalMsg") != null){ %>
	<div class="alert alert-success  alert-dismissible fade show" id="normalMsg" style="display: ;"><%=request.getAttribute("strNormalMsg") %></div>
	<% } %>
	
	
	<div class="container-fluid">
	<%-- 
		<div class="prescriptionTile">
										 
			<div id="goBox">		 
				<div class="row rowFlex reFlex">
				 
				<div class="col-sm-1" align="right"><font id="mandCRId" color="red">*</font><label>CR 2No.</label></div>
					<div class="col-sm-3">
						<div id="patientCrEdId">
							<crNo:crNo value ="${mcPathLabReportDetailBean.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
						</div>													
					</div>
					<div class="col-sm-1">
						<span class="fa fa-search" style="cursor: pointer; display: none;" id="searhPatientImageId" title="Click here for Patient Search" name="searchPatient" onclick="showPatientListingWindow('4',document.forms[0].strCrNo,'setSelectedCrNo');"></span>
							<a href="#" class="btn btn-sm btn-success" onclick="onGoButton(event);" id='goBtnId' onkeyup="goFuncOnEnter(event);" style="font-size: 1rem;">
							GO&nbsp;<i class="fas fa-angle-double-right"></i>
							</a>
					</div>
					 				
					</div>
				</div>
<!-- 				<hr> -->
<!-- 				<div class="row rowFlex reFlex"> -->
<!-- 						<div class="col-sm-10"></div> -->
<!-- 						<div class="col-sm-2" align="right"><font color="red">*</font>Fields Mandatory</div>				 -->
<!-- 				</div> -->
						 					
		 </div>
	 --%>	
			<div class="prescriptionTile">	
			<fieldset>
			
				<div class="row rowFlex reFlex" style="margin-top: 10px;">
					<div class="col-sm-2" style="color:black; font-size : 14px;">Handover Date</div>
					<div class="col-sm-2"><input class="form-control datepicker" name="strPresDate" id="strPresDate" value="${mcPathLabReportDetailBean.strCtDate}" onchange="getPatDtls();"></div>
				</div>
				
				<legend class='legendHeader' id='nonPrintableLegend' style="font-size: 1.2rem;color:black;">Patient List</legend>
					<table class="table" style="margin-top: 10px;">
						<thead><tr>
							<th style="text-align:center;width:3%;color:black;">#
							</th><th style="text-align:center;width:10%;color:black;">CR No.
							</th><th style="text-align:left;width:10%;color:black;">Patient Name
							</th><th style="text-align:center;width:8%;color:black;">Mobile No.
							</th><th style="text-align:center;width:7%;color:black;">Gender/Age
							</th><th style="text-align:center;width:10%;color:black;">Sample Drawn Date/time
							</th><th style="text-align:center;width:10%;color:black;">Sample HandOver Date/time
							</th><th style="text-align:left;width:15%;color:black;">Test Name(Turn Around Time)
							</th><th style="text-align:center;width:7%;color:black;">Status
							</th><th style="text-align:center;width:15%;color:black;">View Report<br>(Report Date/Time)
							</th><th style="text-align:center;width:5%;color:black;">Hard Copy<br>Received?
							</th></tr>
						</thead>
					</table>
					
			 	<div id=divPatDetails style="max-height:300px;overflow:auto;">
			 		<table class="table" id=tablePatDetails>
			 			<bean:write name="mcPathLabReportDetailBean" property="strPatDtl" filter="false"/>
			 		</table>
			 	</div>	
			 	
			 	
		 	</fieldset>
		 	<hr>
		 	<div class="row rowFlex reFlex">
						<div class="col-sm-10"></div>
						<div class="col-sm-2" align="right"><font color="red">*</font>Fields Mandatory</div>				
				</div>
		 	</div>
	 	
	 	</div>
	 	
	 		
		<div class="modal fade" id="showReportPdfModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="height: 5px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>
					<div class="modal-body">
						<div class="text-center">
							<button type="button" class="btn btn-info"
								onclick="$('#showReportPdfModal').modal('hide');$('#printPrescFrameId').remove();">Cancel</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	 
	 	
	 	
	
	<input type="hidden" name="hmode" />
	 
	<input type="hidden" name="crNo" value="${mcPathLabReportDetailBean.strCrNo}" />
	<input type="hidden" name="strHiddenPatDtls" id="strHiddenPatDtls" value="" />
	 <input type="hidden" name="strUploadFileId" value= ""/>
	 
 
</fieldset>
<%-- <jsp:include page="/mms/transactions/abhaQmsIntegration.jsp"></jsp:include> --%>
</html:form>
<%-- <jsp:include page="/mms/transactions/abhaQmsIntegration.jsp" flush="true"></jsp:include>
 --%>
<script type="text/javascript">
	
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	
	</script>
	
</body>
</html>
