<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
c
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
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/PaymentVerify.js"></script>
  <script type="text/javascript">

   
    </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
 <div class="container-fluid">
<div class="row" id='divTrackingIdEntry' style="display: none;">
    <!-- Column for Tracking ID input -->
    <div class="col-lg-6">
        <div class="form-group">
            <label class="col-form-label col-form-label-md" for="PatTrackingid">Tracking Id :</label>
            <input type="text" class="form-control form-control-sm" id="PatTrackingid" name="PatTrackingid" 
                placeholder="Enter Tracking ID" data-validation="mandatory,numeric" maxlength="15" >
            <div class="invalid-feedback"></div>
       </div>
    </div>
    
</div>

	<h5 class="fw-bold text-primary " id="PatTrackingidLbl"></h5>
	
</div>

 
     <div style="margin-left: -20px; display:none;" id="paymentdetailsBeneficiary">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Verify Payment Details</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
        <th style="width: 7%">Sr. No.</th>
        <th style="width: 7%">Acknowledgement No.</th>
        <th style="width: 7%">FirstName</th>
       <!--  <th style="width: 7%">Card Category</th>
        <th style="width: 7%">Ministry</th>
        <th style="width: 7%">Pay Scale</th>
        <th style="width: 7%">Card Validity Applied</th>
        <th style="width: 7%">Card validity</th>
        <th style="width: 7%">CPC</th>
        <th style="width: 7%">Amount</th>
        <th style="width: 7%">AD City</th> -->
        <th style="width: 7%" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
</div>




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
                    
  

    <input type='hidden' name="Benidvalue" id='Benidvalue' value=""  />  
	             <input type='hidden' name="cardnovalue" id='cardnovalue' value=""  /> 
  <input type='hidden' name="cardvalidtohidden" id='cardvalidtohidden' value=""  /> 
   <input type="hidden" name="statusflag" id=statusflag value=""/>
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
</body>
</html>