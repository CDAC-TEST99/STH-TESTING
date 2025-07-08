<!DOCTYPE html>
<html lang="en">
<%@page import="org.json.JSONObject"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@page import="hislogin.transactions.utl.UserDeskUTL"%>
<%@page import="java.awt.Toolkit"%>
<%@page import="java.awt.Dimension"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page
	import="hissso.validation.credentails.authentication.AuthenticationCredentials"%>
<%@page import="vo.usermgmt.MenuMasterVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="hislogin.config.HISLoginConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page
	import="hissso.validation.credentails.authorization.AuthorizationCredentials"%>
<%@page import="java.util.*"%>
<%@page import="hisglobal.utility.HisUtil"%>
<%@page import="hisglobal.utility.Entry"%>
<%@page import="vo.usermgmt.UserMasterVO"%>
<%@page import="application.filters.Base64Utils"%>



<%
	UserMasterVO userVO = (UserMasterVO) request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);
	String key = (String) session.getAttribute(HISSSOServerConfig.LOGIN_TAB_KEY);
	
	String userId="";
	String hospitalCode="";
	AuthorizationCredentials objAuthorize = (AuthorizationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
	AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
	String varSSOTicketGrantingTicket=  (String) request.getAttribute("varSSOTicketGrantingTicket");
	Map zeroLevelModules=null;
	int ellipseAfter=32;
	int ellipseAfterForSecondLevelMenu=25;
	if(objAuthorize!=null && objAuthorize.getMenusHirarchyMap()!=null){
		 userId=objAuthenticate.getVoUser().getVarUserId();
		 hospitalCode= objAuthenticate.getVoUser().getVoHospital().getVarHospitalCode();
		  zeroLevelModules = objAuthorize.getMenusHirarchyMap();
	}
	JSONObject objContent =(JSONObject)request.getSession().getAttribute("content");
	
	String clientShort= "";
	
		if(session.getAttribute("CLIENT_SHORT_NAME") != null)
	  		clientShort=session.getAttribute("CLIENT_SHORT_NAME").toString();
	
	
	if(objContent==null){
		objContent= new JSONObject();
		objContent.put("clientId", "0");
		objContent.put("sushrutlogo", "" 
				);
		objContent.put("clientName", "");
		objContent.put("clientShortName", "");
		
		objContent.put("clientLogoImage", "/HIS/hisglobal/images/cghs_logo_big.png");
		
		
		
	}
	
%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Cache-Control" Content="no-store" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setHeader("Cache-Control", "no-store");
%>

<title><%=clientShort %></title>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Sushrut@Clinic">
	<meta name="author" content="CDAC">
	<meta name="keywords" content="Sushrut,Clinic">
	
	
	<link href="/HIS/hisglobal/images/e-clinic/img/icons/logo.ico" rel="icon"  type="image/x-icon">
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link href="/HIS/hisglobal/cdac_awesome/aos/aos.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/css2.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/responsive.css">
    <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.css">
     <!-- <link href="/HIS/hisglobal/cdac_awesome/css/cdac_preset1.css" rel="stylesheet" > -->
    
    
    	
    <script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"></script>
    <script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
    <script src="/HIS/hisglobal/cdac_awesome/js/popper.min.js"></script>
    <script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.easing.min.js"  ></script>
    <script type="text/javascript" src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
	<script src="https://afsangoshthee.cdac.in/external_api.js"></script>

<style type="text/css">
.navbar .megamenu{ padding: 1rem; }
/* ============ desktop view ============ */
@media all and (min-width: 992px) {
	
	.navbar .has-megamenu{position:static!important;}
	.navbar .megamenu{left:0; right:0; width:100%; margin-top:0;  }
	
}	
/* ============ desktop view .end// ============ */


/* ============ mobile view ============ */
@media(max-width: 991px){
	.navbar.fixed-top .navbar-collapse, .navbar.sticky-top .navbar-collapse{
		overflow-y: auto;
	    max-height: 90vh;
	    margin-top:10px;
	}
}
/* ============ mobile view .end// ============ */
</style>

<script type="text/javascript">

 


	document.addEventListener("DOMContentLoaded", function(){
        /////// Prevent closing from click inside dropdown
        document.querySelectorAll('.dropdown-menu').forEach(function(element){
        	element.addEventListener('click', function (e) {
        		e.stopPropagation();
        	});
        })
    }); 


	
	
	// DOMContentLoaded  end
	$(document).ready(function() {

		
					 
				 
		
		 $( "button" ).click(function( event ) {
				event.preventDefault();
				});
		$('.module_menu').hide();
		$('.tab-bg').hide();
		$('.modicon').click(openModuleMenu);
		$('.menutextusm').click(openLeafMenu)

		$('#btnRefreshFrame').click(reloadFrame);
		//alert($('#varUsrName').val());
		$('#userName').html($('#varUsrName').val()); 
		
		 $('#preloader').delay(450).fadeOut('slow');
	       $('body').delay(450).css({
	        'overflow': 'visible'
	      });  
		$('#btnlogout').click(callLogOut);

		if($('#defaultMenuId').val()!="")
			$("[data-menuid="+$('#defaultMenuId').val()+"]").each(openLeafMenu);
		
		//alert($('#defaultMenuId').val());      
	});
	function initMegaMenu(){
		$('.menutextusm-accordion-header').addClass('collapsed').attr("aria-expanded","false");
		$('.menutextusm_flush_collapseOne').removeClass('show');
		$('.module_menu').hide();
		$('.mod').addClass('col-lg-2').removeClass('col-lg-12 selectedMenu');
		$('.modicon').addClass('col-lg-12');
		$('.modicon').addClass('col-lg-12').removeClass("selectedModuleCSS");
		$('.modicon').find('.moduleName').addClass('modtxt');
		$('.modicon').find('.moduleDesc').hide();
		
	}
	function openModuleMenu(){

		var modobj=$(this).closest('.mod');
		var moduleName=$(modobj).attr("id").split("_")[1];
		if($('#modMenu_'+moduleName).is(":visible") ==false){
			$('.module_menu').hide();
			$('.mod').addClass('col-lg-2').removeClass('col-lg-12 selectedMenu');
			$('.modicon').addClass('col-lg-12').removeClass("selectedModuleCSS");
			$('.modicon').find('.moduleName').addClass('modtxt');
			$('.modicon').find('.moduleDesc').hide();
			$(modobj).removeClass("col-lg-2").addClass("col-lg-12").delay(450).show('slow');		
			$(modobj).find('.modicon').addClass("col-lg-2").removeClass("col-lg-12");
			$('#modMenu_'+moduleName).show();
			var modiconObj=$(modobj).find(".modicon")
			$(modiconObj).addClass('selectedModuleCSS');
			$(modiconObj).find('.moduleName').removeClass('modtxt');
			$(modiconObj).find('.moduleDesc').show();
			
			$(modobj).addClass('selectedMenu');
			
		}
		else{
			$('.module_menu').hide();
			$('.mod').addClass('col-lg-2').removeClass('col-lg-12 selectedMenu');
			$('.modicon').addClass('col-lg-12');			
			$(modobj).removeClass('selectedMenu');
			$('.modicon').addClass('col-lg-12').removeClass("selectedModuleCSS");
			$('.modicon').find('.moduleName').addClass('modtxt');
			$('.modicon').find('.moduleDesc').hide();
		}
		
	}
	
	
	function openLeafMenu(){
		var menuName=$(this).attr("title");
		var url=$(this).attr("data-url");
		var menuId=$(this).attr("data-menuId");
		
		var ismobileAndTabletCheck=mobileAndTabletCheck();
		var key=menuId;
		var ellipseAfter=30;
		if(menuName==undefined){
			alert("menu name not found")
			return;
		}

		var menuDisplayName=menuName.length>ellipseAfter?menuName.substr(0,ellipseAfter)+"...":menuName; ;
		/*showing div which will contain all iframs and hiding all exsting iframes and welcome div */
		$('#allIframeContainer').show();
		$('.tab-bg').show();
		 
		$('.ifcontainer').hide();
	    $('#isWelcomePage').hide();	
	    $('.dropdown-menu').removeClass("show");
	    
	    
		
		$('.module_menu').hide();
		$('.mod').addClass('col-lg-2').removeClass('col-lg-12 selectedMenu');
		$('.modicon').addClass('col-lg-12').removeClass("selectedModuleCSS");
		$('.modicon').find('.moduleName').addClass('modtxt');
		$('.modicon').find('.moduleDesc').hide();	

		/*hiding main dropdown toggle*/
		$("[aria-expanded=true]").removeClass("show").attr("aria-expanded","false");
		$("[data-bs-popper=none]").removeClass("show").remove("data-bs-popper");

		/*focusing menu and iframe if menu selected is aready open */
		if($('#deskmenucol_'+key).length>0){
			$('#deskmenucol_'+key).each(showTab);	
			return;	
		}
		
		if(ismobileAndTabletCheck==true ){
			$('.deskmenucol').remove();	
		}
		else{
			if($('.deskmenualert').length==5){
				var confirmFlag= confirm("Can open 4 Tab at a time. Did You want to close one tab");
				if(confirmFlag==false)
					return;
				
				//removing first non-active tab
				$('.deskmenualert').not('.active').first().closest('.deskmenucol').remove();
			}
			$('.deskmenualert').removeClass("active");
		}

		
		
	    
		/*creating tab*/
	    var newtabhtml="<div class='col-sm-3 deskmenucol' id='deskmenucol_"+key+"'>";
	    newtabhtml+="<div title='"+ menuName+"'class='alert alert-secondary alert-dismissible  fade show deskmenualert active' role='alert' data-url='"+url+"' id='deskmenualert_"+key+"'>";
	    newtabhtml+=menuDisplayName;
	    newtabhtml+="<a type='button' class='btn-close deskmenualertClose'  id='deskmenualertClose_"+key+"'>X</a>";
	    newtabhtml+="</div>";
	    newtabhtml+="</div>";
	    $('#rowTab').append(newtabhtml);
	    /*creating iframe with url*/
	    var newiframehtml= "<div class='ifcontainer'  style='height: 100%;' id='divForIframe_"+key+"'>"
	    	newiframehtml+="<iframe  src='' class='iframecss' wmode='transparent' frameborder='0' id='iframecss_"+key+"'></iframe>";
	    	newiframehtml+="</div>";

		$('#allIframeContainer').append(newiframehtml);
		
		loadInIframe(key, url);		
		$("#deskmenualert_"+key).click(showTab);
		$("#deskmenualertClose_"+key).click(closeTab);
		$('#btnRefreshFrame').show();
	}

	function loadInIframe(key, uri){
		
		
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
			$('#preloader').delay(450).fadeOut('slow');		
		}); 
	}
	 function showTab(){
		 var key=$(this).attr("id").split("_")[1];
		 $('.deskmenualert').removeClass("active");
		 $('.ifcontainer').hide();
		 $('#deskmenualert_'+key).addClass('active');
		 $('#divForIframe_'+key).show();		 		
	 }
	function closeTab(){
		 var key=$(this).attr("id").split("_")[1];
		 if($('.deskmenualert').length>1){
			 if($( "#deskmenualert_"+key ).hasClass("active")){
				 //alert($( "#deskmenualert_"+key ).hasClass("active"));
				 if($( "#deskmenucol_"+key ).next().length>0) 	
			 		$( "#deskmenucol_"+key ).next().each(showTab);				 
				else
					$( "#deskmenucol_"+key ).prev().each(showTab); 
			 }			 
		 }
		 else{
			  $('#isWelcomePage').show();	
			  $('.tab-bg').hide();
			  $('#btnRefreshFrame').hide();
		 }

		 
		 $("#deskmenucol_"+key).remove();
		 $("#divForIframe_"+key).remove();		 
		
	 }
	 function closeTabfromIframeContent(){
		 var activeTablId= $('.deskmenualert').filter(".active").attr("id");
		 $('#activeTablId').each(closeTab);	
	 }

	function reloadFrame(){
	 	var activeTablId= $('.deskmenualert').filter(".active").attr("id");
		var key= activeTablId.split("_")[1];
		var url=$('#deskmenualert_'+key).attr("data-url");
		loadInIframe(key, url); 
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
	 function callLogOut() {
		  $('#preloader').show();
		  deleteCookies();
		  submitForm1("logoutLogin");
	 }


	 function formDataTampered(menuId){
		//alert("menuId>>"+menuId)
		 $('#divForIframe_'+menuId).html("<b>Form Data Tampered</b>")		 
		 		 
		 }

		
	 function submitForm1(actionURL)
	 {

		 alert("inside submitForm1");

		 document.forms[0].action = actionURL ;
	 	document.forms[0].submit();
	 }

	/*for cheking if mobile or tablet*/
	  window.mobileAndTabletCheck = function() {
		   let check = false;
		   (function(a){if(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(a)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\-(n|u)|c55\/|capi|ccwa|cdm\-|cell|chtm|cldc|cmd\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\-s|devi|dica|dmob|do(c|p)o|ds(12|\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\-|_)|g1 u|g560|gene|gf\-5|g\-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd\-(m|p|t)|hei\-|hi(pt|ta)|hp( i|ip)|hs\-c|ht(c(\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\-(20|go|ma)|i230|iac( |\-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc\-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|\-[a-w])|libw|lynx|m1\-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\-2|po(ck|rt|se)|prox|psio|pt\-g|qa\-a|qc(07|12|21|32|60|\-[2-7]|i\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\-|oo|p\-)|sdk\/|se(c(\-|0|1)|47|mc|nd|ri)|sgh\-|shar|sie(\-|m)|sk\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\-|v\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\-|tdg\-|tel(i|m)|tim\-|t\-mo|to(pl|sh)|ts(70|m\-|m3|m5)|tx\-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\-|your|zeto|zte\-/i.test(a.substr(0,4))) check = true;})(navigator.userAgent||navigator.vendor||window.opera);
		   return check;
		 };	

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

			 function addButtons(dlg) {
				    // Define Buttons
				    var $close = dlg.find(".ui-dialog-titlebar-close");
				    var $min = $("<button>", {
				      class: "ui-button ui-corner-all ui-widget ui-button-icon-only ui-window-minimize",
				      type: "button",
				      title: "Minimize"
				    }).insertBefore($close);
				    $min.data("isMin", false);
				    $("<span>", {
				      class: "ui-button-icon ui-icon ui-icon-minusthick"
				    }).appendTo($min);
				    $("<span>", {
				      class: "ui-button-icon-space"
				    }).html(" ").appendTo($min);
				    var $max = $("<button>", {
				      class: "ui-button ui-corner-all ui-widget ui-button-icon-only ui-window-maximize",
				      type: "button",
				      title: "Maximize"
				    }).insertBefore($close);
				    $max.data("isMax", false);
				    $("<span>", {
				      class: "ui-button-icon ui-icon ui-icon-plusthick"
				    }).appendTo($max);
				    $("<span>", {
				      class: "ui-button-icon-space"
				    }).html(" ").appendTo($max);
				    // Define Function
				    $min.click(function(e) {
				      if ($min.data("isMin") === false) {
				        console.log("Minimize Window");
				        $min.data("original-pos", dlg.position());
				        $min.data("original-size", {
				          width: dlg.width(),
				          height: dlg.height()
				        });
				        $min.data("isMin", true);
				        dlg.animate({
				          height: '40px',
				          top: $(window).height() - 50
				        }, 200);
				        dlg.find(".ui-dialog-content").hide();
				      } else {
				        console.log("Restore Window");
				        $min.data("isMin", false);
				        dlg.find(".ui-dialog-content").show();
				        dlg.animate({
				          height: $min.data("original-size").height + "px",
				          top: $min.data("original-pos").top + "px"
				        }, 200);
				      }
				    });
				    $max.click(function(e) {
				      if ($max.data("isMax") === false) {
				        console.log("Maximize Window");
				        $max.data("original-pos", dlg.position());
				        $max.data("original-size", {
				          width: dlg.width(),
				          height: dlg.height()
				        });
				        $max.data("isMax", true);
				        dlg.animate({
				          height: $(window).height() + "px",
				          width: $(window).width() - 20 + "px",
				          top: 0,
				          left: 0
				        }, 200);
				      } else {
				        console.log("Restore Window");
				        $max.data("isMax", false);
				        dlg.animate({
				          height: $max.data("original-size").height + "px",
				          width: $max.data("original-size").width + "px",
				          top: $max.data("original-pos").top + "px",
				          left: $max.data("original-pos").top + "px"
				        }, 200);
				      }
				    });
				  }

				 

		  //  var videoRoomName = generateRoomName("Monti");
		        var api;
		        
		       
		        function initIframeAPI(json){
		        	//alert("inside initIframeAPI=="+  JSON.stringify(json));
		        	try{
		            const domain = json["url"]
		            const Options = {
		                configOverwrite: {
		                    startWithAudioMuted: false,
		                    startWithVideoMuted: false,
		                    defaultLocalDisplayName: 'CGHS',
		                    defaultRemoteDisplayName: 'fellow participant',
		                    defaultLanguage: 'Hi'
		                },
		                interfaceConfigOverwrite: {
		                    APP_NAME: 'CGHS',
		                    DEFAULT_WELCOME_PAGE_LOGO_URL: 'path_of_image',
		                    PROVIDER_NAME: 'CGHS',
		                    defaultRemoteDisplayName: 'fellow participant',
		                    defaultLanguage: 'Hi'
		                },
		                roomName:json["videoRoomName"],
		                jwt: json["jwtToken"],
		                width: '500px',
		                height: '600px',
		                parentNode: document.querySelector('#eConsultation')
		            };
		           api = new JitsiMeetExternalAPI(domain, Options)
		           $( "#eConsultation" ).dialog({
		        	   draggable: true,
		        	    classes: {
		        	      "ui-dialog": "ui-window-options",
		        	      "ui-dialog-titlebar": "ui-window-bar"
		        	    },
		        	    modal: false,
		        	    responsive: true,
		        	     width: 510, // Set the desired width
		        	    height: 610, // Set the desired height
		        	    "position": { my: "left top", at: "right bottom", of: window }
		               });
		           addButtons(dlg) 

		        /*    $('#eConsultation').dialog({
		        	    draggable: true,
		        	    autoOpen: false,
		        	    classes: {
		        	      "ui-dialog": "ui-window-options",
		        	      "ui-dialog-titlebar": "ui-window-bar"
		        	    },
		        	    modal: false,
		        	    responsive: true,
		        	     width: 700, // Set the desired width
		        	    height: 710, // Set the desired height
		        	  });
		           addButtons($(".ui-window-options")); */
		        	}catch(err){
			        	console.log("initIframeAPI err>>>" );
			        	console.log(err );
			        	//alert("e-Consultancy Service not available right now. please try later.")
			        }
		        }


		      
		        
</script>

</head>
<body class='deskbk'>

<!-- Preloader Start -->
     <div id="preloader">
		  <div id="loader">   
		  </div>
		  <span class='midtext'><img src="/HIS/hisglobal/images/e-clinic/img/eshurut_clinic_logo_shiled.png" ></span>
		</div>   
    <!-- Preloader Ends -->
<div class="container-fluid" style="padding: 0;">
<!-- ============= COMPONENT ============== -->
<nav class="navbar navbar-expand-lg navbar-light  bg-white w-100">
<div class="container-fluid">
	<a class="navbar-brand" href="/AHIMSG5/hissso/Login">
    	<div class="d-flex flex-row">
    		<div ><img src='<%=objContent.getString("clientLogoImage") %>' class='img-fluid'></div>
    		<div style="width:100%" class='mt-2' >
    			<% if(objContent.has("sushrutlogo")) {%>
    			<span class='eshusrut-brandName eshusrut-brandName-color '>  <%=objContent.getString("sushrutlogo")  %></span> 			    			
    			<%} %>
			   <%--  <span class='eshusrut-brandName eshusrut-brandName-color4 '> <%=objContent.getString("clientName") %></span>	 --%>			
			   
			    <% if(session.getAttribute("CLIENT_NAME") != null ){ %>
    
    				 <span class='eshusrut-brandName eshusrut-brandName-color '> &nbsp;|  &nbsp;  <%=session.getAttribute("CLIENT_NAME").toString() %></span>	
        			 <% if(session.getAttribute("HOSPITAL_NAME") != null &&  session.getAttribute("HOSPITAL_CODE") != null  
        			 &&  !session.getAttribute("CLIENT_CODE").toString().equals(session.getAttribute("HOSPITAL_CODE").toString()) ){ %>
    
   					&nbsp; <span class='eshusrut-brandName eshusrut-brandName-color'>&nbsp; |</span> &nbsp;
   					 <span class='eshusrut-brandName eshusrut-brandName-color'><%=session.getAttribute("HOSPITAL_NAME").toString() %></span>	 
   
    <% } %>
        
    <% } %>
			   		 
	
			   		    
    		</div>
		</div>
    </a>
    
    
    
    
    
	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#main_nav"  aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"> <i class='d-block d-sm-none d-lg-none d-md-none d-xl-none' class='fas fa-bars fa-fw'> </i></span>
	</button>
	<div class="collapse navbar-collapse" id="main_nav">
		
		<ul class="navbar-nav ms-auto">
			
        	
        	<li class="nav-item dropdown  ">
				<a class="nav-link  dropdown-toggle eshusrut-menu-highLight  usernameMenu" href="#" data-bs-toggle="dropdown" >
				 Welcome <s:property value="varUsrName" />&nbsp;
				<i class='fas fa-caret-down'></i> 
				</a>
			    <ul class="dropdown-menu  dropdown-menu-end">
				  <li class='userdropdownli'>
				  	<div class="text-center">
                      	<h6 class='px-3 mb-2'>
                      		<img src="/HIS/hisglobal/images/e-clinic/module_img/user.png" class="imgmoduleicon rounded-circle" >
                      		
                      			<%  if(userVO.getUserSeatsDtl() != null && userVO.getUserSeatsDtl().size() > 1){ %>
				
				 					<div> Role : <%=userVO.getUserSeatsDtl().stream().filter(u -> u.getVarSeatId().equals(userVO.getVarUserSeatId()) ).findFirst().get().getVarSeatName() %></div>
				
								<% } %>
                      		
                      		
                      		<br/>                          
                      		<div id='userName' class='userName'></div>
                      	</h6>
                      </div>
                   </li>
				  <li class='userdropdownli'><a class="dropdown-item menutextusm" data-menuId='ChangeUserDetails' data-url='/AHIMSG5/hislogin/initChangeUserDetailsLgnFtr' title='Change User Details' href="#">Change User Details </a></li>
				  <li class='userdropdownli'><a class="dropdown-item menutextusm" data-menuId='ChangePassword' data-url='/AHIMSG5/hislogin/initChangePasswordLgnFtr' title='Change Password' href="#">Change Password</a></li>
				
				<%  if(userVO.getUserSeatsDtl() != null && userVO.getUserSeatsDtl().size() > 1){ %>
				
				  <li class='userdropdownli'><a class="dropdown-item menutextusm" data-menuId='ChangeRole' data-url='/AHIMSG5/hislogin/initChangePasswordLgnFtr' title='Change Role' href="#">Change Role</a></li>
				
				<% } %>
				
				  <li class='userdropdownli' ><a class="dropdown-item" href="#"  id='btnlogout'><span class='btn' style='width:100%'><i class='fas fa-right-from-bracket fa-fw'></i> &nbsp; &nbsp;Sign Out</span></a></li>				  
			    </ul>
			</li>
			<li class="nav-item dropdown has-megamenu"> 
				<a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown" onclick="initMegaMenu()"><i class='fas fa-bars fa-fw fa-2x icolor  d-none d-lg-block'></i><span class='eshusrut-menu d-block d-lg-none'>Modules</span> </a>
				<div class="dropdown-menu megamenu usmMegaMenu" role="menu">
						<div class="container-fluid">
							<div class='row'>
								
										<%
										String defaultMenuId= userVO.getVarMenuId();
										boolean flagDefaultMenuExist=false;
										if(zeroLevelModules!=null){
											Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
						          	   		int i=0;
						          	     	for (Map.Entry set : moduleSet ) {
						          	     		
						          	     		//System.out.println("Key===" +set.getKey());
						          	     		String[] arrModData=set.getKey().toString().split("#");
						          	     		String moduleName=arrModData[0];
						          	     		String moduleNameWithoutSpace=moduleName.trim().replaceAll("\\s+", ""); 
						          	     		//System.out.println("moduleNameWithoutSpace===" +moduleNameWithoutSpace);
						          	     		String moduleImageName=(1 >= 0 && 1 < arrModData.length)?arrModData[1]:"/HIS/hisglobal/images/e-clinic/module_img/defaultHealthImage.png";
						          	     		String moduleDescription=(2 >= 0 && 2 < arrModData.length)?arrModData[2]:"" ;
						          	     	%>
						          	     	<div class='col-lg-2 col-12 mod' id='module_<%=moduleNameWithoutSpace %>' >
												<div class='row'>
													<div class='col-lg-12 col-12 modicon' >
														<div class='w-100'>
														<img src="<%=moduleImageName %>" class="imgmoduleicon d-none d-lg-block" >
														</div>
														<div class='w-100 moduleName modtxt'>
														<%=moduleName %>
														</div>
														<div class='w-100 moduleDesc' style='display:none'>
															<%=moduleDescription %>
														</div>											
													</div>
													<div class='col-lg-10 col-12 module_menu' id='modMenu_<%=moduleNameWithoutSpace %>'>
													<div class="row">
													<%
													if (set.getValue() instanceof HashMap) {
														HashMap columnHeadingMap=(HashMap)set.getValue();
														Set<Map.Entry> columnHeadingSet = columnHeadingMap.entrySet();
														for (Map.Entry columnHeadinigMapSet : columnHeadingSet) {
															//System.out.println( columnHeadinigMapSet.getKey().toString());
															String processType=columnHeadinigMapSet.getKey().toString();
															HashMap columnMapFirstLevel=(HashMap) columnHeadinigMapSet.getValue();
															Set<Map.Entry> columnFirstLevelSet = columnMapFirstLevel.entrySet();
															%>
															
																	<div class="col-lg-4 col-12">
																	<div class="col-megamenu"><h6 class="modtxt float-start"><%=processType %> </h6>
																	<ul class="list-unstyled">
																	<%
																	for (Map.Entry firstLevelSet : columnFirstLevelSet){
																		String menuName=firstLevelSet.getKey().toString();
																		String menuNameDisplay=menuName.length()>ellipseAfter?menuName.substring(0,ellipseAfter)+"...":menuName; ;
																		String menuid=menuName.trim().replaceAll("\\s+", "");
																		if(firstLevelSet.getValue()  instanceof String){
																			//System.out.println("key===" + firstLevelSet.getKey() + " Value==" + firstLevelSet.getValue() );
																			org.json.JSONObject leafJson=new org.json.JSONObject(firstLevelSet.getValue().toString());
																			String font_icon_name=leafJson.getString("menuClassId")!=null && !leafJson.getString("menuClassId").equals("")?leafJson.getString("menuClassId"):"fas fa-file-medical";
																			menuid=leafJson.getString("menuId");
									   										String url=leafJson.getString("url");
									   										if(defaultMenuId!=null && !defaultMenuId.equals("") && defaultMenuId.equals(menuid)){
									   											flagDefaultMenuExist=true;
										          	   						}
									   										%>
									   											<li class='non-accordion-li'>
																					<a  class="menutextusm" title='<%=menuName %>' data-url='<%=url %>' data-menuId="<%=menuid%>">
																					<i class="<%=font_icon_name %> fa-fw fa-2x menuiconusm" aria-hidden="true" ></i>&nbsp;&nbsp;<span><%=menuNameDisplay %></span></a>
																				</li>
									   									<%}// if ends
									   									else if (firstLevelSet.getValue() instanceof HashMap) {
									   										%>
									   										<li>
																				<div class="accordion accordion-flush" id="accordionFlush_<%=menuid%>">
																					<div class="accordion-item menu-accordion-item"><h2 class="accordion-header" id="flush_headingOne_<%=menuid%>">
																					<button type="button" data-bs-toggle="collapse" data-bs-target="#flush_collapseOne_<%=menuid%>" aria-expanded="false" 
																					aria-controls="flush_collapseOne_<%=menuid%>" title='<%=menuName %>' class="accordion-button collapsed menu-accordion-button menutextusm-accordion-header">
																					<i class="fas fa-file-medical fa-fw  fa-fw fa-2x menuiconusm" aria-hidden="true"></i>&nbsp;&nbsp;<span><%=menuNameDisplay %></span>
																					</button></h2>
																					<div id="flush_collapseOne_<%=menuid%>" class="accordion-collapse menutextusm_flush_collapseOne collapse" aria-labelledby="flush_headingOne_<%=menuid%>" data-bs-parent="#accordionFlush_<%=menuid%>" >
																					<div class="accordion-body">
																						<ul class="list-unstyled">
																							<%HashMap columnMapSecondLevel=(HashMap) firstLevelSet.getValue();
																							Set<Map.Entry> columnSecondLevelSet = columnMapSecondLevel.entrySet();
																							 for (Map.Entry secondLevelSet : columnSecondLevelSet){
													   											//System.out.println("key===" + secondLevelSet.getKey().toString() + " Value==" + secondLevelSet.getValue() );
													   											
													   											 if(secondLevelSet.getValue()  instanceof String){
													   												org.json.JSONObject leafJsonsecondLevel=new org.json.JSONObject(secondLevelSet.getValue().toString());
																									String font_icon_nameSecond=leafJsonsecondLevel.getString("menuClassId")!=null && !leafJsonsecondLevel.getString("menuClassId").equals("")?leafJsonsecondLevel.getString("menuClassId"):"fas fa-file-medical";
																									String menuNameSecond=leafJsonsecondLevel.getString("menuName");
															   										String menuNameDisplaySecond=menuNameSecond.length()>ellipseAfter?menuNameSecond.substring(0,ellipseAfter)+"...":menuNameSecond; ;
															   										String menuIdSecond=leafJsonsecondLevel.getString("menuId");
															   										String url=leafJsonsecondLevel.getString("url");
															   										if(defaultMenuId!=null && !defaultMenuId.equals("") && defaultMenuId.equals(menuIdSecond)){
															   											flagDefaultMenuExist=true;															   											
																          	   						}
													   												%>
															   										<li class='non-accordion-li'>
																										<a href="#" class="menutextusm" title='<%=menuNameSecond %>' data-url='<%=url %>' data-menuId="<%=menuIdSecond%>">
																										<i class="<%=font_icon_nameSecond %> fa-fw fa-2x menuiconusm" aria-hidden="true" ></i>&nbsp;&nbsp;<span><%=menuNameDisplaySecond%></span></a>
																									</li>
															   									<%} 
													   										} %>
																							
																				
																						</ul>	
																					</div>
																					</div>
																					</div>
																				</div>
																			</li>
									   									
									   										
									   										<% 
									   									}
									   								}// for columnFirstLevelSet ends
																	
																	%>
																	</ul>
																	</div>
																	</div>
																			
															<%
															
														}// for columnHeadingSet ends 
													}
													%>
													
													</div>
													
													</div>
												</div>
											</div>
						          	     		
						          	     	<%	
						          	     
						          	     	}// for moduleSet sends
										}// if zeroLevelModules ends
										
										%>
									
									
						</div>
					</div>
				</div>	
			</li>	
			
					
			
		</ul>
	</div> <!-- navbar-collapse.// -->
</div> <!-- container-fluid.// -->
</nav>
<!-- ============= COMPONENT END// ============== -->
<div class="container-fluid tab-bg">
<div class='row'>
<div class="col-sm-11">	
 <div class='row ' id='rowTab'></div>
</div>
<div class='col-sm-1' style="padding: 0;text-align: right;">
	<a class='btn btn-refresh' id='btnRefreshFrame' style="display: none;"><i class='fas fa-arrows-rotate fa-fw'></i></a>
	<a class='btn btn-info'  id='btnframeUp' style='display:none;' ><i class='fas fa-circle-up fa-fw'></i></a>
	<a class='btn btn-info' id='btnframeDown' style='display:none;'><i class='fas fa-circle-down fa-fw'></i></a>
</div>
</div>
</div>
<div class="container-fluid" id='allIframeContainer' style="display: none;padding-left: 14px;padding-right: 23px;">
</div>
<s:form action="UserDesk"  id="UserDesk" method="POST">
  	<input type="hidden" name="varSSOTicketGrantingTicket" id='varSSOTicketGrantingTicket' value="<%=varSSOTicketGrantingTicket%>">
	<input type="hidden" name="varIsFirstTimeLogin" id="varIsFirstTimeLogin" value="<s:property value="varIsFirstTimeLogin" />">
	<input type="hidden" name="varUserName" id="varUserName" value="<s:property value="varUserName" />">
	<input type="hidden" name="userId" id="userId" value="<%=userId%>">
	<input type="hidden" name="hospitalCode" id="hospitalCode" value="<%=hospitalCode%>">
	
	<input type="hidden" name="varUsrName" id="varUsrName" value="<s:property value="varUsrName" />">
	<%defaultMenuId=flagDefaultMenuExist==false? "":defaultMenuId; %>
	<input type="hidden" name="defaultMenuId" id="defaultMenuId" value="<%=defaultMenuId%>">
	
 </s:form>

<div class="container text-center" id='isWelcomePage' >
	<h4 class='mt-2'>		
	  <span class='eshusrut-brandName eshusrut-brandName-color'>Welcome To Sushrut@Clinic</span>
			    
			    
	</h4>	
	<div class='row  mt-5'>
	<div class='col-lg-3 mt-2'>
	<div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="toast-body">
		    <i class='fas fa-globe fa-fw welcome-toast-icon'></i>
		    <div class="mt-2 pt-2 welcome-toast-text">
		      Web Based Application on <br/> open source platform
		    </div>
		  </div>
  	</div>
  	</div>
  	<div class='col-lg-3 mt-2'>
		  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
		  <div class="toast-body">
		    <i class='fas fa-arrows-to-dot fa-fw welcome-toast-icon'></i>
		    <div class="mt-2 pt-2 welcome-toast-text">
		      Integration With Aadhaar/Bhamashah Id/Aarogyasri
		    </div>
		  </div>
		  </div>
  </div>
  <div class='col-lg-3 mt-2'>
  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
  <div class="toast-body">
    <i class='fas fa-file-circle-check fa-fw welcome-toast-icon'></i>
    <div class="mt-2 pt-2 welcome-toast-text">
      Compliance with Health Level 7 Standards (HL7) and MDDS
    </div>
  </div>
  </div>
  </div>
  
  <div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-id-card fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	      Comprehensive  E.H.R <br/>(SNOMED–CT and ICD-10)
	    </div>
	  </div>
	</div>
</div>



 <div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-envelopes-bulk fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	      Integration with SMS and Email Gateway for real time alerts
	    </div>
	  </div>
	</div>
</div>

 <div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-prescription-bottle-medical fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Integration with Telemedicine through E.H.R standards
	    </div>
	  </div>
	</div>
</div>


 <div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-hospital fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Integrated with MOHF&W’s ICT-based Patient Satisfaction System
	    </div>
	  </div>
	</div>
</div>


 <div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-mobile-screen-button fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Mobile Apps for Consultants and Patients/Citizens 
	    </div>
	  </div>
	</div>
</div>

<div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-chart-pie fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Extensive Dashboards and Real time statistics for trend/pattern analysis 
	    </div>
	  </div>
	</div>
</div>


<div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-house-medical-flag fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Customized clinical data according to department and laboratory 
	    </div>
	  </div>
	</div>
</div>


<div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-users-gear fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Configurable to support varied size & flow of Hospitals
	    </div>
	  </div>
	</div>
</div>


<div class='col-lg-3 mt-2'>
	  <div class="toast toast-demo fade show" role="alert" aria-live="assertive" aria-atomic="true">
	  <div class="toast-body">
	    <i class='fas fa-file-circle-plus fa-fw welcome-toast-icon'></i>
	    <div class="mt-2 pt-2 welcome-toast-text">
	     Extensive Reporting with various format and features
	    </div>
	  </div>
	</div>
</div>



</div>
<div id="eConsultation" title="eConsultation" style="z-index:9999;"></div>	 		    
</div>
	</div><!-- container //  -->

</body>
</html>