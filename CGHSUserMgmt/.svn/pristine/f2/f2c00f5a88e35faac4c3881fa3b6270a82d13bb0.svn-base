var tableData = []; 
var calledAfterAllAjax = new Array();
var userType;
$(document).ready(function () {
    initPage();
    
    
    
    $('#clearForm').click(initPage);
	
	$('#cancelForm').click(backToListPage);
	
	$('#govEmailCheck').change(function(){
		
		if($('#govEmailCheck').prop('checked')){
			$('#govEmailCheck').val(1);
			$('#patEmail').attr( 'data-validation','mandatory,govemail');
		}
		else{
			$('#patEmail').attr( 'data-validation','mandatory,email');
			$('#govEmailCheck').val(0);
		}
		
	});
	
	$('#efectiveFrom').datepicker({ 
		dateFormat : 'dd-M-yy',
       minDate: '0D',
       changeMonth: true,
       changeYear: true,
       onSelect: function (dateText, inst) {
           validateFormData($(this));
           var date = $(this).datepicker("getDate");
           date.setDate(date.getDate() + 1);
           
           $('#efectiveTo').val("");
           $('#efectiveTo').datepicker("option","minDate", date);
        }
   });
	
	
	$('#efectiveTo').datepicker({ 
		dateFormat : 'dd-M-yy',
       yearRange: '2010:2080',
       changeMonth: true,
       changeYear: true,
      
   });
    
    

        // Add Row Button Click
    $("#addRowBtn").click(function () {
        var cityId = $("#cityId").val();
        var hospitalId = $("#hospitalId").val();
        var seatId = $("#userSeatId").val();
        var cityName = $("#cityId option:selected").text();
        var hospitalName = $("#hospitalId option:selected").text();
        var seatName = $("#userSeatId option:selected").text();
        var effectiveTo=$('#efectiveTo').val();
        var effectiveFrom=$('#efectiveFrom').val();
        var days="";

        // Validate required fields
        if (!cityId || !hospitalId || !seatId || effectiveTo=="" || effectiveFrom=="") {
            alert("Please select all fields (City, Hospital, Seat,Effective From and EffectiveTo) before adding.");
            return;
        }
        
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

        // Create a row string concatenated with "^" (only IDs)
        var rowData = `${cityId}^${hospitalId}^${seatId}^${cityName}^${hospitalName}^${seatName}^${days}^${effectiveFrom}^${effectiveTo}`;

        // Check for duplicates in the array
        if (tableData.includes(rowData)) {
            alert("This combination of City, Hospital, and Seat already exists.");
            return;
        }

        // Add new row to the array
        tableData.push(rowData);

        // Update hidden field with IDs only
        updateHiddenField();

        // Add new row to the table (display with names for user visibility)
        var rowIndex = tableData.length - 1;
        $("#detailsTable tbody").append(`
            <tr data-index="${rowIndex}" 
                data-cityId="${cityId}" 
                data-hospitalId="${hospitalId}" 
                data-seatId="${seatId}"
                data-datasetId="0@0"
                data-seatRun="${days}"
                data-effectiveFrom="${effectiveFrom}"
                data-effectiveTo="${effectiveTo}">
                <td>${cityName}</td>
                <td>${hospitalName}</td>
                <td>${seatName}</td>
                <td>
                    <input type="radio" name="defaultSeat" value="${rowIndex}">
                </td>
                <td>${days}</td>
                <td>
                        ${effectiveFrom}
                    </td>
                    <td>
                        ${effectiveTo}
                    </td>
                <td>
                    <button class="btn btn-danger btn-sm delete-row" data-index="${rowIndex}">
                        <i class="fas fa-trash"></i>
                    </button>
                </td>
            </tr>
        `);
    });

        // Delete Row Button Click
        $("#detailsTable").on("click", ".delete-row", function () {
            var rowIndex = $(this).data("index");
			//alert(tableData.length);
            // Remove the row from the array
            tableData.splice(rowIndex, 1);
            //alert(tableData.length);

            // Update hidden field with IDs only
            updateHiddenField();

            // Re-render the table
            renderTable();

        });

        // Function to render the table
        function renderTable() {
            var tableBody = $("#detailsTable tbody");
            tableBody.empty();

            // Ensure the table container is always visible
            /*$("#detailsTableContainer").show();*/
			//alert(tableData.length);
            if (tableData.length === 0) {
                // Display a placeholder row if no data is available
               /* tableBody.append(`
                    <tr>
                        <td colspan="5">No data available. Please add a row.</td>
                    </tr>
                `);*/
                return;
            }

            tableData.forEach(function (row, index) {
				
                var rowParts = row.split("^");
                var cityId=rowParts[0];
                var hospitalId=rowParts[1];
                var seatId=rowParts[2];
                var cityName = rowParts[3];
                var hospitalName = rowParts[4];
                var seatName = rowParts[5];
                var days = rowParts[6];
                var effectiveFrom=rowParts[7];
                var effectiveTo=rowParts[8];
                tableBody.append(`
                    <tr data-index="${index}"
                    data-cityId="${cityId}" 
                    data-hospitalId="${hospitalId}" 
                    data-seatId="${seatId}"
                    data-datasetId="0@0"
                    data-seatRun="${days}"
                    data-effectiveFrom="${effectiveFrom}"
                	data-effectiveTo="${effectiveTo}">
                        <td>${cityName}</td>
                        <td>${hospitalName}</td>
                        <td>${seatName}</td>
                        <td>
                            <input type="radio" name="defaultSeat" value="${index}">
                        </td>
                        <td>${days}</td>
                        <td>
                        ${effectiveFrom}
                    </td>
                    <td>
                        ${effectiveTo}
                    </td>
                        <td>
                           <button class="btn btn-danger btn-sm delete-row" data-index="${index}">
                        <i class="fas fa-trash"></i>
                    </button>
                        </td>
                    </tr>
                `);
            });
        }


        function updateHiddenField() {
            var hiddenData = tableData.map(row => `${row.rowData}^${row.defaultSeat}`).join("|");
            $("#hiddenFieldId").val(hiddenData);
            console.log("Updated Hidden Field Data:", hiddenData);
        }




    
    $("#cityId").change(function(){
		var inputData1={"cityId":this.value};
		
		var configHospital1={
				serviceName:"/getData/gethospitaluserbased",
				inputData:inputData1,
				callBackFunctionName:"commonPopulateCombo",
				comboId:"hospitalId",
				defaultOption:{"optionValue":"","optionText":"Select Hospital"}
		}
		callService(configHospital1);
	});	

    $("#hospitalId").change(function () {
        var inputData2 = { "hospitalId": this.value,"userSeatId":$('#hiddenUserId').val(),"drFlag":$('#drFlag').val() };

        var configSeat = {
            serviceName: "/getData/getseatnamesModify",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "userSeatId",
            defaultOption: { "optionValue": "", "optionText": "Select Role" }
        };
        callService(configSeat);
    });
    $("#clearBtnId").click(function (event) {
        event.preventDefault();
        resetPages();
    });
});
function initPage() {
    hidePreloader();
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
    populateCity();
    //populateUserType();
    calledAfterAllAjax.push("getDesignation");
    populateDesignation();
    getLoginUserType();
    //resetPages();
   /* $("#detailsTableContainer").show();*/

    const userId = $('#primaryKeys').val().split('@')[0];
    
    
    $('#hiddenUserId').val(userId);

    

    /*if (userId) {
        populateUserDetails(userId);
        populateSeatDetails(userId); 
    }*/
}
function resetPages() {
    function resetPage() {
        $('#masterKey').val("UserMaster");
        submitFormWithResetTextField("CallMasterPage");
    }
    $("#detailsTable tbody").empty(); 
    $("form")[0].reset(); 
    $("select").each(function () {
        $(this).val("").change();
    });

    /*$("#detailsTableContainer").show();*/
}

