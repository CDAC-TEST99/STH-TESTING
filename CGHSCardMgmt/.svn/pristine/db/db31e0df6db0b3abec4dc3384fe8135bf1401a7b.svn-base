$(document).ready(function () {
	
	initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#PatTrackingid').val(arrpk[1]);
		$('#PatTrackingidLbl').text("Tracking Id :" + arrpk[1]);
		gettrackingid();
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
	
	
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });
	
	
	   
	    $('#BTNMODIFY').click(saveData);
	    $('#deptaction').change(function(){
			
			
			var cardtypevalue=$('#cardtypevaluehidden').val();
			alert("iiinnn ifff"+cardtypevalue);
	  var deptactionvalue=$('#deptaction').val();
	
	    var payscalelevel=$("#patpayscaleserving option:selected" ).text();
	    var patientname=$("#patName").val();
	    var basicpay=$("#patpayscalevalueserving option:selected").text();
	    
	  
	    
	    if(cardtypevalue=='S'){
		//	alert("iiinnn ifff");
	    if(deptactionvalue==1){
			  $("#patpaylevel").text(payscalelevel);
			  $("#patnameundertaking").text(patientname);
			  $("#patbasicpay").text(basicpay);
			   $('#statusflag').val("A")
			     $('#deptactionhidden').val("1")
			    $("#subscription").show();
			   	$("#remarksbox").hide();
	         $("#departmentundertaking").show();
	    
		}
		else if(deptactionvalue==3)
		{
			  $('#statusflag').val("R");
			    $('#deptactionhidden').val("3")
			 $("#departmentundertaking").hide();
			  $("#subscription").hide();
			   $("#remarksbox").show();
		}else{
			$("#remarksbox").show();
			  $('#deptactionhidden').val("2")
			  $('#statusflag').val("RA");
			 $("#departmentundertaking").hide();
			  $("#subscription").hide();
		}
	   
}else{
	 if(deptactionvalue==1){
			  $("#patpaylevel").text(payscalelevel);
			  $("#patnameundertaking").text(patientname);
			  $("#patbasicpay").text(basicpay);
			   $('#statusflag').val("A")
			     $('#deptactionhidden').val("1")
			    $("#subscription").hide();
			   
	    $("#departmentundertaking").show();
	    
		}
		else if(deptactionvalue==3)
		{
			  $('#statusflag').val("R");
			    $('#deptactionhidden').val("3")
			 $("#departmentundertaking").hide();
			  $("#subscription").hide();
		}else{
			$("#remarksbox").show();
			  $('#deptactionhidden').val("2")
			 $("#departmentundertaking").hide();
			  $("#subscription").hide();
		}
}
	});
	
	
	document.getElementById('select-all').addEventListener('change', function() {
	//	alert("hghgg");
    var checkboxes = document.querySelectorAll('input[name="undertakingChk"]');
    checkboxes.forEach(function(checkbox) {
        checkbox.checked = document.getElementById('select-all').checked;
    });
});
	
	}
	
 

	
    	
    	function gettrackingid()
   	{
			var trackingid=document.getElementById('PatTrackingid').value;

           //alert("11111"+trackingid);
           if(trackingid=='')
            {
             	alert("Plesae enter Mobile no");
	           return;
	
              }
                    
          // alert("11111"); 
	
	 var configJson={
    				serviceName:"/getData/getDetailsontrackingnumber",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"PopulateTrackingNumber",
    			 				
    			}
    		callService(configJson);



 var configJson={
    				serviceName:"/getData/getDetailDependent",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"populateTrackingDependent",
    			 				
    			}
    		callService(configJson);

			
	//alert("nomineee");		
 var configJson={
    				serviceName:"/getData/getDetailNoominee",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"populateTrackingNominee",
    			 				
    			}
    		callService(configJson);

					
			
		}
		
		
   function populateTrackingNominee(configJson, dataJson)
				{
				if (dataJson["message"].indexOf("ERROR") < 0) {
        $.each(dataJson["data"], function(_, json) {
            var html = "<tr>";
             html += "<td>" + json["FirstName"] + "</td>";
        html += "<td>" + json["DOB"] + "</td>";
        html += "<td>" + json["gstr_gender_name"] + "</td>";
         /*html += "<td>" + json["gstr_relation_name"] + "</td>";*/
          html += "<td>";
         html += "<select class='relation-dropdownnom'>"; // Start of dropdown
        html += "<option value='Select Relation'>Select Relation</option>";
       html += "<option value='" + json["nomrelationid"] + "' selected>" + json["gstr_relation_name"] + "</option>"; // Correct syntax
      html += "</select>"; // End of dropdown
         html += "</td>";
        html += "<td><button onclick='editRownom(this)'>Edit</button></td>";
        html += "</tr>";
                              
            $("#Nomtable tbody").append(html);
                 $('#Nomtable').show();         
         
         $( "button" )
         .click(function( event ) {
           event.preventDefault();
           
           
         });
        $( "input[type=button], button" )
          .click(function( event ) {
            event.preventDefault();
               });

        });
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
        return;
    }
}

		
			
			function PopulateTrackingNumber(configJson, dataJson) {
    	 //   alert("configJson>>> " + JSON.stringify(configJson));
    	  //alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
				hidePreloader();
				
    	 
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					//alert(json["resdocupload"]);
					 var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	         
	         if(json["resdocupload"]){
	         var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["resdocupload"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["resdocupload"] + "</a>";
          $('#imagetest').html(url1);
          }else{
			 $('#imagetest').html("NA"); 
		  }
      /*    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +residenceproof + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + residenceproof + "</a>";
             $('#imagetest').html(url1);*/
					  if(json["PPOdocument"]){
					        var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["PPOdocument"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
					           $('#imagetest1').html(url2);
					 }else{
						$('#imagetest1').html("NA"); 
					 }
					                  
                  var url = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + encodeURIComponent(json["uplodfilename"]) + "&folderName=CARDDOCUMENT'>" + json["uplodfilename"] + "</a>";
					
					$('#imagetest').val(url);
                                 
                      $('#patName').val(json["FirstName"]);
                      $('#patNameHindi').val(json["Hindiname"]);
                      $('#patDOB').val(json["DOB"]);
                     // $('#patGender').val(json["gstr_gender_name"]);
                      $('#patMobileNo').val(json["MobileNo"]);
                      $('#statecode').val(json["gstr_statename"]);
                       $('#PatientCghsCity').val(json["gstr_city_name"]);
                       $('#patPANNo').val(json["PANNO"]);
                         $('#patpincodeserving').val(json["Pincode"]);
                       
                     // $('#patrelation').val(json["relation"]);
                      
                      
                      
                     /*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
                       $('#patEmail').val(json["EmailId"]);
                        $('#patresaddress').val(json["ResAddress"]);
                     /*    $('#PatCardtype').val(json["cardtype"]);      // cardtype Applied for serving or pension
                         $('#PatCardsubtype').val(json["gstr_cardtype_name"]);   //subcardtype
                         */
     var configJson={
	serviceName:"/getData/getGenderList",
	comboId:"patGender",
	modifyDataJson:json,			
	callBackFunctionName:"populateAllGenderField",
	defaultOption:{"optionValue":"","optionText":"Select Gender"}	
	}
	callService(configJson);
	
	
	   var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["hospitalcode"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["adcitycode"]],
    		}
    	callService(configJson);
	     var configJson={
	serviceName:"/getData/getRelationdata",
	comboId:"patrelation",
	modifyDataJson:json,			
	callBackFunctionName:"populateAllRelation",
	defaultOption:{"optionValue":"","optionText":"Select relation"}	
	}
	callService(configJson);
	

	
             var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["citycode"],"optionText":"Select City"}
			
			
	   	}
	          callService(configJson);
	   
	   
	   
	   	var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			
			defaultOption:{"optionValue":json["statecode"],"optionText":"Select State"}	
			
		}
	callService(configJson);
	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["districtid"],"optionText":"Select District"},
    			primaryKeys:[json["statecode"]],
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
    
   // alert(json["parent_city_name"]);
      $('#patadcity').val(json["parent_city_name"]);
	         

                 var cardtype=json["gstr_cardtype_name"];
              //   alert(cardtype);
                    var cardtypevalue=  json["cardtype"];
                 //    alert("cardtypevalue>>>>>>>>"+cardtypevalue);
                  var year=json["deputationyear"];
                 
                // alert("year"+cardtype);
              //  if (cardtype=='Pensioner' || cardtype=='Ex-MP' || cardtype=='Freedom Fighter' || cardtype=='Pensioner(Auto)')
              if(cardtypevalue=='P')
                {
				$('#cardtypevaluehidden').val("P");
				   var ppono=json["PPONo"];

				//	alert("iinnn pensioner"+ppono);
					$('#servingdept').hide();
					$('#pensionerdept').show();
				//	  $('#patdepartmentP').val(json["gstr_service_dept_name"]);
					
					$('#patcardtypepensioner').val(json["cardtype"]);
					//	$('#patsubcardtypepensioner').val(json["gstr_cardtype_name"]);
						//	$('#patcardtypecategorypen').val(json["cardcategory"]);
				//	alert(json["cardcategory"]);
					 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardtypecategorypen",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategory"],"optionText":"Select Card Category "},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
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
    			defaultOption:{"optionValue":json["patsubcardtypepensioner"],"optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardtypecategorypen').val()],
    		}
    	callService(configJson);
    	
  
    	
    	
    });

       			  $('#LastPayP').val(json["lastpay"]);
				  $('#PensionerPPO').val(json["PPONo"]);
					 $('#FmaP').val(json["treatmenttype"]);
			    $('#CardApplyvalidity').val(json["cardapplyvalidity"]);
			    $('#PatDOR').val(json["DateofRetirement"]);
			    $('#Existingbenid').val(json["existingbenid"]);
				
				   var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"entitlementP",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);
	      
	      	  
		    var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"payscaleP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		      }
	         callService(configJson);
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
	
	
		/* var configJson={
			serviceName:"/getData/getmainservicedept",
			comboId:"patdepartmentP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
		}
		callService(configJson);
	
	
	 
	 populateSubDepartment(json["Deptid"], json["subdeptid"]);
	 $('#patdepartmentP').change(function(){
		
    	if($('#patdepartmentP').val()=="")
    	{
    		$('#patsubdeptserving').html("<option value=''>Select subdepartment</option>");
    		return;    		
    	}
    	populateSubDepartment($('#patdepartmentP').val(), "");
    });
	
	 PopulateOrganization(json["subdeptid"],json["deporgid"]);
		 $('#patsubdepartmentP').change(function(){
    	
    	if($('#patsubdepartmentP').val()=="")
    	{
    		$('#patorganizationp').html("<option value=''>Select Organization</option>");
    		return;    		
    	}
              PopulateOrganization(subdeptid,"");
    });*/
	
	
	
	
	//alert("validity");
	 var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"CardApplyvalidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);
	
	//alert("FMA");
	 var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"FmaP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
		}
	callService(configJson);
				
				}else{
						//alert(json["payscalevalue"]);
					$('#servingdept').show();
					$('#pensionerdept').hide();
					$('#cardtypevaluehidden').val("S");
					//$('#PatCardtype').val(json["gstr_cardtype_name"]);
				  // $('#patdepartment').val(json["gstr_service_dept_name"]);
					$('#OfcAdress').val(json["officeaddress"]);
					$('#Presentpay').val(json["presentpay"]);
					
					if(json["deputationenddate"]){
					$('#Deputationenddate').val(json["deputationenddate"]);
					$('#depdatediv').show();
					
				}else{
					$('#depdatediv').hide();
				}
					$('#Designation').val(json["Designation"]);
				                $('#patcardtypeserving').val(json["cardtype"]);
				                if(json["cardtype"]=='S'){
									$('#patcardtypeserving').val("Serving");
								}
							//	alert("subcardtype>>>>>>"+json["gstr_cardtype_name"]);
                         $('#patsubcardtypeserving').val(json["gstr_cardtype_name"]);
                         //	alert("category>>>>>>"+json["gstr_card_type_category_name"]);
                       //  $('#patcardcategoryserving').val(json["cardcategory"]);
				               
					var transfercityflag=json["transferflag"];
				  if(transfercityflag=='Y')
				  {
					$('#Transferableservice').val('Yes');
				  }else{
					  $('#Transferableservice').val('No');
				  }
				  
				  
				  
	 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardcategoryserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategoryid"],"optionText":"Select CardCategory"},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
		}
	callService(configJson);
	
	//alert("subcategory>>>>>>>>>>"+json["cardsubcategoryid"]);
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
		
		
		var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypeserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["cardsubcategoryid"],"optionText":"Select SubCategory"},
    			primaryKeys:[json["cardcategoryid"]],
    		}
    	callService(configJson);
    	
		/*	    var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"entitlementS",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);*/
				  
			/*		  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"payscale",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		}
	callService(configJson);*/
					
						//alert("department");
	/*	 var configJson={
			serviceName:"/getData/getmainservicedept",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
			
		}
	 callService(configJson);
	 
	 
	 
		var configJson={
    			serviceName:"/getData/getSubServiceDepartment",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["subdeptid"],"optionText":"Select Sub Department"},
    			
    		}
    	callService(configJson);*/
    //	alert("323232");
    
	   var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdepartment').change(function(){
    	
    	if($('#patdepartment').val()=="")
    	{
    		$('#patsubdeptserving').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdepartment').val()],
    		}
    	callService(configJson);
    });
  //  alert("department>>>>>>>>>>>>>>>>>"+json["orgid"]);
    var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);
    	
  var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
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
 // alert("payscale>>>>>"+json["payscaleid"]);
			  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscaleserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["payscaleid"],"optionText":"Select Payscale"}	
			
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
			defaultOption:{"optionValue":json["basicpay"],"optionText":"Select BasicPay"},
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


    	/*
    	var configJson={
    			serviceName:"/getData/getOrganization",
    			comboId:"patdepartmentorg",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["deporgid"],"optionText":"Select Organization"},
    		
    		}
    	callService(configJson);
					
					
										//alert("department");
		 var configJson={
			serviceName:"/getData/getmainservicedept",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
			
		}
	 callService(configJson);*/
	 
	 
	/*  var configJson={
			serviceName:"/getData/getmainservicedept",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
		}
		callService(configJson);
	
	
	 
	 populateSubDepartmentserving(json["Deptid"], json["subdeptid"]);
	 $('#patdepartment').change(function(){
		
    	if($('#patdepartment').val()=="")
    	{
    		$('#patsubdepartment').html("<option value=''>Select subdepartment</option>");
    		return;    		
    	}
    	populateSubDepartmentserving($('#patdepartment').val(), "");
    });
	
	 PopulateOrganizationserving(json["subdeptid"],json["deporgid"]);
		 $('#patsubdepartment').change(function(){
    	
    	if($('#patsubdepartment').val()=="")
    	{
    		$('#patdepartmentorg').html("<option value=''>Select Organization</option>");
    		return;    		
    	}
              PopulateOrganizationserving($('#patsubdepartment').val(),"");
    });*/
}
				
				
		                    
                $('#officeaddress').val(json["officeAddress"]);
                $('#displayuserinfo').show();
 });      
           }
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
    	 
    
    	}
		
		
		
	
