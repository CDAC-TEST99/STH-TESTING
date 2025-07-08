let dependentArray = [];

$(document).ready(function() {
	//hidePreloader();
	
	
	//alert("cardrenwal");
	
	initPage();



	var primaryKeyFromListPage = $('#primaryKeyFromListPage').val();


	var primaryKeyFromListPage = $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>" + primaryKeyFromListPage);
	if (primaryKeyFromListPage != "") {
		/*	var arrpk = decrypt(primaryKeyFromListPage).split("@");
			$('#Benidvalue').val(arrpk[1]);*/

		//  alert("key>>>>>>>>>>>"+arrpk[1]);
		//gettrackingid();
		var cardtypevalue = $('#cardtypevaluehidden').val();
		//alert("cardtypevalue===="+cardtypevalue);
		var arrpk = (primaryKeyFromListPage).split("^");
		//alert("Benidvalue>>>>>>>>>>"+arrpk[0]);
		var Benid = arrpk[0];
		//alert("BENID" + Benid);
		
		var configJson = {
					//serviceName:"/getData/getBeneficiaryDetails",
					serviceName: "/getData/getexistingdetailsrenewal",
					primaryKeys: [Benid],
					//callBackFunctionName: "PopulateBeneficiaryDetails",
					callBackFunctionName: "Populatedatatbenidrecordexistornot",

				}
				callService(configJson);
		
		var configJson = {
			//serviceName:"/getData/getBeneficiaryDetails",
			serviceName: "/getData/getbeneficiarydetailsrenewal",
			primaryKeys: [Benid],
			callBackFunctionName: "PopulateBeneficiaryDetails",

		}
		
		
		
		callService(configJson);

		//  state and district drop down starts
//alert("cardtype>>>>>>>>>>>"+cardtypevalue);
	/*	var configJson = {
			serviceName: "/getData/getstatelistbasedonCardType",
			comboId: "stateCode",
			callBackFunctionName: "commonPopulateCombo",
			defaultOption: { "optionValue": "", "optionText": "Select State" },
			primaryKeys: [cardtypevalue],
		}
		callService(configJson);

		$('#stateCode').change(function() {

			if ($('#stateCode').val() == "") {
				$('#districtCode').html("<option value=''>Select District</option>");
				return;
			}
			var configJson = {
				serviceName: "/getData/getDistrictList",
				comboId: "districtCode",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue": "", "optionText": "Select District" },
				primaryKeys: [$('#stateCode').val(), cardtypevalue],
			}
			callService(configJson);
		});*/

		// state and district ends 


		var configJson = {
			serviceName: "/getData/getfamilymembers",
			primaryKeys: [Benid],
			callBackFunctionName: "populatefamilymembers",

		}
		callService(configJson);



	}
	else {
		hidePreloader();
		$('#divTrackingIdEntry').show();
		$('#PatTrackingidLbl').hide();
	}





});


function initPage() {
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');
	initInputJson = $(':input').serializeArray();
	hidePreloader();
	new WOW().init();
}

function getBeneficiarydetails() {
	//		var Benid=$('#Benid').val();
	var Benid = document.getElementById('Benid').value;

	//   alert("11111"+Benid);
	if (Benid == '') {
		alert("Plesae enter BenId");
		return;

	}

	// alert("11111"); 

	var configJson = {
		serviceName: "/getData/getBeneficiaryDetails",
		primaryKeys: [Benid],
		callBackFunctionName: "PopulateBeneficiaryDetails",

	}
	callService(configJson);




	var configJson = {
		//serviceName:"/getData/getBeneficiaryDetailsDependent",
		serviceName: "/getData/getbeneficiarydetailsdependentrenewal",
		primaryKeys: [Benid],
		callBackFunctionName: "populateBenIdDependent",

	}
	callService(configJson);



}





function Populatedatatbenidrecordexistornot(configJson, dataJson){
			//  alert("configJson>>> " + JSON.stringify(configJson));
			 //alert("configJson>>> " + JSON.stringify(dataJson));
    	
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               var Trackingid=json["TrackinId"];
			  // var renewal = sessionStorage.getItem("renewal");
              var Renewal=json["Renewal"];
			  
			  //alert(typeof Renewal);
			 //sessionStorage.removeItem("renewal");
//alert("trackingiddd"+Trackingid);
//alert("Renewal"+Renewal);


if(Trackingid && Renewal === '1')
	{ 
		
		//alert('inside if');
		sessionStorage.setItem("txnId", Trackingid);
			$('#masterKey').val("CardRenewalStatus");
			submitFormWithResetTextField("CallMasterPage");
			
			
			//window.location.href = "cardnenewalview.jsp";

			
		
		
	}  else if(Trackingid && Renewal === '0'){   
		
		
		//alert('inside else');
						
						
						$('#masterKey').val("CardRenewal");   
					//	 submitFormWithResetTextField("CallMasterPage");
						  
						 // window.location.href = "cardrenwal.jsp";

		
	}  
              
			     
			  
	
		
    });
			     
			   
                 
        	    
        	}else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
		}
		
		
		
		function populateApplictionTrakingDtls(configJson, dataJson) { alert ("populateApplictionTrakingDtls") ;
			    	  //  alert("configJson>>> " + JSON.stringify(configJson));
			    	  // alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

			    	 
											
								
			    	    	 $('#getrenewalstatus').show();
			    	    	
			    	    let indx = 1;
			    	    const tableBody = $("#getrenewalstatus tbody");
			    	    tableBody.empty();
			    	    var trackingId="";
			    	    // checking if error exists
			    	    if(dataJson["message"].indexOf("ERROR")<0){
			        	    $.each(dataJson["data"], function(_, json){
			              var statusflagapplication=json["statusid"];
								//alert("statusflagapplication");
								var trackingid=json["Trackingid"];
								//alert("trackingid>>>>"+trackingid);
							$('#hiddentrackingid').val(trackingid);
							 trackingId=json["Trackingid"];
			        	    	let html = "<tr>";
			          	        html += "<td class='paymentslno'>" + indx + "</td>";
			          	        html += "<td>" + json["Trackingid"] + "</td>"; 
			          	        html += "<td>" + json["FirstName"] + "</td>";
			          	        html += "<td>" + json["applyDate"] + "</td>";
			          	        html += "<td>" + json["CardType"] + "</td>";
			          	        html += "<td>" + json["gstr_cardtype_name"] + "</td>";
			                	  html += "<td>" + json["MobileNo"] + "</td>";
			          	         html += "<td>" + json["gstr_application_status"] + "</td>";
			          	         	html += "<td>" + json["Rejremarks"] + "</td>";
									html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
			          	         
			          	 /*        if(statusflagapplication=="4"){

			               	       html += "<td><a class='btn btn-his-sm'  onclick='enterpayment(\"" + trackingId + "\")'>Check Payment Details</a></td>";
			                      }
			                      else if(statusflagapplication=="8" || statusflagapplication=="7" ||  statusflagapplication=="9" || statusflagapplication=="10" ||statusflagapplication=="11" ||statusflagapplication=="12"|| statusflagapplication=="13")
			                      {
									  html += "<td>" + json["gstr_application_status"] + " | " + json["Rejremarks"] + "</td>";
										
							 html += "<td><a class='btn btn-his-sm' onclick='ApplyNewcard()'>Re-Apply</a></td>";

								  }
								  
								  else if(statusflagapplication=="2")
								  {
							    html += "<td><a class='btn btn-his-sm' onclick='CancelApplication()'>Cancel</a></td>";
							    
							 html += "<td><a class='btn btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";


								  }
								   else{
							 html += "<td><a class='btn btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
							 html += "<td><a class='btn btn-his-sm' onclick='CancelApplication()'>Cancel</a></td>";
						  }
			          	     */   html += "</tr>";
			          	        trackingId=json["Trackingid"];
			          	        tableBody.append(html);
			            	    });
			        	     	/* var index = 1;
			    $('.paymentslno').each(function() {
			        $(this).text(index);
			        index++;
			            });
			            var configJson={
			          				serviceName:"/getData/getonlineformhtml",
			          				primaryKeys:[document.getElementById('hiddenmobile').value],
			          				"trackingId":trackingId, 
			          				callBackFunctionName:"populateonlineformhtml",
			          			 				
			          			}
			          		callService(configJson);
			        	    */
			        	}
			    	    else{
			    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
			    	    	return;
			    	    }
			        	    	    
			    	}

		
		
