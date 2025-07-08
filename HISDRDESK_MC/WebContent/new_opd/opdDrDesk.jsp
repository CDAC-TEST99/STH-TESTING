<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.*"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
response.setHeader("Cache-Control", "public, max-age=86400"); // Cache for 1 day
response.setHeader("Expires", new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(new Date(System.currentTimeMillis() + 86400000)));
%>

<html lang="en">
<head>
	<meta charset="utf-8" >
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
	<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%> 
	<title>eSushrut - G6</title>   
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/bootstrap/css/bootstrap.min.css">
    <link href="/HIS/hisglobal/drDeskAssets/gijgo/css/gijgo.min.css" rel="stylesheet" type="text/css" /> 
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/fontawesome.min.css">
    <link rel="stylesheet" type="text/css" href="/HIS/hisglobal/drDeskAssets/css/style.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/css/perfect-scrollbar.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/uikit/css/uikit.min.css" />
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/material_icons/icon.css">
	<link rel="stylesheet" type="text/css" href="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/css/dataTables.bootstrap4.min.css"/>
    <link rel="stylesheet" type="text/css" href="/HIS/hisglobal/drDeskAssets/Responsive-2.2.2/css/responsive.bootstrap4.min.css"/>
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/viewerjs/viewer.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css.map">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/flexdatalist/jquery.flexdatalist.min.css">
	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/assests/jquery-confirm.min.css">
	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/css/mainDesk.css">
	
	 <!-- <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">  -->
	  
	<script type="text/javascript" src="../../new_opd/assests/jquery.js"></script>
    <script src="/HIS/hisglobal/drDeskAssets/popper/popper.min.js"></script>
    <script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script>  
    <script src="/HIS/hisglobal/drDeskAssets/gijgo/js/gijgo.min.js" type="text/javascript"></script>
    <script src="/HISDRDESK_MC/new_opd/js/opdDrDeskSave.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/perfectScrollbar/perfect-scrollbar.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/uikit/js/uikit.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/uikit/js/uikit-icons.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/tippy/tippy.all.min.js"></script>
	<script src="/HISDRDESK_MC/new_opd/js/teleconsultancy.js"></script>
    
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/Responsive-2.2.2/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/Responsive-2.2.2/js/responsive.bootstrap4.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/jstree/jstree.min.js"></script> 
	 
	<script src="/HIS/hisglobal/drDeskAssets/viewerjs/viewer.js"></script>  
    <script src="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.js"></script>
    <script src="/HIS/hisglobal/drDeskAssets/chartjs/Chart.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/hotkeys/hotkeys.min.js"></script>
	<script src="/HISDRDESK_MC/new_opd/assests/jquery/jquery-confirm.min.js"></script>
	<!-- <script src="/HISDRDESK_MC/new_opd/assests/bootstrap/js/bootstrap-multiselect.js"></script>
	<link href="/HISDRDESK_MC/new_opd/assests/bootstrap/js/bootstrap-multiselect.css" rel="stylesheet"/>
 -->
	
	<script src="/HISDRDESK_MC/new_opd/js/mainDeskScript.js"></script>  
	<script src="/HISDRDESK_MC/new_opd/js/Opdvital.js"></script>  
	<script src="/HISDRDESK_MC/new_opd/js/VitalSave.js"></script> 
	<script src="/HISDRDESK_MC/new_opd/js/ExtOpenTemplate.js"></script>
	
	<script src="/HIS/hisglobal/FormFlowX/plugins/select2/js/select2.min.js"></script>
	<link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/select2/css/select2.min.css"> 
	 
	<style>
	body{
		padding-top: 0;
	}	
	
.loader{
  position: absolute;
  top:50%;
  left:50%;
}

.loader span{
  display: inline-block;
  width: 0.7rem;
  height: 3rem;
  background-color: #3498db;
}

.loader span:nth-child(1){
  animation: grow 1s ease-in-out infinite;
}

.loader span:nth-child(2){
  animation: grow 1s ease-in-out 0.15s infinite;
}

.loader span:nth-child(3){
  animation: grow 1s ease-in-out 0.30s infinite;
}

.loader span:nth-child(4){
  animation: grow 1s ease-in-out 0.45s infinite;
}

@keyframes grow{
  0%, 100%{
    -webkit-transform: scaleY(1);
    -ms-transform: scaleY(1);
    -o-transform: scaleY(1);
    transform: scaleY(1);
  }

  50%{
    -webkit-transform: scaleY(1.8);
    -ms-transform: scaleY(1.8);
    -o-transform: scaleY(1.8);
    transform: scaleY(1.8);
  }
}
	
	.modal-backdrop{
  z-index: -1 !important;
			}
			
	.blink {
      animation: blink 2s steps(5, start) infinite;
      -webkit-animation: blink 1s steps(5, start) infinite;
    }
    @keyframes blink {
      to {
        visibility: hidden;
      }
    }
    @-webkit-keyframes blink {
      to {
        visibility: hidden;
      }
    }
	/*		
	.patSideList .patCatHeader{
   	
   	 background-color: #ce2020 !important;
   	 text-align: left !important;
   	
   }
   */
   
   .patCategoryPensioner {
  
  		background-color: blanchedalmond;
	}
  .patCategoryOutsiders {
  
  		background-color: lightcyan;
	}
	
	.buttonTriage {
  background-color: #4CAF50;
  border: none;
  color: white;
  /* padding: 10px 32px; */
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  cursor: pointer;
}

