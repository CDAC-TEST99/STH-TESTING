<!DOCTYPE html>
<html lang="en">

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CGHS-Form Type selection</title>
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">

   
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/GenerateBenid.js"></script>
 <style>
    .custom-file-upload {
      border: 1px solid #ced4da;
      display: inline-block;
      padding: 6px 12px;
      cursor: pointer;
      border-radius: 4px;
      background-color: #fff;
      width: 100%;
      text-align: center;
    }
    .preview-img {
      max-width: 50%;
      height: auto;
      display: none;
      border: 1px solid #ced4da;
      margin-top: 10px;
      padding: 5px;
    }
    .btn-custom {
      margin-top: 10px;
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

</head>
 <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  
 
<body>

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" >

	       
  <fieldset  id="ENTRYFORM">      
  <div class="table-responsive">
   <h2 style="text-align: center; margin: 20px 0;">Main Cardholder Details</h2>
 <div id="noDependentLabel" style="display:none; text-align:right; color:red;"></div>

 <table class="table table-bordered table-striped" id="maincardholderdetail">
    <thead>
        <tr>
         <th>Sr. No.</th>
            <th>BenId</th>
            <th>Name of Family Member</th>
            <th>Date of Birth</th>
            <th>Relationship</th>
            <th>Gender</th>
            <th>Photo</th>
             <th>View Document</th>
            
             
            
        </tr>
    </thead>
    <tbody>
       
    </tbody>
</table>
</div>

<div class="table-responsive">
   <h2 style="text-align: center; margin: 20px 0;">Dependent Details</h2>
 <div id="noDependentLabel" style="display:none; text-align:right; color:red;"></div>

 <table class="table table-bordered table-striped" id="Dependentdetails">
    <thead>
        <tr>
         <th>Sr. No.</th>
         <th>Name of Family Member</th>
            <th>Date of Birth</th>
            <th>Relationship</th>
            <th>Gender</th>
            <th>Photo</th>
             <th>View Id Proof</th>
            <th>Action</th>
             
            
        </tr>
    </thead>
    <tbody>
       
    </tbody>
</table>
</div>
    <div class="table-responsive p-4" id="Deptable" style="display:none;" >
   <div class="row">
  <div class="col-lg-12 text-right">
    <div> <button class='btn btn-his'  id="BTNSAVEFINISH2" onclick="addRowToTable()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;ADD Dependent</button></div>
  </div>
  </div>
  <table class="table table-bordered table-striped"  >
  <h5> Dependent Information</h5>
  <thead>
    <tr>
    <th>Sr. No.</th>
      <th>Name</th>
      <th>DOB</th>
        <th>Gender</th>
          <th>Relation</th>
            <th>Photo</th>
              <th>View Document</th>
	        <th>Action</th>
	        <th>Action</th>
    </tr>
	</thead>
	<tbody>
   
	</tbody>
	
   </table>
   </div>
    
    
     <div class="container-fluid" style="display: none;" id="newadddependentinfo">
      <h3 class='mt-4'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepname">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="Newdepname" name="Newdepname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
	          
	           <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NewdepDob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepDob' name='NewdepDob' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		  	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdeptrelation">Relation :</label>
		              <select class="form-control form-control-sm" id="Newdeptrelation" name="Newdeptrelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		     
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdepgender">Gender :</label>
		              <select class="form-control form-control-sm" id="Newdepgender" name="Newdepgender" data-validation="mandatory">
		                		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		      <!-- Blood Group Dropdown -->
			  <div class="col-lg-3" style="display: none;" >
			    <div class="form-group">
			      <label class="col-form-label col-form-label-md" for="depBloodGroup">Blood Group:</label>
			      <select class="form-control form-control-sm" id="depBloodGroup" name="depBloodGroup" data-validation="mandatory">
			        <option value="">Select</option>
			        <option value="A+">A+</option>
			        <option value="B+">B+</option>
			      </select>
			      <div class="invalid-feedback"></div>
			    </div>
			  </div>

    <div class="col-lg-4">
        <div class="form-group">
          <label class="col-form-label col-form-label-md" for="depcardvalidto">Card Valid upto:</label>
		  <input type="text" class="form-control form-control-sm"  id='depcardvalidto' name='depcardvalidto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
          <div class="invalid-feedback"></div>
        </div>
      </div>
  
    	
		   <div class="col-lg-4">
	            <div class="form-group">
	              <div class="mt-3">
	    		    <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload dependent's photo</button>
	    			</div>
	    			 <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 3 MB.</div>
	    		</div>
    		</div>
    		<div class="col-lg-2">
        	    <div class="form-group">
        	      	<img id="preview2" src="#" alt="Preview2" style="display:none;width:70px"/>
         			<div class="overlay" id="overlay" onclick="hidePopup()"></div>
					<br>
					<input type='hidden' id='fileContent2' />
            		<div class="invalid-feedback"></div>
            	</div>
            </div>
		  
		  
		   <div class="col-sm-3"  id="fileuploaddepidproof">
		           
							<input type="hidden" name="depidproof"
								id="filename20" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Dependent ID Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile20" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="20" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon20" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload20"
									onclick="uploadDoc(20,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
		  
  <div class="col-lg-3"  id="fileuploadspousecertificate" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="Jointdeclartionproof"
								id="filename14" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Joint Declaration: <span class="star text-danger">
									*</span>
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
									data-validation="mandatory">

							</div>

							<div id="divFaIcon14" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload14"
									onclick="uploadDoc(14,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
		   
		    <div class="col-sm-3"  id="fileuploadageproof"  style="display:none;">
		           
							<input type="hidden" name="fileuploadageproof"
								id="filename22" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="ID Proof">Dependent Age Proof<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile22" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="20" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon22" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload20"
									onclick="uploadDoc(22,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
		  
		  <div class="col-lg-3">
			    <div class="form-group mt-3" id="disablecheck" style="display:none">
			      <div class="form-check form-switch">
			        <input class="form-check-input" type="checkbox" id="customCheckdisable" onclick="uploaddisabledocument()">
			        <label class="form-check-label" for="customCheckdisable" style="color: Blue; font-size: 20px;">Is Disable?</label>
			      </div>
			    </div>
        		<div class="invalid-feedback"></div>
          </div>
          <div class="col-lg-3"  id="fileuploaddisablecertificate" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="Disabilitycertificate"
								id="filename11" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Disability Certificate">Disability Certificate: <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile11" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="11" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon11" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload11"
									onclick="uploadDoc(11,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
  	</div> 	
		        
    <div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNADDDEP" onclick="adddepinfo()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Add Details</button>
      </div>
    </div>
    
    
  <!-- <div class="container-fluid" style="display: none;" id="newadddependentinfo">
      <h3 class='mt-4'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepname">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="Newdepname" name="Newdepname" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
		  	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdeptrelation">Relation :</label>
		              <select class="form-control form-control-sm" id="Newdeptrelation" name="Newdeptrelation" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		      <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NewdepDob">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepDOB' name='NewdepDOB' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="newdepgender">Gender :</label>
		              <select class="form-control form-control-sm" id="Newdepgender" name="Newdepgender" data-validation="mandatory">
		                <option value="">Select Gender</option>
		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		      Blood Group Dropdown
			  <div class="col-lg-3" style="display: none;" >
			    <div class="form-group">
			      <label class="col-form-label col-form-label-md" for="NewdepBloodGroup">Blood Group:</label>
			      <select class="form-control form-control-sm" id="NewdepBloodGroup" name="NewdepBloodGroup" data-validation="mandatory">
			        <option value="">Select</option>
			        <option value="A+">A+</option>
			        <option value="B+">B+</option>
			      </select>
			      <div class="invalid-feedback"></div>
			    </div>
			  </div>

  
  
    	
		   <div class="col-lg-4">
	            <div class="form-group">
	              <div class="mt-3">
	    		    <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload dependent's photo</button>
	    			</div>
	    			 <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of 3 MB.</div>
	    		</div>
    		</div>
    		<div class="col-lg-2">
        	    <div class="form-group">
        	      	<img id="preview2" src="#" alt="Preview2" style="display:none;width:70px"/>
         			<div class="overlay" id="overlay" onclick="hidePopup()"></div>
					<br>
					<input type='hidden' id='fileContent2' />
            		<div class="invalid-feedback"></div>
            	</div>
            </div>
		  
		  <div class="col-lg-3">
			    <div class="form-group mt-3">
			      <div class="form-check form-switch">
			        <input class="form-check-input" type="checkbox" id="customCheckdisable" onclick="uploaddisabledocument()">
			        <label class="form-check-label" for="customCheckdisable" style="color: Blue; font-size: 20px;">Is Disable?</label>
			      </div>
			    </div>
        		<div class="invalid-feedback"></div>
          </div>
        <div class="col-lg-3"  id="fileupload" style="display:none">
		            <div class="form-group">
		              	<input type="hidden" name="installationCertiFicateDoc"
								id="filename11" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="installationCertiFicate"
								data-langtag="Satisfactory Installation Certificate(SIC)">Disability Certificate : <span class="star text-danger">
									*</span>
							</label>


							<div id="displayFile11" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="11" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 35%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon11" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload11"
									onclick="uploadDoc(11,'CARDDOCUMENT','0');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>



		                <div class="invalid-feedback"></div>
		            </div>
		   </div>
  	</div> 	
		         -->
  
    
     <div class="col-lg-12 text-right">
   			<button class='btn btn-his'  id="BTNSAVEDEP" onclick="savedepinfo()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Save Dependent</button>
      </div>
    </div>

    <br>
   <!-- <div class="row">
	 <div class="col-lg-12 text-center">
   			<button class='btn btn-his'  id="BTNPRINTCARD" onclick="PrintIndexcard()" ><i class='fa-solid fa-broom fa-fw'></i>&nbsp;Print IndexCard</button>
      </div>
    </div> -->
    
 <div class="popup" id="popup">
	<table style='width:100%'>
	<tr>
	<td>
        <div class="option" onclick="uploadPhoto()">
            <img src="/CGHSCardMgmt/global/images/upload-icon.png" alt="Upload Icon"><br>
             Upload Photo 
        </div>
	</td>	
	 <td>Or</td>
	<td>
        <div class="option" onclick="capturePhoto()">
            <img src="/CGHSCardMgmt/global/images/capture-icon.png" alt="Capture Icon"><br>
             Capture Photo 
        </div>
		</td>
		</tr>
		</table>
		
		
	 <input type="file" accept="image/*" id="fileInput" capture="camera" style="display:none;">
	  <video id="video" width="320" height="240" autoplay style="display:none;"></video>
    <button id="capture" style="display:none;" onclick='captureActualPhoto(event);'>Capture</button>
    <canvas id="canvas" width="320" height="240" style="display:none;"></canvas>
		
		
    </div>
    
    <div class="modal fade" id="mymodalprintindexcard" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h2 class="modal-title" id="myModalLabel"></h2>
                        <button type="button" class="btn btn-primary" onclick="saveData()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Save</button>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
        
<p align="center"><b><font size="2">&#2360;&#2370;&#2330;&#2325;&#0032;&#2325;&#2366;&#2352;&#2381;&#2337;/INDEX CARD<br>&#2349;&#2366;&#2352;&#2340;&#0032;&#2360;&#2352;&#2325;&#2366;&#2352;/GOVERNMENT OF INDIA<br>&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2319;&#2357;&#2306; &#0032;&#2346;&#2352;&#2367;&#2357;&#2366;&#2352;&#0032;&#2325;&#2354;&#2381;&#2351;&#2366;&#2339;&#0032;&#2350;&#2306;&#2340;&#2381;&#2352;&#2366;&#2354;&#2351;/MINISTRY OF HEALTH AND FAMILY WELFARE<br> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#2325;&#2375;&#2344;&#2381;&#2342;&#2381;&#2352;&#2368;&#2351; &#0032;&#2360;&#2352;&#2325;&#2366;&#2352;&#0032;&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2351;&#2379;&#2332;&#2345;&#2366;/CENTRAL GOVERNMENT HEALTH SCHEME</font><font size="2" color="#FF0000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</b><a href="#" onClick="return print()">Print</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="javascript:history.go(-1)">Back</a></p>
<div class="table-responsive">
    <table border="0" width="100%">
        <tr>
            <td width="57" align="center"><b><font size="2">1.</font></b></td>
            <td width="239"><font size="2"></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">2.</font></b></td>
            <td width="515">
                <b>
                    <font size="2">
                       &#2360;&#2352;&#2325;&#2366;&#2352;&#2368; &#0032;&#2325;&#2352;&#2381;&#2350;&#2330;&#2366;&#2352;&#2368; &#0032;&#2325;&#2366;&#0032;&#2344;&#2366;&#2350;
                        /Name of The Govt Employee
                    </font>
                </b>
            </td>
            <td width="239"><font size="2"> <span id="govEmployeeName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">3.</font></b></td>
            <td width="515">
                <b><font size="2">&#2310;&#2357;&#2366;&#2360;&#2368;&#2351;&#0032;&#2346;&#2340;&#2366;Residential Address</font></b>
            </td>
            <td width="239"><font size="2"><span id="residentialAddress"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">4.</font></b></td>
            <td width="515">
                <b><font size="2">CGHS Wellness Centre:</font></b></td>
            <td width="239"><font size="2"><span id="wellnesscenterName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">5.</font></b></td>
            <td width="515">
                <b><font size="2">Issue Date / Valid Upto:</font></b></td>
            <td width="239"><font size="2">&nbsp;/&nbsp;<span id="issueDate"></span></font>&nbsp;</td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">6.</font></b></td>
            <td width="515">
                <b><font size="2">Entitlement:</font></b></td>
            <td width="239"><font size="2"><span id="entitlement"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">7.</font></b></td>
            <td width="515">
                <b><font size="2">Department Name:</font></b></td>
            <td width="239"><font size="2"><span id="departmentName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">8.</font></b></td>
            <td width="515">
                <b><font size="2"><span id="familyMemberDetails">Family Member Details</span>:</font></b></td>
            <td width="239">&nbsp;</td>
        </tr>
    </table>
</div>

	<br>
 <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber1">
  <thead>
    <tr>
      <th>S.No</b></th>
       <th>BenId</th>
      <th>Name of Family Member</th>
       <th>Date of Birth</th>
       <th>Relationship</th>
        <th>Gender</th>
          <th>Photo</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
	<p align="justify" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b></p>

<p align="left" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. &#2351;&#2361; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368;
&#2346;&#2381;&#2354;&#2366;&#2360;&#2381;&#2335;&#2367;&#2325; &#0032;&#2325;&#2366;&#2352;&#2381;&#2337;&#0032;&#2332;&#2366;&#2352;&#2368; &#0032;&#2361;&#2379;&#2344;&#2375; &#0032;&#2340;&#2325;&#0032;&#2357;&#2376;&#2343;&#0032;&#2352;&#2361;&#2375;&#2327;&#2368; &#0032;&#2340;&#2341;&#2366; &#0032;&#2325;&#2375;.&#2360;.&#2360;&#2381;&#2357;&#2366;&#2351;&#2379; &#0032;&#2325;&#2375;&#0032;&#2344;&#2366;&#2350;&#2367;&#2325;&#2366;&#2327;&#2340;&nbsp; &#2344;&#2367;&#2332;&#2368; &#0032;&#2309;&#2360;&#2381;&#2346;&#2340;&#2366;&#2354;&#2379;&#2306; &#0032;&#2350;&#2375;&#2306;&#0032;&#2313;&#2346;&#2330;&#2366;&#2352;&#0032;&#2361;&#2375;&#2340;&#2369; &#0032;&#2349;&#2368;&#0032;&#2357;&#2376;&#2343;&#0032;&#2361;&#2379;&#2327;&#2368; &#0032;|<br>/This Slip is valid till issue of Plastic Card&nbsp;and valid for treatment in CGHS empanelled private hospitals also.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.&#2346;&#2335;&#2354;&#0032;&#2331;&#2379;&#2337;&#2364;&#2344;&#2375; &#0032;&#2360;&#2375;&#0032;&#2346;&#2370;&#2352;&#2381;&#2357;&#0032;&#2325;&#2371;&#2346;&#2351;&#2366; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368 &#0032;&#2350;&#2375;&#2306;&#0032;&#2342;&#2368;&#0032;&#2327;&#2312;&#0032;&#2360;&#2350;&#2360;&#2381;&#2340;&#0032;&#2332;&#2366;&#2344;&#2325;&#2366;&#2352;&#2368; &#0032;&#2325;&#2368;&#0032;&#2332;&#2366;&#2305;&#2330;&#0032;&#2325;&#2352;&#0032;&#2354;&#2375;&#2306;&#0032;|/Please Check the data before leaving the counter.</b></p>

<br>
</div>
 </div>
</div>
</div>
  
  <input type="hidden" name="mainchgenderhidden" id="mainchgenderhidden" value=""/>
    <input type="hidden" name="isdisablityvaluehidden" id="isdisablityvaluehidden" value=""/>
  <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  
    <input type='hidden' name="cardnovalue" id='cardnovalue' value="<%=request.getParameter("cardnovalue")%>"  />  
  <input type='hidden' name="primaryKeyFromDelingoffline" id='primaryKeyFromDelingoffline' value="<%=request.getParameter("primaryKeyFromDelingoffline")%>"  />  
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