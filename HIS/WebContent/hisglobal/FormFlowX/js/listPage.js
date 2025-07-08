/*
 * json format
 *  listPageConfigJson={
   "containerId":"divId",
	"listPageHeading": "Dashboard Master-List Page",
	"listServiceName": "/DashboardGroupingMstService/getListPage",
	 filterIds:["dashboardFor"] // used for sending value of filters to generate list page
	"noOfRecordPerPage": "10",
	"isFiltersHidden":"No",
	"isShowListPageInpopup":"No",
	"noSearchSortColumnNo":[4,5],
	paginationRequired:true,
	isFirstRowHeading:true,
	"listPageInitializationVariableIds":["isWizzardView"],
	"filters":[
	           {"filterId":"filterInstituteTypeId",
		  		 "filterLabel":"Institute Type",
		  		 "filterType":"combo",
		  		 "validation":"mandatory"
		  		 "defaultOption":{"optionValue":"ALL","optionText":"ALL"},
		  		 "serviceName":"/EMMSMasterDataWebService/getDataService/GetInstituteType"
				},
				{"filterId":"filterRecordStatus",
			  		 "filterLabel":"Record Status",
			  		 "filterType":"combo",
			  		 "defaultOption":{"optionValue":"1","optionText":"Active"},
			  		 "serviceName":"/EMMSMasterDataWebService/getDataService/GetRecordStatus"
				},
				{"filterId":"filterUniqueId",
		  		 "filterLabel":"Unique Id",
		  		 "filterType":"text",
		  		"validation":"positiveNumeric",
		  		"maxlength":"16",		  		
		  		"minlengthToFireQuery":"5"		  		
				},
				{"filterId":"filterPoDate",
		  		 "filterLabel":"PO Date",
		  		 "filterType":"date"		  		
				},
				{"filterId":"filterUnderWarranty",
	  		 "filterLabel":"Under Warranty",
	  		 "filterType":"checkbox",
	  		 "value":"1",
	  		"isDefaultChecked":"No",
	  		"onlabel":"Only Warrenty",
	  		"offlabel":"All"
	  			 
			},
			{"filterId":"filterUnderCAMC",
		  		 "filterLabel":"Under CAMC",
		  		 "filterType":"checkbox",
		  		"value":"1",
		  		"isDefaultChecked":"Yes",
		  		"onlabel":"Yes",
		  		"onlabel":"Only CAMC",
		  		"offlabel":"All"
			},
			 ], 
	"buttons": [{
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
		}
		{
			"buttonName": "btnView",
			"buttonDisplayName": "View",
			"buttonClass": "btn btn-default btn-info text-white  btn-sm",
			"buttonIcon": "fas fa-eye",
			"onClickFunction": "getViewDtl",
			"onClickServiceName": "/EMMSMasterDataWebService/getDataService/getGroupMstView"
		}
	]
}*/
var ajaxCalledOnChangeOfFilter= new Array();
function createListPage(configJson){
	try{
	//alert(JSON.stringify(configJson));
		ajaxCalledOnChangeOfFilter=null;
		ajaxCalledOnChangeOfFilter= new Array();
	var html="";
	var containerId=configJson["containerId"];
	
	var filterIds=new Array();
	
	var isShowListPageInpopup=configJson["isShowListPageInpopup"]==undefined?"No":configJson["isShowListPageInpopup"];
	//getting existing filterIds defiend by user
	if(configJson["filterIds"]!=undefined){
		filterIds=configJson["filterIds"];
	}
	/*checking if filters exists then adding filterid from  filterobj to filterIds array*/
	if(configJson["filters"]!=undefined ){
		$.each(configJson["filters"],function(k,filterobj){
			filterIds.push(filterobj["filterId"]);
		});		
	}
	if(filterIds.length>0){
		configJson["filterIds"]=filterIds;
	}
	
	html+="<div class='card'>";
	html+="<div class='card-header formCardHeader'><div style='float:left;width:50%'><h5 class='card-title float-left'  data-langtag='"+configJson["listPageHeading"]+"' >"+configJson["listPageHeading"]+" >> List Page</h5><input type='hidden' name='listPageHeading' id='listPageHeading' value='"+configJson["listPageHeading"]+"'></div>";
	if(configJson["buttons"]!=undefined){
		var buttoncontainerClass="buttonContainer";
		//alert(isShowListPageInpopup);
		if(isShowListPageInpopup=="Yes")
			buttoncontainerClass="buttonContainerPopup";
		
		html+="<div style='float:right;width:50%;text-align:right' class='"+buttoncontainerClass+"'>";
		
		/*html+="<div class='col-md-6' style='text-align:right' id='divbuttons'></div>";*/
		
		
		$.each(configJson["buttons"],function(indx,objBtnJson){
			
			/*var btnclass=objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			var buttonDisplayName=objBtnJson["buttonDisplayName"]!=undefined? "<span class='button__text'>"+objBtnJson["buttonDisplayName"]+ "</span>":"";
			var buttonIcon= objBtnJson["buttonIcon"]!=undefined?"<i class='"+objBtnJson["buttonIcon"]+" fa-2x'></i>":"";
			var onClickFunction= objBtnJson["onClickFunction"]!=undefined?"onclick='"+objBtnJson["onClickFunction"]+"'":"";*/
			
			var btnclass=objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			var buttonDisplayName=objBtnJson["buttonDisplayName"]!=undefined? "<span data-langtag='"+objBtnJson["buttonDisplayName"]+"'>"+objBtnJson["buttonDisplayName"]+ "</span>":"";
			var buttonIcon= objBtnJson["buttonIcon"]!=undefined?"<i class='"+objBtnJson["buttonIcon"]+"'></i>":"";
			var onClickFunction= objBtnJson["onClickFunction"]!=undefined?"onclick='"+objBtnJson["onClickFunction"]+"'":"";
			
			if(btnclass.indexOf("singleSelect")<0){
				
				 /*buttonRowhtml+="<button class='button btnLeafMenu'  data-pk='' title='"+objModuleWiseLeafMenu["menuName"]+"' data-menuid='"+objModuleWiseLeafMenu["menuid"]+"' data-url='"+objModuleWiseLeafMenu["url"]+"'>"+
				 	 "<div class='button-content'>"+
					 "<div class='button__icon'><i class='"+objModuleWiseLeafMenu["font_icon_name"]+"  fa-2x'></i></div><span class='button__text'>"+objModuleWiseLeafMenu["menuName"]+"</span>"+
					 "</div> </button>&nbsp;";*/
				
				/* html+="<button "+btnclass+" id='"+objBtnJson["buttonName"]+"' "+onClickFunction+" >"+
				 	 "<div class='button-content'>"+
					 "<div class='button__icon'>"+buttonIcon+"</div>"+buttonDisplayName+""+
					 "</div> </button>&nbsp;";*/
					 
			
			html+="<button "+btnclass+" id='"+objBtnJson["buttonName"]+"' "+onClickFunction+"   >"+buttonIcon+"&nbsp;"+buttonDisplayName+"</button>&nbsp;";
			}
		});
		html+="</div>";
	}
	html+="</div>";	
	html+="<div class='card-body'>";
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
		/*html+="<div class='row' style='border-bottom:1px solid rgba(0, 0, 0, 0.125);'>";
			html+="<div class='col-sm-12' >";
				html+="<a data-val='hide' class='btn btn-xs  bg-gradient-formButton "+hideFilterMinus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterMinus'  onclick=showHideFilters(\'"+containerId+"\',0)><i class='fas fa-minus-circle'></i>&nbsp;Hide Filters</a>";
				html+="<a data-val='show' class='btn btn-xs  bg-gradient-formButton "+hideFilterPlus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterPlus'   onclick=showHideFilters(\'"+containerId+"\',1)><i class='fas fa-plus-circle'></i>&nbsp;Show Filters</a>";
				html+="<a class='btn btn-xs  bg-gradient-formButton hideData' style='margin-top:0px!important; float:right;margin-right: 2px;' id='"+containerId+"_btnFilterMore'   onclick=showMoreFilters(\'"+containerId+"\')><i class='fas fa-filter'>&nbsp;More Filters</i></a>&nbsp;";
			html+="</div>";
		html+="</div>";*/
		
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
			html+="<a class='btn  bg-gradient-formButton  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;' onclick='closeFilterModal()'><i class='fas fa-times-circle'></i>&nbsp;<span data-langtag='Close'>Close</span></a>&nbsp;";
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
	
	
	html+="</div></div>";
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
				 //alert( $(this).prop('checked'));
				 getListPage();
			  });
		});
	
		/*$('#'+containerId +" .singleDatePicker").daterangepicker({
		    singleDatePicker: true,
		    showDropdowns: true,
		    locale: {
		          format: 'DD-MMM-YYYY'
		      }	   
		});
		$('#'+containerId +" .singleDatePicker").val('');	
		$('#'+containerId +" .singleDatePicker").on('apply.daterangepicker', function(ev, picker) {
			getListPage();
		});*/
		
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
function showMoreFilters(containerId){
	$("#"+containerId+"_divTableMoreFilter").modal('show');
}
function closeFilterModal(){
	$(".modal").modal('hide');
}
function populateListPageCombo(configJson, dataJson){
	
	if (typeof popup  !== "undefined") {
		 listJson= JSON.parse($('#spanConfigJsonPopup').html());
	}
	else{
		 listJson= JSON.parse($('#spanConfigJson').html());
	}
	if(dataJson["message"]!=undefined  && dataJson["message"].indexOf("ERROR")>=0){
		alert("Problem while getting filter data");
		return;
	}
    commonPopulateCombo(configJson, dataJson);
        //console.log(configJson["comboId"]+"===="+ $('#' + configJson["comboId"] + ' option:selected').val());
        var selectedVal=$('#' + configJson["comboId"] + ' option:selected').val();
        
        
        if(configJson["callOnLoad"]!=undefined && configJson["callOnLoad"]=="Yes"){
	        var cookeeName=$('#processName').val()+"_"+listJson["containerId"];
	        if(cookeeName!=undefined){
	        	var str=$.cookie(cookeeName);
	        	
	        	if(str!=undefined){
	        		var jsonForCookee=JSON.parse(str);
	        		if(jsonForCookee[configJson["comboId"]] !=undefined){
	        			selectedVal=jsonForCookee[configJson["comboId"]];
	        			//alert(selectedVal);
	        			if($('#' + configJson["comboId"] + " option[value='"+selectedVal+"']").length>0){
		        			$('#' + configJson["comboId"]).val(selectedVal);
		        			if( $('#'+ configJson["comboId"]).hasClass("select2"))
		        		    	$('#'+ configJson["comboId"]).select2({"width":"100%"});
		        			$('#' + configJson["comboId"]).trigger('change');
	        			}
	        		}
	        	}        	
	        }
        }
		
        var cookeeName=$('#processName').val()+"_"+listJson["containerId"];
    	//alert(configJson["comboId"]+"===="+configJson["callOnLoad"]);
        
        if(selectedVal!=""){
        	$('#' + configJson["comboId"] ).each(function(){
        		callOnFilterChange(this, configJson["callOnLoad"]);
        	});
        }
       // alert("before " +ajaxCalledOnChangeOfFilter);
        ajaxCalledOnChangeOfFilter=removeItemOnce(ajaxCalledOnChangeOfFilter, configJson["comboId"] );
       // alert("after " +ajaxCalledOnChangeOfFilter);
	
}

