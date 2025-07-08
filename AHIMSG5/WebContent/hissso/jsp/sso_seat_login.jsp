

<!doctype html>
<html class="no-js" lang="en">
<head>
	<meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<META Http-Equiv="Cache-Control" Content="no-cache" />
	<META Http-Equiv="Cache-Control" Content="no-store" />
	<META Http-Equiv="Pragma" Content="no-cache" />
	<META Http-Equiv="Expires" Content="0" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="CGHS">
	<meta name="author" content="CDAC">
	<meta name="keywords" content="CGHS,HMIS,cdac">
	<meta name="keywords" content="CGHS,Central Government Health Scheme,Ministry of Health & Family Welfare,mohfw, cdac">
	

	<%
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store");
		
		
	%>

    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet"> 
    <title>CGHS</title>
    <title>Central Government Health Scheme</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HIS/hisglobal/cdac_main/images/logo.jpg" rel="icon">
    <link href="/HIS/hisglobal/cdac_main/css/style.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_main/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/fontawesome.min.css">


</head>
<body>	
<nav class="navbar navbar-expand-lg navbar-light  bg-white w-100" style="padding: 0px;border-bottom: 1px solid #e0e0e0;">
	<div class="container-fluid" style='padding-left: 10px'>
	<a class="navbar-brand  mb-1" href="/AHIMSG5/hissso/Login" style="width: 50%;">
    	<div class="d-flex flex-row">
    		<div ><img src='/HIS/hisglobal/images/cghs_logo_big.png' style='width: 50%'></div>
    		
		</div>
    </a>
   </div>
   </nav> 
    <div id="slider" class="position-relative mt-2">
        <div class="container-fluid position-absolute start-0 end-0  main-menu px-md-3 mt-3">
        </div>
        <div class="slider-one">
            <div class="slider-seat-image">           
            </div>
        </div>



   


<div class="container-fluid position-absolute" id="seatBox">
        <div class="row">
            <div class="col-md-2 col-xl-2 col-12">&nbsp; </div>
            <div class="col-md-8 col-xl-8 col-12 p-0  mt-5">
                
              <!-- =============================start -->
                
                
		<div class="modal-content modal-content-bg">
            <div class="modal-body" style="height: 50%;">
                <div class='row'>
			 		<div class="col-12 text-center mt-3">
			 			<img src="/AHIMSG5/hissso/portal/images/logo.jpg"  style="width: 75px;">
			 		</div>							 	
			 		
			 		
			 	</div>	
                
                
                       <form method="post">
							<section class="p-0">
								<div class="row"> 
								<%= request.getSession().getAttribute("seatPageData")  %>
								</div>
							</section>
							<input type="hidden" name="varSeatName" value="">
							</form> 
                    </div>

  		</div>           
            
              <!-- ===================================end -->  
            </div>
        </div>
    </div>
</div>

    
       <!-- jquery latest version -->
		    <script src="/HIS/hisglobal/cdac_main/js/jquery-3.7.1.min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/bootstrap-min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/scripts.js"></script>
    
    		<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
			<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/util.js"></script>
    
    
			
			<script type="text/javascript">
				
			 $(document).ready(function(){
		
				 
			 });

			 function goTo(mode){

			if(mode != 'logout'){
				 var seatName= $('input[name="varSeatId"]:checked').attr("data-seatName");
				 
				 var seatId= $('input[name="varSeatId"]:checked').val()
 				 
				 document.forms[0].varSeatName.value = seatName;
					 
			    	var strSecureCode=seatId+seatName;
			    
			   // 	alert("sec code >> "+strSecureCode.replace(/ /g,"_"));
			    	
			    	var fhttf=hex_md5(strSecureCode.replace(/ /g,"_"));
			    	
			    //	 alert("fhttf >> "+fhttf);
			    	
				    document.forms[0].fhttf.value=fhttf;
			}
				  
		    		document.forms[0].action = '/AHIMSG5/hissso/'+mode+'Login';
		    		document.forms[0].submit();
		    		
		        }
		
			</script>
</body>
</html>

