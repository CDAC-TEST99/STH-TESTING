<!doctype html>
<%@page import="hisglobal.utility.SecurityUtil"%>
<%@page import="hisglobal.utility.HisUtil"%>
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
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Central Government Health Scheme Ministry of Health &amp; Family Welfare Government of India" />
<meta name="author" content="CDAC">
<meta name="keywords" content="CGHS,HMIS,cdac">
<meta name="keywords"
	content="CGHS,Central Government Health Scheme,Ministry of Health & Family Welfare,mohfw, cdac">
<title>Central Government Health Scheme</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon"
	href="/AHIMSG5/hissso/portal/images/favicon.ico">
<!--  CSS Files -->
 <link href="/AHIMSG5/hissso/portal/css/bootstrap-min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="/AHIMSG5/hissso/portal/css/accessibility/accesibility-style-v2.1.css">
<link href="/AHIMSG5/hissso/portal/css/animate.css" rel="stylesheet" />
<link href="/AHIMSG5/hissso/portal/fontawesome/css/all.min.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="/AHIMSG5/hissso/portal/css/style-newdesign.css"
	rel="stylesheet">
<!-- <link href="/AHIMSG5/hissso/portal/css/menu-newdesign.css"
	rel="stylesheet"> -->
<link href="/AHIMSG5/hissso/portal/css/responsive-newdesign.css"
	rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/owl.carousel.min.css"
	rel="stylesheet"> 
	
	<style>
@keyframes scroll-left {
  0%   { transform: translateX(0); }
  100% { transform: translateX(-100%); }
}

</style>
	
	<style>
	
	
	
	
/* List Item Style */
.official-menu-item {
  list-style: none;
  margin: 6px 0;
  padding: 8px 12px;
  border-bottom: 1px solid #e0e0e0;
}

/* Link Style */
.official-link {
  display: block;
  padding: 10px 12px;
  color: #333;
  font-size: 16px;
  font-weight: 500;
  text-decoration: none;
  border-radius: 6px;
  transition: background-color 0.3s, color 0.3s;
}

/* Hover effect */
.official-link:hover {
  background-color: #f0f0f0;
  color: #007BFF;
}

/* Responsive font size */
@media (max-width: 768px) {
  .official-link {
    font-size: 14px;
    padding: 8px 10px;
  }
}
</style>
	
<style>
/* Tabs (Desktop) */
.nav-tabs .nav-link {
  background: #2c2c2c;
  color: #ccc;
  border: none;
  transition: background 0.3s, color 0.3s;
}
.nav-tabs .nav-link.active, .nav-tabs .nav-link:hover {
  
}

/* Accordion Button (Mobile) */
.accordion-button {
  background: #2c2c2c;
  color: #fff;
}
.accordion-button:not(.collapsed) {
  background: #ff416c;
  color: #fff;
}

/* List Scrollbar */
/* .container-fluid::-webkit-scrollbar {
  width: 6px;
}
.container-fluid::-webkit-scrollbar-thumb {
  background-color: #ff4b2b;
  border-radius: 10px;
}
.container-fluid::-webkit-scrollbar-track {
  background: #333;
} */

/* View More */
.view-more:hover {
  background: #ff416c;
  color: #fff;
  transition: background 0.4s;
}

/* Animation */
.tab-pane, .accordion-body {
  animation: fadeIn 0.6s ease;
}
@keyframes fadeIn {
  0% { opacity: 0; transform: translateY(20px); }
  100% { opacity: 1; transform: translateY(0); }
}

/* Responsive Adjustment */
@media (max-width: 767px) {
  #pdfsection .nav-tabs {
    display: none;
  }
  #pdfsection .accordion-header {
    display: block;
  }
  /* .container-fluid {
    height: 400px; /* Slightly less on mobile */
  } */
}
@media (min-width: 768px) {
  .accordion-header {
    display: none;
  }
}
</style>
	
	<style>
@keyframes popupFadeIn {
  0% {
    opacity: 0;
    transform: translate(-50%, -50%) scale(0.8);
  }
  100% {
    opacity: 1;
    transform: translate(-50%, -50%) scale(1);
  }
}
#sharePopup button:hover {
  background: linear-gradient(135deg, #00f2fe 0%, #4facfe 100%);
  transform: scale(1.05);
}
#sharePopup a:hover {
  transform: scale(1.2);
}
#sharePopup button:last-child:hover {
  background: #444;
}


//styles for pdf pop up modal

@keyframes popupFadeIn {
  0% {
    opacity: 0;
    transform: translate(-50%, -50%) scale(0.8);
  }
  100% {
    opacity: 1;
    transform: translate(-50%, -50%) scale(1);
  }
}
#closeModalBtn:hover {
  transform: rotate(90deg);
}
@media (max-width: 768px) {
  #pdfModal {
    width: 95%;
    height: 85vh;
  }
}
@media (max-width: 480px) {
  #pdfModal {
    width: 98%;
    height: 80vh;
  }
  #pdfModal h2 {
    font-size: 16px;
  }
  #closeModalBtn {
    font-size: 20px;
  }
}
</style>


<style>
.custom-popup {
  display: none; /* hidden by default */
  position: fixed;
  z-index: 1000;
  left: 0; top: 0;
  width: 100vw; height: 100vh;
  background-color: rgba(0, 0, 0, 0.6);
  backdrop-filter: blur(4px);
  justify-content: center;
  align-items: center;
  animation: fadeIn 0.3s ease-in-out;
}

.popup-content {
  background: white;
  padding: 20px;
  border-radius: 16px;
  max-width: 90%;
  width: 500px;
  text-align: center;
  position: relative;
  box-shadow: 0 10px 30px rgba(0,0,0,0.3);
  animation: slideIn 0.4s ease;
  display: flex;
  flex-direction: column;
  gap: 20px;
}

.popup-img {
  width: 100%;
  max-height: 200px;
  object-fit: contain;
}

.close-btn {
  position: absolute;
  top: 10px; right: 15px;
  font-size: 24px;
  cursor: pointer;
  color: #333;
}
/*to let the important links scroll work */
.custom-popup-content .content{ 
	max-height:48vh;
}

@keyframes fadeIn {
  from {opacity: 0;}
  to {opacity: 1;}
}

@keyframes slideIn {
  from {
    transform: translateY(-50px);
    opacity: 0;
  }
  to {
    transform: translateY(0);
    opacity: 1;
  }
}

@media (max-width: 600px) {
  .popup-content {
    width: 90%;
    padding: 16px;
  }
}

/* Add Unique Styling for Each Popup (Example) */
.popup1 .popup-content {
  background-color: #f8f9fa;
}

.popup2 .popup-content {
  background-color: #e9ecef;
}

.popup3 .popup-content {
  background-color: #f1f3f5;
}
</style>

