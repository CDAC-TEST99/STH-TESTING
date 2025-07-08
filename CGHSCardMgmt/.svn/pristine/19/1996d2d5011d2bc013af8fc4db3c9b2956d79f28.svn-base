var bhavishyaDataLoad = 0;
$(document).ready(function () {
	
	var genderJson={
			serviceName:"/getData/getGenderListBhavishya",
			comboId:"genderMasterForBhavishya",
			primaryKeys:[0],
			disabled: true,
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(genderJson);
	
	var cardtypevalue='P';
	//console.log("cardtypevalue -->" + cardtypevalue);
	let maximumDate=0
	let minimumDate=-36500
	
	 if(cardtypevalue=='S')
	 {
		 	initPageserving();
		    $('#formTitle').addClass("bg-primary text-primary").html("Application for Serving CGHS Card");
		    maximumDate=calculateDaysFromTodayToYears(18)
		    minimumDate=calculateDaysFromTodayToYears(60);
	 }
	 else if(cardtypevalue=='P'){
		 initPagepensioner();
		 $('#formTitle').addClass("bg-success text-success").html("Application for Pensioner CGHS Card");
		 maximumDate=calculateDaysFromTodayToYears(60);
		 minimumDate=calculateDaysFromTodayToYears(99);	
	 }
	 else if(cardtypevalue=='SA'){
		 initPagepensioner();
		 $('#formTitle').addClass("bg-info text-info").html("Superannuate Application for Pensioner CGHS Card")
		 maximumDate=calculateDaysFromTodayToYears(59)-182;	// 6 months days
		 minimumDate=calculateDaysFromTodayToYears(59)+1;	 
		 
	 }
	 maximumDate=maximumDate-(maximumDate*2); // for getting days in minus
	 minimumDate=minimumDate-(minimumDate*2);// for getting days in minus
	 $('#patDOB').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
	    	changeMonth: true, changeYear: true ,
	    	showButtonPanel: true,  showOtherMonths: true,	    	
	    	selectOtherMonths: true, /* yearRange: fromYear+":"+toYear, */
	    	onSelect: function (date, datepicker) {
	    		validateFormData($('#patDOB'));
	        }
	  });

 var configJson={
			serviceName:"/getData/getgenderlistbhavishyaDropdown",
			comboId:"patgenderhidden",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);


 var configJson={
			serviceName:"/getData/getrelationdatabhavishyadropdown",
			comboId:"patrelationhidden",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);


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

 $('#PatientCghsCity').change(function(){
    	
	var configJson={
    			serviceName:"/getData/getADCityBasedonsatelliteCity",
      			callBackFunctionName:"populatecity",			
        		primaryKeys:[$('#PatientCghsCity').val()],
    		}
    	callService(configJson);
    });

	
 var stateJson={
			serviceName:"/getData/getStateList",
			comboId:"stateCode",						
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
		}
	callService(stateJson);
    
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
    
    
    	
    var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"patresdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[20],
    		}
    	callService(configJson);
    
     var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"mainchdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[10],
    		}
    	callService(configJson);
    



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
			serviceName:"/getData/getDependentRelation",
			comboId:"nomrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);


$('#nomrelation').change(function(){


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
	
	
	  var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"patGender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);

	
	
	  var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"depgender",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);

		
	
   /*
	 * $("#depDOB").datepicker({ //minDate:new Date , //maxDate: maximumDate,
	 * "dateFormat": "dd-M-yy", changeMonth: true, changeYear: true ,
	 * showButtonPanel: true, showOtherMonths: true, selectOtherMonths: true,
	 * //yearRange: "-0:+100", onSelect: function (date, datepicker) { //var id=
	 * $(datepicker).attr("id"); //$('#'+id).trigger('blur'); } });
	 */
	
	 $("#depDOB").datepicker({
      dateFormat: "dd-mm-yy",  // Date format: day-month-year
      changeMonth: true,        // Allows month change
      changeYear: true,         // Allows year change
      showButtonPanel: true,    // Adds a button panel at the bottom (for clear, today buttons)
      showOtherMonths: true,    // Shows days from other months in the calendar
      selectOtherMonths: true,  // Allows selecting days from other months
      yearRange: "-200:+0",     // Allows all years from -9999 to +9999 (practically no restriction)
      maxDate: new Date(),      // No future dates allowed
      onSelect: function (dateText, datepicker) {
        // Convert the selected date to a Date object
       var dob = $(this).datepicker("getDate");
    // Format the date to dd-mm-yyyy manually
    var formattedDate = $.datepicker.formatDate('dd-mm-yy', dob);
   // alert("Selected Date: " + formattedDate);  // Alert in dd-mm-yyyy format
      var age = calculateAge(formattedDate);
      var deprelation=$("#depentrelation").val();
  //    alert("Age: " + age);
      if(age>18){
		 // alert("innniff age");
		  $('#DepPAN').show();
		  
	  }
	  if(age>25 && deprelation==5)
	  {
		  alert("Son age not greater than 25");
		 $('#depgender').prop('disabled', true); // Disable all other inputs
          return;  // Stop fur
	  }else
    {
		 $('#depgender').prop('disabled', false);
	}
  }
});
	
/*	
		var nowDate = new Date();
	var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
$("#depDOB").datepicker({
    dateFormat: "dd-MM-yyyy", // Date format: day-month-year
    changeMonth: true,      // Allows month change
    changeYear: true,       // Allows year change
    showButtonPanel: true,  // Adds a button panel at the bottom (for clear,
							// today buttons)
    showOtherMonths: true,  // Shows days from other months in the calendar
    selectOtherMonths: true, // Allows selecting days from other months
 yearRange: "-200:+0",		 // Allows all years from -9999 to +9999
								// (practically no restriction)
    	maxDate: new Date,
    onSelect: function (date, datepicker) {
        // Custom actions when a date is selected (optional)
    }
});*/


	
	// alert("gender");
	  var configJson={
			serviceName:"/getData/getDependentRelation",
			comboId:"depentrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(configJson);
	
	
$('#depentrelation').change(function(){
//	alert($('#depentrelation').val());
	
	var concatenatedValue=$('#depentrelation').val();
	//var splitValues = concatenatedValue.split(','); // You can change the delimiter if necessary
	
	    var splitValues = concatenatedValue.split('$'); // Split by the dollar sign


    // Now you have an array of values, e.g., splitValues[0] and splitValues[1]
    var relationid = splitValues[0];
    var bhavisyarelationid = splitValues[1];
    
    //alert("relationid>>>>>>>"+relationid);
   // alert("bhavisyarelationid>>>>>>>"+bhavisyarelationid);

	var configJson={
    			serviceName:"/getData/getgenderbaseonrelation",
      			callBackFunctionName:"populategender",			
        		primaryKeys:[relationid],
    		}
    	callService(configJson);
	
    	
		    });
	
	
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depdisdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[70],
    		}
    	callService(configJson);
	
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depspousedoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[50],
    		}
    	callService(configJson);
	
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depmardoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[80],
    		}
    	callService(configJson);
	
	
	 var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depincomestatusdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[90],
    		}
    	callService(configJson);
	
	
	
	var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depidproofdoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[10],
    		}
    	callService(configJson);
	
	var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"depagedoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[60],
    		}
    	callService(configJson);

	$('#select-all').click(function() {
      var isChecked = $(this).prop('checked');
      $('input[name="undertakingChk"]').prop('checked', isChecked);
    });

    // Automatically uncheck "Select All" if any checkbox is unchecked
    $('input[name="undertakingChk"]').click(function() {
      // If any checkbox is unchecked, uncheck the "Select All" checkbox
      if ($('input[name="undertakingChk"]:not(:checked)').length > 0) {
        $('#select-all').prop('checked', false);
      } else {
        $('#select-all').prop('checked', true);
      }
    });
    
    
    
 $('#select-all1').click(function() {
      var isChecked = $(this).prop('checked');
      $('input[name="undertakingChk1"]').prop('checked', isChecked);
    });

    // Automatically uncheck "Select All" if any checkbox is unchecked
    $('input[name="undertakingChk1"]').click(function() {
      // If any checkbox is unchecked, uncheck the "Select All" checkbox
      if ($('input[name="undertakingChk1"]:not(:checked)').length > 0) {
        $('#select-all1').prop('checked', false);
      } else {
        $('#select-all1').prop('checked', true);
      }
    });

});

	 
    function populategender(configJson, dataJson)
    {
		
//		alert("populategender");
		
		
 			$('#depageprooftype').hide();
			$('#fileuploadageproof').hide();
			$('#fileuploaddisablecertificate').hide();
			$('#disabledoctype').hide();  
			$('#isdisablityvaluehidden').val("0");	
			$('#fileuploadspousecertificate').hide();
			$('#spousedoctype').hide();
			 $('#depmarprooftype').hide();
		      $('#fileuploadmarriagedoc').hide();
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					
						var relationidvalue=json["relationid"];
	              if(relationidvalue=='15' || relationidvalue=='16' || relationidvalue=='22' || relationidvalue=='5'){  // 15
																														// "GRAND
																														// SON"
																														// ,22
																														// "MINOR
																														// BROTHER",16
																														// "GRAND
																														// DAUGTHER",5
																														// son
				    $('#depageprooftype').show();
				    $('#fileuploadageproof').show();
				  }
			 
				 if(relationidvalue=='20' || relationidvalue=='21')
				    {    
//						alert("relationvalue"+relationidvalue);
						  // DIVORCED/WIDOWED DEPENDENT DAUGHTER code 20 or 21
							// for DIVORCED/ WIDOWED DEPENDENT SISTER)
					    $('#depmarprooftype').show();
					     $('#fileuploadmarriagedoc').show();
					   
				   }
	               
	               
	              
	               var depdisableflag=json["disableflag"];
	             
	               if(depdisableflag=='1'){
					    $('#fileuploaddisablecertificate').show();
					    $('#disabledoctype').show();
					    
					     $('#isdisablityvaluehidden').val("1");	 
				   }
	        
				var patgendervalue=  $('#patGender').val();
				
				
			
				var genderidvalue=json["genderid"];
				if(relationidvalue=='2'){
					if(genderidvalue=='U' && patgendervalue=='M' ){
				    	$('#depgender').val("F");
				    }
				    else if(genderidvalue=='U' && patgendervalue=='F'){
				    	$('#depgender').val("F");
				    }
				    if (confirm('Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?')) {
	                      $('#fileuploadspousecertificate').show();
	                      $('#spousedoctype').show();
	               	} 		
				}
				else{
					$('#depgender').val(json["genderid"]);	
				}
		  });
        }
    	else{
    	  	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	   	return;
    	}
        	    }    	    
    }	
		
	
