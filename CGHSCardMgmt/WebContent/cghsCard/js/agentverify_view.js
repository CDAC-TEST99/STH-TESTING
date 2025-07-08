$(document).ready(function () {
	
	initPage();
	
	
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#PatTrackingid').val(arrpk[1]);
		$('#PatTrackingidLbl').text("Tracking Id :" + arrpk[1]);
		gettrackingid();
	}
	else{
		hidePreloader();
		$('#divTrackingIdEntry').show();
		$('#PatTrackingidLbl').hide();
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
	
	   var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "DepRelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": "",
            "optionText": "Select Relation"
        }
    };
     callService(configJson);
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
	
	
	
	    $('#BTNMODIFY').click(saveData);
	
	}
	
 

    	
    	function gettrackingid()
   	{
			var trackingid=document.getElementById('PatTrackingid').value;

           //alert("11111"+trackingid);
           if(trackingid=='')
            {
             	alert("Plesae enter Mobile no");
	           return;
	
              }
                    
          // alert("11111"); 
	
	 var configJson={
    				serviceName:"/getData/getDetailsontrackingnumber",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"PopulateTrackingNumber",
    			 				
    			}
    		callService(configJson);



 var configJson={
    				serviceName:"/getData/getDetailDependent",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"populateTrackingDependent",
    			 				
    			}
    		callService(configJson);

			
	//alert("nomineee");		
 var configJson={
    				serviceName:"/getData/getDetailNoominee",
    				primaryKeys:[trackingid],			
    				callBackFunctionName:"populateTrackingNominee",
    			 				
    			}
    		callService(configJson);

					
			
		}
		
		
   function populateTrackingNominee(configJson, dataJson)
				{
				if (dataJson["message"].indexOf("ERROR") < 0) {
        $.each(dataJson["data"], function(_, json) {
            var html = "<tr>";
             html += "<td>" + json["FirstName"] + "</td>";
        html += "<td>" + json["DOB"] + "</td>";
        html += "<td>" + json["gstr_gender_name"] + "</td>";
         /*html += "<td>" + json["gstr_relation_name"] + "</td>";*/
          html += "<td>";
         html += "<select class='relation-dropdownnom'>"; // Start of dropdown
        html += "<option value='Select Relation'>Select Relation</option>";
       html += "<option value='" + json["nomrelationid"] + "' selected>" + json["gstr_relation_name"] + "</option>"; // Correct syntax
        html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["nomuploaddoc"] + "&folderName=CARDDOCUMENT'>" + json["nomuploaddoc"] + "</a></td>";

       
      html += "</select>"; // End of dropdown
         html += "</td>";
     /*   html += "<td><button onclick='editRownom(this)'>Edit</button></td>";*/
        html += "</tr>";
                              
            $("#Nomtable tbody").append(html);
                 $('#Nomtable').show();         
         
         $( "button" )
         .click(function( event ) {
           event.preventDefault();
         });
        $( "input[type=button], button" )
          .click(function( event ) {
            event.preventDefault();
               });

        });
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
        return;
    }
}

		
			
			function PopulateTrackingNumber(configJson, dataJson) {
    	 //   alert("configJson>>> " + JSON.stringify(configJson));
    	  //alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
				hidePreloader();
				
    	 
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){
					
				var resfileupload=	json["resdocupload"];
                //  alert(resfileupload);
                  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
                  var url = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["resdocupload"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["resdocupload"] + "</a>";
					
					$('#imagetest').html(url);
                                   //  alert("jsonfmafacility>>>>>>>>"+json["fmafacility"]);
                                 
                       var PPODocument=json["PPOdocument"];
                        // alert("PPODocument>>>"+PPODocument);
                    var url1 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["PPOdocument"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["PPOdocument"] + "</a>";
                       $('#imagetest1').html(url1);
                       
                                var url2 = "<a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" +json["depspouse_doc"] + "&isGlobal="+isGlobal+"&varSSOTicketGrantingTicket="+ticket+"&folderName=CARDDOCUMENT'>" + json["depspouse_doc"] + "</a>";
                       $('#imagetest2').html(url2);
                       
                      $('#patName').val(json["FirstName"]);
                      $('#patNameHindi').val(json["FirstName"]);
                      $('#patDOB').val(json["DOB"]);
                     // $('#patGender').val(json["gstr_gender_name"]);
                      $('#patMobileNo').val(json["MobileNo"]);
                      $('#statecode').val(json["gstr_statename"]);
                       $('#PatientCghsCity').val(json["gstr_city_name"]);
                     // $('#patrelation').val(json["relation"]);
                      
                              $('#patadcity').val(json["adcitycode"]);
                      
                      
                     /*  $('#patbloodgroup').val(json["gstr_bloodgroup_name"]);*/
                       $('#patEmail').val(json["EmailId"]);
                        $('#patresaddress').val(json["ResAddress"]);
                    
                         $('#PatCardtype').val(json["gstr_cardtype_name"]);
                          $('#patfmafacilitypensioner').val(json["fmafacility"]);
                         
                         
               
                         
                         var configJson={
						serviceName:"/getData/getGenderList",
						comboId:"patGender",			
						callBackFunctionName:"commonPopulateCombo",
						defaultOption:{"optionValue":json["genderId"],"optionText":""}	
			
		}
	callService(configJson);
	
	var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "patrelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": json["relation"],
            "optionText": "Select Relation"
        }
    };
     callService(configJson);
	
             var configJson={
			serviceName:"/getData/getCghscityList",
			comboId:"PatientCghsCity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["citycode"],"optionText":"Select City"}
			
			
	   	}
	          callService(configJson);
	   

                 var cardtype=json["gstr_cardtype_name"];
                // alert(cardtype);
                  var year=json["deputationyear"];
                 var cardtypevaluecategory=json["cardtype"];
               // alert("cardtypecardtypecardtype"+cardtypevaluecategory);
              //  if (cardtype=='Pensioner' || cardtype=='Ex-MP' || cardtype=='Freedom Fighter')
              if(cardtypevaluecategory=='P')
                {
					$('#cardtypevaluehidden').val("P");
					
				   var ppono=json["PPONo"];

				//	alert("iinnn pensioner"+ppono);
					$('#servingdept').hide();
					$('#pensionerdept').show();
					  $('#patdepartmentP').val(json["gstr_service_dept_name"]);
					$('#PatCardtypeP').val(json["cardtype"]);
					$('#PatsubCardtypeP').val(json["gstr_cardtype_name"]);
										
       			  $('#LastPayP').val(json["lastpay"]);
				  $('#PensionerPPO').val(json["PPONo"]);
					 $('#FmaP').val(json["treatmenttype"]);
			    $('#CardApplyvalidity').val(json["cardapplyvalidity"]);
			    $('#PatDOR').val(json["DateofRetirement"]);
			    $('#Existingbenid').val(json["existingbenid"]);
				
				   var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"entitlementP",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);
	      
	      	  
		    var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"payscaleP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		      }
	         callService(configJson);
						
	 var configJson={
			serviceName:"/getData/getdepartmentpepensioner",
			comboId:"patdepartmentP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
		}
	callService(configJson);
	//alert("validity");
	 var configJson={
			serviceName:"/getData/getcardvalidity",
			comboId:"CardApplyvalidity",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["cardapplyvalidity"],"optionText":"Select cardvalidity"}	
		}
	callService(configJson);
	
	//alert("FMA");
	 var configJson={
			serviceName:"/getData/getFmalist",
			comboId:"FmaP",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["treatmenttype"],"optionText":"Select FMA"}	
		}
	callService(configJson);
				
				}else{
					
					$('#cardtypevaluehidden').val("S");
					$('#servingdept').show();
					$('#pensionerdept').hide();
					$('#PatCardtype').val(json["gstr_cardtype_name"]);
				   $('#patdepartment').val(json["gstr_service_dept_name"]);
					$('#OfcAdress').val(json["officeaddress"]);
					$('#Presentpay').val(json["presentpay"]);
					$('#Deputationyear').val(json["deputationyear"]);
					$('#Designation').val(json["Designation"]);
				               
				               
				               $('#PatCardtypeS').val(json["cardtype"]);
					$('#PatsubCardtypeS').val(json["gstr_cardtype_name"]);
										
					var transfercityflag=json["transferflag"];
				  if(transfercityflag=='Y')
				  {
					$('#Transferableservice').val('Yes');
				  }else{
					  $('#Transferableservice').val('No');
				  }
			    var configJson={
				serviceName:"/getData/getEntitlement",
			 comboId:"entitlementS",		
			 callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["entitlement"],"optionText":"Select Entitlement"}	
			
		      }
	      callService(configJson);
				  
					  var configJson={
			serviceName:"/getData/getpayscale",
			comboId:"payscale",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["gnum_pay_scales"],"optionText":"Select Payscale"}	
			
		}
	callService(configJson);
					
						//alert("department");
		 var configJson={
			serviceName:"/getData/getdepartmentserving",
			comboId:"patdepartment",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Deptid"],"optionText":"Select Department"}	
			
		}
	 callService(configJson);
						
				}
				
				
	//alert("Designation");
	 /*var configJson={
			serviceName:"/getData/getDesignationList",
			comboId:"patdesignationserving",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":json["Designation"],"optionText":"Select Designation"}	
		}
	callService(configJson);
                      */
                $('#officeaddress').val(json["officeAddress"]);
                $('#displayuserinfo').show();
 });      
           }
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
    	 
    
    	}
		
		
		
	
