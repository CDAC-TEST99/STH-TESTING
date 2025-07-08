function SaveData(data , FormattedData,e)
{
	console.log(data);
	var checkBox = document.getElementById("strCheckbyDateId");
	if(checkBox.checked == true){
		console.log('kkkk');
	}
	
	console.log('111FormattedData'+FormattedData);
	console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	console.log('saveCount:::>>'+saveCount); 
	//$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/IpdDrDesk/saveData/',type:'POST',data:{JsonData:data ,FormattedJsonDataArray:FormattedData},success:function(result)
    	{
		console.log('::::saved successfully:::');
		//$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_18').addClass('isAttended_2'); 
		//$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		//$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
	 	$('.savePrescAlert').show();
		$(e).hide();
		$('.nextPatientPresc').click(); 
		setTimeout(function(){ 
			  $('.savePrescAlert').fadeOut(4000); 
		}, 3000);
		
		/*swal("This modal will disappear soon!", {
			  buttons: false,
			  timer: 3000,
			});*/ 
    	} 
    	 
    	
	});
	/*$.ajax({
		  type: "POST",
		  url: "http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/",
		  data: data,
		  success: function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}
function SavePatientReffralData(data,e)
{
	console.log(data);
	console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	console.log('saveCount:::>>'+saveCount); 
	//$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/IpdDrDesk/saveData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
		console.log('::::saved successfully:::');
		$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_1').addClass('isAttended_2'); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
	 	$('.savePrescAlert').show();
		$(e).hide();
		$('.nextPatientPresc').click(); 
		setTimeout(function(){ 
			  $('.savePrescAlert').fadeOut(4000); 
		}, 3000);
		
		/*swal("This modal will disappear soon!", {
			  buttons: false,
			  timer: 3000,
			});*/ 
    	} 
    	 
    	
	});
	/*$.ajax({
		  type: "POST",
		  url: "http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/",
		  data: data,
		  success: function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}
function SavePrintData(data)
{
	//alert('2');
	//alert(data);
	console.log(data);
	console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	console.log('....saveCount:::>>'+saveCount); 
	//$('.visitedPatCount').text(saveCount);
	$.ajax({url:'/HISDRDESK_MC/services/restful/IpdDrDesk/saveData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
		console.log('::::saved successfully:::');
		console.log(JSON.stringify(result)); 
		$('.patientListBlock:contains('+data.CR_No+')').removeClass('isAttended_1').addClass('isAttended_2'); 
		$('.patientListBlock:contains('+data.CR_No+') td').eq(0).find('i').remove(); 
		$('.patientListBlock:contains('+data.CR_No+') td').eq(2).find('a').text('Attended'); 
		$('.savePrescAlert').show();
		$('.savePrescAlert').css('top','5vh'); 
		setTimeout(function(){ 
		     $('.nextPatientPresc').click();
		}, 500); 
		setTimeout(function(){ 
			                $('.savePrescAlert').fadeOut(4000);  
		}, 1500); 
	/*	
		$("#printPrescriptionModal").on('hide.bs.modal', function () {
			
		 });*/

/*		$('body').append('<div class="alert alert-success alert-dismissible fade in" style="position:fixed; z-index:9999; top:8vh; left:30vw; color: #fff; background-color: #31900a; border-color: #478c0e; font-size: 16px;"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Success!</strong> Prescription saved successfully</div>');*/
		
    	}
    /*	error: $('body').append('<div class="alert alert-success alert-dismissible fade in" style="position:fixed; z-index:9999; top:8vh; left:30vw;color: #fff;background-color: #da4f39; border-color: #da4f39; font-size: 16px;"><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a><strong>Error!</strong> Prescription saved successfully</div>'),*/
    	 
    	
	});
	/*data = JSON.parse(data.toString());
	$('.printPrescPage .patName').text(data.pat_Name);
	$('.printPrescPage .patCrNo').text(data.CR_No);
	$('.printPrescPage .patAgeGen').text(data.patAge+'/'+data.patGender);
	$('.printPrescPage .patCat').text(data.patCat);
	$('.printPrescPage .patRelName').text('');
	$('.printPrescPage .patDeptU').text('');
	$('.printPrescPage .patVisitDate').text('');
	$('.printPrescPage .consultantName').text('');
	
	for(var i=0;i<data.ReasonOfVisit.length;i++)
	{
		$('.printPrescPage .reasonOfVisit').append(data.ReasonOfVisit[i].split('^')[1].trim()+', ');
	}
	for(var i=0;i<data.InvTestCode.length;i++)
	{ 
		$('.printPrescPage .investigation').append(data.InvTestCode[i].split('^')[4].trim()+', ');
		$('.printPrescPage .investigation').append('<li><p>'+data.InvTestCode[i].split('^')[4].trim()+'</p></li>');
	}
	for(var i=0;i<data.Diagnosis.length;i++)
	{  
		$('.printPrescPage .diagnosis').append(data.Diagnosis[i].split('^')[1].trim().split('#')[0]+'('+data.Diagnosis[i].split('^')[1].trim().split('#')[1]+')'+', ');
	}
	
	$('.printPrescPage .clinicalNote').text(data.FOLLOW_UP[0].progressNote);
	

	for(var i=0;i<data.DrugCodeCat.length;i++)
	{ 
	  $('.printPrescPage .printPrescTreatmentTbl tbody').append('<tr><td>'+data.DrugCodeCat[i].split('&&')[0].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[2].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[4].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[7].trim()+'</td><td>'+data.DrugCodeCat[i].split('&&')[8].trim()+'</td><tr>');
		$('.printPrescPage .printPrescTreatmentLst').append('<li><p>'+data.DrugCodeCat[i].split('&&')[0].trim()+', <small>'+data.DrugCodeCat[i].split('&&')[2].trim()+', '+data.DrugCodeCat[i].split('&&')[4].trim()+', '+data.DrugCodeCat[i].split('&&')[7].trim()+' Days ('+data.DrugCodeCat[i].split('&&')[8].trim()+') </small></p></li>');
	}
	
	
	$('.printPrescPage .followUp').text(data.FOLLOW_UP[0].progressNote);
	$('.printPrescPage .date').text(new Date().toDateString()); */
	
	

	/*$.ajax({
		  type: "POST",
		  url: "http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/",
		  data: data,
		  success: function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}

window.closePopUpIframe = function(){
	$('#printPrescriptionMainDeskModal').modal('hide');$('#printPrescFrameId').remove();
}

window.saveFromIframe = function(data , FormattedData)
{   
	
		
	data = JSON.stringify(data);
	FormattedData = JSON.stringify(FormattedData);
	$('#printPrescriptionModal').modal('hide');
	console.log("saveFromIframe::::>>>>>>>>data:::>>>"+data);
	console.log('totalCount::::::::><>>>>>>'+totalCount+'FormattedData'+FormattedData);
	//if(saveCount<totalCount)
	//saveCount++;
	//console.log('....saveCount:::>>'+saveCount); 
	//$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	//console.log('data.strReffralDeptCmb::::::: '+ patData.strReffralDeptCmb );
	console.log('Deptmartmment ::::::::::'+patData.PatCompleteGeneralDtl.split('#')[6]);

	$.ajax({url:'/HISDRDESK_MC/services/restful/IpdDrDesk/saveData/',type:'POST',data:{JsonData:data ,FormattedJsonDataArray:FormattedData},success:function(result)
    	{
		console.log('::::IPD saved successfully:::');
		console.log(JSON.stringify(result)); 
		//$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_18').addClass('isAttended_2'); 
		//$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		//$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
		//var a=$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		//console.log(':::::::::::::::==========::::::::::::::'+a);
		/*console.log(patData.PatCompleteGeneralDtl)
		console.log((patData.PatCompleteGeneralDtl).split('#')[15]);*/
		var temp= $('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		//console.log(temp);
		//console.log(temp.split('#')[15]);
		if(temp.split('#')[15] == '0' ){
			var patGeneralDtl = $('input[name=patCompleteGeneralDtl]').val();
			var temp=patGeneralDtl.split('#');
			//console.log('patdtls::::::'+patGeneralDtl);
			$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(temp[0]+'#'+temp[1]+'#'+temp[2]+'#'+temp[3]+'#'+temp[4]+'#'+temp[5]+'#'+temp[6]+'#'+temp[7]+'#'+temp[8]+'#'+temp[9]+'#'+temp[10]+'#'+temp[11]+'#'+temp[12]+'#'+temp[13]+'#'+temp[14]+'#1#'+temp[16]+'#'+temp[17]);
			//$('.patientListBlock:contains('+patData.CR_No+') td').eq(9).append('<button type="button" class="btn btn-outline-reprint printPrescriptionMainDeskTriggerBtn" onclick="printPrescriptionMainDeskFun(this)">Reprint</button>');	
		}
		$('.savePrescAlert').show();
		$('.savePrescAlert').css('top','5vh'); 
		var i = 3;
		$('.savePrescAlert .msgAlertTimer').text('Seconds left : '+ i +':00');
		var timer = setInterval(function(){
			$('.savePrescAlert .msgAlertTimer').text('Seconds left : '+ --i +':00');
			},1000);
		var timeOut = setTimeout(function(){ 
			 clearInterval(timer);
		     $('.nextPatientPresc').click();
			 $('.savePrescAlert').fadeOut(1500);  
		}, 3000);  
		$('.savePrescAlertOkBtn').click(function(){
			 clearTimeout(timeOut);
			 $('.nextPatientPresc').click();
			 $('.savePrescAlert').hide();
		});
		$('.savePrescAlertCancelBtn').click(function(){
			 clearTimeout(timeOut); 
			 $('.savePrescAlert').hide();
			 hidePrescription(this);
		}); 
    	} 
    	
	});  
}
/*
$.post(testurl + '/HBIMS/service/patient/desk/patdtl/crno',
			{
				crno: patCRNO,
				hcode: hospitalID
			},
	function (patdetailsJSON) {
		//alert("Response:" + patdetailsJSON.TOTAL + JSON.stringify(patdetailsJSON, null, 2));
		displayPatientDetailsTable(patdetailsJSON);
	});*/


