$(document).ready(function() {
	initPage();
});

function initPage() {
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');
	initInputJson = $(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	localStorage.removeItem("PAN_DTL");
	
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear = toYear - 99;
	let maximumDate = 0
	let minimumDate = -36500
	$('.datepickerdob').datepicker({
		minDate : minimumDate,
		maxDate : maximumDate,
		"dateFormat" : "dd-mm-yy",
		changeMonth : true,
		changeYear : true,
		showButtonPanel : true,
		showOtherMonths : true,
		selectOtherMonths : true,
		yearRange : fromYear + ":" + toYear,
		onSelect : function(date, datepicker) {
			//var id= $(datepicker).attr("id");
			//$('#'+id).trigger('blur');

		}
	});

//	var configJson = {
//		serviceName : "/getData/getGenderList",
//		comboId : "patGender",
//		callBackFunctionName : "callBackgetGenderList",
//		defaultOption : {
//			"optionValue" : "",
//			"optionText" : "Select gender"
//		}
//
//	}
//	callService(configJson);

	$('#patcardtype').change(function() {
		var cardvalue = $('#patcardtype').val();
		$('#cardtypevaluehidden').val(cardvalue)
		//alert(cardvalue);
	});

	
}

function openpage() {
	//var cardtypevalue = $('#cardtypevaluehidden').val();
	var panNumber = $('#patPanno').val();

	$('#panNumber').val(panNumber);
	//alert("PAN Number = " + $('#panNumber').val());
	var hiddenId12 =localStorage.getItem("hiddenId12");
	if(hiddenId12!=null){
		$('#hiddenId12').val(hiddenId12);
		var applicationType="";
		if(hiddenId12=='SA')
			applicationType="DAOnlinePensioner";
		else
			applicationType="onlineapplyplasticcard";
		
		submitFormMaster(applicationType, "add");
	}else{
		console.log("inside openpage hiddenId12 not found");
	}

}

function callBackgetGenderList(configJson, dataJson) {
	//alert(JSON.stringify(dataJson));
	commonPopulateCombo(configJson, dataJson);
}

//function saveData() {
//
//	if (ValidateForAllVisible("ENTRYFORM") == false)
//		return;
//
//	showPreloader("Saving Data Please Wait !");
//	//alert(JSON.stringify(data));
//	var configJson = {
//		serviceName : "/DMLSAVE/saveTestData",
//		callBackFunctionName : "callbackSaveData",
//		fileUploadFlag : $('#fileUploadFlag').val(),
//		inputData : processSerializeArray("ENTRYFORM")
//	}
//	callService(configJson);
//}

function callbackSaveData(configJson, dataJson) {

//	alert(JSON.stringify(dataJson));
	if (dataJson["message"].indexOf("ERROR") >= 0) {
		showMsg(dataJson["message"], null)
	} else {
		var dialogConfigJson = {
			callOnOK : "resetPage",
			"parameterJson" : {}
		}
		showMsg(dataJson["message"], dialogConfigJson)

	}
}
function resetPage() {
	$('#masterKey').val("testProcess2");
	submitFormWithResetTextField("CallMasterPage");
}

function validatePAN(pan) {
	const panPattern = /^[A-Z]{3}[P][A-Z][0-9]{4}[A-Z]{1}$/; // Regular expression
	// for PAN format

	// Convert PAN to uppercase to ensure the input is case-insensitive
	pan = pan.toUpperCase();

	return panPattern.test(pan); // Returns true if valid, false if invalid
}

function validatepancheck() {
	const pan = $('#patPanno').val(); // Get the PAN value from the input
	const errorMessageDiv = document.getElementById('error-message');

	// Clear any existing error message
	errorMessageDiv.textContent = '';

	// Check if the PAN is valid
	if (pan && !validatePAN(pan)) {
		// If invalid, show an error message
		errorMessageDiv.textContent = 'Invalid PAN number format. Please enter a valid PAN.';
	} else {
		// If valid, display success or any other message (optional)
		errorMessageDiv.textContent = ''; // Optionally clear any previous
		// error message
	}
}

function verifyPAN() {
//	alert("Verify PAN calling");
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
//	alert("After Entryform Checking");
	var panNumber = $('#patPanno').val();
	var name = $('#patName').val();
	var fatherName = $('#patfather').val();
	var dob = $('#patDOB').val();
	var payload=	JSON.stringify({
			        pan: panNumber,
			        fathername: fatherName,
			        dob: dob,
			        name: name
			    });
				
	//alert("Name = "+name+"\n Father Name = "+fatherName+"\n Date of Birth = "+dob+"\n PAN Number = "+panNumber);
	 $.ajax({
	        url: "services/restful/pan/verification/v1/inquiry", // API endpoint
	        type: "POST", // HTTP method
	        dataType: "json", // Expected response format
	        contentType: "application/json",
	        data: payload,
	        success: function (data) {
	            console.log(JSON.stringify(data.outputData));
	            console.log("Response Data = "+JSON.stringify(data));
	            if(data.response_Code == 1 && data.outputData.length > 0) {
	            	let nameFlag = data.outputData[0].name;
	            	let dobFlag = data.outputData[0].dob;
	            	let panFlag = data.outputData[0].pan_status;
	            	if(nameFlag == 'Y' && dobFlag == 'Y' && panFlag == 'E') {
						localStorage.setItem("PAN_DTL", payload);
	            		openpage();
	            	} else {
	            		alert("Please Provide Valid PAN Details.");
	            	}
	            } else {
	            	alert("Please Provide Valid PAN Details.");
	            }
	        },
	        error: function (xhr, status, error) {
	            console.log(error);
	        }
	    });
}