let rowIndex = 1;
function populateTrackingDependent(configJson, dataJson) {
   // alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    
    
    if (dataJson["message"].indexOf("ERROR") < 0) {
	//	alert("populateTrackingDependent>>> "+dataJson["data"].length)
        $.each(dataJson["data"], function(indx, json) {
			//alert(json["dependentuploaddoc"]);
	
		  var disablityflagdisplay="";
		     var disablityflag=json["disablityflag"] ;
		     if(disablityflag==1)
		     {
				 disablityflagdisplay="Yes";
			 }else{
				 disablityflagdisplay="No";
			 }
		 
		//alert("indx>>" + indx);
		 
	
         	var jsonDep={
			"uniqueId":indx,
			"depname": json["FirstName"],
	     "dependentRelation":json["DepRelation"], 
	     "dependentGender":json["depGen"],
	     "dependentGenderId":json["depgenderid"],
	      "dependentRelationId":json["deprelationid"],
	    // "dependentBloodGroupadd":depBloodGroupadd,
	     "deppendentDOBadd":json["DOB"],
	     "dependentPhoto":json["photo"],
	     "dependentuploaddoc":json["dependentdisableduploaddoc"],
	          "dependentuploaddoctypeid":json["dependentdisableduploaddoctypeid"],
	     "dependentdisablityflag":disablityflagdisplay,
		     "dependentdisdocuploadname":json["docdisabledocname"],
	     "dependentidproofdoctypeid":json["dependentiddoctypeid"],
	          "dependentidproofdoc":json["dependentiddoc"],
	           "dependentidproofdocname":json["dociddocname"],
	           
	                "dependentspouseproofdoctypeid":json["depspouse_doctypeid"],
	          "dependentspouseproofdoc":json["depspouse_doc"],
	           "dependentspouseproofdocname":json["spousedocname"],
	           
	           "dependentageprooftypeid":json["depagedoctypeid"],
	          "dependentageproofdoc":json["depagedoc"],
	           "dependentageprooftypeiddocname":json["depagedocname"],
	     
	      "dependentmarriageproofdoctypeid":json["marriagedoctypeid"],
	          "dependentmarriageproofdoc":json["marriagedoc"],
	           "dependentmarriageproofdocname":json["marriagedocname"],
	     
	     
	     
	      "dependentincomeproofdoctypeid":json["incomedoctypeid"],
	          "dependentincomeproofdoc":json["incomedoc"],
	           "dependentincomeproofdocname":json["incomedocname"],
	           
	     } 
         	createDependentRow(jsonDep);             
        });
        
           
      
 
    
          $('#Deptable').show();
        
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
        return;
    }
}
let currentRow; 
function editRow(button) {
	var uniqueid =$(button).attr("data-id");
	    var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	
	var str= $('#dependentJson_'+uniqueid).val()
	//alert("str>>>>" + str);
	var jsonObject = JSON.parse(str);  // Parse the string into a JSON object
    //alert("jsonObject>>>>>"+jsonObject.depname);



	//var uniqueidvalue = index;
    //alert(uniqueid);
    $('#selectedRowId').val(uniqueid);
    $('#BTNADDDEP').text("Modify Detail");
     $('#dependentTitle').text("Modify Dependent Details");
	 $('.editdep').hide();
	 $('.deletedep').hide();
    // Show the modify container
    $('#trdependent_'+uniqueid).addClass('selected');
    $('#isdependentmodify').val("1");
      $('#divDependentInfo').show();

    // Store the current row being edited
    var currentRow = button.closest("tr");

    // Get the table cells from the current row
    var cells = currentRow.querySelectorAll("td");
    
   $('#Newdepname').val(jsonObject.depname);
    $('#NewdepDOB').val(jsonObject.deppendentDOBadd); // Similarly for other fields
   // $('#Newdepgender').val(jsonObject.dependentGenderId); // Populate gender
 
 //alert(jsonObject.dependentRelationId);
      var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "Newdeptrelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": jsonObject.dependentRelationId,
            "optionText": "Select Relation"
        }
    };
    callService(configJson);
    
    
 var configJson={
	serviceName:"/getData/getGenderList",
	comboId:"Newdepgender",
	callBackFunctionName:"commonPopulateCombo",
	defaultOption:{"optionValue":jsonObject.dependentGenderId,"optionText":"Select Gender"}	
	}
	callService(configJson);
	//alert(jsonObject.dependentPhoto);
	   document.getElementById("editPhoto").src = jsonObject.dependentPhoto;
	   

	  var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depidproofdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":jsonObject.dependentidproofdoctypeid,"optionText":"Select document"},
    			primaryKeys:[10],
    		}
    	callService(configJson);


 
 var fileId='20';
 var validation='mandatory';
 var folderName='CARDDOCUMENT';
 
 var url="/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName="+jsonObject.dependentidproofdoc+"&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
 
 
 document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url+ "'>"	+ jsonObject.dependentidproofdoc
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		//document.getElementById('filename' + fileId).value = data;
		
		
		$('#filename'+fileId).val(jsonObject.dependentidproofdoc);
 
 
 //   $('#displayFile20').html(url2);





