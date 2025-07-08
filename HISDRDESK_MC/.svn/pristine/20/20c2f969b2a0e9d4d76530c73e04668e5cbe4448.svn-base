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
<title>Sample Handover Details</title>
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

<script language="Javascript" src="../../hisglobal/js/validationCommon.js"></script>
<script type="text/javascript">


/* $(".timepicker").timepicker({
    timeFormat: 'HH:mm:ss', // Include seconds by adding ':ss' to the format
    step: 15, // This sets the step to 15 minutes
}); */


//JavaScript code
document.addEventListener("DOMContentLoaded", function () {
    const selectAllCheckbox = document.getElementById("selectAllCheckbox");
    const dataContainer = document.querySelector("tbody");

    selectAllCheckbox.addEventListener("change", function () {
        const dataCheckboxes = dataContainer.querySelectorAll("input[type='checkbox'][name='strHiddenValues']");
        dataCheckboxes.forEach((checkbox) => {
            checkbox.checked = selectAllCheckbox.checked;
        });
    });

    });





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
		let hiddenOtherDtl = $("#hiddenOtherDtl"+index).val();
		document.forms[0].crNo.value = strHiddenDtl.split("^")[0];
		document.forms[0].strCrNo.value = strHiddenDtl.split("^")[0];
		
		if (document.forms[0].strCrNo.value.length > 14) 
		{
			$("#strHiddenPatDtls").val(strHiddenDtl);
			$("#strHiddenOtherDtl").val(hiddenOtherDtl);
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

	function isNumberKey(evt) {
	    var charCode = (evt.which) ? evt.which : evt.keyCode;
	    var inputValue = evt.target.value;

	    // Check if the input length is already 10 characters
	    if (inputValue.length >= 10) {
	        return false;
	    }

	    if (charCode > 31 && (charCode < 48 || charCode > 57)) {
	        return false;
	    }

	    return true;
	}


	  


	function saveTheData(){
		
		
		var handoverToDet = document.getElementById("strHandoverToDet");
		var strDte = document.getElementById("strDte");
		var strTime = document.getElementById("strTime");
		var strRemarks = document.getElementById("strRemarks");
		var strHandoverToMobile= document.getElementById("strHandoverToMob");


		
		 const checkboxes = document.querySelectorAll("input[type='checkbox'][name='strHiddenValues']");
	    let atLeastOneCheckboxSelected = false;

	    checkboxes.forEach((checkbox) => {
	        if (checkbox.checked) {
	            atLeastOneCheckboxSelected = true;
	        }
	    });

	    if (!atLeastOneCheckboxSelected) {
	        alert("Please select at least one checkbox");
	        return;
	    }



	    if (handoverToDet === null || handoverToDet.value === "") {
	        alert("Please fill Handover To");
	        handoverToDet.focus();
	        return false;
	    }

	    if (strHandoverToMobile === null || strHandoverToMobile.value === "") {
	        alert("Please fill Handover To Mobile No.");
	        strHandoverToMobile.focus();
	        return false;
	    }

	    if (strRemarks === null || strRemarks.value === "") {
	        alert("Please fill Remarks");
	        strRemarks.focus();
	        return false;
	    }
	   
	   /* 
	    if (strTime === null || strTime.value === ""){
	    	alert("Please fill Handover Time");
	    	strTime.focus();
	    	return false;
		    } */


		 
		          var userResponse = confirm("Are you sure you want to save?");
		          if (userResponse) {
		        	  $('#savebutton').hide();
		        	  document.forms[0].hmode.value="save";
		        	  document.forms[0].submit();
		        	  
		              
		          } else {
		              
		              console.log("Save canceled.");
		              //$('#savebutton').show();
		          }
		      
		  

		    //$('#savebutton').hide();
		    
		
		// document.forms[0].hmode.value="save";	

		 //$('#savebutton').hide();		
		 		  
	     //document.forms[0].submit();
	     	

		}


		

	
	$(document).ready(function(){
		  $("#myInput").on("keyup", function() {
		    var value = $(this).val().toLowerCase();
		    $("#myTable tr").filter(function() {
		      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		    });
		  });
		}); 		


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
.divSize{
		width:60%;
		}
		
.timeSize{
		width:60%;
}



.prescriptionTile {
 	color:  #4a4645 ;
 } 
.table{
	color: #4a4645;
}
.fontred{
	color: red;
}
    </style>
    
</head>
<body >
<div id="mainDeskLoadingMsgDiv" style="display:none;width:100vw;height:100vh;position:fixed;z-index:99999; background-color:rgba(0,0,0,0.6)">
	<h2 class="text-center" style="color:white; margin-top:13%"><i class="fa fa-spinner fa-spin"></i> Loading...</h2>
</div>

<html:form name="mcPathLabSampleHandoverDetailFB" action="/transaction/MCPathLabSampleHandoverDetailTransMcNewCNT" type="new_opd.transaction.controller.fb.MCPathLabSampleHandoverDetailFB">
	<fieldset>
	
	
	<div class="prescriptionTile">
<center>
		<div id="errMsg" class="errMsg"><bean:write name="mcPathLabSampleHandoverDetailFB" property="strErrMsg" /></div>
		<div class="warningMsg"><bean:write name="mcPathLabSampleHandoverDetailFB" property="strWarningMsg" /></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="mcPathLabSampleHandoverDetailFB" property="strNormalMsg" /></div>	
	
		<%--< tag:tab tabLabel="Store Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>
</center>
</div>
	
	
	
		<legend class='legendHeader' id='nonPrintableLegend'>Sample Handover Details</legend>
		
		<div class="legend2" id='nonPrintableLegend2'>
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i><span class="popuptextToast">Cancel</span></div>
		</button>
		
		<button id="clearlButton" type="button" class="btn btn-warning mt-1 btn-circle clearbtn" onclick="">
		<img alt="Clear" src="/HIS/hisglobal/images/clear3.png" style="width: 23px; color: #fff;">
		</button>
				
	    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return  saveTheData();" >					
			<div class="popupToast"><i class="fa fa-save iround"  title="Save"></i> <span class="popuptextToast">Save</span></div>
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
	
		<div class="prescriptionTile" style="display:none;">
										 
			<div id="goBox">		 
				<div class="row rowFlex reFlex">
				 
				<div class="col-sm-1" align="right"><font id="mandCRId" color="red">*</font><label>CR No.</label></div>
					<div class="col-sm-3">
						<div id="patientCrEdId">
							<crNo:crNo value ="${mcPathLabSampleHandoverDetailFB.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
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
		 </div>
		
			<div class="prescriptionTile">	
			<fieldset>				
				
			<div class="row rowFlex reFlex" style="margin-top: 10px;">
				
				
					<div class="col-sm-2" style="color:black;">Sample Drawn Date</div>
					<div class="col-sm-2"><input class="form-control datepicker" name="strPresDate" id="strPresDate" value="${mcPathLabSampleHandoverDetailFB.strCtDate}" onchange="getPatDtls();"></div>
				<div class="col-sm-2" style="color:black;"> Search:</div>
				<div class="col-sm-4" style="color:black;">	<input  class="form-control "  id="myInput" type="text" placeholder="Search by CR No,Patient Name,Mobile No ">	</div>
				
				</div>
				
				
				<legend class='legendHeader' id='nonPrintableLegend' style="font-size: 1.2rem;color:black;">Patient List (Pending)</legend>
					<table class="table" style="margin-top: 10px;">
						<thead><tr>
							<th style="text-align:center;width:5%;color:black;"> <input type="checkbox" id="selectAllCheckbox">
							
							</th><th style="text-align:center;width:10%;color:black;">Vial Number
							</th><th style="text-align:center;width:25%;color:black;">Patient Name (CR No.)
							</th><th style="text-align:center;width:10%;color:black;">Mobile
							</th><th style="text-align:center;width:20%;color:black;">Gender/Age
							</th><th style="text-align:center;width:30%;color:black;">Test Name
							
							
							</th></tr>
						</thead>
					</table>
					
			 	<div id=divPatDetails style="max-height:250px;overflow:auto;">
			 		<table class="table" id=tablePatDetails>
			 			<bean:write name="mcPathLabSampleHandoverDetailFB" property="strPatDtl" filter="false"/>
			 		</table>
			 	</div>	
			 	
			 	
		 	</fieldset>
<!-- 		 	<hr> -->
<!-- 		 	<div class="row rowFlex reFlex"> -->
<!-- 						<div class="col-sm-10" onclick="showimg();">Show Help</div> -->
<!-- 						<div class="col-sm-2" align="right"><font color="red">*</font>Fields Mandatory</div>				 -->
<!-- 				</div> -->
		 	</div>
		 	
		 	
		 	<div class="prescriptionTile">	
			<fieldset>				
				
				<legend class='legendHeader' id='nonPrintableLegend' style="font-size: 1.2rem;color:black;">Handover Details</legend>
			
				<div class="row rowFlex reFlex" style="margin-top: 10px;">
				
				<div class="col-sm-2" style="color:black;"><font class="fontred">*</font> Handover To :</div>
				<div class="col-sm-4" style="color:black;">	<input  class="form-control divSize" name="strHandoverToDet" id="strHandoverToDet" type="text">	</div>
				</div>
				
				<div class="row rowFlex reFlex" style="margin-top: 10px;">
				
				<div class="col-sm-2" style="color:black;"><font class="fontred">*</font> Handover Person's Mobile No. :</div>
				<div class="col-sm-4" style="color:black;">	<input type="text" class="form-control divSize" name="strHandoverToMob" id="strHandoverToMob" onkeypress="return isNumberKey(event)">	</div>
				</div>
				
				<%-- <div class="row rowFlex reFlex" style="margin-top: 10px;">
				<div class="col-sm-2" style="color:black;"> Date & Time : </div>
					<div class="col-sm-2"><input class="form-control datepicker1" name="strDte" id="strDte" value="${mcPathLabSampleHandoverDetailFB.strCtDate}" ></div>
					
					<div class="col-sm-2"> <input class="form-control timeSize" name="strTime" id="strTime" type="time"></div>
				
				</div> --%>
				
				<div class="row rowFlex reFlex" style="margin-top: 10px;">
				
				<div class="col-sm-2" style="color:black;"><font class="fontred">*</font> Remarks :</div>
				<div class="col-sm-4" style="color:black;">	<input  class="form-control divSize" name="strRemarks" id="strRemarks" type="text">	</div>
				</div>
							
			 	<%-- <div id=divPatDetails style="max-height:250px;overflow:auto;">
			 		<table class="table" id=tablePatDetails>
			 			<bean:write name="mcPathLabSampleHandoverDetailFB" property="strPatIssuedDtl" filter="false"/>
			 		</table>
			 	</div>	 --%>
			 	
			 	
		 	</fieldset>
		 	</div>
	 	
	 	</div>
	
	<input type="hidden" name="hmode" />
	 
	<input type="hidden" name="crNo" value="${mcPathLabSampleHandoverDetailFB.strCrNo}" />
	<input type="hidden" name="strHiddenPatDtls" id="strHiddenPatDtls" value="" />
	<input type="hidden" name="strHiddenOtherDtl" id="strHiddenOtherDtl" value="" />
	 
 
</fieldset>
	
</html:form>
<%-- <jsp:include page="/mms/transactions/abhaQmsIntegration.jsp" flush="true"></jsp:include> --%>

<script type="text/javascript">
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true,
		     header: true,
		      footer: true ,
		      format: 'dd-mmm-yyyy',
			      });
	});

	var prescDate = $('.datepicker').val();
	$('.datepicker1').each(function(){
	    $(this).datepicker({ modal: true,
		     header: true,
		     footer: true ,
		      format: 'dd-mmm-yyyy',
		      minDate: prescDate
			      });


	      
	});
	
	</script>
	
</body>
</html>
