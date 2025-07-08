

$(document).ready(function () {
	
	//initPage();
	 var Benid=$('#Benidvalue').val();
	 hidePreloader();
	
    });
	

function uploadExcel(){
	 var fileInput = document.getElementById("excelFile");
	 var file = fileInput.files[0];
	 var fileName = file.name;
	 var msgDiv = document.getElementById("invalid-feedback");
	 
    if (fileInput.files.length === 0) {
        swal('Error', 'Please select an Excel file to upload.', 'error');
        return;
    }

    if (!file) {
        alert("Please select an Excel file to view.");
        return;
    }

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
        url: "/CGHSCardMgmt/FormFlowXACTION?hmode=uploadExcel", 
        type: "POST",
        data: formData,
        enctype: "multipart/form-data",
        processData: false,
        contentType: false,
        dataType: "json", 
        success: function(response) {
        	console.log("dataJson>>"+JSON.stringify(response))
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
				
				
                swal('Error', response.message, 'error');
            }
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
            swal('Error', errorMsg, 'error');
        }
    });
}





