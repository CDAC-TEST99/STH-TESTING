var langJson=null;
var lang=null;
$(document).ready(function () {	
	initTranslate($('#currentLang').val());
});
function initTranslate(currentLang){
	if(currentLang==undefined || currentLang=="null")
		currentLang='en';
	//alert(currentLang);
	if(lang==null || currentLang!=lang){
		//alert('/eUpkaran/global/resources/lang_'+currentLang+'.json');
	 $.ajax({
		 	type: 'GET',
			url : '/eUpkaran/global/resources/lang_'+currentLang+'.json',			
			dataType : "json",
			success : function(json) {
				//alert(JSON.stringify(json));
				langJson=json;	
				convertAllLanguageTags();
				lang=currentLang;
			},
			fail : function() {
				alert("error occured while loading");
			}
		});	
	}
	else{
		convertAllLanguageTags();
	}
}
function convertAllLanguageTags(){
	var tagName="data-langtag";
	
	if(langJson!=null){
		$('body').find("["+tagName+"]").each(function(){
			var key=$(this).attr(tagName);
			//alert(key +"===="+ langJson[key])
			if(langJson[key]!=undefined){
				var val=langJson[key];
				$(this).html(val);				
					
			}
		});		
	}
}

function convertAllLanguageTagsInDiv(divId){
	var tagName="data-langtag";
	
	if(langJson!=null){
		$('#'+divId).find("["+tagName+"]").each(function(){
			var key=$(this).attr(tagName);
			//alert(key +"===="+ langJson[key])
			if(langJson[key]!=undefined){
				var val=langJson[key];
				$(this).html(val);				
					
			}
		});		
	}
}


function convertCurrentTagKey(tagkey){
	if(langJson!=null){
		if(langJson[tagkey]!=undefined && $("[data-langtag='"+tagkey+"']").length>0){
			var val=langJson[tagkey];
			$("[data-langtag='"+tagkey+"']").html(val);
		}		
	}
}

function changeLanguage(){
	var currentLang=$('#language').val();
	 
	 var data={
			 hmode:"changeLanguage",
			 currentLang:currentLang,			
	 }
	
	 $.ajax({
		 	type: 'POST',
			url : '/eUpkaran/EUpkaranMasterACTION',
			data : data,
			dataType : "html",
			success : function(returnStr) {				
					//alert(returnStr)
			},
			fail : function() {
				alert("error occured");
			}
		});
	 initTranslate(currentLang);
	 
}