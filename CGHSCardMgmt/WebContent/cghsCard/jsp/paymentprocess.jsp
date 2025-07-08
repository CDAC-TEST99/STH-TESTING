<%@page import="formFlowX.fb.FormFlowXCommonFB"%>

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>

<html>

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>
<script type="text/javascript"	src="/CGHSCardMgmt/cghsCard/js/paymentprocess.js"></script>
<style>
  
      .container {
            text-align: center;
        }
        .timer {
            font-size: 2em;
            margin: 20px 0;
        }
     /*    .loading {
            border: 4px solid #f3f3f3;
            border-radius: 50%;
            border-top: 20px solid #3498db;
            width: 40px;
            height: 40px;
            animation: spin 2s linear infinite;
            margin: 20px auto;
        } */
        .tick {
            font-size: 2em;
            color: green;
            display: none;
        }
        .cross {
            font-size: 2em;
            color: red;
            display: none;
        }
        @keyframes spin {
            0% { transform: rotate(0deg); }
            100% { transform: rotate(360deg); }
        }
        .statusMessage {
            margin-top: 20px;
            font-size: 3em;
            text-align: center;
        }
        
        </style>

    <%
    String trackingid=request.getParameter("hiddentrackingid");
//System.out.println("value of hiddentrackingid" + trackingid);
    %>
</head>
<body>
<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
<fieldset  class='p-5' id="ENTRYFORM">
<!-- <div id="loader">
    <img src="loader.gif" alt="Loading...">
  
</div> -->
  <div id="timeDisplay" style="text-align: center;">Elapsed Time: 0m 0s</div> <!-- Display time here -->
<!-- Status Message -->

 <div class="statusMessage" id="statusMessage">
    </div>


<div class="legend3">
    <button class='btn btn-his' id="downloadecard"  onclick="saveData()" style="display:none;"><i class='fas fa-save fa-fw' ></i>&nbsp;Download e-card</button>
<!--   <input type="button" value="Download-ecard" onclick="saveData();">
 -->  
  </div>


<input type='hidden' name="Benidvalue" id='Benidvalue' value=""  />  
 <input type="hidden" name="statusflag" id="statusflag" value="6"/>
 <input type="hidden" name="PatTrackingid" id="PatTrackingid" value="<%=trackingid%>"/>
   </fieldset> 
   
       <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	    <%String primaryKeyFromListPage= request.getParameter("primaryKey");
	       if(primaryKeyFromListPage==null){
	    	   primaryKeyFromListPage="";
	       }
	     %>
	     <input type='hidden' name="primaryKeyFromListPage" id='primaryKeyFromListPage' value="<%=primaryKeyFromListPage %>"  />  
	         
	     
 </form>
</body></html>