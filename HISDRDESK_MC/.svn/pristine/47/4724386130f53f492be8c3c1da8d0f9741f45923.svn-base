var drugInstructionTags = [
    "After Food",
    "Before Food",
    "After Breakfast",
    "Before Breakfast",
    "Bed Rest",
    "Local application",
    "30 minutes before food",
	"20 minutes before food",
	"Along with food",
	"May cause drowsiness",
	"Empty Stomach",
	"Topical Use"
	
];

$(document).ready(function(){
	
	localStorage.removeItem("currentPatientDtl");	
	
	if($('.prescWithoutLst').is(':checked')) 
	$('.prescriptionColBtn').eq(0).click();
	
	/*$('#lmp').datepicker({
		 uiLibrary: 'bootstrap',
	     format: 'dd-mmm-yyyy',
	     container: "#VitalIDModal",
	     maxDate: function() {
	         var date = new Date();
	         date.setDate(date.getDate());
	         return new Date(date.getFullYear(), date.getMonth(), date.getDate());
	     },
	     icons: {
	         rightIcon: '<span class="glyphicon glyphicon-calendar"></span>'
	     },
	     showRightIcon: false,		     
	     change: function (e) {
	    	 //sessionStorage.setItem('selectedDate',$('#lmp').val().toString());
	    	 
	    	 var mydate = new Date($('#lmp').val());
	    	
	    	 
	    	 var numberOfDaysToAdd = 280;// 40 weeks
	    	 var result = mydate.setDate(mydate.getDate() + numberOfDaysToAdd);
	    	 var edodDt = ((new Date(result))+"").trim();
	    	 var arrEdod= edodDt.split(" ");		    	 
	    	 $('#edod').val(arrEdod[2]+"-"+arrEdod[1] + "-"+ arrEdod[3])
	    	 
	    	 
	    	 
	     }
	 });
	
	 
 	$('#edod').datepicker({
		 uiLibrary: 'bootstrap',
	     format: 'dd-mmm-yyyy',
	     container: "#VitalIDModal",
	     minDate: function() {
	         var date = new Date();
	         date.setDate(date.getDate());
	         return new Date(date.getFullYear(), date.getMonth(), date.getDate());
	     },
	     icons: {
	         rightIcon: '<span class="glyphicon glyphicon-calendar"></span>'
	     },
	     showRightIcon: false,		     
	     change: function (e) {
	    	 //sessionStorage.setItem('selectedDate',$('#listDateFilter').val().toString());
	     }
	 });*/
	 
	 configureDatePicker()
	 	if($('#isScriber').val()!="1"){
	 		populateUnregisteredDrugList();
	 		
	 		if($('#deptUnitName').val()!=""){
	 			var status=$('#deptUnitName').val().split("#")[3];
	 			//alert($('#currentDate').val()+ " == "+ $('#listDateFilter').val())
	 			//alert($('#currentDate').val()==$('#listDateFilter').val())
	 			
	 			SendCallToDisplayBoard();
	 			
	 			if($('#currentDate').val()==$('#listDateFilter').val()){				
	 				hideUnhideOnCallStatus(status);
	 			}
	 			else{
	 				$('.btnCallStatus').hide();
	 			}
	 		}
	 		
	 	}
	 	
	
});


function populateteplatesInSession(){
	//alert("populateteplatesInSession");
	$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=populateteplatesInSession',
		dataType: "text/html",
		type: "GET",
		success:function(result){ 
		//alert("ok");
		}
	});
}

function populateteplatesInSession(){
	//alert("populateteplatesInSession");
	$.ajax({url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=populateteplatesInSession',
		dataType: "text/html",
		type: "GET",
		success:function(result){ 
		//alert("ok");
		}
	});
}

function onChangePrescWithoutLst(e){
	$('input[name=prescMode][value=2]').attr('checked','true'); 
	// $('input[name=prescMode]').val(2); 
	if($('input[name=prescMode]:checked').val() == 2) 
	{
		if($('.prescWithoutLst').is(':checked')) 
			$('.prescriptionColBtn').eq(0).click(); 
		else
			$('.rightPanelClose').click();
	}
}

function getDeltList(e)
 {
	//alert('1');
	//alert(e.value);
	$(".loader").css("display","");
	 $('#tree').append('<font id="treeMsgP" style="color:#1e87f0"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i> Loading prescription....</font>'); // Do not comment !!! Not In use. 
	document.forms[0].strHiddenDeptCode.value=document.forms[0].deptUnitName.value ;
	//sessionStorage.setItem('deptUnitName',document.forms[0].deptUnitName.value);
	document.forms[0].hmode.value="NEW";
	document.forms[0].submit();
 }

 function getPatientData(e)
 {
	//alert('1');
	//alert(e.value); 
	 $(".loader").css("display","");
	 $('#tree').append('<font id="treeMsgP" style="color:#1e87f0"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i> Loading prescription....</font>'); // Do not comment !!! Not In use. 
		
	 if(document.forms[0].deptUnitName.value == '0#0#0')
		 document.forms[0].hmode.value="unspecified"; 
	 else
	document.forms[0].hmode.value="NEW";
	document.forms[0].submit();
 }
 
 function refreshPatientData(e)
 {
	//alert('1');
	//alert(e.value); 
	 $(".loader").css("display","");
	 $('#tree').append('<font id="treeMsgP" style="color:#1e87f0"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i> Loading prescription....</font>'); // Do not comment !!! Not In use. 
		
	 if(document.forms[0].deptUnitName.value == '0#0#0')
		 document.forms[0].hmode.value="unspecified"; 
	 else
		 document.forms[0].hmode.value="NEW";
	document.forms[0].submit();
 }

 function hideOverlay(){
	$('.overlay').toggleClass('overlayHide');
	$('#hamburger').toggleClass('hamburgerWithoutOverlay');
 }

 function resizeText(multiplier) {
  if (document.body.style.fontSize == "") {
    document.body.style.fontSize = "0.8em";
  }
  document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (multiplier * 0.2) + "em";
}

 $(document).ready(function(){
		$('#patSideListBtn1').click(function(){
			//	var waitingPatCount = 0;
				//var attendedPatCount = 0;
				$('#waitingPatList1').empty();
				$('#visitedPatList1').empty();
				$('#patSideListId1').toggle("slow","swing"); 
				/* $('.patCatHeader .badge').text($('.totalPatCount').text()-$('.visitedPatCount').text()); */
				//$('#patSideListId > legend >span').text($('.totalPatCount').text());
		});
		
		$('.closee-consultancy').click(function(){
			//	var waitingPatCount = 0;
				//var attendedPatCount = 0;
				$('#waitingPatList1').empty();
				$('#visitedPatList1').empty();
				$('#patSideListId1').toggle("slow","swing"); 
				/* $('.patCatHeader .badge').text($('.totalPatCount').text()-$('.visitedPatCount').text()); */
				//$('#patSideListId > legend >span').text($('.totalPatCount').text());
		});
		
		
		
		

		$('#patSideListBtn2').click(function(){
			//	var waitingPatCount = 0;
				//var attendedPatCount = 0;
				//$('#waitingPatList2').empty();
				//$('#visitedPatList2').empty();
				$('#patSideListId2').toggle("slow","swing"); 
				/* $('.patCatHeader .badge').text($('.totalPatCount').text()-$('.visitedPatCount').text()); */
				//$('#patSideListId > legend >span').text($('.totalPatCount').text());
		});
		
		$('.closee-consultancy1').click(function(){
			//	var waitingPatCount = 0;
				//var attendedPatCount = 0;
				//$('#waitingPatList2').empty();
				//$('#visitedPatList2').empty();
				$('#patSideListId2').toggle("slow","swing"); 
				/* $('.patCatHeader .badge').text($('.totalPatCount').text()-$('.visitedPatCount').text()); */
				//$('#patSideListId > legend >span').text($('.totalPatCount').text());
		});
		
		
		
		
		
 
		
		
 });
 
 
$(document).ready(function(){
	
	$('#patSideListBtn').click(function(){
			var waitingPatCount = 0;
			var attendedPatCount = 0;
			$('#waitingPatList').empty();
			$('#visitedPatList').empty();
			$('#patSideListId').toggle("slow","swing"); 
			/* $('.patCatHeader .badge').text($('.totalPatCount').text()-$('.visitedPatCount').text()); */
			$('#patSideListId > legend >span').text($('.totalPatCount').text());
			$('.patientListBlock').each(function(){
			    if($(this).hasClass('isAttended_1'))
				{
			    	waitingPatCount++;
					$('#waitingPatList').append('<li><img class="img-circle img-responsive" src="/HISDRDESK_MC/new_opd/img/'+($(this).find('.patGenAgeCat').text().split('/')[0]=='M' ? 'img_avatar.png' : 'img_avatar3.png')+'" style="margin: 3% 2%;float:left; width: 30px; min-width: 20px; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.2); border: 1px solid #fff;"><h5 style="padding: 0px; margin:0px;">'+$(this).find('.patName').text()+'</h5><p>'+$(this).find('.patCrNo').text()+'</p></li>'); /* 0px 5px 25px 0px rgba(0,0,0,0.2) */
				}
			    else
				{
			    	attendedPatCount++;
					$('#visitedPatList').append('<li><img class="img-circle img-responsive" src="/HISDRDESK_MC/new_opd/img/'+($(this).find('.patGenAgeCat').text().split('/')[0]=='M' ? 'img_avatar.png' : 'img_avatar3.png')+'" style="margin: 3% 2%;float:left; width: 30px; min-width: 20px; box-shadow: 0px 0px 0px 0px rgba(0,0,0,0.2); border: 1px solid #fff;"><h5 style="padding: 0px; margin:0px;">'+$(this).find('.patName').text()+'</h5><p>'+$(this).find('.patCrNo').text()+'</p></li>'); /* 0px 5px 25px 0px rgba(0,0,0,0.2) */
				} 
		});


		$('#waitingPatList li').click(function(){ 
			var patCrNo = $(this).find('p').text();
			 count=0;
			    $('.patientListBlock').each(function(index){
			      //console.log('Count:::'+count+':::: Cr :::'+patCrNo);
			      if($(this).is(':contains('+patCrNo+')'))
			      { hidePrescription(this);
				     $(this).find('.prescriptionColBtn').click();
				     $('#patSideListId').hide(); 
			        return false; }
			      else
			        count++;
			    });
			});
	  	$('#visitedPatList li').click(function(){ 
			var patCrNo = $(this).find('p').text();
			 count=0;
			    $('.patientListBlock').each(function(index){
			      //console.log('Count:::'+count+':::: Cr :::'+patCrNo);
			      if($(this).is(':contains('+patCrNo+')'))
			      { hidePrescription(this);
				     $(this).find('.prescriptionColBtn').click();
				     $('#patSideListId').hide(); 
			        return false; }
			      else
			        count++;
			    });
			}); 
		$('.waitingPatHeader > span').text(waitingPatCount);
		$('.visitedPatHeader > span').text(attendedPatCount);
		
		$('.showPatientDtl').not('#patSideListId').click(function(){
			$('#patSideListId').hide(); 
			});
	});

	 
	$('.rightPanelClose').click(function(){
		$('#patSideListId').hide(); 
		});
});


 $(document).ready(function() {
	 
       /* $('#example').DataTable();*/
       var api = null ;
       
      $('#example').addClass( 'nowrap' );
  
      var table = $('#example').DataTable({
          "processing": true,
          responsive: true,
		  ordering: false,
          columnDefs: [
              { targets: [-1, -3], className: 'dt-body-right' } ,
              { responsivePriority: 1, targets: 0 },
              { responsivePriority: 2, targets: -3 },
              { responsivePriority: 3, targets: -2 }
            ] ,
        
			"paging": false,

         /*  "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],*/
          "initComplete": function () {
             api = this.api();
             $('#mainDeskLoadingMsgDiv').hide();
          }        
        });
  /*    if($('#strRailTailFlgId').val() == '1'){
    	  table.columns([8]).visible(false);
      }else{
    	  //console.log('LLLLLLLLLLLLL  ')
    	  table.column(7).visible(false);
      }
      table.page.len( 50 ).draw();
  */        
      
      /*$('.prescriptionColBtn').on( 'click', function () { 
          table.page.len( -1 ).draw();
      } );
       
      $('.rightPanelClose').on( 'click', function () {
          table.page.len( 50 ).draw();
      } );

      $('.prescriptionColBtn').on( 'click', function () {
    	  api.search('').draw();
      } );*/

     
      
    } );


 $(document).ready(function(){
 	$('.patDtlMdlTrgr').click(function(){
      var patName = $(this).find('.patName').text();
      var patCrNo = $(this).parent().parent().find('.patCrNo').text();
      $('#patientDtlModal').find('.patName').text(patName);
      $('#patientDtlModal').find('.patCrNo').text(patCrNo);
    });
 });


$(document).ready(function(){
	//localStorage.setItem("flag","0");
	$("#printPrescriptionMainDeskModal").on('hide.bs.modal', function () {
		$('#printPrescFrameOnMainDeskId').remove();
		localStorage.setItem("flag","0");
		localStorage.removeItem("ajxRqstPatDtl");
	 });  
});