function processAllFilterCombo(filtersJson) {
	//alert("inside processAllFilterCombo");
try{
	if(filtersJson!=undefined){
		$('.select').select2({width: '100%'});
			$.each(filtersJson,function(k,objFilter){
				if(objFilter["filterType"]=='combo'){
					if(objFilter["parentFilterId"]==undefined){
						var pk=new Array();
						if(objFilter["initializationVariableIds"]!=undefined){
							for(var i=0;i<objFilter["initializationVariableIds"].length;i++){
								var varId=objFilter["initializationVariableIds"][i];
								if($('#'+varId).val()!=null)
									pk.push($('#'+varId).val());
							}
							//alert(pk);
						}
						
						var configJson=
						{
							serviceName:objFilter["serviceName"],
							callBackFunctionName:"populateListPageCombo",
							defaultOption:objFilter["defaultOption"],
							comboId:objFilter["filterId"],
							callOnLoad:"Yes"
						}
					
						if(pk!=null && pk.length>0){
							configJson["primaryKeys"]=pk;
						}
						//alert("inside processAllFilterCombo-- configJson---"+ JSON.stringify(configJson));
						callService(configJson);
					}
				}
			});
			
		
		
		$('.filter').change(function(){callOnFilterChange(this,"No")});
	
	}
}catch(err){
	 console.log("Problem in processAllFilterCombo===" +  err.message)
	
}
	
}

