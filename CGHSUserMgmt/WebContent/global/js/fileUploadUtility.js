$(document)
		.ready(
				function() {
					
					onFileUploadFunc();
					
					
					
					
				})
				
				

				
function onFileUploadFunc() {
	$(document)
	.on(
			'change',
			':file',
			function() {
				var input = $(this), numFiles = input
						.get(0).files ? input.get(0).files.length
						: 1, label = input.val()
						.replace(/\\/g, '/').replace(
								/.*\//, '');
						

				input.trigger('fileselect', [ numFiles,
						label ]);

				var f = $(this).get(0).files[0];
				
				//readSingleFile(f, $(this).attr('id'));
			});

$(':file')
	.on(
			'fileselect',
			function(event, numFiles, label) {

				var input = $(this).parents(
						'.file-group').find(':text'), log = numFiles > 1 ? numFiles
						+ ' files selected'
						: label;
						
				if (input.length) {
					input.val(log);
				} else {

					if (log)
						alert(log);
				}

			});
}



var filename;
function uploadDoc(fileId,folderName,mandatory) {
	
	var fillpass = fileId;
	filename = document.getElementById(fileId).value;
	
	regex = new RegExp("(.*?)\.(pdf|jpg|png|jpeg|PNG|JPG|JPEG|PDF)$");
	
	$("#fileUploadFlag").val("1");
	
	var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	
	if ((regex.test(filename))) 
	{
		
		var oFile = document.getElementById(fileId).files[0];
		if (oFile.size > 5242880) // 5 mb for bytes.
		{
			alert("File size must be under 5 MB!");
			return; 
		}
		var encodedFileContent=null;
		 if (oFile) {
		        var r = new FileReader();
		        r.onload = function(e) {
		            var contents = e.target.result;
		            contents = contents.split(',')[1];
		            encodedFileContent = hex_md5(contents);
		        	var formData = new FormData();
		    		formData.append("file_"+fileId, oFile);
		    		
		    		var json={"fieldName":"file_"+fileId, "fileName":oFile.name,"hcode":encodedFileContent};
		    		
		    		var token=encryptBase64(JSON.stringify(json));
		    		
		    		
		    		
		    		
		    		if(formData!=0){
		    		$
		    				.ajax({
		    					url : '/CGHSUserMgmt/FormFlowXACTION?hmode=fileUpload&varSSOTicketGrantingTicket='+ticket +'&tkn='+token+'&folderName='+folderName,
		    					type : "POST",
		    					data : formData,
		    					enctype : 'multipart/form-data',
		    					processData : false,
		    					contentType : false
		    				})
		    				.done(
		    						function(data) {
		    							
		    							if(data=="1"|| data=="2" || data=="3"|| data=="4" ||data=="5"||data=="6"||data=="7"){
		    								var msg="Illegal file";
		    								if(data=="1"){
		    									msg="File Extention not valid"
		    								}
		    								else if(data=='3'){
		    									
		    									msg="Not a Valid File Name";
		    									
		    								}
		    								else if(data=='4'){
		    									msg="Token not found";
		    								}
		    								else if(data=='5'){
		    									msg="File Data Tempared";
		    								}
		    								else if(data=='6'){
		    									msg="File Content Tempared";
		    								}
		    								else if(data=='7'){
												msg="FTP Error !! Please Contact System Administrator."
											}
		    								else{
		    									
		    									msg="File Content Type is Not Match With File Ext";
		    									
		    								}
		    								
		    								alert(msg);

		    								/*var strhtml="<link rel='stylesheet' href='/CGHSUserMgmt/global/template/dist/css/adminlte.min.css'>";
		    								strhtml+="<link type='text/css' rel='stylesheet' href='/HIS/global/error/error.css' />";
		    								strhtml+="<link rel='stylesheet' href='/CGHSUserMgmt/global/template/plugins/fontawesome-free/css/all.min.css'>";
		    								strhtml+="<div  class='page-error' >";
		    								strhtml+="<h1><i class='fas fa-lg fa-exclamation-triangle'></i>&nbsp; "+msg+"</h1><br/>";					
		    								strhtml+=" </div>";
		    								$('body').html(strhtml);*/
		    							}
		    							else{
		    								fileUploadSuccessWithoutView(data,fileId,folderName,mandatory);
		    							}
		    							
		    								
		    						}).fail(function(jqXHR, textStatus ) {
		    							
		    							 var msg = '';
		    						        if (jqXHR.status === 0) {
		    						            msg = 'Not connect.\n Verify Network.';
		    						        } else if (jqXHR.status == 404) {
		    						            msg = 'Requested page not found. [404]';
		    						        } else if (jqXHR.status == 500) {
		    						            msg = 'Internal Server Error [500].';
		    						        } else if (textStatus === 'parsererror') {
		    						            msg = 'Requested JSON parse failed.';
		    						        } else if (textStatus === 'timeout') {
		    						            msg = 'Time out error.';
		    						        } else if (textStatus === 'abort') {
		    						            msg = 'Ajax request aborted.';
		    						        } else {
		    						            msg = 'Uncaught Error.\n' + jqXHR.responseText;
		    						        }
		    							
		    						        alert('File upload failed ...'+msg+"  >> "+textStatus);
			    					
			    					 /*var selectedTab = window.frameElement.id.split("_")[0].split(" ").join("_");  
			    					 var secSelTab = hex_md5(selectedTab);
			    						
			    					 $('#'+csrf_token_key).val(getToken(secSelTab));*/
		    					
		    				});		
		    		}
		          
		        }
		        r.readAsDataURL(oFile);
		    } else {
		        alert("Failed to load file");
		    }
		
	} else {
		alert("This is not valid file. Ex-( docx|pdf|xml|jpg|png|gif|jpeg|txt|xlsx|PNG|JPG|JPEG|TXT) ");
		return false;
	}

}


function captureFileWithSecurityCode(filename,fileId) {
	var oFile = document.getElementById(fileId).files[0];
	if (oFile.size > 5242880) // 5 mb for bytes.
	{
		alert("File size must be under 5 MB!");
		return; 
	}
	
	

	var formData = new FormData();
	
	formData.append("file_"+fileId, oFile);
	
	//getHexaCode
	
	/*formData.append(csrf_token_key , $('#'+csrf_token_key).val() );
	formData.append("f_codes"+fileId , $("#f_codes"+fileId).val() );
	 
	var qstring = getFormDataParams(formData);	 
	var hcode = getHexaCode(qstring);
	formData.append(token_key , hcode ); 
	formData.delete("f_codes"+fileId);
	$("#f_codes"+fileId).remove();*/
	
	return formData;
	
	
}


function fileUploadSuccessWithoutView(data,fileId,folderName,mandatory) {
	if(data.includes("Error")){
		
		document.getElementsByTagName("body")[0].innerHTML = data;
		
	}
	
	var validation="";
	if(mandatory=='1'){
		validation="mandatory";
	}
	//var url="/eUpkaran/EUpkaranMasterACTION?hmode=fileDownload&fileName="+data;
	var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
	var url="/CGHSUserMgmt/FormFlowXACTION?hmode=fileTempDownload&fileName="+data+"&varSSOTicketGrantingTicket="+ticket+"&folderName="+folderName;
	//var url = "FileDownloadTest?fileName=" + data;
	
	document.getElementById('divFaIcon' + fileId).innerHTML = 
		"<a class='btn  btn-his-sm  btn-sm' id='closeFile"	+ fileId
			+ "'  onclick='removeFileWithoutView(\""
			+ fileId
			+ "\",\""+validation+"\",\""+folderName+"\");' >Reset</a> ";		
	
	document.getElementById('displayFile' + fileId).innerHTML = "<a class='uploadA' target='_blank' href='"	+ url+ "'>"	+ data
		+ "</a><input type='file' style='display: none;' id='"+fileId+"' name='file'>"
		
		document.getElementById('filename' + fileId).value = data;
	
	 /*var selectedTab = window.frameElement.id.split("_")[0].split(" ").join("_");  
	 var secSelTab = hex_md5(selectedTab);
		
	 $('#'+csrf_token_key).val(getToken(secSelTab)); */

}


function removeFileWithoutView(fileid,validation,folderName) {
	
	if(document.getElementById('filename' + fileid)==undefined )
		return;
	if(document.getElementById('divFaIcon' + fileid)==undefined )
		return;
	
	if(document.getElementById('displayFile' + fileid)==undefined )
		return;
	
	$('.wid-75-margin').val("");
	document.getElementById('filename' + fileid).value = "";
	/*var str="<div class='d-flex flex-row'>";
	str+="<div class='p-2'><label><a class='btn  bg-gradient-formButton  btn-sm'>" ;
	str+="Choose File <input type='file' style='display: none;' id='"+ fileid+"' name='file'></a></label></div>";
	str+="<div class='p-2'><input type='text'	class='form-control form-control-sm txtfile' readonly='readonly'></div>";
	str+="</div>";*/
	
	var str='<label class="div-inline" style="float: left;margin-right: 2px;"><span class="btn  btn-his-sm  btn-sm">Choose';
	str+='File<input type="file" style="display: none;" id="'+fileid+'" name="file">';
	str+='</span></label> <input type="text" class="form-control form-control-sm classMandat" readonly="readonly" style="float: left;margin-right: 2px;width:35%" data-validation="'+validation+'">'
	
	document.getElementById('displayFile' + fileid).innerHTML = str; 
	document.getElementById('divFaIcon' + fileid).innerHTML = "<a class='btn  btn-his-sm  btn-sm' id='faUpload"+fileid+"' "
	+ "onclick='uploadDoc("+fileid+",\""+folderName+"\");' >Upload</a>";
	
		
	
	/*
	
	
	document.getElementById('displayFile' + fileid).innerHTML = "<label class='div-inline' style='float: left;margin-right: 2px;'><span "
			+ "class='btn  bg-gradient-formButton  btn-sm'>Choose File<input type='file' style='display: none;'"
			+ " id='"+fileid+"' name='file'></span></label> <input type='text' "
			+ "class='form-control form-control-sm txtfileupload' readonly='readonly' style='float: left;margin-right: 2px;width:60%'>";

	document.getElementById('divFaIcon' + fileid).innerHTML = "<a class='btn  bg-gradient-formButton  btn-sm' id='faUpload"+fileid+"' "
	+ "onclick='uploadDoc("+fileid+");' >Upload</a>";
	
	*/
	onFileUploadFunc();
	
	$('#divFaIcon' + fileid).css({'float': 'left','margin-right': '2px'});
}



function checkFileExistsInModify(fileId) {
	//alert(fileId);
	var j =0;
	//alert($('.fileUploadHidden').length);
	$('.fileUploadHidden').each(function(i, obj) {
		var j=obj.name.replace("filename","").trim();
		//alert(fileId+" == "+j+ " obj.value--" + obj.value)
		if (fileId==j && obj.value!="") {
			var ticket=$('#varSSOTicketGrantingTicket').val()!=undefined?$('#varSSOTicketGrantingTicket').val():"";
			var url="/eUpkaran/EUpkaranMasterACTION?hmode=ftpFileDownload&fileName="+obj.value+"&varSSOTicketGrantingTicket="+ticket;
			document.getElementById('displayFile' + fileId).innerHTML = "<a href='"	+ url + "'>" + obj.value + "</a>"
			document.getElementById('divFaIcon' + fileId).innerHTML = "&nbsp;&nbsp;&nbsp;<a class='btn  bg-gradient-formButton  btn-sm' id='closeFile"+ fileId+ "'  onclick='removeFileWithoutView(\""+ fileId + "\");' > &nbsp;Reset</a> ";
		}		
	});
}
