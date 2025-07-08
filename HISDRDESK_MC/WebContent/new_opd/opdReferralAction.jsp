<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
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
	<title>CGHS</title>   
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
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/flexdatalist/jquery.flexdatalist.min.css">
	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/assests/jquery-confirm.min.css">
	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/css/mainDesk.css">
	
	<script type="text/javascript" src="../../new_opd/assests/jquery.js"></script>
    <script src="/HIS/hisglobal/drDeskAssets/popper/popper.min.js"></script>
    <script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/HIS/hisglobal/snomedct/css/jquery-ui.css">  
	<script type="text/javascript" src="../../new_opd/assests/jquery.autocomplete.js"></script>

<script type="text/javascript" src="../../new_opd/assests/jquery-ui.min.js"></script>  
    <script src="/HIS/hisglobal/drDeskAssets/gijgo/js/gijgo.min.js" type="text/javascript"></script>
    <script src="/HIS/hisglobal/drDeskAssets/perfectScrollbar/perfect-scrollbar.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/uikit/js/uikit.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/uikit/js/uikit-icons.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/tippy/tippy.all.min.js"></script>
	
    
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/Responsive-2.2.2/js/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/Responsive-2.2.2/js/responsive.bootstrap4.min.js"></script>
	 
	 
	  
    <script src="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.js"></script>
    
	<script src="/HIS/hisglobal/FormFlowX/plugins/select2/js/select2.min.js"></script>
	<link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/select2/css/select2.min.css">
	
	<script src="/HISDRDESK_MC/new_opd/js/sectionBookMark.js"></script>
	<script src="/HISDRDESK_MC/new_opd/js/myReferral.js"></script>
	
	<style type="text/css">
		.referheading {
			font-weight: bold;text-align: left;border-bottom: 1px solid #d7d7d7;padding: 6px;
		}	
		.divborder{
			border-bottom: 1px solid #d7d7d7;
			padding: 10px;
		}
		table  td{padding:15px !important;}
		table  th{padding:15px !important;}	

		body{ padding-top: 0 !important;}		
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
.dataTables_filter {
  text-align: left !important;
}

	</style> 
</head>
<body>
<%HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);

%>
<div class="loader"  >
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
	<font id="patHospitalCodePrescriptionPanel" style="display: none"><%=objHospitalMstVO.getHospitalCode() %></font>
	<font id="patSeatIdPrescriptionPanel" style="display: none"><%=(String)request.getSession().getAttribute("SEATID") %></font>
		        	
  <div id='page-content-wrapper' style="padding-bottom: 10px;" >
  <div id='patient_profile' class='patient_profile' style="width: 99.8%;margin-left: 1px;margin-top: 2px;" >
    	<div class='row'>
    		<div class='col-sm-1' style="background: #fff;padding: 2px;border: 1px solid #000;border-radius: 10px;margin-left:36px;height:94px;width:94px">
    		<img style="width:100%;height: 100%;" id='imgProfilePic'  src="/HISDRDESK_MC/new_opd/img/patIcon.png"></div>
    		<div class='col-sm-10' >
    			<div class='row'>
    				<div class='col-sm-4' ><h2 style="padding: 0px;color: #fff;text-align: left !important;">
    				<font id="patNamePrescriptionPanel" > </font></h2></div>
    				<div class='col-sm-4' >
    				<h2 style="padding: 0px;color: #fff;text-align: left !important;">Ben ID: -
    				<font id="patCrNoPrescriptionPanel" ></font></h2>
    				</div>	
    				<div class='col-sm-4 patienttiledata' >
    					Relation :- <font id="relation" ></font>
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
    		</div>
    	</div>
   	</div>
   	
