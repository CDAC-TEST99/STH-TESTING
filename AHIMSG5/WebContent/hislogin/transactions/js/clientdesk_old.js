


let userId='';
let isBen='';
var notifctn='';
	$(document).ready(function() {
					 $( "button" )
						.click(function( event ) {
						event.preventDefault();
						});
						$( "input[type=button], button" )
							.click(function( event ) {
							event.preventDefault();
						});

		                isBen=$('#isBen').val();
		                userId=$('#userId').val();
		                //alert("isBen" + isBen);
		                
		                getnotification();

						hidePreloader();
					 
					// resizeFn();					
					createVerticalModuleList();	
					$('#btnRefreshFrame').click(refreshIFrame);	
					showMenuPage();
					
					
					checkForModuleIdWiseListpage();
					
			        
			    	
					
				});
				
				function getnotification(){
					var configJson={
			    			serviceName:"/getData/getnotification",			    					
			    			callBackFunctionName:"callNotifications",
			    		    primaryKeys: [isBen, userId],	
			    		};
		    		
					callFormFlowXService(configJson);
				}
				
				function checkForModuleIdWiseListpage(){
					var configJson={
			    			serviceName:"/getData/checkForModuleIdWiseListpage",			    					
			    			callBackFunctionName:"callCheckForModuleIdWiseListpage",
			    			isDataStoredInSession:"No"		
			    		};
		    		
					callFormFlowXService(configJson);
				}
				
				function callNotifications(configJson, dataJson) {
                    if (Array.isArray(dataJson["data"])) {
                           var record = dataJson["data"][0]; 
                               } else {
                                var record = dataJson["data"];
                                         }
                                //  alert("this is the fetched data" + record["count_value"]);


                                if (record && record["count_value"] > 0) {
                                      notifctn = parseInt(record["count_value"]);
                                              console.log("Updated notifctn:", notifctn);
                                         //    alert('Updated notifctn: ' + notifctn);
        
                              
                             let badge = document.getElementById("notifbdge");
 		   				//	 let count = parseInt(badge.innerText);
 								badge.innerText = notifctn;
                                } else {
							//	   createVerticalModuleList();

                             console.log("No Notifications.");
                   }
				}

				function callCheckForModuleIdWiseListpage(configJson, dataJson){
					
					if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
						//alert(JSON.stringify(dataJson["data"]));	
						
						$('#moduleListForListing').html(JSON.stringify(dataJson["data"]));
						
					}					
				}
 
				/*  function resizeFn() {
					 
				 if(window.innerWidth<930){
							createHorizontalModuleList();						
					}
					else{
						createVerticalModuleList();		
					}
					
				} */
				//window.onresize = resizeFn;
				//resizeFn(); 
				
				
				function createVerticalModuleList(){

					var moduleWiseIntermediateMenu= JSON.parse($('#moduleWiseIntermediateMenu').html());
					var moduleWiseLeafMenu= JSON.parse($('#moduleWiseLeafMenu').html());
					
					$('#divMainPageContainer').empty();
					var moduleJson= JSON.parse($('#moduleJson').html());
					var html="<div class='row'>";

					html+="<div class='col-xl-1 col-lg-1  col-md-2 col-sm-2 col-3 bg-white'      id='moduleContainer' ></div>";
					
					html+="<div class='divMenu' style='display:none;' id='divMenu'>";
					html+="<div class='container-fluid' style='text-align: right; margin: 10px;'  ><a class='btn btn-sm btn-outline-danger' style='cursor:pointer;' id='closeDivMenu'><i class='fa-solid fa-square-xmark fa-2x'></i></a></div>";
					html+="<div class='w-100' id='menuContainer' ></div>";					
					html+="</div>";
					html+="<div class='col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9'  id='divFormContainer'></div>";										
					html+="</div>";	
					$('#divMainPageContainer').html(html);
					
					$.each(moduleJson, function(indx, objModuleJson){
						var html = "<div class='row'>";
                        html += "<div class='col-lg-12 moduleicon modVertical' data-moduleName='" + objModuleJson["moduleNameWithoutSpace"] + "' id='module_" + objModuleJson["moduleNameWithoutSpace"] + "'>";
                        html += "<div class='row'>";
                        html += "<div class='col-12 text-center'>"; 
                        html += "<span class='' style='display: inline-flex; align-items: center;'>"; // Ensures inline display
                        html += "<img src='" + objModuleJson["moduleImageName"] + "' class='imgmoduleicon' />";

                   if (objModuleJson["moduleNameWithoutSpace"] === "Grievance") {
                         html += "<span id='notifbdge' class='badge bg-danger' style='font-size: 13px; margin-left: 5px; padding: 5px 10px;'></span>";
                             }

                              html += "</span>";
                              html += "</div>";
                              html += "<div class='col-12 mt-1 text-center moduletext'>" + objModuleJson["moduleName"] + "</div>";      
                              html += "</div>";
                              html += "</div>";                        
                              html += "</div>"; 
						
						$('#moduleContainer').append(html);


						html="<div class='row menuheading ' id='menutitle_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'>";
						html+="<div  class='col-12 text-center mt-1'><h4 style='color:var(--theme-menu-color)'>"+objModuleJson["moduleName"]+"</h4></div>";
						html+="</div>";
						html+="<div class='row menus' id='menu_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'></div>";
						$('#menuContainer').append(html);
						console.log("1. ....Module name======" +objModuleJson["moduleNameWithoutSpace"]);
						createVerticalLeafNode(objModuleJson["moduleNameWithoutSpace"],objModuleJson["moduleName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, "0", "Services","menu_"+objModuleJson["moduleNameWithoutSpace"]);
						createVerticalInternediateMenu(objModuleJson["moduleNameWithoutSpace"],objModuleJson["moduleName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, "0", "Services","menu_"+objModuleJson["moduleNameWithoutSpace"]);
						
						if($('#menu_'+ objModuleJson["moduleNameWithoutSpace"]).find('.menu').length==0){
							$('#menutitle_'+objModuleJson["moduleNameWithoutSpace"]).remove();
							$('#menu_'+objModuleJson["moduleNameWithoutSpace"]).remove();
							$('#module_'+objModuleJson["moduleNameWithoutSpace"]).remove();
						} 
																		
					});
					
						html="<div class='row'>"
						html+="<div class='col-lg-12 moduleicon modVertical' data-moduleName='setup'  id='module_setup'>";
						html+="<div  class='row'>";
						html+="<div  class='col-12 text-center'>"; 
						html+="<span class=''>";
						html+="<img src='/HIS/hisglobal/images/e-clinic/module_img/setting.png' class='imgmoduleicon' />";
						html+="</span>";
						html+="</div>";
						html+="<div  class='col-12 text-center moduletext'>Setup</div>";		
						html+="</div>";
						html+="</div>";						
						html+="</div>";
						$('#moduleContainer').append(html);
						
						var cnt=0; 
						$.each(moduleJson, function(indx, objModuleJson){
							html="<div class='row menuheading ' id='menutitlesetup_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'>";
							html+="<div  class='col-12 text-center mt-1'><h4 style='color:var(--theme-menu-color)' >"+objModuleJson["moduleName"]+"</h4></div>";
							html+="</div>";
							html+="<div class='row menus' id='menusetup_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'></div>";
							$('#menuContainer').append(html);	
							console.log("Module name======" +objModuleJson["moduleNameWithoutSpace"])										 
							createVerticalLeafNode(objModuleJson["moduleNameWithoutSpace"],objModuleJson["moduleName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, "0", "Setup","menusetup_"+objModuleJson["moduleNameWithoutSpace"]);
							createVerticalInternediateMenu(objModuleJson["moduleNameWithoutSpace"],objModuleJson["moduleName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, "0", "Setup","menusetup_"+objModuleJson["moduleNameWithoutSpace"]);
							
							cnt=cnt+$('#menusetup_'+ objModuleJson["moduleNameWithoutSpace"]).find('.menu').length
							//alert(cnt);								
						});

						 if(cnt==0){
							$('#module_setup').remove();
						} 
						 
						
						html="<div class='row'>"
						html+="<div class='col-lg-12 moduleicon modVertical' data-moduleName='reports'  id='module_reports'>";
						html+="<div  class='row'>";
						html+="<div  class='col-12 text-center'>"; 
						html+="<span class=''>";
						html+="<img src='/HIS/hisglobal/images/e-clinic/module_img/report.png' class='imgmoduleicon' />";
						html+="</span>";
						html+="</div>";
						html+="<div  class='col-12 mt-1 text-center moduletext'>Reports</div>";		
						html+="</div>";
						html+="</div>";						
						html+="</div>";

						
						$('#moduleContainer').append(html);
						$('#moduleContainer').append("<br/><br/><br/><br/>");

						cnt=0; 
						$.each(moduleJson, function(indx, objModuleJson){
							html="<div class='row menuheading' id='menutitlereports_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'><div  class='col-12 text-center mt-1'><h4 style='color:var(--theme-menu-color)'>"+objModuleJson["moduleName"]+"</h4></div></div>";
							html+="<div class='row menus' id='menureports_"+objModuleJson["moduleNameWithoutSpace"]+"' style='display:none;'></div>";
							$('#menuContainer').append(html);											 
							createVerticalLeafNode(objModuleJson["moduleNameWithoutSpace"],objModuleJson["moduleName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, "0", "Reports","menureports_"+objModuleJson["moduleNameWithoutSpace"]);

							if($('#menureports_'+ objModuleJson["moduleNameWithoutSpace"]).find('.menu').length==0){
								$('#menureports_'+ objModuleJson["moduleNameWithoutSpace"]).remove();
								$('#menutitlereports_'+ objModuleJson["moduleNameWithoutSpace"]).remove();								
							}
							else
								cnt=cnt+$('#menureports_'+ objModuleJson["moduleNameWithoutSpace"]).find('.menu').length								
						});
						if(cnt==0){
							$('#module_reports').remove();
						}
						 
						
				/*	if($('.modVertical').length==1){
						checkForModuleIdWiseListpage()
						$('.modVertical').each(verticalModuleClick);
					}	
					*/
					$('.modVertical').click(verticalModuleClick);

					$('.menu').click(function(){
						var url = $(this).attr("data-url");
						openURL(url);
						});
					$('#closeDivMenu').click(closeDivMenu);
				
				}

			
				
				
				function createVerticalInternediateMenu(moduleNameWithoutSpace,moduleName, moduleWiseIntermediateMenu,moduleWiseLeafMenu, parentMenuId, processType,containerName){
					/* console.log("check 1>>>" +JSON.stringify(moduleWiseIntermediateMenu))
					console.log("check 2>>> moduleNameWithoutSpace==" + moduleNameWithoutSpace);

					console.log("check 3>>> moduleWiseIntermediateMenu[moduleNameWithoutSpace]==" + moduleWiseIntermediateMenu[moduleNameWithoutSpace]);
					 */
					if(!moduleWiseIntermediateMenu[moduleNameWithoutSpace]){
						console.log('returning ');
						return;
					}
					
					try{
					if( moduleWiseIntermediateMenu[moduleNameWithoutSpace].length>1){
						$.each(moduleWiseIntermediateMenu[moduleNameWithoutSpace],function(indx, objMenu){
								if(objMenu["processType"].toUpperCase()==processType.toUpperCase()){
									var accBodyId="submenu-body_" + moduleNameWithoutSpace+"_"+objMenu["menuid"];
									var html="<div class='col-12'><h6 style='text-align:left;margin:20px;color:var(--theme-menu-color)'>" + objMenu["menuName"] + "<h6></div>" ;
									html+="<div class='col-12'><div class='row' id='"+accBodyId+"'></div></div>" ;
									$('#'+containerName).append(html);
									createVerticalLeafNode(moduleNameWithoutSpace,objMenu["menuName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, objMenu["menuid"], processType,accBodyId);
								}
						});
					}
					else{
						objMenu=moduleWiseIntermediateMenu[moduleNameWithoutSpace];
						if(objMenu["processType"].toUpperCase()==processType.toUpperCase()){
							var accBodyId="submenu-body_" + moduleNameWithoutSpace+"_"+objMenu["menuid"];
							var html="<div class='col-12'><h6 style='text-align:left;margin:20px;color:var(--theme-menu-color)'>" + objMenu["menuName"] + "<h6></div>" ;
							html+="<div class='col-12'><div class='row' id='"+accBodyId+"'></div></div>" ;
							$('#'+containerName).append(html);
							createVerticalLeafNode(moduleNameWithoutSpace,objMenu["menuName"], moduleWiseIntermediateMenu,moduleWiseLeafMenu, objMenu["menuid"], processType,accBodyId);
						}	
					}
					}catch(err){
						console.log("err-----"+ err);
						//alert(JSON.stringify(moduleWiseIntermediateMenu));
					}
				}

				function  createVerticalLeafNode(moduleNameWithoutSpace,moduleName, moduleWiseIntermediateMenu,moduleWiseLeafMenu, parentMenuId, processType,containerName){

					if(moduleWiseLeafMenu[moduleNameWithoutSpace].length>1){	
						$.each(moduleWiseLeafMenu[moduleNameWithoutSpace],function(indx, objModuleWiseLeafMenu){
							/* alert(objModuleWiseLeafMenu["parentMenuId"].toUpperCase()+ "  ==   "+ parentMenuId.toUpperCase() +"====="+ 
									(objModuleWiseLeafMenu["parentMenuId"].toUpperCase()==parentMenuId.toUpperCase())) */ 						
							if(objModuleWiseLeafMenu["processType"].toUpperCase()==processType.toUpperCase() && objModuleWiseLeafMenu["parentMenuId"].toUpperCase()==parentMenuId.toUpperCase() ){
								var html="<div class='col-12 mb-2 menu' title='"+objModuleWiseLeafMenu["menuName"]+"' data-menuid='"+objModuleWiseLeafMenu["menuid"]+"'  data-url='"+objModuleWiseLeafMenu["url"]+"'>";	
								html+="<button class='buttonmenu'>";
								html+="<span class='button-decor'></span>";
								html+="<div class='button-content'>";
								html+="<div class='button__icon'>";
								html+="<i class='"+objModuleWiseLeafMenu["font_icon_name"]+" fa-2x'></i>";
								html+="</div>";
								html+="<span class='button__text'>"+objModuleWiseLeafMenu["menuName"]+"</span>";
								html+="</div>";
								html+="</button>"; 
								html+="</div>";
								// if(containerName=="menureports_ABHA")
								//alert(html); 
								$('#'+containerName).append(html);	
								
							}
						});
					}
					else{
						var objModuleWiseLeafMenu=moduleWiseLeafMenu[moduleNameWithoutSpace];
						if(objModuleWiseLeafMenu["processType"].toUpperCase()==processType.toUpperCase() && objModuleWiseLeafMenu["parentMenuId"].toUpperCase()==parentMenuId.toUpperCase() ){
							var html="<div class='col-12 mb-2 menu' title='"+objModuleWiseLeafMenu["menuName"]+"' data-menuid='"+objModuleWiseLeafMenu["menuid"]+"' data-url='"+objModuleWiseLeafMenu["url"]+"'>";	
							html+="<button class='buttonmenu'>";
							html+="<span class='button-decor'></span>";
							html+="<div class='button-content'>";
							html+="<div class='button__icon'>";
							html+="<i class='"+objModuleWiseLeafMenu["font_icon_name"]+" fa-2x'></i>";
							html+="</div>";
							html+="<span class='button__text'>"+objModuleWiseLeafMenu["menuName"]+"</span>";
							html+="</div>";
							html+="</button>"; 
							html+="</div>";
							// if(containerName=="menureports_ABHA")
							//alert(html); 
							$('#'+containerName).append(html);	
							
						}

					}
					
				}


				
				function createHorizontalModuleList(){
					$('#divMainPageContainer').empty();
					var moduleJson= JSON.parse($('#moduleJson').html());
					var html="<div class='row m-1 p-2 bg-white'>";
					$.each(moduleJson, function(indx, objModuleJson){
						html+="<div class='col-xl-4 col-lg-4 col-md-4 col-sm-4 col-4  mb-1' style='padding-top: 14px;'  id='module_"+objModuleJson["moduleNameWithoutSpace"]+"'>";
						html+="<div  class='row   btn-his-menu-icon' style='margin: 0px;padding: 0;'>";
						html+="<div  class='col-12 ' style='padding:4px;'>"; 
						html+="<img src='"+objModuleJson["moduleImageName"]+"' class='imgmoduleicon' />";
						html+="</div>";
						html+="<div  class='col-12 text-center mt-1'>"+objModuleJson["moduleName"]+"</div>";		
						html+="</div>";						
						html+="</div>";
					});
					html+="</div>";	
					
					$('#divMainPageContainer').html(html);
					 
				}

			
				function refreshIFrame(){					
					$('#divMenu').hide();
					var url = $('#selectedMenuUrl').val();	
					$('#moduleContainer').addClass('moduleContainerSmall');
					$('#divFormContainer').addClass('iframeFormContainerSmall');	
					$('.moduletext').hide();
					$('#divFormContainer').show();
					$('.btnMenuClick').show();
					loadInIframe(1, url);
				}
				
				function loadInIframe(key, uri){
					
					
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
				 
				
				 

					
				function verticalModuleClick(){
					//alert("inside verticalModuleClick");
					$('#selectedModuleId').val("");
					$('#selectedModuleWiseMenu_open_with_pk').val("");
					
					$('.moduleicon').removeClass('moduleiconActive');
					$(this).addClass('moduleiconActive');
					$('.moduletext').show();
					$('#moduleContainer').removeClass('moduleContainerSmall');
					$('#divFormContainer').removeClass('iframeFormContainerSmall');

					$('#divMenu').show();
					$('.menuheading').hide();
					$('.menus').hide();
					
					
					var moduleName= $(this).attr("data-moduleName");
					
				   
					if(moduleName=="setup"){
						if($("[id^=menusetup_]").find(".menu").length==1){
							$("[id^=menusetup_]").find(".menu").each(function(){
								var url = $(this).attr("data-url");
								openURL(url);
								});
							return;
						}
						$("[id^=menusetup_]").each(function(){
							var key=$(this).attr("id").split("_")[1];
							if($(this).find('.menu').length!=0){										
								$('#menusetup_'+key).show();
								$('#menutitlesetup_'+key).show();
							}									
						});
						$('#divMenu').removeClass("col-xl-3 col-lg-3  col-md-9 col-sm-9 col-8").addClass("col-xl-10 col-lg-10  col-md-9 col-sm-9 col-8");
						$('.menu').removeClass('col-12').addClass('col-xl-4 col-lg-4  col-md-6 col-sm-6');
						$('#divFormContainer').hide();
							
					}
					else if(moduleName=="reports"){
						if($("[id^=menureports_]").find(".menu").length==1){
							$("[id^=menureports_]").find(".menu").each(function(){
								var url = $(this).attr("data-url");
								openURL(url);
								});
							return;
						}
						
						$("[id^=menureports_]").each(function(){
							var key=$(this).attr("id").split("_")[1];							
							if($(this).find('.menu').length!=0){										
								$('#menureports_'+key).show();
								$('#menutitlereports_'+key).show();
							}									
						});
						$('#divMenu').removeClass("col-xl-3 col-lg-3  col-md-9 col-sm-9 col-8").addClass("col-xl-10 col-lg-10  col-md-9 col-sm-9 col-8");
						$('.menu').removeClass('col-12').addClass('col-xl-4 col-lg-4  col-md-6 col-sm-6');
						$('#divFormContainer').hide();	
														
						
					}
					else{
						// services part
						//alert('inside >>> ' + $('#moduleListForListing').html());
						
						var flagMenuView=true;
						if($('#moduleListForListing').html()!=""){
							//alert($('#moduleListForListing').html());
							var jsonModuleListForListing=JSON.parse($('#moduleListForListing').html());
							for( var x=0;x<jsonModuleListForListing.length;x++){
								//alert('moduleId'+jsonModuleListForListing[x]["moduleId"].toUpperCase()+'moduleName'+moduleName.toUpperCase());
								if(jsonModuleListForListing[x]["moduleId"].toUpperCase()==moduleName.toUpperCase()){
									$('#selectedModuleId').val(moduleName);
									//alert("here>>" + jsonModuleListForListing[x]["menu_open_with_pk_with_on_visible_status"]);
									if(jsonModuleListForListing[x]["menu_open_with_pk_with_on_visible_status"]!=undefined  && jsonModuleListForListing[x]["menu_open_with_pk_with_on_visible_status"]!=null && jsonModuleListForListing[x]["menu_open_with_pk_with_on_visible_status"]!=""){
										$('#selectedModuleWiseMenu_open_with_pk').val(jsonModuleListForListing[x]["menu_open_with_pk_with_on_visible_status"]);										
										//alert($('#selectedModuleWiseMenu_open_with_pk').val());
									}
									
									flagMenuView=false;
									$('#divMenu').hide();
									$('#divFormContainer').show();	
									$('#divFormContainer').addClass('col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9').removeClass('col-xl-8 col-lg-8 col-md-2 col-sm-2 col-3');
									$('#divFormContainer').empty();
									
									
									var url=jsonModuleListForListing[x]["listPageURL"]
									 url = createFHashAjaxQuery(url);
									
									//alert(JSON.stringify(jsonModuleListForListing[x]))
									//alert('url'+url);
									var html="<fieldset style='width:99%;margin-left:0px;' >" ;									
									html+="<div class='w-100' id='listFormContainer'></div></fieldset>";
									$('#selectedModuleName').val(jsonModuleListForListing[x]["moduleNameDisplay"])
									$('#divFormContainer').html(html)
									
									$('#listFormContainer').load(url, function(){})
									return;
								}
							}
						}
						
						
						
						
							if($('#menu_'+ moduleName).find(".menu").length==1){
								$('#menu_'+ moduleName).find(".menu").each(function(){
									var url = $(this).attr("data-url");
									openURL(url);
									});
								return;
							}
							else{
								$('#divFormContainer').removeClass('col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9').addClass('col-xl-8 col-lg-8 col-md-2 col-sm-2 col-3')	
							}

							
							$('#menutitle_'+ moduleName).show();
							$('#menu_'+ moduleName).show();
							$('#divMenu').removeClass("col-xl-10 col-lg-10  col-md-9 col-sm-9 col-8").addClass("col-xl-3 col-lg-3  col-md-9 col-sm-9 col-8");
							$('.menu').addClass('col-12').removeClass('col-xl-4 col-lg-4  col-md-6 col-sm-6');
							$('#divFormContainer').removeClass('col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9').addClass('col-xl-8 col-lg-8 col-md-2 col-sm-2 col-3')
							$('#divFormContainer').show();	
						}
					
					
				}
				function closeDivMenu(){					
					$('#divMenu').hide();
					$('#moduleContainer').addClass('moduleContainerSmall');
					$('#divFormContainer').addClass('iframeFormContainerSmall');
					$('.moduletext').hide();
					$('#divFormContainer').addClass('col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9').removeClass('col-xl-8 col-lg-8 col-md-2 col-sm-2 col-3');	 
					$('#divFormContainer').show();	
				}
				
				function showWelcomePage(){
					var html=`<section id="more-features" class="text-center pt-1 mt-1 bg-white" style='min-height:100vh'> <span></span>
			            <h5 class='mt-4 fw-bold' style='color: var(--theme-menu-color);'>Welcome to the CGHS HMIS!</h5>
			            <h6 class='mt-4 fw-bold' >We're delighted to have you here.</h6>
			            <div class="row aos-init aos-animate" data-aos="fade-up">
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/dashboard.png"> </div>
			                        <h6>Dashboard &amp; Reporting</h6>
			                        <p>Extensive Dashboards and Real time statistics for trend/pattern analysis </p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/customization.png">
			                        </div>
			                        <h6>Customization</h6>
			                        <p>Tailor-made eClinic software solution to fit your unique healthcare needs. Customize your system for seamless integration and efficient patient care. </p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"> <img src="/HIS/hisglobal/images/e-clinic/img/icons/web-application.png">
			                        </div>
			                        <h6>Web Application</h6>
			                        <p>Streamline your healthcare services with our cutting-edge eClinic web application. Deliver efficient and personalized care conveniently online.</p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/hl7.png"></div>
			                        <h6>HL7 and MDDS</h6>
			                        <p>Seamlessly integrate HL7 standards and MDDS protocols into your eClinic software solution for efficient data exchange and medical device interoperability. </p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/ehr.png"></div>
			                        <h6>Electronic Health Records </h6>
			                        <p>EHRs are digital patient records that improve healthcare by providing comprehensive health information to providers.</p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/sms.png"></div>
			                        <h6>SMS and Email Integration</h6>
			                        <p>Integrating SMS and Email enhances communication by allowing messages to be sent through various channels, facilitating efficient interaction with users.</p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/consultation.png">
			                        </div>
			                        <h6>Consultation</h6>
			                        <p>Get expert consultation on optimizing your eClinic software solution. Enhanced software for improved patient care and operational efficiency.</p>
			                    </div>
			                </div>
			                <div class="col-md-3">
			                    <div class="box mt-5">
			                        <div class="icon d-flex align-items-center"><img src="/HIS/hisglobal/images/e-clinic/img/icons/patient-satisfaction.png"></div>
			                        <h6>Patient Satisfation &amp; Support</h6>
			                        <p>Focus on patient satisfaction and support with our eClinic software solution for a seamless care experience. </p>
			                    </div>
			                </div>
			        </div></section>`;

					$('#divFormContainer').html(html);
				}


				
				function showMenuPage(){
					
					if($('#defaultMenuURL').val()!=""){
						openURL($('#defaultMenuURL').val());												
					}
					else{
						showWelcomePage()
						
					}
					$('.btnMenuClick').hide();
					$('#moduleContainer').removeClass('moduleContainerSmall');
					$('#divFormContainer').removeClass('iframeFormContainerSmall');
					$('.moduleicon').removeClass('moduleiconActive');
					$('.moduletext').show();
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
				 
				
				
				 function showActions(){
					 var key=$(this).attr("id").split("_")[1];
						$('[id^=trdata_]').removeClass('table-warning');
						$('[id^=btnaction_]').show();
						$('[id^=traction_]').hide();
						
						$('#trdata_'+key).addClass('table-warning');
						$('#traction_'+key).show();
				 }
				function hidePreloader(){

					$('#preloader').delay(450).fadeOut('slow');
				     $('body').delay(450).css({
				        'overflow': 'visible'
				      });  

					}
				function showPreloader(){
					 $('#preloader').show();
				}
				function openURL(url){
					var key=1;
					var newiframehtml= "<div class='ifcontainer'  style='min-height:92vh; height: 100%;' id='divForIframe_"+key+"'>";
			    	newiframehtml+="<iframe  src='' class='iframecss' wmode='transparent' frameborder='0' id='iframecss_"+key+"'></iframe>";
			    	newiframehtml+="</div>";
			    	$('#divFormContainer').html(newiframehtml);
			    	$('#divFormContainer').addClass('col-xl-11 col-lg-11  col-md-10 col-sm-10 col-9').removeClass('col-xl-8 col-lg-8 col-md-2 col-sm-2 col-3')	

			    	loadInIframe(key, url);
			    	$('#selectedMenuUrl').val(url);
			    	
					$('#divMenu').hide();
					$('#moduleContainer').addClass('moduleContainerSmall');
					$('#divFormContainer').addClass('iframeFormContainerSmall');
					
					$('.moduletext').hide();
					$('#divFormContainer').show();
					$('.btnMenuClick').show();		
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

		
	//openURL(uri.replace('*','='));
}

function closeModal(){
	closeFullScreenModal();
}
function closeFullScreenModal(){
	 $('#iframeModalFullScreen').attr("src","");
	 var selectedModuleId =$('#selectedModuleId').val();	 
	 $('#module_'+ selectedModuleId).each(verticalModuleClick);
	 
	 $('#modalFullScreen').modal('hide');
	 getnotification();
	/* $(".offcanvas-backdrop").removeClass('show');
	 $(".offcanvas").removeClass('show')
	 $(".offcanvas").attr("aria-modal", false);*/
	 
}
		


function generateRecordWiseButton(status){
	var buttonHtmlPKBased="";
	var jsonArrbuttonHtmlPKBased=null;
	//alert($('#buttonHtmlPKBased').html());
	if($('#buttonHtmlPKBased').html().trim()!=""){
		jsonArrbuttonHtmlPKBased= JSON.parse($('#buttonHtmlPKBased').html());
		$.each(jsonArrbuttonHtmlPKBased,function(indx, objModuleWiseLeafMenu){
			var status_to_show =objModuleWiseLeafMenu["status_to_show"].split(",");
			
			if((status_to_show.length==1 && status_to_show[0]==-1) || status_to_show.indexOf(status)>=0){
				buttonHtmlPKBased+=" <li  ><a class='dropdown-item dropdown-button btnLeafMenu' data-menuid='"+objModuleWiseLeafMenu["menuId"]+"' data-pk='#pk#' title='"+objModuleWiseLeafMenu["menuName"]+"' data-url='"+objModuleWiseLeafMenu["url"]+"'>" +				 
				 "<div class='button-content'><div class='button__icon'>"+
				 "<i class='"+objModuleWiseLeafMenu["font_icon_name"]+" fa-2x'></i></div><span class='button__text'>"+objModuleWiseLeafMenu["menuName"]+"</div></a></li>" ;
			}
			
		});
	}
	return buttonHtmlPKBased;
}

function callgenerateReport(configJson){
	
	
	
	var inputData=JSON.stringify(configJson["inputData"])
	//alert(inputData);
	var serviceName=configJson["serviceName"];
	var formId=configJson["formId"];
	var format=configJson["format"];
	
	//alert($('#'+formId).find('input[name="inputData"]').val());
	
	if($('#'+formId).find('input[name="inputData"]').val()==undefined){
	
	$('#'+formId).append("<input type='hidden' name='serviceName' value="+serviceName+"><input type='hidden' name='inputData' value='"+inputData+"'><input type='hidden' name='format' value='"+format+"'>");
	
	}
	else{
		$('#'+formId).find('input[name="inputData"]').val(inputData);
		$('#'+formId).find('input[name="serviceName"]').val(serviceName);
		$('#'+formId).find('input[name="format"]').val(format);
	}
	
	 document.forms[formId].hmode.value = "getReport";
	 //document.forms[0].innerHTML('')
	 document.forms[formId].target = "_blank";
	 document.forms[formId].action = "/AHIMSG5/FFXACTION";
	 document.forms[0].submit();
	 
}