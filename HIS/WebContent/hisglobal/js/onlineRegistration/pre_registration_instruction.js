 function redirect()
	     {
       	
        if(document.getElementById("patType1").checked){
       		 document.getElementById("div3").style.display="";
       		 document.getElementById("div2").style.display="none";
       	}else{
       		 document.getElementById("div3").style.display="none";
       		 document.getElementById("div2").style.display="";
       	}
       	
        	
	    	 
	     }
      

        function proceedNew()
        {		
        	window.open('/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationNewServlet','_self'); 
        
        }

		function langInstructions(language)
		{
			if(language=="English")
				{
				document.getElementById("hindi").style.display = "none";
				document.getElementById("punjabi").style.display = "none";
				document.getElementById("english").style.display = "block";
				}
			else if(language=="Hindi")
			{				
				document.getElementById("hindi").style.display = "block";
				document.getElementById("punjabi").style.display = "none";
				document.getElementById("english").style.display = "none";
			}
			else{
				document.getElementById("hindi").style.display = "none";
				document.getElementById("punjabi").style.display = "block";
				document.getElementById("english").style.display = "none";
				}
			}

		   function generateOtp()
	        {
			  
			   if(document.getElementById("crno").value!='')
	    		{
	        		
	        		if(document.getElementById("crno").value.length==16)
	        		
	    			{
	        			var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	        			
	    	    		var data="mode=CHECKCRNO&crNo="+$("#crno").val();//+"&patContactNo="+$('[name="patContactNo"]').val();//patContactNo
	    	    		
	    	    		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
	    	    			{
	    	    			      var statusArr= result.split("#");
	    	    			      var status=statusArr[0];
	    	    			      var mobNo=statusArr[1];
	    	    			      $("#patContactNo").val(mobNo);
	    	    			      var emailId=statusArr[2];	  
	    	    			      $("#patEmail").val(emailId);
	    	    			      if(emailId=="0")
	    	    			    	  {
	    	    			    	  emailId="";  }	    	    			   	    			 	    	    			    	  
	    	        			if(status=="0"){ 
	    	        				$("#lable1").html("<font color='red'><b>No Patient Found with This CR No.</b></font>");
	    	        				document.getElementById("crno").focus();
	    	        			}else if(status=="1"){ 
	    	        				
	    	        				if(mobNo=="0")
	    	        					{
	    	        					$("#lable1").html("No Mobile number is registered against this CR No. Kindly contact Registration Counter for Revisit.");
	    	        					}
	    	        				else{
	    	        					if(mobNo.length<=9||mobNo.length>=11)
	    	        					{
	    	        						$("#lable1").html("Registered Mobile No. Is Not Valid.");
	    	        					}
	    	        					else
	    	        					{
	    	        						var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	    	        	    	    		var data="mode=SENDOPT&crNo="+$("#crno").val()+"&patContactNo="+mobNo+"&patEmail="+emailId;
	    	        	    	    		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
	    	        	    	    			{
		    	        	    	    			
	    	        	    	    			var displayMobNo= mobNo.substring(6,10);
	    	        	    	    			$("#registrationStatus").modal();
//	    	        	    	    			openCustomPopup('#registrationStatus',450,200);
	    	        	    	    			$("#OTPMobile").html("<font color='blue'><b>OTP has been sent to your Mobile No. ******"+displayMobNo+"</b></font>");
//	    	        	    	    			$("#popupLaunch").click();
	    	        	    	          		setTimerForOTP();
	    	        	    	    			} 
	    	        	    	    		});
	    	        	    	    		
	    	        				    }
	    	        					} 
	    	        			} 
	    	        		}
	    	    		});
	    				
	    			
	    			}
	    			else
	    			{
	    				$("#lable1").html("<font color='red'><b>Kindly Enter 16 Digit CR No.</b></font>");
	    				document.getElementById("crno").focus();
	    				return false;
	    			}
	    		}	
	    		else
	    		{
	    			$("#lable1").html("<font color='red'><b>Kindly Enter CR No.</b></font>");
	    			document.getElementById("crno").focus();
	    			return false;
	    		}
	    			//reset();
	        }
	         

	          

 function countdown( elementName, minutes, seconds )
{
	
    var element, endTime, hours, mins, msLeft, time;

    function twoDigits( n )
    {
        return (n <= 9 ? "0" + n : n);
    }

	    function updateTimer()
	    {
	        msLeft = endTime - (+new Date);
	        if ( msLeft < 1000 ) {
	        
	        
	        var patContactNo=$('[name="patContactNo"]').val();
	      	 var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		       var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
		    	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
		    	{
		    	if(result=="1")
		    	{
		    	$("#OTPMobile").html("<font color='red'><b>Time Expired. Kindly click on 'Resend OTP'.</b></font>");
	            element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
		      	}	   	
		    	} 
		    	});
		    	  } else {
	            time = new Date( msLeft );
	            hours = time.getUTCHours();
	            mins = time.getUTCMinutes();
	            element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
	            setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );
	        }
	    }
	
	    element = document.getElementById( elementName );
	    endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
	    updateTimer();
		
	}

 
 

	        
