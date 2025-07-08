$(document).ready(function () {
	
	initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#PatTrackingid').val(arrpk[1]);
		$('#PatTrackingidLbl').text("Tracking Id :" + arrpk[1]);
		
		var onlineflag=arrpk[4];
		//alert("onlineflag>>>>"+onlineflag);
	   $("#formstatusflaghidden").val(arrpk[4]);
	   $("#formrenewalflaghidden").val(arrpk[5]);
	   //alert("1st renewal flag check---"+$("#formrenewalflaghidden").val(arrpk[5]));
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
	
	
	
	    //$('#BTNMODIFY').click(saveData);
	    
	    
	     
    
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
	    $('#deptaction').change(function(){
	  var deptactionvalue=$('#deptaction').val();
	  var cardtypevalue=$("#cardtypevaluehidden").val();
	 // alert(cardtypevalue);

	 	//   alert(deptactionvalue);
	    if(deptactionvalue==1){
			  $('#statusflag').val("3")
			   $('#remarksbox').hide();
			  // $("#intimatepayment").show();
		
		}
		else if(deptactionvalue==2)
		{
			alert("innn elsee");
			 $('#statusflag').val("8")
                $('#remarksbox').show();
                //  $("#intimatepayment").hide();
                     $('#daverifyonlineform').show();
                     $('#daverifyoffline').hide();
                     
                
		}else{
			 $('#statusflag').val("11")
                $('#remarksbox').show();
                //  $("#intimatepayment").hide();
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
                    
          //alert("11111"); 
	
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
					   
					// alert('json["addressProof"]----'+json["addressProof"]);
//alert("formrenewalflaghidden--"+$('#formrenewalflaghidden').val());
					   
					   if(formrenewalflag == 1){ 
						
						
						$("#addressporoofrenewal").show();
						var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["addressProof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["addressProof"] + "</a>";
						                  $('#imagetest5').html(url1);
				       $("#salaryporoofrenewal").show();	
					   var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["salaryProof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["salaryProof"] + "</a>";
					   						                  $('#imagetest6').html(url2);		  
										  
						                  
					   }
                        // alert("PPODocument>>>"+PPODocument);
                    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["PPOdocument"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
                       $('#imagetest1').html(url1);
                       
                                var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["depspouse_doc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["depspouse_doc"] + "</a>";
                       $('#imagetest2').html(url2);
                       
                      // alert("imagetest3>>>>>>>>>>"+json["payslipupload"]);
                         var url3 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["payslipupload"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["payslipupload"] + "</a>";
                       $('#imagetest3').html(url3);
                       
                       
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
	
	
	json["hospitalcode"]
	   var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["hospitalcode"],"optionText":"Select Wellness center"},
    			primaryKeys:[json["adcitycode"]],
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
	   
	    var configJson={
			serviceName:"/getData/getWellnesscenter",
			comboId:"PatientWc",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"},
		   
			
	   	}
	          callService(configJson);
	   
	   	
  
	   

                 var cardtype=json["gstr_cardtype_name"];
                // alert(cardtype);
                  var year=json["deputationyear"];
                 var applyforcardtype=json["cardtype"];
               // alert("cardtypecardtypecardtype"+cardtypevaluecategory);
              //  if (cardtype=='Pensioner' || cardtype=='Ex-MP' || cardtype=='Freedom Fighter')
              if(applyforcardtype=='P')
                {
					$('#cardtypevaluehidden').val("P");
				//	alert("latpay>>>>>>"+json["lastpay"]);
					 $('#patlastpaypensioner').val(json["lastpay"]);
				   var ppono=json["PPONo"];

				//	alert("iinnn pensioner"+ppono);
					$('#servingdept').hide();
					$('#pensionerdept').show();
					  $('#patdeptpensioner').val(json["gstr_service_dept_name"]);
					  
					  
					  if(json["cardtype"]=='P'){
						$('#PatCardtypeP').val("Pensioner");  
					  }
					  
					 // alert("card subcategory>>>>>"+json["cardsubcategoryid"]);
					if(json["cardsubcategoryid"]==17 || json["cardsubcategoryid"]==21)
					{
						// alert("iiiinnnnnnnnnnnnn");
				       $("#patpayscalelevelP").removeAttr('data-validation');
				       $("#patpayscalelevelP").attr('data-validation','numeric');
				          $("#patpayscalevalueP").removeAttr('data-validation');
				          $("#patBasicpayP").removeAttr('data-validation');
				          initValidation('ENTRYFORM');	
				       
					}
					  	 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardcategoryP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategoryid"],"optionText":"Select Card Category "},
			primaryKeys:[json["cardtype"]],
			
		}
	callService(configJson);
	
 $('#patcardcategoryP').change(function(){
    	
    	if($('#patcardcategoryP').val()=="")
    	{
    		$('#PatsubCardtypeP').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"PatsubCardtypeP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardcategoryP').val()],
    		}
    	callService(configJson);
    	
   
    	
    });
     	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"PatsubCardtypeP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["cardsubcategoryid"],"optionText":"Select SubCategory"},
    			primaryKeys:[json["cardcategoryid"]],
    		}
    	callService(configJson);
    	
    	
    	
    	//alert("fma>>>>>>>>>>"+json["treatmenttype"]);
    	  var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
			
		}
	callService(configJson);
	
	   $('#patfmapensioner').change(function(){
		   
		  if( $( "#patfmapensioner" ).val()=="1")
		  {
		showMsg("Applicants availing FMA are eligible only for IPD facility i.e.In patient only. IPD only card holders and dependents are eligible for admissions on credit and reimbursements only. Investigations/ day care procedures and OPD consultations/ OPD medicines are not covered under IPD only facility.","");

		  }
    	if($('#patfmapensioner').val()=="")
    	{
    		$('#patfmafacilitypensioner').html("<option value=''>Select Facility</option>");
    		return;    		
    	}
    	//alert("yyyyyyyyyyyyyyy"+$("#patfmapensioner").val());
    	var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[$("#patfmapensioner").val()],
    		}
    	callService(configJson);
    });
    
    var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["fmafacilityid"],"optionText":"Select Facility"},
    			primaryKeys:[json["treatmenttype"]],
    		}
    	callService(configJson);
	  
					//    $('#patcardcategoryP').val(json["cardcategory"]);
					  //		$('#PatsubCardtypeP').val(json["gstr_cardtype_name"]);
					  var cardsubcategoryidvvalue=json["cardsubcategoryid"];
					 	//alert("cardsubcategoryidvvalue>>>>>>"+cardsubcategoryidvvalue);
					var formvalue = $("#formstatusflaghidden").val();
					
//alert("formvalue>>>>>>" + formvalue);


if (formvalue == 1) {
	//alert("formvalue>>>>>>" + formvalue);
    if (cardsubcategoryidvvalue == 11 || cardsubcategoryidvvalue == 17 || cardsubcategoryidvvalue == 14 || cardsubcategoryidvvalue == 20 ||  cardsubcategoryidvvalue == 19 || cardsubcategoryidvvalue == 21) {
      //alert("iiinnniff>>>>>>" + cardsubcategoryidvvalue);
        $("#paymententerdetails").show();
        $("#selectedaction").hide();
        $('#statusflag').val("6");
        $('#paymententryflag').val("1");
          $('#daverifyoffline').show();
           $("#daverifyonlineform").hide();
    } else {
		//alert("iiinn elseee")
        $("#paymententerdetails").hide();
        $("#selectedaction").show();
         $('#paymententryflag').val("0");
         $('#daverifyoffline').show();
    $("#daverifyonlineform").hide();
    }

} else {
			
						if(cardsubcategoryidvvalue==17 || cardsubcategoryidvvalue==21)
         	{
				// alert("cardsubcategoryidvvalue"+cardsubcategoryidvvalue);
		              $("#paymententerdetails").show();
						$("#selectedaction").hide();
						$("#BTNSAVESERVING").show();
					  $('#statusflag').val("6")
					  $('#paymententryflag').val("1")
					   $('#daverifyoffline').show();
					   $("#daverifyonlineform").hide();
	}
	
						
				//	alert("inelse");
							$("#selectedaction").show();
							
							$("daverifyonlineform").show();
	//alert("iinn else"+cardsubcategoryidvvalue);
	
/*	//alert("iiiinnnelsseeeform")
    $("#selectedaction").show();
    $('#daverifyoffline').hide();
    $("#daverifyonlineform").show();*/
}

					  var cardvalidity=json["cardapplyvalidity"];
					 // alert("cardvalidity"+cardvalidity);
					//$('#PatCardtypeP').val(json["cardtype"]);
					$('#PatsubCardtypeP').val(json["gstr_cardtype_name"]);
										
       			 
				  $('#Patppopensioner').val(json["PPONo"]);
					// $('#patfmapensioner').val(json["treatmenttype"]);
			  //  $('#CardApplyvalidity').val(json["cardapplyvalidity"]);
			    $('#Patdorpensioner').val(json["DateofRetirement"]);
			    $('#Existingbenid').val(json["existingbenid"]);
			//	alert(json["gstr_fma_facility"]);
                        // $('#patfmafacilitypensioner').val(json["gstr_fma_facility"]);
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
	//alert("validity"+json["cardapplyvalidity"]);
	
	$("#patCardApplyValidity").val(json["cardapplyvalidity"]);
	$("#cardvalidityhidden").val(json["cardapplyvalidity"]);
	/* var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"patCardApplyValidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);
	*/
	//alert("FMA");
	/* var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
		}
	callService(configJson);*/
	alert("concat value>>>>>>>" +json["orgid"]+'$'+json["ddocode"]);
	
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
	
    
 alert("payscalevalues>>>>>>>>>>"+json["payscalevalue"]);
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["payscaleid"]],
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
    			comboId:"patentitlementP",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patBasicpayP').val()],
    		}
    	callService(configJson);
    });
    
    
			 $('#BTNPayment').show();		
		
				}else{
					
					var cardsubcategoryidvvalue=json["cardsubcategoryid"];
				//	alert("cardsubcategoryidvvalue"+cardsubcategoryidvvalue);
					$('#cardsubcategoryhidden').val(json["cardsubcategoryid"]);
					
					
					//alert("cardtype>>>>>>>>>>>"+json["cardtype"]);
					var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"PatCardcategory",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardcategoryid"],"optionText":"Select Card Category "},
			primaryKeys:[json["cardtype"]],
			
		}
	callService(configJson);
	
 $('#PatCardcategory').change(function(){



	// alert("valuesubcategory>>>>>>"+$('#PatCardcategory').val());
	 //alert("valuesubcategory>>>>>>"+$('#PatCardcategory').val());

    	
    	if($('#PatCardcategory').val()=="")
    	{
    		$('#PatCardsubtype').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"PatCardsubtype",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#PatCardcategory').val()],
    		}
    	callService(configJson);
    	
   
    	
    });
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"PatCardsubtype",			
    			   callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["cardsubcategoryid"],"optionText":"Select SubCategory"},
    			primaryKeys:[json["cardcategoryid"]],
    		}
    	callService(configJson);
    	
			
			
			
						var formvalue=$("#formstatusflaghidden").val();
						 var  formrenewalflag =  $('#formrenewalflaghidden').val();
