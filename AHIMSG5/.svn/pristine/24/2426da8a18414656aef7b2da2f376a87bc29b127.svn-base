$(document).ready(function() {
	 $('#divForIframe_1').hide();
	 $( "button" )
		.click(function( event ) {
		event.preventDefault();
		});
		$( "input[type=button], button" )
			.click(function( event ) {
			event.preventDefault();
		});
		
		getBenDetail()
		checkForMenuAsDeskListpage();
		hidePreloader();
});


function getBenDetail(){
	var configJson={
			serviceName:"/getData/getBenDetail",			    					
			callBackFunctionName:"callbackGetBenDetail",
			isDataStoredInSession:"Yes"			
		};
	
	callFormFlowXService(configJson);
}


function callbackGetBenDetail(configJson, dataJson){
	//alert(JSON.stringify(dataJson));
	
	$('#modules').empty();
		if(dataJson!=undefined &&  dataJson["data"].length>0){
			var moduleJson=dataJson["data"]	;
		var firstname=null;	
		 
		var cardColor=null
		
		
		$.each(moduleJson, function(indx, objModuleJson){
			//alert(JSON.stringify(objModuleJson));
			var namewithoutspace= objModuleJson["Name"].replace(/\s+/g, '');
			var active="";
			
			if(indx==0){
				active="moduleiconActive";
				firstname=namewithoutspace;
				cardColor=objModuleJson["cardcolor"];
			}
			var benId = objModuleJson["Benificiary Id"];
			var html = "<div class='row'>";
	        html += "<div class='col-lg-12 moduleicon modVertical "+active+" '  data-moduleDisplayName='" + objModuleJson["Name"] + "' data-moduleName='" + namewithoutspace + "' id='sideModule_" + namewithoutspace + "'>";
	        html += "<div class='row'>";
	        html += "<div class='col-12 text-center'>"; 
	        html += "<span class='' style='display: inline-flex; align-items: center;'>"; // Ensures inline display
	        html += "<img style='width:60px;height: 60px;' id='imgProfilePic_"+objModuleJson["Benificiary Id"]+"' src='"+objModuleJson["Photograph"]+"'  class='cutumIcons' >"
	        html += "<span id='jsonprofile_"+ namewithoutspace+ "' style='display:none'>"+JSON.stringify(objModuleJson)+"</span>";
	        html += "</span>";
	        html += "</div>";
		    html += "<div class='col-12 mt-1 text-center moduletext'>" + objModuleJson["Name"] + "</div>";      
		    html += "</div>";
		    html += "</div>";                        
		    html += "</div>";			
			//alert(html);
		    $('#moduleId').append("<option value='"+namewithoutspace +"'>"+objModuleJson["Name"] +"</option>")
			$('#modules').append(html);
		    BenProfilesSmallCard(objModuleJson);
		});
		$('.moduleicon').click(function(){
			var moduleName= $(this).attr("data-moduleName");
			$('.moduleicon').removeClass('moduleiconActive');			
			$('#divMenuContainer').show();
			$(this).addClass('moduleiconActive');
			setBenProfile(objModuleJson);	
		});
		if(moduleJson.length>1){
			$('#sectionallbenIds').show();
			$('#sectionModules').hide();
		}
		else{
			setBenProfile(firstname);	
		}
		
		
		if(cardColor!="")
			$('#benDtl').addClass("patHeader-"+cardColor);
		else
			$('#benDtl').addClass("patHeader-default");
		

		
		if(cardColor!="")
			$('#patient_profile').addClass("patHeader-"+cardColor);
		else
			$('#patient_profile').addClass("patHeader-default");

		
		$('#moduleId').val(firstname)
		
		$('#moduleId').change(function(){
			var moduleName= $(this).val();
			//alert(moduleName);
			$('.moduleicon').removeClass('moduleiconActive');	
			$('#sideModule_'+ moduleName).addClass('moduleiconActive');
			setBenProfile(moduleName);
		});
		
	}
	
}
function BenProfilesSmallCard(json){
	var benId = json["Benificiary Id"];
	var imgSrc=json['Photograph'];
	var html =`<div class="col-md-6 " >
			<div class="card profileCard">
                <div class="card-body pt-3" style="width: 100% !important">
                <div class="row" >
				<div class="col-md-3 text-center" >
            		<img src="${imgSrc}"style="width:125px;height:125px;border-radius: 10px;" alt="Profile Picture">
        		</div>
        		<div class="col-md-9">
					<div class="row">
						<div class="col-md-12"><h4><strong>${json["Name"]}</strong></h4></div> 
						<div class="col-md-12"><h4><strong>Ben ID : </strong>${benId}</h4></div>
						<div class="col-md-12"><h6><strong>Gender/Age : </strong>${json["Gender"]}/${json["AGE"]}</h6></div>
						<div class="col-md-12"><h6><strong>Card Type : </strong>${json["card_type"]}</h6></div>
						<div class="col-md-12"><h6><strong>Card Expiry Date : </strong>${json["Expiry_date"]}</h6></div>
						<div class="col-md-12"><h6><strong>Relation : </strong>${json["relation"]}<h6></div>
					</div>
				</div>
        	</div>
		</div> 
		</div>`;
	$('#allbenIds').append(html);
}
function setBenProfile(moduleName){
	
	
	var json = JSON.parse($('#jsonprofile_'+moduleName).text());
	var benId = json["Benificiary Id"];
	var imgSrc =$('#imgProfilePic_'+benId).attr("src");
	
	
	var html =`<div class="row">
	            <div class="col-md-2 text-center" >
	                <img src="${imgSrc}" style='width:125px;height:125px;border-radius: 10px;' alt="Profile Picture">
	            </div>
	            <div class="col-md-9">
					<div class="row">
						<div class="col-md-4"><h4><strong>${json["Name"]}</strong></h4></div> 
						<div class="col-md-4"><h4><strong>Ben ID : </strong>${benId}</h4></div>
						<div class="col-md-4"><h6><strong>Gender/Age : </strong>${json["Gender"]}/${json["AGE"]}</h6></div>
					</div>
					<div class="row mt-2">	
						<div class="col-md-4"><h6><strong>Card Type : </strong>${json["card_type"]}</h6></div>
						<div class="col-md-4"><h6><strong>Card Expiry Date : </strong>${json["Expiry_date"]}</h6></div>
						<div class="col-md-4"><h6><strong>Relation : </strong>${json["relation"]}<h6></div>
					</div>
					<div class="row mt-2">	
						<div class="col-md-12"><h6><strong>Parent Welness Center : </strong>${json["parentWelnessCenter"]}<h6></div>						                  
					</div>
	            </div>
	        </div>`;
	$('#selectedBenId').val(benId);
	$('#benDtl').html(html);
	
	
	initModuleHTML();	
	hideMainCotainerIfEmpty();
	
	$('.drill-down-container').hide();

  // Go back to the parent module
  $('.back-button').click(function () {			    	  
    $(this).closest('.drill-down-container').hide(); // Hide the drill-down section
    var key=$(this).attr("id").split("_")[1];
    var arrKey=key.split("-");
    var processType=arrKey[1];
    var selectedModuleId= $('#selectedModuleId').val();
   // alert(selectedModuleId);
    if(selectedModuleId!=""){
    	$("[id^='boxcol_"+selectedModuleId+"'][id*='"+processType+"']").show();    	
    }
    else{
    	 $("[id^='boxcol_'][id*='"+processType+"']").show();
    }
    
    $('html, body').animate({ scrollTop: $('#menu_'+ key).offset().top-50}, 500);
  });
	
}



