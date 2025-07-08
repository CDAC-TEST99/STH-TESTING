<!DOCTYPE html>
<%@page import="thirdpartyservices.bharatkosh.service.BharatkoshClient"%>
<html lang="en">

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CGHS-Form Type selection</title>
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">

   
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/getselectcardtype.js"></script>


<script>
/* 

function printFormContainer() {
    // Get the content inside the formContainer div
    var content = document.getElementById("formContainer").innerHTML;

    // Open a new window for printing
    var printWindow = window.open('', '', 'height=800,width=1000');

    // Write the HTML content to the new window
    printWindow.document.write('<html><head><title>Print Form</title></head><body>');
     printWindow.document.write(content);  // Write the content of the form container
    printWindow.document.write('</body></html>');

    // Close the document to finish writing and start printing
    printWindow.document.close();

    // Trigger the print dialog
    printWindow.print();

    // Close the print window after printing
    printWindow.close();
} */
function printFormContainer() {
    // Get the actual DOM element
    var formContainer = document.getElementById("formContainer");

    // Clone the entire container to preserve the current state
    var clone = formContainer.cloneNode(true);

    // Open a new print window
    var printWindow = window.open('', '', 'height=800,width=1000');

    // Prepare the HTML for printing
    printWindow.document.write('<html><head><title>Print Form</title>');

    // Optional: Include your CSS if needed
    var styles = document.querySelectorAll('link[rel="stylesheet"], style');
    styles.forEach(style => {
        printWindow.document.write(style.outerHTML);
    });

    printWindow.document.write('</head><body>');
    printWindow.document.write(clone.outerHTML);  // Use outerHTML of the cloned node
    printWindow.document.write('</body></html>');

    printWindow.document.close();

    // Ensure print is triggered after content loads
    printWindow.onload = function () {
        printWindow.focus();
        printWindow.print();
        printWindow.close();
    };
}

</script>
<style type="text/css">
.status-radio {
  display: flex;
  gap: 20px;
  font-size: 18px;
}

.status-radio-button {
  margin-right: 10px;
}

label {
  cursor: pointer;
}


.instructions {
  margin-bottom: 20px;
  padding: 10px;
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  border-radius: 5px;
}

.instructions p {
  font-size: 16px;
  margin-bottom: 10px;
}

.instructions ul {
  list-style-type: disc;
  margin-left: 20px;
}

.instructions li {
  font-size: 14px;
}


</style>
</head>


  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  


<body >
         

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
 <fieldset  id="ENTRYFORM"> 
 
<div class="container pb-2 text-dark "  style="display:none;" id="applyplastccard">                    
                                   

               <h3 style="text-align: center;">Apply Online for CGHS Card</h3>
                <div class="row mt-5">
				<div class="col-md-7 mt-4">
					<h6><i class='fa-solid fa-hand-point-right fa-xl'></i> Retired Employee  applying for Pensioner CGHS Card</h6>
				</div>
				<div class="col-md-3">
					<button id="Pensioner" name="Pensioner" value="P"  class='btn btn-his-outline'  onclick="openpage(this)">Apply Here</button>
				</div>
				</div>
				<hr>
				<div class="row">
				<div class="col-md-7 mt-4">
					<h6><i class='fa-solid fa-hand-point-right fa-xl'></i> Serving Employee and applying for CGHS Card for the First Time</h6>
				</div>
				<div class="col-md-3">
					<button id="Serving" name="Serving" value="S"    class='btn btn-his-outline' onclick="openpage(this)">Apply Here</button>
				</div>
				</div>	
				<hr>
				<div class="row">
				<div class="col-md-7 mt-4">
				<h6><i class='fa-solid fa-hand-point-right fa-xl'></i> Superannuate in 6 months and applying for Pensioner CGHS Card.</h6>
				</div>
				<div class="col-md-3">
					<button id="Superannuate" name="Superannuate" value="SA"    class='btn btn-his-outline' onclick="openpage(this)">Apply Here</button>
				</div>
				</div>
				<hr>
			
<h6 style="color: red;">
  Note:-Serving beneficiaries are requested to take a printout of the completed application and get it forwarded from their department with all supporting documents to the Additional Director of the CGHS city they belong to.
</h6>
			
