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
			createPatientQueueRow(jsonobj);		
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
function createPatientQueueRow(jsonobj){
	var key= jsonobj["deptcode"];
	var departmentName= jsonobj["DepartmentName"];

	if(jsonobj["isprefered"]==1){
		departmentName=  departmentName+"-"+ jsonobj["UnitName"];
	}
	if($('#trpatQueue_'+key).length>0)
		return;

	var html ='<tr id="trpatQueue_'+key+'">';
	html +='<td style="text-align:center;"><h3>'+jsonobj["queueNo"]+'</h3></td>';
	html +='<td style="text-align:left;">'+departmentName+'</td>';
	html +='<td style="text-align:left;">'+jsonobj["WellnessCenterName"]+'</td>';
	html +='</tr>';  
	$('#tbl_my_queue_List tbody').append(html);  
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
	<%String isHeaderRequired=(String)request.getSession().getAttribute("isHeaderRequired");
	
	
	if(isHeaderRequired.equals("1")){%>
	  <div class="d-flex bd-highlight " style="border-bottom: 1px solid #d0cccc;width: 100%;">
  			<div class="flex-grow-1 p-1 bd-highlight">
  				 <div class="row align-items-center">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11" style="padding-left: 25px;">
  						<img src='/HIS/hisglobal/images/cghs_logo_big.png' class='img-fluid'>
  					</div>	
  				</div>
  			</div>
  		</div>
  		<%} %>
  		<%String errorMessage= (String) request.getAttribute("errorMsg");
  		if(errorMessage==null){
  		
  		%>
  		
		<div class="" id='ENTRYFORM'>
			<div class="card p-2"  style="box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;">
			  <div class="card-body">
			  	<div class="row" id='welcomemsg'>
			  	<div class="col-lg-12">
			  	<h3  class='text-primary text-center'>Welcome to CGHS Queue Management System <br/> Token will display when Doctor Starts</h3>
			  	</div>
			  	</div>
			  	<div  class="row">
			  		<div class="col-lg-12">
			  			<h3  class='text-primary text-center'>Your Todays Visit Details</h3>
			  		</div>
			  	</div>	
			  	<div  class="row">
			  		<div class="col-lg-12">
			  			<table class="table table-striped border" id="tbl_my_queue_List">
						   <thead>
						      <tr class="tableHeading">
						         <th scope="col" class="colHeading" style="text-align: center; width: 20%;">Your Queue No.</th>
						         <th scope="col" class="colHeading" style="text-align: left; width: 40%">GeneralOPD/Speciality Name</th>
						         <th scope="col" class="colHeading" style="text-align: left; width: 40%;">WellNess Center Name</th>         
						      </tr>
						   </thead>
						   <tbody>
						       
						   </tbody>
						</table>
			  		</div>			  		
			  	</div>
			  	<div  class="row">
			  		<div class="col-lg-12">
			  			<h3  class='text-primary text-center'>Current Queue No. in Wellness Center </h3>
			  		</div>
			  	</div>
			  	<div id='div_Token' class="row">
	 				
	 			</div>
	 			<div class="alert alert-warning text-primary text-bold" role="alert">
  					<h6>Queue No. in Yellow represents called patient & Queue No. in white represent next waiting</h6>
				</div>
	 			</div>	 			
			  </div>			
		</div>
			
		
		<%String json=(String) request.getSession().getAttribute("departmentJson");
		String userId=(String)request.getSession().getAttribute("userId");
		String benId=(String)request.getSession().getAttribute("benId");
		%>
		
		<span id='deptJson' style="display: none;" ><%=json %></span>
		<input type="hidden" name="userId" id="userId" value="<%=userId%>">
		<input type="hidden" name="benId" id="benId" value="<%=benId%>">
		<%}else {%>
			<div class="alert alert-danger" role="alert"><%=errorMessage %></div>
		<%} %>
	</div>		  	
</form>
</body>
</html>