.button2 {background-color: #008CBA;} /* Blue */
.button3 {background-color: #f44336;} /* Red */ 
.button4 {background-color: #e7e7e7; color: black;} /* Gray */ 
.button5 {background-color: #555555;} /* Black */
.button6 {background-color: #FFD700; color: black;} /* Yellow */
@media print {
  body {
    margin: 0;
    padding: 20px;
    -webkit-print-color-adjust: exact;
  }
  
  /* Hide unnecessary elements */
  .no-print, .prescBtn {
    display: none !important;
  }

  /* Add print-specific styles */
  @page {
    size: letter;
    margin: 20mm;
  }
}
.member-name {
    display: inline-block;
    min-width: 200px;
    border-bottom: 1px solid black;
    margin-left: 5px;
}	
.scroll-mcform{
height: auto;
  overflow: auto;
}
	
	</style>
<script>
	/*
	$(document).ready(function(){
		  	$('input[name=prescMode]').on('change', function(e){
		  		if($('input[name=prescMode]:checked').val() == 2)
		  		{
		  			$('.mainHeaderSrch').hide();
		  			$('.prescNxtBtn').show();
		  		}
		  		else
		  		{
		  			$('.mainHeaderSrch').show();
		  			$('.prescNxtBtn').hide();
		  		} 
			});
	});
	*/
	
</script>
<script>

/* $(function(){
	$(".btn").on("click", function(){
		  $(document).find(".modal-backdrop").css({"z-index": "-1"});
		});
}); */
</script>
<!--  ################################# Added for IPD switch  ############################################# -->
<script>
function submitPage(mode)
{
	//alert(mode);
	document.forms[0].hmode.value=mode;
	//alert(document.forms[0].hmode.value);
	document.forms[0].submit();
}
function showIpdList(mode){
	
		//alert('Called');	
		submitPage("SHOWIPDLIST");

}

</script>
</head>
<body >


			<div class="modal fade" id="PatientReVisitTemplateModal" >
			    <div id="PatientReVisitTemplateModal12" style="width: 90%" class='modal-dialog modal-lg'>       <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header" style="text-align: center;font-size: 25px;">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			           <h2 class="modal-title text-left">Referral Patient Acceptance (Within Hospital)</h2> 
			        </div>
			        <div class="modal-body">
			       		 <div class="text-center">
			       			<button type="button" class="btn btn-warning" onclick="$('#PatientReVisitTemplateModal').modal('hide');$('#PatientReVisitTemplateModalFrameId').remove();">Cancel</button>
							
							<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
						 </div> 
			        </div>  
			      </div> 
			    </div>
			  </div> 
<div id="mainDeskLoadingMsgDiv" style="width:100vw;height:100vh;position:fixed;z-index:99999; background-color:rgba(0,0,0,0.6)">
	<h2 class="text-center" style="color:white; margin-top:13%"><i class="fa fa-spinner fa-spin"></i> Loading...</h2>
</div>
	<html:form action="/transaction/DoctorDeskAction.cnt"  name="DoctorDeskFB" type="new_opd.transaction.controller.fb.DoctorDeskFB" method="post" >  
		
	<div class="savePrescAlert alert alert-success alert-dismissible fade in" style="display:none; position:fixed; z-index:9999; top:18vh; left:35vw; color: #fff; background-color: rgb(51, 143, 13); border-color: rgb(103, 183, 37); font-size: 16px; padding: 2% 5% 1% 5%;">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<strong>Success!</strong> Prescription saved successfully.
		<br><br>
	    <div class="text-center">
	        <small class="msgAlertNxtPatient" style="color: white;">Press Proceed for Next Patient</small><br>
	        <small class="msgAlertAttendedPatient" style="color: white;">The Patient has been Attended !</small><br>
	        <small class="text-light msgAlertTimer"></small><br><br>
		    <!-- <button class="btn btn-warning btn-sm savePrescAlertCancelBtn" type="button" >Cancel</button> -->
		    <button class="btn btn-info btn-sm savePrescAlertOkBtn" style="margin-left:10px" type="button">Proceed</button>
	    </div>
	</div>
	
		<div id="patSideListId" class="patSideList">
			<legend class="text-center totalPatHeader">Patient List <span class="badge" style="background-color: #36c6D3;">5</span></legend>
			<p class="patCatHeader waitingPatHeader" >Waiting <span class="badge" style="background-color: #ED6B75;">5</span></p>
			<ul id="waitingPatList"> 
			</ul>
			<p class="patCatHeader visitedPatHeader">Attended <span class="badge" style="background-color: #F1C40F;">5</span></p>
			<ul id="visitedPatList"> 
			</ul>
		</div>
		
		 <div id="patSideListId1" style="top: 2.5vh !important;" class="patSideList">
			<legend class="text-center totalPatHeader" style="text-transform: capitalize  !important;background:cadetblue;color:white">TeleConsultancy Request (Today) 
			
			<a href="#" class="closee-consultancy"  data-placement="bottom" data-toggle="tooltip" title="Close Patient Approval List" >
			<font>&times;</font>
			</a>
			</legend>
			
			<ul id="waitingPatList" style="overflow-y: auto;overflow-x: hidden;height: 89.5%;"> 
			<%
			ArrayList<String> teleConsultancyApprovalData = (ArrayList<String>)  request.getSession().getAttribute("teleConsultancyApprovalData");
			if(teleConsultancyApprovalData !=null && teleConsultancyApprovalData.size() >0){
			%>
			<input type="hidden" name="showpatientCount" id="showpatientCountId" value="<%=teleConsultancyApprovalData.size()%>" >
		<%	
			}else{
				%>
			
				<input type="hidden" name="showpatientCount" id="showpatientCountId" value="0" >
			<%	
			}
			if(teleConsultancyApprovalData !=null && teleConsultancyApprovalData.size() >0){
				
				//System.out.println("teleConsultancyApprovalData"+teleConsultancyApprovalData.toString());
			for(int approvalval=0;approvalval<teleConsultancyApprovalData.size();approvalval++){
		     JSONObject approvaljsonObj=new JSONObject(teleConsultancyApprovalData.get(approvalval));
			//System.out.println(approvaljsonObj.get("hrgstr_pat_name")+"approvaljsonObj:::"+approvaljsonObj.toString());
			%>
			
			
			<li>
<!-- 			<img class="img-circle img-responsive" src="/HISDRDESK_MC/new_opd/img/img_avatar3.png" style="margin: 3% 2%;float:left; 
			width: 30px; min-width: 20px; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.2); border: 1px solid #fff;"> -->
			<h5 style="padding: 0px; margin:0px;font-weight: bold;"><%=approvaljsonObj.get("hrgstr_pat_name") %> (<%=approvaljsonObj.get("hrgstr_pat_gender") %>/<%=approvaljsonObj.get("hrgstr_pat_age") %>/<%=approvaljsonObj.get("hrgnum_pat_mobile_no") %>)</h5>
			<p><label style="font-weight: bold; color:#3ba4e3;"> BEN ID: <%=approvaljsonObj.get("hrgnum_puk") %></label> <a href="#" id=<%=approvaljsonObj.get("hrgstr_req_id") %> class="hideme" onclick='approvalData(<%=approvaljsonObj.toString() %> )' data-toggle="tooltip" title="Click To Approve" ><i class="fa fa-check-circle"  style="float: right;"></i></a></p>
			
			<p>Unit:<%=approvaljsonObj.get("hrgstr_deptunit_name") %> </p>
			<p><label style=" font-weight: bold;">Raised on:<%=approvaljsonObj.get("request_date") %>  </label></p>
			<p><label style=" font-weight: bold;">Appointment Slot: <%=approvaljsonObj.get("apointment_date") %>  </label></p>
			<p>Raised By :self(<%=approvaljsonObj.get("hrgstr_req_id") %>) </p>
			<%-- <p><label style=" font-weight: bold;">Problem Statement : <%=approvaljsonObj.get("hrgstr_remarks") %> </label></p> --%>
			<!-- <p>First right-click on the Wi-Fi icon at the lower right corner area of the screen, then click on Open Network and Sharing Center. Next, click on the Wi-Fi connection, which will</p> -->
			</li>
			<%
				}
			}else{
			%>
			<p align="center"> <label style=" font-weight: bold;"> No Data Found </label> </p>
			<%
			}
			%>
			</ul>
			<p class="patCatHeader visitedPatHeader" style="padding: 15px !important"> <span class="badge" style="background-color: #F1C40F;"></span></p>
			<ul id="visitedPatList"> 
			</ul>
		</div>
		
		
		
		
		
		
		
		<div id="patSideListId2" style="top: 2.5vh !important;" class="patSideList">
			<legend class="text-center totalPatHeader" style="text-transform: capitalize  !important;background:cadetblue;color:white">Referral Approval List 
			
			<a href="#" class="closee-consultancy1"  data-placement="bottom" data-toggle="tooltip" title="Close Patient Approval List" >
			<font>&times;</font>
			</a>
			</legend>
			
			<ul id="waitingPatList2" style="overflow-y: auto;overflow-x: hidden;height: 89.5%;"> 
			<%
			ArrayList<String> RefeConsultancyApprovalData = (ArrayList<String>)  request.getSession().getAttribute("RefeConsultancyApprovalData");
			//System.out.println("RefeConsultancyApprovalData.size()"+RefeConsultancyApprovalData.size());
			if(RefeConsultancyApprovalData !=null && RefeConsultancyApprovalData.size() >0){
			%>
			<input type="hidden" name="showpatientCount" id="showpatientCountId" value="<%=RefeConsultancyApprovalData.size()%>" >
		<%	
			}else{
				%>
			
				<input type="hidden" name="showpatientCount" id="showpatientCountId" value="0" >
			<%	
			}
			if(RefeConsultancyApprovalData !=null && RefeConsultancyApprovalData.size() >0){
				
				
				//System.out.println("teleConsultancyApprovalData"+teleConsultancyApprovalData.toString());
			for(int approvalval=0;approvalval<RefeConsultancyApprovalData.size();approvalval++){
			JSONObject approvaljsonObj=new JSONObject(RefeConsultancyApprovalData.get(approvalval));
			//System.out.println("approvaljsonObj:::"+approvaljsonObj.toString());
			%>
			
			
			<li>
<!-- 			<img class="img-circle img-responsive" src="/HISDRDESK_MC/new_opd/img/img_avatar3.png" style="margin: 3% 2%;float:left; 
			width: 30px; min-width: 20px; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.2); border: 1px solid #fff;"> -->
			<h5 style="padding: 0px; margin:0px;font-weight: bold;"><%=approvaljsonObj.get("patname") %> </h5>
			<p><label style="font-weight: bold; color:#3ba4e3;"> BEN ID: <%=approvaljsonObj.get("patcrno") %></label> <a href="#" id=<%=approvaljsonObj.get("fromdepartment") %> class="hideme" onclick='approvalData1(<%=approvaljsonObj.toString() %> )' data-toggle="tooltip" title="Click To Approve" ><i class="fa fa-check-circle"  style="float: right;"></i></a></p>
			
			<p>Refer from:<%=approvaljsonObj.get("fromdepartmentunit") %> </p>
			<p>Refer to:<%=approvaljsonObj.get("todepartmentunit") %> </p>
			<p><label style=" font-weight: bold;">UMID: <%=approvaljsonObj.get("umid_no") %>  </label></p>
			<p>Remarks :(<%=approvaljsonObj.get("remarks") %>) </p>
			<!-- <p>First right-click on the Wi-Fi icon at the lower right corner area of the screen, then click on Open Network and Sharing Center. Next, click on the Wi-Fi connection, which will</p> -->
			</li>
			<%
				}
			}else{
			%>
			<p align="center"> <label style=" font-weight: bold;"> No Data Found </label> </p>
			<%
			}
			%>
			</ul>
			<p class="patCatHeader visitedPatHeader" style="padding: 15px !important"> <span class="badge" style="background-color: #F1C40F;"></span></p>
			<ul id="visitedPatList2"> 
			</ul>
		</div>
		
		
		
		
		
		
		
		
		
		
<div id="wrapper">
  <div class="overlay"></div>
  
  <!-- Sidebar -->
  <nav class="navbar navbar-inverse navbar-fixed-top containerNav" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
      <li class="sidebar-brand"> <a href="#" onclick="return false;"> Preferences <button class="btn btn-xs" type="button" onclick="hideOverlay()"><i style="color: black" class="glyphicon glyphicon-pushpin"></i></button></a> </li>
      <!-- <li> <a href="#"><i class="fa fa-fw fa-home"></i> Home</a> </li> -->
      <!-- <li> <a href="#"><i class="fa fa-fw fa-folder"></i> Page one</a> </li>
      <li> <a href="#"><i class="fa fa-fw fa-file-o"></i> Second page</a> </li>
      <li> <a href="#"><i class="fa fa-fw fa-cog"></i> Third page</a> </li> -->
      <!-- <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-fw fa-plus"></i> Dropdown <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dropdown heading</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li>
        </ul>
      </li> -->
      <!-- <li> <a href="index.html"><i class="fa fa-fw fa-bank"></i> Page1</a> </li> 
      <li> <a href="index2.html"><i class="fa fa-fw fa-bank"></i> Page2</a> </li>  -->
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Switch Between Desks</h4>
      <p style="margin: 1px 0px;"> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="desk" checked> OPD</label> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="desk" > IPD</label> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="desk" > Casuality</label></p>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Prescription Without List</h4>
      <p align="center" style="margin: 1px 0px;"><b style=" vertical-align: top;">Off</b>&nbsp;<label class="switch">
      				   <input type="checkbox" class="prescWithoutLst" onchange="onChangePrescWithoutLst(this, event)" value="1">
      				   <span class="slider round"></span> 
      				</label>&nbsp;<b style="vertical-align: top;">On</b></p>
      <h5 style="margin: 16px 0 8px 0px;text-align: left;">Switching Prescription Mode</h5>
      <p style="margin: 1px 0px;"> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="prescMode" value="1"> Tile</label> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="prescMode" value="2" checked> Page</label> <label><input style="vertical-align: top" class="uk-radio" type="radio" name="prescMode" value="3" > Modal</label></p>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Patient Listing Criteria <i style="color: #EDC10F" class="fa fa-star"></i></h4>
      <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" onchange="patLstColorSrchNewVisit(this,event)" type="checkbox" name="patientListCriteria" checked> New Visit</label> <i class="fa fa-square" style="float: right; color: #A7FBD0; text-shadow: 2px 2px 4px black;"></i></p>
      <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" onchange="patLstColorSrchReffered(this,event)" type="checkbox" name="patientListCriteria" checked> Reffered</label> <i class="fa fa-square" style="float: right;  color: #D481FA; text-shadow: 2px 2px 4px black;"></i></p>
      <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" onchange="patLstColorSrchAppointment(this,event)" type="checkbox" name="patientListCriteria" checked> Appointment Based</label> <i class="fa fa-square" style="float: right;  color: #91061D; text-shadow: 2px 2px 4px black;"></i></p>
	  <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" onchange="patLstColorSrchOther(this,event)" type="checkbox" name="patientListCriteria" checked> Other</label> <i class="fa fa-square" style="float: right; color: #F9F9F9; text-shadow: 2px 2px 4px black;"></i></p>
      <p style="margin: 1px 0px;padding:2px 10px"><a href="#"> ...more</a></p>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Queue No Sort By <i style="color: #EDC10F" class="fa fa-star"></i></h4>
      <p style="margin: 1px 0px;padding:2px 10px"> <label> <input style="vertical-align: top" class="uk-checkbox" type="checkbox" name="queueSortDept" checked> Dept</label> <label><input style="vertical-align: top" class="uk-checkbox" type="checkbox" name="queueSortUnit"> Unit</label></p>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Prescription <i style="color: #EDC10F" class="fa fa-star"></i></h4>
      <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" type="checkbox" name="prescription" checked> Reason Of Visit</label></p>
      <p style="margin: 1px 0px;padding:2px 10px"><label><input style="vertical-align: top" class="uk-checkbox" type="checkbox" name="prescription"> Diagnosis</label></p>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Auto Save <input style="vertical-align: top" class="uk-checkbox" type="checkbox" name="autoSave" checked></h4>
      <h4 style="margin: 16px 0 8px 0px;text-align: left;">Font Size <button class="btn btn-default btn-xs" type="button" onclick="resizeText(-1)"><small>A</small></button><button class="btn btn-default btn-sm" type="button" onclick="resizeText(1)">A</button></h4>
      <!-- <legend>Legend</legend>
      <p style="margin: 1px 0px;padding:2px 10px">P <i class="fa fa-arrow-right"></i> Provisional <i class="fa fa-square" style="float: right;  color: #d4d4d4; text-shadow: 2px 2px 4px black;"></i></p>
      <p style="margin: 1px 0px;padding:2px 10px">F <i class="fa fa-arrow-right"></i> Final <i class="fa fa-square" style="float: right;  color: rgba(35, 104, 194, 0.8); text-shadow: 2px 2px 4px black;"></i></p>
	  <div class="col-sm-10 col-sm-offset-1" style="border:1px solid grey; height: 100px; margin-bottom: 10px; padding: 4px 4px;">
	  	<h6 style="margin: 4px 0;">Summary Stats</h6>
	  	<h6 style="margin: 4px 0;">IPD/EMERG</h6>
	  </div>  -->     
	  <br> 
    </ul> 
  </nav>

  <!-- Page Content -->
  <div id="page-content-wrapper"> 
    <div class="container-fluid"> 
      <div class="row mainTopHeader">
        
        <div class="col-sm-0">
        	 <button style="display:none;" type="button" id="hamburger" class="hamburger is-closed animated fadeInLeft" data-toggle="offcanvas"> <span class="hamb-top"></span> <span class="hamb-middle"></span> <span class="hamb-bottom"></span> </button>
        </div>
        <div class="col-sm-12 " style="box-shadow: 0 0 10px 3px rgba(0,0,0,0.14); padding-bottom: 0px; padding-top: 15px; padding-right: 0px;padding-left: 5px;margin-bottom: 1px;" >
          <div class="row">
          	<div class="col-sm-2" style="padding-right: 0px;padding-left: 0px;">
          		<!-- <h2 class='heading'><i class="fa fa-user" ></i>  DOCTOR DESK</h2> -->
          		<!-- Code added by Siddhant -->
          		<logic:equal name="DoctorDeskFB" property="isScriber" value="1">
				  	<h2 class='heading'><i class="fa fa-user" ></i> NURSING DESK</h2>
				</logic:equal>
				
				<logic:equal name="DoctorDeskFB" property="isScriber" value="0">
					<h2 class='heading'><i class="fa fa-user" ></i> DOCTOR DESK</h2>
				</logic:equal>
          		<p class="text-center" style="font-size:0.95em;margin-top: 0px;margin-bottom: 0px;float: right;font-weight:bold; margin-right:10px;display:none;"><font class="visitedPatCount" style="color: rgba(35, 104, 194, 0.8)"></font> of <a style="color:black" class="totalPatCount" title="Total : 100 Approx waiting" onclick="$('#patListStatModal').modal('show');"></a> attended</p>
          	</div> 
          	<!-- <div class="col-xs-12 col-sm-1">
          		<button style="float: right; color:#4067c5;font-size: 20px;" class="btn btn-outline-success btn-sm fullScreenDeskBtn" type="button" onclick=""><i class="glyphicon glyphicon-fullscreen"></i></button>
          	</div> -->
          	
          	<!--  ################################# Added for IPD NEW switch  ############################################# -->
          	<div class="col-xs-12 col-sm-1" style="display:none;">
          		<p style="display:block">
                   <label class="switch" style="vertical-align: middle;">
                       <input type="checkbox"  value="1" checked="" onclick="showIpdList('SHOWIPDLIST');">
                          	<span class="slider round"></span> 
                   </label>
                </p>
            </div> 
          	 
          	<div class="clearfix visible-xs" style="margin: 10px;"></div>
          	<div class="col-xs-12 col-sm-3 form-horizontal">
          		<div class="form-group" style="margin-top: -4px;">
          		<logic:equal name="DoctorDeskFB" property="isScriber" value="0">	
          		<p  class="control-label col-sm-12 lblfilter" for="deptUnitName" style="text-align: left;">Speciality/Dr. Name </p>
          		</logic:equal>
          		<logic:equal name="DoctorDeskFB" property="isScriber" value="1">	
          		<p  class="control-label col-sm-12 lblfilter" for="deptUnitName" style="text-align: left;">Speciality </p>
          		</logic:equal>
                <div class="col-sm-12" >
                  <select name="deptUnitName" id="deptUnitName" class="form-control" onchange="getDeltList(this);">
            		<!-- <option value="0#0#0">ALL</option> -->
                    <%
                    HashMap<String ,String> DeptCMB= (HashMap) request.getSession().getAttribute("DeptDTL");
                   	//System.out.println("DeptCMB"+DeptCMB);
                   	if(DeptCMB!=null)
                   	{
                   	for(Map.Entry m:DeptCMB.entrySet()){ 
                   	 String DeptCode=(String)m.getKey();
            		 String DeptName=(String)m.getValue();
            		 String SelectedDeptId=(String)request.getSession().getAttribute("SelectedDeptId");
            		 String selected="";
            		 if(SelectedDeptId.contains("#")){
            			String selectedDeptUnitCode= SelectedDeptId.split("#")[1];
            			String deptUnitCode= DeptCode.split("#")[1];
            			if(selectedDeptUnitCode.equals(deptUnitCode))
            				selected="selected";            			            			
            		 }else{
            			if(SelectedDeptId.equals(DeptCode))
            				selected="selected";
            		 }
            		 %>
                      	<option value="<%=DeptCode%>" <%=selected %>><%=DeptName %></option>
                     <%
            		 	}	
                     }
                     %>
                   
            	  </select>
                </div>
          		<button id="patSideListBtn1"  title="" style="float: right;padding:4px 12px; color:#4067c5 ;display:none;" class="btn btn-outline-success btn-sm" type="button">
          		<!-- <i   class="fa fa-list"></i> -->
          		<i   class="fa fa-user-md"></i>
          		<span style="position:absolute;top:-1px;right:1px;color:white;border-radius:25px;display:none;" id="patSideListSpan1" class="blink label label-danger">0</span>
          		<!-- <i style="position:absolute;top:-1px;right:1px;color:red;display:none" class="fa fa-phone"><span id="patSideListSpan1" style="color:tomato"></span></i> --></button>
          		
          		<!-- Old list button for referral list as in teleconsultancy -->
          		<!-- <button id="patSideListBtn2"  title="" style="float: right;padding:4px 12px; color:#4067c5;display:none" class="btn btn-outline-success btn-sm" type="button"> -->
          		
          		<button id="patSideListBtn3" onclick="OPENREveistProcess(this)"  title="" style="float: right;padding:4px 12px; color:#4067c5 ;display:none;" class="btn btn-outline-success btn-sm" type="button">
          		<i   class="fa fa-list"></i>
          		<span style="position:absolute;top:-1px;right:1px;color:white;border-radius:25px;display:none;" id="patSideListSpan2" class="blink label label-danger">0</span>
          		<!-- <i style="position:absolute;top:-1px;right:1px;color:red;display:none" class="fa fa-phone"><span id="patSideListSpan1" style="color:tomato"></span></i> --></button>
          		
          		
          		</div>
          	</div>
          	<div class="col-xs-12 col-sm-3 form-horizontal toggleForFullScreenDeskBtn">
          		<div class="form-group has-feedback" >
          		    <p for="listDateFilter" class="control-labelcol-sm-12 lblfilter" style="text-align: left;margin-left: 17px;">DATE </p>
	                <div class="col-sm-12">
	                  <input type="text" style="padding-top: 0;border-radius: 0px;" class="form-control" name="strPrevDate" id="listDateFilter"  value="${DoctorDeskFB.strPrevDate}" autocomplete="off"> 
			          <span class="glyphicon glyphicon-calendar form-control-feedback"></span>
	                </div> 

          	   </div>  
          	</div>

          	<div class="col-xs-12 col-sm-1" style="padding-top: 26px;" >
          		
          		<button id="patOfflineModalBtn" onclick="patOfflineModalShow()"  title="" style="float: left;padding:4px 12px; color:#4067c5 ;display:none" class="btn btn-outline-success btn-sm" type="button">
          		<i class="fa fa-notes-medical"></i>
          		<span style="position:absolute;top:-1px;right:1px;color:white;border-radius:25px;display:none;" id="patOfflineModalBtn" class="blink label label-danger">0</span>
				</button>
				
          		<button id="patRefreshBtn" onclick="refreshPatientData(this)"  title="Refresh Patient List"  class="btn btn-his" type="button">
          		<i   class="fas fa-redo-alt"></i>
          		<span style="position:absolute;top:-1px;right:1px;color:white;border-radius:25px;display:none;" id="patRefreshBtn" class="blink label label-danger">0</span>
          		</button>
          	</div>
          	<%String ISSMARTQMSENABLED=(String) request.getSession().getAttribute("ISSMARTQMSENABLED"); %>
			<input type='hidden' id='isSmartQMSEnabled' name="isSmartQMSEnabled" value="<%=ISSMARTQMSENABLED %>">
          	<logic:equal name="DoctorDeskFB" property="isScriber" value="0">
          		
	          	<div class="col-xs-12 col-sm-3"  style="padding-top: 26px;text-align: right;">
	          		<button id="patDrLeaveBtn" onclick="openDrLeavePage()"    class="btn btn-his-outline" type="button">
	          			<i class='fas fa-calendar-alt fa-fw'></i><!--Open Leave Page  -->
	          		</button>
	          		
                  		          		
	          	</div>
	          	<%if(ISSMARTQMSENABLED!=null && ISSMARTQMSENABLED.equals("1")){ %>
	          		<div class="col-xs-10 col-sm-10"  style="text-align: center;">	          		
	          			
                  		
                  		<button id="callPatientBtn" onclick="callStatusWiseData(this)" data-callPatient="1" data-Status="7"    style="display: none;" class="btn btn-his btnCallStatus disableOnNextCall " type="button">
		          			<i class='fas fa-headset fa-fw'></i>&nbsp; Call Patient <!-- Call next patient -->		          			
		          		</button>
		          		<button id="startOpdBtn" onclick="callStatusWiseData(this)" data-callPatient="0" data-Status="1" style="display: none;" class="btn btn-his btnCallStatus pulse" type="button">
		          			<i class='fas fa-play-circle fa-fw'></i>&nbsp; Start<!-- Start opd desk -->
		          		</button>
		          		<button id="resumeOpdBtn" onclick="callStatusWiseData(this)"  data-callPatient="0" data-Status="2" title="resume desk" style="display: none;" class="btn btn-his btnCallStatus" type="button">
		          			<i class='fas fa-play fa-fw'></i>&nbsp; Resume<!-- resume desk -->
		          		</button>
		          		<button id="pauseOpdBtn" onclick="callStatusWiseData(this)" data-callPatient="0" data-Status="3" title="Pause desk" style="display: none;" class="btn btn-his-outline btnCallStatus" type="button">
		          			<i class='fas fa-pause fa-fw'></i>&nbsp; Pause<!-- Pause desk -->
		          		</button>
		          		<button id="pickFromPoolOpdBtn" onclick="openopdPoolPatientListPage(this)"   style="display: none;" class="btn btn-his-outline btnCallStatus disableOnNextCall" type="button">
		          			<i class='fas fa-users fa-fw'></i>&nbsp; Pick From Pool<!--Pick Patient fro main pool  -->
		          		</button>
		          		<button id="patReferralBtn" onclick="openReferralPatientList()"  title="Open Accept Transferred Patient"  style="display: none;" class="btn btn-his-outline btnCallStatus" type="button">
          					<i class='fas fa-users fa-fw'></i>&nbsp; Accept Transferred Patient
          				</button>
          			</div>	
          			<div class="col-xs-2 col-sm-2"  style="text-align: center;">	 	
		          		<button id="stopOpdBtn" onclick="callStatusWiseData(this)"  data-callPatient="0" data-Status="4" title="stop desk" style="display: none;" class="btn btn-his-outline-danger btnCallStatus" type="button">
		          			<i class='fas fa-stop fa-fw'></i>Stop OPD<!-- stop desk -->
		          		</button>	          	
	   				</div>
	   			<%}else{ %>	
	   				<div class="col-xs-10 col-sm-10"  style="text-align: center;">
	   					<button id="pickFromPoolOpdBtn" onclick="openopdPoolPatientListPage(this)"   style="display: none;" class="btn btn-his-outline " type="button">
		          			<i class='fas fa-users fa-fw'></i>&nbsp; Pick From Pool<!--Pick Patient fro main pool  -->
		          		</button>
		          		<button id="patReferralBtn" onclick="openReferralPatientList()"  title="Open Accept Transferred Patient"  style="display: none;" class="btn btn-his-outline" type="button">
          					<i class='fas fa-users fa-fw'></i>&nbsp; Accept Transferred Patient
          				</button>
	   				</div>
	   			<%} %>
          	</logic:equal>
          	<div class="modal fade" id="offlinePatCountModal" role="dialog">
			    <div class="modal-dialog modal-sm">       <!-- Modal content-->
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          <h3 class="modal-title">Offline Patient Count</h3>
			        </div>
			        <div class="modal-body" style="text-align: left;">
			        	<input type="text" class="form-control" id="strOfflinePatientCountId" name="strOfflinePatientCount" onkeypress="return isNumber(event)" placeholder="Enter offline patient count">
			        </div>
			       <div align="center"> <input type="button" class="btn btn-primary btn-sm" onclick="saveOfflinePatCount()" value="Submit"></div><br></br>  
			      </div> 
			    </div>
			  </div>
          	
          	<!--  ################################# Added for IPD switch  ############################################# -->
          	<div class="col-xs-12 col-sm-2" style="display:none;">
          		<p style="display:block">
                          <label>IPD</label> &nbsp;
                          <label class="switch" style="vertical-align: middle;">
                             <input type="checkbox"  value="1"  onclick="showIpdList('SHOWIPDLIST');">
                             <span class="slider round"></span> 
                          </label>
                          &nbsp;<label>OPD</label>
                        </p>
          	</div>
          	
          	<div class="col-xs-0 col-sm-0">
	  	           <!--  <a href=""><img src="/HISDRDESK_MC/new_opd/img/scanQR_n.png" style="width: 3.95em;"></a>  -->
	  	            <div class="clearfix visible-xs-block"></div>
          	</div>
          	
           </div>
        </div>
       </div> 
	          		
       <!-- <br> -->
       <div class="row">
       	  
       	   <input type="hidden" name="strRailTailFlg" id="strRailTailFlgId" value="${DoctorDeskFB.strRailTailFlg}" />
		
       	   <div class="col-sm-12 uk-card uk-card-default leftPanel"  style="height: 95vh; padding-top: 5px">  
					<table id="example" class="table table-hover table-condensed table-checkable patientListMainTable" style="width:100%">
					  <thead>
					    <tr class='tableHeading'>
					      <th></th>
					      <th>Q. No.</th>
					      <th>Status</th>
					      <th>Name</th>
					      <th>Ben ID</th>
					      <th>Gen/Age</th>
					      <th>Card Type</th>
					      <th>Relation</th>					     
					       <logic:equal name="DoctorDeskFB" property="isScriber" value="1">
					      	<th>Speciality/Dr. Name</th> 
					      </logic:equal>
					      <th>Action</th>
					      <th>Prescription</th>
					      <th></th>
					     </tr>
					    </thead>
					     <tbody>  
       	   
       	   <%
						HashMap<String ,List> map= (HashMap) request.getSession().getAttribute("OPDDRDESKDATA");
						//System.out.print("map--->"+map);	
						ArrayList<String> list=null;
								for(Map.Entry m:map.entrySet()){ 
									list=new  ArrayList<String>(); 
							 //  System.out.println("NEWWWWWWWWW\n"+m.getKey()+" "+m.getValue());
							   String CrNo1=(String)m.getKey();
							   //System.out.println("List Value crno1::::::"+CrNo1);
							   list=(ArrayList) m.getValue();
							   String patEpisodeCode = list.get(10);
							   String patHospitalCode=list.get(26);
							   String patConsultantName=list.get(23);
							   String parentWellnessCenter=list.get(70);
							   
							 //  System.out.println("parentWellnessCenter called --->     "+ list.get(70));
							   
							 //  System.out.println("parentWellnessCenter called --->"+ parentWellnessCenter);
							  String mobileNo = list.get(43);
							 //  System.out.println("patConsultantName called --->"+ patConsultantName);
							   //System.out.println("LISTDATA:"+list);
							   String CrNo=list.get(0);
							   String patMSeatId = list.get(34);
							   String patVisitNo = list.get(11);
							   
							 //  System.out.println("CrNo called --->                     "+ CrNo.trim());
							  // System.out.println("patEpisodeCode called --->           "+ patEpisodeCode.trim());
							  // System.out.println("patConsultantName called --->        "+ patConsultantName.trim());
							 //  System.out.println("parentWellnessCenter called --->     "+ parentWellnessCenter.trim());
							  // System.out.println("patMSeatId called --->               "+ patMSeatId.trim());
							   //System.out.println("patVisitNo called --->               "+ patVisitNo.trim());
							   //System.out.println("crno called --->"+ patMSeatId);
							  // System.out.println("list get---->"+ list.get(47)+" "+list.get(48)+" "+list.get(49));
							 // System.out.println("pat category code ---->"+ list.get(19));
								     %>
					             <%--  <tr class="patientListBlock isAttended_<%=list.get(24) %> visitType_<%=list.get(27) %>" attended="<%=list.get(24) %>"> --%>
					                  
					                   <%  
				                          if(list.get(19) != null && (list.get(19).equals("33") || list.get(19).equals("22")))
				                          { 
				                          %>
				                          
				                          <tr class="patientListBlock patCategoryPensioner isAttended_<%=list.get(24) %>    visitType_<%=list.get(27) %>" attended="<%=list.get(24) %>">
				                          <% 
				                          }else if(list.get(19) != null && (list.get(19).equals("29")))
				                          {
			                        	  %>
				                          
				                          <tr class="patientListBlock patCategoryOutsiders isAttended_<%=list.get(24) %>    visitType_<%=list.get(27) %>" attended="<%=list.get(24) %>">
				                          <%  
				                          }
				                          else if(list.get(63).equals("1")){// High Risk Pregnancy
				                        	  %>
				                        	   <tr style='background:#f7c0c0 !important;'class="patientListBlock isAttended_<%=list.get(24) %> visitType_<%=list.get(27) %>" attended="<%=list.get(24) %>">
				                        	  
				                          <%   }				                          
				                          else{
				                          %>
					                  
					                  	 <tr class="patientListBlock isAttended_<%=list.get(24) %> visitType_<%=list.get(27) %>" attended="<%=list.get(24) %>">
					                       
				                       	  <%  
				                          }
					                   
					                   
				                          %>
				                           
				                       
				                       <%  
				                          if(list.get(3).split("/")[0].equals("F"))
				                          { //System.out.println("list.get(54) if "+list.get(54)); 
				                          %>
				                          
				                        <td><img class="img-circle img-responsive patProfileImg" src="/HISDRDESK_MC/new_opd/img/img_avatar3.png" style="width: 30px; min-width: 26px; display:inline-block; /* box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.2); */ border: 1px solid #fff;">
				                        <% if(list.get(24).equals("1"))
				                        { %>
				                        <i class="isAttended attended"></i>
				                          <% } %>
				                          
				                           <% if(list.get(47) != null && list.get(47).equals("1"))
				                        	 {%>
				                        		<i class="fa fa-phone" aria-hidden="true" style="color: #74aeec;"></i>
				                        		<!-- <b style="color: #74aeec;font-size: 16px;">T</b> -->
				                           <%} %>
				                          
				                          </td>
				                         <% }
				                          else
				                          {//System.out.println("list.get(54) else "+list.get(54)); 
				                          %>
				                       <td><img class="img-circle img-responsive patProfileImg" src="/HISDRDESK_MC/new_opd/img/img_avatar.png" style="width: 30px; min-width: 26px; display:inline-block; /* box-shadow: 0px 0px 15px 2px rgba(0,0,0,0.2); */ border: 1px solid #fff;">
										<% if(list.get(24).equals("1"))
				                        { %>
				                        <i class="isAttended attended"></i>
				                          <% } %>
				                          
				                           <% if(list.get(47) != null && list.get(47).equals("1"))
				                        	 {%>
				                        		<i class="fa fa-phone" aria-hidden="true" style="color: #74aeec;"></i>
				                        		<!-- <b style="color: #74aeec;font-size: 16px;">T</b> -->
				                           <%}%>
										</td> 
				                         <% } %>
				                          <td class="patQNo text-center"><%=list.get(1) %></td>
				                          <% 
				                          String callStatus =list.get(76);
				                          if(callStatus==null || callStatus.equals(""))
				                        	  callStatus="1";
				                          if(list.get(24).equals("1")) {
				                        	  
				                          	  
				                        	  if(callStatus.equals("0")){  
				                            %>
				                          		<td><a style="cursor: default;padding: 6px;font-size: 11px;" class="label label-success">Called</a></td>
				                          	<%}else if(callStatus.equals("1")){ %>
				                          		<td><a style="cursor: default;padding: 6px;font-size: 11px;" class="label label-warning">Waiting</a></td>
				                          	<%}else{ %>
				                          		<td><a style="cursor: default;padding: 6px;font-size: 11px;" class="label label-warning">-</a></td>
				                          	<%} %>	
				                          	<!-- 	<td><a style="cursor: default;padding: 6px;font-size: 11px;" class="label label-info">Skipped</a></td>
				                          		 -->
				                          <%} else {%>
				                         	 <td class="patStatus"><a style="cursor: default;" class="label label-danger">Attended</a></td>
				                          <% } %>
				                          <%
				                          if(list.get(31).equals("1")) { %>				                          
				                          	  <td class="patName" style="color:#E0A800; font-weight:bold;"><%=list.get(2) %></td>
					                          <td class="patCrNo" style="color:#E0A800; font-weight:bold;"><%=CrNo%></td>
				                          <% }else if(list.get(11).equals("1")) {
				                          %>
					                          <td class="patName" style="color:#7896e3; font-weight:bold;"><%=list.get(2) %></td>
					                          <td class="patCrNo" style="color:#7896e3; font-weight:bold;"><%=CrNo%></td>   
				                          <% }else{%>
					                          <td class="patName"><%=list.get(2) %></td>
					                          <td class="patCrNo"><%=CrNo%></td>
				                          <%} %>
				                          <td class="patGenAgeCat"><%=list.get(3)%></td>
				                          
				                          <%
				                          
				                          String cardType=list.get(64);
				                          String Relation= list.get(65);				                         
				                          %>
				                          <td class="cardType"><%=cardType %></td>
				                          <%-- <td><a style="text-decoration:none;padding: .4em .5em .4em;font-size: 85%;border-radius: .1em; background-color: #ed6b75;" class="label label-danger"><% out.print(list.get(5).toString().length()<= 2 ? "": list.get(5));%></a></td> --%>
				                          <%-- <td><%=list.get(11)%></td> --%>  <!-- label label-danger -->
				                          <td class="relation"><%=Relation %></td>
				                          <logic:equal name="DoctorDeskFB" property="isScriber" value="1">
				                          <td ><%=list.get(6)%></td>
				                          </logic:equal>
				                           <td>				                           	  
				                           	  <font class="mobileNo" style="display:none"><% out.print(list.get(43)); %></font>
				                           	  <font class="isConfirmed" style="display:none"><% out.print(list.get(24)); %></font>
				                           	  <font class="parentWellnessCenter" style="display:none"><% out.print(list.get(70)); %></font>
				                           	  <font class="priority" style="display:none"><% out.print(list.get(71)); %></font>
				                           	  <font class="internalqueueno" style="display:none"><% out.print(list.get(72)); %></font>
				                           	  <font class="internamequeuenovisit" style="display:none"><% out.print(list.get(73)); %></font>
				                           	  <font class="queuesymbol" style="display:none"><% out.print(list.get(74)); %></font>
				                           	  <font class="displayqueueno" style="display:none"><% out.print(list.get(75)); %></font>
				                           	  <font class="queuestatus" style="display:none"><% out.print(list.get(76)); %></font>
				                           	  
				                           	  		
				                           	  <font class="cardColor" style="display:none"><% out.print(list.get(69)); %></font>	
				                           	  <font class="cardValidityDate" style="display:none"><% out.print(list.get(66)); %></font>
				                           	  <font class="cardValidityStatus" style="display:none"><% out.print(list.get(67)); %></font>
				                           	  <font class="patientPhotoName" style="display:none"><% out.print(list.get(68)); %></font>
				                           	  
				                           	  <font class="patRoomNo" style="display:none"><% out.print(list.get(7)==null ? "-" : list.get(7)); %></font>
				                           	  <font class="patDeptUnit" style="display:none"><%=list.get(22)+"/"+list.get(23)%></font>
					                          <font class="patEpisodeCode" style="display:none"><%=list.get(10)%></font>
					                          <font class="patEpisodeVisitNo" style="display:none"><%=list.get(11)%></font>
					                          <font class="patLastVisitDate" style="display:none"><%=list.get(18)==null?"":list.get(18)%></font>
					                          <font class="patVisitType" style="display:none"><%=list.get(27)==null?"":list.get(27).equals("1")?"OPD General":"" %><%=list.get(27)==null?"":list.get(27).equals("2")?"Emergency MLC":"" %><%=list.get(27)==null?"":list.get(27).equals("3")?"Emergency Non MLC":"" %><%=list.get(27)==null?"":list.get(27).equals("4")?"OPD Special":"" %></font>  <!-- Check for Null condition added by Timsi to handle NullPointerException. -->
					                          <font class="patGaurdianName" style="display:none"><%=list.get(8)%></font>
					                          <font class="patHospitalCode" style="display:none"><%=list.get(26)%></font>
					                          <font class="patSeatId" style="display:none"><%=list.get(34)%></font>
					                          <font class="patConsultantName" style="display:none"><%=list.get(51) %></font>
					                          <font class="patOthersDetails" style="display:none"><%=list.get(52) %></font>
					                          <font class="UMIDFlagVal" style="display:none"><%=list.get(53) %></font>
					                          <font class="patAdd" style="display:none"><%=list.get(55) %></font>
					                          <font class="timeOfVisit" style="display:none"><%=list.get(62) %></font> 
					                        
					                        <% if(list.get(60).toString().equals("1")){
					                        	 if(list.get(24).equals("1")) {  //out.print(list.get(31)); %>
					                        	  <logic:equal name="DoctorDeskFB" property="isScriber" value="0">
					                        	  		<% if(callStatus.equals("0") || callStatus.equals("2")){ %>
															<button type="button" class=" btn-his  btnPatData prescriptionColBtn btnnewrx" data-toggle="tooltip" title="click for patient Precription" onclick="return showPrescription(this,0)">Rx</button>
															<button type="button" class=" btn-his-outline  btnPatData" data-bs-toggle="modal" onclick="showSickModal(this)">Sick & Fit</button>
															<button type="button" class=" btn-his-outline  btnPatData" data-bs-toggle="modal" onclick="OpenReferralModal(this)">Refer Patient</button>
															
															<% 
						                      		 			if(!list.get(44).equals("1")){
						                    				%>
															<button type="button" class=" btn-his-outline  btnPatData opdVitalBtn" style="" onclick="openModalForVital(this,event);"  >Vitals/GE</button>
															<%} %>
															<button type="button" class=" btn-his-outline btnPatData  skipPatient" style="" onclick="skipPatient(this,event);"  >Skip</button>
															
															
															<%
															if(ISSMARTQMSENABLED!=null && ISSMARTQMSENABLED.equals("1")){
																if(list.get(74)!=null &&( list.get(74).equals("E") ||list.get(74).equals("P"))){ %>
																	<button type="button" class="btn btn-his-outline btnPatData btn-sm changepriority" style="" onclick="BackToPool(this,event);"  >No Priority</button>
															<%} }%>
														<%} %>
												  </logic:equal>	
												  <logic:equal name="DoctorDeskFB" property="isScriber" value="1">
												  	 <% 
						                      		 if(!list.get(44).equals("1")){
						                    			%> 
												  	<button type="button" class=" btn-his  opdVitalBtn" style="" onclick="openModalForVital(this,event);"  >Vitals/GE</button>
												  	<%} %>
												  </logic:equal>						                      		
					                          <% } 
					                           else { %>
					                           		<logic:equal name="DoctorDeskFB" property="isScriber" value="0">
					                        	   		<button type="button" class=" btn-his  btnPatData prescriptionColBtn" onclick="return showPrescription(this,1)">Modify Rx</button>
					                        	   		<button type="button" class=" btn-his-outline  btnPatData" data-bs-toggle="modal" onclick="showSickModal(this)">Sick & Fit</button>
					                        	   		<button type="button" class=" btn-his-outline  btnPatData" data-bs-toggle="modal" onclick="OpenReferralModal(this)">Refer Patient</button>
					                        	   		
					                        	   	</logic:equal>	
					                         <%   } 
					                           
					                        %> 
					                         <!-- <button type="button" class="btn btn-outline-success btn-sm prescriptionColBtn" onclick="return showPrescription(this,event)">Rx</button> -->
				                            
				                            
				                                 
				                            
				                            
				                          <%  }%>
				                             </td>
				                             
				                          <td>
				                         
				                           <% 
				                           //System.out.println("list.get(54) - "+list.get(54));
				                           //System.out.println("list.get(42) - "+list.get(42));
				                           if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).equals("")) { %>
				                          	<button type="button" class=" btn-his-outline btnPatData printPrescriptionMainDeskTriggerBtn" onclick="printPrescriptionMainDeskFun(this);">Reprint</button>
				                          <% } else{
				                        	  //if(list.get(24).equals("2")) {
				                        		if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Immediate")){  
				                          %>
				                          	<button type="button" class="buttonTriage button3" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Immediate")){ %>
				                          	<span class="label label-warning" style="font-size: 100%"><%=list.get(54)%></span>
				                          <%}else if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Observation")){ %>
				                          	<button type="button" class="buttonTriage button6" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Observation")){ %>
				                          	<span class="label label-warning" style="font-size: 100%"><%=list.get(54)%></span>
				                          <%}else if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Wait")){ %>
				                          	<button type="button" class="buttonTriage" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Wait")){ %>
				                          	<span class="label label-success" style="font-size: 100%"><%=list.get(54)%></span>
				                          <%}else if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Expectant")){ %>
				                          	<button type="button" class="buttonTriage button5" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Expectant")){ %>
				                          	<span class="label label-default" style="font-size: 100%"><%=list.get(54)%></span>
				                          <%}else if(!list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Non Urgent")){ %>
				                          	<button type="button" class="buttonTriage button4" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null && list.get(54).contains("Non Urgent")){ %>
				                          	<span style="font-size: 100%; background-color: #e7e7e7; color: black;"><%=list.get(54)%></span>
				                          <%}else if(!list.get(42).equals("0") && list.get(54)!=null){ %>
				                          	<button type="button" class="buttonTriage button2" onclick="printPrescriptionMainDeskFun(this);"><%=list.get(54)%></button>
				                          <%}else if(list.get(42).equals("0") && list.get(54)!=null){ %>
				                          	<span class="label label-info" style="font-size: 100%"><%=list.get(54)%></span>
				                          <%}
				                        	  }%>
				                          </td>
				                          <td class="patIsPrescUploaded"><a style="cursor: default;background-color:#cf4e24" class="label label-success"><%=(list.get(41).equals("0")? "":"P")%></a></td>  
				                          <input type="hidden" name="patCompleteGeneralDtl" value="<%=list.get(5)+"#"+list.get(6)+"#"+list.get(7)+"#"+list.get(8)+"#"+list.get(11)+"#"+list.get(13)+"#"+list.get(14)+"#"+list.get(17)+"#"+list.get(22)+"#"+list.get(23)+"#"+list.get(19)+"#"+list.get(35)+"#"+list.get(36)+"#"+list.get(37)+"#"+list.get(43)+"#"+list.get(42)+"#"+list.get(45)+"#"+list.get(46)+"#"+list.get(47)+"#"+list.get(48)+"#" %>" >
				                           <input type="hidden" name="patCompleteGeneralDtl1" value='<%=list.get(49)%>' >
				                           <input type="hidden" name="teleConsultancyRequestId" value='<%=list.get(50)%>' >
				                           <!-- ################ Added for reason for visit from registration #################### -->
				                           <input type="hidden" name="ReasonForVisitFormRegistration" value='<%=list.get(5)%>' >
				                           <!-- ################ Added for reason for visit from registration end #################### -->
				                           <input type="hidden" name="isPatReferredId" value='<%=list.get(31)%>' >
									  </tr>
									   
									<%   
									    
							  }  
					%> 
					                   </tbody>
					                  </table>  
					                  <legend>Legends</legend>
					                  <p style="display:inline-block"><i class="fa fa-circle" style="color:#7896e3"></i> New Visit</p>
					                  <p style="display:inline-block; margin-left:20px;"><i class="fa fa-circle"></i> Old Visit</p>
					                  <!-- <p style="display:inline-block; margin-left:20px;"><i class="fa fa-circle" style="color:#E0A800"></i> Refered In</p> 
								      <p style="display:inline-block; margin-left:20px;"><i class="fa fa-circle" style="color:blanchedalmond"></i> Pensioner with FMA</p>
								      <p style="display:inline-block; margin-left:20px;"><i class="fa fa-circle" style="color:lightcyan"></i> Outsider</p>
								      <p style="display:inline-block; margin-left:20px;"><i class="fa fa-circle" style="color:#f7c0c0;"></i>&nbsp;High Risk Pregnancy</p> --> 
								      <!-- <p style="display:inline-block; margin-left:20px;"><i class="fa fa-plus-square" style="color:fuchsia"></i> Triage Completed</p> 
								      <p style="display:inline-block; margin-left:20px;"><i class="fa fa-plus-square" style="color:red"></i> Triage Continue</p> 
								     --></div>  
   									<div class="col-sm-12 uk-card uk-card-default uk-card-hover rightPanel" style="display: none;">
						      		<button style="float: right;padding:8px 18px !important;margin:1px;border-radius: 10px !important;" class="btn-his-outline-danger rightPanelClose" type="button" onclick="hidePrescription(this,event)">x</button>
						      		<!-- <button style="float: right;padding:4px 12px;" class="btn btn-outline-success btn-sm shortcutInfoRightPanel" onclick="$('#shortcutKeysModal').modal('show');" type="button"><i class="fa fa-info"></i></button> -->
						      		<!-- <button style="float: right;padding:4px 12px; color:#87c540" class="btn btn-outline-success btn-sm patSearchRightPanel" onclick="$('#patientSearchModal').modal('show');" type="button"><i class="material-icons">search</i></button> -->
						      	<!-- 	<button id="patSideListBtn" style="float: right;padding:4px 12px; color:#4067c5" class="btn-his-outline" type="button"><i class="fa fa-users"></i></button>						       		
						       		<button id="patientSumBtn" style="float: right;padding:4px 12px; color:#4067c5" class="btn-his-outline patientSumBtn" type="button" onclick="patientSumBtnToggleFun()"><i class="fa fa-wheelchair"></i></button> -->	
						       		<!-- <button style="float: right;padding:4px 12px; color:#4067c5" class="btn btn-outline-success btn-sm fullScreenDeskBtn" type="button" onclick=""><i class="glyphicon glyphicon-fullscreen"></i></button> -->
						       		<!-- <button style="float: right;padding:4px 12px; color:#4067c5" class="btn btn-outline-success btn-sm videocallList" type="button" onclick="videocallList(this)"><i class="glyphicon glyphicon-facetime-video"></i></button> -->						       		
						       	</div>  
						       </div>  
						    </div>
						  </div>
						</div>       
       				

  <input type="hidden" name="hmode"/>
  <input type="hidden" name="isCalledFromListpage" id='isCalledFromListpage' />
  
  
      <input type="hidden" name="internalqueueno" id="internalqueueno" />
      <input type="hidden" name="internamequeuenovisit" id="internamequeuenovisit" />
      <input type="hidden" name="queuesymbol" id="queuesymbol" />
      <input type="hidden" name="displayqueueno" id="displayqueueno" />
      <input type="hidden" name="queuestatus" id="queuestatus" />
   
  
  <input type="hidden" name="strInitialMode" value="${DoctorDeskFB.strInitialMode}"/>
  <input type="hidden" name="strHospitalAddres" value="${DoctorDeskFB.strHospitalAddres}"/>
