
 //json format
  listPageConfigJson={
   "containerId":"LISTPAGE",
	"listPageHeading": "Government Department Master",
	"listServiceName": "cardmgmt.pkg_test.getListPage",
	 "noOfRecordPerPage": "10",
	
		"buttons": [
	{
			    "buttonName": "Add",
				"buttonDisplayName": "Add",
				"buttonClass": "btn  bg-gradient-formButton  btn-sm",
				"buttonIcon": "fas fa-plus-circle",
				"onClickFunction": "initAddPage()"
			},
{
			"buttonName": "Modify",
			"buttonDisplayName": "Modify",
			"buttonClass": "btn btn-default btn-info text-white  btn-sm",
			"buttonIcon": "far fa-edit",
			"onClickFunction": "getModifyDtl",
			"onClickServiceName": "",
			"masterkey":"",
			"initMode":"",
		},
		{
			"buttonName": "btnDelete",
			"buttonDisplayName": "Delete",
			"buttonClass": "btn btn-danger  btn-sm",
			"buttonIcon": "fas fa-trash",
			"onClickFunction": "getDeleteDtl",
			"onClickServiceName": ""
		},
		{
			"buttonName": "btnView",
			"buttonDisplayName": "View",
			"buttonClass": "btn btn-default btn-info text-white  btn-sm",
			"buttonIcon": "fas fa-eye",
			"onClickFunction": "getViewDtl",
			//"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupMstView"
		}
	]
}


