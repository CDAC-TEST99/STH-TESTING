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
 <!--JQuery -->
  <script src="media/jquery/3.4.1/jquery-3.4.1.min.js" type="text/javascript"></script>

  <!--Propper JS -->
  <!-- <script src="media/popper.js/1.16.0/umd/popper.min.js"></script> -->
  <script src="media/popper.js/2.0.6/umd/popper.min.js"></script>
  
  <!--Tooltip JS -->
  <!-- <script src="media/tooltip.js/1.3.2/umd/tooltip.min.js"></script> -->


  <!--JQueryUI -->
  <script src="media/jquery-ui/1.12.1/jquery-ui.min.js" type="text/javascript"></script>
  <link href="media/jquery-ui/1.12.1/jquery-ui.min.css" rel="stylesheet" type="text/css" />
  <script src="media/jquery-ui/1.12.1/jquery.ui.datepicker.validation.min.js" type="text/javascript"></script>
  <script src="media/jquery-ui/1.12.1/jquery.validate.min.js" type="text/javascript"></script>

  <!--Bootstrap -->
  <link href="media/bootstrap/bootstrap-4.3.1/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

  <script src="media/bootstrap/bootstrap-4.3.1/js/bootstrap.min.js" type="text/javascript"></script>


  <!--Bootstrap Datables -->
  <link href="media/dataTables/DataTables-1.10.18/css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/DataTables-1.10.18/js/jquery.dataTables.min.js" type="text/javascript"></script>
  <script src="media/dataTables/DataTables-1.10.18/js/dataTables.bootstrap4.min.js" type="text/javascript"></script>
  <!-- nandini 
  
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css"> -->
  