function getPrevData(CR_No,episodeCode,hospitalCode,lastVisitDate ,admno , eTeleconsultancyReqId,visitNo)
{
	console.log('getPrevData');
	console.log('CR_No:::>>>>---'+CR_No);
	console.log('episodeCode:::>>>>---'+episodeCode);
	console.log('hospitalCode:::>>>>---'+hospitalCode);
	console.log('lastVisitDate:::>>>>---'+lastVisitDate);
	console.log('admno:::>>>>---'+admno);
	console.log('eTeleconsultancyReqId:::>>>>---'+eTeleconsultancyReqId);
	console.log('visitNo:::>>>>---'+visitNo);
	$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/IPDDoctorDeskAction.cnt?hmode=GETPREV&PUK='+CR_No+'&EPISODECODE='+episodeCode+'&HOSPITALCODE='+hospitalCode+'&admNo='+admno+'&eTeleconsultancyReqId='+eTeleconsultancyReqId +' ',type:'GET',async: true,success:function(result)
    	{
		//console.log(url);
			/*var rst = JSON.parse(result);*/
			console.log('rst:::::::'+JSON.stringify(result));
			/*console.log('MY JSON::::::::::::::::::::::::::');
			console.log(result.LASTTHREEVISIT);
			console.log('MY JSON::::::::::::::::::::::::::');
			$('#checkLastThreeVisitDiv0').hide();
			$('#checkLastThreeVisitDiv1').hide();
			$('#checkLastThreeVisitDiv2').hide();
			if(result.LASTTHREEVISIT.length!=null)
			{
				result.LASTTHREEVISIT.forEach(function(item,index){
					console.log('MY JSON3::::::::::::::::::::::::::');
					console.log("index=="+index+"\n value==="+item.HRSTR_JSON);
					if(localStorage.getItem("lastThreeVisitJson_"+index))
						localStorage.removeItem("lastThreeVisitJson_"+index);
						localStorage.setItem("lastThreeVisitJson_"+index, item.HRSTR_JSON);
					
					if(localStorage.getItem("lastThreeVisitJson_"+index)){
						$('#checkLastThreeVisitDiv'+index).show();
						//console.log("show"+index);
					}	
					else
						$('#checkLastThreeVisitDiv'+index).hide();
				});
			}*/
			if(result.INVDATA)
			if(result.INVDATA.length!=null)
			{
				var flag = 0;
				result.INVDATA.forEach(function(item){
					var tempWidth = 0;
					$('.investigationAdded').find('a').each(function(index){
						tempWidth+=$(this).width();
					});
					if(tempWidth > ($('.investigationAdded').width()-380))
					{
						flag=1;
						var isTestGroup = "0";
						if(item.GRPTARIFFID!="0")
							isTestGroup="1";
						//$('.investigationAdded').append('<a class="moreToggleInvestigation '+item.LABNAME.trim().split(' ').join('_')+'" style="padding-left: 5px;display:none;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'"> '+item.TESTNAME+'</label></a>');
						
						
						 var InvestigationDtlsJson = {
								 "IsExternal"   :   "0" ,
								 "TestName" 	:   item.TESTNAME ,
					    		 "TestCode"		:	item.PRVTESTCODE ,
					    		 "LabCode"		:	(item.PRVLABCODE).split('^')[0] ,
					    		 "SampleCode"	:	(item.PRVLABCODE).split('^')[1] ,
					    		 "SampleName"	:	(item.PRVLABCODE).split('^')[2] ,
					    		 "LabName"		:	item.LABNAME ,
					    		 "EntryDate"	:	item.ENTRYDATE ,
					    		 "DeptCode"		:	item.DEPTCODE ,
					    		 "EpisodeCode"	:	item.EPISODECODE ,
					    		 "VisitNo"		:	item.VISITNO ,
					    		// "TestName"		:	investigationVAl1.split('^')[5] ,
					    		 "IsTestGroup"	:	isTestGroup ,
					    		 "tariffId"		:	item.GRPTARIFFID
					     }
						 console.log("INV 1=="+JSON.stringify(InvestigationDtlsJson));
						 var invHtmlInput1 = '';
						 /*if(episodeCode===item.EPISODECODE && visitNo===item.VISITNO)
						 {
							 invHtmlInput1 = "disabled";
						 }
						 else
						 {
							 invHtmlInput1 = "";
						 } */
						
						$('.investigationAdded').append('<label class="InvLabel"><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" '+ invHtmlInput1+' class="value btn btn-xs moreToggleInvestigation '+item.LABNAME.trim().split(' ').join('_')+'">'+
			    	 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'^'+item.TESTNAME+'^'+isTestGroup+'^'+item.GRPTARIFFID+'^'+item.EPISODECODE+'^'+item.VISITNO+'">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
			    	 		'<span class="text text1">'+item.TESTNAME+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');

						 if(invHtmlInput1!="disabled")
							{
								tippy('.'+item.LABNAME.trim().split(' ').join('_'), {
						              content: item.LABNAME.trim(),
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
								tippy('.InvLabel', {
									  content: "This test has already been raised today, pls refer past rx for detail",
									  delay: 50,
						              arrow: true,
						              arrowType: 'round',
						             // size: 'medium',
						              duration: 500,
						              animation: 'scale'
									});
							}
					}
					else
					{
						//$('.investigationAdded').append('<a class="'+item.LABNAME.trim().split(' ').join('_')+'" style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'"> '+item.TESTNAME+'</label></a>');
						var isTestGroup = "0";
						if(item.GRPTARIFFID!="0")
							isTestGroup="1";
						
						 var InvestigationDtlsJson = {
								 "IsExternal"   :   "0" ,
								 "TestName" 	:   item.TESTNAME ,
					    		 "TestCode"		:	item.PRVTESTCODE ,
					    		 "LabCode"		:	(item.PRVLABCODE).split('^')[0] ,
					    		 "SampleCode"	:	(item.PRVLABCODE).split('^')[1] ,
					    		 "SampleName"	:	(item.PRVLABCODE).split('^')[2] ,
					    		 "LabName"		:	item.LABNAME ,
					    		 "EntryDate"	:	item.ENTRYDATE ,
					    		 "DeptCode"		:	item.DEPTCODE ,
					    		 "EpisodeCode"	:	item.EPISODECODE ,
					    		 "VisitNo"		:	item.VISITNO ,
					    		// "TestName"		:	investigationVAl1.split('^')[5] ,
					    		 "IsTestGroup"	:	isTestGroup ,
					    		 "tariffId"		:	item.GRPTARIFFID
					     }
						 console.log("INV 2=="+JSON.stringify(InvestigationDtlsJson));
						 
						 //const entryDate = new Date(item.ENTRYDATE);
						 //const currInvDate = new Date();
						 var invHtmlInput = '';
						/* if(episodeCode===item.EPISODECODE && visitNo===item.VISITNO)
						 {
							 invHtmlInput = "disabled";
						 }
						 else
						 {
							 invHtmlInput = "";
						 } */
						 
						$('.investigationAdded').append('<label class="InvLabel"><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" '+ invHtmlInput+' class="value btn btn-xs '+item.LABNAME.trim().split(' ').join('_')+'">'+
				    	 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'^'+item.TESTNAME+'^'+isTestGroup+'^'+item.GRPTARIFFID+'^'+item.EPISODECODE+'^'+item.VISITNO+'">  '+
				    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
				    	 		'<span class="text text1" >'+item.TESTNAME+' </span>'+
				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
				    	 		'</button></label>');
						if(invHtmlInput!="disabled")
						{
							tippy('.'+item.LABNAME.trim().split(' ').join('_'), {
					              content: item.LABNAME.trim(),
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
							tippy('.InvLabel', {
								  content: "This test has already been raised today, pls refer past rx for detail",
								  delay: 50,
					              arrow: true,
					              arrowType: 'round',
					             // size: 'medium',
					              duration: 500,
					              animation: 'scale'
								});
						}
						
					}

				});

				if(flag==1)
				{
					$('.investigationAdded').parent().prepend('<a style="text-decoration:none;float:right" class="btn btn-link investigationAddedMoreViewBtn">more..</a>');					
/*					$('.investigationAdded').parent().parent().find('div').eq(1).append('<a style="text-decoration:none" class="btn btn-link investigationAddedMoreViewBtn">more..</a>');*/					
					$('.investigationAddedMoreViewBtn').click(function(){
						$('.investigationAdded .moreToggleInvestigation').fadeToggle('fast');
						/*$(this).hide();*/
					});
				}
			}
			if(result.DRUGDATA)
			if(result.DRUGDATA.length!=null)
			{
				var flag = 0;
				result.DRUGDATA.forEach(function(item,index){
					//console.log('moreindex '+index);
					if(index<3)   // rest of items will be hidden with 'more...' link
					{
						var strfrequnctName ='';
						if(item.HGNUM_FREQUENCY_ID == '11')
							strfrequnctName = 'OD';
						else if(item.HGNUM_FREQUENCY_ID == '12')
							strfrequnctName = 'BD';
						else if(item.HGNUM_FREQUENCY_ID == '13')
							strfrequnctName = 'TDS';
						else if(item.HGNUM_FREQUENCY_ID == '14')
							strfrequnctName = 'SOS';
						else if(item.HGNUM_FREQUENCY_ID == '15')
							strfrequnctName = 'QID';
						else if(item.HGNUM_FREQUENCY_ID == '16')
							strfrequnctName = 'HS';
						else
							strfrequnctName = '--';
							
						var chckDrugVal = item.HSTSTR_ITEM_NAME+'&&'+item.HSTNUM_ITEM_ID+'#'+item.HSTNUM_ITEMTYPE_ID+'#'+'0'+'#'+'N'+'#'+item.HSTNUM_ITEMBRAND_ID+'&&'+item.HGSTR_DOSE_NAME+'&&'+item.HGNUM_DOSE_ID+'&&'+strfrequnctName+'&&'+item.HGNUM_FREQUENCY_ID+'&&'+item.HRGDT_START_DATE+'&&'+item.HGNUM_DAYS+'#'+item.HGNUM_DOSE_QTY+'&&'+item.HRGSTR_REMARKS+'&&'+item.HRGNUM_EPISODE_CODE+'&&'+item.HRGNUM_VISIT_NO+'&&EDIT&&'+item.HGSTR_DRUG_ADMIN_ID+'&&'+item.HGNUM_DRUG_ROUTE_ID+'&&'+item.HGSTR_DRUG_ROUTE_NAME;
					  
						var DrugJson ={
			 					"IsExterNal"	:		"0" ,	
			 					"DrugName"		 :	 item.HSTSTR_ITEM_NAME ,
			 					"DrugCode"		 :	 item.HSTNUM_ITEM_ID+'#'+item.HSTNUM_ITEMTYPE_ID+'#'+'0'+'#'+'N'+'#'+item.HSTNUM_ITEMBRAND_ID ,
			 					"DoaseName"		:	item.HGSTR_DOSE_NAME ,
			 					"DoaseCode"		:	item.HGNUM_DOSE_ID ,
			 					"FrequencyName"	:	strfrequnctName ,
			 					"FrequencyCode" :	item.HGNUM_FREQUENCY_ID ,
			 					"StartDate"		:	item.HRGDT_START_DATE ,
			 					"DrugDays"		:	item.HGNUM_DAYS ,
			 					"DrugQuantity"	:	"" ,
			 					"DrugInstruction" :	item.HRGSTR_REMARKS ,
			 					"EpisodeCode"   :	item.HRGNUM_EPISODE_CODE ,
			 					"VisitNo"		:	item.HRGNUM_VISIT_NO ,
			 					"Mode"			:	"EDIT" ,
			 					"drugAdmId"		: 	item.HGSTR_DRUG_ADMIN_ID ,
			 					"drugRouteId"	:	item.HGNUM_DRUG_ROUTE_ID ,
			 					"drugRouteName"	:	item.HGSTR_DRUG_ROUTE_NAME
			 			}
						console.log("DRUGJSON --- "+JSON.stringify(DrugJson));
						//const strtDate = new Date(item.GDT_ENTRY_DATE);
						//const currDate = new Date();
						var drugHtmlInput = '',drugHtmlEditBtn='',drugHtmlRevokeBtn='';
						/*if(episodeCode===item.HRGNUM_EPISODE_CODE && visitNo===item.HRGNUM_VISIT_NO)
						{
							drugHtmlInput = "disabled";
						}
						else
						{
							drugHtmlInput ="";
						}*/
						
						if($('#isAdmittedHiddenValId').val()=='18')
							drugHtmlRevokeBtn = "disabled";
						else
							drugHtmlRevokeBtn = "";
						
						var drugAdmName='';
						switch(item.HGSTR_DRUG_ADMIN_ID){
							case "1":
								drugAdmName = "Before Breakfast";
								break;
							case "2":
								drugAdmName = "After Breakfast";
								break;
							case "3":
								drugAdmName = "Before Lunch";
								break;
							case "4":
								drugAdmName = "After Lunch";
								break;
							case "5":
								drugAdmName = "Before Dinner";
								break;
							case "6":
								drugAdmName = "After Dinner";
								break;
							default:
								drugAdmName = "";
							}
						var drugInst = item.HRGSTR_REMARKS.trim()+'$'+item.HGSTR_DRUG_ROUTE_NAME+'$'+drugAdmName;
						//console.log(drugHtmlInput);
						let drugValFunc = "onclick='openRevokeDrugModal(\""+chckDrugVal+"\",\""+index+"\")'";
						
						$('.drugsAdvicesAdded').parent().find('.table').children('tbody').append('<tr class="TRdrug" id="trDrug'+index+'"> <td><input type="checkbox" class="checkedInput" name="drugsAdvices" '+drugHtmlInput +' value="'+chckDrugVal+'"> <i class="text1" style="display :none">'+JSON.stringify(DrugJson)+' </i></td><td>'+item.HSTSTR_ITEMBRAND_NAME+'</td><td>'+item.HGSTR_DOSE_NAME+'</td><td>'+strfrequnctName+'</td><td>'+item.HRGDT_START_DATE+'</td><td>'+item.HGNUM_DAYS+'</td><td>'+item.HGNUM_DOSE_QTY+'</td><td><a  class="drugAdvicesInstructionsModalBtn" style="color: #109f1c" drugInstructions="'+drugInst+'" onclick="$(\'#drugAdvicesInstructionsModal3\').modal(\'show\');">'+item.HRGSTR_REMARKS.substring(0, 4)+'..'+'</a></td> <td><button class="btn btn-xs drugEditBtn" type="button" '+drugHtmlInput +' ><i class="fa fa-edit"></i></button></td><td ><button class="btn btn-xs drugRevokeBtn" type="button" '+drugValFunc+' id="drugRevokeBtnId" '+drugHtmlRevokeBtn+'><i class="fa fa-times" style="color:red"></i></button></td><td><button class="btn btn-xs monogrambtn" type="button" data-toggle="modal" data-target="CimsMonographId"><i class="fas fa-capsules" style="color: Crimson;"></i></button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-xs Genericbarndbtn" type="button" data-toggle="modal" data-target="GenericMonogramId"><i class="fas fa-tablets" style="color: DeepSkyBlue;"></i></button></td></tr>');	
						
						if(drugHtmlInput == "disabled")
						{
							tippy('.TRdrug', {
								  content: "This medicine has already been prescribed today for issuance to pharmacy, pls refer past rx for detail",
								  delay: 50,
					              arrow: true,
					              arrowType: 'round',
					             // size: 'medium',
					              duration: 500,
					              animation: 'scale'
								});
						}
						
						
						
						  $('.drugAdvicesInstructionsModalBtn').click(function(){ 
							  var drugDtl = $(this).attr('drugInstructions').split('$');
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugAdmIns').text(drugDtl[2]);
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugRouteIns').text(drugDtl[1]);
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugRmrkIns').text(drugDtl[0]);
						});
						  $('.drugEditBtn').click(function(){
							  
							  console.log(item.HSTNUM_ITEM_ID == 100);
							  console.log('::::::::::::::::'+item.HSTNUM_ITEM_ID);
							    if($('input[name=drugName]').val()!='')
							    	return false;
							    
							  
							    if(item.HSTNUM_ITEM_ID == 100){
							    	
							    	var drugName = $(this).parent().parent().find('td').eq(1).text();
							 		var drugDosage = $(this).parent().parent().find('td').eq(2).text();
							 		var drugFrequency = $(this).parent().parent().find('td').eq(3).text(); 
							 		var drugStartDate = $(this).parent().parent().find('td').eq(4).text(); 
							 		var drugDays = $(this).parent().parent().find('td').eq(5).text(); 
							 		var drugQuantity = $(this).parent().parent().find('td').eq(6).text(); 
							 		var instructions = $(this).parent().parent().find('td').eq(7).text(); 
							 		
							 		$(this).parent().parent().remove();
							 		$('input[name=externalDrugName]').val(drugName);
							 		/*$('select[name=drugDosage]').val(drugDosage);*/
							 		$('select[name=externalDrugDosage]').val($('select[name=drugDosage] option:contains('+drugDosage+')').val());
							 		$('select[name=externalDrugFrequency]').val($('select[name=drugFrequency] option:contains('+drugFrequency+')').val());
							 		$('input[name=externalDrugStartDate]').val(drugStartDate); 
							 		$('input[name=externalDrugDays]').val(drugDays);
							 		$('input[name=externalDrugQuantity]').val(drugQuantity); 
							 		$('textarea[name=externalDrugInstructions]').val(instructions); 
							 		$('input[name=externalDrugName]').focus();
							    } else{
							    	
							    	var drugName = $(this).parent().parent().find('td').eq(1).text();
							 		var drugDosage = $(this).parent().parent().find('td').eq(2).text();
							 		var drugFrequency = $(this).parent().parent().find('td').eq(3).text(); 
							 		var drugStartDate = $(this).parent().parent().find('td').eq(4).text(); 
							 		var drugDays = $(this).parent().parent().find('td').eq(5).text(); 
							 		var drugQuantity = $(this).parent().parent().find('td').eq(6).text(); 
							 		var instructions = $(this).parent().parent().find('td').eq(7).text(); 
							 		
							 		$(this).parent().parent().remove();
							 		$('input[name=drugName]').val(drugName);
							 		/*$('select[name=drugDosage]').val(drugDosage);*/
							 		$('select[name=drugDosage]').val($('select[name=drugDosage] option:contains('+drugDosage+')').val());
							 		$('select[name=drugFrequency]').val($('select[name=drugFrequency] option:contains('+drugFrequency+')').val());
							 		$('input[name=drugStartDate]').val(drugStartDate); 
							 		$('input[name=drugDays]').val(drugDays);
							 		$('input[name=drugQuantity]').val(drugQuantity); 
							 		$('textarea[name=drugInstructions]').val(instructions); 
							 		//$('input[name=drugName]').focus();
							 		//return false;
							    }
						 		
							});
						  
						  
						  $('.monogrambtn').click(function(){
					   		  var data1=$(this).parent().parent().find('.checkedInput').val();
					   		var ref_id= item.HSTSTR_CIMS_GUID ;
					   		   console.log(data1); 
					   		  
					   		  $.ajax({
					   		  	url: "/HISDRDESK_MC/services/restful/cims/getMonographCimsData",
					   		  	dataType: "text",
					   		  	type: "POST",
					   		  	async: false,
					   		  	 crossDomain:true,
					   		  	data: {
					   		  		data: '"' + ref_id +'"' ,
					   		  		cimstype : item.HSTSTR_CIMSTYPE
					   		  	},
					   		  	success: function(data) {
					   		  		console.log(data);
					   		  		$('#MonographResponse').html(data);
					   		  		$("#CimsMonographId").modal();
					   		  	//	false ;
					   		  	},
					   		  	error: function(XMLHttpRequest, textStatus, errorThrown) {
					   		  		alert(errorThrown);
					   		  	}
					   		  });
					   		 });
						  
						  
						  $('.Genericbarndbtn').click(function(){

					   		  //var data1=$(this).parent().parent().find('.checkedInput').val();
						   		var ref_id= item.HSTNUM_SCT_CONCEPTID ;

					   		  $.ajax({
					   		  	url: "http://aiimsmanglagiri.uat.dcservices.in/dis/generic/"+ref_id,
					   		  	dataType: "json",
					   		  	type: "GET",
					   		  	async: false,
					   		  	 crossDomain:true, 
					   		  	success: function(data) {
					   		  		console.log(data);
					   		  		/* var myJSON = JSON.stringify(data); */
					   		  	 var html1 ='';
					   		  		for (var i=0; i<data.length; i++) {
					   		  		html1 = '<div class="row"><div class="col-sm-12 genericDesc">' + data[i].genericDescriptions[1].genericName+ '</div></div><div class="row">';
					   		        		
					   		        		for (var j=0; j<data[i].drugTypes.length; j++) {
					   		        			html1 =html1+'<div class="col-sm-12 drugTypeName">' + data[i].drugTypes[j].typeName + '&nbsp; | &nbsp; </div>'  ; 
					   		        		}
					   		        		
					   		        		html1 =html1+'</div><br /><div class="row"><div class="col-sm-6"><strong style="color:blue">Dose Form:&nbsp;&nbsp;</strong> '+ data[i].doseForm +' ';
					   		        		html1 =html1+'</div><div class="col-sm-6"><strong style="color:blue">Route Of Administration:&nbsp;&nbsp;</strong>'+data[i].routeOfAdministration + '</div></div>' ;
					   		        		html1 =html1+'<br /><div class="row"><div class="col-sm-12"><strong style="color:blue">ContraIndications:&nbsp;&nbsp;</strong>'+ data[i].contraIndications + '' ;
					   		        		html1 =html1+'</div></div><br /><div class="row"><div class="col-sm-12"><strong style="color:blue">Indications:&nbsp;&nbsp;</strong>'+ data[i].indications + '</div></div>' ;
					   		       
					   		        $('#GenericMonogramResponse').append(html1);
					   		    }
					   		    console.log(html1);

					   		    
					   		  		$('#GenericMonogramResponse').html(html1);  
					   		  		$("#GenericMonogramId").modal();
					   		  		
					   		  	},
					   		  	error: function(XMLHttpRequest, textStatus, errorThrown) {
					   		  		//alert(errorThrown);
					   		  	    //alert(XMLHttpRequest.responseText);
					   		  	alert("Description Not Mapped By SNOMEDCT");
					   		  	}
					   		  });
					   		  
					   		 });
						  
						  
						  
					}
					else
					{
						//console.log('rest of items will be hidden with more link');
						var strfrequnctName ='';
						if(item.HGNUM_FREQUENCY_ID == '11')
							strfrequnctName = 'OD';
						else if(item.HGNUM_FREQUENCY_ID == '12')
							strfrequnctName = 'BD';
						else if(item.HGNUM_FREQUENCY_ID == '13')
							strfrequnctName = 'TDS';
						else if(item.HGNUM_FREQUENCY_ID == '14')
							strfrequnctName = 'SOS';
						else if(item.HGNUM_FREQUENCY_ID == '15')
							strfrequnctName = 'QID';
						else if(item.HGNUM_FREQUENCY_ID == '16')
							strfrequnctName = 'HS';
						else
							strfrequnctName = '--';
						flag=1;
						
						var chckDrugVal = item.HSTSTR_ITEM_NAME+'&&'+item.HSTNUM_ITEM_ID+'#'+item.HSTNUM_ITEMTYPE_ID+'#'+'0'+'#'+'N'+'#'+item.HSTNUM_ITEMBRAND_ID+'&&'+item.HGSTR_DOSE_NAME+'&&'+item.HGNUM_DOSE_ID+'&&'+strfrequnctName+'&&'+item.HGNUM_FREQUENCY_ID+'&&'+item.HRGDT_START_DATE+'&&'+item.HGNUM_DAYS+'#'+item.HGNUM_DOSE_QTY+'&&'+item.HRGSTR_REMARKS+'&&'+item.HRGNUM_EPISODE_CODE+'&&'+item.HRGNUM_VISIT_NO+'&&EDIT&&'+item.HGSTR_DRUG_ADMIN_ID+'&&'+item.HGNUM_DRUG_ROUTE_ID+'&&'+item.HGSTR_DRUG_ROUTE_NAME;
					   
						var DrugJson ={
			 					"IsExterNal"	:		"0" ,	
			 					"DrugName"		 :	 item.HSTSTR_ITEM_NAME ,
			 					"DrugCode"		 :	 item.HSTNUM_ITEM_ID+'#'+item.HSTNUM_ITEMTYPE_ID+'#'+'0'+'#'+'N'+'#'+item.HSTNUM_ITEMBRAND_ID ,
			 					"DoaseName"		:	item.HGSTR_DOSE_NAME ,
			 					"DoaseCode"		:	item.HGNUM_DOSE_ID ,
			 					"FrequencyName"	:	strfrequnctName ,
			 					"FrequencyCode" :	item.HGNUM_FREQUENCY_ID ,
			 					"StartDate"		:	item.HRGDT_START_DATE ,
			 					"DrugDays"		:	item.HGNUM_DAYS ,
			 					"DrugQuantity"	:	"" ,
			 					"DrugInstruction" :	item.HRGSTR_REMARKS ,
			 					"EpisodeCode"   :	item.HRGNUM_EPISODE_CODE ,
			 					"VisitNo"		:	item.HRGNUM_VISIT_NO ,
			 					"Mode"			:	"EDIT" ,
			 					"drugAdmId"		: 	item.HGSTR_DRUG_ADMIN_ID ,
			 					"drugRouteId"	:	item.HGNUM_DRUG_ROUTE_ID ,
			 					"drugRouteName"	:	item.HGSTR_DRUG_ROUTE_NAME
			 					
			 			}
						console.log("drugjson--"+JSON.stringify(DrugJson));
						
						var drugHtmlInputt = '',drugHtmlRevokeBtn='';
						/*if(episodeCode===item.HRGNUM_EPISODE_CODE && visitNo===item.HRGNUM_VISIT_NO)
						{
							drugHtmlInputt = "disabled";
						}
						else
						{
							drugHtmlInputt = "";
							//drugHtmlInput ="";
						}*/
						
						if($('#isAdmittedHiddenValId').val()=='18')
							drugHtmlRevokeBtn = "disabled";
						else
							drugHtmlRevokeBtn = "";
						
						console.log('drugHtmlInput2 '+drugHtmlInputt);
						var drugAdmName='';
						switch(item.HGSTR_DRUG_ADMIN_ID){
							case "1":
								drugAdmName = "Before Breakfast";
								break;
							case "2":
								drugAdmName = "After Breakfast";
								break;
							case "3":
								drugAdmName = "Before Lunch";
								break;
							case "4":
								drugAdmName = "After Lunch";
								break;
							case "5":
								drugAdmName = "Before Dinner";
								break;
							case "6":
								drugAdmName = "After Dinner";
								break;
							default:
								drugAdmName = "";
							}
						var drugInst = item.HRGSTR_REMARKS.trim()+'$'+item.HGSTR_DRUG_ROUTE_NAME+'$'+drugAdmName;
						
						let drugValFunc = "onclick='openRevokeDrugModal(\""+chckDrugVal+"\",\""+index+"\")'";
						
						$('.drugsAdvicesAdded').parent().find('.table').children('tbody').append('<tr class="moreToggleDrugAdvice" style="display:none" id="trDrug'+index+'"> <td><input type="checkbox" class="checkedInput" name="drugsAdvices"  '+drugHtmlInputt +' value="'+chckDrugVal+'" ><i class="text1" style="display :none">'+JSON.stringify(DrugJson)+' </i></td><td>'+item.HSTSTR_ITEMBRAND_NAME+'</td><td>'+item.HGSTR_DOSE_NAME+'</td><td>'+strfrequnctName+'</td><td>'+item.HRGDT_START_DATE+'</td><td>'+item.HGNUM_DAYS+'</td><td>'+item.HGNUM_DOSE_QTY+'</td><td><a  class="drugAdvicesInstructionsModalBtn" style="color: #109f1c" drugInstructions="'+drugInst+'" onclick="$(\'#drugAdvicesInstructionsModal3\').modal(\'show\');">'+item.HRGSTR_REMARKS.substring(0, 4)+'..'+'</a></td><td><button class="btn btn-xs drugEditBtn" type="button" '+drugHtmlInputt +' ><i class="fa fa-edit"></i></button></td><td><button class="btn btn-xs drugRevokeBtn" type="button" '+drugValFunc +' id="drugRevokeBtnId" '+drugHtmlRevokeBtn+'><i class="fa fa-times" style="color:red"></i></button></td><td><button class="btn btn-xs monogrambtn" type="button" data-toggle="modal" data-target="CimsMonographId"><i class="fas fa-capsules" style="color: Crimson;"></i></button>&nbsp;&nbsp;&nbsp;&nbsp;<button class="btn btn-xs Genericbarndbtn" type="button" data-toggle="modal" data-target="GenericMonogramId"><i class="fas fa-tablets" style="color: DeepSkyBlue;"></i></button></td></tr>');  
						
						if(drugHtmlInputt == "disabled")
						{
							tippy('.moreToggleDrugAdvice', {
								  content: "This medicine has already been prescribed today for issuance to pharmacy, pls refer past rx for detail",
								  delay: 50,
					              arrow: true,
					              arrowType: 'round',
					              size: 'medium',
					              duration: 500,
					              animation: 'scale'
								});
						}

						  $('.drugAdvicesInstructionsModalBtn').click(function(){ 
							  var drugDtl = $(this).attr('drugInstructions').split('$');
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugAdmIns').text(drugDtl[2]);
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugRouteIns').text(drugDtl[1]);
				   			   $('#drugAdvicesInstructionsModal3 .modal-body #drugRmrkIns').text(drugDtl[0]);
						});
						  $('.drugEditBtn').click(function(){
							  
							  console.log(item.HSTNUM_ITEM_ID == 100);
							  console.log('::::::::::::::::'+item.HSTNUM_ITEM_ID);
							  
							    if($('input[name=drugName]').val()!='')
							    	return false;
							    	if(item.HSTNUM_ITEM_ID == 100){
							    	
							    	var drugName = $(this).parent().parent().find('td').eq(1).text();
							 		var drugDosage = $(this).parent().parent().find('td').eq(2).text();
							 		var drugFrequency = $(this).parent().parent().find('td').eq(3).text(); 
							 		var drugStartDate = $(this).parent().parent().find('td').eq(4).text(); 
							 		var drugDays = $(this).parent().parent().find('td').eq(5).text(); 
							 		var drugQuantity = $(this).parent().parent().find('td').eq(6).text(); 
							 		var instructions = $(this).parent().parent().find('td').eq(7).text(); 
							 		
							 		$(this).parent().parent().remove();
							 		$('input[name=externalDrugName]').val(drugName);
							 		/*$('select[name=drugDosage]').val(drugDosage);*/
							 		$('select[name=externalDrugDosage]').val($('select[name=externalDrugDosage] option:contains('+drugDosage+')').val());
							 		$('select[name=externalDrugFrequency]').val($('select[name=externalDrugFrequency] option:contains('+drugFrequency+')').val());
							 		$('input[name=externalDrugStartDate]').val(drugStartDate); 
							 		$('input[name=externalDrugDays]').val(drugDays);
							 		$('input[name=externalDrugQuantity]').val(drugQuantity); 
							 		$('textarea[name=externalDrugInstructions]').val(instructions); 
							 		$('input[name=externalDrugName]').focus();
							    } else{
							    	
							    	var drugName = $(this).parent().parent().find('td').eq(1).text();
							 		var drugDosage = $(this).parent().parent().find('td').eq(2).text();
							 		var drugFrequency = $(this).parent().parent().find('td').eq(3).text(); 
							 		var drugStartDate = $(this).parent().parent().find('td').eq(4).text(); 
							 		var drugDays = $(this).parent().parent().find('td').eq(5).text(); 
							 		var drugQuantity = $(this).parent().parent().find('td').eq(6).text(); 
							 		var instructions = $(this).parent().parent().find('td').eq(7).text(); 
							 		
							 		$(this).parent().parent().remove();
							 		$('input[name=drugName]').val(drugName);
							 		/*$('select[name=drugDosage]').val(drugDosage);*/
							 		$('select[name=drugDosage]').val($('select[name=drugDosage] option:contains('+drugDosage+')').val());
							 		$('select[name=drugFrequency]').val($('select[name=drugFrequency] option:contains('+drugFrequency+')').val());
							 		$('input[name=drugStartDate]').val(drugStartDate); 
							 		$('input[name=drugDays]').val(drugDays);
							 		$('input[name=drugQuantity]').val(drugQuantity); 
							 		$('textarea[name=drugInstructions]').val(instructions); 
							 		//$('input[name=drugName]').focus();
							 		//return false;
							    }
							});   
						  
						  //$('.monogrambtn').click(function(){
						  $(this).on("click", ".monogrambtn", function() {
					   		  var data1=$(this).parent().parent().find('.checkedInput').val();
					   		var ref_id= item.HSTSTR_CIMS_GUID ;
					   		   console.log(data1); 
					   		  
					   		  $.ajax({
					   		  	url: "/HISDRDESK_MC/services/restful/cims/getMonographCimsData",
					   		  	dataType: "text",
					   		  	type: "POST",
					   		  	async: false,
					   		  	 crossDomain:true,
					   		  	data: {
					   		  		data: '"' + ref_id +'"' ,
					   		  		cimstype : item.HSTSTR_CIMSTYPE
					   		  	},
					   		  	success: function(data) {
					   		  		console.log(data);
					   		  		$('#MonographResponse').html(data);
					   		  		$("#CimsMonographId").modal();
					   		  //	false ;
					   		  	},
					   		  	error: function(XMLHttpRequest, textStatus, errorThrown) {
					   		  		alert(errorThrown);
					   		  	}
					   		  });
					   		 });
						  
						  
						  $('.Genericbarndbtn').click(function(){

					   		//  var data1=$(this).parent().parent().find('.checkedInput').val();
						   		var ref_id= item.HSTNUM_SCT_CONCEPTID ;

					   		  $.ajax({
					   		  	url: "http://aiimsmanglagiri.uat.dcservices.in/dis/generic/"+ref_id,
					   		  	dataType: "json",
					   		  	type: "GET",
					   		  	async: false,
					   		  	 crossDomain:true, 
					   		  	success: function(data) {
					   		  		console.log(data);
					   		  		/* var myJSON = JSON.stringify(data); */
					   		  	 var html1 ='';
					   		  		for (var i=0; i<data.length; i++) {
					   		  		html1 = '<div class="row"><div class="col-sm-12 genericDesc">' + data[i].genericDescriptions[1].genericName+ '</div></div><div class="row">';
					   		        		
					   		        		for (var j=0; j<data[i].drugTypes.length; j++) {
					   		        			html1 =html1+'<div class="col-sm-12 drugTypeName">' + data[i].drugTypes[j].typeName + '&nbsp; | &nbsp; </div>'  ; 
					   		        		}
					   		        		
					   		        		html1 =html1+'</div><br /><div class="row"><div class="col-sm-6"><strong style="color:blue">Dose Form:&nbsp;&nbsp;</strong> '+ data[i].doseForm +' ';
					   		        		html1 =html1+'</div><div class="col-sm-6"><strong style="color:blue">Route Of Administration:&nbsp;&nbsp;</strong>'+data[i].routeOfAdministration + '</div></div>' ;
					   		        		html1 =html1+'<br /><div class="row"><div class="col-sm-12"><strong style="color:blue">ContraIndications:&nbsp;&nbsp;</strong>'+ data[i].contraIndications + '' ;
					   		        		html1 =html1+'</div></div><br /><div class="row"><div class="col-sm-12"><strong style="color:blue">Indications:&nbsp;&nbsp;</strong>'+ data[i].indications + '</div></div>' ;
					   		       
					   		        $('#GenericMonogramResponse').append(html1);
					   		    }
					   		    console.log(html1);

					   		    
					   		  		$('#GenericMonogramResponse').html(html1);  
					   		  		$("#GenericMonogramId").modal();
					   		  		
					   		  	},
					   		  	error: function(XMLHttpRequest, textStatus, errorThrown) {
					   		  		//alert(errorThrown);
					   		  	    //alert(XMLHttpRequest.responseText);
					   		  	alert("Description Not Mapped By SNOMEDCT");
					   		  	}
					   		  });
					   		  
					   		 });
					}
				});
				
				if(flag == 1)
				{
				      $('.drugsAdvicesAdded').parent().append('<a style="text-decoration:none" class="btn btn-link drugAdviceAddedMoreViewBtn">More...</a>');				
					  $('.drugAdviceAddedMoreViewBtn').click(function(){
						  $(this).text(function (i, oldText) {            
							    return oldText == "Less..." ? "More..." : "Less...";      
							  });
						  $('.moreToggleDrugAdvice').fadeToggle('fast');
					  });				
				}
				 
			}
			console.log(result.VISTREASON);
			/*console.log('::::::::::::');
			console.log(result.VISTREASON);
			console.log(result.VISTREASON[0]);
			console.log(result.VISTREASON[0].HSTTR_REASONOFVISIT);*/
			
			
			if(result.VISTREASON)	
			if(result.VISTREASON!=null)
			{
				var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					console.log(item.HSTTR_REASONOFVISIT);
					
					
					var str=(item.HSTTR_REASONOFVISIT).replace("[", "");
					str=str.replace(']','');
					var temp= (str).split(',');
					
					/*item.HSTTR_REASONOFVISIT.forEach(function(it)
					{
						console.log(':::::::::::'+it.val());
					}		
					);*/
					
					for(var i=0 ; i<temp.length;i++)
						{
						console.log(':::::::::::'+temp[i]);
						
					if(temp[i]!='')
					{
						var x=temp[i].split('^')[2];
						console.log('Side::::::'+x);
						switch (parseInt(x)) {
						  case 0:
						    text = "Side";
						    break;
							case 1:
						    text = "NR";
						    break;
							case 2:
						    text = "Left";
						    break;
							case 3:
						    text = "Right";
						    break;
							case 4:
						    text = "Bilateral";
						    break;
							default:
						    text = "No value found";
						} 
						var y=temp[i].split('^')[4];
						switch (parseInt(y)) {
						  case 0:
						    text1 = "";
						    break;
							case 1:
						    text1 = "Days";
						    break;
							case 2:
						    text1 = "Weeks";
						    break;
							case 3:
						    text1 = "Months";
						    break;
							case 4:
						    text1 = "Years";
						    break;
							default:
						    text1 = "No value found";
						}

						console.log(text);
						var tmp='';
						if(temp[i].split('^')[4] != 0 && temp[i].split('^')[2] != 0)
						tmp=text+'['+ temp[i].split('^')[3] +text1 + ']';
						else if(temp[i].split('^')[4] != 0)
							tmp='['+ temp[i].split('^')[3] +text1 + ']';
						else if(temp[i].split('^')[2] != 0)
							tmp=text ;
						
						if(temp[i].split('^')[5] !='')
							tmp =tmp +  temp[i].split('^')[5] ;
						
						var tempWidth = 0;
						$('.reasonOfVisitAdded').find('a').each(function(index){
							tempWidth+=$(this).width();
						});
						if(tempWidth > ($('.reasonOfVisitAdded').width()-250))
						{
							
							flag=1;
							
							var chiefComplaintJson ={
									"IsExternalVisit"	:			"1" ,
									"VisitReasonName" : 		 	temp[i].split('^')[1],
									"VisitReasonCode" :			 	temp[i].split('^')[0],
									"VisitReasonSideCode" : 		 temp[i].split('^')[2] ,
									"VisitReasonSideName" :			text,
									"VisitReasonNoOfDays" : 	 	temp[i].split('^')[3] ,
									"VisitComplaintDurationCode" : temp[i].split('^')[4],
									"VisitComplaintDurationName" : text1,
									"VisitReasonRemarks"		: 	temp[i].split('^')[5]
								};
								
								console.log(JSON.stringify(chiefComplaintJson));
							//$('.reasonOfVisitAdded').append('<a class="moreToggleVisitReason" style="padding-left:5px;display:none;"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+item.VISITREASON+'"> '+item.VISITREASON+'</label></a>');
							
							$('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleVisitReason"    title='+tmp+' data-toggle="tooltip" >'+
					    	 		'<input type="checkbox" class="checkedInput" name="visitReason" value="'+temp[i]+'">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
					    	 		'<span class="text">'+temp[i].split('^')[1]+' </span>'+
					    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
					    	 		'</button></label>');
						}
						else
							{
							var chiefComplaintJson ={
									"IsExternalVisit"	:			"1" ,
									"VisitReasonName" : 		 	temp[i].split('^')[1],
									"VisitReasonCode" :			 	temp[i].split('^')[0],
									"VisitReasonSideCode" : 		 temp[i].split('^')[2] ,
									"VisitReasonSideName" :			text,
									"VisitReasonNoOfDays" : 	 	temp[i].split('^')[3] ,
									"VisitComplaintDurationCode" : temp[i].split('^')[4],
									"VisitComplaintDurationName" : text1,
									"VisitReasonRemarks"		: 	temp[i].split('^')[5]
								};
								
								console.log(JSON.stringify(chiefComplaintJson));
								
							$('.reasonOfVisitAdded').append('<label><button  tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleVisitReason tooltipcss "   title='+tmp+' data-toggle="tooltip"  >'+
					    	 		'<input type="checkbox" class="checkedInput" checked name="visitReason" value="'+temp[i]+'">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
					    	 		'<span class="text" id="respRateIdValue"  >'+temp[i].split('^')[1]+' </span>'+
					    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
					    	 		'</button></label>');
							//$('[data-toggle="tooltip"]').tooltip();
							}
							//$('.reasonOfVisitAdded').append('<a style="padding-left:5px"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+item.VISITREASON+'"> '+item.VISITREASON+'</label></a>');
						
							

					}
				}
				});

				if(flag==1)
				{
					$('.reasonOfVisitAdded').parent().prepend('<a style="text-decoration:none;float:right" class="btn btn-link reasonOfVisitAddedMoreViewBtn">more..</a>');					
/*					$('.reasonOfVisitAdded').parent().parent().find('div').eq(1).append('<a style="text-decoration:none" class="btn btn-link reasonOfVisitAddedMoreViewBtn">more..</a>');*/					
					$('.reasonOfVisitAddedMoreViewBtn').click(function(){
						$('.reasonOfVisitAdded .moreToggleVisitReason').fadeToggle('fast');
						$(this).hide();
					});
				}
				$('[data-toggle="tooltip"]').tooltip();
			}
			if(result.VISTREASON)
			if(result.VISTREASON!=null)
			{
				//var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					//var strrefcount=0;
					var clinicalProcValue= '' ;
					console.log('test refferal data '+item.HRSTR_JSON_DATA.strClinicalProcedure.length);
					for(var q=0 ; q< item.HRSTR_JSON_DATA.strClinicalProcedure.length;q++)
					{
						
						
						var test1=item.HRSTR_JSON_DATA.strClinicalProcedure[q] ;
						console.log('test1test1test1test1test1'+test1);
						
						var ClinicalProcedureJson = {
	 							"IsExternal"  			:  "0" ,
	 							"ProceduresName"		:	test1.split('#')[0] ,
	 							"ProcedureCode"			:	test1.split('#')[1] ,
	 							"ProcedureSideCode"		:	test1.split('#')[2] ,
	 							"ProcedureSideName"		:	test1.split('#')[3] ,
	 							"ProcedureSideRemarks"	:	test1.split('#')[4] ,
	 							"ServiceAreaCode"		:	test1.split('#')[5] ,
	 							"ServiceAreaName"		:	test1.split('#')[6] 
	 					}
						if(test1.split('#').length == 7){
							
							clinicalProcValue =test1.split('#')[0]+'#'+test1.split('#')[1]+'#'+test1.split('#')[2]+'#'+test1.split('#')[3]+'#'+test1.split('#')[4]+'#'+test1.split('#')[5]+'#'+test1.split('#')[6];
							var clinicalProcedureVal=test1.split('#')[0];
							
							var temp='';
		 					if(clinicalProcedureVal !='' && test1.split('#')[2] !='0'){
		 						temp= '[' +  test1.split('#')[3] + ']'  ;
		 					}
		 					if(test1.split('#')[4] != '' ){
		 						temp=temp + test1.split('#')[4] ;
		 					}
		 					var servicename=test1.split('#')[6] ; 
							$('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs"   data-toggle="tooltip" title="'+ temp +'" >'+
		 			    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+clinicalProcValue+'" >  '+
		 			    	 		'<i class="" style="display :none">'+JSON.stringify(ClinicalProcedureJson)+' </i>'+
		 			    	 		'<span class="text">'+servicename+' ['+clinicalProcedureVal+']'+' </span>'+
		 			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		 			    	 		'</button></label>');
							
							
						}else{
							clinicalProcValue =test1.split('#')[0]+'#'+test1.split('#')[1]+'#'+test1.split('#')[2]+'#'+test1.split('#')[3]+'#'+test1.split('#')[4];
							var clinicalProcedureVal=test1.split('#')[0];
							
							var temp='';
		 					if(clinicalProcedureVal !='' && test1.split('#')[2] !='0'){
		 						temp= '[' +  test1.split('#')[3] + ']'  ;
		 					}
		 					if(test1.split('#')[4] != '' ){
		 						temp=temp + test1.split('#')[4] ;
		 					}
		 					
							$('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs"   data-toggle="tooltip" title="'+ temp +'" >'+
		 			    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+clinicalProcValue+'" >  '+
		 			    	 		'<i class="" style="display :none">'+JSON.stringify(ClinicalProcedureJson)+' </i>'+
		 			    	 		'<span class="text">'+clinicalProcedureVal+' </span>'+
		 			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		 			    	 		'</button></label>');
						}
						
					}
				});
			}	
			/*if(result.VISTREASON!=null)
			{
				var str1 = '';
				result.VISTREASON.forEach(function(item){ 
					var strrefcount=0;
					console.log('test refferal data '+item.HRSTR_JSON_DATA.strChronicDisease.length);
					for(var q=0 ; q< item.HRSTR_JSON_DATA.strChronicDisease.length;q++)
					{
					
						var hiddenField=item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseName+'^'+item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseId+'^'+item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseDuration+'^'+item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseRemarks;
				      var remarks= item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseRemarks ;
						if(item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseName.trim()!='' && duration.trim()!='' && remarks.trim()!=''){
					          str1='<tr>'+
					          '<td><input type="checkbox"  class="chronicDiseaseChkAll" name="chronicDiseaseChk" value="'+hiddenField+'"></td>'+
					          '<td>'+item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseName+'</td>'+
					          '<td>'+item.HRSTR_JSON_DATA.strChronicDisease[q].CronicDiseaseDuration+'</td>';
					          
					          if(remarks!=''){
					            str1+='<td><a class="chronicDiseaseInstructionsModalBtn" style="color: #109f1c" chronicDiseaseInstructions="'+remarks+'" onclick="$(\'#chronicDiseaseInstructionsModal .modal-body p\').text($(this).attr(\'chronicDiseaseInstructions\'));$(\'#chronicDiseaseInstructionsModal\').modal(\'show\');">'+remarks.substring(0, 4)+'..'+'</a></td>';
					          }
					          else{
					        	  str1+='<td></td>';
					          }
					
					          str1+='<td><button class="btn btn-xs btn-danger chronicDiseaseRemoveRow" type="button" onclick="$(this).parent().parent().remove();" id="removeBtnId2" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button></td> </tr>';
					
					}
						$('#chronicDiseaseListTable').parent().find('.table').children('tbody').append(str1);
				}
			}) ;
		}*/
			if(result.CHRONICDISEASE)
			if(result.CHRONICDISEASE!=null)
			{
				var str1 = '';
				result.CHRONICDISEASE.forEach(function(item){ 
					var strrefcount=0;
					console.log('test refferal data '+item.HGSTR_ALERT_NAME);
						var hiddenField=item.HGSTR_ALERT_NAME+'^'+item.HGNUM_PAT_ALERT_ID+'^'+item.HRGDT_DURATION_YEARS+'^'+item.HBSTR_REMARKS;
				      var remarks= item.HBSTR_REMARKS ;
						if(item.HGSTR_ALERT_NAME.trim()!=''){
					          str1='<tr>'+
					          '<td><input type="checkbox"  class="chronicDiseaseChkAll" name="chronicDiseaseChk" value="'+hiddenField+'"></td>'+
					          '<td>'+item.HGSTR_ALERT_NAME.trim()+'</td>'+
					          '<td>'+item.HRGDT_DURATION_YEARS.trim()+'</td>';
					          
					          if(remarks!=''){
					            str1+='<td><a class="chronicDiseaseInstructionsModalBtn" style="color: #109f1c" chronicDiseaseInstructions="'+remarks+'" onclick="$(\'#chronicDiseaseInstructionsModal .modal-body p\').text($(this).attr(\'chronicDiseaseInstructions\'));$(\'#chronicDiseaseInstructionsModal\').modal(\'show\');">'+remarks.substring(0, 4)+'..'+'</a></td>';
					          }
					          else{
					        	  str1+='<td></td>';
					          }
					
					          str1+='<td><button class="btn btn-xs btn-danger chronicDiseaseRemoveRow" type="button" onclick="$(this).parent().parent().remove();" id="removeBtnId2" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button></td> </tr>';
					
					}
						$('#chronicDiseaseListTable').parent().find('.table').children('tbody').append(str1);
			}) ;
		}
			if(result.VISTREASON)
			if(result.VISTREASON!=null)
			{
				//var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					var strrefcount=0;
					console.log('test refferal data '+item.HRSTR_JSON_DATA.strReferal.length);
					for(var q=0 ; q< item.HRSTR_JSON_DATA.strReferal.length;q++)
					{
						var reffralJson={
								"strReffralDeptCmb" : item.HRSTR_JSON_DATA.strReferal[q].strReffralDeptCmb ,
								"strReffralDepttext" : item.HRSTR_JSON_DATA.strReferal[q].strReffralDepttext , 
								"strreferralType"    : item.HRSTR_JSON_DATA.strReferal[q].strreferralType ,
								"strreferralTypeName" : item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName ,
								"strReffralReason"   : item.HRSTR_JSON_DATA.strReferal[q].strReffralReason ,
								"strReffralDeptDone" : item.HRSTR_JSON_DATA.strReferal[q].strReffralDeptDone ,
								
								"strExternalHospitalcode" : item.HRSTR_JSON_DATA.strReferal[q].strExternalHospitalcode ,
								"strExternalDepartmentcode"   :  item.HRSTR_JSON_DATA.strReferal[q].strExternalDepartmentcode ,
								"strExternalrefferalInstitutecode" : item.HRSTR_JSON_DATA.strReferal[q].strExternalrefferalInstitutecode ,

								"strExternalHospitalName" : item.HRSTR_JSON_DATA.strReferal[q].strExternalHospitalName ,
								"strExternalDepartmentName"   :  item.HRSTR_JSON_DATA.strReferal[q].strExternalDepartmentName ,
								"strExternalrefferalInstituteName" : item.HRSTR_JSON_DATA.strReferal[q].strExternalrefferalInstituteName ,
								'strOtherAssociateHospitalName'		: item.HRSTR_JSON_DATA.strReferal[q].strOtherAssociateHospitalName ,
								'strShowData'  						: item.HRSTR_JSON_DATA.strReferal[q].strShowData ,
								'strExternalZoneName' 				: item.HRSTR_JSON_DATA.strReferal[q].strExternalZoneName , 								'strExternalZoneId'					: item.HRSTR_JSON_DATA.strReferal[q].strExternalZoneId ,
								'strExternalDivisionName'			: item.HRSTR_JSON_DATA.strReferal[q].strExternalDivisionName ,
								'strExternalDivisionId'				: item.HRSTR_JSON_DATA.strReferal[q].strExternalDivisionId ,
								'strExternalInstituteDays'			: item.HRSTR_JSON_DATA.strReferal[q].strExternalInstituteDays ,
								'strExternalInstituteReasonId'		: item.HRSTR_JSON_DATA.strReferal[q].strExternalInstituteReasonId ,
								'strExternalInstituteReasonName'	: item.HRSTR_JSON_DATA.strReferal[q].strExternalInstituteReasonName ,
								'episodeCode'						: item.HRSTR_JSON_DATA.strReferal[q].episodeCode ,	
								'visitNo'							: item.HRSTR_JSON_DATA.strReferal[q].visitNo 
						} ;
						console.log(reffralJson);
						var datashow=item.HRSTR_JSON_DATA.strReferal[q].strShowData ;
						strrefcount++;
						var tooltipdata ='-';
						if(item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName != 0)
							tooltipdata =item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName
						if(item.HRSTR_JSON_DATA.strReferal[q].strReffralReason != '')
							tooltipdata =item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName +'(' + item.HRSTR_JSON_DATA.strReferal[q].strReffralReason +')';
						//console.log(JSON.stringify((reffralJson.toString()));
						
						var refHtmlInput = '';
						if(episodeCode === item.HRSTR_JSON_DATA.strReferal[q].episodeCode && visitNo === item.HRSTR_JSON_DATA.strReferal[q].visitNo)
						{
							refHtmlInput = "disabled";
						}
						else
						{
							refHtmlInput = "";
							//drugHtmlInput ="";
						}
						
						$('.refferalAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button"  data-toggle="tooltip" title='+ tooltipdata +'  '+ refHtmlInput +' class="value btn btn-xs '+datashow.trim()+'">'+
				    	 		'<input type="checkbox" class="checkedInput" name="referalchk" id="strreferalchkId'+strrefcount+'"  value="" >  '+
				    	 		'<i class="" style="display :none">'+JSON.stringify(reffralJson)+'^OLD</i>'+
				    	 		'<span class="text">'+datashow.trim()+'<sup style="color:red; font-weight:bold;"></sup> </span>'+
				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
				    	 		'</button></label>');
						var temp='#strreferalchkId'+strrefcount;
		                $(temp).val(JSON.stringify(reffralJson));
						
					}
					$('[data-toggle="tooltip"]').tooltip();
				});
			}	
			console.log('::::::::::'+result.DIAGNOSIS);
			if(result.VISTREASON)
			if(result.VISTREASON!=null)
			{
				var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					console.log('::::::::::'+item.HRSTR_JSON_DATA.Diagnosis);
					var str=item.HRSTR_JSON_DATA.Diagnosis;//(item.HSTTR_DIAGNOSIS).replace("[", "");
					//str=str.replace(']','');
					var tmp= str;
					
					for(var i=0 ; i<tmp.length;i++)
					{
						
					if(tmp[i]!='')
					{
						var tempWidth = 0;
						$('.diagnosisAdded').find('a').each(function(index){
							tempWidth+=$(this).width();
						});
						
						
						var a=tmp[i].split('^')[1];
						console.log('aaaaaaaaaa')
						var x=a.split('#')[2];
						switch (parseInt(x)) {
						  case 0:
						    text = "";
						    break;
							case 1:
						    text = "NR";
						    break;
							case 2:
						    text = "Left";
						    break;
							case 3:
						    text = "Right";
						    break;
							case 4:
						    text = "Bilateral";
						    break;
							default:
						    text = "No value found";
						}
						var tooval = '';
						if(x !=0)
							tooval=a.split('#')[1] + '['+text+']' ;
						else
							tooval=a.split('#')[1];
						
						if(tmp[i].split('#')[7] !='' && tmp[i].split('#')[7] !='0')
							tooval=tooval + tmp[i].split('#')[7]  ;
						if(tempWidth > ($('.diagnosisAdded').width()-250))
						{
							flag=1;
							//$('.diagnosisAdded').append('<a class="moreToggleDiagnosis" style="padding-left:5px; display:none;"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DIAGNOSTICTYPENAME+'" value="'+item.DIAGNOSTICCODE+'#'+item.DIAGNOSTICTYPECODE+'"> '+item.DIGNOSISNAME+'</label></a>');
							
							
							var DiagnosisJson ={
	 		 						"IsSnomed"				:			"1" ,
	 								"DiagnosisName" 		: 		 	(tmp[i].split('#')[2]).split('^')[1],
	 								"DiagnosisCode" 		:			tmp[i].split('#')[0],
	 								"DiagnosisSideCode" 	: 			tmp[i].split('#')[4] ,
	 								"DiagnosisSideName" 	:			text,
	 								"DiagnosisTypeCode" 	: 	 		tmp[i].split('#')[1] ,
	 								"DiagnosisTypeNamee" 	: 			"",
	 								"DiagnosisRemarks"	:				tmp[i].split('#')[7]
	 							};
	 							
	 		 				console.log(JSON.stringify(DiagnosisJson));
	 		 				
							$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700; display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis" title='+tooval+' data-toggle="tooltip">'+
					    	 		'<input type="checkbox" class="checkedInput" checked diagnosisname="'+tmp[i].split('#')[3]+'" name="diagnosisAdded" value="'+tmp[i]+'">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
					    	 		'<span class="text">'+(tmp[i].split('#')[2]).split('^')[1]+' </span>'+
					    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
					    	 		'</button></label>');
						}
						else{
							//$('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisname="'+item.DIAGNOSTICTYPENAME+'" value="'+item.DIAGNOSTICCODE+'#'+item.DIAGNOSTICTYPECODE+'"> '+item.DIGNOSISNAME+'</label></a>'); 						
							
							var DiagnosisJson ={
	 		 						"IsSnomed"				:			"1" ,
	 								"DiagnosisName" 		: 		 	(tmp[i].split('#')[2]).split('^')[1],
	 								"DiagnosisCode" 		:			tmp[i].split('#')[0],
	 								"DiagnosisSideCode" 	: 			tmp[i].split('#')[4] ,
	 								"DiagnosisSideName" 	:			text,
	 								"DiagnosisTypeCode" 	: 	 		tmp[i].split('#')[1] ,
	 								"DiagnosisTypeNamee" 	: 			"",
	 								"DiagnosisRemarks"	:				tmp[i].split('#')[7]
	 							};
	 							
	 		 				console.log(JSON.stringify(DiagnosisJson));
	 		 				
							$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleDiagnosis" title='+tooval+' data-toggle="tooltip">'+
				    	 		'<input type="checkbox" class="checkedInput" checked name="diagnosisAdded" diagnosisname="'+tmp[i].split('#')[3]+'" value="'+tmp[i]+'">  '+
				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
				    	 		'<span class="text">'+(tmp[i].split('#')[2]).split('^')[1]+' </span>'+
				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
				    	 		'</button></label>');
						}
					}
				}
					if(result.VISTREASON)
					if(result.VISTREASON!=null)
					{
						//var flag = 0;
						result.VISTREASON.forEach(function(item){ 
							//var strrefcount=0;
							if(item.HRSTR_JSON_DATA.OtDtl!=undefined)
							{
							console.log('OtDtl '+item.HRSTR_JSON_DATA.OtDtl.length);
							for(var q=0 ; q< item.HRSTR_JSON_DATA.OtDtl.length;q++)
							{ 
								if(item.HRSTR_JSON_DATA.OtDtl[q]!= '')
								{
									var tmpDate = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[0].trim();
									var operationId = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[1].trim();
									var operation = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[2].trim();
									var surgeonId = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[3].trim();
									var surgeon = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[4].trim();
									var optFindings = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[5].trim()!=''?item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[5].trim():' ';
									var complication = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[6].trim()!=''?item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[6].trim():' ';
									var implant = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[7].trim()!=''?item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[7].trim():' ';
									var pop = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[8].trim()!=''?item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[8].trim():' ';
									var pohp = item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[9].trim()!=''?item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[9].trim():' ';

								var otJson = {
										"operationDate" : 	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[0].trim() ,
										"operationId"	:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[1].trim() ,
										"operation"		:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[2].trim() ,
										"surgeonId"		:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[3].trim() ,
										"surgeon"		:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[4].trim() ,
										"optFindings"	:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[5].trim() ,
										"complication"	:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[6].trim() ,
										"implant"		:	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[7].trim() ,
										"pop"			: 	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[8].trim() ,
										"pohp"			:  	item.HRSTR_JSON_DATA.OtDtl[q].split('&&')[9].trim()	
								};
								console.log(otJson);
								var hiddenOt = tmpDate+'&&'+operationId+'&&'+operation+'&&'+surgeonId+'&&'+surgeon+'&&'+optFindings+'&&'+complication+'&&'+implant+'&&'+pop+'&&'+pohp;
								console.log('hiddenOt =='+hiddenOt);
								$('#otListTable').children('tbody').append('<tr> <td><input type="checkbox" class="checkedInput" name="otCheck" value="'+hiddenOt+'"><i class="text1" style="display :none">'+JSON.stringify(otJson)+' </i></td><td>'+tmpDate+'</td><td>'+operation+'</td><td>'+surgeon+'</td><td><a class="OtModalBtn" style="color: #109f1c" headerTxt="Findings" otDtlTxt="'+optFindings+'" onclick="$(\'#opertationTheatreModal\').modal(\'show\');">'+optFindings.substring(0, 4)+'..'+'</a></td><td><a class="OtModalBtn" style="color: #109f1c" headerTxt="Complications" otDtlTxt="'+complication+'" onclick="$(\'#opertationTheatreModal\').modal(\'show\');">'+complication.substring(0, 4)+'..'+'</a></td><td><a class="OtModalBtn" style="color: #109f1c" headerTxt="Implant" otDtlTxt="'+implant+'" onclick="$(\'#opertationTheatreModal\').modal(\'show\');">'+implant.substring(0, 4)+'..'+'</a></td><td><a class="OtModalBtn" style="color: #109f1c" headerTxt="Pre-op Preparation" otDtlTxt="'+pop+'" onclick="$(\'#opertationTheatreModal\').modal(\'show\');">'+pop.substring(0, 4)+'..'+'</a></td><td><a class="OtModalBtn" style="color: #109f1c" headerTxt="Post-op Hospital Stay Course" otDtlTxt="'+pohp+'" onclick="$(\'#opertationTheatreModal\').modal(\'show\');">'+pohp.substring(0, 4)+'..'+'</a></td></tr>');
								
								$('.OtModalBtn').click(function(){
									  $('#opertationTheatreModal .modal-title').text($(this).attr('headerTxt'));
						  			  $('#opertationTheatreModal .modal-body p').text($(this).attr('otDtlTxt'));
						  		});
								
								
								
								}
							}
						}
						});
					}	
					
					/*if(result.VISTREASON!=null)
					{
						var str1 = '';
						result.VISTREASON.forEach(function(item){ 
							var count1=0;
							console.log('allergy '+item.HRSTR_JSON_DATA.strDrugAllergy.length);
							for(var q=0 ; q< item.HRSTR_JSON_DATA.strDrugAllergy.length;q++)
							{
								var chkBoxId ={
					            		"strAllergyNameCode" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyNameCode ,
					            		"strAllergyName" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyName ,
					            		"strSensivityCode" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strSensivityCode ,
					            		"strSensivityName" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strSensivityName ,
					            		"stDurationTime" : item.HRSTR_JSON_DATA.strDrugAllergy[q].stDurationTime ,
					            		"strAllergysiteName" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergysiteName ,
					            		"strAllergysiteCode" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergysiteCode ,
					            		"strAllergySytmptomsName" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergySytmptomsName ,
					            		"strAllergySytmptomsCode" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergySytmptomsCode ,
					            		"strAllergyRemarks" : item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyRemarks
					            };
					            console.log(chkBoxId);
					            var hiddenField =JSON.stringify(chkBoxId);
								if(item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyName.trim()!=''){
									count1++;
									str1='<tr>'+ 
					                '<td><input type="checkbox" class="allergiesDtlChkAll" id="allergyDtlChkId" name="allergiesDtlChk" value="">'+
									'<i class="text" style="display :none">'+hiddenField+' </i></td>'+
					                '<td>'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyName.trim()+'</td>'+
					                '<td>'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strSensivityName.trim()+'</td>'+
					                '<td>'+item.HRSTR_JSON_DATA.strDrugAllergy[q].stDurationTime.trim()+'</td>'+
					                '<td>'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergySytmptomsName.trim()+'</td>'+
					                '<td>'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergysiteName.trim()+'</td>';
					        	  
					                if(item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyRemarks.trim()!=''){
					                	str1+='<td><a class="allergiesDtlInstructionsModalBtn" style="color: #109f1c" allergyInstructions="'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyRemarks.trim()+'" onclick="$(\'#allergiesDtlInstructionsModal .modal-body p\').text($(this).attr(\'allergyInstructions\'));$(\'#allergiesDtlInstructionsModal\').modal(\'show\');">'+item.HRSTR_JSON_DATA.strDrugAllergy[q].strAllergyRemarks.trim().substring(0, 4)+'..'+'</a></td>';
					                }
					                else{
					                	str1+='<td></td>';
					                }

					                str1+='<td><button class="btn btn-xs btn-danger allergiesDtlRemoveRow" type="button" onclick="$(this).parent().parent().remove();" id="removeBtnId2" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button></td>'+
					                '<i class="text" style="display :none">'+hiddenField+' </i></tr>';
					                
					                $('#allergiesDtlListTable').parent().find('.table').children('tbody').append(str1);
					               
							}
								
						}
					}) ;
				}*/
					if(result.ALLEGRY)
					if(result.ALLEGRY!=null)
					{
						var str1 = '';
						result.ALLEGRY.forEach(function(item){ 
							var count1=0;
							console.log('allergy '+item.HGSTR_ALLERGY_NAME);
							var allergySiteName='';
							var allergySiteId='';
							var symptomCode='';
							var symptomName='';
							if(item.HGSTR_ALLERGY_SITE.trim()!=''){
								if(item.HGSTR_ALLERGY_SITE.split("^")[0]!=''){
									allergySiteName = item.HGSTR_ALLERGY_SITE.split("^")[0];
									allergySiteId = item.HGSTR_ALLERGY_SITE.split("^")[1]
								}
								else{
									allergySiteName = item.HGSTR_ALLERGY_SITE.trim();
									allergySiteId = item.HGSTR_ALLERGY_SITE.trim();
								}
							}
							if(item.HGSTR_SYMTOM_DESC.trim()!=''){
								if(item.HGSTR_SYMTOM_DESC.split("^")[0]!=''){
									symptomName = item.HGSTR_SYMTOM_DESC.split("^")[0];
									symptomCode = item.HGSTR_SYMTOM_DESC.split("^")[1]
								}
								else{
									symptomName = item.HGSTR_SYMTOM_DESC.trim();
									symptomCode = item.HGSTR_SYMTOM_DESC.trim();
								}
							}
								var chkBoxId ={
					            		"strAllergyNameCode" : item.HGSTR_ALLERGY_ID ,
					            		"strAllergyName" : item.HGSTR_ALLERGY_NAME ,
					            		"strSensivityCode" : item.HGNUM_SENSITIVITY_CODE ,
					            		"strSensivityName" : item.HGSTR_ALLERGY_TYPE ,
					            		"stDurationTime" : item.HRGDT_DURATION_YEARS ,
					            		"strAllergysiteName" : allergySiteName ,
					            		"strAllergysiteCode" : allergySiteId ,
					            		"strAllergySytmptomsName" : symptomName ,
					            		"strAllergySytmptomsCode" : symptomCode ,
					            		"strAllergyRemarks" : item.HGSTR_ADVICE
					            };
					            console.log(chkBoxId);
					            var hiddenField =JSON.stringify(chkBoxId);
								if(item.HGSTR_ALLERGY_NAME.trim()!=''){
									count1++;
									str1='<tr>'+ 
					                '<td><input type="checkbox" class="allergiesDtlChkAll" id="allergyDtlChkId" name="allergiesDtlChk" value="">'+
									'<i class="text" style="display :none">'+hiddenField+' </i></td>'+
					                '<td>'+item.HGSTR_ALLERGY_NAME.trim()+'</td>'+
					                '<td>'+item.HGSTR_ALLERGY_TYPE.trim()+'</td>'+
					                '<td>'+item.HRGDT_DURATION_YEARS.trim()+'</td>'+
					                '<td>'+symptomName.trim()+'</td>'+
					                '<td>'+allergySiteName.trim()+'</td>';
					        	  
					                if(item.HGSTR_ADVICE.trim()!=''){
					                	str1+='<td><a class="allergiesDtlInstructionsModalBtn" style="color: #109f1c" allergyInstructions="'+item.HGSTR_ADVICE.trim()+'" onclick="$(\'#allergiesDtlInstructionsModal .modal-body p\').text($(this).attr(\'allergyInstructions\'));$(\'#allergiesDtlInstructionsModal\').modal(\'show\');">'+item.HGSTR_ADVICE.trim().substring(0, 4)+'..'+'</a></td>';
					                }
					                else{
					                	str1+='<td></td>';
					                }

					                str1+='<td><button class="btn btn-xs btn-danger allergiesDtlRemoveRow" type="button" onclick="$(this).parent().parent().remove();" id="removeBtnId2" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button></td>'+
					                '<i class="text" style="display :none">'+hiddenField+' </i></tr>';
					                
					                $('#allergiesDtlListTable').parent().find('.table').children('tbody').append(str1);
					               
							}
					}) ;
				}
					//console.log('hoplCrsVisitDate::::::::::'+item.HRSTR_JSON_DATA.hoplCrsVisitDate);
					console.log('courseNote::::::::::'+item.HRSTR_JSON_DATA.courseNote);
					if(item.HRSTR_JSON_DATA.courseNote!='')
						$('#courseNote').val(item.HRSTR_JSON_DATA.courseNote);
					
					console.log('insTreatNote::::::::::'+item.HRSTR_JSON_DATA.insTreatNote);
					if(item.HRSTR_JSON_DATA.insTreatNote!='')
						$('#insTreatNote').val(item.HRSTR_JSON_DATA.insTreatNote);
					
					if(item.HRSTR_JSON_DATA.strHistoryOfPresentIllNess!='')
						$('#hopiId').val(item.HRSTR_JSON_DATA.strHistoryOfPresentIllNess);
					
					if(item.HRSTR_JSON_DATA.strCompleteHistory.strpastHistory!='')
						$('#pastHistoryId').val(item.HRSTR_JSON_DATA.strCompleteHistory.strpastHistory);
					
					if(item.HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory!='')
						$('#personalHistoryId').val(item.HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory);
					
					if(item.HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory!='')
						$('#familyHistoryId').val(item.HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory);
					
					if(item.HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory!='')
						$('#treatmentHistoryId').val(item.HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory);
					
					if(item.HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory!='')
						$('#surgicalHistoryId').val(item.HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory);
					
					if(item.HRSTR_JSON_DATA.strpiccle.strpallor == 1)
						 $("#pallorId").prop("checked", true)
						 
					if(item.HRSTR_JSON_DATA.strpiccle.stricterus == 1)
						 $("#icterusId").prop("checked", true)
						 
					if(item.HRSTR_JSON_DATA.strpiccle.strcyanosis == 1)
						 $("#cyanosisId").prop("checked", true)
						 
					if(item.HRSTR_JSON_DATA.strpiccle.strclubbing == 1)
						 $("#clubbingId").prop("checked", true)
						 
					if(item.HRSTR_JSON_DATA.strpiccle.striymphadenopathyId == 1)
						 $("#iymphadenopathyId").prop("checked", true)	 
						 
					if(item.HRSTR_JSON_DATA.strpiccle.stredema == 1)
						$("#edemaID").prop("checked", true)
						
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strcvs!='')
						$('#cvsId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strcvs);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strrs!='')
						$('#rsId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strrs);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strcns!='')
						$('#cnsId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strcns);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strpA!='')
						$('#pAId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strpA);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn!='')
						$('#otherExamnId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn!='')
						$('#muscularExamnId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn);
					
					if(item.HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn!='')
						$('#LocalExamnId').val(item.HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn);
					
					if(item.HRSTR_JSON_DATA.strInvestgationNote!='')
						$('#investigationNoteId').val(item.HRSTR_JSON_DATA.strInvestgationNote);
					
					if(item.HRSTR_JSON_DATA.strDiagnosisNote!='')
						$('#diagnosisNoteId').val(item.HRSTR_JSON_DATA.strDiagnosisNote);
					
					if(item.HRSTR_JSON_DATA.strtreatmentAdvice!='')
						$('#treatmentAdviceId').val(item.HRSTR_JSON_DATA.strtreatmentAdvice);
					
					if(item.HRSTR_JSON_DATA.strConfidentialsInfo!='')
						$('#ConfidentialInfoId').val(item.HRSTR_JSON_DATA.strConfidentialsInfo);
					
				});
				if(flag==1)
				{
					$('.diagnosisAdded').parent().prepend('<a style="text-decoration:none; float:right" class="btn btn-link disgnosisAddedMoreViewBtn">more..</a>');					
/*					$('.diagnosisAdded').parent().parent().find('div').eq(1).append('<a style="text-decoration:none" class="btn btn-link disgnosisAddedMoreViewBtn">more..</a>');*/					
					$('.disgnosisAddedMoreViewBtn').click(function(){
						$('.diagnosisAdded .moreToggleDiagnosis').fadeToggle('fast');
						/*$(this).hide();*/
					});
				}
				$('[data-toggle="tooltip"]').tooltip();
			}
			if(result.VITALDTLS)
			if(result.VITALDTLS!=null && result.VITALDTLS!=''){
				console.log('Vital Details'+result);
				result.VITALDTLS.forEach(function(item){ 
					
					if(item.HOPLNUM_WEIGHT_VAL != '' && item.HOPLNUM_WEIGHT_VAL !='0' && item.HOPLNUM_WEIGHT_VAL !='0.00' ){
						console.log('true');
						$("#weightIdValue").text(item.HOPLNUM_WEIGHT_VAL +' kgs');
					}else{
						$("#weightpId").hide();
					}
					
					if(item.HOPLNUM_HEIGHT_VAL != '' && item.HOPLNUM_HEIGHT_VAL !='0' && item.HOPLNUM_HEIGHT_VAL !='0.00' )
						$("#heightIdValue").text(item.HOPLNUM_HEIGHT_VAL+' cms');
					else
						$("#heightpId").hide();
					
					if(item.HOPLNUM_BMI_VAL != '' && item.HOPLNUM_BMI_VAL !='0.00' )
						$("#bmiIdValue").text(item.HOPLNUM_BMI_VAL);
					else
						$("#bmipId").hide();
					
					if(item.HOPLNUM_BPSY_VAL !='0.0' && item.HOPLNUM_BPSY_VAL !='' && item.HOPLNUM_BPSY_VAL !='0')
						$("#bloodPressureIdValue").text(item.HOPLNUM_BPSY_VAL+'/'+item.HOPLNUM_BPDIASY_VAL  + ' mm/HG');
					else
						$("#bppid").hide();	
					
					if(item.HOPLNUM_TEMP_VAL !='0' && item.HOPLNUM_TEMP_VAL !='' && item.HOPLNUM_TEMP_VAL !='0.00')
						$("#temperatureIdValue").text(item.HOPLNUM_TEMP_VAL+' F');
					else
						$("#temppid").hide();	
					
					if(item.HOPLNUM_RR_VAL !='0' && item.HOPLNUM_RR_VAL!='' && item.HOPLNUM_RR_VAL!='0.00')
						$("#respRateIdValue").text(item.HOPLNUM_RR_VAL+' br/m');
					else
						$("#rrpid").hide();	
					
					if(item.HOPLNUM_HB_VAL!='0' && item.HOPLNUM_HB_VAL != '' && item.HOPLNUM_HB_VAL!='0.00')
						$("#haemoglobinIdValue").text(item.HOPLNUM_HB_VAL+ ' gm/dL');
					else
						$("#hgbpid").hide();	
					
					if(item.HOPLNUM_SUGARFAST_VAL !='' && item.HOPLNUM_SUGARFAST_VAL!='0' && item.HOPLNUM_SUGARFAST_VAL!='0.00')
						$("#fastingIdValue").text(item.HOPLNUM_SUGARFAST_VAL+' mg/dL');
					else
						$("#bsfastpid").hide();
					
					if(item.HOPLNUM_SUGARPP_VAL!='0' && item.HOPLNUM_SUGARPP_VAL!='' && item.HOPLNUM_SUGARPP_VAL!='0.00')
					$("#ppRateIdValue").text(item.HOPLNUM_SUGARPP_VAL +' mg/dL');
					else
						$("#bspppid").hide();
					
					if(item.HOPLNUM_HBA1C_VAL!='0' && item.HOPLNUM_HBA1C_VAL!='' && item.HOPLNUM_HBA1C_VAL!='0.00' )
					$("#hba1cIdValue").text(item.HOPLNUM_HBA1C_VAL +' %');
					else
						$("#hba1cpid").hide();
					//$("#pulseIdValue").text('');
					
					if(item.HOPLNUM_PULSE_RATE!='0' && item.HOPLNUM_PULSE_RATE!='' && item.HOPLNUM_PULSE_RATE!='0.00')
					$("#pulserateIdValue").text(item.HOPLNUM_PULSE_RATE+ ' be/m');
					else
						$("#pulseratepid").hide();
					
					if(item.HOPLNUM_CURCUMFERENCE_VAL != '' && item.HOPLNUM_CURCUMFERENCE_VAL !='0'  && item.HOPLNUM_CURCUMFERENCE_VAL !='0.00' )
					$("#curcumferenceIdValue").text(item.HOPLNUM_CURCUMFERENCE_VAL+ ' cms');
					else
						$("#curcumferencepid").hide();
					
					if(item.HOPLNUM_MUAC_VAL!='0' && item.HOPLNUM_MUAC_VAL != '' && item.HOPLNUM_MUAC_VAL!='0.00')
					$("#muacIdvalue").text(item.HOPLNUM_MUAC_VAL + ' cms');
					else
						$("#muacpid").hide();
					
					if(item.HOPLSTR_BLOOD_GROUP !='0')
					$("#bloodgroupIdValue").text(item.HOPLSTR_BLOOD_GROUP);
					else
						$("#bloodgrouppid").hide();
					
					/*----------------------added for cancer screening---------------*/
					if(item.HOPLSTR_CANCER_SCREENING !='0')
						$("#cancerScreeningIdValue").text(item.HOPLSTR_CANCER_SCREENING);
						else
							$("#cancerscreeninggid").hide();
					
					if(item.HOPLSTR_SYMPINFO_VAL !='' && item.HOPLSTR_SYMPINFO_VAL !='--')
					$("#otherInfoIdValue").text(item.HOPLSTR_SYMPINFO_VAL);
					else
						$("#pidremarks").hide();
					
					if(item.HOPLSTR_DISABILITY != '')
						$("#DisabilityIdvalue").text(item.HOPLSTR_DISABILITY);
					else
						$("#Disabilityid").hide();
					
					if(item.HOPLSTR_SMOKING != '')
						$("#SmokingIdvalue").text(item.HOPLSTR_SMOKING);
					else
						$("#Smokingid").hide();
					
					if(item.HOPLSTR_ANEMIC != '')
						$("#AnemicIdvalue").text(item.HOPLSTR_ANEMIC);
					else
						$("#Anemicid").hide();
					
					if(item.HOPLSTR_PREGNANCY != '' && item.HOPLSTR_PREGNANCY != '0')
						$("#PregnancyIdvalue").text(item.HOPLSTR_PREGNANCY+"Week");
					else
						$("#Pregnancyid").hide();
					
					
				   //$("#ClassRangeIdValue").text(''+item.HOPLSTR_BMI_CLASSNAME + ' , ' + item.HOPLSTR_RR_CLASSNAME+ ' , '+ item.HOPLSTR_BP_CLASSNAME + ' , '+ item.HOPLSTR_DIABETIC_CLASSNAME + '(B.S. Fast) , '+item.HOPLSTR_HBA1CCLASSNAME + '(HBA1C) , '+item.HOPLSTR_TEMPRETURE_CLASSNAME + ' , ' +item.HOPLSTR_SUGARPP_CLASSNAME + '(B.S. PP) ');
					
					
					$("#bmiIdValue").attr('data-original-title', item.HOPLSTR_BMI_CLASSNAME);
					$("#bloodPressureIdValue").attr('data-original-title', item.HOPLSTR_BP_CLASSNAME);
					$("#respRateIdValue").attr('data-original-title', item.HOPLSTR_RR_CLASSNAME);
					$("#fastingIdValue").attr('data-original-title', item.HOPLSTR_SUGARPP_CLASSNAME);
					$("#hba1cIdValue").attr('data-original-title', item.HOPLSTR_HBA1CCLASSNAME);
					$("#temperatureIdValue").attr('data-original-title', item.HOPLSTR_TEMPRETURE_CLASSNAME);
				
					var strVitalsChart='';
					if(item.HOPLNUM_WEIGHT_VAL != '' && item.HOPLNUM_WEIGHT_VAL !='0' && item.HOPLNUM_WEIGHT_VAL !='0.00' )
						strVitalsChart+='Weight : '+item.HOPLNUM_WEIGHT_VAL +'KG.,';
					
					if(item.HOPLNUM_HEIGHT_VAL != '' && item.HOPLNUM_HEIGHT_VAL !='0' && item.HOPLNUM_HEIGHT_VAL !='0.00' )
						strVitalsChart+=' Height : ' +item.HOPLNUM_HEIGHT_VAL+'CM,';
					
					if(item.HOPLNUM_BMI_VAL != '' && item.HOPLNUM_BMI_VAL !='0' && item.HOPLNUM_BMI_VAL !='0.00' )
						strVitalsChart+=' BMI : ' + item.HOPLNUM_BMI_VAL+'CM,';
					
					if(item.HOPLNUM_BPSY_VAL != '' && item.HOPLNUM_BPDIASY_VAL != '' && item.HOPLNUM_BPSY_VAL !='0' && item.HOPLNUM_BPDIASY_VAL !='0' && item.HOPLNUM_BPSY_VAL !='0.0' && item.HOPLNUM_BPDIASY_VAL !='0.0' )
						strVitalsChart+=' BP :'+ item.HOPLNUM_BPSY_VAL+'/'+item.HOPLNUM_BPDIASY_VAL + 'mmHg,';
					
					if(item.HOPLNUM_TEMP_VAL != '' && item.HOPLNUM_TEMP_VAL !='0' && item.HOPLNUM_TEMP_VAL !='0.00' )
						strVitalsChart+=' Temperature : ' + item.HOPLNUM_TEMP_VAL+'F,';
					
					if(item.HOPLNUM_RR_VAL != '' && item.HOPLNUM_RR_VAL !='0' && item.HOPLNUM_RR_VAL !='0.00' )
						strVitalsChart+=' Respiration Rate : ' + item.HOPLNUM_RR_VAL+'breaths/min,';
					
					if(item.HOPLNUM_HB_VAL != '' && item.HOPLNUM_HB_VAL !='0' && item.HOPLNUM_HB_VAL !='0.00' )
						strVitalsChart+=' Haemoglobin : ' + item.HOPLNUM_HB_VAL+'g/dl,';
					
					if(item.HOPLNUM_SUGARFAST_VAL != '' && item.HOPLNUM_SUGARFAST_VAL !='0' && item.HOPLNUM_SUGARFAST_VAL !='0.00' )
						strVitalsChart+=' B.S. Fast : ' + item.HOPLNUM_SUGARFAST_VAL+'mg/dl,';
					
					if(item.HOPLNUM_SUGARPP_VAL != '' && item.HOPLNUM_SUGARPP_VAL !='0'  && item.HOPLNUM_SUGARPP_VAL !='0.00')
						strVitalsChart+=' B.S. PP : ' + item.HOPLNUM_SUGARPP_VAL+'mg/dl,';
					
					if(item.HOPLNUM_HBA1C_VAL != '' && item.HOPLNUM_HBA1C_VAL !='0' && item.HOPLNUM_HBA1C_VAL !='0.00')
						strVitalsChart+=' HBA1C : ' + item.HOPLNUM_HBA1C_VAL+'mg/dl,';
					
					if(item.HOPLNUM_PULSE_RATE != '' && item.HOPLNUM_PULSE_RATE !='0' && item.HOPLNUM_PULSE_RATE !='0.00')
						strVitalsChart+=' Pulse Rate : ' + item.HOPLNUM_PULSE_RATE+'be/m,';
					
					
					if(item.HOPLSTR_BLOOD_GROUP != '' && item.HOPLSTR_BLOOD_GROUP !='0' )
						strVitalsChart+=' Blood Group : ' + item.HOPLSTR_BLOOD_GROUP+',';
					
					if(item.HOPLSTR_CANCER_SCREENING != '' && item.HOPLSTR_CANCER_SCREENING !='0' )
						strVitalsChart+='Cancer Screening : ' + item.HOPLSTR_CANCER_SCREENING+',';
					
					if(item.HOPLNUM_CURCUMFERENCE_VAL != '' && item.HOPLNUM_CURCUMFERENCE_VAL !='0'  && item.HOPLNUM_CURCUMFERENCE_VAL !='0.00' )
						strVitalsChart+=' Head Circumference : ' + item.HOPLNUM_CURCUMFERENCE_VAL+'CM,';
					
					if(item.HOPLNUM_MUAC_VAL != '' && item.HOPLNUM_MUAC_VAL !='0' && item.HOPLNUM_MUAC_VAL !='0.00' )
						strVitalsChart+=' MUAC : ' + item.HOPLNUM_MUAC_VAL+'CM,';
					
					console.log('item.HOPLSTR_DISABILITY'+item.HOPLSTR_DISABILITY)
					if(item.HOPLSTR_DISABILITY !='')
					strVitalsChart+=' Disability : ' + item.HOPLSTR_DISABILITY;
					if(item.HOPLSTR_SMOKING !='')
					strVitalsChart+=' Smoking : ' + item.HOPLSTR_SMOKING;
					if(item.HOPLSTR_ANEMIC !='')
					strVitalsChart+=' Anemic : ' + item.HOPLSTR_ANEMIC ;
					if(item.HOPLSTR_PREGNANCY != '')
					strVitalsChart+=' Pregnancy : ' + item.HOPLSTR_PREGNANCY ;
					
					if(item.HOPLSTR_SYMPINFO_VAL !='' && item.HOPLSTR_SYMPINFO_VAL !='--')
						strVitalsChart+=' Interpretation/Remarks: : ' + item.HOPLSTR_SYMPINFO_VAL;
					
					console.log('vitalhiddenval::::'+strVitalsChart);
					//var vitalhiddenval= 'Weight : '+item.HOPLNUM_WEIGHT_VAL +'Kg.,' + ' Height : ' +item.HOPLNUM_HEIGHT_VAL+'CM,'+ ' BMI : ' + item.HOPLNUM_BMI_VAL+'CM,' +' BP :'+ item.HOPLNUM_BPSY_VAL+'/'+item.HOPLNUM_BPDIASY_VAL 'g/dl' +' Temperature : '+ item.HOPLNUM_TEMP_VAL+'F' + item.HOPLNUM_RR_VAL+''  + item.HOPLNUM_HB_VAL + item.HOPLNUM_SUGARFAST_VAL + item.HOPLNUM_SUGARPP_VAL + item.HOPLNUM_HBA1C_VAL
					$("#vitalHiddenValId").val(strVitalsChart);
					console.log(item.HOPLNUM_HB_VAL);
				console.log(item.HOPLNUM_WEIGHT_VAL);
				console.log(item.HOPLSTR_CANCER_SCREENING);
				});
				
			}else{
				console.log('Insdie remove:::::::::');
				$("#weightpId").hide();
				$("#heightpId").hide();
				$("#bmipId").hide();
				$("#bppid").hide();
				$("#temppid").hide();	
				$("#rrpid").hide();	
				$("#hgbpid").hide();	
				$("#bsfastpid").hide();
				$("#bspppid").hide();
				$("#hba1cpid").hide();
				$("#pulseratepid").hide();
				$("#curcumferencepid").hide();
				$("#muacpid").hide();
				$("#bloodgrouppid").hide();
				$("#pidremarks").hide();
				$("#Smokingid").hide();
				$("#Disabilityid").hide();
				$("#Anemicid").hide();
				$("#Pregnancyid").hide();
				$("#cancerscreeninggid").hide();/*----------------------added for cancer screening---------------*/
			}
			
			//????
			if(result.REGISTRATIONVISIT)
			if(result.REGISTRATIONVISIT!=null && result.REGISTRATIONVISIT!=''){
				//console.log('test reson of visit detils Details'+JSON.parse(result));
				result.REGISTRATIONVISIT.forEach(function(item){
					$('#ReasonVisitFromRegistrationId').html(item.HRGSTR_VISIT_REASON);
					$('#ReasonVisitFromRegistrationId').show();
				});				}
				
			
			
			if(result.ETELECONSULTANCYVITAL)
			if(result.ETELECONSULTANCYVITAL!=null && result.ETELECONSULTANCYVITAL!=''){
				console.log('ETELECONSULTANCYVITAL Details'+result.ETELECONSULTANCYVITAL);
				result.ETELECONSULTANCYVITAL.forEach(function(item){
					
			/*	setting in vital modal						
					if(item.HRGNUM_PAT_WEIGHT != '' && item.HRGNUM_PAT_WEIGHT !='0' && item.HRGNUM_PAT_WEIGHT !='0.00' ){
						$("#weightpId").show();
						console.log('true weight');
						$("#weightIdValue").text(item.HRGNUM_PAT_WEIGHT +' kgs');
					}else{
						console.log('false weight');
						$("#weightpId").hide();
					}
					
					if(item.HRGNUM_PAT_HEIGHT != '' && item.HRGNUM_PAT_HEIGHT !='0' && item.HRGNUM_PAT_HEIGHT !='0.00' ){
						$("#heightpId").show();
						$("#heightIdValue").text(item.HRGNUM_PAT_HEIGHT+' cms');
					}
					else
						$("#heightpId").hide();
					
					
				  */
					
					
					    var patcomplaintval=''
					    

						if(item.HRGNUM_PAT_WEIGHT != '')
								patcomplaintval =patcomplaintval+'<b> Wt:</b>  ' +item.HRGNUM_PAT_WEIGHT ;
							
						if(item.HRGNUM_PAT_HEIGHT != '')
								patcomplaintval =patcomplaintval+'<b>  Ht :</b>  ' +item.HRGNUM_PAT_HEIGHT ;
												
						
						if(item.HRGSTR_PAT_PASTDIAGNOSIS != '')
							patcomplaintval =patcomplaintval+'<b>  Past Diagnosis :</b>  ' +item.HRGSTR_PAT_PASTDIAGNOSIS;
						
						if(item.HRGSTR_PAT_ALLERGIES != '')
							patcomplaintval =patcomplaintval+'<b>  Allergy :</b>  ' +item.HRGSTR_PAT_ALLERGIES ;
							
						
						if(item.HRGSTR_PAT_MEDICATION != '')
							patcomplaintval =patcomplaintval+'<b>  Medications :</b>  ' +item.HRGSTR_PAT_MEDICATION;
						
						if(item.HRGSTR_REMARKS != '')
							patcomplaintval =patcomplaintval+'<b>  Remarks :</b> ' +item.HRGSTR_REMARKS;
					
					
					console.log('patientcomplaintidValue'+patcomplaintval)
					$("#patientcomplaintidValue").html(patcomplaintval);
					/*else
						$("#heightpId").hide();*/
					
					//patientcomplaintidValue
					
				});
			}else{
				$("#patientcomplaintid").hide();
			}
    	}
	
	
	
	});
	

	
}

