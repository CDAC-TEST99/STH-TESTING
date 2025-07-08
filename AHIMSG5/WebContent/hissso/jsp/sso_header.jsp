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
<link href="/AHIMSG5/hissso/portal/css/menu-newdesign.css"
	rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/responsive-newdesign.css"
	rel="stylesheet">
<link href="/AHIMSG5/hissso/portal/css/owl.carousel.min.css"
	rel="stylesheet">




<style>

h1, h2 {
	color: #003366;
}

.custom-popup-overlay {
	display: none;
	position: fixed;
	top: 0%;
	left: 0%;
	right: 10%;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.7);
	z-index: 999999;
	justify-content: center;
	align-items: center;
}

.scrollbar-always {
	/* Always show vertical scrollbar */
	border: 1px solid #ccc;
	padding: 10px;
	border-radius: 5px;
}

.centered-div {
	display: flex;
	justify-content: center; /* Center horizontally */
	align-items: center; /* Center vertically */
	height: 100vh; /* Full viewport height */
	padding: 20px; /* Padding from all sides */
	box-sizing: border-box;
	border-radius: 5px;
}

.custom-popup-content {
	background-color: white;
	padding: 20px;
	border-radius: 8px;
	width: 95%;
	height: 70%;
	max-width: 900px;
	position: absolute;
	overflow-y: scroll;
}

.custom-close-btn {
	position: sticky;
	/* border: 2px solid white; */
	top: 0;
	right: 0;
	left: 100%;
	font-size: 15px;
	cursor: pointer;
	color: white;
	z-index: 9999999;
	border: red 3px solid;
	padding: 5px;
	padding-top: 2px;
	border-radius: 25%;
	background: red;
}

.custom-close-btn:hover {
	color: red;
	background-color: white;
}

.custom-popup h2 {
	margin-top: 0;
}

/* Modal Pop up for Footer Links Starts*/
.scrollable-div {
	width: 1500px; /* Set the width of the div */
	height: 00px; /* Set the height of the div */
	overflow: auto; /* Enable scrolling */
	box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	/* border-bottom-right-radius: 10%; */
	transition: border-color 1s ease-in-out;
	animation: borderAnimation 3s infinite;
	/* Optional: Add border for better visibility */
}

#counter {
	font-size: 20px;
	color: #333;
	font-weight: bold;
	margin-top: 20px;
	@
	keyframes
	borderAnimation
	{
	0%
	{
	border-color
	:
	#82c082;
}

50


%
{
border-color


:


#adadad
;


}
100


%
{
border-color


:


#b6aeae
;


}
}
.modalIframe {
	z-index: 999999;
}

.modalPdf {
	display: none;
	position: fixed;
	z-index: 999999;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	width: 80%;
	max-width: 800px;
	height: 90vh;
	background: white;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
	border-radius: 8px;
	overflow: hidden;
}

.modal-content {
	position: relative;
	width: 100%;
	height: 100%;
	display: flex;
	flex-direction: column;
}

.modal-content iframe {
	flex-grow: 1;
	width: 100%;
	height: calc(100% - 50px); /* Leave space for footer */
}

.modal-footer {
	text-align: right;
	padding: 10px;
	background: #f1f1f1;
}

.close {
	position: absolute;
	top: 10px;
	right: 15px;
	font-size: 20px;
	cursor: pointer;
}

#myInput::placeholder {
	text-align: center;
}
</style>

</head>

<body>



