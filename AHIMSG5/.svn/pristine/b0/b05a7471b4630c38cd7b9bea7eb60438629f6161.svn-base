function checkURL(vURL) {
	var flg = true;
	$.ajax({
        url:vURL,
        async: false,
        success: function () {
        		flg = true;
        },
        error: function (jqXHR, status, er) {
            // only set the error on 404
            if (jqXHR.status === 404) { 
            	flg = false;
            }
            else if (jqXHR.status === 500) { 
            	flg = false;
            }
        }
    });
	return flg;
} 

var token_key = "fhttf";
var csrf_token_key = "x-auth-token"; 

var createFHash = function(frmId) {
	// alert("1-frmId"+frmId);
	var datastring = $("#"+frmId).serializeArray();
	document.getElementsByName(token_key)[0].value = getHexaCode(datastring);
	
};

var getHexaCode = function(datastring) {
 //alert("2-datastring"+datastring);
    datastring.sort(function(a, b) {
        var a1 = a.name.toLowerCase(),
            b1 = b.name.toLowerCase();
        if (a1 == b1) return 0;
        return a1 > b1 ? 1 : -1;
    });

    var myInput = "";

    $.each(datastring, function(index, val) {
    	console.log("val.name"+val.name)
		console.log("token_key"+token_key)
        if (val.name != token_key) {
            var newVal = val.value;
            console.log("val.value"+val.value)
            newVal = newVal.replace(/\%26/g, "&"); // replacing & with blanks
            newVal = newVal.replace(/ /gi, "_");
            newVal = newVal.replace(/\%2C/g, ","); // replacing + with blanks
            newVal = unescape(newVal);
            newVal = newVal.replace(/\n|\r\n|\r/g, '_');

            if (newVal == 'undefined')
                newVal = '';
            myInput = myInput + "" + newVal;
  
        }
    });
    console.log("str :: " + myInput);
    return hex_md5(myInput.replace(/\%7C/gi, "|"));
};

var submitForm = function(){
	document.forms[0].submit();
};

var getQueryParameters = function(str){
 //alert("3");
	str = str.split('?')[1];
	var outputArray = new Array();
	var strVals = str.split("&");
	for(var i=0; i< strVals.length; i++){
		var newVals = strVals[i].split("=");
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		outputArray[i] = obj;
	} 
	
	return outputArray;
};

var getJsonParameters = function(obj){
	// alert("4");
	var outputArray = new Array();
	
	var i =0;
	for (var prop in obj) {
		var myobj = {name:""+prop , value:""+obj[prop]} ;
		outputArray[i] = myobj;
		i = i + 1;
		 
	}

	return outputArray;
	
}
 

var getFormDataParams = function(obj) {
 //alert("5");
    var outputArray = new Array();
    var fileI = 0;
    var i = 0;
    for (var key of obj.keys()) {
        var myobj = null;

        if (!key.includes("file")) {
            myobj = {
                name: "" + key,
                value: "" + obj.get(key)
            };

            outputArray[i] = myobj;
            i = i + 1;
        }
    }
    return outputArray;
}


function readSingleFile(f, id) {
    if (f) {
        var r = new FileReader();
        r.onload = function(e) {
            var contents = e.target.result;
            contents = contents.split(',')[1];
            var encodedFileContent = hex_md5(contents);
            $("#f_codes" + id).remove();
            $("<input type='hidden' name='f_codes' class='f_codes' id='f_codes" + id + "' value='" + encodedFileContent + "' />").insertAfter("#fhttf");

        }
        r.readAsDataURL(f);

    } else {
        alert("Failed to load file");
    }
}

var createFHashAjaxQuery = function(str){
	
	console.log("str------------->>"+str)
	//alert("inside testQuery");
	//alert(token_key);
	var qstring = getQueryParameters(str);
	console.log("qstring>>>>>"+JSON.stringify(qstring));
	var hcode = getHexaCode(qstring);
	
	console.log("hcode--->>"+hcode);
	
	str = str+"&"+token_key+"="+hcode;
	//alert("str"+str);
	return str;
};

/*var createFHashAjaxQuery = function(str) {
	// alert("6");
	var mystr = "";
	 
	  if(checkURL('/IMCS/hislogin/initChangePasswordLgnFtr.fp') || checkURL('/IMCS/hislogin/validateChangeUserDetailsLgnFtr.fp') ) {
		   
		  var qstring = getQueryParameters(str);
			console.log(qstring);
			var hcode = getHexaCode(qstring);
			mystr = str+"&"+token_key+"="+hcode;
		  
	  } else {
		  
		  mystr = "/IMCS/hissso/jsp/error/sso_error_login_appnotavail.jsp?a=0";
		  
	  }
	// alert("mystr"+mystr);
	  return mystr;
};*/


function sortandEncodebase64(forrmobj){
	
	
	//alert("inside sortandEncodebase64 " + forrmobj)
	
	$('#'+token_key).val("");
	var datastring = $(':input').serializeArray();
	if(forrmobj!=null){
			//alert("form is ==" + $(forrmobj).attr("name"));
		datastring=$(forrmobj).serializeArray();
	}
	 
//	alert(token_key+"  "+$('[name='+token_key+']').length);
 //console.log(JSON.stringify(datastring));
	$('#'+token_key).val(getHexaCode(datastring) );
	//console.log("abfhttf :: "+document.getElementsByName(token_key)[0].value);
//	alert("abfhttf :: "+document.getElementsByName(token_key)[0].value);
	//alert(document.getElementsByName(token_key)[0].value);
	//return JSON.stringify(datastring);
}


try{
	$(document).ready(function() {
		//alert(document.getElementById(token_key));
		//if(document.getElementById(token_key)==undefined || document.getElementById(token_key)==null){
		if($('#'+token_key).length==0){
			$('<input>').attr({
			    type: 'hidden',
			    id: token_key,
			    name: token_key
			}).appendTo('form');
		}
		
		 
		 	
		
		  (function(){
			  
			  var originalSubmit = document.forms[0].submit;
			 
			  document.forms[0].submit = function(){
				 // alert("here");
				  sortandEncodebase64(document.forms[0]);
				  //createFHash();			  
			   // Call the original submit() function to actually submit the form
			    // Per Aria's suggestion below keeping the "this" binding consistent
			    originalSubmit.apply(document.forms[0]);

			    return false;
			  };
			 
			})();
		//}	
	});
	}catch(e)
	{
		alert("Error Message -> "+e.message);
	}

	function showAjaxError(_errorthrown)
	{
		//alert(_funcName +": "+_errorMsg+" textstatus::"+_textstatus+" errorthrown::"+_errorthrown);	
		window.location = "/HISRegistration/hissso/jsp/error/sso_error_login_illegalactivity.jsp";
			
	}

//var getToken = function(selTabVal) {
//	  //alert("7");
//    var strUrl = "/FP_DVDMS/mms/transactions/MmsCNT.cnt", 
//        strReturn = "";
//  
//    $.ajax({
//        url: strUrl,
//        type: "POST",
//        dataType: "text",
//        data: {
//	        hmode:"getToken", 
//            selTab: selTabVal
//        },
//        success: function(html) {
//            strReturn = html;
//        },
//        error: function(err) {
//            console.log("Token generation error");
//        },
//        async: false
//    });
//
////alert("strReturn>>"+strReturn);
//    return strReturn;
//}


function getFormData($form) {
	// alert("8");
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return Base64.encode(JSON.stringify(indexed_array));
}



$(document).ready(function () {
	 
	 
	
	
});	
