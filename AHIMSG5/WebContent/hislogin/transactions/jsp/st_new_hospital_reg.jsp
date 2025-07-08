<!doctype html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Sushrut Clinic</title>
    <meta name="description" content="">
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link href="/HIS/hisglobal/images/e-clinic/img/icons/logo.ico" rel="icon"  type="image/x-icon">    
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/responsive.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/iframe.css">
    <script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"  ></script>
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.easing.min.js"  ></script>
	<script src="/HIS/hisglobal/cdac_awesome/animate-scroll-back-top/jquery.backtothetop.min.js"  ></script>    
    <script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
	<script type="text/javascript" src="/HIS/hisglobal/FormFlowX/js/commonFunctions.js"></script>
	
	
	<script type="text/javascript">
        $(document).ready(function () {
        	$('#preloader').delay(450).fadeOut('slow');
        	initValidation('ENTRYFORM');
        	$("#district").html("<option value='0'>*Select a District</option>")

        	
        	 $("#state").change(function () {
             		if($(this).val() == 0){
             			$("#stateName").val('');
             			$("#district").html("<option value='0'>*Select a District</option>")
                 	}else{

                 		$("#stateName").val($( "#state option:selected" ).text());
                 		$.get("/AHIMSG5/hislogin/getDistrictListLgnFtr?state_id="+$(this).val(), function(data, status){
								//alert(data);
                 			$("#district").html(data);
                 		    
                 		  });
                 		
                     }
             	 	
			});
        	$("#district").change(function () {

        		if($(this).val() == 0){

            		$("#districtName").val($( "#district option:selected" ).text());
            		                		
                	}else{
                		$("#districtName").val('');
                    	}
            });


   			$('#btnNext').click(CallOnNextButtonClick);

   	   		$('#btnFinish').click(finalSave);
   	   		$('#idCancel').click(function(){
   	   			parent.closeModal('iframeRegistration');
            	e.preventDefault();
   	   	   	});
   			 
             
        });
        function finalSave(){

        	if(ValidateForAllVisible("ENTRYFORM")==false)
	    			return;

	   		var form=$("#msform");

			sortandEncodebase64($("#msform"));

    	
    		showPreloader('Procesing your request. Please Wait !');
    		
    		$.ajax({
    	        type:"POST",
    	        url:'/AHIMSG5/hislogin/saveHospitalRegistrationLgnFtr',
    	        data:form.serialize(),
    	        success: function(response){
    	        	hidePreloader();
    	        	if(response.length == 0){
    	        		alert("Something Went Wrong, Please try Again");
    	        		$('#idCancel').trigger('click');
    	        		return false;
    	        		
        	        }else{
        	        	if(response.includes("Form Data Tampered")){
							alert("Form Data Tampered");			
            	       		$('#ENTRYFORM').hide();
            	       		return false
            	          }  
             	    }
    	       
               		$("#regId").html(response)
			
	   	   			var currentStepNo=$('#currentStepNo').val();
					var nextStepNo=parseInt(currentStepNo)+1;								
					$('.formarea').hide();
					$('.stepbtn').removeClass("active");
					$('#step-'+currentStepNo).addClass('visited');
					$('#formStep-'+nextStepNo).show();
					$('#step-'+nextStepNo).addClass('active');
	   	   			$('#btnNext').hide();
					$('#btnFinish').hide();
					$('#buttonarea').css({"text-align":"center"})
					$('#idCancel').show();
    	        }
	   	   	});
        }
        function CallOnNextButtonClick(){
        	if(ValidateForAllVisible("ENTRYFORM")==false)
		    		return;
				var currentStepNo=$('#currentStepNo').val();

				switch(currentStepNo)
				{
					
					case "1":{
						generateOTP()
						break;
					}
					case "2":{
						validateOTP()
						break;
					}
				}
         }
        function generateOTP(){

        	showPreloader('Sending OTP Please Wait !');
			 $.ajax({
      	     type:"POST",
          	 url: "/AHIMSG5/hislogin/genOTPLgnFtr", 
          	 data: {
						"emailId" : document.getElementsByName("email")[0].value
              	 },
          	 success: function(result){
		           	hidePreloader()
      			MoveToNextStep()
      			 countdown();
   		    
      		 }});
			
        }
        function validateOTP(){
            alert("INSIDE ST NEW HOSP REG JSP")
        	showPreloader('Validating OTP Please Wait !');
        	 $.ajax({
        	     type:"POST",
            	 url: "/AHIMSG5/hislogin/validateRegOTPLgnFtr", 
            	 data: {
						"emailId" : document.getElementsByName("email")[0].value,
						"otp" : $("#otp").val()
            	 },
            	 success: function(result){
            		 hidePreloader()
            		 
					if(result == 'valid'){
						MoveToNextStep()
					}else{
						showAlertMsg("Invalid OTP, Please Enter a Valid One", "danger")
  					    return false;						
					}
            		 
            	 } 
     		    
        		});

            }
        function MoveToNextStep(){
        	var currentStepNo=$('#currentStepNo').val();
			var nextStepNo=parseInt(currentStepNo)+1;
			//alert(nextStepNo);
			$('.formarea').hide();
			$('.stepbtn').removeClass("active")
			$('#formStep-'+nextStepNo).show();
			$('#step-'+currentStepNo).addClass('visited');
			$('#step-'+nextStepNo).addClass('active');
			$('#currentStepNo').val(nextStepNo);
			//$('#btnPrev').show();
			if(nextStepNo==3){
				$('#btnNext').hide();
				$('#btnFinish').show();
			}

        }

        function countdown() {

        	var timeleft = 60;
        	var downloadTimer = setInterval(function(){
        	  if(timeleft <= 0) {
        		$('#counter').html('<a style="color:blue;cursor: pointer;" onclick="genOTP();" >Resend OTP</a>');
        	    clearInterval(downloadTimer);
        	  }
        	  else
        		  $('#counter').html("Resend OTP in :<b>" + timeleft + " seconds</b>");
        	  	  timeleft -= 1;
        	  
        	}, 1000);



             /*  var seconds = 60;
            function tick() {
                var counter = document.getElementById("counter");
                seconds--;
                counter.innerHTML = "0:" + (seconds < 10 ? "0" : "") + String(seconds);
                if (seconds > 0) {
                    setTimeout(tick, 1000);
                } else {
                    counter.innerHTML = '<a style="color:blue;cursor: pointer;" onclick="genOTP();" >Resend OTP</a>';
                }
            }
            tick(); */
        }
       
    </script>
