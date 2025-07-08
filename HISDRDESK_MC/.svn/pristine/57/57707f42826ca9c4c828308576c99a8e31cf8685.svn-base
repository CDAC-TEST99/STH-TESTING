<!-- 
/**
 * @copyright CDAC
 * @developer Pragya Sharma
 */
-->
<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/HisTools.tld" prefix="HIS_MC" %>

<%@ page import = "hisglobal.hisconfig.Config"%>
<%@ page import="hisglobal.utility.generictemplate.GenericTemplateConfig"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<HIS_MC:css src="/hisglobal/css/Color.css"/>
<HIS_MC:css src="/hisglobal/css/calendar-blue2.css"/>

<HIS_MC:javascript src="/hisglobal/js/calendar.js"/>
<HIS_MC:javascript src="/hisglobal/js/dateFunctions.js"/>
<HIS_MC:javascript src="/hisglobal/js/utilityFunctions.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/validationFunctions.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/date_validator.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/time_validator.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/commonUtility.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/templateValidations.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/templateParameterMasterAddMod.js"/>
</head>

<body onload="CallOnLoad()">
	<html:form action="/master/TemplateParameterMaster.cnt">		
		<html:hidden name="TemplateParameterMasterFB" property="hmode"/>		
		<html:hidden name="TemplateParameterMasterFB" property="templateGroupID"/>

		<HIS_MC:TransactionContainer>
			<HIS_MC:TitleTag name="Template Parameter Master">
			</HIS:TitleTag>

			<HIS_MC:statusNew>
				<HIS_MC:ContentTag>
					<table width="100%" border="0"  cellspacing="1" cellpadding="0">
						<tr>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
						</tr>
						<tr>
							<td width="25%"  class="tdfonthead">
								<div align="right">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:message key="tmplname"/>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfont">
								<div align="left">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<b>&nbsp;<bean:write name="TemplateParameterMasterFB" property="templateName"/></b>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfonthead">
								<div align="right">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:message key="tmplcat"/>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfont">
								<div align="left">
									<html:hidden name="TemplateParameterMasterFB" property="templateCategory"/>
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">										
										<b>&nbsp;<bean:write name="TemplateParameterMasterFB" property="templateCategoryType"/></b>
									</font>
								</div>
							</td>
						</tr>
						<tr>
							<td width="25%"  class="tdfonthead">
								<div align="right">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:message key="tmpl"/> <bean:message key="type"/>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfont">
								<div align="left">
									<bean:define id="tempType" name="TemplateParameterMasterFB" property="templateType" type="java.lang.String"></bean:define>
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<b>&nbsp;<%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(tempType)]%></b>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfonthead">
							<div align="right">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:message key="isDefault"/>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfont">
							<input type="checkbox" name="chkIsDefault" disabled="disabled"  />
										<html:hidden name="TemplateParameterMasterFB" property="isDefault"  />
							</td>
						</tr>
						<tr>
					   		<td width="25%" class="tdfonthead">
			           			<div align="right">	           
			              			<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
			              				<bean:message key="effectiveFrom"/>
			              			</font>
			            		</div>
							</td>
		   					<td width="25%" class="tdfont">
		   						<div align="left">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<b>&nbsp;<bean:write name="TemplateParameterMasterFB" property="effectiveFrom"/></b>
									</font>
		   						</div>
		   					</td>
		   					<td width="25%" class="tdfonthead">
		   						<div align="right">
		   							<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
		   								<bean:message key="effectiveTo"/>
		   							</font>
		   						</div>
		   					</td>
		   					<td width="25%" class="tdfont">
		   						<div align="left">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<b>&nbsp;<bean:write name="TemplateParameterMasterFB" property="effectiveTo"/></b>
									</font>
		   						</div>
		   					</td>
		   				</tr>
						<tr>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
						</tr>
					</table>
				</HIS:ContentTag>
				
				<HIS_MC:SubTitleTag name="Template Designer">
				</HIS:SubTitleTag>
				<HIS_MC:ContentTag>
					<table width="100%" align="center" cellpadding="0" cellspacing="0" border="1">
						<tr>
							<td width="100%" align="center">
								<bean:define id="tempId" name="TemplateParameterMasterFB" property="templateId" type="java.lang.String"></bean:define>
								<HIS_MC:GenericTemplateTag templateId="<%=tempId%>"></HIS:GenericTemplateTag>
							</td>
						</tr>
					</table>
				</HIS:ContentTag>
			</HIS:statusNew>

			<HIS_MC:ButtonToolBarTag>
				<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-ccl.png"/>' style="cursor:pointer" onclick="submitForm('CANCEL')" onkeypress="if(event.keyCode==13) submitForm('CANCEL')">
			</HIS:ButtonToolBarTag>
			<HIS_MC:status/>
		</HIS:TransactionContainer>
	</html:form>	
</body>
</html>