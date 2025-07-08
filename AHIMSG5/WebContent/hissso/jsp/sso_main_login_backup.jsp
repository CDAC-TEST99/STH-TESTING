<%@page import="sun.misc.JavaxCryptoSealedObjectAccess"%>
<%@page import="sun.misc.JavaAWTAccess"%>
<%@page import="hisglobal.security.SecureHashAlgorithm"%>
<%@page import="hisglobal.utility.SecurityUtil"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hisglobal.config.HISConfig"%>
<%@page import="hisglobal.utility.Entry"%>
<%@page import="java.util.List"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@page import="hisglobal.config.HISConfig"%>
<%@page import="hisglobal.utility.Entry"%>

<!-- //dev Mobile Login -->
<%@page import="hisglobal.FormFlowX.fb.*"%>
<%@page import="hisglobal.security.*"%>
<%@page import="hisglobal.FormFlowX.vo.*"%>
<%@page import="hissso.config.HISSSOConfig"%>


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
<!-- 	<title>Sushrut@Clinic</title> -->
    <meta content="width=device-width, initial-scale=1" name="viewport" />
<!--  	<link href="/HIS/hisglobal/images/e-clinic/img/icons/logo.ico" rel="icon"  type="image/x-icon"> -->
    <link href="/HIS/hisglobal/cdac_awesome/bootstap/css/bootstrap.min.css" rel="stylesheet"> 
    <!-- <link href="/HIS/hisglobal/cdac_awesome/aos/aos.css" rel="stylesheet">
    <link href="/HIS/hisglobal/cdac_awesome/css/css2.css" rel="stylesheet">    
    <link href="/HIS/hisglobal/cdac_awesome/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/responsive.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css" -->
    
    <title>CGHS</title>
    <title>Central Government Health Scheme</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="/HIS/hisglobal/cdac_main/images/logo.jpg" rel="icon">

    <!--  CSS Files -->
<!--     <link href="/HIS/hisglobal/cdac_main/css/bootstrap-min.css" rel="stylesheet" /> --> 
    <link href="/HIS/hisglobal/cdac_main/css/style.css" rel="stylesheet">
    
    <link href="/HIS/hisglobal/cdac_main/css/responsive.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/all.css">
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/fonts/fontawesome/css/fontawesome.min.css">

<!-- //dev Mobile Login Links -->
<%-- 	<jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include> --%>
<%--     <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/Mobileotp.js"></script> --%>

