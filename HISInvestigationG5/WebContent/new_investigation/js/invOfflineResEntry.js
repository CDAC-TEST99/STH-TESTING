function abc(){
	  var _mode = "AJX_TEST_DTL";
	  $.ajax({
          type: "POST",
          url: "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode,
          contentType: "html",
          async: false,
          success: function (data) {
        	  document.getElementById("divtestdtl").innerHTML = data;
              //$("#response").html(data.d);
              //alert(data);
          }
      });
	  }
  
function showLabTestDtl()
  {
	  var autoGenFormate = "";
	  var _mode = "AJX_TEST_DTL";
	  
	  var urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode;
	  //urlNew  = createFHashAjaxQuery(urlNew);
	  var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
  	  load: function(data) 
  		{
  			autoGenFormate = data;
  			
  		},
          error: function(error)
          {
              alert("faill");
          }};

  	var objDojoAjax = dojo.xhrPost(objXHR);
  	document.getElementById("divtestdtl").innerHTML = autoGenFormate; 
  }
  
function showTest(testCode){
	  if(document.getElementById("strTrToggle"+testCode).value == "1"){
		  $('#product_info_table #tr'+testCode).hide();
		  document.getElementById("strTrToggle"+testCode).value = "0";
		  document.getElementById("strDivImg"+testCode).innerHTML = "<img src='/HISInvestigationG5/hisglobal/images/arrow-down.png' width='16'>";
	  }else{
		  $('#product_info_table #tr'+testCode).show();
		  document.getElementById("strTrToggle"+testCode).value = "1";
		  document.getElementById("strDivImg"+testCode).innerHTML = "<img src='/HISInvestigationG5/hisglobal/images/arrow-up.png' width='16'>";
		  }
	  }

function showDetailsText(obj,index){	  
		
	  if(((obj.value).trim()).length > 0){		
		  
			document.getElementById("strHiddenValue"+index).value = document.getElementById("strTestVal"+index).value;
		}else{
			document.getElementById("strHiddenValue"+index).value = 0;
		}
	}

//Function to toggle the checkbox. 18.1.2021 -Deepti
function enableFields(chkObj,index,testcode){
	 
	  document.getElementById("strHiddenValue"+index).value = 0;
	  if(chkObj.checked){
			var seleTextBoxIndex= index;
		  $("[id$='"+testcode+"']").each(function(){
			  document.getElementById("strTestResultId"+index+"#"+testcode).disabled= false;
			  document.getElementById("strTestResultId"+index+"#"+testcode).value= "";
			  document.getElementById("strTestResultId"+seleTextBoxIndex+"#"+testcode).focus();
			  index++;
		});	  	
	  }
	  else {
		  $("[id$='"+testcode+"']").each(function(){
			  document.getElementById("strTestResultId"+index+"#"+testcode).disabled= true;
			  document.getElementById("strTestResultId"+index+"#"+testcode).value= "";
			  index++;
		});
	  	}
	  } 

//Function added by Deepti to bring the list of result entries. 21.01.2021
function showResultEntries() {
	  
      document.forms[0].hmode.value = "viewResultEntries";
	  document.forms[0].submit();

	  }

//Function to validate the Result Field for the range value.
function validateRangeVal(obj,index){

		var refrange = document.getElementById("strRefRangeValId"+index).value;
		var highrange = document.getElementById("strTestLowValueId"+index).value;
		var lowrange = document.getElementById("strTestHighValueId"+index).value;

		 if(!isNaN(parseFloat(lowrange)) || !isNaN(parseFloat(lowrange)) )	//if(!refrange.includes("- - - -")) /^\d+$/
			{
				var resultVal = obj.value;
				if(resultVal.match(/^\d*\.?\d*$/))  
					{
						
					}
				else{
					alert("Enter only Numeric value for the Result !");
					obj.value="";
					return false;
					}
			}

		else {
				var resultVal = obj.value;
				if(!resultVal.match(/^[a-zA-Z0-9 -]*$/))  
				{
					alert("Enter Alphanumeric value for the Result !");
					obj.value="";
					return false;
				}
			}
	  }

//Function to take the CR num of already registered patient if "Is Old Patient" is checked.
  
