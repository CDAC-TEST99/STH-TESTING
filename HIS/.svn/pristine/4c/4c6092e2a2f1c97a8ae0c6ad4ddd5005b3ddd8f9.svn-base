  $(document).ready(function(){
        	reset();
       
        /*	$("#hospitalID").change(function(){
       			var hashCode=$("#hospitalID").val();
       			
       			var hospitalCode = hashCode.split("#")[0];
       			
       			var crNo=$("#crNo").val();
			    if(hospitalCode!="-1"){        		
  	        		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
  	        		var data="mode=GETHOSPLISTNEW&hospitalCode="+hospitalCode+"&crNo="+crNo;
  	        		$.ajax({url:action,tpye:'POST',data:data,success:function(result){
  	        			$("#visitingDeptID").html(result);
  	        			}
  	        		  });
  				}else{
 					$("#visitingDeptID").html("<option value='-1'>Select Value</option>");
 				}
          	
          	 });*/
        	
        	
//        	 $("input").blur(function(){
//        		
//        		 var deptCode=document.forms[0].visitingDeptID.value;
//        		 alert("Inside::"+ $('[name="Age"]')[0].value)
//        		  if(deptCode.split("#",1) == 111 && $('[name="Age"]')[0].value > 14){
//        		 alert("Age Limit in This Department  is 14 Yrs");
//        		 return false;
//        		 }
//        	 });
        	
        	// added by jyoti shukla

        	var resultarr= $("#oldvisit1").val().split("#");
        	
        	var a=resultarr[4];
        	var b=resultarr[5];
        	

			/*if(a==b)
				{
	        	$("input:radio[name=oldvisit]").attr("disabled",true);

				$("#amtFlag1").hide();
	        	 $("#amtFlag2").show();

				}
			else
				{
	        	$("input:radio[name=oldvisit]").attr("disabled",false);
				$("#amtFlag1").show();
	        	 $("#amtFlag2").hide();


				}*/
        	
        	 $("#visitingDeptID").change(function(){
        		var deptHashCode=$("#visitingDeptID").val();
        		//alert(deptHashCode);
        		var deptCode = deptHashCode.substring(0,3);//deptHashCode.split("#")[1];
        		var hashCode=$("#hospitalID").val();
        		var hospCode=hashCode.split("#")[0];
        		if(agePiteadtric()){
        		if(deptHashCode!="-1"){	
					
	                	$("#visitDate").val("");
	                	
	                	
	                	var crNo=document.getElementById("crNo").value;	                	
	                	var visitingDeptID=document.getElementById("visitingDeptID").value.substring(0,3);//split("#")[0];
	                	var departmentUnitCode=document.getElementById("visitingDeptID").value;//.split("#")[1];
	                	var departmentSlot=document.getElementById("visitingDeptID").value;//.split("#")[1];
	                	
	                	var url='index.jsp?visitingDeptID='+visitingDeptID+"&departmentSlot="+departmentSlot+"&revisitFlag=0&crNo="+crNo+"&hospcode="+hospCode;	                	       	              	                	
	                	var myWindow =window.open(url,'mywindow','width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');	
	                	myWindow.blur();        	  	
	             
	                		                	
				}else{
					/* $("#visitDate").html("<option value='-1'>Select Value</option>"); */
				}	
        		}
        	 });
        	 
        });
  
       function agePiteadtric(){
    	 
    	   var deptCode=document.forms[0].visitingDeptID.value;
    	   var age=$("#patAge").val();
    	   var gender=document.forms[0].genderId.value;
    	 //  alert("deptCode::"+deptCode+"\n"+age+"\n"+gender);
    	   if( Number(age.split(" ")[0]) > 14 && age.split(" ")[1]=="Yr" && deptCode.substring(0,3) == "111" ){
      		 alert("Only patients upto 14 Yrs of age are allowed to visit in Pediatrics Department. Kindly select another department to visit.");
      		 $("#visitingDeptID").val('-1');
      		 return false;
      		 }else if(deptCode.substring(0,3) == "112" && document.forms[0].genderId.value=="Male"){
      			 alert("Only Female & Transgender patients are allowed to visit in Gynaecology Department. Kindly select another department to visit.");
      			 $("#visitingDeptID").val('-1');
           		
      			 return false;
      		 }
      		 else
      			 return true;
       }
    /*    function getDepartmentDtls(obj)
        {
         
     		if(obj.value != -1){
         	//alert("on change");
         		$("#patAddDistrictCode").val(obj.value.split('#')[3]);
         		
         		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
          		var data="mode=GETDEPTLISTNEW&hospitalCode="+obj.value.split('#')[0];
          		$.ajax({url:action,type:'POST',data:data,success:function(result){
          			$("#visitingDeptID").html(result);
          			}
          		  });	 
         		 
         		
         	}else{
         		//alert("no condition change");
         		$("#patAddDistrictCode").val(0);
         		$("#visitingDeptID").html("<option value'-1'>Select Value</option>");
         		
         	}
         	
         }*/
        function validateOld()
        {
        
        	var off_payment_method = document.getElementsByName('oldvisit');
        	//alert()
        	if(document.getElementById("visitDate1").value==$('input[name="oldvisit"]:checked').val().split("#")[5])
        		{
        		alert("Patient has already visited this department today. Kindly select another date for Appointment in this department.");
        		$("#visitDate1").val('');
        		return false;
        		}
        
			var ischecked_method = false;
			for ( var i = 0; i < off_payment_method.length; i++) {
			    if(off_payment_method[i].checked) {
			        ischecked_method = true;
			        break;
			    }
			}
			if(!ischecked_method)   { //payment method button is not checked
			   alert('Kindly Select A Department To Visit.');
			   return false;
			}
        	
        	if($("#visitDate1").val()==''){
        		alert('Kindly Select Visit Date.');
        		$("#visitDate1").focus();
        		return false;
        	}
        /*	if($("#visitDate").val()=='')
           	{
          		alert('Kindly Select Visit Date.');
          		$("#patdate").focus();
          		return false;
               }*/
        	var str=$("#registerDate").val();

	         var res=str.split("#");
	       //  alert("validateOld::"+$("#visitDate1").val());
	       //  alert("validateOldvisitDate1::"+$("#visitDate1").val());
	       //  alert("validateOldres::"+res);
   		for(i=0;i<res.length;i++)
   		{
   			//alert("validateOldres[i]::"+res[i])
   			if(res[i]==$("#visitDate1").val())
   				{
      	         alert("You Have Already Booked An Appointment On This Date");
      	         
      	         return false;
   				}

   		}
        	
        	submitOldFormMain();	
        }
 
    
        function validateOld_payNow()
        {
        	var off_payment_method = document.getElementsByName('oldvisit');  
			var ischecked_method = false;
			for ( var i = 0; i < off_payment_method.length; i++) {
			    if(off_payment_method[i].checked) {
			        ischecked_method = true;
			        break;
			    }
			}
			if(!ischecked_method)   {
			   alert('No department to visit');
			   return false;
			}            	
        	if($("#visitDate1").val()==''){
        		alert('Kindly Select Visit Date.');
        		$("#visitDate1").focus();
        		return false;
        	}     
        	var str=$("#registerDate").val();

	         var res=str.split("#");
	        // alert("2")
	        // alert("visitDate validateOld_payNow::"+$("#visitDate1").val())
	        // alert("visitDate1 validateOld_payNow::"+$("#visitDate1").val())

    		for(i=0;i<res.length;i++)
    		{
    			//alert("res[i] validateOld_payNow::"+res[i])
    			if(res[i]==$("#visitDate1").val())
    				{
       	         alert("You Have Already Booked An Appointment On This Date.");
       	         
       	         return false;
    				}

    		}
            var walletAmnt=   document.getElementsByName('amount')[0].value;

			var resultarr= $("#oldvisit").val().split("#");
  			var a=resultarr[4];
			var b = $("#visitDate1").val().replace(/\//g,"-");
	
			if(a==b)
			{
			if(document.getElementById("visitType1").checked)
				{

	             var fee=document.getElementById("amtFlag2").textContent;
				}
			else
				{

	             var fee=document.getElementById("amtFlag4").textContent;
				}

			}
			else
			{
			if(document.getElementById("visitType1").checked)
				{

	             var fee=document.getElementById("amtFlag1").textContent;
				}
			else
				{

	             var fee=document.getElementById("amtFlag3").textContent;
				}

			}

			/*if(parseInt(walletAmnt)<=parseInt(fee))
				{
				alert("Not Enough Money In Wallet. Please Recharge");
				return false;
				}
			else
				{

				}*/
        	submitOldFormMain_payNow(fee);	
        }
    
 function submitOldFormMain_payNow(fee){
	
	var myRadio = $('input[name=oldvisit]');
	
	var deptCode= myRadio.filter(':checked').val();
	var visitDate1=$("#visitDate1").val();
	
	var isOldDeptVisit = document.getElementsByName('visitType')[0].value;
	
// 	openCustomPopupWithoutClose('#loadingmessage',100,100);
 	var departmentCode=deptCode.split('#')[2];
 	var hospitalName=deptCode.split('#')[6];


 	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
 	//Changes Done BY Jyoti 
 	var crNo=document.getElementById("crNo").value;
 	var patcatCode=document.getElementById("patcatCode").value;
 	var walletNo=document.getElementById("walletNo").value;
 	var amount=fee;

 	

 
 	var data="mode=REREGISTERPATIENTOLD&crNo="+crNo+"&visitingDeptID="+deptCode.split('#')[0]+"&visitDate="+visitDate1+"&hospcode="+deptCode.split('#')[1]+
 	"&isOldDeptVisit="+isOldDeptVisit+"&departmentCode="+departmentCode+"&crNo="+crNo+"&hospitalName="+hospitalName+"&payType="+"1"+"&patcatCode="+patcatCode+"&walletNo="+walletNo+"&amount="+amount;
 	

 	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
 		console.log(result);
  		var resultarr= result.split("###");
      		var registrationStatus=resultarr[0];
      		var registrationNo=resultarr[1];
     		var patName=resultarr[2];
  			var dateOfVisit=resultarr[3];
  			var hospitalname=resultarr[4];
  			var dept=resultarr[4];
  			
    	  	//Code For QRCode

  			var age=resultarr[5];
	  		var ageUnit=resultarr[6];
	  		var mobileNo=resultarr[7];
	  		//var mobileNo
	  		var qrData=registrationNo+","+fname+","+patGenderCode+"/"+age+","+mobileNo;
	  		resetOld();

   		 if(registrationStatus=='1'){
   			regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Appointment Slip</legend><table width="100%"><div id="qrCodeId"></div><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2"><b>Your Visit has been confirmed.</b></td></tr><tr><td>CR No.</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Appointment Date</td><td>'+dateOfVisit+'</td></tr><tr><td>Hospital : </td><td>: '+ hospitalname +'</td></tr><tr><td colspan="2"> Your Visit is valid for selected Date of Visit.</td></tr><tr><td colspan="2">Please visit the registration counter between 8.30 a.m-2.30 p.m (Mon-Sat).</td></tr><tr><td colspan="2"> Your Visit details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr><tr><td align="center" colspan="2"><input type="button" value="close" onclick="callClose();" /></td></tr></table></fieldset></div>';   			
// 				regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Appointment is confirmed.</td></tr><tr><td>CR Number :</td><td>'+registrationNo+'</td></tr><tr><td>Name :</td>	<td>'+patName+'</td></tr><tr><td>Age :</td><td>'+age+''+ageUnit+'</td></tr><tr><td>Mobile No. :</td>	<td>'+mobileNo+'</td></tr><tr><td>Department :</td>		<td>'+selectedDept+'</td></tr><tr><td colspan="2"> you are requested to visit the hospital with this Online slip</td></tr><tr><td colspan="2"> Your details have been sent to your Registered Mobile Number/email-id.</td></tr><tr><td align="center" colspan="2"><input type="button" value="close" onclick="callClose();" /></td></tr></table></fieldset></div>';      			      		

   			
   			
   			//regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Appointment is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Date Of Visit</td><td>'+dateOfVisit+'</td></tr><tr><td>Department</td><td>'+dept+'</td></tr><tr><td colspan="2"> Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">Please visit the registration counter between 8.30 a.m-12.30 p.m (Mon-Sat).</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr></table></fieldset></div>'; 
   		 }
   		else if(registrationStatus=='2'){
  			regStatusDesc='<fieldset><table width="100%"><tr><td colspan="2"><b>The Online Appointment Slot for this department is full. Kindly try different Appointment Date.</b></td></tr> </table></fieldset>';
  		}
   		else if(registrationStatus=='3')
	      		regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><p align="left">An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b> for the Date- <b>'+visitDate1+'</b>. Appointment details are as follows: </p><br><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Department (Unit) :</td><td><b>'+departmentName+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
	   			
//        closeModal();
   		$("#registrationStatus").html(regStatusDesc);
//   		openCustomPopup('#registrationStatus',450,350);
		
   		
   		}
   		  });
    
 }



    function callClose()
 {
  		window.open('/HISRegistration/registration/transactions/onlineAppointmentNewRegistration.his	','_blank');
  		 window.close();

//  		closeModal();
 }


       
        function validateRef()
        {
        	if($("#visitingDeptIDRef").val()=='-1'){
        		alert('Kindly Select Visiting Department.');
        		$("#visitingDeptIDRef").focus();
        		return false;
        	}
        	if($("#visitDateRef").val()=='-1'){
        		alert('Kindly Select The Appointment Date.');
        		$("#visitDateRef").focus();
        		return false;
        	}
        	else if($("[name='regKeyRef']").val().trim()==''){
        		alert('Kindly Enter Validation Code');
        		$("#regKeyRef").focus();
        		return false;
        	}
        	var isCapchaValid=validateCapchaRef();
			if(isCapchaValid=='invalid')
				return false;
 			document.getElementById("visitDateRef").disabled = true;
        	submitRefFormMain();	
        }
        
        function closeMe()
        {
        	window.close();
        }
        
        function getNewAppointmentDate()
        {
        	var deptCode=$("#visitingDeptID").val();
			if(deptCode!="-1"){        		
        		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
        		var data="mode=GETVISITINGDATENEW&deptCode="+deptCode;
        		$.ajax({url:action,tpye:'POST',data:data,success:function(result){
        			$("#visitDate").html(result);
        			}
        		  });
			}else{
				$("#visitDate").html("<option value='-1'>Select Value</option>");
			}	
        }
     
        
