$(document).ready(function() {
	
	console.log("inside payment process screen");
	
	initPage();
	
	
	var trackingid= $('#PatTrackingid').val();
	//alert("trackingid"+trackingid);
	
	
});

function initPage() {
		hidePreloader();
	
	checkStatus();
	
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');
	initInputJson = $(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	
	}function checkStatus() {
  //  $("#loader").show();
    var attempts = 0;  // Counter to track the number of attempts
    var startTime = new Date();  // Get the start time when the function begins
    var intervalId = setInterval(function() {
        // Calculate elapsed time in seconds
        var elapsedTime = Math.floor((new Date() - startTime) / 1000); // Elapsed time in seconds
        var minutes = Math.floor(elapsedTime / 60);  // Get minutes
        var seconds = elapsedTime % 60;  // Get seconds

        // Display the time with the loader
        document.getElementById("timeDisplay").innerHTML = "Elapsed Time: " + minutes + "m " + seconds + "s";

        $.ajax({
            url: "/CGHSCardMgmt/services/restful/bharatkosh/v1/bkpaystatus", // Correct URL
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({
                "tracking_id": $('#PatTrackingid').val()
            }),
            success: function(response) {
                console.log("Response: " + JSON.stringify(response)); // Log for debugging

                // Hide the loader as the response has been received
                document.getElementById("loader").style.display = "none";

                if (response.status === '1' || response.status === 1) {
                    // Show success message and green tick
                    document.getElementById("statusMessage").innerHTML = "Success! Payment successful.";
                    document.getElementById("statusMessage").style.color = "green";
                   // $('.tick').show(); // Show the green tick
                    $("#loader").hide();
                    // Stop checking further
                    clearInterval(intervalId);
                //      $("#downloadecard").show();
                    $( "#downloadecard" ).trigger( "click" );
                     
                  //  var trackingid = $('#trackingid').val();
                 //   window.location.href = "/downloadecard.jsp?trackingid=" + trackingid; 
                
                } else {
                    // Update status to processing
                    document.getElementById("statusMessage").innerHTML = "Processing... Please wait.";
                    document.getElementById("statusMessage").style.color = "orange";
                }
            },
            error: function(xhr, status, error) {
                // Handle error
                document.getElementById("statusMessage").innerHTML = "Error! Unable to reach the server.";
                document.getElementById("statusMessage").style.color = "red";

                // Hide loader and stop the checking
                $("#loader").hide();
                clearInterval(intervalId);
            }
        });

        attempts++;

        // Stop after 60 attempts (5 minutes)
        if (attempts >= 60) {
            document.getElementById("statusMessage").innerHTML = "Timeout! Unable to complete the operation.";
            document.getElementById("statusMessage").style.color = "red";
            $("#loader").hide();
            clearInterval(intervalId);  // Stop checking after 5 minutes
        }
    }, 10000); // Update every 10 second
}

   
function Download()
{
//	alert("iinnn method");
}



function saveData() {
	
	//alert("1111111111111");
	
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
   //  alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/onlinepensionerbenidgenerate",
        callBackFunctionName: "callbackSaveData",
        inputData: processSerializeArray("ENTRYFORM")
    };

   // var dependentJsonArray = configJson.inputData.dependentJson;
    /*var parsedDependentJsonArray = null;

    // Check if dependentJson exists and is an array or a string (to be parsed)
    if (dependentJsonArray && Array.isArray(dependentJsonArray)) {
        // If it's already an array, map it to parse JSON strings (if necessary)
        parsedDependentJsonArray = dependentJsonArray.map(function(jsonString) {
            return JSON.parse(jsonString);
        });

        // Update configJson with the parsed dependentJson array
        configJson.inputData.dependentJson = parsedDependentJsonArray;

        // Optional: Alert to check the configuration before sending
      //  alert("configJson>>>" + JSON.stringify(configJson));
    } else if (typeof dependentJsonArray === 'string') {
        // If it's a single JSON string, parse it into an array
        try {
            parsedDependentJsonArray = JSON.parse(dependentJsonArray);

            // If parsing is successful, wrap it in an array
            if (parsedDependentJsonArray) {
                configJson.inputData.dependentJson = [parsedDependentJsonArray];
            }
        } catch (error) {
            console.error("Error parsing dependentJson:", error);
        }
    } else {
        // Handle the case where there is no dependentJson data
        alert("No valid dependent data found. Proceeding without dependentJson.");
    }*/

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
	
// Check if message contains "ERROR"
if (dataJson["message"].indexOf("ERROR") < 0) {
    // Parse the JSON string into an array
    try {
		
		//alert(dataJson["message"]);
        var parsedMessage = JSON.parse(dataJson["message"]);
        //alert("parsedMessage>>>>>>>>>>>>"+parsedMessage);
        // Ensure the parsed message is an array
        if (Array.isArray(parsedMessage)) {
            $.each(parsedMessage, function(_, json) {
				var firstBenId = parsedMessage[0]["benId"];
				 $('#Benidvalue').val(firstBenId);
			var firstBenId = parsedMessage[0]["benId"];
				//  alert("firstBenId>>>>>>>>>>>>" + firstBenId);
                var Benid = json["benId"];
                //alert("Benid>>>>>>>>>>>>" + Benid);
                var mainchflag=json["mainCardHolder"];
             //alert("mainchflag>>>>>>>>>>>>" + mainchflag);
          
           // var imgBase64=json["imgBase64"];
          //  alert("imgBase64>>>>>>>>>>>>" + imgBase64);
               
          var message=json["message"];
         //   alert("message"+message);
        //    var imgBase64=json["imgBase64"];
             // alert("imgBase64"+imgBase64);
          
               
         //  alert("message>>>>>>>>>"+message);
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

submitFormMaster("PensionerafterpaymentCardprint","add")

	 /*submitFormMaster("PlasticCardPrint","add");	*/	
}
  
  