function proceedOld()
	{
	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data="mode=VALIDATEOTP&crNo="+$("#crno").val()+"&otp="+$("#otp").val();
	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
		{
		if(result=="1")
			{
//			closeModal();
			window.open('/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationoldServlet','_self');
			//document.getElementById("tr2").style.display="none";
			document.getElementById("OldNext").style.display="none";
			document.getElementById("OldOTP").style.display="";
//			document.getElementById("patType").value="1";
			$("#lable1").html("");
			document.getElementById("crno").value="";
			document.getElementById("otp").value="";
			document.getElementById("crno").disabled=true;
			redirect();
			}
		else if (result == "2") {
			//alert("2")//submitForm();
			//	$("#lable1").html("OTP Entered is Incorrect. Enter OTP again.");
			$("#OTPMobile")
					.html(
							"<font color='red'><b>Incorrect OTP. Enter the correct OTP.</b></font>");
			//$("#registrationStatus").modal();
		} else if (result == "3") {
			$("#OTPMobile")
					.html(
							"<font color='red'><b>OTP Expired. Kindly Try again.</b></font>");
		}	 
		}
	});
		
	}
function resendOTP()
{ 
	var mobNo=$('[name="patContactNo"]').val();
	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data="mode=SENDOPT&crNo="+$("#crno").val()+"&patContactNo="+mobNo+"&patEmail="+$('[name="patEmail"]').val();
	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
		{
			
		var displayMobNo= $('[name="patContactNo"]').val().substring(6,10);
		$("#registrationStatus").modal();
//		openCustomPopup('#registrationStatus',450,200);
		$("#lable1").html("OTP has been sent to your Mobile No. ******"+displayMobNo);

		setTimerForOTP();
		}
	});
   	     }


function setTimerForOTP(){


	  
	   
	   document.getElementById("btnresend").disabled = true;
	   document.getElementById("btnsave").disabled = false;
	   
	// Set the date we're counting down to
	   var countDownDate = new Date(new Date().getTime() + 1*60000);

	   // Update the count down every 1 second
	   var x = setInterval(function() {

	     // Get today's date and time
	     var now = new Date().getTime();
	       
	     // Find the distance between now and the count down date
	     var distance = countDownDate - now;
	       
	     // Time calculations for days, hours, minutes and seconds
	     var days = Math.floor(distance / (1000 * 60 * 60 * 24));
	     var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
	     var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
	     var seconds = Math.floor((distance % (1000 * 60)) / 1000);
	       
	     // Output the result in an element with id="demo"
	     document.getElementById("btnresend").innerHTML =  "Resend OTP ("+seconds + "s)";
	       
	     // If the count down is over, write some text 
	     if (distance < 0) {
	       clearInterval(x);
	       document.getElementById("btnresend").innerHTML =  "Resend OTP";
	       document.getElementById("btnresend").disabled = false;
	       document.getElementById("btnsave").disabled = true;
	   	document.getElementById("OTPMobile").innerHTML = "<font color='red'><b>Time Expired. Kindly click on 'Resend OTP'.</b></font>";

	       
	     }
	   }, 1000);
	   
	   
	   }

	function countdown( elementName, minutes, seconds )
	{

	var element, endTime, hours, mins, msLeft, time;

	function twoDigits( n )
	{
	return (n <= 9 ? "0" + n : n);
	}

	function updateTimer()
	{
	msLeft = endTime - (+new Date);
	if ( msLeft < 1000 ) {


	var patContactNo=$('[name="patContactNo"]').val();
	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data="mode=EXPIREOTP&crNo="+$("#crno").val()+"&patContactNo="+$('[name="patContactNo"]').val()+"&patEmail="+$('[name="patEmail"]').val();
//	var action="";
//		<%--  var action="<%=context_path%>LabRptRegistrationServlet"; --%>
//		var urlNew="/AHIMSG5/hislogin/transactions/action/EXPIREOTPLgnFtr";
//		var data="mode=SENDOTP"+"&varNewMobileNumber="+$('#mobileNoFormat').val();
//		urlNew = createFHashAjaxQuery(urlNew+"?"+data);
//		
		
	  // var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
		$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
		{
		if(result=="1")
		{
		$("#OTPMobile").html("Time Expired. Kindly click on 'Resend OTP'.");
	    element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
	  	}	   	
		} 
		});
		  } else {
	    time = new Date( msLeft );
	    hours = time.getUTCHours();
	    mins = time.getUTCMinutes();
	    element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
	    setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );

	    alert("time"+time);
	}
	}

	element = document.getElementById( elementName );
	endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
	alert("endtime"+endTime);
	updateTimer();

	}











