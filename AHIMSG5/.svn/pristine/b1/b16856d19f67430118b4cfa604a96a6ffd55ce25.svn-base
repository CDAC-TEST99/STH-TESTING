$(document).ready(function() {
	
	
		$("#forgetPass").click(function(event){
				
	 			 goTo('forgetPassword');
		 	
		 	});
		 	
		 	$("#forgetPassBen").click(function(event){
				
	 			 goTo('registerPasswordBen');		//goTo('forgetPasswordBen');
		 	
		 	});
	$("#registerPasswordBen").click(function(event){
				
	 			 goTo('registerPasswordBen');
		 	
		 	});
		 	$("#unlockBen").click(function(event){
				
	 			 goTo('unlockben');
		 	
		 	});


	if ($("#mstatus").val() == 'motp') {

		$("#nav-mobile-tab").trigger('click');

	} else {

		$("#nav-user-tab").trigger('click');

	}
	
	
	$('#captchaResponse').keypress(function (e) {
		  if (e.which == 13) {
			  
			  if(loginPage == 'cghs'){
				
				  submitFormOnValidate(validate(),'loginLogin');
			  }else{
				  
				  submitFormOnValidate(validate(),'benloginLogin');
			  }
			  
			  
		    
			  return false;  
		  }
		});
	
	
	
	$('#varOtp').keypress(function (e) {
		  if (e.which == 13) {
			  
			  if(loginPage == 'cghs'){
				
				  submitFormOnValidateOtp(submitValidateOtpTest(),'mloginValidateOtpLogin');
			  }else{
				  
				  submitFormOnValidateOtp(submitValidateOtpTest(),'mbenloginValidateOtpLogin');
			  }
			  
			  
		    
			  return false;  
		  }
		});
	
	
	
	$('#varMobileNumber').keypress(function (e) {
		  if (e.which == 13) {
			  
			  if(loginPage == 'cghs'){
				
				  submitFormOnValidate2(validate(),'mloginLogin');;
			  }else{
				  
				  submitFormOnValidate2(validate(),'mbenloginLogin');
			  }
			  
			  
		    
			  return false;  
		  }
		});
	
});

var minutes = 0, seconds = 60;
var minutesDisplay = "1";
var secondsDisplay = "00";
$(function() {

	if (parseInt(sendCountVal) < 3) {
		
		$("#resendButton").hide();
		$("#otpCountDisplay").hide();

		$("#countDownOTP").html(" Resend OTP in <b>"+minutesDisplay + ":" + secondsDisplay+" sec </b>");
		var countInt = setInterval(function() {
			if (parseInt(minutes) < 0) {
				clearInterval(countInt);
				$("#countDownOTP").hide();
				$("#resendButton").show();
				$("#otpCountDisplay").html("OTP Send Count : "+$("#otpCountValId").html());
				$("#otpCountDisplay").show();
				
				return;
			} else {
				$("#countDownOTP").html("Resend OTP in <b>"+minutesDisplay + ":" + secondsDisplay+" sec </b>");
				
				if(parseInt(minutes) < 10){
					minutesDisplay = "0" + minutes;
				}
				
				if (seconds == 0) {
					minutes--;
					if (minutes < 10)
						minutesDisplay = "0" + minutes;
					seconds = 59;
				}
				seconds--;
				secondsDisplay = seconds;
				if (seconds < 10)
					secondsDisplay = "0" + seconds;
			}
		}, 1000);

	}else{
		
		$("#resendButton").hide();
		$("#otpCountDisplay").hide();
	}
});

