


$(document).ready(function () {
	var cardtypevalue=$('#cardtypevaluehidden').val();
	
	
var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"patrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"1","optionText":"Select Relation"}	
			
		}
		callService(configJson);

var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"}	
			
		}
	callService(configJson);

//alert("state")
    $('#PatientCghsCity').change(function(){
    	
    	if($('#PatientCghsCity').val()=="")
    	{
    		$('#stateCode').html("<option value=''>Select State</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getstateListcitybase",
    			comboId:"stateCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select State"},
    			primaryKeys:[$('#PatientCghsCity').val()],
    		}
    	callService(configJson);
    });


 var configJson={
			serviceName:"/getData/getWellnesscenter",
			comboId:"PatientWc",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"},
		    
			
	   	}
	          callService(configJson);
	   

var configJson={
			serviceName:"/getData/getmaincardtype",
			comboId:"maincardtype",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Card Type"}	
			
		}
	callService(configJson);

$('#maincardtype').change(function(){
	//alert("maincardtype"+($('#maincardtype').val()));
    	
    	if($('#maincardtype').val()=="")
    	{
    		$('#subcardtype').html("<option value=''>Select Sub Card Type</option>");
    		return;    		
    	}
    	
    	//alert(subcardtype);
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"subcardtype",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Sub Card Type"},
    			primaryKeys:[$('#maincardtype').val()],
    		}
    	callService(configJson);
    	
    	if($('#maincardtype').val()=='S'){
    		$('#cardtypevaluehidden').val('S');
    		initPageserving();
       		$('#deptinfoserving').show();
    		$('#deptinfopensioner').hide();
    		$('#Nomineeinfo').hide();
    	}
    	else
    		{
    		initPagepensioner();
    		$('#cardtypevaluehidden').val('P');
    		$('#deptinfopensioner').show();
    		$('#deptinfoserving').hide();
    		$('#Nomineeinfo').hide();
    	
    		}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"subcardtype",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select subcardtype"},
    			primaryKeys:[$('#maincardtype').val()],
    		}
    	callService(configJson);
    });
	
	
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate, "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });


	


var configJson={
			serviceName:"/getData/getBloodgroup",
			comboId:"altnombloodgroup",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BloodGroup"}	
			
		}
	callService(configJson);

var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"altnomgender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);


var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"altnomrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);




$('#altnomrelation').change(function(){
	alert("55555")
	var configJson={
    			serviceName:"/getData/getgenderbaseonrelation",
      			callBackFunctionName:"populatealternategendernominee",			
        		primaryKeys:[$('#altnomrelation').val()],
    		}
    	callService(configJson);
	
    	
		    });
 var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"nomgender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);

var configJson={
			serviceName:"/getData/getBloodgroup",
			comboId:"nombloodgroup",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BloodGroup"}	
			
		}
	callService(configJson);




var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"nomrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);



$('#nomrelation').change(function(){
	alert("444444")
	var configJson={
    			serviceName:"/getData/getgenderbaseonrelation",
      			callBackFunctionName:"populategendernominee",			
        		primaryKeys:[$('#nomrelation').val()],
    		}
    	callService(configJson);
	
    	
		    });


  var configJson={
			serviceName:"/getData/getBloodgroup",
			comboId:"depBloodGroup",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BloodGroup"}	
			
		}
	callService(configJson);

	
	  var configJson={
			serviceName:"/getData/getBloodgroup",
			comboId:"patBloodGroup",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BloodGroup"}	
			
		}
	callService(configJson);
	
	
	//alert("gender");
	  var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"patGender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);

	
	//	alert("gender");
	  var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"depgender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);
	
		
	
	//alert("gender");
	  var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"depentrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);
	
	
	var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });
    
	
});

	
		
		function populategendernominee(configJson, dataJson)
    {
	   //alert("configJson>>> " + JSON.stringify(configJson));
    	 // alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               //alert("Relationid>>>>>>>>"+json["relationid"]);
              
              
			    $('#nomgender').val(json["genderid"]);
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}	
		
		
		
		
		function populatealternategendernominee(configJson, dataJson)
    {
	   //alert("configJson>>> " + JSON.stringify(configJson));
    	//  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
             //  alert("Relationid>>>>>>>>"+json["relationid"]);
              
              
                $("#altnomgender").val(json["genderid"]);
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}	
var jsonWizzard ={};

