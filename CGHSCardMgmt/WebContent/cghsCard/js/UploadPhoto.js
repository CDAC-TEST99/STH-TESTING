
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
			var Benid=document.getElementById('patBenId').value;

       //   alert("11111"+Benid);
           if(Benid=='')
            {
             	alert("Plesae enter Ben Id");
	           return;
	
              }
              
            
  var configJson={
    				serviceName:"/getData/getfamilymembersactivatePhotoUpload",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
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
                
                var dispshortname=json["gstr_hosp_short_name"];
              //  alert("dispshortname>>>>>>>"+dispshortname);
                var flag = json["flag"]; // Get the flag value from JSON
                let selfRow = null; // Variable to hold the "self" row data
                if (flag == 1) {
                    flag = "Active"; // If flag is 1, set it to "Active"
                } else {
                    flag = "DeActive"; // If flag is not 1, set it to "DeActive"
                }
                //    alert(json["Photoname"]);
                let html = "<tr>";
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["memberid"] + "</td>";
                html += "<td>" + json["memberName"] + "</td>";
                html += "<td>" + json["Dob"] + "</td>";
                html += "<td>" + json["Relation"] + "</td>";
                html += "<td>" + json["gender"] + "</td>";
                
                // Check if Photoname exists
                if (json["Photoname"]) {
                    // We call getFileFromFileName asynchronously
                        getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {

                        if (result) {
                            var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
                            var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                            // Add the base64 string as an image tag inside a table cell
                            html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";
                        } else {
                            html += "<td>No image available</td>";
                        }
                        
                        // Dynamically append content
                        html = html +  "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"showPopup('fileInput', 'preview" + json["memberid"] + "', 'hiddenFile" + json["memberid"] + "')\">Choose Photo</a></td>";
                        html = html + "<td><img id='preview" + json["memberid"] + "' src='#' alt='Preview" + json["memberid"] + "' style='display:none;width:70px;' /> <input type='hidden' id='hiddenFile" + json["memberid"] + "' /> </td>";
                        
/*                        html = html + "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"Upload('" + json["memberid"] + "', '#hiddenFile" + json["memberid"] + "')\">Upload Photo</a></td>";
*/                       
html = html + "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"Upload('" + json["memberid"] + "', '#hiddenFile" + json["memberid"] + "', '" + json["gstr_hosp_short_name"] + "')\">Upload Photo</a></td>";

 html += "<td>" + json["gstr_user_name"] + "</td>";
                        html += "<td>" + json["modifieddate"] + "</td>";
                        
                        // Append the row with the photo upload button
                        $("#AutoNumber1 tbody").append(html);
                        $("#AutoNumber1").show();

                        // Update the serial numbers (slno)
                        var index = 1;
                        $('.slno').each(function() {
                            $(this).text(index);
                            index++;
                        });
                    });
                } else {
                    // If Photoname does not exist, handle the "No image available" case
                    html += "<td>No image available</td>";
                    
                    // Dynamically append content
                    html = html +  "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"showPopup('fileInput', 'preview" + json["memberid"] + "', 'hiddenFile" + json["memberid"] + "')\">Choose Photo</a></td>";
                    html = html + "<td><img id='preview" + json["memberid"] + "' src='#' alt='Preview" + json["memberid"] + "' style='display:none;width:70px;' /> <input type='hidden' id='hiddenFile" + json["memberid"] + "' /> </td>";
                    
html = html + "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"Upload('" + json["memberid"] + "', '#hiddenFile" + json["memberid"] + "', '" + json["gstr_hosp_short_name"] + "')\">Upload Photo</a></td>";
                    html += "<td>" + json["gstr_user_name"] + "</td>";
                    html += "<td>" + json["modifieddate"] + "</td>";
                    
                    // Append the row with the photo upload button
                    $("#AutoNumber1 tbody").append(html);
                    $("#AutoNumber1").show();

                    // Update the serial numbers (slno)
                    var index = 1;
                    $('.slno').each(function() {
                        $(this).text(index);
                        index++;
                    });
                }
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
	
/*	
	function Upload(memberid, hiddenFileSelector) {
    // Retrieve the value from the hidden file input
    var fileValue = $(hiddenFileSelector).val();

    // Now you have access to both memberid and fileValue
    alert("Member ID: " + memberid);
   a("File Value: " + fileValue);

    // Further logic to upload or process the file, or handle any actions related to the member
    if (fileValue) {
        // Proceed with file upload logic
        console.log("Proceeding with file upload...");
        // Example: upload the file using AJAX or any other method
    } else {
        alert("No file selected for member " + memberid);
    }
}
*/


     function Upload(memberid, hiddenFileSelector,dispshortname) {
		 
		    var userid=$('#seatId').val()
		    
		 
    var base64String = $(hiddenFileSelector).val();
    var benIdvalue = memberid;
//  alert("dispshortname>>>>>>>>>"+dispshortname);
  
 // alert("benIdvalue>>>>>>>>>"+benIdvalue);
 //  alert("userid>>>>>>>>>"+userid);
    // Check if Base64 string is valid (non-empty)
    if (!base64String || base64String.trim() === '') {
        alert("No image data found!");
        return;
    }

    // Prepare the request data object
    var requestData = {
        "Base64imagefile": base64String,
        "benid": benIdvalue,
        "useridvalue":userid,
        "dispshortname":dispshortname
    };

    // Send the AJAX request
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/getconvertimageBase64tofile',  // URL of your REST service
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(requestData),  // Send the request data as JSON
        success: function(response) {
            // Handle the success response from the server
            if (response.status === 'success') {
                alert("Image uploaded successfully! File path: " + response.filePath);
                 getfamilydetails();
            } else {
                alert("Error: " + response.message);  // Show error message from server response
            }
        },
        error: function(xhr, status, error) {
            // Handle the error (in case the AJAX request fails)
            console.log("AJAX Error: " + status + " " + error);
            alert("An error occurred while uploading the image.");
        }
    });
}