</head>
<body>
	 <!-- Preloader Start -->
		  <div id="preloader">
		  <div id="loader">   
		  </div>
		  <span class='midtext'><img src="/HIS/hisglobal/images/e-clinic/img/eshurut_clinic_logo_shiled.png" ></span>
		</div>   
    <!-- Preloader Ends -->
    <div id="registration" class="register w-100 ">
        <div class="mt-4 p-5">
        <a href="index.html">
            <div class="logo text-center"> <img src="/HIS/hisglobal/images/cghs_logo_big.png" class="img-fluid"> </div>
        </a>
    <div class="offcanvas-header p-0">        
       <h2 class="offcanvas-title px-2 py-2 mt-3 text-white fw-semibold">New Health Facility/Clinic Registration</h2>
  
    </div>
    <div class="offcanvas-body">
        <div class="boxes mt-2">
        <div class="row mx-0">
            <div class="col-3 px-1">
             <div class="steps active text-center steps text-center py-2 border stepbtn" id='step-1'><i class="fa-solid fa-user-tie mb-3"></i><br>Contact</div>   
            </div>
            <div class="col-3 px-1">
                <div class="steps text-center py-2 border stepbtn " id='step-2'><i class="fa-solid fa-file-circle-check  mb-3"></i><br>Verification</div>   
            </div>
            <div class="col-3 px-1">
                <div class="steps text-center py-2 border stepbtn" id='step-3'><i class="fa-solid fa-building-columns  mb-3"></i><br>Institute Information</div>   
            </div>
            <div class="col-3 px-1">
                <div class="steps text-center py-2 border stepbtn" id='step-4'><i class="fa-regular fa-square-check  mb-3"></i><br>Finish</div>   
            </div>
			<input type='hidden' name="currentStepNo" id="currentStepNo" value="1">
        </div>    
        </div>
<form id="msform">
<div class='container form-container' id="ENTRYFORM">
	<div class="alert alert-success fw-bold" role="alert" id='alertMsg' style="display: none;"></div>	
<div class="formarea mt-4" id='formStep-1'>
	<div class="row mb-2 mx-0">
		<div class="col-lg-6" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="uname">Contact Person</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="uname" id='uname' data-validation="mandatory,alphabetOnly" maxlength="100" placeholder="Enter Name" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
	</div>
	<div class="row mb-2 mx-0">
		<div class="col-lg-6" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="email">Email</label>
               	<input type="text" class="form-control form-control-lg" tabindex="1" name="email" id='email'  data-validation="mandatory,email" maxlength="100" placeholder="Enter Email" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
	</div>
	<div class="row mb-2 mx-0">
		<div class="col-lg-6" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="phone">Mobile No.</label>
               	<input type="text" class="form-control form-control-lg" tabindex="2"  name="phone" id='phone'	 data-validation="mandatory,mobile" maxlength="10" placeholder="Enter Mobile" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
	</div>
</div>


