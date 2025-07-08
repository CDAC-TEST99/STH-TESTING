var departmentJSONArray = [];
$(document)
		.ready(
				function() {
					
					
					
					reset();

					//  $("#patDOB").datepicker({format: 'dd-M-yyyy',autoclose: true,todayHighlight: true,maxDate:'0',endDate:'0'});
					// $("#imgDobCal").datepicker({format: 'dd-M-yyyy',autoclose: true,todayHighlight: true,maxDate:'0',endDate:'0'});

					var hospitalCodeValue = $("#hospitalID").val();
					if (hospitalCodeValue != "-1") {
						pinCode = hospitalCodeValue.split("#")[4];
						document.getElementById('patAddPIN').value = pinCode;
						var hospitalCode = hospitalCodeValue.split("#")[0];

						var patGenderCode = $("#patGenderCode").val();

						var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
						var data = "mode=GETDEPTLISTNEW&hospitalCode="
								+ hospitalCode;
						$.ajax({
							url : action,
							type : 'POST',
							data : data,
							success : function(result) {
								$("#visitingDeptID").html(result);

							}
						});
					}

					$("#patAddStateCode").change();

					$("input:radio[name=agedob]").change(function() {
						var agedob = $(this).val();
						if (agedob == 'Age') {
							$("#divPatDOB").hide();
							$("#divAge").show();
						} else if (agedob == 'dob') {
							$("#divPatDOB").show();
							$("#divAge").hide();
						}
					});

					$('[name="patMaritalStatusCode"]').change(
							function() {

								var maritalStatus = $(
										'[name="patMaritalStatusCode"]').val();
								if (maritalStatus == "2") { // single     		
									$('[name="patHusbandName"]').attr(
											'disabled', 'disabled');
									$('[name="patHusbandOccupation"]').attr(
											'disabled', 'disabled');
								} else {
									$('[name="patHusbandName"]').removeAttr(
											'disabled');
									$('[name="patHusbandOccupation"]')
											.removeAttr('disabled');
								}
							});

					$("#patAddCountryCode")
							.change(
									function() {
										var countryCode = $(
												"#patAddCountryCode").val();
										var hashCode = $("#hospitalID").val();
										if (countryCode != "-1") {
											if (countryCode == "101") {
												var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
												var data = "mode=GETSTATELIST&countryCode="
														+ countryCode;
												$.ajax({
													url : action,
													type : 'POST',
													data : data,
													success : function(result) {
														$("#patAddStateCode")
																.html(result);
													}
												});
												
													document.getElementById("patAddStateText").style.display="none";
													document.getElementById("patAddDistrictText").style.display="none";
													document.getElementById("patAddStateCode").style.display="";
													document.getElementById("patAddDistrictCode").style.display="";
													//document.getElementById("patAddStateCode").value="37";
													//$("#patAddStateCode").val("37");
												
												/*document
														.getElementById("stateMandotary").style.display = "";
												document
														.getElementById("stateNotMandotary").style.display = "none";
												document
														.getElementById("divpatAddStateCodeCombo").style.display = "";
												document
														.getElementById("divpatAddStateCodeText").style.display = "none";
												document
														.getElementById("districtCombo").style.display = "";
												document
														.getElementById("districtTextBox").style.display = "none";*/
											} else {
												document.getElementById("patAddStateText").style.display="";
												document.getElementById("patAddDistrictText").style.display="";
												document.getElementById("patAddStateCode").style.display="none";
												document.getElementById("patAddDistrictCode").style.display="none";
												/*document
														.getElementById("stateMandotary").style.display = "none";
												document
														.getElementById("stateNotMandotary").style.display = "";
												document
														.getElementById("divpatAddStateCodeCombo").style.display = "none";
												document
														.getElementById("divpatAddStateCodeText").style.display = "";
												document
														.getElementById("districtCombo").style.display = "none";
												document
														.getElementById("districtTextBox").style.display = "";*/
											}
										} else {
											$("#patAddStateCode")
													.html(
															"<option value='-1'>Select Value</option>");
										}
									});
					$("#patAddStateCode")
							.change(
									function() {
										var stateCode = $("#patAddStateCode")
												.val();
										if (stateCode != "-1") {
											var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
											var data = "mode=GETDISTRICTLIST&stateCode="
													+ stateCode;
											$.ajax({
												url : action,
												tpye : 'POST',
												data : data,
												success : function(result) {
													$("#patAddDistrictCode")
															.html(result);
												}
											});
										} else {
											$("#patAddDistrictCode")
													.html(
															"<option value='-1'>Select Value</option>");
										}
										hashCode = $("#hospitalID").val();
										setTimeout(function() {
											if (stateCode == hashCode
													.split('#')[2]) {
												document
														.getElementById('patAddDistrictCode').value = hashCode
														.split('#')[3];
											}
										});
									});

					//$("#patAge")
						//	.blur(
																		//});
					
					
				});

function agePedia() {
	var deptCode = document.forms[0].visitingDeptID.value;
	if (deptCode.split("#")[0] == '111'
			&& ($('[name="patAge"]')[0].value > 14
			|| $('[name="patAge"]')[0].value < 1)
			&& $('[name="patAgeUnit"]')[0].value == "YR") {
		alert("Valid Age Range for Pediatric Department is 1-14 yrs.");
		$("#patAge").val('');
		return false;
	} else if (deptCode.split("#")[0] == '111'
			&& ($('[name="patAge"]')[0].value > 168
			|| $('[name="patAge"]')[0].value < 1)
			&& $('[name="patAgeUnit"]')[0].value == "MTH") {
		alert("Valid Age Range for Pediatric Department is 1-168 months.");
		$("#patAge").val('');
		return false;
	} else if (deptCode.split("#")[0] == '111'
			&& ($('[name="patAge"]')[0].value > 728
			|| $('[name="patAge"]')[0].value < 1)
			&& $('[name="patAgeUnit"]')[0].value == "WK") {
		alert("Valid Age Range for Pediatric Department is 1-728 weeks.");
		$("#patAge").val('');
		return false;
	} else if (deptCode.split("#")[0] == '111'
			&& ($('[name="patAge"]')[0].value > 5112
			|| $('[name="patAge"]')[0].value < 1)
			&& $('[name="patAgeUnit"]')[0].value == "D") {
		alert("Valid Age Range for Pediatric Department is 1-5112 days.");
		$("#patAge").val('');
		return false;
	}
}


function ageValidation() {
	var age = document.getElementById("patAge").value;
	var ageUnit = document.getElementById("patAgeUnit").value;
	if (age < 18 && ageUnit == "YR")
		$("#patHusbandName").prop("disabled", true);
	else if (age < 216 && ageUnit == "MTH")
		$("#patHusbandName").prop("disabled", true);
	else if (age < 936 && ageUnit == "WK")
		$("#patHusbandName").prop("disabled", true);
	else if (age < 6574 && ageUnit == "D")
		$("#patHusbandName").prop("disabled", true);
	else
		$("#patHusbandName").prop("disabled", false);

}

function ageValidationDob() {
	var dob = document.getElementById("patDOB").value;
	var now = new Date();
	console.log(document.getElementById("patDOB").value + "\n" + now + "\n"
			+ (Number(now.getFullYear()) - Number(dob.split("/")[2])));

	//if (document.getElementById("patDOB").onchange) {
	if (Number(now.getFullYear()) - (Number(dob.split("/")[2])) < Number(18)) {// If age is less than 18 yrs than disable spouse name field.}+ 125 < now.getFullYear() ) {
		$("#patHusbandName").val('');
		$("#patHusbandName").prop("disabled", true);
	} else
		$("#patHusbandName").prop("disabled", false);
	// }
	/*  alert("Age can't be more than 125 yrs.");
	$("#patDOB").val('Select Date');
	$("#patDOB").focus();
	  return false;
	}*/

}

//<for Registration Fee>
function tariffCost() {

	$("#costTr").show();
	if (idReq == "0")
	// if(idReq=="-1") 
	{
		document.getElementById("patId").style.display = "none";
		document.getElementById("patIdTd").style.display = "none";
		document.getElementById("patIdNo").style.display = "none";
	} else {
		$("#patId").show();
		$("#patIdTd").show();
		$("#patIdNo").show();
	}
	document.getElementById("Cost").disabled = true;
}

function getDateCheckBox() {
	//  $('#datePick').multiDatesPicker();

	$('#multiDatePicker').multiDatesPicker({
		container : '#myModalId'
	});
	$('#ui-datepicker-div').css({
		"background" : "lightblue",
		"border" : "1px solid"
	}).hide();

	if ($("#chkBox").is(':checked')) {
		$("#multiDate").show();
		$("#multiDate_1").show();
		document.getElementById("toChangeDateId").disabled = true;
		document.getElementById("visitingDeptID").disabled = true;
		document.getElementById("visitDate").disabled = true;
		document.getElementById("visitDate").value = "";
	} else {
		$("#multiDate").hide();
		$("#multiDate_1").hide();
		document.getElementById("toChangeDateId").disabled = false;
		document.getElementById("visitingDeptID").disabled = false;
		document.getElementById("visitDate").disabled = false;
	}
}

function onchange_patDetailOnId()