function openRevokeDrugModal(obj,index){
	console.log("obj=="+obj);
	  $('#revokeDrugId').val(obj+"^"+index);
	  $('#drugRevokeModal').modal('show');  
}

function saveDrugRevoke()
{
	//$('#drugRevokeModal').modal('hide');
	let drugVal = $("#revokeDrugId").val().split("&&");
	let index = $("#revokeDrugId").val().split("^")[1];
	console.log("drugVal=="+drugVal+" index=="+index);
	var prescJSON = {
			"itemId"			:	drugVal[1].split('#')[0],
			"itemBrandId"		:	drugVal[1].split('#')[4],
			"puk"				:	$('#patCrNoPrescriptionPanel').text(),
			"hospCode"			:	$('#patHospitalCodePrescriptionPanel').text(),
			"admNo"				:	$('#patAdmNoPrescriptionPanel').text(),
			"revokeRemark"		:	$('#strDrugsRevokeRemark').val()
	}
	var data = JSON.stringify(prescJSON); 
	console.log("prescJSON=="+data);
	//return false;
	$.ajax({url:'/HISDRDESK_MC/services/restful/IpdDrDesk/revokeDrugData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
			if(result === 1){
				swal("Drug Revoked Successfully")
				.then((value) => {
					$('#drugRevokeModal').modal('hide');
					$("#trDrug"+index).remove();
				});
			}else{
				swal("Error", "Something Went Worng! ", "error");
				$('#drugRevokeModal').modal('hide');
			}
    	}
	});
}