function callOnFilterChange(obj,callOnLoad){
	var currentFilterJson=null;
	var childArray=new Array();
	var multiParent=new Array();
	var parentId=obj.id;
	var parentValue=obj.value;
	var parray=new Array();
	var listJson="";
	if (typeof popup  !== "undefined") {
		 listJson= JSON.parse($('#spanConfigJsonPopup').html());
	}
	else{
		 listJson= JSON.parse($('#spanConfigJson').html());
	}
	
	var filtersJson =listJson["filters"]
	
	$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>Please select parameter option to continue..</div>");
	
	$.each(filtersJson,function(k,objFilter){
		if(objFilter["filterId"]==parentId){
			currentFilterJson=objFilter;
		}
		if(objFilter["parentFilterId"]!=undefined){
			//alert("main filterId==" +objFilter["filterId"]);
			if(objFilter["parentFilterId"].indexOf(",")<0 && objFilter["parentFilterId"]==parentId){
				//alert(JSON.stringify(objFilter));
				childArray.push(objFilter);
			}
			else{
				// multiple parent will be handled when required
				//childArray.push(objFilter);
			//	multiParent.push(objFilter);
				//parray.push($('#'+objFilter["parentFilterId"]).val())
				
				var arrparent=objFilter["parentFilterId"].split(",");
				for(var x=0;x<arrparent.length;x++){
					if(arrparent[x]==parentId){
						childArray.push(objFilter);
						break;
					}
				}
			}
		}				
	});
	//alert(JSON.stringify(childArray));
	if(childArray.length>0){
		$.each(childArray,function(k,objFilter){
			//alert("child filterId==" +objFilter["filterId"]);
			//alert(JSON.stringify(objFilter));
			var objdefaultOption= objFilter["defaultOption"];
			var filterhtml="<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>";
			$('#'+ objFilter["filterId"]).html(filterhtml);
			//alert(objFilter["filterId"]);
			var arrParentValue=new Array();
			var arrParentIds=objFilter["parentFilterId"].split(",");
			if(arrParentIds.length==1){
				arrParentValue.push(parentValue);
			}
			else{
				for(var x=0;x<arrParentIds.length;x++){
					var parentId=arrParentIds[x];
					if($('#'+parentId).length>0){
						var parentVal=$('#'+parentId).val();								
						arrParentValue.push($('#'+parentId).val());
					}
				}						
			}
			
			if(objFilter["initializationVariableIds"]!=undefined){
				for(var i=0;i<objFilter["initializationVariableIds"].length;i++){
					var varId=objFilter["initializationVariableIds"][i];
					if($('#'+varId).val()!=undefined && $('#'+varId).val()==""){
						return;
					}
					arrParentValue.push($('#'+varId).val());
				}
				//alert(pk);
			}
			if(objFilter["filterId"]!=""){
				ajaxCalledOnChangeOfFilter.push(objFilter["filterId"]);
			}
			//alert("callOnLoad in callOnFilterChange==" +callOnLoad)
			var configJson={
					serviceName:objFilter["serviceName"],
					callBackFunctionName:"populateListPageCombo",						
					defaultOption:objFilter["defaultOption"],
					comboId:objFilter["filterId"],
					primaryKeys:arrParentValue,
					callOnLoad:callOnLoad
			}
			callService(configJson);
		})
		
	}
	/*
	if(multiParent.length>0){
		$.each(multiParent,function(k,objFilter){
			//alert("child filterId==" +objFilter["filterId"]);
			//alert(JSON.stringify(objFilter));
			var objdefaultOption= objFilter["defaultOption"];
			var filterhtml="<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>";
			$('#'+ objFilter["filterId"]).html(filterhtml);
			//alert(objFilter["filterId"]);
			var configJson={
					serviceName:objFilter["serviceName"],
					callBackFunctionName:"populateListPageCombo",						
					defaultOption:objFilter["defaultOption"],
					comboId:objFilter["filterId"],
					primaryKeys:parray,
			}
			callService(configJson);
		})
		
	}*/
	//alert(ajaxCalledOnChangeOfFilter.length);
	if(ajaxCalledOnChangeOfFilter.length<=1){
		getListPage();
	}
}
function populateFilterCombo(configJson,datastr){
	try{
	if(datastr!=""){
		
		var dataJson=JSON.parse(datastr);
		//alert(dataJson);
		var objFilter=configJson["objFilter"]
		var objdefaultOption= objFilter["defaultOption"];
		var filterhtml="<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>";
		$.each(dataJson["dataValue"],function(k,vobj){
			filterhtml+="<option value='"+vobj[0]+"'>"+vobj[1]+"</option>";
		});
		$('#'+ objFilter["filterId"]).html(filterhtml);		
	}
	}catch(err){
		//alert(err.message);
		console.log("Problem in populateFilterCombo===" +  err.message)
	}
}
function getListPage(){
	$('#divSelectedFiltersJson').html("");
	try{
	//alert($('#spanConfigJson').html());
		
		//alert($('#spanConfigJsonPopup').html());
		
		var popup=$('#spanConfigJsonPopup').html();
		var listJson="";
		if (typeof popup  !== "undefined") {
			 listJson= JSON.parse($('#spanConfigJsonPopup').html());
		}
		else{
			 listJson= JSON.parse($('#spanConfigJson').html());
		}
		
	
	
	
	var filterIds=listJson["filterIds"]!=undefined?listJson["filterIds"]:[];
	//alert("filterIds==" + filterIds);
	var pk=new Array();
	var jsonForCookee={};

	if($('#'+listJson["containerId"]+"_divTableListing")!=undefined && $('#'+listJson["containerId"]+"_divTableListing").length>0){
		$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>Please select parameter option to continue..</div>");
	}
	if(ValidateForAll(listJson["containerId"])==false)
		return;
	
	if(listJson["listPageInitializationVariableIds"]!=undefined){
		for(var i=0;i<listJson["listPageInitializationVariableIds"].length;i++){
			var varId=listJson["listPageInitializationVariableIds"][i];
			pk.push($('#'+varId).val());
		}
		//alert(pk);
	}
	var filterDetailsForReport={};
	
	if(filterIds.length>0){
		for(var i=0;i<filterIds.length;i++){
			var txtVal="";
			var objFilter= $('#'+filterIds[i]);
			
			
			//alert(filterIds[i] +"====" +objFilter.length);
			var val=$(objFilter).val();
			if($(objFilter).attr("type")!="hidden"){
					var filterType=objFilter.attr("data-filterType");
					
					//alert(filterType);
					
					if(filterType=="text" || filterType=="date"){
						//alert(objFilter.attr("id") + "===val="+ val + "===defaultValueIfEmpty==" + objFilter.attr("data-defaultValueIfEmpty"));
						if(val==undefined ||val.trim()==""){
							val=objFilter.attr("data-defaultValueIfEmpty");
							txtVal=val;
						}
						
					}
					else if(filterType=="checkbox"){
						
						if($(objFilter).prop('checked')==false){
							val=objFilter.attr("data-defaultValueIfEmpty");
							txtVal=val;
						}
						//alert(val);
					}
					else if(filterType=="combo"){
						val=$(objFilter).val();
						
						txtVal=$("#"+ objFilter.attr("id") + "  option:selected" ).text();
					}
						
					
					//alert(objFilter.attr("id") + "===val="+ val );
					if(val==undefined ||val.trim()==""){
						return;
					}
					
					if(val!=undefined && val.toUpperCase()!="ALL" && val!="0" && val!="-1")
						filterDetailsForReport[$(objFilter).closest('.form-group').find('.col-form-label').html().trim()]=txtVal.trim();
			}
			var jsonForRepopulatingFilters={
					filterId:$(objFilter).attr("id"),
					filterValue:val
			}
			jsonForCookee[$(objFilter).attr("id")]=val;
					
			pk.push(val);
		}
		
			
			var cookeeName=$('#processName').val()+"_"+listJson["containerId"];
			$.cookie(cookeeName,JSON.stringify(jsonForCookee));
		
		$('#divSelectedFiltersJson').html(JSON.stringify(filterDetailsForReport));
	}
	//alert("swrvice>>>"+listJson["listServiceName"]);
	$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>Please Wait for a moment..</div>");
	var configJson={
			serviceName:listJson["listServiceName"],
			callBackFunctionName:"populateListPage",
			primaryKeys:pk,
			listJson:listJson
		}
	//alert("listpage config==="+JSON.stringify(configJson));
	callService(configJson);
	}catch(err){
		console.log("Problem in getListPage===" +  err.message)
	}
	
}
function populateListPage(configJson,dataJson){
	try{
	//	alert(JSON.stringify(dataJson));
	
		//alert("listpage called");
		var listJson=configJson["listJson"];
		//alert(JSON.stringify(listJson["buttons"]));
		var record=listJson["noOfRecordPerPage"]!=undefined?listJson["noOfRecordPerPage"]:"10";
		if(dataJson["message"]!=undefined && dataJson["message"].indexOf("ERROR")>=0){
			$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>"+dataJson["msg"]+"</div>");
			return;
		}
		//alert(JSON.stringify(listJson))
		var tableConfigJson={
				divId:listJson["containerId"]+"_divTableListing",
				tableId:listJson["containerId"]+"_TBL_LISTING",
				paginationRequired:listJson["paginationRequired"]!=undefined && listJson["paginationRequired"]==false?false:true,
				searchRequired:listJson["searchRequired"]!=undefined && listJson["searchRequired"]==false?false:true,
				isCheckBoxRequired:listJson["isCheckBoxRequired"]!=undefined && listJson["isCheckBoxRequired"]==false?false:true,
				recordPerPage:record,
				noSearchSortColumnNo:listJson["noSearchSortColumnNo"],				
				columnHidden:listJson["columnHidden"]==undefined?[]:listJson["columnHidden"],
				isFirstRowHeading:listJson["isFirstRowHeading"]!=undefined && listJson["isFirstRowHeading"]==true?true:false,
				callBackFunctionAfterTableLoaded:listJson["callBackFunctionAfterTableLoaded"]!=undefined?listJson["callBackFunctionAfterTableLoaded"]:null,
				listPageHeading:listJson["listPageHeading"]	,
				userDefinedFunctionOnRowSelect:listJson["userDefinedFunctionOnRowSelect"]!=undefined?listJson["userDefinedFunctionOnRowSelect"]:null,
				buttons:listJson["buttons"]!=undefined?listJson["buttons"]:null,
		}
		
		getTableListing(tableConfigJson,dataJson);	
	}catch(err){
		alert("Problem in populateListPage===" +  err.message)
	}
}


