function checkURL(vURL){var flg=!0;$.ajax({url:vURL,async:!1,success:function(){flg=!0},error:function(jqXHR,status,er){if(jqXHR.status===404){flg=!1}else if(jqXHR.status===500){flg=!1}}});return flg}
var token_key="fhttf";var csrf_token_key="x-auth-token";var createFHash=function(frmId){var datastring=$("#"+frmId).serializeArray();document.getElementsByName(token_key)[0].value=getHexaCode(datastring)};var getHexaCode=function(datastring){datastring.sort(function(a,b){var a1=a.name.toLowerCase(),b1=b.name.toLowerCase();if(a1==b1)return 0;return a1>b1?1:-1});var myInput="";$.each(datastring,function(index,val){console.log("val.name"+val.name)
console.log("token_key"+token_key)
if(val.name!=token_key){var newVal=val.value;console.log("val.value"+val.value)
newVal=newVal.replace(/\%26/g,"&");newVal=newVal.replace(/ /gi,"_");newVal=newVal.replace(/\%2C/g,",");newVal=unescape(newVal);newVal=newVal.replace(/\n|\r\n|\r/g,'_');if(newVal=='undefined')
newVal='';myInput=myInput+""+newVal}});console.log("str :: "+myInput);return hex_md5(myInput.replace(/\%7C/gi,"|"))};var submitForm=function(){document.forms[0].submit()};var getQueryParameters=function(str){str=str.split('?')[1];var outputArray=new Array();var strVals=str.split("&");for(var i=0;i<strVals.length;i++){var newVals=strVals[i].split("=");var obj={name:""+newVals[0],value:""+newVals[1]};outputArray[i]=obj}
return outputArray};var getJsonParameters=function(obj){var outputArray=new Array();var i=0;for(var prop in obj){var myobj={name:""+prop,value:""+obj[prop]};outputArray[i]=myobj;i=i+1}
return outputArray}
var getFormDataParams=function(obj){var outputArray=new Array();var fileI=0;var i=0;for(var key of obj.keys()){var myobj=null;if(!key.includes("file")){myobj={name:""+key,value:""+obj.get(key)};outputArray[i]=myobj;i=i+1}}
return outputArray}
function readSingleFile(f,id){if(f){var r=new FileReader();r.onload=function(e){var contents=e.target.result;contents=contents.split(',')[1];var encodedFileContent=hex_md5(contents);$("#f_codes"+id).remove();$("<input type='hidden' name='f_codes' class='f_codes' id='f_codes"+id+"' value='"+encodedFileContent+"' />").insertAfter("#fhttf")}
r.readAsDataURL(f)}else{alert("Failed to load file")}}
var createFHashAjaxQuery=function(str){console.log("str------------->>"+str)
var qstring=getQueryParameters(str);console.log("qstring>>>>>"+JSON.stringify(qstring));var hcode=getHexaCode(qstring);console.log("hcode--->>"+hcode);str=str+"&"+token_key+"="+hcode;return str};function sortandEncodebase64(forrmobj){$('#'+token_key).val("");var datastring=$(':input').serializeArray();if(forrmobj!=null){datastring=$(forrmobj).serializeArray()}
$('#'+token_key).val(getHexaCode(datastring))}
try{$(document).ready(function(){if($('#'+token_key).length==0){$('<input>').attr({type:'hidden',id:token_key,name:token_key}).appendTo('form')}(function(){var originalSubmit=document.forms[0].submit;document.forms[0].submit=function(){sortandEncodebase64(document.forms[0]);originalSubmit.apply(document.forms[0]);return!1}})()})}catch(e){alert("Error Message -> "+e.message)}
function showAjaxError(_errorthrown){window.location="/HISRegistration/hissso/jsp/error/sso_error_login_illegalactivity.jsp"}
function getFormData($form){var unindexed_array=$form.serializeArray();var indexed_array={};$.map(unindexed_array,function(n,i){indexed_array[n.name]=n.value});return Base64.encode(JSON.stringify(indexed_array))}
$(document).ready(function(){})