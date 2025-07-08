  <script src="/AHIMSG5/hislogin/transactions/js/transferCardListingPage.js"></script>
   <script src="/AHIMSG5/hislogin/transactions/js/security.js"></script>
   
  
<form id="regList"  method='POST'>

			
<section  class="pt-1 mt-1" style='min-height:100vh;letter-spacing: 1px;padding:15px;'> 
	<div class='row'>
		<div class='col-md-2' style="margin-top: -7px;margin-left: -34px;">
			<span class="badge bg-light text-primary"><h5 class='mt-1' id='listModuleTitle'></h5></span>
		</div>
	    <div class='col-md-3  mb-2'>
	    	<div class="form-group">
              	<label class="col-form-label col-form-label-md" for="patDOB">Search :</label>
			<div class='input-group'>
				<input type='text' class='form-control' placeholder='Name/Tracking ID./Mobile' id='search' name='search' aria-label='Username' aria-describedby='input-group-right'>
				<span class='input-group-text' id='input-group-right-example'><i class='fa-solid fa-magnifying-glass fa-fw'></i></span>				
			</div>
			<div class="text-primary" id='searchInfo' style="display: none;">Press enter to search</div>
			</div>
		</div>
		<!-- <div class='col-md-2  mb-2 hideOnSearch' >
			<div class="form-group">
              	<label class="col-form-label col-form-label-md" for="applicationStatus">Application Type :</label>
              	<select class=" form-control filters" id='applicationType' name="applicationStatus">
              		<option value="ALL" selected >All</option>
              	</select>              	
              	<div class="invalid-feedback"></div>
 			 </div>
		</div> -->
		<div class='col-md-3  mb-2 hideOnSearch' >
			<div class="form-group">
              	<label class="col-form-label col-form-label-md" for="applicationStatus">Status :</label>
              	<select class="form-control filters" id='applicationStatus' name="applicationStatus">
              		<option value="" selected >Select</option>
              	</select>              	
              	<div class="invalid-feedback"></div>
 			 </div>
		</div>
		<!-- <div class='col-md-1 mt-5 mb-2' style="display:block"  id='divGenerateReport'>
			<a href="#" class='btn-his-sm' id='generate' onClick="return generateReport();">Generate</a>
		</div> -->
		<div class='col-md-1' style="display:none;margin-top: 39px;"  id='divResetFilter' >
			<a class='btn-his-sm' id='resetFilter'>Reset</a>
		</div>	
		
	</div>

   <div class="row" style="margin-top: -22px;">
   		<div class="col-md-1 ">
   		<!-- <button onclick="return generateReport();">Generate</button> -->
   		<div id='reportgendiv' class="dropdown" style="margin-top: 34px;">
			<button class="btn btn-sm dropdown-his dropdown-toggle show"
				type="button" id="generateMenu" data-bs-toggle="dropdown"
				aria-expanded="true">
				<i class="fa fa-cog fa-spin fa-1x"></i>
			</button>
			<ul class="dropdown-menu hide" aria-labelledby="generateMenu"
				style="position: absolute; inset: 0px auto auto 0px; margin: 0px; transform: translate(-143px, 33px);"
				data-popper-placement="bottom-start">
				<li><a class="dropdown-item dropdown-button btnRptMenu" data-format="XLS"><div class="button-content">
							<div class="button__icon">
								<i class="fa-solid fa-file-excel fa-2x"></i>
							</div>
							<span class="button__text">Excel</span>
						</div></a></li>
				<li><a class="dropdown-item dropdown-button btnRptMenu" data-format="PDF"><div class="button-content">
							<div class="button__icon">
								<i class="fa-solid fa-file-pdf fa-2x"></i>
							</div>
							<span class="button__text">PDF</span>
						</div></a></li>
				<li><a class="dropdown-item dropdown-button btnRptMenu" data-format="HTML"><div class="button-content">
							<div class="button__icon">
								<i class="fa-brands fa-html5 fa-2x"></i>
							</div>
							<span class="button__text">HTML</span>
						</div></a></li>
			</ul>
		</div>
		</div>
		<div class="col-md-11" style='text-align:right' id='divbuttons'></div>
	</div>	
	<div class="row">	
       <div class="col-md-12  no-more-tables">
       	<table class="table table-striped border" id='tbl_cardMgmt_List'><thead></thead><tbody></tbody></table>
       </div>
      
    </div>

		









		<div class="row">
    	<div class="col-md-12" style="text-align: right;">
       	<div class="btn-group" role="group" aria-label="Basic button group">
       	<button class="button" id='more' style="display: none;"><div class="button-content"><div class="button__icon"><i class="fa-solid fa-square-caret-down fa-fw  fa-2x"></i></div><span class="button__text">More</span></div> </button>
       	</div>
         </div>
     </div>  
  <div class="row " ><div class="col-md-12 alert alert-info text-center fw-bold" id='dataMsg' style='display:none;'></div></div>
  <input type='hidden' id='currentPageNo' name="currentPageNo" value='1'>
  <input type='hidden' id='noOfPages' name="noOfPages" value='1'>
  <input type='hidden' id='currentDate' name="currentDate" >
    <input type='hidden' name="fhttf" id='fhttf'/>
    <input type='hidden' name='hmode' />	
  

</section>
</form>
