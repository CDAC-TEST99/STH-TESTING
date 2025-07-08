  
 var initInputJson=null;
 listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "AD Card Approval",
	"listServiceName": "/getData/getAdCardApprovedList",
	"noOfRecordPerPage": "10",
	"noSearchSortColumnNo":[],
	"filters":[
		
	           {"filterId":"filterRecordStatus",
			  		 "filterLabel":"Card Type",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"","optionText":"Select Value"},
			  		 "serviceName":"/getData/getcardtypeforcardApproval"
				}
			 ], 
	"buttons": [
		{
			"buttonName": "btnReset",
			"buttonDisplayName": "Approve",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fas fa-edit",
			"onClickFunction": "listPageResetRecordDtl()",
			"onClickServiceName": "/DMLSAVE/approvedCardbyAd"
		},
			 {
			"buttonName": "Modify",
			"buttonDisplayName": "Modify",
			"buttonClass": "btn-his-outline-sm text-white selectbtn singleSelect",
			"buttonIcon": "far fa-edit",
			"onClickFunction": "submittonew(this)",
			"masterkey":"BeneficiaryData",
			"initMode":"modify",
		},
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
	var flag= confirm("Are you sure to Approve ?");
	if(flag==false)
		return;
	var serviceName=buttonJson["onClickServiceName"];
	var configJson={
			serviceName:serviceName,
			callBackFunctionName:"callbacklistpageSendSMS",				
			initMode:buttonJson["initMode"],
			inputData:{primaryKeys:arrPrimarykey}				
	}
	callService(configJson);
		
}

/*function submittonew(obj)
{	
	
	 var pk=$(obj).attr("data-pk");
	 
	 
	
	 $("#primaryKeys").val(decrypt(pk));
	alert("pkkkls"+ $("#primaryKeys").val());
	var arrpk = ($("#primaryKeys").val()).split("@");
	//alert("fvgfgfgffgf"+arrpk[1]);
	var relationid= arrpk[1];
	
	
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="submittonew(this)"){
				buttonJson=vobj;
			}
		});
		if(relationid==1)
		{
		var masterkey=buttonJson["masterkey"];
		}
		var initmode=buttonJson["initMode"];
		
		
		
		 $('#masterKey').val(masterkey);	 
		 $('#initMode').val(initmode);	 
		 $('#hmode').val("CallMasterPage");
		 showPreloader();
		 document.forms[0].submit();
		 
		//}
	 
}*/

function callbacklistpageSendSMS(configJson, dataJson)
{
	getDeletStatus(configJson, dataJson);
	if(dataJson["message"].indexOf("SUCCESS")>=0){
		if(dataJson["processName"].includes("BulkCardApprove") ){
						// call another service to get ben data --> then for them send sms.
			var primaryKeys = dataJson["primaryKeys"];
			
			var primaryKeysString = primaryKeys.join(", ");
			jsonObject={
           "primaryKeys":"",
   } 

   jsonObject.primaryKeys=primaryKeysString;

		var configJson={
			serviceName:"/getData/getBenInfoSMS",			
			callBackFunctionName:"callbackgetBenInfoSMS",
			 inputData: jsonObject,							
			} 
		callService(configJson);	
			
		}
		else{													// Not sending SMS as the process is not Bulk Approval 
			console.log("Failure: not sending sms");
		}
	}
	else{
		
	}
}

function callbackgetBenInfoSMS(configJson, dataJson){
	console.log(configJson);
	console.log(dataJson);

	if(dataJson["message"].indexOf("PROBLEM")>=0){
		
		}
		else{
		//	console.log(dataJson.data[0] );
		//	console.log(dataJson.data[1] );
			for (let i = 0; i < dataJson.data.length; i++) {
			  const item = dataJson.data[i];
			  var benId =` ${item.BenId}`;
			   var patMobile = ` ${item.MobileNum}`  ;
			    var trackingid = ` ${item.trackingid}` ; 
			 // console.log(`BenId: ${item.BenId}, Name: ${item.NAME}, Mobile: ${item.MobileNum}, Tracking ID: ${item.trackingid}`);
			    const data = new Array(trackingid,benId);
		  		const mobileNumbers = new Array(patMobile); 
		  		jsonObject ={
					"templateId":"",
					  "data":[],
		      	    "mobileNumbers":[],
				}
					jsonObject.templateId="1107174650929590714";
					jsonObject.mobileNumbers=mobileNumbers;
					jsonObject.data=data;
					
						var configJson = {
						serviceName:"/GETDATA/getMessageUsingTemplate",
						callBackFunctionName:"callbackSendSMSAJAX",
						inputData:jsonObject,
					}
					getTemplateMessageandSendSMS(configJson);
			}

		}
}