{
	var result = "";
	var strDtl = "";
	var genderData = "";
	var Relationship = "";
	var insuranceNo = document.getElementById("patIdNo").value;
	var staffNo = document.getElementById("patIdNo").value;
	var studentNo = document.getElementById("patIdNo").value;
	//var c = document.getElementsByName("patPrimaryCatCode")[0].value;		
	// 	var res = c.split("#"); 
	//     var categoryCode = res[0];

	if (categoryCode == 13) {
		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		var data = "mode=GETSTAFFPATLIST&patIdNo=" + staffNo;
		$
				.ajax({
					url : action,
					type : 'POST',
					data : data,
					dataType : "json",
					success : function(data) {
						arrRecordGlobalJsonObject = data;
						document.getElementById("patIdNo").disabled = true;
						$("#InsuredHeader").show();
						$("#detailsTr").show();

						if (arrRecordGlobalJsonObject != "") {
							strDtl = "<div id='staffTable'><table width='100%' border='1' id='mainTableRptId'  class=''  align='center'  cellspacing='0px'   cellpadding='1px'>"
									+ "<tr>"
									+ "<th  colspan='1' width='5%'>select</th>"
									+ "<th  colspan='1' width='15%'>First Name</th>"
									+ "<th  colspan='1' width='15%'>Last Name</th>"
									+ "<th  colspan='1' width='15%'>Employee Id</th>"
									+ "<th  colspan='1' width='15%'>Gender</th>"
									+ "<th  colspan='1' width='15%'>Age</th>"
									+ "<th  colspan='1' width='20%'>Relationship</th>"
									+ "</tr>";

							for (i = 0; i < arrRecordGlobalJsonObject.length; i++) {
								var p = arrRecordGlobalJsonObject[i].Relationship;
								if (p == "")
									arrRecordGlobalJsonObject[i].Relationship = "Self";
								strDtl += "<tr>"
										+ "<td width='5%'  align='center'><input type='radio' name='checkid' 		id='checkid"
										+ i
										+ "' 	value='0' onClick='chkBoxClick1(this,\""
										+ i
										+ "\");'></td>"
										+ "<td width='15%' align='center'><input type='hidden' name='FirstName' 		id='FirstName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObject[i].FirstName
										+ "' >"
										+ arrRecordGlobalJsonObject[i].FirstName
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='LastName' 		id='LastName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObject[i].LastName
										+ "' >"
										+ arrRecordGlobalJsonObject[i].LastName
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='EmployeeNumber'	id='EmployeeNumber"
										+ i
										+ "' value='"
										+ arrRecordGlobalJsonObject[i].EmployeeNumber
										+ "' >"
										+ arrRecordGlobalJsonObject[i].EmployeeNumber
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='Gender' 		id='Gender"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObject[i].Gender
										+ "' >"
										+ arrRecordGlobalJsonObject[i].Gender
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='Age' 			id='Age"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObject[i].Age
										+ "' >"
										+ arrRecordGlobalJsonObject[i].Age
										+ "</td>"
										+ "<td width='20%' align='center'><input type='hidden' name='Relationship'	id='Relationship"
										+ i
										+ "' value='"
										+ arrRecordGlobalJsonObject[i].Relationship
										+ "' >"
										+ arrRecordGlobalJsonObject[i].Relationship
										+ "</td>" + "</tr>";
							}

							strDtl += "</table></div>";
							$("#InsuredPatId").show();
							document.getElementById("myModal").innerHTML = strDtl;
							document.getElementById("headerId").style.display = "block";
							result = "<div id='result'><input type='hidden' name='hiddenResult' value='111'/></div>";
						} else {
							alert("No data found ..!!");
							document.getElementById("patIdNo").disabled = false;
							$("#InsuredHeader").hide();
							$("#detailsTr").hide();
						}
					},
					error : function(errorMsg, textstatus, errorthrown) {
						alert('onchange_patDetailOnId ' + errorMsg
								+ " textstatus::" + textstatus
								+ " errorthrown::" + errorthrown);
					}
				});
	}

	else if (categoryCode == 14) {
		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		var data = "mode=GETSTUDENTPATLIST&patIdNo=" + studentNo;
		$
				.ajax({
					url : action,
					type : 'POST',
					data : data,
					dataType : "json",
					success : function(data) {
						arrRecordGlobalJsonObjectStudent = data;
						document.getElementById("patIdNo").disabled = true;
						$("#InsuredHeader").show();
						$("#detailsTr").show();

						if (arrRecordGlobalJsonObjectStudent != "") {
							strDtl = "<div id='staffTable'><table width='100%' border='1' id='mainTableRptId'  class=''  align='center'  cellspacing='0px'   cellpadding='1px'>"
									+ "<tr>"
									+ "<th  colspan='1' width='5%'>select</th>"
									+ "<th  colspan='1' width='20%'>Student Name</th>"
									+ "<th  colspan='1' width='20%'>Last Name</th>"
									+ "<th  colspan='1' width='20%'>Student Id</th>"
									+ "<th  colspan='1' width='20%'>Gender</th>"
									+ "<th  colspan='1' width='15%'>Age</th>"
									+ "</tr>";

							for (i = 0; i < arrRecordGlobalJsonObjectStudent.length; i++) {
								strDtl += "<tr>"
										+ "<td width='5%'  align='center'><input type='radio' name='checkid' 		id='checkid"
										+ i
										+ "' 	value='0' onClick='chkBoxClick2(this,\""
										+ i
										+ "\");'></td>"
										+ "<td width='20%' align='center'><input type='hidden' name='FirstName' 		id='FirstName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObjectStudent[i].FirstName
										+ "' >"
										+ arrRecordGlobalJsonObjectStudent[i].FirstName
										+ "</td>"
										+ "<td width='20%' align='center'><input type='hidden' name='LastName' 		id='LastName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObjectStudent[i].LastName
										+ "' >"
										+ arrRecordGlobalJsonObjectStudent[i].LastName
										+ "</td>"
										+ "<td width='20%' align='center'><input type='hidden' name='StudentId'		id='StudentId"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObjectStudent[i].StudentId
										+ "' >"
										+ arrRecordGlobalJsonObjectStudent[i].StudentId
										+ "</td>"
										+ "<td width='20%' align='center'><input type='hidden' name='Gender' 		id='Gender"
										+ i
										+ "' 		value='"
										+ arrRecordGlobalJsonObjectStudent[i].Gender
										+ "' >"
										+ arrRecordGlobalJsonObjectStudent[i].Gender
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='Age' 			id='Age"
										+ i
										+ "' 		value='"
										+ arrRecordGlobalJsonObjectStudent[i].Age
										+ "' >"
										+ arrRecordGlobalJsonObjectStudent[i].Age
										+ "</td>" + "</tr>";
							}

							strDtl += "</table></div>";
							$("#InsuredPatId").show();
							document.getElementById("myModal").innerHTML = strDtl;
							document.getElementById("headerId").style.display = "block";
							result = "<div id='result'><input type='hidden' name='hiddenResult' value='111'/></div>";
						} else {
							alert("No data found ..!!");
							document.getElementById("patIdNo").disabled = false;
							$("#InsuredHeader").hide();
							$("#detailsTr").hide();
						}
					},
					error : function(errorMsg, textstatus, errorthrown) {
						alert('onchange_patDetailOnId ' + errorMsg
								+ " textstatus::" + textstatus
								+ " errorthrown::" + errorthrown);
					}
				});
	}

	else {
		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		var data = "mode=GETINSUREDPATLIST&patIdNo=" + insuranceNo;
		$
				.ajax({
					url : action,
					type : 'POST',
					data : data,
					dataType : "json",
					success : function(data) {
						arrRecordGlobalJsonObj = data;
						document.getElementById("patIdNo").disabled = true;
						$("#InsuredHeader").show();
						$("#detailsTr").show();

						if (arrRecordGlobalJsonObj != "") {
							strDtl = "<div id='insuredTable'><table width='100%' border='1' id='mainTableRptId'  class=''  align='center'  cellspacing='0px'   cellpadding='1px'>"
									+ "<tr>"
									+ "<th  colspan='1' width='5%'>select</th>"
									+ "<th  colspan='1' width='10%'>First Name</th>"
									+ "<th  colspan='1' width='10%'>Middle Name</th>"
									+ "<th  colspan='1' width='10%'>Last Name</th>"
									+ "<th  colspan='1' width='10%'>Age</th>"
									+ "<th  colspan='1' width='10%'>Gender</th>"
									+ "<th  colspan='1' width='10%'>Relationship</th>"
									+ "<th  colspan='1' width='15%'>Insurance Number</th>"
									+ "<th  colspan='1' width='20%'>Expiry Date</th>"
									+ "</tr>";

							for (i = 0; i < arrRecordGlobalJsonObj.length; i++) {
								var p = arrRecordGlobalJsonObj[i].Gender;
								if (p == 1) {
									genderData = "Male";
								} else {
									genderData = "Female";
								}

								strDtl += "<tr>"
										+ "<td width='5%'  align='center'><input type='radio' name='checkid' 		id='checkid"
										+ i
										+ "' 	value='0' onClick='chkBoxClick(this,\""
										+ i
										+ "\");'></td>"
										+ "<td width='10%' align='center'><input type='hidden' name='firstName' 		id='firstName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].FirstName
										+ "' >"
										+ arrRecordGlobalJsonObj[i].FirstName
										+ "</td>"
										+ "<td width='10%' align='center'><input type='hidden' name='middleName' 	id='middleName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].MiddleName
										+ "' >"
										+ arrRecordGlobalJsonObj[i].MiddleName
										+ "</td>"
										+ "<td width='10%' align='center'><input type='hidden' name='lastName' 		id='lastName"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].LastName
										+ "' >"
										+ arrRecordGlobalJsonObj[i].LastName
										+ "</td>"
										+ "<td width='10%' align='center'><input type='hidden' name='Age' 			id='Age"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].Age
										+ "' >"
										+ arrRecordGlobalJsonObj[i].Age
										+ "</td>"
										+ "<td width='10%' align='center'><input type='hidden' name='Gender' 		id='Gender"
										+ i
										+ "' 	value='"
										+ genderData
										+ "' >"
										+ genderData
										+ "</td>"
										+ "<td width='10%' align='center'><input type='hidden' name='Relationship' 	id='Relationship"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].Relationship
										+ "' >"
										+ arrRecordGlobalJsonObj[i].Relationship
										+ "</td>"
										+ "<td width='15%' align='center'><input type='hidden' name='insuranceNumber'id='insuranceNumber"
										+ i
										+ "' value='"
										+ arrRecordGlobalJsonObj[i].InsuranceNumber
										+ "' >"
										+ arrRecordGlobalJsonObj[i].InsuranceNumber
										+ "</td>"
										+ "<td width='20%' align='center'><input type='hidden' name='ExpiryDate' 	id='ExpiryDate"
										+ i
										+ "' 	value='"
										+ arrRecordGlobalJsonObj[i].ExpiryDate
										+ "' >"
										+ arrRecordGlobalJsonObj[i].ExpiryDate
										+ "</td>" + "</tr>";
							}
							strDtl += "</table></div>";
							$("#InsuredPatId").show();
							document.getElementById("myModal").innerHTML = strDtl;
							document.getElementById("headerId").style.display = "block";
							result = "<div id='result'><input type='hidden' name='hiddenResult' value='111'/></div>";
						} else {
							alert("No data found ..!!");
							document.getElementById("patIdNo").disabled = false;
							$("#InsuredHeader").hide();
							$("#detailsTr").hide();

						}
					}
				});
	}
}

function chkBoxClick(obj, index) {
	if (document.getElementById("Gender" + index).value == "Male")
		document.getElementsByName("patGenderCode")[0].value = 'M';
	else
		document.getElementsByName("patGenderCode")[0].value = 'F';

	if (document.getElementById("Relationship" + index).value == "Son"
			|| document.getElementById("Relationship" + index).value == "Daugh") {
		document.getElementsByName("patGuardianName")[0].value = document
				.getElementById("middleName" + index).value;
		document.getElementsByName("patHusbandName")[0].value = "";
	} else if (document.getElementById("Relationship" + index).value == "Wife"
			|| document.getElementById("Relationship" + index).value == "Mother") {
		document.getElementsByName("patHusbandName")[0].value = document
				.getElementById("middleName" + index).value;
		document.getElementsByName("patGuardianName")[0].value = "";
	} else if (document.getElementById("Relationship" + index).value == "Self") {
		document.getElementsByName("patGuardianName")[0].value = document
				.getElementById("middleName" + index).value;
		document.getElementsByName("patHusbandName")[0].value = "";
	} else {
		document.getElementsByName("patGuardianName")[0].value = "";
		document.getElementsByName("patHusbandName")[0].value = "";
	}

	document.getElementsByName("fname")[0].value = document
			.getElementById("firstName" + index).value;
	document.getElementsByName("lname")[0].value = document
			.getElementById("lastName" + index).value;
	document.getElementsByName("patAge")[0].value = document
			.getElementById("Age" + index).value;

	$("#myModal").hide();
	$("#InsuredPatId").show();
	document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showInsuredList(2)"/>  Insured List';
}