//alert("sposedocument>>>>>>>>>>"+jsonObject.dependentspouseproofdoc);

if(jsonObject.dependentspouseproofdoc){
	$('#fileuploadspousecertificate').show();
	$('#spousedoctype').show();
	
	
	//alert("innniiiff")
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depspousedoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":jsonObject.dependentspouseproofdoctypeid,"optionText":"Select document"},
    			primaryKeys:[50],
    		}
    	callService(configJson);
 var fileId='14';
 var validation='mandatory';
 var folderName='CARDDOCUMENT';
 
 var url1="/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName="+jsonObject.dependentspouseproofdoc+"&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
 
 //alert(url1);
 
 document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url1+ "'>"	+ jsonObject.dependentspouseproofdoc
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		
		$('#filename'+14).val(jsonObject.dependentspouseproofdoc);
		
	}
	
	 
	     
	if(jsonObject.dependentmarriageproofdoc){
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depmardoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":jsonObject.dependentmarriageproofdoctypeid,"optionText":"Select document"},
    			primaryKeys:[80],
    		}
    	callService(configJson);
    	
	 var fileId='25';
 var validation='mandatory';
 var folderName='CARDDOCUMENT';
 
 var url1="/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName="+jsonObject.dependentmarriageproofdoc+"&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
 
 //alert(url1);
 
 document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url1+ "'>"	+ jsonObject.dependentmarriageproofdoc
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		
		$('#filename'+25).val(jsonObject.dependentmarriageproofdoc);
	}
	
	
	
	if(jsonObject.dependentincomeproofdoc){
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depincomestatusdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":jsonObject.dependentincomeproofdoctypeid,"optionText":"Select document"},
    			primaryKeys:[90],
    		}
    	callService(configJson);
    	
    	
	var fileId='26';
 var validation='mandatory';
 var folderName='CARDDOCUMENT';
 
 var url1="/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName="+jsonObject.dependentincomeproofdoc+"&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
 
 //alert(url1);
 
 document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url1+ "'>"	+ jsonObject.dependentincomeproofdoc
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		
		$('#filename'+26).val(jsonObject.dependentincomeproofdoc);
}

