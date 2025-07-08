$(document).ready(function () {
		initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
//	alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		
		var arrpk = (primaryKeyFromListPage).split("^");
	
	     
  var configJson={
    				serviceName:"/getData/getfamilymembers",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
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
	
	
		
    	function getfamilydetails()
   	{
			var trackingid=document.getElementById('PatTrackingid').value;

         alert("11111"+trackingid);
           if(trackingid=='')
            {
             	alert("Plesae enter Tracking Id");
	           return;
	
              }
              
         
    		
 var configJson={
    				serviceName:"/getData/getBeneficiarBharatkoshPaymentDetails",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"populateBharatkoshPaymentDetails",
    			 				
    			}
    		callService(configJson);
    		
    		
              }
              
              
          
      

  function populateBharatkoshPaymentDetails(configJson, dataJson) {
	  
	// alert("11111111111");
		if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
      showAlertMsg("No Data Found", "danger", "alertMsg");
      
      $("#paymentdiv").show();

    } else {
		
		
     
        $("#PaymentDetail tbody").empty();
       let  indx=1;

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
				 
			    let html = "<tr>";
              html += "<td class='paymentslno'>"+indx+"</td>";
                   html += "<td>" + json["trackingid"] + "</td>";
                   html += "<td>" + json["BenId"] + "</td>";
                    html += "<td>" + json["patname"] + "</td>";
                html += "<td>" + json["cardtype"] + "</td>";
                html += "<td>" + json["mobileno"] + "</td>";
                html += "<td>" + json["amount"] + "</td>";
				  html += "<td>" + json["utrnumber"] + "</td>";
				   html += "<td>" + json["Ordercode"] + "</td>";
				    html += "<td>" + json["paymentstatus"] + "</td>";
if (
  (!json["BenId"] || json["BenId"].trim() === '') &&
  (json["paymentstatus"] === 'SUCCESS' || json["paymentstatus"] === 'Success'))
  {
               html += `<td><a class="btn btn-his-sm" onclick="saveData()">Generate Benid</a></td>`;
                 }

 
                      $("#PaymentDetail tbody").append(html);
                    $("#PaymentDetail").show();
                     
         
               });    
                       
  var index = 1;
    $('.paymentslno').each(function() {
        $(this).text(index);
        index++;
            });
     
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}        
    function populatePaymentdetailsnic(configJson, dataJson)
    {
		 if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        showAlertMsg("No Data Found", "danger", "alertMsg");
    } else {
		    let indx = 1;
        $("#paymentdetailsnic tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
                
             
                
                var benid = json["memberid"];
                var flag = json["flag"]; // Get the flag value from JSON
                let selfRow = null; // Variable to hold the "self" row data
                
               
                
                let html = "<tr>";
                html += "<td class='paymentslno'>" + indx + "</td>";
                html += "<td>" + json["BenId"] + "</td>";
                html += "<td>" + json["BankName"] + "</td>";
                html += "<td>" + json["DD No"] + "</td>";
                html += "<td>" + json["Amount"] + "</td>";
                html += "<td>" + json["DD Date"] + "</td>";
                html += "<td>" + json["insert date"] + "</td>";
                html += "<td>" + json["paymentfrom"] + "</td>";
                html += "<td>" + json["paymentto"] + "</td>";
                
                    html += "</tr>";

                    // Append the row to the table body
                    $("#paymentdetailsnic tbody").append(html);
                    $("#paymentdetailsnic").show();

                    // Update the serial numbers (slno)
                    var index = 1;
                    $('.paymentslno').each(function() {
                        $(this).text(index);
                        index++;
                    });
               
                
                indx++; // Increase the index for the next row
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
	}          
              
              
         function populatefamilymembers(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        showAlertMsg("No Data Found", "danger", "alertMsg");
    } else {
        let indx = 1;
        $("#AutoNumber1 tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
                
             
                
                var benid = json["memberid"];
                var flag = json["flag"]; // Get the flag value from JSON
                let selfRow = null; // Variable to hold the "self" row data
                
                // Set flag value
                flag = (flag == 1) ? "Active" : "DeActive";
                
                let html = "<tr>";
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["memberid"] + "</td>";
                html += "<td>" + json["memberName"] + "</td>";
                html += "<td>" + json["Dob"] + "</td>";
                html += "<td>" + json["Relation"] + "</td>";
                html += "<td>" + json["gender"] + "</td>";
                html += "<td>" + json["gstr_hospital_name"] + "</td>";
                html += "<td>" + json["gstr_cardtype_name"] + "</td>";
                html += "<td>" + json["validupto"] + "</td>";
                   html += "<td>" + json["gnum_short_nm"] + "</td>";
                html += "<td>" + flag + "</td>";

                // We call getFileFromFileName asynchronously
                getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
                    // Check if result is valid
                    if (result) {
                        var cleanedBase64 = result.replace(/\s/g, ''); // Removes any spaces or newlines
                        var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                        // Add the base64 string as an image tag inside a table cell
                        html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";
                    } else {
                        // Handle the case when no image is available
                        html += "<td>No image available</td>";
                    }

                    // Add the Download button or leave empty if DeActive
                   /* if (flag === "DeActive") {
                        html += "<td></td>"; // If DeActive, leave it empty
                    } else {
                        html += "<td><a class='btn btn-his-sm' onclick='Downloadcard(\"" + json["memberid"] + "\")'>Download</a></td>";
                    }*/

                    html += "</tr>";

                    // Append the row to the table body
                    $("#AutoNumber1 tbody").append(html);
                    $("#AutoNumber1").show();

                    // Update the serial numbers (slno)
                    var index = 1;
                    $('.slno').each(function() {
                        $(this).text(index);
                        index++;
                    });
                });
                
                indx++; // Increase the index for the next row
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}


/*			  
	function Downloadcard(memberid)	
		{
		alert("benid>>>>>>"+memberid);
		
		$("#Benidvalue").val(memberid);
			 submitFormMaster("PlasticCardPrint","add");	
			 	

		
	}*/
	
	
function Downloadcard(memberid, callback) {
   // alert("1111111111");
    
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/getBeneficiaryCard',
        type: 'POST',
        contentType: 'application/json',  // Set content type to application/json
        data: JSON.stringify({ benId: memberid }),  // Send the file name as JSON
        success: function(response) {
            //alert("response>>>>>>>>>>>>>>> " + JSON.stringify(response)); // Ensure response is in string format
            
            console.log('Data received:', response);

            // Assuming response.result contains the base64 PDF string
            if (response && response.result) {
                const base64PDF = response.result;
                downloadBase64PDF(base64PDF, "memberid.pdf");
            } else {
                console.error("Base64 PDF data not found in response.");
            }
            
            // Check if callback is a function before calling it
            if (typeof callback === 'function') {
                callback(response); // Call the callback function and pass the result
            } else {
                console.error('Callback is not a function');
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


// Function to download PDF from base64 string
function downloadBase64PDF(base64Str, fileName) {
    // Decode base64 string into binary data
    const byteCharacters = atob(base64Str);
    const byteArrays = [];

    // Convert the byte characters to a byte array
    for (let offset = 0; offset < byteCharacters.length; offset += 1024) {
        const slice = byteCharacters.slice(offset, offset + 1024);
        const byteNumbers = new Array(slice.length);
        for (let i = 0; i < slice.length; i++) {
            byteNumbers[i] = slice.charCodeAt(i);
        }
        byteArrays.push(new Uint8Array(byteNumbers));
    }

    // Create a Blob from the byte array
    const blob = new Blob(byteArrays, { type: 'application/pdf' });

    // Create an object URL from the Blob
    const blobURL = URL.createObjectURL(blob);

    // Create an anchor element to trigger the download
    const link = document.createElement('a');
    link.href = blobURL;
    link.download = fileName;  // Set the desired file name
    link.click();  // Programmatically click the link to start the download

    // Release the object URL
    URL.revokeObjectURL(blobURL);
}


	
function ApprovebyAd()
{
	//alert("4444444444");
	 /*if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    */
   // showPreloader("Saving Data Please Wait !");
  //  alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/CardApprovedbyAd",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
}

	
function callbackSaveData1(configJson, dataJson){
	
//	alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage1(){
//alert("iinn reset page");
	alert("Application Approved")
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
                $('#statusflag').val("9")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
            }
       } 	  
  function GenerateBenId()
{
//	 alert("1111111111111");
	
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
   //  alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/OnlineBenidGenerate",
        callBackFunctionName: "callbackSaveData",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
  }
		
function callbackSaveData(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		//alert("callbackSaveData>>>\n"+ dataJson["message"]);
		var json =JSON.parse(dataJson["message"].replace("SUCCESS:", ""));
		var benId= json["benId"];
		$(Benidvalue).val(benId);
      	var cardNo=json["cardNo"];
      	$(cardnovalue).val(cardNo);
		showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
	}
}
	
  
function resetPage(){
//alert("iinn reset page");
	  submitFormMaster("DAOnlineBenidgenerate","add");	
}	


function getFileFromFileName(fileName, hospname, callback) {
//	alert("getFileFromFileName"+fileName);
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



function DownloadExcel()
{
	
	//alert("DownloadExcel");
	
	const table = document.getElementById('AutoNumber1');

    // Convert the table to a worksheet
    const ws = XLSX.utils.table_to_sheet(table);

    // Create a new workbook and append the worksheet
    const wb = XLSX.utils.book_new();
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');

    // Export the workbook to an Excel file
    XLSX.writeFile(wb, 'table_data.xlsx');
}  




function saveData() {
	
	alert("1111111111111");
	
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

   
    // Call the service
    callService(configJson);
}

	
function callbackSaveData(configJson, dataJson){
	
	
//alert(JSON.stringify(configJson));
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