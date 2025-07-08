
$(document).ready(function () {
    initPage();
});

function initPage() {
    hidePreloader();
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	
	
   /*
    //resetPages();
    $("#detailsTableContainer").show();

    const Benidvalue = $('#primaryKeys').val().split('@')[0];
   // alert("BenId>>>>>>>>>>>"+Benidvalue);
    $("#Benid").val(Benidvalue);
  //  alert("BenId>>>>>>>>>>>"+Benid);
    var configJson={
    				serviceName:"/getData/getBeneficiaryDetails",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"PopulateBeneficiaryDetails",
    			 				
    			}
    		callService(configJson);
    		
    		

 var configJson={
    				serviceName:"/getData/getfamilymembersApprovedbyAd",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
    		
    		//alert("ytrytrfgf");
    		 var configJson={
    				serviceName:"/getData/getBeneficiarypaymentDetails",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"populatePaymentdetails",
    			 				
    			}
    		callService(configJson);
    		
    		
			 var configJson={
			serviceName:"/getData/getADApprovestatus",
			comboId:"deptaction",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Action"}	
		}
		callService(configJson);
		
		 $('#deptaction').change(function(){
	  var deptactionvalue=$('#deptaction').val();
	  if(deptactionvalue==1)
	  {
		     $('#remarksbox').hide();
		      $('#approvestatus').show();
		     
	  }else
	  {
		   $('#remarksbox').show();
		      $('#approvestatus').show();
	  }
	  });

    $('#hiddenUserId').val(Benid);
    
    */

    
}

