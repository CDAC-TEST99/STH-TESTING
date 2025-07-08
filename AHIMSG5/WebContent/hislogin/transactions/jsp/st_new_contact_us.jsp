<html>

<head>

    <title>Contact Us</title>

    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet" >
	<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
	<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/popper.min.js" ></script>
	<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.min.js"></script>
	
	<script src="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/5571ef2661.js" ></script>
	
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"  ></script>
	
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"  ></script>
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.easing.min.js"  ></script>
	<script src="/HIS/hisglobal/cdac_awesome/animate-scroll-back-top/jquery.backtothetop.min.js"  ></script>
	<link href="/HIS/hisglobal/cdac_awesome/css/cdac_preset1.css" rel="stylesheet" >
	
    <script language="JavaScript" type="text/javascript" src="/HIS/hisglobal/js/jquery/jqueryExtValidation.js"></script>
    <script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
    
 

    <script type="text/javascript">
        $(document).ready(function () {

        		$('#preloader').delay(450).fadeOut('slow');
        	       $('body').delay(450).css({
        	        'overflow': 'visible'
        	      }); 	
                $('#idCancel').click(function (e) {
                    //window.parent.location = window.parent.location.href;
                    parent.refershMain();
                    parent.closeModal();
                    e.preventDefault();
                });

                var current_fs, next_fs, previous_fs; //fieldsets
                var opacity;

                $(".next").click(
                    function (e) {
                    	e.preventDefault();

                  //  	alert("inside next")
                    	
                    var htypeVal = $("#htype").val();

                    if(htypeVal == 0){
                    	$("#htype").focus();
         				$("#htypecheck").show();
         				return false;
                        }else{
                        	$("#htypecheck").hide();
                         }	  
                    	
                   	// validateUsername();
                 	var userName = document.getElementsByName("uname")[0].value;
         			if(userName == "") {
         				$("#uname").focus();
         				$("#unamecheck").show();
         				return false;
         			}
         		 	// validateEmail();
         			var email = document.getElementsByName("email")[0].value;   	  
         			if(email == "") {
         				$("#email").focus();
         				$("#emailcheck").show();
         				return false;
         			}
         			var phone = document.getElementsByName("phone")[0].value;   	  
         			if(phone == "") {
             			
         				$("#phone").focus();
         				$("#phonecheck").show();
         				return false;
         			}
         //			$('[name="phone"]').validatebox({
        	//			required : true,
        	//			validType : [ 'numericwithoutspace', 'equalLengthNumeric[10]','DisableAllZero','mobileNostartwithseven']
        	//		});
         		//	 $('[name="patNationalId"]').validatebox({
     			//		validType : [ 'numeric','equalLength[10]']
     			//	});	
         	
         	
         	
         	
                        current_fs = $(this).closest("fieldset");
                        next_fs = $(this).closest("fieldset").next();

                     //	alert("inside next >> "+next_fs)
                     	
                    //	alert(current_fs.attr("id"));
                    	
                        if (current_fs.attr("id") == 'accountfs') {

                    //    	alert("inside current "+current_fs.attr("id"));
                        	
                        	if(!(validateCombo('htype' , 'Institute Type') &&  validateName('uname' , 'Contact Person') && validateEmail('email' , 'Email') && validatePhone('phone' , 'Mobile No.')))
                        		return false;
                            

                            		var form=$("#msform");

                            		sortandEncodebase64($("#msform"));
                            		
                            	//	alert(JSON.stringify(form.serialize()))
                            		$('#preloader').show();
                            		$.ajax({
                            	        type:"POST",
                            	        url:'/AHIMSG5/hislogin/saveContactUsLgnFtr',
                            	        data:form.serialize(),
                            	        success: function(response){
                            	        	$('#preloader').delay(450).fadeOut('slow');
                            	        	if(response.length == 0){

                            	        		alert("Something Went Wrong, Please try Again");
                            	        		$('#idCancel').trigger('click');
                            	        		return false;
                            	        		
                                	        }else{
                                	                                                 	      
                                	       	if(response.includes("Form Data Tampered")){

                                	       		$("#contactcontentId").hide();
                                	       		$("#contactimgId").html("");
                                	       		$("#contactimgId").hide();
                                	       		$("#sth").html(response);
                                	       		 
                                    	       	} 
                                     	    }
                            	            
                            	        	
                            	            
                            	            $("#progressbar li").eq(
                                                    $("fieldset").index(next_fs)).addClass(
                                                        "active");

                                                //show the next fieldset
                                                next_fs.show();
                                                //hide the current fieldset with style
                                                current_fs.animate({
                                                    opacity: 0
                                                }, {
                                                    step: function (now) {
                                                        // for making fielset appear animation
                                                        opacity = 1 - now;

                                                        current_fs.css({
                                                            'display': 'none',
                                                            'position': 'relative'
                                                        });
                                                        next_fs.css({
                                                            'opacity': opacity
                                                        });
                                                    },
                                                    duration: 600
                                                });
                            	            

                            	            
                            	        }
                            	    });
                            	                            		
                                	return false;
                                
                                }
                        

                        //Add Class Active
                        $("#progressbar li").eq(
                            $("fieldset").index(next_fs)).addClass(
                                "active");

                        //show the next fieldset
                        next_fs.show();
                        //hide the current fieldset with style
                        current_fs.animate({
                            opacity: 0
                        }, {
                            step: function (now) {
                                // for making fielset appear animation
                                opacity = 1 - now;

                                current_fs.css({
                                    'display': 'none',
                                    'position': 'relative'
                                });
                                next_fs.css({
                                    'opacity': opacity
                                });
                            },
                            duration: 600
                        });


                        if (current_fs.attr("id") == 'accountfs') {
                            countdown();
                        }


                    });

                $(".previous").click(
                    function () {

                        current_fs = $(this).parent();
                        previous_fs = $(this).parent().prev();

                        //Remove class active
                        $("#progressbar li").eq(
                            $("fieldset").index(current_fs))
                            .removeClass("active");

                        //show the previous fieldset
                        previous_fs.show();

                        //hide the current fieldset with style
                        current_fs.animate({
                            opacity: 0
                        }, {
                            step: function (now) {
                                // for making fielset appear animation
                                opacity = 1 - now;

                                current_fs.css({
                                    'display': 'none',
                                    'position': 'relative'
                                });
                                previous_fs.css({
                                    'opacity': opacity
                                });
                            },
                            duration: 600
                        });
                    });

                $('.radio-group .radio').click(function () {
                    $(this).parent().find('.radio').removeClass('selected');
                    $(this).addClass('selected');
                });

                $(".submit").click(function () {
                    return false;
                })


              
 
             
                

            });

        let usernameError = false;
        let emailError = false;
        let phoneError = false;
        let otpError = false;

        function validateName(id , label) {

        //	alert('inside validateName #'+id);
            
            var regex = /^[a-zA-Z .]*$/;

            let usernameValue = $('#'+id).val();
            if (usernameValue.length == 0) {

        //    	alert('#'+id+'check')
           	 
                $('#'+id+'check').show();
                $('#'+id+'check').focus();
                $('#'+id+'check').html(label+" is Required");

                usernameError = false;
                return false;
            }
            else if (!regex.test(usernameValue)) {
            	 console.log("inside user else reg alpha ");
            	 $('#'+id+'check').show();
            	 $('#'+id+'check').focus();
            	 $('#'+id+'check').html("Only aplhabets and space is allowed");
                usernameError = false;
                return false;
            }
            else {
            	 $('#'+id+'check').hide();
                usernameError = true;
            }
            return usernameError;
        }

        function validateEmail(id , label) {

            var regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

            let emailValue = $('#'+id).val();
            if (emailValue.length == 0) {
            	$('#'+id+'check').html(label+" is Required");
            	$('#'+id+'check').show();
                emailError = false;
                return false;
            }
            else if (!regex.test(emailValue)) {
            	$('#'+id+'check').show();
            	$('#'+id+'check').html("Please enter a correct "+label);
                emailError = false;
                return false;
            }
            else {
            	$('#'+id+'check').hide();
                emailError = true;
            }

            return emailError;
        }
        function validatePhone(id , label) {

            var regex = /^\(?([6-9]{1})\)?([0-9]{2})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;

            let phoneValue = $('#'+id).val();
            if (phoneValue.length == 0) {
                $('#'+id+'check').show();
                $('#'+id+'check').html(label+" is Required");

                phoneError = false;
                return false;
            }
            else if (!regex.test(phoneValue)) {
                $('#'+id+'check').show();
                $('#'+id+'check').html("Please enter a correct "+label);
                phoneError = false;
                return false;
            }
            else {
                $('#'+id+'check').hide();
                phoneError = true;
            }

            return phoneError;
        }


        function validateOTP(){


        	 var regex =  /(?<!\d)\d{5}(?!\d)/g;
        	 let otpValue = $("#otp").val();
        	 if(otpValue.length == 0){
        		  $('#otpcheck').show();
                  $('#otpcheck').html("OTP is Required");
                  otpError = false;
                  return false;
            	 }

        	 else if (!regex.test(otpValue)) {
                 $('#otpcheck').show();
                 $('#otpcheck').html("Please enter Numbers only");
                 otpError = false;
                 return false;
             }
             else {
                 $('#otpcheck').hide();
                 otpError = true;
             }

             return otpError;
        	 
            }

        function validateCombo(id,label) {
             
            let usernameValue = $('#'+id).val();
            if (usernameValue.split('^')[0] == 0) {
                $('#'+id+'check').show();
                $('#'+id+'check').focus();
                $('#'+id+'check').html(label+" is Required");
  
                return false;
            }
            else {
             
            	$('#'+id+'check').hide();
               return true;
            }
            return false;
        }
        


        
        function validateGST(id , label) {
        
           var regex = /^([0][1-9]|[1-2][0-9]|[3][0-8])[A-Z]{3}[ABCFGHLJPTF]{1}[A-Z]{1}[0-9]{4}[A-Z]{1}[1-9A-Z]{1}Z[0-9A-Z]{1}/;

           let usernameValue = $('#'+id).val();
           if (usernameValue.length == 0) {
         
               $('#'+id+'check').show();
               $('#'+id+'check').focus();
               $('#'+id+'check').html(label+" is Required");
 
               return false;
           }
           else if (!regex.test(usernameValue)) {
            
        	   $('#'+id+'check').show();
        	   $('#'+id+'check').focus();
        	   $('#'+id+'check').html("Enter Valid "+label);
             
               return false;
           }
           else {
            
        	   $('#'+id+'check').hide();
              return true;
           }
           return false;
       }
        
        
        
        function validateInstitutionName(id , label) {
        
           var regex = /^[a-zA-Z0-9 ]*$/;

           let usernameValue = $('#'+id).val();
           if (usernameValue.length == 0) {
         
               $('#'+id+'check').show();
               $('#'+id+'check').focus();
               $('#'+id+'check').html(label+" is Required");
 
               return false;
           }
           else if (!regex.test(usernameValue)) {
            
        	   $('#'+id+'check').show();
        	   $('#'+id+'check').focus();
        	   $('#'+id+'check').html("Enter Valid "+label);
             
               return false;
           }
           else {
            
        	   $('#'+id+'check').hide();
              return true;
           }
           return false;
       }


        function validateAddress(compName) {
            
            var regex = /^[ A-Za-z0-9 _@./#&+-]*$/;

            let usernameValue = $('#'+compName).val();
            if (usernameValue.length == 0) {
          
                $('#'+compName+'check').show();
                $('#'+compName+'check').focus();
                $('#'+compName+'check').html("Address is Required");
  
                return false;
            }
            else if (!regex.test(usernameValue)) {
             
                $('#'+compName+'check').show();
                $('#'+compName+'check').focus();
                $('#'+compName+'check').html("Address Institute Name");
              
                return false;
            }
            else {
             
                $('#'+compName+'check').hide();
               return true;
            }
            return false;
        }
        
         

        function validatePinCode(){


       	 var regex =  /(?<!\d)\d{6}(?!\d)/g;
       	 let otpValue = $("#pincode").val();
       	 if(otpValue.length == 0){
       		  $('#pincodecheck').show();
                 $('#pincodecheck').html("PinCode is Required");
                 
                 return false;
           	 }

       	 else if (!regex.test(otpValue)) {
                $('#pincodecheck').show();
                $('#pincodecheck').html("Please enter Numbers only");
              
                return false;
            }
            else {
                $('#pincodecheck').hide();
                return true;
            }

            return false;
       	 
           }
        
        
        function validateInitialFields() {
        

        	validateName('uname' , 'Contact Person');
     	var pathealthid = document.getElementsByName("uname")[0].value;
			if (pathealthid == "") {
				alert("Please enter User Name");
				$("#uname").focus();
				$("#usercheck").show();
				return false;
			}
            
            console.log("inside validate ");
            /*   $("#email").attr('required', true);
            $("#phone").attr('required', true);
            $("#uname").attr('required', true);
            console.log("inside validate "+ emailError+" "+phoneError+" user"+usernameError);
            validateUsername();

            if(usernameError == "false")
                 alert("Please enter Correct User Name"); */
            /*if((usernameError == "true"))
                  validatePhone();
else
	return false;


if(phoneError == "false")
     validateEmail();
else
	return false;
	
      if ((usernameError == "false") || (phoneError == "false") || (emailError == "false")) {
                // alert("Please Enter the Required Deatils");
                consple("inside false");
                return false;
            } */

        }
        function countdown() {
            var seconds = 60;
            function tick() {
                var counter = document.getElementById("counter");
                seconds--;
                counter.innerHTML = "0:" + (seconds < 10 ? "0" : "") + String(seconds);
                if (seconds > 0) {
                    setTimeout(tick, 1000);
                } else {
                    counter.innerHTML = '<a href="#">Resend OTP</a>';
                }
            }
            tick();
        }


        function Rs(amount) {
            var words = new Array();
            words[0] = 'Zero'; words[1] = 'One'; words[2] = 'Two'; words[3] = 'Three'; words[4] = 'Four'; words[5] = 'Five'; words[6] = 'Six'; words[7] = 'Seven'; words[8] = 'Eight'; words[9] = 'Nine'; words[10] = 'Ten'; words[11] = 'Eleven'; words[12] = 'Twelve'; words[13] = 'Thirteen'; words[14] = 'Fourteen'; words[15] = 'Fifteen'; words[16] = 'Sixteen'; words[17] = 'Seventeen'; words[18] = 'Eighteen'; words[19] = 'Nineteen'; words[20] = 'Twenty'; words[30] = 'Thirty'; words[40] = 'Forty'; words[50] = 'Fifty'; words[60] = 'Sixty'; words[70] = 'Seventy'; words[80] = 'Eighty'; words[90] = 'Ninety'; var op;
            amount = amount.toString();
            var atemp = amount.split('.');
            var number = atemp[0].split(',').join('');
            var n_length = number.length;
            var words_string = '';
            if (n_length <= 9) {
                var n_array = new Array(0, 0, 0, 0, 0, 0, 0, 0, 0);
                var received_n_array = new Array();
                for (var i = 0; i < n_length; i++) {
                    received_n_array[i] = number.substr(i, 1);
                }
                for (var i = 9 - n_length, j = 0; i < 9; i++, j++) {
                    n_array[i] = received_n_array[j];
                }
                for (var i = 0, j = 1; i < 9; i++, j++) {
                    if (i == 0 || i == 2 || i == 4 || i == 7) {
                        if (n_array[i] == 1) {
                            n_array[j] = 10 + parseInt(n_array[j]);
                            n_array[i] = 0;
                        }
                    }
                }
                value = '';
                for (var i = 0; i < 9; i++) {
                    if (i == 0 || i == 2 || i == 4 || i == 7) {
                        value = n_array[i] * 10;
                    } else {
                        value = n_array[i];
                    }
                    if (value != 0) {
                        words_string += words[value] + ' ';
                    }
                    if ((i == 1 && value != 0) || (i == 0 && value != 0 && n_array[i + 1] == 0)) {
                        words_string += 'Crores ';
                    }
                    if ((i == 3 && value != 0) || (i == 2 && value != 0 && n_array[i + 1] == 0)) {
                        words_string += 'Lakhs ';
                    }
                    if ((i == 5 && value != 0) || (i == 4 && value != 0 && n_array[i + 1] == 0)) {
                        words_string += 'Thousand ';
                    }
                    if (i == 6 && value != 0 && (n_array[i + 1] != 0 && n_array[i + 2] != 0)) {
                        words_string += 'Hundred and ';
                    } else if (i == 6 && value != 0) {
                        words_string += 'Hundred ';
                    }
                }
                words_string = words_string.split(' ').join(' ');
            }
            return words_string;

        }
        function RsPaise(n) {
            nums = n.toString().split('.')
            var whole = Rs(nums[0])
            if (nums[1] == null) nums[1] = 0;
            if (nums[1].length == 1) nums[1] = nums[1] + '0';
            if (nums[1].length > 2) { nums[1] = nums[1].substring(2, length - 1) }
            if (nums.length == 2) {
                if (nums[0] <= 9) { nums[0] = nums[0] * 10 } else { nums[0] = nums[0] };
                var fraction = Rs(nums[1])
                if (whole == '' && fraction == '') { op = 'Zero only'; }
                if (whole == '' && fraction != '') { op = 'paise ' + fraction + ' only'; }
                if (whole != '' && fraction == '') { op = 'Rupees ' + whole + ' only'; }
                if (whole != '' && fraction != '') { op = 'Rupees ' + whole + 'and paise ' + fraction + ' only'; }
                amt = document.getElementById('amt').value;
                if (amt > 999999999.99) { op = 'Oops!!! The amount is too big to convert'; }
                if (isNaN(amt) == true) { op = 'Error : Amount in number appears to be incorrect. Please Check.'; }
                document.getElementById('op').innerHTML = op;
            }

        }

        RsPaise(Math.round(document.getElementById('amt').value * 100) / 100);



    </script>


</head>

<body>

<!-- Preloader Start -->
    <div id="preloader">
	  <div id="loader"></div>	  
	</div>
    <!-- Preloader Ends -->
	
<section class='loginForm'>
			   <form id="msform" name="msform">
			  <div class="container-fluid py-2 ">
			    <div class="row d-flex justify-content-center align-items-center">
			      <div class="col col-xl-11">
			        <div class="card" style="border-radius: 1rem;">
			          <div class="row g-0">
			            <div class="col-md-5 col-lg-4 d-none d-md-block" id='contactimgId'>
			              <img src="/HIS/hisglobal/images/e-clinic/contactus.png"
			                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
			            </div>
			            <div class="col-md-7 col-lg-8  align-items-center" id='contactcontentId'>
			              <div class="card-body">
			                  <div class="d-flex align-items-center">
			                    <div class="p-2 "><img src='/HIS/hisglobal/images/e-clinic/eclinic-icons.png' class='eshusrut-logo'></div>
					    		<div class="p-2 ">
					    			<span class='eshusrut-brandName eshusrut-brandName-color1'>Sushrut</span>
								    <span class='eshusrut-brandName eshusrut-brandName-color2'><i class='fas fa-hand-holding-medical fa-fw'></i></span>
								    <span class='eshusrut-brandName eshusrut-brandName-color3'>Clinic</span>
					    		</div>
			                  </div>
			
			                  <h5 class="fw-normal mt-3 mb-3 pb-3 text-center" style="letter-spacing: 1px;">Contact Us</h5>
			                  
                                <!-- progressbar -->
                                <ul id="progressbar" style="padding: 0;margin: 0;">
                                      <li class="active" id="account"><strong>Contact Detail </strong></li>
                                   	 <li id="confirm" class='mr-1'><strong>Finish</strong></li>
                                </ul>
                            </div>
                            		</div>
                             <div class="col-md-12 col-lg-12  align-items-center">
                             	<fieldset id='accountfs' > 
                                     <h5 class="fw-normal mt-3 mb-3 pb-3" style="letter-spacing: 1px;text-align: center;">Contact Detail</h5>
                                     <div class='container m-3 p-4'>
                                     	<div class='row'>
                                     	
                                     	<div class='col-md-6 col-lg-6 '>
                                     			<div class="form-outline mb-2">
					                    			<label class="form-label" >Institution Type</label>
					                    			<select name='htype' id='htype' class='form-control form-control-lg'  onchange="validateCombo('htype' , 'Institute Type');" >
                                                   		<%=request.getSession().getAttribute("hosp_reg_type").toString() %>                                                 
                                                	</select>
					                    			 <!-- <input type='hidden' name='htypeName' id='htypeName' value='' /> -->
                                                 	<span id="htypecheck" style="color: red;display:none;">Institution Type is Required</span>
					                  		 	 </div>					                  		 	
                                     		</div>
                                     	
                                     		<div class='col-md-6 col-lg-6 '>
                                     			<div class="form-outline mb-2">
					                    			<label class="form-label" >Contact Person Name</label>
					                    			<input type="text" tabindex="1" maxlength="100" class="form-control form-control-lg" value=""
														name="uname" id='uname' 
														 data-options="required:true,validType:'alphaWithSpace'"
                                            		onclick="validateName('uname' , 'Contact Person');" onkeyup="validateName('uname' , 'Contact Person Name');"
														autocomplete="off"/>
					                    			<span id="unamecheck" style="color: red; display:none;">Contact Person Name is Required</span>
					                    		 </div>
					                  		   </div>
					                  		   
					                  		   <div class='col-md-6 col-lg-6 '>
                                     			<div class="form-outline mb-2">
					                    			<label class="form-label" >Email</label>
					                    			<input type="email" tabindex="1" maxlength="100" class="form-control form-control-lg" value=""
														name="email" id='email'  required    onclick="validateEmail('email' , 'Email');" onkeyup="validateEmail('email' , 'Email');" data-options="required:true,validType:'email'" />
                                       				 <span id="emailcheck" style="color: red; display:none;">Email is Required</span>
					                    		 </div>
					                  		   </div>	
					                  		   
					                  		   <div class='col-md-6 col-lg-6 '>
                                     			<div class="form-outline mb-2">
					                    			<label class="form-label" >*Mobile No.</label>
					                    			<input type="text" tabindex="1" maxlength="10" class="form-control form-control-lg" value=""
														name="phone" id='phone'   required
			                                            pattern="[6-9][0-9]{9}" data-options="required:true,validType:'numeric'"
			                                            title="Number starting with 6-9 and remaining 9 digit with 0-9"
			                                            onclick="validatePhone('phone' , 'Mobile No.');" onkeyup="validatePhone('phone' , 'Mobile No.');" />
			                                        	<span id="phonecheck" style="color: red;display:none;">Mobile No. is Required</span>
					                    		 </div>
					                  		   </div>	 
					                  		 	 
					                  		 <div class='col-md-12 col-lg-12 '>
                                     			<div class="form-outline mb-2">
					                    			<label class="form-label" >Message</label>
					                    			<textarea rows="2" name="message" id='message' class="form-control form-control-lg"
                                                    cols="25" maxlength="50"></textarea>					                    			
					                  		 	 </div>					                  		 	 
                                     		</div>
                                     		 
					                  		 	 
					                  		<a href="#"  name="next" tabindex="3" class="next action-button btn btn-dark btn-sm mt-2 mb-2" >Submit</a>
                                     		</div>
                                     	</div>
                                     	</fieldset>
                                     
                                     	<fieldset style="display: none;" >
		                                    <div class="form-card" id="sth" >
		                                        <h2 class="fs-title text-center">Success !</h2>
		                                         
		                                        <br>
		                                        <div class="row justify-content-center">
		                                            <div class="col-3 text-center">
		                                                <img src="https://img.icons8.com/color/96/000000/ok--v2.png"
		                                                    class="fit-image">
		                                            </div>
		                                        </div>
		                                        
		                                        <br>
		                                        <div class="row justify-content-center">
		                                            <div class="col-7 text-center">
		                                                 <h4>Your Enquiry have been registered, your enquiry id is <span id='regId' ></span></h4>
		                                                <h6>
		                                                    <font color='red'>you will be communicated soon 
		                                                    </font>
		                                                </h6>
		                                            </div>
		                                           
		                                        </div>
		                                        <div class="row text-center" >
		                                            <div class="col-sm-12">
													<a href="#"  name="next" id="idCancel"class="next action-button btn btn-dark btn-sm mt-2 mb-2"   >Close</a>
													</div>
		                                        </div>
		                                    </div>
		                                  </fieldset>
		                                  
        </div>
        </div>
        </div>
        </div>
        </div>
        </div>
        
     
        </form>
        </section>
                                     	


</body>

</html>