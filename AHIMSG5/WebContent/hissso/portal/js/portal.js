let menuData = [];
let siteLabel={};

$(document).ready(function () {
	//localStorage.setItem("cghsCounterDate", date);
	//fetchCityNames();
	$.ajax({
        url: '/AHIMSG5/hissso/portal/json/menu.json', // Path to your JSON file
        type: 'GET',
        dataType: 'json',
        success: function(data) {
        	menuData=data;
        	//alert(JSON.stringify(menuData));
        	createMenu(menuData.menu, document.getElementById("menu"));
        	initAfterMenuJsonLoad();        	
        }
	});
	
	document.getElementById('closeModalBtn').addEventListener('click', function() {
    var modal = document.getElementById('pdfModal');
    modal.style.display = 'none';
	});
	$.ajax({
        url: '/AHIMSG5/hissso/portal/json/label.json', // Path to your JSON file
        type: 'GET',
        dataType: 'json',
        success: function(data) {
        	siteLabel=data;
        	var lang =localStorage.getItem('siteLanguage');
        	if (lang!=undefined)
        		$('#lang').val(lang);
        	else
        		lang='en';
        	
        	if(lang=='en')
        		initLanguageLabels();
        	else
        		languageChange();
        	        	        	
        }
	});
 });



function initLanguageLabels(){
	var lang= $('#lang').val();
	if(lang==undefined)
		lang='en';
	
	$("[data-lang-key]").each(function(){
		var key=$(this).attr("data-lang-key");
		var val='';
		if(siteLabel[key]!=undefined )
			val= siteLabel[key][lang];
		
		if(val==undefined){
			val=siteLabel[key]['en'];
		}
		
		if(val==undefined)
			val="";
		
		
		$(this).html(val);
	})
}

