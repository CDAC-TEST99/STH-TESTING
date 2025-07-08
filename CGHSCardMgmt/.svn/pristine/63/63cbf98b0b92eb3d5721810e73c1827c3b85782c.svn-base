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

	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear = toYear - 99;
	let maximumDate = 0
	let minimumDate = -36500
	$('.datepickerdob').datepicker({
		minDate : minimumDate,
		maxDate : maximumDate,
		"dateFormat" : "dd-M-yy",
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

	var configJson = {
		serviceName : "/getData/getGenderList",
		comboId : "patGender",
		callBackFunctionName : "callBackgetGenderList",
		defaultOption : {
			"optionValue" : "",
			"optionText" : "Select gender"
		}

	}
	callService(configJson);

	$('#patcardtype').change(function() {
		var cardvalue = $('#patcardtype').val();
		$('#cardtypevaluehidden').val(cardvalue)
	//	alert(cardvalue);
	});

	$('#BTNSAVE').click(saveData);

	$('#BTNCLEAR').click(resetPage);

}



    	function getfamilydetails()
   	{
		   alert("11111111");
		var BenIdvalue=$('#Benid').val();
		 alert("11111111+"+BenIdvalue);
  var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[BenIdvalue],			
    				callBackFunctionName:"populatemaincardholder",
    			 				
    			}
    		callService(configJson);
              }
              
  
             	function populatemaincardholder(configJson, dataJson) {
			 alert("populatemaincardholder");
    	  //alert("configJson>>> " + JSON.stringify(configJson));
    	//  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    	   if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   // $('#applyplastccard').show();
    	    }
    	    else
        	    {
					
				 	       	   //alert("iiinnn else"); 	
    	
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){

                  alert("222222222"+json["DOB"]);
                  $('#patName').val(json["FirstName"]);
                  
                  
                  $('#patDOB').val(json["DOB"]);
                  $('#patgender').text()
                   //  $('#cardbenid').text(json["BenId"]);
                     $('#cardbenidBack').text(json["BenId"]);
                     
                       $('#cardvalidupto').text(json["validupto"]);
        	    //	$('#cardentitlement').text(json["gnum_short_nm"]);
        	    //	$('#cardRelation').text(json["gstr_relation_name"]);
        	            	    
        	    //	var encodedStr=json["gstr_entitlement_hindi"];
        	    //	const decodedStr = decodeHtmlEntity(encodedStr);
        	    //	alert("decodedStr>>>>>>>>"+decodedStr);
        	    		//$('#cardentitlementHindi').text(decodedStr);
        	    	$('#patcardtype').val(json["gstr_cardtype_name"]);
        	    	//var cardnamehindi=json["gstr_card_hindi_name"];
        	    	//const decodedcardtypenamehindi= decodeHtmlEntity(cardnamehindi);
        	    	//	$('#cardtypenamehindi').text(decodedcardtypenamehindi);
        	    //	$('#photo').attr('src', json["photo"]);
        	    	
        	getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
							var base64Image = "data:image/jpeg;base64," + result;
        	    	        $('#photo').attr('src', base64Image);
						    console.log("Base64 Image:", base64Image);  // Do something with the result
						    alert("Base64 Image: " + base64Image);  // Use the result here
						});
        	    	
                  //  var color= json["gstr_card_color"].toLowerCase();  
                 //   alert("color"+color) ;
                   //  $('#cghsCard').addClass('cghs-card-'+color);
                   //  $('#cghsCardBack').addClass('cghs-cardback-'+color);
                     
                     
                     $("#linkwithpan").show();
        	    	
            	   });
            	    
            
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	  
    	  
    	}

function openpage() {
	var cardtypevalue = $('#cardtypevaluehidden').val();
	var panNumber = $('#patPanno').val();

	$('#panNumber').val(panNumber);
	alert("PAN Number = " + $('#panNumber').val());
	
	$('#hiddenId12').val(cardtypevalue);
	//    		submitFormMaster("onlineapplyplasticcard","add");	
	submitFormMaster("DAOnlinePensioner", "add");

}

function callBackgetGenderList(configJson, dataJson) {
	//alert(JSON.stringify(dataJson));
	commonPopulateCombo(configJson, dataJson);
}

function saveData() {

	if (ValidateForAllVisible("ENTRYFORM") == false)
		return;

	showPreloader("Saving Data Please Wait !");
	//alert(JSON.stringify(data));
	var configJson = {
		serviceName : "/DMLSAVE/saveTestData",
		callBackFunctionName : "callbackSaveData",
		fileUploadFlag : $('#fileUploadFlag').val(),
		inputData : processSerializeArray("ENTRYFORM")
	}
	callService(configJson);
}

function callbackSaveData(configJson, dataJson) {

	alert(JSON.stringify(dataJson));
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


function saveData1()
{
	
	/*var panno=$("#patPanno").val();
	$("#hiddenpan").val(panno);*/
	//alert("4444444444");
	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
   
   // showPreloader("Saving Data Please Wait !");
   // alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/LINKPanwithBen",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };

   

    // Call the service
    callService(configJson);
}


	
function callbackSaveData1(configJson, dataJson){
	
alert(JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage1(){
alert("iinn reset page");
	parent.closeModal();	
}

  
function getFileFromFileName(fileName, hospname, callback) {
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/gettestimg',
        type: 'POST',
        contentType: 'application/json',    // Sending JSON
        dataType: 'text',                   // Expecting plain text response
        data: JSON.stringify({ 
            filename: fileName, 
            hospname: hospname 
        }),
        success: function(response) {
            console.log('Data received:', response);
            if (typeof callback === 'function') {
                callback(response);
            } else {
                console.warn('Callback is not a function.');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            console.error('Status:', status);
            console.error('Response:', xhr.responseText);
            alert('An error occurred while processing your request.');
        }
    });
}



    function hexToUtf8(hex) {
        let str = '';
        for (let i = 0; i < hex.length; i += 2) {
            let hexChar = hex.substring(i, i + 2);
            str += String.fromCharCode(parseInt(hexChar, 16));
        }
        return str;
    }