function checkForMenuAsDeskListpage(){
	var configJson={
			serviceName:"/getData/checkForMenuAsDeskListpage",			    					
			callBackFunctionName:"callCheckForMenuAsDeskListpage",
			isDataStoredInSession:"No"			
		};
	
	callFormFlowXService(configJson);
}


function callCheckForMenuAsDeskListpage(configJson, dataJson){
	
	if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
		//alert(JSON.stringify(dataJson["data"]));	
		$('#deskIntermediateMenuList').html(JSON.stringify(dataJson["data"]));
	}					
	
	
}

function refreshIFrame(){					
	var url = $('#selectedMenuUrl').val();	
	loadInIframe(1, url);
}
function menuBoxClick(objMenu){
	 var key=$(objMenu).attr('id').split("_")[1];
	 const target = $(objMenu).attr('data-target');
	 
     if(target!=undefined){
	       // alert(target);
	 	const drillDown = $('#' + target);
        if (drillDown.length > 0) { // Check if the drill-down container exists
        	var arrKey=key.split("-");
        	var processType=arrKey[1];
        	$("[id^='boxcol_'][id*='"+processType+"']").hide();        	
            drillDown.show(); // Show the corresponding drill-down row
            $('html, body').animate({ scrollTop: $(drillDown).offset().top-50}, 500);
            $('#' + target).find('.box-col').show('slow');
            
        }
    	 
     }
     else{
    	
    	 //alert(key);
    	 //alert("menuBoxClick>>>" + $('#menuJson_'+key).text());
    	 var menujsonObj= JSON.parse($('#menuJson_'+key).text());
    	 if( $(objMenu).attr("data-isdeskmenu")==0){
	    	 var url=menujsonObj["url"]
	    	 if(url!=undefined && url!=""){
	    		 $('#selectedMenuUrl').val(url);
	    		 $('#divForIframe_1').show();
	    		 $('#sectionModules').hide();
	    		 showHideMenuPage(0);
	    		 loadInIframe("1", url);
	    	 }
    	 }
    	 else{
    		 
    		 OpenDeskListing(menujsonObj);
    	 }
     }
}

