$(document).ready(function() {
	initRegistrationListPage();
	
	$('#show').on('click', function () {
	    $('.center').show();
	    /*$(this).hide();*/
	})

	$('#close').on('click', function () {
	    $('.center').hide();
	    /*$('#show').show();*/
	})
	
	$( "button" )
	.click(function( event ) {
	event.preventDefault();
	});
	
	$('form').on('keypress', function(event) {
	    if (event.keyCode === 13) {
	        event.preventDefault();
	        return false;
	    }
	})
	
	$('.btnRptMenu').click(generateReport);
	$('#listModuleTitle').text($('#selectedModuleName').val());
});


function initRegistrationListPage(){
	
	$('#more').click(function(){
		var currentPageNo=parseInt($('#currentPageNo').val());
		var noOfPages=parseInt($('#noOfPages').val());
		console.log("currentPageNo=="+ currentPageNo + " noOfPages=" +noOfPages);
		if(currentPageNo<=noOfPages){
		  getPageWiseData();
		}
	});
	$('#searchBy').change(function(){
		if(this.value=="benId"){
			 $('#search').attr("placeholder", "Enter Ben. ID")
			 $('#search').prop("maxLength", "20");			 
		}
		else if(this.value=="mobile"){
			$('#search').attr("placeholder", "Enter Mobile No.")
			$('#search').prop("maxLength", "10");
		}
		else if(this.value=="benName"){
			$('#search').attr("placeholder", "Enter Ben. Name")
			$('#search').prop("maxLength", "50");
		}
		else if(this.value=="apt"){
			$('#search').attr("placeholder", "Enter Appointment")
			$('#search').prop("maxLength", "50");
		}
		$('#search').val("").focus();
	});
	
	 var moduleName=$('#selectedModuleId').val();
	  const d = new Date();
	    let toYear = d.getFullYear();
	    let fromYear=toYear-99;
	
	    $('#search').keypress(function(e) {
	    	if(e.which == 13) 
				search();
	    });
		$('#btnSearch').click(search);
	    $('#search').keyup(function(e) {
	    	if($(this).val().trim().length>0)
	    		$('#searchInfo').show();
	    	else
	    		$('#searchInfo').hide();	    	
	    });
		
	    $('#resetFilter').click(function(){
	    	$('#divResetFilter').hide();
	    	 $('.hideOnSearch').show();
        	// $('#divrowkpis').show();
        	 $('#search').val("");
        	 $('#searchBy').val("beneficiaryId").trigger("change");
        	 $('#filterDate').val($('#currentDate').val());
        	 $('#currentPageNo').val("1");
        	 $('#tbl_registration_List tbody').empty();
        	 getRegistrationListPageData("1");
	    });
	 	 
	 $('#filterDate').datepicker({ minDate:-36500 , maxDate: "0",    "dateFormat": "dd-M-yy",   
	    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
	    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,	    	
	    	onSelect: function (date, datepicker) {
	    		$('#tbl_registration_List tbody').empty();
	    		getregistrationkpidata();
	    		getRegistrationListPageData("1");
	        }
     		
	    });

	 var configJson={
 			serviceName:"/getData/getCurrentDate",			    					
 			callBackFunctionName:"callbackGetCurrentDate",
 			isDataStoredInSession:"yes"	
 		};
		
		callFormFlowXService(configJson);
	 
	 
	var selectedModuleWiseMenu_open_with_pk= $('#selectedModuleWiseMenu_open_with_pk').val();
	var jsonArr= null;
	try{
		if(selectedModuleWiseMenu_open_with_pk!=''){
			jsonArr=JSON.parse(selectedModuleWiseMenu_open_with_pk);		
		}
	
	}catch(e){
		console.log('selectedModuleWiseMenu_open_with_pk not found')
	}

	 var buttonRowhtml="<div class='btn-group mt-4' role='group' aria-label='Basic button group'>";
	 buttonRowhtml+= generateButtonForWithoutPK();
	 buttonRowhtml+="</div>";
	 
	 $('#divbuttons').html(buttonRowhtml)	
	 	 	
	 
}
function search(){
	var search =$('#search').val().trim()
    	if(search!=""){
    			
    		var msg="";
        	if($('#searchBy').val()=="beneficiaryId"){
        		 msg=validateByRegExprestion(search,"beneficiaryId") ;
        	}
        	if($('#searchBy').val()=="mobile"){
        		msg=validateByRegExprestion(search,"mobile") ;
        	}
        	if($('#searchBy').val()=="benName"){
        		msg=validateByRegExprestion(search,"alphabetOnly") ;
        	}
        	
        	if(msg!=""){
        		alert(msg)
        		return;
        	}
    	}
    	
    	
    	 $('.hideOnSearch').hide();
    	// $('#divrowkpis').hide();
    	 $('#divResetFilter').show();
    	 $('#tbl_registration_List').show();
        $('#tbl_registration_List tbody').empty();	            
    	getRegistrationListPageData("1");	        	
    
}
function getRegistrationListPageData(pageNo){

	var search=$('#search').val().trim();
	var filterDate=$('#filterDate').val();
	var searchBy=$('#searchBy').val().trim();
	 var recordPerPage=50;
	
	 $('#dataMsg').show().html("Getting Data Please wait !");
	 var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"search":search,"searchBy":searchBy,  "pageNo":pageNo, "recordPerPage":recordPerPage,"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getregistrationlistpagedata",			    					
   			callBackFunctionName:"callGetRegistrationListPageData",
   			"inputData":data
   		};
	 $('#preloader').show();
	 callFormFlowXService(configJson);
       
   	
}