<style>
.animated-btn {
  padding: 10px 20px;
  font-size: 16px;
  background: linear-gradient(45deg, #ff6b81, #f06595);
  border: none;
  border-radius: 50px;
  color: white;
  text-transform: uppercase;
  cursor: pointer;
  transition: transform 0.3s ease, box-shadow 0.3s ease, background 0.4s ease;
  box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
  display: inline-flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  letter-spacing: 1px;
  outline: none;
  animation: bounce 1s infinite;
}

/* Button Hover Animation */
.animated-btn:hover {
  transform: translateY(-5px);
  box-shadow: 0px 6px 16px rgba(0, 0, 0, 0.3);
  background: linear-gradient(45deg, #f06595, #ff6b81);
}

/* Button Focus Animation */
.animated-btn:focus {
  outline: none;
  transform: translateY(-5px);
  box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.4);
}

/* Adding a subtle bounce effect */
@keyframes bounce {
  0%, 100% {
    transform: translateY(0);
  }
  50% {
    transform: translateY(-10px);
  }
}

/* Optional: Adding a "pulse" effect when hovered */
.animated-btn:active {
  animation: pulse 0.6s forwards;
}

/* Pulse Effect */
@keyframes pulse {
  0% {
    transform: scale(1);
  }
  50% {
    transform: scale(1.1);
  }
  100% {
    transform: scale(1);
  }
}
</style>

<style>
.popup-img-container {
  text-align: center;  /* Center the images and descriptions */
  margin-bottom: 20px;
}

.popup-img {
  width: 100%;
  max-width: 300px; /* Limit the image width */
  height: auto;
  object-fit: contain;
  border-radius: 8px;
  box-shadow: 0 4px 8px rgba(0,0,0,0.2); /* Add a subtle shadow to the image */
}

.img-description {
  font-size: 14px;
  color: #333;
  margin-top: 10px;
  font-weight: bold;
  text-align: center;
  padding: 0 20px;
  line-height: 1.5;
  font-style: italic;
  max-width: 90%;
  margin-left: auto;
  margin-right: auto;
}

.popup-content {
  background: white;
  padding: 20px;
  border-radius: 16px;
  max-width: 90%;
  width: 500px;
  text-align: center;
  position: relative;
  box-shadow: 0 10px 30px rgba(0,0,0,0.3);
  display: flex;
  flex-direction: column;
  gap: 20px;
}



.custom-popup-wrapper {
  position: fixed;
  inset: 0;
  background: rgba(0, 0, 0, 0.75);
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 10000;
  padding: 20px;
  box-sizing: border-box;
}

.custom-popup-box {
  position: relative;  /* For close button positioning */
  max-width: 600px;
  /* width: 90%; */
  max-height: 90vh;
  /* NO overflow hidden here */
}

/* Wrapper for image only, to keep border radius and overflow hidden */
.image-wrapper {
  border-radius: 10px;
  
  max-height: 90vh;
}

/* Image fills the wrapper */
.popup-full-image {
  display: block;
  
  height: 100%;
  object-fit: cover;
}

/* Close button positioned at top-right edge of the popup box */
.custom-close-btn {
  position: absolute;
  top: -15px;
  right: -15px;
  width: 38px;
  height: 38px;
  font-size: 26px;
  color: black;
  background: white;
  border-radius: 50%;
  cursor: pointer;
  line-height: 38px;
  text-align: center;
  box-shadow: 0 2px 8px rgba(0,0,0,0.5);
  transition: all 0.3s ease;
  z-index: 10001;
}

.custom-close-btn:hover {
  background: #ff4444;
  transform: scale(1.1) rotate(90deg);
}

/* Responsive */
@media (max-width: 600px) {
  .custom-popup-box {
    width: 100%;
  }
  .custom-close-btn {
  
  
    width: 32px;
    height: 32px;
    font-size: 22px;
    top: -12px;
    right: -12px;
    line-height: 32px;
  }
}
</style>

<!-- ð§  JavaScript -->

<script>
  window.addEventListener("load", function () {
    document.getElementById("customLaunchOverlay").style.display = "flex";
    document.getElementById("btnDismissPopup").addEventListener("click", function () {
      document.getElementById("customLaunchOverlay").style.display = "none";
    });
  });
</script>
<script>
function openPopup(popupId, contentId) {
  document.getElementById(popupId).style.display = 'flex';
}

function closePopup(popupId) {
  document.getElementById(popupId).style.display = 'none';
}
</script>

</head>

<body>
 <div id="customLaunchOverlay" class="custom-popup-wrapper">
  <div class="custom-popup-box">
    <div class="image-wrapper">
      <img src="/AHIMSG5/hissso/portal/images/cghs-app-popup.jpg" alt="Popup Image" class="popup-full-image img-fluid">
    </div>
    <span id="btnDismissPopup" class="custom-close-btn">&times;</span>
  </div>
</div> 

<form method='post'>
		<input type='hidden' name='tokenCode'
			value='<%=java.util.Base64.getEncoder().encodeToString(new java.util.Date().toString().getBytes())%>'></input>
	</form>
	

	<header>
		<div id="topbar" class="container-fluid">
			<div class="row d-flex align-items-center">
						<div class="col-12 col-md-4 d-md-block d-none">
					<div class="d-flex align-items-center">
					
						<p
							class="fw-semibold mb-0 ms-1 tollfree d-flex align-items-center">
							<span class="material-symbols-outlined me-1">
								phone_in_talk </span>
						<p data-lang-key='HelpLine' class="m-0">24 X 7 Helpline
							number: 1800-208-8900</p>
						
					</div>
				</div>
				<div
					class="col-12 col-lg-8 col-md-8 d-flex align-items-center justify-content-md-end justify-content-start loginbtn rightarea p-1">
					
					
					
					<!-- <div
						class="search border-start border-end border-1 border-white border-opacity-25 px-xl-2 pt-1 d-none d-md-block">
					<a href="#myInput" style="color: inherit;"><span class="material-symbols-outlined"> search </span></a>
					</div> -->

					 <a
						class="text-decoration-none text-white ms-1 d-flex align-items-center fw-regular loginbuttton"
						href="/AHIMSG5/hissso/benLogin" data-lang-key='CGHSBenLogin'><span
						class="material-symbols-outlined me-1" >login</span>Beneficiary Login</a> 
						
			
						 <a
						class="text-decoration-none text-white ms-1 d-flex align-items-center fw-regular loginbuttton"
						href="/AHIMSG5/hissso/cghsLogin"data-lang-key='CGHSLogin'><span
						class="material-symbols-outlined me-1"  >login</span>CGHS Login</a>
						
						<div class="search ps-xl-1 d-none d-md-block" 
     style="position: relative; cursor: pointer;  padding: 4px 8px; border-radius: 4px; display: inline-block;">
  <i 
    class="fa-solid fa-magnifying-glass" 
    onclick="focusMainSearch()" 
    style="color: white; font-size: 18px; line-height: 1;">
  </i>
</div>
						
						
					<div class="language me-1">
						<select required="" id='lang' name="lang"
							aria-label="Language selection" onchange="languageChange();"
							class="ms-1 form-select">
							<option value="en" selected="selected">English</option>
							<option value="hi">Hindi</option>
						</select>
					</div>
				</div>
			</div>
		</div>
		 <div class="container-fluid">
		 <div class="row p-0 d-flex align-items-center">
                <div class="col-sm-10 col-12 col-md-4 col-lg-4 d-flex align-items-center">
                    <div class="logo position-relative pe-1 pt-md-0 pt-2">
                        <div class="d-flex align-items-center ">
							<a href="/AHIMSG5/hissso/Login">
    <img src="/AHIMSG5/hissso/portal/images/logo.jpg" width="45px" />
</a>
							<a href="/AHIMSG5/hissso/Login" style="text-decoration: none; color: inherit;">
    <div class="ps-1">
        <h1 class="fw-bold mb-1 pt-1" data-lang-key='cghsFullName'>
            Central Government Health Scheme
        </h1>
        <h2 class="mb-0 fw-regular" data-lang-key='MinistryofHealthFamilyWelfare'>
            Ministry of Health & Family Welfare
        </h2>
        <h3 class="fw-bold pb-1" data-lang-key='GovernmentOfIndia'>
            Government of India
        </h3>
    </div>
</a>
						</div>
					</div>

				</div>
					<div class="col-lg-8 d-flex justify-content-end">
				 <div class="all-logins d-lg-flex align-items-center d-none d-sm-none d-md-none">
						<a
							class="hover-underline text-center text-decoration-none px-md-3 px-lg-1 px-xl-3 px-xxl-4 px-0 fw-regular"
							href="javascript:openFrame('applycard');"><i class="fa-solid fa-id-card"></i>
							<p data-lang-key='applyForCGHSCard' class="mb-0">
								Apply for CGHS card
							</p></a>
							<a href="/AHIMSG5/hissso/empanelledLogin"
  class="hover-underline text-decoration-none text-center px-md-3 px-lg-1 px-xl-3 px-xxl-4 px-0  fw-regular"
>
<i class="fa-solid fa-hospital-user"></i>
  <p data-lang-key="EmpaneledHospitals" class="mb-0">
    Empaneled Hospitals and Labs
  </p>
</a><a
							class="hover-underline text-decoration-none border-0 text-center px-md-3 px-lg-1 px-xl-3 px-xxl-4 px-0 fw-regular"
							href="javascript:openFrame('appointment');"><i class="fa-solid fa-calendar-check"></i>
							<p data-lang-key='BookOnlineAppointment' class="mb-0">
								Book Online Appointment
							</p></a>
							<div class="logos d-flex align-items-center">
							<img src="/AHIMSG5/hissso/portal/images/satyamev.jpg" class="pe-0"  />
							<img src="/AHIMSG5/hissso/portal/images/digital-india.jpg" class="" />
							</div>
							
					</div>
					
				</div>
			</div>

		</div>







	 <div class="container-fluid main-menu py-1">
		 <div class="row">
              <div class="col-12 col-sm-12 col-md-12 col-lg-12 d-flex align-items-center justify-content-between">
				  <nav class="navbar navbar-expand-lg position-relative p-0">
                           <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarWithDropdown" aria-controls="navbarWithDropdown"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                            <span class="close-icon text-white border-0">X</span> <!-- Close Icon -->
                        </button><!-- Collapsible Navbar Content -->
                        <div class="collapse navbar-collapse" id="navbarWithDropdown">
                            <div class="all-logins d-lg-flex d-block align-items-center d-lg-none d-block mt-4">
						<a
							class="text-decoration-none text-white px-md-2 px-lg-1 px-xl-1 px-xxl-2 px-3 border-start-0 d-flex align-items-center fw-semibold justify-content-center"
							href="javascript:openFrame('applycard');"><span
							class="material-symbols-outlined me-1"> badge </span>
							<p data-lang-key='applyForCGHSCard' class="mb-0">
								Apply for<br> CGHS card
							</p></a> <a href=""
  class="text-decoration-none text-white px-md-2 px-lg-1 px-xl-1 px-xxl-2 px-0 d-flex align-items-center fw-semibold justify-content-center"
>
  <span class="material-symbols-outlined me-1">home_health</span>
  <p data-lang-key="EmpaneledHospitals" class="mb-0">
    Empaneled Hospitals<br> and Labs
  </p>
</a> <a
							class="text-decoration-none text-white px-md-2 px-lg-1 px-xl-1 px-xxl-2 px-3 d-flex align-items-center fw-semibold justify-content-center"
							href="javascript:openFrame('appointment');"><span
							class="material-symbols-outlined me-md-1 me-0"> book_online </span>
							<p data-lang-key='BookOnlineAppointment' class="mb-0">
								Book Online<br> Appointment
							</p></a>
					</div>
                            
                            
                            <ul class="navbar-nav" id="menu"> 
                        <i class="fa-solid fa-house text-white ps-2 pt-2"></i>
                            
                            </ul>
                        </div>

                    </nav> 
				
					
				</div>
			</div>

		</div>

	</header>

	<div id="pdfContainer">
		<!-- Datalist will be dynamically created based on groupId -->
	</div>
	
	
	<div id="sharePopup" style="display:none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%) scale(0.9); background: #1f1f1f; border-radius: 16px; padding: 35px 25px; box-shadow: 0 20px 40px rgba(0, 0, 0, 0.7); z-index: 9999; width: 420px; max-width: 90%; animation: popupFadeIn 0.4s ease forwards; color: #e0e0e0;">
  <h3 id="sharePopupTitle" style="margin-top: 0; margin-bottom: 20px; color: #ffffff; font-size: 22px; font-weight: bold; text-align: center;">ð Share This Page</h3>
  
  <input id="sharePopupInput" type="text" readonly style="width: 100%; padding: 14px 16px; font-size: 15px; margin-bottom: 20px; border: 1px solid #333; border-radius: 10px; background: #2c2c2c; color: #ccc; box-sizing: border-box;">

  <div style="text-align: center;">
    <button onclick="copyShareLink()" style="padding: 12px 20px; background: linear-gradient(135deg, #4facfe 0%, #00f2fe 100%); color: white; border: none; border-radius: 50px; cursor: pointer; font-size: 15px; font-weight: 600; transition: background 0.3s, transform 0.3s;">Copy Link</button>
  </div>

  <div style="display: flex; justify-content: center; gap: 25px; margin: 25px 0;">
    <!-- WhatsApp Share -->
    <a href="https://wa.me/?text=" id="whatsappLink" target="_blank" style="color: #25D366; font-size: 26px; transition: transform 0.3s;">
      <i class="fa-brands fa-whatsapp"></i>
    </a>
    <!-- Facebook Share -->
    <a href="https://www.facebook.com/sharer/sharer.php?u=" id="facebookLink" target="_blank" style="color: #1877F2; font-size: 26px; transition: transform 0.3s;">
      <i class="fa-brands fa-facebook"></i>
    </a>
    <!-- Email Share -->
    <a href="mailto:?subject=Check this link&body=" id="emailLink" target="_blank" style="color: #FF6B6B; font-size: 26px; transition: transform 0.3s;">
      <i class="fa-solid fa-envelope"></i>
    </a>
  </div>

  <div style="text-align: center;">
    <button onclick="closeSharePopup()" style="padding: 10px 18px; background: #333; color: #ddd; border: none; border-radius: 50px; cursor: pointer; font-size: 14px; font-weight: 500; transition: background 0.3s, transform 0.3s;">Close</button>
  </div>
</div>
	<!-- Carousel Start -->
	<div class="container-fluid" id="slider">
  <div class="row d-flex handlingdivwidth">
    <div class="col box p-0 order-2 order-lg-1" style="flex: 2.5;"><section id="pdfsection" class="">
  <!-- Tab Navigation -->
  <ul class="nav nav-tabs px-2 border-0" id="myTab" role="tablist">
    <li class="nav-item w-100 px-lg-1 px-xl-3 pt-2" role="presentation">
      <button class="nav-link p-0 active d-flex align-items-center justify-content-start py-1 fw-semibold w-100 border-bottom border-1" id="currentIssuesId" data-bs-toggle="tab" data-bs-target="#currentIssuesId-pane" type="button" role="tab" aria-controls="currentIssuesId-pane" aria-selected="true" onclick="displayCircularDetails(21)"  data-lang-key='LatestNewsUpdates'>
       <i class="fa-solid fa-square me-2"></i>Latest News & Updates
      </button>
    </li>
    <!-- Add other tab buttons if needed -->
  </ul>

  <div class="tab-content accordion" id="myTabContent">
    <!-- News and Updates Section -->
    <div class="tab-pane fade show active accordion-item" id="currentIssuesId-pane" role="tabpanel" aria-labelledby="currentIssuesId" tabindex="0">
      
      <!-- Accordion Header (Mobile) -->
      <h2 class="accordion-header d-none" id="headingOne">
        <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          Current Issues
        </button>
      </h2>

      <!-- Accordion Body -->
      <div id="collapseOne" class="accordion-collapse collapse show d-lg-block" aria-labelledby="headingOne" data-bs-parent="#myTabContent">
        <div class="accordion-body py-1 pe-2 ps-lg-1 ps-xl-4">
          
          <!-- Search Input -->
          <input   type="text" id="myInput" onkeyup="mySearchFunction()" placeholder="Search News & Updates...." class="form-control my-1 searchnews pt-xl-2 pt-lg-1 mb-lg-2 mb-xl-3 px-2">

          <!-- List Container -->
          <div class="container-fluid p-0 scroll">
            <ul id="datalistId1" class="datalist p-0 m-0" style="list-style: none;">
              <div class="view-more text-center text-white p-2 position-relative" style="cursor: pointer;">
                <div class="wavy-line" style="height: 2px; background: linear-gradient(90deg, #ff4b2b, #ff416c); margin: 8px 0;"></div>
                View More &gt;&gt;
              </div>
            </ul>
          </div>

        </div>
      </div>

    </div>

    <!-- Other Tabs (Press Releases, Empanelment, Tenders, etc.) -->
    <!-- You can duplicate the same structure here -->
    
  </div>
</section></div>
    <div class="col p-0 box order-1 order-lg-2" style="flex: 7;">	<div  class="position-relative">

		<div class="header-carousel owl-carousel position-relative">
			<div class="header-carousel-item cghsbanner">
				<div class="header-carousel-item-img-1">
						<img id="bannerImage" src="/AHIMSG5/hissso/portal/images/slider/cghs-english-banner.jpg" alt="Banner Image" /> 
				</div>
			</div>
			

		</div>
	
	
	</div></div>
    <div class="col p-0 box order-3 order-lg-3" style="flex: 2.5;">
    <div class="searchempanneled  text-center position-relative">
	<h2 class="text-white pt-xxl-4 pt-xl-4 pt-lg-2 pt-4"  data-lang-key='SearchEmpanelledHospitals'>Search Empanelled Hospitals</h2>
	<form class="mt-3">
	<div class="form-control bg-transparent border-0 p-0 mb-xl-2 mb-xxl-2 mb-2 mb-lg-1 mt-xxl-4 mt-xl-4 mt-lg-2 px-4">
	<select class="bg-white p-xxl-2 p-2 p-xl-2 p-lg-1 border-1 border-dark border-opacity-50 w-100">
	<option selected="selected" data-lang-key='HospitalsDiagnosticsCentres'>Hospitals/Diagnostics Centres</option>
	</select></div>
	<div class="form-control  bg-transparent border-0 p-0 px-4">
	<select id="citySelect" class="bg-white p-xl-2 p-xxl-2 p-2 p-lg-1  border-1 border-dark border-opacity-50 w-100" >
	<option selected="selected" >Select City</option>
	</select></div>
	<button type="button" class="position-absolute bottom-0 start-0 end-0 text-white w-100 border-0 outline-0 py-xxl-2  py-2  py-xl-2 py-lg-1" id="submitBtn"  data-lang-key='Submit'>Submit</button>
	
	</form>
	
	</div>	
    
    <div class="scanner position-relative">

	<div class="online-support box p-xxl-3 p-xl-2 px-3">
								<div class="heading d-flex align-items-center justify-content-between">
								<h5 class="text-black mb-2 fw-bold" data-lang-key='OnlineSupport'>Online Support</h5>
								<i class="fa-solid fa-headset mb-2"></i>
								</div>
								
								
								<p class="mb-xxl-3 mb-xl-3" data-lang-key='Onlinesupporttext'>For any queries or support related to CGHS services, please reach out to us. We're here to assist you with information, guidance, and help.</p>
								  <div class="important">
							   <div class="item d-flex align-items-center wow fadeInRight mb-4 mb-md-4 mb-xl-3">
								  <div class="icon wow fadeInLeft  me-3"> <i class="fa-solid fa-mobile-screen"></i> </div>
								<div class="fw-semibold">
									<!-- <p data-lang-key='Onlinesupport' class="mb-0">24 X 7 Helpline number:</p> -->
									<a href="tel: 1800-208-8900" class="text-decoration-underline d-block fw-regularlevel3">
 1800-208-8900
</a>
								</div>
							</div>

							<div class="item d-flex align-items-center wow fadeInLeft" data-wow-delay="1s">
															<div class="icon  wow fadeInLeft  me-3">
								<i class="fa-solid fa-envelope-open-text"></i>
								</div>
				<div class="fw-semibold">
									<!-- <p data-lang-key='FacilitiesUnderCGHS' class="mb-0" >Facilities available
										under CGHS</p> -->

									<a href="mailto:mctc@cghs.nic.in" class="text-decoration-underline d-block fw-regularlevel3">
 mctc@cghs.nic.in
</a>
								</div>
							</div>



						</div>
								
								
								</div>					
					
						</div></div>
  </div>
</div>
	
	
	
	
	
	
	
	<div class="container-fluid p-0" id="hideforotherpages">
	<div class="row d-flex align-items-top">
	<div class="col-3 p-0">
	
	
	
	</div>
	<div class="col-9 p-0 d-flex align-items-top">

	
					
	
	</div>
	</div>

	
	<div id="page">
	<div class="page banner text-center py-5 position-relative"
		id="submenu-banner" style="display: none;">
		<h2 id="submenu-header" class="text-white"></h2>
		<div class="image position-absolute end-0 bottom-0">
			<img src="/AHIMSG5/hissso/portal/images/banner-image.png" />
		</div>

		<div
			class="breadcrumb p-0 m-0 wow fadeInUp d-flex align-items-center justify-content-center"
			style="font-size: 25px;" id="submenu-breadcrumb"></div>
	</div>
</div>


	<div id="submenu-content" class="container-fluid scrollable-div "
		style="display: none; height: 600px; width: 1200px;">

		<div class="row">
			<div class="col-md-12">
				<div id="content-display" class="p-1"></div>
			</div>
		</div>
	</div>

	<!-- Carousel End -->


	<section class="my-2 my-md-3 my-lg-5 pb-3" id="aboutsection">
			  <div class="container-fluid " id="newsSection">
			<div class="row">
				<div class="col-md-12 col-lg-3 col-12">
					<div class="heading">
						<span class="line"></span> <small
							class="d-block text-uppercase pt-1" data-lang-key='ExploreMore'>Get to Know Us</small>
						<h2 class="fw-bold mb-3" data-lang-key='LatestNews'>Empowering Healthcare Management</h2>
						<ul class="list-unstyled">
					<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=132" onclick="handleLevel3Click(this)"  data-lang-key='HowToGenerateABHA'>How to generate ABHA number and address</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=133" onclick="handleLevel3Click(this)" data-lang-key='HowToApplyPlasticCard'>How to apply for Plastic Card</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=134" onclick="handleLevel3Click(this)" data-lang-key='ProcedureReferral'>Procedure for Referral</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=135" onclick="handleLevel3Click(this)" data-lang-key='InvestigationTreatment'>Investigations and Treatment Procedures</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=136" onclick="handleLevel3Click(this)" data-lang-key='Hospitalization'>Hospitalization</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=137" onclick="handleLevel3Click(this)" data-lang-key='ReimbursementClaims'>Reimbursement of Medical Claims</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=138" onclick="handleLevel3Click(this)" data-lang-key='Teleconsultation'>Teleconsultation</a>
</li>
<li><i class="fa-solid fa-check me-2"></i>
  <a class="level3 text-black" href="#" data-url="/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=11&subGroupId=139" onclick="handleLevel3Click(this)" data-lang-key='ServiceFeedback'>CGHS Service Feedback</a>
</li>
						</ul>
					</div>
					


				</div>
				<div class="col-md-12 col-lg-9 col-xl-9 col-12 p-md-0">
					<div class="aboutsection pe-md-5 pe-0">
						
						<p class="fw-regular mb-2" data-lang-key='CGHSIntroduction'>For
							the last six decades Central Government Health Scheme is
							providing comprehensive medical care to the Central Government
							employees and pensioners enrolled under the scheme. In fact CGHS
							caters to the healthcare needs of eligible beneficiaries covering
							all four pillars of democratic set up in India namely
							Legislature, Judiciary, Executive and Press. Presently
							approximately 42 lakh beneficiaries are covered by CGHS in 80
							cities all over India and the endeavour is to include more cities
							to improve the accessibility of the services.</p>

						      

							<div class="mission mt-4 d-flex align-items-center justify-content-center">
							<div class="row mt-1">
								   <div class="col-xl-4 col-xxl-3 col-lg-4 col-md-4 col-sm-12 col-12 me-md-0 me-xxl-4 me-xl-0">
                                    <div class="box mb-4 position-relative wow fadeInDown" data-wow-duration="1s">

										<div class="image d-flex align-items-center justify-content-center">
											<img src="/AHIMSG5/hissso/portal/images/vision.jpg"
												class="img-fluid d-flex align-items-center justify-content-center" />
										</div>
										<div class="text px-3">
											<h3 class="mt-3 mb-2 fw-bold" data-lang-key='CGHSVision'>Vision</h3>
											<p data-lang-key='CGHSVisionInfo'>To be the first choice
												in providing quality healthcare services and ensuring
												holistic well being across clients' entire life span.</p>
										</div>
									</div>
								</div>
								  <div class="col-xl-4 col-xxl-3 col-lg-4 col-md-4  col-sm-12 col-12 me-md-0 me-xxl-4 me-xl-0">
                                    <div class="box position-relative wow fadeInDown" data-wow-delay="1s">

										<div class="image  d-flex align-items-center justify-content-center">
											<img src="/AHIMSG5/hissso/portal/images/mission.jpg"
												class="img-fluid" />
										</div>
										<div class="text px-3">
											<h3 class="mt-3 mb-2 fw-bold" data-lang-key='CGHSMission'>Mission</h3>
											<p data-lang-key='CGHSMissionInfo'>Preventive, promotive
												and curative health and wellness services that are
												responsive, accountable and cost effective, providing
												financial risk protection and ensuring healthy lives.</p>
										</div>

									</div>
								</div>
								<div class="col-md-4 bg-gradient">
								<div class="online-support box p-4">
								<div class="heading d-flex align-items-center justify-content-between">
								<h5 class="text-black mb-2 fw-bold" data-lang-key="Moreinfo">More Info</h5>
							
<i class="fa-solid fa-info"></i>
								</div>
								
								
			<p data-lang-key="Moreinfomessage">Presently approximately 42 lakh beneficiaries are covered by CGHS in 80 cities all over India and the endeavour is to include more cities to improve the accessibility of the services.</p>
								  <div class="important">
							   <div class="item d-flex align-items-center wow fadeInRight mb-3 mb-md-3 mb-xl-3">
								  <div class="icon wow fadeInLeft"> <span class="material-symbols-outlined me-2">
                                        location_city </span> </div>
								<div class="fw-semibold">
									<p data-lang-key='CGHSCoveredCities' class="mb-0">CGHS Covered Cities</p>
									<a class="text-decoration-underline d-block fw-regularlevel3" href="javascript:void(0)" onclick="openCustomPopup('content11')"data-lang-key='ClickHere' >
  click here
</a>
								</div>
							</div>

							<div class="item d-flex align-items-center wow fadeInLeft" data-wow-delay="1s">
															<div class="icon">
									<span class="material-symbols-outlined me-2"> check </span>
								</div>
				<div class="fw-semibold">
									<p data-lang-key='FacilitiesUnderCGHS' class="mb-0" >Facilities available
										under CGHS</p>

									<a class="text-decoration-underline d-block fw-regularlevel3" href="javascript:void(0)" onclick="openCustomPopup('content10')"data-lang-key='ClickHere'>
  click here
</a>
								</div>
							</div>



						</div>
								
								
								</div>
								</div>
								
							</div>
						</div>

					</div>

				</div>

			</div></div>
		</div>
	</section>

	<!--Link Carousel-->




	<div id="pdfModal" style="display: none; position: fixed; top: 50%; left: 50%; transform: translate(-50%, -50%) scale(0.95); background: #1f1f1f; border-radius: 16px; width: 90%; width: 1100px; min-width:400px; min-height:400px;height: 90vh; box-shadow: 0 20px 40px rgba(0,0,0,0.6); overflow: hidden; z-index: 10000; animation: popupFadeIn 0.4s ease forwards; color: #fff; resize: both;">
  
  <!-- Modal Header -->
  <div style="background: #272727; padding: 15px 20px; display: flex; align-items: center; justify-content: space-between; position: sticky; top: 0; z-index: 2;">
    <h2 id="pdfModalHeading" style="margin: 0; font-size: 18px; font-weight: bold;">PDF Preview</h2>
    
    <button id="closeModalBtn" style="background: transparent; border: none; color: #fff; font-size: 22px; cursor: pointer; transition: transform 0.3s;">
      <i class="fa-solid fa-xmark"></i>
    </button>
  </div>

  <!-- Modal Content -->
  <div style="padding: 0; height: calc(100% - 60px);">
    <iframe id="pdfIframe" type="application/pdf" frameborder="0" style="width: 100%; height: 100%; border: none; border-radius: 0 0 16px 16px; background: #000;"></iframe>
  </div>
  
</div>



	<!--     <div id="pdfContainer" style="display:none;">
        <iframe id="pdfViewer" width="100%" height="600px"></iframe>
    </div> -->

	<!-- Copyright Start -->

	<footer>
		<div class="container">
	<div
				class="logo-carousel owl-carousel  logos d-lg-flex align-items-center justify-content-end border-bottom border-light border-opacity-25 py-5 wow fadeInUp">
					<div class="item mx-md-3 mx-0 text-center">	
				<a href="https://www.india.gov.in/national-health-portal?page=1"
					target="_blank"><img src="/AHIMSG5/hissso/portal/images/logos/nhp.png" /></a>
					</div>
					 <div class="item mx-md-3 mx-0 text-center"><a
					href="https://www.mygov.in/" target="_blank"><img
					src="/AHIMSG5/hissso/portal/images/logos/mygov.png" /></a> </div>
					<div class="item mx-md-3 mx-0 text-center"><a
					href="https://www.digilocker.gov.in/" target="_blank"> <img
					src="/AHIMSG5/hissso/portal/images/logos/digilocker.png" /></a> </div>
					<div class="item mx-md-3 mx-0 text-center"><a
					href="https://rti.gov.in/" target="_blank"> <img
					src="/AHIMSG5/hissso/portal/images/logos/rti.png" /></a></div><div class="item mx-md-3 mx-0 text-center"> <a
					href="https://pmnrf.gov.in/en/" target="_blank"> <img
					src="/AHIMSG5/hissso/portal/images/logos/national-relief-fund.png" /></a></div>
			</div>
 
			<div class="row mt-5 mb-3">
				<div class="col-md-8 col-xl-8">
					<div class="footer-links">
						<h4 class="" data-lang-key='ImportantLinks'>Important Links</h4>
						    <ul class="list-unstyled pt-3 pb-1 d-lg-flex d-block flex-wrap align-items-md-center justify-content-start footer-linkscon">
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content1')" data-lang-key='PrivacyPolicy'>Privacy Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content3')" data-lang-key='HyperLinkingPolivy'>Hyper Linking Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content4')" data-lang-key='Copyright'>CopyRight Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content5')" data-lang-key='ContentReviewPolicy'>Content Review Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content6')" data-lang-key='ContentContribution'>Content Contribution</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content7')" data-lang-key='ContentArchivalPolicy'>Content Archival Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content8')" data-lang-key='PasswordAuthPolicy'>CGHS Password and Authentication Policy</a></li>
    <li class=""><a href="javascript:void(0)" onclick="openCustomPopup('content9')" data-lang-key='AccessibilityStatement'>Accessibility Statement</a></li>
  