function PopulateBeneficiaryDetails(configJson, dataJson) {
	//  alert("PopulateBeneficiaryDetails   configJson>>> " + JSON.stringify(configJson));
	//alert("PopulateBeneficiaryDetails  dataJson>>>>>>>> " + JSON.stringify(dataJson));
	hidePreloader();


	if (dataJson["message"].indexOf("ERROR") < 0) {
		$.each(dataJson["data"], function(_, json) {



			var resfileupload = json["resdocupload"];
			//  alert(resfileupload);
			var isGlobal = $('#isGlobal').val() != undefined || $('#isGlobal').val() != '' ? $('#isGlobal').val() : '0';
			var ticket = $('#varSSOTicketGrantingTicket').val() != undefined ? $('#varSSOTicketGrantingTicket').val() : "";
			var url = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["resdocupload"] + "&isGlobal=" + isGlobal + "&varSSOTicketGrantingTicket=" + ticket + "&folderName=CARDDOCUMENT'>" + json["resdocupload"] + "</a>";

			$('#imagetest').html(url);
			//  alert("jsonfmafacility>>>>>>>>"+json["fmafacility"]);

			var PPODocument = json["PPOdocument"];
			// alert("PPODocument>>>"+PPODocument);
			var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["PPOdocument"] + "&isGlobal=" + isGlobal + "&varSSOTicketGrantingTicket=" + ticket + "&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
			$('#imagetest1').html(url1);

			var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["depspouse_doc"] + "&isGlobal=" + isGlobal + "&varSSOTicketGrantingTicket=" + ticket + "&folderName=CARDDOCUMENT'>" + json["depspouse_doc"] + "</a>";
			$('#imagetest2').html(url2);

			$('#patName').val(json["FirstName"]);
			$('#patNameHindi').val(json["FirstName"]);
			$('#patDOB').val(json["DOB"]);
			// $('#patGender').val(json["gstr_gender_name"]);
			$('#patMobileNo').val(json["Mobileno"]);
		//	$('#statecode').val(json["gstr_statename"]);
			$('#PatientCghsCity').val(json["gstr_city_name"]);
			// $('#patrelation').val(json["relation"]);

			$('#patadcity').val(json["parent_city_name"]);
			$('#parentcitycodehidden').val(json["adcitycode"]);
			$('#patpincodeserving').val(json["pincode"]);


			//$('#statecode').val(json["gstr_statename"]);
			//$('#statecode').val(json["gstr_statename"]);stateCode
			//$('#stateCode').val(json["stateCode"]);
		//	$('#districtCode').val(json["distCode"]);

			/*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
			$('#patEmail').val(json["EmailId"]);
			$('#patresaddress').val(json["resdaddress"]);


			$('#PatCardtype').val(json["gstr_cardtype_name"]);

		/*	var configJson = {
						serviceName: "/getData/getstatelistbasedonCardType",
						comboId: "stateCode",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": json["stateCode"], "optionText": "" },    
						//primaryKeys: [cardtypevalue],
					}
					callService(configJson);
				
					alert("hghghghg"+json["distCode"]);
						var configJson = {
									serviceName: "/getData/getDistrictList",
									comboId: "districtCode",
									callBackFunctionName: "commonPopulateCombo",
									defaultOption: { "optionValue": json["distCode"], "optionText": "" }, 
									//primaryKeys: [$('#stateCode').val(), cardtypevalue],
								}
								callService(configJson);
*/
			var configJson = {
				serviceName: "/getData/getGenderList",
				comboId: "patGender",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue": json["genderId"], "optionText": "" }

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


			var configJson = {
				serviceName: "/getData/getCghscityList",
				comboId: "PatientCghsCity",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue": json["satellitecitycode"], "optionText": "Select City" }


			}
			callService(configJson);

			$('#PatientCghsCity').change(function() {

				var configJson = {
					serviceName: "/getData/getADCityBasedonsatelliteCity",
					callBackFunctionName: "populatecity",
					primaryKeys: [$('#PatientCghsCity').val()],
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


			var configJson = {
				serviceName: "/getData/getwellnesscenterbasedoncity",
				comboId: "patientwc",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue": json["gnum_hospital_code"], "optionText": "Select Wellness center" },
				primaryKeys: [json["adcitycode"]],
			}
			callService(configJson);





			var cardtype = json["gstr_cardtype_name"];
			// alert(cardtype);
			var year = json["deputationyear"];
			var cardtypevaluecategory = json["cardtype"];
			//alert(cardtypevaluecategory);
			if (cardtypevaluecategory == 'P') {
				//alert("validupto"+json["validupto"]);
				$('#cardtypevaluehidden').val("P");
				$('#patlastpaypensioner').val(json["lastpay"]);
				var ppono = json["PPONo"];

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

				var configJson = {
					serviceName: "/getData/getmaincardcategory",
					comboId: "patcardtypecategorypen",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["cardcategoryid"], "optionText": "Select Card Category " },
					primaryKeys: [json["cardtype"]],

				}
				callService(configJson);

				$('#patcardtypecategorypen').change(function() {

					if ($('#patcardtypecategorypen').val() == "") {
						$('#patsubcardtypepensioner').html("<option value=''>Select SubCategory</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getCardTypeList",
						comboId: "patsubcardtypepensioner",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select SubCategory" },
						primaryKeys: [$('#patcardtypecategorypen').val()],
					}
					callService(configJson);



				});

				var configJson = {
					serviceName: "/getData/getCardTypeList",
					comboId: "patsubcardtypepensioner",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["subcategoryid"], "optionText": "Select SubCategory" },
					primaryKeys: [json["cardcategoryid"]],
				}
				callService(configJson);


				//alert("payscale"+json["payscaleid"]);
				var configJson = {
					serviceName: "/getData/getpayscale",
					comboId: "patpayscalelevelP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["gnum_pay_scales"], "optionText": "Select Payscale" }

				}
				callService(configJson);


				var configJson = {
					serviceName: "/getData/getpayscalevaluesDept",
					comboId: "patpayscalevalueP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["payscalevalue"], "optionText": "Select values" },

				}
				callService(configJson);

				var configJson = {

					serviceName: "/getData/getbasicpaylevelBasedonvalueDept",
					comboId: "patBasicpayP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["basicpay"], "optionText": "Select BasicPay" },

				}
				callService(configJson);

				var configJson = {
					serviceName: "/getData/getEntitlementbasedonbasicpayDept",
					comboId: "patentitlementP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["entitlement"], "optionText": "Select Payscale" },

				}
				callService(configJson);



				$('#patpayscalevalueP').change(function() {


					var salary = $("#patpayscalevalueP option:selected").text();


					var basiclevel = validateSalary(salary);


					var configJson = {

						serviceName: "/getData/getbasicpaylevelBasedonvalue",
						comboId: "patBasicpayP",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": json["basicpay"], "optionText": "Select BasicPay" },
						primaryKeys: [basiclevel],
					}
					callService(configJson);


				});



				$('#patBasicpayP').change(function() {

					if ($('#patBasicpayP').val() == "") {
						$('#patentitlementP').html("<option value=''>Select Payscale</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getEntitlementbasedonbasicpay",
						comboId: "patentitlementP",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select Payscale" },
						primaryKeys: [$('#patBasicpayP').val()],
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
				var configJson = {
					serviceName: "/getData/getcardvalidity",
					comboId: "patCardApplyValidity",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["cardapplyvalidity"], "optionText": "Select cardvalidity" }
				}
				callService(configJson);

				//alert("FMA");
				var configJson = {
					serviceName: "/getData/getFmalist",
					comboId: "patfmapensioner",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["treatmenttype"], "optionText": "Select FMA" }
				}
				callService(configJson);
				//alert(json["facilitycode"]);
				$('#patfmapensioner').change(function() {
					//   alert("1111");

					if ($('#patfmapensioner').val() == "") {
						$('#patfmafacilitypensioner').html("<option value=''>Select Facility</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getfacilitybasedonfma",
						comboId: "patfmafacilitypensioner",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select Facility" },
						primaryKeys: [$('#patfmapensioner').val()],
					}
					callService(configJson);
				});

				var configJson = {
					serviceName: "/getData/getmainorgtype",
					comboId: "patdepartmentP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["orgid"], "optionText": "Select OrganisationType" }

				}
				callService(configJson);


				$('#patdepartmentP').change(function() {

					if ($('#patdepartmentP').val() == "") {
						$('#patsubdepartmentP').html("<option value=''>Select Organisation Name</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getOrganisationnamewithddo",
						comboId: "patsubdepartmentP",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select Organisation name" },
						primaryKeys: [$('#patdepartmentP').val()],
					}
					callService(configJson);
				});
				var configJson = {
					serviceName: "/getData/getOrganisationnamewithddo",
					comboId: "patsubdepartmentP",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["ddocode"], "optionText": "Select District" },
					primaryKeys: [json["orgid"]],
				}
				callService(configJson);



				var configJson = {
					serviceName: "/getData/getfmalistfacility",
					comboId: "patfmafacilitypensioner",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["facilitycode"], "optionText": "Select FMA facility" }
				}
				callService(configJson);

				$("#patcardvalidtoP").datepicker({
					minDate: new Date,
					//maxDate: maximumDate,    
					"dateFormat": "dd-M-yy",
					changeMonth: true, changeYear: true, showButtonPanel: true, showOtherMonths: true,
					selectOtherMonths: true,
					//yearRange: "-0:+100",
					onSelect: function(date, datepicker) {
						//var id= $(datepicker).attr("id");
						//$('#'+id).trigger('blur');

					}
				});
				$('#BTNPayment').show();

			} else {

				//	alert("serving");

				$('#cardtypevaluehidden').val("S");
				$('#servingdept').show();
				$('#pensionerdept').hide();
				$('#PatCardtypeS').val(json["gstr_cardtype_name"]);
				$('#patcardvalidto').val(json["validupto"]);
				//  $('#PatCardtypeS').val(json["cardtype"]);
				//  alert(json["officeaddress"]);
				$("#patofcadrserving").val(json["officeaddress"]);

				//  alert("categoryiiidddddd"+json["cardcategoryid"]);
				var configJson = {
					serviceName: "/getData/getmaincardcategory",
					comboId: "patcardcategoryserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["cardcategoryid"], "optionText": "Select CardCategory" },
					primaryKeys: [$('#cardtypevaluehidden').val()],

				}
				callService(configJson);

				$('#patcardcategoryserving').change(function() {

					if ($('#patcardcategoryserving').val() == "") {
						$('#patsubcardtypeserving').html("<option value=''>Select SubCategory</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getCardTypeList",
						comboId: "patsubcardtypeserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select SubCategory" },
						primaryKeys: [$('#patcardcategoryserving').val()],
					}
					callService(configJson);


				});
				//  alert("subcategory>>>>>>>>>>"+json["subcategoryid"]);
				var configJson = {
					serviceName: "/getData/getCardTypeList",
					comboId: "patsubcardtypeserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["subcategoryid"], "optionText": "Select SubCategory" },
					primaryKeys: [json["cardcategoryid"]],
				}
				callService(configJson);

	//alert("cardtypevaluecategory>>>>>>>>>>"+cardtypevaluecategory);
	var configJson = {
			serviceName: "/getData/getstatelistbasedonCardType",
			comboId: "stateCode",
			callBackFunctionName: "commonPopulateCombo",
			defaultOption: { "optionValue": json["stateCode"], "optionText": "Select State" },
			primaryKeys: [cardtypevaluecategory],
		}
		callService(configJson);

		$('#stateCode').change(function() {

			if ($('#stateCode').val() == "") {
				$('#districtCode').html("<option value=''>Select District</option>");
				return;
			}
		
			var configJson = {
				serviceName: "/getData/getDistrictList",
				comboId: "districtCode",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue": "", "optionText": "Select District" },
				primaryKeys: [$('#stateCode').val(), cardtypevaluecategory],
			}
			callService(configJson);
		});
		
		var configJson = {
				serviceName: "/getData/getDistrictList",
				comboId: "districtCode",
				callBackFunctionName: "commonPopulateCombo",
				defaultOption: { "optionValue":json["distCode"] , "optionText": "Select District" },
				primaryKeys: [json["stateCode"], cardtypevaluecategory],
			}
			callService(configJson);
		
				var configJson = {
					serviceName: "/getData/getpayscale",
					comboId: "patpayscaleserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["gnum_pay_scales"], "optionText": "Select Payscale" }

				}
				callService(configJson);



				var configJson = {
					serviceName: "/getData/getpayscalevaluesDept",
					comboId: "patpayscalevalueserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["payscalevalue"], "optionText": "Select values" },

				}
				callService(configJson);

				var configJson = {

					serviceName: "/getData/getbasicpaylevelBasedonvalueDept",
					comboId: "patBasicpayserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["basicpay"], "optionText": "Select BasicPay" },

				}
				callService(configJson);

				var configJson = {
					serviceName: "/getData/getEntitlementbasedonbasicpayDept",
					comboId: "patentitlementserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": json["entitlement"], "optionText": "Select Payscale" },

				}
				callService(configJson);


				$('#patpayscaleserving').change(function() {

					if ($('#patpayscaleserving').val() == "") {
						$('#patpayscalevalueserving').html("<option value=''>Select values</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getpayscalevalues",
						comboId: "patpayscalevalueserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select values" },
						primaryKeys: [$('#patpayscaleserving').val()],
					}
					callService(configJson);


				});


				$('#patpayscalevalueserving').change(function() {


					var salary = $("#patpayscalevalueserving option:selected").text();


					var basiclevel = validateSalary(salary);


					var configJson = {

						serviceName: "/getData/getbasicpaylevelBasedonvalue",
						comboId: "patBasicpayserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select BasicPay" },
						primaryKeys: [basiclevel],
					}
					callService(configJson);


				});




				$('#patBasicpayserving').change(function() {

					if ($('#patBasicpayserving').val() == "") {
						$('#patentitlementserving').html("<option value=''>Select Payscale</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getEntitlementbasedonbasicpay",
						comboId: "patentitlementserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select Payscale" },
						primaryKeys: [$('#patBasicpayserving').val()],
					}
					callService(configJson);
				});

				var configJson = {
					serviceName: "/getData/getpayscale",
					comboId: "patpayscaleserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": "", "optionText": "Select Payscale" }

				}
				callService(configJson);


				$('#patpayscaleserving').change(function() {

					if ($('#patpayscaleserving').val() == "") {
						$('#patpayscalevalueserving').html("<option value=''>Select values</option>");
						return;
					}
					var configJson = {
						serviceName: "/getData/getpayscalevalues",
						comboId: "patpayscalevalueserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select values" },
						primaryKeys: [$('#patpayscaleserving').val()],
					}
					callService(configJson);


				});


				$('#patpayscalevalueserving').change(function() {


					var salary = $("#patpayscalevalueserving option:selected").text();


					var basiclevel = validateSalary(salary);


					var configJson = {

						serviceName: "/getData/getbasicpaylevelBasedonvalue",
						comboId: "patBasicpayserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select BasicPay" },
						primaryKeys: [basiclevel],
					}
					callService(configJson);


				});


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
				});*/


				/*var configJson={
							serviceName:"/getData/getOrganisationnamewithddo",
							comboId:"patsubdeptserving",			
							callBackFunctionName:"commonPopulateCombo",
							defaultOption:{"optionValue":json["ddocode"],"optionText":"Select District"},
							  primaryKeys:[json["orgid"]],
						}
					callService(configJson);*/


				var configJson = {
					serviceName: "/getData/getOrganisationnamewithddo",
					comboId: "patsubdeptserving",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": "", "optionText": "Select Organisation name" },

				}
				callService(configJson);

				$('#patsubdeptserving').change(function() {

					if ($('#patsubdeptserving').val() == "") {
						$('#patdeptserving').html("<option value=''>Select Organisation Name</option>");
						return;
					}
					// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
					var input = $('#patsubdeptserving').val()

					const parts = input.split('$');

					const orgtypeid = parts[0]; // "16"
					const ddocode = parts[1]; // "122"

					//alert(orgtypeid); // Outputs: 16
					//alert(ddocode); // Outputs: 12
					var configJson = {
						serviceName: "/getData/getmainorgtype",
						comboId: "patdeptserving",
						callBackFunctionName: "commonPopulateCombo",
						defaultOption: { "optionValue": "", "optionText": "Select Organisation name" },
						primaryKeys: [orgtypeid],
					}
					callService(configJson);
				});


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

				$("#PatRetirmentDate").datepicker({
					minDate: new Date,
					//maxDate: maximumDate,    
					"dateFormat": "dd-M-yy",
					changeMonth: true, changeYear: true, showButtonPanel: true, showOtherMonths: true,
					selectOtherMonths: true,
					//yearRange: "-0:+100",
					onSelect: function(dateText) {
						// Get selected retirement date as Date object
						var selectedDate = $(this).datepicker('getDate');

						// Calculate current date + 5 years
						var currentDate = new Date();
						var formattedDateObj = new Date(currentDate);
						formattedDateObj.setFullYear(formattedDateObj.getFullYear() + 5);

						// Function to format Date to dd-Mon-yyyy
						function formatDate(date) {
							var day = ("0" + date.getDate()).slice(-2);
							var monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
								"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
							var month = monthNames[date.getMonth()];
							var year = date.getFullYear();
							return day + "-" + month + "-" + year;
						}

						var formattedDate = formatDate(formattedDateObj);
						var selectedDateFormatted = formatDate(selectedDate);

						// Compare dates
						if (selectedDate < formattedDateObj) {
							// selectedDate less than 5 years from now
							$('#patcardvalidto').val(selectedDateFormatted);
						} else {
							// selectedDate is greater or equal to 5 years from now
							$('#patcardvalidto').val(formattedDate);
						}
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
	else {
		showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
		return;
	}





}



/*   function populatefamilymembers(configJson, dataJson) {
	//   alert("populatefamilymembers");
	   
	   alert("hdhdghdghd");
	if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
		// $('#applyplastccard').show();
	  showAlertMsg("No Data Found", "danger", "alertMsg");

	} else {
		let indx = 1;
		$("#AutoNumber1 tbody").empty();

		if (dataJson["message"].indexOf("ERROR") < 0) {
			$.each(dataJson["data"], function(_, json) {
				
				var benid=json["memberid"];
			//	alert("benid>>>>>>>>>>>>>"+benid);
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
			  // html += "<td>" + json["gstr_hospital_name"] + "</td>";
			   // html += "<td>" + json["gstr_cardtype_name"] + "</td>";
				html += "<td>" + json["validupto"] + "</td>";
				 html += "<td>" + flag + "</td>";	
			    
			   // We call getFileFromFileName asynchronously
				  getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {                   // alert("result>>>>>>>>>>>>>>>>>>>>>"+result); // Check the raw result
					if (result) {
						var cleanedBase64 = result.replace(/\s/g, '');  // Removes any spaces or newlines
						var base64Image = "data:image/jpeg;base64," + cleanedBase64;

						// Check if base64 string is valid
					   // alert("base64Image: " + base64Image);
						console.log("base64Imagessss: ", base64Image);

						// Add the base64 string as an image tag inside a table cell
						html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";



						// Add the button after the image

					} else {
						// Handle the error when result is not valid
						html += "<td>No image available</td>";
			  
					}
					
					
					 });

			  if (flag==="DeActive") {
				html += "<td></td>"; // If Relation is "Self" or flag is 2, leave the <td> empty
			} else {
			html += "<td><a class='btn btn-his-sm' onclick='Downloadcard(\"" + json["memberid"] + "\")'>Download</a></td>";
				// If the condition is not met, add the button with the onclick event
			}
				   
			// commented edit button
				if (json["Relation"] === "Self") {
						html += "<td></td>"; // If Relation is "Self" or flag is DeActive, leave the <td> empty
					} else {
						html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["memberid"] + "\", \"" + json["relationid"] + "\", this)'>Edit</a></td>";
					}
					html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
					  $("#AutoNumber1 tbody").append(html);
					$("#AutoNumber1").show();
				    
							   // Update the serial numbers (slno)
	var index = 1;
	$('.slno').each(function() {
		$(this).text(index);
		index++;
   });
				    
			   

			    
			});
		} else {
			showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
			return;
		}
	}
} */

function uploadPhoto() {


	document.getElementById(ctInputFileNameId).addEventListener('change', function(event) {
		const file = event.target.files[0];

		// Check if file exists and validate its size (10 KB = 10240 bytes)
		if (file && file.size <= 50000) {
			const reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById(ctPreviewId).src = e.target.result;
				document.getElementById(ctPreviewHiddenId).value = e.target.result;

				document.getElementById(ctPreviewId).style.display = 'block';
				document.getElementById('video').style.display = 'none';
				document.getElementById('capture').style.display = 'none';
				document.getElementById('canvas').style.display = 'none';
				hidePopup();
			};
			reader.readAsDataURL(file);

			$("#mainPhotoIdFeedBack").html(""); // Clear any previous error message


			hidePopup();
		} else {
			// Show error message if file is too large
			$("#mainPhotoIdFeedBack").html("Please upload a photo smaller than 50 KB.");

			document.getElementById(ctPreviewId).style.display = 'none';
			document.getElementById('video').style.display = 'none';
			document.getElementById('capture').style.display = 'none';
			document.getElementById('canvas').style.display = 'none';
		}
	});

	document.getElementById(ctInputFileNameId).click();
}


function capturePhoto() {


	if (navigator.mediaDevices && navigator.mediaDevices.getUserMedia) {
		// Access the camera
		navigator.mediaDevices.getUserMedia({ video: true })
			.then(function(stream) {

				video.srcObject = stream;
				video.play();
				video.style.display = 'block';
				document.getElementById('capture').style.display = 'block';
			})
			.catch(function(err) {
				console.log("An error occurred: " + err);
				alert("Camera Permission Denied at Browser, Please Enable or Try to Upload Photo");
			});


	} else {
		alert("Camera Not Available; Please Try to Upload Photo");
	}

}


function captureActualPhoto(event) {

	const context = canvas.getContext('2d');
	context.drawImage(video, 0, 0, 320, 240);
	const dataUrl = canvas.toDataURL('image/png');
	document.getElementById(ctPreviewId).src = dataUrl;
	document.getElementById(ctPreviewHiddenId).value = dataUrl;

	document.getElementById(ctPreviewId).style.display = 'block';
	document.getElementById('video').style.display = 'none';
	document.getElementById('capture').style.display = 'none';
	document.getElementById('canvas').style.display = 'none';
	stopVideoOnly(document.getElementById('video').srcObject);

	$("#mainPhotoIdFeedBack").html("");

	hidePopup();

}




function Upload(memberid, hiddenFileSelector, dispshortname) {

	var userid = $('#seatId').val()


	var base64String = $(hiddenFileSelector).val();
	var benIdvalue = memberid;
	//  alert("dispshortname>>>>>>>>>"+dispshortname);

	// alert("benIdvalue>>>>>>>>>"+benIdvalue);
	//  alert("userid>>>>>>>>>"+userid);
	// Check if Base64 string is valid (non-empty)
	if (!base64String || base64String.trim() === '') {
		alert("No image data found!");
		return;
	}

	// Prepare the request data object
	var requestData = {
		"Base64imagefile": base64String,
		"benid": benIdvalue,
		"useridvalue": userid,
		"dispshortname": dispshortname
	};

	// Send the AJAX request
	/*$.ajax({
		url: 'services/restful/cardapi/v1/BenDetails/getconvertimageBase64tofile',  // URL of your REST service
		type: 'POST',
		contentType: 'application/json',
		data: JSON.stringify(requestData),  // Send the request data as JSON
		success: function(response) {
			// Handle the success response from the server
			if (response.status === 'success') {
				alert("Image uploaded successfully! File path: " + response.filePath);
				// getfamilydetails();
			} else {
				alert("Error: " + response.message);  // Show error message from server response
			}
		},
		error: function(xhr, status, error) {
			// Handle the error (in case the AJAX request fails)
			console.log("AJAX Error: " + status + " " + error);
			alert("An error occurred while uploading the image.");
		}
	});*/
}

function populatefamilymembers(configJson, dataJson) {
	//alert("populatefamilymembers");

	if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
		showAlertMsg("No Data Found", "danger", "alertMsg");
	} else {
		let indx = 1;
		$("#AutoNumber1 tbody").empty();

		if (dataJson["message"].indexOf("ERROR") < 0) {
			$.each(dataJson["data"], function(_, json) {
				var benid = json["memberid"];
				var flag = json["flag"];
				let selfRow = null;

				if (flag == 1) {
					flag = "Active";
				} else {
					flag = "DeActive";
				}

				let html = "<tr>";
				html += "<td class='slno'>" + indx + "</td>";
				html += "<td>" + json["memberid"] + "</td>";
				html += "<td>" + json["memberName"] + "</td>";
				html += "<td>" + json["Dob"] + "</td>";
				// html += "<td>" + json["Relation"] + "</td>";
				//html = html + "<input type='hidden' name='member_" + json["memberid"] + "' value='" + json["relationid"] + "'>";
				html += "<td>" + json["Relation"] +
					"<input type='hidden' class='relation-id' value='" + json["relationid"] + "' name='member_" + json["memberid"] + "'>" +
					"</td>";
				html += "<td>" + json["gender"] + "</td>";
				html += "<td>" + json["validupto"] + "</td>";
				html += "<td>" + flag + "</td>";

				getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {
					if (result) {
						var cleanedBase64 = result.replace(/\s/g, '');
						var base64Image = "data:image/jpeg;base64," + cleanedBase64;

						html += "<td><img src='" + base64Image + "' alt='Image' width='50' height='50'></td>";
						//html += "<td><input type='checkbox' name='isRenewalRequired' value='" + json["memberid"] + "'></td>";

						html += "<td>" +
							"<input type='hidden' name='isRenewalRequired_" + json["memberid"] + "' value='0'>" +
							"<input type='checkbox' name='isRenewalRequired_" + json["memberid"] + "' value='1'>" +
							"</td>";



					} else {
						html += "<td>No image available</td>";
						//html += "<td><input type='checkbox' name='isRenewalRequired' value='" + json["memberid"] + "'></td>";
						html += "<td>" +
							"<input type='hidden' name='isRenewalRequired_" + json["memberid"] + "' value='0'>" +
							"<input type='checkbox' name='isRenewalRequired_" + json["memberid"] + "' value='1'>" +
							"</td>";

					}


					/*
					if (flag==="DeActive") {
						html += "<td></td>";
					} else {
						html += "<td><a class='btn btn-his-sm' onclick='Downloadcard(\"" + json["memberid"] + "\")'>Download</a></td>";
					}
					*/

					/*
					if (json["Relation"] === "Self") {
						html += "<td></td>";
					} else {
						html += "<td><a class='btn btn-his-sm' onclick='Edit(\"" + json["memberid"] + "\", \"" + json["relationid"] + "\", this)'>Edit</a></td>";
					}
					*/
					html = html + "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"showPopup('fileInput', 'preview" + json["memberid"] + "', 'hiddenFile" + json["memberid"] + "')\">Choose Photo</a></td>";
					html = html + "<td><img id='preview" + json["memberid"] + "' src='#' alt='Preview" + json["memberid"] + "' style='display:none;width:70px;' /> <input type='hidden' id='hiddenFile" + json["memberid"] + "' /> </td>";
					html = html + "<td><a href='javascript:void(0);' class='btn btn-primary' onclick=\"Upload('" + json["memberid"] + "', '#hiddenFile" + json["memberid"] + "', '" + json["gstr_hosp_short_name"] + "')\">Upload Photo</a></td>";


					html += "<input type='hidden' name='dependentJson' value='" + JSON.stringify(json) + "'>";
					html += "</tr>"; // close the row after everything

					$("#AutoNumber1 tbody").append(html);
					$("#AutoNumber1").show();

					// Update serial numbers
					var index = 1;
					$('.slno').each(function() {
						$(this).text(index);
						index++;
					});
				});

				indx++; // increase index inside main loop to keep track
			});
		} else {
			showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
			return;
		}
	}
}

function Previewform() {
	//  alert("inside preview form method");

	if ($('#stateCode').val() === "") {
			alert("Please select State.");
			return false;  // stop further processing
		}
		if ($('#districtCode').val() === "") {
				alert("Please select District.");
				return false;  // stop further processing
			}
			if ($('#patpincodeserving').val() === "") {
							alert("Please select Pin Code.");
							return false;  // stop further processing
						}
						
						//alert("pin code---"+$('#patpincodeserving').val());
	if ($('#filename19').val() === "") {
		alert("Please select Address Proof.");
		return false;  // stop further processing
	}
	if ($('#filename20').val() === "") {
		alert("Please select Recent Salary Slip.");
		return false;  // stop further processing
	}

	if ($('#patsubdeptserving').val() === "") {
		alert("Please select Organization Name (DDO Code).");
		return false;  // stop further processing
	}

	/*if ($('#patdeptserving').val() === "") {
		alert("Please select Organization Name.");
		return false;  // stop further processing
	}*/
	if ($('#patpayscaleserving').val() === "") {
		alert("Please select Pay Level.");
		return false;  // stop further processing
	}
	if ($('#patpayscalevalueserving').val() === "") {
		alert("Please select Basic Pay.");
		return false;  // stop further processing
	}
	if ($('#patBasicpayserving').val() === "") {
		alert("Please select Basic Pay Level.");
		return false;  // stop further processing
	}
	if ($('#PatRetirmentDate').val() === "") {
			alert("Please select Date Of Retirement.");
			return false;  // stop further processing
		}
	// Extract hidden or system values
	var isGlobal = ($('#isGlobal').val() || '0');
	var ticket = $('#varSSOTicketGrantingTicket').val() || "";

	// Personal Info
	const patname = $('#patName').val();
	const patnameh = $('#patNameHindi').val();
	const patDOB = $('#patDOB').val();
	const patGender = $('#patGender option:selected').text();
	//alert("patGender>>>"+patGender);
	const patGenderValue = $('#patGender').val();
	//alert("patGenderValue>>>"+patGenderValue);
	const patEmail = $('#patEmail').val();
	const patMobile = $('#patMobileNo').val();
	const patresaddress = $('#patresaddress').val();
	const patrelation = $('#patrelation   option:selected').text();
	const patrelationValue = $('#patrelation').val();
	const PatientCghsCity = $('#PatientCghsCity').val();
	const PatientCghsCityValue = $('#PatientCghsCity option:selected').text();
	const patadcity = $('#patadcity').val();
	const patadcityValue = $('#parentcitycodehidden').val();
	const patpincode = $('#patpincodeserving').val();
	//alert("pin code var---"+patpincode);

	//alert("patadcityValue>>>>"+patadcityValue);
	const patientwc = $('#patientwc  option:selected').text();
	const patientwcValue = $('#patientwc').val();

	// Basic Serving Dept Info
	const PatCardtypeS = $('#PatCardtypeS').val();
	const patcardcategoryserving = $('#patcardcategoryserving option:selected').text();
	const patcardcategoryservingValue = $('#patcardcategoryserving ').val();
	const patsubcardtypeserving = $('#patsubcardtypeserving option:selected').text();
	const patsubcardtypeservingValue = $('#patsubcardtypeserving').val();
	const patdeptserving = $('#patdeptserving option:selected').text();
	const patdeptservingValue = $('#patdeptserving').val();  //Organization Name
	const patsubdeptserving = $('#patsubdeptserving option:selected').text();
	const patsubdeptservingValue = $('#patsubdeptserving').val();  //Organization Name(DDO Code):
	const patofcadrserving = $('#patofcadrserving').val();
	const patpayscaleserving = $('#patpayscaleserving option:selected').text();
	const patpayscaleservingValue = $('#patpayscaleserving').val();
	const patpayscalevalueserving = $('#patpayscalevalueserving option:selected').text();

	//alert("Basic Pay Value----"+$('#patpayscalevalueserving').val());
	const patpayscalevalueservingValue = $('#patpayscalevalueserving').val();
	const patBasicpayserving = $('#patBasicpayserving option:selected').text();
	const patBasicpayservingValue = $('#patBasicpayserving').val();
	const patentitlementserving = $('#patentitlementserving option:selected').text();
	const patentitlementservingValue = $('#patentitlementserving').val();
	const patcardvalidto = $('#patcardvalidto').val();
	const stateCode = $('#stateCode').val();
	//alert("stateCode---"+stateCode);
	const districtCode = $('#districtCode').val();
	//alert("districtCode---"+districtCode);
	const statecodeshow = $('#stateCode option:selected').text();
	//alert("statecodeshow---"+statecodeshow);
	const districtCodeshow = $('#districtCode option:selected').text();
	const PatRetirmentDate = $('#PatRetirmentDate').val();
	//alert("Patdorpensioner---"+Patdorpensioner);

	var pataddressproof = $("#filename19").val();
	var patsalaryproof = $("#filename20").val();
	//alert("addresss----"+pataddressproof);
	//alert("salary----"+patsalaryproof);
	// Set personal info preview   
	$("#prevw_name").text(patname);
	$("#prevw_nameh").text(patnameh);
	$("#prevw_dob").text(patDOB);
	$("#prevw_gender").text(patGender);
	$("#prevw_mob").text(patMobile);
	$("#prevw_mail").text(patEmail);
	$("#prevw_addr").text(patresaddress); // use .html() if multiline needed
	$("#prevw_relation").text(patrelation);
	$("#prevw_cghs_city").text(PatientCghsCityValue);
	$("#prevw_ad_city").text(patadcity);

	$("#prevw_wc").text(patientwc);
	$("#prevw_state").text(statecodeshow);
	$("#prevw_district").text(districtCodeshow);
	$("#prevw_pin").text(patpincode);
	$("#prevw_dor").text(PatRetirmentDate);

	//set all hidden personal values


	$("#hiddenPatName").val(patname);
	$("#hiddenpatNameHindi").val(patnameh);
	$("#hiddenpatDOB").val(patDOB);
	$("#hiddenpatGender").val(patGenderValue);
	//	alert("hidden gender val>>>>"+patGenderValue);
	$("#hiddenpatMobile").val(patMobile);
	$("#hiddenpatEmail").val(patEmail);
	$("#hiddenpatresaddress").val(patresaddress);
	$("#hiddenpatrelation").val(patrelationValue);
	$("#hiddenPatientCghsCity").val(PatientCghsCity);
	$("#hiddenpatadcity").val(patadcityValue);
	$("#hiddenpatientwc").val(patientwcValue);
	$('#cardtypevaluehidden').val("S");
	$('#hiddenpataddressproof').val(pataddressproof);
	$('#hiddenpatsalaryproof').val(patsalaryproof);
	$('#hiddenpatstateCode').val(stateCode);
	$('#hiddenpatdistrictCode').val(districtCode);
	$('#hiddenpatpincodeserving').val(patpincode);
	//alert("pin code var hideev---"+$('#hiddenpatpincodeserving').val());
	$('#hiddenPatRetirmentDate').val(PatRetirmentDate);



	// Set serving dept info preview
	$("#prevw_card_type").text(PatCardtypeS);
	$("#prevw_card_cat").text(patcardcategoryserving);
	$("#prevw_card_subcat").text(patsubcardtypeserving);
	$("#prevw_org_name").text(patdeptserving);
	$("#prevw_org_ddo").text(patsubdeptserving);
	$("#prevw_org_ofc_addr").text(patofcadrserving);
	$("#prevw_pay").text(patpayscaleserving);
	$("#prevw_basic_pay").text(patpayscalevalueserving);
	$("#prevw_basic_pay_lvl").text(patBasicpayserving);
	$("#prevw_entitlement").text(patentitlementserving);
	$("#prevw_card_validto").text(patcardvalidto);
	//alert("ddao code---"+patsubdeptservingValue);
	//$("#hiddenpatsubdeptserving").val(patsubdeptservingValue);
	//alert("org name---"+patdeptservingValue);
	//$("#hiddenpatdeptserving").val(patdeptservingValue);




	//set all departmen values in hiddden 
	$("#hiddenPatCardtypeS").val(PatCardtypeS);
	$("#hiddenpatcardcategoryserving").val(patcardcategoryservingValue);
	$("#hiddenpatsubcardtypeserving").val(patsubcardtypeservingValue);
	$("#hiddenpatdeptserving").val(patdeptservingValue);
	$("#hiddenpatsubdeptserving").val(patsubdeptservingValue);
	$("#hiddenpatofcadrserving").val(patofcadrserving);
	$("#hiddenpatpayscaleserving").val(patpayscaleservingValue);
	$("#hiddenpatpayscalevalueserving").val(patpayscalevalueservingValue);
	$("#hiddenpatBasicpayserving").val(patBasicpayservingValue);
	$("#hiddenpatentitlementserving").val(patentitlementservingValue);
	$("#hiddenpatcardvalidto").val(patcardvalidto);


	// Create an empty array to store the dependent data
	//let dependentArray = [];

	// Clear previous data in the preview table
	$("#AutoNumber2 tbody").empty();

	// Loop through each row in the original table and copy data to preview
	$("#AutoNumber1 tbody tr").each(function() {
		let $row = $(this);

		const slno = $row.find("td:eq(0)").text();
		const benId = $row.find("td:eq(1)").text();
		const name = $row.find("td:eq(2)").text();
		const dob = $row.find("td:eq(3)").text();
		const relation = $row.find("td:eq(4)").text().trim();
		const gender = $row.find("td:eq(5)").text();
		const validUpto = $row.find("td:eq(6)").text();
		const relationId = $row.find("td:eq(4) input.relation-id").val();

		//alert("relationId>>"+relationId);
		// Image


		let uploadedImg = $row.find("td:eq(11)").find("img").attr("src");
		//alert("Uploaded Image from Column 12: " + uploadedImg);
		if (!uploadedImg || uploadedImg.trim() === "" || uploadedImg.trim() === "#") {  //alert('inside 8 th column selection');

			uploadedImg = $row.find("td:eq(8)").find("img").attr("src");
			//alert("Uploaded Image from Column 8: " + uploadedImg);
		}

		const imgHtml = uploadedImg && uploadedImg.trim() !== ""
			? "<img src='" + uploadedImg + "' width='50' height='50'/>"
			: "No Image";


		// Checkbox
		const checkbox = $row.find("input[type='checkbox']");
		const isRenewal = checkbox.is(":checked") ? "Yes" : "No";
		const isRenewalValue = checkbox.is(":checked") ? 1 : 0;

		// Append to preview table
		if (isRenewal === "Yes") {
			let newRow = "<tr>";
			newRow += "<td>" + slno + "</td>";
			newRow += "<td>" + benId + "</td>";
			newRow += "<td>" + name + "</td>";
			newRow += "<td>" + dob + "</td>";
			newRow += "<td>" + relation + "</td>";
			newRow += "<td>" + gender + "</td>";
			newRow += "<td>" + validUpto + "</td>";
			newRow += "<td>" + imgHtml + "</td>";
			newRow += "<td>" + isRenewal + "</td>";
			newRow += "</tr>";

			$("#AutoNumber2 tbody").append(newRow);
		}
		
		
		var formhtml=encryptBase64($('#onlineplasticformhtmlservingdeptonline').html() );
			   $('#onlineapplicationhidden').val(formhtml);

	//	alert('encrypted form----'+$('#onlineapplicationhidden').val());

		// Push the data into the dependentArray
		//alert("final validity ---"+patcardvalidto);
		
		if (isRenewal === "Yes"){
			
			dependentArray.push({
						//   slno: slno,
						benId: benId,
						name: name,
						dob: dob,
						relation: relation,
						relationId: relationId,
						gender: gender,
						//validUpto: validUpto,
						validUpto: patcardvalidto,
						uploadedImg: uploadedImg,
						isRenewal: isRenewalValue,

					});
			
		}
		
	});

	// Set header name
	$("#mainchnameformdepon").text(patname);

	// Show modal
	$('#myModalcghsformservingdeptonline').modal('show');

	//console.log("Dependent Data Array:", dependentArray);
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

function populatecity(configJson, dataJson) {
	//alert("configJson>>> " + JSON.stringify(configJson));



	if (!dataJson || !dataJson.data || dataJson.data.length === 0) {

	}
	else {
		// checking if error exists
		if (dataJson["message"].indexOf("ERROR") < 0) {
			$.each(dataJson["data"], function(_, json) {
				//alert("parentcitycode>>"+json["parentcitycode"]); 
				//alert("parentcityname>>"+json["parentcityname"]);

				var parentcitycodevalue = json["parentcitycode"];
				$('#parentcitycode').val(parentcitycodevalue);

				var parentcityname = json["parentcityname"];

				$('#patadcity').val(parentcityname);
				//$('#patadcityhidden').val(parentcitycodevalue); 


				var configJson = {
					serviceName: "/getData/getwellnesscenterbasedoncity",
					comboId: "patientwc",
					callBackFunctionName: "commonPopulateCombo",
					defaultOption: { "optionValue": "", "optionText": "Select Wellness center" },
					primaryKeys: [parentcitycodevalue],
				}
				callService(configJson);


			});




		}
		else {
			showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
			return;
		}
	}
}


function saveData1() {
	//alert("4444444444");
	if (ValidateForAllVisible("ENTRYFORM") === false) {
		return;
	}


	var configJson = {
		serviceName: "/DMLSAVE/UpdateBenDetails",
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


function callbackSaveData1(configJson, dataJson) {

	//alert(JSON.stringify(configJson));
	if (dataJson["message"].indexOf("ERROR") >= 0) {
		showMsg(dataJson["message"], null)
	}
	else {
		var dialogConfigJson = { callOnOK: "resetPage1", "parameterJson": {} }

		showMsg(dataJson["message"], dialogConfigJson)
	}
}


function getFileFromFileName(fileName, hospname, callback) {
	//alert("getFileFromFileName"+fileName);
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
function Edit(memberid, relationid, button) {
	// Show the dependent info section
	$('#divDependentInfo').show();
	$('#divDependentAddInfo').hide();

	//  alert("relationiddddd>>>"+relationid);
	// Store the current row being edited (using the button that triggered the event)
	var currentRow = button.closest("tr");

	// Get the table cells from the current row
	var cells = currentRow.querySelectorAll("td");

	// Retrieve values from the row
	var memberId = cells[1].innerText;  // Assuming memberid is in the second column
	var memberName = cells[2].innerText; // Assuming member name is in the third column
	var dob = cells[3].innerText;       // Assuming Dob is in the fourth column
	var relation = cells[4].innerText;  // Assuming Relation is in the fifth column
	//alert("relation value" + relation);
	var gender = cells[5].innerText;    // Assuming Gender is in the sixth column
	var validUpto = cells[6].innerText; // Assuming validupto is in the seventh column

	$("#NewdepBenid").val(memberid);
	$('#Newdepname').val(memberName);
	$('#NewdepDOB').val(dob);

	$('#Newdeptrelation').val(relation);   // Populate Relation dropdown
	$('#Newdepgender').val(gender);       // Populate Gender dropdown
	$('#NewdepvalidUpto').val(validUpto); // Populate Valid Upto field
	// Populate Flag field


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
		//   flag: flag
	};

	// Now, you can use this jsonObject in the form to update the dependent details
	// Populate Relation dropdown

	//alert("in edit" + jsonObject.relationid);
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
	//document.getElementById("editPhoto").src = jsonObject.dependentPhoto || ''; // Ensure the field exists or is null

}



function showPopup(inputFileNameId, previewId, previewHiddenId) {
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


function SaveChanges() {

	//	alert("Executing SaveChanges");
	
//	alert("formhtml base 64---"+$('#onlineapplicationhidden').val());
	

	var personalInfo = {
		mainPatName: $('#hiddenPatName').val(),
		mainPatNameh: $('#hiddenpatNameHindi').val(),
		mainPatDOB: $('#hiddenpatDOB').val(),
		mainPatGender: $('#hiddenpatGender').val(),
		mainPatMob: $('#hiddenpatMobile').val(),
		mainPatmail: $('#hiddenpatEmail').val(),
		mainPataddrs: $('#hiddenpatresaddress').val(),
		mainPatreltn: $('#hiddenpatrelation').val(),
		mainPatcity: $('#hiddenPatientCghsCity').val(),
		mainPatadcity: $('#hiddenpatadcity').val(),
		mainPatwc: $('#hiddenpatientwc').val(),
		cardtypevaluehidden: $('#cardtypevaluehidden').val(),
		pataddressproof: $('#hiddenpataddressproof').val(),
		patsalaryproof: $('#hiddenpatsalaryproof').val(),
		stateCode: $('#hiddenpatstateCode').val(),
		districtCode: $('#hiddenpatdistrictCode').val(),
		pinCode: $('#hiddenpatpincodeserving').val(),
		formhtml: $('#onlineapplicationhidden').val(),
		
		
	};


	let val = $('#hiddenpatsubdeptserving').val();  // "D$87"
	let numberOnly = val.replace(/\D/g, '');       // Removes all non-digit characters

	// Department Info
	var deptInfo = {
		mainPatCrdType: $('#hiddenPatCardtypeS').val(),
		mainPatCrdCat: $('#hiddenpatcardcategoryserving').val(),
		mainPatSubCrdCat: $('#hiddenpatsubcardtypeserving').val(),
		mainPatDept: $('#hiddenpatdeptserving').val(),
		//mainSubPatDept: $('#hiddenpatsubdeptserving').val(),
		mainSubPatDept: numberOnly,
		mainPatOfcAdr: $('#hiddenpatofcadrserving').val(),
		mainPatPayScle: $('#hiddenpatpayscaleserving').val(),  //pay level  
		mainPatBasicPay: $('#hiddenpatpayscalevalueserving').val(),// basic pay
		mainPatBasicPayLvl: $('#hiddenpatBasicpayserving').val(),//basic pay level
		mainPatWard: $('#hiddenpatentitlementserving').val(),//entitlement
		mainPatDor: $('#hiddenPatRetirmentDate').val(),//entitlement
		mainPatCardValid: $('#hiddenpatcardvalidto').val()//valid upto
	};




	// Final JSON
	var finalJson = {
		PersonalInfo: personalInfo,
		DeptInfo: deptInfo,
		DependentInfo: dependentArray
	};

	// Log the final JSON structure for debugging
	console.log("Sending JSON to server:", finalJson);
	showPreloader("Saving Data Please Wait !");
	// Send data to the server
	var configJson = {
		serviceName: "/DMLSAVE/cardrenewal",
		callBackFunctionName: "callbackcardrenewalData",
		inputData: finalJson
	};

	callService(configJson);

}




function callbackcardrenewalData(configJson, dataJson) {
    //alert("inside callbackcardrenewalData");

    var message = dataJson["message"];
    

    if (message.indexOf("ERROR") >= 0) {
        showMsg(message, null);
    } else {
        // Extract transaction ID using regex
        var match = message.match(/Transaction ID:\s*(\d+)/);
        if (match && match[1]) {
            var transactionId = match[1];
            console.log("Extracted Transaction ID:", transactionId);

            // Set in hidden field
            $('#renewalhidden').val(transactionId);
        }

        var dialogConfigJson = {
            callOnOK: "resetPage",
            "parameterJson": {}
        };

        showMsg(message, dialogConfigJson);
    }
}

function resetPage() {
  // alert("reset page");

    var txnId = $('#renewalhidden').val();
   // alert("Transaction ID is: " + txnId);
	sessionStorage.setItem("txnId", txnId);


    $('#masterKey').val("CardRenewalStatus");
    submitFormWithResetTextField("CallMasterPage");
}




/*function SaveChanges() {  
	// Personal Info of Main Card Holder
	
	alert("main card name in SaveChanges---"+$('#hiddenPatName').val());
	var personalInfo = {
		mainPatName: $('#hiddenPatName').val(),
		mainPatNameh: $('#hiddenpatNameHindi').val(),
		mainPatDOB: $('#hiddenpatDOB').val(),
		mainPatGender: $('#hiddenpatGender').val(),
		mainPatMob: $('#hiddenpatMobile').val(),
		mainPatmail: $('#hiddenpatEmail').val(),
		mainPataddrs: $('#hiddenpatresaddress').val(),
		mainPatreltn: $('#hiddenpatrelation').val(),
		mainPatcity: $('#hiddenPatientCghsCity').val(),
		mainPatadcity: $('#hiddenpatadcity').val(),
		mainPatwc: $('#hiddenpatientwc').val(),
		//cardtypevaluehidden:$('#cardtypevaluehidden').val(),
		//mainPatImagebase64:$('#Preview').val()
	};
alert("card valid upto----"+$('#hiddenpatcardvalidto').val());
	// Department Info
	var deptInfo = {
		mainPatCrdType: $('#hiddenPatCardtypeS').val(),
		mainPatCrdCat: $('#hiddenpatcardcategoryserving').val(),
		mainPatSubCrdCat: $('#hiddenpatsubcardtypeserving').val(),
		mainPatDept: $('#hiddenpatdeptserving').val(),
		mainSubPatDept: $('#hiddenpatsubdeptserving').val(),
		mainPatOfcAdr: $('#hiddenpatofcadrserving').val(),
		mainPatPayScle: $('#hiddenpatpayscaleserving').val(),
		mainPatBasicPay: $('#hiddenpatpayscalevalueserving').val(),
		mainPatBasicPayLvl: $('#hiddenpatBasicpayserving').val(),
		mainPatWard: $('#hiddenpatentitlementserving').val(),
		mainPatCardValid: $('#hiddenpatcardvalidto').val()
	};

	// Loop through dependent table
	 var dependentList = []; 
	var table = document.querySelector("#AutoNumber1 table");

	if (!table) {
		alert("Dependent table not found!");
		return;
	}

	var rows = table.querySelectorAll("tbody tr");
	var memberId = $('#NewdepBenid').val();
	
	alert("memberId>>"+memberId);
	
	var memberName = $('#Newdepname').val();
	alert("memberName>>"+memberName);
	var depDob  = $('#NewdepDOB').val();
	alert("dob>>"+depDob);
	var depRelation  = $('#Newdeptrelation').val();
	alert("relation>>"+depRelation);
	var depGender  = $('#Newdepgender').val();
	var depValidUpto  = $('#NewdepvalidUpto').val();

	var isUpdated = false;

	rows.forEach((row, index) => {
		var rowBenId  = row.cells[1]?.innerText.trim();
		var rowName  = row.cells[2]?.innerText.trim();
		var rowDob  = row.cells[3]?.innerText.trim();
		var rowRelation  = row.cells[4]?.innerText.trim();
		var rowGender  = row.cells[5]?.innerText.trim();
		var rowValidUpto  = row.cells[6]?.innerText.trim();
		var rowBloodGroup  = row.cells[7] ? row.cells[7].innerText.trim() : null;

		// Skip empty/invalid rows
		if (!rowBenId || rowBenId === "BenID"  || rowRelation === "Self") {
			   console.log(`Skipping row ${index + 1} (benId: ${rowBenId}, relation: ${rowRelation})`);
			   return;
		   }
			let dependent;

			   if (rowBenId === memberId) {
				   // This row was edited — use latest form data
				   dependent = {
					   benId: memberId,
					   name: memberName,
					   dob: depDob,
					   relation: depRelation,
					   gender: depGender,
					   validUpto: depValidUpto,
					   //bloodGroup: row.cells[7] ? row.cells[7].innerText.trim() : null
				   };
			   } else {
				   // Keep as is from table
				   dependent = {
					   benId: rowBenId,
					   name: row.cells[2]?.innerText.trim(),
					   dob: row.cells[3]?.innerText.trim(),
					   relation: row.cells[4]?.innerText.trim(),
					   gender: row.cells[5]?.innerText.trim(),
					   validUpto: row.cells[6]?.innerText.trim()
					  // bloodGroup: row.cells[7] ? row.cells[7].innerText.trim() : null
				   };
			   }

			   //console.log("Dependent added to JSON:", dependent);
			   dependentList.push(dependent);
		   });

	if (!isUpdated) {
		alert("Dependent not found in the table!");
		return;
	} else {
		alert("Changes saved successfully!");
	}

	// Final JSON
	var finalJson = {
		PersonalInfo: personalInfo,
		DeptInfo: deptInfo,
		Dependent: dependentList
	};
	
	
	console.log("Sending JSON to server:", finalJson);

	var configJson = {
		serviceName: "/DMLSAVE/cardrenewal",
		callBackFunctionName: "callbackcardrenewalData",
		inputData: finalJson
	};

	callService(configJson);
}*/


/*function SaveChanges() {
	var fileInput = document.getElementById("editPhotoInput");
	var file = fileInput.files[0];

	if (file) {
		var reader = new FileReader();
		reader.onload = function (e) {
			var base64Image = e.target.result;
			continueSaveChanges(base64Image); // process after async completes
		};
		reader.readAsDataURL(file);
	} else {
		continueSaveChanges(null); // process immediately if no image
	}
}

function continueSaveChanges(base64Image) {
	// Personal Info
	var personalInfo = {
		mainPatName: $('#patName').val(),
		mainPatNameh: $('#patNameHindi').val(),
		mainPatDOB: $('#patDOB').val(),
		mainPatGender: $('#patGender').val(),
		mainPatMob: $('#patMobileNo').val(),
		mainPatmail: $('#patEmail').val(),
		mainPataddrs: $('#patresaddress').val(),
		mainPatreltn: $('#patrelation').val(),
		mainPatcity: $('#PatientCghsCity').val(),
		mainPatadcity: $('#patadcity').val(),
		mainPatwc: $('#patientwc').val(),
		cardtypevaluehidden: $('#cardtypevaluehidden').val()
	};

	// Department Info
	var deptInfo = {
		mainPatCrdType: $('#PatCardtypeS').val(),
		mainPatCrdCat: $('#patcardcategoryserving').val(),
		mainPatSubCrdCat: $('#patsubcardtypeserving').val(),
		mainPatOrg: $('#patdeptserving').val(),
		mainPatOfcAdr: $('#patofcadrserving').val(),
		mainPatPayScle: $('#patpayscaleserving').val(),
		mainPatBasicPay: $('#patpayscalevalueserving').val(),
		mainPatBasicPayLvl: $('#patBasicpayserving').val(),
		mainPatWard: $('#patentitlementserving').val(),
		mainPatCardValid: $('#patcardvalidto').val()
	};

	// Dependent Info
	var dependentList = [];
	var table = document.querySelector("#AutoNumber1 table");

	if (!table) {
		alert("Dependent table not found!");
		return;
	}

	var rows = table.querySelectorAll("tbody tr");
	var memberId = $('#NewdepBenid').val();
	var memberName = $('#Newdepname').val();
	var depDob = $('#NewdepDOB').val();
	var depRelation = $('#Newdeptrelation').val();
	var depGender = $('#Newdepgender').val();
	var depValidUpto = $('#NewdepvalidUpto').val();

	rows.forEach((row) => {
		var rowBenId = row.cells[1]?.innerText.trim();
		var rowRelation = row.cells[4]?.innerText.trim();

		if (!rowBenId || rowBenId === "BenID" || rowRelation === "Self") return;

		let dependent;
		if (rowBenId === memberId) {
			// This is the edited dependent — use latest values from form
			dependent = {
				benId: memberId,
				name: memberName,
				dob: depDob,
				relation: depRelation,
				gender: depGender,
				validUpto: depValidUpto
			};

			// Add base64 image if it exists
			if (base64Image) {
				dependent.photoBase64 = base64Image;
			}
		} else {
			// Other rows — just extract from table
			dependent = {
				benId: rowBenId,
				name: row.cells[2]?.innerText.trim(),
				dob: row.cells[3]?.innerText.trim(),
				relation: row.cells[4]?.innerText.trim(),
				gender: row.cells[5]?.innerText.trim(),
				validUpto: row.cells[6]?.innerText.trim()
			};
		}

		dependentList.push(dependent);
	});

	var finalJson = {
		PersonalInfo: personalInfo,
		DeptInfo: deptInfo,
		Dependent: dependentList
	};

	console.log("Sending JSON to server:", finalJson);

	var configJson = {
		serviceName: "/DMLSAVE/cardrenewal",
		callBackFunctionName: "callbackcardrenewalData",
		inputData: finalJson
	};

	callService(configJson);
}
*/


function previewPhoto(input) {
	const preview = document.getElementById('editPhotoPreview');
	if (input.files && input.files[0]) {
		const reader = new FileReader();
		reader.onload = function(e) {
			preview.src = e.target.result;
			preview.style.display = 'block';
		};
		reader.readAsDataURL(input.files[0]);
	}
}

function AddDependent() {
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
function resetPage1() {
	//alert("iinn reset page");

}




function AddDepDetails() {
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


function callbackUpdateData(configJson, dataJson) {

	//alert(JSON.stringify(configJson));
	if (dataJson["message"].indexOf("ERROR") >= 0) {
		showMsg(dataJson["message"], null)
	}
	else {
		var dialogConfigJson = { callOnOK: "resetPageupdate", "parameterJson": {} }

		showMsg(dataJson["message"], dialogConfigJson)
	}
}


function resetPageupdate() {

}