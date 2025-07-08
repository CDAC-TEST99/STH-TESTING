

function createReportFilterPage(configJson){
	var initInputJson=null;
	try{
	//alert(JSON.stringify(configJson));

	var html="";
	var containerId=configJson["containerId"];
	
	var filterIds=new Array();
	
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
	html+="<div class='card-header formCardHeader'><h5 class='card-title float-left'  data-langtag='"+configJson["listPageHeading"]+"' >"+configJson["listPageHeading"]+" </h5><input type='hidden' name='listPageHeading' id='listPageHeading' value='"+configJson["listPageHeading"]+"'>";
	
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
		html+="<div class='row' style='border-bottom:1px solid rgba(0, 0, 0, 0.125);'>";
			html+="<div class='col-sm-12' >";
				html+="<a data-val='hide' class='btn btn-xs  bg-gradient-formButton "+hideFilterMinus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterMinus'  onclick=showHideReportFilters(\'"+containerId+"\',0)><i class='fas fa-minus-circle'></i>&nbsp;Hide Filters</a>";
				html+="<a data-val='show' class='btn btn-xs  bg-gradient-formButton "+hideFilterPlus+"' style='margin-top:0px!important; float:right;' id='"+containerId+"_btnFilterPlus'   onclick=showHideReportFilters(\'"+containerId+"\',1)><i class='fas fa-plus-circle'>&nbsp;Show Filters</i></a>";
				html+="<a class='btn btn-xs  bg-gradient-formButton hideData' style='margin-top:0px!important; float:right;margin-right: 2px;' id='"+containerId+"_btnFilterMore'   onclick=showMoreReportFilters(\'"+containerId+"\')><i class='fas fa-filter'>&nbsp;More Filters</i></a>&nbsp;";
			html+="</div>";
		html+="</div>";
		
		html+="<div class='row filterHideShow "+filterRowHide+"' id='"+containerId+"_divTableFilter' style='box-shadow: 0 0 1px rgba(0, 0, 0, 0.125), 0 1px 3px rgba(0, 0, 0, 0.2);'>";
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
				filter+="<label class='col-form-label col-form-label-sm' data-filterType='"+objFilter["filterType"]+"'  data-parentId='"+parentId+"' for='"+objFilter["filterId"]+"'   data-langtag='"+objFilter["filterLabel"]+"'>"+objFilter["filterLabel"]+"</label>";
				filter+="<select class='form-control form-control-sm filter select' "+validation+" id='"+objFilter["filterId"]+"'>";
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
		
		html+="<div class='col-lg-3'>";
		html+="<div class='form-group'>";
		html+="<label class='col-form-label col-form-label-sm' for='strReportFormat'   data-langtag='Report Format'>Report Format</label>";
		html+="<select class='form-control form-control-sm select' id='strReportFormat' name='strReportFormat'>";
		html+="<option value='pdf' selected>Pdf</option>";
		html+="<option value='html'>Html</option>";
		html+="<option value='xls'>Excel</option>";
		html+="</select>";
		html+="</div>";
		html+="</div>";
		
		if(moreFilters!=""){
			html+="<div class='modal' id='"+containerId+"_divTableMoreFilter' tabindex='-1' role='dialog'  aria-hidden='true' style='display:none;'>";
			html+="<div class='modal-dialog  modal-lg' role='document'>";
			html+="<div class='modal-content'>";
			html+="<div class='modal-body' id=''>";
			html+="<div class='card'>";
			html+="<div class='card-header formCardHeader'><h5 class='card-title float-left' data-langtag='"+configJson["listPageHeading"]+"'>"+configJson["listPageHeading"]+" >> More Filters</h5>";
			html+="<a class='btn  bg-gradient-formButton  btn-sm'  style='float: right;margin-top: -6px;margin-right: 2px;' onclick='closeReportFilterModal()'><i class='fas fa-times-circle'></i>&nbsp;<span data-langtag='Close'>Close</span></a>&nbsp;";
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
	
	
	
	
	
	html+="</div>";
	if(configJson["buttons"]!=undefined){
		
		
		html+="<div class='card-footer' style='text-align:center;'>";
		
		$.each(configJson["buttons"],function(indx,objBtnJson){
			
			var btnclass=objBtnJson["buttonClass"]!=undefined?"class='"+objBtnJson["buttonClass"]+"'":"";
			var buttonDisplayName=objBtnJson["buttonDisplayName"]!=undefined? "<span data-langtag='"+objBtnJson["buttonDisplayName"]+"'>"+objBtnJson["buttonDisplayName"]+ "</span>":"";
			var buttonIcon= objBtnJson["buttonIcon"]!=undefined?"<i class='"+objBtnJson["buttonIcon"]+"'></i>":"";
			var onClickFunction= objBtnJson["onClickFunction"]!=undefined?"onclick='"+objBtnJson["onClickFunction"]+"'":"";
			var queryKey=objBtnJson["queryKey"]!=undefined?"data-queryKey='"+objBtnJson["queryKey"]+"'":"";
			
			html+="<button "+btnclass+" id='"+objBtnJson["buttonName"]+"' "+onClickFunction+" "+queryKey+"  >"+buttonIcon+"&nbsp;"+buttonDisplayName+"</button>&nbsp;";
		
		});
		html+="</div>";
	}
	html+="</div>";
	$('#'+containerId).html(html);
	
	if($("#"+containerId+"_divTableMoreFilter").length>0){
		$("#"+containerId+"_btnFilterMore").removeClass("hideData");
	}
	
	
	
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
	        		 
		});
	
		$(".singleDatePicker").daterangepicker({
		    singleDatePicker: true,
		    showDropdowns: true,
		    locale: {
		          format: 'DD-MMM-YYYY'
		      }	   
		});
		$('.singleDatePicker').val('');	
		
		
		$( "button" ).click(function( event ) {
			event.preventDefault();
		});
		$('#'+containerId).find('.selectbtn').hide();
		initValidation(containerId);
		processAllReportFilterCombo(configJson["filters"]);
		
		
	}catch(err){
		 console.log("Problem in createReportFilterPage===" +  err.message)		
	}
}
function showMoreReportFilters(containerId){
	$("#"+containerId+"_divTableMoreFilter").modal('show');
}
function closeReportFilterModal(){
	$(".modal").modal('hide');
}
function populateReportFilterPageCombo(configJson, datastr){
	if(datastr!=""){
        var dataJson=JSON.parse(datastr);
        commonPopulateCombo(configJson, datastr);
        //alert(configJson["comboId"]+"===="+ $('#' + configJson["comboId"] + ' option:selected').val());
        var selectedVal=$('#' + configJson["comboId"] + ' option:selected').val();
        if(selectedVal!="" && selectedVal!="0"){
        	$('#' + configJson["comboId"] ).trigger('change');
        }
	}
}

