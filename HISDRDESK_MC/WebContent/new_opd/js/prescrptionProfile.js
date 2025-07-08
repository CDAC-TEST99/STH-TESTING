
$(document).ready(function(){
	
	
	//console.log("From another script:", patDeptNameRX);
	var profileArraId=[];
	//console.log('Inside Precription Profile');
	
	$('input[name=SearchPara]').on('select:flexdatalist',function(e, set, options){
		
		/* alert('You pressed enter!'+e.which);
		if(e.which == 13) {
	        alert('You pressed enter!');
	    }*/
		var investigation = $(this).val(); 
 		let f = 0;
 		var invObj = $("#prescriptionBookMarkJsonDiv").text().trim(); //localStorage.getItem('PrescriptionBookMarkJsonArrayObj'); 
 		invObj = JSON.parse(invObj); 
 		var val;
 		var profileId ;
 		for(var v=0; v<invObj.length;v++)
 		{ 
 			if (invObj[v].SERACH_DATA.toUpperCase() == investigation.toUpperCase()) {
		        console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+invObj[v].HSTR_PROFILE_NAME+'::::::::>>>>'+JSON.stringify(invObj[v].HJOSN_RX_COMPLETE));
		        val = invObj[v].HJOSN_RX_COMPLETE;
		        profileId= invObj[v].HRGNUM_PROFILE_ID;
		        f=1;
		        break;
		    } 
 		}
 		for(var z=0; z<profileArraId.length;z++)
 		{
 			if(profileId == profileArraId[z])
 				{
 				var box= confirm("Bookmark is already added ! \n Are you sure want to add original data and delete Previous Data ?");
 				if(box == true){
 					$( ".clearAllValues" ).click();
 					getPrescriptionProfileJsonData(val);
 					profileArraId =[];
 					profileArraId[profileArraId.length]=profileId;
 					$('#SearchParaIs').val('');
 					return false;
 				}else{
 					$('#SearchParaIs').val('');
 					return false
 				}
 				}
 		}
 		//console.log('NKIT'+profileArraId.length)
 		if(profileArraId.length >= 1){
 			
 			var box= confirm("One Bookmark is already added ! \n Are you sure want to add new Bookmark data and delete Previous Data ?");
				if(box == true){
					$( ".clearAllValues" ).click();
		 			profileArraId =[];
		 			profileArraId[profileArraId.length]=profileId;
		 			getPrescriptionProfileJsonData(val);
		 			$('#SearchParaIs').val('');
		 			return false;
				}else{
					$('#SearchParaIs').val('');
					return false;
				}
				
 			
 		}
 		if(f==1)
 			{
 			$( ".clearAllValues" ).click();
 			console.log('profileId'+profileId +'profileId length '+profileArraId.length);
 			profileArraId[profileArraId.length]=profileId;
 			$('#SearchParaIs').val('');
 				getPrescriptionProfileJsonData(val);
 				//console.log("val >>>> :"+val);
 			}
 	    //}
 	});
});

