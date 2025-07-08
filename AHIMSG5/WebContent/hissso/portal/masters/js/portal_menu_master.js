 let menuData = [ ];


// Function to populate form fields with menu data
function populateForm(menuId) {
    function findMenu(menuList, menuId) {
        for (let menu of menuList) {
            if (menu.menuId == menuId) {
                return menu;
            }
            if (menu.submenu && menu.submenu.length > 0) {
                const submenu = findMenu(menu.submenu, menuId);
                if (submenu) {
                    return submenu;
                }
            }
        }
        return null;
    }
     const selectedMenu = findMenu(menuData, menuId);
    if (selectedMenu) {
        $('#addParentMenuButton').hide();
        $('#deleteMenuButton').show();
        $('#updateMenuButton').show();
        $('#resetMenuButton').show();

		$('#menuId').val(selectedMenu.menuId);
        $('#parentMenu').prop('disabled', true);
        $('#menuTitle').val(selectedMenu.title);
        $('#menuTitleHindi').val(selectedMenu.titleHindi);        
        $('#menuOrder').val(selectedMenu.menuOrder);
        $('#url').val(selectedMenu.url);
        $('#contentType').val(selectedMenu.contentType);
        $('#menuSearchTerms').val(selectedMenu.menuSearchTerms);
        

        if (selectedMenu.encodedContent && selectedMenu.encodedContent.length > 0)
            $('#encodedContent').val(decodeURIComponent(escape(atob(selectedMenu.encodedContent))));
        else    
            $('#encodedContent').val('');
        
        if (selectedMenu.encodedContentHindi && selectedMenu.encodedContentHindi.length > 0)
            $('#encodedContentHindi').val(decodeURIComponent(escape(atob(selectedMenu.encodedContentHindi))));   		 
        else    
            $('#encodedContentHindi').val('');

        
        
        syncToEditor('editor_eng' , 'encodedContent');
        syncToEditor('editor_hindi' , 'encodedContentHindi');
        
        
        toggleInputFields();
    } else {
        // If no menu is selected, clear the form
        $('#menuForm')[0].reset();
        toggleInputFields();
    }
}

function toggleInputFields() {
    const contentType = $('#contentType').val();
    
    if (contentType == 'url' || contentType == 'circular') {
        $('#urlField').show();
        $('#encodedContentField').hide();
        $('#encodedContentFieldHindi').hide();
        $('#searchTermsDiv').hide();
        $('#menuSearchTerms').val("");
        
        $('#suggestedSearchTermsDiv').hide();
        $('#suggestedmenuSearchTerms').val("");
         
        
    } else if (contentType == 'html') {
        $('#urlField').hide();
        $('#encodedContentField').show();
        $('#encodedContentFieldHindi').show();    
        $('#searchTermsDiv').show();
        $('#suggestedSearchTermsDiv').show();
        
    } else {
        $('#urlField').hide();
        $('#encodedContentField').hide();
        $('#encodedContentFieldHindi').hide();
        $('#searchTermsDiv').hide();
        $('#menuSearchTerms').val("");
        
        $('#suggestedSearchTermsDiv').hide();
        $('#suggestedmenuSearchTerms').val("");
        
        
    }
}

function toggleButtons() {
    const parentMenuValue = $('#parentMenu').val();
    if (parentMenuValue == "") {
        $('#addParentMenuButton').show();
        $('#addSubmenuButton').hide();
    } else {
        $('#addParentMenuButton').hide();
        $('#addSubmenuButton').show();
    }
}


function getParentMaxMenuId(menuData) {
    let maxMenuId = 10;

    menuData.forEach(menu => {
        const menuId = parseInt(menu.menuId, 10);
        if (menuId > maxMenuId) {
            maxMenuId = menuId;
        }
    });

    return (maxMenuId + 1).toString();
}