function validate() {
	console.log('1');

	if ($("#nav-mobile-tab").hasClass('active')) {

		document.getElementById("divElementErrorsMobileId").innerHTML = "";
		document.getElementById("divElementErrorsMobileId").style.display = "none";

		if (document.getElementsByName("varMobileNumber")[0].value == ""
				|| document.getElementsByName("varMobileNumber")[0].value == "") {
			console.log('2');
			document.getElementById("divElementErrorsMobileId").innerHTML = "Mobile No. is empty!";
			document.getElementById("divElementErrorsMobileId").style.display = "";
			return false;
		}

		console.log('3');

	} else {

		document.getElementById("divElementErrorsId").innerHTML = "";

		// var specialChars =
		// "#,+,~,\`,=,\,,.,@,!,~,*,^,\`,&,$,(,),[,],{,},:,;,>,<,%,?,<,>,\",\'";
		if (document.getElementsByName("varUserName")[0].value == ""
				|| document.getElementsByName("varPassword")[0].value == "") {
			document.getElementById("divElementErrorsId").innerHTML = "User Name / Password is empty!";
			document.getElementById("divElementErrorsId").style.display = "";

			return false;
		}
		if (IS_CAPTCHA_REQ == "ON"
				&& document.getElementsByName("captchaResponse")[0].value == "") {
			document.getElementById("divElementErrorsId").innerHTML = "Please Enter Captcha!";
			document.getElementById("divElementErrorsId").style.display = "";
			return false;
		}
// commented by bala as on 13-May-2025 as per client request on chemist login  
		
		/*if (!validateAlphaNumWithUnderscoreValue(document
				.getElementsByName("varUserName")[0].value))
		// ||
		// (!isValidAlphaNumericInput(document.getElementById("passwd").value,
		// ""))) //specialChars ) ) )
		{
			document.getElementById("divElementErrorsId").innerHTML = "User Name is not a Valid Email Id...";
			// document.getElementById("divElementErrorsId").innerHTML = "User
			// Name / Password is not an Alpha Numeric...";
			document.getElementById("divElementErrorsId").style.display = "";
			return false;
		}*/

		if (!securePassword()) {
			document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
			document.getElementsByName("varUserName")[0].value = "";
			document.getElementsByName("varPassword")[0].value = "";
			return false;
		}
		// Setting window.name property

	}

	console.log('4');
	window.name = sessionToken;
	// alert(window.name);
	return true;
}

function validateBen() {

	document.getElementById("divElementErrorsId").innerHTML = "";

	// var specialChars =
	// "#,+,~,\`,=,\,,.,@,!,~,*,^,\`,&,$,(,),[,],{,},:,;,>,<,%,?,<,>,\",\'";
	if (document.getElementsByName("varUserName")[0].value == ""
			|| document.getElementsByName("varPassword")[0].value == "") {
		document.getElementById("divElementErrorsId").innerHTML = "User Name / Password is empty!";
		document.getElementById("divElementErrorsId").style.display = "";

		return false;
	}
	if (IS_CAPTCHA_REQ == "ON"
			&& document.getElementsByName("captchaResponse")[0].value == "") {
		document.getElementById("divElementErrorsId").innerHTML = "Please Enter Captcha!";
		document.getElementById("divElementErrorsId").style.display = "";
		return false;
	}
	if (!validateAlphaNumWithUnderscoreValue(document
			.getElementsByName("varUserName")[0].value))
	// || (!isValidAlphaNumericInput(document.getElementById("passwd").value,
	// ""))) //specialChars ) ) )
	{
		document.getElementById("divElementErrorsId").innerHTML = "User Name should be Valid Email or Alphabnumeric with Underscore only.";
		// document.getElementById("divElementErrorsId").innerHTML = "User Name
		// / Password is not an Alpha Numeric...";
		document.getElementById("divElementErrorsId").style.display = "";
		return false;
	}

	if (!securePassword()) {
		document.getElementById("divElementErrorsId").innerHTML = "Faced Some Unknown Problem. Please try Again!";
		document.getElementsByName("varUserName")[0].value = "";
		document.getElementsByName("varPassword")[0].value = "";
		return false;
	}
	// Setting window.name property

	console.log('4');
	window.name = sessionToken;
	// alert(window.name);
	return true;
}

function securePassword() {
	var hashValue = "";

	var objPassHash = new jsSHA(
			document.getElementsByName("varPassword")[0].value
					+ document.getElementsByName("varUserName")[0].value,
			"ASCII");
	// ---var objPassHash = new
	// jsSHA(document.getElementsByName("varUserName")[0].value+document.getElementsByName("varUserName")[0].value,
	// "ASCII");
	try {
		// hashValue = objPassHash.getHash("SHA-1", "HEX");
		hashValue = objPassHash.getHash("SHA-256", "HEX")
	} catch (e) {
		return false;
	}

	// alert("hashValue >> "+hashValue);

	// alert("sessionToken >> "+sessionToken);

	objPassHash = new jsSHA(hashValue + sessionToken, "ASCII");

	try {
		// hashValue = objPassHash.getHash("SHA-1", "HEX");
		hashValue = objPassHash.getHash("SHA-256", "HEX")
	} catch (e) {
		return false;
	}

	document.getElementsByName("varPassword")[0].value = hashValue;
	// alert(hashValue);
	return true;
}

