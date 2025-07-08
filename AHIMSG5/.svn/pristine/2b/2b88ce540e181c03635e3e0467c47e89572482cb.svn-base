function checkURL(vURL) {
	var flg = true;
	$.ajax({
        url:vURL,
        async: false,
        success: function (data) {
        	 
         	if(data.includes("Session is Expired")){
         		flg = false;
         	}else{
         		flg = true;
         	}
         	
        	 
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
	 //alert("1-frmId"+frmId);
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
	        if (val.name != token_key && val.name != 'hmode' &&  val.name != "varSSOTicketGrantingTicket") {
	            var newVal = val.value;
	            console.log("val.value"+val.value)
	            newVal = newVal.replace(/\%26/g, "&"); // replacing & with blanks
	            newVal = newVal.replace(/ /gi, "_");
	            newVal = newVal.replace(/\%2C/g, ","); // replacing + with blanks
	            newVal = newVal.replace(/[*]/g, ""); // replacing * with blanks
	            newVal = unescape(newVal);
	            newVal = newVal.replace(/\n|\r\n|\r/g, '_');

	            if (newVal == 'undefined')
	                newVal = '';
	            myInput = myInput + "" + newVal;
	            console.log("MYINPUT"+myInput)
	            console.log("name >> "+val.name+"  val  >> "+ newVal);
	         
	        }
	    });
	    console.log("str ::>>>SECurity js ahimsg5 " + myInput);
	    return hex_md5(myInput.replace(/\%7C/gi, "|"));
	};

var submitForm = function(){
	document.forms[0].submit();
};


var getQueryParameters = function(str){
	console.log("STRRR1111111>>>AHIMSG5 "+str)
	var outputArray = new Array();
	//alert("str>1>>" + str);
	if(str.indexOf("?")<0){
		return outputArray;
	}
	str = str.split('?')[1];
	console.log("STRRR>>>"+str)
	
	
	var strVals = str.split("&");
	
	for(var i=0; i< strVals.length; i++){
		
		var newVals = strVals[i].split("=");
		var obj = {name:""+newVals[0] , value:""+newVals[1]} ;
		
		outputArray[i] = obj;
		
	} 
	
	console.log("STRRR>4>>"+outputArray)
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
 // alert("5");
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
	
	console.log("str SECURITY JS ahimsg5------------->>"+str)
	//alert("inside testQuery");
	//alert(token_key);
	var qstring = getQueryParameters(str);
	if(qstring!=undefined  && qstring.length>0){
		console.log("qstring>>>>>"+JSON.stringify(qstring));
		var hcode = getHexaCode(qstring);
		
		console.log("hcode--->>"+hcode);
		
		str = str+"&"+token_key+"="+hcode;
	}
	console.log("str"+str);
	return str;
};


var getToken = function(selTabVal) {
	  //alert("7");
  //  var strUrl = "/HBIMS/mms/transactions/MmsCNT.cnt", 
    var strUrl = "/AHIMSG5/hissso/getTokenLogin", 
        strReturn = "";
  
    $.ajax({
        url: strUrl,
        type: "POST",
        dataType: "text",
        data: {
	        hmode:"getToken", 
            selTab: selTabVal
        },
        success: function(html) {
            strReturn = html;
        },
        error: function(err) {
            console.log("Token generation error");
        },
        async: false
    });

 //alert("getToken >> "+strReturn)
    return strReturn;
}


function getFormData($form) {
	 // alert("8");
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i) {
        indexed_array[n['name']] = n['value'];
    });

    return Base64.encode(JSON.stringify(indexed_array));
}


function initSecurityParameterFromajaxjson(datajson){
	
	var json=convertDataToStandardFormat(datajson)
	sortandEncodefhttf(json);
	datajson[token_key]=$('#'+token_key).val();
	//alert(JSON.stringify(datajson));
	return datajson;
}

