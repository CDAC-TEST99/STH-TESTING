<%@page import="hissso.config.HISSSOConfig"%>
<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.UserVO"%>
<%@page import="hisglobal.presentation.WebUTIL"%>
<%@page import="new_investigation.vo.NEWOfflineResultEntryVO"%>
<%@page import="new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB"%>
<%@page import="new_investigation.vo.LabTestVO"%>

<%@taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/HisTools.tld" prefix="his"%>

<%-- <%@page import="new_investigation.InvestigationConfig"%>    --%>   
<%@page import="java.util.*"%>
<%@page import="java.text.DateFormat"%>
 <%@page import="java.text.SimpleDateFormat"%>
<%-- <%@page import="com.ibm.icu.text.SimpleDateFormat"%> --%>
<%@page import="java.util.Date"%>

<%@page import="hisglobal.hisconfig.Config"%>

<%@page import="new_investigation.transactions.controller.fb.NEWOfflineResultEntryFB"%>

<head>
  <title>NEW Offline Result Entry</title>
  <meta charset="ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/new_investigation/media/jquery-ui/1.12.1/external/jquery/jquery.js"></script>
  <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/new_investigation/media/jquery-ui/1.12.1/jquery-ui.min.js"></script>

  <link rel="stylesheet" href="  /HISInvestigationG5/new_investigation/media/jquery-ui/1.12.1/jquery-ui.min.css">

   
     <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/bootstrap.min.css">
  <link rel="stylesheet" href="/HISInvestigationG5/hisglobal/css/AdminLTE.min.css">
  
   
   
   
     
	

<script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap.min.js"></script>
    <link href="/HISInvestigationG5/hisglobal/css/mainDesk.css" rel="stylesheet" type="text/css" />
 
 
 
  


 
  <link rel="stylesheet" type="text/css"	href="/HIS/hisglobal/drDeskAssets/css/style.css">
  <link rel="stylesheet"	href="/HIS/hisglobal/drDeskAssets/css/perfect-scrollbar.css">
  <link rel="stylesheet"	href="/HIS/hisglobal/drDeskAssets/uikit/css/uikit.min.css" />
  <link rel="stylesheet"	href="/HISInvestigationG5/new_investigation/media/prashantUIUX/borderUtilities/css/borderUtilities.css" />
  
   <!--Bootstrap Datables -->
  <link href="media/dataTables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <link href="/HISInvestigationG5/new_investigation/media/dataTables/DataTables-1.10.18/css/dataTables.searchHighlight.css" rel="stylesheet" type="text/css" />
  
  <script src="media/dataTables/DataTables-1.10.18/js/jquery.dataTables.min.js" type="text/javascript"></script>
  <script src="media/dataTables/DataTables-1.10.18/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
  
  <!--Bootstrap Datables FixedHeader -->
  <link href="media/dataTables/FixedHeader-3.1.4/css/fixedHeader.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/FixedHeader-3.1.4/js/dataTables.fixedHeader.min.js" type="text/javascript"></script>
  <script src="media/dataTables/FixedHeader-3.1.4/js/fixedHeader.bootstrap4.min.js" type="text/javascript"></script>
  
   <!--Bootstrap Datables Responsive -->
  <link href="media/dataTables/Responsive-2.2.2/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/Responsive-2.2.2/js/dataTables.responsive.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Responsive-2.2.2/js/responsive.bootstrap4.min.js" type="text/javascript"></script>
  <script src="/HISInvestigationG5/new_investigation/media/dataTables/DataTables-1.10.18/js/dataTables.searchHighlight.min.js" type="text/javascript"></script>  
  
  
  

<style>
.body{
letter-spacing: 1;
}
.lblstyle{
	color: #0b3da1; font-weight: bold; padding-top: 0;
}
.table {
font-size: 14px;
}
</style>

