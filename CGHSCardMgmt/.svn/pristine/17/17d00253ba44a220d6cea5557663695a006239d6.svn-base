  $(document).ready(function () {
    	hidePreloader();

    	  var configJson={
    				serviceName:"/getData/getApplictionTrakingDtls",
    				primaryKeys:[document.getElementById('hiddenmobile').value],			
    				callBackFunctionName:"populateApplictionTrakingDtls",
    			 				
    			}
    		callService(configJson);

    	 


	 $("#patpaymentvalidfrom").datepicker({
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


$("#patpaymentvalidto").datepicker({ minDate:new Date , 
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
		
		

	 $("#patPaymentDDate").datepicker({
     minDate: new Date(),  // Remove or comment this out to allow dates before today
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
		
		
			

    });		
    		
    	
       	function populateApplictionTrakingDtls(configJson, dataJson) {
    	   // alert("configJson>>> " + JSON.stringify(configJson));
    	//   alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	    $('#applyplastccard').show();
    	    }
    	    else
        	    {
								
					
    	    	 $('#getstatusbeneficiary').show();
    	    	
    	    let indx = 1;
    	    const tableBody = $("#getstatusbeneficiary tbody");
    	    tableBody.empty();
    	    var trackingId="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
              var statusflagapplication=json["statusid"];
					//alert("statusflagapplication");
					var trackingid=json["Trackingid"];
					//alert("trackingid>>>>"+trackingid);
				$('#hiddentrackingid').val(trackingid);
				 trackingId=json["Trackingid"];
        	    	let html = "<tr>";
          	        html += "<td class='paymentslno'>" + indx + "</td>";
          	        html += "<td>" + json["Trackingid"] + "</td>"; 
          	        html += "<td>" + json["FirstName"] + "</td>";
          	        html += "<td>" + json["applyDate"] + "</td>";
          	        html += "<td>" + json["CardType"] + "</td>";
          	        html += "<td>" + json["gstr_cardtype_name"] + "</td>";
                	  html += "<td>" + json["MobileNo"] + "</td>";
          	         html += "<td>" + json["gstr_application_status"] + "</td>";
          	         html += "<td>" + json["payment_status"] + "</td>";
          	         	html += "<td>" + json["Rejremarks"] + "</td>";
          	         
          	         if(statusflagapplication=="4"){

               	       html += "<td><a class='btn btn-his-sm'  onclick='enterpayment(\"" + trackingId + "\")'>Check Payment Details</a></td>";
                      }
                      else if(statusflagapplication=="8" || statusflagapplication=="7" ||  statusflagapplication=="9" || statusflagapplication=="10" ||statusflagapplication=="11" ||statusflagapplication=="12"|| statusflagapplication=="13")
                      {
/*						  html += "<td>" + json["gstr_application_status"] + " | " + json["Rejremarks"] + "</td>";
*/							
				 html += "<td><a class='btn btn-his-sm' onclick='ApplyNewcard()'>Re-Apply</a></td>";

					  }
					  
					  else if(statusflagapplication=="2")
					  {
				    html += "<td><a class='btn btn-his-sm' onclick='CancelApplication()'>Cancel</a></td>";
				    
				 html += "<td><a class='btn btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";


					  }
					   else{
				 html += "<td><a class='btn btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
				// html += "<td><a class='btn btn-his-sm' onclick='CancelApplication()'>Cancel</a></td>";
			  }
          	        html += "</tr>";
          	        trackingId=json["Trackingid"];
          	        tableBody.append(html);
            	    });
        	      var index = 1;
    $('.paymentslno').each(function() {
        $(this).text(index);
        index++;
            });
        	/*    var configJson={
          				serviceName:"/getData/getonlineformhtml",
          				primaryKeys:[document.getElementById('hiddenmobile').value],
          				"trackingId":trackingId, 
          				callBackFunctionName:"populateonlineformhtml",
          			 				
          			}
          		callService(configJson);
        	    */
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}


        function populateonlineformhtml(configJson, dataJson) 
	    {
	    	 alert("configJson populateonlineformhtml>>> " + JSON.stringify(configJson));
	    	 alert("dataJson populateonlineformhtml>>>>>>>> " + JSON.stringify(dataJson));
	    	  if(dataJson["message"].indexOf("ERROR")<0){
	    	  $.each(dataJson["data"], function(_, json){
	    		  if (json.hasOwnProperty('formhtml')) {
	    	           // alert("formhtml: " + json["formhtml"]);

	    	          var decrypthtml=  decryptBase64(json["formhtml"])
	    	          alert("decrypthtml>>>>>>>>>: "+ decrypthtml);
	    	          decrypthtml=decrypthtml.replace("#trackingId#", configJson["trackingId"]);
	    	          
	    	          document.getElementById("formContainer").innerHTML = decrypthtml;
	    	     
	    		    	        } else {
	    	            //alert("formhtml key not found in: " + JSON.stringify(json));
	    	        }
	    	  });

	    	}
	    	  else
		    	  {
	    		  showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
	    	    	return;
		    	  }
	    }

    	function viewItem(trackingId)
    	{
			alert("trackingid>>>>>>>>"+trackingId);
			
			   var configJson={
          				serviceName:"/getData/getonlineformhtml",
          				primaryKeys:[trackingId],
          				"trackingId":trackingId, 
                 	callBackFunctionName:"populateonlineformhtml",
          			 				
          			}
          		callService(configJson);
        	//alert("11111111");        	
            $('#myModal').modal('show');
        }
    	
    	
    	function enterpayment(trackingId)
    	{
		//	alert("11111111111");
		 var configJson={
    				serviceName:"/getData/getpaymentdetailsforbeneficiary",
      				callBackFunctionName:"PopulatePaymentdetails",
    			  primaryKeys:[trackingId],			
    			}
    		callService(configJson);	
			$('#getstatusbeneficiary').hide()			
				
			//alert("enterpayment");
		//	$('#Paymententerdetails').show();
		}
    	function openpage(obj)
    	{
    		var val =$(obj).attr("value");
    		//alert(val);
    		$('#hiddenId12').val(val);
    		submitFormMaster("onlineapplyplasticcard","add");	   	
    		
    	}
    	
    	
    	
    		function PopulatePaymentdetails(configJson, dataJson) {
    	   // alert("configJson>>> " + JSON.stringify(configJson));
    	//   alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	    $('#applyplastccard').show();
    	    }
    	    else
        	    {
							
						
					$('#paymentdetailsBeneficiary').show();
    	    	
    	    let indx = 1;
    	    const tableBody = $("#paymentdetailsBeneficiary tbody");
    	    tableBody.empty();
    	    var trackingId="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
                  var statusflagapplication=json["statusid"];
					//alert("statusflagapplication");
					var trackingid=json["trackingid"];
				//	alert("trackingid>>>>"+trackingid);
				$('#hiddentrackingid').val(trackingid);
					
        	    	let html = "<tr>";
          	        html += "<td class='slno'>" + indx + "</td>";
          	        html += "<td>" + json["trackingid"] + "</td>"; 
          	        html += "<td>" + json["patname"] + "</td>";
          	        html += "<td>" + json["cardtype"] + "</td>";
                	  html += "<td>" + json["orgname"] + "</td>";
                	  html += "<td>" + json["gnum_pay_scales"] + "</td>";
                	   html += "<td>" + json["cardvalidity"] + "</td>";
                	    html += "<td>" + json["CPC"] + "</td>";
                        html += "<td>" + json["Amount"] + "</td>";
                       html += "<td><a class='btn btn-his-sm'  onclick='proceedPayment()'>Procced for Payment</a></td>"

                      /*   html += "<td>" + json["adcityname"] + "</td>";*/
                    /*   html += "<td><textarea class='form-control' rows='3'></textarea></td>"; */
/*                 html += "<td><a class='btn btn-his-sm'  onclick='uploadchallan()'>Procced offline</a></td>";
*/
/*                     html += "<td><a class='btn btn-his-sm'  onclick='proceedPayment()'>Procced for Payment</a></td>"
*/          	       
          	        html += "</tr>";
          	        trackingId=json["Trackingid"];
          	        tableBody.append(html);
            	    });
        	    
        	 
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}
    	
    	
    	function uploadchallan()
    	{
			$("#fileuploadpaymentreceipt").show();
			//proceedPayment();
		}
    	function savedetails()
			{
				// Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");

    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/savepaymentDetails",
        callBackFunctionName: "callbackSaveData",
       inputData: processSerializeArray("ENTRYFORM")
    };
    
    // Call the service
    callService(configJson);

			}
		
    		
function callbackSaveData(configJson, dataJson){
	
	//alert("config json>>>>>>>>>>>>>>>>>"+JSON.stringify(configJson));
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

	//alert("send application to Beneficiary")
		$('#Paymententerdetails').hide();
	submitFormMaster("getselectcardtype","add");
}
var showpabharatkoshpaymentmode = false;
function proceedPayment() {
	//alert("hghghghghghg" + $("input[name='status']:checked").val());
	
	if(showpabharatkoshpaymentmode == false){
		$("#showpabharatkoshpaymentmode").show();
		showpabharatkoshpaymentmode = true;	
	}else{
		getBharatkoshSignature();
	}
	//
	
	
  	//$('#BharatKoshPaymentFORM').submit();  
  	//parent.closeModal();
  	
  
}	
function CancelApplication()
{
	
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/Updatestatuscancelwithdraw",
        callBackFunctionName: "callbackSaveDataUpdatestatuscancelwithdraw",
       inputData: processSerializeArray("ENTRYFORM")
    };
    
    // Call the service
    callService(configJson);

			}
		
    		
