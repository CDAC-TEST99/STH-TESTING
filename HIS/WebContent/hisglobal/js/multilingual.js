var multilingualBase64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=multilingualBase64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9\+\/\=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=multilingualBase64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/\r\n/g,"\n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}}

// Language JSON File Location
var language = localStorage.getItem('language');
// Default Language
var default_lang = 'english';

// Set Selected Language
function setLanguage(lang) {
    localStorage.setItem('language', lang);
    language = localStorage.getItem('language');
    
    localStorage.removeItem('langContent');
    
    getLanguage();
    

  

var iframes = document.getElementsByTagName("iframe");



for (var i = 0; i < iframes.length; i++) {

	var id_name = iframes[i].getAttribute("id");
	
	

	if (id_name != "frmMainMenu") {
		var iframe = document.getElementById(id_name);
		
		
		
		var iframeContent = (iframe.contentWindow || iframe.contentDocument);
		
	
		iframeContent.getiFrameLanguage(language);
		
		
	
		
	}
}

var iframe = document.getElementById("frmMainMenu");
if (iframe) {
   var iframeContent = (iframe.contentWindow || iframe.contentDocument);
  
   
   iframeContent.getiFrameLanguage(language);
}
   




 
    
}


function processKeys(lang){
	
	
	   // Loop through message in data        
    $("[key]").each(function() {   
    	
    	if(lang[$(this).attr('key')] === undefined){
    		
    		//console.log($(this).attr('key')+" >> "+$(this).text()+" >> undefined");
        	 
    	}else{
    		
    	//	console.log($(this).attr('key')+" >> "+$(this).text()+" >> "+lang[$(this).attr('key')]);
        	
       	 $(this).text(multilingualBase64.decode(lang[$(this).attr('key')]));
    		
    	}
    	
     
    	});
    
    
    
    $("[key-placeholder]").each(function() { 
      	 $(this).attr("placeholder",multilingualBase64.decode(lang[$(this).attr('key-placeholder')]));
      	});
    
    $("[key-title]").each(function() { 
   	 $(this).attr("title",multilingualBase64.decode(lang[$(this).attr('key-title')]));
   	});
    
    $("[key-value]").each(function() { 
     	 $(this).attr("value",multilingualBase64.decode(lang[$(this).attr('key-value')]));
     	});
    
    
  //  console.log("above keyColumnVal ");
     
    $(".keyColumnVal").each(function() { 
     	
    	
     // 	console.log('inside else >> '+$(this).html());
     	
     	var langString = '{"key-name" : "'+$(this).html().trim()+'" }';
     	
     	//console.log(langString);
     	
     	var langObj =  JSON.parse(langString);
     	 
       	 $(this).html(multilingualBase64.decode(langObj['key-name'] ));
      	 
      // 	console.log("below");
       	 
      	});
     
    
	
	
}



function getLanguage() {
	 
	 
	//console.log("inside getLanguage ");
	 
	
	
	setLanguageHighlight(language);
    // Language on user preference
    (language == null) ? setLanguage(default_lang) : false;
    // Load data of selected language
    
   // console.log(" langContent >> "+localStorage.getItem('langContent'));
    
    if(localStorage.getItem('langContent') == null){
    	
    	
    	 $.ajax({
    	        url: '/UserMgmt_HIS/MultilingualServlet?mode=getlang&langname='+language+'&t=' + new Date().getTime(),
    	        dataType: 'json', async: true
    	    }).done(function (lang) {
    	        
    	    	//  console.log("res >> "+lang);
    	    	
    	    	
    	    	
    	    	localStorage.setItem('langContent', JSON.stringify(lang));
    	    	
    	    	processKeys(lang)
    	        
    	        
    	    });
    	
    }else{
    	
    	var lang = JSON.parse(localStorage.getItem('langContent'));
    	
          	
    	processKeys(lang)
    }
    
    if (typeof validationExtent !== "undefined") { 
        // safe to use the function
    	validationExtent();
    }
   
}

