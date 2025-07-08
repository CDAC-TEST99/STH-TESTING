function openModalForVital(e){
		//alert("openModalForVital>>>");
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
		$('#isCalledFromListpage').val("1");
		$('#btnActonPrevVitalPopulate').click(populateVitalJson);
			
		
		$("#VitalIDModal").modal()  ;
		$("#strVitalModifyId").val('0');
		var patName = $(e).closest('.patientListBlock').find('.patName').text();
		var patCrNo = $(e).closest('.patientListBlock').find('.patCrNo').text();
		var patEpisodeVisitNo = $(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text();
		var patLastVisitDate = $(e).closest('.patientListBlock').find('.patLastVisitDate').text()==='' ? 'First Visit' : $(e).closest('.patientListBlock').find('.patLastVisitDate').text(); //Changed By Timsi Kataria as suggested by Priyesh Sir
		var patVisitType = $(e).closest('.patientListBlock').find('.patVisitType').text();
		var patGaurdianName = $(e).closest('.patientListBlock').find('.patGaurdianName').text(); 
		var patDeptName = $(e).closest('.patientListBlock').find('.patDeptUnit').text();
		var nextPatName = $(e).closest('.patientListBlock').next().find('.patName').text(); 
		var prevPatName = $(e).closest('.patientListBlock').prev().find('.patName').text();
		var patGenAgeCat = $(e).closest('.patientListBlock').find('.patGenAgeCat').text();
		var episodeCode = $(e).closest('.patientListBlock').find('.patEpisodeCode').text();
		var hospitalCode = $(e).closest('.patientListBlock').find('.patHospitalCode').text();
		var seatId = $(e).closest('.patientListBlock').find('.patSeatId').text(); 
		var patConsultantName = $(e).closest('.patientListBlock').find('.patConsultantName').text();  
		var patCompleteGeneralDtl = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl]').val();
		$("#patName").text(patName);
		$("#crNo").text(patCrNo);
		$("#patAge").text(patGenAgeCat);
		$("#patGender").text('');
		$("#strPatientDtlId").val(patCompleteGeneralDtl);
		
		var age=patGenAgeCat.split('/')[1];
		
		var arrAge= age.trim().split(" ");
		var flagShowPregnentOption=false;
		
		var agenumber= parseInt(arrAge[0])
		
		//alert(agenumber);
	//	alert(arrAge[1]);
		if(agenumber>=14 && agenumber<=70 && arrAge[1]!=undefined && arrAge[1]!="" && arrAge[1].toUpperCase()=="YR"){
			flagShowPregnentOption=true;
		}
		
		
		$("#PregnancyDivRadio").hide();
		
		console.log("2 . flagShowPregnentOption>>" + flagShowPregnentOption)
		
		console.log("2 . gender>>" + patGenAgeCat.split('/')[0])
		
		
		
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
		
		$("#strPatHiddenDtlsId").val(patName.trim()+'^'+patCrNo+'^'+episodeCode+'^'+patEpisodeVisitNo+'^'+hospitalCode+'^'+patLastVisitDate+'^'+patVisitType+'^'+seatId);
		//var str ='<b style="color:#015CB9;"><span id="patName">Patient Name:'+patName+' </span> / <span id="crNo">CR Number:'+patCrNo+'</span> / <span id="patAge">Age:'+patGenAgeCat+'</span> / <span id="patGender">Male</span></b>';
		console.log('patCompleteGeneralDtl=='+patCompleteGeneralDtl);
      	console.log('crNo=='+patCrNo);
      	console.log('patGenAgeCat'+patGenAgeCat);
      	console.log('patEpisodeVisitNo'+patEpisodeVisitNo);
      	//alert("here")
      	getAllPreviousVitalDtls(patCrNo,episodeCode,hospitalCode,patEpisodeVisitNo);
      	var vitalJSON = { 
    			'CR_No' : patCrNo,
    			'episodeCode' : episodeCode,
    			'hospitalCode' : hospitalCode,
    			'visitNo' : patEpisodeVisitNo
    	};
      	
      	var data = JSON.stringify(vitalJSON);
      	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/ModifyVital/',type:'POST',data:{JsonData:data},success:function(result)
        	{
    			console.log(result);
    			console.log(result.status);
    			console.log("vital json >>>>" + result.VitalDtls);
    			
    			if(result.status == 1)
    				{
    				
    				/* $.alert({
    				        title: 'Success!',
    				        content: 'Data Saved successfully!!',
    				    });
    				 */
    				 
    				 console.log("vital2");
    				 if((result.VitalDtls).length > 0 ){
    					 
    					 	populateVitalForm(result.VitalDtls[0].VITAL_JSON_DATA);
    						
    						 $("#strPatHiddenDtlsId").val(''+'^'+CR_No+'^'+episodeCode+'^'+visitNo+'^'+hospitalCode+'^'+''+'^'+''+'^'+'10');
    						 $("#strVitalModifyId").val('1');
    				 
    				 }else{
    					 console.log('Error!!!');
    					// $("#strVitalModifyId").val('1');
    					 //$("#strPatHiddenDtlsId").val(''+'^'+CR_No+'^'+episodeCode+'^'+visitNo+'^'+hospitalCode+'^'+''+'^'+''+'^'+'10');
    					 /*$.alert({
    					        title: 'No Record!',
    					        content: 'Data No Avilable',
    					    });*/
    					 
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
						 $("#bloodGroupId").val('0');
						 $("#cancerScreeningId").val('0');/*----------------------added for cancer screening---------------*/
    					 
    				 }
    				 	
    				}else{
    					console.log('Error!!!');
    					 $.alert({
    					        title: 'Error!',
    					        content: 'Unable to Get Prev Data!!',
    					    });
    				}
        	}
    	});
      	
      	
      	 $('#lmp').datepicker({
    		 uiLibrary: 'bootstrap',
		     format: 'dd-mmm-yyyy',
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
		 }); 
      	$('[name=isPregnant]').change(function(){
      		$('#divPregnancyInfo').hide();
      		/*if(this.checked==true && this.value=='Yes'){
      			$('#divPregnancyInfo').show();      			
      		}
      		validateHighRiskPregnancy();*/
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
      	 })
      	 
      	 
      	
	
}


