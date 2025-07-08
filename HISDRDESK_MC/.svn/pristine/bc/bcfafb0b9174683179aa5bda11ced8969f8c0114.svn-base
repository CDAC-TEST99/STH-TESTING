var procedureAllowed=1;
var investigationAllowed=1;
$(document).ready(function(){
	
	var currentPatientDtl= localStorage.getItem("currentPatientDtl");
	
	if(currentPatientDtl==undefined || currentPatientDtl==null){
		alert("Problem while loading patient details!")
		return;
	}
	currentPatientDtl= JSON.parse(currentPatientDtl);
	refreshSectionBookMark("1,2,3");
	$('#patNamePrescriptionPanel').text(currentPatientDtl["patName"])
	$('#patCrNoPrescriptionPanel').text(currentPatientDtl["patCrNo"])
	$('#patGenAgeCatPrescriptionPanel').text(currentPatientDtl["patGenAgeCat"])
	$('#cardType').text(currentPatientDtl["cardType"])
	$('#cardValidityDate').text(currentPatientDtl["cardValidityDate"])
	$('#relation').text(currentPatientDtl["relation"])
	$('#patGenAgeCatPrescriptionPanel').text(currentPatientDtl["patGenAgeCat"])
	
	 $('[name=referralStatus]').click(function(){
			$('#EndorsementDiv').hide();
			var checkedStatus=false;
			if($(this).is(":checked"))
				checkedStatus=true;
			
			var referralType=this.value;
			
			if(referralType==3 && checkedStatus){
				scrollToDiv("EndorsementDiv");										
			}
				
			
		});
	
		$('[name=referType]').click(function(){
				
				var divId=$(this).attr("id").split("_")[1];
				if($('[name=referType]')){
					$('#ExternalDiv').show();
					if($(this).is(":checked")){
						scrollToDiv(divId);
					}
					else{
						$('#'+divId).hide()
					}
					
					
				}else{
					$('#ExternalDiv').hide();
				}
				
				
			});
	
	getExternalRefralConfiguration();
	
	
	getEndorsementHospital();
	getEndorsementDepartment();
	getExternalDepartment();
	getExternalInvestigation();
	getExternalProcedure();
	getExternalFollowup();
	getEndorsementCity();
	
	var cardColor=currentPatientDtl["cardColor"];
	
	if(cardColor!="")
		$('#patient_profile').addClass("patHeader-"+cardColor);
	else
		$('#patient_profile').addClass("patHeader-default");
	
	
		
	$('.loader').hide();
});
function getEndorsementCity(){
	if($('#strEndorsementCity option').length<=1){
				$('#strEndorsementCity').html("");
				
				var data={hmode:"populateEndorsementCity",};
				$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
					dataType: "json",
					data:data,	
					type: "POST",
					success:function(result){ 
						//alert(JSON.stringify(result));	
						$.each(result, function(indx, rowObj){
							var optionValue=rowObj["optionValue"]
							var optionText=rowObj["optionText"]
							if(rowObj["isDefault"]=="1")
								$('#strEndorsementCity').append("<option selected value='"+optionValue+"'>"+optionText+"</option>");
							else
								$('#strEndorsementCity').append("<option value='"+optionValue+"'>"+optionText+"</option>");
						});
					}
				});
			}
			
}
function getEndorsementHospital(){
		//alert("getEndorsementHospital");
		if($('#strEndorsementHospital option').length<=1){
			$('#strEndorsementHospital').html("<option value='' selected>Select Hospital</option>");
			
			
			var data={hmode:"populateEndorsementHospital",};
			$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
				dataType: "json",
				data:data,	
				type: "POST",
				success:function(result){ 
					//alert(JSON.stringify(result));	
					$.each(result, function(indx, rowObj){
						var optionValue=rowObj["optionValue"]
						var optionText=rowObj["optionText"]
						$('#strEndorsementHospital').append("<option value='"+optionValue+"'>"+optionText+"</option>");
					});
				}
			});
		}
		
	}
	function getEndorsementDepartment(){
			
			if($('#strEndorsementDepartment option').length<=1){
				$('#strEndorsementDepartment').html("<option value='' selected>Select Speciality</option>");
				
				
				var data={hmode:"populateEndorsementDepartment",};
				$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
					dataType: "json",
					data:data,	
					type: "POST",
					success:function(result){ 
						//alert(JSON.stringify(result));	
						$.each(result, function(indx, rowObj){
							var optionValue=rowObj["optionValue"]
							var optionText=rowObj["optionText"]
							$('#strEndorsementDepartment').append("<option value='"+optionValue+"'>"+optionText+"</option>");
						});
					}
				});
			}
			
		}