function getiFrameLanguage(language) {
	 
    // Load data of selected language
	 
	//console.log(" iframe langContent >> "+localStorage.getItem('langContent'));
	
	 if(localStorage.getItem('langContent') == null){
	    	
	    	
    	 $.ajax({
    	        url: '/UserMgmt_HIS/MultilingualServlet?mode=getlang&langname='+language+'&t=' + new Date().getTime(),
    	        dataType: 'json', async: true
    	    }).done(function (lang) {
    	        
    	    	//  console.log(" iframe res >> "+lang);
    	    	
    	    	localStorage.setItem('langContent', JSON.stringify(lang));
    	    	
    	    	processKeys(lang)
    	        
    	        
    	    });
    	
    }else{
    	
    	var lang = JSON.parse(localStorage.getItem('langContent'));
    	
          	
    	processKeys(lang)
    }
     
 
}



function setLanguageHighlight(language){
	
	 if((language != null)){
	    	 	    	
	    	$("#selectLanguage").val(language);
	    	

	    	if(window.opener){
	    			
	    		 getiFrameLanguage(language);
	    		
	    	}
	    	
	    }
}


function isBase64(str) {
    if (str ==='' || str.trim() ===''){ return false; }
    try {
        return btoa(atob(str)) == str;
    } catch (err) {
        return false;
    }
}
 

function createCustomAlert(txt) {
	
	var ALERT_TITLE = $("#alert-message").html();
	var ALERT_BUTTON_TEXT = $("#ok").html();
	
	
	d = document;

	 var dt = new Date();
	  var n = dt.getTime();
	
	if(d.getElementById("modalContainer"+n)) return;

	mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
	mObj.id = "modalContainer"+n;
	mObj.className = "modalContainer";
	mObj.style.height = d.documentElement.scrollHeight + "px";
	
	alertObj = mObj.appendChild(d.createElement("div"));
	alertObj.id = "alertBox";
	if(d.all && !window.opera) alertObj.style.top = document.documentElement.scrollTop + "px";
	alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth)/2 + "px";
	alertObj.style.visiblity="visible";

	h1 = alertObj.appendChild(d.createElement("h1"));
	h1.appendChild(d.createTextNode(ALERT_TITLE));

	msg = alertObj.appendChild(d.createElement("p"));
	//msg.appendChild(d.createTextNode(txt));
	msg.innerHTML = "<br><b>"+txt+"</b>";

	btn = alertObj.appendChild(d.createElement("a"));
	btn.id = "closeBtn";
	btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
	//btn.href = "";
	btn.focus();
	btn.onclick = function() { removeCustomAlert(n);return false; };

	alertObj.style.display = "block";
	
}

 
function createCustomConfirm(txt ,callback,callbackCancel, caption)  {
	
	var ALERT_TITLE = $("#confirm-dialog").html();
	var ALERT_BUTTON_TEXT = $("#yes").html();
	var CANCEL_BUTTON_TEXT = $("#no").html();
	
	
	d = document;

	 var dt = new Date();
	  var n = dt.getTime();
	
	if(d.getElementById("modalContainer"+n)) return;

	mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
	mObj.id = "modalContainer"+n;
	mObj.style.height = d.documentElement.scrollHeight + "px";
	mObj.className = "modalContainer";
	
	alertObj = mObj.appendChild(d.createElement("div"));
	alertObj.id = "alertBox";
	if(d.all && !window.opera) alertObj.style.top = document.documentElement.scrollTop + "px";
	alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth)/2 + "px";
	alertObj.style.visiblity="visible";

	h1 = alertObj.appendChild(d.createElement("h1"));
	h1.appendChild(d.createTextNode(ALERT_TITLE));

	msg = alertObj.appendChild(d.createElement("p"));
	//msg.appendChild(d.createTextNode(txt));
	msg.innerHTML = "<br><b>"+txt+"</b>";

	divObj = mObj.appendChild(d.createElement("div"));
	divObj.style.marginLeft ="20%";
 	
	btn = divObj.appendChild(d.createElement("span"));
	btn.id = "yesBtn";
	btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
	//btn.href = "";
	btn.focus();
	btn.onclick = function() { 
		 
		removeCustomAlert(n); 
		 
		 callback();
		 
		
		return true; };
	
	
	btnNo = divObj.appendChild(d.createElement("span"));
	btnNo.id = "noBtn";
	btnNo.appendChild(d.createTextNode(CANCEL_BUTTON_TEXT));
	//btn.href = "";
	btnNo.focus();
	btnNo.onclick = function() { removeCustomAlert(n); callbackCancel(); return false; };
	
	alertObj.appendChild(divObj);
	alertObj.style.display = "block";
}


