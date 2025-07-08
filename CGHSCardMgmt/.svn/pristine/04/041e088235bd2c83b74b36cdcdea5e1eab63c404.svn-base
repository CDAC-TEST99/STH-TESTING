$(document).ready(function () {
		initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		
		var arrpk = (primaryKeyFromListPage).split("^");
		//alert("Benidvalue>>>>>>>>>>"+arrpk[0]);
		var Benid=arrpk[0];
		//$('#BenId').val(arrpk[0]);
	
	  //   alert("key>>>>>>>>>>>"+arrpk);
		//gettrackingid();
	//	getfamilydetails();
	
	     
 /* var configJson={
    				serviceName:"/getData/getfamilymembers",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);*/
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

          //alert("11111"+Benid);
           if(Benid=='')
            {
             	alert("Plesae enter Mobile no");
	           return;
	
              }
              
            
  var configJson={
    				serviceName:"/getData/getfamilymembers",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
              }
              function populatefamilymembers(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
    } else {
        let indx = 1;
        $("#AutoNumber1 tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
                var modifyflag = json["is_modify"];
                var cardapprovedby = json["card_approved_by"];
                var benid = json["memberid"];
                var validupto = json["validupto"];
                
                var relationvalue=json["Relation"];
              //  alert("relationvalue>>>>>>>>"+relationvalue);
                 if (relationvalue === 'Self') {
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
                html += "<td>" + json["gstr_card_color"] + "</td>";
                
                // We call getFileFromFileName asynchronously
                getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
                    if (result) {
                        var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
                        var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                        //console.log("base64Image: ", base64Image);

                        // Add the base64 string as an image tag inside a table cell
                        html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";
                    } else {
                        // Handle the error when result is not valid
                        html += "<td>No image available</td>";
                    }
                    // Add the button if modifyflag is 0 or an image is available
                  

                    // If the card is not approved by the Additional Director, show that info
                    if (modifyflag == 1) {
                        html += "<td> Card is Not Approved by Additional Director.</td>";
                    }else  if (modifyflag == 0 || result) {
                        html += "<td><i class='fa-solid fa-download fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='Downloadcard(\"" + json["memberid"] + "\")' ></i></td>";
                    } else {
                        // If modifyflag is not 0 and no image is available, hide the download button
                        html += "<td>No Download Available</td>";
                    }
                    
       /*             html += "<td><i class='fa-solid fa-calendar-days fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='raiseAppointment(\"" + json["memberid"] + "\")' ></i></a></td>";
                    html += "<td style='text-align: center; vertical-align: middle;'><i class='fa-solid fa-file-medical fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='myEMRDetail(\"" + json["memberid"] + "\")'></i>";
//*/
                    // Append the HTML row after the image has been processed
                   // $("#AutoNumber1 tbody").prepend(html);
                    //$("#AutoNumber1").show();
                    
                     $('#AutoNumber1 tbody').prepend(html); // prepend adds it at the beginning
                      $("#AutoNumber1").show();
                     //$('#AutoNumber1 tbody tr:last-child').css("background-color", "#F0F8FF"); // Alice blue color for others
                     
                });

                indx++;
                }
                else{
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
                html += "<td>" + json["gstr_card_color"] + "</td>";
                
                // We call getFileFromFileName asynchronously
                getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
                    if (result) {
                        var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
                        var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                        //console.log("base64Image: ", base64Image);

                        // Add the base64 string as an image tag inside a table cell
                        html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";
                    } else {
                        // Handle the error when result is not valid
                        html += "<td>No image available</td>";
                    }
                    // Add the button if modifyflag is 0 or an image is available
                  

                    // If the card is not approved by the Additional Director, show that info
                    if (modifyflag == 1) {
                        html += "<td> Card is Not Approved by Additional Director.</td>";
                    }else  if (modifyflag == 0 || result) {
                        html += "<td><i class='fa-solid fa-download fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='Downloadcard(\"" + json["memberid"] + "\")' ></i></td>";
                    } else {
                        // If modifyflag is not 0 and no image is available, hide the download button
                        html += "<td>No Download Available</td>";
                    }
                    
       /*             html += "<td><i class='fa-solid fa-calendar-days fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='raiseAppointment(\"" + json["memberid"] + "\")' ></i></a></td>";
                    html += "<td style='text-align: center; vertical-align: middle;'><i class='fa-solid fa-file-medical fa-xl' style='color: rgba(64,63,129,1);cursor: pointer;' onclick='myEMRDetail(\"" + json["memberid"] + "\")'></i>";
//*/
                    // Append the HTML row after the image has been processed
                    $("#AutoNumber1 tbody").append(html);
                    $("#AutoNumber1").show();
                });

                indx++;
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
	
	function raiseAppointment(benId){
		//alert(benId)
		
		$('#strCrNo').val(benId);
		
		 $('#plasticCardForm').attr('action', '/CGHSAppointment/FormFlowXACTION');
		 submitFormMaster("onlineAppointment","add");
		 
		 
		
	}
	
	
	
function Downloadcard(memberid, callback) {
  //  alert("1111111111");
    
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/getBeneficiaryCard',
        type: 'POST',
        contentType: 'application/json',  // Set content type to application/json
        data: JSON.stringify({ benId: memberid }),  // Send the file name as JSON
        success: function(response) {
        //    alert("response>>>>>>>>>>>>>>> " + JSON.stringify(response)); // Ensure response is in string format
            
            console.log('Data received:', response);

            // Assuming response.result contains the base64 PDF string
            if (response && response.result) {
                const base64PDF = response.result;
                downloadBase64PDF(base64PDF, "benId.pdf");
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
/*function downloadBase64PDF(base64String, fileName = "file.pdf") {
    const linkSource = `data:application/pdf;base64,${base64String}`;
    const downloadLink = document.createElement("a");
    downloadLink.href = linkSource;
    downloadLink.download = fileName;
    downloadLink.click();
}*/

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
	alert("4444444444");
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
	 alert("1111111111111");
	
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



function myEMRDetail(crno) {
	
	//String varSSOTicketGrantingTicket = (String)request.getAttribute("varSSOTicketGrantingTicket");
	
	//System.out.println("benEMr>>>>> " + varSSOTicketGrantingTicket);
	//alert($('#varSSOTicketGrantingTicket').val());
	var ticket = $('#varSSOTicketGrantingTicket').val();
	window.location = "/emrdashboard/patientOverviewAction.cnt?hmode=DETAIL&crno=" + crno+ "&ticket=" + ticket +"&benEmr=1" ; 
}