/*function getDataPrescriptionProfile(e){
	console.log('Test::::::::');
}
*/
var profileArrayId=[];
$('#checkLastThreeVisitDivId').change(function(){
	//var depUnit = window.deptUnit;
 	//alert(2);
	 var profileId =  ($('select[name=checkLastThreeVisitDiv] option:selected').val());
	 alert("profileId>>>" +profileId);
	 let f = 0;
	 //if(localStorage.getItem("	"+profileId))
	 console.log("xxxxxxxxxx>> xxxxxxx"+$("#lastThreeVisitJson_"+profileId).text().trim());
	 const jsonText = $("#lastThreeVisitJson_" + profileId).text().trim();
	 const visitData = JSON.parse(jsonText);
	 //alert(jsonText)
	
	 //var hospCode = document.getElementById("patHospitalCode").lastChild.data;//.split("/")[1]// $(e).closest('.patientListBlock').find('.patHospitalCode').text();
	//ss console.log(hospCode);
	 var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		
	var departmenUnitCodeCurrentRX= patCompleteGeneralDtlPrescriptionPanel.split('#')[5];
	var PatCompleteGeneralDtlProfile= visitData.PatCompleteGeneralDtl;
	var departmenUnitCodeFromProfile= PatCompleteGeneralDtlProfile.split('#')[5];
	var hosp_codeCurrentRX=$('#patHospitalCodePrescriptionPanel').text();
	var hosp_codeProfile= visitData.hosp_code;
	
	//alert("departmenUnitCodeCurrentRX>>" +departmenUnitCodeCurrentRX);
	
	//alert("departmenUnitCodeFromProfile>>" +departmenUnitCodeFromProfile);
	// var deptNameRX = document.getElementById("patDeptName").lastChild.data.split("/")[1];

	// console.log(patientUnitCode); 
	 
	 if($("#lastThreeVisitJson_"+profileId).text().trim()!='')
		 f=1;	 
	 
	 for(var z=0; z<profileArrayId.length;z++)
	 {
		var box = false;
		if(profileId == profileArrayId[z])
		{
			swal({
	            title: "Rx is already added !",
	            text: "Are you sure want to add original data and delete Previous Data ?",
	            icon: "warning",
	            buttons: true,
	            dangerMode: true,
	        })
	        .then((isOkay) => {	
	        	console.log("isOkay=="+isOkay);
	            if (isOkay) {
	            	$( ".clearAllValues" ).click();
					//if(localStorage.getItem("lastThreeVisitJson_"+profileId))
					if($("#lastThreeVisitJson_"+profileId).text()!='')
						getPrescriptionProfileJsonData(JSON.parse($("#lastThreeVisitJson_"+profileId).text()));
					console.log("getPrescription  >>  >>1 ");
					profileArrayId =[];
					profileArrayId[profileArrayId.length]=profileId;
	            }
	        });
			/*var box= confirm("Rx is already added ! \n Are you sure want to add original data and delete Previous Data ?");
			console.log("box=="+box);
			if(box){
				$( ".clearAllValues" ).click();
				if(localStorage.getItem("lastThreeVisitJson_"+profileId))
					getPrescriptionProfileJsonData(JSON.parse(localStorage.getItem("lastThreeVisitJson_"+profileId)));
				profileArrayId =[];
				profileArrayId[profileArrayId.length]=profileId;	
			}*/
			return false;
		}
	 }
	 if(profileArrayId.length >= 1){
		 var box = false;
		 swal({
	            title: "One Rx is already added !",
	            text: "Are you sure want to add new Rx data and delete Previous Data ?",
	            icon: "warning",
	            buttons: true,
	            dangerMode: true,
	        })
	        .then((isOkay) => {
	        	console.log("isOkay2=="+isOkay);
	            if (isOkay) {
	            	box = true;
	            	$( ".clearAllValues" ).click();
					profileArrayId =[];
		 			profileArrayId[profileArrayId.length]=profileId;
		 			//if(localStorage.getItem("lastThreeVisitJson_"+profileId))
		 			if($("#lastThreeVisitJson_"+profileId).text()!='')
		 				getPrescriptionProfileJsonData(JSON.parse($("#lastThreeVisitJson_"+profileId).text().trim()));	
		 			console.log("getPrescription  >>  >>  ");
	            }
	        });
		 
		/* var box= confirm("One Rx is already added ! \n Are you sure want to add new Rx data and delete Previous Data ?");
		 console.log("box2=="+box);
				if(box){
					$( ".clearAllValues" ).click();
					profileArrayId =[];
		 			profileArrayId[profileArrayId.length]=profileId;
		 			if(localStorage.getItem("lastThreeVisitJson_"+profileId))
		 				getPrescriptionProfileJsonData(JSON.parse(localStorage.getItem("lastThreeVisitJson_"+profileId)));	
				}*/
				return false;
		}
	 alert("f===" +f == 1 )
	 alert("departmen==" + departmenUnitCodeCurrentRX==departmenUnitCodeFromProfile);
	 alert("hosp==" + hosp_codeCurrentRX==hosp_codeProfile)
	 if (f == 1 && departmenUnitCodeCurrentRX==departmenUnitCodeFromProfile && hosp_codeCurrentRX==hosp_codeProfile) {
		// alert("inside\npatDeptUnitCode: " + patDeptUnitName + "\ndeptUnit: " + deptNameRX);
		// alert(depUnit);
		    //alert("inside\npatDeptUnitCode: " + patDeptUnitCode + "\ndeptUnit: " + deptUnit);
		    $(".clearAllValues").click();
		    //console.log('profileId: ' + profileId + ' | profileArrayId length: ' + profileArrayId.length);
		    profileArrayId[profileArrayId.length] = profileId;
		 // Step 1: Get the JSON string from the DOM
		    var jsonString = $("#lastThreeVisitJson_" + profileId).text().trim();
		    //console.log("Raw JSON string:", jsonString);

		    // Step 2: Parse the JSON string
		    var parsedData;
		    try {
		      parsedData = JSON.parse(jsonString);
		      console.log("Parsed data:", parsedData);
		    } catch (e) {
		      console.error("Error parsing JSON:", e);
		    }

		    // Step 3: Pass parsed data to the function
		    if (parsedData) {
		      var result = getPrescriptionProfileJsonData(parsedData);
		      console.log("Function result:", result);
		    }
		}

	 swal("Previous Rx data loaded");
	 
});


function ActionRequiredForProfilePrescription(pid , status){
	
	console.log(pid+':::::::::::::::'+status);
	
	var data = JSON.stringify(vitalJSON); 
	console.log(data); 
	var vitalJSON = { 
			'strProfileId' : pid,
			'strStatus' : status,
	}
	var data = JSON.stringify(vitalJSON); 
	console.log(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/savePrscriptionProfileData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
			console.log(result);
			
			if(result == 1)
				{
				
				 $.alert({
				        title: 'Success!',
				        content: 'Data Saved successfully!!',
				    });
				 console.log('Vital Data Saved successfully');
				}else{
					console.log('Error!!!');
					 $.alert({
					        title: 'Error!',
					        content: 'Unable to Save Data!!',
					    });
				}
    	}
	});
				 
}