if(jsonObject.dependentageproofdoc){
var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depagedoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[60],
    		}
    	callService(configJson);
    	
    	 	
	var fileId='24';
 var validation='mandatory';
 var folderName='CARDDOCUMENT';
 
 var url1="/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName="+jsonObject.dependentageproofdoc+"&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
 
 //alert(url1);
 
 document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url1+ "'>"	+ jsonObject.dependentageproofdoc
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		
		$('#filename'+24).val(jsonObject.dependentincomeproofdoc);

}
}

function editRownom(button) {
//alert("iinn row");

$('#NomtableModify').show();
  currentRow = button.closest("tr"); // Store the current row being edited
    var cells = currentRow.querySelectorAll("td");
  var relationvalue=cells[3].querySelector(".relation-dropdownnom").value;
  var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "NomRelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": relationvalue,
            "optionText": "Select Relation"
        }
    };
    callService(configJson);
	
  
          $('#NomName').val(cells[0].innerText);
          $('#NomDob').val(cells[1].innerText);
           $('#NomGen').val(cells[2].innerText);
         //  $('#NomRelation').val(cells[3].innerText);
        
           
           $('#Nomtablemodify').show();
          
    }


function saveChanges() {
	
	var rowIndex = $('#editRowIndex').val();
	//alert("rowIndex");
    if (!currentRow) return; // Ensure there's a row to edit

    // Get the values from the input fields
    var modfiedname = $('#DepName').val();
      var modfieddob = $('#DepDob').val();
    var modifiedgender=$('#DepGender').val();
    var modifiedrelation=$( "#DepRelation option:selected" ).text();
    //alert(modifiedrelation);
     var modifiedrelationid=$( "#DepRelation option:selected" ).val();
   
  var photo=document.getElementById("editPhoto").src;
  //alert(photo);
    // Update the original table cells
    currentRow.cells[1].innerText = modfiedname;
    currentRow.cells[2].innerText = modfieddob;
     currentRow.cells[3].innerText = modifiedgender;
  //   currentRow.cells[4].innerText = modifiedrelation;
      
   currentRow.querySelector('img').src=photo;
  
   
    // Clear the currentRow reference
     $('#dependentinfomodify').hide();
    currentRow = null;
}


