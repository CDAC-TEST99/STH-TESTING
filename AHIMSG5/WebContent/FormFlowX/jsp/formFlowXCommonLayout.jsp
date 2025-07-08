<!DOCTYPE html>


<%@page import="hisglobal.FormFlowX.util.TokenConfig"%>
<%@page import="hisglobal.FormFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  
    <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%String globalVersion="?version=2.0"; %>
  

  <!-- Font Awesome -->
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
  
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/bootstap/css/bootstrap.min.css">
  
  
  <!-- DataTables -->
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-bs4/css/dataTables.bootstrap4.min.css">
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/css/buttons.dataTables.min.css"> 
  
  
   
  <link rel="stylesheet" type="text/css" href="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatable-searchHighlight/dataTables.searchHighlight.css">
    
   <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.css">
 
   
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/select2/css/select2.min.css">

  
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/css/FormFlowXPreset1.css">
  <link href="/HIS/hisglobal/FormFlowX/css/animate.min.css" rel="stylesheet" >
  
  
  
  
  <%String isGlobal=request.getParameter("isGlobal"); 
 	if(isGlobal==null)
 		isGlobal="0";
 	%>
  
<!-- jQuery -->
<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/external/jquery/jquery.js"></script>

<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.js"></script>
  
<!-- Bootstrap 4 -->
<script src="/HIS/hisglobal/FormFlowX/plugins/bootstap/js/bootstrap.bundle.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/moment/moment.min.js"></script>


<!-- Select2 App -->
<script src="/HIS/hisglobal/FormFlowX/plugins/select2/js/select2.min.js"></script>
  
<!-- DataTables -->
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables/jquery.dataTables.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/dataTables.buttons.min.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/css/buttons.html5.min.js"></script>
	
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.flash.min.js"></script> 
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatable-searchHighlight/jquery.highlight.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatable-searchHighlight/dataTables.searchHighlight.min.js"></script>
	
	
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/jszip.min.js"></script>	
	 <script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.html5.min.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.print.min.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.colVis.min.js"></script>
	
	 <script src="/HIS/hisglobal/FormFlowX/plugins/pdfmake/pdfmake.min.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/plugins/pdfmake/vfs_fonts.js"></script>
	<script src="/HIS/hisglobal/FormFlowX/js/html2pdf.bundle.min.js"></script>
	
	
  <script src="/HIS/hisglobal/FormFlowX/js/JSZip.js"></script>
  <script src="/HIS/hisglobal/FormFlowX/js/Kendo.js"></script>
  
  
 <script src="/HIS/hisglobal/FormFlowX/js/commonFunctions.js<%=globalVersion%>"></script>
<%--   <script src="/HIS/hisglobal/FormFlowX/js/security.js<%=globalVersion%>"></script> --%>
  <script src="/HIS/hisglobal/FormFlowX/js/listPage.js<%=globalVersion%>"></script>
    
    
   
 
    
<script>
  var logo="";
  
  $(document).ready(function () {
	 	
	  var vticket=$('#vticket').val();
		$('form').append("<input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket'/>");
		$('#varSSOTicketGrantingTicket').val(vticket);
		//alert($('#varSSOTicketGrantingTicket').val()); 
	$( "button" )
		.click(function( event ) {
		event.preventDefault();
	});
	$( "input[type=button], button" )
		.click(function( event ) {
		event.preventDefault();
	});

	/*  $(window).keydown(function (event) {
        if(event.keyCode == 13) {
            event.preventDefault();
            return false;
        }
    });  */
	 $('input[type="text"]').attr('autocomplete', 'off');

	 $('input[type="text"],textarea').blur(function(){
		 var flag=checkHTMLTags(this);
		 
		
		 if(flag==false){
			  showValidationMsg(this, "Not a valid input !",flag);		  
			  return false;
		}
		else{
			  showValidationMsg(this, "",flag);
		}
	 });
	
	 $('.select2').select2({width: '100%'});	 
	 hidePreloader();
  });



  
</script>
<style type="text/css">

/*New Dialog Alert CSS Starts*/	   	 
.alerteUpkaran {
    min-width:40% !important;
    min-height:100px;
    border:1px solid #666;
    background-color:#fff;
    background-repeat:no-repeat;
    background-position:20px 30px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
}
.alerteUpkaranTitlebar{
	background:#003065 !important;
	color:#fff;
}

#dialog-message h1{
    margin:0;
    font:bold 0.9em;
    border-bottom:1px solid #000;
    padding:5px 0 5px 5px;
}
.okBtn {
	display:block;
    position:relative;
    margin:5px auto;
    border:0 none;
    width:70px;
    text-align:center;
    background:#669E4F;  /* fallback for old browsers */
	  background: -webkit-linear-gradient(to bottom, #336E1B, #669E4F);  /* Chrome 10-25, Safari 5.1-6 */
	  background: linear-gradient(to bottom, #336E1B, #669E4F); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	  
	  border: 1px solid #669E4F;
	  color:#fff !important;
    border-radius: 3px;
    text-decoration:none;
    
    padding: 0.25rem 0.5rem;
	font-size: 0.800rem;
	line-height: 1.5;
	border-radius: 0.2rem;
	letter-spacing: 1px;
}

</style>
</head>
<!-- Preloader Start -->
    <div id="preloader">
    	<p id='msgpreloader' class='rounded alert alert-info fw-bold text-danger border  border-info'>Loading Please Wait..</p>	
	  <div id="loader"></div>	  
	</div>
	<div class="alert alert-success fw-bold" role="alert" id='alertMsg' style="display: none;"></div>
	
    <!-- Preloader Ends -->
<div aria-hidden="true"  id="divForModal"  aria-labelledby="myLargeModalLabel" role="dialog" tabindex="-1" class="modal fade" style="display: none;">
      <div class="modal-dialog modal-lg" style="width: 97%;">
          <div class="modal-content">
              <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">X</span></button>
                  <h4 class="modal-title"></h4>                  
              </div>
              <div class="modal-body">
                 <iframe  style='border:none' id='iframeForModal' src="" width="100%"></iframe>
              </div>
          </div>
      </div>
 </div>
 
 
 
 <div id="dialog-message" title="Status Messaage"></div>  
 <%
   	FormFlowXUserVO objuser =(FormFlowXUserVO) request.getSession().getAttribute("OBJUSER");
   %>   
 <input type="hidden" name="isGlobal" id='isGlobal' value="<%=isGlobal%>"/>
 <input type="hidden" name="theme" id='theme' value="preset1.css"/>
 <%-- <input type="hidden" name="tollfreeNo" id='tollfreeNo' value="<%=Usefulmethods.getQuery("config.Configuration","tolfreeNo" )%>"/> --%>
 
 <input type="hidden" name="gblpk" id='gblpk' />
  <%String processName=(String)request.getAttribute("masterKey"); %>
	<input type='hidden' name='tid' id='tid' value="<%=TokenConfig.GenerateSecureRandomNumber(request,processName)%>" >	
	<input type='hidden' name='afhttf'  id='afhttf' value="" > 
    <input type='hidden' id='vticket' name='vticket' value='<%= (String) request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>'/> 
    
   <input type='hidden' name='seatId'  id='seatId' value="<%=objuser.getSeatId() %>" >
	<input type='hidden' name='hospitalCode'  id='hospitalCode' value="<%=objuser.getHospitalCode() %>" >	
 
 