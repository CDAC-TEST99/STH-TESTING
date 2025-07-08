
$(document).ready(function () {
   /* $('#LISTPAGE').removeClass('hideData');*/
    hidePreloader();
	/*createListPage(listPageConfigJson);*/
    initPage();
    
    
    $('#cancelTransferBtn').click(backToListPage);
    
    $('#clearTransferBtn').click(backToListPage);
    
    $('#accepted').click(function(){
		
		$('#acceptSeatDropdown').val("");
		$('#joiningDate').val("");
		$('#defaultFlag').val("1");
		
		$('#acceptanceDetailsTableDiv').addClass('hideData');
	
    		 $("#acceptanceDetailsTable tbody").html("");
		
		if($(this).prop('checked')){
			
			$('#rejectionRemarks').attr("data-validation","");
			
			//initValidation('remarksDiv');
			
			removeValidation('remarksDiv');
			
			$('#acceptedDtls').removeClass('hideData');
			$('#rejectDtls').addClass('hideData');
		}
		else{
			$('#rejectDtls').removeClass('hideData');
			$('#acceptedDtls').addClass('hideData');
		}
	})
	
	$('#rejected').click(function(){
		
		//alert($(this).prop('checked'))
		
		$('#acceptSeatDropdown').val("");
		$('#joiningDate').val("");
		$('#defaultFlag').val("1");
		
		$('#acceptClass').addClass('hideData');
		
		$('#acceptanceDetailsTableDiv').addClass('hideData');
	
    		 $("#acceptanceDetailsTable tbody").html("");
		
		if($(this).prop('checked')){
			
			$('#rejectionRemarks').attr("data-validation","mandatory");
			
			initValidation('remarksDiv');
			
			
			$('#acceptedDtls').addClass('hideData');
			$('#rejectDtls').removeClass('hideData');
			
			
		}
		else{
			$('#rejectDtls').addClass('hideData');
			$('#acceptedDtls').removeClass('hideData');
		}
	})
	
	
    
    
    /*$("#toHosp").change(function () {
        var hospId=this.value!="" ? this.value:0;
        
        var inputData2 = { "hospitalId": hospId };

         var configSeat = {
            serviceName: "/getData/getSeatNames",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "acceptSeatDropdown",
            defaultOption: { "optionValue": "", "optionText": "Select Seat" }
        };
        callService(configSeat);
    });*/
    
	

    $("#acceptanceDetailsTable").on("click", ".delete-acceptance-row", function () {
        const rowIndex = $(this).data("index");

        // Remove the row from the data array
        acceptanceData.splice(rowIndex, 1);
         checkData.splice(rowIndex, 1);

        // Update the hidden field
        updateAcceptanceHiddenField();

        // Re-render the table
        renderAcceptanceDetailsTable();
    });
    $("#addDetailsIcon").click(function () {
        /*const cityId = $("#acceptCityDropdown").val(); // Fetch ID
        const hospitalId = $("#acceptHospitalDropdown").val(); // Fetch ID*/
        const seatId = $("#acceptSeatDropdown").val(); // Fetch ID
        const effectiveTo = $("#effectiveTo").val()==""?"--":$("#effectiveTo").val();

        /*const cityName = $("#acceptCityDropdown option:selected").text().trim(); // For display only
        const hospitalName = $("#acceptHospitalDropdown option:selected").text().trim(); // For display only*/
        const seatName = $("#acceptSeatDropdown option:selected").text().trim(); // For display only

        // Validate required fields
        if (seatId=="") {
            alert("Please select Seat.");
            return;
        }

        // Add row to the table
        addRowToAcceptanceDetailsTable(seatId,seatName, effectiveTo,$('#defaultFlag').val());
    });



});
/*function listInitAddPage() {
	 hidePreloader();
	    $('#LISTPAGE').addClass('hideData');
	    $('#ENTRYFORM').removeClass('hideData');
	    initValidation('ENTRYFORM');	
		initInputJson=$(':input').serializeArray();
		initPage();
}*/
let acceptanceData = [];
let checkData = [];
function addRowToAcceptanceDetailsTable(seatId,seatName,effectiveTo,isDefault) {
	
	$('#acceptanceDetailsTableDiv').removeClass('hideData');
	
	$('#acceptSeatDropdown').val("").trigger('change.select2');;
	$('#effectiveTo').val("");
	$('#defaultFlag').val("1").trigger('change.select2');
	var days="";
	
    const tableBody = $("#acceptanceDetailsTable tbody");
    
    if($('#allday').prop('checked')){
				days='MON,TUE,WED,THU,FRI,SAT,SUN';
			}
			
			if($('#selectDays').prop('checked')){
				days="";
				if (document.getElementById('edit_monday').checked) {
                          days += 'MON,';
                      }
                      if (document.getElementById('edit_tuesday').checked) {
                          days += 'TUE,';
                      }
                      if (document.getElementById('edit_wednesday').checked) {
                          days += 'WED,';
                      }
                      if (document.getElementById('edit_thursday').checked) {
                          days += 'THU,';
                      }
                      if (document.getElementById('edit_friday').checked) {
                          days += 'FRI,';
                      }
                      if (document.getElementById('edit_saturday').checked) {
                          days += 'SAT,';
                      }
                      if (document.getElementById('edit_sundday').checked) {
                          days += 'SUN,';
                      }

                      if (days.endsWith(',')) {
                          days = days.slice(0, -1);
                      }

			}

    // Concatenate IDs for the hidden field
    const rowData = `${seatId}^${effectiveTo}^${isDefault}^${days}`;
    const seatDtl=`${seatId}`;
    

    // Validate for duplicate entries
    if (checkData.includes(seatDtl)) {
        alert("This Seat already exists.");
        return;
    }
    
    var flag=0;
    
    if(isDefault==='1'){
		acceptanceData.forEach((row, index) => {
		
			var defaultFlag=row.split("^")[2];
			
			//alert(defaultFlag);
			
			if(defaultFlag==='1'){
				flag=1;			}
		
		});
		
		if(flag==1){
			alert("Default Seat Already Present");
			return;
		}
	}
    
    
		
    
	checkData.push(seatDtl)
	
	
	
	$('#toHosp').prop('disabled', true);
	
    // Add data to array
    acceptanceData.push(rowData);
    
    
		var defaultVal=(isDefault==1)? "Yes" : "No"    

    // Update hidden field
    updateAcceptanceHiddenField();

    // Add row to the table (visible format with names)
    const rowIndex = acceptanceData.length - 1;
    tableBody.append(`
        <tr data-index="${rowIndex}">
            <td>${seatName}</td>
            <td>${effectiveTo}</td>
            <td>${defaultVal}</td>
            <td>${days}</td>
            <td>
                <button class="btn btn-danger btn-sm delete-acceptance-row" data-index="${rowIndex}">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>
    `);

    // Ensure the table is visible
    $("#acceptanceDetailsTableSection").show();
}

	
function renderAcceptanceDetailsTable() {
    const tableBody = $("#acceptanceDetailsTable tbody");
    tableBody.empty();

    if (acceptanceData.length === 0) {
		$('#toHosp').prop('disabled', false);
        tableBody.append("<tr><td colspan='6'>No data available. Please add a row.</td></tr>");
        $("#acceptanceDetailsTableSection").hide();
        
        $('#acceptSeatDropdown').val("");
		$('#joiningDate').val("");
		$('#defaultFlag').val("1");
		
		$('#acceptanceDetailsTableDiv').addClass('hideData');
	
    		 $("#acceptanceDetailsTable tbody").html("");
        return;
    }

    acceptanceData.forEach((row, index) => {
        const [seat, effectiveTo, isDefault,days] = row.split("^");
        
        var defaultVal=(isDefault==1)? "Yes" : "No" 
        
       var seatName= $("#acceptSeatDropdown option[value='"+seat+"']").text();
        
        tableBody.append(`
            <tr data-index="${index}">
                <td>${seatName}</td>
                <td>${effectiveTo}</td>
                <td>${defaultVal}</td>
                <td>${days}</td>
                <td>
                    <button class="btn btn-danger btn-sm delete-acceptance-row" data-index="${index}">
                        <i class="fas fa-trash"></i>
                    </button>
                </td>
            </tr>
        `);
    });
}
function updateAcceptanceHiddenField() {
    $("#acceptanceHiddenField").val(acceptanceData.join("|"));
    console.log("Updated Hidden Field with IDs:", $("#acceptanceHiddenField").val());
}



