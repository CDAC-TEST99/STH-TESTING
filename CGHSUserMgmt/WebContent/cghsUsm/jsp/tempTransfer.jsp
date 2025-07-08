<%-- JSP Script created on 28th November 2024 --%>
<!DOCTYPE html>
<%@page import="formFlowX.fb.FormFlowXCommonFB"%>
<%@page import="javax.servlet.http.HttpServletRequest"%>
<%@page import="hisglobal.security.TokenConfig"%>
<%@page import="formFlowX.vo.FormFlowXUserVO"%>
<%@page import="hissso.config.HISSSOConfig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
    <title>Temporary Transfer Request</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <jsp:include page="/global/jsp/commonLayout.jsp" flush="true"></jsp:include>
    <style>
        .custom-file-upload {
            border: 1px solid #ced4da;
            display: inline-block;
            padding: 6px 12px;
            cursor: pointer;
            border-radius: 4px;
            background-color: #fff;
            width: 100%;
            text-align: center;
        }
        .btn-circle {
            width: 40px;
            height: 40px;
            padding: 6px 0;
            border-radius: 50%;
            text-align: center;
            font-size: 20px;
            line-height: 1.42857;
            display: inline-block;
            background-color: #28a745; 
            color: white;
            border: none;
            margin-left: 10px;
        }
        .btn-circle:hover {
            background-color: #218838; 
            color: white;
            text-decoration: none;
        }
        #detailsTable th, #detailsTable td {
            text-align: center;
            vertical-align: middle;
        }
        .btn-danger {
    background-color: #dc3545 !important; /* Bootstrap danger red */
    color: #fff !important; /* White text */
}
    </style>
    <script type="text/javascript" src="/CGHSUserMgmt/cghsUsm/js/tempTransfer.js"></script>
</head>

  <%
  		FormFlowXCommonFB fb=(FormFlowXCommonFB ) request.getAttribute("FORMBEAN");
          	  String isGlobal=fb.getIsGlobal(); 
           		if(isGlobal==null)
          	 		isGlobal="0";
          %>
  
<body>

