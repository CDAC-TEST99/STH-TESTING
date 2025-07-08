<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>

<!-- 

 ** Module 			 : INVESTIGATION
 ** Process  		 : Offline Result Entry Modify Page
 ** Developer		 : DEEPTI AGRAWAL, CDAC-NOIDA
 ** Date of Creation : 05.03.2021

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
</head>
<body>
<div class="row">
      <div class="col-md-12 col-xs-12">
        <div class="box box-solid box-primary">
         <div class="box-header" style="padding: 3px 0 3px 10px;">
          <span style="width:50%;float: left;"><h3 class="box-title" style="font-size: 15px;">Offline Result Entry Process</h3></span>
         </div>
          <!-- /.box-header -->

	<form role="form" id="invOfflineModifyId" action="" method="post" class="form-horizontal">

			<div class="col-md-12 col-xs-12">
                <div class="form-group"> 
                    <label for="po_no" class="col-sm-2 control-label"><font color="red">*</font>Patient Name :</label> 
                    <div class="col-sm-4">                       
                      <input type="text" class="form-control" id="patName" name="patName" required placeholder="Enter Patient Name" autocomplete="off" onkeyup= "return validateInputType(this,'1');" value = "${InvOfflineResultEntryFB.patName}">
                    </div>                   
                    <label for="qtn_ref" class="col-sm-2 control-label"><font color="red">*</font>Gender :</label>
                    <div class="col-sm-4">
					   <select name="patGenderCode" id="patGenderCodeId" class="form-control select_group product" required value = "${InvOfflineResultEntryFB.patGenderCode}">
				         <option value="-1">Select Value</option>
				         <option value="F">Female</option>
				         <option value="M">Male</option>
				         <option value="T">Transgender</option>
			         </select>
			         </div>
			         
			         <label for="supplier_name" class="col-sm-2 control-label"><font color="red">*</font>Age :</label>
                    <div class="col-sm-4" style="padding-left: 0px;">
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="strPatAge" name="strPatAge" required placeholder="Enter Age" autocomplete="off" minlength= "1" maxlength = "3" onkeyup= "validateInputType(this,'2');" value= "${InvOfflineResultEntryFB.strPatAge}">
                        </div>
					    <div class="col-sm-6">
                       <select class="form-control" id="strPatAgeUnit" name="strPatAgeUnit" required value = "${InvOfflineResultEntryFB.strPatAgeUnit}">
                         <option value="Y">Year</option>
                         <option value="M">Month</option>
                         <option value="W">Weeks</option>
                         <option value="D">Days</option>
                       </select>                      
                    </div>
                    </div>   
                    
                    <label for="indent_name" class="col-sm-2 control-label"><font color="red">*</font>Father/Spouse Name :</label>
                    <div class="col-sm-4">
					  <input type="text" class="form-control" id="patGuardianName" name="patGuardianName" required placeholder="Enter Father/Spouse Name" autocomplete="off" onkeyup= "return validateInputType(this,'1');" value= "${InvOfflineResultEntryFB.patGuardianName}">
                    </div>  
                     <label for="supplier_name" class="col-sm-2 control-label"><font color="red">*</font>Mobile No. :</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="patMobileNo" name="patMobileNo" required placeholder="Enter Mobile No." autocomplete="off" minlength="10" maxlength = "10" onkeyup= "validateInputType(this,'2');" value= "${InvOfflineResultEntryFB.patMobileNo}">
                    </div>
                    <label for="indent_name" class="col-sm-2 control-label"><font color="red">*</font>Address :</label>
                    <div class="col-sm-4">
					  <input type="text" class="form-control" id="patAdd" name="patAdd" required placeholder="Enter Address" autocomplete="off" value= "${InvOfflineResultEntryFB.patAdd}">
                    </div>  
                    
                       <label for="rec_by_date" class="col-sm-2 control-label" ><font color="red">*</font>Sample Collection Date :</label>
                    <div class="col-sm-4">
                       <input type="text" class="form-control" id="samplecoldate" name="samplecoldate" value="" autocomplete="off" data-toggle="tooltip" title="Enter date to received item after 12 days" required>
                    </div>                                      
                    <label for="rec_by_date" class="col-sm-2 control-label" ><font color="red">*</font>Result Entry Date :</label>
                    <div class="col-sm-4">
                       <input type="text" class="form-control" id="resultDate" name="resultDate" value="" autocomplete="off" data-toggle="tooltip" title="Enter date to received item after 12 days" required value= "${InvOfflineResultEntryFB.resultDate}">
                    </div>          
	
					<label for="qtn_ref" class="col-sm-2 control-label"><font color="red">*</font>Hospital Name :</label>
                    <div class="col-sm-4">
					   <select name="strPatHospCode" id="strPatHospCodeId" class="form-control select_group product" onchange="" required > 
					 <%--  <bean:write name="InvOfflineResultEntryFB" property="strPatHospCode" filter="false"/>  --%>
			         </select>
			         </div>
				</div>
				
				<div class="col-md-12 col-xs-12" style="padding-right: 0px;padding-left: 0px;">
                 <div class="box box-solid box-primary" style="border: 0px;">
                 <div class="box-header" style="padding: 10px 0 10px 10px;;">
                    <h3 class="box-title" style="font-size: 13px;">Test Details</h3>
                 </div>
                
                  <div class="box-body">
                  <div id="divtestdtl"> 
                   <bean:write name="InvOfflineResultEntryFB" property="strResultDtl" filter="false"/> 
                  </div>
                  </div>
                  </div>
                </div>
             </div>
             
             <div class="box-footer">
                <!-- <a href="" class="btn btn-success" onclick = "saveOfflineResEntry();">Save</a> -->
                <button type = "submit" class="btn btn-success">Save</button>
                <a href="" class="btn btn-warning">Back</a>
                <div class="modal"><!-- Place at bottom of page --></div>
              </div>

<input type="hidden" name="hmode" />
<input type="hidden" name="samplecoldate" id= "collectionDateId" value= "${InvOfflineResultEntryFB.samplecoldate}"/>

</form>
</div>
<!-- /.box -->
</div>
<!-- col-md-12 -->
</div>
<!-- /.row -->
<script type="text/javascript">
$(document).ready(function() {

	 document.getElementById("resultDate").value = document.getElementById("collectionDateId").value;
	
$("#samplecoldate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});
    $("#resultDate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',});
});
</body>
</html>