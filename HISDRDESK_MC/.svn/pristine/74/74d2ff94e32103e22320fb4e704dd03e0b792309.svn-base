<%@page import="org.json.simple.*"%>
<%@page import="javax.json.JsonArray"%>
<%@taglib uri="/WEB-INF/HisTools.tld" prefix="HIS_MC"%>
<%@page import="java.util.*"%>
<%@page import="org.apache.commons.collections.MultiMap"%>
<%@page import="org.apache.commons.collections.map.MultiValueMap"%>
<%@page import="org.json.*"%>
<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>


<meta charset="utf-8">

<%HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);

String dosageOptionHTML=(String)request.getSession().getAttribute("dosageOptionHTML");
String frequencyHTML=(String)request.getSession().getAttribute("frequencyHTML");
%>

<link rel="icon" href="/HIS/hisglobal/snomedct/css/images/csnotk.ico">
 <link rel="stylesheet" href="/HIS/hisglobal/snomedct/css/jquery-ui.css">  
<script type="text/javascript" src="../../new_opd/assests/jquery.autocomplete.js"></script>

<script type="text/javascript" src="../../new_opd/assests/jquery-ui.min.js"></script>
<script type="text/javascript" src="/HIS/hisglobal/snomedct/js/searchtoolmultiautocomplete.js"></script>  
<script src="/HIS/hisglobal/drDeskAssets/flexdatalist/jquery.flexdatalist.min.js"></script>    
<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
<script src="/HIS/hisglobal/drDeskAssets/tippy/tippy.all.min.js"></script>


<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/sectionBookMark.js"></script>
<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/myScript.js?v=160525"></script> 
<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/prescrptionProfile.js?v=160525"></script> 
<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/prescriptionScript.js"></script> 
<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/flexdatalist/jquery.flexdatalist.min.css">


	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/assests/jquery-confirm.min.css">
	<script src="/HISDRDESK_MC/new_opd/assests/jquery/jquery-confirm.min.js"></script>
	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/Chief_Complaint.js"></script> 
	
	<link href="/HISDRDESK_MC/new_opd/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="/HISDRDESK_MC/new_opd/css/bootstrap.css" rel="stylesheet">
	
 	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/OpenTemplate.js"></script>
	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/ExtOpenTemplate.js"></script> 
	<link rel="stylesheet" type="text/css" href="/HISDRDESK_MC/new_opd/css/fb.css"> 
	<link rel="stylesheet" type="text/css" href="/HISDRDESK_MC/new_opd/css/opdtemplate.css"> 
	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/cimsintegration.js"></script> 
	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/fileUploas.js"></script> 


<link type="text/css" href="/HISDRDESK_MC/cims/CSS/mims.css" rel="stylesheet">
<script type="text/javascript" src="/HISDRDESK_MC/cims/Scripts/jjQuery JavaScript Library v2.1.3.js"></script>
<script type="text/javascript" src="/HISDRDESK_MC/cims/Scripts/jquery-ui.min.js"></script>
<script type="text/javascript" src="/HISDRDESK_MC/cims/Scripts/drugalert.js"></script>

<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/speechScript.js"></script> 
<script type="text/javascript" src="/HIS/hisglobal/FormFlowX/js/base64.js"></script>  
 
<style>
.referheading {
	font-weight: bold;text-align: left;border-bottom: 1px solid #d7d7d7;padding: 6px;
}
/*.ui-menu-item:hover{
 background:red; 
}*/
.ui-menu-item .ui-menu-item-wrapper.ui-state-active {
	border: none !important;
    background: #6693bc !important;
    font-weight: bold !important;
    color: #ffffff !important;
}


.flexdatalist-results li span.highlight {
 font-weight:700;
 text-decoration:underline;
  background:yellow;
}

	.nav-tabs .active a {
	    background-color: #2b438a !important;
	    color: #fff !important;
	 } 
	 ul#menu1 li {
	display:inline;
	margin: 0px !important;
	font-size: 14px;
	letter-spacing: inherit !important;
	color: #5a5a5a !important;
	font-weight: 600;
	text-align: justify;
	}
	
	
	#AllergyResponse h3{
	border:none !important;
	background:none !important;
	height:initial !important;
	padding-top:0px !important;
	}
	
	
	#MonographResponse p{
	border:none !important;
	background:none !important;
	height:initial !important;
	padding-top:0px !important;
	}

.tmp-search{
	display:inline !important;
	width:15%;
	position:absolute;
	border-radius:10px;
	left:10px;
	
}
.cent-any{
display:flex;
justify-content:center;
align-items:center
}
	
</style>
<style>

 .genericDesc{
  font-size:20px;
  color:#004080;
 }
 
 .drugTypeName{
 font-size:18px;
 }
 
 .modal-header{
 color:#41B4E1;
 font-size: large;
 }

 
  .micDiv{
 	position: absolute;
 	top: 6px;
 	right: 60px;
 	cursor:pointer;
 	}
  .micDiv i{
   color: darkolivegreen;
   font-size: 1.2em;
  
   }

.column{
color : white;
font-weight:bold;
}
.column ul li:hover,
.column ul li:focus{
  color: black;
}
 
.column ul li{
	font-weight:normal;
	font-size: 90%;
}


.fontred{
	color: red;
}
 
 .legacy-container {
    max-height: 250px; /* Adjust height as needed */
    overflow-y: auto;
    display: block;
}

.legacy-table {
    width: 100%;
    border-collapse: collapse;
}

.legacy-table thead {
    position: sticky;
    top: 0;
    background: white;
    text-align: left;
    z-index: 10;
}
.legacy-table tbody {
	text-align: left;
}
 
</style>
 
<%@page import="java.util.*"%>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>

<!-- Buttons and Image tag for Uploaded Prescriptions starts here --> 
  <div class="btn-group btn-group-lg" id="prescImgControlBtnGrpFixed" style="display:none;position: fixed; top: 0px; z-index: 10000; right: 0px;">
    <button id="prescImgZoomOutBtnFixed" type="button" style="  */font-size: 18px; padding: 0px 7px;" class="btn btn-warning btn-sm"><i class="fa fa-minus-circle"></i></button>
	<button id="prescImgZoomInBtnFixed" type="button" style="font-size: 18px; padding: 0px 7px;" class="btn btn-warning btn-sm"><i class="fa fa-plus-circle"></i></button>
	<button id="prescImgOriginalBtnFixed" type="button" style=" font-size: 18px; padding: 0px 7px;" class="btn btn-warning btn-sm"><i class="fa">&#xf1c5;</i></button>
	<button id="" type="button" style=" font-size: 18px;padding: 0px 10px;" class="btn btn-warning btn-sm" onclick="printImg()"><i class="fa fa-print"></i></button>
	<button id="prescImgRotateLeftBtnFixed" type="button" style="font-size: 18px; padding: 0px 7px; " class="btn btn-warning btn-sm"><i class="fa">&#xf0e2;</i></button>
	<button id="prescImgRotateRightBtnFixed" type="button" style="  font-size: 18px; padding: 0px 7px; " class="btn btn-warning btn-sm"><i class="fa">&#xf01e;</i></button>
	<button id="prescImgCloseBtnFixed" type="button" style=" font-size: 18px;padding: 0px 10px;" class="btn btn-danger btn-sm">x</button>
  </div>
  <img id="prescImgFixed" src=""  style="position:fixed; display:none; right:0; z-index:9998;top:0px; width:27%;height:100vh"/> <!-- /HISDRDESK_MC/new_opd/img/pat_presc.jpg -->
<!-- Buttons and Image tag for Uploaded Prescriptions Ends here --> 
	
	
 <script type="text/javascript">
function printImg() {
  pwin = window.open(document.getElementById("prescImgFixed").src,"_blank");
  pwin.print();
  pwin.close();
  
}
</script>

  
 <script> 


	function bookMarkListView() {
		  console.log('test ------- ');
		  $(".bookMarkListView").css("display","");
		  $("#moreDiv").css("display","none");
		  $("#lessDiv").css("display","");
		}

	function bookMarkListHide() {
		  console.log('test ------- ');
		  $(".bookMarkListView").css("display","none");
		  $("#moreDiv").css("display","");
		  $("#lessDiv").css("display","none");
		}
 </script>
  <!-- Modal -->
      <div class="modal fade" id="chronicDiseaseInstructionsModal" role="dialog">
        <div class="modal-dialog">       <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">x</button>
              <h2 class="modal-title">Chronic Disease Instructions</h2>
            </div>
            <div class="modal-body" style="text-align: left;">
               <p class="text-center">
                 Instructions of doctor will append here.
               </p>
            </div>  
          </div> 
        </div>
      </div>

      <!-- Modal -->
      <div class="modal fade" id="allergiesDtlInstructionsModal" role="dialog">
        <div class="modal-dialog">       <!-- Modal content-->
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal">x</button>
              <h2 class="modal-title">Allergies Instructions</h2>
            </div>
            <div class="modal-body" style="text-align: left;">
               <p class="text-center">
                 Instructions of doctor will append here.
               </p>
            </div>  
          </div> 
        </div>
      </div> 
  
  		<!-- Modal -->
			      <div class="modal fade" id="opdEmrModal" role="dialog">
			          <div class="modal-dialog modal-xl">       <!-- Modal content-->
			          <div class="modal-content">
			              <div class="modal-header">
			              	<div style="width: 50%;float:left;"><h3 style="text-align:left;font-weight: bold;">Past Rx</h3></div>
				              <button type="button" class="close" data-dismiss="modal">x</button>
				              
		                  </div>
		                  <div class="modal-body page-content-wrapper" style="text-align: left;"> 
			              	<div class="row" style="min-height:300px;">
			                	<div class="col-sm-12">
			                		<div class="col-xs-5 col-sm-3 col-md-2"> 
							            <ul class="nav nav-tabs tabs-left nav-pills nav-stacked opdEmrModalNavMenu">
							                <li class="active"><a href="#home" data-toggle="tab">Select Date</a></li> 
							            </ul>
							        </div>
							        <div class="col-xs-7 col-sm-9 col-md-10">
							        	
							            <div class="tab-content opdEmrModalNavMenuContent">
							                <div class="tab-pane active" id="home">
												<ul class="patPreviousPrescriptionList" style="list-style: disclosure-closed;">
												</ul>
							                </div> 
							            </div>
							        </div>
			                  <div class="clearfix"></div>
			                </div>  
			              </div>
			              
			            </div>  
			              </div> 
			          </div>
			      </div>
                 <!--  --> 
                 
                 <!-- Modal -->
			      <div class="modal fade" id="medicineHistoryModal" role="dialog">
			          <div class="modal-dialog modal-xl">       <!-- Modal content-->
			          <div class="modal-content">
			              <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal">x</button>
				              <h2 class="modal-title text-left">Prescribed Medicine History</h2>
		                  </div>
		                  <div class="modal-body" style="text-align: left;"> 
				              <div class='row'>
								<div class="col-md-12">
						          	<table class='table table-hover table-condensed table-checkable' id="medicineHistoryTable" style="width: 100%;"> 
							           <thead>
							             <tr style='background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);'>
							             	<th style="width: 10%; padding: 5px;text-align:center">S.No</th>
											<th style="width: 20%; padding: 5px">Medicine</th>
											<th style="width: 10%;text-align:center; padding: 5px">Dose</th>
											<th style="width: 15%;text-align:center; padding: 5px">Frequency</th>				
											<th style="width: 10%;text-align:center; padding: 5px">Days</th>
											<th style="width: 10%;text-align:center;; padding: 5px">Pres. Qty</th>
											<th style="width: 10%;text-align:center; padding: 5px">Issued Qty</th>
											<th style="width: 15%; padding: 5px">Instruction</th>
							            	<th style="width:5%;text-align:center;padding: 5px ">Status</th>
							            	<th style="width:5%;text-align:center;padding: 5px "></th>
							       		</tr>
							           </thead>
							       	   <tbody>
							           	</tbody> 
									</table>
								</div>
							</div>
			              </div>  
			          </div> 
			         </div>
			      </div>
                 <!--  -->
                 
                 <!--  Stock Modal Starts -->
                  <div class="modal fade" id="medicineStockModal" role="dialog" style="margin-top: -28px;!important">
			          <div class="modal-dialog modal-xl" style="width: 98% !important">       <!-- Modal content-->
			          <div class="modal-content">
			              <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal">x</button>
				              <h2 class="modal-title text-left">Available Medicine in Wellness Center</h2>
		                  </div>
		                  <div class="modal-body" style="text-align: left;">
		                  	  <div class='row'>
		                  	  	<div class='col-md-3' style="text-align:right;"><label>Search</label></div>
		                  	  	<div class='col-md-6'><input type="text" id="globalSearch" class='form-control' placeholder="Search in all Medicine" /> </div>
		                  	  </div>	
		                  	  <div class='row' style="margin-bottom: 10px;">
		                  	  	<div class="col-md-2 rmLeftPaddInInput">
			                        <p style="letter-spacing:0"><label>Dosages </label></p>
			                       <div class="input-group">
			                          <input type="text" class="form-control " name="stockdoseQty" id="stockdoseQty" value="1" maxlength="2" onkeypress="return isNumber(event)">
			                          <div class="input-group-btn">
			                            <span class="btn btn-default" id="spanStockdoseQty">-</span>
			                          </div>
			                       </div>
                       			</div>
                      			<div class="col-md-2 rmLeftPaddInInput">
                        			<p style="letter-spacing:0"><label>Frequency</label></p>
                        			<select class="form-control" name="stockDrugFrequency" > 
                        				<option value="0">Select</option>
										
										  <%
			                        	 if(frequencyHTML!=null){%>
			                        	 	<%=frequencyHTML %>
			                        	 <%} %>
			                        </select> 
			                        <input type='text' class='customDrugFrequencyText' id='stockDrugFrequencyText' name='stockDrugFrequencyText' maxlength='100'  style="display:none;margin-top:5px;" placeholder="Enter Frequency">
			                      </div> 
                      			<div class="col-md-2"  style="display: none;">
			                        <p style="letter-spacing:0"><label>Start Date</label></p>
			                        <input type="date" class="form-control"  id="stockDrugStartDate" name="stockDrugStartDate" style="line-height: normal;">
			                      </div>
			                      <div class="col-md-2">
			                        <p style="letter-spacing:0"><label>Days</label></p>
			                        <input type="text" class="form-control drugDays" onkeypress="return isNumber(event)" name="stockDrugDays" value="" maxlength="2">
			                      </div>
			                      <div class="col-md-2">
			                        <p style="letter-spacing:0"><label>Quantity</label></p>
			                        <input type="text" class="form-control DrugQuantity" onkeypress="return isNumber(event)" name="stockDrugQuantity"  maxlength="3" value="">
			                        <input type='hidden' name='isManualEntryDoneStock' id='isManualEntryDoneStock' value="0" >
			                      </div>
			                      <div class="col-md-2">	
			                        <p style="letter-spacing:0"><label>Prescribed By</label></p>
			                         <input type='text' class="form-control refferedBy" id="stockRefferedBy"  maxlength="100" name='stockRefferedBy' />
			                      </div>
			                      <div class="col-md-2">
			                        <p style="letter-spacing:0"><label>Instructions</label></p>
			                        <input type='text'   class="form-control drugInstruction"  autocomplete="off"   placeholder='Remarks' id="stockDrugInstructionsId" name='stockDrugInstructions'>
			                      </div> 
		                  	  </div>
				              <div class='row' style="height:400px;overflow: auto;">
				              	<div class="col-md-4" style="padding: 2px;overflow: auto; ">
						          	<table class='table table-hover table-condensed table-checkable' id="NormalStockTable" style="width: 100%;">
						          	   <thead>
						          	   	 <tr class="tableHeading">
							             	<th style="padding: 5px;text-align:center" colspan="4">Normal Medicines</th>
							             </tr> 
							             <tr class="tableHeading">
							             	<th style="width: 5%; padding: 5px;text-align:center">S.No</th>
											<th style="width: 80%; padding: 5px">Medicine Name</th>
											<th style="width: 10%;text-align:center;; padding: 5px">Quantity</th>
							            	<th style="width:5%;text-align:center;padding: 5px "></th>
							       		</tr>
							           </thead>
							       	   <tbody>
							           	</tbody> 
									</table>
								</div>
								<div class="col-md-4" style="padding: 2px;overflow: auto; ">
						          	<table class='table table-hover table-condensed table-checkable' id="RestrictedStockTable" style="width: 100%;">
						          	   <thead>
						          	   	 <tr class="tableHeading" >
							             	<th style="padding: 5px;text-align:center" colspan="4">Restricted Medicines</th>
							             </tr> 
							             <tr class="tableHeading">
							             	<th style="width: 5%; padding: 5px;text-align:center">S.No</th>
											<th style="width: 80%; padding: 5px">Medicine Name</th>
											<th style="width: 10%;text-align:center;; padding: 5px">Pack Size</th>
							            	<th style="width:5%;text-align:center;padding: 5px "></th>
							       		</tr>
							           </thead>
							       	   <tbody>
							           	</tbody> 
									</table>
								</div>
								<div class="col-md-4" style="padding: 2px;overflow: auto; ">
						          	<table class='table table-hover table-condensed table-checkable' id="HighValueStockTable" style="width: 100%;">
						          	   <thead>
						          	   	 <tr class="tableHeading" >
							             	<th style="padding: 5px;text-align:center" colspan="4">Restricted Medicines (STC)</th>
							             </tr> 
							             <tr class="tableHeading">
							             	<th style="width: 5%; padding: 5px;text-align:center">S.No</th>
											<th style="width: 80%; padding: 5px">Medicine Name</th>
											<th style="width: 10%;text-align:center;; padding: 5px">Pack Size</th>
							            	<th style="width:5%;text-align:center;padding: 5px "></th>
							       		</tr>
							           </thead>
							       	   <tbody>
							           	</tbody> 
									</table>
								</div>
								
							</div>
			              </div>  
			          </div> 
			         </div>
			      </div>
                 <!--  Stock Modal Ends -->
                 
                 <!-- Modal -->
			      <div class="modal fade" id="opdTeleconsultationModal" role="dialog">
			          <div class="modal-dialog modal-lg">       <!-- Modal content-->
			          <div class="modal-content">
			              <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal">x</button>
				              <h2 class="modal-title text-left">Teleconsultation Remarks</h2>
		                  </div>
		                  <div class="modal-body" style="text-align: left;"> 
			              	<div class="row" style="min-height:300px;">
			                	<div class="col-sm-12">
			                		<!-- <div class="col-xs-5 col-sm-3 col-md-2"> 
							            <ul class="nav nav-tabs tabs-left nav-pills nav-stacked opdEmrModalNavMenu">
							                <li class="active"><a href="#home" data-toggle="tab">Select Date</a></li> 
							            </ul>
							        </div> -->
							        <div class="col-xs-7 col-sm-9 col-md-10">
							            <div class="tab-content opdTeleconsultationModalNavMenuContent">
							                <!-- <div class="tab-pane active" id="home">
												<ul class="patPreviousPrescriptionList" style="list-style: disclosure-closed;">
												</ul>
							                </div>  -->
							            </div>
							        </div>
			                  <div class="clearfix"></div>
			                </div>  
			              </div>
			              
			            </div>  
			              </div> 
			          </div>
			      </div>
                 <!--  -->
                 
                 
                 <!-- Modal -->
			      <div class="modal fade" id="TreeStructurePrescriptionModal" role="dialog">
			          <div class="modal-dialog modal-xl" style="min-width:90vw">       <!-- Modal content-->
			          <div class="modal-content">
			              <div class="modal-header">
				              <button type="button" class="close" data-dismiss="modal">x</button>
				              <h2 class="modal-title text-left">OPD EMR</h2>
		                  </div>
		                  <div class="modal-body" style="text-align: left;"> 
			              	<div class="row" style="min-height:300px;">
			                	<div class="col-sm-12">
			                		<div class="col-xs-5 col-sm-3 col-md-3"> 
							            <ul class="nav nav-tabs tabs-left nav-pills nav-stacked TreeStructurePrescriptionModalNavMenu">
							                <li class="active"><a href="#TreeStructurePrescriptionModalTab1" data-toggle="tab">Select Category</a></li>
							                
							                <li ><a href="#TreeStructurePrescriptionModalTab21" data-toggle="tab" onclick="cghsLegacyData()">Cghs Legacy</a></li>
							               <!-- <li><a href="#TreeStructurePrescriptionModalTab2" data-toggle="tab">Profile</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab3" data-toggle="tab">Vitals Chart</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab4" data-toggle="tab">Chief Complaint</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab5" data-toggle="tab">Diagnosis</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab6" data-toggle="tab">Investigations</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab7" data-toggle="tab">Drug/Advices</a></li>
							                <li><a href="#TreeStructurePrescriptionModalTab8" data-toggle="tab">Clinical Note</a></li> --> 
							            </ul>
							        </div>
							        <div class="col-xs-7 col-sm-9 col-md-9">
							            <div class="tab-content TreeStructurePrescriptionModalNavMenuContent">
							                <div class="tab-pane active treeStructurePresc" id="TreeStructurePrescriptionModalTab1">
												<ul class="TreeStructurePrescriptionModalErrMsg" style="list-style: disclosure-closed;">
												</ul>
							                </div>
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab2">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab2');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab21">
							                	<input id="cghsLegacyDataJson" style="display:none" name="cghsLegacyDataJson"/>
