function refreshSectionBookMark(bookmarkTypeIds){
	var json={
			"mode":"1",
			"seatTd":$('#patSeatIdPrescriptionPanel').text(),
			"hospitalCode":$('#patHospitalCodePrescriptionPanel').text(),
			"bookmarkTypeIds":bookmarkTypeIds,
	}	
	var arr= bookmarkTypeIds.split(",");
	for(var i=0;i<arr.length;i++){
		var html="<select class='sectionbookmarkSelect' id='bookmark_"+arr[i]+"' onchange='openBookMark(this)'><option selected value=''>Select Template</option></select><span id='bookmarkjsonlist_"+arr[i]+"' style='display:none'></span>";		
		$('#sectionBookmark_'+arr[i]).html(html);		
	}
	$('#dataBookmarkModify').html("");
	
	$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getSectionBookmarks',
		type:'POST',
		data:JSON.stringify(json),
		dataType : "json",
		contentType: "application/json; charset=UTF-8",
		success:function(result)
		{
			if(result["status"]=="SUCCESS" && result["data"] !=undefined  && result["data"].length>0) {
				$('#templateModify').html("<option selected value=''>Select Template</option>");		
				$.each(result["data"],function(indx, objJson){
					var pk= objJson["pk"].replace("^", "-"); 
					var option="<option value='"+pk+"'>"+ objJson["bookmarkName"]+"</option>";
					$('#bookmark_'+objJson["bookmarkTypeId"]).append(option);	
					$('#bookmarkjsonlist_'+objJson["bookmarkTypeId"]).append("<span id='bookmarkjson_"+pk+"' style='display:none'>"+JSON.stringify(objJson)+"</span>");
					if(bookmarkTypeIds.indexOf(",")<0)
						$('#templateModify').append(option);										
				});
								
			}
			for(var i=0;i<arr.length;i++){
				$('#bookmark_'+arr[i]).select2({width: '100%'});		
			}
		
			
    } ,
    error: function (xhr, ajaxOptions, thrownError) {
            alert(xhr.status);
            alert(thrownError);
     }
    	
	});
}

function openBookMark(objselect){
	if(objselect.value=="")
		return;
	
	
	
	
	var id =$(objselect).val();
	var arrId= id.split("-");
	var bookmarkTypeId=arrId[2];
	//alert($('#bookmarkjson_'+id).text());
	var bookmarkjson=JSON.parse($('#bookmarkjson_'+id).text());
	LoadBookmarkTemplate(bookmarkTypeId,bookmarkjson)
	
}

function populateInvestigation(bookmarkjson){
	
	var invRefJson= JSON.parse(bookmarkjson["strjson"]);
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultInvestigationValidity= json["investigationValidity"];
	
	
	$.each(invRefJson, function(indx,reffralJson){
		var key='extinv-'+ reffralJson["strReffralExtId"];
		var len=$('[id^=btndel_'+ key).length;
		key= key+(len+1);
		
		reffralJson["validUpto"]=defaultInvestigationValidity;
		reffralJson=checkReferalCode(reffralJson);
		createExternalRow(reffralJson, "ExternalInvestigationListTable", key);				
	});
	EnableDiableExternalCheckboxes();
}
function checkReferalCode(referjson){
	var options= null;
	if(referjson["strreferralTypeCode"] =="2")
		options = $('#refferlExtInvestigationTest option');

	if(referjson["strreferralTypeCode"] =="3")
		options = $('#refferlExtProcedure option');
	//alert(JSON.stringify(referjson));
	var strReffralExtId=referjson["strReffralExtId"]
	
	
	$.map(options ,function(option) {
		 var arroption=(option.value).split('#');
		 var optionText=(option.text);
		 if(arroption[0]==strReffralExtId){
			referjson["refferExtCGHSCode"]=arroption[1];
			referjson["strReffralExtName"]=optionText;				
		}
	});
	return referjson;
}

