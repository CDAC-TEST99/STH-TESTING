$(document).ready(function() {
	initGrievanceListPage();
	
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
	
	
	
	  $('#search').on('input', function () {
//		    var search = $('#search').val().trim();  
//		  
//	        $('#searchInfo').show();
//	        getGrievanceListPageData("1",search);
		  var search = $('#search').val().trim();
		    if (search.length === 0) {
		        $('#searchInfo').hide();
		        return;
		    }
		    $('#searchInfo').show();
		    getGrievanceListPageData("1", search);
		  
		  
	    });
	
});


function initGrievanceListPage(){
	
	$('#more').click(function(){
		var currentPageNo=parseInt($('#currentPageNo').val());
		var noOfPages=parseInt($('#noOfPages').val());
		console.log("currentPageNo=="+ currentPageNo + " noOfPages=" +noOfPages);
		if(currentPageNo<=noOfPages){
		  getPageWiseData();
		}
	});
	getGrievanceListPageData("1","");
	  
	
	 var moduleName=$('#selectedModuleId').val();
	  const d = new Date();
	    let toYear = d.getFullYear();
	    let fromYear=toYear-99;
	
	    $('#search').keypress(function(e) {
	 
	    	 var search = $('#search').val().trim(); 
	         
	    	
	       // if(e.which == 13) {
	        
	        	 $('.hideOnSearch').hide();
	        	// $('#divrowkpis').hide();
	        	 $('#divResetFilter').show();
	        	 $('#tbl_Grievance_List').show();
	            $('#tbl_Grievance_List tbody').empty();	
	            
	           
	            
	        	//getGrievanceListPageData("1",search);	        	
	       // }
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
        	 //$('#divrowkpis').show();
        	 $('#search').val("");
        	 $('#filterDate').val($('#currentDate').val());
        	 $('#currentPageNo').val("1");
        	 $('#tbl_Grievance_List tbody').empty();
        	 getGrievanceListPageData("1","");
	    });
	    $('.filters').change(function(){
	    	$('#tbl_Grievance_List tbody').empty();
	    	getGrievanceListPageData("1","");
	    })
	 	 
	

	 var configJson={
 			serviceName:"/getData/getGrievanceApplicationStatus",			    					
 			callBackFunctionName:"commonPopulateCombo",
 			comboId:"applicationStatus",	
 			isDataStoredInSession:"no",
 			triggerChange:"Yes",
 			defaultOption:{"optionValue":"","optionText":"Select"}	
 		};
		
	callFormFlowXService(configJson);
	
	/*var configJson={
 			serviceName:"/getData/getApplicationType",			    					
 			callBackFunctionName:"commonPopulateCombo",
 			comboId:"applicationType",	
 			isDataStoredInSession:"yes",
 			defaultOption:{"optionValue":"ALL","optionText":"All"}	
 		};
		
	callFormFlowXService(configJson);*/
	 
	 
	var selectedModuleWiseMenu_open_with_pk= $('#selectedModuleWiseMenu_open_with_pk').val();
	//alert("selectedModuleWiseMenu_open_with_pk>>" + selectedModuleWiseMenu_open_with_pk);
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

function getGrievanceListPageData(pageNo){

	if($('#applicationStatus').val()=="")
		return;
	var search=$('#search').val().trim();
	 var recordPerPage=50;
	 $('#dataMsg').show().html("Getting Data Please wait !");
	 //alert($('#applicationStatus').val());
	 var data={
			 "moduleId":$('#selectedModuleId').val().toUpperCase(),
			 "search":search,
			 "applicationStatus":$('#applicationStatus').val()
		};
	
	 var configJson={
   			serviceName:"/getData/getGrievancelistpagedata",			    					
   			callBackFunctionName:"callGrievanceListPageData",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
       
   	
}



function getGrievanceListPageData(pageNo,searchText){
//alert(searchText);
	if($('#applicationStatus').val()=="")
		return;
	
	 var recordPerPage=50;
	 $('#dataMsg').show().html("Getting Data Please wait !");
	 //alert($('#applicationStatus').val());
	 var data={
			 "moduleId":$('#selectedModuleId').val().toUpperCase(),
			 "search":searchText,
			 "applicationStatus":$('#applicationStatus').val()
		};
	
	 var configJson={
   			serviceName:"/getData/getGrievancelistpagedata",			    					
   			callBackFunctionName:"callGrievanceListPageData",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
       
   	
}



function callGrievanceListPageData(configJson, dataJson){
	 alert(JSON.stringify(dataJson));
	// alert(JSON.stringify(configJson));
	
	 $('#tbl_Grievance_List thead').empty();
	    $('#tbl_Grievance_List tbody').empty(); 
	 
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
		 
		 var width="";
		
		 
		 $.each(dataJson["data"][0], function(key, val){
			 var allignment="center";
			 var currentVal = parseFloat(val); 
			 if(currentVal!=NaN){
				 allignment="left";
			 }
			 if(key.toLowerCase()!="pkcolumn"){
				 html+="<th scope='col' class='colHeading' style='text-align:"+allignment+";'>"+key+"</th>";
				 noOfColumn++;
			 }
		 });
		
		 
		 html+="<th scope='col' style='text-align:center;width:5%'>Action</th>";
		 html+="</tr>";
		 $('#tbl_Grievance_List thead').append(html)
		 if(noOfColumn>1){
			 width= 95/noOfColumn;
		 }		 
		 $('.colHeading').css({"width":width+"%"});
		 
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

			 var status_to_show_menu= primaryKey.split("@")[0]
			 var buttonHtmlPKBased =generateRecordWiseButton(status_to_show_menu,encrypt(primaryKey));
			 html+="<td style='text-align:center;' >"+buttonHtmlPKBased+"</td>";
			 
			 html+="</tr>";
			 
			 $('#tbl_Grievance_List tbody').append(html)
			 
		 });
		 
		
		 $('#dataMsg').hide()
		
		 
	 }
	 else{
		 $('#reportgendiv').hide()
		 $('#dataMsg').show().html(dataJson["message"]).addClass("alert-danger").removeClass("alert-info");						 
	 }
	 $('.btnLeafMenu').click(openButtonLink);
}


