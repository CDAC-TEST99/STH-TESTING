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
   
   
    .checkbox-row {
     .radio-row {
      display: flex;
      align-items: center;
    }
    
    
  input[type="radio"] {
    transform: scale(1.5); /* Adjust the scale factor to increase the size */
    margin-right: 10px; /* Optional: Add some space to the right of the radio button */
  }

    .radio-row label {
      margin-right: 100px; /* Adjust this value to control the space between radio buttons */
      font-size: medium;
}
    
        .highlight {
            background-color: yellow; /* Change this to your preferred highlight color */
        }
    </style>
  
<head>
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Beneficiarycardtransferfromda.js"></script>
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
 <h5>Card Transfer Request Details</h5> 
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
 	</div> -->
 	
 	
 	
    
</div>
</div>
 <div class="table-responsive" id="AutoNumber1" style="display:none;">
 <h4>Card Transfer Request Details</h4>
  <table class="table table-bordered table-striped" >
  <thead>
    <tr>
     <th style="width:5%"><b>S.No</b></th>
       <th style="width:10%">BenId</th>
      <th style="width:10%">Name</th>
       <th style="width:10%">Date of Birth</th>
       <th style="width:10%">Relationship</th>
        <th style="width:5%">Gender</th>
        <th style="width:10%">Wellness Center</th>
        <th style="width:10%">Card Type</th>
         <th style="width:10%">Card ValidUpto</th>
        <th style="width:10%">AD City</th>
          <th>Photo</th>
              <th>Action</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
   
   <div class="row" style="display:none;" id="choosecity">
    <div class="radio-row" style="font-size: 18px;">
    <label>
      <input type="radio" name="choice" id="radio1" onclick="transferincity();"> With In City
    </label>
    <label>
      <input type="radio" name="choice" id="radio2" onclick="transferoutsidecity();"> Outside City
    </label>
  </div>
   
   </div>
   <div class="row" id="cardtransfer" style="display:none;">
       <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="PatientCghsCityto">CGHS Covered City</label>
          <select class="form-control form-control-sm select2" id="PatientCghsCityto" name="PatientCghsCityto" data-validation="mandatory">
            <option value="">Select City</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      	</div>
      	     <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patadcity">Concerned AD's Office</label>
          <input type="text" class="form-control form-control-sm" id="patadcity" name="patadcity" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
      	     <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patientwc">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="patientwc" name="patientwc" data-validation="">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      	</div>
      	
      	
		          
		            <div class="col-sm-3"  id="Fileupload3" >
		           
							<input type="hidden" name="transferslip"
								id="filename13" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Residential Address Proof">Upload application for transfer and transfer order forwarded by office/ Application (in case of pensioners) <span class="star text-danger">
									</span>
							</label>

							<div id="displayFile13" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="13" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="">

							</div>

							<div id="divFaIcon13" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload13"
									onclick="uploadDoc(13,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>

		          </div>
		          
		           <div class="col-sm-3"  id="Fileupload3" >
		           
							<input type="hidden" name="joiningorder"
								id="filename14" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Upload Reliving Letter">Upload joining order and address proof/ Only address proof (in case of pensioners).<span class="star text-danger">
									</span>
							</label>

							<div id="displayFile14" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="14" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="">

							</div>

							<div id="divFaIcon14" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload14"
									onclick="uploadDoc(14,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>

		          </div>
		          
		         
      	<div class="legend3">
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="cardtransfersubmit()"><i class='fas fa-save fa-fw'></i>&nbsp;Submit</button>			
		</div> 
      	
      	
   </div>
   
     <div class="row" id="cardtransferincity" style="display:none;">
		                     <div class="col-sm-3">
    <div class="form-group">
          <label class="col-form-label col-form-label-md" for="Patientadcitypresent">Concerned AD's Office</label>
          <input type="text" class="form-control form-control-sm" id="Patientadcitypresent" name="Patientadcitypresent" data-validation="mandatory" readonly="readonly" maxlength="" placeholder="">
          <div class="invalid-feedback"></div>
        </div>
        </div>
	   <div class="col-sm-3">
         <div class="form-group">
          <label class="col-form-label col-form-label-md" for="patientwcintracity">Wellness Center</label>
          <select class="form-control form-control-sm select1" id="patientwcintracity" name="patientwcintracity" data-validation="">
            <option value="">Select Wellness Center</option>
          </select>
          <div class="invalid-feedback"></div>
        </div>
      	</div>
      	
      	      <div class="col-sm-3"  id="Fileupload3" >
		           
							<input type="hidden" name="Addressproof"
								id="filename16" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Upload Address Proof">Upload Application Address Proof(Forwarded by Office)<span class="star text-danger">
									</span>
							</label>

							<div id="displayFile16" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="16" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="">

							</div>

							<div id="divFaIcon16" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload16"
									onclick="uploadDoc(16,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg, .png, Files are allowed upto 200 KB)</span>

		          </div>
		          
      	        
      	<div class="legend3">
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="cardtransfersubmit()"><i class='fas fa-save fa-fw'></i>&nbsp;Submit</button>			
		</div> 
      	
		           </div>
<!-- <div >
<button class='btn btn-his' id="BTNAPPROVE" onclick="DownloadExcel()"><i class='fas fa-save fa-fw' ></i>&nbsp;Download Data in Excel</button>
</div> -->


 <input type="hidden" name="BenId" id="BenId" />
<%--    <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  
 --%>      <input type='hidden' name="Patientadcitycodepresent" id='Patientadcitycodepresent' value=""  />  
         <input type='hidden' name="Benidhidden" id='Benidhidden' value=""  />  
             <input type='hidden' name="parentcitytocodehidden" id='parentcitytocodehidden' value=""  />
                          <input type='hidden' name="cardtranferflag" id='cardtranferflag' value=""  />  
                                       <input type='hidden' name="currentwccode" id='currentwccode' value=""  />
                            <input type='hidden' name="applybyda" id='applybyda' value="1"  />
               
         

</fieldset>

            <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	    <%String primaryKeyFromListPage=(String) request.getSession().getAttribute("SEATID");
	       if(primaryKeyFromListPage==null){
	    	   primaryKeyFromListPage="";
	       }	     	
	     %>
	     <input type='hidden' name="primaryKeyFromListPage" id='primaryKeyFromListPage' value="<%=primaryKeyFromListPage %>"  />  
</form>