function getTableListing(tableConfigJson, dataJson) {
    try {
        // Early exit if no data
        if (!dataJson.data || dataJson.data.length === 0) {
            $('#' + tableConfigJson.divId).html("<div class='alert alert-danger text-center' style='width:100%' role='alert'>No Data Found !</div>");
            return;
        }

        // Cache DOM elements and frequently accessed properties
        const divId = tableConfigJson.divId;
        const tableId = tableConfigJson.tableId;
        const firstDataJson = dataJson.data[0];
        const hasCheckbox = tableConfigJson.isCheckBoxRequired;
        const buttons = tableConfigJson.buttons || [];
        const columnHidden = tableConfigJson.columnHidden || [];
        const noSearchSortColumnNo = tableConfigJson.noSearchSortColumnNo || [];

        // Prepare headers
        const headers = Object.keys(firstDataJson);
        const columnCount = headers.length;
        const columnWidth = 95 / (columnCount - 1) + '%';

        // Build table HTML efficiently
        let html = `<table id="${tableId}" class="table table-striped border" width="100%" style="width:100%;" cellspacing="0"><thead><tr class="tableHeading">`;

        // Check if we need action column
        const hasSingleSelect = buttons.some(btn => 
            btn.buttonClass && btn.buttonClass.includes("singleSelect")
        );

        // Build headers
        headers.forEach((header, index) => {
            header = header.trim();
            const isPkColumn = header.toUpperCase() === "PKCOLUMN";
            
            if (hasCheckbox && index === 0) {
                html += `<th scope="col" class="colHeading" style="width:5%;text-align:center;" data-langtag="${header}">
                    <input type="checkbox" onclick="checkUncheckAll(this)"></th>`;
            } else if (!isPkColumn || !hasCheckbox) {
                const width = hasCheckbox && index === 0 ? '5%' : columnWidth;
                html += `<th scope="col" class="colHeading" style="width:${width}" data-langtag="${header}">${header}</th>`;
            }
        });

        if (hasSingleSelect) {
            html += `<th scope="col" style="text-align:center;width:5%">Action</th>`;
        }

        html += "</tr></thead><tbody>";

        // Build table rows
        const tbodyRows = dataJson.data.map(jsonobj => {
            let rowHtml = "<tr>";
            let primaryKey = "";
            let x = 0;

            for (const k in jsonobj) {
                if (x === 0) {
                    primaryKey = jsonobj[k];
                    if (hasCheckbox) {
                        rowHtml += `<td><div style='width:100%;text-align:center'>
                            <input type="checkbox" name="pk" class="check" value="${jsonobj[k]}"></div></td>`;
                    }
                } else if (k.toUpperCase() !== "PKCOLUMN" || !hasCheckbox) {
                    rowHtml += `<td>${jsonobj[k]}</td>`;
                }
                x++;
            }

            if (hasSingleSelect) {
                const encryptedPk = encrypt(primaryKey);
                const buttonHtml = generateRecordWiseButton(buttons).replaceAll(/#pk#/g, encryptedPk);
                
                rowHtml += `<td style="text-align:center;">
                    <div class="dropdown">
                        <button class="btn btn-sm dropdown-his dropdown-toggle" type="button" 
                            id="dropdownMenuButton" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa-solid fa-ellipsis-vertical"></i>
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">${buttonHtml}</ul>
                    </div>
                </td>`;
            }

            return rowHtml + "</tr>";
        }).join('');

        html += tbodyRows + "</tbody></table>";

        // Insert HTML in one operation
        $('#' + divId).html(html);

        // Prevent default button actions
        $("button, input[type=button]").click(e => e.preventDefault());

        // Prepare DataTable configuration
        const dataTableConfig = {
            paging: tableConfigJson.paginationRequired !== false,
            searching: tableConfigJson.searchRequired !== false,
            searchHighlight: true,
            responsive: true,
            dom: 'lBfrtip',
            buttons: [{
                extend: 'collection',
                text: 'Options',
                buttons: getTableButtons(tableConfigJson, headers)
            }],
            columnDefs: noSearchSortColumnNo.map(target => ({
                targets: target,
                searchable: false,
                orderable: false,
                width: '1%',
                className: 'no-sort dt-body-center'
            }))
        };

        // Add hidden columns
        columnHidden.forEach(col => {
            dataTableConfig.columnDefs.push({
                targets: col,
                visible: false
            });
        });

        // Add pagination options if needed
        if (tableConfigJson.paginationRequired) {
            const recordPerPage = parseInt(tableConfigJson.recordPerPage) || 10;
            dataTableConfig.lengthMenu = [
                [recordPerPage, recordPerPage + 15, recordPerPage + 40, -1],
                [recordPerPage, recordPerPage + 15, recordPerPage + 40, "All"]
            ];
        }

        // Initialize DataTable
        const table = $('#' + tableId).DataTable(dataTableConfig);

        // Style adjustments
        $('.dataTables_wrapper').css({ "width": "100%", "margin-top": "1%" });
        $('#' + tableId + ' thead').find('.no-sort').removeClass('sorting_asc');
        $('.buttons-collection').html("<span><i class='fas fa-cog'></i></span>");

        // Event handlers
        table.on('search.dt draw.dt', () => {
            setDataTitleToDataTableForNoMoreTable(tableId);
        });

        // Checkbox functionality if present
        if (hasCheckbox) {
            setupCheckboxHandlers(tableConfigJson, tableId);
        }

        // Callback after table loads
        if (tableConfigJson.callBackFunctionAfterTableLoaded) {
            try {
                eval(tableConfigJson.callBackFunctionAfterTableLoaded)(tableId);
            } catch (e) {
                console.error("Error in callback:", e);
            }
        }

        // Initial button state
        updateButtonVisibility();

    } catch (err) {
        console.error("Problem in getTableListing:", err.message);
    }
}

// Helper function to generate table buttons
function getTableButtons(tableConfigJson, headers) {
    const date = getCurrentDateString();
    let strFilter = "";
    let messageTop = generateMessageTop(tableConfigJson, date);
    
    if ($('#divSelectedFiltersJson').html().trim()) {
        const selectedFiltersJson = JSON.parse($('#divSelectedFiltersJson').html());
        strFilter = generateFilterString(selectedFiltersJson);
        messageTop += generateFilterTable(selectedFiltersJson);
    }

    const buttons = [
        {
            extend: 'copyHtml5',
            exportOptions: { columns: ':visible' }
        },
        {
            extend: 'excelHtml5',
            exportOptions: { columns: ':visible' }
        },
        {
            extend: 'csvHtml5',
            exportOptions: { columns: ':visible' }
        },
        {
            extend: 'pdfHtml5',
            filename: tableConfigJson.listPageHeading,
            customize: function(doc) {
                doc.defaultStyle.fontSize = 10;
                doc.styles.tableHeader.fontSize = 10;
                doc.content[1].margin = [0, 0, 0, 0];
                doc.content.splice(0, 0, {
                    margin: [0, 0, 0, 0],
                    alignment: 'center',
                    image: logo,
                    width: 500,
                    height: 60,
                });
            },
            title: () => tableConfigJson.listPageHeading,
            message: strFilter,
            pageSize: headers.length > 6 ? "LETTER" : "A4",
            exportOptions: { columns: ':visible' }
        },
        {
            extend: 'print',
            messageTop: messageTop,
            title: () => '',
            exportOptions: { columns: ':visible' }
        }
    ];

    if (headers.length > 2) {
        buttons.push('colvis');
    }

    return buttons;
}

// Helper function to generate message top
function generateMessageTop(tableConfigJson, date) {
    return `<table width="100%">
        <tbody>
            <tr>
                <td valign="top" align="center" width="100%">
                    <img src="/HIS/hisglobal/images/reportHeader.png" style="width: 600;height:80">
                </td>
            </tr>
            <tr>
                <td valign="top" align="center" width="100%">
                    <font style="font-size: 1em; font-weight: bold; text-decoration: underline;">
                        ${tableConfigJson.listPageHeading}
                    </font>
                </td>
            </tr>
            <tr>
                <td align="right" width="100%">
                    <font style="font-size: 0.8em;">Report Date :${date}</font>
                </td>
            </tr>
        </tbody>
    </table>`;
}

// Helper function to generate filter string
function generateFilterString(filters) {
    return Object.entries(filters)
        .map(([heading, value]) => `${heading} :- ${value}`)
        .join(' | ');
}

// Helper function to generate filter table
function generateFilterTable(filters) {
    let rowstr = '';
    let i = 0;
    
    for (const [heading, value] of Object.entries(filters)) {
        if (i % 3 === 0) rowstr += '<tr>';
        rowstr += `<td align="left" width="33%">${heading} :- ${value}</td>`;
        if (i % 3 === 2) rowstr += '</tr>';
        i++;
    }
    
    if (i % 3 !== 0) rowstr += '</tr>';
    
    return `<table width="100%"><tbody>${rowstr}</tbody></table>`;
}

// Helper function to setup checkbox handlers
function setupCheckboxHandlers(tableConfigJson, tableId) {
    const $table = $('#' + tableId);
    
    $('[name="pk"]').closest('td').addClass('hideInNoMoreTable');
    
    $table.on('click', 'input[type="checkbox"]', function(e) {
        const $row = $(this).closest('tr');
        $row.toggleClass('selected', this.checked);
        updateButtonVisibility();
        
        if (tableConfigJson.userDefinedFunctionOnRowSelect) {
            try {
                eval(tableConfigJson.userDefinedFunctionOnRowSelect);
            } catch (err) {
                console.error("Error in userDefinedFunctionOnRowSelect:", err);
            }
        }
        buttonEnable(this.value);
        
        e.stopPropagation();
    });
    
    $table.on('click', 'tr', function(e) {
        $(this).find('[name="pk"]').trigger('click');
        
        if (tableConfigJson.userDefinedFunctionOnRowSelect) {
            try {
                eval(tableConfigJson.userDefinedFunctionOnRowSelect);
            } catch (err) {
                console.error("Error in userDefinedFunctionOnRowSelect:", err);
            }
        }
    });
}

function buttonEnable(val){
	
	return;
}

// Helper function to update button visibility
function updateButtonVisibility() {
    const selectedRowCount = $('.selected').length;
    $('.selectbtn').toggle(selectedRowCount > 0);
    $('.singleSelect').toggle(selectedRowCount <= 1);
}



function getTableListing1(tableConfigJson,dataJson){
try{
	
	//alert(JSON.stringify(dataJson));
	
		//alert(JSON.stringify(tableConfigJson));
	
	if(dataJson["data"]==undefined || dataJson["data"].length==0){
		$('#'+tableConfigJson["divId"]).html("<div class='alert alert-danger text-center' style='width:100%' role='alert'>No Data Found !</div>");
		return;
	}
	
	
	var html="<table id='"+tableConfigJson["tableId"]+"'  class='table table-striped border' width='100%' style='width:100%;' cellspacing='0'><thead>";
	html+="<tr class='tableHeading'>"; 
	
	var firstDataJson= dataJson["data"][0];
	var heading = new Array();
	var data = new Array();
	
	
	for(var k in firstDataJson) 
		heading.push(k);
	
	//alert("heading >>>>"+heading);
	
	var columnWidth=95/(heading.length-1);
	/*if(tableConfigJson["isFirstRowHeading"]==true){
		dataJson["dataHeading"]=dataJson["dataValue"][0]
		dataJson["dataValue"].shift();
	}*/
	
	$.each(heading,function(k,val){
		
		var currColumnWidth=columnWidth+"%";
		val=val.trim();
		var datalangTag="data-langtag='"+val+"'";
		var visClassMobile="";
		var textAllign=''
		//alert(tableConfigJson["isCheckBoxRequired"])
		if(tableConfigJson["isCheckBoxRequired"]){	
			if(k==0 || val.toUpperCase()=="PKCOLUMN"){
				val="<input type='checkbox' onclick='checkUncheckAll(this)'>";
				datalangTag="";
				currColumnWidth='5%';
				textAllign="text-align:center;"
				//alert("inside if")
			}
		}
		
		if(!tableConfigJson["isCheckBoxRequired"]){
			if(val.toUpperCase()=="PKCOLUMN"){
				html+=""
			}
			else{
				html+="<th scope='col' class='colHeading' style='width:"+currColumnWidth+";"+textAllign+";' "+datalangTag+" >"+val+"</th>";
			}
		}
		else{
			html+="<th scope='col' class='colHeading' style='width:"+currColumnWidth+";"+textAllign+";' "+datalangTag+" >"+val+"</th>";
		}
		
		
		
	});	
	
	var singleSelectCount=0;
	
	$.each(tableConfigJson["buttons"],function(indx,objBtnJson){
		
		var btnclass=objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			
			if(btnclass.indexOf("singleSelect")>0){
				singleSelectCount=singleSelectCount+1;
				 
			}
		});
		//alert(singleSelectCount);
		
	
	if(singleSelectCount>0){
		html+="<th scope='col' style='text-align:center;width:5%'>Action</th>";
	}
	
	
	
	html+="</tr></thead><tbody></tbody></table>";
	
	$('#'+tableConfigJson["divId"]).html(html);
	$.each(dataJson["data"],function(indx, jsonobj){
		var trhtml="<tr>";
		var primaryKey="";
		var x=0;
		for(var k in jsonobj){
			if(x==0){
				if(tableConfigJson["isCheckBoxRequired"])
				trhtml+="<td><div style='width:100%;text-align:center'><input type='checkbox' name='pk' class='check' value='"+jsonobj[k]+"' ></div></td>";
				
				primaryKey=jsonobj[k];
			}
			else{
				trhtml+="<td>"+ jsonobj[k]+"</td>";
			}			
			x++;
		}
		
		if(singleSelectCount>0){
		
		var buttonHtmlPKBased =generateRecordWiseButton(tableConfigJson["buttons"]);
			 
			 var mybutton=buttonHtmlPKBased.replaceAll(/#pk#/g,encrypt(primaryKey));
			 
			 //alert("my button >>> "+mybutton);
			 
		trhtml+="<td style='text-align:center;' >" +
			 		"<div class='dropdown'>" +
			 		"<button class='btn btn-sm dropdown-his dropdown-toggle' type='button' id='dropdownMenuButton' data-bs-toggle='dropdown' aria-expanded='false'>" +
			 		" <i class='fa-solid fa-ellipsis-vertical'></i> </button>" +
			 		" <ul class='dropdown-menu' aria-labelledby='dropdownMenuButton'>"+ mybutton+"</ul>" +
			 		"</div></td>" ;
		}	 		 	
		trhtml+="</tr>";
		
		$("#" +tableConfigJson["tableId"] + " tbody").append(trhtml);
	});
	$( "button" )
		.click(function( event ) {
		event.preventDefault();
	});
	$( "input[type=button], button" )
		.click(function( event ) {
		event.preventDefault();
	});
	
	/*$.each(dataJson["dataHeading"],function(k,val){
		try{
			convertCurrentTagKey(val.trim());
		}
		catch(err){
			console.log("cannot convert to language");
		}
	});*/
	//alert(dataJson["dataValue"]);
	var date = getCurrentDateString();
	var strFilter="";
	var messageTop='<table width="100%">'; 
	messageTop+='<tbody>';
	messageTop+='<tr>';
	messageTop+='<td  valign="top" align="center" width="100%">';
	messageTop+='<img src="/HIS/hisglobal/images/reportHeader.png" style="width: 600;height:80" ></td>'; 
	messageTop+='</tr>';
	messageTop+='<tr>';
	messageTop+='<td  valign="top" align="center" width="100%">';
	messageTop+='<font style="font-size: 1em;	font-weight: bold;text-decoration: underline;">'+tableConfigJson["listPageHeading"]+'</font>';
	messageTop+='</td>'; 
	messageTop+='</tr>';
	messageTop+='<tr>';
	messageTop+='<td  align="right" width="100%">';
	messageTop+='<font style="font-size: 0.8em;">Report Date :'+date+'</font>';
	messageTop+='</td>'; 
	messageTop+='</tr>';
	messageTop+='</tbody></table>';
	
	
	
	if($('#divSelectedFiltersJson').html().trim()!=""){
		
		var selectedFiltersJson=JSON.parse($('#divSelectedFiltersJson').html());
	
		
		var rowstr="";
		
		
		 var i=0;
		
		$.each(selectedFiltersJson,function(heading, value){
			strFilter +='  '+heading+' :- '+value+ ' |';
			i++;
			if(i==1){
				rowstr+='<tr>';
			}
			rowstr+='<td  align="left" width="33%">'+heading+' :- '+value +'</td>';
			
			
			if(i%3==0){
				rowstr+='</tr>';
				i=0;
			}
			
			
		});
		if(i!=0)
			rowstr+='</tr>';
		strFilter=strFilter.substr(0,strFilter.length-1);
		
		messageTop+='<table width="100%">'; 
		messageTop+='<tbody>';
		messageTop+=rowstr;		
		messageTop+='</tbody></table>';
	}
	
	var tableButtons= [
        {
            extend: 'copyHtml5',
            exportOptions: {
                columns: ':visible'
            }
        },
       {
     	   extend: 'excelHtml5',
            exportOptions: {
                
                columns: ':visible'
            }
            /*extend: 'excel',
            exportOptions: {
                columns: ':visible'
            }*/
        },
       {
            extend: 'csvHtml5',
            exportOptions: {
                columns: ':visible'
            }
        },

       {
            extend: 'pdfHtml5',
            filename:tableConfigJson["listPageHeading"],
            customize : function(doc){
         	doc.defaultStyle.fontSize = 10; 
             doc.styles.tableHeader.fontSize = 10;
             doc.content[1].margin = [ 0, 0, 0, 0 ]; //left, top, right, bottom
             doc.content.splice( 0, 0, {
                   margin: [ 0, 0, 0, 0 ],
                   alignment: 'center',
                   image: logo,
                   width: 500,
                   height: 60,
               });
            },
            title: function() {
         	   return tableConfigJson["listPageHeading"];
            },
            message:strFilter,
            pageSize:heading.length>6?"LETTER":"A4",
         		   
            exportOptions: {
                columns: ':visible'
            }
        },
       {
            extend: 'print',
            messageTop:messageTop,
            title: function() {
         	   
                return ''
              },
            exportOptions: {
                columns: ':visible'
            }
        }       		              
        ];
	  	
	if(heading.length>2){
	tableButtons.push( 'colvis'  )
	}
	//alert(JSON.stringify(tableButtons));
	var arrcolumnHidden=tableConfigJson["columnHidden"];
	var data={};
	
	
	data ={	
	"paging": tableConfigJson["paginationRequired"]!=undefined && tableConfigJson["paginationRequired"]==false?false:true,
	"searching": tableConfigJson["searchRequired"]!=undefined && tableConfigJson["searchRequired"]==false?false:true ,
	searchHighlight: true,
	responsive: true,
	dom:'lBfrtip',
	buttons: [ 	            
	         {
	              extend: 'collection',
	              text: 'Options',
	              buttons:tableButtons
	          }
	   ],
	  'columnDefs':[{
		  'targets': target,
			'searchable': false,
			'orderable': false,           
			'width': '1%',
			'className': 'no-sort dt-body-center',  
	  }]
	     
	};
	var target=new Array();
	if(tableConfigJson["noSearchSortColumnNo"]!=undefined){
	target=tableConfigJson["noSearchSortColumnNo"];
	}
	
	for(var i=0;i<arrcolumnHidden.length;i++){
		var objhiidencol={"targets": arrcolumnHidden[i], "visible": false  };
		data['columnDefs'].push(objhiidencol);
	}
	//alert(data['columnDefs']);
	
	var recordPerPage=parseInt(tableConfigJson["recordPerPage"])
	if(tableConfigJson["paginationRequired"])
		data['lengthMenu']= [[recordPerPage, recordPerPage+15, recordPerPage+40, -1], [recordPerPage, recordPerPage+15, recordPerPage+40, "All"]];
	
	// alert(JSON.stringify(data));
	var table=$('#'+ tableConfigJson["tableId"]).DataTable(data);
	
	$('.dataTables_wrapper').css({"width":"100%", "margin-top":"1%"})
	
	$('#'+ tableConfigJson["tableId"] +' thead').find('.no-sort').removeClass('sorting_asc');
	
	table.on( 'search.dt', function () {
	setDataTitleToDataTableForNoMoreTable(tableConfigJson["tableId"]);
	} );
	table.on('draw.dt', function() {
	setDataTitleToDataTableForNoMoreTable(tableConfigJson["tableId"]);
	});
	
	$('.buttons-collection').html("<span><i class='fas fa-cog'></i></span>");
	
	// apply row select on checkbox functionality if present
	if(tableConfigJson["isCheckBoxRequired"]){	
	$('[name="pk"]').closest('td').addClass('hideInNoMoreTable');	
	$('#'+tableConfigJson["tableId"]+' tbody').on('click', 'input[type="checkbox"]', function(e){
		var $row = $(this).closest('tr');
		//alert(this.checked);
		if(this.checked){
		  $row.addClass('selected');
		} else {
		  $row.removeClass('selected');
		}
		var selectedRowCount=$('.selected').length;
		if(selectedRowCount==0)
			  $('.selectbtn').hide();
		else if(selectedRowCount==1)
			  $('.selectbtn').show();
		else if(selectedRowCount>1)
			  $('.singleSelect').hide();
		
		if(tableConfigJson["userDefinedFunctionOnRowSelect"]!=null && tableConfigJson["userDefinedFunctionOnRowSelect"]!=undefined){
			eval(tableConfigJson["userDefinedFunctionOnRowSelect"]);
			//alert("called==" + tableConfigJson["userDefinedFunctionOnRowSelect"]);
		}
		e.stopPropagation();
	});
	
	$('#'+tableConfigJson["tableId"]+' tbody').on('click', 'tr', function(e){
		$(this).find('[name="pk"]').trigger('click');
		
		if(tableConfigJson["userDefinedFunctionOnRowSelect"]!=null && tableConfigJson["userDefinedFunctionOnRowSelect"]!=undefined){
			eval(tableConfigJson["userDefinedFunctionOnRowSelect"]);
			//alert("called==" + tableConfigJson["userDefinedFunctionOnRowSelect"]);
		}
	});
	
	
	}
	setDataTitleToDataTableForNoMoreTable(tableConfigJson["tableId"]);
	
	
	if(tableConfigJson["callBackFunctionAfterTableLoaded"]!=null){
		eval(tableConfigJson["callBackFunctionAfterTableLoaded"])(tableConfigJson["tableId"]);
	}
	var selectedRowCount=$('.selected').length;
	if(selectedRowCount==0)
		  $('.selectbtn').hide();
	else if(selectedRowCount==1)
		  $('.selectbtn').show();
	else if(selectedRowCount>1)
		  $('.singleSelect').hide();
	
}catch(err){
	console.log("Problem in getTableListing===" +  err.message)
}
}

function generateRecordWiseButton(buttonJson){
	var buttonHtmlPKBased="";
	var jsonArrbuttonHtmlPKBased=null;
	
	
		jsonArrbuttonHtmlPKBased= buttonJson;
		
		//alert(JSON.stringify(jsonArrbuttonHtmlPKBased))
		
		$.each(jsonArrbuttonHtmlPKBased,function(indx, objBtnJson){
			var btnclass =objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			var onClickFunction=objBtnJson["onClickFunction"]!=undefined?"onclick='"+objBtnJson["onClickFunction"]+"'":"";
			var buttonDisplayName=objBtnJson["buttonDisplayName"]!=undefined? "<span class='button__text'>"+objBtnJson["buttonDisplayName"]+ "</span>":"";
			var buttonIcon= objBtnJson["buttonIcon"]!=undefined?"<i class='"+objBtnJson["buttonIcon"]+" fa-2x'></i>":"";
			
			if(btnclass.indexOf("singleSelect") >0){
				
				/*html+="<button "+btnclass+" id='"+objBtnJson["buttonName"]+"' "+onClickFunction+"   >"+buttonIcon+"&nbsp;"+buttonDisplayName+"</button>&nbsp;";*/
				
				buttonHtmlPKBased+=" <li  ><button class='dropdown-item dropdown-button btnLeafMenu' data-pk='#pk#' "+ onClickFunction+" >" +				 
				 "<div class='button-content'><div class='button__icon'>"+
				 ""+buttonIcon+"</div> "+buttonDisplayName+" </div></a></li>" ;
			}
			
		});
	
	return buttonHtmlPKBased;
}

function setDataTitleToDataTableForNoMoreTable(tableId){
	try{
		
		if($('#'+tableId).closest('div').hasClass('no-more-tables')==false){
			$('#'+tableId).closest('div').addClass('no-more-tables');
		}
		//alert($('#'+tableId).closest('div').hasClass('no-more-tables'));	
	  	var ix=0;
	  	$('#'+tableId+' thead tr th').each(function(){
	  		//alert("indx==" + ix+"===="+  $(this).html());
	  		var html=$(this).html();
	  		if(html.trim()=="")
	  			html="-"
	  		ix++;
	  		if(html.indexOf("checkbox")>=0)
	  			html="Click To Select";
	  		////alert($('#'+tableId+' tbody tr td:nth-child('+ix+')').length);
	  		$('#'+tableId+' tbody tr td:nth-child('+ix+')').attr("data-title",html);
	  	});
	  
	}catch(err){
		console.log("Problem in setDataTitleToDataTableForNoMoreTable===" +  err.message)
	}
  }

function getPrimaryKeyFromListPage(){
	var primarykey="";
	
	var count=0;

	if(document.getElementsByName("pk").length>0){
		for(var i=0;i<document.getElementsByName("pk").length;i++){
			if(document.getElementsByName("pk")[i].checked){
				primarykey+=document.getElementsByName("pk")[i].value+",";
				count++;
			}
		}
		if(count==0){
			return 0;
		}
	}	
	else{		
		return 0;
	}
	
	return primarykey;
}

function getPrimaryKeyFromListPage(){
	var arrPrimarykey=new Array();
	
	var count=0;

	if(document.getElementsByName("pk").length>0){
		for(var i=0;i<document.getElementsByName("pk").length;i++){
			if(document.getElementsByName("pk")[i].checked){
				arrPrimarykey.push(document.getElementsByName("pk")[i].value);
				count++;
			}
		}		
	}
	
	return arrPrimarykey;
}
function listPageViewRecord(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	else if(arrPrimarykey.length>1){
		alert("Please select only 1 record to modify!")
		return;
	}
	else if(arrPrimarykey.length==1){
		var pk=arrPrimarykey[0].split("@");
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="listPageViewRecord()"){
				buttonJson=vobj;
			}
		});
		var serviceName=buttonJson["onClickServiceName"];
		
		var configJson={
				serviceName:serviceName,
				listPageHeading:listJson["listPageHeading"],
				callBackFunctionName:"showViewPage",				
				primaryKeys:pk			
			}
		callService(configJson);
	}	
}