if(formrenewalflag==1){
	
}else{
							//alert("formvalue"+formvalue);
					if(formvalue==1)
					{
						
					if(cardsubcategoryidvvalue==18  || cardsubcategoryidvvalue==16)
					{
				  
						$("#paymententerdetails").show();
						$("#selectedaction").hide();
						$("#BTNSAVESERVING").show();
					  $('#statusflag').val("6")
					  $('#paymententryflag').val("1")
					   $('#daverifyoffline').show();
					   $("#daverifyonlineform").hide();
					  
					}else{
						
						//alert("iiinnelse");
						$("#paymententerdetails").hide();
						$("#selectedaction").show();
						$("#BTNSAVESERVING").show();
						$("#BTNMODIFY").hide();
						
					    $('#paymententryflag').val("0")
					       $('#daverifyoffline').show();
					   $("#daverifyonlineform").show();
					}
					
					}else{
				//	alert("inelse");
						
						if(cardsubcategoryidvvalue==18)
         	           {
				// alert("cardsubcategoryidvvalue"+cardsubcategoryidvvalue);
		              $("#paymententerdetails").show();
						$("#selectedaction").hide();
						$("#BTNSAVESERVING").show();
					  $('#statusflag').val("6")
					  $('#paymententryflag').val("1")
					   $('#daverifyoffline').show();
					   $("#daverifyonlineform").hide();
	                }
	
						if(cardsubcategoryidvvalue==23)
						{
							 $("#paymententerdetails").hide();
							 $("#selectedaction").hide();
						$("#BTNSAVESERVING").show();
						 $('#statusflag').val("6")
					  $('#paymententryflag').val("0")
					   $('#daverifyoffline').show();
					   $("#daverifyonlineform").hide();
						}
				//	alert("inelse");
							$("#selectedaction").show();
							
							$("daverifyonlineform").show();
					}
				}	
				//	alert(json["cardsubcategoryid"]);
					$('#cardsubcategoryhidden').val(json["cardsubcategoryid"]);
					//	alert(json["payscalevalue"]);
					$('#servingdept').show();
					$('#pensionerdept').hide();
					$('#cardtypevaluehidden').val("S");
					//$('#PatCardtype').val(json["gstr_cardtype_name"]);
					//  $('#PatCardcategory').val(json["cardcategory"]);
					
					
				   $('#patdepartment').val(json["gstr_service_dept_name"]);
					$('#OfcAdress').val(json["officeaddress"]);
					$('#Presentpay').val(json["presentpay"]);
					
					if(json["deputationenddate"]){
					$('#Deputationenddate').val(json["deputationenddate"]);
					$('#Deputationenddatehidden').val(json["deputationenddate"]);
					
					$('#depdatediv').show();
					
				}else{
					$('#depdatediv').hide();
				}
					//$('#Designation').val(json["Designation"]);
				                $('#PatCardtype').val(json["cardtype"]);
				                if(json["cardtype"]=='S'){
									$('#PatCardtype').val("Serving");
								}
                       //  $('#PatCardsubtype').val(json["gstr_cardtype_name"]);
				               
					var transfercityflag=json["transferflag"];
				  if(transfercityflag=='Y')
				  {
					$('#Transferableservice').val('Yes');
				  }else{
					  $('#Transferableservice').val('No');
				  }
				  //alert("date of Retirement>>>>>>>>>"+json["DateofRetirement"]);
				   $('#Patdorserving').val(json["DateofRetirement"]);
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
				   
				   $("#dorservinghidden").val(json["DateofRetirement"]);
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
			serviceName:"/getData/getmainorgtype",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Department"}	
			
		}
	 callService(configJson);*/
	 
	 
    	
    //	alert("323232");
    
    
