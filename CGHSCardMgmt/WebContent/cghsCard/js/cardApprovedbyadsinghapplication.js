
$(document).ready(function () {
    initPage();
});

function initPage() {
    hidePreloader();
    initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
   
    //resetPages();
   /* $("#detailsTableContainer").show();*/

   /* const Benidvalue = $('#primaryKeys').val().split('@')[0];
  //  alert("BenId>>>>>>>>>>>"+Benidvalue);
    $("#Benid").val(Benidvalue);
   //alert("BenId>>>>>>>>>>>"+Benid);
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
//	alert("Benidvalue"+Benidvalue);


	var configJson={
    				serviceName:"/getData/getBeneficiaryDetailsApprovedbyAd",
    				primaryKeys:[Benidvalue],			
    				callBackFunctionName:"PopulateBeneficiaryDetails",
    			}
    		callService(configJson);

 var configJson={
    				serviceName:"/getData/getfamilymembersapprovedbyadsingle",
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
    	
    		
}
    function Approve()
    {
		
	//alert("4444444444");
	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  //console.log("inputData>>>> " +processSerializeArray("ENTRYFORM") );
  
    var configJson = {
        serviceName: "/DMLSAVE/ApprovecardByadafterModify",
        callBackFunctionName: "callbackSaveData2",
        inputData: processSerializeArray("ENTRYFORM")
    };
     
	
    callService(configJson);
}

	
function callbackSaveData2(configJson, dataJson){
	
	//alert("callbacksavedata2");
	//alert(JSON.stringify(configJson));
	/*console.log("configJson  ",configJson );
	console.log("dataJson  ", dataJson );*/
	
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{																		// SMS 
		var dialogConfigJson={callOnOK:"resetPage2","parameterJson":{}}
		showMsg(dataJson["message"],dialogConfigJson);
		
		var selectedValue = document.getElementById("deptaction").value;
		const trackingId = document.getElementById("tracking").value;
		var benId = configJson.inputData.Benid.trim();
		var patMobile = configJson.inputData.patMobileNo.trim();
		var category =  configJson.inputData.patCategory;
		
	if (selectedValue ==1 ){													// SMS AD Approve
		const data = new Array(trackingId,benId);
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
	
	else if (selectedValue == 2 || selectedValue == 3 ){		
													// Rejection / Raise Query SMS
		const data = new Array(trackingId,"AD");
  		const mobileNumbers = new Array(patMobile); 
  		jsonObject ={
			"templateId":"",
			  "data":[],
      	    "mobileNumbers":[],
		}
			jsonObject.templateId="1107174662043249932";					// Rejection SMS
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

function backToListPage(){
	
	$('#masterKey').val("BulkCardApprove");
	submitFormWithResetTextField("CallMasterPage");
}


function resetPage2()
{
	 submitFormMaster("CardApprovalByAD","add");
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
                       /*if (json["Relation"] === "Self") {
                        html += "<td></td>"; // If Relation is "Self" or flag is DeActive, leave the <td> empty
                    } else {
                        html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["memberid"] + "\", \"" + json["relationid"] + "\", this)'>Edit</a></td>";
                    }
                  */
				  html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["memberid"] + "\", \"" + json["relationid"] + "\", this)'>Edit</a></td>";                   
html += "<td><input type='checkbox' class='member-checkbox' name='depcheckbox' value='" + json["memberid"] + "'></td>";
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
    	//    alert("configJson>>> " + JSON.stringify(configJson));
    //	  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    	  //alert("populateBen ")
				hidePreloader();
				
    	 
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					
					  $('#selectedaction').show();
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
                               //  alert("hospcode>>>>>>>>>>"+json["gstr_hospital_name"]);
                                    $("#patientwc").val(json["gstr_hospital_name"]);
                              
                        $('#statecode').val(json["gstr_statename"]);
                        
                        document.getElementById("tracking").value =json["trackingid"];
                   
					 // $('#tiddd2').val(json["trackingId"]);
                     /*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
                       $('#patEmail').val(json["EmailId"]);
                        $('#patresaddress').val(json["resdaddress"]);
                    
                    
                         $('#PatCardtype').val(json["gstr_cardtype_name"]);
                         
                         
               
                         
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
	
	
	//alert(json["satellitecitycode"]);
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
	   	
    
			 /*    var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["gnum_hospital_code"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["adcitycode"]],
    		}
    	callService(configJson);*/
	   
                 var cardtype=json["gstr_cardtype_name"];
                // alert(cardtype);
                  var year=json["deputationyear"];
                 var cardtypevaluecategory=json["cardtype"];
               //alert(cardtypevaluecategory);
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
									
							//		alert("validupto>>>>>>>"+json["validupto"]);	
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
	
    
    /*  var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);*/
    		var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["gnum_pay_scales"]],
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
	//alert("validity");
	/* var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"patCardApplyValidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);*/
	
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
    	// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
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
    	    /*
    	    var configJson={
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
	
	
	
/*      var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);*/
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
     alert("gvdhghdghdghdg"+json["orgid"]+'$'+json["ddocode"]);
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

alert(orgtypeid); // Outputs: 16
alert(ddocode); // Outputs: 12
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
	/*
	
	  var configJson={
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
	
	
	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["ddocode"],"optionText":"Select District"},
    			  primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);
	*/
	
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
    });  
				
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
    	
    	
	function validateSalary(salary) {
    // Check if salary is less than 36,500
    if (salary < 36500) {
        return 1;  // Return 1 if salary is less than 36,500
    } 
    // Check if salary is between 36,501 and 50,500
    else if (salary > 36500 && salary < 50500) {
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
			     
			     
			  /*   var configJson={
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
		
		
function saveData1()
{
	//alert("4444444444");
/*	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }*/
  
  
    var configJson = {
        serviceName: "/DMLSAVE/UpdateBenDetails",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackSaveData1(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"getBeneficiarydetails","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
	
	function resetbenedit()
	{
		 //submitFormMaster("BeneficiaryData","add");
		 getBeneficiarydetails

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
	  
	 //alert("11111111111");
		if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        // $('#applyplastccard').show();
      showAlertMsg("No Data Found", "danger", "alertMsg");

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
		alert("benid>>>>"+benid);
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
		var dialogConfigJson={callOnOK:"resetPageupdate","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPageupdate(){

 submitFormMaster("BeneficiaryData","add");
	}
	