<script>
$(document).ready(function () {
	$('#fromDate').datepicker({
		maxDate: 0, 
		minDate: -365,
		changeMonth : true,
		changeYear : true,
		dateFormat:"d-M-yy",
		 onSelect: function(selected) {
				var shouldBeLessThanField=$('#toDate').val();
				if(shouldBeLessThanField!=""){
					$('#toDate').datepicker("option","minDate", selected);
				}
				generatePatientList()
				
			 }
		});

	$('#toDate').datepicker({
		maxDate: 0, 
		minDate: -365,
		changeMonth : true,
		changeYear : true,
		dateFormat:"d-M-yy",
		 onSelect: function(selected) {
			var shouldBeGreaterThanField=$('#fromDate').val();
			if(shouldBeGreaterThanField!=""){
					$('#fromDate').datepicker("option","maxDate", selected);
			}
			generatePatientList();
				
		}
		});


if($('#patDeptUnitCode').val('ALL')){
	generatePatientList();
}

$('#patDeptUnitCode').change(generatePatientList);

});	
function generatePatientList(){
	//alert("test");
	$('#divtablePatientList').html("&nbsp;");
	if($('#patDeptUnitCode').val()=="" ||$('#fromDate').val()=="" || $('#toDate').val()=="" ){
		return;
	}
	var data ={
			patDeptUnitCode:$('#patDeptUnitCode').val(),
			fromDate:$('#fromDate').val(),
			toDate:$('#toDate').val(),
			hmode:"GET_PATIENT_LIST",
			varSSOTicketGrantingTicket:$('#varSSOTicketGrantingTicket').val()
		}
	var html="<table class='table uk-card-default' id='tablePatientList'>";
	html+="<thead>";
	html+="<tr>";	
	html+="<th scope='col' class='control-label '>S.No.</th>";
	html+="<th scope='col'>Name</th>";
	html+="<th scope='col'>Cr.No.</th>";
	html+="<th scope='col'>Gen/Age/Cat/Mobile</th>";
	html+="<th scope='col'>Dept/Unit</th>";
	html+="<th scope='col'>Visit Date</th>";
	html+="<th scope='col'>Action</th>";
	html+="<th scope='col'>Report</th>";
	html+="</tr>";
	html+="</thead>";
	html+="<tbody>";	   
	html+="</tbody>";
	html+="</table>";
	$('#divtablePatientList').html(html);
	$.ajax({url:'/HISInvestigationG5/new_investigation/NEWOfflineResultEntry.cnt',
		dataType: "json",
		data:data,
		type: "POST",		
		success:function(json){
			//console.log(JSON.stringify(json)); 
			var flagDataFound=false;
			$.each(json,function(indx, objjson){
			  flagDataFound=true;
			  var crno=objjson["Cr.No."]
			  
			  /* $('#crnum').val(crno) */

			  html="";
			  html+="<tr>";
			  
			  html+="<td>"+objjson["S.No."]+"</td>";
			  html+="<td>"+objjson["Name"]+"</td>";
			  html+="<td>"+objjson["Cr.No."]+" <input type='hidden' name='ptcr' id='ptcr' value='"+crno+"'</td>";
			  html+="<td>"+objjson["Gen/Age/Cat/Mobile"]+"</td>";
			  html+="<td>"+objjson["Dept/Unit"]+"</td>";
			  html+="<td>"+objjson["visitDate"]+"</td>";			  
			  html+="<td><a style='cursor: default;' class='btn btn-info btn-sm text-white' id='btn_"+indx+"' onclick='openResultEntryPage(this)'>Enter Lab Test</a>";
			  html+="<td><a style='cursor: default;' class='btn btn-info btn-sm text-white' id='btn_"+indx+"' onclick='getOfflineLabTestData(this)'> Lab Report</a>";	
			 html+="<input type='hidden' name='json' id='json_"+indx+"' value='"+JSON.stringify(objjson)+"'>";	
			  html+="</td>";
			  html+="</tr>";

			    $('#tablePatientList tbody').append(html);
			});
			
			if(flagDataFound==false){
				html="<tr>";
				  html+="<td colspan='7' class='text-center text-danger' style='font-weight: bold;'>No Record Found</td>";
				html+="</tr>";  
			    $('#tablePatientList tbody').append(html);
			}
			else{
				var record=10;
				var dataTableConfiguration={
						 "paging": true,
						 "destroy":true,
					       responsive: true,
					       "searching": true,
					       searchHighlight: true,
					       "aaSorting": [],
					       "lengthMenu": [[record, record+15, record+40, -1], [record, record+15, record+40, "All"]]
				}
				$('#tablePatientList').DataTable(dataTableConfiguration);
			}
		}
	});
} 
function openResultEntryPage(objbtn){
	//alert("i.3");
	var indx=$(objbtn).attr("id").split("_")[1];
	var json=JSON.parse($('#json_'+indx).val());
	console.log("json"+json);
	

	$('#patCrNo').val(json["Cr.No."]);
	
	
	
	$('#patEpisodeCode').val(json["episodecode"]);
	$('#patVisitNo').val(json["visit_no"]);
	//$('#hmode').val("NEW");
   
	$('#hmode').val("PatientwiseDtl");
	
	
	
	document.forms[0].submit();

}
function openResultEntryPageWithoutCRNO(){
	$('#hmode').val("NEW");


	document.forms[0].submit();
}


