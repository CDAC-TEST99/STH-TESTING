<!doctype html>
<%@ page import="java.util.Properties, java.io.InputStream" %>
<%@page import="hisglobal.utility.SecurityUtil"%>
<%@page import="hisglobal.utility.HisUtil"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@page import="hisglobal.security.SecureHashAlgorithm"%>
<%@page import="hissso.config.HISSSOServerConfig"%>
<%@page import="hislogin.config.HISLoginConfig"%>
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
	<meta name="description"
		content="Central Government Health Scheme Ministry of Health &amp; Family Welfare Government of India" />
	<meta name="author" content="CDAC">
	<meta name="keywords" content="CGHS,HMIS,cdac">
	<meta name="keywords"
		content="CGHS,Central Government Health Scheme,Ministry of Health & Family Welfare,mohfw, cdac">
	<title>Central Government Health Scheme</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="shortcut icon" href="/AHIMSG5/hissso/portal/images/favicon.ico">
<!--  CSS Files -->
<link href="/AHIMSG5/hissso/portal/css/bootstrap-min.css" rel="stylesheet" />
<link rel="stylesheet" href="/AHIMSG5/hissso/portal/css/accessibility/accesibility-style-v2.1.css">
<link href="/AHIMSG5/hissso/portal/css/animate.css" rel="stylesheet" />
<link href="/AHIMSG5/hissso/portal/fontawesome/css/all.min.css" rel="stylesheet" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="/AHIMSG5/hissso/portal/css/style-newdesign.css" rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/menu-newdesign.css" rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/responsive-newdesign.css" rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/owl.carousel.min.css" rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/empt.css" rel="stylesheet">

<link href="/AHIMSG5/hissso/portal/css/bootstrap-min.css" rel="stylesheet" />
<link href="/AHIMSG5/hissso/portal/fontawesome/css/all.min.css" rel="stylesheet" />

<link rel="stylesheet" href="/HIS/hisglobal/bbpublic/assets/datatables/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="/HIS/hisglobal/bbpublic/assets/datatables/css/buttons.dataTables.min.css">

</head>

<body>

  <!-- Header -->
  <header class="header">
  
  <a href="/AHIMSG5/hissso/Login" data-lang-key="CGHSLogin" style="margin-right: 10px; " class="btn btn-danger float-end">Close</a>
    <div class="d-flex justify-content-between align-items-center">
      <!-- Left Image -->
      <img src="/AHIMSG5/hissso/portal/images/cghs_logo.jpg" alt="CGHS Logo" class="header-logo">

      <!-- Centered Text -->
      <div class="text-center">
        <h1>Central Government Health Scheme</h1>
        <p>Ministry of Health & Family Welfare | Government of India</p>
      </div>
		
      <img src="/AHIMSG5/hissso/portal/images/satyamev_jayate.png" alt="Satyamev Jayate" class="header-logo">
     
    </div>
  </header>

  <!-- Main Form Section -->
  <main class="container my-3">
  <h2 id=restrictedMed class="text-center mb-4 fw-bold">Restricted Medicine</h2>
  
  <div class="btn-group w-50 d-flex align-item-center bg-light rounded p-1 mb-4">
           <button id="stcId" type="button" 
           class="btn btn-res-medi flex-grow-1 active" onclick="restMedicineDetail(1)" >
               STC
           </button>
           <button id="nonStcId" type="button" class="btn btn-res-non-medi flex-grow-1"  onclick="restMedicineDetail(2)">
              NON STC
           </button>
       </div>
    <div class="row justify-content-center">
      <div class="col-md-10 col-lg-8">
 		  <div id="tableContainer" class="animate__animated animate__fadeInUp animate__faster" >
			  <h4 id="tableHeader"></h4>
			    <div style="max-height: 400px;">
					  <table id="restrictedMedicineTableID" class="table table-bordered table-hover" style="margin-bottom: 0;">
					    <thead style="position: sticky; top: 0; background: #fff; z-index: 1;">
					      <tr class="table-dark text-center">
					        <th>Name of Restricted Medicine</th>
					        <th>Dosage type</th>
					        <th>Supplier / Manufacturer</th>
					      </tr>
					    </thead>
					    <tbody>
					      <!-- Dynamic content via JS -->
					    </tbody>
					  </table>
				</div>
			     
			  </div>
      </div>
    </div>

  </main>

  <!-- Footer -->
  <footer class="footer">
    Disclaimer: Website content managed by Ministry of Health and Family Welfare, GOI. Design, Developed and Hosted by Center for Development of Advanced Computing © 
    <a href="https://www.cdac.in/" style="color: inherit;">CDAC</a>
  </footer>

  <script src="/AHIMSG5/hissso/portal/js/bootstrap.bundle.min.js"></script>
  <script src="/AHIMSG5/hissso/portal/js/jquery-3.7.1.min.js"></script>
  <script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
  <script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>
  <script type="text/javascript" src="/HIS/hisglobal/js/hashFunctions.js"></script>
  <script type="text/javascript" src="/HIS/hisglobal/js/util.js"></script>
  <script src="/AHIMSG5/hissso/portal/js/restrictedMedicine.js" type="text/javascript"></script>
  
<script src="/HIS/hisglobal/js/responsiveDataTablewithPlus/datatables.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/dataTables.buttons.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.flash.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/jszip.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.html5.min.js"></script>
<script src="/HIS/hisglobal/FormFlowX/plugins/dataTable/datatables-buttons/js/buttons.print.min.js"></script>

  <script>
    $(document).ready(function () {
      $('#searchInput').hide();

      $('#submitBtn1').on('click', function () {
        $('#tableContainer').show();
        $('#searchInput').show();
        $('#rowCount').show();
      });

      $('#searchInput').on('keyup', function () {
        var value = $(this).val().toLowerCase();
        $('#hospitalTable tbody tr').filter(function () {
          $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);

          var visibleRows = $('#hospitalTable tbody tr:visible').length;
          $('#totalRecords').text(visibleRows);
        });
      });
    });

 
  </script>



</body>
<style>
    /* Increase search input width */
    div.dataTables_filter input {
        width: 300px !important; /* or any width you prefer */
        text-align: center; /* Center text (and placeholder) */
    }

    /* Optional: Center the entire search box */
    div.dataTables_filter {
        text-align: center !important;
    }
	  .btn-res-medi {
		--bs-btn-active-bg: #6fa7b7;
		
	}
		.btn-res-non-medi{
		--bs-btn-hover-bg: #6fa7b7;
		--bs-btn-active-bg: #6fa7b7;
	}
</style>

</html>