<input type="hidden" id="strHospitalName" name="strHospitalName" value="${DoctorDeskFB.strHospitalName}"/>
  <input type="hidden" name="strSeatId" value="${DoctorDeskFB.strSeatId}"/>
  <input type="hidden" name="strHiddenDeptCode" value="${DoctorDeskFB.strHiddenDeptCode}"/>
  <input type="hidden" name="strHospitalCode" value="<%=session.getAttribute("HOSPITAL_CODE")%>"/>
  <input type="hidden" name="currentDate" id='currentDate' value="${DoctorDeskFB.currentDate}"/>
  
  
  
  
  <div class="modal fade" id="shortcutKeysModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Shortcut Keys</h2>
        </div>
        <div class="modal-body text-left">   
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>Key</th><th>Description</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>Ctrl+s</td><td>Prescription Print Preview</td>
								</tr>
								<tr>
									<td>Ctrl+f</td><td>Open Search popup</td>
								</tr>
								<tr>
									<td>Ctrl+i</td><td>Open Investigation Reports</td>
								</tr>
								<tr>
									<td>Ctrl+m</td><td>Open Mini List</td>
								</tr>
								<tr>
									<td>Ctrl+p</td><td>Open Prescription Image</td>
								</tr>
								<!-- <tr>
									<td>Ctrl+shift+n</td><td>Next Patient Prescription</td>
								</tr> -->
								<tr>
									<td>Esc</td><td>To close any Popup</td>
								</tr>
							</tbody>
						</table> 
					</div>
				</div>
	      </div> 
	    </div>
	  </div>
