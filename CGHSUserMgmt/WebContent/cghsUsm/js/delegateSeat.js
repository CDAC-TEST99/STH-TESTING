listPageConfigJson = {
	"containerId": "LISTPAGE",
	"listPageHeading": "Deligate Role",
	"listServiceName": "/getData/getDeligatelist",
	"noOfRecordPerPage": "10",
	"isCheckBoxRequired": false,
	"noSearchSortColumnNo": [1, 2],
	"filters": [
		{
			"filterId": "filterRecordStatus",
			"filterLabel": "Deligate Status",
			"filterType": "combo",
			"defaultOption": { "optionValue": "1", "optionText": "Access Given" },
			"serviceName": "/getData/getDeligatestatus"
		}
	],
	"buttons": [{
		"buttonName": "Deligate",
		"buttonDisplayName": "Deligate",
		"buttonClass": "btn-his-sm text-white  btn-sm",
		"buttonIcon": "fas fa-plus-circle",
		"onClickFunction": "listInitAddPage()",
	},
	{
		"buttonName": "btnDelete",
		"buttonDisplayName": "Revoke",
		"buttonClass": "btn btn-danger btn-sm selectbtn singleSelect",
		"buttonIcon": "fas fa-trash",
		"onClickFunction": "listPageDeleteSingleRecordDtl(this)",
		"onClickServiceName": "/DMLSAVE/revokeDeligatedAccess"
	},
	{
		"buttonName": "btnView",
		"buttonDisplayName": "View",
		"buttonClass": "btn btn-default btn-info text-white  btn-sm selectbtn singleSelect",
		"buttonIcon": "fas fa-eye",
		"onClickFunction": "getViewDtl",
		"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupMstView"
	}
	]
}

$(document).ready(function() {
	//initPage();

	$('#LISTPAGE').removeClass('hideData');
	hidePreloader();
	createListPage(listPageConfigJson);

	$('#myDetailsTable').on('change', 'tbody input[type="radio"]', function() {
		updateSelectedSeatIds();
	});

	/*$('#selectAllCheckbox').on('change', function() {
		const isChecked = $(this).is(':checked');
		$('#myDetailsTable tbody input[type="checkbox"]').prop('checked', isChecked);
		updateSelectedSeatIds(); // Update hidden field when "Select All" is toggled
	});*/

	var seatId = $('#seatId').val();

	if (!seatId) {
		console.error("Seat ID is missing.");
		return;
	}
	
	$('#menuIds').bootstrapDualListbox({
		nonSelectedListLabel: 'Available Records',
		selectedListLabel: 'Selected Records',
		moveOnSelect: false
	})

	$('#efectiveTo').datepicker({
		dateFormat: 'dd-M-yy',
		minDate: "0D",
		changeMonth: true,
		changeYear: true,
		onSelect: function(dateText, inst) {
			validateFormData($(this));
		}
	});


	$("#cityDropdown").change(function() {

		var inputData1 = { "cityId": this.value };
		var configHospital1 = {
			serviceName: "/getData/gethospitaluserbased",
			inputData: inputData1,
			callBackFunctionName: "commonPopulateCombo",
			comboId: "hospitalDropdown",
			defaultOption: { "optionValue": "", "optionText": "Select Hospital" }
		}
		callService(configHospital1);
	});

	$("#fromcityDropdown").change(function() {
			//alert(this.value)
		var inputData1 = { "cityId": this.value };
		var configHospital1 = {
			serviceName: "/getData/gethospitaluserbased",
			inputData: inputData1,
			callBackFunctionName: "commonPopulateCombo",
			comboId: "fromhospitalDropdown",
			triggerChange: "No",
			defaultOption: { "optionValue": "", "optionText": "Select Hospital" }
		}
		callService(configHospital1);
	});

	$("#hospitalDropdown").change(function() {
		var hospitalId = $(this).val() == "" ? "0" : $(this).val();
		var fromUserId = $('#fromuserDropdown').val() == "" ? "0" : $('#fromuserDropdown').val();
		var configJson = {
			serviceName: "/getData/getToUserNamesForDeligation",
			primaryKeys: [hospitalId, fromUserId],
			comboId: "userDropdown",
			callBackFunctionName: "commonPopulateCombo",
			defaultOption: { "optionValue": "", "optionText": "Select User Name" }
		};
		callService(configJson);
	});

	$("#fromhospitalDropdown").change(function() {
		var hospitalId = $(this).val();
		var configJson = {
			serviceName: "/getData/getFromUserNamesForDeligation",
			primaryKeys: [hospitalId],
			comboId: "fromuserDropdown",
			callBackFunctionName: "commonPopulateCombo",
			defaultOption: { "optionValue": "", "optionText": "Select User Name" }
		};
		//alert(JSON.stringify(configJson))
		callService(configJson);
	});


	$("#fromuserDropdown").change(function() {

		var logedInSeat = $(this).val() == "" ? "0" : $(this).val();
		
		$('#roleDiv').addClass('hideData');
		
		$('#menuIds').empty();

		if (logedInSeat != "0") {

			$('#delegateToDiv').removeClass('hideData');
			$('#seatAvlDiv').removeClass('hideData');

			$("#hospitalDropdown").trigger('change');


		}
		else {
			$('#delegateToDiv').addClass('hideData');
			$('#seatAvlDiv').addClass('hideData');
		}

		//alert(logedInSeat);

		var configJson = {
			serviceName: "/getData/getseatdetailsbyuserid",
			primaryKeys: [logedInSeat],
			callBackFunctionName: "populateSeatTable",
		};
		callService(configJson);
	});



	$('#cancelTransferBtn').click(backToListPage);

	$('#clearTransferBtn').click(listInitAddPage);
});

