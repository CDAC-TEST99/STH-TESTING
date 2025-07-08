$(document).ready(function () {
	initPage();
});


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
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });
	
	
	
	var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"patGender",			
			callBackFunctionName:"callBackgetGenderList",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
	
	var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });
    
  
    
    
    $('#BTNSAVE').click(saveData);
    
    $('#BTNCLEAR').click(resetPage);
  
	
}


function callBackgetGenderList(configJson, dataJson){
	//alert(JSON.stringify(dataJson));
	commonPopulateCombo(configJson, dataJson);
}

function saveData(){
	
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	
	
	showPreloader("Saving Data Please Wait !");
	//alert(JSON.stringify(data));
	var configJson={
			serviceName:"/DMLSAVE/saveTestData",
			callBackFunctionName:"callbackSaveData",
			fileUploadFlag:$('#fileUploadFlag').val(),			
			inputData:processSerializeArray("ENTRYFORM")
		}
	callService(configJson);
}
	
function callbackSaveData(configJson, dataJson){
	
	alert(JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
	   showMsg(dataJson["message"],dialogConfigJson)
		
		
	}
}
function resetPage(){
	$('#masterKey').val("testProcess2");
	submitFormWithResetTextField("CallMasterPage");
}