function listPageViewRecordCustom(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	else if(arrPrimarykey.length>1){
		alert("Please select only 1 record to modify!")
		return;
	}
	else if(arrPrimarykey.length==1){
		var pk=arrPrimarykey[0].split("@");
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="listPageViewRecordCustom()"){
				buttonJson=vobj;
			}
		});
		var serviceName=buttonJson["onClickServiceName"];
		
		var configJson={
				serviceName:serviceName,
				listPageHeading:listJson["listPageHeading"],
				callBackFunctionName:"showViewPageCustom",				
				primaryKeys:pk			
			}
		callService(configJson);
	}	
}

function showViewPage(configJson, dataJson){
	//alert(datastr);
	$('divView').html("");
	
		//alert(JSON.stringify(dataJson));
		var html="<div class='card'>";
		html+="<div class='card-header formCardHeader'><h5 class='card-title float-left' data-langtag='"+configJson["listPageHeading"]+"'>"+configJson["listPageHeading"]+" >> View Page</h5>";
		html+="<a class='btn  btn-info text-white  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;' onclick='closeListModal()'><i class='fas fa-times-circle'></i>&nbsp;<span data-langtag='Close'>Close</span></a>&nbsp;";
		html+="<a class='btn  btn-info text-white  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;' data-ReportName='"+configJson["listPageHeading"]+" >> View Page' onclick='printListViewHTML(this)'><i class='fas fa-print'></i>&nbsp;<span data-langtag='Print'>Print</span></a>&nbsp;";
		html+="<a class='btn  btn-info text-white  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;'  data-ReportName='"+configJson["listPageHeading"]+" >> View Page' onclick='printListViewPDF(this)'><i class='fas fa-file-pdf'></i>&nbsp;<span data-langtag='PDf'>PDF</span></a>";
		html+="</div>";
		html+="<div class='card-body' id='divViewBodyForPrint'>";
		html+="<div class='row'>";
		
		var dataobj= dataJson["data"][0];
		for(var k in dataobj){
			if(k.indexOf('#heading')>=0){
				html+="<div class='col-sm-12'>";
					html+="<div class='form-group'>";
					html+="<label class='col-form-label col-form-label-sm col-sm-12 viewHeading' >"+dataobj[k]+" </label>";
					html+="</div>";
				html+="</div>";
			}
			else{
			
				html+="<div class='col-sm-3'>";
				html+="<div class='form-group'>";
				html+="<label class='col-form-label col-form-label-sm col-sm-12' for='institutionName' data-langtag='"+k+"'>"+k+" </label>";
				html+="<label class='col-form-label col-form-label-sm col-sm-12  lbldata'  >"+dataobj[k]+"</label>";
				html+="</div>";
				html+="</div>";
			}
		}
		
		html+="</div>";
		html+="</div>";
		html+="</div>";
		
		$('#divViewBody').html(html);
		$('#divView').modal('show');
	//	convertAllLanguageTagsInDiv("divViewBody");
	
	
}
function printListViewHTML(obj){
	var ReportName=$(obj).attr("data-ReportName");
	var configjson={divId:"divViewBodyForPrint",reportName:ReportName };
	printHTML(configjson);
}
function printListViewPDF(obj){
	var ReportName=$(obj).attr("data-ReportName");
	var configjson={divId:"divViewBodyForPrint",reportName:ReportName };
	printPDF(configjson);
}
function closeListModal(){
	$('#divView').modal('hide');
}