function saveChangesnominee() {
	//alert("11111");
    if (!currentRow) return; // Ensure there's a row to edit

    // Get the values from the input fields
    var name = $('#NomName').val();
   // alert(name);
    var dob = $('#NomDob').val();
   // var gender = $('#DepGender').val();

    // Update the original table cells
    currentRow.cells[0].innerText = name;
    currentRow.cells[1].innerText = dob;
    //currentRow.cells[2].querySelector("select").value = gender; // Update the dropdown

    // Optionally hide the modify container after saving
    $('#NomtableModify').hide();
   var nomjson={"nomname": name,
     "nomdob":dob, 
     } 
     
     
    // Clear the currentRow reference
    currentRow = null;
}



function savedeptdata()
{
	var deptaction=  $('#deptactionhidden').val();
	if(deptaction==1){
		
		if (confirm("Are you sure Are you sure you want to Verify & Forward to CGHS"));
		{
			saveData();
		}
	
	}else if(deptaction==2){
		if (confirm("Are you sure  you want to Return to Applicant?"));
		{
			saveData();
		}
	}else{
		if (confirm("Are you sure you want to Reject?"));
		{
			saveData();
		}
	}
}
function saveData() {
	//alert("iinn methid");
	
	
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
    // alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/saveModifydatadept",
        callBackFunctionName: "callbackSaveData",
        inputData: processSerializeArray("ENTRYFORM")
    };


var dependentJsonArray = configJson.inputData.dependentJson;
    var parsedDependentJsonArray = null;

    // Check if dependentJson exists and is an array or a string (to be parsed)
    if (dependentJsonArray && Array.isArray(dependentJsonArray)) {
        // If it's already an array, map it to parse JSON strings (if necessary)
        parsedDependentJsonArray = dependentJsonArray.map(function(jsonString) {
            return JSON.parse(jsonString);
        });

        // Update configJson with the parsed dependentJson array
        configJson.inputData.dependentJson = parsedDependentJsonArray;

        // Optional: Alert to check the configuration before sending
      //  alert("configJson>>>" + JSON.stringify(configJson));
    } else if (typeof dependentJsonArray === 'string') {
        // If it's a single JSON string, parse it into an array
        try {
            parsedDependentJsonArray = JSON.parse(dependentJsonArray);

            // If parsing is successful, wrap it in an array
            if (parsedDependentJsonArray) {
                configJson.inputData.dependentJson = [parsedDependentJsonArray];
            }
        } catch (error) {
            console.error("Error parsing dependentJson:", error);
        }
    } else {
        // Handle the case where there is no dependentJson data
        alert("No valid dependent data found. Proceeding without dependentJson.");
    }

    // Call the service
    callService(configJson);
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