function getOfflineLabTestData(objbutton){

	var id= objbutton.id.split("_")[1];
	var json= $('#json_'+ id).val()!=""?JSON.parse($('#json_'+ id).val()):{};
	//alert(json);  
	

    $('#investigationLabReportModal').modal('show');
	
	
	
	var labTestData="";

	
	var data={
			"crNoSelected": json["Cr.No."] ,
			"episodeCode":json["episodecode"],
			"patEpisodeVisitNo":json["visit_no"],
			"hospitalCode":json["gnum_hospital_code"],
			"hmode":"getOfflineLabTestData",
			
	}
	
	console.log("data---------------1----->"+JSON.stringify(data))
	
	
	
	$.ajax({url:'/HISInvestigationG5/new_investigation/NEWOfflineResultEntry.cnt',
		dataType: "json",
		data:data,
		type: "POST",
		success:function(result){
			
			//alert("Inside success"+JSON.stringify(result));
			//console.log("JSON.stringify(result)"+JSON.stringify(result))
			$("#labDataRecordDtl").val("1");
			for(var i=0;i<result.length;i++){
				console.log("result[i]"+result[i]);
				var resultReport=result[i].reportFileName;
				//var resultReportFinal=JSON.stringify(resultReport);
					labTestData+="<tr >";
					labTestData+="<td>"+result[i].laboratoryName+"</td>"
								+"<td>"+result[i].testName+"</td>"
								+"<td>"+result[i].TestDate+"</td>"    
								+"<td><button type='button' id='viewButton' class='btn btn-info AddToggleClass' onclick='view_Lab_Report("+JSON.stringify(resultReport)+")'>View Report</button></td>"
								labTestData+="</tr>";
	
			}
			//console.log("data-------------------->"+JSON.stringify(data))
			$('#offlineLabTestDataTable').html(labTestData);
			
			
		}
	}); 
	
	 
}


function view_Lab_Report(reportFileName){
	//alert("inside view_Lab_Report !");
	//alert("reportFileName" + reportFileName);
	document.forms[0].action ='/HISInvestigationG5/new_investigation/NEWOfflineResultEntry.cnt?fileName='+reportFileName+'';
	document.forms[0].hmode.value = 'view_Lab_Report';
		
	document.forms[0].submit();
}





</script>


</head>
<body >

<html:form action="/NEWOfflineResultEntry">

