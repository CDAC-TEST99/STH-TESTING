
 var initInputJson=null;
 listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "Organisation Dept Approval",
	"listServiceName": "/getData/getOrganisationList",
	"noOfRecordPerPage": "10",
	//"isCheckBoxRequired":false,
	"filters":[
	           {"filterId":"filterRecordStatus",
			  		 "filterLabel":"Status",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"1","optionText":"Pending"},
			  		 "serviceName":"/getData/getOrgStatus"
				}
			 ],
	
	"buttons": [{
			"buttonName": "Add",
			"buttonDisplayName": "Department Registration",
			"buttonClass": "btn-his-sm text-white  btn-sm",
			"buttonIcon": "fas fa-plus-circle",
			"onClickFunction": "listInitAddPage()",
		},
		{
			"buttonName": "Modify",
			"buttonDisplayName": "Approval Action",
			"buttonClass": "btn btn-default btn-info text-white btn-sm selectbtn singleSelect",
			"buttonIcon": "far fa-edit",
			"onClickFunction": "submittonew(this)",
			"onClickServiceName": "",
			"masterkey":"OrganisationApproval",
			"initMode":"modify",
			},
		
	]
}



$(document).ready(function () {
	
	 $('#funcDesgn').on('change', function() {
      var selectedValue = $(this).val();
					  alert(' Y Called');

      if (selectedValue === 'Y') {
		  $('#loginContainer').show();
      } else {
		  $('#loginContainer').hide();
      }
    });
    
    			             $('#saveType').val('U');

     var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });
   
    $('#LISTPAGE').removeClass('hideData');
    hidePreloader();
    createListPage(listPageConfigJson);

    $('#btnsave').click(saveData);
    $('#btnclear').click(clearData);

    $(".add-new").click(addNewRow);
    $('#cancelForm').click(backToListPage);
    
   
});

/*document.addEventListener('DOMContentLoaded', function () {
  const link = document.getElementById('applyNewOrgLink');
  link.addEventListener('click', function (event) {
    event.preventDefault(); // Prevents default anchor behavior
    // 👉 Your custom JS logic here
    console.log('Register New Organisation clicked');
   // alert('Register a new Organisation');
    
                            $('#EntryFormsId').show();
     
    // For example, show a hidden div:
  //  document.getElementById('registerFormSection').style.display = 'block';
  
 // Organization Name(DDO Code)
      $("label[for='orgName']").text("Organization Name(DDO Code)");
      $('#fileUploadDtlHeading .accordion-button').text('Update Organisation Details');
        $('#btnsave').html('<i class="fas fa-save"></i> &nbsp; Update');



  // Disable input (orgName)
             $('#orgName').prop('disabled', true);
         
			$('#orgTypedrpDwn').closest('.col-lg-3').hide();
						$('#orgType').closest('.col-lg-3').show();
				
							$('#ddoCd').closest('.col-lg-3').hide();

			 $('#orgType').prop('disabled', true);

            var txt = $('#patsubdeptserving option:selected').text();
            $('#orgName').val(txt);
             $('#saveType').val('U');
     var configJson={
    			serviceName:"/getData/getOrganisationDatabasedonDdoCd",
    			callBackFunctionName:"PopulateUpdateFields",
       			primaryKeys:[$('#patsubdeptserving').val()],
    		}
    	callService(configJson);

  });
  
    const reglink = document.getElementById('registerNewOrgLink');
    reglink.addEventListener('click', function (event) {
    event.preventDefault(); // Prevents default anchor behavior
    // 👉 Your custom JS logic here
    console.log('Register New Organisation clicked');
  //  alert('Register a new Organisation');
    
    			 		    $('#orgType').closest('.col-lg-3').hide();
                             $('#EntryFormsId').show();
     			           $('#orgTypedrpDwn').closest('.col-lg-3').show();
			               $('#orgName').prop('disabled', false);
			            //   $('#ddoCd').closest('.col-lg-3').show();


      $("label[for='orgName']").text("Organization Name");
      $('#fileUploadDtlHeading .accordion-button').text('New Registration');
        $('#btnsave').html('<i class="fas fa-save"></i> &nbsp; Save');
        
                           $('#EntryFormsId').show();
			               $('#orgName').val('');
			               $('#ddoCd').val('');
			               $('#orgCity').val('');
                           $('#orgAddress').val('');
                      //$('#gender').val(json["employee_gender"]);
                     // $('#location').val(json["location"]);
                          $('#nodalOfficer').val('');
                          $('#contactNo').val('');
                          $('#emailId').val('');

				             $('#saveType').val('A');

			var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"orgTypedrpDwn",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
			
		}

	callService(configJson);
   
        });
        
        var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });
			
       
});*/