<div class="formarea mt-4" id='formStep-2' style="display: none;">
	<div class="row mb-2 mx-0">
		<div class="col-lg-6" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="uname">OTP</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="otp" id='otp'  data-validation="mandatory,positiveNumeric" maxlength="4" placeholder="Enter OTP" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>
               	<div id='counter'></div>		                	
  			</div>
 		</div>
	</div>
</div>


<div class="formarea mt-4" id='formStep-3' style="display: none;">
	<div class="row mb-2 mx-0">
		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="hname">Health Facility/Clinic Name</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="hname" id='hname' 
               	  data-validation="mandatory,alphaNumericWithSpace" maxlength="500" placeholder="Enter Health Facility" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
	
		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="hshortname">Health Facility/Clinic Short Name</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="hshortname" id='hshortname' 
               	  data-validation="mandatory,alphabetWithoutSpace" maxlength="4" placeholder="Enter Health Facility Short" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
 		
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="gst">GST No.</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="gst" id='gst' 
               	  data-validation="mandatory,gstin" maxlength="15" placeholder="Enter GST" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="haddress">Institution Address</label>
               	<textarea rows="2" name="haddress" id='haddress' class="form-control form-control-lg"   data-validation="mandatory"   cols="25" maxlength="50"></textarea>               			                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="haddress2">Address Line2</label>
               	<textarea rows="2" name="haddress2" id='haddress2' class="form-control form-control-lg"   data-validation="mandatory"   cols="25" maxlength="50"></textarea>               			                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div>
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="pincode">Pincode</label>
               	<input type="text" class="form-control form-control-lg" tabindex="0" name="pincode" id='pincode'
               	  data-validation="mandatory,pin" maxlength="6" placeholder="Enter Pincode" autocomplete="off">		                	
               	<div class="invalid-feedback"></div>		                	
  				</div>
 		</div> 	
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="city">City</label>
               		<input type="text" class="form-control form-control-lg" tabindex="0" name="city" id='city' 
               	  data-validation="mandatory" maxlength="100" placeholder="Enter Pincode" autocomplete="off">             	
               	<div class="invalid-feedback"></div>
               	   <input type='hidden' name='stateName' id='stateName' value=''/> 		                	
  				</div>
 		</div> 
 		<div class="col-lg-4" >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="state">State</label>
               	<select name='state' id='state' class='form-control form-control-lg'   >
                      <%=request.getSession().getAttribute("state_combo_value").toString() %>                                               
                </select>                	
               	<div class="invalid-feedback"></div>
               	   <input type='hidden' name='stateName' id='stateName' value=''/> 		                	
  				</div>
 		</div> 	
 		<div class="col-lg-4"  >
			 <div class="form-group">
               	<label class="col-form-label col-form-label-md" for="district" >District</label>
               	<select name='district' id='district' class='form-control form-control-lg'    >
                 		 <option value='0'>*Select District</option>                                             
              	</select>              	
               	<div class="invalid-feedback"></div>
               	 <input type='hidden' name='districtName' id='districtName' value=''/>		                	
  				</div>
 		</div> 		
 		
	</div>
	
	
	
	
</div>

<div class="formarea mt-4" id='formStep-4' style="display: none;">
	<div class="row mb-2 mx-0">
		<div class="col-lg-12" >
			  <h2 class="fs-title text-primary text-center">Success !</h2>
               <br>
                <div class="row justify-content-center">
                    <div class="col-3 text-center">
                        <img src="https://img.icons8.com/color/96/000000/ok--v2.png"
                            class="fit-image">
                    </div>
                </div>
                                        
                                       
                 <div class="row justify-content-center">
                     <div class="col-7 text-center">
                         <h4>You Have Successfully Registered, Your Registration id is <span id='regId' ></span></h4>
                         <h6>
                             <font color='red'>Soon You will receive your Login Credentials
                             </font>
                         </h6>
                     </div>
 		</div>
	</div>
</div>
</div>		


<div id='buttonarea' style="text-align: right;"> 
		<!-- <a class="btn btn-primary   btn-lg"  id='btnPrev' type="button" style="display:none;" >Back</a> -->
		<a class="btn btn-primary   btn-lg" id='btnNext' type="button" >Next</a>
		<a class="btn btn-primary   btn-lg"  id='btnFinish' type="button" style="display:none;" >Finish</a>
		<a href="#"  name="next" id="idCancel"class="next action-button btn btn-dark btn-lg"   >Close</a>
</div>
</div>

</form>
</div>
  </div>
</div>
    
   
            <!-- jquery latest version -->
            <script src="assets/js/jquery.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
            <script src="assets/js/menu.js"></script>
            <script src="assets/vendor/aos/aos.js"></script>
            <script src="assets/js/main.js"></script>
</body>
</html>