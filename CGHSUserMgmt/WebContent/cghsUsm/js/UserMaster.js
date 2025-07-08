 var initInputJson=null;
 listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "User Master",
	"listServiceName": "/getData/getUserList",
	"noOfRecordPerPage": "10",
	"noSearchSortColumnNo":[],
	"filters":[
	           {"filterId":"filterRecordStatus",
			  		 "filterLabel":"Record Status",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"1","optionText":"Active"},
			  		 "serviceName":"/getData/getRecordStatus"
				}
			 ], 
	"buttons": [{
			"buttonName": "Add",
			"buttonDisplayName": "Add",
			"buttonClass": "btn-his-sm text-white  btn-sm",
			"buttonIcon": "fas fa-plus-circle",
			
			"onClickFunction": "listInitAddPage()",
		},
		 {
			"buttonName": "Modify",
			"buttonDisplayName": "Modify",
			"buttonClass": "btn-his-outline-sm text-white selectbtn singleSelect",
			"buttonIcon": "far fa-edit",
			"onClickFunction": "submittonew(this)",
			"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupDetailById",
			"masterkey":"ModifyUserMaster",
			"initMode":"modify",
		},
		{
			"buttonName": "btnDelete",
			"buttonDisplayName": "Delete",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fas fa-trash",
			"onClickFunction": "listPageDeleteRecordDtl()",
			"onClickServiceName": "/DMLSAVE/deleteUser"
		},
		{
			"buttonName": "btnReset",
			"buttonDisplayName": "Reset/Unlock User",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fas fa-edit",
			"onClickFunction": "listPageResetRecordDtl()",
			"onClickServiceName": "/DMLSAVE/resetUser"
		},
		{
			"buttonName": "btnView",
			"buttonDisplayName": "View",
			"buttonClass": "btn-his-outline-sm selectbtn singleSelect",
			"buttonIcon": "fas fa-eye",
			"onClickFunction": "listPageViewRecord(this)"
		}
	]
}




$(document).ready(function () {
    //initPage();
    
    $('#LISTPAGE').removeClass('hideData');
    hidePreloader();
	createListPage(listPageConfigJson);
	//hidePreloader();
	
	$('#clearForm').click(resetPage);
	
	$('#cancelForm').click(backToListPage);
	
    
        // Ensure the table container is hidden initially
        $("#detailsTableContainer").hide();

        
        
        
        $("#addRowBtn").click(function () {
        
        // Add row to the table
        //addRowToTable(cityId,hospitalId,seatId,cityName,hospitalName,seatName, isDefault);
        addRowToTable();
    });
    
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
        

        
        $('#userTypeId').change(function(){
			var docFlag=$(this).val().split("^")[1];
			
			if(docFlag==1){
				$('.drClass').removeClass('hideData');
			}
			else{
				docFlag=0;
				$('.drClass').addClass('hideData');
			}
			
			
			var hospitalId=$('#hospitalId').val()==''?0:$('#hospitalId').val();
        var inputData2 = { "hospitalId": hospitalId,"docFlag":docFlag };

        var configSeat = {
            serviceName: "/getData/getSeatNames",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "userSeatId",
            defaultOption: { "optionValue": "", "optionText": "Select Seat" }
        };
        callService(configSeat);
		})
		
		

        // Delete Row Button Click
        $("#detailsTable").on("click", ".delete-row", function () {
           
            
            
            const rowIndex = $(this).attr("data-index");
            

        // Remove the row from the data array
        acceptanceData.splice(rowIndex, 1);
         checkData.splice(rowIndex, 1);
         displayData.splice(rowIndex, 1);

        // Update the hidden field
        updateHiddenField();

        // Re-render the table
        renderTable();
        });




    
    $("#cityId").change(function(){
		var inputData1={"cityId":this.value};
		
		var configHospital1={
				serviceName:"/getData/gethospitaluserbased",
				inputData:inputData1,
				callBackFunctionName:"commonPopulateCombo",
				comboId:"hospitalId",
				defaultOption:{"optionValue":"","optionText":"Select UNIT"}
		}
		callService(configHospital1);
	});	
	
	/*$("#drcityId").change(function(){
		var inputData1={"cityId":this.value};
		
		var configHospital1={
				serviceName:"/getData/gethospitaluserbased",
				inputData:inputData1,
				callBackFunctionName:"commonPopulateCombo",
				comboId:"drhospitalId",
				defaultOption:{"optionValue":"","optionText":"Select Hospital"}
		}
		callService(configHospital1);
	});	*/
	
	

    $("#hospitalId").change(function () {
		var userType=$('#userTypeId').val()==''?'0^0':$('#userTypeId').val();
		var docFlag=userType.split("^")[1];
        var inputData2 = { "hospitalId": this.value,"docFlag":docFlag };

        var configSeat = {
            serviceName: "/getData/getSeatNames",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "userSeatId",
            defaultOption: { "optionValue": "", "optionText": "Select Seat" }
        };
        callService(configSeat);
    });
    
    /*$("#drhospitalId").change(function () {
        var inputData2 = { "hospitalId": this.value };

        var configSeat = {
            serviceName: "/getData/getdepartmentunitcombo",
            inputData: inputData2,
            callBackFunctionName: "commonPopulateCombo",
            comboId: "deptUnit",
            defaultOption: { "optionValue": "", "optionText": "Select Unit" }
        };
        callService(configSeat);
    });*/
    
});

