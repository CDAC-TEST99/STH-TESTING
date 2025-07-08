<!DOCTYPE html>
<%@page import="hissso.config.HISSSOConfig"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Interactive JSON Form and Table</title>
    <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
    <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/bootstap/css/bootstrap.min.css">
    
    <script src="/AHIMSG5/hissso/portal/js/jquery-3.7.1.min.js"></script>
    <script src="/AHIMSG5/hissso/portal/masters/js/portalLabelForm.js"></script>
    <link rel="stylesheet" href="/AHIMSG5/hissso/portal/masters/css/portalMst.css">
    <style>
       
    </style>
</head>
<body>
<form id="menuForm" action="/AHIMSG5/FFXACTION" method="post" style="width: 100%;">

<div class="tab">
    <button class="tablinks " onclick="openTab('Tab1')" >Menu Information</button>
    <button class="tablinks active" >Label Information</button>    
</div>

<div id="Tab2" class="tabcontent">
    <div class="container">
    <div class="box" style="width: 30%;">
        <h1>Portal Label Form</h1>
        <div class="form-group">
            <label for="key">Key:</label>
            <input type="text" id="key" class="form-control" placeholder="Enter JSON key">
        </div>
        <div class="form-group">
            <label for="en_value">Value (English):</label>
            <textarea  id="en_value" class="form-control" placeholder="Enter English value" rows="5" cols="50"></textarea>
            
        </div>
        <div class="form-group">
            <label for="hi_value">Value (Hindi):</label>
             <textarea  id="hi_value" class="form-control" placeholder="Enter Hindi value" rows="5" cols="50"></textarea>
             
        </div>
        <button id="addToLocalStorage" class="btn btn-primary">Add</button>
        <button id="downloadJson" class="btn btn-success">Download JSON</button>
        <button id="resetForm" class="btn btn-warning">Reset</button>
    </div>
    <div class="box" style="width: 70%;">
    <div class="table-container">
        <h1>Portal Label Data</h1>
        <div class="form-group">
            <input type="text" id="searchInput" class="form-control" placeholder="Search table...">
        </div>
        <table id="dataTable" class="table table-striped table-bordered">
            <thead>
                <tr>
                    <th>Key</th>
                    <th>Value (English)</th>
                    <th>Value (Hindi)</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <!-- Dynamic content will be added here -->
            </tbody>
        </table>
    </div>
    </div>
</div>  

<input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value='<%= (String) request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>'/>
<input type='hidden' id='masterKey' name='masterKey' value='<%=(String)request.getParameter("masterKey")%>'/>
<input type='hidden' id='hmode' name='hmode' value=''/>
 </div> 
</form>
   
</body>
</html>