var count=0;
	$(document).ready(function(){

		$('.allergiesAddRows').click(function(){
			count++;
			var allergyName=$(this).parent().parent().find('input[name="allergyName"]').val();
			var siteName=$(this).parent().parent().find('select[name="site"] option:selected').text();
			var duration=$(this).parent().parent().find('input[name="noOfDays"]').val();
			var durationCombo=$(this).parent().parent().find('select[name="duration"] option:selected').text();
			var otherInfo=$(this).parent().parent().find('input[name="otherInfo"]').val();
		//alert(allergyName+"  "+siteName+"  "+duration+"   "+durationCombo+"   "+otherInfo);
		if(allergyName.trim()!='' && siteName.trim()!='' && duration.trim()!='' && durationCombo.trim()!='' && otherInfo.trim()!=''){
			str='<div class="row"  id="rowId'+count+'">'+
			'<div class="form-group col-md-3 alignLeftPaddingLeftZero">'+
				'<input type="text" class="form-control" value="'+allergyName+'" name="allergyName" readonly id="allergyNameId'+count+'">'+
			'</div>'+
			'<div class="form-group col-md-2 alignLeftPaddingLeftZero">'+
				'<input type="text" class="form-control" value="'+siteName+'" name="site" readonly id="siteId'+count+'">'+
			'</div>'+
			'<div class="form-group col-md-4 alignLeftPaddingLeftZero">'+
				'<div class="col-md-6">'+
					'<input type="text" class="form-control" value="'+duration+'" name="noOfDays" readonly id="noOfDaysId'+count+'">'+
				'</div>'+
				'<div class="col-md-6 alignLeftPaddingLeftZero">'+
					'<input type="text" class="form-control" value="'+durationCombo+'" name="duration" readonly id="durationId'+count+'">'+
				'</select>'+
				'</div>'+
			'</div>'+
			'<div class="form-group col-md-2 alignLeftPaddingLeftZero">'+
				'<input type="text" class="form-control" value="'+otherInfo+'" name="otherInfo" readonly id="otherInfoId'+count+'">'+
			'</div>'+
			'<div class="form-group col-md-1">'+
				'<button class="btn btn-sm btn-danger allergiesRemoveRow" onclick="$(this).parent().parent().remove();" id="removeBtnId'+count+'">Remove</button>'+
			'</div>'+
			'</div>';
			$(this).closest('.addAllergyNewRowClass').append(str);
			$(this).parent().parent().find('input[name="allergyName"]').val('');
				$(this).parent().parent().find('input[name="noOfDays"]').val('');
				$(this).parent().parent().find('input[name="otherInfo"]').val('');
		}
		else{
			alert("Please fill all the fields.");
		}
		
	});

	/*$('.allergiesRemoveRow').click(function(){
		alert("yruyh");
		$(this).parent().parent().remove();
	});*/

	$("#heightId").keypress(function (e) {
     	var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#heightId").css("border-color","red");
     		$("#heightId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#heightErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#heightId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}

		$("#heightId").css("border-color","");
     	$("#heightId").css("box-shadow", "");
     	var weight=$("#weightId").val();
     	var height=$("#heightId").val();
     	if(height == ''){
     		$("#bmiId").val('');
     	}
     	if(parseFloat(height) > 250.00){
     		$("#heightErrmsg").html("Height cannot exceed 250cms.").show();
     		$("#heightId").val('');
     	}
     	if(parseFloat(height) == 0){
     		$("#heightErrmsg").html("Ht. can't be 0.").show();
     		$("#heightId").val('');
     		$("#bmiId").val('');
     	}
     	else if(parseFloat(height) > 250){
     		$("#heightErrmsg").html("Not Allowed").show();
     		$("#heightId").val('');
     	}
     	else{
     		$("#heightErrmsg").html("");
     	}

     	if(weight!='' && height!='' && weight!='0.00' && height!='0.00'){    // weight!='0.00' && height!='0.00' check added by ashutoshk
     		var temp=parseFloat(parseFloat(height)/100);
     		var bmi=parseFloat(weight)/(temp*temp);

     		if(bmi > 30){
     			$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Obese").show();
				$('input[name="bmiErrMsgTxt"]').val('Obese');
		        return false;
			}
			else if(bmi < 18.5 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Underweight.").show();
				$('input[name="bmiErrMsgTxt"]').val('Underweight');
		        return false;
			}
			else if(bmi >= 18.5 && bmi <= 24.9 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Normal").show();
				$('input[name="bmiErrMsgTxt"]').val('Normal');
		        return false;
			}
			else if(bmi >= 25.0 && bmi <= 29.9 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Overweight").show();
				$('input[name="bmiErrMsgTxt"]').val('Overweight');
		        return false;
			}
			else{
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("");
			}
     	}
	});

	$("#weightId").keypress(function (e) {
     	var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#weightId").css("border-color","red");
     		$("#weightId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#weightErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#weightId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		$("#weightId").css("border-color","");
     	$("#weightId").css("box-shadow", "");

     	var weight=$("#weightId").val();
     	var height=$("#heightId").val();
     	//alert('weight:: '+weight);
     	//alert('height ::'+height+' --- '+ height!='0.00');
     	
     	if(weight == ''){
     		$("#bmiId").val('');
     	}
     	/*if(parseFloat(weight) > 200.00){
     		$("#weightErrmsg").html("Weight cannot exceed 200kgs.").show();
     		$("#weightId").val('');
     	}*/
     	if(parseFloat(weight) ==0){
     		$("#weightErrmsg").html("Wt. can't be 0.").show();
     		$("#weightId").val('');
     		$("#bmiId").val('');
     	}
     	else if(parseFloat(weight) > 200){
     		$("#weightErrmsg").html("Not Allowed").show();
     		$("#weightId").val('');
     	}
     	else{
     		$("#weightErrmsg").html("");
     	}

     	if(weight!='' && height!='' && height!='0.00' && weight!='0.00'){ 			// weight!='0.00' && height!='0.00' check added by ashutoshk
     		var temp=parseFloat(parseFloat(height)/100);
     		var bmi=parseFloat(weight)/(temp*temp);

     		if(bmi > 30 ){
     			$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Obese").show();
				$('input[name="bmiErrMsgTxt"]').val('Obese');
		        return false;
			}
			else if(bmi < 18.5 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Underweight.").show();
				$('input[name="bmiErrMsgTxt"]').val('Underweight');
		        return false;
			}
			else if(bmi >= 18.5 && bmi <= 24.9 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Normal").show();
				$('input[name="bmiErrMsgTxt"]').val('Normal');
		        return false;
			}
			else if(bmi >= 25.0 && bmi <= 29.9 ){
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("Overweight").show();
				$('input[name="bmiErrMsgTxt"]').val('Overweight');
		        return false;
			}
			else{
				$("#bmiId").val(bmi.toFixed(2));
				$("#bmiErrmsg").html("");
			}
     	}
	});
	
	$("#respRateId").keypress(function (e) {
     	if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
     		$("#respRateId").css("border-color","red");
     		$("#respRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#respRateErrmsg").html("Digits Only").show().fadeOut("slow");
	        return false;
    	}
    	else{
    		$("#respRateId").css("border-color","");
     		$("#respRateId").css("box-shadow", "");
     		return true;
    	}
    });
	
	$("#respRateId").blur(function(){
		if(parseFloat($("#respRateId").val())<1 || parseFloat($("#temperatureId").val())>99){
	        $("#respRateErrmsg").html('Alert! Please Check').show();
     		return false;
		}
	});
	
	
	
	$("#respRateId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=$("#respRateId").val();
		
		if(parseFloat(temp)== 0){
     		$("#respRateErrmsg").html("Respiratory Rate cannot be 0.").show();
     		$("#respRateId").val('');
     	}
		else if(temp > 1 && temp < 9){
			//$("#respRateId").css("border-color","red");
     		//$("#respRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#respRateErrmsg").html("Low RR").show();
	        $('input[name="respRateErrMsgTxt"]').val('Low RR');
	        return false;
		}
		else if(temp > 20){
			//$("#respRateId").css("border-color","red");
     		//$("#respRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#respRateErrmsg").html("High RR").show();
	        $('input[name="respRateErrMsgTxt"]').val('High RR');
	        return false;
		}
		else{
			$("#respRateId").css("border-color","");
     		$("#respRateId").css("box-shadow", "");
     		$("#respRateErrmsg").html("");
     		$('input[name="respRateErrMsgTxt"]').val('Normal');
     		return true;
		}
	});
	
	
	
	
	
	
	$("#pulseRateId").blur(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=$("#pulseRateId").val();
		
		if(parseFloat(temp)== 0){
     		$("#pulseRateErrmsg").html("Pulse Rate cannot be 0.").show();
     		$("#respRateId").val('');
     	}
		else if(parseFloat($("#pulseRateErrmsg").val())<1 || parseFloat($("#pulseRateErrmsg").val())>400){
	        $("#pulseRateErrmsg").html('Alert! Please Check').show();
     		return false;
		}
		else if(temp!=''&& temp <60){
		    $("#pulseRateErrmsg").html("Please Check! Bradycardia").show();	        
	        return false;
		}
		else if(temp!='' && temp > 100){
			  $("#pulseRateErrmsg").html("Please Check! Tachycardia").show();	        
		        return false;
		}
		else{
			$("#pulseRateId").css("border-color","");
     		$("#pulseRateId").css("box-shadow", "");
     		$("#pulseRateErrmsg").html("");
     		$('input[name="pulseRateErrmsg"]').val('Normal');
     		return true;
		}
	});
	
	
	
	

	$("#bmiId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57)){
	    	$("#bmiId").css("border-color","red");
     		$("#bmiId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#bmiErrmsg").html("Values Not Allowed. Enter weight and height values to calculate BMI.").show().fadeOut("slow");
	        return false;
	   	}
    	else{
    		$("#bmiId").css("border-color","");
     		$("#bmiId").css("box-shadow", "");
     		return true;
    	}
    });
	$("#bmiId").keyup(function(){
		$("#bmiId").css("border-color","");
     	$("#bmiId").css("box-shadow", "");
	});
	
	$("#haemoglobinId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#haemoglobinId").css("border-color","red");
     		$("#haemoglobinId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#haemoglobinErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#haemoglobinId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		window.patGender = $('#patAge').text().charAt(0).toUpperCase().split('/')[0];
		var temp = $("#haemoglobinId").val();

		if(window.patGender == 'F'){
			if(parseFloat(temp)==0){	
		        $("#haemoglobinErrmsg").html("Hgb. cannot be 0.").show();
		        $("#haemoglobinId").val('');
			}
			else if(parseFloat(temp) > 0 && parseFloat(temp) < 12.0){
				//$("#haemoglobinId").css("border-color","red");
	     		//$("#haemoglobinId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#haemoglobinErrmsg").html("Low Hgb").show();
		        $('input[name="haemoglobinErrMsgTxt"]').val('Low Hgb');
		        return false;
			}
			else if(parseFloat(temp) > 15.5){
				//$("#haemoglobinId").css("border-color","red");
	     		//$("#haemoglobinId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#haemoglobinErrmsg").html("High Hgb").show();
		        $('input[name="haemoglobinErrMsgTxt"]').val('High Hgb');
		        return false;
			}
			else{
				$("#haemoglobinId").css("border-color","");
     			$("#haemoglobinId").css("box-shadow", "");
     			$("#haemoglobinErrmsg").html("");
     			$('input[name="haemoglobinErrMsgTxt"]').val('Normal');
     			return true;
			}
		}
		else if(window.patGender == 'M'){
			if(parseFloat(temp)==0){	
		        $("#haemoglobinErrmsg").html("Hgb. cannot be 0.").show();
		        $("#haemoglobinId").val('');
			}
			else if(parseFloat(temp) < 13.5){
				//$("#haemoglobinId").css("border-color","red");
	     		//$("#haemoglobinId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#haemoglobinErrmsg").html("Low Hgb").show();
		        $('input[name="haemoglobinErrMsgTxt"]').val('Low Hgb');
		        return false;
			}
			else if(parseFloat(temp) > 17.5){
				//$("#haemoglobinId").css("border-color","red");
	     		//$("#haemoglobinId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#haemoglobinErrmsg").html("High Hgb").show();
		        $('input[name="haemoglobinErrMsgTxt"]').val('High Hgb');
		        return false;
			}
			else{
				$("#haemoglobinId").css("border-color","");
     			$("#haemoglobinId").css("box-shadow", "");
     			$("#haemoglobinErrmsg").html("");
     			$('input[name="haemoglobinErrMsgTxt"]').val('Normal');
     			return true;
			}
		}
	});
	
	
	$("#curcumferenceId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#curcumferenceId").css("border-color","red");
     		$("#curcumferenceId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#curcumferenceErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	
	
	$("#muacId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#muacId").css("border-color","red");
     		$("#muacId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#muacErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	
	$("#temperatureId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#temperatureId").css("border-color","red");
     		$("#temperatureId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	        
	        $("#temperatureErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }
	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#temperatureId").blur(function(){
		if(parseFloat($("#temperatureId").val())<90 || parseFloat($("#temperatureId").val())>110){
	        $("#temperatureErrmsg").html('Invalid input').show();	        
     		$("#temperatureId").val('');     		
     		return false;
		}
	});
	$("#temperatureId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		if(parseFloat($("#temperatureId").val())==0){	
	        $("#temperatureErrmsg").html("Not Allowed").show();
	        $("#temperatureId").val('');
		}	
		else if(parseFloat($("#temperatureId").val())<90 || parseFloat($("#temperatureId").val())>110){
	        $("#temperatureErrmsg").html('Invalid input').show();
     	
		}else if(parseFloat($("#temperatureId").val())<95){
	        $("#temperatureErrmsg").val('');
	        $('input[name="temperatureErrMsgTxt"]').val('Hypothermia');
		}
		else if(parseFloat($("#temperatureId").val()) >= 100.9 && parseFloat($("#temperatureId").val())<104){
			$("#temperatureErrmsg").html("High Fever").show();
        	$('input[name="temperatureErrMsgTxt"]').val('High Fever');
		}
		else if(parseFloat($("#temperatureId").val()) >=104){				
        	$("#temperatureErrmsg").html("Hyperthermia/High Fever").show();
        	$('input[name="temperatureErrMsgTxt"]').val('Hyperthermia/High Fever');
		}		
		else{
			$("#temperatureId").css("border-color","");
	     	$("#temperatureId").css("box-shadow", "");
	     	$("#temperatureErrmsg").html("");
	     	$('input[name="temperatureErrMsgTxt"]').val('Normal');
	     	return true;
	    }
	});
	
	
	
	$("#diastolicId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#diastolicId").css("border-color","red");
     		$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#bpErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	/*$("#diastolicId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=parseFloat($("#diastolicId").val());
		var x=$("#systolicId").val();
		var temp1;
		if(x == ''){
			temp1 = NaN;
		}
		else{
			temp1=parseFloat(x);
		}
		if(temp != NaN && temp1 != NaN){
			if((temp <= 60) && (temp1 <= 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Low BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Low BP');
		        return false;
			}
			if((temp <= 60) && (temp1 > 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 90 && temp1 <= 120)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage2');
		        return false;
			}
			else if(temp > 90 && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage2');
		        return false;
			}
			else if(temp == 0){
				$("#bpErrmsg").html("Diastolic cannot be 0.").show();
				$("#diastolicId").val('');
			}
			else{
				$("#diastolicId").css("border-color","");
		     	$("#diastolicId").css("box-shadow", "");
		     	$("#bpErrmsg").html("");
		     	$('input[name="bpErrMsgTxt"]').val('Normal');
		     	return true;
			}
		}				
	});
