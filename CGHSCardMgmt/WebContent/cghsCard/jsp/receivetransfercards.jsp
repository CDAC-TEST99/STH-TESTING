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
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/receivetransfercards.js"></script>
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

 <!--     <div style="margin-left: -20px;" id="getcardtransferdetails">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Online Applied Plastic Card Status</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
       <th style="width: 5%">Sr. No.</th>
        <th style="width: 15%">BenId</th>
        <th style="width: 15%">City From</th>
        <th style="width: 10%">City To</th>
        <th style="width: 10%">Wellness Center</th>
        <th style="width: 10%">View Document</th>
        <th style="width: 10%">Status</th>
        <th style="width: 10%">Action</th>
      </tr>
    </thead>
    <tbody>
      Data rows go here
    </tbody>
  </table>
  
    	        
      	<div class="legend3">
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="cardrequestforward()"><i class='fas fa-save fa-fw'></i>&nbsp;Submit</button>			
		</div> 
</div>

 -->

		<div class="row" id=transferdetails">
					   <h3>Card Received</h3>
					   	<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="transferferslno">
									Transfer Sl_no :</label> <input type="text" class="form-control form-control-sm"
									id='transferferslno' name='transferferslno' 
									data-validation="mandatory" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="BenId">
									Ben Id :</label> <input type="text" class="form-control form-control-sm"
									id='patBenid' name='patBenid' 
									data-validation="mandatory">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="CityFrom">City From :
									</label> <input type="text" class="form-control form-control-sm"
									id='CityFrom' name='CityFrom' 
									data-validation="mandatory">
								<div class="invalid-feedback"></div>
							</div>
						</div>
							<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="CityTo">City To :
									</label> <input type="text" class="form-control form-control-sm"
									id='CityTo' name='CityTo' 
									data-validation="mandatory">
								<div class="invalid-feedback"></div>
							</div>
						</div>
					
	      <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patWC">Wellness Center :</label>
              <select class="form-control form-control-sm" id="patWC" name="patWC" data-validation="mandatory">
                <option value="">Select Wellness Center</option>
                      </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
	      <div class="col-lg-3">
            <div class="form-group">
              <label class="col-form-label col-form-label-md" for="patapplicationstatus">Status</label>
              <select class="form-control form-control-sm" id="patapplicationstatus" name="patapplicationstatus" data-validation="mandatory">
                <option value="">Select Status</option>
                    <option value="1">Accept</option>
                        <option value="2">Reject</option>
                      </select>
              <div class="invalid-feedback"></div>
            </div>
          </div>
             <div class="col-lg-3" id="remarksbox" style="display:none">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Rejectremarks">Enter Remarks :</label>
		              <input type="textarea" class="form-control form-control-sm" id="Rejectremarks" name="Rejectremarks" placeholder="Enter Remarks" data-validation="mandatory,alphabetOnly" maxlength="100">
		              <div class="invalid-feedback"></div>
		            </div>
		          </div> 
	   
						
					
				<div class="legend3">
				<button class='btn btn-his-outline ' id="BTNVerify" onclick="CardReceivedsubmit()"><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Submit</button>
				</div>
					
					
					
		
				</div>
				
					
     <div class="container-fluid p-4" id="Uploaddocumentview">
   <h2> View Uploaded Documents</h2>
		    
		          <div class="col-lg-3" id="transferorder" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NomName">Transfer Order:</label>
		             <div id="imagetest"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		         		          
		           <div class="col-lg-3" id="joiningorder" style="display:none;">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="PPO">joining Letter:</label>
		             <div id="imagetest2"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		             		          
		           <div class="col-lg-3" id="addressproof" style="display:none;" >
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="PPO">Address Proof:</label>
		             <div id="imagetest3"></div>
		              <div class="invalid-feedback"></div>
		            </div>
		          </div>
		       
		         </div>
				<input type="hidden" name="statushiddenflag" id="statushiddenflag" value=""/>
								<input type="hidden" name="citytocodehidden" id="citytocodehidden" value=""/>
				
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