function initPageserving(){
	 

	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	

	jsonWizzard ={
			//	"stepTitle":"Steps to follow Apply Plastic Card Online",
				"steps":[
					{"step":"Personal Information", "stepIcon":"fa-solid fa-id-card fa-fw"},
					{"step":"Department Information","stepIcon":"fa-solid fa-building fa-fw"},
					{"step":"Dependent Information","stepIcon":"fa-solid fa-users fa-fw"},
					{"step":"Finish","stepIcon":"fa-solid fa-circle-check fa-fw"},
				],
				"activeStepNo":"1"				
		};
	
	
	createWizard(jsonWizzard);

//alert("calender");
	
/*	const d = new Date();
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
	*/
	
    
  //alert("entitlement serving");
  
	
	$(function () {
	var nowDate = new Date();
	var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
	$("#patDeputationenddate").datepicker({
		dateFormat: "dd-M-yy",
		showButtonPanel: true,
		minDate: new Date,
		yearRange: "-0:+100",		
		//maxDate: new Date,
		//yearRange: "-100:+0",		
		changeMonth: true,
		changeYear: true,
		showAnim: 'slideDown',
		closeText: 'Clear', // Text to show for "close" button
		onClose: function () {
			var event = arguments.callee.caller.caller.arguments[0];
			// If "Clear" gets clicked, then really clear it
			if ($(event.delegateTarget).hasClass('ui-datepicker-close')) {
				$(this).val('');
			}
		}
	}).val()
});


$("#patcardvalidfromserving").datepicker({
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

  $("#patcardvalidtoserving").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	//yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });  
	var configJson={
	
			serviceName:"/getData/getBasicpay",
			comboId:"patBasicpayserving",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"}	
			
		}
	callService(configJson);
	
	
	

//alert("entitlement")
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

	
  var configJson={
	
			serviceName:"/getData/getEntitlement",
			comboId:"patentitlementserving",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Entitlement"}	
			
		}
	callService(configJson);
	
	
/*	//alert("cardtypeserving");
	  var configJson={
			serviceName:"/getData/getCardtype",
			comboId:"patcardtypeserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"1","optionText":"Serving"}	
			
		}
	callService(configJson);*/
	
	//alert("Payscaleserving");
	  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscaleserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	//alert("Department");
	  var configJson={
			serviceName:"/getData/getdepartmentserving",
			comboId:"patdeptserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Department"}	
			
		}
	callService(configJson);
	
	
	//alert("serving cardtype");
	 var configJson={
			serviceName:"/getData/getCardTypeList",
			comboId:"patcardtypeserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"10","optionText":"Serving"},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
		}
	callService(configJson);
	

	
	
	
    //alert("here222");
  //  $('#BTNCLEAR').click(resetPage);
   //  $('#BTNSAVEFINISH').click(saveData)

}

 function initPagepensioner(){
	 
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	
	jsonWizzard ={
			//	"stepTitle":"Steps to follow Apply Plastic Card Online",
				"steps":[
					{"step":"Personal Information", "stepIcon":"fa-solid fa-id-card fa-fw"},
					{"step":"Department Information","stepIcon":"fa-solid fa-building fa-fw"},
					{"step":"Dependent Information","stepIcon":"fa-solid fa-users fa-fw"},
					{"step":"Nominee","stepIcon":"fa-solid fa-person-arrow-down-to-line fa-fw"},
					{"step":"Finish","stepIcon":"fa-solid fa-circle-check fa-fw"},
				],
				"activeStepNo":"1"				
		};
	
	createWizard(jsonWizzard);

//alert("calender");
	
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
    
    $("#patcardvalidto").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	//yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });  
   /* $("#Patdorpensioner").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	//yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });*/
    
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
      $("#Patdorpensioner").datepicker({
    // minDate: new Date(),  // Remove or comment this out to allow dates before today
    dateFormat: "dd-M-yy",  // Format the date as day-month-year (e.g., 09-Nov-24)
    changeMonth: true,  // Allow the user to change the month
    changeYear: true,  // Allow the user to change the year
    showButtonPanel: true,  // Show the button panel (Today, Done)
    showOtherMonths: true,  // Show days from adjacent months
    selectOtherMonths: true,  // Allow selection of days from adjacent months
    yearRange: "-100:+100",  // Allow year range from 100 years ago to 100 years in the future
    onSelect: function(date, datepicker) {
      //  var id = $(datepicker).attr("id");
       // $('#' + id).trigger('blur');  // Optional: trigger blur to close the datepicker or for validation
    }
});

var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });
    
	/*
	var configJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
			
		}
	callService(configJson);
    
    $('#stateCode').change(function(){
    	
    	if($('#stateCode').val()=="")
    	{
    		$('#districtCode').html("<option value=''>Select District</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getDistrictList",
    			comboId:"districtCode",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select District"},
    			primaryKeys:[$('#stateCode').val()],
    		}
    	callService(configJson);
    });*/
    	var configJson={
	
			serviceName:"/getData/getBasicpay",
			comboId:"patBasicpayPensioner",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"}	
			
		}
	callService(configJson);
	
	
	

