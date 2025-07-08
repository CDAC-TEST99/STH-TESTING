<%@page import="hisglobal.presentation.ControllerUTIL"%>
<%@page import="hisglobal.vo.HospitalMstVO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

	<!-- Latest compiled JavaScript -->
	<script src="/HIS/hisglobal/drDeskAssets/bootstrap/js/bootstrap.min.js"></script> 
	 
	<script src="/HIS/hisglobal/drDeskAssets/qrcodejs/qrcode.min.js"></script> 
	
	<!-- <script src="/HIS/hisglobal/drDeskAssets/qrcodejs/JsBarcode.code39.min.js"></script> --> 
	
	<script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/barcode_code39.js"></script>
	
	<!-- <script src="/HIS/hisglobal/drDeskAssets/qrcodejs/JsBarcode.all.min.js"></script>  --> 
	
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css">
    <link rel="stylesheet" href="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.css.map">
    <script src="/HIS/hisglobal/drDeskAssets/SweetAlertNew/sweetalert.min.js"></script>
	<script type="text/javascript">


   
		
	</script>
	<style>
	ul#menu li {
	display:inline;
	margin: 0px !important;
	font-size: 14px;
	letter-spacing: inherit !important;
	color: #5a5a5a !important;
	text-align: justify;
	}
	</style>
	<style>
		body{
			padding-bottom:80px; 
		} 
		#printPrescPage{
			margin-bottom:45px;
			
		} 
		.investigation{
			margin:0px !important;
		}
		
		.examination{
			margin:0px !important;
		}
		.investigation li{
			text-align:left !important;
		} 
		.investigation li p{
			margin:0px !important;
			font-size:14px;
		}
		.examination li{
			text-align:left !important;
		} 
		.examination li p{
			margin:0px !important;
			font-size:14px;
		}
		.printPrescTreatmentLst{
			margin:0px !important;
		} 
		.printPrescTreatmentLst li{
			text-align:left !important;
		} 
		.printPrescTreatmentLst li p{
			margin:0px !important;
			font-size:14px;
		}
		.printPrescPage{
			color:black !important;
		}
		.printPrescPage p{
			letter-spacing: inherit !important;
			color: #5a5a5a !important;
			font-weight:600;
			text-align: justify;
		}
		.printPrescPage p small{
		font-weight: 400 !important;
		font-size: 14px;
		}
		.printPrescPatDtlTbl tr td{
			border-top: 0px solid #ddd !important;
			padding: 2px 5px;
		}
		.printPrescPatDtlTbl tr th{
			border-top: 0px solid #ddd !important;
			padding: 2px 5px;
		} 
		.printPrescPatDtlTbl{ 
			font-size: 13px;
			margin:10px 0;
		}
		.printPrescTreatmentTbl{
			font-size: 13px
		}
		.printPrescTreatmentTbl tr td{
		border-top: 0px solid #ddd !important;
		}
		.printPrescTreatmentTbl tr th{
		border-top: 0px solid #ddd !important;
		border-bottom: 0px solid #ddd !important;
		}  
		
		
		
		#watermark
		{
		 position:fixed;
		 top:42%;
		 left:25%;
		 opacity:0.1;
		 font-size: 90px;
		 z-index:-1;
		 color: black;
		 transform: rotate(-20deg);
		}
		/* div.header {
		    display: block; text-align: center; 
		    position: running(header);
		}
		div.footer {
		    display: block; text-align: center;
		    position: running(footer);
		} */
		/* @page {
		    @top-center { content: element(header) }
		}
		@page { 
		    @bottom-center { content: element(footer) }
		} */
		#header {visibility: hidden;position:fixed; top:0}
		
		#footer {
		visibility: hidden;
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0; /* To center the footer horizontally */
  text-align: center; /* To center the content within the footer horizontally */
  color: #7e7e7e;
  padding-bottom: 0px; /* Add padding to the footer if needed */
  
}
		/* #footer{visibility: hidden;position:fixed;bottom:0;left:10px;color: #7e7e7e;} */
		@media print {
		    #header, #footer {visibility: visible;}
		    .prescPrintBtn{display: none;}
		    .prescSaveBtn{display: none;}
		   /*  .divPrintPrescPatDtlTbl{visibility: hidden;} 
			.Logoimg{visibility: hidden;}  */
			 .withHeaderLabel{display:none;) 
		  } 
	</style>
	<style>
	 @media only screen and (min-width: 1100px) {
  #prHeaderr{
  right: 14px !important;
  margin-top: 11px !important;
  }
  #printPrescPage{
  width: 95% !important; 
  /* margin-right: 18% !important; */ 
  }
}
@media only screen and (max-width: 851px) {
  #prHeaderr{
  right: 174px !important;
  margin-top: 50px !important;
  }
  #printPrescPage{
  width: 100% !important; 
  margin-right: none !important; 
  }
} 


#printPrescFrameBody .row{
z-index:-1;
position:relative;
} 

	</style>