function initAfterMenuJsonLoad(){
	
	console.log("inside >>initAfterMenuJsonLoad ");
	
	
    const $submenuItems = $('.navbar-nav a'); // Adjust the selector based on your menu structure
    
    

    $submenuItems.on('click', function (event) {
        event.preventDefault(); // Prevent default link behavior
        
        

        // Fetch and display the content based on the clicked submenu item
        const submenuId = $(this).data('submenu-id'); // Assuming you have a data attribute for submenu ID
        const menuType = $(this).data('submenu-type');
       // alert(submenuId);
        //alert(JSON.stringify(menuData.menu));
        const menuObj = findMenuById(submenuId, menuData.menu);
        setMenuDetailsByMenuId(menuObj);
        
        console.log(      "menuobjj"  +setMenuDetailsByMenuId(menuObj), menuObj )
    });
    
    
	displayCircularDetails(0);
	
}

    function setMenuDetailsByMenuId(menuObj) {
    	
    	console.log("inside >>setMenuDetailsByMenuId   >> ",menuObj.url ,menuObj.menuId,menuObj.menuOrder);
    	
    	const $sliderSection = $('#slider');
        const $contentDiv = $('#submenu-content');
        if (menuObj != null) {
        	var contentType= menuObj.contentType;
        	
        	
        	localStorage.setItem('ctMenuId', menuObj.menuId);
        	localStorage.setItem('ctMenuType', 'normal');
        	
        	
        	//alert("inside setMenuDetailsByMenuId contentType >>> "+contentType);
        	switch(contentType) {
        	  case 'html':
        		  // $("#submenu-title").html(getMenuTitleByLang(menuObj));
                  setMenuBreadCrumb(menuObj.menuId, menuData);
                 $sliderSection.add($("#sociallinks")).add($("#newsSection")).hide();
                  $contentDiv.show();
                  $("#submenu-banner").show();
                  $("#content-display").html( getMenuContentByLang(menuObj));
        	    break;
        	  case 'url':
        		if(menuObj.url=="" || menuObj.url=='#'){
        			url="/AHIMSG5/hissso/Login";
        			window.location.href=url;
        		} 
        		else
        			window.open(menuObj.url, '_blank');
        	    break;
        	  case 'files':
        		  displayFileDetails(menuObj);
          	    break;  
        	    
        	  
        	}
        	
            
        }
    }

      function setMenuBreadCrumb(menuId, menuData) {
       
       
        const menuArray = getMenuHierarchyById(menuId, menuData.menu);
        let breadcrumb = '';

        menuArray.forEach((item, index) => {
            const [id, newtitle] = item.split('###');
                       
            const menuDataVal = menuData.menu ? menuData.menu : menuData;
           
            const menuObjVal = findMenuById(id.toString() , menuDataVal);
           
            console.log(menuObjVal);
           
            const title = getMenuTitleByLang(menuObjVal);
           
            // Capture the title for the last menu item (this will be used for the h2 heading)
            if (index === menuArray.length - 1) {
                pageTitle = title; // Set the page title
            }
           
            if (index !== menuArray.length - 1) {
                breadcrumb += `<a style="cursor: pointer;" onclick="goToParentPage('${id}')" class="text-white opacity-75">${title} &nbsp;&nbsp;</a><i class="fa-solid fa-arrow-right text-white mx-1"></i> &nbsp;&nbsp;`;
            } else {
                breadcrumb += `<a style="cursor: pointer;" onclick="goToPage('${id}')" class="text-white opacity-75">${title}</a>`;
            }
        });
       
        $("#submenu-header").text(pageTitle);
        //$("#submenu-banner").html(headingHtml);
       
        $("#submenu-breadcrumb").html(breadcrumb);
    }





    function findMenuById(menuId, menuData) {
    	
    	if(menuData)
        for (const menu of menuData) {
            if (menu.menuId == menuId) {
                return menu;
            }

            if (menu.submenu && menu.submenu.length > 0) {
                const foundInSubmenu = findMenuById(menuId, menu.submenu);
                if (foundInSubmenu) {
                    return foundInSubmenu;
                }
            }
        }
        return null;
    }

    function getMenuHierarchyById(menuId, menus = menuData.menu, path = []) {
        for (const menu of menus) {
            if (menu.menuId == menuId) {
                return [...path, `${menu.menuId}###${menu.title}`];
            }

            if (menu.submenu && menu.submenu.length > 0) {
                const result = getMenuHierarchyById(menuId, menu.submenu, [...path, `${menu.menuId}###${menu.title}`]);
                if (result) {
                    return result;
                }
            }
        }
        return null; // if no menu is found with the given menuId
    }

    function getAllSubmenuTitlesByParentId(parentMenuId, menus = menuData.menu) {
    	
    	console.log("inside >>getAllSubmenuTitlesByParentId ");
    	
        for (const menu of menus) {
            if (menu.menuId == parentMenuId && menu.submenu) {
                return menu.submenu.map(submenu => `${submenu.menuId}###${submenu.title}###${submenu.titleHindi}`);
            }

            if (menu.submenu && menu.submenu.length > 0) {
                const result = getAllSubmenuTitlesByParentId(parentMenuId, menu.submenu);
                if (result.length > 0) {
                    return result;
                }
            }
        }
        return []; // return an empty array if no submenu is found with the given parentMenuId
    }

    function goToPage(menuId) {
    	
    	console.log("inside >>goToPage ");
    	
    	localStorage.setItem('ctMenuId', menuId);
    	localStorage.setItem('ctMenuType', 'normal');
    	
        const menuObj = findMenuById(menuId, menuData.menu);
        setMenuDetailsByMenuId(menuObj);
    }

    function goToParentPage(menuId) {
    	
    	console.log("inside >>goToParentPage >> "+menuId);
    	
    	localStorage.setItem('ctMenuId', menuId);
    	localStorage.setItem('ctMenuType', 'parray');
    	
    	
        setmenuListByArray(getAllSubmenuTitlesByParentId(menuId, menuData.menu));
                          
        setMenuBreadCrumb(menuId, menuData.menu);
                        
    }

    function setmenuListByArray(menuArray) {
    	
        let menuList = '';
         
       // console.log("menuArray      :       "+menuArray);
        
        menuArray.forEach(item => {
            const [id, title,titleHindi] = item.split('###');
            
            const contentTitle = getMenuTitleByLangWithTitles(title , titleHindi);
            

            
			menuList += `
			  <li class="level3 official-menu-item">
			    <a style="cursor: pointer;" onclick="goToPage('${id}')" class="ruby-menu-link official-link">
			      ${contentTitle}
			    </a>
			  </li>
			`;        
			});
		  //$("#submenu-title").html(menuObj.title);
        //  setMenuBreadCrumb(menuObj.menuId, menuData);
        
        
        $('#slider').hide(); 
       $('#submenu-content').show();
	    $('#content-display').html(menuList);
         
    }
    
    
    
    function setFileListByArray(responses,menuObj) {
    	
    	//console.log("inside >>setFileListByArray ");
    	
        const displayNames = responses.map(item => ({
        	  displayName: item.displayName,
        	  displayHinName: item.displayHinName
        	}));

        let fileNames = responses.map(function (response) {
            return response.fileName;
        });
        
        let menuList = '';
        fileNames.forEach((item, index) => {
        	var lang = document.getElementById("lang").value;  
        	var displayName="";
        	
            if (lang === 'en') {
            	displayName = JSON.stringify(displayNames[index].displayName).match(/"(.*)"/)[1];
            } else if (lang === 'hi') {
            	displayName = JSON.stringify(displayNames[index].displayHinName).match(/"(.*)"/)[1];
            }
            menuList += '<li class="ruby-menu-item" style="margin: 10px 0; padding: 14px 18px; border: 1px solid #e0e0e0; border-radius: 10px; background-color: #ffffff; display: flex; align-items: center; justify-content: space-between; box-shadow: 0 2px 4px rgba(0,0,0,0.05); transition: all 0.3s ease; cursor: pointer;" onmouseover="this.style.transform=\'translateY(-3px)\'; this.style.boxShadow=\'0 6px 12px rgba(0,0,0,0.1)\'" onmouseout="this.style.transform=\'none\'; this.style.boxShadow=\'0 2px 4px rgba(0,0,0,0.05)\'"><a style="text-decoration: none; color: #1e1e1e; font-weight: 600; flex-grow: 1; display: flex; align-items: center; transition: color 0.3s ease;" onclick="displayFile(\'' + item + '\',\'' + displayName + '\')" class="ruby-menu-link"><i class="fa-solid fa-file-circle-check" style="color: #4caf50; margin-right: 12px; font-size: 20px; transition: transform 0.3s ease;" onmouseover="this.style.transform=\'scale(1.2) rotate(5deg)\'" onmouseout="this.style.transform=\'none\'"></i>' + displayName +'</a>'+'<i class="fa-solid fa-share-nodes" title="Share File" style="color: #607d8b; font-size: 18px; margin-left: 15px; transition: color 0.3s ease;" onclick="openSharePopup(\'' + item + '\', \'' + displayName + '\')"></i>'+'</li>'
        });
        

          $('#slider').hide();
         // $contentDiv.show();
          
          //$("#submenu-banner").show();
        $('#submenu-content').show();
	    $('#content-display').html(menuList);
    }
    
    

	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	        iframe.src = ""; 
	    }
	}
	 
	function displayFile(fileName, displayFileName , displayHinName) {
	    var fileNamePart = fileName.split('^')[0];
	    var folderNamePart = fileName.split('^')[1];
	    var lang = document.getElementById("lang").value;
	    var displayFileNames = "";
        if (lang === 'en') {
        	displayFileNames = displayFileName;
        	 console.log("displayFileName in1 :  "+displayFileNames);
        } else if (lang === 'hi') {
        	displayFileNames = displayHinName;
        	 console.log("displayFileName in2:  "+displayFileNames);
        }
    	
	    console.log("displayFileName :  "+displayFileNames);
	    var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + fileNamePart + "&folderName=" + folderNamePart + "&isGlobal=1";
	    
	    fetch(fileURL)
	        .then(response => response.blob())
	        .then(blob => {
	            var blobURL = URL.createObjectURL(blob);
	            
	            var iframe = document.getElementById('pdfIframe');
	            iframe.type = "application/pdf";
	            iframe.src = blobURL;

	            var modal = document.getElementById('pdfModal'); 
	            modal.style.display = "block";

	            
	            document.getElementById('pdfModalHeading').innerText = displayFileNames;
	        })
	        .catch(error => {
	            console.error('Error fetching the file:', error);
	        });
	}

	// Close modal when clicking the close button
	document.getElementById('closeModalBtn').addEventListener('click', function() {
	    document.getElementById('pdfModal').style.display = 'none';
	});

	
	
	function displayFileURL(fileName, displayFileName) {
	    var fileNamePart = fileName.split('^')[0];
	    var folderNamePart = fileName.split('^')[1];
	    
	    var displayFileName = displayFileName;
	    
	    console.log("displayFileName  "+displayFileName);
	    var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + fileNamePart + 			"&folderName=" + folderNamePart + "&isGlobal=1";
	    
	    

	}

	// Close modal when clicking the close button
	document.getElementById('closeModalBtn').addEventListener('click', function() {
	    document.getElementById('pdfModal').style.display = 'none';
	});
	

	function displayFileDetails(menuObj){
		// console.log("inside displayFileDetails   >>"+menuDtl);
		 	
		try {
		    $.ajax({
		        url: menuObj.url,
		        method: "GET",
		        dataType: "json", 
		        success: function (responses) {
		        	
	                if (!responses || responses.length === 0) {
	                    alert("No records found.");
	                    return;
	                }
	                
		        	if(responses.length > 1 ){		              

		        	  	setFileListByArray(responses,menuObj);
		        	  	
		        	}else{
		        		
		        		displayFile(responses[0].fileName , responses[0].displayName, responses[0].displayHinName);

		        	}
		        	 
		    
		    },
	        error: function (xhr, status, error) {
	            console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
	           // alert("An error occurred while processing your request: " + error);
	        }
	    });
	} catch (err) {
	    console.error("Exception occurred:", err.message);
	    alert("An unexpected error occurred: " + err.message);
	}
}


 function setFileListByArray1(responses) {
	 
	/* var fileNamePart = item.split('^')[0];
var folderNamePart = item.split('^')[1];
var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName=" + fileNamePart + "&folderName=" + folderNamePart + "&isGlobal=1";
   */
    console.log("inside >>setFileL yArray 1");
   
        const displayNames = responses.map(item => item.displayName);
      //  console.log("Display Names:", displayNames);
       
        let fileNames = responses.map(function (response) {
            return response.fileName;
        });
    //    console.log("File Names Array:", fileNames);
       
        let menuList = '';
        fileNames.forEach((item, index) => {
            // Get the displayName corresponding to the fileName from the 'responses' array
            let displayName = displayNames[index];
         menuList += '<li class="ruby-menu-item" style="margin: 10px 0; padding: 14px 18px; border: 1px solid #e0e0e0; border-radius: 10px; background-color: #ffffff; display: flex; align-items: center; justify-content: space-between; box-shadow: 0 2px 4px rgba(0,0,0,0.05); transition: all 0.3s ease; cursor: pointer;" onmouseover="this.style.transform=\'translateY(-3px)\'; this.style.boxShadow=\'0 6px 12px rgba(0,0,0,0.1)\'" onmouseout="this.style.transform=\'none\'; this.style.boxShadow=\'0 2px 4px rgba(0,0,0,0.05)\'">' +
    '<a style="text-decoration: none; color: #1e1e1e; font-weight: 600; flex-grow: 1; display: flex; align-items: center; transition: color 0.3s ease;" onclick="displayFile(\'' + item + '\',\'' + displayName + '\')" class="ruby-menu-link">' +
    '<i class="fa-solid fa-file-circle-check" style="color: #4caf50; margin-right: 12px; font-size: 20px; transition: transform 0.3s ease;" onmouseover="this.style.transform=\'scale(1.2) rotate(5deg)\'" onmouseout="this.style.transform=\'none\'"></i>' + displayName +
    '</a>' +
    '<i class="fa-solid fa-share-nodes" title="Share File" style="color: #607d8b; font-size: 18px; margin-left: 15px; transition: color 0.3s ease;" onclick="openSharePopup(\'' + item + '\', \'' + displayName + '\')"></i>' +
    '</li>';
        });


          $('#slider').hide();
         // $contentDiv.show();
         
          //$("#submenu-banner").show();
        $('#submenu-content').show();
   $('#content-display').html(menuList);
    }