//alert("entitlement pensioner")
    $('#patBasicpayPensioner').change(function(){
    	
    	if($('#patBasicpayPensioner').val()=="")
    	{
    		$('#patentitlementpensioner').html("<option value=''>Select Payscale</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patBasicpayPensioner').val()],
    		}
    	callService(configJson);
    });

 // alert("here");
  var configJson={
	
			serviceName:"/getData/getEntitlement",
			comboId:"patentitlementpensioner",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Entitlement"}	
			
		}
	callService(configJson);
	
	   // alert("cardtype pensioner");
		 var configJson={
			serviceName:"/getData/getCardTypeList",
			comboId:"patcardtypepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"11","optionText":"Pensioner"},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
		}
	callService(configJson);
	
	
	
	//alert("Payscale");
	  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"patpayscalepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	//alert("pensioner department");
	  var configJson={
			serviceName:"/getData/getdepartmentpepensioner",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Department"}	
			
		}
	callService(configJson);
	//alert("FMA");
		  var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select FMA"}	
			
		}
	callService(configJson);
	
	   $('#patfmapensioner').change(function(){
    	
    	if($('#patfmapensioner').val()=="")
    	{
    		$('#patfmafacilitypensioner').html("<option value=''>Select Facility</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[$('#patfmapensioner').val()],
    		}
    	callService(configJson);
    });
	
	
	
	
	
    //alert("here222");
    $('#BTNCLEAR').click(resetPage);
  
  //  $('#SAVEPREVIEW').click(saveData)

}

/*function  openpage()
{
	alert("111111");
document.getElementById('welcomeDiv').style.display = "block";
}*/


function saveData() {
	if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	
	// Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");

    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/GenerateBenId",
        callBackFunctionName: "callbackSaveData",
         inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
}

	
function callbackSaveData(configJson, dataJson){
	
	//alert("config json>>>>>>>>>>>>>>>>>"+JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		//alert("callbackSaveData>>>\n"+ dataJson["message"]);
		var json =JSON.parse(dataJson["message"].replace("SUCCESS:", ""));
		var benId= json["benId"];
		$(Benidvalue).val(benId);
      	var cardNo=json["cardNo"];
      	$(cardnovalue).val(cardNo);
		showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
	}
  
}

function resetPage(){
const serializedData = JSON.stringify(processSerializeArray("ENTRYFORM"));
//alert(serializedData);
	 var encryptedata=encryptBase64(serializedData);
	// alert(encryptedata);
	$('#primaryKeyFromDelingoffline').val(encryptedata);
	  submitFormMaster("GenerateBenId","add");	
}


function adddeppensioner()
{
	
	var checkbox =document.getElementById('chkDependent1');
//alert("value of checkbox"+checkbox);
 if (checkbox.checked) 
	 {
		 $('#isdependentadd').val("1");
	 }else{
		 $('#isdependentadd').val("0"); 
	 }
	
}
  
  
  function adddepserving()
  {
	  var checkbox =document.getElementById('customCheck12');
//alert("value of checkbox"+checkbox);
 if (checkbox.checked) 
	 {
		 $('#isdependentadd').val("1");
	 }else{
		 $('#isdependentadd').val("0"); 
	 }
  }
function addpayment()
{
	var cardtypevalue=$('#cardtypevaluehidden').val();
//alert(cardtypevalue);
if (cardtypevalue === 'P')
{
	$('#Nomineeinfo').hide();
    $('#Paymentinfo').show();
}else{
  $('#Paymentinfo').hide();
  $('#Nomineeinfo').show();
}
	
} 

function adddepinfo() {
	//alert("111");
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
		
  const depnameadd = document.getElementById('depname').value;
    
   const depentrelationadd= $( "#depentrelation option:selected" ).text();
   const depentrelationaddID= $( "#depentrelation option:selected" ).val();
  const depDOBadd = document.getElementById('depDOB').value;
  
  const depgenderadd=$( "#depgender option:selected" ).text();
  const depgenderaddID=$( "#depgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#depBloodGroup option:selected" ).text();

    const imgSrc = $("#fileContent2").val();
     const fileuploadvalue=$('#filename11').val();
     const disabilityflag=$('#isdisablityvaluehidden').val();
  //  alert(fileuploadvalue);
    
     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     "dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc,
     "dependentuploaddoc":fileuploadvalue,
     "dependentdisabilityflag":disabilityflag
     } 
      createDependentRow(json);
     
     
     //tbody.appendChild(createRow(depnameadd, depDOBadd,depgenderadd,depentrelationadd,depBloodGroupadd , depdentPhotoadd));
    
    
  	  //updateSerialNumbers();
	  document.getElementById('depname').value = "";
	  document.getElementById('depentrelation').value = "";
	  document.getElementById('depDOB').value = "";
	  document.getElementById('depgender').value = "";
	  document.getElementById('depBloodGroup').value = "";
	  //document.getElementById('depdentPhotoadd').value = "";
    
   
}
function createDependentRow(json){
	
	//alert("createdepjson");
	 var html ="<tr id=''>";
     html +="<td class='slno'></td>";
     html +="<td>" + json["depname"]+"</td>";
     html +="<td>" + json["deppendentDOBadd"] +"</td>";
     html +="<td>" +  json["dependentGender"]  +"</td>";
     html +="<td>" + json["dependentRelation"] +"</td>";
     /*html +="<td>" + json["dependentBloodGroupadd"]+"</td>";*/
     html +="<td><img src='"+json["dependentPhoto"] +"' style='width:100px;height:100px'>" ;
/*     html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=fileTempDownload&fileName=" + json["dependentuploaddoc"] + "&folderName=CARDDOCUMENT'>" + json["dependentuploaddoc"] + "</a></td>";
*/  /*   html +="<td>" + json["dependentdisabilityflag"] +"</td>";*/
   /*  html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";*/
     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
  $('#AutoNumber1 tbody').append(html);
     
     var index=1;
     $('.slno').each(function(){
		 $(this).text(index);
		 index++;
	 });
}