<section class="p-0">
    <form action="/CGHSUserMgmt/FormFlowXACTION" name="FormFlowXACTION" method="post">
        <fieldset id="ENTRYFORM">
                                    <legend class="w-auto px-2 legendcss" id='formTitle'>Temporary Transfer</legend>

			<div class="legend2 ">


				<button class="btn btn-his-sm  btn-sm"  id="saveTransferBtn" onclick="saveTransfer()">
					<i class="fas fa-save"></i> &nbsp; Save
				</button>
				<button class='btn-his-outline-sm ' id="clearTransferBtn">
					<i class='fa-solid fa-broom fa-fw'></i>&nbsp;Clear
				</button>
				<button class="btn-his-outline-sm" id="cancelTransferBtn">
					<i class="fas fa-times"></i> Cancel
				</button>

			</div>
            <!-- Accordion for Role Selection Details -->
            <div class="accordion" id="roleSelectionAccordion">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="roleSelectionHeading">
                        <button class="accordion-button bg-light" type="button" data-bs-toggle="collapse"
                                data-bs-target="#roleSelectionCollapse" aria-expanded="true"
                                aria-controls="roleSelectionCollapse">
                           Transfer Details
                        </button>
                    </h2>
                    <div id="roleSelectionCollapse" class="accordion-collapse collapse show"
                         aria-labelledby="roleSelectionHeading" data-bs-parent="#roleSelectionAccordion">
                        <div class="accordion-body">
                            <!-- From City and From Hospital -->
                            <!-- <div class="container-fluid mt-4" id="fromCityHospitalSection">
                                <div class="row">
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="fromCityDropdown" class="col-form-label col-form-label-md" data-validation="mandatory">From City:</label>
                                            <select id="fromCityDropdown" name="fromCity" class="form-control form-control-sm" data-validation="mandatory">
                                                <option value="">Select City</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="fromHospitalDropdown" class="col-form-label col-form-label-md">From Hospital:</label>
                                            <select id="fromHospitalDropdown" name="fromHospital" class="form-control form-control-sm" data-validation="mandatory">
                                                <option value="">Select Hospital</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div> -->

                            <!-- Transfer Details Table -->
                            <!-- <br><br> -->
                                <div id='transferDetailTableDiv' class="col-md-12  no-more-tables hideData">
                                
                                	<!--  <h3>Transfer Details</h3>
                                <hr/> -->
                                
                                    <table id="detailsTable" class="table table-striped border">
                                        <thead>
                                            <tr>
                                                <th>Order Date</th>
                                                <th>Order No</th>
                                                <th>Transfer To City</th>
                                                <th>Transfer To Hospital</th>
                                                <th>UserName</th>
                                                <th>Status</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <!-- Rows dynamically added via JS -->
                                        </tbody>
                                    </table>
                                </div>
                           
                        </div>
                    </div>
                </div>
            </div>

            <!-- Accordion for New Transfer Request -->
            <div class="accordion mt-4" id="newTransferAccordion">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="newTransferHeading">
                        <button class="accordion-button bg-light" type="button" data-bs-toggle="collapse"
                                data-bs-target="#newTransferCollapse" aria-expanded="true"
                                aria-controls="newTransferCollapse">
                            New Role Transfer Request
                        </button>
                    </h2>
                    <div id="newTransferCollapse" class="accordion-collapse collapse show"
                         aria-labelledby="newTransferHeading" data-bs-parent="#newTransferAccordion">
                        <div class="accordion-body">
                            <div class="container-fluid mt-4" id="newTransferRequestSection">
                                <div class="row">
                                	
                                    <!-- User Dropdown -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="userDropdown" class="col-form-label col-form-label-md">User:</label>
                                            <select id="userDropdown" name="user" class="form-control form-control-sm select2" data-validation="mandatory">
                                                <option value="">Select User</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Transfer To City -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="cityDropdown" class="col-form-label col-form-label-md">Transfer To City:</label>
                                            <select id="cityDropdown" name="transferCity" class="form-control form-control-sm select2" data-validation="mandatory">
                                                <option value="">Select City</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Transfer To Hospital -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="hospitalDropdown" class="col-form-label col-form-label-md">Transfer To Wellness Center:</label>
                                            <select id="hospitalDropdown" name="transferHospital" class="form-control form-control-sm select2" data-validation="mandatory">
                                                <option value="">Select Wellness Center</option>
                                            </select>
                                        </div>
                                    </div>
                                    <!-- Transfer Order No -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="orderNo" class="col-form-label col-form-label-md">Transfer Order No:</label>
                                            <input type="text" id="orderNo" name="transferOrderNo"
                                                   class="form-control form-control-sm" placeholder="Enter Order No" data-validation="mandatory">
                                        </div>
                                    </div>
                                    <!-- Transfer Order Date -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="orderDate" class="col-form-label col-form-label-md">Transfer/Relieving Date:</label>
                                            <input type="date" id="orderDate" name="transferOrderDate"
                                                   class="form-control form-control-sm" data-validation="mandatory">
                                        </div>
                                    </div>
                                   
                                    <!-- Remarks -->
                                    <div class="col-lg-3">
                                        <div class="form-group">
                                            <label for="remarks" class="col-form-label col-form-label-md">Remarks:</label>
                                            <textarea id="remarks" name="remarks" class="form-control form-control-sm" rows="2" placeholder="Enter Remarks"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
        <input type="hidden" name="masterKey" id="masterKey" />
        <input type="hidden" name="hmode" id="hmode" />
        <input type="hidden" name="isGlobal" id="isGlobalLocalVar" value="<%=isGlobal%>" />
        <input type="hidden" name="tid" id="tid" />
        <input type="hidden" name="initMode" id="initMode" />
        <input type="hidden" name="primaryKeys" id="primaryKeys" />
    </form>
</section>


</body>
</html>
<%-- JSP Script created on 28th November 2024 --%>