*/
	
	/*$("#diastolicId1").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=parseFloat($("#diastolicId1").val());
		var x=$("#systolicId1").val();
		var temp1;
		if(x == ''){
			temp1 = NaN;
		}
		else{
			temp1=parseFloat(x);
		}
		if(temp != NaN && temp1 != NaN){
			if((temp <= 60) && (temp1 <= 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Low BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Low BP');
		        return false;
			}
			if((temp <= 60) && (temp1 > 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 90 && temp1 <= 120)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage2');
		        return false;
			}
			else if(temp > 90 && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage2');
		        return false;
			}
			else if(temp == 0){
				$("#bpErrmsg").html("Diastolic cannot be 0.").show();
				$("#diastolicId").val('');
			}
			else{
				$("#diastolicId").css("border-color","");
		     	$("#diastolicId").css("box-shadow", "");
		     	$("#bpErrmsg").html("");
		     	$('input[name="bpErrMsgTxt"]').val('Normal');
		     	return true;
			}
		}				
	});*/

	
	$("#systolicId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#systolicId").css("border-color","red");
     		$("#systolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#bpErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	
	
	$("#systolicId").blur(function () {
		validateBP();
	});
	$("#diastolicId1").keyup(function(){
		validateBP();
	});
	
	/*$("#systolicId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp1=parseFloat($("#systolicId").val());
		var x=$("#diastolicId").val();
		var temp;
		if(x == ''){
			temp = NaN;
		}
		else{
			temp=parseFloat(x);
		}
		if(temp != NaN && temp1 != NaN){
			if((temp1 <1) && (temp1 <= 400)){
			    $("#bpErrmsg").html("Invalid Value").show();
		        $('input[name="bpErrMsgTxt"]').val('Invalid Value');
		        return false;
			}
			
			if((temp <= 60) && (temp1 <= 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Low BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Low BP');
		        return false;
			}
			if((temp <= 60) && (temp1 > 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 90 && temp1 <= 120)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 2');
		        return false;
			}
			else if(temp > 90 && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 2');
		        return false;
			}
			else if(temp1==0){	
		        $("#bpErrmsg").html("Systolic cannot be 0.").show();
		        $("#systolicId").val('');
			}
			else{
				$("#diastolicId").css("border-color","");
		     	$("#diastolicId").css("box-shadow", "");
		     	$("#bpErrmsg").html("");
		     	$('input[name="bpErrMsgTxt"]').val('Normal');
		     	return true;
			}
		}
	});

	$("#systolicId1").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp1=parseFloat($("#systolicId1").val());
		var x=$("#diastolicId1").val();
		var temp;
		if(x == ''){
			temp = NaN;
		}
		else{
			temp=parseFloat(x);
		}
		if(temp != NaN && temp1 != NaN){
			if((temp <= 60) && (temp1 <= 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Low BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Low BP');
		        return false;
			}
			if((temp <= 60) && (temp1 > 90)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 90 && temp1 <= 120)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Ideal BP").show();
		        $('input[name="bpErrMsgTxt"]').val('Ideal BP');
		        return false;
			}
			else if((temp > 60 && temp <= 80) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && (temp1 > 120 && temp1 <= 140)){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 1").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 1');
		        return false;
			}
			else if((temp > 80 && temp <= 90) && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 2');
		        return false;
			}
			else if(temp > 90 && temp1 > 140){
				//$("#diastolicId").css("border-color","red");
	     		//$("#diastolicId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
		        $("#bpErrmsg").html("Hypertension Stage 2").show();
		        $('input[name="bpErrMsgTxt"]').val('Hypertension Stage 2');
		        return false;
			}
			else if(temp1==0){	
		        $("#bpErrmsg").html("Systolic cannot be 0.").show();
		        $("#systolicId").val('');
			}
			else{
				$("#diastolicId").css("border-color","");
		     	$("#diastolicId").css("box-shadow", "");
		     	$("#bpErrmsg").html("");
		     	$('input[name="bpErrMsgTxt"]').val('Normal');
		     	return true;
			}
		}
	});*/

	

	
	$("#fastingId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#fastingId").css("border-color","red");
     		$("#fastingId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#fastingErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#fastingId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=parseFloat($("#fastingId").val());

		if(temp==0){	
	        $("#fastingErrmsg").html("Blood Sugar Fasting cannot be 0.").show();
	        $("#fastingErrmsg").val('');
	        $("#fastingId").val('');
		}
		else if(temp < 70){
			//$("#fastingId").css("border-color","red");
     		//$("#fastingId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#fastingErrmsg").html("Low Sugar").show();
	        $('input[name="fastingErrMsgTxt"]').val('Low Sugar');
	        return false;
		}
		else if(temp >= 101 && temp < 125){
			//$("#fastingId").css("border-color","red");
     		//$("#fastingId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#fastingErrmsg").html("Pre Diabetes").show();
	        $('input[name="fastingErrMsgTxt"]').val('Pre Diabetes');
	        return false;
		}
		else if(temp >= 125){
			//$("#fastingId").css("border-color","red");
     		//$("#fastingId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#fastingErrmsg").html("HighDiabetes").show();
	        $('input[name="fastingErrMsgTxt"]').val('HighDiabetes');
	        return false;
		} 
		else{
			$("#fastingId").css("border-color","");
     		$("#fastingId").css("box-shadow", "");
     		$("#fastingErrmsg").html("");
     		$('input[name="fastingErrMsgTxt"]').val('Normal');
     		return true;
		}
	});

	$("#ppRateId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#ppRateId").css("border-color","red");
     		$("#ppRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#ppRateErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#ppRateId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=parseFloat($("#ppRateId").val());

		if(temp==0){	
	        $("#ppRateErrmsg").html("PP Blood Sugar Value cannot be 0.").show();
	        $("#ppRateErrmsg").val('');
	        $("#ppRateId").val('');
		}
		else if(temp < 70){
			//$("#ppRateId").css("border-color","red");
     		//$("#ppRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#ppRateErrmsg").html("Low Sugar").show();
	        $('input[name="ppRateErrMsgTxt"]').val('Low Sugar');
	        return false;
		}
		else if(temp >= 141 && temp < 200){
			//$("#ppRateId").css("border-color","red");
     		//$("#ppRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#ppRateErrmsg").html("PreDiabetes").show();
	        $('input[name="ppRateErrMsgTxt"]').val('PreDiabetes');
	        return false;
		}
		else if(temp >= 200){
			//$("#ppRateId").css("border-color","red");
     		//$("#ppRateId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#ppRateErrmsg").html("HighDiabetes").show();
	        $('input[name="ppRateErrMsgTxt"]').val('HighDiabetes');
	        return false;
		} 
		else{
			$("#ppRateId").css("border-color","");
     		$("#ppRateId").css("box-shadow", "");
     		$("#ppRateErrmsg").html("");
     		$('input[name="ppRateErrMsgTxt"]').val('Normal');
     		return true;
		}
	});

	$("#hba1cId").keypress(function (e) {
		var self = $(this);
	   	self.val(self.val().replace(/[^0-9\.]/g, ''));
	   	if ((e.which != 46 || self.val().indexOf('.') != -1) && (e.which < 48 || e.which > 57) &&
		       (e.which != 0 && e.which != 8)){
     		$("#hba1cId").css("border-color","red");
     		$("#hba1cId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#hba1cErrmsg").html("Numbers Only").show().fadeOut("slow");
	        return false;
    	}
    	var text = $(this).val();
	    if ((e.which == 46) && (text.indexOf('.') == -1)) {
	        setTimeout(function() {
	            if ($this.val().substring($this.val().indexOf('.')).length > 3) {
	                $this.val($this.val().substring(0, $this.val().indexOf('.') + 3));
	            }
	        }, 1);
	    }

	    if ((text.indexOf('.') != -1) &&
	        (text.substring(text.indexOf('.')).length > 2) &&
	        (e.which != 0 && e.which != 8) &&
	        ($(this)[0].selectionStart >= text.length - 2)) {
	            event.preventDefault();
	    }
    });
	$("#hba1cId").keyup(function(){
		if($(this).val().replace(/^(0+)/g, '')){
			$(this).val($(this).val().replace(/^(0+)/g, ''));
		}
		var temp=parseFloat($("#hba1cId").val());

		if(temp==0){	
	        $("#hba1cErrmsg").html("HBA1C Value cannot be 0.").show();
	        $("#hba1cErrmsg").val('');
	        $("#hba1cId").val('');
		}
		else if(temp >= 5.7 && temp <= 6.4){
			//$("#hba1cId").css("border-color","red");
     		//$("#hba1cId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#hba1cErrmsg").html("PreDiabetes").show();
	        $('input[name="hba1cErrMsgTxt"]').val('PreDiabetes');
	        return false;
		}
		else if(temp >= 6.5){
			//$("#hba1cId").css("border-color","red");
     		//$("#hba1cId").css("box-shadow", "0 1px 1px rgba(0, 0, 0, 0.075) inset, 0 0 8px rgba(255, 0, 0, 0.6)");	
	        $("#hba1cErrmsg").html("HighDiabetes").show();
	        $('input[name="hba1cErrMsgTxt"]').val('HighDiabetes');
	        return false;
		} 
		else{
			$("#hba1cId").css("border-color","");
     		$("#hba1cId").css("box-shadow", "");
     		$("#hba1cErrmsg").html("");
     		$('input[name="hba1cErrMsgTxt"]').val('Normal');
     		return true;
		}
	});

	$('#weightId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#heightId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#haemoglobinId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#diastolicId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#systolicId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#fastingId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#ppRateId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#hba1cId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});
	$('#temperatureId').bind("paste", function(e) {
		var text = e.originalEvent.clipboardData.getData('Text');
		if ($.isNumeric(text)) {
		    if ((text.substring(text.indexOf('.')).length > 3) && (text.indexOf('.') > -1)) {
		        e.preventDefault();
		        $(this).val(text.substring(0, text.indexOf('.') + 3));
		   }
		}
		else {
		        e.preventDefault();
		     }
	});

	$('#haemoglobin').tooltip({
        placement:"top"
    });
    $('#respRate').tooltip({
        placement:"top"
    });
    $('#VitalsPrintBtn').tooltip({
        placement:"top"
    });
    $('#bloodPressure').tooltip({
        placement:"top"
    });
    $('#hba1c').tooltip({
        placement:"top"
    });
    $('#ppRate').tooltip({
        placement:"top"
    });
    $('#fasting').tooltip({
        placement:"top"
    });
    $('#bloodSugarId').tooltip({
        placement:"top"
    });

    $("#VitalsPrintBtn").on('click',function(){
		$('.close').hide();
		$('#VitalsPrintBtn').hide();
		$('#saveBtn').hide();
		$('.opdBayHeaderTwo').hide();
		$('[data-toggle="tooltip"]').tooltip("hide");
		window.print();
		$('.close').show();
		$('#VitalsPrintBtn').show();
		$('#saveBtn').show();
		$('.opdBayHeaderTwo').show();
		return false;
	});

    $(window).bind("resize", function () {
	 	if($(window).width() < 992){
		  $('#bloodSugarDivId').removeClass('alignRight');
		}
	}).trigger('resize');

	$(window).bind("resize", function () {
	 	if($(window).width() >= 992){
		  $('#bloodSugarDivId').addClass('alignRight');
		  $('#bloodPressureDivId').addClass('alignRight');
		}
	}).trigger('resize');

	$("input[id='temperatureId']").attr("maxlength", "5");
	$("input[id='diastolicId']").attr("maxlength", "5");
	$("input[id='systolicId']").attr("maxlength", "5");
	$("input[id='respRateId']").attr("maxlength", "2");
	$("input[id='haemoglobinId']").attr("maxlength", "5");
	$("input[id='pulseId']").attr("maxlength", "3");
	$("input[id='fastingId']").attr("maxlength", "5");
	$("input[id='ppRateId']").attr("maxlength", "5");
	$("input[id='hba1cId']").attr("maxlength", "4");

	});



