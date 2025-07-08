$(function() {
		$(document).ready(function() {
			
			var ht = Math.round($(window).height() - $(".header").outerHeight()-$(".marque").outerHeight()-$(".footer").outerHeight()) + "px";
			var wt = Math.round($(window).width()) + "px";
			$('.body').height(ht);
			var ht2 = Math.round($(window).height() - $(".header").outerHeight()-$(".marque").outerHeight()-$(".footer").outerHeight()-$("#menuStrip").outerHeight()) + "px";
			$('.bodyContent').height(ht2);
			
			/* var ht = Math.round($(window).height() - $(".header").outerHeight()-$(".footer").outerHeight()-$(".marque").outerHeight()) + "px";
			var wt = Math.round($(window).width()) + "px";
			$('.body').height(ht);
			var ht2 = Math.round($(window).height() - $(".header").outerHeight()-$(".footer").outerHeight()-$(".marque").outerHeight()-$("#menuStrip").outerHeight()) + "px";
			$('.bodyContent').height(ht2); */
						
			$('.bodyContent').css({'margin-top':$("#menuStrip").outerHeight()});
			adjustMenuAlignment();
			/*$('.wrapper').width(wt).height(ht);
			alert('login height: '+ ht/2);
			$('.login').height(ht/2);
			 */
			$("#toggle").click(function() {
				alert('toggle called');
				$("#menuContainer").slideToggle();
			});
			 /* $(".userDetail ul li").children('div').addClass("align_right"); */
			$('#arrow_left').mouseout(adjustMenuAlignment);
			$('#arrow_right').mouseout(adjustMenuAlignment);
			$('#menu a').click(function() {
				if($(this).attr('class')=='plusParentNode'){
					$(this).removeClass('plusParentNode');
					$(this).addClass('minusParentNode');
				}else if($(this).attr('class')=='minusParentNode'){
					$(this).removeClass('minusParentNode');
					$(this).addClass('plusParentNode');
				}
			    $(this).next('ul').slideToggle();
			});
			//checkIfSlideBarRequired();
			//initSlideShow();
			$("#smoothmenu a").click(function(){
				$(this).trigger("mouseout");
			});
			$("#lastSeenMenusIcon").mouseover(function(){
				var lastSeenMenusHTML="";
				var idx;
				
				if(lastVisitedMenusStartIdx==-1){
					
				}
				else if(lastVisitedMenusEndIdx >lastVisitedMenusStartIdx){
					for(idx=lastVisitedMenusEndIdx-1; idx >=lastVisitedMenusStartIdx; idx--){
						lastSeenMenusHTML+="<li ><a  onclick=\"callMenu('"+lastVisitedURLs[idx] +"','"+lastVisitedMenus[idx]+"')\">"+lastVisitedMenus[idx] +"</a> </li>";
					}
				}else{
					for(idx=lastVisitedMenusEndIdx-1; idx >=0; idx--){
						lastSeenMenusHTML+="<li ><a  onclick=\"callMenu('"+lastVisitedURLs[idx] +"','"+lastVisitedMenus[idx]+"')\">"+lastVisitedMenus[idx] +"</a> </li>";
					}
					for(idx=maxLastVisitedMenuCount-1; idx >=lastVisitedMenusStartIdx; idx--){
						lastSeenMenusHTML+="<li ><a  onclick=\"callMenu('"+lastVisitedURLs[idx] +"','"+lastVisitedMenus[idx]+"')\">"+lastVisitedMenus[idx] +"</a> </li>";
					}
					
				}
				$("#lastSeenMenusID").html(lastSeenMenusHTML);
				//alert('last visited menus: '+ lastVisitedMenus+" lastVisitedMenusStartIdx: "+lastVisitedMenusStartIdx+" lastVisitedMenusEndIdx"+lastVisitedMenusEndIdx);
			});

		/*	if($('#alertCount').val()>0)
				window.setInterval("$('#alertCountId').toggle();",1000);

			//For Each 10 Seconds the Cash in the Desk will be refreshed, Added by Singaravelan on 04-Jun-2015
			window.setInterval(reloadCashDtl, 10000);
		*/
							
		});
		
});