function convertDataToStandardFormat(datajson){
	var resultJson=new Array();
	var json=
	$.each(datajson, function(k,v){
		if(v==undefined)
			v="";
		if(Array.isArray(v)==false){
			var json = {
				  "name": k,
				  "value":  v.toString()
				};
			resultJson.push(json);
		}
		else{
			for(var i=0;i<v.length;i++){
				var json = {
						  "name": k,
						  "value":  v[i].toString()
						};
				resultJson.push(json);
			}
			
		}
		
	});
	alert("resultJson--" + JSON.stringify(resultJson));
	
	return resultJson;
}
function sortandEncodefhttf(datastring){
	$('#'+token_key).val("");
	datastring.sort(function(a, b){
        var a1= a.name.toLowerCase(), b1= b.name.toLowerCase();
        if(a1== b1) return 0;
        return a1> b1? 1: -1;
    });
	
	var hcode = getHexaCode(datastring);
	//console.log('hcode'+hcode);
	//alert('hcode'+hcode);
	
	$('#'+token_key).val(hcode);
	//alert($('[name='+token_key+']').length);
	alert(JSON.stringify(datastring));
	//$('#'+token_key).val("fhttf"+encryptBase64(JSON.stringify(datastring))+"fhttf");
	//console.log("dbfhttf :: "+document.getElementsByName(token_key)[0].value);
	//return JSON.stringify(datastring);
}

function encryptBase64(val){
	var encodedString  = Base64.encode(val);
	return encodedString ;
}

function decryptBase64(encodedString){
	var decodedString = Base64.decode(encodedString);
	return decodedString;
}


$(document).ready(function() {
  
	$('<input>').attr({
	    type: 'hidden',
	    id: token_key,
	    name: token_key
	}).appendTo('form');
	
	if(window.frameElement == null){
		if(window.parent == null) {
			document.getElementsByTagName("body")[0].innerHTML = "<center>Unauthorized Activity</center>";
			return false;
		}
	}
	 
	var selectedTab = ""; 
	if (window.frameElement)
		selectedTab = window.frameElement.id.split("_")[0].split(" ").join("_");
	else  
		selectedTab = document.forms[0].id.split("_")[0].split(" ").join("_");
	 
	var secSelTab = hex_md5(selectedTab);
	// alert("selectedTab"+secSelTab + "--" +window.frameElement.id.split("_")[0]);
	$('<input>').attr({
	    type: 'hidden',
	    id: csrf_token_key,
	    name: csrf_token_key,
	    value: getToken(secSelTab)
	}).appendTo('form');
 
	(function() {
		 
		 document.forms[0].action = "loginLogin";
	    
    if(selectedTab=="loginForm"){
		var originalSubmit = document.forms[0].submit;
		document.forms[0].submit = function() {
			   
				createFHash($("form").attr("id"));
			 
			originalSubmit.apply(document.forms[0]);
			return false;
		}; } else if($('#validateUserDet').val()==1){
			 
			 document.forms[0].action = "validateChangeUserDetailsLgnFtr";
			var originalSubmit = document.forms[0].submit;
			document.forms[0].submit = function() {
			   
				createFHash($("form").attr("id"));
			 
			originalSubmit.apply(document.forms[0]);
			return false;
		}; }
		else if($('#saveUserDet').val()==1){
			 document.forms[0].action = "saveChangeUserDetailsLgnFtr";
			var originalSubmit = document.forms[0].submit;
			document.forms[0].submit = function() {
			  
			 
				createFHash($("form").attr("id"));
			 
			originalSubmit.apply(document.forms[0]);
			return false;
		};   
			}
			else if($('#changepwd').val()==1){
			 document.forms[0].action = "saveChangePasswordLgnFtr";
			var originalSubmit = document.forms[0].submit;
			document.forms[0].submit = function() {
			  
			 
				createFHash($("form").attr("id"));
			 
			originalSubmit.apply(document.forms[0]);
			return false;
		};   
			}
		 
	})();
	
});	