function callBackOnOK(){
 $('#fileuploadspousecertificate').show();
}
	
	function callbackOnCancel()
	{
		
	}	
		
		function populatecity(configJson, dataJson){
			// alert("configJson>>> " + JSON.stringify(configJson));
    	
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               var parentcitycodevalue=json["parentcitycode"];
               $('#parentcitycode').val(parentcitycodevalue);
           
               var parentcityname=json["parentcityname"];
          
			     $('#patadcity').val(parentcityname); 
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
		}
		
		
		
		function populategendernominee(configJson, dataJson)
    {
	   // alert("configJson>>> " + JSON.stringify(configJson));
    

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
             
              
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
	   // alert("configJson>>> " + JSON.stringify(configJson));
    

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
         
              
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
			// "stepTitle":"Steps to follow Apply Plastic Card Online",
				"steps":[
					{"step":"Personal Information", "stepIcon":"fa-solid fa-id-card fa-fw"},
					{"step":"Department Information","stepIcon":"fa-solid fa-building fa-fw"},
					{"step":"Dependent Information","stepIcon":"fa-solid fa-users fa-fw"},
					{"step":"Finish","stepIcon":"fa-solid fa-circle-check fa-fw"},
				],
				"activeStepNo":"1"				
		};
	
	
	createWizard(jsonWizzard);

		const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-mm-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		// var id= $(datepicker).attr("id");
    		// $('#'+id).trigger('blur');
    		
        }
    });

	
	$("#patDeputationenddate").datepicker({ minDate:new Date , 
	// maxDate: maximumDate,
	"dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, 
    	// yearRange: "-0:+100",
    	onSelect: function (date, datepicker) {
    		// var id= $(datepicker).attr("id");
    		// $('#'+id).trigger('blur');
    		
        }
    });
    
	
	
	var configJson={
	
			serviceName:"/getData/getBasicpay",
			comboId:"patBasicpayserving",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"}	
			
		}
	callService(configJson);
	
	
	

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
	
	
		  var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdeptpensioner').change(function(){
    	
    	if($('#patdeptpensioner').val()=="")
    	{
    		$('#patsubdeptpensioner').html("<option value=''>Select Organisation Name  (DDO Code)</option>");
    		return;    		
    	}
    	alert("Org Type on change");
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdeptpensioner').val()],
    		}
    	callService(configJson);
    });
	
		 $('#patsubdeptserving').change(function(){
    	
    	if($('#patsubdeptserving').val()=="")
    	{
    		$('#patdeptorgserving').html("<option value=''>Select Organization</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganization",
    			comboId:"patdeptorgserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organization"},
    			primaryKeys:[$('#patsubdeptserving').val()],
    		}
    	callService(configJson);
    	
    
    		var configJson={
    			serviceName:"/getData/getdeptonlineflag",
    			callBackFunctionName:"Populatedeptonline",
       			primaryKeys:[$('#patsubdeptserving').val()],
    		}
    	callService(configJson);
    });
	
	
	
	
	
	 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardcategoryserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select CardCategory"},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
		}
	callService(configJson);
	
	 $('#patcardcategoryserving').change(function(){
    	
    	if($('#patcardcategoryserving').val()=="")
    	{
    		$('#patsubcardtypeserving').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypeserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardcategoryserving').val()],
    		}
    	callService(configJson);
    	
    	
    });
	
	
	

	
	  var configJson={
			serviceName:"/getData/getpayscaleBhavishya",
			comboId:"patpayscaleserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	
		 $('#patpayscaleserving').change(function(){
    	
    	if($('#patpayscaleserving').val()=="")
    	{
    		$('#patpayscalevalueserving').html("<option value=''>Select values</option>");
    		return;    		
    	}
    	alert("Pay Scale Change 1");
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
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"},
			primaryKeys:[basiclevel],
		}
	callService(configJson);
	
		
	 });
	


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
			// "stepTitle":"Steps to follow Apply Plastic Card Online",
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
	
			const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-mm-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		// var id= $(datepicker).attr("id");
    		// $('#'+id).trigger('blur');
    		
        }
    });

   
     
    
    
      $("#Patdorpensioner").datepicker({
    // minDate: new Date(), // Remove or comment this out to allow dates before
	// today
    dateFormat: "dd-M-yy",  // Format the date as day-month-year (e.g.,
							// 09-Nov-24)
    changeMonth: true,  // Allow the user to change the month
    changeYear: true,  // Allow the user to change the year
    showButtonPanel: true,  // Show the button panel (Today, Done)
    showOtherMonths: true,  // Show days from adjacent months
    selectOtherMonths: true,  // Allow selection of days from adjacent months
    yearRange: "-100:+100",  // Allow year range from 100 years ago to 100
								// years in the future
    onSelect: function(date, datepicker) {
        var id = $(datepicker).attr("id");
        $('#' + id).trigger('blur');  // Optional: trigger blur to close the
										// datepicker or for validation
    }
});
    
    
var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"patppodoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[40],
    		}
    	callService(configJson);
	 $('#patppodoctypeid').change(function(){
	//	alert($('#patppodoctypeid').val());
    	
    	if($('#patppodoctypeid').val()=="")
    	{
    		$('#patCardApplyValidity').html("<option value=''>Select Cardvalidity</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getcardvalidity",
    			comboId:"patCardApplyValidity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Card Validity"},
    			primaryKeys:[$('#patppodoctypeid').val()],
    		}
    	callService(configJson);
    });

    	
    	
		var configJson={
	
			serviceName:"/getData/getBasicpay",
			comboId:"patBasicpayPensioner",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"}	
			
		}
	callService(configJson);
	
	
	

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


if($('#cardtypevaluehidden').val()=='SA'){
		 var configJson={
			serviceName:"/getData/getmaincardcategorySA",
			comboId:"patcardtypecategorypen",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"1","optionText":""},
			primaryKeys:["P"],
			
		}
	callService(configJson);
	
	
	}else{
		 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardtypecategorypen",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":""},
			primaryKeys:["P"],
			
		}
	callService(configJson);
	}
 $('#patcardtypecategorypen').change(function(){
    	
    	if($('#patcardtypecategorypen').val()=="")
    	{
    		$('#patsubcardtypepensioner').html("<option value=''>Select SubCategory</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getCardTypeList",
    			comboId:"patsubcardtypepensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select SubCategory"},
    			primaryKeys:[$('#patcardtypecategorypen').val()],
    		}
    	callService(configJson);
    	
  
    	
    	
    });

	
	  var configJson={
			serviceName:"/getData/getpayscaleBhavishya",
			comboId:"patpayscalepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Payscale"}	
			
		}
	callService(configJson);
	
	 $('#patpayscalepensioner').change(function(){
    	
    	if($('#patpayscalepensioner').val()=="")
    	{
    		$('#patpayscalevaluepensioner').html("<option value=''>Select Value</option>");
    		return;    		
    	}
    	if(bhavishyaDataLoad == false) {
    	//	alert("Pay Scale Change 2");
        	var configJson={
        			serviceName:"/getData/getpayscalevalues",
        			comboId:"patpayscalevaluepensioner",			
        			callBackFunctionName:"commonPopulateCombo",
        			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
        			primaryKeys:[$('#patpayscalepensioner').val()],
        		}
        	callService(configJson);
    	}
    	
    });
	
	$('#patpayscalevaluepensioner').change(function(){
		
		
		 var salary= $( "#patpayscalevaluepensioner option:selected" ).text();
		
	var basiclevel=	validateSalary(salary);
			var configJson={
	
			serviceName:"/getData/getbasicpaylevelBasedonvalue",
			comboId:"patBasicpayPensioner",		
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select BasicPay"},
			primaryKeys:[basiclevel],
		}
	callService(configJson);
	
		
	 });
	
	
	  var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Department"}	
			
		}
	callService(configJson);
	
	 $('#patdeptpensioner').change(function(){
    	
		 if($('#patdeptpensioner').val()=="")
	    	{
	    		$('#patsubdeptpensioner').html("<option value=''>Select Organisation Name</option>");
	    		return;    		
	    	}
		
		 if(bhavishyaDataLoad == false) {
			 alert("Org Type On change 2");
			 var configJson={
		    			serviceName:"/getData/getOrganisationnamewithddo",
		    			comboId:"patsubdeptpensioner",			
		    			callBackFunctionName:"commonPopulateCombo",
		    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
		    			primaryKeys:[$('#patdeptpensioner').val()],
		    		}
		    	callService(configJson);
		 }
	    	
    });
	
		 $('#patsubdeptpensioner').change(function(){
    	
    	if($('#patsubdeptpensioner').val()=="")
    	{
    		$('#patdeptorgserving').html("<option value=''>Select Organization</option>");
    		return;    		
    	}
    	
    });
	
	 $('#patsubdeptpensioner').change(function(){
	
	var configJson={
    			serviceName:"/getData/getdeptonlineflag",
    			callBackFunctionName:"Populatedeptonline",
       			primaryKeys:[$('#patsubdeptpensioner').val()],
    		}
    	callService(configJson);
	});
	
	
	
	
	  
    $('#BTNCLEAR').click(resetPage);
  
  
}


		

