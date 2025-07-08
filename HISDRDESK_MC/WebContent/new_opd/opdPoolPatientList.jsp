<%@page import="hisglobal.vo.UserVO"%>
<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/all.css">
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/fontawesome/css/fontawesome.min.css">
	 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="/HISDRDESK_MC/new_opd/css/mainDesk.css">
	<link rel="stylesheet" type="text/css" href="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/css/dataTables.bootstrap4.min.css"/>
    
	
	<!-- jQuery library -->
	<script src="/HIS/hisglobal/drDeskAssets/jquery/jquery-3.3.1.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
	<link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css.map">
    <script src="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.js"></script>
    <script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/drDeskAssets/DataTables-1.10.18/js/dataTables.bootstrap4.min.js"></script>
	
	<style type="text/css">
		table  td{padding:15px !important;}
		table  th{padding:15px !important;}	
		
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
<body  >
<%
HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);
UserVO objUserVO =ControllerUTIL.getUserVO(request);
%>
	<%String ISSMARTQMSENABLED=(String) request.getSession().getAttribute("ISSMARTQMSENABLED"); %>
	<input type='hidden' id='isSmartQMSEnabled' name="isSmartQMSEnabled" value="<%=ISSMARTQMSENABLED %>">
    <div class='page-content-wrapper' style="width:100%;color:#000;" >
    	<div class="row mainTopHeader">
        
        <div class="col-sm-12 text-right">
        	 <a  type="button" id='refreshList' class='btn-his-outline'> Refresh List</a>
        </div>
        <div class="col-sm-12 " id='divTableContainer' >
		<table class='table table-hover table-condensed table-checkable patientListMainTable' id="opdpoolPatientListTable" style="width: 100%;"> 
           <thead>
             <tr class='tableHeading'>
             	<th style='width:10%'>Q.No./Apt. Time</th>
             	<th style='width:10%'>Ben. ID.</th>
             	<th style="width:20%;">Beneficiary Name</th>
             	<th style="width:10%;">Mobile</th>
             	<th style="width:10%;">Dr. Name</th>
             	<th style="width:5%;"></th> 
             	<th style="width:5%;"></th>             	
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		</div>
		</div>
	</div>
	
	<div class="loader"  >
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
	<input type="hidden" id='hosp_code' name="hosp_code" value="<%=objHospitalMstVO.getHospitalCode() %>">
	<input type="hidden" id='seatId' name="seatId" value="<%=objUserVO.getSeatId() %>">
	
	
	<script>
	$(document).ready(function(){
		getOpdpoolPatientListTable();	 
		$('#refreshList').click(getOpdpoolPatientListTable);	
	});
	
	function getOpdpoolPatientListTable(){
		var str =localStorage.getItem("attendedBenIds");
		var jsonbenIds= {};
		if(str!=undefined && str!=null && str!="" ){
			jsonbenIds=JSON.parse(str);
		}
		$('#opdpoolPatientListTable').DataTable().clear().destroy();
		
		$('#opdpoolPatientListTable tbody').empty();
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var url = '/HISDRDESK_MC/services/restful/patdata/getBendataFromPool?departmentCode='+departmentUnitDtl[0]+'&departmentUnitCode='+departmentUnitDtl[1]+'&hosp_code='+$('#hosp_code').val() + '&isSmartQueueEnabled='+$('#isSmartQMSEnabled').val();
		//alert(url);
			$.ajax({url: url,  
				async:false,
				success: function(result){
					//alert(JSON.stringify(result));
					$('.loader').hide();
					if(JSON.stringify(result)!="{}")
					{
						
						//alert("result >>> "+JSON.stringify(result));
						console.log("result >>> "+JSON.stringify(result));
						console.log(result);
						
						if(result.pat_details!=undefined && result.pat_details.length>0)
						{
							 
								$.each(result.pat_details, function(indx, json){
									var benId =json["hrgnum_beneficiary_id"].trim()
																		
									if(jsonbenIds[benId]!=undefined){
										return;
									}
									jsonbenIds[benId]=benId;
									var html="<tr>";
									if(json["orderbyApt"]=='1'){										
										html+="<td ><span class='badge' style='background: #ffc107;color: #212529;padding: 8px;' >Appt. Time -" +json["aptDt"]+"</span></td>";
									}
									else{
										html+="<td>" +json["hapstr_display_queue_no"]+"</td>";
									}
										html+="<td>" +json["hrgnum_beneficiary_id"]+"</td>";
										html+="<td>" +json["hrgstr_beneficiary_name"]+"</td>";
										html+="<td>" +json["hrgstr_ben_mobile_no"]+"</td>";										
										html+="<td>" +json["dr_name"]+"</td>";
										if(json["orderbyApt"]=='1'){
										html+="<td><a class='btn-his btnlst' data-id='" +json["hrgnum_beneficiary_id"]+"' onclick='AcceptPatientWithApt(this)'>Call</a><span style='display:none;' id='json_" +json["hrgnum_beneficiary_id"]+"'>"+JSON.stringify(json)+"<span></td>";
										}
										else{
											html+="<td><a class='btn-his btnlst' data-id='" +json["hrgnum_beneficiary_id"]+"' onclick='AcceptPatient(this)'>Call</a><span style='display:none;' id='json_" +json["hrgnum_beneficiary_id"]+"'>"+JSON.stringify(json)+"<span></td>";
										}
										if (json["isMoreThanOneUnit"]==1 && json["patientDeptUnitCode"]!="0") 
											html+="<td><a class='btn-his' data-id='" +json["hrgnum_beneficiary_id"]+"' title='send this patient to pool' onclick='backToPool(this)'>Back</a></td>";
										else
											html+="<td>&nbsp;</td>";			
									html+="</tr>";
									
									$('#opdpoolPatientListTable tbody').append(html);
								});

								$('#opdpoolPatientListTable').DataTable({
							           ordering: false,
							           dom: "<'row'<'col-sm-6'f><'col-sm-6 text-start'p>>" + 
							           "<'row'<'col-sm-12'tr>>" + 
							           "<'row'<'col-sm-5'i><'col-sm-7'p>>"

							     })
						}
						else
						{ 
							swal({
								  title: "Status",
								  text: "No Patient Found In Pool",
								  icon: "warning", 
								}).then(function(willDelete) {
									window.parent.closePopUpReferralPatientList();
								});
						}						
					}
					}
				});
	}
	
	function AcceptPatient(objbtn){
		$('.btnlst').hide();
		if($('#isSmartQMSEnabled').val()=="1"){
			AcceptWithSmartQMS(objbtn)
		}
		else{
			UpdateQueueStatus_For_Withoutsmartqueue(objbtn)
		}
		
	}
	
	function AcceptPatientWithApt(objbtn){
		$('.btnlst').hide();
		UpdateQueueStatus_For_WithoutsmartqueueForApt(objbtn);
		
	}

	function UpdateQueueStatus_For_Withoutsmartqueue(objbtn){
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var Id= $(objbtn).attr("data-id");
		
		var json=JSON.parse($('#json_'+Id).text());
		
		var payload ={"status": "1",
				"benId":json["hrgnum_beneficiary_id"],
				"episodeCode":json["hrgnum_episode_code"],
				"visitNo":json["hrgnum_visit_no"],
				"hospitalCode":json["gnum_hospital_code"],
				"patientDeptUnitCode":json["patientDeptUnitCode"],
				"calling_deptunitid":json["callingDeptUnitId"]
				}
		$('.loader').show();
		changeStatusForWithoutSmartQMS(payload , false);

	}
	function UpdateQueueStatus_For_WithoutsmartqueueForApt(objbtn){
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var Id= $(objbtn).attr("data-id");
		
		
		var userId=$('#seatId').val().split('^')[0];
		
		
		var json=JSON.parse($('#json_'+Id).text());
		
		var payload ={"status": "1",
				"benId":json["hrgnum_beneficiary_id"],
				"episodeCode":json["hrgnum_episode_code"],
				"visitNo":json["hrgnum_visit_no"],
				"hospitalCode":json["gnum_hospital_code"],
				"patientDeptUnitCode":json["patientDeptUnitCode"],
				"calling_deptunitid":json["callingDeptUnitId"],
				"p_seatid":userId
				}
		
		$('.loader').show();
		changeStatusForWithoutSmartQMSForApt(payload , false);

	}
	function AcceptWithSmartQMS(objbtn){
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var Id= $(objbtn).attr("data-id");
		var json= JSON.parse($('#json_'+Id).text());
			//PROCEDURE save_bendata_dr_pool(modevalue character varying, hospitalcode character varying,
			// deptunitid character varying, internalqueueno character varying, queuesymbol character varying, 
			//OUT err character varying) IS
	
		var data={
			"hospitalcode":$('#hosp_code').val(),
			"deptunitid":departmentUnitDtl[1],
			"internalqueueno":json["hapnum_internal_queue_no"],
			"queuesymbol":json["hapstr_queue_symbol"]
		};
		$('.loader').show();
		$.ajax({	
					url:'/HISDRDESK_MC/services/restful/DrDesk/AcceptPatientFromPoolSmartQMS',
					type:'POST',
					data:JSON.stringify(data),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					success:function(result){
						$('.loader').hide();
						var status=result["status"];
						
						if(status=='SUCCESS')
							window.parent.refreshPatientData(this);
						else{
							swal({
								  title: "Status",
								  text: "call Incomplete !!",
								  icon: "warning", 
								});
						}	
					}
		});

		}


	function backToPool(objbtn){
		  var flagcall= confirm("If you send your patient to  back To pool then other doctor can pick it from it \n Are you sure? ");
		  
		  if(flagcall==false){
			  return;
		  }
		
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var Id= $(objbtn).attr("data-id");
		
		var json=JSON.parse($('#json_'+Id).text());
		
		var payload ={"status": "4",
				"benId":json["hrgnum_beneficiary_id"],
				"episodeCode":json["hrgnum_episode_code"],
				"visitNo":json["hrgnum_visit_no"],
				"hospitalCode":json["gnum_hospital_code"],				
				}
		
		changeStatusForWithoutSmartQMS(payload , true);
	}


