!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Plastic Card</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
  
  <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
  
<head>

  <script>

  <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Mobileotp.js"></script>
  
  
  <script type="text/javascript">

  $(document).ready(function () {
  	hidePreloader();
  });

  </script>
</script>
</head>
<body>

<div id="sticky-header">
                <div class=" full-width-mega-dropdown">
                <div class="row align-items-center">
                    <div class="col-12 text-center" > 
                    	    <div class="logo"><img src="/HIS/hisglobal/images/cghs_logo_big.png" class="img-fluid"> </div>
                    </div>                    
                </div>
            </div>
    </div>
	<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
    <fieldset  id="ENTRYFORM">          
  
  
  
    <div class="row" style="margin-left: -20px;"  id="perinfo">
      <div class="col-lg-6 instruction">
       <h2 class='text-center'>CGHS Online Apply Plastic Form</h2>
       
        <h4 class="mt-5"'>Instructions</h4>
       		Welcome to the CGHS Card Online Application Portal

			<p>Thank you for choosing to apply for the Central Government Health Scheme (CGHS) card through our online portal. We are committed to making your application process as smooth and efficient as possible.</p>

			<p>This card provides access to a wide range of medical services and benefits, ensuring that you and your family receive the quality healthcare you deserve.</p>

			<p>To get started, please ensure you have all the necessary documents and information ready. Our step-by-step guide will assist you throughout the application process. Should you need any assistance, our support team is here to help.</p>

			<p>Thank you for your dedication to your health and well-being. We look forward to serving you.<p>

			Warm regards,

			The CGHS Team
			<P>For the purpose of availing CGHS facility for a disabled sons above 25 years, please attach a copy of n the certificate of disability issued by the competent authority.</P>
    	
     </div>
     <div class="col-lg-6 information">
    
      <h2>Select Card Type</h2>

      <div class="form-check ps-0 q-box">
        
        <!-- Row 1: Name and Name in Hindi -->
    
         <div class="row">
          <div class="col-lg-6">
            <div class="form-group">
              <input class="form-check-input" type="checkbox" id="checkbox1">
                        <label class="form-check-label" for="checkbox1">
                          Serving
                        </label>
              <div class="invalid-feedback"></div>
            </div>
          </div>

          <div class="col-lg-6">
            <div class="form-group">
              <input class="form-check-input" type="checkbox" id="checkbox2">
                        <label class="form-check-label" for="checkbox2">
                          Pensioner
                        </label>
              <div class="invalid-feedback"></div>
            </div>
          </div>
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