function listInitAddPage() {
    hidePreloader();
    $('#LISTPAGE').addClass('hideData');
    $('#ENTRYFORM').removeClass('hideData');
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	
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
	
	
    populateCity();
    //populateDrCity();
    populateUserType();
    populateDesignation();
    resetPage();
}


function resetPage(){
	$("#detailsTable tbody").empty(); 
      $("#detailsTableContainer").hide(); 
      
      $('#userTypeId').val("");
      $('#hprId').val("");
      $('#userName').val("");
      $('#loginId').val("");
      $('#password').val("");
      $('#confirmpassword').val("");
      $('#patMobileNo').val("");
      $('#patEmail').val("");
      
      $("#cityId").val("");
    $("#hospitalId").empty().append('<option value="">Select Hospital</option>');
    $("#userSeatId").empty().append('<option value="">Select Seat</option>');
    
    /*$('.select2').trigger('change');
	commonResetFields(initInputJson);*/
    
    //listInitAddPage();
}


function populateUserType() {
    var configJson = {
        serviceName: "/getData/getusertypesbasedonuser",
        comboId: "userTypeId",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select User Type" }
    };
    callService(configJson);
}


function populateDesignation(){
	
	var configJson = {
        serviceName: "/getData/getDesignationList",
        comboId: "desigId",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: { "optionValue": "", "optionText": "Select Designation" }
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

/*function populateDrCity(){
	
	    var configJson={
			serviceName:"/getData/getcitybasedonuser",
		 comboId:"drcityId",		
		 callBackFunctionName:"commonPopulateCombo",
		defaultOption:{"optionValue":"","optionText":"Select City"}	
		
	      }
      callService(configJson);
	
}*/
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
function saveUser() {
    try {
		
		
		
		if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    	if (acceptanceData.length === 0) {
			
					alert("Please add atleast one Seat !!");
					
					return;
			
				
			}
			
			else{
				
				var flag=0;
				
				acceptanceData.forEach((row, index) => {
		
			var defaultFlag=row.split("^")[3];
			
			//alert(defaultFlag);
			
			if(defaultFlag==='1'){
				flag=1;			}
		
		});
		
		if(flag==0){
			alert("Please add one default seat!!");
			return;
		}
				
			}
			
			var randomPass=(Math.floor(100000 + Math.random() * 900000));
			//alert(randomPass);
			
			$('#password').val(randomPass);
			$("#confirmpassword").val(randomPass);
				
    	 
    	var userName = $("#patEmail").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmpassword").val();
        
        var refPass="dbfhttf"+btoa(password)+"dbfhttf";
        
       
        
        $('#refPass').val(refPass);
        

        if (password !== confirmPassword) {
            alert("Passwords do not match!");
            return;
        }

        // Secure the password by hashing it
        var hashedPassword = securePassword(userName, password);
         var confirmhashedPassword = securePassword(userName, confirmPassword);

        if (!hashedPassword) {
            alert("Password hashing failed! User cannot be saved.");
            return false;
        }
        
        

        // Set the hashed password back to the form field
        $("#password").val(hashedPassword);
        $('#confirmpassword').val(confirmhashedPassword);

        var inputData = processSerializeArray("ENTRYFORM");
        var config = {
            serviceName: "saveUser",
            inputData: inputData,
            callBackFunctionName: "handleSaveUserResponse"
        };
        callService(config);
    } catch (error) {
    }
}
function handleSaveUserResponse(configJson, dataJson) {
	   if(dataJson["message"].indexOf("ERROR")>=0){
		   $("#password").val("");
           $("#confirmpassword").val("");
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


function listPageViewRecord(obj){
	
	 var pk=$(obj).attr("data-pk");
	 
	 //alert(pk);
	 //alert(decrypt(pk))
	 
	 $('#divUserView').modal('show');
	
	var configJson={
			serviceName:"/getData/getuserdetailsview",
			callBackFunctionName:"readOnlyDataDisplay",
			containerdivId:"userDtl",
			primaryKeys:[decrypt(pk)],
			isTablularView:"No"
		}
	
	
	callService(configJson);
	
	
	var configJson={
			serviceName:"/getData/getseatdetailsforview",
			callBackFunctionName:"readOnlyDataDisplay",
			containerdivId:"userSeatDtl",
			primaryKeys:[decrypt(pk)],
			isTablularView:"Yes"
		}
	
	
	callService(configJson);
	
	
	
}


let acceptanceData = [];
let checkData = [];
let displayData=[];        
function addRowToTable(){
	
	
			const cityId = $("#cityId").val();
            const hospitalId = $("#hospitalId").val();
            const seatId = $("#userSeatId").val();
            const cityName = $("#cityId option:selected").text();
            const hospitalName = $("#hospitalId option:selected").text();
            const seatName = $("#userSeatId option:selected").text();
            const isDefault=$('#defaultFlag').val();
            var effectiveTo=$('#efectiveTo').val();
            var effectiveFrom=$('#efectiveFrom').val();
            var days="";
            
        	

        if (!cityId || !hospitalId || !seatId || !isDefault || effectiveTo=="" || effectiveFrom=="") {
                alert("Please select all fields (City, Hospital, Seat,Default,Effective From and EffectiveTo) before adding.");
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
            
            
            const rowData = `${cityId}^${hospitalId}^${seatId}^${isDefault}^${days}^${effectiveFrom}^${effectiveTo}`;
    		const seatDtl=`${hospitalId}^${seatId}`;
    		
    

    // Validate for duplicate entries
    if (checkData.includes(seatDtl)) {
        alert("This Role already exists.");
        return;
    }
    
    var flag=0;
    
    if(isDefault==='1'){
		acceptanceData.forEach((row, index) => {
		
			var defaultFlag=row.split("^")[3];
			
			//alert(defaultFlag);
			
			if(defaultFlag==='1'){
				flag=1;			}
		
		});
		
		if(flag==1){
			alert("Default Role Already Present!!");
			return;
		}
	}
    
    
    $('#edit_monday').prop('checked',false);
    $('#edit_tuesday').prop('checked',false);
    $('#edit_wednesday').prop('checked',false);
    $('#edit_thursday').prop('checked',false);
    $('#edit_friday').prop('checked',false);
    $('#edit_saturday').prop('checked',false);
    $('#edit_sundday').prop('checked',false);
    
		
    
	checkData.push(seatDtl)
	
    // Add data to array
    acceptanceData.push(rowData);
    
    var defaultVal=(isDefault==1)? "Yes" : "No" ;
    
    const displayName=`${cityName}^${hospitalName}^${seatName}^${defaultVal}^${days}^${effectiveFrom}^${effectiveTo}`;
    
    displayData.push(displayName);
    
    
    
    
    	updateHiddenField();

            // Make the table container visible if hidden
            $("#detailsTableContainer").show();

            // Add new row to the table (display with names for user visibility)
            var rowIndex = acceptanceData.length - 1;
            $("#detailsTable tbody").append(`
                <tr data-index="${rowIndex}">
                    <td>${cityName}</td>
                    <td>${hospitalName}</td>
                    <td>${seatName}</td>
                    <td>
                        ${defaultVal}
                    </td>
                    <td>
                        ${days}
                    </td>
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
    
    
    
    		$('#cityId').val("").trigger('change.select2');
			$('#hospitalId').val("").trigger('change.select2');
			$('#defaultFlag').val("").trigger('change.select2');
			$('#userSeatId').val("").trigger('change.select2');
			$('#efectiveFrom').val("");
			$('#efectiveTo').val("");
    
    
	
	
	
	
}        
        
        
        

        // Function to render the table
        function renderTable() {
            
            
            const tableBody = $("#detailsTable tbody");
    tableBody.empty();

    if (acceptanceData.length === 0) {
        $("#detailsTableContainer").hide(); // Hide table if no rows are present
        return;
    }

    displayData.forEach((row, index) => {
		
        const [city,hosp,seat, isDefault,days,effectiveFrom,effectiveTo] = row.split("^");
       
        
        tableBody.append(`
            <tr data-index="${index}">
            	<td>${city}</td>
            	<td>${hosp}</td>
                <td>${seat}</td>
                <td>${isDefault}</td>
                <td>${days}</td>
                <td>${effectiveFrom}</td>
                <td>${effectiveTo}</td>
                <td>
                    <button class="btn btn-danger btn-sm delete-row" data-index="${index}">
                        <i class="fas fa-trash"></i>
                    </button>
                </td>
            </tr>
        `);
    });
            
            
            
            
            
        }

        // Function to update the hidden field
        function updateHiddenField() {
            var hiddenData = acceptanceData.join("|");
            $("#hiddenFieldId").val(hiddenData);
            console.log("Updated Hidden Field Data:", hiddenData);
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
		
		$('#govEmailChkDiv').removeClass('hideData');
		
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
	
	function listPageResetRecordDtl(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	var listJson= JSON.parse($('#spanConfigJson').html());
	var buttonJson=null;
	// getting buttonobj from json whose onclick function is listPageDeleteRecordDtl
	$.each(listJson["buttons"],function(key,vobj){
		if(vobj["onClickFunction"]=="listPageResetRecordDtl()"){
			buttonJson=vobj;
		}
	});
	var flag= confirm("Are you sure want to Reset User ?");
	if(flag==false)
		return;
	var serviceName=buttonJson["onClickServiceName"];
	var configJson={
			serviceName:serviceName,
			callBackFunctionName:"getDeletStatus",				
			initMode:buttonJson["initMode"],
			inputData:{primaryKeys:arrPrimarykey}				
	}
	callService(configJson);
		
}
