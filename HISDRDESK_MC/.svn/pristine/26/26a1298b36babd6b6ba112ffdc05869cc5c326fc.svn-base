var globalPatPresc = ''; 
var drugInstructionTags = [
    "After Food",
    "Before Food",
    "After Breakfast",
    "Before Breakfast",
    "Bed Rest",
    "Local application",
    "30 minutes before food",
	"20 minutes before food",
	"Along with food",
	"May cause drowsiness",
	"Empty Stomach",
	"Topical Use"	
];

var procedureAllowed=1;
var investigationAllowed=1;
$(document).ready(function(){
	//$('.manageTemplate').hide();
	getInternalDepartment();
	
	initDrugData();
	initAutoComplete();
	
	$('.accordionbtn').click(togglePrescriptionAccordion);
	
	
	
	refreshSectionBookMark("4,5");
	
	var cardColor=$('#cardColor').val();
	
	if(cardColor!="")
		$('#patient_profile').addClass("patHeader-"+cardColor);
	else
		$('#patient_profile').addClass("patHeader-default");
	
	//$('#extItemType').select2({"width":"100%"});
	
	$('#extItemType').change(function(){
		var extItemType=$(this).val();		
		if(extItemType=="0"){
			$('#spanExtDrugForm').text("-");
			return;	
		}
		var arrId=extItemType.split("^");
		$('#extDoseQty').val("1");
		$('#spanExtDrugForm').text(arrId[1]);
		
	});
	
	 $('#followUpPlannedVisitDaysId').blur(function(){
			
			if(this.value==""){
				return;
			}
			let newDate = addDaysToDate(this.value);
         document.getElementById('followUpPlannedVisitDateId').value = newDate;								
		});
	
	
	
	
	 
	
	
	
	
	
	
	$('.prescPrintBtn').click(function(){
		
		var ResonOfVisitJsonArray =[];
		var j;
		var BoormarkNameVal='' ;
		$('input[name=visitReason]:checked').each(function()
						{
							var jsonString=JSON.parse($(this).parent().find('i').text());
							//console.log(jsonString.VisitReasonName);
							if(BoormarkNameVal == '')
							BoormarkNameVal=jsonString.VisitReasonName
							else	
							BoormarkNameVal = BoormarkNameVal +' + '+jsonString.VisitReasonName;
						});
		$('input[name=diagnosisAdded]:checked').each(function()
				{
					var jsonString=JSON.parse($(this).parent().find('i').text());
					////console.log(jsonString.VisitReasonName);
					if(BoormarkNameVal == '')
						BoormarkNameVal=jsonString.DiagnosisName
					else
					BoormarkNameVal = BoormarkNameVal +' + '+jsonString.DiagnosisName;
			
					/*//console.log('diagnosisAdded::>>> '+$(this).val());
					Diagnosis[j]=$(this).val();    //+'^'+$(this).parent().text()+'#'+$(this).attr('diagnosisName');
					DiagnosisJsonArray[j]=JSON.parse($(this).parent().find('i').text());
					j++; */
				});
		
		$('#PresCriptionBookmarkNameId').val(BoormarkNameVal);
		//console.log(ResonOfVisitJsonArray);
		
		if($('#bookmarkmodal').is(':visible') == true){
			//console.log(':::::::::::::');
			$('#bookmarkmodal').modal('show');
		}else{
			$('#bookmarkmodal').modal('show');
		}
	});
	
	
	$('.rxprofilebtn').click(function(){
		if($('#PresCriptionModal').is(':visible') == true){
			//console.log(':::::::::::::');
			$('#PresCriptionModal').modal('show');
		}else{
			$('#PresCriptionModal').modal('show');
		}
	});
	
	
	$(".cleaarAll1").on("click",function(){
		$("#drugAdviceListTable tbody").empty();
	});
	
	
	
	
	
	$('.checkboxcls').click(function(){
	    $('.checkboxcls').each(function(){
	        $(this).prop('checked', false); 
	    }); 
	    $(this).prop('checked', true);
	});

	 $('.reasonOfVisitCleanBtn').click(function(){
		 $(this).parent().parent().find('#txt-snomed-ct-search_VR').val('');
		 $(this).parent().parent().find('#txt-snomed-ct-search_VR').attr('reasonOfVisitCode','');
	 });
	 
	 $('.diagnosisCleanBtn').click(function(){
		 $(this).parent().parent().find('#txt-snomed-ct-search_VR2').val('');
		 $(this).parent().parent().find('#txt-snomed-ct-search_VR2').attr('diagnosisCode','');
	 });

 	var totalTabMaxWidth = $('.navDeskTabList').width(); 
 	var totalTabActualWidth = 0;
 	var flag = 0;
 	$('.navDeskTabList').find('li').each(function(index){
 		            totalTabActualWidth += $(this).width();
 		           if(totalTabActualWidth>(totalTabMaxWidth - 50))
 		           {	
 		           		$(this).hide();
 		           		$(this).addClass('extraTags');
 		           		flag = 1;
 		           }
 	});
 	if(flag == 1)
 	{
 		$('.navDeskTabList').append('<li class="moreTagsView"><a style="text-decoration:none;">...more</a></li>');
 	}
 	$('.moreTagsView').click(function(){
 		$('.extraTags').toggle(); 
 	}); 

 	$('.addMacroToProgressNoteBtn').click(function(e){
 		
 		//var test=this.id;
 		var id = $(this).attr('id');
 		//console.log('this.id::::'+id);
 		//console.log('12::::::::::::::::'+$('#macrisHiddenId').val());
 		var txt = $('input[name=macroNoteVal]:checked').val();
 		//console.log(txt);
 		//alert(txt);
 		if(txt != null)
 		{	
 			//$(this).parent().parent().val(txt);
 			var temp=($('#macrisHiddenId').val()).replace("Div", "");
 			var temp1=($('#macrisHiddenIdval').val()).replace("Div", "");
 			//console.log('temp       '+temp);
 			//console.log('temp1       '+temp1);
 			$('#'+temp).val(txt);
 			//$('textarea[name=progressNote]').val(txt);
 			$('#'+temp1).modal('hide');
 			$('#macrisHiddenId').val('');
 			$('#macrisHiddenIdval').val('');
 		}
 	}); 

	 	
	$('.progressNoteMacroBtn').click(function(e){
	 		
			//$('#progressNoteMacroModal').modal('show');
	 		var test=this.id;
	 		$('#macrisHiddenId').val(test);
	 		$('#macrisHiddenIdval').val(this.value);
	 		
	 		//console.log(this.value+'::::::::::::::::'+test);
	 		/*//console.log('::::::::::::::::'+test)
	 		var txt = $('input[name=macroNoteVal]:checked').val();
	 		//alert(txt);
	 		if(txt != null)
	 		{	
	 			$(this).parent().parent().val(txt);
	 			$('textarea[name=progressNote]').val(txt);
	 			$('#progressNoteMacroModal').modal('hide');
	 		}*/
	 	}); 
	

 	$('.clearLnk').on('click',function(e){
/* 		$(this).parent().parent().parent().find('.checkedInput:checked').parent().parent().remove();*/
		if($(this).parent().find('.checkedInput').is(':checked'))
		$(this).parent().find('.checkedInput:checked').prop('checked',false);
		else
		$(this).parent().find('.checkedInput').prop('checked',true);
 	});
 	$('.clearLnkDrug').on('click',function(e){  
		$(this).parent().parent().parent().find('.checkedInput:checked').prop('checked',false);
 	});

 	$('.reasonOfVisitAdd').click(function()
 	{
 		////console.log('Index ZVal()'+$(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim().indexOf(';'));
 		if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim().indexOf(';')>='0')
 		{ 		////console.log('true::::::::');	
		 		if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim()!='')
		 		{  
		 			var reasonOfVisitVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().split(';');
			 	   var reasonOfVisitCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode').split(';');
			 	   var visitReasoncount=0;
			 	   for(var i=0;i<(reasonOfVisitVAl.length-1);i++)
		 			{
		 			  var tmp = 0; 
						$('.reasonOfVisitAdded').find('label .text').each(function(index){ 
							if($(this).text().trim().toUpperCase()===reasonOfVisitVAl[i].trim().toUpperCase()) 
							{	tmp = 1; 
								return false;  }
						});
						if(tmp==1)
						{
		
							swal(reasonOfVisitVAl[i].trim()+", Already Added!!");
							continue;
						}
						visitReasoncount ++;
						var visitReasonId=reasonOfVisitVAl[i]+'^'+$("#chiefComplaintSiteId").val()+'^'+$("#chiefComplaintNoOfDaysId").val()+'^'+$("#chiefComplaintDurationId").val()+'^'+$("#reasonofvisitRemarksId").val();
						//console.log('visitReasonId'+$('#chiefComplaintSiteId option:selected').text());
						/*alert(visitReasonId)
						//console.log(visitReasonId);*/
						 //$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<a style="padding-left:5px"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+reasonOfVisitCode[i]+'^'+visitReasonId+'" checked> '+reasonOfVisitVAl[i]+'</label></a>');
						var chiefComplaintJson ={
							"IsExternalVisit"	:		"1" ,
							"VisitReasonName" : 		 reasonOfVisitVAl[i],
							"VisitReasonCode" :			 reasonOfVisitCode[i],
							"VisitReasonSideCode" : 		 $("#chiefComplaintSiteId").val() ,
							"VisitReasonSideName" :			$('#chiefComplaintSiteId option:selected').text(),
							"VisitReasonNoOfDays" : 	 $("#chiefComplaintNoOfDaysId").val() ,
							"VisitComplaintDurationCode" : $("#chiefComplaintDurationId").val(),
							"VisitComplaintDurationName" : $('#chiefComplaintDurationId option:selected').text(),
							"VisitReasonRemarks"		: $("#reasonofvisitRemarksId").val()
						};
						
						//console.log(JSON.stringify(chiefComplaintJson));
						
						var temp='';
						//console.log($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 );
						
						if($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 ) 
						 temp=$('#chiefComplaintSiteId option:selected').text() + '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ; 
						else if($("#chiefComplaintSiteId").val() != 0)
							 temp=$('#chiefComplaintSiteId option:selected').text() ;
						else 
							 temp= '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ;	
						
						
						
						if($("#reasonofvisitRemarksId").val() != ''){
							temp = temp + $("#reasonofvisitRemarksId").val() ;
		 			}
						
						//console.log('temp temp temp '+temp);
						$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs reasonOfVisitAdd " data-toggle="tooltip" title='+ temp +'>'+
					    	 		'<input type="checkbox" class="checkedInput" name="visitReason" value="'+reasonOfVisitCode[i]+'^'+visitReasonId+'" checked="">  '+
					    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
					    	 		'<span class="text">'+reasonOfVisitVAl[i]+' </span>'+
					    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
					    	 		'</button></label>');
		 			   }
					 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val('');
			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode','');
			 		 $(this).parent().parent().find('input[name=chiefComplaintNoOfDays]').val('');
			 		 $(this).parent().parent().find('input[name=reasonofvisitRemarks]').val('');
			 		$(this).parent().parent().find('textarea[name=reasonofvisitRemarks]').val('');
			 		$(this).parent().parent().find('select[name=chiefComplaintSite] ').val('0');
			 		$(this).parent().parent().find('select[name=chiefComplaintDuration] ').val('1');
			 		
		 		 }
		 		else
		 			 swal('Please Select atleast one reason');
 		}
 		else if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim() != ''){
            var generalComplaintVal = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val() ;  //$(this).parent().parent().find('input[name=generalComplaint]').val();
            if(generalComplaintVal.trim()!='')
             {  
               var tmp = 0; 
               $('.reasonOfVisitAdded').find('label .text').each(function(index){ 
                 if($(this).text().split("*")[0].trim().toUpperCase()===generalComplaintVal.trim().toUpperCase()) 
                 { tmp = 1; 
                   return false;  }
               });
               if(tmp==1)
               {
                 swal("Already Added!!");
                 $('#generalComplaintId').val('');
                 return false;
               }
               else
               {
                 var chiefComplaintNoOfDays=$(this).parent().parent().find('input[name="chiefComplaintNoOfDays"]').val();
                 var siteId=$(this).parent().parent().find('select[name="chiefComplaintSite"] option:selected').val();
                 var chiefComplaintDuration=$(this).parent().parent().find('select[name="chiefComplaintDuration"] option:selected').val();

                 if(siteId != '0' || (chiefComplaintDuration != '0' && chiefComplaintNoOfDays !='')){
                     if(siteId != '0' && (chiefComplaintDuration != '0' && chiefComplaintNoOfDays !=''))
                       var generalComplaintChkBoxVal='0^'+generalComplaintVal+'^'+siteId+'^'+chiefComplaintNoOfDays+'^'+chiefComplaintDuration+'^'+$("#reasonofvisitRemarksId").val();
                     else if(siteId != '0')
                       var generalComplaintChkBoxVal='0^'+generalComplaintVal+'^'+siteId+'^0^0'+'^'+$("#reasonofvisitRemarksId").val(); 
                     else if(chiefComplaintDuration != '0' && chiefComplaintNoOfDays !='')
                       var generalComplaintChkBoxVal='0^'+generalComplaintVal+'^0^'+chiefComplaintNoOfDays+'^'+chiefComplaintDuration+'^'+$("#reasonofvisitRemarksId").val();
                     else{
                       swal('Please select all fields');
                       return false;
                     }
                 }
               /*  else if(chiefComplaintDuration != '0' &&  chiefComplaintNoOfDays == ''){
                   swal('Please enter no of days.');
                   return false;
                 }*/
                /* else if(chiefComplaintDuration == '0' &&  chiefComplaintNoOfDays != ''){
                   swal('Please select duration.');
                   return false;
                 }*/
                 else{
                   var generalComplaintChkBoxVal='0^'+generalComplaintVal+'^0^0^0'+'^'+$("#reasonofvisitRemarksId").val();  
                 }
                 
                 //$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="visitReason" value="'+generalComplaintChkBoxVal+'"  checked> '+generalComplaintVal+'(ext)</label></a>');
                 var temp='';
					//console.log($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 );
					
					if($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 ) 
					 temp=$('#chiefComplaintSiteId option:selected').text() + '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ; 
					else if($("#chiefComplaintSiteId").val() != 0)
						
						 temp=$('#chiefComplaintSiteId option:selected').text() ;
					else 
						 temp= '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ;	
					
					
					if($("#reasonofvisitRemarksId").val() != '')
						temp =temp + $("#reasonofvisitRemarksId").val() ;
					
					var chiefComplaintJson ={
							"IsExternalVisit"	:		"1" ,
							"VisitReasonName" : 		 generalComplaintVal,
							"VisitReasonCode" :			 "0",
							"VisitReasonSideCode" : 	 $("#chiefComplaintSiteId").val() ,
							"VisitReasonSideName" :		$('#chiefComplaintSiteId option:selected').text(),
							"VisitReasonNoOfDays" : 	 $("#chiefComplaintNoOfDaysId").val() ,
							"VisitComplaintDurationCode" : $("#chiefComplaintDurationId").val(),
							"VisitComplaintDurationName" : $('#chiefComplaintDurationId option:selected').text(),
							"VisitReasonRemarks"		: $("#reasonofvisitRemarksId").val()
						};
						
						//console.log(JSON.stringify(chiefComplaintJson));
					
                 $(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs"  data-toggle="tooltip" title='+ temp +'>'+
			    	 		'<input type="checkbox" class="checkedInput" name="visitReason" value="'+generalComplaintChkBoxVal+'" checked="">  '+
			    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
			    	 		'<span class="text">'+generalComplaintVal+'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');

               }
              
              //$(this).parent().parent().find('input[name=generalComplaint]').val('');
               $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val('');
		 	  $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode','');
              $(this).parent().parent().find('input[name="chiefComplaintNoOfDays"]').val('');
              $(this).parent().parent().find('input[name=reasonofvisitRemarks]').val('');
              $(this).parent().parent().find('select[name="chiefComplaintSite"]').val('0');
              $(this).parent().parent().find('select[name="chiefComplaintDuration"] ').val('1');
             }
             else{
               swal('Please enter other general complaint to be added');
             }
     }
 		else
 			 {swal('Please Select atleast one reason');}
 		$('[data-toggle="tooltip"]').tooltip();
 	}); 

 	$("input[name=txt-snomed-ct-search_VR2]").on('keypress', function (e) {
 		//console.log('1');
 		if (!e) e = window.event;
 	    var keyCode = e.keyCode || e.which;
 	    if (keyCode == '13'){
 	    	//console.log('2');	

 	 		if($('input[name=diagnosisDiseaseReference]').is(':checked'))
 	 		{
 	 			if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim().indexOf(';')>='0')
 	 	 		{
 	 				if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim()!='')
 	 		 		{  var diagnosisVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().split(';');
 	 			 	   var diagnosisCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode').split(';');
 	 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
 	 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
 	 			 	   //console.log("diagnosisVAl -->> "+diagnosisVAl);
 	 			 	   //console.log("diagnosisCode --->> "+diagnosisCode);
 	 			 	  //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
 	 		 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
 	 		 		   	{
 	 		 			  var tmp = 0; 
 	 		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
 	 		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
 	 		 					{	tmp = 1; 
 	 		 						return false;  }
 	 		 				});
 	 		 				if(tmp==1)
 	 						{ 
 	 							swal(diagnosisVAl[i].trim()+", Already Added!!");
 	 							continue;
 	 						}
 	 		 				var strDiagnosisId=diagnosisCode[i]+'#'+diagnosisTypeCode+'#1^'+diagnosisVAl[i]+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteId").val()+'#'+$('input[name=diagnosisNoOfDays]').val()+'#'+$("#diagnosisDurationId").val()+'#'+$("#diagnosisRemarksId").val();
 	 				 		//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+diagnosisVAl[i]+'</label></a>');
 	 				 		
 	 		 				var temp=''; 
 	 		 				if($("#diagnosisSiteId").val()!= 0 && diagnosisTypeCode !=0)
 	 		 					temp=diagnosisTypeName +'['+ $("#diagnosisSiteId option:selected").text() +']';
 	 		 				else if($("#diagnosisSiteId").val()!= 0)
 	 		 					temp=+'['+ $("#diagnosisSiteId option:selected").text() +']';
 	 		 				else if(diagnosisTypeCode !=0 )
 	 		 					temp=diagnosisTypeName ;
 	 		 				
 	 		 				if($("#diagnosisRemarksId").val() !=''){
 	 		 					temp= temp+ $("#diagnosisRemarksId").val() ;
 	 		 				}
 	 		 				var DiagnosisJson ={
 	 		 						"IsSnomed"				:			"1" ,
 	 								"DiagnosisName" 		: 		 	diagnosisVAl[i],
 	 								"DiagnosisCode" 		:			diagnosisCode[i],
 	 								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
 	 								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
 	 								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
 	 								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
 	 								"DiagnosisRemarks"	:			$("#diagnosisRemarksId").val()
 	 							};
 	 							
 	 		 				//console.log(JSON.stringify(DiagnosisJson));
 	 		 				
 	 				 		$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs" title='+temp+' data-toggle="tooltip" >'+
 	 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
 	 				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
 	 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
 	 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 	 				    	 		'</button></label>');
 	 		 		   	}
 	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val('');
 	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode','');
 	 			 		$(this).parent().parent().find('select[name=diagnosisSite] ').val('0');
 	 			 		$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
 	 			 		$(this).parent().parent().find('textarea[name=diagnosisRemarks]').val('');
 	 			 		 
 	 		 		 }
 	 				else
 	 		 			 swal('Please Select atleast one reason');
 	 	 		}
 		 		else
 		 			 swal('Please Select atleast one reason');
 	 		}
 	 		else{
 	 			 var investigationVAl = $(this).parent().parent().find('input[name=icdCodeInput]').val();  
 	 		 	 var isValid = 0;
 	 		 	 var invObj = $("#icdJsonObjDiv").text().trim(); //localStorage.getItem('icdJsonObj'); 
 	 	 		 invObj = JSON.parse(invObj.toString()); 
 	 	 		 for(var v=0; v<invObj.length;v++)
 	 	 		 { 
 	 	 			if (invObj[v].icdCode.toUpperCase() == investigationVAl.toUpperCase()) {
 	 	 				isValid=1;
 	 			        break;
 	 			    } 
 	 	 		  } 
 	 			if($(this).parent().parent().find('input[name=diseaseInput]').val().trim()!='')
 		 		{  
 	 				var icdCode = $(this).parent().parent().find('input[name=icdCodeInput]').val();
 	 				var icdCodeVal = $(this).parent().parent().find('input[name=diseaseInput]').val(); 
 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
 			 	   //console.log('icdCodeVal ::: ::::: :::: '+icdCode+icdCodeVal); 
 			 	   
 			 	   var tmp = 0; 
 					$('.diagnosisAdded').find('label .text').each(function(index){ 
 						if($(this).text().trim().toUpperCase()===icdCodeVal.trim().toUpperCase()) 
 						{	tmp = 1; 
 							return false;  }
 					});
 					if(tmp==1)
 					{ 
 						swal(icdCodeVal.trim()+", Already Added!!"); 
 					}
 					else
 					{					  
 						var strDiagnosisId=icdCode+'#'+diagnosisTypeCode+'#0^'+icdCodeVal+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteIcdId").val()+'#'+$("#diagnosisNoOfDaysIcdId").val()+'#'+$("#diagnosisDurationIcdId").val()+'#'+$("#diagnosisRemarksIcdId").val();
 						//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+icdCodeVal+'</label></a>');
 						
 						var DiagnosisJson ={
 			 						"IsSnomed"				:			"2" ,
 									"DiagnosisName" 		: 		 	icdCodeVal,
 									"DiagnosisCode" 		:			icdCode,
 									"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
 									"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
 									"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
 									"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
 									"DiagnosisRemarks"	:			$("#diagnosisRemarksIcdId").val()
 								};
 								
 						//console.log(JSON.stringify(DiagnosisJson));
 						var temptoggle='';
 						if(diagnosisTypeName != '' ) 
 							temptoggle =diagnosisTypeName ;
 						if($('#diagnosisSiteId option:selected').text() !='')
 							temptoggle =diagnosisTypeName +'['+$('#diagnosisSiteId option:selected').text() +']' ;
 							
 						if($("#diagnosisRemarksIcdId").val() !=''){
 							temptoggle = temptoggle  +$("#diagnosisRemarksIcdId").val() ; 
 						}
 						$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" title='+temptoggle+' data-toggle="tooltip" type="button" class="value btn btn-xs">'+
 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
 				    			'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
 				    	 		'<span class="text">'+icdCodeVal+' </span>'+
 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 				    	 		'</button></label>');
 				 	}
 					 $(this).parent().parent().find('input[name=diseaseInput]').val('');
 			 		 $(this).parent().parent().find('input[name=icdCodeInput]').val('');  
 			 		$(this).parent().parent().find('select[name=diagnosisSiteIcd] ').val('0');
 				 	$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
 				 	$(this).parent().parent().find('textarea[name=diagnosisRemarksIcd]').val('');
 				 		
 		 		 }
 		 		else
 		 			 swal('Please Select atleast one reason');
 	 			 
 	 			
 	 			
 	 			 
 	 			
 	 		}
 	 		$('[data-toggle="tooltip"]').tooltip();
 	 		
 	    }
 	});
 	
 	var my_field = document.getElementById('icdCodeInputId');
 	
 	my_field.addEventListener('keyup',function(e){
 	//$("input[name=flexdatalist-diseaseInput]").on('keypress', function (e) {
 		//console.log('15635555...............');
 		if (!e) e = window.event;
 	    var keyCode = e.keyCode || e.which;
 	    //console.log(keyCode)
 	    if (keyCode == '13'){
 	    	//console.log('2');	

 	 		if($('input[name=diagnosisDiseaseReference]').is(':checked'))
 	 		{
 	 			if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim().indexOf(';')>='0')
 	 	 		{
 	 				if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim()!='')
 	 		 		{  var diagnosisVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().split(';');
 	 			 	   var diagnosisCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode').split(';');
 	 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
 	 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
 	 			 	   //console.log("diagnosisVAl -->> "+diagnosisVAl);
 	 			 	   //console.log("diagnosisCode --->> "+diagnosisCode);
 	 			 	  //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
 	 		 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
 	 		 		   	{
 	 		 			  var tmp = 0; 
 	 		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
 	 		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
 	 		 					{	tmp = 1; 
 	 		 						return false;  }
 	 		 				});
 	 		 				if(tmp==1)
 	 						{ 
 	 							swal(diagnosisVAl[i].trim()+", Already Added!!");
 	 							continue;
 	 						}
 	 		 				var strDiagnosisId=diagnosisCode[i]+'#'+diagnosisTypeCode+'#1^'+diagnosisVAl[i]+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteId").val()+'#'+$('input[name=diagnosisNoOfDays]').val()+'#'+$("#diagnosisDurationId").val()+'#'+$("#diagnosisRemarksId").val();
 	 				 		//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+diagnosisVAl[i]+'</label></a>');
 	 				 		
 	 		 				var temp=''; 
 	 		 				if($("#diagnosisSiteId").val()!= 0 && diagnosisTypeCode !=0)
 	 		 					temp=diagnosisTypeName +'['+ $("#diagnosisSiteId option:selected").text() +']';
 	 		 				else if($("#diagnosisSiteId").val()!= 0)
 	 		 					temp=+'['+ $("#diagnosisSiteId option:selected").text() +']';
 	 		 				else if(diagnosisTypeCode !=0 )
 	 		 					temp=diagnosisTypeName ;
 	 		 				
 	 		 				if($("#diagnosisRemarksId").val() !=''){
 	 		 					temp= temp+ $("#diagnosisRemarksId").val() ;
 	 		 				}
 	 		 				var DiagnosisJson ={
 	 		 						"IsSnomed"				:			"1" ,
 	 								"DiagnosisName" 		: 		 	diagnosisVAl[i],
 	 								"DiagnosisCode" 		:			diagnosisCode[i],
 	 								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
 	 								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
 	 								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
 	 								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
 	 								"DiagnosisRemarks"	:			$("#diagnosisRemarksId").val()
 	 							};
 	 							
 	 		 				//console.log(JSON.stringify(DiagnosisJson));
 	 		 				
 	 				 		$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs" title='+temp+' data-toggle="tooltip" >'+
 	 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
 	 				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
 	 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
 	 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 	 				    	 		'</button></label>');
 	 		 		   	}
 	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val('');
 	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode','');
 	 			 		$(this).parent().parent().find('select[name=diagnosisSite] ').val('0');
 	 			 		$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
 	 			 		$(this).parent().parent().find('textarea[name=diagnosisRemarks]').val('');
 	 			 		 
 	 		 		 }
 	 				else
 	 		 			 swal('Please Select atleast one reason');
 	 	 		}
 		 		else
 		 			 swal('Please Select atleast one reason');
 	 		}
 	 		else{
 	 			 var investigationVAl = $(this).parent().parent().find('input[name=icdCodeInput]').val();  
 	 		 	 var isValid = 0;
 	 		 	 var invObj = $("#icdJsonObjDiv").text().trim(); //localStorage.getItem('icdJsonObj'); 
 	 	 		 invObj = JSON.parse(invObj.toString()); 
 	 	 		 for(var v=0; v<invObj.length;v++)
 	 	 		 { 
 	 	 			if (invObj[v].icdCode.toUpperCase() == investigationVAl.toUpperCase()) {
 	 	 				isValid=1;
 	 			        break;
 	 			    } 
 	 	 		  } 
 	 			if($(this).parent().parent().find('input[name=diseaseInput]').val().trim()!='')
 		 		{  
 	 				var icdCode = $(this).parent().parent().find('input[name=icdCodeInput]').val();
 	 				var icdCodeVal = $(this).parent().parent().find('input[name=diseaseInput]').val(); 
 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
 			 	   //console.log('icdCodeVal ::: ::::: :::: '+icdCode+icdCodeVal); 
 			 	   
 			 	   var tmp = 0; 
 					$('.diagnosisAdded').find('label .text').each(function(index){ 
 						if($(this).text().trim().toUpperCase()===icdCodeVal.trim().toUpperCase()) 
 						{	tmp = 1; 
 							return false;  }
 					});
 					if(tmp==1)
 					{ 
 						swal(icdCodeVal.trim()+", Already Added!!"); 
 					}
 					else
 					{					  
 						var strDiagnosisId=icdCode+'#'+diagnosisTypeCode+'#0^'+icdCodeVal+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteIcdId").val()+'#'+$("#diagnosisNoOfDaysIcdId").val()+'#'+$("#diagnosisDurationIcdId").val()+'#'+$("#diagnosisRemarksIcdId").val();
 						//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+icdCodeVal+'</label></a>');
 						
 						var DiagnosisJson ={
 			 						"IsSnomed"				:			"2" ,
 									"DiagnosisName" 		: 		 	icdCodeVal,
 									"DiagnosisCode" 		:			icdCode,
 									"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
 									"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
 									"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
 									"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
 									"DiagnosisRemarks"	:			$("#diagnosisRemarksIcdId").val()
 								};
 								
 						//console.log(JSON.stringify(DiagnosisJson));
 						var temptoggle='';
 						if(diagnosisTypeName != '' ) 
 							temptoggle =diagnosisTypeName ;
 						if($('#diagnosisSiteId option:selected').text() !='')
 							temptoggle =diagnosisTypeName +'['+$('#diagnosisSiteId option:selected').text() +']' ;
 							
 						if($("#diagnosisRemarksIcdId").val() !=''){
 							temptoggle = temptoggle  +$("#diagnosisRemarksIcdId").val() ; 
 						}
 						$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" title='+temptoggle+' data-toggle="tooltip" type="button" class="value btn btn-xs">'+
 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
 				    			'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
 				    	 		'<span class="text">'+icdCodeVal+' </span>'+
 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 				    	 		'</button></label>');
 				 	}
 					 $(this).parent().parent().find('input[name=diseaseInput]').val('');
 			 		 $(this).parent().parent().find('input[name=icdCodeInput]').val('');  
 			 		$(this).parent().parent().find('select[name=diagnosisSiteIcd] ').val('0');
 				 	$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
 				 	$(this).parent().parent().find('textarea[name=diagnosisRemarksIcd]').val('');
 				 		
 		 		 }
 		 		else
 		 			 swal('Please Select atleast one reason');
 	 			 
 	 			
 	 			
 	 			 
 	 			
 	 		}
 	 		$('[data-toggle="tooltip"]').tooltip();
 	 		
 	    }
 	}, false);
 	
 	
	$("input[name=txt-snomed-ct-search_VR]").on('keypress', function (e) {
 		if (!e) e = window.event;
 	    var keyCode = e.keyCode || e.which;
 	    if (keyCode == '13'){
 	    	

 	 		//console.log('Index ZVal()'+$(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim().indexOf(';'));
 	 		if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim().indexOf(';')>='0')
 	 		{ 		//console.log('true::::::::');	
 			 		if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim()!='')
 			 		{  
 			 			var reasonOfVisitVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().split(';');
 				 	   var reasonOfVisitCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode').split(';');
 				 	   for(var i=0;i<(reasonOfVisitVAl.length-1);i++)
 			 			{
 			 			  var tmp = 0; 
 							$('.reasonOfVisitAdded').find('label .text').each(function(index){ 
 								if($(this).text().trim().toUpperCase()===reasonOfVisitVAl[i].trim().toUpperCase()) 
 								{	tmp = 1;
 								
 									return false;  }
 							});
 							if(tmp==1)
 							{
 			
 								swal(reasonOfVisitVAl[i].trim()+", Already Added!!");
 								continue;
 							}
 							//var visitReasonId=reasonOfVisitVAl[i]+'^'+$("#chiefComplaintSiteId").val()+'^'+$("#chiefComplaintNoOfDaysId").val()+'^'+$("#chiefComplaintDurationId").val()+"^";
 							var visitReasonId=reasonOfVisitVAl[i]+'^'+$("#chiefComplaintSiteId").val()+'^'+$("#chiefComplaintNoOfDaysId").val()+'^'+$("#chiefComplaintDurationId").val()+'^'+$("#reasonofvisitRemarksId").val();

 							//console.log('visitReasonId'+$('#chiefComplaintSiteId option:selected').text());
 							 //$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<a style="padding-left:5px"><label><input class="checkedInput" type="checkbox" name="visitReason" value="'+reasonOfVisitCode[i]+'^'+visitReasonId+'" checked> '+reasonOfVisitVAl[i]+'</label></a>');
 							var temp='';
 							//console.log($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 );
 							
 							if($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 ) 
 							 temp=$('#chiefComplaintSiteId option:selected').text() + '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ; 
 							else if($("#chiefComplaintSiteId").val() != 0)
 								 temp=$('#chiefComplaintSiteId option:selected').text() ;
 							else 
 								 temp= '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ;
 							
 							
 							
 							var chiefComplaintJson ={
 									"IsExternalVisit"	:		"1" ,
 									"VisitReasonName" : 		 reasonOfVisitVAl[i],
 									"VisitReasonCode" :			 reasonOfVisitCode[i],
 									"VisitReasonSideCode" : 		 $("#chiefComplaintSiteId").val() ,
 									"VisitReasonSideName" :			$('#chiefComplaintSiteId option:selected').text(),
 									"VisitReasonNoOfDays" : 	 $("#chiefComplaintNoOfDaysId").val() ,
 									"VisitComplaintDurationCode" : $("#chiefComplaintDurationId").val(),
 									"VisitComplaintDurationName" : $('#chiefComplaintDurationId option:selected').text(),
 									"VisitReasonRemarks"		: $("#reasonofvisitRemarksId").val()
 								};
 								
 								//console.log(JSON.stringify(chiefComplaintJson));
 								
 								
 								'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
 								
 							$(this).parent().parent().parent().parent().find('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs reasonOfVisitAdd " data-toggle="tooltip" title='+ temp +'>'+
 						    	 		'<input type="checkbox" class="checkedInput" name="visitReason" value="'+reasonOfVisitCode[i]+'^'+visitReasonId+'" checked="">  '+
 						    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
 						    	 		'<span class="text">'+reasonOfVisitVAl[i]+' </span>'+
 						    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 						    	 		'</button></label>');
 			 			   }
 						 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val('');
 				 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode','');
 			 		 }
 			 		else
 			 			 swal('Please Select atleast one reason');
 	 		}
 	 		else if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim() != ''){
 	 			//console.log(';;;;;;;;;15;;;;'+$(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val().trim());
 	            var generalComplaintVal = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val() ;  //$(this).parent().parent().find('input[name=generalComplaint]').val();
 	            if(generalComplaintVal.trim()!='')
 	             {  
 	               var tmp = 0; 
 	               $('.reasonOfVisitAdded').find('label .text').each(function(index){ 
 	                 if($(this).text().split("*")[0].trim().toUpperCase()===generalComplaintVal.trim().toUpperCase()) 
 	                 { tmp = 1; 
 	                   return false;  }
 	               });
 	               if(tmp==1)
 	               {
 	                 swal("Already Added!!");
 	                 $('#generalComplaintId').val('');
 	                 return false;
 	               }
 	               else
 	               {
 	            	  var generalComplaintChkBoxVal='';
 	                 var chiefComplaintNoOfDays=$(this).parent().parent().parent().find('input[name="chiefComplaintNoOfDays"]').val();
 	                 var siteId=$(this).parent().parent().parent().find('select[name="chiefComplaintSite"] option:selected').val();
 	                 var chiefComplaintDuration=$(this).parent().parent().parent().find('select[name="chiefComplaintDuration"] option:selected').val();
 	                 if(siteId != '0' || (chiefComplaintDuration != '0' && chiefComplaintNoOfDays !='')){
 	                     if(siteId != '0' && (chiefComplaintDuration != '0' && chiefComplaintNoOfDays !=''))
 	                        generalComplaintChkBoxVal='0^'+generalComplaintVal+'^'+siteId+'^'+chiefComplaintNoOfDays+'^'+chiefComplaintDuration;
 	                     else if(siteId != '0')
 	                        generalComplaintChkBoxVal='0^'+generalComplaintVal+'^'+siteId+'^0^0'; 
 	                     else if(chiefComplaintDuration != '0' && chiefComplaintNoOfDays !='')
 	                        generalComplaintChkBoxVal='0^'+generalComplaintVal+'^0^'+chiefComplaintNoOfDays+'^'+chiefComplaintDuration;
 	                     else{
 	                       swal('Please select all fields');
 	                       return false;
 	                     }
 	                 }
 	               /*  else if(chiefComplaintDuration != '0' &&  chiefComplaintNoOfDays == ''){
 	                   swal('Please enter no of days.');
 	                   return false;
 	                 }
 	                 else if(chiefComplaintDuration == '0' &&  chiefComplaintNoOfDays != ''){
 	                   swal('Please select duration.');
 	                   return false;
 	                 }*/
 	                 else{
 	                   var generalComplaintChkBoxVal='0^'+generalComplaintVal+'^0^^0';  
 	                 }
 	                 
 	                 //$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="visitReason" value="'+generalComplaintChkBoxVal+'"  checked> '+generalComplaintVal+'(ext)</label></a>');
 	                 var temp='';
 						//console.log($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 );
 						
 						if($("#chiefComplaintSiteId").val() != 0 && $("#chiefComplaintDurationId").val() != 0 ) 
 						 temp=$('#chiefComplaintSiteId option:selected').text() + '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ; 
 						else if($("#chiefComplaintSiteId").val() != 0)
 							 temp=$('#chiefComplaintSiteId option:selected').text() ;
 						else 
 							 temp= '[' + $("#chiefComplaintNoOfDaysId").val() + $('#chiefComplaintDurationId option:selected').text() +']' ;	
 						
 						//console.log('temp::::::::::'+temp);
 						//console.log('generalComplaintVal::::::::::'+generalComplaintVal);
 						//console.log('generalComplaintChkBoxVal::::::::::'+generalComplaintChkBoxVal);
 						
 						var chiefComplaintJson ={
 								"IsExternalVisit"	:		"1" ,
 								"VisitReasonName" : 		 generalComplaintVal,
 								"VisitReasonCode" :			 "0",
 								"VisitReasonSideCode" : 	 $("#chiefComplaintSiteId").val() ,
 								"VisitReasonSideName" :		$('#chiefComplaintSiteId option:selected').text(),
 								"VisitReasonNoOfDays" : 	 $("#chiefComplaintNoOfDaysId").val() ,
 								"VisitComplaintDurationCode" : $("#chiefComplaintDurationId").val(),
 								"VisitComplaintDurationName" : $('#chiefComplaintDurationId option:selected').text(),
 								"VisitReasonRemarks"		: $("#reasonofvisitRemarksId").val()
 							};
 							
 							//console.log(JSON.stringify(chiefComplaintJson));
 							
 						$(this).parent().parent().parent().parent().find('.reasonOfVisitAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs"  data-toggle="tooltip" title='+ temp +'>'+
 				    	 		'<input type="checkbox" class="checkedInput" name="visitReason" value="'+generalComplaintChkBoxVal+'" checked="">  '+
 				    	 		'<i class="text" style="display :none">'+JSON.stringify(chiefComplaintJson)+' </i>'+
 				    	 		'<span class="text">'+generalComplaintVal+'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 				    	 		'</button></label>');

 	               }
 	              
 	              //$(this).parent().parent().find('input[name=generalComplaint]').val('');
 	               $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').val('');
 			 	  $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR]').attr('reasonOfVisitCode','');
 	              $(this).parent().parent().find('input[name="chiefComplaintNoOfDays"]').val('');
 	              $(this).parent().parent().find('select[name="chiefComplaintSite"]').val('0');
 	              $(this).parent().parent().find('select[name="chiefComplaintDuration"] ').val('1');
 	             }
 	             else{
 	               swal('Please enter other general complaint to be added');
 	             }
 	     }
 	 		else
 	 			 {swal('Please Select atleast one reason');}
 	 		$('[data-toggle="tooltip"]').tooltip();
 	 	
 	    	
 	    	
 	    	
 	    	
 	    }
	});
	
 	$('.diagnosisAdd').click(function(){
 		if($('input[name=diagnosisDiseaseReference]').is(':checked'))
 		{
 			if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim().indexOf(';')>='0')
 	 		{
 				if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim()!='')
 		 		{  var diagnosisVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().split(';');
 			 	   var diagnosisCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode').split(';');
 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
 			 	   //console.log("diagnosisVAl -->> "+diagnosisVAl);
 			 	   //console.log("diagnosisCode --->> "+diagnosisCode);
 			 	  //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
 		 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
 		 		   	{
 		 			  var tmp = 0; 
 		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
 		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
 		 					{	tmp = 1; 
 		 						return false;  }
 		 				});
 		 				if(tmp==1)
 						{ 
 							swal(diagnosisVAl[i].trim()+", Already Added!!");
 							continue;
 						}
 		 				var strDiagnosisId=diagnosisCode[i]+'#'+diagnosisTypeCode+'#1^'+diagnosisVAl[i]+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteId").val()+'#'+$('input[name=diagnosisNoOfDays]').val()+'#'+$("#diagnosisDurationId").val()+'#'+$("#diagnosisRemarksId").val();
 				 		//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+diagnosisVAl[i]+'</label></a>');
 				 		
 		 				var temp=''; 
 		 				if($("#diagnosisSiteId").val()!= 0 && diagnosisTypeCode !=0)
 		 					temp=diagnosisTypeName +'['+ $("#diagnosisSiteId option:selected").text() +']';
 		 				else if($("#diagnosisSiteId").val()!= 0)
 		 					temp=+'['+ $("#diagnosisSiteId option:selected").text() +']';
 		 				else if(diagnosisTypeCode !=0 )
 		 					temp=diagnosisTypeName ;
 		 				
 		 				if($("#diagnosisRemarksId").val() !=''){
 		 					temp= temp+ $("#diagnosisRemarksId").val() ;
 		 				}
 		 				
 		 				/*if(diagnosisCode[i]!='')
 		 					temp= temp+' '+ diagnosisCode[i] ;*/
 		 				var DiagnosisJson ={
 		 						"IsSnomed"				:			"1" ,
 								"DiagnosisName" 		: 		 	diagnosisVAl[i],
 								"DiagnosisCode" 		:			diagnosisCode[i],
 								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
 								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
 								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
 								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
 								"DiagnosisRemarks"	:			$("#diagnosisRemarksId").val()
 							};
 							
 		 				//console.log(JSON.stringify(DiagnosisJson));
 		 				
 				 		$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs diagnosisClass" >'+
 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
 				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 				    	 		'</button></label>');
 		 		   	}
 		 		 tippy('.diagnosisClass', {
		              content: temp,
		              delay: 50,
		              arrow: true,
		              arrowType: 'round',
		              size: 'medium',
		              duration: 500,
		              animation: 'scale'
		          });
 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val('');
 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode','');
 			 		$(this).parent().parent().find('select[name=diagnosisSite] ').val('0');
 			 		$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
 			 		$(this).parent().parent().find('textarea[name=diagnosisRemarks]').val('');
 			 		 
 		 		 }
 				else
 		 			 swal('Please Select atleast one reason');
 	 		}
	 		else
	 			 swal('Please Select atleast one reason');
 		}
 		else{
 			 var investigationVAl = $(this).parent().parent().find('input[name=icdCodeInput]').val();  
 		 	 var isValid = 0;
 		 	 var invObj = $("#icdJsonObjDiv").text().trim(); //localStorage.getItem('icdJsonObj'); 
 	 		 invObj = JSON.parse(invObj.toString()); 
 	 		 for(var v=0; v<invObj.length;v++)
 	 		 { 
 	 			if (invObj[v].icdCode.toUpperCase() == investigationVAl.toUpperCase()) {
 	 				isValid=1;
 			        break;
 			    } 
 	 		  } 
 			if($(this).parent().parent().find('input[name=diseaseInput]').val().trim()!='')
	 		{  
 				var icdCode = $(this).parent().parent().find('input[name=icdCodeInput]').val();
 				var icdCodeVal = $(this).parent().parent().find('input[name=diseaseInput]').val(); 
		 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
		 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
		 	   //console.log('icdCodeVal ::: ::::: :::: '+icdCode+icdCodeVal); 
		 	   
		 	   var tmp = 0; 
				$('.diagnosisAdded').find('label .text').each(function(index){ 
					if($(this).text().trim().toUpperCase()===icdCodeVal.trim().toUpperCase()) 
					{	tmp = 1; 
						return false;  }
				});
				if(tmp==1)
				{ 
					swal(icdCodeVal.trim()+", Already Added!!"); 
				}
				else
				{					  
					var strDiagnosisId=icdCode+'#'+diagnosisTypeCode+'#0^'+icdCodeVal+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteIcdId").val()+'#'+$("#diagnosisNoOfDaysIcdId").val()+'#'+$("#diagnosisDurationIcdId").val()+'#'+$("#diagnosisRemarksIcdId").val();
					//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+icdCodeVal+'</label></a>');
					
					var DiagnosisJson ={
		 						"IsSnomed"				:			"2" ,
								"DiagnosisName" 		: 		 	icdCodeVal,
								"DiagnosisCode" 		:			icdCode,
								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
								"DiagnosisRemarks"	:				$("#diagnosisRemarksIcdId").val()
							};
							
					//console.log(JSON.stringify(DiagnosisJson));
					var temptoggle='';
					if(diagnosisTypeName != '' ) 
						temptoggle =diagnosisTypeName ;
					if($('#diagnosisSiteId option:selected').text() !='')
						temptoggle =temptoggle +'['+$('#diagnosisSiteId option:selected').text() +']' ;
						
					if($("#diagnosisRemarksIcdId").val() !=''){
						temptoggle = temptoggle  +$("#diagnosisRemarksIcdId").val() ; 
					}
					if(icdCode != '' ) 
						temptoggle =temptoggle +' '+icdCode;
					//console.log("temptoggle---"+temptoggle);
					$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs diagnosisClass">'+
			    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="">  '+
			    			'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
			    	 		'<span class="text">'+icdCodeVal+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
			 	}
				
				tippy('.diagnosisClass', {
		              content: temptoggle,
		              delay: 50,
		              arrow: true,
		              arrowType: 'round',
		              size: 'medium',
		              duration: 500,
		              animation: 'scale'
		          });
				
				 $(this).parent().parent().find('input[name=diseaseInput]').val('');
		 		 $(this).parent().parent().find('input[name=icdCodeInput]').val('');  
		 		$(this).parent().parent().find('select[name=diagnosisSiteIcd] ').val('0');
			 	$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
			 	$(this).parent().parent().find('textarea[name=diagnosisRemarksIcd]').val('');
			 		
	 		 }
	 		else
	 			 swal('Please Select atleast one reason');
 			 
 			
 			
 			 
 			
 		}
 		//$('[data-toggle="tooltip"]').tooltip();
 	});
 	
 	 $("input[name=diseaseInput]").on('select:flexdatalist', function (e, set, options) {
	  	    var val = set.diagnosisName;
	  	    /*if($('#ICDcodeLst option').filter(function(){
	  	        return this.value === val;        
	  	    }).length) {
	  	    	var diseaseInputVAl1 = $(this).parent().find('#ICDcodeLst option[value="'+val+'"]').attr('id');*/  
	  	    	var icdCodeInputVAl1 = set.icdCode;
	  	    	$(this).parent().parent().parent().find('input[name=icdCodeInput]').val(icdCodeInputVAl1); 
	  	    /*}*/
	  	    	

	  	   	//$("input[name=flexdatalist-diseaseInput]").on('keypress', function (e) {
	  	   		//console.log('15635555...............');
	  	   		if (!e) e = window.event;
	  	   	    var keyCode = e.keyCode || e.which;
	  	   	    //console.log(keyCode)
	  	   	    if (true){
	  	   	    	//console.log('2');	

	  	   	 		if($('input[name=diagnosisDiseaseReference]').is(':checked'))
	  	   	 		{
	  	   	 			if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim().indexOf(';')>='0')
	  	   	 	 		{
	  	   	 				if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim()!='')
	  	   	 		 		{  var diagnosisVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().split(';');
	  	   	 			 	   var diagnosisCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode').split(';');
	  	   	 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
	  	   	 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
	  	   	 			 	   //console.log("diagnosisVAl -->> "+diagnosisVAl);
	  	   	 			 	   //console.log("diagnosisCode --->> "+diagnosisCode);
	  	   	 			 	  //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
	  	   	 		 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
	  	   	 		 		   	{
	  	   	 		 			  var tmp = 0; 
	  	   	 		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
	  	   	 		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
	  	   	 		 					{	tmp = 1; 
	  	   	 		 						return false;  }
	  	   	 		 				});
	  	   	 		 				if(tmp==1)
	  	   	 						{ 
	  	   	 							swal(diagnosisVAl[i].trim()+", Already Added!!");
	  	   	 							continue;
	  	   	 						}
	  	   	 		 				var strDiagnosisId=diagnosisCode[i]+'#'+diagnosisTypeCode+'#1^'+diagnosisVAl[i]+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteId").val()+'#'+$('input[name=diagnosisNoOfDays]').val()+'#'+$("#diagnosisDurationId").val()+'#'+$("#diagnosisRemarksId").val();
	  	   	 				 		//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+diagnosisVAl[i]+'</label></a>');
	  	   	 				 		
	  	   	 		 				var temp=''; 
	  	   	 		 				if($("#diagnosisSiteId").val()!= 0 && diagnosisTypeCode !=0)
	  	   	 		 					temp=diagnosisTypeName +'['+ $("#diagnosisSiteId option:selected").text() +']';
	  	   	 		 				else if($("#diagnosisSiteId").val()!= 0)
	  	   	 		 					temp=+'['+ $("#diagnosisSiteId option:selected").text() +']';
	  	   	 		 				else if(diagnosisTypeCode !=0 )
	  	   	 		 					temp=diagnosisTypeName ;
	  	   	 		 				
	  	   	 		 				if($("#diagnosisRemarksId").val() !=''){
	  	   	 		 					temp= temp+ $("#diagnosisRemarksId").val() ;
	  	   	 		 				}
	  	   	 		 				var DiagnosisJson ={
	  	   	 		 						"IsSnomed"				:			"1" ,
	  	   	 								"DiagnosisName" 		: 		 	diagnosisVAl[i],
	  	   	 								"DiagnosisCode" 		:			diagnosisCode[i],
	  	   	 								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
	  	   	 								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
	  	   	 								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
	  	   	 								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
	  	   	 								"DiagnosisRemarks"	:			$("#diagnosisRemarksId").val()
	  	   	 							};
	  	   	 							
	  	   	 		 				//console.log(JSON.stringify(DiagnosisJson));
	  	   	 		 				
	  	   	 				 		$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs diagnosisClass" >'+
	  	   	 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
	  	   	 				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
	  	   	 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
	  	   	 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	  	   	 				    	 		'</button></label>');
	  	   	 		 		   	}
		  	   	 		 	tippy('.diagnosisClass', {
		  		              content: temp,
		  		              delay: 50,
		  		              arrow: true,
		  		              arrowType: 'round',
		  		              size: 'medium',
		  		              duration: 500,
		  		              animation: 'scale'
		  		          });
	  	   	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val('');
	  	   	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode','');
	  	   	 			 		$(this).parent().parent().find('select[name=diagnosisSite] ').val('0');
	  	   	 			 		$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
	  	   	 			 		$(this).parent().parent().find('textarea[name=diagnosisRemarks]').val('');
	  	   	 			 		 
	  	   	 		 		 }
	  	   	 				else
	  	   	 		 			 swal('Please Select atleast one reason');
	  	   	 	 		}
	  	   		 		else
	  	   		 			 swal('Please Select atleast one reason');
	  	   	 		}
	  	   	 		else{
	  	   	 			 var investigationVAl = $(this).parent().parent().find('input[name=icdCodeInput]').val();  
	  	   	 		 	 var isValid = 0;
	  	   	 		 	 var invObj = $("#icdJsonObjDiv").text().trim();  //localStorage.getItem('icdJsonObj'); 
	  	   	 	 		 invObj = JSON.parse(invObj.toString()); 
	  	   	 	 		 for(var v=0; v<invObj.length;v++)
	  	   	 	 		 { 
	  	   	 	 			if (invObj[v].icdCode.toUpperCase() == investigationVAl.toUpperCase()) {
	  	   	 	 				isValid=1;
	  	   	 			        break;
	  	   	 			    } 
	  	   	 	 		  } 
	  	   	 			if($(this).parent().parent().find('input[name=diseaseInput]').val().trim()!='')
	  	   		 		{  
	  	   	 				var icdCode = $(this).parent().parent().find('input[name=icdCodeInput]').val();
	  	   	 				var icdCodeVal = $(this).parent().parent().find('input[name=diseaseInput]').val(); 
	  	   			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
	  	   			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
	  	   			 	   //console.log('icdCodeVal ::: ::::: :::: '+icdCode+icdCodeVal); 
	  	   			 	   
	  	   			 	   var tmp = 0; 
	  	   					$('.diagnosisAdded').find('label .text').each(function(index){ 
	  	   						if($(this).text().trim().toUpperCase()===icdCodeVal.trim().toUpperCase()) 
	  	   						{	tmp = 1; 
	  	   							return false;  }
	  	   					});
	  	   					if(tmp==1)
	  	   					{ 
	  	   						swal(icdCodeVal.trim()+", Already Added!!"); 
	  	   					}
	  	   					else
	  	   					{					  
	  	   						var strDiagnosisId=icdCode+'#'+diagnosisTypeCode+'#0^'+icdCodeVal+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteIcdId").val()+'#'+$("#diagnosisNoOfDaysIcdId").val()+'#'+$("#diagnosisDurationIcdId").val()+'#'+$("#diagnosisRemarksIcdId").val();
	  	   						//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+icdCodeVal+'</label></a>');
	  	   						
	  	   						var DiagnosisJson ={
	  	   			 						"IsSnomed"				:			"2" ,
	  	   									"DiagnosisName" 		: 		 	icdCodeVal,
	  	   									"DiagnosisCode" 		:			icdCode,
	  	   									"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
	  	   									"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
	  	   									"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
	  	   									"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
	  	   									"DiagnosisRemarks"	:			$("#diagnosisRemarksIcdId").val()
	  	   								};
	  	   								
	  	   						//console.log(JSON.stringify(DiagnosisJson));
	  	   						var temptoggle='';
	  	   						if(diagnosisTypeName != '' ) 
	  	   							temptoggle =diagnosisTypeName ;
	  	   						if($('#diagnosisSiteId option:selected').text() !='')
	  	   							temptoggle =diagnosisTypeName +'['+$('#diagnosisSiteId option:selected').text() +']' ;
	  	   							
	  	   						if($("#diagnosisRemarksIcdId").val() !=''){
	  	   							temptoggle = temptoggle  +$("#diagnosisRemarksIcdId").val() ; 
	  	   						}
	  	   						if(icdCode != '' ) 
	  	   							temptoggle =temptoggle +' '+icdCode;
	  	   						$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs diagnosisClass">'+
	  	   				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
	  	   				    			'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
	  	   				    	 		'<span class="text">'+icdCodeVal+' </span>'+
	  	   				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	  	   				    	 		'</button></label>');
	  	   				 	}
		  	   				tippy('.diagnosisClass', {
		  		              content: temptoggle,
		  		              delay: 50,
		  		              arrow: true,
		  		              arrowType: 'round',
		  		              size: 'medium',
		  		              duration: 500,
		  		              animation: 'scale'
		  		          });
	  	   					 $(this).parent().parent().find('input[name=diseaseInput]').val('');
	  	   			 		 $(this).parent().parent().find('input[name=icdCodeInput]').val('');  
	  	   			 		$(this).parent().parent().find('select[name=diagnosisSiteIcd] ').val('0');
	  	   				 	$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
	  	   				 	$(this).parent().parent().find('textarea[name=diagnosisRemarksIcd]').val('');
	  	   				 		
	  	   		 		 }
	  	   		 		else
	  	   		 			 swal('Please Select atleast one reason');
	  	   	 			 
	  	   	 			
	  	   	 			
	  	   	 			 
	  	   	 			
	  	   	 		}
	  	   	 		//$('[data-toggle="tooltip"]').tooltip();
	  	   	 		
	  	   	    }
	  	   	
	  	});
 	 
	/*$("input[name=txt-snomed-ct-search_VR2]").on('keypress', function (e) {
 		if (!e) e = window.event;
 	    var keyCode = e.keyCode || e.which;
 	    if (keyCode == '13'){ 
 	 		if($(this).val().trim().indexOf(';')>='0')
 	 		{  var diagnosisVAl = $(this).val().split(';');
		 	   var diagnosisCode = $(this).attr('diagnosisCode').split(';');
		 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
		 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
		 	   //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
	 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
	 			   {
		 			  var tmp = 0; 
		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
		 					{	tmp = 1; 
		 						return false;  }
		 				});
		 				if(tmp==1)
						{ 
							swal(diagnosisVAl[i].trim()+", Already Added!!");
							continue;
						}
				 		//$(this).parent().parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+diagnosisCode[i]+'#'+diagnosisTypeCode+'" checked> '+diagnosisVAl[i]+'</label></a>');
				 		 
		 				$(this).parent().parent().parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs">'+
 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+diagnosisCode[i]+'#'+diagnosisTypeCode+'" checked="">  '+
 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 				    	 		'</button></label>');
	 			   }
		 		 $(this).val('');
		 		 $(this).attr('diagnosisCode','');
 	 		 }
 	 		else
 	 			 swal('Please Select atleast one reason');
 	      return true;
 	    }
	});*/

 	document.getElementById('externalDrugStartDate').valueAsDate = new Date();
 	document.getElementById('drugStartDate').valueAsDate = new Date();
 	document.getElementById('stockDrugStartDate').valueAsDate = new Date();
 	var dtVal = new Date(); 
 	var curDate = dtVal.getDate();
 	curDate = curDate.toString().length>1 ? curDate : "0"+curDate;
 	var curMon = dtVal.getMonth() + 1;
 	curMon = curMon.toString().length>1 ? curMon : "0"+curMon;
 	//alert(curDate+'------: '+curMon);
 	$('#drugStartDate').attr('min',dtVal.getFullYear()+"-"+curMon +"-"+curDate);
 	$('input[name=followUpPlannedVisitDate]').attr('min',dtVal.getFullYear()+"-"+curMon +"-"+curDate);
 	
/*
 	
 	$('input[name=drugName]').on('change:flexdatalist',function(){
 		var drugName = $(this).val();
 		//console.log(drugName);
 		let f = 0;
 		if(this.value.trim()==''){
 			$('#drugDosageId').html(doaseCmbValue);
 		}
 		//$.each(JSON.parse(localStorage.getItem('drugJsonObj')), function(i, v) { 
 		$.each(JSON.parse($("#drugJsonObjDiv").text().trim()), function(i, v) {
		    if (v.drugName.toUpperCase() == drugName.toUpperCase()) {
		        //console.log(v.drugId+'::::::::>>>>'+v.drugName);
		        
		        var intemtype=(v.drugId).split('#')[1];
		        //console.log( $('#drugDosageId').html());
		        var options = $('#drugDosageId option');
		        var tempcount=0;
		        var values = $.map(options ,function(option) {
		        	//console.log(intemtype == (option.value).split('^')[3]);
		        	if(intemtype == (option.value).split('^')[3])
		        		{
		        			$("#drugDosageId").val(option.value);
		        			tempcount =1 ;
		        			 
		        		}else{
		        			//$(this).remove();
		        			//tempcount=0;
		        			$("#drugDosageId option[value='"+option.value+"']").remove();
		        		}
		        	$("#drugDosageId").prop("selectedIndex", 0);
		        	////console.log(':::::::1222::'+'#drugDosageId').html());
		        	
		            return option.value;
		        });
		        ////console.log(tempcount + 'tempcounttempcounttempcount');
		        if(tempcount == 0){
		        	
		        	$("#drugDosageId").empty().append('<option value="0">Select</option>');
		        }
		        	
		       // //console.log(values);
		        ////console.log($('select[name=drugDosage]') + ' intemtype ' +intemtype);
		        
		        f=1;
		        return;
		    } 
		 });
 		if(f==1)
 			$('input[name=flexdatalist-drugName]').css('background-color','#FFFFFF');
 		else 
 			$('input[name=flexdatalist-drugName]').css('background-color','#FBE2E2');
 			
<<<<<<< .mine
 		
 	});*/

 	
 	$('#btnAddNewRegisteredDrug').click(addNewRegisteredDrug);
 		
 	$('#btnExternalDrugsAdviceAddId').click(addNewExternalDrug);


 	$('input[name=drugsAdvicesAll]').on('change',function(){   
 		if($(this).is(':checked'))
 		{ 
 			////console.log(1+"checked");
 			$(this).parent().parent().parent().parent().find('.checkedInput:not(:disabled)').prop('checked',true);
 		}
 		else
 		{	 
 			////console.log(2+"unchecked");
 			$(this).parent().parent().parent().parent().find('.checkedInput:checked:not(:disabled)').prop('checked',false);
 		}
 	});
 	 	
 	/*$('input[name=investigation]').on('input',function(){
 		var investigation = $(this).val();
 		if($('#investigationLstTest option').filter(function(){
	 		   return this.value === investigation;        
	 		  }).length) 
 			{
				$(this).removeAttr('style');
 				return true;
 			}
 		else
 			{
 				$(this).css('background-color','#FBE2E2');
 			} 
 	});*/
 	$('input[name=investigation]').on('change:flexdatalist',function(){
 		var investigation = $(this).val(); 
 		let f = 0;
 		var invObj = $("#testJsonObjDiv").text().trim();//localStorage.getItem('testJsonObj'); 
 		invObj = JSON.parse(invObj); 
 		for(var v=0; v<invObj.length;v++)
 		{ 
 			if (invObj[v].testName.toUpperCase() == investigation.toUpperCase()) {
		        //console.log(invObj[v].testName+'::::::::>>>>'+invObj[v].testId);
		        f=1;
		        break;
		    } 
 		} 
 		if(f==1)
 			$('input[name=flexdatalist-investigation]').css('background-color','#FFFFFF');
 		else 
 			$('input[name=flexdatalist-investigation]').css('background-color','#FBE2E2'); 
 	});
 	
 	/*$('input[name=clinicalProcedureName]').on('change:flexdatalist',function(){
 		var investigation = $(this).val(); 
 		let f = 0;
 		var invObj = $("#ClinicalProcedureJsonObjDiv").text().trim(); // localStorage.getItem('ClinicalProcedureObj'); 
 		invObj = JSON.parse(invObj); 
 		for(var v=0; v<invObj.length;v++)
 		{ 
 			if (invObj[v].testName.toUpperCase() == investigation.toUpperCase()) {
		        //console.log(invObj[v].testName+'::::::::>>>>'+invObj[v].testId);
		        f=1;
		        break;
		    } 
 		} 
 		if(f==1)
 			$('input[name=flexdatalist-clinicalProcedureName]').css('background-color','#FFFFFF');
 		else 
 			$('input[name=flexdatalist-clinicalProcedureName]').css('background-color','#FBE2E2'); 
 	});*/
 	
 	
 	$('.investigationAdd').click(function(){
 		
		 var investigationVAl = $(this).parent().parent().find('input[name=investigation]').val();  
	 	 var isValid = 0;
	 	 var invObj = $("#testJsonObjDiv").text().trim();//localStorage.getItem('testJsonObj'); 
 		 invObj = JSON.parse(invObj.toString());
 		 var testCode = '';
 		 for(var v=0; v<invObj.length;v++)
 		 { 
 			if (invObj[v].testName.toUpperCase() == investigationVAl.toUpperCase()) {
 				isValid=1;
 				testCode = invObj[v].testId.split('^')[0];
		        break;
		    } 
 		  } 
 		 if(investigationVAl.trim()=='' &&  $('input[name=externalInvestigation]').val().trim() =='') 
		{
		  swal('Please enter investigation to be added');
		  return false; 
		}
	 		 
 		var reason =0;
 		$('input[name=reasonOfVisit]').each(function()
		{
 			var reasonTestCode = $(this).val().split('^')[0];
 			var reasonEpiCode = $(this).val().split('^')[8];
 			var reasonVisitNo = $(this).val().split('^')[9];
 			
			////console.log('invest val='+investigationVAl+"--"+$('#patEpisodeCodePrescriptionPanel').text());
			////console.log('Visit NO='+$('#patEpisodeVisitNoPrescriptionPanel').text());
			////console.log('testCode ='+testCode);
			////console.log(reasonTestCode);
			if(reasonTestCode===testCode && reasonEpiCode===$('#patEpisodeCodePrescriptionPanel').text() && reasonVisitNo === $('#patEpisodeVisitNoPrescriptionPanel').text()){
				reason =1;
			}				
		});
 		if(reason==1)
		{
			swal("The test you are trying to add is already raised today");
			$('input[name=investigation]').val(''); 
	     	 $(this).parent().parent().find('select[name=investigationSite]').val('0');
			 $(this).parent().parent().find('#InvestigationRemarksId').val('');
	     	 $('input[name=flexdatalist-investigation]').css('background-color','#ffffff');
			return false;
		}
 		
	  if(isValid==1)
	  {  
		    var tmp = 0; 
			$('.investigationAdded').find('label .text').each(function(index){ 
				if($(this).text().trim().toUpperCase()===investigationVAl.trim().toUpperCase()) 
				{	tmp = 1; 
					return false;  }
			});
			if(tmp==1)
			{
				swal("Already Added!!");
				return false;
			}
			if(isValid==1) {   
			 var investigationVAl1='';
		 	 var invObj = $("#testJsonObjDiv").text().trim();//localStorage.getItem('testJsonObj'); 
	 		 invObj = JSON.parse(invObj.toString()); 
			 for(var v=0; v<invObj.length;v++)
	 		 { 
	 			if (invObj[v].testName.toUpperCase() == investigationVAl.toUpperCase()) {
	 				investigationVAl1 = invObj[v].testId;  /*+'^'+$("#investigationSiteId").val()+'^'+$("#investigationRemarksId").val();;*/ 
			        break;
			    } 
	 		  }   
 		//$(this).parent().parent().parent().find('.investigationAdded').append('<a style="padding-left: 5px;" class="'+investigationVAl1.trim().split('^')[4].trim().split(' ').join('_')+'"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+investigationVAl1+'"  checked> '+investigationVAl+'</label></a>');
			 var siteId=$(this).parent().parent().find('select[name="investigationSite"] option:selected').text();
			 var InvestigationDtlsJson = {
					 "IsExternal"   :   "0" ,
					 "TestName" 	:   investigationVAl ,
		    		 "TestCode"		:	investigationVAl1.split('^')[0] ,
		    		 "LabCode"		:	investigationVAl1.split('^')[1] ,
		    		 "SampleCode"	:	investigationVAl1.split('^')[2] ,
		    		 "SampleName"	:	investigationVAl1.split('^')[3] ,
		    		 "LabName"		:	investigationVAl1.split('^')[4] ,
		    		 "IsTestGroup"	:	investigationVAl1.split('^')[6] ,
		    		 "SideCode"		:	$("#investigationSiteId").val() ,
		    		 "SideName"		:	siteId ,
		    		 "SideRemarks"	:	$("#InvestigationRemarksId").val() ,
		    		 "EpisodeCode"	:	$('#patEpisodeCodePrescriptionPanel').text() ,
		    		 "VisitNo"		:	$('#patEpisodeVisitNoPrescriptionPanel').text() ,
		    		 "tariffId"		:	"0"
		     }
			 
			 investigationVAl1 +='^0^'+$('#patEpisodeCodePrescriptionPanel').text()+'^'+$('#patEpisodeVisitNoPrescriptionPanel').text();
			 var sideremks=' ';
			 if($("#investigationSiteId").val() !='' && $("#investigationSiteId").val() !='0')
				 sideremks = sideremks + '('+ siteId + ')' ;
			 if($("#InvestigationRemarksId").val() != '')
				 sideremks = sideremks + ' ('+ $("#InvestigationRemarksId").val() +')' ;
			 
			 //console.log(isValid+"---"+JSON.stringify(InvestigationDtlsJson));
			 
 		$(this).parent().parent().parent().find('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs '+investigationVAl1.trim().split('^')[4].trim().split(' ').join('_')+'">'+
 		 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+investigationVAl1+'" checked="">  '+
 		 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
 		 		'<span class="text text1">'+investigationVAl + sideremks +' </span>'+
 		 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
 		 		'</button></label>');
 		 
 		tippy('.'+investigationVAl1.trim().split('^')[4].trim().split(' ').join('_'), {
            content: investigationVAl1.trim().split('^')[4].trim(),
            delay: 50,
            arrow: true,
            arrowType: 'round',
            size: 'medium',
            duration: 500,
            animation: 'scale'
        });
     	 $('input[name=investigation]').val(''); 
     	 $(this).parent().parent().find('select[name=investigationSite]').val('0');
		 $(this).parent().parent().find('#InvestigationRemarksId').val('');
     	 $('input[name=flexdatalist-investigation]').css('background-color','#ffffff');
			}
		else
			{ 
		    	 $('input[name=investigation]').val(''); 
				 swal('Please select test from list');
		     	 $('input[name=flexdatalist-investigation]').css('background-color','#ffffff');
			} 
	  }
	  else{
		// as per requirement only data from list should be selected so returning after giving this message
		 swal("The newly created test (not selected from the dropdown list) will not be added !!");
		  return;
		  var tmp = 0; 
			$('.investigationAdded').find('label .text').each(function(index){ 
				if($(this).text().split('*')[0].trim().toUpperCase()===$('input[name=investigation]').val().trim().toUpperCase()) 
				{	tmp = 1; 
					return false;  }
			});
			if(tmp==1)
			{
				swal("Already Added!!");
				 $('input[name=investigation]').val(''); 
				return false;
			}
		  //$(this).parent().parent().parent().find('.investigationAdded').append('<a style="padding-left: 5px;" class="'+$('input[name=externalInvestigation]').val().trim()+'"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="0^0^0^bld"  checked> '+$('input[name=externalInvestigation]').val().trim()+'</label></a>');
			 var siteId=$(this).parent().parent().find('select[name="investigationSite"] option:selected').text();
			 var InvestigationDtlsJson = {
					 "IsExternal"   :   "1" ,
					 "TestName" 	:   $('input[name=investigation]').val().trim() ,
		    		 "TestCode"		:	"0" ,
		    		 "LabCode"		:	"0" ,
		    		 "SampleCode"	:	"0" ,
		    		 "SampleName"	:	"0" ,
		    		 "LabName"		:	"0",  
		    		 "IsTestGroup"	:	"0"	,
		    		 "SideCode"		:	$("#investigationSiteId").val() ,
		    		 "SideName"		:	siteId ,
		    		 "SideRemarks"	:	$("#InvestigationRemarksId").val() ,
		    		 "EpisodeCode"	:	$('#patEpisodeCodePrescriptionPanel').text() ,
		    		 "VisitNo"		:	$('#patEpisodeVisitNoPrescriptionPanel').text() ,
		    		 "tariffId"		:	"0"
		     }
			 
			 var txtInvestList="0^0^0^0^0^0^0^0^"+$('#patEpisodeCodePrescriptionPanel').text()+"^"+$('#patEpisodeVisitNoPrescriptionPanel').text();
			 //console.log(isValid+"---"+JSON.stringify(InvestigationDtlsJson));
			 var sideremks=' ';
			 if($("#investigationSiteId").val() !='' && $("#investigationSiteId").val() !='0')
				 sideremks = sideremks + '('+ siteId + ')' ;
			 if($("#InvestigationRemarksId").val() != '')
				 sideremks = sideremks + ' ('+ $("#InvestigationRemarksId").val() +')' ;
			
		  $(this).parent().parent().parent().find('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs '+$('input[name=investigation]').val().trim()+'">'+
	    	 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+txtInvestList+'" checked="">  '+
	    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
	    	 		'<span class="text text1">'+$('input[name=investigation]').val().trim()+ sideremks +'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
	    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	    	 		'</button></label>');
		  $('input[name=investigation]').val(''); 
		  $(this).parent().parent().find('select[name=investigationSite]').val('0');
			 $(this).parent().parent().find('#InvestigationRemarksId').val('');
		/*  swal('Please enter investigation to be added');*/
	  }
 	});
 	
 	/* On key Press Enter */// use 'keyup' when test is to be added as soon as it is selected using enter key.
 	
 	$(document).ready(function(){
	 	$('input[name=flexdatalist-investigation]').on('keypress', function (e) {
	 		
	 		if (!e) e = window.event;
	 	    var keyCode = e.keyCode || e.which;
	 	    if (keyCode == '13'){
	 	    	//console.log('add investigation test on keypress....');
	 	    	$(this).closest(".investigationsDiv").find("#investigationAddId").trigger("click");
	 	    }
		});
 	});
 	/*$(document).ready(function(){
	 	$('input[name=flexdatalist-clinicalProcedureName').on('keypress', function (e) {
	 		
	 		if (!e) e = window.event;
	 	    var keyCode = e.keyCode || e.which;
	 	    if (keyCode == '13'){
	 	    	//console.log('add clinical procedure name on keypress....');
	 	    	$(this).closest(".ClinicalPrcoeduresDiv").find("#clinicalProceduresAddId").trigger("click");
	 	    }
		});
 	});*/
 	
 	$('.externalInvestigationAdd').click(function(){
		 var investigationVAl = $(this).parent().parent().parent().find('input[name=externalInvestigation]').val(); 
	  if(investigationVAl.trim()!='')
	  {  
		    var tmp = 0; 
			$('.investigationAdded').find('label').each(function(index){ 
				if($(this).text().split("(")[0].trim().toUpperCase()===investigationVAl.trim().toUpperCase()) 
				{	tmp = 1; 
					return false;  }
			});
			if(tmp==1)
			{
				swal("Already Added!!");
				return false;
			}
		  
		var investigationVAl1 = '0^0^0^0^0';
 		// alert(investigationVAl1);
 		 $(this).parent().parent().parent().find('.investigationAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+investigationVAl1+'"  checked> '+investigationVAl+'<sup style="color:red; font-weight:bold;">*</sup></label></a>');

		 $(this).parent().parent().parent().find('input[name=externalInvestigation]').val(''); 
	  }
	  else{
		  swal('Please enter external investigation to be added');
	  }
 	});
 	
 	$("input[name=externalInvestigation]").on('keypress', function (event) {
 		if (event.which != 13) 
 	     return true;
	     
	    var val = this.value;
	    //console.log('val:::::::><>>>>'+val);
	    var tmp = 0; 
		$('.investigationAdded').find('label .text').each(function(index){ 
			if($(this).text().trim().toUpperCase()===val.trim().toUpperCase()) 
			{	tmp = 1; 
				return false;  }
		});
		if(tmp==1)
		{
			swal("Already Added!!");
			$(this).val('');
			return false;
		} 
	    	var investigationVAl1 = '0^0^0^0^0';
	    	
	    	 var InvestigationDtlsJson = {
					 "IsExternal"   :   "1" ,
					 "TestName" 	:   $('input[name=externalInvestigation]').val().trim() ,
		    		 "TestCode"		:	"0" ,
		    		 "LabCode"		:	"0" ,
		    		 "SampleCode"	:	"0" ,
		    		 "SampleName"	:	"0" ,
		    		 "LabName"		:	"0",  
		    		 "IsTestGroup"	:	"0"	
		     }
	    	 //console.log(JSON.stringify(InvestigationDtlsJson));
	    	//$(this).parent().parent().parent().parent().find('.investigationAdded').append('<a style="padding-left: 5px;" class="'+investigationVAl1.trim().split('^')[4].trim().split(' ').join('_')+'"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+investigationVAl1+'"  checked> '+val+'</label></a>');
	    	
	    	$(this).parent().parent().parent().parent().find('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs '+$('input[name=externalInvestigation]').val().trim()+'">'+
	    	 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+investigationVAl1+'" checked="">  '+
	    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
	    	 		'<span class="text text1">'+$('input[name=externalInvestigation]').val().trim()+'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
	    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	    	 		'</button></label>');
	    	
	    	$(this).val(''); 
	});
 	


 	$('.investigationBookmarkAddBtn').click(function(){
 		var tmp = 0;var arr = [];var testNameArr='';
		 $(this).parent().parent().find('input[name=bookmarkSubTest]:checked').each(function(index){
		     var subTestName = $(this).parent().text();
		     var testCode = $(this).val().split('^')[0];
		     var temp=0;
				$('.investigationAdded').find('label .checkedInput').each(function(index){ 
					////console.log("value=="+$(this).val());
					////console.log("value=="+$(this).val().split('^').length);
					//if($(this).val().split('^').length == 7)
					//{
						if($(this).val().split('^')[0]===testCode && $(this).val().split('^')[8]===$('#patEpisodeCodePrescriptionPanel').text() && $(this).val().split('^')[9]===$('#patEpisodeVisitNoPrescriptionPanel').text()) 
						{	
							arr.push(subTestName.trim());
							tmp++;
							temp=1;
						}		
					//}
					/*else
					{
						if($(this).val().split('^')[0]===testCode && $(this).val().split('^')[7]===$('#patEpisodeCodePrescriptionPanel').text() && $(this).val().split('^')[8]===$('#patEpisodeVisitNoPrescriptionPanel').text()) 
						{	
							arr.push(subTestName.trim());
							tmp++;
							temp=1;
						}
					}*/
					
				});
				if(temp==1)
					{
						//console.log("count=="+tmp);
					}
				else{
		     var subTestNameVal = $(this).val()+"^"+$('#patEpisodeCodePrescriptionPanel').text()+'^'+$('#patEpisodeVisitNoPrescriptionPanel').text();
			     //console.log('subTestName:::'+subTestName+':::subTestNameVal:::'+subTestNameVal);
			     
			     var InvestigationDtlsJson = {
			    		 "IsExternal"   :   "0" ,
						 "TestName" 	:   subTestName ,
			    		 "TestCode"		:	subTestNameVal.split('^')[0] ,
			    		 "LabCode"		:	subTestNameVal.split('^')[1] ,
			    		 "SampleCode"	:	subTestNameVal.split('^')[2] ,
			    		 "SampleName"	:	subTestNameVal.split('^')[3] ,
			    		 "LabName"		:	subTestNameVal.split('^')[4] ,
			    		 "IsTestGroup"	:	subTestNameVal.split('^')[6] ,
			    		 "EpisodeCode"	:	subTestNameVal.split('^')[8] ,
			    		 "VisitNo"		:	subTestNameVal.split('^')[9] ,
			    		 "tariffId"		:	subTestNameVal.split('^')[7]
			     }
			     //console.log(JSON.stringify(InvestigationDtlsJson));
			     
				 //$('.investigationAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+subTestNameVal+'"  checked> '+subTestName+'</label></a>');
				 
				 $('.investigationAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs '+subTestNameVal.trim().split('^')[4].trim().split(' ').join('_')+'">'+
			    	 		'<input type="checkbox" class="checkedInput" name="reasonOfVisit" value="'+subTestNameVal+'" checked="">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(InvestigationDtlsJson)+' </i>'+
			    	 		'<span class="text text1">'+subTestName+' </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
				 
				 tippy('.'+subTestNameVal.trim().split('^')[4].trim().split(' ').join('_'), {
			            content: subTestNameVal.trim().split('^')[4].trim(),
			            delay: 50,
			            arrow: true,
			            arrowType: 'round',
			            size: 'medium',
			            duration: 500,
			            animation: 'scale'
				 });
				 
				}
 	 	});
		 if(tmp>0)
			 {
			 	for (var y=0; y<arr.length; y++)
			    {
			 		if(y==arr.length-1)
			 			testNameArr += arr[y];
			 		else
			 			testNameArr += arr[y]+' ,';
			    }
				swal(testNameArr+" already added!!!");
				//return false;
			 }
		 $(this).parent().parent().parent().find('.close').click();
		 
 	}); 

 	$('.investigationTestTriggerBtn').click(function(){
 		 var testName = $(this).text(); 
 		 $('#investigationTestBundle .bookmarkTestName').text(testName); 
 	});

 	$('input[name=investigationSearchOn]').on('change',function(){
 		if($(this).val()==2)
 			$('input[name=investigation]').attr('list','investigationLstTestCode');
 		else
 			$('input[name=investigation]').attr('list','investigationLstTest');

 	});

 	$('input[name=bookmarksToAdd]').on('change', function(){
 		if($(this).val() == 1)
 		{
	 		$(this).parent().parent().parent().parent().find('.LabWiseTestButtons').slideUp();
			$(this).parent().parent().parent().parent().find('.AddToBookMarkButtons').slideDown();
 	 	}
 		else
 		{
			$(this).parent().parent().parent().parent().find('.AddToBookMarkButtons').slideUp();
	 		$(this).parent().parent().parent().parent().find('.LabWiseTestButtons').slideDown();
 	 	}
 	 });

 	$('.nextPatientPresc').click(function(e){
 		 localStorage.removeItem("crc");
 		 localStorage.removeItem("idForCRC");
 		 localStorage.removeItem("urlForQR");
 		
 			var maxLength = $('.patientListBlock').length;
		    //console.log('maxLength:::'+maxLength+'::: Count :::'+count);
			if(count>=(maxLength-1)){ 
				return false;
			}
 			var prescMode = $('input[name=prescMode]:checked').val(); 
		    //console.log('NextLink Click PrescVal : '+prescMode);
 			if(prescMode==1)
			{	 
				$('.prescriptionColBtn').eq(++count).click();
			}
			else if(prescMode==2)
			{   
		    	//console.log('NextLink count: '+(++count));
 				hidePrescription(e);  
				$('.prescriptionColBtn').eq(count).click();
			}
			else{
				 var effect = function() {
						  return $('.prescModalCloseBtn').click();
						};   
						$.when( effect() ).done(function() {
				 			$('.prescriptionColBtn').eq(++count).click();
							  }); 
			}
 		}); 
			var confirmHandler = function(){
				confirm('Are you sure to save the data');
			}; 
		if($('input[name=autoSave]').is(':not(:checked)'))
			$('.nextPatientPresc').on('click', confirmHandler); 
		$('input[name=autoSave]').on('change', function(){
			if($(this).is(':checked'))
				$('.nextPatientPresc').unbind('click', confirmHandler);
			else
				$('.nextPatientPresc').bind('click', confirmHandler);   
		});
		

	 	$('.prevPatientPresc').click(function(e){
	 		 localStorage.removeItem("crc");
	 		 localStorage.removeItem("idForCRC");
	 		 localStorage.removeItem("urlForQR");
	 		
	 			var maxLength = 1;
			    //console.log('maxLength:::'+maxLength+'::: Count :::'+count);
				if(count<=(maxLength-1)){ 
					return false;
				}
	 			var prescMode = $('input[name=prescMode]:checked').val(); 
			    //console.log('NextLink Click PrescVal : '+prescMode);
	 			if(prescMode==1)
				{	 
					$('.prescriptionColBtn').eq(--count).click();
				}
				else if(prescMode==2)
				{   
			    	//console.log('NextLink count: '+(--count));
	 				hidePrescription(e);  
					$('.prescriptionColBtn').eq(count).click();
				}
				else{
					 var effect = function() {
							  return $('.prescModalCloseBtn').click();
							};   
							$.when( effect() ).done(function() {
					 			$('.prescriptionColBtn').eq(--count).click();
								  }); 
				}
	 		}); 

		$('input[name=diagnosisDiseaseReference]').on('change',function(){
			if($(this).is(':checked'))
			{
				$('.ICDCodeDiseaseView').slideUp();
				$('.snomedCtDiseaseView').slideDown();
			}
			else
			{ 
				$('.snomedCtDiseaseView').slideUp();
				$('.ICDCodeDiseaseView').slideDown();
			}
		});

		/*$('input[name=icdCodeInput]').change(function(){ 
				$(this).parent().parent().find('input[name=diseaseInput]').val('Colera due to Vibrio cholerae 01.'); 
		});*/
		
		$("input[name=icdCodeInput]").on('select:flexdatalist', function (e, set, options) {
		    var val = set.icdCode;
		    /*if($('#ICDcodeLst option').filter(function(){
		        return this.value === val;        
		    }).length) {
		    	var diseaseInputVAl1 = $(this).parent().find('#ICDcodeLst option[value="'+val+'"]').attr('id');*/  
		    	var diseaseInputVAl1 = set.diagnosisName;
		    	$(this).parent().parent().parent().find('input[name=diseaseInput]').val(diseaseInputVAl1); 

		     	//$("input[name=flexdatalist-diseaseInput]").on('keypress', function (e) {
		     		//console.log('15635555...............');
		     		if (!e) e = window.event;
		     	    var keyCode = e.keyCode || e.which;
		     	    //console.log(keyCode)
		     	    if (keyCode == '13'){
		     	    	//console.log('2');	

		     	 		if($('input[name=diagnosisDiseaseReference]').is(':checked'))
		     	 		{
		     	 			if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim().indexOf(';')>='0')
		     	 	 		{
		     	 				if($(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().trim()!='')
		     	 		 		{  var diagnosisVAl = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val().split(';');
		     	 			 	   var diagnosisCode = $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode').split(';');
		     	 			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
		     	 			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
		     	 			 	   //console.log("diagnosisVAl -->> "+diagnosisVAl);
		     	 			 	   //console.log("diagnosisCode --->> "+diagnosisCode);
		     	 			 	  //console.log('diagnosisType ::: ::::: :::: '+diagnosisTypeCode+diagnosisTypeName);
		     	 		 		   for(var i=0;i<(diagnosisVAl.length-1);i++)
		     	 		 		   	{
		     	 		 			  var tmp = 0; 
		     	 		 				$('.diagnosisAdded').find('label .text').each(function(index){ 
		     	 		 					if($(this).text().trim().toUpperCase()===diagnosisVAl[i].trim().toUpperCase()) 
		     	 		 					{	tmp = 1; 
		     	 		 						return false;  }
		     	 		 				});
		     	 		 				if(tmp==1)
		     	 						{ 
		     	 							swal(diagnosisVAl[i].trim()+", Already Added!!");
		     	 							continue;
		     	 						}
		     	 		 				var strDiagnosisId=diagnosisCode[i]+'#'+diagnosisTypeCode+'#1^'+diagnosisVAl[i]+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteId").val()+'#'+$('input[name=diagnosisNoOfDays]').val()+'#'+$("#diagnosisDurationId").val()+'#'+$("#diagnosisRemarksId").val();
		     	 				 		//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+diagnosisVAl[i]+'</label></a>');
		     	 				 		
		     	 		 				var temp=''; 
		     	 		 				if($("#diagnosisSiteId").val()!= 0 && diagnosisTypeCode !=0)
		     	 		 					temp=diagnosisTypeName +'['+ $("#diagnosisSiteId option:selected").text() +']';
		     	 		 				else if($("#diagnosisSiteId").val()!= 0)
		     	 		 					temp=+'['+ $("#diagnosisSiteId option:selected").text() +']';
		     	 		 				else if(diagnosisTypeCode !=0 )
		     	 		 					temp=diagnosisTypeName ;
		     	 		 				
		     	 		 				if($("#diagnosisRemarksId").val() !=''){
		     	 		 					temp= temp+ $("#diagnosisRemarksId").val() ;
		     	 		 				}
		     	 		 				var DiagnosisJson ={
		     	 		 						"IsSnomed"				:			"1" ,
		     	 								"DiagnosisName" 		: 		 	diagnosisVAl[i],
		     	 								"DiagnosisCode" 		:			diagnosisCode[i],
		     	 								"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
		     	 								"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
		     	 								"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
		     	 								"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
		     	 								"DiagnosisRemarks"	:			$("#diagnosisRemarksId").val()
		     	 							};
		     	 							
		     	 		 				//console.log(JSON.stringify(DiagnosisJson));
		     	 		 				
		     	 				 		$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs" title='+temp+' data-toggle="tooltip" >'+
		     	 				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
		     	 				    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
		     	 				    	 		'<span class="text">'+diagnosisVAl[i]+' </span>'+
		     	 				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		     	 				    	 		'</button></label>');
		     	 		 		   	}
		     	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').val('');
		     	 			 		 $(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('diagnosisCode','');
		     	 			 		$(this).parent().parent().find('select[name=diagnosisSite] ').val('0');
		     	 			 		$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
		     	 			 		$(this).parent().parent().find('textarea[name=diagnosisRemarks]').val('');
		     	 			 		 
		     	 		 		 }
		     	 				else
		     	 		 			 swal('Please Select atleast one reason');
		     	 	 		}
		     		 		else
		     		 			 swal('Please Select atleast one reason');
		     	 		}
		     	 		else{
		     	 			 var investigationVAl = $(this).parent().parent().find('input[name=icdCodeInput]').val();  
		     	 		 	 var isValid = 0;
		     	 		 	 var invObj =$("#icdJsonObjDiv").text().trim(); // localStorage.getItem('icdJsonObj'); 
		     	 	 		 invObj = JSON.parse(invObj.toString()); 
		     	 	 		 for(var v=0; v<invObj.length;v++)
		     	 	 		 { 
		     	 	 			if (invObj[v].icdCode.toUpperCase() == investigationVAl.toUpperCase()) {
		     	 	 				isValid=1;
		     	 			        break;
		     	 			    } 
		     	 	 		  } 
		     	 			if($(this).parent().parent().find('input[name=diseaseInput]').val().trim()!='')
		     		 		{  
		     	 				var icdCode = $(this).parent().parent().find('input[name=icdCodeInput]').val();
		     	 				var icdCodeVal = $(this).parent().parent().find('input[name=diseaseInput]').val(); 
		     			 	   var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
		     			 	   var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
		     			 	   //console.log('icdCodeVal ::: ::::: :::: '+icdCode+icdCodeVal); 
		     			 	   
		     			 	   var tmp = 0; 
		     					$('.diagnosisAdded').find('label .text').each(function(index){ 
		     						if($(this).text().trim().toUpperCase()===icdCodeVal.trim().toUpperCase()) 
		     						{	tmp = 1; 
		     							return false;  }
		     					});
		     					if(tmp==1)
		     					{ 
		     						swal(icdCodeVal.trim()+", Already Added!!"); 
		     					}
		     					else
		     					{					  
		     						var strDiagnosisId=icdCode+'#'+diagnosisTypeCode+'#0^'+icdCodeVal+'#'+diagnosisTypeName+'#'+$("#diagnosisSiteIcdId").val()+'#'+$("#diagnosisNoOfDaysIcdId").val()+'#'+$("#diagnosisDurationIcdId").val()+'#'+$("#diagnosisRemarksIcdId").val();
		     						//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left:5px"><label><input type="checkbox" class="checkedInput" name="diagnosisAdded" diagnosisName="'+diagnosisTypeName+'" value="'+strDiagnosisId+'" checked> '+icdCodeVal+'</label></a>');
		     						
		     						var DiagnosisJson ={
		     			 						"IsSnomed"				:			"2" ,
		     									"DiagnosisName" 		: 		 	icdCodeVal,
		     									"DiagnosisCode" 		:			icdCode,
		     									"DiagnosisSideCode" 	: 			$("#diagnosisSiteId").val() ,
		     									"DiagnosisSideName" 	:			$('#diagnosisSiteId option:selected').text(),
		     									"DiagnosisTypeCode" 	: 	 		diagnosisTypeCode ,
		     									"DiagnosisTypeNamee" 	: 			diagnosisTypeName,
		     									"DiagnosisRemarks"	:			$("#diagnosisRemarksIcdId").val()
		     								};
		     								
		     						//console.log(JSON.stringify(DiagnosisJson));
		     						var temptoggle='';
		     						if(diagnosisTypeName != '' ) 
		     							temptoggle =diagnosisTypeName ;
		     						if($('#diagnosisSiteId option:selected').text() !='')
		     							temptoggle =diagnosisTypeName +'['+$('#diagnosisSiteId option:selected').text() +']' ;
		     							
		     						if($("#diagnosisRemarksIcdId").val() !=''){
		     							temptoggle = temptoggle  +$("#diagnosisRemarksIcdId").val() ; 
		     						}
		     						$(this).parent().parent().parent().find('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" title='+temptoggle+' data-toggle="tooltip" type="button" class="value btn btn-xs">'+
		     				    	 		'<input type="checkbox" diagnosisName="'+diagnosisTypeName+'" class="checkedInput" name="diagnosisAdded" value="'+strDiagnosisId+'" checked="checked">  '+
		     				    			'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
		     				    	 		'<span class="text">'+icdCodeVal+' </span>'+
		     				    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		     				    	 		'</button></label>');
		     				 	}
		     					 $(this).parent().parent().find('input[name=diseaseInput]').val('');
		     			 		 $(this).parent().parent().find('input[name=icdCodeInput]').val('');  
		     			 		$(this).parent().parent().find('select[name=diagnosisSiteIcd] ').val('0');
		     				 	$(this).parent().parent().find('select[name=diagnosisType] ').val('11');
		     				 	$(this).parent().parent().find('textarea[name=diagnosisRemarksIcd]').val('');
		     				 		
		     		 		 }
		     		 		else
		     		 			 swal('Please Select atleast one reason');
		     	 			 
		     	 			
		     	 			
		     	 			 
		     	 			
		     	 		}
		     	 		$('[data-toggle="tooltip"]').tooltip();
		     	 		
		     	    }
		     	
		    /*}*/
		});
		 
		var CR_No = $('#patCrNoPrescriptionPanel').text();  
		var episodeCode = $('#patEpisodeCodePrescriptionPanel').text();
		var hospitalCode = $('#patHospitalCodePrescriptionPanel').text();
		var lastVisitDate = $('#patLastVisitDatePrescriptionPanel').text();
		var visitNo=$('#patEpisodeVisitNoPrescriptionPanel').text();
		//alert(hospitalCode);
		
		var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		
		var deptCode= patCompleteGeneralDtlPrescriptionPanel.split('#')[6];
		
		//console.log("deptCode: "+deptCode);
		//console.log('episodeCode::'+episodeCode+'::CR_No::'+CR_No);
		//console.log('visitNo:::: '+ visitNo);
		//console.log('eTeleConsultancyreq Id'+$('input[name=eTeleconsultancyreq]').val());
		//console.log('isPatReferred Id::'+$('input[name=isPatReferred]').val());
		getPrevData(CR_No,episodeCode,hospitalCode,lastVisitDate,visitNo ,$('input[name=eTeleconsultancyreq]').val(),$('input[name=isPatReferred]').val(),deptCode);
		
		
		$('.followUpPlannedVisitRefresh').click(function(){
			/*$('.followUpPlannedVisit').find('input').removeAttr('disabled');*/
			$('.followUpPlannedVisit').find('input').eq(0).removeAttr('checked');
			$('.followUpPlannedVisit').find('input').eq(1).val('');
			$('.followUpPlannedVisit').find('input').eq(2).val('');
		});
		
		/*$('.followUpPlannedVisit').find('input').on('focus',function(){
			$('.followUpPlannedVisit').find('input').attr('disabled','true');
			var index = $('.followUpPlannedVisit').find('input').index(this);
			if(index=='0')
			{ 
				$('.followUpPlannedVisit').find('input').eq(1).val('');
				$('.followUpPlannedVisit').find('input').eq(2).val('');
			}
			else if(index=='1')
			{
				$('.followUpPlannedVisit').find('input').eq(0).removeAttr('checked'); 
				$('.followUpPlannedVisit').find('input').eq(2).val('');
			}
			else
			{
				$('.followUpPlannedVisit').find('input').eq(0).removeAttr('checked');
				$('.followUpPlannedVisit').find('input').eq(1).val(''); 
			}
			$(this).removeAttr('disabled');  
		});*/
		 
		
		
		
		
		
		

		 $('#allergiesModal .close').click(function(){
		       $('#allergicOrNotId').prop('checked', true);
		 });

		 $('.investigationsDiv').find('input').on('focus',function(){
		        var index = $('.investigationsDiv').find('input').index(this);
		        //alert(index);
		        if (index == '1') {
		          $('.investigationsDiv').find('input').eq(2).val('');
		        } else if (index == '2') {
		          $('.investigationsDiv').find('input').eq(1).val('');
		        } 
		      });
	
		 $('.chiefComplaintDiv').find('input').on('focus',function(){
		        var index = $('.chiefComplaintDiv').find('input').index(this);
		        if (index == '0') {
		          $('.chiefComplaintDiv').find('input').eq(2).val('');
		        } else if (index == '2') {
		          $('.chiefComplaintDiv').find('input').eq(0).val('');
		        } 
		      });
		 
		 $('.ClinicalPrcoeduresDiv').find('input').on('focus',function(){
		        var index = $('.ClinicalPrcoeduresDiv').find('input').index(this);
		        if (index == '0') {
		          $('.ClinicalPrcoeduresDiv').find('input').eq(2).val('');
		        } else if (index == '2') {
		          $('.ClinicalPrcoeduresDiv').find('input').eq(0).val('');
		        } 
		      });
		 
		 

		
	
 });	 
/*function calculateExternalQuantity()
{ 
var freq=$('select[name=externalDrugFrequency] option:selected').val();
var freqname= $('select[name=externalDrugFrequency] option:selected').text();
var dos=$('select[name=externalDrugDosage] option:selected').val();         
var days=$('input[name=externalDrugDays]').val();
var calcquan="1"; 

	if(freq!= -1 && days!="")
	{
  
		if (freq =="11" || freqname =="OD" )
				freq="1";
			
		else if (freq =="12" || freqname =="BD" )
				freq="2";

		else if (freq =="13" || freqname =="TDS" )
				freq="3";

		else if (freq =="15" || freqname =="QID" )
				freq="4";
		
		else if(freq =="18" || freqname =="QW" )
		{
			days = Math.ceil(days/7);
			freq="1";
		}
		
		else 
			freq="1";

		if(dos.split('^')[1]==1)
		{
			dos = dos.split('^')[2];
		}
		else
			{
			dos='1';
			days='1';
			freq="1";
			}

		//$('input[name=externalDrugQuantity]').attr('readonly','false');	
		
		calcquan=freq*dos*days; 
		$('input[name=externalDrugQuantity]').val(calcquan);
	}
	 
}*/

function calculateQuantity(freq,freqname,dos, days ){ 
	
	
	//alert(dos);
	//console.log('calc');
	
	var calcquan="1"; 

	if(freq!= -1 && days!="")
	{
  
		if (freq =="11" || freqname =="OD" )
				freq="1";
			
		else if (freq =="12" || freqname =="BD" )
				freq="2";

		else if (freq =="13" || freqname =="TDS" )
				freq="3";

		else if (freq =="15" || freqname =="QID" )
				freq="4";
		
		else if(freq =="18" || freqname =="QW" )
		{
			days = Math.ceil(days/7);
			freq="1";
		}
		else 	
			freq="1";
		
		if(dos.indexOf("^")>=0){ 
			if(dos.split('^')[1]==1)
			{
				dos = dos.split('^')[2];
			}
			else
				{
				dos='1';
				days='1';
				freq="1";
				}
		}

		//$('input[name=drugQuantity]').attr('readonly','false');	
		
		calcquan=freq*dos*days;
		
		calcquan= Math.round(calcquan);
		
		
			
		return calcquan;
	}
	else
		{
		return ''; 
		}
	 
}

	 function isNumber(evt)
	{	 
	   var charCode = evt.which; 
	   if (charCode > 32 && (charCode < 48 || charCode > 57)) {
	      return false;
	    } 
	    return true;
	}

	 function SaveRxProfileData(mode,e , flg){
		 
		 if($('#PresCriptionBookmarkNameId').val() == ''){
			 alert('Please Enter Bookmark Name');
		 return false;
		 }
		 if($('#PresCriptionBookmarkDescId').val() == ''){
			 alert('Please Enter Bookmark Description');
		 return false;
		 }
		 var check=document.getElementsByName("AllDept");
			var strcount=0;
			//console.log('checkBox.length'+check.length);
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					strcount++;
				}			
			}
			/*if(strcount == 0){
				alert('Please Select checkbox');
				return false;
			}*/
			if($('#bookmarkmodal').hasClass('in') == true){
				$('#bookmarkmodal').modal('hide');
			}else{
				$('#bookmarkmodal').modal('show');
			}	
		 
		 Save(mode,e, '1');
		 
	 }
	 
	 
	function Save(mode,e , flg)
	{
		var patAddValue = $('#patAdd').text();
		var patTimeOfVisitValue = $('#timeOfVisit').text();
	    //console.log("patAddValue====-->" + patAddValue);
	    
	    sessionStorage.setItem('patAddValue', patAddValue);
	    sessionStorage.setItem('patTimeOfVisitValue', patTimeOfVisitValue);
		
		var InvTestCode=[];
		var InvTestCodeToPrint=[]; 
		var  i=0;
		var DrugCodeCat=[]; 
		var ReasonOfVisit=[];
		var Diagnosis=[];
		var j=0; 
		var ChronicDisease=[];
		var drugAllergy=[];
		var ClinicalProcedure=[];
		var k=0;
		var l=0;
		var m=0;
		var z=0;
		var Referal=[];
		var hospCode = $('#patHospitalCodePrescriptionPanel').text();
		var seatId = $('#patSeatIdPrescriptionPanel').text();
		
		var hospName = $('#strHospitalName').val();
		
		var ResonOfVisitJsonArray =[];
		var DiagnosisJsonArray =[];
		var InvestigationJsonArray =[];
		var ClinicalProcedureJsonArray =[];
		var DrugJsonArray =new Array();
		var patGeneralDtl = $('input[name=patGeneralDtl]').val().split('#');
		$('input[name=reasonOfVisit]:checked').each(function()
				{
					//console.log($(this).val());
					if($(this).val().split('^')[0]!='0')
					InvTestCode[i]=$(this).val()+'^'+$(this).parent().find('.text1').text();
					i++;
					
				}); 
		//console.log(InvTestCode);
		i=0;
		$('input[name=reasonOfVisit]:checked').each(function()
				{
					//console.log($(this).val());
					InvTestCodeToPrint[i]=$(this).val()+'^'+$(this).parent().find('.text1').text();
					InvestigationJsonArray[i]=JSON.parse($(this).parent().find('i').text());
					i++; 
				}); 
		//console.log("Inv code to print --->> "+InvTestCodeToPrint);
		
		
		
		$('input[name=drugsAdvices]:checked').each(function()
				{
					////console.log('name=drugsAdvices::::>>>'+$(this).val());
					if($(this).val().trim().split('&&')[1]!=100) 
					{
						DrugCodeCat[j]=$(this).val();
						////console.log("DrugJson::::::: "+JSON.parse($(this).parent().find('i').text()));
						//alert($(this).parent().find('i').text());
						DrugJsonArray.push(JSON.parse($(this).parent().find('i').text()));
						j++;
					}
					
				});
		//console.log('DrugCodeCat');
		//console.log(DrugCodeCat);
		j=0;
		$('input[name=visitReason]:checked').each(function()
				{
					//console.log('ReasonOfVisit::>>> '+$(this).val());
					ReasonOfVisit[j]=$(this).val();   //+'^'+$(this).parent().text();
					ResonOfVisitJsonArray[j]=JSON.parse($(this).parent().find('i').text());
					////console.log('DDDDDDDDD  '+$(this).parent().find('i').text());
					////console.log('DDDDDDDDD '+document.getElementsByName("visitReasonHidden")[j].value);
					j++; 
				});
		//console.log('ReasonOfVisit');
		//console.log(ReasonOfVisit); 
		j=0;
		// Check if any input with the name "diagnosisAdded" is checked
		if ($('input[name="diagnosisAdded"]:checked').length === 0 && $('input[name="chronicDiseaseChk"]:checked').length==0) {
			swal("Diagnosis is Mandatory");
		    $('html, body').animate({ scrollTop: $('#diagnosisMainDiv').offset().top-50}, 500);
		    return;
		} else {
		    $('input[name="diagnosisAdded"]:checked').each(function() {
		        Diagnosis[j] = $(this).val();
		        
		        DiagnosisJsonArray[j] = JSON.parse($(this).parent().find('i').text());
		        
		        j++;
		    });
		}

		//console.log('Diagnosis');
		//console.log(Diagnosis);
		
		
		
		k=0;
		$('input[name=chronicDiseaseChk]:checked').each(function()
				{
					//Malaria;^61462000^100^asdasd
					//Chronic Disease^Chronic Disease ID ^ Duration(yrs) ^ Remarks
					//console.log('chronicDiseaseChk::>>> '+$(this).val());
					var disease=$(this).val();
					
					var Json={
							"CronicDiseaseName" : disease.split('^')[0],
							"CronicDiseaseId" : disease.split('^')[1],
							"CronicDiseaseDuration" : disease.split('^')[2],
							"CronicDiseaseRemarks" : disease.split('^')[3],
					};
					
					ChronicDisease[k]=Json;
					k++; 
				});
		//console.log('ChronicDisease');
		//console.log(ChronicDisease);
		
		
		l=0;
		$('input[name=allergiesDtlChk]:checked').each(function()
				{
					//Malaria;^61462000^100^asdasd
					//Chronic Disease^Chronic Disease ID ^ Duration(yrs) ^ Remarks
					var allergy=$(this).parent().find('i').text();
					////console.log('chronicDiseaseChk::>>> '+$(this).val());
					////console.log('Parse Jsom'+JSON.parse($(this).val()));
					//JSON.parse();
					////console.log('chronicDiseaseChk::>>> '+JSON.parse(allergy));
					////console.log('chronicDiseaseChk:Test:>>> '+JSON.stringify(JSON.parse($(this).val())));
					//var allergy=$(this).val();
					drugAllergy[l]=JSON.parse(allergy);
					l++; 
				});
		
		//console.log('drugAllergy');
		//console.log(drugAllergy);
		
		
		 m=0;
		$('input[name=clinicalProc]:checked').each(function()
				{
					//console.log('clinicalProc::>>> '+$(this).val());
					ClinicalProcedure[m]=$(this).val();    //+'^'+$(this).parent().text()+'#'+$(this).attr('diagnosisName');
					ClinicalProcedureJsonArray[m]=JSON.parse($(this).parent().find('i').text());
					
					m++; 
				});
		//console.log('ClinicalProcedure');
		//console.log(ClinicalProcedure);
		var endorsmentDtl=  new Array();
		var externalConsultantReferalDtl=  new Array();
		var externalInvestigationReferalDtl=  new Array();
		var externalProcedureReferalDtl=  new Array();
		var externalFollowupReferalDtl=  new Array();
		
		var dt= (new Date().getDate().toString().padStart(2, '0'))+""+((new Date().getMonth()+1).toString().padStart(2, '0')) +""+new Date().getFullYear();
		//alert(patGeneralDtl);
		//alert(dt);
	
		//benid/date/episodecode+visitno
		var refId= patGeneralDtl[1]+"/"+ dt+"/"+patGeneralDtl[2]+$('#patEpisodeVisitNoPrescriptionPanel').text();
		
		var indxconsultant=0;
		var indxInvestigation=0;
		var indxProcedure=0;
		var indxFollowup=0;
		var flagReferalFound=false; 
		//alert("internalReffralJson>> " + $('[id^=internalReffralJson_]').length)
		$('[id^=internalReffralJson_]').each(function(){
			var str=$(this).text();
			var json= JSON.parse(str);
			if(json["strreferralTypeName"]=="Internal"){
				Referal.push(json);
			}
		});
		
		$('[id^=reffralJson_]').each(function()
		{
			var str=$(this).text();
			var json= JSON.parse(str);
			
			
			if(json["strreferralTypeName"]=="Endorsement"){				
				endorsmentDtl.push(json);
				flagReferalFound=true;
			}
			else{
				if(json["strreferralTypeName"]=="Consultation"){
					json["refSNO"]=++indxconsultant;
					json["refId"]=refId;
					externalConsultantReferalDtl.push(json);
					flagReferalFound=true;
				}
				if(json["strreferralTypeName"]=="Investigation"){
					json["refSNO"]=++indxInvestigation;
					json["refId"]=refId;
					externalInvestigationReferalDtl.push(json);
					flagReferalFound=true;
				}
				if(json["strreferralTypeName"]=="Procedure"){
					json["refSNO"]=++indxProcedure;
					json["refId"]=refId;
					externalProcedureReferalDtl.push(json);
					flagReferalFound=true;
				}
				if(json["strreferralTypeName"]=="Follow up"){
					json["refSNO"]=++indxFollowup;
					json["refId"]=refId;
					externalFollowupReferalDtl.push(json);
					flagReferalFound=true;
				}
				
			}
		});
		if(flagReferalFound==false){
			refId="";
		}
			
		var CR_No = $('#patCrNoPrescriptionPanel').text();
		var patGenAgeCat = $('#patGenAgeCatPrescriptionPanel').text();
		
		//console.log('SeatID:::::::::::  '+ $('input[name=patGeneralDtl]').val())
		var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		
		var fromdeptCode= patCompleteGeneralDtlPrescriptionPanel.split('#')[6];
		//alert(patCompleteGeneralDtlPrescriptionPanel);
		
		var episodeCode =$('#patEpisodeCodePrescriptionPanel').text();
		//alert("episode"+episodeCode);
		
		var endTreatment = $('input[name=endTreatment]:checked').val();
		var plannedVisitSos = $('input[name=followUpPlannedVisitSos]:checked').parent().text();
		var plannedVisitDays = $('input[name=followUpPlannedVisitDays]').val();
		var plannedVisitDate = $('input[name=followUpPlannedVisitDate]').val(); 
		var progressNote = $('textarea#progressNote').val(); 
		if(localStorage.getItem("tempName"))
			progressNote += '\n\nENCLOSURES : '+localStorage.getItem("tempName");
		//console.log('progressNote:::>>>> '+progressNote);
		
		
		var pastHistoryId	= $('#pastHistoryId').val();
		var personalHistoryId	= $('#personalHistoryId').val();
		var familyHistoryId	= $('#familyHistoryId').val();
		var treatmentHistoryId	= $('#treatmentHistoryId').val();
		var surgicalHistoryId	= $('#surgicalHistoryId').val();

		var cpmpleteHistory = {
		"strpastHistory"    	:pastHistoryId ,
		"strpersonalHistory"	:personalHistoryId ,
		"strfamilyHistory"	:familyHistoryId ,
		"strtreatmentHistory"	:treatmentHistoryId ,
		"strsurgicalHistory"	:surgicalHistoryId 
		} ;

		var cpmpleteHistoryJSON = JSON.stringify(cpmpleteHistory); 
		//console.log(cpmpleteHistoryJSON); 
		

		var cvsId	= $('#cvsId').val();
		var rsId	= $('#rsId').val();
		var cnsId	= $('#cnsId').val();
		var pAId	= $('#pAId').val();
		var otherExamnId= $('#otherExamnId').val();
		var muscularExamnId= $('#muscularExamnId').val();
		var LocalExamnId= $('#LocalExamnId').val();
		var SystemicExamnId=$('#SystemicExamnId').val(); 
		var pallorId ='' ;
		var icterusId ='';
		var cyanosisId='';
		var clubbingId='';
		var iymphadenopathyId='';
		var edemaID='';
		if($('#pallorId').is(":checked"))
		pallorId = '1';
		else
		pallorId = '0';	
		
		if($('#icterusId').is(":checked"))
			icterusId = '1';
			else
			icterusId = '0';
		
		if($('#cyanosisId').is(":checked"))
			cyanosisId = '1';
			else
			cyanosisId = '0';
		
		if($('#clubbingId').is(":checked"))
			clubbingId = '1';
			else
			clubbingId = '0';
		
		if($('#iymphadenopathyId').is(":checked"))
			iymphadenopathyId = '1';
			else
			iymphadenopathyId = '0';
		
		if($('#edemaID').is(":checked"))
			edemaID = '1';
			else
			edemaID = '0';
		
		
		//console.log('pallorId'+pallorId);
		
		var piccle = {
				"strpallor" :pallorId,
				"stricterus":icterusId,
				"strcyanosis":cyanosisId,
				"strclubbing":clubbingId,
				"striymphadenopathyId":iymphadenopathyId,
				"stredema" :edemaID
				
				
		}

		var addSystematicExamniation = {
		"strcvs" 	: cvsId ,
		"strrs"		: rsId ,
		"strcns"	: cnsId ,
		"strpA"		: pAId ,
		"strotherExamn"	: otherExamnId ,
		"strmuscularExamn" :muscularExamnId ,
		"strLocalExamn"  : LocalExamnId,
		"SystemicExamn": SystemicExamnId
		} ; 

		var addSystematicExamniationJson = JSON.stringify(addSystematicExamniation); 
		//console.log(addSystematicExamniationJson); 
		
		var HistoryOfPresentIllNess=$("#hopiId").val();
		var DiagnosisNote=$("#diagnosisNoteId").val();
		var investigationNote=$("#investigationNoteId").val();
		var otherAllergiesId=$("#otherAllergiesId").val();
		var treatmentAdviceId=$("#treatmentAdviceId").val();
		var strVitalsChartId=$("#vitalHiddenValId").val();
		var labHiddenValId=$("#labHiddenValId").val();		
		var strReffralDeptCmb= [] ;  // ($('select[name=refferlPatientDept] option:selected').val()).split('#')[0];
		var strReffralDepttext=  []; // ($('select[name=refferlPatientDept] option:selected').text());
		//var strReffralReason=$('input[name=refferalResonId]').val(); ------ commented by ashutoshk for changing input tag to textarea tag under refer section
		var strReffralReason=$("#refferalResonId").val();
		var strReffralDeptDone = []; //($('select[name=refferlPatientDept] option:selected').val());
		var strConfidentialsInfo=$("#ConfidentialInfoId").val();
		var refferlCmblength= $('select[name=refferlPatientDept] option:selected') ;
		
		var DeptIdflg='0';
		if($('#deptonlyid').is(":checked"))
			DeptIdflg='1';
		
		
		var check=document.getElementsByName("AllDept");
		
		//console.log('checkBox.length'+check.length);
		var AllDeptIdflg='0';
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				AllDeptIdflg=check[i].value;
			}			
		}
		
		var PresCriptionBookmarkNameval= $('#PresCriptionBookmarkNameId').val();
		var PresCriptionBookmarkDescVal= $('#PresCriptionBookmarkDescId').val();
		var admissionadviceDeptName='';
		var admissionadviceWardName='';
		var admissionadviceNotes='';
		$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getAdmissionAdvice?Modval=7&CrNo='+patGeneralDtl[1]+'&episodeCode='+patGeneralDtl[2] +'&visitNo='+$('#patEpisodeVisitNoPrescriptionPanel').text()+'&seatId=&Entrydate=&hosp_code='+hospCode+'',
			async:false,
			success:function(result){ 
				//console.log(patGeneralDtl[1]+'-'+patGeneralDtl[2]+'-'+$('#patEpisodeVisitNoPrescriptionPanel').text());
				//console.log('getAdmissionAdvice  getAdmissionAdvice  :::::::::::::::'+result);
				for(var len =0 ; len < result.length ; len ++){
					//console.log(result[len]);
					 admissionadviceDeptName= result[len].GETDEPTUNITNAME;
					 admissionadviceWardName=result[len].GETWARDNAME;
					 admissionadviceNotes=result[len].HIPSTR_ADVICE_NOTE;
					
				}
			}
		});
		let now = new Date();
		let curVisitDate = 
		    now.getDate().toString().padStart(2, '0') + '/' +
		    (now.getMonth() + 1).toString().padStart(2, '0') + '/' +
		    now.getFullYear() + ' ' +
		    now.getHours().toString().padStart(2, '0') + ':' +
		    now.getMinutes().toString().padStart(2, '0') + ':' +
		    now.getSeconds().toString().padStart(2, '0');
		console.log("curVisitDate    >>>   : "+ curVisitDate);
		
		var prescJSON = {
			'InvTestCode':InvTestCode,
			'InvTestCodeToPrint':InvTestCodeToPrint,
			'DrugCodeCat':DrugCodeCat,
			"DrugJsonArray"	: DrugJsonArray ,
			'ReasonOfVisit':ReasonOfVisit,
			'Diagnosis':Diagnosis,
			'FOLLOW_UP':[
				{'endTreatment':endTreatment, 
				'Planned_Visit':[
					{'plannedVisitSos':plannedVisitSos,
					'plannedVisitDays':plannedVisitDays,
					'plannedVisitDate':		plannedVisitDate =="" ? "" : plannedVisitDate.split('-')[2]+'-'+plannedVisitDate.split('-')[1]+'-'+plannedVisitDate.split('-')[0]
					}
					],
				'progressNote':progressNote
				}],
			"pat_Name":patGeneralDtl[0],
			"CR_No":patGeneralDtl[1],
			"episodeCode":patGeneralDtl[2],
			"episodeVisitNo":$('#patEpisodeVisitNoPrescriptionPanel').text(),
			"currentVisitDate":curVisitDate,
			"patVisitType":$('#patVisitTypePrescriptionPanel').text(),
			"lastVisitDate":$('#patLastVisitDatePrescriptionPanel').text(),
			"patGender":patGeneralDtl[3].split('/')[0],
			"patAge":patGeneralDtl[3].split('/')[1],
			"patCat":patGeneralDtl[3].split('/')[2],
			"patQueueNo":patGeneralDtl[3].split('/')[3],
			"hosp_code":hospCode,	
			"seatId": $('input[name=strSeatId]').val(),
			"hrgnum_is_docuploaded":0,
			"patConsultantName":$('#patConsultantNamePrescriptionPanel').text(),
			"patDept":$('#patDeptName').text(),
			"patGaurdianName":$('#patGaurdianNamePrescriptionPanel').text(),
			"PatCompleteGeneralDtl":patCompleteGeneralDtlPrescriptionPanel ,
			"strCompleteHistory":cpmpleteHistory, // From Here
			"strSystematicExamniation":addSystematicExamniation,
			"strChronicDisease":ChronicDisease ,
			"strHistoryOfPresentIllNess":HistoryOfPresentIllNess,
			"strDiagnosisNote":DiagnosisNote ,
			"strDrugAllergy" : drugAllergy ,
			"strInvestgationNote" :investigationNote ,
			"strotherAllergies":otherAllergiesId ,
			"strClinicalProcedure":ClinicalProcedure ,
			"strtreatmentAdvice" :treatmentAdviceId ,
			"strVitalsChart"	  :strVitalsChartId ,
			"labReportEntry"	:	labHiddenValId,
			"strpiccle"			  :piccle ,
			"strConfidentialsInfo" : strConfidentialsInfo ,
			"strEndorsmentDtl":endorsmentDtl,
			"strReferal" :Referal ,
			"externalConsultantReferalDtl": externalConsultantReferalDtl,
			"externalInvestigationReferalDtl": externalInvestigationReferalDtl,
			"externalProcedureReferalDtl": externalProcedureReferalDtl,
			"externalFollowupReferalDtl": externalFollowupReferalDtl,
			"strDeptIdflg" :flg.toString() ,
			"strAllDeptIdflg" :AllDeptIdflg.toString() ,
			"strPresCriptionBookmarkNameval" :PresCriptionBookmarkNameval ,
			"strPresCriptionBookmarkDescVal" :PresCriptionBookmarkDescVal ,
			"strUmidNo" : $('#patUmidPrescriptionPanel').text() ,
			"admissionadviceDeptName": admissionadviceDeptName ,
			"admissionadviceWardName" : admissionadviceWardName , 
			"admissionadviceNotes" : admissionadviceNotes,
			"strDesignation" : $('#patdesignationPrescriptionPanel').text() ,
			"strStation" : $('#patStationPrescriptionPanel').text() ,
			"strLevelOfEntitlement" : $('#patRecentLevelOfEntitlementTestPrescriptionPanel').text(),
			"strPatRecentDept" : $('#patRecentDepartmentTestPrescriptionPanel').text(),
			"hospName" : hospName,
			"cardType":$('#cardType').text(),
			"relation":$('#relation').text(),
			"isModify":$('#isModify').val(),
			"parentWellnessCenter" :$('#parentWellnessCenter').val(),
			"priority":$('#priority').val(),
			"internalqueueno":$('#internalqueueno').val(),
			"internamequeuenovisit":$('#internamequeuenovisit').val(),
			"queuesymbol":$('#queuesymbol').val(),
			"displayqueueno":$('#displayqueueno').val(),
			"queuestatus":$('#queuestatus').val(),
			"proxy_flag":$('#proxy_flag').val(),
			"proxy_name":$('#proxy_name').val(),
			"proxy_contact":$('#proxy_contact').val(),
			"proxy_relation":$('#proxy_relation').val(),
			"referralId":refId
		};
		
	
 
		var FormattedJson ={ 
				"Patient_Name"					:	patGeneralDtl[0].trim(),
				"CR_No"							:	patGeneralDtl[1],
				"EpisodeCode"					:	patGeneralDtl[2],
				"EpisodeVisitNo"				:	$('#patEpisodeVisitNoPrescriptionPanel').text(),
				"CurrentVisitDate"				:	curVisitDate,
				"PatVisitType"					:	$('#patVisitTypePrescriptionPanel').text(),
				"LastVisitDate"					:	$('#patLastVisitDatePrescriptionPanel').text(),
				"PatientGender"					:	patGeneralDtl[3].split('/')[0],
				"PatientAge"					:	patGeneralDtl[3].split('/')[1],
				"PatientCat"					:	patGeneralDtl[3].split('/')[2],
				"PatientQueueNo"				:	patGeneralDtl[3].split('/')[3],
				"hosp_code"						:	hospCode,	
				"hrgnum_is_docuploaded"			:	0,
				"ConsultantName"				:	$('#patConsultantNamePrescriptionPanel').text(),
				"PatientDept"					:	$('#patDeptName').text(),
				"patGaurdianName"				:	$('#patGaurdianNamePrescriptionPanel').text(),
				"PatCompleteGeneralDtl"			:	patCompleteGeneralDtlPrescriptionPanel ,
				"seatId"						:   $('input[name=strSeatId]').val(),
				"HistoryOfPresentIllNess"		:	HistoryOfPresentIllNess,
				"DiagnosisNote"					:	DiagnosisNote ,
				"InvestgationNote" 				:	investigationNote ,
				"OtherAllergies"				:	otherAllergiesId ,
				"ReasonOfVisitJsonArray"		:	ResonOfVisitJsonArray ,
				"DiagnosisJsonArray"			:	DiagnosisJsonArray,
				"InvestigationJsonArray"		: 	InvestigationJsonArray,
				"CompleteHistoryJaonArray" 		:	cpmpleteHistory ,
				"SystematicExamniationArray" 	: 	addSystematicExamniation ,
				"ChronicDiseaseArray" 			:	ChronicDisease ,
				"PiccleArray"			  		:	piccle ,
				"ClinicalProcedureJsonArray"	:	ClinicalProcedureJsonArray ,
				"DrugJsonArray"					:	DrugJsonArray ,
				"EndorsmentDtl"					:	endorsmentDtl,				
				"PatientRefrel"					:	Referal ,
				"externalConsultantReferalDtl"	: 	externalConsultantReferalDtl,
				"externalInvestigationReferalDtl": 	externalInvestigationReferalDtl,
				"externalProcedureReferalDtl"	: 	externalProcedureReferalDtl,
				"externalFollowupReferalDtl": externalFollowupReferalDtl,
				"strpiccle"			 			:	piccle ,
				"strtreatmentAdvice" 			:	treatmentAdviceId ,
				"strConfidentialsInfo" 			: 	strConfidentialsInfo ,
				"strVitalsChart"	 			: 	strVitalsChartId ,
				"labReportEntry"				:	labHiddenValId,
				'FOLLOW_UP'						:	[
													{'endTreatment':endTreatment, 
													'Planned_Visit':[
														{'plannedVisitSos':plannedVisitSos,
														'plannedVisitDays':plannedVisitDays,
														'plannedVisitDate':plannedVisitDate}
														],
													'progressNote':progressNote
													}],
													
				"strDeptIdflg" :flg.toString(),
				"strAllDeptIdflg" :AllDeptIdflg.toString() ,
				"strPresCriptionBookmarkNameval" :PresCriptionBookmarkNameval  ,
				"strPresCriptionBookmarkDescVal" :PresCriptionBookmarkDescVal ,
				"strUmidNo" : $('#patUmidPrescriptionPanel').text() ,
				"admissionadviceDeptName": admissionadviceDeptName ,
				"admissionadviceWardName" : admissionadviceWardName , 
				"admissionadviceNotes" : admissionadviceNotes,
				"strDesignation" : $('#patdesignationPrescriptionPanel').text() ,
				"strStation" : $('#patStationPrescriptionPanel').text() ,
				"strLevelOfEntitlement" : $('#patRecentLevelOfEntitlementTestPrescriptionPanel').text(),
				"strPatRecentDept" : $('#patRecentDepartmentTestPrescriptionPanel').text(),
				"hospName" : hospName,
				"parentWellnessCenter" 	:	$('#parentWellnessCenter').val(),
				"priority"				:	$('#priority').val(),
				"internalqueueno"	:	$('#internalqueueno').val(),
				"internamequeuenovisit"	:	$('#internamequeuenovisit').val(),
				"queuesymbol"	:	$('#queuesymbol').val(),
				"displayqueueno"	:	$('#displayqueueno').val(),
				"queuestatus"	:	$('#queuestatus').val(),
				"proxy_flag":$('#proxy_flag').val(),
				"proxy_name":$('#proxy_name').val(),
				"proxy_contact":$('#proxy_contact').val(),
				"proxy_relation":$('#proxy_relation').val(),
				"referralId":refId
		}
			//console.log('FormattedJson');
			//console.log(FormattedJson);
			//console.log(JSON.stringify(FormattedJson));
			
			var myJSON = JSON.stringify(prescJSON); 
			////console.log("myJSON ashutoshk "+myJSON); 
			if(localStorage.getItem("myJSON"))
				localStorage.removeItem("myJSON");
				localStorage.setItem("myJSON", myJSON);
				
				if(localStorage.getItem("FormattedJson"))
					localStorage.removeItem("FormattedJson");
					localStorage.setItem("FormattedJson", JSON.stringify(FormattedJson));
				
			if(localStorage.getItem("flag"))
				localStorage.removeItem("flag");
			localStorage.setItem("flag", "0");
				
			if(mode!='printSave')
			swal({
				  title: "Are you sure to Save?",
				  text: "Press ok to save!",
				  icon: "warning",
				  buttons: true,
				  dangerMode: true,
				})
			.then(function(willDelete) {
			  if (willDelete) { 
						SaveData(myJSON ,JSON.stringify(FormattedJson) ,e); 
			  } else {
			     return false;
			  }
			});
			else 
			{
				//alert( $(window).width());
				//alert('1'+ $(window).width()< 1100);
				if($(window).width() <  850){
					//alert('2');
				 // $('#printPrescriptionModalId12').removeClass('modal-dialog modal-lg');
				 //alert(document.getElementById("printPrescriptionModalId12").className);
				 document.getElementById("printPrescriptionModalId12").className='';
				 // alert(document.getElementById("printPrescriptionModalId12").className);
				 }else{
					 document.getElementById("printPrescriptionModalId12").className='modal-dialog modal-xl';
				 }
				
				$('#printPrescriptionModal .modal-body').prepend('<iframe id="printPrescFrameId" style="width:100%;height:80vh;" src="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=PRINTPRESC"></iframe>');
				$('#printPrescriptionModal').modal('show');
				//$("#printPrescriptionModal").find(".modal-backdrop").css({"z-index": "-1"});
				
				/*$(e).hide(); */							
			}
	} 

	
	//Code Added By Timsi Kataria as suggested by Priyesh Sir
	
	$('.generalComplaintAdd').click(function(){ 
 		
		 var generalComplaintVal = $(this).parent().parent().parent().find('input[name=generalComplaint]').val(); 
		  if(generalComplaintVal.trim()!='')
		  {  
			    var tmp = 0; 
				$('.reasonOfVisitAdded').find('label').each(function(index){ 
					if($(this).text().split("(")[0].trim().toUpperCase()===generalComplaintVal.trim().toUpperCase()) 
					{	tmp = 1; 
						return false;  }
				});
				if(tmp==1)
				{
					swal("Already Added!!");
					return false;
				}
				else
				{
					$(this).parent().parent().parent().find('.reasonOfVisitAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="visitReason" value="'+0+'"  checked> '+generalComplaintVal+'<sup style="color:red; font-weight:bold;">*</sup></label></a>');

				}
	 		 
			 $(this).parent().parent().parent().find('input[name=generalComplaint]').val(''); 
		  }
		  else{
			  swal('Please enter other general complaint to be added');
		  }
	}); 
	
	

	/* New Code for Past Rx Button on Prescription Page */
	$(document).ready(function(){
		
		
		  
		  window.patCrNo = $('#patCrNoPrescriptionPanel').text();
		  window.episodeCode = $('#patEpisodeCodePrescriptionPanel').text();
		  window.visitNo = $('#patEpisodeVisitNoPrescriptionPanel').text();
		  window.seatId = $('#patSeatIdPrescriptionPanel').text();
		  window.hospCode = $('#patHospitalCodePrescriptionPanel').text();
		  window.deptName = $('#patDeptName').text();
		  
		     var todaysys = new Date(); 
			 var dd = todaysys.getDate();
			 dd = dd.toString().length>1 ? dd : "0"+dd;
			 var mm = todaysys.getMonth() + 1;
			 mm = mm.toString().length>1 ? mm : "0"+mm;
			 var yyyy=todaysys.getFullYear();
			 //todaysys = dd+'/'+mm+'/'+yyyy;
			 todaysys=new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear()
		  
		  //alert(window.patCrNo+" "+window.episodeCode+" "+window.visitNo+" "+window.deptName);
		  if(window.patCrNo==""){
			  return;
		  }
		$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatDataForPastPrescription?Modval=2&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
			async:true,
			beforesend : $('.patPreviousPrescriptionList').parent().append('<p id="prescriptionListMsg"><i class="fa fa-spinner fa-spin"></i> Loading</p>'),
				success:function(data){ 
					
				
					var str = '';
					var strHistory = '' , strExaminations = '' , strChronics = '' , strAllergies = '' , strClinicalProc = '' , strVitalsInfo = '' ;
					var count = 1;
					var menuId = 'opdEMRModalNavMenuItem';
					//alert(Object.keys(data).length);
					//alert(Object.keys(data.pat_details).length);
					//console.log('======:::::::::::::::::::::::::::::::::::::::::::::::======data.pat_details'+Object.keys(data.pat_details).length);
					//console.log('data ashukk ---- '+ JSON.stringify(data.pat_details));
					
					if(Object.keys(data.pat_details).length > 0){
						
						$('.opdEmrModalNavMenu').children('li').eq(0).remove();
						$('.opdEmrModalNavMenuContent').children('div').eq(0).remove();
						////console.log('data ashukk ---- '+ JSON.stringify(data.pat_details));
						$('#medicineHistoryTable tbody').empty();
						$('#prescriptionListMsg').remove();
						var lastVisitDateForTile="";
						for(var i=0;i<Object.keys(data.pat_details).length;i++)
						{   
							//alert(data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate);
							var visitDate = data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate.trim();
							var temp = visitDate.split("/");
							
							createMedicineHistory(data.pat_details[i]);// creating drug history
							//console.log('DATASAVE_TIME ---- '+ data.pat_details[i].DATASAVE_TIME.split(" ")[1].trim() +' \n HRSTR_JSON_DATA>>>>> '+ JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA));
							
							var JSON_DATA =data.pat_details[i].HRSTR_JSON_DATA
							
							if(i != 0){
								/*var prevVisitDate = data.pat_details[i-1].HRSTR_JSON_DATA.currentVisitDate.trim();
								var tempPrevVisitDate = prevVisitDate.split("/");
								
								if(temp[0] === tempPrevVisitDate[0]  && temp[1] === tempPrevVisitDate[1] && temp[2] === tempPrevVisitDate[2])
									count++;
								else 
									count=1;*/
								
								var currVisitNo = data.pat_details[i].HRSTR_JSON_DATA.episodeVisitNo.trim();
								var prevVisitNo = data.pat_details[i-1].HRSTR_JSON_DATA.episodeVisitNo.trim();
								
								var currEpisodeCode = data.pat_details[i].HRSTR_JSON_DATA.episodeCode.trim();
								var prevEpisodeCode = data.pat_details[i-1].HRSTR_JSON_DATA.episodeCode.trim();
								
								if(currVisitNo === prevVisitNo  && currEpisodeCode === prevEpisodeCode)
									count++;
								else 
									count=1;
							}
							
							var months = new Array(12);
						 	months[1] = "Jan";
						 	months[2] = "Feb";
						 	months[3] = "Mar";
						 	months[4] = "Apr";
						 	months[5] = "May";
						 	months[6] = "Jun";
						 	months[7] = "Jul";
						 	months[8] = "Aug";
						 	months[9] = "Sep";
						 	months[10] = "Oct";
						 	months[11] = "Nov";
						 	months[12] = "Dec";
						 	
							//var tempdate =	data.pat_details[i].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim().split('#')[7].split('-');
						 	var tempdate = data.pat_details[i].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim().split('#')[7].split('-'); 

						 	if(lastVisitDateForTile==""){
						 		lastVisitDateForTile=tempdate[0]+ "-" +tempdate[1] + "-" + tempdate[2];						 		
						 		$('#lastVisitDateTile').html("<a style='background: #fff;padding: 3px;color: blue;' onclick=\"showProcessPopUps('pastRx')\">"+lastVisitDateForTile+"</a>");
						 		
						 	}
						 	
						 	var maxDate1 =    tempdate[0]+"-"+tempdate[1] +"-"+tempdate[2]+" {"+data.pat_details[i].DATASAVE_TIME.split(" ")[1].trim()+"}";
						 	//var maxDate1 =    tempdate[0]+"-"+tempdate[1] +"-"+tempdate[2].substring(2,4)+" {"+data.pat_details[i].DATASAVE_TIME.split(" ")[1].trim()+"}";

						 	var today = new Date();
							var printDate = today.getDate()+'-'+months[today.getMonth()+1]+'-'+today.getFullYear();
							var printTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
							
							str = '';
							strHistory = '' , strExaminations = '' , strChronics = '' , strAllergies = '' . strVitalsInfo = '' , strClinicalProc = '' ;
							
							////////////////////////////////////////////////////////////////////////////////////////////////////
							
							$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatVitalDataForDetailedPrescription?Modval=3&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=0&Entrydate=&hosp_code='+window.hospCode+'',
								async:false,
								success:function(result){ 
									
										if(Object.keys(result.pat_vital_details).length > 0){
											
											for(var j=0;j<Object.keys(result.pat_vital_details).length;j++){   
												
												strVitalsInfo = '' ;
												
												if(result.pat_vital_details[j].TO_CHAR == data.pat_details[i].TO_CHAR){
													if(j<7){
												 		strVitalsInfo+='<div class="row"><div class="col-sm-12"><p><b> VITALS : </b><small class="vitalsInfo">';
												 		
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strWeight != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strWeight != '0.00'){
								      						strVitalsInfo+='Weight : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strWeight+' kgs , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strHeight != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strHeight != '0.00'){
								      						strVitalsInfo+='Height : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strHeight+' cms , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strBmid != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strBmid != '0.00'){
								      						strVitalsInfo+='BMI : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strBmid+' , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strTempreature != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strTempreature != '0.00' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strTempreature != '0.0'){
								      						strVitalsInfo+='Temperature : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strTempreature+' <sup>o</sup>F , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strrespRate != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strrespRate != '0'){
								      						strVitalsInfo+='Respiration Rate : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strrespRate+' br/m , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strhaemoglobin != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strhaemoglobin != '0.00'){
								      						strVitalsInfo+='Haemoglobin : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strhaemoglobin+' gm/dL , ';
								      					}
								      					
								      					if((result.pat_vital_details[j].HOPLSTR_JSON_DATA.strsystolic != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strdiastolic != '') && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strsystolic != '0.0' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strdiastolic != '0.0'){
								      						strVitalsInfo+='B.P : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strsystolic+'/'+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strdiastolic+' mm/HG , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strsystolic1 != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strdiastolic1 != ''){
								      						strVitalsInfo+='B.P : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strsystolic1+'/'+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strdiastolic1+' mm/HG , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strfasting != ''){
								      						strVitalsInfo+='B.S. Fast : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strfasting+' mg/dL , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strRateId != ''){
								      						strVitalsInfo+='PP : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strRateId+' mg/dL , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strhba1c != ''){
								      						strVitalsInfo+='HBA1C : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strhba1c+' % , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strbloodGroup != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strbloodGroup != '0'){
								      						strVitalsInfo+='Blood Group : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strbloodGroup+', ';
								      					}
								      					
								      					/*-----------Added for cancer screening---------------*/
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcancerScreening != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcancerScreening != '0'){
								      						strVitalsInfo+='Cancer screening : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcancerScreening+', ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcurcumference != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcurcumference != '0'){
								      						strVitalsInfo+='Head Circumference : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strcurcumference+' cms , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strmuac != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strmuac != '0'){
								      						strVitalsInfo+='MUAC : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strmuac+' cms , ';
								      					}
								      					
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strDisability != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strDisability != '0'){
								      						strVitalsInfo+='Disability : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strDisability+' , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strSmoking != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strSmoking != '0'){
								      						strVitalsInfo+='Smoking'+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strSmoking+'  , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strAnemic != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strAnemic != '0'){
								      						strVitalsInfo+='Anemic : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strAnemic+'  , ';
								      					}
								      					
								      					if(result.pat_vital_details[j].HOPLSTR_JSON_DATA.strPregnancy != '' && result.pat_vital_details[j].HOPLSTR_JSON_DATA.strPregnancy != '0'){
								      						strVitalsInfo+='Pregnancy : '+result.pat_vital_details[j].HOPLSTR_JSON_DATA.strPregnancy+'  , ';
								      					}
								      					strVitalsInfo+='</small></p></div></div>';
												 	}
												}
												else{
													strVitalsInfo+='<div class="row"><div class="col-sm-12<p><b> VITALS : </b><small class="vitalsInfo">';
													/*strVitalsInfo+='No Record Found';*/
													strVitalsInfo+='</small></p></div></div>';
												}

											}
											
										}
										
									}
								
							});
											
							//console.log('1::::::::::Vital End');
							//////////////////////////////////////////////////////////////////////////////////////////////////
							
							/*$('.opdEmrModalNavMenu').append('<li><a href="#'+menuId+(i+1)+'" data-toggle="tab">'+data.pat_details[i].TO_CHAR+'</a></li>');*/
							$('.opdEmrModalNavMenu').append('<li><a style="font-size: 13px;" href="#'+menuId+(i+1)+'" data-toggle="tab">'+maxDate1+'</a></li>'); 
							////console.log('data.pat_details[i].TO_CHAR : '+data.pat_details[i].TO_CHAR);
							////console.log('in pastrx ---> HRSTR_JSON_DATA : '+JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA));
							////console.log('HOSPNAME -- '+data.pat_details[i].HOSPNAME);
							////console.log('HOSPADD -- '+data.pat_details[i].HOSPADD);
							////console.log('HRSTR_JSON_DATA -- '+ JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA));
							str+='<div style="right:8px; position:fixed">'+
							'<input type="button" data-date="'+maxDate1+'" data-btnindx="'+i+'" onclick="loadRX(this);" value="Load RX" class="btn-his  pull-right" style="margin-left:11px;"  id="loadPastPrescBtn'+(i+1)+'"/> &nbsp;'+	
							'<input type="button" onclick="printDiv(\''+menuId+(i+1)+'\');" value="Print" class="btn-his previousPrescPrintBtn pull-right" id="printPastPrescBtn'+(i+1)+'"/>'+
							'<span style="display:none;" id="pastrx_'+i+'">'+JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA)+'</span>'+							
							'</div>'; 
							//alert(data.pat_details[i].printData);
							str+='<div id="printPrescPage_tabContent'+(i+1)+'" class="printPreviousPrescPage">';
							
							if(data.pat_details[i].HRSTR_JSON_DATA.printData!=undefined){
								var strdata=decryptBase64(data.pat_details[i].HRSTR_JSON_DATA.printData);
								str+=strdata+"</div>";
								$('.opdEmrModalNavMenuContent').append('<div class="tab-pane" id="'+menuId+(i+1)+'">'+str+'</div>');
							}
							else{
									str+='<div class="row"><div style="float:left"> <h4 class="text-center" style="font-weight:bold"> '+
												'<img alt="" src="/HIS/hisglobal/assets/img/logo.png" style="height: 56px"></h4> </div><br>'+
									 			'<div style="float:left;text-align:center">'+
									 			 // '<h4><b>'+$('input[name=strHospitalName]').val()+'</b></h4> '+
											     // ' <h5>'+$('input[name=strHospitalAddres]').val()+'</h5> '+ 
									 			  '<h4><b>'+data.pat_details[i].HOSPNAME+'</b></h4> '+
											      ' <h5>'+data.pat_details[i].HOSPADD+'</h5> '+ 
											     '</div> '+
											'</div>'+  
											'<div class="" style="border-top: 1px solid grey; border-bottom: 1px solid grey;">'+
											'<table class="table table-condensed printPrescPatDtlTbl table-responsive">'+
											'<tbody><tr>'+
											' <th colspan="5">'+
											'<table align="center">'+
											'	<tr><td></td><td><h4><font color="blue">OPD Prescription</font></h4></td><td></td></tr>'+
											'</table>'+
										'</th>'+
											'<tr>'+
											'<th>Name</th><td class="patName">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.pat_Name.trim();
									str+='</td><th>BEN ID.</th><td class="patCrNo">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.CR_No.trim();
									str+='</td></tr><tr><th>Age/Gender</th><td class="patAgeGen">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.patAge.trim()+'/'+data.pat_details[i].HRSTR_JSON_DATA.patGender.trim();
									str+='</td><th>Patient Category</th><td class="patCat">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.patCat.trim();
									str+='</td></tr><tr>'+
										'<th>Father/Spouse Name</th><td class="patRelName">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.patGaurdianName.trim();
									str+='</td><th>Department(Unit/Consultant)</th><td class="patDeptU">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.patDept.trim();
									str+='</td></tr><tr><th>Visit Date</th><td class="patVisitDate">';
									str+=data.pat_details[i].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim().split('#')[7];
									str+='</td><th>Unit Head</th><td class="consultantName">';
									if($('#strRailTailFlgId').val() == '1')
										str+='-';
									else	
										str+=data.pat_details[i].HRSTR_JSON_DATA.patConsultantName.trim();
									str+='</td></tr></tbody></table></div>'; 
									
									if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit !=''){
									str+='<div class="row">'+
									'<div class="col-sm-12">'+
										'<p><b>CHIEF COMPLAINT : </b><small class="reasonOfVisit">';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit.length;j++){
											
											
											
											
											
											
											
											
											var VisitReason='';
											var text='';
											var text1='';
											//console.log('Visit Reason Length:::::::'+data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length);
											if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length == 2)
												{
												VisitReason=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j]+'^0^^0';
												}else{
													VisitReason=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j];
													}
											var x=VisitReason.split('^')[2];
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
											    text = "";
											}
											var y=VisitReason.split('^')[4];
											switch (parseInt(y)) {
											  case 0:
											    text1 = "";
											    break;
												case 1:
											    text1 = "Day/s";
											    break;
												case 2:
											    text1 = "Week/s";
											    break;
												case 3:
											    text1 = "Month/s";
											    break;
												case 4:
											    text1 = "Year/s";
											    break;
												default:
											    text1 = "";
											}
											var remarks_temp ='';
											if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length == 6){
											if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[5].trim() != '' )
												{
												remarks_temp =' '+data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[5].trim();
												}else{
													remarks_temp='';
												}
											}
											str+=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[1].trim()+(text == '' ? '' : ' ('+text+','+(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[3]=='' ? '' : +data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[3].trim()+' '+ text1) +')')+remarks_temp+', '
										}
										str+='</small></p>'+
												'</div>'+
											'</div>'+
											'<br>';
									}
									
									//console.log('1::::::::::strHistoryOfPresentIllNess');	
										if("strHistoryOfPresentIllNess" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess != ''){
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p style="text-align: justify;"><b>HISTORY OF PRESENT ILLNESS : </b><small>';
											for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess.length;j++){
												str+=data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess[j];
											}
											str+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
											}
										}
										
									str+=strVitalsInfo;
									
								
										
										
										/*else{
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>HISTORY OF PRESENT ILLNESS : </b><small>';
											str+='No Record Found';
											str+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';
										}*/
										
										
										
										if("strSystematicExamniation" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											
										if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs != '' || data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns != ''
										|| 	data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs != '' || data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA != ''
										|| data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn != ''
										)	{
											strExaminations+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>EXAMINATION : </b><ul>';
										
											if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs != ''){
												strExaminations+='<li><b style="color: #5a5a5a !important;">CVS : </b><small>';
												strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs;
												strExaminations+='</small></li>';
											}
											/*else{
												strExaminations+='No Record Found';
											}*/
											
											
											
											if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns != ''){
												strExaminations+='<li><b style="color: #5a5a5a !important;">CNS : </b><small>';
												strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns;
												strExaminations+='</small></li>';
											}
											/*else{
												strExaminations+='No Record Found';
											}*/
											
											
											
											
											if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs != ''){
												strExaminations+='<li><b style="color: #5a5a5a !important;">RS : </b><small>';
												strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs;
												strExaminations+='</small></li>';
											}
											/*else{
												strExaminations+='No Record Found';
											}*/
											
												
											
											
											if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA != ''){
												strExaminations+='<li><b style="color: #5a5a5a !important;">P/A : </b><small>';
												strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA;
												strExaminations+='</small></li>';
											}
											/*else{
												strExaminations+='No Record Found';
											}*/
											
											if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn != ''){
												strExaminations+='<li><b style="color: #5a5a5a !important;">General Examination : </b><small >';
												strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn;
												strExaminations+='</small></li>';
												
											}
											
											if("strmuscularExamn" in data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation){
												if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn != ''){
													strExaminations+='<li><b style="color: #5a5a5a !important;">Muscular Examination : </b><small >';
													strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn;
													strExaminations+='</small></li>';
													
												}
											}
											
											if("strLocalExamn" in data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation){
												if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn != ''){
													strExaminations+='<li><b style="color: #5a5a5a !important;">Local Examination : </b><small >';
													strExaminations+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn;
													strExaminations+='</small></li>';
													
												}
											}
											
											
											
											
											strExaminations+='</ul></p></div></div>';
											/*else{
												strExaminations+='No Record Found';
											}*/
											
											}
										}
										/*else
										{
											strExaminations+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>SYSTEMATIC EXAMINATION : </b><small>';
											strExaminations+='No Record Found';
											strExaminations+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';	
										}
										*/
										str+=strExaminations;
										
										
										if("strCompleteHistory" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory != '' || data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory != '' ||
													data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory != '' || 	data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory != '' ||
													data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory != '' ){
											strHistory+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>COMPLETE HISTORY : </b><ul>';
											
											strHistory+='<li> <p style="letter-spacing: inherit !important; color: #5a5a5a !important; font-weight: 600; text-align: justify;"><b style="color: #5a5a5a !important;">PAST HISTORY : </b><small style="font-weight: 400 !important;font-size: 14px;">';
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory != ''){
												strHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory;
											}
											
											strHistory+='</small><p/></li>';
											
											strHistory+='<li><p style="letter-spacing: inherit !important; color: #5a5a5a !important; font-weight: 600; text-align: justify;"><b style="color: #5a5a5a !important;">PERSONAL HISTORY : </b><small style="font-weight: 400 !important;font-size: 14px;">';
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory != ''){
												strHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory;
											}
											
											
											strHistory+='</small></p></li>';
											
											strHistory+='<li><p style="letter-spacing: inherit !important; color: #5a5a5a !important; font-weight: 600; text-align: justify;"><b style="color: #5a5a5a !important;">FAMILY HISTORY : </b><small style="font-weight: 400 !important;font-size: 14px;">';
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory != ''){
												strHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory;
											}
											
											strHistory+='</small></p></li>';	
											
											
											strHistory+='<li><p style="letter-spacing: inherit !important; color: #5a5a5a !important; font-weight: 600; text-align: justify;"><b style="color: #5a5a5a !important;">TREATMENT HISTORY : </b><small style="font-weight: 400 !important;font-size: 14px;">';
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory != ''){
												strHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory;
											}
											
											strHistory+='</small></p></li>';
											
											
											
											strHistory+='<li><p style="letter-spacing: inherit !important; color: #5a5a5a !important; font-weight: 600; text-align: justify;"><b style="color: #5a5a5a !important;">SURGICAL HISTORY : </b><small style="font-weight: 400 !important;font-size: 14px;">';
											if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory != ''){
												strHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory;
											}
											
											strHistory+='</small></p></li>';
											strHistory+='</ul></p></div></div>';
										}
									}
										
										str+=strHistory;
										
										
										
										
										if("strChronicDisease" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease.length > 0){
												strChronics+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>CHRONIC DISEASES : </b></p>';
												//strChronics+='<ul>';
												for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease.length;j++){
													var CronicDiseaseName=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseName.split(';')[0];
													var CronicDiseaseDuration=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseDuration;
													var CronicDiseaseRemarks=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseRemarks;
		
													if(CronicDiseaseDuration != '' && CronicDiseaseRemarks != '')
														strChronics+=''+CronicDiseaseName+' ('+CronicDiseaseDuration+' yrs ) ('+CronicDiseaseRemarks+')';
													else if(CronicDiseaseDuration != '')
														strChronics+=''+CronicDiseaseName+' ('+CronicDiseaseDuration+' yrs )';
													else if(CronicDiseaseRemarks != '')
														strChronics+=''+CronicDiseaseName+' ( '+CronicDiseaseRemarks+')';
													else
														strChronics+=''+CronicDiseaseName+' ';
												}
												//strChronics+='</ul>';
												strChronics+='</div></div>';
											}
											/*else{
												strChronics+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>CHRONIC DISEASES : </b><small>';
												strChronics+='No Record Found';
												strChronics+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
											}*/
											
										}
										/*else
										{
											strChronics+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>CHRONIC DISEASES : </b><small>';
											strChronics+='No Record Found';
											strChronics+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';	
										}*/
										
										str+=strChronics;
										
									
									/*str+='<div class="row">'+
									'<div class="col-sm-12">'+
										'<p><b>EXAMINATION </b><small class="">';
									
									str+='</small></p>'+
											'</div>'+
										'</div>'+
										'<br>';*/
									//console.log("Diagnosis.log::::::::::::::::::1");
										if(data.pat_details[i].HRSTR_JSON_DATA.Diagnosis !=''){
										str+='<div class="row">'+
										'<div class="col-sm-12">'+
											'<p><b>DIAGNOSIS : </b><small class="diagnosis">';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.Diagnosis.length;j++){
											
											var x=data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split('#')[4];
											var text='';
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
											    text = "";
											}
											
											
											var remeaksTemp= '';
											if(data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split("#")[7] != ''){
												remeaksTemp=' '+ data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split("#")[7]+' ' ;
											}else{
												remeaksTemp= '';
											}
											var temp=data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].replace("^","#").split("#");
											str+=temp[3].trim()+'( ' + data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split('#')[3]+ ' ' + (text == '' ? '' :  text)+' '+ remeaksTemp+ ' ), '; 
										}
										str+='</small></p>'+
												'</div>'+
											'</div>'+
											'<br>';
										}
										//console.log("Diagnosis.log::::::::::::::::::2");
										
										if("strDiagnosisNote" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote !=''){
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p><b></b><small>';
											for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote.length;j++){
												str+=data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote[j];
											}
											str+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
											}
										}
										/*else{
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>DIAGNOSIS NOTE : </b><small>';
											str+='No Record Found';
											str+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';
										}*/
										
										if(data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint !=''){
										str+='<div class="row">'+
										'<div class="col-sm-12">'+
											'<p><b>INVESTIGATIONS ADVISED : </b></p>'+
											'<ul class="investigation" id="menu1">';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint.length;j++){
											var temp=data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split("^");
											var tempinvs=(data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^').length ==6 ?  data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^')[5].trim():data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^')[7].trim()) ;
											str+='<li>'+ (j+1)+') ' +temp[5].trim() +' ,</li>';
										}
										str+='</ul>'+
												'</div>'+
											'</div>'+
											'<br>';
										}
										/*if("strInvestgationNote" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p><b>INVESTIGATION NOTE : </b><small>';
											for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote.length;j++){
												str+=data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote[j].trim();
											}
											str+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
										}
										else{
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>INVESTIGATION NOTE : </b><small>';
											str+='No Record Found';
											str+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';
										}*/
										
										if("strClinicalProcedure" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure.length > 0 && data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure !=''){
												strClinicalProc+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>PROCEDURES : </b></p>';
												strClinicalProc+='<ul>';
												for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure.length;j++){
													
													if(data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#").length == 7){
														
														var strClinicalProcedureName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[0];
														var strClinicalProcedureSite=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[3];
														var strClinicalProcedureRemarks=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[4];
														var strServicereaName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[6];
														
														if(strClinicalProcedureSite.trim() != 'Side' && strClinicalProcedureRemarks!='')
															strClinicalProc+='<li>'+strServicereaName+' ['+strClinicalProcedureName+']'+', '+strClinicalProcedureSite+', '+strClinicalProcedureRemarks+'</li>';
														else if(strClinicalProcedureSite.trim() != 'Side')
															strClinicalProc+='<li>'+strServicereaName+' ['+strClinicalProcedureName+']'+', '+strClinicalProcedureSite+'</li>';
														else if(strClinicalProcedureRemarks != '')
															strClinicalProc+='<li>'+strServicereaName+' ['+strClinicalProcedureName+']'+', '+strClinicalProcedureRemarks+'</li>';
														else
															strClinicalProc+='<li>'+strServicereaName+' ['+strClinicalProcedureName+']'+'</li>';
														
														
													}else{
													var strClinicalProcedureName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[0];
													var strClinicalProcedureSite=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[3];
													var strClinicalProcedureRemarks=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[4];
													
													if(strClinicalProcedureSite.trim() != 'Side' && strClinicalProcedureRemarks!='')
														strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureSite+', '+strClinicalProcedureRemarks+'</li>';
													else if(strClinicalProcedureSite.trim() != 'Side')
														strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureSite+'</li>';
													else if(strClinicalProcedureRemarks != '')
														strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureRemarks+'</li>';
													else
														strClinicalProc+='<li>'+strClinicalProcedureName+'</li>';
													}
													
												}
												strClinicalProc+='</div></div>';
											}
											/*else{
												strClinicalProc+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>PROCEDURES : </b><small>';
												strClinicalProc+='No Record Found';
												strClinicalProc+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
											}*/
											
										}
										/*else
										{
											strClinicalProc+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>CLINICAL PROCEDURES : </b><small>';
											strClinicalProc+='No Record Found';
											strClinicalProc+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';	
										}*/
										
										str+=strClinicalProc;
										if(data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice.trim() != ''){
										str+='<div class="row">'+
										'<div class="col-sm-12">'+
											'<p style="text-align: justify;"><b>TREATMENT ADVICE : </b><small class="clinicalNote">';
								//for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice.length;j++){
									
									str+=data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice.trim();
								//}
								
								str+='</small></p>'+
										'</div>'+
									'</div>'+
									'<br>';
								}
								
										if(data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat !=''){
										str+='<div class="row">'+
										'<div class="col-sm-12" align="center">'+
											'<p style="text-align: left;font-size: small;font-family: cursive;margin-bottom: 0px;">Rx</p>'+
											'<ol class="printPrescTreatmentLst"> ';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat.length;j++){
											
											var temp=data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat[j].split("&&");
											if(temp[8].trim() !='')
											str+='<li>'+temp[0].trim()+', '+temp[2].trim()+', '+temp[4].trim()+', '+temp[7].trim().split('#')[0]+' Days ,'+'Qty : '+temp[7].trim().split('#')[1]+', '+temp[6].trim()+', ('+temp[8].trim()+') </li>';
											else
												str+='<li>'+temp[0].trim()+', '+temp[2].trim()+', '+temp[4].trim()+', '+temp[7].trim().split('#')[0]+' Days ,'+'Qty : '+temp[7].trim().split('#')[1]+', '+temp[6].trim()+'</li>';	
											
											//str+='<li><b>'+temp[0].trim()+'</b></li>';
										}
										
										str+='</ol>'+
												'</div>'+
											'</div>'+
										'<br>';
										}
										/// Commented By Timsi. Do Not Remove. ///
										/*if("strDrugAllergy" in (data.pat_details[i].HRSTR_JSON_DATA))
										{
											if(data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy.length > 0){
												strAllergies+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>ALLERGIES : </b></p>';
												strAllergies+='<ul>';
												for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy.length;j++){
													var strAllergyName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergyName.split(';')[0];
													var strAllergySytmptomsName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergySytmptomsName.split(';')[0];
													var strSensivityName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strSensivityName;
													var strAllergysiteName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergysiteName.split(';')[0];
													var stDurationTime=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].stDurationTime;
													var strAllergyRemarks=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergyRemarks;
				
													if(strAllergysiteName != '' && strSensivityName!='')
														strAllergies+='<li>'+strAllergyName+'('+strSensivityName+' on '+strAllergysiteName+'), '+strAllergySytmptomsName+', '+stDurationTime+' yrs, '+strAllergyRemarks+'</li>';
													else
														strAllergies+='<li>'+strAllergyName+', '+strAllergySytmptomsName+', '+stDurationTime+' yrs, '+strAllergyRemarks+'</li>';
													
												}
												strAllergies+='</div></div>';
											}
											else{
												strAllergies+='<div class="row">'+
												'<div class="col-sm-12">'+
												'<p><b>ALLERGIES : </b><small>';
												strAllergies+='No Record Found';
												strAllergies+='</small></p>'+
												'</div>'+
												'</div>'+
												'<br>';
											}
											
										}
										else
										{
											strAllergies+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p><b>ALLERGIES : </b><small>';
											strAllergies+='No Record Found';
											strAllergies+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';	
										}
										
										str+=strAllergies;
									*/
									
									//Put Treatment Advice Here
									if("strDrugAllergy" in (data.pat_details[i].HRSTR_JSON_DATA)){	
										if(data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy !=''){
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p><b>DRUG ALLERGY : </b></p>'+
												'<ul class="drugallergy" id="menu1">';
											for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy.length;j++){
												var temp=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergyName;
												str+='<li>'+ (j+1)+') ' +temp+' ,</li>';
											}
											str+='</ul>'+
													'</div>'+
												'</div>'+
												'<br>';
											}else{
												
										/*		str+='<div class="row">'+
												'<div class="col-sm-12">'+
													'<p><b>DRUG ALLERGY : </b></p>'+
													'<ul class="drugallergy" id="menu1">';
												str+='<li> No Known Drug Allergy </li>';
												
												str+='</ul>'+
														'</div>'+
													'</div>'+
													'<br>'; */
												
												
												str+='<div class="row">'+
												'<div class="col-sm-12">';
													
											//	str+='<li> No Known Drug Allergy </li>';
		  								    	
												str+='</div>'+
													'</div>'+
													'<br>';
											}
								}else{
									
								/*	str+='<div class="row">'+
									'<div class="col-sm-12">'+
										'<p><b>DRUG ALLERGY : </b></p>'+
										'<ul class="drugallergy" id="menu1">';
									str+='<li> No Known Drug Allergy </li>';
									
									str+='</ul>'+
											'</div>'+
										'</div>'+
										'<br>'; */
									
									str+='<div class="row">'+
									'<div class="col-sm-12">';
										
							//		str+='<li> No Known Drug Allergy </li>';
									
									str+='</div>'+
										'</div>'+
										'<br>';
									
								}
						
									
										
										
										if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP !=''){
										
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP.length;j++){
											if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim() !=''){
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
											'<p style="text-align: justify;"><b>CLINICAL NOTE : </b><small class="clinicalNote">';
											str+=data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim();
											str+='</small></p>'+
											'</div>'+
											'</div>'+
											'<br>';
											 }
											}
										}
										
										/*if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory != ''){
											////console.log('result.strHistoryOfPresentIllNess'+data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess);
											  $('#pastHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory[0].strsurgicalHistory);
										}*/
								
										//Showing HOPI of last visit ,if not required should be commented	
										if(data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess != ''){
											////console.log('result.strHistoryOfPresentIllNess'+data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess);
											
											if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											/*	var today = new Date(); 
												 var dd = today.getDate();
												 dd = dd.toString().length>1 ? dd : "0"+dd;
												 var mm = today.getMonth() + 1;
												 mm = mm.toString().length>1 ? mm : "0"+mm;
												 var yyyy=today.getFullYear();
												 today = dd+'/'+mm+'/'+yyyy; */
												//console.log('----------------------------------->'+todaysys);
												//console.log('----------------------------------->'+new Date().getDate()+'/'+(new Date().getMonth()+1)+'/'+new Date().getFullYear());
												 //console.log('----------------------------------->'+data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate);
												 //console.log(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate); 
												 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate){
													 $('#hopiId').val(data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess);
													 $('#completeHistoryDiv').find('.accordionbtn').trigger('click');
												 }
												
											}																																
											
										}
									
										
										if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP !=''){
									
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP.length;j++){
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p style="text-align: justify;"><b>FOLLOW UP : </b><small class="followUp">';
											
											if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitSos!='' && data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitSos!=null){
												str+=data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitSos;
												
											}
											else if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDays!='' && data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDays!=null){
												str+='After '+data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDays+' Days';
												$('#followUpPlannedVisitDaysId').val(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDays);
												
											}
											else if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDate!='' && data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDate!=null){
												str+='On '+data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDate;
												//$('#followUpPlannedVisitDateId').val('data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].Planned_Visit[0].plannedVisitDate');
											}
											str+='</small></p>'+
											'</div>'+
										'</div><br>';
										}
									}
										
										
										
										if("strReferal" in data.pat_details[i].HRSTR_JSON_DATA ){
										if(data.pat_details[i].HRSTR_JSON_DATA.strReferal.length > 0){
											
											str+='<div class="row">'+
											'<div class="col-sm-12">'+
												'<p style="text-align: justify;"><b>Refer To.: </b><small class="clinicalNote"><br>';
											
											for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strReferal.length;j++){
											
												if("strShowData" in data.pat_details[i].HRSTR_JSON_DATA.strReferal[j]){
													var strrefertext='';
													if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strShowData != ''){
														 strrefertext =data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strShowData ;
													 if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralReason !='')
														 strrefertext = strrefertext + '( ' +data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralReason +')' ;
													 if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strreferralType !='0')
														 strrefertext = strrefertext + '[ ' +data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strreferralTypeName +']' ;
														 
													/* if(data.strReferal[j].strReffralReason !='') */
													//	$('.printPrescPage .refferPatientDept').append('<li><p>'+strrefertext+ ' </li></p>');	 
													/* else if(data.strReferal[j].strreferralType != '0')
														$('.printPrescPage .refferPatientDept').append('<li><p>'+data.strReferal[j].strReffralDepttext+ '['+data.strReferal[j].strreferralTypeName+']'+' </li></p>');
													else
														$('.printPrescPage .refferPatientDept').append('<li><p>'+data.strReferal[j].strReffralDepttext +' </li></p>'); */
													str+=strrefertext+'<br>'; 
													}
													
													
												}else{
												
											if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralReason.trim() != '')
											str+=data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralDepttext.trim()+" ("+data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralReason.trim()+" ) , ";
											else
											str+=data.pat_details[i].HRSTR_JSON_DATA.strReferal[j].strReffralDepttext.trim()+", ";	
										
												}
										
												
											}
											
											
											str+='</small></p>'+
											'</div>'+
										'</div>'+
										'<br>';
											
									}
								}
										/*'<br>'+ 
										'<div id="patQrCode" class="pull-right"></div>'+  
										'<br>'+*/
										str+='<br>'+
										'<h5 style="font-weight:bold; margin-top:0;margin-bottom:0;">Doctor Signature :</h5>'+'<br>'+ 
										'<h5 class="consultantName" style="margin-top:0">'+data.pat_details[i].USER_NAME.trim()+'<br>'+data.pat_details[i].DATASAVE_TIME.trim()+'</h5>'
										
										
									'</div>';
									
									 var date = new Date();
									 document.title=window.patCrNo+date.getDate()+(date.getMonth()+1)+date.getFullYear();
									 //console.log('Date:::::::::>>>>>>>'+date.getDate()+(date.getMonth()+1)+date.getFullYear());
									 //console.log('time ::>>>>>>>>>>>>>>'+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds());
									 ////console.log('data.CR_No.toString()+(date.getDate()+date.getMonth()+date.getFullYear())::::::::::>>>>>>>'+data.CR_No.toString()+date.getDate()+(date.getMonth()+1)+date.getFullYear());
										
									 //str+='<table><thead></thead><tbody></tbody><tfoot><tr><td><div class="page-footer-space"></div></td></tr></tfoot>';
									 /*var dateTime=date.getDate()+'-'+(date.getMonth()+1)+'-'+date.getFullYear()+' at '+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds();
									 str+='<div class="footerPastPresc">CRNo. <font class="footerCrNo">'+window.patCrNo+'</font> Printing Date : <font class="printDateAndTime>'+dateTime+'</font></div>';*/
									$('.opdEmrModalNavMenuContent').append('<div class="tab-pane" id="'+menuId+(i+1)+'">'+str+'</div>');
									
								}
						}
						$('.opdEmrModalNavMenu').children('li').eq(0).addClass('active');
						/*var temp = $('.opdEmrModalNavMenu li.active a').attr('href');
						alert(temp);*/
						$('.opdEmrModalNavMenuContent').children('div').eq(0).addClass('active');
						
						checkProfileOnLoadOfRX();
					}
					else{
						$('#prescriptionListMsg').text('No Past Precriptions Found !');	
					}							
				},
				complete: $('#prescriptionListMsg').text('Error !!!')
		});
		
		  $('#followUpPlannedVisitRefreshId').tooltip({
	        placement:"top"
	      });
		  $('#treeStructurePrescBtnId').tooltip({
	        placement:"top"
	      });
	      $('#opdEmrBtnId').tooltip({
	        placement:"top"
	      });
	      $('#bmiIdValue').tooltip({
	        placement:"top"
	      });
	      $('#temperatureIdValue').tooltip({
	        placement:"top"
      	  });
	      $('#bloodPressureIdValue').tooltip({
	        placement:"top"
      	  });
	      $('#pulseIdValue').tooltip({
	        placement:"top"
	      });
	      $('#drugFrequency').tooltip({
	        placement:"top"
	      });
	      $('#drugInstructions').tooltip({
	        placement:"top"
	      });
	      $('#externalDrugFrequency').tooltip({
	        placement:"top"
	      });
	      $('#externalDrugInstructions').tooltip({
	        placement:"top"
	      });
	      $('#vitalModify').tooltip({
	        placement:"top"
	      });
	      $('.clearAllValues').tooltip({
	        placement:"top"
	      });
	      $('#respRateIdValue').tooltip({
		        placement:"top"
		      });
	      $('.reasonOfVisitAdd').tooltip({
		        placement:"top"
		      });
	      
	      
	      $(window).bind("resize", function () {
	          if($(window).width() <= 576){
	            $('.siteDiv').removeClass('paddingLeftRightZero');
	            $('.itemTypeDiv').removeClass('paddingLeftRightZero');
	            $('.chiefComplaintDuration').removeClass('alignLeftPaddingLeftZero');
	            $('.chiefComplaintNoOfDays').removeClass('paddingRightZero');
	            $('.chiefComplaintDuration').addClass('paddingLeftRightZero');
	            $('.chiefComplaintNoOfDays').addClass('paddingLeftRightZero');
	            $('.quantityDiv').removeClass('paddingRightZero');
	          }
	        }).trigger('resize');

	        $(window).bind("resize", function () {
	          if($(window).width() <= 767){
	            $('.siteDiv').removeClass('paddingLeftRightZero');
	            $('.itemTypeDiv').removeClass('paddingLeftRightZero');
	            $('.chiefComplaintDuration').removeClass('alignLeftPaddingLeftZero');
	            $('.chiefComplaintNoOfDays').removeClass('paddingRightZero');
	            $('.chiefComplaintDuration').addClass('paddingLeftRightZero');
	            $('.chiefComplaintNoOfDays').addClass('paddingLeftRightZero');
	            $('.quantityDiv').removeClass('paddingRightZero');
	          }
	        }).trigger('resize');

	        $(window).bind("resize", function () {
	          if($(window).width() > 768){
	            $('.siteDiv').addClass('paddingLeftRightZero');
	            $('.itemTypeDiv').addClass('paddingLeftRightZero');
	            $('.chiefComplaintDuration').addClass('alignLeftPaddingLeftZero');
	            $('.chiefComplaintNoOfDays').addClass('paddingRightZero');
	            $('.chiefComplaintDuration').removeClass('paddingLeftRightZero');
	            $('.chiefComplaintNoOfDays').removeClass('paddingLeftRightZero');
	            $('.quantityDiv').addClass('paddingRightZero');
	          }
	        }).trigger('resize');
	        
	        $(window).bind("resize", function () {
	            if($(window).width() < 602){
	              $('.AddToggleClass').addClass('btn-block');
	            }
	            else{
	              $('.AddToggleClass').removeClass('btn-block');
	            }
	          }).trigger('resize');
	        
	        /* this is use to EMR / History Data */
	        var strEpisodeCodeChk=window.episodeCode;
	        if(window.patCrNo==""){
				  return;
			  }
	      $.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatDataForPastPrescription?Modval=2&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
				async:true,
				beforesend : $('.TreeStructurePrescriptionModalErrMsg').parent().append('<p id="TreeStructurePrescriptionListMsg"><i class="fa fa-spinner fa-spin"></i> Loading</p>'),
					success:function(data){ 
						var strProfileInfo = '' , strChiefComplaint = '' , strDiagnosis = '' , strInvestigations = '' , strDrugsAndAdvices = '' , strClinicalNote = '';
						var strHistory = '' , strExaminations = '' , strAllergies = '' , strChronics = '' , strClinicalProc = '' ;
						var strtreatmentAdvice123 ='';
						var strClinicalProcedure ='';
						var strTreatmentAdviceService ='';
						var str = '';
						var strconfidentialInfo ='';
						
						//alert(Object.keys(data).length);
						//alert(Object.keys(data.pat_details).length);
						if(Object.keys(data.pat_details).length > 0){
							$('#TreeStructurePrescriptionListMsg').remove();
							
							$('.TreeStructurePrescriptionModalNavMenu').children('li').eq(0).remove();
							$('.TreeStructurePrescriptionModalNavMenuContent').children('div').eq(0).remove();
							
							var months1 = new Array(12);
						 	months1[1] = "Jan";
						 	months1[2] = "Feb";
						 	months1[3] = "Mar";
						 	months1[4] = "Apr";
						 	months1[5] = "May";
						 	months1[6] = "Jun";
						 	months1[7] = "Jul";
						 	months1[8] = "Aug";
						 	months1[9] = "Sep";
						 	months1[10] = "Oct";
						 	months1[11] = "Nov";
						 	months1[12] = "Dec";
						 	
							var today = new Date();
							var printDate = today.getDate()+'-'+months1[today.getMonth()+1]+'-'+today.getFullYear();
							var printTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
							
							str+='<div class="row"><h4 class="text-center" style="font-weight:bold">PATIENT CLINICAL DATA</h4>'+
							'</div>'+  
							'<div class="" style="border-top: 1px solid grey; border-bottom: 1px solid grey;">'+
							'<table class="table table-condensed printPrescPatDtlTbl table-responsive">'+
							'<tbody>'+
							'<tr>'+
							'<th>Name</th><td class="patName">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim();
							str+='</td><th>BEN ID.</th><td class="patCrNo">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim();
							str+='</td></tr>';
							str+='<tr>'+
							'<th>Department(Unit/Consultant)</th><td class="patDeptU">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.patDept.trim();
							str+='</td><th>Reprinted On</th><td class="printedOn">';
							str+=printDate+' / '+printTime;
							str+='</td></tr>';
							
							str+='<tr>'+
							'<th>Mobile No</th><td class="patDeptU">';
							if((data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[14].trim())
							str+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[14].trim();
							
							if($('#strRailTailFlgId').val() == '0'){
							
							str+='</td><th>Occupation</th><td class="printedOn">';
							str+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17].trim();
							str+='</td></tr>';
							}else{
								var patOthersDetails1=$('#patOthersDetailsPrescriptionPanel').html()
								if(patOthersDetails1 !='{}'){
								str+='</td><th>Designation</th><td class="printedOn">';
								str+=(JSON.parse(patOthersDetails1).designation);
								str+='</td></tr>'
									
									str+='<tr>'+
									'<th>Station</th><td class="patDeptU">';
								
								str+=(JSON.parse(patOthersDetails1).custom_unit);
								str+='</td><th></th><td></td></tr>'
								} else{
									str+='</td><th>Occupation</th><td class="printedOn">';
									str+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17].trim();
									str+='</td></tr>';
									
								}
									
							}
							
							////console.log("patOthersDetailsPrescriptionPanel ::::::::::  "  +$('#patOthersDetailsPrescriptionPanel').html());
							
							str+='</tbody></table></div>';
							
							/*str+='<div class="row"><h4 class="text-center" style="font-weight:bold">AIIMS PATNA OPD PRESCRIPTION</h4>'+
							'</div>'+  
							'<div class="" style="border-top: 1px solid grey; border-bottom: 1px solid grey;">'+
							'<table class="table table-condensed printPrescPatDtlTbl table-responsive">'+
							'<tbody>'+
							'<tr>'+
							'<th>Name</th><td class="patName">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim();
							str+='</td><th>BEN ID.</th><td class="patCrNo">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim();
							str+='</td></tr><tr><th>Age/Gender</th><td class="patAgeGen">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.patAge.trim()+'/'+data.pat_details[0].HRSTR_JSON_DATA.patGender.trim();
							str+='</td><th>Patient Category</th><td class="patCat">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.patCat.trim();
							str+='</td></tr><tr>'+
								'<th>Father/Spouse Name</th><td class="patRelName">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.patGaurdianName.trim();
							str+='</td><th>Consultant Name</th><td class="consultantName">';
							str+=data.pat_details[0].HRSTR_JSON_DATA.patConsultantName.trim();
							str+='</td></tr></tbody></table></div>';*/
							
							strProfileInfo+='<div class="row"><div style="width: 100%;" class="profileInfo col-md-6">'+
			                '<table class="table table-condensed printPrescPatDtlTbl table-responsive">'+
			                '<thead>'+
			                '<tr>'+
			                '<td style="width:10%;"><img alt="" src="/HIS/hisglobal/images/cghs_logo.png" style="width:85px;"></td>'+
			                '<td style="width:80%;text-align: center;vertical-align: top;letter-spacing: 1px"><h4 style="font-weight:bold;">'+
			                '&#x915;&#x947;&#x928;&#x94D;&#x926;&#x94D;&#x930;&#x940;&#x92F;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;&#x20;&#x938;&#x94D;&#x935;&#x93E;&#x938;&#x94D;&#x925;&#x94D;&#x92F;&#x20;&#x92F;&#x94B;&#x91C;&#x928;&#x93E;'+
			                '</h4>'+
			                '<h4>Central Government Health Scheme</h4>'+
			              /*  '<h5 class="" style="font-weight:bold;">'+
			                hospitalName + ' - (' + hospitalTypeName + ')' +
			                '</h5>'+
			                (address1 ? '<h5 style="font-weight:bold;">' + address1 + '</h5>' : '') +
			                '</td>'+
			                '<td style="width:15%;text-align: center;"><span id="patQrCode"></span></td>'+*/
			                '</tr>'+
			                '</thead>'+
			                '<tbody>';
							
							strProfileInfo+='<tr>'+
						    '<td><h5 style="width: 300px !important;">Patient Name : <span>'+data.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim()+' </span></h5> <td >'+
						    '<td><h5 style="width: 300px !important;">&#x932;&#x93E;&#x92D;&#x93E;&#x930;&#x94D;&#x925;&#x940;&#x20;&#x915;&#x940;&#x20;&#x92A;&#x939;&#x91A;&#x93E;&#x928;&#x20;&#x938;&#x902;&#x2E; / Beneficiary ID : <span>'+data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim()+' </span></h5> <td >'
						    ;
							strProfileInfo+='<tr>'+
						    '<td><h5 style="width: 300px !important;">&#x906;&#x92F;&#x941;/&#x932;&#x93F;&#x902;&#x917; / Age/Gender : <span>';if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'M'){
								strProfileInfo+='Male';
							}
							else if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'F'){
								strProfileInfo+='Female';
							} 
						    strProfileInfo+=' </span></h5> <td >'+
						    '<td><h5 style="width: 300px !important;">&#x915;&#x93E;&#x930;&#x94D;&#x921;&#x20;&#x915;&#x93E;&#x20;&#x92A;&#x94D;&#x930;&#x915;&#x93E;&#x930; /Card Type : <span>'+data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim()+' </span></h5> <td >'
						    ;
							strProfileInfo+='<tr>'+
						    '<td><h5 style="width: 300px !important;">&#x938;&#x92E;&#x94D;&#x92C;&#x902;&#x927; / Relation : <span>'+data.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim()+' </span></h5> <td >'+
						    '<td><h5 style="width: 300px !important; display:none;">&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x2F;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x926;&#x93E;&#x924;&#x93E;&#x20; / Department/Consultant : <span>'+data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim()+' </span></h5> <td >'
						    ;
							strProfileInfo+='<tr>'+
						    '<td><h5 style="width: 300px !important;">&#x935;&#x93F;&#x92D;&#x93E;&#x917;&#x2F;&#x92A;&#x930;&#x93E;&#x92E;&#x930;&#x94D;&#x936;&#x926;&#x93E;&#x924;&#x93E;&#x20; / Department/Consultant : <span>'+(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[14]+' </span></h5> <td >'+
						    '<td><h5 style="width: 300px !important;">&#x926;&#x93F;&#x928;&#x93E;&#x902;&#x915; / Date : <span>'+data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim()+' </span></h5> <td >';
						/*	strProfileInfo+=data.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim();
							strProfileInfo+='</td></tr><tr><th>BEN ID. : </th><td class="patCrNo">';
							strProfileInfo+=data.pat_details[0].HRSTR_JSON_DATA.CR_No.trim();
							strProfileInfo+='</td></tr><tr><th>Gender : </th><td class="patGen">';
							
							if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'M'){
								strProfileInfo+='Male';
							}
							else if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'F'){
								strProfileInfo+='Female';
							}
							
							strProfileInfo+='</td></tr><tr><th>Age : </th><td class="patAge">';
							strProfileInfo+=data.pat_details[0].HRSTR_JSON_DATA.patAge.trim();
							strProfileInfo+='</td></tr>';
							if(data.pat_details[0].HRSTR_JSON_DATA.patCat!=undefined){
								strProfileInfo+='<tr><th>Category : </th><td class="patCat">';
								strProfileInfo+=data.pat_details[0].HRSTR_JSON_DATA.patCat.trim();
								strProfileInfo+='</td></tr>';
							}*/
							/*strProfileInfo+='<tr><th>Refered By : </th><td>';
							strProfileInfo+=''; // Fill in the refered by Consultant name
							strProfileInfo+='</td></tr>';
							strProfileInfo+='<tr>'+*/
							/*strProfileInfo+='<th>Father/Spouse Name : </th><td class="patRelName">';
							strProfileInfo+=data.pat_details[0].HRSTR_JSON_DATA.patGaurdianName.trim();
							strProfileInfo+='</td></tr> '; 
							
							strProfileInfo+='</tr><tr>'+
						    '<th>Mobile No : </th><td class="patRelName">';
							strProfileInfo+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[14];
							strProfileInfo+='</td></tr> ';*/
							if($('#strRailTailFlgId').val() == '0'){
							
							strProfileInfo+='</tr><tr>'+
						    '<th>Occupation : </th><td class="patRelName">';
							strProfileInfo+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17];
							strProfileInfo+='</td></tr> ';
							}else{
								var patOthersDetails1=$('#patOthersDetailsPrescriptionPanel').html();
								if(patOthersDetails1 !='{}'){
								strProfileInfo+='</tr><tr>'+
							    '<th>Designation : </th><td class="patRelName">';
								strProfileInfo+=(JSON.parse(patOthersDetails1).designation);
								strProfileInfo+='</td></tr> ';
								
								strProfileInfo+='</tr><tr>'+
							    '<th>Station : </th><td class="patRelName">';
								strProfileInfo+=(JSON.parse(patOthersDetails1).custom_unit);
								strProfileInfo+='</td></tr> ';
								}else{
									strProfileInfo+='</tr><tr>'+
								    '<th>Occupation : </th><td class="patRelName">';
									strProfileInfo+=(data.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17];
									strProfileInfo+='</td></tr> ';
									
								}
							}
							
							strProfileInfo+='</tbody></table></div>';
							
							if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'M'){
								strProfileInfo+='<div class="col-md-3" style="display:none">'+
								  '<img src="/HISDRDESK_MC/hisglobal/images/MaleIcon.png"  class="patImg" style="height:108px;width:108px;">'+
								'</div>';
							}
							else if(data.pat_details[0].HRSTR_JSON_DATA.patGender.trim() == 'F'){
								strProfileInfo+='<div class="col-md-3"  style="display:none">'+
								  '<img src="/HISDRDESK_MC/hisglobal/images/FemaleIcon.png" class="patImg" style="height:108px;width:108px;">'+
								'</div>';
							}						
							strProfileInfo+='</div>'; //End of row
							strProfileInfo+='<p>OPD Visit Summary:  (Last 5)</p>';
							
							for(var i=0;i<Object.keys(data.pat_details).length;i++){  
								
								var visitDate = data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate.trim();
								var temp = visitDate.split("/");
								var months = new Array(12);
							 	months[1] = "Jan";
							 	months[2] = "Feb";
							 	months[3] = "Mar";
							 	months[4] = "Apr";
							 	months[5] = "May";
							 	months[6] = "Jun";
							 	months[7] = "Jul";
							 	months[8] = "Aug";
							 	months[9] = "Sep";
							 	months[10] = "Oct";
							 	months[11] = "Nov";
							 	months[12] = "Dec";

							 	var maxDate = temp[0]+" "+months[temp[1]] +", "+temp[2];
							 	
							 	if(i<7){ //For details of last 7 visits
							 	strProfileInfo+='<table class="table table-condensed PatVisitSummaryDtlTbl table-responsive">'+
								'<tbody>'+
								'<tr><th width="5%">Dept: </th><td class="dept" width="45%">';
							 	strProfileInfo+=data.pat_details[i].HRSTR_JSON_DATA.patDept.trim();
							 	strProfileInfo+='</td><th width="10%">Visit Date: </th><td class="visitDate" width="12%">';
							 	strProfileInfo+=data.pat_details[i].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim().split('#')[7];
							 	strProfileInfo+='</td><th width="10%">Unit Head: </th><td width="18%">';
							 	////console.log("Railtel_Flag : "+$('#strRailTailFlgId').val());
							 	if($('#strRailTailFlgId').val() == '1')
							 		strProfileInfo+='-';
							 	else
							 		strProfileInfo+=data.pat_details[i].HRSTR_JSON_DATA.patConsultantName.trim();
							 	strProfileInfo+='</td></tr></table>';
							 	
							 	/*strProfileInfo+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
							 	strProfileInfo+='<p>Consultant Name : <small>';
								strProfileInfo+=data.pat_details[i].HRSTR_JSON_DATA.patConsultantName.trim();
								strProfileInfo+='</small></p>';*/
							 	}
							 	if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit.length > 0){
							 		
							 	strChiefComplaint+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
								strChiefComplaint+='<p><small>';
								
									for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit.length;j++){
										
										
										var text='';
										var text1='';
										//console.log('Visit Reason Length:::::::'+data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length);
										if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length == 2)
											{
											VisitReason=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j]+'^0^^0';
											}else{
												VisitReason=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j];
												}
										var x=VisitReason.split('^')[2];
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
										    text = "";
										}
										var y=VisitReason.split('^')[4];
										switch (parseInt(y)) {
										  case 0:
										    text1 = "";
										    break;
											case 1:
										    text1 = "Day/s";
										    break;
											case 2:
										    text1 = "Week/s";
										    break;
											case 3:
										    text1 = "Month/s";
										    break;
											case 4:
										    text1 = "Year/s";
										    break;
											default:
										    text1 = "";
										}
										
										
										
										
										var remarks_temp ='';
										if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^').length == 6){
										if(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[5].trim() != '' )
											{
											remarks_temp =' '+data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[5].trim()+' ';
											}else{
												remarks_temp='';
											}
										}
										//strChiefComplaint+=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[1].trim()+remarks_temp+', ';
										strChiefComplaint+=data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[1].trim()+(text == '' ? '' : ' ('+text+','+(data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[3].trim()==''? '' : +data.pat_details[i].HRSTR_JSON_DATA.ReasonOfVisit[j].split('^')[3].trim()+' '+ text1) +')')+remarks_temp+', '
									}
								
								/*else{
									strChiefComplaint+='No Record Found';
								}*/
								
								strChiefComplaint+='</small></p>';
							 	}
								
								
								
								
								
								if(data.pat_details[i].HRSTR_JSON_DATA.Diagnosis.length > 0){
									
									strDiagnosis+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									if(data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote != ''){
										strDiagnosis+='<p><small><b>Diagnosis Note</b> : ';
										strDiagnosis+=data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote;
										strDiagnosis+='</small></p>';
										
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
												 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
											     $('#diagnosisNoteId').val(data.pat_details[i].HRSTR_JSON_DATA.strDiagnosisNote);
												
											}	
										
									}
									strDiagnosis+='<p><small>';
									for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.Diagnosis.length;j++){
										
										var x=data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split('#')[4];
										var text='';
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
										    text = "";
										}
										
										
										var remeaksTemp= '';
										if(data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split("#").length == 8){
										if(data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split("#")[7] != ''){
											remeaksTemp=' '+ data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split("#")[7]+' ' ;
										}else{
											remeaksTemp= '';
										}
									}
										var temp=data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].replace("^","#").split("#");
										//strDiagnosis+=temp[3].trim()+remeaksTemp+', ';
										
										strDiagnosis+=temp[3].trim()+'( ' + data.pat_details[i].HRSTR_JSON_DATA.Diagnosis[j].split('#')[3]+ ' ' + (text == '' ? '' :  text)+' '+ remeaksTemp+ ' ), '; 
									}
									strDiagnosis+='</small></p>';
								}
								
								if(data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint.length > 0){
									strInvestigations+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									if(data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote != ''){
										strInvestigations+='<p><small><b>Investigation Note</b> : ';
										strInvestigations+=data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote;
										strInvestigations+='</small></p>';
										//past investigation note
										//if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode)
										//$('#investigationNoteId').val(data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote);
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#investigationNoteId').val(data.pat_details[i].HRSTR_JSON_DATA.strInvestgationNote);
											
										}
									}
									strInvestigations+='<p><ol class="investigation">';
									for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint.length;j++){
										var temp=data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split("^");
										var tempinvs=(data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^').length ==6 ?  data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^')[5].trim():data.pat_details[i].HRSTR_JSON_DATA.InvTestCodeToPrint[j].split('^')[7].trim()) ;
										strInvestigations+='<li>'+temp[5].trim()+'</li>';
									}
									strInvestigations+='</ol></p>';
								}
								
								//console.log(data.pat_details[i].HRSTR_JSON_DATA);
								if(data.pat_details[i].HRSTR_JSON_DATA.externalInvestigationReferalDtl.length > 0){
									//alert(JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA.externalInvestigationReferalDtl));
									strInvestigations+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									strInvestigations+='<p><ol class="investigation">';
									$.each(data.pat_details[i].HRSTR_JSON_DATA.externalInvestigationReferalDtl, function(indx, invjson){
										//alert("invjson--" + JSON.stringify(invjson));
										strInvestigations+='<li>Test name : '+invjson["strReffralExtName"]+' , Referral Note : '+invjson["refferalExtReson"]+' ,No. of Investigation : ' +invjson["noAllowed"]+' , Valid Upto : '+invjson["validUpto"]+'</li>';
									});
									strInvestigations+='</ol></p>';
								}
								
								
								if(data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat.length > 0){
									strDrugsAndAdvices+='<p><u>'+maxDate+' : '+data.pat_details[i].DATASAVE_TIME.split(" ")[1].trim()+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									strDrugsAndAdvices+='<p><ol class="printPrescTreatmentLst">';
									for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat.length;j++){
										var temp=data.pat_details[i].HRSTR_JSON_DATA.DrugCodeCat[j].split("&&");
										if(temp[8].trim() !='')
										strDrugsAndAdvices+='<li>'+temp[0].trim()+', '+temp[2].trim()+', '+temp[4].trim()+', '+temp[7].trim().split('#')[0]+' Days,'+' Qty : '+temp[7].trim().split('#')[1]+', '+temp[6].trim() + '('+temp[8].trim()+') </li>';
										else
											strDrugsAndAdvices+='<li>'+temp[0].trim()+', '+temp[2].trim()+', '+temp[4].trim()+', '+temp[7].trim().split('#')[0]+' Days,'+' Qty : '+temp[7].trim().split('#')[1]+', '+ temp[6].trim()+'</li>';
									}
									strDrugsAndAdvices+='</ol></p>';
								}
								
								if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP.length > 0){
									strClinicalNote+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									strClinicalNote+='<p><small>';
									for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP.length;j++){
										if(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim() != ''){
											strClinicalNote+=data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim();
											//Past Data fill Clinical progress Note
										//	if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode)
										//	$('#progressNote').val(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim());
											if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
												 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
												 $('#progressNote').val(data.pat_details[i].HRSTR_JSON_DATA.FOLLOW_UP[j].progressNote.trim());
												
											}
											
										}
									}
									strClinicalNote+='</small></p>';
								}
								
								if("strCompleteHistory" in (data.pat_details[i].HRSTR_JSON_DATA))
								{
									var strHistoryOfPresentIllNess='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess != ''){
										strHistoryOfPresentIllNess+='<p><small><b>HOPI</b> : ';
										strHistoryOfPresentIllNess+=data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess;
										strHistoryOfPresentIllNess+='</small></p>';
									}
									var strsurgicalHistory='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory != ''){
										strsurgicalHistory+='<p><small><b>Surgical History</b> : ';
										strsurgicalHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory;
										strsurgicalHistory+='</small></p>';
										 if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#surgicalHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strsurgicalHistory);
											
										}		
									}							
									var strpersonalHistory='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory != ''){
										strpersonalHistory+='<p><small><b>Personal History</b> : ';
										strpersonalHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory;
										strpersonalHistory+='</small></p>';
										 if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#personalHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpersonalHistory);
											
										}
									}							
									var strtreatmentHistory='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory != ''){
										strtreatmentHistory+='<p><small><b>Treatment History</b> : ';
										strtreatmentHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory;
										strtreatmentHistory+='</small></p>';
										 if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#treatmentHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strtreatmentHistory);
											
										}
									}
									var strpastHistory='';
									//alert(JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA));
									//console.log(JSON.stringify(data.pat_details[i].HRSTR_JSON_DATA));
									if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory != ''){
										strpastHistory+='<p><small><b>Past History</b> : ';
										strpastHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory;
										strpastHistory+='</small></p>';
										 if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate){
												 $('#hopiId').val(data.pat_details[i].HRSTR_JSON_DATA.strHistoryOfPresentIllNess);
												 $('#pastHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strpastHistory);
											 }
											
										}
									}
									var strfamilyHistory='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory != ''){
										strfamilyHistory+='<p><small><b>Family History</b> : ';
										strfamilyHistory+=data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory;
										strfamilyHistory+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#familyHistoryId').val(data.pat_details[i].HRSTR_JSON_DATA.strCompleteHistory.strfamilyHistory);
											
										}
									}
									
									if(strHistoryOfPresentIllNess!='' || strsurgicalHistory!='' || strpersonalHistory!='' || strtreatmentHistory!='' || strpastHistory!='' || strfamilyHistory!='')
										{
										strHistory+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
										if(strHistoryOfPresentIllNess!='')
											strHistory+=strHistoryOfPresentIllNess;
										if(strsurgicalHistory!='')
											strHistory+=strsurgicalHistory;
										if(strpersonalHistory!='')
											strHistory+=strpersonalHistory;
										if(strtreatmentHistory!='')
											strHistory+=strtreatmentHistory;
										if(strpastHistory!='')
											strHistory+=strpastHistory;
										if(strfamilyHistory!='')
											strHistory+=strfamilyHistory;
										
										}
									if($('#completeHistoryDiv').find('.accordionbtnExpended').length==0){

										var inputjsoncompleteHistoryDiv=$('#completeHistoryDiv :input').serializeArray();
										
										var flagDataFound=false;
										$.each(inputjsoncompleteHistoryDiv,function(k,vobj){
											var key=vobj["name"];
											var value=vobj["value"];
											if(value!="")
												flagDataFound=true;						
										});
										//alert("here flagDataFound>>>" + flagDataFound);
										if(flagDataFound){
											$('#completeHistoryDiv').find('.accordionbtn').trigger('click');
										}
									}	
								}
								
								if("strSystematicExamniation" in (data.pat_details[i].HRSTR_JSON_DATA))
								{
									var strcvs='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs != ''){
										strcvs+='<p><small><b>CVS</b> : ';
										strcvs+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs;
										strcvs+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#cvsId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcvs);
											
										}
									}
									var strcns='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns != ''){
										strcns+='<p><small><b>CNS</b> : ';
										strcns+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns;
										strcns+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#cnsId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strcns);
											
										}
									}
									var strrs='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs != ''){
										strrs+='<p><small><b>RS</b> : ';
										strrs+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs;
										strrs+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#rsId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strrs);
											
										}
									}
									var strpA='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA != ''){
										strpA+='<p><small><b>P/A</b> : ';
										strpA+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA;
										strpA+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#pAId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strpA);
											
										}
									}
									var strotherExamn='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn != ''){
										strotherExamn+='<p><small><b>General Examination</b> : ';
										strotherExamn+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn;
										strotherExamn+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#otherExamnId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strotherExamn);
											
										}
									}
									
									var strmuscularExamn='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn != ''){
										strmuscularExamn+='<p><small><b>Muscular Examination</b> : ';
										strmuscularExamn+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn;
										strmuscularExamn+='</small></p>';
										if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
											
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
										     $('#muscularExamnId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strmuscularExamn);
											
										}
									}
									var strLocalExamn='';
									if(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn != ''){
										strLocalExamn+='<p><small><b>Locl Examination</b> : ';
										strLocalExamn+=data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn;
										strLocalExamn+='</small></p>';
										 if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
												
											 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate){
												 $('#SystemicExamnId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.SystemicExamn);
												 $('#LocalExamnId').val(data.pat_details[i].HRSTR_JSON_DATA.strSystematicExamniation.strLocalExamn);
											 }
											
										}
									}							
									if(strcvs!='' || strcns!='' || strrs!='' || strpA!='' || strotherExamn!='' || strmuscularExamn!='' || strLocalExamn!=''){
										strExaminations+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
										if(strcvs!='')
											strExaminations+=strcvs;
										if(strcns!='')
											strExaminations+=strcns;
										if(strrs!='')
											strExaminations+=strrs;
										if(strpA!='')
											strExaminations+=strpA;
										if(strotherExamn!='')
											strExaminations+=strotherExamn;
										if(strmuscularExamn!='')
											strExaminations+=strmuscularExamn;
										if(strLocalExamn!='')
											strExaminations+=strLocalExamn;
									}
									
									
									
									var inputjsonsystematicExaminationDiv=$('#systematicExaminationDiv :input').serializeArray();
									//alert(JSON.stringify(inputjsonsystematicExaminationDiv));
									var flagDataFound=false;
									$.each(inputjsonsystematicExaminationDiv,function(k,vobj){
										var key=vobj["name"];
										var value=vobj["value"];
										if(value!="")
											flagDataFound=true;						
									});
									//alert("here flagDataFound>>>" + flagDataFound);
									if(flagDataFound){
										$('#systematicExaminationDiv').find('.accordionbtn').trigger('click');
									}
										
								}
								
								if(data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice != ''){
									//console.log('Inside Treatment Advice');
									strtreatmentAdvice123+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
									strtreatmentAdvice123+='<p><small>';
									strtreatmentAdvice123+=data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice;
									strtreatmentAdvice123+='</small></p>';
									
									if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
										
										 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate){
											 $('#treatmentAdviceId').val(data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice);
											 if($('#treatmentAdviceId').val().trim()!=""){
												 $('#treatmentMainDiv').find('.accordionbtn').trigger('click');
											 }
										 }
									}
									
								}								
								
								if(data.pat_details[i].HRSTR_JSON_DATA.strConfidentialsInfo != ''){
									//console.log('Inside conf info');
									strconfidentialInfo+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
									strconfidentialInfo+='<p><small>';
									strconfidentialInfo+=data.pat_details[i].HRSTR_JSON_DATA.strConfidentialsInfo;
									strconfidentialInfo+='</small></p>';
									//$('#treatmentAdviceId').val(data.pat_details[i].HRSTR_JSON_DATA.strtreatmentAdvice);
									if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
										
										 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
									     $('#ConfidentialInfoId').val(data.pat_details[i].HRSTR_JSON_DATA.strConfidentialsInfo);
										
									}
									
								}
								
								
								if("strReferal" in data.pat_details[i].HRSTR_JSON_DATA){
								if(data.pat_details[i].HRSTR_JSON_DATA.strReffralDepttext != '' && data.pat_details[i].HRSTR_JSON_DATA.strReferal.length){
									////console.log('Inside referral Advice');
									strClinicalProcedure+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
									strClinicalProcedure+='<p><small>';
									
									for(var r=0 ; r < data.pat_details[i].HRSTR_JSON_DATA.strReferal.length ; r++){
										//if( (data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strReffralReason) =! '' )
										if("strShowData" in data.pat_details[i].HRSTR_JSON_DATA.strReferal[r]){
										var strrefertext='';
											if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strShowData != ''){
												 strrefertext =data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strShowData ;
											 if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strReffralReason !='')
												 strrefertext = strrefertext + '( ' +data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strReffralReason +')' ;
											 if(data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strreferralType !='0')
												 strrefertext = strrefertext + '[ ' +data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strreferralTypeName +']' ;
											 }
											
											strClinicalProcedure+=strrefertext+' ,<br>';	
										
										}else
											strClinicalProcedure+=data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strReffralDepttext.trim()+'('+data.pat_details[i].HRSTR_JSON_DATA.strReferal[r].strReffralReason.trim()+') ,';
																					
									}
									
									strClinicalProcedure+='</small></p>';
									
								}
							}
								
								
								
								
								
								
								//console.log('strtreatmentAdvice123 :::::::: '+strtreatmentAdvice123);
								if("strChronicDisease" in (data.pat_details[i].HRSTR_JSON_DATA))
								{
									if(data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease.length > 0){
										strChronics+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
										strChronics+='<p><ul>';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease.length;j++){
											var CronicDiseaseName=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseName.split(';')[0];
											var CronicDiseaseDuration=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseDuration;
											var CronicDiseaseRemarks=data.pat_details[i].HRSTR_JSON_DATA.strChronicDisease[j].CronicDiseaseRemarks;

											if(CronicDiseaseDuration != '' && CronicDiseaseRemarks != '')
												strChronics+='<li>'+CronicDiseaseName+', '+CronicDiseaseDuration+' yrs, '+CronicDiseaseRemarks+'</li>';
											else if(CronicDiseaseDuration != '')
												strChronics+='<li>'+CronicDiseaseName+', '+CronicDiseaseDuration+' yrs </li>';
											else if(CronicDiseaseRemarks != '')
												strChronics+='<li>'+CronicDiseaseName+', '+CronicDiseaseRemarks+' </li>';
											else
												strChronics+='<li>'+CronicDiseaseName+' </li>';
										}
										strChronics+='</ul></p>';
									}
									
								}
								
								
								if("strDrugAllergy" in (data.pat_details[i].HRSTR_JSON_DATA))
								{
									if(data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy.length > 0){
										strAllergies+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
										strAllergies+='<p><ul>';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy.length;j++){
											var strAllergyName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergyName.split(';')[0];
											var strAllergySytmptomsName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergySytmptomsName.split(';')[0];
											var strSensivityName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strSensivityName;
											var strAllergysiteName=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergysiteName.split(';')[0];
											var stDurationTime=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].stDurationTime;
											var strAllergyRemarks=data.pat_details[i].HRSTR_JSON_DATA.strDrugAllergy[j].strAllergyRemarks;

											if(strAllergysiteName != '' && strSensivityName!='')
												strAllergies+='<li>'+strAllergyName+'('+strSensivityName+' on '+strAllergysiteName+'), '+strAllergySytmptomsName+', '+stDurationTime+' yrs, '+strAllergyRemarks+'</li>';
											else
												strAllergies+='<li>'+strAllergyName+', '+strAllergySytmptomsName+', '+stDurationTime+' yrs, '+strAllergyRemarks+'</li>';
											
										}
										strAllergies+='</ul></p>';
										
										//strAllergies+='<br>';
										if("strotherAllergies" in (data.pat_details[i].HRSTR_JSON_DATA)){
											if(data.pat_details[i].HRSTR_JSON_DATA.strotherAllergies != '')
											{
												strAllergies+='<li> OTHER ALLERGY : '+ data.pat_details[i].HRSTR_JSON_DATA.strotherAllergies+'</li>';
											}
										}
										
										
									} else if("strotherAllergies" in (data.pat_details[i].HRSTR_JSON_DATA)){
										if(data.pat_details[i].HRSTR_JSON_DATA.strotherAllergies != '')
										{
											strAllergies+='<li> OTHER ALLERGY : '+ data.pat_details[i].HRSTR_JSON_DATA.strotherAllergies+'</li>';
										}
									}	
								}
								
								if("strClinicalProcedure" in (data.pat_details[i].HRSTR_JSON_DATA))
								{
									if(data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure.length > 0){
										strClinicalProc+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</u></p>';
										strClinicalProc+='<p><ul>';
										for(var j=0;j<data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure.length;j++){
											if(data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#").length == 7)
											{
											var strClinicalProcedureName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[0];
											var strClinicalProcedureSite=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[3];
											var strClinicalProcedureRemarks=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[4];
											var strServiceAreaName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[6];
											
											if(strClinicalProcedureSite.trim() != 'Side' && strClinicalProcedureRemarks!='')
												strClinicalProc+='<li>'+strServiceAreaName +' [ '+strClinicalProcedureName+']'+', '+strClinicalProcedureSite+', '+strClinicalProcedureRemarks+'</li>';
											else if(strClinicalProcedureSite.trim() != 'Side')
												strClinicalProc+='<li>'+strServiceAreaName +' [ '+strClinicalProcedureName+']'+', '+strClinicalProcedureSite+'</li>';
											else if(strClinicalProcedureRemarks != '')
												strClinicalProc+='<li>'+strServiceAreaName +' [ '+strClinicalProcedureName+']'+', '+strClinicalProcedureRemarks+'</li>';
											else
												strClinicalProc+='<li>'+strServiceAreaName +' [ '+strClinicalProcedureName+']'+'</li>';
											
											}else{
												
												
												var strClinicalProcedureName=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[0];
												var strClinicalProcedureSite=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[3];
												var strClinicalProcedureRemarks=data.pat_details[i].HRSTR_JSON_DATA.strClinicalProcedure[j].split("#")[4];
												
												
												if(strClinicalProcedureSite.trim() != 'Side' && strClinicalProcedureRemarks!='')
													strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureSite+', '+strClinicalProcedureRemarks+'</li>';
												else if(strClinicalProcedureSite.trim() != 'Side')
													strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureSite+'</li>';
												else if(strClinicalProcedureRemarks != '')
													strClinicalProc+='<li>'+strClinicalProcedureName+', '+strClinicalProcedureRemarks+'</li>';
												else
													strClinicalProc+='<li>'+strClinicalProcedureName+'</li>';
											}
										}
										strClinicalProc+='</ul></p>';
									}
									
									
								}
								
								if(data.pat_details[i].HRSTR_JSON_DATA.externalProcedureReferalDtl.length > 0){
									
									strClinicalProc+='<p><u>'+maxDate+' ('+data.pat_details[i].HRSTR_JSON_DATA.patDept.trim()+')</p></u>';
									strClinicalProc+='<p><ol class="procedure">';
									$.each(data.pat_details[i].HRSTR_JSON_DATA.externalProcedureReferalDtl, function(indx, procjson){
										
										strClinicalProc+='<li>Procedure name : '+procjson["strReffralExtName"]+' , Referral Note : '+procjson["refferalExtReson"]+' ,No. of Procedure : ' +procjson["noAllowed"]+' , Valid Upto : '+procjson["validUpto"]+'</li>';
									});
									strClinicalProc+='</ol></p>';
								}
								
							}
							
							
							
							var date = new Date();
							document.title=window.patCrNo+date.getDate()+(date.getMonth()+1)+date.getFullYear();
							//console.log('Date:::::::::>>>>>>>'+date.getDate()+(date.getMonth()+1)+date.getFullYear());
							var fileName='';
							var fileName1='';
							if(Object.keys(data.Template).length > 0){	
								//for(var k=0;k<Object.keys(data.Template).length;k++){
							//	var dt=data.Template[k].GDT_ENTRY_DATE ;
								for(var j=0;j<Object.keys(data.Template).length;j++){
									
									/*if(data.Template[k].GDT_ENTRY_DATE != data.Template[j].GDT_ENTRY_DATE)
									{
										fileName+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
									}*/
									if(data.Template[j].TEMPLATE_TYPE == '2'){
										fileName1+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
										//fileName+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
										//console.log('data.Template[j].FILE_NAME'+data.Template[j].FILE_NAME);
										//fileName +='<li value='+data.Template[j].FILE_NAME+'><a href="#" value='+data.Template[j].FILE_NAME+' onclick="getpdffile(this)">' + data.Template[j].FILE_NAME +'</a></li>'
										fileName1 +='<li>  <button type="button" class="btn btn-link"  value='+data.Template[j].FILE_NAME+'#'+data.Template[j].GNUM_HOSPITAL_CODE+' onclick="getpdffile(this)">'+data.Template[j].TEMPLATE_NAME+'</button></li> '
									//	fileName +='<li> '+data.Template[j].TEMPLATE_NAME+' <a     onclick="getpdffile('+data.Template[j].FILE_NAME+'#'+data.Template[j].GNUM_HOSPITAL_CODE+',this)" href="#">Get Pdf</a></li> '
										
									}else{
										fileName+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
										//fileName+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
										//console.log('data.Template[j].FILE_NAME'+data.Template[j].FILE_NAME);
										//fileName +='<li value='+data.Template[j].FILE_NAME+'><a href="#" value='+data.Template[j].FILE_NAME+' onclick="getpdffile(this)">' + data.Template[j].FILE_NAME +'</a></li>'
										fileName +='<li>  <button type="button" class="btn btn-link"  value='+data.Template[j].FILE_NAME+'#'+data.Template[j].GNUM_HOSPITAL_CODE+' onclick="getpdffile(this)">'+data.Template[j].TEMPLATE_NAME+'</button></li> '
									//	fileName +='<li> '+data.Template[j].TEMPLATE_NAME+' <a     onclick="getpdffile('+data.Template[j].FILE_NAME+'#'+data.Template[j].GNUM_HOSPITAL_CODE+',this)" href="#">Get Pdf</a></li> '
									}
								}
								//}
							}
							
							
							var strPatientDocumentUpload='';
							if(Object.keys(data.PaptientDoc).length > 0){	
								//for(var k=0;k<Object.keys(data.Template).length;k++){
							//	var dt=data.Template[k].GDT_ENTRY_DATE ;
								for(var j=0;j<Object.keys(data.PaptientDoc).length;j++){
									
								
									strPatientDocumentUpload+='<p><u>'+data.PaptientDoc[j].GDT_ENTRY_DATE+' ('+data.PaptientDoc[j].HRGSTR_FILE_NAME.trim()+')</u></p>';
										//fileName+='<p><u>'+data.Template[j].GDT_ENTRY_DATE+' ('+data.Template[j].DEPT_UNIT_NAME.trim()+')</u></p>';
										//console.log('data.Template[j].FILE_NAME'+data.PaptientDoc[j].HRGSTR_FILE_NAME);
										//fileName +='<li value='+data.Template[j].FILE_NAME+'><a href="#" value='+data.Template[j].FILE_NAME+' onclick="getpdffile(this)">' + data.Template[j].FILE_NAME +'</a></li>'
										strPatientDocumentUpload +='<li>  <button type="button" class="btn btn-link"  value='+data.PaptientDoc[j].HRGNUM_PUK+'#'+data.PaptientDoc[j].HRGSTR_FILE_NAME+' onclick="getpdffile1(this)">'+data.PaptientDoc[j].HRGSTR_FILE_NAME+'</button></li> '
									//	fileName +='<li> '+data.Template[j].TEMPLATE_NAME+' <a     onclick="getpdffile('+data.Template[j].FILE_NAME+'#'+data.Template[j].GNUM_HOSPITAL_CODE+',this)" href="#">Get Pdf</a></li> '
										
									
								}
								//}
							}
							
							
							var profileNav = '<li><a href="#TreeStructurePrescriptionModalTab2" data-toggle="tab" style="background-color:#6e93a6;"><i class="far fa-address-card"></i> Profile</a></li>';
							if(strProfileInfo!='')
								profileNav ='<li><a href="#TreeStructurePrescriptionModalTab2" data-toggle="tab"><i class="far fa-address-card"></i> Profile</a></li>';
							var cghsLegacyNav = '<li style="display: none;"><a href="#TreeStructurePrescriptionModalTab21" data-toggle="tab" style="background-color:#6e93a6;" onclick="cghsLegacyData()"><i class="far fa-address-card"></i> Cghs Legacy</a></li>';
							if(strProfileInfo!='')
								cghsLegacyNav ='<li style="display: none;"><a href="#TreeStructurePrescriptionModalTab21" data-toggle="tab" onclick="cghsLegacyData()"><i class="far fa-summary"></i> Cghs Legacy</a></li>';
							var chiefComNav = '<li><a href="#TreeStructurePrescriptionModalTab4" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-user-md"></i> Chief Complaint</a></li>';
							if(strChiefComplaint!='')
								chiefComNav = '<li><a href="#TreeStructurePrescriptionModalTab4" data-toggle="tab"><i class="fas fa-user-md"></i> Chief Complaint</a></li>';
							var diagNav ='<li><a href="#TreeStructurePrescriptionModalTab5" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-diagnoses"></i> Diagnosis</a></li>';
							if(strDiagnosis!='')
								diagNav ='<li><a href="#TreeStructurePrescriptionModalTab5" data-toggle="tab"><i class="fas fa-diagnoses"></i> Diagnosis</a></li>';
							var investigationNav = '<li><a href="#TreeStructurePrescriptionModalTab6" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-microscope"></i> Investigations</a></li>';
							if(strInvestigations!='')
								investigationNav = '<li><a href="#TreeStructurePrescriptionModalTab6" data-toggle="tab"><i class="fas fa-microscope"></i> Investigations</a></li>';
							var drugNav = '<li><a href="#TreeStructurePrescriptionModalTab7" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-pills"></i> Drug/Advices</a></li>';
							if(strDrugsAndAdvices!='')
								drugNav = '<li><a href="#TreeStructurePrescriptionModalTab7" data-toggle="tab"><i class="fas fa-pills"></i> Drug/Advices</a></li>';
							var historyNav = '<li><a href="#TreeStructurePrescriptionModalTab9" data-toggle="tab" aria-expanded="false" style="background-color:#6e93a6;"><i class="fas fa-pen-square"></i> History</a></li>';
							if(strHistory!='')
								historyNav = '<li><a href="#TreeStructurePrescriptionModalTab9" data-toggle="tab" aria-expanded="false"><i class="fas fa-pen-square"></i> History</a></li>';
							var exmNav = '<li><a href="#TreeStructurePrescriptionModalTab10" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-stethoscope"></i> Examinations</a></li>';
							if(strExaminations!='')
								exmNav = '<li><a href="#TreeStructurePrescriptionModalTab10" data-toggle="tab"><i class="fas fa-stethoscope"></i> Examinations</a></li>';
							var allergyNav = '<li><a href="#TreeStructurePrescriptionModalTab11" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-allergies"></i> Allergies</a></li>';
							if(strAllergies!='')
								allergyNav = '<li><a href="#TreeStructurePrescriptionModalTab11" data-toggle="tab"><i class="fas fa-allergies"></i> Allergies</a></li>';
							var chronicNav = '<li><a href="#TreeStructurePrescriptionModalTab12" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-x-ray"></i> Chronic Diseases</a></li>';
							if(strChronics!='')
								chronicNav = '<li><a href="#TreeStructurePrescriptionModalTab12" data-toggle="tab"><i class="fas fa-x-ray"></i> Chronic Diseases</a></li>';
							var clinicalProNav = '<li><a href="#TreeStructurePrescriptionModalTab13" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-procedures"></i> Clinical Procedures</a></li>';
							if(strClinicalProc!='')
								clinicalProNav = '<li><a href="#TreeStructurePrescriptionModalTab13" data-toggle="tab"><i class="fas fa-procedures"></i> Clinical Procedures</a></li>';
							var treatAdvNav = '<li><a href="#TreeStructurePrescriptionModalTab15" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-prescription"></i> Treatment Advices</a></li>';
							if(strtreatmentAdvice123!='')
								treatAdvNav = '<li><a href="#TreeStructurePrescriptionModalTab15" data-toggle="tab"><i class="fas fa-prescription"></i> Treatment Advices</a></li>';
							var referalNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab16" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-ambulance"></i> Patient Ref.</a></li>';
							if(strClinicalProcedure!='')
								referalNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab16" data-toggle="tab"><i class="fas fa-ambulance"></i> Patient Ref.</a></li>';
							var confNav = '<li style="display:none;"><a  href="#TreeStructurePrescriptionModalTab17" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-ambulance"></i>Confidential info.</a></li>';
							if(strconfidentialInfo!='')
								confNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab17" data-toggle="tab"><i class="fas fa-ambulance"></i>Confidential info.</a></li>';
							var tempInfoNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab18" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-user-shield"></i> Template Info.</a></li>';
							if(fileName!='')
								tempInfoNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab18" data-toggle="tab"><i class="fas fa-user-shield"></i> Template Info.</a></li>';
							var procAdmNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab19" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-user-shield"></i>Procedure Administration</a></li>';
							if(fileName1!='')
								procAdmNav = '<li style="display:none;"><a href="#TreeStructurePrescriptionModalTab19" data-toggle="tab"><i class="fas fa-user-shield"></i>Procedure Administration</a></li>';
							var docUploadNav = '<li><a href="#TreeStructurePrescriptionModalTab20" data-toggle="tab" style="background-color:#6e93a6;"><i class="fas fa-user-shield"></i>Patient Document</a></li>';
							if(strPatientDocumentUpload!='')
								docUploadNav = '<li><a href="#TreeStructurePrescriptionModalTab20" data-toggle="tab"><i class="fas fa-user-shield"></i>Patient Document</a></li>';
							
							$('.TreeStructurePrescriptionModalNavMenu').children('li').eq(0).addClass('active');
							$('.TreeStructurePrescriptionModalNavMenuContent').children('div').eq(0).addClass('active');
							
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab2').append(strProfileInfo);
							if(strChiefComplaint=='')
								strChiefComplaint+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab4').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab4').append(strChiefComplaint);
							if(strDiagnosis=='')
								strDiagnosis+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab5').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab5').append(strDiagnosis);
							if(strInvestigations=='')
								strInvestigations+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab6').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab6').append(strInvestigations);
							if(strDrugsAndAdvices=='')
								strDrugsAndAdvices+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab7 #drugDiv').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab7 #drugDiv').append(strDrugsAndAdvices);
							if(strClinicalNote=='')
								strClinicalNote+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab8').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab8').append(strClinicalNote);
							if(strHistory=='')
								strHistory+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab9').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab9').append(strHistory);
							if(strExaminations=='')
								strExaminations+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab10').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab10').append(strExaminations);
							if(strAllergies=='')
								strAllergies+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab11').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab11').append(strAllergies);
							if(strChronics=='')
								strChronics+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab12').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab12').append(strChronics);
							if(strClinicalProc=='')
								strClinicalProc+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab13').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab13').append(strClinicalProc);
							if(strtreatmentAdvice123=='')
								strtreatmentAdvice123+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab15').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab15').append(strtreatmentAdvice123);
							if(strClinicalProcedure=='')
								strClinicalProcedure+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab16').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab16').append(strClinicalProcedure);
							if(strconfidentialInfo=='')
								strconfidentialInfo+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab17').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab17').append(strconfidentialInfo);
							if(fileName=='')
								fileName+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab18').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab18').append(fileName);
							if(fileName1=='')
								fileName1+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab19').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab19').append(fileName1);
							if(strPatientDocumentUpload=='')
								strPatientDocumentUpload+="<p><b>No Record Found<b></p>";
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab20').append(str);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab20').append(strPatientDocumentUpload);
							
							var strmodalNavContent =profileNav+
			                '<li><a href="#TreeStructurePrescriptionModalTab3" data-toggle="tab"><i class="fa fa-heartbeat" aria-hidden="true"></i> Vitals / GE</a></li>'+
			                cghsLegacyNav+
			                historyNav+
			                exmNav+
			                allergyNav+
			                chronicNav+
			                chiefComNav+
			                diagNav+
			                investigationNav+
			                clinicalProNav+
			                treatAdvNav+
			                drugNav+
			                referalNav+
			                confNav+
			                tempInfoNav+
			                procAdmNav+
			                docUploadNav;
		
							$('.TreeStructurePrescriptionModalNavMenu').append(strmodalNavContent);
							
						}
						else{
							$('#TreeStructurePrescriptionListMsg').text('No Details Found !');	
						}
					},
	  				complete: $('#TreeStructurePrescriptionListMsg').text('Error !!!')
			});
	      if(window.patCrNo==""){
			  return;
		  }
	      $.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatDataForPastPrescription?Modval=2&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
				async:true,
				//beforesend : $('.TreeStructurePrescriptionModalErrMsg').parent().append('<p id="TreeStructurePrescriptionListMsg"><i class="fa fa-spinner fa-spin"></i> Loading</p>'),
					success:function(data){
						
						//alert(Object.keys(data).length);
						//alert(Object.keys(data.pat_details));
						if(Object.keys(data.pat_details).length > 0){
							
							for(var i=0;i<Object.keys(data.pat_details).length;i++){  
							
								
								//alert(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.strpallor);
								////console.log("strEpisodeCodeChk "+strEpisodeCodeChk);
								////console.log("data.pat_details[i].HRSTR_JSON_DATA.episodeCode "+data.pat_details[i].HRSTR_JSON_DATA.episodeCode);
								////console.log("ashu todaysys "+todaysys);
								////console.log("ashu data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate "+data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate);
								////console.log(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate);
								
								if(strEpisodeCodeChk == data.pat_details[i].HRSTR_JSON_DATA.episodeCode){
									
									 if(todaysys == data.pat_details[i].HRSTR_JSON_DATA.currentVisitDate)
								     {
										 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.strpallor == 1)
											 $("#pallorId").prop("checked", true)
											 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.stricterus == 1)
											 $("#icterusId").prop("checked", true)
											 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.strcyanosis == 1)
											 $("#cyanosisId").prop("checked", true)
											 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.strclubbing == 1)
											 $("#clubbingId").prop("checked", true)
											 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.striymphadenopathyId == 1)
											 $("#iymphadenopathyId").prop("checked", true)	 
											 
										if(data.pat_details[i].HRSTR_JSON_DATA.strpiccle.stredema == 1)
											$("#edemaID").prop("checked", true)
								     }
									
								}	
								
									 
								
							}
							
						}
					}
	      });
	      
		      
	      var colorArray = ['36a2eb','ff6384','4bc0c0','ffcd56','9966ff','ff9f40','ffcf9f','ffe6aa','a5dfdf','9ad0f5','a0cece','c9cbcf','8afdfd','f67019','4dc9f6'];
	      
	      $.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatientEHRDtlsForInvDrug?Modval=13&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
				async:true,
					success:function(data){ 
						var strInvDrug = '';
						//$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab7').append("<div><p><small><b>Other Drugs</b> : ");
						if(Object.keys(data.pat_details).length > 0){
							strInvDrug+='<p><ol class="printPrescTreatmentLst">';
							for(var i=0;i<Object.keys(data.pat_details).length;i++){
								strInvDrug+='<li>'+data.pat_details[i].ITM+', Qty : '+data.pat_details[i].ISSUE_QTY+', Date : '+data.pat_details[i].ISSUE_DATE +'</li>';
							}
							strInvDrug+='</ol></p>';
							////console.log("strInvDrug==>"+strInvDrug);
							$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab7').append("<br><div><p><small><b>Issued Drugs</b></small> :</p>"+strInvDrug+"</div>");
						}
					}
	      });
	      
		      $.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatVitalDataForDetailedPrescription?Modval=3&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
					async:true,
					//beforesend : $('.TreeStructurePrescriptionModalErrMsg').parent().append('<p id="TreeStructurePrescriptionVitalsListMsg"><i class="fa fa-spinner fa-spin"></i> Loading</p>'),
						success:function(data){ 
							var strVitalsChart = '';
							
							var strWeight='', strHeight='', strBmid='', strTemperature='', strrespRate='', strhaemoglobin='', strBloodPressure='',strBloodPressure1='', strfasting='', strRateId='', strhba1c='', strSymptoms='';
							var strPulseRateArr=[] , strCircumferenceArr=[], strMuac ='';
							var strPulseRate='' ,  strBloodGroup ='',  strBloodGroup ='' ,strCancerScreening = '', strCircumference='', strMuac ='';
							var strBMIArr=[] , strTemperatureArr=[] , strRespRateArr=[] , strHaemoglobinArr=[] , strBloodPressureArr=[] , strBloodPressureArr1=[] , strFastingArr=[] , strRateIdArr=[] , strHba1cArr=[] ;
							var strBloodGroupArr =[] ,strCancerScreeningArr=[],strcurcumferenceArr=[] ,strmuacArr=[] ;
							var strBloodGroup='' ,strcurcumference ='',strmuac='' ;
							/*----------------------added for cancer screening---------------*/
							var strCancerScreening ='';
							var strDateArr=[] ;
							var strHeightArr=[] , strWeightArr=[], strSymptomsArr=[] ;
							var strDisabilityArr=[] ,strSmokingArr=[] , strAnemicArr=[] , strPregnancyArr=[] ; 
							var strDisability='' ,strSmoking='' , strAnemic='' , strPregnancy='' ; 
							var menuId = 'TreeStructureVitalsDetails';
							
							var profileInfoString = '';
							if(window.patCrNo==""){
								  return;
							  }
							////////////////////////////////////////////////////
							$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatDataForPastPrescription?Modval=2&CrNo='+window.patCrNo+'&episodeCode='+window.episodeCode +'&visitNo='+window.visitNo+'&seatId=&Entrydate=&hosp_code='+window.hospCode+'',
								async:false,
								success:function(result){ 

											if(Object.keys(result.pat_details).length > 0){
											
												var months = new Array(12);
											 	months[1] = "Jan";
											 	months[2] = "Feb";
											 	months[3] = "Mar";
											 	months[4] = "Apr";
											 	months[5] = "May";
											 	months[6] = "Jun";
											 	months[7] = "Jul";
											 	months[8] = "Aug";
											 	months[9] = "Sep";
											 	months[10] = "Oct";
											 	months[11] = "Nov";
											 	months[12] = "Dec";

											 	var today = new Date();
												var printDate = today.getDate()+'-'+months[today.getMonth()+1]+'-'+today.getFullYear();
												var printTime = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
												
												profileInfoString+='<div class="row"><h4 class="text-center" style="font-weight:bold">PATIENT CLINICAL DATA</h4>'+
												'</div>'+  
												'<div class="" style="border-top: 1px solid grey; border-bottom: 1px solid grey;">'+
												'<table class="table table-condensed printPrescPatDtlTbl table-responsive">'+
												'<tbody>'+
												'<tr>'+
												'<th>Name</th><td class="patName">';
												profileInfoString+=result.pat_details[0].HRSTR_JSON_DATA.pat_Name.trim();
												profileInfoString+='</td><th>BEN ID.</th><td class="patCrNo">';
												profileInfoString+=result.pat_details[0].HRSTR_JSON_DATA.CR_No.trim();
												profileInfoString+='</td></tr>';
												profileInfoString+='<tr>'+
												'<th>Department(Unit/Consultant)</th><td class="patDeptU">';
												profileInfoString+=result.pat_details[0].HRSTR_JSON_DATA.patDept.trim();
												profileInfoString+='</td><th>Reprinted On</th><td class="printedOn">';
												profileInfoString+=printDate+' / '+printTime;
												profileInfoString+='</td></tr>';
												
												profileInfoString+='<tr>'+
												'<th>Mobile No</th><td class="patDeptU">';
												profileInfoString+=(result.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[14].trim();
												if($('#strRailTailFlgId').val() == '0'){
												profileInfoString+='</td><th>Occupation</th><td class="printedOn">';
												profileInfoString+=(result.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17].trim();
												profileInfoString+='</td></tr>';
												}else{
													var patOthersDetails1=$('#patOthersDetailsPrescriptionPanel').html();
													if(patOthersDetails1 !='{}'){
													profileInfoString+='</td><th>Designation</th><td class="printedOn">';
													profileInfoString+=(JSON.parse(patOthersDetails1).designation);
													profileInfoString+='</td></tr>';
													
													profileInfoString+='<tr>'+
													'<th>Station</th><td class="patDeptU">';
													profileInfoString+=(JSON.parse(patOthersDetails1).custom_unit);
													profileInfoString+='</td><th></th><td></td></tr>';
													
													}else{
														profileInfoString+='</td><th>Occupation</th><td class="printedOn">';
														profileInfoString+=(result.pat_details[0].HRSTR_JSON_DATA.PatCompleteGeneralDtl.trim()).split('#')[17].trim();
														profileInfoString+='</td></tr>';
														
													}
												}
												profileInfoString+='</tbody></table></div>';
											}
									}
							});
							
							///////////////////////////////////////////////////
							//alert(Object.keys(data).length);
							//alert(Object.keys(data.pat_vital_details).length);
							if(Object.keys(data.pat_vital_details).length > 0){
								//$('#TreeStructurePrescriptionVitalsListMsg').remove();
								
								strVitalsChart+='<div class="table-responsive"><table class="table table-hover table-striped table-condensed" id="VitalDataTreeRow">';
							 	strVitalsChart+='<thead><tr style="color:#6d6db7"><th>Parameter/Date</th>';	
							 	
								for(var i=0;i<Object.keys(data.pat_vital_details).length;i++){   
									
									////console.log(i+" ** "+data.pat_vital_details[i].TO_CHAR);
									strDateArr[i]=data.pat_vital_details[i].TO_CHAR;
									//console.log("date array -->> "+i+" -->> "+strDateArr[i]);
								 	////console.log(i+" ** "+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strfasting);
									//console.log(i+" ashutoshk "+ JSON.stringify(data.pat_vital_details[i].HOPLSTR_JSON_DATA));
								 	
								 	if(i<7){
								 		strVitalsChart+='<th>'+data.pat_vital_details[i].TO_CHAR+'</th>';
				      					
								 		
								 		if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsymptoms != ''){
								 			strSymptoms+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsymptoms+'</td>';
								 			strSymptomsArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsymptoms;
				      					}
				      					else{
				      						strSymptoms+='<td style="color:green">--</td>';
				      					}
								 		
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strWeight != ''){
				      						strWeight+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strWeight+'</td>';
				      						strWeightArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strWeight;
				      					}
				      					else{
				      						strWeight+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strHeight != ''){
				      						strHeight+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strHeight+'</td>';
				      						strHeightArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strHeight;
				      					}
				      					else{
				      						strHeight+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strBmid != ''){
				      						strBmid+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strBmid+'</td>';
				      						strBMIArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strBmid;
				      						//console.log("BMI array -->> "+i+" -->> "+strBMIArr[i]);
				      					}
				      					else{
				      						strBmid+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strTempreature != ''){
				      						strTemperature+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strTempreature+'</td>';
				      						strTemperatureArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strTempreature
				      					}
				      					else{
				      						strTemperature+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strrespRate != ''){
				      						strrespRate+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strrespRate+'</td>';
				      						strRespRateArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strrespRate;
				      					}
				      					else{
				      						strrespRate+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhaemoglobin != ''){
				      						strhaemoglobin+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhaemoglobin+'</td>';
				      						strHaemoglobinArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhaemoglobin;
				      					}
				      					else{
				      						strhaemoglobin+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic != ''){
				      						strBloodPressure+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic+'/'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic+'</td>';
				      						strBloodPressureArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic+'/'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic;
				      					}
				      					else{
				      						strBloodPressure+='<td style="color:green">--</td>';
				      					}
				      					
				      					if( ( "strsystolic1" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA))  && ( "strdiastolic1" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA))  ){
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic1 != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic1 != ''){
				      						strBloodPressure1+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic1+'/'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic1+'</td>';
				      						strBloodPressureArr1[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strsystolic1+'/'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strdiastolic1;
				      					}
				      					else{
				      						strBloodPressure1+='<td style="color:green">--</td>';
				      					}
				      					}else{
				      						strBloodPressure1+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strfasting != ''){
				      						strfasting+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strfasting+'</td>';
				      						strFastingArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strfasting;
				      					}
				      					else{
				      						strfasting+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strRateId != ''){
				      						strRateId+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strRateId+'</td>';
				      						strRateIdArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strRateId;
				      					}
				      					else{
				      						strRateId+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhba1c != ''){
				      						strhba1c+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhba1c+'</td>';
				      						strHba1cArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strhba1c;
				      					}
				      					else{
				      						strhba1c+='<td style="color:green">--</td>';
				      					}
				      					
				      					
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strbloodGroup != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strbloodGroup != '0'){
				      						strBloodGroup+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strbloodGroup+'</td>';
				      						strBloodGroupArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strbloodGroup;
				      					}
				      					else{
				      						strBloodGroup+='<td style="color:green">--</td>';
				      					}
				      					
				      					/*--------------Added for cancer screening-----------------*/
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcancerScreening != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcancerScreening != '0'){
				      						strCancerScreening+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcancerScreening+'</td>';
				      						strCancerScreeningArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcancerScreening;
				      					}
				      					else{
				      						strCancerScreening+='<td style="color:green">--</td>';
				      					}
				      					
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcurcumference != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcurcumference != '0'){
				      						strcurcumference+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcurcumference+'</td>';
				      						strcurcumferenceArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strcurcumference;
				      					}
				      					else{
				      						strcurcumference+='<td style="color:green">--</td>';
				      					}
				      					
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strmuac != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strmuac != '0'){
				      						strmuac+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strmuac+'</td>';
				      						strmuacArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strmuac;
				      					}
				      					else{
				      						strmuac+='<td style="color:green">--</td>';
				      					}
				      					
				      					/**/
				      					if("strDisability" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA)){
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strDisability != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strDisability != '0'){
				      						strDisability+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strDisability+'</td>';
				      						strDisabilityArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strDisability;
				      					}
				      					else{
				      						strDisability+='<td style="color:green">--</td>';
				      					}
				      				}else{
			      						strDisability+='<td style="color:green">--</td>';
			      					}
				      					if("strSmoking" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA)){
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strSmoking != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strSmoking != '0'){
				      						strSmoking+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strSmoking+'</td>';
				      						strSmokingArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strSmoking;
				      					}
				      					else{
				      						strSmoking+='<td style="color:green">--</td>';
				      					}
				      				}else{
			      						strSmoking+='<td style="color:green">--</td>';
			      					}
				      					if("strAnemic" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA)){
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strAnemic != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strAnemic != '0'){
				      						strAnemic+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strAnemic+'</td>';
				      						strAnemicArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strAnemic;
				      					}
				      					else{
				      						strAnemic+='<td style="color:green">--</td>';
				      					}
				      				}else{
			      						strAnemic+='<td style="color:green">--</td>';
			      					}
				      					if("strPregnancy" in (data.pat_vital_details[i].HOPLSTR_JSON_DATA)){
				      					if(data.pat_vital_details[i].HOPLSTR_JSON_DATA.strPregnancy != '' && data.pat_vital_details[i].HOPLSTR_JSON_DATA.strPregnancy != '0'){
				      						strPregnancy+='<td>'+data.pat_vital_details[i].HOPLSTR_JSON_DATA.strPregnancy+'</td>';
				      						strPregnancyArr[i]=data.pat_vital_details[i].HOPLSTR_JSON_DATA.strPregnancy;
				      					}
				      					else{
				      						strPregnancy+='<td style="color:green">--</td>';
				      					}
				      				}else{
			      						strPregnancy+='<td style="color:green">--</td>';
			      					}
				      					
								 	}
			      					

								}
								
								strVitalsChart+='</tr></thead>'; 
		      					strVitalsChart+='<tbody>';
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Weight(kgs)</td>';
		      					strVitalsChart+=strWeight;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Height(cms)</td>';
		      					strVitalsChart+=strHeight;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">BMI(kg/m<sup>2</sup>)</td>';
		      					strVitalsChart+=strBmid;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Temperature(F)</td>';
		      					strVitalsChart+=strTemperature;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Respiration  Rate(braths/min)</td>';
		      					strVitalsChart+=strrespRate;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Haemoglobin(gm/dL)</td>';
		      					strVitalsChart+=strhaemoglobin;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Blood Pressure(mm/Hg)</td>';
		      					strVitalsChart+=strBloodPressure;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Blood Pressure(mm/Hg)</td>';
		      					strVitalsChart+=strBloodPressure1;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Blood Sugar (Fasting)(mg/dL)</td>';
		      					strVitalsChart+=strfasting;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">HBA1C(%)</td>';
		      					strVitalsChart+=strhba1c;
		      					
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Pulse Rate (beats/min)</td>';
		      					strVitalsChart+=strRateId;
		      					strVitalsChart+='</tr>';
		      					
		      					/*----------------added for Cancer Screnning-------------*/
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Cancer Screening</td>';
		      					strVitalsChart+=strCancerScreening;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Blood Group</td>';
		      					strVitalsChart+=strBloodGroup;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Head Circumference (cms)</td>';
		      					strVitalsChart+=strcurcumference;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Disability</td>';
		      					strVitalsChart+=strDisability;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Smoking</td>';
		      					strVitalsChart+=strSmoking;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Anemic</td>';
		      					strVitalsChart+=strAnemic;
		      					strVitalsChart+='</tr>';
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Pregnancy</td>';
		      					strVitalsChart+=strPregnancy;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">MUAC(cms)</td>';
		      					strVitalsChart+=strmuac;
		      					strVitalsChart+='</tr>';
		      					
		      					
		      					strVitalsChart+='<tr><td style="font-weight:bold;">Remarks</td>';
		      					strVitalsChart+=strSymptoms;
		      					strVitalsChart+='<td class="text-right"><button id="parameterVitalsTrendBtn" class="btn btn-sm btn-info testTrendsBtn" type="button">Trends</button></td>';
		      					strVitalsChart+='</tr>';
		      					
		      					/*strVitalsChart+='<tr><td style="font-weight:bold;">Blood Sugar (PP)</td>';
		      					strVitalsChart+=strRateId;
		      					strVitalsChart+='</tr>';*/
		      					
		      					
		      					
		      					strVitalsChart+='</tbody></table></div>';
		      					
		      					strVitalsChart+='<h5 class="text-left cumulativeTestChartHeadingForVitalsTreePresc"  style="display:none;"></h5>';
		      					strVitalsChart+='<div class="col-sm-12" style="position: relative;"><canvas id="'+menuId+'_chart"></canvas></div>';
		      					
		      					var date = new Date();
								document.title=window.patCrNo+date.getDate()+(date.getMonth()+1)+date.getFullYear();
								//console.log('Date:::::::::>>>>>>>'+date.getDate()+(date.getMonth()+1)+date.getFullYear());
								//console.log('time ::>>>>>>>>>>>>>>'+date.getHours()+':'+date.getMinutes()+':'+date.getSeconds());
								 
		      					$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append(profileInfoString);
		      					$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append("<br>");
								$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append(strVitalsChart);
								
							}
							else{
								$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append(profileInfoString);
		      					$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append("<br>");
		      					$('.TreeStructurePrescriptionModalNavMenuContent #TreeStructurePrescriptionModalTab3').append(strVitalsChart);
								//$('#TreeStructurePrescriptionVitalsListMsg').text('No Record Found !');	
							}
							
							window.chartColors = {
									red: 'rgb(255, 99, 132)',
									orange: 'rgb(255, 159, 64)',
									yellow: 'rgb(255, 205, 86)',
									green: 'rgb(75, 192, 192)',
									blue: 'rgb(54, 162, 235)',
									purple: 'rgb(153, 102, 255)',
									grey: 'rgb(201, 203, 207)',
									olive: 'rgb(115, 153, 0)'
								};

							for(var k=0; k<strDateArr.length;k++){
								var config = {
										type: 'line',
										data: {
											labels: strDateArr,
											datasets: [{
												label: 'Weight',
												backgroundColor: window.chartColors.red,
												borderColor: window.chartColors.red,
												data: strWeightArr,
												fill: false,
											},{
												label: 'Height',
												backgroundColor: window.chartColors.red,
												borderColor: window.chartColors.red,
												data: strHeightArr,
												fill: false,
											}, {
												label: 'BMI',
												backgroundColor: window.chartColors.red,
												borderColor: window.chartColors.red,
												data: strBMIArr,
												fill: false,
											}, {
												label: 'Temperature',
												fill: false,
												backgroundColor: window.chartColors.blue,
												borderColor: window.chartColors.blue,
												data: strTemperatureArr,
												fill: false,
											},
											{
												label: 'Respiration rate',
												fill: false,
												backgroundColor: window.chartColors.yellow,
												borderColor: window.chartColors.yellow,
												data: strRespRateArr,
												fill: false,
											},
											{
												label: 'Haemoglobin',
												fill: false,
												backgroundColor: window.chartColors.green,
												borderColor: window.chartColors.green,
												data: strHaemoglobinArr,
												fill: false,
											},
											/*{
												label: 'Blood Pressure',
												fill: false,
												backgroundColor: window.chartColors.orange,
												borderColor: window.chartColors.orange,
												data: strBloodPressureArr,
												fill: false,
											},*/
											{
												label: 'Blood Sugar Fasting',
												fill: false,
												backgroundColor: window.chartColors.grey,
												borderColor: window.chartColors.grey,
												data: strFastingArr,
												fill: false,
											},
											{
												label: 'Blood Sugar PP',
												fill: false,
												backgroundColor: window.chartColors.purple,
												borderColor: window.chartColors.purple,
												data: strRateIdArr,
												fill: false,
											},
											{
												label: 'HBA1C',
												fill: false,
												backgroundColor: window.chartColors.olive,
												borderColor: window.chartColors.olive,
												data: strHba1cArr,
												fill: false,
											}
											,
											{ 
												label: 'Blood Group',
												fill: false,
												backgroundColor: window.chartColors.olive,
												borderColor: window.chartColors.olive,
												data: strBloodGroupArr,
												fill: false,
											},
											{  /*----------------------added for cancer screening---------------*/
												label: 'Cancer Screening',
												fill: false,
												backgroundColor: window.chartColors.olive,
												borderColor: window.chartColors.olive,
												data: strCancerScreeningArr,
												fill: false,
											},
											{
												label: 'Head Circumference',
												fill: false,
												backgroundColor: window.chartColors.pink,
												borderColor: window.chartColors.pink,
												data: strcurcumferenceArr,
												fill: false,
											},
											{
												label: 'MUAC',
												fill: false,
												backgroundColor: window.chartColors.blue,
												borderColor: window.chartColors.blue,
												data: strmuacArr,
												fill: false,
											}
											
											]
										},
										options: {
											responsive: true,
											title: {
												display: true,
												text: 'Vitals Chart'
											},
											tooltips: {
												mode: 'index',
												intersect: false,
											},
											hover: {
												mode: 'nearest',
												intersect: true
											},
											scales: {
												xAxes: [{
													display: true,
													scaleLabel: {
														display: true,
														labelString: 'Date'
													}
												}],
												yAxes: [{
													display: true,
													scaleLabel: {
														display: true,
														labelString: 'Values'
													},
													ticks: {
										                  min: 0,
										                  scaleSteps : 10,
										                  stepSize: 100,
										              }
												}]
											}
										}
									};
								$('#parameterVitalsTrendBtn').click(function(){
									$('.cumulativeTestChartHeadingForVitalsTreePresc').show();
									var ctx = document.getElementById(menuId+'_chart').getContext('2d');
									window.myLine = new Chart(ctx, config);
								});
								
								
							}
							
						}
		      
				      
		      			//,complete: $('#TreeStructurePrescriptionVitalsListMsg').text('Error !!!')
				});
		      $('.investigationsDiv').find('input').on('focus',function(){
		          var index = $('.investigationsDiv').find('input').index(this);
		          //alert(index);
		          if (index == '1') {
		            $('.investigationsDiv').find('input').eq(2).val('');
		          } else if (index == '2') {
		            $('.investigationsDiv').find('input').eq(1).val('');
		          } 
		        });

	});
	
	
	$('.clinicalProceduresAdd').click(function(){
		var clinicalProcedureVal = $('select[name=clinicalProcedureName] option:selected').text();//$(this).parent().parent().parent().find('input[name=clinicalProcedureName]').val();
		//var otherProceduresVal = clinicalProcedureVal ; //$(this).parent().parent().parent().find('input[name=otherProcedures]').val();
		var ServiceAreaName =	$('select[name=clinicalServiceArea] option:selected').text();
		var clinicalProcedureCode = $('select[name=clinicalProcedureName] option:selected').val();
		var ServiceAreaCode = $('select[name=clinicalServiceArea] option:selected').val();
		//console.log('clinicalProcedureVal== '+clinicalProcedureVal+ '  ServiceAreaName==='+  ServiceAreaName); 
		if(clinicalProcedureVal.trim()!='')
		  {  
			   /* var tmp = 0; 
				$('.clinicalProceduresAdded').find('label .text').each(function(index){ 
					if($(this).text().split("(")[0].trim().toUpperCase()===clinicalProcedureVal.trim().toUpperCase()) 
					{	tmp = 1; 
						return false;  }
				});
				if(tmp==1)
				{
					swal("Already Added!!");
					//$(this).parent().parent().parent().find('input[name=txt-snomed-ct-search_VR7]').val(''); 
					return false;
				}*/
				var isValid = 0;
			 	 var invObj = $("#ClinicalProcedureJsonObjDiv").text().trim(); //localStorage.getItem('ClinicalProcedureObj'); 
		 		 invObj = JSON.parse(invObj.toString()); 
		 		 for(var v=0; v<invObj.length;v++)
		 		 { 
		 			if (invObj[v].testName.toUpperCase() == clinicalProcedureVal.toUpperCase()) {
		 				isValid=1;
				        break;
				    } 
		 		  } 
		 		 if(ServiceAreaCode=='0')
		 		{
					  swal('Please select service area');
					  return false; 
				}
		 		 else if(clinicalProcedureCode.trim()=='0') 
				{
				  swal('Please select procedure');
				  return false; 
				}
				else
				{
					var diagnosisCode ='';
					 for(var v=0; v<invObj.length;v++)
			 		 { 
			 			if (invObj[v].testName.toUpperCase() == clinicalProcedureVal.toUpperCase()) {
			 			diagnosisCode  = invObj[v].testId;	//+'^'+invObj[v].labName ;  /*+'^'+$("#investigationSiteId").val()+'^'+$("#investigationRemarksId").val();;*/ 
					        break;
					    } 
			 		 }
					//var diagnosisCode = '0'; //$(this).parent().parent().find('input[name=txt-snomed-ct-search_VR7]').attr('clinicalprocedurecode');
	 			 	//var diagnosisTypeCode = $(this).parent().parent().find('select[name=diagnosisType]').val();
	 			 	//var diagnosisTypeName = $(this).parent().parent().find('select[name=diagnosisType] option:selected').text();
	 			 	   //console.log('diagnosisCode'+diagnosisCode);
	 			 	   if(diagnosisCode != ''){
	 			 	 	 var siteId=$(this).parent().parent().find('select[name="clinicalProceduresSite"] option:selected').text();
	 					clinicalProcValue =clinicalProcedureVal+'#'+diagnosisCode+'#'+$("#clinicalProceduresSiteId").val()+'#'+siteId+'#'+$("#clinicalProceduresRemarksId").val()+'#'+$('#clinicalServiceAreaId').val()+'#'+ServiceAreaName;
	 					
	 					var ClinicalProcedureJson = {
	 							"IsExternal"  			:  "0" ,
	 							"ProceduresName"		:	clinicalProcedureVal ,
	 							"ProcedureCode"			:	diagnosisCode ,
	 							"ProcedureSideCode"		:	$("#clinicalProceduresSiteId").val() ,
	 							"ProcedureSideName"		:	siteId ,
	 							"ProcedureSideRemarks"	:	$("#clinicalProceduresRemarksId").val() ,
	 							"ServiceAreaCode"		:	$('#clinicalServiceAreaId').val(),
	 							"ServiceAreaName"		:	$('select[name=clinicalServiceArea] option:selected').text()
	 					}
	 					
	 					var temp='';
	 					if(clinicalProcedureVal !='' && $("#clinicalProceduresSiteId").val() !='0'){
	 						temp= '[' +  siteId + ']'  ;
	 					}
	 					if($("#clinicalProceduresRemarksId").val() != '' ){
	 						temp=temp + $("#clinicalProceduresRemarksId").val() ;
	 					}
	 					 //console.log('ClinicalProcedureJson -- '+JSON.stringify(ClinicalProcedureJson));
	 					 
	 					//commented by ashutoshk to hide ServiceAreaName 
	 					$(this).parent().parent().parent().find('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs"   data-toggle="tooltip" title="'+ temp +'" >'+
	 			    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+clinicalProcValue+'" checked="">  '+
	 			    	 		'<i class="" style="display :none">'+JSON.stringify(ClinicalProcedureJson)+' </i>'+
	 			    	 		//'<span class="text">'+ServiceAreaName +' ['+ clinicalProcedureVal+ ']' +' </span>'+
	 			    	 		'<span class="text">' +'['+ clinicalProcedureVal+ ']' +' </span>'+
	 			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	 			    	 		'</button></label>');
	 			 	   }else{
	 			 		 var siteId=$(this).parent().parent().find('select[name="clinicalProceduresSite"] option:selected').text();
	 					otherProceduresValue =otherProceduresVal+'#0^0#'+$("#clinicalProceduresSiteId").val()+'#'+siteId+'#'+$("#clinicalProceduresRemarksId").val()+'#'+$('#clinicalServiceAreaId').val()+'#'+ServiceAreaName;
	 					var ClinicalProcedureJson = {
	 							"IsExternal"  			:  "1" ,
	 							"ProceduresName"		:	otherProceduresVal ,
	 							"ProcedureCode"			:	"0^0" ,
	 							"ProcedureSideCode"		:	$("#clinicalProceduresSiteId").val() ,
	 							"ProcedureSideName"		:	siteId ,
	 							"ProcedureSideRemarks"	:	$("#clinicalProceduresRemarksId").val(),
	 							"ServiceAreaCode"		:	$('#clinicalServiceAreaId').val(),
	 							"ServiceAreaName"		:	$('select[name=clinicalServiceArea] option:selected').text()
	 					}
	 					 //console.log('ClinicalProcedureJson '+JSON.stringify(ClinicalProcedureJson));
	 					
	 					var temp='';
	 					if(otherProceduresVal !='' && $("#clinicalProceduresSiteId").val() !='0'){
	 						temp=  '[' +  siteId + ']'  ;
	 					}
	 					if($("#clinicalProceduresRemarksId").val() != '' ){
	 						temp=temp + $("#clinicalProceduresRemarksId").val() ;
	 					}
	 					
	 					$(this).parent().parent().parent().find('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs" data-toggle="tooltip" title='+ temp +' >'+
	 			    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+otherProceduresValue+'" checked="">  '+
	 			    	 		'<i class="" style="display :none">'+JSON.stringify(ClinicalProcedureJson)+' </i>'+
	 			    	 		//'<span class="text">'+ServiceAreaName +'['+ otherProceduresVal+ ']' +'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
	 			    	 		'<span class="text">'+'['+ otherProceduresVal+ ']' +'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
	 			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	 			    	 		'</button></label>');
	 			 	   }
	 			

				}
		 		//$(this).parent().parent().parent().find('input[name=clinicalProcedureName]').val('');
			 //$(this).parent().parent().parent().find('input[name=flexdatalist-clinicalProcedureName]').val(''); 
			 //$(this).parent().parent().find('input[name=txt-snomed-ct-search_VR2]').attr('clinicalprocedurecode','');
			 $(this).parent().parent().find('select[name=clinicalProceduresSite]').val('0');
			 $('#clinicalProcedureName').html(strClinicalProcedurehtml);
			 $(this).parent().parent().find('select[name=clinicalServiceArea]').val('0');
			 $(this).parent().parent().find('#clinicalProceduresRemarksId').val('');
			 $('[data-toggle="tooltip"]').tooltip();
		  }
		/*else if(otherProceduresVal != ''){
			var tmp = 0; 
			$('.clinicalProceduresAdded').find('label .text').each(function(index){ 
				if($(this).text().split("*")[0].trim().toUpperCase()===otherProceduresVal.trim().toUpperCase()) 
				{	tmp = 1; 
					return false;  }
			});
			if(tmp==1)
			{
				swal("Already Added!!");
				$(this).parent().parent().parent().find('input[name=otherProcedures]').val(''); 
				return false;
			}
			else
			{
				var siteId=$(this).parent().parent().find('select[name="clinicalProceduresSite"] option:selected').text();
			     otherProceduresValue =otherProceduresVal+'#'+$("#clinicalProceduresSiteId").val()+'#'+siteId+'#'+$("#clinicalProceduresRemarksId").val();
				
			   $(this).parent().parent().parent().find('.clinicalProceduresAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs">'+
		    	 		'<input type="checkbox" class="checkedInput" name="clinicalProc" value="'+otherProceduresValue+'" checked="">  '+
		    	 		'<span class="text">'+otherProceduresVal+'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
		    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		    	 		'</button></label>');

			}
			//$(this).parent().parent().parent().find('input[name=clinicalProcedureName]').val('');
			$('#clinicalProcedureName').html(strClinicalProcedurehtml);
			 $(this).parent().parent().find('select[name=clinicalServiceArea]').val('0');
			 $(this).parent().parent().parent().find('input[name=otherProcedures]').val(''); 
			 $(this).parent().parent().find('select[name=clinicalProceduresSite]').val('0');
			 $(this).parent().parent().find('#clinicalProceduresRemarksId').val('');
			 $('[data-toggle="tooltip"]').tooltip();
		}*/
		  else{
			  swal('Please enter clinical procedures to be added');
		  }
	});
	
	$('.drugBookmarkAddBtn').click(function(){
		//console.log(':::::::::DRUGBOOKMRKADD');
		
		 $(this).parent().parent().find('input[name=drugsAdvicesBook]:checked').each(function(index){
			 var drugsAdvicesBookName = $(this).parent().text();
			 //console.log($(this).val());
			 var hiddenVal=$(this).val();
			 
			 var temp1=0;
			 $('#drugAdviceListTable tbody').find('tr').each(function(index){
				 //console.log('==DRUGTD'+$(this).find('td').eq(0).children('input').val().split('&&')[0]);
				 //console.log('==DRUGTD1'+hiddenVal.split('&&')[0]);
				 //console.log('======DRUGTD2'+($(this).find('td').eq(0).children('input').val().split('&&')[0]).toUpperCase() == (hiddenVal.split('&&')[0]).toUpperCase());
					if(($(this).find('td').eq(0).children('input').val().split('&&')[0]).toUpperCase() == (hiddenVal.split('&&')[0]).toUpperCase()) 
					{	
						//console.log('1111');
						temp1 = 1; 
						//return false; 
					}
				});
			 
			 ////console.log($(this).find('tr').html());
			 //console.log(hiddenVal.split('&&')[8]);
			
			 if(temp1 == 1)
				 {}else{
					 
				 
				 
					 var DrugJson ={
			 					"IsExterNal"	:		"0" ,	
			 					"DrugName"		 :	 hiddenVal.split('&&')[0] ,
			 					"DrugCode"		 :	 hiddenVal.split('&&')[1] ,
			 					"DoaseName"		:	hiddenVal.split('&&')[2] ,
			 					"DoaseCode"		:	hiddenVal.split('&&')[3] ,
			 					"FrequencyName"	:	hiddenVal.split('&&')[4] ,
			 					"FrequencyCode" :	hiddenVal.split('&&')[5] ,
			 					"StartDate"		:	hiddenVal.split('&&')[6] ,
			 					"DrugDays"		:	(hiddenVal.split('&&')[7]).split('#')[0] ,
			 					"DrugQuantity"	:	(hiddenVal.split('&&')[7]).split('#')[1] ,
			 					"DrugInstruction" :	hiddenVal.split('&&')[8]
			 					
			 			}
			 			
			 			//console.log(JSON.stringify(DrugJson));
			 var html='<tr>';
			 html+='<td><input type="checkbox" class="checkedInput" name="drugsAdvices" value="'+hiddenVal+'"  checked><i class="text" style="display :none">'+JSON.stringify(DrugJson)+' </i></td>';
			 html+='<td>'+hiddenVal.split('&&')[0]+'</td>';
			 html+='<td>'+hiddenVal.split('&&')[2]+'</td>';
			 html+='<td>'+hiddenVal.split('&&')[4]+'</td>';
			 html+='<td>'+hiddenVal.split('&&')[6]+'</td>';
			 html+='<td>'+(hiddenVal.split('&&')[7]).split('#')[0]+'</td>';
			 html+='<td>'+(hiddenVal.split('&&')[7]).split('#')[1]+'</td>';
			 html+='<td>'+hiddenVal.split('&&')[8]+'</td>';
			 html+='<td><button  class="btn btn-xs drugEditBtn" type="button"><i class="fa fa-edit"></i></button></td>';
			 html+='</tr>';		 
			 $('#drugAdviceListTable').children('tbody').append();
			 
			 
			 $('.drugEditBtn').click(function(){
				 //console.log('inside drugEditBtn 4')
				    if($('input[name=drugName]').val()!='')
				    	return false;
			 		var drugName = $(this).parent().parent().find('td').eq(1).text();
			 		var drugDosage = $(this).parent().parent().find('td').eq(2).text();
			 		var drugFrequency = $(this).parent().parent().find('td').eq(3).text(); 
			 		var drugStartDate = $(this).parent().parent().find('td').eq(4).text(); 
			 		var drugDays = $(this).parent().parent().find('td').eq(5).text(); 
			 		var drugQuantity = $(this).parent().parent().find('td').eq(6).text(); 
			 		var instructions = $(this).parent().parent().find('td').eq(7).text(); 
			 		
			 		var firsttdObj=$(this).parent().parent().find('td').eq(0);
					var json= JSON.parse($(firsttdObj).find('.text1').html());
			 		
			 		var drugjson={
				 		    "drugId": json["DrugCode"],
				 		    "drugName": json["DrugName"],
				 		    "drugStatus": json["drugStatus"]!=undefined?json["drugStatus"]:"",
				 		    "programId": json["programId"]!=undefined?json["programId"]:"",
				 		    "programName": json["programName"]!=undefined?json["programName"]:"",
				 		}
				 	$("#drugJsonObjDiv").text(JSON.stringify(drugjson));
			 		
			 		
			 		$(this).parent().parent().remove();
			 		$('input[name=drugName]').val(drugName);
			 		$('input[name=flexdatalist-drugName]').val(drugName);
			 		$('select[name=drugDosage]').val($('select[name=drugDosage] option:contains('+drugDosage+')').val());
			 		$('select[name=drugFrequency]').val($('select[name=drugFrequency] option:contains('+drugFrequency+')').val());
			 		/*$('input[name=drugStartDate]').val(drugStartDate); */
			 		document.getElementById('drugStartDate').valueAsDate = new Date();
			 		$('input[name=drugDays]').val(drugDays);
			 		$('input[name=drugQuantity]').val(drugQuantity);
			 		$('textarea[name=drugInstructions]').val(instructions);
				}); 
			}
		});
		
		
		
		 $(this).parent().parent().parent().find('.close').click();
		// $(this).parent().parent().parent().parent().find('#drugAdviceListTable').children('tbody').append('<tr> <td><input type="checkbox" class="checkedInput" name="drugsAdvices" value="'+HiddenDrugAdvice+'"  checked></td><td>'+drugName+'</td><td>'+drugDosage+'</td><td>'+drugFrequency+'</td><td>'+drugStartDate+'</td><td>'+drugDays+'</td><td>'+drugQuantity+'</td><td><a class="drugAdvicesInstructionsModalBtn" style="color: #109f1c" drugInstructions="'+drugInstructions+'" onclick="$(\'#drugAdvicesInstructionsModal\').modal(\'show\');">'+drugInstructions.substring(0, 4)+'..'+'</a></td><td><button class="btn btn-xs drugEditBtn" type="button"><i class="fa fa-edit"></i></button></td></tr>'); // drugInstructions   drugInstructions.substring(0, 4)
	});
	
	 var strrefcount=0;
	 $( document ).ready(function() {
	 $('input[name=referalchk]').each(function()
				{
		 ++strrefcount;
				})
	 });
	$('.refferaladdBtn').click(function(){
			////console.log('"""""""""""""""""""refferaladdBtn');
			
			////console.log(" ---- "+$("#strreferalchkId1").val());
		
			$('#strOtherHospitalNameDivId').hide();
			var strReffralDeptCmb= ($('select[name=refferlPatientDept] option:selected').val()).split('#')[0];
			var strReffralDepttext=($('select[name=refferlPatientDept] option:selected').text());
			
			var strreferralType= ($('select[name=referralType] option:selected').val());
			var strreferralTypeName=($('select[name=referralType] option:selected').text());
			
			//var strReffralReason=$('input[name=refferalResonId]').val(); ------ commented by ashutoshk for changing input tag to textarea tag under refer section
			var strReffralReason= '';
			if($("#refferalResonId").val()=='')
				strReffralReason= $("#refferalResonId2").val();
			else
				strReffralReason = $("#refferalResonId").val();
			//console.log("Referral Note-----------"+$("#refferalResonId").val());
			var strReffralDeptDone =($('select[name=refferlPatientDept] option:selected').val());
			var strExternalHospital='';
			var strExternalDepartment='' , strExternalrefferalInstitute='';
			var strtooltiplData='';
			var strShowData='';
			var strExternalHospitalName1='';
			var strExternalDepartmentName='' , strExternalrefferalInstituteName='', strOtherAssociateHospitalName='';
			var strExternalZoneName ='', strExternalZoneId='',strExternalDivisionName='',strExternalDivisionId='';
			var strExternalInstituteDays ='', strExternalInstituteReasonId='', strExternalInstituteReasonName='';
			if(strreferralType == '0'){
				 swal('Please select Referal Combo to be added');
				  return false; 
			
			}
			
			if(strreferralType == 4){
				 if($('#strRailTailFlgId').val() == '1'){
					strExternalZoneId= ($('select[name=strExternalrefferalZone] option:selected').val());
					strExternalZoneName=($('select[name=strExternalrefferalZone] option:selected').text())
					 strShowData = strExternalZoneName ;
					 if(strExternalZoneId==''){
						 swal('Please select Zone Combo to be added');
						  return false; 
					 }
					 strExternalDivisionId= ($('select[name=strExternalDivisionList] option:selected').val());
					 strExternalDivisionName=($('select[name=strExternalDivisionList] option:selected').text())
					 strShowData += '['+ strExternalDivisionName +']' ;
					 if(strExternalDivisionId==''){
						 swal('Please select Division Combo to be added');
						  return false; 
					 }
					 strExternalHospital= ($('select[name=strExternalrefferalHospital1] option:selected').val());
					 strExternalHospitalName1=($('select[name=strExternalrefferalHospital1] option:selected').text())
					 strShowData += '['+ strExternalHospitalName1 +']' ;
					 if(strExternalHospital==''){
						 swal('Please select External Hospital Combo to be added');
						  return false; 
					 }
				 }
				 else{
					 strExternalHospital= ($('select[name=strExternalrefferalHospital] option:selected').val());
					 strExternalHospitalName1=($('select[name=strExternalrefferalHospital] option:selected').text())
					 strShowData = strExternalHospitalName1 ;
					 if(strExternalHospital==''){
						 swal('Please select External Hospital Combo to be added');
						  return false; 
					 }
				 }
				 
				 strExternalDepartment= ($('select[name=strExternalDepartmentList] option:selected').val());
				 strExternalDepartmentName=($('select[name=strExternalDepartmentList] option:selected').text());
				 strShowData +=  '['+ strExternalDepartmentName +']' ;
				 //console.log(strShowData);
				 if(strExternalDepartment=='0'){
					 swal('Please select External Department Combo to be added');
					  return false; 
				 }
			}
			
			if(strreferralType == 5){
				strExternalrefferalInstituteName=  ($('select[name=strExternalrefferalInstitute] option:selected').text());
				strExternalrefferalInstitute= ($('select[name=strExternalrefferalInstitute] option:selected').val());
				strShowData = strExternalrefferalInstituteName;
				if(strExternalrefferalInstitute=='-1'){
					 swal('Please select External Institute Combo to be added');
					  return false; 
				 }
				 //strOtherAssociateHospitalName
				 if(strExternalrefferalInstitute == '0'){
					 strOtherAssociateHospitalName= $('#strOtherHospitalNameId').val();
					 strShowData += '['+ strOtherAssociateHospitalName + ']'
					 
				 }else{
				 strExternalDepartmentName=($('select[name=strExternalDepartmentList] option:selected').text());
				 strExternalDepartment= ($('select[name=strExternalDepartmentList] option:selected').val());
				 strShowData += '['+  strExternalDepartmentName +']'
				 if(strExternalDepartment=='0'){
					 swal('Please select External Department Combo to be added');
					  return false; 
				 }
			  }
				 strExternalInstituteDays =$("input[name='strExternalrefferalDays']").val();
				 strExternalInstituteReasonName=($('select[name=referralReason] option:selected').text());
				 strExternalInstituteReasonId= ($('select[name=referralReason] option:selected').val());
			}
			////console.log(strReffralDeptCmb +' ::::: '+strReffralDepttext+' ::::::: '+ strreferralType + '   ::::: '+ strreferralTypeName +'  ::::::' + strReffralReason +':::::::'+ strReffralDeptDone);
			if(strreferralType == 1 || strreferralType == 2  || strreferralType == 3){
				strShowData = ($('select[name=refferlPatientDept] option:selected').text()) ;
			 if(strReffralDeptCmb.trim()=='0' ) 
				{
				  swal('Please select Department to be added');
				  return false; 
				}
			}
			 var chk=0;
			
			 $('.refferalAdded').find('label .text').each(function(index){
				 ////console.log("strReffralDepttext "+$(this).text().trim().toUpperCase());
				// //console.log("strReffralDepttext upper "+$(this).text().trim().toUpperCase());
				 
				// //console.log("check : "+$(this).text().trim().toUpperCase()==strReffralDepttext.trim().toUpperCase());
					if($(this).text().trim().toUpperCase()===strReffralDepttext.trim().toUpperCase()) 
					{	
						chk = 0; 
						return false; 
					}
				});
			 
			 
			/* $('.refferalAdded').find('input id').each(function(index){
				 //console.log("refferalAdded id "+$(this));
				// //console.log("strReffralDepttext upper "+$(this).text().trim().toUpperCase());
				 
				 ////console.log("check : "+$(this).text().trim().toUpperCase()==strReffralDepttext.trim().toUpperCase());
					if($(this).text().trim().toUpperCase()===strReffralDepttext.trim().toUpperCase()) 
					{	
						chk = 0; 
						return false; 
					}
				});*/
			 var chkMode ="";
			 $('input[name=referalchk]').each(function()
						{
							//console.log('referalchk::>>> '+$(this).parent().find('i').text());
							////console.log("refer--"+JSON.parse($(this).parent().find('i').text()));
							var strrefrealId=JSON.parse($(this).parent().find('i').text().split("^")[0]);
							var mode = $(this).parent().find('i').text().split("^")[1];
							//console.log(strrefrealId.strReffralDeptCmb);
							var episodeCode = $('#patEpisodeCodePrescriptionPanel').text();
							var visitNo = $('#patEpisodeVisitNoPrescriptionPanel').text();
							
							if(strreferralType == '1' || strreferralType == '2' || strreferralType == '3'){
								
								if(strReffralDeptCmb === strrefrealId.strReffralDeptCmb && episodeCode === strrefrealId.episodeCode && visitNo === strrefrealId.visitNo) 
								{	
									chk = 1; 
									chkMode = mode;
								}
							}
							if(strreferralType == '4' ){
								
								if(strExternalHospital === strrefrealId.strExternalHospitalcode && episodeCode === strrefrealId.episodeCode && visitNo === strrefrealId.visitNo && strExternalDepartment === strrefrealId.strExternalDepartmentcode) 
								{	
									chk = 1; 
									chkMode = mode;
								}
							}
							if(strreferralType == '5' ){
								
								if(strExternalrefferalInstitute == strrefrealId.strExternalrefferalInstitutecode && episodeCode === strrefrealId.episodeCode && visitNo === strrefrealId.visitNo && strExternalDepartment === strrefrealId.strExternalDepartmentcode) 
								{	
									chk = 1; 
									chkMode = mode;
								}
							}
						});
					
					
					//console.log(chkMode);
					if(chk ==1 ){
						if(chkMode==="NEW")
							swal('Department already added');
						else
							swal('The department you are trying to add is already referred today');
						return false; 
					}
					else{
					var reffralJson={
							"strReffralDeptCmb" : strReffralDeptCmb ,
							"strReffralDepttext" : strReffralDepttext , 
							"strreferralType"    : strreferralType ,
							"strreferralTypeName" : strreferralTypeName ,
							"strReffralReason"   :  strReffralReason ,
							"strReffralDeptDone" : strReffralDeptDone ,
							
							"strExternalHospitalcode" : strExternalHospital ,
							"strExternalDepartmentcode"   :  strExternalDepartment ,
							"strExternalrefferalInstitutecode" : strExternalrefferalInstitute ,
							
							"strExternalHospitalName" : strExternalHospitalName1 ,
							"strExternalDepartmentName"   :  strExternalDepartmentName ,
							"strExternalrefferalInstituteName" : strExternalrefferalInstituteName ,
							'strOtherAssociateHospitalName'		: strOtherAssociateHospitalName ,
							'strShowData'  						: strShowData ,
							'strExternalZoneName' 				: strExternalZoneName , 							
							'strExternalZoneId'					: strExternalZoneId ,
							'strExternalDivisionName'			: strExternalDivisionName ,
							'strExternalDivisionId'				: strExternalDivisionId ,
							'strExternalInstituteDays'			: strExternalInstituteDays ,
							'strExternalInstituteReasonId'		: strExternalInstituteReasonId ,
							'strExternalInstituteReasonName'	: strExternalInstituteReasonName ,
							'episodeCode'			:	$('#patEpisodeCodePrescriptionPanel').text() ,
							'visitNo'				:	$('#patEpisodeVisitNoPrescriptionPanel').text()
					} ;
					////console.log("strShowData="+strShowData);
					//console.log("Stringfy JSon refferal == "+JSON.stringify(reffralJson));
					strrefcount++;
					var tooltipdata ='-';
					if(strreferralType != 0)
						tooltipdata =strreferralTypeName;
					if(strReffralReason != '')
						tooltipdata =strreferralTypeName +'(' + strReffralReason +')';
					////console.log(JSON.stringify((reffralJson.toString()));
					$(this).parent().parent().parent().find('.refferalAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button"  data-toggle="tooltip" title='+ tooltipdata +'  class="value btn btn-xs '+strShowData.trim()+'">'+
			    	 		'<input type="checkbox" class="checkedInput" name="referalchk" id="strreferalchkId'+strrefcount+'"  value="" checked="">  '+
			    	 		'<i class="" style="display :none">'+JSON.stringify(reffralJson)+'^NEW</i>'+
			    	 		'<span class="text">'+strShowData.trim()+'<sup style="color:red; font-weight:bold;"></sup> </span>'+
			    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
			    	 		'</button></label>');
					
					 var temp='#strreferalchkId'+strrefcount;
		                $(temp).val(JSON.stringify(reffralJson));
		                
				}
					//$('#refferlPatientDeptId').html(refferlPatientDeptVal1);
					
					$('select[name=refferlPatientDept]').val('0#0#0#0#0#0#0#0');
					$('select[name=referralType]').val('0');
					$('#refferalResonId').val('');
					$("#refferalResonId2").val('');
					$('select[name=strExternalrefferalInstitute]').val('-1');
					if($('#strRailTailFlgId').val() == '1'){
						$('select[name=strExternalrefferalHospital1]').val('');
						$('select[name=strExternalrefferalZone]').val('');
						$('select[name=strExternalDivisionList]').val('');
					 }
					 else{
						$('select[name=strExternalrefferalHospital]').val('');
					 }
					
					
					
					$('[data-toggle="tooltip"]').tooltip();
			 
			
	});
	var doaseCmbValue='';
	var refferlPatientDeptVal1 = '';
	var strExternalDepartmentListhtml = '';
	var strExternalDivisionListhtml ='';
	var strClinicalProcedurehtml ='';
	$( document ).ready(function() {
	    doaseCmbValue= $('#drugDosageId').html();
	    //refferlPatientDeptVal1 = $('#refferlPatientDeptId').html();
	    strExternalDepartmentListhtml = $('#strExternalDepartmentListId').html();
	    strClinicalProcedurehtml = $('#clinicalProcedureName').html();
	});
	
	
	$(function() {
        $(".AddTogleclassBtn").on("click", function() {
            $('html, body').animate({
                scrollTop: $(".AddTogleclassBtn").offset().top
            }, 1000);

        });
	 });
	
	
	/*$('#strExternalrefferalHospitalId').change(function(){
		
		$('#strExternalDepartmentListId').html("<option value='0#0#0#0#0#0#0#0' selected>Select Department</option>");
		var data={hmode:"populatestrExternalDepartmentList",strHospitalCode: $('#strExternalrefferalHospitalId').val()};
		
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(result);
				//alert(JSON. stringify(result));
				var selected="";
				if(result.length==1){
					selected="selected";
				}
				else
					$('#strExternalDepartmentListId').html("<option value='0#0#0#0#0#0#0#0' selected>Select Department</option>");
					
				$.each(result, function(indx, rowObj){
					var optionValue=rowObj["dept_code"]
					var optionText=rowObj["department_name"]
					//alert(optionValue);
					$('#strExternalDepartmentListId').append("<option value='"+optionValue+"' "+selected+">"+optionText+"</option>");
				});
			}
		});
	});*/
	
	
	$('#strExternalrefferalZoneId').change(function(){
			//$('select[name=strExternalDivisionList] option:selected').val('');
			//var tempcount1=0;
			$('#strExternalDivisionListId').html('');
			var zoneId=  ($('select[name=strExternalrefferalZone] option:selected').val());
			//console.log("zoneId==="+zoneId);
			$.ajax({
                type: "GET",
                url: '/HISServices/service/railtelService/getDivisionList?zoneId='+zoneId,
                //data: ({subSystemId : $('#subSystem'+elementIdIndex+'').val() }),
                dataType:'json',
                async: true,
                success: function(items) {
                    ////console.log(items);
                    if(items.status==1 && items.division_details!=null)
                 	   {
                     	   if(items.division_details.length>0)
                     	   {
                     		  $('#strExternalDivisionListId').append($('<option>', {value: '', text: 'Select Division'}));
                     		  for(var j=0;j<items.division_details.length;j++)
                             	{
                         	    	//localStorage.removeItem('prescImg'+count.toString()+(j+1));
                         	    	//localStorage.setItem('prescImg'+count.toString()+(j+1),result2.ImageData[j].IMG_DOCUMENT); 
                                 	$('#strExternalDivisionListId').append($('<option>', {value: items.division_details[j].DIVISION_ID, text: items.division_details[j].DIVISION_NAME}));
                                 	}
                     	   }
                     	  else
                		   {
                     		 $('#strExternalDivisionListId').append($('<option>', {value: '', text: 'Select Division'}));
                		   }
                 	   }
                },
                error: function (e) {
                    alert('Error Received: ' + e);
                  },
            });
			
	});
	$('#strExternalDivisionListId').change(function(){
		//$('select[name=strExternalDivisionList] option:selected').val('');
		//var tempcount1=0;
		$('#strExternalrefferalHospitalId1').html('');
		var zoneId=  ($('select[name=strExternalrefferalZone] option:selected').val());
		var divisionId=  ($('select[name=strExternalDivisionList] option:selected').val());
		$.ajax({
            type: "GET",
            url: '/HISServices/service/railtelService/getHospitalList?zoneId='+zoneId+'&divisionId='+divisionId,
            //data: ({subSystemId : $('#subSystem'+elementIdIndex+'').val() }),
            dataType:'json',
            async: true,
            success: function(items) {
                ////console.log(items);
                if(items.status==1 && items.hospital_details!=null)
             	   {
                 	   if(items.hospital_details.length>0)
                 	   {
                 		  $('#strExternalrefferalHospitalId1').append($('<option>', {value: '', text: 'Select Hospital'}));
                 		  for(var j=0;j<items.hospital_details.length;j++)
                         	{
                     	    	//localStorage.removeItem('prescImg'+count.toString()+(j+1));
                     	    	//localStorage.setItem('prescImg'+count.toString()+(j+1),result2.ImageData[j].IMG_DOCUMENT); 
                             	$('#strExternalrefferalHospitalId1').append($('<option>', {value: items.hospital_details[j].CODE, text: items.hospital_details[j].NAME}));
                             	if($('#patHospitalCodePrescriptionPanel').text()===items.hospital_details[j].CODE)
                             		$("#strExternalrefferalHospitalId1 option[value='"+items.hospital_details[j].CODE+"']").remove();
                            }
                 	   }
	             	   else
             		   {
	             		  $('#strExternalrefferalHospitalId1').append($('<option>', {value: '', text: 'Select Hospital'}));
             		   }
             	   }
            },
            error: function (e) {
                alert('Error Received: ' + e);
              },
        });
		
	});
	
	$('#strExternalrefferalHospitalId1').change(function(){
		
		$('#strExternalDepartmentListId').html(strExternalDepartmentListhtml);
		var tempcount1=0;
		var intemtype=  ($('select[name=strExternalrefferalHospital1] option:selected').val());
		
		var options = $('#strExternalDepartmentListId option');
        
		var values = $.map(options ,function(option) {
        	//console.log(intemtype +"  "+    (option.value).split('#')[10]);
        	if(intemtype == (option.value).split('#')[10])
        		{
        		$("#strExternalDepartmentListId").val(option.value);	
        			
        		tempcount1 = 1 ;
        			 
        		}else{
        			$("#strExternalDepartmentListId option[value='"+option.value+"']").remove();
	        		
        			//$(this).remove();
        			//tempcount1=0;
        			
        		}
        	$("#strExternalDepartmentListId").prop("selectedIndex", 0);
        	
        	
        	/*else{
        			$("#drugDosageId").val('0');
        		}*/
            return option.value;
        });
		//console.log('tempcount1::::::::::  '+tempcount1);
    	
		if(tempcount1 == 0)
		{
		$("#strExternalDepartmentListId").html('<option value="0#0#0#0#0#0#0#0#0#0">Select Department</option>');
		}
		
	});

	$('#strExternalrefferalHospitalId').change(function(){
		
		$('#strExternalDepartmentListId').html(strExternalDepartmentListhtml);
		var tempcount1=0;
		var intemtype=  ($('select[name=strExternalrefferalHospital] option:selected').val());
		
		var options = $('#strExternalDepartmentListId option');
        
		var values = $.map(options ,function(option) {
        	////console.log(intemtype +"  "+    (option.value).split('#')[10]);
        	if(intemtype == (option.value).split('#')[10])
        		{
        		$("#strExternalDepartmentListId").val(option.value);	
        			
        		tempcount1 = 1 ;
        			 
        		}else{
        			$("#strExternalDepartmentListId option[value='"+option.value+"']").remove();
	        		
        			//$(this).remove();
        			//tempcount1=0;
        			
        		}
        	$("#strExternalDepartmentListId").prop("selectedIndex", 0);
        	
        	
        	/*else{
        			$("#drugDosageId").val('0');
        		}*/
            return option.value;
        });
		//console.log('::::::::::  '+tempcount1);
    	
		if(tempcount1 == 0)
		{
		$("#strExternalDepartmentListId").html('<option value="0#0#0#0#0#0#0#0#0#0">Select Department</option>');
		}
		
	});
	$('#strEmpanelledDepartmentListId').change(function(){
		//$('select[name=strExternalDivisionList] option:selected').val('');
		//var tempcount1=0;
		$('#strExternalrefferalInstituteId').html('');
		var deptId=  ($('select[name=strEmpanelledDepartmentList] option:selected').val()).split('#')[0];
		var hospId=  $('#patHospitalCodePrescriptionPanel').text();
		//console.log("deptId==>"+deptId+"  hospId==>"+hospId);
		$.ajax({
            type: "GET",
            url: '/HISServices/service/railtelService/getExtDeptWiseInstituteList?deptId='+deptId+'&hospId='+hospId,
            //data: ({subSystemId : $('#subSystem'+elementIdIndex+'').val() }),
            dataType:'json',
            async: true,
            success: function(items) {
                ////console.log(items);
                if(items.status==1 && items.Institute_details!=null)
             	   {
                 	   if(items.Institute_details.length>0)
                 	   {
                 		  $('#strExternalrefferalInstituteId').append($('<option>', {value: '-1', text: 'Select Institute'}));
                 		  for(var j=0;j<items.Institute_details.length;j++)
                         	{
                     	    	//localStorage.removeItem('prescImg'+count.toString()+(j+1));
                     	    	//localStorage.setItem('prescImg'+count.toString()+(j+1),result2.ImageData[j].IMG_DOCUMENT); 
                             	$('#strExternalrefferalInstituteId').append($('<option>', {value: items.Institute_details[j].GNUM_INSTITUTE_CODE, text: items.Institute_details[j].GSTR_INSTITUTE_NAME}));
                             	//if($('#patHospitalCodePrescriptionPanel').text()===items.hospital_details[j].CODE)
                             		//$("#strExternalrefferalHospitalId1 option[value='"+items.hospital_details[j].CODE+"']").remove();
                            }
                 	   }
	             	   else
             		   {
	             		  $('#strExternalrefferalInstituteId').append($('<option>', {value: '-1', text: 'Select Institute'}));
             		   }
             	   }
                else
      		   {
          		  $('#strExternalrefferalInstituteId').append($('<option>', {value: '-1', text: 'Select Institute'}));
      		   }
            },
            error: function (e) {
                alert('Error Received: ' + e);
              },
        });
		
	});
	
/*$('#strExternalrefferalInstituteId').change(function(){
	 $('#refferlPatientDeptDivId').hide();
	 $('#strExternalDepartmentListDiv').show();
	
	 var strOtherExtHospitalCode=  ($('select[name=strExternalrefferalInstitute] option:selected').val());
	 if(strOtherExtHospitalCode == 0){
		 $('#strOtherHospitalNameDivId').show();
		 $('#strExternalDepartmentListDiv').hide();
			
	 }else{
		 $('#strExternalDepartmentListDiv').show();
		 $('#strOtherHospitalNameDivId').hide();
	 }
	 
		$('#strExternalDepartmentListId').html(strExternalDepartmentListhtml);
		var tempcount1=0;
		var intemtype=  100;
		
		var options = $('#strExternalDepartmentListId option');
        
		var values = $.map(options ,function(option) {
        	////console.log(intemtype +"  "+    (option.value).split('#')[10]);
        	if(intemtype == (option.value).split('#')[10])
        		{
        		$("#strExternalDepartmentListId").val(option.value);	
        			
        		tempcount1 = 1 ;
        			 
        		}else{
        			$("#strExternalDepartmentListId option[value='"+option.value+"']").remove();
	        		
        			//$(this).remove();
        			//tempcount1=0;
        			
        		}
        	$("#strExternalDepartmentListId").prop("selectedIndex", 0);
        	
        	
        	else{
        			$("#drugDosageId").val('0');
        		}
            return option.value;
        });
		//console.log('::::::::::  '+tempcount1);
    	
		if(tempcount1 == 0)
		{
		$("#strExternalDepartmentListId").html('<option value="0#0#0#0#0#0#0#0#0#0">Select Department</option>');
		}
		
	});*/
	
	
	$(document).ready(function(){
		
		var patCompleteGeneralDtl = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		var reqFlg=patCompleteGeneralDtl.split('#')[18];
		var reqId=patCompleteGeneralDtl.split('#')[19];
		////console.log(reqFlg + ' ===  '+ reqId);
		if(reqFlg == '0'){
			$('.videocallList').hide();
			$('.eteleconsultancyViewDocclass').hide();
			$('#patientcomplaintid').hide();
			$('.opdTeleconsultationBtn').hide();
			
		}
		
	});
	
	function getpdffile(e ){
		
		var temp=e.value;
		$.ajax({url:'/HISDRDESK_MC/services/restful/Template/printpdf/',type:'POST',data:{fileName: temp.split('#')[0] , hosp_code : temp.split('#')[1] },success:function(result)
	    	{
			//console.log("----------------------");

			base64toPDF1(result.base64);

			}
	});
	}
	
	function getpdffile1(e ){
		
		var temp=e.value;
		//console.log(temp);
		$.ajax({url:'/HISDRDESK_MC/services/restful/Template/printpdf1/',type:'POST',data:{fileName: temp.split('#')[1] , hosp_code : temp.split('#')[0] },success:function(result)
	    	{
			//console.log("----------------------"+result.base64);
			


			
			
			var isChrome = navigator.userAgent.indexOf("Chrome") != -1;
			
			////console.log('isChrome '+isChrome);
			if(isChrome)
			{ 
				
				var pdfWindow = window.open("");
				
				pdfWindow.document.write("<object style='width:100vw; height:100vh' data='data:application/pdf, image/jpeg;base64"+result.base64+"'></object>");
				
			}
			else
			{		 
				
			 
			 window.open("data:application/pdf;base64, " + result.base64);
			 
			 
			} 
	
			
			//base64toPDF1(result.base64); // commented by ashutoshk to stop duplicate window opening while viewing file

			}
	});
	}
	
	function base64toPDF1(data) {
	    var bufferArray = base64ToArrayBuffer1(data);
	    var blobStore = new Blob([bufferArray], { type: "application/pdf" });
	    if (window.navigator && window.navigator.msSaveOrOpenBlob) {
	        window.navigator.msSaveOrOpenBlob(blobStore);
	        return;
	    }

	    var data = window.URL.createObjectURL(blobStore);
	    window.open(data);
	   /* var link = document.createElement('a');
	    document.body.appendChild(link);
	    link.href = data;
	    link.download = "file.pdf";
	    link.click();
	    window.URL.revokeObjectURL(data);
	    link.remove();*/
	}

	function base64ToArrayBuffer1(data) {
	    var bString = window.atob(data);
	    var bLength = bString.length;
	    var bytes = new Uint8Array(bLength);
	    for (var i = 0; i < bLength; i++) {
	        var ascii = bString.charCodeAt(i);
	        bytes[i] = ascii;
	    }
	    return bytes;
	};
	
	
	$('#clinicalServiceAreaId').change(function(){
		var ClinicalProcedureObj='';
		var jsonarray =[];
		var j=0;
	//	if(!localStorage.getItem('ClinicalProcedureObj'))
		var clinicalServiceAreaIdva=$('#clinicalServiceAreaId').val().split('^')[0];
		//console.log(clinicalServiceAreaIdva);
			ClinicalProcedureObj= JSON.parse( $("#ClinicalProcedureJsonObjDivOne").text().trim()); // JSON.parse(localStorage.getItem('ClinicalProcedureObj1')); 
		
			for (i = 0; i < ClinicalProcedureObj.length; i++) {
				 //console.log((ClinicalProcedureObj[i].testId).split('^')[6]);
				 var val1=(ClinicalProcedureObj[i].testId).split('^')[6];
				 if(val1 == clinicalServiceAreaIdva){
					 jsonarray[j]= ClinicalProcedureObj[i];
					 j++;
				 }
				} 
			 //localStorage.removeItem("ClinicalProcedureObj"); 
			 //console.log('ClinicalProcedureObj '+JSON.stringify(jsonarray));
			 $("#ClinicalProcedureJsonObjDiv").text(JSON.stringify(jsonarray));
			//localStorage.setItem('ClinicalProcedureObj',JSON.stringify(jsonarray));  
		
		
		});
	
	
	function  getDrugAdvice(){
		$('#drugInstructionsId1').val($('#strDrugsRemarksId').val());
		$('#drugAdvicesInstructionsModal1').modal('toggle');
	}
	
	function  getDrugAdvice1(){
		$('#externalDrugInstructionsId').val($('#strDrugsRemarksId1').val());
		$('#drugAdvicesInstructionsModal2').modal('toggle');
	}
	
	function countChar(val,id) {
	    var len = val.value.length;
	    ////console.log("id========="+id+"  len=="+len);
	    var maxlength = $(val).attr('maxlength');    
	    if (len > maxlength) {
	      val.value = val.value.substring(0, maxlength);
	    } else {
	      $('#'+id).text(maxlength - len);
	    }
	 }
	
	function getProcedure(){
		//$('#clinicalProcedureName').html('');
		$('#clinicalProcedureName').html(strClinicalProcedurehtml);
		var tempcount1=0;
		var intemtype=  ($('select[name=clinicalServiceArea] option:selected').val()).split("^")[0];
		
		var options = $('#clinicalProcedureName option');
        
		var values = $.map(options ,function(option) {
        	//console.log(intemtype +"  "+    (option.value).split('^')[6]);
        	if(intemtype == (option.value).split('^')[6])
        		{
        		$("#clinicalProcedureName").val(option.value);	
        			
        		tempcount1 = 1 ;
        			 
        		}else{
        			$("#clinicalProcedureName option[value='"+option.value+"']").remove();
	        		
        			//$(this).remove();
        			//tempcount1=0;
        			
        		}
        	$("#clinicalProcedureName").prop("selectedIndex", 0);
        	
            return option.value;
        });
		//console.log('::::::::::  '+tempcount1);
    	
		if(tempcount1 == 0)
		{
			$("#clinicalProcedureName").html('<option value="0">Select Procedure</option>');
		}
	}
	
	$('.emrPatDtl').click(function(e){
		let cr=$('#patCrNoPrescriptionPanel').text();
		
		let tkt=0;
		 if(localStorage.getItem("varSSOTicketGrantingTicketStoreage"))
			 tkt = localStorage.getItem("varSSOTicketGrantingTicketStoreage"); 
		 
		/*var action = '/emrdashboard/patientOverviewAction.cnt?hmode=DETAIL&crno='+cr+'&varSSOTicketGrantingTicket='+tkt;
		//console.log(action);
		var left=(screen.width-1400)/2;
		var top=(screen.height-1000)/2;
	    window.open(action,"popup","height=600,width=1000,left="+left+",top="+ top +",scrollbars=yes,location=no");*/
	    
	    $("#emrModal .modal-body").html('<iframe src="/emrdashboard/patientOverviewAction.cnt?hmode=DETAIL&crno='+cr+'&varSSOTicketGrantingTicket='+tkt+'" style="height:60vw;width:100%"></iframe>');
		$("#emrModal").modal("show");

		});
	
	function showHidePrescriptionDivmultiselect(objmultiselect,  arrSelected){
		var intervalTimeinMiliSecond=3000;
		var jsonAllBtn={"addCompleteHistoryBtn":"completeHistoryDiv",
			"addSystematicExaminationBtn":"systematicExaminationDiv",
			"addChronicDiseaseBtn":"chronicDiseaseDiv",
			"confidentilabtn":"confidentialDivId",
			"diagnosisNotebtn":"diagnosisNoteDivId",
			/*"addLabTest":"divInvestigationTile",*/
			"addProcedure":"divProcedureTile",
			"addTreatmentAdvice":"divTreatmentAdviceTile",
			"addAlergies":"allergiesModal"
			/*"addFollowUp":"divFollowUpTile"*/
		};
		var arrDivNotFound=[];
		$.each(jsonAllBtn,function(key,divToShow){
			var found=false;
			for(var i=0;i<arrSelected.length;i++){
				if(arrSelected[i]==key){
					found=true;
					break;
				}				
			}
			if(found){
				if($('#'+ divToShow).is(':visible')==false){
					$('#'+ divToShow).show().css({"background-color":"#FFF8E8"});
					//	$('#'+ divToShow).show().css({"background-color":"#FFF8E8", "padding-top": "100px"});
					//$(this).attr("href", "#"+divToShow);
					objmultiselect.$container.removeClass('open');
					var intervalId = window.setInterval(function(){
						$('#'+ divToShow).css("background-color","#fff");
					}, intervalTimeinMiliSecond);
					 $('html, body').animate({ scrollTop: $("#"+divToShow).offset().top-50}, 1000);
				}
			}	
			else{
				$('#'+ divToShow).hide();				
			}
		});		
		
	}
	function showProcessPopUps(selected){
		if(selected=='')
			return;
		//alert(selected);
		switch(selected) {
		   case "pastRx":
			  $('#opdEmrModal').modal('show');
		    break;
		   case "medicineHistory":
				  $('#medicineHistoryModal').modal('show');
				  hideUnideRepeatedDrug();
		    break; 
		   case "medicineStock":
				  $('#medicineStockModal').modal('show');
				  
				 var drugInstructionsArr=getTagFromLocalStorage("drugInstructions");
				 if(drugInstructionsArr.length==0){
					 drugInstructionsArr=drugInstructionTags;
					 localStorage.setItem("drugInstructions", JSON.stringify(drugInstructionsArr)); 
				 }
				 $("#stockDrugInstructionsId").autocomplete({source: drugInstructionsArr  });
			  
				 
				  checkForStockDrugAlreadyAdded();
			    break;	
		  case "opdEMR":
			  $('#TreeStructurePrescriptionModal').modal('show');
		    break;
		  case "vital":
			  ModifyVital(this,event)
		    break;
		  case "admissionAdvice":
			  OpenAdmissionadviceTemplate(this,event)
			    break;
		  case "sickFit":
			    // code block
			  alert("This section is under under maintenance")
			  break;
		  case "complaintTemplate":
			  OpenTemplate2("48#1");
			    break;
		  case "examinationTemplate":
			  OpenTemplate2("47#1");
			    break;
		  case "historyTemplate":
			  OpenTemplate2("46#1");
			    break;
		  case "otherTemplates":
			  OpenTemplate2("49#1");
			    break;
		} 
		//$("#chkmenu2").multiselect('clearSelection');		
	}
	
	function showHidePrescriptionDiv(objButton ){
		var divToShowHide= $(objButton).attr("data-divtoshow");
		var classname=""
		if($(objButton).hasClass('btngrp1')) {
			classname='btngrp1';		
		}
		if($(objButton).hasClass('btngrp2')) {
			classname='btngrp2';		
		}
		if($(objButton).hasClass('btngrp3')) {
			classname='btngrp3';		
		}
		
		$('.'+classname).each(function(){
			var divId=$(this).attr("data-divtoshow");
			if(divId!=divToShowHide && $(this).is(":visible")){
				$(this).find('i').removeClass("fa-minus").addClass("fa-plus");
				$('#'+ divId).hide();
			}
		});
		
		$(objButton).find('i').toggleClass('fa-plus fa-minus');
		$('#'+ divToShowHide).slideToggle();
		
		/*var jsonAllBtn={"addCompleteHistoryBtn":"completeHistoryDiv",
				"addSystematicExaminationBtn":"systematicExaminationDiv",
				"addChronicDiseaseBtn":"chronicDiseaseDiv",
				"confidentilabtn":"confidentialDivId",
				"diagnosisNotebtn":"diagnosisNoteDivId",				
				"addProcedure":"divProcedureTile",
				"addTreatmentAdvice":"divTreatmentAdviceTile",
				"addAlergies":"allergiesModal"				
			};*/
	}
	 
	function togglePrescriptionAccordion(){
		
		var dataTarget= $(this).attr("data-target");
		
		if($( dataTarget).is(":visible")==false){
			$(this).find('i').removeClass('fa-plus').addClass('fa-minus');
			$(this).removeClass('accordionCollapse').addClass('accordionbtnExpended');			
		}else{
			$(this).find('i').removeClass('fa-minus').addClass('fa-plus');
			$(this).removeClass('accordionbtnExpended').addClass('accordionCollapse');			
		}
		
		//$(this).find('i').toggleClass('fa-plus fa-minus');
		//$(this).toggleClass('accordionCollapse accordionbtnExpended');
	}
	function getInternalDepartment(){
		
		
			$('#refferlPatientDeptId').html("<option value='' selected>Select Department</option>");
			
			var deptCode=$('#deptUnitName').val().split("#")[1];
			var data={hmode:"populateReffralDeptCmb",strHiddenDeptCode:deptCode};
			$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
				dataType: "json",
				data:data,	
				type: "POST",
				success:function(result){ 
					//alert(JSON.stringify(result));	
					$.each(result, function(indx, rowObj){
						var optionValue=rowObj["column_1"]
						var optionText=rowObj["deptname"]
						$('#refferlPatientDeptId').append("<option value='"+optionValue+"'>"+optionText+"</option>");
					});
					//alert($('#refferlPatientDeptId').html());
				}
			});
		
		
	}



function getUniqueId()
{
	uniqueId= Date.now().toString() + Math.floor(Math.random() * 1000000).toString();
	return uniqueId;
}
function ValidateAndAddInternalRefral(){
	
	if($('#refferlPatientDeptId').val()==""){
		swal('Please select Referal department');
		return false;
	}
	
	var refferlPatientDeptId= ($('#refferlPatientDeptId option:selected').val()).split('#')[0];
	
	var key="int-"+refferlPatientDeptId;
	
	if($('#btndelInternalRow_'+key).length>0){
		swal('This department is already added');
		return false;
	}
	var strReffralDepttext=($('#refferlPatientDeptId option:selected').text());
	var strShowData=strReffralDepttext ;
	var reffralJson ={
	    "strReffralDeptCmb": refferlPatientDeptId,
	    "strReffralDepttext": strReffralDepttext,
	    "strReferralStatus": "1",
	    "strreferralTypeName": "Internal",
	    "strReffralReason": $('#refferalResonId').val().trim(),
	    "strReffralDeptDone": $('#refferlPatientDeptId option:selected').val(),
	    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
	    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text()
	}
	
	
	createInternalReferralRow(reffralJson);
	$('#refferlPatientDeptId').val("");
	$('#refferalResonId').val("");
	
	
}
function createInternalReferralRow(reffralJson){
	var key="int-"+reffralJson["strReffralDeptCmb"];
	var html='<tr><td>'+reffralJson["strReffralDepttext"]+'</td>';
	html+='<td>'+reffralJson["strReffralReason"]+'</td>';
	html+='<td>';
	html+='<button style="padding:4px 12px;margin:1px;" id="btndelInternalRow_'+key+'" class="btn btn-danger btn-sm" type="button">x</button>';
	html+='<span id="internalReffralJson_'+key+'" style="display :none">'+JSON.stringify(reffralJson)+'</span></td>';
	html+='</tr>';
	$('#TransferListTable tbody').append(html);
	$('#divInternalReffralList').show();
	
	//$('[name=referralStatus]').prop("disabled", true);
	$('#btndelInternalRow_'+key).click(function(){
		$(this).closest('tr').remove();
		if($('#TransferListTable tbody tr').length==0){
			$('#divInternalReffralList').hide();
		//	$('#referralStatus1').prop("disabled",  false);
			$('[name=referralStatus]').prop("disabled", false);
		}
	});
}



function scrollToDiv(divToShow){
	var intervalTimeinMiliSecond=3000;
	if($('#'+ divToShow).is(':visible')==false){
		$('#'+ divToShow).show().css({"background-color":"#FFF8E8"});
		var intervalId = window.setInterval(function(){
			$('#'+ divToShow).css("background-color","transparent");
		}, intervalTimeinMiliSecond);
		 $('html, body').animate({ scrollTop: $("#"+divToShow).offset().top-50}, 1000);
	}
	
}

function loadRX(objbtn){
	var dt=$(objbtn).attr('data-date');
	var profileId= parseInt($(objbtn).attr('data-btnindx'));
	dt=dt.split("{")[0];
	var val="";
	//alert("inside loadRX");
	var indx=0;
	$('#checkLastThreeVisitDivId option').each(function(){
		
		if(val=="" && dt.trim()==$(this).text().trim() && profileId==indx){
			val=$(this).val();
		}
		indx++;
	});
	$('#opdEmrModal').modal('hide');
	
	swal({
        title: "Confirm !",
        text: "Are you sure want to add to new Rx?",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
    .then((isOkay) => {
    	console.log("isOkay2=="+isOkay);
        if (isOkay) {
        	box = true;
        	$( ".clearAllValues" ).click();
        	$('#drugAdviceListTable tbody').empty();
        	$('#TransferListTable tbody').empty();
        	
        	$('#referralStatus2').prop("checked", true);
        	$('#referralStatus2').trigger('click');
			profileArrayId =[];
 			profileArrayId[profileArrayId.length]=profileId;
 			//if(localStorage.getItem("lastThreeVisitJson_"+profileId))
 			//alert("check 2")
			//alert(profileId);
			//alert($("#pastrx_"+profileId).text());
 			if($("#pastrx_"+profileId).text()!='')
 				getPrescriptionProfileData(JSON.parse($("#pastrx_"+profileId).text().trim()));	
 			//console.log("getPrescription  >>  >>  ");
        }
    	});
}
function addNewRegisteredDrug(){
		
		if($("#drugJsonObjDiv").text().trim()==''){
			swal('Please select drug name from list');
			return;
		}
		//alert($("#drugJsonObjDiv").text().trim());	
		var  selectedDrugJson=JSON.parse($("#drugJsonObjDiv").text().trim());
		
		var drugName = selectedDrugJson["drugName"];
		var drugBrandId = selectedDrugJson["drugBrandId"];
		var drugId = selectedDrugJson["drugId"]+"#"+drugBrandId;
		
		
		
		var drugDosage = $('#doseQty').val() +" "+selectedDrugJson["drugForm"]  //$('[name=drugDosage] option:selected').text();
			
		 var drugDosageID = $('#doseQty').val(); //$('[name=drugDosage]  option:selected').val().split('^')[0];
		 var drugFrequencyId = $('[name=drugFrequency]').val();
		 
		 var drugFrequency = $('[name=drugFrequency] option:selected').text();
		 
		 if(drugFrequencyId=="-1"){
			if($('#drugFrequencyText').val().trim()==""){
				swal("Please Enter Drug frequency")
				return;
			}
			else{				
				drugFrequency=$('#drugFrequencyText').val().trim();
				storeTagInLocalStorage("customDrugFrequencyText", drugFrequency);
			}
		 }else if(drugFrequencyId=="0"){
			drugFrequency='--';
		 }
		 
		 // alert(drugFrequency+drugFrequencyId);
		 var drugStartDate = $('[name=drugStartDate]').val();
		 var drugDays = $('[name=drugDays]').val();
		 var drugQuantity = $('[name=drugQuantity]').val(); 
		 var drugInstructions = $('[name=drugInstructions]').val();
		 var refferedBy = $('[name=refferedBy]').val();
		 
		 var tmp = 0; 
		
		
		$('input[name=drugsAdvices]').each(function(){
			if(tmp==0 && $(this).val().trim().split('&&')[1]==drugId.trim())
			{	tmp = 1; 
				return false;  
			}
		});
		
		if(validatePrescribedQuantity( "drugQuantity",selectedDrugJson)==false){
			return false;
		}
		
		
	    if (isNaN(drugDays)) {
		 swal("Days Must be Numeric value!");
		 return false;
	   } 
	    if(tmp==1)  //if(tmp==1) due to progressive drug doase
		{ 
	    	 swal("The drug is already advised today!!");
	    	 $(this).parent().parent().parent().find('input[name=drugName]').val(''); 
	    	 return false;
		}

		
		 if(drugName.trim()!='')  
		 {    
	 			drugDays= (drugDays=='') ? '0' : drugDays ;
	 			////console.log('drugDays::::::::'+drugDays);
	 			drugQuantity= (drugQuantity == '') ? '0' :drugQuantity;
			var HiddenDrugAdvice=drugName+'&&'+drugId+'&&'+drugDosage+'&&'+drugDosageID+'&&'+drugFrequency+'&&'+drugFrequencyId+'&&'+drugStartDate+'&&'+drugDays+'#'+drugQuantity+'&&'+drugInstructions+'&&'+$('#patEpisodeCodePrescriptionPanel').text()+'&&'+$('#patEpisodeVisitNoPrescriptionPanel').text()+'&&NEW'; //drugInstructions
			////console.log('HiddenDrugAdvice::::::::'+HiddenDrugAdvice);
			
			storeTagInLocalStorage("drugDays", drugDays);
 			storeTagInLocalStorage("DrugQuantity", drugQuantity);	
 			storeTagInLocalStorage("refferedBy", refferedBy);
 			storeTagInLocalStorage("drugInstructions", drugInstructions);
			var uniqueId= getUniqueOPDId();
			var DrugJson =selectedDrugJson;
			
			/*adding extra data */
			DrugJson["uniqueId"]=uniqueId;
			DrugJson["IsExterNal"]="0";
			DrugJson["drugDosage"]=drugDosage;
			DrugJson["drugDosageId"]=drugDosageID;
			DrugJson["drugFrequency"]=drugFrequency;
			DrugJson["drugFrequencyId"]=drugFrequencyId;
			DrugJson["drugStartDate"]=drugStartDate;
			DrugJson["drugDays"]=drugDays;
			DrugJson["patientDrugQuantity"]=drugQuantity;
			DrugJson["drugInstructions"]=drugInstructions;
			DrugJson["CR_No"]=$('#patCrNoPrescriptionPanel').text();  
			DrugJson["EpisodeCode"]=$('#patEpisodeCodePrescriptionPanel').text() ;
			DrugJson["VisitNo"]=$('#patEpisodeVisitNoPrescriptionPanel').text() ;
			DrugJson["hospitalCode"]=$('#patHospitalCodePrescriptionPanel').text();
			DrugJson["seatId"]=$('#patSeatIdPrescriptionPanel').text();			
			DrugJson["Mode"]="NEW";
			DrugJson["HiddenDrugAdvice"]=HiddenDrugAdvice;
			DrugJson["modeVal"]="1";
			DrugJson["isEditable"]="1";
			DrugJson["refferedBy"]=refferedBy;
			
			//alert(JSON.stringify(DrugJson));
			BlockQty(DrugJson);
			
			$('[name=drugName]').val('');
			$('[name=flexdatalist-drugName]').val('');
			$('input[name=flexdatalist-drugName]').css('background-color','#FFFFFF');
			$('#doseQty').val('1');
			$('#spanDrugForm').text('-')
			$('[name=drugInstructions]').val("");
			//$('[name=drugQuantity]').val("");
			$('#isManualEntryDone').val("0")
			 if(drugFrequencyId=="-1"){
				$('[name=drugFrequency]').val("0");
				$('#drugFrequencyText').val("").hide();	
			 }
				
			
		}
		else
			swal('Drug name is required');
}

function addStockDrug(){
	var key=$(this).attr('id').split("_")[1];
	//alert(key);
	//alert($("#stockdrugjson_"+key).text().trim());	
	var  selectedDrugJson=JSON.parse($("#stockdrugjson_"+key).text().trim());
	
	var drugName = selectedDrugJson["drugName"];
	var drugBrandId = selectedDrugJson["drugBrandId"];
	var drugId = selectedDrugJson["drugId"]+"#"+drugBrandId;
	
	var reason =0; var drugMode='';
	
	 
	var drugDosage = $('#stockdoseQty').val() +" "+selectedDrugJson["drugForm"]  
	
		
	 var drugDosageID = $('#stockdoseQty').val(); 
	 
		 		 
	


		 if(drugFrequencyId=="-1"){
			$('[name=drugFrequency]').val("0");
			$('#drugFrequencyText').val("").hide();	
		 }
		
	 
	 
	 
	 var drugFrequencyId = $('[name=stockDrugFrequency]').val();
	 var drugFrequency = $('[name=stockDrugFrequency] option:selected').text();
	  
	  if(drugFrequencyId=="-1"){
	  	if($('#stockDrugFrequencyText').val().trim()==""){
	  		swal("Please Enter Drug frequency")
	  		return;
	  	}
	  	else{				
	  		drugFrequency=$('#stockDrugFrequencyText').val().trim();	  		
	  		storeTagInLocalStorage("customDrugFrequencyText", drugFrequency);
	  	}
	   }else if(drugFrequencyId=="0"){
	  		drugFrequency='--';
	   }
	 
	 var drugStartDate = $('[name=stockDrugStartDate]').val();
	 var drugDays = $('[name=stockDrugDays]').val();
	 var drugQuantity = $('[name=stockDrugQuantity]').val(); 
	 var drugInstructions = $('[name=stockDrugInstructions]').val();
	 var refferedBy = $('[name=stockRefferedBy]').val();
	 
	 var tmp = 0; 
	
	 $('#stockdoseQty').val(drugDosageID);
  	 $('[name=stockDrugFrequency]').val(drugFrequencyId);
  	$('[name=stockDrugDays]').val(drugDays);
  	//$('[name=stockDrugQuantity]').val(drugQuantity);

	
	$('input[name=drugsAdvices]').each(function(){
		if(tmp==0 && $(this).val().trim().split('&&')[1]==drugId.trim())
		{	tmp = 1; 
			return false;  
		}
	});
	
	
	if(validatePrescribedQuantity("stockDrugQuantity",selectedDrugJson)==false){
				return false;
	}
    if (isNaN(drugDays)) {
	 swal("Days Must be Numeric value!");
	 return false;
   } 
    if(tmp==1)  //if(tmp==1) due to progressive drug doase
	{ 
    	 swal("The drug is already advised today!!");
    	 $(this).parent().parent().parent().find('input[name=drugName]').val(''); 
    	 return false;
	}

	
	 
	 if(drugName.trim()!='')  
	 {    
 			drugDays= (drugDays=='') ? '0' : drugDays ;
 			////console.log('drugDays::::::::'+drugDays);
 			drugQuantity= (drugQuantity == '') ? '0' :drugQuantity;
		var HiddenDrugAdvice=drugName+'&&'+drugId+'&&'+drugDosage+'&&'+drugDosageID+'&&'+drugFrequency+'&&'+drugFrequencyId+'&&'+drugStartDate+'&&'+drugDays+'#'+drugQuantity+'&&'+drugInstructions+'&&'+$('#patEpisodeCodePrescriptionPanel').text()+'&&'+$('#patEpisodeVisitNoPrescriptionPanel').text()+'&&NEW'; //drugInstructions
		////console.log('HiddenDrugAdvice::::::::'+HiddenDrugAdvice);
		var uniqueId= getUniqueOPDId();
		
		storeTagInLocalStorage("drugDays", drugDays);
		storeTagInLocalStorage("DrugQuantity", drugQuantity);	
		storeTagInLocalStorage("refferedBy", refferedBy);
		storeTagInLocalStorage("drugInstructions", drugInstructions);
		
		var DrugJson =selectedDrugJson;
		
		/*adding extra data */
		DrugJson["uniqueId"]=uniqueId;
		DrugJson["IsExterNal"]="0";
		DrugJson["drugDosage"]=drugDosage;
		DrugJson["drugDosageId"]=drugDosageID;
		DrugJson["drugFrequency"]=drugFrequency;
		DrugJson["drugFrequencyId"]=drugFrequencyId;
		DrugJson["drugStartDate"]=drugStartDate;
		DrugJson["drugDays"]=drugDays;
		DrugJson["patientDrugQuantity"]=drugQuantity;
		DrugJson["drugInstructions"]=drugInstructions;
		DrugJson["CR_No"]=$('#patCrNoPrescriptionPanel').text();  
		DrugJson["EpisodeCode"]=$('#patEpisodeCodePrescriptionPanel').text() ;
		DrugJson["VisitNo"]=$('#patEpisodeVisitNoPrescriptionPanel').text() ;
		DrugJson["hospitalCode"]=$('#patHospitalCodePrescriptionPanel').text();
		DrugJson["seatId"]=$('#patSeatIdPrescriptionPanel').text();			
		DrugJson["Mode"]="NEW";
		DrugJson["HiddenDrugAdvice"]=HiddenDrugAdvice;
		DrugJson["modeVal"]="1";
		DrugJson["isEditable"]="1";
		DrugJson["refferedBy"]=refferedBy;
		
		//alert(JSON.stringify(DrugJson));
		BlockQty(DrugJson);
		$('[name=stockDrugInstructions]').val('');
		$('#stockdoseQty').val(drugDosageID);
	  	$('[name=stockDrugFrequency]').val(drugFrequencyId);
	  	$('[name=stockDrugDays]').val(drugDays);
	  	$('[name=stockDrugQuantity]').val(drugQuantity);		
		$('#isManualEntryDoneStock').val("0")
				
	}
}

/*External Drug Entry*/
function addNewExternalDrug(){
	 
	 var drugName1 = $('[name=externalDrugName]').val();
		var drugName =  drugName1.toUpperCase(); 
		 	
		var arrExtItemType=$("#extItemType").val().split("^");
			
		 var drugDosageID = $('#doseQty').val();
		 drugDosage=$('#doseQty').val() +" "+arrExtItemType[1];
		 var drugFrequencyId = $('[name=externalDrugFrequency]').val();
		 var drugFrequency = $('[name=externalDrugFrequency] option:selected').text();
		 		 
		 if(drugFrequencyId=="-1"){
	 			if($('#externalDrugFrequencyText').val().trim()==""){
	 				swal("Please Enter Drug frequency")
	 				return;
	 			}
	 			else{				
	 				drugFrequency=$('#externalDrugFrequencyText').val().trim();
	 				storeTagInLocalStorage("customDrugFrequencyText", drugFrequency);
	 			}
	 			
		  }else if(drugFrequencyId=="0"){
		 		drugFrequency='--';
		  }
				 
		 
		
			 
		// alert(drugFrequency+drugFrequencyId);
		 var drugStartDate = $('[name=externalDrugStartDate]').val();
		 var drugDays = $('[name=externalDrugDays]').val();   
		 var externalDrugQuantity = $('[name=externalDrugQuantity]').val(); 
		 var drugInstructions = $('[name=externalDrugInstructions]').val();
		 var refferedBy = $('[name=externalRefferedBy]').val();
		 
		 

		 if(drugName.trim()!='' ) //&& drugInstructions.trim()!='' && drugDosage.trim()!='' && drugStartDate.trim()!='' && drugDays.trim()!=''
		 {  
			//console.log('drugDays::::::::'+drugDays);
			drugDays= (drugDays=='') ? '0' : drugDays ;
	 			//console.log('drugDays::::::::'+drugDays);
				
	 			if(externalDrugQuantity==''  ){
					swal("Quantity entry required!!");
					return false;
				}
	 			if (isNaN(drugDays)) {
					swal("Days Must be Numeric value!");
					return false;
				  }
	 			externalDrugQuantity= (externalDrugQuantity == '') ? '0' :externalDrugQuantity;
	 			
	 			
 		
 			storeTagInLocalStorage("drugDays", drugDays);
 			storeTagInLocalStorage("DrugQuantity", externalDrugQuantity);	
 			storeTagInLocalStorage("refferedBy", refferedBy);
 			storeTagInLocalStorage("drugInstructions", drugInstructions);
			var HiddenDrugAdvice=drugName+'&&'+'100#100#100#100#100'+'&&'+drugDosage+'&&'+drugDosageID+'&&'+drugFrequency+'&&'+drugFrequencyId+'&&'+drugStartDate+'&&'+drugDays+'#'+externalDrugQuantity+'&&'+drugInstructions; //drugInstructions
			var uniqueId= getUniqueOPDId();
			var arrStatusWiseQty= new Array();
			var stJson={"status": "NA", "statusQty":externalDrugQuantity}
			arrStatusWiseQty.push(stJson);					
							
							
			var DrugJson= {
				    "drugId": "100",
				    "drugName": drugName,
					"isQuantityCalculated": arrExtItemType[2],
					"drugForm": arrExtItemType[1],
				    "drugStatus": "0",
				    "programId": "0",
				    "programName": "-",
				    "color": "BLACK",
				    "drugQuan": "0",
				    "programDisplayName": "-",
				    "quantityDisplay": "-",
				    "itemTypeId": arrExtItemType[0],
				    "code": "-",
				    "drugBrandId": "100",
				    "uniqueId":uniqueId,
				    "IsExterNal"	:		"1" ,
				    "drugDosage":drugDosage,
				    "drugDosageId":drugDosageID,
				    "drugFrequency":drugFrequency,
				    "drugFrequencyId":drugFrequencyId,
				    "drugStartDate":drugStartDate,
				    "drugDays":drugDays,
				    "patientDrugQuantity":externalDrugQuantity,
				    "drugInstructions":drugInstructions,
				    "CR_No":$('#patCrNoPrescriptionPanel').text(),
				    "EpisodeCode":$('#patEpisodeCodePrescriptionPanel').text(),
				    "VisitNo":$('#patEpisodeVisitNoPrescriptionPanel').text(),
				    "hospitalCode":$('#patHospitalCodePrescriptionPanel').text(),
				    "seatId":$('#patSeatIdPrescriptionPanel').text(),
				    "Mode":"NEW",
				    "HiddenDrugAdvice":HiddenDrugAdvice,
				    "isEditable":"1",
				    "refferedBy":refferedBy,
					"drugDispenceStatusWiseQty":arrStatusWiseQty				    	 
				} 
				
			createDrugMultiRow(DrugJson);
			
		 
			 $('[name=externalDrugName]').val('');
			 $('#extDoseQty').val("1");
			 $('#spanExtDrugForm').text("-"); 
			 $("#extItemType").val("0")
			 document.getElementById('externalDrugStartDate').valueAsDate = new Date();
			 $('[name=externalDrugInstructions]').val("");
			 if(drugFrequencyId=="-1"){
 				$('[name=externalDrugFrequency]').val("0");
 				$('#externalDrugFrequencyText').val("").hide();	
 			 }
			 //$('[name=externalDrugQuantity]').val(""); 
			 $('#isManualEntryDoneExternal').val("0")
			 	 			 
		 }
		 else
			 swal('Drug name is required');
}



function createDrugMultiRow(DrugJson){
	
	var patientDrugQuantity=DrugJson["patientDrugQuantity"];
	
	if(patientDrugQuantity!=undefined && isNaN(patientDrugQuantity)==false){
		patientDrugQuantity=parseInt(patientDrugQuantity);			
	}
	else{
		console.log("invalid patientDrugQuantity");
		return
	}
	
	if(patientDrugQuantity>999){
		alert("Drug Quantity too large")
		return;
	}
	
	var uniqueId= getUniqueOPDId();
	//alert(uniqueId);
	var medicineHistoryPrescribedByJson=null
	if(DrugJson["medicineHistoryPrescribedByJson"]!=undefined){
		//var medicineHistoryPrescribedByJson={"patConsultantName": "","departmentName":"","hospitalName":"", "visitDate":""};
		if(DrugJson["medicineHistoryPrescribedByJson"]["patConsultantName"]!=$('#strConsultantName').val())
			medicineHistoryPrescribedByJson=DrugJson["medicineHistoryPrescribedByJson"];
	}
	var refferedBy= DrugJson["refferedBy"]==undefined? "": DrugJson["refferedBy"];
	//alert("drugDispenceStatusWiseQty>>" +DrugJson["drugDispenceStatusWiseQty"])
	if(DrugJson["drugDispenceStatusWiseQty"] !=null && DrugJson["drugDispenceStatusWiseQty"]!=undefined){
			var statusHTML="";
			if(DrugJson["drugDispenceStatusWiseQty"].length==1){
				statusHTML=DrugJson["drugDispenceStatusWiseQty"][0]["status"];
			}
			else{
				$.each(DrugJson["drugDispenceStatusWiseQty"], function(key, statusJson){
					statusHTML+=statusJson["status"] + " Qty-" + statusJson["statusQty"] + "</br>";	
				});
				
			}	
			
			var html='<tr> <td style="text-align: center;display:none;">';
			html+='<input type="checkbox" class="checkedInput" name="drugsAdvices" value="'+DrugJson["HiddenDrugAdvice"]+'"  checked>';
			html+='<i class="text1" id="drugjson_'+uniqueId+'" style="display :none">'+JSON.stringify(DrugJson)+' </i></td>';
			html+='<td style="text-align: left;">'+DrugJson["drugName"]+'</td>';
			html+='<td style="text-align:center">'+DrugJson["drugDosage"]+'</td>'
			html+='<td style="text-align:center">'+DrugJson["drugFrequency"]+'</td>';
			html+='<td style="display:none;">'+DrugJson["drugStartDate"]+'</td>';
			html+='<td style="text-align:center">'+DrugJson["drugDays"]+'</td>';
			html+='<td style="text-align:center">'+DrugJson["patientDrugQuantity"]+'</td>';
			html+='<td style="text-align:center;">'+statusHTML+'</td>';
			html+='<td style="text-align: left;">'+refferedBy+'</td>';
			html+='<td style="text-align: left;">'+DrugJson["drugInstructions"]+'</td>';
				
			html+='<td style="text-align:center;">'
			//alert(DrugJson["isEditable"])	
			if(DrugJson["isEditable"]!=undefined && DrugJson["isEditable"]=="1"){
				html+='<button class="btn btn-info btn-xs" id="drugEditBtn_'+uniqueId+'" title="Edit Drug details" type="button"><i class="fa fa-edit"></i></button> &nbsp;';
				html+='<button class="btn btn-danger btn-xs" id="drugDeleteBtn_'+uniqueId+'" title="Delete Drug details"  type="button"><i class="fa fa-trash"></i></button>';
				if(medicineHistoryPrescribedByJson!=null)
					html+='<a class="btn btn-info btn-xs" id="drugShowRxByBtn_'+uniqueId+'" title="View Drug prescribed By doctor"  type="button">Rx By</a>';	
			}else{
				//alert(DrugJson.orderedQty);
				html+='<span style="color:red">Ordered/Issued Qty-'
				if(DrugJson.orderedQty!="0")
					html+=DrugJson.orderedQty+' </span>';
				else if(DrugJson.issueQty!="0")
					html+=DrugJson.issueQty+' </span>';	
				
			}
			
			html+='</td>';
			html+='</tr>';
			if(medicineHistoryPrescribedByJson!=null){
				html+='<tr id="trprescribedby_'+uniqueId+'" style="display:none;">';		
				html+="<td class='text-primary' colspan='7' style='padding: 5px;font-weight:bold;padding-top: 10px;text-align:left'>" +
						"<span>Consultant : "+medicineHistoryPrescribedByJson["patConsultantName"]+
						"&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;" +
						"Speciality : "+medicineHistoryPrescribedByJson["departmentName"]+
						"&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; " +
						"Wellness Center : "+medicineHistoryPrescribedByJson["hospitalName"]+
						"&nbsp;&nbsp;&nbsp;  |&nbsp;&nbsp;&nbsp;   " +
						"Prescription Date : "+medicineHistoryPrescribedByJson["visitDate"]+"</span></td>";
				html+="<td style='padding: 5px;font-weight:bold;padding-top: 10px;text-align:center'>" +
						"<a class='btn btn-info btn-xs' id='drugHideRxByBtn_"+uniqueId+"'>hide</a>" +
						"</td>";
				html+='</tr>';
			}
		
		    $('#drugAdviceListTable').children('tbody').append(html);
		    $('#drugAdviceListTable').show();
		    $('input[name=flexdatalist-drugName]').closest('.input-group').find('.input-group-btn').show();
		    $('input[name=flexdatalist-drugName]').attr("readonly", false);
		    
		    $('#drugShowRxByBtn_'+uniqueId).click(function(){
		    	var key=$(this).attr("id").split("_")[1];
		    	$('#trprescribedby_'+ key).show();
		    	$('#drugShowRxByBtn_'+ key).hide();    	
		    });
		    
		    $('#drugHideRxByBtn_'+uniqueId).click(function(){
		    	var key=$(this).attr("id").split("_")[1];
		    	$('#trprescribedby_'+ key).hide();
		    	$('#drugShowRxByBtn_'+ key).show();
		    });
		    
		    $('#drugDeleteBtn_'+uniqueId).click(function(){
		    	var flag= confirm('Are you sure want to delete drug?');
		    	if(flag==false)
		    		return;
		    	var key=$(this).attr("id").split("_")[1];
		    	var firsttdObj=$(this).parent().parent().find('td').eq(0);
		     	var json= JSON.parse($(firsttdObj).find('.text1').html());
		     	UnblockQty(json);
		    	$(this).closest('tr').remove();
		    	if($("#trprescribedby_"+key).length>0)
		    		$("#trprescribedby_"+key).remove();
		    	
		    	if($("[id^=drugDeleteBtn_]").length==0){
		    		$('#drugAdviceListTable').hide();
		    	}
		    });
			$('[id^=drugEditBtn_]').show();
			$('[id^=drugDeleteBtn_]').show();
		    $('#drugEditBtn_'+uniqueId).click(function(){
		    	$('[id^=drugEditBtn_]').hide();
				$('[id^=drugDeleteBtn_]').hide();
		    	//console.log('inside drugEditBtn 1')
			    var firsttdObj=$(this).parent().parent().find('td').eq(0);
		    	var json= JSON.parse($(firsttdObj).find('.text1').html());
		    	
		    	var drugName = json["drugName"];
				var drugDosage = json["drugDosage"];
				var drugFrequency = json["drugFrequency"]
				//var drugStartDate = json["drugStartDate"]; 
				var drugDays = json["drugDays"]; 
				var drugQuantity = json["patientDrugQuantity"]; 
				var instructions = json["drugInstructions"]; 
				
				UnblockQty(json);
				if(json["IsExterNal"]=="0"){
					$('input[name=drugName]').val(drugName);
					$('input[name=flexdatalist-drugName]').val(drugName).attr("readonly", true);
					$('select[name=drugDosage]').val($('select[name=drugDosage] option:contains('+drugDosage+')').val());
					$('select[name=drugFrequency]').val($('select[name=drugFrequency] option:contains('+drugFrequency+')').val());
					$('input[name=drugDays]').val(drugDays);
					$('input[name=drugQuantity]').val(drugQuantity);
					$('textarea[name=drugInstructions]').val(instructions);
					$('#drugInstructionsId1').val(instructions);			
					$('input[name=flexdatalist-drugName]').closest('.input-group').find('.input-group-btn').hide();
					$("#drugJsonObjDiv").text(JSON.stringify(json));
		    	}
				else{
					
					$('input[name=externalDrugName]').val(drugName);
			 		$('select[name=externalDrugDosage]').val($('select[name=externalDrugDosage] option:contains('+drugDosage+')').val());
			 		$('select[name=externalDrugFrequency]').val($('select[name=externalDrugFrequency] option:contains('+drugFrequency+')').val());
			 		$('input[name=externalDrugDays]').val(drugDays); 
			 		$('input[name=externalDrugQuantity]').val(drugQuantity);   
			 		$('input[name=externalDrugInstructions]').val(instructions);
			 		
				}
				$(this).parent().parent().remove();
		    }); 
		     
			 $("#drugJsonObjDiv").empty();
			 $('input[name=flexdatalist-drugName]').val("").attr("readonly", false);
			 checkForStockDrugAlreadyAdded();
	 }
  }
		



function getUniqueOPDId()
{
	uniqueId= Date.now().toString() + Math.floor(Math.random() * 1000000).toString();
	return uniqueId;
}

function BlockQty(DrugJson){
	
	//alert("BlockQty called ");
	if(DrugJson["IsExterNal"]=="0"){
		
		var patientDrugQuantity=DrugJson["patientDrugQuantity"]
		if(patientDrugQuantity!=undefined && isNaN(patientDrugQuantity)==false){
			patientDrugQuantity=parseInt(patientDrugQuantity);			
		}
		else{
			console.log("invalid patientDrugQuantity");
			return
		}
		
		if(patientDrugQuantity>999){
			alert("Drug Quantity too large")
			return;
		}
		DrugJson["modeVal"]="1";				
		$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/blockReleaseStoreQuantity',
			type:'POST',
			data:JSON.stringify(DrugJson),
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success:function(result)
	    {
			//alert(JSON.stringify(result))
			DrugJson["modeVal"]="";
			if(result["status"]=="SUCCESS"){
				var issuestatus =result["issuestatus"];
				var arr= issuestatus.split("#");
				var arrStatusWiseQty=new Array();
				for(var i=0;i<arr.length;i++){
					var st=arr[i].split("^");
					var stJson={"status": st[0], "statusQty":st[1]}
					arrStatusWiseQty.push(stJson);
				}
				DrugJson["drugDispenceStatusWiseQty"]=arrStatusWiseQty;
				
				
				createDrugMultiRow(DrugJson);
			}
			else{
				alert("problem while blocking quantity")
			}
			
				
	    } ,
	    error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	     }
	    	
		});
		
	}
	else{
		createDrugMultiRow(DrugJson);
	}
}

function UnblockQty(DrugJson){
	
	if(DrugJson["IsExterNal"]=="0"){
		DrugJson["modeVal"]="2";
		$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/blockReleaseStoreQuantity',
			type:'POST',
			data:JSON.stringify(DrugJson),
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success:function(result)
	    {
			//alert(JSON.stringify(result))
			DrugJson["modeVal"]="";
				
	    } ,
	    error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	     }
	    	
		});
	}
}
function loadPreviousDrugs(DrugJsonArray,drugIssuedDetailJson){
	//alert("inside loadPreviousDrugs");
	if(DrugJsonArray!=undefined &&  DrugJsonArray.length!=null)
	{
	//	var flag = 0;
		DrugJsonArray.forEach(function(item,index){
			item.uniqueId=getUniqueOPDId();
			/*checking */
			if($('input[name=drugsAdvices]').length>0){
				var tmp=0;
				var drugId =item["HiddenDrugAdvice"].trim().split('&&')[1].trim();
				$('input[name=drugsAdvices]').each(function(){
					var val=$(this).val().trim().split('&&')[1]
					if(tmp==0 && val==drugId)
					{	tmp = 1; 
						return false;  
					}
				});		
				if(tmp==1) 
				{
					return;
				}
			}
			var today = new Date();
			var dd = today.getDate();
	
			var mm = today.getMonth()+1; 
			var yyyy = today.getFullYear();
			if(dd<10) 
			{
			    dd='0'+dd;
			} 
	
			if(mm<10) 
			{
			    mm='0'+mm;
			} 
			today = yyyy+'-'+mm+'-'+dd;
			item.drugStartDate=today;
			item.uniqueId=index;
			item.CR_No=$('#patCrNoPrescriptionPanel').text();
			
			var drugEpisode=item["EpisodeCode"]!=undefined ?item["EpisodeCode"]:"0";
			var drugVisitNo=item["VisitNo"]!=undefined ?item["VisitNo"]:"0";
			var drugHospitalCode=item["hospitalCode"]!=undefined ?item["hospitalCode"]:"0";
			
			var currentEpisodeCode=$('#patEpisodeCodePrescriptionPanel').text();
			var currentVisitNo=$('#patEpisodeVisitNoPrescriptionPanel').text();
			var currentHospitalCode=$('#patHospitalCodePrescriptionPanel').text();
			var drugQuan=item["drugQuan"]==""?"-1" : item["drugQuan"];
		//	alert("drugEpisode>>>" + drugEpisode + "==" + currentEpisodeCode +  (drugEpisode==currentEpisodeCode));
			//alert("drugVisitNo>>>" + drugVisitNo + "==" + currentVisitNo +  (drugVisitNo==currentVisitNo));
			//alert("drugHospitalCode>>>" + drugHospitalCode + "==" + currentHospitalCode +  (drugHospitalCode==currentHospitalCode)); 
			var flagBlock=true;
			if(drugEpisode==currentEpisodeCode 
				&& drugVisitNo==currentVisitNo && drugHospitalCode==currentHospitalCode){
				flagBlock=false;
			}
			if(item["IsExterNal"]=="1") 
				flagBlock=false;
			
			
			item["CR_No"]=$('#patCrNoPrescriptionPanel').text();
			item["EpisodeCode"]= $('#patEpisodeCodePrescriptionPanel').text();
			item["hospitalCode"]=$('#patHospitalCodePrescriptionPanel').text();
			item["VisitNo"]=$('#patEpisodeVisitNoPrescriptionPanel').text();
			
			//alert("flagBlock>>>"+ flagBlock);
			//if currrent date episode code and visit no. then not blocking again
			if(flagBlock){
				var payload={"hmode": "getCurrentDateStoreData", "keyword" : JSON.stringify(item)}
				//console.log("payload>>>" +  JSON.stringify(payload));
				$.ajax(
						{
							url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
						    type:'POST',
						    data:payload,
						    async: true,
						    dataType : "json",
						    success:function(result)
						    {
						    	//alert(JSON.stringify(result))
						    	result["isEditable"]="1";
						    	BlockQty(result)			    	
						    }
					});
			}else{
				//alert("inside else");
				item.EpisodeCode=currentEpisodeCode;
				item.VisitNo=currentVisitNo;
				item.hospitalCode=currentHospitalCode;
				item.seatId=$('#patSeatIdPrescriptionPanel').text();
				//alert("drugIssuedDetailJson>>" + JSON.stringify(drugIssuedDetailJson));
				var issueOrderjson= getDrugOrderIssuedQty(drugIssuedDetailJson,item["drugId"], item["drugBrandId"]);
				//alert("issueOrderjson>>" + JSON.stringify(issueOrderjson));
				if(issueOrderjson["issuedQty"]!="0" || issueOrderjson["orderedQty"]!="0"){				
					item.isEditable="0";
					item.issueQty=issueOrderjson["issuedQty"];
					item.orderedQty=issueOrderjson["orderedQty"];
					}
				else
					item.isEditable="1";					
				
				createDrugMultiRow(item);
				
			}
		});
		
	
		
		 
	}
	
}
function createMedicineHistory(pat_detailsJson){
	//alert(pat_detailsJson.HRSTR_JSON_DATA.DrugJsonArray.length);
	//console.log("createMedicineHistory>>>>" +  JSON.stringify(pat_detailsJson))
	if(pat_detailsJson.HRSTR_JSON_DATA.DrugJsonArray!=undefined && pat_detailsJson.HRSTR_JSON_DATA.DrugJsonArray.length>0){
		var DrugJsonArray=pat_detailsJson.HRSTR_JSON_DATA.DrugJsonArray;
		var html="";
		var key=pat_detailsJson.DATASAVE_TIME.replace(":","");
		regex = /-/gi;
		key=key.replaceAll(regex,"");
		key=key.replace(" ","");
		//19-Dec-2024 17:21
		var displayDrugRow="display:none";
		var btnShowHideTitle="Show";
		//if($('#medicineHistoryTable tbody tr').length==0){
			btnShowHideTitle="Hide";
			displayDrugRow="";
		//}
			
		var departmentName= (pat_detailsJson.HRSTR_JSON_DATA.patDept).split("/")[0];	
		var patConsultantName= pat_detailsJson.HRSTR_JSON_DATA.patConsultantName
		var hospitalName=pat_detailsJson["HOSPNAME"];
		var medicineHistoryPrescribedByJson={"patConsultantName": patConsultantName,"departmentName":departmentName,"hospitalName":hospitalName, "visitDate":pat_detailsJson.DATASAVE_TIME};
		html+="<tr>";
		html+="<td class='bg-success text-primary' colspan='8' style='padding: 5px;font-weight:bold;padding-top: 10px;'><span>Consultant : "+patConsultantName+"&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;Speciality : "+departmentName+"&nbsp;&nbsp;&nbsp; | &nbsp;&nbsp;&nbsp; Wellness Center : "+hospitalName+"&nbsp;&nbsp;&nbsp;  |&nbsp;&nbsp;&nbsp;   Visit Date : "+pat_detailsJson.DATASAVE_TIME+"</span></td>";
		html+="<td class='bg-success' style='padding: 14px;text-align:right'><a class='btn-his-outline btnHideShow_"+key+"' >"+btnShowHideTitle+"</a></td>";
		html+="<td class='bg-success' style='padding: 14px;'><a class='btn-his-outline btnRepeat_"+key+"' >Repeat</a>";
	//	html+="<span class='medicineHistoryJson_"+key+"' style='display:none;'>"+JSON.stringify(DrugJsonArray)+"</span></td>";		
		html+="</tr>";
		$('#medicineHistoryTable tbody').append(html)	
		var drugIssuedDetailJson=pat_detailsJson.HRSTR_JSON_DATA["drugIssuedDetailJson"];
		for(var i=0;i<DrugJsonArray.length;i++)
		{ 
			var drugJson=DrugJsonArray[i];
			//alert(JSON.stringify(drugJson));
			var drugkey=key+""+(i+1);
			var drugRepeatClassName="drugRepeat"+drugJson["drugId"]+"-"+ drugJson["drugBrandId"];
			drugJson["medicineHistoryPrescribedByJson"]=medicineHistoryPrescribedByJson;
			
			var statusHTML="";
				if(drugJson["drugDispenceStatusWiseQty"]!=undefined){
					if(drugJson["drugDispenceStatusWiseQty"].length==1){
						statusHTML=drugJson["drugDispenceStatusWiseQty"][0]["status"];
					}
					else{
						$.each(drugJson["drugDispenceStatusWiseQty"], function(key, statusJson){
							statusHTML+=statusJson["status"] + " Qty-" + statusJson["statusQty"] + "</br>";	
						});
						
					}	
				}
			var issueOrderjson= getDrugOrderIssuedQty(drugIssuedDetailJson,drugJson["drugId"], drugJson["drugBrandId"]);
			var issueQty=issueOrderjson["issuedQty"]			
			drugJson["issueQty"]=issueQty;
			drugJson["drugQuan"]="-1";
			
			var html="";
				html+="<tr class='row_"+key+"' style='"+displayDrugRow+"'>";
				html+="<td style='text-align:center'>"+(i+1)+"</td>";
				html+="<td>"+drugJson["drugName"]+"</td>";
				html+="<td style='text-align:center'>"+drugJson["drugDosage"]+"</td>";
				html+="<td style='text-align:center'>"+drugJson["drugFrequency"]+"</td>";
				html+="<td style='text-align:center'>"+drugJson["drugDays"]+" Days</td>";
				html+="<td style='text-align:center'>"+drugJson["patientDrugQuantity"]+"</td>";
				html+="<td style='text-align:center;color:blue'>"+drugJson["issueQty"]+"</td>";
				html+="<td >"+drugJson["drugInstructions"]+"</td>";
				html+="<td style='text-align:center'>"+statusHTML+"</td>";				
				html+="<td style='text-align:center;padding: 10px;'>";
				html+="<span id='medicineHistorySingleDrugJson_"+drugkey+"' style='display:none;'>"+JSON.stringify(drugJson)+"</span>";				
				html+="<a class='btn-his-outline btnDrugRepeat "+drugRepeatClassName+"' id='btnRepeatOne_"+drugkey+"'  onclick='repeatDrugFromSearch(this);' >R</a>";
				html+="<i class='fa fa-check-circle fa-2x text-success iconDrugRepeat icon-"+drugRepeatClassName+"' style='display:none;'  ></i>"
				html+="<td>";
				html+="</tr>";
				$('#medicineHistoryTable tbody').append(html);
				
				
		}
		//alert(key);
		$('.btnHideShow_'+key).click(function(){
			//alert($(this).attr('class'));
			var k= $(this).attr('class').split("_")[1];
			//alert(k)
			if($('.row_'+k).is(":visible")){
				$(this).text("Show");
				$('.row_'+k).hide();
			}
			else{
				$(this).text("Hide");
				$('.row_'+k).show();
			}
		});
		
		
		/* for repeating all drug of particular visit*/		
		$('.btnRepeat_'+key).click(function(){
			var k= $(this).attr('class').split("_")[1];
			//alert(k);
			$(this).hide();
			var DrugJsonArray= new Array();
			//alert($("[id^=btnRepeatOne_"+k+ "]").length);
			//alert($('.medicineHistoryJson_'+k).text());
			$("[id^=btnRepeatOne_"+k+ "]").each(function(){
				var k1= $(this).attr('id').split("_")[1];
				var drugJson=JSON.parse($('#medicineHistorySingleDrugJson_'+k1).text());
				
				drugJson["drugQuan"]="-1";
				drugJson["CR_No"]=$('#patCrNoPrescriptionPanel').text();				
				DrugJsonArray.push(drugJson);
				$('.drugRepeat'+drugJson["drugId"]+"-"+ drugJson["drugBrandId"]).hide();
				$('.icon-drugRepeat'+drugJson["drugId"]+"-"+ drugJson["drugBrandId"]).show();
				
				//$(this).hide();
			})
			//alert(JSON.stringify(DrugJsonArray));
			loadPreviousDrugs(DrugJsonArray,null);					
		});
	}	
}
function hideUnideRepeatedDrug(){
	$('.btnDrugRepeat').show();
	$('.iconDrugRepeat').hide();
	$('[id^=drugjson_]').each(function(){
		var drugJson=JSON.parse($(this).text());
		$('.drugRepeat'+drugJson["drugId"]+"-"+ drugJson["drugBrandId"]).hide();
		$('.icon-drugRepeat'+drugJson["drugId"]+"-"+ drugJson["drugBrandId"]).show();
	});
	
	
}
function repeatDrugFromSearch(objbtnrepeatOne){
	var k= $(objbtnrepeatOne).attr('id').split("_")[1];
	var drugJson=JSON.parse($('#medicineHistorySingleDrugJson_'+k).text());
	drugJson["CR_No"]=$('#patCrNoPrescriptionPanel').text();
	drugJson["EpisodeCode"]="";
	drugJson["hospitalCode"]="";
	drugJson["VisitNo"]="";
	drugJson["drugQuan"]="-1";
	// since loadPreviousDrugs function is taking array as input so making this array
	var DrugJsonArray=new Array();
	DrugJsonArray.push(drugJson); 
	//alert("inside repeatDrugFromSearch>>>" + JSON.stringify(DrugJsonArray));
	loadPreviousDrugs(DrugJsonArray,null);
	$('.drugRepeat'+drugJson["drugBrandId"]).hide();
	$('.icon-drugRepeat'+drugJson["drugBrandId"]).show();
}

function checkForStockDrugAlreadyAdded(){
	$("[id^=btnstockkadd_]").show();
	$("[id^=stockIconcheck_]").hide();
	if($("[name=drugsAdvices]").length>0){
		$("[name=drugsAdvices]").each(function(){
			var val=this.value;
			var Id=val.split("&&")[1];
			/*var drugId=Id.split("#")[0];
			var drugBrandId=Id.split("#")[1];*/
			var key=Id.split("#")[0]+ "-" +Id.split("#")[1];
			if($("[id^=trstockdrug_"+key+"]").length>0){
				$("[id^=btnstockkadd_"+key+"]").hide();
				$("[id^=stockIconcheck_"+key+"]").show();
			}
			//alert(key);
			//alert($(".drugRepeat"+key).length);
			if($(".drugRepeat"+key).length>0){
				$('.drugRepeat'+key).hide();
				$('.icon-drugRepeat'+key).show();
			}
		});
	}

	
	
}

function UnhideReferalFields(strreferralTypeCode){
	
	$('#referralStatus2').prop("checked", true);
	$('#ExternalDiv').show();
	if(strreferralTypeCode=="1"){
		$('#referType_extConsultation').prop("checked",true);
		$('#referType_extConsultation').prop("disabled",true);
		$('#extConsultation').show();
	}
	if(strreferralTypeCode=="2"){
		$('#referType_extInvestigation').prop("checked",true);
		$('#referType_extInvestigation').prop("disabled",true);
		$('#extInvestigation').show();
	}
	if(strreferralTypeCode=="3"){
		$('#referType_extProcedure').prop("checked",true);
		$('#referType_extProcedure').prop("disabled",true);
		$('#extProcedure').show();
	}
	if(strreferralTypeCode=="4"){
		$('#referType_extFollowup').prop("checked",true);
		$('#referType_extFollowup').prop("disabled",true);
		$('#extFollowup').show();
	}
	
}

function getDrugOrderIssuedQty(drugIssuedDetailJson,itemId, itemBrandId){
	var json={"issuedQty":"0", "orderedQty":"0"};
	var DataWithQtyFound= false
	if(drugIssuedDetailJson!=null && drugIssuedDetailJson!=undefined && drugIssuedDetailJson.length>0){
		$.each(drugIssuedDetailJson, function(indx, issuejson){
			if(DataWithQtyFound==false &&  issuejson["itemId"]==itemId && issuejson["itembrandId"]== itemBrandId){
				var issue_qty =parseInt(issuejson["issue_qty"]);
				json["issuedQty"]=issuejson["issue_qty"];				
				json["orderedQty"]=issuejson["order_qty"];
				if(issue_qty>0)
					DataWithQtyFound=true;	
			}	
		});
	}	
	return json;
}


function validateName(input) {
    // Define a regex pattern to allow only letters, numbers, spaces, and some punctuation
    const regex = /^[A-Za-z]+(?: [A-Za-z]+)*$/;

    // Check if input matches the allowed pattern
    if (!regex.test(input)) {        
        return false;
    }
    return true;
}

function validatePrescribedQuantity(drugQuantityId,selectedDrugJson){
	var drugQuantity=$('[name='+drugQuantityId + ']').val().trim();
	var maxCapQty= parseInt(selectedDrugJson["maxCapQty"]);
	var packSize= parseInt(selectedDrugJson["packSize"]);
	
	//alert("maxCapQty >>" + maxCapQty);
	
	//alert("drugQuantity >>" + drugQuantity);
	
	//alert("packSize >>" + packSize);
	
	if(drugQuantity=='' ){
		swal("Quantity entry is mandatory!!");
		return false;
	}
			
	
	if(drugQuantity!=""){
		var qty=parseInt(drugQuantity);
		if(qty>maxCapQty){
			swal("Maximum prescribed quantity cannot be greater than "+maxCapQty);
			return false;
		}
		if(packSize>1){
			 if(qty%packSize!=0){
				swal("Prescribed quantity must be a multiple of the pack size (" + packSize + ").");
				return false;
			}			
		}
	}
	return true; 
	
	
} 

function hideUnhideProxyDetail(objcheckbox){
	$('.proxy').val('');
	if($(objcheckbox).is(":checked")){
		$('#proxyMainDiv').show('slow');		
		$('#proxy_flag').val("1");
	}else{
		$('#proxyMainDiv').hide('slow');		
		$('#proxy_flag').val("0");
	}
	
}

function addExternalDiagnosis(){
	 var externalDiagnosisVal = $('input[name=externalDiagnosisTxt]').val(); 
	  if(externalDiagnosisVal.trim()!='')
	  {  
		    var tmp = 0; 
			$('.diagnosisAdded').find('label .text').each(function(index){ 
				if($(this).text().split("*")[0].trim().toUpperCase()===externalDiagnosisVal.trim().toUpperCase()) 
				{	tmp = 1; 
					return false;  }
			});
			if(tmp==1)
			{
				swal("Already Added!!");
				$('input[name=externalDiagnosisTxt]').val('');
				return false;
			}
			else
			{
				storeTagInLocalStorage("externalDiagnosisTxtIdTag", externalDiagnosisVal);
				//$(this).parent().parent().parent().find('.diagnosisAdded').append('<a style="padding-left: 5px;"><label> <input type="checkbox" class="checkedInput" name="diagnosisAdded" value="0#0#2^'+externalDiagnosisVal+'#0#0##0#0"  checked> '+externalDiagnosisVal+'(ext)</label></a>');
				var DiagnosisJson ={
						"IsSnomed"				:			"3" ,
						"DiagnosisName" 		: 		 	externalDiagnosisVal,
						"DiagnosisCode" 		:			"0",
						"DiagnosisSideCode" 	: 			"0" ,
						"DiagnosisSideName" 	:			"0",
						"DiagnosisTypeCode" 	: 	 		"0" ,
						"DiagnosisTypeNamee" 	: 			"0",
						"DiagnosisRemarks"		:			"External Diagnosis"
					};
				//console.log(JSON.stringify(DiagnosisJson));
				$('.diagnosisAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button" class="value btn btn-xs">'+
		    	 		'<input type="checkbox" class="checkedInput" name="diagnosisAdded" value="0#0#2^'+externalDiagnosisVal+'#0#0##0#0" checked="checked">  '+
		    	 		'<i class="text" style="display :none">'+JSON.stringify(DiagnosisJson)+' </i>'+
		    	 		'<span class="text">'+externalDiagnosisVal+'<sup style="color:red; font-weight:bold;">*</sup> </span>'+
		    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
		    	 		'</button></label>');

			}
		 
		 $('input[name=externalDiagnosisTxt]').val(''); 
	  }
	  else{
		  swal('Please enter other diagnosis to be added');
	  }

}
function getTagFromLocalStorage(keyname){
	var str =localStorage.getItem(keyname);
	var arrJson=new Array();
	//alert(str);
	if(str!=null && str!=undefined)
		arrJson=JSON.parse(str);
	return arrJson;
}


function storeTagInLocalStorage(keyname, data){
	var str =localStorage.getItem(keyname);
	var arrJson=new Array();
	var found=false;
	
	if(str!=null && str!=undefined){
		arrJson=JSON.parse(str);
		
		for(var i=0;i<arrJson.length;i++){
			var str=arrJson[i];
			if(str==data){
				found=true;
				break;
			}
		}		
	}
	if(found==false){
		arrJson.push(data)
		localStorage.setItem(keyname, JSON.stringify(arrJson)); 
	}
}

function getCurrentDate() {
	const date = new Date();
	const day = String(date.getDate()).padStart(2, '0'); // Ensures 2-digit day
	const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
	const month = monthNames[date.getMonth()];
	const year = date.getFullYear();
    return `${day}-${month}-${year}`;
}

function matchDates(date1Str, date2Str) {
    // Mapping months for parsing
	//alert("date1Str==" + date1Str)
	//alert("date2Str==" + date2Str)
    const months = {
        'January': 0, 'February': 1, 'March': 2, 'April': 3, 'May': 4, 'June': 5,
        'July': 6, 'August': 7, 'September': 8, 'October': 9, 'November': 10, 'December': 11
    };
	//alert(date2Str);
    // Parse first date ('20 May 2025')
    const [day1, month1, year1] = date1Str.split(' ');
    const date1 = new Date(parseInt(year1), months[month1], parseInt(day1));
	//alert(date2Str);
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

function checkProfileOnLoadOfRX(){
	//alert("inside checkProfileOnLoad");	
	var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
	//alert(patCompleteGeneralDtlPrescriptionPanel);
	var departmenUnitCodeCurrentRX= patCompleteGeneralDtlPrescriptionPanel.split('#')[5];
	//alert(departmenUnitCodeCurrentRX);
	var hosp_codeCurrentRX=$('#patHospitalCodePrescriptionPanel').text();
	var currentDate=$('#currentDate').val();
	
	var indx=0;
	var isCurrentDateProfileFound=false;
		
	//alert($('[id^=pastrx_]').length);
	$('[id^=pastrx_]').each(function(){
		
		console.log($(this).text().trim());
		var visitData= JSON.parse($(this).text().trim());
		var PatCompleteGeneralDtlProfile= visitData.PatCompleteGeneralDtl;
		var departmenUnitCodeFromProfile= PatCompleteGeneralDtlProfile.split('#')[5];
		var hosp_codeProfile= visitData.hosp_code;
		var visitDate= visitData.currentVisitDate;
	
		var flag =matchDates(currentDate, visitDate);
		
		if(flag ==true && departmenUnitCodeCurrentRX==departmenUnitCodeFromProfile && hosp_codeCurrentRX==hosp_codeProfile){
			//alert("ok");
			isCurrentDateProfileFound=true;
			getPrescriptionProfileData(visitData);
			jsonLastVisit=null;
		}else{
			if(indx==0)
				jsonLastVisit=visitData;			
		}
		indx++;
	});
	if(isCurrentDateProfileFound==false){
			populateLastDiagnosis();
	}
	
}




function getPrescriptionProfileData(val){
	
	//alert('Inside getPrescriptionProfileData 1');
	console.log('Inside Prescription Profile Json');
	//console.log(val.InvestigationJsonArray.length);
	console.log(JSON.stringify(val));
	var referFound=false;
	var isEndorsement=false;
	
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
	//alert('chech 2');
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
	if(val.InvestigationJsonArray!=undefined  && val.InvestigationJsonArray.length!=null)
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

		
		if(val.strInvestgationNote !=null){
			$('#investigationNoteId').val(val.strInvestgationNote);
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
	
	//for drug	
	if(val.DrugJsonArray.length!=null)
	{
		
		var flag =matchDates($('#currentDate').val(), val.currentVisitDate);
		console.log($('#currentDate').val());
		console.log(val.CurrentVisitDate);
		var drugIssuedDetailJson=val.drugIssuedDetailJson;
		
		//alert("inside getPrescriptionProfileData  " +JSON.stringify(drugIssuedDetailJson))
		console.log(JSON.stringify(val));
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
	
	var DiagnosisJsonArray=val.DiagnosisJsonArray;
		

	if(DiagnosisJsonArray==undefined && val.Diagnosis!=undefined && val.Diagnosis.length>0){
		var arrDiagnosis=val.Diagnosis;
		DiagnosisJsonArray= new Array();
		for(var i=0;i<arrDiagnosis.length;i++){
			var arr= arrDiagnosis[i].split("#");

			var DiagnosisJson ={
		 						"IsSnomed"				:			arr[2].split("^")[0] ,
								"DiagnosisName" 		: 		 	arr[2].split("^")[1],
								"DiagnosisCode" 		:			arr[0] ,
								"DiagnosisSideCode" 	: 			arr[4] ,
								"DiagnosisSideName" 	:			'',
								"DiagnosisTypeCode" 	: 	 		arr[1] ,
								"DiagnosisTypeNamee" 	: 			arr[3],
								"DiagnosisRemarks"	:				arr[6]
							};
			DiagnosisJsonArray.push(DiagnosisJson);				
		}
	}
	
	
	if(DiagnosisJsonArray!=null)
	{
		var flag = 0;
		var jsonkey={};
		DiagnosisJsonArray.forEach(function(item){
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
		
			
			$('.refferalAdded').append('<label><button tabindex="0" style="padding-left: 5px;font-weight:700;" type="button"  data-toggle="tooltip" title='+ tooltipdata +'  class="value btn btn-xs '+item.strReffralDepttext.trim()+'">'+
	    	 		'<input type="checkbox" class="checkedInput" name="referalchk" id="strreferalchkId'+strrefcount+'"  value="" checked="">  '+
	    	 		'<i class="" style="display :none">'+JSON.stringify(reffralJson)+'^NEW</i>'+
	    	 		'<span class="text">'+item.strShowData.trim()+'<sup style="color:red; font-weight:bold;"></sup> </span>'+
	    	 		'<span class="fdl-remove" onclick="$(this).parent().remove();">x</span>'+
	    	 		'</button></label>');
			var temp='#strreferalchkId'+strrefcount;
            $(temp).val(JSON.stringify(reffralJson));
         
			
		});
	
	}
	
	$('#followUpPlannedVisitDaysId').val(val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDays);
	$('#followUpPlannedVisitDateId').val(val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitDate);
	if((val.FOLLOW_UP[0].Planned_Visit[0].plannedVisitSos).trim() == ('SOS').trim() ){
		$('#followUpPlannedVisitSosId').prop('checked', true);
	}	
}


function populateLastDiagnosis(){
	//alert("inside  populateLastDiagnosis");
	var val=null;
	
	if($('[id^=pastrx_]').length==0)
		return;
	var patCompleteGeneralDtlPrescriptionPanel = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
		
	var departmenUnitCodeCurrentRX= patCompleteGeneralDtlPrescriptionPanel.split('#')[5];
	var hosp_codeCurrentRX=$('#patHospitalCodePrescriptionPanel').text();
	
	var indx=0;
	$('[id^=pastrx_]').each(function(){
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
	
	var DiagnosisJsonArray=val.DiagnosisJsonArray;
	//alert(JSON.stringify(DiagnosisJsonArray));

	if(DiagnosisJsonArray==undefined && val.Diagnosis!=undefined && val.Diagnosis.length>0){
		var arrDiagnosis=val.Diagnosis;
		DiagnosisJsonArray= new Array();
		for(var i=0;i<arrDiagnosis.length;i++){
			var arr= arrDiagnosis[i].split("#");
			//alert(arr);
			
			
			
			var DiagnosisJson ={
		 						"IsSnomed"				:			arr[2].split("^")[0] ,
								"DiagnosisName" 		: 		 	arr[2].split("^")[1],
								"DiagnosisCode" 		:			arr[0] ,
								"DiagnosisSideCode" 	: 			arr[4] ,
								"DiagnosisSideName" 	:			'',
								"DiagnosisTypeCode" 	: 	 		arr[1] ,
								"DiagnosisTypeNamee" 	: 			arr[3],
								"DiagnosisRemarks"	:				arr[6]
							};
			DiagnosisJsonArray.push(DiagnosisJson);				
		}
	}
	else{
		DiagnosisJsonArray=null;
	}
		
//	var tempchkval=item.DiagnosisCode+'#'+item.DiagnosisTypeCode+'#'+item.IsSnomed+'^'+
// item.DiagnosisName+'#'+item.DiagnosisTypeNamee+'#'+item.DiagnosisSideCode+'##0'+'#'+item.DiagnosisRemarks
	
	
	
	if(val!=null && DiagnosisJsonArray!=null)
		{
			var jsonkey={};
			DiagnosisJsonArray.forEach(function(item){
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

function initAutoComplete(){

	var externalDiagnosisTxtIdTag=getTagFromLocalStorage("externalDiagnosisTxtIdTag");
	 if(externalDiagnosisTxtIdTag!=null && externalDiagnosisTxtIdTag!=undefined && externalDiagnosisTxtIdTag.length>0)
		 $("#externalDiagnosisTxtId").autocomplete({source: externalDiagnosisTxtIdTag  });

	 var customDrugFrequencyText=getTagFromLocalStorage("customDrugFrequencyText");
	 if(customDrugFrequencyText!=null && customDrugFrequencyText!=undefined && customDrugFrequencyText.length>0)
	 	$(".customDrugFrequencyText").autocomplete({source: customDrugFrequencyText  });



	 var drugDaysArr=getTagFromLocalStorage("drugDays");
	 if(drugDaysArr!=null && drugDaysArr!=undefined && drugDaysArr.length>0)
	 	$(".DrugQuantity").autocomplete({source: drugDaysArr  });

	 var DrugQuantityArr=getTagFromLocalStorage("DrugQuantity");
	 if(DrugQuantityArr!=null && DrugQuantityArr!=undefined && DrugQuantityArr.length>0)
	 	$(".drugDays").autocomplete({source: DrugQuantityArr  });

	 var refferedByArr=getTagFromLocalStorage("refferedBy");
	 if(refferedByArr!=null && refferedByArr!=undefined && refferedByArr.length>0)
	 	$(".refferedBy").autocomplete({source: refferedByArr  });
	 
	 var drugInstructionsArr=getTagFromLocalStorage("drugInstructions");
	 if(drugInstructionsArr.length==0){
		 drugInstructionsArr=drugInstructionTags;
		 localStorage.setItem("drugInstructions", JSON.stringify(drugInstructionsArr)); 
	 }
	 $(".drugInstruction").autocomplete({source: drugInstructionsArr  });
	 
	 
	 var Tag=getTagFromLocalStorage("proxyRelationTag");
	 if(Tag!=null && Tag!=undefined && Tag.length>0)
	  	$('#proxy_relation').autocomplete({source: Tag });

	 $('#proxy_relation').blur(function(){
		var text= $(this).val().trim();
		if(text!=""){
			storeTagInLocalStorage("proxyRelationTag", text);
		}
	 });
}
function initDrugData(){
	$('[name=drugQuantity]').blur(function(){
		$('#isManualEntryDone').val("1");
	})
	$('[name=stockDrugQuantity]').blur(function(){
			$('#isManualEntryDoneStock').val("1");
	});
	$('[name=externalDrugQuantity]').blur(function(){
			$('#isManualEntryDoneExternal').val("1");
	});	
	$('.diagnosisAddExt').click(addExternalDiagnosis); 
		 $("#externalDiagnosisTxtId").on('keypress', function (e) {
	 		//console.log('1');
	 		if (!e) e = window.event;
	 	    var keyCode = e.keyCode || e.which;
	 	    if (keyCode == '13'){	 	    		
	 	    	addExternalDiagnosis();
	 	    }
		 });
		
		$('input[name=drugName]').flexdatalist({
	         url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=searchDrug', // Struts action URL
	         minLength: 3, // Minimum characters before triggering AJAX
	         searchContain: true, // Allow partial matches
	         searchDelay: 580, // Delay in milliseconds
	         cache: false, // Disable caching for dynamic data
	         searchIn: 'drugBrandNameForDisplay', // search in field
	         searchByWord : true,
	         requestType: 'POST', // Use POST to send the search term
	         params: function(query) {
	             return { searchTerm: query }; // Pass the search term as a parameter
	         },
	          visibleProperties: ["drugBrandNameForDisplay", "quantityDisplay" ], // Display the 'name' property in suggestions  
	          valueProperty:"drugId"         
	     });
		 
		 
		 $("input[name=flexdatalist-drugName]").on('keypress', function (e) {
		 		//console.log('1');
		 		if (!e) e = window.event;
		 	    var keyCode = e.keyCode || e.which;
		 	    if (keyCode == '13'){	 	    		
		 	    	addNewRegisteredDrug();
		 	    }
		 });
		 $("input[name=externalDrugName]").on('keypress', function (e) {
		 		//console.log('1');
		 		if (!e) e = window.event;
		 	    var keyCode = e.keyCode || e.which;
		 	    if (keyCode == '13'){	 	    		
		 	    	addNewExternalDrug();
		 	    }
		 });
		 
		 $('input[name=drugName]').on('show:flexdatalist.results', function(e, options) {
			 
			 setTimeout(function() {
				 $('.flexdatalist-results  li').each(function() {
					 if(options!=undefined && options.length>0){
						
						 var itemData;
						 var itemName=$(this).find('.item-drugBrandNameForDisplay').text();
						
						 itemData=options.filter(item => item["drugBrandNameForDisplay"] && item["drugBrandNameForDisplay"].trim()==itemName.trim());
						//alert(JSON.stringify(itemData));
			             if (itemData && itemData.length>0 &&  itemData[0].color) {
							//alert("here");
			            	 var color=itemData[0].color.toLowerCase().trim();
			            	 var className="optionBlack";
			            	
			            	 switch(color) {
			            	  case "black":
			            		  className="optionBlack";
			            	    break;
			            	  case "blue":
			            		  className="optionBlue";
			            	    break;
			            	  case "green":
			            		  className="optionGreen";
			            	    break;
			            	  case "red":
			            		  className="optionRed";
			            	    break;
			            	  default:
			            		  className="optionBlack";
			            	} 
			                $(this).addClass(className);
			                $(this).find('.item-quantityDisplay').addClass('optionQuantityDisplay')
			              }
					 }
		           }); 
			 },50);
		 }); 
		 $('input[name=drugName]').on('select:flexdatalist', function(e, options) {
			var json = options;
			json.drugBrandNameForDisplay_highlight="";
			$('#drugJsonObjDiv').html(JSON.stringify(json));
			$('#spanDrugForm').text(json["drugForm"]);	
			$('#doseQty').val("1");	 
		 })
		 
		
		$('#doseQty').on('blur',function(){	validateBeforeQuantityCalculate("1");});
		$('select[name=drugFrequency]').on('change',function(){	validateBeforeQuantityCalculate("1");});
		
		$('input[name=drugDays]').on('keyup',function(){validateBeforeQuantityCalculate("1");});
				
		$('#extDoseQty').on('blur',function(){validateBeforeQuantityCalculate("2")});
	
		$('select[name=externalDrugDosage]').on('change',function(){validateBeforeQuantityCalculate("2")});
		
		$('[name=externalDrugFrequency]').on('change',function(){validateBeforeQuantityCalculate("2")});
		$('input[name=externalDrugDays]').on('keyup',function(){validateBeforeQuantityCalculate("2")});
			
		$('#stockdoseQty').on('blur', function () {	validateBeforeQuantityCalculate("3")});
		$('select[name=stockDrugFrequency]').on('change',function(){validateBeforeQuantityCalculate("3")});
		
		$('input[name=stockDrugDays]').on('keyup',function(){validateBeforeQuantityCalculate("3")});				
}

function validateBeforeQuantityCalculate(status){
	var freq=null;
	var freqname=null;
	var dos=null;
	var days=null;
	var calcquan=null;
	if(status=="1"){/*store drug */
		var freq=$('select[name=drugFrequency] option:selected').val();
		if(freq=="-1"){
			$('#drugFrequencyText').val("").show();
			return;
		}
		$('#drugFrequencyText').val("").hide();
		//alert($('#isManualEntryDone').val());
		if($('#isManualEntryDone').val()=="1")
			return;
		var  selectedDrugJson=JSON.parse($("#drugJsonObjDiv").text().trim());
		if(selectedDrugJson["isQuantityCalculated"]=="1"){
			freqname= $('select[name=drugFrequency] option:selected').text();
			dos=$('#doseQty').val();              
			days=$('input[name=drugDays]').val();
			calcquan=calculateQuantity(freq,freqname,dos,days);			
			$('input[name=drugQuantity]').val(calcquan);
		}
		return;
	}
	if(status=="2"){/*External drug not in CGHS*/
		if($("#extItemType").val()=="0"){
			alert("please select drug type");
			return;
		}
						
		freq=$('select[name=externalDrugFrequency] option:selected').val();
		
		if(freq=="-1"){
			$('#externalDrugFrequencyText').val("").show();
			return;
		}
		$('#externalDrugFrequencyText').val("").hide();
		var arrExtItemType=$("#extItemType").val().split("^");
								
		if(freq=="-1"){
			$('#externalDrugFrequencyText').val("").show();
			return;
		}		
		if(arrExtItemType[2]!="1")//quantity Calculaterequired 
			return
			
		if($('#isManualEntryDoneExternal').val()=="1")
			return 
		freqname= $('select[name=externalDrugFrequency] option:selected').text();
		dos=$('#extDoseQty').val();                  
		days=$('input[name=externalDrugDays]').val();
		calcquan=calculateQuantity(freq,freqname,dos,days);
		$('input[name=externalDrugQuantity]').val(calcquan);
		return;		
	}
	if(status=="3"){/*Available sock drug */
		freq=$('select[name=stockDrugFrequency] option:selected').val();
		$('#stockDrugFrequencyText').val("").hide();
		if(freq=="-1"){
			$('#stockDrugFrequencyText').val("").show();
			return;
		}
		if($('#isManualEntryDoneStock').val()=="1"){
			return;
		}		
		freqname= $('select[name=stockDrugFrequency] option:selected').text();
		dos=$('#stockdoseQty').val();        
		days=$('input[name=stockDrugDays]').val();
		calcquan=calculateQuantity(freq,freqname,dos,days);
		$('input[name=stockDrugQuantity]').val(calcquan);
	}
	
	
	
}