function populateUserType() {
    var configJson = {
        serviceName: "/getData/getUserTypes",
        comboId: "userTypeId",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select User Type" }
    };
    callService(configJson);
}

function populateCity() {
   
    var configJson={
			serviceName:"/getData/getcitybasedonuser",
		 comboId:"cityId",		
		 callBackFunctionName:"commonPopulateCombo",
		defaultOption:{"optionValue":"","optionText":"Select City"}	
		
	      }
      callService(configJson);
}

function populateUserDetails(userId) {
    const configJson = {
        serviceName: "/getData/getUserDetails",
        primaryKeys:[userId],
        callBackFunctionName: "commonPopulateForm",
        functionAfterPopulating:"setDoctorData"
    };
    callService(configJson);
}

function setDoctorData(){
	var drFlag=$('#drFlag').val();
	
	if(drFlag==1){
		$('#hprDrDiv').removeClass('hideData');
	}
	else{
		$('#hprDrDiv').addClass('hideData');
	}
	
	if($('#notEmployee').prop('checked')){
		
		$('#govEmailChkDiv').addClass('hideData');
		$('#govEmailCheck').val(0);
		
		$('#govEmailChkDiv').prop('checked',false);
		
		$('#patEmail').attr( 'data-validation','mandatory,email');
		
	}
	
	if($('#isEmployee').prop('checked')){
		if(userType==52 || userType==27){
		$('#govEmailChkDiv').removeClass('hideData');
		}
		else{
			$('#govEmailChkDiv').addClass('hideData');
		}
		
		$('#govEmailChkDiv').prop('checked',true);
		$('#govEmailCheck').val(1);
		
		$('#patEmail').attr( 'data-validation','mandatory,govemail');
	}
	
	if($('#govEmailCheck').prop('checked')){
			$('#govEmailCheck').val(1);
			$('#patEmail').attr( 'data-validation','mandatory,govemail');
		}
		else{
			$('#patEmail').attr( 'data-validation','mandatory,email');
			$('#govEmailCheck').val(0);
		}
	
}
function populateSeatDetails(userId) {
	  const configJson = {
		        serviceName: "/getData/getSeatDetails",
		        primaryKeys: [userId], 
		        callBackFunctionName: "populateSeatTable",
		    };
		    callService(configJson);
}

