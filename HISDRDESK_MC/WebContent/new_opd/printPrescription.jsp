<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
response.setHeader("Cache-Control", "public, max-age=86400"); // Cache for 1 day
response.setHeader("Expires", new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z").format(new Date(System.currentTimeMillis() + 86400000)));
%>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
	<title>Print Prescription</title>
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/all.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/fontawesome.min.css">
	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/bootstrap/css/bootstrap.min.css">

	<!-- jQuery library -->
	<script src="/HIS/hisglobal/drDeskAssets/jquery/jquery-3.3.1.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
	<script src="/HIS/hisglobal/drDeskAssets/qrcodejs/qrcode.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/FormFlowX/js/base64.js"></script>
	<script type="text/javascript" src="/HISDRDESK_MC/new_opd/js/printPrescription.js"></script>  
	
	<style type="text/css">
			table { display: table; width:100%;background-color: transparent;border-collapse: collapse;border-spacing: 0;page-break-inside:auto; }
			tr{ page-break-inside:auto; }
			tbody td    { border:1px solid #e0e0e0; padding:5px;}
			thead th    { border:1px solid #e0e0e0;background: #e0e0e0;padding:5px; }
			thead td    { padding:5px; }
			.sectiontitle {font-weight: bold;  margin-top: 20px;  margin-bottom: 10px;}
			
			.line{
				margin-top:5px;margin-bottom:16px; border-bottom: 3px solid #265919;
			}
			
			.page-break {
			  page-break-before: always;
			  break-before: always; 
			}
			
	</style>
</head>
<body id="printPrescFrameBody" >
	<%HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);%>
	
	<div style="right:8px; position:fixed" class="prHeader" id="prHeaderr" >
		<label class="withHeaderLabel" style="z-index: 99999;display: none;"><input type="checkbox" name="withHeaderCheck" value="1" >&nbsp;  Without Header</label><br><!--With Header  -->
		<button class="btn btn-primary prescBtn" id='prescSaveLoadBtn'style="z-index:9999;" type="button" onclick="">Save</button>
		<button class="btn btn-info prescBtn" id='prescPrintBtn' style="z-index:9999;" type="button" onclick="">Print Prescription</button>
	<!-- 			<button class="btn btn-info prescPrintBtn" style="z-index:9999;" type="button" onclick="">Print</button> -->
	</div>
	 
	<div style="width:100%;padding:10px;color:#000;page-break-inside:auto;" id='divPrintable'>
		
		<!-- Header starts here -->
		<table>
		  <thead>	
		  <tr>
		  	<td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
		  	<td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'><h4 style='font-weight:bold;'>
		  	&#x915;&#x947;&#x928;&#x94D;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;
		  	</h4>
		  	<h4>
		  	Central Government Health Scheme	  	
		  	</h4>
		  	<h5 class="" style="font-weight:bold;">
		  	<%int HospitalTypeCode=1;
		  	if(objHospitalMstVO.getHospitalTypeCode()==null || objHospitalMstVO.getHospitalTypeCode().equals("")){
		  		HospitalTypeCode=1;
		  	}
		  	else{
		  		HospitalTypeCode= Integer.parseInt(objHospitalMstVO.getHospitalTypeCode());
		  	}
		  	String HospitalTypeName="";
		  	switch (HospitalTypeCode) {
            case 1:
            	HospitalTypeName="ALLOPATHY";
                break;
            case 2:
            	HospitalTypeName="AYURVEDA";
                break;
            case 3:
            	HospitalTypeName="HOMEOPATHY";
                break;
            case 5:
            	HospitalTypeName="SIDDHA";
                break;
            case 6:
            	HospitalTypeName="UNANI";
                break;
            case 7:
            	HospitalTypeName="YOGA,NATUROPATHY";
                break;           
            default:
            	HospitalTypeName="Allopathy";
        }

		  	 %>
		  	<%=objHospitalMstVO.getHospitalName() %> - <%="("+HospitalTypeName+")" %>
		  	</h5>
		  	<%if(objHospitalMstVO.getAddress1()!=null && !objHospitalMstVO.getAddress1().trim().equals("") ){ %>
				<h5 style="font-weight:bold;" ><%=objHospitalMstVO.getAddress1()%></h5>
			<%} %>
			<h4 style="font-weight:bold;text-decoration: underline;" >OPD Prescription</h4>
		  	</td>
		  	<td style='width:15%;text-align: center;'><span id="patQrCode"></span></td>
		  
		  </tr>
		 </thead> 
		</table>
		<div class='line' id='line1'></div>
		<!-- Header ends here -->
		<!-- Patient details starts here -->
		<table>
		  <tbody>	
		  <tr>
		  	<td style='width:20%;'>
		  	&#x928;&#x93E;&#x92E;
		  	/ Name</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdName'></td>
		  	<td style='width:20%;'>
		  	&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x915;&#x940;&#x20;&#x92A;&#x939;&#x91A;&#x93E;&#x928;&#x20;&#x938;&#x902;&#x2E;
		  	<br/>Beneficiary Id</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdBenId'></td>
		  	
		  </tr>
		  <tr>
		  	<td style='width:20%;'>
		  	&#x906;&#x92F;&#x941;/&#x932;&#x93F;&#x902;&#x917;
		  	/ Age/Gender
		  	</td>
		  	<td style='width:30%;' class='tdAgeGender'></td>
		  
		  	<td style='width:20%;'>
		  	&#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x915;&#x93E;&#x20;&#x92A;&#x94D;&#x930;&#x915;&#x93E;&#x930;
		  	/Card Type</td>
		  	<td style='width:30%;' class='tdCardType'></td>
		  </tr>
		  
		  <tr>
		  	<!-- <td style='width:20%;'>
		  	&#x92E;&#x94B;&#x92C;&#x93E;&#x907;&#x932; / Mobile No.
		  	</td>
		  	<td style='width:30%;'id='tdMobile'></td> -->
		  	<td style='width:20%;'>
		  	&#x938;&#x92E;&#x94D;&#x92C;&#x902;&#x927;
		  	/ Relation
		    </td>
		  	<td style='width:30%;' class='tdRelation'></td>
		  </tr>
		  <tr>
		  	<td style='width:25%;'>
		  	&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x2F;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x926;&#x93E;&#x924;&#x93E;&#x20;
		  	/ Department/Consultant
		  	</td>
		  	<td style='width:30%;' class='tdDepartment'></td>
		  	<td style='width:20%;'>
		  	&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915;
		  	/ Visit Date
		    </td>
		  	<td style='width:30%;' class='tdVisitDate'></td>
		  </tr>
		 </tbody> 	
		</table>
		<!-- Patient details ends here -->

		
		<!--Internal Referral  details starts here-->
		
		<h5 class="InternalReffral sectiontitle">
		&#x930;&#x94B;&#x917;&#x940;&#x20;&#x938;&#x94D;&#x925;&#x93E;&#x928;&#x93E;&#x902;&#x924;&#x930;&#x923;&#x20;&#x935;&#x93F;&#x935;&#x930;&#x923;/
		Patient Transfer Details :</h5>
		<table class='InternalReffral' id="InternalReffralListTable"> 
           <thead>
             <tr>
             	<th style="width:40%;">
            	&#x935;&#x93F;&#x936;&#x947;&#x937;&#x20;&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x20;&#x915;&#x93E;&#x20;&#x928;&#x93E;&#x92E;		                        
            	<br/>
            	Speciality Name</th>
            	<th style='width:60%'>
            	&#2360;&#2381;&#2341;&#2366;&#2344;&#2366;&#2306;&#2340;&#2352;&#2339;&#32;&#2335;&#2367;&#2346;&#2381;&#2346;&#2339;&#2368;
            	<br/>
            	Transfer Note</th>				                           
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		<!--Internal Referral  details ends here-->
		<!--External  Referral  details component wise starts here-->
		<table class='ExternalReffral' id="ExternalReffralListTable" style="display: none;" > 
           <thead><!--  -->
             <tr>
             	<th style="width:10%;text-align:center;">Ref. Id/ SNO.</th>
             	<th style="width:35%;">Component Details</th>
             	<th style="width:35%;">Remarks</th>
             	<th style="width:10%;text-align:center;">Valid Upto</th>
             	<th style="width:10%;text-align:center;">Max. Qty</th>
            	<th style="width:5%;text-align:center">Referral Type</th>		                           
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		<!--External  Referral  details component wise ends here-->
		
		<div class='line' id='line3'></div>
		<table id='vitalLabTable' style="display: block;">
		  <tbody>
		   <tr class="proxy">
		  	<td style='width:30%;color:blue;font-weight: bold;font-size: 15px;' >Proxy Visit</td>
		  	<td style='width:70%;' id='proxyDtl'> </td>
		  </tr>	
		  <tr class="vitals">
		  	<td style='width:30%;' >&#x91C;&#x93C;&#x930;&#x942;&#x930;&#x940;&#x20;&#x938;&#x902;&#x915;&#x947;&#x924; / Vitals /GE</td>
		  	<td style='width:70%;' id='vitalDtl'> </td>
		  </tr>
		  <tr class="chiefCompiants">
		  	<td style='width:30%;' >&#x92E;&#x941;&#x916;&#x94D;&#x92F;&#x20;&#x938;&#x92E;&#x938;&#x94D;&#x92F;&#x93E; / Chief Complaint</td>
		  	<td style='width:70%;' id='chiefCompiantDtl'> </td>
		  </tr>
		  <tr class="completeHistory">
		  	<td style='width:30%;' >&#x92A;&#x942;&#x930;&#x93E;&#x20;&#x907;&#x924;&#x93F;&#x939;&#x93E;&#x938; / Complete History </td>
		  	<td style='width:70%;'><ul id='completeHistoryDtl'> </ul> </td>
		  </tr>
		  <tr class="Examination">
		  	<td style='width:30%;' >&#x92A;&#x930;&#x940;&#x915;&#x94D;&#x937;&#x93E;  / Examination</td>
		  	<td style='width:70%;'>
		  		<p id='examination1' style="padding-left:30px"> </p>
		  		<ul id='examination'> </ul> 
		  	</td>
		  </tr>
		  <tr class="chronicDisease">
		  	<td style='width:30%;' >&#x938;&#x94D;&#x925;&#x93E;&#x92F;&#x940;&#x20;&#x92C;&#x940;&#x92E;&#x93E;&#x930;&#x940;  / Chronic Disease</td>
		  	<td style='width:70%;' id='chronicDiseaseDtl'> </td>
		  </tr>
		  
		    <tr class="LabReport">
		  	<td style='width:30%;' >&#x932;&#x948;&#x92C;&#x20;&#x930;&#x93F;&#x92A;&#x94B;&#x930;&#x94D;&#x91F;  / Lab Reports</td>
		  	<td style='width:70%;' id='LabReportDtl'> </td>
		  </tr>
		  
		  <tr class="diagnosis">
		  	<td style='width:50%;' >&#x20;&#x930;&#x94B;&#x917;&#x2D;&#x928;&#x93F;&#x926;&#x93E;&#x928; / Diagnosis</td>
		  	<td style='width:70%;' id='diagnosisDtl'> </td>
		  </tr>
		  <tr class="diagnosisAdvice">
		  	<td style='width:30%;' >&#x930;&#x94B;&#x917;&#x2D;&#x928;&#x93F;&#x926;&#x93E;&#x928;&#x20;&#x938;&#x932;&#x93E;&#x939; / Diagnosis Advice</td>
		  	<td style='width:70%;' id='diagnosisAdviceDtl'> </td>
		  </tr>
		  <tr class="Investigation">
		  	<td style='width:30%;' >&#x91C;&#x93E;&#x902;&#x91A; /CGHS Investigation</td>
		  	<td style='width:70%;' ><ul id='InvestigationDtl'></ul> </td>
		  </tr>
		  <tr class="InvestigationAdvice">
		  	<td style='width:30%;' >&#x91C;&#x93E;&#x902;&#x91A;&#x20;&#x938;&#x932;&#x93E;&#x939; /CGHS Investigation Advice </td>
		  	<td style='width:70%;' id='InvestigationAdviceDtl'> </td>
		  </tr>
		  <tr class="Procedure">
		  	<td style='width:30%;' >&#x92A;&#x94D;&#x930;&#x915;&#x94D;&#x930;&#x93F;&#x92F;&#x93E;&#x28;&#x913;&#x902;&#x29;&#x20;&#x915;&#x940;&#x20;&#x938;&#x932;&#x93E;&#x939;&#x2F;&#x909;&#x92A;&#x91A;&#x93E;&#x930;&#x20;&#x915;&#x93F;&#x92F;&#x93E;&#x20;&#x917;&#x92F;&#x93E; <br/>CGHS Procedure(s) Advised/Treated</td>
		  	<td style='width:70%;'><ul id='ProcedureDtl'></ul> </td>
		  </tr>
		  <tr class="TreatmentAdvice">
		  	<td style='width:30%;' >&#x909;&#x92A;&#x91A;&#x93E;&#x930;&#x20;&#x938;&#x932;&#x93E;&#x939; / Treatment Advice</td>
		  	<td style='width:70%;' id='TreatmentAdviceDtl'> </td>
		  </tr>
		  <tr class="Allergy">
		  	<td style='width:30%;' >&#x90F;&#x932;&#x930;&#x94D;&#x91C;&#x940; / Allergy</td>
		  	<td style='width:70%;'><ul id='AllergyDtl'></ul> </td>
		  </tr>
		  
		 </tbody> 	
		</table> 
		
		
		<!--Drug  details starts here-->
		<div class='line' id='line4'></div>
		<h5 class="Drug normalDrug sectiontitle" >
		&#x926;&#x935;&#x93E;&#x908;&#x20;&#x915;&#x93E;&#x20;&#x935;&#x93F;&#x935;&#x930;&#x923;/
		Medication Details :</h5>
		<table class='Drug normalDrug' id="DrugListTable" style="display: block;"> 
           <thead>
             <tr>
             	<th style="width: 10%;text-align:center">S.No</th>
				<th style="width: 20%">Medicine</th>
				<th style="width: 10%;text-align:center">Dose</th>
				<th style="width: 15%;text-align:center">Frequency</th>				
				<th style="width: 10%;text-align:center">Days</th>
				<th style="width:8%;text-align:center">Status</th>				
				<th style="width: 10%;text-align:center">Quantity</th>										
				<th style="width: 10%">Prescribed By</th>
				<th style="width: 10%">Instruction</th>            		                           
       		</tr>
           </thead>
           <tbody></tbody>
           <tfoot><tr><td colspan="9"><b>Medicine Status</b> : D - Delivery ,I - Indent</td></tr></tfoot> 
		</table>
		<!--drug  details ends here-->
		<table>
		  <tbody>	
		  <tr class="visitSummary">
		  	<td style='width:30%;' >&#x92E;&#x93F;&#x932;&#x928;&#x947;&#x20;&#x915;&#x93E;&#x20;&#x938;&#x93E;&#x930;&#x93E;&#x902;&#x936; /Visit Summary</td>
		  	<td style='width:70%;' id='visitSummaryDtl'> </td>
		  </tr>
		 </tbody> 
		</table>
		<br/>
		<br/>
		<br/>
		<h5>Doctor Signature :</h5>
		<h5 style="margin-top:1" id="varUserName"><%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %></h5>
		<h5 class="visitDateonsultannt" style="margin-top:0"></h5>
		
			<div id="footer">
				<div style="margin-top:25px;margin-bottom:16px; border-bottom: 3px solid #265919;"></div>
			<!-- <p style="font-weight:bold;">Referred to any Govt. Hospital/any CGHS Empanelled HCO</p> -->
			<p style="font-weight:bold;">This is a computer-generated prescription; hence, a doctor&#x2019;s stamp is not necessary.</p>
				<ul>
				    <li style="font-size:12px;">&#x921;&#x93F;&#x91C;&#x93F;&#x91F;&#x932;&#x20;&#x905;&#x92A;&#x928;&#x93E;&#x90F;&#x902;&#x2C;&#x20;&#x92D;&#x94C;&#x924;&#x93F;&#x915;&#x20;&#x926;&#x938;&#x94D;&#x924;&#x93E;&#x935;&#x947;&#x91C;&#x93C;&#x94B;&#x902;&#x20;&#x938;&#x947;&#x20;&#x92C;&#x91A;&#x947;&#x902;&#x21; | Go Digital, Avoid Physical Documents!</li>
				    <li style="font-size:12px;">ABHA (&#x906;&#x92F;&#x941;&#x937;&#x94D;&#x92E;&#x93E;&#x928;&#x20;&#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x916;&#x93E;&#x924;&#x93E;) &#x92C;&#x928;&#x93E;&#x90F;&#x902;&#x20;&#x914;&#x930; CGHS &#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x906;&#x908;&#x921;&#x940;&#x20;&#x938;&#x947;&#x20;&#x932;&#x93F;&#x902;&#x915;&#x20;&#x915;&#x930;&#x947;&#x902;&#x964; | Create &amp; Link Your ABHA (Ayushman Bharat Health Account) with CGHS Beneficiary ID.</li>
				    <li style="font-size:12px;">ABHA &#x906;&#x908;&#x921;&#x940;&#x20;&#x92C;&#x928;&#x93E;&#x90F;&#x902;&#x3A; cghs.mohfw.gov.in | Create your ABHA ID at: cghs.mohfw.gov.in.</li>
				    <li style="font-size:12px;">&#x91F;&#x947;&#x932;&#x940;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x20; (Tele Consultation): esanjeevani.mohfw.gov.in &#x938;&#x947;&#x20;&#x918;&#x930;&#x20;&#x92C;&#x948;&#x920;&#x947;&#x20;&#x91A;&#x93F;&#x915;&#x93F;&#x924;&#x94D;&#x938;&#x93E;&#x20;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x20;&#x932;&#x947;&#x902;&#x964; | Avail OPD consultation via esanjeevani.mohfw.gov.in .</li>
				    <li style="font-size:12px;">CGHS &#x932;&#x93E;&#x92D;&#x3A;&#x20;&#x22;&#x92A;&#x924;&#x93E;&#x22;&#x20;&#x92B;&#x93C;&#x940;&#x932;&#x94D;&#x921;&#x20;&#x92E;&#x947;&#x902;&#x20;&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x906;&#x908;&#x921;&#x940;&#x20;&#x926;&#x930;&#x94D;&#x91C;&#x20;&#x915;&#x930;&#x947;&#x902;&#x20;&#x935;&#x20; CGHS &#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x905;&#x92A;&#x932;&#x94B;&#x921;&#x20;&#x915;&#x930;&#x947;&#x902;&#x964; | Enter Beneficiary ID under "Address" &amp; upload CGHS card.</li>
				    <li style="font-size:12px;">&#x92E;&#x93E;&#x928;&#x938;&#x93F;&#x915;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x938;&#x939;&#x93E;&#x92F;&#x924;&#x93E; (Tele-MANAS): &#x92E;&#x941;&#x92B;&#x94D;&#x924;&#x20;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x20;&#x915;&#x947;&#x20;&#x932;&#x93F;&#x90F; 14416 / 1800-91-4416 &#x92A;&#x930;&#x20;&#x915;&#x949;&#x932;&#x20;&#x915;&#x930;&#x947;&#x902;&#x964; | Call Tele-MANAS at 14416 / 1800-91-4416 for free mental health support.</li>
				    <li style="font-size:12px;">&#x939;&#x947;&#x932;&#x94D;&#x92A;&#x932;&#x93E;&#x907;&#x928;&#x3A; CGHS &#x91F;&#x94B;&#x932;&#x2D;&#x92B;&#x94D;&#x930;&#x940; 1800-208-8900 | &#x905;&#x927;&#x93F;&#x915;&#x20;&#x91C;&#x93E;&#x928;&#x915;&#x93E;&#x930;&#x940;&#x20;&#x915;&#x947;&#x20;&#x932;&#x93F;&#x90F; cghs.mohfw.gov.in &#x926;&#x947;&#x916;&#x947;&#x902;&#x964; | CGHS Toll-Free 1800-208-8900 | Visit cghs.mohfw.gov.in for more.</li>
				    <li style="font-size:12px;">myCGHS &#x910;&#x92A;&#x20;&#x921;&#x93E;&#x909;&#x928;&#x932;&#x94B;&#x921;&#x20;&#x915;&#x930;&#x947;&#x902;&#x3A;&#x20;&#x905;&#x92A;&#x949;&#x907;&#x902;&#x91F;&#x92E;&#x947;&#x902;&#x91F;&#x20;&#x92C;&#x941;&#x915;&#x93F;&#x902;&#x917;&#x2C;&#x20;&#x92E;&#x947;&#x921;&#x93F;&#x915;&#x932;&#x20;&#x915;&#x94D;&#x932;&#x947;&#x92E;&#x2C;&#x20;&#x908;&#x2D;&#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x935;&#x20;&#x905;&#x928;&#x94D;&#x92F;&#x20;&#x938;&#x947;&#x935;&#x93E;&#x913;&#x902;&#x20;&#x915;&#x947;&#x20;&#x932;&#x93F;&#x90F; myCGHS &#x910;&#x92A;&#x20;&#x915;&#x93E;&#x20;&#x909;&#x92A;&#x92F;&#x94B;&#x917;&#x20;&#x915;&#x930;&#x947;&#x902;&#x964; | Download the myCGHS App for appointment booking, medical claims, e-card, and other services.</li>
				    <li style="font-size:12px;">&#x90F;&#x92A;&#x94D;&#x932;&#x93F;&#x915;&#x947;&#x936;&#x928;&#x20;&#x909;&#x92A;&#x932;&#x92C;&#x94D;&#x927;&#x3A; Play Store &#x914;&#x930; App Store &#x92A;&#x930;&#x964; | Available on Play Store &amp; App Store.</li>
				    <li style="font-size:12px;">&#x921;&#x93F;&#x91C;&#x93F;&#x91F;&#x932;&#x20;&#x939;&#x947;&#x932;&#x94D;&#x925;&#x915;&#x947;&#x92F;&#x930;&#x20;&#x905;&#x92A;&#x928;&#x93E;&#x90F;&#x902;&#x2C;&#x20;&#x92D;&#x935;&#x93F;&#x937;&#x94D;&#x92F;&#x20;&#x915;&#x94B;&#x20;&#x938;&#x941;&#x930;&#x915;&#x94D;&#x937;&#x93F;&#x924;&#x20;&#x92C;&#x928;&#x93E;&#x90F;&#x902;&#x21; | Go Digital, Secure Your Health Future!</li>
				</ul>
	
			</div>
	
		<div class="page-break"style="width:100%;padding:10px;color:#000;page-break-inside:auto;" id='divDrugPrintable'>
		
		<!-- Header starts here -->
		<table>
		  <thead>	
		  <tr>
		  	<td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
		  	<td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'><h4 style='font-weight:bold;'>
		  	&#x915;&#x947;&#x928;&#x94D;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;
		  	</h4>
		  	<h4>
		  	Central Government Health Scheme	  	
		  	</h4>
		  	<h5 class="" style="font-weight:bold;"><%=objHospitalMstVO.getHospitalName() %></h5>
		  	<%if(objHospitalMstVO.getAddress1()!=null && !objHospitalMstVO.getAddress1().trim().equals("") ){ %>
				<h5 style="font-weight:bold;" ><%=objHospitalMstVO.getAddress1()%></h5>
			<%} %>
			 <h4 style="font-weight:bold;text-decoration: underline;" >MSD Authority Slip</h4> 
		  	</td>
		  	<td style='width:15%;text-align: center;'><span id="patQrCode"></span></td>
		  
		  </tr>
		 </thead> 
		</table>
		<div class='line' id='line1'></div>
		<!-- Header ends here -->
		<!-- Patient details starts here -->
		<table>
		  <tbody>	
		  <tr>
		  	<td style='width:20%;'>
		  	&#x928;&#x93E;&#x92E;
		  	/ Name</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdName'></td>
		  	<td style='width:20%;'>
		  	&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x915;&#x940;&#x20;&#x92A;&#x939;&#x91A;&#x93E;&#x928;&#x20;&#x938;&#x902;&#x2E;
		  	<br/>Beneficiary Id</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdBenId'></td>
		  	
		  </tr>
		  <tr>
		  	<td style='width:20%;'>
		  	&#x906;&#x92F;&#x941;/&#x932;&#x93F;&#x902;&#x917;
		  	/ Age/Gender
		  	</td>
		  	<td style='width:30%;' class='tdAgeGender'></td>
		  
		  	<td style='width:20%;'>
		  	&#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x915;&#x93E;&#x20;&#x92A;&#x94D;&#x930;&#x915;&#x93E;&#x930;
		  	/Card Type</td>
		  	<td style='width:30%;' class='tdCardType'></td>
		  </tr>
		  
		  <tr>
		  	<!-- <td style='width:20%;'>
		  	&#x92E;&#x94B;&#x92C;&#x93E;&#x907;&#x932; / Mobile No.
		  	</td>
		  	<td style='width:30%;'id='tdMobile'></td> -->
		  	<td style='width:20%;'>
		  	&#x938;&#x92E;&#x94D;&#x92C;&#x902;&#x927;
		  	/ Relation
		    </td>
		  	<td style='width:30%;' class='tdRelation'></td>
		  	<td style='width:20%;'>
		  	&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915;
		  	/ Visit Date
		    </td>
		  	<td style='width:30%;' class='tdVisitDate'></td>
		  </tr>
		  <tr>
		  	<td style='width:25%;'>
		  	&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x2F;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x926;&#x93E;&#x924;&#x93E;&#x20;
		  	/ Department/Consultant
		  	</td>
		  	<td style='width:30%;' class='tdDepartment' ></td>
		  	<td style='width:20%;'>&nbsp;</td>
		  	<td style='width:30%;font-weight:bold;'>&nbsp;</td>
		  </tr>
		 </tbody> 	
		</table>


		<div class='line' id='line4'></div>
		<h5 class="Drug sectiontitle" >
		&#x926;&#x935;&#x93E;&#x908;&#x20;&#x915;&#x93E;&#x20;&#x935;&#x93F;&#x935;&#x930;&#x923;/
		Medication Details :</h5>
		<table class='Drug' id="DrugRestricedListTable" style="display: block;"> 
           <thead>
             <tr>
             	<th style="width: 10%;text-align:center">S.No</th>
				<th style="width: 20%">Medicine</th>
				<th style="width: 10%;text-align:center">Dose</th>
				<th style="width: 15%;text-align:center">Frequency</th>				
				<th style="width: 10%;text-align:center">Days</th>
				<th style="width:8%;text-align:center">Status</th>				
				<th style="width: 10%;text-align:center">Quantity</th>										
				<th style="width: 10%">Prescribed By</th>
				<th style="width: 10%">Instruction</th>            		                           
       		</tr>
           </thead>
           <tbody></tbody>
         <!--   <tfoot><tr><td colspan="9"><b>Medicine Status</b> :  R - Restricted , HV - High Value</td></tr></tfoot> --> 
		</table>
		<br/>
		<br/>
		<br/>
		<table>
		  <tbody>	
		  <tr>
		  	<td style='width:70%;border: none;' >
		<h5>Doctor Signature :</h5>
		<h5 style="margin-top:1" id="varUserName"><%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %></h5>
		<h5 class="visitDateonsultannt" style="margin-top:0"></h5>
		</td>
			<td style='width:30%;border: none;'>
				<h5>CMO Signature :</h5>
			</td>	
		</tr>
		</tbody>
		</table>
			<div id="footer">
				<div style="margin-top:25px;margin-bottom:16px; border-bottom: 3px solid #265919;"></div>
			<p id="resDrugEndFlagID" style="font-weight:bold;text-decoration: underline;">CHECK LIST FOR ISSUE OF RESTRICTED MEDICINES (Online)</p>
					<ul>
                        <li style="font-size:12px;">Application to AD (MSD) duly forwarded by CMO I/c</li>
						<li style="font-size:12px;">Computer generated Indent Slip of Restricted medicine issued by CGHS WC</li>
						<li style="font-size:12px;">Photocopy of Specialist's prescription/Discharge Summary (Emergency Case)</li>
						<li style="font-size:12px;">Copy of relevant Investigation reports supporting the diagnosis</li>
						<li style="font-size:12px;">Copy of Referral slip from WC for treatment at CGHS empaneled Hospital</li>
						<li style="font-size:12px;">Photocopy of CGHS Card of patient & primary card holder.</li>
						<li style="font-size:12px;">Utilization Utilization certificate of Restricted Medicine Signed & Stamped by treating specialist/CMO I/c of WC</li>
						<li style="font-size:12px;">For more than one Restricted Medicines, 2(two) copies of indent Slip are required medicine</li>
						<li style="font-size:12px;">Restricted Medicines should be issued as per pack size only</li>
						
						</ul>
						<p style="font-weight:bold;">Note: S. No. 1 to 5 should be verified & duly signed & stamped by CMO I/C of WC.</p>
						<p style="font-weight:bold;text-decoration: underline;">INSTRUCTION FOR COLLECTING RESTRICTED MEDICINES FROM MSD</p>
					<ul>
						<li style="font-size:12px;font-weight:bold;">Authority Letter with copy of Photo ID of the person authorized to collect the medicines.</li>
						<li style="font-size:12px;">MSD Restricted Medicines Indented on Monday to Friday can be collected on next working day or after receipt of SMS. <span style="font-weight:bold;">Medicine Indented on Saturday should be collected on Tuesday</span></li>
						<li style="font-size:12px;">Medicines are to be collected within 15 Days of Indent, otherwise the indent lapses account automatically.</li>
						<li style="font-size:12px;">Patients should bring the ice packs and ice box to carry the medicines and use it as per the instructions of treating Specialist/instruction on the box of medicines</li>
						<li style="font-size:12px;">Empty strip/vials/PFS should be preserved for verification of utilization certificate by CMO IC</li>
						<li style="font-size:12px;">Collection Timings: 2PM to 4PM (Mon-Fri)</li>
						<li style="font-size:12px;">Saturday, Sunday & Gazetted Holiday Restricted Medicine section is closed</li>
						<li style="font-size:12px;">CGHS Helpline - Toll Free Phone Number 1800-208-8900</li>
					 </ul>
					 <p style="font-weight:bold;text-align: center;">Collection Timings: 2PM to 4PM (Mon-Fri) </p>
					 <p style="text-align: center;" >Saturday , Sunday & Gazetted Holiday Restricted Medicine section is closed</p>
					 <p style="font-weight:bold;text-align: center;">CGHS Helpline - Toll Free Phone Number  1800-208-8900</p>
					<p style="font-size:12px;">Legends RM-Restricted Medicine; CM IC: Chief Medical Officer In-charge; ID: Identity WC: Wellness Center; MSD: Medical Store Depot; UC: Utilization Certificate; AD: Additional Director</p>
	
			</div>
		</div>
	</div>
		<div class="page-break"style="width:100%;padding:10px;color:#000;page-break-inside:auto;" id='divPrintable2'>
		
		<!-- Header starts here -->
		<table>
		  <thead>	
		  <tr>
		  	<td style='width:10%;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width:85px;'></td>
		  	<td style='width:80%;text-align: center;vertical-align: top;letter-spacing: 1px'><h4 style='font-weight:bold;'>
		  	&#x915;&#x947;&#x928;&#x94D;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;
		  	</h4>
		  	<h4>
		  	Central Government Health Scheme	  	
		  	</h4>
		  	<h5 class="" style="font-weight:bold;">
		  	<%=objHospitalMstVO.getHospitalName() %> - <%="("+HospitalTypeName+")" %>
		  	</h5>
		  	<%if(objHospitalMstVO.getAddress1()!=null && !objHospitalMstVO.getAddress1().trim().equals("") ){ %>
				<h5 style="font-weight:bold;" ><%=objHospitalMstVO.getAddress1()%></h5>
			<%} %>
			<!-- <h4 style="font-weight:bold;text-decoration: underline;" >OPD Prescription</h4> -->
		  	</td>
		  	<td style='width:15%;text-align: center;'><span id="patQrCode"></span></td>
		  
		  </tr>
		 </thead> 
		</table>
		<div class='line' id='line1'></div>
		<!-- Header ends here -->
		<!-- Patient details starts here -->
		<table>
		  <tbody>	
		  <tr>
		  	<td style='width:20%;'>
		  	&#x928;&#x93E;&#x92E;
		  	/ Name</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdName'></td>
		  	<td style='width:20%;'>
		  	&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x915;&#x940;&#x20;&#x92A;&#x939;&#x91A;&#x93E;&#x928;&#x20;&#x938;&#x902;&#x2E;
		  	<br/>Beneficiary Id</td>
		  	<td style='width:30%;font-weight:bold;font-size: 20px' class='tdBenId'></td>
		  	
		  </tr>
		  <tr>
		  	<td style='width:20%;'>
		  	&#x906;&#x92F;&#x941;/&#x932;&#x93F;&#x902;&#x917;
		  	/ Age/Gender
		  	</td>
		  	<td style='width:30%;' class='tdAgeGender'></td>
		  
		  	<td style='width:20%;'>
		  	&#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x915;&#x93E;&#x20;&#x92A;&#x94D;&#x930;&#x915;&#x93E;&#x930;
		  	/Card Type</td>
		  	<td style='width:30%;' class='tdCardType'></td>
		  </tr>
		  
		  <tr>
		  	<!-- <td style='width:20%;'>
		  	&#x92E;&#x94B;&#x92C;&#x93E;&#x907;&#x932; / Mobile No.
		  	</td>
		  	<td style='width:30%;'id='tdMobile'></td> -->
		  	<td style='width:20%;'>
		  	&#x938;&#x92E;&#x94D;&#x92C;&#x902;&#x927;
		  	/ Relation
		    </td>
		  	<td style='width:30%;' class='tdRelation'></td>
		  	<td style='width:20%;'>
		  	&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915;
		  	/ Visit Date
		    </td>
		  	<td style='width:30%;' class='tdVisitDate'></td>
		  </tr>
		  <tr>
		  	<td style='width:25%;'>
		  	&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x2F;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x926;&#x93E;&#x924;&#x93E;&#x20;
		  	/ Department/Consultant
		  	</td>
		  	<td style='width:30%;' class='tdDepartment'></td>
		  	<td style='width:20%;'>		  	
		  	 Referral Id 
		    </td>
		  	<td style='width:30%;font-weight:bold;'id='tdReferral1'></td>
		  </tr>
		 </tbody> 	
		</table>
		<!-- Patient details ends here -->
		<!--Endorsement  details starts here-->
		<div class='line' id='line2'></div>
		<h5 class="Endorsement sectiontitle" >
		&#x92A;&#x943;&#x937;&#x94D;&#x920;&#x93E;&#x902;&#x915;&#x928;&#x20;&#x935;&#x93F;&#x935;&#x930;&#x923;/
		Endorsement Details :</h5>
		<p class='Endorsement' id="EndorsementDtl"></p>
		<!--Endorsement  details ends here-->
		
		<!--Internal Referral  details starts here-->
		
		<h5 class="InternalReffral sectiontitle">
		&#x930;&#x94B;&#x917;&#x940;&#x20;&#x938;&#x94D;&#x925;&#x93E;&#x928;&#x93E;&#x902;&#x924;&#x930;&#x923;&#x20;&#x935;&#x93F;&#x935;&#x930;&#x923;/
		Patient Transfer Details :</h5>
		<table class='InternalReffral' id="InternalReffralListTable"> 
           <thead>
             <tr>
             	<th style="width:40%;">
            	&#x935;&#x93F;&#x936;&#x947;&#x937;&#x20;&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x20;&#x915;&#x93E;&#x20;&#x928;&#x93E;&#x92E;		                        
            	<br/>
            	Speciality Name</th>
            	<th style='width:60%'>
            	&#2360;&#2381;&#2341;&#2366;&#2344;&#2366;&#2306;&#2340;&#2352;&#2339;&#32;&#2335;&#2367;&#2346;&#2381;&#2346;&#2339;&#2368;
            	<br/>
            	Transfer Note</th>				                           
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		<!--Internal Referral  details ends here-->
		<!--External  Referral  details component wise starts here-->
		<table class='ExternalReffral' id="ExternalReffralListTable" > 
           <thead><!--  -->
             <tr>
             	<th style="width:25%;text-align:center;">Sub-Ref. Id</th>
             	<th style="width:35%;">Component Details</th>
             	<th style="width:25%;">Remarks</th>
             	<th style="width:15%;text-align:center;">Valid Upto</th>
             	<th style="width:10%;text-align:center;">Max. Qty</th>
            	<th style="width:5%;text-align:center">Status</th>		                           
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		<p style="font-weight:bold;">*Status I/O  Refers to  Inside/Outside CGHS Respectively.<p/>
		<br/>
		<br/>
		<br/>
		<h5>Doctor Signature :</h5>
		<h5 style="margin-top:1" id="varUserName"><%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %></h5>
		<h5 class="visitDateonsultannt" style="margin-top:0"></h5>
		
			<div id="footer">
				<div style="margin-top:25px;margin-bottom:16px; border-bottom: 3px solid #265919;"></div>
			<p id="refEndFlagID" style="font-weight:bold;">Referred to any Govt. Hospital/any CGHS empanelled HCO</p>
			<p style="font-weight:bold;">This is a computer-generated prescription; hence, a doctor&#x2019;s stamp is not necessary.</p>
				<ul>
				    <li style="font-size:12px;">For beneficiary download form and other facilities visit cghs.mohfw.gov.in</li>

				</ul>
	
			</div>
	</div>
	
	
	
	<!-- divPrintable ends here -->
	
	
	<script>
	
</script>	
</body>
</html>