<!-- 							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab21');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div> -->
												<p>Medical History</p>
				<!-- Add radio button filters -->
						<div class="filter-container mb-3 d-flex justify-content-start gap-3"  style="background-color: lightblue;">
					    <div class="form-check form-check-inline">
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterAll" value="all" checked>
					        <label class="form-check-label" style="padding-right: 50px;" for="filterAll">All</label>
					    
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterAllopathy" value="Allopathy" >
					        <label class="form-check-label" style="padding-right: 50px;" for="filterAllopathy">Allopathy</label>
					    
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterAyurveda" value="Ayurveda">
					        <label class="form-check-label" style="padding-right: 50px; "for="filterAyurveda">Ayurveda</label>
					    
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterHomeopathy" value="Homeopathy">
					        <label class="form-check-label" style="padding-right: 50px; "for="filterHomeopathy">Homeopathy</label>
					   
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterSiddha" value="Siddha">
					        <label class="form-check-label" style="padding-right: 50px; for="filterSiddha">Siddha</label>
					        
					        <input class="form-check-input hosp-filter" type="radio" name="hospTypeFilter" id="filterUnani" value="Unani">
					        <label class="form-check-label" for="filterSiddha">Unani</label>
					    </div>
					</div>

												   
													<div class="legacy-container">	
													<table class='legacy-table table table-striped table-hover table-condensed table-checkable'style="width: 100%;"> 
												           <thead>
												             <tr>
												             	<th>Prescription Date</th>
												             	<th>Medicine Name</th>
												             	<th>Quantity</th>
												             	<th>WC NAME/Disp Code</th>	                           
												       		</tr>
												           </thead>
											           <tbody id="medicalHistoryTableId">
											           		<!-- Dynamic rows will be added here -->
											           </tbody> 
													</table>
												</div>
												<br>
												<p>Lab History</p>
													<div class="legacy-container">
														
														    <table class="legacy-table table table-striped table-hover table-condensed table-checkable" style="width: 100%;">
														        <thead>
														            <tr>
														                <th>Dispensary Code</th>
														                <th>Test Name</th>
														                <th>Registration No</th>
														                <th>Entry Date</th>
														                <th>Parent Dispensary</th>
														            </tr>
														        </thead>
														        <tbody id="labHistoryTableId">
														            <!-- Dynamic rows will be added here -->
														        </tbody>
														    </table>
														</div>
													<br>
													<p>Referral History</p>
													<div class="legacy-container">
													
													<table class='legacy-table table table-striped table-hover table-condensed table-checkable'style="width: 100%;"> 
												           <thead>
												             <tr>
												             	<th>Referral Id</th>
												             	<th>Ref Status</th>
												             	<th>Ref Date</th>
												             	<th>Ref Validity</th>	                           
												       		</tr>
												           </thead>
											           <tbody id="referralHistoryTableId">
											           		<!-- Dynamic rows will be added here -->
											           </tbody> 
													</table>
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab3">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="$('#parameterVitalsTrendBtn').hide();printDiv('TreeStructurePrescriptionModalTab3');$('#parameterVitalsTrendBtn').show();" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab4">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab4');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab5">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab5');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab6">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab6');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab7">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab7');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
												<div id="drugDiv"></div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab8">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab8');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab9">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab9');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab10">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab10');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab11">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab11');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab12">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab12');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab13">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab13');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>  
							                 <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab15">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab15');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab16">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab16');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>  
							                
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab17">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab17');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div>  
							                
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab18">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab18');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                
							                <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab19">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab19');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                
							                
							                  <div class="tab-pane treeStructurePresc" id="TreeStructurePrescriptionModalTab20">
							                	<div style="right:8px; position:fixed">
													<input type="button" onclick="printDiv('TreeStructurePrescriptionModalTab20');" value="Print" class="btn btn-info previousPrescDetailsPrintBtn pull-right" />
												</div>
							                </div> 
							                 
							            </div>
							        </div>
			                  <div class="clearfix"></div>
			                </div>  
			              </div>
			              
			            </div>  
			              </div> 
			          </div>
			      </div>
                 <!--  -->
  
  <!-- Modal -->
  <div class="modal fade" id="printAllModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Select Print Items</h2>
        </div>
        <div class="modal-body" style=" text-align: left;">
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Prescription</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Complaint</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Examination</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Episode  Alergies</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>History</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Patient Chronic Disease</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Service Requisition Details</p> 
            </div>
          </div> 
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>Admission Advice</p> 
            </div>
          </div>
          <div class="row">
            <div class="col-sm-2 col-sm-offset-2">
              <input type="checkbox" form="form-control" name="" checked=""> 
            </div>
            <div class="col-sm-8">
              <p>External Examination Details</p> 
            </div>
          </div>
          <br><br>
          <div class="row text-center">
           <!--  <button class="btn btn-primary savePrintPrescBtn" type="button">Print</button>   -->
          </div>
        </div> 
      </div> 
    </div>
  </div>

  <!-- Modal -->
  <div class="modal fade" id="followUpDocUploadModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Patient Document Upload</h2>
        </div>
        <div class="modal-body" style="text-align: left;">
        	<div id="followUpDocumentUpload" class="well center-block">
        		<div class="media">
				  <div class="media-left" style="width:20%">
				    <img src="/HIS/hisglobal/drDeskAssets/img/upload_icon2.png" class="media-object" style="width:60px">
				  </div>
				  <div class="media-body">
				    <h4 class="media-heading text-left">Upload File</h4>
				    <p>Drag and Drop...</p>
				  </div>
				</div>
        	</div> 
        	<div class="row">
        		<div class="col-sm-8 col-sm-offset-2">
        			<div class="dropzone-previews" id="followUpDocumentUploadPreview"></div>
        		</div>
        	</div>
        </div>  
      </div> 
    </div>
  </div> 

  <!-- Modal -->
     <%
          			MultiValueMap DrugProfileBookmark= (MultiValueMap) request.getSession().getAttribute("DrugProfile");
                   	
                     if(DrugProfileBookmark!=null)
                   	{
                   		Set<String> keys = DrugProfileBookmark.keySet();
                   	for(String key : keys){ 
                   		
                   	  %>
                   	  
					<div class="modal fade" id="investigationTestBundle<%=key.split("#")[0] %>" role="dialog">
					    <div class="modal-dialog">       <!-- Modal content-->
					      <div class="modal-content">
					        <div class="modal-header">
					          <button type="button" class="close" data-dismiss="modal">&times;</button>
					          <h2 class="modal-title">Bookmark Drug Detail</h2>
					        </div>
					        <div class="modal-body" style="text-align: left;">
					          <div class="row">
					            <div class="col-sm-16 col-sm-offset-1">
					              <p>Bookmark Name : <font class="bookmarkTestName"><%=key.split("#")[1] %></font></p>
					              
					             <table id="" class="table table-condensed table-hover" style="margin-bottom: 0px;"> 
                            <thead>
                              <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
                                <th style=""><input type="checkbox" class="checkedInputAll" name="drugsAdvicesAll"></th><th>Drug</th><th>Dosage</th><th>Frequency</th><th class="drugAdviceListExcessCol">Start Date</th><th>Days</th><th>Quantity</th><th class="drugAdviceListExcessCol">Instructions</th><th>Change</th>
                              </tr>
                            </thead>
                            <tbody>
                            
				       <%
						JSONObject drugProfileJsonObj =null;
				      
						for(int i=0 ; i<(((List) DrugProfileBookmark.getCollection(key)).size()) ; i++){
								//System.out.println("Json Obejct"+((List) DrugProfileBookmark.getCollection(key)).get(i));
								//List<String> jsonStr=((List) Unattented.getCollection(key1)).get(i);
								drugProfileJsonObj =  (JSONObject)(((List) DrugProfileBookmark.getCollection(key)).get(i));
								//System.out.println("DRUGNAME ==="+drugProfileJsonObj.get("DRUGNAME"));
								String DRUGNAME=(String)drugProfileJsonObj.get("DRUGNAME");
								
								%>
								<tr id="rowId"> <td><input type="checkbox" class="checkedInput" checked="checked" name="drugsAdvicesBook" value="<%=drugProfileJsonObj.get("HIDDEN_VAL") %>" ></td><td><%=DRUGNAME %></td><td><%=drugProfileJsonObj.get("DOSENAME") %></td><td><%=drugProfileJsonObj.get("FREQUENCY_NAME") %></td><td><%=drugProfileJsonObj.get("CURR_DATE") %></td><td><%=drugProfileJsonObj.get("DAYS") %></td><td><%=drugProfileJsonObj.get("TOTAL_QTY") %></td><td><a class="drugAdvicesInstructionsModalBtn" style="color: #109f1c" druginstructions="Remaeks" onclick="$('#drugAdvicesInstructionsModal').modal('show');"><%=drugProfileJsonObj.get("REMARKS") %></a></td><td><button class="btn btn-xs drugEditBtn" type="button"><i class="fa fa-edit"></i></button></td></tr></tbody>
                             <%
						}
                             %>
                            
                           </table>
                           
					            </div> 
					          </div>  
					          <br> 
					          <div class="row text-center">
					            <button class="btn btn-primary savePrintPrescBtn drugBookmarkAddBtn" type="button">Add</button>  
					          </div>
					        </div>  
					      </div> 
					    </div>
					  </div> 
                   	  
                   	  <%		
                   	}
                   	}
                     
                     %>
  
  
  
  
  <% 
  	HashMap<String ,String> BookmarkTestMAP = (HashMap) request.getSession().getAttribute("BookmarkDTL");
    //System.out.print("MacrosDTL"+MacrosMap);	
	ArrayList<String> listBookMarkTestList=null;
	int j=0;
	 	if(BookmarkTestMAP!=null)
	 	{
			for(Map.Entry m:BookmarkTestMAP.entrySet()){ 
				listBookMarkTestList=new  ArrayList<String>();
				listBookMarkTestList=(ArrayList) m.getValue();
	//			System.out.println("::::"+m.getValue());
	
				%>
				  <div class="modal fade" id="investigationTestBundle<%=j %>" role="dialog">
				    <div class="modal-dialog">       <!-- Modal content-->
				      <div class="modal-content">
				        <div class="modal-header">
				          <button type="button" class="close" data-dismiss="modal">&times;</button>
				          
				        	<% if(listBookMarkTestList.get(6).equals("1")){
							%>
								<h2 class="modal-title">Group Test Detail</h2>
							<%}else{%>
								<h2 class="modal-title">Bookmark Test Detail</h2>
							<%}%>
				         
				        </div>
				        <div class="modal-body" style="text-align: left;">
				          <div class="row">
				            <div class="col-sm-8 col-sm-offset-2">
				            
				             	<%if(listBookMarkTestList.get(6).equals("1")){
									%>
				              			<p><input type="checkbox" name="bookmarkAllCheck" value="1" onchange="checkAllBookmarkItem(this)" checked> GROUP NAME : <font class="bookmarkTestName"> <%=listBookMarkTestList.get(5) %></font></p>
								<%}else{%>
				              			<p><input type="checkbox" name="bookmarkAllCheck" value="1" onchange="checkAllBookmarkItem(this)" checked> BOOKMARK NAME : <font class="bookmarkTestName"> <%=listBookMarkTestList.get(5) %></font></p>	
				              	<%}
				              		//System.out.println("listBookMarkTestList"+listBookMarkTestList.size());
				                   listBookMarkTestList.size();
				                   
				                   for(int l=0 ; l <listBookMarkTestList.size() ; l=l+8){
				                	   String TestCodeVal=listBookMarkTestList.get(l+2);
				              %>
				              
				              <p style="font-size:0.95em"><label><input type="checkbox" name="bookmarkSubTest" value="<%=TestCodeVal %>" checked> <%=listBookMarkTestList.get(l+4) %></label></p>
				            <% 
				             } %>
				            </div> 
				          </div>  
				          <br> 
				          <div class="row text-center">
				            <button class="btn btn-primary savePrintPrescBtn investigationBookmarkAddBtn" type="button">Add</button>  
				          </div>
				        </div>  
				      </div> 
				    </div>
				  </div> 
		<%	
		 j++;
			}
	 	} 
  %> 
  
  <!-- Modal -->
  

  <%
	MultiValueMap MacrosDTL= (MultiValueMap) request.getSession().getAttribute("MacrosDTL");
 	//System.out.println("DeptCMB"+RoomWise);
 	if(MacrosDTL!=null)
 	{
 		Set<String> keys = MacrosDTL.keySet();
 	for(String key : keys){ 
 		//System.out.println("MAcros Keys"+key);
 		//System.out.println("MAcros Keys Dtl"+MacrosDTL.get(key));
 		//System.out.println("MAcros Keys Dtl"+((List) MacrosDTL.getCollection(key)).size());
 		
 		
 		JSONObject patJsonObj =null;
 		
 		%>

  
  <div class="modal fade" id="progressNoteMacroModal<%=key %>" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Macros</h2>
        </div>
        <div class="modal-body" style="text-align: left;">
          <div class="row">
            <div class="col-sm-8 col-sm-offset-2"> 
          <%
          
          for(int i=0 ; i<(((List) MacrosDTL.getCollection(key)).size()) ; i++){
				//System.out.println("MaceosDTL::::::::::"+((List) MacrosDTL.getCollection(key)).get(i));
				//List<String> jsonStr=((List) Unattented.getCollection(key1)).get(i);
				patJsonObj =  (JSONObject)(((List) MacrosDTL.getCollection(key)).get(i));
				
          %>
				<p><label><input type="radio" name="macroNoteVal" value="<%=patJsonObj.get("HGSTR_MACRO_DESC")%>" > <%=patJsonObj.get("HGSTR_MACRO_HEADER")%></label></p>			   
              <!-- <p><label><input type="radio" name="macroNoteVal" value="Patient has to do oral rinse with warm water twice a day.Take pain killer inn case of major pain.In case of fever more then 101 visit hospital."> Marco 1</label></p> -->
              <!-- <p><label><input type="radio" name="macroNoteVal" value="Bedrest for 7 days, high liquid diet, Cold water soak."> Macro 2</label></p> --> 
           
           
           <%
           }
          %>
           
            </div> 
          </div>  
          <br> 
          <div class="row text-center">
            <button class="btn btn-primary savePrintPrescBtn addMacroToProgressNoteBtn" type="button">Add</button>  
          </div>
        </div>  
      </div> 
    </div>
    <input type="hidden" name="macrisHidden" id="macrisHiddenId" value="">
     <input type="hidden" name="macrisHidden" id="macrisHiddenIdval" value="">
  </div> 
  
 					 <%
 	}
                     }
                     %>
  
    <!-- Modal -->
  <div class="modal fade" id="printPrescriptionModal" role="dialog">
    <div id="printPrescriptionModalId12" class='modal-dialog modal-xl'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <!-- <button type="button" class="close" data-dismiss="modal" >&times;</button>  -->
          <button type="button" class="close" data-dismiss="modal" onclick="$('#printPrescriptionModal').modal('hide');$('#printPrescFrameId').remove();">&times;</button>   <!-- onclick added by ashutoshk for checking duplicacy of print prescription.-->
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#printPrescriptionModal').modal('hide');$('#printPrescFrameId').remove();">Cancel</button>
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div>  
  
  
  
  
  
  
  <!-- Open Template -->
   <div class="modal fade" id="OpenTemplateModal" role="dialog">
    <div id="OpenTemplateModal12" class='modal-dialog modal-xl' style="min-width:98vw" >      
      <div class="modal-content">
        <div class="modal-header cent-any"> 
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
          <input type="text" class="form-control temp-search" >
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpenTemplateModal').modal('hide');$('#OpenTemplateModalFrameId').remove();">Cancel</button>
				
			 </div> 
        </div>  
      </div> 
    </div>
  </div>  
  
  
   <!-- Open e-Consultancy -->
   <div class="modal fade" id="OpeneConsultancyModal" role="dialog">
    <div id="OpeneConsultancyModal12" class='modal-dialog modal-lg'>       Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpeneConsultancyModal').modal('hide');$('#OpeneConsultancyModalFrameId').remove();">Cancel</button>
				<!-- x -->
				<!-- <button type="button" class="btn btn-info opdTemplatePres" onclick="saveHtmlData()">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div>  
  
    <div class="modal fade" id="printComplaintModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Print Complaints</h4>
        </div>
        <div class="modal-body" id="printComplaintModalDivId">
          <!-- <p>Some text in the modal.</p> -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  <div class="modal fade" id="printHistoryModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Print History</h4>
        </div>
        <div class="modal-body" id="printHistoryModalDivId">
          <!-- <p>Some text in the modal.</p> -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  <div class="modal fade" id="printExaminationModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Print Examination</h4>
        </div>
        <div class="modal-body" id="printExaminationModalDivId">
          <!-- <p>Some text in the modal.</p> -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  <div class="modal fade" id="printQuestionareModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Print Questionnaire</h4>
        </div>
        <div class="modal-body" id="printQuestionareModalDivId">
          <!-- <p>Some text in the modal.</p> -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
  
  
  <div class="modal fade" id="OpenComplaintsTemplateModal" role="dialog">
    <div id="OpenComplaintsTemplateModal12" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">Complaint
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpenComplaintsTemplateModal').modal('hide');$('#OpenComplaintsTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  
  
  
  <div class="modal fade" id="AdmissionAdviceTemplateModal" role="dialog">
    <div id="OpenComplaintsTemplateModal12" style="width: 90%" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#AdmissionAdviceTemplateModal').modal('hide');$('#AdmissionAdviceTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  <div id="sickModal" class="modal fade "  role="dialog" >
	  <div class="modal-dialog modal-lg" style="width:90vw;">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
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
	
	
	<div id="triageModal" class="modal fade "  role="dialog" >
	  <div class="modal-dialog modal-lg" style="width:90vw;">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">Triage</h4>
	      </div>
	      <div class="modal-body">
	     
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
	
	<div id="emrModal" class="modal fade "  role="dialog" >
	  <div class="modal-dialog modal-lg" style="width:90vw;">
	
	    <!-- Modal content-->
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	        <h4 class="modal-title">EMR</h4>
	      </div>
	      <div class="modal-body">
	     
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	
	  </div>
	</div>
  
  
  <div class="modal fade" id="InvestigationTemplateModal" role="dialog">
    <div id="OpenComplaintsTemplateModal12" style="width: 90%" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">Investigation Requisition Raising
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#InvestigationTemplateModal').modal('hide');$('#InvestigationTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div>
  
   <div class="modal fade" id="OpenFileUploadModal" role="dialog">
    <div id="OpenFileUploadModal12"  class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">
        <h3 style="color:currentColor;float:left">File Upload</h3>
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" style="display: none" class="btn btn-warning" onclick="$('#OpenFileUploadModal').modal('hide');$('#OpenFileUploadModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  
  
  <div class="modal fade" id="OpenHistoryTemplateModal" role="dialog">
    <div id="OpenHistoryTemplateModal12" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">History
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpenHistoryTemplateModal').modal('hide');$('#OpenHistoryTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  
  
  <div class="modal fade" id="OpenQuestionnaireTemplateModal" role="dialog">
    <div id="OpenQuestionnaireTemplateModal12" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">Questionnaire
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpenQuestionnaireTemplateModal').modal('hide');$('#OpenQuestionnaireTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  
  
  <div class="modal fade" id="OpenExaminationTemplateModal" role="dialog">
    <div id="OpenExaminationTemplateModal12" class='modal-dialog modal-lg'>       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header" style="text-align: center;font-size: 25px;">Examination
          <button type="button" class="close" data-dismiss="modal">&times;</button> 
        </div>
        <div class="modal-body">
       		 <div class="text-center">
       			<button type="button" class="btn btn-warning" onclick="$('#OpenExaminationTemplateModal').modal('hide');$('#OpenExaminationTemplateModalFrameId').remove();">Cancel</button>
				
				<!-- <button type="button" class="btn btn-info printPrescSAveBtn" onclick="">Save</button> -->
			 </div> 
        </div>  
      </div> 
    </div>
  </div> 
  
  
    <!-- Modal -->
  <div class="modal fade" id="drugAdvicesInstructionsModal" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Drug Advice Instructions</h2>
        </div>
        <div class="modal-body" style="text-align: left;">
           <p class="text-center">
             Instructions of doctor will append here.
           </p>
        </div>  
      </div> 
    </div>
  </div> 
  
  
  <!-- <div class="modal fade" id="drugAdvicesInstructionsModal1" role="dialog">
    <div class="modal-dialog">       Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Drug Advice Instructions</h2>
        </div>
        <div class="modal-body" style="text-align: left;">
          <textarea class="form-control" onblur="countChar(this,'charNumDrgRmk');" id="strDrugsRemarksId" name="strDrugsRemarks" maxlength="500" onkeyup="countChar(this,'charNumDrgRmk');"></textarea>
        			<p align="right">
						<label>characters remaining: <span id="charNumDrgRmk" title="500">500</span></label>
					</p>
        
        </div>
       <div align="center"> <input type="button" class="btn btn-primary btn-sm" onclick="getDrugAdvice()" value="Submit"></div><br></br>  
      </div> 
    </div>
  </div>  -->
  
  
  
    <div class="modal fade" id="drugAdvicesInstructionsModal2" role="dialog">
    <div class="modal-dialog">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Drug Advice Instructions</h2>
        </div>
        <div class="modal-body" style="text-align: left;">
          <textarea class="form-control" onblur="countChar(this,'charNumExtDrugRmk');" id="strDrugsRemarksId1" name="strDrugsRemarks1" maxlength="500" onkeyup="countChar(this,'charNumExtDrugRmk');"></textarea>
          <p align="right">
			 <label>characters remaining: <span id="charNumExtDrugRmk" title="500">500</span></label>
		</p>
        
        </div>
       <div align="center"> <input type="button" class="btn btn-primary btn-sm" onclick="getDrugAdvice1()" value="Submit"></div><br></br>  
      </div> 
    </div>
  </div> 
  
    <!-- Modal -->
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
								<!-- <h4 class="text-left">VIEW & DOWNLOAD LAB REPORTS</h4> -->
								<ul class="patInvestigationTestList" >
								</ul>
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
   
   
   <div class="modal fade" id="patImageModal" role="dialog" >
    <div class="modal-dialog  modal-sm">       <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title text-left">Patient Image</h2>
        </div>
        <div class="modal-body" style="text-align: left;"> 
			 <div class="row" style="min-height:300px;">
			    <div  class="col-sm-12">
			       <img id="viewPatientImage" style="height: 21em;vertical-align: text-bottom;padding-right: 10px;">
			        <!-- <div class="col-xs-5 col-sm-2 col-md-3"> 
			            <ul class="nav nav-tabs tabs-left investigationModalNavMenu">
			                <li class="active"><a href="#home12" data-toggle="tab">My Reports</a></li> 
			            </ul>
			        </div>
			        <div class="col-xs-7 col-sm-10 col-md-9">
			            Tab panes
			            <div class="tab-content investigationModalNavMenuContent">
			                <div class="tab-pane active" id="home12">
								<h4 class="text-left">VIEW & DOWNLOAD LAB REPORTS</h4>
								<ul class="patInvestigationTestList" >
								</ul>
			                </div> 
			            </div>
			        </div> -->
			        <div class="clearfix"></div>
			    </div>  
			</div> 
           <!-- <object id="investigationLabReportPdf1" data="data:application/pdf;base64," type="application/pdf" style="width:100%;height:500px;"></object> -->
        </div>  
      </div> 
    </div>
  </div>
   
   
  <button id="patPrescViewModalTriggerBtn" type="button" style="display:none" data-toggle="modal" data-target="#patPrescViewModal"></button>
  <!-- Modal -->
<!--   <div class="modal fade" id="patPrescViewModal" role="dialog" aria-labelledby="modalLabel">
    <div class="modal-dialog" role="document">       Modal content
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h2 class="modal-title">Patient Prescription View</h2>
        </div>
        <div class="modal-body" style="text-align: left; height:80vh">
           <img src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" style="width: 90%; margin: 0 5%" />
            <div id="galley">
              <ul class="pictures">
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li> 
              </ul>
            </div>
           
        </div>  
      </div> 
    </div>
  </div> -->
  
    <!--  <div class="modal fade" id="patPrescViewModal" role="dialog" aria-labelledby="modalLabel" tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="modalLabel">Patient Prescription View</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body" style=" height:80vh">
            <div id="galley">
              <ul class="pictures">
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
                <li><img data-original="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" src="/HISDRDESK_MC/new_opd/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
              </ul>
            </div>
          </div> 
        </div>
      </div>
    </div>  --> 
    
    <div class="modal fade" id="patPrescViewModal" role="dialog" aria-labelledby="modalLabel" tabindex="-1">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="modalLabel">Patient Prescription View</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body" style=" height:80vh">
            <div id="galley">
              <ul class="pictures">
                <li><img data-original="/HIS/hisglobal/drDeskAssets/img/pat_presc.jpg" src="/HIS/hisglobal/drDeskAssets/img/pat_presc.jpg" alt="Cuo Na Lake"></li>
              </ul>
            </div>
          </div> 
        </div>
      </div>
    </div> 
   
    <!-- Prescription Code Starts here -->
    <div id='patient_profile' class='patient_profile' >
    	<div class='row'>
    		<div class='col-sm-1' style="background: #fff;padding: 2px;border: 1px solid #000;border-radius: 10px;margin-left:10px;height:94px;width:94px">
    		<img style="width:100%;height: 100%;" id='imgProfilePic'  src="/HISDRDESK_MC/new_opd/img/patIcon.png"></div>
    		<div class='col-sm-10' style="margin-top: -20px;">
    			<div class='row'>
    				<div class='col-sm-4' ><h2 style="padding: 0px;color: #fff;text-align: left !important;"><font id="patNamePrescriptionPanel" > </font></h2></div>
    				<div class='col-sm-4' >
    				<h2 style="padding: 0px;color: #fff;text-align: left !important;">Ben ID: -
    				<font id="patCrNoPrescriptionPanel" ></font></h2>
    				<font id="patEpisodeCodePrescriptionPanel" style="display: none"></font>
		        	<font id="patHospitalCodePrescriptionPanel" style="display: none"><%=objHospitalMstVO.getHospitalCode() %></font>
		        	<font id="patSeatIdPrescriptionPanel" style="display: none"><%=(String)request.getSession().getAttribute("SEATID") %></font>
		        	<font id="patOthersDetailsPrescriptionPanel" style="display: none"></font> 
		        	<font id="patAdd" style="display: none"></font>
		        	<font id="timeOfVisit" style="display: none"></font>
		        	<font id="patdesignationPrescriptionPanel" style="display: none"></font>
		        	<font id="patStationPrescriptionPanel" style="display: none"></font>
		        	<font style="vertical-align: super;display: none" id="patUmidPrescriptionPanelId" > <b>UMID :</b></font>
        			<font id="patUmidPrescriptionPanel" style="vertical-align: super;display: none;"></font>
        			<font id="patGaurdianNamePrescriptionPanel" style="display:none"></font>
        			<font id="patConsultantNamePrescriptionPanel" style="display:none"></font>
        	
    				</div>  
    				<div class='col-sm-4 patienttiledata' style="margin-top: 22px;" >
    					Patient Priority :-<font id="patPatientConditon">Normal</font>
    				</div>    				  				
    			</div>
    			<div class='row'>
    				<div class='col-sm-4' >
    					<font id="patGenAgeCatPrescriptionPanel" class='patienttiledata'></font>
    				</div>
    				<div class='col-sm-4 patienttiledata' >
    					Card Type :-<font id="cardType" ></font>    					
    				</div> 
    				<div class='col-sm-4 patienttiledata' >
    					Card Expiry Date :-<font id="cardValidityDate" ></font>    					
    				</div> 
    				   				
      			</div>
    			<div class='row'>
    				<div class='col-sm-4 patienttiledata' >
    					Relation :- <font id="relation" ></font>
    				</div>
    				<div class='col-sm-8 patienttiledata' >
    					Parent wellness center:- <font id="divParentWellnessCenter" ></font>
    				</div>
    				
    			</div> 
    			<div class='row'>
    				<div class='col-sm-4 patienttiledata' >
    					Primary diagnosis(Chronic) :- <font id="chronicDiagnosistile" ></font>
    				</div>
    				<div class='col-sm-4 patienttiledata' >
    					H/o allergy :- <font id="alergytile" ></font>
    				</div>
    				<div class='col-sm-4 patienttiledata' >
    					Last visit date :- <font id="lastVisitDateTile" ></font>
    				</div>
    			</div>	   			
    		</div>
    	</div>
   	</div> 
   	<div class='row'>
    		<div class='col-sm-12' style="text-align: center;margin-top: 10px;margin-bottom: 10px;">
    			<h2 class='heading' >Rx Prescription 
        			<b style="font-weight: normal;font-size: 16px;font-family: courier;">[</b>
        			<b id="patDeptName" style="font-weight: normal;font-size: 16px;"></b>
        			<b style="font-weight: normal;font-size: 16px;font-family: courier;">]</b>        	
 				</h2>
    		
    		</div>
    </div>		
        
        <div class="tab-content tab-rx">
          <div id="home" class="tab-pane fade in active">
            <div class="container-fluid prescriptionContainer" style="padding-left: 10px;padding-right: 10px;">
              <div class="row">
                <!-- <div class="col-xs-0 col-sm-0 col-md-1"></div> -->
                <div id="prescriptionTileContainer" class="col-sm-12 col-md-12" style="padding-left: 0px;padding-right: 10px;">
                 <p id="prescriptionPanelPatStatus" style="font-size: 22px; color: rgb(27, 191, 35);"></p>
                 <p id="patPensionerFMA" style="font-size: 15px; color: rgb(255, 0, 0);"></p>
                 
                 
                 
                 <div class="container-fluid" >
                 	   
                     <div class="row"> 
                      <div class="col-sm-7 col-md-7" style="margin-top:5px;">
                      	<a type="button" class="btn-his-outline"  onclick="showProcessPopUps('pastRx')">Past RX</a> &nbsp;
      					<a type="button" class="btn-his-outline"  onclick="showProcessPopUps('vital')">Add/Modify Vitals</a> &nbsp;
      					<a type="button" class="btn-his-outline"  onclick="showProcessPopUps('opdEMR')">EMR</a>
      					<a type="button" class="btn-his-outline"  onclick="openPatientReviewPage()">Add/View Patient Review</a>
      					
      					<!-- <select id="chkmenu2"  class="btn-his-outline" data-max-options="1">
					    	<option value="" selected="selected" ></option>
			           		<option value="admissionAdvice" >Admission Advice</option>
			                <option value="sickFit" >Sick & Fit</option>
			                <option value="complaintTemplate" >Complaint Template</option>
			                <option value="examinationTemplate" >Examination Template</option>
			                <option value="historyTemplate" >History Template</option>
			                <option value="otherTemplates" >Other Templates</option>
					    </select> -->
      					</div>	   
                      <div class="col-sm-5 col-md-5" style="margin-top:5px;">
                        <div class="col-sm-10 col-md-10">                          
                        	<input type='text'placeholder='Search Bookmark and Refill Rx' class="form-control flexdatalist flexdatalist-set" autocomplete="off" tabindex="-1" data-min-length='1' list='languages' 	name='SearchPara' id="SearchParaIs"    >
      					</div>
				      					 <div style="display:none" id="prescriptionBookMarkJsonDiv"></div>
				         <%  JSONArray PrescriptionBookMarkJsonArray1 = (JSONArray) request.getSession().getAttribute("PrescriptionBookMarkJsonArray");
				         if(PrescriptionBookMarkJsonArray1 !=null){
				         %>           
        			 <script> 
                      $(document).ready(function(){
                          <%  JSONArray PrescriptionBookMarkJsonArray = (JSONArray) request.getSession().getAttribute("PrescriptionBookMarkJsonArray");
                          
                          //System.out.println("PrescriptionBookMarkJsonArray"+PrescriptionBookMarkJsonArray);
                          %> 
                          try{ 
                            var tempJSON 
                            = <%=PrescriptionBookMarkJsonArray.toString() %>;
						    //var testJsonObj = tempJSON; 
						    //console.log(tempJSON);   
						    
						    if($("#prescriptionBookMarkJsonDiv").text().trim().length<=0)
					    	{
					    		$("#prescriptionBookMarkJsonDiv").text(JSON.stringify(tempJSON).toString());
					    	}
					    	else if(JSON.stringify(tempJSON).toString() != $("#prescriptionBookMarkJsonDiv").text().trim().toString()){
					    		$("#prescriptionBookMarkJsonDiv").text(JSON.stringify(tempJSON).toString());
					    	}
					    	
							/*if(!localStorage.getItem('PrescriptionBookMarkJsonArrayObj'))
								localStorage.setItem('PrescriptionBookMarkJsonArrayObj',JSON.stringify(tempJSON).toString()); 
							else if(JSON.stringify(tempJSON).toString() != localStorage.getItem('PrescriptionBookMarkJsonArrayObj').toString() )
								{
									console.log('localStorage else');
									localStorage.setItem('PrescriptionBookMarkJsonArrayObj',JSON.stringify(tempJSON));  
								} */
							$('input[name=SearchPara]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     searchByWord: true,
							     maxShownResults: 50,
							     searchIn: 'SERACH_DATA', 
							     data: tempJSON
							 });  
                              }
                          catch(err){
                              console.log('err.message:>>>'+err.message);
                              }
                         }); 
                      </script>
      			 <%} %>
       			<div class="col-md-2 col-sm-2">
                          <div class="dropdown AddToggleClass" style="float:left;margin-left: 31px;">                                                                                  
                            <ul class="dropdown-menu prescViewVisitLst" role="menu" aria-labelledby="prescViewVisiBtnId">
                             <!--  <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Presc1</a></li>    -->
                            </ul>
                            <button type="button"  class="btn-his rxprofilebtn" data-toggle="tooltip" title="Manage Bookmark"   data-toggle="modal" ><i class="glyphicon glyphicon-bookmark"></i></button>
                          </div>    
                          
                          </div>
                          <script>
                          $(document).ready(function(){
                              $(".dropdown-toggle").dropdown();
                             
                          });
                          </script>
                          <br><br>
                        <!-- <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p> -->
                        
                    </div>
                    <div class="col-sm-1 col-md-1" style="margin-top:5px; display: none;">
                       	<select class="form-control checkLastThreeVisitAdded" name="checkLastThreeVisitDiv" id="checkLastThreeVisitDivId"> </select>
                         <div class="lastVisitDiv" style="display: none">
                         	<ol class="lastVisitOl"></ol>
                         </div>
      				</div>
      				
      				
                </div>
                 
               </div>
                 <div id="bookmarkmodal" class="modal fade" role="dialog" style="z-index:9999">
				  <div class="modal-dialog modal-lg">
				
				    <!-- Modal content-->
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
				        <h4 class="modal-title">Do you want to bookmark this Rx profile ?</h4>
				      </div>
				      <div class="modal-body">
				     
				       <div class="col-md-12">
				      <!--  <label>Enter Book Mark Name</label> -->
				       <input type="text" class="form-control" maxlength="1000" id="PresCriptionBookmarkNameId" placeholder="Enter BookMark Name" name="bookmarkName">
				     	<br> 
				       <textarea class="form-control" name="PresCriptionBookmarkDesc" placeholder="Enter Bookmark Description" id="PresCriptionBookmarkDescId" ></textarea>
				       <br>
				       <!-- <input type="checkbox" style="display: none;" name="deptonly" id="deptonlyid" value="1"><label style="display: none;">Restricted Access</label>
				       <input type="checkbox" style="" name="AllDept" id="ALlDeptId" value="1">Accessible to Other Within Department
				      -->
				     
				    			<input type="checkbox" id="ALlDeptId" class=" " name="AllDept" value="1"  checked="checked"/> <label> Accessible Within Department </label>
				               <!--  <input type="checkbox" id="ALlDeptId" class=" checkboxcls" name="AllDept" value="2" /> <label> Department Access </label>
				                <input type="checkbox" id="ALlDeptId" class=" checkboxcls" name="AllDept" value="3" /><label> All  </label>
				                 -->
				     
				       </div>
				       <br>
				        <div class="row">
				       
				       </div>
				      </div>
				      <div class="modal-footer">
				        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="">Close</button> 
				       <!--  <button type="button" class="btn btn-primary" onclick="Save('printSave',this , 0)">Skip</button> -->
				        <button type="button" class="btn btn-success" onclick="SaveRxProfileData('printSave',this , 1)">Save bookmark & Preview Rx</button>
				      </div>
				    </div>
				
				  </div>
			</div>


 			

 <div id="PresCriptionModal" class="modal fade" role="dialog" style="z-index:9999">

  <div class="modal-dialog  modal-md">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Manage Your Bookmarks</h4>
         <h4 class="modal-title" align="right"><a class="modal-title" href="#" onclick="refreshListPage()" >Refresh</a></h4>
        
      </div>
      <div class="modal-body">
      
       <table class="table table-bordered" id="example12">
          <thead>
            <tr>
              <th style="background-color:#ddd;color:black">#</th>
              <th style="background-color:#ddd;color:black">Name </th>
              <th style="background-color:#ddd;color:black">Description</th>
              <th style="background-color:#ddd;color:black">Created By </th>
              <th style="background-color:#ddd;color:black">Action </th>
            </tr>
          </thead>
          <tbody>
          
          <%
           /*  if(false){   */
       ArrayList<JSONObject> strPrescriptionProfileJSON = (ArrayList<JSONObject>) request.getSession().getAttribute("PrescriptionBookMark");
     	//System.out.println("strPrescriptionProfileJSON:::  "+strPrescriptionProfileJSON.toString());
       if(strPrescriptionProfileJSON !=null){
     		if(strPrescriptionProfileJSON.size() > 0){
     			for(int ii=0 ; ii< strPrescriptionProfileJSON.size();ii++){
     	//			JSONObject js=new JSONObject(strPrescriptionProfileJSON.get(i));
     				//JSONObject js1=new JSONObject(js.get("HJOSN_RX_COMPLETE"));
     				StringBuffer sb =new StringBuffer();
				//System.out.println("");     				

     				sb.append("<lable style=' font-weight: bold; color:#3ba4e3;'> Chief Complaint: ");
     				sb.append("</lable>");
     				
     				org.json.simple.JSONArray ReasonOfVisitJsonArray= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("ReasonOfVisitJsonArray");
     				for(int ReasonOfVisitJsonArrayvar=0 ; ReasonOfVisitJsonArrayvar < ReasonOfVisitJsonArray.size(); ReasonOfVisitJsonArrayvar++ ){
     					if(new JSONObject( ReasonOfVisitJsonArray.get(ReasonOfVisitJsonArrayvar).toString()).has("VisitReasonName"))
     					sb.append(new JSONObject( ReasonOfVisitJsonArray.get(ReasonOfVisitJsonArrayvar).toString()).getString("VisitReasonName"));
						sb.append(", ");
     					//System.out.println("ReasonOfVisitJsonArray"+new JSONObject( ReasonOfVisitJsonArray.get(ReasonOfVisitJsonArrayvar).toString()).getString("VisitReasonName"));
     				}
     				sb.append("<br>");
     				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Diagnosis: ");
     				sb.append("</lable>");
     				org.json.simple.JSONArray DiagnosisJsonArray= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("DiagnosisJsonArray");
     				for(int DiagnosisJsonArrayvar=0 ; DiagnosisJsonArrayvar < DiagnosisJsonArray.size(); DiagnosisJsonArrayvar++ ){
     					sb.append(new JSONObject( DiagnosisJsonArray.get(DiagnosisJsonArrayvar).toString()).getString("DiagnosisName"));
						sb.append(", ");
     					//System.out.println("DiagnosisJsonArray"+new JSONObject( DiagnosisJsonArray.get(DiagnosisJsonArrayvar).toString()).getString("DiagnosisName"));
     				}
     				sb.append("<br>");
     				org.json.simple.JSONArray invartiagtionJsonArray= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("InvestigationJsonArray");
     				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Investigations: ");
     				sb.append("</lable>");
 					for(int investigationJsonArray=0 ; investigationJsonArray < invartiagtionJsonArray.size(); investigationJsonArray++ ){
     					//System.out.println("investigationJsonArray"+new JSONObject( invartiagtionJsonArray.get(investigationJsonArray).toString()).getString("TestName"));
     				sb.append(new JSONObject( invartiagtionJsonArray.get(investigationJsonArray).toString()).getString("TestName") +"  ");
					sb.append(", ");
 					}
 					sb.append("<br>");
 					sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Drugs: ");
     				sb.append("</lable>");
 					org.json.simple.JSONArray DrugJsonArray= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("DrugJsonArray");
     				for(int DrugJsonArrayvar=0 ; DrugJsonArrayvar < DrugJsonArray.size(); DrugJsonArrayvar++ ){
     					//System.out.println("DrugJsonArray.get(DrugJsonArrayvar).toString()>>"+DrugJsonArray.get(DrugJsonArrayvar).toString());
     					sb.append(new JSONObject( DrugJsonArray.get(DrugJsonArrayvar).toString()).getString("drugName"));
						sb.append(", ");
     					//System.out.println("DrugJsonArray"+new JSONObject( DrugJsonArray.get(DrugJsonArrayvar).toString()).getString("DrugName"));
     				}
     				sb.append("<br>");
     				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Clinical Procedure: ");
     				sb.append("</lable>");
 					org.json.simple.JSONArray ClinicalProcedureJsonArray= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("ClinicalProcedureJsonArray");
     				for(int ClinicalProcedureJsonArrayvar=0 ; ClinicalProcedureJsonArrayvar < ClinicalProcedureJsonArray.size(); ClinicalProcedureJsonArrayvar++ ){
     					sb.append(new JSONObject( ClinicalProcedureJsonArray.get(ClinicalProcedureJsonArrayvar).toString()).getString("ProceduresName"));
						sb.append(", ");
     					//System.out.println("ProceduresName"+new JSONObject( DrugJsonArray.get(ClinicalProcedureJsonArrayvar).toString()).getString("ProceduresName"));
     				}
     				sb.append("<br>");
     				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Investigation Notes: ");
     				sb.append("</lable>");
     				if(((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("InvestgationNote") !=null){
     					sb.append(((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("InvestgationNote"));
     				}
					sb.append("<br>");
     				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Treatment Advice Note: ");
     				sb.append("</lable>");
     				if(((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("strtreatmentAdvice") !=null){
     					sb.append(((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("strtreatmentAdvice"));
     				}
     					// System.out.println("1234567890::::::: \n"+((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("FOLLOW_UP"));
     					JSONArray js=new JSONArray(((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("FOLLOW_UP").toString());
     					//System.out.println("1234567891:::::::"+((JSONObject)js.get(0)).getString("progressNote"));
     				
     					sb.append("<br>");
         				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Progress Note: ");
         				sb.append("</lable>");
         				if(((JSONObject)js.get(0)).getString("progressNote") !=null){
         					sb.append(((JSONObject)js.get(0)).getString("progressNote"));
         				}
     						
         				sb.append("<br>");
         				sb.append("<br><lable style=' font-weight: bold; color:#3ba4e3;'> Referal: ");
         				sb.append("</lable>");
         				org.json.simple.JSONArray DrugJsonArray1= (org.json.simple.JSONArray)((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("PatientRefrel");
         				for(int DrugJsonArrayvar=0 ; DrugJsonArrayvar < DrugJsonArray1.size(); DrugJsonArrayvar++ ){
         					if(new JSONObject( DrugJsonArray1.get(DrugJsonArrayvar).toString()).has("strShowData"))
         					sb.append(new JSONObject( DrugJsonArray1.get(DrugJsonArrayvar).toString()).getString("strShowData"));
    						sb.append(", ");
         					//System.out.println("DrugJsonArray"+new JSONObject( DrugJsonArray.get(DrugJsonArrayvar).toString()).getString("DrugName"));
         				}
         				
     				
     				  %>
            <tr>
              <td><img alt="" src="../../hisglobal/images/details_close.png" style="display: none;" class="dtHide">
				  <img src="../../hisglobal/images/details_open.png" class="dtShow" />
             <!--  <button type="button" class="dtHide" ><i class="fas fa-minus"></i></button> -->
              </td>
             
              <td><%= ((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("strPresCriptionBookmarkNameval")  %></td>
              <td><%= ((JSONObject)((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HJOSN_RX_COMPLETE")).get("strPresCriptionBookmarkDescVal")  %></td>
              <td><%= (String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("USER_NAME"))  %></td>
             
             <%
     				String PREOFILE_ACCESS =(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("PREOFILE_ACCESS"));
     				String action =(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("GNUM_ISVALID"));
     				if(PREOFILE_ACCESS.equalsIgnoreCase("1")){
     				if(action.equalsIgnoreCase("Active")){
     					%>
     					
              <td>
			  			<input type="radio" name="strPrescriptionAction" onclick="ActionRequiredForProfilePrescription(<%=(((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID"))%> , 3)" value=<%=(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID")) %> > Delete 
     					<input type="radio" name="strPrescriptionAction" onclick="ActionRequiredForProfilePrescription(<%=(((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID"))%> , 0)" value=<%=(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID")) %> > Disable
			  </td>
			  <%
     					} else{
     				%>
            <td>
            <input type="radio" name="strPrescriptionAction" onclick="ActionRequiredForProfilePrescription(<%=(((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID"))%> , 1)" value=<%=(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID")) %> >Active
     				<input type="radio" name="strPrescriptionAction" onclick="ActionRequiredForProfilePrescription(<%=(((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID"))%> , 3)" value=<%=(String) (((JSONObject)strPrescriptionProfileJSON.get(ii)).get("HRGNUM_PROFILE_ID")) %> >Delete
            
            </td>
            
            
     				<%
     				}
     			} else {	
     				%> 
     				<td>
     				</td>
     				<%} %>
     				
     				
            </tr>
			<tr  style="display:none" >
			<td style="display:none" >  <input type="button"></td>
			 <td style="display:none"  >  TEST</td>
			<td  style="display:none" >  DD</td>
			<td colspan="5"  >  <%=sb.toString() %></td>
			<td style="display:none">
			  			<input type="radio" >
     					<input type="radio">
			  </td>
			
			</tr>
            
            <% 
            sb.delete(0, sb.length());
     			}
     		}
     	}
      /*   }  */
            %>
                  </tbody>
        </table>
