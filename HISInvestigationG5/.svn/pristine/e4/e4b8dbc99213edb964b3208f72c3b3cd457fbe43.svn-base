
package new_investigation.transactions.controller.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang.WordUtils;

//import org.apache.commons.text.WordUtils;

import hisglobal.utility.HisUtil;
import new_investigation.vo.NEWOfflineResultEntryVO;

public class NEWOfflineResultEntryHLP {

	public static String getOfflineResultEntryDtls(NEWOfflineResultEntryVO vo, HttpServletRequest request)
			throws Exception {

		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		int count = 0, j = 0, indTestFlag = 0;
		String strHiddenVal = "", strRefRange = "";
		String prevLabCode = "", prevTestCode = "";
		String highLowVals[];
		try {

			ws = vo.getOfflineTestWS();
			
			sb.append("<table style=\"font-size: 15px;width: 100%; \" class=\"table-bordered\" id=\"product_info_table\">");
			sb.append("<thead>");
			sb.append("<tr id='tableHeaderId'>");
			sb.append("<th style=\"width:5%;text-align: center;\">#</th>");
			sb.append("<th style=\"width:25%;\">Test Name</th>");
			sb.append("<th style=\"width:30%;\">Parameter Name</th>");
			sb.append("<th style=\"width:25%;text-align: center;\">Result</th>");
			sb.append("<th style=\"width:35%;text-align: center;\">Ref. Range</th>");
		//	sb.append("<th style='border: solid 1px black'  colspan='1' width='4%'>Sl. No.</th> ");
			sb.append("</thead>");
			sb.append("</tr>");
			sb.append("<tbody>");
			if (ws != null && ws.size() > 0) {
				
                      
				/**
				 * 1.lab code 2.lab name 3.test code 4.test name 5.gnum_parameter_code 6.parameter name
				 * 7.Ref_Range 8.Multiple Param Flag 9.Criteria_code >> (10) Normal (11) AGE WISE (12) GENDER WISE  10.Element_type >>(E) Check Range. (D) Combo(Not to Check).
				 * REF RANGE >> hgstr_high_value^hgstr_low_value^hgstr_low_value_uom^hgstr_high_value_uom^
				 * 				Gender code^hgnum_low_age^hgnum_high_age^age_unit#low_Range^High_Range^^hgstr_low_value_uom^hgstr_high_value_uom^hgnum_low_age^hgnum_high_age^ 
				 * E.G. >> 700^1^IU/L^IU/L^0^0.0000^12.0000^1#130^20^IU/L^IU/L^0^13.0000^55.0000^1
				 */
				while (ws.next()) {
					
					
					if (ws.getString(10).equals("1") && !prevTestCode.equals(ws.getString(3))) {
						sb.append("<tr style=\"background-color: #5498be;cursor: pointer;\" onclick='showTest("
												+ ws.getString(3) + ");'>");  //#008d4c  //93c3de //68b9e7
						sb.append("<input type='hidden' id='strTrToggle" + ws.getString(3) + "'  value='0'>");
							sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td colspan=\"5\" style=\"text-align:left ;padding: 4px 0 4px 10px;color:#fff;\">"
								+ ws.getString(4) + "<div align='center' style=\"float: left;\" id='strDivImg"
								+ ws.getString(3)
								+ "'><img src='/HISInvestigationG5/hisglobal/images/arrow-down.png' width='16'></div></td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("</tr>");
						indTestFlag = 1;
					} else {
						if (ws.getString(10).equals("0") && indTestFlag == 1) {
							sb.append("<tr style='background-color:#8a8ab8;font-weight: bold;font-size: 13px;' title='Individual Test'>"); //#2C4294
							sb.append("<input type='hidden' id='strTrToggle" + ws.getString(3) + "'  value='0'>");
							sb.append("<td style=\"display: none;\">&nbsp;</td>");
							sb.append(
									"<td colspan=\"5\" style=\"text-align:'center';padding: 4px 0 4px 10px;color:#fff;\">Individual Test(s)</td>");
							sb.append("<td style=\"display: none;\">&nbsp;</td>");
							sb.append("<td style=\"display: none;\">&nbsp;</td>");
							sb.append("<td style=\"display: none;\">&nbsp;</td>");
							sb.append("</tr>");
							indTestFlag = 0;
						}
					}

					strHiddenVal = ws.getString(1) + "^" + ws.getString(3) + "^" + ws.getString(5);
					highLowVals=ws.getString(7).split("\\^");   //Get the high and Low ranges be available at jsp.

					if (ws.getString(10).equals("1"))
						sb.append("<tr id='tr" + ws.getString(3) + "' style=\"display: none;\">");
					else
						sb.append("<tr id='tr" + ws.getString(3) + "'>");
					sb.append("<input type='hidden' name='strHiddenValue' id='strHiddenValue" + j + "'  value='0'>");
					sb.append("<input type='hidden' name='strTestVal' id='strTestVal" + j + "'  value='" + strHiddenVal
							+ "'>");
					sb.append("<input type='hidden' name='strTestLowValue' id='strTestLowValueId" + j + "'  value='"+highLowVals[1]+"'>");
					sb.append("<input type='hidden' name='strTestHighValue' id='strTestHighValueId" + j + "'  value='"+highLowVals[0]+"'>");
					//FOR ELEMENT TYPE "E"
					if(ws.getString(10).equalsIgnoreCase("E")) {
						
						 if(ws.getString(9).equalsIgnoreCase("10")) {
						
						strRefRange = ws.getString(7).split("\\^")[1] + " " + ws.getString(7).split("\\^")[2] + " - "
								+ ws.getString(7).split("\\^")[0] + " " + ws.getString(7).split("\\^")[3];
						
						} 
						
						if (ws.getString(9).equalsIgnoreCase("11"))  //AGE-WISE COMPARISON
						{ 
							String refValue[] = ws.getString(7).split("#");
							if(refValue.length>1) {                /// nandini
							strRefRange = Math.round(Float.valueOf(refValue[1].split("\\^")[5]))+"-"+Math.round(Float.valueOf(refValue[1].split("\\^")[6]))+" ";
							
								if(refValue[1].split("\\^")[7].equalsIgnoreCase("1"))
									strRefRange= strRefRange + "Yrs: ";
								else if(refValue[1].split("\\^")[7].equalsIgnoreCase("2"))
									strRefRange= strRefRange + "Months: ";
								else
									strRefRange= strRefRange + "Days: ";
							strRefRange= strRefRange+refValue[1].split("\\^")[2]+"-"+refValue[1].split("\\^")[0]+" "+refValue[1].split("\\^")[2];
							
							strRefRange= strRefRange+"; "+Math.round(Float.valueOf(refValue[0].split("\\^")[5]))+"-"+Math.round(Float.valueOf(refValue[0].split("\\^")[6]))+" ";
							
							if(refValue[0].split("\\^")[7].equalsIgnoreCase("1"))
								strRefRange= strRefRange + "Yrs: ";
							else if(refValue[0].split("\\^")[7].equalsIgnoreCase("2"))
								strRefRange= strRefRange + "Months: ";
							else
								strRefRange= strRefRange + "Days: ";
							
							strRefRange= strRefRange+refValue[0].split("\\^")[1]+"-"+refValue[0].split("\\^")[0]+" "+refValue[0].split("\\^")[2];
							System.out.println("HLP  >> REF _ RANGE STRING at E 11 = "+strRefRange);
						}
						}
						else if (ws.getString(9).equalsIgnoreCase("12"))  //GENDER-WISE COMPARISON
						{ 
							String ref_range_result = ws.getString(7); 
							if(ref_range_result.contains("#")) {
							String refValue[] = ref_range_result.split("#");
							if(refValue.length>0) {
							strRefRange = "M: "+refValue[0].split("\\^")[1] + " - "	+ refValue[0].split("\\^")[0] + " " + refValue[0].split("\\^")[3]+ "; F: " 
									+refValue[1].split("\\^")[1] + " - "	+ refValue[1].split("\\^")[0] + " " + refValue[1].split("\\^")[3];
							}
							else if(ref_range_result.contains("M")) {
								refValue = ref_range_result.split("M");
								strRefRange = "M: "+refValue[0].split("\\^")[1] + " " + refValue[0].split("\\^")[2] +" " + refValue[0].split("\\^")[3];
							}
							else if(ref_range_result.contains("F")) {
								refValue = ref_range_result.split("F");
								strRefRange = "F: "+refValue[0].split("\\^")[1] + " " + refValue[0].split("\\^")[2] +" " + refValue[0].split("\\^")[3];
							}
						}	
							else 
								strRefRange = ws.getString(7).split("\\^")[1] + " " + ws.getString(7).split("\\^")[2] + " - "
									+ ws.getString(7).split("\\^")[0] + " " + ws.getString(7).split("\\^")[3];
								
					  } //System.out.println("HLP  >> REF _ RANGE STRING at E 12 = "+strRefRange);
					} 
					//For ELEMENT TYPE "D"  
					else if(ws.getString(10).equalsIgnoreCase("D")){
						
						//For ELEMENT TYPE "D"  or ("E" and "10")
						strRefRange = ws.getString(7).split("\\^")[1] + " " + ws.getString(7).split("\\^")[2] + " - "
								+ ws.getString(7).split("\\^")[0] + " " + ws.getString(7).split("\\^")[3];
					}
					
					
					if (prevTestCode == "" || !prevTestCode.equals(ws.getString(3))) {
						sb.append("<td style=\"text-align: center;\"><input type='checkbox' name='srrChk' value='"
								+ strHiddenVal + "' onclick='enableFields(this," + j + "," + ws.getString(3)
								+ ");'></td>");  
				
					//	 sb.append("<td style=\"text-align: center;\"><input type='hidden' id='labcodeno' name='labcodeno' value="+ws.getString(1)+"></td>");
						sb.append("<td style=\"text-align: left;\">" + ws.getString(4) + "</td>");
					} else {
						sb.append("<td style=\"text-align: center;\">&nbsp;</td>");
						sb.append("<td style=\"text-align: left;\">&nbsp;</td>");
					}

					sb.append("<td style=\"text-align: left;\">" + ws.getString(6) + "</td>");
					sb.append("<td style=\"text-align: center;\"><input type='text' id = 'strTestResultId" + j + "#"
							+ ws.getString(3) + "' name='strTestResult' disabled onblur='showDetailsText(this," + j
							+ ");' onkeyup = 'validateRangeVal(this,"+j+");' autocomplete= 'on'></td>"); // "$"+ws.getString(3)+
					sb.append("<td style=\"text-align: center;\">" + strRefRange + "</td>");
					sb.append("<input type='hidden' name='strRefRangeVal' id='strRefRangeValId" + j + "' value='"
							+ strRefRange + "' >");
					//sb.append("<td style=\"text-align: center;\"><input type='hidden' id='labcodeno' name='labcodeno' value="+ws.getString(1)+"></td>");
						
					j++;
					sb.append("</tr>");
					prevTestCode = ws.getString(3);
					prevLabCode = ws.getString(1);

				}

			}

			sb.append("</tbody></table>");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return sb.toString();
	}

	// Function to generate the Result Entry Slip by Deepti 20.01.2021
//	public static String printslip(InvOfflineResultEntryVO vo) {
//
//		StringBuffer sb = new StringBuffer("");
//		WebRowSet ws = null;
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date = new Date();
//		String prevTestCode = "";
//		try {
//
//			// vo.getStrPatientDtlWS().beforeFirst();
//			ws = vo.getStrPatientDtlWS();
//			String patAge= "",patAgeUnit="", patGender="";
//			ws.beforeFirst();
//			
//			sb.append("<html><head><style>");
//			sb.append("html,\r\n" + 
//					"body {\r\n" + 
//					"  height: 100%;\r\n" + 
//					"  margin: 0;\r\n" + 
//					"  padding: 0;\r\n" + 
//					"}\r\n" + 
//					"\r\n" + 
//					"body {\r\n" + 
//					"  \r\n" + 
//					"  padding-bottom: 100px;\r\n" + 
//					"}\r\n" + 
//					"\r\n" + 
//					".footer {\r\n" + 
//					"  position: fixed;\r\n" + 
//					"  bottom: 0;\r\n" + 
//					"  width: 100%;\r\n" + 
//					"  text-align: center;\r\n" + 
//					"}");
//			sb.append("</style></head><body>");
//			while (ws.next()) {
//				sb.append("<div id='printableArea'> ");
//				sb.append("<div valign='top'>");
//				
//				String hosp_name_add[]=ws.getString(8).split("\\#");
//				
//				sb.append("<div>");
//				sb.append("<center><h2>" + hosp_name_add[0] + "</h2></center>");
//				sb.append("</div>");
//				
//				sb.append("<div><center><table style= 'width:100%;'>");
//				
//				for(int i= 1; i<hosp_name_add.length;i++) {
//					if(!(hosp_name_add[i].equals(""))|| !(hosp_name_add[i]=="") || !(hosp_name_add[i]==null)) {
//						sb.append("<tr><td style= 'align:center;font-size: 12px;'>");
//						sb.append(hosp_name_add[i]);
//						sb.append("</td></tr>");
//					}
//				}
//				sb.append("</table></center></div>");
//				
//				sb.append("<div align='right'>");
//				sb.append("<label>Print Date-Time:" + dateFormat.format(date) + "</label>");
//				sb.append("<br></br><br></br><br></br>");
//				sb.append("</div>");
//
//				sb.append("</div>");
//
//				// Printing the Patient's Details.
//				sb.append("<div style='border: 1px solid black; border-radius: 25px; padding: 15px;'>");
//				sb.append("<table width='100%' style='font-size: 12px;'> ");
//				sb.append("<tr>");
//				sb.append("<td width= '23%'><label><b>Reg. Number: </b></label></td><td width= '23%'><b>" + vo.getPatCRNo()
//						+ "</b></td>");
//				sb.append("<td width= '25%'><label><b>Collection Centre: </b></label></td><td width= '25%'>"
//						+ ws.getString(7) + "</td>");
//
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'><label><b>Patient Name: </b></label></td><td width= '23%'>"+ WordUtils.capitalizeFully(ws.getString(1)) + "</td>");
//				sb.append("<td width= '25%'><label><b>Sample Collection Date: </b></label></td><td width= '25%'><b>"
//						+ ws.getString(9) + "</b></td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'><label><b>Age / Sex: </b></label></td><td width= '23%'>" + ws.getString(3)
//						+ " " + ws.getString(4) + " / " + ws.getString(2) + "</td>");
//				sb.append("<td width= '25%'><label><b>Result Entry Date: </b></label></td><td width= '25%'><b>"
//						+ ws.getString(10) + "</b></td>");
//				sb.append("</tr>");
//				
//				sb.append("<tr>");
//				sb.append("<td width= '23%'><label><b>Address: </b></label></td><td width= '23%'>" + WordUtils.capitalizeFully(ws.getString(5))
//						+ "</td>");
//				sb.append("<td width= '25%'><label><b>Mobile No.: </b></label></td><td width= '25%'>" + ws.getString(6)
//						+ "</td>");
//				sb.append("</tr>");
//
//				sb.append("</table></div><br></br>");
//				
//				patAge=ws.getString(3);
//				patAgeUnit=ws.getString(4);
//				patGender=ws.getString(2);
//			}
//
//			// Printing the Tests' Details.
//			// vo.getStrPatientTestListWS().beforeFirst();
//			ws = vo.getStrPatientTestListWS();
//			int slno = 1;
//			sb.append("<div style='border: 1px solid black'>");
//			sb.append("<table  id='viewTableListing' border = '1' style='width:100%; border-collapse: collapse;'> ");
//			sb.append("<thead> <tr style= 'border: 1px solid black;'> " + " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 5%;'> S.No</th> "
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 30%;'> Test Name </th>" 
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 27%;'> Parameter Name </th>"
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 13%;'> Result</th>  " 
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 25%;'> Reference Range</th>" + "</tr> </thead>");
//
//			sb.append("<tbody><tr></tr><tr></tr><tr></tr>");
//
//			while (ws.next()) {
//				sb.append("<tr style= 'border: 1px solid black;'>");
//				if(!prevTestCode.equals(ws.getString(9))) {
//					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + slno++ + " </td> ");
//					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(1) + " </td> ");
//				}
//				else {
//					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> ");
//					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> ");
//					
//				}
//				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(5) + " </td> ");
//
//				// Logic to get the Out of Range values printed in the Bold.
//				
//				if (!(ws.getString(6).equals("-")) && !(ws.getString(6).matches("[a-zA-Z]+"))) {
//					
//					float lowVal=0,highVal=0;
//					String rangeVal[] = ws.getString(6).replace("^", "#").split("#");
//					
//						if((!rangeVal[1].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[1].charAt(0))))
//					 lowVal = Float.parseFloat(rangeVal[1]);
//						if((!rangeVal[0].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[0].charAt(0))))
//					 highVal = Float.parseFloat(rangeVal[0]);
//					
//					if (ws.getString(3).matches("[0-9.]+") && (((Float.parseFloat(ws.getString(3)) < lowVal))
//							|| (Float.parseFloat(ws.getString(3)) > highVal))) { 
//						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> <b>" + ws.getString(3) + " </b></td> ");
//					} else if(!ws.getString(3).matches("[0-9.]+") || ws.getString(3).matches("[a-zA-Z]+")){
//						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
//					}
//					else { 
//						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
//					}
//				} else if(ws.getString(6).equals("-")){
//					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
//				}
//				
//				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(2) + " </td> ");
//				sb.append("</tr>");
//				prevTestCode=ws.getString(9);
//			}
//			sb.append("</tbody></table></div>");
//			sb.append("<br></br><br></br><br></br><br></br>");
//			
//			sb.append("<div style='float:right'><img src='"+vo.getStrUserSign()+"' width='150px' height='68px'/><p><b> Signature of the Pathologist</b></p></div>");
//			//sb.append("<div class='footer' style='padding-top: 10px; border-top: 1px solid #ddd; font-size:13px; color: #333; margin-top: 20px; text-align: center;'>This is Computer-generated Test Report. Signature not required.</div>");
//			sb.append("<div style= 'position: fixed; bottom: 10px; width: 100%; border-top: 1px solid #ddd; font-size:11px; color: #333;'>Test results relate only to item received. All reports need clinical correlation. Kindly discuss if necessary. No part of the report can be reproduced without written permission of the laboratory.<br></br><b>this is computer generated report. Signature not required.</b></div>");
//			sb.append("</div>");
//			sb.append("</body></html>");
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//
//	// Function to List the Result Entries of the day by Deepti 21.01.2021
//
//	public static String viewResultEntriesListForReportView(InvOfflineResultEntryVO vo) {
//
//		StringBuffer sb = new StringBuffer("");
//		WebRowSet ws = null;
//		try {
//
//			vo.getStrResultEntryListWS().beforeFirst();
//			ws = vo.getStrResultEntryListWS();
//			int slno = 1;
//
//			sb.append("<div class='row'>");
//			sb.append("<div class='col-md-12 col-xs-12'>");
//			sb.append("<div class='box box-solid box-primary'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries</h3>");
//			
//			sb.append("</div></div></div>");
//
//			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
//
//			sb.append(
//					"<label class = 'col-sm-2 control-label'><font color='red'>*</font>From Date (Sample Collection) : </label>");
//			sb.append(
//					"<div class='col-sm-1'><input style= 'width:110px;' type = 'text' name = 'strFromDate' id= 'strFromDateId' placeholader = 'Sample Collection Date FROM'/>");
//			sb.append("</div>");
//
//			sb.append(
//					"<label class = 'col-sm-2 control-label'><font color='red'>*</font>To Date (Sample Collection) : </label>");
//			sb.append(
//					"<div class='col-sm-1'><input style= 'width:110px;' type = 'text' name = 'strToDate' id= 'strToDateId' placeholader = 'Sample Collection Date TO'/>");
//			sb.append("</div>");
//
//			// sb.append("<div class='col-sm-1'><label class = 'control-label col-sm-1'>OR</label></div>");
//			/*
//			 * sb.append("<div class='col-sm-1'>"); //sb.
//			 * append("<button type='submit' id = 'getEntryListBtnId' class='btn btn-success' onclick = 'getResultEntryList();'>Get List</button>"
//			 * ); sb.
//			 * append("<a href='#' id='getEntryListBtnId' class='btn btn-success' onclick='getResultEntryList();'><span>Get List</span></a> "
//			 * ); sb.append("</div>");
//			 */
//
//			sb.append("<label class='col-sm-1 control-label' style = 'width:10%'>&nbsp; OR &nbsp;&nbsp;&nbsp;<font color='red'>*</font>Reg. No.:</label>");
//			sb.append("<div class='col-sm-2' style='width:11%'>");
//			sb.append("<input type='text' class='form-control' style = 'height: 25px;'id='patCRNoId' name='patCRNo' placeholder='Reg. No.' autocomplete='on' minlength = '10' maxlength = '10'>");
//			sb.append("</div>");
//
//			sb.append("<label class='col-sm-1 control-label' style='text-align:left;width:10%'>&nbsp; OR &nbsp;&nbsp;<font color='red'>*</font>Mobile No.:</label>");
//			sb.append("<div class='col-sm-1'style='width:10%'>");
//			sb.append("<input type='text' class='form-control' style = 'height: 25px;' id='patMobNoId' name='patMobNo' placeholder='Mobile No.' autocomplete='on' minlength = '10' maxlength = '10'>");
//			sb.append("</div>");
//			
//			sb.append("<div class='col-sm-1'>");
//			// sb.append("<button type='submit' id = 'getPatDtlsId' class='btn btn-success'onclick = 'getPatientDetails();'>Get Detail</button>");  
//			sb.append("<a href='#' id='getPatDtlsId' class='btn btn-success' style='padding:1px 6px;' onclick='getDetails();' data-toggle='modal'><span>Go</span></a> ");
//			sb.append("</div><br/>");
//
//			sb.append("</div>");
//
//			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
//			sb.append("</div></div>");
//			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
//					+ "<h3 class='box-title' style='font-size: 15px;'>From Date "+vo.getStrFromDate()+"&nbsp;-&nbsp;To Date&nbsp;"+vo.getStrToDate()+"</h3>");
//			sb.append("</div></div>");
//			sb.append("<div class='table-responsive'>");
//			sb.append("<table class='table-bordered' id= 'TablePatTestList' style= 'width:100%'><thead>");
//			sb.append("<tr>");
//			sb.append("<th scope='col' width = '5%'>#</th>");
//			//sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
//			sb.append("<th scope='col' width = '15%'> Patient Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
//			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab Report</th></thead>");
//			sb.append("<tbody>");
//
//			if (ws != null && ws.size() > 0) {
//				while (ws.next()) {
//					sb.append("<tr>");
//					sb.append("<td>" + slno++ + "</td>");
//					//sb.append("<td>" + ws.getString(8) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
//					sb.append("<td>" + ws.getString(2) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(6) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
//					sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)+"\");'><span>View</span></a></td>");
//					// sb.append("<td><button type='submit' class='btn btn-success' onclick =
//					// 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>"); //<span class='glyphicon glyphicon-download-alt'></span>
//				}
//			}
//			/*
//			 * else // Commented as Data Table is applied. 
//			 * { sb.append("<tr>");
//			 * sb.append("<td>No result Entries to show</td></tr>"); }
//			 */
//			sb.append("</tbody><table></div>");
//			sb.append("</div>");
//			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
//			sb.append("</span></div>");
//			sb.append("<div class = 'col-sm-12' style='text-align:center;margin-top:1%;'>");
//			// sb.append("<a href='#' id='cancelBtnId' class='btn btn-success' onclick = 'cancelFunc();'><span>Cancel</span></a> ");
//			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Reset</button>");
//			sb.append("</div>");
//			sb.append("</div>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//
////Function to Display the Patient's Details on click of Get Details by Deepti 21.01.2021
//	public static String getPatOfflineResDtl(InvOfflineResultEntryVO vo) {
//
//		StringBuffer sb = new StringBuffer("");
//		String prevTestCode = "";
//		try {
//
//			WebRowSet ws1 = null;
//
//			sb.append("<div class='row'>");
//			sb.append("<div class='col-md-12 col-xs-12'>");
//			sb.append("<div class='box box-solid box-primary' style= 'margin-top:2px;'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries -> Patient Detail</h3>");
//			sb.append("</div></div>");
//
//			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
//			/* sb.append("<label for='po_no' class='col-sm-2 control-label'><font color='red'>*</font>CR No. :</label>");
//			sb.append("<div class='col-sm-2' float='left'>");
//			sb.append("<input type='text' class='form-control' id='patCRNoId' name='patCRNo' autocomplete='on' value= '"+ vo.getPatCRNo() + "' />");
//			sb.append("</div>");
//
//			
//			 * sb.append("<div class='col-sm-4' float='center'>"); sb.
//			 * append("<button type='submit' class='btn btn-success' onclick = 'getPatientDetails();' disabled>Go</button>"
//			 * ); sb.append("</div></div>");
//			 */
//
//			/*sb.append("<div class='col-md-12 col-xs-12 box box-solid box-primary'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
//					+ "<h3 class='box-title' style='font-size: 15px;'>Patient Details: </h3>");
//			sb.append("</div></div>"); */
//			sb.append("<div class='rounded border table-responsive' style = 'border: 1px solid black; border-radius: 10px;padding: 5px;'>");
//			//sb.append("<div class='table-responsive'>");
//			sb.append("<table id = 'patDtlTable' width='100%' class='table table-sm table-bordered'> ");
//
//			// Section to get General details.
//
//			ws1 = vo.getStrPatientDtlWS();
//
//			while (ws1.next()) {
//
//				
//				sb.append("<tr>");
//				
//				if(vo.getPatCRNo().equals("")) {
//					sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + ws1.getString(12)+ "</label></td>");
//					}
//				else
//				sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + vo.getPatCRNo()+ "</label></td>");
//				
//				sb.append("<td width= '25%'>Collection Centre: </td><td width= '25%'>" + ws1.getString(7) + "</td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'>Patient Name: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(1)) + "</td>");
//				sb.append("<td width= '25%'><label>Sample Collection Date: </label></td><td width= '25%'><label>"+ ws1.getString(9) + "</label></td>");
//				// sb.append("<td><label>Sex:</label><span>"+ws.getString(2)+"</span></td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'>Age / Sex: </td><td width= '23%'>" + ws1.getString(3) + " "
//						+ ws1.getString(4) + " / " + ws1.getString(2) + "</td>");
//				sb.append("<td width= '25%'><label>Result Entry Date: </label></td><td width= '25%'><label>"
//						+ ws1.getString(10) + "</label></td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'>Address: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(5)) + "</td>");
//				sb.append("<td width= '25%'>Mobile No.: </td><td width= '25%'>" + ws1.getString(6) + "</td>");
//				sb.append("</tr>");
//			}
//			sb.append("</table></div>");
//			sb.append(
//					"<hr style='color: #000;border: 0px;height: 12px;box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'/>");
//
//			vo.getStrPatientTestListWS().beforeFirst();
//			ws1 = vo.getStrPatientTestListWS();
//			int slno = 1;
//
//			sb.append("<table  id = 'patTestListTable' class = 'border' id='viewTableResultListing' width='100%'> ");
//			/* sb.append("<thead> <tr> " + " <th width= '5%'> # </th> " + " <th width= '28%'> Test Name </th>"
//					+ " <th width= '27%'> Parameter Name </th>" + " <th width= '20%'> Ref. Range</th>  "
//					+ " <th width= '20%'> Result</th>" + "</tr> </thead>");
//			*/
//			
//			sb.append("<thead> <tr style= 'border: 1px solid black;'> " + " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 5%;'> S.No</th> "
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 40%;'> Test Name </th>" 
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Result </th>"
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Unit</th>  " 
//					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 25%;'> Reference Range</th>" + "</tr> </thead>");
//			
//			sb.append("<tbody><tr></tr><tr></tr><tr></tr>");
//			while (ws1.next()) {
//				sb.append("<tbody><tr>");				
//				if(!prevTestCode.equals(ws1.getString(9))) {
//					sb.append("<tr>"); // style= 'border: 1px solid black;'
//					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + slno++ + " </td> ");
//					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'><b> " + ws1.getString(1) + "</b> </td> ");
//					sb.append("</tr>");
//					sb.append("<tr>");
//					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
//					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(5) + " </td> ");
//					}
//					else {
//						sb.append("<tr>");
//						sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
//						sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(5) + " </td> ");
//					}
//				//sb.append(" <td align= 'left'> " + slno++ + " </td> ");
//				//sb.append(" <td align= 'left'> " + ws1.getString(1) + " </td> ");
//				//sb.append(" <td  align= 'left'> " + ws1.getString(5) + " </td> ");
//				//sb.append(" <td align= 'left'> " + ws1.getString(2) + " </td> ");
//
//				// Logic to get the Out of Range values printed in the Bold.
//				if (!ws1.getString(6).equals("-")) {
//					float lowVal=0,highVal=0;
//					String rangeVal[] = ws1.getString(6).replace("^", "#").split("#");
//					
//					if((!(rangeVal[1].equals("-"))  && (Character.isDigit(rangeVal[1].charAt(0)))))
//						 lowVal = Float.parseFloat(rangeVal[1]);
//					if((!(rangeVal[0].equals("-")) && (Character.isDigit(rangeVal[1].charAt(0)))))
//						 highVal = Float.parseFloat(rangeVal[0]);
//
//					if (ws1.getString(3).matches("[0-9]+") && (((Float.parseFloat(ws1.getString(3)) < lowVal))
//							|| (Float.parseFloat(ws1.getString(3)) > highVal))) {
//						sb.append(" <td align= 'left'> <b>" + ws1.getString(3) + " </b></td> ");
//					} else {
//						sb.append(" <td align= 'left'> " + ws1.getString(3) + " </td> ");
//					}
//				} else {
//					sb.append(" <td align= 'left'> " + ws1.getString(3) + " </td> ");
//				}
//				
//				sb.append("<td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'>" + ws1.getString(11) + "</td>");
//				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(6).replace('^', '-') + " </td> "); 
//				sb.append("</tr>");
//				prevTestCode=ws1.getString(9);
//			}
//			sb.append("</tbody></table><br/>");
//			sb.append("<div style='float:center;margin-left: 42%;'>");
//			ws1.beforeFirst();
//			int iteration = 1;
//			while (ws1.next() && iteration++ == 1) {
//				sb.append("<a href='#' class = 'btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws1.getString(4)
//						+ "\");'>View Slip</a>");
//				sb.append(
//						"&nbsp;&nbsp;&nbsp;<a href='#' class = 'btn btn-warning' onclick = 'cancelFunc();'>Cancel</a>");
//				// sb.append("<button type='submit' class='btn btn-success' onclick =
//				// 'view_Print_Slip(this,"+ws1.getString(4)+");'>View/Print</button></div><script>showHideDiv();</script>");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//
//	public static String viewResultEntriesList(InvOfflineResultEntryVO vo) {
//
//		StringBuffer sb = new StringBuffer("");
//		WebRowSet ws = null;
//		try {
//
//			vo.getStrResultEntryListWS().beforeFirst();
//			ws = vo.getStrResultEntryListWS();
//			int slno = 1;
//			
//			String strHospitalList = ""; 
//			HisUtil hisutil = new HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
//			if (vo.getStrMsgType().equals("1")) 
//			{ 
//				throw new Exception(vo.getStrMsgString()); 
//			} 
//			
//			vo.getStrHospitalListWS().beforeFirst();
//			
//			if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() >1) 
//			{ //If the logged-in Hospital has sub-hospitals
//			 
//				strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"","0^All", false); 
//			}
//			 
//			else if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() == 1 ) 
//			{ //If the logged-in Hospital has no sub-hospitals
//			
//			vo.getStrHospitalListWS().beforeFirst(); 
//			strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"", "", false);
//			}
//			
//			else 
//			{ 
//				strHospitalList = "<option value='0'>Select Value</option>";
//			}
//			
//			
//			sb.append("<div class='row'>");
//			sb.append("<div class='col-md-12 col-xs-12'>");
//			sb.append("<div class='box box-solid box-primary'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries View</h3>");
//			sb.append("</div></div>");
//			sb.append("</div>");
//
//			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
//
//			sb.append("<label class = 'col-sm-2 control-label'style = 'width:190px;'><font color='red'>*</font>From Date (Result Entry) : </label>");
//			sb.append("<div class='col-sm-2' style='width:11%;'><input type = 'text' name = 'strFromDate' id= 'strFromDateId' style = 'width:120px;'/>");
//			sb.append("</div>");
//
//			sb.append("<label class = 'col-sm-2 control-label' style='width:190px;'><font color='red'>*</font>To Date (Result Entry) : </label>");
//			sb.append("<div class='col-sm-2' style='width:11%;'><input type = 'text' name = 'strToDate' id= 'strToDateId' style = 'width:120px;'/>");
//			sb.append("</div>");
//			
//			sb.append("<label class = 'col-sm-1 control-label'>Hospital : </label>");
//			sb.append("<div class='col-sm-2'><select name='strPatHospCode' id='strPatHospCodeId' class=form-control select_group product style= 'height: 26px;font-size: 12px;'>");
//			
//			sb.append(strHospitalList); 
//			sb.append("</select></div>");//sb.append("</div>");
//			
//			sb.append("<div class='col-sm-1'>");
//			//sb.append("<input type='button' class='btn btn-success' onclick = 'getEntryList();'>Go");
//			sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-success' onclick='getEntryList();'><span>Go</span></a> ");
//			//sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-warning' onclick='resetListFields();'><span>Reset</span></a> ");
//			sb.append("</div><br/>");
//
//			sb.append("</div>");
//
//			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
//			sb.append("</div></div>");
//
//			sb.append("<div class='table-responsive'>");
//			sb.append("<table id = 'resultEntriesListTable' class='table-bordered'><thead>");
//			sb.append("<tr>");
//			sb.append("<th scope='col' width = '5%'>#</th>");
//			sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
//			sb.append("<th scope='col' width = '15%'>Patient Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
//			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab Report</th></thead>");
//			sb.append("<tbody>");
//
//			if (ws != null && ws.size() > 0) {
//				while (ws.next()) {
//					sb.append("<tr>");
//					sb.append("<td>" + slno++ + "</td>");
//					sb.append("<td>" + ws.getString(8) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
//					sb.append("<td>" + ws.getString(2) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(6) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
//					//System.out.println("GDT_ENTRY_DT HLP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> = "+ws.getString(11));
//					sb.append("<td align='center'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)
//							+ "\");'><span>View</span></a> ");//  <a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' onclick = 'modifyRecord(this,\""+ws.getString(1)+"\",\""+ws.getString(4)+"\",\""+ws.getString(9)+"\",\""+ws.getString(10)+"\",\""+ws.getString(11)+"\")'><span>Edit</span></a></td>"); //class='glyphicon glyphicon-download-alt'
//					// sb.append("<td><button type='submit' class='btn btn-success' onclick = 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>");
//				}
//			}
//			/*
//			 * else { sb.append("<tr>");
//			 * sb.append("<td>No result Entries to show</td></tr>"); }
//			 */
//			sb.append("</tbody><table></div></div>");
//			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
//			sb.append("</span></div>");
//			sb.append("<div class = 'col-sm-12' style='text-align:center'>");
//			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Cancel</button>");
//			sb.append("</div>");
//			sb.append("</div>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//
//	public static String getRegisteredPatientDtl(InvOfflineResultEntryVO vo) {
//
//		StringBuffer sb = new StringBuffer("");
//
//		try {
//
//			WebRowSet ws1 = null;
//			sb.append("<div class='table-responsive'>");
//			sb.append("<table id = 'regPatDtlTable' style= 'width:100%; font-size: 12px;' class='table table-sm table-borderless'> ");
//
//			// Section to get General details.
//
//			ws1 = vo.getStrPatientDtlWS();
//			while (ws1.next()) {
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + vo.getPatCRNo()+ "</label></td>");
//				sb.append("<td width= '25%'>Mobile No.: </td><td width= '25%'>" + ws1.getString(6) + "</td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '25%'>Patient Name: </td><td width= '25%'>" + WordUtils.capitalizeFully(ws1.getString(1)) + "</td>");
//				sb.append("<td width= '23%'>Age / Sex: </td><td width= '23%'>" + ws1.getString(3) + " "
//						+ ws1.getString(4) + " / " + ws1.getString(2) + "</td>");
//				sb.append("</tr>");
//
//				sb.append("<tr>");
//				sb.append("<td width= '23%'>Father/Spouse Name: </td><td width= '23%'>" + ws1.getString(11) + "</td>");
//				sb.append("<td width= '23%'>Address: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(5)) + "</td>");
//				sb.append("</tr>");
//
//			}
//			sb.append("</table></div>");
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//
//	}
//
//	public static String viewResultEntries_onHospChange(InvOfflineResultEntryVO vo) {
//		StringBuffer sb = new StringBuffer("");
//		WebRowSet ws = null;
//		try {
//
//			vo.getStrResultEntryListWS().beforeFirst();
//			ws = vo.getStrResultEntryListWS();
//			int slno = 1;
//			
//			String strHospitalList = ""; 
//			HisUtil hisutil = new HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
//			if (vo.getStrMsgType().equals("1")) 
//			{ 
//				throw new Exception(vo.getStrMsgString()); 
//			} 
//			
//			WebRowSet hospWS = vo.getStrHospitalListWS();
//			String HospComboString = "";
//			while(hospWS.next())
//			{
//				if(vo.getHospitalcode().equalsIgnoreCase(hospWS.getString(1)))
//					HospComboString = hospWS.getString(1)+"^"+hospWS.getString(2)+"#0^All";	
//					
//			}
//			vo.getStrHospitalListWS().beforeFirst();
//			
//			if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() >1) 
//			{ //If the logged-in Hospital has sub-hospitals
//			 
//				strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"",HospComboString, false); 
//			}
//			 
//			else if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() == 1 ) 
//			{ //If the logged-in Hospital has no sub-hospitals
//			
//			vo.getStrHospitalListWS().beforeFirst(); strHospitalList =
//			hisutil.getOptionValue(vo.getStrHospitalListWS(),"", "", false);
//			}
//			
//			else 
//			{ 
//				strHospitalList = "<option value='0'>Select Value</option>";
//			}
//			
//			sb.append("<div class='row'>");
//			sb.append("<div class='col-md-12 col-xs-12'>");
//			sb.append("<div class='box box-solid box-primary'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries View</h3>");
//			sb.append("</div></div>");
//			sb.append("</div>");
//
//			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
//
//			sb.append("<label class = 'col-sm-2 control-label'><font color='red'>*</font>From Date (Result Entry) : </label>");
//			sb.append("<div class='col-sm-2'><input type = 'text' name = 'strFromDate' id= 'strFromDateId'/>");
//			sb.append("</div>");
//
//			sb.append("<label class = 'col-sm-2 control-label'><font color='red'>*</font>To Date (Result Entry) : </label>");
//			sb.append("<div class='col-sm-2'><input type = 'text' name = 'strToDate' id= 'strToDateId'/>");
//			sb.append("</div>");
//			
//			sb.append("<label class = 'col-sm-1 control-label'>Hospital : </label>");
//			sb.append("<div class='col-sm-2'><select name='strPatHospCode' id='strPatHospCodeId' class=form-control select_group product style= 'height: 27;font-size: 13px;'>");
//			sb.append(strHospitalList);
//			sb.append("</select></div>");
//			
//			sb.append("<div class='col-sm-1'>");
//			//sb.append("<input type='button' class='btn btn-success' onclick = 'getEntryList();'>Go");
//			sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-success' onclick='getEntryList();'><span>Go</span></a> ");
//			sb.append("</div><br/>");
//
//			sb.append("</div>");
//
//			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
//			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
//					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
//			sb.append("</div></div>");
//
//			sb.append("<div class='table-responsive'>");
//			sb.append("<table id = 'resultEntriesListTable' class='table-bordered'><thead>");
//			sb.append("<tr>");
//			sb.append("<th scope='col' width = '5%'>#</th>");
//			sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
//			sb.append("<th scope='col' width = '15%'>Name</th>");
//			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
//			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
//			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab Report</th></thead>");
//			sb.append("<tbody>");
//
//			if (ws != null && ws.size() > 0) {
//				while (ws.next()) {
//					sb.append("<tr>");
//					sb.append("<td>" + slno++ + "</td>");
//					sb.append("<td>" + ws.getString(8) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
//					sb.append("<td>" + ws.getString(2) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(6) + "</td>");
//					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
//					sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)
//							+ "\");'><span>View</span></a></td>"); //class='glyphicon glyphicon-download-alt'
//					// sb.append("<td><button type='submit' class='btn btn-success' onclick =
//					// 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>");
//				}
//			}
//			/*
//			 * else { sb.append("<tr>");
//			 * sb.append("<td>No result Entries to show</td></tr>"); }
//			 */
//			sb.append("</tbody><table></div></div>");
//			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
//			sb.append("</span></div>");
//			sb.append("<div class = 'col-sm-12' style='text-align:center'>");
//			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Cancel</button>");
//			sb.append("</div>");
//			sb.append("</div>");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return sb.toString();
//	}
//	
public static String printSlipTestWise(NEWOfflineResultEntryVO vo) {

	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	String prevTestCode = "";
	try {
		
		 final String cghs_logo = "data:image/png;base64,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";

		ws = vo.getStrPatientDtlWS();
		ws.beforeFirst();
		
		sb.append("<html><head><style>");
   	sb.append("html,\r\n" + 
				"body {\r\n" + 
				"  height: 80%;\r\n" + 
				"  margin: 0;\r\n" + 
				"  padding: 0;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"body {\r\n" + 
				"  \r\n" + 
		"  padding-bottom: 80px;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				".footer {\r\n" + 
				"  position: fixed;\r\n" + 
				"  bottom: 0;\r\n" + 
				"  width: 80%;\r\n" + 
				"  text-align: center;\r\n" + 
				"}");
		sb.append("</style></head><body>");
		while (ws.next()) {
			sb.append("<div id='printableArea'> ");
			sb.append("<div valign='top'>");
			
			sb.append("<div style='float:left'>");
			sb.append("<center><h2><img src='"+cghs_logo+"' style='height:120px;margin-bottom:10px;'/></h2></center>");
			sb.append("</div>");
			
			
			String hosp_name_add[]=ws.getString(8).split("\\#");
			
			sb.append("<div>");
			sb.append("<center><h2>" + hosp_name_add[0] + "</h2></center>");
			sb.append("</div>");
			
			sb.append("<div><center><table style= 'width:100%;'>");
			
			for(int i= 1; i<hosp_name_add.length;i++) {
				if(!(hosp_name_add[i].equals(""))|| !(hosp_name_add[i]=="") || !(hosp_name_add[i]==null)) {
					sb.append("<tr><td style= 'align:center;font-size: 12px;'>");
					sb.append(hosp_name_add[i]);
					sb.append("</td></tr>");
				}
			}
			sb.append("</table></center></div>");
			
			sb.append("<div align='right'>");
			sb.append("<label>" + dateFormat.format(date) + "</label>");
			sb.append("<br></br><br></br><br></br>");
			sb.append("</div>");

			sb.append("</div>");

			// Printing the Patient's Details.
			sb.append("<div style='border: 1px solid black; border-radius: 25px; padding: 15px;'>");
			sb.append("<table width='100%' style='font-size: 12px;'> ");
    		sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Registration No.: </b></label></td><td width= '23%'><b>" + vo.getPatCRNo()
					+ "</b></td>");
			sb.append("<td width= '23%'><label><b>Request No.: </b></label></td><td width= '23%'><b>" + vo.getRequisitionNo()
			        + "</b></td>");
			
			///nandini

			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width= '25%'><label><b>Collection Centre: </b></label></td><td width= '75%' colspan='3'>"
					+ ws.getString(7) + "</td>");

			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Patient Name: </b></label></td><td width= '23%'>"+ WordUtils.capitalizeFully(ws.getString(1)) + "</td>");
			sb.append("<td width= '25%'><label><b>Sample Collection Date: </b></label></td><td width= '25%'><b>"
					+ ws.getString(9) + "</b></td>");
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Age / Sex: </b></label></td><td width= '23%'>" + ws.getString(3)
					 + " / " + ws.getString(2) + "</td>");
			sb.append("<td width= '25%'><label><b>Result Entry Date: </b></label></td><td width= '25%'><b>"
					+ ws.getString(10) + "</b></td>");
			sb.append("</tr>");
			
			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Address: </b></label></td><td width= '23%'>" + WordUtils.capitalizeFully(ws.getString(5))
					+ "</td>");
			sb.append("<td width= '25%'><label><b>Mobile No.: </b></label></td><td width= '25%'>" + ws.getString(6)
					+ "</td>");
			sb.append("</tr>");

			sb.append("</table></div><br></br>");
			
		}