<!--  Refer Patient Starts -->
	<div class="card cardPrescription" id='ReferMainDiv' >
        <button class="btn accordionbtn accordionbtnExpended"  type="button" data-toggle="collapse" data-target="#collapse-13"><i class="fa fa-minus"></i> &nbsp; Refer Patient</button>
        <div class="" id="collapse-13" aria-labelledby="heading-13" style="padding: 17px;">
                   <div class="row divborder" id='divReferralStatus'>
                         <div class="col-sm-6 col-md-6">
                           <p style="letter-spacing:0"><label>Refer Status</label></p>
                           <div class="form-check form-check-inline">                           	 
 							 <input class="form-check-input" type="radio"  value="2" name="referralStatus" checked="checked" id="referralStatus2" >&nbsp;
 							 <label class="form-check-label" for="referralStatus2">Referral</label>&nbsp;&nbsp;
 							 
 							 <input class="form-check-input" type="radio"  value="3" name="referralStatus" id="referralStatus3" >&nbsp;
 							 <label class="form-check-label" for="referralStatus3">Endorsement</label>&nbsp;&nbsp;
							</div>
							<span id='refralConfiguration' style="display: none;"></span>
						  </div>
                          <div class="col-sm-6 col-md-6 referRow" id='divReferType' >
                            <p style="letter-spacing:0"><label>Refer Type :</label></p>
                           <div class="form-check form-check-inline">
  								<input class="form-check-input" type="checkbox" value="Consultation" name="referType" id="referType_extConsultation">&nbsp;
  								<label class="form-check-label" for="referType_extConsultation">Consultation</label>&nbsp;&nbsp;
  								
  								<input class="form-check-input" type="checkbox" value="Investigation" name="referType" id="referType_extInvestigation">&nbsp;
  								<label class="form-check-label" for="referType_extInvestigation">Investigation</label>&nbsp;&nbsp;
  								
  								<input class="form-check-input" type="checkbox" value="Procedure" name="referType" id="referType_extProcedure">&nbsp;
  								<label class="form-check-label" for="referType_extProcedure">Procedure</label>&nbsp;&nbsp;
  								
  								<input class="form-check-input" type="checkbox" value="Follow up" name="referType" id="referType_extFollowup">&nbsp;
  								<label class="form-check-label" for="referType_extFollowup">Follow up</label>&nbsp;&nbsp;
							</div>
                          </div>
                    </div> 
                   
                          
                          <!-- EndorsementDiv Start here-->
                          	<div class='row referRow divborder' id='EndorsementDiv' style="display: none;">
                          		<div class="col-sm-12 col-md-12" >
	                          			<h4 class='referheading'>Endorsement Detail</h4>
                          		</div>
                          		<div class="form-group col-sm-3 col-md-3 endorsmentEntry" >	
			            	  	<p style="letter-spacing:0"><label>City Name</label></p>
			                  	<select class="form-control"  id="strEndorsementCity" name="strEndorsementCity" >
			                		<option value="">Select City</option>
			                	</select>
							   </div>
                         		<div class="form-group col-sm-3 col-md-3 endorsmentEntry" >	
			            	  	<p style="letter-spacing:0"><label>Hospital Name</label></p>
			                  	<select class="form-control"  id="strEndorsementHospital" name="strEndorsementHospital" >
			                		<option value="">Select Hospital</option>
			                	</select>
							   </div>
							  
							   <div class="form-group col-sm-3 col-md-3 endorsmentEntry" >			
							   	<p style="letter-spacing:0"><label>Department Name</label></p>		  
				 				<select class="form-control"  id="strEndorsementDepartment" name="strEndorsementDepartment" >
			                		<option value="">Select Department</option>
			                	</select>
							   </div>
							    <div class="form-group col-sm-3 col-md-3 endorsmentEntry" >						
							    	<p style="letter-spacing:0"><label>Doctor Name</label></p>
							    	<div class="col-sm-12" style="margin-left: -20px;">
							    	  <div style="float:left;padding: 10px;border-top-right-radius: 0;border-bottom-right-radius: 0;font-size: 1rem;font-weight: 400;line-height: 1.5;font-size: 1rem;font-weight: 400;line-height: 1.5;display: -webkit-box;display: -webkit-flex;display: -ms-flexbox;display: flex;padding: .375rem .75rem;text-align: center;white-space: nowrap;color: #212529;border: 1px solid #ced4da;border-radius: .25rem;border-top-right-radius: 0.25rem;border-bottom-right-radius: 0.25rem;background-color: #e9ecef;-webkit-box-align: center;-webkit-align-items: center;-ms-flex-align: center;align-items: center;width: 11%;"> Dr.</div>
							    	  <div style="float:left;width: 89%;">
 											<input type="text" class="form-control" placeholder="Enter Doctor Name" name="strEndorsementDoctor" id="strEndorsementDoctor" maxlength="100">
 										  </div>	
									 </div>
									  <span id="reffralJson_endorsement" style="display :none"></span>
							   </div>
								  
								 
				              </div>
				              <!-- EndorsementDiv Ends here -->
				              
				              
                          
                          <!-- External Start here-->
                          <div class='row referRow ' id='ExternalDiv' style="display: none;">
                          <div class="col-sm-12 col-md-12" >
                          	<div class='row divborder' id='extConsultation' style="display: none;">
                          		<div class="form-group  col-lg-4 col-sm-3 col-md-12" >
                          			<!-- <h4 class='referheading '>Consultation Detail</h4> -->	 
                          			<p style="letter-spacing:0"><label>Refer To Speciality :</label></p>		
	                          		<select class="form-control selectSearch"  id="refferlExtPatientDeptId" name="refferlExtPatientDeptId" >
			                             <option value="">Select Speciality</option>                        	
			                         </select>
                          		</div>
                          		<div class="form-group  col-lg-3 col-sm-6 col-md-6"  style="padding-top: 43px;" id='sectionBookmark_2'>
                          		</div> 
                          		<div class="form-group  col-lg-5 col-sm-3 col-md-6"  style="text-align: right;padding-top: 43px;">
                          			<a type="button" class="btn-his-outline" onclick="bookmarkSection(2)" ><i class="glyphicon glyphicon-bookmark" title='New Consultation Template'></i>&nbsp;New Cons. Template</a>
                          			<a type="button" class="btn-his-outline manageTemplate"   onclick="manageTemplateSection(2)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;Manage Template</a>
                          		</div> 
                          		
 <!--                          	<div class="form-group col-sm-1 col-md-1 bookmarkcontainer" id='divMoreBookmark_1'>
                          			<a id='moreBookmark_1' class="btn btn-his-outline-sm btn-sm">More +</a>
                          		</div> -->
                          		
                          		
                          		<div class="col-sm-12 table-responsive" >
                          			   <table id="ExternalConsultationListTable" class="table table-condensed" style="margin-bottom: 0px;display:none;"> 
				                            <thead>
				                              <tr class="tableHeading">
				                                <th style='width:5%'>S.NO.</th>
				                                <th style='width:30%'>Speciality Name</th>
				                                <th style='width:25%'>Referral Note</th>
				                                <th style='width:15%'>No. of Consultation</th>
				                                <th style='width:15%;text-align: center;'>Valid Upto</th>
				                                <th style='width:10%'>&nbsp;</th>
				                              </tr>
				                            </thead>
				                            <tbody></tbody> 
				                        </table>
                          		</div>
				            </div>
				            <div class='row divborder' id='extInvestigation' style="display: none;">
				            	<div class="form-group  col-lg-4 col-sm-3 col-md-3" >
                          			<p style="letter-spacing:0"><label> Test Name :</label></p>
					              	<select class="form-control selectSearch"  id="refferlExtInvestigationTest" name="refferlExtInvestigationTest" >
			                             <option value="">Select Tests</option>                        	
			                         </select> 
                          		</div>
                          		<div class="form-group  col-lg-3 col-sm-6 col-md-6"  style="padding-top: 43px;" id='sectionBookmark_1'>
                          		</div> 
                          		<div class="form-group  col-lg-5 col-sm-3 col-md-6"  style="text-align: right;padding-top: 43px;">
                          			<a type="button" class="btn-his-outline" onclick="bookmarkSection(1)" ><i class="glyphicon glyphicon-bookmark"></i>&nbsp;New Inv. Template</a>
                          			<a type="button" class="btn-his-outline manageTemplate"   onclick="manageTemplateSection(1)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;Manage Template</a>
                          		</div> 
                          		
                          		
                          		
                          		
                          		<div class="col-sm-12 table-responsive" >
                          			   <table id="ExternalInvestigationListTable" class="table table-condensed " style="margin-bottom: 0px;display:none;"> 
				                            <thead>
				                              <tr class="tableHeading">
				                                <th style='width:5%'>S.NO.</th>
				                                <th style='width:30%'>Test Name</th>
				                                <th style='width:25%'>Referral Note</th>
				                                <th style='width:15%'>No. of Investigation</th>
				                                <th style='width:15%;text-align: center;'>Valid Upto</th>
				                                <th style='width:10%'>&nbsp;</th>
				                              </tr>
				                            </thead>
				                            <tbody></tbody> 
				                        </table>
                          		</div>
				            </div>
				            <div class='row divborder' id='extProcedure' style="display: none;">
				            	<div class="form-group  col-lg-4 col-sm-3 col-md-3" >
                          			<p style="letter-spacing:0"><label>Procedure Name :</label></p>
					              	<select class="form-control selectSearch"  id="refferlExtProcedure" name="refferlExtProcedure" >
			                             <option value="">Select Procedure</option>                        	
			                         </select> 
                          		</div>
                          		<div class="form-group  col-lg-3 col-sm-6 col-md-6"   style="padding-top: 43px;"  id='sectionBookmark_3'>
                          		</div> 
                          		<div class="form-group  col-lg-5 col-sm-3 col-md-6"  style="text-align: right;padding-top: 43px;">
                          			<a type="button" class="btn-his-outline" onclick="bookmarkSection(3)" ><i class="glyphicon glyphicon-bookmark"></i>&nbsp;New Proc. Template</a>
                          			<a type="button" class="btn-his-outline manageTemplate"   onclick="manageTemplateSection(3)"><i class="glyphicon glyphicon-bookmark"></i>&nbsp;Manage Template</a>
                          		</div>
                          		
                          		<div class="col-sm-12 table-responsive" >
                          			   <table id="ExternalProcedureListTable" class="table table-condensed" style="margin-bottom: 0px;display:none;"> 
				                            <thead>
				                              <tr class="tableHeading">
				                                <th style='width:5%'>S.NO.</th>
				                                <th style='width:30%'>Procedure Name</th>
				                                <th style='width:25%'>Referral Note</th>
				                                <th style='width:15%'>No. of Procedure</th>
				                                <th style='width:15%;text-align: center;'>Valid Upto</th>
				                                <th style='width:10%'>&nbsp;</th>
				                              </tr>
				                            </thead>
				                            <tbody></tbody> 
				                        </table>
                          		</div>
				            	
				            </div>
				            <div class='row divborder' id='extFollowup' style="display: none;">
                          		<div class="form-group  col-lg-4 col-sm-3 col-md-3" >
                          			<p style="letter-spacing:0"><label>Refer To Follow-up Speciality :</label></p>		
	                          		<select class="form-control selectSearch"  id="refferlExtFollowupDeptId" name="refferlExtFollowupDeptId" >
			                             <option value="">Select Speciality</option>                        	
			                         </select>
                          		</div>
                          		<div class="col-sm-12 table-responsive" >
                          			   <table id="ExternalFollowUpListTable" class="table table-condensed " style="margin-bottom: 0px;display:none;"> 
				                            <thead>
				                              <tr class="tableHeading">
				                                <th style='width:5%'>S.NO.</th>
				                                <th style='width:30%'>Speciality Name</th>
				                                <th style='width:25%'>Referral Note</th>
				                                <th style='width:15%'>No. of Follow up</th>
				                                <th style='width:15%;text-align: center;'>Valid Upto</th>
				                                <th style='width:10%'>&nbsp;</th>
				                              </tr>
				                            </thead>
				                            <tbody></tbody> 
				                        </table>
                          		</div>				            	  
				            </div>                          
                          </div>
                          </div>
                          <!-- External Ends here -->
           </div>
    </div>
	<!--  Refer Patient Ends -->
   	
   	</div>
   	
   	
   	<div class="modal fade" id="sectionBookmark" role="dialog">
	    <div class="modal-dialog modal-xl" style='width:85%'>
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
	    <div class="modal-dialog modal-xl" style='width:85%'>
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
</body>	 