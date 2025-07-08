<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
 <meta http-equiv="refresh" content="0; url=/AHIMSG5/hissso/Login">
<link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet">
<link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
<link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">

</head>
<script>
function checkURL(vURL) {
	var flg = true;
	$.ajax({
        url:vURL,
        async: false,
        success: function () {
        	flg = true;
        },
        error: function (jqXHR, status, er) {
            // only set the error on 404
            if (jqXHR.status === 404) { 
            	flg = false;
            }
            else if (jqXHR.status === 500) { 
            	flg = false;
            }
        }
    });
	return flg;
} 
function pageOnLoad()
{ 
		  setTimeout(function() {
 
			  if(!checkURL('/AHIMSG5/hissso/sessionCheckLogin')) {
				    alert("Your session has expired. Kindly login again.")
			    	window.parent.document.forms[0].action = "logoutLogin" ;
			    	window.parent.document.forms[0].submit();
	  } 
		    
 
		}, 1000); 
			 
		
	
}
</script>
 </head>

<body style="background: #fff" onload="pageOnLoad();">
<div class="container mt-5">
<div class='row mt-5'>
	<div class='col-md-12  text-center'>
		<h1 class='text-primary'>Session is Expired or Not a Authenticated User or Invalid URL </h1>
     </div>
	<div class='col-md-12  text-center'><img src='/HIS/hisglobal/images/gears.gif' style='width:200px;'></div>

</div>
</div>
 
</body>
</html>