//function reset(){
//    $('[name="patContactNo"]').val('');
//  	
//  	document.forms[0].reset();
//  	return;
//  	
//  }

	function validateBhamashahId()
	        {
	        	if(document.getElementById("bhamashahId").value!='')
	    		{
	        		if(document.getElementById("bhamashahId").value.length==15)
	    			{
	        			var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	        			//alert('action'+action);
	    	    		var data="mode=CHECKBHAMASHAHSHID&crNo="+$("#bhamashahId").val();
	    	    		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
	    	    			{
	    	    			      var statusArr= result.split("#");
	    	    			      var status=statusArr[0];
	    	    			      var mobNo=statusArr[1];
	    	        			if(status=="0"){ 
	    	        				$("#lable1").html("No Patient Found with This CR NO!");
	    	        				document.getElementById("crno").focus();
	    	        			}else if(status=="1"){ 
	    	        				//alert(mobNo.length);
	    	        				if(mobNo=="0")
	    	        					{
	    	        					$("#lable1").html("Your mobile number is not registered. Please contact Registration Counter first.");
	    	        					}
	    	        				else{
	    	        					if(mobNo.length<=9||mobNo.length>=11)
	    	        					{
	    	        						$("#lable1").html("Registered Mobile No Is Not Valid! ");
	    	        					}
	    	        					else
	    	        					{
	    	        						var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	    	        	    	    		var data="mode=SENDOTP&crNo="+$("#bhamashahId").val()+"&patContactNo="+mobNo;
	    	        	    	    		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
	    	        	    	    			{
	    	        	    	    			var displayMobNo= mobNo.substring(6,10);
	    	        	    	    			$("#lable1").html("OTP has been sent to your Mobile No. ******"+displayMobNo);
	    	        	    	    			 document.getElementById("OldOTP").style.display="none";
	    	        	    	    			 document.getElementById("OldNext").style.display="";
	    	        	    	    			 document.getElementById("otp").value='';
	    	        	    	    			 document.getElementById("tr2").style.display="";
	    	        	    	    			 document.getElementById("crno").disabled=true;
	    	        	    	    			} 
	    	        	    	    		});
	    	        	    	    		
	    	        				    }
	    	        					}
	    	        			}
	    	        		}
	    	    		});
	    				
	        			
	    			}
	    			else
	    			{
	    				$("#lable1").html("Please Enter 15 Digit CR NO!");
	    				document.getElementById("crno").focus();
	    				return false;
	    			}
	    		}	
	    		else
	    		{
	    			$("#lable1").html("Please Enter CR NO!");
	    			document.getElementById("crno").focus();
	    			return false;
	    		}
	    			
	        }
	        
	        function back()
	        {	
	        	 document.getElementById("div1").style.display="";
	    		 document.getElementById("div2").style.display="none";
	    		 document.getElementById("div3").style.display="none";
	    		 //document.getElementById("patType1").value=" ";
	    		 $("#patType1"). prop("checked", false);
	    		 $("#patType2"). prop("checked", false);
	    		// document.getElementById("patType2").value=" ";
	    		 document.getElementById("crno").value = "";
	    		 $("#lable1").html(" ");
	        }
/*
	      //Timer Check   
	        var seconds = 100;//300; //change 120 for any number you want, it's the seconds //
	        function secondPassed() {
	        	 var element;
	            var minutes = Math.round((seconds - 30)/60);
	            var remainingSeconds = seconds % 60;
	            if (remainingSeconds < 10) {
	                remainingSeconds = "0" + remainingSeconds;  
	            }
	            document.getElementById('countdown').innerHTML = minutes + ":" + remainingSeconds;
	            if (seconds == 0) {
	            	
	                clearInterval(countdownTimer);
	                document.getElementById('countdown').innerHTML = '<input type="button"  value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="proceedOld()">';
	                
	                
	            } else {
	                seconds--;
	            }
	        }
	         
	        var countdownTimer = setInterval('secondPassed()', 1000);
	        //Timer Check//removed by New Timer --Devika
	        */
	        $("#button").click(function () {        
	            $("#pop").close;
	               });
	        
	        
	        function closewindow() {   
//	        	alert("djdj");
	        	$('#modal').modal('toggle'); 
	            return false;
	        }
	    
	        $(document).ready(function(){
	    		
	    		
	  		  $("#closeModalID").click(function(){
	  			 $("#registrationStatus").hide();
	  		  });
	  		 
	  		});