<%@page import="formFlowX.fb.FormFlowXCommonFB"%>

  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>

<html>

<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
<head>

<script type="text/javascript"
	src="/CGHSCardMgmt/cghsCard/js/linkpanwithbenid.js"></script>

<style type="text/css">
</style>


  
</head>
<body>

	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION"
		method="post">

		<fieldset id="ENTRYFORM">

	
			<br />
			<br />


			

				<div class="row  rowborder bg-white p-2 text-dark bg-opacity-10 "
					style="padding-top: 5px;">
					<div class='col-lg-12 bordertext'>
						<h4 class='text-primary' style="text-align: center;">Link PAN With Ben Id</h4>
						
					</div>
					</div>
				<!-- 	<div class="row">
    <div class="col-md-3">
        <div class="form-group d-flex align-items-center">
            <label class="col-form-label col-form-label-md mr-4" for="Benid">Ben Id :</label>
            <input type="text" class="form-control form-control-sm mr-3" id="Benid" name="Benid" 
                placeholder="Enter BenId ID" data-validation="mandatory,numeric" maxlength="15">
            <input type="button" value="Go" onclick="getfamilydetails()" class="btn btn-primary">
        </div>
        <div class="invalid-feedback"></div>
    </div>
</div>
 -->
<div class="row">
    <div class="col-md-3">
        <div class="form-group d-flex align-items-center">
            <label class="col-form-label col-form-label-md mr-3 mb-0" for="Benid" style="white-space: nowrap;"> Ben Id :</label>
            <input type="text" class="form-control form-control-sm mr-3" id="Benid" name="Benid" 
                placeholder="Enter BenId ID" data-validation="mandatory,numeric" maxlength="15">
            <input type="button" value="Go" onclick="getfamilydetails()" class="btn btn-primary">
        </div>
        <div class="invalid-feedback"></div>
    </div>
</div>

 
					
					<div class="row" id=linkwithpan style="display:none;">
					
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patName">
									Name :</label> <input type="text" class="form-control form-control-sm"
									id='patName' name='patName' placeholder="Enter Name"
									data-validation="mandatory" maxlength="100">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patDOB">Date
									Of Birth :</label> <input type="text"
									class="form-control form-control-sm datepickerdob" id='patDOB'
									name='patDOB' placeholder="dd-Mon-yyyy"
									data-validation="mandatory" maxlength="11" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>
						<div class='col-lg-3'>
							<div class="form-group">
								<label class="col-form-label col-form-label-md" for="patcardtype">Cardtype:</label> <input type="text"
									class="form-control form-control-sm" id='patcardtype'
									name='patcardtype' 
									data-validation="mandatory" readonly="readonly">
								<div class="invalid-feedback"></div>
							</div>
						</div>

	   
						
					
					
						<div class='col-lg-3'>
							<div class="form-group ">
								<label class="col-form-label col-form-label-md" for=stateCode">PAN Number
									:</label> <input type="text"
									class="form-control form-control-sm form-control"
									id='patPanno' name='patPanno' placeholder="Enter PAN Number"
									data-validation="mandatory" maxlength="10" onblur="validatepancheck()">
								<div class="invalid-feedback"></div>
								<div id="error-message" class="error"></div>
							</div>
						</div> 
		
						
						 <div class="legend3">
				<button class='btn btn-his-outline ' id="BTNVerify" onclick="saveData1()"  ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Link PAN</button>
				</div>
				</div>
			
			<input type="hidden" name="hiddenpan" id="hiddenpan" value="" /> 
			<input type="hidden" name="masterKey" id="masterKey" /> <input
				type='hidden' name="hmode" id="hmode" /> <input type='hidden'
				name="tid" id='tid' /> <input type='hidden' name="initMode"
				id='initMode' /> <input type='hidden' name="primaryKeys"
				id='primaryKeys' />
				<input
						type='hidden' name="fileUploadFlag" id='fileUploadFlag' />
						<input
						type='hidden' name="cardtypevaluehidden" id='cardtypevaluehidden' value="" />
						<input
						type='hidden' name="hiddenId12" id='hiddenId12' value="" />
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
			<input type="hidden" name="panNumber" id="panNumber"/>

		</fieldset>





	</form>
</body>
</html>