// share pop up
function openSharePopup(fileName, displayName) {
	const baseURL = document.getElementById('baseURL').value;
	
    const fileNamePart = fileName.split('^')[0];
    const folderNamePart = fileName.split('^')[1];
    const shareURL = baseURL+`/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName=${fileNamePart}&folderName=${folderNamePart}&isGlobal=1`;
    
    // Set the link in the input field
    document.getElementById('sharePopupInput').value = shareURL;
    document.getElementById('sharePopupTitle').innerText = `Share: ${displayName}`;
    
    // Create share links for different platforms
    const whatsappURL = `https://wa.me/?text=${encodeURIComponent(shareURL)}`;
    const facebookURL = `https://www.facebook.com/sharer/sharer.php?u=${encodeURIComponent(shareURL)}`;
    const emailURL = `mailto:?subject=Check this link&body=${encodeURIComponent(shareURL)}`;
    
    document.getElementById('whatsappLink').setAttribute('href', whatsappURL);
    document.getElementById('facebookLink').setAttribute('href', facebookURL);
    document.getElementById('emailLink').setAttribute('href', emailURL);
    
    // Show the popup
    document.getElementById('sharePopup').style.display = 'block';
    document.getElementById('sharePopupOverlay').style.display = 'block';
}

function closeSharePopup() {
    document.getElementById('sharePopup').style.display = 'none';
    document.getElementById('sharePopupOverlay').style.display = 'none';
}