function populateConsultation(bookmarkjson){
var refJson= JSON.parse(bookmarkjson["strjson"]);
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultValidity= json["consultationValidity"];
	
	
	$.each(refJson, function(indx,reffralJson){
		var key='extcon-'+ reffralJson["strReffralExtId"];
		if($('#btndel_'+ key).length>0){		
			return false;
		}
		reffralJson["validUpto"]=defaultValidity;
		createExternalRow(reffralJson, "ExternalConsultationListTable", key);
				
	});
	EnableDiableExternalCheckboxes();
}
function populateProcedure(bookmarkjson){
	var refJson= JSON.parse(bookmarkjson["strjson"]);
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultValidity= json["procedureValidity"];
	
	
	$.each(refJson, function(indx,reffralJson){
		var key='extproc-'+ reffralJson["strReffralExtId"];
		var len=$('[id^=btndel_'+ key).length;
		key= key+(len+1);
		
		reffralJson["validUpto"]=defaultValidity;
		reffralJson=checkReferalCode(reffralJson);
		createExternalRow(reffralJson, "ExternalProcedureListTable", key);
				
	});
	EnableDiableExternalCheckboxes();

}

function populateDrug(bookmarkjson){
	var DrugJsonArray= JSON.parse(bookmarkjson["strjson"]);
	var finalDrugArr= new Array();
	$.each(DrugJsonArray, function(indx, drugJson){
		drugJson["drugQuan"]="-1";
		drugJson["CR_No"]=$('#patCrNoPrescriptionPanel').text();
		drugJson["EpisodeCode"]="";
		drugJson["hospitalCode"]="";
		drugJson["VisitNo"]="";		
		//alert(JSON.stringify(drugJson));
		finalDrugArr.push(drugJson);
	});
	loadPreviousDrugs(finalDrugArr,null);		
}

function populateDiagnosis(bookmarkjson){
	
	var DiagnosisJsonArray= JSON.parse(bookmarkjson["strjson"]);
	var jsonkey={};
	
	//creating for alreay added diagnosis 
	$('input[name="diagnosisAdded"]:checked').each(function() {
			var json=JSON.parse($(this).parent().find('i').text()); 
			var  DiagnosisName=json["DiagnosisName"]
			jsonkey[DiagnosisName]=DiagnosisName;
	    });
	
	
	$.each(DiagnosisJsonArray, function(indx, item){
		
		//alert(item.DiagnosisName); 
		//alert(jsonkey[item.DiagnosisName]);
		if(jsonkey[item.DiagnosisName] !=undefined)//checking duplicate
			return;
		
		jsonkey[item.DiagnosisName]=item.DiagnosisName;

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
	 				
		
	});
} 




function bookmarkSection(bookmarkTypeId){
	$('#dataToBookmark').empty();
	
	$('#dataToBookmark').html("<ul  id='dataToBookmarkUl'></ul>");
	switch(bookmarkTypeId) {
	  case 1:{
	// investigation
		if($('#ExternalInvestigationListTable tbody tr').length==0){
			alert("Select Tests names");
			return;
		}
		listDataForbookmarkInv();
		break;
	  }
	  case 2:{
			// consultation
				if($('#ExternalConsultationListTable tbody tr').length==0){
					alert("Select consultation names");
					return;
				}
				listDataForBookmarkConsultation();
				break;
	  }
	  case 3 :{// procedure
		if($('#ExternalProcedureListTable tbody tr').length==0){
				alert("Select procedure names");
				return;
		}
		listDataForBookmarkProcedure();
		break;
		  
	  }
	  case 4 :{// drug
			if($('#drugAdviceListTable tbody tr').length==0){
					alert("Enter Drug names to bookmark");
					return;
			}
			listDataForBookmarkDrug();
			break;
	  }	
	  case 5 :{// diagnosis
				if($('input[name="diagnosisAdded"]:checked').length==0){
					alert("Enter Diagnosis to create bookmark !");
					return;
				}
				
				listDataForBookmarkDiagnosis();
	  			break;
	  	  }	    
	  
	}
	
	$('#sectionBookmark').modal('show');
	$('#bookmarkTypeId').val(bookmarkTypeId);
	$('#sectionTemplateName').focus();
}
function listDataForbookmarkInv(){
	var arr= new Array();
	$('[id^=reffralJson_extinv-]').each(function(){
		var json=JSON.parse($(this).text());
		var html="<li>"+json["strReffralExtName"]+"</li>";
		$('#dataToBookmarkUl').append(html);
		arr.push(json);
	});
	$('#jsonSectionBookmark').text(JSON.stringify(arr));
	$('#SectionBookMarkHeadingName').text("Create Investigation Template");
}
function listDataForBookmarkConsultation(){
	var arr= new Array();
	
	$('[id^=reffralJson_extcon-]').each(function(){
		var json=JSON.parse($(this).text());
		var html="<li>"+json["strReffralExtName"]+"</li>";
		$('#dataToBookmarkUl').append(html);
		arr.push(json);
	});
	$('#jsonSectionBookmark').text(JSON.stringify(arr));
	$('#SectionBookMarkHeadingName').text("Create Consultation Template");
}

