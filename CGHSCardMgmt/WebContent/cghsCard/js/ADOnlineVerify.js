let dependentArray = [];

$(document).ready(function () {
	
	initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	
	if(primaryKeyFromListPage!=""){
		
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		//alert("primary>>>>>>>>>>>"+arrpk[4]);
		
		$('#PatTrackingid').val(arrpk[1]);
		$('#PatTrackingidLbl').text("Tracking Id :" + arrpk[1]);
		var onlineflag=arrpk[4];
	//	alert("onlineflag>>>>"+onlineflag);
	   $("#formstatusflaghidden").val(arrpk[4]);
	   $("#formrenewalflaghidden").val(arrpk[5]);
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
	
	   var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "DepRelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": "",
            "optionText": "Select Relation"
        }
    };
     callService(configJson);
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
    
	    
	    $('#deptaction').change(function(){
	  var deptactionvalue=$('#deptaction').val();
	  var cardtypevalue=$("#cardtypevaluehidden").val();
	    var cardsubcategory=$("#cardsubcategoryhidden").val();
	//  alert("cardsubcategory>>>>>>>>>>"+cardsubcategory);
	//  alert(cardtypevalue);
//if(cardtypevalue=='P'){
	// 16-Jourmlist,17--PensionerAuto,18--ServingAuto,21--Airindia,11--Pensioner,20--Ex-gov-20
	if(cardsubcategory==17 ||   cardsubcategory==21)
	{
		  if(deptactionvalue==1){                             //Application approved and pending for payment
			  $('#statusflag').val("5")
			   $('#remarksbox').hide();
			   $("#intimatepayment").show();
			     $("#BTNSAVESERVING").hide();
              //  $("#BTNSAVEPENSIONER").show();
			   
		
		}
		else if(deptactionvalue==2)   // Application Rejected 
		{
			 $('#statusflag').val("9")
                $('#remarksbox').show();
                  $("#intimatepayment").hide();
                   $("#BTNSAVESERVING").hide();
               $("#BTNSAVEPENSIONERREJECTREMARKS").show();
		}else{
			 $('#statusflag').val("12")   // Application Returned to Beneficiary
                $('#remarksbox').show();
                  $("#intimatepayment").hide();
                   $("#BTNSAVESERVING").hide();
                $("#BTNSAVEPENSIONER").show();
		}
	}else if(cardsubcategory==16 || cardsubcategory==20   ||  cardsubcategory==11  ||  cardsubcategory==14  ||  cardsubcategory==20  || cardsubcategory==19)
	{
	 	   // alert(deptactionvalue);
	    if(deptactionvalue==1){                             //Application approved and pending for payment
			  $('#statusflag').val("4")
			   $('#remarksbox').hide();
			   $("#intimatepayment").show();
			     $("#BTNSAVESERVING").hide();
              //  $("#BTNSAVEPENSIONER").show();
			   
		
		}
		else if(deptactionvalue==2)   // Application Rejected 
		{
			 $('#statusflag').val("9")
                $('#remarksbox').show();
                  $("#intimatepayment").hide();
                   $("#BTNSAVESERVING").hide();
              $("#BTNSAVEPENSIONERREJECTREMARKS").show();
		}else{
			 $('#statusflag').val("12")   // Application Returned to Beneficiary
                $('#remarksbox').show();
                  $("#intimatepayment").hide();
                   $("#BTNSAVESERVING").hide();
                $("#BTNSAVEPENSIONER").show();
		}
	   
 }else{
	 
	 if(deptactionvalue==1){
			  $('#statusflag').val("6")
			   $('#remarksbox').hide();
			  $("#BTNSAVESERVING").show();
			 //   $("#BTNSAVEPENSIONER").hide();
			  
		}
		else if(deptactionvalue==2)
		{
			 $('#statusflag').val("9")
                $('#remarksbox').show();
                $("#BTNSAVESERVING").show();
                $("#BTNSAVEPENSIONERREJECTREMARKS").hide();
		}else{
			 $('#statusflag').val("12")
                $('#remarksbox').show();
                $("#BTNSAVESERVING").show();
             $("#BTNSAVEPENSIONER").hide();
                
		}
 }
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
        html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["nomuploaddoc"] + "&folderName=CARDDOCUMENT'>" + json["nomuploaddoc"] + "</a></td>";

       
      html += "</select>"; // End of dropdown
         html += "</td>";
     /*   html += "<td><button onclick='editRownom(this)'>Edit</button></td>";*/
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
					
				var resfileupload=	json["resdocupload"];
                //  alert(resfileupload);
                  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
                  var url = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["resdocupload"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["resdocupload"] + "</a>";
					
					$('#imagetest').html(url);
                                   //  alert("jsonfmafacility>>>>>>>>"+json["fmafacility"]);
                                 
                       var PPODocument=json["PPOdocument"];
					   var  formrenewalflag =  $('#formrenewalflaghidden').val();
                       //  alert("formrenewalflag>>>"+formrenewalflag);
						 
						 if(formrenewalflag == 1){ 
						 					
						 					
						 	$("#addressporoofrenewal").show();
						 	var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["addressProof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["addressProof"] + "</a>";
						 					                  $('#imagetest5').html(url1);
						 	$("#salaryporoofrenewal").show();	
						     var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["salaryProof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["salaryProof"] + "</a>";
						 				   						                  $('#imagetest6').html(url2);		  
						 	}
                    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["PPOdocument"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
                       $('#imagetest1').html(url1);
                       
                                var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["depspouse_doc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["depspouse_doc"] + "</a>";
                       $('#imagetest2').html(url2);
                       
                      $('#patName').val(json["FirstName"]);
                      $('#patNameHindi').val(json["Hindiname"]);
                      $('#patDOB').val(json["DOB"]);
                     // $('#patGender').val(json["gstr_gender_name"]);
                      $('#patMobileNo').val(json["MobileNo"]);
                      $('#statecode').val(json["gstr_statename"]);
                       $('#PatientCghsCity').val(json["gstr_city_name"]);
                     // $('#patrelation').val(json["relation"]);
                      
                              $('#patadcity').val(json["parent_city_name"]);
                        $('#statecode').val(json["gstr_statename"]);
                        
                     /*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
                       $('#patEmail').val(json["EmailId"]);
                        $('#patresaddress').val(json["ResAddress"]);
                    
                    
                         $('#PatCardtype').val(json["gstr_cardtype_name"]);
                          $('#patpincodeserving').val(json["Pincode"]);
                         
                           $('#patPANNo').val(json["PANNO"]);
                           $('#adcitycodehidden').val(json["adcitycode"]);
                           
	   
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
			defaultOption:{"optionValue":json["citycode"],"optionText":"Select City"}
			
			
	   	}
	          callService(configJson);
	
	//alert(json["hospitalcode"]);
	   var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["hospitalcode"],"optionText":""},
    			primaryKeys:[json["adcitycode"]],
    		}
    	callService(configJson);
	   

                 var cardtype=json["gstr_cardtype_name"];
                // alert(cardtype);
                  var year=json["deputationyear"];
                 var cardtypevaluecategory=json["cardtype"];
               // alert("cardtypecardtypecardtype"+cardtypevaluecategory);
              //  if (cardtype=='Pensioner' || cardtype=='Ex-MP' || cardtype=='Freedom Fighter')
              if(cardtypevaluecategory=='P')
                {
					//alert("iiinnnfiii")
					$('#cardtypevaluehidden').val("P");
				//	alert("latpay>>>>>>"+json["lastpay"]);
					 $('#patlastpaypensioner').val(json["lastpay"]);
				   var ppono=json["PPONo"];

					$('#servingdept').hide();
					$('#pensionerdept').show();
					  $('#patdeptpensioner').val(json["gstr_service_dept_name"]);
					  
					   $('#patcardcategoryP').val(json["cardcategory"]);
					  if(json["cardtype"]=='P'){
						$('#PatCardtypeP').val("Pensioner");  
					  }
					//  alert("cardcategory>>>>>>>>>>"+json["cardcategory"]);
					  
					     $('#patcardcategoryP').val(json["cardcategory"]);
					//$('#PatCardtypeP').val(json["cardtype"]);
					$('#PatsubCardtypeP').val(json["gstr_cardtype_name"]);
					
					var cardsubcategoryidvvalue=json["cardsubcategoryid"];
					//alert("cardsubcategoryidvvalue"+cardsubcategoryidvvalue);
					$('#cardsubcategoryhidden').val(json["cardsubcategoryid"]);
						var formvalue=$("#formstatusflaghidden").val();
						
					//	alert("formvalue>>>>>>"+formvalue);
							if(formvalue==1)
							{
													
							if(cardsubcategoryidvvalue==11 || cardsubcategoryidvvalue==17 || cardsubcategoryidvvalue==21)
							{
												
								$("#paymententerdetails").show();
								$("#selectedaction").hide();
								$("#BTNSAVESERVING").show();
							  $('#statusflag').val("6")
							   $('#paymententryflag').val("1")
								
							}else{
								$("#paymententerdetails").hide();
									$("#selectedaction").show();
									$("#BTNSAVESERVING").hide();
									 $('#paymententryflag').val("0")
							}
							
							}else{
									$("#selectedaction").show();
							}
						
       			 
				  $('#Patppopensioner').val(json["PPONo"]);
					 $('#patfmapensioner').val(json["treatmenttype"]);
			    $('#CardApplyvalidity').val(json["cardapplyvalidity"]);
			    $('#Patdorpensioner').val(json["DateofRetirement"]);
			    $('#Existingbenid').val(json["existingbenid"]);
			//	alert(json["gstr_fma_facility"]);
                         $('#patfmafacilitypensioner').val(json["gstr_fma_facility"]);
				   var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"patentitlementpensioner",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);
	      
	      	  
		  /*  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscalepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		      }
	         callService(configJson);*/
						
	 var configJson={
			serviceName:"/getData/getdepartmentpepensioner",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
		}
	callService(configJson);
	$("#patCardApplyValidity").val(json["cardapplyvalidity"]);
	$("#cardvalidityhidden").val(json["cardapplyvalidity"]);
	//alert("validity");
	/* var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"patCardApplyValidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);*/
	
	//alert("FMA");
	 var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
		}
	callService(configJson);
	
	
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
	//alert(json["orgid"])
/*	var configJson={
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
	
	
	/*
	 //alert(json["Deptid"]);
    	 var configJson={
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
    
      var configJson={
			
			serviceName:"/getData/getCPCbasedonpaylevel",
      	     callBackFunctionName:"populateCPC",	
			primaryKeys:[json["payscaleid"]],
		}
	callService(configJson);
    
    
    //alert("payscale"+json["payscaleid"]);
     var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscalelevelP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["payscaleid"],"optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["payscaleid"]],
    		}
    	callService(configJson)
     /* var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);*/
    
    	
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
  
		
	

		 $('#patpayscalelevelP').change(function(){
    	
    	if($('#patpayscalevalueP').val()=="")
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
    			comboId:"patentitlementserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patBasicpayserving').val()],
    		}
    	callService(configJson);
    });
    
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
    
    
    
			 $('#BTNPayment').show();		
		
				}else{
					
					
						var cardsubcategoryidvvalue=json["cardsubcategoryid"];
					//alert("cardsubcategoryidvvalue"+cardsubcategoryidvvalue);
					$('#cardsubcategoryhidden').val(json["cardsubcategoryid"]);
						var formvalue=$("#formstatusflaghidden").val();
						var formrenewalval = $("#formrenewalflaghidden").val();
						//alert("formrenewalval...."+formrenewalval);	
						
						if(formrenewalval == 1){
						  $("#BTNAPPROVERENEWAL").show();
													
													
						}else{				
							if(formvalue==1)
							{
								
							if(cardsubcategoryidvvalue==18 || cardsubcategoryidvvalue==23 || cardsubcategoryidvvalue==10 || cardsubcategoryidvvalue==16)
							{
						  
								$("#paymententerdetails").show();
								$("#selectedaction").hide();
								$("#BTNSAVESERVING").show();
							  $('#statusflag').val("6")
							  $('#paymententryflag').val("1")
							}else{
								$("#paymententerdetails").hide();
								$("#selectedaction").show();
								$("#BTNSAVESERVING").hide();
							    $('#paymententryflag').val("0")
							}
							
							}else{
									$("#selectedaction").show();
									$("#paymententerdetails").hide();
								$("#selectedaction").show();
								$("#BTNSAVESERVING").hide();
							    $('#paymententryflag').val("0")
							} 
					}
					
				//	alert(json["cardsubcategoryid"]);
					$('#cardsubcategoryhidden').val(json["cardsubcategoryid"]);
					$('#servingdept').show();
					$('#pensionerdept').hide();
					$('#cardtypevaluehidden').val("S");
					//$('#PatCardtype').val(json["gstr_cardtype_name"]);
				   $('#patdepartment').val(json["gstr_service_dept_name"]);
					$('#OfcAdress').val(json["officeaddress"]);
					$('#Presentpay').val(json["presentpay"]);
					
					$('#PatCardcategory').val(json["cardcategory"]);
				//	alert("deputationdate>>>>>>>>>>"+json["deputationenddate"]);
					if(json["deputationenddate"]){
					$('#Deputationenddate').val(json["deputationenddate"]);
					$('#Deputationenddatehidden').val(json["deputationenddate"]);
					//alert(json["cardsubcategoryid"]);
					
					$('#depdatediv').show();
					
				}else{
					$('#depdatediv').hide();
				}
					$('#Designation').val(json["Designation"]);
				                $('#PatCardtype').val(json["cardtype"]);
				                if(json["cardtype"]=='S'){
									$('#PatCardtype').val("Serving");
								}
                         $('#PatCardsubtype').val(json["gstr_cardtype_name"]);
				               
					var transfercityflag=json["transferflag"];
				  if(transfercityflag=='Y')
				  {
					$('#Transferableservice').val('Yes');
				  }else{
					  $('#Transferableservice').val('No');
				  }
			
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
		/* var configJson={
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
    	callService(configJson);
    //	alert("323232");*/
    
   /* var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdepartment').change(function(){
    	
    	if($('#patdepartment').val()=="")
    	{
    		$('#patsubdepartment').html("<option value=''>Select Organisation Name</option>");
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
	 
	  var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);*/	
	 
	   var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"]+'$'+json["ddocode"],"optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
  	$('#patsubdepartment').change(function(){
		    	
    	if($('#patsubdepartment').val()=="")
    	{
    		$('#patdepartment').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    //	alert("7jdhjhdjhdjhjd"+ $('#patsubdepartment').val());
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
    	
    	
    	
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[json["orgid"]],
    		}
    		callService(configJson);
  /*var configJson={
    			serviceName:"/getData/getpayscalevaluesDept",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);*/
    	
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
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["payscaleid"]],
    		}
    	callService(configJson);
    
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
	 
	 /*
	  var configJson={
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
			
			 var configJson={
			serviceName:"/getData/getADApprovestatus",
			comboId:"deptaction",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Action"}	
		}
		callService(configJson);
				
				
		                    
                $('#officeaddress').val(json["officeAddress"]);
                $('#displayuserinfo').show();
 });    
 
 
 
   
           }
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
    	 
    
    	}
		
		
		function showpaymentmodal()
		{
			//alert("1111111111111");
	var cardtypevalue=$('#cardtypevaluehidden').val();
	var cardsubcategoryvalue=$('#cardsubcategoryhidden').val();
	if(cardsubcategoryvalue==16)                    //Journlist cardtype
		{
			var enteramountbyad=$("#amountenterebyad").val();
			if (enteramountbyad !== null && enteramountbyad !== "") 
			{
				
			$("#paymentpopup").show();
		    $('#payamounthidden').val(enteramountbyad);
			$('#paymentpopup').text(enteramountbyad);
			$('#paymentlabel').show();
			$("#dialogOverlay").show();
				
			}else{
			$("#paymentpopup").show();
			var result = calculateAmountJournlist();
		    $('#payamounthidden').val(result);
			$('#paymentpopup').text(result);
			$('#paymentlabel').show();
			$("#dialogOverlay").show();
			}
		}else if(cardsubcategoryvalue==11 || cardsubcategoryvalue==19)    // Pensioner calculate formula
		{
			var enteramountbyad=$("#amountenterebyad").val();
			if (enteramountbyad !== null && enteramountbyad !== "") 
			{
				
			$("#paymentpopup").show();
		    $('#payamounthidden').val(enteramountbyad);
			$('#paymentpopup').text(enteramountbyad);
			$('#paymentlabel').show();
			$("#dialogOverlay").show();
				
			}else{
			 var payscale=$("#patpayscalelevelP option:selected" ).text();
			 var cardvalidity=$("#patCardApplyValidity").val();
			$("#paymentpopup").show();
			$("#payscalepopup").show();
			
			    $('#payscalepopup').text(payscale);
				$('#cardvaliditypopup').text(cardvalidity);
				var cpcvalue=$("#cpchiddenvalue").val();
				var result = calculateAmountPensioner(cpcvalue, cardvalidity); // Example: CPC value = 100, Card validity = 2 years
               //alert(result);
                 $('#payamounthidden').val(result);
                 $('#paymentlabel').show();
                 $('#cardvaliditypopup').show()
			$('#paymentpopup').text(result);
			$("#dialogOverlay").show();
			}
		}else if(cardsubcategoryvalue==17 || cardsubcategoryvalue==18 || cardsubcategoryvalue==21)//(Serving Auto,Pensioner Auto,AirIndia)
		{
			var enteramountbyad=$("#amountenterebyad").val();
			alert("enteramountbyad>>>>>>>"+enteramountbyad);
			if (enteramountbyad !== null && enteramountbyad !== "") 
			{
				
			$("#paymentpopup").show();
		    $('#payamounthidden').val(enteramountbyad);
			$('#paymentpopup').text(enteramountbyad);
			$('#paymentlabel').show();
			$("#dialogOverlay").show();
				
			}else{
			var adcitycode=$("#adcitycodehidden").val();
			//alert("adcitycode>>>>>>>>>>>>>"+adcitycode);
	     var configJson={
    			serviceName:"/getData/getamountbasedoncitycardtype",
      			callBackFunctionName:"populateamountbasedoncardtypecity",			
        		primaryKeys:[cardsubcategoryvalue,adcitycode],
    		}
    	callService(configJson);
    	
    	     // var amount1=$("#amountautonoumshidden").val();
    //	alert("amount>>>>>>>>>>222222"+amount1);
    //	$('#paymentpopup').text(amount1);
    	 var cardvalidity=$("#patCardApplyValidity").val();
    	 	$('#cardvaliditypopup').text(cardvalidity);
			$("#paymentlabel").show();
			    $('#cardvaliditypopup').show()
			$("#dialogOverlay").show();
    	}
    	
		}else{
			alert("Not found category for payment");
		}
		
		}
	
	
	
	function populateamountbasedoncardtypecity(configJson, dataJson)
	{
		
	   if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					
						var autonomusamount=json["amount"];
					//alert("autonomusamount>>>"+autonomusamount);
					//	$("#amountautonoumshidden").val(autonomusamount);
						$("#payamounthidden").val(autonomusamount);
						
							$('#paymentpopup').text(autonomusamount);
	    
		  });
        }
    	else{
    	  	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	   	return;
    	}
        	    }    	    
    }	
		
	
	 
    function populateCPC(configJson, dataJson)
    {
 			
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					
						var CPCValue=json["CPC"];
					//	alert("CPCValue>>>"+CPCValue);
						$("#cpchiddenvalue").val(CPCValue);
	          
		  });
        }
    	else{
    	  	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	   	return;
    	}
        	    }    	    
    }	
		
	

function populateTrackingDependent(configJson, dataJson) {
  //  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
          var getcardvalidityservingdor="";

    if (dataJson["message"].indexOf("ERROR") < 0) {
        $.each(dataJson["data"], function(_, json) {
			//alert(json["dependentuploaddoc"]);
	
	  var disablityflagdisplay="";
	     var disablityflag=json["disablityflag"] ;
		 //alert("calculatedbvalidity>>>>"+json["calculatedbvalidity"] );
		  //alert("renewal>>>>"+json["renewal"] );
		  var renewal = json["renewal"];
	     if(disablityflag==1)
	     {
			 disablityflagdisplay="Yes";
		 }else{
			 disablityflagdisplay="No";
		 }
		 var depdob=json["DOB"];
		 var depslno=json["depslno"];
	//	 alert("depslno>>>>>>>>>>"+depslno);
	    var relationid=json["deprelationid"];
	    //var cardvalidityyears=9;
	      let currentDate = new Date(); // Get the current date
        // Display the value for debugging
              var benId = json["benId"];
			//  alert("benId>>>"+benId);
                  var cardvalidityyearstring="";
               var cardvalidityallmembers ="";
          var cardtypevalue=$('#cardtypevaluehidden').val();
          if(cardtypevalue=='P'){
			  
        cardvalidityyearstring=$("#cardvalidityhidden").val();
     // alert("cardvalidityyearsiiiiinnnncreatedepjson"+cardvalidityyearstring);
        cardvalidityyearstring=Number(cardvalidityyearstring);
		    var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
		  //  alert("cardvalidityallmembers>>>>>>>>>>>>>>>"+cardvalidityallmembers);
    /*  if(cardvalidityyearstring=="Lifetime")
      {
		  cardvalidityyearstring=10;
		  cardvalidityyearstring=Number(cardvalidityyearstring);
		    var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
	  }else{
		  cardvalidityyearstring=Number(cardvalidityyearstring);
        var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
	  }*/
      

 
    }else
    {
		var servingdor=$("#dorservinghidden").val();
		var deputationdatehidden=$("#Deputationenddatehidden").val();
		//alert("deputationdatehiddendate>>>>>>>>>>>"+deputationdatehidden);
		if(deputationdatehidden){
			let currentDate = new Date();
			var getcardvalidityondepuyear=calculateYearsFromDate(deputationdatehidden);
		//	alert("deputationyear>>>>>>"+getcardvalidityondepuyear);
			  var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, getcardvalidityondepuyear);
		}else if(servingdor)
		{
			//alert("cardvaliditydbbbbbb"+json["calculatedbvalidity"]);
			//alert("relationid>>>>>"+relationid);
			let currentDate = new Date();
		    cardvalidityyearstring=5;
			 var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
			  
			  								  
					let d1 = new Date(parseDDMMYYYYtoYMD(cardvalidityallmembers));
				//	 alert("cardvalidityDate111111111>>>>>>>>>>>>>>>"+d1);
					let d2 = new Date(parseDDMMYYYYtoYMD(servingdor));
				
			  	if (d1.getTime() > d2.getTime()) {
					  //  alert("d1 is after d2");
					     getcardvalidityservingyear=calculateYearsFromDate(servingdor);
					  cardvalidityallmembers=  calculatecardvalidityservingdep(depdob, relationid, getcardvalidityservingyear,servingdor);
					  
					 // 	 alert("cardvalidityallmembers>>>>>>>>>>>"+cardvalidityallmembers);
					  //    cardvalidityallmembers=servingdor;
					}else{
						 cardvalidityyearstring=5;
			  var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
					}
					
		
			  
			}
			
			else if(json["calculatedbvalidity"]){
				//alert("iiinnn renewal");
			  //if(renewal == 1){
				cardvalidityallmembers =  json["calculatedbvalidity"];
				//alert(cardvalidityallmembers);
			 // }else{
				  }else{
					  
				  
				cardvalidityyearstring=5;
				      
				         cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
                   // alert("gdsssss2222"+cardvalidityallmembers);
				            //alert(cardvalidityallmembers);
				
			  }
			
			
			 
	 
	}
      	var jsonDep={
		"cardvalidityallmembersjson":cardvalidityallmembers,
		    "depslno":depslno,
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
			   "benId":json["benId"],
	           
	     } 
         	createDependentRow(jsonDep);             
        });
        
           
        
        
         $( "button" )
         .click(function( event ) {
           event.preventDefault();
         });
        $( "input[type=button], button" )
          .click(function( event ) {
            event.preventDefault();
               });

     
         // $('#Deptable').show();
        
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
        return;
    }
}
let currentRow; 
function editRow(button, index)  {
//alert("iinn row");

   $('#dependentinfomodify').show(); // Show the modify container
    currentRow = button.closest("tr"); // Store the current row being edited
    var cells = currentRow.querySelectorAll("td");
     $('#editRowIndex').val(index);
 //alert("editrowindex"+editrowindex);
 
 //   alert("Editing: " + cells[0].innerText);
          $('#DepName').val(cells[1].innerText);
          $('#DepDob').val(cells[2].innerText);
           $('#DepGender').val(cells[3].innerText);
          // $('#DepRelation').val(cells[3].innerText);
         // var relationvalue=cells[4].querySelector(".relation-dropdown").value;
        
      var relationDropdown = cells[4].querySelector(".relation-dropdown");
    var relationvalue = relationDropdown ? relationDropdown.value : "";
    console.log("Relation value:", relationvalue); // Debugging output

    // Set the relation value if you need to display it somewhere
    $('#DepRelation').val(relationvalue); // Assuming you have an input to show this value

    // Get the photo URL from the appropriate cell
       var photoUrl = cells[5].querySelector("img").src;
     // alert(photoUrl);
   
 
    if (photoUrl) {
        document.getElementById("editPhoto").src = photoUrl;
    } else {
       
        document.getElementById("editPhoto").src = ""; // or a default image
    }
 
   // Handle the file link
    var fileLink = cells[7].querySelector("a") ? cells[7].querySelector("a").href : "#";
    var fileName = cells[7].querySelector("a") ? cells[7].querySelector("a").innerText : "File";
    //alert(fileLink);
    // Update the file link for editing
    viewfileedit.href = fileLink;
    viewfileedit.innerText = fileName;
    viewfileedit.target = "_blank"; // Open in a new tab

   //  $('#disflag').val(cells[6].innerText);

}