function resetSearch(){
	$('#search').val("");	
	$('[id^=mainContainerSearch]').hide();
	$('#rowSearch').empty();
	
	filterModuleProcesses("All");
}

function filterModuleProcesses(moduleNameWithoutSpace){
	//alert(moduleNameWithoutSpace);
	$('#mainContainerSearch').hide();
	
	if(moduleNameWithoutSpace=="All"){
		$('.box-col').show()		
		$('.moduleicon').removeClass('moduleiconActive')
		
		if($("[id^='boxcol_'][id*='Services']").length>0){
			$('#mainContainer_Services').show();
		}
		if($("[id^='boxcol_'][id*='Reports']").length>0){
			$('#mainContainer_Reports').show();
		}
		if($("[id^='boxcol_'][id*='Setup']").length>0){
			$('#mainContainer_Setup').show();
		}
		return;
	}
	
	$('[id^=mainContainer_]').show();	
	$('.moduleicon').removeClass('moduleiconActive')
	$('.box-col').hide();
	$('[id^=boxcol_'+moduleNameWithoutSpace+']').show();
	
	
	
	if($('[id^=menu_'+moduleNameWithoutSpace+'-Services]').length==0){
		$('[id^=mainContainer_Services]').hide();		
	}
	if($('[id^=menu_'+moduleNameWithoutSpace+'-Reports]').length==0){
		$('[id^=mainContainer_Reports]').hide();		
	}
	if($('[id^=menu_'+moduleNameWithoutSpace+'-Setup]').length==0){
		$('[id^=mainContainer_Setup]').hide();		
	}
	
	$('html, body').animate({ scrollTop: 0}, 1000);
	
}