function listDataForBookmarkProcedure(){
	var arr= new Array();
	
	$('[id^=reffralJson_extproc-]').each(function(){
		var json=JSON.parse($(this).text());
		var html="<li>"+json["strReffralExtName"]+"</li>";
		$('#dataToBookmarkUl').append(html);
		arr.push(json);
	});
	$('#jsonSectionBookmark').text(JSON.stringify(arr));
	$('#SectionBookMarkHeadingName').text("Create Procedure Template");
}



function listDataForBookmarkDrug(){
	var arr= new Array();
	
	$('[id^=drugjson_]').each(function(){
		var json=JSON.parse($(this).text());
		var html="<li>"+json["drugName"]+"</li>";
		$('#dataToBookmarkUl').append(html);
		arr.push(json);
	});
	$('#jsonSectionBookmark').text(JSON.stringify(arr));
	$('#SectionBookMarkHeadingName').text("Create Drug Template");
}


function listDataForBookmarkDiagnosis(){
	var DiagnosisJsonArray= new Array();
	$('input[name="diagnosisAdded"]:checked').each(function() {
		var json=JSON.parse($(this).parent().find('i').text());  
		var html="<li>"+json["DiagnosisName"]+"</li>";
		$('#dataToBookmarkUl').append(html);     
        DiagnosisJsonArray.push(json);    
    });
	$('#jsonSectionBookmark').text(JSON.stringify(DiagnosisJsonArray));
	$('#SectionBookMarkHeadingName').text("Create Drug Template");
}



function SaveBookmarkTemplate(){

	if($('#sectionTemplateName').val().trim()==""){
		alert("Please select a templateName")
		return;
	}
	var json={
			"mode":"1",
			"seatTd":$('#patSeatIdPrescriptionPanel').text(),
			"hospitalCode":$('#patHospitalCodePrescriptionPanel').text(),
			"bookmarkTypeId":$('#bookmarkTypeId').val(),
			"sectionSno":"0",
			"sectionjson":$('#jsonSectionBookmark').text(),
			"sectionTemplateName": $('#sectionTemplateName').val()			
	}
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveSectionBookmark',
			type:'POST',
			data:JSON.stringify(json),
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success:function(result)
	    {
			//alert(JSON.stringify(result))
			
			if(result["status"]=="SUCCESS"){
				alert("Template Saved Successfuly!");
				if($('#bookmarkTypeId').val()!="")
					refreshSectionBookMark($('#bookmarkTypeId').val());
				
				$('#sectionTemplateName').val("");
				$('#bookmarkTypeId').val("");
				$('#sectionBookmark').modal('hide');
			}
			else{
				alert("Problem while saving template");
			}
			
				
	    } ,
	    error: function (xhr, ajaxOptions, thrownError) {
	            alert(xhr.status);
	            alert(thrownError);
	     }
	    	
		});
	
}



function manageTemplateSection(bookmarkTypeId){
	
	var html= $('#bookmark_'+bookmarkTypeId ).html();
	//alert(html);
	$('#dataBookmarkModify').html("");
	$('#templateModify').html(html);
	$('#sectionBookmarkManage').modal('show');
	$('#bookmarkTypeIdForModify').val(bookmarkTypeId);	
	$('#divEditTemplateName').hide();	
	$('.btnTemplate').hide();
	
}