<script>
$(document).ready(function() {
    $('#example12').DataTable({

    		order: [[0, "asc"]],
    		   bSort: false
    }
    	    );

    $("#example12_length").hide();
    $("#example12_info").hide();
    $("#example12").on("click", ".dtShow", function(){
    	console.log('Data table click event show');
		$(this).parent().parent().next().css("display","");
		$(this).parent().find(".dtHide").css("display","");
		$(this).parent().find(".dtShow").css("display","none");
    	});
    
    
    $("#example12").on("click", ".dtHide", function(){
    	console.log('Data table click event show');
    	$(this).parent().parent().next().css("display","none");
		$(this).parent().find(".dtShow").css("display","");
		$(this).parent().find(".dtHide").css("display","none");
    	});
    
   /*  $(".dtShow").on("click",function(){
    	
        		console.log('Data table click event show');
        		$(this).parent().parent().next().css("display","");
        		$(this).parent().find(".dtHide").css("display","");
        		$(this).parent().find(".dtShow").css("display","none");
        		
        }); */

   /*  $(".dtHide").on("click",function(){
    	
		$(this).parent().parent().next().css("display","none");
		$(this).parent().find(".dtShow").css("display","");
		$(this).parent().find(".dtHide").css("display","none");
});  */
} );


$(document).ready(function() {
	
    
    var patVisitType = $('#patVisitTypePrescriptionPanel').text();
    //console.log('patVisitType -> '+ patVisitType);
    if(patVisitType != null && patVisitType.trim() == "Emergency Non MLC")
    	$("#triageBtn").css("display","");
    if(patVisitType != null && patVisitType.trim() == "Emergency MLC")
    	$("#triageBtn").css("display","");
    
} );

</script>     
      
      	<!-- <div><a href="0"> Malerila</a></div>
		<div><a href="0"> Malerila</a></div>
		<div><a href="0"> Malerila</a></div>
		<div><a href="0"> Malerila</a></div>
		<div><a href="0"> Malerila</a></div> -->
		      
      </div>
	  
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal" onclick="">Close</button>
      </div>
    </div>

  </div>