function listPageDeleteRecordDtl(){
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	var listJson= JSON.parse($('#spanConfigJson').html());
	var buttonJson=null;
	// getting buttonobj from json whose onclick function is listPageDeleteRecordDtl
	$.each(listJson["buttons"],function(key,vobj){
		if(vobj["onClickFunction"]=="listPageDeleteRecordDtl()"){
			buttonJson=vobj;
		}
	});
	var flag= confirm("Are you sure want to delete record ?");
	if(flag==false)
		return;
	var serviceName=buttonJson["onClickServiceName"];
	var configJson={
			serviceName:serviceName,
			callBackFunctionName:"getDeletStatus",				
			initMode:buttonJson["initMode"],
			inputData:{primaryKeys:arrPrimarykey}				
	}
	callService(configJson);
		
}


function listPageDeleteSingleRecordDtl(obj){
	var pk=$(obj).attr("data-pk");
	 
	 
	
	
	var arrPrimarykey=new Array();
	arrPrimarykey.push(decrypt(pk));
	//alert(arrPrimarykey);
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	var listJson= JSON.parse($('#spanConfigJson').html());
	var buttonJson=null;
	// getting buttonobj from json whose onclick function is listPageDeleteRecordDtl
	$.each(listJson["buttons"],function(key,vobj){
		if(vobj["onClickFunction"]=="listPageDeleteSingleRecordDtl(this)"){
			buttonJson=vobj;
		}
	});
	var flag= confirm("Are you sure want to delete record ?");
	if(flag==false)
		return;
	var serviceName=buttonJson["onClickServiceName"];
	//alert(serviceName);
	var configJson={
			serviceName:serviceName,
			callBackFunctionName:"getDeletStatus",				
			inputData:{primaryKeys:arrPrimarykey}				
	}
	callService(configJson);
	
}