/*
 *  Function Not in Use
 * */

function showvital(e){  
			//alert('showvital');
			var patName = $(e).closest('.patientListBlock').find('.patName').text();
			var patCrNo = $(e).closest('.patientListBlock').find('.patCrNo').text();
			var patEpisodeVisitNo = $(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text();
			var patLastVisitDate = $(e).closest('.patientListBlock').find('.patLastVisitDate').text()==='' ? 'First Visit' : $(e).closest('.patientListBlock').find('.patLastVisitDate').text(); //Changed By Timsi Kataria as suggested by Priyesh Sir
			var patVisitType = $(e).closest('.patientListBlock').find('.patVisitType').text();
			var patGaurdianName = $(e).closest('.patientListBlock').find('.patGaurdianName').text(); 
			var patDeptName = $(e).closest('.patientListBlock').find('.patDeptUnit').text();
			var nextPatName = $(e).closest('.patientListBlock').next().find('.patName').text(); 
			var prevPatName = $(e).closest('.patientListBlock').prev().find('.patName').text();
			var patGenAgeCat = $(e).closest('.patientListBlock').find('.patGenAgeCat').text();
			var episodeCode = $(e).closest('.patientListBlock').find('.patEpisodeCode').text();
			var hospitalCode = $(e).closest('.patientListBlock').find('.patHospitalCode').text();
			var seatId = $(e).closest('.patientListBlock').find('.patSeatId').text(); 
			var patConsultantName = $(e).closest('.patientListBlock').find('.patConsultantName').text();  
			var patCompleteGeneralDtl = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl]').val();
			console.log('showPrescription::>>> '+patName+patCrNo+patEpisodeVisitNo+patLastVisitDate);
			/* alert('frst::'+episodeCode); */
			var prescMode = $('input[name=prescMode]:checked').val(); 
	        console.log('Presc in showPrescription() : '+prescMode);

	        console.log('Presc in patCrNo() : '+patCrNo);
	        console.log('Presc in patEpisodeVisitNo() : '+patEpisodeVisitNo);
	        
			if(prescMode==1) //Not in use !! Do not comment.
			{	console.log('tile mode presc'+prescMode);
				inTilePresc(e, patName, patCrNo, episodeCode, patGenAgeCat, patCompleteGeneralDtl); //Not in use !! Do not comment.
			}
			else if(prescMode==2)
	        { console.log('page mode presc'+prescMode);
				$('.showPatientDtl').remove();
				$('.patientListBlock').attr('clicked','0');   //Not in use !! Do not comment.
				$('.rightPanel').append(str);
				$('.leftPanelHeader').toggleClass('col-sm-12 hideCls');
				$('.leftPanel').toggleClass('col-sm-12 hideCls');
				$('.prescriptionColShow').hide('slow');  //Not in use !! Do not comment.
				$('.mainTopHeader').hide();
				$('.rightPanel').parent().append('<h2 id="rightPanelLoadMsgId" style="margin-top:20%; margin-left:5%"><i class="fa fa-spinner fa-spin"></i> Loading Patient Prescription....</h3>');
				 $.ajax({
					url: '/HISDRDESK_MC/new_opd/Opdvital.jsp',
					async:true,
					success: function(result){
						//alert(result);
						$('.rightPanel .showPatientDtl').html(result);
						//$('.showPatientDtl').remove();
							$('#patNamePrescriptionPanel').text(patName);
				      		$('#patCrNoPrescriptionPanel').text(patCrNo);
				      		$('#patSummaryTileImg').attr('src',$(e).closest('.patientListBlock').find('.patProfileImg').attr('src'));
				      		$('#patEpisodeVisitNoPrescriptionPanel').text(patEpisodeVisitNo);
				      		$('#patLastVisitDatePrescriptionPanel').text(patLastVisitDate);
				      		$('#patVisitTypePrescriptionPanel').text(patVisitType);
				      		$('#prescriptionPanelPatStatus').text($(e).closest('.patientListBlock').hasClass('isAttended_1')?'':'Attended').css('color',$(e).closest('.patientListBlock').hasClass('isAttended_1')?'#1bbf23':'red');
				      		$('#patGaurdianNamePrescriptionPanel').text(patGaurdianName);
				      		$('#patDeptName').text(patDeptName);
				      		$('#patGenAgeCatPrescriptionPanel').html(patGenAgeCat);
				      		$('#patHospitalCodePrescriptionPanel').html(hospitalCode); 
				      		//$('#patSeatIdPrescriptionPanel').html(seatId); 
				      		$('#patConsultantNamePrescriptionPanel').html(patConsultantName); 
				      		if(nextPatName.trim()!='')
				      		$('#nextPatNamePrescriptionPanel').html(nextPatName.split("  ")[0].length>3 ? '('+nextPatName.split("  ")[0]+')' : '('+nextPatName.split("  ")[0]+' '+nextPatName.split("  ")[1]+')'); 
				      	  	if(prevPatName.trim()!='')
				      		$('#prevPatNamePrescriptionPanel').html(prevPatName.split("  ")[0].length>3 ? '('+prevPatName.split("  ")[0]+')' : '('+prevPatName.split("  ")[0]+' '+prevPatName.split("  ")[1]+')'); 
				      		$('#patEpisodeCodePrescriptionPanel').text(episodeCode);
				      		$('input[name=patCompleteGeneralDtlPrescriptionPanel]').val(patCompleteGeneralDtl);
				      		$('input[name=patGeneralDtl]').val(patName+'#'+patCrNo+'#'+episodeCode+'#'+patGenAgeCat);
							$('.rightPanel').show();
							$('body').css('padding-top','0px');
							$('body .container-fluid:first-child').css('margin','0px');
							count=0;
							$('.patientListBlock').each(function(index){
								console.log('patientListBlock::::>>>>> '+count); 
								if($(this).find('.patCrNo').text().trim() === $('#patCrNoPrescriptionPanel').text().trim())
									return false;
									count++;
								}); 	
							$('#rightPanelLoadMsgId').remove();
						}
					}); 
				
			}
			else if(prescMode==3)//Not in use !! Do not comment.
	        { console.log('modal mode presc'+prescMode);
				$('.showPatientDtl').remove();
				$('.patientListBlock').attr('clicked','0'); 
				$('.prescModalBody').append(str);
	      		$('.prescModalBody .showPatientDtl').load('/HISDRDESK_MC/new_opd/prescription.jsp', function(){
			      		$('#patNamePrescriptionPanel').text(patName);
			      		$('#patCrNoPrescriptionPanel').text(patCrNo);
			      		$('#patGenAgeCatPrescriptionPanel').text(patGenAgeCat);
			      		$('#patEpisodeCodePrescriptionPanel').text(episodeCode);
			      		$('input[name=patCompleteGeneralDtlPrescriptionPanel]').val(patCompleteGeneralDtl);
			      		$('input[name=patGeneralDtl]').val(patName+'#'+patCrNo+'#'+episodeCode+'#'+patGenAgeCat);
		      		});   
				$('#prescModalTriggerBtn').click();
			}  
	}