let rowIndex = 1;
function populateTrackingDependent(configJson, dataJson) {
  //  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    
    if (dataJson["message"].indexOf("ERROR") < 0) {
        $.each(dataJson["data"], function(_, json) {
			//alert(json["dependentuploaddoc"]);
	
	  var disablityflagdisplay="";
	     var disablityflag=json["disablityflag"] ;
	     if(disablityflag==1)
	     {
			 disablityflagdisplay="Yes";
		 }else{
			 disablityflagdisplay="No";
		 }
		 
		 var relationid=json["deprelationid"];
	 alert(json["dependentiddoc"]);
            var html = "<tr>";
               html += "<td>" + rowIndex + "</td>"; // Add index here
             html += "<td>" + json["FirstName"] + "</td>";
        html += "<td>" + json["DOB"] + "</td>";
        html += "<td>" + json["depGen"] + "</td>";
     /*   html += "<td>" + json["DepBloodgroup"] + "</td>";*/
       /* html += "<td>" + json["DepRelation"] + "</td>";*/
        html += "<td>"
         html += "<select class='relation-dropdown'>"; // Start of dropdown
        html += "<option value='Select Relation'>Select Relation</option>";
       html += "<option value='" + json["deprelationid"] + "' selected>" + json["DepRelation"] + "</option>"; // Correct syntax
      html += "</select>"; // End of dropdown
         html += "</td>";
        html +="<td><img src='"+json["photo"]+"' style='width:90px;height:90px'></td>";
       /*   html += "<td>" +disablityflagdisplay + "</td>";*/
         html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + json["dependentiddoc"] + "&folderName=CARDDOCUMENT'>" + json["dependentiddoc"] + "</a></td>";
        html += "<td><button onclick='editRow(this, " + rowIndex + ")'>Edit</button></td>";
         html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";
        html += "</tr>";
                                     
                    
            $("#Deptable tbody").append(html);
              rowIndex++;
        
        
         $( "button" )
         .click(function( event ) {
           event.preventDefault();
         });
        $( "input[type=button], button" )
          .click(function( event ) {
            event.preventDefault();
               });

                      
        });
          $('#Deptable').show();
        
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
        return;
    }
}
let currentRow; 
function editRow(button, index)  {
//alert("iinn row");

   $('#dependentinfomodify').show(); // Show the modify container
    currentRow = button.closest("tr"); // Store the current row being edited
    var cells = currentRow.querySelectorAll("td");
     $('#editRowIndex').val(index);
 //alert("editrowindex"+editrowindex);
 
 //   alert("Editing: " + cells[0].innerText);
          $('#DepName').val(cells[1].innerText);
          $('#DepDob').val(cells[2].innerText);
           $('#DepGender').val(cells[3].innerText);
          // $('#DepRelation').val(cells[3].innerText);
         // var relationvalue=cells[4].querySelector(".relation-dropdown").value;
        
      var relationDropdown = cells[4].querySelector(".relation-dropdown");
    var relationvalue = relationDropdown ? relationDropdown.value : "";
    console.log("Relation value:", relationvalue); // Debugging output

    // Set the relation value if you need to display it somewhere
    $('#DepRelation').val(relationvalue); // Assuming you have an input to show this value

    // Get the photo URL from the appropriate cell
       var photoUrl = cells[5].querySelector("img").src;
     // alert(photoUrl);
   
 
    if (photoUrl) {
        document.getElementById("editPhoto").src = photoUrl;
    } else {
       
        document.getElementById("editPhoto").src = ""; // or a default image
    }
 
   // Handle the file link
    var fileLink = cells[7].querySelector("a") ? cells[7].querySelector("a").href : "#";
    var fileName = cells[7].querySelector("a") ? cells[7].querySelector("a").innerText : "File";
    //alert(fileLink);
    // Update the file link for editing
    viewfileedit.href = fileLink;
    viewfileedit.innerText = fileName;
    viewfileedit.target = "_blank"; // Open in a new tab

   //  $('#disflag').val(cells[6].innerText);

}