ddsmoothmenu.init({
		mainmenuid: "menuStrip", //menu DIV id
		//orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
		//classname: 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		//contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
}) 
ddsmoothmenu.init({
		mainmenuid: "smoothmenu", //menu DIV id
		//orientation: 'h', //Horizontal or vertical menu: Set to "h" or "v"
		//classname: 'ddsmoothmenu', //class added to menu's outer DIV
		//customtheme: ["#1c5a80", "#18374a"],
		//contentsource: "markup" //"markup" or ["container_id", "path_to_menu_file"]
}) 



/*Added by Anjali- 28-04-2020*/
function reloadManualDtl(menuName){
	var myURL=createFHashAjaxQuery("/AHIMSG5/hislogin/reloadManualDtlUserDesk?t="+new Date().getTime())

	//console.log(myURL);
	
		
	var data = {
		varUserChoiceMenu : menuName
	};

	$
			.ajax({
				url : myURL,
				// url:"/AHIMSG5/hislogin/loadUserDesk.action",
				type : "POST",
				async : true,
				dataType : "text",
				data : data,
				success : function(dataval) {
					//alert("Inside success"+dataval);
					var mnuName=menuName.split("_").join(" ");
					document.getElementById("manualdivId").innerHTML = "<div class='col_1' id='manualDiv' style='color:black; width:240px;'>"+ "<div class='btn-group'><input type=\"search\" id=\"searchManual\" autocomplete='off' placeholder=\"Search for manuals..\" onkeyup='searchManuals(event)' title=\"Type in a name\"><span id='searchClear' onclick='clearSearch();' class='glyphicon glyphicon-remove-circle'></span></div><input type='text' style='display:none;' >\r\n"
					+"<h3 style='color:black;'><b>"+mnuName+" User Manuals</b></h3>"
							+dataval + "</div>";

					var toggler = document.getElementsByClassName("caret1");
					var i;

					for (i = 0; i < toggler.length; i++) {
						toggler[i]
								.addEventListener(
										"click",
										function() {
											this.parentElement
													.querySelector(".nested").classList
													.toggle("active");
											this.classList.toggle("caret1-down");
										});
					}
					
					
				}
			
			
			});
		
}

function clearSearch(){
	$("#searchManual").val('');
}


/*Search manuals using text box*/
var previousLength = 0;

function searchManuals(e) {

	var input, filter, ul, li, a, i, txtValue;
	input = document.getElementById("searchManual");
	filter = input.value.toUpperCase();

	if (e.keyCode == 13) {

		var myLi = $(".nested  li").filter(function() {
			return $(this).css("display") == "block"
		});
		
		var myNestedLi=$(".nested li.nested li").filter(function(){
			return $(this).css("display")=="block"
		});

		if (myLi != null && myLi.length > 0) {

			document.getElementById("searchManual").value = "";
			previousLength = 0;

			myLi[0].getElementsByTagName("a")[0].click();

		}else if(myLi!=null && myNestedLi!=null && myLi.length>0 && myNestedLi.length>0){
			document.getElementById("searchManual").value = "";
			previousLength = 0;

			myNestedLi[0].getElementsByTagName("a")[0].click();
			
		}

	}

	if ((previousLength == 0 && filter.length == 1) || filter.length == 0) {
		var toggler = document.getElementsByClassName("caret1");
		var i;

		for (i = 0; i < toggler.length; i++) {
			toggler[i].parentElement.querySelector(".nested").classList
					.toggle("active");

			toggler[i].classList.toggle("caret1-down");

		}
	}

	previousLength = filter.length;
	
	ul = document.getElementsByClassName("myUL");
	for (x = 0; x < ul.length; x++) {
		li = ul[x].getElementsByTagName("li");
		for (i = 0; i < li.length; i++) {
			a = li[i].getElementsByTagName("a")[0];
			txtValue = a.textContent || a.innerText;
			// console.log("txtValue >> "+txtValue.toUpperCase() +" filter >>
			// "+filter+" >> index val >>
			// "+txtValue.toUpperCase().indexOf(filter) );
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "block";
				// console.log("txtValue block >> "+txtValue);
			} else {
				if (!(txtValue == 'Services' || txtValue == 'Setup' || txtValue == 'Reports')) {
					li[i].style.display = "none";
				}
				// console.log("txtValue none >> "+txtValue);
			}
		}
	}

	//ul = document.getElementsByClassName("myUL");
	ulNested = document.getElementsByClassName("nested");
	for (x = 0; x < ulNested.length; x++) {
		li = ulNested[x].getElementsByTagName("li");
		for (i = 0; i < li.length; i++) {
			a = li[i].getElementsByTagName("a")[0];
			txtValue = a.textContent || a.innerText;
			//console.log("txtValue >> "+txtValue.toUpperCase() +" filter >>"+filter+" >> index val >> "+txtValue.toUpperCase().indexOf(filter));
			if (txtValue.toUpperCase().indexOf(filter) > -1) {
				li[i].style.display = "block";
				 //console.log("txtValue block >> "+txtValue);
			} else if (!(txtValue == 'Services' || txtValue == 'Setup' || txtValue == 'Reports')) {
					li[i].style.display = "none";
					 //console.log("txtValue none else if>> "+txtValue);
				}
				else{
					li[i].style.display="block";
				 //console.log("txtValue none else >> "+txtValue);
				}
		}
	}
}
	
