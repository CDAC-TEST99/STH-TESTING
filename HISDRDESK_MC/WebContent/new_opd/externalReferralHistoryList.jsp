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
    <script type="text/javascript" src="/HIS/hisglobal/FormFlowX/js/base64.js"></script> 
    
    
	<style type="text/css">
	table {
		  display: table;
		  width: 100%;
		  background-color: transparent;
		  border-collapse: collapse;
		  border-spacing: 0;
		  page-break-inside: auto;
		}
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

.placeholder-disable:focus::placeholder {
  color: red;
  text-align: center; 
}


.placeholder-disable::placeholder {
  text-align: center; /* Center the placeholder text */
}

.placeholder-disable:focus::placeholder {
  color: red; /* Change color on focus */
}


 #customDisableModal {
    display: none;
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background: #fff;
    border-radius: 8px;
    box-shadow: 0 8px 24px rgba(0,0,0,0.2);
    padding: 24px 32px;
    width: 390px;
    max-width: 90%;
    z-index: 1000;
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  }

  #customDisableModal p {
    font-size: 16px;
    margin-bottom: 16px;
    color: #333;
  }

  #customDisableModal label {
    font-weight: 600;
    display: block;
    margin-bottom: 8px;
    color: #444;
  }

  #disableReason {
    width: 100%;
    padding: 8px 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
    box-sizing: border-box;
  }

  #customDisableModal button {
    background-color: #1d2b52;
    color: white;
    border: none;
    padding: 10px 18px;
    border-radius: 4px;
    cursor: pointer;
    font-size: 14px;
    margin-right: 12px;
    transition: background-color 0.3s ease;
  }

  #customDisableModal button:last-child {
    background-color: #f0ad4e;
  }

  #customDisableModal button:hover {
    background-color: #0056b3;
  }

  #customDisableModal button:last-child:hover {
    background-color: #5a6268;
  }
	</style>
</head>
<body  >
	<div class='page-content-wrapper' style="width:100%;padding:10px;color:#000;" >		
		<div class='row' style="margin-bottom: 10px;">
			<div class="col-md-3">
                    <p style="letter-spacing:0"><label>Refer Status</label></p>
                    <select class="form-control" name="referStatus"  id="referStatus"> 
                    	<option value="2" selected="selected">External</option>
					<option value="3">Endorsement</option>
                    </select> 
              </div>
              <div class="col-md-6">&nbsp;</div>
              <div class="col-md-3">
              	<p style="letter-spacing:0"><label>Search</label></p>
              		<input type='text' class="form-control" maxlength="100" id='search' >  
              </div>
              	 
         </div>
        <div class='row'>
			<div class="col-md-12">
	          	<table class='table table-hover table-condensed table-checkable patientListMainTable' id="ExternalReffralListTable" style="width: 100%;"> 
			           <thead><!--  -->
			             <tr>
			             	<th style="width:25%;text-align:center;">Ref. Id</th>
			             	<th style="width:35%;">Component Details</th>
			             	<th style="width:25%;">Remarks</th>
			             	<th style="width:15%;text-align:center;">Valid Upto</th>
			             	<th style="width:10%;text-align:center;">Max. Qty</th>
			            	<th style="width:5%;text-align:center">Referral Type</th>
			            	<th style="width:5%;text-align:center">Disable Status</th>                     
			       		</tr>
			           </thead>
		           <tbody>
		           	</tbody> 
				</table>
			</div>
		</div>
	</div>
	<div  id='divprint'></div>
	
	<div class="loader"  >
          <span></span>
          <span></span>
          <span></span>
          <span></span>
        </div>
        
        <div id="customDisableModal">
			  <p style="color: red;">Are you sure you want to disable this referral?</p>
			  <label for="disableReason">Reason:</label>
			  <input type="text" id="disableReason" />
			  <br><br>
   			<button onclick="confirmDisable()">Confirm</button>
		  <button onclick="closeCustomConfirm()">Cancel</button>
		</div>