function processAllReportFilterCombo(filtersJson) {
try{
	if(filtersJson!=undefined){
		$('.select').select2({width: '100%'});
			$.each(filtersJson,function(k,objFilter){
				if(objFilter["filterType"]=='combo'){
					if(objFilter["parentFilterId"]==undefined){
						var configJson=
						{
							queryKey:objFilter["queryKey"],
							callBackFunctionName:"populateReportFilterPageCombo",
							defaultOption:objFilter["defaultOption"],
							comboId:objFilter["filterId"]
						}
						getFilterData(configJson);
					}
				}
			});
			
		
		
		$('.filter').change(function(){
			var currentFilterJson=null;
			var childArray=new Array();
			var parentId=this.id;
			var parentValue=this.value;
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
					}
				}				
			});
			//alert(childArray);
			if(childArray.length>0){
				$.each(childArray,function(k,objFilter){
					//alert("child filterId==" +objFilter["filterId"]);
					//alert(JSON.stringify(objFilter));
					var objdefaultOption= objFilter["defaultOption"];
					var filterhtml="<option selected value='"+objdefaultOption["optionValue"]+"'>"+objdefaultOption["optionText"]+"</option>";
					$('#'+ objFilter["filterId"]).html(filterhtml);
					//alert(objFilter["filterId"]);
					var configJson={
							queryKey:objFilter["queryKey"],
							callBackFunctionName:"populateReportFilterPageCombo",						
							defaultOption:objFilter["defaultOption"],
							comboId:objFilter["filterId"],
							primaryKeys:[parentValue],
					}
					getFilterData(configJson);
				})
				
			}

		});
	
	}
}catch(err){
	 console.log("Problem in processAllReportFilterCombo===" +  err.message)
	
}
	
}
function populateReportFilterCombo(configJson,datastr){
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
		console.log("Problem in populateReportFilterCombo===" +  err.message)
	}
}
function generateReport(objbtn,listJson){
	
	try{
		var strReportFormat=$('#strReportFormat').val();
		var dataType="";
		var queryKey=$(objbtn).attr("data-queryKey");
		if(queryKey==undefined){
			alert("query-key not found");
			return
		}
		
		if(strReportFormat=="pdf")
			dataType="application/pdf";
		else if(strReportFormat=="html")
			dataType="text/html";
		else if(strReportFormat=="xls")
			dataType="application/vnd.ms-excel";
			
			
	var filterIds=listJson["filterIds"]!=undefined?listJson["filterIds"]:[];
	//alert("filterIds==" + filterIds);
	var pk=new Array();
	if(ValidateForAll(listJson["containerId"])==false)
		return;
	
	if(filterIds.length>0){
		for(var i=0;i<filterIds.length;i++){
			var objFilter= $('#'+filterIds[i]);
			//alert(filterIds[i] +"====" +objFilter.length);
			var filterType=objFilter.attr("data-filterType");
			var val=objFilter.val();
			if(filterType=="text" || filterType=="date"){
				//alert(objFilter.attr("id") + "===val="+ val + "===defaultValueIfEmpty==" + objFilter.attr("data-defaultValueIfEmpty"));
				if(val==undefined ||val.trim()==""){
					val=objFilter.attr("data-defaultValueIfEmpty");
				}
				
			}
			else if(filterType=="checkbox"){
				
				if($(objFilter).prop('checked')==false){
					val=objFilter.attr("data-defaultValueIfEmpty");
				}
				//alert(val);
			}
				
			
			//alert(objFilter.attr("id") + "===val="+ val );
			if(val==undefined ||val.trim()==""){
				return;
			}
			pk.push(val);
		}
	}
	//alert(JSON.stringify(data));
	
	$('#queryKey').val(queryKey);
	$('#primaryKeys').val(pk);
	$('#hmode').val("generateReport");
	document.forms[0].target = "_blank";
    document.forms[0].submit();
	
	
	
	
	}catch(err){
		console.log("Problem in generateReport===" +  err.message)
	}
	
}

function showHideReportFilters(containerId,status){
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
 


function getFilterData(configJson){
	 
	 var data={
			 hmode:"getFilterData",
			 queryKey:configJson["queryKey"],			
	 }
	 
	 if(configJson["primaryKeys"]!=undefined){
		 data.primaryKeys= configJson["primaryKeys"]
	 }
	 if(configJson["initMode"]!=undefined){
		 data.initMode= configJson["initMode"]
	 }
	var url= document.forms[0].action; 
	if(url==undefined){
		alert("Form url not found")
		return;
	}
	//alert(JSON.stringify(configJson))	
	 $.ajax({
		 	type: 'POST',
			url : url,
			data : data,
			dataType : "html",
			success : function(returnStr) {
				//alert(returnStr);
				if(configJson["callBackFunctionName"]!=undefined)
					eval(configJson["callBackFunctionName"])(configJson, returnStr);						
			},
			fail : function() {
				alert("error occured");
			}
		});	
}

function clearReportFilters(){
	document.forms[0].reset();
	$('.select').select2({width: '100%'});
		
}