</div>
<!-- accordionOPDDesk Starts -->
<div class="accordion" id="accordionOPDDesk">
	
	<!--  Vital Details Starts -->
	<div class="card cardPrescription" id='vitalmainDiv' style="display: none;" >
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-12"><i class="fa fa-minus"></i> &nbsp; Vitals & General Examination</button>
        <div class="" id="collapse-12" aria-labelledby="heading-12" style="padding: 17px;">
                    <div class="row"> 
                        <div class="col-sm-10 col-md-11 prescriptionTileRowFirstCol ">
							<p class="vital weight col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="weightpId"><i class="glyphicon glyphicon-scale"></i> Weight :  <span id="weightIdValue"  data-toggle="tooltip" ></span></p> 
                            <p class="vital height col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel"  id="heightpId"><i class="fa fa-male"></i> Height : <span id="heightIdValue"  data-toggle="tooltip" ></span></p> 
                            <p class="vital bmi col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel"  id="bmipId"><i class="fa fa-weight"></i> BMI : <span id="bmiIdValue" data-toggle="tooltip" ></span><span class="bmiIdErrMsg" style="display:none;">(Low Weight)</span></p> 
                            <p class="vital temperature col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="temppid"><i class="fas fa-thermometer"></i> Temp : <span id="temperatureIdValue"  data-toggle="tooltip" ></span><span class="temperatureIdErrMsg" style="display:none;">(High)</span></p> 
                            <p class="vital respRate col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="rrpid"><i class="fa fa-stethoscope"></i> RR : <span id="respRateIdValue"  data-toggle="tooltip" ></span><span class="temperatureIdErrMsg" style="display:none;">(High)</span></p> 
                            <p class="vital col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="pulseratepid"><i class="fa fa-heartbeat" style="color:red"></i> Pulse Rate : <span id="pulserateIdValue"  data-toggle="tooltip" ></span></p>
                            <p class="vital bloodPressure col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="bppid"><i class="fa fa-x-ray"></i> BP : <span id="bloodPressureIdValue" data-toggle="tooltip" ></span><span class="bloodPressureIdErrMsg" style="display:none;"></span></p>
                            <p class="vital col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="alcoholConsumption"><i class="fa fa-glass-whiskey"></i> Alcohol Consumption : <span id="alcoholConsumptionvalue"  data-toggle="tooltip" ></span></p>
                            <p class="vital col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="Smokingid"><i class="fa fa-smoking"></i> Smoking : <span id="SmokingIdvalue"  data-toggle="tooltip" ></span></p>
                            <p class="vital col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" style='display:none;' id="Pregnancyid"><i class="fas fa-female"></i> Pregnancy : <span id="PregnancyIdvalue"  data-toggle="tooltip" ></span></p>
                            
                          <!--   <p class="haemoglobin col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="hgbpid"><i class="fa fa-file-medical-alt"></i> Hgb : <span id="haemoglobinIdValue"  data-toggle="tooltip" ></span></p> 
                            <p class="fasting col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="bsfastpid"><i class="fa fa-cubes"></i> B.S.Fast :<span id="fastingIdValue"  data-toggle="tooltip" ></span></p> 
                            <p class="ppRate col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="bspppid"><i class="fa fa-cubes"></i> B.S. PP : <span id="ppRateIdValue"  data-toggle="tooltip" ></span></p>
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="hba1cpid"><i class="fa fa-strikethrough"></i> HBA1C : <span id="hba1cIdValue"  data-toggle="tooltip" ></span></p>
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="bloodgrouppid"><i class="glyphicon glyphicon-tint"></i> Blood Group : <span id="bloodgroupIdValue"  data-toggle="tooltip" ></span></p>
                            ----------------------added for cancer screening---------------
                            <p class="cancerScreening col-sm-6 col-md-6 opdVitalsTile opdVitalsLabel" id="cancerscreeninggid"><i class="glyphicon glyphicon-tint"></i> Cancer Screening : <span id="cancerScreeningIdValue"  data-toggle="tooltip" ></span></p>  
                            
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="curcumferencepid"><i class="fa fa-circle-notch"></i> Circumference : <span id="curcumferenceIdValue"  data-toggle="tooltip" ></span></p>
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="muacpid"><i class="fa fa-tape"></i> MUAC : <span id="muacIdvalue"  data-toggle="tooltip" ></span></p>                                                        
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="Disabilityid"><i class="fab fa-accessible-icon"></i> Disability : <span id="DisabilityIdvalue"  data-toggle="tooltip" ></span></p>
                            
                            
                            <p class="hba1c col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" id="Anemicid"><i class="fa fa-vial"></i> Anemic : <span id="AnemicIdvalue"  data-toggle="tooltip" ></span></p>
                            
                            <p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" style='display:none;' id="lblLmp"><i class="fas fa-calendar-alt fa-fw"></i> LMP : <span id="lmpvalue"  data-toggle="tooltip" ></span></p>
                            <p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" style='display:none;' id="lblEDOD" ><i class="far fa-calendar-check fa-fw"></i> EDOD : <span id="edodvalue"  data-toggle="tooltip" ></span></p>
                            
                            <p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" style='display:none;color:red' id="lblIsHighRiskPregnancy"><i class="fas fa-exclamation-triangle fa-fw"></i><span  style='color:red;font-weight: bold;' id="hrpvalue"  data-toggle="tooltip" > High Risk Pregnancy</span></p>
                                            
                                                    
                            <p class="otherInfo col-sm-12 col-md-12 opdVitalsTile opdVitalsLabel" id="pidremarks"><i class="fa fa-comment-dots"></i> Interpretation/Remarks : <span id="otherInfoIdValue"></span></p>
                            <p class="otherInfo col-sm-12 col-md-12 opdVitalsTile opdVitalsLabel" id="patientcomplaintid"><i class="fa fa-phone-square"></i> Teleconsultancy Req Info : <span id="patientcomplaintidValue"></span></p>
                            <p class="otherInfo col-sm-12 col-md-12 opdVitalsTile opdVitalsLabel" id="RegReasonForVisitId"><i class="fa fa-clinic-medical"></i> Reason for Visit : <span id="ReasonVisitFromRegistrationId"></span></p>
                           -->
                             <input type="hidden" id="vitalHiddenValId" name="vitalHiddenVal" value="">
                        </div>
                        
                   
                 </div>
			
			   
        </div>
    </div>
	<!--  Vital Details Ends -->
	<!-- Proxy details Starts -->
	<div class="row">
         <div class="col-xs-12 col-md-12 col-sm-12">
           <span class='bg-warning' style="padding: 10px;">
           <input type="checkbox" name="isProxy" id="isProxy" onclick="hideUnhideProxyDetail(this)">&nbsp;&nbsp;&nbsp;<label for="isProxy"  style="color:blue;font-size: 15px">Proxy Visit</label>
        	</span>
         </div>
     </div>    
    <div class="card cardPrescription" id='proxyMainDiv' style="display: none;">
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-0"><i class="fa fa-plus"></i> &nbsp; Proxy Details</button>
        <div class="" id="collapse-0" aria-labelledby="heading-0" style="padding: 17px;">
        	<div class="row">
        		<div class="col-md-4">
                        <p style="letter-spacing:0"><label>Proxy Person Name</label></p>
                        <input type="text" class="form-control proxy"  name="proxy_name"  id='proxy_name' value=""  maxlength="100">
                </div>
                <div class="col-md-4">
                        <p style="letter-spacing:0"><label>Proxy Person Mobile</label></p>
                        <input type="text" class="form-control proxy" onkeypress="return isNumber(event)" name="proxy_contact" id="proxy_contact" value=""  maxlength="10" >
                </div> 
                <div class="col-md-4">
                        <p style="letter-spacing:0"><label>Relation</label></p>
                        <input type="text" class="form-control proxy"  name="proxy_relation" id="proxy_relation" value="" maxlength="100">
                </div>          	   
        	
        	</div>
        </div>
     </div>   
	<!-- Proxy details End -->
	
	<!-- Chief Complaint Starts -->
    <div class="card cardPrescription" id='chiefComplaintMainDiv'>
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-1"><i class="fa fa-minus"></i> &nbsp; Chief Complaint</button>
        <div class="" id="collapse-1" aria-labelledby="heading-1" style="padding: 17px;">
                 <div class="row">
                      <div class="col-sm-10 col-md-11 prescriptionTileRowFirstCol">
                        <p class="reasonOfVisitAdded"><b></b> 
                          <a style="text-decoration: none;" class="clearLnk">
                            <img style="width: 22px;" alt="" src="/HIS/hisglobal/drDeskAssets/img/clear3.png">
                          </a>
                          <button class="btn btn-xs btn-danger clearAllValues" type="button" data-toggle="tooltip" title="Clear All" onclick="$(this).parent().find('label').remove();" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button>
                          <!-- <button class="value btn btn-xs moreToggleVisitReason clearAllValues" type="button" data-toggle="tooltip" title="Clear All" ></button> 
                          <button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleVisitReason tooltipcss" title="Side" data-toggle="tooltip"></button> -->
                        <!--<a><label><input type="checkbox" class="checkedInput" name="visitReason" checked> Fever</label></a><a style="padding-left:5px"><label>
                        <input type="checkbox" class="checkedInput" name="visitReason" checked> Body Ache</label></a> -->
                        </p>
                      </div>
                      <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                        
                      	<br><br>
                        <!-- <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p> -->
                      </div>
                      
                    </div>
                    <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                    <div class="row chiefComplaintDiv">
                    	<div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-xs-14 col-sm-5 col-md-6 reasonOfVisitCol">
                        <div class="input-group">
                          <input type="text" placeholder="Chief Complaint" reasonofvisitcode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR" id="txt-snomed-ct-search_VR" autocomplete="on" onclick="load_UNIVD('VR','FINDING','450970008')" >   <!-- onclick="load_UNIVD('VR','','450970008')"  -->
                          <div class="input-group-btn">
                            <button class="btn btn-default reasonOfVisitCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                          </div>
                        </div>
                        <div class="concept" id="conceptdiv_1"></div>
                        <input type="hidden" name="targetId"> 
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"  style="display: none;"></div>
                      <div class="col-xs-12 col-sm-1 col-md-1 optionalOrDiv" style="display: none;">
                        <p><b>OR</b></p>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"  style="display: none;"></div>
                      <div class="col-xs-12 col-sm-3 col-md-3"  style="display: none;">
                        <div class="input-group">
                          <input type="text" placeholder="Generic Complaint" name="generalComplaint" id="generalComplaintId" tabindex=-1 class="form-control">
                          <div class="input-group-btn">
                            <button tabindex=-1 class="btn btn-default extInvestigationCleanBtn" onclick="$('input[name=generalComplaint]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                            <!-- <button class="right" type="button" id="start_button_generic" onclick="startButton(event)">
								<img id="start_img_generic" src="/HISDRDESK_MC/hisglobal/images/mic.gif" alt="Start" style="height:30px;width:30px;">
							</button> -->
                          </div>
                        </div>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-1 col-md-1 paddingLeftRightZero siteDiv marginBottom">
                          <select class="form-control" name="chiefComplaintSite" id="chiefComplaintSiteId" autocomplete="off">
                            <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                             <option value="5">Upper Left</option>
                              <option value="6">Lower Left</option>
                              <option value="7">Upper Right</option>
                              <option value="8">Lower Right</option>
                          </select>
                        </div>
                        <div class="col-xs-12 col-sm-3 col-md-2 marginBottom">
                          <div class="col-xs-4 col-sm-4 col-md-4 paddingRightZero chiefComplaintNoOfDays">
                            <input type="text" class="form-control" placeholder="No." name="chiefComplaintNoOfDays" id="chiefComplaintNoOfDaysId" onkeypress="return isNumber(event)">
                          </div>
                          <div class="col-xs-8 col-sm-8 col-md-8 alignLeftPaddingLeftZero chiefComplaintDuration">
                            <select class="form-control" name="chiefComplaintDuration"  id="chiefComplaintDurationId" autocomplete="off">
                            <!--  <option value="0">Duration</option> -->
                              <option value="1">Day/s</option>
                              <option value="2">Week/s</option>
                              <option value="3">Month/s</option>
                              <option value="4">Year/s</option>
                            </select>
                          </div>
                        </div>
                        <div class="col-sm-2 col-md-2">
                        <textarea class="form-control" name="reasonofvisitRemarks" id="reasonofvisitRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-1 col-md-1 prescriptionTileRowsCol">
                        <button class="btn-his reasonOfVisitAdd" id="reasonOfVisitAddId" type="button">Add</button>
                      </div>
                    </div>
        </div>
    </div>
    <!-- Chief Complaint Ends -->
    
    
	
    <!-- Complete History Starts -->
	<div class="card cardPrescription" id='completeHistoryDiv' >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-2"><i class="fa fa-plus"></i> &nbsp;History of Present Illness</button>
        <div class="collapse" id="collapse-2" aria-labelledby="heading-2" style="padding: 17px;">                 
                        <div class="row">
                        <div class="col-xs-12 col-md-3 col-sm-5">
                          <label for="hopi" >History Of Present Illness:</label>
                        </div>
                        <div class="form-group col-xs-12 col-md-11 col-sm-12">
                          <textarea class="form-control" onblur="countChar(this,'charNumHopi');abortMic(this);" id="hopiId" name="hopi" maxlength="3000" onkeyup="countChar(this,'charNumHopi')"></textarea>
                          <p align="right">
							  <label>characters remaining: <span id="charNumHopi" title="3000">3000</span></label>
							</p>
                          <div class="micDiv">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;color:darkolivegreen;font-size:1.2em" class="stop-btn fas fa-microphone  blink"></i>
						</div>
                          <div style="position: absolute;top: 0;right: 16px;">
							  <button type="button" onclick="$(this).parent().parent().find('#hopiId').val('');" class="btn btn-sm btn-default reasonOfVisitCleanBtn"><i class="glyphicon glyphicon-remove"></i></button>
							</div>
                        </div>                       
                    	</div>
                        <div class="row">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="pastHistory" >Past History:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" onblur="countChar(this,'charNumPastHis');abortMic(this);" id="pastHistoryId" name="pastHistory" maxlength="2000" onkeyup="countChar(this,'charNumPastHis');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumPastHis" title="2000">2000</span></label>
							  </p>
                             <div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;color:darkolivegreen;font-size:1.2em" class="stop-btn fas fa-microphone  blink"></i>
							</div>
                            </div>
                        </div>
                        <div class="row">	
		                  	 <div class="col-xs-12 col-md-12 col-sm-12 text-right" style="margin-top: 17px;">
		                      	<button class="btn-his-outline btngrp3" data-divtoshow="divPersonalHistory" type="button" onclick="showHidePrescriptionDiv(this)">
		                   		<i class="fa fa-plus"></i> Personal History</button>
		                   		<button class="btn-his-outline btngrp3" type="button" data-divtoshow="divFamilyHistory" onclick="showHidePrescriptionDiv(this)">
		                   		<i class="fa fa-plus"></i> Family History</button>
		                   		<button class="btn-his-outline btngrp3" type="button" data-divtoshow="divTreatmentHistory" onclick="showHidePrescriptionDiv(this)">
		                   		<i class="fa fa-plus"></i> Treatment History</button>
		                   		<button class="btn-his-outline btngrp3" type="button" data-divtoshow="divSurgicalHistory" onclick="showHidePrescriptionDiv(this)">
		                   		<i class="fa fa-plus"></i> Surgical History</button>
		                   		
		                      </div>
                    	</div>
                        
                        
                        
                        <div class="row" id='divPersonalHistory' style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="personalHistory">Personal History:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" onblur="countChar(this,'charNumPerHis');abortMic(this);" id="personalHistoryId" name="personalHistory" maxlength="2000" onkeyup="countChar(this,'charNumPerHis');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumPerHis" title="2000">2000</span></label>
							  </p>
                          <div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;color:darkolivegreen;font-size:1.2em" class="stop-btn fas fa-microphone  blink"></i>
							</div>
                            </div>
                        </div>
                        <div class="row" id='divFamilyHistory' style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="familyHistory">Family History:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" onblur="countChar(this,'charNumFamHis');abortMic(this);" id="familyHistoryId" name="familyHistory" maxlength="2000" onkeyup="countChar(this,'charNumFamHis');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumFamHis" title="2000">2000</span></label>
							  </p>
                          <div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
						</div>
                            </div>
                        </div>
                        <div class="row" id='divTreatmentHistory' style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="treatmentHistory" >Treatment History:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" onblur="countChar(this,'charNumTreatHis');abortMic(this);" id="treatmentHistoryId" name="treatmentHistory" maxlength="2000" onkeyup="countChar(this,'charNumTreatHis');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumTreatHis" title="2000">2000</span></label>
							  </p>
                             <div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
							</div>
                            </div>
                        </div>
                        <div class="row" id='divSurgicalHistory' style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="surgicalHistory" >Surgical History:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" onblur="countChar(this,'charNumSurgHis');abortMic(this);" id="surgicalHistoryId" name="surgicalHistory" maxlength="2000" onkeyup="countChar(this,'charNumSurgHis');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumSurgHis" title="2000">2000</span></label>
							  </p>
                           <div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
							</div>
                            </div>
                        </div>
                        <div class="row">
	                        <div class="col-xs-12">
	                    	    <label style="color:rgba(75,75,75, 0.7);"><b>Examination :</b></label>
	                      	</div>
                      	</div>
                      	<div class="row">
                            <div class="col-xs-8 col-md-2 col-sm-2">
                              <input type="checkbox" name="pallor" id="pallorId">&nbsp;<label for="Pallor" >Pallor</label>
                            </div>
                            
                             <div class="col-xs-8 col-md-2 col-sm-2">
                              <input type="checkbox" name="icterus" id="icterusId">&nbsp;<label for="icterus" >Icterus</label>
                            </div>
                            
                             <div class="col-xs-8 col-md-2 col-sm-2">
                              <input type="checkbox" name="cyanosis" id="cyanosisId">&nbsp;<label for="cyanosis" >Cyanosis</label>
                            </div>
                            
                             <div class="col-xs-8 col-md-2 col-sm-2">
                              <input type="checkbox" name="clubbing" id="clubbingId">&nbsp;<label for="clubbing" >Clubbing</label>
                            </div>
                            
                             <div class="col-xs-8 col-md-2 col-sm-2">
                              <input type="checkbox" name="iymphadenopathy" id="iymphadenopathyId">&nbsp;<label for="iymphadenopathy" >Iymphadenopathy</label>
                            </div>
                            
                             <div class="col-xs-8 col-md-2 col-sm-2">
                              <input  type="checkbox" name="edema" id="edemaID">&nbsp;<label for="Pallor" >Edema</label>
                            </div>
                           
                        </div>
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="cvs" >CVS:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                               <textarea class="form-control" id="cvsId" name="cvs" maxlength="2000" onkeyup="countChar(this,'charNumCvs');" onblur="countChar(this,'charNumCvs');"></textarea>
                               <p align="right">
							  	<label>characters remaining: <span id="charNumCvs" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="rs" >RS:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="rsId" name="rs" maxlength="2000" onkeyup="countChar(this,'charNumRs');" onblur="countChar(this,'charNumRs');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumRs" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="cns">CNS:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">                              
                              <textarea class="form-control" id="cnsId" name="cns" maxlength="2000" onkeyup="countChar(this,'charNumCns');" onblur="countChar(this,'charNumCns');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumCns" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="pA">P/A:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="pAId" name="pA" maxlength="2000" onkeyup="countChar(this,'charNumpA');" onblur="countChar(this,'charNumpA');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumpA" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="otherExamn">General Examination:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="otherExamnId" name="otherExamn" maxlength="2000" onkeyup="countChar(this,'charNumOthExm');" onblur="countChar(this,'charNumOthExm');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumOthExm" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="otherExamn" >Muscular Examination:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="muscularExamnId" name="muscularExamn" maxlength="2000" onkeyup="countChar(this,'charNumMusExm');" onblur="countChar(this,'charNumMusExm');"></textarea>
                              <p align="right">
							  	<label>characters remaining: <span id="charNumMusExm" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        
                        <div class="row" style="display: none;">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="LocalExamn" >Local Examination:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="LocalExamnId" name="LocalExamn" maxlength="2000" onkeyup="countChar(this,'charNumLocExm');" onblur="countChar(this,'charNumLocExm');"></textarea>
                               <p align="right">
							  	<label>characters remaining: <span id="charNumLocExm" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-xs-12 col-md-3 col-sm-5">
                              <label for="LocalExamn" >Systemic Examination:</label>
                            </div>
                            <div class="form-group col-xs-12 col-md-11 col-sm-12">
                              <textarea class="form-control" id="SystemicExamnId" name="SystemicExamnId" maxlength="2000" onkeyup="countChar(this,'charNumLocExm');" onblur="countChar(this,'charNumLocExm');"></textarea>
                               <p align="right">
							  	<label>characters remaining: <span id="charNumLocExm" title="2000">2000</span></label>
							  </p>
                            </div>
                        </div>
                        
                    
        </div>
    </div>
	<!-- Complete History  Ends -->
    
    <!--  Investigation Reports Starts  -->
	<div class="card cardPrescription" id='investigationReportMainDiv'  >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-6"><i class="fa fa-plus"></i> &nbsp; Lab Reports</button>
        <div class="collapse" id="collapse-6" aria-labelledby="heading-6" style="padding: 17px;">
                    <div class="row">
                      <div class="col-sm-7 col-md-7 prescriptionTileRowFirstCol">
                      </div>
                      <div class="col-sm-3 col-md-3 prescriptionTileRowsCol" style="text-align: right;">
                      	<button type="button" class="btn-his-outline investigationLabReport" onclick="showProcessPopUps('vital')">Lab Report Entry</button>
                      </div>
                       <div class="col-sm-2 col-md-2 prescriptionTileRowsCol">
                        <button type="button" class="btn-his-outline investigationLabReport" onclick="$('#investigationLabReportModal').modal('show');" style="float:left;">CGHS Lab Reports</button>
                      	<br><br>
                        <input type="hidden" id="labHiddenValId" name="labHiddenValId" value="">
                      </div>
                    </div>
                    <div class="row"  >	
							<p class="col-sm-3 col-md-3  opdVitalsLabel" >Blood Sugar</p>		
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > FBS : <span id="strfastingValue" >-</span></p>
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > PPBS : <span id="strRateIdValue" >-</span></p>
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > HBA1C : <span id="strhba1cValue" >-</span></p>							
					</div>
					<hr style="margin-top: 0;margin-bottom: 0; "/>
					<div class="row">	
							<p class="col-sm-12 col-md-12  opdVitalsLabel" >Lipid Profile</p>
					</div>		
					<div class="row">	
							<p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" > T.CHL. : <span id="stracblValue" >-</span></p>
							<p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" > TGL : <span id="strtglValue" >-</span></p>
							<p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" > HDL : <span id="strhdlValue" >-</span></p>
							<p class="col-sm-3 col-md-3 opdVitalsTile opdVitalsLabel" > LDL : <span id="strldlValue" >-</span></p>					
					</div>	
					<hr style="margin-top: 0;margin-bottom: 0; "/>
					<div class="row"  >	
							<p class="col-sm-3 col-md-3  opdVitalsLabel" >Kidney Function Test</p>		
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > Creatinine : <span id="strCreatinineValue" >-</span></p>
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > Uric Acid : <span id="strUricAcidValue" >-</span></p>														
					</div>
					<hr style="margin-top: 0;margin-bottom: 0; "/>
					<div class="row"  >	
							<p class="col-sm-3 col-md-3  opdVitalsLabel" >Thyroid Profile</p>		
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > TSH : <span id="strtshValue" >-</span></p>
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > T3 : <span id="strt3Value" >-</span></p>
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > T4 : <span id="strt4Value" >-</span></p>							
					</div>	<hr style="margin-top: 0;margin-bottom: 0; "/>
					<div class="row"  >	
							<p class="col-sm-3 col-md-3  opdVitalsTile opdVitalsLabel" > HB% : <span id="strhaemoglobinValue" >-</span>g/dL</p>
							<p class="col-sm-6 col-md-6  opdVitalsTile opdVitalsLabel" > Any Other Reports : <span id="stranyOtherReportValue" >-</span></p>												
					</div>	
		</div>
	</div>			
	<!--  Investigation Reports Ends -->
    
	
    <!--  Diagnosis Starts -->
	<div class="card cardPrescription" id='diagnosisMainDiv' >
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-5"><i class="fa fa-minus"></i> &nbsp; Diagnosis</button>
        <div class="" id="collapse-5" aria-labelledby="heading-5" style="padding: 17px;">
        			<div class="row">
        			  <div class="form-group  col-lg-3 col-sm-6 col-md-6"   id='sectionBookmark_5'></div>
        			  <div class="form-group  col-lg-3 col-sm-6 col-md-6" >&nbsp;</div>
                      <div class="form-group  col-lg-6 col-sm-6 col-md-6" style="text-align: right;">
                      	  <a type="button" class="btn-his-outline"  onclick="bookmarkSection(5)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;New Diagnosis Template</a>
                      	  <a type="button" class="btn-his-outline manageTemplate"   onclick="manageTemplateSection(5)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;Manage Template</a>
                      </div>	  
                    </div>  
                    <div class="row">
                      <div class="col-sm-10 col-md-11">
                        <p class="diagnosisAdded">
                          <font class="fontred">*</font><b></b>  <a style="text-decoration: none;" class="clearLnk"><img style="width: 22px;" alt="" src="/HIS/hisglobal/drDeskAssets/img/clear3.png"></a>
                          <button class="btn btn-xs btn-danger clearAllValues" type="button" data-toggle="tooltip" title="Clear All" onclick="$(this).parent().find('label').remove();" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button>  
                           <p style="display:block">
                          <label>ICD Code</label>
                          <label class="switch" style="vertical-align: middle;">
                             <input type="checkbox" name="diagnosisDiseaseReference" value="1" checked="">
                             <span class="slider round"></span> 
                          </label>
                          &nbsp;<label>SNOMED-CT</label>
                        </p> 
                      </div>
                      <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                      <!--   <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p> -->
                      </div>
                    </div>   
                    <div class="row snomedCtDiseaseView">
                      <div class="col-sm-3 col-md-4 marginBottom">
                        <!-- <input type="text" placeholder="SNOMED-CT Diagnosis" class="form-control" name="diagnosis">  --> 
                        <div class="input-group">
                          <input type="text" style="z-index:0;" placeholder="Enter Diagnosis" id="txt-snomed-ct-search_VR2" diagnosiscode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR2" id="txt-snomed-ct-search_VR2" autocomplete="on" onclick="load_UNIVD2('VR2','DISORDER','')" tabindex="2">  
                          <div class="input-group-btn">
                            <button class="btn btn-default diagnosisCleanBtn" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                          </div>
                        </div>
                         <div class="concept" id="conceptdiv_2">  </div>
                          <input type="hidden" name="targetId2"> 
                      </div>
                      <div class="col-sm-2 col-md-2 paddingLeftRightZero siteDiv marginBottom">
                          <select class="form-control" name="diagnosisSite" id="diagnosisSiteId" autocomplete="off">
                              <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                            <option value="5">Upper Left</option>
                            <option value="6">Lower Left</option>
                             <option value="7">Upper Right</option>
                              <option value="8">Lower Right</option>
                          </select>
                        </div>
                        <div class="col-xs-12 col-sm-3 col-md-2 marginBottom" style="display: none;">
                          <div class="col-xs-4 col-sm-4 col-md-4 paddingRightZero chiefComplaintNoOfDays">
                            <input type="text" class="form-control" placeholder="No." name="diagnosisNoOfDays" onkeypress="return isNumber(event)">
                          </div>
                          <div class="col-xs-8 col-sm-8 col-md-8 alignLeftPaddingLeftZero chiefComplaintDuration marginBottom">
                            <select class="form-control" name="diagnosisDuration" id="diagnosisDurationId" autocomplete="off">
                              <option value="0">Duration</option>
                              <option value="1">Days</option>
                              <option value="2">Weeks</option>
                              <option value="3">Months</option>
                              <option value="4">Years</option>
                            </select>
                          </div>
                        </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-2 col-md-2 marginBottom">
                        <select class="form-control" name="diagnosisType" tabindex="3">
                          <option value="11" selected="selected">Provisional</option>
                          <option value="12">Differential</option>
                          <option value="14">Final</option>
                        </select>
                      </div>
                      <div class="col-sm-3 col-md-3">
                        <textarea class="form-control" name="diagnosisRemarks" id="diagnosisRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-1 col-md-1 prescriptionTileRowsCol">
                        <button class="btn-his diagnosisAdd" id="diagnosisAddId" type="button">Add</button>
                      </div>
                    </div>
                     <div class="row ICDCodeDiseaseView" style="display: none;">
                      
                     
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                     <div class="col-xs-6 col-sm-2 col-md-2 marginBottom">
                        <input type="text" placeholder="ICD Code Search" class="form-control flexdatalist flexdatalist-set" name="icdCodeInput" id="icdCodeInputId" autocomplete="off" style="position: absolute; top: -14000px; left: -14000px;" tabindex="-1">

                        <datalist id="ICDcodeLst">    
                        </datalist>
                      </div>
            			 <div style="display:none" id="jsonContainer"><div style="display:none" id="icdJsonObjDiv"></div></div>
                      <script> 
                       
                      $(document).ready(function(){
                          try{
                              <% JSONArray mapIcdCodeLst = (JSONArray) request.getSession().getAttribute("DiagnosisDTL"); %>
                            var tempJSON = <%=mapIcdCodeLst.toString() %>;
						    var icdJsonObj = tempJSON; 
						    //console.log(tempJSON); 
						    if($("#icdJsonObjDiv").text().trim().length<=0)
						    	{
						    		$("#icdJsonObjDiv").text(JSON.stringify(tempJSON).toString());
						    	}
						    else if(JSON.stringify(tempJSON).toString() != $("#icdJsonObjDiv").text().trim().toString()){
						    		$("#icdJsonObjDiv").text(JSON.stringify(tempJSON).toString());
						    }
						    
						  
							/* if(!localStorage.getItem('icdJsonObj'))
								localStorage.setItem('icdJsonObj',JSON.stringify(tempJSON).toString()); 
							else if(JSON.stringify(tempJSON).toString() != localStorage.getItem('icdJsonObj').toString() )
								{
									console.log('localStorage else');
									localStorage.setItem('icdJsonObj',JSON.stringify(tempJSON));  
								}  */
							$('input[name=icdCodeInput]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     maxShownResults: 50,
							     searchIn: 'icdCode', 
							     data: tempJSON
							 }); 
							$('input[name=diseaseInput]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     maxShownResults: 50,
							     searchIn: 'diagnosisName', 
							     data: tempJSON
							 });  
                              }
                          catch(err){
                              console.log('err.message:>>>'+err.message);
                              }
                         }); 
                      </script>
                      
                      <div class="col-xs-6 col-sm-6 col-md-3 marginBottom">
                        <input type="text" placeholder="Disease" class="form-control flexdatalist flexdatalist-set" name="diseaseInput" style="position: absolute; top: -14000px; left: -14000px;" tabindex="-1">
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-1 col-md-1 paddingLeftRightZero siteDiv marginBottom">
                        <select class="form-control" name="diagnosisSiteIcd" id="diagnosisSiteIcdId" autocomplete="off">
                            <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                        </select>
                      </div>
                      <div class="col-xs-12 col-sm-3 col-md-2 marginBottom" style="display: none;">
                          <div class="col-xs-4 col-sm-4 col-md-4 paddingRightZero chiefComplaintNoOfDays">
                            <input type="text" class="form-control" placeholder="No." name="diagnosisNoOfDaysIcd" id="diagnosisNoOfDaysIcdId">
                          </div>
                          <div class="col-xs-8 col-sm-8 col-md-8 alignLeftPaddingLeftZero chiefComplaintDuration marginBottom">
                            <select class="form-control" name="diagnosisDurationIcd" id="diagnosisDurationIcdId" autocomplete="off">
                              <option value="0">Duration</option>
                              <option value="1">Days</option>
                              <option value="2">Weeks</option>
                              <option value="3">Months</option>
                              <option value="4">Years</option>
                            </select>
                          </div>
                        </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-2 col-md-2 marginBottom" >
                        <select class="form-control" name="diagnosisType" >
                          <!-- <option value="0">Diagnosis Type</option> -->
                          <option value="11">Provisional</option>
                          <!-- <option value="13">Working</option> -->
                          <option value="12">Differential</option>
                          <option value="14">Final</option>
                        </select>
                      </div>
                      <div class="col-sm-3 col-md-3">
                        <textarea class="form-control" name="diagnosisRemarksIcd" id="diagnosisRemarksIcdId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                        <button class="btn-his diagnosisAdd" type="button">Add</button>
                      </div>
                    </div>
                    <div class="row">
                    	<div class="col-xs-12">
                    	    <label for="treatmentAdvice" style="color:rgba(75,75,75, 0.7);"><b>Chronic Disease :</b></label>
                      	</div>
                    </div>
                    <div class="row">
                    	<div class="col-xs-12">
                    		<div class="table-responsive">
	                          <table id="chronicDiseaseListTable" class="table table-condensed table-hover" style="margin-bottom: 0px;"> 
	                            <thead>
	                              <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
	                                <th><!-- <input type="checkbox" class="chronicDiseaseChkAll" name="chronicDiseaseChkAll"> --></th><th>Chronic Disease</th><th>Duration(yrs)</th><th>Remarks</th><th>Action</th>
	                              </tr>
	                            </thead>
	                            <tbody>
                              </table>
                        	</div>
                    	</div>
                    </div>
                    <div class="row">                        
                          <div class="col-xs-12 col-sm-6 col-md-8 chronicDiseaseCol">
                            <p style="letter-spacing:0"><label>Chronic Disease</label></p>
                            <div class="input-group">
                              <input type="text" placeholder="Chronic Disease" chronicDiseasecode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR3" id="txt-snomed-ct-search_VR3" onclick="load_UNIVD3('VR3','','450970008')" autocomplete="on">   <!-- onclick="load_UNIVD3('VR3','','450970008')" tabindex="1" -->
                              <div class="input-group-btn">
                                <button class="btn btn-default chronicDiseaseCleanBtn" onclick="$('input[name=txt-snomed-ct-search_VR3]').val('');" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                              </div>
                            </div>
                            <div class="concept" id="conceptdiv_3"></div>
                            <input type="hidden" name="targetId3"> 
                          </div>
                          <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                          <div class="col-xs-12 col-sm-2 col-md-1 marginBottom">
                            <p style="letter-spacing:0"><label>Duration(yrs)</label></p>
                            <input type="text" class="form-control" placeholder="No." name="chronicDiseaseNoOfYears" id="chronicDiseaseNoOfYearsId" onkeypress="return isNumber(event)">
                          </div>
                          
                          <div class="col-xs-12 col-sm-3 col-md-2 marginBottom">
                            <p style="letter-spacing:0"><label>Remarks</label></p>
                            <textarea class="form-control" name="chronicDiseaseRemarks" id="chronicDiseaseRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                          </div>
                          <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                          <div class="col-sm-1 col-md-1 prescriptionTileRowsCol">
                            <p style="letter-spacing:0"><label></label></p>
                            <button class="btn-his chronicDiseaseAddRows" id="chronicDiseaseAddRowsId"  style="margin-top:12px;" type="button">Add</button>
                          </div>
                    </div>
                    	
           
                    <div class="row">	
                  	 <div class="col-xs-12 col-md-12 col-sm-12 text-right"  style="margin-top: 17px;">
                      	<button class="btn-his-outline btngrp2" data-divtoshow="externalDiagnosis"  type="button"    onclick="showHidePrescriptionDiv(this)">
                   		<i class="fa fa-plus"></i> Other Diagnosis</button>
                   		<button style="display: none;" class="btn-his-outline btngrp2"  type="button"  data-divtoshow="confidentialDivId"   onclick="showHidePrescriptionDiv(this)">
                   		<i class="fa fa-plus"></i> Confidential Info.</button>
                   		<button class="btn-his-outline btngrp2"  type="button"    data-divtoshow="diagnosisNoteDivId" onclick="showHidePrescriptionDiv(this)">
                   		<i class="fa fa-plus"></i> Diagnosis Notes</button>
                      </div>
                    </div>	
                    
                    <div class="row" id="externalDiagnosis" style="display: none;">
                        <br>
                        <div class="col-sm-10 col-md-11 marginBottom">
                          <div class="input-group">
                              <input type="text" placeholder="Enter Other Diagnosis" name="externalDiagnosisTxt" id="externalDiagnosisTxtId" class="form-control">
                              <div class="input-group-btn">
                                <button class="btn btn-default extInvestigationCleanBtn" onclick="$('input[name=externalDiagnosisTxt]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                              </div>
                          </div>
                        </div>
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                        <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                           <button class="btn-his diagnosisAddExt" id="diagnosisAddExtId" type="button">Add</button>
                        </div>
                        <div class="clearfix visible-xs"></div>
                    </div>
                    
                    
                    <div class="row" id="confidentialDivId" style="display: none;">
                        <br>
                        <div class="col-sm-12 col-md-12 marginBottom">
                        	<p><b>Confidential Info :</b></p>
                        </div>
                        <div class="col-sm-10 col-md-11 marginBottom">
                         
                         <div class="form-group col-xs-14 col-md-13 col-sm-13">
                        	<textarea class="form-control" id="ConfidentialInfoId"  onblur="abortMic(this)" placeholder="Enter  Confidential Information" name="ConfidentialInfoName" maxlength="2000"></textarea>
                     	<div class="micDiv" style="right:17px;">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
						</div>
                     	 </div>
                       </div>
                        
                        <div class="clearfix visible-xs"></div>
                    </div>
                    
                    <div class="clearfix visible-xs" style="margin-top:10px;"></div>
                    <div class="row" id="diagnosisNoteDivId" style="display: none;">
                                      <br>
                      <div class="col-xs-12 col-md-3 col-sm-5">
                        <label for="diagnosisNote"><b>Diagnosis Note:</b></label>
                      </div>
                      <div class="form-group col-xs-12 col-md-11 col-sm-12">
                        <textarea class="form-control" onblur="countChar(this,'charNumDiag');abortMic(this);" id="diagnosisNoteId" name="diagnosisNote" maxlength="2000" onkeyup="countChar(this,'charNumDiag')"></textarea>
                        <p align="right">
							  <label>characters remaining: <span id="charNumDiag" title="2000">2000</span></label>
							</p>
                        <div class="micDiv">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
						</div>
                        <div style="position: absolute;top: 0;right: 16px;">
						<button type="button" onclick="$(this).parent().parent().find('#diagnosisNoteId').val('');" class="btn btn-sm btn-default reasonOfVisitCleanBtn"><i class="glyphicon glyphicon-remove"></i></button>
						</div>
                      </div>
                      <!-- <div class="form-group col-xs-12 col-md-12 col-sm-12">
                        <div class="col-xs-3 col-md-1 col-sm-3">
                          <label for="diagnosisNote">Diagnosis Note:</label>
                        </div>
                        <div class="col-xs-9 col-md-9 col-sm-9 alignLeftPaddingLeftZero">
                          <textarea class="form-control" id="diagnosisNoteId" name="diagnosisNote" maxlength="2000"></textarea>
                        </div>
                      </div> -->
                      <div class="col-xs-3 col-sm-1" style="padding-right: 0px; text-align: center;">
                          <button type="button" style="padding: 0px;color:#3696e9" class="btn-his progressNoteMacroBtn" id="diagnosisNoteIdDiv" value="progressNoteMacroModal2Div"  onclick="$('#progressNoteMacroModal2').modal('show');"> <!--  onclick="$('#progressNoteMacroModal').modal('show');" <i class="material-icons" style="font-size: 1.5em">message</i> --><i class="fa fa-comments" style="font-size: 1.5em;display:none;"></i></button>
                        </div>   
                    </div>
                   </div>                            
    </div>
	<!--  Diagnosis Ends -->
	<!--  Investigation Starts -->
	<div class="card cardPrescription" id='investigationMainDiv' style="display:none;" >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-6"><i class="fa fa-plus"></i> &nbsp; CGHS Investigation</button>
        <div class="collapse" id="collapse-6" aria-labelledby="heading-6" style="padding: 17px;">
                    <div class="row">
                      <div class="col-sm-10 col-md-10 prescriptionTileRowFirstCol">
                        <p class="investigationAdded"><b></b> 
                        <a style="text-decoration: none;" class="clearLnk"><img style="width: 22px;" alt="" src="/HIS/hisglobal/drDeskAssets/img/clear3.png"></a>
                        <button class="btn btn-xs btn-danger clearAllValues" type="button" data-toggle="tooltip" title="Clear All" onclick="$(this).parent().find('label').remove();" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button> 
                        <!-- <a><label><input type="checkbox" class="checkedInput" name="reasonOfVisit"  checked> CBC</label>
                        </a>
                        <a style="padding-left: 5px;"><label> 
                        <input type="checkbox" class="checkedInput" name="reasonOfVisit"  checked> BLOOD SUGAR</label>
                        </a> --></p>
                      </div>
                      <!-- <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                        <button type="button" id="InvestigationTemplateId" class="btn btn-info btn-sm vitalModifyBtn AddToggleClass" onclick="OpenInvestigationTemplate(this,event)" tabindex="0" data-toggle="tooltip" title="Investigation" style="float:left;border:0px;">Raise Tests</button>
                        <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p>
                      </div> -->
                      
                       <div class="col-sm-2 col-md-2 prescriptionTileRowsCol">
                        <button type="button" class="btn-his-outline investigationLabReport" onclick="$('#investigationLabReportModal').modal('show');" style="float:left;">Lab Reports</button>
                      	<br><br>
                        <!-- <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p> -->
                      </div>
                    </div>    
                    <div class="row">
                      <div class="col-sm-11">
                        
                        <%
						HashMap<String ,String> BookmarkMAP = (HashMap) request.getSession().getAttribute("BookmarkDTL");
						//System.out.print("MacrosDTL"+MacrosMap);	
						ArrayList<String> listBookMarkList=null;
						int i=0;
						 	if(BookmarkMAP!=null)
						 	{
						%>
						<p style="padding-left: 10px;display:none"><a><label><input type="radio" value="1" name="bookmarksToAdd" checked> Add through Bookmarks</label></a>
                        <!-- <a style="padding-left: 5px;"><label><input type="radio" value="2" name="bookmarksToAdd"> Lab Wise Test</label></a></p> -->
                        <p class="AddToBookMarkButtons" style="padding-left: 10px;">
                        <%
						 		for(Map.Entry m:BookmarkMAP.entrySet()){ 
									listBookMarkList=new  ArrayList<String>();
									listBookMarkList=(ArrayList) m.getValue();
									//System.out.println("bkm ::::"+m.getValue());
						
									if(listBookMarkList.get(6).equals("1")){
									%>
									 	<button class="btn btn-primary btn-xs investigationTestTriggerBtn" type="button" onclick="$('#investigationTestBundle<%=i %>').modal('show');" data-toggle="tooltip" data-placement="bottom" title="Group Test"><%=listBookMarkList.get(5) %></button>
									<%}else{%>
										 <button class="btn btn-success btn-xs investigationTestTriggerBtn" type="button" onclick="$('#investigationTestBundle<%=i %>').modal('show');" data-toggle="tooltip" data-placement="bottom" title="Bookmark"><%=listBookMarkList.get(5) %></button>
									<%}
							 i++;
								}
                        	%>
                        	</p>
                        	<br>
                        	<%
						 	}	
							   %>
						<!-- <button class="btn btn-warning btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Blood Sugar</button> -->
                        
                        
                        <p class="LabWiseTestButtons" style="padding-left: 10px; display: none;"><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Biochemistry</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Radiology</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Dental</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Clinical Pathology Lab</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Microbiology</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Dermotology</button><button class="btn btn-danger btn-sm investigationTestTriggerBtn" type="button" data-toggle="modal" data-target="#investigationTestBundle">Pathology</button>
                        </p>
                      </div>    
                    </div>
                    <!-- <p>(<font style="color: rgba(35, 104, 194, 0.8)"> Search On : </font> <label><input type="radio" name="investigationSearchOn" checked="true" value="1"> Test Name</label>&nbsp;<label>
                    <input type="radio" name="investigationSearchOn" value="2"> Test Code</label>
                    )</p> -->
                       <div class="row investigationsDiv">
                      <div class="col-xs-12 col-sm-6 col-md-8 marginBottom">
                        <div class="input-group">
                          <input type="text" placeholder="Test Name" name="investigation" class="form-control flexdatalist flexdatalist-set" autocomplete="off" tabindex="-1" style="position: absolute; top: -14000px; left: -14000px;">
                          <div class="input-group-btn">
                            <button class="btn btn-default investigationCleanBtn" onclick="$('input[name=investigation]').val('');$('input[name=flexdatalist-investigation]').css('background-color','#ffffff');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                          </div>
                        </div>
                        <datalist id="investigationLstTest">          
                       
					 	</datalist>
                      </div>
					<div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      
                      <div class="col-sm-1 col-md-1 paddingLeftRightZero siteDiv marginBottom">
                          <select class="form-control" name="investigationSite" id="investigationSiteId" autocomplete="off">
                             <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                            <option value="5">Upper Left</option>
                            <option value="6">Lower Left</option>
                             <option value="7">Upper Right</option>
                              <option value="8">Lower Right</option>
                          </select>
                        </div>
                        <div class="col-xs-12 col-sm-3 col-md-2 marginBottom">
                            <textarea class="form-control" name="InvestigationRemarks" id="InvestigationRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                         </div>
                         
                      <div class="col-xs-12 col-sm-1 col-md-1 optionalOrDiv" style="display: none">
                        <p><b>OR</b></p>
                      </div>

                      <div class="col-xs-12 col-sm-5 col-md-4 marginBottom" style="display: none">
                          <div class="input-group">
                              <input type="text" tabindex=-1 placeholder="External Test Name" name="externalInvestigation" id="externalInvestigationId" class="form-control">
                              <div class="input-group-btn">
                                <button tabindex=-1  class="btn btn-default extInvestigationCleanBtn" onclick="$('input[name=externalInvestigation]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                              </div>
                          </div>
                        </div>

                      <!-- <div class="col-sm-2 col-md-1 paddingLeftRightZero siteDiv marginBottom">
                        <select class="form-control" name="investigationSite" id="investigationSiteId" autocomplete="off">
                         <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                        </select>
                      </div>
                      <div class="col-sm-3 col-md-2">
                        <textarea class="form-control" name="investigationRemarks" id="investigationRemarksId" rows="1" style="height:34px;" placeholder="Instructions"></textarea>
                      </div> -->
                      <div style="display:none" id="testJsonObjDiv"></div>
                      <script> 
                      $(document).ready(function(){
                          <%  JSONArray mapTestDtlLst = (JSONArray) request.getSession().getAttribute("TESTDTL");   %> 
                          try{ 
                            var tempJSON = <%=mapTestDtlLst.toString() %>;
						    //var testJsonObj = tempJSON; 
						    //console.log(tempJSON);   
                            if($("#testJsonObjDiv").text().trim().length<=0)
					    	{
					    		$("#testJsonObjDiv").text(JSON.stringify(tempJSON).toString());
					    	}
					    	else if(JSON.stringify(tempJSON).toString() != $("#testJsonObjDiv").text().trim().toString()){
					    		$("#testJsonObjDiv").text(JSON.stringify(tempJSON).toString());
					    	}
					    	
							/*if(!localStorage.getItem('testJsonObj'))
								localStorage.setItem('testJsonObj',JSON.stringify(tempJSON).toString()); 
							else if(JSON.stringify(tempJSON).toString() != localStorage.getItem('testJsonObj').toString() )
								{
									console.log('localStorage else');
									localStorage.setItem('testJsonObj',JSON.stringify(tempJSON));  
								} */
						/* 	 $('input[name=investigation]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     searchByWord: true,
							     maxShownResults: 50,
							     searchIn: 'testName', 
							     data: tempJSON
							 });  */
                            $('input[name=investigation]').flexdatalist({
							    minLength: 1,
							    focusFirstResult: true,
							    searchByWord: false, // Disable built-in search behavior
							    maxShownResults: 50,
							    searchIn: 'testName',
							    data: tempJSON,
							    search: function(query, data) {
							        query = query.toLowerCase();
							        return data.filter(function(item) {
							            return item.drugName.toLowerCase().startsWith(query.charAt(0));
							        });
							    }
							});
							    							    
                              }
                          catch(err){
                              console.log('err.message:>>>'+err.message);
                              }
                         }); 
                      </script>
                      	<div class="clearfix visible-xs" style="margin-top:5px;"></div>
			              <div class="col-sm-1 col-md-1 prescriptionTileRowsCol">
			                 <button class="btn-his investigationAdd" id="investigationAddId" type="button">Add</button>
			              </div>
                      </div>
                      <br>
                   <div class="clearfix visible-xs" style="margin-top:10px;"></div>
                   <!-- <button class="btn btn-info" type="button" onclick="$('#externalInvestigationInput').slideToggle();$(this).find('i').toggleClass('fa-plus fa-minus');"><i class="fa fa-plus"></i> Add External Investigation</button> -->
                    <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                    <div class="row">
                      <div class="col-xs-12 col-md-3 col-sm-5">
                        <label for="investigationNote" style="color:rgba(75,75,75, 0.7);"><b>Investigation Note:</b></label>
                      </div>
                      <div class="form-group col-xs-12 col-md-11 col-sm-12">
                        <textarea class="form-control" onblur="countChar(this,'charNumInv');abortMic(this);" id="investigationNoteId" name="investigationNote" maxlength="2000" onkeyup="countChar(this,'charNumInv');"></textarea>
                        <p align="right">
							  <label>characters remaining: <span id="charNumInv" title="2000">2000</span></label>
							</p>
                         <div class="micDiv">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
						</div>
                        <div style="position: absolute;top: 0;right: 16px;">
							<button type="button" onclick="$(this).parent().parent().find('#investigationNoteId').val('');" class="btn btn-sm btn-default reasonOfVisitCleanBtn"><i class="glyphicon glyphicon-remove"></i></button>
							</div>
                      </div>
                     <!-- <div class="row" id="externalInvestigationInput" style="display:none;">   <br>
                       <div class="col-sm-10 col-md-11">
			             <div class="input-group">
			             	<input type="text" placeholder="Enter External Test Name" name="externalInvestigation" class="form-control">
				            <div class="input-group-btn">
							  <button class="btn btn-default extInvestigationCleanBtn" onclick="$('input[name=externalInvestigation]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
							</div>
			             </div>
			           </div>
			           <div class="clearfix visible-xs" style="margin-top:5px;"></div>
		               <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
		                 <button class="btn-his externalInvestigationAdd" type="button">Add</button>
		               </div>-->
		               
		               <div class="col-xs-3 col-sm-1" style="padding-right: 0px; text-align: center;">
                          <button type="button" style="padding: 0px;color:#3696e9" class="btn-his progressNoteMacroBtn" id="investigationNoteIdDiv" value="progressNoteMacroModal3Div"  onclick="$('#progressNoteMacroModal3').modal('show');"> <!--  onclick="$('#progressNoteMacroModal').modal('show');" <i class="material-icons" style="font-size: 1.5em">message</i> --><i class="fa fa-comments" style="font-size: 1.5em;display:none;"></i></button>
                        </div>
		               
                    </div>  
                  
                    
			   
        </div>
    </div>
	<!--  Investigation Ends -->
	<!--  Procedure(s) advised/Treated Starts -->
	<div class="card cardPrescription" id='procedureMainDiv' style="display:none;" >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-7"><i class="fa fa-plus"></i> &nbsp;CGHS Procedure(s) Advised/Treated</button>
        <div class="collapse" id="collapse-7" aria-labelledby="heading-7" style="padding: 17px;">
                    <div class="row">
                      <div class="col-sm-10 col-md-11 prescriptionTileRowFirstCol">
                        <p class="clinicalProceduresAdded"><b></b> 
                          <a style="text-decoration: none;" class="clearLnk">
                            <img style="width: 22px;" alt="" src="/HIS/hisglobal/drDeskAssets/img/clear3.png">
                          </a>
                          <button class="btn btn-xs btn-danger clearAllValues" type="button" data-toggle="tooltip" title="Clear All" onclick="$(this).parent().find('label').remove();" style="background-color: white;border: 0px;"><span style="color: red;" class="glyphicon glyphicon-trash" style="color: red;"></span></button>
                       <!-- <button type="button" class="btn btn-info" data-toggle="modal" data-target="" style="float:Right;background-color:#ed6c68; border:0px;" value="49#2"  onclick="OpenTemplate(this)">Administration</button> -->
                        </p>
                        
                      </div>
                      
                      <div class="col-sm-2 col-md-1 prescriptionTileRowsCol">
                        <button type="button" class="btn-his" data-toggle="modal" data-target="" style="float:Right;display:none;" value="49#2"  onclick="OpenTemplate(this)">Administration</button>
                      	<br><br>
                        <!-- <p><a class="clearLnk" style="color: rgba(35, 104, 194, 0.8)" title="Clear checked items"><img src="img/clear.png" style="width: 2.2em; height: 2.2em; min-width: 2em;"></a></p> -->
                      </div>
                      
                    </div>
                   <br>
                    <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                    <div class="row ClinicalPrcoeduresDiv">
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      
                       <div class="col-xs-8 col-sm-4 col-md-2 clinicalProcedureCol">
                          <select class="form-control" name="clinicalServiceArea" id="clinicalServiceAreaId" autocomplete="off" onchange="getProcedure()">
                             <option value="0">Select Service Area</option>
                              <%
                        	 LinkedHashMap<String ,String> strServiceAreaHashMap = (LinkedHashMap) request.getSession().getAttribute("ServiceAreaDtl");
                              //System.out.println("strServiceAreaHashMap "+strServiceAreaHashMap);
                          //   if(strServiceAreaHashMap != null){ 
                             for(Map.Entry m:strServiceAreaHashMap.entrySet()){  
                            	  // System.out.println(m.getKey()+" "+m.getValue()); 
                            	   
                            	   %>
                            	   <option value="<%=m.getKey()%>"><%=m.getValue() %></option> 
                            	   <%
                            	  }  
                             
                           //  }
								
									   %>    
                          </select>
                        </div>
                      
                      <div class="col-xs-8 col-sm-4 col-md-6 clinicalProcedureCol">
                        <div >
                         <!-- <input type="text" placeholder="Clinical Procedure" name="clinicalProcedureName" class="form-control flexdatalist flexdatalist-set" autocomplete="off" tabindex="-1" style="position: absolute; top: -14000px; left: -14000px;">
                          <div class="input-group-btn">
                            <button class="btn btn-default clinicalProcedureCleanBtn" type="button" onclick="$('input[name=clinicalProcedureName]').val('');"><i class="glyphicon glyphicon-remove"></i></button>
                          </div> -->
                          
                          <select class="form-control"  id=clinicalProcedureName name="clinicalProcedureName" >
                             <option value="0">Select Procedure</option>
                        	<%
                        	HashMap<String ,List> procmap = (HashMap) request.getSession().getAttribute("clinicalProcedureMap");
		                      if(procmap!=null && procmap.size()>0){
                        	for(Map.Entry procm:procmap.entrySet()){ 
								
                        		 String procId=(String)procm.getKey();
                        		 String procVal=(String)procm.getValue();
							   
							   %>
		            
			                  	<option value="<%=procId%>"><%=procVal %></option> 
			                  
			                  <%
			                  }
                        	
                        	%>
                        	   <%
		                      }else{
		                    	  
		                    	  %>
		      		            
			  						<option value="0">Select Procedure</option>			                  
				  				<%
		                    	  
		                      }
	                 			 %>
                        </select>
                          
                        </div>
                        <div class="concept" id="conceptdiv_7"></div>
                        <input type="hidden" name="targetId"> 
                        <div style="display:none" id="jsonContainer"><div style="display:none" id="ClinicalProcedureJsonObjDiv"></div></div>
                        <div style="display:none" id="jsonContainer"><div style="display:none" id="ClinicalProcedureJsonObjDivOne"></div></div>
                        <script> 
                       $(document).ready(function(){
                          <%  JSONArray mapTestDtlLst1 = (JSONArray) request.getSession().getAttribute("CILINICALPROCEDURE");   %> 
                          try{ 
                            var tempJSON = <%=mapTestDtlLst1.toString() %>;
						    //var testJsonObj = tempJSON; 
						    //console.log("CILINICALPROCEDURE=="+JSON.stringify(tempJSON));  
						    
						    if($("#ClinicalProcedureObj").text().trim().length<=0)
					    	{
					    		$("#ClinicalProcedureJsonObjDiv").text(JSON.stringify(tempJSON).toString());
					    		$("#ClinicalProcedureJsonObjDivOne").text(JSON.stringify(tempJSON).toString());
					    	}
					    	else if(JSON.stringify(tempJSON).toString() != $("#ClinicalProcedureJsonObjDiv").text().trim().toString()){
					    		$("#ClinicalProcedureJsonObjDiv").text(JSON.stringify(tempJSON).toString());
					    		$("#ClinicalProcedureJsonObjDivOne").text(JSON.stringify(tempJSON).toString());
					    	}
						     
							/* if(!localStorage.getItem('ClinicalProcedureObj')){
								localStorage.setItem('ClinicalProcedureObj',JSON.stringify(tempJSON).toString());
								localStorage.setItem('ClinicalProcedureObj1',JSON.stringify(tempJSON).toString());
							}
							else if(JSON.stringify(tempJSON).toString() != localStorage.getItem('ClinicalProcedureObj').toString() )
								{
									console.log('localStorage else');
									localStorage.setItem('ClinicalProcedureObj',JSON.stringify(tempJSON));  
									localStorage.setItem('ClinicalProcedureObj1',JSON.stringify(tempJSON).toString());
								} */ 
							/*$('input[name=clinicalProcedureName]').flexdatalist({
							     minLength: 1,
							     focusFirstResult: true,
							     searchByWord: true,
							     maxShownResults: 50,
							     searchIn: 'testName', 
							     data: tempJSON
							 }); */ 
                              }
                          catch(err){
                              console.log('err.message:>>>'+err.message);
                              }
                         });  
                      </script>
                        
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-xs-12 col-sm-1 col-md-1 optionalOrDiv" style="display: none;">
                        <p><b>OR</b></p>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-xs-12 col-sm-3 col-md-3" style="display: none;">
                        <div class="input-group">
                          <input type="text" placeholder="Other Procedures" name="otherProcedures" id="otherProceduresId" tabindex=-1 class="form-control">
                          <div class="input-group-btn">
                            <button tabindex=-1 class="btn btn-default otherProceduresCleanBtn" onclick="$('input[name=otherProcedures]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                          </div>
                        </div>
                      </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      
                      <div class="col-sm-1 col-md-1 paddingLeftRightZero siteDiv marginBottom">
                          <select class="form-control" name="clinicalProceduresSite" id="clinicalProceduresSiteId" autocomplete="off">
                             <option value="0">Side</option>
                            <option value="1">NR</option>
                            <option value="2">Left</option>
                            <option value="3">Right</option>
                            <option value="4">Bilateral</option>
                            <option value="5">Upper Left</option>
                            <option value="6">Lower Left</option>
                             <option value="7">Upper Right</option>
                              <option value="8">Lower Right</option>
                          </select>
                        </div>
                        <div class="col-xs-12 col-sm-3 col-md-2 marginBottom">
                            <textarea class="form-control" name="clinicalProceduresRemarks" id="clinicalProceduresRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                         </div>
                      <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      <div class="col-sm-1 col-md-1 prescriptionTileRowsCol">
                        <button class="btn-his clinicalProceduresAdd" id="clinicalProceduresAddId" type="button">Add</button>
                      </div>
                    </div>
                                        
                  
			   
        </div>
    </div>
	<!--  Procedure(s) advised/Treated Ends -->
     
