
$(document).ready(function () {
	 

    // Set the callback to run when the Google Charts library is loaded
 
	var cardtypevalue="";
	
var configJson={
			serviceName:"/getData/getmaincardtype",
			comboId:"maincardtype",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Card Type"}	
			
		}
	callService(configJson);

$('#maincardtype').change(function(){
	//alert("maincardtype"+($('#maincardtype').val()));
    	
    	
    	
    	if($('#maincardtype').val()=='S'){
    		$('#cardtypevaluehidden').val('S');
    		 $('#deptinfoserving').show();
		  $('#Nomineeinfo').hide();
		   $('#undertakingbtnserving').show();
		  	 $('#deptinfopensioner').hide();
		 	initPageserving();
		 	
		    $('#formTitle').addClass("bg-primary text-primary").html("Application for Serving CGHS Card");
    		
    	}
    	else if($('#maincardtype').val()=='P')
    		{
    	
    		$('#cardtypevaluehidden').val('P');
    		 $('#deptinfopensioner').show();
		    $('#Nomineeinfo').show();
		     $('#deptinfoserving').hide();
		 
		 initPagepensioner();
		 $('#formTitle').addClass("bg-success text-success").html("Application for Pensioner CGHS Card");
    		
    	
    		}else{
				
				
				  $('#deptinfopensioner').show();
		    $('#Nomineeinfo').show();
		      $('#deptinfoserving').hide();
		// alert("gghghghghgh"+cardtypevalue);
		 initPagepensioner();
		 $('#formTitle').addClass("bg-info text-info").html("Superannuate Application for Pensioner CGHS Card")
			}
    	
    });
	
	
	
	/*var cardtypevalue=$('#maincardtype').val();
	alert("cardtypevalue>>>>>>"+cardtypevalue);*/
	
	 var nowDate = new Date();
    var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
	let maximumDate=0
	let minimumDate=-36500
//	alert(cardtypevalue);
	 if(cardtypevalue=='S')
	 {
		 $('#deptinfoserving').show();
		  $('#Nomineeinfo').hide();
		   $('#undertakingbtnserving').show();
		  
		 	initPageserving();
		 	
		    $('#formTitle').addClass("bg-primary text-primary").html("Application for Serving CGHS Card");
		  //  maximumDate=calculateDaysFromTodayToYears(18)
		  //  minimumDate=calculateDaysFromTodayToYears(60);
	 }
	 else if(cardtypevalue=='P'){
		 
		  $('#deptinfopensioner').show();
		    $('#Nomineeinfo').show();
		 
		 initPagepensioner();
		 $('#formTitle').addClass("bg-success text-success").html("Application for Pensioner CGHS Card");
		// maximumDate=calculateDaysFromTodayToYears(60);
		// minimumDate=calculateDaysFromTodayToYears(99);	
	 }
	 else if(cardtypevalue=='SA'){
		   $('#deptinfopensioner').show();
		    $('#Nomineeinfo').show();
		// alert("gghghghghgh"+cardtypevalue);
		 initPagepensioner();
		 $('#formTitle').addClass("bg-info text-info").html("Superannuate Application for Pensioner CGHS Card")
		// maximumDate=calculateDaysFromTodayToYears(59)-182;	// 6 months days	 
		// minimumDate=calculateDaysFromTodayToYears(59)+1;	 
		 
	 }
	// maximumDate=maximumDate-(maximumDate*2); // for getting days in minus
	// minimumDate=minimumDate-(minimumDate*2);// for getting days in minus
	/* $('#patDOB').datepicker({ 
	  minDate: new Date(),         // Prevents selecting a date before today
             maxDate: '+1Y',   
		   "dateFormat": "dd-mm-yy",   
	    	changeMonth: true, changeYear: true ,
	    	showButtonPanel: true,  showOtherMonths: true,	    	
	    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
	    	onSelect: function (date, datepicker) {
	    		validateFormData($('#patDOB'));
	        }
	  });*/



      $("#patDOB").datepicker({
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

	
	var configJson={
			serviceName:"/getData/getstatelistbasedonCardType",
			comboId:"stateCode",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select State"},
			primaryKeys:[cardtypevalue],
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
    			primaryKeys:[$('#stateCode').val(),cardtypevalue],
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
   $("#depDOB").datepicker({ 
	   //minDate:new Date , 
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
	
		/*var nowDate = new Date();
	var today = new Date(nowDate.getFullYear(), nowDate.getMonth(), nowDate.getDate(), 0, 0, 0, 0);
$("#depDOB").datepicker({
    dateFormat: "dd-mm-yy", // Date format: day-month-year
    changeMonth: true,      // Allows month change
    changeYear: true,       // Allows year change
    showButtonPanel: true,  // Adds a button panel at the bottom (for clear, today buttons)
    showOtherMonths: true,  // Shows days from other months in the calendar
    selectOtherMonths: true, // Allows selecting days from other months
 yearRange: "-200:+0",		 // Allows all years from -9999 to +9999 (practically no restriction)
    	maxDate: new Date,
    onSelect: function (date, datepicker) {
        // Custom actions when a date is selected (optional)
        

    }
});
*/
 
    // Initialize datepicker
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
		  $("#incomestatusdoctype").show();
		    $("#fileuploadIncomestatus").show();
		  
	  }else{
		 	  $('#DepPAN').hide(); 
	  }
	  if(age>25 && deprelation==5 )
	  {
		  alert("Son age not greater than 25");
		 $('#depgender').prop('disabled', true); // Disable all other inputs
          return;  // Stop fur
	  }else if(age>25 && deprelation==28 )
    {
	alert("Adopted Son age not greater than 25");
		 $('#depgender').prop('disabled', true);
		  return;  
	}else  if(age>18 && deprelation==22)
	{
		alert(" Minor Brother age not greater than 18");
		 $('#depgender').prop('disabled', true);
		  return; 
	}else  if(age>18 && deprelation==32)
	{
	alert("Minor Daughter of Separated/Widowed/Divorced Daughter age not greater than 18");
		 $('#depgender').prop('disabled', true);
		  return; 	
	}else  if(age>18 && deprelation==33)
	{
		alert("Minor Son of Separated/Widowed/Divorced Daughter age not greater than 18");
		 $('#depgender').prop('disabled', true);
	}
		
	else{
		 $('#depgender').prop('disabled', false);
	}
  }
});

	//alert("gender");
	  var configJson={
			serviceName:"/getData/getDependentRelation",
			comboId:"depentrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
	callService(configJson);
	
	
$('#depentrelation').change(function(){

	var configJson={
    			serviceName:"/getData/getgenderbaseonrelation",
      			callBackFunctionName:"populategender",			
        		primaryKeys:[$('#depentrelation').val()],
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
    			comboId:"adoptiondoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[100],
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
		$('#generateBtn').click(OTPFn);
	$('#validateBtn').click(OTPVerifyFn);
	$('#resendBtn').click(sendOTP);
});

	 
    function populategender(configJson, dataJson)
    {
 			$('#depageprooftype').hide();
			$('#fileuploadageproof').hide();
			$('#fileuploaddisablecertificate').hide();
			$('#disabledoctype').hide();  
			$('#isdisablityvaluehidden').val("0");	
			$('#fileuploadspousecertificate').hide();
			$('#spousedoctype').hide();
			 $('#depmarprooftype').hide();
		      $('#fileuploadmarriagedoc').hide();
		       $('#adoptionprooftype').hide();
					     $('#fileuploadAdoption').hide();
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
					
						var relationidvalue=json["relationid"];
	              if(relationidvalue=='15' || relationidvalue=='16' || relationidvalue=='22' || relationidvalue=='5'){  //15	"GRAND SON"  ,22 "MINOR BROTHER",16	"GRAND DAUGTHER",5 son
				    $('#depageprooftype').show();
				    $('#fileuploadageproof').show();
				  }
			 //Divorced/Separated  Daughter (Dependant and Unmarried)--20
			// Divorced/Separated Sister (Dependant and Unmarried)--21
				 if(relationidvalue=='20' || relationidvalue=='21' ||  relationidvalue=='30' || relationidvalue=='31' )
				    {    
						//alert("relationvalue"+relationidvalue);
						  //DIVORCED/WIDOWED DEPENDENT DAUGHTER code 20  or 21 for DIVORCED/ WIDOWED DEPENDENT SISTER)
					    $('#depmarprooftype').show();
					     $('#fileuploadmarriagedoc').show();
					   
				   }
	                if(relationidvalue=='28' || relationidvalue=='29')
				    {    
						//alert("relationvalue"+relationidvalue);
						  //DIVORCED/WIDOWED DEPENDENT DAUGHTER code 20  or 21 for DIVORCED/ WIDOWED DEPENDENT SISTER)
					    $('#adoptionprooftype').show();
					     $('#fileuploadAdoption').show();
					   
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
				   
				     $('#dialogOverlay').show();
				 
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
		
		
/*		document.getElementById('myCheckbox').addEventListener('click', function() {
  var checkbox = document.getElementById('myCheckbox');
  if (checkbox.checked) {
    console.log('Checkbox is checked, value:', checkbox.value);
  } else {
    console.log('Checkbox is unchecked');
  }
});*/
		function populategendernominee(configJson, dataJson)
    {
	   //alert("configJson>>> " + JSON.stringify(configJson));
    

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
	   //alert("configJson>>> " + JSON.stringify(configJson));
    

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
	


		const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-mm-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });

	
	$("#patDeputationenddate").datepicker({ minDate:new Date , 
	//maxDate: maximumDate,    
	"dateFormat": "dd-mm-yy",   
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
	
	//alert("6556565");
	 var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
    	$('#patsubdeptserving').change(function(){
    	
    	if($('#patsubdeptserving').val()=="")
    	{
    		$('#patdeptserving').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
    	  var input=$('#patsubdeptserving').val()
    	 
           const parts = input.split('$');

          const orgtypeid = parts[0]; // "16"
            const ddocode = parts[1]; // "122"

//alert(orgtypeid); // Outputs: 16
//alert(ddocode); // Outputs: 12
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdeptserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    	callService(configJson);
    });
	
/*	
	  var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
			
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
	
	
	
	*/
	
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
	
	/*
	 $('#patsubcardtypeserving').change(function(){
		 
		 var valueofsubcategory=$('#patsubcardtypeserving').val();
		 //16--journlist 18--serving auto
		if (valueofsubcategory==16)
    	{
			//alert(valueofsubcategory);
			 $('#patpayscaleserving').prop('disabled', true);
			  $('#patpayscalevalueserving').prop('disabled', true);
			   $('#patBasicpayserving').prop('disabled', true);
			   var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"2","optionText":"Select Payscale"},
    			primaryKeys:[2],
    		}
    	callService(configJson);
			 
			    var configJson={
    			serviceName:"/getData/getcardvalidity",
    			comboId:"patCardApplyValidity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"1","optionText":"Select Card Validity"},
    			
    		}
    	callService(configJson);
		}else{
			 $('#patpayscaleserving').prop('disabled', false);
			  $('#patpayscalevalueserving').prop('disabled', false);
			   $('#patBasicpayserving').prop('disabled', false);
			    var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementserving",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			
    		}
    	callService(configJson);
			   		
		
		}
		
  });
	*/
	
	

	
	  var configJson={
			serviceName:"/getData/getpayscale",
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
	
			const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-mm-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		//var id= $(datepicker).attr("id");
    		//$('#'+id).trigger('blur');
    		
        }
    });

   
     
    
    
      $("#Patdorpensioner").datepicker({
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
    
    
var configJson={
    			serviceName:"/getData/getdocsubtype",
    			comboId:"patppodoctypeid",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select document"},
    			primaryKeys:[40],
    		}
    	callService(configJson);
	
	//alert($('#patppodoctypeid').val());
	
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
			defaultOption:{"optionValue":"","optionText":""},
			primaryKeys:["P"],
			
		}
	callService(configJson);
	
	
	}else{
		 var configJson={
			serviceName:"/getData/getmaincardcategory",
			comboId:"patcardtypecategorypen",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Card Category "},
			primaryKeys:[$('#cardtypevaluehidden').val()],
			
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
			serviceName:"/getData/getpayscale",
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
    	var configJson={
    			serviceName:"/getData/getpayscalevalues",
    			comboId:"patpayscalevaluepensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			primaryKeys:[$('#patpayscalepensioner').val()],
    		}
    	callService(configJson);
    });
    
    
    $('#patsubcardtypepensioner').change(function(){
    	
    	var valuesubcategory=$('#patsubcardtypepensioner').val();
   // alert("valuesubcategory>>>>"+valuesubcategory);
    if (valuesubcategory==21)
    	{
			//alert(valueofcategory);
			 $('#patpayscalepensioner').prop('disabled', true);
			  $('#patpayscalevaluepensioner').prop('disabled', true);
			   $('#patBasicpayPensioner').prop('disabled', true);
			   
			   
			   
			   var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpayDept",
    			comboId:"patentitlementpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    			
    		}
    	callService(configJson);
			 
			    var configJson={
    			serviceName:"/getData/getcardvalidity",
    			comboId:"patCardApplyValidity",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"1","optionText":"Select Card Validity"},
    			
    		}
    	callService(configJson);
		}else{
			 $('#patpayscalepensioner').prop('disabled', false);
			  $('#patpayscalevaluepensioner').prop('disabled', false);
			   $('#patBasicpayPensioner').prop('disabled', false);
		}
       var configJson={
    			serviceName:"/getData/getEntitlementbasedonbasicpay",
    			comboId:"patentitlementpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Payscale"},
    		
    		}
    	callService(configJson);
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
	// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
	 var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			
    		}
    	callService(configJson);
    	
    	$('#patsubdeptpensioner').change(function(){
    	
    	if($('#patsubdeptpensioner').val()=="")
    	{
    		$('#patdeptpensioner').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	// alert("7jdhjhdjhdjhjd"+$('#patsubdeptpensioner').val());
    	  var input=$('#patsubdeptpensioner').val()
    	 
           const parts = input.split('$');

          const orgtypeid = parts[0]; // "16"
            const ddocode = parts[1]; // "122"

//alert(orgtypeid); // Outputs: 16
//alert(ddocode); // Outputs: 12
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patdeptpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[orgtypeid],
    		}
    	callService(configJson);
    });
	 /* var configJson={
			serviceName:"/getData/getmainorgtype",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select OrganisationType"}	
			
		}
	callService(configJson);

	
	 $('#patdeptpensioner').change(function(){
    	
    	if($('#patdeptpensioner').val()=="")
    	{
    		$('#patsubdeptpensioner').html("<option value=''>Select Organisation Name</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getOrganisationnamewithddo",
    			comboId:"patsubdeptpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organisation name"},
    			primaryKeys:[$('#patdeptpensioner').val()],
    		}
    	callService(configJson);
    });*/
	
	 /* var configJson={
			serviceName:"/getData/getmainservicedept",
			comboId:"patdeptpensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Department"}	
			
		}
	callService(configJson);
	
	 $('#patdeptpensioner').change(function(){
    	
    	if($('#patdeptpensioner').val()=="")
    	{
    		$('#patsubdeptpensioner').html("<option value=''>Select subdepartment</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getSubServiceDepartment",
    			comboId:"patsubdeptpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Sub Department"},
    			primaryKeys:[$('#patdeptpensioner').val()],
    		}
    	callService(configJson);
    });
	*/
/*		 $('#patsubdeptpensioner').change(function(){
    	
    	if($('#patsubdeptpensioner').val()=="")
    	{
    		$('#patorgpensioner').html("<option value=''>Select Organization</option>");
    		return;    		
    	}
    	var configJson={
    			serviceName:"/getData/getmainorgtype",
    			comboId:"patorgpensioner",			
    			callBackFunctionName:"commonPopulateCombo",
    			defaultOption:{"optionValue":"","optionText":"Select Organization"},
    			primaryKeys:[$('#patsubdeptpensioner').val()],
    		}
    	callService(configJson);
    	
    	
    	
    	
    });
	*/
/*	 $('#patsubdeptpensioner').change(function(){
	
	var configJson={
    			serviceName:"/getData/getdeptonlineflag",
    			callBackFunctionName:"Populatedeptonline",
       			primaryKeys:[$('#patsubdeptpensioner').val()],
    		}
    	callService(configJson);
	});
	*/
	
	
	
		  var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"patfmapensioner",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select FMA"}	
			
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
    			primaryKeys:[$('#patfmapensioner').val()],
    		}
    	callService(configJson);
    });
	  
    $('#BTNCLEAR').click(resetPage);
  
  
}


		

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
        serviceName: "/DMLSAVE/saveBenData",
        callBackFunctionName: "callbackSaveData",
        	fileUploadFlag:"0",	
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

	
function callbackSaveData(configJson, dataJson){
	//alert("configJson>>>>"+JSON.stringify(configJson));
	
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	
		
			}
}
function resetPage(){
	
 submitFormMaster("DAVerify","add");
	//parent.closeModal();	
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
	if(ValidateForAllVisible("ENTRYFORM")==false)
	return;*/
/*	if($("#fileContent2").val()==''){
		
		$("#DepPhotoIdFeedBack").html("Please Select a Photo");
		return;
	}*/
  const depnameadd = document.getElementById('depname').value;
    
   const depentrelationadd= $( "#depentrelation option:selected" ).text();
   const depentrelationaddID= $( "#depentrelation option:selected" ).val();
  const depDOBadd = document.getElementById('depDOB').value;
  
  const depgenderadd=$( "#depgender option:selected" ).text();
  const depgenderaddID=$( "#depgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#depBloodGroup option:selected" ).text();

    const imgSrc = $("#fileContent2").val();
   const depmobileadd=document.getElementById('depmobile').value;  
     const disabilityflag=$('#isdisablityvaluehidden').val();
     
   
    
    
     const mainchdob = $('#patDOB').val();
	  	 
		 const mainchage = calculateAge(mainchdob);
		// alert(mainchage);
		
	  	 const dependentdob = $('#depDOB').val();
	  	
		 const depage = calculateAge(dependentdob);
	
				
				const dependentidproofdoc=$('#filename20').val();
				var dependentIdProofdoctypeidvalue=$("#depidproofdoctypeid option:selected").val();
				var Dependentidproofdoctypename=$("#depidproofdoctypeid option:selected").text();
			//	alert(dependentIdProofdoctypeidvalue);
						
				var dependentspousecertificatetypeidvalue=$("#depspousedoctypeid option:selected" ).val();
		        const dependentspousecertificate=$('#filename14').val();
		       const dependentspousecertificatename=$("#depspousedoctypeid option:selected" ).text();
		       
		//alert(Dependentidproofdoctypename);
				
					var dependentMarriageTypeidvalue=$("#depmardoctypeid option:selected").val();//marriagedoc document type id
					var dependentMarriageDocname=$("#depmardoctypeid option:selected").text();//marriage document doc name
					var dependentMarriagedoc=$("#filename25").val();//marriage doc document
					
						
						var dependentAgeTypeid=$("#depagedoctypeid option:selected").val();
						var dependentAgedoc=$("#filename24").val();
						var dependentAgeDocname=$("#depagedoctypeid option:selected").text();
						
						
						
						var dependentdisableTypeid=$("#depdisdoctypeid option:selected").val();
						var dependentdisableDocName=$("#depdisdoctypeid option:selected").text();
						 const fileuploadvalue=$('#filename11').val();//disability doc
						
	
	            var dependentincomestatusdoctypeidvalue=$("#depincomestatusdoctypeid option:selected").val(); 
            	var dependentincomestatusuploaddoc=$("#filename26").val();
	            var dependentincomestatusdocname=$("#depincomestatusdoctypeid option:selected").text(); 
	            
	            var dependentadoptiondoctypeid=$("#adoptiondoctypeid option:selected").val(); 
                 var dependentadoptiondocname=$("#filename30").val(); 
					if(depage>25 && depentrelationaddID=='5' ){
								showMsg("You Can not add Dependent Son's Age is gretaer than 25","");
			
								return;
					}
					if(depage>25 && depentrelationaddID=='28' ){
								showMsg("You Can not add Adopted Son's Age is gretaer than 25","");
			
								return;
					}
			    if(depage>18 && depentrelationaddID=='7'){
					showMsg("you can not add Dependent Brother's Age is gretaer than 18 ","");
						
						return;
					}
					
					  if(depage>18 && depentrelationaddID=='32'){
					showMsg("you can not add Dependent Minor Daughter's Age is gretaer than 18 ","");
						
						return;
					}
					  if(depage>18 && depentrelationaddID=='33'){
					showMsg("you can not add Dependent  Minor Son's Age is gretaer than 18 ","");
						
						return;
					}
					
							const depundertakingpannotavailble=$('#filename29').val();
		//alert("depundertakingpannotavailble>"+depundertakingpannotavailble);

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
       "dependentidproofdoctypename":Dependentidproofdoctypename,
       "dependentincomestatusdocname":dependentincomestatusdocname,
       "dependentdisableDocName":dependentdisableDocName,
       "dependentAgeDocname":dependentAgeDocname,
       "dependentMarriageDocname":dependentMarriageDocname,
        "dependentpannotavailbleundertaking":depundertakingpannotavailble,
       "depmobile":depmobileadd,
       "depadopiontypeid":dependentadoptiondoctypeid,
       "depadopiontypedocname":dependentadoptiondocname
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
    // Reset the image input (if it's a file input field)
    document.getElementById('fileContent2').value = ""; // Reset image field

    // Reset file upload fields (if they're file input fields)
    document.getElementById('filename11').value = "";  // Reset first file upload
    document.getElementById('filename14').value = "";  // Reset second file upload
    document.getElementById('filename20').value = "";  // Reset ID proof field
     document.getElementById('preview2').value = ""; 
      document.getElementById('filename24').value = "";
      document.getElementById('filename25').value = "";
     $('#preview2').attr("src" ,"").hide();
    removeFileWithoutView("20","mandatory","CARDDOCUMENT");
    removeFileWithoutView("14","mandatory","CARDDOCUMENT");
    removeFileWithoutView("11","mandatory","CARDDOCUMENT");
      removeFileWithoutView("24","mandatory","CARDDOCUMENT");
     removeFileWithoutView("25","mandatory","CARDDOCUMENT");
     removeFileWithoutView("29","mandatory","CARDDOCUMENT");

    // If you have an <img> tag to display the selected image, you can reset its `src` attribute like this:
 //   document.getElementById('preview2').src = "";  // Replace 'imgPreview' with your actual img tag id if needed
   
}
function createDependentRow(json){
	
	   
	           var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	         //var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +residenceproof + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + residenceproof + "</a>";
	var deprelationvalue=json["dependentRelation"];
	
	 var html ="<tr id=''>";
     html +="<td class='slno'></td>";
     html +="<td>" + json["depname"]+"</td>";
     html +="<td>" + json["deppendentDOBadd"] +"</td>";
     html +="<td>" +  json["dependentGender"]  +"</td>";
     html +="<td>" + json["dependentRelation"] +"</td>";
     /*html +="<td>" + json["dependentBloodGroupadd"]+"</td>";*/
     html +="<td><img src='"+json["dependentPhoto"] +"' style='width:100px;height:100px'>" ;
/*     html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=fileTempDownload&fileName=" + json["dependentIdProof"] + "&folderName=CARDDOCUMENT'>" + json["dependentIdProof"] + "</a></td>";
*/    /* html +="<td>" + json["dependentdisabilityflag"] +"</td>";*/
    
    
// File upload document links, only display if the document name is not null
html += "<td>";
if (json["dependentIdProof"]) {
    html += "<span>" + json["dependentidproofdoctypename"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentIdProof"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentIdProof"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentspousecertificate"]) {
    html += "<span>Joint Declaration</span>";  // Properly closed the <span> tag
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentspousecertificate"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentspousecertificate"].split('_').slice(1).join('_') + "</a><br>";
}



if (json["dependentIncomeDoc"]) {
    html += "<span>" + json["dependentincomestatusdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentIncomeDoc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentIncomeDoc"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentdisableuploaddoc"]) {
    html += "<span>" + json["dependentdisableDocName"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentdisableuploaddoc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentdisableuploaddoc"].split('_').slice(1).join('_') + "</a><br>";
}


if (json["dependentAgeDoc"]) {
    html += "<span>" + json["dependentAgeDocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentAgeDoc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentAgeDoc"].split('_').slice(1).join('_') + "</a><br>";
}


if (json["dependentMarriagedoc"]) {
    html += "<span>" + json["dependentMarriageDocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentMarriagedoc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+ "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentAgeDoc"].split('_').slice(1).join('_') + "</a><br>";
}




html += "</td>";
     if (deprelationvalue === 'Self') {
        html += "<td><button class='deleteBtn' style='display:none;'>Delete</button></td>";
    } else {
        html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";
    }
     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#dependenttable tbody').append(html);
     
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
	/*
if(ValidateForAllVisible("ENTRYFORM")==false)
	return;*/
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
	
/*	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;*/
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
	$("#dependenttable tbody" ).empty();
var checkbox =document.getElementById('customCheck12');
 if (checkbox.checked) {
		
	 if(ValidateForAllVisible("perinfo")==false){
			 alert("Plese Enter Main CardHolder's Personal Information First"); 
			 checkbox.checked=false;
			 window.scroll({
				 top: 0, 
				 left: 0, 
				 behavior: 'smooth' 
				});
			 return;
		 }
	
	      $('#dependentinfo').show();
		 	 $('#isdependentadd').val("1");
		 	  
		 	
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
	    "dependentidproofdoctypename": $( "#mainchdoctypeid option:selected" ).text(),   
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":"",
	     "dependentpannotavailbleundertaking":"",
       "depmobile":$("#patMobileNo").val()
	        
	     } 
	 createDependentRow(json);
	 
	 	 
	 }
	 else{
		  /* $('#BTNSAVEFINISH2').show();
		  $('#BTNNEXT3').hide();
		  $('#BTNPreviewDependent').show();*/
		   $('#dependentinfo').hide();
		   $('#isdependentadd').val("0");
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
	    "dependentidproofdoctypename": $( "#mainchdoctypeid option:selected" ).text(),   
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":"",
	     "dependentpannotavailbleundertaking":"",
       "depmobile":$("#patMobileNo").val()
	        
	     } 
	// createDependentRow(json);
	 
	 }

}
  
  function showdependentserving()
{
	
$("#dependenttable tbody" ).empty();
	    
var checkbox =document.getElementById('chkDependent1');
 if (checkbox.checked) {
	  if(ValidateForAllVisible("perinfo")==false){
			 alert("Plese Eneter Main CardHolder's Personal Information First"); 
			 checkbox.checked=false;
			 window.scroll({
				 top: 0, 
				 left: 0, 
				 behavior: 'smooth' 
				});
			 return;
		 }
	 $('#dependentinfo').show();
		 	 $('#isdependentadd').val("1");
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
	    "dependentidproofdoctypename": $( "#mainchdoctypeid option:selected" ).text(),   
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":"",
	     "dependentpannotavailbleundertaking":"",
       "depmobile":$("#patMobileNo").val()
	        
	     } 
	 createDependentRow(json);
	
	$('#isdependentadd').val("1");
	 	 
	 }
	 else{
		
		  /* $('#BTNPreviewDept').show();
		
		  $('#BTNNEXT2').hide();*/
		     $('#dependentinfo').hide();
		  $('#isdependentadd').val("0");
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
	    "dependentidproofdoctypename": $( "#mainchdoctypeid option:selected" ).text(),   
      "dependentdisableTypeid":"",
        "dependentspousecertificatetypeid":"",
       "dependentIdProofTypeId":  $("#mainchdoctypeid option:selected").val(),
     "dependentMarriageTypeId":"",
     "dependentMarriagedoc":"",
      "dependentAgeType":"",
      "dependentAgeDoc":"",
	    "dependentIncomeDocTypeId":"",
       "dependentIncomeDoc":"",
	     "dependentpannotavailbleundertaking":"",
       "depmobile":$("#patMobileNo").val()
	        
	     } 
//	 createDependentRow(json);
	 }

}
  
  
        function uploaddeclartion()
        {
			
     var checkboxPAN =document.getElementById('checkBoxPAN');
     alert("checkboxPAN>>>>"+checkboxPAN);
	  if (checkboxPAN.checked) {
			$("#DepPAN").hide();
			$("#fileuploadPANNotavailble").show();
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
if(ValidateForAllVisible("ENTRYFORM")==false)
	return;
	    
          
var cardtypevalue=$('#cardtypevaluehidden').val();


if (cardtypevalue === 'P' || cardtypevalue === 'SA'){
	$('#dependentinfo').show();
	$('#deptinfopensioner').hide();
	$('#BTNPreviewDependent').hide();
	//$('#BTNUNDERTAKINGServing').hide();
	
}
else{
	$('#dependentinfo').show();
	$('#deptinfoserving').hide();
	$('#BTNNEXT4').hide();
	$('#BTNPreviewDependent').show();	
	//	$('#BTNUNDERTAKINGServing').show();
}
		
  jsonWizzard["activeStepNo"]="3";
  createWizard(jsonWizzard);	
}

	
  
  function UnderTakingServing()
  {
	/*  if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	 
	 if(ValidateForAllVisible("ENTRYFORM")==false){
		return;
	}*/
	
	  var isdepvalue= $('#isdependentadd').val();
	 //  var isdepvalue= $('#isdependentadd').val();
	    var patname= $('#patName').val();
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
				 
	 	if(isdepvalue=='1'){
		  $('#cghsundertakingwithdependent').show();
		  $('#deptinfoserving').hide();	 
		    $('#perinfo').hide();
				    $('#dependentinfo').hide();
				      $('#selectmaincardtype').hide();
		    
		 
	  }else{
		   var patname= $('#patName').val();
		   $("#mainchnamewithotdep").text(patname);
		  		   $('#cghsundertakingwithOutdependent').show();	
		    $('#deptinfoserving').hide();	
		      $('#perinfo').hide();
		        $('#selectmaincardtype').hide();
		      
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
		  createDependentRow(json);       
		   
	  }	 
	  
  }
	  
  
  function UnderTaking()
  {
	  
	  if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	 
	  if(ValidateForAllVisible("ENTRYFORM")==false){
		return;
	}
	 
	   $('#spousecondn').hide();
	     $('#daughtersister').hide();
	       $('#parentinlaw').hide();
	  //  alert("iiinn UnderTaking");
	    var isdepvalue= $('#isdependentadd').val();
	    var patname= $('#patName').val();
	 
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
	if(isdepvalue=='1'){
		
		  $('#deptinfopensioner').hide();
		   $('#perinfo').hide();
		  
		  $('#cghsundertakingwithdependent').show();
		  $('#Nomineeinfo').hide();	 
	    $('#dependentinfo').hide();
	     $('#selectmaincardtype').hide();	
	  
	 
	  }
	  
	  
	  else{
		  
				  var patname= $('#patName').val();
	  $('#deptinfopensioner').hide();
		   $('#perinfo').hide();
	       $("#mainchnamewithotdep").text(patname);
		   $('#cghsundertakingwithOutdependent').show();	
		    $('#Nomineeinfo').hide();
		      $('#dependentinfo').hide();	
		      
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
		  createDependentRow(json); 
	  }

		
  jsonWizzard["activeStepNo"]="4";
  createWizard(jsonWizzard);	
}
	  
   
 
  
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
	  $('#addnaltomineehidden').val("1");	 
	  	 $('#alternamenominee').show();
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

  function Previewform() 
  {
  if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	  	 /*if($('#patpayscalepensioner').is(":visible")){
		$('#patpayscalepensioner').hide();	
	}
	
	 	 if($('#patpayscalevaluepensioner').is(":visible")){
		$('#patpayscalevaluepensioner').hide();	
	}
	 if($('#patBasicpayPensioner').is(":visible")){
		$('#patBasicpayPensioner').hide();	
	}*/
			 
	  	   
	    // Primary nominee details
   if (ValidateForAllVisible("ENTRYFORM") === false) {
      return;
  }
    
          var isdepvalue= $('#isdependentadd').val();
        //  alert("isdepvalue>>>>>>>>>>>"+isdepvalue);   
          
          
          if(isdepvalue==0)
          {
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
		  createDependentRow(json); 
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
			     			  
// File upload document links, only display if the document name is not null
html += "<td>";
if (json["dependentIdProof"]) {
    html += "<span>" + json["dependentidproofdoctypename"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentIdProof"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentIdProof"].split('_').slice(1).join('_') + "</a><br>";
}

if (json["dependentspousecertificate"]) {
         html += "<span>Joint Declaration</span>";  // Properly closed the <span> tag
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentspousecertificate"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentspousecertificate"].split('_').slice(1).join('_') + "</a><br>";
}


if (json["dependentIncomeDoc"]) {
    html += "<span>" + json["dependentincomestatusdocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentIncomeDoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentIncomeDoc"].split('_').slice(1).join('_') + "</a><br>";
}



if (json["dependentdisableuploaddoc"]) {
    html += "<span>" + json["dependentdisableDocName"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentdisableuploaddoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentdisableuploaddoc"].split('_').slice(1).join('_') + "</a><br>";
}


if (json["dependentAgeDoc"]) {
    html += "<span>" + json["dependentAgeDocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentAgeDoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentAgeDoc"].split('_').slice(1).join('_') + "</a><br>";
}


if (json["dependentMarriagedoc"]) {
    html += "<span>" + json["dependentMarriageDocname"] + "</span>";
    html += "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentMarriagedoc"] + "&folderName=CARDDOCUMENT' style='margin-left: 10px;'>" + json["dependentAgeDoc"].split('_').slice(1).join('_') + "</a><br>";
}

html += "</td>";
			  
			     html +="</tr>";
			    $("#AutoNumber1 tbody").append(html); 
						 	
			    indx++;
			  
		  });
          
	       var residenceproof=$('#filename13').val();
	      var ppo=$('#filename12').val();
	       var payslip=$('#filename35').val();
	       
	           var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	         var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +residenceproof + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + residenceproof + "</a>";
          $('#imagetest').html(url1);
      /*    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +residenceproof + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + residenceproof + "</a>";
             $('#imagetest').html(url1);*/
 
        var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +ppo + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + ppo + "</a>";
           $('#imagetest1').html(url2);
 
 
      var url3 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +payslip + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + payslip + "</a>";
           $('#imagetest2').html(url3);
 
	    var cardtypevalue=$('#cardtypevaluehidden').val();
	    var name = $("#patName").val();
           $("#dialogName").text(name);
           
           var mainname = $("#patName").val();
           $("#dialogNamemain").text(mainname);
                      
           var email=$("#patEmail").val();
           $("#dialogemail").text(email);
           
            var mob=$("#patMobileNo").val();
            $("#hiddenpatmobile").val(mob);
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
           $("#dialogpincodedepon").text(patpincode);
           
            //alert("isdepvalue"+isdepvalue);
         
        	if (cardtypevalue === 'P' || cardtypevalue === 'SA'){	// Card type Pensioner and superannuatio=ng
        //	alert("cardcategory>>>>>"+$("#patcardtypepensioner option:selected").text());
			   $("#dialogcardtype").html($("#patcardtypepensioner option:selected").text())
            $("#dialogsubcardtype").html($("#patsubcardtypepensioner option:selected").text())
         
         
           $("#dialogdateofret").text($("#Patdorpensioner").val());
             $("#dialogcardvalidity").html($("#patCardApplyValidity option:selected").text())
        
        $("#mainchnameform").text(mainname);
         
         
         $("#diagogpayscale").html($("#patpayscalepensioner option:selected").text())
       
		 
		  $("#dialogdept").html($( "#patdeptpensioner option:selected" ).text())
		   var ofcaddress=$("#patofcadrpensioner").val();
           $("#dialogofcadress").text(ofcaddress);
             $("#dialogpayscale").html($( "#patpayscalepensioner option:selected" ).text())
         
               var plastpay=$("#patpayscalevaluepensioner option:selected").text();
           $("#dialogpreslastpay").html(plastpay);
           
           
           //   $("#dialogdesignation").html($( "#patdesignationpensioner option:selected" ).text())
                 var penpincode=$("#patpincodepensioner").val();
           $("#dialogpin").text(penpincode);
          var dofretirement=$("#Patdorpensioner").val();
           $("#dialogretirementdate").text(dofretirement);
                    var PPOnumber=$("#Patppopensioner").val();
              $("#dialogppono").text(PPOnumber);    
                      if(PPOnumber){
						   $("#dialogppostatus").text("Yes");   
						  
					  }else
					  {
						 $("#dialogppostatus").text("No");     
					  }
					   $("#dialogfmaeligible").html($( "#patfmafacilitypensioner option:selected" ).text())
         
      var dateofretirement= $("#Patdorpensioner").val(); 
        $("#dialogdateofret").text(dateofretirement);
        
        var fmavalue=$("#patfmapensioner").val(); 
        if(fmavalue==1)
        {
			$('#dialogfma').text("yes");
		}else
            {
				$('#dialogfma').text("No");
			}
			
			     var deptonlineflag=$('#departmentonoffhiddenflag').val(); 
	   var isdepvalue= $('#isdependentadd').val();
		 
/*			 if(isdepvalue==1){
				   $('#ulundertakingwithoutdependentpensioner').empty();
          	// alert("444444444");
       		 $('input[name="undertakingChk"]:checked').each(function(){
				
				var key =(this).attr('id').split("_")[1];	
			var key = $(this).attr('id').split("_")[1];
	         //alert("key>>>>>>>>>>>>"+key);
				var text= $('#withdepdentlbl_'+key).text(); 
				//alert("text>>>>>>>>>>>>"+text);
				$('#ulundertakingwithoutdependentpensioner').append("<li>&#10004;" + text+ "</li>");
	             
			});    
	
			 }else{
			 alert("iiinnnelkseee");
		      $('#ulundertakingwithoutdependentpensioner').empty();
          //	 alert("444444444");
       		 $('input[name="undertakingChk1"]:checked').each(function(){
				
				var key =(this).attr('id').split("_")[1];	
			var key = $(this).attr('id').split("_")[1];

				var text= $('#nonRefundablelbl_'+key).text(); 
				$('#ulundertakingwithoutdependentpensioner').append("<li>&#10004;" + text+ "</li>");
	             
			});    
	}*/
			 $('#myModalcghsform').modal('show');
             
                      
     	    	 var formhtml=encryptBase64($('#onlineplasticformhtml').html() );
	    $('#onlineapplicationhidden').val(formhtml);
             
              }else   // Card Type Else Condition
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
          
	   
	      $("#dialogcardtypedeo").text($("#patcardtypeserving").val())
	        $("#dialogsubcardtypedeo").text($("#patsubcardtypeserving").val())
	    
	      $("#dialogdeptserving").html($("#patdeptserving option:selected" ).text())
			   var ofcaddressserving=$("#patofcadrserving").val();
           $("#dialogofcadress").text(ofcaddressserving);
           
           
		   $("#diagogpayscaledepon").html($( "#patpayscaleserving option:selected" ).text())
             $("#dialogdesignation").html($("#patdesignationserving option:selected" ).text())
                                                                             
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
	           
	                
	          /*      alert("11111111111111");
	                $('#ulundertakingwithoutdependent').empty();
          
       		 $('input[name="undertakingChk1"]:checked').each(function(){
				
				var key =(this).attr('id').split("_")[1];	
			var key = $(this).attr('id').split("_")[1];

				var text= $('#nonRefundablelbl_'+key).text(); 
				$('#ulundertakingwithoutdependent').append("<li>&#10004;" + text+ "</li>");
	             
			});    
			
			
			withdepdent_1*/
			  var isdepvalue= $('#isdependentadd').val();
		 /*
			 if(isdepvalue==1){
				   $('#ulundertakingwithoutdependentpensioner').empty();
          	// alert("444444444");
       		 $('input[name="undertakingChk"]:checked').each(function(){
				
				var key =(this).attr('id').split("_")[1];	
			var key = $(this).attr('id').split("_")[1];
	       //  alert("key>>>>>>>>>>>>"+key);
				var text= $('#withdepdentlbl_'+key).text(); 
			//	alert("text>>>>>>>>>>>>"+text);
				$('#ulundertakingwithoutdependentpensioner').append("<li>&#10004;" + text+ "</li>");
	             
			});    
	
			 }else{
		//	 alert("iiinnnelkseee");
		      $('#ulundertakingwithoutdependentpensioner').empty();
          	// alert("444444444");
       		 $('input[name="undertakingChk1"]:checked').each(function(){
				
				var key =(this).attr('id').split("_")[1];	
			var key = $(this).attr('id').split("_")[1];

				var text= $('#nonRefundablelbl_'+key).text(); 
				$('#ulundertakingwithoutdependentpensioner').append("<li>&#10004;" + text+ "</li>");
	             
			});    
	}*/
     	 $('#myModalcghsformservingdeptonline').modal('show');
     	 var formhtml=encryptBase64($('#onlineplasticformhtmlservingdeptonline').html() );
	    $('#onlineapplicationhidden').val(formhtml);
         }
         	
	   	    	   
	 
       
        }