function submitFormOnValidate(flg, actionURL) {
	if (flg) {
		submitLoginForm(actionURL);
	}
}

function submitLoginForm(actionURL) {

	var user = document.getElementsByName("varUserName")[0].value;
	var pass = document.getElementsByName("varPassword")[0].value;
	var sessionLoginToken = document.forms[0].sessionLoginToken.value;

	var xtoken = document.getElementById("x-auth-token").value;

	var strSecureCode = sessionLoginToken + pass + user + xtoken;

	if (document.forms[0].captchaResponse != undefined) {

		var captcha = document.forms[0].captchaResponse.value;
		strSecureCode = captcha + strSecureCode;

	}

	// alert("secure code >> "+strSecureCode);

	var fhttf = hex_md5(strSecureCode);
	document.forms[0].fhttf.value = fhttf;

	document.forms[0].action = actionURL;
	document.forms[0].submit();
}

function submitBenFormOnValidate(flg, actionURL) {
	// alert("submitFormOnValidate::"+flg+"::actionURL::"+actionURL);
	if (flg) {
		submitLoginBenForm(actionURL);
	}
}

function submitLoginBenForm(actionURL) {
	//alert("submitLoginBenForm");

	var user = document.getElementsByName("varUserName")[0].value;
	var pass = document.getElementsByName("varPassword")[0].value;
	var sessionLoginToken = document.forms[2].sessionLoginToken.value;
	// var token='token';
	// var tokenNew=document.forms[0].token.value;
	// alert("document.forms[0].captchaTxtBox
	// "+document.forms[0].captchaTxtBox.value)
	if (document.forms[2].captchaTxtBox != undefined) {

		var captcha = document.forms[2].captchaTxtBox.value;
		var strSecureCode = captcha + sessionLoginToken + pass + user;
		var fhttf = hex_md5(strSecureCode);

		document.forms[2].fhttf.value = fhttf;
	}
	// alert(document.forms[0].fhttf.value+" "+fhttf);

	// document.forms[0].action = actionURL + ".action";
	document.forms[2].action = actionURL;

	document.forms[2].submit();
	//alert("exitsubmit");
}

function submitValidateOtpTest() {


if ( document.getElementById("divElementErrorsMobileId") != null  ){
	document.getElementById("divElementErrorsMobileId").innerHTML = "";
	document.getElementById("divElementErrorsMobileId").style.display = "none";
}
	if (document.getElementsByName("varOtp")[0].value == ""
			|| document.getElementsByName("varOtp")[0].value == "") {

		document.getElementById("divElementErrorsMobileId").innerHTML = "Please Enter OTP!";
		document.getElementById("divElementErrorsMobileId").style.display = "";
		return true;
	}
	return true;

}


function submitValidateOtpUserLogin() {


if ( document.getElementById("divElementErrorsId") != null  ){
	document.getElementById("divElementErrorsId").innerHTML = "";
	document.getElementById("divElementErrorsId").style.display = "none";
}
	if (document.getElementsByName("varOtp")[0].value == ""
			|| document.getElementsByName("varOtp")[0].value == "") {
			
		document.getElementById("divElementErrorsId").innerHTML = "Please Enter OTP!";
		document.getElementById("divElementErrorsId").style.display = "";
		return true;
	}
	return true;

}