</ul>

					</div>
				</div>
					<div class="col-md-4 col-xl-4">
					<div class="box wow fadeInLeft">
						<p class="m-0 fw-semibold text-white mb-3 ps-2"
							data-lang-key='AlsoAvailableOn'>Also Available On</p>
						<div class="icon flex-wrap flex-md-nowrap d-flex align-items-top  text-center d-flex justify-content-between" style="flex-basis: auto;">
						
						<div class="android mb-2">
						<a href="https://play.google.com/store/apps/details?id=com.cdac.cghsmobileapp" target="_blank"><img src="/AHIMSG5/hissso/portal/images/google-playstore.png" class="mb-2"></a>	
				      <img src="/AHIMSG5/hissso/portal/images/android_qr.png" alt="Android QR Code"  width="100" height="95">
    
    </div>
   <div class="ios mb-2">
   <a href="https://apps.apple.com/in/app/mycghs/id6744057914" target="_blank"><img src="/AHIMSG5/hissso/portal/images/apple-store.png" class="mb-2"></a> 
      <img src="/AHIMSG5/hissso/portal/images/ios_qr.png" alt="iOS QR Code" width="100" height="95">
     
 			</div>	
				
				<div class="connect wow fadeInRight mb-2" style="visibility: visible; animation-name: fadeInRight;">
						<div class="d-flex align-items-center mb-2">
						<a class="mb-1 fw-semibold me-2 text-white" data-lang-key="ConnectWithUs" href="https://www.youtube.com/@cghsindia" target="_blank"></a> 					
						<a href="https://www.youtube.com/@cghsindia" target="_blank">			<img src='/AHIMSG5/hissso/portal/images/youtube.gif'></a> 		
						</div>
							
							
						  <img src="/AHIMSG5/hissso/portal/images/youtube_qr.png" alt="Youtube QR Code" width="100" height="95">
						</div>		
						</div>
					</div>

					
		
			</div>

					
				</div>
			</div>
			


