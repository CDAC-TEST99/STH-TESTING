
$(document).ready(function () {
    
   initPage();

    
    // Populate the hospitals based on the selected city in cityDropdown
    $("#cityDropdown").change(function () {
        var cityId = $("#cityDropdown").val();
        var inputData1 = { "cityId": this.value };

        var configHospital1 = {
            serviceName: "/getData/getHospitalList",
            inputData: inputData1,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "hospitalDropdown",
            defaultOption: { "optionValue": "", "optionText": "Select Hospital" }
        };
        callService(configHospital1);
    });
    
   
    $('#cancelTransferBtn').click(backToListPage);
    
    $('#clearTransferBtn').click(initPage);
});
function populateTransferDetails(hospitalId) {
    const configJson = {
        serviceName: "/getData/getTempTransferDetailsToHospital",
        primaryKeys: [hospitalId],
        callBackFunctionName: "populateTransferTable"
    };
    callService(configJson); // Initiate the service call
}

function populateTransferTable(configJson, dataJson) {
    console.log("Transfer Details Response:", dataJson); 
    
    $('#transferDetailTableDiv').removeClass('hideData');

    const tableBody = $("#detailsTable tbody");
    tableBody.empty(); // Clear existing rows

    const orderNos = []; // Array to store Order Nos

    // Handle errors in the response
    if (dataJson.message && dataJson.message.indexOf("ERROR") >= 0) {
        showAlertMsg("Error fetching transfer details!", "danger", "alertMsg");
        return;
    }

    // Check if data is available
    if (dataJson.data && dataJson.data.length > 0) {
        // Iterate through the transfer data and populate the table
        dataJson.data.forEach((row, index) => {
			//alert(JSON.stringify(row));
			//alert(row.userId)
			const pk=row.orderNo+'^'+row.userId
            const orderNo = row.orderNo || ''; // Get Order No
            orderNos.push(orderNo); // Add Order No to array

            // Determine the action icon based on status
            let actionHtml = '';
            
            if (row.status === 'Revoked/Deleted') {
				actionHtml = '<i class="fas fa-times text-danger" title="Revoked/Deleted"></i>';
				}
				else if (row.status === 'Rejected') {
                actionHtml = '<i class="fas fa-times text-danger" title="Rejected"></i>';
            }
				else{
           /* if (row.status === 'Pending') {*/
                actionHtml = '<i class="fas fa-trash text-danger" title="Delete" style="cursor:pointer;" onclick="deleteTransfer(' + `'${pk}'` + ');"></i>';
            }
            /*} else if (row.status === 'Rejected') {
                actionHtml = '<i class="fas fa-times text-danger" title="Rejected"></i>';
            } else if (row.status === 'Approved') {
                actionHtml = '<i class="fa fa-check-square text-success" title="Accepted"></i>';
            }*/

            const html = `
                <tr data-index="${index}">
                    <td>${row.orderDate || ''}</td>
                    <td>${row.orderrefNo}</td>
                    <td>${row.toCity || ''}</td>
                    <td>${row.toHospital || ''}</td>
                    <td>${row.userName || ''}</td>
                    <td>${row.status || ''}</td>
                    <td>${actionHtml}</td>
                </tr>
            `;
            tableBody.append(html);
        });
    } else {
        // Display a message if no data is available
        tableBody.append(`
            <tr>
                <td colspan="7">No transfer details found for the selected hospital.</td>
            </tr>
        `);
    }

    // Update the hidden field with concatenated Order Nos
    $("#orderNoHiddenField").val(orderNos.join("|"));
    console.log("Updated Order Nos in Hidden Field:", $("#orderNoHiddenField").val());

    // Ensure the table container is visible
    $("#detailsTableContainer").show();
}

function deleteTransfer(orderNo) {
    var seatId = $("#seatId").val();
    var inputJson = {
        "primaryKeys": orderNo
    };

    const configJson = {
        serviceName: "/DMLSAVE/deleteTempTransferRequest",
        inputData: inputJson,
        callBackFunctionName: "handleDeleteResponse"
    };

    callService(configJson); 
}

function handleDeleteResponse(configJson, dataJson) {
    if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"backToListPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson);
		
	}
}

/*function listInitAddPage() {
    hidePreloader();
    $('#LISTPAGE').addClass('hideData');
    $('#ENTRYFORM').removeClass('hideData');
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
    populateCity();
   // populateUserType();
    //resetPages();
    populateCity2();
}*/
function initPage() {
    hidePreloader();
    resetTransferForm();
    initValidation('ENTRYFORM');
    //populateCity();
    var hospitalId=$('#hospitalCode').val();
    
   

         var configJson = {
                serviceName: "/getData/getUserNames",
                primaryKeys: [hospitalId],
                comboId: "userDropdown",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select User Name" }
            };
            callService(configJson);
    
    populateTransferDetails(hospitalId);
   
       
    
    
    populateCity2();
  //  populateUserType();
}

function resetTransferForm() {
    $('#transferDetailTableDiv').addClass('hideData');
    $("#detailsTable tbody").empty();
    $('#fromCityDropdown').val("");
    $("#fromHospitalDropdown").empty().append('<option value="">Select Hospital</option>');
    $("#userDropdown").empty().append('<option value="">Select User</option>');
    $("#cityDropdown").val("");
    $("#hospitalDropdown").empty().append('<option value="">Select User</option>');
    $('#orderNo').val("");
    $('#orderDate').val("");
    $('#remarks').val("");
    
}

// Populate the first city dropdown
function populateCity() {
    var configJson = {
        serviceName: "/getData/getCities",
        comboId: "fromCityDropdown",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select City" }
    };
    callService(configJson);
}

// Populate the second city dropdown
function populateCity2() {
    var configJson = {
        serviceName: "/getData/getcitybasedonuser",
        comboId: "cityDropdown",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select City" }
    };
    callService(configJson);
}


// Update the options in cityDropdown to exclude the selected city in fromCityDropdown
/*function updateCity2Options() {
    var selectedCity = $("#fromCityDropdown").val();
    $("#cityDropdown option").each(function () {
        if ($(this).val() === selectedCity) {
            $(this).hide(); // Hide the option
        } else {
            $(this).show(); // Show all other options
        }
    });

    // Reset cityDropdown if the current selection matches the hidden city
    if ($("#cityDropdown").val() === selectedCity) {
        $("#cityDropdown").val("").change();
    }
}*/
function saveTransfer() {
    try {
		
		if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
        }
		
		
        var inputData = processSerializeArray("ENTRYFORM");
        var config = {
            serviceName: "saveTempTransferRequest",
            inputData: inputData,
            callBackFunctionName: "handleSaveTransferResponse"
        };

        // Call the service
        callService(config);
        
    } catch (error) {
        console.error("Error in saveTransfer:", error);
    }
}


function handleSaveTransferResponse(configJson, dataJson) {
	   if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"backToListPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson);
		
	}
	}
	
function backToListPage(){
	
	$('#masterKey').val("tempTransfer");
	submitFormWithResetTextField("CallMasterPage");
}

/*function populateHospital(hospitalId){
	
	var configJson = {
                serviceName: "/getData/getFromTransferHospital",
                primaryKeys: [hospitalId],
                comboId: "fromHosp",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select Wellness Center" }
            };
            callService(configJson);
}	*/