/*var ajaxCalledOnChangeOfFilter= new Array();
function createListPage(configJson){
	try{
	//alert(JSON.stringify(configJson));
		ajaxCalledOnChangeOfFilter=null;
		ajaxCalledOnChangeOfFilter= new Array();
	var html="";
	var containerId=configJson["LISTPAGE"];
	
	var filterIds=new Array();
	
	var isShowListPageInpopup=configJson["isShowListPageInpopup"]==undefined?"No":configJson["isShowListPageInpopup"];
	//getting existing filterIds defiend by user
	if(configJson["filterIds"]!=undefined){
		filterIds=configJson["filterIds"];
	}
	checking if filters exists then adding filterid from  filterobj to filterIds array
	if(configJson["filters"]!=undefined ){
		$.each(configJson["filters"],function(k,filterobj){
			filterIds.push(filterobj["filterId"]);
		});		
	}
	if(filterIds.length>0){
		configJson["filterIds"]=filterIds;
	}
	
	html+="<fieldset class='border p-3 fieldsetcss'>";
	html+="<legend class='w-auto px-2 legendcss' data-langtag='"+configJson["listPageHeading"]+"' >"+configJson["listPageHeading"]+" >> List Page</legend>";
	
	
	html+="<input type='hidden' name='listPageHeading' id='listPageHeading' value='"+configJson["listPageHeading"]+"'>";
	if(configJson["buttons"]!=undefined){
		var buttoncontainerClass="buttonContainer";
		//alert(isShowListPageInpopup);
		if(isShowListPageInpopup=="Yes")
			buttoncontainerClass="buttonContainerPopup";
		
		html+="<div class='"+buttoncontainerClass+"'>";
		
		$.each(configJson["buttons"],function(indx,objBtnJson){
			
			var btnclass=objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			var buttonDisplayName=objBtnJson["buttonDisplayName"]!=undefined? "<span data-langtag='"+objBtnJson["buttonDisplayName"]+"'>"+objBtnJson["buttonDisplayName"]+ "</span>":"";
			var buttonIcon= objBtnJson["buttonIcon"]!=undefined?"<i class='"+objBtnJson["buttonIcon"]+"'></i>":"";
			var onClickFunction= objBtnJson["onClickFunction"]!=undefined?"onclick='"+objBtnJson["onClickFunction"]+"'":"";
			html+="<button "+btnclass+" id='"+objBtnJson["buttonName"]+"' "+onClickFunction+"   >"+buttonIcon+"&nbsp;"+buttonDisplayName+"</button>&nbsp;";
		
		});
		html+="</div>";
	}
	
	html+="<div class='alert alert-success' role='alert' id='divMsg' style='display: none;'></div>";
	if(configJson["filters"]!=undefined){
		var isFiltersHidden=configJson["isFiltersHidden"]==undefined?"No":configJson["isFiltersHidden"];
		
		var hideFilterMinus;
		var hideFilterPlus;
		var filterRowHide;
		if(isFiltersHidden=="No"){
			hideFilterMinus="";
			filterRowHide="";
			hideFilterPlus="hideData";
			
		}
		else{
			hideFilterMinus="hideData";
			filterRowHide="hideData";
			hideFilterPlus="";
			
		}
		html+="<div class='row' style='border-bottom:1px solid rgba(0, 0, 0, 0.125);display:none;'>";
			html+="<div class='col-sm-12' >";
				html+="<a data-val='hide' class='btn btn-xs  btn-info text-white "+hideFilterMinus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterMinus'  onclick=showHideFilters(\'"+containerId+"\',0)><i class='fas fa-minus-circle'></i>&nbsp;Hide Filters</a>";
				html+="<a data-val='show' class='btn btn-xs  btn-info text-white "+hideFilterPlus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterPlus'   onclick=showHideFilters(\'"+containerId+"\',1)><i class='fas fa-plus-circle'>&nbsp;Show Filters</i></a>";
				html+="<a class='btn btn-xs  btn-info text-white hideData' style='margin-top:0px!important; float:right;margin-right: 2px;' id='"+containerId+"_btnFilterMore'   onclick=showMoreFilters(\'"+containerId+"\')><i class='fas fa-filter'>&nbsp;More Filters</i></a>&nbsp;";
			html+="</div>";
		html+="</div>";
		
		html+="<div class='row filterHideShow "+filterRowHide+"' id='"+containerId+"_divTableFilter' >";
		var filterhtml="";
		var moreFilters=""; 
		$.each(configJson["filters"],function(kfilter,objFilter){
			////alert(JSON.stringify(objFilter));
			var filter="";
			var validation =objFilter["validation"]!=undefined? "data-validation='"+ objFilter["validation"]+"'":"";
			if(objFilter["filterType"]=='combo'){
				var parentId=objFilter["parentFilterId"]==undefined?"0":objFilter["parentFilterId"];
				filter+="<div class='col-lg-3'>";
				filter+="<div class='form-group'>";
				filter+="<label class='col-form-label col-form-label-sm'  for='"+objFilter["filterId"]+"'   data-langtag='"+objFilter["filterLabel"]+"'>"+objFilter["filterLabel"]+"</label>";
				filter+="<select class='form-control form-control-sm filter select' "+validation+" id='"+objFilter["filterId"]+"' data-filterType='"+objFilter["filterType"]+"'  data-parentId='"+parentId+"'>";
				var objdefaultOption= objFilter["defaultOption"];
					filter+="<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>";
				filter+="</select><div class='invalid-feedback'></div>";
				//filter+"<input class="form-control form-control-sm" type="text" placeholder=".form-control-sm" id="inputSmall">
				filter+="</div>";
				filter+="</div>";
				
			}
		   if(objFilter["filterType"]=='text'){
			   
			   var maxlength=objFilter["maxlength"]==undefined?"":"maxlength='"+objFilter["maxlength"]+"'";
			   var minlengthToFireQuery=objFilter["minlengthToFireQuery"]==undefined?"":"data-minlength='"+objFilter["minlengthToFireQuery"]+"'";
			   
				filter+="<div class='col-lg-3'>";
				filter+="<div class='form-group'>";
				filter+="<label class='col-form-label col-form-label-sm' for='"+objFilter["filterId"]+"'   data-langtag='"+objFilter["filterLabel"]+"'>"+objFilter["filterLabel"]+"</label>";
				filter+="<input type='text' class='form-control form-control-sm textbox' "+validation+" "+maxlength+" "+minlengthToFireQuery+" data-filterType='"+objFilter["filterType"]+"'  data-defaultValueIfEmpty='ALL'  id='"+objFilter["filterId"]+"'>";
				filter+="<div class='invalid-feedback'></div>";
				filter+="</div>";
				filter+="</div>";
			}
			
			if(objFilter["filterType"]=='date'){
				
				filter+="<div class='col-lg-3'>";
				filter+="<div class='form-group'>";
				filter+="<label class='col-form-label col-form-label-sm' for='"+objFilter["filterId"]+"'   data-langtag='"+objFilter["filterLabel"]+"'>"+objFilter["filterLabel"]+"</label>";
				filter+="<input class='form-control form-control-sm singleDatePicker' "+validation+" data-filterType='"+objFilter["filterType"]+"' data-defaultValueIfEmpty='ALL' type='text' id='"+objFilter["filterId"]+"'>";
				filter+="<div class='invalid-feedback'></div>";
				filter+="</div>";
				filter+="</div>";
			}
			
			if(objFilter["filterType"]=='checkbox'){
				var value=objFilter["value"];
				var isDefaultChecked=objFilter["isDefaultChecked"]!=undefined?objFilter["isDefaultChecked"]:"No";
				var onlabel=objFilter["onlabel"]!=undefined?objFilter["onlabel"]:"On";
				var offlabel=objFilter["offlabel"]!=undefined?objFilter["offlabel"]:"Off";
				var checked=isDefaultChecked=="Yes"?"checked":"";
				var width=objFilter["width"]!=undefined?objFilter["width"]:"30%";
				
				
				filter+="<div class='col-lg-3'>";
				filter+="<div class='form-group'>";
				filter+="<label class='col-form-label col-form-label-sm col-sm-12' for='"+objFilter["filterId"]+"'   data-langtag='"+objFilter["filterLabel"]+"'>"+objFilter["filterLabel"]+"</label>";

				filter+="<input type='checkbox' value='"+value+"' "+checked+" data-switchMinWidth='"+width+"' data-filterType='"+objFilter["filterType"]+"'  data-defaultValueIfEmpty='ALL' id='"+objFilter["filterId"]+"' class='switchchklist' data-toggle='switchbutton'  data-onlabel='"+onlabel+"' data-offlabel='"+offlabel+"' data-onstyle='success' data-offstyle='danger'>";
				//filter+="<input type='checkbox' data-filterType='"+objFilter["filterType"]+"' "+validation+" data-defaultValueIfEmpty='ALL' id='"+objFilter["filterId"]+"'>";
				filter+="<div class='invalid-feedback'></div>";
				filter+="</div>";
				filter+="</div>";
			}
			
			if(objFilter["underMoreFilter"]!=undefined && objFilter["underMoreFilter"]=="yes")
				moreFilters+=filter;
			else
				filterhtml+=filter;			
		
		});
		html+=filterhtml;
		
		if(moreFilters!=""){
			html+="<div class='modal' id='"+containerId+"_divTableMoreFilter' tabindex='-1' role='dialog'  aria-hidden='true' style='display:none;'>";
			html+="<div class='modal-dialog  modal-lg' role='document'>";
			html+="<div class='modal-content'>";
			html+="<div class='modal-body' id=''>";
			html+="<div class='card'>";
			html+="<div class='card-header formCardHeader'><h5 class='card-title float-left' data-langtag='"+configJson["listPageHeading"]+"'>"+configJson["listPageHeading"]+" >> More Filters</h5>";
			html+="<a class='btn  btn-info text-white  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;' onclick='closeFilterModal()'><i class='fas fa-times-circle'></i>&nbsp;<span data-langtag='Close'>Close</span></a>&nbsp;";
			html+="</div>";
			html+="<div class='card-body' id='divViewBodyForPrint'>";
			
			html+="<div class='row'>"+moreFilters+"</div></div>";
			html+="</div>";
			html+="</div>";
			html+="</div>";	
			html+="</div>";
			html+="</div>";
			html+="</div>";
		}
		html+="</div>"
		
	}
	html+="<div class='row'><div class='col-lg-12 hideData' id='divSelectedFiltersJson'></div></div>";	
	html+="<div class='row no-more-tables' id='"+containerId+"_divTableListing'></div>";
	if(isShowListPageInpopup=="Yes")
	html+="<span id='spanConfigJsonPopup' style='display:none;'>" +JSON.stringify(configJson)+"</span>"; 
	html+="<span id='spanConfigJson' style='display:none;'>" +JSON.stringify(configJson)+"</span>"; 
	html+="<div class='modal' id='divView' tabindex='-1' role='dialog' aria-labelledby='divViewLabel' aria-hidden='true'>";
	html+="<div class='modal-dialog  modal-lg' role='document'>";
	html+="<div class='modal-content'>";
	html+="<div class='modal-body' id='divViewBody'>";
	html+="</div>";	
	html+="</div>";
	html+="</div>";
	html+="</div>";
	
	
	html+="</fieldset>";
	$('#'+containerId).html(html);
	
	if($("#"+containerId+"_divTableMoreFilter").length>0){
		$("#"+containerId+"_btnFilterMore").removeClass("hideData");
	}
	
	$(".textbox").keypress(function(e) {
	    if(e.which == 13) {	    	 
	    	getListPage();
	    }
	});
	
	  $('.switchchklist').each(function(){
			var id=this.id;
			//alert(id);
			var switchMinWidth=$(this).attr("data-switchMinWidth");
			document.getElementById(id).switchButton();
	
			$('#'+id).closest('.btn').css({"min-width":switchMinWidth+ " !important"});
			var previousStyle = $('#'+id).closest('.btn').attr('style');
			
			if(previousStyle ==undefined)
				previousStyle="";
			//alert(switchMinWidth);
			
			//alert(id + "==="+previousStyle);
			//alert($('#'+id).closest('.btn').length)
	        $('#'+id).closest('.btn').attr('style',  previousStyle + 'width:' + switchMinWidth + '!important;'+'height:calc(1.8125rem + 2px) !important;' );
	       
			 $('#'+id).change(function() {
				 console.log( $(this).prop('value'));
				 getListPage();
			  });
		});
	
		$('#'+containerId +" .singleDatePicker").daterangepicker({
		    singleDatePicker: true,
		    showDropdowns: true,
		    locale: {
		          format: 'DD-MMM-YYYY'
		      }	   
		});
		$('#'+containerId +" .singleDatePicker").val('');	
		$('#'+containerId +" .singleDatePicker").on('apply.daterangepicker', function(ev, picker) {
			getListPage();
		});
		
		$( "button" ).click(function( event ) {
			event.preventDefault();
		});
		$('#'+containerId).find('.selectbtn').hide();
		initValidation(containerId);
		processAllFilterCombo(configJson["filters"]);
		//getListPage();
		if(configJson["filters"].length==0)// call list page if no filters available
			getListPage();
		
		//convertAllLanguageTagsInDiv(containerId)
	}catch(err){
		 console.log("Problem in createListPage===" +  err.message)		
	}
}



*/