function populateSeatTable(configJson, dataJson) {
    console.log("Seat Details Response:", dataJson); // Debug response

    const tableBody = $("#detailsTable tbody");
    tableBody.empty();

    if (dataJson.message && dataJson.message.indexOf("ERROR") >= 0) {
        showAlertMsg("Error fetching seat details!", "danger", "alertMsg");
        return;
    }

    if (dataJson.data && dataJson.data.length > 0) {
        // Iterate through the seat data and populate the table
        dataJson.data.forEach((row, index) => {
            const isChecked = parseInt(row.isDefaultSeat) === 1 ? 'checked' : ''; // Convert to number before checking
            const html = `
                <tr data-index="${index}" 
                    data-cityId="${row.cityId}" 
                    data-hospitalId="${row.hospitalId}" 
                    data-seatId="${row.seatId}"
                    data-datasetId="${row.datasetId}"
                    data-seatRun="${row.seatRun}"
                    data-effectiveFrom="${row.effectiveFrom}"
                    data-effectiveTo="${row.effectiveTo}">
                    <td>${row.cityName || ''}</td>
                    <td>${row.hospitalName || ''}</td>
                    <td>${row.seatName || ''}</td>
                    <td>
                        <input type="radio" name="defaultSeat" value="${index}" ${isChecked} />
                    </td>
                    <td>
                        ${row.seatRun}
                    </td>
                    <td>
                        ${row.effectiveFrom}
                    </td>
                    <td>
                        ${row.effectiveTo}
                    </td>
                    <td>
                        <button class="btn btn-danger btn-sm delete-row" data-index="${index}">
                            <i class="fas fa-trash"></i>
                        </button>
                    </td>
                </tr>
            `;
            tableBody.append(html);
            
              var rowData = `${row.cityId}^${row.hospitalId}^${row.seatId}^${row.cityName}^${row.hospitalName}^${row.seatName}^${row.seatRun}^${row.effectiveFrom}^${row.effectiveTo}`;
              
              tableData.push(rowData);
        });
    } else {
        tableBody.append(`
            <tr>
                <td colspan="5">No seat details available.</td>
            </tr>
        `);
    }

    // Ensure the table container is visible
    /*$("#detailsTableContainer").show();*/
}

function removeRow(index) {
    const row = $("#detailsTable tbody tr").eq(index);
    row.remove();
}
function securePassword(userName, password) {
    var hashValue = "";

    if (!password || !userName) {
        alert("Username or Password is empty!");
        return false;
    }

    var objPassHash = new jsSHA(password + userName, "ASCII");
    try {
        hashValue = objPassHash.getHash("SHA-256", "HEX");
    } catch (e) {
        alert("Error hashing password!");
        return false;
    }

    return hashValue;
}
function updateHiddenFieldBeforeUpdate() {
    var hiddenData = [];
    $("#detailsTable tbody tr").each(function () {
        var cityId = $(this).attr("data-cityId");
        var hospitalId = $(this).attr("data-hospitalId");
        var seatId = $(this).attr("data-seatId");
        var isDefaultSeat = $(this).find("input[name='defaultSeat']").is(":checked") ? 1 : 0;
        var datasetId=$(this).attr("data-datasetId");
        var days=$(this).attr("data-seatRun");
        var effectiveFrom=$(this).attr("data-effectiveFrom");
        var effectiveTo=$(this).attr("data-effectiveTo");

        if (cityId && hospitalId && seatId) {
            hiddenData.push(`${cityId}^${hospitalId}^${seatId}^${isDefaultSeat}^${datasetId}^${days}^${effectiveFrom}^${effectiveTo}`);
        }
    });

    $("#hiddenFieldId").val(hiddenData.join("|"));
    console.log("Updated Hidden Field Data for Update:", hiddenData.join("|"));
}