function getAllPreviousVitalDtls(CR_No,episodeCode,hospitalCode,visitNo){
	
	var data={"CR_No":CR_No, "episodeCode":episodeCode , "hospitalCode":hospitalCode, "visitNo":visitNo};
	$('#vitaldates').html("");
	$.ajax(
			{	
				url:'/HISDRDESK_MC/services/restful/DrDesk/getAllPreviousVitalDtls',
				type:'POST',
				data:JSON.stringify(data),
				dataType : "json",
				contentType: "application/json; charset=UTF-8",
				success:function(result){
					//alert(JSON.stringify(result));
					if(result["VitalDtls"]!=undefined && result["VitalDtls"].length>0){
						$('#previous_vitals').html(JSON.stringify(result["VitalDtls"]));
						$('#selectedVitalIndex').val("");
						$('#vitaldates').append("<h5>Previous Vitals</h5>");
						$.each(result["VitalDtls"],function(indx, vitalobj){
							var html="<a class='btn btn-outline-success btn-sm btnvitaldate' title='Click To view vital detail' data-indx='"+indx+"' data-dt='"+vitalobj["hopldt_entry_date"]+"' style='margin-bottom: 10px;'>"+vitalobj["hopldt_entry_date"]+"</a>";							
							$('#vitaldates').append(html);
						});
					}
					else{														
						$('#vitaldates').append("<h5>No Previous Vitals</h5>");
					}
					$('.btnvitaldate').click(showPrevVital);
					
				}
	});
	
}