function showInsuredList(mode) {
	if (mode == 1) {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showInsuredList(2)"/>  Insured List';
		document.getElementById('myModal').style.display = "none";
	} else {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/minus.gif" onclick="showInsuredList(1)"/> Insured List';
		document.getElementById('myModal').style.display = "block";
	}
}

function chkBoxClick1(obj, index) {
	document.getElementsByName("fname")[0].value = document
			.getElementById("FirstName" + index).value;
	document.getElementsByName("lname")[0].value = document
			.getElementById("LastName" + index).value;
	document.getElementsByName("patAge")[0].value = document
			.getElementById("Age" + index).value;
	document.getElementsByName("patGenderCode")[0].value = document
			.getElementById("Gender" + index).value;

	$("#myModal").hide();
	$("#InsuredPatId").show();
	document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showStaffList(2)"/>  Employee List';
}

function showStaffList(mode) {
	if (mode == 1) {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showInsuredList(2)"/>  Employee List';
		document.getElementById('myModal').style.display = "none";
	} else {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/minus.gif" onclick="showInsuredList(1)"/> Employee List';
		document.getElementById('myModal').style.display = "block";
	}
}

function chkBoxClick2(obj, index) {
	document.getElementsByName("fname")[0].value = document
			.getElementById("FirstName" + index).value;
	document.getElementsByName("lname")[0].value = document
			.getElementById("LastName" + index).value;
	document.getElementsByName("patAge")[0].value = document
			.getElementById("Age" + index).value;

	document.getElementsByName("patGenderCode")[0].value = document
			.getElementById("Gender" + index).value;

	$("#myModal").hide();
	$("#InsuredPatId").show();
	document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showStudentList(2)"/>  Student List';
}

function showStudentList(mode) {
	if (mode == 1) {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/plus.gif" onclick="showInsuredList(2)"/>  Student List';
		document.getElementById('myModal').style.display = "none";
	} else {
		document.getElementById('imageDiv').innerHTML = '<img src="/HIS/hisglobal/images/minus.gif" onclick="showInsuredList(1)"/> Student List';
		document.getElementById('myModal').style.display = "block";
	}

}

function validateAlphaWithoutSpaceOnly(e, obj) {
	var charCode;
	if (typeof e.charCode != 'undefined') // Other
		charCode = e.charCode;
	else
		// IE
		charCode = e.keyCode;
	if (charCode == 0 || (charCode >= 65 && charCode <= 90)
			|| (charCode >= 97 && charCode <= 122))
		return true;
	else
		return false;
}

function validateAlphaNumericWithSpecialCharacterOnly(e) {
	var key;
	var keychar;

	if (window.event)
		key = window.event.keyCode;
	else if (e)
		key = e.which;
	else
		return true;
	keychar = String.fromCharCode(key);

	keychar = keychar.toUpperCase();
	// control keys
	if ((key == null) || (key == 0) || (key == 8) || (key == 9) || (key == 13)
			|| (key == 27) || (key == 32) || (key == 47) || (key == 45)
			|| (key == 95) || (key == 44))
		return true;

	// alphas and numeric
	else if ((("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ./-,:;'][{}-_)(*&$#@!\|")
			.indexOf(keychar) > -1))
		return true;

	else if ((("0123456789").indexOf(keychar) > -1))
		return true;

	else
		return false;
}

function captchaReset() {
	var url = "CaptchaServlet2?t=" + new Date().getTime();
	ajaxFunction(url, "1");

}

function getDepartmentDtls(obj) {

	if (obj.value != -1) {

		$("#patAddDistrictCode").val(obj.value.split('#')[3]);

		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		var data = "mode=GETDEPTLISTNEW&hospitalCode="
				+ obj.value.split('#')[0];
		$.ajax({
			url : action,
			type : 'POST',
			data : data,
			success : function(result) {
				$("#visitingDeptID").html(result);
			}
		});

		setDepartmentDependents(document.getElementsByName("visitingDeptID")[0].value);
	} else {

		$("#patAddDistrictCode").val(0);
		$("#visitingDeptID").html("<option value'-1'>Select Value</option>");

	}

}

//   function checkMobileDup1()
//   {
//  	 alert("Dup")
//   	var hospitalID=$("#hospitalID").val();
//   	var y=$("#hospitalID").val();
//   	var res1 = y.split("#");
//   	var hospitalCode = res1[0];
//   	var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
//		var data="mode=checkMobileDup&patContact="+patContact+"&hospitalCode="+hospitalCode;}
//   
function checkMobileDup() {
	// alert("1")
	var patContact = $("#patContactNo").val();
	var hospitalID = $("#hospitalID").val();
	var y = $("#hospitalID").val();
	var res1 = y.split("#");
	var hospitalCode = res1[0];
	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data = "mode=checkMobileDup&patContact=" + patContact
			+ "&hospitalCode=" + hospitalCode;
	//alert("2")
	$.ajax({
		url : action,
		type : 'POST',
		data : data,
		success : function(result) {
			$("#patContactNo").html(result);
		}
	});
}
function setDepartmentDependents(deptObj) {

	var deptCode = deptObj.options[deptObj.selectedIndex].value;

	if (deptCode.split("#", 1) == "112") {

		$('[name="patGenderCode"]')[0].value = deptCode.substring(23, 24);
		var defaultGenderName = $("#patGenderCode option[value='" + F + "']")
				.text();

		return false;
	}

}
function back() {
	// alert("back")
	window.history.back();
}
//  function PredicAge(){
//	  var deptCode=document.forms[0].visitingDeptID.value;
//	  if(deptCode.split("#",1) == 111 && $('[name="patAge"]')[0].value > 14){
//			alert("Age Limit in This Department  is 14 Yrs");
//			$('[name="patAge"]')[0].value = 14;
//			return false;
//			}  
//  }
function GynGender() {
	var deptCode = document.forms[0].visitingDeptID.value;
	//alert(deptCode)
	// alert($('[name="patGenderCode"]')[0].value)
	if (deptCode.split("#", 1) == '112'
			&& $('[name="patGenderCode"]')[0].value != deptCode.substring(23,
					24) && $('[name="patGenderCode"]')[0].value != "T") {
		 $("#patGenderCode").val('-1');
		alert("Only Female and Transgender gender is allowed in this Department.");

		//	 $("#patGenderCode").val('F');

		return false;
		// $("#patGenderCode").val('F');
	}

}

function getAjaxResponse(res, mode) {

	if (mode == "1") {
		//data:image/png;base64,
		document.getElementById("captchaDiv").innerHTML = '<img id="imageid" align="right" height="30" src="data:image/png;base64,'
				+ res
				+ '"  class="captcha" style="width:90px;height:30px" border="1" />';

	}

}

function onchange_countryCode(obj){
	
	if(obj.value=="101"){
		document.getElementById("patAddStateText").style.display="none";
		document.getElementById("patAddDistrictText").style.display="none";
		document.getElementById("patAddStateCode").style.display="";
		document.getElementById("patAddDistrictCode").style.display="";
		document.getElementById("patAddStateCode").value="37";
	}else{
		document.getElementById("patAddStateText").style.display="";
		document.getElementById("patAddDistrictText").style.display="";
		document.getElementById("patAddStateCode").style.display="none";
		document.getElementById("patAddDistrictCode").style.display="none";
	}
	
}

function setHospitalList(obj) {
	// alert("onchange")
	//var objDept  =document.getElementsByName("hospitalType")[0];
	//alert("objDept "+objDept);
	/*	if(obj.value != -1){
	    	
			$("#patAddDistrictCode").val(obj.value.split('#')[3]);
			
			var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	 		var data="mode=GETDEPTLISTNEW&hospitalCode="+obj.value.split('#')[0];
	 		$.ajax({url:action,type:'POST',data:data,success:function(result){
	 			$("#visitingDeptID").html(result);
	 			}
	 		  });	 
			
	 		setDepartmentDependents (document.getElementsByName("visitingDeptID").val()[0]);
		}else{
			
			$("#patAddDistrictCode").val(0);
			$("#visitingDeptID").html("<option value'-1'>Select Value</option>");
			
		}*/

	var hosType = obj.value;
	//alert("hosCode"+hosCode);
	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data = "mode=GETHOSPITALLIST&hospitalType=" + hosType;
	//stration/registration/reports/getHospitalListhospitalwiseListReport.cnt?hospitalType="+hosCode;
	//alert(action);
	$.ajax({
		url : action,
		type : "POST",
		async : true,
		data : data,
		success : function(data) { //alert("inside ajax");
			$("#hospitalID").html(data);

		}
	});
}

function openpopup() {

	$("#visitDate").val("");
	$("#patAge").val("");
	$("#patGenderCode").val("-1");
	$("#patDOB").val("");
	$("#patAgeUnit").val("YR");
	
	
	if ($("#visitingDeptID").val() != "-1") {

		var hosCode = document.getElementById("hospitalID").value.split("#")[0];
		var patGenderCodeId = document.getElementById("visitingDeptID").value
				.split("#")[1];
		var visitingDeptId = document.getElementById("visitingDeptID").value
				.split("#")[2];
		var departmentUnitCode = document.getElementById("visitingDeptID").value
				.split("#")[1];
		var departmentSlot = document.getElementById("visitingDeptID").value
				.split("#")[1];

		var url = 'index.jsp?visitingDeptID=' + visitingDeptId
				+ "&departmentSlot=" + departmentSlot
				+ "&revisitFlag=0&hospcode=" + hosCode;

		var myWindow = window
				.open(url, 'mywindow',
						'width=700,height=620,left=550,top=300,screenX=200,screenY=200,opacity=0.5');
		myWindow.blur();
	}
}

// For populating appointment Date from opening window to opener window
function populate(appointDate) {
	document.getElementById("visitDate").value = appointDate;

	var y = '8:30 AM to 12:30 PM';
	document.getElementById("Timing").value = y;

}

function callPrint() {
	var divToPrint = document.getElementById('PrintArea').innerHTML;

	var script = document.createElement("script");
	script.type = "text/javascript";
	//Chrome,Firefox, Opera, Safari 3+
	script.onload = function() {

		jQuery("#qrCodeId").qrcode({
			width : 100,
			height : 100,
			text : "hello",
		});
	};

	var printHTML = "<html><head>"
			+ "<style>.main-body{margin-left:10px;margin-right:10px;margin-top:10px;margin-bottom:5px;padding:10px 10px 10px 10px;}</style></head><body class='main-body'>"
			+ divToPrint
			+ "<p align='center'>OPD Timings- Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter).</p>"
			+ "</body><script>function chkstate(){ \nwindow.close();\n}\nfunction print_win(){\nwindow.print();chkstate();\n}\nprint_win();</script></html>";
	//newwin.document.write('.main-body{margin-left:10px;margin-right:10px;margin-top:10px;margin-bottom:5px;padding:10px 10px 10px 10px;}');

	var popupWin = window.open('', 'printwin',
			'left=100,top=100,width=700,height=700,scrollbars=yes');
	//window.open('', '_blank', 'width=500,height=500');

	popupWin.document.open();
	popupWin.document.write(printHTML);
	//window.print();
	// popupWin.document.write(document.getElementsByTagName("head")[0].appendChild(script));

	popupWin.document.close();

}