/*

function createRow(json, rowId);
 {
  
  
}*/
function deleteRow(button) {
    var row = button.closest('tr'); // Find the closest row
    row.parentNode.removeChild(row); // Remove the row from the table
}


function createRowform(serialNoform,depaddnameform, dobaddform,genderaddform,relationform,bloodgroupform)
{
	const tr = document.createElement('tr');
        tr.appendChild(createTd(serialNoform));
  tr.appendChild(createTd(depaddnameform));
   tr.appendChild(createTd(dobaddform));
  tr.appendChild(createTd(relationform));
  tr.appendChild(createTd(genderaddform));
   tr.appendChild(createTd(bloodgroupform));
  
	  return tr;
}

function  createRownominee(json)
{
	//alert("iiin create row");	
	
	
	 var html ="<tr id=''>";
     html +="<td class='slnoNom'></td>";
     html +="<td>" + json["nomnameadd"]+"</td>";
    html +="<td>" + json["nomdobadd"] +"</td>";
     html +="<td>" + json["nomrelationadd"] +"</td>";
     html +="<td>" +  json["nomgenderadd"]  +"</td>";
     html +="<td>" + json["nombloodgroupadd"]+"</td>";
    html +="<input type='hidden' name='nomineeJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#AutoNumber3 tbody').append(html);
     
         var index=1;
     $('.slnoNom').each(function(){
		 $(this).text(index);
		 index++;
 });
}

// Helper function to create a <td> with text content
function createTd1(content) {
    const td = document.createElement('td');
    td.textContent = content; // Set text content
    return td;
}

function createTd(value) {
  const td = document.createElement('td');
  td.innerText = value;
  return td;
}


 function deleteRow(icon) {
           const row = icon.parentElement.parentElement; // Get the <tr> element (row) of the clicked button
            row.remove();  // Remove the row from the table
            updateSerialNumbers();
        }


 function updateSerialNumbers() {
            const tbody = document.querySelector('#dependenttable tbody');
            const rows = tbody.querySelectorAll('tr');

            // Loop through all rows and update the serial number
            rows.forEach((row, index) => {
                row.cells[0].textContent = index + 1;  // Update the serial number (first cell)
            });
        }

function cleardepdetail()
{
	//alert("22222");
	document.getElementById('depname').innerHTML = "";
	document.getElementById('depentrelation').innerHTML = "";
	document.getElementById('depDOB').innerHTML = "";
	document.getElementById('depgender').innerHTML = "";
	document.getElementById('depMobile').innerHTML = "";
}


function clearvaluesperinfo()
{
//	alert("values");
	document.getElementById('patName').value = '';
	document.getElementById('patNameHindi').value = '';
	document.getElementById('patDOB').value = '';
	document.getElementById('patGender').value = '';
	document.getElementById('patBloodGroup').value = '';
	document.getElementById('patMobileNo').value = '';
	 document.getElementById('patEmail').value= '';
	document.getElementById('patResaddress').value= '';
		
}

function clearvaluesdeptserving()
{
	document.getElementById('patCardtypeServing').value = '';
   document.getElementById('patDeptserving').value = '';
	document.getElementById('patEntitlementServing').value = '';
	document.getElementById('patPayscaleServing').value = '';
	document.getElementById('patPresentpayServing').value = '';
	document.getElementById('patpincodeserving').value = '';
	document.getElementById('patdesignationserving').value = '';
    document.getElementById('patofcnoserving').value = '';
   document.getElementById('patofcadrserving').value = '';
	
}

function clearvaluesdeptpensioner()
{	
	//alert("pensioner");
	document.getElementById('patcardtypepensioner').value = '';
    document.getElementById('patentitlementpensioner').value = '';
    document.getElementById('patpayscalepensioner').value = '';
	document.getElementById('patlastpaypensioner').value = '';
	document.getElementById('patdesignationpensioner').value = '';
	document.getElementById('patofcnopensioner').value = '';
	document.getElementById('patpincodepensioner').value = '';
	document.getElementById('Patppopensioner').value = '';
	document.getElementById('Patdorpensioner').value = '';
}