function handleDecision()

{
	
	 const approveButton = document.getElementById('approve');
        const rejectButton = document.getElementById('reject');
	 if (approveButton.checked) {
                alert("You have approved.");
                $('#statusflag').val("A")
                 $('#remarksbox').hide();
            //  saveData()
            } else if (rejectButton.checked) {
               alert("You have rejected.");
                $('#statusflag').val("R")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
            }
       } 
function editRownom(button) {
//alert("iinn row");

$('#NomtableModify').show();
  currentRow = button.closest("tr"); // Store the current row being edited
    var cells = currentRow.querySelectorAll("td");
  var relationvalue=cells[3].querySelector(".relation-dropdownnom").value;
  var configJson = {
        serviceName: "/getData/getRelationdata",
        comboId: "NomRelation",
        callBackFunctionName: "commonPopulateCombo",
        defaultOption: {
            "optionValue": relationvalue,
            "optionText": "Select Relation"
        }
    };
    callService(configJson);
	
  
          $('#NomName').val(cells[0].innerText);
          $('#NomDob').val(cells[1].innerText);
           $('#NomGen').val(cells[2].innerText);
         //  $('#NomRelation').val(cells[3].innerText);
        
           
           $('#Nomtablemodify').show();
          
    }


function saveChanges() {
	
	var rowIndex = $('#editRowIndex').val();
	//alert("rowIndex");
    if (!currentRow) return; // Ensure there's a row to edit

    // Get the values from the input fields
    var modfiedname = $('#DepName').val();
      var modfieddob = $('#DepDob').val();
    var modifiedgender=$('#DepGender').val();
    var modifiedrelation=$( "#DepRelation option:selected" ).text();
    //alert(modifiedrelation);
     var modifiedrelationid=$( "#DepRelation option:selected" ).val();
   
  var photo=document.getElementById("editPhoto").src;
  //alert(photo);
    // Update the original table cells
    currentRow.cells[1].innerText = modfiedname;
    currentRow.cells[2].innerText = modfieddob;
     currentRow.cells[3].innerText = modifiedgender;
  //   currentRow.cells[4].innerText = modifiedrelation;
      
   currentRow.querySelector('img').src=photo;
  
   
    // Clear the currentRow reference
     $('#dependentinfomodify').hide();
    currentRow = null;
}