function populateTransferDetails(hospitalId) {
    const configJson = {
        serviceName: "/getData/getTempTransferDetailsByHospital",
        primaryKeys: [hospitalId],
        callBackFunctionName: "populateTransferTable"
    };
    callService(configJson); // Initiate the service call
}

function populateTransferTable(configJson, dataJson) {
	
	$('#transferDetailTableDiv').removeClass('hideData');
	
    console.log("Transfer Details Response:", dataJson); // Debug the response

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
            const orderNo = row.orderNo || ''; // Get Order No
            orderNos.push(orderNo); // Add Order No to array

            const isDisabled = row.status === "Rejected" || row.status === "Approved" ? "disabled" : "";
            
            let actionHtml = '';
            if (row.status === 'Pending') {
                actionHtml = '<input type="radio" id="radioid_'+index+'" onclick="checkRadio(' + `'${orderNo}'` + ','+`'${row.drFlag}'`+');" />';
            } else if (row.status === 'Rejected') {
                actionHtml = '<i class="fas fa-times text-danger" title="Rejected"></i>';
            } else if (row.status === 'Approved') {
                actionHtml = '<i class="fa fa-check-square text-success" title="Accepted"></i>';
            }
            
            
            const html = `
                <tr data-index="${index}">
                    <td>${actionHtml}
                    </td>
                    <td>${row.refNo}</td>
                    <td>${row.orderDate || ''}</td>
                    <td>${row.fromCity || ''}</td>
                    <td>${row.fromHospital || ''}</td>
                    <td>${row.userName || ''}</td>
                    <td>${row.status || ''}</td>
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

function initPage() {
    hidePreloader();
    resetAcceptanceForm();
    initValidation('ENTRYFORM');
     var hospitalId=$('#hospitalCode').val();
     
    populateTransferDetails(hospitalId);
    populateHospital(hospitalId);
    
  
    
    //populateCity();
    //populateCity2();
}
//Populate the first city dropdown
function populateCity() {
    var configJson = {
        serviceName: "/getData/getCities",
        comboId: "toCityDropdown",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select City" }
    };
    callService(configJson);
}
//Populate the second city dropdown
function populateCity2() {
    var configJson = {
        serviceName: "/getData/getCities",
        comboId: "acceptCityDropdown",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select City" }
    };
    callService(configJson);
}
function resetAcceptanceForm() {
    $("form")[0].reset();
    $("#detailsTable tbody").empty();
    $("#detailsTableContainer").hide();
}
function saveTransfer() {
    try {
		
		
		if($('#accepted').prop('checked')){
			
			if (acceptanceData.length === 0) {
			
					alert("Please add atleast one Seat !!");
					
					return;
			
				
			}
			
			else{
				
				var flag=0;
				
				acceptanceData.forEach((row, index) => {
		
			var defaultFlag=row.split("^")[2];
			
			//alert(defaultFlag);
			
			if(defaultFlag==='1'){
				flag=1;			}
		
		});
		
		if(flag==0){
			alert("Please add one default seat!!");
			return;
		}
				
			}	
			
			
			
		}
		$('#toHosp').prop('disabled', false);
		
		 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
        }
		
		
        var inputData = processSerializeArray("ENTRYFORM");
        console.log("Serialized Input Data:", inputData);

        var config = {
            serviceName: "updateTemptransferrequest",
            inputData: inputData,
            callBackFunctionName: "handleSaveTransferResponse"
        };

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
	
	$('#masterKey').val("tempTransferApproval");
	submitFormWithResetTextField("CallMasterPage");
}


function checkRadio(orderId,drFlag){
	$("#acceptanceDetailsSections").removeClass('hideData');
	
	
	if(drFlag!=1){
		
		var hospId=$('#toHosp').val();
        
        var inputData2 = { "hospitalId": hospId,"docFlag":drFlag };

         var configSeat = {
            serviceName: "/getData/getSeatNames",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "acceptSeatDropdown",
            defaultOption: { "optionValue": "", "optionText": "Select Seat" }
        };
        callService(configSeat);
		
	}
	else{
		var hospId=$('#toHosp').val();
        
        var inputData2 = { "hospitalId": hospId,"docFlag":drFlag,"orderId":orderId };
		
		var configSeat = {
            serviceName: "/getData/getTempDrSeatName",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "acceptSeatDropdown",
            defaultOption: { "optionValue": "", "optionText": "Select Seat" }
        };
        callService(configSeat);
		
	}
	
	
	//$('#acceptanceDetailsTableDiv').removeClass('hideData');
	
	$("#orderId").val(orderId);
}

function populateHospital(hospitalId){
	
	var configJson = {
                serviceName: "/getData/getTempfromtransferhospital",
                primaryKeys: [hospitalId],
                comboId: "toHosp",
                callBackFunctionName: "commonPopulateCombo",
                defaultOption: { "optionValue": "", "optionText": "Select Wellness Center" }
            };
            callService(configJson);
}

function allDaysFunc(obj){
	
	if($(obj).prop('checked')){
			
			//$('#depDiv').addClass('hideData');
			$('#seatRunDiv').addClass('hideData');
					
	}
	
}

function selectDaysFunc(obj){
	
	if($(obj).prop('checked')){
			
			//$('#depDiv').addClass('hideData');
			$('#seatRunDiv').removeClass('hideData');
					
	}
	
}	