function openTermsAndConditionPopup() {
	window
			.open(
					'/HISRegistration/HISPreregistration_onlineAppointment/termsAndConditionPHRMS.jsp',
					'_blank', 'width=800,height=650');
}

function validateSpace(obj, name) {

	var valid = true
	var len = obj.value.length
	var val = obj.value

	if (parseInt(len) > 0) {
		for (i = 0; i < len; i++) {
			if ((val.charAt(i)) == ' ') {
				alert("Space is not allowed.");
				valid = false;
				return valid;
			}
		}
	}
	//alert(valid);
	return valid;
}

var selectedHospitalName = '';

function validateSave() {
	if ($("#hospitalTypeID").val() == '-1') {
		alert('Kindly Select Hospital Type.');
		$("#hospitalTypeID").focus();
		return false;
	}

	if ($("#hospitalID").val() == '-1') {
		alert('Kindly Select Hospital Name.');
		$("#hospitalID").focus();
		return false;
	}

	if ($("#visitingDeptID").val() == '-1') {
		alert('Kindly Select Visiting Department.');
		$("#visitingDeptID").focus();
		return false;
	}

	//         	$('[name="patContactNo"]').validatebox({
	// 				required : true,
	// 				validType : [ 'numericwithoutspace', 'equalLengthNumeric[10]','DisableAllZero','mobileNostartwithseven']
	// 			});

	/* 	<for category and based on category ID Number> */

	//         	if($("#patPrimaryCatCodeId").val()=='-1'){
	//         		alert('Please Select Patient Category.');
	//         		$("#patPrimaryCatCodeId").focus();
	//         		return false;
	//         	}
	//var c = document.getElementsByName("patPrimaryCatCode")[0].value;		
	//         	var res = c.split("#"); 
	//             var categoryCode = res[0];	
	//         	if(categoryCode=="12" || categoryCode=="13" || categoryCode=="14") 
	//         	{        		
	//         		if($("#patIdNo").val().trim()==''){
	//             		alert('Please Enter Id');
	//             		$("#patIdNo").focus();
	//             		return false;
	//             	}           	
	//         	}
	if ($("#fname").val().trim() == '') {
		alert('Kindly Enter First Name.');
		$("#fname").focus();
		return false;
	}

	var agedob = $('[name="agedob"]:checked').val();
	var ageUnit = document.forms[0].patAgeUnit.value;
	if (agedob == 'Age') {
		var age = $("#patAge").val();

		if (age == '') {
			alert('Kindly Enter The Age.');
			$("#patAge").focus();
			return false;
		} else if (ageUnit == 'YR' && age < 1 && age > 125) {
			alert("Age should be in the range 1-125 years.");
			$("#patAge").val('');
			return false;
		} else if (ageUnit == 'MTH' && age > 1500) {
			alert("Age should be in the range 1-1500 months.");
			$("#patAge").val('');
			return false;
		} else if (ageUnit == 'WK' && age > 6517) {
			alert("Age should be in the range 1-6517 weeks.");
			$("#patAge").val('');
			return false;
		} else if (ageUnit == 'D' && age > 45625) {
			alert("Age should be in the range 1-45625 days.");
			$("#patAge").val('');
			return false;
		}

	} else if (agedob == 'dob') {
		//        			alert("else if");
		if ($("#patDOB").val() == 'Select Date') {
			alert('Kindly Enter DOB.');
			$("#patDOB").focus();
			return false;
		}
		var selectedDate = $("#patDOB").val();
		var dob = selectedDate.substring(3, 5) + '/'
				+ selectedDate.substring(0, 2) + '/'
				+ selectedDate.substring(6);
		var dobDate = new Date(dob);
		var now = new Date();
		if (dobDate > now) {
			alert("DOB can't be greater than today.");
			$("#patDOB").val('Select Date');
			$("#patDOB").focus();
			return false;
		}
		if (dobDate.getFullYear() + 125 < now.getFullYear()) {
			alert("Age can't be more than 125 yrs.");
			$("#patDOB").val('Select Date');
			$("#patDOB").focus();
			return false;
		}

	}
	//gender amd visiting department handel
	if ($("#patGenderCode").val() == '-1') {
		alert('Kindly Select The Gender.');
		$("#patGenderCode").focus();
		return false;
	} else {
		if ($('#visitingDeptID').val().split("#")[1] != -1) {

		}
	}
	// end
	if ($("#patGuardianName").val().trim() == ''
			&& $("#patHusbandName").val().trim() == ''
			&& $("#patMotherName").val().trim() == ''
			&& !$("#patHusbandName").prop('disabled')) {
		alert('Kindly Enter Father Name Or Spouse Name Or Mother Name.');
		$("#patGuardianName").focus();
		//$("#patHusbandName").focus();
		//$("#patMotherName").focus();

		return false;
	} else if ($("#patGuardianName").val().trim() == ''
			&& $("#patMotherName").val().trim() == ''
			&& $("#patHusbandName").prop('disabled')) {
		alert('Kindly Enter Father Name Or Mother Name.');
		$("#patGuardianName").focus();

	}

	if ($("#patAddCountryCode").val() == '-1') {
		alert('Kindly Select The Country.');
		$("#patAddCountryCode").focus();
		return false;
	}
	if ($("#patAddCountryCode").val() == '101'
			&& $("#patAddStateCode").val() == '-1') {
		alert('Kindly Select The State.');
		$("#patAddStateCode").focus();
		return false;
	}

	if ($("#patAddDistrictCode").val() == '-1') {
		alert('Kindly Select The District.');
		$("#patAddDistrictCode").focus();
		return false;
	}

	if ($("#patAddCity").val() == '') {
		alert('Kindly Enter The City/Village.');
		$("#patAddCity").focus();
		return false;
	}

	var mobileNo = $('[name="patContactNo"]').val().trim();
	if (mobileNo == '') {
		alert('Kindly Enter The Mobile No.');
		$('[name="patContactNo"]').focus();
		return false;
	} else {
		if (!$.isNumeric(mobileNo)) {
			alert('Only Digits are allowed.');
			$('[name="patContactNo"]').focus();
			return false;
		} else {
			if (isStartWithZeroToSix(mobileNo)) {
				alert('Mobile No. should start with 6,7,8 or 9.');
				$('[name="patContactNo"]').focus();
				return false;
			} else {
				var noLength = mobileNo.length;
				if (noLength != '10') {
					alert("Enter 10-digit Mobile No.");
					$('[name="patContactNo"]').focus();
					return false;
				}
			}
		}

	}
	var pinNo = $('[name="patAddPIN"]').val().trim();
	if (pinNo != '') {
		if (!$.isNumeric(pinNo)) {
			alert('Only Numbers Allowed.');
			$('[name="patAddPIN"]').focus();
			return false;
		} else {
			if (isStartWithZero(pinNo)) {
				alert('First Digit of Pincode should not be 0.');
				$('[name="patAddPIN"]').focus();
				return false;
			} else {
				var pinLength = pinNo.length;
				if (pinLength != '6') {
					alert("Enter 6-digit Pincode.");
					$('[name="patAddPIN"]').focus();
					return false;
				}
			}
		}
	} else {
		//alert('Please Enter Pincode');
		$("#patAddPIN").focus();
		return true;
	}

	selectedHospitalName = hospitalID.options[hospitalID.selectedIndex].text;
	return true;
}
function checkMother() {
	var motherName = $("#patMotherName").val();
	alert("Mother::" + document.forms[0].patMotherName.value);
}

function capitalize(str) {
	str = str.split(" ");

	for (var i = 0, x = str.length; i < x; i++) {
		str[i] = str[i][0].toUpperCase() + str[i].substr(1);
	}

	return str.join(" ");
}