function showPrevVital(){
	var indx= $(this).attr("data-indx");
	var dt= $(this).attr("data-dt");
	var previous_vitals= JSON.parse($('#previous_vitals').html());
	$('#divPrevVitalDtl').html("");
	$('#preVitalHeading').text("Vital For Date : " + dt)
	$('#divPrevVitalDtlMain').show();	
	$('#btnActonPrevVitalHide').show();
	$('#btnActonPrevVitalShow').hide();
	$('#btnActonPrevVitalPopulate').show();
	$('#divPrevVitalDtl').show();	
	$('#selectedVitalIndex').val(indx);
	
	//alert(previous_vitals[indx]);
	var vital_json_data= JSON.parse( previous_vitals[indx]["vital_json_data"]);
	//alert(JSON.stringify(vital_json_data));
	//$('#divPrevVitalDtlMain').hide();
	$.each(vital_json_data, function(key, valobj){
		var headingLabel="";
		var dataLabel="";
		
		if(key=="strPatdtls" || key=="strPregnancy" || key=="strGeneral" || key=="strbmiErrmsg" || key=="strrespRateErrmsg" || key=="strfastingErrmsg" || key=="strppRateErrmsg")
			return;
		
		if(Array.isArray(valobj)){
			var val="";
			for(var i=0;i<valobj.length;i++){
				val+=valobj[i] + " ";				
			}
			headingLabel=key;
			dataLabel=val;
		}
		else{
			
			if(valobj.trim()!="" && valobj.trim()!="0" && valobj.trim()!="0.0" && valobj.trim()!="0.00" ){
				headingLabel=key;
				dataLabel=valobj;
			}
		}		
		if(headingLabel!=""){
			switch(headingLabel) {
			  case "strWeight":headingLabel="Weight(Kg)"; break;
			  case "strHeight":headingLabel="Height(cm)"; break;
			  case "strBmid":headingLabel="BMI(kg/m2)"; break;
			  case "strTempreature":headingLabel="Temp(F)"; break;
			  case "strrespRate":headingLabel="Resp.Rate(breaths/min)"; break;
			  case "strhaemoglobin":headingLabel="Hemoglobin(g/dL)"; break;
			  case "strsystolic":headingLabel="Systolic(mmHg)"; break;
			  case "strdiastolic":headingLabel="Diastolic(mmHg)"; break;
			  case "strfasting":headingLabel="Fasting"; break;
			  case "strRateId":headingLabel="PP"; break;
			  case "strsymptoms":headingLabel="Remarks"; break;
			  case "strpulseRate":headingLabel="Pulse Rate"; break;
			  case "strbloodGroup":headingLabel="Blood Group"; break;
			  case "strhba1c":headingLabel="HBA1C"; break;
			  case "strDisability":headingLabel="Disability"; break;
			  case "strSmoking":headingLabel="Smoking"; break;
			  case "strcancerScreening":headingLabel="Cancer Screening"; break;
			 
			  case "strAnemic":headingLabel="Severe Anemia"; break;
			 
			  case "isPregnant":headingLabel="Is Pregnant ?"; break;
			  case "lmp":headingLabel="LMP"; break;
			  case "edod":headingLabel="EDOD"; break;
			  case "obestetricHistory":headingLabel="Obestetric History"; break;
			  case "pastHistory":headingLabel="Past History"; break;
			  case "Pregnancy1":headingLabel="Gestational Age (In Weeks)"; break;
			  case "pregnancyInducedHypertension":headingLabel="Pregnancy Induced Hypertension"; break;
			  case "gestationalDiabetesMelitus":headingLabel="Gestational Diabetes Melitus"; break;
			  case "reactiveForHIV":headingLabel="Reactive for HIV"; break;
			  case "syphilis":headingLabel="Syphilis"; break;
			  case "hypothorism":headingLabel="Hypothorism"; break;
			  case "tuberculosis":headingLabel="Tuberculosis"; break;
			  case "malaria":headingLabel="Malaria"; break;
			  case "previousLSCS":headingLabel="Previous LSCS"; break;
			  case "hepatitisB":headingLabel="Hepatitis B"; break;
			  case "badObstetricHistory":headingLabel="Bad Obstetric history"; break;
			  case "twinsMultiplePregnancy":headingLabel="Twins/Multiple Pregnancy"; break;
			  case "cephaloPelvicDisproportion":headingLabel="Cephalo-pelvic Disproportion"; break;
			  case "abnormalFetalPregnanacy":headingLabel="Abnormal Fetal Pregnanacy"; break;
			  case "teenagePregnanacy":headingLabel="Teenage Pregnanacy"; break;
			  case "highFever":headingLabel="High Fever"; break;
			  case "rti-sti-hpsag-positive":headingLabel="RTI/STI/HBS Ag +ve"; break;
			  case "having-HO-Still-Birth":headingLabel="Having H/O Still Birth"; break;
			  case "congenitalMalformation":headingLabel="Congenital Malformation"; break;
			  case "rhNegativeBloodGroupOfMother":headingLabel="Rh Negative Blood Group Of Mother"; break;
			  case "earlyPrimi":headingLabel="Early Primi"; break;
			  case "elderlyPrimi":headingLabel="Elderly Primi"; break;
			  case "grandMultipara":headingLabel="Grand Multipara"; break;
			  case "shortStature":headingLabel="Short Stature"; break;
			  case "OtherIfAny1":headingLabel="Other (If Any)"; break;
			  case "isPatientReferredToHigherFacility":headingLabel="Is Patient referred to Higher facility"; break;
			  case "birthPreparednessPlanMade":headingLabel="Birth preparedness plan made"; break;
			  case "OtherIfAny2":headingLabel="Other (If Any)"; break;
			  case "isHighRiskPregnancy":headingLabel="Is High Risk Pregnancy?"; break;
			  case "stracbl":headingLabel="T.CHL"; break;
			  case "strtgl":headingLabel="TGL."; break;
			  case "strhdl":headingLabel="HDL"; break;
			  case "strldl":headingLabel="LDL"; break;
			  case "strCreatinine":headingLabel="Creatinine"; break;
			  case "strUricAcid":headingLabel="Uric Acid"; break;
			  case "strtsh":headingLabel="TSH"; break;
			  case "strt3":headingLabel="T3"; break;
			  case "strt4":headingLabel="T4"; break;
			  case "stranyOtherReport":headingLabel="Other Reports"; break;				
			}
			
			
			
			
			var html="<div class='col-md-3'>";
			html+="<div class='form-group'>";
			html+="<label >"+headingLabel+" : </label><br/>";
			html+="<label style='color:blue;'>"+dataLabel+"</label>";
			html+="</div>";
			html+="</div>";
			$('#divPrevVitalDtl').append(html);
		}
		
	});
	
	
	
}