<!--  Drugs/Advices Starts -->
	<div class="card cardPrescription" id='drugMainDiv' >
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-9"><i class="fa fa-minus"></i> &nbsp; Drugs/Advices</button>
        <div class="" id="collapse-9" aria-labelledby="heading-9" style="padding: 17px;">
             <div class="">
                  				
                    
                    <div class="row">
                      <div class="form-group  col-lg-3 col-sm-6 col-md-6"   id='sectionBookmark_4'></div>
                      <div class="form-group  col-lg-1 col-sm-6 col-md-6"  >&nbsp;</div>	
                      <div class="form-group  col-lg-8 col-sm-6 col-md-6" style="text-align: right;">
                      	  <a type="button" class="btn-his-outline"  onclick="bookmarkSection(4)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;New Drug Template</a>
                      	  <a type="button" class="btn-his-outline manageTemplate"   onclick="manageTemplateSection(4)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;Manage Template</a>
                      	  <a type="button" class="btn-his-outline"  onclick="showProcessPopUps('medicineStock')">Available Medicine</a>   	
						  <a type="button" class="btn-his-outline"  onclick="showProcessPopUps('medicineHistory')">Medicine History</a>
					  </div>	  
                        <br/>
                        <br/>
                        <%
                        /* ####   for drug bookmark more option if bookmarks are more than 5 ###*/
          			MultiValueMap DrugProfile= (MultiValueMap) request.getSession().getAttribute("DrugProfile");
                   	
                    //System.out.println("DrugProfile "+DrugProfile);		
                     if(DrugProfile!=null && DrugProfile.size() > 0)
                   	{
                    	// System.out.println("DrugProfilelength "+DrugProfile.size());	
                    	  int Tempval=0;
                   		Set<String> keys = DrugProfile.keySet();
                   	for(String key : keys){ 
                   		Tempval++;
                   		/* System.out.println("RoomNo"+key);
                   		System.out.println("Patient Dtl"+DrugProfile.get(key));
                   		System.out.println("Patient Dtl"+((List) DrugProfile.getCollection(key)).size()); */
                   		if(Tempval >5)
                   		{
                   		
                   		%>
                   		
                   		  <%--  $('#moreDiv').append('<button id="+ btnid+" class="btn btn-primary btn-xs investigationTestTriggerBtn" type="button" onclick="$('#investigationTestBundle<%=key.split("#")[0] %>').modal('show');"><%=key.split("#")[1] %></button>'); --%>
                   		  <button id='key.split("#")[0]' class="btn btn-primary btn-xs investigationTestTriggerBtn bookMarkListView" type="button" onclick="$('#investigationTestBundle<%=key.split("#")[0] %>').modal('show');" style="display:none; "><%=key.split("#")[1] %></button>		
                   			
                   		<%
                   		
                   		}
                   		else{
                   		%>
                   		 <button id='<%=key.split("#")[0] %>' class="btn btn-primary btn-xs investigationTestTriggerBtn" type="button" onclick="$('#investigationTestBundle<%=key.split("#")[0] %>').modal('show');"><%=key.split("#")[1] %></button>		
                   		 
                   		<%
                   		}
                   		
                   		
                   	}
                   	%>
                   	 	<button type="button" id="moreDiv" style="text-decoration:none;" class="btn-his" onClick="bookMarkListView()" >more...</button>
                   		 <button type="button" id="lessDiv" style="text-decoration:none;display:none;" class="btn-his" onClick="bookMarkListHide()">less...</button>
                   		
                   	<%
                  }
                   		%>
                      <div id="bntDiv"> </div>  
                         <div class="col-lg-12 col-sm-12 col-md-12 table-responsive">
                          <table id="drugAdviceListTable"  class="table table-condensed table-hover" style="margin-bottom: 0px;display: none;"> 
                            <thead>
                              <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
                               <th style="width:5%;text-align:center;display:none;" ><input type="checkbox" class="checkedInputAll" name="drugsAdvicesAll"></th>
                               <th style="width:15%;" >Drug</th>
                               <th style="width:10%;text-align:center">Dosage</th>
                               <th style="width:10%;text-align:center">Frequency</th>
                               <th class="drugAdviceListExcessCol" style="display: none;">Start Date</th>
                               <th style="width:10%;text-align:center">Days</th>
                               <th style="width:10%;text-align:center">Quantity</th>
                               <th  style="width:10%;text-align:center">Status</th>
                               <th  style="width:10%;">Prescribed By</th>
                               <th  style="width:10%;" class="drugAdviceListExcessCol">Instructions</th>
                               
                               <th style="width:10%;text-align:center">Action</th>                                 
                              </tr>
                            </thead>
                            <tbody>
                            </tbody>
                           </table>
                          </div>  
                      </div>
                    </div>   
                     
                    <div class="row">
                      <div class="col-md-6">	<!-- class name changed from "col-md-2"  to "col-md-4" by Timsi as suggested By Priyesh Sir  -->
                        <p style="letter-spacing:0"><label><span style="color:red;">*</span>Drug Name</label></p>
                        <div class="input-group" style="width: 100%">
                        	<input type="text" placeholder="Drug Name" class="form-control" name="drugName" value="" autocomplete="off"  tabindex="5">  
                        	<div class="input-group-btn">
							  <button class="btn btn-default drugNameCleanBtn" onclick="$('input[name=drugName]').val('');$('input[name=flexdatalist-drugName]').css('background-color','#ffffff');$('#doseQty').val('1');$('#spanDrugForm').text('-')" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
							</div>
                        </div>
                        <datalist id="drugNameLst">
                        
                        </datalist>
                      </div>
                      <div style="display:none" id="jsonContainer"><div style="display:none" id="drugJsonObjDiv"></div></div>
                        <div class="col-md-2 rmLeftPaddInInput">
                        <p style="letter-spacing:0"><label>Dosages
                        <div class="input-group">
                          <input type="text"  class="form-control " name="doseQty" id="doseQty" value="1" maxlength="2" onkeypress="return isNumber(event)">
                          <div class="input-group-btn">
                            <span class="btn btn-default"  id='spanDrugForm'>-</span>
                          </div>
                        </div>
                        <input type='hidden' name="drugDosage" id="drugDosageId">
                      </div>
                      <div class="col-md-2 rmLeftPaddInInput">
                        <p style="letter-spacing:0"><label>Frequency<!-- <sup style="color:red;">*</sup> --></label></p>
                        <select class="form-control" name="drugFrequency"  tabindex="7"> 
                        	 <option value="0">Select</option>
                        	
                        	  <%                        	  
                        	 if(frequencyHTML!=null){%>
                        	 	<%=frequencyHTML %>
                        	 <%} %>	
							
                        </select>
                        <input type='text' class='customDrugFrequencyText' id='drugFrequencyText' name='drugFrequencyText' maxlength='100' class='form-control'  style="display:none;margin-top:5px;" placeholder="Enter Frequency"> 
                      </div> 
                      <div class="col-md-2" style="display:none;">
                        <p style="letter-spacing:0"><label>Start Date<!-- <sup style="color:red;">*</sup> --></label></p>
                        <input type="date" class="form-control" id="drugStartDate" name="drugStartDate" style="line-height: normal;"  tabindex="8">
                      </div>
                      <div class="col-md-1">
                        <p style="letter-spacing:0"><label>Days<!-- <sup style="color:red;">*</sup> --></label></p>
                        <input type="text" class="form-control drugDays" onkeypress="return isNumber(event)" name="drugDays" value=""  tabindex="9" maxlength="2">
                      </div>
                      <div class="col-md-1">
                        <p style="letter-spacing:0"><label>Quantity<!-- <sup style="color:red;">*</sup> --></label></p>
                        <input type="text" class="form-control DrugQuantity" onkeypress="return isNumber(event)" name="drugQuantity"  maxlength="3"  tabindex="10">
                        <input type='hidden' name='isManualEntryDone' id='isManualEntryDone' value="0" >
                      </div>
                      </div>
                      <div class="row">
                      <div class="col-md-2">	<!-- class name changed from "col-md-3" to "col-md-1" by Timsi as suggested By Priyesh Sir  -->
                        <p style="letter-spacing:0"><label>Prescribed By</label></p>
                         <input type='text' class="form-control refferedBy" id="refferedBy"  maxlength="100" name='refferedBy' />
                      </div>
                      <div class="col-md-4">	<!-- class name changed from "col-md-3" to "col-md-1" by Timsi as suggested By Priyesh Sir  -->
                        <p style="letter-spacing:0"><label>Instructions</label></p>
                       <!--  <textarea class="form-control" name="drugInstructions" rows="1" tabindex="11" style="height:34px;"></textarea>  -->	
                        
                         <input type='text' class="form-control drugInstruction" id="drugInstructionsId1"  maxlength="500" name='drugInstructions'>
                      <!-- <input type='text' class="form-control"  id="strDrugsRemarksId" name="strDrugsRemarks" maxlength="500" /> -->
        			
                      </div> 
                      <div class="col-md-1 prescriptionTileRowsCol" >  
                        <button style="margin-top: 2.8em;" class="btn-his" id="btnAddNewRegisteredDrug" type="button">Add</button>
                      </div>
                    </div>  
                    <br>
                    <div class="clearfix visible-xs visible-sm" style="margin-top:10px;"></div>
                    <div class="col-md-12" style='text-align: right' > 
                   		<button id="externalDrugBtn" class="btn-his-outline"  type="button" onclick="$('#externalDrugInput').slideToggle();$(this).find('i').toggleClass('fa-plus fa-minus');" data-toggle="tooltip" title="These drugs will not be dispensed by the Pharmacist since these Drugs are not available in the Hospital"><i class="fa fa-plus"></i>&nbsp;Drugs Not Available in CGHS</button>
                   		<button id="treatementDtlBtn" class="btn-his-outline"  type="button" onclick="$('#treatmentMainDiv').slideToggle();$(this).find('i').toggleClass('fa-plus fa-minus');" data-toggle="tooltip" title=""><i class="fa fa-plus"></i>&nbsp;Treatment Details</button>
                   </div>             
                    <div class="clearfix visible-xs visible-sm" style="margin-top:10px;"></div>
                     
                    
                    <div class="row" id="externalDrugInput" style="display:none;">
                      <div class="col-md-4">
                        <p style="letter-spacing:0"><label>Drug Name<sup style="color:red;">*</sup></label></p>
                        <div class="input-group">
                        	<input type="text" placeholder="External Drug Name" class="form-control" name="externalDrugName" id="externalDrugNameId" value="">
                        	<div class="input-group-btn">
							  <button class="btn btn-default extDrugNameCleanBtn" onclick="$('input[name=externalDrugName]').val('');" style="z-index:0;" type="button"><i class="glyphicon glyphicon-remove"></i></button>
							</div>
                        </div>   
                      </div>
                      <div class="col-md-2 rmLeftPaddInInput">
                        <p style="letter-spacing:0"><label>Drug Type</label></p>
                        <select class="form-control" name="extItemType" id="extItemType" autocomplete="off">
                        <option value="0">Select</option>
                        	<%
                        	 if(dosageOptionHTML!=null){%>
                        	 	<%=dosageOptionHTML %>
                        	 <%} %>	
                        </select>
                       </div>
                       <div class="col-md-2 rmLeftPaddInInput">
                        <p style="letter-spacing:0"><label>Dosages
                        <div class="input-group">
                          <input type="text"  class="form-control " name="extDoseQty" id="extDoseQty" value="1" maxlength="2" onkeypress="return isNumber(event)">
                          <div class="input-group-btn">
                            <span class="btn btn-default"  id='spanExtDrugForm'>-</span>
                          </div>
                        </div>                        
                      </div>
                       
                      <div class="col-md-2 rmLeftPaddInInput">
                        <p style="letter-spacing:0"><label>Frequency</label></p>
                        <select class="form-control" name="externalDrugFrequency"> 
                        	<option value="0">Select</option>							
							  <%
                        	 if(frequencyHTML!=null){%>
                        	 	<%=frequencyHTML %>
                        	 <%} %>
                        </select> 
                        <input type='text' class='customDrugFrequencyText' id='externalDrugFrequencyText' name='externalDrugFrequencyText' maxlength='100' style="display:none;margin-top:5px;" class='form-control' placeholder="Enter Frequency">
                      </div> 
                      <div class="col-md-2" style="display: none;">
                        <p style="letter-spacing:0"><label>Start Date</label></p>
                        <input type="date" class="form-control"  id="externalDrugStartDate" name="externalDrugStartDate" style="line-height: normal;">
                      </div>
                      <div class="col-md-1">
                        <p style="letter-spacing:0"><label>Days</label></p>
                        <input type="text" class="form-control drugDays" onkeypress="return isNumber(event)" name="externalDrugDays" value="" maxlength="2">
                      </div>
                      <div class="col-md-1">
                        <p style="letter-spacing:0"><label>Quantity</label></p>
                        <input type="text" class="form-control DrugQuantity" onkeypress="return isNumber(event)" maxlength="3" name="externalDrugQuantity"  value="">
                        <input type='hidden' name='isManualEntryDoneExternal' id='isManualEntryDoneExternal' value="0" >
                      </div>
                      <div class="col-md-4">	<!-- class name changed from "col-md-3" to "col-md-1" by Timsi as suggested By Priyesh Sir  -->
                        <p style="letter-spacing:0"><label>Prescribed By</label></p>
                         <input type='text' class="form-control refferedBy" id="externalRefferedBy"  maxlength="100" name='externalRefferedBy' />
                      </div>
                      <div class="col-md-4">
                        <p style="letter-spacing:0"><label>Instructions</label></p>
                       
                        <input type='text'   class="form-control drugInstruction"  autocomplete="off"   placeholder='Remarks' id="externalDrugInstructionsId" name='externalDrugInstructions'>
                        
                      </div> 
                      <div class="col-md-1 prescriptionTileRowsCol" style="padding-top: 20px;
">  
                        <button style="margin-top: 20px;" class="btn-his" id="btnExternalDrugsAdviceAddId" type="button">Add</button>
                      </div>
                    </div>
                    <br>                     
                  </div>   
			   
        </div>
    </div>
	<!--  Drugs/Advices Ends -->

	
<!--  Treatment Advice Starts -->
	<div class="card cardPrescription" id='treatmentMainDiv' style="display: none;" >
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-8"><i class="fa fa-minus"></i> &nbsp; Treatment Advice</button>
        <div class="" id="collapse-8" aria-labelledby="heading-8" style="padding: 17px;">
        	     <div class="row"  >
                      <div class="col-xs-12 col-md-3 col-sm-5">
                        <label for="treatmentAdvice" style="color:rgba(75,75,75, 0.7);"><b>Treatment Advice:</b></label>
                      </div>
                      <div class="form-group col-xs-12 col-md-11 col-sm-12">
                        <textarea class="form-control" onblur="countChar(this,'charNumTreat');abortMic(this);" id="treatmentAdviceId" name="treatmentAdvice" maxlength="2000" placeholder="Drugs should not be prescribed in this field. This is for recording general guidelines about the treatment such as Diet restrictions, physical activities, etc." onkeyup="countChar(this,'charNumTreat')"></textarea>
                        <p align="right">
							  <label>characters remaining: <span id="charNumTreat" title="2000">2000</span></label>
						</p>
                         <div class="micDiv">
                                 <i  class="start-btn fas fa-microphone-slash" ></i>
                                 <i  style="display:none;" class="stop-btn fas fa-microphone  blink"></i>
						</div> 
                        <div style="position: absolute;top: 0;right: 16px;">
						<button type="button" onclick="$(this).parent().parent().find('#treatmentAdviceId').val('');" class="btn btn-sm btn-default reasonOfVisitCleanBtn"><i class="glyphicon glyphicon-remove"></i></button>
						</div>
                      </div>
                    
                      
                      <div class="col-xs-3 col-sm-1" style="padding-right: 0px; text-align: center;">
                          <button type="button" style="padding: 0px;color:#3696e9" class="btn-his progressNoteMacroBtn" id="treatmentAdviceIdDiv" value="progressNoteMacroModal4Div" onclick="$('#progressNoteMacroModal4').modal('show');"> <!--  onclick="$('#progressNoteMacroModal').modal('show');" <i class="material-icons" style="font-size: 1.5em">message</i> --><i class="fa fa-comments" style="font-size: 1.5em;display:none;"></i></button>
                      </div>
                </div>
                <!--  Alergy Starts -->
                <div class="row"  >
                      <div class="col-xs-12 col-md-3 col-sm-5">
                        <label for="treatmentAdvice" style="color:rgba(75,75,75, 0.7);"><b>Alergy:</b></label>
                      </div>
                </div>  
                 <div class="row"  >
                 	<div class="col-xs-12">
                		<div class="table-responsive">
                          <table id="allergiesDtlListTable" class="table table-condensed table-hover" style="margin-bottom: 0px;"> 
                            <thead>
                              <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
                                <th><input type="checkbox" class="allergiesDtlChkAll" name="allergiesDtlChkAll"></th><th>Allergy Name</th><th>Sensitivity</th><th>Duration(yrs)</th><th>Symptoms</th><th>Allergy Site</th><th>Advice</th><th>Action</th>
                              </tr>
                            </thead>
                            <tbody>
                            
                            </tbody> 
                        </table>
                      	</div>                      
					</div>
				</div>	
                 <div class="row">
                   <div class="form-group col-md-2">
                     <p style="letter-spacing:0"><label>Allergy Name</label></p>
                     <div class="input-group">
                       <input type="text" placeholder="Allergy Name" allergynamecode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR4" id="txt-snomed-ct-search_VR4" onclick="load_UNIVD4('VR4','SUBSTANCE','')" autocomplete="on">
                       <div class="input-group-btn">
                         <button class="btn btn-default allergyNameCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                       </div>
                     </div>
                   </div>
                   <div class="form-group col-md-2">
                       <p style="letter-spacing:0"><label>Sensitivity</label></p>
                       <select class="form-control" name="allergiesSensitivityCode" id="allergiesSensitivityCodeId">
                         <option value="-1" selected="selected">Select Value</option>    
                         <option value="11">Type 1</option>
                         <option value="12">Type 2</option>
                         <option value="13">Type 3</option>
                         <option value="14">Type 4</option>
                         <option value="15">Type 5</option>
                       </select>
                   </div>
                   <div class="form-group col-md-2">
                     <p style="letter-spacing:0"><label>Duration(yrs)</label></p>
                     <input type="text" class="form-control" placeholder="No." name="allergiesDuration" id="allergiesDurationId" onkeypress="return isNumber(event)">
                   </div>
                   <div class="form-group col-md-2">
                       <p style="letter-spacing:0"><label>Allergy Side</label></p>
                       <div class="input-group">
                         <input type="text" placeholder="Side" allergysitecode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR5" id="txt-snomed-ct-search_VR5" autocomplete="on" onclick="load_UNIVD5('VR5','','')">
                         <div class="input-group-btn">
                           <button class="btn btn-default allergySiteCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                         </div>
                       </div>
                   </div>
                   <div class="form-group col-md-2">
                     <p style="letter-spacing:0"><label>Symptoms</label></p>
                     <div class="input-group">
                       <input type="text" placeholder="Symptoms" allergysymptomscode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR6" id="txt-snomed-ct-search_VR6" autocomplete="on" onclick="load_UNIVD6('VR6','','')">
                       <div class="input-group-btn">
                         <button class="btn btn-default allergySymptomsCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                       </div>
                     </div>
                   </div>
                   <div class="form-group col-md-1">
                     <p style="letter-spacing:0"><label>Remarks</label></p>
                     <textarea class="form-control" name="allergiesDtlRemarks" id="allergiesDtlRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                   </div>
                   <div class="form-group col-md-1">
                   	<p style="letter-spacing:0"><label></label></p>
                     <button class="btn-his allergiesDtlAddRows" type="button" style="margin-top: 10px;">Add</button>
                   </div>
                 </div> 

                 <div class="row">
                   <div class="col-xs-12 col-md-3 col-sm-5">
                     <label for="otherAllergies" style="color:rgba(75,75,75, 0.7);"><b>Other Allergies:</b></label>
                   </div>
                   <div class="form-group col-xs-12 col-md-11 col-sm-12">
                     <textarea class="form-control" id="otherAllergiesId" name="otherAllergies" maxlength="2000" onkeyup="countChar(this,'charNumOthAll');" onblur="countChar(this,'charNumOthAll');"></textarea>
                     <p align="right">
		  			<label>characters remaining: <span id="charNumOthAll" title="2000">2000</span></label>
	 				 </p>
                   </div>
                 </div>  
                <!--  Alergy Ends -->    
        </div>
    </div>
	<!--  Treatment Advice Ends -->
	
	
	
	
	
	
<!--  Transfer Patient Starts -->
	<div class="card cardPrescription" id='TransferMainDiv'  >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-15"><i class="fa fa-plus"></i> &nbsp; Transfer Patient</button>
        <div class="collapse" aria-expanded="false" id="collapse-15" aria-labelledby="heading-15" style="padding: 17px;">
                    <!-- Internal Referral Starts -->
				              <div class='row referRow' id='InternalRefDiv' >				              	
                          		<div class="col-sm-12 table-responsive"  id='divInternalReffralList' style="display: none;">
                          			   <table id="TransferListTable" class="table table-condensed table-hover" style="margin-bottom: 10px;"> 
				                            <thead>
				                              <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
				                                <th style='width:40%'>Speciality Name</th>
				                                <th style='width:50%'>Transfer Note</th>
				                                <th style='width:10%'>&nbsp;</th>
				                              </tr>
				                            </thead>
				                            <tbody></tbody> 
				                        </table>
                          		</div>
				              	<div class="col-sm-3 col-md-3 form-group" >
					              	<p style="letter-spacing:0"><label>Transfer To Speciality :</label></p>		
	                          		<select class="form-control"  id="refferlPatientDeptId" name="refferlPatientDept" >
			                             <option value="0#0#0#0#0#0#0#0">Select Speciality</option>                        	
			                         </select>
		                   		</div>
		                   		 <div class="col-sm-3 col-md-3 form-group" >
		                   		 	<p style="letter-spacing:0"><label>Transfer Note :</label></p>
                           			<textarea class="form-control" name="refferalReson" id="refferalResonId" 
                           			rows="1" style="height:34px;" placeholder="Enter Referral Note"></textarea>
                          		  </div>
                          		  <div class="form-group col-sm-3 col-md-3" >
								   		<button class="btn-his"  style="margin-top: 37px;" style="margin-top: 37px;" id="btnAddInternalReffral" type="button" >Add</button>
								   </div>
                          
				              </div>
				              <!-- Internal Referral Ends -->
                          
                         
           </div>
    </div>
	<!--  Transfer Patient Ends -->
	
	
	
	<!--  Follow Up And Visit Summary Starts -->
	<div class="card cardPrescription" id='FollowupMainDiv' >
        <button class="btn accordionbtn accordionCollapse"  type="button" data-toggle="collapse" data-target="#collapse-14"><i class="fa fa-plus"></i> &nbsp;Visit Summary</button>
        <div class="collapse" id="collapse-14" aria-labelledby="heading-14" style="padding: 17px;">
                  	 <!-- <button type="button" class="btn btn-info btn-sm followUpDocumentUpload" style="float:right; background-color:#517fa4; border:0px;display: none;" onclick="$('#followUpDocUploadModal').modal('show');">Upload Document</button> -->
                     <div align="right"> <input type="button" class="btn-his-outline" onclick="OpenFileUpload(this)" value="File Upload"></div>  
                     <div class="row">
                       <div class="col-sm-2">
                          <p><label>End Treatment</label></p> 
                       </div>
                       <div class="col-sm-10">
                          <p><label><input type="radio" name="endTreatment" value="1" onchange="endTreatmentFun(this)"> Yes</label>&nbsp;<label><input type="radio" name="endTreatment" value="0" onchange="endTreatmentFun(this)" checked> No</label></p>
                       </div>
                     </div>
                      <div class="row followUpPlannedVisit">
                        <div class="col-xs-8 col-sm-2">
                          <p><label>Planned Visit Date</label></p> 
                        </div>
                        <div class="col-xs-4 col-sm-2" style="margin-top:12px;">
                        	<a class="followUpPlannedVisitRefresh"><i class="glyphicon glyphicon-refresh" id="followUpPlannedVisitRefreshId" data-toggle="tooltip" data-original-title="Clear All"></i></a>
                        </div>
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                        <div class="col-sm-1">
                          <label><input type="checkbox" name="followUpPlannedVisitSos" id="followUpPlannedVisitSosId" checked> SOS</label>
                        </div>
                        <div class="col-sm-2">
                          <div class="col-xs-8 col-sm-8" style="padding: 0 1px">
                            <input class="form-control" type="text" placeholder="Days" name="followUpPlannedVisitDays" id="followUpPlannedVisitDaysId" tabindex="12">
                          </div>
                          <div class="col-xs-4 col-sm-4" style="padding: 0 1px">
                            <label style="color:rgba(75,75,75, 0.7); letter-spacing:0.5; font-size:14px">Days</label>
                          </div> 
                        </div>
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                        <div class="col-sm-4">
                          <div class="col-xs-8 col-sm-8" style="padding: 0 1px">
                            <input class="form-control" type="date" style="line-height: normal;" name="followUpPlannedVisitDate" id="followUpPlannedVisitDateId">
                          	<!-- <input class="form-control date-picker-start" type="text" placeholder="mm/dd/yyyy" style="line-height: normal;"  name="followUpPlannedVisitDate" id="followUpPlannedVisitDateId"> -->
                          </div>
                          <div class="col-xs-4 col-sm-4" style="padding: 0 1px">
                            <label style="color:rgba(75,75,75, 0.7); letter-spacing:0.5; font-size:14px">Scheduled Date</label>
                          </div> 
                        </div>
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                        <!-- <div class="col-sm-2">
                        	<a class="followUpPlannedVisitRefresh"><i class="glyphicon glyphicon-refresh"></i></a>
                        </div> -->
                        <div class="clearfix visible-xs" style="margin-top:5px;"></div>
                      </div>
                      <div class="clearfix" style="padding:5px 0"></div>
                      <div class="row">
                        <div class="col-sm-2">
                          <p><label>Clinical Notes</label></p>
                        </div>
                        <div class="col-xs-3 col-sm-1" style="padding-right: 0px; text-align: center;">
                          <button type="button" style="padding: 0px;color:#3696e9" class="btn-his progressNoteMacroBtn" id="progressNoteDiv" value="progressNoteMacroModal6Div" onclick="$('#progressNoteMacroModal6').modal('show');" ><!-- <i class="material-icons" style="font-size: 1.5em">message</i> --><i class="fa fa-comments" style="font-size: 1.5em;display:none;"></i></button>
                        </div>
                        <div class="col-xs-9 col-sm-9">
                          <textarea class="form-control" onblur="countChar(this,'charNumPrgNote');abortMic(this);" id="progressNote" name="progressNote" rows="7" maxlength="5000" placeholder="Enter Clinical Notes"  tabindex="13" onkeyup="countChar(this,'charNumPrgNote');"></textarea> 
                          <p align="right">
							  <label>characters remaining: <span id="charNumPrgNote" title="5000">5000</span></label>
							</p>
						<div class="micDiv">
                                 <i style="display:none" class="stop-btn fas fa-microphone blink" ></i>
                                 <i   class="start-btn fas fa-microphone-slash"></i>
                         
						</div> 
						<div style="position: absolute;top: 0;right: 16px;">
						<button type="button" onclick="$(this).parent().parent().find('#progressNote').val('');" class="btn btn-sm btn-default reasonOfVisitCleanBtn"><i class="glyphicon glyphicon-remove"></i></button>
						</div>
						
						  <p class="no-browser-support" style="display: none;">Browser Doesn't Support Speech API (Use Google Chrome)</p> 
                        </div>
                        
                      </div>
        </div>
    </div>
	<!--  Follow Up And Visit Summary Ends -->
	
</div>
<!-- accordionOPDDesk  Ends -->                 
                 
 
 
                              
          
                  
                  
                  
                  
                  
                  
                  
                  
              
                 
                  
                  
                  
                  
                  
                   
                   
                  
                  
                  
                  
                  
                 
                 
                  
                  <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                  
                  <div class='rx-footer' >
                  	<div class='row'>
                  	    <div class="col-sm-12 text-center">
					    	<button type="button" class="btn-his" onclick="Save('printSave',this , 0)">Preview & Save</button>
                  			<a  class="prescPrintBtn1" data-toggle="modal"  style="display:none"><button class="btn-his">Bookmark this Rx</button></a> 
                  			<a  class="prescPrintBtn" data-toggle="modal" ><button class="btn-his-outline" >Bookmark this Rx</button></a>
                  	</div>
                  	</div>
                  </div> 
          
    <div class="modal fade" id="sectionBookmark" role="dialog">
	    <div class="modal-dialog modal-lg">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" onclick="localStorage.setItem('refWindowFlag','0');ChangePatRefFlag(this);">&times;</button>
	          <h4 class="modal-title" style="font-weight:bold" id='SectionBookMarkHeadingName'>Template Section</h4>
	        </div>
	        <div class="modal-body">
	        	  <div class='row'>
	                 <div class="col-xs-12 col-sm-6 ">
	                    <p style="letter-spacing:0"><label>Template Name</label></p>
	                    <input type="text" class="form-control" name="sectionTemplateName" id="sectionTemplateName" maxlength="50" />
	                    <span id='jsonSectionBookmark' style="display: none;"></span>
	                 </div>	                 
	              </div>
	              <div class='row'>
	              	<div class="col-xs-12 col-sm-12 " id='dataToBookmark' style="margin-top: 30px;">
	                </div>
	              </div>  
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-his"  onclick="SaveBookmarkTemplate()">Save</button>
	          <input type='hidden' name="bookmarkTypeId" id="bookmarkTypeId" value="">
	        </div> 
	      </div>      
	    </div>
   </div>
   
   <div class="modal fade" id="sectionBookmarkManage" role="dialog">
	    <div class="modal-dialog modal-xl">
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal" onclick="localStorage.setItem('refWindowFlag','0');ChangePatRefFlag(this);">&times;</button>
	          <h4 class="modal-title" style="font-weight:bold" id='SectionBookMarkHeadingName'>Edit /Delete Template</h4>
	        </div>
	        <div class="modal-body">
	        	  <div class='row'>
	                 <div class="col-xs-12 col-sm-6 ">
	                    <p style="letter-spacing:0"><label>Template Name</label></p>
	                    <select class='form-control' id='templateModify'  name="templateModify" onchange="populateTemplateDataForModify(this)">	                    
	                    </select>
	                 </div>
	                 <div class="col-xs-12 col-sm-6 " id='divEditTemplateName' style="display:none;">
	                    <p style="letter-spacing:0"><label>Template Name(For Edit)</label></p>
	                    <input type="text" class="form-control" id='sectionTemplateNameModify'  name="sectionTemplateNameModify" maxlength="250" />
	                 </div>		                 
	              </div>
	              
	              <div class='row'>
	              	<div class="col-xs-12 col-sm-12 " id='dataBookmarkModify' style="margin-top: 30px;">
	                </div>
	              </div>  
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn-his-outline-danger btnTemplate"  style="display: none;" onclick="DeleteBookmarkTemplate()">Delete</button>&nbsp;&nbsp;	          
	          <button type="button" class="btn-his btnTemplate" style="display: none;" onclick="EditBookmarkTemplate()">Save</button>
	          <button type="button" class="btn-his-outline btnTemplate"  style="display: none;" onclick="LoadTemplate()">Use This Template</button>	&nbsp;&nbsp;
	          <input type='hidden' name="bookmarkTypeIdForModify" id="bookmarkTypeIdForModify" value="">
	          <input type='hidden' name="bookmarkTypeIdForModify" id="bookmarkSNoForModify" value="">
	        </div> 
	      </div>      
	    </div>
   </div>
          
                            	
<script>
function endTreatmentFun(e){
	if(e.value=='0')
	{
		$('input[name=endTreatment]').val('1');
			$('.followUpPlannedVisit').show();
		}
	else
	{
		$('input[name=endTreatment]').val('0');
		$('.followUpPlannedVisit').hide();
		}
	}
</script>
                </div>
                 <div class="col-sm-3 col-md-3 patSummaryTile" style="display:none;  background-size: cover;padding:5px; margin-top:inherit ; min-height: 618px;">
                 <!--  <img id="patSummaryTileImg"   class="img-circle img-responsive" style="width: 70px; float: right;"> -->
                  <h2 style="margin-top: 0px;margin-bottom: 20px;font-family: 'Cormorant Upright', serif;">Patient Summary</h2>
                  <!-- <h5 style="margin: 0px;">Patient Name : <font id="patSummaryNameGenAgeCat"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br>
                  <h5 style="margin: 0px;">CRN : <font id="patSummaryCRN"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br>  -->
                  
                    <div class="row">
                      <div class="column" style="background-color:#86bfa0;padding:15px;">
					      <h4 style="color:white"><label>Visit Summary</label></h4>
					    <h5>Current Visit No : <font id="patEpisodeVisitNoPrescriptionPanel"></font> (<font id="patVisitTypePrescriptionPanel"></font>)</h5>
                  <h5>Last Visited On : <font id="patLastVisitDatePrescriptionPanel"></font></h5>
					  </div>
					</div>
                    <div class="row">
                      <div class="column vitalPS" style="background-color:#007cff61;padding:15px;">
					    <h4 style="color:white"><label>Vitals</label></h4>
					    <p style="color:white;font-weight: normal" id="patVitalSingsDatePrescriptionPanel"></p>
					  </div>
					  <div class="column chrDiseasePS" style="background-color:#6e93a6;padding:10px;">
					    <h4 style="color:white"><label>Chronic Profile</label></h4>
					    <p style="color:white" id="patChronicDiseasePrescriptionPanel"></p>
					  </div>
					  
					</div>
					<div class="row">
                      <div class="column currAdmPS" style="background-color:#bb9d83;padding:15px;">
					    <h4 style="color:white"><label>Complaints/Diagnosis/History</label></h4>
					    <h5 style="color:white" class="ccheader"><label>Chief Complaint:</label></h5>
					    <p style="color:white" class="ccDtl" id="patChiefCompDatePrescriptionPanel"></p>
					    <h5 class="hopiheader"><label>History of present illness:</label><font id="patHoplDatePrescriptionPanel"></font></h5>
					    <!-- <h5 style="color:white" class="hopiheader">HOPI :</h5>
					    <p style="color:white" id="patHoplDatePrescriptionPanel"></p> -->
					    <h5 style="color:white" class="diagheader"><label>Diagnosis:</label></h5>
					    <p style="color:white" id="patDiagnosisDatePrescriptionPanel"></p>
					  </div>					  
					</div>
					
					<div class="row">
					  <div class="column curMediPS" style="background-color:#6895d0c4;padding:10px;">
					    <h4 style="color:white"><label>Medication</label></h4>
					    <p style="color:white" id="patMedicineDatePrescriptionPanel"></p>
					  </div>
					  <div class="column labTestPS" style="background-color:#ec7da7;padding:10px;">
					    <h4 style="color:white"><label>Recent Investigations</label></h4>
					    <p style="color:white" id="patRecentLabTestPrescriptionPanel"></p>
					  </div>
					</div>
           			<div class="row">
					  <div class="column clincalProPS" style="background-color:#82b0b0;padding:10px;">
					    <h4 style="color:white"><label>Clinical Procedures</label></h4>
					    <p style="color:white" id="patClinicalProDatePrescriptionPanel"></p>
					  </div>
					  <div class="column allergiesPS" style="background-color:#231b4d8c;padding:10px;">
					    <h4 style="color:white"><label>Allergies</label></h4>
					    <p style="color:white" id="patAllergiesPrescriptionPanel"></p>
					  </div>
					</div>
                    <div class="row" id="patRecentUmidTilesPrescriptionPanel" >
					  <div class="column" style="background-color:#95938e;padding:15px;">
					    <h4 style="color:white"><label>UMID Demographics</label></h4>
					    <h5>UMID : <font id="patRecentUmidTestPrescriptionPanel"></font></h5>
					    <h5>Email Id : <font id="patRecentEmailTestPrescriptionPanel"></font></h5>
					    <h5>Validity : <font id="patRecentValidityTestPrescriptionPanel"></font></h5>
					    <h5>Status : <font id="patRecentStatusTestPrescriptionPanel"></font></h5>
					    <h5>Age : <font id="patRecentAgeTestPrescriptionPanel"></font></h5>
					    <h5>Blood Group : <font id="patRecentBloodTestPrescriptionPanel"></font></h5>
					    <h5>Handicapped : <font id="patRecentHandicappedTestPrescriptionPanel"></font></h5>
					    <h5>Level of entitlement : <font id="patRecentLevelOfEntitlementTestPrescriptionPanel"></font></h5>
					    <h5>Department : <font id="patRecentDepartmentTestPrescriptionPanel"></font></h5>
					    <h5>OPD Elegibility : <font id="patRecentOPDElegibilityTestPrescriptionPanel"></font></h5>
					    <h5>IPD Elegibility : <font id="patRecentIPDElegibilityTestPrescriptionPanel"></font></h5>
					    <h5>Beneficiary : <font id="patRecentBeneficiaryTestPrescriptionPanel"></font></h5>
					    <h5>Designation : <font id="patOccupationTestPrescriptionPanel"></font></h5>
					    <h5>Station : <font id="patStationTestPrescriptionPanel"></font></h5>
					    <br>
					  </div>
					 </div>
                    <!-- <div id="patRecentUmidTilesPrescriptionPanel">
                    
                    <h5 style="margin: 0px;">UMID :<font id="patRecentUmidTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     <h5 style="margin: 0px;">Email Id :<font id="patRecentEmailTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     
                     <h5 style="margin: 0px;">Validity :<font id="patRecentValidityTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     
                     
                     <h5 style="margin: 0px;">Status :<font id="patRecentStatusTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     
                     <h5 style="margin: 0px;">Age :<font id="patRecentAgeTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     <h5 style="margin: 0px;">Blood Group :<font id="patRecentBloodTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     
                     <h5 style="margin: 0px;">Handicapped :<font id="patRecentHandicappedTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                     
                     
                     <h5 style="margin: 0px;">Level of entitlement :<font id="patRecentLevelOfEntitlementTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                    
                      <h5 style="margin: 0px;">Department :<font id="patRecentDepartmentTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                    
                      <h5 style="margin: 0px;">OPD Elegibility :<font id="patRecentOPDElegibilityTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                    
                    
                      <h5 style="margin: 0px;">IPD Elegibility :<font id="patRecentIPDElegibilityTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                     
                      <h5 style="margin: 0px;">Beneficiary :<font id="patRecentBeneficiaryTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                    
                      <h5 style="margin: 0px;">Designation :<font id="patOccupationTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br>
                    
                     <h5 style="margin: 0px;">Station :<font id="patStationTestPrescriptionPanel"></font></h5>
                    <p style="font-weight: normal;"></p>
                    <br> 
                    
                     </div>
                    <button class="btn btn-info prescImgFixedTriggerBtn" onclick="prescImgFixedTriggerFun('0')" type="button">page</button>
                    <p><button type="button" style="padding-left:0;" class="btn-his patPrescView" onclick="$('#patPrescViewModalTriggerBtn').click();">Prescription View</button></p>
                    <div id="tree"></div> -->
                    
                </div> 
                <!-- <div class="col-xs-0 col-sm-0 col-md-1"></div> -->
              </div>   
          </div>
        </div> 
        
        
        <!-- <div class="modal fade" id="allergiesModal" role="dialog" data-backdrop="static" data-keyboard="false">
          <div class="modal-dialog modal-lg" style="width:80vw;">       Modal content
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">x</button>
                  <h2 class="modal-title text-left">Add Allergies</h2>
              </div>
              <div class="modal-body" style="text-align: left;"> 
                <div class="table-responsive">
                  <table id="allergiesDtlListTable" class="table table-condensed table-hover" style="margin-bottom: 0px;"> 
                    <thead>
                      <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
                        <th><input type="checkbox" class="allergiesDtlChkAll" name="allergiesDtlChkAll"></th><th>Allergy Name</th><th>Sensitivity</th><th>Duration(yrs)</th><th>Symptoms</th><th>Allergy Site</th><th>Advice</th><th>Action</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr> 
                        <td><input type="checkbox" class="allergiesDtlChkAll" name="allergiesDtlChk" value="91935009"></td>
                        <td>Allergy to Peanuts</td>
                        <td>Type 1</td>
                        <td>1</td>
                        <td>Swollen Face</td>
                        <td>Face</td>
                        <td><a class="allergiesDtlInstructionsModalBtn" style="color: #109f1c" allergyInstructions="Avoid Peanuts" onclick="$('#allergiesDtlInstructionsModal .modal-body p').text($(this).attr('allergyInstructions'));$('#allergiesDtlInstructionsModal').modal('show');">Avoi..</a></td>
                        <td><button class="btn btn-sm btn-danger allergiesDtlRemoveRow" onclick="$(this).parent().parent().remove();" id="removeBtnId2">Remove</button></td>
                      </tr>
                    </tbody>
                </table>
              </div>

              <br>

              <div class="row">
                <div class="form-group col-md-2">
                  <p style="letter-spacing:0"><label>Allergy Name</label></p>
                  <div class="input-group">
                
                    <input type="text" placeholder="Chief Complaint" allergyNameCode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR4" id="txt-snomed-ct-search_VR4" autocomplete="on" onclick="load_UNIVD4('VR4','','450970008')" >
                    <div class="input-group-btn">
                      <button class="btn btn-default allergyNameCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                    </div>
                    <div class="concept" id="conceptdiv_4"></div>
				  <input type="hidden" name="targetId4"> 
                  </div>
                  
                </div>
                <div class="form-group col-md-2">
                    <p style="letter-spacing:0"><label>Sensitivity</label></p>
                    <select tabindex="1" class="form-control" name="allergiesSensitivityCode" id="allergiesSensitivityCodeId">
                      <option value="-1" selected="selected">Select Value</option>    
                      <option value="11">Type 1</option>
                      <option value="12">Type 2</option>
                      <option value="13">Type 3</option>
                      <option value="14">Type 4</option>
                      <option value="15">Type 5</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                  <p style="letter-spacing:0"><label>Duration(yrs)</label></p>
                  <input type="text" class="form-control" placeholder="No." name="allergiesDuration" id="allergiesDurationId" onkeypress="return isNumber(event)">
                </div>
                <div class="form-group col-md-2">
                    <p style="letter-spacing:0"><label>Allergy Site</label></p>
                    <div class="input-group">
                      <input type="text" placeholder="Site" allergySiteCode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR5" id="txt-snomed-ct-search_VR5" autocomplete="on">
                      <div class="input-group-btn">
                        <button class="btn btn-default allergySiteCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                      </div>
                    </div>
                </div>
                <div class="form-group col-md-2">
                  <p style="letter-spacing:0"><label>Sytmptoms</label></p>
                  <div class="input-group">
                    <input type="text" placeholder="Symptoms" allergySymptomsCode="" class="form-control clearable ui-autocomplete-input x onX" name="txt-snomed-ct-search_VR6" id="txt-snomed-ct-search_VR6" autocomplete="on">
                    <div class="input-group-btn">
                      <button class="btn btn-default allergySymptomsCleanBtn" type="button"><i class="glyphicon glyphicon-remove"></i></button>
                    </div>
                  </div>
                </div>
                <div class="form-group col-md-2">
                  <p style="letter-spacing:0"><label>Remarks</label></p>
                  <textarea class="form-control" name="allergiesDtlRemarks" id="allergiesDtlRemarksId" rows="1" style="height:34px;" placeholder="Remarks"></textarea>
                </div>
                <div class="form-group col-md-1">
                  <button class="btn-his allergiesDtlAddRows">Add</button>
                </div>
              </div> 

              <div class="row">
                <div class="col-xs-12 col-md-3 col-sm-5">
                  <label for="otherAllergies"><b>Other Allergies:</b></label>
                </div>
                <div class="form-group col-xs-12 col-md-12 col-sm-12">
                  <textarea class="form-control" id="otherAllergiesId" name="otherAllergies" maxlength="2000"></textarea>
                </div>
              </div>   

            </div>  
          </div> 
			
            </div>  
              </div>  -->
              
              
         
          
<!-- Added by Timsi for Patient Referal Modal******************************************************* -->        
<div class="modal fade" id="patreferal" role="dialog">
    <div class="modal-dialog modal-lg">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" onclick="localStorage.setItem('refWindowFlag','0');ChangePatRefFlag(this);">&times;</button>
          <h4 class="modal-title" style="font-weight:bold">PATIENT REFERAL</h4>
        </div>
        <div class="modal-body">
          <!-- <div class="text-center">
       	  	<button type="button" class="btn btn-warning" onclick="$('#patreferal').modal('hide');$('#patreferalFrameId').remove();localStorage.setItem('refWindowFlag','0');">Cancel</button>
		  </div> -->
        </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
      
    </div>
  </div>

<!-- ******************************************************* -->
       		<!-- <div id="patreferal" class="tab-pane fade">
	          	<input type='button' onclick='openRefPage(this);'>
            </div>  -->
           
          
        </div>
 

      <input type="hidden" name="patGeneralDtl" id="patGeneralDtl" />
       <input type="hidden" name="cardValidityStatus" id="cardValidityStatus" />
       <input type="hidden" name="cardColor" id="cardColor" />
      <input type="hidden" name="patientPhotoName" id="patientPhotoName" />
      
      <input type="hidden" name="parentWellnessCenter" id="parentWellnessCenter" />
      <input type="hidden" name="internalqueueno" id="internalqueueno" />
      <input type="hidden" name="internamequeuenovisit" id="internamequeuenovisit" />
      <input type="hidden" name="queuesymbol" id="queuesymbol" />
      <input type="hidden" name="displayqueueno" id="displayqueueno" />
      <input type="hidden" name="queuestatus" id="queuestatus" />
      <input type="hidden" name="proxy_flag" id="proxy_flag" value="0" />
      <input type="hidden" name="mobileNo" id="mobileNo" value="" />
      
     
      
       
      
       
      <input type="hidden" name="patCompleteGeneralDtlPrescriptionPanel" id="patCompleteGeneralDtlPrescriptionPanel" />  
      <input type="hidden" name="eTeleconsultancyreq" id="eTeleconsultancyreqId" /> 
      <input type="hidden" name="isPatReferred" id="isPatReferredId" />  
      <input type="hidden" name="strHospitalAddres" value="<%=request.getSession().getAttribute("HOSPITAL_ADDRESS").toString() %>"/>
	  <input type="hidden" name="strHospitalName" value="<%=request.getSession().getAttribute("HOSPITAL_NAME").toString() %>"/>
	  <input type="hidden" name="strConsultantName" id="strConsultantName" value="<%=request.getSession().getAttribute("UserName").toString() %>"/>
	   <input type="hidden" name="hrpflag" value="1">
		 <input type="hidden" name="isModify" id='isModify' value="0">
		 <input type="hidden" name="hospitalShortName" id='hospitalShortName' value="<%=objHospitalMstVO.getHospitalShortName() %>">
		  
		 
		 
		<!--  <input type="hidden" name="currentBserviceId" value='1' /> -->
			 
			 
<script>


/*
$(document).ready(function(){
	var dtVal = new Date(); 
 	var curDate = dtVal.getDate();
 	curDate = curDate.toString().length>1 ? curDate : "0"+curDate;
 	var curMon = dtVal.getMonth();
 	//curMon = curMon.toString().length>1 ? curMon : "0"+curMon;
 	//alert(curDate+'------: '+curMon);

 	var months = new Array(12);
 	months[0] = "January";
 	months[1] = "February";
 	months[2] = "March";
 	months[3] = "April";
 	months[4] = "May";
 	months[5] = "June";
 	months[6] = "July";
 	months[7] = "August";
 	months[8] = "September";
 	months[9] = "October";
 	months[10] = "November";
 	months[11] = "December";

 	var maxDate = curDate+" "+months[curMon] +" "+dtVal.getFullYear();

 	//alert(months[curMon]);
 	//alert("maxDate---> "+maxDate.toString());
 	//alert("listdatefilter val --> "+$('#listDateFilter').val());
 	
 	if($('#listDateFilter').val() == maxDate.toString())
 	{
 		if($('#patreferal').find('iframe').length == 0)
 		{
 			window.patCrNo = $('#patCrNoPrescriptionPanel').text();
 			var targetURL= "/HISRegistration/registration/transactions/NEWDRDESKPatientReferral.action?varSSOTicketGrantingTicket=" + parent.document.getElementsByName("varSSOTicketGrantingTicket")[0].value;

 			$('#patreferal .modal-body').prepend("<iframe  id='patreferalFrameId' src='"+targetURL+"' style='width:100%;height:100vh;border:0px solid grey;'></iframe>");
 			localStorage.setItem('refWindowFlag','0');
 			//$('#patreferal').modal('show');
 			//window.open(targetURL);
 			// <iframe style="width:100%; height:100%; border:0px solid grey;" src="/HISRegistration/registration/transactions/PatientReferral.action"></iframe>
 		}
 	 }
 	 else
 	{ 
 	 	swal('Patient did not visit today and hence cannot be referred.').then(function(){
 	 		$('#patreferal').find('.modal-footer button:first-child').click();
	 	});
 	 } 
		
});
*/

function openRefPage(e)
{
	var dtVal = new Date(); 
 	var curDate = dtVal.getDate();
 	curDate = curDate.toString().length>1 ? curDate : "0"+curDate;
 	var curMon = dtVal.getMonth();
 	//curMon = curMon.toString().length>1 ? curMon : "0"+curMon;
 	//alert(curDate+'------: '+curMon);

 	var months = new Array(12);
 	months[0] = "January";
 	months[1] = "February";
 	months[2] = "March";
 	months[3] = "April";
 	months[4] = "May";
 	months[5] = "June";
 	months[6] = "July";
 	months[7] = "August";
 	months[8] = "September";
 	months[9] = "October";
 	months[10] = "November";
 	months[11] = "December";

 	var maxDate = curDate+" "+months[curMon] +" "+dtVal.getFullYear();

 	$('#patreferal').modal({
	  backdrop: 'static',
	  keyboard: false
	});
 	//alert(months[curMon]);
 	//alert("maxDate---> "+maxDate.toString());
 	//alert("listdatefilter val --> "+$('#listDateFilter').val());
 	if($('#listDateFilter').val() == maxDate.toString())
 	{
 	 	if($('#patreferal').find('iframe').length == 0)
 		{ 
 	 		window.patCrNo = $('#patCrNoPrescriptionPanel').text();
 			var targetURL= "/HISRegistration/registration/transactions/NEWDRDESKPatientReferral.action?varSSOTicketGrantingTicket=" + parent.document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
 			$('#patreferal .modal-body').prepend("<iframe id='patreferalFrameId' src='"+targetURL+"' style='width:100%;height:70vh;border:0px solid grey;'></iframe>");
			$('#patreferal').modal('show');
 			//window.open(targetURL);
 			// <iframe style="width:100%; height:100%; border:0px solid grey;" src="/HISRegistration/registration/transactions/PatientReferral.action"></iframe>
 		}
 	 }
 	else
 	{ 
 		swal('Patient did not visit today and hence cannot be referred.').then(function(){
 	 	 	$('#patreferal').find('.modal-footer button:first-child').click();
	 	});
 	 }
}

function ChangePatRefFlag(e){
	var patReferedOrNotFlag=localStorage.getItem('patReferedOrNotFlag');
	if(patReferedOrNotFlag=='1'){
		window.parent.patEpisodeCode=$('#patEpisodeCodePrescriptionPanel').text();
		window.parent.patHospitalCode=$('#patHospitalCodePrescriptionPanel').text();
		window.parent.patSeatId=$('#patSeatIdPrescriptionPanel').text();
		window.parent.patCrNo=$('#patCrNoPrescriptionPanel').text();
		window.parent.patVisitNo=$('#patEpisodeVisitNoPrescriptionPanel').text();
		//alert("episode code --->> "+window.parent.patEpisodeCode+ " "+window.parent.patHospitalCode+" "+window.parent.patSeatId+" "+window.parent.patVisitNo+" "+window.parent.patCrNo);
		var patRefJSON = {
			'CrNo':window.parent.patCrNo,
			'EpisodeCode':window.parent.patEpisodeCode,
			'HospitalCode':window.parent.patHospitalCode,
			'SeatId':window.parent.patSeatId,
			'VisitNo':window.parent.patVisitNo
		};
		//var data1=JSON.parse(patRefJSON);
		var data = JSON.stringify(patRefJSON);
		console.log("patRefJSON --->> "+patRefJSON); 
		//alert(patRefJSON);
		$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/referPatient/',type:'POST',data:{JsonData:data},success:function(result)
	    	{
	    		console.log(":::::patient refered successfully:::::::::");
	    	}
		});
		//alert("1");
	}
}

