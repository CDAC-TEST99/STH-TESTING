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
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/commonUtility.js"/>
<HIS_MC:javascript src="/hisglobal/utility/generictemplate/js/parameterMasterAdd.js"/>
<HIS_MC:javascript src="/hisglobal/js/commonFunctions.js"/>
</head>

<body>
	<html:form action="/master/ParameterMaster.cnt">
		<html:hidden name="ParameterMasterFB" property="hmode"/>		
	<HIS_MC:TransactionContainer>	
		<HIS_MC:TitleTag name="Parameter Master>>View">
		</HIS:TitleTag>
		<HIS_MC:ContentTag>
				<table width="100%" border="0"  cellspacing="1" cellpadding="0">
					<tr>
						<td width="25%"  class="tdfonthead" >
							<div align="right">
								<font color="#000000"  size="2" face="Verdana, Arial, Helvetica, sans-serif">
									<b><bean:message key="paraName"/></b>
								</font>
							</div>
						</td>
						<td width="25%"  class="tdfont">
							<html:text name="ParameterMasterFB" property="paraName" size="30" readonly="true">
							</html:text>
						</td>
					</tr>
					
					<tr>
						<td width="25%"  class="tdfonthead" >
							<div align="right">
								<font color="#000000"  size="2" face="Verdana, Arial, Helvetica, sans-serif">
									<font color="#ff0000">*</font>
									<b><bean:message key="snomedCtConceptId"/></b>
								</font>
							</div>
						</td>
						<td width="25%"  class="tdfont">
						
						
					<html:text readonly="true" name="ParameterMasterFB" property="prefferedTerm" ></html:text>
						
						</td>
					</tr>
					
					<tr>	
						<td width="25%"  class="tdfonthead" align="right">
							<div align="right">
								<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
									<b><bean:message key="paraBound"/></b>
								</font>
							</div>
						</td>
						<td width="25%"  class="tdfont" >
							<logic:equal name="ParameterMasterFB"  property="paraBound" value="<%=GenericTemplateConfig.PARAMETER_BOUND_NON_PATIENT_CENTRIC %>">
								<html:text name="ParameterMasterFB" property="paraBound" size="30" value="Non Patient Centric" readonly="true"/>
							</logic:equal>
							<logic:equal name="ParameterMasterFB"  property="paraBound" value="<%=GenericTemplateConfig.PARAMETER_BOUND_PATIENT_CENTRIC %>">
								<html:text name="ParameterMasterFB" property="paraBound" size="30" value="Patient Centric" readonly="true"/>
							</logic:equal>
							<!-- 
							<html:select name="ParameterMasterFB" property="paraBound" disabled="true">
								<html:option value="-1">Select Value</html:option>
								<html:option value="<%=GenericTemplateConfig.PARAMETER_BOUND_NON_PATIENT_CENTRIC %>">Non Patient Centric</html:option>
								<html:option value="<%=GenericTemplateConfig.PARAMETER_BOUND_PATIENT_CENTRIC %>">Patient Centric</html:option>
							</html:select>
							-->
						</td>
					</tr>
					<tr>
						<td width="25%"  class="tdfonthead" align="right">
							<div align="right">
								<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
									<b><bean:message key="paraType"/></b> 
								</font>
							</div>
						</td>
						<td width="25%"  class="tdfont" align="right">
							<html:text name="ParameterMasterFB" property="paraTypeLabel" size="30" readonly="true"/>
							<html:hidden name="ParameterMasterFB" property="isActive" value="<%=Config.IS_VALID_ACTIVE%>" />	
						</td>
					</tr>
					<tr>
						<td class="tdfonthead"  width="25%" align="right">
							<div align="right">
								<font color="#000000" size="2" face="Verdana, Arial, Helvetica, sans-serif">
									<b><bean:message key="isActive"/></b> 
								</font>
							</div>
						</td>
						<td width="25%"  class="tdfont">
							<logic:equal name="ParameterMasterFB"  property="isActive" value="<%=Config.IS_VALID_ACTIVE %>">
								<html:text name="ParameterMasterFB" property="isActive" size="30" value="Active" readonly="true"/>
							</logic:equal>
							<logic:equal name="ParameterMasterFB"  property="isActive" value="<%=Config.IS_VALID_INACTIVE %>">
								<html:text name="ParameterMasterFB" property="isActive" size="30" value="In Active" readonly="true"/>
							</logic:equal>
						</td>
					</tr>
				</table>
				</HIS:ContentTag>
				<HIS_MC:ButtonToolBarTag>
					<img class="button" src='<HIS_MC:path src="/../HIS/hisglobal/images/buttons/btn-ccl.png"/>' style="cursor:pointer" onclick="submitForm('CANCEL')" onkeypress="if(event.keyCode==13) submitForm('CANCEL')">
				</HIS:ButtonToolBarTag>
			<center><b><HIS_MC:status/></b></center>
		</HIS:TransactionContainer>		
		<html:hidden name="ParameterMasterFB" property="paraId"/>
	</html:form>	
</body>
</html>