</head>
<body id="printPrescFrameBody" onload="">
	<div id="header"> </div>

			<div style="right:8px; position:fixed" class="prHeader" id="prHeaderr" >
			<!-- <div style="right:200px; position:fixed;top: 60px;"> -->
				<label class="withHeaderLabel" style="z-index: 99999;display:none"><input type="checkbox" name="withHeaderCheck" value="1" >&nbsp  Without Header</label><br><!--With Header  -->
				<button class="btn btn-success prescSaveBtn" style="z-index:9999;" type="button" onclick="">Save</button>
				<button class="btn btn-info prescPrintBtn" style="z-index:9999;" type="button" onclick="">Print</button>
			</div> 
			
			<!-- <div style="right:23px; position:fixed">
				<button class="btn btn-info bookmarkbtn" style="z-index:9999;padding-top: 5px;margin-top: 81px;" type="button" data-toggle="modal" data-target="#bookmarkmodal">BookMark</button>
			</div> --> 

	<h2 id="watermark"></h2>
		<style type="text/css">
	      	 	.tablePrecrption{
	      	 		border:1px solid #000;
	      	 	}
	      	 	.tablePrecrption  td{
	      	 		border:1px solid #000;width: 33%;
	      	 	}
	      	 	.tablePrecrption  td span{
	      	 		font-weight: bold;
	      	 	}
	      	 	
	      	 	hr {
				  border-style: inset;
				  border-width: 1px;
				}
				@media print {
				    @page {
				        margin-top: 0;
				        margin-bottom: 0;
				    }
				    body {
				        padding-top: 0px;
				        padding-bottom: 72px ;
				    }
				}
	      	 </style>
		<div style="z-index: -1">
	      <div id="printPrescPage" class="container printPrescPage"> 
	         <%HospitalMstVO objHospitalMstVO =ControllerUTIL.getHospitalVO(request);%>
             <div class="row">
             	<table class="table table-condensed printPrescPatDtlTbl">
					<tbody>
					<tr>
					<!-- <th style='width:33%'><img alt="" src="" style='height:80px;'></th> -->
					<th style='width:8%;text-align: center;'><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style='width: 8%;'></th>
					<!-- <th style='width:33%'><div id="patQrCode" class="pull-right"></div> </th> -->
					</tr>
						<tr>
							<th colspan="3" style="text-align: center;" >
							<h4 style="font-weight:bold; margin-left:100px;">Central Government Health Scheme <span id="patQrCode" class="pull-right"> </h4> 
						 	<h5 class="" style="font-weight:bold; margin-left:100px;"><%=objHospitalMstVO.getHospitalName().toUpperCase() %></h5> 
								
							<%if(objHospitalMstVO.getAddress1()!=null && !objHospitalMstVO.getAddress1().trim().equals("") ){ %>
								<h5 style="font-weight:bold; margin-left:100px;" ><%=objHospitalMstVO.getAddress1().toUpperCase() %></h5>
							<%} %>
								<h4 style="font-weight:bold; margin-left:100px;" >OPD Prescription</h4>
								
							</th>
						</tr>
					</tbody>
				</table>
			</div>   


		<div class="row">
				<table class="table table-condensed printPrescPatDtlTbl tablePrecrption">
					<tbody>
						<tr>
						<h6 class="text-left" style="font-weight:bold;"><span class="patDeptU"></span></h6>
							<td >BEN ID :
								<span class="patCrNo" ></span>
								<span id="patBarCode"></span>
							</td>
							<td >Date & Time :
							<span class=patVisitDate></span> <span class=patTimeOfVisit></span>
							</td>
						
							<td >Category :
							<span class=patCat></span>
							</td>
						</tr>
						
						<tr >
							<td>Patient Name :
								<span class="patName"></span>
							</td>
							<td>Age/Gender :
							<span class=patAgeGen></span>
							</td>
						
							<td>Father/Spouse/Mother Name  :
							<span class=patRelName></span>
							</td>
						</tr>
						
						
						<tr >
							<td colspan="3">Residence :
							
							<span class=patAddressName></span>, Mobile: <span class=mobileno></span>
							</td>
						
						</tr>
						
						<tr >
							<!-- <td>Mobile No. :
							<span class=mobileno></span>
							</td> -->
							
							<!-- <td >Department(Unit/Consultant) :
								<span class="patDeptU"></span>
							</td> -->
							<td colspan="3">Unit Head. :
								<span class="consultantName"></span>
							</td>
							
						</tr>
						<tr id='EndorsmentDivId'>
							<td colspan="3" style="padding: 0px;"><p>ENDORSMENT Detail :</p>
								<table id="EndorsementListTable" class="table table-condensed "> 
		                            <thead>
		                              <tr class='patPrecriptionData'>
		                                   <th style="width:40%;border: 1px solid;">Hospital Name</th>
				                           <th style="width:30%;border: 1px solid;">Department Name</th>
				                           <th style="width:30%;border: 1px solid;">Doctor Name</th>				                           
				                      </tr>
		                            </thead>
		                            <tbody></tbody> 
				                 </table>
							</td>
						</tr>
						<tr  class='patPrecriptionData'>
							<td  colspan="3" id='diagnosisDivId'>								
								<p>DIAGNOSIS :<small class="diagnosis"></small></p>
								
							</td>								
						</tr>
						
						<tr  class='patPrecriptionData' id='diagnosisNoteID1' >
							<td  colspan="3"  >								
								DIAGNOSIS ADVICE :
								<p style="margin-left: 2%;"><small class="diagnosisNoteID"></small></p>
							</td>								
						</tr>
						<tr id='refferPatientDeptDivId'>
							<td colspan="3" style="padding: 0px;"><p>INTERNAL REFERRAL :</p>
								<table id="InternalReffralListTable" class="table table-condensed "> 
		                            <thead>
		                              <tr class='patPrecriptionData'>
		                                <th style='width:40%;border: 1px solid;'>		                                
		                                Speciality Name</th>
		                                <th style='width:60%;border: 1px solid;'>Referral Note</th>		                                
		                              </tr>
		                            </thead>
		                            <tbody></tbody> 
				                 </table>
							</td>
						</tr>
						
						<tr>
							<td colspan="3" style="padding: 0px;">
								<table class='table table-condensed' style="margin-bottom: 0;">
									<tbody>
										<tr id='vitalsdtlsDivId' class='patPrecriptionData'>
											<td style="width: 40%">VITALS/GE :</td>
											<td style="width: 60%" class="vitalsdtls"></td>
										</tr>
										<tr id='reasonOfVisitDivId'  class='patPrecriptionData'>
											<td style="width: 40%">CHIEF COMPLAINT :</td>
											<td style="width: 60%" class="reasonOfVisit"></td>
										</tr>
										<tr id='historyIllnessNotesDivId' class='patPrecriptionData'>
											<td style="width: 40%">HISTORY OF PRESENT ILLNESS :</td>
											<td style="width: 60%" class="historyIllnessNotes"></td>
										</tr>
										<tr id='completeHistoryDivId' class='patPrecriptionData'>
											<td style="width: 40%">COMPLETE HISTORY :</td>
											<td style="width: 60%" class="completeHistory"></td>
										</tr>
										<tr id='examinationDivId' class='patPrecriptionData'>
											<td style="width: 40%">EXAMINATION :</td>
											<td style="width: 60%">
												<ul class="examination1"></ul>								
												<ul class="examination"></ul>
											</td>
										</tr>
										
										<tr id='chronicDiseaseDivId' class='patPrecriptionData'>
											<td style="width: 40%">CHRONIC DISEASE :</td>
											<td style="width: 60%" class="chronicDisease"></td>
										</tr>
										<tr id='ProceduresidDivId' class='patPrecriptionData'>
											<td style="width: 40%">PROCEDURES :</td>
											<td style="width: 60%" class="Proceduresid"></td>
										</tr>
										<tr id='treatmentadviceDivId' class='patPrecriptionData'>
											<td style="width: 40%">TREATMENT ADVICE :</td>
											<td style="width: 60%" class="treatmentadvice"></td>
										</tr>
										<tr id='followUpDivId' class='patPrecriptionData'>
											<td style="width: 40%">FOLLOW UP :</td>
											<td style="width: 60%" class="followUp"></td>
										</tr>
										
										<tr id='prolongDetailsTRId' class='patPrecriptionData'>
											<td style="width: 40%">PROLONGED TREATMENT DETAILS :</td>
											<td style="width: 60%" class="prolongDetails"></td>
										</tr>
										<tr id='drugallergyDivId' class='patPrecriptionData'>
											<td style="width: 40%">DRUG ALLERGY :</td>
											<td style="width: 60%"><ul class="drugallergy" id="menu"></ul></td>
										</tr>
										
										
									
									</tbody>
								
								</table>
							
							</td>
							
						</tr>
						<tr id="investigationDivId" class='patPrecriptionData'>
							<td  colspan="3" >								
								<p>INVESTIGATIONS &#x91C;&#x93E;&#x902;&#x91A;:
								<ul class="investigation" id="menu"></ul>
							</td>								
						</tr>
						<tr id="investigationNoteID1" class='patPrecriptionData'>
							<td  colspan="3" >								
								<p>INVESTIGATION ADVICE :
								<p style="margin-left: 2%;"><small class="investigationNoteID"></small></p>
							</td>								
						</tr>
						
						<tr class='patPrecriptionData'>
							<td  colspan="3" id="rxDivId" style="padding: 0;">								
								<table class='table table-condensed' style="margin-bottom: 0;" id='printPrescTreatmentLst'>
									<thead>
										<tr>
											<th colspan="7" style="text-align: center;">Medicine Rx :
										</th>
										</tr>
										<tr>
											<th style="width: 5%">S. No</th>
											<th style="width: 30%">Drug</th>
											<th style="width: 15%">Dosage</th>
											<th style="width: 15%">Frequency</th>
											<th style="width: 10%">Days</th>
											<th style="width: 10%">Quantity</th>
											<th style="width: 15%">Instruction</th>
										</tr>
									</thead>
									<tbody>
											
									</tbody>
								
								</table>
							</td>								
						</tr>
						<tr id="clinicalNoteDivId" class='patPrecriptionData'>
							<td  colspan="3" >								
								<p>CLINICAL NOTE : <small class="clinicalNote"></small></p>
							</td>								
						</tr>
						
						
						
						
						
						
						
						
						
						
					</tbody>
				</table>
			</div> 
			
			<br> 
			<div id="patQrCode" style="display:none" class="pull-right"></div>  
			<!-- <br>
			<br> -->
			
			
			<!-- <svg id="patBarCode"  class="pull-right"></svg> -->
		
			<!-- <div id="patBarCode" class="pull-right"></div>  -->

			
			<!-- <svg class="barcode" jsbarcode-format="upc" jsbarcode-value="33201210020" jsbarcode-textmargin="0" jsbarcode-fontoptions="bold">
			</svg> -->
			
			<h5 style="font-weight:bold">Signature of Consultant / Resident :</h5> 
			<%--<font class="loginConsultantName" style="display:none"><%=request.getSession().getAttribute("UserName").toString() %></font> --%>					                      
		<h5 style="margin-top:1" id="varUserName"><%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %></h5> 
		<%-- <%=((hisglobal.vo.UserVO)request.getSession().getAttribute( hisglobal.config.HISConfig.USER_VO) ).getUsrName().toString() %> </h5>  --%>
			<h5 class="visitDateonsultannt" style="margin-top:0"></h5> 
			<!-- <th>Consultant Name</th><td class="consultantName"></td> -->
			
			<!-- <h5 style="font-weight:bold" id="templateAnnexure">Annexure :</h5> 
			<div id="templateAttched"></div> -->
			
			
		</div>
	</div>
	<script>
	$(document).ready(function(){

		var patAddValue = sessionStorage.getItem('patAddValue');
		var patTimeOfVisitValue = sessionStorage.getItem('patTimeOfVisitValue');
    	console.log("patAddValue=+"+patAddValue)
    	console.log("patTimeOfVisitValue=+"+patTimeOfVisitValue)
		
		$('input[name=withHeaderCheck]').on('change', function(){
			if($(this).is(':checked'))
			{
				$('#printStyleId').text('');
				 //$(".divPrintPrescPatDtlTbl").addcss("visibility: hidden;");
				 $("#divPrintPrescPatDtlTblId").css("visibility", "hidden");
				 $("#LogoimgId").css("visibility", "hidden");
				 
			}
			else
			{
				$('#printStyleId').text('#printPrescPage{ margin-top:80px;}');
				
				$("#divPrintPrescPatDtlTblId").css("visibility", "");
				$("#LogoimgId").css("visibility", "");
				
			}
			});
    	console.log("localStorage.getItemflag---"+localStorage.getItem("flag"))
		var myJSON;
		var  datasave;
		var  userJson;
		var struserflg=0;
		var mobileNo = "";
	  if(localStorage.getItem("flag")=="0")
	  {
		 
		struserflg=1;
		myJSON = localStorage.getItem("myJSON");
		myJSON = JSON.parse(myJSON); 
		//alert("if");
	  }
	  else
	  {
		  //alert("else");	
		  $('.prescSaveBtn').hide();
		  var ajxRqstPatDtl = localStorage.getItem("ajxRqstPatDtl").split('#');
		  var url = '/HISDRDESK_MC/services/restful/patdata/getPatData?Modval=1&CrNo='+ajxRqstPatDtl[0]+'&episodeCode='+ajxRqstPatDtl[1]+'&visitNo='+ajxRqstPatDtl[2]+'&seatId=&Entrydate='+ajxRqstPatDtl[4]+'&hosp_code='+ajxRqstPatDtl[5];
			$.ajax({url: url, /*  '/HISDRDESK_MC/services/restful/patdata/getPatData?Modval=1&CrNo=331011800028649&episodeCode=10212001&visitNo=1&seatId=10038&Entrydate=27-DEC-2018&hosp_code=33101', */ 
				async:false,
				success: function(result){
					if(JSON.stringify(result)!="{}")
					{
						console.log("result >>> "+JSON.stringify(result));
						console.log(result);
						if(result.pat_details!=undefined)
						{
							if(result.pat_details.length>0)
							{ 
								myJSON = result.pat_details[0].HRSTR_JSON_DATA;
								userJson = result.pat_details[0].USER_NAME;
								datasave = result.pat_details[0].DATASAVE_TIME;								
							}
							else
							{ 
								swal({
									  title: "Prescription not saved through lite version !!",
									  text: "please save again to be printed",
									  icon: "warning", 
									}).then(function(willDelete) {
										window.parent.closePopUpIframe();
									});
							}
						}
						else
						{ 
							swal({
								  title: "Prescription not saved through lite version !!",
								  text: "please save again to be printed",
								  icon: "warning", 
								}).then(function(willDelete) {
									window.parent.closePopUpIframe();
								});
						}
						console.log("MYJSOON"+myJSON);
						console.log("datasave_TIME"+datasave);
					}
					}
				});
	  }
	  //alert('myJSON::::>>>>>'+JSON.stringify(myJSON));
	  if(myJSON==undefined)
		  return false;
	  var crc =localStorage.getItem("crc");
	 // alert(crc)
	  if(crc==undefined || crc==null){
		
		  $.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/generateCRC/',type:'POST',data:{JsonData:JSON.stringify(myJSON)},
			  success:function(result){
		   		 // alert(JSON.stringify(result))
		   		 
				  if(result["message"] ==undefined  || result["message"].indexOf("ERROR")<0){
						  localStorage.setItem("crc",result["crc"]);
						  localStorage.setItem("idForCRC",result["idForCRC"]);
						  localStorage.setItem("urlForQR",result["urlForQR"]);
						  myJSON=result;
						  
						  var urlForQR=result["urlForQR"];
						 
						  //alert(urlForQR);
						    var qrcode = new QRCode(document.getElementById("patQrCode"), {
							    text: urlForQR,
							    width: 90,
							    height: 90
							});
					}
				}
		  	});  

		}
	  else{
		 // alert("inside else")
		 // alert("inside else")
		  var urlForQR=myJSON["urlForQR"];
		 // alert("urlForQR==" + urlForQR)
		  var qrcode = new QRCode(document.getElementById("patQrCode"), {
			    text: urlForQR,
			    width: 100,
			    height: 100
			});

		  //alert("in else " + JSON.stringify(myJSON));
	  }
		
	  
		data = myJSON; 
		var tempObj = data;
		/* tempObj.InvTestCode = jQuery.grep(
				tempObj.InvTestCode, 
                function (item,index) { 
                  return index <  "2"; 
                });
		tempObj.InvTestCodeToPrint = jQuery.grep(
				tempObj.InvTestCodeToPrint, 
                function (item,index) { 
                  return index <  "0"; 
                });
		tempObj.DrugCodeCat = jQuery.grep(
				tempObj.DrugCodeCat, 
                function (item,index) { 
                  return index <  "2"; 
                });
		tempObj.ReasonOfVisit = jQuery.grep(
				tempObj.ReasonOfVisit, 
                function (item,index) { 
                  return index <  "2"; 
                });
		tempObj.Diagnosis = jQuery.grep(
				tempObj.Diagnosis, 
                function (item,index) { 
                  return index <  "2"; 
                });
		tempObj.PatCompleteGeneralDtl = jQuery.grep(
				tempObj.PatCompleteGeneralDtl, 
                function (item,index) { 
                  return index <  "0"; 
                }); */
		

                document.getElementById("patBarCode").innerHTML=DrawCode39Barcode(data.CR_No, 0);
                /* console.log('templateAttched -- '+localStorage.getItem("tempName"));

                if(localStorage.getItem("tempName")){

                	document.getElementById("templateAttched").innerHTML=localStorage.getItem("tempName");
                }else{
                	document.getElementById("templateAnnexure").style.display = "none"; 
                } */
                

                /* JsBarcode("#patBarCode", $("#awbno").text(), {
                	  format: "pharmacode",
                	  //lineColor: "#0aa",
                	  width: 4,
                	  height: 40,
                	  fontSize: 24,
             		  lineColor: "#1e1616",
                	  displayValue: true
                	});  */

                	/* JsBarcode("#patBarCode")
                	  .options({font: "OCR-B"}) // Will affect all barcodes
                	  .EAN13("1234567890128", {fontSize: 18, textMargin: 0})
                	  .blank(20) // Create space between the barcodes
                	  .EAN5("12345", {height: 85, textPosition: "top", fontSize: 16, marginTop: 15})
                	  .render(); */

                	  /* JsBarcode("#patBarCode", data.CR_No, {
                		  format: "CODE39",
                		  displayValue: true,
                		  height: 40,
                		  width: 1
                		}); */


                //JsBarcode(".barcode").init();

		$('.prescPrintBtn').click(function(){
			$(this).hide();
			$('.prescSaveBtn').hide();
			var date = new Date();
			document.title=data.CR_No.toString()+date.getDate()+(date.getMonth()+1)+date.getFullYear();
			console.log('Date:::::::::>>>>>>>'+date.getDate()+(date.getMonth()+1)+date.getFullYear());
			console.log('data.CR_No.toString()+(date.getDate()+date.getMonth()+date.getFullYear())::::::::::>>>>>>>'+data.CR_No.toString()+date.getDate()+(date.getMonth()+1)+date.getFullYear());
			window.print();
			if(localStorage.getItem("flag")=="0"){
				var myJSON=JSON.parse(localStorage.getItem("myJSON"));
				 myJSON["crc"]=localStorage.getItem("crc");
				 myJSON["idForCRC"]=localStorage.getItem("idForCRC");
				 myJSON["urlForQR"]=localStorage.getItem("urlForQR");
					
				window.parent.saveFromIframe(myJSON ,JSON.parse(localStorage.getItem("FormattedJson")));
			}	
			/* setTimeout(function(){ 
				$('.prescPrintBtn').show();
				window.parent.saveFromIframe(JSON.parse(localStorage.getItem("myJSON")) ,JSON.parse(localStorage.getItem("FormattedJson"))); 
			}, 1000);  */
		});
		
		$('.prescSaveBtn').click(function(){	
			$(this).hide();
			$('.prescPrintBtn').hide();
			var myJSON=JSON.parse(localStorage.getItem("myJSON"));

			 myJSON["crc"]=localStorage.getItem("crc");
			 myJSON["idForCRC"]=localStorage.getItem("idForCRC");
			 myJSON["urlForQR"]=localStorage.getItem("urlForQR");
			
			window.parent.saveFromIframe(myJSON,JSON.parse(localStorage.getItem("FormattedJson"))); 
			});
		$('.printPrescPage .visitDateonsultannt').text(new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear());
		
		console.log('struserflg struserflg '+ (struserflg == 0 || struserflg == '0'));
		console.log('#strRailTailFlgId :: '+ $('#strRailTailFlgId').val());
		if(struserflg == 0 || struserflg == '0'){
			$('#strUserNameId').html(userJson);
			$('.printPrescPage .visitDateonsultannt').text(datasave );
		}
		//alert("here");
		$('.printPrescPage .visitDateonsultannt').text(datasave );
		$('.printPrescPage .patName').text(data.pat_Name);
		$('.printPrescPage .patCrNo').text(data.CR_No); 
		$('.footerCrNo').text(data.CR_No);
		$('.printPrescPage .patAgeGen').text(data.patAge+'/'+data.patGender);
		$('.printPrescPage .patCat').text(data.patCat);
		$('.printPrescPage .patRelName').text(data.patGaurdianName);
		$('.printPrescPage .patDeptU').text(data.patDept);
		$('.printPrescPage .patAddressName').text(patAddValue);
		$('.printPrescPage .patTimeOfVisit').text(patTimeOfVisitValue);
		var patCat=data.patCat;
				
		var datef=(data.PatCompleteGeneralDtl).split('#')[12];
		console.log("DATE F "+datasave)
		$('.printPrescPage .patVisitDate').text(datef.split('/')[2]+'/'+datef.split('/')[1]+'/'+datef.split('/')[0] );
		//$('.printPrescPage .visitDateonsultannt').text(new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear()+' '+ new Date().getHours()+':'+new Date().getMinutes() );
		if($('#strRailTailFlgId').val() == '1')						//don't show consultantName in case of Railtel 
			$('.printPrescPage .consultantName').text('-');
		else
			$('.printPrescPage .consultantName').text(data.patConsultantName);
		$('.printPrescPage .mobileno').text((data.PatCompleteGeneralDtl).split('#')[14]);
		//$('.printPrescPage .occupation').text((data.PatCompleteGeneralDtl).split('#')[17]);
		$('.printPrescPage .occupation').text(((data.PatCompleteGeneralDtl).split('#')[17].includes('^'))? (data.PatCompleteGeneralDtl).split('#')[17].split('^')[0]:(data.PatCompleteGeneralDtl).split('#')[17]);

		if(data.ReasonOfVisit.length == 0)
			{
			$( "#reasonOfVisitDivId" ).parent().find('br').remove();
			$( "#reasonOfVisitDivId" ).remove();
			}
		for(var i=0;i<data.ReasonOfVisit.length;i++)
		{
			var VisitReason='';
			console.log('Visit Reason Length:::::::'+data.ReasonOfVisit[i].split('^').length);
			if(data.ReasonOfVisit[i].split('^').length == 2)
				{
				VisitReason=data.ReasonOfVisit[i]+'^0^^0';
				}else{
					VisitReason=data.ReasonOfVisit[i];
					}
			var x=VisitReason.split('^')[2];
			switch (parseInt(x)) {
			  case 0:
			    text = "";
			    break;
				case 1:
			    text = "NR";
			    break;
				case 2:
			    text = "Left";
			    break;
				case 3:
			    text = "Right";
			    break;
				case 4:
			    text = "Bilateral";			    
			    break;
				case 5:
				    text = "Upper Left";			    
				    break;
				case 6:
				    text = "Lower Left";			    
				    break;
				case 7:
				    text = "Upper Right";			    
				    break; 
				case 8:
				    text = "Lower Right";			    
				    break; 
				          
			    
			    
				default:
			    text = "";
			}
			var y=VisitReason.split('^')[4];
			switch (parseInt(y)) {
			  case 0:
			    text1 = "";
			    break;
				case 1:
			    text1 = "Day/s";
			    break;
				case 2:
			    text1 = "Week/s";
			    break;
				case 3:
			    text1 = "Month/s";
			    break;
				case 4:
			    text1 = "Year/s";
			    break;
				default:
			    text1 = "";
			}
			var temp='';

			if(VisitReason.split('^')[1].trim() != '' && VisitReason.split('^')[2] != '0'  && VisitReason.split('^')[3] != '' && VisitReason.split('^')[5] != '')
				temp=VisitReason.split('^')[1].trim()+'('+text+','+VisitReason.split('^')[3].trim()+' '+text1+') '+VisitReason.split('^')[5];
			else if( VisitReason.split('^')[1].trim() != '' && VisitReason.split('^')[2] != '0'  && VisitReason.split('^')[3] != '' )
				temp=VisitReason.split('^')[1].trim()+'('+text+','+VisitReason.split('^')[3].trim()+' '+text1+') ';
			else if( VisitReason.split('^')[1].trim() != '' && VisitReason.split('^')[2] != '0' )
				temp=VisitReason.split('^')[1].trim()+'('+text+') ';
			else if( VisitReason.split('^')[1].trim() != ''   && VisitReason.split('^')[3] != '' )
				temp=VisitReason.split('^')[1].trim()+'('+VisitReason.split('^')[3].trim()+' '+text1+') ';
			else if( VisitReason.split('^')[1].trim() != '' )
				temp=VisitReason.split('^')[1].trim() + ( VisitReason.split('^')[5] == '' ? '' : '('+ VisitReason.split('^')[5] +')' );



			
			/* if(text =='')
			temp=VisitReason.split('^')[1].trim()+'('+VisitReason.split('^')[3].trim() +text1+') '+VisitReason.split('^')[5];
			else if(VisitReason.split('^')[3].trim() == '')
			temp=VisitReason.split('^')[1].trim()+'('+text+') '+VisitReason.split('^')[5];	
			else if(text !='' && VisitReason.split('^')[3].trim() != '')
			temp=VisitReason.split('^')[1].trim()+'('+text+','+VisitReason.split('^')[3].trim()+' '+text1+') '+VisitReason.split('^')[5]; */
			
			$('.printPrescPage .reasonOfVisit').append(temp+', ');
		}
		console.log(':::::::::::'+ "strHistoryOfPresentIllNess" in data);
		if("strHistoryOfPresentIllNess" in data){
		if(data.strHistoryOfPresentIllNess != '')
			{
			$('.printPrescPage .historyIllnessNotes').append(data.strHistoryOfPresentIllNess);
			}else{
				$( "#historyIllnessNotesDivId" ).parent().find('br').remove();
				$( "#historyIllnessNotesDivId" ).remove();
				
				}
		}else{
			$( "#historyIllnessNotesDivId" ).parent().find('br').remove();
			$( "#historyIllnessNotesDivId" ).remove();
			
			}
		if("strVitalsChart" in data){
		if(data.strVitalsChart != '')
		{
			//$('.printPrescPage .vitalsdtls').append(data.strVitalsChart);
			//console.log("data.strVitalsChart===="+data.strVitalsChart.split(','));
			var vitalDataLen = data.strVitalsChart.split(',').length;
			for(var i=0;i<vitalDataLen;i++)
			{
				if(data.strVitalsChart.split(',')[i]!='' && data.strVitalsChart.split(',')[i].split(':')[0].trim()!='Cancer Screening')
					{
						//console.log(i+"xxxxxx"+data.strVitalsChart.split(',')[i]);
						$('.printPrescPage .vitalsdtls').append(data.strVitalsChart.split(',')[i]+", ");
					}
			}
		}else{
			$( "#vitalsdtlsDivId" ).parent().find('br').remove();
			$( "#vitalsdtlsDivId" ).remove();
			
			}
		}else{
			$( "#vitalsdtlsDivId" ).parent().find('br').remove();
			$( "#vitalsdtlsDivId" ).remove();
			
			}
		if(data.InvTestCodeToPrint.length == 0){
			$( "#investigationDivId" ).parent().find('br').remove();
			$( "#investigationDivId" ).remove();
			}
		if(data.strDrugAllergy != ''){
			$( "#NoAllergyDivId" ).remove();
			for(var i=0;i<data.strDrugAllergy.length;i++)
			{ 
				/*$('.printPrescPage .investigation').append(data.InvTestCode[i].split('^')[4].trim()+', ');*/
				console.log('data.strDrugAllergy[i].strAllergyName....................'+data.strDrugAllergy[i].strAllergyName);
				$('.printPrescPage .drugallergy').append(' <li> '+ (i+1)+') ' +data.strDrugAllergy[i].strAllergyName+' ,</li> ');
			}
		}else{
			$( "#drugallergyDivId" ).parent().find('br').remove();
			$( "#drugallergyDivId" ).remove();
		//	$('.printPrescPage .NoAllergyDivIdClass').append('No Known Drug Allergy');
			}
			
		for(var i=0;i<data.InvTestCodeToPrint.length;i++)
		{ 
			/*$('.printPrescPage .investigation').append(data.InvTestCode[i].split('^')[4].trim()+', ');*/
			//console.log('data.InvTestCodeToPrint[i]....................'+data.InvTestCodeToPrint[i]);
			//console.log('data.InvTestCodeToPrint[i]....................'+data.InvTestCodeToPrint[i].split('^').length);
			//$('.printPrescPage .investigation').append(' <li> '+ (i+1)+') ' +(data.InvTestCodeToPrint[i].split('^').length<=5?data.InvTestCodeToPrint[i].split('^')[4].trim():data.InvTestCodeToPrint[i].split('^')[5].trim())+' ,</li> ');
			if(data.InvTestCodeToPrint[i].split('^').length ==8){
				//alert("Inif");
				$('.printPrescPage .investigation').append(' <li> '+ (i+1)+') ' +(data.InvTestCodeToPrint[i].split('^')[7].trim())+' ,</li> ');
				}
				
				
				else if(data.InvTestCodeToPrint[i].split('^').length ==6){
					//alert("Inelseif1");
					$('.printPrescPage .investigation').append(' <li> '+ (i+1)+') ' +(data.InvTestCodeToPrint[i].split('^')[5].trim())+' ,</li> ');
					}
					
					
					else if(data.InvTestCodeToPrint[i].split('^').length ==9){
						//alert("Inelseif2");
						$('.printPrescPage .investigation').append(' <li> '+ (i+1)+') ' +(data.InvTestCodeToPrint[i].split('^')[8].trim())+' ,</li> ');
						}
						
						
						else{
							//alert("Inelse" + (data.InvTestCodeToPrint[i].split('^')[10].trim()));
							//alert("Inelse2" + data.InvTestCodeToPrint[i]);
							$('.printPrescPage .investigation').append(' <li> '+ (i+1)+') ' +(data.InvTestCodeToPrint[i].split('^')[10].trim())+' ,</li> ');
							}
							
						
			
		}

		
		console.log('data.strSystematicExamniation.length::::');
		console.log("strSystematicExamniation" in data );

	//	struserflg=0;
		if("strSystematicExamniation" in data){
			if(data.strSystematicExamniation.strLocalExamn != '' || data.strSystematicExamniation.strcvs != '' || data.strSystematicExamniation.strrs != '' || data.strSystematicExamniation.strcns != '' || data.strSystematicExamniation.strpA != '' || data.strSystematicExamniation.strmuscularExamn !='' || data.strSystematicExamniation.strotherExamn != '' || data.strpiccle.strpallor =='1' || data.strpiccle.strpallor =='1' || data.strpiccle.strcyanosis =='1' || data.strpiccle.strclubbing =='1' || data.strpiccle.strclubbing =='1' || data.strpiccle.stredema =='1'){
					
				} else{
					$( "#examinationDivId" ).parent().find('br').remove();
					$( "#examinationDivId" ).remove();
					}
			}else{
				$( "#examinationDivId" ).parent().find('br').remove();
				$( "#examinationDivId" ).remove();
				}
			console.log("strSystematicExamniation::::::");
			console.log("strSystematicExamniation" in data);
			if("strSystematicExamniation" in data){
			if(data.strSystematicExamniation.strcvs != '') 
			$('.printPrescPage .examination').append('<li><p>CVS: <small> '+(data.strSystematicExamniation.strcvs)+'</small></p></li>');

			if(data.strSystematicExamniation.strrs != '') 
				$('.printPrescPage .examination').append('<li><p>RS: <small> '+(data.strSystematicExamniation.strrs)+'</small></p></li>');

			if(data.strSystematicExamniation.strcns != '') 
				$('.printPrescPage .examination').append('<li><p>CNS: <small> '+(data.strSystematicExamniation.strcns)+'</small></p></li>');

			if(data.strSystematicExamniation.strpA != '') 
				$('.printPrescPage .examination').append('<li><p>P/A: <small> '+(data.strSystematicExamniation.strpA)+'</small></p></li>');

			console.log("data.strSystematicExamniation"+"strmuscularExamn" in  data.strSystematicExamniation);

			if(data.strSystematicExamniation.strotherExamn != '') 
				$('.printPrescPage .examination').append('<li><p>General Examination:<small> '+(data.strSystematicExamniation.strotherExamn)+'</small></p></li><br>');

			if("strmuscularExamn" in  data.strSystematicExamniation){
			if(data.strSystematicExamniation.strmuscularExamn != '') {
				$('.printPrescPage .examination').append('<li><p> Muscular Examination: <small> '+(data.strSystematicExamniation.strmuscularExamn)+'</small></p></li>');
			}
			}

			if("strLocalExamn" in  data.strSystematicExamniation){
				if(data.strSystematicExamniation.strLocalExamn != '') {
					$('.printPrescPage .examination').append('<li><p> Local Examination: <small> '+(data.strSystematicExamniation.strLocalExamn)+'</small></p></li>');
				}
			}

			
			
			}
			if("strpiccle" in data){
			if(data.strpiccle.strpallor =='1')
				$('.printPrescPage .examination1').append('Pallor &nbsp;&nbsp;&nbsp;');

			if(data.strpiccle.stricterus =='1')
				$('.printPrescPage .examination1').append('Icterus &nbsp;&nbsp;&nbsp;');

			if(data.strpiccle.strcyanosis =='1')
				$('.printPrescPage .examination1').append('Cyanosis &nbsp;&nbsp;&nbsp;');

			if(data.strpiccle.strclubbing =='1')
				$('.printPrescPage .examination1').append('Clubbing &nbsp;&nbsp;&nbsp;');

			if(data.strpiccle.striymphadenopathyId =='1')
				$('.printPrescPage .examination1').append('Lymphadenopathy &nbsp;&nbsp;&nbsp;');

			if(data.strpiccle.stredema =='1')
				$('.printPrescPage .examination1').append('Edema &nbsp;&nbsp;&nbsp;');
			//$('.printPrescPage .examination').append('<br>');
			}




			if("strCompleteHistory" in data){
				if(data.strCompleteHistory.strpastHistory != '' || data.strCompleteHistory.strpersonalHistory != '' || data.strCompleteHistory.strfamilyHistory != '' || data.strCompleteHistory.strtreatmentHistory != '' || data.strCompleteHistory.strsurgicalHistory != '' ){
						
					} else{
						$( "#completeHistoryDivId" ).parent().find('br').remove();
						$( "#completeHistoryDivId" ).remove();
						}
				}else{
					$( "#completeHistoryDivId" ).parent().find('br').remove();
					$( "#completeHistoryDivId" ).remove();
					}
				console.log("completeHistoryDivId::::::");
				console.log("strSystematicExamniation" in data);
				if("strSystematicExamniation" in data){
				if(data.strCompleteHistory.strpastHistory != '') 
				$('.printPrescPage .completeHistory').append('<li><p>Past History: <small> '+(data.strCompleteHistory.strpastHistory)+'</small></p></li>');

				if(data.strCompleteHistory.strpersonalHistory != '') 
					$('.printPrescPage .completeHistory').append('<li><p>Personal History: <small> '+(data.strCompleteHistory.strpersonalHistory)+'</small></p></li>');

				if(data.strCompleteHistory.strfamilyHistory != '') 
					$('.printPrescPage .completeHistory').append('<li><p>Family History: <small> '+(data.strCompleteHistory.strfamilyHistory)+'</small></p></li>');

				if(data.strCompleteHistory.strtreatmentHistory != '') 
					$('.printPrescPage .completeHistory').append('<li><p>Treatment History: <small> '+(data.strCompleteHistory.strtreatmentHistory)+'</small></p></li>');

				if(data.strCompleteHistory.strsurgicalHistory != '') 
					$('.printPrescPage .completeHistory').append('<li><p>Surgical History:<small> '+(data.strCompleteHistory.strsurgicalHistory)+'</small></p></li>');
				}



				if(data.strChronicDisease.length == 0)
				{
				$( "#chronicDiseaseDivId" ).parent().find('br').remove();
				$( "#chronicDiseaseDivId" ).remove();
				}




				for(var i=0;i<data.strChronicDisease.length;i++)
				{
					var temp ='' ; 
				 if(data.strChronicDisease[i].CronicDiseaseName !='' && data.strChronicDisease[i].CronicDiseaseDuration !='' && data.strChronicDisease[i].CronicDiseaseRemarks !=''){
							temp= data.strChronicDisease[i].CronicDiseaseName +'('+data.strChronicDisease[i].CronicDiseaseDuration+'yrs)'+ '('+ data.strChronicDisease[i].CronicDiseaseRemarks +')';
							} 
				 else if(data.strChronicDisease[i].CronicDiseaseName != '' && data.strChronicDisease[i].CronicDiseaseDuration !='' ){
						temp= data.strChronicDisease[i].CronicDiseaseName +'('+data.strChronicDisease[i].CronicDiseaseDuration+'yrs)';
						}
					else if(data.strChronicDisease[i].CronicDiseaseName != '' &&  data.strChronicDisease[i].CronicDiseaseRemarks !='' ){
								temp =data.strChronicDisease[i].CronicDiseaseName  + '('+ data.strChronicDisease[i].CronicDiseaseRemarks +')';
								}else{
									temp =data.strChronicDisease[i].CronicDiseaseName ;
									}
					
					$('.printPrescPage .chronicDisease').append(temp+', ');
				}


			
		if("strInvestgationNote" in data){
			
		if(data.strInvestgationNote.trim() != '')
			{
			$('.printPrescPage .investigationNoteID').append(data.strInvestgationNote);
			}
		else{
			$( "#investigationNoteID1" ).remove();
			
			}
		
		}
		else{
			$( "#investigationNoteID1" ).remove();
			} 
		
		if("strClinicalProcedure" in data){
		for(var i=0;i<data.strClinicalProcedure.length;i++)
		{ 
			var x=data.strClinicalProcedure[i].split('#')[2];
			switch (parseInt(x)) {
			  case 0:
			    text = "";
			    break;
				case 1:
			    text = "NR";
			    break;
				case 2:
			    text = "Left";
			    break;
				case 3:
			    text = "Right";
			    break;
				case 4:
			    text = "Bilateral";
			    break;
				default:
			    text = "";
			}
			
			console.log('data.Proceduresid[i]....................'+data.strClinicalProcedure[i].split('^').length);
			/* $('.printPrescPage .Proceduresid').append('<li><p>'); */
			if(text !="")
			text ='('+text+')';
			if(data.strClinicalProcedure[i].split('#').length == 7){
				var remarksprocedure=data.strClinicalProcedure[i].split('#')[4] ;

				//commented by ashutoshk for hiding service area name 
				//$('.printPrescPage .Proceduresid').append('<li><p>'+ data.strClinicalProcedure[i].split('#')[6] +' ['+data.strClinicalProcedure[i].split('#')[0]+']' + (text != '' ? text : '' )+ (remarksprocedure != '' ? '('+remarksprocedure +')'	 : '' ));
				$('.printPrescPage .Proceduresid').append('<li><p>'+' ['+data.strClinicalProcedure[i].split('#')[0]+']' + (text != '' ? text : '' )+ (remarksprocedure != '' ? '('+remarksprocedure +')'	 : '' ));
			}else{
			var remarksprocedure=data.strClinicalProcedure[i].split('#')[4] ;
			
			$('.printPrescPage .Proceduresid').append('<li><p>'+data.strClinicalProcedure[i].split('#')[0] + (text != '' ? text : '' )+ (remarksprocedure != '' ? '('+remarksprocedure +')'	 : '' ));
			}
			/* if(text != '')
			$('.printPrescPage .Proceduresid').append('('+text+')');
			
			if(data.strClinicalProcedure[i].split('#')[4] != '')
			$('.printPrescPage .Proceduresid').append('( '+data.strClinicalProcedure[i].split('#')[4]+' )');
 */
			$('.printPrescPage .Proceduresid').append('</p></li>');
		}
		}
		if("strClinicalProcedure" in data){
		if(data.strClinicalProcedure.length == 0)
			{
			$( "#ProceduresidDivId" ).parent().find('br').remove();
			$( "#ProceduresidDivId" ).remove();
			}
		}else{
			$( "#ProceduresidDivId" ).parent().find('br').remove();
			$( "#ProceduresidDivId" ).remove();
			}
		if(data.Diagnosis.length == 0){
			$( "#diagnosisDivId" ).parent().find('br').remove();
			$( "#diagnosisDivId" ).remove();
			}
		
		for(var i=0;i<data.Diagnosis.length;i++)
		{  
			var DiagnosisType='';var type='';
			console.log('DiagnosisType Length:');
			console.log(data.Diagnosis[i].split('#').length);
			if(data.Diagnosis[i].split('#').length == 8)
				{
				DiagnosisType=data.Diagnosis[i]+'#0##0#' ;
				}else{
					DiagnosisType=data.Diagnosis[i];	
					}
			var x=DiagnosisType.split('#')[4];
			switch (parseInt(x)) {
			  case 0:
			    text = "";
			    break;
				case 1:
			    text = "NR";
			    break;
				case 2:
			    text = "Left";
			    break;
				case 3:
			    text = "Right";
			    break;
				case 4:
			    text = "Bilateral";
			    break;
				default:
			    text = "";
			}
			if(data.Diagnosis[i].split('#')[0] =='0')
				{
				$('.printPrescPage .diagnosis').append(DiagnosisType.split('^')[1].trim().split('#')[0]+', ');
				}else{
			if(DiagnosisType.split('^')[1].trim().split('#')[1]!=undefined && DiagnosisType.split('^')[0].trim().split('#')[1]!=0)
			$('.printPrescPage .diagnosis').append(' '+DiagnosisType.split('^')[1].trim().split('#')[0]);
				
			if(DiagnosisType.split('#')[1] != '')
				$('.printPrescPage .diagnosis').append('(<i>'+DiagnosisType.split('^')[1].trim().split('#')[1]+', </i>');	
			if(DiagnosisType.split('#')[0] != ''){
				console.log("DiagnosisType.split('#')[0].trim()=="+DiagnosisType.split('#')[0].trim());
					if(DiagnosisType.split('#')[2].split('^')[0]==0)
						type = DiagnosisType.split('#')[0].trim();
					else
						type='SNOMEDCT-'+DiagnosisType.split('#')[0].trim();
				}
			//$('.printPrescPage .diagnosis').append('<i>'+type+', </i>');			
			if(text != "")
				$('.printPrescPage .diagnosis').append(text +', ');	
			
			console.log('DiagnosisType.split'+DiagnosisType);
			if(DiagnosisType.split('#')[7] != '')
			$('.printPrescPage .diagnosis').append(' '+DiagnosisType.split('#')[7] );

			$('.printPrescPage .diagnosis').append(')');

			}
			/* else
			$('.printPrescPage .diagnosis').append(DiagnosisType.split('^')[1].trim().split('#')[0]+', '); */
		}
		//if("strDiagnosisNote" in data){
		if(data.strDiagnosisNote != '')
		{
			$('.printPrescPage .diagnosisNoteID').append(data.strDiagnosisNote);
			$('.printPrescPage .diagnosisNoteID').append('<br>');
		} else{
			$( "#diagnosisNoteID1" ).remove();
		}
		
		
		
		
		if("strotherAllergies" in data){
			if(data.strotherAllergies != '')
			{
			  $('.printPrescPage .OtherAllergy').append(data.strotherAllergies);
				//$('.printPrescPage .treatmentadvice').append(data.strtreatmentAdvice);
			}else{
				$( "#OtherAllergyDivId" ).parent().find('br').remove();
				$( "#OtherAllergyDivId" ).remove();
				}
			}else{
				$( "#OtherAllergyDivId" ).parent().find('br').remove();
				$( "#OtherAllergyDivId" ).remove();
				}
		
		
		
		
		//}
		//console.log('data.FOLLOW_UP[0].progressNote -- '+data.FOLLOW_UP[0].progressNote);
		if(data.FOLLOW_UP[0].progressNote !='' ){

			if(data.FOLLOW_UP[0].progressNote !='')
				//$('.printPrescPage .clinicalNote').append('<pre style="background-color:white;border: 0px solid #ccc; text-align: justify;  width: 650px; font-weight: 400 !important;font-size: 16px; overflow: hidden; ">'+data.FOLLOW_UP[0].progressNote+'</pre>');
				$('.printPrescPage .clinicalNote').text(data.FOLLOW_UP[0].progressNote);	
		}else{
			$( "#clinicalNoteDivId" ).parent().find('br').remove();
			$( "#clinicalNoteDivId" ).remove();
			}
		if("strtreatmentAdvice" in data){
		if(data.strtreatmentAdvice != '')
		{
		  //$('.printPrescPage .treatmentadvice').append('<pre style="background-color:white;border: 0px solid #ccc; text-align: justify;  width: 650px; font-weight: 400 !important;font-size: 14px; overflow: hidden; ">'+data.strtreatmentAdvice+'</pre>');
			$('.printPrescPage .treatmentadvice').append(data.strtreatmentAdvice);
		}else{
			$( "#treatmentadviceDivId" ).parent().find('br').remove();
			$( "#treatmentadviceDivId" ).remove();
			}
		}else{
			$( "#treatmentadviceDivId" ).parent().find('br').remove();
			$( "#treatmentadviceDivId" ).remove();
			}
	//---Prashant
		if("prolongTreatment" in data){
			
			if(data.prolongTreatment != '')
			{
			  	$('.printPrescPage .prolongDetails').append(data.prolongTreatment);
			}else{
				$( "#prolongDetailsTRId" ).parent().find('br').remove();
				$( "#prolongDetailsTRId" ).remove();
				}
			}else{
				$( "#prolongDetailsTRId" ).parent().find('br').remove();
				$( "#prolongDetailsTRId" ).remove();
				}

	//---Prashant
		
		if(data.DrugCodeCat.length == 0){
			$( "#rxDivId" ).parent().find('br').remove();
			$( "#rxDivId" ).remove();
		//	$('.printPrescPage .NoDrugDivIdClass').append('No drugs Prescribed');
			}
		//alert(data.DrugCodeCat.length);
		for(var i=0;i<data.DrugCodeCat.length;i++)
		{ 
			$( "#NoDrugDivId" ).remove();
			var html="";
			
		/* Not in Use *//*  $('.printPrescPage .printPrescTreatmentTbl tbody').append('<tr><td>'+data.DrugCodeCat[i].split('&&')[0].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[2].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[4].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[7].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[8].trim()+'</td><tr>');*/
			 if(data.DrugCodeCat[i].split('&&')[8].trim()!='' && data.DrugCodeCat[i].split('&&')[8].trim() != null)
			{
					var temp =data.DrugCodeCat[i].split('&&')[6].trim();
					var tmpDate=temp.split('-')[2]+'-'+temp.split('-')[1]+'-'+temp.split('-')[0];
					//alert("line 932 :"+tmpDate);
				if(data.DrugCodeCat[i].split('&&')[7].trim()!='' && data.DrugCodeCat[i].split('&&')[7].trim() !=null){
					
					html+="<tr>";
					html+="<td style='width: 5%; border-bottom:1px solid grey;font-weight: normal;'>"+(i+1)+"</td>";
					html+="<td style='width: 30%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[0].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[2].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[4].trim()+"</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[0]+" Days</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[1]+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[8].trim()+"</td>";
					html+="</tr>";
					$('.printPrescPage #printPrescTreatmentLst tbody').append(html);
				}	
				else{ 
					html+="<tr>";
					html+="<td style='width: 5%; border-bottom:1px solid grey;font-weight: normal;'>"+(i+1)+"</td>";
					html+="<td style='width: 30%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[0].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[2].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[4].trim()+"</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[0]+" Days</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[1]+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[8]+"</td>";
					html+="</tr>";
					$('.printPrescPage #printPrescTreatmentLst tbody').append(html);
				}

					
				
			}
			else
			{
				var temp =data.DrugCodeCat[i].split('&&')[6].trim();
				var tmpDate=temp.split('-')[2]+'-'+temp.split('-')[1]+'-'+temp.split('-')[0];
				//alert("line 942 :"+tmpDate);
				if(data.DrugCodeCat[i].split('&&')[7].trim()!='' && data.DrugCodeCat[i].split('&&')[7].trim() !=null){

					html+="<tr>";
					html+="<td style='width: 5%; border-bottom:1px solid grey;font-weight: normal;'>"+(i+1)+"</td>";
					html+="<td style='width: 30%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[0].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[2].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[4].trim()+"</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[0]+" Days</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[1]+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[8]+"</td>";
					html+="</tr>";
					$('.printPrescPage #printPrescTreatmentLst tbody').append(html);
				}
				else{
					html+="<tr>";
					html+="<td style='width: 5%; border-bottom:1px solid grey;font-weight: normal;'>"+(i+1)+"</td>";
					html+="<td style='width: 30%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[0].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[2].trim()+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[4].trim()+"</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[0]+" Days</td>";
					html+="<td style='width: 10%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[7].trim().split('#')[1]+"</td>";
					html+="<td style='width: 15%; border-bottom:1px solid grey;font-weight: normal;'>"+data.DrugCodeCat[i].split('&&')[8]+"</td>";
					html+="</tr>";
					$('.printPrescPage #printPrescTreatmentLst tbody').append(html);	
				}
					
			}
				
			 

			
		}
		
		if("strUmidNo" in data ){
			
			if(data.strUmidNo != ''){
				
				$('.printPrescPage .umidId').text(data.strUmidNo);
				}
			else{
				$('#strUmidtblID').css('display','none');
			}
			
		}else{
			$('#strUmidtblID').css('display','none');
		}
		