function saveData() {
//	alert("jhsghdghgdh");
	/*if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	*/
	// Validate form inputs
	
	  $('input:disabled, select:disabled, textarea:disabled').prop('disabled', false);
   if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
  
    showPreloader("Saving Data Please Wait !");

    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/generatetrackingidbhavisya",
        callBackFunctionName: "callbackSaveData",
        	fileUploadFlag:"1",	
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
      // alert("configJson>>>" + JSON.stringify(configJson));
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
/*	alert("configJson>>>>"+JSON.stringify(configJson));
	
	alert("datajson>>>>"+JSON.stringify(dataJson));*/
	
	if(dataJson["message"].indexOf("ERROR")>=0){
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
	else{
		
		var dialogConfigJson={"callOnOK":"CloseTab"}
		showMsg(dataJson["message"],dialogConfigJson)
		
			}
}
function CloseTab(){
	
	//alert("inside closeTab");
	 console.log("Bhavishya Redirect = "+$('#redirectBhavishya').val());
     if($('#redirectBhavishya').val() == "Y") {
     	window.open('', '_self').close();
     }
     else{
    	 resetPage();
     }
    
}
function resetPage(){
	//alerr("ojjjjjj");
parent.closeModal();	
}

  
function addpayment()
{
	var cardtypevalue=$('#cardtypevaluehidden').val();
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
	
	/*
	 * if(ValidateForAllVisible("ENTRYFORM")==false) return;
	 */
	if($("#fileContent2").val()==''){
		
		$("#DepPhotoIdFeedBack").html("Please Select a Photo");
		return;
	}
		
  const depnameadd = document.getElementById('depname').value;
    
   const depentrelationadd= $( "#depentrelation option:selected" ).text();
   const depentrelationaddID= $( "#depentrelation option:selected" ).val();
  const depDOBadd = document.getElementById('depDOB').value;
 // alert("depDOBadd>>>>>>"+depDOBadd);
  
  const depgenderadd=$( "#depgender option:selected" ).text();
  const depgenderaddID=$( "#depgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#depBloodGroup option:selected" ).text();

    const imgSrc = $("#fileContent2").val();
    
    
     const fileuploadvalue=$('#filename11').val();
     const disabilityflag=$('#isdisablityvaluehidden').val();
     const dependentspousecertificate=$('#filename14').val();
    const dependentidproofdoc=$('#filename20').val();
    
     const mainchdob = $('#patDOB').val();
	  	 
		 const mainchage = calculateAge(mainchdob);
		// alert(mainchage);
		
	  	 const dependentdob = $('#depDOB').val();
	  	
		 const depage = calculateAge(dependentdob);
	
	var dependentspousecertificatetypeidvalue=$("#depspousedoctypeid option:selected" ).val();
	
	var dependentIdProofdoctypeidvalue=$("#depidproofdoctypeid option:selected").val();
	var dependentMarriageTypeidvalue=$("#depmardoctypeid option:selected").val();
	// alert("dependentMarriageTypeidvalue>>>>>>>>>>>>>>"+dependentMarriageTypeidvalue);
	var dependentMarriagedoc=$("#filename25").val();
	
	var dependentAgeTypeid=$("#depagedoctypeid option:selected").val();
	var dependentAgedoc=$("#filename24").val();
	var dependentdisableTypeid=$("#depdisdoctypeid option:selected").val();
	
	var dependentincomestatusdoctypeidvalue=$("#depincomestatusdoctypeid option:selected").val(); 
	dependentincomestatusuploaddoc=$("#filename26").val();
	
		if(depage>25 && depentrelationaddID=='5' ){
					showMsg("You Can not add Dependent Son's Age is gretaer than 25","");

					return;
		}
    if(depage>18 && depentrelationaddID=='7'){
		showMsg("you can not add Dependent Brother's Age is gretaer than 18 ","");
			
			return;
		}
     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     "dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc,
     "dependentdisableTypeid":dependentdisableTypeid,
     "dependentdisableuploaddoc":fileuploadvalue,
     "dependentdisabilityflag":disabilityflag,
     "dependentspousecertificatetypeid":dependentspousecertificatetypeidvalue,
     "dependentspousecertificate":dependentspousecertificate,
     "dependentIdProof":dependentidproofdoc,
     "dependentIdProofTypeId":dependentIdProofdoctypeidvalue,
     "dependentMarriageTypeId":dependentMarriageTypeidvalue,
     "dependentMarriagedoc":dependentMarriagedoc,
      "dependentAgeTypeId":dependentAgeTypeid,
      "dependentAgeDoc":dependentAgedoc,
      "dependentIncomeDocTypeId":dependentincomestatusdoctypeidvalue,
       "dependentIncomeDoc":dependentincomestatusuploaddoc,
       "depdataaddfrombhavisya":"N"
     } 
      createDependentRow(json);
     
     
     // tbody.appendChild(createRow(depnameadd,
		// depDOBadd,depgenderadd,depentrelationadd,depBloodGroupadd ,
		// depdentPhotoadd));
    
    
  	  // updateSerialNumbers();
	  document.getElementById('depname').value = "";
	  document.getElementById('depentrelation').value = "";
	  document.getElementById('depDOB').value = "";
	  document.getElementById('depgender').value = "";
	  document.getElementById('depBloodGroup').value = "";
	  // document.getElementById('depdentPhotoadd').value = "";
    // Reset the image input (if it's a file input field)
    document.getElementById('fileContent2').value = ""; // Reset image field

    // Reset file upload fields (if they're file input fields)
    document.getElementById('filename11').value = "";  // Reset first file
														// upload
    document.getElementById('filename14').value = "";  // Reset second file
														// upload
    document.getElementById('filename20').value = "";  // Reset ID proof field
     document.getElementById('preview2').value = ""; 
     $('#preview2').attr("src" ,"").hide();
    removeFileWithoutView("20","mandatory","CARDDOCUMENT");
    removeFileWithoutView("14","mandatory","CARDDOCUMENT");
    removeFileWithoutView("11","mandatory","CARDDOCUMENT");

    // If you have an <img> tag to display the selected image, you can reset its
	// `src` attribute like this:
 // document.getElementById('preview2').src = ""; // Replace 'imgPreview'
	// with your actual img tag id if needed
   
}
function createDependentRow(json) {
	
    var deprelationvalue = json["dependentRelation"];
    var maritalStatus = json["dependentMaritalStatus"];
    var handicappedCertificate = json["handicapped_Certificate"];
    
//    alert("Marital Status of Dependent = "+json["depname"]+"\t Marital Status = "+maritalStatus);
    
    var html = "<tr>";
    var uploadHtml = "Not Applicable";

    // If relation is 'Self', change the row color and add it to the top of the table
    if (deprelationvalue === 'Self') {
    	html = "<tr class='highlight'>";
        html += "<td class='slno'></td>";
        html += "<td>" + json["depname"] + "</td>";
        html += "<td>" + json["deppendentDOBadd"] + "</td>";
        html += "<td>" + json["dependentGender"] + "</td>";
        html += "<td>" + json["dependentRelation"] + "</td>";
        html += "<td><img src='" + json["dependentPhoto"] + "' style='width:100px;height:100px'></td>";
        html += "<td>"+uploadHtml+"</td>";
        html += "<td><button class='deleteBtn' style='display:none;'>Delete</button></td>";  // Hide delete for 'Self'
        html += "<input type='hidden' name='dependentJson' value='" + JSON.stringify(json) + "'>";
        html += "</tr>";

        // Prepend the 'Self' row to the top of the table
        $('#dependenttable tbody').prepend(html); // prepend adds it at the beginning
        $('#dependenttable tbody tr:last-child').css("background-color", "#F0F8FF"); // Alice blue color for others
    } else {
    	handicappedCertificate = "Test-Son-UploadDoc";
//    	alert("Dep Name = "+json["depname"]+"\t Dependent Relation = "+deprelationvalue.toUpperCase()+"\n Marital Status = "+maritalStatus);
    	if(deprelationvalue.toUpperCase() === "BROTHER" && handicappedCertificate.length > 0 ) { // For Disabled Brother
//    		alert("Brother Upload Add");
    		uploadHtml = '<div id="uploadBhavishyaDoc" class="file-group"><label class="div-inline" style="float: left; margin-right: 2px;"><span class="btn  btn-his-sm  btn-sm">Choose File<input type="file" id="uploadDependentDoc" name="file"></span></label> <input type="text" class="form-control form-control-sm classMandat"	readonly="readonly"	style="float: left; margin-right: 2px; width: 35%" data-validation="mandatory"><br></div><div id="divFaIcon12" style="float: left; margin-right: 2px;"> <a class="btn  btn-his-sm  btn-sm" id="faUpload12"	onclick="uploadDoc(12,"BROTHERDOCUMENT","1");">Upload</a></div>';

    	} else if(deprelationvalue.toUpperCase() === "SISTER"  && 
    			( maritalStatus == 2 || maritalStatus == 3 ) ) { // For Widow or Divorcee Sister
//    		alert("Sister Upload Add");

    		uploadHtml = '<div id="uploadBhavishyaDoc" class="file-group"><label class="div-inline" style="float: left; margin-right: 2px;"><span class="btn  btn-his-sm  btn-sm">Choose File<input type="file" id="uploadDependentDoc" name="file"></span></label> <input type="text" class="form-control form-control-sm classMandat"	readonly="readonly"	style="float: left; margin-right: 2px; width: 35%" data-validation="mandatory"><br></div><div id="divFaIcon12" style="float: left; margin-right: 2px;"> <a class="btn  btn-his-sm  btn-sm" id="faUpload12"	onclick="uploadDoc(12,"SISTERDOCUMENT","1");">Upload</a></div>';
    		
    	} else if(deprelationvalue.toUpperCase() === "DAUGHTER" && 
    			( maritalStatus == 2 || maritalStatus == 3 ) ) { // For Widow or Divorcee Daughter
//    		alert("Daughter Upload Add");
    		
    		uploadHtml = '<div id="uploadBhavishyaDoc" class="file-group"><label class="div-inline" style="float: left; margin-right: 2px;"><span class="btn  btn-his-sm  btn-sm">Choose File<input type="file" id="uploadDependentDoc" name="file"></span></label> <input type="text" class="form-control form-control-sm classMandat"	readonly="readonly"	style="float: left; margin-right: 2px; width: 35%" data-validation="mandatory"><br></div><div id="divFaIcon12" style="float: left; margin-right: 2px;"> <a class="btn  btn-his-sm  btn-sm" id="faUpload12"	onclick="uploadDoc(12,"DAUGHTERDOCUMENT","1");">Upload</a></div>';
			
    	} else if(deprelationvalue.toUpperCase() === "SON" && handicappedCertificate.length > 0 ) { // For Disabled Son
//    		alert("Son Upload Add");

    		uploadHtml = '<div id="uploadBhavishyaDoc" class="file-group"><label class="div-inline" style="float: left; margin-right: 2px;"><span class="btn  btn-his-sm  btn-sm">Choose File<input type="file" id="uploadDependentDoc" name="file"></span></label> <input type="text" class="form-control form-control-sm classMandat"	readonly="readonly"	style="float: left; margin-right: 2px; width: 35%" data-validation="mandatory"><br></div><div id="divFaIcon12" style="float: left; margin-right: 2px;"> <a class="btn  btn-his-sm  btn-sm" id="faUpload12" onclick="uploadDoc(12,"SONDOCUMENT","1");">Upload</a></div>';
    		
    	}
    	
//    	alert("Upload Doc HTML = "+uploadHtml);
        // Regular row for other relations
        html += "<td class='slno'></td>";
        html += "<td>" + json["depname"] + "</td>";
        html += "<td>" + json["deppendentDOBadd"] + "</td>";
        html += "<td>" + json["dependentGender"] + "</td>";
        html += "<td>" + json["dependentRelation"] + "</td>";
        html += "<td><img src='" + json["dependentPhoto"] + "' style='width:100px;height:100px'></td>";
        html += "<td>"+uploadHtml+"</td>"
        // Handling delete button based on relation
        html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";
        html += "<input type='hidden' name='dependentJson' value='" + JSON.stringify(json) + "'>";
        html += "</tr>";
        
        // Append regular row to the table
        $('#dependenttable tbody').append(html);
    }

    // Update the serial numbers (slno)
    var index = 1;
    $('.slno').each(function() {
        $(this).text(index);
        index++;
    });
}


