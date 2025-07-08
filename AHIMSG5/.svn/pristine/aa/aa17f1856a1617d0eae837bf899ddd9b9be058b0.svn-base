<!DOCTYPE html>
<%@page import="hissso.config.HISSSOConfig"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     <script src="/AHIMSG5/hissso/portal/js/jquery-3.7.1.min.js"></script>
	 
	 <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/fonts/fontawesome-free-6.4.0-web/css/all.min.css">
	 <link rel="stylesheet" href="/HIS/hisglobal/FormFlowX/plugins/bootstap/css/bootstrap.min.css">
	 <link rel="stylesheet" href="/AHIMSG5/hissso/portal/masters/css/portalMst.css">
	 <script src="/AHIMSG5/hissso/portal/masters/js/portal_menu_master.js"></script> 
    <title>Menu Information Capture</title>
    <style>
      
		
    </style>
</head>
<body>
<form id="menuForm" action="/AHIMSG5/FFXACTION" method="post" style="width: 100%;">

<div class="tab">
    <button class="tablinks active" >Menu Information</button>
    <button class="tablinks" onclick="openTab('Tab2')">Label Information</button>    
</div>

<div id="Tab1" class="tabcontent">
 <div class="container">
    <div class="box">
        <h3>Menu Information</h3>
        
            <div class="form-group">
                <label for="parentMenu">Parent Menu</label>
                <select id="parentMenu" name="parentMenu" onchange="toggleButtons()">
                    <option value="">Select Parent Menu</option>
                </select>
            </div>
            <div class="form-group">
                <label for="menuTitle">Menu Title</label>
                <input type="text" id="menuTitle" name="menuTitle" required>
				 <input type="hidden" id="menuId" name="menuId" >
            </div>
             <div class="form-group">
                <label for="menuTitle">Menu Title In Hindi</label>
                <input type="text" id="menuTitleHindi" name="menuTitleHindi" required>				 
            </div>
           
            <div class="form-group">
                <label for="menuOrder">Menu Order</label>
                <input type="text" id="menuOrder" name="menuOrder" required>
            </div>
             
            <div class="form-group">
                <label for="contentType">Content Type</label>
                <select id="contentType" name="contentType" onchange="toggleInputFields()">
                    <option value="">Select</option>
                    <option value="url">URL</option>
                    <option value="html">HTML</option>
                    <option value="circular">Circular</option>
                </select>
            </div>
            <div class="form-group" id="urlField" style="display: none;">
                <label for="url">URL</label>
                <input type="text" id="url" name="url">
            </div>
            
            <div class="editorcontainer" id="encodedContentField" style="display: none;">
              <div class='editorHeader' >English Content Editor  
              <span style="margin-left: 35%;font-size: 12px;">Editor <label class="switch">
				  <input type="checkbox" id="engEditorSwitch" >
				  <span class="slider round"></span>
				</label> Text</span>              
              </div>  
      <div class="toolbar">
         <button onclick="execCmd(event,'bold')" title="Bold"><i class="fas fa-bold"></i></button>
         <button onclick="execCmd(event,'italic')" title="Italic"><i class="fas fa-italic"></i></button>
         <button onclick="execCmd(event,'underline')" title='Underline'><i class="fas fa-underline"></i></button>
         <button onclick="execCmd(event,'insertUnorderedList')" title="Unordered List" ><i class="fas fa-list-ul"></i></button>
         <button onclick="execCmd(event,'insertOrderedList')" title="Ordered List"><i class="fas fa-list-ol"></i></button>
         <select onchange="execCmd(event,'formatBlock', this.value)">
            <option value="" disabled selected>Heading</option>
            <option value="p">Normal</option>
            <option value="H1">H1</option>
            <option value="H2">H2</option>
            <option value="H3">H3</option>
            <option value="H4">H4</option>
            <option value="H5">H5</option>
         </select>
         <button onclick="execCmd(event,'justifyLeft')" title="Justify Left"><i class="fas fa-align-left"></i></button>
         <button onclick="execCmd(event,'justifyCenter')" title="Justify Center"><i class="fas fa-align-center"></i></button>
         <button onclick="execCmd(event,'justifyRight')" title="Justify Right"><i class="fas fa-align-right"></i></button>
         <button onclick="execCmd(event,'justifyFull')" title="Justify Full"><i class="fas fa-align-justify"></i></button>
      </div>
      <div class='editor' id="editor_eng" contenteditable="true" oninput="syncToTextArea('editor_eng' , 'encodedContent')">Start typing here...</div>
        <textarea class='rte hidden' id="encodedContent" name="encodedContent" cols="50" rows="10" oninput="syncToEditor('editor_eng' , 'encodedContent');"></textarea>
   </div>
             <br>
                       
            <div class="editorcontainer" id="encodedContentFieldHindi" style="display: none;">
             <div class='editorHeader' >Hindi Content Editor
             
             <span style="margin-left: 35%;font-size: 12px;">Editor<label class="switch">
  <input type="checkbox" id="hindiEditorSwitch" onchange="toggleDiv('hindiEditorSwitch', 'editor_hindi' , 'encodedContentHindi');">
  <span class="slider round"></span>
