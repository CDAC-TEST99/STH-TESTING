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
    </style>
  
<head>
<style>

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

<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/UploadPhoto.js"></script>
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
 <h4>Family Details</h4>
  <table class="table table-bordered table-striped" >
  <thead>
    <tr>
     <th style="width:5%"><b>S.No</b></th>
       <th style="width:10%">BenId</th>
      <th style="width:10%">Name</th>
       <th style="width:10%">Date of Birth</th>
       <th style="width:10%">Relationship</th>
        <th style="width:5%">Gender</th>
    
          <th>Photo</th>
              <th colspan="3">Action</th>
               <th>Last Modified By</th>
               <th>Last Modified Date</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
<!-- <div >
<button class='btn btn-his' id="BTNAPPROVE" onclick="DownloadExcel()"><i class='fas fa-save fa-fw' ></i>&nbsp;Download Data in Excel</button>
</div> -->

  <div class="col-lg-2">
        	    <div class="form-group">
        	      	<img id="preview2" src="#" alt="Preview2" style="display:none;width:70px"/>
         			<div class="overlay" id="overlay" onclick="hidePopup()"></div>
					<br>
					<input type='hidden' id='fileContent2' />
            		<div class="invalid-feedback"></div>
            	</div>
            </div>
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

 <input type="hidden" name="BenId" id="BenId" />
   <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  
 
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