function initModuleHTML(){
	
	//alert("inside initModuleHTML");
	$('#mainContainer').empty();
	if($('#moduleJson').html()!=""){
		var moduleJson=JSON.parse($('#moduleJson').html());		
		$.each(moduleJson, function(indx, modObj){
			var moduleMainId=modObj["moduleNameWithoutSpace"];
			var html='';
			var html='';
			var jsonReturn=createBoxMenus(modObj["MenuLevel1"]);
			var totalLevel1Menus=jsonReturn["totalLevel1Menus"];
			var menuLevel1HTML =jsonReturn["html"] ;
			if(totalLevel1Menus !=0){
				$('#mainContainer').append(menuLevel1HTML);
			
			var menuLevel2HTML= createDrillDownMenu(modObj["MenuLevel1"])
			if(menuLevel2HTML!=''){
				$('#mainContainer').append(menuLevel2HTML)
			}
		  }
		});
	}
}
function createBoxMenus(arrMenu){
	
	var html ='';
	var jsonReturn={};
	var totalMenus=0;
	if(arrMenu==undefined)
		return html;
	
	var arrMenuLevel1=arrMenu;
	/*converting level level 1 object to Array if only one object found*/
	if (!Array.isArray(arrMenu)) {
		arrMenuLevel1=new Array();
		arrMenuLevel1.push(arrMenu);
	}

	$.each(arrMenuLevel1, function(indx, objmenu){
		var processType=objmenu["processType"];
		
		var drilldown="";
		var id=objmenu["moduleNameWithoutSpace"]+"-"+ processType+"-"+ objmenu["menuid"];
		var leafClass='leaf';
		var iconColorClass="";
		var isDeskMenu="0";
		if(processType=="Services")
			iconColorClass="icon-green";
		else if(processType=="Reports")
			iconColorClass="icon-purple";
		else
			iconColorClass="icon-blue";
		
		var  icon=  objmenu["font_icon_name"];
		if(icon=="")
			icon="fas fa-file-medical";
		if(objmenu["MenuLevel2"]!=undefined){
			objmenu=checkIfListPageRequired(objmenu);
			iconColorClass="icon-drill";
			if(objmenu["desk_url"]==undefined || objmenu["desk_url"]==""){
				leafClass="";
				drilldown='data-target="drillDown_'+id+'"';				
				icon="fa-classic fa-solid fa-arrows-down-to-line fa-fw";
			}else{
				//console.log("desk json>>>>"+  JSON.stringify(objmenu));
				isDeskMenu="1";
				icon="fa-classic fa-solid fa-table-list fa-fw";
			}
		}
		
		html+='<div class="col-lg-2 col-md-4 col-sm-4 col-4  box-col '+leafClass+'" id="boxcol_'+id+'"  data-menuName="'+objmenu["menuName"]+'" >';
			html +='<div class="box" '+drilldown+' id="menu_'+id+'" data-IsDeskMenu="'+isDeskMenu+'" onclick="menuBoxClick(this)" >';
				html +='<div class="icon-container">';
					html +='<div class="icon '+iconColorClass+'"><i class="'+icon+'"></i></div>';
				html +='</div>';
				html +=' <div class="text">'+objmenu["menuName"]+'</div>';
				html +=' <span style="display:none;" id="menuJson_'+id+'">'+JSON.stringify(objmenu)+'</span>';
			html +='</div>';
		html +='</div>';
		totalMenus++;
	});
	jsonReturn["totalLevel1Menus"]=totalMenus;
	jsonReturn["html"]=html;
	
	return jsonReturn;
}
function createDrillDownMenu(arrMenu){
	var html ='';
	if(arrMenu==undefined)
		return html;
	var arrMenuLevel1=arrMenu;
	/*converting level level 1 object to Array if only one object found*/
	if (!Array.isArray(arrMenu)) {
		arrMenuLevel1=new Array();
		arrMenuLevel1.push(arrMenu);
	}
	var iconColorClass="";
	
	$.each(arrMenuLevel1, function(indx, objlevel1Menu){
		var processType=objlevel1Menu["processType"];
		if(processType=="Services")
			iconColorClass="icon-green";
		else if(processType=="Reports")
			iconColorClass="icon-purple";
		else
			iconColorClass="icon-blue";
		/*checking if drill down exists*/
		if(objlevel1Menu["MenuLevel2"]!=undefined){
			
			var obj= checkIfListPageRequired(objlevel1Menu);
			
			if(obj["desk_url"]!=undefined && obj["desk_url"]!="")
				return;
			
			
			var arrlevel2= objlevel1Menu["MenuLevel2"];
			if (!Array.isArray(objlevel1Menu["MenuLevel2"])) {
				arrlevel2=new Array();
				arrlevel2.push(objlevel1Menu["MenuLevel2"]);
			}
			
			
			var id=objlevel1Menu["moduleNameWithoutSpace"]+ "-"+ processType+"-"+ objlevel1Menu["menuid"];
			html +='<div class="row drill-down-container" style="display:none;" id="drillDown_'+id+'">';
			html +='<div class="col-4 p-2" >';
			html +='<h6 class="processTypeHeading" style="text-align:left">'+objlevel1Menu["menuName"] + '</label>' ;
			html +='</div>';
			html +='<div class="col-8 p-2" style="text-align:right;">';
			html +='<button class="back-button btn-his-sm" id="back_'+id+'">Go Back</button>';
			html +='</div>';
			$.each(arrlevel2,function(indx, objmenuLevel2){
				var leafClass='';
				if(objmenuLevel2["url"]!="")
					leafClass='leaf';
				
				var  icon=  objmenuLevel2["font_icon_name"];
				if(icon=="")
					icon="fas fa-file-medical";
				var menuId=objmenuLevel2["moduleNameWithoutSpace"]+"-"+ objmenuLevel2["processType"]+"-"+ objmenuLevel2["menuid"];
				html +='<div class="col-lg-3 col-md-6 col-sm-6 col-6 box-col '+leafClass+'"  data-menuName="'+objmenuLevel2["menuName"]+'">';
				html +='<div class="box" id="menu_'+menuId+'" data-isdeskmenu="0"  onclick="menuBoxClick(this)">';
				html +='<div class="icon-container">';
				html +='<div class="icon '+iconColorClass+'"><i class="'+icon+'"></i></div>';
				html +='</div>';
				html +='<div class="text">'+objmenuLevel2["menuName"]+'</div>';
				html +=' <span style="display:none;" id="menuJson_'+menuId+'">'+JSON.stringify(objmenuLevel2)+'</span>';
				html +='</div>';
				html +='</div>';
			});
			html +='</div>';
		}
	});
	
	
	return html;
}

