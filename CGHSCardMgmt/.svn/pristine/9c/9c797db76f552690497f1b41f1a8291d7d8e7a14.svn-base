$(document).ready(function () {
		initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#PatTrackingid').val(arrpk[1]);
		$('#PatTrackingidLbl').text("Tracking Id :" + arrpk[1]);
		gettrackingid();
	}
	else{
		hidePreloader();
		$('#divTrackingIdEntry').show();
		$('#PatTrackingidLbl').hide();
	}
		
	
	   var configJson={
			serviceName:"/getData/getWellnesscenter",
			comboId:"PatientWc",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"},
		   
			
	   	}
	          callService(configJson);
	   	
	
	 $("#patcardvalidfrom").datepicker({
    // minDate: new Date(),  // Remove or comment this out to allow dates before today
    dateFormat: "dd-M-yy",  // Format the date as day-month-year (e.g., 09-Nov-24)
    changeMonth: true,  // Allow the user to change the month
    changeYear: true,  // Allow the user to change the year
    showButtonPanel: true,  // Show the button panel (Today, Done)
    showOtherMonths: true,  // Show days from adjacent months
    selectOtherMonths: true,  // Allow selection of days from adjacent months
    yearRange: "-100:+100",  // Allow year range from 100 years ago to 100 years in the future
    onSelect: function(date, datepicker) {
        var id = $(datepicker).attr("id");
        $('#' + id).trigger('blur');  // Optional: trigger blur to close the datepicker or for validation
    }
});

$("#patcardvalidto").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	//yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });  
	
	
});
function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	}
	
	
		
    	function gettrackingid()
   	{
			var trackingid=document.getElementById('PatTrackingid').value;

    //      alert("11111"+trackingid);
           if(trackingid=='')
            {
             	alert("Plesae enter trackingid no");
	           return;
	
              }
              
               var configJson={
    				serviceName:"/getData/getpaymentdetailsforbeneficiary",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"PopulatePaymentdetails",
    			 				
    			}
    		callService(configJson);
              }
              
              
            
    	
    		function PopulatePaymentdetails(configJson, dataJson) {
    	   // alert("configJson>>> " + JSON.stringify(configJson));
    	//   alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	    $('#applyplastccard').show();
    	    }
    	    else
        	    {
							
						
					$('#paymentdetailsBeneficiary').show();
    	    	
    	    let indx = 1;
    	    const tableBody = $("#paymentdetailsBeneficiary tbody");
    	    tableBody.empty();
    	    var trackingId="";
    	    var mobileno="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
                  var statusflagapplication=json["statusid"];
					//alert("statusflagapplication");
					var trackingid=json["Trackingid"];
					//alert("trackingid>>>>"+trackingid);
				$('#hiddentrackingid').val(trackingid);
				
			let cardvalidityaplly = json["cardvalidity"]; // Get the value from your JSON (replace with actual data)
            let currentDate = new Date(); // Get the current date
        // Display the value for debugging
                //  alert("cardvalidityaplly: " + cardvalidityaplly);
              cardvalidityaplly = Number(cardvalidityaplly);  // Convert to number if it's a string

// Call the function to add the years dynamically
            let newDate1 = addYearsToDate(currentDate, cardvalidityaplly);
		//	alert("newDate1>>>>>>>>>>>>"+newDate1);
			
			$("#cardvalidtohidden").val(newDate1);
        	    	let html = "<tr>";
          	        html += "<td class='slno'>" + indx + "</td>";
          	        html += "<td>" + json["trackingid"] + "</td>"; 
          	        html += "<td>" + json["patname"] + "</td>";
          	        html += "<td>" + json["cardtype"] + "</td>";
                	/*  html += "<td>" + json["gstr_service_dept_name"] + "</td>";
                	  html += "<td>" + json["gnum_pay_scales"] + "</td>";
                	   html += "<td>" + json["cardvalidity"] + " year </td>";
                	   
                	    html += "<td>" + json["CPC"] + "</td>";
                        html += "<td>" + json["Amount"] + "</td>";
                         html += "<td>" + json["adcityname"] + "</td>";*/
                           html += "<td><a class='btn btn-his-sm'  onclick='viewItem()'>View Form</a></td>";
                       html += "<td><a class='btn btn-his-sm'  onclick='GenerateBenId()'>Verify</a></td>";

          	         
          	        html += "</tr>";
          	        mobileno=json["mobileno"] 
          	        trackingId=json["Trackingid"];
          	        tableBody.append(html);
            	    });
        	    
        	    var configJson={
          				serviceName:"/getData/getonlineformhtml",
          				primaryKeys:[mobileno],
          				callBackFunctionName:"populateonlineformhtml",
          			 				
          			}
          		callService(configJson);
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}
			
			
			

	    function populateonlineformhtml(configJson, dataJson) 
	    {
	    	 // alert("configJson populateonlineformhtml>>> " + JSON.stringify(configJson));
	    	 //alert("dataJson populateonlineformhtml>>>>>>>> " + JSON.stringify(dataJson));
	    	  if(dataJson["message"].indexOf("ERROR")<0){
	    	  $.each(dataJson["data"], function(_, json){
	    		  if (json.hasOwnProperty('formhtml')) {
	    	           // alert("formhtml: " + json["formhtml"]);

	    	          var decrypthtml=  decryptBase64(json["formhtml"])
	    	         // alert("decrypthtml>>>>>>>>>: "+ decrypthtml);
	    	          decrypthtml=decrypthtml.replace("#trackingId#", configJson["trackingId"]);
	    	          
	    	          document.getElementById("formContainer").innerHTML = decrypthtml;
	    	     
	    		    	        } else {
	    	            //alert("formhtml key not found in: " + JSON.stringify(json));
	    	        }
	    	  });

	    	}
	    	  else
		    	  {
	    		  showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
	    	    	return;
		    	  }
	    }


    	function viewItem()
    	{
        	//alert("11111111");        	
            $('#myModal').modal('show');
        }
    	  
	