// Function to add a parent menu
function addParentMenu() {
    const form = $('#menuForm')[0];
	 
	 
    const formData = new FormData(form);
    const menu = {
        title: formData.get('menuTitle'),
        titleHindi: formData.get('menuTitleHindi'),
        menuId: getParentMaxMenuId(menuData),
		menuOrder: formData.get('menuOrder'),
        url: formData.get('url') || "#",
        contentType: formData.get('contentType'),
        encodedContent: btoa(unescape(encodeURIComponent(formData.get('encodedContent')) )) || "",
        encodedContentHindi: btoa(unescape(encodeURIComponent( formData.get('encodedContentHindi') ))) || "",
        menuSearchTerms:formData.get('menuSearchTerms'), 
        submenu: []
    };
    menuData.push(menu);
    localStorage.setItem('menuData', JSON.stringify(menuData));
    updateParentMenuOptions();
    $('#menuForm')[0].reset();
    toggleInputFields(); // Reset input fields visibility
    toggleButtons(); // Reset button visibility
    
    displayMenuTree(menuData);
    
    alert('Parent menu added!');
}

// Function to generate max sub-menu id for a given parent menu
function getMaxSubMenuId(menuData, parentMenuId) {
    let maxSubMenuId = 10;

    function findSubMenu(menuList, parentMenuId) {
        menuList.forEach(menu => {
            if (menu.menuId.startsWith(parentMenuId) && menu.menuId.length > parentMenuId.length) {
                const subMenuId = parseInt(menu.menuId.slice(parentMenuId.length), 10);
                if (subMenuId > maxSubMenuId) {
                    maxSubMenuId = subMenuId;
                }
            }
            if (menu.submenu && menu.submenu.length > 0) {
                findSubMenu(menu.submenu, menu.menuId);
            }
        });
    }

    findSubMenu(menuData, parentMenuId);
    
    // Generate new sub-menu ID
    const newSubMenuId = parentMenuId + String(maxSubMenuId + 1).padStart(2, '0');
    return newSubMenuId;
}

// Function to add a submenu
function addSubmenu() {
    const form = $('#menuForm')[0];
	
    const formData = new FormData(form);
    const parentMenuId = formData.get('parentMenu');
    if (!parentMenuId) {
        alert('Please select a parent menu.');
        return;
    }
	  
    const submenu = {
    		 title: formData.get('menuTitle'),
    	        titleHindi: formData.get('menuTitleHindi'),
    	        menuId: getParentMaxMenuId(menuData),
    			menuOrder: formData.get('menuOrder'),
    	        url: formData.get('url') || "#",
    	        contentType: formData.get('contentType'),
    	        encodedContent: btoa(unescape(encodeURIComponent(formData.get('encodedContent')) )) || "",
    	        encodedContentHindi: btoa(unescape(encodeURIComponent( formData.get('encodedContentHindi') ))) || "",
    	        menuSearchTerms:formData.get('menuSearchTerms'), 
        submenu: []
    };

    // Recursive helper function to add submenu
    function addSubmenuRecursive(menuList, parentMenuId, submenu) {
        for (let menu of menuList) {
            if (menu.menuId == parentMenuId) {
                menu.submenu.push(submenu);
                return true; // Stop further recursion once the submenu is added
            }
            if (menu.submenu.length > 0) {
                if (addSubmenuRecursive(menu.submenu, parentMenuId, submenu)) {
                    return true; // Stop further recursion once the submenu is added
                }
            }
        }
        return false; // If no matching parent menu is found
    }

    addSubmenuRecursive(menuData, parentMenuId, submenu);
    localStorage.setItem('menuData', JSON.stringify(menuData));
    updateParentMenuOptions();
    $('#menuForm')[0].reset();
    toggleInputFields(); // Reset input fields visibility
    toggleButtons(); // Reset button visibility
    
    displayMenuTree(menuData);
    
    alert('Submenu added!');
}
        