function reloadCashDtl(){

	
	
	
	
	var action="/AHIMSG5/hislogin/reloadCashUserDesk"
	$.ajax
	(
			{
				url : action, 
				type : "POST",
				async : true,
				dataType : "text",
				success : function(returnHTML) 
				{	
					if($('[name="varIsAutoRefresh"]').val()!="" && $('[name="varIsAutoRefresh"]').val()!="0")
						reloadAlertDtl();
					document.getElementById("cashCollectedDiv").innerHTML=returnHTML;
					 
				/*	if(returnHTML.includes("Session is Expired")){
						  countDownDate = new Date().getTime() ;
					}else{
						
						 countDownDate = new Date().getTime() + (15*60*1000);
					}*/
					
					
					$('#cashCollectedDiv').qtip('destroy');
					$('#cashCollectedDiv').qtip({
				        content:
				        {
				        	text: 'Loading...',
				        	ajax: {
				                url: '/AHIMSG5/hislogin/cashCollectionDtlUserDesk', 
				                type: 'POST', 
				                once:false,
				                data:{},
				                success: function(data, status) {					                      
				                    this.set('content.text', data);
				                     
				                   /* if(data.includes("Session is Expired")){
										  countDownDate = new Date().getTime() ;
									}else{
										
										 countDownDate = new Date().getTime() + (15*60*1000);
									}*/
				                    getLanguage();
				                }
				            }		            
				        },				          
				        style: {  	
				        	classes: 'tipCustomStyle qtip-rounded',	            	
				        },
				        position: {		       
				            my: 'top center', 
				            at: 'bottom center', 
				        }
				    });
				},
				error : function(errorMsg, textstatus, errorthrown) 
				{
					// countDownDate = new Date().getTime();
					 
						var erTxt="<font size='4 px' color='red'>Cash in Hand : Error</font>"
						document.getElementById("cashCollectedDiv").innerHTML=erTxt;
						getLanguage();
				}
			}
			
	);	
	
	
	setTimeout(function(){
		
		document.getElementById("cashCollectedDiv").innerHTML="<span style='cursor:pointer;' onclick='reloadCashDtl();' ><font size='4 px' color='yellow'><span key='click-to-view-cash-in-hand'>Click to View Cash In Hand</span></font></span>";
		getLanguage();
	}, 15000);
	
	getLanguage();
	
}

