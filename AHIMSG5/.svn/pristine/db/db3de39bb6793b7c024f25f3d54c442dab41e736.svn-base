$(document).ready(function() {
	initBillingListPage();
	
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
});


function initBillingListPage(){
	
	$('#more').click(function(){
		var currentPageNo=parseInt($('#currentPageNo').val());
		var noOfPages=parseInt($('#noOfPages').val());
		console.log("currentPageNo=="+ currentPageNo + " noOfPages=" +noOfPages);
		if(currentPageNo<=noOfPages){
		  getPageWiseData();
		}
	});
	  
	 var moduleName=$('#selectedModuleId').val();
	  const d = new Date();
	    let toYear = d.getFullYear();
	    let fromYear=toYear-99;
	
	    $('#search').keypress(function(e) {
	    	
	        if(e.which == 13) {
	        	 $('.hideOnSearch').hide();
	        	 $('#divrowkpis').hide();
	        	 $('#divResetFilter').show();
	        	 $('#tbl_Billing_List').show();
	            $('#tbl_Billing_List tbody').empty();	            
	        	getBillingListPageData("1");	        	
	        }
	    });
	    $('#search').keyup(function(e) {
	    	if($(this).val().trim().length>0)
	    		$('#searchInfo').show();
	    	else
	    		$('#searchInfo').hide();	    	
	    });
	    $('#resetFilter').click(function(){
	    	$('#divResetFilter').hide();
	    	 $('.hideOnSearch').show();
        	 $('#divrowkpis').show();
        	 $('#search').val("");
        	 $('#filterDate').val($('#currentDate').val());
        	 $('#currentPageNo').val("1");
        	 $('#tbl_Billing_List tbody').empty();
        	 getBillingListPageData("1");
	    });
	 	 
	 $('#filterDate').datepicker({ minDate:-36500 , maxDate: "0",    "dateFormat": "dd-M-yy",   
	    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
	    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,	    	
	    	onSelect: function (date, datepicker) {
	    		$('#tbl_Billing_List tbody').empty();
	    		getBillingkpidata();
	    		getBillingListPageData("1");
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
	
	
	
	
	
	 var moduleWiseLeafMenu= JSON.parse($('#moduleWiseLeafMenu').html());
	
	 var jsonArrbuttonHtmlPKBased= new Array();
	 
	 var buttonRowhtml="<div class='btn-group mt-4' role='group' aria-label='Basic button group'>";
	
	 var modarr=null;
	 if(Array. isArray(moduleWiseLeafMenu[moduleName])==false){
		 modarr=new Array();
		 modarr.push(moduleWiseLeafMenu[moduleName])		
	 }
	 else{
		 modarr=moduleWiseLeafMenu[moduleName];
	 }
		 
	 $.each(modarr,function(indx, objModuleWiseLeafMenu){
	 	 if(objModuleWiseLeafMenu["processType"].toUpperCase()=="SERVICES" && objModuleWiseLeafMenu["parentMenuId"].toUpperCase()=="0" ){
			 var flagMenuWithoutPK=true;
			 var status_to_show=-1;
			 if(jsonArr!=null && jsonArr.length>0){
				 //alert(arrMenuIds + "==" + objModuleWiseLeafMenu["menuid"]);
				 for(var i =0;i<jsonArr.length;i++){
					 var jsonMenu= jsonArr[i];
					 //alert('jsonMenu>>>' + JSON.stringify(jsonMenu));
					 if(jsonMenu["menuid"] ==objModuleWiseLeafMenu["menuid"].trim()){
						 flagMenuWithoutPK=false;
						 
						 status_to_show=jsonMenu["status_to_show"]
						 break;
					 }
				 }
			 }

			 
			 
			 if(flagMenuWithoutPK){
				 buttonRowhtml+="<button class='button btnLeafMenu'  data-pk='' data-menuid='"+objModuleWiseLeafMenu["menuid"]+"'  title='"+objModuleWiseLeafMenu["menuName"]+"' data-url='"+objModuleWiseLeafMenu["url"]+"'>"+
				 	 "<div class='button-content'>"+
					 "<div class='button__icon'><i class='"+objModuleWiseLeafMenu["font_icon_name"]+"  fa-2x'></i></div><span class='button__text'>"+objModuleWiseLeafMenu["menuName"]+"</span>"+
					 "</div> </button>&nbsp;";
				 
			 }else{
				 var json={"menuId":objModuleWiseLeafMenu["menuid"],
						 "status_to_show":status_to_show,
						 "menuName": objModuleWiseLeafMenu["menuName"],
						 "url":objModuleWiseLeafMenu["url"],
						 "font_icon_name":objModuleWiseLeafMenu["font_icon_name"]
				 }
				 jsonArrbuttonHtmlPKBased.push(json);
												 		
			 }
		 }
	 });
	 buttonRowhtml+="</div>";
	 
	 $('#divbuttons').html(buttonRowhtml)	
	 $('#buttonHtmlPKBased').html(JSON.stringify(jsonArrbuttonHtmlPKBased));
	 	 	
	 
}

function getBillingListPageData(pageNo){

	var search=$('#search').val().trim();
	var filterDate=$('#filterDate').val(); 
	 var recordPerPage=50;
	 $('#dataMsg').show().html("Getting Data Please wait !");
	 var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"search":search,  "pageNo":pageNo, "recordPerPage":recordPerPage,"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getBillinglistpagedata",			    					
   			callBackFunctionName:"callGetBillingListPageData",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
       
   	
}

function callGetBillingListPageData(configJson, dataJson){
	 //alert(JSON.stringify(dataJson));
	 
	
	 $('#tbl_Billing_List thead').empty();
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
		 $('#tbl_Billing_List thead').append(html)
		 
		 
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
			 var buttonHtmlPKBased =generateRecordWiseButton(status_to_show_menu);
			 
			 var mybutton=buttonHtmlPKBased.replaceAll(/#pk#/g,encrypt(primaryKey));
			
			
			 html+="<td style='text-align:center;' >" +
			 		"<div class='dropdown'>" +
			 		"<button class='btn btn-sm dropdown-his dropdown-toggle' type='button' id='dropdownMenuButton' data-bs-toggle='dropdown' aria-expanded='false'>" +
			 		" <i class='fa-solid fa-ellipsis-vertical'></i> </button>" +
			 		" <ul class='dropdown-menu' aria-labelledby='dropdownMenuButton'>"+ mybutton+"</ul>" +
			 		"</div>" ;
			 html+="</tr>";
			 
			 /*html+="<tr class='bg-light' style='display:none;' id='traction_"+indx+"'><td colspan='"+(noOfColumn+1)+"' style='text-align:right'>"+mybutton+"</td></tr>";*/
			 
			 $('#tbl_Billing_List tbody').append(html)
			 
		 });
		 
		
		 $('#dataMsg').hide()
		
		 
	 }
	 else{
		 $('#reportgendiv').hide();
		 $('#dataMsg').show().html(dataJson["message"]).addClass("alert-danger").removeClass("alert-info");						 
	 }
	 $('.btnLeafMenu').click(openButtonLink);
}


function getBillingkpidata(){
	
	var filterDate=$('#filterDate').val(); 
	var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getBillingkpidata",			    					
   			callBackFunctionName:"callGetBillingkpidata",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
} 
function callGetBillingkpidata(configJson, dataJson){
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
		getBillingkpidata();
		getBillingListPageData("1");
		
	}					
}
function getPageWiseData(){
	//pageBtn' data-pageno="+i+"
	//alert("getPageWiseData");
	var nextPageNo=parseInt($('#currentPageNo').val())+1;
	$('.pageBtn').removeClass("btn-info").addClass("btn-light");
	$(this).removeClass("btn-light").addClass("btn-info");	
	getBillingListPageData( nextPageNo);
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
   			serviceName:"/getData/getInvestigationlistpagedata",
   			"inputData":data,
   			formId:"billList",
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