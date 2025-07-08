

$(document).ready(function () {
	
	initPage();
	
	   
var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		//alert("Primarykey>>>>>>>>>>"+arrpk);
		//alert(arrpk[0]);
		//alert(arrpk[1]);
		//alert(arrpk[2]);
		$('#BenId').val(arrpk[1]);
	//	var Benid=$('#BenId').val(arrpk[2]);
//	alert(Benid);
	  
	
	}else{
		hidePreloader();
	}
		
	  getfamilydetails();
	
	});
	
	
  function initPage(){
	hidePreloader();
	$("form").attr('autocomplete', 'off');
	$('#stepUL').empty();
	initValidation('ENTRYFORM');	
	initInputJson=$(':input').serializeArray();
	hidePreloader();
	new WOW().init();
	
	}
  
  	
    	function getfamilydetails()
   	{
		   //alert("11111111");
		var BenIdvalue=$('#patBenId').val();
  var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[BenIdvalue],			
    				callBackFunctionName:"populatemaincardholder",
    			 				
    			}
    		callService(configJson);
              }
              
  		
             	function populatemaincardholder(configJson, dataJson) {
			 //   alert("populatemaincardholder");
    	  //alert("configJson>>> " + JSON.stringify(configJson));
    	//  alert("dataJson>>>>>>>> " + JSON.stringify(dataJson));
    	   if (!dataJson || !dataJson.data || dataJson.data.length === 0) {
        	   // $('#applyplastccard').show();
    	    }
    	    else
        	    {
					
				 	       	   //alert("iiinnn else"); 	
    	
    	    if(dataJson["message"].indexOf("ERROR")<0){
        	    $.each(dataJson["data"], function(_, json){

               //    alert("222222222"+json["DOB"]);
                  $('#cardname').text(json["FirstName"]);
                  $('#cardDob').text(json["DOB"]);
                     $('#cardbenid').text(json["BenId"]);
                     $('#cardbenidBack').text(json["BenId"]);
                     
                       $('#cardvalidupto').text(json["validupto"]);
        	    	$('#cardentitlement').text(json["gnum_short_nm"]);
        	    	$('#cardRelation').text(json["gstr_relation_name"]);
        	            	    
        	    	var encodedStr=json["gstr_entitlement_hindi"];
        	    	const decodedStr = decodeHtmlEntity(encodedStr);
        	    //	alert("decodedStr>>>>>>>>"+decodedStr);
        	    		$('#cardentitlementHindi').text(decodedStr);
        	    	$('#cardcardtype').text(json["gstr_cardtype_name"]);
        	    	var cardnamehindi=json["gstr_card_hindi_name"];
        	    	const decodedcardtypenamehindi= decodeHtmlEntity(cardnamehindi);
        	    		$('#cardtypenamehindi').text(decodedcardtypenamehindi);
        	    	$('#photo').attr('src', json["photo"]);
                    var color= json["gstr_card_color"].toLowerCase();  
                 //   alert("color"+color) ;
                     $('#cghsCard').addClass('cghs-card-'+color);
                     $('#cghsCardBack').addClass('cghs-cardback-'+color);
        	    	
            	   });
            	    
            
        	    
        	}
    	    else{
    	    	showAlertMsg("Kindly enter valid range in field!", "danger","alertMsg");
    	    	return;
    	    }
        	    }    	    
    	  
    	  
    	}
	function decodeHtmlEntity(encodedStr) {
    var textarea = document.createElement('textarea');
    textarea.innerHTML = encodedStr;
    return textarea.value;
}
	
		
		 function generateBarcode() {
			 let Benid= $('#BenId').val();  // A string variable
       let concatenatedValue = `${Benid}90456`;  // Concatenates using template literals
/*
    //var barcodeId = ; // Get barcode ID
    JsBarcode("#barcode", concatenatedValue, {
      format: "CODE128",     // Barcode format (other options: CODE39, EAN, UPC, etc.)
      lineColor: "#000000",  // Line color (black)
      width: 3,              // Barcode width
      height: 20,           // Barcode height
      displayValue: true     // Display barcode value
      
    });
    */
    
     $('#qrCode').qrcode(
				 {
					 //render: 'div',
					 width: 100,
					 height: 100,
					 text: concatenatedValue}
				 );
				 
	var canvas=$("#qrCode"+" "+"canvas")
			var img=canvas.get(0).toDataURL("image/png");
			$("#qrCode").html('<img src="'+img+'">');			 
	 
    
  }	 
  
  
    function hexToUtf8(hex) {
        let str = '';
        for (let i = 0; i < hex.length; i += 2) {
            let hexChar = hex.substring(i, i + 2);
            str += String.fromCharCode(parseInt(hexChar, 16));
        }
        return str;
    }
 
   function printIDCard() {
      var printContent = document.getElementById('idCard');
      var printWindow = window.open('', '', 'height=400,width=600');
      printWindow.document.write('<html><head><title>ID Card Print</title>');
      printWindow.document.write('<style>body {font-family: Arial, sans-serif;}');
      printWindow.document.write('.id-card {width: 350px; height: 200px; border: 2px solid #333; padding: 20px; display: flex; flex-direction: row; justify-content: space-between; background-color: #f4f4f4;}');
      printWindow.document.write('.id-card img {width: 70px; height: 70px; border-radius: 50%;}');
      printWindow.document.write('.id-info {display: flex; flex-direction: column; justify-content: center; margin-left: 20px;}');
      printWindow.document.write('.id-info h2 {margin: 0; font-size: 18px;}');
      printWindow.document.write('.id-info p {margin: 5px 0; font-size: 14px;}');
      printWindow.document.write('</style></head><body>');
      printWindow.document.write(printContent.outerHTML);
      printWindow.document.write('</body></html>');
      printWindow.document.close(); // Close the document
      printWindow.print(); // Trigger the print dialog
    }