function removeCustomAlert(n) {
	document.getElementsByTagName("body")[0].removeChild(document.getElementById("modalContainer"+n));
	return;
}

window.alert = function(txt) {
	createCustomAlert(txt);
};

window.confirm  =  function(message, callback,callbackCancel, caption) {
	createCustomConfirm(message, callback,callbackCancel, caption);
};

// Auto Loader
$(document).ready(function () {
	 	 
	$("body").append("<div id='alert-message' key='alert-message' style='display:none' >Alert Message</div>");
	$("body").append("<div id='confirm-dialog' key='confirm-dialog' style='display:none' >Confirm Dialog</div>");
	$("body").append("<div id='ok' key='ok' style='display:none' >Ok</div>"); 
	$("body").append("<div id='yes' key='yes' style='display:none' >Yes</div>");
	$("body").append("<div id='no' key='no' style='display:none' >No</div>"); 
	
	
	
	$("head").append("<style> .modalContainer { background-color:rgba(0, 0, 0, 0.3); position:absolute; width:100%; height:100%; top:0px; left:0px; z-index:10000; }  #alertBox { position:relative; width:400px; min-height:140px; margin-top:50px; border:1px solid #666; background-color:#fff; background-repeat:no-repeat; background-position:20px 30px; }  #modalContainer > #alertBox { position:fixed; }  #alertBox h1 { margin:0; font:bold 0.9em verdana,arial; background-color:#3073BB; color:#FFF; border-bottom:1px solid #000; padding:2px 0 2px 5px; } #alertBox p { font:0.7em verdana,arial; height:50px; padding-left:5px; margin-left:55px; } #alertBox #closeBtn { display:block; position:relative; margin:5px auto; padding:7px; border:0 none; width:70px; font:0.7em verdana,arial; text-transform:uppercase; text-align:center; color:#FFF; background-color:#357EBD; border-radius: 3px; text-decoration:none; cursor:pointer }   #yesBtn { display:block; position:relative; margin:5px auto; padding:7px; border:0 none; width:70px; font:0.7em verdana,arial; text-transform:uppercase; text-align:center; color:#FFF; background-color:#357EBD; border-radius: 3px; text-decoration:none; cursor:pointer; float: left; } #noBtn { display:block; position:relative; margin:5px auto; padding:7px; border:0 none; width:70px; font:0.7em verdana,arial; text-transform:uppercase; text-align:center; color:#FFF; background-color:#357EBD; border-radius: 3px; text-decoration:none; cursor:pointer; float: left; margin-left: 2%; }  	#mContainer { position:relative; width:600px; margin:auto; padding:5px; border-top:2px solid #000;	border-bottom:2px solid #000; font:0.7em verdana,arial; } h1,h2 { margin:0; padding:4px; font:bold 1.5em verdana; border-bottom:1px solid #000; }  code { font-size:1.2em; color:#069; } #credits { position:relative; margin:25px auto 0px auto; width:350px; font:0.7em verdana; border-top:1px solid #000; border-bottom:1px solid #000; height:90px; padding-top:4px; } #credits img { float:left; margin:5px 10px 5px 0px; border:1px solid #000000; width:80px; height:79px; }  .important { background-color:#F5FCC8; padding:2px; }  code span { color:green; } </style> ");
	 
	
	
	
	
    if (language != null && language !== default_lang){
    	 
    	 getLanguage(language);
    	
    }else{
    	setLanguageHighlight(language);
    }
       
});