<!-- Add this inside your page to support the animation -->

		</div>
	





<div class="container-fluid copyright">
  <div class="best-viewed text-white text-center py-2">
    <p class="fst-italic p-0 m-0" data-lang-key="BestViewedNote">
      <strong>Note:</strong> Best viewed on the latest versions of 
      <strong>Mozilla Firefox (v125+)</strong> or 
      <strong>Google Chrome (v124+)</strong>, preferably in 
      <em>Incognito/Private Mode</em> for optimal security and performance.
    </p>
    <div class="p-0 m-0" data-lang-key="ScreenResolutionNote">
      Recommended screen resolution: <strong>1366 x 768 pixels</strong> or higher. 
      | Last Updated: <strong>20/06/2025 12:30 PM </strong>
      &nbsp;  
    </div>
   
  <span data-lang-key="Visitors">Visitors:</span> <strong class="website-counter"></strong>
    
      
  </div>
  <div class="row py-2" style="background:#1e1f90">
    <div class="col-md-12 text-center mb-md-0 p-0">
      <div class="disclaimer text-center" data-lang-key="DisclaimerNote">
        Disclaimer: Website content managed by Ministry of Health and
        Family Welfare, GOI Design, Developed and Hosted by Center for
        Development of Advanced Computing 
        <a href="https://cdac.in/" class="fw-bold text-decoration-none text-white" target="_blank">(C-DAC)</a>
      </div>
    </div>
  </div>
</div>

	</footer>


	<div id="custom-popup-overlay"
		class="custom-popup-overlay scrollbar-always">
		
		<div class="custom-popup-content">
			<span class="custom-close-btn d-flex align-items-center justify-content-center" onclick="closeCustomPopup()"><i class="fa-solid fa-xmark"></i></span>
		<div id="custom-popup-content"></div>
		</div>
	</div>



	<div class="modal modalIframe" id="modalFullScreen" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-fullscreen">
			<div class="modal-content">
				<div class="modal-header" style="padding: 0;">
					<div class="container-fluid" style="padding: 3px;">
						<div class="row">
							<div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11"
								style="padding-left: 25px;">
								<img src='/HIS/hisglobal/images/cghs_logo_big.png'
									style='height: 50px;'>
							</div>
							<div class="col-lg-8 col-xl-8 col-md-4 col-sm-4 col-12"
								style="padding-left: 25px; text-align: right;">
								<button type="button" id='closeFullScreenModal'
									class="float-end mt-2 btn btn-sm btn-danger"
									data-bs-toggle="modal" data-bs-target="#modalFullScreen"
									onclick="closeFullScreenModal();">Close</button>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body">
					<iframe src="" id="iframeModalFullScreen"
						style="width: 100%; height: 100%"></iframe>
				</div>
			</div>
		</div>
	</div>
	<a id="button"><span class="material-symbols-outlined">north</span></a>
	<!-- Copyright End -->
	<!-- Back to Top -->
	<!-- accessibility panel -->
	<div class="uwaw uw-light-theme gradient-head uwaw-initial paid_widget"
		id="uw-main" style="z-index: 99999">
		<div class="relative second-panel">
			<h3>Accessibility Options</h3>
			<div class="uwaw-close" onclick="closeMain()"></div>
		</div>
		<div class="uwaw-body">
			<div class="h-scroll">
				<div class="uwaw-features">
					<div class="uwaw-features__item reset-feature" id="featureItem_sp">
						<button id="speak" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-speaker"> </span>
							</span> <span class="uwaw-features__item__name">Text To Speech</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon_sp" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem">
						<button id="btn-s9" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-bigger-text"> </span>
							</span><span class="uwaw-features__item__name">Bigger Text</span>
							<div class="uwaw-features__item__steps reset-steps"
								id="featureSteps">
								<!-- Steps span tags will be dynamically added here -->
							</div>
							<span class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-st">
						<button id="btn-small-text" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-small-text"> </span>
							</span><span class="uwaw-features__item__name">Small Text</span>
							<div class="uwaw-features__item__steps reset-steps"
								id="featureSteps-st">
								<!-- Steps span tags will be dynamically added here -->
							</div>
							<span class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-st" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-lh">
						<button id="btn-s12" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-line-hight"> </span>
							</span> <span class="uwaw-features__item__name">Line Height</span>
							<div class="uwaw-features__item__steps reset-steps"
								id="featureSteps-lh">
								<!-- Steps span tags will be dynamically added here -->
							</div>
							<span class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-lh" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-ht">
						<button id="btn-s10" onclick="highlightLinks()"
							class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-highlight-links"> </span>
							</span> <span class="uwaw-features__item__name">Highlight Links</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-ht" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-ts">
						<button id="btn-s13" onclick="increaseAndReset()"
							class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-text-spacing"> </span>
							</span> <span class="uwaw-features__item__name">Text Spacing</span>
							<div class="uwaw-features__item__steps reset-steps"
								id="featureSteps-ts">
								<!-- Steps span tags will be dynamically added here -->
							</div>
							<span class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-ts" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-df">
						<button id="btn-df" onclick="toggleFontFeature()"
							class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-dyslexia-font"> </span>
							</span> <span class="uwaw-features__item__name">Dyslexia Friendly</span>
							<span class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-df" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature" id="featureItem-hi">
						<button id="btn-s11" onclick="toggleImages()"
							class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-hide-images"> </span>
							</span> <span class="uwaw-features__item__name">Hide Images</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-hi" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature"
						id="featureItem-Cursor">
						<button id="btn-cursor" onclick="toggleCursorFeature()"
							class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-cursor"> </span>
							</span> <span class="uwaw-features__item__name">Cursor</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-cursor" style="display: none"> </span>
						</button>
					</div>
					<div class="uwaw-features__item reset-feature"
						id="featureItem-ht-dark">
						<button id="dark-btn" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__name"> <span
								class="light_dark_icon"> <input type="checkbox"
									class="light_mode uwaw-featugres__item__i" id="checkbox" /> <label
									for="checkbox" class="checkbox-label"> <!-- <i class="fas fa-moon-stars"></i> -->
										<i class="fas fa-moon-stars"> <span
											class="ux4g-icon icon-moon"></span>
									</i> <i class="fas fa-sun"> <span class="ux4g-icon icon-sun"></span>
									</i> <span class="ball"></span>
								</label>
							</span> <span class="uwaw-features__item__name">Light-Dark</span>
							</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-ht-dark"
								style="display: none; pointer-events: none"> </span>
						</button>
					</div>
					<!-- Invert Colors Widget -->
					<div class="uwaw-features__item reset-feature" id="featureItem-ic">
						<button id="btn-invert" class="uwaw-features__item__i"
							data-uw-reader-content="Enable the UserWay screen reader"
							aria-label="Enable the UserWay screen reader"
							aria-pressed="false">
							<span class="uwaw-features__item__icon"> <span
								class="ux4g-icon icon-invert"> </span>
							</span> <span class="uwaw-features__item__name">Invert Colors</span> <span
								class="tick-active uwaw-features__item__enabled reset-tick"
								id="tickIcon-ic" style="display: none"> </span>
						</button>
					</div>
				</div>
			</div>
			<!-- Reset Button -->
		</div>
		<div class="reset-panel">
			<!-- copyright accessibility bar -->
			<div class="copyrights-accessibility">
				<button class="btn-reset-all" id="reset-all" onclick="resetAll()">
					<span class="reset-icon"> </span> <span class="reset-btn-text">Reset
						All Settings</span>
				</button>
			</div>
		</div>
	</div>
	<button id="uw-widget-custom-trigger" class="uw-widget-custom-trigger"
		aria-label="Accessibility Widget" data-uw-trigger="true"
		aria-haspopup="dialog">
		<img
			src="data:image/svg+xml,%0A%3Csvg width='32' height='32' alt='accessibility-options' viewBox='0 0 32 32' fill='none' xmlns='http://www.w3.org/2000/svg'%3E%3Cg clip-path='url(%23clip0_1_1506)'%3E%3Cpath d='M16 7C15.3078 7 14.6311 6.79473 14.0555 6.41015C13.4799 6.02556 13.0313 5.47894 12.7664 4.83939C12.5015 4.19985 12.4322 3.49612 12.5673 2.81719C12.7023 2.13825 13.0356 1.51461 13.5251 1.02513C14.0146 0.535644 14.6383 0.202301 15.3172 0.0672531C15.9961 -0.0677952 16.6999 0.00151652 17.3394 0.266423C17.9789 0.53133 18.5256 0.979934 18.9101 1.55551C19.2947 2.13108 19.5 2.80777 19.5 3.5C19.499 4.42796 19.1299 5.31762 18.4738 5.97378C17.8176 6.62994 16.928 6.99901 16 7Z' fill='white'/%3E%3Cpath d='M27 7.05L26.9719 7.0575L26.9456 7.06563C26.8831 7.08313 26.8206 7.10188 26.7581 7.12125C25.595 7.4625 19.95 9.05375 15.9731 9.05375C12.2775 9.05375 7.14313 7.67875 5.50063 7.21188C5.33716 7.14867 5.17022 7.09483 5.00063 7.05063C3.81313 6.73813 3.00063 7.94438 3.00063 9.04688C3.00063 10.1388 3.98188 10.6588 4.9725 11.0319V11.0494L10.9238 12.9081C11.5319 13.1413 11.6944 13.3794 11.7738 13.5856C12.0319 14.2475 11.8256 15.5581 11.7525 16.0156L11.39 18.8281L9.37813 29.84C9.37188 29.87 9.36625 29.9006 9.36125 29.9319L9.34688 30.0112C9.20188 31.0206 9.94313 32 11.3469 32C12.5719 32 13.1125 31.1544 13.3469 30.0037C13.5813 28.8531 15.0969 20.1556 15.9719 20.1556C16.8469 20.1556 18.6494 30.0037 18.6494 30.0037C18.8838 31.1544 19.4244 32 20.6494 32C22.0569 32 22.7981 31.0162 22.6494 30.0037C22.6363 29.9175 22.6206 29.8325 22.6019 29.75L20.5625 18.8294L20.2006 16.0169C19.9387 14.3788 20.1494 13.8375 20.2206 13.7106C20.2225 13.7076 20.2242 13.7045 20.2256 13.7013C20.2931 13.5763 20.6006 13.2963 21.3181 13.0269L26.8981 11.0763C26.9324 11.0671 26.9662 11.0563 26.9994 11.0438C27.9994 10.6688 28.9994 10.15 28.9994 9.04813C28.9994 7.94625 28.1875 6.73813 27 7.05Z' fill='white'/%3E%3C/g%3E%3Cdefs%3E%3CclipPath id='clip0_1_1506'%3E%3Crect width='32' height='32' fill='white'/%3E%3C/clipPath%3E%3C/defs%3E%3C/svg%3E%0A"><span>Accessibility
			Options</span>
	</button>
	
	<%
    String baseURL = HisUtil.getParameterFromHisPathXML("HIS_BASEURL");
    if (baseURL != null && !baseURL.trim().equals("")) {
    	System.out.println("The BASE URL >>>>> >>>>>>"+ baseURL );
	%>
	    <input type="hidden" id="baseURL" name="baseURL" value="<%= baseURL %>" />
	<%
	    }
	%>
	
	<!-- accessibility panel end-->
	<%
	String portalVersion = SecurityUtil.getMd5Hash(new java.util.Date().toString());
	%>
	 <script type="text/javascript" src="/AHIMSG5/hissso/js/footer_links.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/jquery-3.7.1.min.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/bootstrap.bundle.min.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/weights-v1.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/wow.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/scripts.js?v=<%=portalVersion%>"></script>
	<script src="/AHIMSG5/hissso/portal/js/owl.carousel.min.js"></script>
	<script src="/AHIMSG5/hissso/portal/js/main.js?v=<%=portalVersion%>"></script>