function getBeneficiarydetails()
{
	const Benidvalue = $('#Benid').val();
	//alert("111"+Benidvalue);
	$("#patBenId").val(Benidvalue);
	 var configJson={
    				serviceName:"/getData/getBeneficiaryDetails",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"PopulateBeneficiaryDetails",
    			 				
    			}
    		callService(configJson);
    		
    	
 var configJson={
    				serviceName:"/getData/getfamilymembersformodification",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
    		
    		//alert("ytrytrfgf");
    		 var configJson={
    				serviceName:"/getData/getBeneficiarypaymentDetails",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"populatePaymentdetails",
    			 				
    			}
    		callService(configJson);
    			
    		
}
    
    function Approve()
    {
		
	//alert("4444444444");
	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  
  
    var configJson = {
        serviceName: "/DMLSAVE/ApprovecardByadafterModify",
        callBackFunctionName: "callbackSaveData2",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackSaveData2(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage2","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}


function resetPage2()
{
	parent.closeModal();
}
   
      
   function populatefamilymembers(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
      showAlertMsg("No Data Found", "danger", "alertMsg");

    } else {
        let indx = 1;
        $("#AutoNumber1 tbody").empty();

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
				//alert("relationid"+json["relationid"]);
				var benid=json["memberid"];
				  var flag = json["flag"]; // Get the flag value from JSON
					   let selfRow = null; // Variable to hold the "self" row data
					if (flag == 1) {
					    flag = "Active"; // If flag is 1, set it to "Active"
					} else {
					    flag = "DeActive"; // If flag is not 1, set it to "DeActive"
					}
                let html = "<tr>";
                html += "<td class='slno'>" + indx + "</td>";
                html += "<td>" + json["memberid"] + "</td>";
                html += "<td>" + json["memberName"] + "</td>";
                html += "<td>" + json["Dob"] + "</td>";
                html += "<td>" + json["Relation"] + "</td>";
                html += "<td>" + json["gender"] + "</td>";
             /*   html += "<td>" + json["gstr_hospital_name"] + "</td>";
                html += "<td>" + json["gstr_cardtype_name"] + "</td>";*/
                html += "<td>" + json["validupto"] + "</td>";
				 html += "<td>" + flag + "</td>";	
              //  alert(json["Photoname"]);
               // We call getFileFromFileName asynchronously
                getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
                   // alert("result>>>>>>>>>>>>>>>>>>>>>"+result); // Check the raw result
                    if (result) {
                        var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
                        var base64Image = "data:image/jpeg;base64," + cleanedBase64;

                        // Check if base64 string is valid
                       // alert("base64Image: " + base64Image);
                        console.log("base64Image: ", base64Image);

                        // Add the base64 string as an image tag inside a table cell
                        html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";



                        // Add the button after the image

                    } else {
                        // Handle the error when result is not valid
                        html += "<td>No image available</td>";
              
                    }
/*
              if (flag==="DeActive") {
			    html += "<td></td>"; // If Relation is "Self" or flag is 2, leave the <td> empty
			} else {
            html += "<td><a class='btn btn-his-sm' onclick='Downloadcard(\"" + json["memberid"] + "\")'>Download</a></td>";
			    // If the condition is not met, add the button with the onclick event
			}*/
                      /* if (json["Relation"] === "Self") {
                        html += "<td></td>"; // If Relation is "Self" or flag is DeActive, leave the <td> empty
                    } else {*/
                      html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["memberid"] + "\", \"" + json["relationid"] + "\", this)'>Edit</a></td>";                   
html += "<td><input type='checkbox' class='member-checkbox' name='depcheckbox' value='" + json["memberid"] + "'></td>";
/*}*/
                  
                      $("#AutoNumber1 tbody").append(html);
                    $("#AutoNumber1").show();
                    
                               // Update the serial numbers (slno)
    var index = 1;
    $('.slno').each(function() {
        $(this).text(index);
        index++;
   });
                    
                });

                
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}
function PopulateBeneficiaryDetails(configJson, dataJson) {
    	 //   alert("configJson>>> " + JSON.stringify(configJson));
    	  //alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
				hidePreloader();
				 if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
         showAlertMsg("No Data Found Beneficiary Belongs to another City", "danger", "alertMsg");

    }else{
    	 
    	 
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					//alert(json["allow_depend_only"]);
					
				var resfileupload=	json["resdocupload"];
                //  alert(resfileupload);
                  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
                  var url = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["resdocupload"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["resdocupload"] + "</a>";
					
					$('#imagetest').html(url);
                                   //  alert("jsonfmafacility>>>>>>>>"+json["fmafacility"]);
                                 
                       var PPODocument=json["PPOdocument"];
                        // alert("PPODocument>>>"+PPODocument);
                    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["PPOdocument"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
                       $('#imagetest1').html(url1);
                       
                                var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["depspouse_doc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["depspouse_doc"] + "</a>";
                       $('#imagetest2').html(url2);
                       
                      $('#patName').val(json["FirstName"]);
                      $('#patNameHindi').val(json["FirstName"]);
                      $('#patDOB').val(json["DOB"]);
                     // $('#patGender').val(json["gstr_gender_name"]);
                      $('#patMobileNo').val(json["Mobileno"]);
                      $('#statecode').val(json["gstr_statename"]);
                       $('#PatientCghsCity').val(json["gstr_city_name"]);
                     // $('#patrelation').val(json["relation"]);
                      
                              $('#patadcity').val(json["parent_city_name"]);
                                 $('#parentcitycodehidden').val(json["adcitycode"]);
                              
                              
                        $('#statecode').val(json["gstr_statename"]);
                        
                     /*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
                       $('#patEmail').val(json["EmailId"]);
                        $('#patresaddress').val(json["resdaddress"]);
                    
                    
                         $('#PatCardtype').val(json["gstr_cardtype_name"]);
                        // alert("hospital"+json["gstr_hospital_name"]);
                          $("#patientwc").val(json["gstr_hospital_name"]);
                         $("#patientwchidden").val( json["gnum_hospital_code"]);
                       
                $("#patDOB").datepicker({
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
    

                         
                         var configJson={
						serviceName:"/getData/getGenderList",
						comboId:"patGender",			
						callBackFunctionName:"commonPopulateCombo",
						defaultOption:{"optionValue":json["genderId"],"optionText":""}	
			
		}
	callService(configJson);
	
	var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "patrelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": json["relation"],
            "optionText": "Select Relation"
        }
    };
     callService(configJson);
	
             var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["satellitecitycode"],"optionText":"Select City"}
			
			
	   	}
	          callService(configJson);
	          
	           $('#PatientCghsCity').change(function(){
    	
	var configJson={
    			serviceName:"/getData/getADCityBasedonsatelliteCity",
      			callBackFunctionName:"populatecity",			
        		primaryKeys:[$('#PatientCghsCity').val()],
    		}
    	callService(configJson);
    });

	//   alert("wccode"+json["gnum_hospital_code"]);
/*	    var configJson={
			serviceName:"/getData/getWellnesscenter",
			comboId:"PatientWc",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_hospital_code"],"optionText":"Select WellnessCenter"},
		   
			
	   	}
	          callService(configJson);
	   */
	   	
    /*
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["gnum_hospital_code"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["adcitycode"]],
    		}
    	callService(configJson);
	   */
	 
                 var cardtype=json["gstr_cardtype_name"];
                // alert(cardtype);
                  var year=json["deputationyear"];
                 var cardtypevaluecategory=json["cardtype"];
           //    alert(cardtypevaluecategory);
              if(cardtypevaluecategory=='P')
                {
					//alert("validupto"+json["validupto"]);
					$('#cardtypevaluehidden').val("P");
				$('#patlastpaypensioner').val(json["lastpay"]);
				   var ppono=json["PPONo"];

					$('#servingdept').hide();
					$('#pensionerdept').show();
					  $('#patdeptpensioner').val(json["gstr_service_dept_name"]);
					$('#PatCardtypeP').val(json["cardtype"]);
					$('#PatsubCardtypeP').val(json["gstr_cardtype_name"]);
										
       			 $('#patcardvalidtoP').val(json["validupto"]);

				  $('#Patppopensioner').val(json["PPONo"]);
					 $('#patfmapensioner').val(json["treatmenttype"]);
			    $('#CardApplyvalidity').val(json["cardapplyvalidity"]);
			    $('#Patdorpensioner').val(json["DateofRetirement"]);
			    $('#Existingbenid').val(json["existingbenid"]);
			//     $('#patcardcategoryP').val(json["cardcategory"]);
			//	alert(json["gstr_fma_facility"]);
			
               //  $('#patfmafacilitypensioner').val(json["gstr_fma_facility"]);
          
		 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardtypecategorypen",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategoryid"],"optionText":"Select Card Category "},
			primaryKeys:[json["cardtype"]],
			
		}
	callService(configJson);
	
 $('#patcardtypecategorypen').change(function(){
    	
    	if($('#patcardtypecategorypen').val()=="")
    	{
    		$('#patsubcardtypepensioner').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypepensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardtypecategorypen').val()],
    		}
    	callService(configJson);
    	
   
    	
    });
    
    var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypepensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["subcategoryid"],"optionText":"Select SubCategory"},
    			primaryKeys:[json["cardcategoryid"]],
    		}
    	callService(configJson);
    	
     
        //alert("payscale"+json["payscaleid"]);
     var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscalelevelP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["gnum_pay_scales"]],
    		}
    	callService(configJson);
    	
	
	   $('#patpayscalelevelP').change(function(){
	    	
	    	if($('#patpayscalelevelP').val()=="")
	    	{
	    		$('#patpayscalevalueP').html("<option value=''>Select values</option>");
	    		return;    		
	    	}
	    	var configJson={
	    			serviceName:"/getData/getpayscalevalues",
	    			comboId:"patpayscalevalueP",			
	    			callBackFunctionName:"commonPopulateCombo",
	    			defaultOption:{"optionValue":"","optionText":"Select values"},
	    			primaryKeys:[$('#patpayscalelevelP').val()],
	    		}
	    	callService(configJson);
	    	
	    	
	    });
	
  	var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalueDept",
			comboId:"patBasicpayP",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["basicpay"],"optionText":"Select BasicPay"},
			
		}
	callService(configJson);
	
    	
    	var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalueDept",
			comboId:"patBasicpayP",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["basicpay"],"optionText":"Select BasicPay"},
			
		}
	callService(configJson);
	
	var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpayDept",
    			comboId:"patentitlementP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Payscale"},
    			
    		}
    	callService(configJson);
  
    
    
    $('#patpayscalevalueP').change(function(){
		
		
		 var salary= $( "#patpayscalevalueP option:selected" ).text();
		
		
	var basiclevel=	validateSalary(salary);
	
	
		var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalue",
			comboId:"patBasicpayP",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["basicpay"],"optionText":"Select BasicPay"},
			primaryKeys:[basiclevel],
		}
	callService(configJson);
	
		
	 });
	


    $('#patBasicpayP').change(function(){
    	
    	if($('#patBasicpayP').val()=="")
    	{
    		$('#patentitlementP').html("<option value=''>Select Payscale</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patBasicpayP').val()],
    		}
    	callService(configJson);
    });
/*
				   var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"patentitlementpensioner",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);
	      
	      	  
		    var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscalepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		      }
	         callService(configJson);
						
	 var configJson={
			serviceName:"/getData/getdepartmentpepensioner",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
		}
	callService(configJson);*/
/*	alert("validity>>>>"+json["cardapplyvalidity"]);
	 var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"patCardApplyValidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);*/
	
	/*
var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"patppodoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[40],
    		}
    	callService(configJson);
	
	//alert($('#patppodoctypeid').val());
	
    $('#patppodoctypeid').change(function(){
	//	alert($('#patppodoctypeid').val());
    	
    	if($('#patppodoctypeid').val()=="")
    	{
    		$('#patCardApplyValidity').html("<option value=''>Select Cardvalidity</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getcardvalidity",
    			comboId:"patCardApplyValidity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select Card Validity"},
    			primaryKeys:[$('#patppodoctypeid').val()],
    		}
    	callService(configJson);
    });
*/

	var configJson={
    			serviceName:"/getData/getcardvalidityforofflinepen",
    			comboId:"patCardApplyValidity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select Card Validity"},
    		
    		}
    	callService(configJson);
	
	//alert("FMA");
	 var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
		}
	callService(configJson);
	//alert(json["facilitycode"]);
	  $('#patfmapensioner').change(function(){
		//   alert("1111");
		 
    	if($('#patfmapensioner').val()=="")
    	{
    		$('#patfmafacilitypensioner').html("<option value=''>Select Facility</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[$('#patfmapensioner').val()],
    		}
    	callService(configJson);
    	    });
    	    alert(json["orgid"]+'$'+json["ddocode"]);
    	    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"]+'$'+json["ddocode"],"optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
  	$('#patsubdepartmentP').change(function(){
		    	
    	if($('#patsubdepartmentP').val()=="")
    	{
    		$('#patdepartmentP').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	//alert("7jdhjhdjhdjhjd"+$('#patsubdepartmentP').val());
    	  var input=$('#patsubdepartmentP').val()
    	 
           const parts = input.split('$');

          const orgtypeid = parts[0]; // "16"
            const ddocode = parts[1]; // "122"

//alert(orgtypeid); // Outputs: 16
//alert(ddocode); // Outputs: 12
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    		callService(configJson);
    	});
    
    		var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[json["orgid"]],
    		}
    		callService(configJson);
    	/*    var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdepartmentP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdepartmentP').change(function(){
    	
    	if($('#patdepartmentP').val()=="")
    	{
    		$('#patsubdepartmentP').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdepartmentP').val()],
    		}
    	callService(configJson);
    });
    var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["ddocode"],"optionText":"Select District"},
    			  primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);
	
	*/
	  
	  var configJson={
			serviceName:"/getData/getfmalistfacility",
			comboId:"patfmafacilitypensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["facilitycode"],"optionText":"Select FMA facility"}	
		}
	callService(configJson);
	/*
	$("#patcardvalidtoP").datepicker({ minDate:new Date , 
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
    */
    
   	$("#patcardvalidtoP").datepicker({
    minDate: new Date(),  // Today's date as the minimum
    maxDate: new Date(2099, 11, 31),  // Adjust to the desired end date
    dateFormat: "dd-M-yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "2024:2099",  // Set the range explicitly
    showButtonPanel: true,
    showOtherMonths: true,
    selectOtherMonths: true,
    onSelect: function (date, datepicker) {
        console.log(date);  // Debug selected date
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
    
			
			 $('#BTNPayment').show();		
		
				}else{
					
				//	alert("serving");
					
					$('#cardtypevaluehidden').val("S");
					$('#servingdept').show();
					$('#pensionerdept').hide();
				$('#PatCardtypeS').val(json["gstr_cardtype_name"]);
				 $('#patcardvalidto').val(json["validupto"]);
                   //  $('#PatCardtypeS').val(json["cardtype"]);
              //  alert(json["officeaddress"]);
                  $ ("#patofcadrserving").val(json["officeaddress"]);
                   
                   
                   if(json["allow_depend_only"]=='1')
                   {
					 //  alert("iinn");
					   $("#patallowdeponly").val("Y");
					 			 
				   }else 
				   {
				     $("#patallowdeponly").val("N");
				   }
                 //  alert("categoryiiidddddd"+json["cardcategoryid"]);
					 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardcategoryserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategoryid"],"optionText":"Select CardCategory"},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
		}
	callService(configJson);
	
	 $('#patcardcategoryserving').change(function(){
    	
    	if($('#patcardcategoryserving').val()=="")
    	{
    		$('#patsubcardtypeserving').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypeserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardcategoryserving').val()],
    		}
    	callService(configJson);
    	
    	
    });
  //  alert("subcategory>>>>>>>>>>"+json["subcategoryid"]);
    var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypeserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["subcategoryid"],"optionText":"Select SubCategory"},
    			primaryKeys:[json["cardcategoryid"]],
    		}
    	callService(configJson);
			
			
	
	  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscaleserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	/*
	
      var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);
    	*/
    	
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["gnum_pay_scales"]],
    		}
    	callService(configJson);
    	var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalueDept",
			comboId:"patBasicpayserving",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["basicpay"],"optionText":"Select BasicPay"},
			
		}
	callService(configJson);
	
	var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpayDept",
    			comboId:"patentitlementserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Payscale"},
    			
    		}
    	callService(configJson);
	
	
		 $('#patpayscaleserving').change(function(){
    	
    	if($('#patpayscaleserving').val()=="")
    	{
    		$('#patpayscalevalueserving').html("<option value=''>Select values</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select values"},
    			primaryKeys:[$('#patpayscaleserving').val()],
    		}
    	callService(configJson);
    	
    	
    });
    
    
    $('#patpayscalevalueserving').change(function(){
		
		
		 var salary= $( "#patpayscalevalueserving option:selected" ).text();
		
		
	var basiclevel=	validateSalary(salary);
	
	
		var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalue",
			comboId:"patBasicpayserving",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"},
			primaryKeys:[basiclevel],
		}
	callService(configJson);
	
		
	 });
	

			

    $('#patBasicpayserving').change(function(){
    	
    	if($('#patBasicpayserving').val()=="")
    	{
    		$('#patentitlementserving').html("<option value=''>Select Payscale</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patBasicpayserving').val()],
    		}
    	callService(configJson);
    });
    
   // alert("gvdhghdghdghdg"+json["orgid"]+'$'+json["ddocode"]);
	 var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"]+'$'+json["ddocode"],"optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
   	$('#patsubdeptserving').change(function(){
    	
    	if($('#patsubdeptserving').val()=="")
    	{
    		$('#patdeptserving').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
    	  var input=$('#patsubdeptserving').val()
    	 
           const parts = input.split('$');

          const orgtypeid = parts[0]; // "16"
            const ddocode = parts[1]; // "122"

//alert(orgtypeid); // Outputs: 16
//alert(ddocode); // Outputs: 12
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    	callService(configJson);
    });
		var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);
	 $('#Patdorserving').val(json["DateofRetirement"]);
					   $("#dorservinghidden").val(json["DateofRetirement"]);

let dorStr = json["DateofRetirement"]; // e.g., "22-06-2027"
let dorDate = parseDDMMYYYY(dorStr);


	      $("#Patdorserving").datepicker({
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

$("#patcardvalidto").datepicker({
    minDate: new Date(),          // Today
    maxDate: dorDate,             // DOR
    dateFormat: "dd-M-yy",        // Display format
    changeMonth: true,
    changeYear: true,
    yearRange: "2024:2099",
    showButtonPanel: true,
    showOtherMonths: true,
    selectOtherMonths: true,
    onSelect: function (date, datepicker) {
        console.log("Selected date:", date);
    }
});
/*	  var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdeptserving').change(function(){
    	
    	if($('#patdeptserving').val()=="")
    	{
    		$('#patsubdeptserving').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdeptserving').val()],
    		}
    	callService(configJson);
    });
	*/
	
/*	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["ddocode"],"optionText":"Select District"},
    			  primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);
	*/
	/*	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    	callService(configJson);*/
	
						$('#BTNMODIFY').show();	
    
	
	 $("#patcardvalidfrom").datepicker({
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

/*
$("#patcardvalidto").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	//yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });  */
    
    	
			
				
				}
				
				
	//alert("Designation");
	/* var configJson={
			serviceName:"/getData/getDesignationList",
			comboId:"patdesignationserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Designation"],"optionText":"Select Designation"}	
		}
	callService(configJson);*/
                      
                $('#officeaddress').val(json["officeAddress"]);
                $('#displayuserinfo').show();
 });      

 
 
           }
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
    	 
    
    }
				
    
    	}
    	
    		function validateSalary(salary) {
		//alert("salary");
    // Check if salary is less than or equal to 36,500
    if (salary <= 36500) {
        return 1;  // Return 1 if salary is less than or equal to 36,500
    } 
    // Check if salary is between 36,501 and 50,500
    else if (salary > 36500 && salary <= 50500) {
        return 2;  // Return 2 if salary is between 36,501 and 50,500
    } 
    // Salary is 50,500 or more
    else {
        return 3;  // Return 3 if salary is 50,500 or more
    }
}