function submitFormOld()
	{
	var myRadio = $('input[name=oldvisit]');
	
	var deptCode= myRadio.filter(':checked').val();
	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data="mode=CHECKUNITSTATUS&visitDate1="+$("#visitDate1").val()+"&deptCode="+deptCode;
	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(status)
		{
		
		if(status=="0")
			{
			document.getElementById("lable1").style.display="";
			$("#lable1").html("Current Unit will not be working on selected Visiting Date.Either change visiting date or will have to visit another unit");
			}
		if(status=="1")
			{
		document.getElementById("lable1").style.display="none";
			document.getElementById("visitDate1").disabled = true;
			}
		},error: function (error) {
              alert('error; ' + eval(error));
          }
	});
	}
function submitOldFormMain(){

	var myRadio = $('input[name=oldvisit]');
	var deptCode= myRadio.filter(':checked').val();
	var visitDate1=$("#visitDate1").val();
	var regStatusDesc="";
	var isOldDeptVisit = document.getElementsByName('visitType')[0].value;
	
	var fname=$("#fname").val();
	var patGenderCode=$("#patGenderCode").val();
	var patAge=$("#patAge").val();
	var patMobile=$("#patMobile").val();
	var patcatCode=$("#patCat").val();
	
	var DepartmentUnitCode=$("#visitingDeptID").val(); 
    var z =$("#visitingDeptID").val();
    var res2 = z.split("#");
    var DepartmentUnitCode = res2[1];
    var patAddStateCode=$("#patAddStateCode").val();
    var patAddCountryCode=$("#patAddCountryCode").val();
    var departmentCode=deptCode.split('#')[2];
 	var hospitalName=deptCode.split('#')[6];
 	
 	//Changes Done BY Jyoti 
 	var crNo=document.getElementById("crNo").value;
 	var patcatCode=document.getElementById("patcatCode").value;
 	var walletNo=document.getElementById("walletNo").value;
 	//var amount=fee;

 	

 
 	
//    var patAddDistrictCode=document.forms[0].patAddDistrictCode.value;
//    var patAddDistrict=$('[name="patAddDistrict"]').val();
//	openCustomPopupWithoutClose('#loadingmessage',100,100);
 	var departmentCode=deptCode.split('#')[2];
 	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	//var data="mode=REREGISTERPATIENTOLD&crNo="+crNo+"&visitingDeptID="+deptCode.split('#')[0]+"&visitDate="+visitDate1+"&hospcode="+deptCode.split('#')[1]+
 	//"&isOldDeptVisit="+isOldDeptVisit+"&departmentCode="+departmentCode+"&payType="+"0";
 	var data="mode=REREGISTERPATIENTOLD&crNo="+crNo+"&visitingDeptID="+deptCode.split('#')[0]+"&visitDate="+visitDate1+"&hospcode="+deptCode.split('#')[1]+
 	"&isOldDeptVisit="+isOldDeptVisit+"&departmentCode="+departmentCode+"&age="+patAge+"&gender="+patGenderCode+"&mobileNo="+patMobile+"&hospitalName="+hospitalName+"&patcatCode="+patcatCode+"&payType="+"1";
 	//alert(data);
 
 	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
 		//alert(result);
      		var resultarr= result.split("###");
      		var registrationStatus=resultarr[0];
      		var registrationNo=resultarr[1];
     		var patName=resultarr[2];
  			var dateOfVisit=resultarr[3];
  			var dept=deptCode.split("#")[7];//document.getElementsByName('oldVisit')[0].value;
  			var hosName=deptCode.split('#')[7];
  			var appointmentNo=resultarr[6];
  			var hospitalname=resultarr[5];
  			
  			var qrData=registrationNo+","+fname+","+patGenderCode+"/"+patAge+","+patMobile;
    	  	//Code For QRCode
  			

  			if(registrationStatus=='1'){
   			regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td>Department (Unit) :</td><td><b>'+dept+'</b></td></tr><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Mobile No. :</td><td><b>'+patMobile+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
   			//regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Appointment is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Date Of Visit</td><td>'+dateOfVisit+'</td></tr><tr><td>Department</td><td>'+dept+'</td></tr><tr><td colspan="2"> Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">Please visit the registration counter between 8.30 a.m-12.30 p.m (Mon-Sat).</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr></table></fieldset></div>'; 
  				//regStatusDesc='<div class="col-sm-4" align="right" style ="background-color : white; "><i class="fa fa-print"  style="font-size:28px"  onclick="callPrint();"></i><div id="PrintArea" class="col-sm-12" ><fieldset width="100%" class="scheduler-border"><legend width="100%" class="scheduler-border">Online  Slip</legend><table class="table table-bordered" width="100%"><tr><td align="right" ></td></tr><tr><td> No </td><td>: '+registrationNo+'</td></tr><tr><td>Name </td><td>: '+patName+'</td></tr><tr><td>Age </td><td>: '+age+' '+ageUnit+'</td></tr><tr><td>Mobile No. </td><td>: '+mobileNo+'</td></tr><tr><td>Address </td><td>: '+ Address +'</td></tr><tr><td colspan="3"> Your Online registration has been Confirmed please visit OPD Counter at Hospital.</td></tr><tr><td colspan="3"> Your details have been sent to your Registered Mobile Number.</td></tr></table></fieldset></div>';
		
  			}
   		else if(registrationStatus=='2'){
  			regStatusDesc='<fieldset><table width="100%"><tr><td colspan="2"><b>The Online Appointment Slot for this department is full. Kindly try different Appointment Date.<b></td></tr> </table></fieldset>';
  		}
   		else if(registrationStatus=='3')
	      		regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><p align="left">An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b> for the Date- <b>'+visitDate1+'</b>. Appointment details are as follows: <p><br><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td>Department (Unit) :</td><td><b>'+dept+'</b></td></tr><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Mobile No. :</td><td><b>'+patMobile+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>'; 			
	   			
   		
//        closeModal();
   		
   		
   	 $("#PrintArea").html(regStatusDesc);
     $("#registrationStatus").modal();
  //   openCustomPopup('#registrationStatus',450,300);
     jQuery("#qrCodeId").qrcode({width: 100,height: 100,text:qrData});
		//alert(qrData);
		var canvas = $('#qrCodeId canvas');
	    var img = canvas.get(0).toDataURL("image/png");
	    //or
	    //var img = $(canvas)[0].toDataURL("image/png");
	    var qrImage= '<img src="'+img+'"/>';
	    $("#qrCodeId").html(qrImage);
	    resetOld();
   		}
   		  });
 	
 }