<!--<script src="/AHIMSG5/hissso/portal/js/scripts.js"></script> -->
	<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/share.js"></script>
	<script src='/AHIMSG5/hissso/portal/js/portal.js?v=<%=portalVersion%>'></script> 
	
	
	
	<script>
function animateCounter(targetId, countStr) {
    const container = document.getElementById(targetId);
    container.innerHTML = '';
    for (let digit of countStr) {
        let span = document.createElement('span');
        span.className = 'digit';
        span.textContent = digit;
        span.style.transition = 'transform 0.3s ease';
        span.style.display = 'inline-block';
        span.style.margin = '0 2px';
        span.style.fontWeight = 'bold';
        span.style.color = 'yellow';
        container.appendChild(span);
    }
}

window.addEventListener('DOMContentLoaded', function () {
    fetch('getVisitorCount.do')  // or .action depending on your config
        .then(res => res.json())
        .then(data => {
            if (data.count) {
                animateCounter('visitorCounter', data.count);
            }
        });
});
</script>
	<script>
        $(document).ready(function() {
            let visits = localStorage.getItem("visitCounter");
            if (!visits) {
                visits = 0;
            }
            visits++;
            localStorage.setItem("visitCounter", visits);
            $("#counter").text(visits);

            
        });
<%-- 
        var baseURL = '<%= baseURL %>';
        console.log("Base URL from server:", baseURL); --%>
    </script>
    
    <script>

    function applyLanguage(lang) {
    	  document.querySelectorAll('[data-lang-key]').forEach(el => {
    	    const key = el.getAttribute('data-lang-key');
    	    const text = languageStrings[lang][key];

    	    if (el.tagName === 'INPUT' && 'placeholder' in el) {
    	      el.placeholder = text;
    	    } else {
    	      el.textContent = text;
    	    }
    	  });
    	}
    function benUderCunstruction(message, url) {
     //   alert(message); // Shows an alert with the provided message
     //   window.location.href = url; // Redirects the user to the provided URL
     }
    </script>
    


	<!--JS for Modal Pop up for Footer Links Start  -->
	<script type="text/javascript">


    function openCustomPopup(contentId) {
        let content = '';

        // You can use JSP logic to decide the content dynamically
        if (contentId === 'content1') {
            content = `
            	 <header>
                <h1>Privacy Policy for CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025 | <strong>Last Updated:</strong>  11 March 2025</p>
                          </header>
<div class="content">
<section>
<h2>1. Introduction</h2>
<p>The Central Government Health Scheme (CGHS) is committed to safeguarding the privacy and security of its beneficiaries' personal data. This Privacy Policy outlines the collection, usage, storage, and protection of personal data when using the CGHS website (<a href="http://www.cghs.gov.in">www.cghs.gov.in</a>). Our data handling practices comply with the Information Technology Act, (2000) the Right to Information (RTI) Act, 2005, and applicable Draft Data Protection Rules. The CGHS website conforms to Guidelines for Indian Government Websites (GIGW) 3.0, ensuring quality, security, and accessibility.</p>
</section>

<section>
<h2>2. Accuracy Disclaimer</h2>
<p>Though all efforts have been made to ensure the accuracy of the content on this website, the same should not be construed as a statement of law or used for any legal purposes. The Central Government Health Scheme accepts no responsibility in relation to the accuracy, completeness, usefulness, or otherwise, of the contents. Users are advised to verify/check any information and obtain appropriate professional advice before acting on the information provided on this website.</p>
</section>

<section>
<h2>3. Data Collection & Processing</h2>
<p>When you fill the online CGHS Card application form, we collect and process:</p>
<ul>
    <li><strong>Personal Identification Data:</strong> Name, age, date of birth, gender.</li>
    <li><strong>Contact Details:</strong> Address, mobile number, email ID.</li>
    <li><strong>Identity & Verification Documents:</strong> PAN card, Voter ID, passport details etc.</li>
    <li><strong>Employment & Financial Data:</strong> Salary slip, employment details, pension information.</li>
    <li><strong>Nominee Details:</strong> Information of individuals nominated under CGHS benefits.</li>
    <li><strong>Transaction & Contribution Data:</strong> History of CGHS contributions and payment records.</li>
    <li><strong>Device & Log Data:</strong> IP address, browser type, operating system details, timestamps, and session activity.</li>
</ul>
</section>

<section>
<h2>4. Conformity with GIGW 3.0</h2>
<p>The CGHS website follows GIGW 3.0 guidelines, ensuring:</p>
<ul>
    <li><strong>User-Centric Design & Accessibility:</strong> Compliance with Web Content Accessibility Guidelines (WCAG 2.1, Level AA) for people with disabilities.</li>
    <li><strong>API Integrations:</strong> Secure linkage with DigiLocker, PAN verification, BharatKosh, UTI-ITSL Single-Sign-On (SSO), and other government platforms.</li>
    <li><strong>Security Standards:</strong> Protection against unauthorized access, cyber threats, and data breaches as per ISO 27001, OWASP security guidelines, and CERT-In advisories.</li>
    <li><strong>Regular Audit & Compliance Checks:</strong> The CGHS website undergoes STQC website quality certification and cybersecurity audits.</li>
    <li><strong>Multilingual Support:</strong> Ensuring accessibility to beneficiaries in multiple Indian languages.</li>
</ul>
</section>

<section>
<h2>5. Consent & Legal Basis for Data Processing</h2>
<p>By consenting to the use of the CGHS website for card application and login-based CGHS beneficiary services, you consent to the collection and processing of your data for:</p>
<ul>
    <li>Verification & Authentication of CGHS beneficiaries.</li>
    <li>Processing financial transactions & nominee details.</li>
    <li>Security, fraud prevention & cybersecurity measures.</li>
    <li>Service-related updates.</li>
</ul>
</section>

<section>
<h2>6. Data Sharing & Third-Party Disclosure</h2>
<p>CGHS does not sell, rent, or trade your personal data. However, we may disclose data under the following circumstances:</p>
<ul>
    <li><strong>Legal & RTI Requests:</strong> Personal data is exempt from disclosure under Section 8(1)(e) and Section 8(1)(j) of the RTI Act. If required by law, CGHS will redact confidential details under Section 10 before sharing.</li>
    <li><strong>Government Authorities & Audits:</strong> Data may be shared for policy implementation, audits, and compliance.</li>
    <li><strong>Third-Party Service Providers:</strong> External vendors handling data storage, IT services, and payment processing must comply with CGHS data protection agreements.</li>
</ul>
</section>

<section>
<h2>7. Data Retention & Security Measures</h2>
<p>CGHS follows strict data retention & security protocols:</p>
<ul>
    <li><strong>Retention Period:</strong> Personal data shall be retained only for the duration necessary for its purpose, as detailed in the department&#8217;s record retention policy, after which it is securely deleted.</li>
    <li><strong>Encryption:</strong> All stored and transmitted data is secured using AES-256 encryption.</li>
    <li><strong>Access Controls:</strong> Multi-factor authentication (MFA) restricts access to authorized personnel only.</li>
    <li><strong>Regular Security Audits:</strong> Periodic evaluations to prevent cyber threats & vulnerabilities.</li>
</ul>
</section>

<section>
<h2>8. User Rights</h2>
<p>CGHS beneficiaries have the right to:</p>
<ul>
    <li>Access their stored personal data.</li>
    <li>Request correction or updates to inaccurate data.</li>
    <li>Request data in a structured, machine-readable format.</li>
    <li>Request deletion of personal data, subject to legal obligations.</li>
    <li>Opt-out of non-essential notifications & analytics tracking.</li>
    <li>File complaints with CGHS.</li>
</ul>
</section>

<section>
<h2>9. Contact Information</h2>
<p>For privacy concerns, contact toll free CGHS Helpline Number at <a href="tel:1800-208-8900">1800-208-8900</a> or write to us at <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a>.</p>
</section>
</div>
            
            `;
        } else if (contentId === 'content2') {
            content = `
            	<header>
                <h1>Disclaimer for the CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025 | <strong>Last Updated:</strong> 11 March 2025</p>
                 </header>
            <div class="content">
            <section>
                <h2>1. General Disclaimer</h2>
                <p>The Central Government Health Scheme (CGHS) website is provided as a public service to disseminate information regarding CGHS services, policies, and beneficiary-related matters. While every effort is made to ensure the accuracy and reliability of the content, the CGHS does not guarantee the completeness, correctness, or timeliness of the information provided on this website.</p>
                <p>Users are advised to verify any official announcements, policies, or updates through authorized government sources before making decisions based on the content of this website.</p>
            </section>

            <section>
                <h2>2. Accuracy and Reliability of Information</h2>
                <p>CGHS endeavors to keep the information on this website accurate and up to date; however, errors may occur due to technical, administrative, or regulatory updates. CGHS does not assume any legal liability or responsibility for any errors, omissions, or discrepancies in the website content.</p>
                <p>Information on this website:</p>
                <ul>
                    <li>Is subject to change without prior notice.</li>
                    <li>Should not be considered legally binding unless specifically stated in government circulars or notifications.</li>
                    <li>May be interpreted differently based on specific individual or organizational circumstances.</li>
                </ul>
            </section>

            <section>
                <h2>3. External Links and Third-Party Content</h2>
                <p>This website may provide links to external websites operated by other government agencies, organizations, or third parties for informational purposes. The inclusion of such links does not imply:</p>
                <ul>
                    <li>Endorsement of the linked site or its content.</li>
                    <li>Responsibility for the accuracy or security of third-party sites.</li>
                </ul>
                <p>CGHS does not guarantee the accessibility, availability, or reliability of external links and is not responsible for any data security, privacy concerns, or damages resulting from the use of third-party websites. Users are encouraged to review the privacy policies and terms of service of external websites before accessing or sharing personal information.</p>
            </section>

            <section>
                <h2>4. Security and Technical Issues Disclaimer</h2>
                <p>CGHS implements industry-standard security measures to safeguard user data and ensure website functionality. However, CGHS does not guarantee:</p>
                <ul>
                    <li>That the website will always operate without disruption, delays, or security vulnerabilities.</li>
                    <li>That the website is free from viruses, malware, or cyber threats.</li>
                    <li>That unauthorized third parties will not gain unauthorized access to user information despite security measures in place.</li>
                </ul>
                <p>Users are responsible for ensuring their own cybersecurity measures, such as using updated antivirus software, secure connections, and verifying website authenticity before entering sensitive data.</p>
            </section>

            <section>
                <h2>5. No Professional or Legal Advice</h2>
                <p>The information provided on this website is for general informational purposes only and does not constitute:</p>
                <ul>
                    <li>Medical advice or guidance on health treatments.</li>
                    <li>Legal consultation for disputes or government policies.</li>
                    <li>Financial advice on payments, benefits, or transactions.</li>
                </ul>
                <p>Beneficiaries and users are encouraged to consult licensed professionals, government officials, or authorized representatives for personalized assistance.</p>
            </section>

            <section>
                <h2>6. Limitation of Liability</h2>
                <p>Under no circumstances shall CGHS, the Ministry of Health & Family Welfare, its employees, or affiliated government agencies be liable for:</p>
                <ul>
                    <li>Direct, indirect, incidental, or consequential damages resulting from website use.</li>
                    <li>Loss of data, financial loss, or service interruptions due to website downtime.</li>
                    <li>User decisions or actions based on information obtained from this website.</li>
                </ul>
                <p>Users accessing this website do so at their own risk and acknowledge that CGHS does not guarantee uninterrupted service, absolute security, or the absence of technical errors.</p>
            </section>

            <section>
                <h2>7. Changes to the Disclaimer</h2>
                <p>CGHS reserves the right to modify, update, or remove any part of this disclaimer without prior notice. Users are encouraged to review this disclaimer periodically to remain informed of any changes.</p>
            </section>

            <section>
                <h2>8. Contact Information</h2>
                <p>For queries regarding this disclaimer, users may contact:</p>
                <p>Email: <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a></p>
                <p>Helpline: <a href="tel:1800-208-8900">1800-208-8900</a></p>
                <p>This disclaimer is issued in accordance with government policies, cybersecurity regulations, and the Guidelines for Indian Government Websites (GIGW 3.0).</p>
            </section>
                </div>    

                
            `;
        }

        else if (contentId === 'content3') {
            content = `
            	<header>
                <h1>Hyperlinking Policy</h1>
                      </header>
            	<div class="content">
            	<section>
            	<h2>1. Introduction</h2>
                <p>This Hyperlinking Policy outlines the guidelines for linking to and from the Central Government Health Scheme (CGHS) website (<a href="https://www.cghs.mohfw.gov.in" target="_blank">www.cghs.mohfw.gov.in</a>).</p>
                </section>
             	<section>
                <h2>2. Linking to the CGHS Website</h2>
                <ul>
                    <li>The link must not misrepresent the CGHS website or create an impression of endorsement or affiliation where none exists.</li>
                    <li>Links should be direct to the CGHS homepage or specific service pages, without altering the original content.</li>
                    <li>No website shall frame or replicate CGHS content in a way that could mislead users.</li>
                    <li>Websites that link to CGHS must not contain defamatory, misleading, or unlawful content.</li>
                    <li>Any entity wishing to use CGHS logos, branding, or official symbols must obtain prior written permission from CGHS.</li>
                </ul>
                </section>
             	<section>
                <h2>3. Linking from the CGHS Website</h2>
                <p>The CGHS website may include links to external websites for user convenience. These may include:</p>
                <ul>
                    <li>Government websites, including ministries, health departments, and public sector organizations.</li>
                    <li>Recognized healthcare institutions and regulatory bodies.</li>
                    <li>Other relevant resources that align with CGHS s objectives.</li>
                </ul>
                <p>However:</p>
                <ul>
                    <li>CGHS does not endorse or guarantee the accuracy, reliability, or security of third-party websites.</li>
                    <li>External links are provided solely for informational purposes.</li>
                    <li>CGHS is not responsible for third-party website policies, privacy measures, or content changes.</li>
                </ul>
                </section>
             	<section>
                <h2>4. Prohibited Practices</h2>
                <ul>
                    <li>Deep linking, embedding, or modifying CGHS content in a way that misleads users.</li>
                    <li>Using CGHS hyperlinks on websites that host illegal, obscene, or defamatory content.</li>
                    <li>Implying official endorsement or affiliation without written approval.</li>
                    <li>Linking to the CGHS website for commercial purposes without express permission.</li>
                </ul>
                </section>
             	<section>
                <h2>5. Request for Linking Permission</h2>
                <p>Organizations or individuals who wish to:</p>
                <ul>
                    <li>Link to CGHS using official branding, logos, or graphics.</li>
                    <li>Embed specific CGHS web pages in portals or applications.</li>
                    <li>Obtain approval for link placement on CGHS s digital platforms.</li>
                </ul>
                <p>Must submit a formal request to:</p>
                <p><strong>Email:</strong> <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a></p>
                <p><strong>Helpline:</strong> 1800-208-8900</p>
                <p><strong>Address:</strong> &nbsp; MS Flats Rd, Sector 13 R K Puram, Sector 13, Rama Krishna Puram, New Delhi, Delhi 110022</p>
                </section>
             	<section>
                <h2>6. Disclaimer and Liability</h2>
                <ul>
                    <li>CGHS reserves the right to withdraw linking permissions at any time.</li>
                    <li>CGHS does not assume responsibility for any consequences resulting from accessing external links.</li>
                    <li>CGHS will not be liable for damages resulting from the use or inability to use hyperlinks provided on its website.</li>
                </ul>
                </section>
             	<section>
                <h2>7. Policy Updates</h2>
                <p>This Hyperlinking Policy is subject to periodic review. Users are encouraged to review this page for the latest updates.</p>
                </section>
             	<section>
                <h2>Compliance Statement</h2>
                <p>This Hyperlinking Policy ensures that CGHS hyperlinks are used responsibly and securely. CGHS remains committed to maintaining clear, lawful, and secure digital interactions across platforms.</p>
                </section></div>
                `;
        }

        else if (contentId === 'content4') {
            content = `
            	<header><h1>Copyright Policy for CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025 | <strong>Last Updated:</strong> 11 March 2025</p></header>
                <div class="content">
                <section>
                <h2>1. Ownership of Content</h2>
                <p>All content, including but not limited to text, images, graphics, logos, documents, videos, software, and digital materials available on the Central Government Health Scheme (CGHS) website (<a href="https://www.cghs.mohfw.gov.in" target="_blank">www.cghs.mohfw.gov.in</a>) is the intellectual property of the Government of India and CGHS, unless otherwise stated. This content is protected under the Copyright Act, 1957 (India), international copyright treaties, and applicable intellectual property laws.</p>
                </section>
                <section>
                <h2>2. Permitted Use</h2>
                <p>Users may:</p>
                <ul>
                    <li>Access and use the content for personal, informational, and non-commercial purposes.</li>
                    <li>Download and print materials such as government circulars, policies, and beneficiary guidelines, provided they are used without modification and with appropriate attribution to CGHS.</li>
                    <li>Share official government notifications from the website for educational or administrative purposes, as long as they are not altered or misrepresented.</li>
                </ul>
                </section>
                <section>
                <h2>3. Prohibited Use</h2>
                <p>Users are strictly prohibited from:</p>
                <ul>
                    <li>Modifying or creating derivative works based on the websiteÃÂ¢Ã¢ÂÂ¬Ã¢ÂÂ¢s content without prior written permission from CGHS.</li>
                    <li>Using CGHS logos, emblems, trademarks, or any other branding elements without official authorization.</li>
                    <li>Commercializing any website content by selling, licensing, or incorporating it into third-party products or services.</li>
                    <li>Embedding CGHS content in external websites in a way that misrepresents the original source.</li>
                </ul>
                </section>
                <section>
                <h2>4. Copyright Infringement and Reporting Mechanism</h2>
                <p>CGHS respects the intellectual property rights of others and expects users to do the same. If you believe that any content on the CGHS website infringes your copyright, you may report the violation by providing the following details:</p>
                <ul>
                    <li>A description of the copyrighted work allegedly being infringed.</li>
                    <li>The URL or location of the infringing content on the CGHS website.</li>
                    <li>Your contact details (name, email, phone number).</li>
                    <li>A declaration of good faith that you have the authority to report the claim.</li>
                </ul>
                <p><strong>Contact for Copyright Concerns:</strong></p>
                <p>Email: <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a></p>
                <p>Helpline: 1800-208-8900</p>
                </section>
                <section>
                <h2>5. Use of Third-Party Content</h2>
                <p>The CGHS website may contain content, references, or links to external resources owned by third parties, including government reports, external research papers, and collaborative materials. The copyright of such content remains with the respective owners, and:</p>
                <ul>
                    <li>CGHS does not claim ownership over third-party content.</li>
                    <li>Any third-party content used on the website is either under a valid license, permitted by law, or with appropriate attribution.</li>
                    <li>Users must refer to the respective third-party copyright policies before using such content.</li>
                </ul>
                </section>
                <section>
                <h2>6. Disclaimer of Liability</h2>
                <p>While all efforts have been made to ensure the accuracy and reliability of content on the CGHS website, the Government of India and CGHS are not responsible for any unauthorized reproduction, distribution, or misuse of website materials by third parties. Users accessing or using the website&#8217;s content do so at their own discretion and risk.</p>
                </section>
                <section>
                <h2>7. Enforcement and Legal Actions</h2>
                <p>Any unauthorized use or violation of this Copyright Policy may result in:</p>
                <ul>
                    <li>Legal action under applicable copyright laws, including the Copyright Act, 1957.</li>
                    <li>Blocking of access to CGHS services for users found in violation.</li>
                    <li>Issuance of takedown notices to infringing parties under the Information Technology Act, 2000.</li>
                </ul>
                </section>
                <section>
                <h2>8. Policy Updates</h2>
                <p>This Copyright Policy is subject to periodic review and updates. Users are encouraged to review this policy regularly to stay informed about their rights and obligations.</p>
                </section>
                <section>
                <h2>Compliance Statement</h2>
                <p>This Copyright Policy ensures that the intellectual property of CGHS and the Government of India is protected and used in accordance with applicable copyright laws and digital governance standards. Users are expected to respect these guidelines while accessing and utilizing the CGHS website and its content.</p>
</section></div>

                `;}
        else if (contentId === 'content5') {
            content = `
            	<header><h1>Content Review Policy</h1></header>
<div class="content">
<scetion>
                <h2>1. Purpose</h2>
                <p>The Content Review Policy ensures that all content on the CGHS website remains accurate, relevant, and compliant with the Guidelines for Indian Government Websites (GIGW) 3.0.</p>
</section>
<section>
                <h2>2. Review Frequency</h2>
                <ul>
                    <li><strong>Quarterly Reviews:</strong> All general website content is reviewed every three months.</li>
                    <li><strong>Bi-Annual Reviews:</strong> Critical healthcare-related information, eligibility criteria, and beneficiary services undergo a detailed review every six months.</li>
                    <li><strong>Annual Compliance Reviews:</strong> A full content audit is conducted once a year to ensure adherence to GIGW 3.0, cybersecurity, and accessibility standards.</li>
                </ul>
                </section>
                <section>
                <h2>3. Review Process</h2>
                <ul>
                    <li>The <strong>Content Management Team</strong> is responsible for identifying content requiring updates or removal.</li>
                    <li>The <strong>Technical & Cybersecurity Team</strong> ensures all security protocols are maintained in line with CERT-In recommendations.</li>
                    <li>Any content update request must be submitted for approval by the <strong>Webmaster</strong> and CGHS Compliance Team.</li>
                </ul>
                </section>
                <section>
                <h2>4. Corrections & Updates</h2>
                <ul>
                    <li>Any factual inaccuracies identified during the review process will be corrected immediately.</li>
                    <li>Any new updates, policies, or guidelines mandated by the government will be added within five working days of notification.</li>
                    <li>If an urgent correction is required (such as a security concern or incorrect beneficiary information), it will be implemented within 24 hours.</li>
                </ul>
                </section>
                <section>
                <h2>Compliance Statement</h2>
                <p>CGHS ensures compliance with data protection laws, cybersecurity best practices, and GIGW 3.0 standards, keeping all published content accurate, secure, and accessible to beneficiaries.</p>
</div>

                `;}
        else if (contentId === 'content6') {
            content = `
            	<header><h1>Content Contribution, Moderation & Approval Policy</h1></header>
            	<div class="content">
            	 <section>
                <h2>1. Purpose</h2>
                <p>This policy governs how content is contributed, moderated, and approved for publication on the CGHS website, ensuring accuracy, reliability, and adherence to government communication standards.</p>
                </section>
                <section>
                <h2>2. Content Contribution Guidelines</h2>
                <ul>
                    <li>Content contributions are allowed only from authorized CGHS personnel.</li>
                    <li>Contributors must ensure that all information aligns with CGHS policies and government guidelines.</li>
                    <li>Submissions must include appropriate references and citations where necessary.</li>
                </ul>
                </section>
                <section>
                <h2>3. Moderation Process</h2>
                <ul>
                    <li>A <strong>Content Moderation Team</strong> will review all submitted content for factual accuracy, grammar, and compliance with security and accessibility standards.</li>
                    <li>Any submissions containing sensitive or restricted information will undergo additional scrutiny by the CGHS Compliance Team.</li>
                    <li>User-generated content, such as comments or inquiries, will be monitored and moderated to maintain decorum and accuracy.</li>
                </ul>
                </section>
                <section>
                <h2>4. Content Approval Workflow</h2>
                <ul>
                    <li><strong>Step 1: Submission</strong>  Authorized personnel submit content through the CGHS Content Management System.</li>
                    <li><strong>Step 2: Review</strong>  Moderation Team checks content for accuracy and compliance.</li>
                    <li><strong>Step 3: Approval</strong>  The Webmaster and Designated Officials approve the content for publication.</li>
                    <li><strong>Step 4: Publication</strong>  Approved content is published on the CGHS website.</li>
                </ul></section>
</div>

                `;}
        else if (contentId === 'content7') {
            content = `
                      
            	<header> <h1>Content Archival Policy</h1></header>
       <div class="content">
                <section>
                <h2>1. Purpose</h2>
                <p>The Content Archival Policy of the Central Government Health Scheme (CGHS) ensures that digital content on the CGHS website is periodically reviewed, archived, and managed to maintain relevance, accuracy, and compliance with legal and regulatory requirements.</p>
             	</section>
             	<section>
                <h2>2. Archival Guidelines</h2>
                <ul>
                    <li>All web content will be reviewed every year to ensure its continued relevance.</li>
                    <li>Content that is no longer applicable or outdated will be archived for a minimum of five years before deletion.</li>
                    <li>Content of historical importance, government circulars, policy updates, and beneficiary guidelines will be permanently archived for reference.</li>
                    <li>Archived content will be securely stored and accessible upon request through official CGHS channels.</li>
                </ul>
                </section>
             	<section>
                <h2>3. Responsibilities</h2>
                <ul>
                    <li>The <strong>Web Administrator</strong> is responsible for identifying outdated content for archival.</li>
                    <li>The <strong>CGHS Content Management Team</strong> will oversee the periodic content review process.</li>
                    <li>Archived content retrieval requests must be approved by the <strong>CGHS Content Oversight Committee</strong>.</li>
                </ul></section>
</div>
                `;}


        else if (contentId === 'content8') {
            content = `
            	<header> <h1>CGHS Password and Authentication Policy</h1></header>
<div class="content">
            	<section>
            <h2>1. Purpose</h2>
                <p>This policy establishes the requirements for password security and authentication mechanisms within the Central Government Health Scheme (CGHS). It aims to ensure the protection of user accounts, prevent unauthorized access, and uphold data integrity and confidentiality.</p>
                </section>
                <section>
                <h2>2. Authentication Mechanism</h2>
                <p>CGHS employs <strong>Single Sign-On (SSO)</strong> authentication through <strong>MeriPehchaan</strong>, the national digital identity platform, to ensure secure and seamless access to CGHS services.</p>

                <h3 class="mt-2">Primary Authentication Methods:</h3>
                <ul>
                    <li><strong>MeriPehchaan SSO Login:</strong> Recommended for beneficiaries and employees for centralized access control.</li>
                    <li><strong>Username & Password-Based Authentication:</strong> Used for non-SSO CGHS users, including internal personnel.</li>
                    <li><strong>Multi-Factor Authentication (MFA):</strong> Mandatory for administrators and privileged accounts to enhance security.</li>
                </ul>
                </section>
                <section>
                <h2>3. Password Policy for Non-SSO Users</h2>
                
                <h3 class="mt-2">3.1 Password Complexity Requirements</h3>
                <ul>
                    <li>Minimum password length: 12 characters (maximum 20 characters).</li>
                    <li>Must contain at least one uppercase letter (A-Z).</li>
                    <li>Must contain at least one lowercase letter (a-z).</li>
                    <li>Must include at least one numeric digit (0-9).</li>
                    <li>Must have at least one special character (@ $ # ? _ % & !).</li>
                    <li>Must not contain the user&#8217;s name, ID, or commonly used dictionary words.</li>
                </ul>

                <h3>3.2 Password Expiration and Rotation</h3>
                <ul>
                    <li>Passwords must be changed every 90 days.</li>
                    <li>Users will receive password expiration reminders 10 days prior to expiration.</li>
                    <li>New passwords must not match any of the last five previously used passwords.</li>
                </ul>

                <h3>3.3 Account Lockout and Recovery</h3>
                <ul>
                    <li>Accounts will be locked after five consecutive failed login attempts for CGHS staff.</li>
                    <li>Beneficiary accounts will be locked after ten failed login attempts.</li>
                    <li>Locked accounts can only be reset through registered email/SMS OTP verification.</li>
                </ul>
                </section>
                <section>
                <h2>4. Multi-Factor Authentication (MFA) Policy</h2>
                <ul>
                    <li>MFA is mandatory for all CGHS administrators and employees.</li>
                    <li>MFA is enabled for beneficiaries through OTP-based authentication via MeriPehchaan SSO.</li>
                    <li>Additional authentication factors, such as biometric verification, may be implemented in future security enhancements.</li>
                </ul>
                </section>
                <section>
                <h2>5. Single Sign-On (SSO) via MeriPehchaan</h2>
                <p>CGHS encourages users to authenticate via <strong>MeriPehchaan</strong>, which provides:</p>
                <ul>
                    <li>Secure identity verification using Aadhaar, DigiLocker, or mobile OTP authentication.</li>
                    <li>Centralized access control, reducing password fatigue and the need for multiple logins.</li>
                    <li>Enhanced security through passwordless authentication.</li>
                    <li>Direct integration with CGHS e-Services to ensure seamless user experience.</li>
                </ul>
                </section>
                <section>
                <h2>6. Password Storage and Confidentiality</h2>
                <ul>
                    <li>Passwords must never be shared with others, including IT personnel.</li>
                    <li>Passwords must be stored securely, using encryption and industry-standard hashing techniques.</li>
                    <li>Administrators must enforce password hashing and salting mechanisms to mitigate security risks.</li>
                </ul>
                </section>
                <section>
                <h2>7. Password Reset and Recovery</h2>
                <ul>
                    <li>Self-service password reset is available through registered email/SMS OTP verification.</li>
                    <li>SSO users must reset their credentials via MeriPehchaan&#8217;s account recovery process.</li>
                    <li>Additional biometric or multi-factor authentication may be required for critical system access resets.</li>
                </ul>
                </section>
                <section>
                <h2>8. System Administrator Responsibilities</h2>
                <ul>
                    <li>Implement role-based access control (RBAC) to enforce least privilege principles.</li>
                    <li>Conduct regular security audits to ensure compliance with password policies.</li>
                    <li>Monitor login activities and enforce adaptive authentication for suspicious login attempts.</li>
                </ul>
                </section>
                <section>
                <h2>9. Compliance and Enforcement</h2>
                <ul>
                    <li>Failure to comply with this policy may result in account suspension or restricted access.</li>
                    <li>Periodic security awareness training will be conducted for all CGHS users.</li>
                    <li>Regular security audits will be performed to ensure continued compliance with government cybersecurity policies.</li>
                </ul></section>
</div>
                `;}
        else if (contentId === 'content9') {
            content = `
            	<header><h1>Accessibility Statement for CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025 | <strong>Last Updated:</strong> 11 March 2025</p>
              </header>
<div class="content">
<section>
                <h2>1. Commitment to Accessibility</h2>
                <p>The Central Government Health Scheme (CGHS) is dedicated to ensuring that its digital services are accessible to all users, regardless of device, technology, or ability. Our objective is to provide an inclusive and seamless user experience across various platforms, including desktop computers, laptops, and web-enabled mobile devices.</p>
                <p>Recognizing the importance of accessibility, CGHS has integrated features to accommodate users with visual, auditory, motor, and cognitive disabilities. Assistive technologies such as screen readers, screen magnifiers, and keyboard navigation tools are supported to enhance accessibility.</p>
                </section>
                <section>
                <h2>2. Compliance with Accessibility Standards</h2>
                <p>The CGHS website has been developed in adherence to <strong>Guidelines for Indian Government Websites (GIGW) 3.0</strong> and follows universal design principles to ensure usability for all visitors. The website is built using <strong>XHTML 1.0 Transitional</strong> and complies with <strong>Level AAA of the Web Content Accessibility Guidelines (WCAG) 2.1</strong>, as established by the <strong>World Wide Web Consortium (W3C)</strong>.</p>

                <h3 class="mt-2">The CGHS website ensures:</h3>
                <ul>
                    <li><strong>User-Centric Design & Accessibility:</strong> Optimized for screen readers and keyboard navigation.</li>
                    <li><strong>API Integrations:</strong> Secure connectivity with India Portal, DigiLocker, Aadhaar-based identity verification, Single-Sign-On (SSO), MyGov, and other government platforms.</li>
                    <li><strong>Security & Compliance:</strong> Compliance with ISO 27001, OWASP security protocols, and CERT-In cybersecurity advisories.</li>
                    <li><strong>Multilingual Support:</strong> Availability in multiple Indian languages to cater to diverse users.</li>
                    <li><strong>Regular Audits & Compliance Checks:</strong> Subject to STQC certification and periodic accessibility assessments.</li>
                </ul>
                </section>
                <section>
                <h2>3. Scope of Accessibility</h2>
                <p>This accessibility statement applies to all publicly available sections of the CGHS website, including:</p>
                <ul>
                    <li>Healthcare service information</li>
                    <li>Beneficiary login</li>
                    <li>Online payment and contribution portals</li>
                    <li>Government notifications and circulars</li>
                    <li>Feedback mechanisms and contact support</li>
                </ul>
                <p>While every effort has been made to enhance accessibility, some Portable Document Format (PDF) files may not yet be fully accessible. Work is ongoing to improve their accessibility.</p>
                </section>
                <section>
                <h2>4. Accessibility Features</h2>
                <p>To support users with disabilities, the CGHS website incorporates the following accessibility features:</p>
                <ul>
                    <li><strong>Keyboard Navigation:</strong> Enables full website navigation using only a keyboard.</li>
                    <li><strong>Screen Reader Compatibility:</strong> Fully functional with NVDA, JAWS, and TalkBack.</li>
                    <li><strong>Alternative Text Descriptions:</strong> Ensures all significant images and non-text content are accompanied by appropriate descriptions.</li>
                    <li><strong>High Contrast Mode:</strong> Enhances readability for visually impaired users.</li>
                    <li><strong>Adjustable Text Size:</strong> Allows users to modify font sizes for better visibility.</li>
                    <li><strong>Skip to Main Content Link:</strong> Facilitates direct navigation to primary content, bypassing repetitive elements.</li>
                    <li><strong>Accessible Forms & Captions:</strong> Ensures proper structuring of online forms and captions for multimedia content.</li>
                </ul>
                </section>
                <section>
                <h2>5. External Websites & Third-Party Content</h2>
                <p>Certain sections of this website contain links to external websites, which are maintained by their respective government departments. CGHS is not responsible for the accessibility compliance of external websites, as their accessibility is managed by the respective entities.</p>
                </section>
                <section>
                <h2>6. Reporting Accessibility Issues</h2>
                <p>We are committed to maintaining an accessible digital platform. If you encounter any accessibility barriers or have suggestions for improvement, please contact us:</p>
                <ul>
                    <li><strong>Email:</strong> <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a></li>
                    <li><strong>Helpline:</strong> 1800-208-8900</li>
                    <li><strong>Feedback Form:</strong> <a href="[Insert Feedback Form URL]">[Insert Link to Feedback Form]</a></li>
                </ul>
                <p>We aim to acknowledge all accessibility-related inquiries within five working days and provide an alternative means of accessing the requested content if necessary.</p>
                </section>
                <section>
                <h2>7. Future Accessibility Enhancements</h2>
                <p>CGHS is actively enhancing its accessibility framework through:</p>
                <ul>
                    <li>Biennial accessibility audits to identify and rectify issues.</li>
                    <li>Implementation of AI-powered accessibility solutions.</li>
                    <li>Expansion of voice-assisted and screen reader-compatible functionalities.</li>
                    <li>Optimization of mobile and tablet accessibility features.</li>
                </ul>
                <p>We encourage users to share feedback to help us improve the accessibility of CGHS services.</p>
                </section>
                <section>
                <h2>Compliance Statement</h2>
                <p>CGHS remains committed to fostering universal digital access and ensuring that all individuals, regardless of their abilities, can interact with our online services efficiently. The CGHS website follows globally recognized web accessibility, usability, and inclusive design principles to uphold equal access to critical healthcare information and services.</p>
</section>
                </div>
                
                `;}

        else if (contentId === 'content10') {
            content = `
            	<div class="content" style="background: #f9f9f9; border: 1px solid #ddd; padding: 20px; border-radius: 10px; box-shadow: 0 2px 8px rgba(0,0,0,0.05); font-family: Arial, sans-serif;">
            	  <h3 style="color: #38843a; margin-bottom: 16px;">Facilities available under CGHS</h3>
            	  <ul style="padding-left: 20px; margin: 0; color: #333; line-height: 1.7;">
            	    <li style="margin-bottom: 10px;">OPD Treatment at WCs including issue of medicines.</li>
            	    <li style="margin-bottom: 10px;">Specialist Consultation at Polyclinic/Govt. Hospitals and at CGHS empanelled hospitals after referral by CGHS.</li>
            	    <li style="margin-bottom: 10px;">OPD/ Indoor treatment at Government and empanelled Hospitals.</li>
            	    <li style="margin-bottom: 10px;">Investigations at Government and empanelled Diagnostic centers.</li>
            	    <li style="margin-bottom: 10px;">Cashless facility available for treatment in empanelled hospitals and diagnostic centers for <span style="color: #ed1848;">Pensioners</span> and other identified beneficiaries.</li>
            	    <li style="margin-bottom: 10px;">Reimbursement of expenses for treatment availed in Govt. /Private Hospitals under emergency and specific treatment advised by Govt. Specialist or Specialist of Pvt. HCOs duly endorsed by CMO/MO of WCs.</li>
            	    <li style="margin-bottom: 10px;">Reimbursement of expenses incurred for purchase of hearing aids, artificial limbs, appliances etc., after obtaining permission.</li>
            	    <li style="margin-bottom: 10px;">Family Welfare, Maternity and Child Health Services.</li>
            	    <li style="margin-bottom: 10px;">Medical consultation. Dispensing of medicines in <span style="color: #38843a;">Ayurveda, Homeopathy, Unani and Siddha</span> system of medicines (AYUSH).</li>
            	  </ul>
            	</div> 

                
            `;
        }
        else if (contentId === 'content11') {
            content = `
            	<div class="content" style="background: #f9f9f9; border: 1px solid #ddd; padding: 20px; border-radius: 10px; box-shadow: 0 2px 8px rgba(0,0,0,0.05); font-family: Arial, sans-serif;">
            	  <h3 style="color: #38843a; margin-bottom: 16px;">CGHS Covered Cities</h3>
            	  <ol style="padding-left: 20px; margin: 0; color: #333; line-height: 1.7;">
            	    <li>Agra</li>
            	    <li>Agartala</li>
            	    <li>Ahmedabad</li>
            	    <li>Aizwal</li>
            	    <li>Ajmer</li>
            	    <li>Aligarh</li>
            	    <li>Allahabad (Prayagraj)</li>
            	    <li>Ambala</li>
            	    <li>Amritsar</li>
            	    <li>Baghpat</li>
            	    <li>Bengaluru</li>
            	    <li>Bareilly</li>
            	    <li>Behrampur</li>
            	    <li>Bhopal</li>
            	    <li>Bhubaneshwar</li>
            	    <li>Chandrapur</li>
            	    <li>Chandigarh</li>
            	    <li>Chhatrapati Sambhaji Nagar (Aurangabad)</li>
            	    <li>Chennai</li>
            	    <li>Chhapra</li>
            	    <li>Coimbatore</li>
            	    <li>Cuttack</li>
            	    <li>Darbhanga</li>
            	    <li>Dhanbad</li>
            	    <li>Dehradun</li>
            	    <li>Delhi & NCR: Delhi, Faridabad, Ghaziabad, Greater Noida, Noida, Gurgaon, Indirapuram, Sahibabad</li>
            	    <li>Dibrugarh</li>
            	    <li>Gandhinagar</li>
            	    <li>Gangtok</li>
            	    <li>Gaya</li>
            	    <li>Gorakhpur</li>
            	    <li>Guwahati</li>
            	    <li>Guntur</li>
            	    <li>Gwalior</li>
            	    <li>Hyderabad</li>
            	    <li>Imphal</li>
            	    <li>Indore</li>
            	    <li>Jabalpur</li>
            	    <li>Jaipur</li>
            	    <li>Jalandhar</li>
            	    <li>Jammu</li>
            	    <li>Jodhpur</li>
            	    <li>Kannur</li>
            	    <li>Kanpur</li>
            	    <li>Kohima</li>
            	    <li>Kolkata (including Ishapore)</li>
            	    <li>Kochi</li>
            	    <li>Kota</li>
            	    <li>Kozhikode</li>
            	    <li>Lucknow</li>
            	    <li>Meerut</li>
            	    <li>Moradabad</li>
            	    <li>Mumbai</li>
            	    <li>Muzaffarpur</li>
            	    <li>Mysuru</li>
            	    <li>Nagpur</li>
            	    <li>Nashik</li>
            	    <li>Nellore</li>
            	    <li>Panaji</li>
            	    <li>Panchkula</li>
            	    <li>Patna</li>
            	    <li>Puducherry</li>
            	    <li>Pune</li>
            	    <li>Raipur</li>
            	    <li>Ranchi</li>
            	    <li>Rajahmundry</li>
            	    <li>Saharanpur</li>
            	    <li>Shillong</li>
            	    <li>Shimla</li>
            	    <li>Silchar</li>
            	    <li>Siliguri (including Jalpaiguri)</li>
            	    <li>Sonipat</li>
            	    <li>Srinagar</li>
            	    <li>Thiruvananthapuram</li>
            	    <li>Varanasi (Benaras)</li>
            	    <li>Tiruchirapalli (Trichy)</li>
            	    <li>Tirunelveli</li>
            	    <li>Vadodara</li>
            	    <li>Vijayawada</li>
            	    <li>Vishakhapatnam</li>
            	  </ol>
            	</div>
            `;
        }
        // Set the content of the popup
        document.getElementById('custom-popup-content').innerHTML = content;

        // Display the popup
        document.getElementById('custom-popup-overlay').style.display = 'flex';
    }

    // Function to close the popup
    function closeCustomPopup() {
        document.getElementById('custom-popup-overlay').style.display = 'none';
    }




    </script>

	<!--JS for Modal Pop up for Footer Links Start  -->