<!-- Datatable1 -->
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
<!--   <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/sth.js"></script> -->
<script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap.min.js"></script>
   
   
  <!--Bootstrap Datatables Buttons -->
  <link href="media/dataTables/Buttons-1.5.6/css/buttons.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/Buttons-1.5.6/js/dataTables.buttons.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Buttons-1.5.6/js/buttons.bootstrap4.min.js" type="text/javascript"></script>

  <script src="media/dataTables/Buttons-1.5.6/js/buttons.colVis.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Buttons-1.5.6/js/buttons.flash.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Buttons-1.5.6/js/buttons.html5.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Buttons-1.5.6/js/buttons.print.min.js" type="text/javascript"></script>


  <!--Excel HTML5 export button -->
  <script src="media/dataTables/JSZip-2.5.0/jszip.min.js" type="text/javascript"></script>

  <!--PDF HTML5 export button -->
  <script src="media/dataTables/pdfmake-0.1.36/pdfmake.min.js" type="text/javascript"></script>
  <script src="media/dataTables/pdfmake-0.1.36/vfs_fonts.js" type="text/javascript"></script>


  <!--Bootstrap Datables FixedHeader -->
  <link href="media/dataTables/FixedHeader-3.1.4/css/fixedHeader.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/FixedHeader-3.1.4/js/dataTables.fixedHeader.min.js" type="text/javascript"></script>
  <script src="media/dataTables/FixedHeader-3.1.4/js/fixedHeader.bootstrap4.min.js" type="text/javascript"></script>
  <!--not ness-->


  <!--Bootstrap Datables RowGroup -->
  <link href="media/dataTables/RowGroup-1.1.0/css/rowGroup.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/RowGroup-1.1.0/js/dataTables.rowGroup.min.js" type="text/javascript"></script>
  <script src="media/dataTables/RowGroup-1.1.0/js/rowGroup.bootstrap4.min.js" type="text/javascript"></script>
  <!--not ness-->


  <!--Bootstrap Datables Responsive -->
  <link href="media/dataTables/Responsive-2.2.2/css/responsive.bootstrap4.min.css" rel="stylesheet" type="text/css" />
  <script src="media/dataTables/Responsive-2.2.2/js/dataTables.responsive.min.js" type="text/javascript"></script>
  <script src="media/dataTables/Responsive-2.2.2/js/responsive.bootstrap4.min.js" type="text/javascript"></script>

  <!--Bootstrap Select -->
   <link href="media/dataTables/select/1.3.1/css/select.bootstrap.min.css" rel="stylesheet" type="text/css" />
   <script src="media/dataTables/select/1.3.1/js/select.bootstrap4.min.js" type="text/javascript"></script>
  <!-- <link href="media/dataTables/select/1.3.1/css/select.dataTables.min.css" rel="stylesheet" type="text/css" /> -->
  <script src="media/dataTables/select/1.3.1/js/dataTables.select.min.js" type="text/javascript"></script>


  <!-- Datables api->processing -->
  <script type="text/javascript" src="media/dataTables/api/processing().js"></script>

  <!--Fontawesome Icons---->
  <link rel="stylesheet" href="media/fontawesome/5.10.1/css/all.css" />


  <!---For Bootstrap 3 moment.js dattimepicker---->
  <!-- <link rel="stylesheet" href="media/bootstrap/bootstrap-3.3.7/css/bootstrap.min.css" /> -->
  <script type="text/javascript" src="media/moment-js/moment.js"></script>
  <script type="text/javascript" src="media/bootstrap/bootstrapDateTime/js/bootstrap-datetimepicker.min.js"></script>
  <link rel="stylesheet" href="media/bootstrap/bootstrapDateTime/css/bootstrap-datetimepicker.min.css" />

  <!---Datatables Date sorting plugin----->
  <!-- <script type="text/javascript" src="media/misc/moment.min.js"></script> -->
  <script type="text/javascript" src="media/moment-js/datetime-moment.js"></script>


  <!--Vue JS -->
  <script src="media/vue-js/vue.min.js" type="text/javascript"></script>
  <script src="media/vue-js/vuex.js" type="text/javascript"></script>
  <script src="media/vue-js/portal-vue.umd.min.js" type="text/javascript"></script>
  <link rel="stylesheet" href="media/vue-js/bootstrap-vue/bootstrap-vue.min.css" />

  <!--highchart JS -->
  <script src="media/highcharts/7.2.0/highcharts.js"></script>
  <script src="media/highcharts/7.2.0/modules/exporting.js"></script>
  <script src="media/highcharts/7.2.0/modules/export-data.js"></script>

  <!--Tippy JS----->

  <script type="text/javascript" src="media/tippy/6.0.0/dist/tippy-bundle.umd.min.js"></script>
  <link href="media/tippy/6.0.0/animations/perspective-extreme.css" rel="stylesheet" type="text/css" />
  <link href="media/tippy/6.0.0/animations/shift-away-extreme.css" rel="stylesheet" type="text/css" />
  <link href="media/tippy/6.0.0/themes/light.css" rel="stylesheet" type="text/css" />


  <!--TextFit JS----->
  <script type="text/javascript" src="media/textFit/2.4.0/textFit.min.js"></script>

  <!--Fancy Box----->
  <script type="text/javascript" src="media/fancybox/3.5.7/jquery.fancybox.min.js"></script>
  <link rel="stylesheet" href="media/fancybox/3.5.7/jquery.fancybox.min.css" type="text/css" />
	
  <!--Toastify CSS----->
  <link rel="stylesheet" href="media/toastify/1.6.1/toastify.min.css" type="text/css" />
	
  <!--patientTile----->
  <script type="text/javascript" src="media/prashantUIUX/patientTile/js/patientTile.js"></script>
  <link rel="stylesheet" href="media/prashantUIUX/patientTile/css/patientTile.css" type="text/css" />
  
  <!--borderUtilities----->
  <script type="text/javascript" src="media/prashantUIUX/borderUtilities/js/borderUtilities.js"></script>
  <link rel="stylesheet" href="media/prashantUIUX/borderUtilities/css/borderUtilities.css" type="text/css" />
  
  <!--loadingEffects----->
  <script type="text/javascript" src="media/prashantUIUX/loadingEffects/js/loadingEffects.js"></script>
  <link rel="stylesheet" href="media/prashantUIUX/loadingEffects/css/loadingEffects.css" type="text/css" />
  
  <!--customBootstrap----->
  <script type="text/javascript" src="media/prashantUIUX/customBootstrap/js/customBootstrap.js"></script>
  <script type="text/javascript" src="/HISInvestigationG5/hisglobal/js/commonFunctions.js"></script>
  
  <link rel="stylesheet" href="media/prashantUIUX/customBootstrap/css/customBootstrap.css" type="text/css" />
  <!-- <link rel="stylesheet" href="media/prashantUIUX/customBootstrap/css/customSelect.css" /> -->
  
  <!--Fonts--------------->
  <link rel="stylesheet" href="media/fonts/webfontkit-averta-family/stylesheet.css" type="text/css" />
	  <link rel="stylesheet" href="media/reports/css/invTrackingReport.css" />
	  
  
  <!--Sample Collection js/css--------------->
   <link rel="stylesheet" href="media/investigation/css/SampleCollectionNew.css" />
   
   <script type="text/javascript" src="media/investigation/js/NEWOfflineResultEntry.js"></script>
	   <link rel="stylesheet" href="media/services/css/invResultValidationResp.css" />
	 
	   
	  <his:css src="/new_investigation/media/xray/sweetalert.css" />

