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
<%@ page import = "java.util.*,hisglobal.presentation.*" %>
<%@ page import="hisglobal.utility.generictemplate.GenericTemplateConfig"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<HIS_MC:css src="/hisglobal/css/Color.css"/>
<HIS_MC:css src="/hisglobal/css/calendar-blue2.css"/>

<HIS_MC:javascript src="/hisglobal/js/validation.js"/>
<HIS_MC:javascript src="/hisglobal/transactionutil/js/master.js"/>
<HIS_MC:javascript src="/hisglobal/js/util.js"/>
<HIS_MC:javascript src="/hisglobal/js/calendar.js"/>
<HIS_MC:javascript src="/hisglobal/js/dateFunctions.js"/>
<HIS_MC:javascript src="/hisglobal/js/commonFunctions.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/commonUtility.js"/>
<HIS_MC:javascript src="/hisglobal/js/utilityFunctions.js" />
<HIS_MC:javascript src="/registration/js/registration.js" />

<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/templateParameterMasterAddMod.js"/>


</head>

<body onload="CallThisOnLoad()">
	<html:form action="/master/TemplateParameterMaster.cnt">
		<%	String sysDate=WebUTIL.getCustomisedSysDate((Date)session.getAttribute(Config.SYSDATEOBJECT), "dd-MMM-yyyy");	%>
		<html:hidden name="TemplateParameterMasterFB" property="hmode"/>		
		<html:hidden name="TemplateParameterMasterFB" property="entryDate" value="<%=sysDate%>" />

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
									<html:text name="TemplateParameterMasterFB" property="templateName" maxlength="50" onkeypress="return validateAlphaNumOnly(this,event)">
									</html:text>
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
									<!--<html:select name="TemplateParameterMasterFB" property="templateCategory">
										<html:option value="-1">Select Value</html:option>
										<html:options collection="<%=GenericTemplateConfig.ESSENTIAL_LIST_ALL_TEMPLATE_CATEGORY%>" property="templateCategory" labelProperty="templateCategoryType"/> 
									</html:select>-->
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:write name="TemplateParameterMasterFB" property="templateCategoryName"/>
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
									<logic:notEqual name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
										<html:select name="TemplateParameterMasterFB" property="templateType">
											<html:option value="-1">Select Value</html:option>
											<html:option value="<%=GenericTemplateConfig.TEMPLATE_TYPE_NORMAL%>"><%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(GenericTemplateConfig.TEMPLATE_TYPE_NORMAL)]%></html:option>
											<html:option value="<%=GenericTemplateConfig.TEMPLATE_TYPE_MATRIX%>"><%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(GenericTemplateConfig.TEMPLATE_TYPE_MATRIX)]%></html:option>
											<html:option value="<%=GenericTemplateConfig.TEMPLATE_TYPE_CONSENT%>"><%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(GenericTemplateConfig.TEMPLATE_TYPE_CONSENT)]%></html:option>
											<html:option value="<%=GenericTemplateConfig.TEMPLATE_TYPE_GUIDELINE%>"><%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(GenericTemplateConfig.TEMPLATE_TYPE_GUIDELINE)]%></html:option>
										</html:select>
									</logic:notEqual>
									<logic:equal name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
										<html:hidden name="TemplateParameterMasterFB" property="templateId"/>
										<html:hidden name="TemplateParameterMasterFB" property="tempSerialNo"/>
										<html:hidden name="TemplateParameterMasterFB" property="oldTemplateName"/>
										<html:hidden name="TemplateParameterMasterFB" property="oldTemplateCategory"/>
										<html:hidden name="TemplateParameterMasterFB" property="oldEffectiveTo"/>										
										<html:hidden name="TemplateParameterMasterFB" property="templateType"/>
										<html:hidden name="TemplateParameterMasterFB" property="oldIsDef"/>
										<bean:define id="tempType" name="TemplateParameterMasterFB" property="templateType" type="java.lang.String"></bean:define>
										<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
											<b>&nbsp;<%=GenericTemplateConfig.TEMPLATE_TYPES[Integer.parseInt(tempType)]%></b>
										</font>
									</logic:equal>
								</div>
							</td>
							<td width="25%"  class="tdfonthead">
							<div align="right">
									<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
										<bean:message key="isDefault"/>
									</font>
								</div>
							</td>
							<td width="25%"  class="tdfont"><input type="checkbox" name="chkIsDefault"  />
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
							
							<bean:define name="TemplateParameterMasterFB" property="effectiveFrom"  id="effFrom" type="java.lang.String"/>
		   					<%	if(effFrom==null||effFrom.equalsIgnoreCase(""))	{	effFrom =sysDate;	}	%>
	
		   					<td width="25%" class="tdfont">
		   						<div align="left">
									<logic:notEqual name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
		   								<HIS_MC:date name='<%="effectiveFrom"%>' dateFormate="%d-%b-%Y" value="<%=effFrom %>" />
		   							</logic:notEqual>
									<logic:equal name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
										<html:hidden name="TemplateParameterMasterFB" property="effectiveFrom"/>
										<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
											<b>&nbsp;<bean:write name="TemplateParameterMasterFB" property="effectiveFrom"/></b>
										</font>
									</logic:equal>
		   						</div>
		   					</td>
		   					<td width="25%" class="tdfonthead">
		   						<div align="right">
		   							<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
		   								<bean:message key="effectiveTo"/>
		   							</font>
		   						</div>
		   					</td>
		   					
		   					<bean:define name="TemplateParameterMasterFB" property="effectiveTo" id="effTo" type="java.lang.String" />		   					
		   					
		   					<td width="25%" class="tdfont">
		   						<div align="left">
									<logic:notEqual name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
		   								<HIS_MC:date name='<%="effectiveTo"%>' dateFormate="%d-%b-%Y" />
		   							</logic:notEqual>
									<logic:equal name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
			   							<HIS_MC:date name='<%="effectiveTo"%>' dateFormate="%d-%b-%Y" value="<%=effTo%>" />
									</logic:equal>
		   						</div>
		   					</td>
		   				</tr>
						<logic:equal name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
						<tr>
							<td class="tdfont" colspan="4" width="100%">
								<html:hidden name="TemplateParameterMasterFB" property="modeTempModify" />
								<input type="checkbox" id="chkModeModify"/>
								<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
									 &nbsp; Want to modify Template
								</font>
							</td>
						</tr>
						</logic:equal>
						<tr>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
							<td width="25%"  class="tdfonthead"></td>
							<td width="25%"  class="tdfont"></td>
						</tr>
					</table>
				</HIS:ContentTag>
			</HIS:statusNew>

			<HIS_MC:ButtonToolBarTag>
				<HIS_MC:statusNew>
					<logic:notEqual name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
						<img class="button" src='<HIS_MC:path src="/hisglobal/images/btn-next.png"/>' style="cursor:pointer" onkeypress="if(event.keyCode==13) submitFormOnValidate(validateNext(),'NEXT')" onclick="submitFormOnValidate(validateNext(),'NEXT')">	
					</logic:notEqual>				
					<logic:equal name="TemplateParameterMasterFB" property="hmode" value="MODIFY">
						<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-mo.png"/>' style="cursor:pointer" onkeypress="if(event.keyCode==13) submitFormOnValidate(validateTempModify(),'MODIFYTEMPLATE')" onclick="submitFormOnValidate(validateTempModify(),'MODIFYTEMPLATE')">
					</logic:equal>					
					<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-ccl.png"/>' style="cursor:pointer" onclick="submitForm21('CANCEL')" onkeypress="if(event.keyCode==13) submitForm21('CANCEL')">
					<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-clr.png"/>' style="cursor:pointer" onclick="submitForm21('ADD')" onkeypress="if(event.keyCode==13) submitForm21('ADD')">
				</HIS:statusNew>
					
				<HIS_MC:statusDone>
					<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-ccl.png"/>' style="cursor:pointer" onclick="submitForm21('CANCEL')" onkeypress="if(event.keyCode==13) submitForm21('CANCEL')">
				</HIS:statusDone>
			</HIS:ButtonToolBarTag>
			<html:hidden name="TemplateParameterMasterFB" property="templateCategory"/>
			<html:hidden name="TemplateParameterMasterFB" property="templateCategoryName"/>
			<html:hidden name="TemplateParameterMasterFB" property="templateGroupID"/>
			<html:hidden name="TemplateParameterMasterFB" property="isDefault"  />
			<html:hidden name="TemplateParameterMasterFB" property="defChk"  />
			<html:hidden name="TemplateParameterMasterFB" property="lockChk"  />
			<center><b><HIS_MC:status/></b></center>
		</HIS:TransactionContainer>
	</html:form>	
</body>
</html>