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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.3/xlsx.full.min.js"></script>

    <script src="script.js"></script>
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
   <style>
        .highlight {
            background-color: yellow; /* Change this to your preferred highlight color */
        }
        
        .self-row {
    background-color: #f0f8ff;  /* Light blue background */
    font-weight: bold;  /* Optional: Make text bold */
}
        
    </style>
  
<head>
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Undeletecards.js"></script>
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
<div class="row" id='divBenID'>
    <!-- Column for Tracking ID input -->
   <!--      <div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patGender">Action
									:</label> <select class="form-control form-control-sm" id='pataction'
									name="pataction" data-validation="mandatory">
									<option value="">Select Action</option>
									<option value="1">Delete</option>
									<option value="2">Undelete</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div> -->
    
    <div class="col-sm-2">
        <div class="form-group">
            <label class="col-form-label col-form-label-md" for="patBenId">Main CardHolder BenId :</label>
            <input type="text" class="form-control form-control-sm" id="patBenId" name="patBenId" 
                placeholder="Enter BenID" data-validation="mandatory,numeric" maxlength="15" >
            <div class="invalid-feedback"></div>
       </div>
    </div>
     <div class="col-lg-6 mt-4" >
        <div class="form-group">            
         <button class='btn btn-his ' id="BTNNEXT"  onclick="getfamilydetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Search</button>	
            <div class="invalid-feedback"></div>
        </div>
 	</div>
<h7 style="text-align: center; color: red;">Note:- If you delete the main cardholder, then all dependents will be automatically  deleted.</h7>
 	
 	
    
</div>
</div>
 <div class="table-responsive" id="AutoNumber1" style="display:none;">
 
 <h2>Family Details</h2>
  <table class="table table-bordered table-striped" >
  <thead>
    <tr>
     <th style="width:5%"><b>S.No</b></th>
       <th style="width:5%%">BenId</th>
      <th style="width:10%">Name</th>
       <th style="width:10%">Date of Birth</th>
       <th style="width:5%">Relationship</th>
        <th style="width:5%">Gender</th>
        <th style="width:10%">Wellness Center</th>
        <th style="width:5%">Card Type</th>
         <th style="width:10%">Card Validity</th>
          <th style="width:10%">Card Status</th>
                <th style="width:10%">Remarks</th>
          <th style="width:10%">Deleted Date</th>
           <th style="width:10%">Deleted By</th>
            <th style="width:10%">Photo</th>
              <th>Action</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
<!-- <div >
<button class='btn btn-his' id="BTNAPPROVE" onclick="DownloadExcel()"><i class='fas fa-save fa-fw' ></i>&nbsp;Download Data in Excel</button>
</div> -->


 <input type="hidden" name="BenId" id="BenId" />
   <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  
 
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