function listInitAddPage() {
	//alert('hh')
	hidePreloader();
	$('#LISTPAGE').addClass('hideData');
	$('#ENTRYFORM').removeClass('hideData');
	initValidation('ENTRYFORM');
	initInputJson = $(':input').serializeArray();
	//resetForm();

	populateCity();
	//populateUserName();
	//loadDelegateDetails();
}

function loadDelegateDetails() {
	const seatId = $('#seatId').val();
	if (!seatId) {
		console.error("Seat ID is missing.");
		return;
	}
	var configJson = {
		serviceName: "getDelegateDetails",
		inputData: { seatId: seatId },
		callBackFunctionName: "populateDelegateDetailsTable"
	};
	callService(configJson);
}
function populateDelegateDetailsTable(configJson, dataJson) {
	const tableBody = $('#currentDelegateDetailsTable tbody');
	tableBody.empty();

	if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
		tableBody.append(`
            <tr>
                <td colspan="6">No delegate details available.</td>
            </tr>
        `);
		return;
	}

	dataJson.data.forEach((row, index) => {
		const hiddenField = `<input type="hidden" name="delegateId_${index}" value="${row.DelegateId}" id="delegateId_${index}" />`;

		const html = `
            <tr>
                <td>${row.CityName || 'N/A'}</td>
                <td>${row.HospitalName || 'N/A'}</td>
                <td>${row.UserName || 'N/A'}</td>
                <td>${row.SeatName || 'N/A'}</td>
                <td>${row.DelegateDate ? new Date(row.DelegateDate).toLocaleDateString() : 'N/A'}</td>
                <td>
                    <i class="fas fa-trash-alt text-danger" style="cursor: pointer;" onclick="revokeDelegate(${index})"></i>
                </td>
            </tr>
            ${hiddenField}  
        `;
		tableBody.append(html);
	});
}

function revokeDelegate(delegateIndex) {
	const delegateId = document.getElementById('delegateId_' + delegateIndex).value;
	console.log('Revoke called with Delegate ID:', delegateId);

	if (!delegateId) {
		console.error("Delegate ID is missing.");
		return;
	}

	var inputData = { "delegateId": delegateId };

	var configJson = {
		serviceName: "/DMLSAVE/setrevokeDelegate",
		inputData: inputData,
		callBackFunctionName: "handleRevokeResponse",
	};

	console.log('Config for service:', configJson);

	callService(configJson);
}

function handleRevokeResponse(response) {
	console.log('Service Response:', response);

	if (response && response.returnValue === "SUCCESS") {
		alert("Delegate successfully revoked.");
		refreshDelegateTable();
	} else {
		alert("Delegate successfully revoked.");
	}
}