/*

 function saveundertakingwithDep() {
            // Check if all checkboxes are checked
            if($('input[name="undertakingChk"]:checked').length<11){
			alert("Please complete Undertaking")
				return
							}
							else{
							//	alert("allowed");
								Previewform();
							}
		
        }*/
        

function saveundertakingwithDep() {
    // Get all checkboxes with the name "undertakingChk"
    var totalCheckboxes = $('input[name="undertakingChk"]').length;

    // Check if the number of checked checkboxes is equal to the total number of checkboxes
    if ($('input[name="undertakingChk"]:checked').length < totalCheckboxes) {
        // If not all checkboxes are checked, show an alert
        alert("Please complete Undertaking");
        return;  // Stop further execution
    } else {
        // If all checkboxes are checked, proceed with Previewform()
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
								
							//	alert("allowed");
								Previewform();
							}
		
       		 }
       		
/*
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
    const nomproofvalue=$('#filename15').val();
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
	        "nomaadharadd": nomaadhar,
	        "nomproof":nomproofvalue
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
        const alternatenomineeproof=$('#filename17').val();
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
	            "nomaadharadd": alternatenomineaadhar,
	            "nomproof":alternatenomineeproof
	        };
	        
	        // Add alternate nominee to the array
	        nomineeJson.push(json1);
        
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
			     html +="<td style='display:none;'>" + json["dependentBloodGroupadd"]+"</td>";
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
               
                             
            var resaddress=$("#patResaddress").val();
           $("#dialogoresadress").text(resaddress);
     
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
                      
          
            
              }else
		   {
	   //  alert("iinnn elseee");
	      $("#dialogcardtype").html($( "#patcardtypeserving option:selected" ).text())
	      $("#dialogcardtype").html($( "#patdeptserving option:selected" ).text())
			   var ofcaddressserving=$("#patofcadrserving").val();
           $("#dialogofcadress").text(ofcaddressserving);
                      
		   $("#dialogpayscale").html($( "#patpayscaleserving option:selected" ).text())
             $("#dialogdesignation").html($("#patdesignationserving option:selected" ).text())
         
	   	    	   
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
        }*/


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
	var checkboxdeputationflag =document.getElementById('depuflag1').value;
  // alert("checkboxdeputationflag>>>"+checkboxdeputationflag);

	if (checkboxdeputationflag=='1') {
		//alert("iinniifff")
		$('#showdepyeardiv').show();
		$('#deputationflaghidden').val("1");
		}
		
	/*
	var checkboxdeputationflag =document.getElementById('deputationflag');
	if (checkboxdeputationflag.checked) {
		$('#showdepyeardiv').show();
		}else
		{
			$('#showdepyeardiv').hide();
			$('#deputationflaghidden').val("0");
		}*/
}

