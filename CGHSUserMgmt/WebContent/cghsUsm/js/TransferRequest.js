/* JS Script created on 28th November 2024 */
/*listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "Role Transfer",
	"listServiceName": "/getData/getSeatTransferList",
	"noOfRecordPerPage": "10",
	"noSearchSortColumnNo":[1,2],
	"filters":[
	           {"filterId":"filterfromCity",
			  		 "filterLabel":"City",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"","optionText":"Select City"},
			  		 "serviceName":"/getData/getCities"
				},
				 {"filterId":"filterfromHospital",
			  		 "filterLabel":"Hospital",
			  		 "filterType":"combo",
			  		 "parentFilterId":"filterfromCity",
			  		 "defaultOption":{"optionValue":"","optionText":"Select Hospital"},
			  		 "serviceName":"/getData/getHospitalForListpage"
				},
				 {"filterId":"filterseatStatus",
			  		 "filterLabel":"Seat Status",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"0","optionText":"Pending"},
			  		 "serviceName":"/getData/getseatStatus"
				}
			 ], 
	"buttons": [{
			"buttonName": "Add",
			"buttonDisplayName": "Add",
			"buttonClass": "btn btn-default btn-info text-white  btn-sm",
			"buttonIcon": "fas fa-plus-circle",
			"onClickFunction": "listInitAddPage()",
		},
		 /*{
			"buttonName": "Modify",
			"buttonDisplayName": "Modify",
			"buttonClass": "btn btn-default btn-info text-white btn-sm selectbtn singleSelect",
			"buttonIcon": "far fa-edit",
			"onClickFunction": "submittonew()",
			"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupDetailById",
			"masterkey":"ModifyUserMaster",
			"initMode":"modify",
		},*/
		/*{
			"buttonName": "btnDelete",
			"buttonDisplayName": "Delete",
			"buttonClass": "btn btn-danger btn-sm selectbtn",
			"buttonIcon": "fas fa-trash",
			"onClickFunction": "listPageDeleteRecordDtl()",
			"onClickServiceName": "/DMLSAVE/deleteSeat"
		},
		/*{
			"buttonName": "btnView",
			"buttonDisplayName": "View",
			"buttonClass": "btn btn-default btn-info text-white  btn-sm selectbtn singleSelect",
			"buttonIcon": "fas fa-eye",
			"onClickFunction": "getViewDtl",
			"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupMstView"
		}*/
	/*]
}*/
$(document).ready(function () {
    /*$('#LISTPAGE').removeClass('hideData');
    hidePreloader();
	createListPage(listPageConfigJson);*/
   initPage();

    // Populate the hospitals based on the selected city in fromCityDropdown
    /*$("#fromCityDropdown").change(function () {
        var cityId = $("#fromCityDropdown").val();
        var inputData1 = { "cityId": this.value };

        // Update the hospital dropdown
        var configHospital1 = {
            serviceName: "/getData/getHospitalList",
            inputData: inputData1,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "fromHospitalDropdown",
            defaultOption: { "optionValue": "", "optionText": "Select Hospital" }
        };
        callService(configHospital1);

        // Hide the selected city in the other dropdown
       // updateCity2Options();
    });*/
   /* $("#fromHospitalDropdown").change(function () {
        var hospitalId = $("#fromHospitalDropdown").val();
        if (!hospitalId) {
            alert("Please select a valid hospital.");
            return;
        }
        populateTransferDetails(hospitalId);
        var configJson = {
                serviceName: "/getData/getUserNames",
                primaryKeys: [hospitalId],
                comboId: "userDropdown",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select User Name" }
            };
            callService(configJson);
        
    });*/

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
    
     $("#fromHosp").change(function () {
        var hospId=this.value!="" ? this.value:0;

         var configJson = {
                serviceName: "/getData/getUserNames",
                primaryKeys: [hospId],
                comboId: "userDropdown",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select User Name" }
            };
            callService(configJson);
    });
    
    $('#cancelTransferBtn').click(backToListPage);
    
    $('#clearTransferBtn').click(initPage);
});
function populateTransferDetails(hospitalId) {
    const configJson = {
        serviceName: "/getData/getTransferDetailsToHospital",
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
            if (row.status === 'Pending') {
                actionHtml = '<i class="fas fa-trash text-danger" title="Delete" style="cursor:pointer;" onclick="deleteTransfer(' + `'${pk}'` + ');"></i>';
            } else if (row.status === 'Rejected') {
                actionHtml = '<i class="fas fa-times text-danger" title="Rejected"></i>';
            } else if (row.status === 'Approved') {
                actionHtml = '<i class="fa fa-check-square text-success" title="Accepted"></i>';
            }

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
        serviceName: "/DMLSAVE/deleteTransferRequest",
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
    
    populateTransferDetails(hospitalId);
    populateHospital(hospitalId);
       
    
    
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
        serviceName: "/getData/getCities",
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
            serviceName: "saveTransferRequest",
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
	
	$('#masterKey').val("TransferRequest");
	submitFormWithResetTextField("CallMasterPage");
}

function populateHospital(hospitalId){
	
	var configJson = {
                serviceName: "/getData/getFromTransferHospital",
                primaryKeys: [hospitalId],
                comboId: "fromHosp",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select Wellness Center" }
            };
            callService(configJson);
}	

