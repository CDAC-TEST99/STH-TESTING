<!DOCTYPE html>
<html lang="en">


<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<head>
    <title>Registration Priority SetUp Master </title>

   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
   
       
 <script type="text/javascript" src="/CGHSCardMgmt/masters/js/regPrioritySetupMst.js"></script>

<style>
th, td {
  border-style:groove;
  border-color: #96D4D4;
  
}
</style>

</head>




  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  

<body>
      
	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" class="bannersection">
		<header class="header-area header-wrapper bg-light">
            <div>
                <div class=" full-width-mega-dropdown">
                <div class="row align-items-center">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11" style="padding-left: 25px;"> 
                    	<a href="/AHIMSG5/hissso/Login">
                            <div class="logo"><img src="/HIS/hisglobal/images/cghs_logo_big.png" class='img-fluid'> </div>
                        </a> 
                    </div>
                </div>
            </div>
            
    </div>
 </header>



		<fieldset  id="ENTRYFORM">	
		<h1 style="text-align: center; margin: 20px 0;">Registration Priority Set Up  </h1>
				
         <div class="row "> 
         <div class="field"  style="text-align:right;" >
			<button class='btn btn-his-sm  btn-sm ' id="BTNSAVE"  ><i class='fas fa-save fa-fw'></i>&nbsp;Save</button>
			<button class='btn btn-his-sm  btn-sm ' id="BTNCANCEL"  ><i class='fa-solid fa-circle-xmark fa-fw'></i>&nbsp;Cancel</button>
			<button class='btn btn-his-sm  btn-sm ' id="BTNCLEAR"  onclick="clearvaluesperinfo()1" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>		
		</div> 
		</div>
		        <div class="row">
        
        <div class="col-sm-6">
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for="hospital">City :</label> 
								<select class="form-control form-control-sm select2"
									id='cityId' name="city">
									<option value="">Select City</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>
											
						
<div class="col-sm-6">
        <div class="form-group">
        							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for="hospital">Hospital :</label> 
								<select class="form-control form-control-sm select2" id='hospitalId' name="hospital">
									<option value="">Select Hospital</option>
								</select>
								<div class="invalid-feedback"></div>
							</div>
						</div>   

   </div>
   </div>


<div class="container-fluid mt-4">
                              <div class="table-responsive">
                    <table id="regPrioritySetup" class="table table-bordered"  style="width:100%">
                        <thead>
                            <tr>
								 <th style="text-align: center">Priority Type</th>
                                 <th style="text-align: center">Priority Symbol</th>
                                 <th style="text-align: center">Priority Order</th>
                                 <th style="text-align: center">Priority Ratio</th> 
                                <th style="text-align: center">Configuration Value</th>
                                <th style="text-align: center">Remarks</th>
                               
                            </tr>
                            
                            <tr>
   						 <td style="text-align: center">EMG</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						<td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4" required>
   						   <input type="text" id="" name="" maxlength="4" size="4"></td>
						<td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10" style="text-align: center;"></td>
   						    
  </tr>
  
   <tr>
   						 <td style="text-align: center"> SERVICE</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
               
               <tr>
   						 <td style="text-align: center"> CRITICAL_DISEASE </td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
  
  <tr>
   						 <td style="text-align: center"> PREGNANT</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
  
  <tr>
   						 <td style="text-align: center"> AGE</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
  
  <tr>
   						 <td style="text-align: center"> AGE SENIOR 70+ </td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
  
  <tr>
   						 <td style="text-align: center"> ONLINE_APP</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
  
  
  <tr>
   						 <td style="text-align: center"> AGE 60+</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
                <tr>
   						 <td style="text-align: center"> FEMALE</td>
    					<td style="text-align: center">   <input type="text" id="" name="" maxlength="4" size="4"></td>
   						 <td style="text-align: center"> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						  <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4"></td>
   						   <td style="text-align: center"><input type="text" id="" name="" maxlength="4" size="4" required> <input type="text" id="" name="" maxlength="4" size="4"></td>
   						    <td style="text-align: center"> <input type="text" id="" name="" maxlength="10" size="10"></td>
  </tr>
                            
                        </thead>
                        <tbody>
                          
                        </tbody>
                    </table>
                </div>
            </div>



		<input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />
	   
	   
	   </fieldset>
	    




  </form>
</body>
</html>