function saveChangesnominee() {
	//alert("11111");
    if (!currentRow) return; // Ensure there's a row to edit

    // Get the values from the input fields
    var name = $('#NomName').val();
   // alert(name);
    var dob = $('#NomDob').val();
   // var gender = $('#DepGender').val();

    // Update the original table cells
    currentRow.cells[0].innerText = name;
    currentRow.cells[1].innerText = dob;
    //currentRow.cells[2].querySelector("select").value = gender; // Update the dropdown

    // Optionally hide the modify container after saving
    $('#NomtableModify').hide();
   var nomjson={"nomname": name,
     "nomdob":dob, 
     } 
     
     
    // Clear the currentRow reference
    currentRow = null;
}
function saveData() {
	  
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
     //alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/saveModifydatadept",
        callBackFunctionName: "callbackSaveData",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
}

	
function callbackSaveData(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
		
			}
}
	
  function resetapage()
  {
	  $('#remarksbox').hide();
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
	 // alert(previewHiddenId);

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
 
		
     
  }
function addRowToTable() {
//	alert("1111111111111");
   $('#newadddependentinfo').show();
     var configJson={
						serviceName:"/getData/getGenderList",
						comboId:"Newdepgender",			
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
	 function deleteRow(button) {
    var row = button.closest('tr'); // Find the closest row
    row.parentNode.removeChild(row); // Remove the row from the table
}

	 
function adddepinfo() {
	//alert("111");

  const depnameadd = document.getElementById('Newdepname').value;
    
   const depentrelationadd= $( "#Newdeptrelation option:selected" ).text();
   const depentrelationaddID= $( "#Newdeptrelation option:selected" ).val();
  const depDOBadd = document.getElementById('NewdepDOB').value;
  
  const depgenderadd=$( "#Newdepgender option:selected" ).text();
  const depgenderaddID=$( "#Newdepgender option:selected" ).val();
  
  const depBloodGroupadd=$( "#NewdepBloodGroup option:selected" ).text();

    const imgSrc = $("#fileContent2").val();
    //alert("imgSrc"+imgSrc);
     const fileuploadvalue=$('#filename11').val();
    //alert("fileuploadvaluefileuploadvaluefileuploadvalue"+fileuploadvalue);
     const disablityflag=$('#isdisablityvaluehidden').val();
    // alert(disablityflag);
     var json={"depname": depnameadd,
     "dependentRelation":depentrelationadd, 
     "dependentGender":depgenderadd,
     "dependentGenderId":depgenderaddID,
      "dependentRelationId":depentrelationaddID,
     "dependentBloodGroupadd":depBloodGroupadd,
     "deppendentDOBadd":depDOBadd,
     "dependentPhoto":imgSrc,
     "dependentuploaddoc":fileuploadvalue,
     "dependentdisablityflag":disablityflag
     } 
     
         
      createDependentRow(json);
    
      
    }  
      function createDependentRow(json){
		  var isGlobal= $('#isGlobal').val()!=undefined || $('#isGlobal').val()!=''?$('#isGlobal').val():'0';
                  var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
		  
		  var uniqueid=getUniqueId();
		//  alert(uniqueid);
	//if(indx!=0)
		//uniqueid=indx;
	 var disablityflag=json["dependentdisablityflag"] ;
	     if(disablityflag==1)
	     {
			 disablityflagdisplay="Yes";
		 }else{
			 disablityflagdisplay="No";
		 }
		 
	var realtionid=json["dependentRelationId"];
	//alert(realtionid);
	 var html ="<tr id='trdependent_"+uniqueid+"'>";
          html += "<td>" + rowIndex + "</td>"; // Add index here
     html +="<td>" + json["depname"]+"</td>";
     html +="<td>" + json["deppendentDOBadd"] +"</td>";
     html +="<td>" +  json["dependentGender"]  +"</td>";
   /*  html +="<td>" + json["dependentRelation"] +"</td>";*/
     /*html +="<td>" + json["dependentBloodGroupadd"]+"</td>";*/
      html += "<td>";
         html += "<select class='relation-dropdown'>"; // Start of dropdown
        html += "<option value='Select Relation'>Select Relation</option>";
       html += "<option value='" + json["dependentRelationId"] + "' selected>" + json["dependentRelation"] + "</option>"; // Correct syntax
      html += "</select>"; // End of dropdown
         html += "</td>";
     html +="<td><img src='"+json["dependentPhoto"] +"' style='width:100px;height:100px'>" ;
      /* html +="<td>" +disablityflagdisplay+"</td>";*/
          html += "<td><a class='uploadA' target='_blank' href='/CGHSCardMgmt/FormFlowXACTION?hmode=fileTempDownload&fileName=" + json["dependentuploaddoc"] + "&folderName=CARDDOCUMENT'>" + json["dependentuploaddoc"] + "</a></td>";
         html += "<td><button onclick='editRow(this, " + rowIndex + ")'>Edit</button></td>";
          html += "<td><button class='deleteBtn' onclick='deleteRow(this)'>Delete</button></td>";
     html +="<input type='hidden' name='dependentJson' value='"+JSON.stringify(json)+"'>";
     html +="</td>";
     html +="</tr>";
     $('#Deptable tbody').append(html);
     
   rowIndex++;
   $('#newadddependentinfo').hide();
   
}