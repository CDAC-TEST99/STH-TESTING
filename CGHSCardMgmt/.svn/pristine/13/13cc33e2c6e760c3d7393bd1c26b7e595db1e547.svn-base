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

   
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/printacknowledgement.js"></script>


<script>


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
}
</script>
</head>


  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
           		
           		String userMobile=request.getParameter("hiddenmobile");
           		System.out.println("value of mobileno" + userMobile);

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
        <th style="width: 10%">Action</th>
      </tr>
    </thead>
    <tbody>
      <!-- Data rows go here -->
    </tbody>
  </table>
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
                                <input type="hidden" name="hiddenmobile" id="hiddenmobile" value="<%=request.getParameter("patMobileNo")%>"/>
	       <input type="hidden" name="onlineapplicationhidden" id="onlineapplicationhidden" value="<%=request.getParameter("onlineapplicationhidden")%>"/>
</form>

<form target="_blank" action="https://training.pfms.gov.in/bharatkosh/bkepay" id="BharatKoshPaymentFORM" name="BharatKoshPaymentACTION" method="post">
 		<!-- <fieldset  id="ENTRYFORM"> --> 
 		<input type="hidden" name="isGlobal" id='isGlobalLocalVarBk' value="<%=isGlobal%>"/>
	    <input type='hidden' name="hmode" id="hmodeBK" value="BharatkoshPaymentRequest"/>
 		<input type='hidden' name="bharrkkosh" id="bharrkkoshBK" value=""/>		
</form>
</body>

</html>
