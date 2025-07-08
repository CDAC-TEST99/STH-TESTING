$(document).ready(function () {
	
	initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#Benidvalue').val(arrpk[1]);
	
	   //  alert("key>>>>>>>>>>>"+arrpk[1]);
		//gettrackingid();
		getfamilydetails();
	}
	else{
		hidePreloader();
		$('#divTrackingIdEntry').show();
		$('#PatTrackingidLbl').hide();
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
    	
 function getBeneficiarydetails()
   	{
	//		var Benid=$('#Benid').val();
			var Benid=document.getElementById('Benid').value;

        //   alert("11111"+Benid);
           if(Benid=='')
            {
             	alert("Plesae enter BenId");
	           return;
	
              }
                    
          // alert("11111"); 
	
	 var configJson={
    				serviceName:"/getData/getBeneficiaryDetails",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"PopulateBeneficiaryDetails",
    			 				
    			}
    		callService(configJson);




 var configJson={
    				serviceName:"/getData/getBeneficiaryDetailsDependent",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populateBenIdDependent",
    			 				
    			}
    		callService(configJson);

					
			
		}
		
		
  
			
			function PopulateBeneficiaryDetails(configJson, dataJson) {
    	 //   alert("configJson>>> " + JSON.stringify(configJson));
    	  //alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
				hidePreloader();
				
    	 
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
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
	   	
    
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["gnum_hospital_code"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["adcitycode"]],
    		}
    	callService(configJson);
	   
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
	
    
     /* var configJson={
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
	 var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"patCardApplyValidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
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
	
	
	/*
      var configJson={
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
	callService(configJson);
                      */
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
			     
			     
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[parentcitycodevalue],
    		}
    	callService(configJson);
	
		
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
	alert("4444444444");
	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  
  
    var configJson = {
        serviceName: "/DMLSAVE/UpdateBenDetails",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackSaveData1(configJson, dataJson){
	
	alert(JSON.stringify(configJson));
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
	parent.closeModal();	
	}