function oldPatDtl(obj){

	if(obj.checked){
		
		//Disable all the elements of the pat demographic Div.
		var nodes = document.getElementById("patDtlId").getElementsByTagName('*');
		for(var i = 0; i < nodes.length; i++){
		     nodes[i].disabled = true;
		  }
		var nodes1 = document.getElementById("patTestDateDtlId").getElementsByTagName('*');
		for(var i = 0; i < nodes1.length; i++){
		     nodes1[i].disabled = true;
		  }

		var nodes2 = document.getElementById("showPatCRNoId").getElementsByTagName('*');
		for(var i = 0; i < nodes2.length; i++){
		     nodes2[i].disabled = false;
		  }
		document.getElementById("patDtlId").style.display="none";
		document.getElementById("patTestDateDtlId").style.display="none";
		document.getElementById("offlineTestsListId").style.display="none";
		document.getElementById("offlineEntryFormFooterId").style.display="none";
		document.getElementById("showPatCRNoId").style.display="";
		}
		if(!obj.checked){
			
			//Enable all the elements of the pat demographic Div.
			var nodes = document.getElementById("patDtlId").getElementsByTagName('*');
			for(var i = 0; i < nodes.length; i++){
			     nodes[i].disabled = false;
			  }
			var nodes1 = document.getElementById("patTestDateDtlId").getElementsByTagName('*');
			for(var i = 0; i < nodes1.length; i++){
			     nodes1[i].disabled = false;
			  }
			var nodes2 = document.getElementById("showPatCRNoId").getElementsByTagName('*');
			for(var i = 0; i < nodes2.length; i++){
			     nodes2[i].disabled = true;
			  }
			document.getElementById("showPatCRNoId").style.display="none";
			document.getElementById("patDtlId").style.display="";
			document.getElementById("patTestDateDtlId").style.display="";
			document.getElementById("offlineTestsListId").style.display="";
			document.getElementById("offlineEntryFormFooterId").style.display="";
			}
	  }

  //Function to display the details of the already registered patient.
  
function getPatDtl(){
	
	

	  if (document.getElementById("patCRNoId").value=="" && document.getElementById("patMobNoId").value=="")
		  {
		 	 alert('Enter a valid CR or Mobile number !');
			 return;
		  }
		  if (document.getElementById("patMobNoId").value!="" && document.getElementById("patMobNoId").value.length !=10){
				alert('Enter a valid Mobile number !');
				return;
			  }
		  if (document.getElementById("patCRNoId").value!="" && document.getElementById("patCRNoId").value.length !=15){
				alert('Enter a valid CR number !');
				return;
			  }
	
	  else
		  {
		  
		  var res = "";
		  var _mode = "getRegisteredPatientDetail";
		  var crNo = document.getElementById("patCRNoId").value;
		  var mobNo = document.getElementById("patMobNoId").value;
		  var urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode+"&cr_no="+crNo+"&mob_no="+mobNo;
		  var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
	  	  load: function(data) 
	  		{
	  		res = data;
	  		},
	          error: function(error)
	          {
	              alert("fail");
	          }};
		  var objDojoAjax = dojo.xhrPost(objXHR);
		  
		  document.getElementById("multiPatListDataId").innerHTML = res;

		  $('#multiplePatientListId').modal('show');

		  if(res.trim() == null || res.trim() == ""){
	
			  alert('No Record Found for the entered CR/Mobile Number');
			  return;
		  }
	  	if(res.trim() != null || res.trim() != "") {
	  	document.forms[0].isAlreadyPatient.value = "1";

	  	//Make the Div's shown/hide.
	  	document.getElementById("patDtlId").style.display = "";
	  	document.getElementById("patTestDateDtlId").style.display="";
	  	document.getElementById("showPatCRNoId").style.display="none";
	  	document.getElementById("offlineTestsListId").style.display="";
		document.getElementById("offlineEntryFormFooterId").style.display="";
		document.getElementById("reset_btn_id").style.display="none";

	  	//enable the Div-elements.
	  	var nodes1 = document.getElementById("patTestDateDtlId").getElementsByTagName('*');
		for(var i = 0; i < nodes1.length; i++){
		     nodes1[i].disabled = false;
		}

			  	var val = res.split(",");
			  	document.forms[0].patName.value=val[0];  //Set Name.
			  	document.forms[0].patGenderCode.value=val[1]; //set Gender.
			  	document.forms[0].strPatAge.value=val[2];  //Set Age.
			  	document.forms[0].strPatAgeUnit.value=val[3]; // Set Age Unit.
			  	document.forms[0].patGuardianName.value=val[4];  //Set Father/Spouse Name.
			  	document.forms[0].patMobileNo.value=val[5];  //Set Mobile number.
			  	document.forms[0].patAdd.value=val[6];  //Set Address.
			  	
			  	document.forms[0].patCRNo.value=val[7]; //Set CR Number In case of search by mobile number.
			  	
			  	var strDt= new Date(val[8]);
			  				  	
			  		$("#samplecoldate").datepicker({format: 'dd-mm-yyyy',autoclose: true,todayHighlight: true, endDate: '+0d',startDate: strDt});
			  	
	  			//document.getElementById("patInfoDivId").innerHTML = res;
			  	var nodes2 = document.getElementById("patDtlId").getElementsByTagName('*');
				for(var i = 0; i < nodes2.length; i++){
				     nodes2[i].disabled = true;
				}
	   		}
	 	else {

		 	alert("No Data found for the CR No. !")
			return;
		 }
	  }
	}

