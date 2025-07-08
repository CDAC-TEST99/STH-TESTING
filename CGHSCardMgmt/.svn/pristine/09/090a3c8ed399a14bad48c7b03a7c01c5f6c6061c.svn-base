<!DOCTYPE html>
<html lang="en">

<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CGHS-Form Type selection</title>
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <link rel="stylesheet" href="/HIS/hisglobal/cdac_awesome/css/login.css">

   
    <script type="text/javascript" src="/CGHSCardMgmt/cghsCard/js/DAOnlineBenidgenerate.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
 <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  
<body>

<form action="/CGHSCardMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post" >

	       
  <fieldset  id="ENTRYFORM">   

                    
                    <div id="contentToPrint">
        <div>
       <input type="button" onClick="return printContent()" value="Print">
        </div>
<p align="center"><b><font size="2">&#2360;&#2370;&#2330;&#2325;&#0032;&#2325;&#2366;&#2352;&#2381;&#2337;/INDEX CARD<br>&#2349;&#2366;&#2352;&#2340;&#0032;&#2360;&#2352;&#2325;&#2366;&#2352;/GOVERNMENT OF INDIA<br>&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2319;&#2357;&#2306; &#0032;&#2346;&#2352;&#2367;&#2357;&#2366;&#2352;&#0032;&#2325;&#2354;&#2381;&#2351;&#2366;&#2339;&#0032;&#2350;&#2306;&#2340;&#2381;&#2352;&#2366;&#2354;&#2351;/MINISTRY OF HEALTH AND FAMILY WELFARE<br> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&#2325;&#2375;&#2344;&#2381;&#2342;&#2381;&#2352;&#2368;&#2351; &#0032;&#2360;&#2352;&#2325;&#2366;&#2352;&#0032;&#2360;&#2381;&#2357;&#2366;&#2360;&#2381;&#2341;&#2381;&#2351;&#0032;&#2351;&#2379;&#2332;&#2345;&#2366;/CENTRAL GOVERNMENT HEALTH SCHEME</font><font size="2" color="#FF0000">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </font>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
</b> &nbsp;&nbsp;&nbsp;&nbsp;</p>
<div class="table-responsive">
    <table border="0" width="100%">
        <tr>
            <td width="57" align="center"><b><font size="2">1.</font></b></td>
            <td width="239">Card No./Type<font size="2"></font></td>
             <td width="239"><font size="2"> <span id="CardNumber"></span>/ <span id="CardType"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">2.</font></b></td>
            <td width="515">
                <b>
                    <font size="2">
                       &#2360;&#2352;&#2325;&#2366;&#2352;&#2368;&#0032;&#2325;&#2352;&#2381;&#2350;&#2330;&#2366;&#2352;&#2368; &#0032;&#2325;&#2366;&#0032;&#2344;&#2366;&#2350;
                        /Name of The Govt Employee
                    </font>
                </b>
            </td>
            <td width="239"><font size="2"> <span id="govEmployeeName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">3.</font></b></td>
            <td width="515">
                <b><font size="2">&#2310;&#2357;&#2366;&#2360;&#2368;&#2351;&#0032;&#2346;&#2340;&#2366;Residential Address</font></b>
            </td>
            <td width="239"><font size="2"><span id="residentialAddress"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">4.</font></b></td>
            <td width="515">
                <b><font size="2">CGHS Wellness Centre:</font></b></td>
            <td width="239"><font size="2"><span id="wellnessCentre"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">5.</font></b></td>
            <td width="515">
                <b><font size="2">Issue Date / Valid Upto:</font></b></td>
            <td width="239"><font size="2">&nbsp;/&nbsp;<span id="issueDate"></span></font>&nbsp;</td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">6.</font></b></td>
            <td width="515">
                <b><font size="2">Entitlement:</font></b></td>
            <td width="239"><font size="2"><span id="entitlement"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">7.</font></b></td>
            <td width="515">
                <b><font size="2">Department Name:</font></b></td>
            <td width="239"><font size="2"><span id="departmentName"></span></font></td>
        </tr>
        <tr>
            <td width="57" align="center"><b><font size="2">8.</font></b></td>
            <td width="515">
                <b><font size="2"><span id="familyMemberDetails">Family Member Details</span>:</font></b></td>
            <td width="239">&nbsp;</td>
        </tr>
    </table>