$(".modalCloseImg simplemodal-close").click( function()
        {
	
		$.modal.close();
        }
);
function submitRefFormMain(){
    var visitingDeptID=$("#visitingDeptIDRef").val();
	   var visitDate=$("#visitDateRef").val(); 	  
 	
//	  openCustomPopupWithoutClose('#loadingmessage',100,100);
	  
 	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
 	var data="mode=REGISTERREFPATIENT&visitingDeptID="+visitingDeptID+"&visitDate="+visitDate;
 	 $.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
      		var resultarr= result.split("###");
      		var registrationStatus=resultarr[0];
      		var registrationNo=resultarr[1];
     		var patName=resultarr[2];
  			var dateOfVisit=resultarr[3];
  		var dept=resultarr[4];
  			var regStatusDesc='';
   		 if(registrationStatus=='1'){
   			regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Appointment is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Appointment Date</td><td>'+dateOfVisit+'</td></tr><tr><td colspan="2"> Appointment is valid only for selected Date of Visit.</td></tr><tr><td colspan="2">Please visit the registration counter between 8.00-11.00 a.m (Mon-Fri) and 8.00-10.30 a.m ( Sat and Gazetted Holidays).</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"> Your Appointment details have also been sent to registered Mobile. Number.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr></table></fieldset></div>';

   		}
   		else if(registrationStatus=='2'){
   			regStatusDesc='<fieldset><table width="100%"><tr><td colspan="2"><b>The Online Appointment Slot For this department is full. Kindly try different Appointment Date.</b></td></tr> </table></fieldset>';
   		}
   		else if(registrationStatus=='3')
	      		regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><p align="left">An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b> for the Date- <b>'+visitDate+'</b>. Appointment details are as follows: </p><br><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Department (Unit):</td><td><b>'+departmentName+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
	   			
   		//$("#registrationForm").hide();
//   		closeModal();
   		$("#registrationStatus").html(regStatusDesc);
   		jQuery("#qrCodeId").qrcode({width: 100,height: 100,text:qrData});
		//alert(qrData);
		var canvas = $('#qrCodeId canvas');
	    var img = canvas.get(0).toDataURL("image/png");
	    //or
	    //var img = $(canvas)[0].toDataURL("image/png");
	    var qrImage= '<img src="'+img+'"/>';
	    $("#qrCodeId").html(qrImage);
//   		openCustomPopup('#registrationStatus',450,200);
   		getNewAppointmentDate();
   		resetRef();
   		reloadCapcha();
   		reloadCapchaOld();
     	reloadCapchaRef();
   		}
   		  }); 
 	
 }
	
	