function getExternalDepartment(){
	
	if($('#refferlExtPatientDeptId option').length<=1){
		$('#refferlExtPatientDeptId').html("<option value='' selected>Select Speciality</option>");
		
		
		var data={hmode:"populatestrExternalDepartmentList",};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(JSON.stringify(result));	
				$.each(result, function(indx, rowObj){
					var optionValue=rowObj["optionValue"]
					var optionText=rowObj["optionText"]
					$('#refferlExtPatientDeptId').append("<option value='"+optionValue+"'>"+optionText+"</option>");
				});
				$('#refferlExtPatientDeptId').select2({width: '100%'});
			}
		});
	}
	
}

function getExternalInvestigation(){
	
	if($('#refferlExtInvestigationTest option').length<=1){
		$('#refferlExtInvestigationTest').html("<option value='' selected>Select Investigation</option>");
		
		
		var data={hmode:"populateExternalInvestigation"};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(JSON.stringify(result));	
				$.each(result, function(indx, rowObj){
					var optionValue=rowObj["optionValue"]
					var optionText=rowObj["optionText"]
					$('#refferlExtInvestigationTest').append("<option value='"+optionValue+"'>"+optionText+"</option>");
				});
				$('#refferlExtInvestigationTest').select2({width: '100%'});
			}
		});
	}
	
}


function getExternalProcedure(){
	
	if($('#refferlExtProcedure option').length<=1){
		$('#refferlExtProcedure').html("<option value='' selected>Select Procedure</option>");
		
		
		var data={hmode:"populateExternalProcedure",};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(JSON.stringify(result));	
				$.each(result, function(indx, rowObj){
					var optionValue=rowObj["optionValue"]
					var optionText=rowObj["optionText"]
					$('#refferlExtProcedure').append("<option value='"+optionValue+"'>"+optionText+"</option>");
				});
				$('#refferlExtProcedure').select2({width: '100%'});
			}
		});
	}
	
}


function getExternalFollowup(){
	
	if($('#refferlExtFollowupDeptId option').length<=1){
		$('#refferlExtFollowupDeptId').html("<option value='' selected>Select Speciality</option>");
		
		
		var data={hmode:"populateExternalFollowup",};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(JSON.stringify(result));	
				$.each(result, function(indx, rowObj){
					var optionValue=rowObj["optionValue"]
					var optionText=rowObj["optionText"]
					$('#refferlExtFollowupDeptId').append("<option value='"+optionValue+"'>"+optionText+"</option>");
				});
				
				$('#refferlExtFollowupDeptId').select2({width: '100%'})
			}
		});
	}	
}

function getExternalRefralConfiguration(){
	
	if($('#refralConfiguration').text()==""){
		var data={hmode:"getExternalRefralConfiguration",};
		$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt',
			dataType: "json",
			data:data,	
			type: "POST",
			success:function(result){ 
				//alert(JSON.stringify(result))
				$('#refralConfiguration').text(JSON.stringify(result))
				//populateExternalConfiguration($('#refralConfiguration').text());
			}
		});
	}
	/*else{
		populateExternalConfiguration($('#refralConfiguration').text()); 
	}*/
	
	$('#refferlExtPatientDeptId').change(ValidateAndAddExtConsultationDtl);	
	$('#refferlExtInvestigationTest').change(ValidateAndAddExtInvestigationDtl);	
	$('#refferlExtProcedure').change(ValidateAndAddExtProcedureDtl);
	$('#refferlExtFollowupDeptId').change(ValidateAndAddExtFollowupDtl);	
}