/*    
  var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			
    		}
    	callService(configJson);*/
    	
    //	alert("hdhdghdghg"+json["orgid"]+'$'+json["ddocode"]);
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
			
    	/*	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    		callService(configJson);*/
    	
    /*	alert("dhghdghgdhgghd"+json["orgid"]);
    		var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["orgid"],"optionText":"Select Organisation name"},
    			primaryKeys:[json["orgid"]],
    		}
    		callService(configJson);*/
    	
    	
    	
    	
    	
    		var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevalueserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":json["payscalevalue"],"optionText":"Select values"},
    			primaryKeys:[json["payscaleid"]],
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
			serviceName:"/getData/getmainorgtype",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["orgid"],"optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);*/

	
	/* $('#patdepartment').change(function(){
    	
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
    });*/
	 
/*
	 var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdepartment",			
    			callBackFunctionName:"commonPopulateCombo",
    			primaryKeys:[json["orgid"]],
    		}
    	callService(configJson);	
	*/
}
				
			 var configJson={
			serviceName:"/getData/getDealingAssApprovestatus",
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
		if(cardtypevalue=='P')
		{
			
			
			    var payscale=$("#patpayscalelevelP option:selected" ).text();
             //   alert("payscale>>>>>>>"+payscale);
                var cardvalidity=$("#patCardApplyValidity").val();
			  //  alert("cardvaliditycardvalidity>>>>>>>"+cardvalidity);
			    $('#payscalepopup').text(payscale);
				$('#cardvaliditypopup').text(cardvalidity);
				var cpcvalue=$("#cpchiddenvalue").val();
				var result = calculateAmount(cpcvalue, cardvalidity); // Example: CPC value = 100, Card validity = 2 years
              //   alert(result);
                 $('#payamounthidden').val(result);
			$('#paymentpopup').text(result);
			$("#dialogOverlay").show();
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
    	}        	    }    	    
    }	
		
	
	
	
	
	