function populateTemplateDataForModify(objselect){
	$('#dataBookmarkModify').html("");
	var id =$(objselect).val();
	
	if(id=="")
		return;
	var sectionTemplateName=$("#templateModify option:selected").text();
	$('#sectionTemplateNameModify').val(sectionTemplateName);
	$('#divEditTemplateName').show();
	$('.btnTemplate').show();
	var arrId= id.split("-");
	var bookmarkTypeId=parseInt(arrId[2]);
	var bookmarkSNo=parseInt(arrId[3]);
	//alert("bookmarkSNo>>>" + bookmarkSNo);
	$('#bookmarkTypeIdForModify').val(bookmarkTypeId);
	$('#bookmarkSNoForModify').val(bookmarkSNo);
	
	var bookmarkjson=JSON.parse($('#bookmarkjson_'+id).text());
	
	
	switch(bookmarkTypeId) {
	  case 1:{
	// investigation
		var html=`<table id="TemplateExternalListTable" class="table table-condensed " style="margin-bottom: 0px;"> 
	                <thead>
	                  <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
	                    <th style='width:30%'>Test Name</th>
	                    <th style='width:30%'>Referral Note</th>
	                    <th style='width:15%'>No. of Investigation</th>                
	                    <th style='width:10%'>&nbsp;</th>
	                  </tr>
	                </thead> <tbody></tbody> </table>`;
					
		$('#dataBookmarkModify').html(html);
		populateTemplateForReferrralModify(bookmarkjson);
		break;
	  }
	  case 2:{
			// consultation
			var html=`<table id="TemplateExternalListTable" class="table table-condensed " style="margin-bottom: 0px;"> 
			                <thead>
			                  <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
			                    <th style='width:30%'>Speciality Name</th>
			                    <th style='width:30%'>Referral Note</th>
			                    <th style='width:15%;display:none;' >No. of Investigation</th>                
			                    <th style='width:10%'>&nbsp;</th>
			                  </tr>
			                </thead> <tbody></tbody> </table>`;
							
			$('#dataBookmarkModify').html(html);
			populateTemplateForReferrralModify(bookmarkjson);
			$('.templateNoAllowed').hide();
			break;
	  }
	  case 3 :{// procedure
			var html=`<table id="TemplateExternalListTable" class="table table-condensed " style="margin-bottom: 0px;"> 
	                <thead>
	                  <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
	                    <th style='width:30%'>Procedure Name</th>
	                    <th style='width:30%'>Referral Note</th>
	                    <th style='width:15%'>No. of Investigation</th>                
	                    <th style='width:10%'>&nbsp;</th>
	                  </tr>
	                </thead> <tbody></tbody> </table>`;
					
			$('#dataBookmarkModify').html(html);
			populateTemplateForReferrralModify(bookmarkjson);
		break;				  
	  }
	  case 4 :{// drug
		populateTemplateForDrugModify(bookmarkjson);
		break;
	  }	
	  case 5 :{// diagnosis
		populateTemplateForDiagnosisModify(bookmarkjson);
		break;
	  }	    
	}
	initDeleteTemplate();
	
}
function initDeleteTemplate(){
	$('[id^=btndeltemplate_]').click(function(){
			if($('#TemplateExternalListTable tbody tr').length==1){
				swal('atleast one row required !')
				return;
			}
			$(this).closest('tr').remove();	
		});
}
function populateTemplateForDrugModify(bookmarkjson){
	var html=`<table id="TemplateExternalListTable" class="table table-condensed " style="margin-bottom: 0px;"> 
        <thead>
          <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
		  		<th style="width:20%;">Drug</th>
         		<th style="width:10%;text-align:center">Dosage</th>
         		<th style="width:15%;text-align:center">Frequency</th>                    
         		<th style="width:15%;text-align:center">Days</th>
         		<th style="width:10%;text-align:center">Quantity</th>
         		<th style="width:20%;" class="drugAdviceListExcessCol">Instructions</th>             
            	<th style='width:10%'>&nbsp;</th>
          </tr>
	    </thead> <tbody></tbody> </table>`;
	$('#dataBookmarkModify').html(html);
	//alert(bookmarkjson["strjson"]);
	var DrugArray= JSON.parse(bookmarkjson["strjson"]);
	var optionhtml=$("[name=drugFrequency]").html();
	
	$.each(DrugArray, function(indx,drugJson){
		var drugDosage= drugJson["drugDosage"].split(" ")[1];
		var drugFrequencyId=drugJson["drugFrequencyId"];
		var displayFrequency="display:none;"
		if(drugFrequencyId!="-1")
			drugFrequency=""
		else{
			displayFrequency="";
		}
		var key=drugJson["drugId"]+indx;	
		html=`<tr>
				<td>${drugJson["drugBrandNameForDisplay"]}</td>
				<td>
					<div class="input-group">
		                 <input type="text" class="form-control " name="templateDoseQty" id='templateDoseQty_${key}' 
						 value="${drugJson["drugDosageId"]}" maxlength="2" onkeypress="return isNumber(event)">
		                  <div class="input-group-btn">
		                     <span class="btn btn-default" id="spanTemplateDrugForm_${key}">${drugDosage}</span>
		                  </div>
		              </div>
				</td>
				<td>
					<select class="form-control templateDrugFrequency" id='templateDrugFrequency_${key}' 
					name="templateDrugFrequency" tabindex="7">${optionhtml}</select>
					<input type="text" class="customDrugFrequencyText"  name="templateDrugFrequencyText" 
					id='templateDrugFrequencyText_${key}' 
					maxlength="100" style="${displayFrequency};margin-top:5px;" placeholder="Enter Frequency" value="${displayFrequency}">
				</td>
				<td>
					<input type="text" class="form-control templateDrugDays"  onkeypress="return isNumber(event)" 
					id='templateDrugDays_${key}' name="templateDrugDays" value="${drugJson["drugDays"]}" tabindex="9" maxlength="2">
				</td>
				<td>
					<input type="text" class="form-control templateDrugQuantity" 
					onkeypress="return isNumber(event)" id='templateDrugQuantity_${key}' 
					name="templateDrugQuantity" value="${drugJson["patientDrugQuantity"]}" maxlength="3" tabindex="10">
				</td>
				<td>
				<input type="text" class="form-control templateDrugInstruction"  maxlength="500" 
				id='templateDrugInstruction_${key}' value="${drugJson["drugInstructions"]}"
				name="templateDrugInstruction"  autocomplete="off">
				</td>
				<td>
					<button style="padding:4px 12px;margin:1px;" id="btndeltemplate_${key}" class="btn btn-danger btn-sm" type="button">x</button>
					<span id="templatedrugJson_${key}" style="display :none">${JSON.stringify(drugJson)}</span>
						
				</td>				
				</tr>`
				$('#TemplateExternalListTable tbody').append(html)					
				$('#templateDrugFrequency_'+key).val(drugFrequencyId);
				
		});	
		initDrugTemplateRows();		
}

