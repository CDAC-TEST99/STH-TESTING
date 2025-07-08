let editMode = false;
let currentKey = "";


$(document).ready(function(){
	initData()
	// Load table data on initial page load
	loadTableData();
});

function initData(){
	$( "button" ).click(function( event ) {
		event.preventDefault();
	});
	if(localStorage.getItem("formData")==undefined){
	 $.ajax({
	        url: '/AHIMSG5/hissso/portal/json/label.json', // Path to your JSON file
	        type: 'GET',
	        dataType: 'json',
	        success: function(data) {
	        	formData=data;
	        	localStorage.setItem('formData', JSON.stringify(formData));
	        	loadTableData();
	        }
		});
	}
	else{
		loadTableData();
	}
	
	
	$("#addToLocalStorage").click(function() {
	    const key = $("#key").val();
	    const en_value = $("#en_value").val();
	    const hi_value = $("#hi_value").val();

	    if (!key || !en_value || !hi_value) {
	        alert("Please fill all fields.");
	        return;
	    }

	    let formData = JSON.parse(localStorage.getItem("formData")) || {};
	    formData[key] = { en: en_value, hi: hi_value };
	    localStorage.setItem("formData", JSON.stringify(formData));
	    alert("Data added to local storage.");
	    loadTableData();

	    if (editMode) {
	        $("#addToLocalStorage").text("Add");
	        $("#key").prop("disabled", false);
	        editMode = false;
	    }

	    $("#key").val("");
	    $("#en_value").val("");
	    $("#hi_value").val("");
	    $("#searchInput").val("");
	});

	$("#downloadJson").click(function() {
	    const formData = localStorage.getItem("formData");
	    if (formData) {
	        const blob = new Blob([formData], { type: "application/json" });
	        const url = URL.createObjectURL(blob);
	        const a = document.createElement("a");
	        a.href = url;
	        a.download = "label.json";
	        document.body.appendChild(a);
	        a.click();
	        document.body.removeChild(a);
	    } else {
	        alert("No data found in local storage.");
	    }
	});

	$("#resetForm").click(function() {
	    $("#key").prop("disabled", false);
	    $("#key").val("");
	    $("#en_value").val("");
	    $("#hi_value").val("");
	    $("#searchInput").val("");
	    
	    editMode = false;
	    currentKey = "";
	    $("#addToLocalStorage").text("Add");
	});


	
}
function loadTableData() {
    const formData = JSON.parse(localStorage.getItem("formData")) || {};
    const tableBody = $("#dataTable tbody");
    tableBody.empty(); // Clear existing table data
    
    $.each(formData, function(key, value) {
        const row = `<tr>
            <td>${key}</td>
            <td>${value.en}</td>
            <td>${value.hi}</td>
            <td>
                <button class="btn btn-sm" onclick="editData('${key}')">
                    <i class="fas fa-edit"></i>
                </button>
                <button class="btn btn-sm" onclick="deleteData('${key}')">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
        </tr>`;
        tableBody.append(row);
    });
    
    

  //Search functionality
  $("#searchInput").on("keyup", function() {
      const value = $(this).val().toLowerCase();
       
      $("#dataTable tbody tr").filter(function() {
          // Skip the search of the last 2 td elements
          const cellsText = $(this).find("td").slice(0, -2).text().toLowerCase();
          $(this).toggle(cellsText.indexOf(value) > -1);
      });

      // Highlight search content
      $("#dataTable tbody tr").each(function() {
          const row = $(this);
          row.find("td").slice(0, -2).each(function() {
              const cell = $(this);
              const regex = new RegExp(`(${value})`, "gi");
              cell.html(cell.text().replace(regex, "<span class='highlight'>$1</span>"));
          });
      });
  });
  $( "button" ).click(function( event ) {
		event.preventDefault();
	});
    
}

function editData(key) {
    const formData = JSON.parse(localStorage.getItem("formData")) || {};
    if (formData[key]) {
        $("#key").val(key).prop("disabled", true);
        $("#en_value").val(formData[key].en);
        $("#hi_value").val(formData[key].hi);
        $("#addToLocalStorage").text("Edit");
        editMode = true;
        currentKey = key;
    }
}

function deleteData(key) {
    let formData = JSON.parse(localStorage.getItem("formData")) || {};
    delete formData[key];
    localStorage.setItem("formData", JSON.stringify(formData));

    $("#key").prop("disabled", false);
    $("#key").val("");
    $("#en_value").val("");
    $("#hi_value").val("");
    $("#searchInput").val("");
    loadTableData();
}





function openTab(tabId){
	
	$('#masterKey').val("portalMenuMst")
	$('#hmode').val("CallMasterPage");
	document.forms[0].submit();	
	
} 
