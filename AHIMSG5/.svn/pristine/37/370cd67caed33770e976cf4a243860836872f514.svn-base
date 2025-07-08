$(document).ready(function () {
	
	if ( localStorage.getItem("selectedCityId")!= null && localStorage.getItem("selectedCityId")!= ""  ){
		fetchHospitalsByCity(localStorage.getItem("selectedCityId"));
	      $('#tableContainer').show();
	      $('#searchInput').show();
	      $('#rowCount').show();
	  }
	
	
	if ( localStorage.getItem("selectedWcCityId")!= null && localStorage.getItem("selectedWcCityId")!= ""  ){
		alert(1);
		fetchWellnessCenterByCity(localStorage.getItem("selectedWcCityId"));
	      $('#tableContainer').show();
	      $('#searchInput').show();
	      $('#rowCount').show();
	  }
    fetchCityNames();

    $('#citySelect').on('change', function () {
        var selectedCityId = $(this).val();
        if (selectedCityId) {
        	$('#tableContainer').hide();
        	$('#hospitalTable').DataTable().destroy();
            fetchHospitalsByCity(selectedCityId);
        } else {
            $('#hospitalTable').hide();
        }
    });
    $('#cityWcSelect').on('change', function () {
        var selectedWcCityId = $(this).val(); 
        if (selectedWcCityId) {
        	$('#tableContainer').hide();
        	$('#hospitalTable').DataTable().destroy();
            fetchWellnessCenterByCity(selectedWcCityId); 
        } else {
            $('#hospitalTable').hide();
        }
    });

    // Function to fetch and display city names in the dropdown
    function fetchCityNames() {
        var url = createFHashAjaxQuery("/AHIMSG5/hislogin/getCityNamesLgnFtr?");
        $.ajax({
            url: url,
            method: "GET",
            success: function (data) {
            	
            	populateWcCityNames(data);
                // Ensure you are accessing the correct part of the response
                if (data.cityNamesDtl) {
                    //console.log("Cities:", data.cityNamesDtl);
                    var citySelect = $('#citySelect');
                    citySelect.empty(); // Clear existing options
                    citySelect.append('<option value="">--Select--</option>'); // Default select option
                    
                    // Populate the dropdown with city names
                    data.cityNamesDtl.forEach(function(city) {
                    	//alert(2);
                        var option = $('<option></option>')
                            .val(city.cityId) // Set cityId as the value
                            .text(city.cityName); // Set cityName as the display text
                        //citySelect.append(option);
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

    function populateWcCityNames(cityData) {

                if (cityData.cityNamesDtl) {
                    console.log("cityWcSelect:", cityData.cityNamesDtl);
                    var cityWcSelect = $('#cityWcSelect');
                    
                    // Clear Wellness Center
                    cityWcSelect.empty(); 
                    cityWcSelect.append('<option value="">--Select--</option>');

                    cityData.cityNamesDtl.forEach(function(city) {
                    	//alert(2);
                        var option = $('<option></option>')
                            .val(city.cityId) // Set cityId as the value
                            .text(city.cityName); // Set cityName as the display text
                        cityWcSelect.append(option);
                    });
                } else {
                    console.error("No city names found in the response.");
                }

    }
    
    // Function to fetch hospitals based on the selected city
    function fetchHospitalsByCity(cityId) {
    	///alert(3);
        $.ajax({
            url: createFHashAjaxQuery("/AHIMSG5/hislogin/getHospitalsByCityLgnFtr?cityId=" + cityId),
            method: "GET",
            dataType: "json",
            success: function (data) {
            		//alert(2);
                if (Array.isArray(data.hospitalNamesDtl) && data.hospitalNamesDtl.length > 0) {
                	
                    populateHospitalTable(data);
                } else {
                    populateHospitalTable([]);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error fetching hospitals:", error);
            }
        });
    }
    

    function fetchWellnessCenterByCity(cityId) {
    	//alert(3);
        $.ajax({
            url: createFHashAjaxQuery("/AHIMSG5/hislogin/fetchWellnessCenterByCityLgnFtr?cityId=" + cityId),
            method: "GET",
            dataType: "json",
            success: function (data) {
            		//alert(2);
                if (Array.isArray(data.hospitalNamesDtl) && data.hospitalNamesDtl.length > 0) {
                	
                    populateWCHospitalTable(data);
                } else {
                	populateWCHospitalTable([]);
                }
            },
            error: function (xhr, status, error) {
                console.error("Error fetching hospitals:", error);
            }
        });
    }


});
function populateHospitalTable(hospitalData) {
    var table = document.getElementById('hospitalTable');
    var tbody = table.querySelector('tbody');
    tbody.innerHTML = ''; // Clear existing rows
    //alert(1);
    // Check if data exists and is in expected format
    if (!hospitalData || !hospitalData.hospitalNamesDtl) {
        let noDataRow = document.createElement('tr');
        noDataRow.classList.add('table-warning');
        noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No hospital data available</td>";
        tbody.appendChild(noDataRow);
        table.style.display = 'table';
        return;
    }
    
    if (Array.isArray(hospitalData.hospitalNamesDtl) && hospitalData.hospitalNamesDtl.length > 0) {
    	//alert(2);
        for (var i = 0; i < hospitalData.hospitalNamesDtl.length; i++) {
        	//alert(3);
            var item = hospitalData.hospitalNamesDtl[i];
            
            if (!item || !item.hospName) {
                console.warn("Invalid hospital item at index", i, item);
                continue; // Skip this item
            }
            
            let row = document.createElement('tr');
            row.classList.add('table-primary');
            row.innerHTML = 
                "<td>" + (item.hospName || 'N/A') + "</td>" +
                "<td>" + (item.hospAcc || 'N/A') + "</td>" +
                "<td>" + (item.hospAdd || 'N/A') + "</td>" +
                "<td>" + (item.facEmpled || 'N/A') + "</td>";
            
            tbody.appendChild(row);
        }
        
        if (tbody.children.length === 0) {
        	console.log(noDataRow);
            let noDataRow = document.createElement('tr');
            noDataRow.classList.add('table-warning');
            noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No valid hospital records found</td>";
            tbody.appendChild(noDataRow);
        }
    } else {
        let noDataRow = document.createElement('tr');
        noDataRow.classList.add('table-warning');
        noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No hospitals found</td>";
        tbody.appendChild(noDataRow);
    }
    
  var selectedCityName = $('#citySelect option:selected').text().trim();
var exportTitle = selectedCityName + " Empanelled Hospitals";

// Destroy any existing DataTable
$('#hospitalTable').DataTable().destroy();

$('#hospitalTable').DataTable({
    dom: 'Bfrtip',
    buttons: [
        {
            extend: 'copy',
            title: exportTitle
        },
        {
            extend: 'csv',
            title: exportTitle,
            filename: exportTitle.replace(/\s+/g, '_') // filename-safe
        },
        {
            extend: 'excel',
            title: exportTitle,
            filename: exportTitle.replace(/\s+/g, '_')
        },
        {
            extend: 'pdf',
            title: exportTitle,
            filename: exportTitle.replace(/\s+/g, '_'),
            orientation: 'landscape',
            pageSize: 'A4'
        },
        {
            extend: 'print',
            title: '<h2 style="text-align:center;">' + exportTitle + '</h2>'
        }
    ],
    pageLength: 10,
    searching: true,
    language: {
        search: "",
        searchPlaceholder: "Search Hospitals..." // Custom placeholder text
    }
});

// Show row count
 var totalRows = table.rows({ search: 'applied' }).count();
            $('#totalRecords').text(totalRows);
            $('#rowCount').show();
}



function populateWCHospitalTable(hospitalData) {
    var table = document.getElementById('hospitalTable');
    var tbody = table.querySelector('tbody');
    tbody.innerHTML = ''; // Clear existing rows
    
    // Check if data exists and is in expected format
    if (!hospitalData || !hospitalData.hospitalNamesDtl) {
        let noDataRow = document.createElement('tr');
        noDataRow.classList.add('table-warning');
        noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No hospital data available</td>";
        tbody.appendChild(noDataRow);
        table.style.display = 'table';
        return;
    }
    
    if (Array.isArray(hospitalData.hospitalNamesDtl) && hospitalData.hospitalNamesDtl.length > 0) {
        for (var i = 0; i < hospitalData.hospitalNamesDtl.length; i++) {
            var item = hospitalData.hospitalNamesDtl[i];
            
            if (!item || !item.hospNameCodeType) {
                console.warn("Invalid hospital item at index", i, item);
                continue; // Skip this item
            }
            
            let row = document.createElement('tr');
            row.classList.add('table-primary');
            row.innerHTML = 
                "<td>" + (item.hospNameCodeType || 'N/A') + "</td>" +
                "<td>" + (item.shortname || 'N/A') + "</td>" +
                "<td>" + (item.address || 'N/A') + "</td>" +
                "<td>" + (item.phone || 'N/A') + "</td>" +
                "<td>" + (item.email || 'N/A') + "</td>";
            
            tbody.appendChild(row);
            var selectedCityName = $('#cityWcSelect option:selected').text().trim();
            var exportTitle = selectedCityName + " Wellness Centers";
            $('#tableHeader').val(exportTitle);
        }
        
        if (tbody.children.length === 0) {
            console.log(noDataRow);
            let noDataRow = document.createElement('tr');
            noDataRow.classList.add('table-warning');
            noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No valid hospital records found</td>";
            tbody.appendChild(noDataRow);
        }
    } else {
        let noDataRow = document.createElement('tr');
        noDataRow.classList.add('table-warning');
        noDataRow.innerHTML = "<td colspan='4' style='text-align:center;'>No hospitals found</td>";
        tbody.appendChild(noDataRow);
    }
    

    // Destroy any existing DataTable
    if ($.fn.DataTable.isDataTable('#hospitalTable')) {
        $('#hospitalTable').DataTable().destroy();
    }

    // Initialize DataTable
    var dataTable = $('#hospitalTable').DataTable({
        dom: 'Bfrtip',
        buttons: [
            {
                extend: 'copy',
                title: exportTitle
            },
            {
                extend: 'csv',
                title: exportTitle,
                filename: exportTitle.replace(/\s+/g, '_') // filename-safe
            },
            {
                extend: 'excel',
                title: exportTitle,
                filename: exportTitle.replace(/\s+/g, '_')
            },
            {
                extend: 'pdf',
                title: exportTitle,
                filename: exportTitle.replace(/\s+/g, '_'),
                orientation: 'landscape',
                pageSize: 'A4'
            },
            {
                extend: 'print',
                title: '<h2 style="text-align:center;">' + exportTitle + '</h2>',
  
            },
            {
                text: 'Print Table',  // Custom print button text
                action: function ( e, dt, node, config ) {
                    var printWindow = window.open('', '_blank', 'width=800,height=600'); // Open a new window
                    var printTitle = '<h2 style="text-align:center;">' + exportTitle + '</h2>'; // Title to print
                    var tableHTML = $('#hospitalTable').clone().prop('outerHTML'); // Get table HTML

                    // Add styles to the print window
                    printWindow.document.write('<html><head><title>Print Table</title>');
                    printWindow.document.write('<style>table { width: 100%; border-collapse: collapse; }');
                    printWindow.document.write('th, td { padding: 8px; text-align: left; border: 1px solid #ddd; }');
                    printWindow.document.write('</style></head><body>');
                    printWindow.document.write(printTitle); // Add title
                    printWindow.document.write(tableHTML); // Add table
                    printWindow.document.write('</body></html>');

                    // Trigger print dialog once content is loaded
                    printWindow.document.close();
                    printWindow.focus();
                    printWindow.print();
                }
            }
        ],
        pageLength: 10,
        searching: true,
        language: {
            search: "",
            searchPlaceholder: "Search Hospitals..." 
        }
    });

    // Show row count
    var totalRows = dataTable.rows({ search: 'applied' }).count();
    $('#totalRecords').text(totalRows);
    $('#rowCount').show();
}