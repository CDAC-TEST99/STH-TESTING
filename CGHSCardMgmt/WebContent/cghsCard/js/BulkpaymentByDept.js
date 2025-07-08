  
 var initInputJson=null;
 listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "Dept Bulk Payment",
	"listServiceName": "/getData/getcardcategorybenforBulkPayment",
	"noOfRecordPerPage": "10",
	"noSearchSortColumnNo":[1,2],
	"filters":[
		
	           {"filterId":"filterRecordStatus",
			  		 "filterLabel":"Card Type",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"","optionText":"Select Value"},
			  		 "serviceName":"/getData/getCardlistBulkforPayment"
				}
			 ], 
	"buttons": [
		{
			"buttonName": "btnApprove",
			"buttonDisplayName": "Proceed",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fas fa-edit",
			"onClickFunction": "openModalDtlPage()"		
		}
	]
}


$(document).ready(function () {
    //initPage();
    
    $('#LISTPAGE').removeClass('hideData');
    hidePreloader();
	createListPage(listPageConfigJson);
	//hidePreloader();
	  
    
});

	
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
	var flag= confirm("Are you sure to Proceed ?");
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




function openModalDtlPage(){
	
	var arrPrimarykey=getPrimaryKeyFromListPage();
var strPrimaryKey = JSON.stringify(arrPrimarykey);
//alert("stringfy>>>>>>" + strPrimaryKey); // Outputs the array as a JSON string

// Remove the first and last characters (the brackets)
   var result = strPrimaryKey.slice(1, -1);
  // alert("stringfy without brackets>>>>>>" + result); // Outputs the array without brackets
		
		
		var resultWithSingleQuotes = result.replace(/"/g, "'");
//alert("stringfy with single quotes>>>>>>" + resultWithSingleQuotes);
		
		var serviceName="/getData/CalculateTotalAmount";
		
		var configJson={
				serviceName:serviceName,				
				callBackFunctionName:"showDetails",				
		        primaryKeys:resultWithSingleQuotes,		
			}
		
		callService(configJson);
		
}
function showDetails(configJson, dataJson){
   // alert(JSON.stringify(dataJson));
    $('#divApproveView').modal('show');
    
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        showAlertMsg("Beneficiary belongs to another City!", "danger", "alertMsg");
    } else {
        let indx = 1;
        let totalAmount = 0; // Initialize totalAmount variable to store sum

        $("#AutoNumber1 tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            let selfRow = null; // Variable to hold the "self" row data
            
            $.each(dataJson["data"], function(_, json) {
                let html = "<tr>";
          
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["trackingid"] + "</td>";
                html += "<td>" + json["NAME"] + "</td>";
                html += "<td>" + json["DOB"] + "</td>";
                html += "<td>" + json["Amount"] + "</td>";
                
                // Add the amount to the totalAmount
                totalAmount += parseFloat(json["Amount"]) || 0;

                $("#AutoNumber1 tbody").append(html);
                $("#AutoNumber1").show();
                
                // Increment the index for the next row
                var index = 1;
                $('.slno').each(function() {
                    $(this).text(index);
                    index++;
                });
            });

            // Append the total sum row at the bottom
            let totalHtml = "<tr>";
            totalHtml += "<td colspan='4' style='text-align: right;'>Total Amount</td>"; // Merge cells
            totalHtml += "<td>" + totalAmount.toFixed(2) + "</td>"; // Display the sum with 2 decimals
            totalHtml += "</tr>";

            $("#AutoNumber1 tbody").append(totalHtml);

            // Append the "Proceed to Payment" button
            let buttonHtml = "<tr><td colspan='5' style='text-align: center;'>";
            buttonHtml += "<button class='btn btn-success' id='proceedPaymentButton'>Proceed to Payment</button>";
            buttonHtml += "</td></tr>";

            $("#AutoNumber1 tbody").append(buttonHtml);

            // Add an event listener for the button to handle payment
            $('#proceedPaymentButton').on('click', function() {
                // Add the logic for proceeding to payment
                proceedToPayment(totalAmount);
            });

        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}

function proceedToPayment(totalAmount) {
    // Logic for proceeding to payment
    // This is a placeholder function, replace it with your actual payment handling code
    alert("Proceeding to payment for the total amount of " + totalAmount.toFixed(2));
}