/*
 * 
 * function createRow(json, rowId); { }
 */
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
           const row = icon.parentElement.parentElement; // Get the <tr>
															// element (row) of
															// the clicked
															// button
            row.remove();  // Remove the row from the table
            updateSerialNumbers();
        }


 function updateSerialNumbers() {
            const tbody = document.querySelector('#dependenttable tbody');
            const rows = tbody.querySelectorAll('tr');

            // Loop through all rows and update the serial number
            rows.forEach((row, index) => {
                row.cells[0].textContent = index + 1;  // Update the serial
														// number (first cell)
            });
        }

function cleardepdetail()
{
	document.getElementById('depname').innerHTML = "";
	document.getElementById('depentrelation').innerHTML = "";
	document.getElementById('depDOB').innerHTML = "";
	document.getElementById('depgender').innerHTML = "";
	document.getElementById('depMobile').innerHTML = "";
}


function clearvaluesperinfo()
{
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
	
if(ValidateForAllVisible("ENTRYFORM")==false)
	return;
	var cardtypevalue=$('#cardtypevaluehidden').val();
	if (cardtypevalue === 'P' || cardtypevalue === 'SA')
	{
		$('#deptinfopensioner').hide();
		$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("1");
	}else{
		$('#deptinfoserving').hide();
		$('#Nomineeinfo').show();
		 $('#isnomineeadd').val("0");
	}
	jsonWizzard["activeStepNo"]="4";
	createWizard(jsonWizzard);
}


function shownomineeserving()
{
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	var cardtypevalue=$('#cardtypevaluehidden').val();
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
 * function showdependentServing() {
 * alert(document.getElementById("chkDependent1")[i].checked);
 * if(document.getElementById("chkDependent1")[i].checked){
 * $('#BTNNEXT2').show(); $('#BTNPreviewDept').hide(); } else{
 * $('#BTNNEXT2').hide(); $('#BTNPreviewDept').show(); }
 * $('#deptinfoserving').hide(); $('#Nomineeinfo').show(); }
 */
function showdependentpensioner()
{
			
var checkbox =document.getElementById('customCheck12');
 if (checkbox.checked) {
	 	 
	/* var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val(),
	     "dependentdisableuploaddoc":"",
	     "dependentdisabilityflag":"0",
	     "dependentspousecertificate":"",
	    "dependentIdProof":$("#filename19").val(),
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":""
	    
	        
	     } 
	 createDependentRow(json);*/
	 	$('#dependentinfo').show();
	 
	 	 $('#isdependentadd').val("1");
	 }
	 else{
		  $('#dependentinfo').hide();
		   $('#isdependentadd').val("0");
	 }

}
  
  function showdependentserving()
{
var checkbox =document.getElementById('chkDependent1');
 if (checkbox.checked) {
	 $('#BTNNEXT2').show();
	 $('#BTNPreviewDept').hide();
	
	$('#isdependentadd').val("1");
	 	 
	 }
	 else{
		
		   $('#BTNPreviewDept').show();
		
		  $('#BTNNEXT2').hide();
		  $('#isdependentadd').val("0");
	 }

}
  
  
  
  function uploaddisabledocument()
  {
var checkbox =document.getElementById('customCheckdisable');
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
/*
 * if(ValidateForAllVisible("ENTRYFORM")==false) return;
 */
          
	 var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val(),
	     "dependentdisableuploaddoc":"",
	     "dependentdisabilityflag":"0",
	     "dependentspousecertificate":"",
	    "dependentIdProof":$("#filename19").val(),
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":""
	    
	        
	     } 
	 createDependentRow(json);
	 
	jsonWizzard["activeStepNo"]="2";
	createWizard(jsonWizzard);	
var cardtypevalue="P";


if (cardtypevalue === 'P' || cardtypevalue === 'SA'){
	$('#dependentinfo').show();
// $('#deptinfopensioner').hide();
	$('#BTNPreviewDependent').hide();
	// $('#BTNUNDERTAKINGServing').hide();
	
}
else{
	$('#dependentinfo').show();
	$('#deptinfoserving').hide();
	$('#BTNNEXT4').hide();
	$('#BTNPreviewDependent').show();	
	// $('#BTNUNDERTAKINGServing').show();
}
		
  jsonWizzard["activeStepNo"]="3";
  createWizard(jsonWizzard);	
}

	
  
  function UnderTakingServing()
  {
	  var isdepvalue= $('#isdependentadd').val();
	   var isdepvalue= $('#isdependentadd').val();
	    var patname= $('#patName').val();
	       $("#mainchname").text(patname);
	 	if(isdepvalue=='1'){
		  $('#cghsundertakingwithdependent').show();
		  $('#deptinfoserving').hide();	 
				    $('#dependentinfo').hide();
		   
		 
	  }else{
		   var patname= $('#patName').val();
		   $("#mainchnamewithotdep").text(patname);
		  		   $('#cghsundertakingwithOutdependent').show();	
		    $('#deptinfoserving').hide();	
		  
	  }	 
	  
  }
	  function UnderTaking()
  {
		  
		  if(bhavishyaDataLoad == false) {
			  $('input:disabled, select:disabled, textarea:disabled').prop('disabled', false);
		  }
		   if (ValidateForAllVisible("ENTRYFORM") === false) {
		        return;
		    }
		   
	   $('#spousecondn').hide();
	     $('#daughtersister').hide();
	       $('#parentinlaw').hide();
	  //  alert("iiinn UnderTaking");
	    var isdepvalue= $('#isdependentadd').val();
	    var patname= $('#patName').val();
	  var bhavisyadepflag=  $('#isdependentaddbhavisya').val();
	 
	       $("#mainchname").text(patname);
	          $("[name=dependentJson]").each(function(){
				  
				  
				   var json = JSON.parse( $(this).val());
				//  alert("Relation"+ json["dependentRelationId"]);// (if spouse added as dependent).
				  if(json["dependentRelationId"]==2){
              $('#spousecondn').show();
				  }
				   if(json["dependentRelationId"]==6  || json["dependentRelationId"]==20 ||  json["dependentRelationId"]==21){
              $('#daughtersister').show();
				  }
				     if(json["dependentRelationId"]==9  || json["dependentRelationId"]==10 ){
              $('#parentinlaw').show();
				  }
				  
				 
				  
				  });
	          
	          $('#depinfo').hide();
	          
	if(isdepvalue=='1' || bhavisyadepflag==1){
		
		  $('#deptinfopensioner').hide();
		   $('#perinfo').hide();
		  
		  $('#cghsundertakingwithdependent').show();
		  $('#Nomineeinfo').hide();	 
	    $('#dependentinfo').hide();
	  
	 
	  }
	  
	  
	  else{
		  
				  var patname= $('#patName').val();
	  $('#deptinfopensioner').hide();
		   $('#perinfo').hide();
	       $("#mainchnamewithotdep").text(patname);
		   $('#cghsundertakingwithOutdependent').show();	
		    $('#Nomineeinfo').hide();
		      $('#dependentinfo').hide();	
		      
		 /*   var json={"depname": $("#patName").val(),
	     "dependentRelation":   $( "#patrelation option:selected" ).text(),
	  	     "dependentGender":$( "#patGender option:selected" ).text(),
	      "dependentGenderId":$( "#patGender option:selected" ).val(),
	      "dependentRelationId":$("#patrelation option:selected").val(),
	     "dependentBloodGroupadd":$( "#patBloodGroup option:selected" ).text(),
	     "deppendentDOBadd":$("#patDOB").val(),
	     "dependentPhoto":$("#mainPhotoId").val(),
	     "dependentdisableuploaddoc":"",
	     "dependentdisabilityflag":"0",
	     "dependentspousecertificate":"",
	    "dependentIdProof":$("#filename19").val(),
	    "dependentidproofdoctypename": $( "#mainchdoctypeid option:selected" ).text(),   
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":""
		      
	  }
		  createDependentRow(json); */
	  }

		
  jsonWizzard["activeStepNo"]="4";
  createWizard(jsonWizzard);	
}
	    
  /*
  function UnderTaking()
  {
	    var isdepvalue= $('#isdependentadd').val();
	    var patname= $('#patName').val();
	 
	       $("#mainchname").text(patname);
	       
	if(isdepvalue=='1'){
		
		  $('#cghsundertakingwithdependent').show();
		   $('#deptinfopensioner').hide();	
		   $('#perinfo').hide();	
		  $('#Nomineeinfo').hide();	 
	  }else{
		  var patname= $('#patName').val();
	
	       $("#mainchnamewithotdep").text(patname);
		   $('#cghsundertakingwithOutdependent').show();	
		   $('#deptinfopensioner').hide();	
		   $('#perinfo').hide();
		    $('#Nomineeinfo').hide();	
	  }
		  
	  

		
  jsonWizzard["activeStepNo"]="4";
  createWizard(jsonWizzard);	
}
	  
   
 */
  
  function prevStep3()
  {
var cardtypevalue=$('#cardtypevaluehidden').val();
 if (cardtypevalue === 'P')
{
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
 if (checkbox.checked) {
	 $('#alternamenominee').show();
	  $('#addnaltomineehidden').val("1");	 
	 }
	 else
	 {
		 $('#alternamenominee').hide();
		  $('#addnaltomineehidden').val("0");
	 }
}

	  
function nextStep() {
	if(ValidateForAllVisible("ENTRYFORM")==false){
		return;
	}
		
	if($("#mainPhotoId").val()==''){
		
		$("#mainPhotoIdFeedBack").html("Please Select a Photo");
		return;
	}	
	
	var cardtypevalue=$('#cardtypevaluehidden').val();
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
	     "dependentdisableuploaddoc":"",
	     "dependentdisabilityflag":"0",
	     "dependentspousecertificate":"",
	    "dependentIdProof":$("#filename19").val(),
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":""
	    
	        
	     } 
	 createDependentRow(json);
	 
	jsonWizzard["activeStepNo"]="2";
	createWizard(jsonWizzard);	
}