</script> 

<style>
		#drugAdvicesInstructionsModal .modal-body p{
 			word-wrap : break-word;
		}
		#chronicDiseaseInstructionsModal .modal-body p{
		    word-wrap : break-word;
		}
		#allergiesDtlInstructionsModal .modal-body p{
		 	word-wrap : break-word;
		}
</style>


<!-- <script>
$(document).ready(function(){
	//alert('2');
	$('#refferlPatientDeptId').multiselect();
	//alert('1');
	});
</script> -->
<script src="/HIS/hisglobal/drDeskAssets/dropzone/dropzone.js"></script> 

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
	/* function CloseModalPopup() {       
        $("#opdEmrModal").modal('hide');
		} */
	</script>
	
	<style>
		@media print {
		  .tooltip { visibility: hidden; }
		}
		.opdVitalsTile{
			 font-weight:normal !important;
			 font-size:1.0em !important;
		}
		
		body{
			padding-bottom:80px; 
		} 
		#printPrescPage{
			margin-bottom:45px; 
		} 
		.investigation{
			margin:0px !important;
		}
		.investigation li{
			text-align:left !important;
		} 
		.investigation li p{
			margin:0px !important;
			font-size:13px;
		}
		.printPrescTreatmentLst{
			margin:0px !important;
		} 
		.printPrescTreatmentLst li{
			text-align:left !important;
		} 
		.printPrescTreatmentLst li p{
			margin:0px !important;
			font-size:13px;
		}
		.printPreviousPrescPage{
			color:black !important;
			margin-bottom:45px;
		}
		.printPreviousPrescPage p{
			letter-spacing: inherit !important;
			color: #5a5a5a !important;
			font-weight:600;
		}
		.printPreviousPrescPage p small{
			font-weight: 400 !important;
			font-size: 90%;
		}
		.printPrescPatDtlTbl tr td{
			border-top: 0px solid #ddd !important;
			padding: 2px 5px;
		}
		.printPrescPatDtlTbl tr th{
			border-top: 0px solid #ddd !important;
			padding: 2px 5px;
		} 
		.printPrescPatDtlTbl{ 
			font-size: 13px;
			margin:10px 0;
		}
		.printPrescTreatmentTbl{
			font-size: 13px
		}
		.printPrescTreatmentTbl tr td{
		border-top: 0px solid #ddd !important;
		}
		.printPrescTreatmentTbl tr th{
		border-top: 0px solid #ddd !important;
		border-bottom: 0px solid #ddd !important;
		}  
		
		#watermark
		{
		 position:fixed;
		 top:42%;
		 left:25%;
		 opacity:0.1;
		 font-size: 90px;
		 z-index:-1;
		 color: black;
		 transform: rotate(-20deg);
		}
		
		.footerPastPresc{visibility: hidden;position:fixed;bottom:0;left:10px;color: #7e7e7e;} 
	
		/* @media print{
			tfoot {display: table-footer-group;}
		} */
		
		 /* @media print {
		    .previousPrescPrintBtn{
		    	visibility: hidden;
		    }
		    
		    body.modal-open {
		        visibility: hidden;
		    }
		    
		    #opdEmrModal body.modal-open .modal .modal-header{
		    	visibility: hidden;
		    }		    
		    
		    body.modal-open .modal .modal-body .opdEmrModalNavMenu .active,
		    body.modal-open .modal .modal-body .opdEmrModalNavMenuContent .active{
				visibility: visible; /* make visible modal body and header */
		    }
		} */
		#opdEmrModal.modal-body p{
		    word-wrap : break-word;
		}
		#drugAdvicesInstructionsModal.modal-body p{
		    word-wrap : break-word;
		}
		#chronicDiseaseInstructionsModal.modal-body p{
		    word-wrap : break-word;
		}
		.nav-pills>li>a {
	      background-color: #7087ce; 
	      border-color: #777777;
	      color:#fff;
	    }
	    .nav-pills>li.active>a, .nav-pills>li.active>a:hover, .nav-pills>li.active>a:focus {
	      color: #fff;
	      background-color: #666;
	      border: 1px solid #888888;
	    }
	    .nav-pills>li>a:hover {
	      border-color: #2b438a;
	      background-color: #2b438a;
	    }
	    .treeStructurePresc{
			color:black !important;
		}
		.treeStructurePresc p u{
			letter-spacing: inherit !important;
			color: #6d6db7 !important;
			font-weight:600;
		}
		.treeStructurePresc p small{
			font-weight: 400 !important;
			color: black !important;
			font-size: 90%;
		}
		/* .printPreviousPrescPage{
			width: 50em !important;
		}
		.treeStructurePresc{
			width: 50em !important;
		} */
		
		.optionalOrDiv{
	      text-align:center;
	      line-height: 2.6;
	    }
	    .alignRight{
	      text-align:right;
	    }
	    .alignLeftPaddingLeftZero{
	      text-align:left;
	      padding-left:0;
	    }
	    .paddingRightZero{
	      padding-right:0;
	    }
	    .paddingLeftRightZero{
	      padding-right:0;
	      padding-left:0;
	    }
	    .tooltip{
	        position:absolute;
	        z-index:1020;
	        display:block;
	        visibility:visible;
	        padding:5px;
	        font-size:13px;
	        opacity:0;
	        filter:alpha(opacity=0)
	    }
	    #home label{
	      font-weight: 400 !important;
	    }
	    .marginBottom{
	      margin-bottom:5px;
	    }
	    @media only screen and (max-width: 992px) and (min-width: 577px){
			 #opdEmrModal .modal-dialog {
		    	width: 95vw !important;
			}
			#TreeStructurePrescriptionModal .modal-dialog {
			    width: 95vw !important;
			}
			#VitalIDModal .modal-dialog {
			    width: 95vw !important;
			}
			#shortcutKeysModal .modal-dialog {
		    	width: 95vw !important;
			}
			#patientSearchModal .modal-dialog {
		    	width: 95vw !important;
			}
		}
		
		@media only screen and (max-width: 577px){
			#TreeStructurePrescriptionModal .TreeStructurePrescriptionModalNavMenu{
				font-size: 7px !important;	
			}
			#opdEmrModal .opdEmrModalNavMenu{
				font-size: 7px !important;	
			}
			#investigationLabReportModal .investigationModalNavMenu{
				font-size: 7px !important;	
			}
		}
	    
	</style>
	
	<style>
		@media screen {
		  #printSection {
		      display: none;
		  }
		}

		@media print {
		  body * {
		    visibility:hidden;
		  }
		  #printSection, #printSection * {
		    visibility:visible;
		  }
		  #printSection {
		    position:absolute;
		    left:0;
		    top:0;
		  }
		}
		/* .zoom:hover {
  			box-shadow: 0 1px 18px 0px #bababa; 
			 -webkit-transform: translateY(-4px);
			transform: translateY(-4px); 
		} */
		.value{
			display:inline-block;
			background:#eee;
			border-radius:3px;
			color:#777;
			line-height:20px;
			margin-left:5px;
			margin-right:5px;
		}
}
	</style>
	
 <!-- <script>
		var langs =
		[['Afrikaans',       ['af-ZA']],
		 ['Bahasa Indonesia',['id-ID']],
		 ['Bahasa Melayu',   ['ms-MY']],
		 ['Català',          ['ca-ES']],
		 ['etina',         ['cs-CZ']],
		 ['Deutsch',         ['de-DE']],
		 ['English',         ['en-AU', 'Australia'],
		                     ['en-CA', 'Canada'],
		                     ['en-IN', 'India'],
		                     ['en-NZ', 'New Zealand'],
		                     ['en-ZA', 'South Africa'],
		                     ['en-GB', 'United Kingdom'],
		                     ['en-US', 'United States']],
		 ['Español',         ['es-AR', 'Argentina'],
		                     ['es-BO', 'Bolivia'],
		                     ['es-CL', 'Chile'],
		                     ['es-CO', 'Colombia'],
		                     ['es-CR', 'Costa Rica'],
		                     ['es-EC', 'Ecuador'],
		                     ['es-SV', 'El Salvador'],
		                     ['es-ES', 'España'],
		                     ['es-US', 'Estados Unidos'],
		                     ['es-GT', 'Guatemala'],
		                     ['es-HN', 'Honduras'],
		                     ['es-MX', 'México'],
		                     ['es-NI', 'Nicaragua'],
		                     ['es-PA', 'Panamá'],
		                     ['es-PY', 'Paraguay'],
		                     ['es-PE', 'Perú'],
		                     ['es-PR', 'Puerto Rico'],
		                     ['es-DO', 'República Dominicana'],
		                     ['es-UY', 'Uruguay'],
		                     ['es-VE', 'Venezuela']],
		 ['Euskara',         ['eu-ES']],
		 ['Français',        ['fr-FR']],
		 ['Galego',          ['gl-ES']],
		 ['Hrvatski',        ['hr_HR']],
		 ['IsiZulu',         ['zu-ZA']],
		 ['Íslenska',        ['is-IS']],
		 ['Italiano',        ['it-IT', 'Italia'],
		                     ['it-CH', 'Svizzera']],
		 ['Magyar',          ['hu-HU']],
		 ['Nederlands',      ['nl-NL']],
		 ['Norsk bokmål',    ['nb-NO']],
		 ['Polski',          ['pl-PL']],
		 ['Português',       ['pt-BR', 'Brasil'],
		                     ['pt-PT', 'Portugal']],
		 ['Român',          ['ro-RO']],
		 ['Slovenina',      ['sk-SK']],
		 ['Suomi',           ['fi-FI']],
		 ['Svenska',         ['sv-SE']],
		 ['Türkçe',          ['tr-TR']],
		 ['',       ['bg-BG']],
		 ['P',         ['ru-RU']],
		 ['',          ['sr-RS']],
		 ['',            ['ko-KR']],
		 ['',             ['cmn-Hans-CN', ''],
		                     ['cmn-Hans-HK', ''],
		                     ['cmn-Hant-TW', ''],
		                     ['yue-Hant-HK', '']],
		 ['',           ['ja-JP']],
		 ['Lingua latna',   ['la']]];
		for (var i = 0; i < langs.length; i++) {
		  select_language.options[i] = new Option(langs[i][0], i);
		}
		select_language.selectedIndex = 6;
		updateCountry();
		select_dialect.selectedIndex = 6;
		showInfo('info_start');
		function updateCountry() {
		  for (var i = select_dialect.options.length - 1; i >= 0; i--) {
		    select_dialect.remove(i);
		  }
		  var list = langs[select_language.selectedIndex];
		  for (var i = 1; i < list.length; i++) {
		    select_dialect.options.add(new Option(list[i][1], list[i][0]));
		  }
		
		  select_dialect.style.visibility = list[1].length == 1 ? 'hidden' :
		'visible';
		}
		var create_email = false;
		var final_transcript = '';
		var recognizing = false;
		var ignore_onend;
		var start_timestamp;
		if (!('webkitSpeechRecognition' in window)) {
		  upgrade();
		} else {
			if($('#start_button').data('clicked')) {
				start_button.style.display = 'inline-block';
		    }
		  //start_button.style.display = 'inline-block';
		  var recognition = new webkitSpeechRecognition();
		  recognition.continuous = true;
		  recognition.interimResults = true;
		  recognition.onstart = function() {
		    recognizing = true;
		    showInfo('info_speak_now');
		    if($('#start_button').data('clicked')) {
		    	start_img.src = '/HISDRDESK_MC/hisglobal/images/mic-animate.gif';
		    }
		    //start_img.src = '/HISDRDESK_MC/hisglobal/images/mic-animate.gif';
		  };
		  recognition.onerror = function(event) {
		    if (event.error == 'no-speech') {
		    	if($('#start_button').data('clicked')) {
		    		start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
			    }
		      //start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
		      showInfo('info_no_speech');
		      ignore_onend = true;
		    }
		    if (event.error == 'audio-capture') {
		    	if($('#start_button').data('clicked')) {
		    		start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
			    }
		      //start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
		      showInfo('info_no_microphone');
		      ignore_onend = true;
		    }
		    if (event.error == 'not-allowed') {
		      if (event.timeStamp - start_timestamp < 100) {
		        showInfo('info_blocked');
		      } else {
		        showInfo('info_denied');
		      }
		      ignore_onend = true;
		    }
		  };
		  recognition.onend = function() {
		    recognizing = false;
		    if (ignore_onend) {
		      return;
		    }
		    if($('#start_button').data('clicked')) {
		    	start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
		    }
		    //start_img.src = '/HISDRDESK_MC/hisglobal/images/mic.gif';
		    if (!final_transcript) {
		      showInfo('info_start');
		      return;
		    }
		    showInfo('');
		    if (window.getSelection) {
		      window.getSelection().removeAllRanges();
		      var range = document.createRange();

		      if($('#start_button').data('clicked')) {
		    	  range.selectNode(document.getElementById('txt-snomed-ct-search_VR'));
		      }
		      
		      //range.selectNode(document.getElementById('txt-snomed-ct-search_VR'));
		      window.getSelection().addRange(range);
		    }
		    if (create_email) {
		      create_email = false;
		      createEmail();
		    }
		  };
		  recognition.onresult = function(event) {
		    var interim_transcript = '';
		    for (var i = event.resultIndex; i < event.results.length; ++i) {
		      if (event.results[i].isFinal) {
		        final_transcript += event.results[i][0].transcript;
		      } else {
		        interim_transcript += event.results[i][0].transcript;
		      }
		    }
		    final_transcript = capitalize(final_transcript);
		  //  final_span.innerHTML = linebreak(final_transcript);
		    //interim_span.innerHTML = linebreak(interim_transcript);
		    if($('#start_button').data('clicked')) {
		    	document.getElementById("txt-snomed-ct-search_VR").value = linebreak(final_transcript);
		    }
		    //document.getElementById("txt-snomed-ct-search_VR").value = linebreak(final_transcript);
		   /* if (final_transcript || interim_transcript) {
		      showButtons('inline-block');
		    } */
		  };
		}
		function upgrade() {
			if($('#start_button').data('clicked')) {
				start_button.style.visibility = 'hidden';
		    }
		  //start_button.style.visibility = 'hidden';
		  showInfo('info_upgrade');
		}
		var two_line = /\n\n/g;
		var one_line = /\n/g;
		function linebreak(s) {
		  return s.replace(two_line, '<p></p>').replace(one_line, '<br>');
		}
		var first_char = /\S/;
		function capitalize(s) {
		  return s.replace(first_char, function(m) { return m.toUpperCase(); });
		}
		
		function startButton(event) {
		  if (recognizing) {
		    recognition.stop();
		    return;
		  }
		
		
		  final_transcript = '';
		  recognition.lang = select_dialect.value;
		  recognition.start();
		  ignore_onend = false;
		 // final_span.innerHTML = '';
		  interim_span.innerHTML = '';
		  if($('#start_button').data('clicked')) {
			  start_img.src = '/HISDRDESK_MC/hisglobal/images/mic-slash.gif';
		    }
		  //start_img.src = '/HISDRDESK_MC/hisglobal/images/mic-slash.gif';
		  showInfo('info_allow');
		  //showButtons('none');
		  start_timestamp = event.timeStamp;
		}
		function showInfo(s) {
		  if (s) {
		    for (var child = info.firstChild; child; child = child.nextSibling) {
		      if (child.style) {
		        child.style.display = child.id == s ? 'inline' : 'none';
		      }
		    }
		    info.style.visibility = 'visible';
		  } else {
		    info.style.visibility = 'hidden';
		  }
		}
		
		var current_style;
		function showButtons(style) {
		  if (style == current_style) {
		    return;
		  }
		  current_style = style;
		  //copy_button.style.display = style;
		  //email_button.style.display = style;
		  //copy_info.style.display = 'none';
		  //email_info.style.display = 'none';
		}