function ShowDeputationyearNo()
{
	
	
		var checkboxdeputationflag2 =document.getElementById('depuflag2').value;

	
//	alert("checkboxdeputationflag2>>>"+checkboxdeputationflag2);
	
		if (checkboxdeputationflag2=='2') {
		//alert("iinniifff")
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

  function uploadPhoto() {
    document.getElementById(ctInputFileNameId).addEventListener('change', function(event) {
        const file = event.target.files[0];

        // Check if file exists and validate its size (10 KB = 10240 bytes)
        if (file && file.size <= 50000) {
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
  

		}else{
			alert("Camera Not Available; Please Try to Upload Photo");
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
    
    // Convert the month name (e.g., 'Nov') into a month number (e.g., 10 for November)
    const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    const monthIndex = monthNames.indexOf(month); // Get month index from the monthNames array
    
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

	    // Calculate the target date by adding the number of years to today's year
	    let targetDate = new Date(today.getFullYear() + years, today.getMonth(), today.getDate()+1);

	    // Calculate the difference in time (in milliseconds)
	    let differenceInTime = targetDate - today;

	    // Convert the time difference to days
	    let differenceInDays = Math.floor(differenceInTime / (1000 * 60 * 60 * 24));
	    
	    return differenceInDays;
	}	
	
	
	function validateSalary(salary) {
	//	alert("salary");
    // Check if salary is less than or equal to 36,500
    if (salary <= 36500) {
        return 1;  // Return 1 if salary is less than or equal to 36,500
    } 
    // Check if salary is between 36,501 and 50,500
    else if (salary > 36500 && salary <= 50500) {
        return 2;  // Return 2 if salary is between 36,501 and 50,500
    } 
    // Salary is 50,500 or more
    else {
        return 3;  // Return 3 if salary is 50,500 or more
    }
}


// Function to validate PAN number
function validatePAN(pan) {
    const panPattern = /^[A-Z]{5}[0-9]{4}[A-Z]{1}$/;  // Regular expression for PAN format

    // Convert PAN to uppercase to ensure the input is case-insensitive
    pan = pan.toUpperCase();

    return panPattern.test(pan);  // Returns true if valid, false if invalid
}

// Event listener for blur (clicking outside the input)


function validatepancheck()
	{
		 const pan =$('#patPANNo').val(); // Get the PAN value from the input field
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
        errorMessageDiv.textContent = '';  // Optionally clear any previous error message
        
        checkPanExist(pan);
    }
	}
function checkPanExist(pan)
{
	
	//alert(pan);
	 var configJson={
    			serviceName:"/getData/getPANNumber",
    			 callBackFunctionName: "callbackgetPAN",			
    		     			primaryKeys:[pan],
    		}
    	callService(configJson);
}

	
function validatepancheckDependent()
	{
		 const pan =$('#DepPANNo').val(); // Get the PAN value from the input field
		// alert("pan>>>>>>>>"+pan);
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
        errorMessageDiv.textContent = '';  // Optionally clear any previous error message
        
        checkPanExist(pan);
    }
	}
	function callbackgetPAN(configJson, dataJson) {
		const errorMessageDiv = document.getElementById('error-message');
  // Alert the entire `dataJson` object
 // alert("dataJson>>>> " + JSON.stringify(dataJson));
 if(dataJson["message"].indexOf("ERROR")<0){
	    	  $.each(dataJson["data"], function(_, json){
	    		// alert(json["optionValue"]);
	    		 if(json["optionValue"]==1){
					 errorMessageDiv.textContent='PAN Number already Exist';
					//alert("PAN Number already Exist");
				 }
				 else{
					 
				 }
	    	  });

	    	}
	    	  else
		    	  {
	    		  showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
	    	    	return;
		    	  }
}

function openmodal()
{
	//preview();
	$('#dialogOverlayconfirmpreview').show();
}

function handleResponse(response) {
//	alert("response>>>>>>>>>>>"+response);
     if (response === true)  {

      $('#fileuploadspousecertificate').show();
	  $('#spousedoctype').show();    
	   } else {
          $('#fileuploadspousecertificate').hide();
	  $('#spousedoctype').hide();    
      }

      // Close the dialog box
      document.getElementById('dialogOverlay').style.display = 'none';
    }

function handleResponsepreview(response) {
//	alert("response>>>>>>>>>>>"+response);
     if (response === true)  {

         saveData();
	   } else {
          
      }

      // Close the dialog box
      document.getElementById('dialogOverlayconfirmpreview').style.display = 'none';
    }
    
    
function OTPFn() {
	/*if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	*/
	var usermobile=document.getElementById('nommobile').value;
	if(usermobile==''){
		alert("Please Enter Mobile Number");
		return;
	}
	//var mobilehidden=	$('#hiddenmobile').val(usermobile);
	$("#userMobile").attr("readOnly",true);
	$('#generateBtn').hide();	
	$('#OTPRow').show();
	$('#validateBtn').show();
	$('#resendBtn').show();
	$('#userOTP').val("").focus();
  
	sendOTP();
}


function sendOTP(){
	var otpGen = Math.floor(1000 + Math.random() * 9000);
	showAlertMsg("OTP is send to mobile no.", 'success',"alertMsg");
    showMsg("Your OTP is"  +otpGen +"<br/> SMS Service not yet configured !", null);
    $('#otpGen').val(otpGen);
    resendOTPTimer("resendBtn");

}


function resendOTPTimer(btnId){
	$('#'+btnId).html("-").addClass("btn-light").removeClass("btn-his-outline").html("-");
	
	var timeleft = 10;
	var resendClickCount=0
	
	if($('#resendClickCount').val()!=undefined && $('#resendClickCount').val()!="" )		
		resendClickCount=parseInt($('#resendClickCount').val());
	
	
	var attemptLeft=2-resendClickCount;	
	$('#resendClickCount').val(++resendClickCount);	
	if(attemptLeft==0){
		$('#'+btnId).hide();
		return;
	}
	
	var downloadTimer = setInterval(function(){
	  if(timeleft <= 0){
		 $('#'+btnId).html("Resend OTP").removeClass("btn-light").addClass("btn-his-outline");
	    clearInterval(downloadTimer);
	  }
	  else
		  $('#'+btnId).html("<span style='font-size:13px;'>Resend  OTP in :<b>" + timeleft + " seconds</b> ,<br/>Attempt left: "+attemptLeft+"</span>"	);
	  	  timeleft -= 1;
	  
	}, 1000)
}
function OTPVerifyFn() {
 /* 
	if(ValidateForAllVisible("ENTRYFORM")==false)
			return;
	    */
	
	const userOtp = document.getElementById('userOTP').value;
//	alert("userOtp>>>>>"+userOtp);
alert("otpgeneratevalue>>>>>"+$('#otpGen').val());
	
    if($('#otpGen').val()!=userOtp){
    	 showMsg("ERROR:OTP entered doesnot match!", null);
    	 return;    
    }
    else{
    	var dialogConfigJson={callOnOK:"callBackOnOK"};
    	showMsg("SUCCESS:OTP Validated successfully!", dialogConfigJson);
    }
   
    
}
function callBackOnOK(){
	$('#OTPRow').hide();
	$('#validateBtn').hide();
	$('#resendBtn').hide();
	$('#Reset').hide();
	
}


function calculateAgeBasedonDob(dob) {
	
	alert("dobiiinnnnnnnnn>>>>"+dob)
  var today = new Date();
  var birthDate = new Date(dob);
  
  // Calculate difference in years
  var age = today.getFullYear() - birthDate.getFullYear();
  var month = today.getMonth() - birthDate.getMonth();

  // Adjust age if the current month is earlier than the birth month
  // Or if the current month is the birth month but the day is earlier than the birth day
  if (month < 0 || (month === 0 && today.getDate() < birthDate.getDate())) {
    age--;
  }

  return age;
}
function ValidatePPO() {
    // Get the value from the input field
    var ppoNumber = document.getElementById("Patppopensioner").value;

    // Regular expression to allow alphabets, numbers, hyphens (-), and slashes (/)
    var regExp = /^[a-zA-Z0-9/-]+$/;

    // Check if the PPO number matches the regular expression
    if (regExp.test(ppoNumber)) {
        // If valid, you can optionally add a success message or remove any error message
        console.log("PPO Number is valid.");
    } else {
        // If invalid, show an error message
        alert("Invalid PPO Number! Only alphabets, numbers, hyphens (-), and slashes (/) are allowed.");
    }
}

  