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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="hislogin.config.HISLoginConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page	import="hissso.validation.credentails.authorization.AuthorizationCredentials"%>
<%@page import="java.util.*"%>
<%@page import="hisglobal.utility.HisUtil"%>
<%@page import="hisglobal.utility.Entry"%>
<%@page import="vo.usermgmt.UserMasterVO"%>
<%@page import="application.filters.Base64Utils"%>




<%
	UserMasterVO userVO = (UserMasterVO) request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);
	String key = (String) session.getAttribute(HISSSOServerConfig.LOGIN_TAB_KEY);
	
	String userId="";
	AuthorizationCredentials objAuthorize = (AuthorizationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHORIZATION_OBJECT);
	AuthenticationCredentials objAuthenticate = (AuthenticationCredentials) session.getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
	String varSSOTicketGrantingTicket=  (String) request.getAttribute("varSSOTicketGrantingTicket");
	Map zeroLevelModules=null;
	int ellipseAfter=25;
	int ellipseAfterForSecondLevelMenu=20;
	if(objAuthorize!=null && objAuthorize.getMenusHirarchyMap()!=null){
		 userId=objAuthenticate.getVoUser().getVarUserId();
		  zeroLevelModules = objAuthorize.getMenusHirarchyMap();
	}
	JSONObject objContent =(JSONObject)request.getSession().getAttribute("content");
	
	if(objContent==null){
		objContent= new JSONObject();
		objContent.put("clientId", "0");
		objContent.put("sushrutlogo", "<span class='eshusrut-brandName eshusrut-brandName-color1'>Sushrut</span>" + 
				"<span class='eshusrut-brandName eshusrut-brandName-color2'><i class='fas fa-hand-holding-medical fa-fw'></i></span>" + 
				"<span class='eshusrut-brandName eshusrut-brandName-color3'>Clinic</span>"+
				"<span class='eshusrut-brandName eshusrut-brandName-color2'> | </i></span>" 
				);
		objContent.put("clientName", "");
		objContent.put("clientShortName", "");
		objContent.put("themeFileName", "cdac_preset1.css");
		objContent.put("clientLogoImage", "/HIS/hisglobal/images/e-clinic/eclinic-icons.png");
		
	}
	String clientShort=session.getAttribute("CLIENT_SHORT_NAME").toString();
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
	
	<link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
	<link href="/HIS/hisglobal/cdac_awesome/css/<%=objContent.getString("themeFileName") %>" rel="stylesheet" >
	
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"  ></script>
	<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
	<script src="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/5571ef2661.js" ></script>
	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.easing.min.js"  ></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/ssoLogin.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>

<style type="text/css">
.deskbackground{
	background-color: #eee !important;
	font-family: -apple-system,BlinkMacSystemFont,segoe ui,Roboto,helvetica neue,Arial,noto sans,sans-serif,apple color emoji,segoe ui emoji,segoe ui symbol,noto color emoji !important;
	
}
.menuIcon{
width:100%;font-size:27px;border-radius: 50%;border: 1px solid #8080806b;padding: 7px;background: #F7EDEE;
}
.menutab{
font-size: 12px;
color:#133B57;
letter-spacing: 2px;

}
.deskmenu{
	font-size: 15px;
	color:#133B57;	
	font-family: 'Roboto-Regular';
}
.deskmenu:hover{
	font-weight: bold;
}
.cardbg{
	background: transparent;
	min-height: 54vh;
	border:none;
}

#moduleLink{position: fixed;z-index: 1000;width: 100%;top: 57px;margin-left: -12px;padding: 6px;}

#moduleLink .link{
	color: #133B57;
	text-decoration: none;
	font-size: 13px;	
}
#moduleLink .linkactive{
	background: #133B57 !important;
	color: #fff  !important;
}
.submenu{
	text-align: right;background: silver;
}
.btnmenu{ 
  background: white;
  background-color: white;
  border: grey;  
  border-radius: 20px; 
  padding: 15px;
  text-decoration: none;
  text-align: left;
  cursor: pointer;
  box-shadow: rgba(99, 99, 99, 0.2) 0px 2px 8px 0px;
}
.btnmenu:hover{ 
  background: #FCFFB2; 
}
.submenuBack{
	background: #133B57 !important;
	border: #133B57 !important;
	margin-bottom: 10px;
}
/* For Tablet View */
@media screen and (min-device-width: 768px)
and (max-device-width: 1024px) {
 .btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}

