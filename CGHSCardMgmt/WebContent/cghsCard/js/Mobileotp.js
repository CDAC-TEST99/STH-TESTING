
$(document).ready(function () {
	//alert("1111");
	initValidation('ENTRYFORM');
	$('#generateBtn').click(OTPFn);
	$('#validateBtn').click(OTPVerifyFn);
	$('#resendBtn').click(sendOTP);
	hidePreloader();

});
function openMobileotp(){
	$('#instruction').hide();
	$('#ENTRYFORM').show();
}

let otpGen;
let timer;
let secondsRemaining = 60;

function OTPFn() {
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	
	var usermobile=document.getElementById('userMobile').value;
	var mobilehidden=	$('#hiddenmobile').val(usermobile);
	$("#userMobile").attr("readOnly",true);
	$('#generateBtn').hide();	
	$('#OTPRow').show();
	$('#validateBtn').show();
	$('#resendBtn').show();
	$('#userOTP').val("").focus();
  	
	sendOTP();
}

function sendOTP(){
	//alert("correct place");
	var otpGen = Math.floor(1000 + Math.random() * 9000);
	
	showAlertMsg("OTP is send to mobile no.", 'success',"alertMsg"); 
	var mobileNumber=	$('#hiddenmobile').val();
showMsg("Your OTP is"  +otpGen);
  $('#otpGen').val(otpGen);
    resendOTPTimer("resendBtn");
		
	//For OTP to apply Plastic card 
      	const data = new Array(otpGen.toString() );
		const mobileNumbers = new Array(mobileNumber);
		jsonObject = {
				"templateId":"",
				  "data":[],
	      	    "mobileNumbers":[],
			}
		jsonObject.data=data;
		jsonObject.mobileNumbers=mobileNumbers;
		jsonObject.templateId = "1107174358255649846";
				
			var configJson = {
				serviceName:"/GETDATA/getMessageUsingTemplate",
				callBackFunctionName:"callbackSendSMSAJAX",
				inputData:jsonObject,
			}
			getTemplateMessageandSendSMS(configJson); 
		} 


function OTPVerifyFn() {
  
	if(ValidateForAllVisible("ENTRYFORM")==false)
			return;
	    
	
	const userOtp = document.getElementById('userOTP').value;
	
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
	 submitFormMaster("getselectcardtype","add");
}


/*
function openpage1()
{
	
		$('#hiddenId12').val($('#Serving').val());
		submitFormMaster("onlineapplyplasticcard","add");
	}

function openpage()
{
		$('#hiddenId12').val($('#Pensioner').val());
		submitFormMaster("onlineapplyplasticcard","add");
	
}
*/

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