function submitForm() {
	//	alert("submitForm")

	var hospitalID = $("#hospitalID").val();
	var y = $("#hospitalID").val();
	var res1 = y.split("#");
	var hospitalCode = res1[0];
	var hospitalName = res1[1];
	var hospitalDisplay = res1[6];

	//  alert("res1::"+res1)
	var visitingDeptID = $("#visitingDeptID").val();

	var DepartmentUnitCode = $("#visitingDeptID").val();
	var z = $("#visitingDeptID").val();
	var res2 = z.split("#");
	var DepartmentUnitCode = res2[1];

	var visitingDeptCode = res2[0];

	var patIdNo = $('[name="patIdNo"]').val();

	var visitDate = $("#visitDate").val();
	var fname = $("#fname").val();
	var lname = $("#lname").val();
	var agedob = $('[name="agedob"]:checked').val();
	var patAge = $("#patAge").val();

	// alert("visitDate >> "+visitDate);

	var patAgeUnit = document.forms[0].patAgeUnit.value;
	var patDOB = $("#patDOB").val();
	var patGenderCode = $("#patGenderCode").val();
	var patGuardianName = $("#patGuardianName").val();
	var patMotherName = $("#patMotherName").val();//document.forms[0].patMotherName.value;
	var patHusbandName = $("#patHusbandName").val();
	//console.log(patMotherName + "\n" + patHusbandName);

	var aadharno = $('[name="aadharno"]').val();
	var patAddCountryCode = $("#patAddCountryCode").val();
	var patAddStateCode = $("#patAddStateCode").val();
	var patAddStateName = $("#patAddStateID").val();
	var patAddHNo = document.forms[0].patAddHNo.value;
	var patAddStreet = $('[name="patAddStreet"]').val();
	var patAddCityLoc = document.forms[0].patAddCityLoc.value;
	var patAddDistrictCode = document.forms[0].patAddDistrictCode.value;
	var patAddDistrict = $('[name="patAddDistrict"]').val();
	var patAddCity = document.forms[0].patAddCity.value;
	var patAddPIN = document.forms[0].patAddPIN.value;
	var patContactNo = $('[name="patContactNo"]').val();
	var patEmail = $('[name="patEmail"]').val();
	var patIsUrban = $('[name="patIsUrban"]').val();
	var deptId = document.getElementById("visitingDeptID");
	var selectedDept = deptId.options[deptId.selectedIndex].text;
	var isPHRMSMobileNoConsent = $('[name="isPHRMSMobileNoConsent"]').val();
	var isAadharConsent = $('input[name=isAadharConsent]').val();
	var hospitalCodeValue = $("#hospitalID").val();
	var deptUnitName=document.getElementById("visitingDeptID");
	var deptUnitName1=deptUnitName.options[deptUnitName.selectedIndex].text;

	var pay_mode = 0;
	if (aadharno == "")
		isAadharConsent = 0;
	/*  For Category and Address on Registration Slip */
	// var patCategory=res[1];
	if($("#patAddStateCode").is(":visible") && $("#patAddDistrictCode").is(":visible") ){
	var districtCode = document.getElementById("patAddDistrictCode");
	var selectedDistrict = districtCode.options[districtCode.selectedIndex].text;
	var StateCode = document.getElementById("patAddStateCode");
	var selectedState = StateCode.options[StateCode.selectedIndex].text;
	}
	else{
		//var districtCode = document.getElementById("patAddDistrictCode");
		var selectedDistrict = document.getElementById("patAddStateText").value;
		//var StateCode = document.getElementById("patAddStateCode");
		var selectedState = document.getElementById("patAddDistrictText").value;
	}
	var countryCode = document.getElementById("patAddCountryCode");
	var selectedcountry = countryCode.options[countryCode.selectedIndex].text;
	var Address = "";
	//     	    var Address=patAddHNo+","+patAddStreet+","+patAddCityLoc+" "+patAddCity+" "+selectedDistrict+" "+selectedState+" "+selectedcountry+" "+patAddPIN;
	// End
	if (patAddPIN != '') {
		if (patAddHNo == '' && patAddStreet == '' && patAddCityLoc == '') {
			Address = titleCase(patAddCity) + ", " + selectedDistrict + " - "
					+ patAddPIN + ", " + titleCase(selectedState) + ", " + selectedcountry;
		} else {
			Address = patAddHNo + ", " + titleCase(patAddStreet) + ", "
					+ titleCase(patAddCityLoc) + ", " + titleCase(patAddCity)
					+ ", " + selectedDistrict + " - " + patAddPIN + ", "
					+ titleCase(selectedState) + ", " + selectedcountry;

		}
	} else {
		if (patAddHNo == '' && patAddStreet == '' && patAddCityLoc == '') {
			Address = titleCase(patAddCity) + ", " + selectedDistrict + ", "
					+ titleCase(selectedState) + ", " + selectedcountry;
		} else {
			Address = patAddHNo + ", " + titleCase(patAddStreet) + ", "
					+ titleCase(patAddCityLoc) + ", " + titleCase(patAddCity)
					+ ", " + selectedDistrict + ", " + titleCase(selectedState) + ", "
					+ selectedcountry;

		}
	}

	//Address=capitalize(Address);
	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var department = $('#visitingDeptID option:selected').text();
	var departmentName = department.split("(");

	var data = "mode=REGISTERPATIENT&hospitalID=" + hospitalID
			+ "&visitingDeptID=" + visitingDeptID + "&visitDate=" + visitDate
			+ "&fname=" + fname + "&lname=" + lname + "&agedob=" + agedob
			+ "&patAge=" + patAge + "&patAgeUnit=" + patAgeUnit + "&patDOB="
			+ patDOB + "&patGenderCode=" + patGenderCode + "&patGuardianName="
			+ patGuardianName + "&patHusbandName=" + patHusbandName
			+ "&patMotherName=" + patMotherName + "&aadharno=" + aadharno
			+ "&patAddCountryCode=" + patAddCountryCode + "&patAddStateCode="
			+ patAddStateCode + "&patAddStateName=" + patAddStateName
			+ "&patAddHNo=" + patAddHNo + "&patAddStreet=" + patAddStreet
			+ "&patAddCityLoc=" + patAddCityLoc + "&patAddDistrictCode="
			+ patAddDistrictCode + "&patAddDistrict=" + patAddDistrict
			+ "&patAddCity=" + patAddCity + "&patAddPIN=" + patAddPIN
			+ "&patContactNo=" + patContactNo + "&patEmail=" + patEmail
			+ "&patIsUrban=" + patIsUrban + "&hospitalname="
			+ selectedHospitalName + "&isPHRMSMobileNoConsent="
			+ isPHRMSMobileNoConsent + "&isAadharConsent=" + isAadharConsent
			+ "&pay_mode=" + pay_mode + "&hospitalCode=" + hospitalCode
			+ "&visitingDeptCode=" + visitingDeptCode + "&DepartmentUnitCode="
			+ DepartmentUnitCode + "&patIdNo=" + patIdNo + "&departmentName="
			+ departmentName[0];

	//	alert(selectedHospitalName+","+hospitalCode);

	$
			.ajax({
				url : action,
				type : 'POST',
				data : data,
				async : false,
				success : function(result) {
					var resultarr = result.split("###");
					//		alert(resultarr);
					var registrationStatus = resultarr[0];
					var registrationNo = resultarr[1];
					var patName = resultarr[2];
					var dateOfVisit = resultarr[3];
					//var hospitalname=hospitalDisplay;
					var age = resultarr[5];
					var ageUnit = resultarr[6];
					var mobileNo = resultarr[7];
					var deptName = departmentName[0];

					if (ageUnit == 'MTH') {

						ageUnit = "(Months)"
					} else if (age > 12 && ageUnit == 'YR') {
						ageUnit = "(Years)"
					}

					var regStatusDesc = '';
					var qrData = registrationNo + "," + fname + "," + age + " "
							+ ageUnit + "/" + patGenderCode + "," + mobileNo;//DepartmentUnitCode+","+patAddCountryCode+","+patAddStateCode+","+patAddDistrictCode;
					//	alert("hospitalDisplay::"+hospitalname);
					//console.log(patName + "\n" + Address);

					if (registrationStatus == '-1') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">Some Error Occurred. Please Try Again Later...</td></tr></table></fieldset>';
					} else if (registrationStatus == '0') {
						regStatusDesc = '<div class="col-sm-4" align="right" style ="background-color : white; "><i class="fa fa-print"  style="font-size:28px; cursor:pointer;"  onclick="callPrint();"></i><div id="PrintArea" class="col-sm-12" ><fieldset width="100%" class="scheduler-border"><legend width="100%" class="scheduler-border">Online Appointment Slip</legend><table class="table table-bordered" width="100%" align="right" id="slipTable"><div id="qrCodeId"></div>'
								+'<tr><td>Appointment Date: </td><td><b>'
								+ dateOfVisit
								+ '</b></td></tr><tr><td>Hospital : </td><td><b> '
								+hospitalName
								+ '</b></td></tr><tr><td>Department (Unit) :</td><td><b> '
								+deptUnitName1//+ deptName
								+'<tr><td>Appointment No.: </td><td><b>'
								+ registrationNo
								+ '</b></td></tr><tr><td>Name :</td><td><b>'
								+ titleCase(patName)
								/*+ '</b></td></tr><tr><td>Appointment Date:</td><td><b> '
								+ dateOfVisit*/
								+ '</b></td></tr><tr><td>Age/Gender :</td><td><b> '
								+ age
								+ ' '
								+ ageUnit+' / '+patGenderCode
								+ '</b></td></tr><tr><td>Mobile No. :</td><td><b> '
								+ mobileNo
								+ '</b></td></tr><tr><td>Address :</td><td><b> '
								+ Address
								/*+ '</b></td></tr><tr><td>Hospital : </td><td><b> '
								+ hospitalName*/
								+ '</b></td></tr><tr><td colspan="3">- Your appointment has been confirmed. <br>- Kindly visit the OPD Counter at the Hospital to obtain Central Registration No. & OPD Card.</td></tr><tr><td colspan="3"> Your details have been sent to your Registered Mobile Number. </td></tr></table></fieldset></div><div><tr><tr><td colspan="2">OPD Timings- Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter).</td></tr><td colspan="2"><button type="button" class="btn btn-default" data-dismiss="modal" onclick="location.reload();">Close</button></td></tr></div></div>';
						//regStatusDesc='<div class="col-sm-4" align="right" style ="background-color : white; "><i class="fa fa-print"  style="font-size:28px"  onclick="callPrint();"></i><div id="PrintArea" class="col-sm-12" ><fieldset width="100%" class="scheduler-border"><legend width="100%" class="scheduler-border">Online  Slip</legend><table class="table table-bordered" width="100%"><tr><td align="right" ></td></tr><tr><td> No </td><td>: '+registrationNo+'</td></tr><tr><td>Name </td><td>: '+patName+'</td></tr><tr><td>Age </td><td>: '+age+' '+ageUnit+'</td></tr><tr><td>Mobile No. </td><td>: '+mobileNo+'</td></tr><tr><td>Address </td><td>: '+ Address +'</td></tr><tr><td colspan="3"> Your Online registration has been Confirmed please visit OPD Counter at Hospital.</td></tr><tr><td colspan="3"> Your details have been sent to your Registered Mobile Number.</td></tr></table></fieldset></div>';
					} else if (registrationStatus == '1') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">You have already applied for Online Registration. </td></tr><tr><td colspan="2"> Please check your registered mobile/email for Online Appointment no.</td></tr> </table></fieldset>';
					} else if (registrationStatus == '2') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">You are already registered with PGI</td></tr><tr><td colspan="2">Please Visit Directly.</td></tr></table></fieldset>';
					} else if (registrationStatus == '3') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">The Online Registration slot For this department is full. Please Try a Different Visit Date.</td></tr> </table></fieldset>';
					}

					//	      		closeModal();
					$("#registrationStatus").html(regStatusDesc);
					//	openCustomPopup('#registrationStatus',450,300);
					jQuery("#qrCodeId").qrcode({
						width : 100,
						height : 100,
						text : qrData
					});

					var canvas = $('#qrCodeId canvas');
					var img = canvas.get(0).toDataURL("image/png");
					//or
					//var img = $(canvas)[0].toDataURL("image/png");
					var qrImage = '<img src="' + img + '"/>';
					$("#qrCodeId").html(qrImage);

				}
			});
	reset();

}
//Timer Check   
// var seconds = 100;//300; //**change 120 for any number you want, it's the seconds **//
//        function secondPassed() {
//        	 var element;
//            var minutes = Math.round((seconds - 30)/60);
//            var remainingSeconds = seconds % 60;
//            if (remainingSeconds < 10) {
//                remainingSeconds = "0" + remainingSeconds;  
//            }
//            document.getElementById('countdown').innerHTML = minutes + ":" + remainingSeconds;
//            if (seconds == 0) {
//                clearInterval(countdownTimer);
//                document.getElementById('countdown').innerHTML = '<input type="button"  value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateotp()">';
//                
//                
//            } else {
//                seconds--;
//            }
//        }

// var countdownTimer = setInterval('secondPassed()', 1000);
//Timer Check

// }
//For avoiding OTP generation and validation   
function savedata(pay_mode) {
	if (!validateSave()) {
		return false;
	} else {
		submitForm_payNow(pay_mode);
	}
}

function titleCase(str) {
	str = str.toLowerCase().split(' '); //take str, lowercase all letters, create array
	for (var i = 0; i < str.length; i++) { //iterate over the array
		if (str[i] != '') {
			str[i] = str[i].split(''); //take each index of the array and turn it into a new index
			str[i][0] = str[i][0].toUpperCase();//now we have a multi-d array. find the first letter make it uppercase
			str[i] = str[i].join(''); //take the multi-d array join it into an array
		}
	}
	return (str.join(' ')); //take the new array from above, turn it back into a string
}