function copyShareLink() {
    const input = document.getElementById('sharePopupInput');
    input.select();
    input.setSelectionRange(0, 99999); // For mobile
    navigator.clipboard.writeText(input.value).then(() => {
        alert("Link copied to clipboard!");
    });
}






function displayFileDetails1(url){
// console.log("inside displayFileDetails   >>"+menuDtl);

try {
   $.ajax({
       url: url,
       method: "GET",
       dataType: "json",
       success: function (responses) {
       
                if (!responses || responses.length === 0) {
                    alert("No records found.");
                    return;
                }
               
        if(responses.length > 1 ){              

          setFileListByArray1(responses);
         
        }else{
       
        displayFile(responses[0].fileName , responses[0].displayName , responses[0].displayHinName);

        }
       
   
   },
        error: function (xhr, status, error) {
            console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
        }
    });
} catch (err) {
    console.error("Exception occurred:", err.message);
    alert("An unexpected error occurred: " + err.message);
}
}



	
	/*For Latest News*/
	function displayCircularDetails(groupId,subGroupId){
		
		//var subGroupId=101;
		
		if (groupId && typeof groupId !== 'undefined' && groupId !== "" && subGroupId && typeof subGroupId !== 'undefined' && subGroupId !== "") {
  	
	        action = createFHashAjaxQuery("/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=" + groupId + "&subGroupId=" + subGroupId);
	    } else {
	        // Fetch all records within the last 30 days
	        action = createFHashAjaxQuery("/AHIMSG5/hislogin/fetchCircularDetailsLgnFtr?groupId=" + 0 + "&subGroupId=" + 0);
	        //
	    }
		var jsonObject = { groupId: groupId,
						   subGroupId:subGroupId 
						  };
		//console.log("inside displayCirculaurDetails jsonObject>>>"+JSON.stringify(jsonObject)) 
		var jsonData = window.btoa(JSON.stringify(jsonObject));
		
		try {
		    $.ajax({
		        url: action,
		        method: "GET",
		        dataType: "json", 
		        success: function (responses) {
		        	
		        	if (responses && responses.length) {
		        	    
		        	    const useSubGroup = responses.length === 1;
		        	    
		        	    if (useSubGroup) {
		        	        addRows(responses, groupId, subGroupId);
		        	    } else {
		        	        addRows(responses, groupId); 
		        	    }
		        	}
		        },
		            //console.log("AJAX Request Successful. CircularDetailsData:", responses);
		        	/*//alert("12");
		            if (responses.length > 1) {
		                // Create an array of file names from the responses
		                let fileNames = responses.map(function (response) {
		                    return response.fileName;
		                });
		                

		                //console.log("File Names Array:", fileNames);

		                // Process each response to get the fileName and pass it to the FTP function
		                responses.forEach(function (response) {
		                	//alert("3");
		                    const fileName = response.fileName;
		                    //console.log("Processing fileName:", fileName);

		                     addRows(responses, groupId);
		                });
		            }
			            else {
				            
		                responses.forEach(function (response) {
		                    const fileName = response.fileName; 
		                    //console.log("Processing fileName:", fileName);

		                    addRows(responses, groupId, subGroupId);
		                });
		                
		            } 
		        }*/

		        error: function (xhr, status, error) {
		            console.error("AJAX Error - Status:", status, "Error:", error, "Response:", xhr.responseText);
		            alert("An error occurred while processing your request: " + error);
		        }
		    });
		} catch (err) {
		    console.error("Exception occurred:", err.message);
		    alert("An unexpected error occurred: " + err.message);
		}
	}
		
		function handleLevel3Click(anchor) {
  const linkText = anchor.textContent.trim();
  const url = anchor.getAttribute('data-url');

  console.log("Link text:", linkText);
  console.log("URL:", url);
  displayFileDetails1(url)

  
}

	function addRows(responses,groupId,subGroupId) {
		//alert("Inside addRows: " + JSON.stringify(responses, null, 2));		
		const datalist = document.querySelector(`#datalistId${groupId}`);
		//$("#datalistId").html("");	
		$('.datalist').html("");	
	  responses.forEach(function(data) {
		//  console.log("Inside forEach CircularDetailsData:", data);

	    addRowData(responses,data,groupId,subGroupId);
	    
	  });
	}
	
	function formatDate(dateTimeStr) {
		 const datePart = dateTimeStr.split(" ")[0];

		    const dateObj = new Date(datePart);

		    const weekdays = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];

		    const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];

		    const weekday = weekdays[dateObj.getDay()];
		    const day = dateObj.getDate();
		    const month = months[dateObj.getMonth()];
		    const year = dateObj.getFullYear();

		    /*return weekday+" "+day +" "+ month+" "+year;*/
		    return +" "+day +" "+ month+" "+year;
	}

					

	function addRowData(responses,data,groupId,subGroupId) {
		console.log(groupId);
		//console.log("Inside addRow1234:", data);
		var  description = data && data.description ? data.description.trim() : "No Description Available";
		var  fromDate = data && data.fromDate ? formatDate(data.fromDate.trim()  ) : "No Date Available";
		var  fileName = data && data.fileName ? data.fileName.trim() : "No File Available";
		var  displayName = data && data.displayName ? data.displayName.trim() : "No DisplayName Available";
		var  displayHinName = data && data.displayHinName ? data.displayHinName.trim() : "&#xA;&#x915;&#x94B;&#x908;&#x20;&#x939;&#x93F;&#x902;&#x926;&#x940;&#x20;&#x928;&#x93E;&#x92E;&#x20;&#x909;&#x92A;&#x932;&#x92C;&#x94D;&#x927;&#x20;&#x928;&#x939;&#x940;&#x902;&#x20;&#x939;&#x948;";
		// function t change formate date
		//console.log("Inside fromDate>>>>>:", fromDate);
		
		if($("#lang").val() === 'en'){
			
			var showFileName = displayName;
		}else{
			var showFileName = displayHinName;
		}
		
			
			var folderName = "";
			var urlFileName = fileName.split("^")[0]; // covert this to base64

			//var urlFileNameBase64 = btoa(urlFileName);

			// Now you have the Base64 encoded version of urlFileName
			//console.log("urlFileNameBase6400  .>>  "+ urlFileNameBase64);
			
			if (fileName && fileName !== "No File Available") {
			    // Split the fileName by `_` to get its parts
			    let parts = fileName.split("_");
			    if (parts.length > 1) {
			        let secondPart = parts[1];
			
			        // Split the second part by `^` to extract showFileName and folderName
			        let splitParts = secondPart.split("^");
			        folderName = splitParts[1] || "";
			    }
			}

		var fileURL = "/CGHSGrievance/FormFlowXACTION?hmode=ftpFileDownload&fileName="+urlFileName+"&folderName="+folderName+"&isGlobal=1";
		
		//console.log("Show File Name:", showFileName);  
	const displayNames = responses.map(item => item.displayName);
	    const datalist = document.querySelector('.datalist');

	    const newListItem = document.createElement('li');
	   // console.log("newListItem  ++  "+ newListItem);
	    newListItem.classList.add('my-1', 'pt-0', 'd-flex', 'align-items-top', 'pb-1');

//	    if (responses.length > 0){
		 newListItem.innerHTML =
  "<div class='light-sm-txt datetime' " +
    "style='animation: fadeIn 0.5s ease;'>"  +
    fromDate +
  
  "</span>" +
"</button>" +
     
    
  "</div>" +

  "<div class='multiplepdflist d-flex align-items-center' style='animation: slideIn 0.5s ease;'>" +
    "<ul class='d-flex align-items-top p-0' style='list-style: none; margin: 0; padding: 0;'>" +
      "<li class='me-4'>" +
        "<a href='" + fileURL + "' target='_blank' class='d-flex align-items-center align-items-top text-decoration-none' " +
           "style='color: #333; font-size: 0.79rem; font-weight: 500; transition: color 0.3s ease; text-decoration: none;' " +
           "onmouseover=\"this.style.color='#ed1848'\" onmouseout=\"this.style.color='#333'\">" +
          showFileName +
        "</a>" +
      "</li>" +
    "</ul>" +
  "</div>" +

  "<style>" +
    "@keyframes fadeIn { from { opacity: 0; } to { opacity: 1; } }" +
    "@keyframes slideIn { from { opacity: 0; transform: translateY(10px); } to { opacity: 1; transform: translateY(0); } }" +
  "</style>";

		    if(groupId === 0){
				datalistId1.appendChild(newListItem);
				}
			if(groupId==14){
				datalistId2.appendChild(newListItem);
				}
			if(groupId==14){
				datalistId3.appendChild(newListItem);
				}
			if(groupId==14){
				datalistId4.appendChild(newListItem);
				}/*
			if(groupId==5){
				datalistId5.appendChild(newListItem);
				}*/
			 
	  }

	

	function languageChange(){
	
		localStorage.setItem('siteLanguage', $('#lang').val());
		//setFileListByArray(responses,menuObj);
		fetchCityNames();
		initLanguageLabels();
		document.getElementById("menu").innerHTML = '';
		createMenu(menuData.menu, document.getElementById("menu"));
		
		initAfterMenuJsonLoad();
		 
		
		let ctMenuTypeVal =	localStorage.getItem('ctMenuType');
		let ctMenuIdVal = localStorage.getItem('ctMenuId');
		
		  var lang = document.getElementById("lang").value;  // Get selected language
        var imageElement = document.getElementById("bannerImage");  // Get the image element

        if (lang === 'en') {
            // Change image source for English
            imageElement.src = "/AHIMSG5/hissso/portal/images/slider/cghs-english-banner.jpg";  // English Image Path
        } else if (lang === 'hi') {
            // Change image source for Hindi
            imageElement.src = "/AHIMSG5/hissso/portal/images/slider/cghs-hindi-banner.jpg";  // Hindi Image Path
        }
    	
    	if(ctMenuTypeVal == 'parray'){
    		
    		goToParentPage(ctMenuIdVal);
    		
    		
    	}else{
    		    		
    		if(ctMenuIdVal){
    			
  			  const menuDataVal = menuData.menu ? menuData.menu : menuData;
  	            
  	            const menuObjVal = findMenuById( ctMenuIdVal, menuDataVal);
  	            var contentType= menuObjVal.contentType;
  	            if(contentType=="url" && menuObj.url!=undefined  && menuObj.url!='' && menuObj.url!='#')
  	            	setMenuDetailsByMenuId(menuObjVal);  	         
  		}	
       }
 
	}
	

	function getMenuTitleByLang(menuObj){
				
		if($("#lang").val() === 'en'){
			
			return menuObj.title;
			
		}else{
			
			return menuObj.titleHindi ? menuObj.titleHindi :  menuObj.title;
			
		}
		
	}
	
	

	function getMenuContentByLang(menuObj){
		
		var content = '';
				
		if($("#lang").val() === 'en'){
			
			content = menuObj.encodedContent;
			
		}else{
			
			content =  menuObj.encodedContentHindi ? menuObj.encodedContentHindi :  menuObj.encodedContent;
			
		}
		
		
		return decodeURIComponent(escape(atob(content)))
		
	}
	
	
	
