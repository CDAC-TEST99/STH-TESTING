<%@page import="formFlowX.fb.FormFlowXCommonFB"%>

<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8">
  <title>Download Photos And Data</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
   <style>
        .highlight {
            background-color: yellow; /* Change this to your preferred highlight color */
        }
        
        
        /* General Card Styling */

.cghs-card{
	margin: 20px auto;
    border: 1px solid #ddd;
    border-radius: 8px;
    overflow: hidden;
	height: 300px;   
	width: 507px;	
	border: 1px solid #000;
	background-repeat: no-repeat;  
	background-size: 100% 100%;
}

.cghs-card-green{
	background-image: url('/HIS/hisglobal/images/cghscard/GREEN.png');	
}
.cghs-cardback-green{
	background-image: url('/HIS/hisglobal/images/cghscard/GREEN_BACK.png');	
}
.cghs-card-blue{
	background-image: url('/HIS/hisglobal/images/cghscard/BLUE.png'); 
}
.cghs-cardback-blue{
	background-image: url('/HIS/hisglobal/images/cghscard/BLUE_BACK.png'); 
}


.cghs-card-red{
	background-image: url('/HIS/hisglobal/images/cghscard/RED.png');
}
.cghs-cardback-red{
	background-image: url('/HIS/hisglobal/images/cghscard/RED_BACK.png');
}

.cghs-card-orange{
	background-image: url('/HIS/hisglobal/images/cghscard/ORANGE.png');
}

.cghs-cardback-orange{
	background-image: url('/HIS/hisglobal/images/cghscard/ORANGE_BACK.png');
}

.cghs-card-yellow{
	background-image: url('/HIS/hisglobal/images/cghscard/YELLOW.png');
}
.cghs-cardback-yellow{
	background-image: url('/HIS/hisglobal/images/cghscard/YELLOW_BACK.png');
}

.card-body {
  display: flex;
  padding: 5px;
}

.card-content {
  display: flex;
  width: 100%;
}

.card-image {
  margin-right: 15px;
  margin-top: 100px;
}

.card-image img {
  width: 80px;
  height: 100px;
    object-fit: cover;
}

.card-details {
  flex-grow: 1;
}

.card-body p {
  margin: 0;  /* Remove margin around paragraphs */
  padding: 0; /* Remove padding inside paragraphs */
  text-align:left;
}

 .ledger-header-error {
    background: #5d0606;
    color: white;
    text-align: center;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    position: sticky;
    top: 0;
    z-index: 1000;
  }
  
  
  
 .ledger-header-success {
    background: #1d39a7;
    color: white;
    text-align: center;
    padding: 10px;
    font-size: 18px;
    font-weight: bold;
    position: sticky;
    top: 0;
    z-index: 1000;
  }
 

.table-container {
    max-height: 300px;
    overflow-y: auto;
  } 

.table-container table {
  width: 100%;
  border-collapse: collapse;
}

.table-container th, td {
  padding: 10px;
  border: 1px solid #ddd;
  text-align: left;
}

.table-container thead {
  position: sticky;
  top: 0;
  background: #f8f8f8;
  z-index: 2;
}

   
    </style>
  
<head>
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Airindiarenewalupload.js"></script>
 <link rel="stylesheet" href="/CGHSCardMgmt/global/css/swal.css">
<script src="/CGHSCardMgmt/global/js/swal.js"></script>
  <script type="text/javascript">

   
    </script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
  

</style>
  <script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.11.0/dist/JsBarcode.all.min.js"></script>
  
  
 <!-- QrCode -->
 <script src="/HIS/hisglobal/FormFlowX/plugins/jquery-qrcode/jquery.qrcode.min.js"></script>

</head>


<%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
   
<body>
   

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Custom Card</title>
    <link rel="stylesheet" href="styles.css">
      <script src="script.js"></script>
</head>
<body>

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
	<div class='row'>
		<div class='col-md-2' style="margin-top: -7px;margin-left: -34px;">
			<span class="badge bg-light text-primary"><h5 class='mt-1' id='listModuleTitle'></h5></span>
		</div>
		
		<!-- Excel Upload -->
	<div class='col-md-3 mt-3 mb-2'>
	    <label for="excelFile1">Upload Card Renewal Data Excel File (500 Rows only):</label>
	    <input type="file" id="excelFile" name="excelFile" accept=".xls,.xlsx" class="form-control">
	</div>
	<div class='col-md-2 mt-4 mb-2' id='uploadExcel'>
	    <button type="button" class="btn-his-sm" style="margin-top :15px" onclick="uploadExcel()">Upload Excel</button>
	    <div class="invalid-feedback"></div>
	</div>
	
	<div class='col-md-1 mt-4 mb-2' id='resetPage' style="display: none;">
	    <button type="button" class="btn-his-sm" style="margin-top :15px" onclick="resetPage()">Reset</button>
	    <div class="invalid-feedback"></div>
	</div>
	
	
	<div class='col-md-2 mt-4 mb-2' id='cardRenewal' style="display: none;">
	    <button type="button" class="btn-his-sm" style="margin-top :15px" onclick="cardRenewal()">Card Renewal</button>
	    <div class="invalid-feedback"></div>
	</div>
	
	
	<div id="downloadSample" style="text-align: right;" class="col-md-4 mt-4 mb-2">
	    <a href="/CGHSCardMgmt/cghsCard/Card_Details_Sample.xlsx" style="color: blue;cursor: pointer;">Click to Download Sample Excel Sheet</a>
	</div>
	
	</div>

<div style="color: red;font-size: 14;font-weight: bolder;" id='errMsg' ></div>
<div style="color: green;font-size: 14;font-weight: bolder;" id='normalMsg' ></div>
  
  
 <div id="instructionArea" style="margin-top: 6%;margin-left: 15%;">
  
  <table>
    <tr>
        <th>Step</th>
        <th>Instruction</th>
    </tr>
    <tr>
        <td>Step 1</td>
        <td>Download the Sample Excel sheet from the above link or  <a href="/CGHSCardMgmt/cghsCard/Card_Details_Sample.xlsx" style="color: blue;cursor: pointer;">Click to Download Sample Excel Sheet</a></td>
    </tr>
    <tr>
        <td>Step 2</td>
        <td>Update the Excel sheet with the required card renewal details as per specified format <br>and without any duplicate data</td>
    </tr>
    <tr>
        <td>Step 3</td>
        <td>Choose the Excel File and then Click Upload Excel Button</td>
    </tr>
    <tr>
        <td>Step 4</td>
        <td>If any Error Records; please rectify the same in excel and retry from Step 1, <br>until No Error Records appear on the screen</td>
    </tr>
      <tr>
        <td>Step 5</td>
        <td>When All Records are successful; Click the 'Card Renewal' Button to renew all the uploaded Data</td>
    </tr>
</table>

  
  
  </div>
  
	
  <div id='errorRecordArea'>
  <div class="ledger-header-error" id='errorRecordId'>Error Records</div>
  <div class='table-container' >
  <table id='errorRecords'></table>
  </div>
  </div>
  
  
  
  <div  id='successRecordArea'>
  <div class="ledger-header-success" id='successRecordId'>Success Records</div> 	
  	 <div class='table-container' >
  	<table id='successRecords'></table>
  	</div>
  </div>
  
  
  
 <input type="hidden" name="successRecordsJson" id="successRecordsJson" /> 
 <input type="hidden" name="BenId" id="BenId" />
 <input type='hidden' name="cityId" id="cityId"/>
  <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  

  </form>
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
</body>
</html>


