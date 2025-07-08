<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@page import="hissso.config.HISSSOConfig"%>
<!-- 

 ** Module 			 : INVESTIGATION
 ** Process  		 : View Result Report (Offline Result Entry)
 ** Developer		 : DEEPTI AGRAWAL, CDAC-NOIDA
 ** Date of Creation : 28.01.2021

 -->
 
<html>
<head>
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
  
  <script type="text/javascript" src="/HISInvestigationG5/hisglobal/js/dojotoolkit/dojo/dojo.js" djConfig="parseOnLoad: true"> </script>
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/jquery-1.11.1.min.js"></script>  
  
 <!--  Date Picker -->
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/jquery.dataTables.min.js"></script>
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap-datepicker.min.js"></script>
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap.min.js"></script>
  
  <script>
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

  function  getDetails()         
  {
 	 if ((document.getElementById("patCRNoId").value!="" || document.getElementById("patMobNoId").value !="")&& (document.getElementById("strFromDateId").value == "" || document.getElementById("strToDateId").value == ""))
 		 {
 		 	getPatientDetails();
 		 }
 	 else if (document.getElementById("patCRNoId").value =="" && document.getElementById("patMobNoId").value =="" && document.getElementById("strFromDateId").value != "" && document.getElementById("strToDateId").value != "")
 	 {
 		 getResultEntryList();
 		}
 	 else if(document.getElementById("patCRNoId").value =="" && document.getElementById("patMobNoId").value =="" && (document.getElementById("strFromDateId").value != "" && document.getElementById("strToDateId").value == ""))
 	 {
 		 alert("Please Select To Date !");
 			 }
 	 else if(document.getElementById("patCRNoId").value =="" && document.getElementById("patMobNoId").value =="" && (document.getElementById("strFromDateId").value == "" && document.getElementById("strToDateId").value != ""))
 	 {
 		 alert("Please Select From Date !");
 			 }
 	 else if (document.getElementById("patCRNoId").value =="" && document.getElementById("patMobNoId").value =="" && document.getElementById("strFromDateId").value == "" && document.getElementById("strToDateId").value == "")
 	 {
 		 alert("Please Select Either From-To Dates or Reg. Number or Mobile Number !");
 		}
 	 else if ((document.getElementById("patCRNoId").value !="" || document.getElementById("patMobNoId").value !="")&& (document.getElementById("strFromDateId").value != "" || document.getElementById("strToDateId").value != ""))
 	 {
 		 alert("Please Select Either From-To Dates or Reg. /Mobile Number, Not Both !");
 		}
 	 
  }
   

  // Function to get the result entries on the click of Get List for the selected dates. - Deepti 28.01.2021 
  function getResultEntryList()
  {
	  var flg=true;

	 /*  if(document.getElementById("strFromDateId").value != null && document.getElementById("strToDateId").value == null)
		  {
				alert("Please select to date !");
				flg=false;
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
 			flg=false;
 			return false;
		 }

	 if(flg==true)
		 {
		      document.forms[0].hmode.value = "unspecified";
			  document.forms[0].submit();
		  }
	  }

  function getPatientDetails()

  {
			var goFlg = '0';

		if (document.getElementById("patCRNoId").value!="")
			{
				if(document.getElementById("patCRNoId").value.length ==15)
					goFlg = '1';
				else	
					goFlg = '2';
			}
		else if (document.getElementById("patMobNoId").value!="")
		{
			if(document.getElementById("patMobNoId").value.length ==10)
				goFlg = '1';
			else	
				goFlg = '3';
		}
		
		if(goFlg == '2') {

				alert("Please Enter valid cr. Number");
				return;
			}
		if(goFlg == '3') {

			alert("Please Enter valid Mobile Number");
			return;
		}
		if(goFlg == '1'){

        	  var res = "";

var _mode = "getAllPatList";
var crNo = document.getElementById("patCRNoId").value;
var mobNo = document.getElementById("patMobNoId").value;
var ticket=$('#varSSOTicketGrantingTicket').val()
alert('ticket'+ticket)


var urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryViewTile.cnt?hmode="+_mode+"&cr_no="+crNo+"&mob_no="+mobNo+"&varSSOTicketGrantingTicket="+ticket;

var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
  load: function(data) 
	{
	res = data;
	},
    error: function(error)
    {
        alert("fail");
    }};
var objDojoAjax = dojo.xhrPost(objXHR);

document.getElementById("multiPatListDataId").innerHTML = res;

$('#multiplePatientListId').modal('show'); 
}
}

 
 function getPatDtl()
 {
	  var selVal="";
	  var selFlg= false;
	  var patdtlradio = document.getElementsByName("multiPat");
	 	for(var i=0;i< patdtlradio.length; i++)
		 	{
				if(patdtlradio[i].checked){
					selVal = patdtlradio[i].value;
					selFlg=true;
				}
		 	}
	 	if(selFlg==false){
				alert('Select a record to proceed !');
				return;
		 	}
	 	if(selFlg==true){
				var cr_no = selVal.split("$")[0].trim();
				var p_name = selVal.split("$")[1].trim();
				var p_gender = selVal.split("$")[2].trim();
				var p_age = selVal.split("$")[3].trim();
				var p_ageunit = selVal.split("$")[4].trim(); 
				var p_guardian = selVal.split("$")[5].trim();
				var p_coll_centre = selVal.split("$")[6].trim();
				var p_parent_hospital = selVal.split("$")[7].trim();
				var mob_no = selVal.split("$")[8].trim();
				var _mode = "showPatientDetail";
       		    var urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryViewTile.cnt?hmode="+_mode+"&cr_no="+cr_no+"&mob_no="+mob_no+"&p_name="+p_name+"&p_gender="+p_gender+"&p_age="+p_age+"&p_ageunit="+p_ageunit+"&p_guardian="+p_guardian+"&p_coll_centre="+p_coll_centre+"&p_parent_hospital="+p_parent_hospital;
       		    
				  var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
			  	  load: function(data) 
			  		{
			  		res = data;
			  		},
			          error: function(error)
			          {
			              alert("fail");
			          }};
				  var objDojoAjax = dojo.xhrPost(objXHR);
				  /* if(res.trim() == null || res.trim() == ""){
			
					  alert('No Record Found for the entered CR/Mobile Number !');
					  return;
				  }
 */			  	if(res.trim() != null || res.trim() != "") {
			  		document.getElementById("offlineResEntPatDtlDivId").innerHTML=res;
			  		document.getElementById("offlineResEntPatDtlDivId").style.display="";
			  		document.getElementById("offlineResEntListDivId").style.display="none";
			  		$('#multiplePatientListId').modal('hide');
			  		 
			  		$('#patTestListTable').dataTable( {
				        "scrollY":        100,
				        "jQueryUI":       true,
				        "paging":         false,   
				        "ordering": false,    
				        "filter": false, //for search feature.
				        "info": true,
				        "iDisplayLength":-1,
				        "columns": [              // for ordering 
				            { "orderable": false },            
				            { "orderable": false },
				            { "orderable": false },
				            { "orderable": false },
				            { "orderable": false },
				          ],        
				        "lengthMenu": [[-1], ["All"]]
				    });
				  		
		 	}
	 }
 }
  function cancelFunc()
  {
	  	document.forms[0].hmode.value="unspecified"; 
	  	document.getElementById("patCRNoId").value = "";
	  	document.getElementById("patMobNoId").value = "";
	  	document.forms[0].submit();
	  }

  function addDataTable(){
	
	   //Added for Data tables. 
	  $('#TablePatTestList').dataTable( {
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
  
  </script>
  
  <style>
   th, td {
   font-family: helvetica;
  padding: 2px;
  font-size: 12px;
}

.DataTables_sort_icon{
float:right;
}
  
  </style>
  
<title>View Offline Result Report</title>
</head>

<body onload= "addDataTable();" style="font-size: 12px;">

<form role="form" id="invOfflineReportViewId" action="" method="post" class="form-horizontal">
<!--<logic:equal name="InvOfflineResultEntryFB" property="strGoFlag" value="1">
						<div id="offlineResEntPatDtlDivId">
								<bean:write name="InvOfflineResultEntryFB" property="strOfflineResEntPatDtl" filter="false"/> 
						</div>
	</logic:equal>  -->
<div id="offlineResEntPatDtlDivId" style= "display: none">
								
						</div>

<div id="offlineResEntListDivId">
 <bean:write name="InvOfflineResultEntryFB" property="strResEntryList" filter="false"/> 
 </div>
 
 <div id = "multiplePatientListId" class="modal fade" role="dialog">
      <div class="modal-dialog modal-lg">
      <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            	<h5 class="modal-title" id="myModalLabel" style ="text-align: center">Patient(s) with Matching Reg./Mobile Number:</h5>
      		</div>
      		<!-- Modal body -->
      		<div class="modal-body" id = "multiPatListDataId">
          		 <bean:write name="InvOfflineResultEntryFB" property="strMultiPatList" filter="false"/> 
       		 </div>
      	</div>
      	</div>
      </div>
 
 <input type="hidden" name="hmode" />
  <input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value="<%=request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>"/>
 <input type="hidden" name="strGoFlag" value= ""/>
 <input type="hidden" name="strUploadFileId" value= ""/>
 
</form>
<script type="text/javascript">
$(document).ready(function() {
    $("#strFromDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});
    $("#strToDateId").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});
  });
  </script>
</body>
</html>