function resetOld(){
	document.getElementById('oldvisit1').checked = false;
	$("#visitDate1").val('');
	//$('[name="regKeyOld"]').val('');
	//document.getElementById("lable1").style.display="none";
	//document.getElementById("visitDate1").disabled = false;
	//var resultarr= $("#oldvisit").val().split("#");

	//captchaReset();
	return;
	
}
function validateCapchaOld(){
	var validationStatus='invalid';
		var regKey=$("[name='regKeyOld']").val();
		if(regKey!=""){        		
     		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
     		var data="mode=VALIDATECAPCHA&regKey="+regKey;
     		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
	      		if(result=='0'){
				alert('Please Enter Correct Verification Code');
      		$("#regKeyOld").focus();
      		validationStatus= "invalid";
      		
			}else{
				validationStatus= "valid";
			}
     		}
     		  });
			}else{
				validationStatus= "invalid";
			}
	return validationStatus;
	
	
}
function validateCapchaRef(){
	var validationStatus='invalid';
		var regKey=$("[name='regKeyRef']").val();
		if(regKey!=""){        		
     		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
     		var data="mode=VALIDATECAPCHA&regKey="+regKey;
     		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
	      		if(result=='0'){
				alert('Please Enter Correct Verification Code');
      		$("#regKeyRef").focus();
      		validationStatus= "invalid";
      		
			}else{
				validationStatus= "valid";
			}
     		}
     		  });
			}else{
				validationStatus= "invalid";
			}
	return validationStatus;
	
	
}

        
        function changeDate(obj){
//         	Commented By Ranjit as Calender is Required by PGI Team
        	/*var value;
        	var myRadio = $('input[name=oldvisit]');
    		var deptCode= myRadio.filter(':checked').val();
    		//alert(deptCode);
    		$("#lable1").html("");
			if(deptCode!="-1"){        		
        		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
        		var data="mode=GETVISITINGDATEOLD&deptCode="+deptCode;
        		$.ajax({url:action,tpye:'POST',data:data,success:function(result){
        			$("#visitDate1").html(result);
        			}
        		  });
			}else{
				$("#visitDate1").html("<option value='-1'>Select Value</option>");
			}*/	
		
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth() + 1;
			var yyyy = today.getFullYear();
			if (dd < 10) {
			  dd = '0' + dd;
			}

			if (mm < 10) {
			  mm = '0' + mm;
			}
			today = dd + '-' + mm + '-' + yyyy;
			
			
				if(obj.value.split('#')[3]=="yes")
				{				
				alert("You have Already visited this department today.");	
				 document.getElementById("visitDate1").value="";
		     	   document.getElementById("visitDate").value="";
				}
			else
				{
				var aa=obj.value.split('#')[4];
				if(aa==today)
						{
						alert("You Have Already Visited this Department today.");
						 document.getElementById("visitDate1").value="";
				     	   document.getElementById("visitDate").value="";
						}
				else if(obj.value.split('#')[7].includes("Pediatrics") && Number($('#ageId').val().split(" ")[0])>14 && $('#ageId').val().split(" ")[1]=='Yr'){
					alert("Only patients upto 14 Yrs of age are allowed to visit in Pediatrics Department. Hence, you can no longer book an appointment in this department.");
		      		obj.checked=false;
		      		obj.disabled=true;
		      		document.getElementById("radTitle"+obj.id.split("oldvisit")[1]).title="Only patients upto 14 Yrs of age are allowed to visit in Pediatrics Department. Hence, you can no longer book an appointment in this department.";
		      		//obj.attr('title','Only patients upto 14 yrs of age allowed');
				}
				
				else if(obj.value.split('#')[7].includes("Gynaec") && $('#gendeId').val()=='Male'){
					 alert("Only Female & Transgender patients are allowed to visit in Gynaecology Department.");
		      		obj.checked=false;
		      		obj.disabled=true;
		      		document.getElementById("radTitle"+obj.id.split("oldvisit")[1]).title="Only Female & Transgender patients are allowed to visit in Gynaecology Department.";
				}
				else{
			var visitingDeptID=obj.value.split("#")[2];
			
			var departmentUnitCode=obj.value.split('#')[0];
			var departmentSlot=obj.value.split('#')[0];
		
			var crNo=document.getElementById("crNo").value;
			var lstVisitDt=obj.value.split("#")[5];
			var hospcode=obj.value.split('#')[1];
			var url='index.jsp?visitingDeptID='+visitingDeptID+"&departmentSlot="+departmentSlot+"&revisitFlag=1&crNo="+crNo+"&hospcode="+hospcode+"&lstVisitDate="+lstVisitDt;
			
        	var myWindow =window.open(url,'mywindow','width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');	
        	myWindow.blur();  
					}
			}
    	 }
        
        function populate(appointDate){
     	   document.getElementById("visitDate1").value=appointDate;
     	   document.getElementById("visitDate").value=appointDate;
     	   
   	  			var resultarr= $("#oldvisit").val().split("#");
      			
      			var a=resultarr[4];
		
				var b = appointDate.replace(/\//g,"-");
		
			if(a==b)
				{
				if(document.getElementById("visitType1").checked)
					{
					$("#amtFlag1").hide();
		        	 $("#amtFlag2").show();
					}
				else
					{
					$("#amtFlag3").hide();
		        	 $("#amtFlag4").show();
					}

				}
			else
				{
				if(document.getElementById("visitType1").checked)
					{
					$("#amtFlag1").show();
		        	$("#amtFlag2").hide();

					}
				else
					{

					$("#amtFlag3").show();
		        	$("#amtFlag4").hide();

					}

				}
         }
    	
    	 
        
        function changeDateRef(){
        	var value;
        	var deptCode=$("#visitingDeptIDRef").val();
    		
    		$("#lable1").html("");
			if(deptCode!="-1"){        		
        		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
        		var data="mode=GETVISITINGDATEREF&deptCode="+deptCode;
        		$.ajax({url:action,tpye:'POST',data:data,success:function(result){
        			$("#visitDateRef").html(result);
        			}
        		  });
			}else{
				$("#visitDateRef").html("<option value='-1'>Select Value</option>");
			}	
    	
    	 }
        function callPrint() {
        	var divToPrint = document.getElementById('printArea').innerHTML;

        	var script = document.createElement("script");
        	script.type = "text/javascript";
        	//Chrome,Firefox, Opera, Safari 3+
        	script.onload = function() {

        		jQuery("#qrCodeId").qrcode({
        			width : 100,
        			height : 100,
        			text : "hello",
        		});
        	};

        	var printHTML = "<html><head>"
        			+ "<style>.main-body{margin-left:10px;margin-right:10px;margin-top:10px;margin-bottom:5px;padding:10px 10px 10px 10px;}</style></head><body class='main-body'>"
        			+ divToPrint
        			//+ "<p align='center'>OPD Timings- Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter).</p>"
        			+ "</body><script>function chkstate(){ \nwindow.close();\n}\nfunction print_win(){\nwindow.print();chkstate();\n}\nprint_win();</script></html>";
        	//newwin.document.write('.main-body{margin-left:10px;margin-right:10px;margin-top:10px;margin-bottom:5px;padding:10px 10px 10px 10px;}');

        	var popupWin = window.open('', 'printwin',
        			'left=100,top=100,width=700,height=700,scrollbars=yes');
        	//window.open('', '_blank', 'width=500,height=500');

        	popupWin.document.open();
        	popupWin.document.write(printHTML);
        	//window.print();
        	// popupWin.document.write(document.getElementsByTagName("head")[0].appendChild(script));

        	popupWin.document.close();

        }
 
        
        function validateSave(){
            
        	if($("#hospitalID").val()=='-1'){
        		alert('Please Select Hospital Name.');
        		$("#hospitalID").focus();
        		return false;
        	}
        	
        	
        	if($("#visitingDeptID").val()=='-1'){
        		alert('Please Select Visiting Department.');
        		$("#visitingDeptID").focus();
        		return false;
        	}
			
        	else{ 
        		  if($("#visitingDeptID").val().split("#")[6]!= -1)
        			{
        			  if($('#patGenderCode').val()=='Female')
        				  $('#patGenderCode').val('F')
        				  else if($('#patGenderCode').val()=='Male'){
        					  $('#patGenderCode').val('M') 
        				  }
        				 
        			  
        			 
        			   if($("#visitingDeptID").val().split("#")[6]!= $('#patGenderCode').val())
        				{
        				   alert("Please Select Valid Visit Department");
        				   $("#visitingDeptID").focus();
        				   return false;
        				} 
        			}
        	}
        	
        
        
        if($("#visitDate").val()=='-1'){
       				alert('Kindly Select The Appointment Date.');
               		$("#visitDate").focus();
               		return false;
       			}
        	//alert("validateSave::"+$("#visitDate").val())
        	//alert("validateSAve::"+$("#visitDate1").val())
        var str=$("#registerDate").val();
	         var res=str.split("#");
         for(i=0;i<res.length;i++)
  		{
        	// alert("valiatee::"+res[i]);
  			if(res[i]==$("#visitDate1").val())
  				{
     	         alert("You Have Already Booked An Appointment On This Date");
     	         
     	         return false;
  				}
  		}
       		
       		      	
       		submitForm();
       		
       		}
        function submitForm(){
        	
           var hashcode=$("#hospitalID").val();
           var hospcode=hashcode.split("#")[0];
           var selectedHospitalName = hashcode.split("#")[1];					
           var visitingDeptID=$("#visitingDeptID").val();
     	   var visitDate=$("#visitDate").val(); 	  
        	
//     	  openCustomPopupWithoutClose('#loadingmessage',100,100);
     	
        	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
        	var data="mode=REREGISTERPATIENT&visitingDeptID="+visitingDeptID+"&visitDate="+visitDate+"&hospcode="+hospcode+"&selectedHospitalName="+selectedHospitalName;
        	 $.ajax({url:action,type:'POST',data:data,async: false,success:function(result){
   	      		var resultarr= result.split("###");
   	      		var registrationStatus=resultarr[0];
   	      		var registrationNo=resultarr[1];
   	     		var patName=resultarr[2];
   	  			var dateOfVisit=resultarr[3];
   	  			var dept=resultarr[4];
   	  			var hospitalname=resultarr[4];
   	  			var qrData=registrationNo+","+fname+","+patGenderCode+","+age+","+DepartmentUnitCode+","+patAddCountryCode+","+patAddStateCode+","+patAddDistrictCode;
	  			//Code For QRCode

   	  			var regStatusDesc='';
	      		 if(registrationStatus=='1'){
	      			
	      			regStatusDesc='<div id="PrintArea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Visit is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Appointment Date</td><td>'+dateOfVisit+'</td></tr><tr><td colspan="2"> This Visit is valid only for selected Date of Visit.</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"> Your Visit details have also been sent to registered Mobile No.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr></table></fieldset></div>';

	      		}
	      		else if(registrationStatus=='2'){
	      			regStatusDesc='<fieldset><table width="100%"><tr><td colspan="2"><b>The Online Appointment Slot for this department is full. Kindly try different Appointment Date.</td></tr> </table></fieldset>';
	      		}
	      		else if(registrationStatus=='3')
       	      		regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><p align="left">An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b> for the Date- <b>'+visitDate+'</b>. Appointment details are as follows: </p><br><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Department :</td><td><b>'+departmentName+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
       	   			
	      		
//	      		closeModal();
	      		$("#registrationStatus").html(regStatusDesc);
//	      		openCustomPopup('#registrationStatus',450,350);
	      		jQuery("#qrCodeId").qrcode({width: 100,height: 100,text:qrData});
	      		//alert(qrData);
	      		var canvas = $('#qrCodeId canvas');
	      	    var img = canvas.get(0).toDataURL("image/png");
	      	    //or
	      	    //var img = $(canvas)[0].toDataURL("image/png");
	      	    var qrImage= '<img src="'+img+'"/>';
	      	    $("#qrCodeId").html(qrImage);
	      		reset();
	        	
	      		}
	      		  });         	
        }
         
  
    function validateSave_PayNow(){       
               	if($("#hospitalID").val()=='-1'){
               		alert('Kindly Select the Hospital Name.');
               		$("#hospitalID").focus();
               		return false;
               	}        	        	
               	if($("#visitingDeptID").val()=='-1'){
               		alert('Kindly Select the Visiting Department.');
               		$("#visitingDeptID").focus();
               		return false;
               	}
               	else{ 
               		/*  if($("#visitingDeptID").val().split("#")[6]!= -1)
               			{
               			  if($('#patGenderCode').val()=='Female')
               				  $('#patGenderCode').val('Female')
               				  else if($('#patGenderCode').val()=='Male'){
               					  $('#patGenderCode').val('M') 
               				  }
//               			   if($("#visitingDeptID").val().split("#")[6]!= $('#patGenderCode').val())
//               				{
//               				   alert("gen::"+$('#patGenderCode').val());
//               				   alert("Please Select Valid Visit Department");
//               				   $("#visitingDeptID").focus();
//               				   return false;
//               				} 
               			}*/
               	}    
            	if($("#visitDate").val()=='')
               	{
              		alert('Kindly Select The Appointment Date.');
              		$("#patdate").focus();
              		return false;
                   }
//                if($("#visitDate").val()=='-1'){
//               				alert('Please Enter Available Visit Date');
//                       		$("#visitDate").focus();
//                       		return false;
//               			}
               
             var str=$("#registerDate").val();
  	         var res=str.split("#");
  	       //  alert("validatePayNOW::"+$("#visitDate").val())
  	        // alert("validatePayNow::"+$("#visitDate1").val())
  	        // alert("res::"+res)
         /*     for(i=0;i<res.length;i++)
       		{
            	  alert(res[i]);
       			if(res[i]==$("#visitDate1").val())
       				{
       				
          	         alert("You Have Already Booked An Appointment On This Date");
          	         
          	         return false;
       				}
       		}
*/

		
		
              var fee="";
              
               submitForm_PayNow(fee);      		
              		}
        
    function submitForm_PayNow(fee){   
    	
                  var hashcode=$("#hospitalID").val();
                  var hospcode=hashcode.split("#")[0];
                  var fname=$("#fname").val();
                  var hospitalName = hashcode.split("#")[1];	
                  var patGenderCode=$("#patGenderCode").val();
                  var patAddCountryCode=$("#patAddCountryCode").val();
            	   var patAddStateCode=$("#patAddStateCode").val();
            	   var patAddStateName=$("#patAddStateID").val();
                  var visitingDeptID=$("#visitingDeptID").val();        	   
            	  var visitDate1=$("#visitDate").val();
//            	  openCustomPopupWithoutClose('#loadingmessage',100,100);    	
               	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";              
            	var isOldDeptVisit=document.getElementsByName('visitType')[1].value;               
               	var departmentCode=visitingDeptID.substring(0,3);
                var departmentUnitCode=visitingDeptID;	              	
            	var crNo=document.getElementById("crNo").value;    
            	var patcatCode=document.getElementById("patcatCode").value;
             	var walletNo=document.getElementById("walletNo").value;
             	var amount=fee;
             	//var hospCode=$("#hospitalID").val().split("#")[0];
             	
             	//var hospitalName=$("#hospitalID").val().split("#")[1];
             	
//             	var departmentName=document.getElementById("visitingDeptID").value.split("#")[9];
            /*	var unitName=document.getElementById("visitingDeptID").value.split("#")[9];
            	var roomName=document.getElementById("visitingDeptID").value.split("#")[10];   
            	var unitName1=document.getElementById("visitingDeptID").value.split("#")[1];
            	var roomName1=document.getElementById("visitingDeptID").value.split("#")[2]; 
            	 var DepartmentUnitCode=$("#visitingDeptID").val(); 
                 var z =$("#visitingDeptID").val();
                 var res2 = z.split("#");
                 var DepartmentUnitCode = res2[1];*/
            	var e = document.getElementById("visitingDeptID");
            	var departmentName = e.options[e.selectedIndex].text;
            	var fname=$("#fname").val();
            	
            	var patGenderCode=$("#patGenderCode").val();
            	var patAge=$("#patAge").val();
            	var patMobile=$("#patMobile").val();
            	

            	//var data="mode=REREGISTERPATIENTOLD&visitingDeptID="+departmentUnitCode+"&visitDate="+visitDate1+"&hospcode="+hospcode+
            	//"&isOldDeptVisit="+isOldDeptVisit+"&departmentCode="+departmentCode+"&crNo="+crNo+"&departmentName="+departmentName+"&unitName="+unitName+"&roomName="+roomName+"&patcatCode="+patcatCode+"&walletNo="+walletNo+"&amount="+amount;;              
               
            	var data="mode=REREGISTERPATIENTOLD&crNo="+crNo+"&visitingDeptID="+departmentUnitCode+"&visitDate="+visitDate1+"&hospcode="+hospcode+
             	"&isOldDeptVisit="+isOldDeptVisit+"&departmentCode="+departmentCode+"&age="+patAge+"&gender="+patGenderCode+"&mobileNo="+patMobile+"&hospitalName="+hospitalName+"&patcatCode="+patcatCode+"&payType="+"1";
             	//alert(data);
             
             	$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
             		//alert(result);
                  		var resultarr= result.split("###");
                  		
                  		var registrationStatus=resultarr[0];
                  		var registrationNo=resultarr[1];
                 		var patName=resultarr[2];
              			var dateOfVisit=resultarr[3];
              			// var dept=document.getElementById("visitingDeptID").value.split("#")[11];
           	  		   // var hospitalname = selectedHospitalName;
           	  		   //var hosName=deptCode.split('#')[7];
              			var appointmentNo=resultarr[6];
              			var hospitalname=resultarr[5];
              			
              			var qrData=registrationNo+","+fname+","+patGenderCode+"/"+patAge+","+patMobile;
                	  	//Code For QRCode

               	/* $.ajax({url:action,type:'POST',data:data,async: false,success:function(result){
          	      		var resultarr= result.split("###");
          	      		var registrationStatus=resultarr[0];
          	      		var registrationNo=resultarr[1];
          	     		var patName=resultarr[2];
          	  			var dateOfVisit=resultarr[3];
          	  		    var dept=document.getElementById("visitingDeptID").value.split("#")[11];
          	  		    var hospitalname = selectedHospitalName;
          	  		    var age=resultarr[5];
          	  		    var qrData=registrationNo+","+fname+","+patGenderCode+","+age+","+DepartmentUnitCode+","+patAddCountryCode+","+patAddStateCode;*/
            	  	//Code For QRCode

          	  			var regStatusDesc='';
          	  			
       	      		 if(registrationStatus=='1'){
//        	      		regStatusDesc='<div id="PrintAea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Visit is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Date Of Visit</td><td>'+dateOfVisit+'</td></tr><tr><td>Department</td><td>'+dept+'</td></tr><tr><td colspan="2"> This Visit is valid only for selected Date of Visit.</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"> Your Visit details have also been sent to registered Mobile No.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr><tr><td align="center" colspan="2"><input type="button" value="close" onclick="callClose();" /></td></tr></table></fieldset></div>';
       	      			//regStatusDesc='<div id="PrintAea"><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2">Your Visit is confirmed.</td></tr><tr><td>CR No</td><td>'+registrationNo+'</td></tr><tr><td>Name</td><td>'+patName+'</td></tr><tr><td>Date Of Visit</td><td>'+dateOfVisit+'</td></tr><tr><td>Department</td><td>'+dept+'</td></tr><tr><td colspan="2"> This Visit is valid only for selected Date of Visit.</td></tr><tr><td colspan="2"> Read instructions carefully before visiting Hospital.</td></tr><tr><td colspan="2"> Your Visit details have also been sent to registered Mobile No.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr><tr><td align="center" colspan="2"><input type="button" value="close" onclick="callClose();" /></td></tr></table></fieldset></div>';
       	      		//regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Department :</td><td><b>'+departmentName+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
       	      	regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td>Department (Unit) :</td><td><b>'+departmentName+'</b></td></tr><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Mobile No. :</td><td><b>'+patMobile+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
       			
       	      			 //regStatusDesc='<div ><fieldset><legend>Online Registration Slip</legend><table width="100%"><tr><td align="right" colspan="2"><input type="button" value="print" onclick="callPrint();" /></td></tr><tr><td colspan="2"><b>Your Appointment is confirmed.</b></td></tr><div id="qrCodeId"></div><tr><td>CR No :</td><td><b>'+registrationNo+'<b></td></tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Department :</td><td><b>'+departmentName+'</b></td></tr><tr><td>Hospital : </td><td><b> '+ hospitalname +'</b></td></tr><tr><td colspan="2"> This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">Please visit the registration counter between 08 AM-02 PM (Mon-Sat).</td></tr><tr><td colspan="2"> Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Please bring all your OPD Cards/Reports.</b></td></tr></table></fieldset></div>';
       	      		}else if(registrationStatus=='2'){
       	      			regStatusDesc='<fieldset><table width="100%"><tr><td colspan="2"><b>The Online Appointment Slot For this department is full. Kindly try different Appointment Date.</b></td></tr> </table></fieldset>';
					}
       	      		else if(registrationStatus=='3')
       	      		regStatusDesc='<div class="col-sm-12" align="right" style ="background-color : white; "><p align="left">An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b> for the Date- <b>'+visitDate1+'</b>. Appointment details are as follows: </p><br><button class="btn-primary"  style="cursor:pointer;"  onclick="callPrint();">Print</button><div id="printArea" class="col-sm-12" ><fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td align="right" colspan="2"></td></tr><tr><td colspan="2">Your Appointment has been confirmed.</td></tr><div id="qrCodeId"></div><tr><td>Appointment Date :</td><td><b>'+dateOfVisit+'</b></td></tr><tr><td>Hospital Name :</td><td><b>'+hospitalname+'</b></td></tr><tr><td>Department (Unit) :</td><td><b>'+departmentName+'</b></td></tr><tr><td>CR No. :</td><td><b>'+registrationNo+'</b></td></tr><tr><td>Appointment No. :</td><td><b>'+appointmentNo+'</b></td></tr><tr><td>Name :</td><td><b>'+patName+'</b></td></tr><tr><td>Age/Gender :</td><td><b>'+patAge+' / '+patGenderCode+'</b></td></tr><tr><td>Mobile No. :</td><td><b>'+patMobile+'</b></td></tr><tr><td colspan="2">- This Appointment is valid for selected Date of Visit.</td></tr><tr><td colspan="2">- Kindly visit the Registration Counter between OPD Timings- <b>Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter)</b>.</td></tr><tr><td colspan="2">- Your Appointment details have also been sent to your registered Mobile Number.</td></tr><tr><td colspan="2"><b>Kindly bring your previous OPD Cards/Reports.</b></td></tr></table></fieldset></div>';   			
           			
       	      		//regStatusDesc='<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2"></td></tr>An Appointment has already been booked in the selected Department-Unit for this CR No. <b>'+registrationNo+'</b>. Appointment details are as follows:</table></fieldset>';
       	      		 //closeModal();
       	      	 $("#PrintArea").html(regStatusDesc);
       	     	 $("#registrationStatus").modal();  
       	     //	openCustomPopup('#registrationStatus',450,300);
       	     	jQuery("#qrCodeId").qrcode({width: 100,height: 100,text:qrData});
       			//alert(qrData);
       			var canvas = $('#qrCodeId canvas');
       		    var img = canvas.get(0).toDataURL("image/png");
       		    //or
       		    //var img = $(canvas)[0].toDataURL("image/png");
       		    var qrImage= '<img src="'+img+'"/>';
       		    $("#qrCodeId").html(qrImage);
       	      		reset();
       	      		} });         	
               }

                             
        function reset(){
        	$("#hospitalTypeID").val('-1');
        	
        	$("#hospitalID").val('-1');
        	$("#visitingDeptID").val('-1');
        	$("#visitDate").val('');
        	//$('[name="regKey"]').val('');
        	return;
        	
        }
        function resetRef(){
        	$("#visitingDeptIDRef").val('-1');
        	$("#visitDateRef").val('-1');
        	$('[name="regKeyRef"]').val('');
        	document.getElementById("visitDateRef").disabled = false;
        	return;
        	
        }
        
         /*Added By Anant Patel on 08-oct-2015 for Reloading Captcha  */
      /*  function reloadCapcha()
        {
        
        document.getElementById("capchaImg").src='/PGIMER_PORTAL/CaptchaServlet?'+(new Date().getTime());
        document.getElementById("regKey").value='';
        $("#regKey").focus();
        }
       
        function reloadCapchaOld()
        {
        
        document.getElementById("capchaImgOld").src='/PGIMER_PORTAL/CaptchaServlet?'+(new Date().getTime());
        document.getElementById("regKeyOld").value='';
        $("#regKeyOld").focus();
        }
        function reloadCapchaRef()
        {
        
        document.getElementById("capchaImgRef").src='/PGIMER_PORTAL/CaptchaServlet?'+(new Date().getTime());
        document.getElementById("regKeyRef").value='';
        $("#regKeyRef").focus();
        }*/
       
        function IsEmail(email) {
        	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        	  return regex.test(email);
        	}
        function validateCapcha(){
        	var validationStatus='invalid';
   			var regKey=$("[name='regKey']").val();
   			if(regKey!=""){        		
   	      		var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
   	      		var data="mode=VALIDATECAPCHA&regKey="+regKey;
   	      		$.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result){
	   	      		if(result=='0'){
	    				alert('Please Enter Correct Verification Code');
	          		$("#regKey").focus();
	          		validationStatus= "invalid";
	          		
	    			}else{
	    				validationStatus= "valid";
	    			}
   	      		}
   	      		  });
   				}else{
   					validationStatus= "invalid";
   				}
			return validationStatus;
			
			
   	 }
        function clearData(){
        	$("#registrationStatus").val('');
        	$("#registrationStatus").html('');
        	reset();
        	return;
        }
        function isStartWithZero(val)
        {	

        	var startingWithZero=true;
        	var len=val.length;
        		
        	if (parseInt(len)>0 )
        	{
        		
        		if((val.charAt(0))==0)
        		{
        			startingWithZero=true;
        		}
        		else
        		{
        			startingWithZero=false;
        		}
        	}
        	else
        	{
        		startingWithZero=false;
        	}
        	
        	return startingWithZero;
        	
        }


