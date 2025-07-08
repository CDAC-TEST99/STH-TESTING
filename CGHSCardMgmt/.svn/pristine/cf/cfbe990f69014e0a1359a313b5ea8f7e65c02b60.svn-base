<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
  <title>seach by Trackingid</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
   <style>
        .highlight {
            background-color: yellow; /* Change this to your preferred highlight color */
        }
    </style>
  <style>
     .preview-img {
      max-width: 20%;
      height: auto;
      display: none;
      border: 1px solid #ced4da;
      margin-top: 10px;
      padding: 5px;
    }
    .btn-custom {
      margin-top: 10px;
    }
    
      .highlight {
            background-color: yellow; /* Highlight color */
        }
      .popup {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            border: 1px solid #ccc;
            background-color: #fff;
            padding: 20px;
            z-index: 1000;
			width:30%;
        }
        .popup .option {
            margin-bottom: 10px;
			cursor: pointer;
			margin-left: 25px;
			text-align:center;
        }
        .popup .option img {
            width: 60px;
			height: 60px;
			margin-left: 15px;
        }
        .overlay {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 500;
        }
		
		.option:hover {background-color: gray;}
  </style>
<head>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/cardrenwalview.js"></script>
  <script type="text/javascript">

   
    </script>
   
    
<meta charset="ISO-8859-1">
<title>Card Renewal View</title>
</head>


<%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  
<body>

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
<fieldset  class='p-5' id="ENTRYFORM">

    <div style="margin-left: -20px;display:none;" id="getrenewalstatus">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Renewal Status</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
        <th style="width: 10%">Sr. No.</th>
        <th style="width: 15%">Acknowledgement No.</th>
        <th style="width: 15%">FirstName</th>
        <th style="width: 10%">ApplyDate</th>
        <th style="width: 10%">CardType</th>
        <th style="width: 10%">Sub CardType</th>
        <th style="width: 10%">Mobile No.</th>
        <th style="width: 15%">Status</th>
          <th style="width: 15%">Remarks</th>
                <th style="width: 10%" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
  <div style="text-align: left;">
  <h6>
    If you believe you are eligible as per CGHS rules, please review your details and re-apply with correct and complete information.
  </h6>
  <p>
    For more details on eligibility under CGHS, kindly refer to the FAQs section on the CGHS website.
  </p>
</div>

</div>

    <input type="hidden" id="renewalhidden" name="renewalhidden" value="${param.renewalhidden}" />
    
    
    
    <div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="max-width:100%">
                <div class="modal-content">
                    <div class="modal-header">
                     
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                               				        	
<div class="container mr-t10 mr-b20">
	<div class="text-right">
<!-- 	 <button type="button" class="btn btn-primary" onclick="window.print()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Print</button>

 -->	
                         <button type="button" class="btn btn-primary" onclick="printFormContainer()" id="SAVEPREVIEW" data-bs-dismiss="modal">Print</button>
 
 </div>
                    <div id="formContainer" class='text-dark'></div>
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>	
  
 </fieldset>
     <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
</form>
</body>
</html>