function prevStep() {
	var cardtypevalue=$('#cardtypevaluehidden').val();
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

  function Previewform() {
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
	        html += "<td class='slnoNom'>" + (indx + 1) + "</td>";  // Index
																	// starts
																	// from 1
																	// for
																	// serial
																	// number
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
	    
	   // const tbody = document.querySelector('#dependenttable tbody');
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
			    /*
				 * html +="<td style='display:none;'>" +
				 * json["dependentBloodGroupadd"]+"</td>";
				 */
			     html +="<td><img src='"+json["dependentPhoto"]+"' style='width:100px;height:100px'>" ;
			     html +="</tr>";
			    $("#AutoNumber1 tbody").append(html); 
			 // $('#AutoNumber2Iimg'+indx).html("<img
				// src='"+json["dependentPhoto"]+"'
				// style='width:100px;height:100px;' />")
			 	// $('#AutoNumber2ISno'+indx).html(indx);
			 	
			    indx++;
			  
		  });
          
	       
	    var cardtypevalue="P";
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
               
               
                 
            var resaddress=$("#patresaddress").val();
           $("#dialogoresadress").text(resaddress);
           
            $("#dialogstate").html($("#stateCode option:selected" ).text())
          $("#dialogdistrict").html($("#districtCode option:selected" ).text())
        var patpincode= $("#patpincodeserving").val();
          $("#dialogpincode").text(patpincode);
         $("#dialogcghscity").html($("#PatientCghsCity option:selected").text())
          
    
         
        	if (cardtypevalue === 'P' || cardtypevalue === 'SA'){	
				alert($('#patcardtypecategorypen option:selected').text());
			   $("#dialogcardtypeBhavishya").text($('#patcardtypecategorypen option:selected').text());
            $("#dialogsubcardtype").text($("#patsubcardtypepensioner option:selected").text());
            
            $('#dialogFmaFacilityBhavishya').text($("#patfmafacilitypensioner option:selected").text());
            
           $("#dialogdateofret").text($("#Patdorpensioner").val());
             $("#dialogcardvalidity").html($("#patCardApplyValidity option:selected").text())
        
        $("#mainchnameform").text(mainname);
         
         
         $("#diagogpayscale").html($("#patpayscalepensioner option:selected").text())
       
		   $("#dialogcardtype").html($( "#patcardtypepensioner option:selected" ).text())
		  $("#dialogdept").html($( "#patdeptpensioner option:selected" ).text())
		   var ofcaddress=$("#patofcadrpensioner").val();
           $("#dialogofcadress").text(ofcaddress);
             $("#dialogpayscale").html($("#patpayscalepensioner option:selected" ).text())
         //
           $("#dialogpreslastpay").text($("#patpayscalevaluepensioner option:selected" ).text());
           
           
           // $("#dialogdesignation").html($( "#patdesignationpensioner
			// option:selected" ).text())
                 var penpincode=$("#patpincodepensioner").val();
           $("#dialogpin").text(penpincode);
          var dofretirement=$("#Patdorpensioner").val();
           $("#dialogretirementdate").text(dofretirement);
                    var PPOnumber=$("#Patppopensioner").val();
              $("#dialogppono").text(PPOnumber);    
                      
              
      var dateofretirement= $("#Patdorpensioner").val(); 
        $("#dialogdateofret").text(dateofretirement);
        
        var ppo = $("#Patppopensioner").val();
        if(ppo != "" && ppo > 0) {
        	$('#patPpoStatus').text("Yes");
        	$('#patPpoNumber').text(ppo);
        } else {
        	$('#patPpoStatus').text("No");
        	$('#patPpoNumber').text("");
        }
        	
        
        
        var fmavalue=$("#patfmapensioner").val(); 
        if(fmavalue==1)
        {
			$('#dialogfma').text("yes");
		}else
            {
				$('#dialogfma').text("No");
			}
			
			     var deptonlineflag=$('#departmentonoffhiddenflag').val(); 
	       if(deptonlineflag=="1")
	       {
			   $('#sponsoringauthpensioner').show();
			   
		   }else
		   {
			      $('#sponsoringauthpensioner').hide();
		   }
			 $('#myModalcghsform').modal('show');
             
                      
     	    	 var formhtml=encryptBase64($('#onlineplasticformhtml').html() );
	    $('#onlineapplicationhidden').val(formhtml);
             
              }else
		   {
	   
	   var name = $("#patName").val();
           $("#dialogNameservindeo").text(name);
           
           var mainname = $("#patName").val();
           $("#mainchnameformdepon").text(mainname);
                      
           var email=$("#patEmail").val();
           $("#dialogemaildepon").text(email);
           
            var mob=$("#patMobileNo").val();
           $("#dialogemobdepon").text(mob);
           
             var patDOB= $("#patDOB").val(); 
           $("#dialogdob").text(patDOB);
                          
              var mainrelation=$("#patrelation").val();
           $("#dialogrelation").text(mainrelation);
           
          $("#dialogbldgrup").html($( "#patBloodGroup option:selected" ).text())
          $("#dialoggen").html($( "#patGender option:selected" ).text())
                  
                  $("#dialogcghscitydepon").html($("#PatientCghsCity option:selected").text())
                     $("#dialogbasicpaydepo").html($("#patBasicpayserving option:selected").text())
                  
            var depname = $("#depname").val();
            $("#dialogdepNameDepon").text(depname);
           $("#dialogdeprelationship").html($( "#depentrelation option:selected" ).text())
            var depdob=$("#depDOB").val();
           $("#dialogdepdob").text(depdob);
             var resaddress=$("#patresaddress").val();
           $("#dialogoresadressdepon").text(resaddress);
           
            $("#dialogstatedepon").html($("#stateCode option:selected" ).text())
            
          $("#dialogdistrictdepon").html($("#districtCode option:selected" ).text())

        var patpincode= $("#patpincodeserving").val();
          $("#dialogpincodedepon").text(patpincode);
         $("#dialogcghscity").html($("#PatientCghsCity option:selected").text())
          
	   
	      
	    
	      $("#dialogdeptserving").html($("#patdeptserving option:selected" ).text());
			   var ofcaddressserving=$("#patofcadrserving").val();
           $("#dialogofcadress").text(ofcaddressserving);
           
           
		   $("#diagogpayscaledepon").html($( "#patpayscaleserving option:selected" ).text());
             $("#dialogdesignation").html($("#patdesignationserving option:selected" ).text());
                                                                             
           var resaddress=$("#patresaddress").val();
           $("#dialogoresadress").text(resaddress);
          
          
              var deputationflagdisplay=$('#deputationflaghidden').val();  
              
               
	     
          if(deputationflagdisplay==1)
           {
		   $('#dialogdepflag').text("yes");
	        }
	        
	        var deptonlineflag=$('#departmentonoffhiddenflag').val(); 
	       if(deptonlineflag=="1")
	       {
			   $('#sponsoringauthservingdept').hide();
			   
		   }else
		   {
			      $('#sponsoringauthservingdept').show();
		   }
	        
	        var patDeputationyearvalue=$('#patDeputationenddate').val();
	        $('#dialogdepdate').text(patDeputationyearvalue);
	           $('#dialogprespay').html($( "#patpresentpayserving option:selected" ).text())
	           
	                    
     	 $('#myModalcghsformservingdeptonline').modal('show');
     	 var formhtml=encryptBase64($('#onlineplasticformhtmlservingdeptonline').html() );
	    $('#onlineapplicationhidden').val(formhtml);
         }
	   	    	   
	 
       
        }

 function saveundertakingwithDep() {
            // Check if all checkboxes are checked
            if($('input[name="undertakingChk"]:checked').length<11){
			alert("Please complete Undertaking")
				return
							}
							else{
							// alert("allowed");
								Previewform();
							}
		
        }



 function saveundertakingwithoutDep() {
            // Check if all checkboxes are checked
            if($('input[name="undertakingChk1"]:checked').length<3){
				alert("Please complete Undertaking")
				return
							}
							else{
							// alert("allowed");
								Previewform();
							}
		
        }
