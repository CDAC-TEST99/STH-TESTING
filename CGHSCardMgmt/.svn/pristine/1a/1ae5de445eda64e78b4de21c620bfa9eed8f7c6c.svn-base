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
    </style>
    
  <style>
/* Overlay background (semi-transparent) */


    .checkbox-group input[type="checkbox"],
    .checkbox-group label {
        display: inline; /* Ensure checkbox and label appear on the same line */
        vertical-align: middle; /* Align vertically */
    }

    .checkbox-group input[type="checkbox"] {
        margin-right: 10px; /* Adds space between the checkbox and the text */
    }

#dialogOverlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5); /* Black background with opacity */
  display: none; /* Hidden by default */
  z-index: 1000; /* Ensure the overlay is above other elements */
  justify-content: center;
  align-items: center;
  display: flex; /* Use flexbox to center the dialog */
}

/* Dialog box styling */
#dialogBox {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  width: 514px;
  text-align: center;
}

/* Question text styling */
#dialogBox p {
  font-size: 16px;
  margin-bottom: 20px;
}

 .button-container {
    display: flex; /* Use flexbox to align buttons horizontally */
    gap: 10px; /* Optional: Add space between buttons */
    justify-content: center; /* Center the buttons horizontally */
    margin-top: 20px; /* Optional: Add some space above the buttons */
  }

  /* Styling for buttons */
  .button {
    padding: 10px 20px; /* Adjust padding to make buttons bigger */
    font-size: 16px; /* Adjust font size */
    cursor: pointer; /* Change cursor to pointer for better UX */
    border: none; /* Remove default button border */
    border-radius: 5px; /* Optional: Rounded corners for buttons */
  }

  /* Yes button style */
  .yes-button {
    background-color: #4CAF50; /* Green background for Yes */
    color: white;
  }

  /* No button style */
  .no-button {
    background-color: #f44336; /* Red background for No */
    color: white;
  }

  /* Hover effects for the buttons */
  .yes-button:hover {
    background-color: #45a049;
  }

  .no-button:hover {
    background-color: #e53935;
  }

        .error {
            color: red;
        }
  
   /*  .checkbox-group {
            margin-bottom: 15px;
        }
        .checkbox-group input {
            margin-right: 10px;
        }
        .checkbox-group label {
            font-size: 14px;
        }
        */
        .error {
            color: red;
            font-size: 14px;
        }
   .content {
            line-height: 1.6;
        }
        .content ul {
            
            margin-left: 20px;
        }
        .content li {
            margin-bottom: 10px;
        }
        .signature {
            margin-top: 30px;
            text-align: right;
        }
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
  

<head>
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/dependentmodify.js"></script>
  <script type="text/javascript">

   
    </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#editFormContainer {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    padding: 20px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    width: 400px;
    z-index: 999;
}

#editFormContainer form {
    display: flex;
    flex-direction: column;
}

#editFormContainer form input,
#editFormContainer form button {
    margin: 10px 0;
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
 	
 	
    
</div>
</div>
 <div class="table-responsive" id="AutoNumber1" style="display:none;">
 
 <h2>Family Details</h2>
           
