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
<body>

	<div class='page-content-wrapper' style="width:100%;padding:10px;color:#000;" >		
			<div class='row' style="margin-bottom: 10px;">
			 <div class="col-md-4">
              	<p style="letter-spacing:0">Beneficiary Name : <label id='benName'>Beneficiary Name</label></p>              	
              </div> 
              <div class="col-md-4">
              	<p style="letter-spacing:0">Beneficiary Id : <label id='benId'>Beneficiary Id</label></p>
              	
              </div>
              <div class="col-md-4">
              	<p style="letter-spacing:0">Gender/Age/Mobile : <label id='genderAgeMobile'>gen</label></p>
              	
              </div>	
			
			 <div class="col-md-12" style="display: none;" >
                    <p style="letter-spacing:0"><label>Patient Rating</label></p>
                    
                    <div class="form-check">
  						<input class="form-check-input" type="radio" name="patientRating" value="1" id="patientRating1">
  						<label class="form-check-label text-danger" for="patientRating1">Poor experience (non-compliance, rude, etc.)</label>
					</div>
					<div class="form-check">
  						<input class="form-check-input" type="radio" checked="checked" name="patientRating" value="5" id="patientRating5">
  						<label class="form-check-label text-primary" for="patientRating5">Average (neutral experience)</label>
					</div>
					<div class="form-check">
  						<input class="form-check-input" type="radio" name="patientRating" value="10" id="patientRating10">
  						<label class="form-check-label text-success" for="patientRating10">Excellent (fully cooperative, follows advice, respectful)</label>
					</div> 
              </div>
              <div class="col-md-12">
              	<p style="letter-spacing:0"><label>Remarks</label></p>
              		<input type='text' class="form-control" maxlength="100" id='remarks' name="remarks" >  
              </div>
              <div class="col-md-12" style='text-align: center;margin-top: 10px;'>
              	<a class='btn-his' id='btnSave'>Save</a>
              </div>
              <input type='hidden' name="reviewGivenBy" id="reviewGivenBy" value="<%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %>" />	 
        	 </div>
         <div class='row'>
			<div class="col-md-12">
	          	<table class='table table-hover table-condensed table-checkable' id="reviewListTable" style="width: 100%;"> 
		           <thead>
		             <tr class='tableHeading'>
		             	<!-- <th style="width:25%;text-align:center;">Review Rating</th> -->
		             	<th style="width:30%;">Review Remarks</th>
		             	<th style="width:25%;">Review Given By</th>
		             	<th style="width:20%;">Review Date</th>		             			                           
		       		</tr>
		       	   </thead>
		           <tbody>
		           </tbody> 
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
	
	
	<script>
	$(document).ready(function(){
		
		
		$('.loader').hide();
		$('#btnSave').click(savePatientReview);

		  
		var strPatdtl=localStorage.getItem("patdtl");

	    if(strPatdtl==undefined  || strPatdtl==null ||  strPatdtl==""){
	        console.log("patdtl not found")
	        return;
	    }
	    var patjson = 	JSON.parse(strPatdtl);	
		$('#benName').text(patjson["patientName"]);
		$('#benId').text(patjson["CR_No"]);
		$('#genderAgeMobile').text(patjson["genderAgeMobile"]);
	    
		getPreviousPatientReviewData();
		/* getCRNoWiseExternalReferralData();	 
		$('#referStatus').change(getCRNoWiseExternalReferralData);
		$('#search').keyup(searchData);	 */
	});

	

function savePatientReview(){
	
	if($('[name=patientRating]').is(":checked")==false){
		alert("Please select patient rating");
		return;
	}
	if($('[name=remarks]').val().trim()==""){
		alert("Please enter your remarks");
		return;
	}

	
    var strPatdtl=localStorage.getItem("patdtl");

    if(strPatdtl==undefined  || strPatdtl==null ||  strPatdtl==""){
        console.log("patdtl not found")
        return;
    }
	var data = 	JSON.parse(strPatdtl);	

	data["reviewStatus"]=$('[name=patientRating]:checked').val();
	data["reviewRemarks"]=$('[name=remarks]').val();
	data["reviewGivenBy"]=$('[name=reviewGivenBy]').val();
	
	
	
	$('.loader').show();
		
		$.ajax({	
					url:'/HISDRDESK_MC/services/restful/DrDesk/savePatientReview',
					type:'POST',
					data:JSON.stringify(data),
					dataType : "json",
					contentType: "application/json; charset=UTF-8",
					success:function(result){
						
						var status=result["status"];
						if(result["status"]=="SUCCESS"){
							swal({
								  title: "Status",
								  text: "Review Given Successfully !!",
								  icon: "success", 
								});
							getPreviousPatientReviewData();
						}
						else{
							$('.loader').hide();
							swal({
								  title: "Status",
								  text: "Problem while saving record !!",
								  icon: "danger", 
								});
							}
						
							
					}
		});
		
	}
	
	 
	function getPreviousPatientReviewData(){
		$('#reviewListTable tbody').empty()

		 var strPatdtl=localStorage.getItem("patdtl");

	    if(strPatdtl==undefined  || strPatdtl==null ||  strPatdtl==""){
	        console.log("patdtl not found")
	        return;
	    }
		var patjson = 	JSON.parse(strPatdtl);	

	
		$('.loader').show();
		
		var seatId=patjson["seatId"].split("^")[1];
		var url = '/HISDRDESK_MC/services/restful/patdata/getPreviousPatientReviewData?crNo='+patjson["CR_No"]+
				  '&episodeCode='+patjson["episodeCode"]+'&visitNo='+patjson["visitNo"]+'&seatId='+seatId+
		 		   '&hosp_code='+patjson["hospitalCode"];
		 
		//	alert(url);
			$.ajax({url: url,  
				async:false,
				success: function(result){
					$('.loader').hide();
					if(result["status"]=="1" && result["data"].length>0){
						var html="";
						$.each(result["data"],function(indx, objjson){
							var trColor='#fff';
							if(objjson["reviewStatusNo"]=="1")
								trColor="#F6D6D6";
							html="<tr class='searchRow ' style='background-color:"+trColor+"'>";
							/* html+="<td>"+objjson["reviewStatus"] +"</td>"; */
							html+="<td>"+objjson["reviewRemarks"] +"</td>";
							html+="<td>"+objjson["reviewGivenBy"] +"</td>";
							html+="<td>"+objjson["reviewDate"] +"</td>";														
							html+="</tr>";
							$('#reviewListTable tbody').append(html);	
						});
					}
					if($('#reviewListTable tbody tr').length==0){
						$('#reviewListTable tbody').append("<tr><td class='bg-danger' style='text-align:center' colspan='4'>No Record Found</td></tr>");
					} 
					
				} 
		});
	} 
	





	
	
</script>	
</body>
</html>
