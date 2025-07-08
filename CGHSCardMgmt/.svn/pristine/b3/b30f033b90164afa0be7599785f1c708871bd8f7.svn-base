$(document).ready(function () {
   	hidePreloader();
	
	//alert('Hello');
	var txnId = sessionStorage.getItem("txnId");
	  //  alert("Transaction ID from session storage in cardrenwalview: " + txnId);
	var configJson={
	   				serviceName:"/getData/getRenewalTrakingDtls",
	   				primaryKeys:txnId,			
	   				callBackFunctionName:"populateApplictionTrakingDtls",
	   			 				
	   			}
	   		callService(configJson);
			
			
			
			
	
	});
	
	
	function populateApplictionTrakingDtls(configJson, dataJson) { //alert ("populateApplictionTrakingDtls") ;
	    	    //alert("configJson>>> " + JSON.stringify(configJson));
	    	  // alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));

	    	 
									
						
	    	    	 $('#getrenewalstatus').show();
	    	    	
	    	    let indx = 1;
	    	    const tableBody = $("#getrenewalstatus tbody");
	    	    tableBody.empty();
	    	    var trackingId="";
	    	    // checking if error exists
	    	    if(dataJson["message"].indexOf("ERROR")<0){
	        	    $.each(dataJson["data"], function(_, json){
	              var statusflagapplication=json["statusid"];
						//alert("statusflagapplication");
						var trackingid=json["Trackingid"];
						//alert("trackingid>>>>"+trackingid);
					$('#hiddentrackingid').val(trackingid);
					 trackingId=json["Trackingid"];
	        	    	let html = "<tr>";
	          	        html += "<td class='paymentslno'>" + indx + "</td>";
	          	        html += "<td>" + json["Trackingid"] + "</td>"; 
	          	        html += "<td>" + json["FirstName"] + "</td>";
	          	        html += "<td>" + json["applyDate"] + "</td>";
	          	        html += "<td>" + json["CardType"] + "</td>";
	          	        html += "<td>" + json["gstr_cardtype_name"] + "</td>";
	                	  html += "<td>" + json["MobileNo"] + "</td>";
	          	         html += "<td>" + json["gstr_application_status"] + "</td>";
	          	         	html += "<td>" + json["Rejremarks"] + "</td>";
							/*html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
							html += "<td><a class='btn-his-sm' onclick='CancelApplication(\"" + trackingId + "\")'>Cancel</a></td>";*/
	          	         
	          	     /*if(statusflagapplication=="15"){

						html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
						html += "<td><a class='btn-his-sm' onclick='ApplyRenewal()'>Re-Apply</a></td>";
	                      }*/
						  if(statusflagapplication=="16"){

						  						html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
						  						html += "<td><a class='btn-his-sm' onclick='ApplyRenewal(\"" + trackingId + "\")'>Re-Apply</a></td>";
						  	                      }
	                   
						  else if(statusflagapplication=="2")
						  {
					         html += "<td><a class='btn-his-sm' onclick='CancelApplication(\"" + trackingId + "\")'>Cancel</a></td>";
					    
					        html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";


						  }
						   else{
					 html += "<td><a class='btn-his-sm' onclick='viewItem(\"" + trackingId + "\")'>View</a></td>";
					// html += "<td><a class='btn btn-his-sm' onclick='CancelApplication()'>Cancel</a></td>";
				  }
	          	       html += "</tr>";
	          	        trackingId=json["Trackingid"];
	          	        tableBody.append(html);
	            	    });
	        	     	/* var index = 1;
	    $('.paymentslno').each(function() {
	        $(this).text(index);
	        index++;
	            });
	            var configJson={
	          				serviceName:"/getData/getonlineformhtml",
	          				primaryKeys:[document.getElementById('hiddenmobile').value],
	          				"trackingId":trackingId, 
	          				callBackFunctionName:"populateonlineformhtml",
	          			 				
	          			}
	          		callService(configJson);
	        	    */
	        	}
	    	    else{
	    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
	    	    	return;
	    	    }
	        	    	    
	    	}

			
			function viewItem(trackingId)
			    	{
						//alert("trackingid>>>>>>>>"+trackingId);
						
						   var configJson={
			          				serviceName:"/getData/getonlineformhtml",
			          				primaryKeys:[trackingId],
			          				"trackingId":trackingId, 
			                 	callBackFunctionName:"populateonlineformhtml",
			          			 				
			          			}
			          		callService(configJson);
			        	//alert("11111111");        	
			            $('#myModal').modal('show');
			        }
					
					function CancelApplication(trackingId)
					{  	//var formData = processSerializeArray("ENTRYFORM");
					    //alert("trackingId " + trackingId);

						
					    // Prepare the configJson object
					    var configJson = {
					        serviceName: "/DMLSAVE/updatestatuscancelrenewal",
							primaryKeys:[trackingId],
					        callBackFunctionName: "callbackSaveDataUpdatestatuscancelrenewal",
					      // inputData: processSerializeArray("ENTRYFORM")
					    };
					    
					    // Call the service
					    callService(configJson);

					}
							
					    		
					function callbackSaveDataUpdatestatuscancelrenewal(configJson, dataJson){
						
						//alert("config json>>>>>>>>>>>>>>>>>"+JSON.stringify(configJson));
						if(dataJson["message"].indexOf("ERROR")>=0){
							showMsg(dataJson["message"],null)
						}
						else{
							var dialogConfigJson={callOnOK:"resetPageUpdatestatuscancelwithdraw","parameterJson":{}}
							
							showMsg(dataJson["message"],dialogConfigJson)
						}
					}
						
					  
					function resetPageUpdatestatuscancelwithdraw(){
					//alert("iinn reset page");f
						//alert("send application to Beneficiary");
						 window.location.reload();
							
					}
					/*function ApplyRenewal()
					{
					alert("ApplyRenewal");
					//window.location.href = "cardrenwal";
					
					sessionStorage.setItem("txnId", Trackingid);
										
										$('#masterKey').val("CardRenewalStatus");
										   submitFormWithResetTextField("CallMasterPage");
					}*/
					
					
					function ApplyRenewal()
										{
										//alert("ApplyRenewal");
										//window.location.href = "cardrenwal";
										//sessionStorage.setItem("renewal", "1");
										
										$('#masterKey').val("CardRenewalStatus"); 
										    submitFormMaster("CardRenewal", "add");
										}
					function populateonlineformhtml(configJson, dataJson) 
					    {
					    	// alert("configJson populateonlineformhtml>>> " + JSON.stringify(configJson));
					    	 //alert("dataJson populateonlineformhtml>>>>>>>> " + JSON.stringify(dataJson));
					    	  if(dataJson["message"].indexOf("ERROR")<0){
					    	  $.each(dataJson["data"], function(_, json){
					    		  if (json.hasOwnProperty('formhtml')) {
					    	           // alert("formhtml: " + json["formhtml"]);

					    	          var decrypthtml=  decryptBase64(json["formhtml"])
					    	         // sssalert("decrypthtml>>>>>>>>>: "+ decrypthtml);
					    	          decrypthtml=decrypthtml.replace("#trackingId#", configJson["trackingId"]);
					    	          
					    	          document.getElementById("formContainer").innerHTML = decrypthtml;
					    	     
					    		    	        } else {
					    	            //alert("formhtml key not found in: " + JSON.stringify(json));
					    	        }
					    	  });

					    	}
					    	  else
						    	  {
					    		  showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
					    	    	return;
						    	  }
					    }
						
						
						function printFormContainer() {
						    var printContents = document.getElementById("formContainer").innerHTML;
						    var originalContents = document.body.innerHTML;

						    var printWindow = window.open('', '', 'height=700,width=900');
						    printWindow.document.write('<html><head><title>Print Form</title>');
						    printWindow.document.write('<link rel="stylesheet" href="your-bootstrap-path/bootstrap.min.css">'); 
						    printWindow.document.write('<style>body{font-family:Arial; padding:20px;} table { width: 100%; border-collapse: collapse; } th, td { border: 1px solid #ddd; padding: 8px; }</style>');
						    printWindow.document.write('</head><body>');
						    printWindow.document.write(printContents);
						    printWindow.document.write('</body></html>');
						    printWindow.document.close();
						    printWindow.focus();

						    printWindow.print();
						    printWindow.close();
						}

			    	