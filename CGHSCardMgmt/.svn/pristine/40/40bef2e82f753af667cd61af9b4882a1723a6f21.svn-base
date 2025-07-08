$(document).ready(function () {
	
	initPage();
	
	
	var Benid=$('#Benidvalue').val();
alert("Benid>>>>>>>>>>>>>>>>>"+Benid);
	 $("#benId1").text(Benid);
	 var cardno=$('#cardnovalue').val();
var primaryKeyFromListPage= $('#primaryKeyFromDelingoffline').val();
//alert("Primarykeys>>>>>>>>>>>>>>>>>"+primaryKeyFromListPage);
let rowindex=1;
if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage);
	//	alert("arrpk>>>>>>>>>"+arrpk);
		 arrpk = JSON.parse(arrpk);
		
		
		 if(arrpk.patrelation=='1')
   {
	   maincardholrelationvalue="Self";
   }
   
   
	var maincardholdername=arrpk.patName;
	var maincardholderdob=arrpk.patDOB;
	var maincardholdergenderId=arrpk.patGender;
	var photoUrl=arrpk.mainPhotoId;
  var maincardholderrelationid=arrpk.isdependentadd;
	var maincardholderrelation=maincardholrelationvalue;
	var isdependent=arrpk.isdependentadd;
	//alert(isdependent);
	var cardvalidity=arrpk.patcardvalidto;
	alert(cardvalidity)
   if(isdependent=='1')
   {
	 //  alert("iiinnifff");
	  $('#newadddependentinfo').show();
	   $("#depcardvalidto").datepicker({ minDate:cardvalidity , 
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
   }else{
	   $('#noDependentLabel').text("You have not selected a dependent").show();
   }
  
   if(maincardholdergenderId=='F'){
	   $('#mainchgenderhidden').val("F");
	   maincardholdergender="Female";
   }else if(maincardholdergenderId=='M')
   {
	     $('#mainchgenderhidden').val("M");
	    maincardholdergender="Male";
   }else{
	    $('#mainchgenderhidden').val("T");
	   maincardholdergender="Transender";
   }
	
	 var json={
	  "mainchbenid":Benid,
	  "mainchname": maincardholdername,
      "mainchdob":maincardholderdob, 
      "mainchgender":maincardholdergender,
      "mainchgenderid":maincardholdergenderId,
     "mainchrelation":maincardholderrelation,
     "mainchrelationid": maincardholderrelationid,
      "mainchphoto":photoUrl,
     
     } 

     createDependentRowmaincardholder(json);
	
	
	/*
  var json={
	  "DepBenId":Benid,
	  "DepName": maincardholdername,
      "DepDob":maincardholderdob, 
      "DepGender":maincardholdergender,
      "DepGenderID":maincardholdergenderId,
     "DepRelation":maincardholderrelation,
     "DepRelationId": maincardholderrelationid,
      "DepPhoto":photoUrl,
      "Depdocupload":"",
	  "Depdisablityflag":"0",
     } 


     
      createDependentRow(json);*/
      
      	//	alert("genderdependent");
	  var configJson={
			serviceName:"/getData/getGenderList",
			comboId:"Newdepgender",			
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
	
	
	
	
	  var configJson={
			serviceName:"/getData/getRelationdata",
			comboId:"Newdeptrelation",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select Relation"}	
			
		}
		callService(configJson);
		
		
		$('#Newdeptrelation').change(function(){
	//alert("Newdeptrelation")
	
	var configJson={
    			serviceName:"/getData/getgenderbaseonrelation",
      			callBackFunctionName:"populategender",			
        		primaryKeys:[$('#Newdeptrelation').val()],
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

		
	}
	
});

function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	
	
	
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
	
	function adddepinfo() {
	//alert("111");
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
		
		 
		
  const depnameadd = document.getElementById('Newdepname').value;
    
   const depentrelationadd= $( "#Newdeptrelation option:selected" ).text();
   const depentrelationaddID= $( "#Newdeptrelation option:selected" ).val();
  const depDOBadd = document.getElementById('NewdepDob').value;
  
  const depgenderadd=$( "#Newdepgender option:selected" ).text();
  const depgenderaddID=$( "#Newdepgender option:selected" ).val();
  
     const imgSrc = $("#fileContent2").val();
    const fileuploadvalue=$('#filename11').val();
     const disabilityflag=$('#isdisablityvaluehidden').val();
    //alert(fileuploadvalue);
     const dependentspousecertificate=$('#filename14').val();
    //alert(fileuploadvalue);
    const dependentidproofdoc=$('#filename20').val();
     const dependentAgeProofdoc=$('#filename22').val();
     
     
     
     var depage=calculateAge(depDOBadd);
if(depage>25 && depentrelationaddID=='5'){
			alert("Son's Age is not greater than 25")
			return;
		}
    if(depage>18 && depentrelationaddID=='7'){
			alert("Brother's Age is not gretaer than 18")
			return;
		}

     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     //"dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc,
     "dependentdisableuploaddoc":fileuploadvalue,
     "dependentdisabilityflag":disabilityflag,
     "dependentspousecertificate":dependentspousecertificate,
     "dependentIdProof":dependentidproofdoc,
     "dependentAgeProof":dependentAgeProofdoc
     } 
      createDependentRow(json);
     
     
     //tbody.appendChild(createRow(depnameadd, depDOBadd,depgenderadd,depentrelationadd,depBloodGroupadd , depdentPhotoadd));
    
    
    
   
}




  function populategender(configJson, dataJson)
    {
	  // alert("configJson>>> " + JSON.stringify(configJson));
    //	  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   
    	    }
    	    else
        	    {
    	       	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
               
               //alert("Relationid>>>>>>>>"+json["relationid"]);
               var depdisableflag=json["disableflag"];
              // alert("depdisableflag>>>>>>>>"+json["disableflag"]);
              
             
               if(depdisableflag=='1'){
				    $('#fileuploaddisablecertificate').show();
				     $('#isdisablityvaluehidden').val("1");	 
			   }else{
				  $('#fileuploaddisablecertificate').hide();  
				   $('#isdisablityvaluehidden').val("0");	 
			   }
			   
			   if(relationidvalue==5 || relationidvalue==15 || relationidvalue==16 || relationidvalue==22){
				     $('#fileuploadageproof').show();
				   
			   }else{
				    $('#fileuploadageproof').hide();
			   }
       var patgendervalue= $('#mainchgenderhidden').val();
		//	var patgendervalue=  $('#patGender').val();
			//alert("patgendervalue>>>>>>>>"+patgendervalue);
			
			var relationidvalue=json["relationid"];
			   var genderidvalue=json["genderid"];
			 //  alert("genderidvalue>>>>>>>>"+genderidvalue);
			   if(genderidvalue=='U' && patgendervalue=='M' && relationidvalue=='2'){
				    $('#Newdepgender').val("F"); 
				  /*  var dialogConfigJson={callOnOK:"callBackOnOK",callOnCancel: "callbackOnCancel"};
    	           showMsg("Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?", dialogConfigJson);*/
				   	if (confirm('Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?')) {
               // Save it!
              $('#fileuploadspousecertificate').show();
                     
                     } 			   			    
			   }else if(genderidvalue=='U' && patgendervalue=='F' && relationidvalue=='2')
			   {
   			    $('#Newdepgender').val("M"); 
   			      	if (confirm('Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?')) {
               // Save it!
              $('#fileuploadspousecertificate').show();
                     
                     } 	
   			    /* var dialogConfigJson={callOnOK:"callBackOnOK",callOnCancel: "callbackOnCancel"};
    	           showMsg("Is your spouse employed under Ministry of Railways/ Ministry of Defense/ State government/ PSU?", dialogConfigJson);
				   //   $('#fileuploadspousecertificate').show();*/
			   }else{
				  // alert("iinnelse>>>>"+json["genderid"]);
				   $('#Newdepgender').val(json["genderid"]);
				     $('#fileuploadspousecertificate').hide();
				
			   }
			   
			   
                 });
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}	
	/*
	
function adddepinfo() {
	//alert("111");
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
		
  const depnameadd = document.getElementById('Newdepname').value;
    
   const depentrelationadd= $( "#Newdeptrelation option:selected" ).text();
   const depentrelationaddID= $( "#Newdeptrelation option:selected" ).val();
  const depDOBadd = document.getElementById('NewdepDOB').value;
  
  const depgenderadd=$( "#Newdepgender option:selected" ).text();
  const depgenderaddID=$( "#Newdepgender option:selected" ).val();
  
     const imgSrc = $("#fileContent2").val();
    const fileuploadvalue=$('#filename11').val();
     const disabilityflag=$('#isdisablityvaluehidden').val();
    alert(fileuploadvalue);
    
    
    
     var json={
		 "DepBenId":"",
		 "DepName": depnameadd,
     "DepRelation":depentrelationadd, 
       "DepRelationId":depentrelationaddID, 
     "DepGender":depgenderadd,
      "DepGenderID":depgenderaddID,
       "DepDob":depDOBadd,
       "DepPhoto":imgSrc,
     "Depdocupload":fileuploadvalue,
     "Depdisablityflag":disabilityflag
     } 
      createDependentRow(json);

    
    
   
}*/


function createDependentRowmaincardholder(json)
{

	
	 var html ="<tr id=''>";
     html +="<td class='slno'></td>";
     html +="<td>" + json["mainchbenid"]+"</td>";
     html +="<td>" + json["mainchname"]+"</td>";
     html +="<td>" + json["mainchdob"] +"</td>";
       html +="<td>" + json["mainchrelation"] +"</td>";
     html +="<td>" +  json["mainchgender"]  +"</td>";
        /*html +="<td>" + json["dependentBloodGroupadd"]+"</td>";*/
     html +="<td><img src='"+json["mainchphoto"] +"' style='width:100px;height:100px'>" ;
       html += "<td><a class='btn btn-his-sm' onclick='viewIndexCard()'>View</a></td>";
        html +="<input type='hidden' name='maincardholderjson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#maincardholderdetail tbody').append(html);
 //saveData();
     var index=1;
     $('.slno').each(function(){
		 $(this).text(index);
		 //index++;
	 });
	 
	 }

function createDependentRow(json){
	
	  
	 var html ="<tr id=''>";
     html +="<td class='slno1'></td>";
        html +="<td>" + json["depname"] +"</td>";
          html +="<td>" + json["deppendentDOBadd"] +"</td>";
       html +="<td>" + json["dependentRelation"] +"</td>";
     html +="<td>" +  json["dependentGender"]  +"</td>";
        /*html +="<td>" + json["dependentBloodGroupadd"]+"</td>";*/
     html +="<td><img src='"+json["dependentPhoto"] +"' style='width:100px;height:100px'>" ;
    html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=fileTempDownload&fileName=" + json["dependentIdProof"] + "&folderName=CARDDOCUMENT'>" + json["dependentIdProof"] + "</a></td>";
  /*   html +="<td>" + json["Depdisablityflag"] +"</td>";*/
       html += "<td><button onclick='editRownom(this)'>Edit</button></td>";
     html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";
     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#Dependentdetails tbody').append(html);
     $('#Dependentdetails').show();
 //saveData();
     var index=1;
     $('.slno1').each(function(){
		 $(this).text(index);
		 index++;
	 });
	 
	 
	  document.getElementById('Newdepname').value = "";
	  document.getElementById('Newdeptrelation').value = "";
	  document.getElementById('NewdepDob').value = "";
	  document.getElementById('Newdepgender').value = "";
	  $("#fileContent2").val(""); // Clear image src input
    $('#filename11').val(""); // Clear file upload input
  //  $('#imagePreview').attr('src', ''); // If you have an image preview, clear it as well
	  
	//     $('#newadddependentinfo').hide();
}


function savedepinfo() {
	
	if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	 if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
//alert("Dep data");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/DependentBenId",
        callBackFunctionName: "callbackSaveData",
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
	
	alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		alert("callbackSaveData>>>>>>>\n"+ dataJson["message"]);
				var json =JSON.parse(dataJson["message"].replace("SUCCESS:", ""));
			showMsg("SUCCESS:"+ json["message"],dialogConfigJson)
	}
  
}