function populatecity(configJson, dataJson){
			//  alert("configJson>>> " + JSON.stringify(configJson));
    	
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               var parentcitycodevalue=json["parentcitycode"];
               $('#parentcitycode').val(parentcitycodevalue);
           
               var parentcityname=json["parentcityname"];
          
			     $('#patadcity').val(parentcityname); 
			     
		/*	     
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[parentcitycodevalue],
    		}
    	callService(configJson);*/
	
		
    });
			     
			   
                 
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
		}
		
 function parseDDMMYYYY(dateStr) {
    const [day, month, year] = dateStr.split("-");
    return new Date(`${year}-${month}-${day}`); // ISO format
}

function saveData1()
{
//	alert("4444444444");
/*	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }*/
  
  
    var configJson = {
        serviceName: "/DMLSAVE/UpdateBendetailsall",
        callBackFunctionName: "callbackSaveDataUpdateBendetailsall",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackSaveDataUpdateBendetailsall(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
		//alert(JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
	}
	else{
		var dialogConfigJson={callOnOK:"getBeneficiarydetails","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
function getFileFromFileName(fileName, hospname, callback) {
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/gettestimg',
        type: 'POST',
        contentType: 'application/json',    // Sending JSON
        dataType: 'text',                   // Expecting plain text response
        data: JSON.stringify({ 
            filename: fileName, 
            hospname: hospname 
        }),
        success: function(response) {
            console.log('Data received:', response);
            if (typeof callback === 'function') {
                callback(response);
            } else {
                console.warn('Callback is not a function.');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            console.error('Status:', status);
            console.error('Response:', xhr.responseText);
            alert('An error occurred while processing your request.');
        }
    });
}



  function populatePaymentdetails(configJson, dataJson) {
	  
	// alert("11111111111");
		if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
      showAlertMsg("No Data Found", "danger", "alertMsg");
      
      $("#paymentdiv").show();

    } else {
		
		
	           var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
     
        $("#PaymentDetail tbody").empty();
       let  indx=1;

        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function(_, json) {
				 
			
                let html = "<tr>";
                html += "<td class='paymentslno'>"+indx+"</td>";
                   html += "<td>" + json["Benid"] + "</td>";
                  html += "<td>" + json["RefrenceNo"] + "</td>";
                html += "<td>" + json["paymentvalidfrom"] + "</td>";
                html += "<td>" + json["paymentvalidto"] + "</td>";
                html += "<td>" + json["paymentamount"] + "</td>";
           
           html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["paymentreceipt"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["paymentreceipt"].split('_').slice(1).join('_') + "</a><br>";
        
                html += "<td>";
if (json["paymentreceipt"]) {
           html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["paymentreceipt"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["paymentreceipt"].split('_').slice(1).join('_') + "</a><br>";
}
html += "</td>";
                      $("#PaymentDetail tbody").append(html);
                    $("#PaymentDetail").show();
                    
         
               });    
                       
  var index = 1;
    $('.paymentslno').each(function() {
        $(this).text(index);
        index++;
            });
     
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}
  
function resetPage1(){
//alert("iinn reset page");
	parent.closeModal();	
	}
	
	function showbeneficiary(benid){
		//alert("benid>>>>"+benid);
	}
	
	
	
function Edit(memberid, relationid, button) {
    // Show the dependent info section
    $('#divDependentInfo').show();
$('#divDependentAddInfo').hide();
    // Store the current row being edited (using the button that triggered the event)
    var currentRow = button.closest("tr");

    // Get the table cells from the current row
    var cells = currentRow.querySelectorAll("td");

    // Retrieve values from the row
    var memberId = cells[1].innerText;  // Assuming memberid is in the second column
    var memberName = cells[2].innerText; // Assuming member name is in the third column
    var dob = cells[3].innerText;       // Assuming Dob is in the fourth column
    var relation = cells[4].innerText;  // Assuming Relation is in the fifth column
    var gender = cells[5].innerText;    // Assuming Gender is in the sixth column
    var validUpto = cells[6].innerText; // Assuming validupto is in the seventh column
    var flag = cells[7].innerText;  
  /*  var imgSrc = cells[8].querySelector("img").src; // Assuming the image is in the ninth column
    alert("Image Source:", imgSrc); // Log the image source for debugging

    // Set the image in your edit form
    document.getElementById("editPhoto").src = imgSrc || ''; 
        // Assuming flag is in the eighth column*/

    // Update the form fields with the row values
    $("#NewdepBenid").val(memberid);
    $('#Newdepname').val(memberName);
    $('#NewdepDOB').val(dob);
    $('#Newdeptrelation').val(relation);   // Populate Relation dropdown
    $('#Newdepgender').val(gender);       // Populate Gender dropdown
    $('#NewdepvalidUpto').val(validUpto); // Populate Valid Upto field
    $('#Newdepflag').val(flag);           // Populate Flag field


      $("#NewdepDOB").datepicker({
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


$("#NewdepvalidUpto").datepicker({
    minDate: new Date(),  // Today's date as the minimum
    maxDate: new Date(2099, 11, 31),  // Adjust to the desired end date
    dateFormat: "dd-M-yy",
    changeMonth: true,
    changeYear: true,
    yearRange: "2024:2099",  // Set the range explicitly
    showButtonPanel: true,
    showOtherMonths: true,
    selectOtherMonths: true,
    onSelect: function (date, datepicker) {
        console.log(date);  // Debug selected date
    }
});
/*$("#NewdepvalidUpto").datepicker({
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
});*/
    // Assuming `jsonObject` has necessary information or you can use the row's data for further population
    var jsonObject = {
        memberid: memberId,
        relationid: relationid,
        memberName: memberName,
        dob: dob,
        relation: relation,
        gender: gender,
        validupto: validUpto,
        flag: flag
    };

    // Now, you can use this jsonObject in the form to update the dependent details
    // Populate Relation dropdown
    let relationConfig = {
        serviceName: "/getData/getDependentRelation",
        comboId: "Newdeptrelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": jsonObject.relationid,
            "optionText": "Select Relation"
        }
    };
    callService(relationConfig);

    // Populate Gender dropdown
    let genderConfig = {
        serviceName: "/getData/getGenderList",
        comboId: "Newdepgender",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": jsonObject.gender,
            "optionText": "Select Gender"
        }
    };
    callService(genderConfig);

    // Set the image source for the dependent photo
    document.getElementById("editPhoto").src = jsonObject.dependentPhoto || ''; // Ensure the field exists or is null

}


function UpdateDetails()
{
	/* if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  */
 
    var configJson = {
        serviceName: "/DMLSAVE/UpdateDependentBenDetails",
        callBackFunctionName: "callbackUpdateDependentBenDetails",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackUpdateDependentBenDetails(configJson, dataJson){
	
//	alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		alert("m here");
		var dialogConfigJson={callOnOK:"getBeneficiarydetails","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPageupdate(){
window.location.reload();
 //submitFormMaster("BeneficiaryModification","add");
	}
	
	
	function AddDependent()
	{
		  let relationConfig = {
        serviceName: "/getData/getDependentRelation",
        comboId: "Newdeptrelationadd",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": "",
            "optionText": "Select Relation"
        }
    };
    callService(relationConfig);
/*    
    $("#NewdepDOBadd").datepicker({
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
*/
$("#NewdepDOBadd").datepicker({
      dateFormat: "dd-mm-yy",  // Date format: day-month-year
      changeMonth: true,        // Allows month change
      changeYear: true,         // Allows year change
      showButtonPanel: true,    // Adds a button panel at the bottom (for clear, today buttons)
      showOtherMonths: true,    // Shows days from other months in the calendar
      selectOtherMonths: true,  // Allows selecting days from other months
      yearRange: "-200:+0",     // Allows all years from -9999 to +9999 (practically no restriction)
      maxDate: new Date(),      // No future dates allowed
      onSelect: function (dateText, datepicker) {
        // Convert the selected date to a Date object
       var dob = $(this).datepicker("getDate");
    // Format the date to dd-mm-yyyy manually
    var formattedDate = $.datepicker.formatDate('dd-mm-yy', dob);
   // alert("Selected Date: " + formattedDate);  // Alert in dd-mm-yyyy format
      var age = calculateAge(formattedDate);
      var deprelation=$("#Newdeptrelationadd").val();
  //    alert("Age: " + age);
  
	  if(age>25 && deprelation==5 )
	  {
		  alert("Son age not greater than 25");
		 $('#depgender').prop('disabled', true); // Disable all other inputs
          return;  // Stop fur
	  }else if(age>25 && deprelation==28 )
    {
	alert("Adopted Son age not greater than 25");
		 $('#Newdepgenderadd').prop('disabled', true);
		  return;  
	}else  if(age>18 && deprelation==22)
	{
		alert(" Minor Brother age not greater than 18");
		 $('#Newdepgenderadd').prop('disabled', true);
		  return; 
	}else  if(age>18 && deprelation==32)
	{
	alert("Minor Daughter of Separated/Widowed/Divorced Daughter age not greater than 18");
		 $('#Newdepgenderadd').prop('disabled', true);
		  return; 	
	}else  if(age>18 && deprelation==33)
	{
		alert("Minor Son of Separated/Widowed/Divorced Daughter age not greater than 18");
		 $('#Newdepgenderadd').prop('disabled', true);
	}
		
	else{
		 $('#Newdepgenderadd').prop('disabled', false);
	}
  }
});
$("#NewdepvalidUptoadd").datepicker({
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
  let genderConfig = {
        serviceName: "/getData/getGenderList",
        comboId: "Newdepgenderadd",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": "",
            "optionText": "Select Gender"
        }
    };
    callService(genderConfig);
		  $('#divDependentAddInfo').show();
		      $('#divDependentInfo').hide();

	}
	function calculateAge(dobString) {
    // Parse the date in 'dd-MMM-yyyy' format
    const dobParts = dobString.split('-');
    const day = parseInt(dobParts[0], 10);
    const month = dobParts[1];
    const year = parseInt(dobParts[2], 10);
    
    // Convert the month name (e.g., 'Nov') into a month number (e.g., 10 for November)
    const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    const monthIndex = monthNames.indexOf(month); // Get month index from the monthNames array
    
    // Create a Date object using the parsed day, month, and year
    const birthDate = new Date(year, monthIndex, day);
    
    // Get today's date
    const today = new Date();
    
    // Calculate the age
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDifference = today.getMonth() - birthDate.getMonth();
    
    // If birthday hasn't occurred this year yet, subtract 1 from age
    if (monthDifference < 0 || (monthDifference === 0 && today.getDate() < birthDate.getDate())) {
        age--;
    }

    return age; // Return the calculated age
}



function AddDepDetails()
	 {
 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  
  
    var configJson = {
        serviceName: "/DMLSAVE/adddepdetails",
        callBackFunctionName: "callbackUpdateData",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackUpdateData(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"getBeneficiarydetails","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage1(){
 submitFormMaster("BeneficiaryModification","add");
	}
	
	
	function addpayment()
	{
			$("#paymententerdetails").show();
			
    
      $("#paymentto").datepicker({
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
    
    
    
     
    
      $("#paymentfrom").datepicker({
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
    
    
      $("#paymentdate").datepicker({
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
	}
	
	
	function SavePayment()
	{
		 
/* if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }*/
  
  
    var configJson = {
        serviceName: "/DMLSAVE/AddPaymentBen",
        callBackFunctionName: "callbackUpdateDataAddPaymentBen",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackUpdateDataAddPaymentBen(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"getBeneficiarydetails","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage2(){
 submitFormMaster("BeneficiaryModification","add");
	}
	
	
	
	
function ValidatePPO() {
    // Get the value from the input field
    var ppoNumber = document.getElementById("Patppopensioner").value;

    // Regular expression to allow alphabets, numbers, hyphens (-), and slashes (/)
    var regExp = /^[a-zA-Z0-9/-]+$/;

    // Check if the PPO number matches the regular expression
    if (regExp.test(ppoNumber)) {
        // If valid, you can optionally add a success message or remove any error message
        console.log("PPO Number is valid.");
    } else {
        // If invalid, show an error message
        alert("Invalid PPO Number! Only alphabets, numbers, hyphens (-), and slashes (/) are allowed.");
    }
}

  
	