function populateTemplateForDiagnosisModify(bookmarkjson){
	var html=`<table id="TemplateExternalListTable" class="table table-condensed " style="margin-bottom: 0px;"> 
        <thead>
          <tr style="background: linear-gradient(to bottom, #dbdbdb /* #acd6ff */, white);">
		  		<th style="width:20%;">Diagnosis</th>
         		<th style="width:10%;text-align:center">Diagnosis Site</th>
         		<th style="width:15%;text-align:center">Diagnosis Type</th>
         		<th style="width:10%;text-align:center">Diagnosis Remarks</th>         		             
            	<th style='width:10%'>&nbsp;</th>
          </tr>
	    </thead> <tbody></tbody> </table>`;
	$('#dataBookmarkModify').html(html);
	
	var DiagnosisArray= JSON.parse(bookmarkjson["strjson"]);
	//alert(JSON.stringify(DiagnosisArray));
	$.each(DiagnosisArray, function(indx,diagnosisJson){
		var remarks = diagnosisJson["DiagnosisRemarks"]!="0"?diagnosisJson["DiagnosisRemarks"]:"";
		if(remarks=="External Diagnosis"){
			remarks="";
		}
		
		html=`<tr>
				<td style='padding-left:5px;'>${diagnosisJson["DiagnosisName"]}</td>
				<td>
					<select class="form-control" name="templateDiagnosisSite" id="templateDiagnosisSite_${indx}" autocomplete="off">
	                    <option value="0">Side</option>
	                    <option value="1">NR</option>
	                    <option value="2">Left</option>
	                    <option value="3">Right</option>
	                    <option value="4">Bilateral</option>
	                    <option value="5">Upper Left</option>
	                    <option value="6">Lower Left</option>
	                    <option value="7">Upper Right</option>
	                    <option value="8">Lower Right</option>
	                  </select>
				</td>
				<td>
				<select class="form-control" name="templateDiagnosisType" id="templateDiagnosisType_${indx}" tabindex="3">
				  <option value="0">Select Diagnosis Type</option>  
				  <option value="11">Provisional</option>
                  <option value="12">Differential</option>
                  <option value="14">Final</option>
                </select>
				</td>
				<td>
					<input type="text" class="form-control" 
					 id='templateDiagnosisRemarks_${indx}' 
					name="templateDiagnosisRemarks" id="templateDiagnosisRemarks_${indx}"
					 maxlength="200" tabindex="10" placeholder="Remarks" value="${remarks}" >
				</td>
				
				<td>
					<button style="padding:4px 12px;margin:1px;" id="btndeltemplate_${indx}" class="btn btn-danger btn-sm" type="button">x</button>
					<span id="templateDiagnosisJson_${indx}" style="display :none">${JSON.stringify(diagnosisJson)}</span>
				</td>				
				</tr>`
				$('#TemplateExternalListTable tbody').append(html);	
				$('#templateDiagnosisSite_'+indx).val(diagnosisJson["DiagnosisSideCode"]);
				$('#templateDiagnosisType_'+indx).val(diagnosisJson["DiagnosisTypeCode"])				
	});
}
function initDrugTemplateRows(){
	
	$('[name=templateDoseQty]').on('blur',function(){
		var uniqueId =$(this).attr("id").split("_")[1];		
		calculatetemplateDrug(uniqueId);
	});
	$('[name=templateDrugDays]').on('blur',function(){
			var uniqueId =$(this).attr("id").split("_")[1];		
			calculatetemplateDrug(uniqueId);
	});
	
	$('[name=templateDrugFrequency_]').change(function(){
		var uniqueId =$(this).attr("id").split("_")[1];
		$('#customDrugFrequencyText'+uniqueId).val("");		
		if($(this).val()=="-1")
			$('#customDrugFrequencyText'+uniqueId).show()					
		else{
			$('#customDrugFrequencyText'+uniqueId).hide();
			calculatetemplateDrug(uniqueId);
		}		
	});
	
}
function calculatetemplateDrug(uniqueId){
	var freq=$('#templateDrugFrequency_'+uniqueId+' option:selected').val();
	var freqname= $('#templateDrugFrequency_'+uniqueId+' option:selected').text();	
	if(freq=="-1")
		return;		
	var dos=$('#templateDoseQty_'+uniqueId).val();         
	var days=$('#templateDrugDays_'+uniqueId).val();
	var  selectedDrugJson=JSON.parse($("#templatedrugJson_"+uniqueId).text().trim());	
	if(selectedDrugJson["isQuantityCalculated"]=="1"){
		var calcquan=calculateQuantity(freq,freqname,dos,days);					
		$('#templateDrugQuantity_'+uniqueId).val(calcquan);
	}
}
function populateTemplateForReferrralModify(bookmarkjson){
	//alert(JSON.stringify(bookmarkjson));
	var refJson= JSON.parse(bookmarkjson["strjson"]);
	
	//alert(JSON.stringify(refJson));							
	$.each(refJson, function(indx,reffralJson){
		var key='exttemplateInv-'+ reffralJson["strReffralExtId"];
		var len=$('[id^=btndeltemplateInv_'+ key).length;
		key= key+(len+1);
		html=`<tr>
		<td style="padding-top: 12px;">${reffralJson["strReffralExtName"]}</td>
		<td><input type="text" class="form-control multirowtemplateModifyfield" id="templateRefNote_${key}" 
		value="${ reffralJson["refferalExtReson"]}" maxlength="1000"/></td>
		<td class='templateNoAllowed'>
		<input type="text" class="form-control multirowtemplateModifyfield" id="templateNoAllowed_${key}" 
		value="${reffralJson["noAllowed"] }" onkeypress="return isNumber(event)" maxlength="2" /></td>
		<td>
		<button style="padding:4px 12px;margin:1px;" id="btndeltemplate_${key}" class="btn btn-danger btn-sm" type="button">x</button>
		<span id="templateReffralJson_${key}" style="display :none">${JSON.stringify(reffralJson)}</span>
		</td>		
		</tr>`
		$('#TemplateExternalListTable tbody').append(html);						                           
						                      
		
		$('.multirowtemplateModifyfield').blur(ValidateAndUpdateTemplateJson);
	});
	
}