function getUniqueId()
{
	uniqueId= Date.now().toString() + Math.floor(Math.random() * 1000000).toString();
	return uniqueId;
}
function getPatientImg() {
    if($('#patCrNoPrescriptionPanel').text()== null ){
    	return;
    }
    var fileName = $('#patientPhotoName').val();
    
    var fileExt = fileName.split(".")[1].toLowerCase();
   // alert(fileName);
   // fullFileName
   var  crno=$('#patCrNoPrescriptionPanel').text();
   if(crno==""){
		var currentPatientDtl=localStorage.getItem("currentPatientDtl");
		if(currentPatientDtl!=null && currentPatientDtl!=undefined){
			currentPatientDtl=JSON.parse(currentPatientDtl);
			crno =currentPatientDtl["patCrNo"]
		}
		else	
			return;
		if(crno=="")
			return	
   }
   
   
    var urlShortName = '/HISDRDESK_MC/services/restful/search/getBenShortName?CrNo='+ crno;

    $.ajax({
        url: urlShortName,
        method: 'GET',
        success: function(result) {
            //console.log("API Response:", result);
            if (!result || result.length === 0) {
                alert("No patient record found for CrNo: " + $('#patCrNoPrescriptionPanel').text());
                return;
            }
            var shortName = result[0].shortname;
           // alert("Short Name: " + shortName);
            
            var url1 = '/HISDRDESK_MC/services/restful/patdata/getPatientBase64Image?shortName=' + shortName + '&fileName=' + fileName;
            

            $.ajax({
                url: url1,
                method: 'GET',
                success: function(result)             {
        			if(result["status"]=="1"){
        				var base64Img=result["base64Img"];
        				
        				if(fileExt=="jpg"){
        					base64Img="data:image/jpeg;base64," +base64Img
        				}
        				else if(fileExt=="png"){
        					base64Img="data:image/png;base64," +base64Img
        				}
        				$('#imgProfilePic').attr("src", base64Img);
        			}},
                error: function(xhr) {
                    console.error("Failed to load image:", xhr.responseText);
                    alert("Failed to load patient image.");
                }
            });
        },
        error: function(xhr) {
            console.error("Failed to fetch short name:", xhr.responseText);
           // alert("Failed to fetch patient details.");
        }
    });
}