/*
 * function Previewform() { //alert("in method");
 * if($('#divDependentEntry').is(":visible")){ $('#divDependentEntry').hide(); } //
 * Primary nominee details if (ValidateForAllVisible("ENTRYFORM") === false) {
 * return; }
 * 
 * const nomname1 = $("#nomname").val(); const nomrelation1 = $("#nomrelation
 * option:selected").text(); const nomdob1 = $("#nomdob").val(); const
 * nomgender1 = $("#nomgender option:selected").text(); const nommobile =
 * $('#nommobile').val(); const nombenid = $('#nombenid').val(); const nomaadhar =
 * $('#nomaadhar').val(); const nomaddress = $('#nomaddress').val(); const
 * nomproofvalue=$('#filename15').val(); var nomineeJson = new Array();
 * if(nomname1!=""){ // Primary nominee JSON object var json = { "nomnameadd":
 * nomname1, "nomrelationadd": nomrelation1, "nomgenderadd": nomgender1,
 * "nomdobadd": nomdob1, "nommobileadd": nommobile, "nombenidadd": nombenid,
 * "nomaddressadd": nomaddress, "nomaadharadd": nomaadhar,
 * "nomproof":nomproofvalue }; // Add the primary nominee to the array
 * nomineeJson.push(json); }
 * 
 * var isnomineeaddvalue = $('#isnomineeadd').val(); if(nomineeJson) { // If
 * alternate nominee is present if (isnomineeaddvalue == 1 ) { // Alternate
 * nominee details const alternatenominename = $("#altnomname").val(); const
 * alternatenominenamerelation = $("#altnomrelation option:selected").text();
 * const alternatenominedob = $("#altnomdob").val(); const alternatenominegender =
 * $("#altnomgender option:selected").text(); const alternatenomineMobile =
 * $("#altnommobile").val(); const alternatenominebenid =
 * $('#altnombenid').val(); const alternatenomineaadhar =
 * $('#altnomaadhar').val(); const alternatenomineaadress =
 * $('#altnomaddress').val(); const
 * alternatenomineeproof=$('#filename17').val(); if(alternatenominename!=""){ //
 * Alternate nominee JSON object var json1 = { "nomnameadd":
 * alternatenominename, "nomrelationadd": alternatenominenamerelation,
 * "nomgenderadd": alternatenominegender, "nomdobadd": alternatenominedob,
 * "nommobileadd": alternatenomineMobile, "nombenidadd": alternatenominebenid,
 * "nomaddressadd": alternatenomineaadress, "nomaadharadd":
 * alternatenomineaadhar, "nomproof":alternatenomineeproof }; // Add alternate
 * nominee to the array nomineeJson.push(json1); } } // Clear previous entries
 * in the table $("#AutoNumber3 tbody").empty(); if(nomineeJson.length>0){ //
 * Append nominee details to the table nomineeJson.forEach(function(obj, indx) {
 * var html = "<tr>"; html += "<td class='slnoNom'>" + (indx + 1) + "</td>"; //
 * Index starts from 1 for serial number html += "<td>" + obj["nomnameadd"] + "</td>";
 * html += "<td>" + obj["nomdobadd"] + "</td>"; html += "<td>" +
 * obj["nomrelationadd"] + "</td>"; html += "<td>" + obj["nomgenderadd"] + "</td>";
 * html += "<td>" + obj["nommobileadd"] + "</td>"; html += "</tr>";
 * 
 * $("#AutoNumber3 tbody").append(html); }); }else{ $('#liNominee').hide(); }
 * 
 * //const tbody = document.querySelector('#dependenttable tbody'); const rows =
 * document.querySelectorAll('#dependenttable tbody tr'); var indx=1;
 * $("#AutoNumber1 tbody").empty(); $("[name=dependentJson]").each(function(){
 * var json = JSON.parse( $(this).val());
 * 
 * var html ="<tr >";
 * 
 * 
 * html +="<td class='slno'>"+indx+"</td>"; html +="<td>" +
 * json["depname"]+"</td>"; html +="<td>" + json["deppendentDOBadd"]+"</td>";
 * html +="<td>" + json["dependentRelation"] +"</td>"; html +="<td>" +
 * json["dependentGender"]+"</td>"; html +="<td style='display:none;'>" +
 * json["dependentBloodGroupadd"]+"</td>"; html +="<td><img
 * src='"+json["dependentPhoto"]+"' style='width:100px;height:100px'>" ; html
 * +="</tr>"; $("#AutoNumber1 tbody").append(html);
 * //alert("$('#AutoNumber2Iimg'+indx)>>" + $('#AutoNumber2Iimg'+indx).length) //
 * $('#AutoNumber2Iimg'+indx).html("<img src='"+json["dependentPhoto"]+"'
 * style='width:100px;height:100px;' />")
 * //$('#AutoNumber2ISno'+indx).html(indx);
 * 
 * indx++;
 * 
 * });
 * 
 * 
 * var cardtypevalue=$('#cardtypevaluehidden').val(); var name =
 * $("#patName").val(); $("#dialogName").text(name);
 * 
 * var mainname = $("#patName").val(); $("#dialogNamemain").text(mainname);
 * 
 * var email=$("#patEmail").val(); $("#dialogemail").text(email);
 * 
 * var mob=$("#patMobileNo").val(); $("#dialogemob").text(mob);
 * 
 * var patDOB= $("#patDOB").val(); $("#dialogdob").text(patDOB);
 * 
 * var mainrelation=$("#patrelation").val();
 * $("#dialogrelation").text(mainrelation);
 * 
 * $("#dialogbldgrup").html($( "#patBloodGroup option:selected" ).text())
 * $("#dialoggen").html($( "#patGender option:selected" ).text())
 * 
 * 
 * var depname = $("#depname").val(); $("#dialogdepName").text(depname);
 * $("#dialogdeprelationship").html($( "#depentrelation option:selected"
 * ).text()) var depdob=$("#depDOB").val(); $("#dialogdepdob").text(depdob);
 * $("#dialogdepbldgrup").html($( "#depBloodGroup option:selected" ).text())
 * $("#dialogdepgen").html($( "#depgender option:selected" ).text())
 * 
 * 
 * var resaddress=$("#patResaddress").val();
 * $("#dialogoresadress").text(resaddress);
 * 
 * if(cardtypevalue=='P'){
 * 
 * 
 * $("#dialogcardtype").html($( "#patcardtypepensioner option:selected"
 * ).text()) $("#dialogdept").html($( "#patdeptpensioner option:selected"
 * ).text()) var ofcaddress=$("#patofcadrpensioner").val();
 * $("#dialogofcadress").text(ofcaddress); $("#dialogpayscale").html($(
 * "#patpayscalepensioner option:selected" ).text())
 * 
 * var plastpay=$("#patlastpaypensioner").val(); //
 * alert("lastpay>>>>>"+plastpay) $("#dialogpreslastpay").text(plastpay); //
 * $("#dialogdesignation").html($( "#patdesignationpensioner option:selected"
 * ).text()) var penpincode=$("#patpincodepensioner").val();
 * $("#dialogpin").text(penpincode); var
 * dofretirement=$("#Patdorpensioner").val();
 * $("#dialogretirementdate").text(dofretirement); var
 * PPOnumber=$("#Patppopensioner").val(); $("#dialogppono").text(PPOnumber);
 * 
 * 
 * 
 * }else { // alert("iinnn elseee"); $("#dialogcardtype").html($(
 * "#patcardtypeserving option:selected" ).text()) $("#dialogcardtype").html($(
 * "#patdeptserving option:selected" ).text()) var
 * ofcaddressserving=$("#patofcadrserving").val();
 * $("#dialogofcadress").text(ofcaddressserving);
 * 
 * $("#dialogpayscale").html($( "#patpayscaleserving option:selected" ).text())
 * $("#dialogdesignation").html($("#patdesignationserving option:selected"
 * ).text())
 * 
 * 
 * $('#dialogtransferablecity').html($( "#PatTransferablecityflag
 * option:selected" ).text())
 * 
 * var deputationflagdisplay=$('#deputationflaghidden').val(); //
 * alert(deputationflagdisplay); if(deputationflagdisplay==1) {
 * $('#dialogdeputation').text("yes"); }
 * 
 * var patDeputationyearvalue=$('#patDeputationyear').val();
 * $('dialogdeputationyear').val(patDeputationyearvalue);
 * $('#dialogprespay').html($( "#patpresentpayserving option:selected" ).text())
 * 
 * $('#myModalcghsform').modal('show'); var
 * formhtml=encryptBase64($('#onlineplasticformhtml').html() );
 * $('#onlineapplicationhidden').val(formhtml); } }
 */


 function prevstep5()
 {
	 // alert("1111");
	 $('#Paymentinfo').hide();
	 $('#Nomineeinfo').show();
 }
 
 
 