<!-- 	<div id="customDisableModal" style="display:none; position:fixed; top:20%; left:30%; background:white; border:1px solid #ccc; padding:20px;">
	  <p>Are you sure you want to disable this referral?</p>
	  	<label>Reason:</label>
	  	<input type="text" id="disableReason" />
	  <br><br>
		  
		  <button onclick="confirmDisable()">Confirm</button>
		  <button onclick="closeCustomConfirm()">Cancel</button>
	</div> -->
	
	
	<span id='testjson' style="display: none;"> </span>
	<span id='precedurejson' style="display: none;"> </span>
	<script>
	$(document).ready(function(){

		getCRNoWiseExternalReferralData();	
		getExternalInvestigation(); 
		getExternalProcedure();
		$('#referStatus').change(getCRNoWiseExternalReferralData);
		$('#search').keyup(searchData);	
		//alert(getUniqueOPDId());
	});
	
	function getCRNoWiseExternalReferralData(){
		$('#ExternalReffralListTable tbody').empty()
		var arrRefHistoryIds = localStorage.getItem("refHistoryIds").split('#');
		//alert(arrRefHistoryIds);
		var seatId=arrRefHistoryIds[3].split("^")[1];
		var url = '/HISDRDESK_MC/services/restful/patdata/getCRNoWiseExternalReferralData?crNo='+arrRefHistoryIds[0]+
				  '&episodeCode='+arrRefHistoryIds[1]+'&visitNo='+arrRefHistoryIds[2]+'&seatId='+seatId+
		 		   '&hosp_code='+arrRefHistoryIds[4]+ "&referStatus="+$('#referStatus').val() ;
		 
			//alert(url);
			$.ajax({url: url,  
				async:false,
				success: function(result){
					$('.loader').hide();
					//alert(JSON.stringify(result));
					if(JSON.stringify(result)!="{}")						 
					{
						var processedJson={}
						/*grouping all endorsment data printkey and date wise*/
						var dateWiseGroupEndorsmentJson={};						
						$.each(result["endorsementData"],function(indx, objJson){
							var key=objJson["printkey"]+"&&"+objJson["refDate"];
							if(dateWiseGroupEndorsmentJson[key]==undefined){
								var arr= new Array();
								$.each(result["endorsementData"],function(indx, obj){
									var key1=obj["printkey"]+"&&"+obj["refDate"];
									if(key==key1){
										arr.push(obj);
									}								
								});								
								dateWiseGroupEndorsmentJson[key]=arr;
							}
						});
						//alert(JSON.stringify(dateWiseGroupEndorsmentJson));

						/*grouping all ext data printkey and date wise*/
						var dateWiseGroupExtJson={};
						
						$.each(result["externalReferralData"],function(indx, objJson){
							var key=objJson["printkey"]+"&&"+objJson["refDate"];
							if(dateWiseGroupExtJson[key]==undefined){
								var arr= new Array();
								$.each(result["externalReferralData"],function(indx, obj){
									var key1=obj["printkey"]+"&&"+obj["refDate"];
									if(key==key1){
										arr.push(obj);
									}								
								});								
								dateWiseGroupExtJson[key]=arr;
							}
						});
						//alert(JSON.stringify(dateWiseGroupExtJson));

						/*merging dateWiseGroupEndorsmentJson and dateWiseGroupExtJson json printkey and ref date wise*/
						$.each(dateWiseGroupEndorsmentJson,function(key,arr){
							var objjson={"endorsement":arr};
							processedJson[key]=objjson;
						});
						$.each(dateWiseGroupExtJson,function(key,arr){
							var objjson={};
							if(processedJson[key]!=undefined){
								 objjson=processedJson[key];
							}
							objjson["ext"]=arr;
							processedJson[key]=objjson;
						});
						/*==================*/
						/*creating final html rows from processedJson*/
						$.each(processedJson, function(key, objjson){
							var printKey=key.split("&&")[0];
							var refDate=key.split("&&")[1];
							var html="";
							
							if(objjson["endorsement"] !=undefined){
								$.each(objjson["endorsement"], function(indx, obj){
									var endorsementJSON= JSON.parse(obj["endorsementJSON"]);
									html+="<tr>";
									html+="<td class='bg-success' colspan='1'><b>Refer Date : "+refDate+"</b></td>";
									html+="<td class='bg-success' colspan='2'><b>Hospital/Department : "+endorsementJSON["strEndorsementHospitalName"]+"/"+endorsementJSON["strEndorsementDepartmentName"] +"</b></td>";
									html+="<td class='bg-success' colspan='2'><b>Doctor : "+endorsementJSON["strEndorsementDoctor"]+"</b></td>";
									html+="<td class='bg-success' colspan='6' style='text-align:right'><a data-key='"+printKey+"' class='btn-his-outline printprescription'>Print</a></td>"		
									html+="</tr>";
									$('#ExternalReffralListTable tbody').append(html);
								});
							}
							else{
								html+="<tr>";
								html+="<td class='bg-success' colspan='3'><b>Refer Date : "+refDate+"</b></td>";
								html+="<td class='bg-success' colspan='3' style='text-align:right'><button class='btn-his-outline ' data-key='"+printKey+"' onclick='repeatAll(this)'>Repeat</button></td>";
								html+="<td class='bg-success' colspan='6' style='text-align:right'><a data-key='"+printKey+"' class='btn-his-outline printprescription'>Print</a></td>"		
								html+="</tr>";
								$('#ExternalReffralListTable tbody').append(html);
							}
							
							if (objjson["ext"] !== undefined) {
							    var arrExt = objjson["ext"];
							    $.each(arrExt, function(indx, objext) {

							    	//alert(objext["disableStatus"]);
							        var RefJson = JSON.parse(objext["RefJson"]);
							        var trclass = "";

							        if (objext["isValidityExpired"] === "1") {
							            trclass = "'text-danger'";
							        }

							        var key = RefJson["strReffralExtId"] + "-" + RefJson["refSNO"];
							        var repeateRefJson = JSON.stringify(RefJson);
							        var refetype = RefJson["strreferralTypeName"];
							        var disableSatatus = objext["disableStatus"];
							        var disableRemark = objext["disableRemark"];
							      	 console.log("disableRemark    >   "+ disableRemark);

							        var html = "<tr class='searchRow " + trclass + "'>";
							        html += "<td>" + RefJson["refId"] + "/" + RefJson["refSNO"] + "</td>";
							        html += "<td>" + RefJson["strreferralTypeName"] + "</td>";
							        html += "<td>" + RefJson["strReffralExtName"] + "</td>";
							        html += "<td>" + RefJson["refferalExtReson"] + "</td>";
							        html += "<td>" + RefJson["validUpto"] + "</td>";
							        html += "<td id='noAllowed_" + key + "'>" + objext["qtyConsumed"] + "." + RefJson["noAllowed"] + "</td>";
							        html += "<td id='disableSts_" + key + "' style='color:" + (disableSatatus == 0 ? "green" : "red") + ";text-align: center;'>" + (disableSatatus == 0 ? "Active" : "Disabled") + "</td>";
							        html += "<td><button class='btn-his-outline' data-key='" + printKey + "' id='btnRepeatRef_" + key + "' onclick='repeatSingle(this)'>R</button><span style='display:none;' id='json_" + key + "' >" + JSON.stringify(RefJson) + "</span></td>";
							       /*  html += "<td><input value='' type='text' class='form-control' id='textDisable_" + key + "' " 
							        + (disableSatatus == 1 ? "style='display:none'" : "") 
							        + "></td>"; */	
							        html += "<td>" + (disableSatatus == 1 ? disableRemark : "<button class='btn-his-outline' id='btnDisable_" + key + "' onclick='showCustomConfirm(this)'>D</button>") + "</td>";

							        html += "<td id='hiddenRefferExtCGHSCode_" + key+"' style='display:none;'>" + RefJson["refferExtCGHSCode"] + "</td>";
							        html += "</tr>";

							        $('#ExternalReffralListTable tbody').append(html);
							    });
							}

							
						});
						$('.printprescription').click(printPrescription);
							
					}
					if($('#ExternalReffralListTable tbody tr').length==0){
						$('#ExternalReffralListTable tbody').append("<tr><td class='bg-danger' style='text-align:center' colspan='6'>No Record Found</td></tr>");
					}
				} 
				});
	}

	function repeatAll(objRepeatAllButton){

		var printKey=$(objRepeatAllButton).attr("data-key");
		
	 	$('[id^=btnRepeatRef_]').each(function(){
		 	if($(this).attr("data-key")==printKey)
	 			repeatSingle(this);
		}); 
	}

	function repeatSingle(objButton){
	    var tr = objButton.closest('tr');
	    var hiddenTd = tr.querySelector('td[id^="hiddenRefferExtCGHSCode_"]');
	    var refferExtCGHSCode = hiddenTd ? hiddenTd.textContent : null;

	    //alert(refferExtCGHSCode);
		getExternalInvestigation(refferExtCGHSCode)

		var key=$(objButton).attr("id").split("_")[1];
		//var disableReason = $("#btnDisable_" + key).val();
		//alert(disableReason);
		//alert($('#json_'+key).text());
		var reffralJson=JSON.parse($('#json_'+key).text());
		//reffralJson.disableReason=disableReason;
		
		const today = new Date();
		const futureDate = new Date(today); // Create a copy of today
		futureDate.setMonth(futureDate.getMonth() + 3); // Adjust the month on the copy
		
		const day = String(futureDate.getDate()).padStart(2, '0');
		const month = String(futureDate.getMonth() + 1).padStart(2, '0'); // Month is 0-indexed
		const year = futureDate.getFullYear();


		//console.log("date   >> "+ day +"-"+month+"-"+ year);
		reffralJson.validUpto = day +"-"+month+"-"+ year;
		
		console.log(reffralJson.validUpto);
		//alert(JSON.stringify(reffralJson));

		var strreferralTypeCode=reffralJson["strreferralTypeCode"]
		//alert(JSON.stringify(reffralJson));
		parent.UnhideReferalFields(strreferralTypeCode)
		
		if(strreferralTypeCode=="1"){
			var key='extcon-'+reffralJson["strReffralExtId"];
			parent.createExternalRow(reffralJson, "ExternalConsultationListTable", key);
		}
		if(strreferralTypeCode=="2"){
			var key='extinv-'+reffralJson["strReffralExtId"];
			reffralJson=checkReferalCode(reffralJson);			
			parent.createExternalRow(reffralJson, "ExternalInvestigationListTable", key);
		}
		if(strreferralTypeCode=="3"){
			var key='extproc-'+reffralJson["strReffralExtId"];	
			reffralJson=checkReferalCode(reffralJson);			
			parent.createExternalRow(reffralJson, "ExternalProcedureListTable", key);
		}
		if(strreferralTypeCode=="4"){
			var key='extfollowup-'+reffralJson["strReffralExtId"];
			parent.createExternalRow(reffralJson, "ExternalFollowUpListTable", key);
		}
		
				
	}
	function printPrescription(){
		var primaryKey=$(this).attr("data-key");
		//alert(primaryKey);
		var arr=primaryKey.split("#") ;
		var json={"crNo":arr[0],
				"episodeCode":arr[1],
				"visitNo":arr[2],
				"seatId":"0",
				"visitDate":arr[4],
				"hospCode":arr[3]
				};
		printPrescriptionMainDeskFunForPdf(json);
		
		
	}
	function searchData(){
		var searchTerm= $(this).val().trim().toLowerCase();
		if(searchTerm==""){
			$('.searchRow').show();
		}
		$('.searchRow').hide();
		$('.searchRow').each(function(){
			var trobj=$(this);
			var text=""	;
			$(trobj).find('td').each(function(){
				text+=$(this).text().trim().toLowerCase()+"";
			})			
			if(text.indexOf(searchTerm)>=0)
				$(trobj).show();
		});
		
	}


	function printPrescriptionMainDeskFunForPdf(json){
		$('#divprint').empty();
		var crNo = json["crNo"];
		var episodeCode = json["episodeCode"];
		var visitNo = json["visitNo"];
		var seatId = json["seatId"];
		var visitDate =json["visitDate"];
		var hospCode = json["hospCode"]; 
		
		  var CRNO =crNo;
	      var convertedCRNO = CRNO.replace('/', '-');
	       var url = '/HISDRDESK_MC/services/restful/patdata/ReferralHTML?Modval=5&CrNo='+convertedCRNO+'&episodeCode='+episodeCode+'&visitNo='+visitNo+'&seatId='+seatId+'&Entrydate='+visitDate+'&hosp_code='+hospCode;
			$.ajax({url: url, /*  '/HISDRDESK_MC/services/restful/patdata/getPatData?Modval=1&CrNo=331011800028649&episodeCode=10212001&visitNo=1&seatId=10038&Entrydate=27-DEC-2018&hosp_code=33101', */ 
				async:false,
				success: function(result){
					
					var strdata = decryptBase64(result);

					var $html = $('<div style="width:100%">').html(strdata)
					
					$html.find('#ExternalReffralListTable')
					    .removeAttr('style') // Remove the style attribute to make it visible
					    .addClass('your-class-name'); // Add your desired class

					$('#divprint').html($html.html()).show();

					$('#DrugListTable').hide();
					$('#vitalLabTable').hide();
					var divContent = $('#divprint').html();
					
					var printWindow = window.open('', '_blank');
					printWindow.document.open();
					printWindow.document.write("<html><head><title>Print Preview</title></head><body>" + divContent + "</body></html>");

					$('#divprint').empty();

					printWindow.document.close();
					printWindow.print();
					
				}
				});
		
	 
	}

	function getExternalInvestigation(){
		var data={hmode:"populateExternalInvestigation"};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				$('#testjson').html(JSON.stringify(result));					
				}
			});				
	}
	function checkReferalCode(referjson){
		//alert(JSON.stringify(referjson));
		var json = null;
		if(referjson["strreferralTypeCode"] =="2")
			json=JSON.parse($('#testjson').html());
			
		if(referjson["strreferralTypeCode"] =="3")
			json=JSON.parse($('#precedurejson').html());

		var refferExtCGHSCode=referjson["refferExtCGHSCode"]
		//alert("refferExtCGHSCode==" +refferExtCGHSCode);
		
		
		for(i=0;i<json.length;i++){
			var rowObj=json[i];

			
		    var arroption=rowObj["optionValue"].split("#");
			var optionText=rowObj["optionText"];
			  
			if(arroption[4].trim()==refferExtCGHSCode.trim()){
				//alert("here");
				referjson["refferExtCGHSCode"]=arroption[1];
				referjson["strReffralExtName"]=optionText;
				break;		
			}

		}
		return referjson;
	}


	function getExternalProcedure(){
		
		if($('#refferlExtProcedure option').length<=1){
			$('#refferlExtProcedure').html("<option value='' selected>Select Procedure</option>");
			
			
			var data={hmode:"populateExternalProcedure",};
			$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
				dataType: "json",
				data:data,	
				type: "POST",
				success:function(result){ 
					$('#precedurejson').html(JSON.stringify(result));					
				}
			});
		}
		
	}

	function getUniqueOPDId()
	{
		var uniqueId = Date.now() + Math.floor(Math.random() * 1000);
		return uniqueId;
	}

	function showCustomConfirm(objButton) {
		
	    document.getElementById('customDisableModal').style.display = 'block';
	    
	    var $row = $(objButton).closest('tr');
	    
	    var jsonSpan = $row.find('span[id^="json_"]');
	    
	    if (jsonSpan.length === 0) {
	        console.error('JSON data span not found in this row');
	        return;
	    }
	    
	    var jsonString = jsonSpan.text();
	    var referralJson;
	    try {
	        referralJson = JSON.parse(jsonString);
	    } catch (e) {
	        console.error('Error parsing JSON:', e);
	        return;
	    }
	   
	    console.log('Referral JSON:', referralJson);
	    
	    //var $row = $(objButton).closest('tr');
	    
	    // Find the JSON span inside this row
	   // var jsonString = $row.find('[id^="json_"]').text();
	   // var tr = objButton.closest('tr');
		var key = $(objButton).attr("id").split("_")[1];
		//var reffralJson = JSON.parse($('#json_'+key).text());
		var disableRemark = $('#disableReason').val();

	    var modal = document.getElementById('customDisableModal');
	    modal.dataset.key = key;
	    modal.dataset.objButtonId = objButton.id; 
	    modal.dataset.referralJson = JSON.stringify(referralJson);

	    // Clear input field (optional)
	    document.getElementById('disableReason').value = '';

	  //  console.log("Referral JSON:", reffralJson);

		//console.log("disble remarks     : "+disableRemark +" n\ "+ JSON.stringify(reffralJson)+" \ "+reffralJson.refId);
	    
	}

	function confirmDisable(){

	    var modal = document.getElementById('customDisableModal');
	    var key = modal.dataset.key;
	   // var objButtonId = modal.dataset.objButtonId;
	    //var objButton = document.getElementById(objButtonId);
	   // var objButton = modal.dataset.objButton;
	    var reffralJson = JSON.parse(modal.dataset.referralJson);
	    var disableRemark = document.getElementById('disableReason').value;
	    var disableSatatus = "1";

	    modal.style.display = 'none';

		var arrRefHistoryIds = localStorage.getItem("refHistoryIds").split('#');

		var refId=reffralJson.refId;

		console.log("refId : "+ refId );
		console.log("reffralJson : "+ JSON.stringify(reffralJson));
		
		var jsonData = {
			    disableStatus: disableSatatus, 
			    refId: refId
			};
		 var url = '/HISDRDESK_MC/services/restful/patdata/updateReferralDisableSatatus' + 
        '?crNo=' + arrRefHistoryIds[0] + 
        '&episodeCode=' + arrRefHistoryIds[1] + 
		'&disableSatatus=' + disableSatatus+
		'&refId=' + refId+
		'&strReffralExtId=' + reffralJson.strReffralExtId+
		'&disableRemark=' +disableRemark;
        
		$.ajax({url: url,
			async:false,
			//type: 'POST'
			success: function(result){
				
			 if (disableSatatus == "1" ){
					console.log("updateStatus  :  "+key);	
					$('#btnDisable_' + key).hide();
					$('#disableSts_' + key).text("Disabled");
					$('#disableSts_' + key).css("color", "red");
		            /* var statusCell = $(objButton).closest('tr').find('td').eq(-4);
		            statusCell.text("Disabled");
		            statusCell.css("color", "red");
 */				}
		   	}
		}); 

	}

	function closeCustomConfirm() {
	    document.getElementById('customDisableModal').style.display = 'none';
	}

</script>	
</body>
</html>