function updateUser() {
    try {
        // Ensure a default seat is selected
        var defaultSeatSelected = $("input[name='defaultSeat']:checked").length > 0;

        if (!defaultSeatSelected) {
            alert("Please select a default seat before updating.");
            return;
        }
        updateHiddenFieldBeforeUpdate();
        // Validate passwords if provided
      /*  var password = $("#password").val();
        var confirmPassword = $("#confirmpassword").val();
        if (password && password !== confirmPassword) {
            alert("Passwords do not match!");
            return;
        }*/

		var password = atob($("#refPass").val().replaceAll("dbfhttf",""));
		
		//alert(password);
		
		

        // Secure the password by hashing it (if password is provided)
        var hashedPassword = password ? securePassword($("#patEmail").val(), password) : "";
        if (!hashedPassword && password) {
            alert("Password hashing failed! User cannot be updated.");
            return false;
        }
        
        if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }

        // Set the hashed password back to the form field
        if (hashedPassword) {
            $("#password").val(hashedPassword);
        }
        
         $('#desigId').prop('disabled', false);

        // Serialize the form input
        var inputData = processSerializeArray("ENTRYFORM");
        
       
        
       

        console.log("Filtered Input Data:", inputData); // Debugging
        // Prepare API call configuration
       var config = {
            serviceName: "updateUser",
            inputData: inputData,
            callBackFunctionName: "handleUpdateUserResponse",
        };

        // Call the update service
        callService(config);
    } catch (error) {
        console.error("Error updating user:", error);
    }
}

function handleUpdateUserResponse(configJson, dataJson) {
   if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"backToListPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson);
		
	}
}

function backToListPage(){
	
	$('#masterKey').val("UserMaster");
	submitFormWithResetTextField("CallMasterPage");
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

function checkIsEmployee(obj){
	
	if($(obj).prop('checked')){
		
		if(userType==52 || userType==27){
		$('#govEmailChkDiv').removeClass('hideData');
		}
		else{
			$('#govEmailChkDiv').addClass('hideData');
		}
		
		$('#govEmailCheck').prop('checked',true);
		$('#govEmailCheck').val(1);
		
		$('#patEmail').attr( 'data-validation','mandatory,govemail');
	      
	      
			
			
	}
	
	
	
}

function checkNotEmployee(obj){
	
	if($(obj).prop('checked')){
		
		$('#govEmailChkDiv').addClass('hideData');
		$('#govEmailCheck').val(0);
		
		$('#govEmailCheck').prop('checked',false);
		
		$('#patEmail').attr( 'data-validation','mandatory,email');
	      
	      
			
			
	}
	}
function populateDesignation(){
	
	var configJson = {
        serviceName: "/getData/getDesignationList",
        comboId: "desigId",
        callBackFunctionName: "populateDesigCombo",
        defaultOption: { "optionValue": "", "optionText": "Select Designation" }
    };
    callService(configJson);
	
}

function populateDesigCombo(configJson, dataStr) {

	//var dataJson = JSON.parse(dataStr);
	commonPopulateCombo(configJson, dataStr);
	calledAfterAllAjax = removeItemOnce(calledAfterAllAjax, "getDesignation");
	//console.log("populating group Combo ");
	if (calledAfterAllAjax.length == 0) {
		
		 const userId = $('#primaryKeys').val().split('@')[0];
    
    if (userId) {
        populateUserDetails(userId);
        populateSeatDetails(userId); 
    }
	}

}

function getLoginUserType(){
	
	const configJson = {
		        serviceName: "/getData/getLoginUserType",
		        callBackFunctionName: "userTypeLogic",
		    };
		    callService(configJson);
		    
}

function userTypeLogic(configJson, dataJson){
	
	var jsonData=dataJson["data"];
	
	
	if(jsonData.length>0){
		
		$.each(jsonData,function(indx, rowJson){
		
			userType= rowJson["userTypeId"];
			
			
			if(userType==52 || userType==27){
				$('#isContractualDiv').removeClass('hideData');
				$('#govEmailChkDiv').removeClass('hideData');
				$('#patEmail').prop('readonly',false);
			}
			else{
				$('#isContractualDiv').addClass('hideData');
				$('#govEmailChkDiv').addClass('hideData');
				$('#patEmail').prop('readonly',true);
				$('#userName').prop('readonly',true);
				$('#dob').prop('readonly',true);
				$("#dob").datepicker("destroy");
				$('#patMobileNo').prop('readonly',true);
				//$('#desigId').prop('readonly',true);
				$('#desigId').prop('disabled', true);
				
				$('#panNo').prop('readonly',true);
				
			}
			
			
		
		
		})	
		
		}
		
		
	
}



 