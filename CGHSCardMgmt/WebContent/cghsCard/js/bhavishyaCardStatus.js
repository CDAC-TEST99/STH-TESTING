$(document).ready(
		function() {
			let statusCode = $('#statusCode').val();
			let approvedDiv = document
					.getElementById("bhavishyaCghsCardStatusApprovedDiv");
			let pendingDiv = document
					.getElementById("bhavishyaCghsCardStatusPendingDiv");
			console.log("Application Status Code = " + statusCode);
			if (statusCode == "6" || statusCode == "4") {
				approvedDiv.style.display = "block";
				pendingDiv.style.display = "none";
			} else {
				approvedDiv.style.display = "none";
				pendingDiv.style.display = "block";
			}
			hidePreloader();
		});
