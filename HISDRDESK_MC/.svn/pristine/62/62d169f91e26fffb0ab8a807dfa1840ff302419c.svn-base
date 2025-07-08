function SaveData(data , FormattedData,e)
{
	//console.log(data);
	
	var checkBox = document.getElementById("strCheckbyDateId");
	if(checkBox.checked == true){
		//console.log('kkkk');
	}
	
	//console.log('111FormattedData'+FormattedData);
	//console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	//console.log('saveCount:::>>'+saveCount); 
	$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveData/',type:'POST',data:{JsonData:data ,FormattedJsonDataArray:FormattedData},success:function(result)
    	{
		
		$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_1').addClass('isAttended_2'); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
	 	$('.savePrescAlert').show();
		$(e).hide();
	
		
		localStorage.removeItem("crc");
		localStorage.removeItem("idForCRC");
		localStorage.removeItem("urlForQR");
		setTimeout(function(){ 
			  $('.savePrescAlert').fadeOut(4000);
			  
		}, 3000);
		
		/*swal("This modal will disappear soon!", {
			  buttons: false,
			  timer: 3000,
			});*/ 
    	} ,
    	 error: function (xhr, ajaxOptions, thrownError) {
    	        alert(xhr.status);
    	        alert(thrownError);
    	  }
    	 
    	
	});
	/*$.ajax({
		  type: "POST",
		  url: "http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/",
		  data: data,
		  success: function (JsonData1) {
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}
function SavePatientReffralData(data,e)
{
	//console.log(data);
	//console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	//console.log('saveCount:::>>'+saveCount); 
	$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
		//console.log('::::saved successfully:::');
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
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}
function SavePrintData(data)
{
	//alert('2');
	//alert(data);
	//console.log(data);
	//console.log('totalCount::::::::><>>>>>>'+totalCount);
	if(saveCount<totalCount)
	saveCount++;
	//console.log('....saveCount:::>>'+saveCount); 
	$('.visitedPatCount').text(saveCount);
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveData/',type:'POST',data:{JsonData:data},success:function(result)
    	{
		//console.log('::::saved successfully:::');
		//console.log(JSON.stringify(result)); 
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
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		  		},
		  dataType: 'json'
		});*/
	
	/*$.post('http://10.226.17.20:8080/HBIMS/services/restful/DrDesk/saveData/',
			{
				JsonData : data
			}).done(
	function (JsonData1) {
				//console.log('::::saved successfully:::');
				alert(JSON.stringify(JsonData1));
		
	});*/
	
}

window.closePopUpIframe = function(){
	$('#printPrescriptionMainDeskModal').modal('hide');$('#printPrescFrameId').remove();
}

window.saveFromIframe = function(data , FormattedData)
{   
	
	data = JSON.stringify(data);
	console.log("json before save>>>" + data);
	FormattedData = JSON.stringify(FormattedData);
	$('#printPrescriptionModal').modal('hide');
	if(saveCount<totalCount)
		saveCount++;
	 
	$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	//alert('before save');
	//console.log('before save call '+  JSON.stringify(data));	
	//return;
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveData/',type:'POST',data:{JsonData:data ,FormattedJsonDataArray:FormattedData},
		success:function(result)
    	{
		
		 localStorage.removeItem("crc");
		 localStorage.removeItem("idForCRC");
		 localStorage.removeItem("urlForQR");
		
		$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_1').addClass('isAttended_2'); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
		var a=$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		////console.log(':::::::::::::::==========::::::::::::::'+a);
		//console.log(patData.PatCompleteGeneralDtl)
		//console.log((patData.PatCompleteGeneralDtl).split('#')[15]);
		var temp= $('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		////console.log('tempashu'+temp);
		//alert(temp);
		////console.log(temp.split('#')[15]);
		if(temp.split('#')[15] == '0' ){
			var patGeneralDtl = $('input[name=patCompleteGeneralDtl]').val();
			var temp=patGeneralDtl.split('#');
			////console.log('patdtls::::::'+patGeneralDtl);
			$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(temp[0]+'#'+temp[1]+'#'+temp[2]+'#'+temp[3]+'#'+temp[4]+'#'+temp[5]+'#'+temp[6]+'#'+temp[7]+'#'+temp[8]+'#'+temp[9]+'#'+temp[10]+'#'+temp[11]+'#'+temp[12]+'#'+temp[13]+'#'+temp[14]+'#1#'+temp[16]+'#'+temp[17]);
			$('.patientListBlock:contains('+patData.CR_No+') td').eq(9).append('<button type="button" class="btn btn-outline-reprint printPrescriptionMainDeskTriggerBtn" onclick="printPrescriptionMainDeskFun(this)">Reprint</button>');	
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
			 $('.savePrescAlert').fadeOut(1500);
			 callQueueStatusUpdateAfterSave(this)
			 hidePrescription(this);
		}, 3000);  
		$('.savePrescAlertOkBtn').click(function(){
			 clearTimeout(timeOut);			
			 $('.savePrescAlert').hide();
			 callQueueStatusUpdateAfterSave(this)
			 hidePrescription(this);
		});
		$('.savePrescAlertCancelBtn').click(function(){
			 clearTimeout(timeOut); 
			 $('.savePrescAlert').hide();
			 callQueueStatusUpdateAfterSave(this);			 
			 hidePrescription(this);
		}); 
		
    	},
    	 error: function(data){
    	        alert("Problem while saving data");
    	  }
    	
	});  
}