<script>
  window.addEventListener("load", function () {
    document.getElementById("customLaunchOverlay").style.display = "flex";

    document.getElementById("btnDismissPopup").addEventListener("click", function () {
      document.getElementById("customLaunchOverlay").style.display = "none";
    });
  });
</script>


<script>
  function focusMainSearch() {
    const input = document.getElementById("myInput");
    input.focus();
    mySearchFunction();
  }
</script>

	<script type="text/javascript">


	
    function mySearchFunction() {
        var input, filter, ul, li, a, i, txtValue;
        input = document.getElementById("myInput");
        filter = input.value.toUpperCase();
        ul = document.getElementById("datalistId1");
        li = ul.getElementsByTagName("li");

        for (i = 0; i < li.length; i++) {
            let label = li[i].getElementsByTagName("label")[0]; // Get the label text
            let links = li[i].getElementsByTagName("a"); // Get all <a> elements inside the list item

            let found = false;
            // Check label texft
            if (label) {
                txtValue = label.textContent || label.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                }
            }

            // Check links text (PDF file names)
            for (let j = 0; j < links.length; j++) {
                let linkText = links[j].textContent || links[j].innerText;
                if (linkText.toUpperCase().indexOf(filter) > -1) {
                    found = true;
                    break;
                }
            }

            // Show or hide the <li> element based on search result
            /* li[i].style.display = found ? "" : "none"; */
            li[i].style.cssText = found ? "" : "display: none !important;";
        }
    }


    document.addEventListener('DOMContentLoaded', function () {
        // Define the URL to fetch file details
        var coveredCityUrl = "/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=10&subGroupId=103";
        //var faclityCGHSUrl = "/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=10&subGroupId=102";
        
       // var cghsCounterDate = localStorage.getItem("cghsCounterDate");

       
        
        // Fetch file details and populate the link
        fetchAndSetDownloadLink(coveredCityUrl);
    });

    function fetchAndSetDownloadLink(coveredCityUrl) {
        try {
            $.ajax({
                url: coveredCityUrl,
                method: "GET",
                dataType: "json",
                success: function (responses) {
                    if (!responses || responses.length === 0) {
                        console.log("No records found.");
                        return;
                    }
                    // Assuming the first response contains the file details
                    var fileName = responses[0].fileName;
                    var folderName = responses[0].folderName || "default-folder"; // Replace with actual folder name if needed

            	    var fileNamePart = fileName.split('^')[0];
            	    var folderNamePart = fileName.split('^')[1];
            	    
            	    var displayFileName = displayFileName;
            	    
            	    console.log("displayFileName  "+displayFileName);
            	    var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + fileNamePart + "&folderName=" + folderNamePart + "&isGlobal=1";
            	    
                    var downloadLink = document.getElementById('downloadLink');
                    downloadLink.href = fileURL;

                    // Add an event listener to trigger the download when the link is clicked
                    downloadLink.addEventListener('click', function (event) {
                        event.preventDefault(); // Prevent the default link behavior
                        window.location.href = fileURL; // Trigger the download
                    });
                },
                error: function (xhr, status, error) {
                    console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
                  //  alert("An error occurred while processing your request: " + error);
                }
            });
        } catch (err) {
            console.error("Exception occurred:", err.message);
           // alert("An unexpected error occurred: " + err.message);
        }
    }


    
	 $(document).ready(function(){

		 
		 var status="0";
		 console.log("cghs counter>> " ,  localStorage.getItem("cghsCounterDate") );
		 //alert("checking console");
		 
		  if ( localStorage.getItem("cghsCounterDate")!= null && localStorage.getItem("cghsCounterDate")!= ""  ){
					
			  }
		  else{
			  status="1";
			  localStorage.setItem('cghsCounterDate', "1" );
	       // = "/AHIMSG5/hislogin/viewerHITCountLgnFtr?status="+ status;
	        
		  }
		  insertHITCount(status);
		 //displayCircularDetails(1,101);
		  
	 });

	    function insertHITCount(status) {
	        
			var url = "/AHIMSG5/hislogin/viewerHITCountLgnFtr?status="+ status;
	        $.ajax({
	            url: url,
	            method: "GET",
	            success: function (data) {
	                if (data.hitCountAllArray) {
						var counterValue = data.hitCountAllArray[0].totalCount;
						$('.website-counter').text(counterValue);
		                   
	                } else {
	                    console.error("No records found.");
	                }
	            },
	            error: function (xhr, status, error) {
	                console.error("Error fetching cities:", error);
	                console.log("XHR Status:", xhr.status); 
	                console.log("XHR Status Text:", xhr.statusText);
	                console.log("Response Text:", xhr.responseText); 
	            }
	        });
	    }