function shownomineepensioner()
{
	
	/*if(ValidateForAllVisible("ENTRYFORM")==false)
		return;*/
	//var cardtypevalue=$('#cardtypevaluehidden').val();
	//alert(cardtypevalue);
	if ($('#maincardtype').val()=='P' || $('#maincardtype').val()=='SA')
	{
		$('#perinfo').hide();
		$('#deptinfopensioner').hide();
		$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("1");
	}else{
		$('#perinfo').hide();
		$('#deptinfoserving').hide();
		$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("0");
	}
	
	 var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val()
	  
	     } 
	      createDependentRow(json);
	jsonWizzard["activeStepNo"]="4";
	createWizard(jsonWizzard);
}


function shownomineeserving()
{
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	var cardtypevalue=$('#cardtypevaluehidden').val();
//alert(cardtypevalue);
if (cardtypevalue === 'P' || cardtypevalue === 'SA')
{
	$('#deptinfopensioner').hide();
	$('#Nomineeinfo').show();
	jsonWizzard["activeStepNo"]="4";
	createWizard(jsonWizzard);

}else{
	$('#deptinfoserving').hide();
	$('#Nomineeinfo').show();
}
}

/*
function showdependentServing()
{
	alert(document.getElementById("chkDependent1")[i].checked);
	if(document.getElementById("chkDependent1")[i].checked){
		 $('#BTNNEXT2').show();
		 $('#BTNPreviewDept').hide();
	}
	else{
		 $('#BTNNEXT2').hide();
		 $('#BTNPreviewDept').show();
	}
	$('#deptinfoserving').hide();
	$('#Nomineeinfo').show();

}*/
function showdependentpensioner()
{
var checkbox =document.getElementById('customCheck12');
//alert("value of checkbox"+checkbox);
 if (checkbox.checked) {
	 $('#BTNNEXT3').show();
	  $('#BTNSAVEFINISH2').hide();
	 	 $('#isdependentadd').val("1");
	 }
	 else{
		// alert("iiinn else");
		   $('#BTNSAVEFINISH2').show();
		  $('#BTNNEXT3').hide();
		   $('#isdependentadd').val("0");
	 }

}
  
  function showdependentserving()
{
var checkbox =document.getElementById('customCheck11');
alert("value of checkbox"+checkbox);
 if (checkbox.checked) {
  $('#isdependentadd').val("1");
	 	 
	 }
	 else{
		 //alert("iiinn else");
	 $('#isdependentadd').val("0");
	 }

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
  
function adddependentdetail()
{
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	        
          
var cardtypevalue=$('#cardtypevaluehidden').val();
// alert(cardtypevalue);

$('#dependentinfo').show();
if (cardtypevalue === 'P' || cardtypevalue === 'SA'){
	$('#deptinfopensioner').hide();
	$('#BTNPreviewDependent').hide();
}
else{
	$('#deptinfoserving').hide();
	$('#BTNNEXT4').hide();
	$('#BTNPreviewDependent').show();	
}
		
  jsonWizzard["activeStepNo"]="3";
  createWizard(jsonWizzard);	
}

	
  
  
  function prevStep3()
  {
	 // alert("111111");
var cardtypevalue=$('#cardtypevaluehidden').val();
 if (cardtypevalue === 'P')
{
	//alert("iinnn ifff");
	 $('#dependentinfo').hide(); 
	 $('#deptinfopensioner').show(); 
	
}else{
	$('#dependentinfo').hide();
	$('#deptinfoserving').show();
	
}
 jsonWizzard["activeStepNo"]="2";
 createWizard(jsonWizzard);	
}
	 
function Addanothernominee() {
    var checkbox =document.getElementById('isnomineeaddvalue');
//alert("value of checkbox"+checkbox);
 if (checkbox.checked) {
	 $('#alternamenominee').show();
	  $('#addnaltomineehidden').val("1");	 
	 }
	 else
	 {
		 $('#alternamenominee').hide();
		  $('#addnaltomineehidden').val("0");
	 }
	//alert("isnomineeadd>>"+$('#isnomineeadd').val());
}

	  
function nextStep() {
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	var cardtypevalue=$('#cardtypevaluehidden').val();
	//alert(cardtypevalue);
	if (cardtypevalue === 'P' || cardtypevalue === 'SA')
	{	
		$('#perinfo').hide();
		$('#deptinfopensioner').show();
	}
	else
	{
		$('#perinfo').hide();
		$('#deptinfoserving').show();
	}

	var checkbox =document.getElementById('chkDependent1');
	//alert("value of checkbox"+checkbox);
	 if (checkbox.checked) {
		$('#BTNNEXT2').show();
		$('#BTNPreviewDept').hide();
		$('#isdependentadd').val("1");
	 }

	 var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val(),
	     "dependentuploaddoc":"",
	     "dependentdisabilityflag":"0"
	   
	     } 
	 createDependentRow(json);
	 
	jsonWizzard["activeStepNo"]="2";
	createWizard(jsonWizzard);	
}