function changeStatusForWithoutSmartQMS(payload, loadSameListinPopUp){
		
		$('.loader').show();
		$.ajax({	
					url:'/HISDRDESK_MC/services/restful/DrDesk/UpdateQueueStatus_For_Withoutsmartqueue',
					type:'POST',
					data:JSON.stringify(payload),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					success:function(result){
						$('.loader').hide();
						var status=result["status"];
						
						if(status=='SUCCESS')
							if(loadSameListinPopUp)
								getOpdpoolPatientListTable()
							else	
								window.parent.refreshPatientData(this);
						else{
							swal({
								  title: "Status",
								  text: "call Incomplete !!",
								  icon: "warning", 
								});
						}	
					}
		});

	}
function changeStatusForWithoutSmartQMSForApt(payload, loadSameListinPopUp){
	
	$('.loader').show();
	$.ajax({	
				url:'/HISDRDESK_MC/services/restful/DrDesk/UpdateQueueStatus_For_WithoutsmartqueueForApt',
				type:'POST',
				data:JSON.stringify(payload),
				dataType : "json",
				contentType: "application/json; charset=UTF-8",
				success:function(result){
					$('.loader').hide();
					var status=result["status"];
					
					if(status=='SUCCESS')
						if(loadSameListinPopUp)
							getOpdpoolPatientListTable()
						else	
							window.parent.refreshPatientData(this);
					else{
						swal({
							  title: "Status",
							  text: "call Incomplete !!",
							  icon: "warning", 
							});
					}	
				}
	});

}
	
</script>	
</body>
</html>