function getMenuTitleByLangWithTitles(title , hindiTitle){
		
		var content = '';
				
		if($("#lang").val() === 'en'){
			
			content = title;
			
		}else{
			
			content = hindiTitle ? hindiTitle : title;
			
		}
		
		
		return content;
		
	}
	
function createMenu(menuItems, parentElement, isSubmenu = false) {
    console.log("inside >>createMenu ");
    
    menuItems.forEach(item => {
        let li = document.createElement("li");
         if (!isSubmenu) {
            li.classList.add("nav-item");
        }

        let a = document.createElement("a");
        a.classList.add("nav-link");
      if (item.submenu && item.submenu.length > 0) {
            a.classList.add("dropdown-toggle");
        }
        a.setAttribute('id', "navbarDropdown");
        a.setAttribute('role', "button");
        a.setAttribute('data-submenu-id', item.menuId);
        a.setAttribute('data-submenu-type', item.contentType);
        a.href = item.url;
        a.textContent = getMenuTitleByLang(item);
         li.appendChild(a);
        
        if (item.submenu && item.submenu.length > 0) {
            let ul = document.createElement("ul");
             ul.classList.add("dropdown-menu");
             ul.setAttribute('aria-labelledby', "navbarDropdown");
            li.classList.add("dropdown"); // Add a different class if there’s a submenu
            createMenu(item.submenu, ul);
             ul.querySelectorAll("a").forEach(submenuAnchor => {
                submenuAnchor.classList.add("dropdown-item");
                // ✅ Collapse navbar on submenu click
                submenuAnchor.addEventListener('click', () => {
                    const navbarCollapse = document.querySelector('.navbar-collapse');
                    if (navbarCollapse && navbarCollapse.classList.contains('show')) {
                        const collapse = bootstrap.Collapse.getOrCreateInstance(navbarCollapse);
                        collapse.hide();
                    }
                });
            });

            li.appendChild(ul);
        }
        
        parentElement.appendChild(li);
    });
}




