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
<title>Sample Collection</title>
<link href="../css/master.css" rel="stylesheet" type="text/css">
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


//var url = "/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?vialSeries=N";
//var urlParams = new URLSearchParams(url.substring(url.indexOf('?')));
//var vialSeries = urlParams.get('vialSeries');

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


function validateInputLength(inputId) {
   // var inputValue = document.getElementById("strVialNo"+inputId).value;

    var inputValue = $("#strVialNo" + inputId).val();
   // alert("inputId::"+inputId);
	
	//alert("VALUE::::"+$("#strVialNo" + inputId).val())
   if (inputValue.length!='' && inputValue.length != 8) {
        alert("Please enter exactly 8 characters.");
        $("#strVialNo" + inputId).val('');
      //  $("#strVialNo" + inputId).focus();
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

function onClickTestDtl(index)
{
	var count = 0;
	//alert(index);
	//$("input[name=strVialNo]")[index].readOnly = false;
	
	containerTypeId = $("input[name=strTestCode]")[index].value.split("^")[1];
	//alert("containerTypeId::"+containerTypeId);
	//alert($("#strVialNo"+containerTypeId+"-0"));

	
	var strVial = $("#strVialNo"+containerTypeId+"-0");
	//alert(strVial);
	strVial.attr("readonly", false);
	strVial.css("background-color","lightblue");
	
	//alert("#strTestCode"+containerTypeId+"-0"+$("#strTestCode"+containerTypeId+"-0"));
	
	//alert("strTestCode.checked::"+$("input[name=strTestCode]")[index].checked);
	
	if($("input[name=strTestCode]")[index].checked==false)
	{
		$('input[name=strTestCode]').each(function (i) {		
			 
			 if($("input[name=strTestCode]")[i].value.split("^")[1] == containerTypeId)
			 {
				 if (this.checked) {
					 $("input[name=strTestCode]")[i].prop("checked", false );
					 count++;
				 }
			 }
			 //alert("count::"+count);
		}); 
		
		if (count==0) {
			strVial.val("");
			strVial.attr("readonly", true);		
			//alert(strVial);
			strVial.css("background-color","");
		}
	}
	else if($("input[name=strTestCode]")[index].checked==true)
	{
		$('input[name=strTestCode]').each(function (i) {		
			 
			 if($("input[name=strTestCode]")[i].value.split("^")[1] == containerTypeId)
			 {
				 if (!this.checked) {
					 
					 if(typeof $("input[name=strTestCode]")[i]["checkbox"]!='undefined')
					 $("input[name=strTestCode]")[i].prop("checked", true );
				 }
			 }
			 //alert("count::"+count);
		});
	}	
	
	
}

	function openPrescribedTestDtl(index){
	 
		$('#mainDeskLoadingMsgDiv').show();
// 		alert("index:"+index);
		let strHiddenDtl = $("#strHiddenDtl"+index).val(); // crNo
		let hiddenOtherDtl = $("#hiddenOtherDtl"+index).val(); ////hrgnum_puk ^ hospCode ^ hrgnum_requisition_no ^ hrgdt_requisition_date
		document.forms[0].crNo.value = strHiddenDtl.split("^")[0];
		document.forms[0].strCrNo.value = strHiddenDtl.split("^")[0];
		
		$("#strHiddenPatDtls").val(strHiddenDtl);
		$("#strHiddenOtherDtl").val(hiddenOtherDtl);
		
		//var url = "/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?vialSeries=N";
		//var urlParams = new URLSearchParams(url.substring(url.indexOf('?')));
		//var vialSeries = urlParams.get('vialSeries');
		//alert("vialSeries"+vialSeries)
		
		var url1="/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?hmode=getPrescribedTestDtl&hiddenOtherDtl="+window.btoa(hiddenOtherDtl);     
 		// alert(url1);
		 
		 $.ajax({
			  url: url1,
			  success:function(data){
				  
				  //alert("hi::"+data);
					objVal= document.getElementById("tablePatPrescribedDetails"); 
					objVal.innerHTML = data; 
					$('#mainDeskLoadingMsgDiv').hide();
				  }
			});		 
		 
		/* if (document.forms[0].strCrNo.value.length > 14) 
		{
			$("#strHiddenPatDtls").val(strHiddenDtl);
			$("#strHiddenOtherDtl").val(hiddenOtherDtl);
			document.forms[0].hmode.value = "issueToPatGo";
			document.forms[0].submit();
		
		} else {
			alert("Please Enter Valid Cr No.");
			$('#mainDeskLoadingMsgDiv').hide();
			return false;
		} */
	}

	function getPatDtls(){

		$('#mainDeskLoadingMsgDiv').show();
		document.forms[0].hmode.value = "unspecified";
		document.forms[0].submit();
	}
	
	
function onBlurMethod(index)
{
	var count = 0;
	var prevContainerTypeId=0;
	var containerTypeId=0;
	var vialNo;
	var strVial;
	var breakOut=false;		
	var currentVialNo='',currentContainerId=0;
	
	//alert("index::"+index);
	
	currentVialNo = $("#strVialNo"+index).val();
	currentContainerId = index.split("-")[0];
	
	//alert("currentVialNo::"+currentVialNo);
	//alert("currentContainerId::"+currentContainerId);
	//alert("currentVialNo123::"+vialSeries+currentVialNo);	
	//alert("currentVialNo::"+currentVialNo);
	var completeVial= currentVialNo;
	
	if(currentVialNo=='')
		return false;
		
	$('input[name=strTestCode]').each(function (i) {
		containerTypeId = $("input[name=strTestCode]")[i].value.split("^")[1];
		
		if(containerTypeId!=prevContainerTypeId)
			{
   			vialNo = $("input[name=strVialNo]")[i].value;
   			
   				if(containerTypeId!=currentContainerId)
				{
					if(vialNo==currentVialNo)
					{
						alert("Duplicate Vial No.");
						$("#strVialNo"+index).val('');
						breakOut = true;
						return false;
					}
				}
			}
   		else
			{
//   		 	$('input[name="strVialNo"]')[i].value = vialNo;
			}
		prevContainerTypeId = containerTypeId;			
				
	}); 

	
	var myURL="/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?hmode=checkDuplicateVial&completeVial="+completeVial+"&index="+index; 
	
	$.ajax({
		  url: myURL,
		  success:function(data){

			 // alert("URL: " + myURL);
			 // console.log("MYDATA"+data)
				var nCount = data.split("^")[0];
				var nindex = data.split("^")[1];

			if(nCount>0){
						alert("This Vial No. already exists.")
						$("#strVialNo"+nindex).val('');
						//breakOut = true;
						$("#strVialNo"+index).focus();
						return false;
				}
			  
			  
			  }
		});
}




function onSaveCheckDuplicateVial(strVials){
    var index =0;

    var strVials='';
	
	$('input[name=strVialNo]').each(function() {
	   
	    if(this.value!='')
	    {
		   
		    if(strVials=='')
			{
		    	strVials = this.value;
			}
		    else{    
	    		strVials = strVials+','+ this.value;
		    }
	    }
	    
	    
	});
	
	var myURL="/HISDRDESK_MC/new_opd/transaction/MCPathLabSampleDrawnDetailCNT.cnt?hmode=checkDuplicateVial&completeVial="+strVials+"&index="+index; 

	
	
	$.ajax({
		  url: myURL,
		  success:function(data){

			 // alert("URL: " + myURL);
			 // console.log("MYDATA"+data)
				var nCount = data.split("^")[0];
				var nindex = data.split("^")[1];

			if(nCount>0){
						alert("This Vial No. already exists.")
						$("#strVialNo"+nindex).val('');
						//breakOut = true;
						$("#strVialNo"+index).focus();
						return false;
				}
			else{
				onSave();
				}
			  
			  
			  }
		});

	
}



function onSave(){

		var count = 0;
		var prevContainerTypeId=0;
		var containerTypeId=0;
		var vialNo;
		var strVial;
		var breakOut=false;			
					
		
		

				//onSaveCheckDuplicateVial(strVials)
			//	alert("vials>>"+strVials);

		
		$('input[name=strTestCode]').each(function (i) {
			containerTypeId = $("input[name=strTestCode]")[i].value.split("^")[1];
			
			if(containerTypeId!=prevContainerTypeId)
   			{
	   			vialNo = $("input[name=strVialNo]")[i].value;
	   			
	   			if (this.checked) {
       	   		 	strVial = $("#strVialNo"+containerTypeId+"-0");
       	   		 
		           	if(strVial.val()=='')
		       	   	{
			       	   	alert("Please enter Vial No.");
			       	   	$(strVial).focus();
			       	   	breakOut = true;
		    	   	   	return false;
		       	   	}
		            	count++;
		        }
	   			else
	   			{
	   				$("input[name=strVialNo]")[i].disabled = true;
	   			}	
   			}
	   		else
   			{
	   			//$("input[name=strVialNo]")[i].value
	   		 	$('input[name="strVialNo"]')[i].value = vialNo;
	   			if(vialNo=='')
	   			{
	   				$("input[name=strVialNo]")[i].disabled = true;
	   			}	
   			}
			prevContainerTypeId = containerTypeId;
		});     
		
		if(breakOut) {
			//alert("inside :: breakOut");
			$('input[name=strTestCode]').each(function (i) {
	        	   $("input[name=strVialNo]")[i].disabled = false;			        		   
			});
			
		    breakOut = false;
		    return false;
		} 
		
		
		/* $('input[name=strTestCode]').each(function (i) {
	           if (!this.checked) {
 	        	   	$("input[name=strVialNo]")[i].disabled = true;
	           }	           
		}); */
		
		
		/* $('input[name=strTestCode]').each(function (i) {
				alert( $(this).val() );
			
	           if (this.checked) {
	        		alert("strVialNo"+i+"::"+$("input[name=strVialNo]")[i].value);   
	           }
		}); 
		
		 $("input[name=strVialNo]").each( function () {
		       alert( $(this).val() );
		       count++;
		   }); 
		*/
		
		if(count==0){

				$('input[name=strTestCode]').each(function (i) {
			        	   $("input[name=strVialNo]")[i].disabled = false;	
				}); 
				
				alert("Please Select a Test to Add");
				return false;
			}
		else{

		$('#mainDeskLoadingMsgDiv').show();
 
		 document.forms[0].hmode.value="save";						  
 	     document.forms[0].submit();
		}	 
	
}
	
/* 
	function getAjaxResponse(res,mode)
	{
			var objVal;
		   if(mode=="1"){   
		   		var err = document.getElementById("errMsg");
			 		var temp1 = res.split("####");
				         
	        		 if(temp1[0] == "ERROR"){
	         			err.innerHTML = temp1[1];	
	        			 }
					else{
						alert("hi");
					objVal= document.getElementById("tablePatPrescribedDetails"); 
					objVal.innerHTML = res; 
					}
			 }
			
	}	 */
	
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

.prescriptionTile {
 	color:  #4a4645 ;
 } 
.table{
	color: #4a4645;
}
    </style>
    
</head>
<body >
<div id="mainDeskLoadingMsgDiv" style="display:none;width:100vw;height:100vh;position:fixed;z-index:99999; background-color:rgba(0,0,0,0.6)">
	<h2 class="text-center" style="color:white; margin-top:13%"><i class="fa fa-spinner fa-spin"></i> Loading...</h2>
</div>

<html:form name="mcPathLabSampleDrawnDetailFB" action="/transaction/MCPathLabSampleDrawnDetailCNT" type="new_opd.transaction.controller.fb.MCPathLabSampleDrawnDetailFB">
	<fieldset>

<div class="prescriptionTile">
<center>
		<div id="errMsg" class="errMsg"><bean:write name="mcPathLabSampleDrawnDetailFB" property="strErrMsg" /></div>
		<div class="warningMsg"><bean:write name="mcPathLabSampleDrawnDetailFB" property="strWarningMsg" /></div>
		<div id="normalMsg" class="normalMsg"><bean:write name="mcPathLabSampleDrawnDetailFB" property="strNormalMsg" /></div>	
	
		<%--< tag:tab tabLabel="Store Master" selectedTab="FIRST" align="center" width="TABLEWIDTH"></tag:tab> --%>
</center>
</div>	
		<legend class='legendHeader' id='nonPrintableLegend'>Sample Collection</legend>
	 <div class="legend2" id='nonPrintableLegend2'>
		
		<button id="cancelButton" type="button" class="btn btn-outline-danger mt-1 btn-circle cancelbtn" onclick="cancelFunc();">
		<div class="popupToast"><i class="fa fa-ban iround"  title="Cancel"></i>
		<span class="popuptextToast">Cancel</span>
		</div>
		</button>	
<!-- 		<button  id="printbutton" type="button" class="btn btn-outline-primary mt-1 btn-circle printbtn" data-toggle="modal" data-target="" style="background-color:#2e79b4;" onClick="showSlip();" > -->
<!-- 			<div class="popupToast"><i class="fa fa-print iround"  title="Print Last Voucher"></i> <span class="popuptextToast">Print</span></div> -->
<!-- 		</button>		 -->
	    <button  type="button" id="savebutton" class="btn btn-outline-success mt-1 btn-circle savebtn"  tabindex='2' onClick="return  onSaveCheckDuplicateVial();"   data-toggle="" data-target="#previewModal" >					
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
							<crNo:crNo value ="${mcPathLabSampleDrawnDetailFB.strCrNo}" js=" onkeypress='return initGoFunc(event);'"></crNo:crNo>
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
				
				
					<div class="col-sm-2" style="color:black;">Visit Date</div>
					<div class="col-sm-2"><input class="form-control datepicker" name="strVisitDate" id="strVisitDate" value="${mcPathLabSampleDrawnDetailFB.strCtDate}" onchange="getPatDtls();"></div>
				<div class="col-sm-2" style="color:black;"> Search:</div>
				<div class="col-sm-4" style="color:black;">	<input  class="form-control "  id="myInput" type="text" placeholder="Search by CR No,Patient Name,Mobile No ">	</div>
				
				</div>
				
				
				<legend class='legendHeader' id='nonPrintableLegend' style="font-size: 1.2rem;color:black;">Patient List (Pending)</legend>
					<table class="table" style="margin-top: 10px;">
						<thead><tr>
							<th style="text-align:center;width:10%;color:black;">#
							</th><th style="text-align:center;width:10%;color:black;">Select
							</th><th style="text-align:center;width:20%;color:black;">CR No.
							</th><th style="text-align:left;width:20%;color:black;">Patient Name
							</th><th style="text-align:center;width:20%;color:black;">Gender/Age							
							</th><th style="text-align:center;width:20%;color:black;">Mobile No
							</th></tr>
						</thead>
					</table>
					
			 	<div id=divPatDetails style="max-height:250px;overflow:auto;">
			 		<table class="table" id=tablePatDetails>
			 			<bean:write name="mcPathLabSampleDrawnDetailFB" property="strPatDtl" filter="false"/>
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
				
				<legend class='legendHeader' id='nonPrintableLegend' style="font-size: 1.2rem;color:black;">Prescribed Test List</legend>
					<table class="table" style="margin-top: 10px;">
						<thead><tr>
							<th style="text-align:center;width:10%;color:black;">Vial/Container</th>
							<th style="text-align:center;width:10%;color:black;">Collected</th>
							<th style="text-align:center;width:20%;color:black;">Test Name</th>
							<th style="text-align:center;width:15%;color:black;">Vial No. <br> (0-9/A-Z,8 digit)</th>
						</tr></thead>
					</table>
					
			 	<div id=tablePatPrescribedDetails style="max-height:250px;overflow:auto;">
			 		
			 	</div>	
			 	
			 	
		 	</fieldset>
		 	</div>
	 	
	 	</div>
	
	<input type="hidden" name="hmode" />
	 
	<input type="hidden" name="crNo" value="${mcPathLabSampleDrawnDetailFB.strCrNo}" />
	<input type="hidden" name="strHiddenPatDtls" id="strHiddenPatDtls" value="" />
	<input type="hidden" name="strHiddenOtherDtl" id="strHiddenOtherDtl" value="" />
	<input type="hidden" name="strVialSeries" id="strVialSeries" value="${mcPathLabSampleDrawnDetailFB.strVialSeries}" />
	
	 
 
</fieldset>
	
</html:form>


<script type="text/javascript">
	
	$('.datepicker').each(function(){
	    $(this).datepicker({ modal: true, header: true, footer: true ,format: 'dd-mmm-yyyy'});
	});
	
	</script>
	
</body>
</html>
