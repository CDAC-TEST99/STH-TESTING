
$(document).ready(function () {
	             
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
	//	alert("Primary key"+arrpk[1]);
		
		//$('#BenId').val(arrpk[1]);
	
	   var Benid=arrpk[1];
  var configJson={
    				serviceName:"/getData/getatransferDetails",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"PopulatetransferDetails",
    			 				
    			}
    		callService(configJson);
	
	}else{
		hidePreloader();
	}
		
	 
	
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
  
  /*
  function cardtransferSubmit(Benid)
  {

  var configJson={
    				serviceName:"/DMLSAVE/Updatecardtransferstatus",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"callbackSaveData",
    			 				
    			}
    		callService(configJson);
              }
  
  */
  function cardtransferSubmit()
  {

  var configJson={
    				serviceName:"/DMLSAVE/Updatecardtransferstatus",
    				  callBackFunctionName: "callbackSaveData",
                  inputData: processSerializeArray("ENTRYFORM")
    			 				
    			}
    		callService(configJson);
              }
function callbackSaveData(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPagetransfer","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage(){
	submitFormMaster("TransferReqApprove","add");	
		
}
  
  
  
     function PopulatetransferDetails(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
    } else {
        let indx = 1;
        $("#getcardtransferdetails tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
		//		alert("ddddddddddd"+json["addressproof"]);
				//  alert(resfileupload);
                  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
				// alert("city"+json["Cityto"]); 
				  $('#transferferslno').val(json["slno"]);
                $("#patBenid").val( json["BenId"]);
                  $("#CityFrom").val(json["Cityfrom"]);
                    $("#CityTo").val(json["Cityto"]);
                    $("#patWC").val(json["gstr_hospital_name"]);
                    
                    
                    var transfertypeflag=json["transfertypeflag"];
              //      alert("transfertypeflag"+transfertypeflag);
                    if(transfertypeflag==1){
						  if(json["addressproof"]){
							   var url3 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["addressproof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["addressproof"] + "</a>";
                       $('#imagetest3').html(url3);
                       }
                        $('#addressproof').show();
                        $('#transferorder').hide();
                         $('#joiningorder').hide();
					}else{
						   if (json["joiningorder"]) {
                        var url4 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["joiningorder"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["joiningorder"] + "</a>";
                       $('#imagetest2').html(url4);
                       }
					
                     if (json["transferorder"]) {
                   var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["transferorder"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["transferorder"] + "</a>";
                       $('#imagetest').html(url2);
                       }
                         $('#addressproof').hide();
                        $('#transferorder').show();
                         $('#joiningorder').show();
                       }
                    
                  
                      
			/*
                let html = "<tr>";
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["BenId"] + "</td>";
                html += "<td>" + json["Cityfrom"] + "</td>";
                html += "<td>" + json["Cityto"] + "</td>";
                  html += "<td>" + json["gstr_hospital_name"] + "</td>";
                    html += "<td>";
		       if (json["transferorder"]) {
		        html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["transferorder"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["transferorder"].split('_').slice(1).join('_') + "</a><br>";
		    }
		      if (json["joiningorder"]) {
		        html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["joiningorder"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["joiningorder"].split('_').slice(1).join('_') + "</a><br>";
		    }
		    
		    if(json["addressproof"]){
			  html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["addressproof"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["addressproof"].split('_').slice(1).join('_') + "</a><br>";

			}
                 html += "</td>";
                    html += "<td><select class='status-dropdown' data-id='" + json["BenId"] + "'>";
                       html += "<option value=''>Select Status</option>";
                html += "<option value='approved'>Approved & Forward</option>";
                html += "<option value='rejected'>Rejected</option>";
                html += "</select></td>";
             html += "<td><a class='btn btn-his-sm' onclick='cardtransferSubmit(\"" + json["BenId"] + "\")'>Submit</a></td>";

                    $("#getcardtransferdetails tbody").append(html);
                    $("#getcardtransferdetails").show();*/
                    
                    $('#patapplicationstatus').change(function(){
    	
    
   var statusvalue= $("#patapplicationstatus").val();
 //  alert("statusvalue");
    if(statusvalue==2)
    {
		$("#statushiddenflag").val("2");
		$("#remarksbox").show();
	}else{
			$("#statushiddenflag").val("1");
		$("#remarksbox").hide();
	}
    });
              
                indx++;
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}



document.querySelectorAll('.status-dropdown').forEach(dropdown => {
    dropdown.addEventListener('change', function() {
      // Get the selected value
      const selectedValue = this.value;
      
      // Get the data-id attribute
      const benId = this.getAttribute('data-id');
      
      // Log the selected value and data-id to the console
   alert(`BenId: ${benId}, Status: ${selectedValue}`);
      
      // You can use this data for any other logic you need, like updating the server or UI
    });
  });