//To Reload the Alert Dtls in the Desk, Added by Singaravelan on 29-Oct-2015
function reloadAlertDtl(){
	
	//alert("Refresh Alert");
	var action="/AHIMSG5/hislogin/getAlertDtlUserDesk"
	$.ajax
	(
			{
				url : action, 
				type : "POST",
				async : true,
				dataType : "text",
				success : function(returnHTML) 
				{	
					var alertCount="0";var mrgMsg="";
					if(returnHTML.indexOf("$")>0){
						alertCount= returnHTML.split("$")[0];
						mrqMsg=returnHTML.split("$")[1];
					}
					document.getElementById("alertCountId").innerHTML=alertCount;
					document.getElementById("footmarquee").innerHTML=mrqMsg;
					
				},
				error : function(errorMsg, textstatus, errorthrown) 
				{						
				}
			}
	);	
	
}
 
function addTab(menu,targetURL){

	//alert("Inside tab Addition :: Menu :: "+menu+" Url ::"+targetURL);
	
	if ($('#tabframe').tabs('exists', menu) && checkTabHasURL(targetURL)) {
		$('#tabframe').tabs('select', menu);
		//alert("targetUrl: "+targetURL);
		//investigation tab refresh by Different url and cr no added by warish//
		if(targetURL.indexOf("/HBIMS/billing/transactions/CashCollectionOnlineTransCNT.cnt?hmode=GO&CRNO") !== -1)
			tabMenuRefresh(menu,targetURL);
	} else {
		ajaxStartTab();
		var content = '<iframe id="'+menu+'_iframe" scrolling="auto" frameborder="0" src="'
				+ targetURL + '" style="width:100%;height:95%;" onLoad="ajaxCompleteTab();getLanguage();"></iframe>';
		tabCount=$('#tabframe ul li').length;
		if(tabCount<=MAX_TAB_COUNT){	
			$('#tabframe').tabs(
					'add', {
		 			title : menu,content : content,	closable : true,heightStyle: "content",	id:targetURL				
					/* tools:[{ iconCls:'icon-mini-refresh', handler:function(){tabMenuRefresh(menu,targetURL);	}}] */
				});	
		} 
		else 
		{
			var truFls = window.confirm("Alert! Five Tabs are already open.\nPress 'Ok' to close the first tab.\nPress 'Cancel' to close the last tab.");
			if (truFls)
				{
					$('#tabframe').tabs("close",1);
					$('#tabframe').tabs(
							'add', {
							title : menu,content : content,	closable : true,heightStyle: "content",	id:targetURL				
							/* tools:[{ iconCls:'icon-mini-refresh', handler:function(){tabMenuRefresh(menu,targetURL);	}}] */
						});	
				}
			/*else
				$('#tabframe').tabs("close",tabCount);*/
			ajaxCompleteTab();
		}
		/*$('#tabframe').tabs(
				'add', {
				title : menu,content : content,	closable : true,heightStyle: "content",	id:targetURL				
				 tools:[{ iconCls:'icon-mini-refresh', handler:function(){tabMenuRefresh(menu,targetURL);	}}] 
			});	*/
		//By Warish on 01.09.17
		
		/*if(tabCount<=MAX_TAB_COUNT){
			//alert("Inside tabCount<=MAX_TAB_COUNT :: tabCount"+tabCount+" MAX_TAB_COUNT "+MAX_TAB_COUNT);
		} else {
			var truFls = window.confirm("!Alert! There is limit on open Tabs at a time as 5. Five Tabs are already open.\nIf you want close the oldest opened tab, Press 'Ok'.\nIf you want to choose to close a tab, Press 'Cancel'.");
			 //alert("Inside tabCount > MAX_TAB_COUNT :: tabCount"+tabCount+" MAX_TAB_COUNT "+MAX_TAB_COUNT+" Exsists ::"+$('#tabframe').tabs('exists', 1));				 
			if (truFls) {
				  ajaxStartTab();
				  $('#tabframe').tabs("close",1);
			}
			else
				$('#tabframe').tabs("close",tabCount);
		}*/
	}
}



function tabMenuRefresh(menu,targetURL) {
	document.getElementById(menu+'_iframe').contentDocument.location=targetURL;
}
function tabRefresh(){
	var tab = $('#tabframe').tabs('getSelected');
	var targetURL=tab.panel('options').id;
	var menu=tab.panel('options').title;
	if(targetURL.indexOf("/")>=0)
		document.getElementById(menu+'_iframe').contentDocument.location=targetURL;
}
 