function handleDecision()

{
	
	 const approveButton = document.getElementById('approve');
        const rejectButton = document.getElementById('reject');
	 if (approveButton.checked) {
                alert("You have approved.");
                $('#remarksbox').hide();
                $('#statusflag').val("4")
            } else if (rejectButton.checked) {
               alert("You have rejected.");
                $('#statusflag').val("8")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
            }
       } 	  
  function GenerateBenId()
{
	 alert("1111111111111");
	   $('#statusflag').val("6");
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
    alert("333333333");
    // Prepare the configJson object
    
    
    var configJson = {
        serviceName: "/DMLSAVE/OnlineBenidGeneratepensioner",
        callBackFunctionName: "callbackSaveData",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
  }
		
function callbackSaveData(configJson, dataJson){
	
	//alert(JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		
if (dataJson["message"].indexOf("ERROR") < 0) {
    // Parse the JSON string into an array
    try {
        var parsedMessage = JSON.parse(dataJson["message"]);
        
        // Ensure the parsed message is an array
        if (Array.isArray(parsedMessage)) {
            $.each(parsedMessage, function(_, json) {
				var firstBenId = parsedMessage[0]["benId"];
			//	  alert("firstBenId>>>>>>>>>>>>" + firstBenId);
                var Benid = json["benId"];
             //     alert("Benid>>>>>>>>"+Benid);
                var mainchflag=json["mainCardHolder"];
          
                $('#Benidvalue').val(firstBenId);
     
		showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
            });
        } else {
            alert("Parsed message is not an array!");
        }
    } catch (error) {
        alert("Error parsing JSON: " + error.message);
    }
} else {
    // Show an alert for invalid range
    showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
    return;
}

	}
}
	
  
function resetPage(){
//alert("iinn reset page");
	  submitFormMaster("PlasticCardPrint","add");	
}	

function addYearsToDate(currentDate, years) {
//	alert("years>>>>"+years);
    // Create a copy of the current date to avoid modifying the original
    let resultDate = new Date(currentDate);
    
    // Add the specified number of years
  resultDate.setFullYear(resultDate.getFullYear() + years);
  
    
    // Format the date as dd-mm-yyyy
    let day = resultDate.getDate().toString().padStart(2, '0'); // Get day and ensure 2 digits
    let month = (resultDate.getMonth() + 1).toString().padStart(2, '0'); // Get month and ensure 2 digits
    let year = resultDate.getFullYear(); // Get full year
    
    // Return formatted date
    return `${day}-${month}-${year}`;
}