function resetPage()
{
	parent.closeModal();	
}
	 
	 
 
  function uploaddisabledocument()
  {
 var checkbox =document.getElementById('customCheckdisable');
//alert("value of checkbox"+checkbox);
 if (checkbox.checked) {
	 $('#fileupload').show();
	 $('#isdisablityvaluehidden').val("1");	 
	 }
	 else
	 {
		  $('#fileupload').hide();
		 	  $('#isdisablityvaluehidden').val("0");
	 }
	
	}
	
	
   	var myStream = null;
	 
// stop only camera
function stopVideoOnly(stream) {
	stream.getTracks().forEach((track) => {
		if (track.readyState == 'live' && track.kind === 'video') {
			track.stop();
		}
	});
}


var ctPreviewId = '';
var ctPreviewHiddenId = '';
var ctfileEvent = null;

  function showPopup(inputFileNameId , previewId , previewHiddenId) {
	//  alert(previewHiddenId);

	  ctPreviewId = previewId;
	  ctPreviewHiddenId = previewHiddenId;
	  ctInputFileNameId = inputFileNameId
	  
      document.getElementById('popup').style.display = 'block';
      document.getElementById('overlay').style.display = 'block';
  }

  function hidePopup() {
      document.getElementById('popup').style.display = 'none';
      document.getElementById('overlay').style.display = 'none';
  }

  function uploadPhoto() {

	  
	  document.getElementById(ctInputFileNameId).addEventListener('change', function(event) {
          const file = event.target.files[0];
	      const reader = new FileReader();
	      reader.onload = function(e) {
	    	  document.getElementById(ctPreviewId).src = e.target.result;
	    	  document.getElementById(ctPreviewHiddenId).value  = e.target.result;
	           
	          document.getElementById(ctPreviewId).style.display = 'block';
	          document.getElementById('video').style.display = 'none';
	          document.getElementById('capture').style.display = 'none';
	          document.getElementById('canvas').style.display = 'none';
				 hidePopup();
	      };
	      reader.readAsDataURL(file);
	  
	      hidePopup();
	   });
	   
	      document.getElementById(ctInputFileNameId).click();
	      

	      
	    }

  function capturePhoto() {
        
		   // Access the camera
  navigator.mediaDevices.getUserMedia({ video: true })
      .then(function(stream) {
		 
          video.srcObject = stream;
          video.play();
          video.style.display = 'block';
          captureButton.style.display = 'block';
      })
      .catch(function(err) {
          console.log("An error occurred: " + err);
      });
 
		
     
  }


  function captureActualPhoto(event){
		
      const context = canvas.getContext('2d');
      context.drawImage(video, 0, 0, 320, 240);
      const dataUrl = canvas.toDataURL('image/png');
      document.getElementById(ctPreviewId).src = dataUrl;
      document.getElementById(ctPreviewHiddenId).value  = dataUrl;
      
      document.getElementById(ctPreviewId).style.display = 'block';
      document.getElementById('video').style.display = 'none';
      document.getElementById('capture').style.display = 'none';
      document.getElementById('canvas').style.display = 'none';
	  stopVideoOnly(document.getElementById('video').srcObject );
		
		 hidePopup();
	  
	 }
	 function deleteRow(button) {
	    var row = button.closest('tr'); // Find the closest row
 	   row.remove(); // Remove the row from the table
 	   createRoqSequenceNo("tddepSeq");
	}

	 
