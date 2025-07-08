<!-- 
 ## Copyright Information				: C-DAC, Noida  
 ## Project Name				       	: PUNJAB AHIS
 ## Name of Developer		 			: Manish
 ## Module Name					        : INVESTIGATION
 ## Process/Database Object Name	    : OFFLINE RESULT ENTRY
 ## Date of Creation					: 06/01/2021
   -->
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="new_investigation.InvestigationConfig"%>
<script type="text/javascript" src="/HISInvestigationG5/hisglobal/js/dojotoolkit/dojo/dojo.js" djConfig="parseOnLoad: true"> </script>
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
<!--   <script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/sth.js"></script> -->
<script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/hisglobal/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript" src="/HISInvestigationG5/new_investigation/js/invOfflineResEntry.js"></script>

  
  
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
<body  onload="onload();" style="font-size: 12px;">
<div class="content-wrapper" style="margin-left: 0;">

<logic:equal value="1" name="InvOfflineResultEntryFB" property="strMsgType">
<div id= "msgId" style="float:center;margin-left: 42%;color: red;font-weight: bold;font-size: 12px;padding-top: 5px;">
<bean:write name="InvOfflineResultEntryFB" property="strMsgString" filter="false"/> 
</div>
</logic:equal>
<logic:equal value="0" name="InvOfflineResultEntryFB" property="strMsgType">
<div id= "msgId" style="float:center;margin-left: 42%;color: green;font-weight: bold;font-size: 12px;padding-top: 5px;">
<bean:write name="InvOfflineResultEntryFB" property="strMsgString" filter="false"/> 
</div>
</logic:equal>
  <!-- Main content -->
  <section class="content">
    <!-- Small boxes (Stat box) -->
    <div class="row">
      <div class="col-md-12 col-xs-12">
        <div class="box box-solid box-primary">
         <div class="box-header" style="padding: 3px 0 3px 10px;">
                    <span style="width:50%;float: left;"><h3 class="box-title" style="font-size: 15px;">Offline Result Entry Process</h3></span>
                    <span style="width:50%;float: left;text-align: right;">
                    <label class="checkbox-inline"><input type="checkbox" name = "isOldPatient" value="" onclick = "oldPatDtl(this);">Is Already Registered?</label>
                    <label class="checkbox-inline"><input type="checkbox" name = "viewResultEntryChk" value="" onclick = "showResultEntries();">View Result Entries</label>
                    </span>
        </div>
          <!-- /.box-header -->
          
          <form role="form" id="orderCreate" action="" method="post" class="form-horizontal">
          
         <!--  Div to input CR number in case of already registered patient. -->
         
              <div class="box-body" style="padding: 10px 3px 0px 3px;">
              <div class="col-md-12 col-xs-12" id = "showPatCRNoId" style= "display: none;">
              	<div class="form-group"> 
                    <label for="po_no" class="col-sm-2 control-label"><font color="red">*</font>Reg. No. :</label> 
                    <div class="col-sm-2">
              			<input type='text' class='form-control' id='patCRNoId' name='patCRNo' placeholder="Enter Reg. Number" autocomplete='on' minlength="10" maxlength = "10" onkeyup= "validateInputType(this,'2');"/>
              		</div>
              		<div class="col-sm-1 control-label" style="text-align:right;">
              			<span><font style= "size:14px;font-weight:bold;">OR</font></span>
              		</div>
              		 <label for="po_no" class="col-sm-2 control-label"><font color="red">*</font>Mobile No. :</label> 
                    <div class="col-sm-2">
              			<input type='text' class='form-control' id='patMobNoId' name='patMobNo' placeholder="Enter Mobile Number" autocomplete='on' minlength="10" maxlength = "10" onkeyup= "validateInputType(this,'2');"/>
              		</div>
              		 <div class="col-sm-2">
              		 <a href='#' id='getPatDtl' class='btn btn-success' onclick = 'getPatDtl();' data-toggle='modal'>Go</a>
              		  <a href='#' id='getPatDtl' class='btn btn-warning' onclick = 'resetFields();'>Reset</a>
              		 </div>
              	</div>
               </div>
               
               <!--  Div to display patient's detail in case of already registered patient. -->
               <!-- Not Reqd. Filled data to the input fields. -->
               <%--  <div class="col-md-12 col-xs-12" id = "patInfoDivId" style= "display: none;">
                	<bean:write name="InvOfflineResultEntryFB" property="strOfflineResEntPatDtl" filter="false"/>
                </div> --%>
                <div class="col-md-12 col-xs-12" id = "patDtlId">
                <div class="form-group"> 
                    <label for="po_no" class="col-sm-2 control-label"><font color="red">*</font>Patient Name :</label> 
                    <div class="col-sm-4">                       
                      <input type="text" class="form-control" id="patName" name="patName" required placeholder="Enter Patient Name" autocomplete="off" onkeyup= "return validateInputType(this,'1');">
                    </div>                   
                    <label for="qtn_ref" class="col-sm-2 control-label"><font color="red">*</font>Gender :</label>
                    <div class="col-sm-4">
					   <select name="patGenderCode" id="patGenderCodeId" class="form-control select_group product" required>
				         <option value="-1">Select Value</option>
				         <option value="F">Female</option>
				         <option value="M">Male</option>
				         <option value="T">Transgender</option>
			         </select>
			         </div>
                    </div>                    
               <!--  </div> 
                 
                <div class="col-md-12 col-xs-12"> -->
                  <div class="form-group">
                    <label for="supplier_name" class="col-sm-2 control-label"><font color="red">*</font>Age :</label>
                    <div class="col-sm-4" style="padding-left: 0px;">
                        <div class="col-sm-6">
                          <input type="text" class="form-control" id="strPatAge" name="strPatAge" required placeholder="Enter Age" autocomplete="off" minlength= "1" maxlength = "5" onkeyup= "validateInputType(this,'2');" onblur= "validateAge();">
                        </div>
					    <div class="col-sm-6">
                       <select class="form-control" id="strPatAgeUnit" name="strPatAgeUnit" required onchange = "validateAge();">
                         <option value="Y">Year(s)</option>
                         <option value="M">Month(s)</option>
                         <option value="W">Week(s)</option>
                         <option value="D">Day(s)</option>
                       </select>                                         
                    </div>
                    
                    </div>
                    <label for="indent_name" class="col-sm-2 control-label"><font color="red">*</font>Father/Mother/Spouse Name :</label>
                    <div class="col-sm-4">
					  <input type="text" class="form-control" id="patGuardianName" name="patGuardianName" required placeholder="Enter Father/Mother/Spouse Name" autocomplete="off" onkeyup= "return validateInputType(this,'1');">
                    </div>
                  </div>
               <!--  </div>
                
                <div class="col-md-12 col-xs-12"> -->
                  <div class="form-group">
                    <label for="supplier_name" class="col-sm-2 control-label"><font color="red">*</font>Mobile No. :</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="patMobileNo" name="patMobileNo" required placeholder="Enter Mobile No." autocomplete="off" minlength="10" maxlength = "10" onkeyup= "validateInputType(this,'2');"> <!-- onblur = "return validateMobNo();" -->
                    </div>
                    <label for="indent_name" class="col-sm-2 control-label"><font color="red">*</font>Address :</label>
                    <div class="col-sm-4">
					  <input type="text" class="form-control" id="patAdd" name="patAdd" required placeholder="Enter Address" autocomplete="off" onkeyup= "validateInputType(this,'3');">
                    </div>
                  </div>
                 </div>
                <div class="col-md-12 col-xs-12" id = "patTestDateDtlId"> 
                <div class="form-group"> 
                    <label for="rec_by_date" class="col-sm-2 control-label" ><font color="red">*</font>Sample Collection Date :</label>
                    <div class="col-sm-4">
                       <input type="text" class="form-control" id="samplecoldate" name="samplecoldate" value="" autocomplete="off" data-toggle="tooltip" required onchange="validateDates();">
                        
                    </div>                                      
                    <label for="rec_by_date" class="col-sm-2 control-label" ><font color="red">*</font>Result Entry Date :</label>
                    <div class="col-sm-4">
                       <input type="text" class="form-control" id="resultDate" name="resultDate" value="" autocomplete="off" data-toggle="tooltip" required onchange="validateDates();">
                        
                    </div>
                   </div>                    
               <!--  </div>
                
                <div class="col-md-12 col-xs-12"> -->
                <div class="form-group"> 
                                       
                    <label for="qtn_ref" class="col-sm-2 control-label"><font color="red">*</font>Hospital Name :</label>
                    <div class="col-sm-4">
					   <select name="strPatHospCode" id="strPatHospCodeId" class="form-control select_group product" onchange="isDuplicacyAllowed(this);" required data-toggle="modal" >
					   <bean:write name="InvOfflineResultEntryFB" property="strHospitalList" filter="false"/>
			         </select>
			         </div>
                    </div>                    
                </div>
                
                 <div class="col-md-12 col-xs-12" id= "offlineTestsListId" style="padding-right: 0px;padding-left: 0px;">
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
              <!-- /.box-body -->

				<input type="hidden" name="hmode" />
				<input type="hidden" name="isAlreadyPatient" value="0"/>	
				<input type="hidden" name="isDuplicacyChkRqd" value="0"/>
              <div class="box-footer" id = "offlineEntryFormFooterId">
                <!-- <a href="" class="btn btn-success" onclick = "saveOfflineResEntry();">Save</a> -->
                <button type = "submit" class="btn btn-success">Save</button>
                <a href="" class="btn btn-warning" id= "reset_btn_id">Reset</a>
                <div class="modal"><!-- Place at bottom of page --></div>
                
     <div id = "duplicatePatientListId" class="modal fade" role="dialog">
      <div class="modal-dialog">
      <!-- Modal content-->
        <div class="modal-content">
          <div class="modal-header">
          		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            	<h4 class="modal-title" id="myModalLabel">Patient with similar data already exists</h4>
      		</div>
      		<!-- Modal body -->
      		<div class="modal-body" id = "dupPatListDataId">
          		 <bean:write name="InvOfflineResultEntryFB" property="strDupPatList" filter="false"/> 
       		 </div>
      	</div>
      	</div>
      </div>
                
              </div>
            </form>
          <!-- /.box-body -->
        </div>
        <!-- /.box -->
      </div>
      <!-- col-md-12 -->
    </div>
    <!-- /.row -->
    

  </section>
  <!-- /.content -->
</div>
<!-- /.content-wrapper -->

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

<script type="text/javascript">
$(document).ready(function() {

    $('form').on('submit', function(e) {

    	validateMobNo();
	    validateAge();
	    validateDates();
	    //alert("inside save fution");
	    var h= document.getElementById("strPatHospCodeId");
		var hospCode = h.options[h.selectedIndex].value;

		if(hospCode== "0"){
			alert("Please Select Hospital Name !");
			e.preventDefault(e);
			}
		
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
    					alert("hello g");
    				 	document.forms[0].hmode.value = "insert";
    				  	document.forms[0].submit();
    				}
    	 		
    			if(document.forms[0].isAlreadyPatient.value == "1"){

    				var nodes = document.getElementById("patDtlId").getElementsByTagName('*');
    				for(var i = 0; i < nodes.length; i++){
    				     nodes[i].disabled = true;
    				  }
    				//document.getElementById("patCRNoId").readOnly = true;
    				  
    				document.forms[0].hmode.value = "saveAlreadyRegPat";
    				document.forms[0].submit();
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
  </script>
</body>

</html>  