function getPrescriptionProfileJsonDataOld(val){
	
	//alert('Inside Prescription Profile Json');
	console.log('Inside Prescription Profile Json');
	//console.log(val.InvestigationJsonArray.length);
	console.log(JSON.stringify(val));
	var referFound=false;
	var isEndorsement=false;
	//alert("inside if>>>" +val.PatientRefrel.length);
	if(val.proxy_flag=="1"){
		$('#isProxy').prop("checked", true);
		$('#proxy_flag').val("1");
		$('#proxyMainDiv').show();
		if(val.proxy_name!=undefined && val.proxy_name!=null)			
			$('#proxy_name').val(val.proxy_name);
		
		if(val.proxy_contact!=undefined && val.proxy_contact!=null)			
			$('#proxy_contact').val(val.proxy_contact);
		
		if(val.proxy_relation!=undefined && val.proxy_relation!=null)			
				$('#proxy_relation').val(val.proxy_relation);
		
	}
	
	if(val.PatientRefrel!=undefined && val.PatientRefrel.length>0){
	
		
		
		$.each(val.PatientRefrel, function(indx, reffralJson){
			createInternalReferralRow(reffralJson);
		});			
	}

	
	if(val.strEndorsmentDtl!=undefined && val.strEndorsmentDtl.length>0){
		$('#EndorsementListTable').show();
		referFound=true;
		isEndorsement=true;
		$('#EndorsementListTable').show();
		$('[name=referralStatus]').prop("disabled", true);
		$("#referralStatus3").prop("checked", true);
		$('#divReferType').show();
		$.each(val.strEndorsmentDtl, function(indx, reffralJson){
			createEndorementRow(reffralJson,indx);
		});
	}
	//alert(JSON.stringify(val.externalConsultantReferalDtl));
	if(val.externalConsultantReferalDtl!=undefined && val.externalConsultantReferalDtl.length>0){
		
		referFound=true;
		$('#referType_extConsultation').prop("checked", true);
		$('#referType_extConsultation').prop("disabled", true);
		$('#ExternalDiv').show();
		$('#extConsultation').show();
		$('#divReferType').show();
		$('#ExternalConsultationListTable').show();
		$.each(val.externalConsultantReferalDtl, function(indx, reffralJson){
			var key='extcon-'+reffralJson["strReffralExtId"];
			createExternalRow(reffralJson, "ExternalConsultationListTable", key);
		});
		if(isEndorsement==false)
			$("#referralStatus2").prop("checked", true);
	}
	
	if(val.externalInvestigationReferalDtl!=undefined && val.externalInvestigationReferalDtl.length>0){
		$('#referType_extInvestigation').prop("checked", true);
		$('#referType_extInvestigation').prop("disabled", true);
		$('#extInvestigation').show();
		//$('#ExternalInvestigationListTable').append(html)
		$('#ExternalInvestigationListTable').show();
		$('#ExternalDiv').show();		
		$('#divReferType').show();		
		
		
		referFound=true;
		$.each(val.externalInvestigationReferalDtl, function(indx, reffralJson){
			var key='extinv-'+reffralJson["strReffralExtId"];
			var len=$('[id^=btndel_'+ key).length;
			key= key+(len+1);
			createExternalRow(reffralJson, "ExternalInvestigationListTable", key);
		});
		if(isEndorsement==false)
			$("#referralStatus2").prop("checked", true);
	}
	if(val.externalProcedureReferalDtl!=undefined && val.externalProcedureReferalDtl.length>0){
		$('#referType_extProcedure').prop("checked", true);
		$('#referType_extProcedure').prop("disabled", true);
		$('#extProcedure').show();
		$('#ExternalProcedureListTable').show();
		$('#ExternalDiv').show();		
		$('#divReferType').show();	
		
		
		referFound=true;
		$.each(val.externalProcedureReferalDtl, function(indx, reffralJson){
			var key='extproc-'+reffralJson["strReffralExtId"];
			var len=$('[id^=btndel_'+ key).length;
			key= key+(len+1);
			createExternalRow(reffralJson, "ExternalProcedureListTable", key);
		});
		if(isEndorsement==false)
			$("#referralStatus2").prop("checked", true);
	}
	
	if(val.externalFollowupReferalDtl!=undefined && val.externalFollowupReferalDtl.length>0){
		$('#referType_extFollowup').prop("checked", true);
		$('#referType_extFollowup').prop("disabled", true);
		$('#extFollowup').show();
		$('#ExternalFollowUpListTable').show();
		$('#ExternalDiv').show();		
		$('#divReferType').show();	
		
		referFound=true;
		$.each(val.externalFollowupReferalDtl, function(indx, reffralJson){
			var key='extfollowup-'+reffralJson["strReffralExtId"];
			createExternalRow(reffralJson, "ExternalFollowUpListTable", key);
		});
		if(isEndorsement==false)
			$("#referralStatus2").prop("checked", true);
	}
	if(val.InvestigationJsonArray.length!=null)
	{
		var flag = 0;
		val.InvestigationJsonArray.forEach(function(item){
			var tempWidth = 0;
			$('.investigationAdded').find('a').each(function(index){
				tempWidth+=$(this).width();
			});
			console.log("item.tariffId==="+item.tariffId);
			var tariffId ="0",episodeCode="0",visitNo="0",isTestGroup="0";
			if(item.tariffId!=undefined)
				tariffId = item.tariffId;
			if(item.EpisodeCode!=undefined)
				episodeCode = item.EpisodeCode;
			if(item.VisitNo!=undefined)
				visitNo = item.VisitNo;
			if(item.IsTestGroup!=undefined)
				isTestGroup = item.IsTestGroup;
			if(tempWidth > ($('.investigationAdded').width()-380))
			{
				
				 var InvestigationDtlsJson = {
						 "IsExternal"   :   "0" ,
						 "TestName" 	:   item.TestName ,
			    		 "TestCode"		:	item.TestCode ,
			    		 "LabCode"		:	item.LabCode , 
			    		 "SampleCode"	:	item.SampleCode ,
			    		 "SampleName"	:	item.SampleName ,
			    		 "LabName"		:	item.LabName ,
			    		// "TestName"		:	investigationVAl1.split('^')[5] ,
			    		 "IsTestGroup"	:	isTestGroup ,
			    		 "tariffId"		:   tariffId ,
			    		 "EpisodeCode"	:	episodeCode ,
			    		 "VisitNo"		:	visitNo
			     }
				 var sideremks=' ';
				 if('SideCode' in item ) {
				 
				 if(item.SideCode !='' && item.SideCode !='0')
					 sideremks = sideremks + '('+ item.SideName + ')' ;
				 if(item.SideRemarks != '')
					 sideremks = sideremks + ' ('+item.SideRemarks +')' ;
				}
				 
				
				 if(item.LABNAME==undefined)
						item.LABNAME="lab";
				// alert("item.LABNAME>>" + item.LABNAME);
				if(item.LabCode != '0'){
					
					$('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleInvestigation '+item.LABNAME.trim().split(' ').join('_')+'">'+
			    	 		'<input type="checkbox" class="checkedInput" checked name="reasonOfVisit" value="'+item.TestCode+'^'+item.LabCode+'^'+item.SampleCode+'^'+item.SampleName+'^'+item.LabName+'^'+item.TestName+'^'+isTestGroup+'^'+tariffId+'^'+episodeCode+'^'+visitNo+'">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
			    	 		'<span class="text text1">'+item.TestName + sideremks +'<sup style="color:red; font-weight:bold;">*</sup>  </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
				}else{
					$('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleInvestigation '+item.LABNAME.trim().split(' ').join('_')+'">'+
			    	 		'<input type="checkbox" class="checkedInput" checked name="reasonOfVisit" value="'+item.TestCode+'^'+item.LabCode+'^'+item.SampleCode+'^'+item.SampleName+'^'+item.LabName+'^'+item.TestName+'^'+isTestGroup+'^'+tariffId+'^'+episodeCode+'^'+visitNo+'">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
			    	 		'<span class="text text1">'+item.TestName + sideremks+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
				}
			
	    	 		
				 tippy('.'+item.LabName.trim().split(' ').join('_'), {
		              content: item.LabName.trim(),
		              delay: 50,
		              arrow: true,
		              arrowType: 'round',
		              size: 'medium',
		              duration: 500,
		              animation: 'scale'
		          });
			}
			else
			{
				//$('.investigationAdded').append('<a class="'+item.LABNAME.trim().split(' ').join('_')+'" style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'"> '+item.TESTNAME+'</label></a>');
				
				 var InvestigationDtlsJson = {
						 "IsExternal"   :   "0" ,
						 "TestName" 	:   item.TestName ,
			    		 "TestCode"		:	item.TestCode ,
			    		 "LabCode"		:	item.LabCode , 
			    		 "SampleCode"	:	item.SampleCode ,
			    		 "SampleName"	:	item.SampleName ,
			    		 "LabName"		:	item.LabName ,
			    		// "TestName"		:	investigationVAl1.split('^')[5] ,
			    		 "IsTestGroup"	:	isTestGroup ,
			    		 "tariffId"		:   tariffId ,
			    		 "EpisodeCode"	:	episodeCode ,
			    		 "VisitNo"		:	visitNo
			     }
				 
				 var sideremks=' ';
					if('SideCode' in item ) {
					
					 
					 if(item.SideCode !='' && item.SideCode !='0')
						 sideremks = sideremks + '('+ item.SideName + ')' ;
					 if(item.SideRemarks != '')
						 sideremks = sideremks + ' ('+item.SideRemarks +')' ;
					}
					
				// alert(JSON.stringify(InvestigationDtlsJson));
				 if(item.LabCode != '0'){
				$('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs '+item.LabName.trim().split(' ').join('_')+'">'+
		    	 		'<input type="checkbox" class="checkedInput" checked name="reasonOfVisit" value="'+item.TestCode+'^'+item.LabCode+'^'+item.SampleCode+'^'+item.SampleName+'^'+item.LabName+'^'+item.TestName+'^'+isTestGroup+'^'+tariffId+'^'+episodeCode+'^'+visitNo+'">  '+
		    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
		    	 		'<span class="text text1">'+item.TestName + sideremks+' </span>'+
		    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		    	 		'</button></label>');
				 }else{
					 $('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs '+item.LabName.trim().split(' ').join('_')+'">'+
				    	 		'<input type="checkbox" class="checkedInput" checked name="reasonOfVisit" value="'+item.TestCode+'^'+item.LabCode+'^'+item.SampleCode+'^'+item.SampleName+'^'+item.LabName+'^'+item.TestName+'^'+isTestGroup+'^'+tariffId+'^'+episodeCode+'^'+visitNo+'">  '+
				    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
				    	 		'<span class="text text1">'+item.TestName+ sideremks +'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
				    	 		'</button></label>');
				 }
				 tippy('.'+item.LabName.trim().split(' ').join('_'), {
		              content: item.LabName.trim(),
		              delay: 50,
		              arrow: true,
		              arrowType: 'round',
		              size: 'medium',
		              duration: 500,
		              animation: 'scale'
		          });

			}

		});

		
		if(val.InvestgationNote !=null){
			$('#investigationNoteId').val(val.InvestgationNote);
		}
		
		$('#investigationMainDiv').find('.accordionbtn').trigger('click');
		$('#investigationMainDiv').find('.value').show();
		$('.investigationAddedMoreViewBtn').hide();
	}
	else{// if investigation not raised but investigation notes exist
		if(val.InvestgationNote !=null){
			$('#investigationNoteId').val(val.InvestgationNote);
			$('#investigationMainDiv').find('.accordionbtn').trigger('click');
		}
		
	}
	
	/*for drug*/	
	if(val.DrugJsonArray.length!=null)
	{
		
		var flag =matchProfileDates($('#currentDate').val(), val.CurrentVisitDate);
		console.log($('#currentDate').val());
		console.log(val.CurrentVisitDate);
		var drugIssuedDetailJson=val.drugIssuedDetailJson;
		console.log(flag);
		if(flag== false)
			drugIssuedDetailJson=null;
			
		loadPreviousDrugs(val.DrugJsonArray,drugIssuedDetailJson);
		$('#drugMainDiv').find('.accordionbtn').trigger('click');
		$('#drugMainDiv').find('.value').show();
		$('.drugAdviceAddedMoreViewBtn').hide();
	}
	
	if(val.strtreatmentAdvice !=null){
		$('#treatmentAdviceId').val(val.strtreatmentAdvice);
		$('#treatmentMainDiv').find('.accordionbtn').trigger('click');		
	}
	
	if(val.FOLLOW_UP[0].progressNote !=null){
		$('#progressNote').val(val.FOLLOW_UP[0].progressNote);
		$('#FollowupMainDiv').find('.accordionbtn').trigger('click');	
	}
	
	//progressNote
	
	if(val.ClinicalProcedureJsonArray!=null && val.ClinicalProcedureJsonArray.length>0)
	{
		
			val.ClinicalProcedureJsonArray.forEach(function(item){ 
			
				var ClinicalProcedureJson = {
							"IsExternal"  			:  item.IsExternal ,
							"ProceduresName"		:	item.ProceduresName ,
							"ProcedureCode"			:	item.ProcedureCode ,
							"ProcedureSideCode"		:	item.ProcedureSideCode ,
							"ProcedureSideName"		:	item.ProcedureSideName ,
							"ProcedureSideRemarks"	:	item.ProcedureSideRemarks ,
							"ServiceAreaCode"		:	item.ServiceAreaCode,
							"ServiceAreaName"		:	item.ServiceAreaName
					};
					 console.log(JSON.stringify(ClinicalProcedureJson));
				// Dressing#3310181^102#1#NR#sss\
					 var tooltipval='';
					 
					 if(item.ProcedureSideCode != '0'){
						 tooltipval = tooltipval +" ["+item.ProcedureSideName + "]";
					 }
					 if(item.ProcedureSideRemarks !=''){
						 tooltipval = tooltipval + " " + item.ProcedureSideRemarks;
					 }
				var clinicalProcValue=item.ProceduresName+'#'+item.ProcedureCode+'#'+item.ProcedureSideCode+'#'+item.ProcedureSideName+'#'+item.ProcedureSideRemarks+'#'+item.ServiceAreaCode+'#'+item.ServiceAreaName;
					$('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" data-toggle="tooltip" title="'+ tooltipval +'" class="value btn btn-xs">'+
			    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+clinicalProcValue+'" checked="checked">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(ClinicalProcedureJson)+' </i>'+
			    	 		'<span class="text">'+item.ProceduresName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
			});
			$('[data-toggle="tooltip"]').tooltip();
		
			$('#procedureMainDiv').find('.accordionbtn').trigger('click');
			$('#procedureMainDiv').find('.value').show();
		
	}
	
	if(val.ReasonOfVisitJsonArray!=null)
	{
		var flag = 0;
		var temp='';
		val.ReasonOfVisitJsonArray.forEach(function(item){ 
			console.log(item.ReasonOfVisitJsonArray);
			
			
				var tmp='';
				
				
				var tempWidth = 0;
				$('.reasonOfVisitAdded').find('a').each(function(index){
					tempWidth+=$(this).width();
				});
				if(tempWidth > ($('.reasonOfVisitAdded').width()-250))
				{
					
					//flag=1;
					if(item.VisitReasonSideName !='' && item.VisitReasonSideName !='0')
					{
						tmp=tmp +' '+item.VisitReasonSideName ;
					}
					if(item.VisitReasonNoOfDays !=''){
						tmp=tmp + '[' +item.VisitReasonNoOfDays + ' ' +  item.VisitComplaintDurationName +' ]';
					}
					if(item.VisitReasonRemarks != ''){
						tmp=tmp+ ' ' +item.VisitReasonRemarks ;
					}
					
					console.log('tmptmp'+tmp);
					var chiefComplaintJson ={
							"IsExternalVisit"	:			"1" ,
							"VisitReasonName" : 		 	item.VisitReasonName,
							"VisitReasonCode" :			 	item.VisitReasonCode,
							"VisitReasonSideCode" : 		"0",
							"VisitReasonSideName" :			item.VisitReasonSideName,
							"VisitReasonNoOfDays" : 	 	"",
							"VisitComplaintDurationCode" :  "1",
							"VisitComplaintDurationName" :  item.VisitComplaintDurationName,
							"VisitReasonRemarks"		: 	"",
						};
						
						console.log(JSON.stringify(chiefComplaintJson));
						//41982003^Male climacteric^2^15^2^Renmsk
						var tempchkval=item.VisitReasonCode +'^'+item.VisitReasonName +'^'+item.VisitReasonSideCode +'^'+item.VisitReasonNoOfDays +'^'+item.VisitComplaintDurationCode +'^'+item.VisitReasonRemarks;
					//$('.reasonOfVisitAdded').append('<a class="moreToggleVisitReason" style="padding-left:5px;display:none;"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+item.VISITREASON+'"> '+item.VISITREASON+'</label></a>');
					
					$('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" class="value btn btn-xs"    title="'+tmp+'" data-toggle="tooltip" >'+
			    	 		'<input type="checkbox" checked class="checkedInput" name="visitReason" value="'+tempchkval+'">  '+
			    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
			    	 		'<span class="text">'+item.VisitReasonName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
				}
				else
					{
					if(item.VisitReasonSideName !='' && item.VisitReasonSideName !='0')
					{
						tmp=tmp+" "+item.VisitReasonSideName ;
					}
					if(item.VisitReasonNoOfDays !=''){
						tmp=tmp+ "[" + item.VisitReasonNoOfDays + " " +  item.VisitComplaintDurationName +" ]";
					}
					if(item.VisitReasonRemarks != ''){
						tmp=tmp+ " " +item.VisitReasonRemarks ;
					}
					
					console.log('tmptmp'+tmp);
					var chiefComplaintJson ={
							"IsExternalVisit"	:			"1" ,
							"VisitReasonName" : 		 	item.VisitReasonName,
							"VisitReasonCode" :			 	item.VisitReasonCode,
							"VisitReasonSideCode" : 		"0",
							"VisitReasonSideName" :			item.VisitReasonSideName,
							"VisitReasonNoOfDays" : 	 	"",
							"VisitComplaintDurationCode" :  "1",
							"VisitComplaintDurationName" :  item.VisitComplaintDurationName,
							"VisitReasonRemarks"		: 	"",
						};
					var tempchkval=item.VisitReasonCode +'^'+item.VisitReasonName +'^'+"0" +'^'+"" +'^'+"1" +'^'+"";
						console.log(JSON.stringify(chiefComplaintJson));
						
					$('.reasonOfVisitAdded').append('<label><button  tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs  tooltipcss "   title="'+tmp+'" data-toggle="tooltip"  >'+
			    	 		'<input type="checkbox" checked class="checkedInput" name="visitReason" value="'+tempchkval+'">  '+
			    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
			    	 		'<span class="text" id="respRateIdValue"  >'+item.VisitReasonName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
					}
		});

		
		$('#chiefComplaintMainDiv').find('.accordionbtn').trigger('click');
		$('#chiefComplaintMainDiv').find('.value').show();
		$('.reasonOfVisitAddedMoreViewBtn').hide();
		
	}
	
	
	if(val.DiagnosisJsonArray!=null)
	{
		var flag = 0;
		var jsonkey={};
		val.DiagnosisJsonArray.forEach(function(item){
			//alert(item.DiagnosisName); 
			//alert(jsonkey[item.DiagnosisName]);
			if(jsonkey[item.DiagnosisName] !=undefined)//checking duplicate
				return;
			
			jsonkey[item.DiagnosisName]=item.DiagnosisName;
			var tempWidth = 0;
			$('.diagnosisAdded').find('a').each(function(index){
				tempWidth+=$(this).width();
			});
			
				if(tempWidth > ($('.diagnosisAdded').width()-250))
				{
					//flag=1;
					//$('.diagnosisAdded').append('<a class="moreToggleDiagnosis" style="padding-left:5px; display:none;"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DIAGNOSTICTYPENAME+'" value="'+item.DIAGNOSTICCODE+'#'+item.DIAGNOSTICTYPECODE+'"> '+item.DIGNOSISNAME+'</label></a>');
					
					
					var DiagnosisJson ={
		 						"IsSnomed"				:			"1" ,
								"DiagnosisName" 		: 		 	item.DiagnosisName,
								"DiagnosisCode" 		:			item.DiagnosisCode,
								"DiagnosisSideCode" 	: 			item.DiagnosisSideCode ,
								"DiagnosisSideName" 	:			item.DiagnosisSideName,
								"DiagnosisTypeCode" 	: 	 		item.DiagnosisTypeCode ,
								"DiagnosisTypeNamee" 	: 			item.DiagnosisTypeNamee,
								"DiagnosisRemarks"	:				item.DiagnosisRemarks
							};
							
		 				console.log(JSON.stringify(DiagnosisJson));
		 				var tooval='';
		 				
		 				if(item.DiagnosisSideCode !='0')
		 					tooval=tooval+" "+item.DiagnosisSideName ;
		 				if(item.DiagnosisTypeCode !='0')
		 					tooval=tooval+" ("+item.DiagnosisTypeNamee + " )" ;
		 				if(item.DiagnosisRemarks != '')
		 					tooval=tooval+" "+item.DiagnosisRemarks ;
		 				
		 				console.log('toovaltooval'+tooval);
		 				
		 				//82214002#14#1^Five day fever#Final#2##0#Remaks
		 				var tempchkval=item.DiagnosisCode+'#'+item.DiagnosisTypeCode+'#'+item.IsSnomed+'^'+item.DiagnosisName+'#'+item.DiagnosisTypeNamee+'#'+item.DiagnosisSideCode+'##0'+'#'+item.DiagnosisRemarks
					$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700; display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis tooltipcss" title="'+tooval+'" data-toggle="tooltip">'+
			    	 		'<input type="checkbox" checked class="checkedInput"  diagnosisname="'+item.DiagnosisName+'" name="diagnosisAdded" value="'+tempchkval+'">  '+
			    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
			    	 		'<span class="text">'+item.DiagnosisName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
		 				
				}
				else{
					
					
	 				
					var DiagnosisJson ={
	 						"IsSnomed"				:			"1" ,
							"DiagnosisName" 		: 		 	item.DiagnosisName,
							"DiagnosisCode" 		:			item.DiagnosisCode,
							"DiagnosisSideCode" 	: 			item.DiagnosisSideCode ,
							"DiagnosisSideName" 	:			item.DiagnosisSideName,
							"DiagnosisTypeCode" 	: 	 		item.DiagnosisTypeCode ,
							"DiagnosisTypeNamee" 	: 			item.DiagnosisTypeNamee,
							"DiagnosisRemarks"	:				item.DiagnosisRemarks
						};
						
	 				console.log(JSON.stringify(DiagnosisJson));
	 				var tooval="";
	 			
	 				if(item.DiagnosisSideCode !='0')
	 					tooval=tooval+" "+item.DiagnosisSideName ;
	 				if(item.DiagnosisTypeCode !='0' || item.DiagnosisTypeCode !='')
	 					tooval=tooval+" ("+item.DiagnosisTypeNamee + " )" ;
	 				if(item.DiagnosisRemarks != '')
	 					tooval=tooval+" "+item.DiagnosisRemarks ;
	 				
	 				console.log('toovaltooval'+tooval);
	 				var tempchkval=item.DiagnosisCode+'#'+item.DiagnosisTypeCode+'#'+item.IsSnomed+'^'+item.DiagnosisName+'#'+item.DiagnosisTypeNamee+'#'+item.DiagnosisSideCode+'##0'+'#'+item.DiagnosisRemarks
					var tmpcount=0;
					$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis tooltipcss" title="'+tooval+'" data-toggle="tooltip">'+
		    	 		'<input type="checkbox" checked class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DiagnosisName+'" value="'+tempchkval+'">  '+
		    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
		    	 		'<span class="text">'+item.DiagnosisName+' </span>'+
		    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		    	 		'</button></label>');	 				
		}
		});
		
		if(val.DiagnosisNote !=null){
			$('#diagnosisNoteId').val(val.DiagnosisNote);
		}
		if(val.strConfidentialsInfo !=null){
			$('#ConfidentialInfoId').val(val.strConfidentialsInfo);
			
		}
		$('#diagnosisMainDiv').find('.accordionbtn').trigger('click');
		$('#diagnosisMainDiv').find('.value').show();
		$('.disgnosisAddedMoreViewBtn').hide();
	}
	else{
		var openFlag=0;
		if(val.DiagnosisNote !=null){
			$('#diagnosisNoteId').val(val.DiagnosisNote);
			openFlag=1;
		}
		if(val.strConfidentialsInfo !=null){
			$('#ConfidentialInfoId').val(val.strConfidentialsInfo);
			openFlag=1;
		}
		if(openFlag==1){
			$('#diagnosisMainDiv').find('.accordionbtn').trigger('click');
		}
		
	}
	
	if(val.PatientRefrel!=null)
	{
		var flag = 0;
		val.PatientRefrel.forEach(function(item){ 
			
			
			var reffralJson={
					"strReffralDeptCmb" : item.strReffralDeptCmb ,
					"strReffralDepttext" : item.strReffralDepttext , 
					"strreferralType"    : item.strreferralType ,
					"strreferralTypeName" : item.strreferralTypeName ,
					"strReffralReason"   :  item.strReffralReason ,
					"strReffralDeptDone" : item.strReffralDeptDone ,
					
					"strExternalHospitalcode" : item.strExternalHospital ,
					"strExternalDepartmentcode"   :  item.strExternalDepartment ,
					"strExternalrefferalInstitutecode" : item.strExternalrefferalInstitute ,
					
					"strExternalHospitalName" : item.strExternalHospitalName1 ,
					"strExternalDepartmentName"   :  item.strExternalDepartmentName ,
					"strExternalrefferalInstituteName" : item.strExternalrefferalInstituteName ,
					'strOtherAssociateHospitalName'		: item.strOtherAssociateHospitalName ,
					'strShowData'  						: item.strShowData
			} ;
			
			var reffralJson={
					"strReffralDeptCmb" : item.strReffralDeptCmb ,
					"strReffralDepttext" : item.strReffralDepttext , 
					"strreferralType"    : item.strreferralType ,
					"strreferralTypeName" : item.strreferralTypeName ,
					"strReffralReason"   :  item.strReffralReason ,
					"strReffralDeptDone" : item.strReffralDeptDone
			} ;
			console.log(reffralJson);
			
			var tooltipdata ='-';
			if(item.strreferralType != 0)
				tooltipdata =item.strreferralTypeName;
			if(item.strReffralReason != '')
				tooltipdata =item.strreferralTypeName +'(' + item.strReffralReason +' ) ';
			
			strrefcount++;
			/*$('.refferalAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button"  data-toggle="tooltip" title="'+ tooltipdata +'"  class="value btn btn-xs '+item.strReffralDepttext.trim()+'">'+
	    	 		'<input type="checkbox" class="checkedInput" name="referalchk" id="strreferalchkId'+strrefcount+'"  value="" checked="">  '+
	    	 		'<span class="text">'+item.strShowData.trim()+'<sup style="color:red; font-weight:bold;"></sup> </span>'+
	    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	    	 		'</button></label>');*/
			
			$('.refferalAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button"  data-toggle="tooltip" title='+ tooltipdata +'  class="value btn btn-xs '+item.strReffralDepttext.trim()+'">'+
	    	 		'<input type="checkbox" class="checkedInput" name="referalchk" id="strreferalchkId'+strrefcount+'"  value="" checked="">  '+
	    	 		'<i class="" style="display :none">'+JSON.stringify(reffralJson)+'^NEW</i>'+
	    	 		'<span class="text">'+item.strShowData.trim()+'<sup style="color:red; font-weight:bold;"></sup> </span>'+
	    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	    	 		'</button></label>');
			var temp='#strreferalchkId'+strrefcount;
            $(temp).val(JSON.stringify(reffralJson));
         
			
		});
		//alert("here");
		//$('[data-toggle="tooltip"]').tooltip();
		//$('#ReferMainDiv').find('.accordionbtn').trigger('click');
		//$('#ReferMainDiv').find('.value').show();
		//$('.disgnosisAddedMoreViewBtn').hide();
	}
	
	$('#followUpPlannedVisitDaysId').val(val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays);
	$('#followUpPlannedVisitDateId').val(val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate);
	if((val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos).trim() == ('SOS').trim() ){
		$('#followUpPlannedVisitSosId').prop('checked', true);
	}
	
}


function matchProfileDatesOld(date1Str, date2Str) {
    // Mapping months for parsing
    const months = {
        'January': 0, 'February': 1, 'March': 2, 'April': 3, 'May': 4, 'June': 5,
        'July': 6, 'August': 7, 'September': 8, 'October': 9, 'November': 10, 'December': 11
    };

    // Parse first date ('20 May 2025')
    const [day1, month1, year1] = date1Str.split(' ');
    const date1 = new Date(parseInt(year1), months[month1], parseInt(day1));

    // Parse second date ('20/05/2025 12:15:02')
    const [datePart] = date2Str.split(' '); // Ignore time
    const [day2, month2, year2] = datePart.split('/');
    
    const date2 = new Date(parseInt(year2), parseInt(month2) - 1, parseInt(day2));

    // Compare only the **date** (ignoring time)
	if (date1.getTime() > date2.getTime()) {
	        return false;
	    } else if (date1.getTime() < date2.getTime()) {
	        return false;
	    } else {
	        return true;
	    }
}
function checkProfileOnLoadOld(){
	//alert("inside checkProfileOnLoad");	
	var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
	var departmenUnitCodeCurrentRX= patCompleteGeneralDtlPrescriptionPanel.split('#')[5];
	var hosp_codeCurrentRX=$('#patHospitalCodePrescriptionPanel').text();
	var currentDate=$('#currentDate').val();
	//var jsonLastVisit=null;
	var indx=0;
	$('[id^=lastThreeVisitJson_]').each(function(){
		var visitData= JSON.parse($(this).text().trim());
		var PatCompleteGeneralDtlProfile= visitData.PatCompleteGeneralDtl;
		var departmenUnitCodeFromProfile= PatCompleteGeneralDtlProfile.split('#')[5];
		var hosp_codeProfile= visitData.hosp_code;
		var visitDate= visitData.CurrentVisitDate;
		var flag =matchProfileDates(currentDate, visitDate);
		if(flag ==true && departmenUnitCodeCurrentRX==departmenUnitCodeFromProfile && hosp_codeCurrentRX==hosp_codeProfile){
			getPrescriptionProfileJsonData(visitData);
			jsonLastVisit=null;
		}else{
			if(indx==0)
				jsonLastVisit=visitData;
			
		}
		indx++;
	});
	
}
function populateLastDiagnosisOld(){
	//alert("inside populateLastDiagnosis");
	var val=null;
	
	if($('[id^=lastThreeVisitJson_]').length==0)
		return;
	var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		
	var departmenUnitCodeCurrentRX= patCompleteGeneralDtlPrescriptionPanel.split('#')[5];
	var hosp_codeCurrentRX=$('#patHospitalCodePrescriptionPanel').text();
	
	var indx=0;
	$('[id^=lastThreeVisitJson_]').each(function(){
		var visitData= JSON.parse($(this).text().trim());
		var PatCompleteGeneralDtlProfile= visitData.PatCompleteGeneralDtl;
		var departmenUnitCodeFromProfile= PatCompleteGeneralDtlProfile.split('#')[5];
		var hosp_codeProfile= visitData.hosp_code;
		if(indx==0  && departmenUnitCodeCurrentRX==departmenUnitCodeFromProfile && hosp_codeCurrentRX==hosp_codeProfile){
			val=visitData;
			indx++;
		}
	});
	//alert(val);
	//alert(val.DiagnosisJsonArray.length);
	if(val!=null && val.DiagnosisJsonArray!=null && val.DiagnosisJsonArray.length>0)
		{
			var jsonkey={};
			val.DiagnosisJsonArray.forEach(function(item){
				//alert(item.DiagnosisName); 
				//alert(jsonkey[item.DiagnosisName]);
				if(jsonkey[item.DiagnosisName] !=undefined)//checking duplicate
					return;
				
				jsonkey[item.DiagnosisName]=item.DiagnosisName;
				var tempWidth = 0;
				$('.diagnosisAdded').find('a').each(function(index){
					tempWidth+=$(this).width();
				});
				
					if(tempWidth > ($('.diagnosisAdded').width()-250))
					{
						//flag=1;
						//$('.diagnosisAdded').append('<a class="moreToggleDiagnosis" style="padding-left:5px; display:none;"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DIAGNOSTICTYPENAME+'" value="'+item.DIAGNOSTICCODE+'#'+item.DIAGNOSTICTYPECODE+'"> '+item.DIGNOSISNAME+'</label></a>');
						
						
						var DiagnosisJson ={
			 						"IsSnomed"				:			"1" ,
									"DiagnosisName" 		: 		 	item.DiagnosisName,
									"DiagnosisCode" 		:			item.DiagnosisCode,
									"DiagnosisSideCode" 	: 			item.DiagnosisSideCode ,
									"DiagnosisSideName" 	:			item.DiagnosisSideName,
									"DiagnosisTypeCode" 	: 	 		item.DiagnosisTypeCode ,
									"DiagnosisTypeNamee" 	: 			item.DiagnosisTypeNamee,
									"DiagnosisRemarks"	:				item.DiagnosisRemarks
								};
								
			 				console.log(JSON.stringify(DiagnosisJson));
			 				var tooval='';
			 				
			 				if(item.DiagnosisSideCode !='0')
			 					tooval=tooval+" "+item.DiagnosisSideName ;
			 				if(item.DiagnosisTypeCode !='0')
			 					tooval=tooval+" ("+item.DiagnosisTypeNamee + " )" ;
			 				if(item.DiagnosisRemarks != '')
			 					tooval=tooval+" "+item.DiagnosisRemarks ;
			 				
			 				console.log('toovaltooval'+tooval);
			 				
			 				//82214002#14#1^Five day fever#Final#2##0#Remaks
			 				var tempchkval=item.DiagnosisCode+'#'+item.DiagnosisTypeCode+'#'+item.IsSnomed+'^'+item.DiagnosisName+'#'+item.DiagnosisTypeNamee+'#'+item.DiagnosisSideCode+'##0'+'#'+item.DiagnosisRemarks
						$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700; display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis tooltipcss" title="'+tooval+'" data-toggle="tooltip">'+
				    	 		'<input type="checkbox" checked class="checkedInput"  diagnosisname="'+item.DiagnosisName+'" name="diagnosisAdded" value="'+tempchkval+'">  '+
				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
				    	 		'<span class="text">'+item.DiagnosisName+' </span>'+
				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
				    	 		'</button></label>');
			 				
					}
					else{
						
						
		 				
						var DiagnosisJson ={
		 						"IsSnomed"				:			"1" ,
								"DiagnosisName" 		: 		 	item.DiagnosisName,
								"DiagnosisCode" 		:			item.DiagnosisCode,
								"DiagnosisSideCode" 	: 			item.DiagnosisSideCode ,
								"DiagnosisSideName" 	:			item.DiagnosisSideName,
								"DiagnosisTypeCode" 	: 	 		item.DiagnosisTypeCode ,
								"DiagnosisTypeNamee" 	: 			item.DiagnosisTypeNamee,
								"DiagnosisRemarks"	:				item.DiagnosisRemarks
							};
							
		 				console.log(JSON.stringify(DiagnosisJson));
		 				var tooval="";
		 			
		 				if(item.DiagnosisSideCode !='0')
		 					tooval=tooval+" "+item.DiagnosisSideName ;
		 				if(item.DiagnosisTypeCode !='0' || item.DiagnosisTypeCode !='')
		 					tooval=tooval+" ("+item.DiagnosisTypeNamee + " )" ;
		 				if(item.DiagnosisRemarks != '')
		 					tooval=tooval+" "+item.DiagnosisRemarks ;
		 				
		 				console.log('toovaltooval'+tooval);
		 				var tempchkval=item.DiagnosisCode+'#'+item.DiagnosisTypeCode+'#'+item.IsSnomed+'^'+item.DiagnosisName+'#'+item.DiagnosisTypeNamee+'#'+item.DiagnosisSideCode+'##0'+'#'+item.DiagnosisRemarks
						var tmpcount=0;
						$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis tooltipcss" title="'+tooval+'" data-toggle="tooltip">'+
			    	 		'<input type="checkbox" checked class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DiagnosisName+'" value="'+tempchkval+'">  '+
			    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
			    	 		'<span class="text">'+item.DiagnosisName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');	 				
			}
			});
			
			if(val.DiagnosisNote !=null){
				$('#diagnosisNoteId').val(val.DiagnosisNote);
			}
			if(val.strConfidentialsInfo !=null){
				$('#ConfidentialInfoId').val(val.strConfidentialsInfo);
				
			}
			$('#diagnosisMainDiv').find('.accordionbtn').trigger('click');
			$('#diagnosisMainDiv').find('.value').show();
			$('.disgnosisAddedMoreViewBtn').hide();
		}	
}