function printPrescriptionMainDeskFun(e){ 
  	if($('#printPrescFrameOnMainDeskId'))
	  	$('#printPrescFrameOnMainDeskId').remove();
	var crNo = $(e).closest('.patientListBlock').find('.patCrNo').text();
	var episodeCode = $(e).closest('.patientListBlock').find('.patEpisodeCode').text();
	var visitNo = $(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text();
	var seatId = $(e).closest('.patientListBlock').find('.patSeatId').text();
	var visitDate = $(e).closest('.patientListBlock').find('.patLastVisitDate').text();
	var hospCode = $(e).closest('.patientListBlock').find('.patHospitalCode').text(); 
	localStorage.setItem("ajxRqstPatDtl",crNo+'#'+episodeCode+'#'+visitNo+'#'+seatId+'#'+(visitDate==''?$("#listDateFilter").val():visitDate.split(" ")[0])+'#'+hospCode);
	localStorage.setItem("flag","2");
	$('#printPrescriptionMainDeskModal .modal-body').prepend('<iframe id="printPrescFrameOnMainDeskId" style="width:100%;height:80vh;" src="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=PRINTPRESC"></iframe>');
	$('#printPrescriptionMainDeskModal').modal('show'); 
} 


$(document).ready(function(){
	$('.emrLink').click(function(e){
		var patName = $(this).parent().parent().find('.patName').text();
	    var patCrNo = $(this).parent().parent().find('.patCrNo').text();  
	    $('.emrPatName').html(patName);
	    $('.emrPatCrNo').html(patCrNo);
	    $('#emrModalTriggerBtn').click();
	});
});



$('#jstree_demo_div').jstree();
$('#jstree_demo_div').on("changed.jstree", function (e, data) {
	  //console.log(data.selected);
	});  
$('#jstree_demo_div').on('ready.jstree', function() {
    $("#jstree_demo_div").jstree("open_all");          
});

  $('#jstree_demo').jstree({
    "core" : {
      "animation" : 0,
      "check_callback" : true,
      "themes" : { "stripes" : true },
      'data' : {
        'url' : function (node) {
          return node.id === '#' ?
            'ajax_demo_roots.json' : 'ajax_demo_children.json';
        },
        'data' : function (node) {
          return { 'id' : node.id };
        }
      }
    },
    "types" : {
      "#" : {
        "max_children" : 1,
        "max_depth" : 4,
        "valid_children" : ["root"]
      },
      "root" : {
        "icon" : "/static/3.3.6/assets/images/tree_icon.png",
        "valid_children" : ["default"]
      },
      "default" : {
        "valid_children" : ["default","file"]
      },
      "file" : {
        "icon" : "glyphicon glyphicon-file",
        "valid_children" : []
      }
    },
    "plugins" : [
      "contextmenu", "dnd", "search",
      "state", "types", "wholerow"
    ]
  });


 $(document).ready(function(){
	$('body').mousemove(function(event){
		var strmsgX =  event.pageX;   
		/*if(strmsgX<=0)
		$('.hamburger').click();*/
	});
});

function collapsePanel(e){
	$(e).parent().css('display','none');
	$(e).closest('.patientListBlock').children('.leftPanel').removeClass('col-sm-6').toggleClass('col-sm-12');
	$('body').append("<button id='rightNavBtn1' class='btn btn-info btn-sm' type='button' onclick='showPanel(this,event)' style='position: fixed; right: -10px; top:15vh;'>Right Panel</button>");
}
function showPanel(e){
	$('.rightPanel').css('display','');
	$('.leftPanel').removeClass('col-sm-12').toggleClass('col-sm-6');
	$('#rightNavBtn1').remove();
}


$(document).ready(function () {
  var trigger = $('.hamburger'),
      overlay = $('.overlay'),
     isClosed = false;

    trigger.click(function () {
      hamburger_cross();      
      $("body").click(function(){

      });
    });

function hamburger_cross() {
      if (isClosed == true) {          
        overlay.hide();
        trigger.removeClass('is-open');
        trigger.addClass('is-closed');
        isClosed = false;
      } else {   
      	overlay.removeClass('overlayHide');
        overlay.show();
        trigger.removeClass('hamburgerWithoutOverlay');
        trigger.removeClass('is-closed');
        trigger.addClass('is-open');
        isClosed = true;
      }
} 

function sideNavClose() {
        $('#wrapper').toggleClass('toggled');
        hamburger_cross();
} 

$('[data-toggle="offcanvas"]').click(function () {
      $('#wrapper').toggleClass('toggled');
  }); 
  $('.overlay').click(function(){
  	sideNavClose();
  });

  $('.sidebar-nav li:not(:first-child)').click(function(){
  	sideNavClose();
  }); 

});











	var count = 0;
	var saveCount = 0;
	var totalCount = 0;
	var str = '<div class="showPatientDtl"> </div>';
	var str1 = '<div class="showPatientDtl" id="showPatientDtlTileID" style="display:none"> </div>';
	
	
	
	$(document).ready(function(){    
			   $('.patientListBlock .templatePrescriptionBtn').click(function(){
			   		inTilePresc(this,'','','','');
			   });  
	});
	function inTilePresc(e,patName,patCrNo,episodeCode,patGenAgeCat,patCompleteGeneralDtl, patAdd, timeOfVisit){  
			   	  $(e).parent().parent().css('background-color','#f2f2f2');
			      $(e).parent().parent().css('box-shadow','0 0 4px 1px black');
			      $(e).parent().parent().css('margin-bottom','5px');
			     /* $(this).parent().parent().css('border-left','10px solid #91061D'); */
					var temp = $(e).parent().parent().parent().attr('clicked');
					if(temp == 0){
						var effect = function() {
						  return $('.showPatientDtl').remove();
						};   
						$.when( effect() ).done(function() {
						    var topY = $(e).offset(); 
						      $('.leftPanel').animate({
							        scrollTop: topY.top	}, 0);
							  }); 
			            $('.patientListBlock').attr('clicked','0');
			            $(e).parent().parent().parent().append(str1); 
			            $(e).parent().parent().parent().find('.showPatientDtl').load('/HISDRDESK_MC/new_opd/prescription.jsp', function(){
				      		$('#patNamePrescriptionPanel').text(patName);
				      		$('#patCrNoPrescriptionPanel').text(patCrNo);
				      		$('#patAdd').text(patAdd);
				      		$('#timeOfVisit').text(timeOfVisit);
				      		$('#patGenAgeCatPrescriptionPanel').text(patGenAgeCat);
				      		$('#patEpisodeCodePrescriptionPanel').text(episodeCode);
				      		$('input[name=patCompleteGeneralDtlPrescriptionPanel]').val(patCompleteGeneralDtl);
				      		$('input[name=patGeneralDtl]').val(patName+'#'+patCrNo+'#'+episodeCode+'#'+patGenAgeCat);
				      		/* alert('inTileFunc::'+episodeCode); */
				      		$('.showPatientDtl').slideDown('slow'); 
				      		count=0;
							$('.patientListBlock').each(function(index){
								//console.log('patientListBlock::::>>>>> '+count); 
								if($(this).find('.patCrNo').text().trim() === $('#patCrNoPrescriptionPanel').text().trim())
									return false;
									count++;
								}); 	
			      		});
						$(e).parent().parent().parent().attr('clicked','1');
					}
					if(temp == 1) 
					{
						$(e).parent().parent().parent().children('.showPatientDtl').toggleClass('hideCls'); 
					}
				}
 
	
	function showPrescription(e, isModify){ 
			$('.prescriptionColBtn').attr("disabled", true);
			$(".loader").show();
			
			localStorage.setItem('refWindowFlag','0'); 	// Change added by Timsi to support Patient Referal Process
			localStorage.setItem('patReferedOrNotFlag', 0);	// Change added by Timsi to support Patient Referal Process
			localStorage.removeItem("crc");
			localStorage.removeItem("idForCRC");
			localStorage.removeItem("urlForQR");
			
			var patName = $(e).closest('.patientListBlock').find('.patName').text();
			var patCrNo = $(e).closest('.patientListBlock').find('.patCrNo').text();
			var patEpisodeVisitNo = $(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text();
			
			localStorage.removeItem("tempName"); 
			if(localStorage.getItem("FormattedJson")){
				localStorage.removeItem("FormattedJson");
			}
			
			if(localStorage.getItem("myJSON")){
				localStorage.removeItem("myJSON");
			}
			
			
			
			var patLastVisitDate = $(e).closest('.patientListBlock').find('.patLastVisitDate').text()==='' ? 'First Visit' : $(e).closest('.patientListBlock').find('.patLastVisitDate').text(); //Changed By Timsi Kataria as suggested by Priyesh Sir
			var patVisitType = $(e).closest('.patientListBlock').find('.patVisitType').text();
			var patGaurdianName = $(e).closest('.patientListBlock').find('.patGaurdianName').text(); 
			var patDeptName = $(e).closest('.patientListBlock').find('.patDeptUnit').text();
			var patAdd = $(e).closest('.patientListBlock').find('.patAdd').text();
			var timeOfVisit = $(e).closest('.patientListBlock').find('.timeOfVisit').text();
			var nextPatName = $(e).closest('.patientListBlock').next().find('.patName').text(); 
			var prevPatName = $(e).closest('.patientListBlock').prev().find('.patName').text();
			var patGenAgeCat = $(e).closest('.patientListBlock').find('.patGenAgeCat').text();
			var mobileNo = $(e).closest('.patientListBlock').find('.mobileNo').text();
			
			
			var episodeCode = $(e).closest('.patientListBlock').find('.patEpisodeCode').text();
			var hospitalCode = $(e).closest('.patientListBlock').find('.patHospitalCode').text();
			var seatId = $(e).closest('.patientListBlock').find('.patSeatId').text(); 
			var patConsultantName = $(e).closest('.patientListBlock').find('.patConsultantName').text();  
			var patCompleteGeneralDtl = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl]').val();
			var patCompleteGeneralDtl1 = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl1]').val();
			var teleConsultancyRequestId = $(e).closest('.patientListBlock').find('input[name=teleConsultancyRequestId]').val();
			
			var patOthersDetails = $(e).closest('.patientListBlock').find('.patOthersDetails').text();
			var patOthersDetailss;
			var isPatReferredId = $(e).closest('.patientListBlock').find('input[name=isPatReferredId]').val();
			
			var cardType=$(e).closest('.patientListBlock').find('.cardType').text();
			var relation=$(e).closest('.patientListBlock').find('.relation').text();
			var cardValidityDate=$(e).closest('.patientListBlock').find('.cardValidityDate').text();
			var cardValidityStatus=$(e).closest('.patientListBlock').find('.cardValidityStatus').text();
			var patientPhotoName=$(e).closest('.patientListBlock').find('.patientPhotoName').text();
			var cardColor=$(e).closest('.patientListBlock').find('.cardColor').text();
			
			var parentWellnessCenter=$(e).closest('.patientListBlock').find('.parentWellnessCenter').text();
			var priority=$(e).closest('.patientListBlock').find('.priority').text();
			var internalqueueno=$(e).closest('.patientListBlock').find('.internalqueueno').text();
			var internamequeuenovisit=$(e).closest('.patientListBlock').find('.internamequeuenovisit').text();
			var queuesymbol=$(e).closest('.patientListBlock').find('.queuesymbol').text();
			var displayqueueno=$(e).closest('.patientListBlock').find('.displayqueueno').text();
			var queuestatus=$(e).closest('.patientListBlock').find('.queuestatus').text();
			
			patOthersDetailss = '{}';
			
		/*	$.ajax({url:'/HISDRDESK_MC/services/restful/patdata/getPatUmidData?Modval=9&CrNo='+patCrNo+'&hosp_code='+hospitalCode +'',
				dataType: "json",
	   		  	type: "GET",
				async:false,
				success:function(result){ 
				//	//console.log('getPatUmidData1 :  '+JSON.stringify(result.pat_details[0].UMID_DATA));
					if(result.status == "1"){
						patOthersDetailss = result.pat_details[0].UMID_DATA;
					}else{
						patOthersDetailss = '{}';
					}
				}
			});*/
			
			////console.log(JSON.stringify(result));
			//console.log('=============patOthersDetails=================='+ patOthersDetails);
			//console.log('=============patOthersDetailss=================='+ JSON.stringify(patOthersDetailss));
			
			////console.log(patOthersDetailss.umid_no);
			/*------------------------------Reason for Visit from Registration------------*/
			var ReasonForVisitFormRegistrationvar = $(e).closest('.patientListBlock').find('input[name=ReasonForVisitFormRegistration]').val();
			/*------------------------------Reason For Visit from registration end--------------*/
			//console.log('showPrescription::>>> '+patName+patCrNo+patEpisodeVisitNo+patLastVisitDate);
			/* alert('frst::'+episodeCode); */
			var prescMode = $('input[name=prescMode]:checked').val(); 
	        //console.log('Presc in showPrescription() : '+prescMode);
	        
	        //console.log('patCompleteGeneralDtl  '+patCompleteGeneralDtl);

			if(prescMode==1) //Not in use !! Do not comment.
			{	//console.log('tile mode presc'+prescMode);
				inTilePresc(e, patName, patCrNo, episodeCode, patGenAgeCat, (patCompleteGeneralDtl+'^^^'+patCompleteGeneralDtl1)); //Not in use !! Do not comment.
			}
			else if(prescMode==2)
	        { //console.log('page mode presc'+prescMode);
				$('.showPatientDtl').remove();
				$('.patientListBlock').attr('clicked','0');   //Not in use !! Do not comment.
				$('.rightPanel').append(str);
				$('.leftPanelHeader').toggleClass('col-sm-12 hideCls');
				$('.leftPanel').toggleClass('col-sm-12 hideCls');
				$('.prescriptionColShow').hide('slow');  //Not in use !! Do not comment.
				$('.mainTopHeader').hide();
				
				
				$('.rightPanel').parent().append('<h2 id="rightPanelLoadMsgId" style="margin-top:20%; margin-left:5%"><i class="fa fa-spinner fa-spin"></i> Loading Patient Prescription....</h3>');
				
				var currentPatientDtl={
					
					"patCrNo":patCrNo,
					"episodeCode":episodeCode,
					"patEpisodeVisitNo":patEpisodeVisitNo,
					"hospitalCode":hospitalCode,
					"seatId":seatId,															
					"patientPhotoName":patientPhotoName,
					"patName":patName,
					"cardType":cardType,
					"relation":relation,
					"cardValidityDate":cardValidityDate,
					"cardValidityStatus":cardValidityStatus,
					"cardColor":cardColor,
					"mobileNo":mobileNo,
					"parentWellnessCenter":parentWellnessCenter,
					"patDeptName":patDeptName,
					"patGenAgeCat":patGenAgeCat,
					"patAdd":patAdd  								
				}
				
				localStorage.setItem("currentPatientDtl",JSON.stringify(currentPatientDtl));
					
				 $.ajax({
					url: '/HISDRDESK_MC/new_opd/prescription.jsp',
					async:true,
					success: function(result){
							$('.prescriptionColBtn').attr("disabled", false);
							$(".loader").hide();
							$('.rightPanel .showPatientDtl').html(result);
							$('#patNamePrescriptionPanel').text(patName);
				      		$('#patCrNoPrescriptionPanel').text(patCrNo);
							$('#patientPhotoName').val(patientPhotoName);
							
				      		//alert("isModify>>" + isModify);
				      		$('#isModify').val(isModify)
				      		populateStoreDrugList();
				    
				      		$('#cardType').text(cardType);
							$('#relation').text(relation);
							$('#cardValidityDate').text(cardValidityDate);
							$('#cardValidityStatus').val(cardValidityStatus);
							
							$('#cardColor').val(cardColor);
							$('#mobileNo').val(mobileNo);
							
							$('#divParentWellnessCenter').text(parentWellnessCenter)
							
							$('#patPatientConditon').text(priority);
							$('#parentWellnessCenter').val(parentWellnessCenter);
							$('#priority').val(priority);
							$('#internalqueueno').val(internalqueueno);
							$('#internamequeuenovisit').val(internamequeuenovisit);
							$('#queuesymbol').val(queuesymbol);
							$('#displayqueueno').val(displayqueueno);
							$('#queuestatus').val(queuestatus);
							
							
							
				      		if(patOthersDetailss != '{}'){
				      			$('#patOthersDetailsPrescriptionPanel').text(JSON.stringify(patOthersDetailss));
					      		$('#patUmidPrescriptionPanel').text((patOthersDetailss).umid_no);
					      		$('#patRecentUmidTestPrescriptionPanel').text((patOthersDetailss).umid_no);
					      		
					      		$('#patRecentEmailTestPrescriptionPanel').text(patOthersDetailss.email_id);
					      		$('#patRecentValidityTestPrescriptionPanel').text(patOthersDetailss.validity);
					      		$('#patRecentAgeTestPrescriptionPanel').text(patOthersDetailss.age);
					      		$('#patRecentBloodTestPrescriptionPanel').text(patOthersDetailss.blood_group);
					      		$('#patRecentHandicappedTestPrescriptionPanel').text(patOthersDetailss.handicap_status);
					      		$('#patRecentLevelOfEntitlementTestPrescriptionPanel').text(patOthersDetailss.level_of_entitilment);
					      		
					      		$('#patRecentStatusTestPrescriptionPanel').text(patOthersDetailss.current_status);
					      		
					      		
					      		$('#patRecentDepartmentTestPrescriptionPanel').text(patOthersDetailss.department);
					      		$('#patRecentOPDElegibilityTestPrescriptionPanel').text(patOthersDetailss.opd_eligibility);
					      		$('#patRecentIPDElegibilityTestPrescriptionPanel').text(patOthersDetailss.ipd_eligibility);
					      		$('#patRecentBeneficiaryTestPrescriptionPanel').text(patOthersDetailss.beneficiary_type);
					      		$('#patOccupationTestPrescriptionPanel').text(patOthersDetailss.designation);
					      		$('#patStationTestPrescriptionPanel').text(patOthersDetailss.custom_unit);
					      		
					      		$('#patdesignationPrescriptionPanel').text(patOthersDetailss.designation);
					      		$('#patStationPrescriptionPanel').text(patOthersDetailss.custom_unit);
					    
					      		// patIdImageforRailDtl
					      		$("#patSummaryTileImg").attr("src", patOthersDetailss.profile_pic);
				      		
				      		}else{
				      			$('#patOthersDetailsPrescriptionPanel').text('{}');
				      			$('#patUmidPrescriptionPanelId').css('display','none');
				      			$('#patUmidPrescriptionPanel').css('display','none');
				      			$('#patUmidPrescriptionPanel').text('');
				      			$('#patdesignationPrescriptionPanel').text('');
					      		$('#patStationPrescriptionPanel').text('');
					      			
				      			$('#patRecentUmidTilesPrescriptionPanel').css('display','none');
				      			$('#patRecentIPDElegibilityTestPrescriptionPanel').css('display','none');
				      			$('#patRecentOPDElegibilityTestPrescriptionPanel').css('display','none');
				      			$('#patRecentDepartmentTestPrescriptionPanel').css('display','none');
				      			$('#patRecentLevelOfEntitlementTestPrescriptionPanel').css('display','none');
				      			$('#patRecentHandicappedTestPrescriptionPanel').css('display','none');
				      			$('#patRecentBloodTestPrescriptionPanel').css('display','none');
				      			$('#patRecentAgeTestPrescriptionPanel').css('display','none');
				      			$('#patRecentStatusTestPrescriptionPanel').css('display','none');
				      			
				      			$('#patRecentValidityTestPrescriptionPanel').css('display','none');
				      			$('#patRecentEmailTestPrescriptionPanel').css('display','none');
				      			
				      			$('#patSummaryTileImg').attr('src',$(e).closest('.patientListBlock').find('.patProfileImg').attr('src'));
				      		}
				      		//$('#patSummaryTileImg').attr('src',$(e).closest('.patientListBlock').find('.patProfileImg').attr('src'));
				      		$('#patEpisodeVisitNoPrescriptionPanel').text(patEpisodeVisitNo);
				      		$('#patLastVisitDatePrescriptionPanel').text(patLastVisitDate);
				      		$('#patVisitTypePrescriptionPanel').text(patVisitType);
				      		$('#prescriptionPanelPatStatus').text($(e).closest('.patientListBlock').hasClass('isAttended_1')?'':'Attended').css('color',$(e).closest('.patientListBlock').hasClass('isAttended_1')?'#1bbf23':'red');
				      		$('#patGaurdianNamePrescriptionPanel').text(patGaurdianName);
				      		$('#patDeptName').text(patDeptName);
				      		$('#patGenAgeCatPrescriptionPanel').html(patGenAgeCat); 
				      		$('#patAdd').html(patAdd);
				      		$('#timeOfVisit').html(timeOfVisit);
				      		//$('#patPensionerFMA').html(patGenAgeCat);
				      		$('#patHospitalCodePrescriptionPanel').html(hospitalCode); 
				      		//$('#patSeatIdPrescriptionPanel').html(seatId); 
				      		$('#patConsultantNamePrescriptionPanel').html(patConsultantName); 
				      		if(nextPatName.trim()!='')
				      		$('#nextPatNamePrescriptionPanel').html(nextPatName.split("  ")[0].length>3 ? '('+nextPatName.split("  ")[0]+')' : '('+nextPatName.split("  ")[0]+' '+nextPatName.split("  ")[1]+')'); 
				      	  	if(prevPatName.trim()!='')
				      		$('#prevPatNamePrescriptionPanel').html(prevPatName.split("  ")[0].length>3 ? '('+prevPatName.split("  ")[0]+')' : '('+prevPatName.split("  ")[0]+' '+prevPatName.split("  ")[1]+')'); 
				      		$('#patEpisodeCodePrescriptionPanel').text(episodeCode);
				      		$('input[name=patCompleteGeneralDtlPrescriptionPanel]').val(patCompleteGeneralDtl+'^^^'+patCompleteGeneralDtl1);
				      		$('input[name=eTeleconsultancyreq]').val(teleConsultancyRequestId);
				      		$('input[name=eTeleconsultancyreq]').val(teleConsultancyRequestId); 
				      		$('input[name=isPatReferred]').val(isPatReferredId);
				      				      		
				      		/*--------------------------Added For Reason For Visit for registration----------------------*/
				      		if(ReasonForVisitFormRegistrationvar == '--'){
				      		$('#RegReasonForVisitId').html(ReasonForVisitFormRegistrationvar).hide();
				      		}else{
				      			$('#ReasonVisitFromRegistrationId').html(ReasonForVisitFormRegistrationvar);
				      		}
				      		
				      		/*--------------------------Added For Pensioner FMA by ashutoshk ----------------------*/
				      		////console.log('patCompleteGeneralDtl  ------- '+patCompleteGeneralDtl);
				      		////console.log('patCompleteGeneralDtl.split("#")[10]  ------- '+patCompleteGeneralDtl.split("#")[10]);
				      		if(patCompleteGeneralDtl.split("#")[10] != null && patCompleteGeneralDtl.split("#")[10] != '' &&  (patCompleteGeneralDtl.split("#")[10] == '33' || patCompleteGeneralDtl.split("#")[10] == '22')){
				      		$('#patPensionerFMA').html('[ Eligible for OPD Services - Only for Chronic Diseases ]');
				      		}else{
				      			$('#patPensionerFMA').html('[ Eligible for OPD Services - Only for Chronic Diseases ]').hide();
				      		}
				   
				      		/*--------------------------Added For Reason For Visit for registration end----------------------*/ 
				      		$('input[name=patGeneralDtl]').val(patName+'#'+patCrNo+'#'+episodeCode+'#'+patGenAgeCat);
							$('.rightPanel').show();
							$('body').css('padding-top','0px');
							$('body .container-fluid:first-child').css('margin','0px');
							count=0;
							$('.patientListBlock').each(function(index){
								//console.log('patientListBlock::::>>>>> '+count); 
								if($(this).find('.patCrNo').text().trim() === $('#patCrNoPrescriptionPanel').text().trim())
									return false;
									count++;
								}); 	
							$('#rightPanelLoadMsgId').remove();
							getPatientImg();
							
						}
					}); 
				 
			}
			else if(prescMode==3)//Not in use !! Do not comment.
	        { //console.log('modal mode presc'+prescMode);
				$('.showPatientDtl').remove();
				$('.patientListBlock').attr('clicked','0'); 
				$('.prescModalBody').append(str);
	      		$('.prescModalBody .showPatientDtl').load('/HISDRDESK_MC/new_opd/prescription.jsp', function(){
			      		$('#patNamePrescriptionPanel').text(patName);
			      		$('#patCrNoPrescriptionPanel').text(patCrNo);
			      		$('#patGenAgeCatPrescriptionPanel').text(patGenAgeCat);
			      		$('#patAdd').text(patAdd);
			      		$('#timeOfVisit').text(timeOfVisit);
			      		$('#patEpisodeCodePrescriptionPanel').text(episodeCode);
			      		$('input[name=patCompleteGeneralDtlPrescriptionPanel]').val(patCompleteGeneralDtl);
			      		$('input[name=patGeneralDtl]').val(patName+'#'+patCrNo+'#'+episodeCode+'#'+patGenAgeCat);
		      		});   
				$('#prescModalTriggerBtn').click();
			}
	}

	function hidePrescription(e){
		//$("#example").addClass("collapsed");
		$('.leftPanelHeader').toggleClass('col-sm-12 hideCls');
		$('.leftPanel').toggleClass('col-sm-12 hideCls');
		$('.prescriptionColShow').show();
		$('.rightPanel').hide();
		$('.mainTopHeader').slideDown();
		$('body').css('padding-top','15px');
		//$('body .container-fluid:first-child').css('margin','5px 20px');
		localStorage.removeItem("tempName");
		
		if(localStorage.getItem("FormattedJson")){
			localStorage.removeItem("FormattedJson");
		}
		
		if(localStorage.getItem("myJSON")){
			localStorage.removeItem("myJSON");
		}
		
		/*//console.log("lastThreeVisitLength hidePrescription"+localStorage.getItem("lastThreeVisitLength"));
		 * 
		 * for (var index = 0; index < 20; index++) {
			if(localStorage.getItem("lastThreeVisitJson_"+index)){
				localStorage.removeItem("lastThreeVisitJson_"+index);
			}
				
		}
		var length = localStorage.getItem("lastThreeVisitLength");
		
		for (var index = 0; index < length; index++) {
			if(localStorage.getItem("lastThreeVisitJson_"+index)){
				
				//console.log("lastThreeVisitLength index"+index);
				localStorage.removeItem("lastThreeVisitJson_"+index);
			}
				
		} */
		
		localStorage.removeItem("lastThreeVisitLength");
		//document.forms[0].hmode.value="NEW";
		//document.forms[0].submit();
	}

	function refreshListPage(){
		document.forms[0].hmode.value="NEW";
		document.forms[0].submit();
	}
 