function ValidateAndAddEndorsmentDtl(){
	
	if($('#strEndorsementHospital').val()==""){
		swal('Please select Hospital !');
		return false;
	}
	if($('#strEndorsementDepartment').val()==""){
		swal('Please select Department !');
		return false;
	}
	if($('#strEndorsementDoctor').val().trim()==""){
		swal('Please enter doctor name !');
		return false;
	}
	
	if ($('#strEndorsementDoctor').val().trim().length < 3) {
	       swal('Please enter at least 3 characters!');
	       return;
	 }
	if(!validateName($('#strEndorsementDoctor').val().trim())) {
		swal('Invalid Doctor name !');
		return;
	}
	  
	
	var hospitalCode= ($('#strEndorsementHospital option:selected').val()).split('#')[0];
	var hospitalName=($('#strEndorsementHospital option:selected').text());
	
	
	var deptId= ($('#strEndorsementDepartment option:selected').val()).split('#')[0];
	var depttext=($('#strEndorsementDepartment option:selected').text());
	var strEndorsementDoctor=$('#strEndorsementDoctor').val().trim();
	var strEndorsementDoctor=$('#strEndorsementDoctor').val().trim()
	if(strEndorsementDoctor.toLowerCase().indexOf("dr")<0){
		strEndorsementDoctor="Dr. "+ strEndorsementDoctor;
	}
	
	var reffralJson ={
		"strEndorsementHospitalName":hospitalName,
		"strEndorsementHospitalCode":hospitalCode,
	    "strEndorsementDepartmentName": depttext ,
	    "strReffralDeptId": deptId,
	    "strEndorsementDoctor":strEndorsementDoctor,
	    "strReferralStatus": "3",
	    "strreferralTypeName": "Endorsement",
	    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
	    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text()
	}
	$('#reffralJson_endorsement').text(reffralJson);
	
}
function createEndorementRow(reffralJson,key){
	
	var html='<tr><td>'+reffralJson["strEndorsementHospitalName"]+'</td>';
	html+='<td>'+reffralJson["strEndorsementDepartmentName"]+'</td>';
	html+='<td>'+reffralJson["strEndorsementDoctor"]+'</td>';
	html+='<td>';
	html+='<button style="padding:4px 12px;margin:1px;" id="btndelEndorsementRow_'+key+'" class="btn btn-danger btn-sm" type="button">x</button>';
	html+='<span id="reffralJson_'+key+'" style="display :none">'+JSON.stringify(reffralJson)+'</span></td>';
	html+='</tr>';
	$('#EndorsementListTable tbody').append(html);
	$('#EndorsementListTable').show();
	$('[name=referralStatus]').prop("disabled", true);
	$('#btndelEndorsementRow_'+key).click(function(){
		$(this).closest('tr').remove();
		if($('#EndorsementListTable tbody tr').length==0){
			$('#EndorsementListTable').hide();
			$('.endorsmentEntry').show();
			//$('#referralStatus3').prop("disabled",  false);
			$('[name=referralStatus]').prop("disabled", false);
		}
	});
}
function getCheckedReferralStatusVal(){
	
	if($('#referralStatus2').is(":checked"))
		strReferralStatus=$('#referralStatus2').val();
	else if($('#referralStatus3').is(":checked"))
		strReferralStatus=$('#referralStatus3').val();
	else{
		alert("invalid refral status")
		strReferralStatus= 0;
	}
	return strReferralStatus;
}


function ValidateAndAddExtConsultationDtl(){
	
	
	
	if($('#refferlExtPatientDeptId').val()==""){
		swal('Please select Speciality !');
		return false;
	}
	var noOfConsultationAllowed= $('#noOfConsultationAllowed').val();
	
	if(noOfConsultationAllowed==""){
		swal('Please enter no. of consultatation !');
		return false;
	}
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultConsultationAllowed= json["consultationAllowed"];
	var defaultConsultationValidity= json["consultationValidity"];
	var noOfConsultationAllowed=json["consultationAllowed"];
	
	
	var deptId= ($('#refferlExtPatientDeptId option:selected').val()).split('#')[0];
	var depttext=($('#refferlExtPatientDeptId option:selected').text());
	var key='extcon-'+ deptId;
	if($('#btndel_'+ key).length>0){
		swal('This speciality already added');
		return false;
	}
	var strReferralStatus=getCheckedReferralStatusVal();
	if(strReferralStatus==0)
		return;

	var reffralJson ={
		"strReffralExtName":depttext ,
	    "strReffralExtId": deptId ,
	    "refferalExtReson":"",
	    "strReferralStatus": strReferralStatus,
	    "strreferralTypeName": "Consultation",
	    "strreferralTypeCode": "1",
	    "noAllowed":noOfConsultationAllowed, 
	    "validUpto":json["consultationValidity"], 
	    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
	    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text(),
	    "defaultAllowed":defaultConsultationAllowed,
		"refferExtCGHSCode":"OC001A" 
	}
	

	createExternalRow(reffralJson, "ExternalConsultationListTable", key);
	$('#refferlExtPatientDeptId').val("");
	$('#refferalExtResonId').val("");
	$('#noOfConsultationAllowed').val(defaultConsultationAllowed);
	$('#validUpto').val(defaultConsultationValidity);
	EnableDiableExternalCheckboxes();		
	
}