function prevStep() {
	var cardtypevalue=$('#cardtypevaluehidden').val();
//alert(cardtypevalue);
if (cardtypevalue === 'P' || cardtypevalue === 'SA')
{
	$('#perinfo').show();
	$('#deptinfopensioner').hide();
	
}else{
		$('#perinfo').show();
	$('#deptinfoserving').hide();
}


jsonWizzard["activeStepNo"]="1";
createWizard(jsonWizzard);	

}



function Previewformindexcard()
	{
		alert("1111111111111");
	    // Primary nominee details
   if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
           
             var mainname = $("#patName").val();
           $("#govEmployeeName").text(mainname);
		  
		     var resdaddres = $("#patresaddress").val();
		     $("#residentialAddress").text(resdaddres);
		    
		    var validto=$("#patcardvalidto").val();
		    
		 //   alert(validto);
		    $("#issueDate").text(validto);
		    
		     $("#entitlement").html($( "#patentitlementpensioner option:selected" ).text())
		      $("#BensubCardType").html($( "#subcardtype option:selected" ).text())
		        $("#BenCardType").html($( "#maincardtype option:selected" ).text())
		    	    
           if($('#maincardtype').val()=='P'){
		  var depname = $("#patdeptpensioner").val();
	 //  alert(depname);
		    $("#departmentName").html($( "#patdeptpensioner option:selected" ).text())
		  
		    $('#mymodalprintindexcard').modal('show');
		  
		                 
		   
          }
          else
          {
			//  alert("iiinnn elseee");
			  
			   var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val()
	  
	     } 
	      createDependentRow(json);
	  $('#mymodalprintindexcard').modal('show');
	}
	  	 
		 
		  	 var formhtml=encryptBase64($('#printindexcardhtml').html() );
	$('#printindexcardhidden').val(formhtml);
}

  function Previewform() {
	  //alert("in method");
	if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	  	  	      
	    // Primary nominee details
   if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
           
   const nomname1 = $("#nomname").val();
    const nomrelation1 = $("#nomrelation option:selected").text();
    const nomdob1 = $("#nomdob").val();
    const nomgender1 = $("#nomgender option:selected").text();
    const nommobile = $('#nommobile').val();
    const nombenid = $('#nombenid').val();
    const nomaadhar = $('#nomaadhar').val();
    const nomaddress = $('#nomaddress').val();
    
    var nomineeJson = new Array();
    if(nomname1!=""){
	    // Primary nominee JSON object
	    var json = {
	        "nomnameadd": nomname1,
	        "nomrelationadd": nomrelation1,
	        "nomgenderadd": nomgender1,
	        "nomdobadd": nomdob1,
	        "nommobileadd": nommobile,
	        "nombenidadd": nombenid,
	        "nomaddressadd": nomaddress,
	        "nomaadharadd": nomaadhar
	    };
	    
	    // Add the primary nominee to the array
	    nomineeJson.push(json);
    }
    
    var isnomineeaddvalue = $('#isnomineeadd').val();
   if(nomineeJson) 
   {
    // If alternate nominee is present
    if (isnomineeaddvalue == 1 ) {
    	
        // Alternate nominee details
        const alternatenominename = $("#altnomname").val();
        const alternatenominenamerelation = $("#altnomrelation option:selected").text();
        const alternatenominedob = $("#altnomdob").val();
        const alternatenominegender = $("#altnomgender option:selected").text();
        const alternatenomineMobile = $("#altnommobile").val();
        const alternatenominebenid = $('#altnombenid').val();
        const alternatenomineaadhar = $('#altnomaadhar').val();
        const alternatenomineaadress = $('#altnomaddress').val();
        if(alternatenominename!=""){
	        // Alternate nominee JSON object
	        var json1 = {
	            "nomnameadd": alternatenominename,
	            "nomrelationadd": alternatenominenamerelation,
	            "nomgenderadd": alternatenominegender,
	            "nomdobadd": alternatenominedob,
	            "nommobileadd": alternatenomineMobile,
	            "nombenidadd": alternatenominebenid,
	            "nomaddressadd": alternatenomineaadress,
	            "nomaadharadd": alternatenomineaadhar
	        };
	        
	        // Add alternate nominee to the array
	        nomineeJson.push(json1);
        }
    }
    }
    // Clear previous entries in the table
     $("#AutoNumber3 tbody").empty();
    if(nomineeJson.length>0){
	    // Append nominee details to the table
	    nomineeJson.forEach(function(obj, indx) {
	        var html = "<tr>";
	        html += "<td class='slnoNom'>" + (indx + 1) + "</td>";  // Index starts from 1 for serial number
	        html += "<td>" + obj["nomnameadd"] + "</td>";
	        html += "<td>" + obj["nomdobadd"] + "</td>";
	        html += "<td>" + obj["nomrelationadd"] + "</td>";
	        html += "<td>" + obj["nomgenderadd"] + "</td>";
	        html += "<td>" + obj["nommobileadd"] + "</td>";
	        html += "</tr>";
	        
	        $("#AutoNumber3 tbody").append(html);
	    });
    }else{
    	$('#liNominee').hide();
    }
	    
	   //const tbody = document.querySelector('#dependenttable tbody');
          const rows = document.querySelectorAll('#dependenttable tbody tr');
          var indx=1;
          $("#AutoNumber1 tbody").empty();
          $("[name=dependentJson]").each(function(){
			  var json = JSON.parse( $(this).val());
			 			  
			  var html ="<tr >";
			  
			  
			     html +="<td class='slno'>"+indx+"</td>";
			     html +="<td>" + json["depname"]+"</td>";
			     html +="<td>" + json["deppendentDOBadd"]+"</td>";
			     html +="<td>" + json["dependentRelation"] +"</td>";
			     html +="<td>" + json["dependentGender"]+"</td>";
			    /* html +="<td style='display:none;'>" + json["dependentBloodGroupadd"]+"</td>";*/
			     html +="<td><img src='"+json["dependentPhoto"]+"' style='width:100px;height:100px'>" ;
			     html +="</tr>";
			    $("#AutoNumber1 tbody").append(html); 
			 	//alert("$('#AutoNumber2Iimg'+indx)>>" + $('#AutoNumber2Iimg'+indx).length)
			 //	$('#AutoNumber2Iimg'+indx).html("<img src='"+json["dependentPhoto"]+"' style='width:100px;height:100px;' />")
			 	//$('#AutoNumber2ISno'+indx).html(indx);
			 	
			    indx++;
			  
		  });
          
	       
	    var cardtypevalue=$('#cardtypevaluehidden').val();
	    var name = $("#patName").val();
           $("#dialogName").text(name);
           
           var mainname = $("#patName").val();
           $("#dialogNamemain").text(mainname);
                      
           var email=$("#patEmail").val();
           $("#dialogemail").text(email);
           
            var mob=$("#patMobileNo").val();
           $("#dialogemob").text(mob);
           
             var patDOB= $("#patDOB").val(); 
           $("#dialogdob").text(patDOB);
                          
              var mainrelation=$("#patrelation").val();
           $("#dialogrelation").text(mainrelation);
           
          $("#dialogbldgrup").html($( "#patBloodGroup option:selected" ).text())
          $("#dialoggen").html($( "#patGender option:selected" ).text())
                  
       
            var depname = $("#depname").val();
            $("#dialogdepName").text(depname);
           $("#dialogdeprelationship").html($( "#depentrelation option:selected" ).text())
            var depdob=$("#depDOB").val();
           $("#dialogdepdob").text(depdob);
            $("#dialogdepbldgrup").html($( "#depBloodGroup option:selected" ).text())
            $("#dialogdepgen").html($( "#depgender option:selected" ).text())
               
               
     
           if(cardtypevalue=='P'){	
			   
         
		   $("#dialogcardtype").html($( "#patcardtypepensioner option:selected" ).text())
		  $("#dialogdept").html($( "#patdeptpensioner option:selected" ).text())
		   var ofcaddress=$("#patofcadrpensioner").val();
           $("#dialogofcadress").text(ofcaddress);
             $("#dialogpayscale").html($( "#patpayscalepensioner option:selected" ).text())
         
               var plastpay=$("#patlastpaypensioner").val();
              // alert("lastpay>>>>>"+plastpay)
           $("#dialogpreslastpay").text(plastpay);
           //   $("#dialogdesignation").html($( "#patdesignationpensioner option:selected" ).text())
                 var penpincode=$("#patpincodepensioner").val();
           $("#dialogpin").text(penpincode);
          var dofretirement=$("#Patdorpensioner").val();
           $("#dialogretirementdate").text(dofretirement);
                    var PPOnumber=$("#Patppopensioner").val();
              $("#dialogppono").text(PPOnumber);    
                      
                        
            var resaddress=$("#patResaddress").val();
           $("#dialogoresadress").text(resaddress);
            
              }else
		   {
	   //  alert("iinnn elseee");
	      $("#dialogcardtype").html($( "#patcardtypeserving option:selected" ).text())
	      $("#dialogcardtype").html($( "#patdeptserving option:selected" ).text())
			   var ofcaddressserving=$("#patofcadrserving").val();
           $("#dialogofcadress").text(ofcaddressserving);
           
           
		   $("#dialogpayscale").html($( "#patpayscaleserving option:selected" ).text())
             $("#dialogdesignation").html($("#patdesignationserving option:selected" ).text())
                                                                             
           var resaddress=$("#patresaddress").val();
           $("#dialogoresadress").text(resaddress);
          
         }
	   	    	   
	   	   $('#dialogtransferablecity').html($( "#PatTransferablecityflag option:selected" ).text())
	   	    	    	    	              
	       var deputationflagdisplay=$('#deputationflaghidden').val();  
	      // alert(deputationflagdisplay);
          if(deputationflagdisplay==1)
           {
		   $('#dialogdeputation').text("yes");
	        }
	        
	        var patDeputationyearvalue=$('#patDeputationyear').val();
	        $('dialogdeputationyear').val(patDeputationyearvalue);
	           $('#dialogprespay').html($( "#patpresentpayserving option:selected" ).text())
          
     	 $('#myModalcghsform').modal('show');
     	 var formhtml=encryptBase64($('#onlineplasticformhtml').html() );
	$('#onlineapplicationhidden').val(formhtml);
       
        }


 function prevstep5()
 {
	 //alert("1111");
	 $('#Paymentinfo').hide();
	 $('#Nomineeinfo').show();
 }
 
 
 