</div> 
<button type="button" id="prescModalTriggerBtn" style="display: none;" href="#modal-container" uk-toggle></button>

<div id="modal-container" class="uk-modal-container" uk-modal>
    <div class="uk-modal-dialog uk-modal-body prescModalBody" style="height: 85vh;">
        <button class="uk-modal-close-default prescModalCloseBtn" type="button" uk-close></button> 
    </div>
</div>

<!-- <button id="prescModalTriggerBtn" style="display: none;" class="btn btn-default" type="button" data-toggle="modal" data-target="#prescModal"></button>
   <div class="modal fade" id="prescModal" role="dialog">
    <div class="modal-dialog modal-lg">
     
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Patient Clinical Details</h4>
        </div>
        <div class="modal-body prescModalBody" style="height: 85vh;">
          
        </div> 
      </div>
      
    </div>
  </div> -->

  <!-- Modal - Patient Detail-->
  <div class="modal fade" id="patListStatModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Patient Stats (Under Development)</h2>
        </div>
        <div class="modal-body text-left">   
        		<!-- <p>Total : 100</p>
        		<table class="table table-hover">
        			<thead>
        				<tr>
        					<th></th><th>Walk In</th><th>Appointment</th><th>Casuality</th>
        				</tr>
        			</thead>
        			<tbody>
        				<tr>
        					<td>Total Patient (100) : </td><td>70</td><td>20</td><td>10</td>
        				</tr>
        				<tr>
        					<td>Attended (14) : </td><td>3</td><td>6</td><td>5</td>
        				</tr>
        				<tr>
        					<td>Waiting (86) : </td><td>67</td><td>14</td><td>5</td>
        				</tr>
        			</tbody>
        		</table> -->

	      </div> 
	    </div>
	  </div>
</div>
 
  <!-- Modal - Patient Detail-->
  <div class="modal fade" id="patientDtlModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Patient Detail</h2>
        </div>
        <div class="modal-body">
          <table class="table table-hover">
            <thead> 
            </thead>
            <tbody>
              <tr>
                <td><b>Name</b></td><td><p class="patName">Patient 1</p></td>
              </tr>
              <tr>
                <td><b>BEN ID.</b></td><td><p class="patCrNo">33456738328939</p></td>
              </tr>
              <tr>
                <td><b>Gender</b></td><td><p>Male</p></td>
              </tr>
              <tr>
                <td><b>Age</b></td><td><p>23</p></td>
              </tr>
              <tr>
                <td><b>Father Name</b></td><td><p>Father</p></td>
              </tr>
            </tbody>
          </table>
        </div>  
      </div> 
    </div>
  </div>
  
  <div class="modal fade" id="printPrescriptionMainDeskModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:85%" >       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#printPrescriptionMainDeskModal').modal('hide');$('#printPrescFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  <div class="modal fade" id="ReferralListModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:85%" >    
      <div class="modal-content">
        <div class="modal-header">
          <div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">Patient Transferred From Other OPD List</h3></div>
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#ReferralListModal').modal('hide');$('#ReferralListModalFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div>
  
  
  
  <div class="modal fade" id="ReferralHistoryModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:85%" >    
      <div class="modal-content">
        <div class="modal-header">
        	<div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">Referral History</h3></div>
        	<button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#ReferralHistoryModal').modal('hide');$('#ReferralHistoryModalFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  <div class="modal fade" id="pateintReviewModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:85%" >    
      <div class="modal-content">
        <div class="modal-header">
          <div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">Patient Review</h3></div>	
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#pateintReviewModal').modal('hide');$('#pateintReviewModalFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div>
  
  <div class="modal fade" id="drLeaveModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width:85%" >    
      <div class="modal-content">
        <div class="modal-header">
          <div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">Doctor Leave</h3></div>	
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#drLeaveModal').modal('hide');$('#drLeaveModalFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
				

<div id="patientSearchModal" class="modal fade" role="dialog">
  <div class="modal-dialog"> 
    <!-- Modal content-->
    <div class="modal-content">
     <!--  <div class="modal-header">
        <h4 class="modal-title">Search Patient</h4>
      </div> -->
      <div class="modal-body"> 
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <div class="uk-search uk-search-navbar mainHeaderSrch" style="border: 1px solid #d7d7d7; margin-bottom: 3px;margin-left: auto; margin-right:auto; display:block;">
 		    <span uk-search-icon="" class="uk-search-icon uk-icon"><svg width="24" height="24" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><circle fill="none" stroke="#000" stroke-width="1.1" cx="10.5" cy="10.5" r="9.5"></circle><line fill="none" stroke="#000" stroke-width="1.1" x1="23" y1="23" x2="17" y2="17"></line></svg></span>
  	        <input id="uk-search-input2" class="uk-search-input" placeholder="Search..." onkeyup="globalSearch2(this,event)" onfocus="globalSearch2(this,event)" maxlength="15" list="searchPatLst2" type="search"> 
  	        <datalist id="searchPatLst2"> 
  	          </datalist>
  	        </div>
      </div> 
    </div> 
  </div>
</div>

<div class="modal fade" id="PoolPatientListModal" role="dialog">
    <div class="modal-dialog modal-xl" style="width:95%" >    
      <div class="modal-content">
        <div class="modal-header">
          <div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">OPD Pool Patient List</h3></div>
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#PoolPatientListModal').modal('hide');$('#PoolPatientListModalFrameId').remove();">Cancel</button>
			 </div> 
        </div>  
      </div> 
    </div>
  </div>
  
  <div class="modal fade" id="ReferralModal" role="dialog" style="margin-top: -28px;!important">
	<div class="modal-dialog modal-xl" style="width: 100% !important">  
      <div class="modal-content">
        <div class="modal-header">
          <div style="width: 50%;float:left;"><p style="text-align:left;font-weight: bold;font-size: 18px;">Patient Referral Detail</p></div>
          <button type="button" class="btn btn-danger" style="float: right;" onclick="$('#ReferralModal').modal('hide');$('#ReferralModalFrameId').remove();">Cose</button> 
        </div>
        <div class="modal-body" style="padding: 5px;">
       		 
        </div>  
      </div> 
    </div>
  </div>
   
<button id="emrModalTriggerBtn" style="display: none;" class="btn btn-default" type="button" data-toggle="modal" data-target="#emrModal"></button>
  <!-- Modal -->
  <div class="modal fade" id="emrModal" role="dialog">
    <div class="modal-dialog modal-lg" style="width: 90%;">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">EMR</h4>
        </div>
                <div class="modal-body" style="height: 95vh;">
        	<!-- <div class="row">
        		<div style="text-transform: uppercase;" class="col-sm-6">
        			<p class="emrPatName">Patient Name</p>
        		</div>
        		<div class="col-sm-6">
      			    <p class="emrPatCrNo" style="float: right">3353131321321</p>
        		</div>
        	</div> -->
        
        <div class="row">
          <div id="jstree_demo_div" class="col-sm-3" style="max-width: 30%; overflow-x: hidden;">
            <ul> 
              <li>All
                <ul> 
                  <li>CHB
                  <ul>
                    <li>OPD Wise
                      <ul>
                        <li>Cardiology(CY UT 01)
                          <ul>
                            <li>Episode::1
                              <ul>
                                <li>Enc::1 (12-Jun-2018)</li>
                              </ul>
                            </li>
                          </ul>
                        </li>
                      </ul>
                    </li>
                    <li>IPD Wise
                      <ul>
                        <li>AdmissionNo::211012018000209</li>
                      </ul>
                    </li> 
                  </ul>
                  </li>
                </ul>
              </li>
            </ul>
          </div>
          <div class="col-sm-7">
             <ul class="nav nav-tabs">
              <li class="active"><a data-toggle="tab" href="#tab">Patient Detail</a></li>
              <li><a data-toggle="tab" href="#tab1">Reason Of Visit</a></li>
              <li><a data-toggle="tab" href="#tab2">Diagnosis</a></li>  
              <li><a data-toggle="tab" href="#tab3">Investigation</a></li>  
            </ul>
            <div class="tab-content">
              <div id="tab" class="tab-pane fade in active">
                <h4 style="background-color: #009eed; color: white;">Patient Detail</h4> 
                <table class="table table-condensed table-hover table-striped">
                  <tbody>
                    <tr>
                      <td>Name</td>
                      <td><b>Patient</b></td>
                      <td>CRN.</td>
                      <td><b>211011800004461</b></td>
                      <td>Age/Gender</td>
                      <td><b>22 Y/Male</b></td>
                    </tr>
                    <tr>
                      <td>Primary Category</td>
                      <td><b>General</b></td>
                      <td>Marital Status</td>
                      <td><b>Single</b></td>
                      <td rowspan="3">Picture</td>
                      <td rowspan="3"><img class="img-responsive img-circle" src="/HISDRDESK_MC/new_opd/img/img_avatar.png" style="width: 75px"></td>
                    </tr> 
                    <tr>
                      <td>Father Name</td>
                      <td><b>General</b></td>
                      <td>Mother Name</td>
                      <td><b></b></td> 
                    </tr>
                    <tr>
                      <td>Spouse Name</td>
                      <td><b></b></td>
                      <td>Religion</td>
                      <td><b></b></td> 
                    </tr>
                    <tr>
                      <td>Monthly Income</td>
                      <td><b>Rs. 0.00</b></td>
                      <td>National ID</td>
                      <td><b></b></td> 
                    </tr>
                    <tr>
                      <td>Adm. No.</td>
                      <td><b>2111012018000209</b></td>
                      <td>Admission Date</td>
                      <td><b>12-Jun-2018</b></td>
                      <td>Speciality/Dr. Name</td>
                      <td><b>Cardiology/ CY UT 01</b></td>
                    </tr>
                    <tr>
                      <td>Ward/ Room No.</td>
                      <td><b>Ward1/General Room 1</b></td>
                      <td>Bed No</td>
                      <td><b>Rtert</b></td>
                      <td></td>
                      <td><b></b></td>
                    </tr>
                  </tbody>
                </table> 
                <h4 style="background-color: #009eed; color: white; margin: 0px;">Address Detail</h4> 
                <table class="table table-hover table-condensed table-striped">
                  <thead>
                    <tr>
                      <th><i class="fa fa-home"></i> Current Address</th>
                      <th><i class="fa fa-home"></i> Permanent Address</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>324, Khordha, Sadfad, India</td>
                      <td>324, Khordha, Sadfad, India</td>
                    </tr>
                  </tbody>
                </table>
                <hr>
                <div class="row text-center">
                  <button type="button" class="btn btn-info">Cancel</button>
                </div>
              </div>
              <div id="tab1" class="tab-pane fade">
                <h4 style="background-color: #009eed; color: white;">Reason Of Visit</h4>
              </div>
              <div id="tab2" class="tab-pane fade">
                <h4 style="background-color: #009eed; color: white;">Diagnosis</h4>
              </div>
              <div id="tab3" class="tab-pane fade">
                <h4 style="background-color: #009eed; color: white;">Investigation</h4>
              </div>
            </div>
        </div>
        </div> 
      </div>
      </div>      
    </div> 
  </div> 
 
  
 <div class="modal fade" id="sickFitModal" role="dialog">
  <div class="modal-dialog" style="width: 90%;">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title" id="sickFitModalLabel">Sick & Fit Details</h2>
        <div style="margin-top: -30px;display: flex;justify-content: end;">
          <button type="button" class="btn btn-secondary" style="margin-right: 20px;" data-bs-dismiss="modal" onclick="window.location.reload();">X</button>
        </div>

      </div>
      <div class="modal-body">
        <div class="row">
        <div class="col-md-6">
        	<h4>Medical Certificate for Sick & Fit</h4>
        </div>
			<div class="col-md-6" style="display: flex; flex-direction: column; align-items: center;">
			    <!-- Buttons in a horizontal row -->
			    <div style="display: flex; gap: 10px;">
			        <button type="button" id="sickFormID" class="btn btn-outline-success btn-sm" >Sick Medical certificate</button>
 			        <!-- <button type="button" id="fitFormID" class="btn btn-outline-success btn-sm">Fit Medical certificate</button>  -->
			    </div>

			        </div>
			        
		<div class="col-md-12" style="display: flex; flex-direction: column; align-items: center;">
        	
	        <table class="table table-hover" id="patientDetailsTable">
	          <thead></thead>
	          <tbody>
	            <!-- Rows will be populated dynamically -->
	          </tbody>
	        </table>
        </div>
 <!-- Hidden Form for Sick Certificate Details -->
 <div class="col-sm-12">

<div id="sickFormDetails" style="display: none; margin-top: 20px;">
<hr class="border border-success border-3 opacity-75">
		<h2 class="text-center text-bold" style="margin-top: 0;">Sick Certificate</h2>
		  				
			
		    <!-- Form Row for Illness, Designation, Absence Period -->
		    <div class="form-row">
		      <div class="col-md-6">
		      		      <div class="form-group col-md-10">
		          <label for="illness">Diagnosed Illness:</label>
		          <input type="text" class="form-control" id="illness" placeholder="Enter illness" required="">
		        </div>

<!-- 		        <div class="form-group col-md-10">
		          <label for="absencePeriod">Absence From:</label>
		          <input type="date" id="absenceFrom" required class="form-control">

		        </div> -->
			      	<div class="form-group col-md-10">
		          <label for="remarks">Remarks:</label>
		          <input type="text" class="form-control" id="remarks" placeholder="Enter remarks" required="">
		        </div>
		      </div>

		      <div class="col-md-6">

		      <div class="form-group col-md-10">
		      	<div class="mb-3 col-md-6" >
		          <label for="absencePeriod">Effective Date:</label>
		          <input type="date" id="effectiveDate" required class="form-control" readonly>
		          
		          <script>
    // Get today's date in YYYY-MM-DD format
    const today = new Date().toISOString().split('T')[0];

    // Set the default date
    document.getElementById("effectiveDate").value = today;
</script>
		        </div>
		        <div class="mb-3 col-md-6" >    
		          <label for="designation">Absence Period:</label>
		          <input type="number" class="form-control"  id="designation" min="1" max="15" placeholder="Days"  required>
		        </div>
		    </div>
		    </div>
		
		    <!-- SaveButton -->
						<!-- <div id="sickForms" style="display: none; margin-top: 20px;"> -->
					<div style="justify-content: center;display: flex;" class="justify-content-center d-flex  col-md-12">
						        <label class="me-5" style="margin-right: 30px;">
						            <!-- <input class="radio-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3" onclick="openForm3Modal(3)"> -->
									<button type="button" class="btn btn-outline-success btn-sm" name="flexRadioDefault" id="flexRadioDefault3" onclick="openForm3Modal(3)">Save</button>
						        </label>
<!-- 						        <label>
									<button type="button" class="btn btn-outline-success btn-sm" name="flexRadioDefault" id="flexRadioDefault4" onclick="openForm4Modal(4)">Save Form4</button>
						        </label> -->
						    </div>
						<!-- </div> -->
		  
		</div>
		 </div>
<div class="col-sm-12">
<div id="sickLeaveExt" style="display: none; margin-top: 20px;">
<hr class="border border-success border-3 opacity-75">
		<h2 class="text-center text-bold" style="margin-top: 0;">Leave Extention</h2>
		  				
			
		    <!-- Form Row for Illness, Designation, Absence Period -->
		    <div class="form-row">
		      <div class="col-md-6">
		      		      <div class="form-group col-md-10">
		          <label for="illness">Diagnosed Illness:</label>
		          <input type="text" class="form-control" id="illnessE" readonly="">
		        </div>

<!-- 		        <div class="form-group col-md-10">
		          <label for="absencePeriod">Absence From:</label>
		          <input type="date" id="absenceFrom" required class="form-control">

		        </div> -->
			      	<div class="form-group col-md-10">
		          <label for="remarks">Remarks:</label>
		          <input type="text" class="form-control" id="remarksE" placeholder="Enter remarks" required="">
		        </div>
		      </div>

		      <div class="col-md-6">

		      <div class="form-group col-md-10">
		      	<div class="mb-3 col-md-6">
		          <label for="absencePeriod">Effective Date:</label>
		          <input type="date" id="effectiveDateE" required="" class="form-control" readonly="">

		        </div>
		        <div class="mb-3 col-md-6">    
		          <label for="designation">Absence Period:</label>
		          <input type="number" class="form-control" id="designationE" min="1" max="15" placeholder="Days" required="">
		         

		        </div>
		        <input type="hidden" id="tempMedNoEHidden" name="tempMedNoE" value="">
		    </div>
		    </div>
		
		    <!-- SaveButton -->
						<!-- <div id="sickForms" style="display: none; margin-top: 20px;"> -->
					<div style="justify-content: center;display: flex;" class="justify-content-center d-flex  col-md-12">
						        <label class="me-5" style="margin-right: 30px;">
						            <!-- <input class="radio-input" type="radio" name="flexRadioDefault" id="flexRadioDefault3" onclick="openForm3Modal(3)"> -->
									<button type="button" class="btn btn-outline-success btn-sm" name="flexRadioDefault" id="flexRadioDefault3" onclick="leaveExtSaveDtls(this)">Save</button>
						        </label>