function populateVitalJson(){
	
	var flag=confirm("This action will populate vital in Todays Vital form.\n Do you want to continue?");
	if(flag==false)
		return;
	
	var selectedVitalIndex=$('#selectedVitalIndex').val()
	var previous_vitals= JSON.parse($('#previous_vitals').html());
	$('#btnActonPrevVitalShow').show();
	$('#btnActonPrevVitalPopulate').hide();
	$('#btnActonPrevVitalHide').hide();
	$('#divPrevVitalDtl').hide();
	console.log(previous_vitals[selectedVitalIndex]);
	var jsonVital= previous_vitals[selectedVitalIndex]["vital_json_data"];
	
	populateVitalForm(jsonVital);
	
	 
	}



function populateVitalForm(vitalJSON){
	//alert("inside populateVitalForm");
	
	$.each(JSON.parse(vitalJSON), function(key,value){
		if(value!=""){
			switch (key){
				case "strWeight":
					$("#weightId").val(value);					
				break;
				case "strHeight":
					$("#heightId").val(value);
				break;
				case "strBmid":
					$("#bmiId").val(value);
				break;
				case "strTempreature":
					$("#temperatureId").val(value);
				break;
				case "strrespRate":
					$("#respRateId").val(value);
				break;
				case "strpulseRate":
					$("#pulseRateId").val(value);
				break;	
				case "strsystolic":
					$("#systolicId").val(value);
				break;	
				case "strdiastolic":
					$("#diastolicId").val(value);
				break;	
				case "alcoholConsumption":
					if(value=="Yes")
						document.getElementsByName("alcoholConsumption")[0].checked=true;
					if(value=="No")
						document.getElementsByName("alcoholConsumption")[1].checked=true;
				break;
				case "strSmoking":
					if(value=="Yes")
						document.getElementsByName("Smoking")[0].checked=true;
					if(value=="No")
						document.getElementsByName("Smoking")[1].checked=true;
				break;					
				case "isPregnant":
					if(value=="Yes")
						document.getElementsByName("isPregnant")[0].checked=true;
					if(value=="No")
						document.getElementsByName("isPregnant")[1].checked=true;
				break;
				case "strfasting":
					$("#fastingId").val(value);
				break;
				case "strRateId":
					$("#ppRateId").val(value);
				break;
				
				case "strhba1c":
					$("#hba1cId").val(value);
				break;
				
				case "stracbl":
					$("#acbl").val(value);
				break;
				
				case "strtgl":
					$("#tgl").val(value);
				break;
				
				case "strhdl":
					$("#hdl").val(value);
				break;
				case "strldl":
					$("#ldl").val(value);
				break;
				case "strCreatinine":
					$("#Creatinine").val(value);
				break;
				case "strUricAcid":
					$("#uricAcid").val(value);
				break;
				case "strtsh":
					$("#tsh").val(value);
				break;
				
				case "strt3":
					$("#t3").val(value);
				break;
				
				case "strt4":
					$("#t4").val(value);
				break;
				
				case "strhaemoglobin":
					$("#haemoglobinId").val(value);
				break;
				
				case "stranyOtherReport":
					$("#anyOtherReport").val(value);
				break;
				
				case "strsymptoms":
					$("#symptomsId").val(value);
				break;
			}
		}
	});
}

function createVitalDiv(vitalJSON){
	//alert("inside createVitalDiv");
	$('.vital').hide();
	var strVitalsChart="";
	var strsystolic="";
	$.each(vitalJSON, function(key,value){
		if(value!=""){
			switch (key){
				case "strWeight":
					strVitalsChart+='Weight : '+value +'kgs,';
					$("#weightIdValue").text(value +' kgs,');
					$('#weightpId').show();
				break;
				case "strHeight":
					strVitalsChart+=' Height : ' +value+'cms,';
					$("#heightIdValue").text(value+' cms');
					$('#heightpId').show();
				break;
				case "strBmid":
					strVitalsChart+=' BMI : ' + value+',';
					$("#bmiIdValue").text(value);
					$('#bmipId').show();
				break;
				case "strTempreature":
					strVitalsChart+=' Temperature : ' + value+'F,';
					$("#temperatureIdValue").text(value+' F');
					$('#temppid').show();
				break;
				case "strrespRate":
					strVitalsChart+=' Respiration Rate : ' + value+'br/m,';
					$("#respRateIdValue").text(value +' br/m');
					$('#rrpid').show();
				break;
				case "strpulseRate":
					strVitalsChart+=' Pulse Rate : ' + value+'be/m,';
					$("#pulserateIdValue").text(value +' be/m');
					$('#pulseratepid').show();
				break;					
				case "alcoholConsumption":
					strVitalsChart+=' Alcohol Consumption : ' + value+',';		
					$("#alcoholConsumptionvalue").text(value);
					$('#alcoholConsumption').show();
				break;
				case "strSmoking":
					strVitalsChart+=' Smoking : ' + value+',';		
					$("#SmokingIdvalue").text(value);
					$('#bppid').show();
				break;					
				case "isPregnant":
					strVitalsChart+=' Pregnancy : ' + value+',';
					$("#PregnancyIdvalue").text(value);
					$('#Pregnancyid').show();
				break;					
			}
		}
	});
	if(vitalJSON["strsystolic"]!=undefined && vitalJSON["strdiastolic"]!=undefined){
		strVitalsChart+=' BP : ' + vitalJSON["strsystolic"] + " / " + vitalJSON["strdiastolic"] + " mm/HG"+',';
		$('#bloodPressureIdValue').text(vitalJSON["strsystolic"] + " / " + vitalJSON["strdiastolic"] + " mm/HG")
		$('#bppid').show();
	}
	$("#vitalHiddenValId").val(strVitalsChart);
	$('#vitalmainDiv').show();
  	

}



