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
    		
        }
    });
	    
	    
	    

	
	
	var configJson={
			serviceName:"/getData/getGovtDeptNameList",
			comboId:"govtDeptName",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Govt. Deptartment Name"}	
			
		}
	callService(configJson);
    
    
      
var configJson = {
    serviceName: "/getData/getOrgTypeNameList",
    comboId: "orgType",			
    callBackFunctionName: "commonPopulateCombo",
    defaultOption: {"optionValue": "",
        "optionText": "Select Organization Type Name"
    }	
}

callService(configJson);

   $('#orgType').change(function() {
        var selectedType = $('#orgType option:selected').text(); 

        if (selectedType === "Autonomous Bodies") {
            $('#isAutonomous').val("1");  
        } 
        else if (selectedType === "") {
            $('#isAutonomous').val("0");  
        }
        else {
            $('#isAutonomous').val("2");   
        }
    });
	
	
    $('#BTNSAVE').click(saveData);
    
    $('#BTNCLEAR').click(resetPage);
  
	
}


function saveData(){
	
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	
	
	showPreloader("Saving Data Please Wait !");
	//alert(JSON.stringify(data));
	var configJson={
			serviceName:"/DMLSAVE/saveGovtServiceDeptMstData",
			callBackFunctionName:"callbackSaveData",			
			inputData:processSerializeArray("ENTRYFORM")
		}
	callService(configJson);

	}
function callbackSaveData(configJson, dataJson){
	
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
	   showMsg(dataJson["message"],dialogConfigJson)
		
		
	}
	
	
}

/*function resetPage(){
	$('#masterKey').val("govtSubServiceDeptMst");
	submitFormWithResetTextField("CallMasterPage");
}*/