$(function () {
  $('[data-toggle="tooltip"]').tooltip({template:'<div class="tooltip" role="tooltip"><div class="arrow"></div><div class="tooltip-inner"></div></div>'});
});

$(document).ready(function(){

	
	
});




function globalSearch(e){
	$('#searchPatLst').empty();
	var txt = e.value;
	txt = txt.toUpperCase(); 
	/*alert(txt);*/
	//console.log('txt::::>>>'+txt);
	$('.patientListBlock:contains('+txt+')').hide('slow');
	$('.patientListBlock').each(function(index){
		//console.log('each');
		if($(this).find('.patCrNo').text().toUpperCase().indexOf(txt)>='0' && txt!='')
			{
					//console.log('matched');
					$('#searchPatLst').append('<option value="'+$(this).find('.patCrNo').text()+'"></option>'); 
			}
		});
	$('.patientListBlock:not(:contains('+txt+'))').hide('slow');
	$('.patientListBlock:contains('+txt+')').show('slow');
	/* $('.patientListBlock:contains('+txt+')').find('.patName').each(function(index){
		     var patNameforLst = $(this).text();
		     $('#searchPatLst').append('<option value="'+patNameforLst+'"></option>');
	});  */
	
}
function globalSearch2(e){
	$('#searchPatLst2').empty();
	var txt = e.value;
	txt = txt.toUpperCase(); 
	/*alert(txt);*/
	//console.log('txt::::>>>'+txt);
	/* $('.patientListBlock:contains('+txt+')').hide('slow'); */
	$('.patientListBlock').each(function(index){
		//console.log('each');
		if($(this).find('.patCrNo').text().toUpperCase().indexOf(txt)>='0' && txt!='')
			{
					//console.log('matched');
					$('#searchPatLst2').append('<option value="'+$(this).find('.patCrNo').text()+'"></option>'); 
			}
		});
	/* $('.patientListBlock:not(:contains('+txt+'))').hide('slow'); */
	/* $('.patientListBlock:contains('+txt+')').show('slow'); */
	/* $('.patientListBlock:contains('+txt+')').find('.patName').each(function(index){
		     var patNameforLst = $(this).text();
		     $('#searchPatLst').append('<option value="'+patNameforLst+'"></option>');
	});  */
	
}


$(document).ready(function(){
	$('#patientSearchModal').on('hidden.bs.modal',function(){
		$('#uk-search-input2').val('');
	});	 
});	


function patLstColorSrchOther(e){
	 if($(e).is(':checked'))
	 {
	 	$('.otherSrch').show('slow');
	 }
	 else{
	 	$('.otherSrch').hide('slow');
	 }
}
function patLstColorSrchNewVisit(e){
	 if($(e).is(':checked'))
	 {
	 	$('.newVisitSrch').show('slow');
	 }
	 else{
	 	$('.newVisitSrch').hide('slow');
	 }
}

function patLstColorSrchReffered(e){
	 if($(e).is(':checked'))
	 {
	 	$('.refferedSrch').show('slow');
	 }
	 else{
	 	$('.refferedSrch').hide('slow');
	 }
}
function patLstColorSrchAppointment(e){
	 if($(e).is(':checked'))
	 {
	 	$('.appointmentBasedSrch').show('slow');
	 }
	 else{
	 	$('.appointmentBasedSrch').hide('slow');
	 }
}





 $(document).ready(function(){
	var count = 0;
	$('.patientListBlock').each(function(){
			count++;
		});
	$('.isAttended_2').each(function(){
		saveCount++;
	});
	totalCount = count;
	$('.visitedPatCount').text(saveCount);
	$('.totalPatCount').text(count); 
});

 
 $(document).ready(function(){
	 new PerfectScrollbar('.containerNav');
	  new PerfectScrollbar('.leftPanel');
	  new PerfectScrollbar('.prescModalBody');
	  new PerfectScrollbar('#patSideListId');
 });
 
 