function checkTabHasURL(targetURL){
	var urlFound=false;
	var tabs = $('#tabframe').tabs('tabs');
	for(var i=0; i<tabs.length; i++){
		 if(tabs[i].panel('options').id==targetURL)
	    	urlFound=true;
	}
		//alert("targetUrl: "+targetURL);
	//investigation tab refresh by Different url and cr no added by warish//
	    if(targetURL.indexOf("/HBIMS/billing/transactions/CashCollectionOnlineTransCNT.cnt") !== -1)
	    	urlFound=true;
	   return urlFound;
}


function menuSelected(menuName,isSelectHomeScreen)
{
	var action="/AHIMSG5/hislogin/refreshHomeUserDesk";
	
 	
	var data = {
			varUserChoiceMenu:menuName
	 };
	 $.ajax
	 ({
				url : action, 
				type : "POST",
				async : true,
				dataType : "text",
				data :data,
				success : function(returnHTML) 
				{							
				  if($('#frmMainMenu').length && typeof menu != 'undefined')
					  if(document.getElementsByName("varMenuAssigned")[0].value=="")
						$('#frmMainMenu').attr('src','/AHIMSG5/hislogin/transactions/jsp/st_desk_homeMenuTab_page.jsp'); 					  
				   if(document.getElementsByName("varMenuAssigned")[0].value=="none")
					  $('#frmMainMenu').attr('src','/AHIMSG5/hislogin/transactions/jsp/st_noMenu.jsp'); 	
				  if(isSelectHomeScreen)
				 	 $('#tabframe').tabs('select', 0); 
				  else{
					  //$('#tabframe').tabs('select', 1); 
					  //$('#tabframe').tabs('select', 0); 
				  }
				  
				  $("ul#menuList li").removeClass('selectedMenu');	
				  menuName=menuName.toString().replace(/ /g, '_');
				  $("#"+menuName).addClass('selectedMenu');	
				  
				  
				  reloadManualDtl(menuName);//Change manual list dynamically
				  
				  
				},
				error : function(errorMsg, textstatus, errorthrown) 
				{
						alert("Sorry !! Not Able to Refresh the Home Tab");
				}
	 });	
}

function showHomeTab(){
	$('#tabframe').tabs('select', 0); 
}

function closeTab(url)
{
	var targetURL = url;	
	var elemFrame = document.getElementById("frmMain");
	
	if(elemFrame!=null){
		elemFrame.src=targetURL;
		elemFrame.refresh();
	}
	else{
		if(typeof $('#tabframe')!='undefined'){
			var tab = $('#tabframe').tabs('getSelected');
			var index = $('#tabframe').tabs('getTabIndex',tab);
			$('#tabframe').tabs('select',index-1);	
			$('#tabframe').tabs('close',index);	

		}
	}
}