</script> -->
	
<script>
	function multiSearchOr(text, searchWords){
		if(text.indexOf(searchWords)>=0){
			return true;
		}
		else{
			return false;
		}
	}
</script>
<script>
function cghsLegacyData(){
	labHistoryData()
	referralHistoryData()
	medicalHistoryData()
}

function labHistoryData(){ 
	var crno="";
		var currentPatientDtl=localStorage.getItem("currentPatientDtl");
		if(currentPatientDtl!=null && currentPatientDtl!=undefined){
			currentPatientDtl=JSON.parse(currentPatientDtl);
			crno =currentPatientDtl["patCrNo"]
		}
		if(crno=="")
			return;	
	   
	   
    $.ajax({
        url: '/HISDRDESK_MC/services/restful/search/labHistoryData?CrNo=' + crno,
        async: true,
        success: function(result) {
            console.log("Server Response labHistoryData: ", result);
            populateLabTables(result);
        },
        error: function(xhr, ajaxOptions, thrownError) {
            console.log(xhr.status);
            console.log(thrownError);
        }
    });
}
function referralHistoryData(){ 
	var crno="";
	var currentPatientDtl=localStorage.getItem("currentPatientDtl");
	if(currentPatientDtl!=null && currentPatientDtl!=undefined){
		currentPatientDtl=JSON.parse(currentPatientDtl);
		crno =currentPatientDtl["patCrNo"]
	}
	if(crno=="")
		return;	
   	
	   
    $.ajax({
        url: '/HISDRDESK_MC/services/restful/search/referralHistoryData?CrNo=' + crno,
        async: true,
        success: function(result) {
            console.log("Server Response referralHistoryData: ", result);
            populateReferralTables(result);
        },
        error: function(xhr, ajaxOptions, thrownError) {
        	console.log(xhr.status);
        	console.log(thrownError);
        }
    });
}
function medicalHistoryData(){ 
	var crno="";
	var currentPatientDtl=localStorage.getItem("currentPatientDtl");
	if(currentPatientDtl!=null && currentPatientDtl!=undefined){
		currentPatientDtl=JSON.parse(currentPatientDtl);
		crno =currentPatientDtl["patCrNo"]
	}
	if(crno=="")
		return;	
   
    $.ajax({
        url: '/HISDRDESK_MC/services/restful/search/medicalHistoryData?CrNo=' + crno,
        async: true,
        success: function(result) {
            console.log("Server Response medicalHistoryData: ", result);
            populateMedicalTables(result);
        },
        error: function(xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
        }
    });
}