</div>

	<br>
 <div class="table-responsive">
  <table class="table table-bordered table-striped" id="AutoNumber1">
  <thead>
    <tr>
      <th style="width:5%">S.No</b></th>
       <th style="width:20%">BenId</th>
      <th style="width:20%">Name</th>
       <th style="width:20%">Date of Birth</th>
       <th style="width:15%">Relationship</th>
        <th style="width:10%">Gender</th>
          <th style="width:10%">Photo</th>
	 
    </tr>
	</thead>
	<tbody>
   
	</tbody>
   </table>
   </div>
	<p align="justify" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </b></p>

<p align="left" style="margin-top: 0; margin-bottom: 0"><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1. &#2351;&#2361; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368;
&#2346;&#2381;&#2354;&#2366;&#2360;&#2381;&#2335;&#2367;&#2325; &#0032;&#2325;&#2366;&#2352;&#2381;&#2337;&#0032;&#2332;&#2366;&#2352;&#2368; &#0032;&#2361;&#2379;&#2344;&#2375; &#0032;&#2340;&#2325;&#0032;&#2357;&#2376;&#2343;&#0032;&#2352;&#2361;&#2375;&#2327;&#2368; &#0032;&#2340;&#2341;&#2366; &#0032;&#2325;&#2375;.&#2360;.&#2360;&#2381;&#2357;&#2366;&#2351;&#2379; &#0032;&#2325;&#2375;&#0032;&#2344;&#2366;&#2350;&#2367;&#2325;&#2366;&#2327;&#2340;&nbsp; &#2344;&#2367;&#2332;&#2368; &#0032;&#2309;&#2360;&#2381;&#2346;&#2340;&#2366;&#2354;&#2379;&#2306; &#0032;&#2350;&#2375;&#2306;&#0032;&#2313;&#2346;&#2330;&#2366;&#2352;&#0032;&#2361;&#2375;&#2340;&#2369; &#0032;&#2349;&#2368;&#0032;&#2357;&#2376;&#2343;&#0032;&#2361;&#2379;&#2327;&#2368; &#0032;|<br>/This Slip is valid till issue of Plastic Card&nbsp;and valid for treatment in CGHS empanelled private hospitals also.<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.&#2346;&#2335;&#2354;&#0032;&#2331;&#2379;&#2337;&#2364;&#2344;&#2375; &#0032;&#2360;&#2375;&#0032;&#2346;&#2370;&#2352;&#2381;&#2357;&#0032;&#2325;&#2371;&#2346;&#2351;&#2366; &#0032;&#2346;&#2352;&#2381;&#2330;&#2368 &#0032;&#2350;&#2375;&#2306;&#0032;&#2342;&#2368;&#0032;&#2327;&#2312;&#0032;&#2360;&#2350;&#2360;&#2381;&#2340;&#0032;&#2332;&#2366;&#2344;&#2325;&#2366;&#2352;&#2368; &#0032;&#2325;&#2368;&#0032;&#2332;&#2366;&#2305;&#2330;&#0032;&#2325;&#2352;&#0032;&#2354;&#2375;&#2306;&#0032;|/Please Check the data before leaving the counter.</b></p>

<br>
</div>
</div>
<!-- </div>
 </div>
</div>
</div> -->
  
  
  
  
  <input type='hidden' name="Benidvalue" id='Benidvalue' value="<%=request.getParameter("Benidvalue")%>"  />  
  </fieldset>
  
  
                  <input type="hidden" name="masterKey" id="masterKey" />
	     <input type='hidden' name="hmode" id="hmode"/>
	         <input type="hidden" name="isGlobal" id='isGlobalLocalVar' value="<%=isGlobal%>"/>
	     <input type='hidden' name="tid" id='tid'/>	
	     <input type='hidden' name="initMode" id='initMode' />	     	     		
	     <input type='hidden' name="primaryKeys" id='primaryKeys' />     
	     
  </form>

</body>
</html>