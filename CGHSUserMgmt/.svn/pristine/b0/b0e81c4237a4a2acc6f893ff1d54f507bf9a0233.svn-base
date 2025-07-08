 var initInputJson=null;
 listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "Skip Otp",
	"listServiceName": "/getData/getuserlistForSkipOtp",
	"noOfRecordPerPage": "10",
	"noSearchSortColumnNo":[],
	"filters":[{"filterId":"filterRecordStatus",
			  		 "filterLabel":"Skip Status",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"0","optionText":"No"},
			  		 "serviceName":"/getData/getSkipStatus"
				}
			], 
	"buttons": [
		{
			"buttonName": "btnSkipOtp",
			"buttonDisplayName": "Skip Otp",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fa-solid fa-ban",
			"onClickFunction": "listPageDeleteRecordDtl()",
			"onClickServiceName": "/DMLSAVE/updateSkipOtp"
		},
		{
			"buttonName": "btnUnSkipOtp",
			"buttonDisplayName": "Revoke Skip Otp",
			"buttonClass": "btn-his-outline-sm selectbtn",
			"buttonIcon": "fa-solid fa-ban",
			"onClickFunction": "listPageUnskipRecordDtl()",
			"onClickServiceName": "/DMLSAVE/updateRevokeSkipOtp"
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

function listPageDeleteRecordDtl(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	var listJson= JSON.parse($('#spanConfigJson').html());
	var buttonJson=null;
	// getting buttonobj from json whose onclick function is listPageDeleteRecordDtl
	$.each(listJson["buttons"],function(key,vobj){
		if(vobj["onClickFunction"]=="listPageDeleteRecordDtl()"){
			buttonJson=vobj;
		}
	});
	var flag= confirm("Are you sure want to Skip otp for selected user ?");
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

function listPageUnskipRecordDtl(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	var listJson= JSON.parse($('#spanConfigJson').html());
	var buttonJson=null;
	// getting buttonobj from json whose onclick function is listPageDeleteRecordDtl
	$.each(listJson["buttons"],function(key,vobj){
		if(vobj["onClickFunction"]=="listPageUnskipRecordDtl()"){
			buttonJson=vobj;
		}
	});
	var flag= confirm("Are you sure want to Revoke Skip otp for selected user ?");
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

function buttonEnable(val) {
	
	var arrPrimarykey=getPrimaryKeyFromListPage();
		//alert(arrPrimarykey);
		
		var count=arrPrimarykey.length;
		
		if(count>=1){
			
		
	
	if($('#filterRecordStatus').val()==0){
		$('#btnUnSkipOtp').hide();
		$('#btnSkipOtp').show();
		
	}
	else{
		$('#btnUnSkipOtp').show();
		$('#btnSkipOtp').hide();
	}
	
	}
	else{
		$('#btnUnSkipOtp').hide();
		$('#btnSkipOtp').hide();
	}
	
}