window.saveFromIframe1 = function(data , FormattedData) //for same page
{   
	
	data = JSON.stringify(data);
	console.log("json before save  close>>>" + data);
	FormattedData = JSON.stringify(FormattedData);
	$('#printPrescriptionModal').modal('hide');
	if(saveCount<totalCount)
		saveCount++;
	 
	$('.visitedPatCount').text(saveCount);
	var patData = JSON.parse(data);
	//alert('before save');
	//console.log('before save call '+  JSON.stringify(data));	
	//return;
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveData/',type:'POST',data:{JsonData:data ,FormattedJsonDataArray:FormattedData},
		success:function(result)
    	{
			
			
			$('.savePrescAlert').show();
			$('.savePrescAlert').css('top', '5vh');
			$('.savePrescAlertOkBtn').hide();
			$('.msgAlertNxtPatient').hide();
			$('.msgAlertAttendedPatient').show();
			setTimeout(function() {
			  $('.savePrescAlert').hide();
			}, 3000);
			$('.savePrescAlertCancelBtn').click(function(){
				 $('.savePrescAlert').hide();
			});
/*			var timeOut = setTimeout(function(){ 
				 clearInterval(timer);		     
				 $('.savePrescAlert').fadeOut(1500);
				 //callQueueStatusUpdateAfterSave(this)
				// hidePrescription(this);
			}, 3000);*/
		/*
		 localStorage.removeItem("crc");
		 localStorage.removeItem("idForCRC");
		 localStorage.removeItem("urlForQR");
		
		$('.patientListBlock:contains('+patData.CR_No+')').removeClass('isAttended_1').addClass('isAttended_2'); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(0).find('i').remove(); 
		$('.patientListBlock:contains('+patData.CR_No+') td').eq(2).find('a').text('Attended'); 
		var a=$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		////console.log(':::::::::::::::==========::::::::::::::'+a);
		//console.log(patData.PatCompleteGeneralDtl)
		//console.log((patData.PatCompleteGeneralDtl).split('#')[15]);
		var temp= $('.patientListBlock:contains('+patData.CR_No+')').find('input').val(); 
		////console.log('tempashu'+temp);
		//alert(temp);
		////console.log(temp.split('#')[15]);
		if(temp.split('#')[15] == '0' ){
			var patGeneralDtl = $('input[name=patCompleteGeneralDtl]').val();
			var temp=patGeneralDtl.split('#');
			////console.log('patdtls::::::'+patGeneralDtl);
			$('.patientListBlock:contains('+patData.CR_No+')').find('input').val(temp[0]+'#'+temp[1]+'#'+temp[2]+'#'+temp[3]+'#'+temp[4]+'#'+temp[5]+'#'+temp[6]+'#'+temp[7]+'#'+temp[8]+'#'+temp[9]+'#'+temp[10]+'#'+temp[11]+'#'+temp[12]+'#'+temp[13]+'#'+temp[14]+'#1#'+temp[16]+'#'+temp[17]);
			$('.patientListBlock:contains('+patData.CR_No+') td').eq(9).append('<button type="button" class="btn btn-outline-reprint printPrescriptionMainDeskTriggerBtn" onclick="printPrescriptionMainDeskFun(this)">Reprint</button>');	
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
			 $('.savePrescAlert').fadeOut(1500);
			 callQueueStatusUpdateAfterSave(this)
			 hidePrescription(this);
		}, 3000);  
		$('.savePrescAlertOkBtn').click(function(){
			 clearTimeout(timeOut);			
			 $('.savePrescAlert').hide();
			 callQueueStatusUpdateAfterSave(this)
			 hidePrescription(this);
		});
		$('.savePrescAlertCancelBtn').click(function(){
			 clearTimeout(timeOut); 
			 $('.savePrescAlert').hide();
			 callQueueStatusUpdateAfterSave(this);			 
			 hidePrescription(this);
		}); 
		*/
		
    	},
    	 error: function(data){
    	        alert("Problem while saving data");
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



function getPrevData(CR_No,episodeCode,hospitalCode,lastVisitDate ,visitNo , eTeleconsultancyReqId,isPatReferred,deptCode)
{
	//alert("inside getPrevData");
	//console.log('Call getPrevData ashukk -- '+episodeCode);
	//console.log(CR_No+'---'+episodeCode);
	//console.log('hospitalCode:::>>>>---'+hospitalCode);
	//console.log('lastVisitDate:::>>>>---'+lastVisitDate);
	//console.log('visitNo ::: '+visitNo);
	//console.log('eTeleconsultancyReqId'+eTeleconsultancyReqId);
	//console.log('isPatReferred getPrevData'+isPatReferred);
	//console.log('deptCode getPrevData'+deptCode);
	var currDate=getCurrentDate() ;
	var profileId=null;
	if(eTeleconsultancyReqId != "1")
		eTeleconsultancyReqId = "0";
	
	if(isPatReferred != "1")
		isPatReferred = "0";
	
	
	$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=GETPREV&PUK='+CR_No+'&EPISODECODE='+episodeCode+'&HOSPITALCODE='+hospitalCode+'&visitNo='+visitNo+'&eTeleconsultancyReqId='+eTeleconsultancyReqId+'&isPatReferred='+isPatReferred +'&deptCode='+deptCode +' ',type:'GET',async: true,success:function(result)
    	{
	
			localStorage.removeItem("lastThreeVisitLength");
			
			$('#checkLastThreeVisitDivId').hide();
			if(result.LASTTHREEVISIT)
			if(result.LASTTHREEVISIT !=null && result.LASTTHREEVISIT !=undefined && result.LASTTHREEVISIT.length >0)
			{
			//	alert("result.LASTTHREEVISIT>>" +JSON.stringify(result.LASTTHREEVISIT));
				//$('#checkLastThreeVisitDivId').show();
				localStorage.setItem("lastThreeVisitLength", result.LASTTHREEVISIT.length);
				if(isPatReferred=="1")
					$('.checkLastThreeVisitAdded').append('<option value="">Load Referral Rx</option>');
				else
					$('.checkLastThreeVisitAdded').append('<option value="">Load Past Rx</option>');
				result.LASTTHREEVISIT.forEach(function(item,index){
					////console.log('MY JSON3::::::::::::::::::::::::::');
					//console.log("index=="+index+"\n value==="+item.ENT_DATE);
					//console.log("index=="+index+"\n value==="+item.HRSTR_JSON);
					//alert("item.ENT_DATE>>" +item.ENT_DATE)
					//alert("currDate>>" +currDate)
					if(currDate.trim()==item.ENT_DATE.trim()){						
						profileId=index;
					}
					$('.checkLastThreeVisitAdded').append('<option value='+index+'>'+item.ENT_DATE+'</option>');
					$('.lastVisitOl').append('<li id=lastThreeVisitJson_'+index+'>'+item.HRSTR_JSON+'</li>');
					/*if(localStorage.getItem("lastThreeVisitJson_"+index))
						localStorage.removeItem("lastThreeVisitJson_"+index);
					localStorage.setItem("lastThreeVisitJson_"+index, item.HRSTR_JSON);*/
				});
			}else
				localStorage.setItem("lastThreeVisitLength", 0);
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
						//$('.investigationAdded').append('<a class="moreToggleInvestigation '+item.LABNAME.trim().split(' ').join('_')+'" style="padding-left: 5px;display:none;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+item.PRVTESTCODE+'^'+item.PRVLABCODE+'^'+item.LABNAME+'"> '+item.TESTNAME+'</label></a>');
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
						 //console.log("INV 1=="+JSON.stringify(InvestigationDtlsJson));
						 var invHtmlInput1 = '';
						 if(episodeCode===item.EPISODECODE && visitNo===item.VISITNO)
						 {
							 invHtmlInput1 = "disabled";
						 }
						 else
						 {
							 invHtmlInput1 = "";
						 } 
						
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
						 //console.log("INV 2=="+JSON.stringify(InvestigationDtlsJson));
						 
						 //const entryDate = new Date(item.ENTRYDATE);
						 //const currInvDate = new Date();
						 var invHtmlInput = '';
						 if(episodeCode===item.EPISODECODE && visitNo===item.VISITNO)
						 {
							 invHtmlInput = "disabled";
						 }
						 else
						 {
							 invHtmlInput = "";
						 } 
						 
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
					$('.investigationAddedMoreViewBtn').click(function(){
						$('.investigationAdded .moreToggleInvestigation').fadeToggle('fast');
						/*$(this).hide();*/
					});
				}
			}
		
			
			if(result.VISTREASON)	
			if(result.VISTREASON!=null)
			{
				var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					//console.log(item.HSTTR_REASONOFVISIT);
					
					
					var str=(item.HSTTR_REASONOFVISIT).replace("[", "");
					str=str.replace(']','');
					
					var temp= (str).split(',');
					
					/*item.HSTTR_REASONOFVISIT.forEach(function(it)
					{
						//console.log(':::::::::::'+it.val());
					}		
					);*/
					
					for(var i=0 ; i<temp.length;i++)
						{
						//console.log(':::::::::::'+temp[i]);
							
						if(temp[i]!='')
						{
						var first=temp[i].split('^')[0];
						
						var visitArr=temp[i].split('^');
						if(isNaN(first)){
							visitArr.unshift("0");
							temp[i]="0^"+temp[i];
						}
						//alert("visitArr>>>" +visitArr);
						var x=visitArr[2];
						//console.log('Side::::::'+x);
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
						var y=visitArr[4];
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

						//console.log(text);
						var tmp='';
						if(visitArr[4] != 0 && visitArr[2] != 0)
						tmp=text+'['+ visitArr[2] +text1 + ']';
						else if(visitArr[4] != 0)
							tmp='['+ visitArr[2] +text1 + ']';
						else if(visitArr[2] != 0)
							tmp=text ;
						
						if(visitArr[5]!=undefined &&  visitArr[5] !='')
							tmp =tmp +  visitArr[5] ;
						
						var tempWidth = 0;
						$('.reasonOfVisitAdded').find('a').each(function(index){
							tempWidth+=$(this).width();
						});
						
						if(tempWidth > ($('.reasonOfVisitAdded').width()-250))
						{
							
							flag=1;
							
							var chiefComplaintJson ={
									"IsExternalVisit"	:			"1" ,
									"VisitReasonName" : 		 	visitArr[1],
									"VisitReasonCode" :			 	visitArr[0],
									"VisitReasonSideCode" : 		 visitArr[2] ,
									"VisitReasonSideName" :			text,
									"VisitReasonNoOfDays" : 	 	visitArr[3] ,
									"VisitComplaintDurationCode" : visitArr[4],
									"VisitComplaintDurationName" : text1,
									"VisitReasonRemarks"		: 	visitArr[5]
								};
								
								//console.log(JSON.stringify(chiefComplaintJson));
							//$('.reasonOfVisitAdded').append('<a class="moreToggleVisitReason" style="padding-left:5px;display:none;"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+item.VISITREASON+'"> '+item.VISITREASON+'</label></a>');
							
							if(temp[i].split('^')[1]==undefined)
								continue;
							
							$('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;display:none;white-space: normal;" type="button" class="value btn btn-xs moreToggleVisitReason"    title='+tmp+' data-toggle="tooltip" >'+
					    	 		'<input type="checkbox" checked class="checkedInput" name="visitReason" value="'+temp[i]+'">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
					    	 		'<span class="text">'+visitArr[1]+' </span>'+
					    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
					    	 		'</button></label>');
						}
						else
							{
							var chiefComplaintJson ={
									"IsExternalVisit"	:			"1" ,
									"VisitReasonName" : 		 	visitArr[1],
									"VisitReasonCode" :			 	visitArr[0],
									"VisitReasonSideCode" : 		 visitArr[2] ,
									"VisitReasonSideName" :			text,
									"VisitReasonNoOfDays" : 	 	visitArr[3] ,
									"VisitComplaintDurationCode" : visitArr[4],
									"VisitComplaintDurationName" : text1,
									"VisitReasonRemarks"		: 	visitArr[5]
								};
								
								//console.log(JSON.stringify(chiefComplaintJson));
							if(temp[i].split('^')[1]==undefined)
										continue;
	
							$('.reasonOfVisitAdded').append('<label><button  tabindex="0" style="padding-left: 5px;font-weight:700;white-space: normal;" type="button" class="value btn btn-xs moreToggleVisitReason tooltipcss "   title='+tmp+' data-toggle="tooltip"  >'+
					    	 		'<input type="checkbox" class="checkedInput" checked name="visitReason" value="'+temp[i]+'">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
					    	 		'<span class="text" id="respRateIdValue"  >'+visitArr[1]+' </span>'+
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
					//console.log('test refferal data '+item.HRSTR_JSON_DATA.strClinicalProcedure.length);
					for(var q=0 ; q< item.HRSTR_JSON_DATA.strClinicalProcedure.length;q++)
					{
						
						
						var test1=item.HRSTR_JSON_DATA.strClinicalProcedure[q] ;
						//console.log('test1test1test1test1test1'+test1);
						
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
			var strChronicDeseaseTile="";
			if(result.CHRONICDISEASE!=undefined && result.CHRONICDISEASE!=null && result.CHRONICDISEASE.length>0)
			{
				var str1 = '';
				result.CHRONICDISEASE.forEach(function(item){
					//{"CronicDiseaseName":"Hypertension;","CronicDiseaseId":"38341003","CronicDiseaseRemarks":"",
					//"CronicDiseaseDuration":"1"}
					//alert(JSON.stringify(item));
					var hiddenField=item.CronicDiseaseName+'^'+item.CronicDiseaseId+'^'+item.CronicDiseaseDuration+'^'+item.CronicDiseaseRemarks;
					 var remarks= item.CronicDiseaseRemarks ;
					 strChronicDeseaseTile+= item.CronicDiseaseName+" ";
					 str1='<tr>'+
			          '<td><input type="checkbox" style="display:none;"  checked="checked"  class="chronicDiseaseChkAll" name="chronicDiseaseChk" value="'+hiddenField+'"></td>'+
			          '<td>'+item.CronicDiseaseName+'</td>'+
			          '<td>'+item.CronicDiseaseDuration+'</td>';
			          
			          if(remarks!=''){
			            str1+='<td><a class="chronicDiseaseInstructionsModalBtn" style="color: #109f1c" chronicDiseaseInstructions="'+remarks+'" onclick="$(\'#chronicDiseaseInstructionsModal .modal-body p\').text($(this).attr(\'chronicDiseaseInstructions\'));$(\'#chronicDiseaseInstructionsModal\').modal(\'show\');">'+remarks.substring(0, 4)+'..'+'</a></td>';
			          }
			          else{
			        	  str1+='<td></td>';
			          }
			
			          str1+='<td><button class="btn btn-xs btn-danger chronicDiseaseRemoveRow" type="button" onclick="$(this).parent().parent().remove();" id="removeBtnId2" style="background-color: white;border: 0px;"><span class="glyphicon glyphicon-trash" style="color: red;"></span></button></td> </tr>';					          
			          $('#chronicDiseaseListTable').parent().find('.table').children('tbody').append(str1);
					 
				});
			}
			if(strChronicDeseaseTile==""){
				strChronicDeseaseTile="NA";
				 $('#chronicDiseaseListTable').hide();
			}
			else{
				strChronicDeseaseTile=strChronicDeseaseTile.substr(0, strChronicDeseaseTile.length-1);// revoving last comma;
			}
		
			$('#chronicDiagnosistile').text(strChronicDeseaseTile);	
			
			
			
			if(result.VISTREASON)
			if(result.VISTREASON!=null)
			{
				//var flag = 0;
				result.VISTREASON.forEach(function(item){ 
					var strrefcount=0;
					//console.log('test refferal data '+item.HRSTR_JSON_DATA.strReferal.length);
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
						//console.log(reffralJson);
						var datashow=item.HRSTR_JSON_DATA.strReferal[q].strShowData ;
						strrefcount++;
						var tooltipdata ='-';
						if(item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName != 0)
							tooltipdata =item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName
						if(item.HRSTR_JSON_DATA.strReferal[q].strReffralReason != '')
							tooltipdata =item.HRSTR_JSON_DATA.strReferal[q].strreferralTypeName +'(' + item.HRSTR_JSON_DATA.strReferal[q].strReffralReason +')';
						////console.log(JSON.stringify((reffralJson.toString()));
						
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
			//console.log('::::::::::'+result.DIAGNOSIS);
			
			var strAlergyForTile="";
			if(result.ALLEGRY!=undefined && result.ALLEGRY!=null && result.ALLEGRY.length>0)
			{
				
				var str1 = '';
				result.ALLEGRY.forEach(function(item){ 
					var count1=0;
					//console.log('allergy '+item.HGSTR_ALLERGY_NAME);
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
			            //console.log(chkBoxId);
			            var hiddenField =JSON.stringify(chkBoxId);
						if(item.HGSTR_ALLERGY_NAME.trim()!=''){
							var allergyName=item.HGSTR_ALLERGY_NAME.trim();
							var found=false;
							// checking for duplicate alergy row
							if($('[name=allergyName]').length>0){								
								$('[name=allergyName]').each(function(){
									//alert($(this).val()+ "==" + allergyName)
									if($(this).val()==allergyName)
										found=true;
								});
							}
							//alert("found >>" +found);
							if(found==false){
								strAlergyForTile+=allergyName+" ,";	
								count1++;
								str1='<tr>'+ 
				                '<td><input type="checkbox" style="display:none;"  checked="checked" class="allergiesDtlChkAll" id="allergyDtlChkId" name="allergiesDtlChk" value="">'+
								'<i class="text" style="display :none">'+hiddenField+' </i></td>'+
				                '<td><input type="hidden" name="allergyName" value="'+allergyName+'">'+allergyName+'</td>'+
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
					}
			}) ;
			if(strAlergyForTile!=""){
				strAlergyForTile=strAlergyForTile.substr(0, strAlergyForTile.length-1);// removing last comma;
			}
			else{
				$('#allergiesDtlListTable').hide();
			}
				
			//$('#AlergyMainDiv').find('.accordionbtn').trigger('click');	
		}
		else{
			strAlergyForTile="NA"
		}
		$('#alergytile').text(strAlergyForTile);
				
			if(result.VITALDTLS)
			if(result.VITALDTLS!=null && result.VITALDTLS!=''){
				//console.log('Vital Details'+result);
				//console.log("vital1");
				$('#vitalmainDiv').show();
				
				result.VITALDTLS.forEach(function(item){ 
					
					var jsonVital = JSON.parse(item.VITAL_JSON_DATA);
					
					createVitalDiv(jsonVital);
					createLabDiv(jsonVital);
					
					
				});
				
				
				
								
				
				
			}else{
				//console.log('Insdie remove:::::::::');
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
				////console.log('test reson of visit detils Details'+JSON.parse(result));
				result.REGISTRATIONVISIT.forEach(function(item){
					$('#ReasonVisitFromRegistrationId').html(item.HRGSTR_VISIT_REASON);
					$('#ReasonVisitFromRegistrationId').show();
				});				}
				
			//console.log("result.INVENTORYDRUG=="+result.INVENTORYDRUG);
			if(result.INVENTORYDRUG)
				if(result.INVENTORYDRUG.length!=null)
				{
					result.INVENTORYDRUG.forEach(function(item,index){
						//if(index<3)
						//{
							var InvDrugJson ={
				 					"ITEMNAME"	:	 item.ITM ,
				 					"ISSUEQTY"	:	 item.ISSUE_QTY,
				 					"ISSUEDATE"	:	item.ISSUE_DATE ,
				 					"STORE"		:	item.STORE ,
				 					"HOSPNAME"	:	item.HOSP_NAME 
				 			}
							//console.log("InvDrugJson --- "+JSON.stringify(InvDrugJson));
							
							$('.drugsAdvicesAdded').parent().find('.table').children('tbody').append('<tr class="TRInvdrug" style="display :none"> <td><input type="hidden" name="invDrugName" value="'+item.ITM+'"> <i class="text2">'+JSON.stringify(InvDrugJson)+' </i></td></tr>');	
						//}
					});
				}
			
			if(result.ETELECONSULTANCYVITAL)
			if(result.ETELECONSULTANCYVITAL!=null && result.ETELECONSULTANCYVITAL!=''){
				//console.log('ETELECONSULTANCYVITAL Details'+result.ETELECONSULTANCYVITAL);
				result.ETELECONSULTANCYVITAL.forEach(function(item){
					
			
					
					
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
					
					
					//console.log('patientcomplaintidValue'+patcomplaintval)
					$("#patientcomplaintidValue").html(patcomplaintval);
					
					
				});
				
			}else{
				$("#patientcomplaintid").hide();
			}
			
			
			//if(profileId!=null){
			//	$('#checkLastThreeVisitDivId').val(profileId).trigger('change');
			//	checkProfileOnLoad();
			//}else{
				//populateLastDiagnosis();
			//}
    	}
	
	
	
	});
	
	
	

	
}