<style>
        /* Modal Content Width */
        .modal-dialog { max-width: 600px; }
        .modal-dialog {
			   
			   margin-right: auto;
			   margin-left: 35%;
			   margin-bottom: 5%;
			 }

        /* Form Control Styling */
        .form-control-lg { padding: 0.75rem 1.25rem; }
        .btn-custom { background-color: #007bff; color: white; }
        .btn-outline-custom { border: 1px solid #007bff; color: #007bff; }
        .btn-outline-custom:hover { background-color: #007bff; color: white; }

        /* Centering Elements */
        .modal-body .text-center { text-align: center; }

        /* Form Spacing */
        .form-label { font-weight: bold; }

        /* Fade Animation */
        .fade-tab { opacity: 0; transition: opacity 0.5s ease-in-out; }
        .fade-tab.show { opacity: 1; }

	    .btn-link{	--bs-btn-bg: #d5322e;
	    }
	
	    .required{
	    color: rgb(255, 30, 30);
	    margin-left: 1px;
	    }
	    
	    .modal-content-bg{
		    background: #ECE9E6;  /* fallback for old browsers */
			background: -webkit-linear-gradient(to top, #FFFFFF, #ECE9E6);  /* Chrome 10-25, Safari 5.1-6 */
			background: linear-gradient(to top, #FFFFFF, #ECE9E6); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
			width: 70%;
			border: 8px solid #ced4da;
		    border-radius: 22px;
		    background: linear-gradient(to right, #CFDEF3, #E0EAFC);
	    }
	   /*  .nav-tabs .nav-link .active{
	    background: linear-gradient(to right top, #6678e2, #6e6ed2, #7464c2, #765ab3, #7751a3); */
	    
	    .nav-tabs .nav-link.active {
		  color: white;
		  background-color: var(--bs-nav-tabs-link-active-bg);
		  border-color: var(--bs-nav-tabs-link-active-border-color);
		  background: linear-gradient(to right top, #6678e2, #6e6ed2, #7464c2, #765ab3, #7751a3);		
		}
		
	
		.mb-4 {
		  margin-top: 1.5rem !important;
		}
		.btn {
		--bs-btn-hover-border-color: black;}
		
		.group {
		  display: flex;
		  line-height: 30px;
		  align-items: center;
		  position: relative;  
		}
		
		.input {
		  width: 100%;
		  height: 45px;
		  line-height: 30px;
		  padding: 0 5rem;
		  padding-left: 3rem;
		  border: 2px solid transparent;
		  border-radius: 10px;
		  outline: none;
		  background-color: #f8fafc;
		  color: #0d0c22;
		  transition: .5s ease;
		}
		
		.input::placeholder {
		  color: #94a3b8;
		}
		
		.input:focus, input:hover {
		  outline: none;
		  border-color: rgba(129, 140, 248);
		  background-color: #fff;
		  box-shadow: 0 0 0 5px rgb(129 140 248 / 30%);
		}
		
		.icon {
		  position: absolute;
		  left: 1rem;
		  fill: none;
		  width: 1rem;
		  height: 1rem;
		}
    </style>

</head>
<body>
	 <!-- Preloader Start -->
		<%--  <div id="preloader">
		  <div id="loader">   
		  </div>
		  <span class='midtext'>Loading..</span>
		</div>    --%>
    <!-- Preloader Ends -->
<header>

  <form method='post'>
  	<input type='hidden' name='tokenCode' value='<%= java.util.Base64.getEncoder().encodeToString(new java.util.Date().toString().getBytes()) %>' ></input>
  </form>
        <div id="topbar" class="container-fluid">
         
            <div class="row">
                <div class="col-lg-12 col-md-12 d-flex align-items-center justify-content-end loginbtn">
                  
                
                  
                    <a class="text-decoration-none text-white d-flex align-items-center fw-regular raise-ticket">

                        <span class="material-symbols-outlined p-1 me-1">confirmation_number</span>
                        <p class="m-0">Raise Ticket</p>
                    </a>
    <button id='loginBenButtonId'
    class="text-white ms-3 d-flex align-items-center fw-regular border-0  px-2 py-2 position-relative  type="button" >
					<span class="material-symbols-outlined me-1">login</span>Beneficiary Login  
                       <div class="arrow position-absolute bottom-0"></div> 
                     </button>  
                    <button id='logincghsButtonId'
                        class="text-white ms-3 d-flex align-items-center fw-regular border-0 px-2 py-2 position-relative" type="button" >
                        <span class="material-symbols-outlined me-1">Login</span><span>Login</span>
                          
                        
<!--                             <a class ="login-link" href="" style="" data-bs-toggle="modal"  data-bs-target="#myModalLogin">Login</a> -->
                            <div
                            class="arrow position-absolute bottom-0"></div></button>

                </div>
            </div>
        </div>
    </header>
    <div id="slider" class="position-relative">
        <div class="container-fluid position-absolute start-0 end-0 top-0 main-menu px-md-3">
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div class="logo position-relative">
                        <div class="d-flex align-items-center ">
                            <img src="/HIS/hisglobal/cdac_main/images/logo.jpg" />
                            <div class="ps-2 pt-2">
                                <h1 class="fw-regular mb-1">Central Government Health Scheme</h1>
                                <p class="lh-lg mb-0">Ministry of Health & Family Welfare</p>
                                <p>Government of India</p>
                            </div>
                        </div>


                    </div>
                </div>
                <div class="col-md-6 col-lg-8 d-flex justify-content-end align-items-center">
                    <nav class="navbar navbar-expand-custom p-0">
                        <button class="navbar-toggler p-1" type="button" aria-controls="navbarSupportedContent"
                            aria-expanded="false" aria-label="Toggle navigation">
                            <span class="material-symbols-outlined text-white">segment</span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ml-auto">

                                <li class="nav-item active position-relative">
                                    <div class="hori-selector"></div>
                                  <a class="nav-link  d-flex align-items-center" href="javascript:openFrame('appointment');"  >
 											<span class="material-symbols-outlined mb-1 me-1">
                                            event_available</span><span>Book Appointment</span></a>
                                           
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:openFrame('applycard');"  >
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            add_circle</span><span>Apply Card</span></a>
                                </li>
                                  <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:openFrame('pensionerapplycard');"  >
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            add_circle</span><span>Apply Pensioner Card</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:void(0);">
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            visibility</span><span>View</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:void(0);">
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            download</span><span>Download</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:void(0);">
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            help</span><span>Help Desk</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:void(0);">
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            language</span><span>CGHS Website</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link  d-flex align-items-center" href="javascript:void(0);">
                                        <span class="material-symbols-outlined mb-1 me-1">
                                            group</span><span>Beneficiaries</span></a>
                                </li>

                            </ul>
                        </div>
                    </nav>
                    <div class="d-flex align-items-center">
                        <img src="/HIS/hisglobal/cdac_main/images/satyamev-jayate-logo.png" class="imres" />
                    </div>
                </div>
            </div>

        </div>



        <div class="slider-one">
            <div class="slider-one-image"></div>
        </div>



    </div>


  <!-- The Login Pop Up Modal -->
  
 


<!-- Beneficiary Login Modal --> 
 
            <div class="modal" id="ForgotPasswordModal"  class="modal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
				<div class="modal-dialog ">
					<div class="modal-content">
						<iframe class="border-0" id='iframeForgotPasswordModal'src="" style="height: 70vh;"></iframe>
					</div>
				</div>
			</div> 


     <div class="container-fluid position-absolute" id="kpis">
        <div class="row">
            <div class="col-md-5 col-xl-3 col-12">
                <div class="row">
                    <div class="col-md-12 col-6">
                        <div class="kpi pinkkpi text-white text-center position-relative mb-sm-3 py-sm-2 py-4 mb-1">
                            <div class="icon position-absolute"><span class="material-symbols-outlined">
                                    add_box
                                </span></div>
<!--                             <div class="rightimg position-absolute"><img src="/HIS/hisglobal/cdac_main/images/kpibg.png"></div> -->
                            <h2 class="my-2 pt-3">CGHS UNITS</h2>
                            <p class="mb-1 fw-light"><b>475</b> Total CGHS Units</p>
                            <p class="fw-light"><b>3</b> CGHS Units Online Today</p>
                        </div>
                    </div>
                    <div class="col-md-12 col-6">
                        <div class="bluekpi kpi position-relative text-center py-sm-1 text-white mb-1 mb-sm-1">
                            <div class="icon position-absolute"><span class="material-symbols-outlined">
                                    person_check
                                </span></div>
                            <div class="rightimg position-absolute"><img src="/HIS/hisglobal/cdac_main/images/kpibg.png"></div>
                            <h2 class="my-sm-2 my-2 ">Registrations</h2>
                            <p class="mb-1 fw-light"><b>63,282</b> Registrations Today
                            </p>
                            <hr class="m-2 m-sm-2" />
                            <small class="fw-light">Online Appointments, Walk-in Appointments & Conventional
                                Registrations
                                included</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-6 col-xl-4 col-12 p-0">
                <div class="purplekpi text-white px-3 py-1 kpi position-relative">
                    <div class="icon position-absolute"><span class="material-symbols-outlined">
                            group
                        </span></div>
                    <div class="rightimg position-absolute"><img src="/HIS/hisglobal/cdac_main/images/purplebg.png"></div>
                    <h2 class="my-2 p-2 po dev">
                        Cardholder's / Beneficiaries</h2>

                    <div class="row mt-4">
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Card Holder's
                            </p>
                            <hr />
                        </div>
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Serving
                            </p>
                            <hr />
                        </div>
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Pensioner
                            </p>
                            <hr />
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Card Holder's
                            </p>
                        </div>
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Serving
                            </p>
                        </div>
                        <div class="col-md-4 col-4">
                            <p class="mb-1 fw-light"><b>16,43,943 </b><br> Pensioner
                            </p>
                        </div>
                    </div>
                    <div class="cghs position-absolute bottom-0">CGHS</div>
                    <div class="view-more position-absolute text-center text-white p-2">
                        <div class="wavy-line"></div>
                        View More >>
                    </div>
                </div>
            </div>
        </div>
    </div>

     <section id="pdfsection" class="container my-5">
        <ul class="nav nav-tabs d-none d-lg-flex" id="myTab" role="tablist">
            <li class="nav-item" role="presentation">
                <button class="nav-link active d-flex align-items-center" id="currentIssuesId" data-bs-toggle="tab"
                    data-bs-target="#currentIssuesId-pane" type="button" role="tab" aria-controls="currentIssuesId-pane"
                    aria-selected="true" onclick="displayCircularDetails(1)">  <span class="material-symbols-outlined me-1">description</span> Current Issues</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link d-flex align-items-center" id="press-releases" data-bs-toggle="tab" data-bs-target="#press-releases-pane"
                    type="button" role="tab" aria-controls="press-releases-pane" aria-selected="false" onclick="displayCircularDetails(2)"> <span class="material-symbols-outlined me-1">description</span> Press
                    Releases</button>
            </li>
            <li class="nav-item" role="presentation">
                <button class="nav-link d-flex align-items-center" id="instructions" data-bs-toggle="tab" data-bs-target="#instructions-pane"
                    type="button" role="tab" aria-controls="instructions-pane"
                    aria-selected="false" onclick="displayCircularDetails(3)"> <span class="material-symbols-outlined me-1">description</span> Instructions</button>
            </li>

            <li class="nav-item" role="presentation">
                <button class="nav-link d-flex align-items-center" id="tenders-vacancies" data-bs-toggle="tab"
                    data-bs-target="#tenders-vacancies-pane" type="button" role="tab"
                    aria-controls="tenders-vacancies-pane" aria-selected="false" onclick="displayCircularDetails(4)"> <span class="material-symbols-outlined me-1">description</span> Tenders & Vacancies</button>
            </li>

            <li class="nav-item" role="presentation">
                <button class="nav-link d-flex align-items-center" id="stories" data-bs-toggle="tab" data-bs-target="#stories-pane" type="button"
                    role="tab" aria-controls="stories-pane" aria-selected="false" onclick="displayCircularDetails(5)"> <span class="material-symbols-outlined me-1">description</span> Stories</button>
            </li>
        </ul>
        <div class="tab-content accordion" id="myTabContent">
            <div class="tab-pane fade show active accordion-item" id="currentIssuesId-pane" role="tabpanel"
                aria-labelledby="currentIssuesId" tabindex="0">

                <h2 class="accordion-header d-lg-none" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">Current
                        Issues</button>
                </h2>
                <div id="collapseOne" class="accordion-collapse collapse show  d-lg-block" aria-labelledby="headingOne"
                    data-bs-parent="#myTabContent">
                    <div class="accordion-body">
                        <div class="container-fluid">
                            <ul id="datalistId1" class="datalist p-0 m-0">
                                
                                 <!--    <div class="multiplepdflist d-flex align-items-center px-2">
                                        <ul id="pdfListId2" class="d-flex align-items-top p-0 my-2">
                                        </ul>
                                     </div> -->
                                <div class="view-more text-center text-white p-2 position-relative">
                                    <div class="wavy-line"></div>
                                    View More &gt;&gt;
                                </div>


                            </ul>



                        </div>
                    </div>
                </div>

            </div>
            <div class="tab-pane fade accordion-item" id="press-releases-pane" role="tabpanel"
                aria-labelledby="press-releases" tabindex="0">
                <h2 class="accordion-header d-lg-none" id="headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Press Releases
                    </button>
                </h2>
                <div id="collapseTwo" class="accordion-collapse collapse d-lg-block" aria-labelledby="headingTwo"
                    data-bs-parent="#myTabContent">
                    <div class="accordion-body">
                        <div class="container-fluid">
                            <ul id="datalistId2" class="datalist p-0 m-0">

                         <!--         <li class="mt-1 mb-3 pt-3"><a href="#" target="_blank"
                                        class="text-decoration-none d-flex align-items-top px-2">
                                        <span class="material-symbols-outlined me-2">picture_as_pdf</span>Office
                                        Memorandum regarding Pancarida Heart and Multi Speciality Hospital Pvt Ltd under
                                        CGHS Patna (9 October 2024)</a>
                                    <div class="light-sm-txt d-block d-flex align-items-top datetime my-1 px-2">
                                        <span class="material-symbols-outlined me-1">schedule</span>Tuesday 29 Oct 2024,
                                        6:29 PM
                                    </div>

                                    <div class="multiplepdflist d-flex align-items-center px-2">
                                        <ul id="pdfListId2" class="d-flex align-items-top p-0 my-2">
                                        </ul>
                                     </div>  
                                       <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    1 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    2 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    3 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    4 </a>
                                            </li>
                                        </ul>
                                    
                                </li> 
                                <li class="my-3 pt-3"><a href="#" target="_blank"
                                        class="text-decoration-none d-flex align-items-top px-2">
                                        <span class="material-symbols-outlined me-2">picture_as_pdf</span>Office
                                        Memorandum regarding Pancarida Heart and Multi Speciality Hospital Pvt Ltd under
                                        CGHS Patna (9 October 2024)</a>
                                    <div class="light-sm-txt d-block d-flex align-items-top datetime mt-1 px-2 mb-2">
                                        <span class="material-symbols-outlined me-1">schedule</span>Tuesday 29 Oct 2024,
                                        6:29 PM
                                    </div>


                                </li>


                                <li class="my-3 pt-3"><a href="#" target="_blank"
                                        class="text-decoration-none d-flex align-items-top px-2">
                                        <span class="material-symbols-outlined me-2">picture_as_pdf</span>Office
                                        Memorandum regarding Pancarida Heart and Multi Speciality Hospital Pvt Ltd under
                                        CGHS Patna (9 October 2024)</a>
                                    <div class="light-sm-txt d-block d-flex align-items-top datetime mt-1 px-2 mb-2">
                                        <span class="material-symbols-outlined me-1">schedule</span>Tuesday 29 Oct 2024,
                                        6:29 PM
                                    </div>

                                    <div class="multiplepdflist d-flex align-items-center px-2">
                                        <ul class="d-flex align-items-top p-0 my-2">
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    1 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    2 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    3 </a>
                                            </li>
                                            <li class="me-4"><a href="" target="_blank"
                                                    class="d-flex align-items-center  align-items-top text-decoration-none"><span
                                                        class="material-symbols-outlined me-1">picture_as_pdf</span> PDF
                                                    4 </a>
                                            </li>
                                        </ul>
                                    </div>


                                </li>

                                <li class="my-3 pt-3"><a href="#" target="_blank"
                                        class="text-decoration-none d-flex align-items-top px-2">
                                        <span class="material-symbols-outlined me-2">picture_as_pdf</span>Office
                                        Memorandum regarding Pancarida Heart and Multi Speciality Hospital Pvt Ltd under
                                        CGHS Patna (9 October 2024)</a>
                                    <div class="light-sm-txt d-block d-flex align-items-top datetime mt-1 px-2 mb-2">
                                        <span class="material-symbols-outlined me-1">schedule</span>Tuesday 29 Oct 2024,
                                        6:29 PM
                                    </div>


                                </li>
                                <li class="my-3 pt-3"><a href="#" target="_blank"
                                        class="text-decoration-none d-flex align-items-top px-2">
                                        <span class="material-symbols-outlined me-2">picture_as_pdf</span>Office
                                        Memorandum regarding Pancarida Heart and Multi Speciality Hospital Pvt Ltd under
                                        CGHS Patna (9 October 2024)</a>
                                    <div class="light-sm-txt d-block d-flex align-items-top datetime mt-1 px-2 mb-2">
                                        <span class="material-symbols-outlined me-1">schedule</span>Tuesday 29 Oct 2024,
                                        6:29 PM
                                    </div>

                                </li> -->

                                <div class="view-more text-center text-white p-2 position-relative">
                                    <div class="wavy-line"></div>
                                    View More &gt;&gt;
                                </div>


                            </ul>



                        </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade accordion-item" id="instructions-pane" role="tabpanel"
                aria-labelledby="instructions" tabindex="0">
                <h2 class="accordion-header d-lg-none" id="headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        Instructions
                    </button>
                </h2>
                <div id="collapseThree" class="accordion-collapse collapse d-lg-block" aria-labelledby="headingThree"
                    data-bs-parent="#myTabContent">
                    <div class="accordion-body">
                        <div class="container-fluid">
                            <ul id="datalistId3" class="datalist p-0 m-0">
                                

                                <div class="view-more text-center text-white p-2 position-relative">
                                    <div class="wavy-line"></div>
                                    View More &gt;&gt;
                                </div>


                            </ul>



                        </div>
                    </div>
                </div>
            </div>

            <div class="tab-pane fade accordion-item" id="tenders-vacancies-pane" role="tabpanel"
                aria-labelledby="tenders-vacancies" tabindex="0">
                <h2 class="accordion-header d-lg-none" id="headingFour">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Tenders and Vacancies
                    </button>
                </h2>
                <div id="collapseFour" class="accordion-collapse collapse d-lg-block" aria-labelledby="headingFour"
                    data-bs-parent="#myTabContent">
                    <div class="accordion-body">
                        <div class="container-fluid">
                            <ul id="datalistId4" class="datalist p-0 m-0">
                                

                                <div class="view-more text-center text-white p-2 position-relative">
                                    <div class="wavy-line"></div>
                                    View More &gt;&gt;
                                </div>


                            </ul>



                        </div>
                    </div>
                </div>
            </div>


            <div class="tab-pane fade accordion-item" id="stories-pane" role="tabpanel" aria-labelledby="stories"
                tabindex="0">
                <h2 class="accordion-header d-lg-none" id="headingFive">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        Stories
                    </button>
                </h2>
                <div id="collapseFive" class="accordion-collapse collapse d-lg-block" aria-labelledby="headingFive"
                    data-bs-parent="#myTabContent">
                    <div class="accordion-body">
                        <div class="container-fluid">
                            <ul id="datalistId5" class="datalist p-0 m-0">
                                
                                <div class="view-more text-center text-white p-2 position-relative">
                                    <div class="wavy-line"></div>
                                    View More &gt;&gt;
                                </div>


                            </ul>



                        </div>
                    </div>
                </div>
            </div>

        </div>


    </section>

    <div class="ashokchakra position-fixed end-0 bottom-0" style="z-index: 999;"><img src="/HIS/hisglobal/cdac_main/images/ashokchakra.png" />
    </div>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-10 d-flex align-items-center justify-content-center">
                    <div class="copyright text-white text-center">Website owned & maintained by: Centre for Development
                        of Advanced Computing (C-DAC)</div>
                </div>
                <div class="col-lg-2 p-0">
                    <div class="me-1"><img src="/HIS/hisglobal/cdac_main/images/digital-india-logo.png" /></div>
                </div>
            </div>


        </div>
    </footer>




<div class="modal" id="modalFullScreen" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		  <div class="modal-fullscreen">
		    <div class="modal-content">
		      <div class="modal-header" style="padding: 0;">
		      	 <div class="container-fluid" style="padding: 3px;">
		       	 <div class="row">
                    <div class="col-lg-4 col-xl-4 col-md-4 col-sm-4 col-11" style="padding-left: 25px;">
  						<img src='/HIS/hisglobal/images/cghs_logo_big.png' style='height:50px;'>
  					</div>	
  					<div class="col-lg-8 col-xl-8 col-md-4 col-sm-4 col-12" style="padding-left: 25px;text-align: right;">
  						<button type="button" id='closeFullScreenModal' class="float-end mt-2 btn btn-sm btn-danger" data-bs-toggle="modal" data-bs-target="#modalFullScreen" onclick="closeFullScreenModal();">Close</button>
  					</div>
  				 </div>
  				 </div>
		      </div>
		      <div class="modal-body">
		      	<iframe src=""  id="iframeModalFullScreen" style="width: 100%;height: 100%"></iframe>
		     </div>
		    </div>
		  </div>
		</div>


    <!-- Placed js at the end of the document so the pages load faster -->

		    <!-- jquery latest version -->
		    <script src="/HIS/hisglobal/cdac_main/js/jquery-3.7.1.min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/bootstrap-min.js"></script>
		    <script src="/HIS/hisglobal/cdac_main/js/scripts.js"></script>
			
		<%-- 	<script src="/HIS/hisglobal/cdac_awesome/jquery/jquery.min.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/bootstap/js/bootstrap.bundle.min.js"></script> --%>
            <script src="/HIS/hisglobal/cdac_awesome/js/popper.min.js"></script>
            
            <script src="/HIS/hisglobal/cdac_awesome/js/menu.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/aos/aos.js"></script>
            <script src="/HIS/hisglobal/cdac_awesome/js/purecounter_vanilla.js"></script>
            
            <script src="/HIS/hisglobal/cdac_awesome/js/main.js"></script> 
                         
			<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
			<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
			<script type="text/javascript" src="/HIS/hisglobal/js/util.js"></script>
			<script type="text/javascript" src="/AHIMSG5/hissso/js/ssoLogin.js"></script>
			<script type="text/javascript">

			
			/* 	function Refresh()
				{
					this.location.reload();
	
				}
				function refershMain()
				{
					window.location.href = window.location.pathname; 
				}
	 */
/* 	For Cghs Login */
			 $(document).ready(function(){

				 displayCircularDetails(1,101);
 
				 $("#logincghsButtonId").click(function(){

					 	document.forms[0].action = '/AHIMSG5/hissso/cghsLogin';
					 	document.forms[0].submit();

					 });


				 $("#loginBenButtonId").click(function(){

					 	document.forms[0].action = '/AHIMSG5/hissso/benLogin';
					 	document.forms[0].submit();

				 });
				  
			 });
	 
	 
//	 alert("mstatus  = "+$("#mstatus").val());

     //const messageOTP = "OTP sent to CGHS linked mobile number ending with " + "******"+mobileNo.slice(-4);
     //temprory OTP service down error
     const messageOTP ="Currently OTP service is down Please Login using CGHS User Login !"
     /* var attemptLeft=2-resendClickCount;	
     const messageClickCount = "Attempt left:" +attemptLeft;
     let clickCount = 0; */
   /*  console.log(message);
   $('#message-container').text(message); */
// for action error Mobile

	 		if($("#mstatus").val() == 'motp'){ 

	 		 	$("#logincghsButtonId").trigger('click');
	 			
	 			 $("#nav-mobile-tab").trigger('click');
	 			 
				 $("#otPRow").show();
				 console.log(messageOTP);
				 $('#alertMsgMobile').text(messageOTP);
				 $('#alertMsgMobile').show();
				// $('#generateButton').click(resendOTPTimer);
				 $('#generateButton').hide();
				 
				 $('#validateButton').show();
			     /* $('#resendButton').click(resendOTPTimer); */
				 $('#resendButton').show();	
	 		}
	
				  /*  $('#resendButton').click(function() {
				     clickCount++; 
				     $('#resendclickCount').text(resendclickCount); 
				   });
	 */
	 		/* function resendOTPTimer(btnId){ alert("insideresendTimer");
	 			$('#'+btnId).html("-").addClass("btn-light").removeClass("btn-his-outline").html("-");
	 			
	 			var timeleft = 60;
	 			var resendClickCount=0
	 			
	 			if($('#resendClickCount').val()!=undefined && $('#resendClickCount').val()!="" )		
	 				resendClickCount=parseInt($('#resendClickCount').val());
	 			
	 			var attemptLeft=2-resendClickCount;	
	 			$('#resendClickCount').val(++resendClickCount);	
	 			if(attemptLeft==0){ console.log(messageClickCount);
	 				$('#'+btnId).hide();
	 				return;
	 			}
	 			
	 			var downloadTimer = setInterval(function(){
	 			  if(timeleft <= 0){
	 				 $('#'+btnId).html("Resend OTP").removeClass("btn-light").addClass("btn-his-outline");
	 			    clearInterval(downloadTimer);
	 			  }
	 			  else  alert("1")
	 				  $('#'+btnId).html("<span style='font-size:13px;'>Resend  OTP in :<b>" + timeleft + " seconds</b> ,<br/>Attempt left: "+attemptLeft+"</span>"	);
	 			  	  timeleft -= 1;
	 			  	alert("2")
	 			}, 1000)
	 		}

	 		 */
	 		 
			 $('#myModalLogin').on('shown.bs.modal', function () {
				    $('#nav-tab a[data-bs-toggle="tab"]').on('click', function (e) {
				        e.preventDefault();
				        $(this).tab('show');
				    });
				});

			 $('#nav-tab .nav-link').on('click', function (e) {
				    e.preventDefault();
				    $(this).tab('show');
				});


			 
       function openMobileotp()
        {
		// $('#myModalserving').modal('hide');
		// window.location = ("/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp",'_blank');
		 window.open('/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp', '_blank');
		 
		 }
	

			var IS_CAPTCHA_REQ = "<%=HISConfig.CAPTCHA_IMPLEMENTATION%>";
	
	
				var sessionToken = "<%=session.getAttribute(HISSSOServerConfig.LOGIN_SESSION_SALT)%>";
							
				/*  $(document).ready(function() { 
					 $('#preloader').delay(450).fadeOut('slow');
					 	$( "button" ).click(function( event ) {
							event.preventDefault();
						});
						$( "input[type=button], button" ).click(function( event ) {
							event.preventDefault();
						});

						if($('#divElementErrorsId').html().trim()!=""){
							showLoginPage();
							$('#divElementErrorsId').show();
						}
						else{$('#divElementErrorsId').hide();}

						$('.btn-close').click(function(){
							$('.modal').modal('hide');
						});
						
						$("#idForgotPassword").click(function() {
							$('.modal').modal('hide');
							$('#iframeForgotPasswordModal').attr("src", "/AHIMSG5/hislogin/initForgetPasswordLgnFtr");
							$("#ForgotPasswordModal").modal("show");					
						});
						$('.btn-close').click(function(){
							$('.footerframes').attr("src","");
						}); */
                         
				
				 function showLoginPage(){

					 $("#myModalLogin").modal("show");
					 

				 }
				 function openLoginPage(){ 
					 $('#myModalLogin').modal('show');

				}

				 
		
					
					function openFrame(id){
						
						var url="";

						
						
						/* if(id=="cghscard")
							url="/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp" */
						
						
						if(id=="appointment"){
							//url="/ABDM_QMS/ABHACreation?abdmMode=appointment&isGlobal=1"
							//url="/HISRegistration_MC/registration/transactions/OnlineAppoitment.action?requestMode=ABDM";
                          
							 $('#myModalserving').modal('hide');
								// window.location = ("/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp",'_blank');
			 					//url = '/CGHSAppointment/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp';
							 url=createFHashAjaxQuery("/ABDM_QMS/ABHACreation?abdmMode=appointment&isGlobal=1");

						}	


						if(id == "applycard"){

							 $('#myModalserving').modal('hide');
							 location.href= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp';
							}
						
					
						if(id == "pensionerapplycard"){

							 $('#myModalserving').modal('hide');
							 location.href= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=DAOnlinePensioner';
							}
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
				//dev
				if($('#divElementErrorsId').html().trim()!=""){
					showLoginPage();
					$('#divElementErrorsId').show();
				}
				else{$('#divElementErrorsId').hide();}
				$('.btn-close').click(function(){
					$('.modal').modal('hide');
				});

/* 				if($('#divElementErrorsMobileId').html().trim()!=""){
					showLoginPage();
					$('#divElementErrorsMobileId').show();
				}
				else{$('#divElementErrorsMobileId').hide();}
				$('.btn-close').click(function(){
					$('.modal').modal('hide');
				}); */


				function displayCircularDetails(groupId){

					var subGroupId=101;
					
					var action =createFHashAjaxQuery("/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=" + groupId + "&subGroupId=" + subGroupId);

					var jsonObject = { groupId: groupId,
									   subGroupId:subGroupId 
									  };
					console.log("inside displayCircularDetails jsonObject>>>"+JSON.stringify(jsonObject)) 
					var jsonData = window.btoa(JSON.stringify(jsonObject));
					
					try {
					    $.ajax({
					        url: action,
					        method: "GET",
					        dataType: "json", 
					        success: function (responses) {
					            console.log("AJAX Request Successful. CircularDetailsData:", responses);

					            if (responses.length > 1) {
					                // Create an array of file names from the responses
					                let fileNames = responses.map(function (response) {
					                    return response.fileName;
					                });

					                console.log("File Names Array:", fileNames);

					                // Process each response to get the fileName and pass it to the FTP function
					                responses.forEach(function (response) {
					                    const fileName = response.fileName;
					                    console.log("Processing fileName:", fileName);

					                     addRows(responses, groupId);
					                });
					            }
 					            else {
 	 					            
					                responses.forEach(function (response) {
					                    const fileName = response.fileName; 
					                    //console.log("Processing fileName:", fileName);

					                    addRows(responses, groupId);
					                });
					                
					            } 
					        },
					        error: function (xhr, status, error) {
					            console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
					            alert("An error occurred while processing your request: " + error);
					        }
					    });
					} catch (err) {
					    console.error("Exception occurred:", err.message);
					    alert("An unexpected error occurred: " + err.message);
					}
					}

				function addRows(responses,groupId) {
					//alert("Inside addRows: " + JSON.stringify(responses, null, 2));		
					const datalist = document.querySelector(`#datalistId${groupId}`);
					//$("#datalistId").html("");	
					$('.datalist').html("");	
				  responses.forEach(function(data) {
					//  console.log("Inside forEach CircularDetailsData:", data);

				    addRowData(responses,data,groupId);
				    
				  });
				}
				
				function formatDate(dateTimeStr) {
					 const datePart = dateTimeStr.split(" ")[0];

					    const dateObj = new Date(datePart);

					    const weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

					    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

					    const weekday = weekdays[dateObj.getDay()];
					    const day = dateObj.getDate();
					    const month = months[dateObj.getMonth()];
					    const year = dateObj.getFullYear();

					    return weekday+" "+day +" "+ month+" "+year;
				}

								

				function addRowData(responses,data,groupId) {
					console.log(groupId);
					//console.log("Inside addRow1234:", data);
					var  description = data && data.description ? data.description.trim() : "No Description Available";
					var  fromDate = data && data.fromDate ? formatDate(data.fromDate.trim()  ) : "No Date Available";
					var  fileName = data && data.fileName ? data.fileName.trim() : "No File Available";
					var  displayName = data && data.displayName ? data.displayName.trim() : "No DisplayName Available";
					// function t change formate date
					//console.log("Inside fromDate>>>>>:", fromDate);
					

						var showFileName = displayName;
						var folderName = "";
						var urlFileName = fileName.split("^")[0]; // covert this to base64

						//var urlFileNameBase64 = btoa(urlFileName);

						// Now you have the Base64 encoded version of urlFileName
						//console.log("urlFileNameBase6400  .>>  "+ urlFileNameBase64);
						
						if (fileName && fileName !== "No File Available") {
						    // Split the fileName by `_` to get its parts
						    let parts = fileName.split("_");
						    if (parts.length > 1) {
						        let secondPart = parts[1];
						
						        // Split the second part by `^` to extract showFileName and folderName
						        let splitParts = secondPart.split("^");
						        folderName = splitParts[1] || "";
						    }
						}

					var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName="+urlFileName+"&folderName="+folderName+"&isGlobal=1";
					
					//console.log("Show File Name:", showFileName);  
					//console.log("Folder Name:", folderName);   
					//console.log("URL File Name:", urlFileName); 
					
						//console.log("fileURL>>>>>:  ", fileURL);
						
				    const datalist = document.querySelector('.datalist');

				    const newListItem = document.createElement('li');
				   // console.log("newListItem  ++  "+ newListItem);
				    newListItem.classList.add('my-3', 'pt-3');

//				    if (responses.length > 0){
					    newListItem.innerHTML = 
						    //href='#' target='_blank' 
							 "<label class='text-decoration-none d-flex align-items-top px-2'>"+
							    "<span class='material-symbols-outlined me-2'>picture_as_pdf</span>"+
							    ""+description+""
							  +"</label>"

							  +"<div class='light-sm-txt d-block d-flex align-items-top datetime mt-1 px-2 mb-2'>"
							   +"<span class='material-symbols-outlined me-1'>schedule</span>"+
							    ""+fromDate+""+
							  "</div>"
	  
	 				     +   "<div class='multiplepdflist d-flex align-items-center px-2'>"+
					            "<ul class='d-flex align-items-top p-0 my-2'>"+
					            	"<li class='me-4'>"+
					                    "<a href='"+fileURL+"' target='_blank'  class='d-flex align-items-center align-items-top text-decoration-none'>"+
					                        "<span class='material-symbols-outlined me-1'>picture_as_pdf</span>"+
					                        ""+showFileName+""
					                    +"</a>"
					                +"</li>"
					            +"</ul>"
					        +"</div>" 
						      ;

						if(groupId==1){
							datalistId1.appendChild(newListItem);
							}
						if(groupId==2){
							datalistId2.appendChild(newListItem);
							}
						if(groupId==3){
							datalistId3.appendChild(newListItem);
							}
						if(groupId==4){
							datalistId4.appendChild(newListItem);
							}
						if(groupId==5){
							datalistId5.appendChild(newListItem);
							}
						 
				   // datalist.appendChild(newListItem);
				  }

				
				
			</script>
</body>
</html>