function prevStep4()
{
var checkboxpensioner =document.getElementById('customCheck12');
var checkboxserving =document.getElementById('customCheck1');
	var cardtypevalue=$('#cardtypevaluehidden').val();
if (cardtypevalue === 'P' ||cardtypevalue === 'SA' )
{
	if (checkboxpensioner.checked) {
	 $('#Nomineeinfo').hide();
	 $('#dependentinfo').show();
		 jsonWizzard["activeStepNo"]="3";
		 createWizard(jsonWizzard);
	 }
	 else
	 {
	     $('#Nomineeinfo').hide();
		 $('#deptinfopensioner').show();
		 jsonWizzard["activeStepNo"]="2";
		 createWizard(jsonWizzard);
	 }
	
}else
{
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
	document.getElementById("deptinfo").style.display="block";
	document.getElementById("deptinstr").style.display="block";

	document.getElementById("adddepent").style.display="None";
	document.getElementById("dependentinfo").style.display="None";
	}




function addnominee()
{	
	
	var cardtypevalue=$('#cardtypevaluehidden').val();
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

 /*
	 * function uploadPhoto() {
	 * 
	 * 
	 * document.getElementById(ctInputFileNameId).addEventListener('change',
	 * function(event) { const file = event.target.files[0]; const reader = new
	 * FileReader(); reader.onload = function(e) {
	 * document.getElementById(ctPreviewId).src = e.target.result;
	 * document.getElementById(ctPreviewHiddenId).value = e.target.result;
	 * 
	 * document.getElementById(ctPreviewId).style.display = 'block';
	 * document.getElementById('video').style.display = 'none';
	 * document.getElementById('capture').style.display = 'none';
	 * document.getElementById('canvas').style.display = 'none'; hidePopup(); };
	 * reader.readAsDataURL(file); $("#mainPhotoIdFeedBack").html("");
	 * hidePopup(); });
	 * 
	 * document.getElementById(ctInputFileNameId).click();
	 *  }
	 */
function uploadPhoto() {
    document.getElementById(ctInputFileNameId).addEventListener('change', function(event) {
        const file = event.target.files[0];

        // Check if file exists and validate its size (10 KB = 10240 bytes)
        if (file && file.size <= 10240) {
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

            $("#mainPhotoIdFeedBack").html(""); // Clear any previous error
												// message
            hidePopup();
        } else {
            // Show error message if file is too large
            $("#mainPhotoIdFeedBack").html("Please upload a photo smaller than 10 KB.");
            document.getElementById(ctPreviewId).style.display = 'none';
            document.getElementById('video').style.display = 'none';
            document.getElementById('capture').style.display = 'none';
            document.getElementById('canvas').style.display = 'none';
        }
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
		
		 $("#mainPhotoIdFeedBack").html("");
		
		 hidePopup();
	  
	 }
	
function calculateAge(dobString) {
    // Parse the date in 'dd-MMM-yyyy' format
    const dobParts = dobString.split('-');
    const day = parseInt(dobParts[0], 10);
    const month = dobParts[1];
    const year = parseInt(dobParts[2], 10);
    
    // Convert the month name (e.g., 'Nov') into a month number (e.g., 10 for
	// November)
    const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    const monthIndex = monthNames.indexOf(month); // Get month index from the
													// monthNames array
    
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

function Populatedeptonline(configJson, dataJson)
 {
	
	   if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
                $("#departmentonoffhiddenflag").val(json["deptonlineflag"]);
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}	

  function calculateDaysFromTodayToYears(years) {
	    // Get today's date
	    let today = new Date();

	    // Calculate the target date by adding the number of years to today's
		// year
	    let targetDate = new Date(today.getFullYear() + years, today.getMonth(), today.getDate()+1);

	    // Calculate the difference in time (in milliseconds)
	    let differenceInTime = targetDate - today;

	    // Convert the time difference to days
	    let differenceInDays = Math.floor(differenceInTime / (1000 * 60 * 60 * 24));
	    
	    return differenceInDays;
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


// Function to validate PAN number
function validatePAN(pan) {
    const panPattern = /^[A-Z]{3}[P][A-Z][0-9]{4}[A-Z]{1}$/;  // Regular
																// expression
														// for PAN format

    // Convert PAN to uppercase to ensure the input is case-insensitive
    pan = pan.toUpperCase();

    return panPattern.test(pan);  // Returns true if valid, false if invalid
}

// Event listener for blur (clicking outside the input)


function validatepancheck()
	{
		 const pan =$('#patPANNo').val(); // Get the PAN value from the input
											// field
		// alert("333333333"+pan)
    const errorMessageDiv = document.getElementById('error-message');

    // Clear any existing error message
    errorMessageDiv.textContent = '';

    // Check if the PAN is valid
    if (pan && !validatePAN(pan)) {
        // If invalid, show an error message
        errorMessageDiv.textContent = 'Invalid PAN number format. Please enter a valid PAN.';
    } else {
        // If valid, display success or any other message (optional)
        errorMessageDiv.textContent = '';  // Optionally clear any previous
											// error message
    }
	}


function enableDisableBhavishyaFields(status) {
	console.log("Bhavishya Fields Enable/Disable Function Called.");
	
}
let relationExist = false;
function loadDataByPan() {
    var panNumber = $('#panNumber').val();
	//console.log("Load DataBy PAN Number = "+panNumber);
    
    $.ajax({
        url: "services/restful/bhavishya/getBhavishyaData", // API endpoint
        type: "POST", // HTTP method
        dataType: "json", // Expected response format
        contentType: "application/json",
        data: JSON.stringify({
	        panNumber: panNumber
	    }),
        success: function (data) {
            console.log(JSON.stringify(data));
            if(data.statusCode == 200) {
            	bhavishyaDataLoad = true;
            	console.log("Bhavishya Data Retrieval API Response = "+data.message);
            	if(data.relations.length>0)
            		relationExist = true;
            	
            	if(data.fmaFacility == "NOT") {
            		alert("You're Not Eligible For CGHS Card.");
            		return;
            	}
            		
            	populateBhavishyaData(data);
            	
            } 
        },
        error: function (xhr, status, error) {
            console.log(error);
        }
    });
}

function populateBhavishyaData(data) {
	
//	alert("PPO = "+data.ppo);
	if(data.ppo != undefined && data.ppo.length > 0) {
		$('#Patppopensioner').val(data.ppo);
		$('#Patppopensioner').prop('disabled', true);
	}
	
	$('#patName').val(data.name);
	$('#patName').prop('disabled', true);
	
	//alert("base64"+ data.photograph);
	let base64ImagePrefix = 'data:image/png;base64,';

// Adding the prefix before the base64 data
$('#preview').attr('src', base64ImagePrefix + data.photograph);
	
	$("#mainPhotoId").val(base64ImagePrefix + data.photograph);
	
	$('#patDOB').val(data.dob);
	$('#patDOB').prop('disabled', true);
	/*
	$('#patGender').val(data.genderCode);
	var genderCode = data.genderCode;
	let selectGenderValue = "";
	let genderDropDown = document.getElementById("patGender");
	for (let i = 0; i < genderDropDown.options.length; i++) {
	    if (genderDropDown.options[i].value.includes("$"+genderCode)) {
	    	selectGenderValue = genderDropDown.options[i].value
	        break;
	    }
	}
	
*/	
	var genderJson={
			serviceName:"/getData/getGenderListBhavishya",
			comboId:"patGender",
			primaryKeys:[data.genderCode],
			disabled: true,
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Gender"}	
			
		}
	callService(genderJson);
	$('#patGender').prop('disabled', true);
	
	$('#patMobileNo').val(data.mobile);
	$('#patMobileNo').prop('disabled', true);
	
	$('#patEmail').val(data.email);
//	$('#patEmail').prop('disabled', true);
	
	$('#patresaddress').val(data.address);
	$('#patresaddress').prop('disabled', true);
	
		$('#patPANNo').val(data.pan);
		//alert("PAN>>>>>>>>>>>>>>>"+data.pan);
	$('#patPANNo').prop('disabled', true);
	
	
	$('#patpincodeserving').val(data.pincode);
	$('#patpincodeserving').prop('disabled', true);
	
	//$('#PatientCghsCity').val(data.cityDesc);
	

var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":data.cityDesc,"optionText":"Select City"}	
			
		}
	callService(configJson);

 $('#PatientCghsCity').change(function(){
    	
	var configJson={
    			serviceName:"/getData/getADCityBasedonsatelliteCity",
      			callBackFunctionName:"populatecity",			
        		primaryKeys:[data.cityDesc],
    		}
    	callService(configJson);
    });

	
	
	
	//alert("fmaa>>>>>>>"+data.fmaCode);
	var fmacode="";
	
	//	alert("fmacode>>>>>>>>"+data.fmaCode);
		if(data.fmaCode==1 || data.fmaCode==6){
			 var configJson={
				serviceName:"/getData/getFmalistBhavishya",
				comboId:"patfmapensioner",			
				callBackFunctionName:"commonPopulateCombo",
				defaultOption:{"optionValue":"2","optionText":"Select FMA"},
				primaryKeys:[2],
			} 
		
			 callService(configJson);
		 	
			 var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[2],
    		}
    	callService(configJson);
	} else if(data.fmaCode==3){
		 var configJson={
					serviceName:"/getData/getFmalistBhavishya",
					comboId:"patfmapensioner",			
					callBackFunctionName:"commonPopulateCombo",
					defaultOption:{"optionValue":"","optionText":"Select FMA"},
					primaryKeys:[1],
					
				}
		 callService(configJson);
		 var configJson={
	    			serviceName:"/getData/getfacilitybasedonfma",
	    			comboId:"patfmafacilitypensioner",			
	    			callBackFunctionName:"commonPopulateCombo",
	    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
	    			primaryKeys:[1],
	    		}
	    	callService(configJson);
	}
	$('#patfmapensioner').prop('disabled', true);
		$('#patfmafacilitypensioner').prop('disabled', true);
	/*	  var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":data.fmaCode,"optionText":"Select FMA"}	
			
		}
	callService(configJson);
	*/
	
/*		var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[data.fmaCode],
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
    	var configJson={
    			serviceName:"/getData/getfacilitybasedonfma",
    			comboId:"patfmafacilitypensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Facility"},
    			primaryKeys:[data.fmaCode],
    		}
    	callService(configJson);
    });*/
	var stateJson={
			serviceName:"/getData/getStateListBhavishya",
			comboId:"stateCode",	
			disabled: true,
			primaryKeys:[data.stateCode],
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"}	
		}
	callService(stateJson);

	 var districtJson={
			serviceName:"/getData/getDistrictListBhavishya",
			comboId:"districtCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select District"},
			primaryKeys:[data.stateCode, data.districtCode],
		}
	callService(districtJson);
	 
	 var coveredCityList={
				serviceName:"/getData/getCghscityListBhavishya",
				comboId:"PatientCghsCity",			
				callBackFunctionName:"commonPopulateCombo",
				defaultOption:{"optionValue":"","optionText":"Select City"}	,
	 			primaryKeys:[data.cityDesc],
				
			}
		callService(coveredCityList);
	 
	 var adOfficeCity ={
 			serviceName:"/getData/getADCityBasedonsatelliteCityBhavishya",
   			callBackFunctionName:"populatecity",			
   			primaryKeys:[data.cityDesc],
 		}
 		callService(adOfficeCity);
	 

	$('#stateCode').prop('disabled', true);
	$('#districtCode').prop('disabled', true);
//	$('#PatientCghsCity').prop('disabled', true);
//	$('#patadcity').prop('disabled', true);
	
	var orgType={
			serviceName:"/getData/getmainorgtypeBhavishya",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			primaryKeys:[data.org_Type],
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
		}
	callService(orgType);
	
	$('#patdeptpensioner').prop('disabled', true);
	
	var ddoCodeOrg={
			serviceName:"/getData/getOrganisationnamewithddoBhavishya",
			comboId:"patsubdeptpensioner",
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Organisation name (DDO Code)"},
			primaryKeys:[data.ddO_Code]
		}
	callService(ddoCodeOrg);
	//$('#patsubdeptpensioner').prop('disabled', true);
	
	
	var payLevelJson={
			serviceName:"/getData/getpayscaleBhavishya",
			comboId:"patpayscalepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			primaryKeys:[data.payLevel],
			defaultOption:{"optionValue":"","optionText":"Select Payscale"}	
			
		}
	callService(payLevelJson);
	$('#patpayscalepensioner').prop('disabled', true);
	
    var patpayscalevalueSelect ={
			serviceName:"/getData/getpayscalevaluesbhavishya",
			comboId:"patpayscalevaluepensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
			primaryKeys:[data.payLevel, data.lastPay],
		}
	callService(patpayscalevalueSelect);
 //  $('#patpayscalevaluepensioner').prop('disabled', true);
   
   var patscalevalue= $('#patpayscalevaluepensioner').val();
	
//	alert("patscalevalue>>>>>"+patscalevalue);
//	$('#patlastpaypensioner').val(data.lastPay);
	
	$('#Patdorpensioner').val(data.dor);
	adddepinfoBhavishya(data, data.relations);
	
	
	
	
}


function populatecity(configJson, dataJson){
			//  alert("configJson>>> " + JSON.stringify(configJson));
    	
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               var parentcitycodevalue=json["parentcitycode"];
               $('#parentcitycode').val(parentcitycodevalue);
           
               var parentcityname=json["parentcityname"];
          
			     $('#patadcity').val(parentcityname); 
			     
			     
			     var configJson={
    			serviceName:"/getData/getwellnesscenterbasedoncity",
    			comboId:"patientwc",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Wellness center"},
    			primaryKeys:[parentcitycodevalue],
    		}
    	callService(configJson);
	
		
    });
			     
			   
                 
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
		}
		
function adddepinfoBhavishya(mainData, relations) {
	
	var mainchname=mainData.name;
//	alert("name>>>>>"+mainchname);
//	var mainchdob=mainData.dob;
//var mainchdob = "14-11-1964";

// Split the date string by '-'
//var dateParts = mainchdob.split('-');

// Reformat to YYYY-MM-DD
//var formattedDate = dateParts[2] + '-' + dateParts[1] + '-' + dateParts[0];
//console.log(formattedDate); // Output will be "1964-11-14"
//	alert("ddooobbb>>>>>"+mainchdob);
	var mainchgender=mainData.genderCode;
//	alert("mainchgender>>>>>"+mainchgender);
		var mainchphoto=mainData.photograph;
	//alert("mainchphoto>>>>>"+mainchphoto);
	
	
	 var json = {
            "depname": mainchname,
            "dependentRelation": "Self",
            "dependentGender": mainchgender,
            "dependentGenderId": "",
            "dependentRelationId": "1",
            "deppendentDOBadd": mainData.dob,
            "dependentPhoto": "data:image/png;base64," + mainchphoto,
            "dependentdisableTypeid": "N/A",
            "dependentdisableuploaddoc": "" ,
            "dependentdisabilityflag": "",
            "dependentspousecertificatetypeid": "N/A",
            "dependentspousecertificate": "N/A",
            "dependentIdProof": "N/A",
            "dependentIdProofTypeId": "N/A",
            "dependentMarriageTypeId": "N/A",
            "dependentMarriagedoc": "N/A",
            "dependentAgeTypeId": "N/A",
            "dependentAgeDoc": "N/A",
            "dependentIncomeDocTypeId": "N/A",
            "dependentIncomeDoc": "N/A",
            "depdataaddfrombhavisya":"Y"
        };
	  var configJson = {
            serviceName: "/getData/getgendermainch",
            callBackFunctionName: "populategendermainchbhaviya",
            primaryKeys: [mainchgender], // Assuming this is meant to be an array
            bhavishyajson: json
        };
	  callService(configJson);
	  
	  
        
    var genderCombo = document.getElementById("genderMasterForBhavishya");
    let genderMap = {};

    // Populate genderMap from the genderCombo options
    for (let option of genderCombo.options) {
        genderMap[option.value.split('$')[1]] = option.text;
    }

    // Loop through relations and create the required JSON for each
    for (let i = 0; i < relations.length; i++) {
		$('#isdependentaddbhavisya').val("1");
		
		let base64ImagePrefix = 'data:image/png;base64,';

       var dephotobase64="";// Adding the prefix before the base64 data
	
	if (relations[i].photograph != "") {
    dephotobase64 = "data:image/png;base64," + relations[i].photograph;
    // alert("Base64 Photo Data: " + dephotobase64); // More descriptive message
} else {
    dephotobase64 = "";
}


var bavGendtls=getGenderByBavishyaId(relations[i].genderCode);

var bavRelDtls = getRelationByBavishyaId(relations[i].relationWithPensioner);

      var bhavisyarelationcode=relations[i].relationWithPensioner;
    var bhavisyagendercode=relations[i].genderCode;
        
            
	var genId = "0";
	var genname = "NA";
	
	
	
	if(bavGendtls.includes(',')){
		var benArr = bavGendtls.split(',');
		genId = benArr[0].split('$')[0];
		genname =  benArr[1];
	// alert("genderid>>>>>>>>>>"+genId);
	// alert("genname>>>>>>>>>>"+genname);
	}
	

        
        
	var relId = "0";
	var relName = "NA";
	
	if(bavRelDtls.includes(',')){
		var benArr = bavRelDtls.split(',');
		relId = benArr[0].split('$')[0];
		relName =  benArr[1];
		// alert("relationid>>>>>>>>>>"+relId);
			// alert("relationname>>>>>>>>>>"+relName);
	}


        var json = {
            "depname": relations[i].name,
            "dependentRelation": relName,
            "dependentGender": genname,
            "dependentGenderId": genId,
            "dependentRelationId": relId,
            "deppendentDOBadd": relations[i].dob,
             "dependentPhoto": dephotobase64,
              "dependentdisableTypeid": "N/A",
            "dependentdisableuploaddoc": "data:application/pdf;base64," + relations[i].handicapped_Certificate,
            "dependentdisabilityflag": relations[i].handicapped,
            "dependentspousecertificatetypeid": "N/A",
            "dependentspousecertificate": "N/A",
            "dependentIdProof": "N/A",
            "dependentIdProofTypeId": "N/A",
            "dependentMarriageTypeId": "N/A",
            "dependentMarriagedoc": "N/A",
            "dependentAgeTypeId": "N/A",
            "dependentAgeDoc": "N/A",
            "dependentIncomeDocTypeId": "N/A",
            "dependentIncomeDoc": "N/A",
               "depdataaddfrombhavisya":"Y",
               "dependentMaritalStatus" : relations[i].maritalStatus
        };
  
 createDependentRow(json);
  
        
        
    }
}


function getRelationByBavishyaId(bavishyaRelationId){
	//alert("getRelationByBavishyaId");
	
	 const option = $("#patrelationhidden option").filter(function() {
    return $(this).val().endsWith(bavishyaRelationId); // Match the starting part of the value
  });
	
	return option.val()+","+option.text();
}
 
 
 
function getGenderByBavishyaId(bhavisyagendercode){
//	alert("getGenderByBavishyaId");
	 const option = $("#patgenderhidden option").filter(function() {
    return $(this).val().endsWith(bhavisyagendercode); // Match the starting part of the value
  });
	
	return option.val()+","+option.text();
}
 

function populategendermainchbhaviya(configJson, dataJson)
{
//	alert("populategendermainchbhaviya");
  if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        return;
    } else {
        // Check if the response does not contain an error
        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function (_, json) {
                var gendercode = json["gendercode"];
                var gendername = json["gendername"];

                        // alert("gendercode>>>>"+gendercode);
                 //alert("gendercode configjson>>>>>>" + configJson.bhavishyajson.dependentGender);

              configJson.bhavishyajson.dependentGenderId = gendercode;  // Update dependentGender with the selected gendercode
                
                // Alert to verify the update
                //alert("Updated dependentGender >>>>>>" + configJson.bhavishyajson.dependentGender);
                
                // Optionally, you can also update other fields if needed
                // For example, if you want to update other values like gendername:
                configJson.bhavishyajson.dependentGender = gendername;
               // alert("Updated dependentGenderName >>>>>>" + configJson.bhavishyajson.dependentGenderName);
                var configJsonupdated=configJson.bhavishyajson;
              //  alert("configJsonupdated>>>>>>>>>>>"+configJsonupdated);
                createDependentRow(configJsonupdated)
                
                
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }	
}

/*function populategenderbhaviya(configJson, dataJson) {
    // Debugging alerts
    alert("111111111111111111111111");
   // alert("configJson >>>>>>" + JSON.stringify(configJson.bhavishyajson));
    alert("configJson gender>>>>>>" + JSON.stringify(configJson.bhavishyajson.dependentGender));
console.log(JSON.stringify(dataJson));
 alert("dataJson >>>>>>" + JSON.stringify(dataJson));
    // Check if dataJson is available and contains data
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        return;
    } else {
        // Check if the response does not contain an error
        if (dataJson["message"].indexOf("ERROR") < 0) {
            $.each(dataJson["data"], function (_, json) {
                var gendercode = json["gendercode"];
                var gendername = json["gendername"];

         
                
                 alert("gendercode configjson>>>>>>" + configJson.bhavishyajson.dependentGender);

              configJson.bhavishyajson.dependentGenderId = gendercode;  // Update dependentGender with the selected gendercode
                
                // Alert to verify the update
                alert("Updated dependentGender >>>>>>" + configJson.bhavishyajson.dependentGender);
                
                // Optionally, you can also update other fields if needed
                // For example, if you want to update other values like gendername:
                configJson.bhavishyajson.dependentGender = gendername;
                alert("Updated dependentGenderName >>>>>>" + configJson.bhavishyajson.dependentGenderName);
                var configJsonupdated=configJson.bhavishyajson;
                alert("configJsonupdated>>>>>>>>>>>"+configJsonupdated);
                createDependentRow(configJsonupdated)
                
                
            });
        } else {
            showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
            return;
        }
    }
}
*/

/*
function adddepinfoBhavishya(relations) {
	var genderCombo = document.getElementById("genderMasterForBhavishya");
	let genderMap = {};
	for (let option of genderCombo.options) {
        genderMap[option.value.split('$')[1]] = option.text;
    }
	console.log()
	for(let i=0; i<relations.length; i++) {
		
		var json={"depname": relations[i].name,
			     "dependentRelation":relations[i].relationWithPensioner, 
			     "dependentGender":relations[i].genderCode,
			     "dependentGenderId":"N/A",
			      "dependentRelationId":"N/A",
			     "deppendentDOBadd":relations[i].dob,
			     "dependentPhoto":"data:image/png;base64,"+relations[i].photograph,
			     "dependentdisableTypeid":"N/A",
			     "dependentdisableuploaddoc":"data:application/pdf;base64,"+relations[i].handicapped_Certificate,
			     "dependentdisabilityflag":relations[i].handicapped,
			     "dependentspousecertificatetypeid":"N/A",
			     "dependentspousecertificate":"N/A",
			     "dependentIdProof":"N/A",
			     "dependentIdProofTypeId":"N/A",
			     "dependentMarriageTypeId":"N/A",
			     "dependentMarriagedoc":"N/A",
			      "dependentAgeTypeId":"N/A",
			      "dependentAgeDoc":"N/A",
			      "dependentIncomeDocTypeId":"N/A",
			       "dependentIncomeDoc":"N/A"
			     } 
			     // createDependentRow(json);
			      
			      
		var configJson={
    		serviceName:"/getData/getGenderListBhavishya",
      			callBackFunctionName:"populategenderbhaviya",			
        		primaryKeys:[gendercodebhavisya],
        		bhavishyajson:json
        		    		}
    	callService(configJson);
		
		
		
	}
}


	function populategenderbhaviya(configJson, dataJson)
    {
	 //  alert("configJson>>> " + JSON.stringify(configJson.bhavishyajson));
	 
	 alert("111111111111111111111111");
       alert("configjson>>>>>>>>"+configJson.bhavishyajson);

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
                            
                var gendercode=json["gendercode"];
                var gendername=json["gendername"];
                alert("gendercode>>>>>>>>>>"+gendercode);
                  
               
			    $('#genderbhaviysacodehidden').val(json["gendercode"]);
			     $('#genderbhaviysanamehidden').val(json["gendername"]);
			     
			     var depgenderid=$('#genderbhaviysacodehidden').val();
    				var depgendername=$('#genderbhaviysanamehidden').val();
    				
    				alert("---------------"+depgenderid);
			     alert("=============="+depgendername);
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}	*/