function ValidateAndUpdateTemplateJson(){
	var key=$(this).attr("id").split("_")[1];
	//alert(key);
	//alert($('#templateInvReffralJson_'+key).text());
	var json=JSON.parse($('#templateReffralJson_'+key).text());
	
	//alert("json>>>>"+JSON.stringify(json))
	var defaultAllowed= json["defaultAllowed"]
	//alert(defaultAllowed); 
	var noAllowed = $('#templateNoAllowed_'+key).val().trim(); 
	if(noAllowed==""){
		swal('Please enter No. Allowed !');
		$('#templateNoAllowed_'+key).focus();
		return false;
	}
	
	if(noAllowed=="0"){
		swal('No. Allowed cannot be zero !' );
		$('#templateNoAllowed_'+key).focus();
		$('#templateNoAllowed_'+key).val("1");
		return false;
	}

	noAllowed = parseInt(noAllowed, 10);
	defaultAllowed = parseInt(defaultAllowed, 10);
	//alert("noAllowed>>>"+noAllowed+ "defaultAllowed>>>  "+defaultAllowed)

	if(noAllowed>defaultAllowed){
		//alert(1);
		swal('No. allowed cannot be greater than '+ defaultAllowed );		
		$('#noAllowed_'+key).val(defaultAllowed);
		return false;
	}
	
	var refNote= $('#refNote_'+key).val().trim();
	
	json["refferalExtReson"]=refNote;
	json["noAllowed"]=noAllowed;
	
	//alert(JSON.stringify(json));
	$('#templateReffralJson_'+key).text(JSON.stringify(json));
	
} 
function DeleteBookmarkTemplate(){
	if(confirm("Are you sure want to delete this template ?")==false){
		return;
	}
	var bookmarkTypeId=$('#bookmarkTypeIdForModify').val();
	var bookmarkSno=$('#bookmarkSNoForModify').val();
		
	var json={
			"mode":"2",
			"seatTd":$('#patSeatIdPrescriptionPanel').text(),
			"hospitalCode":$('#patHospitalCodePrescriptionPanel').text(),
			"bookmarkTypeId":bookmarkTypeId,
			"sectionSno":bookmarkSno,
			"sectionjson":"",
			"sectionTemplateName": ""			
	}
	
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveSectionBookmark',
			type:'POST',
			data:JSON.stringify(json),
			dataType : "json",
			contentType: "application/json; charset=UTF-8",
			success:function(result)
	    	{
				if(result["status"]=="SUCCESS"){
					swal("BookMark Deleted Successfully !");
					$('#sectionTemplateNameModify').val()						
					refreshSectionBookMark(bookmarkTypeId);	
					$('#divEditTemplateName').hide();
					$('.btnTemplate').hide();
				}
				else{
					alert("Problem while saving template");
				}
			 } ,
	    error: function (xhr, ajaxOptions, thrownError) {
	            console.log(xhr.status);
	            console.log(thrownError);
	     }
	    	
		});
}



