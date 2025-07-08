

$(document).ready(function () {
	
	//initPage();
	 var Benid=$('#Benidvalue').val();
	
	 hidePreloader();
	getCardType();
	getCityId();
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.dateto').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });
	
	$('.dateFrom').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });
	
	
	
	});
  
function getCardType() {
	var configJson={
			serviceName:"/getData/getcardtypeforcardApproval",			    					
			callBackFunctionName:"commonPopulateCombo",
			comboId:"cardType",	
			isDataStoredInSession:"no",
			triggerChange:"Yes",
			defaultOption:{"optionValue":"","optionText":"Select"}	
		};
	
callService(configJson);
}

function getCityId() {
	  var configJson={
			serviceName:"/getData/getcityidbasedonhospital",			
			callBackFunctionName:"populatecity",
		}
	callService(configJson);
}

function populatecity(configJson, dataJson){
	
	$('#cityId').val(dataJson.data[0].optionValue);
	getWellnessCenter(dataJson.data[0].optionValue);
}

function getWellnessCenter(city) {
	  var configJson={
  			serviceName:"/getData/getwellnesscenterbasedoncity",
  			comboId:"wellnessCenter",			
  			callBackFunctionName:"commonPopulateCombo",
  			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
  			primaryKeys:[city],
  		}
  	callService(configJson);
}




function submit(){
	var dateTo = $('#dateTo').val();
	var dateFrom = $('#dateFrom').val();
	var cardType = $('#cardType').val();
	var wellnessCenter = $('#wellnessCenter').val();
	


	// Define validation rules using a JSON-like object
	var fieldsToValidate = {
	      dateTo: {
			        value: dateTo,
			        message: "Please select a  'To Date'."
			    },
	    dateFrom: {
	        value: dateFrom,
	        message: "Please select a  'From Date'."
	    },
	    cardType: {
	        value: cardType,
	        message: "Please choose a card type."
	    },
	    wellnessCenter: {
	        value: wellnessCenter,
	        message: "Please select a wellness center."
	    }
	};

	// Loop through each field and validate
	for (let key in fieldsToValidate) {
	    if (!fieldsToValidate[key].value || fieldsToValidate[key].value.trim() === "") {
	        swal({
	            title: "Missing Information",
	            text: fieldsToValidate[key].message,
	            icon: "warning",
	            button: "OK"
	        });
	        return false;
	    }
	}
	 var configJson={
	  			serviceName:"/getData/getfileandfoldername",			
	  			callBackFunctionName:"downloadMultipleFilesAsZip",
	  			primaryKeys:[dateTo,dateFrom,cardType,wellnessCenter],
	  		}
	  	callService(configJson);
	
}

function downloadMultipleFilesAsZip(configJson, dataJson) {
	var dataCheck = dataJson.data;
	if (Array.isArray(dataCheck) && dataCheck.length === 0) {
	    swal({
	        title: "No Photos Found",
	        text: "Unfortunately, there are no photos available at the moment. Please check back later.",
	        icon: "info",
	        button: "Got it!"
	    });
	    return false;
	}

    // Encode JSON to Base64
    var jsonData = window.btoa(JSON.stringify(dataJson.data));
    console.log("jsonData .... >>> " + jsonData);

    // Create a temporary form to trigger file download
    var form = document.createElement("form");
    form.method = "POST";
    form.action = "/CGHSCardMgmt/FormFlowXACTION";
    form.style.display = "none";
    form.target = "_blank"; // open download in new tab

    // Create and append hidden fields
    var hmodeInput = document.createElement("input");
    hmodeInput.type = "hidden";
    hmodeInput.name = "hmode";
    hmodeInput.value = "downloadMultipleFilesAsZip";
    form.appendChild(hmodeInput);

    var jsonDataInput = document.createElement("input");
    jsonDataInput.type = "hidden";
    jsonDataInput.name = "jsonData";
    jsonDataInput.value = jsonData;
    form.appendChild(jsonDataInput);

    // Optional: filename or extension if server supports it
    const fileNameInput = document.createElement("input");
    fileNameInput.type = "hidden";
    fileNameInput.name = "fileName";
    const currentDate = getCurrentDateFormatted();
    fileNameInput.value = currentDate+".zip"; // Optional - depends on backend
    form.appendChild(fileNameInput);
    
    // Append form to body and submit
    document.body.appendChild(form);
    form.submit();

    // Clean up the form from the DOM
    document.body.removeChild(form);
}