$(document).ready(function(){
	 /* new PerfectScrollbar('.containerNav');
	  new PerfectScrollbar('.leftPanel');
	  new PerfectScrollbar('.prescModalBody');
	  new PerfectScrollbar('#patSideListId');
	 */ 
	  
	  tippy('.opdVitalBtn',{
		  content: 'Click for patient Vitals',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
	  });
	  tippy('.prescriptionColBtn', {
		     content: 'Click for patient Prescription',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 });
		 tippy('.printPrescriptionMainDeskTriggerBtn', {
		     content: 'Patient Prescription Reprint',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 }); 
		 tippy('.emrLink', {
		      content: 'Click for patient EMR',
		      delay: 100,
		      arrow: true,
		      arrowType: 'round',
		      size: 'large',
		      duration: 500,
		      animation: 'scale'
		  });
		 tippy('.fullScreenDeskBtn', {
		     content: 'Responsive View',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 });
		 tippy('.shortcutInfoRightPanel', {
		     content: 'Shortcut Keys',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 });
		 tippy('.rightPanelClose', {
		     content: 'Close Prescription',
		     delay: 100,
		     arrow: true,
		     arrowType: 'round',
		     size: 'large',
		     duration: 500,
		     animation: 'scale'
		 }); 
		 
		 tippy('.skipPatient',{
			  content: 'Click to Skip this patient and call next patient',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 tippy('.changepriority',{
			  content: 'Click to change priority of this patient and call next patient',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 
		 tippy('#callPatientBtn',{
			  content: 'Click to call next patient from pool',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 tippy('#startOpdBtn',{
			  content: 'Click to start  Doctor Desk',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 
		 
		 tippy('#resumeOpdBtn',{
			  content: 'Click to resume  Doctor Desk',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 
		 tippy('#stopOpdBtn',{
			  content: 'Click to stop  Doctor Desk',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 
		 tippy('#pickFromPoolOpdBtn',{
			  content: 'Click to pick patient from pool',
			     delay: 100,
			     arrow: true,
			     arrowType: 'round',
			     size: 'large',
			     duration: 500,
			     animation: 'scale'
		  });
		 
		 
});

function configureDatePicker(){
	//alert($('input[name=strInitialMode]').val());
	if($('input[name=strInitialMode]').val() == '1')
	{
		sessionStorage.removeItem('selectedDate');
		
	}
	 var datepicker = $('#listDateFilter').datepicker({
		 
		     uiLibrary: 'bootstrap',
		     format: 'dd mmmm yyyy',
		     maxDate: function() {
		         var date = new Date();
		         date.setDate(date.getDate());
		         return new Date(date.getFullYear(), date.getMonth(), date.getDate());
		     },
		     icons: {
		         rightIcon: '<span class="glyphicon glyphicon-calendar"></span>'
		     },
		     showRightIcon: false,
		     close: function(e){
		     	getPatientData(e);
		     },
		     change: function (e) {
		    	// sessionStorage.setItem('selectedDate',$('#listDateFilter').val().toString());
		     }
		 });  
	var date = $('#listDateFilter').val()
	//console.log(typeof date+'date:::::::::>>>>>>>>>>>>>>>'+(date!=''?date:'no date'));
	if(date!='')
	{
		datepicker.value(date);
	}
	else
	{
		/*if(sessionStorage.getItem('selectedDate'))
		{
			datepicker.value(new Date(sessionStorage.getItem('selectedDate')));
		}
		else
		{*/
			var date = new Date();
	        date.setDate(date.getDate());
	        datepicker.value(new Date(date.getFullYear(), date.getMonth(), date.getDate()));
	       // sessionStorage.setItem('selectedDate',new Date(date.getFullYear(), date.getMonth(), date.getDate()).toString());
		/*}*/
	} 
} 

$(document).ready(function(){ 
	
	/*
	  if (elem.requestFullscreen) {
	    elem.requestFullscreen();
	  } else if (elem.webkitRequestFullscreen) { // Safari
	    elem.webkitRequestFullscreen();
	  } else if (elem.msRequestFullscreen) { // IE11 
	    elem.msRequestFullscreen();
	  }*/

	var varSSOTicketGrantingTicket=parent.document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
	
	if(localStorage.getItem("varSSOTicketGrantingTicketStoreage"))
		localStorage.removeItem("varSSOTicketGrantingTicketStoreage");
		localStorage.setItem("varSSOTicketGrantingTicketStoreage", varSSOTicketGrantingTicket);
	
	$('.fullScreenDeskBtn').click(function(){
		var elem = document.documentElement;
	
		/*	  if (elem.requestFullscreen) {
			    elem.requestFullscreen();
			  } else if (elem.webkitRequestFullscreen) { // Safari 
			    elem.webkitRequestFullscreen();
			  } else if (elem.msRequestFullscreen) { // IE11 
			    elem.msRequestFullscreen();
			  } */
		

		var win = window.open(window.location.href,'_blank');
		var varSSOTicketGrantingTicket=parent.document.getElementsByName("varSSOTicketGrantingTicket")[0].value;
		
		if(localStorage.getItem("varSSOTicketGrantingTicketStoreage"))
			localStorage.removeItem("varSSOTicketGrantingTicketStoreage");
			localStorage.setItem("varSSOTicketGrantingTicketStoreage", varSSOTicketGrantingTicket);
		localStorage.setItem('isFullScreen','1'); 
	});
	
	if(localStorage.getItem('isFullScreen')=='1')
	{
		//$('.toggleForFullScreenDeskBtn').toggleClass('col-sm-4 col-sm-5');	//Commented by Timsi to improve responsiveness of Date Field in full screen mode.
		$('.fullScreenDeskBtn').hide();
	}
	$(window).on("beforeunload", function() { 
	    return localStorage.setItem('isFullScreen','0');
	});
	$('.fullScreenDeskBtn').click(function(){
		/* $('.fullScreenDeskBtn').hide(); */
		});
	if(!localStorage.getItem('isFullScreen'))
		$('.fullScreenDeskBtn:first-child').click();
	
	$("#uk-search-input2").on('keypress', function (e) {
		if (!e) e = window.event;
		    var keyCode = e.keyCode || e.which;
	    var val = this.value;
		//console.log('keyCode::::>>>'+keyCode);
	    if(keyCode == 38 && keyCode == 40)
		    return false;
		    if (keyCode == '13' && val.trim()!='' && $('.patientListBlock').is(':contains('+val.trim()+')')){ 
		    if($('#searchPatLst2 option').filter(function(){
		        return this.value === val;        
		    }).length) {   
			    if(val == $('#patCrNoPrescriptionPanel').text().trim())
				{
			    	swal("Already open!!");
					return false;
				}
		    	hidePrescription(this);
				$('.patientListBlock:contains('+val+')').find('.prescriptionColBtn')[0].click();
				$('#patientSearchModal').find('.close').click();
				$(this).val('');
		    }
		    else{
		    	hidePrescription(this);
				$('.patientListBlock:contains('+val+')').find('.prescriptionColBtn')[0].click();
				$('#patientSearchModal').find('.close').click();
				$(this).val('');
			    }
		    }
	});
	
	/*$('.videocallList').click(function(){
		//console.log('videocallList');
		
		var patCompleteGeneralDtl = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl]').val();
		
		
		//console.log('patCompleteGeneralDtl'+patCompleteGeneralDtl);
		
		
	});*/
});
function videocallList(e){
	//console.log('videocallList');
	
	
	////console.log($('input[name=patCompleteGeneralDtlPrescriptionPanel]').val());
	var patCompleteGeneralDtl = $('input[name=patCompleteGeneralDtlPrescriptionPanel]').val();
	var reqFlg=patCompleteGeneralDtl.split('#')[18];
	var reqId=patCompleteGeneralDtl.split('#')[19];
	//console.log('patCompleteGeneralDtl -- '+patCompleteGeneralDtl);
	var tele_data=patCompleteGeneralDtl.split('^^^')[1];
	////console.log(reqFlg + ' ===  '+ reqId);
	//console.log('tele_data -- '+tele_data);
	////console.log(JSON.parse(JSON.stringify(patCompleteGeneralDtl.split('^^^')[1])));
	
	//var patCompleteGeneralDtl1 = $(e).closest('.patientListBlock').find('input[name=patCompleteGeneralDtl1]').val();
	
	////console.log("patCompleteGeneralDtl1::::"+patCompleteGeneralDtl1)
	 	
	////console.log('patCompleteGeneralDtl'+patCompleteGeneralDtl);
	//console.log(JSON.parse(tele_data).hrgstr_consultant_name);
	var jsondata ={
        "data" : {
                    "title": "eConsultation Doctor Call",
                    "content": JSON.parse(tele_data).hrgstr_consultant_name +" is calling you for eConsultation. Please join the call using the �Join Video Call� link shown in the �Consultation and Status� page of the app.",
                    "navigateTo": JSON.parse(tele_data).hrgstr_req_id  
        },
        "to": JSON.parse(tele_data).patient_token 
		}

	
	
	$.ajax({
		  type: "POST",
		  beforeSend: function(request) { 
		      //Nagpur
			  // request.setRequestHeader('Authorization', 'key=AAAASo__iUw:APA91bF-hl9D6cH9SBNPfXqOtUrHS6P3CBXzNfsM66h4KpOMQjyvbFLSM7p_ahIrVTxwx9obp4UNhkSnccE59qgX4jXIwdouSS5Xwf_QuShGmTvJGmbt2RYvUwgcF-vFPthQSW_dT91o');
			  
			  //Mangalgiri
			 //  request.setRequestHeader('Authorization', 'key=AAAA_wN054A:APA91bFz4gupSTKaqoq-7fNsk6n-U5wRWeaPo50UNf1lbevOToha4Ac8jqewJKk5C5r4YaHY2Eu3cL3M2Ue9-F6cmztdgNF7ZNl33SnGVQm7SOMpKR0I2hqvXCBBpsJ_h5WrdQ7_ati-');
			  
			  //Bhubneshwar
			//    request.setRequestHeader('Authorization', 'key=AAAABolJZwI:APA91bH1HpICwhpcsZkPoOYqDmFQ0M0jQ3UEW_Bhr1-pZoy9QI05wmQRpW5uAKujbGedHf2uV_Av-KWoeBM7ZlU3e6qDZjyYb4qChlU0BTuyqxc_mwPemnX82mPEEnKDONpXKz_vNOou');
			  
			  //Patna
			  //request.setRequestHeader('Authorization', 'key=AAAA7BQ8QWs:APA91bH3_lsDHE9ozOnVcOI_FZUbDujnINqsfHr0PWPDwG0KdlXBDizVA4wMR9146_a5Cw2ZC3IbQvb9CabW2Kf5twmSNjjIBaPl9VFHK6ARIkaygNipyYMNfeBoC76u2PgER6l_7Xmo');
		      
			  //Raipur
			  //request.setRequestHeader('Authorization', 'key=AAAARpXMVTU:APA91bG8K04eMkgnu2A_drRCpTNRTH17p-ZDAf5MXymIJuoFF4_xPwQMRQM1--L8adeeYXgu56gFee5GfEnR6gfXEHG2G2wpHIKi4ZGd7P0WKYw0XFfJVHjjssG1whyxxf-NsCCj_wcc');

			  //Railway
			  //request.setRequestHeader('Authorization', 'key= AAAAsUIV2YQ:APA91bF1PG-537KH8M5OSnCSy22g-VTlrE4wERTNZrYoPhTBU9mvAFIm8kEDPOpzff15Clym48B_eWiFuoavLMug_PdNQ4ti0HY-XR3dmuyBq1Lz_MTyfJhs0ZfGb37683YSgw32BRMy');
			  request.setRequestHeader('Authorization', 'key= AAAAsUIV2YQ:APA91bF8b0UAARLWSNKVSKvKvvnKsDgO9wutmxOlJ3SfdJQZE79EEYJQRbsCP7l1nfPmASHx-9aGHbNlZEcwSieZSAdxR_NSPUjl1CY1Ex4oYEU5eXOw4bAp_NGM7N-O580Uq4fT3j4f');
				 
			  
		      //Bhatinda
			 // request.setRequestHeader('Authorization', 'key=  AAAAF-tosS8:APA91bEzfvW8wrC2SZUd_r4DdzuE_NZe2qjav2zQEvQc7r0ctJYiQomelj5rQvIKJSVK443mXyzhNifWa0wTbjt1s_eIwwj6hi302ReYIHrj5Xj5zaPn0IoT5VJ4hb9uvmb-XutFxtHP');
			  
			  //Gorakhpur
			//  request.setRequestHeader('Authorization', 'key=  AAAA_dvcwEA:APA91bEjkUXeBdAy5OsXytkmr-FJ5b10YDXXGfSZ1lCk9qZaNi53ZHiCwhTEJGVHDtkM23bvyEUdFgZC3Ta-SEa0fWuxdwAZRERGCOXnl-v0DsPLPGDCH5Ju5uREFpJDGP-TZUtLsOO1');
			 
		  
		  },
		  url: "https://fcm.googleapis.com/fcm/send",
		 // url: "https://hmis.rcil.gov.in/HISServices/service/callPushNotfication/call",
		  data: JSON.stringify(jsondata),
		  processData: false,
		  contentType: 'application/json',
          dataType: 'json',
		  success: function(msg) {
			//console.log('Notification Send :'+ JSON.stringify(msg));
		  }
		});
	
	
	
	
	var url='https://mconsultancy.uat.dcservices.in/'+reqId ;
	//window.open(url , "_blank");
	window.open(url, "_blank", "toolbar=yes,scrollbars=yes,resizable=yes,top=200,bottom=200,left=300,right=200,width=700,height=500");
	/*$('#OpeneConsultancyModal .modal-body').prepend('<iframe id="OpeneConsultancyModalFrameId" style="width:100%;height:80vh;" src="'+url+'"></iframe>');
	$('#OpeneConsultancyModal').modal('show');
	$("#OpeneConsultancyModal").find(".modal-backdrop").css({"z-index": "-1"});*/
	
}

$(document).ready(function(){
	
	//console.log('showpatientCountId'+$('#showpatientCountId').val());
	
	
	
	 /*$(function () {
	     
	     $( document ).tooltip();
	     $('#patSideListBtn1').tooltip({
	         content: 'TOOLTIP CONTENT'
	     });
	 });*/
	 
	/*$('[data-toggle="tooltip"]').tooltip();
	$('#patSideListBtn1').tooltip({
        placement:"bottom"
      });*/
	//$('#patSideListBtn1').tooltip( "option", "content", "TOOLTIP CONTENT" );
	/*
	 * */
	//$("#patSideListBtn1").hover(function(){
		//$('#patSideListBtn1').tooltip( "option", "content", "TOOLTIP CONTENT" );
		$("#patSideListBtn1").attr("title",$('#showpatientCountId').val()+" Patient is Pending for Approval ");
		//$('#patSideListBtn1').tooltip();
		//$('[data-toggle="tooltip"]').tooltip();
		//$("#patSideListBtn1").tooltip();
		$('#patSideListBtn1').tooltip({
	        placement:"bottom" ,
	        container: 'body'
	      });
		
//	});
	
	
	
	});

$(document).ready(function(){
	
	$("#OpeneConsultancyModal").on('hide.bs.modal', function () {
		$('#OpeneConsultancyModalFrameId').remove();
	 });
});


$(document).ready(function() {
	$('#table panel data').click(function(){
		//alert("datatable2");
	       /* $('#example').DataTable();*/
	       var api = null ;
	       
	   $('#example').addClass( 'nowrap' ); 
	      var table = $('#example').DataTable({
	          "processing": true,
	          /* responsive: {
	              details: true
	          }, */ 
	          responsive: true,
	          columnDefs: [
	              { targets: [-1, -3], className: 'dt-body-right' } ,
	              { responsivePriority: 1, targets: 0 },
	              { responsivePriority: 2, targets: -3 },
	              { responsivePriority: 3, targets: -2 }
	            ] ,
	        
	          
	           "lengthMenu": [[10, 25, 50, 100, -1], [10, 25, 50, 100, "All"]],
	          "initComplete": function () {
	             api = this.api();
	             $('#mainDeskLoadingMsgDiv').hide();
	          }	          
	        });
	     // table.columns([1,2]).visible(false);  
	    //  //console.log('UMIDFlagVal UMIDFlagVal UMIDFlagVal  '+$('#strRailTailFlgId').val());
	      if($('#strRailTailFlgId').val() == '1'){
	    	  table.columns([8]).visible(false);
	      }else{
	    	  //console.log('LLLLLLLLLLLLL  ')
	    	  table.column(7).visible(false);
	      }
	      table.page.len( 50 ).draw();
	          
	      
	      $('.prescriptionColBtn').on( 'click', function () { 
	          table.page.len( -1 ).draw();
	      } );
	       
	      $('.rightPanelClose').on( 'click', function () {
	          table.page.len( 50 ).draw();
	      } );

	      $('.prescriptionColBtn').on( 'click', function () {
	    	  api.search('').draw();
	      } );
	      if(false){

	    		var tempName=$(id).parent().parent().find('a').text();
	    		//console.log("tempName:::::::::::::::::::::"+tempName);
	    		var parametreArr=[];
	    		var elVal="";
	    		var elId="";
	    		var jsonForm={};
	    		var j;
	    		for(var i=0;i<$('#'+templateid).find('#subContDivLeft').find(".addedEl").length;i++)
	    			{
	    			j=i;
	    			elId=$('#'+templateid).find('#subContDivLeft').find(".addedEl")[i].id;
	    			
	    				if($($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).hasClass("addedElGrp"))
	    					elVal=$($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).find("input:checked").val();
	    				else if($($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).hasClass("actPic"))
	    					elVal=$($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).parent().parent().parent().find(".ImgUpDiv img").attr("src");
	    				else if($($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).hasClass("input-group")){
	    					elVal=$($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).find("input").val()+"#"+$($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).find("button").html();
	    				
	    				}
	    				else if($($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).prop("id").split("-")[0]=="MultiAc"){
	    					let values=[];
	    					//console.log('if @@@@@@@@@@@@');
	    					$($('#'+templateid).find('#subContDivLeft').find(".addedEl")[i]).closest(".contDrag ").find(".addedElHelper .MultiHelper input").each((j,b)=>{
	    						if(j>0){
	    							values[j]=b.value;
	    						}

	    						
	    					});
	    					elVal=values;
	    				}
	    				else	{
	    					elVal=$("#"+elId).val();
	    					//console.log("ELSE");
	    					//console.log(elVal);
	    				}		
	    						
	    				
	    				
	    				//console.log("-----------");
	    				//console.log(elId);
	    				//console.log(elVal);
	    				//console.log("-----------");
	    				 jsonForm[elId ] = elVal;
	    				
	    			}
	    		
	    		 parametreArr[0]=jsonForm;
	    		
	    		 //console.log(':::::::::::::'+ parametreArr[0]);
	    		// //console.log(JSON.stringify(parametreArr));
	    		
	    		
	    		
	    		
	    		//console.log($('#strTemplatecodeId').val());
	    		//var formid = $('form').attr('id');
	    		////console.log('Length of the form is ::  '+formid);

	    		/*var parametreArr=[];
	    		for(var j=0 ;j < formId.split('#').length-1 ;j++ )
	    			{
	    			var jsonForm={};
	    			var formID1='#'+formId.split('#')[j];
	    			////console.log(formID1);
	    			 var queryFrom = $(formID1).serializeArray();

	    			   
	    			 for (i in queryFrom) {
	    				////console.log('1  '+queryFrom[i].value);
	    			   jsonForm[queryFrom[i].name] = queryFrom[i].value;
	    			   if(!$(a).hasClass("addedElGrp"))
	    			   
	    			   jsonForm[$('input[name="' + queryFrom[i].name + '"]').attr("id") ] = queryFrom[i].value;
	    			  }
	    			 ////console.log(JSON.stringify(jsonForm));
	    			 parametreArr[j]=jsonForm;
	    			}
	    		*/
	    		// return jsonForm;
	    		//console.log(':::::::::::::');
	    		////console.log(JSON.stringify(parametreArr));
	    		 var myJSON='';
	    		 if(localStorage.getItem("PatDtlsJsonData"))
	    		 myJSON = localStorage.getItem("PatDtlsJsonData");
	    			myJSON = JSON.parse(myJSON);

	    		////console.log('Save Html Template'+ JSON.stringify(jsonForm));
	    		  var vitalJSON = { 
	    				  'strSaveData' : "1" ,
	    				  "strPatJsonData" : myJSON ,
	    				  "strTemplateId"  : templateid.toString(),
	    				  'strFormData'	: parametreArr
	    				  } ;
	    				  var data = JSON.stringify(vitalJSON); 
	    		  		//console.log(data);
	    		  		//$('.opdTemplatePres').hide();	
	    		  		//console.log("  //console.log  ");
	    		  		$('#OpenTemplateModal').modal('hide');
	    		$.ajax({url:'',type:'POST',data:{JsonData:data},success:function(result)
	    	    	{
	    			
	    			//console.log('   ::::::::::::::::::::::::::::::::  ');

	    			swal("Data Save Successfully");
	    			
	    			$("#OpenTemplateModal").on('hide.bs.modal', function () {
	    				$('#OpenTemplateModalFrameId').remove();
	    			 });
	    			
	    			printDiv(templateid ,tempName);
	    			$('#OpenTemplateModalFrameId').remove();
	    			$('#OpenTemplateModal').modal('hide');
	    			
	    				$('#OpenTemplateModal').modal('hide');$('#OpenTemplateModalFrameId').remove();
	    	    	}
	    		});
	    		

	      }

	     
	      
	    
		
		
	})
	
});



$(document).ready(function() {
	
	if($('#strRailTailFlgId').val() == '0'){
		$('#patSideListBtn3').hide()
	}else{
		
		$("#patSideListBtn3").attr("title","Click here for Referral Stamping ");
		//$('#patSideListBtn1').tooltip();
		//$('[data-toggle="tooltip"]').tooltip();
		//$("#patSideListBtn1").tooltip();
		$('#patSideListBtn3').tooltip({
	        placement:"bottom" ,
	        container: 'body'
	      });
	}
	
	$("#patRefreshBtn").attr("title","Refresh List");
	//$('#patSideListBtn1').tooltip();
	//$('[data-toggle="tooltip"]').tooltip();
	//$("#patSideListBtn1").tooltip();
	$('#patRefreshBtn').tooltip({
        placement:"bottom" ,
        container: 'body',
        trigger : 'hover'
      });
	
	$("#patOfflineModalBtn").attr("title","Offline Patient Count");
	//$('#patSideListBtn1').tooltip();
	//$('[data-toggle="tooltip"]').tooltip();
	//$("#patSideListBtn1").tooltip();
	$('#patOfflineModalBtn').tooltip({
        placement:"bottom" ,
        container: 'body',
        trigger : 'hover'
      });
	
});
function opnedrugbookmark(){
	//var drugInstructionTags = [ "After Food","Before Food","After Breakfast","Before Breakfast","Bed Rest","Local application","Request For Local Purchase"];
	//alert(availableTags);
	$('#strDrugsRemarksId').val('');
	$("#strDrugsRemarksId").autocomplete({
        source: drugInstructionTags,
        appendTo : '#drugAdvicesInstructionsModal1'
    });
	
	$('#drugAdvicesInstructionsModal1').modal('show');
}
function opneExtdrugbookmark(){
	//var drugInstructionTags = [ "After Food","Before Food","After Breakfast","Before Breakfast","Bed Rest","Local application","Request For Local Purchase"];
	$('#strDrugsRemarksId1').val('');
	//alert(drugInstructionTags);
	$("#strDrugsRemarksId1").autocomplete({
        source: drugInstructionTags,
        appendTo : '#drugAdvicesInstructionsModal2'
    });
	
	$('#drugAdvicesInstructionsModal2').modal('show');
}


function patOfflineModalShow(){
	$('#strOfflinePatientCountId').val('');
	$('#offlinePatCountModal').modal('show');
}
function saveOfflinePatCount(){
	var strOfflinePatientCount = $('#strOfflinePatientCountId').val();
	
	if(strOfflinePatientCount==''){
		swal("Please enter offline patient count","","error");
		return false;
	}
	var seatId = $("input[name=strSeatId]").val();
	var deptCode = $("input[name=strHiddenDeptCode]").val().split("#")[0];
	var deptUnitCode = $("input[name=strHiddenDeptCode]").val().split("#")[1];
	var visitedPatCount = $('.visitedPatCount').text();
	var totalPatCount = $('.totalPatCount').text();
	var strHospitalCode = $("input[name=strHospitalCode]").val();
	var opdDate = $("input[name=strPrevDate]").val();
	
	var jsonArray = {	
			 "seatId": seatId ,
			 "deptCode": deptCode ,
			 "deptUnitCode": deptUnitCode ,
			 "visitedPatCount": visitedPatCount ,
			 "totalPatCount": totalPatCount ,
			 "strHospitalCode": strHospitalCode ,
	         "strOfflinePatientCount": strOfflinePatientCount ,
	         "opdDate": opdDate
	    };
	
	var data = JSON.stringify(jsonArray);
	//console.log(data);
	$.ajax({url:'/HISDRDESK_MC/services/restful/DrDesk/saveOfflinePatCountDtl',type:'POST',data:{JsonData:data },success:function(result)
    	{
		//console.log(':::::::::::::::::::: '+result);
		if(result === 1){
			//alert('Patient Approval Succesfully');
			//swal("Approve", "Patient Approve Successfully ", "success");

			swal("Offline Patient Count Added Successfully")
			.then((value) => {
				/*document.forms[0].strHiddenDeptCode.value=document.forms[0].deptUnitName.value ;
				document.forms[0].hmode.value="NEW";
				document.forms[0].submit();*/
				$('#offlinePatCountModal').modal('hide');
				
			});
			
			
			//return true;
		}else{
			//$(reqid).show();
			swal("Error", "Something Went Worng! ", "error");
			$('#offlinePatCountModal').modal('hide');
			/*alert('Something Went Wrong');
			return false;*/
		}
    	}
	});
	
}
function isNumber(evt)
{	 
   var charCode = evt.which; 
   if (charCode > 32 && (charCode < 48 || charCode > 57)) {
      return false;
    } 
    return true;
}

function validateHighRiskPregnancy(){
	return false; // stopping this option as not required in CGHS 
	
	
	var flagIsHighRiskPregnancy=false;
	$('#alertdivHRP').hide();
	if(document.getElementsByName("isPregnant")[0].checked==false){
		$('#isHighRiskPregnancyNo').prop("checked", true);
		return false;
	}
	
	//alert("check 1"); 
	var weightId= $('#weightId').val().trim()!=""? parseInt( $('#weightId').val().trim()):-1;
	if(weightId> -1 && weightId<40){
		return true;
	}
	
	//alert("check 2");
	var heightId= $('#heightId').val().trim()!=""? parseInt( $('#heightId').val().trim()):-1;
	if(heightId> -1 && heightId<150){
		return true;
	}
	
	//alert("check 3");
	var haemoglobinId= $('#haemoglobinId').val().trim()!=""? parseInt( $('#haemoglobinId').val().trim()):-1;
	if(haemoglobinId> -1  && haemoglobinId<10){
		return true;
	}
	
	//alert("check 4");
	var fastingId= $('#fastingId').val().trim()!=""? parseInt( $('#fastingId').val().trim()):-1;
	if(fastingId> -1 && fastingId>110){
		return true;
	}
	
	//alert("check 5");
	$('[name=obestetricHistory]').each(function(){
		if(this.checked)
			flagIsHighRiskPregnancy=true;
	});
	
	//alert("check 6");
	if(flagIsHighRiskPregnancy)
		return true;
	
	//alert("check 7");
	$('.hrpRadioYes').each(function(){
		if(this.checked)
			flagIsHighRiskPregnancy=true;
	});
	//alert("check 8");
	
	if(flagIsHighRiskPregnancy)
		return true;
	
	//alert("check 9");
	
	return false;
	
}
function openReferralPatientList(){
	
	if($('#deptUnitName').val()=="0#0#0")
		return;
	
	if($('#deptUnitName').val()==undefined  || $('#deptUnitName').val()=="")
		return;
	
	if($('.btnnewrx').length>0){
		swal({
			  title: "Status",
			  text: "Transferred Patients Can be accepted after current patient is attended/skipped",
			  icon: "warning", 
			}).then(function(willDelete) {
				return;
			});
		return;
	}
	
	
	
	var deptCode=$('#deptUnitName').val().split("#")[0];
	var deptUnitCode=$('#deptUnitName').val().split("#")[1];
	
	if($('#ReferralListModalFrameId').length>0)
	  	$('#ReferralListModalFrameId').remove();
	 
	localStorage.setItem("departmentUnitDtl",deptCode+'#'+deptUnitCode);
	$('#ReferralListModal .modal-body').prepend('<iframe id="ReferralListModalFrameId" style="width:100%;height:80vh;" src="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=REFER_LISTING"></iframe>');
	$('#ReferralListModal').modal('show'); 
	
}

window.closePopUpReferralPatientList = function(){
	$('#ReferralListModal').modal('hide');$('#ReferralListModalFrameId').remove();
}



function populateUnregisteredDrugList(){
	$.ajax(
		{
			url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=getUnRegisteredDrugs',
		    type:'GET',
		    async: true,		
		    success:function(result)
		    {
		    	/*if(result=="OK")
		    		console.log("Unregistered Drug load successful");
		    	else
		    		console.log("Problem while loading Unregistered Drug !");*/
		    	
		    }
	});	
}
function populateStoreDrugList(){
	
	$.ajax(
			{
				url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=getStoreDrugs',
			    type:'GET',
			    dataType:'json',
                async: true,		
			    success:function(result)
			    {
			    	$('#NormalStockTable tbody').empty();
			    	$('#RestrictedStockTable tbody').empty();
			    	$('#HighValueStockTable tbody').empty();
			    	var indxJA=1;
			    	var indxMSD=1;
			    	var indxUC=1;
			    	$.each(result, function(indx, drugobj){	
			    		
			    		var key=drugobj["drugId"]+"-"+ drugobj["drugBrandId"]+"-"+ indx;
			    			// three html are made separately so that if any extra field is required in one of programe type 
			    			//in future can be handled easily
			    			if(drugobj["drugStatus"]=="0"){
			    				var html="<tr class='trstockdrug' id='trstockdrug_"+key+"'>";
				    			html+="<td style='text-align:center'>"+indxJA+"<span style='display:none;' id='stockdrugjson_"+key+"'>"+JSON.stringify(drugobj)+"</span></td>";
				    			html+="<td style='text-align:left' class='tdstockdrug'>"+drugobj["drugName"]+"</td>";
				    			html+="<td style='text-align:center'>"+drugobj["drugQuan"]+"</td>";
				    			html+="<td style='padding: 12px;text-align:center;'>" +
		    					"<i class='fa fa-check-circle fa-2x text-success' style='display:none;' id='stockIconcheck_"+key+"'></i>" +
		    					"<a class='btn-his-outline' id='btnstockkadd_"+key+"'>Add</a></td>";
				    			html+="</tr>";
			    				$('#NormalStockTable tbody').append(html);
			    				indxJA++;
			    			}
			    			else if(drugobj["drugStatus"]=="1"){
			    				var html="<tr class='trstockdrug' id='trstockdrug_"+key+"'>";
				    			html+="<td style='text-align:center'>"+indxUC+"<span style='display:none;' id='stockdrugjson_"+key+"'>"+JSON.stringify(drugobj)+"</span></td>";
				    			html+="<td style='text-align:left' class='tdstockdrug'>"+drugobj["drugName"]+"</td>";
				    			html+="<td style='text-align:center'>"+drugobj["packSize"]+"</td>";
				    			html+="<td style='padding: 12px;text-align:center;'>" +
				    					"<i class='fa fa-check-circle fa-2x text-success' style='display:none;' id='stockIconcheck_"+key+"'></i>" +
				    					"<a class='btn-his-outline' id='btnstockkadd_"+key+"'>Add</a></td>";
				    			html+="</tr>";
			    				$('#RestrictedStockTable tbody').append(html);
			    				indxUC++;
			    			}
			    			else if(drugobj["drugStatus"]=="2"){
			    				var html="<tr class='trstockdrug' id='trstockdrug_"+key+"'>";
				    			html+="<td style='text-align:center'>"+indxMSD+"<span style='display:none;' id='stockdrugjson_"+key+"'>"+JSON.stringify(drugobj)+"</span></td>";
				    			html+="<td style='text-align:left' class='tdstockdrug'>"+drugobj["drugName"]+"</td>";
				    			html+="<td style='text-align:center'>"+drugobj["packSize"]+"</td>";
				    			html+="<td style='padding: 12px;text-align:center;'>" +
				    			"<i class='fa fa-check-circle fa-2x text-success'  style='display:none;' id='stockIconcheck_"+key+"'></i>" +
		    					"<a class='btn-his-outline' id='btnstockkadd_"+key+"'>Add</a></td>";
				    			html+="</tr>";
			    				$('#HighValueStockTable tbody').append(html);
			    				indxMSD++;
			    			}
			    		
			    	});
			    	$('#globalSearch').on('keyup', function() {
			            $('.trstockdrug').show();
			            var searchValue = this.value;
			            $('.tdstockdrug').each(function(){
			            	var drugname= $(this).text();
			            	//alert(searchSubstringCaseInsensitive(drugname, searchValue));
			            	if(searchSubstringCaseInsensitive(drugname, searchValue)==false)
			            		$(this).closest('tr').hide();
			            })
			    	});
			    	$('[id^=btnstockkadd_]').click(addStockDrug);
			    	
			    }
		});
}
function searchSubstringCaseInsensitive(mainString, substring) {
    if (mainString.toLowerCase().includes(substring.toLowerCase())) {
        return true;
    } else {
        return false;
    }
}

function populateDrugAutoCompleteList(drugJsonObj){
	try{ 
			
	    if($("#drugJsonObjDiv").text().trim().length<=0)
	  	{
	  		$("#drugJsonObjDiv").text(JSON.stringify(drugJsonObj).toString());
	  	}
	  	else if(JSON.stringify(drugJsonObj).toString() != $("#drugJsonObjDiv").text().trim().toString()){
	  		$("#drugJsonObjDiv").text(JSON.stringify(drugJsonObj).toString());
	  	}	
		
		$('input[name=drugName]').flexdatalist({
		     minLength: 1,
		     focusFirstResult: true,
		     searchByWord: true,
		     maxShownResults: 50,
		     searchIn: 'drugName',
		     visibleProperties: ["drugName","drugQuan"], 
		     data: drugJsonObj
		}); 
			
										  
		$('input[name=drugName]').on('select:flexdatalist', function(event, set, options) {
		    //console.log(set.drugName); 
		    //console.log(set.drugQuan); 
		    //console.log(set.drugId); 
		    $(this).attr('drugId',set.drugId);
		});
		
    }
    catch(err){
        //console.log('err.message:>>>'+err.message);
       }
} 


function printPrescriptionMainDeskFunForPdf(json){
	var crNo = json["crNo"];
	var episodeCode = json["episodeCode"];
	var visitNo = json["visitNo"];
	var seatId = json["seatId"];
	var visitDate =json["visitDate"];
	var hospCode = json["hospCode"]; 
	
	  var CRNO =crNo;
      var convertedCRNO = CRNO.replace('/', '-');
       var url = '/HISDRDESK_MC/services/restful/patdata/digi?Modval=5&CrNo='+convertedCRNO+'&episodeCode='+episodeCode+'&visitNo='+visitNo+'&seatId='+seatId+'&Entrydate='+visitDate+'&hosp_code='+hospCode;
		$.ajax({url: url, /*  '/HISDRDESK_MC/services/restful/patdata/getPatData?Modval=1&CrNo=331011800028649&episodeCode=10212001&visitNo=1&seatId=10038&Entrydate=27-DEC-2018&hosp_code=33101', */ 
			async:false,
			success: function(result){
				if(JSON.stringify(result)!="{}")
				{
					//console.log("result123 >>> "+JSON.stringify(result));
					//$('#reprintCardPdfModal').modal('show'); 
					//document.getElementById("reprintCardPdf").data="data:application\/pdf\;base64,"+result;
					//$('#reprintCardPdf').show();
					window.open('data:application/pdf;base64,'+result, '_blank')
					////console.log(result);
					
				}
			}
			});
	
 
}

function openReferralHistoryForPatient(){
	if($('#ReferralHistoryModalFrameId').length>0)
	  	$('#ReferralHistoryModalFrameId').remove();
	
	var patGeneralDtl = $('input[name=patGeneralDtl]').val().split('#');
	
	var crNo = patGeneralDtl[1];
	var episodeCode = patGeneralDtl[2];
	var visitNo = $('#patEpisodeVisitNoPrescriptionPanel').text();
	var seatId = $('input[name=strSeatId]').val();
	var hospCode = $('#patHospitalCodePrescriptionPanel').text(); 
	localStorage.setItem("refHistoryIds",crNo+'#'+episodeCode+'#'+visitNo+'#'+seatId+'#'+hospCode);
	
	$('#ReferralHistoryModal .modal-body').prepend('<iframe id="ReferralHistoryModalFrameId" style="width:100%;height:80vh;" src="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=REFER_HISTORY_LISTING"></iframe>');
	$('#ReferralHistoryModal').modal('show'); 
	
}


function openPatientReviewPage(){
	if($('#pateintReviewModalFrameId').length>0)
	  	$('#pateintReviewModalFrameId').remove();
	
	//Shanti Devi    #1000860#10211002#F / 59 Yr / 910000000000
	
	var patGeneralDtl = $('input[name=patGeneralDtl]').val().split('#');
	var patientName=patGeneralDtl[0].trim();
	var genderAgeMobile=patGeneralDtl[3].trim();
	
	var crNo = patGeneralDtl[1];
	var episodeCode = patGeneralDtl[2];
	var visitNo = $('#patEpisodeVisitNoPrescriptionPanel').text();
	var seatId = $('input[name=strSeatId]').val();
	var hospCode = $('#patHospitalCodePrescriptionPanel').text(); 
	var patdtl={"CR_No":crNo,
			"episodeCode":episodeCode,
			"visitNo":visitNo,
			"seatId":seatId,
			"hospitalCode":hospCode,
			"patientName":patientName,
			"genderAgeMobile":genderAgeMobile
			}
	
	//localStorage.setItem("Ids",crNo+'#'+episodeCode+'#'+visitNo+'#'+seatId+'#'+hospCode);
	localStorage.setItem("patdtl", JSON.stringify(patdtl));
	
	
	
	$('#pateintReviewModal .modal-body').prepend('<iframe id="pateintReviewModalFrameId" style="width:100%;height:80vh;" src="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=PATIENT_REVIEW"></iframe>');
	$('#pateintReviewModal').modal('show'); 
	
}

function openDrLeavePage(){
	if($('#deptUnitName').val()==undefined  || $('#deptUnitName').val()=="")
		return;
	
	var url="/CGHSRegistration/FormFlowXACTION?masterKey=doctorLeaveMaster&varSSOTicketGrantingTicket="+$('#varSSOTicketGrantingTicket').val();
	
	localStorage.setItem("deptUnitName",$('#deptUnitName').val());
	
	$('#drLeaveModal').modal('hide');$('#drLeaveModalFrameId').remove();
	$('#drLeaveModal .modal-body').prepend('<iframe id="drLeaveModalFrameId" style="width:100%;height:80vh;" src="'+url+'"></iframe>');
	$('#drLeaveModal').modal('show'); 
}

function addDaysToDate(days) {
	  // Get the current date
    let currentDate = new Date();

    // Add the number of days
    currentDate.setDate(currentDate.getDate() + parseInt(days, 10));

    // Format the date as YYYY-MM-DD
    let year = currentDate.getFullYear();
    let month = (currentDate.getMonth() + 1).toString().padStart(2, '0'); // Add leading 0 if necessary
    let day = currentDate.getDate().toString().padStart(2, '0'); // Add leading 0 if necessary

    return `${year}-${month}-${day}`;
}

function hideUnhideOnCallStatus(status){
	$('.btnCallStatus').hide();
	
	if($('#isSmartQMSEnabled').val()=="0"){
		$('#pickFromPoolOpdBtn').show();
		$('#patReferralBtn').show();
		$('.btnPatData').show();
		return;		
	}
	//alert(status);
	if(status==0){// start
		$('#startOpdBtn').show()
	}
	
	if(status==1){// start or resume
		$('#callPatientBtn').show();
		$('#pauseOpdBtn').show();
		$('#stopOpdBtn').show();
		$('#pickFromPoolOpdBtn').show();
		$('#patReferralBtn').show();
		$('.btnPatData').show();
		
		
	}
	if(status==2){//paused
		$('#resumeOpdBtn').show();
		$('#stopOpdBtn').show();
		$('.btnPatData').hide();
	}
	if(status==3){//stop or close
		$('#startOpdBtn').show();
		$('.btnPatData').hide();
	}
	
}

function callStatusWiseData(btnObj){
	var flagcallPatient=$(btnObj).attr("data-callPatient");
	var flagStatus=$(btnObj).attr("data-Status");
	var deptunitid= $('#deptUnitName').val().split("#")[1];
	
	var btnId=$(btnObj).attr('id');
	
	if(btnId=='pauseOpdBtn'){
		var confirmFlag=confirm('Assigned patient will wait till resume of opd.\nDo you want to continue ?')
		if(confirmFlag==false)
			return;
	}
	if(btnId=='stopOpdBtn'){
		var confirmFlag=confirm('Patients will be reassigned/cancelled.\nDo you want to continue ?')
		if(confirmFlag==false)
			return;
	}
	
	if(btnId=='callPatientBtn' && $('.btnnewrx').length>0){
		
		swal({
			  title: "Status",
			  text: "Next Patient Can be called after current patient is attended/skipped",
			  icon: "warning", 
			}).then(function(willDelete) {
				return;
			});
		return;
	}

		
	var inputjson={"deptunitid" :deptunitid, "actionflag":flagStatus, 
			"queueinternalno":$('#internalqueueno').val(), 
			"queueinternalno_visit" :$('#internamequeuenovisit').val(),
			"queuesymbol":$('#queuesymbol').val(), 
			"callnextpatient":flagcallPatient ,
			"benid":"" ,
			"benname":"",
			"mobileno":"",
			"displayqueueno":$('#displayqueueno').val()
		}
	updateUnitStatus(inputjson);	 
}
function updateUnitStatus(inputjson){
	//alert("actionflag>>" + inputjson["actionflag"]);
			

	$(".loader").css("display","");
	 $('#tree').append('<font id="treeMsgP" style="color:#1e87f0"><i class="fa fa-spinner fa-spin" style="font-size:18px"></i> Loading prescription....</font>'); // Do not comment !!! Not In use. 
		
	var payload={"hmode": "queueoperationbydr",inputjson:JSON.stringify(inputjson) }
	//alert("payload>>>" +  JSON.stringify(payload));
	
	
	$.ajax(
			{
				url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
			    type:'POST',
			    data:payload,
			    async: true,
			    dataType : "json",
			    success:function(result)
			    {
					//alert(JSON.stringify(result));
			    	if(result["message"]=="success"){	
										    		
			    		$('#internalqueueno').val("");
			    		$('#internamequeuenovisit').val("");
			    		$('#queuesymbol').val("");
			    		$('#displayqueueno').val("");
			    		refreshPatientData(this);
			    	}
			    }
		});	
	
}



function openopdPoolPatientListPage(){
	if($('#deptUnitName').val()==undefined  || $('#deptUnitName').val()=="")
		return;
	
	if($('.btnnewrx').length>0){
		
		swal({
			  title: "Status",
			  text: "Next Patient Can be called after current patient is attended/skipped",
			  icon: "warning", 
			}).then(function(willDelete) {
				return;
			});
		return;
	}
	var jsonbenIds={};
	$('.patCrNo').each(function(){
		var benId =$(this).text().trim();
		jsonbenIds[benId]=benId;
	});
	localStorage.setItem("attendedBenIds",JSON.stringify(jsonbenIds));
	
	var url="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=OPEN_POOL_PATIENT&varSSOTicketGrantingTicket="+$('#varSSOTicketGrantingTicket').val();
	
	localStorage.setItem("departmentUnitDtl",$('#deptUnitName').val());
	
	$('#PoolPatientListModal').modal('hide');$('#PoolPatientListModalFrameId').remove();
	$('#PoolPatientListModal .modal-body').prepend('<iframe id="PoolPatientListModalFrameId" style="width:100%;height:80vh;margin-top:-28px" src="'+url+'"></iframe>');
	$('#PoolPatientListModal').modal('show'); 
}

function callQueueStatusUpdateAfterSave(obj){

	if($('#isSmartQMSEnabled').val()=="0"){
		  hidePrescription(obj);
		  refreshPatientData(this);
		return;
	}
	  var str =localStorage.getItem("myJSON")
	  var myJSON= JSON.parse(str);
	  var deptunitid= $('#deptUnitName').val().split("#")[1];
	  var actionflag=9;
	 
	// alert(myJSON["isModify"])
	 console.log("str>>>" + str)
	 //alert("mobileNo>>>" + $('#mobileNo').val());
	  if(myJSON["isModify"]!="1"){
		 // var flagcall= confirm("Do you want to call next patient ?");
		  var flagcallPatient="0";
		  /*if(flagcall){
			  flagcallPatient="1";
		  }*/
		  var inputjson={"deptunitid" :deptunitid, "actionflag":actionflag, 
					"queueinternalno":$('#internalqueueno').val(), 
					"queueinternalno_visit" :$('#internamequeuenovisit').val(),
					"queuesymbol":$('#queuesymbol').val(), 
					"callnextpatient":flagcallPatient ,
					"benid":myJSON["CR_No"] ,
					"benname":myJSON["pat_Name"],
					"mobileno":$('#mobileNo').val(),
					"displayqueueno":$('#displayqueueno').val()
				}
		  updateUnitStatus(inputjson);
	  }
	  else{
		  hidePrescription(obj);
		  refreshPatientData(this);
	  }
	    
}
/*
	 actionflag = 1 >> Start, 2 >> Resume, 3 >> Pause, 4 >> Stop,
5 >> Change Priority, 
6 >> Skip, 7 >> Call Next Patient.
9 >> When Rx is saved */
function skipPatient(e){
	
	  var flagcall= confirm("Are you sure want to skip this patient");
	  var flagcallPatient="0";
	  if(flagcall==false){
		  return;
	  }
	  if($('#isSmartQMSEnabled').val()=="0"){
		  changeStatusForWithoutSmartQMS(e)
	  }else{
		  var actionflag=6;
		  changeStatus(e,actionflag,flagcallPatient);
		    
	  }
	  
}
function changeStatusForWithoutSmartQMS(e){
	
	
	
	var payload ={"status": "3",
			"benId": $(e).closest('.patientListBlock').find('.patCrNo').text(),
			"episodeCode": $(e).closest('.patientListBlock').find('.patEpisodeCode').text(),
			"visitNo": $(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text(),
			"hospitalCode":$(e).closest('.patientListBlock').find('.patHospitalCode').text()			
			}
	$('.loader').show();
	$.ajax({	
				url:'/HISDRDESK_MC/services/restful/DrDesk/UpdateQueueStatus_For_Withoutsmartqueue',
				type:'POST',
				data:JSON.stringify(payload),
				dataType : "json",
				contentType: "application/json; charset=UTF-8",
				success:function(result){
					$('.loader').hide();
					var status=result["status"];
					
					if(status=='SUCCESS')
						refreshPatientData(this);
					else{
						swal({
							  title: "Status",
							  text: "call Incomplete !!",
							  icon: "warning", 
							});
					}	
				}
	});

}

function BackToPool(e){
	 var flagcall= confirm("Are you sure you want to mark patient as no piority for this patient ?");
	  var flagcallPatient="1";
	  if(flagcall==false){
		  return;
	  }	 
	  var actionflag=5;
	  changeStatus(e,actionflag,flagcallPatient);
}
function changeStatus(e,actionflag,flagcallPatient){
	 var deptunitid= $('#deptUnitName').val().split("#")[1];
	  var patGenAgeCat = $(e).closest('.patientListBlock').find('.patGenAgeCat').text();
	  var mobile=	 $(e).closest('.patientListBlock').find('.mobile').text(); 
	  var internalqueueno=$(e).closest('.patientListBlock').find('.internalqueueno').text();
	  var internamequeuenovisit=$(e).closest('.patientListBlock').find('.internamequeuenovisit').text();
	  var queuesymbol=$(e).closest('.patientListBlock').find('.queuesymbol').text();
	  var displayqueueno=$(e).closest('.patientListBlock').find('.displayqueueno').text();		
	  
	  var inputjson={"deptunitid" :deptunitid, "actionflag":actionflag, 
				"queueinternalno":internalqueueno, 
				"queueinternalno_visit" :internamequeuenovisit,
				"queuesymbol":queuesymbol, 
				"callnextpatient":flagcallPatient ,
				"benid":$(e).closest('.patientListBlock').find('.patCrNo').text() ,
				"benname":$(e).closest('.patientListBlock').find('.patName').text(),
				"mobileno":mobile,
				"displayqueueno":displayqueueno
			}
	  updateUnitStatus(inputjson);
}

function SendCallToDisplayBoard(){
	//alert("SendCallToDisplayBoard");
	var indx=0;
	var arr= new Array();
	var isCalledStatusFound=false
	$('.queuestatus').each(function(){
		var queuestatus=$(this).text();
		var isConfirmed=	$('.isConfirmed').eq(indx).text().trim();
		if(isConfirmed!=2 && ( queuestatus=="0" || queuestatus=="1")){
			if(queuestatus=="0"){
				isCalledStatusFound=true;
			}
			var json={
					"displayqueueno" : $('.displayqueueno').eq(indx).text().trim(),
					"benname" : $('.patName').eq(indx).text().trim(),
					"queuestatus" : $('.queuestatus').eq(indx).text().trim(),
			}
			arr.push(json);
		}
		indx++;
	});
	
	var deptunitid= $('#deptUnitName').val().split("#")[1];
	var status=$('#deptUnitName').val().split("#")[3];
		//alert(status);
		if(status=="1" && arr.length==0){
			status="Started";
			if(arr.length==0){
				arr=new Array();
				var json={
						"displayqueueno" : status,
						"benname" : "",
						"queuestatus" : "-1"
				}
				arr.push(json);
			}
			
		}		
		else if(status=="2"){
			status="Paused";
			arr=new Array();
			var json={
					"displayqueueno" : status,
					"benname" : "",
					"queuestatus" : "-1"
			}
			arr.push(json);
		}
		else if(status=="3"){
			status="Stopped";
			arr=new Array();
			var json={
					"displayqueueno" : status,
					"benname" : "",
					"queuestatus" : "-1"
			}
			arr.push(json);
		}
		
		
		
	//alert(JSON.stringify(arr));
	
	if(arr.length>0){
		
		var payload={"hmode": "SendCallToDisplayBoard","departmentUnitCode":deptunitid, "inputjson": JSON.stringify(arr)}
		//alert("payload>>>" +  JSON.stringify(payload));
		$.ajax(
				{
					url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
				    type:'POST',
				    data:payload,
				    async: true,
				    dataType : "json",
				    success:function(result)
				    {
				    	// do nothing
				    	
				    }
			});	
	}
}



var globalPatCrNo = null;
var globalPatEpisodeCode = null;
var globalparentWellnessCenter = null;
var globalpatConsultantName = null;

function showSickModal(e) {
		  var patCrNo=  $(e).closest('.patientListBlock').find('.patCrNo').text()
		  globalPatCrNo =patCrNo;
		  globalPatEpisodeCode =$(e).closest('.patientListBlock').find('.patEpisodeCode').text();
		  globalpatConsultantName = $(e).closest('.patientListBlock').find('.patConsultantName').text();
		  globalparentWellnessCenter = $(e).closest('.patientListBlock').find('.parentWellnessCenter').text();
		  fetchPatientDetails(patCrNo);
	  

	
		  $('#sickFitModal').modal('show');
		  $('#patDiagnosisDiv').modal('show');
		  //$('#sickFormDetails').style.display = 'none';
	
	}

	// Function to fetch patient details
	function fetchPatientDetails(patCrNo,patEpisodeCode,patConsultantName,parentWellnessCenter) {
	  // Find the patient row in the table using patCrNo
	  const patientRow = $(`.patientListBlock .patCrNo:contains('${patCrNo}')`).closest('.patientListBlock');

	  if (patientRow.length > 0) {
		  
	    // Extract patient details from the row
		    const patientData = {
		    	      name: patientRow.find('.patName').text().trim(),
		    	      crNo: patientRow.find('.patCrNo').text().trim(),
		    	      patMobileNo: patientRow.find('.mobileNo').text().trim(),
		    	      gender: patientRow.find('.patGenAgeCat').text().split('/')[0].trim(),
		    	      age: patientRow.find('.patGenAgeCat').text().split('/')[1].trim(),
		    	      patConsultantName:globalpatConsultantName,
		    	      parentWellnessCenter:globalparentWellnessCenter,
		    	      
		    	    };
		    
		    console.log('Patient Data:', patientData);

	    updatePatientTable(patientData);
	    generateTable(patientData);
	  } else {
	    console.error('Patient not found with CR Number:', patCrNo);
	  }
	}
	


	  let mcfcAge, mcfcGender, mcfcpatCrNo, mcfcpatName;
		// Function to update the table with patient details
		  function updatePatientTable(patientData) {
			    const tableBody = document.querySelector("#patientDetailsTable tbody");

			    // Clear existing rows
			    tableBody.innerHTML = "";

			    // Assign global variables
			    mcfcAge = patientData.age;
			    mcfcGender = patientData.gender;
			    mcfcpatCrNo = patientData.crNo;
			    mcfcpatName = patientData.name;

			    // Add rows with patient details
			    const rows = 
			      "<tr>" +
			        "<td><b>Name</b></td>" +
			        "<td><p class='mcfcpatName'>" + mcfcpatName + "</p></td>" +
			        "<td><b>BEN ID.</b></td>" +
			        "<td><p class='mcfcpatCrNo'>" + mcfcpatCrNo + "</p></td>" +
			        "<td><b>Gender</b></td>" +
			        "<td><p class='mcfcGender'>" + mcfcGender + "</p></td>" +
			        "<td><b>Age</b></td>" +
			        "<td><p class='mcfcAge'>" + mcfcAge + "</p></td>" +
			      "</tr>";

			    // Insert rows into the table
			    tableBody.innerHTML = rows;
			  }
	//console.log("globalEpisodeCode  >>  "+globalEpisodeCode);
	
	function saveFittnessDtls(button) {
		
		  if ( confirm("Do you want to make this patient as Attended") ){
		    	var isAttendedFlag = 1;
		    }else{
		    	var isAttendedFlag = 0;
		    }
		
		  var mobileElement = document.querySelector('.mobileNo');
		  var patMobileNo = mobileElement.textContent || mobileElement.innerText;
		  var patMCSeatId = document.querySelector('.patSeatId').textContent;
		  var patMCVisitNo = document.querySelector('.patEpisodeVisitNo').textContent;
		 // var mcHospName = document.getElementById('varMCHospName').value
		  //var hospitalName = hospitalName;
		  
		 // alert(hospitalName);
		 // alert("patMCSeatId  > : "+ patMCSeatId ,"patMCVisitNo  > : "+ patMCVisitNo );
		 // alert("1 > "+patMobileNo);
	    var $row = $(button).closest('tr');
	    //var $row = $(element).closest('tr'); 
	    //var patConsultantName = globalpatConsultantName;
	    var puk = $row.find('.puk').val();
	    var episodeCode = $row.find('.episodeCode').val();
	    var illness = $row.find('.illness').text(); 
	    //var entryDate = $row.find('.entryDate').val().split(' ')[0];
	    var designation = $row.find('.gnumMedNo').val();
	    var tempGnumMedNo = $row.find('.gnumMedNo').val();
	    //console.log("saveFittnessDtls  gnumMedNo  >> " ,$row.find('.gnumMedNo').val() )

		console.log("saveFittnessDtls  tempGnumMedNo  >> " ,globalpatConsultantName,patConsultantName )
		
		var patConsultantName = globalpatConsultantName + "^" + document.getElementById('varMCHospName').value;	
		
		var inputjson = {
	        puk: puk,
	        episodeCode: episodeCode,
	        formID: '5',
	        illness: illness,
	        designation: designation,
	        absenceFrom: '2025-02-14',
	        absenceTo: '2025-02-14',
	        effectiveDate: '2025-02-14',
	        mcStatus:0,
	        fcStatus:1,
	        tempGnumMedNo:tempGnumMedNo,
	        consultantName:patConsultantName,
	        seatId:document.querySelector('.patSeatId').textContent,
	        visitNo:document.querySelector('.patEpisodeVisitNo').textContent,
	        isAttended:isAttendedFlag
	    };
			    //console.log("Final JSON:", JSON.stringify(inputjson));

		updateSickFormStatus(inputjson);
	    // Construct the final payload
	    var payload = {
	        hmode: "saveSickFormData",
	        inputjson: JSON.stringify(inputjson)

	    };
	    console.log("Payload being posted saveFittnessDtls:", payload);
	    
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            if (response.message === "success") {
	               console.log("Form data saved successfully!"); 
	               
	               //var formType = "Fittness";
	              // sendMesageConfirm("Fittness");
	              // sendMesageConfirm(button)
	               location.reload();
				    //console.log("updateSickFormStatus inputJson >> " + JSON.stringify(inputjson));
				    
	            } else {
	                alert("Failed to saveFittnessDtls: " + (response.message || "Unknown error"));
	            }
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	            alert("An error occurred while saving form data. Please try again.");
	        }
	    });
        
	}
	
	
/*	function sendMesageConfirm(button){
		console.log("configJson message>>> ", configJson);
		console.log("dataJson message>>> ", dataJson);
			var formType = "Fittness "
			const data = new Array(formType);
			const mobileNumbers = new Array(patMobile);
			jsonObject = {
					"templateId":"",
					  "data":[],
		      	    "mobileNumbers":[],
				}
			jsonObject.data = data;
			jsonObject.mobileNumbers = patientData.mobileNo;
			jsonObject.templateId = "1107174437129269650";
					
				var configJson = {
					serviceName:"/GETDATA/getMessageUsingTemplate",
					callBackFunctionName:"callbackSendSMSAJAX",
					inputData:jsonObject,
				}
				getTemplateMessageandSendSMS(configJson);
			
			} */
	
	
    function updateSickFormStatus(inputjson){
    	//console.log("updateSickFormStatus inputJson >> " + JSON.stringify(inputjson));
    	
	    var payload2 = {
		        "hmode": "updateSickFormStatus",
		        inputjson: JSON.stringify(inputjson)
		    };

	    console.log("updateSickFormStatus inputJson >> " + payload2.hmode,JSON.stringify(inputjson));
	    
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload2,
	        dataType: 'json',
	        success: function(response) {
	            console.log('Second request success:', response);
	        }
	    });
    	}
    
	
	function saveFormData(formID  , isAttendedFlag ) {
	    document.getElementById('sickFormDetails').style.display = 'none';
		  //alert(isAttendedFlag);
		  var patMCSeatId = document.querySelector('.patSeatId').textContent;
		  var patMCVisitNo = document.querySelector('.patEpisodeVisitNo').textContent;
		  var patMobileNo = document.querySelector('.mobileNo').textContent;
		  var hospitalName = document.querySelector('#strHospitalName').textContent;
		  
		 // alert(hospitalName);
		// var patMobileNo = mobileElement.textContent || mobileElement.innerText;
		  
		// alert("11  > "+patMobileNo);
	    // Get form elements
	    var patCrNo = globalPatCrNo;
	    var episodeCode = globalPatEpisodeCode;
	    //var wellnessCenter = hospitalName;
		//var patConsultantName = globalpatConsultantName
		//alert("globalpatConsultantName", globalpatConsultantName);
	    console.log("hospitalName  >> ", hospitalName);
	    var illnessField = document.getElementById('illness');
	    var remarksField = document.getElementById('remarks');
	    var designationField = document.getElementById('designation');
	    //var hospitalName = hospitalName;
	    
	    var illness = illnessField.value;
	    var remarks = remarksField.value;
	    var designation = designationField.value;
	    var absenceFrom = "2025-02-14";
	    var absenceTo = "2025-02-14";
	    var effectiveDate = document.getElementById('effectiveDate').value;

	    function parseAndFormatDate(dateStr) {
	        if (!dateStr) return null;
	        const [year, month, day] = dateStr.split('-');
	        const date = new Date(Date.UTC(year, month - 1, day));
	        return date.toISOString();
	    }

	    var absenceFromISO = parseAndFormatDate(absenceFrom);
	    var absenceToISO = parseAndFormatDate(absenceTo);

	    if (!absenceFromISO || !absenceToISO || !effectiveDate) {
	        return;
	    }  
	    console.log("effectiveDate is a valid date");

	    patCrNo = Number(patCrNo);
	    episodeCode = Number(episodeCode);

	    console.log("formID... " + typeof(formID));

	    if (!formID || !illness || !designation || !effectiveDate || !patCrNo || !episodeCode || !absenceFrom || !absenceTo) {
	        alert("Please fill in all fields.");
	        return;
	    }

	    // Concatenating illness and remarks with "^"
	    var illnessWithRemarks = illness + "^" + remarks;
	    var patConsultantName = globalpatConsultantName + "^" + document.getElementById('varMCHospName').value;	
	    var inputjson = {
	        puk: patCrNo,
	        episodeCode: episodeCode,
	        formID: formID,
	        illness: illnessWithRemarks, // Updated field
	        //wellnessCenter:wellnessCenter,
	        designation: designation,
	        absenceFrom: absenceFrom,
	        absenceTo: absenceTo,
	        effectiveDate: effectiveDate,
	        mcStatus:0,
	        consultantName:patConsultantName,
	        seatId:document.querySelector('.patSeatId').textContent,
	        visitNo:document.querySelector('.patEpisodeVisitNo').textContent,
	        isAttended:isAttendedFlag
	    };

	    console.log("Final JSON:", JSON.stringify(inputjson));
	

	    // Construct the final payload
	    var payload = {
	        hmode: "saveSickFormData",
	        inputjson: JSON.stringify(inputjson)

	    };
	    console.log("Payload being posted:", payload);
	    
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            if (response.message === "success") {
	               console.log("Form data saved successfully!");
	               
	                // ✅ **Clear input fields after successful save**
	                illnessField.value = "";
	                designationField.value = "";
	                remarks.value = "";
	                //var formType = "Medical"
	                getMedicalFromsDtls(inputjson);
	                //sendMesageConfirm(formType);
	            } else {
	                alert("Failed to save form data: " + (response.message || "Unknown error"));
	                return;
	            }
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	            alert("An error occurred while saving form data. Please try again.");
	        }
	    });
        
	}
	
	function openForm3Modal(formID) {
		
	    // Validate required fields
	    var illness = document.getElementById('illness').value.trim();
	    var designation = document.getElementById('designation').value.trim();
	    var effectiveDate = document.getElementById('effectiveDate').value.trim();

	    if (!illness || !designation || !effectiveDate) {
	        alert("Please fill in all required fields before proceeding.");
	        return; // 🚨 Stop execution if any field is missing
	    }
		
	    if ( confirm("Do you want to make this patient as Attended") ){
	    	saveFormData(formID , 1);
	    }else{
	    	saveFormData(formID , 0);
	    }
	  
	    // Hide the sickFitModal
	    $('#sickFitModal').modal('hide');
	    // Ensure form3 is visible as a block element
	    $('#form3').css('display', 'block');
	    // Show the modal properly
	    $('#form3').modal('show');
	    // Handle close button inside form3
	    $('#form3 button[data-bs-dismiss="modal"]').click(function() {
	        $('#form3').modal('hide');
	        location.reload();
	    });
	}

	/*function sendMesageConfirm(formType){
		//alert( " correct place ");
		  var mobileElement = document.querySelector('.mobileNo');
		  var patMobileNo = mobileElement.textContent || mobileElement.innerText;
		//alert("inside sms");
		  console.log(formType)
	//	alert("11  > "+patMobileNo);

			//var formType = "Fittness "
			const data = new Array(formType);
			const mobileNumbers = new Array(patMobileNo);
			jsonObject = {
					"templateId":"",
					  "data":[],
		      	    "mobileNumbers":[],
				}
			jsonObject.data = data;
			jsonObject.mobileNumbers = mobileNumbers;
			jsonObject.templateId = "1107174437125596219";
					
				var configJson = {
					serviceName:"/GETDATA/getMessageUsingTemplate",
					callBackFunctionName:"callbackSendSMSAJAX",
					inputData:jsonObject,
				}
				//getTemplateMessageandSendSMS(configJson);
			
			}*/
	
	function saveLeaveExtDtls(button) {
		

	    var $row = $(button).closest('tr');
	    var pukE = $row.find('.puk').val();
	    var episodeCodeE = $row.find('.episodeCode').val();
	    var illnessE = $row.find('.illness').text(); 
	    var tempMedNoE = $row.find('.gnumMedNo').val();
	    console.log("tempMedNoE saveLeaveExtDtls  >>> ", $row.find('.gnumMedNo').val())
	    var tempEffectiveDate = $row.find('.effectiveDate').val().split(' ')[0];
	    var absenceDays = parseInt($row.find('.designation').val()); // Getting absenceDays

	    var effectiveDate = new Date(tempEffectiveDate);
	    effectiveDate.setDate(effectiveDate.getDate() + absenceDays);

	    var newEffectiveDate = effectiveDate.toISOString().split('T')[0];

	    console.log("New Effective Date:", newEffectiveDate);
	    
	    document.getElementById('sickLeaveExt').style.display = 'block';
	    document.getElementById('patDiagnosisDiv').style.display = 'none';

	    // Prefill values in the form fields
	    document.getElementById('illnessE').value = illnessE;
	    document.getElementById('effectiveDateE').value = newEffectiveDate;
	    document.getElementById('tempMedNoEHidden').value = tempMedNoE;
	    
	}



	
	function leaveExtSaveDtls(button) {
		
	    var patCrNo = globalPatCrNo;
	    var episodeCode = globalPatEpisodeCode;
		//var patConsultantName = globalpatConsultantName
		//alert("globalpatConsultantName", globalpatConsultantName);
	    console.log("saveFormData  >> ");
	    var illnessField = document.getElementById('illnessE');
	    var remarksField = document.getElementById('remarksE');
	    var tempMedNoField = document.getElementById('tempMedNoEHidden');
	    var designationField = document.getElementById('designationE');
	   // console.log("tempMedNoField   >>>  " , tempMedNoField)
	    var illness = illnessField.value;
	    var remarks = remarksField.value;
	    var tempMedNo = tempMedNoField.value;
	    console.log("hospitalName   >>>  " , hospitalName)
	    var designation = designationField.value;
	    var absenceFrom = "2025-02-14";
	    var absenceTo = "2025-02-14";
	    var effectiveDate = document.getElementById('effectiveDateE').value;
	    
	    function parseAndFormatDate(dateStr) {
	        if (!dateStr) return null;
	        const [year, month, day] = dateStr.split('-');
	        const date = new Date(Date.UTC(year, month - 1, day));
	        return date.toISOString();
	    }

	    var absenceFromISO = parseAndFormatDate(absenceFrom);
	    var absenceToISO = parseAndFormatDate(absenceTo);

	    if (!absenceFromISO || !absenceToISO || !effectiveDate) {
	        return;
	    }  
	    console.log("effectiveDate is a valid date");

	    patCrNo = Number(patCrNo);
	    episodeCode = Number(episodeCode);

	    //console.log("formID... " + typeof(formID));

	    if ( !illness || !designation || !effectiveDate || !patCrNo || !episodeCode || !absenceFrom || !absenceTo) {
	        alert("Please fill in all fields.");
	        return;
	    }

	    // Concatenating illness and remarks with "^"
	    var illnessWithRemarks = illness + "^" + remarks + "^"+ tempMedNo;
	    var patConsultantName = globalpatConsultantName + "^" + document.getElementById('varMCHospName').value;	
	    
	    if ( confirm("Do you want to make this patient as Attended") ){
		   	var isAttendedFlag = 1;
	    }else{
	    	var isAttendedFlag = 0;
	    }
	    
	    var inputjson = {
	        puk: patCrNo,
	        episodeCode: episodeCode,
	        formID: 6,
	        illness: illnessWithRemarks,
	        designation: designation,
	        absenceFrom: absenceFrom,
	        absenceTo: absenceTo,
	        effectiveDate: effectiveDate,
	        mcStatus:1,
	        fcStatus:0,
	        tempGnumMedNo:tempMedNo,
	        consultantName:patConsultantName,
	        seatId:document.querySelector('.patSeatId').textContent,
	        visitNo:document.querySelector('.patEpisodeVisitNo').textContent,
	        isAttended:isAttendedFlag
	    };

	    updateLeaveExtStatus(inputjson)
			   // console.log("Final JSON  leaveExtSaveDtls:", JSON.stringify(inputjson));
	

	    // Construct the final payload
	    var payload = {
	        hmode: "saveSickFormData",
	        inputjson: JSON.stringify(inputjson)

	    };
	    console.log("Payload being posted saveFittnessDtls:", payload);
	    
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            if (response.message === "success") {
	               console.log("Form data saved successfully!"); 
	               
	               //sendMesageConfirm(formType);  
	               location.reload();
	            } else {
	                alert("Failed to saveFittnessDtls: " + (response.message || "Unknown error"));
	            }
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	            alert("An error occurred while saving form data. Please try again.");
	        }
	    });
        
	}
	
	
    function updateLeaveExtStatus(inputjson){
    	//console.log("updateSickFormStatus inputJson >> " + JSON.stringify(inputjson));
    	
	    var payload2 = {
		        "hmode": "updateSickFormStatus",
		        inputjson: JSON.stringify(inputjson)
		    };

	    console.log("updateSickFormStatus inputJson >> " + payload2.hmode,JSON.stringify(inputjson));
	    
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload2,
	        dataType: 'json',
	        success: function(response) {
	            console.log('Second request success:', response);
	        }
	    });
    	}
	
	function getMedicalFromsDtls(inputjson){
		
//		var patName = globalPatName;
		//alert("1 successfully!");
		var patConsultantName = globalpatConsultantName;
	    var parentWellnessCenter = globalparentWellnessCenter;

	    var inputJson = JSON.stringify({
	        formId: inputjson.formID,
	        episodeCode: inputjson.episodeCode,
	        puk: inputjson.puk,
	        entryDate: 0,
	        gnumMedNo:0,
	        tempGnumMedNo:0
	    });

	    var payload = {
	        "hmode": "getMedFromsRecords",
	        "modeval": "1",
	        inputJson: inputJson
	    };

	    console.log("getMedicalFromsDtls inputJson >> " + inputJson);

	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            console.log("Server Response getMedicalFromsDtls:  ", response);

	            if (response.message === "success" && response.data.length > 0) {
	                var item = response.data[0];
	                
	                console.log("item.orgname   >>  ",  item.orgname);

	                function formatDateTimeIST(dateInput) {
	                    let options = {
	                        year: 'numeric',
	                        month: '2-digit',
	                        day: '2-digit',
	                        hour: '2-digit',
	                        minute: '2-digit',
	                        second: '2-digit',
	                        hour12: true,
	                        timeZone: 'Asia/Kolkata'  // Indian Standard Time
	                    };
	                    return new Date(dateInput).toLocaleString('en-IN', options);
	                }

	                function formatDate(dateInput) {
	                    var date = new Date(dateInput);
	                    var day = ('0' + date.getDate()).slice(-2);
	                    var month = ('0' + (date.getMonth() + 1)).slice(-2);
	                    var year = date.getFullYear();
	                    return day + '/' + month + '/' + year;
	                }

	                var absenceTo = formatDate(item.absenceTo);
	                var absenceFrom = formatDate(item.absenceFrom);
	                var effectiveDate = formatDate(item.effectiveDate);

	                // Format current date-time in IST
	                var currentDateTimeIST = formatDateTimeIST(new Date());
	                
	                document.querySelectorAll("#illnessId").forEach(el => {
	                    let illnessText = item.illness || "N/A";

	                    // Split illness and remarks by '^'
	                    let [illness, remarks] = illnessText.split("^");

	                    remarks = remarks ? remarks.trim() : "N/A";

	                    // Set illness in #illnessId
	                    el.innerText = illness;
	                    console.log("illness",illness);
	                });

	                // Set remarks in #remarksId
	                document.querySelectorAll("#remarksId").forEach(el => {
	                    let illnessText = item.illness || "N/A";

	                    // Split illness and remarks by '^'
	                    let [illness, remarks] = illnessText.split("^");

	                    // Handle missing values
	                    remarks = remarks ? remarks.trim() : "N/A";

	                    el.innerText = remarks;
	                    
	                    console.log("remarks",remarks);
	                });
	                if (item.orgname != null) {
	                    //alert("11");
	                    // Update the text content of the servingID span
	                    document.querySelectorAll("#orgNameID").forEach(el => {
	                        el.textContent = "of "+ item.orgname + " (Ministry/ Office)";
	                        console.log("orgname  >>>  . > > > > ",el.textContent)
	                    });

	                    // Update the text content of the servingHinID span
	                    document.querySelectorAll("#orgNameIDHin").forEach(el => {
	                        el.textContent = item.orgname +" (मंत्रालय / कायालय) का  ";
	                    });
	                }
	                document.querySelectorAll("#medCertiNoID").forEach(el => {el.innerText = item.gnumMedNo || "N/A";});
	                document.querySelectorAll("#designationId").forEach(el => {el.innerText = (item.designation ? item.designation : "N/A") + "/Days"});
	                document.querySelectorAll("#effective-date").forEach(el => {el.innerText = effectiveDate || "N/A";});
	                document.getElementById("current-date").innerText = currentDateTimeIST.split(",")[0];
	                document.getElementById("timeMcId").innerText = currentDateTimeIST.split(",")[1];
	                document.getElementById("currentDateFcId").innerText = currentDateTimeIST.split(",")[0];
	                document.getElementById("timeFcId").innerText = currentDateTimeIST.split(",")[1];
	                document.querySelectorAll("#printedBy").forEach(el => {el.innerText = patConsultantName || "N/A";});
	                document.querySelectorAll("#consultant-name").forEach(el => {el.innerText = item.docName || "N/A";});
	                //var patName = document.getElementById('patNameId').value;
	                document.querySelectorAll("#patient-name").forEach(el => {el.innerText = mcfcpatName;});
	                document.querySelectorAll("#benId").forEach(el => {el.innerText = item.puk || "N/A";});

	                //document.getElementById("patNameFCId").innerText = patName;
	                document.querySelectorAll("#patNameFCId").forEach(el => {el.innerText = patName || "N/A";});
	                //console.log("getReprintDataForMCForm  patname>>"+patName );
	                
	                //console.log("Updated Modal Fields Successfully with IST Date-Time: ", currentDateTimeIST);
	            }
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	        }
	    });
	}
	
	function getLeaveExtDtls(button){
		
		//var patName = globalPatName;
	    var $row = $(button).closest('tr');
	    //var $row = $(element).closest('tr'); 
	    var patConsultantName = globalpatConsultantName;
	    var puk = $row.find('.puk').val();
	    var tempMedNo = $row.find('.tempMedNo').val();
	    var episodeCode = $row.find('.episodeCode').val();
	    //var designation = $row.find('.designation').val();
	    var illness = $row.find('.illness').text(); 
	    var entryDate = $row.find('.entryDate').val().split(' ')[0];
	    var tempGnumMedNo = $row.find('.gnumMedNo').val();
	    
	   // var designation = tempGnumMedNo;

	    var inputJson = JSON.stringify({
	        formId: 6,
	        episodeCode: episodeCode,
	        puk: puk,
	        entryDate: entryDate,
	        gnumMedNo:0,
			tempGnumMedNo:tempGnumMedNo,
	    });

	    var payload = {
	        "hmode": "getMedFromsRecords",
	        "modeval": "4",
	        inputJson: inputJson
	    };

	    console.log("getLeaveExtDtls inputJson >> " + inputJson);
	    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            console.log("Server Response getLeaveExtDtls:  ", response);
	            
                var item = response.data[0];
        		

                function formatDateTimeIST(dateInput) {
                    let options = {
                        year: 'numeric',
                        month: '2-digit',
                        day: '2-digit',
                        hour: '2-digit',
                        minute: '2-digit',
                        second: '2-digit',
                        hour12: true,
                        timeZone: 'Asia/Kolkata'  // Indian Standard Time
                    };
                    return new Date(dateInput).toLocaleString('en-IN', options);
                }
                function formatDate(dateInput) {
                    var date = new Date(dateInput);
                    var day = ('0' + date.getDate()).slice(-2);
                    var month = ('0' + (date.getMonth() + 1)).slice(-2);
                    var year = date.getFullYear();
                    return day + '/' + month + '/' + year;
                }

                var absenceTo = formatDate(item.absenceTo);
                var absenceFrom = formatDate(item.absenceFrom);
                var effectiveDate = formatDate(item.effectiveDate);

                // Format current date-time in IST
                var currentDateTimeIST = formatDateTimeIST(new Date());
                
                document.querySelectorAll("#illnessMCXId").forEach(el => {
                    let illnessText = item.illness || "N/A";

                    // Split illness and remarks by '^'
                    let [illness, remarks] = illnessText.split("^");

                    remarks = remarks ? remarks.trim() : "N/A";

                    // Set illness in #illnessId
                    el.innerText = illness;
                    console.log("illness",illness);
                });

                // Set remarks in #remarksId
                document.querySelectorAll("#remarksMCXId").forEach(el => {
                    let illnessText = item.illness || "N/A";

                    // Split illness and remarks by '^'
                    let [illness, remarks] = illnessText.split("^");

                    // Handle missing values
                    remarks = remarks ? remarks.trim() : "N/A";

                    el.innerText = remarks;
                    
                    console.log("remarks",remarks);
                });
                
                // Format current date-time in IST
                var currentDateTimeIST = formatDateTimeIST(new Date());
                
                if (typeof item.orgname === 'undefined') {
                    //alert("11");
                    // Update the text content of the servingID span
                    document.querySelectorAll("#servingMCXId").forEach(el => {
                        el.textContent = "IN RESPECT OF GAZETTED OFFICERS / NON - GAZETTED OFFICERS";
                    });

                    // Update the text content of the servingHinID span
                    document.querySelectorAll("#servingHinMCXId").forEach(el => {
                        el.textContent = "के लिए राजपत्रित / गैर-राजपत्रित अधिकारी हेतु चिकित्सा प्रमाण पत्र";
                    });
                }
                
                document.querySelectorAll("#medCertiMCXId").forEach(el => {el.innerText = item.gnumMedNo || "N/A";});
                document.querySelectorAll("#effective-date").forEach(el => {el.innerText = effectiveDate || "N/A";});
                document.querySelectorAll("#designationMCXId").forEach(el => {el.innerText = (item.designation ? item.designation : "N/A") + "/Days"});
                document.getElementById("currentDateMCXId").innerText = currentDateTimeIST.split(",")[0];
                document.getElementById("timeMCXId").innerText = currentDateTimeIST.split(",")[1];
                //document.getElementById("currentDateMCXId").innerText = currentDateTimeIST;
                document.querySelectorAll("#printedBy").forEach(el => {el.innerText = patConsultantName || "N/A";});
                document.querySelectorAll("#consultant-name").forEach(el => {el.innerText = item.docName || "N/A";});
                var patName = document.getElementById('patNameId').value;
                document.querySelectorAll("#benMCXId").forEach(el => {el.innerText = item.puk || "N/A";});
                document.querySelectorAll("#orgNameMCXId").forEach(el => {
                    if (item.orgname) {
                        el.innerHTML = `Department: <span style="text-decoration: underline;">${item.orgname}</span>`;
                    } else {
                        el.innerHTML = "";
                    }
                });

                document.querySelectorAll("#patNameMCXId").forEach(el => {el.innerText = patName || "N/A";});
                console.log("getReprintDataForMCForm  patname>>"+patName );
		        
/*                var text = item.gnumMedNo; 
                var elementId = "patQrCode"; 

                QRCode.toCanvas(document.getElementById(elementId), text, function (error) {
                  if (error) console.error(error);
                  console.log("QR code generated!");
                });*/
			    document.getElementById('sickFormDetails').style.display = 'none';
	            
	    	    $('#sickFitModal').modal('hide');
	    	    // Ensure form3 is visible as a block element
	    	    $('#form6').css('display', 'block');
	    	    // Show the modal properly
	    	    $('#form6').modal('show');
	    	    // Handle close button inside form3
	    	    $('#form6 button[data-bs-dismiss="modal"]').click(function() {
	    	        $('#form6').modal('hide');
	    	        location.reload();
	    	    });
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	        }
	    });
	}
	
	
	function getFittnessDtls( button) {
	    var $row = $(button).closest('tr');
	    //var $row = $(element).closest('tr'); 
	    var patConsultantName = globalpatConsultantName;
	    var puk = $row.find('.puk').val();
	    var episodeCode = $row.find('.episodeCode').val();
	    var illness = $row.find('.illness').text(); 
	    var entryDate = $row.find('.entryDate').val().split(' ')[0];
	    var tempGnumMedNo = $row.find('.gnumMedNo').val();

	    console.log("Puk:", puk);
	    console.log("Episode Code:", episodeCode);
	    console.log("Illness:", illness);
	    console.log("Entry Date:", entryDate);
	    console.log("GnumMedNo:", tempGnumMedNo);
		
		//alert("1 successfully!");

	    var inputJson = JSON.stringify({
	        formId: 5,
	        episodeCode: episodeCode,
	        puk: puk,
	        entryDate: entryDate,
	        gnumMedNo:0,
	        mcStatus:1,
			tempGnumMedNo:tempGnumMedNo
	    });

	    var payload = {
	        "hmode": "getMedFromsRecords",
	        "modeval": "4",
	        inputJson: inputJson
	    };

	    
    $.ajax({
	        url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
	        type: 'POST',
	        data: payload,
	        async: true,
	        dataType: 'json',
	        success: function (response) {
	            console.log("Server Response getFittnessDtls:  ", response);

	            if (response.message === "success" && response.data.length > 0) {
	                var item = response.data[0];

	                function formatDateTimeIST(dateInput) {
	                    let options = {
	                        year: 'numeric',
	                        month: '2-digit',
	                        day: '2-digit',
	                        hour: '2-digit',
	                        minute: '2-digit',
	                        second: '2-digit',
	                        hour12: true,
	                        timeZone: 'Asia/Kolkata'  // Indian Standard Time
	                    };
	                    return new Date(dateInput).toLocaleString('en-IN', options);
	                }
	                
	                // Format current date-time in IST
	                var currentDateTimeIST = formatDateTimeIST(new Date());

	                console.log("beneficiery id >>>  .  . ",item.puk);
	                document.querySelectorAll("#medCertiFCId").forEach(el => {el.innerText = item.gnumMedNo || "N/A";});
	                document.querySelectorAll("#effective-date").forEach(el => {el.innerText = effectiveDate || "N/A";});
	                document.getElementById("current-date").innerText = currentDateTimeIST.split(",")[0];
	                document.getElementById("timeMcId").innerText = currentDateTimeIST.split(",")[1];
	                document.getElementById("currentDateFcId").innerText = currentDateTimeIST.split(",")[0];
	                document.getElementById("timeFcId").innerText = currentDateTimeIST.split(",")[1];
	                document.querySelectorAll("#printedBy").forEach(el => {el.innerText = patConsultantName || "N/A";});
	                document.querySelectorAll("#consultant-name").forEach(el => {el.innerText = item.docName || "N/A";});
	                var patName = document.getElementById('patNameId').value;
	                document.querySelectorAll("#benFCId").forEach(el => {el.innerText = item.puk || "N/A";});
	                
	                if (typeof item.orgname === 'undefined') {
	                    //alert("11");
	                    // Update the text content of the servingID span
	                    document.querySelectorAll("#servingFCId").forEach(el => {
	                        el.textContent = " TO RETURN TO DUTY";
	                    });

	                    // Update the text content of the servingHinID span
	                    document.querySelectorAll("#servingHinFCId").forEach(el => {
	                        el.textContent = "ड्यूटी पर लौटने के लिए";
	                    });
	                }
/*	                document.querySelectorAll("#orgNameFCId").forEach(el => {
	                    if (item.orgname) {
	                        el.innerHTML = `Department: <span style="text-decoration: underline;">${item.orgname}</span>`;
	                    } else {
	                        el.innerHTML = "";
	                    }
	                });*/
	                //var  orgname = "Ministry of Defence";
	                if (item.orgname != null) {
	                    //alert("11");
	                    // Update the text content of the servingID span
	                    document.querySelectorAll("#orgNameFCId").forEach(el => {
	                        el.textContent = "of the "+ item.orgname + " (Ministry/ Office)";
	                        console.log("item.orgname  >>>  . > > > > ",el.textContent);
	                    });

	                    // Update the text content of the servingHinID span
	                    document.querySelectorAll("#orgNameFCIdHin").forEach(el => {
	                        el.textContent = item.orgname +" (मंत्रालय / कायालय) के  ";
	                        console.log("item.orgname  >>>  . > > > > ",el.textContent)
	                    });
	                }

	                document.querySelectorAll("#patNameFCId").forEach(el => {el.innerText = patName || "N/A";});
	                console.log("getReprintDataForMCForm  patname>>"+patName );
			        
				    document.getElementById('sickFormDetails').style.display = 'none';
				    //document.getElementById('patDiagnosisDiv').style.display = 'none';
				    
					  $('#sickFitModal').modal('hide');
					  $('#form5').modal('hide');
					  $('#form5').modal('show');
					  $('#form5 button[data-bs-dismiss="modal"]').click(function() {
						    $('#form5').modal('hide');
						    location.reload();
						});
	                //console.log("Updated Modal Fields Successfully with IST Date-Time: ", currentDateTimeIST);
	            }
	        },
	        error: function (xhr, status, error) {
	            console.error("Error:", error);
	        }
	    });
    }

	  function generateTable(patientData) {
		  
		  var entryDate = new Date();

		var year = entryDate.getFullYear();
		var month = (entryDate.getMonth() + 1).toString().padStart(2, '0');
		var day = entryDate.getDate().toString().padStart(2, '0');

		entryDate = `${year}-${month}-${day}`;
		  
		    var inputJson = JSON.stringify({
		    	formId:0,
		    	episodeCode:0,
		    	puk: patientData.crNo,
		    	entryDate:entryDate,
		    	gnumMedNo:0,
		    	tempGnumMedNo:0
		    });

		    console.log("generateTable inputJson >> " + inputJson);
			var payload={
					"hmode": "getMedFromsRecords",
					"modeval": "2",
					inputJson: inputJson
					}
			console.log("generateTablePayload being posted from :", payload);
		    $.ajax({
		      url: '/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
		        type: 'POST',
		        data: payload,
		        async: true,
		        dataType: 'json',
		      success: function (response) {
		            console.log("Server Response:", response);

		            if (response.data && response.data.length > 0) {
		                renderTable(response.data, patientData);
		            } else {
		                console.warn("No data found.");
		                $("#generalDiagnosisTable tbody").html("<tr><td colspan='3' class='text-center'>No records available.</td></tr>");
		            }
		        },
		        error: function (xhr, status, error) {
		            console.error("Error:", error);
		            //alert("");
		        }
		    });
		  }
	  
	  function renderTable(data, patientData) {
		 // alert(1);
		    var patName = (patientData.name && typeof patientData.name === 'string') 
		        ? patientData.name 
		        : (patientData.name.textContent || patientData.name.innerText || '');
		    
		    var patMobNO = (patientData.patMobileNo && typeof patientData.patMobileNo === 'string') 
	        ? patientData.patMobileNo 
	        : (patientData.patMobileNo.textContent || patientData.patMobileNo.innerText || '');

		    $("#patNameId").val(patName);

		    var generalTableHtml = "";
		    var medicalBoardTableHtml = "";

		    var generalTheadHtml = 
		        "<tr><th>Effective Date</th><th>Diagnosed Illness</th><th>Reprint Medical Certificate</th><th>Issue Leave Extention</th><th>Issue Fitness Certificate</th></tr>";

		    var medicalBoardTheadHtml = 
		        "<tr><th>Medical Board Members</th><th>Effective Date</th><th>Reprint</th></tr>";

		   // var patMobNO = patientData.mobileNo;
		    
		    console.log("patMobNO  >> " +patMobNO);
		    data.forEach(function (record) {
		        // Extract medical numbers
		        var tempMedNo = record.illness.split("^")[2];
		        var gnumMedNo = record.gnumMedNo;

		        // Date formatting function
		        function formatDate(dateInput) {
		            var date = new Date(dateInput);
		            var day = ('0' + date.getDate()).slice(-2);
		            var month = ('0' + (date.getMonth() + 1)).slice(-2);
		            var year = date.getFullYear();
		            return day + '/' + month + '/' + year;
		        }

		        var effectiveDate = formatDate(record.effectiveDate);

		        
		        var medicCertificateExtention = "<td>";

		        // Determine visibility based on mcStatus
		        if (record.mcStatus === "1") {
		            // Hide save buttons, show reprint buttons
		            medicCertificateExtention += 
		                "<button type='button' class='btn btn-outline-success btn-sm' onclick='getLeaveExtDtls(this)'>Reprint</button>";

		        } else if (record.mcStatus === "0") {
		            // Hide reprint, show saveLeaveExtDtls
		            medicCertificateExtention += 
		            	"<button type='button' class='btn btn-outline-success btn-sm' onclick='saveLeaveExtDtls(this)'>Generate</button>" ;

		        } 
		        
		        var fitMedicCertificate = "<td>";
		        if (record.fcStatus === "1") {
		            // Hide save buttons, show reprint buttons
		        	fitMedicCertificate += 
		                "<button type='button' class='btn btn-outline-success btn-sm' onclick='getFittnessDtls(this)'>Reprint</button>";
		        } else if (record.fcStatus === "0") {
		            // Hide reprint show saveFittnessDtls
		           fitMedicCertificate += 
		                "<button type='button' class='btn btn-outline-success btn-sm' onclick='saveFittnessDtls(this)'>Generate</button>";
		        } 
		        // Medical Board Table HTML generation
		        if (parseInt(record.formId, 10) === 5) {
		            medicalBoardTableHtml += 
		                "<tr>" +
		                    "<input type='hidden' class='puk' value='" + record.puk + "' />" +
		                    "<input type='hidden' class='formId' value='" + record.formId + "' />" +
		                    "<input type='hidden' class='episodeCode' value='" + record.episodecode + "' />" +
		                    "<input type='hidden' class='entryDate' value='" + record.entryDate + "' />" +
		                    "<button class='btn btn-primary btn-sm' onclick='getDataFromTableMCForm(this)'>Reprint</button>" +
		                "</tr>";
		        } 
		        // General Diagnoses Table HTML generation
		        else if (parseInt(record.formId, 10) === 3){
		            generalTableHtml += 
		                "<tr>" +
		                    "<td>" + effectiveDate + "</td>" +
		                    "<td class='illness'>" + (record.illness.split("^")[0] || '') + "</td>" + // Handling missing illness values
		                    "<td>" +
		                        "<input type='hidden' class='effectiveDate' value='" + record.effectiveDate + "' />" +
		                        "<input type='hidden' class='designation' value='" + record.designation + "' />" +
		                        "<input type='hidden' class='puk' value='" + record.puk + "' />" +
		                        "<input type='hidden' class='tempMedNo' value='" + record.illness + "' />" +
		                        "<input type='hidden' class='formId' value='" + record.formId + "' />" +
		                        "<input type='hidden' class='episodeCode' value='" + record.episodecode + "' />" +
		                        "<input type='hidden' class='entryDate' value='" + record.entryDate + "' />" +
		                        "<input type='hidden' class='gnumMedNo' value='" + record.gnumMedNo + "' />" +
		                        "<button class='btn btn-primary btn-sm' onclick='getDataFromTableMCForm(this)'>Reprint</button>" +
		                    "</td>" +
		                    medicCertificateExtention +
		                    fitMedicCertificate +
		                "</tr>";
		        }
		    });

		    // Inject the headers and body into the tables
		    $("#generalDiagnosisTable thead").html(generalTheadHtml);
		    $("#generalDiagnosisTable tbody").html(generalTableHtml);

		}

  
	  function getDataFromTableMCForm(buttonElement) {
		    
		    var row = $(buttonElement).closest('tr');

		    var puk= row.find('.puk').val();
		    var formId = row.find('.formId').val();
		    var episodeCode = row.find('.episodeCode').val();
		    var entryDate = row.find('.entryDate').val().split(' ')[0];
		    var gnumMedNo = row.find('.gnumMedNo').val();

		    var inputJson = JSON.stringify({
		    	puk:puk,
		        formId: formId,
		        episodeCode: episodeCode,
		        entryDate: entryDate,
		        gnumMedNo:gnumMedNo,
		        tempGnumMedNo:0
		    });

		    console.log(" getDataFromTableMCFormInput JSON:", inputJson);

		    getReprintDataForMCForm(inputJson);
		}

		function getReprintDataForMCForm(inputJson) {
			
			//var patName = globalPatName;
			var patConsultantName = globalpatConsultantName;
		    var parentWellnessCenter = globalparentWellnessCenter;
		    //alert("patname>> ",patName);
			var payload={
					"hmode": "getMedFromsRecords",
					"modeval": "3",
					inputJson: inputJson
					}
			 console.log("getReprintDataForMCForm inputJson >> " + inputJson);
			$.ajax(
					{ 
						url:'/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt',
				        type: 'POST',
				        data: payload,
				        async: true,
				        dataType: 'json',
				        success: function (response) {
								console.log("Server Response getReprintDataForMCForm:  ", response);
								
								
					            if (response.message === "success" && response.data.length > 0) {
					                var item = response.data[0];
					                

					                function formatDateTimeIST(dateInput) {
					                    let options = {
					                        year: 'numeric',
					                        month: '2-digit',
					                        day: '2-digit',
					                        hour: '2-digit',
					                        minute: '2-digit',
					                        second: '2-digit',
					                        hour12: true,
					                        timeZone: 'Asia/Kolkata'  // Indian Standard Time
					                    };
					                    return new Date(dateInput).toLocaleString('en-IN', options);
					                }

					                function formatDate(dateInput) {
					                    var date = new Date(dateInput);
					                    var day = ('0' + date.getDate()).slice(-2);
					                    var month = ('0' + (date.getMonth() + 1)).slice(-2);
					                    var year = date.getFullYear();
					                    return day + '/' + month + '/' + year;
					                }

					                var absenceTo = formatDate(item.absenceTo);
					                var absenceFrom = formatDate(item.absenceFrom);
					                var effectiveDate = formatDate(item.effectiveDate);

					                // Format current date-time in IST
					                var currentDateTimeIST = formatDateTimeIST(new Date());

					                document.querySelectorAll("#illnessId").forEach(el => {
					                    let illnessText = item.illness || "N/A";

					                    // Split illness and remarks by '^'
					                    let [illness, remarks] = illnessText.split("^");

					                    remarks = remarks ? remarks.trim() : "N/A";

					                    // Set illness in #illnessId
					                    el.innerText = illness;
					                    console.log("illness",illness);
					                });

					                // Set remarks in #remarksId
					                document.querySelectorAll("#remarksId").forEach(el => {
					                    let illnessText = item.illness || "N/A";

					                    // Split illness and remarks by '^'
					                    let [illness, remarks] = illnessText.split("^");

					                    // Handle missing values
					                    remarks = remarks ? remarks.trim() : "N/A";

					                    el.innerText = remarks;
					                    
					                    console.log("remarks",remarks);
					                });
					                //alert(1);
					                console.log("orgNameID", item.orgname );
					                //var  orgname = "Ministry of Defence";
					                
					                if (item.orgname != null) {
					                    //alert("11");
					                    // Update the text content of the servingID span
					                    document.querySelectorAll("#orgNameID").forEach(el => {
					                        el.textContent = "of "+ item.orgname + " (Ministry/ Office)";
					                        console.log("orgname  >>>  . > > > > ",el.textContent);
					                    });

					                    // Update the text content of the servingHinID span
					                    document.querySelectorAll("#orgNameIDHin").forEach(el => {
					                        el.textContent = item.orgname +" (मंत्रालय / कायालय) का  ";
					                        console.log("orgname  >>>  . > > > > ",el.textContent)
					                    });
					                }
					                
					                console.log("item.gnumMedNo   >>  ",item.gnumMedNo);
					                document.querySelectorAll("#medCertiNoID").forEach(el => {el.innerText = item.gnumMedNo || "N/A";});
					                document.querySelectorAll("#designationId").forEach(el => {el.innerText = (item.designation ? item.designation : "N/A") + "/Days"});
					                document.querySelectorAll("#effective-date").forEach(el => {el.innerText = effectiveDate || "N/A";});
					                document.getElementById("current-date").innerText = currentDateTimeIST.split(",")[0];
					                document.getElementById("timeMcId").innerText = currentDateTimeIST.split(",")[1];
					                document.getElementById("currentDateFcId").innerText = currentDateTimeIST.split(",")[0];
					                document.getElementById("timeFcId").innerText = currentDateTimeIST.split(",")[1];
					                document.querySelectorAll("#printedBy").forEach(el => {el.innerText = patConsultantName || "N/A";});
					                document.querySelectorAll("#consultant-name").forEach(el => {el.innerText = item.docName || "N/A";});
					                //var patName = document.getElementById('patNameId').value;
					                document.querySelectorAll("#patient-name").forEach(el => {el.innerText = mcfcpatName;});
					                document.querySelectorAll("#benId").forEach(el => {el.innerText = item.puk || "N/A";});
					                //document.querySelectorAll("#orgNameID").forEach(el => {el.innerText = item.orgname || "N/A";});
					                //document.getElementById("patNameFCId").innerText = patName;
					                document.querySelectorAll("#patNameFCId").forEach(el => {el.innerText = patName || "N/A";});
					                console.log("getReprintDataForMCForm  patname>>"+patName );
					                
					                
					                console.log("item.formId  "+item.formId);
				                
					                console.log("item.formId Type: ", typeof item.formId, "Value:", item.formId);

					                switch (parseInt(item.formId)) {
					                    case 3:
					                        console.log("item.formId === 3");
					                        $('#sickFitModal').modal('hide');
					                        $('#form3').modal('show');
						              		$('#form3 button[data-bs-dismiss="modal"]').click(function() {
						          			$('#form3').modal('hide');
						          			location.reload();
						          			});
					                        break;
					                    case 5:
					                      console.log("item.formId === 5");
					                      $('#sickFitModal').modal('hide');
					                      $('#form5').modal('show');
					              		  $('#form5 button[data-bs-dismiss="modal"]').click(function() {
					          			  $('#form5').modal('hide');
					          			  location.reload();
					          			});
					                        break;
					                    default:
					                        console.log("Unknown formId: ", item.formId);
					                        break;
					                }
				                
				            }

				        },
					        error: function (xhr, status, error) {
					            console.error("Error:", error);
					        }
					    });
		}

	  function printToPdfForMCForm() {
		  
		  $('#form3').modal('hide');
		  setTimeout(function () {
		    var printContents = document.getElementById('divPrintable').innerHTML;
		    var originalContents = document.body.innerHTML;

	        document.body.innerHTML = printContents;
	        window.print();

	        // Restore the original page content after printing
	        document.body.innerHTML = originalContents;
	        location.reload(); // Ensure proper reloading after printing

		  	}, 300);
		}
	  function printToPdfForMCForm1() {
		    // Hide the modal before printing
		    $('#form5').modal('hide');

		    // Allow the modal to fully close before proceeding (use a timeout)
		    setTimeout(function () {
		        var printContents = document.getElementById('divPrintable1').innerHTML;
		        var originalContents = document.body.innerHTML;

		        document.body.innerHTML = printContents;
		        window.print();

		        // Restore the original page content after printing
		        document.body.innerHTML = originalContents;
		        location.reload(); // Ensure proper reloading after printing

		    }, 300); // Small delay to allow the modal to close properly
		}
	  function printToPdfForMCForm2() {
		    // Hide the modal before printing
		    $('#form6').modal('hide');

		    // Allow the modal to fully close before proceeding (use a timeout)
		    setTimeout(function () {
		        var printContents = document.getElementById('divPrintable2').innerHTML;
		        var originalContents = document.body.innerHTML;

		        document.body.innerHTML = printContents;
		        window.print();

		        // Restore the original page content after printing
		        document.body.innerHTML = originalContents;
		        location.reload(); // Ensure proper reloading after printing

		    }, 300); // Small delay to allow the modal to close properly
		}


		function openopdPoolPatientListPage(){
			if($('#deptUnitName').val()==undefined  || $('#deptUnitName').val()=="")
				return;
			
			if($('.btnnewrx').length>0){
				
				swal({
					  title: "Status",
					  text: "Next Patient Can be called after current patient is attended/skipped",
					  icon: "warning", 
					}).then(function(willDelete) {
						return;
					});
				return;
			}
			var jsonbenIds={};
			$('.patCrNo').each(function(){
				var benId =$(this).text().trim();
				jsonbenIds[benId]=benId;
			});
			localStorage.setItem("attendedBenIds",JSON.stringify(jsonbenIds));
			
			var url="/HISDRDESK_MC/new_opd/transaction/DoctorDeskAction.cnt?hmode=OPEN_POOL_PATIENT&varSSOTicketGrantingTicket="+$('#varSSOTicketGrantingTicket').val();
			
			localStorage.setItem("departmentUnitDtl",$('#deptUnitName').val());
			
			$('#PoolPatientListModal').modal('hide');$('#PoolPatientListModalFrameId').remove();
			$('#PoolPatientListModal .modal-body').prepend('<iframe id="PoolPatientListModalFrameId" style="width:100%;height:80vh;margin-top:-28px" src="'+url+'"></iframe>');
			$('#PoolPatientListModal').modal('show'); 
		}

