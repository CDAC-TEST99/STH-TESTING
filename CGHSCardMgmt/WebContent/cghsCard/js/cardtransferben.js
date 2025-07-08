$(document).ready(function () {
		initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
//	alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		
		var arrpk = (primaryKeyFromListPage).split("^");
		//alert("Benidvalue>>>>>>>>>>"+arrpk[0]);
		var Benid=arrpk[0];
		//$('#BenId').val(arrpk[0]);
	
	  //   alert("key>>>>>>>>>>>"+arrpk);
		//gettrackingid();
	//	getfamilydetails();
	
	      
	      
  var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatemaincardholder",
    			 				
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
    
    
var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCityto",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"}	
			
		}
	callService(configJson);

 $('#PatientCghsCityto').change(function(){
    	
	var configJson={
    			serviceName:"/getData/getADCityBasedonsatelliteCity",
      			callBackFunctionName:"populatecity",			
        		primaryKeys:[$('#PatientCghsCityto').val()],
    		}
    	callService(configJson);
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
	
		function populatecity(configJson, dataJson){
			//  alert("configJson>>> " + JSON.stringify(configJson));
    	
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               var parentcitycodevalue=json["parentcitycode"];
               $('#parentcitytocodehidden').val(parentcitycodevalue);
           
               var parentcityname=json["parentcityname"];
         // alert("parentcityname>>>>>>>>"+parentcityname);
			     $('#patadcity').val(parentcityname); 
			     
			     
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[parentcitycodevalue],
    		}
    	callService(configJson);
	
		
    });
			     
			   
                 
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
		}
		
		
    	function getfamilydetails()
   	{
			var Benid=document.getElementById('patBenId').value;

         // alert("11111"+Benid);
           if(Benid=='')
            {
             	alert("Plesae enter Ben Id ");
	           return;
	
              }
              
            
  var configJson={
    				serviceName:"/getData/getfamilymembers",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
              }
              
   function populatemaincardholder(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
    } else {
        let indx = 1;
        $("#AutoNumber1 tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
				
				var benid=json["BenId"];
			   $("#Benidhidden").val(json["BenId"]);
		//	   alert("adcity>>>>>>>>>>>>>>"+json["adcitycode"]);
			   
                let html = "<tr>";
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["BenId"] + "</td>";
                html += "<td>" + json["FirstName"] + "</td>";
                html += "<td>" + json["DOB"] + "</td>";
                html += "<td>" + json["gstr_relation_name"] + "</td>";
                html += "<td>" + json["gender"] + "</td>";
                html += "<td>" + json["gstr_hospital_name"] + "</td>";
                html += "<td>" + json["gstr_cardtype_name"] + "</td>";
                html += "<td>" + json["validupto"] + "</td>";
/*                html += "<td>" + json["gstr_card_color"] + "</td>";
 
*/                  html += "<td>" + json["parent_city_name"] + "</td>"; 
                // We call getFileFromFileName asynchronously
                getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
                   // alert("result>>>>>>>>>>>>>>>>>>>>>"+result); // Check the raw result
                    if (result) {
                        var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
                        var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                        // Check if base64 string is valid
                       // alert("base64Image: " + base64Image);
                        console.log("base64Image: ", base64Image);

                        // Add the base64 string as an image tag inside a table celljson["gstr_hospital_name"]
                        html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";

                        // Add the button after the image
                        html += "<td><a class='btn btn-his-sm' onclick='CardTransfer(\"" + json["BenId"] + "\", \"" +json["adcitycode"] + "\",\"" +json["parent_city_name"] + "\",\"" +json["currentwccode"] + "\")'>CardTransfer</a></td>";

/*            html += "<td><a class='btn btn-his-sm' onclick='CardTransfer(\"" + json["BenId"] + "\")'>CardTransfer</a></td>";
*/
                    } else {
                        // Handle the error when result is not valid
                        html += "<td>No image available</td>";

                        // Add the button when there's no image
                        html += "<td><a class='btn btn-his-sm' onclick='CardTransfer(\"" + json["BenId"] + "\", \"" +json["adcitycode"] + "\",\"" +json["parent_city_name"] + "\",\"" +json["currentwccode"] + "\")'>CardTransfer</a></td>";

                    }

                    // Append the HTML row after the image has been processed
                    $("#AutoNumber1 tbody").append(html);
                    $("#AutoNumber1").show();
                });

                indx++;
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}



function CardTransfer(memberid,adcity,adcityname,wccentercode)
{
	//alert("adcity>>>>>>>>>"+wccentercode);
	$("#Patientadcitycodepresent").val(adcity);
	$("#Benidhidden").val(memberid);
	$("#Patientadcitypresent").val(adcityname);
	$("#parentcitytocodehidden").val(adcity);
	$("#currentwccode").val(wccentercode);
	//alert("iinnn cardtranfer");
	
	 
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwcintracity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[adcity],
    		}
    	callService(configJson);
	$("#choosecity").show();
}


function transferincity()
{

	var value=$("#radio1").val();
	//alert("11111111"+value);
	$("#cardtranferflag").val("1");
	$("#cardtransferincity").show();
	$("#cardtransfer").hide();
	
}


function transferoutsidecity()
{
	$("#cardtranferflag").val("2");
	$("#cardtransfer").show();
	$("#cardtransferincity").hide();

}
function cardtransfersubmit()
{
	 var configJson = {
        serviceName: "/DMLSAVE/CardTransferRequest",
        callBackFunctionName: "callbackSaveDatatransfer",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
}

	
function callbackSaveDatatransfer(configJson, dataJson){
//	   alert("configJson>>> " + JSON.stringify(configJson));

	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPagetransfer","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPagetransfer(){

	//alert("Application Approved")
		Parent.closeModal();	

}
/*			  
	function Downloadcard(memberid)	
		{
		alert("benid>>>>>>"+memberid);
		
		$("#Benidvalue").val(memberid);
			 submitFormMaster("PlasticCardPrint","add");	
			 	

		
	}*/
	
	
function Downloadcard(memberid, callback) {
  //  alert("1111111111");
    
    $.ajax({
        url: 'services/restful/parliament/v1/BenDetails/getBeneficiaryCard',
        type: 'POST',
        contentType: 'application/json',  // Set content type to application/json
        data: JSON.stringify({ benId: memberid }),  // Send the file name as JSON
        success: function(response) {
            alert("response>>>>>>>>>>>>>>> " + JSON.stringify(response)); // Ensure response is in string format
            
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
	// alert("1111111111111");
	
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