</label>Text</span>
             
             </div>  
      	<div class="toolbar">
         <button onclick="execCmd(event,'bold')" title="Bold"><i class="fas fa-bold"></i></button>
         <button onclick="execCmd(event,'italic')" title="Italic"><i class="fas fa-italic"></i></button>
         <button onclick="execCmd(event,'underline')" title='Underline'><i class="fas fa-underline"></i></button>
         <button onclick="execCmd(event,'insertUnorderedList')" title="Unordered List" ><i class="fas fa-list-ul"></i></button>
         <button onclick="execCmd(event,'insertOrderedList')" title="Ordered List"><i class="fas fa-list-ol"></i></button>
         <select onchange="execCmd(event,'formatBlock', this.value)">
            <option value="" disabled selected>Heading</option>
            <option value="p">Normal</option>
            <option value="H1">H1</option>
            <option value="H2">H2</option>
            <option value="H3">H3</option>
            <option value="H4">H4</option>
            <option value="H5">H5</option>
         </select>
         <button onclick="execCmd(event,'justifyLeft')" title="Justify Left"><i class="fas fa-align-left"></i></button>
         <button onclick="execCmd(event,'justifyCenter')" title="Justify Center"><i class="fas fa-align-center"></i></button>
         <button onclick="execCmd(event,'justifyRight')" title="Justify Right"><i class="fas fa-align-right"></i></button>
         <button onclick="execCmd(event,'justifyFull')" title="Justify Full"><i class="fas fa-align-justify"></i></button>
      </div>
      <div class='editor' id="editor_hindi" contenteditable="true" oninput="syncToTextArea('editor_hindi' , 'encodedContentHindi')">Start typing here...</div>
        <textarea class='rte hidden' id="encodedContentHindi" name="encodedContentHindi" cols="50" rows="10" oninput="syncToEditor('editor_hindi' , 'encodedContentHindi');"></textarea>
   </div>
            <br>
             <div style="display: none;" id='suggestedSearchTermsDiv'>
             		<div id='suggestedmenuSearchTerms' ></div>
            </div>
            <br>
               <div  style="display: none;" class="form-group" id='searchTermsDiv'>
                <label for="menuSearchTerms">Search Terms</label>
               	<textarea id='menuSearchTerms' name='menuSearchTerms' rows="5" cols="50"></textarea>
            </div>
            
            
            <button type="button" id="addParentMenuButton" onclick="addParentMenu()">Add Parent Menu</button>
           	<button type="button" id="addSubmenuButton" onclick="addSubmenu()" style="display: none;">Add Sub-menu</button>
         	<button type="button" id="updateMenuButton" onclick="editMenu()" style="display: none;">Edit Menu</button>
			<button type="button" id="deleteMenuButton" onclick="deleteMenu()" style="display: none;background-color: red;">Delete Menu</button>
           <button type="button" id="resetMenuButton" onclick="resetButton();" style="background-color: lightgrey;color: black;">Reset</button>
		   <button type="button" onclick="generateJSON()" style="background-color: lightgreen;color: black;">Download JSON</button>
		   <!-- <button type="button" id="loadLiveMenu" onclick="loadLiveMenu('1')">Load Live Menus</button> -->
        
        <pre id="jsonOutput"></pre>
    </div>
	<div class='box'>
		<div class="float-container">
		
		<div class="float-child"><h3>Menu Map</h3></div>
		<div class="float-child"> Language : <select name='lang' id='lang' onchange="languageChange();"><option value='en'>English</option> <option value='hi'>Hindi</option> </select> </div>
		
		</div>		
		<input type="text" id="searchField" onkeyup='searchMenu();' placeholder="Search Menu">
       		
	  <nav class='menu' id="menu"></nav>
	</div>
	</div>
</div>

<input type='hidden' id='varSSOTicketGrantingTicket' name='varSSOTicketGrantingTicket' value='<%= (String) request.getParameter(HISSSOConfig.LOGGEDIN_USER_GRANTING_TICKET_ID_VAR)%>'/>
<input type='hidden' id='masterKey' name='masterKey' value='<%=(String)request.getParameter("masterKey")%>'/>
<input type='hidden' id='hmode' name='hmode' value=''/>

</form>	
  </body>
</html>