function submitFormOnValidateOtp(flg, actionURL) {

	if (flg) {
		submitValidateOtp(actionURL);
		return false;
	}
}
function submitFormOnValidateOtp1(flg, actionURL) {

	if (flg) {
		submitValidateOtp1(actionURL);
		return false;
	}
}
//var mobileNo = document.getElementsByName("varMobileNumber")[0].value;
function submitValidateOtp(actionURL) {
	 var mobileNo=document.getElementsByName("varMobileNumber")[0].value;
	var otp = document.getElementsByName("varOtp")[0].value;
	var mstatus = document.getElementsByName("mstatus")[0].value;
	var sessionLoginToken = document.forms[0].sessionLoginToken.value;
	// var token='token';
	// var tokenNew=document.forms[0].token.value;
	// alert("document.forms[0].captchaTxtBox
	// "+document.forms[0].captchaTxtBox.value)

	var strSecureCode = mstatus + sessionLoginToken + mobileNo + otp;
	var fhttf = hex_md5(strSecureCode);
	// alert("fhttf"+fhttf)
	
	if(actionURL == 'mloginValidateOtpLogin' || actionURL == 'mbenloginValidateOtpLogin' ){
		
		document.forms[0].fhttf.value = fhttf;

	document.forms[0].action = actionURL;

	document.forms[0].submit();
		
	}else{
		
		document.forms[1].fhttf.value = fhttf;

	document.forms[1].action = actionURL;

	document.forms[1].submit();
	}
	
	

	return false;
	
}
function submitValidateOtp1(actionURL) {

	 var mobileNo=document.getElementsByName("varMobileNumber")[0].value;
	var otp = document.getElementsByName("varOtp")[0].value;
	//var mstatus = document.getElementsByName("mstatus")[0].value;
	var sessionLoginToken = document.forms[0].sessionLoginToken.value;
	// var token='token';
	// var tokenNew=document.forms[0].token.value;
	// alert("document.forms[0].captchaTxtBox
	// "+document.forms[0].captchaTxtBox.value)

	var strSecureCode = "" + sessionLoginToken + mobileNo + otp;
	var fhttf = hex_md5(strSecureCode);
	// alert("fhttf"+fhttf)
	
	if(actionURL == 'beneficiaryloginLogin'){
		document.forms[0].fhttf.value = fhttf;

	document.forms[0].action = actionURL;

	document.forms[0].submit();
		
	}else{
		
		document.forms[1].fhttf.value = fhttf;

	document.forms[1].action = actionURL;

	document.forms[1].submit();
	}
	
	

	return false;
	
}
function submitFormOnValidate3(flg, actionURL) {
	/* alert("submitFormOnValidate2::"+flg+"::actionURL::"+actionURL); */
	console.log('6');
	if (flg) {
		console.log('7');
		submitLoginForm2(actionURL);
	}
}

function submitFormOnValidate2(flg, actionURL) {
	/* alert("submitFormOnValidate2::"+flg+"::actionURL::"+actionURL); */
	console.log('6');
	if (flg) {
		console.log('7');
		submitLoginForm2(actionURL);
	}
}


function submitLoginForm1(actionURL , event) {
	

	event.preventDefault();
	
	console.log('7');
	var mobileNo = document.getElementsByName("varMobileNumber")[0].value;
	var otp = document.getElementsByName("varOtp")[0].value;
	 
	var sessionLoginToken = document.forms[0].sessionLoginToken.value;
	// var token='token';
	// var tokenNew=document.forms[0].token.value;
	// alert("document.forms[0].captchaTxtBox
	// "+document.forms[0].captchaTxtBox.value)

	var strSecureCode =   sessionLoginToken + mobileNo + otp;

	var fhttf = hex_md5(strSecureCode);
	document.forms[0].fhttf.value = fhttf;
	console.log('8');

	document.forms[0].action = actionURL;

	document.forms[0].submit();

	/*
	 * $('#generateButton').hide(); $('#validateButton').show();
	 */

}


function submitLoginForm2(actionURL) {
	
	console.log('7');
	var mobileNo = document.getElementsByName("varMobileNumber")[0].value;
	var otp = document.getElementsByName("varOtp")[0].value;
	var mstatus = document.getElementsByName("mstatus")[0].value;
	var sessionLoginToken = document.forms[1].sessionLoginToken.value;
	// var token='token';
	// var tokenNew=document.forms[0].token.value;
	// alert("document.forms[0].captchaTxtBox
	// "+document.forms[0].captchaTxtBox.value)

	var strSecureCode = mstatus + sessionLoginToken + mobileNo + otp;
	var fhttf = hex_md5(strSecureCode);
	document.forms[1].fhttf.value = fhttf;
	console.log('8');

	document.forms[1].action = actionURL;

	document.forms[1].submit();

	/*
	 * $('#generateButton').hide(); $('#validateButton').show();
	 */

}

/**
 * Purpose : To ensure to enter a Alphanumeric Value with Underscore Only
 * Calling On Event : onkeypress Parameters : 1. this & 2. event Return Type :
 * boolean
 * 
 * Ascii Code allowed A-65, Z-90, a-97, z-122, Underscore - 95
 */