if("strDesignation" in data ){
			
			if(data.strDesignation != ''){
				
				$('.printPrescPage .strDesignationID').text(data.strDesignation);
				}
			else{
				$('#strDesignationID').css('display','none');
			}
			
		}	else{
			$('#strDesignationID').css('display','none');
		}
	
		
if("strStation" in data ){
	
	if(data.strStation != ''){
		
		$('.printPrescPage .strStationID').text(data.strStation);
		}
	else{
		$('#strStationID').css('display','none');
	}
	
}else{
	$('#strStationID').css('display','none');
}
		console.log("admissionadviceDeptName::::::");
		console.log("admissionadviceDeptName" in data);
		if("admissionadviceDeptName" in data ){
			if(data.admissionadviceDeptName != ''){
				
				$('.printPrescPage .admissionPatientDept').append('<p>Deparment :	'+data.admissionadviceDeptName+'  , Ward :	'+data.admissionadviceWardName+'  Notes :	'+data.admissionadviceNotes+'</p>');
				
				}else{
					/*var myLSJSON='';
					if(localStorage.getItem("AdmAdvcJsonData")){
						myLSJSON = localStorage.getItem("AdmAdvcJsonData");
						myLSJSON = JSON.parse(myLSJSON);
						$('.printPrescPage .admissionPatientDept').append('<p>Deparment :	'+myLSJSON.Department+'  , Unit :	'+myLSJSON.Unit+'  </p>');
						localStorage.removeItem("AdmAdvcJsonData");
					}else{*/
						$( "#admissionDeptDivId" ).remove();
					//}
				}
			}else{
				/*var myLSJSON='';
				if(localStorage.getItem("AdmAdvcJsonData")){
					myLSJSON = localStorage.getItem("AdmAdvcJsonData");
					myLSJSON = JSON.parse(myLSJSON);
					$('.printPrescPage .admissionPatientDept').append('<p>Deparment :	'+myLSJSON.Department+'  , Unit :	'+myLSJSON.Unit+'  </p>');
					localStorage.removeItem("AdmAdvcJsonData");
				}
				else{*/
					$( "#admissionDeptDivId" ).remove();
				//}
			}

	if(data.strEndorsmentDtl!=undefined &&  data.strEndorsmentDtl.length > 0 ){
			//alert(JSON.stringify(data.strReferal));
			$.each(data.strEndorsmentDtl , function(indx, refJson){
				var str="<tr>";
				str+="<td>"+refJson["strEndorsementHospitalName"]+"</td>";
				str+="<td>"+refJson["strEndorsementDepartmentName"]+"</td>";
				str+="<td>"+refJson["strEndorsementDoctor"]+"</td>";
				str+="</tr>";
				$('#EndorsementListTable tbody').append(str);
			});
	}else{
			$('#EndorsmentDivId').remove();
	}		
	if(data.strReferal!=undefined &&  data.strReferal.length > 0 ){
		//alert(JSON.stringify(data.strReferal));
		$.each(data.strReferal , function(indx, refJson){
			var str="<tr>";
			str+="<td>"+refJson["strReffralDepttext"]+"</td>";
			str+="<td>"+refJson["strReffralReason"]+"</td>";
			str+="</tr>";
			$('#InternalReffralListTable tbody').append(str);
		});
	}else{
		$('#refferPatientDeptDivId').remove();
	}
	
	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos!=null)
	$('.printPrescPage .followUp').append(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos);
	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays!=null)
	$('.printPrescPage .followUp').append('<br>'+'After '+data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays+' Days');
	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate!=null)
	$('.printPrescPage .followUp').append('<br>'+'On '+data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate);
	
	$('.printPrescPage .date').text(new Date().toDateString());

	
	});
	
	</script>


<div id="footer">--------This slip is computer-generated and does not require a signature.---------</div>
 <style type="text/css" media="print" id="printStyleId"></style>


  <input type="hidden" name="strHospitalAddres" value="${DoctorDeskFB.strHospitalAddres}"/>
<input type="hidden" name="strHospitalName" value="${DoctorDeskFB.strHospitalName}"/>
<input type="hidden" name="strRailTailFlg" id="strRailTailFlgId" value="${DoctorDeskFB.strRailTailFlg}" />
  
</body>
</html>