<!-- 						        <label>
									<button type="button" class="btn btn-outline-success btn-sm" name="flexRadioDefault" id="flexRadioDefault4" onclick="openForm4Modal(4)">Save Form4</button>
						        </label> -->
						    </div>
						<!-- </div> -->
		  
		</div>
		 </div>
		</div>
		<div class="col-sm-12">
		<div id="patDiagnosisDiv" style="display: block">
		<div>			
		<h3>Patient Diagnosis Records</h3>
			<table id="generalDiagnosisTable" class="table">
			    <thead></thead>
			    <tbody></tbody>
			</table>
			</div>

			<div >
<!-- 			<h3>Medical Board Evaluation</h3>
			<table id="medicalBoardTable" class="table">
			    <thead></thead>
			    <tbody></tbody>
			</table>
			<div>
          </div> -->
          
          <input type="hidden" id="patNameId" name="patName" value=""/>
          </div>
 
        </div>
      </div>

    </div>

  </div>
        <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="window.location.reload();">Close</button>
      </div>
</div>
</div>
  </div>
  </div>
  <!-- Changed line - added 'modal-dialog-scrollable' class -->
<!-- <div id="form3" class="modal-dialog modal-lg modal-dialog-centered modal-fullscreen-md-down modal-dialog-scrollable" tabindex="-1" aria-labelledby="form3ModalLabel" aria-hidden="true"> -->

