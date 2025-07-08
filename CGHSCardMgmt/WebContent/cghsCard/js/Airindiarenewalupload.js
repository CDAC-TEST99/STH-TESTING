

$(document).ready(function () {
	
	//initPage();
	 var Benid=$('#Benidvalue').val();
	 
		$("#successRecordArea").hide();
		$("#errorRecordArea").hide();
	 
	 hidePreloader();
	 
	
    });


function resetPage(){


	$("#uploadExcel").show();
	$("#instructionArea").show();
	$("#resetPage").hide();
	$("#cardRenewal").hide();
	
	$("#excelFile").val("");
	
	$("#successRecordArea").hide();
	$("#errorRecordArea").hide();
	
	
}

function uploadExcel(){
	
	
	
	
	 var fileInput = document.getElementById("excelFile");
	 var file = fileInput.files[0];
	 
	 if (!file) {
	        alert("Please select an Excel file to view.");
	        return;
	    }
	 
	 var fileName = file.name;
	 var msgDiv = document.getElementById("invalid-feedback");
	 
    if (fileInput.files.length === 0) {
        swal('Error', 'Please select an Excel file to upload.', 'error');
        return;
    }

   
    $("#errMsg").html("");
		  $("#errMsg").hide();
    
    
    showPreloader();

    var formData = new FormData();
    formData.append("file", file);
    var hospitalCode = $('#hospitalCode').val();
    var seatId = $('#seatId').val();
    //alert("hospitalCode>>"+hospitalCode);
    //alert("seatId>>"+seatId);
    formData.append("hospitalCode", hospitalCode);
    formData.append("seatId", seatId);
    
    for (var pair of formData.entries()) {
        console.log(pair[0]+ ', '+ pair[1].name);  
    }

    $.ajax({
        url: "/CGHSCardMgmt/FormFlowXACTION?hmode=uploadAirIndiaExcel", 
        type: "POST",
        data: formData,
        enctype: "multipart/form-data",
        processData: false,
        contentType: false,
        dataType: "json", 
        success: function(response) {
        	console.log("dataJson>>"+JSON.stringify(response))
        	
        	
        	if(response.message){
        		
        		
        		 if (response.message.includes("SUCCESS")) {
       			  
       			  $("#errMsg").html("");
       			  $("#errMsg").hide();
       			  
       			    $("#normalMsg").html( response.message || 'Excel uploaded successfully.');
       			  $("#normalMsg").show();
       			  
                       swal('Success', response.message || 'Excel uploaded successfully.', 'success');
                       
                   } else {
       				
       				
       				  $("#errMsg").html("Error : "+ response.message);
       			 	 $("#errMsg").show();
       			  
       			    $("#normalMsg").html("");
       			  $("#normalMsg").hide();
       				
       		   $("#excelFile").val("");
                       swal('Error', response.message, 'error');
                   }
        		
        		
        	}else{
        		
        		
        		if(response.excelData.length > 0){
        			 	
        			
        			generateTable(response.excelData , 'successRecords' );
        			
        			$("#successRecordId").html("Success Records ("+ response.excelData.length +")");
        			$("#successRecordArea").show();
        			
        		}
        		
        		if(response.excelDataError.length > 0){
        			 
        			generateTable(response.excelDataError , 'errorRecords' );
        			
        			
        			$("#errorRecordId").html("Error Records ("+ response.excelDataError.length +")");
        			$("#errorRecordArea").show();
        		}else{
        			
        			$("#cardRenewal").show();
        			$("#successRecordsJson").val(window.btoa("{\"data\" : "+JSON.stringify(response.excelData)+"}"));
        		}
        		
        		
        		$("#uploadExcel").hide();
        		$("#resetPage").show();
        		$("#instructionArea").hide();
        		
        	}
        	
        	
        	 hidePreloader();
         
        },
        error: function(xhr, status, error) {
            let errorMsg = "Failed to upload Excel";
            if (xhr.responseText) {
                try {
                    const errObj = JSON.parse(xhr.responseText);
                    errorMsg = errObj.error || xhr.responseText;
                } catch (e) {
                    errorMsg = xhr.responseText;
                }
            }
            
            hidePreloader();
            
            $("#excelFile").val("");
            swal('Error', errorMsg, 'error');
        }
    });
}

function cardRenewal(){
    var hiddenjson = $("#successRecordsJson").val();
  //  alert("Hidden JSON (Base64): " + hiddenjson);

    try {
        // Decode Base64 string
        var decodedString = atob(hiddenjson);

        // Parse decoded string into JSON
        var jsonObject = JSON.parse(decodedString);

         console.log("Decoded JSON object:", jsonObject);
        
        var configJson = {
        serviceName: "/DMLSAVE/UpdateAirIndiacardsvalidity",
        callBackFunctionName: "callbackSaveData2",
        inputData: jsonObject
    };
     	
    callService(configJson);
       // alert("Decoded JSON object:"+ jsonObject);
        // You can now use jsonObject as a regular JavaScript object
    } catch (e) {
        console.error("Error decoding or parsing JSON:", e);
    }
}


function callbackSaveData2(configJson, dataJson)
	{
		//alert(JSON.stringify(configJson));
		//alert(JSON.stringify(dataJson));
		
			if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{	
		
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		showMsg(dataJson["message"],dialogConfigJson);
		}
		
	}
function generateTable(jsonArray , tableId) {
		 
    const table = document.getElementById(tableId);
    
    table.innerHTML = "";

    // Create table header
    let headerRow = "<thead><tr>";
    Object.keys(jsonArray[0]).forEach(key => { headerRow += `<th>${key}</th>`; });
    headerRow += "</tr></thead>";
    table.innerHTML += headerRow;

    // Create table rows
    jsonArray.forEach(item => {
        let row = "<tr>";
        Object.values(item).forEach(value => {   row += `<td>${value}</td>`;  });
        row += "</tr>";
        table.innerHTML += row;
    });
    
    
    if (jsonArray.length > 1) {
    	table.style.display='block';
        return;
    }
    
}