function loadInIframe(key, uri){
	
	if(uri.includes("#USERID#")){
		uri=uri.replace("#USERID#", btoa($('#userId').val()))
	}
	if(uri.includes("#HOSPITALCODE#")){
		uri=uri.replace("#HOSPITALCODE#", $('#hospitalCode').val())
	}
	
	//alert("inside loadInIframe >>>uri>>" + uri);
	 uri = createFHashAjaxQuery(uri);
	
	
	 //var url=decryptBase64($(this).attr("data-url"));
	 if(uri.indexOf("?")==-1)
		 uri+= "?varSSOTicketGrantingTicket=" + document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
	 else
		uri+= "&varSSOTicketGrantingTicket=" + document.getElementsByName("varSSOTicketGrantingTicket")[0].value;	

	   
	console.log("uri is"+uri);
	
	//alert($('#iframecss_'+key).length);
	 $('#iframecss_'+key).attr("src",uri);
	   
	 $('#preloader').show();
	 $('#iframecss_'+key).on('load', function(){
		$('#preloader').delay(550).fadeOut('slow');	
		
	}); 
	 
}
function showHideMenuPage(status){
	if(status==1){
		$('#sectionModules').show();		 
		 $('#btnShowIFrame').show();
		 
		 $('#divForIframe_1').hide();
		 $('#btnShowMenu').hide();
		 $('#btnRefreshFrame').hide();
	}
	else{
		$('#sectionModules').hide();		 
		 $('#btnShowIFrame').hide();
		 
		 $('#divForIframe_1').show();
		 $('#btnShowMenu').show();
		 $('#btnRefreshFrame').show();
	}
}
function deleteCookies() {
 	var allcookies = document.cookie.split(";");
 	for (var i = 0; i < allcookies.length; i++) {
 		var cookie = allcookies[i];
 		var eqPos = cookie.indexOf("=");
 		var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
 		document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
 	}
 }

function submitForm1(actionURL)
{
	document.forms[0].action = actionURL ;
	document.forms[0].submit();
}
			
function callLogOut() {
		  $('#preloader').show();
		  deleteCookies();
		  
		  var clientId=$('#clientId').val();
		  submitForm1("logoutLogin");
}

function submitFormRole(actionURL)
{
	 
	 
	 var clientId=document.forms[0].clientId.value;
	 var hospitalCode=document.forms[0].hospitalCode.value;
	 var selectedMenuUrl=document.forms[0].selectedMenuUrl.value;
	 var userId=document.forms[0].userId.value;
	 var varIsFirstTimeLogin=document.forms[0].varIsFirstTimeLogin.value;
	 var varUserName=document.forms[0].varUserName.value;
	 var varUsrName=document.forms[0].varUsrName.value;
	 var xtoken=document.getElementById("x-auth-token").value;
	  
	 
   	var strSecureCode=clientId+hospitalCode+selectedMenuUrl+userId+varIsFirstTimeLogin+varUserName+varUsrName+xtoken;
   
  // 	alert("sec code >> "+strSecureCode.replace(/ /g,"_"));
   	
   	var fhttf=hex_md5(strSecureCode.replace(/ /g,"_"));
   	
   //	 alert("fhttf >> "+fhttf);
   	
	    document.forms[0].fhttf.value=fhttf;
	document.forms[0].action = actionURL ;
	document.forms[0].submit();
}

function hideMainCotainerIfEmpty(){
	if($('#moduleJson').html()!=""){
		var moduleJson=JSON.parse($('#moduleJson').html());		
		var foundServices=false;
		var foundSetup=false;
		var foundReport=false;
		
		$.each(moduleJson, function(indx, modObj){
			var moduleNameWithoutSpace=modObj["moduleNameWithoutSpace"]
			if($('[id^=menu_'+moduleNameWithoutSpace+'-Services]').length>0)
				foundServices=true;
			if($('[id^=menu_'+moduleNameWithoutSpace+'-Reports]').length>0)
				foundSetup=true;
			
			if($('[id^=menu_'+moduleNameWithoutSpace+'-Setup]').length>0)
				foundReport=true;			
		});
	
		if(foundServices==false){
			$('[id^=mainContainer_Services]').hide();		
		}
		if(foundSetup==false){
			$('[id^=mainContainer_Reports]').hide();		
		}
		if(foundReport==false){
			$('[id^=mainContainer_Setup]').hide();		
		}
	}
}


