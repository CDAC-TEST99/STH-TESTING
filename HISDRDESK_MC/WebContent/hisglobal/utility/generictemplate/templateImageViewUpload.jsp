<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/HisTools.tld" prefix="HIS_MC" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>

<%@page import="hisglobal.hisconfig.Config"%>
<%@page import ="hisglobal.presentation.*" %>

<HIS_MC:css src="/hisglobal/css/Color.css"/>
<HIS_MC:css src="/hisglobal/css/master.css"/>
<HIS_MC:css src="/hisglobal/css/hisStyle.css"/>
<HIS_MC:css src="/hisglobal/css/hisStyleExt.css"/>
<HIS_MC:css src="/hisglobal/css/calendar-blue2.css"/>

<HIS_MC:javascript src="/registration/js/popup.js"/>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<script>
function setImage()
{
	var imageName = document.getElementsByName("uploadImageName")[0].value;	
	if(imageName=="")
	{
		alert('Please Select A File');
		return;
	}
	var ext = imageName.substring(imageName.lastIndexOf("."),imageName.length).toUpperCase();
	if(ext==".JPG" || ext==".JPEG" || ext==".GIF" || ext==".PNG" || ext==".BMP")
	{
		document.getElementsByName('extension')[0].value = ext;
		document.getElementsByName('transactionMode')[0].value = "SAVE" ;
		document.forms[0].submit();	
	}
	else
	    alert('Please Select Files With Formats : GIF/JPG/JPEG/PNG/BMP');
}

function onFormLoad()
{
	var formclose=true;
  	<%     
		Status objStatus=(Status)request.getAttribute(Config.STATUS_OBJECT);
    	if(objStatus.contains(Status.NEW))
    	{
   	%>    	
    		formclose=false;    	   	
   	<%
	    }    
    %>
    if(formclose)
    {
    	if(!window.opener.closed)
    	{    		
    		opener.ImageUploadControl.setUploadedImage(document.getElementsByName('row')[0].value,document.getElementsByName('col')[0].value,document.getElementsByName('extension')[0].value);
    		    	
	    	self.close();
    	}
    }
}
</script>

<body onload="onFormLoad()">
	<html:form enctype="multipart/form-data" action="/templateImageViewUpload.cnt" method="post">
		<HIS_MC:TransactionContainer>
			<HIS_MC:ContentTag>
				<table>
					<tr>
						<td class="tdfonthead">
							<b>
								<bean:message key="selectImage" />
							</b>
							<html:file name="TemplateImageViewUploadFB" property="uploadImageName" ></html:file>
						</td>
					</tr>
				</table>
			</HIS:ContentTag>
			
			<HIS_MC:ButtonToolBarTag>
				<html:button value="Attach" property="mybutton" onclick="setImage()"/>
			</HIS:ButtonToolBarTag>
		</HIS:TransactionContainer>
		<html:hidden name="TemplateImageViewUploadFB" property="transactionMode"/>
		<html:hidden name="TemplateImageViewUploadFB" property="row"/>
		<html:hidden name="TemplateImageViewUploadFB" property="col"/>
		<html:hidden name="TemplateImageViewUploadFB" property="extension"/>
	</html:form>
</body>