/* 	 
	 function insertHITCount(){
		 var status= "1";
		var url = "/AHIMSG5/hislogin/viewerHITCountLgnFtr?status="+ status;
		   try {
	            $.ajax({
	                url: url,
	                method: "GET",
	                dataType: "json",
	                success: function (responses) {
	                    if (!responses || responses.length === 0) {
	                        console.log("No records found.");
	                        return;
	                    }
	                    // Assuming the first response contains the file details
	                 
	                },
	                error: function (xhr, status, error) {
	                    console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
	                  //  alert("An error occurred while processing your request: " + error);
	                }
	            });
	        } catch (err) {
	            console.error("Exception occurred:", err.message);
	           // alert("An unexpected error occurred: " + err.message);
	        }
		 
		 } */
    		function openFrame(id){
						
						var url="";

						if(id=="appointment"){
                          
							 $('#myModalserving').modal('hide');
							 url=createFHashAjaxQuery("/CGHSAppointment/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp");
							 //url=createFHashAjaxQuery("/ABDM_QMS/ABHACreation?abdmMode=appointment&isGlobal=1");

						}	


						if(id == "applycard"){

							 $('#myModalserving').modal('hide');
							 url= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp';
							// url= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=PanVerification';
							}
						
						if(id == "applycardonline"){

							 $('#myModalserving').modal('hide');
							 url= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=PanVerification';
							}
						if(id == "pensionerapplycard"){

							 $('#myModalserving').modal('hide');
							 url= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=DAOnlinePensioner';
							}
						//url="/AHIMSG5/hissso/constructionLogin";

						$('#preloader').show();
						$('#iframeModalFullScreen').attr("src",url);

						 $('#modalFullScreen').show();
						 $(".modal-backdrop").hide();
						
						
						 $('#iframeModalFullScreen').on('load', function(){
								$('#preloader').delay(450).fadeOut('slow');		
							});
							
						}	

    					function closeModal(){
    						closeFullScreenModal();
    					}		

    					function closeFullScreenModal(){
    						 $('#iframeModalFullScreen').attr("src","");
    						 $('#modalFullScreen').hide();
    						 $(".modal-backdrop").hide();
 
    					}

    					</script>

</body>

</html>