function callFormFlowXService(configJson){
	//alert("service>>>>"+configJson["serviceName"]);
	
	 
	
	 
	 var data={
			 hmode:"callService",
			 serviceName:configJson["serviceName"],	
			 isGlobal:"0"
	 }
	 if(configJson["inputData"]!=undefined){
		 data.inputData=JSON.stringify(configJson["inputData"])
		//alert('inputdata>>>>>>'+JSON.stringify(data.inputData));
	 }
	 
	 if(configJson["primaryKeys"]!=undefined){
		 data.primaryKeys= configJson["primaryKeys"]		
	 }
	 if(configJson["initMode"]!=undefined){
		 data.initMode= configJson["initMode"]
	 }
	 if(configJson["fileUploadFlag"]!=undefined){
		 data.fileUploadFlag= configJson["fileUploadFlag"]
	 }
	
	 if(configJson["isDataStoredInSession"]!=undefined)
		 data.isDataStoredInSession= configJson["isDataStoredInSession"]
	 
	 
	 //alert($('#varSSOTicketGrantingTicket').val());
	 data.varSSOTicketGrantingTicket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	// data.tid=$('#tid').length>0?$('#tid').val():"";
	 var processName="ClientDesk";
	
	
	 data.processName=processName;
	 data.seatId=$('#userId').length>0?$('#userId').val():"";
	 data.hospitalCode=$('#hospitalCode').length>0?$('#hospitalCode').val():"";
	// alert("tid in callService--" + $('#tid').val());
// data=initSecurityParameterFromajaxjson(data);
	
// alert('aftersecuritycode'+JSON.stringify(data));
	 //data.serviceName="test123";
	//var url= "/AHIMSG5//FFXACTION"
	 
	 
	 
	 
	 var fhttfCode= getHexaCode(getJsonParameters(data));
	// alert("fhttfCode>>>>" +fhttfCode);
 	data.fhttf=fhttfCode;
	 
	
	
	 
	
	 //alert("data>>>>" + JSON.stringify(data));
	 
	 
	 
		var url= "/AHIMSG5/FFXACTION";
	
	
 
	
	if(configJson["serviceName"].indexOf("DMLService")>=0)
		 $('#preloader').show();
		
	//alert('data>>>'+JSON.stringify(data));
		
	 $.ajax({
		 	type: 'POST',
			url : url,
			data :data,							
			dataType : "json",
			success : function(returnStr) {
				//alert('insidepostmethod'+JSON.stringify(returnStr));
				
				hidePreloader();
				/*if(returnStr.indexOf("page-error")>=0){
					$('body').html(returnStr);
				}				
				else if(configJson["callBackFunctionName"]!=undefined)*/
				eval(configJson["callBackFunctionName"])(configJson, returnStr);
				
				
						
			},
			error: function (jqXHR, exception) {
				
				
				  console.log(jqXHR);
				
				  console.log(exception);
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		        hidePreloader();
		        console.log(msg);
		        //alert("Some Problem Occured");
		    },
			fail : function() {
				hidePreloader();
				alert("error occured");
			}
		});
	
 }
 