<form method='post'>
		<input type='hidden' name='tokenCode'
			value='<%=java.util.Base64.getEncoder().encodeToString(new java.util.Date().toString().getBytes())%>'></input>
	</form>
	<div class="fixed-buttons wow fadeInRight">
		<div class="fixed-right-button">
			<button class="toggle-btn">
				<span class="material-symbols-outlined">mail</span>
			</button>
			<div class="hover-content">
				<a href="mailto:cghs-helpdesk@lsmgr.nic.in" class="text-white">cghs-helpdesk@lsmgr.nic.in</a>
			</div>
		</div>

		<div class="fixed-right-button">
			<button class="toggle-btn">
				<span class="material-symbols-outlined"> phone_in_talk </span>
			</button>
			<div class="hover-content">
				<a href="tel:1800-208-8900" class="text-white">1800-208-8900</a>
			</div>
		</div>
	</div>

	<header>
		<div id="topbar" class="container-fluid">
			<div class="row d-flex align-items-center">
				<!-- <div class="col-md-3 p-0">
            		<span style="float: left;"><img src="/AHIMSG5/hissso/portal/images/emblem-png.png" /></span>
            		<span style="float: left;"><p class="ps-2 m-0 pb-0">&#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930; | </p></span>
            		<span style="float: left;"><p class="fw-semibold mb-0 ms-1 tollfree "><span
                                class="material-symbols-outlined me-1">
                                phone_in_talk
                            </span>24 X 7 Helpline number: 1800-208-8900 </p>
                     </span>       
            	</div> -->

				<div class="col-12 col-md-4 p-0 d-md-block d-none">
					<div class="indian-flag d-flex align-items-center ms-3">
						<img src="/AHIMSG5/hissso/portal/images/emblem-png.png" />
						<p class="ps-2 m-0 pb-0 fw-semibold">&#x92D;&#x93E;&#x930;&#x924;&#x20;&#x938;&#x930;&#x915;&#x93E;&#x930;
							|</p>
						<p
							class="fw-semibold mb-0 ms-1 tollfree d-flex align-items-center">
							<span class="material-symbols-outlined me-1">
								phone_in_talk </span>
						<p data-lang-key='HelpLine' class="m-0">24 X 7 Helpline
							number: 1800-208-8900</p>
						</p>
					</div>
				</div>
				<div
					class="col-12 col-lg-8 col-md-8 d-flex align-items-center justify-content-md-end justify-content-start loginbtn rightarea">
					<div class="all-logins d-flex align-items-center">

						<a
							class="text-decoration-none text-white px-2 d-flex align-items-center fw-semibold"
							href="javascript:openFrame('applycard');"><span
							class="material-symbols-outlined me-1"> badge </span>
							<p data-lang-key='applyForCGHSCard' class="mb-0">
								Apply for<br> CGHS card
							</p></a> <a
							class="text-decoration-none text-white px-2 d-flex align-items-center fw-semibold"
							href="javascript:openFrame('applycardonline');"><span
							class="material-symbols-outlined me-1"> badge <!--  </span>Apply for<br> CGHS card (Online)</a> -->
						</span>
							<p data-lang-key='applyForCGHSCardOnline' class="mb-0">
								Apply for<br> CGHS card (Online)
							</p> </a> <a
							class="text-decoration-none text-white px-2 d-flex align-items-center fw-semibold"><span
							class="material-symbols-outlined me-1"> home_health </span>
							<p data-lang-key='EmpaneledHospitals' class="mb-0">
								Empaneled Hospitals<br> and Labs
							</p></a> <a
							class="text-decoration-none text-white px-2 d-flex align-items-center fw-semibold"
							href="javascript:openFrame('appointment');"><span
							class="material-symbols-outlined me-1"> book_online </span>
							<p data-lang-key='BookOnlineAppointment' class="mb-0">
								Book Online<br> Appointment
							</p></a>
					</div>
					<div
						class="search border-start border-end border-1 border-white border-opacity-25 px-xl-2 pt-1">
						<span class="material-symbols-outlined"> search </span>
					</div>

					<a
						class="text-decoration-none text-white ms-1 d-flex align-items-center fw-regular loginbuttton"
						href="/AHIMSG5/hissso/benLogin"><span
						class="material-symbols-outlined me-1"> group </span>Ben. Login</a> <a
						class="text-decoration-none text-white ms-1 d-flex align-items-center fw-regular loginbuttton"
						href="/AHIMSG5/hissso/cghsLogin"><span
						class="material-symbols-outlined me-1">login</span>CGHS Login</a>
					<div class="language">
						<select required="" id='lang' name="lang"
							aria-label="Language selection" onchange="languageChange();"
							class="ms-1 form-select">
							<option value="en" selected="selected">English</option>
							<option value="hi">Hindi</option>
						</select>
					</div>


					<!-- <div class="important-menu ms-1 pt-1">
                        <span class="material-symbols-outlined" id="dropdownMenuButton" data-bs-toggle="dropdown"
                            style="font-size: 30px;">
                            menu
                        </span>




                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <li><a class="dropdown-item" href="#">Action</a></li>
                            <li><a class="dropdown-item" href="#">Another action</a></li>
                            <li><a class="dropdown-item" href="#">Something else here</a></li>
                        </ul>

                    </div> -->


				</div>
			</div>
		</div>
		<div class="container-fluid main-menu px-md-3 white-bg">
			<div class="row p-0 d-flex align-items-center">
				<div class="col-md-3 col-lg-3 d-flex align-items-center p-0">
					<div class="logo position-relative pe-1">
						<div class="d-flex align-items-center ">
							<img src="/AHIMSG5/hissso/portal/images/logo.jpg" width="45px" />
							<div class="ps-1">
								<h1 class="fw-bold mb-1 pt-1" data-lang-key='cghsFullName'>Central
									Government Health Scheme</h1>
								<h2 class="mb-0 fw-regular"
									data-lang-key='MinistryofHealthFamilyWelfare'>Ministry of
									Health & Family Welfare</h2>
								<h3 class="fw-bold pb-1" data-lang-key='GovernmentOfIndia'>Government
									of India</h3>
							</div>
						</div>
					</div>

				</div>
				<div class="col-md-9 col-lg-9 d-flex justify-content-end p-0">
					<div class="ruby-menu-demo-header">
						<div class="ruby-wrapper">
							<button class="c-hamburger c-hamburger--htx visible-xs">
								<span>toggle menu</span>
							</button>

							<ul class="ruby-menu" id="menu"></ul>




						</div>

					</div>
				</div>
			</div>

		</div>



	</header>
	
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
	<script type="text/javascript" src="/AHIMSG5/hissso/js/md5.js"></script>
	<script type="text/javascript" src="/AHIMSG5/hissso/js/security.js"></script>

	<script src='/AHIMSG5/hissso/portal/js/portal.js?v=<%=portalVersion%>'></script>





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
                <p><strong>Effective Date:</strong> 11 March 2025</p>
                <p><strong>Last Updated:</strong>  11 March 2025</p>
            </header>

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
                    <li><strong>Retention Period:</strong> Personal data shall be retained only for the duration necessary for its purpose, as detailed in the departmentâ€™s record retention policy, after which it is securely deleted.</li>
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
            `;
        } else if (contentId === 'content2') {
            content = `
            	<header>
                <h1>Disclaimer for the CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025</p>
                <p><strong>Last Updated:</strong> 11 March 2025</p>
            </header>

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
                    

                
            `;
        }

        else if (contentId === 'content3') {
            content = `


            	<h2>1. Introduction</h2>
                <p>This Hyperlinking Policy outlines the guidelines for linking to and from the Central Government Health Scheme (CGHS) website (<a href="https://www.cghs.mohfw.gov.in" target="_blank">www.cghs.mohfw.gov.in</a>).</p>
                
                <h2>2. Linking to the CGHS Website</h2>
                <ul>
                    <li>The link must not misrepresent the CGHS website or create an impression of endorsement or affiliation where none exists.</li>
                    <li>Links should be direct to the CGHS homepage or specific service pages, without altering the original content.</li>
                    <li>No website shall frame or replicate CGHS content in a way that could mislead users.</li>
                    <li>Websites that link to CGHS must not contain defamatory, misleading, or unlawful content.</li>
                    <li>Any entity wishing to use CGHS logos, branding, or official symbols must obtain prior written permission from CGHS.</li>
                </ul>
                
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
                
                <h2>4. Prohibited Practices</h2>
                <ul>
                    <li>Deep linking, embedding, or modifying CGHS content in a way that misleads users.</li>
                    <li>Using CGHS hyperlinks on websites that host illegal, obscene, or defamatory content.</li>
                    <li>Implying official endorsement or affiliation without written approval.</li>
                    <li>Linking to the CGHS website for commercial purposes without express permission.</li>
                </ul>
                
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
                
                <h2>6. Disclaimer and Liability</h2>
                <ul>
                    <li>CGHS reserves the right to withdraw linking permissions at any time.</li>
                    <li>CGHS does not assume responsibility for any consequences resulting from accessing external links.</li>
                    <li>CGHS will not be liable for damages resulting from the use or inability to use hyperlinks provided on its website.</li>
                </ul>
                
                <h2>7. Policy Updates</h2>
                <p>This Hyperlinking Policy is subject to periodic review. Users are encouraged to review this page for the latest updates.</p>
                
                <h2>Compliance Statement</h2>
                <p>This Hyperlinking Policy ensures that CGHS hyperlinks are used responsibly and securely. CGHS remains committed to maintaining clear, lawful, and secure digital interactions across platforms.</p>
                
                `;
        }

        else if (contentId === 'content4') {
            content = `
            	<h1>Copyright Policy for CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025</p>
                <p><strong>Last Updated:</strong> 11 March 2025</p>
                
                <h2>1. Ownership of Content</h2>
                <p>All content, including but not limited to text, images, graphics, logos, documents, videos, software, and digital materials available on the Central Government Health Scheme (CGHS) website (<a href="https://www.cghs.mohfw.gov.in" target="_blank">www.cghs.mohfw.gov.in</a>) is the intellectual property of the Government of India and CGHS, unless otherwise stated. This content is protected under the Copyright Act, 1957 (India), international copyright treaties, and applicable intellectual property laws.</p>
                
                <h2>2. Permitted Use</h2>
                <p>Users may:</p>
                <ul>
                    <li>Access and use the content for personal, informational, and non-commercial purposes.</li>
                    <li>Download and print materials such as government circulars, policies, and beneficiary guidelines, provided they are used without modification and with appropriate attribution to CGHS.</li>
                    <li>Share official government notifications from the website for educational or administrative purposes, as long as they are not altered or misrepresented.</li>
                </ul>
                
                <h2>3. Prohibited Use</h2>
                <p>Users are strictly prohibited from:</p>
                <ul>
                    <li>Modifying or creating derivative works based on the websiteâ€™s content without prior written permission from CGHS.</li>
                    <li>Using CGHS logos, emblems, trademarks, or any other branding elements without official authorization.</li>
                    <li>Commercializing any website content by selling, licensing, or incorporating it into third-party products or services.</li>
                    <li>Embedding CGHS content in external websites in a way that misrepresents the original source.</li>
                </ul>
                
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
                
                <h2>5. Use of Third-Party Content</h2>
                <p>The CGHS website may contain content, references, or links to external resources owned by third parties, including government reports, external research papers, and collaborative materials. The copyright of such content remains with the respective owners, and:</p>
                <ul>
                    <li>CGHS does not claim ownership over third-party content.</li>
                    <li>Any third-party content used on the website is either under a valid license, permitted by law, or with appropriate attribution.</li>
                    <li>Users must refer to the respective third-party copyright policies before using such content.</li>
                </ul>
                
                <h2>6. Disclaimer of Liability</h2>
                <p>While all efforts have been made to ensure the accuracy and reliability of content on the CGHS website, the Government of India and CGHS are not responsible for any unauthorized reproduction, distribution, or misuse of website materials by third parties. Users accessing or using the websiteâ€™s content do so at their own discretion and risk.</p>
                
                <h2>7. Enforcement and Legal Actions</h2>
                <p>Any unauthorized use or violation of this Copyright Policy may result in:</p>
                <ul>
                    <li>Legal action under applicable copyright laws, including the Copyright Act, 1957.</li>
                    <li>Blocking of access to CGHS services for users found in violation.</li>
                    <li>Issuance of takedown notices to infringing parties under the Information Technology Act, 2000.</li>
                </ul>
                
                <h2>8. Policy Updates</h2>
                <p>This Copyright Policy is subject to periodic review and updates. Users are encouraged to review this policy regularly to stay informed about their rights and obligations.</p>
                
                <h2>Compliance Statement</h2>
                <p>This Copyright Policy ensures that the intellectual property of CGHS and the Government of India is protected and used in accordance with applicable copyright laws and digital governance standards. Users are expected to respect these guidelines while accessing and utilizing the CGHS website and its content.</p>


                `;}
        else if (contentId === 'content5') {
            content = `
            	<h1>Content Review Policy</h1>

                <h2>1. Purpose</h2>
                <p>The Content Review Policy ensures that all content on the CGHS website remains accurate, relevant, and compliant with the Guidelines for Indian Government Websites (GIGW) 3.0.</p>

                <h2>2. Review Frequency</h2>
                <ul>
                    <li><strong>Quarterly Reviews:</strong> All general website content is reviewed every three months.</li>
                    <li><strong>Bi-Annual Reviews:</strong> Critical healthcare-related information, eligibility criteria, and beneficiary services undergo a detailed review every six months.</li>
                    <li><strong>Annual Compliance Reviews:</strong> A full content audit is conducted once a year to ensure adherence to GIGW 3.0, cybersecurity, and accessibility standards.</li>
                </ul>

                <h2>3. Review Process</h2>
                <ul>
                    <li>The <strong>Content Management Team</strong> is responsible for identifying content requiring updates or removal.</li>
                    <li>The <strong>Technical & Cybersecurity Team</strong> ensures all security protocols are maintained in line with CERT-In recommendations.</li>
                    <li>Any content update request must be submitted for approval by the <strong>Webmaster</strong> and CGHS Compliance Team.</li>
                </ul>

                <h2>4. Corrections & Updates</h2>
                <ul>
                    <li>Any factual inaccuracies identified during the review process will be corrected immediately.</li>
                    <li>Any new updates, policies, or guidelines mandated by the government will be added within five working days of notification.</li>
                    <li>If an urgent correction is required (such as a security concern or incorrect beneficiary information), it will be implemented within 24 hours.</li>
                </ul>

                <h2>Compliance Statement</h2>
                <p>CGHS ensures compliance with data protection laws, cybersecurity best practices, and GIGW 3.0 standards, keeping all published content accurate, secure, and accessible to beneficiaries.</p>


                `;}
        else if (contentId === 'content6') {
            content = `
            	<h1>Content Contribution, Moderation & Approval Policy</h1>

                <h2>1. Purpose</h2>
                <p>This policy governs how content is contributed, moderated, and approved for publication on the CGHS website, ensuring accuracy, reliability, and adherence to government communication standards.</p>

                <h2>2. Content Contribution Guidelines</h2>
                <ul>
                    <li>Content contributions are allowed only from authorized CGHS personnel.</li>
                    <li>Contributors must ensure that all information aligns with CGHS policies and government guidelines.</li>
                    <li>Submissions must include appropriate references and citations where necessary.</li>
                </ul>

                <h2>3. Moderation Process</h2>
                <ul>
                    <li>A <strong>Content Moderation Team</strong> will review all submitted content for factual accuracy, grammar, and compliance with security and accessibility standards.</li>
                    <li>Any submissions containing sensitive or restricted information will undergo additional scrutiny by the CGHS Compliance Team.</li>
                    <li>User-generated content, such as comments or inquiries, will be monitored and moderated to maintain decorum and accuracy.</li>
                </ul>

                <h2>4. Content Approval Workflow</h2>
                <ul>
                    <li><strong>Step 1: Submission</strong>  Authorized personnel submit content through the CGHS Content Management System.</li>
                    <li><strong>Step 2: Review</strong>  Moderation Team checks content for accuracy and compliance.</li>
                    <li><strong>Step 3: Approval</strong>  The Webmaster and Designated Officials approve the content for publication.</li>
                    <li><strong>Step 4: Publication</strong>  Approved content is published on the CGHS website.</li>
                </ul>


                `;}
        else if (contentId === 'content7') {
            content = `
                      
            	 <h1>Content Archival Policy</h1>

                <h2>1. Purpose</h2>
                <p>The Content Archival Policy of the Central Government Health Scheme (CGHS) ensures that digital content on the CGHS website is periodically reviewed, archived, and managed to maintain relevance, accuracy, and compliance with legal and regulatory requirements.</p>

                <h2>2. Archival Guidelines</h2>
                <ul>
                    <li>All web content will be reviewed every year to ensure its continued relevance.</li>
                    <li>Content that is no longer applicable or outdated will be archived for a minimum of five years before deletion.</li>
                    <li>Content of historical importance, government circulars, policy updates, and beneficiary guidelines will be permanently archived for reference.</li>
                    <li>Archived content will be securely stored and accessible upon request through official CGHS channels.</li>
                </ul>

                <h2>3. Responsibilities</h2>
                <ul>
                    <li>The <strong>Web Administrator</strong> is responsible for identifying outdated content for archival.</li>
                    <li>The <strong>CGHS Content Management Team</strong> will oversee the periodic content review process.</li>
                    <li>Archived content retrieval requests must be approved by the <strong>CGHS Content Oversight Committee</strong>.</li>
                </ul>

                `;}


        else if (contentId === 'content8') {
            content = `
            	 <h1>CGHS Password and Authentication Policy</h1>

                <h2>1. Purpose</h2>
                <p>This policy establishes the requirements for password security and authentication mechanisms within the Central Government Health Scheme (CGHS). It aims to ensure the protection of user accounts, prevent unauthorized access, and uphold data integrity and confidentiality.</p>

                <h2>2. Authentication Mechanism</h2>
                <p>CGHS employs <strong>Single Sign-On (SSO)</strong> authentication through <strong>MeriPehchaan</strong>, the national digital identity platform, to ensure secure and seamless access to CGHS services.</p>

                <h3>Primary Authentication Methods:</h3>
                <ul>
                    <li><strong>MeriPehchaan SSO Login:</strong> Recommended for beneficiaries and employees for centralized access control.</li>
                    <li><strong>Username & Password-Based Authentication:</strong> Used for non-SSO CGHS users, including internal personnel.</li>
                    <li><strong>Multi-Factor Authentication (MFA):</strong> Mandatory for administrators and privileged accounts to enhance security.</li>
                </ul>

                <h2>3. Password Policy for Non-SSO Users</h2>
                
                <h3>3.1 Password Complexity Requirements</h3>
                <ul>
                    <li>Minimum password length: 12 characters (maximum 20 characters).</li>
                    <li>Must contain at least one uppercase letter (A-Z).</li>
                    <li>Must contain at least one lowercase letter (a-z).</li>
                    <li>Must include at least one numeric digit (0-9).</li>
                    <li>Must have at least one special character (@ $ # ? _ % & !).</li>
                    <li>Must not contain the userâ€™s name, ID, or commonly used dictionary words.</li>
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

                <h2>4. Multi-Factor Authentication (MFA) Policy</h2>
                <ul>
                    <li>MFA is mandatory for all CGHS administrators and employees.</li>
                    <li>MFA is enabled for beneficiaries through OTP-based authentication via MeriPehchaan SSO.</li>
                    <li>Additional authentication factors, such as biometric verification, may be implemented in future security enhancements.</li>
                </ul>

                <h2>5. Single Sign-On (SSO) via MeriPehchaan</h2>
                <p>CGHS encourages users to authenticate via <strong>MeriPehchaan</strong>, which provides:</p>
                <ul>
                    <li>Secure identity verification using Aadhaar, DigiLocker, or mobile OTP authentication.</li>
                    <li>Centralized access control, reducing password fatigue and the need for multiple logins.</li>
                    <li>Enhanced security through passwordless authentication.</li>
                    <li>Direct integration with CGHS e-Services to ensure seamless user experience.</li>
                </ul>

                <h2>6. Password Storage and Confidentiality</h2>
                <ul>
                    <li>Passwords must never be shared with others, including IT personnel.</li>
                    <li>Passwords must be stored securely, using encryption and industry-standard hashing techniques.</li>
                    <li>Administrators must enforce password hashing and salting mechanisms to mitigate security risks.</li>
                </ul>

                <h2>7. Password Reset and Recovery</h2>
                <ul>
                    <li>Self-service password reset is available through registered email/SMS OTP verification.</li>
                    <li>SSO users must reset their credentials via MeriPehchaanâ€™s account recovery process.</li>
                    <li>Additional biometric or multi-factor authentication may be required for critical system access resets.</li>
                </ul>

                <h2>8. System Administrator Responsibilities</h2>
                <ul>
                    <li>Implement role-based access control (RBAC) to enforce least privilege principles.</li>
                    <li>Conduct regular security audits to ensure compliance with password policies.</li>
                    <li>Monitor login activities and enforce adaptive authentication for suspicious login attempts.</li>
                </ul>

                <h2>9. Compliance and Enforcement</h2>
                <ul>
                    <li>Failure to comply with this policy may result in account suspension or restricted access.</li>
                    <li>Periodic security awareness training will be conducted for all CGHS users.</li>
                    <li>Regular security audits will be performed to ensure continued compliance with government cybersecurity policies.</li>
                </ul>

                `;}
        else if (contentId === 'content9') {
            content = `
            	<h1>Accessibility Statement for CGHS Website</h1>
                <p><strong>Effective Date:</strong> 11 March 2025</p>
                <p><strong>Last Updated:</strong> 11 March 2025</p>

                <h2>1. Commitment to Accessibility</h2>
                <p>The Central Government Health Scheme (CGHS) is dedicated to ensuring that its digital services are accessible to all users, regardless of device, technology, or ability. Our objective is to provide an inclusive and seamless user experience across various platforms, including desktop computers, laptops, and web-enabled mobile devices.</p>
                <p>Recognizing the importance of accessibility, CGHS has integrated features to accommodate users with visual, auditory, motor, and cognitive disabilities. Assistive technologies such as screen readers, screen magnifiers, and keyboard navigation tools are supported to enhance accessibility.</p>

                <h2>2. Compliance with Accessibility Standards</h2>
                <p>The CGHS website has been developed in adherence to <strong>Guidelines for Indian Government Websites (GIGW) 3.0</strong> and follows universal design principles to ensure usability for all visitors. The website is built using <strong>XHTML 1.0 Transitional</strong> and complies with <strong>Level AAA of the Web Content Accessibility Guidelines (WCAG) 2.1</strong>, as established by the <strong>World Wide Web Consortium (W3C)</strong>.</p>

                <h3>The CGHS website ensures:</h3>
                <ul>
                    <li><strong>User-Centric Design & Accessibility:</strong> Optimized for screen readers and keyboard navigation.</li>
                    <li><strong>API Integrations:</strong> Secure connectivity with India Portal, DigiLocker, Aadhaar-based identity verification, Single-Sign-On (SSO), MyGov, and other government platforms.</li>
                    <li><strong>Security & Compliance:</strong> Compliance with ISO 27001, OWASP security protocols, and CERT-In cybersecurity advisories.</li>
                    <li><strong>Multilingual Support:</strong> Availability in multiple Indian languages to cater to diverse users.</li>
                    <li><strong>Regular Audits & Compliance Checks:</strong> Subject to STQC certification and periodic accessibility assessments.</li>
                </ul>

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

                <h2>5. External Websites & Third-Party Content</h2>
                <p>Certain sections of this website contain links to external websites, which are maintained by their respective government departments. CGHS is not responsible for the accessibility compliance of external websites, as their accessibility is managed by the respective entities.</p>

                <h2>6. Reporting Accessibility Issues</h2>
                <p>We are committed to maintaining an accessible digital platform. If you encounter any accessibility barriers or have suggestions for improvement, please contact us:</p>
                <ul>
                    <li><strong>Email:</strong> <a href="mailto:cghs-helpdesk@lsmgr.nic.in">cghs-helpdesk@lsmgr.nic.in</a></li>
                    <li><strong>Helpline:</strong> 1800-208-8900</li>
                    <li><strong>Feedback Form:</strong> <a href="[Insert Feedback Form URL]">[Insert Link to Feedback Form]</a></li>
                </ul>
                <p>We aim to acknowledge all accessibility-related inquiries within five working days and provide an alternative means of accessing the requested content if necessary.</p>

                <h2>7. Future Accessibility Enhancements</h2>
                <p>CGHS is actively enhancing its accessibility framework through:</p>
                <ul>
                    <li>Biennial accessibility audits to identify and rectify issues.</li>
                    <li>Implementation of AI-powered accessibility solutions.</li>
                    <li>Expansion of voice-assisted and screen reader-compatible functionalities.</li>
                    <li>Optimization of mobile and tablet accessibility features.</li>
                </ul>
                <p>We encourage users to share feedback to help us improve the accessibility of CGHS services.</p>

                <h2>Compliance Statement</h2>
                <p>CGHS remains committed to fostering universal digital access and ensuring that all individuals, regardless of their abilities, can interact with our online services efficiently. The CGHS website follows globally recognized web accessibility, usability, and inclusive design principles to uphold equal access to critical healthcare information and services.</p>

                `;}
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
            // Check label text
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
            li[i].style.display = found ? "" : "none";
        }
    }


    document.addEventListener('DOMContentLoaded', function () {
        // Define the URL to fetch file details
        var coveredCityUrl = "/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=10&subGroupId=103";
        //var faclityCGHSUrl = "/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=10&subGroupId=102";
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
                    alert("An error occurred while processing your request: " + error);
                }
            });
        } catch (err) {
            console.error("Exception occurred:", err.message);
            alert("An unexpected error occurred: " + err.message);
        }
    }
	 $(document).ready(function(){

		 //displayCircularDetails(1,101);
		  
	 });
    					function openFrame(id){
						
						var url="";

						if(id=="appointment"){
                          
							 $('#myModalserving').modal('hide');
							 
							 url=createFHashAjaxQuery("/ABDM_QMS/ABHACreation?abdmMode=appointment&isGlobal=1");

						}	


						if(id == "applycard"){

							 $('#myModalserving').modal('hide');
							 url= '/CGHSCardMgmt/FormFlowXACTION?isGlobal=1&masterKey=Mobileotp';
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
	
  