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

	<!-- jQuery library -->
	<script src="/HIS/hisglobal/drDeskAssets/jquery/jquery-3.3.1.min.js"></script>
	<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
	<script src="/HIS/hisglobal/drDeskAssets/qrcodejs/qrcode.min.js"></script> 
	  <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css.map">
    <script src="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.js"></script>
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
	</style>
</head>
<body  >
<%
HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);
UserVO objUserVO =ControllerUTIL.getUserVO(request);
%>
	<div class='page-content-wrapper' style="width:100%;padding:10px;color:#000;" >
		<table class='table table-hover table-condensed table-checkable patientListMainTable' id="InternalReffralListTable" style="width: 100%;"> 
           <thead>
             <tr class='tableHeading'>
             	<th style='width:10%'>BenId</th>
             	<th style="width:20%;">Beneficiary Name</th>
             	<th style="width:10%;">Gender/Age</th>
             	<th style="width:20%;">Transferred From Speciality<br/>/ Dr. Name</th>
             	<th style="width:15%;">Remarks</th>
             	<th style="width:15%;">Refer Date</th>
             	<th style="width:10%;">Action</th>
       		</tr>
           </thead>
           <tbody></tbody> 
		</table>
		
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
		getPatientListData();	 	
	});
	
	function getPatientListData(){
		var departmentUnitDtl = localStorage.getItem("departmentUnitDtl").split('#');
		var url = '/HISDRDESK_MC/services/restful/patdata/getInternalReferralPatientData?departmentCode='+departmentUnitDtl[0]+'&departmentUnitCode='+departmentUnitDtl[1]+'&hosp_code='+$('#hosp_code').val();
		//alert(url);
			$.ajax({url: url,  
				async:false,
				success: function(result){
					//alert(JSON.stringify(result));
					if(JSON.stringify(result)!="{}")
					{
						$('.loader').hide();
						//alert("result >>> "+JSON.stringify(result));
						console.log("result >>> "+JSON.stringify(result));
						console.log(result);
						if(result.pat_details!=undefined)
						{
							if(result.pat_details.length>0)
							{ 
								$.each(result.pat_details, function(indx, json){
									var html="<tr>";
										html+="<td>" +json["BenID"]+"</td>";
										html+="<td>" +json["BenefiaryName"]+"</td>";
										html+="<td>" +json["ageGender"]+"</td>";
										html+="<td>" +json["DepartmentUnit"]+"</td>";
										html+="<td>" +json["Remarks"]+"</td>";
										html+="<td>" +json["ReferDate"]+"</td>";
										html+="<td><a class='btn-his' data-id='" +json["pkcolumn"]+"' onclick='VisitStamp(this)'>Accept</a></td>";
									html+="</tr>";
									$('#InternalReffralListTable').append(html);
								});
							}
							else
							{ 
								
								swal({
									  title: "Status",
									  text: "No Transferred Patient Found",
									  icon: "warning", 
									}).then(function(willDelete) {
										window.parent.closePopUpReferralPatientList();
									});
							}
						}
						else
						{ 
							swal({
								  title: "Status",
								  text: "No Referral Patient Found",
								  icon: "warning", 
								}).then(function(willDelete) {
									window.parent.closePopUpReferralPatientList();
								});
						}						
					}
					}
				});
	}
	function VisitStamp(objbtn){
		
		var arrId= $(objbtn).attr("data-id").split("@");

		//a.hrgnum_puk||''@''|| a.hrgnum_episode_code||''@''||a.hrgnum_visit_no||''@''|| a.hrgnum_s_no
		//||''@''||hrgnum_to_dept_code||''@''||hgnum_to_deptunitcode as pkcolumn

		var data={"CR_No":arrId[0], 
				"episodeCode":arrId[1] ,
				"visitNo":arrId[2] , 
				"refSno":arrId[3],
				"to_dept_code":arrId[4],
				"to_deptunitcode":arrId[5], 
				"hospitalCode":$('#hosp_code').val(),
				"seatId":$('#seatId').val() };
		$('.loader').show();
		$.ajax({	
					url:'/HISDRDESK_MC/services/restful/DrDesk/ReferralVisitStamping',
					type:'POST',
					data:JSON.stringify(data),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					success:function(result){
						$('.loader').hide();
						var status=result["status"];
						
						if(status==1)
							window.parent.refreshPatientData(this);
						else{
							swal({
								  title: "Status",
								  text: "Visit not confirmed !!",
								  icon: "warning", 
								});
						}	
					}
		});
		
	}
</script>	
</body>
</html>
