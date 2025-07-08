<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>

<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<meta charset="UTF-8">
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
        
        
        /* General Card Styling */

.cghs-card{
	margin: 20px auto;
    border: 1px solid #ddd;
    border-radius: 8px;
    overflow: hidden;
	height: 300px;   
	width: 500px;	
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
   
    </style>
  
<head>
<script>

</script>
<script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/eplasticcardprint.js"></script>
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
<!-- CARD FRONT -->
<div class="card cghs-card " id='cghsCard' >
<div class="card-body">
    <div class="card-content">
      <div class="card-image">
        <img id="photo" src="default-photo.jpg" alt="Profile Photo" style="border-radius: 10px;border:1px solid #ddd9d9 !important;">
      </div>
      <div class="card-details" style="margin-top: 76px;">
      <table>
	      <tr>
	      <td style='width:70%; padding:5px;color:#1F6780;font-weight: bold; text-transform: capitalize;letter-spacing: 0.040rem; '>
	          <p class="card-text">
	          NAME: <span id="cardname"></span>
	          </p>	          
	         <p>DOB/GENDER: <span id="cardDob"></span>/<span id="cardGender"></span></p>
	         <p class="card-text">CATEGORY: <span id="cardcardtype"></span> <span id="cardtypenamehindi" style="display: none;"></span></p>
	         <p>RELATION: <span id="cardRelation"></span></p>
	         <p>WARD ENTITLEMENT: <span id="cardentitlement"></span><span id="cardentitlementHindi" style="display: none;"></span></p>
	         <p>VALID UPTO: <span id="cardvalidupto"></span></p>
	        <!-- <p><span id="cardbenid"></span>/ <span id="cardcardtype"></span> (<span id="cardtypenamehindi"></span>)</p> -->
	        <!-- <p>&#x935;&#x948;&#x927;&#x924;&#x93E;/Valid Upto - <span id="cardvalidupto"></span></p> -->
	        </td>
	        <td style="width: 30%; text-align: right; padding-left: 15px;" id="qrCode"></td>
	         <tr>
	          <td colspan="2" style="text-align: right; padding-right: 10px; padding-top: 20px;letter-spacing: 0.040rem;font-weight: bold;">&#x928;&#x93F;&#x930;&#x94D;&#x926;&#x947;&#x936;&#x915;/Director</td>
	     	 </tr>
    	</table>
    	<div style='margin-top: -36px;margin-left: -90px;font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : <span id="cardbenid"></span> </div>  
	  </div>
	  
</div>    
</div>
</div>

<!-- CARD FRONT END ================================================-->
<!-- CARD BACK --> 
<div class="card cghs-card " id='cghsCardBack' >
<div class="card-body">
    <div class="card-content">      
      <div class="card-details" style="margin-top: 76px;">
      <table>
	      <tr>
	      	 
	        <td style="width: 30%; text-align: right; padding-left: 15px;" id="qrCodeBack"></td>
	        <td style='width:70%; padding:5px;color:#1F6780;font-weight: bold; text-transform: capitalize;letter-spacing: 0.040rem; '>
	          
	        </td>
    	</table>
    	<div style='margin-top: 160px;margin-left: 9px;font-size: 33x;color: #fff;font-weight: bold;font-size: 18px;font-style: italic;'>BEN ID : <span id="cardbenidBack"></span> </div>  
	  </div>
	  
</div>    
</div>
</div>
<!-- CARD BACK END  -->




   

<!--   <button onclick="printIDCard()">Print ID Card</button>
 -->

  <!-- Print Button -->
    <script src="script.js"></script>
  
 <input type="hidden" name="BenId" id="BenId" />
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