function prevStep4()
{
var checkboxpensioner =document.getElementById('customCheck12');
var checkboxserving =document.getElementById('customCheck1');
//alert("value of checkbox"+checkbox);
	var cardtypevalue=$('#cardtypevaluehidden').val();
//alert(cardtypevalue);
if (cardtypevalue === 'P' ||cardtypevalue === 'SA' )
{
	if (checkboxpensioner.checked) {
	 //alert("11111");
	 $('#Nomineeinfo').hide();
	 $('#dependentinfo').show();
		 jsonWizzard["activeStepNo"]="3";
		 createWizard(jsonWizzard);
	 }
	 else
	 {
     //alert("2222");
	     $('#Nomineeinfo').hide();
		 $('#deptinfopensioner').show();
		 jsonWizzard["activeStepNo"]="2";
		 createWizard(jsonWizzard);
	 }
	
}else
{
	//alert("3333");
	if (checkboxserving.checked) {
	 $('#Nomineeinfo').hide();
	 $('#dependentinfo').show();
	 jsonWizzard["activeStepNo"]="3";
	 createWizard(jsonWizzard);
	}
	else
	{
     $('#Nomineeinfo').hide();
	 $('#deptinfoserving').show();
	 jsonWizzard["activeStepNo"]="2";
	 createWizard(jsonWizzard);
	}
	
}	
}