function getGrievancekpidata(){
	
	var filterDate=$('#filterDate').val(); 
	var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"filterDate":filterDate};
	 
	 var configJson={
   			serviceName:"/getData/getGrievancekpidata",			    					
   			callBackFunctionName:"callGetGrievancekpidata",
   			"inputData":data
   		};
		
		callFormFlowXService(configJson);
} 
function callGetGrievancekpidata(configJson, dataJson){
	// alert(JSON.stringify(dataJson));
	if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
		$.each(dataJson["data"][0], function(key,value){
			$('#'+key).html(value);
		});
	}
}


function callbackGetGrievanceApplicationStatus(configJson, dataJson){
	
	if(dataJson["data"]!=undefined &&  dataJson["data"].length>0){
		var json=dataJson["data"][0];		
		//getGrievancekpidata();
		
		
	}					
}
function getPageWiseData(){
	//pageBtn' data-pageno="+i+"
	//alert("getPageWiseData");
	var nextPageNo=parseInt($('#currentPageNo').val())+1;
	$('.pageBtn').removeClass("btn-info").addClass("btn-light");
	$(this).removeClass("btn-light").addClass("btn-info");	
	getGrievanceListPageData( nextPageNo,"");
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
	
	 
	var data={"moduleId":$('#selectedModuleId').val().toUpperCase(),"search":search,"applicationStatus":$('#applicationStatus').val()};
	 
	 var configJson={
   			serviceName:"/getData/getGrievancelistpagedata",
   			"inputData":data,
   			formId:"regList",
   			"format":format
   		};
		
		callgenerateReport(configJson);
}