function populateCity() {

	var configJson = {
		serviceName: "/getData/getcitybasedonuser",
		comboId: "fromcityDropdown",
		callBackFunctionName: "commonPopulateCombo",
		defaultOption: { "optionValue": "", "optionText": "Select City" }

	}
	callService(configJson);


	var configJson = {
		serviceName: "/getData/getcitybasedonuser",
		comboId: "cityDropdown",
		callBackFunctionName: "commonPopulateCombo",
		defaultOption: { "optionValue": "", "optionText": "Select City" }

	}
	callService(configJson);
}
function saveDelegate() {
	try {

		if (ValidateForAllVisible("ENTRYFORM") === false) {
			return;
		}
		
		if ( $('#menuIds').val() == '') { 
		 alert(" Map atleast one Menu.")
		 return; 
	}

		var inputData = processSerializeArray("ENTRYFORM");

		if ($('#hiddenSeatIds').val() == "") {
			alert("Please Select Seat!!");
			return;
		}

		var config = {
			serviceName: "saveDelegateRequest",
			inputData: inputData,
			callBackFunctionName: "handleSaveDelegateResponse"
		};

		callService(config);
	} catch (error) {
		console.error("Error in Delegate Save:", error);
	}
}
function handleSaveDelegateResponse(configJson, dataJson) {
	if (dataJson["message"].indexOf("ERROR") >= 0) {
		showMsg(dataJson["message"], null)
	}
	else {
		var dialogConfigJson = { callOnOK: "backToListPage", "parameterJson": {} }

		showMsg(dataJson["message"], dialogConfigJson);

	}
}

function backToListPage() {

	$('#masterKey').val("DelegateSeat");
	submitFormWithResetTextField("CallMasterPage");
}

function populateSeatTable(configJson, dataJson) {
	console.log("Seat Details Response:", dataJson);

	const tableBody = $('#myDetailsTable tbody');
	tableBody.empty();

	if (dataJson.message && dataJson.message.indexOf("ERROR") >= 0) {
		showAlertMsg("Error fetching seat details!", "danger", "alertMsg");
		return;
	}

	if (dataJson.data && dataJson.data.length > 0) {
		dataJson.data.forEach((row, index) => {
			const html = `
                <tr data-seat-id="${row.gnum_seatid}">
                    <td><input type="radio" /></td>
                    <td>${row.gstr_seat_name || 'N/A'}</td>
                </tr>
            `;
			tableBody.append(html);
		});
	} else {
		tableBody.append(`
            <tr>
                <td colspan="3">No seat details available.</td>
            </tr>
        `);
	}
}

function updateSelectedSeatIds() {
	const selectedSeatIds = [];

	// Collect selected seat IDs
	$('#myDetailsTable tbody input[type="radio"]:checked').each(function() {
		const seatId = $(this).closest('tr').data('seat-id'); // Assuming seat ID is stored in a data attribute
		if (seatId) {
			selectedSeatIds.push(seatId);
			$('#roleDiv').removeClass('hideData');
			
			var hospId=$("#fromhospitalDropdown").val();
			 

			var configJson = {
				serviceNameLeftList: "/getData/getseatmenus",
				comboId: "menuIds",
				primaryKeysLeftList:[hospId,seatId]
			}
			commonDualListPopulate(configJson);
		}
	});

	// Update the hidden input field
	const concatenatedSeatIds = selectedSeatIds.join(',');
	$('#hiddenSeatIds').val(concatenatedSeatIds);

	// Log the selected seat IDs for debugging
	console.log('Selected Seat IDs:', concatenatedSeatIds);
}



function resetForm() {
	$("#fromcityDropdown").val("");
	$("#fromhospitalDropdown").empty().append('<option value="">Select Hospital</option>');
	$("#fromuserDropdown").empty().append('<option value="">Select User</option>');
	$("#cityDropdown").val("");
	$("#hospitalDropdown").empty().append('<option value="">Select Hospital</option>');
	$("#userDropdown").empty().append('<option value="">Select User</option>');
	$('#myDetailsTable tbody').empty();
	$('#delegateToDiv').addClass('hideData');
	$('#seatAvlDiv').addClass('hideData');


}