/*function PopulateUpdateFields(configJson, dataJson){
	
	
		if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){		
					
				//	alert('function Called');
					 $('#orgCity').val(json["org_city"]);
                      $('#orgAddress').val(json["org_address"]);
                      //$('#gender').val(json["employee_gender"]);
                     // $('#location').val(json["location"]);
                       $('#nodalOfficer').val(json["org_contact_person"]);
                       $('#contactNo').val(json["org_contact_no"]);
                       $('#emailId').val(json["org_email_id"]);
                       });
                       }			
	 
}*/

			 function captureState() {
    const stateSelect = document.getElementById("stateCode");
    const selectedText = stateSelect.options[stateSelect.selectedIndex].text;

    // You can now use or save this text
    console.log("Selected State Text:", selectedText);

    // Example: Store in a hidden input if needed for form submission
    document.getElementById("stateTxt").value = selectedText;
  }

	 function captureCity() {
    const citySelect = document.getElementById("districtCode");
    const selectedTxt = citySelect.options[citySelect.selectedIndex].text;

    // You can now use or save this text
    console.log("Selected State Text:", selectedTxt);

    // Example: Store in a hidden input if needed for form submission
    document.getElementById("distTxt").value = selectedTxt;
  }
  
  function extractAfterDollar() {
    const selectElement = document.getElementById("patsubdepartment");
    const selectedValue = selectElement.value; // e.g., "D$87"
    
         alert('updated ddo code ');
         
                 var firstNm =   $('#frstNm').val()
                  var lstNm =   $('#lastNm').val()

		
		firstNm = firstNm + ' ' + lstNm;
		$('#nodalOfficer').val(firstNm);
		alert('first Name :- ' + firstNm);


    
    if (selectedValue.includes("$")) {
      const ddoCode = selectedValue.split("$")[1]; // "87"
      document.getElementById("updDddoCd").value = ddoCode;
     // ddoCd
     alert('updated ddo code ' + ddoCode);
           // document.getElementById("ddoCd").value = ddoCode;
            $('#ddoCd').val(ddoCode);

    } else {
      document.getElementById("updDddoCd").value = ""; // clear if invalid
    }
  }