$(document).ready(function () {
    // Fetch city names when the page loads
    fetchCityNames();

    // Event handler for when a city is selected
    $('#citySelect').on('change', function () {
        var selectedCityId = $(this).val(); // Get the selected city's ID
        if (selectedCityId) {
        	localStorage.setItem('selectedCityId', selectedCityId );
            //fetchHospitalsByCity(selectedCityId); // Fetch hospitals for the selected city
        } else {
            $('#hospitalTable').hide(); // Hide the hospital table if no city is selected
        }
    });

    // Function to fetch and display city names in the dropdown

});

function fetchCityNames() {
    var url = createFHashAjaxQuery("/AHIMSG5/hislogin/getCityNamesLgnFtr?");
    $.ajax({
        url: url,
        method: "GET",
        success: function (data) {
            // Ensure you are accessing the correct part of the response
            if (data.cityNamesDtl) {
            	
                //console.log("Cities:", data.cityNamesDtl);
            	 var citySelect = $('#citySelect');
                 citySelect.empty(); 
            	if ($("#lang").val() === 'en') {
            		citySelect.append('<option data-lang-key="citySelect" value="">--Select--</option>');    
                } else {
                	citySelect.append('<option data-lang-key="citySelect" value="">--&#x91A;&#x92F;&#x928;&#x20;&#x915;&#x930;&#x947;&#x902;--</option>'); 
                }

                data.cityNamesDtl.forEach(function(city) {
                    var cityNameToShow;
                    if ($("#lang").val() === 'en') {
                        cityNameToShow = city.cityName;     // English name
                    } else {
                        cityNameToShow = city.cityHinName;  // Hindi name or other language
                    }
                    //console.log("Current language is en: " + ($("#lang").val() === 'en'));

                    var option = $('<option></option>')
                        .val(city.cityId)       // Set cityId as the value
                        .text(cityNameToShow);  // Use the selected city name

                    citySelect.append(option);
                });
            } else {
                console.error("No city names found in the response.");
            }
        },
        error: function (xhr, status, error) {
            console.error("Error fetching cities:", error);
            console.log("XHR Status:", xhr.status); 
            console.log("XHR Status Text:", xhr.statusText);
            console.log("Response Text:", xhr.responseText); 
        }
    });
}

$(document).ready(function () {
    $('#searchInput').hide();

    $('#submitBtn').on('click', function () {
    	window.location = "/AHIMSG5/hissso/empanelledLogin";
    });

    $('#searchInput').on('keyup', function () {
      var value = $(this).val().toLowerCase();
      $('#hospitalTable tbody tr').filter(function () {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);

        var visibleRows = $('#hospitalTable tbody tr:visible').length;
        $('#totalRecords').text(visibleRows);
      });
    });
  });