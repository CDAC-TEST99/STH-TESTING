
 
<%@page import="hisglobal.utility.HisUtil"%>  
<%@page import="vo.usermgmt.UserMasterVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<html>

<head>



<title>My Alerts</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META Http-Equiv="Cache-Control" Content="no-cache" />
<META Http-Equiv="Cache-Control" Content="no-store" />
<META Http-Equiv="Pragma" Content="no-cache" />
<META Http-Equiv="Expires" Content="0" />


<script type="text/javascript" src="/HIS/hisglobal/js/jquery.js"></script>
<script src="/HIS/hisglobal/js/jquery.hashchange.min.js" type="text/javascript"></script>
<script src="/HIS/hisglobal/js/jquery.easytabs.min.js" type="text/javascript"></script>



    <link rel="stylesheet" href="/HIS/hisglobal/css/dwh.css">
	<link rel="stylesheet" href="/HIS/hisglobal/css/control.css">
	<link rel="stylesheet" href="/HIS/hisglobal/css/pure-drawer.css">
	<link href="/HIS/hisglobal/css/task.css" rel="stylesheet" type="text/css">
	

  <style>
    /* Example Styles for Demo */
    .etabs { margin: 0; padding: 0; }
    .tab { display: inline-block; zoom:1; *display:inline; background: #eee; border: solid 1px #999; border-bottom: none; -moz-border-radius: 4px 4px 0 0; -webkit-border-radius: 4px 4px 0 0; }
    .tab a { font-size: 14px; line-height: 2em; display: block; padding: 0 10px; outline: none; }
    .tab a:hover { text-decoration: underline; }
    .tab.active { background: #fff; padding-top: 6px; position: relative; top: 1px; border-color: #666; }
    .tab a.active { font-weight: bold; }
    .tab-container .panel-container { background: #fff; border: solid #666 1px; padding: 10px; -moz-border-radius: 0 4px 4px 4px; -webkit-border-radius: 0 4px 4px 4px; }
    .panel-container { margin-bottom: 10px; }
  </style>
	<!-- <script type="text/javascript" src="/HIS/hisglobal/js/multilingual.js"></script> -->
  <script type="text/javascript">
  $(document).ready(function(){ 
      $("#pure-toggle-right").attr('checked', 'true');
      $("#tabsalerts").css({"color":"red"});
      $("#tabsalerts").click(function(){
      $("#tabs1-broadcasts").hide();
      $("#tabs1-alerts").show();
      $("#tabsalerts").css({"color":"red"});
      $("#tabsbroadcasts").css({"color":"white"});
      
      });
       $("#tabsbroadcasts").click(function(){
      $("#tabs1-alerts").hide();
      $("#tabs1-broadcasts").show();
      $("#tabsbroadcasts").css({"color":"red"});
      $("#tabsalerts").css({"color":"white"});
      
      });     
   });
   function closedefaultTask(){
	    $('#pure-toggle-right').removeProp('checked');
	}
	

	<%
	
	UserMasterVO userVO = (UserMasterVO)request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO);
	
	%>
	 	
	
		var userName = "<%=userVO.getVarUserName() %>";
		var seatId = "<%=userVO.getVarUserSeatId() %>"; 
		var hospCode =  "<%=userVO.getVarHospitalCode() %>";
		var userType =   "<%=userVO.getVarUserLevel() %>";
		var userId =   "<%=userVO.getVarUserId() %>";
		
		if(parseInt(userType) > 5)
			userType = 5;
			
	
	var clientId = "<%=HisUtil.getParameterFromHisPathXML("ALERT_CLIENT_ID")%>";
	var projectId = "<%=HisUtil.getParameterFromHisPathXML("ALERT_PROJECT_ID")%>";
 
	 
	
	
	var msgIdList = seatId+"^"+userName+"^"+clientId;
	var alertIdList = seatId+"^"+userName+"^"+clientId;
	//getBMessages();

	function getBMessages() {

		

		var alertQueryParams = JSON.stringify({
			"hospCode" : hospCode,
			"seatId" : seatId,
			"userName" : userName,
			"userType" :userType,
			"clientCode" : clientId,
			"projectId" :projectId,
			"userId" : userId
		});

		$
				.ajax({
					type : "POST",
					url : "/AHIMSG5/alert/AlertClient?mode=myAlrts",
					contentType : "application/json; charset=utf-8",
					dataType : "json",
					data : alertQueryParams,
					success : function(myJson) {
							 
						
						
						if (myJson != null )
							if((myJson.alertMessages != null && myJson.alertMessages.length > 0) ||  (myJson.broadcastMsgs != null && myJson.broadcastMsgs.length > 0 )) {
						 
							var printMsg = "";
							
							if (myJson.alertMessages != null && myJson.alertMessages.length > 0) {
 								
								printMsg = printMsg
										+ " <div style='align: center;'><table class='flatTableData' border='1px' style='border-collapse:collapse;' width='100%'><tr class='headingTr'><td width='20%'>Alert Name</td><td width='80%'>Message</td></tr>";

										
								if (typeof (myJson.alertMessages.length) !== "undefined"
										&& myJson.alertMessages.length > 0) {

									for ( var i = 0; i < myJson.alertMessages.length; i++) {
										
										if(myJson.alertMessages[i].strAlertName != null && myJson.alertMessages[i].strAlertName != '' && myJson.alertMessages[i].strAlertName != 0){
											
											printMsg = printMsg
											+ "<tr><td>"+ myJson.alertMessages[i].strAlertName
											+"</td><td>"+ myJson.alertMessages[i].strMsg
											+"</td></tr>";
											
										}
										
									
									 
									}
									
								} else {
 
									if(myJson.alertMessages[i].strAlertName != null && myJson.alertMessages[i].strAlertName != '' && myJson.alertMessages[i].strAlertName != 0){
								 
									printMsg = printMsg
									+ "<tr><td>"+ myJson.alertMessages.strAlertName
									+"</td><td>"+ myJson.alertMessages.strMsg
									+"</td></tr>";

									}
									 
								}

								printMsg = printMsg
								+ " </table></div>";
								
							}else{
								
								printMsg =  " <div style='text-align: center;'> Alerts not Available </div>";
								
								
								
							}
							
							 
							
							document.getElementById("tabs1-alerts").innerHTML = printMsg;
							
							
							
							if (myJson.broadcastMsgs != null &&  myJson.broadcastMsgs.length > 0) {

								printMsg = " <div style='align: center;'><table class='flatTableData' border='1px' style='border-collapse:collapse;' width='100%'><tr class='headingTr'><td width='20%'>Header</td><td width='10%'>Sent From</td><td width='40%'>Message</td><td width='30%'>Validity</td></tr>";

								if (typeof (myJson.broadcastMsgs.length) !== "undefined"
										&& myJson.broadcastMsgs.length > 0) {

									for ( var i = 0; i < myJson.broadcastMsgs.length; i++) {
										
										if(myJson.broadcastMsgs[i].msgHeader != null && myJson.broadcastMsgs[i].msgHeader != '' && myJson.broadcastMsgs[i].msgHeader != 0){
											
											printMsg = printMsg
											+ "<tr><td>"+ myJson.broadcastMsgs[i].msgHeader
											+ "</td><td>"+ myJson.broadcastMsgs[i].msgFrom
											+"</td><td>"+ myJson.broadcastMsgs[i].msg
											+"</td><td>"+ myJson.broadcastMsgs[i].validity 
											+"</td></tr>";
											 
											
										}
										
								

									}
								} else {

									if(myJson.broadcastMsgs.msgHeader != null && myJson.broadcastMsgs.msgHeader != '' && myJson.broadcastMsgs.msgHeader != 0){
									
									printMsg = printMsg
									+ "<tr><td>"+ myJson.broadcastMsgs.msgHeader
									+ "</td><td>"+ myJson.broadcastMsgs.msgFrom
									+"</td><td>"+ myJson.broadcastMsgs.msg
									+"</td><td>"+ myJson.broadcastMsgs.validity
									+"</td></tr>";

									}
								 
								}
								
								printMsg = printMsg
								+ " </table></div>";

							}else{
								
								printMsg =  " <div style='text-align: center;'> Broadcast Messages not Available </div>";
								
							}
							 
							document.getElementById("tabs1-broadcasts").innerHTML = printMsg;
							 
						 
							return false;

						}

					},

					error : function(a , b , c){

						alert("error "+a+b+c);
							
						}
				});

	}
	
    
	   $(document).ready( function() {
		      $('#tab-container').easytabs();
		      getBMessages();
		      
		    });
		    
    
  </script>

</head>

 
<body class="formbg">

<div class="pure-container" data-effect="pure-effect-1">
            <input type="checkbox" id="pure-toggle-right" class="pure-toggle" data-toggle="right" style="display:none;"/>
            <label id="firstButton" class="pure-toggle-label" for="pure-toggle-right" data-toggle-label="right" style="display:none;">+</label> 

            <nav class="pure-drawer" data-position="right">
	            <table class='flatTable'>
					<tr class='titleTr' style="font-size: 14px;">
						<td colspan='2' class='titleTd'><span key='alert/broadcast-list'>ALERT/BROADCAST LIST</span></td>					
						<td colspan='3'>
							<div style="margin-left:70%">
							<span style='margin-left:20px;cursor:pointer;'><a id='tabsalerts' class='fancybox' href='#' style="color:#fff;text-decoration:none;"><sapn key='alerts'>ALERTS</sapn></a></span>
							<span style='margin-left:20px;cursor:pointer;'><a id='tabsbroadcasts' class='fancybox' href='#' style="color:#fff;text-decoration:none;"><sapn key='broadcasts'>BROADCASTS</sapn></a></span>							
							
							<span style='margin-left:20px;'><a class='fancybox' href='#inline2' style="display:none;"><img src='/HIS/hisglobal/images/addTask.png' id="displayDeleteList" title='Add Task'></a></span>
							</div>
						</td>
				    </tr>					
				</table>
	            <div style='overflow:auto;border-bottom:5px solid black;background-color:#fff;' id="tabs1-alerts">
	                  <h3 style="text-align:center;"><sapn key='data-not-available'>Data not available!!!!</sapn></h3>
	            </div> 
	            <div style='overflow:auto;border-bottom:5px solid black;background-color:#fff;display:none;' id="tabs1-broadcasts">
	                  <h3 style="text-align:center;"><sapn key='data-not-available'>Data not available!!!!</sapn></h3>
	            </div>    
	            
            </nav>   
            
            <div class="pure-pusher-container">                
                <label class="pure-overlay" for="pure-toggle-right" data-overlay="right"></label> 
            </div>
        </div>
	  
</body>
</html>