function resetPage(){
	alert("iinn reset page");
//	$('#masterKey').val("viewfamilydetails");
		//submitFormWithResetTextField("CallMasterPage");
	  submitFormMaster("viewfamilydetails","add");	
}

function viewIndexCard()
    	{
        	//alert("11111111");        	
      


 var configJson={
    				serviceName:"/getData/getDetailsonbenid",
    				primaryKeys:[$('#Benidvalue').val()],			
    				callBackFunctionName:"populateIndexCard",
    			 				
    			}
    		callService(configJson);

    	 

   }	  	
        	
 		    	
       	function populateIndexCard(configJson, dataJson) {
    	   // alert("configJson>>> " + JSON.stringify(configJson));
    	//   alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
  //  alert("populateIndexCard");
    	    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   // $('#applyplastccard').show();
    	    }
    	    else
        	    {
		  
    	       	    	
    	    	
    	    let indx = 1;
    	   // const tableBody = $("#getstatusbeneficiary tbody");
    	     $("#AutoNumber1 tbody").empty();
    	   // var trackingId="";
    	    // checking if error exists
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){

        	    	let html = "<tr>";
          	        html += "<td class='slno'>" + indx + "</td>";
          	        html += "<td>" + json["benid"] + "</td>"; 
          	        html += "<td>" + json["FirstName"] + "</td>";
          	        html += "<td>" + json["DOB"] + "</td>";
          	        html += "<td>" + json["gstr_relation_name"] + "</td>";
          	        html += "<td>" + json["gstr_gender_code"] + "</td>";
          	         html +="<td><img src='"+json["photo"]+"' style='width:100px;height:100px'>" ;
          
               	         
          	        html += "</tr>";
          	       // trackingId=json["Trackingid"];
          	         $("#govEmployeeName").text(json["FirstName"]);
          	          $("#wellnesscenterName").text(json["gstr_hospital_name"]);
          	             $("#issueDate").text(json["validupto"]);
          	           $("#departmentName").text(json["DepartmentId"]);
          	           $("#residentialAddress").text(json["hrgstr_address_line1"]);
          	           
          	           
          	         $("#AutoNumber1 tbody").append(html); 
            	    });
            	    
            	   
        	    
        	   $('#mymodalprintindexcard').modal('show');
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	}