</div>
	
	
	
	  
     <div style="margin-left: -20px;display:none;" id="getstatusbeneficiary">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Online Applied Plastic Card Status</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
        <th style="width: 10%">Sr. No.</th>
        <th style="width: 15%">Acknowledgement No.</th>
        <th style="width: 15%">FirstName</th>
        <th style="width: 10%">ApplyDate</th>
        <th style="width: 10%">CardType</th>
        <th style="width: 10%">Sub CardType</th>
        <th style="width: 10%">Mobile No.</th>
        <th style="width: 15%">Status</th>
        <th style="width: 15%">Payment Status</th>
          <th style="width: 15%">Remarks</th>
                <th style="width: 10%" colspan="2">Action</th>
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
  <div style="text-align: left;">
  <h6>
    If you believe you are eligible as per CGHS rules, please review your details and re-apply with correct and complete information.
  </h6>
  <p>
    For more details on eligibility under CGHS, kindly refer to the FAQs section on the CGHS website.
  </p>
</div>

</div>



<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog" style="max-width:100%">
                <div class="modal-content">
                    <div class="modal-header">
                     
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                               				        	
<div class="container mr-t10 mr-b20">
	<div class="text-right">
<!-- 	 <button type="button" class="btn btn-primary" onclick="window.print()" id="SAVEPREVIEW"  data-bs-dismiss="modal" >Print</button>

 -->	
                         <button type="button" class="btn btn-primary" onclick="printFormContainer()" id="SAVEPREVIEW" data-bs-dismiss="modal">Print</button>
 
 </div>
                    <div id="formContainer" class='text-dark'></div>
                    </div>
                    </div>
                    </div>
                    </div>
                    </div>	
                    
  
       
  
<!-- <div class="container-fluid bordercontainer" style="margin-left: -20px; max-width:60%; margin-right: auto; margin-left: auto;">

 -->  
 <!-- <div id="Paymententerdetails" style="display:none;">
 
    <div class="container-fluid" style="margin-left: -20px;" >
      <h3 class='mt-4'>Payment Mode</h3>
      <hr/>
        <div class="row">

  <div class="row">
    
    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patPaymentBankName">Payment Mode :</label>
                <input type="text" class="form-control form-control-sm" id="patPaymentBankName" name="patPaymentBankName" value="BHARAT KOSH" placeholder="Enter patPaymentBankName" data-validation="mandatory,numeric" maxlength="100">
      
        <div class="invalid-feedback"></div>
      </div>
    </div>

    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patPaymentDDNo">Demand Draft / Bharat Kosh Reference No.:</label>
        <input type="text" class="form-control form-control-sm" id="patPaymentDDNo" name="patPaymentDDNo" placeholder="Enter Reference No" data-validation="mandatory,numeric" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patPaymentDDate">Demand Draft / Bharat Kosh Reference Date:</label>
        <input type="text" class="form-control form-control-sm" id='patPaymentDDate' name='patPaymentDDate' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patpaymentAmount">Amount:</label>
        <input type="text" class="form-control form-control-sm" id="patpaymentAmount" name="patpaymentAmount" placeholder="Enter Amount" data-validation="mandatory" maxlength="100">
        <div class="invalid-feedback"></div>
      </div>
    </div>

    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patpaymentvalidfrom">Valid From:</label>
        <input type="text" class="form-control form-control-sm" id='patpaymentvalidfrom' name='patpaymentvalidfrom' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
    <div class="col-sm-3">
      <div class="form-group">
        <label class="col-form-label col-form-label-md" for="patpaymentvalidto">Valid To:</label>
        <input type="text" class="form-control form-control-sm" id='patpaymentvalidto' name='patpaymentvalidto' placeholder="dd-Mon-yyyy" data-validation="mandatory" maxlength="11" readonly="readonly">
        <div class="invalid-feedback"></div>
      </div>
    </div>
    
     <div class="col-sm-3"  id="fileuploadpaymentreceipt" >
		           
							<input type="hidden" name="patpaymentreceipt"
								id="filename1" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="Payment Receipt">Payment receipt<span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile1" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="1" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 50%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon1" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload1"
									onclick="uploadDoc(1,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>

		          </div>
		
  </div>
   <div class="legend3">
			
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="savedetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Save Details</button>			
		</div>
</div>
</div>
          </div> -->
          <div style="margin-left: -20px; display:none;" id="paymentdetailsBeneficiary">
  <table class="table table-striped border text-center">
    <thead>
      <tr>
        <th colspan="9">
          <h3>Payment Details</h3>
        </th>
      </tr>
    </thead>
    <thead class="information">
      <tr class="tableHeading">
        <th style="width: 5%">Sr. No.</th>
        <th style="width: 8%">Acknowledgement No.</th>
        <th style="width: 8%">FirstName</th>
        <th style="width: 8%">Card Category</th>
        <th style="width: 8%">Ministry</th>
        <th style="width: 4%">Pay Scale</th>
        <th style="width: 4%">Card Validity</th>
        <th style="width: 8%">CPC</th>
        <th style="width: 8%">Amount</th>