function maintainLastSeenMenuArray(url,menu){
	//alert('maintain url: '+ url + 'menu: '+ menu);
	 if(menu === undefined){
	 }else{	 
		if(lastVisitedMenus.indexOf(menu)!= -1){
			deleteMenuFromCircularQueue(url,menu);
		}
		addMenuToCircularQueue(url,menu);
	} 
	//alert('lastVisitedMenus: '+ lastVisitedMenus);
}

 function addMenuToCircularQueue(url,menu){
	if(lastVisitedMenusStartIdx == -1 && lastVisitedMenusEndIdx == -1){// empty array 
		lastVisitedMenus[++lastVisitedMenusEndIdx]=menu;
		lastVisitedURLs[lastVisitedMenusEndIdx]=url;
		lastVisitedMenusStartIdx=0;
		lastVisitedMenusEndIdx++;
	}else{
		lastVisitedMenus[lastVisitedMenusEndIdx]=menu;
		lastVisitedURLs[lastVisitedMenusEndIdx]=url;
		if(lastVisitedMenusEndIdx== lastVisitedMenusStartIdx)
			lastVisitedMenusStartIdx=(lastVisitedMenusStartIdx+1)%maxLastVisitedMenuCount;
		lastVisitedMenusEndIdx=(lastVisitedMenusEndIdx+1)%maxLastVisitedMenuCount;
	}
}
function deleteMenuFromCircularQueue(url,menu){
	try {
		var menuIdx= lastVisitedMenus.indexOf(menu);
		var idx;
		var noOfShuflings=lastVisitedMenusEndIdx-menuIdx-1;
		if(noOfShuflings <0){
			noOfShuflings=noOfShuflings+ maxLastVisitedMenuCount;
		}
		if(noOfShuflings > 0){
			for(idx=1; idx <= noOfShuflings; idx++ ){
				lastVisitedMenus[menuIdx]=lastVisitedMenus[(menuIdx+1)%maxLastVisitedMenuCount];
				lastVisitedURLs[menuIdx]=lastVisitedURLs[(menuIdx+1)%maxLastVisitedMenuCount];
				menuIdx=(menuIdx+1)%maxLastVisitedMenuCount;
			}
			lastVisitedMenus[menuIdx]='-1';
			lastVisitedURLs[menuIdx]='-1';
			lastVisitedMenusEndIdx=lastVisitedMenusEndIdx-1;
			if(lastVisitedMenusEndIdx<0)
				lastVisitedMenusEndIdx=lastVisitedMenusEndIdx+maxLastVisitedMenuCount;
		}else if(noOfShuflings == 0){ // only one element is there in array make array empty
			lastVisitedMenus[menuIdx]='-1';
			lastVisitedURLs[menuIdx]='-1';
			lastVisitedMenusStartIdx=-1;
			lastVisitedMenusEndIdx=-1;
		}
	}catch(err){
		alert(err);
	}	
}  

function deleteCookies()
{
	var allcookies = document.cookie.split(";");
	for (var i = 0; i < allcookies.length; i++)
	{
		var cookie = allcookies[i];
		var eqPos = cookie.indexOf("=");
		var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
		document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
		//document.cookie = 'UP-759283=; expires=Thu, 01-Jan-70 00:00:01 GMT;'; 
		//document.cookie = name+'="";-1; path=/';
	}
}

function callLogOut(e)
{
	alert("in HIS");
	deleteCookies();
	submitForm("logoutLogin");
// 	document.form1.hmode.value="LOG_OUT";
// 	//document.form1.action="../startup/loginAction";
// 	document.form1.action="loginAction";
// 	document.form1.submit();
}

function searchMenu()
{
	openURLInPopup('/AHIMSG5/hislogin/transactions/jsp/st_menu_search.jsp','500','200');
	
}

function uploadDate(name){
	 var fileName=name.split(".");
	  var manName=fileName[0].split(/[^a-zA-Z_(.+)]/)[0];  
	  var entryDate=fileName[0].split(manName);
	  var uploadDate=entryDateDate[1].substring(0,10).split("_").join("-");
}


/*Added by Anjali-30-04-2020*/
function openManual(fileName,selectedLink){
	var myURL='/AHIMSG5/hislogin/downloadManualUserDesk?t='+new Date().getTime();
	myURL = createFHashAjaxQuery(myURL);
	//var mrURL='/AHIMSG5/hislogin/downloadManualUserDesk';
	//alert(myURL);
	//alert("inside openManual");
	var data = {
			
			//varManualFileURL:fileURL,
			varManualFileName : fileName
		};
	
	$
	.ajax({
		//url : "/AHIMSG5/hislogin/downloadManualUserDesk",
		url:	myURL,
		type : "POST",
		async : true,
		dataType : "html",
		data : data,
		success : function(dataval) {
			//var dataval="Hello World. Print it.";
			//alert("inside ajax call");
			//alert(dataval);
			/*Title of the modal*/
			 var manualTitle = selectedLink.split("_").join(" ");
			 manualTitle=manualTitle.split("XXX").join("&");
			 manualTitle=manualTitle.split("XXY").join("/");
			 /* */
			 
			 //alert(fileName.split(".")[0].split()[1]);
			 
			/* Manual Upload Date*/
			 var name=fileName.split(".");
			  var manName=name[0].split(/[^a-zA-Z_(.+)]/)[0];  
			  var entryDate=name[0].split(manName);
			  var uploadDate=entryDate[1].substring(0,10).split("_").join("-");
			  /*alert(uploadDate);
			  alert(name[0]);*/
			  // alert(dataval);
			 
			document.getElementById("myModal").innerHTML="<div class='modal-dialog modal-dialog-scrollable modal-lg'><div class='modal-content'><div class='modal-header text-center' style='background-color:#2C4294;'><h5 id='hospitalHeader' class='modal-title' style='margin: 0 auto;color:white;'>"+hospitalHeader()+
        "</h4><button type='button' class='close' style='color:white;' data-dismiss='modal'>&times;</button></div>"+
        "<div class='modal-body' id='myModalBody' style='color:black;'>"+"<p align='right'>Last updated on- <b>"+uploadDate+"</b></p>"+dataval+"</div><div class='modal-footer'>"+
        "<span class='btn btn-primary' onclick='printManual(\""+selectedLink+"\")'>Print</span>"+
      "<span  class='btn btn-default' data-dismiss='modal'>Close</span> </div></div></div>";
		}
	
	});

	//alert("above printManual function call");
	/*printManual(dataval);
	alert("below printManual function call");*/
	}