function createExternalRow(reffralJson, tableId, key) {
    //console.log("reffralJson:", reffralJson);
    //console.log("tableId:", tableId);
    //console.log("key:", key);
    

    
    if ($('#btndel_' + key).length > 0) {
        return;
    }
    
    var className = "";
    if (reffralJson["isAvailableInCGHS"] != undefined && reffralJson["isAvailableInCGHS"] == '1') {
        className = "refTrGreen";
    }

    var html = '<tr class="'+className+'">';
	html += '<td style="padding-top: 19px !important;" class="'+tableId+'sno">' + reffralJson["strReffralExtName"] + '</td>';
    html += '<td style="padding-top: 19px !important;font-weight: bold;">' + reffralJson["strReffralExtName"] + '</td>';
    html += '<td><input type="text" class="form-control multirowtextfield" id="refNote_' + key + '" value="' + reffralJson["refferalExtReson"] + '" maxlength="1000"  /></td>';
    html += '<td><input type="text" class="form-control multirowtextfield" id="noAllowed_' + key + '" value="' + reffralJson["noAllowed"] + '" onkeypress="return isNumber(event)" maxlength="2" /></td>';
    html += '<td style="padding-top: 19px;text-align:center;" >' + reffralJson["validUpto"] + '</td>';
    html += '<td>';
    html += '<button style="padding:4px 12px;margin:1px;"  id="btndel_' + key + '" class="btn btn-danger btn-sm" type="button">x</button>';
	html += '<input type="hidden" id="strreferralTypeCode_' + key + '" value="'+reffralJson["strreferralTypeCode"]+'">'
    html += '<span id="reffralJson_' + key + '" style="display :none">' + JSON.stringify(reffralJson) + '</span></td>';
    html += '</tr>';
    $('#' + tableId + ' tbody').append(html);
    $('#' + tableId).show();
    
    if (tableId === 'ExternalConsultationListTable') {
        var elementId = 'noAllowed_' + key;
        var tdElement = $('#' + elementId);
        var columnIndex = tdElement.closest('td')[0].cellIndex;
        var thElement = tdElement.closest('table').find('thead th').eq(columnIndex);

        // Completely hide the column
        thElement.css('display', 'none');
        tdElement.closest('td').css('display', 'none');
    }
	generateTableSequence(tableId);

    $('#btndel_' + key).click(function() {
		var tableId=$(this).closest('table').attr("id");
        $(this).closest('tr').remove();
        EnableDiableExternalCheckboxes();
		generateTableSequence(tableId);
    });
    
    $('.multirowtextfield').blur(ValidateAndUpdateJson);
	
	initAutoCompleteForRefNote(key);
	$('#refNote_'+key).blur(createAutocompleteRecordForReferral);
}
function generateTableSequence(tableId){
	var sno=1;
	$('.'+ tableId+'sno').each(function(){
		$(this).text(sno++);
	});
}
function initAutoCompleteForRefNote(key){
	
	var strreferralTypeCode= $('#strreferralTypeCode_'+key).val();
	var Tag=null;
	switch(strreferralTypeCode) {
    	  case "1":
			Tag=getTagFromLocalStorage("refNoteConsultationTag");
    	    break;
    	  case "2":
			Tag=getTagFromLocalStorage("refNoteInvestigationTag");
    	    break;
    	  case "3":
			  Tag=getTagFromLocalStorage("refNoteProcedureTag");
    	    break;
    	  case "4":
			  Tag=getTagFromLocalStorage("refNoteFollowUpTag");	    		  
    	    break;    	  
     }
	 if(Tag!=null && Tag!=undefined && Tag.length>0)
	 	$('#refNote_'+key).autocomplete({source: Tag });
		
}
function createAutocompleteRecordForReferral(){
	var key=$(this).attr("id").split("_")[1];
	var text= $(this).val().trim();
	var strreferralTypeCode= $('#strreferralTypeCode_'+key).val()
	if(text!=""){
		switch(strreferralTypeCode) {
	    	  case "1":
	    		  storeTagInLocalStorage("refNoteConsultationTag", text);
	    	    break;
	    	  case "2":
	    		  storeTagInLocalStorage("refNoteInvestigationTag", text);
	    	    break;
	    	  case "3":
	    		  storeTagInLocalStorage("refNoteProcedureTag", text);
	    	    break;
	    	  case "4":
	    		  storeTagInLocalStorage("refNoteFollowUpTag", text);
	    	    break;    	  
	    }	
	}
	
}


