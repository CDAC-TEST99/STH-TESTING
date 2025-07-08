$(document).ready(function () {
	
	initPage();
	
	
	
		
	
});

function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	}
	
	
	function getBenId()
	{
		
			var BenId=document.getElementById('patBenId').value;
		//	alert("iiinnnnbenid>>>>>>>"+BenId);
			
			
			
  var configJson={
    				serviceName:"/getData/getfamilymembers",
    				primaryKeys:[$('#patBenId').val()],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
    		
    		var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[$('#patBenId').val()],			
    				callBackFunctionName:"populateIndexCard",
    			 				
    			}
    		callService(configJson);
	}
	
	
	
  function printContent() {
            var printWindow = window.open('', '', 'height=800,width=800');
            printWindow.document.write('<html><head><title>Print Content</title></head><body>');
            printWindow.document.write(document.getElementById('contentToPrint').innerHTML);
            printWindow.document.write('</body></html>');
            printWindow.document.close();
            printWindow.print();
        }


		 	function populateIndexCard(configJson, dataJson) {
    	//    alert("populateIndexCard");
    	//   alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
  //  alert("populateIndexCard");
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   // $('#applyplastccard').show();
    	    }
    	    else
        	    {
		  
    	       	    	
    	    	
    	    let indx = 1;
    	   // const tableBody = $("#getstatusbeneficiary tbody");
    	    // $("#AutoNumber1 tbody").empty();
    	   // var trackingId="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
        	    
          	       
          	       // trackingId=json["Trackingid"];
          	         $("#govEmployeeName").text(json["FirstName"]);
          	            $("#issueDate").text(json["validupto"]);
          	         //   $("#entitlement").text(json["validupto"])   
          	             $("#departmentName").text(json["gstr_service_dept_name"]) 
          	              $("#entitlement").text(json["gnum_ward_entitlement_nm"])
          	                 $("#residentialAddress").text(json["resdaddress"])
          	                 $("#wellnessCentre").text(json["gstr_hospital_name"])
          	                  $("#CardNumber").text(json["cardno"])
          	                    $("#CardType").text(json["gstr_cardtype_name"])
          	                 
          	                      	     	  
		   
            	    });
            	    
            	   
        	    
        	 //  $('#mymodalprintindexcard').modal('show');
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}

	
       	function populatefamilymembers(configJson, dataJson) {
			  //  alert("populatefamilymembers");
    	//  alert("configJson>>> " + JSON.stringify(configJson));
    	 // alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    	   if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   // $('#applyplastccard').show();
    	    }
    	    else
        	    {
		     	       	    	
    	    	
    	    let indx = 1;
    	   // const tableBody = $("#getstatusbeneficiary tbody");
    	     $("#AutoNumber1 tbody").empty();
    	   // var trackingId="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){

        	    	let html = "<tr>";
          	        html += "<td class='slno'>" + indx + "</td>";
          	        html += "<td>" + json["beneficiary Id"] + "</td>"; 
          	        html += "<td>" + json["Name"] + "</td>";
          	        html += "<td>" + json["DOB"] + "</td>";
          	        html += "<td>" + json["Relation"] + "</td>";
          	        html += "<td>" + json["Gender"] + "</td>";
          	         html +="<td><img src='"+json["Photo"]+"' style='width:100px;height:100px'>" ;

               	         
          	        html += "</tr>";
          	       // trackingId=json["Trackingid"];
          	    //     $("#govEmployeeName").text(json["Name"]);
          	         
          	         $("#AutoNumber1 tbody").append(html); 
          	            indx++;
            	    });
            	    
            	   
        	    $('#printindexcardshow').show();
        	 //  $('#mymodalprintindexcard').modal('show');
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	  
    	  
    	}