function EditBookmarkTemplate(){
	var bookmarkTypeId=$('#bookmarkTypeIdForModify').val();
	var bookmarkSno=$('#bookmarkSNoForModify').val();
	
	var arrData =processJson();
	
	if(arrData.length>0){
		var json={
				"mode":"3",
				"seatTd":$('#patSeatIdPrescriptionPanel').text(),
				"hospitalCode":$('#patHospitalCodePrescriptionPanel').text(),
				"bookmarkTypeId":bookmarkTypeId,
				"sectionSno":bookmarkSno,
				"sectionjson":JSON.stringify(arrData) ,
				"sectionTemplateName": $('#sectionTemplateNameModify').val()			
		}
		$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveSectionBookmark',
				type:'POST',
				data:JSON.stringify(json),
				dataType : "json",
				contentType: "application/json; charset=UTF-8",
				success:function(result)
		    {
				//alert(JSON.stringify(result))
				if(result["status"]=="SUCCESS"){
						var flag= confirm("BookMark saved Successfully.\n Do you want to Use it on main page?");
						
						$('#sectionTemplateNameModify').val("");	
						refreshSectionBookMark(bookmarkTypeId);	
						$('#divEditTemplateName').hide();
						$('#sectionBookmarkManage').modal('hide');
						$('.btnTemplate').hide();
						if(flag){
							LoadBookmarkTemplate(bookmarkTypeId,json);
						}
				}
				else{
					alert("Problem while saving template");
				}
				
				
					
		    } ,
		    error: function (xhr, ajaxOptions, thrownError) {
		            alert(xhr.status);
		            alert(thrownError);
		     }
		    	
			});
	}
	else{
		swal("Cannot save blank data!");
	}
		
}
function processJson(){
	
	var bookmarkTypeId=$('#bookmarkTypeIdForModify').val();
	var arrData= new Array();
	//alert(bookmarkTypeId);
	if(bookmarkTypeId=="1" || bookmarkTypeId=="2" || bookmarkTypeId=="3"){
			$('[id^=templateReffralJson_]').each(function(){
				var key= $(this).attr('id').split("_")[1];
				var json=JSON.parse($(this).text());
				json["refferalExtReson"]=$('#templateRefNote_'+key).val();
				json["noAllowed"]=$('#templateNoAllowed_'+key).val();
				arrData.push(json);
			});		
	}
	else if(bookmarkTypeId=="4"){
		$('[id^=templatedrugJson_]').each(function(){
			var key= $(this).attr('id').split("_")[1];
			var json=JSON.parse($(this).text());	
			//alert($('#spanTemplateDrugForm_'+key).text());
			json["drugDosageId"]= $('#templateDoseQty_'+ key).val();
			json["drugDosage"]=$('#templateDoseQty_'+ key).val() + " " + $('#spanTemplateDrugForm_'+key).text();
			json["drugFrequencyId"]= $('#templateDrugFrequency_'+ key).val();
			
			if($('#templateDrugFrequency_'+ key).val()=="-1")
				json["drugFrequency"]= $('#customDrugFrequencyText'+key).val();	
			else
				json["drugFrequency"]= $('#templateDrugFrequency_'+key+' option:selected').text();	
			
			json["drugDays"]= $('#templateDrugDays_'+ key).val();
			json["patientDrugQuantity"]= $('#templateDrugQuantity_'+ key).val();
			json["drugInstructions"]= $('#templateDrugInstruction_'+ key).val();
			//alert(JSON.stringify(json));		
			arrData.push(json);
		});		
	}
	else if(bookmarkTypeId=="5"){
			$('[id^=templateDiagnosisJson_]').each(function(){
				var key= $(this).attr('id').split("_")[1];
				var json=JSON.parse($(this).text());	
				var templateDiagnosisSite=$('#templateDiagnosisSite_'+ key).val();
				json["DiagnosisSideCode"]=templateDiagnosisSite ;
				json["DiagnosisSideName"]= templateDiagnosisSite=="0"?"":$('#templateDiagnosisSite_'+key+' option:selected').text();
				
				var templateDiagnosisType=$('#templateDiagnosisType_'+ key).val();
				json["DiagnosisTypeCode"]=templateDiagnosisType ;
				json["DiagnosisTypeNamee"]= templateDiagnosisType=="0"?"":$('#templateDiagnosisType_'+key+' option:selected').text();
				json["DiagnosisRemarks"]= $('#templateDiagnosisRemarks_'+ key).val().trim()==""?"0":$('#templateDiagnosisRemarks_'+ key).val();
				//alert(JSON.stringify(json));		
				arrData.push(json);
			});		
		}
	return arrData;
}
function LoadTemplate(){
	var bookmarkTypeId=$('#bookmarkTypeIdForModify').val();
	var json=processJson();
	var bookmarkjson={"strjson":JSON.stringify(json)};
	
	LoadBookmarkTemplate(bookmarkTypeId,bookmarkjson);
	$('#sectionBookmarkManage').modal('hide');
}
function LoadBookmarkTemplate(bookmarkTypeId,bookmarkjson){

	switch (bookmarkTypeId){
			case '1':{
				populateInvestigation(bookmarkjson);
				break;
			}
			case '2':{
				populateConsultation(bookmarkjson);
				break;
			}
			case '3':{
				populateProcedure(bookmarkjson);
				break;
			}
			case '4':{
				populateDrug(bookmarkjson);
				break;
			}
			case '5':{
				populateDiagnosis(bookmarkjson);
				break;
			}
			
			
		}	
}