/*function SaveRenewal(){
	

	
	var personalInfo = {
	      
	        patEmail: $('#patEmail').val(),
	        patresaddress: $('#patresaddress').val(),
			
			patsubdepartment: numberOnly,//ddo org
			 patdepartment: $('#patdepartment').val(),//org 
			 PatCardtype: $('#PatCardtype').val(),
			 PatCardcategory: $('#PatCardcategory').val(),
			 PatCardsubtype: $('#PatCardsubtype').val(),
			 patpayscaleserving: $('#patpayscaleserving').val(),  
			 patpayscalevalueserving: $('#patpayscalevalueserving').val(),
			 patBasicpayserving: $('#patBasicpayserving').val(),
			 patentitlementserving: $('#patentitlementserving').val(),
			 OfcAdress: $('#OfcAdress').val()
	       
	    };
		
		
	$("#Deptable tbody tr").each(function () {
			
			
			//let uploadedImg = $row.find("td:eq(5)").find("img").attr("src");
			
			alert("Uploaded Image from Column 5: " + uploadedImg);
			
			dependentArray.push({
					    
					      
						  
					   });
			
		});
}
*/
function handleDecision()

{
	
	 const approveButton = document.getElementById('approve');
        const rejectButton = document.getElementById('reject');
	 if (approveButton.checked) {
                alert("You have approved.");
                $('#remarksbox').hide();
                $('#statusflag').val("3")
            } else if (rejectButton.checked) {
               alert("You have rejected.");
                $('#statusflag').val("8")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
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
function saveData() {
	
	//alert("1111111111111");
	
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
   //  alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/OnlineBenidGenerate",
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
	
//	alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
	
// Check if message contains "ERROR"
if (dataJson["message"].indexOf("ERROR") < 0) {
    // Parse the JSON string into an array
    try {
        var parsedMessage = JSON.parse(dataJson["message"]);
        
        // Ensure the parsed message is an array
        if (Array.isArray(parsedMessage)) {
            $.each(parsedMessage, function(_, json) {
				var firstBenId = parsedMessage[0]["benId"];
				  //alert("firstBenId>>>>>>>>>>>>" + firstBenId);
                var Benid = json["benId"];
                var mainchflag=json["mainCardHolder"];
            
          
            var imgBase64=json["imgBase64"];
                $('#Benidvalue').val(firstBenId);
     
		showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
            });
        } else {
            alert("Parsed message is not an array!");
        }
    } catch (error) {
        alert("Error parsing JSON: " + error.message);
    }
} else {
    // Show an alert for invalid range
    showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
    return;
}


	}
}
	
  
function resetPage(){
//alert("iinn reset page");
	submitFormMaster("ViewBeneficiaryafterBenid","add");	
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
        serviceName: "/DMLSAVE/OnlinePensionerpaymentstatus",
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
	//console.log('configJson', configJson);
//alert('configJson', configJson);
    // Call the service
    callService(configJson);
}


	
function callbackSaveData1(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{

		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}

		showMsg(dataJson["message"],dialogConfigJson)
		
		var trackingid = configJson.inputData.PatTrackingid.trim();
		var patmobile =  configJson.inputData.patMobileNo.trim();
		//var patMobile ="8619929647";
		
		
		
		const data = new Array(trackingid,"cghs.mohfw.gov.in");
		  		const mobileNumbers = new Array(patmobile); 
		  		jsonObject ={
					"templateId":"",
					  "data":[],
		      	    "mobileNumbers":[],
				}
					jsonObject.templateId="1107174832352873261";
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

	
  
function resetPage1(){
//alert("iinn reset page");
	parent.closeModal();	
}

  
  
  function abc()
  {
	//  alert("11111111111");
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
	 // alert(previewHiddenId);

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
function addRowToTable() {
//	alert("1111111111111");
   $('#newadddependentinfo').show();
     var configJson={
						serviceName:"/getData/getGenderList",
						comboId:"Newdepgender",			
						callBackFunctionName:"commonPopulateCombo",
						defaultOption:{"optionValue":"","optionText":"Select Gender"}	
    }
callService(configJson);


var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"Newdeptrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);
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
    row.parentNode.removeChild(row); // Remove the row from the table
}

	 
function adddepinfo() {
	//alert("111");

  const depnameadd = document.getElementById('Newdepname').value;
    
   const depentrelationadd= $( "#Newdeptrelation option:selected" ).text();
   const depentrelationaddID= $( "#Newdeptrelation option:selected" ).val();
  const depDOBadd = document.getElementById('NewdepDOB').value;
  
  const depgenderadd=$( "#Newdepgender option:selected" ).text();
  const depgenderaddID=$( "#Newdepgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#NewdepBloodGroup option:selected" ).text();

    const imgSrc = $("#fileContent2").val();
         const fileuploadvalue=$('#filename11').val();
    //alert("fileuploadvaluefileuploadvaluefileuploadvalue"+fileuploadvalue);
     const disablityflag=$('#isdisablityvaluehidden').val();
    // alert(disablityflag);
     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     "dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc, 
     "dependentuploaddoc":fileuploadvalue,
     "dependentdisablityflag":disablityflag
     } 
     
         
      createDependentRow(json);
    
      
    }  
    let rowIndex = 1;
      function createDependentRow(json) { //alert("createDependentRow");
    var isGlobal = $('#isGlobal').val() != undefined || $('#isGlobal').val() != '' ? $('#isGlobal').val() : '0';
    var ticket = $('#varSSOTicketGrantingTicket').val() != undefined ? $('#varSSOTicketGrantingTicket').val() : "";
   
   
    var relationid = json["dependentRelationId"];
    var dependentdob = json["deppendentDOBadd"];
	
  

    var html = "<tr>";  // Start the row
    html += "<td>" + rowIndex + "</td>";  // Add index here
    html += "<td>" + json["benId"] + "</td>";  // Add index here
    html += "<td>" + json["depname"] + "</td>";  // Dependent name
    html += "<td>" + json["deppendentDOBadd"] + "</td>";  // Dependent date of birth

    // Gender dropdown
    html += "<td>";
    html += "<select class='gender-dropdown'>";
    html += "<option value='Select Gender'>Select Gender</option>";
    html += "<option value='" + json["dependentGenderId"] + "' selected>" + json["dependentGender"] + "</option>";  // Set the selected option to the dependent's gender
    html += "</select>";
    html += "</td>";

    // Relation dropdown
    html += "<td>";
    html += "<select class='relation-dropdown'>";
    html += "<option value='Select Relation'>Select Relation</option>";
    html += "<option value='" + json["dependentRelationId"] + "' selected>" + json["dependentRelation"] + "</option>";  // Set the selected option to the dependent's relation
    html += "</select>";
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

    // Card validity
    html += "<td><input type='text' class='card-validity'  id = 'card-validity' value='" + json["cardvalidityallmembersjson"] + "' ></td>";
 html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
    html += "</tr>";  // Close the row

    // Append the row to the table
    $("#Deptable tbody").append(html);
    $("#Deptable").show();
    rowIndex++;
    
    
     $(".card-validity").datepicker({
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
  
}

/*
function populateSubDepartment(deptId, subdeptid){
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
	 
	 
	 
	 function calculateAmountPensioner (cpcvalue,cardvalidity){
		  var amount=cpcvalue*cardvalidity*12;
		  return amount;
	 }
	 
	 
	  function calculateAmountJournlist(){
		  var amount=1067;
		  return amount;
	 }
function handleResponse(response) {
//	alert("response>>>>>>>>>>>"+response);
     if (response === true)  {
        saveData1();
	   } else {
     $("#amountbox").show();
     showpaymentmodal();
  //   $("#amountenterebyad").val();
      }

      // Close the dialog box
      document.getElementById('dialogOverlay').style.display = 'none';
    }
    
        function calculatecardvalidity(depdob,relationid,cardvalidityyears){
		
		let currentDate = new Date();
			//alert("relationid>>>>"+relationid);
			  const depage = calculateAge(depdob);
			  //alert("relationid11111111111depagedepage"+depage)
		if(relationid==1){
		//	alert("cardvalidityyears>>>>>>>>>>>>>>>>>>>>>>"+cardvalidityyears);
			
			var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
		}
		else if(relationid==5){
		// alert("iiinnn elseeeeeee cardvalidity relationidrelationid 55555");
		//alert("depage>>"+depage);
	       const depsonagevalue = 25 - depage;
	     //   alert("depsonagevalue"+depsonagevalue) ;
	        if(depsonagevalue>=cardvalidityyears){
				var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
			}else{
				var cardvaliditydate= addYearsToDate(currentDate, depsonagevalue);
			return cardvaliditydate;
			}
	       
	}
	 else if(relationid==15){
		// alert("iiinnn elseeeeeee cardvalidity relationid15555");
	
	       const depsonagevalue =18 - depage;
	       // alert("depsonagevalue"+depsonagevalue+"cardvalidityyears>>"+cardvalidityyears);
	       if(depsonagevalue>=cardvalidityyears){
				var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
			}else{
				var cardvaliditydate= addYearsToDate(currentDate, depsonagevalue);
			return cardvaliditydate;
			}
	       
	}else{
		
	//	alert("iiinnn elseeeeeee cardvalidity");
			
			
			var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
	}
	
	}
	
function addYearsToDate(currentDate, years) {
    // Debugging: alert the number of years being added
 // alert("years>>>>" + years);
     if (years === 10) {
        return "01-01-2099";
    }
    // Create a copy of the current date to avoid modifying the original date
    let resultDate = new Date(currentDate);

    // Add the specified number of years to the current date
    resultDate.setFullYear(resultDate.getFullYear() + years);

    // Format the result date as dd-mm-yyyy
    let day = resultDate.getDate().toString().padStart(2, '0');
    let month = (resultDate.getMonth() + 1).toString().padStart(2, '0'); 
    let year = resultDate.getFullYear(); 
    return `${day}-${month}-${year}`;
}

/*
	
	function populateSubDepartmentserving(deptId, subdeptid){
	
//	 alert("11111111");
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
	 }*/

function calculateAge(dobString) {
//	alert("aggggeee");
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

function calculateYearsFromDate(date) {
    // Ensure the date is in string format dd-mm-yyyy
    if (typeof date !== 'string') {
        throw new Error("The date must be a string in dd-mm-yyyy format.");
    }

    // Split the date string into day, month, and year
    const [day, month, year] = date.split('-').map(num => parseInt(num, 10));

    // Create a Date object from the provided date
    const providedDate = new Date(year, month - 1, day); // months are 0-indexed in JavaScript

    // Get the current date
    const currentDate = new Date();
//alert("currentdate>>>>>"+currentDate);
    // Calculate the difference in years
    let yearsDifference = providedDate.getFullYear()-currentDate.getFullYear();


//alert("yearsDifference>>>>>"+yearsDifference);
    // Adjust the year difference if the current date hasn't yet reached the provided date for this year
   /* if (currentDate.getMonth() < providedDate.getMonth() || 
        (currentDate.getMonth() === providedDate.getMonth() && currentDate.getDate() < providedDate.getDate())) {
        yearsDifference--;
    }*/

    return yearsDifference;
}



function UpdateRemarks()
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
        serviceName: "/DMLSAVE/UpdateRejectRemarksonlineByAd",
        callBackFunctionName: "callbackSaveDataUpdateRejectRemarksonlineByAd",
        inputData: processSerializeArray("ENTRYFORM")
    };

   
    callService(configJson);
}


	
function callbackSaveDataUpdateRejectRemarksonlineByAd(configJson, dataJson){
	
	//alert(JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{

		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}

		showMsg(dataJson["message"],dialogConfigJson)
		
		
			} 

}

function resetPageRejectRemarksonlineByAd(){
//alert("iinn reset page");
	parent.closeModal();	
}



function SaveRenewal()
{
	//alert ("inside SaveRenewal ");
	
	//alert(JSON.stringify(processSerializeArray("ENTRYFORM")));

	  var configJson = {
	        serviceName: "/DMLSAVE/updaterenewalRequestdata",
	        callBackFunctionName: "callbackSaveDataSaveRenewal",
	        inputData: processSerializeArray("ENTRYFORM")
	    };
		
		
		
		//alert("mmmmmmmmm");

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


		
	function callbackSaveDataSaveRenewal(configJson, dataJson){
		
		//alert(JSON.stringify(dataJson));
		if(dataJson["message"].indexOf("ERROR")>=0){
			showMsg(dataJson["message"],null)
		}
		else{

			var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}

			//showMsg(dataJson["message"],dialogConfigJson)
			
			// Check if message contains "ERROR"
			if (dataJson["message"].indexOf("ERROR") < 0) {
			    // Parse the JSON string into an array
			    try {
			        var parsedMessage = JSON.parse(dataJson["message"]);
			        
			        // Ensure the parsed message is an array
			        if (Array.isArray(parsedMessage)) {
			            $.each(parsedMessage, function(_, json) {
							var firstBenId = parsedMessage[0]["benId"];
							  //alert("firstBenId>>>>>>>>>>>>" + firstBenId);
			                var Benid = json["benId"];
			                var mainchflag=json["mainCardHolder"];
			            
			          
			            var imgBase64=json["imgBase64"];
			                $('#Benidvalue').val(firstBenId);
			     
					showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
			            });
			        } else {
			            alert("Parsed message is not an array!");
			        }
			    } catch (error) {
			        alert("Error parsing JSON: " + error.message);
			    }
			} else {
			    // Show an alert for invalid range
			    showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
			    return;
			}
			
			
				} 

	}

	function resetPageRejectRemarksonlineByAd(){
	//alert("iinn reset page");
		parent.closeModal();	
	}


