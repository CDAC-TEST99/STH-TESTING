<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <!-- Font Awesome -->
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">  
  <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.css">
  <link href="/HIS/hisglobal/cdac_awesome/css/animate.min.css" rel="stylesheet" >
  <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
  <link href="/HIS/hisglobal/images/logo.ico" rel="icon"  type="image/x-icon">
  
  
  
  
<!-- jQuery -->
<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/external/jquery/jquery.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/jquery-ui-1.13.2.custom/jquery-ui.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/js/wow.min.js"  ></script>
<script src="/HIS/hisglobal/FormFlowX/js/jquery.easing.min.js"  ></script>
  
<!-- Bootstrap 4 -->
<script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script>
  
 <script src="/HIS/hisglobal/FormFlowX/js/security.js"></script> 
 <script src="/CGHSCardMgmt/global/js/md5.js"></script>
 <script src="/HIS/hisglobal/FormFlowX/js/commonFunctions.js"></script>
<script type="text/javascript">

$(document).ready(function () {
	$('#btnshowDisplayBoard').click(showDisplayBoard);
});
function showDisplayBoard(){
	if($('[name="deptUnitCode"]:checked').length==0){
		alert("Please select Speciality/General OPD Name ");
		return
	}	
	var arr= new Array();
	
	$('[name="deptUnitCode"]:checked').each(function(){

		var key=$(this).attr('id').split("_")[1];	
		//alert(key);
		var objDept= JSON.parse($('#deptjson_'+key).text());
		arr.push(objDept);
	});
	//alert(JSON.stringify(arr));
	var str= encrypt(JSON.stringify(arr));
	var url="/HISDRDESK_MC/new_opd/transaction/OPDDisplayBoard.cnt?strKeys="+str;
	openFullScreenPopup(url);
}


function openFullScreenPopup(url) {
    // Open the URL in a new window
    const popup = window.open(url, '_blank', 'fullscreen=yes');

    // Check if the popup was blocked
    if (!popup || popup.closed || typeof popup.closed === 'undefined') {
        alert('Popup was blocked by the browser. Please allow popups for this site.');
    } else {
        // Attempt to make the window full screen (may not work in all browsers)
        if (popup.document.documentElement.requestFullscreen) {
            popup.document.documentElement.requestFullscreen();
        } else if (popup.document.documentElement.mozRequestFullScreen) { // Firefox
            popup.document.documentElement.mozRequestFullScreen();
        } else if (popup.document.documentElement.webkitRequestFullscreen) { // Chrome, Safari, Opera
            popup.document.documentElement.webkitRequestFullscreen();
        } else if (popup.document.documentElement.msRequestFullscreen) { // IE/Edge
            popup.document.documentElement.msRequestFullscreen();
        }
    }
}
</script>
    
    

</head>
<body>
<form>
<div class="container-fluid " id='ENTRYFORM'>
			<div class="card p-2"  style="box-shadow: rgba(0, 0, 0, 0.19) 0px 10px 20px, rgba(0, 0, 0, 0.23) 0px 6px 6px;">
			  <div class="card-body">
			  	<div class='row'>
			  		<div class='col-lg-12 bordertext text-center' >
			  			<h3 class="text-primary">Welcome to the OPD Queue Management System</h3>
			  			<h5 class="text-dark">Please Select Speciality/General OPD Name Below to continue</h5>			  			
			  		</div>
			  	</div>
			  	<div class='row' >
			  		
			  	 <%
			  		String strdeptJson= (String)request.getSession().getAttribute("deptJsonArr");
			  	 %>
			  	 <%-- <span ><%=strdeptJson %></span> --%>
			  	 <%	if(strdeptJson!=null && !strdeptJson.equals("")){
                    JSONArray arr=new  JSONArray(strdeptJson);
                   	
                   	if(arr!=null && arr.length()>0)
                   	{
                   	for(int i=0;i<arr.length();i++){
                   		JSONObject objJson=arr.getJSONObject(i);
                   	 
                   		String deptUnitCode= objJson.getString("departmentunitcode");
            		 	String DeptName=objJson.getString("DepartmentName")+ "(" + objJson.getString("UnitName")+ ")" ;
            		 	String unitStatusCode= objJson.getString("unitStatusCode");
            		 	String unitStatus= objJson.getString("unitStatus");
            		 	String className="";
            		 	if(unitStatusCode.equals("1"))
            		 		className="text-success";
            		 	else if(unitStatusCode.equals("2"))
            		 		className="text-warning";
            		 	else  if(unitStatusCode.equals("3"))
            		 		className="text-danger";
            		 %>
                      	<div class='col-lg-4 	 bordertext p-3' >
	                      	<div class="form-check form-switch">
							  <input class="form-check-input" type="checkbox" style="width: 4em; height: 2em;" name="deptUnitCode" id="deptUnitCode_<%=deptUnitCode %>" value="<%=deptUnitCode%>"> &nbsp;
							  <label class="form-check-label" style="font-size: 15px;margin-top: 3px;" for="deptUnitCode_<%=deptUnitCode %>"><%=DeptName %><p class="<%=className %>" style="font-size: 15px;margin-top: 3px;margin-left: 24px;">Status : <%=unitStatus %></p></label>
							  
							  
							  <span style="display: none;" id='deptjson_<%=deptUnitCode %>'><%=objJson.toString() %></span>
							</div>
						</div>
                      	
                     <%
            		 	}	
                     }}
                     %>
			  	
			  	
			  	</div>
			  		
			</div>
			<div class="card-footer p-3">
   			 <div class='row' >
			  		<div class='col-lg-12 bordertext text-center' >
			  			<a class="btn-his" id='btnshowDisplayBoard'>Show Display-board</a>
			  		</div>
			  	</div>
  			</div>
			</div>
</div>	
					  	
</form>
</body>
</html>