function checkIfListPageRequired(objmenu){
	var status=false;
	//alert($('#deskIntermediateMenuList').text())
	if($('#deskIntermediateMenuList').text()==""){
		return objmenu;		
	}
	/* Example deskIntermediateMenuList for refernce
	[
    {
        "menuId": "111034000000",
        "menName": "Registration Desk",
        "desk_url": "/AHIMSG5/FFXACTION?masterKey=registrationListingPage",
        "menujsonarr": "[{\"childmenuId\" : 111034001000, \"is_primary_key_required\" : 0, \"show_on_status_list\" : \"-1\"},{\"childmenuId\" : 111034002000, \"num_is_primary_key_required\" : 0, \"str_show_on_status_list\" : \"-1\"},{\"childmenuId\" : 111034003000, \"num_is_primary_key_required\" : 0, \"str_show_on_status_list\" : \"-1\"}]"
    }
]
	 * */
	
	var deskIntermediateMenuList=JSON.parse( $('#deskIntermediateMenuList').text())
	var menujsonArrdesk=null;
	$.each(deskIntermediateMenuList,function(indx,json){
		if(objmenu["menuName"]==json["menName"]){
			status=true;
			objmenu["desk_url"]=json["desk_url"];
			menujsonArrdesk= JSON.parse(json["menujsonarr"]);
		}
	});
	if(status){
		var arrMenuLevel2=new Array();
		
		var arr2=objmenu["MenuLevel2"]
		if (!Array.isArray(objmenu["MenuLevel2"])) {
			arr2=new Array();
			arr2.push(objmenu["MenuLevel2"]);
		}
		
		
		
		$.each(arr2,function(indx, objlevel2Menu){
			$.each(menujsonArrdesk, function(indx2, menujsondesk){
				if(menujsondesk["childmenuId"]==objlevel2Menu["menuid"]){					
					objlevel2Menu["is_primary_key_required"]=menujsondesk["is_primary_key_required"];
					objlevel2Menu["show_on_status_list"]=menujsondesk["show_on_status_list"];
				}
				
			});
			arrMenuLevel2.push(objlevel2Menu);
		});
		objmenu["MenuLevel2"]=arrMenuLevel2;
		
	}
	
	return objmenu;
}
function OpenDeskListing(menujsonObj){
	//alert("inside OpenDeskListing")
	//alert(JSON.stringify(menujsonObj))
	$('#divDeskListingContainer').show();
	$('#divMenuContainer').hide();
	$('#selectedMenuJson').val(JSON.stringify(menujsonObj));
	
	var url=menujsonObj["desk_url"]
	url = createFHashAjaxQuery(url);
	
	
	var html="<fieldset style='width:99%;margin-left:0px;' >" ;									
	html+="<div class='w-100' id='listFormContainer'></div></fieldset>";
	$('#selectedModuleName').val(menujsonObj["menuNameDisplay"])
	$('#divDeskListingContainer').html(html)
	
	$('#listFormContainer').load(url, function(){})
}


function generateRecordWiseButton(status, primaryKey){
	var buttonHtmlPKBased="";
	var jsonArrbuttonHtmlPKBased=null;
	
	var selectedMenuJson =JSON.parse($('#selectedMenuJson').val());
	//alert($('#selectedMenuJson').val());
	var mybutton="";
	var arrlevel2= selectedMenuJson["MenuLevel2"];
	if (!Array.isArray(selectedMenuJson["MenuLevel2"])) {
		arrlevel2=new Array();
		arrlevel2.push(selectedMenuJson["MenuLevel2"]);
	}
	    var buttonRowhtml="";
	    var menuCount=0
		$.each(arrlevel2,function(indx, menuobj){
			if(menuobj["is_primary_key_required"]=="1"){
			var status_to_show =menuobj["show_on_status_list"].split(",");
			
			if((status_to_show.length==1 && status_to_show[0]==-1) || status_to_show.indexOf(status)>=0){
				buttonHtmlPKBased+=" <li  ><a class='dropdown-item dropdown-button btnLeafMenu' data-menuid='"+menuobj["menuid"]+"' data-pk='"+primaryKey+"' title='"+menuobj["menuName"]+"' data-url='"+menuobj["url"]+"'>" +				 
				 "<div class='button-content'><div class='button__icon'>"+
				 "<i class='"+menuobj["font_icon_name"]+" fa-2x'></i></div><span class='button__text'>"+menuobj["menuName"]+"</div></a></li>" ;
				menuCount++;
				
				//This will be used if for record only 2 button is required
				buttonRowhtml+="<a class='btn-his-sm btnLeafMenu'  data-pk='"+primaryKey+"'  title='"+menuobj["menuName"]+"' data-menuid='"+menuobj["menuid"]+"' data-url='"+menuobj["url"]+"'>"+
			 	 "<i class='"+menuobj["font_icon_name"]+"  fa-fw'></i>&nbsp;"+menuobj["menuName"]+
				 "</a>&nbsp;";
				
				
			}
			}
			
		});
		
		if(buttonHtmlPKBased!=""){
			/*if(menuCount<=2){
				// creating button for row
				mybutton=buttonRowhtml;
			}
			else{*/
				// creating droup down for row
				mybutton+="<div class='dropdown'>" +
		 		"<button class='btn btn-sm dropdown-his dropdown-toggle' type='button' id='dropdownMenuButton' data-bs-toggle='dropdown' aria-expanded='false'>" +
		 		" <i class='fa-solid fa-ellipsis-vertical'></i> </button>" +
		 		" <ul class='dropdown-menu' aria-labelledby='dropdownMenuButton'>"+ buttonHtmlPKBased+"</ul>" +
		 		"</div>" ;
			/*}
			*/
			
			
		}
		else{
			mybutton="-"
		}
	
	return mybutton;
}


