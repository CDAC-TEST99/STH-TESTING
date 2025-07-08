<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <!-- Font Awesome -->
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">  
  <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.css">
  <link href="/HIS/hisglobal/cdac_awesome/css/animate.min.css" rel="stylesheet" >
  <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
  <link href="/HIS/hisglobal/images/logo.ico" rel="icon"  type="image/x-icon">
  
  
  
  
<!-- jQuery -->
<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/external/jquery/jquery.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/js/wow.min.js"  ></script>
<script src="/HIS/hisglobal/FormFlowX/js/jquery.easing.min.js"  ></script>
  
<!-- Bootstrap 4 -->
<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
  
 <script src="/HIS/hisglobal/FormFlowX/js/security.js"></script> 
 <script src="/CGHSCardMgmt/global/js/md5.js"></script>
 <script src="/HIS/hisglobal/FormFlowX/js/commonFunctions.js"></script>
 <style type="text/css">
  .carousel-caption{
  top:30%;
 }
 .para{
 	background: #fff;color:navy;text-align: left; margin-bottom: 3px;margin-bottom: 3px;
  font-size: 13px;
  padding: 5px;
 } 
 .kpistyle{
border-radius:15px;padding: 10px;box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;background-color: white;margin: 10px;
}
.queueno{
border: 5px solid green;border-radius: 50%;text-align: center;margin-top: ;padding: 30px;color: #000;
font-size: 80px;
font-family: Futura;
text-shadow: 1px 4px 4px #555;
text-align: center;
-webkit-background-clip: text;
-moz-background-clip: text;
}
.headerFooter{background-color: black;color: #fff;padding: 10px;}
.textCall{
 color:blue;
font-size: 20px;
}

.bg-new{
 	background: #FFE79B
}
.bg-disabled{
 	background: #9BA4B5
}
 
 
 </style>
<script type="text/javascript">
var datahtml=[];
/* var datahtml=[
    {
        "departmentunitcode": "10211",
        "deptcode": "102",
        "DepartmentName": "Cardiology",
        "unitStatusCode": "1",
        "UnitName": "Dr. Ajay Gupta",
        "Room": "1215#102",
        "hospitalCode": "3726001",
        "unitStatus": "Started"
    },
    {
        "queueNoJson": "[{\"displayqueueno\":\"4E\",\"benname\":\"Shanti Devi\",\"queuestatus\":\"0\"},{\"displayqueueno\":\"6P\",\"benname\":\"Dharampal Sabharwal\",\"queuestatus\":\"1\"},{\"displayqueueno\":\"3\",\"benname\":\"M Mallika\",\"queuestatus\":\"1\"}]",
        "departmentunitcode": "10811",
        "deptcode": "108",
        "DepartmentName": "Internal Medicine",
        "unitStatusCode": "1",
        "UnitName": "Dr. Vivek Aggarwal",
        "Room": "1211#189",
        "hospitalCode": "3726001",
        "unitStatus": "Started"
    }
]; */
$(document).ready(function () {
	var str =$('#deptJson').text();
	if(str!=""){
		var deptJson= JSON.parse(str);
		if(deptJson.length==1){
			$('#div_Token').append("<div class='col-lg-3' >&nbsp;<div>");
		}
		$.each(deptJson, function(indx, jsonobj){
			var key=jsonobj["departmentunitcode"]
			createCounters(jsonobj,key,"");			
		});
		getQueueData(str);
		// for reformating html
		//createDataHTML(datahtml);
	}
});
function createCounters(jsonobj,key,message){
	var counter_status="-";
	var html="";
	var room= jsonobj["Room"]!=undefined? "Room No.-"+ jsonobj["Room"].split("#")[1]:"";
	html+="<div class='col-lg-4 counterToken ' id='counter_"+key+"' style='display:none;' data_queueno='0' >";
	html+="<div class='card kpistyle bg-disabled' style='padding: 0;'>";
	html+="<div style='margin-top: -18px;margin-left: -1;margin-right: -1;' class='card-header headerFooter'>";
	html+="<h4 class='card-title text-center text-warning' ><p>"+jsonobj["DepartmentName"]+"</p>";
	html+="<p style='font-size: 19px;'>"+jsonobj["UnitName"]+"</p> ";
	html+="<p style='font-size: 19px;'>"+room+"</p> </h4>";
	html+="<input type='hidden' id='message_"+key+"' value='"+message+"'>"
	html+="</div>";
	html+="<div class='card-body text-center' style='padding:0;'>";	
	html+="<div class='row'>";
	html+="<div class='col-sm-12 ' style='margin: 6px;'>";
	html+="<table style='width:96%;' id='tblDisplay_"+key+"'>";
	html+="<tbody>";
	html+="<tr>";
	html+="<td style='text-align: left;width:100%' class='fw-bold text-center text-primary'  >";
	html+="	<h3>"+counter_status+"</h3></td>";
	html+="</tr>";
	html+="</tbody>";
	html+="</table>";
	html+="</div>";
	html+="</div>"
	html+="</div>"
	html+="</div>"
	html+="</div>";
	$('#div_Token').append(html);
	
	
}


function getQueueData(str){

	var encdata =encrypt(str)
	const eventSource = new EventSource('/HISDRDESK_MC/sse?encdata='+encdata);
    eventSource.onmessage = function(event) {

    	lastreceivedtime  = new Date();
    	
		console.log("inside event result");
    	
    	console.log(event);
    	
    	var dataPart = event.data;
		console.log("dataPart>>" + dataPart);
		if(dataPart!=undefined)
    		createDataHTML(JSON.parse(dataPart));
    };	 

    eventSource.onerror = function() {
        console.log('Connection closed.');
        eventSource.close(); // Stop the stream when an error occurs
    };
        
  }

function createDataHTML(deptJson){
	$.each(deptJson, function(indx, jsonobj){
		var html="";
		var key=jsonobj["departmentunitcode"];
		//alert(JSON.stringify(deptJson));
		if(jsonobj["queueNoJson"]==undefined){
			html+="<tr>";
			html+="<td style='text-align: center;width:100%;' class='fw-bold text-center text-primary bg-white'  >";
			html+="	<h3>-</h3></td>";
			html+="</tr>";
		}
		else{
			
			var  queueNoJsonArr = JSON.parse(jsonobj["queueNoJson"]);
			
			
			$.each(queueNoJsonArr, function(indx, qJsonObj){
				//alert(JSON.stringify(qJsonObj));
				if(qJsonObj["displayqueueno"]=="Stopped"){
					$('#counter_'+key).hide();
					return;
				}
				else{
					$('#counter_'+key).show();
					$('#welcomemsg').hide();
				}
				if(qJsonObj["queuestatus"]=="0"){
					html+="<tr>";	
					html+="<td style='text-align: left;width:100%;border:1px solid silver;' class='fw-bold text-center text-primary bg-warning'  >";
					html+="	<h3>"+qJsonObj["displayqueueno"]+"</h3></td>";
					html+="</tr>";
				}
				else if(qJsonObj["queuestatus"]=="-1"){
					html+="<tr>"; 
					var className="";
					if (qJsonObj["displayqueueno"]=="Started")
						className="text-white bg-success";
					else
						className="text-white bg-danger";		
					html+="<td style='text-align: left;width:100%;border:1px solid silver;' class='fw-bold text-center "+className+"'  >";
					html+="	<h3>"+qJsonObj["displayqueueno"]+"</h3></td>";
					html+="</tr>";
				}
				else{
					html+="<tr>";	
					html+="<td style='text-align: left;width:100%;border:1px solid silver;' class='fw-bold text-center text-dark bg-white'  >";
					html+="	<h3>"+qJsonObj["displayqueueno"]+"</h3></td>";
					html+="</tr>";
				}
			});
		}
		//alert(html);
		$('#tblDisplay_'+key + ' tbody').html(html);		
	});
}


</script>
    
    

</head>
<body>
<form>
<div class="d-flex bd-highlight " style="border-bottom: 1px solid #d0cccc;width: 100%;">
  			<div class="flex-grow-1 p-1 bd-highlight">
  				 <div class="row align-items-center">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11" style="padding-left: 25px;">
  						<img src='/HIS/hisglobal/images/cghs_logo_big.png' class='img-fluid'>
  					</div>	
  					<div class="col-lg-8 col-xl-8 col-md-4 col-sm-4 col-12" style="padding-left: 25px;">
  						<p class='menuModaltitle' >OPD Queue No. Display System</p>
  					</div>	
  				</div>
  			</div>
  			
  		</div>
		<div class="" id='ENTRYFORM'>
			<div class="card p-2"  style="box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;">
			  <div class="card-body">
			  	<div class="row">
			  	<div class="col-lg-8">
			  	<h3 id='welcomemsg' class='text-primary text-center'>Welcome to CGHS Queue Management System <br/> Token will display when Doctor Starts</h3>
			  	<div id='div_Token' class="row">
	 				
	 			</div>
	 			<div class="alert alert-warning text-primary text-bold" role="alert">
  					<h6>Queue No. in Yellow represents called patient & Queue No. in white represent next waiting</h6>
				</div>
	 			</div>
	 			<div class="col-lg-4">
	 				<div id="carouselWithCaptions" class="carousel slide pointer-event" data-bs-ride="carousel">
						  <ol class="carousel-indicators">
						    <li data-bs-target="#carouselWithCaptions" data-bs-slide-to="0" class="active"></li>
						    <li data-bs-target="#carouselWithCaptions" data-bs-slide-to="1"></li>
						    <li data-bs-target="#carouselWithCaptions" data-bs-slide-to="2"></li>
						  </ol>
						  <div class="carousel-inner">
						      <div class="carousel-item active" style="height: 70vh;">
						      <img src="/AHIMSG5/hissso/portal/images/slider/slider1.png" class="d-block w-100" alt="Slide 1">
						      <div class="carousel-caption d-none d-sm-block">
						      	<img src="/AHIMSG5/hissso/portal/images/slider/banner-logo.png" style="width: 70px;background: #fff;" />
						      	<h6 style="background: #ec1a47;">Central Government Health Scheme</h6>
						        <p class='pulse' style="background: #fff;color:navy;">Presently approximately<b>
						        <span data-lang-key='cghsInfo2'> 42 lakh beneficiaries</span>&nbsp;</b>
						        are covered by CGHS in <b>&nbsp; 80 cities &nbsp;</b> over India. </span>
                        		</p>
						      </div>
						    </div>  
						    <div class="carousel-item" style="height: 70vh;">
						      <img src="/AHIMSG5/hissso/portal/images/slider/slider1.png" class="d-block w-100" alt="Slide 2">
						      <div class="carousel-caption d-none d-sm-block" style="top:0;width: 80%;">
						      	<h4 style="color: #323141;margin-bottom: 20px;">Facilities Available </h4>
						        <p class='para'>OPD Treatment at WCs & issue of medicines</p>
						        <p class='para'>Specialist Consultation at Polyclinic/Govt. Hospitals</p>
						        <p class='para'>OPD/ Indoor treatment at Govt. and empanelled Hospitals</p>
						        <p class='para'>Cashless facility available for treatment in empanelled hospitals </p>
						        <p class='para'>Reimbursement of expenses for treatment availed in Govt. /Private Hospitals</p>
						        <p class='para'>Family Welfare, Maternity and Child Health Services</p>
						        <p class='para'>Medical consultation. Dispensing of medicines in Ayurveda ,Homeopathy, Unani and Siddha system of medicines (AYUSH)</p>
						      </div>
						    </div> 
						    
						    <div class="carousel-item " style="height: 70vh;">
						      <img src="/AHIMSG5/hissso/portal/images/slider/slider1.png" class="d-block w-100" alt="Slide 2">
						      <div class="carousel-caption d-none d-sm-block" style="top:0;width: 80%;">
						      	<h4 style="color: #323141;margin-bottom: 20px;">Timings of Wellness Centres</h4>						       
						        <p class='para'>Wellness Centers are open from 7:30 AM to 2:00 PM on all working days except emergency services wherever applicable</p>
						        <p class='para'>Emergency services- timing 7:30AM to 1:30 PM </p>
						        <p class='para'>Limited Emergency services 1:30PM to 7:30AM </p>
						        <p class='para'>Wellness Centres remain closed on all Central Govt. holidays.Not more than 2 consecutive days</p>
						        <p class='para'>Registration Timings: The registration is stopped 15 minutes before scheduled closing time of dispensary</p>
						      </div>
						    </div> 
						     
						    					   
						  </div>
						  <a class="carousel-control-prev" href="#carouselWithCaptions" role="button" data-bs-slide="prev">
						    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Previous</span>
						  </a>
						  <a class="carousel-control-next" href="#carouselWithCaptions" role="button" data-bs-slide="next">
						    <span class="carousel-control-next-icon" aria-hidden="true"></span>
						    <span class="visually-hidden">Next</span>
						  </a>
						</div>
	 				
	 			</div>
			  </div>			
			</div>
		</div>	
		
		<%String json=(String) request.getSession().getAttribute("departmentJson"); %>
		<span id='deptJson' style="display: none;" ><%=json %></span>
	</div>	
	<div class="logos d-flex align-items-center justify-content-between border-bottom border-light border-opacity-25 py-5 wow fadeInUp" style="visibility: visible; animation-name: fadeInUp;background: url('/AHIMSG5/hissso/portal/images/footerbg.png');">&nbsp;
                <!-- <a style="background: #fff;margin-top: -38px;margin-left: 15px;" href=""><img src="/AHIMSG5/hissso/portal/images/logos/nhp.png"></a>
                <a style="background: #fff;margin-top: -38px;margin-left: 15px;" href=""><img src="/AHIMSG5/hissso/portal/images/logos/mygov.png"></a>
                <a style="background: #fff;margin-top: -38px;margin-left: 15px;" href=""> <img src="/AHIMSG5/hissso/portal/images/logos/digilocker.png"></a>
                <a style="background: #fff;margin-top: -38px;margin-left: 15px;" href=""> <img src="/AHIMSG5/hissso/portal/images/logos/rti.png"></a>
                <a style="background: #fff;margin-top: -38px;margin-left: 15px;" href=""> <img src="/AHIMSG5/hissso/portal/images/logos/national-relief-fund.png"></a> -->
     </div>				  	
</form>
</body>
</html>