$(document).ready(function () {
	
	//LISTPAGE ENTRYFORM
	initInputJson=null;
	 
	$( "button" )
		.click(function( event ) {
		event.preventDefault();
	});
	
	$( "input[type=button], button" )
		.click(function( event ) {
		event.preventDefault();
	});
	//$('#ENTRYFORM').removeClass('hideData');
	
	$('#LISTPAGE').removeClass('hideData');
	createListPage(listPageConfigJson);
	//initAddPage()
	$('#BTNCLEAR').click(resetPage);
	$('#BTNSAVE').click(saveData);
		$('#BTNBACK').click(backToListPage);

	
$('#BTNBACK').click(function(){
		showPreloader();
     
        submitFormMaster("govtDeptMst","ADD");
});
	$('#Modify').click(function(){
		
		$('#BTNCLEAR').prop("hidden",true);
		
	});
	
	
	
	initValidation('ENTRYFORM');
	initPage();
});


function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	var json ={
			"stepTitle":"Test Title here",
			"steps":[
				{"step":"step-One", "stepIcon":"1"},
				{"step":"step-Two","stepIcon":"2"},
				{"step":"step-Three","stepIcon":"3"},
				{"step":"Finish","stepIcon":"fa-solid fa-circle-check fa-fw"},
			],
			"activeStepNo":"3"				
	};
	createWizard(json);

	
	const d = new Date();
	let toYear = d.getFullYear();
	let fromYear=toYear-99;
	let maximumDate=0
	let minimumDate=-36500
	$('.datepickerdob').datepicker({ minDate:minimumDate , maxDate: maximumDate,    "dateFormat": "dd-M-yy",   
    	changeMonth: true, changeYear: true , showButtonPanel: true,  showOtherMonths: true,   
    	selectOtherMonths: true, yearRange: fromYear+":"+toYear,
    	onSelect: function (date, datepicker) {
    		
        }
    });
	    
  
    
    $('#BTNSAVE').click(saveData);
    
    $('#BTNCLEAR').click(resetPage);
  
	
}


function saveData(){
	
	
	if(ValidateForAllVisible("ENTRYFORM")==false)
		return;
	
	
	showPreloader("Saving Data Please Wait !");
	//alert(JSON.stringify(data));
	var configJson={
			serviceName:"/DMLSAVE/saveGovtDeptMstData",
			callBackFunctionName:"callbackSaveData",			
			inputData:processSerializeArray("ENTRYFORM")
		}
	callService(configJson);
}
	
function callbackSaveData(configJson, dataJson){
	
//	alert("callbackSaveData>>>"+JSON.stringify(dataJson));
	if(dataJson["message"].indexOf("ERROR")>=0){
		showMsg(dataJson["message"],null)
	}
	else{
		var dialogConfigJson={callOnOK:"resetPage","parameterJson":{}}
	   showMsg(dataJson["message"],dialogConfigJson)
		
		
	}
}

function clearvaluesperinfo()
{
//alert("values");
	document.getElementById('govtDeptName').value = '';

		
}


function resetPage(){	
	$('.select2').trigger('change');
	commonResetFields(initInputJson);
}