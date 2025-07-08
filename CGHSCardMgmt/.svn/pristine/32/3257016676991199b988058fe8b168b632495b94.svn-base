/*$(document).ready(function () {

		initPage();
		});*/
		
$(document).ready(function () {


   // alert('checkedvalue'+$('input[type=radio][name=transferType]:checked').val());
    if ($('input[type=radio][name=transferType]:checked').val() == '0') {
		 transferType=0;
        doUploadSectionOnPageLoad(0);
    } else if ($('input[type=radio][name=transferType]:checked').val() == '1') {
		transfertype=1;
        // Add your code here for the '1' case
        doUploadSectionOnPageLoad(1);
    }
	
	
 function  doUploadSectionOnPageLoad(transferType)
    {
		
		 
	    //let transferType = document.querySelector('input[name="transferType"]:checked').value;
	    let cardTypeId = document.getElementById("cardTypeId").value;
	  
	    let uploadLabel = document.getElementById("uploadLabel");
	    let uploadSection = document.getElementById("uploadSection");


	    uploadSection.style.display = "flex";

	    if (transferType === "1") { // Within City
	        uploadLabel.innerText = "Upload Address Proof:";
	    } else { 
	        if (cardTypeId === "18" || cardTypeId === "24" ) {
	            uploadLabel.innerText = "Upload Transfer Order:";
	        } else {
	            uploadLabel.innerText = "Upload Address Proof:";
	        }
	    }
	
	}
	
		initPage();
	
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#BenId').val(arrpk[1]);
	
	    // alert("key>>>>>>>>>>>"+arrpk[1]);
		//gettrackingid();
		getfamilydetails();
	}
	else{
		hidePreloader();
		$('#divTrackingIdEntry').show();
		$('#PatTrackingidLbl').hide();
	}
		
	
	   var configJson={
			serviceName:"/getData/getWellnesscenter",
			comboId:"PatientWc",			
			callBackFunctionName:"commonPopulateCombo",
			defaultOption:{"optionValue":"","optionText":"Select City"},
		   
			
	   	}
	          callService(configJson);
	   	
	
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
	
	
});
function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	getBenificiaryDtl();
	getfamilydetails();
	getDependentDetail();
		

	 
	
	}
	

		
   function getfamilydetails()
   	{
	var benid=$('#benId').val();
		var Benid = benid.split("^")[0] ;
           if(Benid=='')
            {
             	alert("Plesae enter BenId");
	           return;
	
              }
              
              
                        
  var configJson={
    				serviceName:"/getData/getDependentMembers",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatefamilymembers",
    			 				
    			}
    		callService(configJson);
              }
              





	