<!--          <th style="width: 11%">Enter PAO CODE/Remarks</th>
 -->       <!--  <th style="width: 5%">AD City</th> -->
                   <th style="width: 8%">Action</th>
         
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
</div>

  <div class="col-sm-3"  id="fileuploadpaymentreceipt"  style="display:none">
		           
							<input type="hidden" name="patpaymentreceipt"
								id="filename1" value="" /> <label
								class="col-form-label col-form-label-sm"
								for="ID Proof"
								data-langtag="Payment Receipt">Upload  <span class="star text-danger">
									*</span>
							</label>

							<div id="displayFile1" class="file-group">
								<label class="div-inline"
									style="float: left; margin-right: 2px;"><span
									class="btn  btn-his-sm  btn-sm">Choose File<input
										type="file" style="display: none;" id="1" name="file">
								</span></label> <input type="text"
									class="form-control form-control-sm classMandat"
									readonly="readonly"
									style="float: left; margin-right: 2px; width: 50%"
									data-validation="mandatory">

							</div>

							<div id="divFaIcon1" style="float: left; margin-right: 2px;">
								<a class="btn  btn-his-sm  btn-sm" id="faUpload1"
									onclick="uploadDoc(1,'CARDDOCUMENT','1');">Upload</a>

							</div>
							<div class="invalid-feedback"></div>

							<br />
							<br /> <span style="color: red;">(Only .pdf, .jpg, .jpeg,
								.png, Files are allowed upto 5 MB)</span>
								
								
			<div class="legend3">
			<button class='btn btn-his ' id="BTNNEXT1"  onclick="savedetails()"><i class='fas fa-save fa-fw'></i>&nbsp;Save Details</button>			
		</div>	

		          </div>
		
  
  

<!--   <div class="status-radio"  id="showpabharatkoshpaymentmode" style="display:block;">
    <h2>Bharatkosh Payment Mode</h2>
  <label>
    <input type="radio" name="status" value="online"  onclick="setStatus('Online')" class="status-radio-button"> Online
  </label>
  <label>
    <input type="radio" name="status" value="offline" onclick="setStatus('Offline')" class="status-radio-button"> Offline
  </label>
</div>
   -->
  <div class="status-radio" id="showpabharatkoshpaymentmode" style="display:none;">
  <!-- Instruction div -->
  <div class="instructions">
    <p>Please select the payment mode:</p>
    <ul>
    
      <li><strong>Online:</strong> select this option in case you wish pay through online mode such as internet banking, credit card or debit card, UPI or IMPS. Please note that the daily limit of UPI transactions is Rs 1 Lakh per day as set by National Payments Corporation of India.</li>
      <li><strong>Offline:</strong> select this option if you prefer to pay in physical mode (offline) through Bank (NEFT). You will be redirected to BharatKosh Website where you will need to enter your Bank account Number and IFSC Code to generate a Deposit Slip. Please take a print out and visit your bank for payment. Note: The transaction has to be completed within 15 days of generating Deposit Slip.
</li>
    </ul>
  </div>

  <h2>Bharatkosh Payment Mode</h2>
  <label>
    <input type="radio" name="status" value="online" onclick="setStatus('Online')" class="status-radio-button"> Online
  </label>
  <label>
    <input type="radio" name="status" value="offline" onclick="setStatus('Offline')" class="status-radio-button"> Offline
  </label>
</div>
  
  

            <input type="hidden" name="hiddentrackingid" id="hiddentrackingid" value=""/>
          
          </fieldset>
<input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />
	         <input type='hidden' name="hiddenId12" id='hiddenId12' />
	      <input type='hidden' name="selectcardtype" id='selectcardtype' />
         <input type="hidden" name="hiddenmobile" id="hiddenmobile" value="<%=request.getParameter("userMobile")%>"/>
	       <input type="hidden" name="onlineapplicationhidden" id="onlineapplicationhidden" value="<%=request.getParameter("onlineapplicationhidden")%>"/>
</form>
<!--  <form target="_blank" action="https://bharatkosh.gov.in/BKePay" id="BharatKoshPaymentFORM" name="BharatKoshPaymentACTION" method="post">  -->

 <form target="_blank" action="https://training.pfms.gov.in/bharatkosh/bkepay" id="BharatKoshPaymentFORM" name="BharatKoshPaymentACTION" method="post">
		<!-- <fieldset  id="ENTRYFORM"> --> 
 		<input type="hidden" name="isGlobal" id='isGlobalLocalVarBk' value="<%=isGlobal%>"/>
	    <input type='hidden' name="hmode" id="hmodeBK" value="BharatkoshPaymentRequest"/>
 		<input type='hidden' name="bharrkkosh" id="bharrkkoshBK" value=""/>		
</form>
</body>

</html>