		// Printing the Tests' Details.
		
		ws = vo.getStrPatientTestListWS();
		int slno = 1;
		sb.append("<div style='border: 1px solid black'>");
		sb.append("<table  id='viewTableListing' border = '1' style='width:100%; border-collapse: collapse;'> ");
		sb.append("<thead> <tr style= 'border: 1px solid black;'> " + " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 5%;'> S.No</th> "
				+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 40%;'> Test Name </th>" 
				+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Result </th>"
				+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Unit</th>  " 
				+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 25%;'> Reference Range</th>" + "</tr> </thead>");
		

		sb.append("<tbody><tr></tr><tr></tr><tr></tr>");
		System.out.println("vo.getStrPatientTestListWS()>>>"+vo.getStrPatientTestListWS());
       ws.beforeFirst();
		while (ws.next()) {
			//10114
				if(!prevTestCode.equals(ws.getString(9))) {
				sb.append("<tr style= 'border: 1px solid black;'>");
				sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + slno++ + " </td> ");
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'><b> " + ws.getString(1) + "</b> </td> ");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(5) + " </td> ");
				}
				else {
					sb.append("<tr>");
  				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(5) + " </td> ");
				}
			// Logic to get the Out of Range values printed in the Bold.
			
			if (!ws.getString(6).equals("-")) {
				
				float lowVal=0,highVal=0;
				String rangeVal[] = ws.getString(6).replace("^", "#").split("#");
				
				if((!rangeVal[1].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[1].charAt(0))))
					 lowVal = Float.parseFloat(rangeVal[1]);
						if((!rangeVal[0].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[0].charAt(0))))
					 highVal = Float.parseFloat(rangeVal[0]);
				
				if (ws.getString(3).matches("[0-9.]+") && (((Float.parseFloat(ws.getString(3)) < lowVal))
						|| (Float.parseFloat(ws.getString(3)) > highVal))) { 
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> <b>" + ws.getString(3) + " </b></td> ");
				} else if(!ws.getString(3).matches("[0-9.]+")){  
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
				}
				else {
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
				}
			} else {
				sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
			}
			sb.append("<td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'>" + ws.getString(11) + "</td>");
		sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(6).replace('^', '-') + " </td> "); 
			sb.append("</tr>");
			prevTestCode=ws.getString(9);
		}
		sb.append("</tbody></table></div>");
		sb.append("<br></br><br></br>");
		
		sb.append("<div style='float:right'><p><b> Signature of the Pathologist</b></p></div>");
		System.out.println("Signature------"+vo.getStrUserSign());
		//sb.append("<div class='footer' style='padding-top: 10px; border-top: 1px solid #ddd; font-size:13px; color: #333; margin-top: 20px; text-align: center;'>This is Computer-generated Test Report. Signature not required.</div>");
		sb.append("<div style= 'position: fixed; bottom: 9px; width: 100%; border-top: 1px solid #ddd; font-size:09px; color: #333;'>Test results relate only to item received. All reports need clinical correlation. Kindly discuss if necessary. No part of the report can be reproduced without written permission of the laboratory.<br></br><b>this is computer generated report. Signature not required.</b></div>");
		sb.append("</div>");
		sb.append("</body></html>");

	} catch (Exception e) {

		e.printStackTrace();
	}
	return sb.toString();
}