function hospitalHeader(){
	var myURL='/AHIMSG5/hislogin/hospitalHeaderUserDesk?t='+new Date().getTime();
	myURL = createFHashAjaxQuery(myURL);
	
	$
	.ajax({
		url : myURL,
		type : "POST",
		async : true,
		dataType : "text",
		success : function(dataval) {
			//alert("hospitalInfo-> "+dataval);
			document.getElementById("hospitalHeader").innerHTML=dataval;
			//alert("hospitalInfo-> "+dataval);
		}
	});
}

function printManual(manualTitle){
	
	
	newwin=window.open('','printwin','left=100,top=100,width=700,height=700,scrollbars=yes');
	newwin.document.write('<HTML><HEAD><title>'+manualTitle+'</title>');
 
	// newwin.document.write('<style type="text/css"> .hidecontrol { display: none;
	// } </style>\n')
	newwin.document.write('\n');
	newwin.document.write('<style>');
	newwin.document.write('.main-body{margin-left:10px;margin-right:10px;margin-top:10px;margin-bottom:5px;padding:10px 10px 10px 10px;}');
	newwin.document.write('</style>');
	newwin.document.write('<script>\n');
	newwin.document.write('function chkstate(){ \n');
	// newwin.document.write('if(document.readystate=="complete" ||
	// document.readystate=="undefined"){\n');
	newwin.document.write('window.close();\n');
	// newwin.document.write('}\n');
	// newwin.document.write('else{\n');
	// newwin.document.write('setTimeout("chkstate()",2000)\n');
	// newwin.document.write('}\n');
	newwin.document.write('}\n');
	newwin.document.write('function print_win(){\n');
	newwin.document.write('window.print();\n');
	newwin.document.write('chkstate();\n');
	newwin.document.write('}\n');

	newwin.document.write('<\/script>\n');
	newwin.document.write('</HEAD>\n');
	newwin.document.write('<BODY class="main-body">\n');
	newwin.document.write(document.getElementById("hospitalHeader").innerHTML+ '<br><br>');
	newwin.document.write(document.getElementById("myModalBody").innerHTML);
	newwin.document.write('</BODY>\n');
	newwin.document.write('<script>\n');
	 
	newwin.document.write('print_win();\n');
	newwin.document.write('</script>\n');
	newwin.document.write('</HTML>\n');
	newwin.document.close();
		
	
}

function showDiv()
{
	document.getElementById("envato-widget1").style.display= "block";
}
function hideDiv()
{
	document.getElementById("envato-widget1").style.display= "none";	
}

var secs;
var timerID = null;
var timerRunning = false;
var delay = 1000;
var currentDate=null;