<div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="AddDependent()"><i class='fas fa-save fa-fw' ></i>&nbsp;ADD Dependent</button>
</div> 
  <table class="table table-bordered table-striped" >
  <thead>
    <tr>
     <th style="width:5%"><b>S.No</b></th>
       <th style="width:10%">BenId</th>
       <th style="width:10%">CardNo</th>
      <th style="width:10%">Name</th>
       <th style="width:10%">Date of Birth</th>
       <th style="width:10%">Relationship</th>
        <th style="width:5%">Gender</th>
    <!--     <th style="width:10%">Wellness Center</th>-->
        <th style="width:10%">Card Type</th>
         <th style="width:10%">Card ValidUpto</th>
       <th style="width:10%">Card Status</th>
        <th>Photo</th>
              <th>Action</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
  
     <div class="container-fluid" style="display: none;" id="divDependentInfo">
      <h3 class='mt-4' id='dependentTitle'>Edit Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>

          
           <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepname">Dependent BenId :</label>
	              <input type="text" class="form-control form-control-sm" id="NewdepBenid" name="NewdepBenid" readonly="true" data-validation="mandatory,numeric" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
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
		       
		            <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NewdepvalidUpto">Valid upto :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepvalidUpto' name='NewdepvalidUpto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		               
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		      <!-- Blood Group Dropdown -->
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

  
  
		   <div class="col-lg-3">
    <div class="form-group">
      <label class="col-form-label col-form-label-md" for="">Photo:</label>
           
    <img id="editPhoto" src="" alt="Edit Photo" style='width:90px;height:90px'>
    <div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
               	 <div class="invalid-feedback"></div>
    </div>
    </div>
    </div>

  <!--    <div class="col-lg-3">
           <div class="form-group">
          	<img id="editPhoto" src="#" alt="editPhoto" style="display:none; width:90px;height:90px"/>
         	<div class="overlay" id="overlay" onclick="hidePopup()"></div>
			<br>
              <input type='hidden' id='editPhoto' name="editPhoto"/>
		 	 	 <div class="invalid-feedback"></div>
            </div>
       <div class="invalid-feedback"></div>
    </div>
 -->

<div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="UpdateDetails()"><i class='fas fa-save fa-fw' ></i>&nbsp;Save Details</button>
</div> 
</div>


     <div class="container-fluid" style="display: none;" id="divDependentAddInfo">
      <h3 class='mt-4' id='dependentTitle'>Add Dependent Details</h3>
      <hr/>    
          <div class="row" id='divDependentEntry'>

    
	          <div class="col-lg-3">
	            <div class="form-group">
	              <label class="col-form-label col-form-label-md" for="Newdepnameadd">Dependent Name :</label>
	              <input type="text" class="form-control form-control-sm" id="Newdepnameadd" name="Newdepnameadd" placeholder="Enter Name" data-validation="mandatory,alphabetOnly" maxlength="100">
	              <div class="invalid-feedback"></div>
	            </div>
	          </div>
		  	 <div class="col-lg-3">
		           <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="Newdeptrelationadd">Relation :</label>
		              <select class="form-control form-control-sm" id="Newdeptrelationadd" name="Newdeptrelationadd" data-validation="mandatory">
		              </select>
		             <div class="invalid-feedback"></div>
		     	  </div>
		      </div>
		      <div class="col-lg-3">
		            <div class="form-group">
		             	<label class="col-form-label col-form-label-md" for="NewdepDOBadd">Date Of Birth :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepDOBadd' name='NewdepDOBadd' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
			            <div class="invalid-feedback"></div>
		            </div>
		       </div>
		
		       <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="newdepgender">Gender :</label>
		              <select class="form-control form-control-sm" id="Newdepgenderadd" name="Newdepgenderadd" data-validation="mandatory">
		                <option value="">Select Gender</option>
		            
		              </select>
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		       
		            <div class="col-lg-3">
		            <div class="form-group">
		              <label class="col-form-label col-form-label-md" for="NewdepvalidUpto">Valid upto :</label>
						<input type="text" class="form-control form-control-sm datepickerdob"  id='NewdepvalidUptoadd' name='NewdepvalidUptoadd' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
		               
		              <div class="invalid-feedback"></div>
		            </div>
		       </div>
		      <!-- Blood Group Dropdown -->
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
	    		    <button class='btn btn-his-outline' onclick="showPopup('fileInput','preview2' , 'fileContent2' );">Upload dependent's passport size photo</button>
	    			</div>
	    			 <div class="text-primary">Please upload photos in JPG or PNG format, with a maximum file size of  50 KB.</div>
		    			  <input type='text'  data-validation="mandatory"  name="fileContent2" style="display: none;"/>
		 	             <div style='color: red;' id='DepPhotoIdFeedBack'></div>
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
    </div>

  

<div>
<button class='btn btn-his' id="BTNAPPROVE" onclick="AddDepDetails()"><i class='fas fa-save fa-fw' ></i>&nbsp;Save Details</button>
</div> 
</div>


  
 <div class="popup" id="popup" style="display:none;">
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