/*		
function populatefamilymembers(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        return;
    }

    let indx = 1;
    $("#AutoNumber1 tbody").empty();

    if (dataJson["message"].indexOf("ERROR") < 0) {
		
		
		
		
        $.each(dataJson["data"], function (_, json) {
            let html = "<tr>"; 
           // alert('benid'+json["beneficiary Id"])
            // alert('memberid'+json["memberid"])

         //  html += `<td class='slno'>${indx}</td>`;
            html += `<td><input type='checkbox' class='rowCheckbox' value='${json["beneficiary Id"] ? json["beneficiary Id"] : ''}' /></td>`; 
               html += "<td>" + json["beneficiary Id"] + "</td>"; 
                html += `<td>${json["Dob"] ? json["Dob"] : ''}</td>`;
            html += `<td>${json["memberName"] ? json["memberName"] : ''}</td>`;
           
         
            html += `<td>${json["gender"] ? json["gender"] : ''}</td>`;
               html += `<td>${json["Relation"] ? json["Relation"] : ''}</td>`;
               
               
           // html += `<td>${json["Photo"] ? json["Photo"] : ''}</td>`;
           
            
        
             if (json["Photo"]) {
				 
                getImage(json["Photo"]).then(base64Image => {
                    if (base64Image) {
						alert('base64Image'+base64Image)
                        html += `<td><img src="data:image/jpeg;base64,${base64Image}" alt="Photo" width="50" height="50" /></td>`;
                    } else {
                        html += `<td>No Photo</td>`; // In case the image is not found
                    }
                   })}
           
           
           
           
            html += `<td>${json["mobileNo"] ? json["mobileNo"] : ''}</td>`;
            html += "</tr>";

            $("#AutoNumber1 tbody").append(html);
            indx++;
        });
    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
    }
}
*/	  
	
	
function populatefamilymembers(configJson, dataJson) {
    if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        return;
    }

    let indx = 1;
    $("#AutoNumber1 tbody").empty();

    if (dataJson["message"].indexOf("ERROR") < 0) {
        
        let rowPromises = [];

        $.each(dataJson["data"], function (_, json) {
            let rowPromise = new Promise((resolve) => {
                let html = "<tr>"; 
                html += `<td><input type='checkbox' class='rowCheckbox' value='${json["beneficiary Id"] ? json["beneficiary Id"] : ''}' /></td>`; 
                html += "<td>" + json["beneficiary Id"] + "</td>"; 
                html += `<td>${json["Dob"] ? json["Dob"] : ''}</td>`;
                html += `<td>${json["memberName"] ? json["memberName"] : ''}</td>`;
                html += `<td>${json["gender"] ? json["gender"] : ''}</td>`;
                html += `<td>${json["Relation"] ? json["Relation"] : ''}</td>`;
                html += `<td>${json["mobileNo"] ? json["mobileNo"] : ''}</td>`;
                
                //alert('photo'+json["Photoname"]);
                	//$('#patimgDivNew').html(json["Photoname"]);
                	  // Default dummy image path (you can use a URL or base64 image)
                const dummyImagePath = '/HIS/hisglobal/images/img_avatar_Male.png';  // Example placeholder image
        
                if (json["Photoname"]) {
                    getImage(json["Photoname"]).then(base64Image => {
                        if (base64Image) {
                           
                         /*   html += `<td><img src="data:image/jpeg;base64,${base64Image}" alt="Photo" width="50" height="50" /></td>`;*/
                           html += `<td><img src="data:image/jpeg;base64,${base64Image || 'fallbackBase64Image'}" alt="Photo" width="50" height="50" /></td>`;
                        } else {
							 html += `<td><img src="${dummyImagePath}" alt="Photo" width="50" height="50" /></td>`;  // Handle image fetch failure
                            //html += `<td>No Photo</td>`; // If no image is found, show "No Photo"
                        }
                        resolve(html + "</tr>");  // Resolve the row Promise
                    }).catch(() => {
                        //html += `<td>No Photo</td></tr>`;  // Handle case if image fetching fails
                         html += `<td><img src="${dummyImagePath}" alt="Photo" width="50" height="50" /></td>`;  // Handle image fetch failure
                        resolve(html);  // Resolve even if image fetching fails
                    });
                } else {
                    //html += `<td>No Photo</td></tr>`;  // If no photo data is available
                     html += `<td><img src="${dummyImagePath}" alt="Photo" width="50" height="50" /></td>`;  // Handle image fetch failure
                    resolve(html);  // Resolve immediately if no photo is available
                }
            });

            rowPromises.push(rowPromise);  // Add the row Promise to the list
        });

        // Wait for all rowPromises to complete, then append them to the table
        Promise.all(rowPromises).then(rows => {
            $("#AutoNumber1 tbody").append(rows.join(""));  // Append all rows at once
        });

    } else {
        showAlertMsg("Kindly enter valid range in field!", "danger", "alertMsg");
    }
}

function getImage(fileName) {
    //alert('fileName: ' + fileName);
    return new Promise((resolve, reject) => {
        const folderName = 'CGHS_PROFILE_PICS';  // Folder where images are stored
        const imageUrl = `/CGHSCardMgmt/FormFlowXACTION?hmode=viewImage&fileName=${encodeURIComponent(fileName)}&folderName=${encodeURIComponent(folderName)}`;

        fetch(imageUrl)
            .then(response => {
                if (response.ok) {
                    return response.blob();  // Get the image as a blob
                } else {
                    reject("Image not found");
                }
            })
            .then(blob => {
                // Convert the blob to a base64 string
                const reader = new FileReader();
                reader.onloadend = function() {
                    resolve(reader.result.split(',')[1]);  // Extract base64 string (ignore the data URL prefix)
                };
                reader.readAsDataURL(blob);  // Read the blob as a Data URL
            })
            .catch(() => {
                reject("Error fetching image");
            });
    });
}

/*
function getImage(fileName) {
	alert('fileName'+fileName);
    return new Promise((resolve, reject) => {
        const folderName = 'CGHS_PROFILE_PICS';  // Folder where images are stored

        const imageUrl = `/CGHSCardMgmt/FormFlowXACTION?hmode=viewImage&fileName=${encodeURIComponent(fileName)}&folderName=${encodeURIComponent(folderName)}`;
         //const imageUrl = `/CGHSCardMgmt/FormFlowXACTION?hmode=viewImage&fileName=${fileName}&folderName=${folderName}`;

        fetch(imageUrl)
            .then(response => {
                if (response.ok) {
                    return response.text();  // Assuming the response is base64 string
                } else {
                    reject("Image not found");
                }
            })
            .then(base64Image => {
                resolve(base64Image);  // Return the base64 string to the caller
            })
            .catch(() => {
                reject("Error fetching image");
            });
    });
}
	*/
	
function ApprovebyAd()
{
	//alert("4444444444");
	 /*if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    */
   // showPreloader("Saving Data Please Wait !");
   // alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/CardApprovedbyAd",
        callBackFunctionName: "callbackSaveData1",
        inputData: processSerializeArray("ENTRYFORM")
    };

    // Call the service
    callService(configJson);
}


	
	
	
	
	
function callbackSaveData1(configJson, dataJson){
	
	//alert(JSON.stringify(configJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage1","parameterJson":{}}
		
		showMsg(dataJson["message"],dialogConfigJson)
	}
}
	
  
function resetPage1(){
//alert("iinn reset page");
	alert("Application Approved")
}

function handleDecision()