<fieldset class="m-2 px-1">
	<legend>
	
		<div class="container-fluid my-0 noUserSelect mx-0 px-0" id="container1">
			<div class="row align-items-center no-gutters"><!--  px-1 px-md-2  -->
			
				<div class="col-8 col-sm-6 col-md-3 col-lg-3 textFit">
					<p class="text-nowrap"  style="font-family:averta-extrabolduploaded_file;text-decoration: none; color: rgba(23, 97, 194, 0.74); font-weight: bold; font-size: 20px;">
						<span class="text-primary"><img  src='..\new_investigation\media\images\blood-sample.png'></span>
						Offline Result Entry 
						<span class="fullScreenBtn"><img height="26" width="26" src='..\new_investigation\media\images\expand.svg'></span>
					</p>
				</div>
				<div class="col-3 col-sm-5 col-md-8 col-lg-8 d-flex justify-content-end mb-3">
					<hr class="lineBetween" style="margin-top: 10px;">					
				</div>
				<div class="col-1 col-sm-1 col-md-1 col-lg-1  mb-3" style='margin-left: -26px;'>
					<a style='cursor: default;' class='btn btn-info btn-sm text-white'  onclick='openResultEntryPageWithoutCRNO()'>New Result Entry</a>
				</div>
			</div>
		</div>
	</legend>
	<div id="page-content-wrapper" style="background-color: #eaeef3;">
		<div class="container-fluid">
		<div class="card uk-card-default">
			  <div class="card-header bg-white">
			  	 	<div class="row">
			   		 	<div class="col-md-10">&nbsp;</div>
			   		 	<div class="col-md-2 text-center">
			   		 		
			   		 	</div>
			   		</div>
			   	<div class="row">
			   		 <div class="col-md-3 position-relative">
					    <label for="patDeptUnit"  class="form-label control-label lblstyle ">DEPT/UNIT</label>
					    <html:select property="patDeptUnitCode" name="NEWOfflineResultEntryFB" styleId="patDeptUnitCode" styleClass="form-control">
					    	<html:option value="ALL">All</html:option>
						    <logic:notEmpty name="LSTDEPARTMENTUNITLIST">
					     		<html:options collection="LSTDEPARTMENTUNITLIST" property="value" labelProperty="label" />
					    	</logic:notEmpty>	
					    	<logic:empty  name="LSTDEPARTMENTUNITLIST">
					    		<html:option value="">No Records</html:option>
					    	</logic:empty>
					    </html:select>					  				    
					</div>
					<div class="col-md-2 position-relative">
					    <label for="fromDate"  class="form-label control-label lblstyle ">From Date</label>
					    <html:text property="fromDate" name="NEWOfflineResultEntryFB" styleId="fromDate" styleClass="form-control"></html:text>
					    					    
					</div>
					<div class="col-md-2 position-relative" >
					    <label for="toDate"  class="form-label control-label lblstyle ">To Date</label>
					    <html:text property="toDate" name="NEWOfflineResultEntryFB" styleId="toDate" styleClass="form-control"></html:text>					    				    
					</div>
			   	</div>
			  </div>
			  <div class="card-body" style="margin-top: 18px;" id='divtablePatientList'>
			    &nbsp;
			  </div>			  
			</div>		
		</div>
	</div>
	
	
	
	 <div class="modal fade" id="investigationLabReportModal" role="dialog" >
    <div class="modal-dialog modal-lg">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title text-left">Lab Report Analyzer</h2>
        </div>
        <div class="modal-body" style="text-align: left;"> 
			 <div class="row" style="min-height:300px;">
			    <div  class="col-sm-12">
			        <!-- <h3>Reports</h3>
			        <hr/> -->
			        <div class="col-xs-5 col-sm-2 col-md-3"> 
			            <ul class="nav nav-tabs tabs-left investigationModalNavMenu">
			                <li class="active"><a href="#home12" data-toggle="tab">My Reports</a></li> 
			            </ul>
			        </div>
			        <div class="col-xs-7 col-sm-10 col-md-9">
			            <!-- Tab panes -->
			            <div class="tab-content investigationModalNavMenuContent">
			             <div class="tab-pane active" id="home12">
			                <input type="hidden" id="labDataRecordDtl" value="0">
								
								<!-- <ul class="patInvestigationTestList" > -->
								<div class="patInvestigationTestList">
									<table id="offlineLabTestData"
								class="table table-hover table-condensed table-checkable patientListMainTable "
								style="width: 100%">
								<thead>
									<tr>
										<th>Laboratory Name</th>
										<th>Test Name</th>				
										<th>Test Date</th>																									
									</tr>
								</thead>
								<tbody id="offlineLabTestDataTable">
								</tbody>
								</table>
								<!-- </ul> -->
								</div>
			                </div> 
			            
			            </div>
			        </div>
			        <div class="clearfix"></div>
			    </div>  
			</div> 
           <!-- <object id="investigationLabReportPdf1" data="data:application/pdf;base64," type="application/pdf" style="width:100%;height:500px;"></object> -->
        </div>  
      </div> 
    </div>
  </div>
</fieldset>
 <%-- <input type="hidden" id="VarClientShort" name="VarClientShort"  value="<%=request.getAttribute("clientShortName")%>"/>  --%>
<input type='hidden' name='hmode' id='hmode' />
 <html:hidden name="NEWOfflineResultEntryFB" property="patCrNo" styleId="patCrNo"/>
 <input type='hidden'  name="crNoInput" id="crNoInput"/>  
 
 <html:hidden name="NEWOfflineResultEntryFB" property="patEpisodeCode" styleId="patEpisodeCode"/>
 <html:hidden name="NEWOfflineResultEntryFB" property="patVisitNo" styleId="patVisitNo"/> 
  <html:hidden name="NEWOfflineResultEntryFB" property="isbillingreq" styleId="isbillingreq"/>
  <%-- <html:hidden name="NEWOfflineResultEntryFB" property="varclientshort" /> --%>
 <%-- <input type="text" id="varclientshort" name="varclientshort"  value="<%=request.getAttribute("clientShortName")%>"> 
   <input type="text" id="varclientcode" name="varclientcode"  value="<%=request.getAttribute("clientCode")%>"> 
 <input type="text" id="varclientname" name="varclientname"  value="<%=request.getAttribute("clientName")%>"> 
 <input type="text" id="varclientstartyear" name="varclientstartyear"  value="<%=request.getAttribute("clientStartYear")%>">  --%>
			  
<!-- <input type='text' name='varclientshort' id='varclientshort' /> -->
<input type='hidden' name='crnum' id='crnum' />


 <input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value="<%=request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>"/>
 
			  
</html:form>
 </body>




</html>