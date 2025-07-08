$(document).ready(function () {
    initPage();

	 $("#clearBtnId").click(function (event) {
        event.preventDefault();
        resetPages();
    });
    
 //select city then change hospital name  
      $("#cityId").change(function(){
		var inputData1={"cityId":this.value};
		
		var configHospital1={
				serviceName:"/getData/gethospitalname",
				inputData:inputData1,
				callBackFunctionName:"commonPopulateCombo",
				comboId:"hospitalId",
				defaultOption:{"optionValue":"","optionText":"Select Hospital"}
		}
		callService(configHospital1);
	});	
	
	
 //select hospital then get appintment details  
	
	$('#hospitalId').change(function(){
	alert("hospitalId")
	
	var configJson={
   				serviceName:"/getData/get_appointment_dtls",
   				comboId:"regPrioritySetup",		
      			callBackFunctionName:"populateRegPrioritySetup",	
      			primaryKeys:[$('#hospitalId').val()],
   		}
   	callService(configJson);
	
    	
		    });
	
});


	
	function populateRegPrioritySetup(configJson, dataJson){
			 alert("configJson>>> " + JSON.stringify(configJson));
      alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

}
	
	function createDependentRow(json){
	
	var RegPrioritySetup=json["getappointmentdtls"];
	alert("RegPrioritySetup"+RegPrioritySetup);
	
	 var html ="<tr id=''>";
     html +="<td>" + json["priorityType"]+"</td>";
     html +="<td>" + json["prioritySymbol"] +"</td>";
     html +="<td>" +  json["priorityOrder"]  +"</td>";
     html +="<td>" + json["priorityRatio"] +"</td>";
     html +="<td>" + json["configurationValue"] +"</td>";
     html +="<td>" + json["remarks"] +"</td>";

     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#regPrioritySetup tbody').append(html);
     
     var index=1;
     $('.slno').each(function(){
		 $(this).text(index);
		 index++;
	 });
}


	
function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	var json ={
			"stepTitle":"Test Title here",
			"steps":[
				{"step":"step-One", "stepIcon":"1"},
				{"step":"step-Two","stepIcon":"2"},
				{"step":"step-Three","stepIcon":"3"},
				{"step":"Finish","stepIcon":"fa-solid fa-circle-check fa-fw"},
			],
			"activeStepNo":"3"				
	};
	createWizard(json);

	
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		
        }
    });
	    
  
    
    $('#BTNSAVE').click(saveData);
    
    $('#BTNCLEAR').click(resetPage);
 
    var configJson={
			serviceName:"/getData/getcities",
		 comboId:"cityId",		
		 callBackFunctionName:"commonPopulateCombo",
		defaultOption:{"optionValue":"","optionText":"Select City"}	
		
	      }
      callService(configJson);
}


function saveData(){
	
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	
	
	showPreloader("Saving Data Please Wait !");
	//alert(JSON.stringify(data));
	var configJson={
			serviceName:"/DMLSAVE/saveRegPrioritySetupMstData",
			callBackFunctionName:"callbackSaveData",			
			inputData:processSerializeArray("ENTRYFORM")
		}
	callService(configJson);
}
	
function callbackSaveData(configJson, dataJson){
	
//	alert("callbackSaveData>>>"+JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
	   showMsg(dataJson["message"],dialogConfigJson)
		
		
	}
}


function resetPage(){	
	$('.select2').trigger('change');
	commonResetFields(initInputJson);
}