function generateButtonForWithoutPK(){
	var buttonRowhtml="";
	var jsonArrbuttonHtmlPKBased=null;
	
	var selectedMenuJson =JSON.parse($('#selectedMenuJson').val());
	
	var arrlevel2= selectedMenuJson["MenuLevel2"];
	if (!Array.isArray(selectedMenuJson["MenuLevel2"])) {
		arrlevel2=new Array();
		arrlevel2.push(selectedMenuJson["MenuLevel2"]);
	}
	
	
		$.each(arrlevel2,function(indx, menuobj){
			if(menuobj["is_primary_key_required"]=="0"){
				 buttonRowhtml+="<a class='btn-his-sm btnLeafMenu'  data-pk='' title='"+menuobj["menuName"]+"' data-menuid='"+menuobj["menuid"]+"' data-url='"+menuobj["url"]+"'>"+
			 	 "<i class='"+menuobj["font_icon_name"]+"  fa-fw'></i>"+menuobj["menuName"]+
				 "</a>&nbsp;";
			}
			
		});
	
	return buttonRowhtml;
}


function openButtonLink(){
	var uri = $(this).attr("data-url");
	
	var menuName=$(this).attr("title");
	
	$('#modalMenuName').html(menuName);
	var pk=$(this).attr("data-pk");
	
	pk = pk.replace('=','*');
	
	if(pk!=""){ 
		if(uri.indexOf("?")==-1)
			 uri+= "?primaryKey=" + pk;
		else
			uri+= "&primaryKey=" + pk;
	}
	uri = createFHashAjaxQuery(uri);		
	uri= uri.replace('*','=');
	
	if(uri.indexOf("?")==-1)
		 uri+= "?varSSOTicketGrantingTicket=" + document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
	 else
		uri+= "&varSSOTicketGrantingTicket=" + document.getElementsByName("varSSOTicketGrantingTicket")[0].value;	
	
	/*uri = createFHashAjaxQuery(uri);
	
	//alert(uri);
	uri= uri.replace('*','=');*/
	
	//alert(uri+uri);
	$('#preloader').show();
	$('#iframeModalFullScreen').attr("src",uri);
	$('#selectedMenuUrl').val(uri);
	$('#modalFullScreen').modal("show");
	 $('#iframeModalFullScreen').on('load', function(){
			$('#preloader').delay(450).fadeOut('slow');		
	});
}


function closeModal(){
	closeFullScreenModal();
}
function closeFullScreenModal(){
	 $('#iframeModalFullScreen').attr("src","");
	 $('#modalFullScreen').modal('hide');
	 var menujsonObj =JSON.parse($('#selectedMenuJson').val());
	 OpenDeskListing(menujsonObj);
	 //getnotification();
	/* $(".offcanvas-backdrop").removeClass('show');
	 $(".offcanvas").removeClass('show')
	 $(".offcanvas").attr("aria-modal", false);*/
	 
}
function getnotification(){
	var configJson={
			serviceName:"/getData/getnotification",			    					
			callBackFunctionName:"callNotifications",
		    primaryKeys: [isBen, userId],	
		};
	
	callFormFlowXService(configJson);
}

function callNotifications(configJson, dataJson) {
    if (Array.isArray(dataJson["data"])) {
           var record = dataJson["data"][0]; 
               } else {
                var record = dataJson["data"];
                         }
                
                if (record && record["count_value"] > 0) {
                      notifctn = parseInt(record["count_value"]);
                              console.log("Updated notifctn:", notifctn);
                         //    alert('Updated notifctn: ' + notifctn);

              
             let badge = document.getElementById("notifbdge_Grievance");
			//	 let count = parseInt(badge.innerText);
					badge.innerText = notifctn;
                } else {
			//	   createVerticalModuleList();

             console.log("No Notifications.");
   }
}

function submitChangePass(actionURL){
	$('#selectedMenuUrl').val(actionURL);
	    		 $('#divForIframe_1').show();
	    		 $('#sectionModules').hide();
	    		 showHideMenuPage(0);
	    		 loadInIframe("1", actionURL);
}




function ajaxStart(){
	 // do Nothing
	}

	function ajaxComplete(){
		 // do Nothing
	};
	function ajaxStartMenu(){
		 // do Nothing
	}

	function ajaxCompleteMenu(){
		 // do Nothing
	};
	function ajaxStartTab(){
		 // do Nothing
	}

	function ajaxCompleteTab(){
		 // do Nothing
	};
	
	
	