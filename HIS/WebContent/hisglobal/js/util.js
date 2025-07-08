
function printContent() {
		
		newwin=window.open('','printwin',"menubar=no,location=no,resizable=no,status=yes,left=100,top=100,width=950,height=700,scrollbars=yes");
		newwin.document.write('<html><head>');
		newwin.document.write('<style type="text/css"> .hidecontrol { display: none; } </style>\n');
		newwin.document.write((document.getElementsByTagName("head")[0]).innerHTML);
		newwin.document.write('\n');
		newwin.document.write('<script>\n');
		newwin.document.write('function chkstate(){ \n');
		newwin.document.write('window.close();\n');
		newwin.document.write('}\n');
		newwin.document.write('function print_win(){\n');
		newwin.document.write('window.print();\n');
		newwin.document.write('chkstate();\n');
		newwin.document.write('}\n');

		newwin.document.write('</script>\n');
		newwin.document.write('</head>\n');
		newwin.document.write('<body>\n');
		newwin.document.write((document.getElementsByTagName("body")[0]).innerHTML);
		newwin.document.write('</body>\n');
		newwin.document.write('<script>\n');
		 
		newwin.document.write('print_win();\n');
		newwin.document.write('</script>\n');
		newwin.document.write('</html>\n');
		newwin.document.close();
		
	}


	function downloadPdf(){
		
		var doc =new jsPDF();
		var elementHTML=$('#tblData').html();
		
		var specialElementHandlers={
				'#elementH':function(element ,renderer){
					return true ;
				}
		};
		
		doc.fromHTML(elementHTML, 15, 15 , {
			'width':170,
			'elementHandlers':specialElementHandlers
		});
		
		doc.save('document.pdf');
			
		}
		

	function exportTableTOExcel(tableID ,filename){
		
		 var downloadLink;
		    var dataType = 'application/vnd.ms-excel';
		    var tableSelect = document.getElementById(tableID);
		    var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');
		    
		    // Specify file name
		    filename = filename?filename+'.xls':'excel_data.xls';
		    
		    // Create download link element
		    downloadLink = document.createElement("a");
		    
		    document.body.appendChild(downloadLink);
		    
		    if(navigator.msSaveOrOpenBlob){
		        var blob = new Blob(['\ufeff', tableHTML], {
		            type: dataType
		        });
		        navigator.msSaveOrOpenBlob( blob, filename);
		    }else{
		        // Create a link to the file
		        downloadLink.href = 'data:' + dataType + ', ' + tableHTML;
		    
		        // Setting the file name
		        downloadLink.download = filename;
		        
		        //triggering the function
		        downloadLink.click();
		    }
		
	}


	function exportTableTOExcel1()
	{
		
		 
		$('#myForm').table2excel({
			exclude: ".noExl",
			name: document.getElementsByTagName("title")[0].innerHTML,
			filename:document.getElementsByTagName("title")[0].innerHTML
		});
		 
		
	}


	function downloadPdf1(){
		
		//Adding Content in printAreaValue so that is the hidden field does not append more than once and the buttons are available after pdf download.
		var printAreaValue = '<img onclick="printContent();" src="/HIS/hisglobal/images/printer_tab.jpg"  title = "Click Here to Print" style="cursor:pointer;"/> <img onclick="goBack();" src="/HIS/hisglobal/images/back_button.gif" title = "Click Here to Go Back" style="cursor:pointer;"/> <img onclick="downloadPdf1();" src="/HIS/hisglobal/images/pdf.png" title= "Save as PDF" style="cursor:pointer;"/>&nbsp;<img onclick="exportTableTOExcel1();" src="/HIS/hisglobal/images/excel1.png" title = "Save as Excel" style="cursor:pointer;"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ';
				//document.getElementById("printArea").innerHTML = "";
		 
		document.getElementById("printAreaDivId").innerHTML = "";  //Cleared the div content.
		
		var bodyText = document.getElementsByTagName("body")[0].innerHTML;
				
		//console.log(printAreaValue);
		bodyText = "<body>"+bodyText+"</body>";
		bodyText= bodyText.replace(/&nbsp;/g,'');
		//bodyText= bodyText.replace(/&amp;/g,'And');
	 
		var encodedString = Base64.encode(bodyText);
	  
		document.getElementById("printAreaDivId").innerHTML = printAreaValue+"<input type='hidden' name='htmlcode' value='"+encodedString+"'>";
		
		document.forms[0].action="/HISClinical/HtmltoPDF";
		document.forms[0].method ="POST";
		document.forms[0].submit();
			
		}
	
	

	function getAjaxResponse() {

		 $('#t01').dataTable( {
			           "scrollY":        180,
			           "scrollCollapse": true,
			           "jQueryUI":       true,
			           "paging":         false,   
			           "ordering": true,    
			           "filter": true,
			           "info": false,
			           "iDisplayLength":-1,
			           "lengthMenu": [[-1], ["All"]]
			       });
				   
		}	
		
		
		