function createLabDiv(vitalJSON){
	var strLabDtl="";
	//alert(JSON.stringify(vitalJSON));
	$.each(vitalJSON, function(key,value){
		if($('#'+ key + 'Value')!=undefined && $('#'+ key + 'Value').length>0 && value!=""){
			$('#'+ key + 'Value').text(value);			
		}
	});
	var strfasting=vitalJSON["strfasting"]==undefined?"":vitalJSON["strfasting"].trim();
	var strRateId=vitalJSON["strRateId"]==undefined?"":vitalJSON["strRateId"].trim();
	var strhba1c=vitalJSON["strhba1c"]==undefined?"":vitalJSON["strhba1c"].trim();
	var flagsugar=false;
	if(strfasting!="" || strRateId!="" || strhba1c!="" ){
		strLabDtl+="Blood Sugar : ";
		flagsugar=true
	}
	if(strfasting!="")
		strLabDtl+=" FBS : " +strfasting ;
	if(strRateId!="")
		strLabDtl+=" PPBS : " +strRateId;
	if(strhba1c!="")
		strLabDtl+=" HBA1C : " +strhba1c;
	if(flagsugar) 
		strLabDtl+="<br/>";
	
	var stracbl=vitalJSON["stracbl"]==undefined?"":vitalJSON["stracbl"].trim();
	var strtgl=vitalJSON["strtgl"]==undefined?"":vitalJSON["strtgl"].trim();
	var strhdl=vitalJSON["strhdl"]==undefined?"":vitalJSON["strhdl"].trim();
	var strldl=vitalJSON["strldl"]==undefined?"":vitalJSON["strldl"].trim();
	var flagLipidProfile=false;
	if(stracbl!="" || strtgl!="" || strhdl!="" || strldl!="" ){
		strLabDtl+="Lipid Profile : ";
		flagLipidProfile=true;
	}
	
	if(stracbl!="")
		strLabDtl+=" T.CHL. : " +stracbl ;
	if(strtgl!="")
		strLabDtl+=" TGL : " +strtgl ;
	if(strhdl!="")
		strLabDtl+=" HDL : " +strhdl ;
	if(strldl!="")
		strLabDtl+=" LDL : " +strldl ;
	
	if(flagLipidProfile) 
		strLabDtl+="<br/>";
	
	var strCreatinine=vitalJSON["strCreatinine"]==undefined?"":vitalJSON["strCreatinine"].trim();
	var strUricAcid=vitalJSON["strUricAcid"]==undefined?"":vitalJSON["strUricAcid"].trim();
	var flagKidneyFunctionTest=false;
	if(strCreatinine!="" || strUricAcid!=""){
		strLabDtl+="Kidney Function Test : ";
		flagKidneyFunctionTest=true;
	}
	if(strCreatinine!="")
		strLabDtl+=" Creatinine : " +strCreatinine ;
	if(strUricAcid!="")
		strLabDtl+=" Uric Acid : " +strUricAcid ;
	if(flagKidneyFunctionTest) 
		strLabDtl+="<br/>";
	
	var strtsh=vitalJSON["strtsh"]==undefined?"":vitalJSON["strtsh"].trim();
	var strt3=vitalJSON["strt3"]==undefined?"":vitalJSON["strt3"].trim();
	var strt4=vitalJSON["strt4"]==undefined?"":vitalJSON["strt4"].trim();
	var flagThyroidProfile=false;
	if(strtsh!="" || strt3!="" || strt4!=""){
		strLabDtl+="Thyroid Profile : ";
		flagThyroidProfile=true;
	}
	if(strtsh!="")
		strLabDtl+=" TSH : " +strtsh ;
	if(strt3!="")
		strLabDtl+=" T3 : " +strt3 ;
	if(strt4!="")
		strLabDtl+=" T4 : " +strt4 ;
	if(flagThyroidProfile) 
		strLabDtl+="<br/>";
	
	var strhaemoglobin=vitalJSON["strhaemoglobin"]==undefined?"":vitalJSON["strhaemoglobin"].trim();
	
	if(strhaemoglobin!="")
		strLabDtl+=" HB% : " +strhaemoglobin  + " g/dL <br/>";
	
	var stranyOtherReport=vitalJSON["stranyOtherReport"]==undefined?"":vitalJSON["stranyOtherReport"].trim();
	if(stranyOtherReport!="")
		strLabDtl+=" Any Other Reports : " +stranyOtherReport;
	
	//alert("strLabDtl>>>" + strLabDtl)
	$('#labHiddenValId').val(strLabDtl);
	if(strLabDtl!="")
		$('#investigationReportMainDiv').find('.accordionbtn').trigger('click');
		
}

function validateBP(){
	
	/*if($("#systolicId").val().replace(/^(0+)/g, '')){
		$("#systolicId").val($('#diastolicId').val().replace(/^(0+)/g, ''));
	}
	if($("#diastolicId").val().replace(/^(0+)/g, '')){
		$("#diastolicId").val($('#diastolicId').val().replace(/^(0+)/g, ''));
	}*/
	
	var systolic='';
	if($("#systolicId").val().trim() == ''){
		systolic = '';
	}else{
		systolic=parseFloat($("#systolicId").val() );
	}	
	
	var diastolicId=parseFloat($("#diastolicId").val());
	
	if($("#diastolicId").val().trim() == ''){
		diastolicId = '';
	}else{
		diastolicId=parseFloat($("#diastolicId").val() );
	}	
	
	if(systolic!=""){
		if(systolic <1 || systolic > 400){
			
		    $("#bpErrmsg").html("Invalid Value").show();
	        $('input[name="bpErrMsgTxt"]').val('Invalid Value');
	        return false;
		}		
	}
	if(diastolicId!=""){
		if(diastolicId <1 ||diastolicId > 300){
		    $("#bpErrmsg").html("Invalid Value").show();
	        $('input[name="bpErrMsgTxt"]').val('Invalid Value');
	        return false;
		}	
	}
	if(systolic!="" && diastolicId!="" ){
		if(systolic <90 || diastolicId < 60 ) {
			$("#bpErrmsg").html("Please Check! Hypotension").show();
		    $('input[name="bpErrMsgTxt"]').val('Please Check! Hypotension');
		}
		else if(systolic >130 || diastolicId > 90 ) {
			$("#bpErrmsg").html("Please Check! Hypertension").show();
		    $('input[name="bpErrMsgTxt"]').val('Please Check! Hypertension');
		}		
	}
	
	
	
	
	
	
}