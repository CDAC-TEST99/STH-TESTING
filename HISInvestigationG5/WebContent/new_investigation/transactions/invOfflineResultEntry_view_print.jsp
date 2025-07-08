<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="new_investigation.InvestigationConfig"%>

<!-- 

 ** Module 			 : INVESTIGATION
 ** Process  		 : Offline Result Entry View Page
 ** Developer		 : DEEPTI AGRAWAL, CDAC-NOIDA
 ** Date of Creation : 21.01.2021

 -->

<html>
<head>
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  
   <!-- Datatable -->
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/smoothness/jquery-ui-1.10.4.custom.min.css">
   <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/dataTables.jqueryui.css">
   <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/alert/jquery-ui.min.css">
   
     <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/bootstrap.min.css">
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/AdminLTE.min.css">
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/bootstrap-datepicker.min.css">
  
   
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/jquery-1.11.1.min.js"></script> 
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/jquery-ui-1.10.4.custom.min.js"></script> 
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/jquery.dataTables.min.js"></script>
     
	<script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap-datepicker.min.js"></script>
  <script>

  function showHideDiv()
  {
	document.getElementById("offlineResEntPatDtlDivId").style.display="";
	document.getElementById("offlineResEntListDivId").style.display="none";
	
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
  			alert("No File to Download!!");			
  		}
  	
  }

  function getEntryList()
  {
	      /*  if(document.getElementById("strFromDateId").value.trim() == "" || document.getElementById("strFromDateId").value.trim() == null)
		      {
	    	  	alert("Enter From Date !");
	    	  	return false;
	 			//flg=false;
		      } 
	       if(document.getElementById("strToDateId").value.trim() == "" || document.getElementById("strToDateId").value.trim() == null)
		      {
	    	  	alert("Enter To Date !");
	 			//flg=false; 
		      }  */
	      if(document.getElementById("strFromDateId").value != null)
	    		var fromdtArr = document.getElementById("strFromDateId").value.split("-");
	    		var fmonth=fromdtArr[1];
	    		var fday=fromdtArr[0];
	    		var fyear=fromdtArr[2];

	    		var fromDt = new Date(fmonth+" "+fday+" "+fyear);

	    		if(document.getElementById("strToDateId").value != null)
	    		var todtArr = document.getElementById("strToDateId").value.split("-");
	    		var tmonth=todtArr[1];
	    		var tday=todtArr[0];
	    		var tyear=todtArr[2];

	    		var toDt = new Date(tmonth+" "+tday+" "+tyear);

	    		if(fromDt > toDt)
	    			{
	    	 			alert("From Date can not be greater than To Date !");
	    	 			return false;
	    			 }
	    		var hospital_code = document.getElementById("strPatHospCodeId").options[document.getElementById("strPatHospCodeId").selectedIndex].value;
	   			 
					if(hospital_code=="0") {
						
						document.forms[0].strGoFlag.value="0";
	  					document.forms[0].hmode.value="viewResultEntries"; 
	  					document.forms[0].submit();
					}
					else{
						
						getEntryListForHosp();
						}
	  }

  function cancelFunc()
  {
	  	document.forms[0].hmode.value="unspecified"; 
	  	document.forms[0].submit();
	  }
  
  function addDataTable(){
		
	   //Added for Data tables. 
	  $('#resultEntriesListTable').dataTable( {
       "scrollY":        270,
       "jQueryUI":       true,
       "paging":         false,   
       "ordering": true,    
       "filter": true, //for search feature.
       "info": true,
       "iDisplayLength":-1,
       "columns": [              // for ordering 
           { "orderable": true },            
           { "orderable": true },
           { "orderable": true },
           { "orderable": true },
           { "orderable": true },
           { "orderable": true },
           { "orderable": true },
           { "orderable": false },
         ],        
              
       "lengthMenu": [[-1], ["All"]]
   });
	    
}
  
   function resetFunc()
  { 
	  alert("resetFunc");
	 
  } 

 function getEntryListForHosp()
 {
	
	/* if((document.getElementById("strFromDateId").value != null || document.getElementById("strFromDateId").value != "") && (document.getElementById("strToDateId").value == null || document.getElementById("strToDateId").value == ""))
	{
		alert('Enter To Date !');
		return false;
	}

	if((document.getElementById("strFromDateId").value == null || document.getElementById("strFromDateId").value == "") && (document.getElementById("strToDateId").value != null || document.getElementById("strToDateId").value != ""))
	{
		alert('Enter From Date !');
		return false;
	} */

		 if(document.getElementById("strFromDateId").value != null)
 		var fromdtArr = document.getElementById("strFromDateId").value.split("-");
 		var fmonth=fromdtArr[1];
 		var fday=fromdtArr[0];
 		var fyear=fromdtArr[2];

 		var fromDt = new Date(fmonth+" "+fday+" "+fyear);

 		if(document.getElementById("strToDateId").value != null)
 		var todtArr = document.getElementById("strToDateId").value.split("-");
 		var tmonth=todtArr[1];
 		var tday=todtArr[0];
 		var tyear=todtArr[2];

 		var toDt = new Date(tmonth+" "+tday+" "+tyear);

 		if(fromDt > toDt)
 			{
 	 			alert("From Date can not be greater than To Date !");
 	 			return false;
 			 }

 		var fromDate1 = document.getElementById("strFromDateId").value;
 		var toDate1 = document.getElementById("strToDateId").value;
 			  	
 		var hospital_code = document.getElementById("strPatHospCodeId").options[document.getElementById("strPatHospCodeId").selectedIndex].value;

 		if(fromDt=="" || fromDt==null)
 			fromDt="-";
 		if(toDt=="" || toDt==null)
 			toDt="-";
			
		  var _mode = "viewResultEntries_onHospChange";
		  document.forms[0].strGoFlag.value="1";
		 var myUrl = "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode+"&hosp_code="+hospital_code+"&from_dt="+fromDt+"&to_dt="+toDt;
		  $.ajax({
	          type: "POST",
	          url: myUrl,
	          contentType: "html",
	          async: false,
	          success: function (data) {
		          
	          document.getElementById("offlineResEntPatDtlDivId").innerHTML = data;
	          }
	      }); 

	      document.getElementById("offlineResEntPatDtlDivId").style.display = "";
	      document.getElementById("offlineResEntListDivId").style.display = "none";
	      addDataTable();
	      // var lastDate = new Date();
	  	//	lastDate.setDate(lastDate.getDate() - 7);  //Date of 7 date before.

	  		$("#strFromDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',}).datepicker('setDate', fromDate1);
	      	$("#strToDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',}).datepicker("setDate", toDate1);
	 }

 function modifyRecord(obj,cr_No,mob_No,req_No,isModified,entryDt){

	 alert('entryDt = '+entryDt);
	 
	 if(isModified=='1')
		 {
			alert('Modification is allowed only once !');
			return;
		 }
	 
		document.forms[0].patCRNo.value = cr_No;
		document.forms[0].reqNo.value = req_No;
		document.forms[0].patMobNo.value = mob_No;
		
		document.forms[0].hmode.value="modify"; 
		document.forms[0].submit();

 	}

  </script>
  
  <style>
  th, td {
  padding: 2px;
  font-size: 12px;
}

.DataTables_sort_icon{
float:right;
}
  
  input{font-color: black;}
  </style>
  </head>
<body onload= "addDataTable();" style="font-size: 12px;">

<form role="form" id="invOfflineViewId" action="" method="post" class="form-horizontal">

<%-- Not Reqd As CR NUMBER input is removed from the page.  
	<logic:equal name="InvOfflineResultEntryFB" property="strGoFlag" value="1"> --%>
						<div id="offlineResEntPatDtlDivId" style= "display:none;">
								<bean:write name="InvOfflineResultEntryFB" property="strOfflineResEntPatDtl" filter="false"/> 
						</div>
<%-- 	</logic:equal>  --%>
<logic:equal name="InvOfflineResultEntryFB" property="strGoFlag" value="0">
<div id="offlineResEntListDivId">
 <bean:write name="InvOfflineResultEntryFB" property="strResEntryList" filter="false"/> 
 </div>
 </logic:equal> 
 
 <input type="hidden" name="hmode" />
 <input type="hidden" name="strGoFlag" value= ""/>
 <input type="hidden" name="strUploadFileId" value= ""/>
 
 <input type = "hidden" name="patCRNo" value= ""/>
 <input type = "hidden" name="reqNo" value =""/>
 <input type = "hidden" name="patMobNo" value =""/> 
 </form>
 
 <script type="text/javascript">
$(document).ready(function() {

	var lastDate = new Date();
	lastDate.setDate(lastDate.getDate() - 7);  //Date of 7 date before.

	$("#strFromDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});//.datepicker('setDate', lastDate);
    $("#strToDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});//.datepicker("setDate", 'now');
  });
  
  </script>
</body>
</html>