function getDeletStatus(configJson,datastr1){

	if(datastr1!=""){
		var datastr=JSON.stringify(datastr1);
		var dataJson=JSON.parse(datastr);
		console.log(datastr)
		var msg=dataJson["message"];
		
		if(msg.indexOf("ERROR")>=0){
			showMsg(dataJson["message"]);	
		}
		else{
			$('.selectbtn').hide();
			var dialogConfigJson={callOnOK:"getListPage"};
			showMsg(msg,dialogConfigJson);
		}
}}

function listInitAddPage(){
	$('#ENTRYFORM').removeClass('hideData');
	$('#LISTPAGE').addClass('hideData');
	$('#initMode').val("ADD");
	initInputJson=$(':input').serializeArray();	
	entryFormHeading("Add Page");
	resetPage();
}


function listInitModifyPage(){
	//alert("inside listInitModifyPage");
	resetPage();
	var arrPrimarykey=getPrimaryKeyFromListPage();
	if(arrPrimarykey.length==0){
		alert("Please select a record!")
		return;
	}
	else if(arrPrimarykey.length>1){
		alert("Please select only 1 record to modify!")
		return;
	}
	else if(arrPrimarykey.length==1){
		
		var pk=arrPrimarykey[0].split("@");
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="listInitModifyPage()"){
				buttonJson=vobj;
			}
		});
		var serviceName=buttonJson["onClickServiceName"];
		$('#ENTRYFORM').removeClass('hideData');
		$('#LISTPAGE').addClass('hideData');
		$('#initMode').val("MODIFY");
		//alert(pk);
	//	alert(arrPrimarykey);
		//alert(serviceName);
		resetWizzardView($('#enableWizzardView').val());
		var configJson={
				serviceName:serviceName,
				callBackFunctionName:"populateFormData",				
				primaryKeys:pk		
			}
		callService(configJson);
		entryFormHeading("Modify Page");
	}	
}


function backToListPage(){
	$('#LISTPAGE').removeClass('hideData');
	$('#ENTRYFORM').addClass('hideData');	
	getListPage();	
}

function submittonew(obj)
{	
	
	 
	 /*var arrPrimarykey=getPrimaryKeyFromListPage();
	 
	 if(arrPrimarykey.length==0){
			alert("Please select a record!")
			return;
		}
		else if(arrPrimarykey.length>1){
			alert("Please select only 1 record to modify!")
			return;
		}
		else if(arrPrimarykey.length==1){*/
		
		
	 
	 
	 
	 //var pk=arrPrimarykey[0];
	 
	 var pk=$(obj).attr("data-pk");
	 
	 
	
	 $("#primaryKeys").val(decrypt(pk));
	 //alert("pkkkls"+ $("#primaryKeys").val());
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="submittonew(this)"){
				buttonJson=vobj;
			}
		});
		
		var masterkey=buttonJson["masterkey"];
		var initmode=buttonJson["initMode"];
		
		
		
		 $('#masterKey').val(masterkey);	 
		 $('#initMode').val(initmode);	 
		 $('#hmode').val("CallMasterPage");
		 showPreloader();
		 document.forms[0].submit();
		 
		//}
	 
}

function submitToView()
{	
	
	 
	 var arrPrimarykey=getPrimaryKeyFromListPage();
	 
	 if(arrPrimarykey.length==0){
			alert("Please select a record!")
			return;
		}
		else if(arrPrimarykey.length>1){
			alert("Please select only 1 record to modify!")
			return;
		}
		else if(arrPrimarykey.length==1){
	 
	 
	 
	 var pk=arrPrimarykey[0];
	
	 $("#primaryKeys").val(pk);
	 //alert("pkkkls"+ $("#primaryKeys").val());
		var listJson= JSON.parse($('#spanConfigJson').html());
		var buttonJson=null;
		// getting buttonobj from json whose onclick function is listPageViewRecord
		$.each(listJson["buttons"],function(key,vobj){
			if(vobj["onClickFunction"]=="submitToView()"){
				buttonJson=vobj;
			}
		});
		
		var masterkey=buttonJson["masterkey"];
		//var initmode=buttonJson["MODIFY"];
		
		 $('#masterKey').val(masterkey);	 
		 $('#initMode').val('VIEW');	 
		 $('#hmode').val("CallMasterPage");
		 document.forms[0].submit();
		 
		}
	 
}