function changeVisitType()
	{
	if(document.getElementById("visitType1").checked)
		{
	  
		//captchaReset(document.getElementById("visitType1").value);
		document.getElementById("tab1").style.display="";
		document.getElementById("divtd2").style.display="none";
		document.getElementById("divtd1").style.display="none";
		document.getElementById("td1").style.display="";
		document.getElementById("td2").style.display="none";
		document.getElementById("tab2").style.display="";
		document.getElementById("tab3").style.display="none";
		document.getElementById("tab4").style.display="";
		document.getElementById("tab5").style.display="";
		document.getElementById("tab6").style.display="none";
		 $( "#tab1" ).load(window.location.href + " #tab1" );
		
		
		}
	
	
	if(document.getElementById("visitType2").checked)
		{
		 
		//captchaReset(document.getElementById("visitType2").value);
		document.getElementById("tab1").style.display="none";
		document.getElementById("divtd1").style.display="none";
		document.getElementById("divtd2").style.display="none";
		document.getElementById("td2").style.display="none";
		document.getElementById("td1").style.display="none";
		document.getElementById("tab2").style.display="none";
		document.getElementById("tab3").style.display="";
		document.getElementById("tab4").style.display="none";
		document.getElementById("tab5").style.display="none";
		document.getElementById("tab6").style.display="none";
		document.getElementById("lable1").style.display="none";
	//	var resultarr= $("#oldvisit").val().split("#");
    	/*var a=resultarr[4];
    	var b=resultarr[5];

		if(a==b)
			{
				$("#amtFlag3").hide();
        	    $("#amtFlag4").show();

			}
		else
			{
				$("#amtFlag3").show();
        	 	$("#amtFlag4").hide();
			}*/
	//	 $( "#tab3" ).load(window.location.href + " #tab3" );
		
    	//reloadCapcha();
		}
	
		/*if(document.getElementById("visitType3").checked)
		{
		document.getElementById("tab1").style.display="none";
		document.getElementById("tab2").style.display="none";
		document.getElementById("tab3").style.display="none";
		document.getElementById("tab4").style.display="none";
		document.getElementById("tab5").style.display="none";
		document.getElementById("tab6").style.display="";
		document.getElementById("lable1").style.display="none";
		reloadCapchaRef();
		}*/
	
	
	}
	  
	  function alertDept()
	  {
		if($('#visitDate1 option').size()==1)
			{
			alert("Please Select Department Unit.");
			}
	  }

	  function captchaReset(val) 
	  {
	  	if(val=="0")//New Visit
		{
			var url = "CaptchaServlet2?t=" + new Date().getTime();
			ajaxFunction(url, "1");
		}
		else//Old
		{
			var url = "CaptchaServlet2?t=" + new Date().getTime();
			ajaxFunction(url, "2");
		
		}

	}

	function getAjaxResponse(res, mode) 
	{
     	if (mode == "1") //New
		{
			document.getElementById("captchaDivNew").innerHTML ='<img id="imageid" align="right" height="30" src="data:image/png;base64,' + res + '"  class="captcha" style="width:90px;height:30px" border="1" />';
		}
		if (mode == "2") //Old
		{
			document.getElementById("captchaDivOld").innerHTML ='<img id="imageid" align="right" height="30" src="data:image/png;base64,' + res + '"  class="captcha" style="width:90px;height:30px" border="1" />';			
		}
	}
	
	
	
	
	function checkvisittype()
	{
	if(document.getElementById("visitType1").checked)
		{
			document.getElementById("divtd2").style.display="none";
			//captchaReset();
		}
	
	}
	
	function openpopup()
	{    
		if($("input[name='visitType']:checked").val()=="1"){
		obj=$("input[name='oldvisit']:checked");//document.getElementById("oldvisit");
		//console.log(obj.val());
		if(document.getElementById("visitDate1").value!="" && typeof ($("input[name='visitType']:checked").checked))
			{
			//$('#visitDate1').attr('placeholder',
            //'Select Date');
		//	$("#visitDate1").val("");
	
		var url='index.jsp?visitingDeptID='+obj.val().split("#")[0]+"&departmentSlot="+obj.val().split('#')[0]+"&revisitFlag=0&crNo="+document.getElementById("crNo").value+"&hospcode="+obj.val().split('#')[1];
    
        	var myWindow =window.open(url,'mywindow','width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');	
        	myWindow.blur();
		}
		//else if(typeof (document.getElementById('oldvisit').checked))
		
		}
		else{
			//alert("in else");
			obj=document.getElementById("visitingDeptID").value;
			var url='index.jsp?visitingDeptID='+obj+"&departmentSlot="+obj+"&revisitFlag=0&crNo="+document.getElementById("crNo").value+"&hospcode="+document.getElementById("hospitalId").value.split('#')[0];
		    
        	var myWindow =window.open(url,'mywindow','width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');	
        	myWindow.blur();
	
		}
			
		
	}
	function popupNewDept(){
		
    	$("#visitDate").val("");

    	if($("#visitingDeptID").val()!="-1")
        {
        	var hosCode = document.getElementById("hospitalID").value.split("#")[0];
        	
        	var crNo=document.getElementById("crNo").value;
        	
        	var visitingDeptID=document.getElementById("visitingDeptID").value.substring(0,3);//split("#")[0];
        	var departmentUnitCode=document.getElementById("visitingDeptID").value;//.split("#")[1];
        	var departmentSlot=document.getElementById("visitingDeptID").value;//.split("#")[1];
        	
        		var url='index.jsp?visitingDeptID='+visitingDeptID+"&departmentSlot="+departmentSlot+"&revisitFlag=0&crNo="+crNo+"&hospcode="+hosCode;
        	        	
        
        	var myWindow =window.open(url,'mywindow','width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');	
        	myWindow.blur();  
        }
    }
	
	$(document).ready(function(){
		
		
		  $("#closeModalID").click(function(){
			 $("#registrationStatus").hide();
		  });
		 
		});