function populateLabTables(data) {
	
    if (!data || !Array.isArray(data)) {
        console.error("Unexpected data format", data);
        document.getElementById('TreeStructurePrescriptionModalTab21').innerHTML = "<p>No data available</p><p>" + JSON.stringify(data) + "</p>";
        return;
    }
    
    let labHistoryTable = document.querySelector('#labHistoryTableId');
    
    if (data.length === 0) {
        // Create a no data row for each table
        let noDataRowLab = document.createElement('tr');
        noDataRowLab.classList.add('table-warning');
        noDataRowLab.innerHTML = "<td colspan='9' style='text-align:center;'>No records found!!</td>";
        labHistoryTable.appendChild(noDataRowLab);

    } else {
        data.forEach(function(item, key) {
            console.log("dispensary code " + item["dispensary Code"]);

            // Populate Lab History Table
            let labRow = document.createElement('tr');
            labRow.classList.add('table-primary');
            labRow.innerHTML = "<td>" + item["dispensary Code"] + "</td>" +
                               "<td>" + item["Test Code"] + "</td>" +
                               "<td>" + item["Registration No"] + "</td>" +
                               "<td>" + item["Insertion Date"].split(" ")[0] + "</td>" +
                               "<td>" + item["Parent Dispensary"] + "</td>";
            labHistoryTable.appendChild(labRow);

        });
    }
}

function populateReferralTables(data) {
	
    if (!data || !Array.isArray(data)) {
        console.error("Unexpected data format", data);
        document.getElementById('TreeStructurePrescriptionModalTab21').innerHTML = "<p>No data available</p><p>" + JSON.stringify(data) + "</p>";
        return;
    }
    
    let referralHistoryTable = document.querySelector('#referralHistoryTableId');
    
    if (data.length === 0) {

        let noDataRowReferral = document.createElement('tr');
        noDataRowReferral.classList.add('table-warning');
        noDataRowReferral.innerHTML = "<td colspan='4' style='text-align:center;'>No records found!!</td>";
        referralHistoryTable.appendChild(noDataRowReferral);

    } else {
        data.forEach(function(item, key) {
           // console.log("dispensary code " + item["dispensary Code"]);

            let referralRow = document.createElement('tr');
            referralRow.classList.add('table-primary');
            referralRow.innerHTML = 
                         "<td>" + item["Referral Id"] + "/" + item["Ref Id"] + "</td>" +
                         "<td>" + item["Ref Status"] + "</td>" +
                         "<td>" + item["Ref Date"] + "</td>" +
                         "<td>" + item["Ref Validity"] + "</td>";
            referralHistoryTable.appendChild(referralRow);

        });
    }
}

let originalMedicalData = []; // Store original data for filtering

function populateMedicalTables(data) {
    if (!data || !Array.isArray(data)) {
        console.error("Unexpected data format", data);
        document.getElementById('TreeStructurePrescriptionModalTab21').innerHTML = "<p>No data available</p><p>" + JSON.stringify(data) + "</p>";
        return;
    }
    
    // Store original data for filtering
    originalMedicalData = data;
    
    // Initial population
    filterMedicalData('all');
    
    // Add event listeners to radio buttons
    document.querySelectorAll('.hosp-filter').forEach(radio => {
        radio.addEventListener('change', function() {
            filterMedicalData(this.value);
        });
    });
}

function filterMedicalData(filterValue) {
    let medicalHistoryTable = document.querySelector('#medicalHistoryTableId');
    medicalHistoryTable.innerHTML = ''; // Clear existing rows
    
    let filteredData = originalMedicalData;
    
    if (filterValue !== 'all') {
        filteredData = originalMedicalData.filter(item => {
            // Assuming each item has a hosp_type property
            // Adjust this condition based on your actual data structure
            return item.hosp_type === filterValue;
        });
    }
    
    if (filteredData.length === 0) {
        let noDataRowMedical = document.createElement('tr');
        noDataRowMedical.classList.add('table-warning');
        noDataRowMedical.innerHTML = "<td colspan='4' style='text-align:center;'>No records found!!</td>";
        medicalHistoryTable.appendChild(noDataRowMedical);
    } else {
        filteredData.forEach(function(item, key) {
            let medicalRow = document.createElement('tr');
            medicalRow.classList.add('table-primary');
            medicalRow.innerHTML = "<td>" + item["Prescription Date"] + "</td>" + 
						            "<td>" + (item["Medicine Name"] ? item["Medicine Name"] : "No medicine name found") + "</td>" +
						            "<td>" + item["Quantity"] + "</td>" +
						            "<td>" + (item["WC NAME/Disp Code"] ? item["WC NAME/Disp Code"].split("^")[0] : "No WC name found") + "</td>";

            medicalHistoryTable.appendChild(medicalRow);
        });
    }
}

</script>