function OpenReferralModal(e){
		
	var patName = $(e).closest('.patientListBlock').find('.patName').text();
	var currentPatientDtl={
					"patCrNo":$(e).closest('.patientListBlock').find('.patCrNo').text(),
					"patName":$(e).closest('.patientListBlock').find('.patName').text(),
					"episodeCode":$(e).closest('.patientListBlock').find('.patEpisodeCode').text(),
					"patEpisodeVisitNo":$(e).closest('.patientListBlock').find('.patEpisodeVisitNo').text(),
					"hospitalCode": $(e).closest('.patientListBlock').find('.patHospitalCode').text(),
					"seatId":$(e).closest('.patientListBlock').find('.patSeatId').text(),															
					"patientPhotoName":$(e).closest('.patientListBlock').find('.patientPhotoName').text(),					
					"cardType":$(e).closest('.patientListBlock').find('.cardType').text(),
					"relation":$(e).closest('.patientListBlock').find('.relation').text(),
					"cardValidityDate":$(e).closest('.patientListBlock').find('.cardValidityDate').text(),
					"cardValidityStatus":$(e).closest('.patientListBlock').find('.cardValidityStatus').text(),
					"cardColor":$(e).closest('.patientListBlock').find('.cardColor').text(),
					"mobileNo":$(e).closest('.patientListBlock').find('.mobileNo').text(),
					"parentWellnessCenter":$(e).closest('.patientListBlock').find('.parentWellnessCenter').text(),
					"patDeptName":$(e).closest('.patientListBlock').find('.patDeptUnit').text(),
					"patGenAgeCat":$(e).closest('.patientListBlock').find('.patGenAgeCat').text(),
					"patAdd":$(e).closest('.patientListBlock').find('.patAdd').text()  								
				}
				
	localStorage.setItem("currentPatientDtl",JSON.stringify(currentPatientDtl));
	
		var url="/HISDRDESK_MC/new_opd/transaction/OPDReferralAction.cnt?varSSOTicketGrantingTicket="+$('#varSSOTicketGrantingTicket').val();
		
		$('#ReferralModal').modal('hide');$('#ReferralModalFrameId').remove();
		$('#ReferralModal .modal-body').prepend('<iframe id="ReferralModalFrameId" style="width:100%;height:86vh;" src="'+url+'"></iframe>');
		$('#ReferralModal').modal('show'); 
}				
function getPatientImg() {
   var crno="";
    if($('#patCrNoPrescriptionPanel').text()== null ){
    	return;
    }
    var fileName = $('#patientPhotoName').val();
    
    var fileExt = fileName.split(".")[1].toLowerCase();
  
	var currentPatientDtl=localStorage.getItem("currentPatientDtl");
	if(currentPatientDtl!=null && currentPatientDtl!=undefined){
		currentPatientDtl=JSON.parse(currentPatientDtl);
		crno =currentPatientDtl["patCrNo"]
	}
	else	
		return;
	if(crno=="")
		return	
   
   
   
    var urlShortName = '/HISDRDESK_MC/services/restful/search/getBenShortName?CrNo='+ crno;

    $.ajax({
        url: urlShortName,
        method: 'GET',
        success: function(result) {
            //console.log("API Response:", result);
            if (!result || result.length === 0) {
                alert("No patient record found for CrNo: " + $('#patCrNoPrescriptionPanel').text());
                return;
            }
            var shortName = result[0].shortname;
           // alert("Short Name: " + shortName);
            
            var url1 = '/HISDRDESK_MC/services/restful/patdata/getPatientBase64Image?shortName=' + shortName + '&fileName=' + fileName;
            

            $.ajax({
                url: url1,
                method: 'GET',
                success: function(result)             {
        			if(result["status"]=="1"){
        				var base64Img=result["base64Img"];
        				
        				if(fileExt=="jpg"){
        					base64Img="data:image/jpeg;base64," +base64Img
        				}
        				else if(fileExt=="png"){
        					base64Img="data:image/png;base64," +base64Img
        				}
        				$('#imgProfilePic').attr("src", base64Img);
        			}},
                error: function(xhr) {
                    console.error("Failed to load image:", xhr.responseText);
                    alert("Failed to load patient image.");
                }
            });
        },
        error: function(xhr) {
            console.error("Failed to fetch short name:", xhr.responseText);
           // alert("Failed to fetch patient details.");
        }
    });
}