function ValidateAndUpdateJson(){
	var key=$(this).attr("id").split("_")[1];
	var json=JSON.parse($('#reffralJson_'+key).text());
	
	//alert("json>>>>"+JSON.stringify(json))
	var defaultAllowed= json["defaultAllowed"]
	//alert(defaultAllowed); 
	var noAllowed = $('#noAllowed_'+key).val().trim(); 
	if(noAllowed==""){
		swal('Please enter No. Allowed !');
		$('#noAllowed_'+key).focus();
		return false;
	}
	
	if(noAllowed=="0"){
		swal('No. Allowed cannot be zero !' );
		$('#noAllowed_'+key).focus();
		$('#noAllowed_'+key).val("1");
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
	

	
	//changed on 24/05/2025 --dev
	/*if(noAllowed<defaultAllowed){
		//alert(1);
		swal('No. allowed cannot be greater than '+ defaultAllowed );		
		$('#noAllowed_'+key).val(noAllowed);
		return false;
	}*/
	var refNote= $('#refNote_'+key).val().trim();
	
	json["refferalExtReson"]=refNote;
	json["noAllowed"]=noAllowed;
	
	//alert(JSON.stringify(json));
	$('#reffralJson_'+key).text(JSON.stringify(json));
	
}


function ValidateAndAddExtInvestigationDtl(){
	
	if($('#refferlExtInvestigationTest').val()==""){
		swal('Please select Test for adding !');
		return false;
	}
	var arrVal= $('#refferlExtInvestigationTest').val().split("#");
	var isTestAvalaibleInCGHS=arrVal[3];
	
	var noOfInvestigationAllowed= "1";
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultInvestigationAllowed= arrVal[2];
	var defaultInvestigationValidity= json["investigationValidity"];
	
	var refferlExtInvestigationTestId= ($('#refferlExtInvestigationTest option:selected').val()).split('#')[0];
	var refferlExtInvestigationCGHSTestCode= ($('#refferlExtInvestigationTest option:selected').val()).split('#')[1];
	
	var refferlExtInvestigationTestName=($('#refferlExtInvestigationTest option:selected').text());
	var key='extinv-'+ refferlExtInvestigationTestId;
	//alert(key);
	//alert($('#btndel_'+ key).length);

	
	var len=$('[id^=btndel_'+ key).length;
	if(len>0){
		//alert("here");
			var flag =confirm('This test already added \n do you want to add again?');
			if (flag==false)
				return;		
	}
	key= key+(len+1);
	
	var strReferralStatus=getCheckedReferralStatusVal();
	if(strReferralStatus==0)
		return;
	
	var reffralJson ={			
		    "strReffralExtName": refferlExtInvestigationTestName,
		    "strReffralExtId": refferlExtInvestigationTestId,
		    "refferExtCGHSCode":refferlExtInvestigationCGHSTestCode,
		    "refferalExtReson":"",
		    "strReferralStatus": strReferralStatus,
		    "strreferralTypeName": "Investigation",
		    "strreferralTypeCode": "2",
		    "noAllowed":noOfInvestigationAllowed, 
		    "validUpto":defaultInvestigationValidity, 
		    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
		    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text(),
		    "isAvailableInCGHS":isTestAvalaibleInCGHS,
		    "defaultAllowed":defaultInvestigationAllowed
		}
	
	createExternalRow(reffralJson, "ExternalInvestigationListTable", key);
	
	$('#refferlExtInvestigationTest').val("");
	$('#refferlExtInvestigationReason').val("");
	$('#refferlExtInvestigationNoAllowed').val(investigationAllowed);
	$('#refferlExtInvestigationNoAllowedValidUpto').val(defaultInvestigationValidity);
	EnableDiableExternalCheckboxes();
}

function ValidateAndAddExtProcedureDtl(){
	if($('#refferlExtProcedure').val()==""){
		swal('Please select procedure for adding !');
		return false;
	}
	var noOfProcedureAllowed= "1";
	
	
	var arrVal= $('#refferlExtProcedure').val().split("#");
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultProcedureAllowed= arrVal[2];
	var defaultProcedureValidity= json["procedureValidity"];
	
	var refferlExtProcedureId= ($('#refferlExtProcedure option:selected').val()).split('#')[0];
	var refferlExtProcedureCGHSTestCode= ($('#refferlExtProcedure option:selected').val()).split('#')[1];
	var rrefferlExtProcedureName=($('#refferlExtProcedure option:selected').text());
	var key='extproc-'+ refferlExtProcedureId;
	var len=$('[id^=btndel_'+ key).length;
	if(len>0){
		var flag =confirm('This procedure already added \n do you want to add again?');
		if (flag==false)
			return;		
	}
	key= key+(len+1);
	var strReferralStatus=getCheckedReferralStatusVal();
	if(strReferralStatus==0)
		return;
	
	var reffralJson ={
			"strReffralExtName": rrefferlExtProcedureName,
		    "strReffralExtId": refferlExtProcedureId,
		    "refferExtCGHSCode":refferlExtProcedureCGHSTestCode,
		    "refferalExtReson":"",
		    "strReferralStatus": strReferralStatus,
		    "strreferralTypeName": "Procedure",
		    "strreferralTypeCode": "3",
		    "noAllowed":noOfProcedureAllowed, 
		    "validUpto":defaultProcedureValidity, 
		    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
		    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text(),
		    "defaultAllowed":defaultProcedureAllowed
		}

	//alert(JSON.stringify(reffralJson));
	createExternalRow(reffralJson, "ExternalProcedureListTable", key);
	
	$('#refferlExtProcedure').val("");
	$('#refferalExtProcedureReason').val("");
	$('#refferlExtProcedureNoAllowed').val(procedureAllowed);
	$('#refferlExtProcedureValidUpto').val(defaultProcedureValidity);
	EnableDiableExternalCheckboxes();	
}


function ValidateAndAddExtFollowupDtl(){
	if($('#refferlExtFollowupDeptId').val()==""){
		swal('Please select follow-up speciality for adding !');
		return false;
	}
	
	var json=JSON.parse($('#refralConfiguration').text())[0];
	var defaultFollowupAllowed= json["followupAllowed"];
	var defaultFollowupValidity= json["followupValidity"];
	
	var refferlExtFollowupDeptId= ($('#refferlExtFollowupDeptId option:selected').val()).split('#')[0];
	var refferlExtFollowupDeptName=($('#refferlExtFollowupDeptId option:selected').text());

	var key='extfollowup-'+ refferlExtFollowupDeptId;
	
	if($('#btndel_'+ key).length>0){
		swal('This followup speciality  already added');
		return false;
	}
	var strReferralStatus=getCheckedReferralStatusVal();
	
	if(strReferralStatus==0)
		return;
	
	var reffralJson ={
			"strReffralExtName": refferlExtFollowupDeptName,
		    "strReffralExtId": refferlExtFollowupDeptId,
		    "refferalExtReson":"",
		    "strReferralStatus": strReferralStatus,
		    "strreferralTypeName": "Follow up",		    
		    "strreferralTypeCode": "4",
		    "noAllowed":defaultFollowupAllowed, 
		    "validUpto":defaultFollowupValidity, 
		    "episodeCode": $('#patEpisodeCodePrescriptionPanel').text(),
		    "visitNo": $('#patEpisodeVisitNoPrescriptionPanel').text(),
		    "defaultAllowed":defaultFollowupAllowed,
			"refferExtCGHSCode":"OC001A"
		}
	
	createExternalRow(reffralJson, "ExternalFollowUpListTable", key);
	
	$('#refferlExtFollowupDeptId').val("");
	$('#refferalExtFollowupReason').val("");
	$('#extFollowupNoOfConsultationAllowed').val(defaultFollowupAllowed);
	$('#extFollowupValidUpto').val(defaultFollowupValidity);
	EnableDiableExternalCheckboxes();	
}

function EnableDiableExternalCheckboxes(){
	var  empty= true;
	if($('#ExternalFollowUpListTable tbody tr').length>0){
		empty=false;		
		$('#referType_extFollowup').prop("disabled",  true);
		$('#ExternalFollowUpListTable').show();		
	}
	else{
		$('#referType_extFollowup').prop("disabled",  false);
		$('#ExternalFollowUpListTable').hide();
	}
	if($('#ExternalProcedureListTable tbody tr').length>0){
		empty=false;
		$('#referType_extProcedure').prop("disabled",  true);
		$('#ExternalProcedureListTable').show();
	}
	else{
		$('#referType_extProcedure').prop("disabled",  false);
		$('#ExternalProcedureListTable').hide();
	}
	
	if($('#ExternalInvestigationListTable tbody tr').length>0){
		empty=false;
		$('#referType_extInvestigation').prop("disabled",  true);
		$('#ExternalInvestigationListTable').show();
	}
	else{
		$('#referType_extInvestigation').prop("disabled",  false);
		$('#ExternalInvestigationListTable').hide();
	}
	
	if($('#ExternalConsultationListTable tbody tr').length>0){
		empty=false;
		$('#referType_extConsultation').prop("disabled",  true);
		$('#ExternalConsultationListTable').show();
	}
	else{
		$('#referType_extConsultation').prop("disabled",  false);
		$('#ExternalConsultationListTable').hide();
	}
	//enableDisableReferStatusForExternal();	
	/*if(empty){
		$('#referralStatus2').prop("disabled",  false);	
	}
	else{
		$('#referralStatus2').prop("disabled",  true);
	}*/
	
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

function resetAllDataForReferral(){
	$('#EndorsementDiv').hide();	
	$('#extConsultation').hide();
	$('#extInvestigation').hide();
	$('#extProcedure').hide();
	$('#extFollowup').hide();
	$('#divReferType').hide();
	
	$("[name=referType]").prop("checked", false);
	$("[name=referType]").prop("disabled", false);
	
	
	//$('#TransferListTable').hide();
	$('#ExternalConsultationListTable').hide();
	$('#ExternalInvestigationListTable').hide();
	$('#ExternalProcedureListTable').hide();
	$('#ExternalFollowUpListTable').hide();
	
	//$('#TransferListTable tbody').empty();
	$('#ExternalConsultationListTable tbody').empty();
	$('#ExternalInvestigationListTable tbody').empty();
	$('#ExternalProcedureListTable tbody').empty();
	$('#ExternalFollowUpListTable tbody').empty();	
}
function enableDisableReferStatusForExternal(){
	if($('#referralStatus2').is(":checked")){
		if($('#ExternalConsultationListTable tbody tr').length>0 || $('#ExternalInvestigationListTable tbody tr').length>0 ||
				$('#ExternalProcedureListTable tbody tr').length>0 || $('#ExternalFollowUpListTable tbody tr').length>0
		){
			$('[name=referralStatus]').prop("disabled", true);
		}
		else{
			$('[name=referralStatus]').prop("disabled", false);
		}
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
