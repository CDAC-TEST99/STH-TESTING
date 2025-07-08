
$(document).ready(function () {
	             
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
//	("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		//("Primary key"+arrpk[1]);
		
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
  
  
  function cardtransferSubmit(Benid)
  {

  var configJson={
    				serviceName:"/DMLSAVE/Updatecardtransferstatus",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"callbackSaveData",
    			 				
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
	Parent.closeModal();			
}
  
  
  
     function PopulatetransferDetails(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
    } else {
        let indx = 1;
        $("#getcardtransferdetails tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
				  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
			
              /*  let html = "<tr>";
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
                 html += "</td>";
                    html += "<td><select class='status-dropdown' data-id='" + json["BenId"] + "'>";
                html += "<option value='approved'>Approved & Forward</option>";
                html += "<option value='rejected'>Rejected</option>";
                html += "</select></td>";
             html += "<td><a class='btn btn-his-sm' onclick='cardtransferSubmit(\"" + json["BenId"] + "\")'>Submit</a></td>";


  var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwcintracity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[adcity],
    		}
                    $("#getcardtransferdetails tbody").append(html);
                    $("#getcardtransferdetails").show();
                indx++;*/
                
            //alert("city"+json["slno"]); 
               $('#transferferslno').val(json["slno"]);
                $("#patBenid").val( json["BenId"]);
                  $("#CityFrom").val(json["Cityfrom"]);
                    $("#CityTo").val(json["Cityto"]);
                    
                     $("#citytocodehidden").val(json["citytocode"]);

                    
               var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patWC",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["hospcodeid"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["citytoid"]],
    		}
    		    	callService(configJson);


 var transfertypeflag=json["transfertypeflag"];
            //        alert("transfertypeflag"+transfertypeflag);
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
                
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}


  function CardReceivedsubmit()
  {
	  if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
 var configJson = {
        serviceName: "/DMLSAVE/updatecardreceived",
        callBackFunctionName: "callbackSaveData",
       inputData: processSerializeArray("ENTRYFORM")
    };
     callService(configJson);
   }
  
  
  function callbackSaveData(configJson, dataJson) {
//    alert(JSON.stringify(configJson));

    // Check for ERROR in message
    if (dataJson["message"] && dataJson["message"].indexOf("ERROR") >= 0) {
        showMsg(dataJson["message"], null);
    } else {
        var dialogConfigJson = { callOnOK: "resetPagetransfer", parameterJson: {} };

        // Show success message
        showMsg(dataJson["message"], dialogConfigJson);

        // Extract values one by one
        var wcfrom = dataJson["wcfrom"];
        var wcto = dataJson["wcto"];
        var benIdStr = dataJson["benId"]; // "10020607,10020606"

        // Split benId by comma
        var benIds = benIdStr.split(",");

        if (benIds.length > 0) {
            var firstBenId = benIds[0];
          //  alert("First BenId: " + firstBenId);
            $('#Benidvalue').val(firstBenId);
        }

    //    alert("WC From: " + wcfrom);
    //    alert("WC To: " + wcto);
    }
}

  
function resetPage(){
		submitFormMaster("Receivecardtransfer","add");		
}