function adddepinfo() {
//	alert("111");


  const depnameadd = document.getElementById('Newdepname').value;
    
   const depentrelationadd= $( "#Newdeptrelation option:selected" ).text();
   const depentrelationaddID= $( "#Newdeptrelation option:selected" ).val();
  const depDOBadd = document.getElementById('NewdepDOB').value;
  
  const depgenderadd=$( "#Newdepgender option:selected" ).text();
  const depgenderaddID=$( "#Newdepgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#NewdepBloodGroup option:selected" ).text();

/*var depidproofuploaddoctypeid=$("#depidproofdoctypeid option:selected").val();
var dependentidproofdocname=$("#depidproofdoctypeid option:selected").text();*/
var photo=document.getElementById("editPhoto").src;
//alert("photo>>>>>>>>>>"+photo);
      
  //currentRow.querySelector('img').src=photo;
    const imgSrc = photo;
   // alert("imgSrc"+imgSrc);
     const fileuploadvalue=$('#filename11').val();
    //alert("fileuploadvaluefileuploadvaluefileuploadvalue"+fileuploadvalue);
     const disablityflag=$('#isdisablityvaluehidden').val();
     //alert(disablityflag);
     
     
     
     var depidproofuploaddoctypeid=$("#depidproofdoctypeid option:selected").val()
   var  dependentidproofdoc=$('#filename20').val();
    var dependentidproofdocname=$("#depidproofdoctypeid option:selected").text();
    
  //  alert(depidproofuploaddoctypeid);
    
 //alert(dependentidproofdoc);
// alert(dependentidproofdocname);
   
   var dependentspouseproofdoctypeid=$("#depspousedoctypeid option:selected").val();
var dependentspouseproofdocname=$("#depspousedoctypeid option:selected").text();
   var dependentspouseproofdoc=$('#filename14').val();
   
   
     //alert(dependentspouseproofdoctypeid);
   //  alert(dependentspouseproofdoc);
 //alert(dependentspouseproofdocname);
   
   var dependentmarriageproofdoctypeid=$("#depmardoctypeid option:selected").val();
   var dependentmarriageproofdocname=$("#depmardoctypeid option:selected").text();
   var dependentmarriageproofdoc=$('#filename25').val();
   
   
      var dependentincomeproofdoctypeid=$("#depincomestatusdoctypeid option:selected").val();
   var dependentincomeproofdocname=$("#depincomestatusdoctypeid option:selected").text();
   var dependentincomeproofdoc=$('#filename26').val();
   
   
   var dependentageproofdoctypeid=$("#depagedoctypeid option:selected").val();
   var dependentageproofdocname=$("#depagedoctypeid option:selected").text();
   var dependentageproofdoc=$('#filename24').val();
   
   
    var dependentdisableproofdoctypeid=$("#depdisdoctypeid option:selected").val();
   var dependentdiableproofdocname=$("#depdisdoctypeid option:selected").text();
   var dependentdisableproofdoc=$('#filename11').val();
   
     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     "dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc,
     "dependentuploaddoc":fileuploadvalue,
     "dependentdisablityflag":disablityflag,
      "dependentdisdoctypeid":dependentdisableproofdoctypeid,
	  "dependentdisdocuploadname":dependentdiableproofdocname,
	"dependentdisproofdoc":dependentdisableproofdoc,
		     
		     
	     "dependentidproofdoctypeid":depidproofuploaddoctypeid,
	          "dependentidproofdoc":dependentidproofdoc,
	           "dependentidproofdocname":dependentidproofdocname,
	           
	                "dependentspouseproofdoctypeid":dependentspouseproofdoctypeid,
	          "dependentspouseproofdoc":dependentspouseproofdoc,
	           "dependentspouseproofdocname":dependentspouseproofdocname,
	           
	           "dependentageprooftypeid":dependentageproofdoctypeid,
	          "dependentageproofdoc":dependentageproofdoc,
	           "dependentageprooftypeiddocname":dependentageproofdocname,
	     
	      "dependentmarriageproofdoctypeid":dependentmarriageproofdoctypeid,
	          "dependentmarriageproofdoc":dependentmarriageproofdocname,
	           "dependentmarriageproofdocname":dependentmarriageproofdoc,
	     
	     
	     
	      "dependentincomeproofdoctypeid":dependentincomeproofdoctypeid,
	          "dependentincomeproofdoc":dependentincomeproofdoc,
	           "dependentincomeproofdocname":dependentincomeproofdocname,
     
     } 
     
         
      createDependentRow(json);
    
      
    }  
    
    function createDependentRow(json) {
		
    // Generate a unique ID for the row (assuming getUniqueId() is a function defined elsewhere)
   // alert("selectedRowId===" + $('#selectedRowId').val());
     var uniqueid = "";//$('#selectedRowId').val()!=""?$('#selectedRowId').val(): getUniqueId();
    
     if(json["uniqueId"]!=undefined)
     	uniqueid=json["uniqueId"];
     else{
		 uniqueid = $('#selectedRowId').val()!=""?$('#selectedRowId').val(): getUniqueId();
	 }
   
   

    // Determine if the dependent has a disability
    var disablityflag = json["dependentdisablityflag"];
    var disablityflagdisplay = (disablityflag == 1) ? "Yes" : "No";

   var deprelationvalue=json["dependentRelationId"];

      
			   var html = "";
html += "<td class='tddepSeq'></td>"; // Add row index here
html += "<td>" + json["depname"] + "</td>"; // Dependent name
html += "<td>" + json["deppendentDOBadd"] + "</td>"; // Dependent date of birth

// Gender dropdown
html += "<td>";
html += "<select class='gender-dropdown'>"; // Start of gender dropdown
html += "<option value='Select Gender'>Select Gender</option>";
html += "<option value='" + json["dependentGenderId"] + "' selected>" + json["dependentGender"] + "</option>"; // Set the selected option to the dependent's gender
html += "</select>"; // End of gender dropdown
html += "</td>";

// Relation dropdown
html += "<td>";
html += "<select class='relation-dropdown'>"; // Start of relation dropdown
html += "<option value='Select Relation'>Select Relation</option>";
html += "<option value='" + json["dependentRelationId"] + "' selected>" + json["dependentRelation"] + "</option>"; // Set the selected option to the dependent's relation
html += "</select>"; // End of relation dropdown
html += "</td>";

// Dependent photo
html += "<td><img src='" + json["dependentPhoto"] + "' style='width:100px;height:100px' /></td>";

// File upload document links, only display if the document name is not null
html += "<td>";
if (json["dependentidproofdoc"]) {
    html += "<span>" + json["dependentidproofdocname"] + "</span><input type='hidden' value='" + json["dependentidproofdoctypeid"] + "'>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentidproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentidproofdoc"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentspouseproofdoc"]) {
    html += "<span>" + json["dependentspouseproofdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentspouseproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentspouseproofdoc"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentageproofdoc"]) {
    html += "<span>" + json["dependentageprooftypeiddocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentageproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentageproofdoc"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentmarriageproofdoc"]) {
    html += "<span>" + json["dependentmarriageproofdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentmarriageproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentmarriageproofdoc"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentuploaddoc"]) {
    html += "<span>" + json["dependentdisdocuploadname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentuploaddoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentuploaddoc"].split('_').slice(1).join('_') + "</a>";
}

if (json["dependentincomeproofdoc"]) {
    html += "<span>" + json["dependentincomeproofdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentincomeproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentincomeproofdoc"].split('_').slice(1).join('_') + "</a>";
}

if (json["dependentdisproofdoc"]) {
    html += "<span>" + json["dependentdisproofdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentdisproofdoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentdisproofdoc"].split('_').slice(1).join('_') + "</a>";
}


html += "</td>";

if (deprelationvalue == '1') {
//	alert("iinnniiifff")
    html += "<td style='padding-top: 45px;'></td>";
} else {
    html += "<td style='padding-top: 45px;'><a class='editdep btn-his-outline' data-id='" + uniqueid + "' onclick='editRow(this)'>Edit</a></td>";
}

// Hidden input field containing JSON data
html += "<input type='hidden' name='dependentJson' id='dependentJson_" + uniqueid + "' value='" + JSON.stringify(json) + "' />";

html += "</tr>";

			   
			   
    
    
  // alert("trdependent length>>>"+  $("#trdependent_"+uniqueid).length)
    if($("#trdependent_"+uniqueid).length>0){
		$("#trdependent_"+uniqueid).html(html);
		 $('#divDependentInfo').hide();
		 $('#isEditabledependentflag').val("1");
	}
	else{// creating new row
		html = "<tr id='trdependent_" + uniqueid + "'>" + html+ "</tr>";
		 $('#Deptable tbody').append(html);
		 $('#isEditabledependentflag').val("1");
	}
	createRoqSequenceNo("tddepSeq");
	 
	 /*$('#selectedRowId').val("");
	 $('#BTNADDDEP').text("Add Details");
	 $('#dependentTitle').text("Add Dependent Details");
	 $('.editdep').show();
	 $('.deletedep').show();*/
	  $('.editdep').show();
	 $('#trdependent_'+uniqueid).removeClass('selected');
   
    // Append the created HTML to the table body
     

    // Hide the "new add dependent" form
    $('#newadddependentinfo').hide();
}
   

function populateAllGenderField(configJson, dataJson){
 var json= configJson["modifyDataJson"];
 
 configJson["comboId"]="Newdepgender";
 commonPopulateCombo(configJson, dataJson);
 $('#Newdepgender').val(json["depGen"]);
 
 configJson["comboId"]="patGender";
 commonPopulateCombo(configJson, dataJson);
 $('#patGender').val(json["genderId"]);
 
 	
}


function populateAllRelation(configJson, dataJson)
{
//	alert("populateAllRelation");
	 var json= configJson["modifyDataJson"];
 
 configJson["comboId"]="Newdeptrelation";
 commonPopulateCombo(configJson, dataJson);
  

 
 configJson["comboId"]="patrelation";
 commonPopulateCombo(configJson, dataJson);
 $('#patrelation').val(json["relation"]);
 
}
	
function addRowToTable() {
   $('#divDependentInfo').show();
 }
 
 function createRoqSequenceNo(className){
	 var sno=1;
	 $('.'+className).each(function(){
		$(this).text(sno++); 
	 });
 }
 /*function populateSubDepartment(deptId, subdeptid){
	 //alert("11111111");
		var configJson={
    			serviceName:"/getData/getSubServiceDepartment",
    			comboId:"patsubdepartmentP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":subdeptid,"optionText":"Select Sub Department"},
    			primaryKeys:[deptId],
    		}
    	callService(configJson);
 }
 function populateSubDepartmentserving(deptId, subdeptid){
	
	 alert("11111111");
		var configJson={
    			serviceName:"/getData/getSubServiceDepartment",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":subdeptid,"optionText":"Select Sub Department"},
    			primaryKeys:[deptId],
    		}
    	callService(configJson);
 }
 function PopulateOrganizationserving(subdeptid,deporg)
	 {
		// alert("in populateorganization");
		 	var configJson={
    			serviceName:"/getData/getOrganization",
    			comboId:"patdepartmentorg",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":deporg,"optionText":"Select Organization"},
    			primaryKeys:[subdeptid],
    		}
    	callService(configJson);
	 }
 
 function PopulateOrganization(subdeptid,deporg)
	 {
		// alert("in populateorganization");
		 	var configJson={
    			serviceName:"/getData/getOrganization",
    			comboId:"patorganizationp",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":deporg,"optionText":"Select Organization"},
    			primaryKeys:[subdeptid],
    		}
    	callService(configJson);
	 }*/
 
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
function handleDecision()

{
	//alert("1111111");
	 const approveButton = document.getElementById('approve');
        const rejectButton = document.getElementById('reject');
	 if (approveButton.checked) {
                alert("You have approved.");
                $('#statusflag').val("A")
                 $('#remarksbox').hide();
            //  saveData()
            } else if (rejectButton.checked) {
               alert("You have rejected.");
                $('#statusflag').val("R")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
            }
       } 

	
function saveData1()
{
	//alert("4444444444");
	 /*if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    */
   // showPreloader("Saving Data Please Wait !");
   // alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/ApplicationverifiedafterPayment",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };
    
    var dependentJsonArray = configJson.inputData.dependentJson;
    var parsedDependentJsonArray = null;

    // Check if dependentJson exists and is an array or a string (to be parsed)
    if (dependentJsonArray && Array.isArray(dependentJsonArray)) {
        // If it's already an array, map it to parse JSON strings (if necessary)
        parsedDependentJsonArray = dependentJsonArray.map(function(jsonString) {
            return JSON.parse(jsonString);
        });

        // Update configJson with the parsed dependentJson array
        configJson.inputData.dependentJson = parsedDependentJsonArray;

        // Optional: Alert to check the configuration before sending
      //  alert("configJson>>>" + JSON.stringify(configJson));
    } else if (typeof dependentJsonArray === 'string') {
        // If it's a single JSON string, parse it into an array
        try {
            parsedDependentJsonArray = JSON.parse(dependentJsonArray);

            // If parsing is successful, wrap it in an array
            if (parsedDependentJsonArray) {
                configJson.inputData.dependentJson = [parsedDependentJsonArray];
            }
        } catch (error) {
            console.error("Error parsing dependentJson:", error);
        }
    } else {
        // Handle the case where there is no dependentJson data
        alert("No valid dependent data found. Proceeding without dependentJson.");
    }

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