<!DOCTYPE html>
<html lang="en">

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mobile Verification</title>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <style>
   body {
    font-family: 'Montserrat', sans-serif;
    margin: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 60vh;
    background: linear-gradient(to right, #CBC3E3, #6e3960);
}



.card {
    background-color: #fff;
    border-radius: 10px;
    overflow: hidden;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
}

.header {
    background-color: #6e3960;
    color: #fff;
    padding: 2px;
    text-align: center;
    text-font:5px;
}

.content {
    padding: 10px;
    
}

button {
    background-color: #CBC3E3;
    color: #fff;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

button:hover {
    background-color: #CBC3E3;
}

.otp-form {
    display: none;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
}

input {
    width: calc(100% - 30px);
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ddd;
    border-radius: 5px;
    outline: none;
}

.success-message {
    display: none;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
    color: #4CAF50;
}

.error-message {
    color: #e74c3c;
    margin-top: 10px;
}

button:disabled {
    background-color: #ccc;
    cursor: not-allowed;
}

.success-message p {
    margin: 10px 0;
}

.otp-display {
    margin-top: 20px;
    text-align: center;
}

.otp-text {
    font-size: 18px;
    margin: 0;
}

input:disabled {
    background-color: #f2f2f2;
    color: #a0a0a0;
    cursor: not-allowed;
}

.timer {
    margin-top: 10px;
    font-size: 14px;
    
 }
 
    .otp-form {
    display: none;
    flex-direction: column;
    align-items: center;
    margin-top: 20px;
}
    
}
    
    
    </style>
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Mobileotp.js"></script>
     <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/onlineapplyplasticcard.js"></script>
    
    <script type="text/javascript">

    $(document).ready(function () {
    	hidePreloader();
    });

    </script>
</head>


  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  

<body class='bannersection'>
<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
	   <div style="text-align: center;">
               <h3>Apply Online for Plastic Cards</h3>
                  <div class="instruction">  
				  <div class="row">
				<div class="col-md-9 ">
				<h4>New Employees/Pensioners who are not CGHS beneficiaries</h4>
				</div>
				<div class="col-md-3">
			<!-- 	<input type="button"  name="Pensioner"  id="button1" value="P" onClick="openpage()" class='btn btn-his-outline'> -->
				
				<button id="Pensioner" name="Pensioner" value="P"  class='btn btn-his-outline' data-bs-toggle="modal" data-bs-target="#myModalpensioner" onclick="openpage()">Apply Here</button>
				
				</div>
				</div>
				
				<hr>
				<div class="row">
				<div class="col-md-9">
				<h4>New Employees/Servings who are not CGHS beneficiaries</h4>
				</div>
				<div class="col-md-3">
			<!-- 	<input type="button"  name="Serving" id="button1" value="Apply here" onClick=""  class='btn btn-his-outline'> -->
					<button id="Serving" name="Serving" value="S"   data-bs-toggle="modal" data-bs-target="#myModalserving" class='btn btn-his-outline' onclick="openpage1()">Apply Here</button>
				
				</div>
				</div>	
				
				<hr>
				<div class="row">
				<div class="col-md-9">
				<h4>Existing CGHS Beneficiaries who have not applied for Plastic cards</h4>
				</div>
				<div class="col-md-3">
					<button id="" name="" value="" onClick="()" class='btn btn-his-outline'>Apply Here</button>
				</div>
				</div>			  
						  
			


			<p  class="text-primary">**"Print-out of the filled on-line form, duly verified by competent authority  along with photographs and required documents, needs to be submitted to CGHS, for issuing of Plastic Cards."**</p>
				  
			<p class="font-w6">**Note: The beneficiaries whose card type needs to be changed from serving to pensioners should not apply Online.</p>
			

	</div>
	</div>
	
	
	
	<!--  <div class="modal fade" id="myModalserving" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="max-width:40%">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="myModalLabel">Confirm Action</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                                      
        
            <!-- Main Heading -->
        <!--    <h1>All applications from serving beneficiaries</h1>
            <!-- Subheading -->
          <!--   <p class="small text-muted">Copy of ID proof of dependent family members(Passport, PAN Card, Masked Aadhar, voter ID card etc.)</p>
           <p class="small text-muted">  Passport size photograph of all dependent family members.</p>
             <p class="small text-muted"> Pay slip of serving employee showing deduction of CGHS amount</p>
            <p class="small text-muted"> Proof of Residential Address</p>
              <h1>If dependent is son or minor brother</h1>
               <p class="small text-muted"> All above and Proof of Age of Son/ brother</p>
               
               <h1 class="display-2">If dependent is son or minor brother</h1>
               <p class="small text-muted"> All above If Dependent is Disabled Son or Disabled brother</p>
       
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="confirmBtn" onClick="openpage1()" >OK</button>
                    </div>
                </div>
            </div>
        </div>
	 -->
	<!--  <div class="modal fade" id="myModalpensioner" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="max-width:40%">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="myModalLabel">Confirm Action</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                                      
            <h1 >All applications from Pensioner beneficiaries</h1>
            <!-- Subheading -->
          <!--   <p class="small text-muted">Copy of ID proof of dependent family members(Passport, PAN Card, Masked Aadhar, voter ID card etc.)</p>
           <p class="small text-muted">  Passport size photograph of all dependent family members.</p>
             <p class="small text-muted"> Self-attested PPO or Provisional PPO or Last pay certificate</p>
            <p class="small text-muted"> Copy of Bharatkosh Challan for CGHS subscription paid</p>
              <p class="small text-muted"> Proof of availing/ non availing FMA</p>
                <p class="small text-muted"> Proof of Residential address</p>
                   <p class="small text-muted"> Duly filled and signed Nomination form / Nominee declaration</p>
                 
              <h1 >If dependent is son or minor brother</h1>
               <p class="small text-muted"> All above and Proof of Age of Son/ brother</p>
               
               <h1>If dependent is son or minor brother</h1>
               <p class="small text-muted"> All above and Proof of Disability - Self-attested copy of Disability certificate issued by Medical Board of Government hospital</p>
    -->
       
                   <!--   </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="button" class="btn btn-primary" id="confirmBtn" onClick="openpage()" >OK</button>
                    </div>
                </div>
            </div>
        </div>-->
	
	
	 
     
   
	
	
	
	
<input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />
	         <input type='hidden' name="hiddenId12" id='hiddenId12' />
	      <input type='hidden' name="selectcardtype" id='selectcardtype' />

</form>
</body>

</html>
