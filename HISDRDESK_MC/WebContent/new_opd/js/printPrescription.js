var isSeparateRestrictedMedicine=false;
var myJSON;

	var  datasave;
	var  userJson;
	$(document).ready(function(){
		
		 var flag=localStorage.getItem("flag");
		 if(flag=="0")
		  {//alert("1");
			struserflg=1;
			myJSON = localStorage.getItem("myJSON");
			myJSON = JSON.parse(myJSON); 
			getCRCData();
			
		  }
		  else
		  {
			  //alert("inside else");
			  $('#prescSaveBtn').hide();
			  getPatData();
		  }	


		 $('#prescSaveLoadBtn').click(function(){	
			 
			 //alert(1);
			// console.log(" prescSaveBtn         > :       :"  + JSON.parse(localStorage.getItem("FormattedJson")));
				//$(this).hide();
				$('.prescPrintBtn').hide();
				
				var myJSON=JSON.parse(localStorage.getItem("myJSON"));

				 myJSON["crc"]=localStorage.getItem("crc");
				 myJSON["idForCRC"]=localStorage.getItem("idForCRC");
				 myJSON["urlForQR"]=localStorage.getItem("urlForQR");
				 myJSON["patConsultantName"]=$('#varUserName').text()
				 

				 var printData=encryptBase64($('#divPrintable').html() );// prescription
				 myJSON["printData"]=printData;
				 
				 if($('#divPrintable2').length>0){
					 var printData2=encryptBase64($('#divPrintable2').html() );// referral print
					 myJSON["referPrintData"]=printData2;
				 }

				window.parent.saveFromIframe(myJSON,JSON.parse(localStorage.getItem("FormattedJson"))); 
		});
		 
		 $('#prescSaveBtn').click(function(){	//for same page
			 
			 //alert(1);
			// console.log(" prescSaveBtn         > :       :"  + JSON.parse(localStorage.getItem("FormattedJson")));
				//$(this).hide();
				$('.prescPrintBtn').hide();
				
				var myJSON=JSON.parse(localStorage.getItem("myJSON"));

				 myJSON["crc"]=localStorage.getItem("crc");
				 myJSON["idForCRC"]=localStorage.getItem("idForCRC");
				 myJSON["urlForQR"]=localStorage.getItem("urlForQR");
				 myJSON["patConsultantName"]=$('#varUserName').text()
				 

				 var printData=encryptBase64($('#divPrintable').html() );// prescription
				 myJSON["printData"]=printData;
				 
				 if($('#divPrintable2').length>0){
					 var printData2=encryptBase64($('#divPrintable2').html() );// referral print
					 myJSON["referPrintData"]=printData2;
				 }

				window.parent.saveFromIframe1(myJSON,JSON.parse(localStorage.getItem("FormattedJson"))); 
		});

		 $('#prescPrintBtn').click(function(){
				$('.prescBtn').hide();
				
				var date = new Date();
				document.title=myJSON.CR_No.toString()+date.getDate()+(date.getMonth()+1)+date.getFullYear();
				window.print();
				if(localStorage.getItem("flag")=="0"){
					
					 myJSON["crc"]=localStorage.getItem("crc");
					 myJSON["idForCRC"]=localStorage.getItem("idForCRC");
					 myJSON["urlForQR"]=localStorage.getItem("urlForQR");
					 myJSON["patConsultantName"]=$('#varUserName').text()
					 
					 
					 var printData=encryptBase64($('#divPrintable').html() );// prescription
					 myJSON["printData"]=printData;
					 
					 if($('#divPrintable2').length>0){
						 var printData2=encryptBase64($('#divPrintable2').html() );// referral print
						 myJSON["referPrintData"]=printData2;
					 }
						 
					 
					 window.parent.saveFromIframe(myJSON ,JSON.parse(localStorage.getItem("FormattedJson")));
				}
		});		
		 	
	});

	
	
	function getPatData(){
		var ajxRqstPatDtl = localStorage.getItem("ajxRqstPatDtl").split('#');
		var url = '/HISDRDESK_MC/services/restful/patdata/getPatData?Modval=1&CrNo='+ajxRqstPatDtl[0]+'&episodeCode='+ajxRqstPatDtl[1]+'&visitNo='+ajxRqstPatDtl[2]+'&seatId=&Entrydate='+ajxRqstPatDtl[4]+'&hosp_code='+ajxRqstPatDtl[5];
			$.ajax({url: url,  
				async:false,
				success: function(result){
					if(JSON.stringify(result)!="{}")
					{
						//alert("result >>> "+JSON.stringify(result));
						console.log("result >>> "+JSON.stringify(result));
						console.log(result);
						if(result.pat_details!=undefined)
						{
							if(result.pat_details.length>0)
							{ 
								myJSON = result.pat_details[0].HRSTR_JSON_DATA;
								userJson = result.pat_details[0].USER_NAME;
								datasave = result.pat_details[0].DATASAVE_TIME;		
								getCRCData();
								populateFormData(myJSON);						
							}
							else
							{ 
								alert("Prescription not saved through lite version !!");
								
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
	function generateQR(myJSON){
		var urlForQR=myJSON["urlForQR"];
		//alert("urlForQR>>" +urlForQR);
		 var qrcode = new QRCode(document.getElementById("patQrCode"), {
			    text: urlForQR,
			    width: 100,
			    height: 100
		});
	}
	function getCRCData(){
		 var crc =localStorage.getItem("crc");
		 var urlForQR =localStorage.getItem("urlForQR");
		 var idForCRC =localStorage.getItem("idForCRC");
		  	 
		 if(crc==undefined || crc==null){
			
			  $.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/generateCRC/',type:'POST',data:{JsonData:JSON.stringify(myJSON)},
				  success:function(result){
			   		 
					  if(result["message"] ==undefined  || result["message"].indexOf("ERROR")<0){
							  localStorage.setItem("crc",result["crc"]);
							  localStorage.setItem("idForCRC",result["idForCRC"]);
							  localStorage.setItem("urlForQR",result["urlForQR"]);
							  myJSON=result;
							  generateQR(myJSON);
							  populateFormData(myJSON)									  
						}
					}
			  	});  
	
		 }
		 else{
				
			  myJSON["crc"]=crc;
			  myJSON["urlForQR"]=urlForQR;
			  myJSON["idForCRC"]=idForCRC;	
			  generateQR(myJSON);
			  populateFormData(myJSON);
			  //console.log("pupolateFormData  >>  >     "+JSON.stringify(myJSON));
		  }
		}
	function formatTimeToAMPM(timeString) {
	    var timeParts = timeString.split(':');
	    var hours = parseInt(timeParts[0]);
	    var minutes = timeParts[1];
	    var seconds = timeParts[2];
	    var ampm = hours >= 12 ? 'PM' : 'AM';
	    
	    // Convert hours to 12-hour format
	    hours = hours % 12;
	    hours = hours ? hours : 12; // the hour '0' should be '12'
	    
	    return hours + ':' + minutes + ':' + seconds + ' ' + ampm;
	}
		

	function populateFormData(data){
		console.log("json>>>>>"+ JSON.stringify(data));
		var cardType =data["cardType"]!=undefined?data["cardType"]:"";
		var relation =data["relation"]!=undefined?data["relation"]:"";
		//alert("cardType>>" + cardType);
		//alert("relation>>" + relation);
		$('.tdCardType').text(cardType);		
		$('.tdName').text(data["pat_Name"]);		
		$('.tdAgeGender').text(data["patAge"]+ "/" + myJSON["patGender"]);
		$('.tdBenId').text(data["CR_No"]);
		//$('#tdMobile').text((data.PatCompleteGeneralDtl).split('#')[14]);
		$('.tdRelation').text(relation);
		$('.tdDepartment').text(data["patDept"]);
		
		//var datef=(data.PatCompleteGeneralDtl).split('#')[12];
		
		var datecurf = data.currentVisitDate;
		console.log("Original date: " + datecurf);
		
		var parts = datecurf.split(' ');
		var datePart = parts[0];
		var timePart = parts[1];
		
		var formattedTime = formatTimeToAMPM(timePart);
		
		// Combine back with date
		var formattedDate = datePart + ' ' + formattedTime;
		console.log("Formatted date: " + formattedDate);
		//var datecurf=data.currentVisitDate;
		//console.log("datef  >>>> / "  +datecurf);
		$('.tdVisitDate').text(formattedDate);
		$('.visitDateonsultannt').text(new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear());
		var referralId=data["referralId"];
		if(referralId!=""){
			$('#tdReferral1').text(referralId);
			populateEndorementDtl(data);
			populateExternalReferal(data);			
		}
		else{
			$('#divPrintable2').remove();
		}

/* 		if((stJson["status"] === "R" || stJson["status"] === "HV")!=""){
			$('#tdReferral1').text(referralId);
			populateEndorementDtl(data);
			populateExternalReferal(data);			
		}
		else{
			$('#divPrintable').remove();
		} */
		
		populateInternalReferralDtl(data);
		
		populateVitals(data);
		populateChiefComplaint(data);
		populateCompleteHistory(data);
		populateExamination(data);
		polulateChronicDisease(data);
		populateDiagnosis(data);
		populateDiagnosisNote(data);
		populateInvestigation(data);
		populateInvestigationAdviceDtl(data);
		populateProcedureDtl(data);
		populateTreatmentAdvice(data);
		populateAllergyDtl(data);
		populateDrugDtl(data);
		if(isSeparateRestrictedMedicine==true)
			populateRestrictedDrugDtl(data);
		else
			$('#divDrugPrintable').remove();
			
		populateVisitSummary(data);  
		populateLabReport(data);
		populateProxyDtl(data);
		
	}
 	function populateEndorementDtl(data){
		//alert("inside populateEndorementDtl");
		$('#EndorsementDtl').empty();
		if(data.strEndorsmentDtl==undefined || data.strEndorsmentDtl.length == 0 ){
			$('.Endorsement').remove();
			return;
		}
		
		var str="This endorsment is based on reference by <b>";
		$.each(data.strEndorsmentDtl , function(indx, refJson){
			 str+= refJson["strEndorsementHospitalName"] +" ("+ refJson["strEndorsementDepartmentName"]+ " / "+refJson["strEndorsementDoctor"]+")";
		}); 
		str+="</b></p>";
		
		$('#refEndFlagID').hide();
		$('#EndorsementDtl').html(str); 
			
	} 
	function populateInternalReferralDtl(data){
		$('#InternalReffralListTable tbody').empty();
		if(data.strReferal==undefined ||  data.strReferal.length == 0 ){
			$('.InternalReffral').remove();
			return;
		}
		//alert(JSON.stringify(data.strReferal));
		$.each(data.strReferal , function(indx, refJson){
			var str="<tr>";
			str+="<td>"+refJson["strReffralDepttext"]+"</td>";
			str+="<td>"+refJson["strReffralReason"]+"</td>";
			str+="</tr>";
			$('#InternalReffralListTable tbody').append(str);
		});
		
	}
	function populateVitals(data){
		$('#vitalDtl').empty();
		//alert(JSON.stringify(data));
		if(data.strVitalsChart==undefined || data.strVitalsChart == ''){
			$('.vitals').remove();
			return;
		}
		//alert(data.strVitalsChart);
		var vitalDataLen = data.strVitalsChart.split(',').length;
		for(var i=0;i<vitalDataLen;i++)
		{
			if(data.strVitalsChart.split(',')[i]!='' && data.strVitalsChart.split(',')[i].split(':')[0].trim()!='Cancer Screening')
				{
					//console.log(i+"xxxxxx"+data.strVitalsChart.split(',')[i]);
					$('#vitalDtl').append(data.strVitalsChart.split(',')[i]+", ");
				}
		}
		

	}
	function populateChiefComplaint(data){
		$('#chiefCompiantDtl').empty();
		if(data.ReasonOfVisit.length == 0)
		{
			$( ".chiefCompiants" ).remove();
			return;
		}
		for(var i=0;i<data.ReasonOfVisit.length;i++)
		{
			var VisitReason='';
			
			
			if(data.ReasonOfVisit[i].split('^').length == 2)
			{
				
				VisitReason=data.ReasonOfVisit[i]+'^0^^0^';
			}else{
				VisitReason=data.ReasonOfVisit[i];
			}
			
		
		var temp=VisitReason.split('^')[1].trim();
		var otherdtl="";
		if(VisitReason.split('^')[2] != '0'){
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
			otherdtl+=text+",";
		}
		
		if(VisitReason.split('^')[3].trim()!=""){
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
			otherdtl+=VisitReason.split('^')[3].trim() + " "+ text1+","
		}
		
	
		if(VisitReason.split('^')[5]!=undefined  && VisitReason.split('^')[5] != ''){
			otherdtl+=VisitReason.split('^')[5]; 
		}
		if(otherdtl.endsWith(",")){
			otherdtl=otherdtl.substring(0, otherdtl.length-1);
		}
		
		if(otherdtl!=""){
			temp=temp + "("+otherdtl+")"; 
		}
				
		$('#chiefCompiantDtl').append(temp+',');
	}
		
}
function populateCompleteHistory(data){

	var found=false;

	$('#completeHistoryDtl').empty();
	if(data.strHistoryOfPresentIllNess!=undefined && data.strHistoryOfPresentIllNess.trim()!=""){
		$('#completeHistoryDtl').append('<li><p><b>Past History :</b> '+(data.strHistoryOfPresentIllNess.trim())+'</p></li>');
		found=true;
	}
	if("strCompleteHistory" in data){
		if(data.strCompleteHistory.strpastHistory!=undefined && data.strCompleteHistory.strpastHistory.trim()!=""){
			$('#completeHistoryDtl').append('<li><p><b>Past History :</b> '+(data.strCompleteHistory.strpastHistory.trim())+'</p></li>');
			found=true;
		}
		if(data.strCompleteHistory.strpersonalHistory!=undefined && data.strCompleteHistory.strpersonalHistory.trim()!=""){
			$('#completeHistoryDtl').append('<li><p><b>Personal History :</b> '+(data.strCompleteHistory.strpersonalHistory.trim())+'</p></li>');
			found=true;
		}
		if(data.strCompleteHistory.strfamilyHistory!=undefined && data.strCompleteHistory.strfamilyHistory.trim()!=""){
			$('#completeHistoryDtl').append('<li><p><b>Family History :</b> '+(data.strCompleteHistory.strfamilyHistory.trim())+'</p></li>');
			found=true;
		}
		if(data.strCompleteHistory.strtreatmentHistory!=undefined && data.strCompleteHistory.strtreatmentHistory.trim()!=""){
			$('#completeHistoryDtl').append('<li><p><b>Treatment History :</b> '+(data.strCompleteHistory.strtreatmentHistory.trim())+'</p></li>');
			found=true;
		}
		if(data.strCompleteHistory.strsurgicalHistory!=undefined && data.strCompleteHistory.strsurgicalHistory.trim()!=""){
			$('#completeHistoryDtl').append('<li><p><b>Surgical History :</b> '+(data.strCompleteHistory.strsurgicalHistory.trim())+'</p></li>');
			found=true;
		}
	}
	if(found==false){
		$('.completeHistory').remove();
	}	
}
function populateExamination(data){
	var found=false;
	$('#examination1').empty();
	$('#examination').empty();
	if("strpiccle" in data){
		
		if(data.strpiccle.strpallor =='1'){
			$('#examination1').append('Pallor &nbsp;&nbsp;&nbsp;');
			found=true;
		}
	
		if(data.strpiccle.stricterus =='1'){
			$('#examination1').append('Icterus &nbsp;&nbsp;&nbsp;');
			found=true;
		}
	
		if(data.strpiccle.strcyanosis =='1'){
			$('#examination1').append('Cyanosis &nbsp;&nbsp;&nbsp;');
			found=true;
		}
	
		if(data.strpiccle.strclubbing =='1'){
			$('#examination1').append('Clubbing &nbsp;&nbsp;&nbsp;');
			found=true;
		}
	
		if(data.strpiccle.striymphadenopathyId =='1'){
			$('#examination1').append('Lymphadenopathy &nbsp;&nbsp;&nbsp;');
			found=true;
		}
	
		if(data.strpiccle.stredema =='1'){
			$('#examination1').append('Edema &nbsp;&nbsp;&nbsp;');
			found=true;
		}
		
	}
	
	if("strSystematicExamniation" in data){
		if(data.strSystematicExamniation.strcvs!=undefined && data.strSystematicExamniation.strcvs != '') {
			$('#examination').append('<li><p><b>CVS :</b> '+(data.strSystematicExamniation.strcvs)+'</p></li>');
			found=true;
		}

		if(data.strSystematicExamniation.strrs!=undefined && data.strSystematicExamniation.strrs != ''){ 
			$('#examination').append('<li><p><b>RS :</b> '+(data.strSystematicExamniation.strrs)+'</p></li>');
			found=true;
		}

		if(data.strSystematicExamniation.strcns!=undefined && data.strSystematicExamniation.strcns != ''){ 
			$('#examination').append('<li><p><b>CNS :</b> '+(data.strSystematicExamniation.strcns)+'</p></li>');
			found=true;
		}

		if(data.strSystematicExamniation.strpA!=undefined && data.strSystematicExamniation.strpA != ''){ 
			$('#examination').append('<li><p><b>P/A : </b> '+(data.strSystematicExamniation.strpA)+'</p></li>');
			found=true;
		}


		if(data.strSystematicExamniation.strotherExamn!=undefined && data.strSystematicExamniation.strotherExamn != ''){ 
			$('#examination').append('<li><p><b>General Examination :</b> '+(data.strSystematicExamniation.strotherExamn)+'</p></li>');
			found=true;
		}

		
		if(data.strSystematicExamniation.strmuscularExamn!=undefined && data.strSystematicExamniation.strmuscularExamn != '') {
			$('#examination').append('<li><p><b>Muscular Examination :</b> '+(data.strSystematicExamniation.strmuscularExamn)+'</p></li>');
			found=true;
		}
		

	
		if(data.strSystematicExamniation.strmuscularExamn!=undefined &&  data.strSystematicExamniation.strLocalExamn != '') {
				$('#examination').append('<li><p><b>Local Examination :</b> '+(data.strSystematicExamniation.strLocalExamn)+'</p></li>');
				found=true;
		}
		
	}	
	if(found==false){
		$('.Examination').remove();
	}	
}
function polulateChronicDisease(data){
	$('#chronicDiseaseDtl').empty();
	if(data.strChronicDisease==undefined || data.strChronicDisease.length == 0)
	{
		$( ".chronicDisease" ).remove();
		return;
	}
   
	for(var i=0;i<data.strChronicDisease.length;i++)
	{
		var temp ='' ; 

		if(data.strChronicDisease[i].CronicDiseaseName !='')
		 temp=temp+data.strChronicDisease[i].CronicDiseaseName;

	   var otherdtl="";
	   if(data.strChronicDisease[i].CronicDiseaseDuration !='')
		   otherdtl   +=data.strChronicDisease[i].CronicDiseaseDuration +",";

	   if(data.strChronicDisease[i].CronicDiseaseRemarks !='')
		   otherdtl   +=data.strChronicDisease[i].CronicDiseaseRemarks +",";

	    if(otherdtl.endsWith(",")){
			otherdtl=otherdtl.substring(0, otherdtl.length-1);
		}
		
		if(otherdtl!=""){
			temp=temp + "("+otherdtl+")"; 
		}
		
		$('#chronicDiseaseDtl').append(temp+', ');
	}
}
function populateDiagnosis(data){
	$('#diagnosisDtl').empty();
	if(data.Diagnosis==undefined || data.Diagnosis.length == 0)
	{
		$( ".diagnosis" ).remove();
		return;
	}	
	
	for(var i=0;i<data.Diagnosis.length;i++)
	{  
		var DiagnosisType='';
		var type='';

		var arrDaignosis=data.Diagnosis[i].split('#');
		
		var diagnosisName=arrDaignosis[2].split("^")[1];
		var diagnosisSiteId="";
		var diagnosisType=arrDaignosis[3];
		var remarks=arrDaignosis[7];
		//alert(remarks);
		var x=arrDaignosis[4];
		switch (parseInt(x)) {
		  case 0:
			  diagnosisSiteId = "";
		    break;
			case 1:
				diagnosisSiteId = "NR";
		   		 break;
			case 2:
				diagnosisSiteId = "Left";
		    	break;
			case 3:
				diagnosisSiteId = "Right";
		    	break;
			case 4:
				diagnosisSiteId = "Bilateral";
		    break;
			case 5:
				diagnosisSiteId = "Upper Left";
		   		break;
			case 6:
				diagnosisSiteId = "Lower Left";
		   		break;	
			case 7:
				diagnosisSiteId = "Upper Right";
		   		break;	
			case 8:
				diagnosisSiteId = "Lower Right";
		   		break;	
			default:
				diagnosisSiteId = "";
		}
		var temp=diagnosisName;
		var otherdtl="";
		if(diagnosisSiteId!=undefined && diagnosisSiteId!="")
			otherdtl+=diagnosisSiteId+",";
		
		if(diagnosisType!=undefined && diagnosisType!="" && diagnosisType!="0")
			otherdtl+=diagnosisType+","; 
		
		if(remarks!=undefined &&  remarks!="" && remarks.trim()!=0){			
			otherdtl+=remarks+","; 
		}
		
		if(otherdtl.endsWith(",")){
			otherdtl=otherdtl.substring(0, otherdtl.length-1);
		}
		
		if(otherdtl!=""){
			temp=temp + "("+otherdtl+")"; 
		}	
		
		$('#diagnosisDtl').append(temp+', ');
		
	}
}
function populateDiagnosisNote(data){
	
	if(data.strDiagnosisNote==undefined || data.strDiagnosisNote.trim()==''){
		$('.diagnosisAdvice').remove();
		return;
	}
	$('#diagnosisAdviceDtl').html(data.strDiagnosisNote);
}
function populateInvestigation(data){
	$('#InvestigationDtl').empty();
	if(data.InvTestCodeToPrint==undefined || data.InvTestCodeToPrint.length==0){
		$('.Investigation').remove();
		return;
	}
	for(var i=0;i<data.InvTestCodeToPrint.length;i++)
	{ 
		if(data.InvTestCodeToPrint[i].split('^').length ==8){
			$('#InvestigationDtl').append('<li>' +(data.InvTestCodeToPrint[i].split('^')[7].trim())+' </li> ');
		}
		else if(data.InvTestCodeToPrint[i].split('^').length ==6){
			$('#InvestigationDtl').append('<li>' +(data.InvTestCodeToPrint[i].split('^')[5].trim())+' </li> ');
		}
		else if(data.InvTestCodeToPrint[i].split('^').length ==9){
			$('#InvestigationDtl').append('<li>' +(data.InvTestCodeToPrint[i].split('^')[8].trim())+' </li> ');
		}
		else{
			$('#InvestigationDtl').append('<li>' +(data.InvTestCodeToPrint[i].split('^')[10].trim())+' </li> ');
		}
	}
}
function populateInvestigationAdviceDtl(data){
	if(data.strInvestgationNote==undefined || data.strInvestgationNote.trim()==''){
		$('.InvestigationAdvice').remove();
		return;
	}
	$('#InvestigationAdviceDtl').html(data.strInvestgationNote);	
}
function populateProcedureDtl(data){

	$('#ProcedureDtl').empty();
	if(data.strClinicalProcedure==undefined || data.strClinicalProcedure.length==0){
		$('.Procedure').remove();
		return;
	}
	
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
         
			
			if(text !="")
				text ='('+text+')';
			if(data.strClinicalProcedure[i].split('#').length == 7){
				var remarksprocedure=data.strClinicalProcedure[i].split('#')[4] ;
				$('#ProcedureDtl').append('<li><p>'+data.strClinicalProcedure[i].split('#')[0] + " " +(text != '' ? text : '' )+ (remarksprocedure != '' ? '('+remarksprocedure +')'	 : '' ));
			}else{
				var remarksprocedure=data.strClinicalProcedure[i].split('#')[4] ;
				$('#ProcedureDtl').append('<li><p>'+data.strClinicalProcedure[i].split('#')[0] + " " + (text != '' ? text : '' )+ (remarksprocedure != '' ? '('+remarksprocedure +')'	 : '' ));
			}
			$('#ProcedureDtl').append('</p></li>');
	}
	
}

function populateTreatmentAdvice(data){
	if(data.strtreatmentAdvice==undefined || data.strtreatmentAdvice.trim()==''){
		$('.TreatmentAdvice').remove();
		return;
	}
	$('#TreatmentAdviceDtl').html(data.strtreatmentAdvice);	
}
function populateAllergyDtl(data)
{
	$('#AllergyDtl').empty();
	
	if(data.strDrugAllergy==undefined || data.strDrugAllergy.length==0){
		$('.Allergy').remove();
		return;
	}	

	
	for(var i=0;i<data.strDrugAllergy.length;i++)
	{ 
		var allergyName=data.strDrugAllergy[i].strAllergyName;
		allergyName=allergyName.replace(";","");
		var alergypara=""
		if(data.strDrugAllergy[i].strSensivityName!=undefined){
			alergypara+=data.strDrugAllergy[i].strSensivityName+",";
			alergypara=alergypara.replace(";","");
		}

		if(data.strDrugAllergy[i].strAllergysiteName!=undefined){
			alergypara+=data.strDrugAllergy[i].strAllergysiteName+",";
			alergypara=alergypara.replace(";","");
		}

		if(data.strDrugAllergy[i].strAllergySytmptomsName!=undefined){
			alergypara+=data.strDrugAllergy[i].strAllergySytmptomsName+",";
			alergypara=alergypara.replace(";","");
		}
			
		if(data.strDrugAllergy[i].strAllergyRemarks!=undefined){
			alergypara+=data.strDrugAllergy[i].strAllergyRemarks+",";
			alergypara=alergypara.replace(";","");
		}

			
		if(alergypara!=""){
			alergypara= alergypara.replace(",","");
			alergypara="("+alergypara+")";
			alergypara=alergypara.replace(";","");					
		}
			
			
		$('#AllergyDtl').append("<li>"+allergyName+" "+alergypara+"</li>");
	}
}


function populateVisitSummary(data){
	var flagFound=false;
	$('#visitSummaryDtl').empty();
	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos!=null){
		$('#visitSummaryDtl').append("<p><b>Planned Visit Date : </b>"+data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos+"</p>");
		flagFound=true;
	}

	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays!=null){
		$('#visitSummaryDtl').append('<p>or After '+data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays+' Days</p>');
		flagFound=true;
	}

	if(data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate!='' && data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate!=null){
		$('#visitSummaryDtl').append('<p>'+'On '+data.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate+"</p>");
		flagFound=true;
	}
	if(data.FOLLOW_UP[0].progressNote !='' ){
		$('#visitSummaryDtl').append("<p><b>Clinical Notes :  </b>"+data.FOLLOW_UP[0].progressNote+"</p>");
		flagFound=true;
	}
}




function populateExternalReferal(data){

	$('#ExternalReffralListTable tbody').empty();
	var lenExternalConsultantReferalDtl= (data.externalConsultantReferalDtl==undefined?0: data.externalConsultantReferalDtl.length);
	var lenExternalInvestigationReferalDtl= (data.externalInvestigationReferalDtl==undefined?0: data.externalInvestigationReferalDtl.length);
	var lenexternalProcedureReferalDtl= (data.externalProcedureReferalDtl==undefined?0: data.externalProcedureReferalDtl.length); 
	var lenExternalFollowupReferalDtl= (data.externalFollowupReferalDtl==undefined?0: data.externalFollowupReferalDtl.length);
	
	if(lenExternalConsultantReferalDtl==0 && lenExternalInvestigationReferalDtl==0 && lenexternalProcedureReferalDtl==0 && lenExternalFollowupReferalDtl==0){
		$('#ExternalReffralListTable').remove();
		$('.ExternalReffralFooter').remove();
		$('#line3').remove();
	}
	var isExternalReferral=false;
	
	if(lenExternalConsultantReferalDtl>0){
		var str="<tr>";
		
		str+="<td colspan='2'><b>Refer Type Name : "+data.externalConsultantReferalDtl[0]["strreferralTypeName"]+"</b></td>";
		//str+="<td colspan='4' style='text-align:right'><b>Reference ID : "+data.externalConsultantReferalDtl[0]["refId"]+"</b></td>";		
		str+="</tr>";
		$('#ExternalReffralListTable tbody').append(str);

		$.each(data.externalConsultantReferalDtl, function(indx, refJson){

			//alert(JSON.stringify(refJson));
			var refType = (refJson["isAvailableInCGHS"] == 1) ? "I" : "O";
		//	console.log("strreferralTypeName ... >>>  > ",refJson["strreferralTypeName"] ,refType)
			
			var refId = data.externalConsultantReferalDtl[0]["refId"] +"/"+ data.externalConsultantReferalDtl[0]["strreferralTypeCode"];
			//console.log("refId ... >>>  > ",refId)
			var str="<tr>";

			str += "<td style='text-align:center;font-size:11px;'>" + refId + "/" + refJson["refSNO"] + "</td>";
			
			str+="<td>"+refJson["strReffralExtName"]+"</td>";
			str+="<td>"+refJson["refferalExtReson"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["validUpto"]+"</td>";
			str+="<td id='noAllowed' style='text-align:center;'>"+refJson["noAllowed"]+"</td>";
			str += "<td style='text-align:center;'>" + refType + "</td>";
			str+="</tr>";

		    // Check referral status
		    if (refJson["strReferralStatus"] == 2) {
		        isExternalReferral = true;
		    }



		    $('#ExternalReffralListTable tbody').append(str);
 		    if (refJson["strreferralTypeName"] === 'Consultation') {

		         $('#noAllowed').hide();
		     } 
		});

	}	


	if(lenExternalInvestigationReferalDtl>0){
		var str="<tr>";
		str+="<td colspan='2'><b>Refer Type Name : "+data.externalInvestigationReferalDtl[0]["strreferralTypeName"]+"</b></td>";
		//str+="<td colspan='4' style='text-align:right'><b>Reference ID : "+data.externalInvestigationReferalDtl[0]["refId"]+"</b></td>";		
		str+="</tr>";
		$('#ExternalReffralListTable tbody').append(str);

		$.each(data.externalInvestigationReferalDtl , function(indx, refJson){
			var refType = (refJson["isAvailableInCGHS"] == 1) ? "I" : "O";

			var refId = data.externalInvestigationReferalDtl[0]["refId"]+"/"+ data.externalInvestigationReferalDtl[0]["strreferralTypeCode"];
			console.log("refId ... >>>  > ",refId)
			var str="<tr>";

			str += "<td style='text-align:center;font-size: 11px;'>" + refId + "/" + refJson["refSNO"] + "</td>";
			//console.log("isAvailableInCGHS ... >>>  > ",refJson["isAvailableInCGHS"] ,refType)
			str+="<td>"+refJson["strReffralExtName"]+"</td>";
			str+="<td>"+refJson["refferalExtReson"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["validUpto"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["noAllowed"]+"</td>";
			str += "<td style='text-align:center;'>" + refType + "</td>";
			str+="</tr>";
			if(refJson["strReferralStatus"]==2)
				isExternalReferral=true;
			$('#ExternalReffralListTable tbody').append(str);
		});
	}	
	if(lenexternalProcedureReferalDtl>0){
		var str="<tr>";
		str+="<td colspan='2'><b>Refer Type Name : "+data.externalProcedureReferalDtl[0]["strreferralTypeName"]+"</b></td>";
		//str+="<td colspan='4' style='text-align:right'><b>Reference ID : "+data.externalProcedureReferalDtl[0]["refId"]+"</b></td>";		
		str+="</tr>";
		$('#ExternalReffralListTable tbody').append(str);

		$.each(data.externalProcedureReferalDtl , function(indx, refJson){

			var refType = (refJson["isAvailableInCGHS"] == 1) ? "I" : "O";
			var refId = data.externalProcedureReferalDtl[0]["refId"]+"/"+ data.externalProcedureReferalDtl[0]["strreferralTypeCode"];
			var str="<tr>";
			str += "<td style='text-align:center;font-size: 11px;'>" + refId + "/" + refJson["refSNO"] + "</td>";		
			str+="<td>"+refJson["strReffralExtName"]+"</td>";
			str+="<td>"+refJson["refferalExtReson"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["validUpto"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["noAllowed"]+"</td>";
			str += "<td style='text-align:center;'>" + refType + "</td>";
			str+="</tr>";
			if(refJson["strReferralStatus"]==2)
				isExternalReferral=true;
			$('#ExternalReffralListTable tbody').append(str);
		});
	}

	if(lenExternalFollowupReferalDtl>0){
		var str="<tr>";
		str+="<td colspan='2'><b>Refer Type Name : "+data.externalFollowupReferalDtl[0]["strreferralTypeName"]+"</b></td>";
		//str+="<td colspan='4' style='text-align:right'><b>Reference ID : "+data.externalFollowupReferalDtl[0]["refId"]+"</b></td>";		
		str+="</tr>";
		$('#ExternalReffralListTable tbody').append(str);

		$.each(data.externalFollowupReferalDtl , function(indx, refJson){
			var refType = (refJson["isAvailableInCGHS"] == 1) ? "I" : "O";
			//console.log("isAvailableInCGHS ... >>>  > ",refJson ,refType)
			var refId = data.externalFollowupReferalDtl[0]["refId"]+"/"+ data.externalFollowupReferalDtl[0]["strreferralTypeCode"];
			var str="<tr>";
			str += "<td style='text-align:center;font-size: 11px;'>" + refId + "/" + refJson["refSNO"] + "</td>";		
			str+="<td>"+refJson["strReffralExtName"]+"</td>";
			str+="<td>"+refJson["refferalExtReson"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["validUpto"]+"</td>";
			str+="<td style='text-align:center;'>"+refJson["noAllowed"]+"</td>";
			str += "<td style='text-align:center;'>" + refType + "</td>";
			str+="</tr>";
			if(refJson["strReferralStatus"]==2)
				isExternalReferral=true;
			$('#ExternalReffralListTable tbody').append(str);

		});
	}
	
	//alert("isExternalReferral>>" + isExternalReferral);
	if(isExternalReferral==false){
		$('.ExternalReffralFooter').remove();		
	}
	
	
}

function populateLabReport(data){
	$('#LabReportDtl').empty();
	if(data.labReportEntry==undefined || data.labReportEntry == ''){
		$('.LabReport').remove();
		return;
	}
	//alert(data.labReportEntry);
	$('#LabReportDtl').html(data.labReportEntry)	
}
function populateProxyDtl(data){
	$('#proxyDtl').empty();
	//alert(JSON.stringify(data));
	//alert(data["proxy_flag"]);
	if(data["proxy_flag"]=="1"){
		var str="";
		if(data["proxy_name"].trim()!="")
		 str+="Proxy Name : "+data["proxy_name"];
		if(data["proxy_contact"].trim()!="")
			str+="  Proxy Mobile No. : "+ data["proxy_contact"] ;
		if(data["proxy_relation"].trim()!="")
			str+=" Relation : "+ data["proxy_relation"]
		$('#proxyDtl').text(str);
	}
	else{
		$('.proxy').remove();
	}	
}


function populateDrugDtl(data)
{

	//alert( "populateDrugDtl::::" + JSON.stringify(data));
	$('#DrugListTable tbody').empty();
	//alert(JSON.stringify(data.DrugJsonArray));
	if(data.DrugJsonArray==undefined || data.DrugJsonArray.length==0){
		$('.Drug').remove();
		return;
	}	
	var isNormalDrugFound=false;
	//alert(data.DrugJsonArray.length);
	var sqNo=0;
	for(var i=0; i<data.DrugJsonArray.length; i++) { 
	    var drugJson = data.DrugJsonArray[i];
	    var html = "";
		if(isSeparateRestrictedMedicine==true && (drugJson["drugStatus"]=="1" || drugJson["drugStatus"]=="2"))
			continue;
		
		
	 	html += "<tr>";
	    html += "<td style='text-align:center'>" + (++sqNo) + "</td>";
	    html += "<td>" + drugJson["drugName"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugDosage"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugFrequency"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugDays"] + " Days</td>";

	    if(drugJson["drugDispenceStatusWiseQty"].length > 1){
	        html += "<td style='text-align:center' colspan='2'>";
	        html += "<table><thead>";
	        $.each(drugJson["drugDispenceStatusWiseQty"], function(sindx, stJson){
	            html += "<tr>";
	            html += "<td style='text-align:center'>" + stJson["status"] + "</td>";
	            html += "<td style='text-align:center'>" + stJson["statusQty"] + "</td>";				
	            html += "</tr>";	          
	        });
	        html += "</thead></table>";
	        html += "</td>";
	    } else {
	        var stJson = drugJson["drugDispenceStatusWiseQty"][0];
	        html += "<td style='text-align:center'>" + stJson["status"] + "</td>";
	        html += "<td style='text-align:center'>" + stJson["statusQty"] + "</td>";
	    }
	    html += "<td style='text-align:center'>" + drugJson["refferedBy"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugInstructions"] + "</td>";

		$('#DrugListTable tbody').append(html);
	 		   
		isNormalDrugFound=true
	    
	}
	
	if(isNormalDrugFound==false)
		$('.normalDrug').remove();
	
}

function populateRestrictedDrugDtl(data)
{

	
	$('#DrugRestricedListTable tbody').empty();
	if(data.DrugJsonArray==undefined || data.DrugJsonArray.length==0){
		$('#divDrugPrintable').remove();
		return;
	}	
	var isRestrictedFound=false;
	//alert(data.DrugJsonArray.length);
	var sqNo=0;
	for(var i=0; i<data.DrugJsonArray.length; i++) { 
	    var drugJson = data.DrugJsonArray[i];
	    var html = "";
		if(drugJson["drugStatus"]=="1" || drugJson["drugStatus"]=="2" ){// restricted/high value
	 	html += "<tr>";
	    html += "<td style='text-align:center'>" + (++sqNo) + "</td>";
	    html += "<td>" + drugJson["drugName"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugDosage"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugFrequency"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugDays"] + " Days</td>";

	    if(drugJson["drugDispenceStatusWiseQty"].length > 1){
	        html += "<td style='text-align:center' colspan='2'>";
	        html += "<table><thead>";
	        $.each(drugJson["drugDispenceStatusWiseQty"], function(sindx, stJson){
	            html += "<tr>";
	            html += "<td style='text-align:center'>" + stJson["status"] + "</td>";
	            html += "<td style='text-align:center'>" + stJson["statusQty"] + "</td>";				
	            html += "</tr>";	          
	        });
	        html += "</thead></table>";
	        html += "</td>";
	    } else {
	        var stJson = drugJson["drugDispenceStatusWiseQty"][0];
	        html += "<td style='text-align:center'>" + stJson["status"] + "</td>";
	        html += "<td style='text-align:center'>" + stJson["statusQty"] + "</td>";
	    }
	    html += "<td style='text-align:center'>" + drugJson["refferedBy"] + "</td>";
	    html += "<td style='text-align:center'>" + drugJson["drugInstructions"] + "</td>";

	   
	    
			isRestrictedFound=true;
		  	$('#DrugRestricedListTable tbody').append(html);
	    }
		
	    
	}
	//console.log('DrugRestricedListTable length>>' + $('#DrugRestricedListTable tbody').length);
	
	if(isRestrictedFound==false)
		$('#divDrugPrintable').remove();
	
}