function ShowDeputationyear()
{
	
	var checkboxdeputationflag =document.getElementById('deputationflag');
	if (checkboxdeputationflag.checked) {
		$('#showdepyeardiv').show();
		$('#deputationflaghidden').val("1");
		}else
		{
			$('#showdepyeardiv').hide();
			$('#deputationflaghidden').val("0");
		}
}

function showalreadycghsbenid()
{
		var checkboxalreadycghsid =document.getElementById('CGHSholdserviceflag');
	if (checkboxalreadycghsid.checked) {
		$('#enterbenidifexist').show();
		$('#cghsbenidexistflag').val("1");
		}else{
			$('#enterbenidifexist').hide();
			$('#cghsbenidexistflag').val("0");
		}
}


function prevStep2() {
	//alert("44444");
	document.getElementById("deptinfo").style.display="block";
	document.getElementById("deptinstr").style.display="block";

	document.getElementById("adddepent").style.display="None";
	document.getElementById("dependentinfo").style.display="None";
	}




function addnominee()
{	
	
	var cardtypevalue=$('#cardtypevaluehidden').val();
	//alert(cardtypevalue);
	if (cardtypevalue === 'P' || cardtypevalue === 'SA')
	{
		$('#dependentinfo').hide();
    	$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("1");
	}else{
		$('#dependentinfo').hide();
		$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("0");
	}
	jsonWizzard["activeStepNo"]="4";
	createWizard(jsonWizzard);
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
        
        if(navigator.mediaDevices){
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
 
		}else{
			alert("Camera Not Available; Please Try Upload Photo");
		}
     
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
	

  function calculateDaysFromTodayToYears(years) {
	    // Get today's date
	    let today = new Date();

	    // Calculate the target date by adding the number of years to today's year
	    let targetDate = new Date(today.getFullYear() + years, today.getMonth(), today.getDate()+1);

	    // Calculate the difference in time (in milliseconds)
	    let differenceInTime = targetDate - today;

	    // Convert the time difference to days
	    let differenceInDays = Math.floor(differenceInTime / (1000 * 60 * 60 * 24));
	    
	    return differenceInDays;
	}	