function setTime()
{
	if('<s:property value="varIsFirstTimeLogin" />'=='1')
		openURLInPopupWithoutClose("/AHIMSG5/hislogin/initFirstLoginLgnFtr","600","400");				

	// Setting Time initially on Load
	var dateAsString = document.getElementsByName("varCurrentDate")[0].value;
	currentDate = convertStrToDate(dateAsString,'dd-MM-yyyy hh:mm'); // for format dd-MM-yyyy HH:mm  of 'dateAsString2'
	var tdDate=document.getElementById("dateTdId");
 	var newDateFormat = convertDateToStr(currentDate, "Week, dd-Mon-yyyy hh:mm");
	tdDate.innerHTML=newDateFormat;
	
	//alert("set time")
	InitializeTimer();
}

function InitializeTimer()
{
    // Set the length of the timer, in seconds
    secs = 60;
    StopTheClock();
    StartTheTimer();
}

function StopTheClock()
{	
	
	
	
	//alert("stop")
    if(timerRunning)
        clearTimeout(timerID);
    timerRunning = false;
}

function StartTheTimer()
{
	//alert("start")
	if (secs==0)
	{
		StopTheClock();
		var tdDate=document.getElementById("dateTdId");
		var objnewDate = addToDate(currentDate,1,"MI");
     	var newDateFormat = convertDateToStr(objnewDate, "Week, dd-Mon-yyyy hh:mm");
     	var newDate = convertDateToStr(objnewDate, "dd-MM-yyyy hh:mm");
     	currentDate = objnewDate;
     	
	   // alert("newDate---------"+newDate);
		tdDate.innerHTML=newDateFormat;
		document.getElementsByName("varCurrentDate")[0].value=newDate;
		setTime();
 	
      	InitializeTimer();
    }
    else
    {
        self.status = secs;
        secs = secs - 1;
      	timerRunning = true;
        timerID = self.setTimeout("StartTheTimer()", delay);
    }
}
function getNextMonth(monthId)
{
var monthArray=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];	
return monthArray[monthId];
}

function getNextDay(dayId)
{
var daysArray=["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];	
return daysArray[dayId];
}
	
	

function checkIfSlideBarRequired(){
	var menuContainerWidth = $("#menuContainer").width();
	var menuWidth=0;
	$("#menuStrip #smoothmenu ul#menuList")
	.children("li")
	.each(
			function(index) {
				currentMenuWidth = $(this).outerWidth(true);
				menuWidth += currentMenuWidth;

			});
	if(menuContainerWidth > menuWidth){
		$('#arrow_left').css({'display':'none'});
		$('#arrow_right').css({'display':'none'});
		$('#menuStrip').css({'left':'0'});
	}
	
}
function adjustMenuAlignment() {
	var listColumnWidth = 0;
	var menuContainerWidth = $("#menuContainer").width();
	var leftOffset = Math.abs($("#menuStrip").offset().left);
	/*Find leftmost menu item */
	var cummulativeLeftMenuWidth = 0;
	var currentMenuWidth = 0;
	var currentWindowMenuWidth = 0;
	$("#menuStrip ul#menu")
			.children("li")
			.each(
					function(index) {
						currentMenuWidth = $(this).outerWidth(true);
						cummulativeLeftMenuWidth += currentMenuWidth;
						if (cummulativeLeftMenuWidth > leftOffset
								&& currentWindowMenuWidth < menuContainerWidth) {
							currentWindowMenuWidth += currentMenuWidth;
							listColumnWidth = $($(this).children('div'))
									.outerWidth(true);
							if (currentWindowMenuWidth + listColumnWidth > menuContainerWidth) {
								//alert('class added to '+ $(this).children("a").text());
								$(this).children('div').addClass(
										"align_right");
							} else {
								//alert('class removed from '+ $(this).children("a").text());
								$(this).children('div').removeClass(
										"align_right");
							}

						}

					});

}
	
function ajaxStart(){
    $("#loadingmessage").css("display","block");
}

function ajaxComplete(){
	$("#loadingmessage").css("display","none");
};
function ajaxStartMenu(){
    $("#loadingMenu").css("display","none");
}

function ajaxCompleteMenu(){
	$("#loadingMenu").css("display","none");
};
function ajaxStartTab(){
    $("#loadingTab").css("display","none");
}

function ajaxCompleteTab(){
	$("#loadingTab").css("display","none");
};