//public static String getDuplicatePatientDtl(InvOfflineResultEntryVO vo) {
//
//	StringBuffer sb = new StringBuffer("");
//	WebRowSet ws = null;
//	
//	try {
//		
//		sb.append("<div class= 'modal-body'> <table id = 'duplicatePatientListTableId'>");
//		sb.append("<tr>");
//		sb.append("<th style='width:5%;font-family: helvetica;padding: 1px;font-size: 12px;'></th>");
//		sb.append("<th style='width:25%;font-family: helvetica;padding: 1px;font-size: 12px;'>Patient Name</th>");
//		sb.append("<th style='width:15%;font-family: helvetica;padding: 1px;font-size: 12px;'>Age/Sex</th>");
//		sb.append("<th style='width:25%;font-family: helvetica;padding: 1px;font-size: 12px;'>Father/Spouse Name</th>");
//		sb.append("<th style='width:15%;font-family: helvetica;padding: 1px;font-size: 12px;'>Mobile No.</th>");
//		sb.append("<th style='width:5%;font-family: helvetica;padding: 1px;font-size: 12px;'></th>");
//		sb.append("</tr>");
//		
//		ws= vo.getDupPatListWS();
//		String radioBtn =""; 
//		while(ws.next()) {
//			radioBtn = ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"$"+ws.getString(6)+"$"+ws.getString(7)+"$"+ws.getString(9);
//			sb.append("<tr>");
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><input type='radio' id='dupPatid' name='dupPat' value='"+radioBtn+"' checked></td>"); //"+i+"
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(2)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(4)+ " "+ws.getString(5)+" / "+ws.getString(3)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(7)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(6)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' id='dupPatGoid' name='dupPatGo' value='"+radioBtn+"' onclick = 'switchToAlreadyRegistered();'><span>Go</span></a></td>"); //"+i+"
//			sb.append("</tr>");
//		}
//		
//		sb.append("</table></div>");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return sb.toString();
//}
//
//public static String getAllPatList(InvOfflineResultEntryVO vo) {
//	StringBuffer sb = new StringBuffer("");
//	WebRowSet ws = null;
//	
//	try {
//		sb.append("<div class= 'modal-body'> <table class= 'table' id = 'multiplePatientListTableId' width = '100%'>");
//		sb.append("<tr>");
//		sb.append("<th style='width:5%;font-family: helvetica;padding: 2px;font-size: 12px;'></th>");
//		sb.append("<th style='width:10%;font-family: helvetica;padding: 2px;font-size: 12px;'>Reg No.</th>");
//		sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Patient Name</th>");
//		sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Age/Sex</th>");
//		sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Father/Spouse Name</th>");
//		sb.append("<th style='width:10%;font-family: helvetica;padding: 2px;font-size: 12px;'>Mobile No.</th>");
//		sb.append("<th style='width:25%;font-family: helvetica;padding: 2px;font-size: 12px;'>Coll. Centre</th>");
//		sb.append("</tr>");
//		
//		ws= vo.getPatientListWS();
//		String radioBtn ="";
//		int i=1;
//		if(ws.size()>0) {
//		while(ws.next()) {
//			radioBtn = ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"$"+ws.getString(6)+"$"+ws.getString(11)+"$"+ws.getString(12)+"$"+ws.getString(7);
//			sb.append("<tr>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'><input type='radio' id='multiPatid"+i+"'+ name='multiPat' value='"+radioBtn+"'></td>"); 
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(1)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+WordUtils.capitalizeFully(ws.getString(2))+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(4)+ " "+ws.getString(5)+" / "+ws.getString(3)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+WordUtils.capitalizeFully(ws.getString(6))+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(7)+"</td>");
//			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(9)+"</td>");
//			sb.append("</tr>");
//			i++;
//			
//		}
//		sb.append("<tr>");
//		sb.append("<td></td><td></td><td></td><td></td>");
//		sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' id='multiPatGoid' name='multiPatGo' onclick = 'getPatDtl();'><span>Go</span></a>");  //value='"+i+"'
//		sb.append("&nbsp;&nbsp;<a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' data-dismiss='modal'><span>Cancel</span></a></td>");
//		sb.append("<td></td><td></td>");
//		sb.append("</tr>");
//		}
//		else {
//			sb.append("<tr><td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>No Record Found</td>");
//			sb.append("<td><a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' data-dismiss='modal'><span>Cancel</span></a></td></tr>");
//		}
//		sb.append("</table></div>");
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	return sb.toString();
//}
//
public static String getAllPatListResultEntry(NEWOfflineResultEntryVO vo) {
	
	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = null;
	
    try {
		sb.append("<div class= 'modal-body'> <table class= 'table' id = 'multiplePatientListTableId' width = '100%'>");
		sb.append("<tr>");
		sb.append("<th style='width:5%;font-family: helvetica;padding: 2px;font-size: 12px;'></th>");
    	sb.append("<th style='width:10%;font-family: helvetica;padding: 2px;font-size: 12px;'>Reg No.</th>");
		sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Patient Name</th>");
    	sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Age/Sex</th>");
 		sb.append("<th style='width:15%;font-family: helvetica;padding: 2px;font-size: 12px;'>Father/Spouse Name</th>");
		sb.append("<th style='width:10%;font-family: helvetica;padding: 2px;font-size: 12px;'>Mobile No.</th>");
		sb.append("<th style='width:25%;font-family: helvetica;padding: 2px;font-size: 12px;'>Coll. Centre</th>");
		sb.append("</tr>");
		
		ws= vo.getPatientListWS();
		String radioBtn ="";
		int i=1;
		if(ws.size()>0) {
		while(ws.next()) {
			radioBtn = ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"$"+ws.getString(6)+"$"+ws.getString(11)+"$"+ws.getString(12)+"$"+ws.getString(7) +"$"+ws.getString(8);
			sb.append("<tr>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'><input type='radio' id='multiPatid"+i+"'+ name='multiPat' value='"+radioBtn+"'></td>"); 
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(1)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+WordUtils.capitalizeFully(ws.getString(2))+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(4)+ " "+ws.getString(5)+" / "+ws.getString(3)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+WordUtils.capitalizeFully(ws.getString(6))+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(7)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>"+ws.getString(9)+"</td>");
			sb.append("</tr>");
			i++;
			
		}
		sb.append("<tr>");
		sb.append("<td></td><td></td><td></td><td></td>");
		sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' id='multiPatGoid' name='multiPatGo' onclick = 'getRegisteredPatDtl();'><span>Go</span></a>");  //value='"+i+"'
		sb.append("&nbsp;&nbsp;<a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' data-dismiss='modal'><span>Cancel</span></a></td>");
		sb.append("<td></td><td></td>");
		sb.append("</tr>");
		}
		else {
			sb.append("<tr><td style= 'font-family: helvetica;padding: 2px;font-size: 12px;'>No Record Found</td>");
			sb.append("<td><a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' data-dismiss='modal'><span>Cancel</span></a></td></tr>");
	}
		sb.append("</table></div>");
	} catch (Exception e) {
		e.printStackTrace();
	}
   return sb.toString();

}

	// Old method to get the List of Result Entries on the Current Day. - For
	// Reference. Dont Remove.
	/*
	 * public static String viewResultEntriesList(OfflineResultEntryVO vo) {
	 * 
	 * StringBuffer sb = new StringBuffer(""); WebRowSet ws = null; try {
	 * 
	 * String strHospitalList = ""; HisUtil hisutil = new
	 * HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); } vo.getStrHospitalListWS().beforeFirst();
	 * if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() >
	 * 1) { //If the logged-in Hospital has sub-hospitals
	 * 
	 * strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"",
	 * "0^All", false); }
	 * 
	 * else if (vo.getStrHospitalListWS() != null &&
	 * vo.getStrHospitalListWS().size() == 1 ) { //If the logged-in Hospital has no
	 * sub-hospitals
	 * 
	 * vo.getStrHospitalListWS().beforeFirst(); strHospitalList =
	 * hisutil.getOptionValue(vo.getStrHospitalListWS(),"", "", false);
	 * 
	 * }
	 * 
	 * else { strHospitalList = "<option value='0'>Select Value</option>";
	 * 
	 * }
	 * 
	 * vo.getStrResultEntryListWS().beforeFirst(); ws=vo.getStrResultEntryListWS();
	 * int slno = 1;
	 * 
	 * sb.append("<div class='row'>");
	 * sb.append("<div class='col-md-12 col-xs-12'>");
	 * sb.append("<div class='box box-solid box-primary'>");
	 * sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>" +
	 * "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries</h3>"
	 * ); sb.append("</div></div>");
	 * 
	 * 
	 * sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
	 * 
	 * sb.append("<label class='col-sm-2 control-label'>Hospital :</label>");
	 * sb.append("<div class='col-sm-2'>"); sb.
	 * append("<select name='strPatHospCode' id='strPatHospCodeId' class=form-control select_group product onchange='getEntryListForHosp();'>"
	 * ); sb.append(strHospitalList); sb.append("</select></div>");
	 * 
	 * //sb.append("<label class='col-sm-2 control-label'>CR NO :</label>"); sb.
	 * append("<label class='col-sm-2 control-label'><font color='red'>*</font>CR No. :</label>"
	 * ); sb.append("<div class='col-sm-2'>"); sb.
	 * append("<input type='text' class='form-control' id='patCRNoId' name='patCRNo' placeholder='Enter CR No.' autocomplete='on'>"
	 * ); sb.append("</div>");
	 * 
	 * sb.append("<div class='col-sm-2'>"); sb.
	 * append("<button type='submit' class='btn btn-success' onclick = 'getPatientDetails();'>Get Detail</button>"
	 * ); sb.append("</div></div><br/>");
	 * 
	 * sb.append("<div class = 'col-sm-12' style='text-align:center'>"); // sb.
	 * append("<button type='submit' class='btn btn-success' onclick = 'resetFunc();'>Reset</button>"
	 * ); //sb.
	 * append("<a href='#' id='resetBtnId' class='btn btn-success' onclick='resetFunc();'><span>Clear</span></a> "
	 * ); //sb.append("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"); //sb.
	 * append("<a href='#' id='cancelBtnId' class='btn btn-success' onclick = 'cancelFunc();'><span>Cancel</span></a> "
	 * ); sb.
	 * append("<button type='submit' class='btn btn-success' onclick = 'cancelFunc();'>Cancel</button>"
	 * ); sb.append("</div><br></br>");
	 * 
	 * sb.append("<div class='box box-solid box-primary'>");
	 * sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "+
	 * "<h3 class='box-title' style='font-size: 15px;'>Today's Offline Result Entry List</h3>"
	 * ); sb.append("</div></div>");
	 * 
	 * 
	 * sb.append("<div class='table-responsive'>");
	 * sb.append("<table class='table table-sm table-borderless'><thead>");
	 * sb.append("<tr>"); sb.append("<th scope='col'>S. No.</th>");
	 * sb.append("<th scope='col'>CR No.</th>");
	 * sb.append("<th scope='col'>Name</th>");
	 * sb.append("<th scope='col'></th></thead>"); sb.append("<tbody>");
	 * 
	 * if(ws !=null && ws.size()>0) { while(ws.next()) { sb.append("<tr>");
	 * sb.append("<td>"+slno++ +"</td>"); sb.append("<td>"+ws.getString(1)+"</td>");
	 * sb.append("<td>"+ws.getString(2)+"</td>");
	 * sb.append("<td><a href='#' onclick = 'view_Print_Slip(this,\""+ws.getString(3
	 * )+"\");'><span class='glyphicon glyphicon-download-alt'>View</span></a></td>"
	 * ); //sb.
	 * append("<td><button type='submit' class='btn btn-success' onclick = 'view_Print_Slip(this,"
	 * +ws.getString(3)+");'>View/Print</button></td>"); } } else {
	 * sb.append("<tr>"); sb.append("<td>No result Entries to show</td></tr>"); }
	 * sb.append("</tbody><table></div>"); sb.append("</div></div>");
	 * }catch(Exception e) { e.printStackTrace(); } return sb.toString(); }
	 */




