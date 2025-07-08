

$(document).ready(function () {
	
	//initPage();
	 var Benid=$('#Benidvalue').val();
	 // alert("Benid>>>>>>>>>>"+Benid);
	  /*generateBarcode();*/
    //    alert("Benid>>>>>>>>>>"+Benid);
      /*    getfamilydetails();
	  */
	   
	   
	   
	      
  var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatemaincardholder",
    			 				
    			}
    		callService(configJson);
    		
    		
    		});
             
/*var primaryKeyFromListPage= $('#primaryKeyFromListPage').val();
	//alert("primaryKeyFromListPage>>>>>"+primaryKeyFromListPage);
	if(primaryKeyFromListPage!=""){
		var arrpk = decrypt(primaryKeyFromListPage).split("@");
		$('#BenId').val(arrpk[1]);
	
	   
	
	}else{
		hidePreloader();
	}
		
	 
	
	});*/
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
			var Benid=document.getElementById('BenId').value;

        
           if(Benid=='')
            {
             	alert("Plesae enter Benid");
	           return;
	
              }
                
            
  var configJson={
    				serviceName:"/getData/getmaincardholderdetails",
    				primaryKeys:[Benid],			
    				callBackFunctionName:"populatemaincardholder",
    			 				
    			}
    		callService(configJson);
              }
              
              
              
function Downloadcard(memberid, callback) {
    //alert("1111111111");
    
    $.ajax({
        url: 'services/restful/parliament/v1/BenDetails/getBeneficiaryCard',
        type: 'POST',
        contentType: 'application/json',  // Set content type to application/json
        data: JSON.stringify({ benId: memberid }),  // Send the file name as JSON
        success: function(response) {
        //    alert("response>>>>>>>>>>>>>>> " + JSON.stringify(response)); // Ensure response is in string format
            
            console.log('Data received:', response);

            // Assuming response.result contains the base64 PDF string
            if (response && response.result) {
                const base64PDF = response.result;
                //downloadBase64PDF(base64PDF, "memberid.pdf");
                
                base64ToImage(base64PDF);
            } else {
                console.error("Base64 PDF data not found in response.");
            }
            
            // Check if callback is a function before calling it
            if (typeof callback === 'function') {
                callback(response); // Call the callback function and pass the result
            } else {
                console.error('Callback is not a function');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            console.error('Status:', status);
            console.error('Response:', xhr.responseText);
            alert('An error occurred while processing your request.');
        }
    });
}

    function base64ToImage(base64String) {
            const img = new Image();  // Create a new <img> element
            img.src = "data:image/png;base64," + base64String;  // Set the source to Base64 string
            
            // Optional: Append the image to a specific element in the DOM
            document.getElementById('image-container').appendChild(img);
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

                //     alert("222222222"+json["DOB"]);
                  $('#cardname').text(json["FirstName"]);
                  $('#cardDob').text(json["DOB"]);
                     $('#cardbenid').text(json["BenId"]);
                     $('#cardbenidBack').text(json["BenId"]);
                     
                       $('#cardvalidupto').text(json["validupto"]);
        	    	$('#cardentitlement').text(json["gnum_short_nm"]);
        	    	$('#cardRelation').text(json["gstr_relation_name"]);
        	    	$("#cardfacility").text(json["gstr_fma_facility"]);
        	            	    
        	    	var encodedStr=json["gstr_entitlement_hindi"];
        	    	const decodedStr = decodeHtmlEntity(encodedStr);
        	    //	alert("decodedStr>>>>>>>>"+decodedStr);
        	    		$('#cardentitlementHindi').text(decodedStr);
        	    	$('#cardcardtype').text(json["gstr_cardtype_name"]);
        	    	var cardnamehindi=json["gstr_card_hindi_name"];
        	    	const decodedcardtypenamehindi= decodeHtmlEntity(cardnamehindi);
        	    		$('#cardtypenamehindi').text(decodedcardtypenamehindi);
        	    	//	alert("photoname>>>>>>>>>>"+json["photo"]);
        	    	
        	    		// Usage:
						    getFileFromFileName(json["Photoname"], json["gstr_hosp_short_name"], function(result) {

							var base64Image = "data:image/jpeg;base64," + result;
        	    	        $('#photo').attr('src', base64Image);
						  //  console.log("Base64 Image:", base64Image);  // Do something with the result
						   // alert("Base64 Image: " + base64Image);  // Use the result here
						});
        	    	
                    var color= json["gstr_card_color"].toLowerCase();  
                 //   alert("color"+color) ;
                     $('#cghsCard').addClass('cghs-card-'+color);
                     $('#cghsCardBack').addClass('cghs-cardback-'+color);
        	    	
        	    	
        	    	//alert("fma facility>>>>>>>>>>>>>>>>>>"+json["gstr_fma_facility"])
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
		//	 alert("1111111111");
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
	//	alert("img>>>>>>>>>>>"+img);
			$("#qrCode").html('<img src="'+img+'">');			 
	 
    
  }	 
  
  

function getFileFromFileName(fileName, hospname, callback) {
//	alert("getFileFromFileName"+fileName);
    $.ajax({
        url: 'services/restful/cardapi/v1/BenDetails/gettestimg',
        type: 'POST',
        contentType: 'application/json',    // Sending JSON
        dataType: 'text',                   // Expecting plain text response
        data: JSON.stringify({ 
            filename: fileName, 
            hospname: hospname 
        }),
        success: function(response) {
            console.log('Data received:', response);
            if (typeof callback === 'function') {
                callback(response);
            } else {
                console.warn('Callback is not a function.');
            }
        },
        error: function(xhr, status, error) {
            console.error('Error:', error);
            console.error('Status:', status);
            console.error('Response:', xhr.responseText);
            alert('An error occurred while processing your request.');
        }
    });
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

    
    function Downloadpdf()
      {
		//  alert("878788888");
            // Select the content to capture
            const content = document.getElementById("formContainer");
    // alert("content>>>>>>>>>>"+content);
html2canvas(content, {
    onrendered: function (canvas) {  // Callback method for older versions
        // Create a new jsPDF instance
        const { jsPDF } = window.jspdf;
        const doc = new jsPDF();

        // Define the width and height of the image based on the page size
        const pageWidth = doc.internal.pageSize.width;  // Get the width of the PDF page (A4 is 210mm)
        const pageHeight = doc.internal.pageSize.height; // Get the height of the PDF page (A4 is 297mm)

        // Set image width and height to fit within the page size
        const imgWidth = pageWidth - 20;  // Adjust image width to fit (20mm margin on both sides)
        const imgHeight = (canvas.height / canvas.width) * imgWidth;  // Maintain aspect ratio

        // Add the canvas image to the PDFF
        // X and Y position are set to 10mm to avoid overflow and keep the image within the page
        doc.addImage(canvas.toDataURL('image/png'), 'PNG', 10, 10, imgWidth, imgHeight);

        // Save the PDF with a name
        doc.save("card.pdf");
    }
});



        }