function populateTrackingDependent(configJson, dataJson) { //alert("1270");
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
	
	

function populateTrackingDependent(configJson, dataJson) { //alert("1345");
   //alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
      var cardvalidityyearstring="";
      var getcardvalidityservingyear="";
      var getcardvalidityservingdor="";
               var cardvalidityallmembers ="";
    if (dataJson["message"].indexOf("ERROR") < 0) {
        $.each(dataJson["data"], function(_, json) {
			//alert(json["dependentuploaddoc"]);
	
	  var disablityflagdisplay="";
	     var disablityflag=json["disablityflag"] ;
		 //alert("calculatedbvalidity>>>>"+json["calculatedbvalidity"] );
		// alert("renewal>>>>"+json["renewal"] );
		 var renewal = json["renewal"];
		 var benId = json["benId"];
	     if(disablityflag==1)
	     {
			 disablityflagdisplay="Yes";
		 }else{
			 disablityflagdisplay="No";
		 }
		 var depdob=json["DOB"];
	    var relationid=json["deprelationid"];
		
	    //var cardvalidityyears=9;
	      let currentDate = new Date(); // Get the current date
        // Display the value for debugging
              var depslno=json["depslno"];
          var cardtypevalue=$('#cardtypevaluehidden').val();
		  
          if(cardtypevalue=='P'){
			  
        cardvalidityyearstring=$("#cardvalidityhidden").val();
   //   alert("cardvalidityyearsiiiiinnnncreatedepjson"+cardvalidityyearstring);
       cardvalidityyearstring=Number(cardvalidityyearstring);
       
		     cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
   
      

 
    }else    
    {
		
		
		var deputationdatehidden=$("#Deputationenddatehidden").val();
		var servingdor=$("#dorservinghidden").val();
		//alert("deputationdatehiddendate>>>>>>>>>>>"+deputationdatehidden);
		if(deputationdatehidden){
			let currentDate = new Date();
			 getcardvalidityondepuyear=calculateYearsFromDate(deputationdatehidden);
			//alert("deputationyear>>>>>>"+getcardvalidityondepuyear);
			  var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, getcardvalidityondepuyear);
			 // alert("gdsssss"+cardvalidityallmembers);
            
		}else if(servingdor)
		{
		//	alert("cardvaliditydbbbbbb"+json["calculatedbvalidity"]);
			//alert("relationid>>>>>"+relationid);
			let currentDate = new Date();
		    cardvalidityyearstring=5;
			 var cardvalidityallmembers = calculatecardvalidity(depdob, relationid, cardvalidityyearstring);
			  
			  								  
					let d1 = new Date(parseDDMMYYYYtoYMD(cardvalidityallmembers));
				//	 alert("cardvalidityDate111111111>>>>>>>>>>>>>>>"+d1);
					let d2 = new Date(parseDDMMYYYYtoYMD(servingdor));
				
			  	if (d1.getTime() > d2.getTime()) {
					//    alert("d1 is after d2");
					     getcardvalidityservingyear=calculateYearsFromDate(servingdor);
					  cardvalidityallmembers=  calculatecardvalidityservingdep(depdob, relationid, getcardvalidityservingyear,servingdor);
					  
					//  	 alert("cardvalidityallmembers>>>>>>>>>>>"+cardvalidityallmembers);
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
	           
	           "dependentbhavisyaflag":json["bhavisyaflag"],
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

function parseDDMMYYYYtoYMD(dateStr) {
	//alert(">>>>>>>>>>>>>>"+dateStr);
    const [day, month, year] = dateStr.split("-");
    return `${year}-${month}-${day}`; // "2030-06-16"
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


function parseDDMMYYYY(dateStr) {
    const [day, month, year] = dateStr.split("-");
    return new Date(`${year}-${month}-${day}`);
}

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
	
	//alert(JSON.stringify(configJson));
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
	// submitFormMaster("PlasticCardPrint","add");	
	
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
        serviceName: "/DMLSAVE/applicationverifybyDA",
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
	
//	alert(JSON.stringify(configJson));
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
    //alert("imgSrc"+imgSrc);
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
    
  
      function createDependentRow(json) {
	 let rowIndex = 1;	   
    var isGlobal = $('#isGlobal').val() != undefined || $('#isGlobal').val() != '' ? $('#isGlobal').val() : '0';
    var ticket = $('#varSSOTicketGrantingTicket').val() != undefined ? $('#varSSOTicketGrantingTicket').val() : "";
   
   
    var relationid = json["dependentRelationId"];
    var dependentdob = json["deppendentDOBadd"];
  

    var html = "<tr>";  // Start the row
    html +="<td class='slno'></td>";
	html += "<td>" + json["benId"] + "</td>";
    html += "<td>" + json["depname"] + "</td>";  // Dependent name
    html += "<td>" + json["deppendentDOBadd"] + "</td>";  // Dependent date of birth
       html += "<td>" + json["dependentGenderId"] + "</td>";  // Dependent date of birth
       html += "<td data-value='" + json["dependentRelation"] + "'>" + json["dependentRelation"] + "</td>";

/*     html += "<td>" + json["dependentRelation"] + "</td>";  // Dependent date of birth
*/   /* // Gender dropdown
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
*/
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
    html += "<td>" + json["cardvalidityallmembersjson"] + "</td>";
    
/*     html += "<td>" + json["dependentbhavisyaflag"] + "</td>";
*/      html += "<td>" + json["depslno"] + "</td>";

if (relationid == 1)
{

}else{
		       html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["depslno"] + "\", \"" +  json["dependentRelationId"] + "\", this)'>Edit</a></td>";

}
     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";

    html += "</tr>";  // Close the row

    // Append the row to the table
    $("#Deptable tbody").append(html);
    $("#Deptable").show();
     var index=1;
     $('.slno').each(function(){
		 $(this).text(index);
		 index++;
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
	 }
	 
	 
	 */
	 function calculateAmount (cpcvalue,cardvalidity){
		  var amount=cpcvalue*cardvalidity*12;
		  return amount;
	 }
	 
function handleResponse(response) {
//	alert("response>>>>>>>>>>>"+response);
     if (response === true)  {
        saveData1();
	   } else {
       // alert("111");
      }

      // Close the dialog box
      document.getElementById('dialogOverlay').style.display = 'none';
    }
    
    
    function calculatecardvalidity(depdob,relationid,cardvalidityyears){
		
		let currentDate = new Date();
		//	alert("depdob>>>>"+depdob);
			  const depage = calculateAge(depdob);
			  //alert("relationid11111111111depagedepage"+depage)
		if(relationid==1){
		//alert("cardvalidityyears>>>>>>>>>>>>>>>>>>>>>>"+cardvalidityyears);
			
			var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
		}
		else if(relationid==5){
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
	
	       const depsonagevalue =18 - depage;
	      //  alert("depsonagevalue"+depsonagevalue) 
	       if(depsonagevalue>=cardvalidityyears){
				var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
			}else{
				var cardvaliditydate= addYearsToDate(currentDate, depsonagevalue);
			return cardvaliditydate;
			}
	       
	}else{
			
			
			var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
	}
	
	}
	
	function calculatecardvalidityservingdep(depdob, relationid, cardvalidityyears, servingdor) {
  //  alert("relation id >>>>> " + servingdor);

    // Convert servingdor string (DD-MM-YYYY or similar) to Date object
    let servingdorDate = parseDDMMYYYYnew(servingdor);
     //  alert("servingdorDate id >>>>> " + servingdorDate);
    const depage = calculateAge(depdob);  // Assuming this returns a number

  //  alert("Dependent Age: " + depage);

    let cardvaliditydate;

    if (relationid == 1) {
        cardvaliditydate = servingdorDate;
    } else if (relationid == 5) {
        const depsonagevalue = 25 - depage;
        alert("depsonagevalue: " + depsonagevalue);
        if (depsonagevalue >= cardvalidityyears) {
            cardvaliditydate = addYearsToDateserving(servingdorDate, cardvalidityyears);
        } else {
            cardvaliditydate = addYearsToDateserving(servingdorDate, depsonagevalue);
        }
    } else if (relationid == 15) {
        const depsonagevalue = 18 - depage;
        if (depsonagevalue >= cardvalidityyears) {
            cardvaliditydate = addYearsToDateserving(servingdorDate, cardvalidityyears);
        } else {
            cardvaliditydate = addYearsToDateserving(servingdorDate, depsonagevalue);
        }
    } else {
           cardvaliditydate = servingdorDate;
    }

    return formatToDDMMYYYY(cardvaliditydate);
}


function parseDDMMYYYYnew(dateStr) {
    const [day, month, year] = dateStr.split("-");
    return new Date(year, month - 1, day);  // Local date
}


function formatToDDMMYYYY(dateObj) {
    const dd = String(dateObj.getDate()).padStart(2, '0');
    const mm = String(dateObj.getMonth() + 1).padStart(2, '0'); // Months are 0-indexed
    const yyyy = dateObj.getFullYear();
    return `${dd}-${mm}-${yyyy}`;
}
	
	/*  function calculatecardvalidityservingdep(depdob,relationid,cardvalidityyears,servingdor){
		
		let currentDate = new Date();
		alert("relation id>>>>>"+relationid);
	//	let servingdordate=new Date(servingdor);
			//alert("servingdorservingdor>>>>"+servingdordate);
			  const depage = calculateAge(depdob);
			  alert("relationid11111111111depagedepage"+depage)
		if(relationid==1){
		//alert("cardvalidityyears>>>>>>>>>>>>>>>>>>>>>>"+cardvalidityyears);
			
			var cardvaliditydate= servingdor;
			//addYearsToDate(servingdor, cardvalidityyears);
			return cardvaliditydate;
		}
		else if(relationid==5){
		alert("depage>>"+depage);
	       const depsonagevalue = 25 - depage;
	        alert("depsonagevalue"+depsonagevalue) ;
	        if(depsonagevalue>=cardvalidityyears){
				var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
			}else{
				var cardvaliditydate= addYearsToDate(currentDate, depsonagevalue);
			return cardvaliditydate;
			}
	       
	}
	 else if(relationid==15){
	
	       const depsonagevalue =18 - depage;
	      //  alert("depsonagevalue"+depsonagevalue) 
	       if(depsonagevalue>=cardvalidityyears){
				var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
			}else{
				var cardvaliditydate= addYearsToDate(currentDate, depsonagevalue);
			return cardvaliditydate;
			}
	       
	}else{
			
			
			var cardvaliditydate= addYearsToDate(currentDate, cardvalidityyears);
			return cardvaliditydate;
	}
	
	}
	*/
	
	/*function populateSubDepartmentserving(deptId, subdeptid){
	
	// alert("11111111");
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
 */
function addYearsToDate(currentDate, years) {
    // Debugging: alert the number of years being added
   //alert("years>>>>" + years);
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

function addYearsToDateserving(baseDate, years) {
    let result = new Date(baseDate);
    result.setFullYear(result.getFullYear() + years);
    return result;
}
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
	//alert("date>>>>"+date);
    // Ensure the date is in string format dd-mm-yyyy
    if (typeof date !== 'string') {
        throw new Error("The date must be a string in dd-mm-yyyy format.");
    }

    // Split the date string into day, month, and year
    const [day, month, year] = date.split('-').map(num => parseInt(num, 10));

    // Create a Date object from the provided date
    const providedDate = new Date(year, month - 1, day); // months are 0-indexed in JavaScript

//alert("providedDate>>>>>"+providedDate);
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

function Edit(memberid, relationid, button) {
    $('#divDependentInfo').show();
    $('#divDependentAddInfo').hide();

    // Store the current row being edited globally
    currentEditRow = button.closest("tr");

    var cells = currentEditRow.querySelectorAll("td");

    var memberName = cells[1].innerText;
    var dob = cells[2].innerText;
    var gender = cells[3].innerText;
    var relation = cells[4].innerText;
    var validUpto = cells[7].innerText;
    var depslno=cells[8].innerText;
    $('#Newdepname').val(memberName);
    $('#NewdepDOB').val(dob);
    $('#Newdeptrelation').val(relation);
    $('#Newdepgender').val(gender);
 //   $('#NewdepvalidUpto').val(validUpto);
      $('#Newdepslno').val(depslno);

    $("#NewdepDOB").datepicker({
        dateFormat: "dd-mm-yy",
        changeMonth: true,
        changeYear: true,
        showButtonPanel: true,
        showOtherMonths: true,
        selectOtherMonths: true,
        yearRange: "-100:+100",
        onSelect: function(date, datepicker) {
            var id = $(datepicker).attr("id");
            $('#' + id).trigger('blur');
        }
    });

    $("#NewdepvalidUpto").datepicker({
        minDate: new Date(),
        maxDate: new Date(2099, 11, 31),
        dateFormat: "dd-M-yy",
        changeMonth: true,
        changeYear: true,
        yearRange: "2024:2099",
        showButtonPanel: true,
        showOtherMonths: true,
        selectOtherMonths: true,
        onSelect: function(date, datepicker) {
            console.log(date);
        }
    });

    // Optional: Load dropdowns
   // alert("relationId>>>>>>>>>>>>>"+relationid);

    callService({
        serviceName: "/getData/getDependentRelation",
        comboId: "Newdeptrelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": relationid,
            "optionText": "Select Relation"
        }
    });

    callService({
        serviceName: "/getData/getGenderList",
        comboId: "Newdepgender",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": gender,
            "optionText": "Select Gender"
        }
    });
}


function SaveDependent() {
    if (!currentEditRow) {
        alert("No row selected for editing.");
        return;
    }

    var updatedName = $('#Newdepname').val();
    var updatedDob = $('#NewdepDOB').val();
    var updatedRelationValue = $('#Newdeptrelation').val();
    var updatedGenderValue = $('#Newdepgender').val();
    var updatedValidUpto = $('#NewdepvalidUpto').val();
      var updateslno=$('#Newdepslno').val();
    // Get selected option text
    var updatedRelationText = $('#Newdeptrelation option:selected').text();
    var updatedGenderText = $('#Newdepgender option:selected').text();

    var cells = currentEditRow.querySelectorAll("td");

    // Update the table with display text
    cells[1].innerText = updatedName;
    cells[2].innerText = updatedDob;
    cells[3].innerText = updatedGenderText;
    cells[4].innerText = updatedRelationText;
    cells[7].innerText = updatedValidUpto;
 cells[8].innerText = updateslno;
    $('#divDependentInfo').hide();
    currentEditRow = null;
}


function UpdateDetails()
{
	/*if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  
 */
    var configJson = {
        serviceName: "/DMLSAVE/UpdateDependentTrackingDetails",
        callBackFunctionName: "callbackUpdateDependentTrackingDetails",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
}

	
function callbackUpdateDependentTrackingDetails(configJson, dataJson){
	
//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
	//	alert("m here");
		var dialogConfigJson={callOnOK:"resetPageupdate","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPageupdate(){
window.location.reload();
 //submitFormMaster("BeneficiaryModification","add");
	}
	
	
	
	function modifymainchdetails()
	{
		  var configJson = {
        serviceName: "/DMLSAVE/updatedmainchttrackingdetailsDA",
        callBackFunctionName: "callbackupdatedmainchttrackingdetailsDA",
        inputData: processSerializeArray("ENTRYFORM")
    };
     

    // Call the service
    callService(configJson);
	}

function callbackupdatedmainchttrackingdetailsDA(configJson, dataJson){
	
//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
	//	alert("m here");
		var dialogConfigJson={callOnOK:"resetPageupdate2","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
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
function resetPageupdate2(){
window.location.reload();
 //submitFormMaster("BeneficiaryModification","add");
	}