function listInitAddPage(){
	
	initValidation('ENTRYFORM');
	 hidePreloader();
    $('#LISTPAGE').addClass('hideData');
    $('#ENTRYFORM').removeClass('hideData');
   // $('#EntryFormsId').addClass('hideData');
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	$('#applyNewOrgLink').hide();
	
	//$('#ddoCodeContainer').hide();
	$('#loginContainer').hide();
//	$('#paoCodeContainer').hide();
	$('#wordHide').show();
		
		//	#patsubdeptserving'.val()
	
	getModuleList();
	
	////////////////////////////
    
    const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-mm-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });
    
     $("#Patdorpensioner").datepicker({
    // minDate: new Date(),  // Remove or comment this out to allow dates before today
    dateFormat: "dd-mm-yy",  // Format the date as day-month-year (e.g., 09-Nov-24)
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

  //////////////////////////////////
	
	/*var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
			
		}

	callService(configJson);
	
	$('#patdeptserving').change(function(){
		
		        var selectedText = $('#patdeptserving option:selected').text();
    	
		    	$('#orgType').val(selectedText);
		    	$('#orgType').replaceWith(`
  <input type="text" id="orgType" class="form-control form-control-sm" value="${selectedText}" readonly>
`);
				$('#applyNewOrgLink').hide();
				$('#EntryFormsId').hide();
				$('#btnsave').html('<i class="fas fa-save"></i> &nbsp; Save');


    	if($('#patdeptserving').val()=="")
    	{
    		$('#patsubdeptserving').html("<option value=''>Select Organisation Name</option>");
    		$('#applyNewOrgLink').hide();
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdeptserving').val()],
    		}
    	//	alert('org_type' + $('#patdeptserving').val());
    	callService(configJson);

    });
    

    $('#patsubdeptserving').change( function(){
    	
    	$('#btnsave').html('<i class="fas fa-save"></i> &nbsp; Save');
    	$('#EntryFormsId').hide();
    	if($('#patsubdeptserving').val()=="")
    	{
    		$('#patdeptorgserving').html("<option value=''>Select Organization</option>");
    		$('#applyNewOrgLink').hide();
    		return;    		
    	} else {
			$('#applyNewOrgLink').show();
		}
    	var configJson={
    			serviceName:"/getData/getOrganization",
    			comboId:"patdeptorgserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organization"},
    			primaryKeys:[$('#patsubdeptserving').val()],
    		}
    		
    	callService(configJson);*/
    	
    /* // alert('value of organisation name ' + $('#patsubdeptserving').val());
    		var configJson={
    			serviceName:"/getData/getdeptonlineflag",
    			callBackFunctionName:"Populatedeptonline",
       			primaryKeys:[$('#patsubdeptserving').val()],
    		}
    	callService(configJson);
    });*/
    
    
    //////////////////////  NEW CODE  - 
    
     var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
    	$('#patsubdepartment').change(function(){
		    	
    	if($('#patsubdepartment').val()=="")
    	{
    		$('#patdepartment').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	alert("7jdhjhdjhdjhjd"+ $('#patsubdepartment').val());
    	  var input=$('#patsubdepartment').val();
    	 
           const parts = input.split('$');

          const orgtypeid = parts[0]; // "16"
            const ddocode = parts[1]; // "122"
            
            

//alert(orgtypeid); // Outputs: 16
//alert(ddocode); // Outputs: 12
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    		callService(configJson);
    	});
    	
    	
    	
    	/*var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[json["orgid"]],
    		}
    		callService(configJson);
    		*/
    		
    			
}	  






function saveData(){
	
	
	$('#patdeptserving').hide(); 
    $('#patsubdeptserving').hide();
	if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    
    
    var configJson = {
	        serviceName: "/DMLSAVE/proc_update_add_org_detls",
	        callBackFunctionName: "callbackSaveData",
             inputData: processSerializeArray("ENTRYFORM"),
               
	    };
	
	 callService(configJson);

}


function callbackSaveData(configJson, dataJson){
	 //alert(JSON.stringify(dataJson));
	//alert("config json>>>>>>>>>>>>>>>>>"+JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"backToListPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
		
			}
	
	//$('#primaryKeys').val(9050401);
	
	// submitFormMaster("","add");
}



function clearData(){
	
	//alert("check clear");
	
	 document.querySelectorAll('select').forEach(function(select) {
        select.selectedIndex = 0;  
    });

   
    document.querySelectorAll('textarea').forEach(function(textarea) {
        textarea.value = '';  
    });

   
    document.querySelectorAll('input').forEach(function(input) {
       
        if (input.type === 'date' || input.type === 'time') {
            input.value = '';
        }
    });

  
	
}



function getModuleList(){
	var configJson={
			serviceName:"/getData/getmodulelist",
			comboId:"modid",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Module"}	
			
		}
	callService(configJson);
	
}

function backToListPage(){
	
	//$('#masterKey').val("complaindesk");
		submitFormMaster("OrganistnDeptApproval");

//	submitFormWithResetTextField("OrganistnDeptApproval");
}


function validatePhoneNumber(input) {
    // Remove any non-numeric characters
    input.value = input.value.replace(/\D/g, ''); 

    // Enforce only 10 digits by trimming extra characters
    if (input.value.length > 10) {
      input.value = input.value.substring(0, 10); // Allow only 10 digits
    }
  } 
  
   $("#Patdorpensioner").datepicker({
    // minDate: new Date(),  // Remove or comment this out to allow dates before today
    dateFormat: "dd-mm-yy",  // Format the date as day-month-year (e.g., 09-Nov-24)
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

/*function handleDdoPaoCheckbox(checkbox) {
    if (checkbox.checked) {
    $('#ddoCodeContainer').show();
//	$('#paoCodeContainer').show();      // Add your logic here
    	$('#wordHide').hide();

    } else {
		 $('#ddoCodeContainer').hide();
		 	$('#wordHide').show();

	//$('#paoCodeContainer').hide(); 
	}
  }*/