function callbackSaveDataUpdatestatuscancelwithdraw(configJson, dataJson){
	
	//alert("config json>>>>>>>>>>>>>>>>>"+JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPageUpdatestatuscancelwithdraw","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPageUpdatestatuscancelwithdraw(){
//alert("iinn reset page");f
	//alert("send application to Beneficiary");
	 window.location.reload();
		
}
	


function setStatus(status) {
  //alert("status>>>>>>>>>>>>>>"+status);
}
function ApplyNewcard()
{
//alert("djhjdhjhdjh");	
$("#applyplastccard").show();
$("#getstatusbeneficiary").hide();
}

var timestamp = Date.now();
function getBharatkoshSignature(){
    var configJson = {
        callBackFunctionName: 'callbackSaveData'
    }
	var url = "/CGHSCardMgmt/services/restful/bharatkosh/v1/ds/base64SignedXml";
	var data={
			 "tracking_id":$('#hiddentrackingid').val(),
			 "timestamp":timestamp,
			 "payment_type":$("input[name='status']:checked").val()
	 };
		 $.ajax({
		 	type: 'POST',
			url : url,
			data : JSON.stringify(data),
			dataType : "json",
			contentType: "application/json",
			success : function(json) {
			//	console.log(JSON.stringify(json));
				$('#bharrkkoshBK').val(json.base64SignedXml);
			    $('#BharatKoshPaymentFORM').submit();  
			    submitFormMaster("paymentprocess", "add");
				//eval(configJson["callBackFunctionName"])(configJson, returnStr);
				
						
			},
			error: function (jqXHR, exception) {
				
				
				  console.log(jqXHR);
				
				  console.log(exception);
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        hidePreloader();
		        console.log(msg);
		        //alert("Some Problem Occured");
		    },
			fail : function() {
				hidePreloader();
				alert("error occured");
			}
		});

}
	