function validateAlphaNumWithUnderscoreOnly(obj, e) {
	// alert("Char Code = "+e.charCode+" Key Code = "+e.keyCode);
	var charCode;
	if (typeof e.charCode != 'undefined') // Other
		charCode = e.charCode;
	else
		// IE
		charCode = e.keyCode;
	// alert(charCode);
	if (charCode == 0 || charCode == 95 || (charCode >= 65 && charCode <= 90)
			|| (charCode >= 97 && charCode <= 122)
			|| (charCode >= 48 && charCode <= 57))
		return true;
	else
		return false;
}

/**
 * Purpose : To validate whether a given String is Alphanumeric having
 * Underscore Only Calling On Event : onchange, user-defined way Parameters : 1.
 * val/string to validate Return Type : boolean
 */
function validateAlphaNumWithUnderscoreValue(val) {
	const pattern = /^[a-zA-Z0-9_]*$/;
	
	 const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	
	return (pattern.test(val) || emailRegex.test(val));
}

var Base64 = {
	_keyStr : "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
	encode : function(e) {
		var t = "";
		var n, r, i, s, o, u, a;
		var f = 0;
		e = Base64._utf8_encode(e);
		while (f < e.length) {
			n = e.charCodeAt(f++);
			r = e.charCodeAt(f++);
			i = e.charCodeAt(f++);
			s = n >> 2;
			o = (n & 3) << 4 | r >> 4;
			u = (r & 15) << 2 | i >> 6;
			a = i & 63;
			if (isNaN(r)) {
				u = a = 64
			} else if (isNaN(i)) {
				a = 64
			}
			t = t + this._keyStr.charAt(s) + this._keyStr.charAt(o)
					+ this._keyStr.charAt(u) + this._keyStr.charAt(a)
		}
		return t
	},
	decode : function(e) {
		var t = "";
		var n, r, i;
		var s, o, u, a;
		var f = 0;
		e = e.replace(/[^A-Za-z0-9\+\/\=]/g, "");
		while (f < e.length) {
			s = this._keyStr.indexOf(e.charAt(f++));
			o = this._keyStr.indexOf(e.charAt(f++));
			u = this._keyStr.indexOf(e.charAt(f++));
			a = this._keyStr.indexOf(e.charAt(f++));
			n = s << 2 | o >> 4;
			r = (o & 15) << 4 | u >> 2;
			i = (u & 3) << 6 | a;
			t = t + String.fromCharCode(n);
			if (u != 64) {
				t = t + String.fromCharCode(r)
			}
			if (a != 64) {
				t = t + String.fromCharCode(i)
			}
		}
		t = Base64._utf8_decode(t);
		return t
	},
	_utf8_encode : function(e) {
		e = e.replace(/\r\n/g, "\n");
		var t = "";
		for (var n = 0; n < e.length; n++) {
			var r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r)
			} else if (r > 127 && r < 2048) {
				t += String.fromCharCode(r >> 6 | 192);
				t += String.fromCharCode(r & 63 | 128)
			} else {
				t += String.fromCharCode(r >> 12 | 224);
				t += String.fromCharCode(r >> 6 & 63 | 128);
				t += String.fromCharCode(r & 63 | 128)
			}
		}
		return t
	},
	_utf8_decode : function(e) {
		var t = "";
		var n = 0;
		var r = c1 = c2 = 0;
		while (n < e.length) {
			r = e.charCodeAt(n);
			if (r < 128) {
				t += String.fromCharCode(r);
				n++
			} else if (r > 191 && r < 224) {
				c2 = e.charCodeAt(n + 1);
				t += String.fromCharCode((r & 31) << 6 | c2 & 63);
				n += 2
			} else {
				c2 = e.charCodeAt(n + 1);
				c3 = e.charCodeAt(n + 2);
				t += String.fromCharCode((r & 15) << 12 | (c2 & 63) << 6 | c3
						& 63);
				n += 3
			}
		}
		return t
	}
}

function encryptBase64(val) {
	var encodedString = Base64.encode(val);
	return encodedString;
}

function decryptBase64(encodedString) {
	var decodedString = Base64.decode(encodedString);
	return decodedString;
}


 function goTo(mode){

		 				  
		    		document.forms[0].action = '/AHIMSG5/hissso/'+mode+'Login';
		    		document.forms[0].submit();
		    		
		        }


/* resendotp */

/* $('#resendButton').click(startCountdown); */