/* For Mobile Portrait View */
@media screen and (max-device-width: 480px)
and (orientation: portrait){
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}
/* For Mobile Landscape View */
@media screen and (max-device-width: 640px)
and (orientation: landscape) {
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}
/* For Mobile Phones Portrait or Landscape View */
@media screen and (max-device-width: 640px) {
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}
/* For iPhone 4 Portrait or Landscape View */
@media screen and (min-device-width: 320px)
and (-webkit-min-device-pixel-ratio: 2) {
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}
/* For iPhone 5 Portrait or Landscape View */
@media (device-height: 568px) and (device-width: 320px)
and (-webkit-min-device-pixel-ratio: 2) {
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}
/* For iPhone 6 and 6 plus Portrait or Landscape View */
@media (min-device-height: 667px) and (min-device-width: 375px)
and (-webkit-min-device-pixel-ratio: 3) {
	.btnmenu{
	  border: grey;  
	  border-radius: 20px; 
	  padding: 15px;
	  text-decoration: none;
	  text-align: center;
	  min-height: 120px;
	}

}


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


html{
scroll-behavior: smooth;
}
</style>

<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function(){
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

		 $('.link').click(function(){
		    	$('.link').removeClass('linkactive');
		    	$(this).addClass('linkactive');
		 });
		 showRecentMenus();
		$('[id^=parent_]').click(function(){
			
			var key=this.id.split('_')[1];
			if($('#submenu_'+key).length>0){
				$('#submenu_'+key).show();
				$(this).closest('.parent').hide();
			}
			
		});	
		$('[id^=menu_]').click(openLeafMenu);	

		
		$('.submenuBack').click(function(){
			$(this).closest('.submenu').hide();
			$('.parent').show();
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
			$("[data-menuId="+$('#defaultMenuId').val()+"]").each(openLeafMenu);
		
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
	function setRecentMenuList(menuName, url, menuId) {
		  var strRecent = localStorage.getItem("arrRecent");
		  var arrRecent = strRecent ? JSON.parse(strRecent) : [];

		  var json = { "menuName": menuName, "url": url, "menuId": menuId };

		  for (var i = 0; i < arrRecent.length; i++) {
		    var jobj = arrRecent[i];
		    if (jobj["menuName"] == menuName)
		      return;
		  }

		  if (arrRecent.length === 3) {
		    arrRecent.pop();
		  }

		  arrRecent.unshift(json);
		  localStorage.setItem("arrRecent", JSON.stringify(arrRecent));
		  showRecentMenus();
		}
	function showRecentMenus(){
		var strRecent = localStorage.getItem("arrRecent");
		  var arrRecent = strRecent ? JSON.parse(strRecent) : [];

		  if (!arrRecent || arrRecent.length === 0) {
		    $('.recent').hide();
		    $('#pills-Registration').css({ "padding-top": "95px" });
		    return;
		  }

		  $('#pills-Registration').css({ "padding-top": "5px" });
		  $('.recent').show();
		  $('.recentMenus').empty();
	//	alert(arrRecent.length);
		for(var i=0;i<arrRecent.length;i++){
			var jobj=arrRecent[i];
			var html="<div class='col-lg-4 col-sm-4 col-lg-4  col-md-4    mb-1'  title='"+jobj["menuName"]+"' data-url='"+jobj["url"]+"' data-menuId='"+jobj["menuId"]+"'   id='recentmenu_"+jobj["menuId"]+"'>";
			html+="<div  class='btnmenu'>";
			html+="<div class='row'>";
			html+="<div class='col-12 col-xl-2'>";
			html+="<span class='eshusrut-brandName-color2 menuIcon' style='width:100%;font-size:26px;'>";
			html+="<i class='fas fa-file-medical-alt fa-fw'></i></span>";
			html+="</div>";
			html+="<div class='col-12 col-xl-10 mt-2'>";
			html+="<span style='width:100%' class='deskmenu'>"+jobj["menuName"]+"</span>";
			html+="</div>"; 
			html+="</div>";
			html+="</div>";
			html+="</div>";
			$('.recentMenus').append(html);
		}
	}
	
	function openLeafMenu(){
		var menuName=$(this).attr("title");
		var url=$(this).attr("data-url");
		var menuId=$(this).attr("data-menuId");
		setRecentMenuList(menuName,url,menuId)


		
		return;
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
	    var newiframehtml= "<div class='ifcontainer'  style='height: 81vh;' id='divForIframe_"+key+"'>"
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
		  var clientId='<%=objContent.get("clientId")%>'
		  if(clientId=="0"){
		  	submitForm1("logoutLogin");
		  }
		  else{	
			  submitForm1("logoutClientSignIn");
		  }

		}


	 function formDataTampered(menuId){
		//alert("menuId>>"+menuId)
		 $('#divForIframe_'+menuId).html("<b>Form Data Tampered</b>")		 
		 		 
		 }

		
	 function submitForm1(actionURL)
	 {
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
	 
</script>

</head>
<body class='deskbackground'>

<!-- Preloader Start -->
    <div id="preloader">
	  <div id="loader"></div>	  
	</div>
    <!-- Preloader Ends -->
<div class="container-fluid" style="padding: 0;">
<!-- ============= COMPONENT ============== -->
 <nav class="navbar navbar-expand-lg navbar-light sticky-top bg-white w-100">
<div class="container-fluid">
	<a class="navbar-brand" href="/AHIMSG5/hissso/Login">
    	<div class="d-flex flex-row">
    		<div ><img src='<%=objContent.getString("clientLogoImage") %>' class='eshusrut-logo'></div>
    		<div style="width:100%" class='mt-2' >
    			<% if(objContent.has("sushrutlogo")) {%>
    			<%=objContent.getString("sushrutlogo") %>			    			
    			<%} %>
			    <span class='eshusrut-brandName eshusrut-brandName-color4 '> <%=objContent.getString("clientName") %></span>				
			   
			    <% if(session.getAttribute("CLIENT_NAME") != null ){ %>
    
    &nbsp; <span class='eshusrut-brandName eshusrut-brandName-color2 '> <%= clientShort%></span>
         <% if(session.getAttribute("HOSPITAL_NAME") != null &&  session.getAttribute("HOSPITAL_CODE") != null  &&  !session.getAttribute("CLIENT_CODE").toString().equals(session.getAttribute("HOSPITAL_CODE").toString()) ){ %>
    
   &nbsp; <span class='eshusrut-brandName eshusrut-brandName-color4 '>|</span> &nbsp; <span class='eshusrut-brandName eshusrut-brandName-color4 '> <%=session.getAttribute("HOSPITAL_NAME").toString() %></span>	 
   
    <% } %>
        
    <% } %>
			   		 
	
			   		    
    		</div>
		</div>
    </a>
    	
</div> <!-- container-fluid.// -->
</nav> 
<!-- ============= COMPONENT END// ============== -->
<div class="container mt-3">
<%
String defaultMenuId= userVO.getVarMenuId();
boolean flagDefaultMenuExist=false;
if(zeroLevelModules!=null){
	Set<Map.Entry> moduleSet = zeroLevelModules.entrySet();	
	
      	     	%>

<div  class="row mt-3" >
	<%int i=0;
	  	for (Map.Entry set : moduleSet ) {
	  		
	  		//System.out.println("Key===" +set.getKey());
	  		String[] arrModData=set.getKey().toString().split("#");
	  		String moduleName=arrModData[0];
	  		
	  		String moduleNameWithoutSpace=moduleName.trim().replaceAll("\\s+", ""); 
	  		//System.out.println("moduleNameWithoutSpace===" +moduleNameWithoutSpace);
	  		String moduleImageName=(1 >= 0 && 1 < arrModData.length)?arrModData[1]:"/HIS/hisglobal/images/e-clinic/module_img/defaultHealthImage.png";
	  		String moduleDescription=(2 >= 0 && 2 < arrModData.length)?arrModData[2]:"" ;
	%>
	 
  
  

	 
	 
	 	 <div class='col-4 col-lg-2 mt-4' title='<%=moduleName %>'  id='module_<%= moduleNameWithoutSpace%>'>
	  		<a   href="#pills-<%= moduleNameWithoutSpace%>"  >
	  			 <div  class="row ">
	  			 <div  class="col-12 text-center"> 
	  			  <span style="width:100%;border: 1px solid #e9ecef;  border-radius: 9px;  background: #fff;  padding: 23px;box-shadow: 0 .46875rem 2.1875rem rgba(4,9,20,.03),0 .9375rem 1.40625rem rgba(4,9,20,.03),0 .25rem .53125rem rgba(4,9,20,.05),0 .125rem .1875rem rgba(4,9,20,.03);">
	  					<img style='width: 40px; height: 40px;' src='<%= moduleImageName%>' />
	  			  </span>
	  			  </div>
	  			  <div  class="col-12 mt-3 text-center">
	  			  	<%=moduleName %>
	  			  </div>		
	  			</div>
	  		 </a>
	  	</div>  
	  		
	  		
	  
	  
	 <% }// for ends
	  	} // if ends%>   
	</div>
 </div> 
 
 
  

</body>
</html>