public static String getOfflineResultEntryDtlswithbilling(NEWOfflineResultEntryVO vo, HttpServletRequest request)
		throws Exception {

	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = null;
	int count = 0, j = 0, indTestFlag = 0;
	String strHiddenVal = "", strRefRange = "";  
	String prevLabCode = "", prevTestCode = "";
	String highLowVals[];
	String strStatus= "";
	try {

		ws = vo.getOfflineTestWS();
		System.out.println("ws>>"+ws);
		System.out.println("getOfflineTestWS>>"+vo.getOfflineTestWS());
		
		sb.append("<table style=\"font-size: 15px;width:100%;\" class=\"table-bordered\" id=\"product_info_table\">");
		sb.append("<thead>");
		sb.append("<tr id='tableHeaderId'>");
		sb.append("<th style=\"width:5%;text-align: center;\">#</th>");
		sb.append("<th style=\"width:25%;text-align: center;\">Test Name</th>");
		sb.append("<th style=\"width:15%;text-align: center;\">Parameter Name</th>");
		sb.append("<th style=\"width:25%;text-align: center;\">Result</th>");
		sb.append("<th style=\"width:25%;text-align: center;\">Ref. Range</th>");
	    sb.append("<th style=\"width:35%;text-align: center;\">Status</th>");
		sb.append("</thead>");
		sb.append("</tr>");
		sb.append("<tbody>");
		if (ws != null && ws.size() > 0) {
			
			while (ws.next()) {
				
				if (ws.getString(11).equals("1") && !prevTestCode.equals(ws.getString(4))) {
					sb.append("<tr style=\"background-color: #5498be;cursor: pointer;\" onclick='showTest("+ ws.getString(3) + ");'>"); 
					sb.append("<input type='hidden' id='strTrToggle" + ws.getString(3) + "'  value='0'>");
					sb.append("<td style=\"display: none;\">&nbsp;</td>");
					sb.append("<td colspan=\"5\" style=\"text-align:left ;padding: 4px 0 4px 10px;color:#fff;\">"
					            + ws.getString(4) + "<div align='center' style=\"float: left;\" id='strDivImg"
							    + ws.getString(3)+ "'><img src='/HISInvestigationG5/hisglobal/images/arrow-down.png' width='16'></div></td>");
					sb.append("<td style=\"display: none;\">&nbsp;</td>");
					sb.append("<td style=\"display: none;\">&nbsp;</td>");
					sb.append("<td style=\"display: none;\">&nbsp;</td>");
					sb.append("<td style=\"display: none;\">&nbsp;</td>");
					sb.append("</tr>");
					indTestFlag = 1;
				} else {
					if (ws.getString(10).equals("0") && indTestFlag == 1) {
						sb.append("<tr style='background-color:#8a8ab8;font-weight: bold;font-size: 13px;' title='Individual Test'>"); 
						//sb.append("<tr style='font-weight: bold;font-size: 13px;' title='Individual Test'>"); 
						sb.append("<input type='hidden' id='strTrToggle" + ws.getString(3) + "'  value='0'>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td colspan=\"5\" style=\"text-align:'center';padding: 4px 0 4px 10px;color:#fff;\">Individual Test(s)</td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("<td style=\"display: none;\">&nbsp;</td>");
						sb.append("</tr>");
						indTestFlag = 0;
					}
				}

				String billNo=ws.getString(5);
				System.out.println("billNo>>>"+billNo);
				strHiddenVal = ws.getString(1) + "^" + ws.getString(3) + "^" + ws.getString(6)+"^" + billNo;;
				System.out.println("billNo>>>"+billNo);
				highLowVals=ws.getString(8).split("\\^");   //Get the high and Low ranges be available at jsp.

				
				if (ws.getString(11).equals("1"))
					sb.append("<tr id='tr" + ws.getString(3) + "' style=\"display: none;\">");
				else
					sb.append("<tr id='tr" + ws.getString(3) + "'>");
				    sb.append("<input type='hidden' name='strHiddenValue' id='strHiddenValue" + j + "'  value='0'>");
				    sb.append("<input type='hidden' name='strTestVal' id='strTestVal" + j + "'  value='" + strHiddenVal+ "'>");
				    System.out.println("strHiddenVal>>>>"+strHiddenVal);
				    sb.append("<input type='hidden' name='strTestLowValue' id='strTestLowValueId" + j + "'  value='"+highLowVals[1]+"'>");
				    sb.append("<input type='hidden' name='strTestHighValue' id='strTestHighValueId" + j + "'  value='"+highLowVals[0]+"'>");
				//FOR ELEMENT TYPE "E"
				if(ws.getString(11).equalsIgnoreCase("E")) {
					
					 if(ws.getString(10).equalsIgnoreCase("10")) {
					
					strRefRange = ws.getString(8).split("\\^")[1] + " " + ws.getString(8).split("\\^")[2] + " - "
							+ ws.getString(8).split("\\^")[0] + " " + ws.getString(8).split("\\^")[3];
					
					} 
					
					if (ws.getString(10).equalsIgnoreCase("11"))  //AGE-WISE COMPARISON
					{ 
						String refValue[] = ws.getString(8).split("#");
						if(refValue.length>1) {                /// nandini
						strRefRange = Math.round(Float.valueOf(refValue[1].split("\\^")[5]))+"-"+Math.round(Float.valueOf(refValue[1].split("\\^")[6]))+" ";
						
							if(refValue[1].split("\\^")[7].equalsIgnoreCase("1"))
								strRefRange= strRefRange + "Yrs: ";
							else if(refValue[1].split("\\^")[7].equalsIgnoreCase("2"))
								strRefRange= strRefRange + "Months: ";
							else
								strRefRange= strRefRange + "Days: ";
						strRefRange= strRefRange+refValue[1].split("\\^")[2]+"-"+refValue[1].split("\\^")[0]+" "+refValue[1].split("\\^")[2];
						
						strRefRange= strRefRange+"; "+Math.round(Float.valueOf(refValue[0].split("\\^")[5]))+"-"+Math.round(Float.valueOf(refValue[0].split("\\^")[6]))+" ";
						
						if(refValue[0].split("\\^")[7].equalsIgnoreCase("1"))
							strRefRange= strRefRange + "Yrs: ";
						else if(refValue[0].split("\\^")[7].equalsIgnoreCase("2"))
							strRefRange= strRefRange + "Months: ";
						else
							strRefRange= strRefRange + "Days: ";
						
						strRefRange= strRefRange+refValue[0].split("\\^")[1]+"-"+refValue[0].split("\\^")[0]+" "+refValue[0].split("\\^")[2];
						System.out.println("HLP  >> REF _ RANGE STRING at E 11 = "+strRefRange);
					}
					}
					else if (ws.getString(10).equalsIgnoreCase("12"))  //GENDER-WISE COMPARISON
					{ 
						String ref_range_result = ws.getString(8); 
						if(ref_range_result.contains("#")) {
						String refValue[] = ref_range_result.split("#");
						if(refValue.length>0) {
						strRefRange = "M: "+refValue[0].split("\\^")[1] + " - "	+ refValue[0].split("\\^")[0] + " " + refValue[0].split("\\^")[3]+ "; F: " 
								+refValue[1].split("\\^")[1] + " - "	+ refValue[1].split("\\^")[0] + " " + refValue[1].split("\\^")[3];
						}
						else if(ref_range_result.contains("M")) {
							refValue = ref_range_result.split("M");
							strRefRange = "M: "+refValue[0].split("\\^")[1] + " " + refValue[0].split("\\^")[2] +" " + refValue[0].split("\\^")[3];
						}
						else if(ref_range_result.contains("F")) {
							refValue = ref_range_result.split("F");
							strRefRange = "F: "+refValue[0].split("\\^")[1] + " " + refValue[0].split("\\^")[2] +" " + refValue[0].split("\\^")[3];
						}
					}	
						else 
							strRefRange = ws.getString(8).split("\\^")[1] + " " + ws.getString(8).split("\\^")[2] + " - "
								+ ws.getString(8).split("\\^")[0] + " " + ws.getString(8).split("\\^")[3];
							
				  } //System.out.println("HLP  >> REF _ RANGE STRING at E 12 = "+strRefRange);
				} 
				//For ELEMENT TYPE "D"  
				else if(ws.getString(11).equalsIgnoreCase("D")){
					
					//For ELEMENT TYPE "D"  or ("E" and "10")
					strRefRange = ws.getString(8).split("\\^")[1] + " " + ws.getString(8).split("\\^")[2] + " - "
							+ ws.getString(8).split("\\^")[0] + " " + ws.getString(8).split("\\^")[3];
				}
				
				
				if (prevTestCode == "" || !prevTestCode.equals(ws.getString(4))) {
					sb.append("<td style=\"text-align: center;\"><input type='checkbox' name='srrChk' value='"
							+ strHiddenVal + "' onclick='enableFields(this," + j + "," + ws.getString(3)
							+ ");'></td>");  
					
				//	 sb.append("<td style=\"text-align: center;\"><input type='hidden' id='labcodeno' name='labcodeno' value="+ws.getString(1)+"></td>");
					sb.append("<td    style=\"text-align: left;\" > " + ws.getString(4).replace("[", "<br/><i >[ Bill No. :  ") + "</i> </td>");
				} else {
					sb.append("<td style=\"text-align: center;\">&nbsp;</td>");
					sb.append("<td style=\"text-align: left;\">&nbsp;</td>");
				}

				sb.append("<td style=\"text-align: left;\">" + ws.getString(7) + "</td>");
				sb.append("<td style=\"text-align: center;\"><input type='text' id = 'strTestResultId" + j + "#"
						+ ws.getString(3) + "' name='strTestResult' disabled onblur='showDetailsText(this," + j
						+ ");' onkeyup = 'validateRangeVal(this,"+j+");' autocomplete= 'on'></td>"); // "$"+ws.getString(3)+
				sb.append("<td style=\"text-align: center;\">" + strRefRange + "</td>");
				sb.append("<input type='hidden' name='strRefRangeVal' id='strRefRangeValId" + j + "' value='"+ strRefRange + "' >");
				sb.append("<input type='hidden' name='strStatusVal' id='strStatusValId" + j + "' value='"+ strStatus + "' >");
				System.out.println("ws.getString(5)===" + ws.getString(5));
				 if(ws.getString(5).equalsIgnoreCase("1^1")){
					// sb.append("<td style='text-align: center;'><span style='color: green;'>Free</span></td>");
				       sb.append("\"<td style='text-align: center;'><span class=\"badge bg-success text-white\">Free</span></td>");
				 }				
				else if(ws.getString(5).equals("0^0")) {
				        sb.append("<td ><span class=\"badge bg-danger text-white\">Payment Pending</span></td>");
				}   
			    else 
			    {
			    	sb.append("<td style=\"text-align: center;\"><span class=\"badge bg-success text-white\">Paid</span></td>");	
			    }
					
				j++;
				sb.append("</tr>");
				prevTestCode = ws.getString(4);
				prevLabCode = ws.getString(1);

			}

		}

		sb.append("</tbody></table>");

	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	}

	return sb.toString();
}













}