<div class="modal fade scroll-mcform" id="form3" style="display: none;" tabindex="-1" aria-labelledby="form3ModalLabel" aria-hidden="true"> 
  <div class="modal-dialog modal-lg modal-dialog-centered modal-fullscreen-md-down"> 
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title text-center" id="fitModalLabel">Form 3/4 &#x92E;&#x947;&#x921;&#x93F;&#x915;&#x932;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930; (Medical Certificate)</h5>
        <div style="margin-top: -30px;display: flex;justify-content: end;">
          <button type="button" class="btn btn-secondary" style="margin-right: 20px;" data-bs-dismiss="modal">X</button>
          <button class="btn btn-info" style="z-index:9999;" type="button" onclick="printToPdfForMCForm()">Print</button>
        </div>
      </div>
      
      <div class="modal-body">
        <div style="right:8px; position:fixed" class="prHeader" id="prHeaderr">
          <label class="withHeaderLabel" style="z-index: 99999;display: none;">
            <input type="checkbox" name="withHeaderCheck" value="1">&nbsp; &#x939;&#x947;&#x921;&#x930;&#x20;&#x915;&#x947;&#x20;&#x92C;&#x93F;&#x928;&#x93E; (Without Header)
          </label>
          <br>
        </div>

        <div id='divPrintable'>
          <!-- Header starts here -->
          <table>
            <thead>  
              <tr>
                <td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
                <td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;">CENTRAL GOVERNMENT HEALTH SCHEME / &#x915;&#x947;&#x902;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E; </h4>
                  <h4 style='font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;'>MINISTRY OF HEALTH AND FAMILY WELFARE/ &#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x914;&#x930;&#x20;&#x92A;&#x930;&#x93F;&#x935;&#x93E;&#x930;&#x20;&#x915;&#x932;&#x94D;&#x92F;&#x93E;&#x923;&#x20;&#x92E;&#x902;&#x924;&#x94D;&#x930;&#x93E;&#x932;&#x92F;</h4>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >GOVERNMENT OF INDIA / &#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930; </h4> 
				<h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >MEDICAL CERTIFICATE / &#x91A;&#x93F;&#x915;&#x93F;&#x924;&#x94D;&#x938;&#x915;&#x940;&#x92F;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;</h4>
					<h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;">Certificate No (&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x938;&#x902;&#x916;&#x94D;&#x92F;&#x93E;) :<span id="medCertiNoID"></span> </h4>
                  
                </td>
                <td style="width:15%;text-align: center;"><span id="patQrCode" title="https://muhseclinic.uat.dcservices.in/ST/su?key=428673EE"><canvas width="100" height="100" style="display: none;"></canvas><img style="display: block;" src="data:image/png;base64,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"></span></td>
              </tr>
            </thead> 
          </table>
          
          <hr class="border border-success border-3 opacity-75">
          
          <!-- Medical Certificate details starts here -->
          <div class="letter">
            <div class="header">
            <%HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);%>
               <table>
				<thead>  
				  <tr>
					<td style="width:50%;font-weight: bold;">Date (&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915;) : <span id="current-date" style="font-weight: normal;"></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">Time (&#x938;&#x92E;&#x92F;) : <span id="timeMcId" style="font-weight: normal;"></span></td>
				  </tr>
				  <tr>
					<td style="width:50%;font-weight: bold;">Beneficiary Id (&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x906;&#x908;&#x921;&#x940;) : <span id="benId" style="font-weight: normal;" ></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">CGHS WC (&#x938;&#x940;&#x91C;&#x940;&#x90F;&#x91A;&#x90F;&#x938;&#x20;&#x921;&#x92C;&#x94D;&#x932;&#x94D;&#x92F;&#x942;&#x938;&#x940;) : <span style="font-weight: normal;"><%=objHospitalMstVO.getHospitalName() %></span></td>
				</tr>
				</thead> 
			</table>
			<br>
            <p>SIGNATURE OF APPLICANT (&#x906;&#x935;&#x947;&#x926;&#x915;&#x20;&#x915;&#x947;&#x20;&#x939;&#x938;&#x94D;&#x924;&#x93E;&#x915;&#x94D;&#x937;&#x930;)</p>
              <!-- <p>सरकारी कर्मचारी के हस्ताक्षर </p> -->
              <br>
            </div>
            <div class="content">
       <p>I, after careful personal examination of the case, hereby certify that  <span id="patient-name" style="font-weight: bold;">  </span>
       <span id="orgNameID" style="font-weight: bold;"></span> whose signature is given above is suffering from
       <span id="illnessId" style="font-weight: bold;"></span> 
       and I consider that a period of absence from duty of <span id="designationId" style="font-weight: bold;">/Days</span>
       With effect from <span id="effective-date" style="font-weight: bold;">  </span> 
       with effect from today absolutely necessary for the restoration of his/her health.</p>
       
              <br>
              <p>
               &#x20;&#x92E;&#x948;&#x902;&#x2C; <span id="consultant-name" style="font-weight: bold;"></span> &#2352;&#2379;&#2327;&#2368;&#32;&#2325;&#2368;&#32;&#2343;&#2381;&#2351;&#2366;&#2344;&#2346;&#2370;&#2352;&#2381;&#2357;&#2325;&#32;&#2357;&#2381;&#2351;&#2325;&#2381;&#2340;&#2367;&#2327;&#2340;&#32;&#2346;&#2352;&#2368;&#2325;&#2381;&#2359;&#2366;&#32;&#2325;&#2375;&#32;&#2348;&#2366;&#2342;&#32;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#2367;&#2340;&#32;&#2325;&#2352;&#2340;&#2366;&#32;&#2361;&#2370;&#2305;&#32;&#2325;&#2367; 
     <span id="orgNameIDHin" style="font-weight: bold;"></span> &nbsp; <span id="patient-name" style="font-weight: bold;">
      </span>&nbsp;&#x20;&#x91C;&#x93F;&#x928;&#x915;&#x93E;&#x20;&#x939;&#x938;&#x94D;&#x924;&#x93E;&#x915;&#x94D;&#x937;&#x930;&#x20;&#x90A;&#x92A;&#x930;&#x20;&#x939;&#x948;&#x2C; &nbsp;<span id="illnessId" style="font-weight: bold;"> 
      </span>&nbsp; &#x938;&#x947;&#x20;&#x92A;&#x940;&#x921;&#x93C;&#x93F;&#x924;&#x20;&#x939;&#x948;&#x20;&#x914;&#x930;&#x20;&#x92E;&#x947;&#x930;&#x93E;&#x20;&#x935;&#x93F;&#x91A;&#x93E;&#x930;&#x20;&#x939;&#x948;&#x20;&#x915;&#x93F;&#x20;&#x924;&#x93E;&#x930;&#x940;&#x916; &nbsp;<span id="effective-date" style="font-weight: bold;"></span> &#x938;&#x947;
               <span id="designationId" style="font-weight: bold;"></span>&nbsp; &#x926;&#x93F;&#x928;&#x20;&#x915;&#x940;&#x20;&#x91B;&#x941;&#x91F;&#x94D;&#x91F;&#x940;&#x20;&#x938;&#x947;&#x20;&#x905;&#x928;&#x941;&#x92A;&#x924;&#x20;&#x930;&#x939;&#x928;&#x93E;&#x20;&#x909;&#x928;&#x915;&#x947;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x932;&#x93E;&#x92D;&#x20;&#x915;&#x947;&#x20;&#x932;&#x90F;&#x20;&#x906;&#x935;&#x936;&#x94D;&#x92F;&#x915;&#x20;&#x939;&#x948;&#x20;&#x964;
              </p>
              <br>
              <!-- <p>Remarks: <span id="remarksId" style="font-weight: bold;"></span></p> -->
              <br>
               <br>
				<table class="table">
				  <tbody>
								
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">Printed By [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">NAME OF MEDICAL OFFICER (<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				    </tr>
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x92E;&#x941;&#x926;&#x94D;&#x930;&#x93F;&#x924;   [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x91A;&#x93F;&#x915;&#x93F;&#x924;&#x94D;&#x938;&#x93E;&#x20;&#x905;&#x93F;&#x927;&#x915;&#x93E;&#x930;&#x940;&#x20;&#x915;&#x93E;&#x20;&#x928;&#x93E;&#x92E; (<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				
				    </tr>
				  </tbody>
				</table>

			<p>This is an electronically generated certificate, therefore stamp of doctor is not required.</p>
			<p>&#x92F;&#x939;&#x20;&#x90F;&#x915;&#x20;&#x907;&#x932;&#x947;&#x915;&#x94D;&#x91F;&#x94D;&#x930;&#x949;&#x928;&#x93F;&#x915;&#x20;&#x930;&#x942;&#x92A;&#x20;&#x938;&#x947;&#x20;&#x924;&#x948;&#x92F;&#x93E;&#x930;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x939;&#x948;&#x2C;&#x20;&#x907;&#x938;&#x932;&#x93F;&#x90F;&#x20;&#x907;&#x938;&#x92E;&#x947;&#x902;&#x20;&#x921;&#x949;&#x915;&#x94D;&#x91F;&#x930;&#x20;&#x915;&#x940;&#x20;&#x92E;&#x941;&#x939;&#x930;&#x20;&#x915;&#x940;&#x20;&#x906;&#x935;&#x936;&#x94D;&#x92F;&#x915;&#x924;&#x93E;&#x20;&#x928;&#x939;&#x940;&#x902;&#x20;&#x939;&#x948;&#x964;</p>
              <!-- <p>Date/दिनांक: <span id="current-date"></span></p> -->
            </div>
          </div>

          <!-- Footer starts here -->
          <br>
<!--           <div class="d-flex justify-content-end" style="display: flex; flex-direction: column; align-items: flex-end;">
            <p><span id="consultant-name"></span></p>
            <p><b>Authorized Medical Officer / प्राधिकृत चिकित्सा अधिकारी</b></p>
            <br> -->
            
<%--             <p><%=objHospitalMstVO.getHospitalName() %></p>
            <p><b>Hospital Dispensary / अस्पताल / औषधालय</b></p> --%>
          <!-- </div> -->
          <!-- <p>Date/दिनांक: <span id="current-date"></span></p> -->

<!--           <div id="footer" class="text-center">
            <p><b>किसी भी सरकारी अस्पताल / CGHS मान्यता प्राप्त अस्पताल में संदर्भित करें</b></p>
            <p><b>यह एक कंप्यूटर जनित प्रिंटआउट है, इसलिए डॉक्टर की मुहर आवश्यक नहीं है</b></p>
          </div> -->
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>

<div class="modal fade scroll-mcform" id="form6" style="display: none;" tabindex="-1" aria-labelledby="form3ModalLabel" aria-hidden="true"> 
  <div class="modal-dialog modal-lg modal-dialog-centered modal-fullscreen-md-down"> 
    <div class="modal-content">
      <div class="modal-header">
        
        <div style="display: flex;justify-content: end;">
          <button type="button" class="btn btn-secondary" style="margin-right: 20px;" data-bs-dismiss="modal">X</button>
          <button class="btn btn-info" style="z-index:9999;" type="button" onclick="printToPdfForMCForm2()">Print</button>
        </div>
      </div>
      
      <div class="modal-body">
        <div style="right:8px; position:fixed" class="prHeader" id="prHeaderr">
          <label class="withHeaderLabel" style="z-index: 99999;display: none;">
            <input type="checkbox" name="withHeaderCheck" value="1">&nbsp;&#x20;&#x939;&#x947;&#x921;&#x930;&#x20;&#x915;&#x947;&#x20;&#x92C;&#x93F;&#x928;&#x93E;&#x20;(Without Header)
          </label>
          <br>
        </div>

        <div id='divPrintable2'>
          <!-- Header starts here -->
          <table>
            <thead>  
              <tr>
                <td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
                <td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;">CENTRAL GOVERNMENT HEALTH SCHEME / &#x915;&#x947;&#x902;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;&#x20;</h4>
                  <h4 style='font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;'>MINISTRY OF HEALTH AND FAMILY WELFARE/ &#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x914;&#x930;&#x20;&#x92A;&#x930;&#x93F;&#x935;&#x93E;&#x930;&#x20;&#x915;&#x932;&#x94D;&#x92F;&#x93E;&#x923;&#x20;&#x92E;&#x902;&#x924;&#x94D;&#x930;&#x93E;&#x932;&#x92F;</h4>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >GOVERNMENT OF INDIA / &#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930; </h4> 
				<h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >LEAVE EXTENTION CERTIFICATE / &#x905;&#x935;&#x915;&#x93E;&#x936;&#x20;&#x935;&#x93F;&#x938;&#x94D;&#x924;&#x93E;&#x930;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;</h4>
					<h4 style="font-weight:bold;margin-top: 0; font-size: inherit;">
                    Certificate No (&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x938;&#x902;&#x916;&#x94D;&#x92F;&#x93E;) :<span id="medCertiMCXId"></span> </h4>
                </td>
                <td style="width:15%;text-align: center;"><span id="patQrCode" title="https://muhseclinic.uat.dcservices.in/ST/su?key=428673EE"><canvas width="100" height="100" style="display: none;"></canvas><img style="display: block;" src="data:image/png;base64,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"></span></td>
              </tr>
            </thead> 
          </table>
          
          <hr class="border border-success border-3 opacity-75">
          
          <!-- Medical Certificate details starts here -->
          <div class="letter">
            <div class="header">
             <table>
				<thead>  
				  <tr>
					<td style="width:50%;font-weight: bold;">Date (&#2342;&#2367;&#2344;&#2366;&#2306;&#2325;) : <span id="currentDateMCXId" style="font-weight: normal;"></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">Time (&#x938;&#x92E;&#x92F;) : <span id="timeMCXId" style="font-weight: normal;"></span></td>
				  </tr>
				  <tr>
					<td style="width:50%;font-weight: bold;">Beneficiary Id (&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x906;&#x908;&#x921;&#x940;) : <span id="benMCXId" style="font-weight: normal;"></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">CGHS WC (&#x938;&#x940;&#x91C;&#x940;&#x90F;&#x91A;&#x90F;&#x938;&#x20;&#x921;&#x92C;&#x94D;&#x932;&#x94D;&#x92F;&#x942;&#x938;&#x940;) : <span style="font-weight: normal;" ><%=objHospitalMstVO.getHospitalName() %></span></td>
				</tr>
				</thead> 
			</table>
			<br>
            <p>SIGNATURE OF APPLICANT (&#x906;&#x935;&#x947;&#x926;&#x915;&#x20;&#x915;&#x947;&#x20;&#x939;&#x938;&#x94D;&#x924;&#x93E;&#x915;&#x94D;&#x937;&#x930;)</p>
              <!-- <p>सरकारी कर्मचारी के हस्ताक्षर </p> -->
              <br>
            </div>
            <div class="content">
            
            
                   <p>I, after careful personal examination of the case, hereby certify that  <span id="patNameMCXId" style="font-weight: bold;">  </span>
       <span id="orgNameMCXId" style="font-weight: bold;"></span> whose signature is given above is suffering from
       <span id="illnessMCXId" style="font-weight: bold;"></span> 
       and I consider that a period of absence from duty of <span id="designationMCXId" style="font-weight: bold;">/Days</span>
       With effect from <span id="effective-date" style="font-weight: bold;">  </span> 
       with effect from today absolutely necessary for the restoration of his/her health.</p>
       
              <br>
              <p>
    &#x92E;&#x948;&#x902;&#x2C; <span id="consultant-name" style="font-weight: bold;"></span> &#2352;&#2379;&#2327;&#2368;&#32;&#2325;&#2368;&#32;&#2343;&#2381;&#2351;&#2366;&#2344;&#2346;&#2370;&#2352;&#2381;&#2357;&#2325;&#32;&#2357;&#2381;&#2351;&#2325;&#2381;&#2340;&#2367;&#2327;&#2340;&#32;&#2346;&#2352;&#2368;&#2325;&#2381;&#2359;&#2366;&#32;&#2325;&#2375;&#32;&#2348;&#2366;&#2342;&#32;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#2367;&#2340;&#32;&#2325;&#2352;&#2340;&#2366;&#32;&#2361;&#2370;&#2305;&#32;&#2325;&#2367; 
     <span id="orgNameMCXIdHin" style="font-weight: bold;"></span> &nbsp; <span id="patNameMCXId" style="font-weight: bold;">
      </span>&nbsp;&#x20;&#x91C;&#x93F;&#x928;&#x915;&#x93E;&#x20;&#x939;&#x938;&#x94D;&#x924;&#x93E;&#x915;&#x94D;&#x937;&#x930;&#x20;&#x90A;&#x92A;&#x930;&#x20;&#x939;&#x948;&#x2C; &nbsp;<span id="illnessMCXId" style="font-weight: bold;"> 
      </span>&nbsp;&#x20;&#x938;&#x947;&#x20;&#x92A;&#x940;&#x921;&#x93C;&#x93F;&#x924;&#x20;&#x939;&#x948;&#x20;&#x914;&#x930;&#x20;&#x92E;&#x947;&#x930;&#x93E;&#x20;&#x935;&#x93F;&#x91A;&#x93E;&#x930;&#x20;&#x939;&#x948;&#x20;&#x915;&#x93F;&#x20;&#x924;&#x93E;&#x930;&#x940;&#x916; &nbsp;<span id="effective-date" style="font-weight: bold;"></span>&#x20;&#x938;&#x947;
               <span id="designationMCXId" style="font-weight: bold;"></span>&nbsp;&#x20;&#x926;&#x93F;&#x928;&#x20;&#x915;&#x940;&#x20;&#x91B;&#x941;&#x91F;&#x94D;&#x91F;&#x940;&#x20;&#x938;&#x947;&#x20;&#x905;&#x928;&#x941;&#x92A;&#x924;&#x20;&#x930;&#x939;&#x928;&#x93E;&#x20;&#x909;&#x928;&#x915;&#x947;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x932;&#x93E;&#x92D;&#x20;&#x915;&#x947;&#x20;&#x932;&#x90F;&#x20;&#x906;&#x935;&#x936;&#x94D;&#x92F;&#x915;&#x20;&#x939;&#x948;&#x20;&#x964;
              </p>
              <br>
              <!-- <p>Remarks: <span id="remarksMCXId" style="text-decoration: underline;"></span></p> -->
              <br>
           <table class="table">
				  <tbody>
								
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">Printed By [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">NAME OF MEDICAL OFFICER (<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				    </tr>
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x92E;&#x941;&#x926;&#x94D;&#x930;&#x93F;&#x924;   [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x91A;&#x93F;&#x915;&#x93F;&#x924;&#x94D;&#x938;&#x93E;&#x20;&#x905;&#x93F;&#x927;&#x915;&#x93E;&#x930;&#x940;&#x20;&#x915;&#x93E;&#x20;&#x928;&#x93E;&#x92E;&#x20;(<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				
				    </tr>
				  </tbody>
				</table>
			<p>This is an electronically generated certificate, therefore stamp of doctor is not required.</p>
			<p>&#x92F;&#x939;&#x20;&#x90F;&#x915;&#x20;&#x907;&#x932;&#x947;&#x915;&#x94D;&#x91F;&#x94D;&#x930;&#x949;&#x928;&#x93F;&#x915;&#x20;&#x930;&#x942;&#x92A;&#x20;&#x938;&#x947;&#x20;&#x924;&#x948;&#x92F;&#x93E;&#x930;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x939;&#x948;&#x2C;&#x20;&#x907;&#x938;&#x932;&#x93F;&#x90F;&#x20;&#x907;&#x938;&#x92E;&#x947;&#x902;&#x20;&#x921;&#x949;&#x915;&#x94D;&#x91F;&#x930;&#x20;&#x915;&#x940;&#x20;&#x92E;&#x941;&#x939;&#x930;&#x20;&#x915;&#x940;&#x20;&#x906;&#x935;&#x936;&#x94D;&#x92F;&#x915;&#x924;&#x93E;&#x20;&#x928;&#x939;&#x940;&#x902;&#x20;&#x939;&#x948;&#x964;</p>
              <!-- <p>Date/दिनांक: <span id="currentDateMCXId"></span></p> -->
            </div>
          </div>

          <!-- Footer starts here -->
          <br>
          <div class="d-flex justify-content-end" style="display: flex; flex-direction: column; align-items: flex-end;">
<!--             <p><span id="consultant-name"></span></p>
            <p><b>Authorized Medical Officer / प्राधिकृत चिकित्सा अधिकारी</b></p> -->
<%--             <br>
            <p><%=objHospitalMstVO.getHospitalName() %></p>
            <p><b>Hospital Dispensary / अस्पताल / औषधालय</b></p> --%>
          </div>
<!--           <p>Date/दिनांक: <span id="currentDateMCXId"></span></p> -->

<!--           <div id="footer" class="text-center">
            <p><b>किसी भी सरकारी अस्पताल / CGHS मान्यता प्राप्त अस्पताल में संदर्भित करें</b></p>
            <p><b>यह एक कंप्यूटर जनित प्रिंटआउट है, इसलिए डॉक्टर की मुहर आवश्यक नहीं है</b></p>
          </div> -->
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>



<div class="modal fade scroll-mcform" id="form5" tabindex="-1" aria-labelledby="form5ModalLabel" aria-hidden="true" style="height: auto; overflow: auto;">
  <div class="modal-dialog modal-lg modal-dialog-centered modal-fullscreen-md-down"> 
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title text-center" id="fitModalLabel">Form 5 Medical Certificate</h5>
        <div  style="margin-top: -30px;display: flex;justify-content: end;">
          <button type="button" class="btn btn-secondary" style="margin-right: 20px;" data-bs-dismiss="modal">X</button>
      		<button class="btn btn-info" style="z-index:9999;" type="button" onclick="printToPdfForMCForm1()">Print</button></div>
      	</div>
		<div class="modal-body">
		<div style="right:8px; position:fixed" class="prHeader" id="prHeaderr" >
			<label class="withHeaderLabel" style="z-index: 99999;display: none;"><input type="checkbox" name="withHeaderCheck" value="1" >&nbsp;  Without Header</label><br><!--With Header  -->
			
		</div>

<div id='divPrintable1'>
	
	<!-- Header starts here -->
	<table>
		<thead>	
		<tr>
			<td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
			<td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;">CENTRAL GOVERNMENT HEALTH SCHEME / &#x915;&#x947;&#x902;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;&#x20;</h4>
                  <h4 style='font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;'>MINISTRY OF HEALTH AND FAMILY WELFARE/ &#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x914;&#x930;&#x20;&#x92A;&#x930;&#x93F;&#x935;&#x93E;&#x930;&#x20;&#x915;&#x932;&#x94D;&#x92F;&#x93E;&#x923;&#x20;&#x92E;&#x902;&#x924;&#x94D;&#x930;&#x93E;&#x932;&#x92F;</h4>
                  <h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >GOVERNMENT OF INDIA / &#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930; </h4> 
				<h4 style="font-weight:bold;margin-top: 0;font-size: inherit;margin-bottom: 0;" >
				FITNESS CERTIFICATE / &#x92B;&#x93F;&#x91F;&#x928;&#x947;&#x938;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;<span id="servingFCId"></span></h4>
					<h4 style="font-weight:bold;margin-top: 0; font-size: inherit;">
                    Certificate No (&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x938;&#x902;&#x916;&#x94D;&#x92F;&#x93E;) :<span id="medCertiFCId"></span> </h4>
					
			</td>
			<td style="width:15%;text-align: center;"><span id="patQrCode" title="https://muhseclinic.uat.dcservices.in/ST/su?key=428673EE"><canvas width="100" height="100" style="display: none;"></canvas><img style="display: block;" src="data:image/png;base64,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"></span></td>
		</tr>
		</thead> 
	</table>

	<hr class="border border-success border-3 opacity-75">
	<!-- <div style='margin-top:5px;margin-bottom:16px; border-bottom: 3px solid #265919;'></div> -->
	<!-- Header ends here -->

	<!-- Medical Certificate details starts here -->
	
	<div class="letter">
            <div class="header">
                           <table>
				<thead>  
				  <tr>
					<td style="width:50%;font-weight: bold;">Date (&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915;) : <span id="currentDateFcId" style="font-weight: normal;"></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">Time (&#x938;&#x92E;&#x92F;) : <span id="timeFcId" style="font-weight: normal;"></span></td>
				  </tr>
				  <tr>
					<td style="width:50%;font-weight: bold;">Beneficiary Id (&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x906;&#x908;&#x921;&#x940;) : <span id="benFCId" style="font-weight: normal;" ></span></td>
					<td style="width:50%;font-weight: bold;padding-left: 80px;">CGHS WC (&#x938;&#x940;&#x91C;&#x940;&#x90F;&#x91A;&#x90F;&#x938;&#x20;&#x921;&#x92C;&#x94D;&#x932;&#x94D;&#x92F;&#x942;&#x938;&#x940;) : <span style="font-weight: normal;"><%=objHospitalMstVO.getHospitalName() %></span></td>
				</tr>
				</thead> 
			</table>

			<br>
            <p>SIGNATURE OF APPLICANT (&#x906;&#x935;&#x947;&#x926;&#x915;&#x20;&#x915;&#x947;&#x20;&#x939;&#x938;&#x94D;&#x924;&#x93E;&#x915;&#x94D;&#x937;&#x930;)</p>
              <!-- <p>सरकारी कर्मचारी के हस्ताक्षर </p> -->
              <br>
            </div>
       <br>
	<!-- <div class="md-12" style="margin-top:20px;"> -->
	<div class="content">
				<p>I, do hereby certify that I have carefully examined 
				<span id="patNameFCId" style="font-weight:bold">
				</span> <span id="orgNameFCId" style="font-weight:bold"></span> 
				whose signature is given above and find that he/she has
				recovered from his/her illness and is now fit to resume duty in Government service. 
				I also certify that before arriving at this decision, I have examined the original
				medical certificate(s) and statement(s) of the case (or certified copies thereof), 
				on which leave was granted or extended, and have taken these into consideration in
				arriving at my decision.</p> 

				<br>
				<p>&#2350;&#2376;&#2306;&#44;&#32;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#2367;&#2340;&#32;&#2325;&#2352;&#2340;&#2366;&#47;&#2325;&#2352;&#2340;&#2368;&#32;&#2361;&#2370;&#2305;&#32;&#2325;&#2367;&#32;&#2350;&#2376;&#2306;&#2344;&#2375;<span id="orgNameFCIdHin" style="font-weight:bold"></span> 
				<span id="patNameFCId" style="font-weight:bold"></span>
				&#2325;&#2368;&#32;&#2360;&#2366;&#2357;&#2343;&#2366;&#2344;&#2368;&#32;&#2346;&#2370;&#2352;&#2381;&#2357;&#2325;&#32;&#2332;&#2366;&#2306;&#2330;&#32;&#2325;&#2368;&#32;&#2361;&#2376;&#44;&#32;&#2332;&#2367;&#2360;&#2325;&#2366;&#32;&#2361;&#2360;&#2381;&#2340;&#2366;&#2325;&#2381;&#2359;&#2352;&#32;&#2314;&#2346;&#2352;&#32;&#2342;&#2367;&#2319;&#32;&#2327;&#2319;&#32;&#2361;&#2376;&#32;&#2324;&#2352;&#32;&#2346;&#2366;&#2351;&#2366;&#32;&#2361;&#2376;&#9;&#32;&#2325;&#2367;&#32;&#2357;&#2361;&#32;&#2309;&#2346;&#2344;&#2368;&#32;&#2348;&#2368;&#2350;&#2366;&#2352;&#2368;&#32;&#2360;&#2375;&#32;&#2336;&#2368;&#2325;&#32;&#2361;&#2379;&#32;&#2327;&#2319;&#32;&#2361;&#2376;&#32;&#2324;&#2352;&#32;&#2360;&#2352;&#2325;&#2366;&#2352;&#2368;&#32;&#2360;&#2375;&#2357;&#2366;&#32;&#2350;&#2375;&#2306;&#32;&#2347;&#2367;&#2352;&#32;&#2360;&#2375;&#32;&#2325;&#2366;&#2350;&#32;&#2325;&#2352;&#2344;&#2375;&#32;&#2325;&#2375;&#32;&#2354;&#2367;&#2319;&#32;&#2351;&#2379;&#2327;&#2381;&#2351;&#32;&#2361;&#2376;&#32;&#2404;&#32;&#2350;&#2376;&#2306;&#32;&#2351;&#2361;&#32;&#2349;&#2368;&#32;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#2367;&#2340;&#32;&#2325;&#2352;&#2340;&#2366;&#47;&#2325;&#2352;&#2340;&#2368;&#32;&#2361;&#2370;&#2305;&#32;&#2325;&#2367;&#32;&#2311;&#2360;&#32;&#2344;&#2367;&#2352;&#2381;&#2339;&#2351;&#32;&#2346;&#2352;&#32;&#2346;&#2361;&#2369;&#2306;&#2330;&#2344;&#2375;&#32;&#2360;&#2375;&#32;&#2346;&#2361;&#2354;&#2375;&#44;&#32;&#2350;&#2376;&#2306;&#2344;&#2375;&#32;&#2350;&#2366;&#2350;&#2354;&#2375;&#32;&#2325;&#2375;&#32;&#2350;&#2370;&#2354;&#32;&#2330;&#2367;&#2325;&#2367;&#2340;&#2381;&#2360;&#2366;&#32;&#2346;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#32;&#2346;&#2340;&#2381;&#2352;&#32;&#2324;&#2352;&#32;&#2357;&#2367;&#2357;&#2352;&#2339;&#32;&#40;&#2351;&#2366;&#32;&#2313;&#2360;&#2325;&#2368;&#32;&#2346;&#2381;&#2352;&#2350;&#2366;&#2339;&#2367;&#2340;&#32;&#2346;&#2381;&#2352;&#2340;&#2367;&#2351;&#2366;&#41;&#32;&#2325;&#2368;&#32;&#2332;&#2366;&#2306;&#2330;&#32;&#2325;&#2368;&#32;&#2361;&#2376;&#44;&#32;&#2332;&#2367;&#2360;&#32;&#2346;&#2352;&#32;&#2331;&#2369;&#2335;&#2381;&#2335;&#2368;&#32;&#2342;&#2368;&#32;&#2327;&#2312;&#32;&#2341;&#2368;&#32;&#2351;&#2366;&#32;&#2348;&#2397;&#2366;&#2312;&#32;&#2327;&#2312;&#32;&#2341;&#2368;&#44;&#32;&#2324;&#2352;&#32;&#2311;&#2344;&#32;&#2346;&#2352;&#32;&#2357;&#2367;&#2330;&#2366;&#2352;&#32;&#2325;&#2352;&#2325;&#2375;&#32;&#2361;&#2368;&#32;&#2350;&#2376;&#2306;&#32;&#2311;&#2360;&#32;&#2344;&#2367;&#2352;&#2381;&#2339;&#2351;&#32;&#2346;&#2352;&#32;&#2346;&#2361;&#2369;&#2306;&#2330;&#2366;&#47;&#2346;&#2361;&#2369;&#2306;&#2330;&#2368;&#32;&#2361;&#2370;&#2305;&#32;&#2404;</p>

				  <br>
				  <br>
				<table class="table">
				  <tbody>
								
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">Printed By [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">NAME OF MEDICAL OFFICER (<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				    </tr>
				    <tr>
				      <th scope="row" style="border-top: none !important;"></th>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x92E;&#x941;&#x926;&#x94D;&#x930;&#x93F;&#x924;&#x20;  [<span style="font-weight: normal;" id="printedBy"></span>]</td>
						<td style="width:50%;font-weight: bold; border-top: none !important;">&#x91A;&#x93F;&#x915;&#x93F;&#x924;&#x94D;&#x938;&#x93E;&#x20;&#x905;&#x93F;&#x927;&#x915;&#x93E;&#x930;&#x940;&#x20;&#x915;&#x93E;&#x20;&#x928;&#x93E;&#x92E;&#x20;(<span style="font-weight: normal;" id="consultant-name"></span>)</td>
				
				    </tr>
				  </tbody>
				</table>
				
			<p>This is an electronically generated certificate, therefore stamp of doctor is not required.</p>
			<p>&#x92F;&#x939;&#x20;&#x90F;&#x915;&#x20;&#x907;&#x932;&#x947;&#x915;&#x94D;&#x91F;&#x94D;&#x930;&#x949;&#x928;&#x93F;&#x915;&#x20;&#x930;&#x942;&#x92A;&#x20;&#x938;&#x947;&#x20;&#x924;&#x948;&#x92F;&#x93E;&#x930;&#x20;&#x92A;&#x94D;&#x930;&#x92E;&#x93E;&#x923;&#x20;&#x92A;&#x924;&#x94D;&#x930;&#x20;&#x939;&#x948;&#x2C;&#x20;&#x907;&#x938;&#x932;&#x93F;&#x90F;&#x20;&#x907;&#x938;&#x92E;&#x947;&#x902;&#x20;&#x921;&#x949;&#x915;&#x94D;&#x91F;&#x930;&#x20;&#x915;&#x940;&#x20;&#x92E;&#x941;&#x939;&#x930;&#x20;&#x915;&#x940;&#x20;&#x906;&#x935;&#x936;&#x94D;&#x92F;&#x915;&#x924;&#x93E;&#x20;&#x928;&#x939;&#x940;&#x902;&#x20;&#x939;&#x948;&#x964;</p>
			  
	</div>
              
              
              
	</div>
	<!-- Medical Certificate details ends here -->

	<!-- Footer starts here -->
	
	<br>
	<div class="d-flex justify-content-end" style="display: flex; flex-direction: column; align-items: flex-end;">
	
		

          <br>
          <div class="d-flex justify-content-end" style="display: flex; flex-direction: column; align-items: flex-end;">
<!--             <p><span id="consultant-name"></span></p>
            <p><b>Authorized Medical Officer / प्राधिकृत चिकित्सा अधिकारी</b></p> -->
            <br>
<%--             <p><%= objHospitalMstVO.getHospitalName() %></p>
            <p><b>Hospital Dispensary / अस्पताल / औषधालय</b></p> --%>
          </div>
<script type="text/javascript">
    var hospitalName = "<%= objHospitalMstVO.getHospitalName() %>";
   //	 console.log("objHospitalMstVO  >>    1783dev  ",hospitalName); // You can use this value in JS now
</script>
	
	<div id="footer" class="text-center"><!-- 
		<div style='margin-top:5px;margin-bottom:16px; border-bottom: 3px solid #265919;'></div> -->
		<div class="d-flex justify-content-left" style="display: flex; flex-direction: column; align-items: baseline;">
<input type="hidden" id="varMCHospName" name="varMCHospName" value="<%= objHospitalMstVO.getHospitalName() %>"/>
		</div>

	</div>
	        
        </div>
<!--         <p>Date/दिनांक: <span id="currentDateFcId"></span></p> -->
      </div>

	     <div class="modal-footer">
	       <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	       <!-- <button type="button" class="btn btn-primary" onclick="downloadPDF()">Download PDF</button> -->
	      </div>
	    </div>
	  </div>
	</div>
 </div>
<script>
	document.getElementById('sickFormID').addEventListener('click', function() {
	    document.getElementById('sickFormDetails').style.display = 'block';
	    document.getElementById('patDiagnosisDiv').style.display = 'none';
	    //document.getElementById('fitFormDetails').style.display = 'none';
	  });
	  
/* 	document.getElementById('fitFormID').addEventListener('click', function() {
		
	    //document.getElementById('fitFormDetails').style.display = 'block';
	    document.getElementById('sickFormDetails').style.display = 'none';
	    document.getElementById('patDiagnosisDiv').style.display = 'none';

	    openForm5Modal(5);
	    
/* 	    document.getElementById("currentDateFcId").innerText =new Date().toLocaleDateString();
	    document.querySelectorAll("#consultant-name").forEach(el => { el.innerText = globalpatConsultantName || "N/A"; });
	    var patName = document.getElementById('patNameId').value;
	    document.getElementById("patNameFCId").innerText = patName;

	    $('#sickFitModal').modal('hide');
	    $('#form5').modal('hide').modal('show');

	    $('#form5 button[data-bs-dismiss="modal"]').click(function() {
	        $('#form5').modal('hide');
	        location.reload();
	    });  
	});
 */
</script>
  
<!--   <div id="sickModal" class="modal fade "  role="dialog" >
  <div class="modal-dialog modal-lg" style="width:90vw;">

    Modal content
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close"  data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Sick Leave</h4>
      </div>
      <div class="modal-body">
     
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>

  </div>
</div>

<script>
$(document).ready(function(){
	$(".opdSickBtn").click(function(){
		let cr=$(this).closest(".patientListBlock").find(".patCrNo").text();
		let dept=$(this).closest(".patientListBlock").find("input[name='patCompleteGeneralDtl']").val().split("#")[6];
		let tkt=0;
		 if(localStorage.getItem("varSSOTicketGrantingTicketStoreage"))
			 tkt = localStorage.getItem("varSSOTicketGrantingTicketStoreage");

		$("#sickModal .modal-body").html( '<iframe src="/HBIMS/sickleave/transactions/SickLeaveCNT.cnt?hmode=GOEXTERNAL&varSSOTicketGrantingTicket='+tkt+'&patCrNo='+cr+'&departmentUnitCode='+dept+'" style="height:70vw;width:100%"></iframe>');
		$("#sickModal").modal("show");
	});
});

</script> -->
  
   <div class="modal fade " id="VitalIDModal" role="dialog">
 <!--   <div class="modal-dialog modal-lg"> -->
 
 <div class="modal-dialog modal-lg" style="width: 90%;">
<div class="modal-content">       
				<div class="modal-body" style="text-align: left;"> 
					<div class="container-fluid">
					<div class="row" style="min-height:400px;">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">x</button>
							<h2 class="modal-title text-left">Vitals Entry/ Lab Test Report Entry</h2>
							<div class="row">
								<div class="col-md-5 col-sm-1" style="font-size: small;">
								<b style="color:#7d7f84;"><span>Wellness Center : <%= objHospitalMstVO.getHospitalName() %> </span></b>
								</div>
								<div class="col-md-6 col-sm-9 col-xs-11" style="text-align:right; font-size: small;">
									<b style="color:#7d7f84;"><span id="patName">Patient Name</span> / <span id="crNo">CR Number</span> / <span id="patAge">Age</span> <span id="patGender"></span></b>
								</div>
								<div class="col-md-1 col-sm-1 col-xs-1 alignRight" style="display:none;">
									<i class="fa fa-print" id="VitalsPrintBtn" data-toggle="tooltip" title="" data-original-title="Print Vitals" onclick="$('#VitalIDModal #VitalsPrintBtn [data-toggle=tooltip], .tooltip').tooltip('hide');$('#VitalsPrintBtn').hide();$('#saveBtn').hide();$('#VitalIDModal .close').hide();printDiv('VitalIDModal');$('#VitalsPrintBtn').show();$('#saveBtn').show();$('#VitalIDModal .close').show();$('#VitalIDModal #VitalsPrintBtn [data-toggle=tooltip], .tooltip').tooltip('show');"></i>
								</div>
								<div class="col-md-1 col-sm-1 col-xs-1 alignRight">
									<i class="" id="" data-toggle="tooltip" title=""></i>
								</div>
							</div>
						</div>	
						
						<div class="row">
						<div class="col-md-2" style='text-align: center;background-color: #dde1ec;min-height:100vh;padding: 10px;' id='vitaldates'></div>
						<div class="col-md-10">
							<span style='display:none;' id='previous_vitals'></span>
							<input type='hidden' name='selectedVitalIndex' id="selectedVitalIndex" value=''>
							<div class="container-fluid" id='divPrevVitalDtlMain' style="background-color: #ebf4e9;margin-bottom:10px;display:none;">
								<div class="row" style="background-color: #CCD5AE;">
									<div class="col-md-10" style="font-weight: bold;padding-top: 10px;">
										<h5 style="font-weight: bold" id='preVitalHeading'></h5>
									</div>
									<div class="col-md-1" style="margin-top: 5px;">
										<a class="btn btn-outline-success btn-sm" id='btnActonPrevVitalHide'>Hide</a>
										<a class="btn btn-outline-success btn-sm" id='btnActonPrevVitalShow' style="display: none;">Show</a>
									</div>
									<div class="col-md-1" style="margin-top: 5px;">										
										<a class="btn btn-outline-success btn-sm" id='btnActonPrevVitalPopulate'>Extract</a>
									</div>
									
								</div>	
								<div class="row" id="divPrevVitalDtl"></div>
							</div>
							
						<div class="row" style="background-color: #CCD5AE;margin-bottom:10px;">
									<div class="col-md-10" style="font-weight: bold;padding-top: 10px;">
										<h5 style="font-weight: bold">Today Vital Entry Form</h5>
									</div>
						</div>				
						<!-- <label for="patient detail">Patient Name / CR Number </label> -->
						 <div class="row">
							<div class="form-group col-md-3 col-sm-6 col-xs-12">
								<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
									<label for="weight">Weight:</label>
								</div>
								<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
									<input type="text" class="form-control hrpcheckfield" maxlength="3" maxvalue="200" id="weightId" placeholder="kgs" name="weight">&nbsp;<span id="weightErrmsg" class="errorMessage"></span>
								</div>
							</div>
						
							<div class="form-group col-md-3 col-sm-6 col-xs-12">
								<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
									<label for="height">Height:</label>
								</div>
								<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
									<input type="text" class="form-control hrpcheckfield" maxlength="3" id="heightId" placeholder="cms" name="height" >&nbsp;<span id="heightErrmsg" class="errorMessage"></span>
								</div>
							</div>

							<div class="form-group col-md-3 col-sm-6 col-xs-12">
								<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
									<label for="bmi">BMI:</label>
								</div>
								<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
									<input type="text" class="form-control" id="bmiId" placeholder="kg/m2" name="bmi" readonly>&nbsp;<span id="bmiErrmsg" class="errorMessage"></span>
								</div>
							</div>

							<div class="form-group col-md-3 col-sm-6 col-xs-12">
								<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
									<label for="temperature">Temp(F):</label>
								</div>
								<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
									<input type="text" class="form-control" id="temperatureId" maxlength="3" placeholder="In Fahrenheit" name="temperature">
									&nbsp;<span id="temperatureErrmsg" class="errorMessage"></span>
								</div>
							</div>

						</div>	

					<div class="row">
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label for="respRate" id="respRate" data-toggle="tooltip" title="Respiration Rate">Resp.Rate:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="respRateId" maxlength="2" placeholder="breaths/min" name="respRate">
							&nbsp;<span id="respRateErrmsg" class="errorMessage"></span>
							
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label for="pulseRate" id="pulseRate" data-toggle="tooltip" title="Pulse Rate">Pulse Rate:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" maxlength="3" onkeypress="return isNumber(event)" id="pulseRateId" placeholder="Pulse Rate" name="haemoglobin">
							&nbsp;<span id="pulseRateErrmsg" class="errorMessage"></span>
						</div>
					</div>
					<div class="form-group col-md-6 col-sm-12 col-xs-12">
						<div class="col-md-3 col-sm-2 col-xs-3 alignLeft" id="bloodPressureDivId">
							<label for="diastolic" id="bloodPressure" data-toggle="tooltip" title="Blood Pressure">BP(mmHg):</label>
						</div>
						<div class="col-md-5 col-sm-5 col-xs-5 alignLeftPaddingLeftZero">
							<div class="col-md-10 col-sm-10 col-xs-10 paddingLeftRightZero">
								<!-- <span data-toggle="tooltip" title="Blood Pressure"></span> -->
								<input type="text" class="form-control" id="systolicId"  maxlength="3" data-toggle="tooltip" title="Systolic" placeholder="Systolic" name="systolic"><!-- &nbsp;<span id="bpErrmsg" class="errorMessage"></span> -->
								<input type="text" class="form-control" id="systolicId1" style="display: none;"  data-toggle="tooltip" title="Systolic" placeholder="Systolic" name="systolic1">&nbsp;<span id="bpErrmsg" class="errorMessage"></span>	
							</div>
							<div class="col-md-2 col-sm-2 col-xs-2 paddingRightZero" style="font-size:20px;">
								<p><b>/</b></p>
								<!-- <p><b>/</b></p> -->
							</div>
						</div>
						<!-- <div class="col-md-1 paddingLeftRightZero">
						  <label for="separator">/</label>
						</div> -->
						<div class="col-md-4 col-sm-5 col-xs-4 alignLeftPaddingLeftZero">
						<input type="text" class="form-control" id="diastolicId" maxlength="3" data-toggle="tooltip" title="Diastolic"  placeholder="Diastolic" name="diastolic"><!-- &nbsp;<span id="diastolicErrmsg" class="errorMessage"></span> -->
						<input type="text" class="form-control" id="diastolicId1"  data-toggle="tooltip" style="display: none;" title="Diastolic"  placeholder="Diastolic" name="diastolic1"><!-- &nbsp;<span id="diastolicErrmsg" class="errorMessage"></span> -->
						
						</div>
					</div>
				</div>

				<div class="row">
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label style="margin-top: 0px" for="alcoholConsumption" id="alcoholConsumption1" data-toggle="tooltip" title="Alcohol consumption">Alcohol Consumption:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input  type="radio" name="alcoholConsumption" value="Yes">Yes &nbsp;
							<input  type="radio" name="alcoholConsumption" value="No" >No
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label style="margin-top: 0px" for="Smoking1" id="Smoking1" data-toggle="tooltip" title="Smoking">Smoking:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input  type="radio" name="Smoking" value="Yes">Yes &nbsp;
							<input  type="radio" name="Smoking" value="No" >No
						</div>
					</div>
					
					
					<div class="form-group col-md-3 col-sm-6 col-xs-12" id='PregnancyDivRadio' style='display:none;'>
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label style="margin-top: 0px" for="isPregnant" data-toggle="tooltip" >Is Pregnant:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input  type="radio" name="isPregnant" value="Yes">Yes &nbsp;
							<input  type="radio" name="isPregnant" value="No" >No
						</div>
						

					</div>
			    </div>
			    <div class="row">
			    	<div class="form-group col-md-6 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-3 col-xs-4 alignLeft">
							<label style="margin-top: 0px" for="isVitalDate" id="isVitalDateID" data-toggle="tooltip" title="Vital Date">Date :</label>
						</div>
						<div class="col-md-6 col-sm-5 col-xs-6 alignLeftPaddingLeftZero">
							<input  class="form-control"type="date" name="isVitalDate" value="Yes">
						</div>
					</div>

			    </div>
				<div class="row">
					<div class="form-group col-md-12 col-sm-12 col-xs-12" style="background: silver;">
					<h5 style="font-weight: bold;margin-left: 29px;margin-top: 10px;">Lab Test Report Entry</h5></div>
				</div>
				<div class="row">	
				<div class="form-group col-md-3 col-sm-12 col-xs-12">
					<label>Blood Sugar</label>					
				</div>	
				</div>	
				<div class="row">
				<div class="form-group col-md-3 col-sm-4 col-xs-12">
					<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
						<label for="fasting" id="fasting" data-toggle="tooltip" title="Blood Sugar Fast">FBS:</label>
					</div>
					<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
						<input type="text" class="form-control hrpcheckfield" id="fastingId" placeholder="Fasting" name="fasting">&nbsp;<span id="fastingErrmsg" class="errorMessage"></span>
					</div>
				</div>
				<div class="form-group col-md-3 col-sm-4 col-xs-12">
					<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
						<label for="ppRate" id="ppRate" data-toggle="tooltip" title="Blood Sugar PP Rate">PPBS:</label>
					</div>
					<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
						<input type="text" class="form-control" id="ppRateId" placeholder="PP" name="ppRate">&nbsp;<span id="ppRateErrmsg" class="errorMessage"></span>
					</div>
				</div>
				<div class="form-group col-md-3 col-sm-4 col-xs-12">
					<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
						<label for="hba1c" id="hba1c" data-toggle="tooltip" title="Blood Sugar HBA1C Rate">HBA1C:</label>
					</div>
					<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
						<input type="text" class="form-control" id="hba1cId" placeholder="%" name="hba1c">&nbsp;<span id="hba1cErrmsg" class="errorMessage"></span>
					</div>
				</div>
								
				</div>
				<hr style="margin-top: 0;margin-bottom: 0; "/>
				<div class="row">	
					<div class="form-group col-md-3 col-sm-12 col-xs-12">
						<label>Lipid Profile</label>					
					</div>	
				</div>	
				<div class="row">				
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>T.CHL. : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="acbl" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>TGL. : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="tgl" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>HDL. : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="hdl" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>LDL. : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="ldl" >
						</div>
					</div>		
				</div>
				<hr style="margin-top: 0;margin-bottom: 0; "/>	
				
				<div class="row">	
					<div class="form-group col-md-3 col-sm-12 col-xs-12">
						<label>Kidney Function Test</label>					
					</div>	
				</div>	
				<div class="row">				
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>Creatinine : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="Creatinine" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>Uric Acid : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="uricAcid" >
						</div>
					</div>
				</div>
				
				
				<hr style="margin-top: 0;margin-bottom: 0; "/>	
				
				<div class="row">	
					<div class="form-group col-md-3 col-sm-12 col-xs-12">
						<label>Thyroid Profile</label>					
					</div>	
				</div>	
				<div class="row">				
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>TSH : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="tsh" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>T3 : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="t3" >
						</div>
					</div>
					<div class="form-group col-md-3 col-sm-4 col-xs-12">
						<div class="col-md-6 col-sm-4 col-xs-4 alignLeft">
							<label>T4 : </label>
						</div>
						<div class="col-md-6 col-sm-8 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control" id="t4" >
						</div>
					</div>
				 </div>
				<hr style="margin-top: 0;"/>
				<div class="row">
				
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label for="haemoglobin" id="haemoglobin" data-toggle="tooltip" title="Haemoglobin">HB%:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" class="form-control hrpcheckfield" id="haemoglobinId" placeholder="g/dL" name="haemoglobin">&nbsp;<span id="haemoglobinErrmsg" class="errorMessage"></span>
						</div>
					</div>
					<div class="form-group col-md-9 col-sm-6 col-xs-12">
						<div class="col-md-2 col-sm-5 col-xs-4 alignLeft">
							<label for="haemoglobin" id="haemoglobin" data-toggle="tooltip" title="Haemoglobin">Any Other Reports</label>
						</div>
						<div class="col-md-9 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<textarea class="form-control" id="anyOtherReport" name="anyOtherReport" maxlength="500" ></textarea>
						</div>
					</div>
					
					<div class="form-group col-md-3 col-sm-6 col-xs-12" style="display: none;">
						<div class="col-md-6 col-sm-5 col-xs-4 alignLeft">
							<label for="bloodGroup" id="bloodGroup" data-toggle="tooltip" title="Haemoglobin">Blood Group</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<select id="bloodGroupId" class="form-control">
								<option value="0">Select</option>
								<option value="A-">A-</option>
								<option value="B-">B-</option>
								<option value="O-">O-</option>
								<option value="AB-">AB-</option>
								<option value="A+">A+</option>
								<option value="B+">B+</option>
								<option value="O+">O+</option>
								<option value="AB+">AB+</option>
							</select>
						</div>
					</div>					
					
				</div>

				<div class="row">
					<!-- ----------------------added for cancer screening--------------- -->
					<div class="form-group col-md-6 col-sm-6 col-xs-12" style="display: none;">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="cancerScreening" id="cancerScreening" data-toggle="tooltip" title="cancerScreening">Cancer Screening</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<select id="cancerScreeningId" class="form-control" multiple="multiple">
								<option value="0">Select</option>
								<option value="Basal cell carcinoma">Basal cell carcinoma</option>
								<option value="Breast cancer">Breast cancer</option>
								<option value="Carcinoma of Nasopharynx and Larynx">Carcinoma of Nasopharynx and Larynx</option>
								<option value="Cervical Cancer">Cervical Cancer</option>
								<option value="Colorectal cancer">Colorectal cancer</option>
								<option value="Hepatocellular carcinoma">Hepatocellular carcinoma</option>
								<option value="Kaposi sarcoma">Kaposi sarcoma</option>
								<option value="Lung cancer">Lung cancer</option>
								<option value="Lymphoproliferative lesions">Lymphoproliferative lesions</option>
								<option value="Malignant melanoma">Malignant melanoma</option>
								<option value="Occular surface squamous neoplasia">Occular surface squamous neoplasia</option>
								<option value="Oral cancer">Oral cancer</option>
								<option value="Oropharyngeal Cancer">Oropharyngeal Cancer</option>
								<option value="Prostate cancer">Prostate cancer</option>
								<option value="Retinoblastoma">Retinoblastoma</option>
								<option value="Sebaceous gland carcinoma">Sebaceous gland carcinoma</option>
								<option value="Secondary neck cancer">Secondary neck cancer</option>
								<option value="Skin cancer">Skin cancer</option>	
								<option value="Squamous cell carcinoma">Squamous cell carcinoma</option>
								<option value="Thyroid Cancer">Thyroid Cancer</option>
								<option value="Uveal melanoma">Uveal melanoma</option>
							</select>
						</div>
					</div>
					
					<div id="curcumferenceIdDivId" style="display: none;">
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="Curcumference" id="Curcumference" data-toggle="tooltip" title="Head Circumference">Head Circm:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text"  class="form-control" id="curcumferenceId" placeholder="cms" name="curcumference">&nbsp;<span id="curcumferenceErrmsg" class="errorMessage"></span>
						</div>
					</div>
					</div>
					<div id="muacDivId" style="display: none;">
					<div  class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="MUAC" id="muac" data-toggle="tooltip" title="MUAC">MUAC:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text" onkeypress="" class="form-control" id="muacId" placeholder="cms" name="MUAC">&nbsp;<span id="muacErrmsg" class="errorMessage"></span>
						</div>
					</div>
					
				</div>
				<div class="form-group col-md-3 col-sm-6 col-xs-12" style="display: none;">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label style="margin-top: 0px" for="Disability1" id="Disability1" data-toggle="tooltip" title="Disability">Disability:</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input  type="radio" name="Disability" value="Yes">Yes &nbsp
							<input  type="radio" name="Disability" value="No" >No
						</div>
				</div>
					
					
					
					
					
					<div class="form-group col-md-3 col-sm-6 col-xs-12" style="display: none;">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label style="margin-top: 0px" for="Anemic1" id="Anemic1" data-toggle="tooltip" title="Anemic">Severe Anemia :</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input  type="radio" class='hrpRadio hrpRadioYes' name="Anemic" value="Yes">Yes &nbsp
							<input  type="radio" class='hrpRadio' name="Anemic" value="No" >No
						</div>
					</div>
					
					
					
					

				</div>
				<div class="container-fluid" id='divPregnancyInfo' style='border-bottom:1px solid silver;margin-bottom:5px;display:none;' >
					<div class='row'>
						<div class="form-group col-md-12 col-sm-12 col-xs-12" style='background: silver;'><h5 style='font-weight: bold;margin-left: 29px;margin-top: 10px;'>Pregnancy Information</h5></div>
					</div>
										<div class='row'>
					<div  class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="lmp"  data-toggle="tooltip" title="Last Menstrual Period ">LMP :</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text"  class="form-control" id="lmp"  name="lmp" maxlength='12'>
							&nbsp;<span id="lmpErrorMessage" class="errorMessage"></span>
						</div>
					</div>
					
					<div  class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="edod" data-toggle="tooltip" title="Estimated Date Of Dilivery">EDOD :</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text"  class="form-control" id="edod"  name="edod" maxlength='12'>
							&nbsp;<span id="edodErrorMessage" class="errorMessage"></span>
						</div>
					</div>
					
					
					<div  class="form-group col-md-6 col-sm-6 col-xs-12">
						<div class="col-md-3 col-sm-3 col-xs-3 alignRight">
							<label for="obestetricHistory" data-toggle="tooltip" title="Obestetric History">Obestetric History :</label>
						</div>
						<div class="col-md-9 col-sm-9 col-xs-9 alignLeftPaddingLeftZero" style='margin-top: 5px;'>
							<input type="checkbox"  class='hrpCheckbox'   name="obestetricHistory" value='Gravida'>&nbsp; Gravida &nbsp;
							<input type="checkbox"  class='hrpCheckbox'   name="obestetricHistory" value='Para'>&nbsp; Para &nbsp;
							<input type="checkbox"  class='hrpCheckbox'   name="obestetricHistory" value='Live Birth'>&nbsp; Live Birth &nbsp;
							<input type="checkbox"  class='hrpCheckbox'   name="obestetricHistory" value='Abortion'>&nbsp; Abortion
						</div>
					</div>
					</div>
					<div class='row'>
					
					<div  class="form-group col-md-6 col-sm-6 col-xs-12">
						<div class="col-md-3 col-sm-3 col-xs-3 alignRight">
							<label for="edod" data-toggle="tooltip" title="Past History">Past History :</label>
						</div>
						<div class="col-md-9 col-sm-9 col-xs-9 alignLeftPaddingLeftZero">
							<input type="text"  class="form-control" id="pastHistoryVital"  name="pastHistoryVital" maxlength='150'>
							&nbsp;<span id="pastHistoryErrorMessage" class="errorMessage"></span>
						</div>
					</div>
					
					<div  class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-6 col-sm-5 col-xs-4 alignRight">
							<label for="Pregnancy1" data-toggle="tooltip" title="Past History">Gestational Age (In Weeks) :</label>
						</div>
						<div class="col-md-6 col-sm-7 col-xs-6 alignLeftPaddingLeftZero">
							<input type="text"  class="form-control" id="Pregnancy1"  name="Pregnancy1" maxlength='2'>
							&nbsp;<span id="gestationalAgeErrorMessage" class="errorMessage"></span>
						</div>
					</div>
					
					
					<div class="form-group col-md-3 col-sm-6 col-xs-12">
						<div class="col-md-8 col-sm-8 col-xs-8 alignRight">
							<label style="margin-top: 0px" for="pregnancyInducedHypertension"  data-toggle="tooltip" >Pregnancy Induced Hypertension</label>
						</div>
						<div class="col-md-4 col-sm-4 col-xs-4 alignLeftPaddingLeftZero">
							<input  type="radio" class='hrpRadio hrpRadioYes' name="pregnancyInducedHypertension" value="Yes">Yes &nbsp;
							<input  type="radio" class='hrpRadio' name="pregnancyInducedHypertension" value="No" >No
						</div>
					</div>
					
					</div>
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6 alignRight">
								<label style="margin-top: 0px" for="gestationalDiabetesMelitus"  data-toggle="tooltip" >Gestational Diabetes Melitus</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="gestationalDiabetesMelitus" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="gestationalDiabetesMelitus" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="reactiveForHIV"  data-toggle="tooltip" >Reactive for HIV :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="reactiveForHIV" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="reactiveForHIV" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="syphilis"  data-toggle="tooltip" >Syphilis :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="syphilis" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="syphilis" value="No" >No
							</div>
						</div>
					
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="hypothorism"  data-toggle="tooltip" >Hypothorism :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="hypothorism" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="hypothorism" value="No" >No
							</div>
						</div>
					</div>	
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="tuberculosis"  data-toggle="tooltip" >Tuberculosis :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="tuberculosis" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="tuberculosis" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="malaria"  data-toggle="tooltip" >Malaria :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="malaria" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="malaria" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="previousLSCS"  data-toggle="tooltip" >Previous LSCS :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="previousLSCS" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="previousLSCS" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="hepatitisB"  data-toggle="tooltip" >Hepatitis B :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="hepatitisB" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="hepatitisB" value="No" >No
							</div>
						</div>
						
					</div>
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="badObstetricHistory"  data-toggle="tooltip" >Bad Obstetric history :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="badObstetricHistory" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="badObstetricHistory" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="twinsMultiplePregnancy"  data-toggle="tooltip" >Twins/Multiple Pregnancy :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="twinsMultiplePregnancy" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="twinsMultiplePregnancy" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="cephaloPelvicDisproportion"  data-toggle="tooltip" >Cephalo-pelvic Disproportion :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="cephaloPelvicDisproportion" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="cephaloPelvicDisproportion" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="abnormalFetalPregnanacy"  data-toggle="tooltip" >Abnormal Fetal Pregnanacy :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="abnormalFetalPregnanacy" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="abnormalFetalPregnanacy" value="No" >No
							</div>
						</div>
					</div>
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="teenagePregnanacy"  data-toggle="tooltip" >Teenage Pregnanacy :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="teenagePregnanacy" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="teenagePregnanacy" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="highFever"  data-toggle="tooltip" >High Fever :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="highFever" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="highFever" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="rti-sti-hpsag-positive"  data-toggle="tooltip" >RTI/STI/HBS Ag +ve</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="rti-sti-hpsag-positive" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="rti-sti-hpsag-positive" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="having-HO-Still-Birth"  data-toggle="tooltip" >Having H/O Still Birth</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="having-HO-Still-Birth" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="having-HO-Still-Birth" value="No" >No
							</div>
						</div>
						
					</div>
					
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="congenitalMalformation"  data-toggle="tooltip" >Congenital Malformation :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="congenitalMalformation" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="congenitalMalformation" value="No" >No
							</div>
						</div>
						
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="rhNegativeBloodGroupOfMother"  data-toggle="tooltip" >Rh Negative Blood Group Of Mother</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="rhNegativeBloodGroupOfMother" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="rhNegativeBloodGroupOfMother" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="earlyPrimi"  data-toggle="tooltip" >Early Primi :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="earlyPrimi" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="earlyPrimi" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="elderlyPrimi"  data-toggle="tooltip" >Elderly Primi :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="elderlyPrimi" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="elderlyPrimi" value="No" >No
							</div>
						</div>
					</div>	
					<div class='row'>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="grandMultipara"  data-toggle="tooltip" >Grand Multipara :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="grandMultipara" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="grandMultipara" value="No" >No
							</div>
						</div>
						<div class="form-group col-md-3 col-sm-6 col-xs-12">
							<div class="col-md-6 col-sm-6 col-xs-6  alignRight">
								<label style="margin-top: 0px" for="shortStature"  data-toggle="tooltip" >Short Stature :</label>
							</div>
							<div class="col-md-6 col-sm-6 col-xs-6  alignLeftPaddingLeftZero">
								<input  type="radio" class='hrpRadio hrpRadioYes' name="shortStature" value="Yes">Yes &nbsp;
								<input  type="radio" class='hrpRadio' name="shortStature" value="No" >No
							</div>
						</div>
						<div  class="form-group col-md-6 col-sm-6 col-xs-12">
							<div class="col-md-3 col-sm-3 col-xs-3 alignRight">
								<label for="OtherIfAny1" data-toggle="tooltip">Other (If Any) :</label>
							</div>
							<div class="col-md-9 col-sm-9 col-xs-9 alignLeftPaddingLeftZero">
								<input type="text"  class="form-control" id="OtherIfAny1"  name="OtherIfAny1" maxlength='150'>
								&nbsp;<span id="OtherIfAny1ErrorMessage" class="errorMessage"></span>
							</div>
						</div>
						
					</div>	
					<div class='row'>
						<div class="form-group col-md-4 col-sm-4 col-xs-12">
							<div class="col-md-8 col-sm-8 col-xs-8  alignRight">
								<label style="margin-top: 0px" for="isPatientReferredToHigherFacility"  data-toggle="tooltip" >Is Patient referred to Higher facility</label>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-4  alignLeftPaddingLeftZero">
								<input  type="radio"  name="isPatientReferredToHigherFacility" value="Yes">Yes &nbsp;
								<input  type="radio"  name="isPatientReferredToHigherFacility" value="No" >No
							</div>
						</div>
						<div  class="form-group col-md-8 col-sm-8 col-xs-12">
							<div class="col-md-4 col-sm-4 col-xs-4 alignRight">
								<label for="birthPreparednessPlanMade" data-toggle="tooltip">Birth preparedness plan made</label>
							</div>
							<div class="col-md-8 col-sm-8 col-xs-8 alignLeftPaddingLeftZero">
								<input type="text"  class="form-control" id="birthPreparednessPlanMade"  name="birthPreparednessPlanMade" maxlength='150'>
								&nbsp;<span id="birthPreparednessPlanMadeErrorMessage" class="errorMessage"></span>
							</div>
						</div>
					</div>	
					<div class='row'>	
						<div  class="form-group col-md-6 col-sm-6 col-xs-12">
							<div class="col-md-3 col-sm-3 col-xs-3 alignRight">
								<label for="OtherIfAny2" data-toggle="tooltip">Other (If Any) :</label>
							</div>
							<div class="col-md-9 col-sm-9 col-xs-9 alignLeftPaddingLeftZero">
								<input type="text"  class="form-control" id="OtherIfAny2"  name="OtherIfAny2" maxlength='150'>
								&nbsp;<span id="OtherIfAny1ErrorMessage" class="errorMessage"></span>
							</div>
						</div>
						<div class="form-group col-md-4 col-sm-4 col-xs-12">
							<div class="col-md-8 col-sm-8 col-xs-8  alignRight">
								<label style="margin-top: 0px" for="isPatientReferredToHigherFacility"  data-toggle="tooltip" >Is High Risk Pregnancy?</label>
							</div>
							<div class="col-md-4 col-sm-4 col-xs-4  alignLeftPaddingLeftZero">
								<input  type="radio" name="isHighRiskPregnancy" id='isHighRiskPregnancyYes' value="Yes">Yes &nbsp;
								<input  type="radio" name="isHighRiskPregnancy" id='isHighRiskPregnancyNo' value="No" >No
							</div>
						</div>
					</div>	
					
					
					
					
					
					
				</div>	
				
				
				<div class="row">
					<div class="form-group col-md-12 col-sm-12 col-xs-12">
						<div class="col-md-2 col-sm-3 col-xs-3 alignRight">
							<label for="symptoms">Remarks:</label>
						</div>
						<div class="col-md-10 col-sm-9 col-xs-9 alignLeftPaddingLeftZero">
							<textarea class="form-control" id="symptomsId" name="symptoms" maxlength="2000" onkeyup="countChar(this,'charNumSymp');" onblur="countChar(this,'charNumSymp');"></textarea>
							<p align="right">
							  <label>characters remaining: <span id="charNumSymp" title="2000">2000</span></label>
							</p>
						</div>
					</div>
				</div>
				</div>
				
				</div>
				<div class='row' id='alertdivHRP' style='display:none;'>
						<div class="form-group col-md-12 col-sm-12 col-xs-12" >
							<div class="alert alert-danger" role="alert">
								<b>This is a case of High Risk Pregnancy</b>
							</div>						
						</div>
					</div>

				<div class="row">
					<div class="col-md-4">
					</div>
					<div class="col-md-4 alignCenter">
						<button class="btn btn-success saveBtn" id="saveBtn" type="button" onclick="VitalSave(this,event);"><i class="fa fa-save"></i> Save</button>
					</div>
					<div class="col-md-4">
					</div>
				</div>
				
			</div>	
				
			<div class="modal fade" id="abcd" >
			    <div  class='modal-dialog modal-lg'>       <!-- Modal content-->
			      <div class="modal-content">

			        <div class="modal-body">
			       		
			        </div>  
			      </div> 
			    </div>
			  </div> 	

				
				
				

<%	String ticket =(String)request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR);
		if(ticket==null){
			ticket="";
			//System.out.println("HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR is null");
		}
	
	%>
	 <input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value='<%= ticket %>'/> 

				<input type="hidden" name="respRateErrMsgTxt" value=''> 
				<input type="hidden" name="bmiErrMsgTxt" value=''> 
				<input type="hidden" name="temperatureErrMsgTxt" value=''>
				<input type="hidden" name="diastolicErrMsgTxt" value=''>
				<input type="hidden" name="bpErrMsgTxt" value=''>
				<input type="hidden" name="systolicErrMsgTxt" value=''>
				<input type="hidden" name="fastingErrMsgTxt" value=''>
				<input type="hidden" name="haemoglobinErrMsgTxt" value=''>
				<input type="hidden" name="ppRateErrMsgTxt" value=''>
				<input type="hidden" name="hba1cErrMsgTxt" value=''>
				<input type="hidden" name="strPatientDtl" id="strPatientDtlId" value=''>
				<input type="hidden" name="strPatHiddenDtls" id="strPatHiddenDtlsId" value=''>
				<input type="hidden" name="strVitalModify" id="strVitalModifyId" value='0'>
				 <input type="hidden" name="patAdd" id="patAdd">  

	</div>
</div>	
</div>
</div>
</div>

        <div class="loader"  style="display:none">
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
<html:hidden name="DoctorDeskFB" property="isScriber" styleId="isScriber" />


</html:form>
</body>

<style>
	.errorMessage{
		color: #193595 !important;
		font-size: 12px !important;
	}
</style>

<script>
try {  

/*-----------------------------
  App buttons and input 
------------------------------*/
var recognition;

$('#uk-search-input2').on('focus', function(e) {
	var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
	if(!SpeechRecognition)
		return false;

	  recognition = new SpeechRecognition();


	  var noteTextarea = $('#uk-search-input2'); 

	  var noteContent = '';
	   

	  /*-----------------------------
	  Voice Recognition 
	------------------------------*/

	//If false, the recording will stop after a few seconds of silence.
	//When true, the silence period is longer (about 15 seconds),
	//allowing us to keep recording even when the user pauses. 
	recognition.continuous = true;

	//This block is called every time the Speech APi captures a line. 
	recognition.onresult = function(event) {

	// event is a SpeechRecognitionEvent object.
	// It holds all the lines we have captured so far. 
	// We only need the current one.
	var current = event.resultIndex;

	// Get a transcript of what was said.
	var transcript = event.results[current][0].transcript;

	// Add the current transcript to the contents of our Note.
	// There is a weird bug on mobile, where everything is repeated twice.
	// There is no official solution so far so we have to handle an edge case.
	var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);

	if(!mobileRepeatBug) {
	noteContent += transcript+' ';
	
	noteTextarea.val(noteContent.trim());
	}
	};

	recognition.onstart = function() { 
	/*instructions.text('Voice recognition activated. Try speaking into the microphone.');*/
	}

	recognition.onspeechend = function() {
	/*instructions.text('You were quiet for a while so voice recognition turned itself off.');*/
	}

	recognition.onerror = function(event) {
	if(event.error == 'no-speech') {
	/*instructions.text('No speech was detected. Try again.');  */
	};
	}
if (noteContent.length) {
noteContent += ' ';
}

recognition.start();
});


$('#uk-search-input2').on('blur', function(e) {
	if(recognition!=null & recognition!=''){
		recognition.stop(); 
	}
});

}
catch(e) {
  console.error(e);
  $('.no-browser-support').show(); 
}

</script>

<!-- \
<script>
$(document).ready(function(){
	$('#example_filter input').prop('id','example_filter_searchId');
});
</script>
-->

<!-- 
<script>
try {  

/*-----------------------------
  App buttons and input 
------------------------------*/
var recognition;

$('#example_filter_searchId').on('focus', function(e) {
	var SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
	if(!SpeechRecognition)
		return false;

	console.log("1");
	  recognition = new SpeechRecognition();


	  var noteTextarea = $('#example_filter_searchId'); 

	  var noteContent = '';
	   
	  console.log("2");
	  /*-----------------------------
	  Voice Recognition 
	------------------------------*/

	//If false, the recording will stop after a few seconds of silence.
	//When true, the silence period is longer (about 15 seconds),
	//allowing us to keep recording even when the user pauses. 
	recognition.continuous = true;

	//This block is called every time the Speech APi captures a line. 
	recognition.onresult = function(event) {

	// event is a SpeechRecognitionEvent object.
	// It holds all the lines we have captured so far. 
	// We only need the current one.
	var current = event.resultIndex;

	// Get a transcript of what was said.
	var transcript = event.results[current][0].transcript;

	// Add the current transcript to the contents of our Note.
	// There is a weird bug on mobile, where everything is repeated twice.
	// There is no official solution so far so we have to handle an edge case.
	var mobileRepeatBug = (current == 1 && transcript == event.results[0][0].transcript);

	if(!mobileRepeatBug) {
	noteContent += transcript+' ';
	
	noteTextarea.val(noteContent.trim());
	console.log("3");
	}
	};

	recognition.onstart = function() { 
	/*instructions.text('Voice recognition activated. Try speaking into the microphone.');*/
	}

	recognition.onspeechend = function() {
	/*instructions.text('You were quiet for a while so voice recognition turned itself off.');*/
	}

	recognition.onerror = function(event) {
	if(event.error == 'no-speech') {
		console.log("4");
	/*instructions.text('No speech was detected. Try again.');  */
	};
	}
if (noteContent.length) {
noteContent += ' ';
}

recognition.start();
});


$('#example_filter_searchId').on('blur', function(e) {
	if(recognition!=null & recognition!=''){
		console.log("5");
		recognition.stop(); 
	}
});

}
catch(e) {
  console.error(e);
  $('.no-browser-support').show(); 
}

</script> 
-->

<style>
	@media only screen and (max-width: 468px){
			 #patientSearchModal .mainHeaderSrch {
		    	display:inline-block !important;
			}
	}
	@media print {
	  .tooltip { visibility: hidden; }
	}
</style>

<script>
console.log($("#showpatientCountId").val()>0);

if($("#showpatientCountId").val()>0){
	$("#patSideListSpan1").css("display","");
	$("#patSideListSpan1").text($("#showpatientCountId").val());
}else{
	$("#patSideListSpan1").css("display","none");
	$("#patSideListSpan1").text("0");
}

			
</script>

<script>



	function printDiv(divName) {

		 $('.pull-right').attr('type','hidden');
	     var printContents = document.getElementById(divName).innerHTML;
	     var originalContents = document.body.innerHTML;

	     document.body.innerHTML = printContents;

	     window.print();

	     document.body.innerHTML = originalContents;
		 $('.pull-right').attr('type','button');

		 $('#opdEmrModal .close').click(function(){
			 $('#opdEmrModal').modal('toggle');
			 $('body').removeClass('modal-open');
			 $('.modal-backdrop').remove();
		 });

		 $('#TreeStructurePrescriptionModal .close').click(function(){
			 $('#TreeStructurePrescriptionModal').modal('toggle');
			 $('body').removeClass('modal-open');
			 $('.modal-backdrop').remove();
		 });

		 $('#VitalIDModal .close').click(function(){
			 $('#VitalIDModal').modal('toggle');
			 $('body').removeClass('modal-open');
			 $('.modal-backdrop').remove();
		 });
		 

		}
			</script>
	
	
</html>