// Function to edit a menu
function editMenu() {
    const form = $('#menuForm')[0];
    const formData = new FormData(form);
    const menuId = formData.get('menuId');
    const updatedMenu = {
    		 title: formData.get('menuTitle'),
    	        titleHindi: formData.get('menuTitleHindi'),
    	        menuId: getParentMaxMenuId(menuData),
    			menuOrder: formData.get('menuOrder'),
    	        url: formData.get('url') || "#",
    	        contentType: formData.get('contentType'),
    	        encodedContent: btoa(unescape(encodeURIComponent(formData.get('encodedContent')) )) || "",
    	        encodedContentHindi: btoa(unescape(encodeURIComponent( formData.get('encodedContentHindi') ))) || "",
    	        menuSearchTerms:formData.get('menuSearchTerms'), 
        submenu: []
    };

    function updateMenuRecursive(menuList, menuId, updatedMenu) {
        for (let i = 0; i < menuList.length; i++) {
            if (menuList[i].menuId == menuId) {
            	
            	updatedMenu.submenu = menuList[i].submenu;
                menuList[i] = updatedMenu;
                
                return true; 
            }
            if (menuList[i].submenu && menuList[i].submenu.length > 0) {
                if (updateMenuRecursive(menuList[i].submenu, menuId, updatedMenu)) {
                    return true;
                }
            }
        }
        return false;
    }

    updateMenuRecursive(menuData, menuId, updatedMenu);
    localStorage.setItem('menuData', JSON.stringify(menuData));
    updateParentMenuOptions();
    $('#menuForm')[0].reset();
    toggleInputFields(); 
    toggleButtons(); 

    displayMenuTree(menuData);

    $('#deleteMenuButton').hide();
    $('#updateMenuButton').hide();
    $('#resetMenuButton').hide();
    $('#parentMenu').prop('disabled', false);

    alert('Menu updated!');
}

// Function to delete a menu
function deleteMenu() {
    const form = $('#menuForm')[0];
    const formData = new FormData(form);
    const menuId = formData.get('menuId');
   
    function deleteMenuRecursive(menuList, menuId) {
        for (let i = 0; i < menuList.length; i++) {
            if (menuList[i].menuId == menuId) {
                menuList.splice(i, 1);
                return true; // Stop further recursion once the menu is deleted
            }
            if (menuList[i].submenu && menuList[i].submenu.length > 0) {
                if (deleteMenuRecursive(menuList[i].submenu, menuId)) {
                    return true; // Stop further recursion once the submenu is deleted
                }
            }
        }
        return false; // If no matching menu is found
    }

    deleteMenuRecursive(menuData, menuId);
    localStorage.setItem('menuData', JSON.stringify(menuData));
    updateParentMenuOptions();
    
    $('#menuForm')[0].reset();
    toggleInputFields(); 
    toggleButtons(); 

    displayMenuTree(menuData);

    $('#deleteMenuButton').hide();
    $('#updateMenuButton').hide();
    $('#resetMenuButton').hide();
    $('#parentMenu').prop('disabled', false);
    
    alert('Menu deleted!');
}
		
		 // Function to update parent menu options
function updateParentMenuOptions() {
    const $parentMenuSelect = $('#parentMenu');
    $parentMenuSelect.html('<option value="">Select Parent Menu</option>'); // Reset options

    function addMenuOptions(menuList, prefix = '') {
        menuList.forEach(menu => {
            const $option = $('<option>').val(menu.menuId).text(`${prefix}${menu.title}`);
            $parentMenuSelect.append($option);
            if (menu.submenu && menu.submenu.length > 0) {
                addMenuOptions(menu.submenu, `${prefix}${menu.title} → `); // Recursively add submenu options
            }
        });
    }

    addMenuOptions(menuData);
}

// Function to highlight search terms
function highlightSearchTerm($element, searchTerm) {
    const regex = new RegExp(`(${searchTerm})`, 'gi');
    $element.html($element.text().replace(regex, '<span class="highlight">$1</span>'));
}