function submitForm_payNow(pay_mode) {

	/*  <Validation for multi date selection for registration> */

	if ($("#chkBox").is(':checked')) {
		if ($("#multiDatePicker").val() == '') {
			alert('Kindly Select  Date for Appointment.');
			$("#patdate").focus();
			return false;
		}
	} else {
		if ($("#visitDate").val() == '') {
			alert('Kindly Select Visit Date.');
			$("#patdate").focus();
			return false;
		}
	}
	//<Multi date Selection validation Ends>

	//	alert("submitForm_payNow: "+pay_mode);
	//var x =$('[name="patPrimaryCatCode"]').val();
	//var res = x.split("#");
	//var patPrimaryCatCode = res[0];        	
	// alert(patPrimaryCatCode);

	var hospitalID = $("#hospitalID").val();
	var y = $("#hospitalID").val();
	var res1 = y.split("#");
	var hospitalCode = res1[0];

	var visitingDeptID = $("#visitingDeptID").val();

	var DepartmentUnitCode = $("#visitingDeptID").val();
	var z = $("#visitingDeptID").val();
	var res2 = z.split("#");
	var DepartmentUnitCode = res2[0];
	var RoomCode = res2[3];

	var visitingDeptCode = res2[2];
	var patIdNo = $('[name="patIdNo"]').val();
	var visitDate = $("#visitDate").val();
	var fname = $("#fname").val();
	var lname = $("#lname").val();
	var agedob = $('[name="agedob"]:checked').val();
	var patAge = $("#patAge").val();
	var patAgeUnit = $('[name="patAgeUnit"]').val();
	var patDOB = $("#patDOB").val();
	var patGenderCode = $("#patGenderCode").val();
	var patGuardianName = $("#patGuardianName").val();
	var patHusbandName = $("#patHusbandName").val();
	var patMotherName = $("#patMotherName").val();
	var aadharno = $('[name="aadharno"]')[0].val();
	var patAddCountryCode = $("#patAddCountryCode").val();
	var patAddStateCode = $("#patAddStateCode").val();
	var patAddStateName = $("#patAddStateID").val();
	var patAddHNo = $('[name="patAddHNo"]').val();
	var patAddStreet = $('[name="patAddStreet"]').val();
	var patAddCityLoc = $('[name="patAddCityLoc"]').val();
	var patAddDistrictCode = $("#patAddDistrictCode").val();
	var patAddDistrict = $("#patAddDistrict").val();
	var patAddCity = $("#patAddCity").val();
	var patAddPIN = $('[name="patAddPIN"]').val();
	var patContactNo = $('[name="patContactNo"]').val();
	var patEmail = $('[name="patEmail"]').val();
	var patIsUrban = $('[name="patIsUrban"]').val();
	var deptId = document.getElementById("visitingDeptID");
	var selectedDept = deptId.options[deptId.selectedIndex].text;
	var isPHRMSMobileNoConsent = $('[name="isPHRMSMobileNoConsent"]').val();
	var isAadharConsent = $('input[name=isAadharConsent]').val();

	/*  For Category and Address on Registration Slip */
	//var CategoryName=res[1]; 
	var districtCode = document.getElementById("patAddDistrictCode");
	var selectedDistrict = districtCode.options[districtCode.selectedIndex].text;
	var StateCode = document.getElementById("patAddStateCode");
	var selectedState = StateCode.options[StateCode.selectedIndex].text;
	var countryCode = document.getElementById("patAddCountryCode");
	var selectedcountry = countryCode.options[countryCode.selectedIndex].text;
	var Address = patAddHNo + "," + titleCase(patAddStreet) + ","
			+ titleCase(patAddCityLoc) + "," + titleCase(patAddCity) + ","
			+ selectedDistrict + "," + selectedState + "," + selectedcountry
			+ "," + patAddPIN;
	//alert(Address);
	if (aadharno == "")
		isAadharConsent = 0;
	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var department = $('#visitingDeptID option:selected').text();

	var departmentName = department.split("(");

	//<if Multiple date Array or Sinlge registration date for visit>
	var arr;
	if ($("#chkBox").is(':checked')) {
		var toSplit = $("#multiDatePicker").val().split(",");
		arr = [];
		for (var i = 0; i < toSplit.length; i++) {
			var dateAr = toSplit[i].split('/');
			arr[i] = dateAr[2] + '-' + dateAr[0] + '-' + dateAr[1];
		}
		arr = arr.join("#");
		$('[name="datePickArr"]')[0].value = arr;

	} else {
		arr = "nodate";
	}
	//Multiple date Array ends  	

	var data = "mode=REGISTERPATIENT&hospitalID=" + hospitalID
			+ "&visitingDeptID=" + visitingDeptID + "&visitDate=" + visitDate
			+ "&fname=" + fname + "&lname=" + lname + "&agedob=" + agedob
			+ "&patAge=" + patAge + "&patAgeUnit=" + patAgeUnit + "&patDOB="
			+ patDOB + "&patGenderCode=" + patGenderCode + "&patGuardianName="
			+ patGuardianName + "&patMotherName=" + patMotherName
			+ "&patHusbandName=" + patHusbandName + "&aadharno=" + aadharno
			+ "&patAddCountryCode=" + patAddCountryCode + "&patAddStateCode="
			+ patAddStateCode + "&patAddStateName=" + patAddStateName
			+ "&patAddHNo=" + patAddHNo + "&patAddStreet=" + patAddStreet
			+ "&patAddCityLoc=" + patAddCityLoc + "&patAddDistrictCode="
			+ patAddDistrictCode + "&patAddDistrict=" + patAddDistrict
			+ "&patAddCity=" + patAddCity + "&patAddPIN=" + patAddPIN
			+ "&patContactNo=" + patContactNo + "&patEmail=" + patEmail
			+ "&patIsUrban=" + patIsUrban + "&hospitalname="
			+ selectedHospitalName + "&isPHRMSMobileNoConsent="
			+ isPHRMSMobileNoConsent + "&isAadharConsent=" + isAadharConsent
			+ "&pay_mode=" + pay_mode + "&hospitalCode=" + hospitalCode
			+ "&visitingDeptCode=" + visitingDeptCode + "&DepartmentUnitCode="
			+ DepartmentUnitCode + "&patIdNo=" + patIdNo + "&RoomCode="
			+ RoomCode + "&departmentName=" + departmentName[0] + "&arr=" + arr;

	$
			.ajax({
				url : action,
				type : 'POST',
				data : data,
				async : false,
				success : function(result) {
					var resultarr = result.split("###");
					var registrationStatus = resultarr[0];
					var registrationNo = resultarr[1];
					var patName = resultarr[2];
					var dateOfVisit = resultarr[3];
					var hospitalname = resultarr[4];
					var age = resultarr[5];
					var ageUnit = resultarr[6];
					var mobileNo = resultarr[7];
					var regStatusDesc = '';

					/* if(registrationStatus=='-1'){
						regStatusDesc='<fieldset><legend>Online  Slip</legend><table width="100%"><tr><td colspan="2">Some Error Occurred. Please Try Again Later...</td></tr></table></fieldset>';
					}else if(registrationStatus=='0'){	  
						regStatusDesc='<div align="right"><input type="button" value="print" onclick="callPrint();"/><div id="PrintArea"><fieldset><legend>Online  Slip</legend><table width="100%"><tr><td align="right" ></td></tr><tr><td>CR Number :</td><td><b> '+registrationNo+'</b></td></tr><tr><td>Name :</td><td><b> '+patName+'</b></td></tr><tr><td>Age :</td><td><b> '+age+' '+ageUnit+'</b></td></tr><tr><td>Mobile No. :</td><td>:<b> '+mobileNo+'</b></td></tr><tr></tr><tr><td>Address :</td><td><b> '+ Address +'</b></td></tr> <tr><td colspan="2"> Your Online registration has been Confirmed please visit OPD Counter at Hospital.</td></tr><tr><td colspan="2"> Your details has been sent to your Registered Mobile Number.</td></tr></table></fieldset></div></div>';
					}else if(registrationStatus=='1'){
						regStatusDesc='<fieldset><legend>Online  Slip</legend><table width="100%"><tr><td colspan="2">You have already applied for Online Registration. </td></tr><tr><td colspan="2"> Please check your registered mobile/email for Online Registration no.</td></tr> </table></fieldset>';
					}else if(registrationStatus=='2'){
						regStatusDesc='<fieldset><legend>Online  Slip</legend><table width="100%"><tr><td colspan="2">You are already registered with PGI</td></tr><tr><td colspan="2">Please Visit Directly.</td></tr></table></fieldset>';
					}else if(registrationStatus=='3'){
						regStatusDesc='<fieldset><legend>Online  Slip</legend><table width="100%"><tr><td colspan="2">The Online Registration slot For this department is full. Please Try a Different visit Date.</td></tr> </table></fieldset>';
					}*/
					if (registrationStatus == '-1') {
						regStatusDesc = '<fieldset><legend>Online  Slip</legend><table width="100%"><tr><td colspan="2">Some Error Occurred. Please Try Again Later...</td></tr></table></fieldset>';
					} else if (registrationStatus == '0') {
						regStatusDesc = '<div class="col-sm-4" align="right" style ="background-color : white; "><i class="fa fa-print"  style="font-size:28px;cursor:pointer;"  onclick="callPrint();"></i><div id="PrintArea" class="col-sm-12" ><fieldset width="100%" class="scheduler-border"><legend width="100%" class="scheduler-border">Online Appointment Slip</legend><table class="table table-bordered" width="100%" id="slipTable"><div id="qrCodeId"></div><tr><td>Appointment No.: </td><td><b>'
								+ registrationNo
								+ '</b></td></tr><tr><td>Name :</td><td><b>'
								+ titleCase(patName)
								+ '</b></td></tr><tr><td>Appointment Date:</td><td><b> '
								+ dateOfVisit
								+ '</b></td></tr><tr><td>Department :</td><td><b> '
								+ deptName
								+ '</b></td></tr><tr><td>Age/Gender :</td><td><b> '
								+ age
								+ ' '
								+ ageUnit+' / '+patGenderCode
								+ '</b></td></tr><tr><td>Mobile No. :</td><td><b> '
								+ mobileNo
								+ '</b></td></tr><tr><td>Address :</td><td><b> '
								+ Address
								+ '</b></td></tr><tr><td>Hospital : </td><td><b> '
								+ hospitalName
								+ '</b></td></tr><tr><td colspan="3">- Your appointment has been confirmed. <br>- Kindly visit the OPD Counter at the Hospital to obtain Central Registration No. & OPD Card.</td></tr><tr><td colspan="3"> Your details have been sent to your Registered Mobile Number. </td></tr></table></fieldset></div><div><tr><tr><td colspan="2">OPD Timings- Mon-Sat, 08 AM - 02 PM (Summer) & 09 AM - 03 PM (Winter).</td></tr><td colspan="2"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button></td></tr></div></div>';
						//regStatusDesc='<div class="col-sm-4" align="right" style ="background-color : white; "><i class="fa fa-print"  style="font-size:28px"  onclick="callPrint();"></i><div id="PrintArea" class="col-sm-12" ><fieldset width="100%" class="scheduler-border"><legend width="100%" class="scheduler-border">Online  Slip</legend><table class="table table-bordered" width="100%"><tr><td align="right" ></td></tr><tr><td> No </td><td>: '+registrationNo+'</td></tr><tr><td>Name </td><td>: '+patName+'</td></tr><tr><td>Age </td><td>: '+age+' '+ageUnit+'</td></tr><tr><td>Mobile No. </td><td>: '+mobileNo+'</td></tr><tr><td>Address </td><td>: '+ Address +'</td></tr><tr><td colspan="3"> Your Online registration has been Confirmed please visit OPD Counter at Hospital.</td></tr><tr><td colspan="3"> Your details have been sent to your Registered Mobile Number.</td></tr></table></fieldset></div>';
					} else if (registrationStatus == '1') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">You have already applied for Online Appointment. </td></tr><tr><td colspan="2"> Please check your registered mobile/email for Online Appointment no.</td></tr> </table></fieldset>';
					} else if (registrationStatus == '2') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">You are already registered with PGI</td></tr><tr><td colspan="2">Please Visit Directly.</td></tr></table></fieldset>';
					} else if (registrationStatus == '3') {
						regStatusDesc = '<fieldset><legend>Online Appointment Slip</legend><table width="100%"><tr><td colspan="2">The Online Registration slot For this department is full. Please Try a Different Visit Date.</td></tr> </table></fieldset>';
					}

					//<for existence of duplicate record....>
					else if (registrationStatus == '5') {
						var fatherName = resultarr[4];
						var patRegDate = resultarr[8];
						var patAddress = resultarr[9];
						var url = 'duplicateRecord.jsp?&registrationNo='
								+ registrationNo + "&patName=" + patName
								+ "&age=" + age + "&fatherName=" + fatherName
								+ "&mobileNo=" + mobileNo + "&patRegDate="
								+ patRegDate + "&patAddress=" + patAddress;
						var myWindow = window
								.open(url, 'mywindow',
										'width=999,height=200,left=200,top=350,screenX=100,screenY=200,opacity=0.5');
						self.blur();
						regStatusDesc = "";
					}
					//	      		closeModal();
					$("#registrationStatus").html(regStatusDesc);
					if (regStatusDesc == "") {
					} else {
						openCustomPopup('#registrationStatus', 450, 300);
					}

				}
			});
	reset();
}