<his:javascript src="/new_investigation/media/xray/sweetalert.js" />
<style>

#confirm  {
    text-align: center;
 }
 
 .bg-success-light{
	background-color:  #bfeeca !important;
  }
 
</style>

<script>
var pat_ward="";
var pat_crno="";
var pat_reqtype="";

//$(document).ready(function()
//		{
//	});



/*function printElement(elem) {
    var domClone = elem.cloneNode(true);
    var $printSection = document.getElementById("printSection");
	//alert($printSection);
    if (!$printSection) {
        var $printSection = document.createElement("div");
        $printSection.id = "printSection";
        document.body.appendChild($printSection);
    }

    //$printSection.innerHTML = "";
    //$printSection.appendChild(domClone);
    window.print();
    $("#opdModal").removeClass("form");
} */

function callonload()
{
	//alert("inside callonload");

	
/*	var printDivContent = $('#divPrintId').html();
	//alert(printDivContent);
	if(printDivContent!=undefined && printDivContent.trim()!='')
		{
			$("#btnOPD").trigger("click"); 
			 /* window.setTimeout(function (){
								$("#opdModal .close").trigger("click");
						},60000);  */
		} 


	$('#product_info_table').dataTable( {
        "scrollY":        300,
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

	

	
	
if(document.getElementsByName("hmode")[0].value=="NEWWW")		
{
	


 pat_crno=<%=request.getAttribute("patCrNo")%> ;
 clientShortName=<%=request.getAttribute("clientShortName")%> ;
 pat_ward=<%=request.getAttribute("wardCode")%> ;
  pat_reqtype=<%=request.getAttribute("patStatusCode")%> ;

//alert(pat_ward);

document.getElementsByName("sampleAreaCode")[0].value=pat_ward;
//alert(pat_crno);
$('#crNoInput').val=pat_crno;


//document.getElementsByName("patCrNo")[0].value="961012000000732";
document.getElementById("crNoInput").value=pat_crno;
//document.getElementById("patStatusCode")[0].value="";
document.getElementsByName("sampleAreaCode")[0].value=pat_ward;
document.getElementsByName("patStatusCode")[0].value=pat_reqtype;

var crno = $('#crNoInput').val();
$('.patDetails').removeClass("d-none");

var globalSearchParam={ crNo:crno, billNo:"",searchType:"1"};
AjaxGetPatDetails(globalSearchParam);

$.when(globalAjaxGetPatDtlObj ).then(function( data, textStatus, jqXHR ){
	//console.log("fffffff");
 //alert("Loading...");
	var patDtl = globalPatientDetails[0].patStatusCode;
	//alert(patDtl);
	billedUnbilledfun_ipd("2",pat_ward);
	$('#tabsId').removeClass("d-none");
	 });
	 
showLoding(false);
$('#container2ExpandBtn').click();
$("#container2ExpandBtn").off("click");
$('#container2ExpandBtn').addClass("d-none");
$('#CancelBtn1').addClass("d-none");



}
//$('#resultEntryForm').show();




</script>

  <script>

  function onload(){
	  //document.getElementById("divtestdtl").innerHTML = $("input[name=strResultDtl]").val();
	   //Added for Data tables. 
	  $('#product_info_table').dataTable( {
        "scrollY":        300,
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

 
  </script>


</head>
<body onload="callonload()">

<html:form action="/NEWOfflineResultEntry" >

<fieldset class="m-2 px-1">
	<legend>
	
		<div class="container-fluid my-0 noUserSelect mx-0 px-0" id="container1">
			<div class="row align-items-center no-gutters"><!--  px-1 px-md-2  -->
			
				<div class="col-8 col-sm-6 col-md-3 col-lg-3 textFit">
					<p class="text-nowrap"  style="font-family:averta-extrabolduploaded_file;font-size:21px;">
						<span class="text-primary"><img  src='..\new_investigation\media\images\blood-sample.png'></span>
						Offline Result Entry 
						<span class="fullScreenBtn"><img height="26" width="26" src='..\new_investigation\media\images\expand.svg'></span>
					</p>
				</div>
				
				<div class="col-4 col-sm-6 col-md-9 col-lg-9 d-flex justify-content-end mb-3">
					<hr class="lineBetween"></hr>
					
					
				</div>
				
			</div>
		</div>
	</legend>
	
			<div class="container-fluid mb-2" id="container2" style="margin-top:-15px;">

			
			
				 <div id="inptCrid" class="" style="margin-left: -26px; margin-right: -28px;">
				<his:InputCrNoInvestigationTag />
		 </div>
		 
		 

			
	
</div>


<!-------------------------------------------------------------------------------duplicate barcode section  ----------------------------------------------------------------------------->
<div class="container-fluid mb-2 d-none" id="container21" style="margin-top:-15px;">

			
			<div class="mx-1 row  p-2 align-items-center shadow rounded bg-white  hover-shadow collapse show" id="container2Row1"> <!-- style="font-family: 'Roboto', sans-serif;" -->
				<div class="col-12 col-lg-4 rounded border-right-lg border-primary noUserSelect" >
					<div class="input-group d-flex flex-nowrap mb-2">
						<div class="input-group-prepend">
							<div id="combo2" class="input-group-text" style="font-weight:400;font-size:14px;">Cr No.</div>
						</div>
					<input type="text" class="form-control" id="crNoInput1" placeholder="Enter Cr. No." maxlength="16" minlength="16" style="font-weight:400;font-size:14px;">
					</div>
				
				</div>
				
				
				<div class="col-12 col-lg-4 noUserSelect">
					<div class="form-row align-items-center d-flex">
							<div class="col-12 col-lg-4 mr-auto getDataBtnDiv" >
							<button id="getDataForDupBarCode" type="button" class="btn btn-primary ">
								<i class="text-nowrap"> Search </i>
							</button>

							<button id="getingData" class="btn btn-primary text-nowrap d-none"  disabled>
								<span class="spinner-border spinner-border-sm"></span> Loading..
							</button>
						</div>
						
						</div>
						</div>
						<div class="col-12 col-lg-4 noUserSelect">
						<div class="form-row align-items-center d-flex">
							<div class="radio" style="vertical-align:middle;color:rgb(0, 0, 139);" >
      							<label style="font-weight:700;font-size:14px;" ><input type="radio" name="duplicateBarcodeGen" onclick="showduplicatebarcode()">&nbsp;Duplicate BarCode Printing</label>
							</div>
							&nbsp;&nbsp;
						<div  id="sampleBack" class="radio" style="vertical-align:middle;color:rgb(0, 0, 139);" >
      							<label style="font-weight:700;font-size:14px;"><input type="radio" name="samplesection"  onclick="showsamplecol()">&nbsp;Sample Collection</label>
						</div>
					</div>

				</div>
				
			</div>

				<div class="d-flex justify-content-end border-top-lg border-dark mx-1  ">
				<button id="container2ExpandBtn" class="btn btn-sm btn-warning ml-auto" type="button" data-toggle="collapse" data-target="#container2Row1" aria-expanded="true" aria-controls="collapseExample">
					<i class="fa fa-arrow-up "></i>
					<i class="fa fa-arrow-down d-none"></i>
				</button>
				</div>
</div>

<div class="container-fluid contianer-responsive  col-12 col-sm-12 col-md-12  d-none" id="barcodePatDivId" >

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-10"><h5 class="text-black"  style="font-weight:700;font-size:14px;">Sample Collected Details <span class="badge badge-primary" id="barcodeSpan"></span></h5></li>
	</ul>

	<div id="tab-10" class="tab-content current">
				<div id="alltab-1" class="col-12 pt-2 collapse show" >
					<table id="exampleBarCode"
						class="table table-sm dt-responsive nowrap table-condensed mx-md-0 rounded bg-white "
						style="width: 100%">
						<thead style="font-weight:700;font-size:14px;">
							<tr style="font-size:14px;">
								<th></th>
								<th><input type="checkbox" onclick="dupselectAll()" id="dupselectallchk"></th>
								<th>CR No</th>
								<th>Patient Name</th>
								<th>Age</th>
								<th>Lab Name</th>
								<th>Test Name</th>
								<th>Sample No.</th>
								<th>Requisition Date</th>
								<th>Patient Status</th>
								<th>Department Unit</th>
								<th>Visit Date</th> 
							</tr>
						</thead>
						<tbody style="font-weight: 400;font-size: 14px;">
						</tbody>
						
					</table>
				</div>
				
				<div class="col-12 pt-2 d-flex justify-content-center" id="save_id" style="font-size:0.9em;font-weight:bold; color:red; padding-left:0px;padding-top:5px; margin-left:0px;"></div>
				
				
				<div class="col-12 pt-2 d-flex justify-content-center">
				
					<div class="saveGENBtnDiv">
						<button id="saveGENBtn" type="button" class="btn btn-primary text-nowrap saveValidateBtn" disabled onClick="GenerateBarcode()">
							<span class=""></span> Go
						</button>
					</div>
					&emsp;
					
					<div class="CancelBtnDiv">
						<button id="CancelBtn2" type="button" class="btn btn-danger text-nowrap CancelBtn">
							<span class=""></span> Cancel
						</button>
					</div>
				</div>
			<div class="col-12 pt-2 d-flex justify-content-center" id="save_id" style="font-size:0.9em;font-weight:bold; color:red; padding-left:0px;padding-top:5px; margin-left:0px;"></div>
	</div>
	

</div>


<!----------------------------------------------------------------------End  ----------------------------------------------------------------->
<div class="container-fluid mb-2 d-none patDetails" id="patDetails">
			<div class="mx-md-1 mx-md-point5 row p-2 align-items-center shadow rounded-lg bg-white no-gutters">


				<div class="col-12 col-md-12  rounded hover-shadow overflow-auto patDetails" id="patDetails-table-Opd">
			 
					<table id="DataTableOPD" class="table table-sm dt-responsive nowrap table-condensed mx-md-0 rounded bg-white " style="width: 100% ; ">
						<thead style="font-weight: 700;font-size: 14px;">
							<tr>
								<th>Patient Name</th>
								<th>CR Number</th>
								<th>Patient Status</th>
								<th>Gender</th>
								<th>Age</th>
								<th>Guardian Name</th>
								<th>Category</th>
								<th>DOB</th>
								<th>Mobile No</th>
								<th>Address</th>
							</tr>
						</thead>
						<tbody style="font-weight: 400;font-size: 14px;"> </tbody>
					</table>
				</div>
				
				<!-- <div  class="col-1 col-md-1 d-flex justify-content-center overflow-hidden">
								&nbsp;
				</div>	 -->
				<div class="col-12 col-md-12  rounded hover-shadow overflow-auto patDetails" id= patDetails-table>
					
					<table id="episodeDetailTable" class="table table-sm dt-responsive nowrap table-condensed mx-md-0 rounded bg-white " style="width:100% ;">
					    <thead style="font-weight: 700;font-size: 14px;">
					      <tr>
					      	  <th></th>	
					          <th>Department Name</th>
					           <th>Unit Name</th>
					           <th>Last Visit Date</th>
					        </tr>
					    </thead>
					       <tbody style="font-weight: 400;font-size: 14px;"> </tbody>
					   </table> 
					</div>
				
				
  <input type="hidden" name="patCategoryCode" id="patCategoryCode_samplecoll01">
			
				<div class=" col-md-12  rounded hover-shadow overflow-auto d-none patDetails" id="patDetails-table-Ipd" >
			
					<table id="DataTableIPD" class="table table-sm dt-responsive nowrap table-condensed mx-md-0 rounded bg-white " style="width: 100% ; ">
						<thead style="font-weight: 700;font-size: 14px;">
							<tr>
								<th>Patient Name</th>
								<th>CR Number</th>
								<th>Patient Status</th>
								<th>Gender</th>
								<th>Age</th>
								<th>Guardian Name</th>
								<th>Category</th>
								<th>DOB</th>
								<th>Admission Date</th>
								<th>Admission No.</th>
								<th>Department Name</th>
								<th>Ward Name</th>
								<th>Room Name</th>
								<th>Bed Name</th>
								<th>Diagnosis</th>
								<th>Consultant Name</th>
								<th>Mobile No</th>
								<th>Address</th>
							</tr>
						</thead>
						<tbody style="font-weight: 400;font-size: 14px;"> </tbody>
					</table>
				</div>

			</div>
		</div>


	
	<logic:equal value="1" name="NEWOfflineResultEntryFB" property="strMsgType">
<div id= "msgId" style="float:center;margin-left: 42%;color: red;font-weight: bold;font-size: 12px;padding-top: 5px;">
<bean:write name="NEWOfflineResultEntryFB" property="strMsgString" filter="false"/> 
</div>
</logic:equal>
<logic:equal value="0" name="NEWOfflineResultEntryFB" property="strMsgType">
<div id= "msgId" style="float:center;margin-left: 42%;color: green;font-weight: bold;font-size: 12px;padding-top: 5px;">
<bean:write name="NEWOfflineResultEntryFB" property="strMsgString" filter="false"/> 
</div>
</logic:equal>
	      
    
          
         <!--  Div to input CR number in case of already registered patient. -->
         
              <div class="box-body" style="padding: 10px 3px 0px 3px;">
                
             
  
                
                <div id="newOfflineTestsListId" class="container-fluid mb-2 d-none "> 
                 <div class="col-md-12 col-xs-12" id= "newofflineTestsListId" style="padding-right: 0px;padding-left: 0px;">
                 <div class="box box-solid box-primary" style="border: 0px;">
                 <div class="box-header" style="padding: 10px 0 10px 10px;;">
                    <h3 id="combo1" class="input-group-text" style="font-weight:400;font-size:14px;">Test Details</h3>                    
                 </div>
                 
                   <div class="box-body">
                  <div id="divtestdtl" style="font-size: font-size: 15px;/*! width: 100%; */;">
                  	<bean:write name="NEWOfflineResultEntryFB" property="strResultDtl" filter="false"/>
                  </div>
                  <br/>
	    			<br/>
	    			<br/>
	    			<br/>
                  </div>
                  </div>
                </div>
           
              <!-- /.box-body -->

			
				<input type="hidden" name="isAlreadyPatient" value="0"/>	
				<input type="hidden" name="isDuplicacyChkRqd" value="0"/>
				 
              
    			
              </div>
               <div class="box-footer text-center" id = "offlineEntryFormFooterId" style="position: fixed;bottom: 0;width: 100%;">
                <!-- <a href="" class="btn btn-success" onclick = "saveOfflineResEntry();">Save</a> -->
               <!--  <button type = "button" id='btnsave' class="btn btn-success" >Save</button>
                <a href="" class="btn btn-warning" id= "reset_btn_id">Reset</a>
               -->   <button type = "submit" class="btn btn-success">Save</button>
                <a href="" class="btn btn-warning" id= "reset_btn_id">Reset</a>
                <div class="modal"><!-- Place at bottom of page --></div>
                
             </div>  
           
			<!-- Added by nandini -->
			<html:hidden name="NEWOfflineResultEntryFB" property="isbillingreq" styleId="isbillingreq"/>
	 <!-- 	<html:hidden name="NEWOfflineResultEntryFB" property="strPatHospCode"/>   OnlineReqJson-->
	        <html:hidden name="NEWOfflineResultEntryFB" property="patEpisodeCode"/>
	        <html:hidden name="NEWOfflineResultEntryFB" property="patVisitNo"/>    
			<html:hidden name="NEWOfflineResultEntryFB" property="patName"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patStatus"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patGenderCode"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patAge"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patGuardianName"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patCategoryCode"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patDOB"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patMobileNo"/>
			<html:hidden name="NEWOfflineResultEntryFB" property="patAddress"/>
			 <html:hidden name="NEWOfflineResultEntryFB" property="departmentname"/>
			  <html:hidden name="NEWOfflineResultEntryFB" property="unitname"/>
			   <html:hidden name="NEWOfflineResultEntryFB" property="visitdate"/>
			    <%-- <html:hidden name="NEWOfflineResultEntryFB" property="varclientshort"/> --%>
			      <input type="hidden" id="varclientshort" name="varclientshort"  value="<%=request.getAttribute("clientShortName")%>"> 
			     <input type="hidden" id="varclientcode" name="varclientcode"  value="<%=request.getAttribute("clientCode")%>"> 
 <input type="hidden" id="varclientname" name="varclientname"  value="<%=request.getAttribute("clientName")%>"> 
 <input type="hidden" id="varclientstartyear" name="varclientstartyear"  value="<%=request.getAttribute("clientStartYear")%>"> 
 <input type="hidden" id="ptcrno" name="ptcrno"  value="<%=request.getAttribute("ptcrno")%>"> 
 
 
			   
		  
			<!-- Ended by nandini Singh -->
			
			
			    
       
	<div id="tab-2" class="tab-content ">
		 <div id="allValReqnList_tab-2" class="col-12 pt-2 collapse " >
					<table id="example1" class="display table table-sm  nowrap table-condensed mx-md-0 shadow rounded bg-white hover-shadow" style="width: 100%;">
						<thead style="font-weight:700;font-size: 14px;">
							<tr>
				
                <th>Lab Name</th>
               	<th>Test Name</th>
                <th>Requsition Date</th>
                <th>Priority</th>
			    <th>Priority</th>
			
							</tr>
						</thead>
						<tbody style="font-weight:400;font-size: 14px;">
						</tbody>
						
					</table>
				</div>
				
				
				
				<div class="col-12 pt-2 d-flex justify-content-center">
				
					
					<div class="cnclBtnDiv">
						<button id="CancelBtn3" type="button" class="btn btn-danger text-nowrap " >
							<span class=""></span> Cancel
						</button>
					</div>
				</div>
				<div class="col-12 pt-2 d-flex justify-content-center" id="save_id" style="font-size:0.9em;font-weight:bold; color:red; padding-left:0px;padding-top:5px; margin-left:0px;"></div>
				
	</div>
	

</div><!-- container -->

</fieldset>

<html:hidden name="NEWOfflineResultEntryFB" property="duplicateBarcodeGeneration" />
 			<input type='hidden' name="hmode" />
			<%-- <html:hidden name="NEWOfflineResultEntryFB" property="hmode" /> --%>
			<html:hidden name="NEWOfflineResultEntryFB" property="flagforipddesk" />
			<html:hidden name="NEWOfflineResultEntryFB" property="statuschange" />
			<html:hidden name="NEWOfflineResultEntryFB" property="modebarcode" />
			<html:hidden name="NEWOfflineResultEntryFB" property="selectedCheckbox" />
			 <html:hidden name="NEWOfflineResultEntryFB" property="showStatus" />
			<html:hidden name="NEWOfflineResultEntryFB" property="sampleAreaName" />
			<html:hidden name="NEWOfflineResultEntryFB" property="sampleAreaCode" />
			<html:hidden name="NEWOfflineResultEntryFB" property="isSampleAreaSelected" />
			<html:hidden name="NEWOfflineResultEntryFB" property="isSearchclicked" />
			<html:hidden name="NEWOfflineResultEntryFB" property="patStatusCode" />
			<%-- <html:hidden name="NEWOfflineResultEntryFB" property="VarClientShort" /> --%>
			 <html:hidden name="NEWOfflineResultEntryFB" property="onlineReqJson" styleId="onlineReqJson"/>
			 <!-- <input type='hidden'  name="crNoInput" id="crNoInput"/>  -->
			 <html:hidden name="NEWOfflineResultEntryFB" property="crNoInput" /> 
			 
			 

</html:form>

<a data-fancybox data-type="iframe" id="fancyBoxIFrame" class="fancyBoxIFrame"></a>



<!--  <script type="text/javascript">

    $('form').on('submit', function(e) { 
    	e.preventDefault();

    	//alert("inside save fution")
    	
    //	validateMobNo();
	  //  validateAge();
	    //validateDates();
	    
	  //  var h= document.getElementById("strPatHospCodeId");
		//var hospCode = h.options[h.selectedIndex].value;

	//	if(hospCode== "0"){
		//	alert("Please Select Hospital Name !");
			//e.preventDefault(e);
			//}
		
	   
  	});
  	
    	$(window).keydown(function(e){
        	if(e.keyCode == 13) {
         		e.preventDefault();
          		return false;
        }
      });

    	var lastDate = new Date();
	  	lastDate.setDate(lastDate.getDate() - 7);  //Date of 7 date before.
    	
    $("#samplecoldate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});//.datepicker({startDate: new Date()}); //minDate: lastDate, 
    $("#resultDate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',}).datepicker("setDate",'now');
     
  });

   
  </script>  -->


<!-- <script>

 $(document).ready(function() { 
	alert("ready");
	$('#btnsave').click(function(){
		alert("click")
		 var testReqFlf = 0;
	    	document.getElementsByName("strTestResult").forEach(function(e) {
	  		  if(e.value.trim()!="")
	  			  {
	  			  	testReqFlf++;
	  			  }
	  		});

	    	 if(testReqFlf == 0){
	   		  alert("Please enter atleast one test result");
	   			e.preventDefault(e);
	   		  }

	    	 if(testReqFlf > 0){
	    		 document.getElementsByName("strTestResult").forEach(function(e) {
	    	  		  e.disabled = false;
	    	});
			if(document.forms[0].isAlreadyPatient.value == "0") {
				  if($('#onlineReqJson').val()!=undefined  && $('#onlineReqJson').val()!=""){
					var finalArrTest= new Array();
					var jsonArr=JSON.parse($('#onlineReqJson').val());
					$("[name=srrChk]:checked").each(function(){
						var arr= this.value.split("^");
						$.each(jsonArr,function(indx,jsonobj){
							if(jsonobj["gnum_test_code"]==arr[1]){
								jsonobj["resultEntered"]="1";
								//jsonobj["labCode"]=arr[1];
								jsonobj["patCRNo"]= $('[name="patCRNo"]').val();
								finalArrTest.push(jsonobj);
							}
						});					
					});
					$('#onlineReqJson').val(JSON.stringify(finalArrTest))
				 } 
						
					 	document.forms[0].hmode.value = "insert";
					  	document.forms[0].submit();
			}
	    		if(document.forms[0].isAlreadyPatient.value == "1"){

//	    				var nodes = document.getElementById("patDtlId").getElementsByTagName('*');
	  //  				for(var i = 0; i < nodes.length; i++){
	    //				     nodes[i].disabled = true;saveAlreadyRegPat
	    	//			  }
	    				//document.getElementById("patCRNoId").readOnly = true;generateComposition
	    				  
	    			document.forms[0].hmode.value = "saveAlreadyRegPat";
	    				document.forms[0].submit();
	    			}
	    		  {
	    		  		localStorage.setItem("isPrintCalled","true");
	    		  	/* var options = {
	    		  	  };
	    		  	  var pdf = new jsPDF('p', 'pt', 'a2');
	    		  	  pdf.addHTML($("#PDFBODY"), 15, 15, options, function() {
	    		  	    pdf.save('pageContent.pdf');
	    		  	  }); */
	    		  	  /* window.print(); */
	    		  	   $('img').each(function() {
	    		  	      $("img").attr("src", function() {
	    		            return $(this).attr("class");
	    		      });
	    		  	   });
	    		 
	    		  	//alert(str);
	    		  	//alert("hi");
	    		  	var encodedStr = window.btoa(encodeURI(str), 'UTF-8');
	    		  	document.getElementsByName("htmlPreview")[0].value= encodedStr;
	    			 submitForm21('SAVEDOCPDF');

	    		  }

				
	   	 		}

		
		});
});





</script> -->
  
   <!-- <script type="text/javascript">
$(document).ready(function() {
	
    $('form').on('submit', function(e) {
        alert('insave')

    	e.preventDefault();

    	alert("inside save fution")

		
	    var testReqFlf = 0;
    	document.getElementsByName("strTestResult").forEach(function(e) {
  		  if(e.value.trim()!="")
  			  {
  			  	testReqFlf++;
  			  }
  		});

    	 if(testReqFlf == 0){
   		  alert("Please enter atleast one test result");
   			e.preventDefault(e);
   		  }

    	 if(testReqFlf > 0){
    		 document.getElementsByName("strTestResult").forEach(function(e) {
    	  		  e.disabled = false;
    	});
		if(document.forms[0].isAlreadyPatient.value == "0") {
			  if($('#onlineReqJson').val()!=undefined  && $('#onlineReqJson').val()!=""){
				var finalArrTest= new Array();
				var jsonArr=JSON.parse($('#onlineReqJson').val());
				$("[name=srrChk]:checked").each(function(){
					var arr= this.value.split("^");
					$.each(jsonArr,function(indx,jsonobj){
						if(jsonobj["gnum_test_code"]==arr[1]){
							jsonobj["resultEntered"]="1";
							//jsonobj["labCode"]=arr[1];
							jsonobj["patCRNo"]= $('[name="patCRNo"]').val();
							finalArrTest.push(jsonobj);
						}
					});					
				});
				$('#onlineReqJson').val(JSON.stringify(finalArrTest))
			 } 
					
				 	document.forms[0].hmode.value = "insert";
				  	document.forms[0].submit();
		}
    		if(document.forms[0].isAlreadyPatient.value == "1"){


    				  
    			document.forms[0].hmode.value = "saveAlreadyRegPat";
    				document.forms[0].submit();
    			}
    		  {
    		  		localStorage.setItem("isPrintCalled","true");
    		  
    		  	  /* window.print(); */
    		  	   $('img').each(function() {
    		  	      $("img").attr("src", function() {
    		            return $(this).attr("class");
    		      });
    		  	   });
    		 
    	
    		  	var encodedStr = window.btoa(encodeURI(str), 'UTF-8');
    		  	document.getElementsByName("htmlPreview")[0].value= encodedStr;
    			 submitForm21('SAVEDOCPDF');

    		  }

			
   	 		}
  	});
  	
    	$(window).keydown(function(e){
        	if(e.keyCode == 13) {
         		e.preventDefault();
          		return false;
        }
      });

    	var lastDate = new Date();
	  	lastDate.setDate(lastDate.getDate() - 7);  //Date of 7 date before.
    	
    $("#samplecoldate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});//.datepicker({startDate: new Date()}); //minDate: lastDate, 
    $("#resultDate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',}).datepicker("setDate",'now');
     
  });

   
  </script> -->
  <input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value="<%=request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>"/>

</body>




</html>