// Function to search menu
function searchMenu() {
    const searchTerm = $('#searchField').val().toLowerCase();
    const $menuItems = $('#menu li');
    
    $menuItems.addClass('hidden');

    function searchMenuRecursive($menuList) {
        $menuList.each((index, item) => {
            const $item = $(item);
            const $a = $item.find('a').first();
            if ($a && $a.text().toLowerCase().includes(searchTerm)) {
                $item.removeClass('hidden');
                highlightSearchTerm($a, searchTerm);
            } else if ($item.find('ul').length > 0) {
                searchMenuRecursive($item.find('ul > li'));
                if ($item.find('ul > li').toArray().some(li => !$(li).hasClass('hidden'))) {
                    $item.removeClass('hidden');
                }
            }
        });
    }

    if (searchTerm) {
        searchMenuRecursive($('#menu > ul > li'));
    } else {
        displayMenuTree(menuData);
    }
}


// Function to sort menu by menuOrder
function sortMenu(menu) {
    // Sort submenus first
    menu.forEach(function (item) {
        if (item.submenu && item.submenu.length > 0) {
            sortMenu(item.submenu);
        }
    });
    
    // Sort main menu
    menu.sort(function (a, b) {
        return a.menuOrder - b.menuOrder;
    });
}


function getMenuTitleByLang(menuObj){
			
	if($("#lang").val() === 'en'){
		
		return menuObj.title;
		
	}else{
		
		return menuObj.titleHindi ? menuObj.titleHindi :  menuObj.title;
		
	}
	
}


// Function to create menu tree
function createMenu(menuData) {

// Sort the menu data
sortMenu(menuData);

    const $ul = $('<ul>');

    menuData.forEach(menuItem => {
        const $li = $('<li>');
        const $a = $('<a>').text(getMenuTitleByLang(menuItem)).css('cursor', 'pointer').click(event => {
            event.preventDefault();
            
            const $previouslySelected = $('li a.selected');
            if ($previouslySelected) {
                $previouslySelected.removeClass('selected');
            }

            $a.addClass('selected');
            populateForm(menuItem.menuId);
			
			$('#parentMenu').val("");
			$('#parentMenu').prop('disabled', true);
			$('#addSubmenuButton').hide();
			
			
        });

        $li.append($a);
        if (menuItem.submenu && menuItem.submenu.length > 0) {
            $li.append(createMenu(menuItem.submenu));
        }

        $ul.append($li);
    });

    return $ul;
}


function languageChange(){
	 
	displayMenuTree(menuData);
	
}

// Function to display menu tree
function displayMenuTree(menuData) {
    $('#menu').empty();
    $('#menu').append(createMenu(menuData));
}

// Function to reset button
function resetButton() {
    const $form = $('#menuForm');
    $form[0].reset();
    toggleInputFields(); 
    toggleButtons(); 
    $('#searchField').val('');
    displayMenuTree(menuData);

	$('#parentMenu').prop('disabled', false);

    $('#deleteMenuButton').hide();
    $('#updateMenuButton').hide();
    $('#resetMenuButton').hide();
}

// Function to generate JSON output
function generateJSON() {
    const storedMenuData = JSON.parse(localStorage.getItem('menuData'));
	
	sortMenu(storedMenuData);
	
	  var blob = new Blob(['{"menu":'+JSON.stringify(storedMenuData, null, 4)+'}'], { type: "text/plain" });
            // Create a link element
            var link = document.createElement("a");
            // Set the download attribute with a file name
            link.download = "menu.json";
            // Create a URL for the blob and set it as the href attribute
            link.href = window.URL.createObjectURL(blob);
            // Append the link to the body
            document.body.appendChild(link);
            // Programmatically click the link to trigger the download
            link.click();
            // Remove the link from the document
            document.body.removeChild(link);
	
	
  //  $('#jsonOutput').text(JSON.stringify(storedMenuData, null, 4));
}
function loadLiveMenu(confirmLoad){
	
	if(confirmLoad==1 && confirm("This will load live menu here and current changes will be discarded \n Are you sure want to load?")==false){
		return;
	}
	
	$.ajax({
        url: '/AHIMSG5/hissso/portal/json/menu.json', // Path to your JSON file
        type: 'GET',
        dataType: 'json',
        success: function(data) {
        	menuData=data.menu;
        	localStorage.setItem('menuData', JSON.stringify(menuData));
        	  updateParentMenuOptions();
              
              toggleButtons(); // Set initial button visibility
              displayMenuTree(menuData);
        }
	});
}