function validateInputType(obj,type){

		  var inputVal= obj.value;


		  if(inputVal.trim().length == 0){

				obj.value="";
				return false;
			}
		if(type=='1'){
						if(!inputVal.match(/^[a-zA-Z ]+$/)) {  //Only Alphbets with spaces without leading spaces. >> /^[a-zA-Z-][a-zA-Z -]*$/
							
							//alert('Only Alphabets are allowed');
							obj.value="";
							return false;
						}
					} 
		if(type=='2'){
					if(!inputVal.match(/^[0-9]+$/)) {  //Only numbers without leading zeross.  /^(0|[1-9][0-9])*$/
						
						//alert('Only digits are allowed');
						obj.value="";
						return false;
					}
				} 
		
		if(type=='3'){
			if(!inputVal.match(/^[0-9a-zA-Z!@&#,-._/ )( ]+$/)) {  //for address validation.
				
				//alert('Only digits are allowed');
				obj.value="";
				return false;
			}
		} 
	  }

// Function to compare and validate Sample Collection and Result Entry Dates at the form. -- Deepti 12.03.2021
function validateDates(){

	var sampleDtArr= document.getElementById("samplecoldate").value.split("-");
	var resEntryDtArr= document.getElementById("resultDate").value.split("-");

		var fmonth=sampleDtArr[1];
 		var fday=sampleDtArr[0];
 		var fyear=sampleDtArr[2];

 		var sampleDt = new Date(fmonth+" "+fday+" "+fyear);

 		var tmonth=resEntryDtArr[1];
 		var tday=resEntryDtArr[0];
 		var tyear=resEntryDtArr[2];

 		var resEntryDt = new Date(tmonth+" "+tday+" "+tyear);
 		
 		if(sampleDt > resEntryDt)
 			{
 	 			alert("Sample Collection Date can not be later than Result Entry Date");
 	 			return;// false;
 			 }
 		var date1 = sampleDt;
 		date1.setDate(date1.getDate() + 7);

 		if(sampleDt < resEntryDt && resEntryDt > date1){
 			alert("Result Entry Date should be within 7 days of Sample Collection Date");
 			document.getElementById("samplecoldate").value="";
	 			return;
 		}
}

//Function to Reset the CR No. & Mob No. fields at the "is Already Registered page." --15.03.2021
function resetFields(){
	
	document.getElementById("patMobNoId").value= "";
	document.getElementById("patCRNoId").value= "";
}

//Function to validate the mobile number pattern in India.
function validateMobNo()
{
	var num =document.getElementById("patMobileNo").value;
	var replacestring = /^0+/;
	num = num.replace(replacestring,"");
	if(num.trim().length != 10){
		
		alert('Please enter valid mobile number.');
		document.getElementById("patMobileNo").value="";
		document.getElementById("patMobileNo").focus();
		return;
	}
	if(num.trim().length==10 && num.charAt(0)<6)
		{
			alert("Mobile number should start with 6,7,8 or 9 only !");
			document.getElementById("patMobileNo").value="";
			return;
		}
}

//Function to validate the Age field.
function validateAge()
{
	var age= document.getElementById("strPatAge").value;
	var e= document.getElementById("strPatAgeUnit");
	var ageUnit = e.options[e.selectedIndex].value;
	
	 if((age<1 || age > 125) && ageUnit=="Y"){
		 alert("Please select age between 1 to 125 years");
		 document.getElementById("strPatAge").value="";
		 return;
	 }
	 if((age<1 || age >  1500) && ageUnit=="M"){
		 alert("Please select age between 1 to 1500 months");
		 document.getElementById("strPatAge").value="";
		 return;
	 }
	 if((age<1 || age >  6517) && ageUnit=="W"){
		 alert("Please select age between 1 to 6517 weeks");
		 document.getElementById("strPatAge").value="";
		 return;
	 }
	 if((age<1 || age >  45625) && ageUnit=="D"){
		 alert("Please select age between 1 to 45625 days");
		 document.getElementById("strPatAge").value="";
		 return;
	 }
}

//Function to check whether the duplicacy check is required for the selected hospital.
function isDuplicacyAllowed(hospComboObj){
	
	if(document.getElementById("patName").value.trim()=="" || document.getElementById("patName").value.trim()==null){
		alert('Please enter name');
		$('#strPatHospCodeId option').prop('selected', function() {
	        return this.defaultSelected;
	    });
		return;
	}
	if(document.getElementById("strPatAge").value.trim()=="" || document.getElementById("strPatAge").value.trim()==null){
		alert('Please enter age');
		$('#strPatHospCodeId option').prop('selected', function() {
	        return this.defaultSelected;
	    });
		return;
	}
	if(document.getElementById("patGenderCodeId").value.trim()=="-1" || document.getElementById("patGenderCodeId").value.trim()==-1){
		alert('Please select gender');
		$('#strPatHospCodeId option').prop('selected', function() {
	        return this.defaultSelected;
	    });
		return;
	}
	if(document.getElementById("patGuardianName").value.trim()=="" || document.getElementById("patGuardianName").value.trim()==null){
		alert('Please enter father/Spouse name');
		$('#strPatHospCodeId option').prop('selected', function() {
	        return this.defaultSelected;
	    });
		return;
	}
	if(document.getElementById("patMobileNo").value.trim()=="" || document.getElementById("patMobileNo").value.trim()==null){
		alert('Please enter Mobile number');
		$('#strPatHospCodeId option').prop('selected', function() {
	        return this.defaultSelected;
	    });
		return;
	}
	var hospCode= hospComboObj.value;
	var _mode= "isDuplicacyReqd"
	var urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode+"&hospCode="+hospCode;
	  var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
	  load: function(data) 
		{
		res = data;
		},
        error: function(error)
        {
            alert("Error Occurred");
        }};
	  var objDojoAjax = dojo.xhrPost(objXHR);

	  if(res=='1'){
		  
		  document.forms[0].isDuplicacyChkRqd.value= "1";
		  
		  var p_name = document.getElementById("patName").value.trim();
		  var p_gender = document.getElementById("patGenderCodeId").value;
		  var p_age = document.getElementById("strPatAge").value.trim();
		  var p_ageUnit = document.getElementById("strPatAgeUnit").value;
		  var p_guadianName = document.getElementById("patGuardianName").value.trim();
		  var p_mob = document.getElementById("patMobileNo").value.trim();
		  
		  _mode = "getDuplicateRecord";
		  
		  urlNew = "/HISInvestigationG5/new_investigation/invOfflineResultEntryTemplateTile.cnt?hmode="+_mode+"&p_hospCode="+hospCode+"&p_name="+p_name+"&p_gender="+p_gender+"&p_age="+p_age+"&p_ageUnit="+p_ageUnit+"&p_guadianName="+p_guadianName+"&p_mob="+p_mob;
		  var objXHR = {url: urlNew, sync:true, postData: "", handleAs: "text",
		  load: function(data) 
			{
			res = data;
			},
	        error: function(error)
	        {
	            alert("Error Occurred");
	        }};
		  var objDojoAjax = dojo.xhrPost(objXHR);
		  
		  if(res != null || res != ""){
			  document.getElementById("dupPatListDataId").innerHTML = res;
			  res = "";
			  $('#duplicatePatientListId').modal('show'); 
		  }
		  else{
			  $('#duplicatePatientListId').modal('hide');
			  
		  }
	  }
}

//Function to Switch to IsAlreadyRegistered on click of Radio button of Duplicate record List.

function switchToAlreadyRegistered()
{
	var radioval = document.getElementById('dupPatid').value;

  	document.forms[0].isAlreadyPatient.value = "1";

  	//Make the Div's shown/hide.
  	document.getElementById("patDtlId").style.display = "";
  	document.getElementById("patTestDateDtlId").style.display="";
  	document.getElementById("showPatCRNoId").style.display="none";
  	document.getElementById("offlineTestsListId").style.display="";
	document.getElementById("offlineEntryFormFooterId").style.display="";

  	//enable the Div-elements.
  	var nodes1 = document.getElementById("patTestDateDtlId").getElementsByTagName('*');
	for(var i = 0; i < nodes1.length; i++){
	     nodes1[i].disabled = false;
	}

		  	var val = radioval.split("$");
		  	document.forms[0].patName.value=val[1];  //Set Name.
		  	document.forms[0].patGenderCode.value=val[2]; //set Gender.
		  	document.forms[0].strPatAge.value=val[3];  //Set Age.
		  	document.forms[0].strPatAgeUnit.value=val[4]; // Set Age Unit.
		  	document.forms[0].patGuardianName.value=val[6];  //Set Father/Spouse Name.
		  	document.forms[0].patMobileNo.value=val[5];  //Set Mobile number.
		  	document.forms[0].patAdd.value=val[7];  //Set Address.
		  	
		  	document.forms[0].patCRNo.value=val[0]; //Set CR Number In case of search by mobile number.
		  	
		  	var nodes2 = document.getElementById("patDtlId").getElementsByTagName('*');
			for(var i = 0; i < nodes2.length; i++){
			     nodes2[i].disabled = true;
			}
   		
			$('#duplicatePatientListId').modal('hide');
}


//Added By Tripti for Search feature in the form. - 17.09.2021
function getRegisteredPatDtl() {
	
	//alert('testing getRegisteredPatDtl');
	 var selVal="";
	  var selFlg= false;
	  var patdtlradio = document.getElementsByName("multiPat");
	 	for(var i=0;i< patdtlradio.length; i++)
		 	{
				if(patdtlradio[i].checked){
					selVal = patdtlradio[i].value;
					selFlg=true;
				}
		 	}
	 	if(selFlg==false){
				alert('Select a record to proceed !');
				return;
		 	}
	 	if(selFlg==true){
	 		
				var cr_no = selVal.split("$")[0].trim();
				var p_name = selVal.split("$")[1].trim();
				var p_gender = selVal.split("$")[2].trim();
				var p_age = selVal.split("$")[3].trim();
				var p_ageunit = selVal.split("$")[4].trim(); 
				var p_guardian = selVal.split("$")[5].trim();
				var p_coll_centre = selVal.split("$")[6].trim();
				var p_parent_hospital = selVal.split("$")[7].trim();
				var mob_no = selVal.split("$")[8].trim();
				var p_addr = selVal.split("$")[9].trim();
				
				document.forms[0].isAlreadyPatient.value = "1";

			  	//Make the Div's shown/hide.
			  	document.getElementById("patDtlId").style.display = "";
			  	document.getElementById("patTestDateDtlId").style.display="";
			  	document.getElementById("showPatCRNoId").style.display="none";
			  	document.getElementById("offlineTestsListId").style.display="";
				document.getElementById("offlineEntryFormFooterId").style.display="";
				document.getElementById("reset_btn_id").style.display="none";

			  	//enable the Div-elements.
			  	var nodes1 = document.getElementById("patTestDateDtlId").getElementsByTagName('*');
				for(var i = 0; i < nodes1.length; i++){
				     nodes1[i].disabled = false;
				}
				
				document.forms[0].patName.value=p_name;  //Set Name.
			  	document.forms[0].patGenderCode.value=p_gender; //set Gender.
			  	document.forms[0].strPatAge.value=p_age;  //Set Age.
			  	document.forms[0].strPatAgeUnit.value=p_ageunit; // Set Age Unit.
			  	document.forms[0].patGuardianName.value=p_guardian;//Set Father/Spouse Name.
			  	document.forms[0].patMobileNo.value=mob_no;  //Set Mobile number.
			  	document.forms[0].patAdd.value=p_addr;  //Set Address.
			  	document.forms[0].strPatHospCode.value=p_coll_centre;  //Set Collection Centre Hospital.
			  	
			  	document.forms[0].patCRNo.value=cr_no; //Set CR Number In case of search by mobile number.
			  	$('#multiplePatientListId').modal('hide');

	 		}
	 	
	 	


}
