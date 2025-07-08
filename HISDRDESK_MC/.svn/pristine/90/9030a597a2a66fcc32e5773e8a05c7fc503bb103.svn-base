function VitalSave(e){
	
	//console.log('Inside VaitalSave Method');
	//console.log($("#weightId").val());
	var patName = $(e).closest('.patientListBlock').find('.patName').text();
   
    var itrremks='';
	//console.log('patName'+patName);
	var weightId=$("#weightId").val();
	var heightId=$("#heightId").val();
	var bmiId=$("#bmiId").val();
	var temperatureId=$("#temperatureId").val();
	var respRateId=$("#respRateId").val();
	var haemoglobinId=$("#haemoglobinId").val();
	var diastolicId=$("#diastolicId").val();
	var systolicId=$("#systolicId").val();
	var fastingId=$("#fastingId").val();
	var ppRateId=$("#ppRateId").val();
	var hba1cId=$("#hba1cId").val();
	
	
	var deptId=$("#strPatientDtlId").val();
	var patdtlsId=$("#strPatHiddenDtlsId").val();
	if(patdtlsId==""){
		alert("Patient detail not found in vital. cannot save")
		return;
	}
		
	
	var bmiErrmsg=$("#bmiErrmsg").text();
	var temperatureErrmsg=$("#temperatureErrmsg").text();
	var respRateErrmsg=$("#respRateErrmsg").text();
	var haemoglobinErrmsg=$("#haemoglobinErrmsg").text();
	var bpErrmsg=$("#bpErrmsg").text();
	var fastingErrmsg=$("#fastingErrmsg").text();
	var ppRateErrmsg=$("#ppRateErrmsg").text();
	var hba1cErrmsg=$("#hba1cErrmsg").text();
	var pulseRateId=$("#pulseRateId").val() =='' ? '0' : $("#pulseRateId").val();
	var bloodGroupId=$("#bloodGroupId").val()=='' ? '0' : $("#bloodGroupId").val();
	/*##########   added for cancer screening   ##########*/
	//var cancerScreeningId=$("#cancerScreeningId").val()=='' ? '0' : $("#cancerScreeningId").val();
	//var cancerScreeningId = cancerScreeningId.replaceAll("\\[|\\]", "")
	var cancerScreeningId = $("#cancerScreeningId").val()=='' ? '0' :$("#cancerScreeningId").val().toString().replaceAll("[\\[\\]]", "").replaceAll("\"", "");
   			
	
	var Disability=$('input[name="Disability"]:checked').val();
	
	//console.log('DisabilityDisabilityDisabilityDisability   '+Disability);
	if(Disability == undefined){
		Disability='';	
	}
	
	//console.log('DisabilityDisabilityDisabilityDisability   '+Disability);
	
	var Smoking=$('input[name="Smoking"]:checked').val();
	if(Smoking == undefined){
		Smoking='';	
	}
	
	var alcoholConsumption=$('input[name="alcoholConsumption"]:checked').val();
	if(alcoholConsumption == undefined){
		alcoholConsumption='';	
	}
	
	var Anemic=$('input[name="Anemic"]:checked').val();
	
	if(Anemic == undefined){
		Anemic='';	
	}
	
	var Pregnancy="";
	var diastolicId1=$("#diastolicId1").val()=='' ? '0' : $("#diastolicId1").val();
	var systolicId1=$("#systolicId1").val()=='' ? '0' : $("#systolicId1").val();
	//console.log("bmiErrmsg::::::::::"+bmiErrmsg);
	var patGenAgeCat=$('#patAge').html();
	var curcumferenceId=$("#curcumferenceId").val()=='' ? '0' : $("#curcumferenceId").val();
	var muacId=$("#muacId").val()=='' ? '0' : $("#muacId").val(); 
	//console.log(patGenAgeCat);
	var isPregnant="";
	var lmp="";
	var edod="";
	var isHighRiskPregnancy="";
	
	if(patGenAgeCat.split('/')[0] == 'F'){
		if(document.getElementsByName("isPregnant")[0].checked==true){
			Pregnancy=$("#Pregnancy1").val() =='' ? '' : $("#Pregnancy1").val();
			lmp=$('#lmp').val();
			edod=$('#edod').val();
			isPregnant="Yes";
			isHighRiskPregnancy=$('[name=isHighRiskPregnancy]').val();
		}
		else{
			isPregnant="No";
		}
	}
	
	
	if(bmiErrmsg != '')
		itrremks +=bmiErrmsg+',' ;
	if(temperatureErrmsg != '')
		itrremks +=temperatureErrmsg+',' ;
	if(respRateErrmsg != '')
		itrremks +=respRateErrmsg+',' ;
	if(haemoglobinErrmsg != '')
		itrremks +=haemoglobinErrmsg+',' ;
	if(fastingErrmsg != '')
		itrremks +=fastingErrmsg+',' ;
	if(ppRateErrmsg != '')
		itrremks +=ppRateErrmsg+',' ;
	if(hba1cErrmsg != '')
		itrremks +=hba1cErrmsg+',' ;
	
	//itrremks=bmiErrmsg+',' +temperatureErrmsg+' ,'+respRateErrmsg+' ,'+haemoglobinErrmsg+' , '+bpErrmsg+' , '+fastingErrmsg+' '+ppRateErrmsg+ ' ,'+hba1cErrmsg ;
	
	//var symptomsId=$("#symptomsId").val().replace(",", " ")+ ',' + itrremks.replace(",", " ") ;
	var symptomsId=$("#symptomsId").val() ; //+ itrremks ;  //.replace(/,(?=[^,]*$)/, '')
	
	
	
	
	var vitalJSON = { 
			'strWeight' : weightId,
			'strHeight' : heightId,
			'strBmid' : bmiId,
			'strTempreature' : temperatureId,
			'strrespRate' : respRateId,
			'strdiastolic' : diastolicId,
			'strsystolic' : systolicId,
			'strsymptoms' : symptomsId,
			'strPatdtls' :patdtlsId,
			'strGeneral' :deptId , 
			'strbmiErrmsg' : bmiErrmsg,
			'strtemperatureErrmsg' : temperatureErrmsg,
			'strrespRateErrmsg' : respRateErrmsg,
			'strhaemoglobinErrmsg' : haemoglobinErrmsg,
			'strbpErrmsg' : bpErrmsg,
			'strfastingErrmsg' : fastingErrmsg,
			'strppRateErrmsg' : ppRateErrmsg,
			'strhba1cErrmsg' : hba1cErrmsg ,
			'strpulseRate' : pulseRateId , 
			'strbloodGroup' : bloodGroupId ,
			'strmuac'	:	muacId,
			'strcurcumference' :curcumferenceId ,
			'strDisability'	   :	Disability,
			'strSmoking'			: Smoking,
			'strAnemic'			:	Anemic ,
			'strPregnancy'			:Pregnancy ,
			'strdiastolic1' : 	diastolicId1,
			'strsystolic1' : 	systolicId1 ,
			'strcancerScreening' : cancerScreeningId ,
			'alcoholConsumption':alcoholConsumption,
			'isPregnant':isPregnant,
			'strfasting' : fastingId,
			'strRateId' : ppRateId,
			'strhba1c' : hba1cId,
			'stracbl':$('#acbl').val(),
			'strtgl':$('#tgl').val(),
			'strhdl':$('#hdl').val(),
			'strldl':$('#ldl').val(),
			'strCreatinine':$('#Creatinine').val(),
			'strUricAcid':$('#uricAcid').val(),
			'strtsh':$('#tsh').val(),
			'strt3':$('#t3').val(),
			'strt4':$('#t4').val(),
			'strhaemoglobin' : haemoglobinId,
			'stranyOtherReport':$('#anyOtherReport').val()
	};
	
	//var hrpdata= processVitalSerializeArray("divPregnancyInfo");
	////console.log("hrpdata====" +JSON.stringify(hrpdata));
	
	//alert("hrpdata====" +JSON.stringify(hrpdata));
	/*$.each(hrpdata, function(key,value){
		vitalJSON[key]=value;
		
	});*/
	
	//console.log("final vitalJSON ====" +JSON.stringify(vitalJSON));
	
	var data = JSON.stringify(vitalJSON); 
	//console.log(data); 
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveVital/',type:'POST',data:{JsonData:data},success:function(result)
    	{
			//console.log(result);
			
			if(result == 1)
				{
				//console.log("vital3");
				 $.alert({
				        title: 'Success!',
				        content: 'Data Saved successfully!!',
				    });
				 if( $("#strVitalModifyId").val() == 1){
				    createVitalDiv(vitalJSON)
				    createLabDiv(vitalJSON)
				    $("#weightId").val('');
					$("#heightId").val('');
					$("#bmiId").val('');
					$("#temperatureId").val('');
					$("#respRateId").val('');
					$("#haemoglobinId").val('');
					$("#diastolicId").val('');
					$("#systolicId").val('');
					$("#fastingId").val('');
					$("#ppRateId").val('');
					$("#hba1cId").val('');
					$("#symptomsId").val('');
					 $('#bmiErrmsg').text('');
					 $('#temperatureErrmsg').text('');
					 $('#bpErrmsg').text('');
					 $('#fastingErrmsg').text('');
					 $('#ppRateErrmsg').text('');
					 $('#hba1cErrmsg').text('');
					 $('#respRateErrmsg').text('');
					 $('#weightErrmsg').text('');
					 $('#heightErrmsg').text('');
					 $("#pulseRateId").val('');
					 $("#curcumferenceId").val('');
					 $("#muacId").val('');
					 $('#acbl').val("");
					 $('#tgl').val("");
					 $('#hdl').val("");
					 $('#ldl').val("");
					 $('#Creatinine').val("");
					 $('#uricAcid').val("");
					 $('#tsh').val("");
					 $('#t3').val("");
					 $('#t4').val("");
					 $('#anyOtherReport').val("");
				 }
				 $("#VitalIDModal").modal('hide');
				 if($('#isCalledFromListpage').val()=="1")
					 refreshPatientData(e);
				}else{
					//console.log('Error!!!');
					 $.alert({
					        title: 'Error!',
					        content: 'Unable to Save Data!!',
					    });
				}
    	}
	});
}