function PrintIndexcard()
{
	
	
	if($('#divDependentEntry').is(":visible")){
		$('#divDependentEntry').hide();	
	}
	  	  	      
	    // Primary nominee details
   if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
        const rows = document.querySelectorAll('#Deptable tbody tr');
          var indx=1;
          $("#AutoNumber1 tbody").empty();
          $("[name=dependentJson]").each(function(){
			  var json = JSON.parse( $(this).val());
			 			  
			  var html ="<tr >";
			  
			  
			     html +="<td class='slno'>"+indx+"</td>";
			      html +="<td>" + json["DepBenId"]+"</td>";
			     html +="<td>" + json["DepName"]+"</td>";
			     html +="<td>" + json["DepDob"]+"</td>";
			     html +="<td>" + json["DepRelation"] +"</td>";
			     html +="<td>" + json["DepGender"]+"</td>";
			    /* html +="<td style='display:none;'>" + json["dependentBloodGroupadd"]+"</td>";*/
			     html +="<td><img src='"+json["DepPhoto"]+"' style='width:100px;height:100px'>" ;
			     html +="</tr>";
			    $("#AutoNumber1 tbody").append(html); 
			 	//alert("$('#AutoNumber2Iimg'+indx)>>" + $('#AutoNumber2Iimg'+indx).length)
			 //	$('#AutoNumber2Iimg'+indx).html("<img src='"+json["dependentPhoto"]+"' style='width:100px;height:100px;' />")
			 	//$('#AutoNumber2ISno'+indx).html(indx);
			 	
			    indx++;
			  
		  });
		  var primaryKeyFromListPage= $('#primaryKeyFromDelingoffline').val();
  //alert("Primarykeys>>>>>>>>>>>>>>>>>"+primaryKeyFromListPage);
    
     if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage);
	//	alert("arrpk>>>>>>>>>"+arrpk);
		 arrpk = JSON.parse(arrpk);
		 
		  $("#govEmployeeName").text(arrpk.patName);
		  $("#residentialAddress").text(arrpk.patresaddress)
		   $("#issueDate").text(arrpk.PatDofissue)
		    $("#entitlement").text(arrpk.patentitlementserving)
		      $("#departmentName").text(arrpk.patdeptserving)
		  
		  
		}

	
	//alert("11111");
	 $('#mymodalprintindexcard').modal('show');
}

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
	