function showAndHideFilters(){
	if($('.filterHideShow').hasClass('hideData')){
		$('.filterHideShow').removeClass('hideData');
		//$('#filterButton').html("Hide Filters");
	}
	else{
		$('.filterHideShow').addClass('hideData');
		//$('#filterButton').html("Show Filters");
	}
	
	
	
	
}

function redirectToList(masterKey){
	
	 /*var go_to_url = "/eUpkaran/EUpkaranMasterACTION?hmode=CallMasterPage&masterkey="+masterKey;
	      
	      //this will redirect us in same window
	      document.location.href = go_to_url;*/
	      submitFormMaster(masterKey,"ADD");
	
}
function checkUncheckAll(objCheckAll){
	var tableId='LISTPAGE_TBL_LISTING';
	//alert($('[name="pk"]').length);
	
	if(objCheckAll.checked){
		$('[name="pk"]').attr("checked",true);
		$('#'+tableId +'tbody tr').addClass('selected');
		$('.selectbtn').show();
		$('.singleSelect').hide();
	}
	else{
		$('[name="pk"]').attr("checked",false);	
		$('#'+tableId +'tbody tr').removeClass('selected');
		$('.selectbtn').hide();
	}
	
	
	/*$('#'+tableConfigJson["tableId"]+' tbody').on('click', 'input[type="checkbox"]', function(e){
	      var $row = $(this).closest('tr');
		////alert(this.checked);
	      if(this.checked){
	         $row.addClass('selected');
	      } else {
	         $row.removeClass('selected');
	      }
	      var selectedRowCount=$('.selected').length;
	      if(selectedRowCount==0)
	    	  $('.selectbtn').hide();
	      else if(selectedRowCount==1)
	    	  $('.selectbtn').show();
	      else if(selectedRowCount>1)
	    	  $('.singleSelect').hide();
	    	  
	      e.stopPropagation();
	   });
	   
	   $('#'+tableConfigJson["tableId"]+' tbody').on('click', 'tr', function(e){
		  
		   $(this).find('[name="pk"]').trigger('click');
	   });*/
	
	
}


function showHideFilters(containerId,status){
	if(status=="0"){
		$('#'+containerId+"_btnFilterMinus").addClass("hideData");
		$('#'+containerId+"_btnFilterPlus").removeClass("hideData");
		$('#'+containerId+"_divTableFilter").addClass("hideData");
	}
	else{
		$('#'+containerId+"_btnFilterMinus").removeClass("hideData");
		$('#'+containerId+"_btnFilterPlus").addClass("hideData");
		$('#'+containerId+"_divTableFilter").removeClass("hideData");
	}
}

function  entryFormHeading(updateStr){
	var listPageHeading=$('#listPageHeading').val();
	if(updateStr!=undefined)
		listPageHeading=listPageHeading+ " >> "+ updateStr;
	$('#entryFormTitle').html(listPageHeading).attr("data-langtag",listPageHeading);
}

function readOnlyDataDisplay(configJson,dataJson){
	//alert(JSON.stringify(dataJson));
	
	var jsonData=dataJson["data"];
	//alert(dataStr);
	var html="";
	$('#gblpk').val("");
	var allPK="";
	var isTablularView=configJson["isTablularView"];
	var scrollHeight='';
	var scrollAfterRecordNo=configJson["scrollAfterRecordNo"];
	var scollableClass="";
	if(configJson["isScrollableDiv"]!=undefined && configJson["isScrollableDiv"]=="Yes"){
			
		scrollHeight="height:"+(configJson["scrollHeight"]!=undefined?configJson["scrollHeight"]:'200px')+";";
		
					
		scollableClass="table-wrapper-scroll-y my-custom-scrollbar";
	}
	
		
		//alert(dataJson["dataValue"]);
	if(jsonData==undefined || jsonData.length==0){
		$('#'+configJson["containerdivId"]).html("<div class='listPageMsg'>No Details Available</div>");
	}
	else{
		if(isTablularView ==undefined){
			if(jsonData.length>1){
				isTablularView="Yes";
			}
			else{
				isTablularView="No";
			}
		}
		//alert(isTablularView);
		if(isTablularView=="Yes"){
			if(scrollAfterRecordNo!=undefined && dataJson["dataValue"].length< scrollAfterRecordNo){
				scollableClass="";
				scrollHeight="";
			}
			
			
			var width="";
			var noOfColumn=0;
			
			html="<div class='row no-more-tables "+scollableClass+" ' style= '"+scrollHeight+"'><table class='table table-hover' id='"+configJson["containerdivId"]+"_table'></div>";
			html+="<thead>";
			html+="<tr class='tableHeading'>";
			/*var tableColWidth=configJson["tableColWidthinPercentage"];
			var  colCommonWidth=100/dataJson["dataHeading"].length;
			if(tableColWidth==undefined){
				tableColWidth= new Array();
				for(var a=0;a<dataJson["dataHeading"].length;a++){
					tableColWidth.push(colCommonWidth+"%");
				}				
			}
			else if(tableColWidth.length<dataJson["dataHeading"].length){
				var len=tableColWidth.length
				for(var a=len;a<dataJson["dataHeading"].length;a++){
					tableColWidth.push(colCommonWidth+"%");
				}
			}*/
			
			$.each(jsonData[0], function(key, val){
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
			
			/*$.each(dataJson["dataHeading"],function(indx,heading){
				if(heading.toUpperCase()!="PKCOLUMN"){
					html+="<th style='width:"+tableColWidth[indx]+";'>"+heading+"</th>";
				}
			});*/
			
			
			html+="</tr>";
			html+="</thead>";
			html+="<tbody>";
			html+="</tbody>";
			html+="</table>";
			//alert(html);
			$('#'+configJson["containerdivId"]).html(html);
			
			
			 if(noOfColumn>1){
			 width= 100/noOfColumn;
		 }		 
		 $('.colHeading').css({"width":width+"%"});
		 
		 
		 $.each(jsonData, function(indx, rowJson){
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
			 
			 html+="</tr>";
			 
			 /*html+="<tr class='bg-light' style='display:none;' id='traction_"+indx+"'><td colspan='"+(noOfColumn+1)+"' style='text-align:right'>"+mybutton+"</td></tr>";*/
			// alert(html)
			 $('#'+configJson["containerdivId"] +"_table tbody").append(html);
			 
		 });
		 
		 
		
			/*$.each(dataJson["dataValue"],function(indx,vArr){
				html="<tr>";
				$.each(dataJson["dataHeading"],function(indx,heading){
					if(heading.toUpperCase()=="PKCOLUMN")
						allPK+=vArr[indx]+",";// accumulating all primary keys				
					else{
						html+="<td data-title='"+heading+"'>"+vArr[indx]+"</td>";	
					}				
				});
				html+="</tr>";
				$('#'+configJson["containerdivId"] +"_table tbody").append(html);
			});
			if(allPK!="")
				$('#gblpk').val(allPK);*/
		}
		else {
			
			html="<div class='row form-group'>";
			//var dataValue= dataJson["dataValue"][0];
			/*var jsonData=dataJson["data"];*/
			//alert(JSON.stringify(jsonData));
			$.each(jsonData,function(indx, rowJson){
				//alert(heading);
				/*if(heading.toUpperCase()=="PKCOLUMN"){
					$('#gblpk').val(dataValue[indx])
				}
				else if(heading.indexOf(' ') <=0 && heading.indexOf('.') <=0 && heading.indexOf('(')<=0)
				{
					if($("[name="+heading+"]").length>0)
						return;
				}
				else{*/
					$.each(rowJson, function(key, val){
					html+="<div class='col-sm-3'>";
						html+="<label class='col-form-label col-form-label-sm col-sm-12' for='institutionName' data-langtag='"+key+"'>"+key+" :-</label>";
						html+="<label class='col-form-label col-form-label-sm col-sm-12 lbldata' style='font-weight:normal;' >"+val+"</label>";
					html+="</div>";
					});
				//}
			});		
			html+="</div>";
			
			$('#'+configJson["containerdivId"]).html(html);
			
		}
	}
	//convertAllLanguageTagsInDiv(configJson["containerdivId"]);
}

function removeItemOnce(arr, value) {
	  var index = arr.indexOf(value);
	  if (index > -1) {
	    arr.splice(index, 1);
	  }
	  return arr;
	}