function downLoadExcel(){
	var dateTo = $('#dateTo').val();
	var dateFrom = $('#dateFrom').val();
	var cardType = $('#cardType').val();
	var wellnessCenter = $('#wellnessCenter').val();

	// Define validation rules using a JSON-like object
	var fieldsToValidate = {
	      dateTo: {
			        value: dateTo,
			        message: "Please select a  'To Date'."
			    },
	    dateFrom: {
	        value: dateFrom,
	        message: "Please select a  'From Date'."
	    },
	    cardType: {
	        value: cardType,
	        message: "Please choose a card type."
	    },
	    wellnessCenter: {
	        value: wellnessCenter,
	        message: "Please select a wellness center."
	    }
	};
	// Loop through each field and validate
	for (let key in fieldsToValidate) {
	    if (!fieldsToValidate[key].value || fieldsToValidate[key].value.trim() === "") {
	        swal({
	            title: "Missing Information",
	            text: fieldsToValidate[key].message,
	            icon: "warning",
	            button: "OK"
	        });
	        return false;
	    }
	}
	  var configJson={
				serviceName:"/getData/getdataapprovedbyad",			
				callBackFunctionName:"getdataapprovedbyadcallback",
				primaryKeys:[dateTo,dateFrom,cardType,wellnessCenter],
			}
		callService(configJson);
}

function getdataapprovedbyadcallback(configJson, dataJson) {
    // Step 1: Encode JSON data safely to Base64
	var dataCheck = dataJson.data;
	if (Array.isArray(dataCheck) && dataCheck.length === 0) {
	    swal({
	        title: "No Data",
	        text: "There is no data available.",
	        icon: "warning",
	        button: "OK"
	    });
	    return false;
	}
    const jsonData = window.btoa(unescape(encodeURIComponent(JSON.stringify(dataJson.data))));
    console.log("Encoded Base64 JSON >>>", jsonData); // Optional for debugging

    // Step 2: Create a temporary form element
    const form = document.createElement("form");
    form.method = "POST";
    form.action = "/CGHSCardMgmt/FormFlowXACTION";
    form.style.display = "none";
    form.target = "_blank"; 

    // Step 3: Add required hidden inputs

    // hmode for server to recognize the operation
    const hmodeInput = document.createElement("input");
    hmodeInput.type = "hidden";
    hmodeInput.name = "hmode";
    hmodeInput.value = "downloadExcelFromBase64"; // Your defined mode
    form.appendChild(hmodeInput);

    // jsonData (Base64-encoded payload)
    const jsonDataInput = document.createElement("input");
    jsonDataInput.type = "hidden";
    jsonDataInput.name = "jsonData";
    jsonDataInput.value = jsonData;
    form.appendChild(jsonDataInput);

    // Optional: filename or extension if server supports it
    const fileNameInput = document.createElement("input");
    fileNameInput.type = "hidden";
    fileNameInput.name = "fileName";
    const currentDate = getCurrentDateFormatted();
    fileNameInput.value = currentDate+".xlsx"; // Optional - depends on backend
    form.appendChild(fileNameInput);

    // Step 4: Submit form and remove it from DOM
    document.body.appendChild(form);
    form.submit();
    document.body.removeChild(form);
}





function getCurrentDateFormatted() {
    const today = new Date();

    const day = today.getDate().toString().padStart(2, '0');

    const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
                        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    const month = monthNames[today.getMonth()];

    const year = today.getFullYear();

    return `${day}-${month}-${year}`;
}