function ModifyVital(e)
{
	////console.log('Inside ModifyVital');
	
	$('#btnActonPrevVitalHide').click(function(){
		$('#btnActonPrevVitalShow').show();
		$('#btnActonPrevVitalPopulate').hide();
		$('#btnActonPrevVitalHide').hide();
		$('#divPrevVitalDtl').hide();		
	});
	$('#btnActonPrevVitalShow').click(function(){
		$('#btnActonPrevVitalShow').hide();
		$('#btnActonPrevVitalPopulate').show();
		$('#btnActonPrevVitalHide').show();
		$('#divPrevVitalDtl').show();		
	});
	$('#isCalledFromListpage').val("0");
	
	$('#btnActonPrevVitalPopulate').click(populateVitalJson);
	
	var CR_No = $('#patCrNoPrescriptionPanel').text();  
	var episodeCode = $('#patEpisodeCodePrescriptionPanel').text();
	var hospitalCode = $('#patHospitalCodePrescriptionPanel').text();
	var lastVisitDate = $('#patLastVisitDatePrescriptionPanel').text();
	var visitNo=$('#patEpisodeVisitNoPrescriptionPanel').text();
	var patname=$('#patNamePrescriptionPanel').text();
	var patGenAgeCat=$('#patGenAgeCatPrescriptionPanel').html();
	var seatId = $('#patSeatIdPrescriptionPanel').text();
	
	var vitalJSON = { 
			'CR_No' : CR_No,
			'episodeCode' : episodeCode,
			'hospitalCode' : hospitalCode,
			'visitNo' : visitNo,
			
	};
	var data = JSON.stringify(vitalJSON);
	$("#VitalIDModal").modal();
	
	
	
	var age=patGenAgeCat.split('/')[1];
	
	var arrAge= age.trim().split(" ");
	var flagShowPregnentOption=false;
	
	var agenumber= parseInt(arrAge[0])
	
	if(agenumber>=14 && agenumber<=70 && arrAge[1]!=undefined && arrAge[1]!="" && arrAge[1].toUpperCase()=="YR"){
		flagShowPregnentOption=true;
	}
	
	$("#PregnancyDivRadio").hide();	
	//console.log("1 . flagShowPregnentOption>>" + flagShowPregnentOption)
	
	//console.log("1 . gender>>" + patGenAgeCat.split('/')[0])
	
	if(patGenAgeCat.split('/')[0].trim()=='F' && flagShowPregnentOption){
		$("#PregnancyDivRadio").show();		
	}
	

	var age = (patGenAgeCat.split('/')[1]).replace('Yr','') ; 
			if(age.trim() <= '18')
			$("#curcumferenceIdDivId").show();
			else
			$("#curcumferenceIdDivId").hide();
			
			if(age.trim() <= '18')
				$("#muacDivId").show();
				else
				$("#muacDivId").hide();
			
	
	$("#patName").text(patname);
	$("#crNo").text(CR_No);
	$("#patAge").text(patGenAgeCat);
	$("#patGender").text('');

	getAllPreviousVitalDtls(CR_No,episodeCode,hospitalCode,visitNo);
	
	
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/ModifyVital/',type:'POST',data:{JsonData:data},success:function(result)
    	{ 
			if(result.status == 1  )
				{
				
				$("#strPatHiddenDtlsId").val(''+'^'+CR_No+'^'+episodeCode+'^'+visitNo+'^'+hospitalCode+'^'+''+'^'+''+'^'+seatId);
				 $("#strVitalModifyId").val('1');
				 
				 populateVitalForm(result.VitalDtls[0].VITAL_JSON_DATA);				
				
				}
    	}
	
	});
	
	/* $('#lmp').datepicker({
		 uiLibrary: 'bootstrap',
	     format: 'dd-mmm-yyyy',
	     container: "#VitalIDModal",
	     maxDate: function() {
	         var date = new Date();
	         date.setDate(date.getDate());
	         return new Date(date.getFullYear(), date.getMonth(), date.getDate());
	     },
	     icons: {
	         rightIcon: '<span class="glyphicon glyphicon-calendar"></span>'
	     },
	     showRightIcon: false,		     
	     change: function (e) {
	    	 //sessionStorage.setItem('selectedDate',$('#lmp').val().toString());
	    	 
	    	 var mydate = new Date($('#lmp').val());
	    	
	    	 
	    	 var numberOfDaysToAdd = 280;// 40 weeks
	    	 var result = mydate.setDate(mydate.getDate() + numberOfDaysToAdd);
	    	 var edodDt = ((new Date(result))+"").trim();
	    	 var arrEdod= edodDt.split(" ");		    	 
	    	 $('#edod').val(arrEdod[2]+"-"+arrEdod[1] + "-"+ arrEdod[3])
	    	 
	    	 
	    	 
	     }
	 });
	
	 
  	$('#edod').datepicker({
		 uiLibrary: 'bootstrap',
	     format: 'dd-mmm-yyyy',
	     container: "#VitalIDModal",
	     minDate: function() {
	         var date = new Date();
	         date.setDate(date.getDate());
	         return new Date(date.getFullYear(), date.getMonth(), date.getDate());
	     },
	     icons: {
	         rightIcon: '<span class="glyphicon glyphicon-calendar"></span>'
	     },
	     showRightIcon: false,		     
	     change: function (e) {
	    	 //sessionStorage.setItem('selectedDate',$('#listDateFilter').val().toString());
	     }
	 }); */
	
  	$('[name=isPregnant]').change(function(){
  		$('#divPregnancyInfo').hide();
  		if(this.checked==true && this.value=='Yes'){
  			$('#divPregnancyInfo').show();      			
  		}  
		 if(validateHighRiskPregnancy()){
			$('#isHighRiskPregnancyYes').prop("checked", true);
			$('#alertdivHRP').show();
		 }
		 else{
			$('#isHighRiskPregnancyNo').prop("checked", true);
			$('#alertdivHRP').hide();
		 }
  	});
  	
  
  	
  	$("#gestationalAge").keypress(function (e) {
     	var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#gestationalAgeErrorMessage").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
  	});
  	 
  	 $('.hrpcheckfield').blur(function(){
  		 if(validateHighRiskPregnancy()){
  			$('#isHighRiskPregnancyYes').prop("checked", true);
  			$('#alertdivHRP').show();
  		 }
  		else{
  			$('#isHighRiskPregnancyNo').prop("checked", true);
 			$('#alertdivHRP').hide();
  		 }
  	 });
  	 $('#isHighRiskPregnancyNo').click(function(){
  		$('#alertdivHRP').hide();
  	 })
  	 $('.hrpCheckbox, .hrpRadio').click(function(){
  		 if(validateHighRiskPregnancy()){
 			$('#isHighRiskPregnancyYes').prop("checked", true);
 			$('#alertdivHRP').show();
 		 }
  		 else{
  			$('#isHighRiskPregnancyNo').prop("checked", true);
 			$('#alertdivHRP').hide();
  		 }
  	 }); 
	
}

function processVitalSerializeArray(divId){
	var inputjson=$('#'+divId +' :input').serializeArray();
	var finalJson={}; 
	$.each(inputjson,function(k,vobj){
		var key=vobj["name"];
		var value=vobj["value"];
		if(value.trim()=="")
			return;
		if(finalJson[key]==undefined){
		
			finalJson[key]=value;
		}
		else{
			
			var arrVal=new Array();
			//alert(arrVal.length);
			
			 if(Array.isArray(finalJson[key])){
				
				 arrVal=finalJson[key];
			 }
			 if(arrVal.length==0){
				 arrVal.push(finalJson[key]);
				
			}
			 
			
			 arrVal.push(value);
			 finalJson[key]=arrVal;
		}
	});
	//alert(JSON.stringify(finalJson));
	return finalJson
}