function toggleEditor(checkId , editorId , textAreaId) {
    var checkbox = document.getElementById(checkId);
    var editorDiv = document.getElementById(editorId);
    var textAreaDiv = document.getElementById(textAreaId);
    if (checkbox.checked) {
    	textAreaDiv.classList.remove("hidden");
    	editorDiv.classList.add("hidden");
    	$(".toolbar").hide();
    	
    } else {
    	$(".toolbar").show();
    	editorDiv.classList.remove("hidden");
    	textAreaDiv.classList.add("hidden");
    	
    }
}


// Load initial data and update parent menu options on page load
$(document).ready(function(){
   
	$( "button" ).click(function( event ) {
		event.preventDefault();
	});
	const storedMenuData = JSON.parse(localStorage.getItem('menuData')) || [];
    if (storedMenuData.length > 0) {
        menuData = storedMenuData;
        updateParentMenuOptions();
        
        toggleButtons(); // Set initial button visibility
        displayMenuTree(menuData);
        
    }else{
    	loadLiveMenu(0);
    }    
   
    syncToEditor('editor_eng' , 'encodedContent');
    syncToEditor('editor_hindi' , 'encodedContentHindi');
	  
    
    document.getElementById("engEditorSwitch").addEventListener("change", function() {
    	toggleEditor('engEditorSwitch', 'editor_eng' , 'encodedContent');
    });
    
    
    document.getElementById("hindiEditorSwitch").addEventListener("change", function() {
    	toggleEditor('hindiEditorSwitch', 'editor_hindi' , 'encodedContentHindi');
    });
    
    
    
});



function calculateTF(word, text) {
    var words = text.split(/\W+/);
    var wordCount = words.length;
    var wordFrequency = words.filter(w => w.toLowerCase() === word.toLowerCase()).length;
    return wordFrequency / wordCount;
}

function calculateIDF(word, texts) {
    var numDocumentsContainingWord = texts.filter(text => text.toLowerCase().includes(word.toLowerCase())).length;
    return Math.log(texts.length / (1 + numDocumentsContainingWord));
}

function extractKeywords() {
    var text = document.getElementById('encodedContent').value;
    
    
    const stopWords = ["the", "and", "to", "of", "in", "is", "for", "by", "on", "this", "with", "from", "a", "an", "that", "as", "at", "or", "are", "all"];
    
    // Convert text to lowercase and split into words
    const words = text.toLowerCase().split(/\W+/);
    
    // Filter out the stop words and empty strings
    const filteredWords = words.filter(word => !stopWords.includes(word) && word.length > 4);
    
    // Create a Set to store unique keywords
    const keywordsSet = new Set(filteredWords);
    
    // Convert Set to an array and sort it alphabetically
    const keywords = Array.from(keywordsSet).sort((a, b) => b.length - a.length).slice(0, 20);
        
    document.getElementById('suggestedmenuSearchTerms').innerHTML = '<b>Suggested Search Terms: </b>' + keywords.join(', ');
     
}

 
 


function execCmd(e , command, value = null) {
	
	e.preventDefault();
	
    document.execCommand(command, false, value);
    syncToTextArea('editor_eng' , 'encodedContent');
	 syncToTextArea('editor_hindi' , 'encodedContentHindi');
 }

 function syncToTextArea(editorId, textAreaId) {
	 if(document.getElementById(textAreaId)) {
		 document.getElementById(textAreaId).value = document.getElementById(editorId).innerHTML;
		 extractKeywords();
	 }
		
 }

 function syncToEditor(editorId, textAreaId) {
	 if(document.getElementById(textAreaId)){
		 
		 document.getElementById(editorId).innerHTML = document.getElementById(textAreaId).value;
		 extractKeywords();
	 }
		
 }

 
function openTab(tabId){
	
	$('#masterKey').val("portalLabelForm")
	$('#hmode').val("CallMasterPage");
	document.forms[0].submit();	
	
} 