$(".modalCloseImg simplemodal-close").click(function() {

	$.modal.close();
});

/*function generateotp()//This function is not in Use as changes for Timer by devika
 {

 /*  <Validation for multi date selection for registration> */
/*	if ($("#chkBox").is(':checked')) {
 alert("For Multiple Date Registration Kindly Select Pay-Now option \n\nIf You want to Pay-Later then de-select the multiple date selector");
 return false;
 } else {
 if ($("#visitDate").val() == '') {
 alert('Kindly Select Visit Date.');
 $("#patdate").focus();
 return false;
 }
 }
 //<Multi date Selection validation Ends>

 if (!validateSave()) {
 return false;
 } else {

 var patContactNo = $('[name="patContactNo"]').val();
 var patEmail = $('[name="patEmail"]').val();
 var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";

 var data = "mode=SENDOTP1&patContactNo=" + patContactNo + "&patEmail="
 + patEmail;

 $.ajax({
 url : action,
 type : 'POST',
 data : data,
 async : false,
 success : function(result) {
 var displayMobNo = patContactNo.substring(6, 10);
 document.getElementById("btnsave").style.display = "none";
 alert("displayMobNo::" + displayMobNo)
 //	    	    document.getElementById("btnotp1").style.display="none";
 //	    	    alert("registrationStatus:"+document.getElementById("registrationStatus").innerHTML);

 $("#registrationStatus").modal();
 //	      		openCustomPopup('#registrationStatus',450,200);	 

 //	      		alert("lable1::"+document.getElementById("lable1").value)
 //	      		 $("#lable1").html("OTP has been sent to your Mobile No. ******"+displayMobNo);
 //	      			
 }
 });
 }
 }
 */
function genTP() {

	openCustomPopup('#registrationStatus', 450, 200);
}

function MobileNo() {
	var displayMobNo = $('[name="patContactNo"]').val().substring(6, 10);
	// $("#lable1").html("OTP has been sent to your Mobile No. ******"+displayMobNo);

	/*$("#registrationStatus .modal-title").html(
			"<font color='blue'><b>OTP has been sent to your Mobile No. ******" + displayMobNo
					+ "</b></font>");*/
	$("#registrationStatus").modal();
}

function validateotp() {
	// alert("function")
	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data = "mode=VALIDATEOTP&crNo=" + $('[name="patContactNo"]').val()
			+ "&otp=" + $("#otp").val();
	$
			.ajax({
				url : action,
				type : 'POST',
				data : data,
				async : false,
				success : function(result) {
					if (result == "1") {
						//alert("VALIDATEOTP")	
						$('#btnsave').hide();
						// 				 document.getElementById("btnsave").style.display="none";
						// document.getElementById("btnotp1").style.display="block";
						// closeModal();
						submitForm();

					} else if (result == "2") {
						//alert("2")//submitForm();
						//	$("#lable1").html("OTP Entered is Incorrect. Enter OTP again.");
						$("#OTPMobile")
								.html(
										"<font color='red'><b>Incorrect OTP. Enter the correct OTP.</b></font>");
						//$("#registrationStatus").modal();
					} else if (result == "3") {
						$("#OTPMobile")
								.html(
										"<font color='red'><b>OTP Expired. Kindly Try again.</b></font>");
					}

				}
			});
	//$('#btnsave').hide();
}

function checkMobileDup() {

	var hospitalCode = $("#hospitalID").val();
	var y = $("#hospitalID").val();
	var res1 = y.split("#");
	var hospitalCode = res1[0];
	var patContactNo = $('[name="patContactNo"]').val();

	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	var data = "mode=CHECKMOBILEDUP&patContactNo=" + patContactNo
			+ "&hospitalCode=" + hospitalCode;
	//var data="mode=checkMobileDuplicay&crNo="+$('[name="patContactNo"]').val();

	$.ajax({
		url : action,
		type : 'POST',
		data : data,
		async : false,
		success : function(result) {
			//document.forms[0].checkDup.value=result
			//alert(result);
			if (result.endsWith("data")) {
				//do nothing
			}
			else{
				var finalData=result.split("##");
				var dataCntnt="";
				for(var i=1;i<finalData.length;i++){
					if(finalData[i].endsWith('Appointment')){
						var data=finalData[i].split("^");
					var dataCntnt=dataCntnt+"<tr><td>"+i+".</td><td>"+data[0]+"</td><td align='center'>-"+"</td><td>"+data[1]+"</td><td>"+data[2]+"/"+data[3]+"</td><td>"+data[4]+"</td><td>"+data[5]+"</td></tr>";
					}
					else if(finalData[i].endsWith('Registration')){
						var data=finalData[i].split("^");
						var dataCntnt=dataCntnt+"<tr><td>"+i+".</td><td align='center'>-"+"</td><td>"+data[0]+"</td><td>"+data[1]+"</td><td>"+data[2]+"/"+data[3]+"</td><td>"+data[4]+"</td><td>"+data[5]+"</td></tr>";
						}
					}
					//	var dataCntnt=dataCntnt+"";
				
				document.getElementById("myModalBody").innerHTML="<b>This Mobile No. has already been registered with this hospital for the following records-</b><br><br><table class='table-striped table-bordered' style='width:100%;'><tr><th>S.No.</th><th>Appointment No.</th><th>CR No.</th><th>Name</th><th>Age/Gender</th><th>Mobile No.</th><th>Registration Date</th></tr> "+
				dataCntnt+" </table>";
					$("#duplicacyPopup").modal();

				}
				//.getElementById("duplicacyPopup").style.display="block";
				//alert("This Mobile Number is " + patContactNo
				//	+ " already registered in this Hospital.");

		//	}
			//		

		}
	});
}

///

/*function resendOTP()
 { 
 alert("Resend")
 var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
 var data="mode=SENDOTP&crNo="+$("#crno").val()+"&patContactNo="+mobNo;
 $.ajax({url:action,tpye:'POST',data:data,async: false,success:function(result)
 {

 var displayMobNo= mobNo.substring(6,10);
 $("#registrationStatus").modal();
 //      			openCustomPopup('#registrationStatus',450,200);
 $("#lable1").html("OTP has been sent to your Mobile No. ******"+displayMobNo);

 setTimerForOTP();
 }
 });
 }

 function setTimerForOTP(){


 var action="/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";

 var data="mode=SENDOTP1&patContactNo="+patContactNo+"&patEmail="+patEmail;

 $.ajax({url:action,type:'POST',data:data,async: false,success:function(result)
 {
 var displayMobNo= patContactNo.substring(6,10);

 document.getElementById("btnresend").disabled = true;
 document.getElementById("btnsave").disabled = false;

 // Set the date we're counting down to
 var countDownDate = new Date(new Date().getTime() + 1*60000);

 // Update the count down every 1 second
 var x = setInterval(function() {

 // Get today's date and time
 var now = new Date().getTime();

 // Find the distance between now and the count down date
 var distance = countDownDate - now;

 // Time calculations for days, hours, minutes and seconds
 var days = Math.floor(distance / (1000 * 60 * 60 * 24));
 var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
 var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
 var seconds = Math.floor((distance % (1000 * 60)) / 1000);

 // Output the result in an element with id="demo"
 document.getElementById("btnresend").innerHTML =  "Resend OTP ( "+seconds + "s )";

 // If the count down is over, write some text 
 if (distance < 0) {
 clearInterval(x);
 document.getElementById("btnresend").innerHTML =  "Resend OTP";
 document.getElementById("btnresend").disabled = false;
 document.getElementById("btnsave").disabled = true;


 }
 }, 1000);


 }

 function countdown( elementName, minutes, seconds )
 {

 var element, endTime, hours, mins, msLeft, time;

 function twoDigits( n )
 {
 return (n <= 9 ? "0" + n : n);
 }

 function updateTimer()
 {
 msLeft = endTime - (+new Date);
 if ( msLeft < 1000 ) {


 var patContactNo=$('[name="patContactNo"]').val();
 var action="";
 //      		<%--  var action="<%=context_path%>LabRptRegistrationServlet"; --%>
 var urlNew="/AHIMSG5/hislogin/transactions/action/EXPIREOTPLgnFtr";
 var data="mode=SENDOTP"+"&varNewMobileNumber="+$('#mobileNoFormat').val();
 urlNew = createFHashAjaxQuery(urlNew+"?"+data);


 // var data="mode=EXPIREOTP&patContactNo="+$("#crno").val();
 $.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
 {
 if(result=="1")
 {
 $("#lable2").html("Time Over Please Resend OTP");
 element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
 }	   	
 } 
 });
 } else {
 time = new Date( msLeft );
 hours = time.getUTCHours();
 mins = time.getUTCMinutes();
 element.innerHTML = (hours ? hours + ':' + twoDigits( mins ) : mins) + ':' + twoDigits( time.getUTCSeconds() );
 setTimeout( updateTimer, time.getUTCMilliseconds() + 500 );

 alert("time"+time);
 }
 }

 element = document.getElementById( elementName );
 endTime = (+new Date) + 1000 * (60*minutes + seconds) + 500;
 alert("endtime"+endTime);
 updateTimer();

 }

 */