{
	
	 const approveButton = document.getElementById('approve');
        const rejectButton = document.getElementById('reject');
	 if (approveButton.checked) {
                alert("You have approved.");
                $('#remarksbox').hide();
                $('#statusflag').val("4")
            } else if (rejectButton.checked) {
               alert("You have rejected.");
                $('#statusflag').val("9")
                $('#remarksbox').show();
               
            } else {
                resultDiv.textContent = "Please select an option.";
                resultDiv.style.color = "black";
            }
       } 	  
  function GenerateBenId()
{
//	 alert("1111111111111");
	
    // Validate form inputs
    if (ValidateForAllVisible("ENTRYFORM") === false) {
        return;
    }
    
    showPreloader("Saving Data Please Wait !");
   //  alert("333333333");
    // Prepare the configJson object
    var configJson = {
        serviceName: "/DMLSAVE/OnlineBenidGenerate",
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
//alert("iinn reset page");
	  submitFormMaster("DAOnlineBenidgenerate","add");	
}	


function getBenificiaryDtl(){
	
	
		var Benid=$('#benId').val();
		var benId = Benid.split("^")[0] ;


	if(benId=='null'||benId==''||benId==undefined||benId==null){
		
		alert("Please Enter Benificiary Id");
		
		return;
		
		
	}
	
	
	 var configJson={
    				serviceName:"/getData/getBenDtl",
    				primaryKeys:[benId],			
    				callBackFunctionName:"PopulateBenificiaryDtls",
    			 				
    			}
    		callService(configJson);

	
	
	
	
	
}


function PopulateBenificiaryDtls(configJson, dataJson){
	
	
	//alert(JSON.stringify(dataJson));
	var jsonData=dataJson["data"];
	
	var html="";
	
		 if(jsonData.length>0){
			 
			 $('#divBenificiaryId').addClass('hideData');
			 
			 $("#benificiaryId").prop("readonly", true);
			 
			 $('#btngo').prop('disabled', true);
			 
			 $('#benficDiv').removeClass('hideData');
			 
			 $('#otherDtlDiv').removeClass('hideData');

	var ben_status=1;
	var valid_status=1;
	$.each(jsonData,function(indx, rowJson){
		/*html+="<div class='row form-group'>";*/

	
	var cardTypeElement = document.getElementById("cardTypeId");
if (cardTypeElement && rowJson["card_type"]) {
    var cardParts = rowJson["card_type"].split("^");
  
    if (cardParts.length > 2) {
        cardTypeElement.value = cardParts[2];  
    } else {
        console.error("Invalid card_type format:", rowJson["card_type"]);
    }
} else {
    console.error("Element not found or card_type is undefined.");
}

	
	
		ben_status=rowJson["ben_status"];
		valid_status=rowJson["valid_status"];
		
		$('#patNamePrescriptionPanel').html(rowJson["Name"]);
		$('#patimgDiv').html(rowJson["Photograph"]);
		$('#patCrNoPrescriptionPanel').html(rowJson["Benificiary Id"]);
		$('#patGenAgeCatPrescriptionPanel').html(rowJson["Gender"]+'&nbsp;/&nbsp;'+rowJson["AGE"]+'&nbsp;/&nbsp;'+rowJson["Mobile No."]);
		$('#cardType').html(rowJson["card_type"].split("^")[0]);
		$('#cardValidityDate').html(rowJson["Expiry_date"]);
		$('#relation').html(rowJson["relation"]);
		
		if(rowJson["card_type"].split("^")[1]!=""){
			 $('#benficDiv').addClass("patHeader-"+rowJson["card_type"].split("^")[1]);

		}
		else{
			$('#benficDiv').addClass("patHeader-default");
		}
		

		
		})
		
		var benId=$('#benificiaryId').val();
		
		
			if(ben_status==6 || valid_status==0){
				$('#otherDtlDiv').addClass('hideData');
				showMsg("Card Is Expired Or Not Approved !!",null);
				
				//$('#dataMsg').show().html("No Record Found").addClass("alert-danger").removeClass("alert-info");
				$('#dataMsgExpire').show().html("Card Is Expired Or Not Approved !!").addClass("alert-danger").removeClass("alert-info");
				return;
			}
			else{
			
			var configJson={
    				serviceName:"/getData/getApptdtl",
    				primaryKeys:[benId],			
    				callBackFunctionName:"PopulateApptDtls",
    			 				
    			}
    		callService(configJson);
    		
    		var configJson={
    				serviceName:"/getData/gettodaybenvisitdtl",
    				primaryKeys:[benId],			
    				callBackFunctionName:"PopulateVisitDtls",
    			 				
    			}
    		callService(configJson);
    		
    		
    		
    		
    		
    		var configJson={
    				serviceName:"/getData/getEpisodesdtlForReg",
    				primaryKeys:[benId],			
    				callBackFunctionName:"PopulateEpisodeDtls",
    			 				
    			}
    		callService(configJson);
    		
    		
    		}
		
		
		
		}
		else{
			alert("No record Found !!");
		}
	
	
	
	

              
              
              
              



	  
	
}