function Downloadcard(memberid, callback) {
   // alert("1111111111");
    
    $.ajax({
        url: 'services/restful/parliament/v1/BenDetails/getBeneficiaryCard',
        type: 'POST',
        contentType: 'application/json',  // Set content type to application/json
        data: JSON.stringify({ benId: memberid }),  // Send the file name as JSON
        success: function(response) {
        //    alert("response>>>>>>>>>>>>>>> " + JSON.stringify(response)); // Ensure response is in string format
            
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

function downloadBase64PDF(base64Str, fileName) {
    try {
        const byteCharacters = atob(base64Str);
        const byteArrays = [];
        for (let offset = 0; offset < byteCharacters.length; offset += 1024) {
            const slice = byteCharacters.slice(offset, offset + 1024);
            const byteNumbers = Array.from(slice).map(char => char.charCodeAt(0));
            byteArrays.push(new Uint8Array(byteNumbers));
        }

        const blob = new Blob(byteArrays, { type: 'application/pdf' });
        const blobURL = window.URL.createObjectURL(blob);

        const link = document.createElement('a');
        link.href = blobURL;
        link.download = fileName;
        document.body.appendChild(link); // Append to the DOM
        link.click();
        document.body.removeChild(link); // Clean up
        window.URL.revokeObjectURL(blobURL); // Release memory
    } catch (error) {
        console.error('Error downloading PDF:', error);
    }
}


	
function ApprovebyAd()
{
	//alert("4444444444");
	 /*if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    */
   // showPreloader("Saving Data Please Wait !");
    alert("333333333");
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
var ctPreviewId = '';
var ctPreviewHiddenId = '';
var ctfileEvent = null;
var ctInputFileNameId = '';

  function showPopup(inputFileNameId , previewId , previewHiddenId) {
	  ctPreviewId = previewId;
	  ctPreviewHiddenId = previewHiddenId;
	  ctInputFileNameId = inputFileNameId
	  
      document.getElementById('popup').style.display = 'block';
      document.getElementById('overlay').style.display = 'block';
  }

  function hidePopup() {
      document.getElementById('popup').style.display = 'none';
      document.getElementById('overlay').style.display = 'none';
  }

  function uploadPhoto() {
	  
	
    document.getElementById(ctInputFileNameId).addEventListener('change', function(event) {
        const file = event.target.files[0];

        // Check if file exists and validate its size (10 KB = 10240 bytes)
        if (file && file.size <= 50000) {
            const reader = new FileReader();
            reader.onload = function(e) {
                document.getElementById(ctPreviewId).src = e.target.result;
                document.getElementById(ctPreviewHiddenId).value  = e.target.result;

                document.getElementById(ctPreviewId).style.display = 'block';
                document.getElementById('video').style.display = 'none';
                document.getElementById('capture').style.display = 'none';
                document.getElementById('canvas').style.display = 'none';
                hidePopup();
            };
            reader.readAsDataURL(file);

            $("#mainPhotoIdFeedBack").html(""); // Clear any previous error message
             
            
            hidePopup();
        } else {
            // Show error message if file is too large
            $("#mainPhotoIdFeedBack").html("Please upload a photo smaller than 50 KB.");
            
            document.getElementById(ctPreviewId).style.display = 'none';
            document.getElementById('video').style.display = 'none';
            document.getElementById('capture').style.display = 'none';
            document.getElementById('canvas').style.display = 'none';
        }
    });

    document.getElementById(ctInputFileNameId).click();
}


  function capturePhoto() {
        
     
	if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
		   // Access the camera
  navigator.mediaDevices.getUserMedia({ video: true })
      .then(function(stream) {
		 
          video.srcObject = stream;
          video.play();
          video.style.display = 'block';
          document.getElementById('capture').style.display = 'block';
      })
      .catch(function(err) {
          console.log("An error occurred: " + err);
          alert("Camera Permission Denied at Browser, Please Enable or Try to Upload Photo");
      });
  

		}else{
			alert("Camera Not Available; Please Try to Upload Photo");
		}
     
  }


  function captureActualPhoto(event){
		
      const context = canvas.getContext('2d');
      context.drawImage(video, 0, 0, 320, 240);
      const dataUrl = canvas.toDataURL('image/png');
      document.getElementById(ctPreviewId).src = dataUrl;
      document.getElementById(ctPreviewHiddenId).value  = dataUrl;
      
      document.getElementById(ctPreviewId).style.display = 'block';
      document.getElementById('video').style.display = 'none';
      document.getElementById('capture').style.display = 'none';
      document.getElementById('canvas').style.display = 'none';
	  stopVideoOnly(document.getElementById('video').srcObject );
		
		 $("#mainPhotoIdFeedBack").html("");
		
		 hidePopup();
	  
	 }
	