function callGetRegistrationListPageData(configJson, dataJson){
	 //alert(JSON.stringify(dataJson));
	 
	hidePreloader();
	 $('#tbl_registration_List thead').empty();
	 if(dataJson["data"].length>0){
		 $('#reportgendiv').show();
		 var totalRecord =parseInt(dataJson["errMsgCode"]);
		 var recordPerPage =parseInt(dataJson["recordPerPage"]);
		 var noOfPages=1;
		 var currentPageNo=parseInt(dataJson["pageNo"]);
		 
		 if(totalRecord>recordPerPage){
			 noOfPages=Math.ceil(totalRecord / recordPerPage);
		  }
		 
		  var currentRecordCount=currentPageNo*recordPerPage;
		  if(currentRecordCount>totalRecord)
			  currentRecordCount=totalRecord;	
		  
		  $('#recordInfo').html("Showing "+(currentRecordCount) +" of "+ totalRecord +" records" );
		  $('#currentPageNo').val(currentPageNo);
		  $('#noOfPages').val(noOfPages);
		  
		  if(noOfPages>1){
			  $('#more').show();
		  }
		  
		//alert("totalRecord===" + totalRecord + " recordPerPage=="+ recordPerPage +" noOfPages===" +noOfPages );
		 
		 var noOfColumn=0;
		 var html="<tr class='tableHeading'>"
		 $.each(dataJson["data"][0], function(key, val){
			 var allignment="center";
			 var currentVal = parseFloat(val); 
			 if(currentVal!=NaN){
				 allignment="left";
			 }
			 if(key.toLowerCase()!="pkcolumn"){
				 html+="<th scope='col' style='text-align:"+allignment+";'>"+key+"</th>";
				 noOfColumn++;
			 }
		 });
		 html+="<th scope='col' style='text-align:center;'>Action</th>";
		 html+="</tr>";
		 $('#tbl_registration_List thead').append(html)
		 
		 
		 $.each(dataJson["data"], function(indx, rowJson){
			 html="<tr id='trdata_"+indx+"'>"
			 var primaryKey="";	 
			 $.each(rowJson, function(key, val){
				 var allignment="center";
				 var currentVal = parseFloat(val); 
				 if(currentVal!=NaN){
					 allignment="left";
				 }
				 
				 if(key.toLowerCase()!="pkcolumn"){
					 html+="<td data-title='"+key+"' style='text-align:"+allignment+";' >"+val+"</td>";
				 }
				 else
					 primaryKey=val;
					 
			 });
			 var status_to_show_menu= primaryKey.split("@")[0]
			 var buttonHtmlPKBased =generateRecordWiseButton(status_to_show_menu,encrypt(primaryKey));
			 html+="<td style='text-align:center;' >"+buttonHtmlPKBased+"</td>";
			 
			 html+="</tr>";
			 
			 /*html+="<tr class='bg-light' style='display:none;' id='traction_"+indx+"'><td colspan='"+(noOfColumn+1)+"' style='text-align:right'>"+mybutton+"</td></tr>";*/
			 
			 $('#tbl_registration_List tbody').append(html)
			 
		 });
		 
		
		 $('#dataMsg').hide()
		
		 
	 }
	 else{
		 $('#reportgendiv').hide()
		 $('#dataMsg').show().html(dataJson["message"]).addClass("alert-danger").removeClass("alert-info");						 
	 }
	 $('.btnLeafMenu').click(openButtonLink);
}


function getregistrationkpidata(){
	
	var filterDate=$('#filterDate').val(); 
	var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getregistrationkpidata",			    					
   			callBackFunctionName:"callGetregistrationkpidata",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
} 
function callGetregistrationkpidata(configJson, dataJson){
	// alert(JSON.stringify(dataJson));
	if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
		$.each(dataJson["data"][0], function(key,value){
			$('#'+key).html(value);
		});
	}
}


function callbackGetCurrentDate(configJson, dataJson){
	if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
		var json=dataJson["data"][0]
		$('#filterDate').val(json["currentDate"]);
		$('#currentDate').val(json["currentDate"]);
		getregistrationkpidata();
		getRegistrationListPageData("1");
		
	}					
}
function getPageWiseData(){
	//pageBtn' data-pageno="+i+"
	//alert("getPageWiseData");
	var nextPageNo=parseInt($('#currentPageNo').val())+1;
	$('.pageBtn').removeClass("btn-info").addClass("btn-light");
	$(this).removeClass("btn-light").addClass("btn-info");	
	getRegistrationListPageData( nextPageNo);
}

function isAtBottom() {
	 //
	 const { scrollTop, scrollHeight, clientHeight } = document.documentElement;
	 const buffer = 5;
	 console.log("left==" + Math.ceil(scrollTop + clientHeight) + " right==" + (scrollHeight - buffer) );
	 return Math.ceil(scrollTop + clientHeight+25) >= scrollHeight - buffer;
}

function generateReport(){
	var format=$(this).attr("data-format");
	
	/* document.forms[0].hmode.value = "getReport";
	 document.forms[0].target = "_blank";
	 document.forms[0].action = "/AHIMSG5/FFXACTION";
	 document.forms[0].submit();*/
	var search=$('#search').val().trim();
	var filterDate=$('#filterDate').val(); 
	 
var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"search":search,"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getregistrationlistpagedata",
   			"inputData":data,
   			formId:"regList",
   			"format":format
   		};
		
		callgenerateReport(configJson);
}


/*
window.addEventListener('scroll', () => {
  
  const { scrollTop, scrollHeight, clientHeight } = document.documentElement;
  
  if (isAtBottom()) {
	  var currentPageNo=parseInt($('#currentPageNo').val());
	  var noOfPages=parseInt($('#noOfPages').val());
	  console.log("currentPageNo=="+ currentPageNo + " noOfPages=" +noOfPages);
	  if(currentPageNo<=noOfPages){
		  getPageWiseData()
	  }
  }
});
*/