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
	controllerUrl:""
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
var controllerUrl=null;
function createListPage(configJson){
	try{
	//alert(JSON.stringify(configJson));
		ajaxCalledOnChangeOfFilter=null;
		ajaxCalledOnChangeOfFilter= new Array();
	var html="";
	var containerId=configJson["containerId"];
	
	var filterIds=new Array();
	
	controllerUrl=configJson["controllerUrl"]==undefined?null:configJson["controllerUrl"];
	
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
	
	
	
	
	
	
	
	html+="<div class='card-header formCardHeader'>";
	html+="<h5 class='card-title float-left' data-langtag='"+configJson["listPageHeading"]+"' >"+configJson["listPageHeading"]+" >> List Page</h5>";
	
	
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
		html+="<div class='row' style='border-bottom:1px solid rgba(0, 0, 0, 0.125);display:none;'>";
			html+="<div class='col-sm-12' >";
				html+="<a data-val='hide' class='btn btn-xs  btn-info text-white "+hideFilterMinus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterMinus'  onclick=showHideFilters(\'"+containerId+"\',0)><i class='fas fa-minus-circle'></i>&nbsp;Hide Filters</a>";
				html+="<a data-val='show' class='btn btn-xs  btn-info text-white "+hideFilterPlus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterPlus'   onclick=showHideFilters(\'"+containerId+"\',1)><i class='fas fa-plus-circle'>&nbsp;Show Filters</i></a>";
				html+="<a class='btn btn-xs  btn-info text-white hideData' style='margin-top:0px!important; float:right;margin-right: 2px;' id='"+containerId+"_btnFilterMore'   onclick=showMoreFilters(\'"+containerId+"\')><i class='fas fa-filter'>&nbsp;More Filters</i></a>&nbsp;";
			html+="</div>";
		html+="</div>";
		
		html+="<div class='row filterHideShow mb-2 "+filterRowHide+"' id='"+containerId+"_divTableFilter' >";
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
	
	
	html+="</div>";
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
						var strJson="";
						if(objFilter["initializationVariableIds"]!=undefined){
							for(var i=0;i<objFilter["initializationVariableIds"].length;i++){
								var varId=objFilter["initializationVariableIds"][i];
								if($('#'+varId).val()!=null){
									strJson+="\""+varId+"\":\""+$('#'+varId).val()+"\",";									
								}
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
					
						if(strJson!=""){
							strJson=strJson.substr(0, strJson.length-1);
							strJson="{"+strJson+"}";
							//alert("processAllFilterCombo===" + strJson);
							configJson["inputData"]=JSON.parse(strJson);
						}
						//alert("inside processAllFilterCombo-- configJson---"+ JSON.stringify(configJson));
						
						configJson["controllerUrl"]= controllerUrl;
						callListPageService(configJson);
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
			var strJson="";
			var arrParentIds=objFilter["parentFilterId"].split(",");
			for(var x=0;x<arrParentIds.length;x++){
				var parentId=arrParentIds[x];
				if($('#'+parentId).length>0){
					var parentVal=$('#'+parentId).val();
					strJson+="\""+parentId+"\":\""+parentVal+"\",";						
				}
			}						
			
			if(objFilter["initializationVariableIds"]!=undefined){
				for(var i=0;i<objFilter["initializationVariableIds"].length;i++){
					var varId=objFilter["initializationVariableIds"][i];
					if($('#'+varId).val()!=undefined && $('#'+varId).val()==""){
						return;
					}
					strJson+="\""+varId+"\":\""+$('#'+varId).val()+"\",";					
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
					callOnLoad:callOnLoad
			}
			if(strJson!=""){
				strJson=strJson.substr(0, strJson.length-1);
				strJson="{"+strJson+"}";
				//alert("callOnFilterChange===" + strJson);
				configJson["inputData"]=JSON.parse(strJson);
			}
			
			configJson["controllerUrl"]= controllerUrl;
			callListPageService(configJson);
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
			callListPageService(configJson);
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
	var strJson=""
	var jsonForCookee={};

	if($('#'+listJson["containerId"]+"_divTableListing")!=undefined && $('#'+listJson["containerId"]+"_divTableListing").length>0){
		$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>Please select parameter option to continue..</div>");
	}
	if(ValidateForAll(listJson["containerId"])==false)
		return;
	
	if(listJson["listPageInitializationVariableIds"]!=undefined){
		for(var i=0;i<listJson["listPageInitializationVariableIds"].length;i++){
			var varId=listJson["listPageInitializationVariableIds"][i];			
			strJson+="\""+varId+"\":\""+$('#'+varId).val()+"\",";	
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
			strJson+="\""+$(objFilter).attr("id")+"\":\""+val+"\",";			
			
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
			listJson:listJson
		}
	
	if(strJson!=""){
		strJson=strJson.substr(0, strJson.length-1);
		strJson="{"+strJson+"}";
		configJson["inputData"]=JSON.parse(strJson);
	}
	
	configJson["controllerUrl"]= controllerUrl;
	callListPageService(configJson);
	}catch(err){
		console.log("Problem in getListPage===" +  err.message)
	}
	
}
function populateListPage(configJson,dataJson){
	try{
	//	alert(JSON.stringify(dataJson));
	
		//alert("listpage called");
		var listJson=configJson["listJson"];
		var record=listJson["noOfRecordPerPage"]!=undefined?listJson["noOfRecordPerPage"]:"10";
		if(dataJson["message"]!=undefined && dataJson["message"].indexOf("ERROR")>=0){
			$('#'+listJson["containerId"]+"_divTableListing").html("<div class='listPageMsg'>"+dataJson["msg"]+"</div>");
			return;
		}
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
		}
		
		getTableListing(tableConfigJson,dataJson);	
	}catch(err){
		alert("Problem in populateListPage===" +  err.message)
	}
}


function getTableListing(tableConfigJson,dataJson){
try{
	
	//alert(JSON.stringify(dataJson));
	
	if(dataJson["data"]==undefined || dataJson["data"].length==0){
		$('#'+tableConfigJson["divId"]).html("<div class='alert alert-danger text-center' style='width:100%' role='alert'>No Data Found !</div>");
		return;
	}
	
	
	var html="<table id='"+tableConfigJson["tableId"]+"'  class='table table-bordered table-striped tbl-listing' width='100%' style='width:100%;' cellspacing='0'><thead><tr class='listPageHeader'>"; 
	
	var firstDataJson= dataJson["data"][0];
	var heading = new Array();
	var data = new Array();
	
	
	for(var k in firstDataJson) 
		heading.push(k);
	
	//alert(heading);
	
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
		if(tableConfigJson["isCheckBoxRequired"]){	
			if(k==0 || val.toUpperCase()=="PKCOLUMN"){
				val="<input type='checkbox' onclick='checkUncheckAll(this)'>";
				datalangTag="";
				currColumnWidth='5%';
				textAllign="text-align:center;"
				//alert("inside if")
			}
		}
		
		if( (tableConfigJson["isCheckBoxRequired"] && k==0) || k>0)
		html+="<th  style='width:"+currColumnWidth+";"+textAllign+";' "+datalangTag+" >"+val+"</th>";
		
	});	
	html+="</tr></thead><tbody></tbody></table>";
	
	$('#'+tableConfigJson["divId"]).html(html);
	$.each(dataJson["data"],function(indx, jsonobj){
		var trhtml="<tr>";
		var x=0;
//		alert("jsonobj::"+JSON.stringify(jsonobj));
		for(var k in jsonobj){
			if(x==0){
				if(tableConfigJson["isCheckBoxRequired"])
					trhtml+="<td><div style='width:100%;text-align:center'><input type='checkbox' name='pk' class='check' value='"+jsonobj[k]+"' ></div></td>";
				else
					trhtml+="<input type='hidden' name='pk' value='"+jsonobj[k]+"' >";
			}
			else{
				trhtml+="<td>"+ jsonobj[k]+"</td>";
			}			
			x++;
		} 	
		trhtml+="</tr>";
		
		$("#" +tableConfigJson["tableId"] + " tbody").append(trhtml);
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
		//alert(tableConfigJson["userDefinedFunctionOnRowSelect"]);
		if(tableConfigJson["userDefinedFunctionOnRowSelect"]!=null && tableConfigJson["userDefinedFunctionOnRowSelect"]!=undefined){
			eval(tableConfigJson["userDefinedFunctionOnRowSelect"]);
			//alert("called==" + tableConfigJson["userDefinedFunctionOnRowSelect"]);
		}
		e.stopPropagation();
	});
	
	$('#'+tableConfigJson["tableId"]+' tbody').on('click', 'tr', function(e){
		
		//alert("here")
		//alert("here>>" + $(this).closest('tr').find('[data-title="CR No."]').text());
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

function getPrimaryKeyFromListPage(index){
	var primarykey="";

	if(document.getElementsByName("pk").length>0){
			primarykey=document.getElementsByName("pk")[index].value;
	}	
	else{		
		return 0;
	}
	
	return primarykey;
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
		configJson["controllerUrl"]= controllerUrl;
		callListPageService(configJson);
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
		configJson["controllerUrl"]= controllerUrl;
		callListPageService(configJson);
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
/*
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
	configJson["controllerUrl"]= controllerUrl;
	callListPageService(configJson);
		
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
		configJson["controllerUrl"]= controllerUrl;
		callListPageService(configJson);
		entryFormHeading("Modify Page");
	}	
}
*/

function backToListPage(){
	$('#LISTPAGE').removeClass('hideData');
	$('#ENTRYFORM').addClass('hideData');	
	getListPage();	
}

function submittonew()
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
			if(vobj["onClickFunction"]=="submittonew()"){
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
		 
		}
	 
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

function readOnlyDataDisplay(configJson,dataStr){
	var dataJson=JSON.parse(dataStr);
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
	if(dataJson["dataValue"]==undefined || dataJson["dataValue"].length==0){
		$('#'+configJson["containerdivId"]).html("<div class='listPageMsg'>No Details Available</div>");
	}
	else{
		if(isTablularView ==undefined){
			if(dataJson["dataValue"].length>1){
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
			
			html="<div class='row no-more-tables "+scollableClass+" ' style= '"+scrollHeight+"'><table class='table table-hover' id='"+configJson["containerdivId"]+"_table'></div>";
			html+="<thead>";
			html+="<tr class='listHeader'>";
			var tableColWidth=configJson["tableColWidthinPercentage"];
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
			}
			
			$.each(dataJson["dataHeading"],function(indx,heading){
				if(heading.toUpperCase()!="PKCOLUMN"){
					html+="<th style='width:"+tableColWidth[indx]+";'>"+heading+"</th>";
				}
			});
			html+="</tr>";
			html+="</thead>";
			html+="<tbody>";
			html+="</tbody>";
			html+="</table>";
			//alert(html);
			$('#'+configJson["containerdivId"]).html(html);
		
			$.each(dataJson["dataValue"],function(indx,vArr){
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
				$('#gblpk').val(allPK);
		}
		else {
			
			html="<div class='row form-group'>";
			var dataValue= dataJson["dataValue"][0];
			//alert(JSON.stringify(dataValue));
			$.each(dataJson["dataHeading"],function(indx,heading){
				//alert(heading);
				if(heading.toUpperCase()=="PKCOLUMN"){
					$('#gblpk').val(dataValue[indx])
				}
				else if(heading.indexOf(' ') <=0 && heading.indexOf('.') <=0 && heading.indexOf('(')<=0)
				{
					if($("[name="+heading+"]").length>0)
						return;
				}
				else{
					
					html+="<div class='col-sm-3'>";
						html+="<label class='col-form-label col-form-label-sm col-sm-12' for='institutionName' data-langtag='"+heading+"'>"+heading+" :-</label>";
						html+="<label class='col-form-label col-form-label-sm col-sm-12 lbldata' style='font-weight:normal;' >"+dataValue[indx]+"</label>";
					html+="</div>";
				}
			});		
			html+="</div>";
			
			$('#'+configJson["containerdivId"]).html(html);
			
		}
	}
	convertAllLanguageTagsInDiv(configJson["containerdivId"]);
}

function removeItemOnce(arr, value) {
	  var index = arr.indexOf(value);
	  if (index > -1) {
	    arr.splice(index, 1);
	  }
	  return arr;
	}


function callListPageService(configJson){
	// alert(JSON.stringify(configJson));
	 var data={			
			 serviceName:configJson["serviceName"],	
			 isGlobal: "1"
	 }
	 if(configJson["inputData"]!=undefined){
		 data.inputData=JSON.stringify(configJson["inputData"])
		// alert("JSON.stringify(data.inputData)::"+JSON.stringify(data.inputData));
	 }
	 var url= configJson["controllerUrl"]!=undefined  &&  configJson["controllerUrl"]!= null ?configJson["controllerUrl"]: document.forms[0].action;
		// alert(url);
	if(url==undefined){
		alert("Form url not found")
		return;
	}
	//alert(url);	
	 $.ajax({
		 	type: 'POST',
			url : url,
			data : data,
			dataType : "json",
			success : function(returnStr) {
				//hidePreloader();
				eval(configJson["callBackFunctionName"])(configJson, returnStr);
			},
			error: function (jqXHR, exception) {
				  console.log(jqXHR);
				  console.log(exception);
				
		        var msg = '';
		        if (jqXHR.status === 0) {
		            msg = 'Not connect.\n Verify Network.';
		        } else if (jqXHR.status == 404) {
		            msg = 'Requested page not found. [404]';
		        } else if (jqXHR.status == 500) {
		            msg = 'Internal Server Error [500].';
		        } else if (exception === 'parsererror') {
		            msg = 'Requested JSON parse failed.';
		        } else if (exception === 'timeout') {
		            msg = 'Time out error.';
		        } else if (exception === 'abort') {
		            msg = 'Ajax request aborted.';
		        } else {
		            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		        }
		       // hidePreloader();
		        console.log(msg);
		        //alert("Some Problem Occured");
		    },
			fail : function() {
				//hidePreloader();
				alert("error occured");
			}
		});
	
}