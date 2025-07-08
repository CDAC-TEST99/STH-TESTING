<!DOCTYPE html>
<html lang="en">


<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Government Sub Department Master </title>
    
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <style>
    
    </style>
       
 <script type="text/javascript" src="/CGHSCardMgmt/masters/js/govtSubServiceDeptMst.js"></script>

</head>


  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  

<body class='bannersection'>
      
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
		
				
         <div class="row "> 
         <div class="field"  style="text-align:right;" >
			<button class='btn btn-his-sm  btn-sm ' id="BTNSAVE"  ><i class='fas fa-save fa-fw'></i>&nbsp;Save</button>
			<button class='btn btn-his-sm  btn-sm ' id="BTNCANCEL"  ><i class='fa-solid fa-circle-xmark fa-fw'></i>&nbsp;Cancel</button>
			<button class='btn btn-his-sm  btn-sm ' id="BTNCLEAR"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear</button>			
		</div> 
		</div>
		         <div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-12" style="padding-left: 50px;">
            <div class="form-group">
                <label class="col-form-label col-form-label-sm" for="govtDeptName">Govt. Department Name:</label>
                <select class="form-control form-control-sm select2" id="govtDeptName" name="govtDeptName" data-validation="mandatory">
                    <option value="">Select Govt. Department Name</option>
                </select>
                <div class="invalid-feedback"></div>
            </div>
        </div>
    </div>
    
    <div class="row justify-content-center">
        <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-12" style="padding-left: 50px;">
            <div class="form-group">
                <label class="col-form-label col-form-label-sm" for="subDeptName">Sub Department Name:</label>
                <input class="form-control form-control-sm" type="text" id="subDeptName" name="subDeptName" placeholder="Enter Sub Department Name" maxlength="50" data-validation="mandatory,alphabetOnly">
                <div class="invalid-feedback"></div>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-12" style="padding-left: 50px;">
            <div class="form-group">
                <label class="col-form-label col-form-label-sm" for="orgType">Organization Type:</label>
                <select class="form-control form-control-sm select2" id="orgType" name="orgType" data-validation="mandatory">
                    <option value="">Select Organization Type</option>
                </select>
                <div class="invalid-feedback"></div>
            </div>
        </div>
    </div>

    <div class="row justify-content-center">
        <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-12" style="padding-left: 50px;">
            <div class="form-group">
                <label class="col-form-label col-form-label-sm" for="isAutonomous">Is Autonomous:</label>
                <select class="form-control form-control-sm select1" id="isAutonomous" name="isAutonomous" data-validation="mandatory">
                    <option value="">Select Is Autonomous</option>
                    <option value="1">Yes</option>
                    <option value="2">No</option>
                </select>
                <div class="invalid-feedback"></div>
            </div>
        </div>
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
