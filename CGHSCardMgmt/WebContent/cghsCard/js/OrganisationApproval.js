$(document).ready(function () {
		initPage();

});
function initPage(){
	
	var pkid=$('#primaryKeys').val();
//	alert('Pk value :- ' + 	pkid);

var configJson={
    			serviceName:"/getData/getOrganisationDatabasedonId",
    			callBackFunctionName:"PopulateUpdateFields",
       			primaryKeys:[pkid],
    		}
    	callService(configJson);

	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	}
	
	function PopulateUpdateFields(configJson, dataJson){
	
	
		if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){		
				//	alert('function Called');
					 $('#orgType').val(json["org_name_type"]);
					 $('#orgName').val(json["orgNameDept"]);
					 $('#orgCity').val(json["org_city"]);
                      $('#orgAddress').val(json["org_address"]);
                      $('#ddoCd').val(json["org_ddo_code"]);

                      //$('#gender').val(json["employee_gender"]);
                     // $('#location').val(json["location"]);
                       $('#nodalOfficer').val(json["org_contact_person"]);
                       $('#contactNo').val(json["org_contact_no"]);
                       $('#emailId').val(json["org_email_id"]);
                       });
                       }			
	 
}

 function saveAction(saveType){
	 
	 
	 if(saveType == 'approve') {
       $('#flag_type').val('A');
       
       const loginId = $('#emailId').val();
    //   alert(loginId);
       
     //  var confirmhashedPassword = securePassword(loginId, '123456');
	//   $('#hashPassword').val(confirmhashedPassword);
       
    //   alert('hashed Pass' + confirmhashedPassword);
        var configJson = {
        serviceName: "/DMLSAVE/proc_update_org_approval",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
	 }
	 
	 if(saveType == 'reject'){
       $('#flag_type').val('R');
       
       var configJson = {
        serviceName: "/DMLSAVE/proc_update_org_approval",
        callBackFunctionName: "callbackRejectData1",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
	 }
	
}

function securePassword(userName, password) {
    var hashValue = "";

       var objPassHash = new jsSHA(password + userName, "ASCII");
    try {
        hashValue = objPassHash.getHash("SHA-256", "HEX");
    } catch (e) {
      //  alert("Error hashing password!");
        return false;
    }

      //  alert('hashValue' + hashValue);
       return hashValue;
}
	

	
function callbackSaveData1(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}
		
		
		showMsg(dataJson["message"],dialogConfigJson)
		
		 var configJson = {
            serviceName: "/DMLSAVE/proc_new_user_creation",
             callBackFunctionName: "callbackSaveData",
             inputData: processSerializeArray("ENTRYFORM")
 				   };
        		    callService(configJson);
	}
}
	
  
function resetPage1(){
//alert("iinn reset page");/CGHSCardMgmt/WebContent/cghsCard/jsp/OrganistnDeptApproval.jsp
	submitFormMaster("OrganistnDeptApproval", "modify");
}

function callbackSaveData(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		
		
		showMsg(dataJson["message"],dialogConfigJson)
		
	}
}
	
  
function resetPage(){
//alert("iinn reset page");/CGHSCardMgmt/WebContent/cghsCard/jsp/OrganistnDeptApproval.jsp
	submitFormMaster("OrganistnDeptApproval", "modify");
}

function callbackRejectData1(configJson, dataJson){
	
	//alert('Rejected');
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)

		
	}
}
	