function generateOtp() {
	/*  <Validation for multi date selection for registration> */
	if ($("#chkBox").is(':checked')) {
		alert("For Multiple Date Registration Kindly Select Pay-Now option \n\nIf You want to Pay-Later then de-select the multiple date selector");
		return false;
	} else {
		if ($("#visitDate").val() == '') {
			alert('Please Select Visit Date.');
			$("#patdate").focus();
			return false;
		}
	}
	//<Multi date Selection validation Ends>

	if (!validateSave()) {
		return false;
	} else {

		var patContactNo = $('[name="patContactNo"]').val();

		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		//	var data="mode=SENDOTP&crNo="+$("#crno").val()+"&patContactNo="+patContactNo;
		var data = "mode=SENDOTP1&patContactNo=" + patContactNo;
		$.ajax({
			url : action,
			tpye : 'POST',
			data : data,
			async : false,
			success : function(result) {
				//alert(result);
				//console.log("url-> "+url);
				var displayMobNo = $('#patContactNo').val().substring(6, 10);
				$("#OTPMobile").html(
						"<font color='blue'><b>OTP has been sent to your Mobile No. ******"
								+ displayMobNo + "</b></font>");

				$("#popupLaunch").click();
				setTimerForOTP();
			}
		});
	}
}

//      	function proceedOld(){
//      		var urlNew="/AHIMSG5/hislogin/transactions/action/VALIDATEOTPLgnFtr";
//      		var data="varNewMobileNumber="+$('#mobileNoFormat').val()+"&otp="+$("#otp").val();
//      		
//      		//var data="mode=VALIDATEOTP&crNo="+$("#crno").val()+"&otp="+$("#otp").val();
//
//      		urlNew = createFHashAjaxQuery(urlNew+"?"+data);
//      			
//      		data = "";
//      		
//      		$.ajax({url:urlNew,tpye:'POST',data:data,async: false,success:function(result)
//      			{
//      			if(result=="1")
//      				{
//      	 
//      				//window.open('/HISInvestigationG5/HISPreregistration_onlineAppointment/LabRptRegistrationoldServlet.lab','_self');
//      				//document.getElementById("tr2").style.display="none";
//      				//document.getElementById("OldNext").style.display="none";
//      				//document.getElementById("OldOTP").style.display="";
//      			//	document.getElementById("patType").value="1";
//      				$(".label1Class").html("OTP verified successfully.");
//      			//	document.getElementById("varNewMobileNumber").value="";
//      				//document.getElementById("otp").value="";
//      				document.getElementById("otp").disabled=true;
//      				$("#closeBtn").click();
//      			//	document.getElementById("varNewMobileNumber").disabled=true;
//      				//document.getElementById("varConfirmMobileNumber").disabled=true;
//      				addUpdateMobileNo.submitOnSave();
//      				
//      				//redirect();
//      				}
//      		 	else if(result=="2")
//      			{
//      				$(".label1Class").html("Incorrent OTP Entered. Enter OTP Again.");
//      			}
//      			else if(result=="3")
//      			{
//      				$(".label1Class").html("OTP has expired. Click on Resend OTP button.");
//      			}	 
//      			}
//      		});
//      			
//
//      	}
//
//
function resendOTP() {

	var patContactNo = $('[name="patContactNo"]').val();

	var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
	//	var data="mode=SENDOTP&crNo="+$("#crno").val()+"&patContactNo="+patContactNo;
	var data = "mode=SENDOTP1&patContactNo=" + patContactNo;
	$.ajax({
		url : action,
		tpye : 'POST',
		data : data,
		async : false,
		success : function(result) {
			//alert(result);
			//console.log("url-> "+url);
			var displayMobNo = $('#patContactNo').val().substring(6, 10);
			$("#OTPMobile").html(
					"<font color='blue'><b>OTP has been sent to your Mobile No. ******"
							+ displayMobNo + "</b></font>");

			//	$("#popupLaunch").click();
			setTimerForOTP();
		}
	});
}

function setTimerForOTP() {

	document.getElementById("btnresend").disabled = true;
	document.getElementById("btnsave").disabled = false;

	// Set the date we're counting down to
	var countDownDate = new Date(new Date().getTime() + 1 * 60000);

	// Update the count down every 1 second
	var x = setInterval(
			function() {

				// Get today's date and time
				var now = new Date().getTime();

				// Find the distance between now and the count down date
				var distance = countDownDate - now;

				// Time calculations for days, hours, minutes and seconds
				var days = Math.floor(distance / (1000 * 60 * 60 * 24));
				var hours = Math.floor((distance % (1000 * 60 * 60 * 24))
						/ (1000 * 60 * 60));
				var minutes = Math.floor((distance % (1000 * 60 * 60))
						/ (1000 * 60));
				var seconds = Math.floor((distance % (1000 * 60)) / 1000);

				// Output the result in an element with id="demo"
				document.getElementById("btnresend").innerHTML = "Resend OTP "
						+ "(" + seconds + "s)";

				// If the count down is over, write some text 
				if (distance < 0) {
					clearInterval(x);
					document.getElementById("btnresend").innerHTML = "Resend OTP";// $("#resend-otp").html();
					//$('#btnsave').prop('disabled', true);
					document.getElementById("btnresend").disabled = false;
					document.getElementById("btnsave").disabled = true;
					document.getElementById("OTPMobile").innerHTML = "<font color='red'><b>Time Expired. Kindly click on 'Resend OTP'.</b></font>";

				}
			}, 1000);

}

function countdown(elementName, minutes, seconds) {

	var element, endTime, hours, mins, msLeft, time;

	function twoDigits(n) {
		return (n <= 9 ? "0" + n : n);
	}

	function updateTimer() {
		msLeft = endTime - (+new Date);
		if (msLeft < 1000) {

			var patContactNo = $('[name="patContactNo"]').val();
			var action = "";
			//	<%--  var action="<%=context_path%>LabRptRegistrationServlet"; --%>
			//	var patContactNo=$('[name="patContactNo"]').val(); 

			var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
			var data = "mode=EXPIREOTP&patContactNo=" + patContactNo;
			$
					.ajax({
						url : action,
						tpye : 'POST',
						data : data,
						async : false,
						success : function(result) {
							if (result == "1") {
								$("#lable1").html(
										"Time Over. Please Resend OTP.");
								element.innerHTML = '<input type="button" value="Resend OTP" style="padding-left: 25px; padding-right: 25px;" onclick="generateOtp()">';
							}
						}
					});
		} else {
			time = new Date(msLeft);
			hours = time.getUTCHours();
			mins = time.getUTCMinutes();
			element.innerHTML = (hours ? hours + ':' + twoDigits(mins) : mins)
					+ ':' + twoDigits(time.getUTCSeconds());
			setTimeout(updateTimer, time.getUTCMilliseconds() + 500);

			alert("time" + time);
		}
	}

	element = document.getElementById(elementName);
	endTime = (+new Date) + 1000 * (60 * minutes + seconds) + 500;
	alert("endtime" + endTime);
	updateTimer();

}

function reset() {
	$("#hospitalID").val('-1');
	$("#visitingDeptID").val('-1');
	$("#visitDate").val('');
	$("#patGenderCode").val('-1');
	$("#patGuardianName").val('');
	//$("#patMotherName").val('');
	$('[name="patHusbandName"]').val('');
	$("#fname").val('');
	$("#lname").val('');
	$("#patDOB").val('Select Date');
	$('[name="aadharno"]').val('');
	$("#patAddCountryCode").val('101');
	$("#patAddStateCode").val('-1');//37 for Andhra
	$('[name="patAddHNo"]').val('');
	$('[name="patAddCityLoc"]').val('');
	$('[name="patAddDistrictCode"]').val('-1');// 536 for Hyderabad
	$('[name="patAddCity"]').val('');
	$('[name="patAddPIN"]').val('');
	$('[name="patContactNo"]').val('');
	$("#patEmail").val('');
	$('[name="patAddStreet"]').val('');
	$("#patAge").val('');
	$('#divPHRMSMobileNoConsentId').hide();

	document.getElementById("btnotp1").enabled = true;
	document.forms[0].reset();
	//document.getElementById("btnotp1").style.display="";

	return;

}

function registerBtnClk(){
	$("#btnotp1").click();
}

function IsEmail(email) {
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return regex.test(email);
}
function validateCapcha() {
	var validationStatus = 'invalid';
	var regKey = $("[name='regKey']").val();
	if (regKey != "") {
		var action = "/HISRegistration/HISPreregistration_onlineAppointment/PreRegistrationServlet";
		var data = "mode=VALIDATECAPCHA&regKey=" + regKey;
		$.ajax({
			url : action,
			tpye : 'POST',
			data : data,
			async : false,
			success : function(result) {
				if (result == '0') {
					alert('Please Enter Correct Verification Code.');
					$("#regKey").focus();
					validationStatus = "invalid";

				} else {
					validationStatus = "valid";
				}
			}
		});
	} else {
		validationStatus = "invalid";
	}
	return validationStatus;

}
function clearData() {
	$("#registrationStatus").val('');
	$("#registrationStatus").html('');
	reset();
	return;
}
function isStartWithZero(val) {

	var startingWithZero = true;
	var len = val.length;

	if (parseInt(len) > 0) {

		if ((val.charAt(0)) == 0) {
			startingWithZero = true;
		} else {
			startingWithZero = false;
		}
	} else {
		startingWithZero = false;
	}

	return startingWithZero;

}

function isStartWithZeroToSix(val) {

	var startingWithZero = true;
	var len = val.length;

	if (parseInt(len) > 0) {

		if ((val.charAt(0)) != 6 && (val.charAt(0)) != 7
				&& (val.charAt(0)) != 8 && (val.charAt(0)) != 9) {
			startingWithZero = true;
		} else {
			startingWithZero = false;
		}
	} else {
		startingWithZero = false;
	}

	return startingWithZero;

}

function OnchangeMobileNo() {
	if ($('[name="patContactNo"]').val().length == 10) {
		$("#divPHRMSMobileNoConsentId").show();
	} else if ($('[name="patContactNo"]').val().length != 10) {
		$("#divPHRMSMobileNoConsentId").hide();
	}
}
function checkUncheckIsPHRMSMobileNoConsent(event) {
	$('[name="isPHRMSMobileNoConsent"]').val(event.value);
}
function OnchangeAadharNo() {
	if ($('[name="aadharno"]').val().length == 12) {
		$("#divAadharConsentId").show();
	} else if ($('[name="aadharno"]').val().length != 12) {
		$("#divAadharConsentId").hide();
	}
}
function checkUncheckAadharConsent(event) {
	$('[name="isAadharConsent"]').val(event.value);
}