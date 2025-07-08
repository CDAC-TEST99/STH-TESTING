package new_investigation.transactions.controller.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;
import org.apache.commons.lang.WordUtils;
//import org.apache.commons.text.WordUtils;

import hisglobal.config.SaveFileInFtpGlobal;
import hisglobal.utility.HisUtil;
import new_investigation.vo.InvOfflineResultEntryVO;

public class InvOfflineResultEntryHLP {

	public static String getOfflineResultEntryDtls(InvOfflineResultEntryVO vo, HttpServletRequest request)
			throws Exception {
		System.out.println("printslip11");

		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		int count = 0, j = 0, indTestFlag = 0;
		String strHiddenVal = "", strRefRange = "";
		String prevLabCode = "", prevTestCode = "";
		String highLowVals[];
		try {

			ws = vo.getOfflineTestWS();
			sb.append("<table style=\"font-size: 10px;\" class=\"table-bordered\" id=\"product_info_table\">");
			sb.append("<thead>");
			sb.append("<tr id='tableHeaderId'>");
			sb.append("<th style=\"width:5%;text-align: center;\">#</th>");
			sb.append("<th style=\"width:25%;text-align: center;\">Test Name</th>");
			sb.append("<th style=\"width:30%;text-align: center;\">Parameter Name</th>");
			sb.append("<th style=\"width:25%;text-align: center;\">Result</th>");
			sb.append("<th style=\"width:35%;text-align: center;\">Ref. Range</th>");
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
						sb.append("<td colspan=\"6\" style=\"text-align: right;padding: 4px 0 4px 10px;color:#fff;\">"
								+ ws.getString(4) + "<div align='left' style=\"float: right;\" id='strDivImg"
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
									"<td colspan=\"6\" style=\"text-align: left;padding: 4px 0 4px 10px;color:#fff;\">Individual Test(s)</td>");
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
							//System.out.println("HLP  >> REF _ RANGE STRING at E 11 = "+strRefRange);
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
						sb.append("<td style=\"text-align: left;\">" + ws.getString(4) + "</td>");
					} else {
						sb.append("<td style=\"text-align: center;\">&nbsp;</td>");
						sb.append("<td style=\"text-align: left;\">&nbsp;</td>");
					}

					sb.append("<td style=\"text-align: left;\">" + ws.getString(6) + "</td>");
					sb.append("<td style=\"text-align: center;\"><input type='text' id = 'strTestResultId" + j + "#"
							+ ws.getString(3) + "' name='strTestResult' disabled onblur='showDetailsText(this," + j
							+ ");' onkeyup = 'validateRangeVal(this,"+j+");' autocomplete= 'off'></td>"); // "$"+ws.getString(3)+
					sb.append("<td style=\"text-align: center;\">" + strRefRange + "</td>");
					sb.append("<input type='hidden' name='strRefRangeVal' id='strRefRangeValId" + j + "' value='"
							+ strRefRange + "' >");

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
	public static String printslip(InvOfflineResultEntryVO vo) {
System.out.println("printslip");
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String prevTestCode = "";
		
		
		try {

			// vo.getStrPatientDtlWS().beforeFirst();
			
			
	  		/*Added by Anjali- 26-11-2020*/
	  		String downFile="";
	  		
	  		/*Fetch base64 string of Customized logo File*/
				
				  if(vo.getStrLogoFileName()!=null && vo.getStrLogoFileName()!="") {
				  downFile=
				  SaveFileInFtpGlobal.readImageFromLocation(vo.getStrLogoFileName()); 
				  System.out.println("Download Files======"+downFile);
				  
				  }
				 
			ws = vo.getStrPatientDtlWS();
			String patAge= "",patAgeUnit="", patGender="";
			ws.beforeFirst();
			
			sb.append("<html><head><style>");
			sb.append("html,\r\n" + 
					"body {\r\n" + 
					"  height: 100%;\r\n" + 
					"  margin: 0;\r\n" + 
					"  padding: 0;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					"body {\r\n" + 
					"  \r\n" + 
					"  padding-bottom: 100px;\r\n" + 
					"}\r\n" + 
					"\r\n" + 
					".footer {\r\n" + 
					"  position: fixed;\r\n" + 
					"  bottom: 0;\r\n" + 
					"  width: 100%;\r\n" + 
					"  text-align: center;\r\n" + 
					"}");
			sb.append("</style></head><body>");
			while (ws.next()) {
				sb.append("<div id='printableArea'> ");
				sb.append("<div valign='top'>");
				//logo......
				
				 if(vo.getIsLogoRequired().equals("0"))//No logo 
					  sb.
					  append(" <td  width='50%'> <div class='div-table-col' id='divOPDCardLogo' align='right' style='width: 100%;'><img width='70' src='/HIS/hisglobal/images/e-clinic/goa_logo.jpg'/></div></td>"
				  );
				
				vo.setLogoType("1");
	  		  	
				  if(vo.getIsLogoRequired().equals("0"))//No logo 
					  sb.
					  append(" <td  width='50%'> <div class='div-table-col' id='divOPDCardLogo' align='right' style='width: 100%;'><img width='70' src='/HIS/hisglobal/images/e-clinic/goa_logo.jpg'/></div></td>"
				  );
				  
				  
				  else { if(vo.getLogoType().equals("1")) {//Default PHSC Logo 
					  sb.
				  append(" <td  width='50%'> <div class='div-table-col' id='divOPDCardLogo' align='right' style='width: 100%;'><img width='70' src='/HIS/hisglobal/images/e-clinic/goa_logo.jpg'/></div></td>"
				  );
				  
				  }else if(vo.getLogoType().equals("2")) {//Customized Logo fetched from FTP 
				  sb.
				  append(" <td  width='50%'> <div class='div-table-col' id='divOPDCardLogo' align='right' style='width: 100%;'><img src='" +downFile+"' width='70px' height='68px'/></div></td>");
				  
				  }
				  
				  }
				
				//logo.....
				
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
				sb.append("<label>Print Date-Time:" + dateFormat.format(date) + "</label>");
				sb.append("<br></br><br></br><br></br>");
				sb.append("</div>");

				sb.append("</div>");

				// Printing the Patient's Details.
				sb.append("<div style='border: 1px solid black; border-radius: 25px; padding: 15px;'>");
				sb.append("<table width='100%' style='font-size: 12px;'> ");
				sb.append("<tr>");
				sb.append("<td width= '23%'><label><b>Reg. Number: </b></label></td><td width= '23%'><b>" + vo.getPatCRNo()
						+ "</b></td>");
				sb.append("<td width= '25%'><label><b>Collection Centre: </b></label></td><td width= '25%'>"
						+ ws.getString(7) + "</td>");

				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'><label><b>Patient Name: </b></label></td><td width= '23%'>"+ WordUtils.capitalizeFully(ws.getString(1)) + "</td>");
				sb.append("<td width= '25%'><label><b>Sample Collection Date: </b></label></td><td width= '25%'><b>"
						+ ws.getString(9) + "</b></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'><label><b>Age / Sex: </b></label></td><td width= '23%'>" + ws.getString(3)
						+ " " + ws.getString(4) + " / " + ws.getString(2) + "</td>");
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
				
				patAge=ws.getString(3);
				patAgeUnit=ws.getString(4);
				patGender=ws.getString(2);
			}

			// Printing the Tests' Details.
			// vo.getStrPatientTestListWS().beforeFirst();
			ws = vo.getStrPatientTestListWS();
			int slno = 1;
			sb.append("<div style='border: 1px solid black'>");
			sb.append("<table  id='viewTableListing' border = '1' style='width:100%; border-collapse: collapse;'> ");
			sb.append("<thead> <tr style= 'border: 1px solid black;'> " + " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 5%;'> S.No</th> "
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 30%;'> Test Name </th>" 
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 27%;'> Parameter Name </th>"
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 13%;'> Result</th>  " 
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 25%;'> Reference Range</th>" + "</tr> </thead>");

			sb.append("<tbody><tr></tr><tr></tr><tr></tr>");

			while (ws.next()) {
				sb.append("<tr style= 'border: 1px solid black;'>");
				if(!prevTestCode.equals(ws.getString(9))) {
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + slno++ + " </td> ");
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(1) + " </td> ");
				}
				else {
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> ");
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> ");
					
				}
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(5) + " </td> ");

				// Logic to get the Out of Range values printed in the Bold.
				
				if (!(ws.getString(6).equals("-")) && !(ws.getString(6).matches("[a-zA-Z]+"))) {
					
					float lowVal=0,highVal=0;
					String rangeVal[] = ws.getString(6).replace("^", "#").split("#");
					
						if((!rangeVal[1].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[1].charAt(0))))
					 lowVal = Float.parseFloat(rangeVal[1]);
						if((!rangeVal[0].trim().equalsIgnoreCase("-")) && (Character.isDigit(rangeVal[0].charAt(0))))
					 highVal = Float.parseFloat(rangeVal[0]);
					
					if (ws.getString(3).matches("[0-9.]+") && (((Float.parseFloat(ws.getString(3)) < lowVal))
							|| (Float.parseFloat(ws.getString(3)) > highVal))) { 
						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> <b>" + ws.getString(3) + " </b></td> ");
					} else if(!ws.getString(3).matches("[0-9.]+") || ws.getString(3).matches("[a-zA-Z]+")){
						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
					}
					else { 
						sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
					}
				} else if(ws.getString(6).equals("-")){
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(3) + " </td> ");
				}
				
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws.getString(2) + " </td> ");
				sb.append("</tr>");
				prevTestCode=ws.getString(9);
			}
			sb.append("</tbody></table></div>");
			sb.append("<br></br><br></br><br></br><br></br>");
			
			sb.append("<div style='float:right'><img src='"+vo.getStrUserSign()+"' width='150px' height='68px'/><p><b> Signature of the Pathologist</b></p></div>");
			//sb.append("<div class='footer' style='padding-top: 10px; border-top: 1px solid #ddd; font-size:13px; color: #333; margin-top: 20px; text-align: center;'>This is Computer-generated Test Report. Signature not required.</div>");
			sb.append("<div style= 'position: fixed; bottom: 10px; width: 100%; border-top: 1px solid #ddd; font-size:11px; color: #333;'>Test results relate only to item received. All reports need clinical correlation. Kindly discuss if necessary. No part of the report can be reproduced without written permission of the laboratory.<br></br><b>this is computer generated report. Signature not required.</b></div>");
			sb.append("</div>");
			sb.append("</body></html>");

		} catch (Exception e) {

			e.printStackTrace();
		}
		return sb.toString();
	}

	// Function to List the Result Entries of the day by Deepti 21.01.2021

	public static String viewResultEntriesListForReportView(InvOfflineResultEntryVO vo) {
		System.out.println("printslip222");

		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		try {
			
	//		final String goa_logo = "data:image/png;base64,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";

			vo.getStrResultEntryListWS().beforeFirst();
			ws = vo.getStrResultEntryListWS();
			System.out.println("webrowsize"+ws.size());
			int slno = 1;
			
			//   sb.append("<div>");
				//sb.append("<center><h2><img src='"+goa_logo+"' style='height:120px;margin-bottom:10px;'></h2></center>");
				//sb.append("</div>");

			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12 col-xs-12'>");
			sb.append("<div class='box box-solid box-primary'>");
		/*	sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries</h3>");
			
			sb.append("</div></div></div>");

			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");

			sb.append(
					"<label class = 'col-sm-2 control-label'><font color='red'>*</font>From Date (Sample Collection) : </label>");
			sb.append(
					"<div class='col-sm-1'><input style= 'width:110px;' type = 'text' name = 'strFromDate' id= 'strFromDateId' placeholader = 'Sample Collection Date FROM'/>");
			sb.append("</div>");

			sb.append("<label class = 'col-sm-2 control-label'><font color='red'>*</font>To Date (Sample Collection) : </label>");
			sb.append("<div class='col-sm-1'><input style= 'width:110px;' type = 'text' name = 'strToDate' id= 'strToDateId' placeholader = 'Sample Collection Date TO'/>");
			sb.append("</div>");

	
			sb.append("<label class='col-sm-1 control-label' style = 'width:10%'>&nbsp; OR &nbsp;&nbsp;&nbsp;<font color='red'>*</font>Cr No.:</label>");
			sb.append("<div class='col-sm-2' style='width:11%'>");
			sb.append("<input type='text' class='form-control' style = 'height: 25px;'id='patCRNoId' name='patCRNo' placeholder='Cr.No.' autocomplete='on' minlength = '15' maxlength = '15'>");
			sb.append("</div>");

			sb.append("<label class='col-sm-1 control-label' style='text-align:left;width:10%'>&nbsp; OR &nbsp;&nbsp;<font color='red'>*</font>Mobile No.:</label>");
			sb.append("<div class='col-sm-1'style='width:10%'>");
			sb.append("<input type='text' class='form-control' style = 'height: 25px;' id='patMobNoId' name='patMobNo' placeholder='Mobile No.' autocomplete='on' minlength = '10' maxlength = '10'>");
			sb.append("</div>");
			
			sb.append("<div class='col-sm-1'>");
			// sb.append("<button type='submit' id = 'getPatDtlsId' class='btn btn-success'onclick = 'getPatientDetails();'>Get Detail</button>");  
			sb.append("<a href='#' id='getPatDtlsId' class='btn btn-success' style='padding:1px 6px;' onclick='getDetails();' data-toggle='modal'><span>Go</span></a> ");
			sb.append("</div><br/>");

			sb.append("</div>"); */

			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
			sb.append("</div></div>");
			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
					+ "<h3 class='box-title' style='font-size: 15px;'>From Date "+vo.getStrFromDate()+"&nbsp;-&nbsp;To Date&nbsp;"+vo.getStrToDate()+"</h3>");
			sb.append("</div></div>");
			sb.append("<div class='table-responsive'>");
			sb.append("<table class='table-bordered' id= 'TablePatTestList' style= 'width:100%'><thead>");
			sb.append("<tr>");
			sb.append("<th scope='col' width = '5%'>#</th>");
			//sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
			sb.append("<th scope='col' width = '11%' style= 'text-align:center;'>Req. No</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'> Patient Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
			//sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab Report</th></thead>");
			sb.append("<tbody>");

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					sb.append("<tr>");
					sb.append("<td>" + slno++ + "</td>");
					//sb.append("<td>" + ws.getString(8) + "</td>");
					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
					sb.append("<td align='center'>" + ws.getString(9) + "</td>");
					sb.append("<td align='center' >" + ws.getString(2) + "</td>");
					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
					//sb.append("<td align='center'>" + ws.getString(6) + "</td>");
					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
				sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)+"\");'><span>View</span></a></td>");
					// sb.append("<td><button type='submit' class='btn btn-success' onclick =
					// 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>"); //<span class='glyphicon glyphicon-download-alt'></span>
				}
			}
			/*
			 * else // Commented as Data Table is applied. 
			 * { sb.append("<tr>");
			 * sb.append("<td>No result Entries to show</td></tr>"); }
			 */
			sb.append("</tbody><table></div>");
			sb.append("</div>");
			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
			sb.append("</span></div>");
			sb.append("<div class = 'col-sm-12' style='text-align:center;margin-top:1%;'>");
			// sb.append("<a href='#' id='cancelBtnId' class='btn btn-success' onclick = 'cancelFunc();'><span>Cancel</span></a> ");
			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Reset</button>");
			sb.append("</div>");
			sb.append("</div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

//Function to Display the Patient's Details on click of Get Details by Deepti 21.01.2021
	public static String getPatOfflineResDtl(InvOfflineResultEntryVO vo) {
		System.out.println("printslip333");

		StringBuffer sb = new StringBuffer("");
		String prevTestCode = "";
		try {

			WebRowSet ws1 = null;

			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12 col-xs-12'>");
			sb.append("<div class='box box-solid box-primary' style= 'margin-top:2px;'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries -> Patient Detail</h3>");
			sb.append("</div></div>");

			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");
			/* sb.append("<label for='po_no' class='col-sm-2 control-label'><font color='red'>*</font>CR No. :</label>");
			sb.append("<div class='col-sm-2' float='left'>");
			sb.append("<input type='text' class='form-control' id='patCRNoId' name='patCRNo' autocomplete='on' value= '"+ vo.getPatCRNo() + "' />");
			sb.append("</div>");

			
			 * sb.append("<div class='col-sm-4' float='center'>"); sb.
			 * append("<button type='submit' class='btn btn-success' onclick = 'getPatientDetails();' disabled>Go</button>"
			 * ); sb.append("</div></div>");
			 */

			/*sb.append("<div class='col-md-12 col-xs-12 box box-solid box-primary'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
					+ "<h3 class='box-title' style='font-size: 15px;'>Patient Details: </h3>");
			sb.append("</div></div>"); */
			sb.append("<div class='rounded border table-responsive' style = 'border: 1px solid black; border-radius: 10px;padding: 5px;'>");
			//sb.append("<div class='table-responsive'>");
			sb.append("<table id = 'patDtlTable' width='100%' class='table table-sm table-bordered'> ");

			// Section to get General details.

			ws1 = vo.getStrPatientDtlWS();

			while (ws1.next()) {

				
				sb.append("<tr>");
				
				if(vo.getPatCRNo().equals("")) {
					sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + ws1.getString(12)+ "</label></td>");
					}
				else
				sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + vo.getPatCRNo()+ "</label></td>");
				
				sb.append("<td width= '25%'>Collection Centre: </td><td width= '25%'>" + ws1.getString(7) + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'>Patient Name: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(1)) + "</td>");
				sb.append("<td width= '25%'><label>Sample Collection Date: </label></td><td width= '25%'><label>"+ ws1.getString(9) + "</label></td>");
				// sb.append("<td><label>Sex:</label><span>"+ws.getString(2)+"</span></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'>Age / Sex: </td><td width= '23%'>" + ws1.getString(3) + " "
						+ ws1.getString(4) + " / " + ws1.getString(2) + "</td>");
				sb.append("<td width= '25%'><label>Result Entry Date: </label></td><td width= '25%'><label>"
						+ ws1.getString(10) + "</label></td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'>Address: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(5)) + "</td>");
				sb.append("<td width= '25%'>Mobile No.: </td><td width= '25%'>" + ws1.getString(6) + "</td>");
				sb.append("</tr>");
			}
			sb.append("</table></div>");
			sb.append(
					"<hr style='color: #000;border: 0px;height: 12px;box-shadow: inset 0 12px 12px -12px rgba(0, 0, 0, 0.5);'/>");

			vo.getStrPatientTestListWS().beforeFirst();
			ws1 = vo.getStrPatientTestListWS();
			int slno = 1;

			sb.append("<table  id = 'patTestListTable' class = 'border' id='viewTableResultListing' width='100%'> ");
			/* sb.append("<thead> <tr> " + " <th width= '5%'> # </th> " + " <th width= '28%'> Test Name </th>"
					+ " <th width= '27%'> Parameter Name </th>" + " <th width= '20%'> Ref. Range</th>  "
					+ " <th width= '20%'> Result</th>" + "</tr> </thead>");
			*/
			
			sb.append("<thead> <tr style= 'border: 1px solid black;'> " + " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 5%;'> S.No</th> "
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 40%;'> Test Name </th>" 
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Result </th>"
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 15%;'> Unit</th>  " 
					+ " <th style = 'font-family: helvetica;padding: 2px;font-size: 12px;width: 25%;'> Reference Range</th>" + "</tr> </thead>");
			
			sb.append("<tbody><tr></tr><tr></tr><tr></tr>");
			while (ws1.next()) {
				sb.append("<tbody><tr>");				
				if(!prevTestCode.equals(ws1.getString(9))) {
					sb.append("<tr>"); // style= 'border: 1px solid black;'
					sb.append(" <td style = 'font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + slno++ + " </td> ");
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'><b> " + ws1.getString(1) + "</b> </td> ");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
					sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(5) + " </td> ");
					}
					else {
						sb.append("<tr>");
						sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'></td> "); 
						sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(5) + " </td> ");
					}
				//sb.append(" <td align= 'left'> " + slno++ + " </td> ");
				//sb.append(" <td align= 'left'> " + ws1.getString(1) + " </td> ");
				//sb.append(" <td  align= 'left'> " + ws1.getString(5) + " </td> ");
				//sb.append(" <td align= 'left'> " + ws1.getString(2) + " </td> ");

				// Logic to get the Out of Range values printed in the Bold.
				if (!ws1.getString(6).equals("-")) {
					float lowVal=0,highVal=0;
					String rangeVal[] = ws1.getString(6).replace("^", "#").split("#");
					
					if((!(rangeVal[1].equals("-"))  && (Character.isDigit(rangeVal[1].charAt(0)))))
						 lowVal = Float.parseFloat(rangeVal[1]);
					if((!(rangeVal[0].equals("-")) && (Character.isDigit(rangeVal[1].charAt(0)))))
						 highVal = Float.parseFloat(rangeVal[0]);

					if (ws1.getString(3).matches("[0-9]+") && (((Float.parseFloat(ws1.getString(3)) < lowVal))
							|| (Float.parseFloat(ws1.getString(3)) > highVal))) {
						sb.append(" <td align= 'left'> <b>" + ws1.getString(3) + " </b></td> ");
					} else {
						sb.append(" <td align= 'left'> " + ws1.getString(3) + " </td> ");
					}
				} else {
					sb.append(" <td align= 'left'> " + ws1.getString(3) + " </td> ");
				}
				
				sb.append("<td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'>" + ws1.getString(11) + "</td>");
				sb.append(" <td style ='font-family: helvetica;padding: 1px;font-size: 12px;' align= 'left'> " + ws1.getString(6).replace('^', '-') + " </td> "); 
				sb.append("</tr>");
				prevTestCode=ws1.getString(9);
			}
			sb.append("</tbody></table><br/>");
			sb.append("<div style='float:center;margin-left: 42%;'>");
			ws1.beforeFirst();
			int iteration = 1;
			while (ws1.next() && iteration++ == 1) {
				sb.append("<a href='#' class = 'btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws1.getString(4)
						+ "\");'>View Slip</a>");
				sb.append(
						"&nbsp;&nbsp;&nbsp;<a href='#' class = 'btn btn-warning' onclick = 'cancelFunc();'>Cancel</a>");
				// sb.append("<button type='submit' class='btn btn-success' onclick =
				// 'view_Print_Slip(this,"+ws1.getString(4)+");'>View/Print</button></div><script>showHideDiv();</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String viewResultEntriesList(InvOfflineResultEntryVO vo) {
		System.out.println("printslip4++++");

		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		try {

			vo.getStrResultEntryListWS().beforeFirst();
			ws = vo.getStrResultEntryListWS();
			int slno = 1;
			
			String strHospitalList = ""; 
			HisUtil hisutil = new HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
			if (vo.getStrMsgType().equals("1")) 
			{ 
				throw new Exception(vo.getStrMsgString()); 
			} 
			
			vo.getStrHospitalListWS().beforeFirst();
			
			if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() >1) 
			{ //If the logged-in Hospital has sub-hospitals
			 
				strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"","0^All", false); 
			}
			 
			else if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() == 1 ) 
			{ //If the logged-in Hospital has no sub-hospitals
			
			vo.getStrHospitalListWS().beforeFirst(); 
			strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"", "", false);
			}
			
			else 
			{ 
				strHospitalList = "<option value='0'>Select Value</option>";
			}
			
			
			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12 col-xs-12'>");
			sb.append("<div class='box box-solid box-primary'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries View</h3>");
			sb.append("</div></div>");
			sb.append("</div>");

			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");

			sb.append("<label class = 'col-sm-2 control-label'style = 'width:190px;'><font color='red'>*</font>From Date (Result Entry) : </label>");
			sb.append("<div class='col-sm-2' style='width:11%;'><input type = 'text' name = 'strFromDate' id= 'strFromDateId' style = 'width:120px;'/>");
			sb.append("</div>");

			sb.append("<label class = 'col-sm-2 control-label' style='width:190px;'><font color='red'>*</font>To Date (Result Entry) : </label>");
			sb.append("<div class='col-sm-2' style='width:11%;'><input type = 'text' name = 'strToDate' id= 'strToDateId' style = 'width:120px;'/>");
			sb.append("</div>");
			
			sb.append("<label class = 'col-sm-1 control-label'>Hospital : </label>");
			sb.append("<div class='col-sm-2'><select name='strPatHospCode' id='strPatHospCodeId' class=form-control select_group product style= 'height: 26px;font-size: 12px;'>");
			
			sb.append(strHospitalList); 
			sb.append("</select></div>");//sb.append("</div>");
			
			sb.append("<div class='col-sm-1'>");
			//sb.append("<input type='button' class='btn btn-success' onclick = 'getEntryList();'>Go");
			sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-success' onclick='getEntryList();'><span>Go</span></a> ");
			//sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-warning' onclick='resetListFields();'><span>Reset</span></a> ");
			sb.append("</div><br/>");

			sb.append("</div>");

			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
			sb.append("</div></div>");

			sb.append("<div class='table-responsive'>");
			sb.append("<table id = 'resultEntriesListTable' class='table-bordered'><thead>");
			sb.append("<tr>");
			sb.append("<th scope='col' width = '5%'>#</th>");
			sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
			sb.append("<th scope='col' width = '15%'>Patient Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab 4Report</th></thead>");
			sb.append("<tbody>");

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					sb.append("<tr>");
					sb.append("<td>" + slno++ + "</td>");
					sb.append("<td>" + ws.getString(8) + "</td>");
					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
					sb.append("<td>" + ws.getString(2) + "</td>");
					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
					sb.append("<td align='center'>" + ws.getString(6) + "</td>");
					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
					//System.out.println("GDT_ENTRY_DT HLP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> = "+ws.getString(11));
					sb.append("<td align='center'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)
							+ "\");'><span>View</span></a> ");//  <a href='#' class='btn btn-warning' style='height:25px;padding: 3px 6px;font-size: 12px;' onclick = 'modifyRecord(this,\""+ws.getString(1)+"\",\""+ws.getString(4)+"\",\""+ws.getString(9)+"\",\""+ws.getString(10)+"\",\""+ws.getString(11)+"\")'><span>Edit</span></a></td>"); //class='glyphicon glyphicon-download-alt'
					// sb.append("<td><button type='submit' class='btn btn-success' onclick = 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>");
				}
			}
			/*
			 * else { sb.append("<tr>");
			 * sb.append("<td>No result Entries to show</td></tr>"); }
			 */
			sb.append("</tbody><table></div></div>");
			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
			sb.append("</span></div>");
			sb.append("<div class = 'col-sm-12' style='text-align:center'>");
			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Cancel</button>");
			sb.append("</div>");
			sb.append("</div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static String getRegisteredPatientDtl(InvOfflineResultEntryVO vo) {
		System.out.println("printslip5++++++");

		StringBuffer sb = new StringBuffer("");

		try {

			WebRowSet ws1 = null;
			sb.append("<div class='table-responsive'>");
			sb.append("<table id = 'regPatDtlTable' style= 'width:100%; font-size: 12px;' class='table table-sm table-borderless'> ");

			// Section to get General details.

			ws1 = vo.getStrPatientDtlWS();
			while (ws1.next()) {

				sb.append("<tr>");
				sb.append("<td width= '23%'><label>Reg. No.: </label></td><td width= '23%'><label>" + vo.getPatCRNo()+ "</label></td>");
				sb.append("<td width= '25%'>Mobile No.: </td><td width= '25%'>" + ws1.getString(6) + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '25%'>Patient Name: </td><td width= '25%'>" + WordUtils.capitalizeFully(ws1.getString(1)) + "</td>");
				sb.append("<td width= '23%'>Age / Sex: </td><td width= '23%'>" + ws1.getString(3) + " "
						+ ws1.getString(4) + " / " + ws1.getString(2) + "</td>");
				sb.append("</tr>");

				sb.append("<tr>");
				sb.append("<td width= '23%'>Father/Spouse Name: </td><td width= '23%'>" + ws1.getString(11) + "</td>");
				sb.append("<td width= '23%'>Address: </td><td width= '23%'>" + WordUtils.capitalizeFully(ws1.getString(5)) + "</td>");
				sb.append("</tr>");

			}
			sb.append("</table></div>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

	public static String viewResultEntries_onHospChange(InvOfflineResultEntryVO vo) {
		System.out.println("printslip6++++++");
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = null;
		try {

			vo.getStrResultEntryListWS().beforeFirst();
			ws = vo.getStrResultEntryListWS();
			int slno = 1;
			
			String strHospitalList = ""; 
			HisUtil hisutil = new HisUtil("Offline Result Entry", "InvOfflineResultEntryFB");
			if (vo.getStrMsgType().equals("1")) 
			{ 
				throw new Exception(vo.getStrMsgString()); 
			} 
			
			WebRowSet hospWS = vo.getStrHospitalListWS();
			String HospComboString = "";
			while(hospWS.next())
			{
				if(vo.getHospitalcode().equalsIgnoreCase(hospWS.getString(1)))
					HospComboString = hospWS.getString(1)+"^"+hospWS.getString(2)+"#0^All";	
					
			}
			vo.getStrHospitalListWS().beforeFirst();
			
			if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() >1) 
			{ //If the logged-in Hospital has sub-hospitals
			 
				strHospitalList = hisutil.getOptionValue(vo.getStrHospitalListWS(),"",HospComboString, false); 
			}
			 
			else if (vo.getStrHospitalListWS() != null && vo.getStrHospitalListWS().size() == 1 ) 
			{ //If the logged-in Hospital has no sub-hospitals
			
			vo.getStrHospitalListWS().beforeFirst(); strHospitalList =
			hisutil.getOptionValue(vo.getStrHospitalListWS(),"", "", false);
			}
			
			else 
			{ 
				strHospitalList = "<option value='0'>Select Value</option>";
			}
			
			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12 col-xs-12'>");
			sb.append("<div class='box box-solid box-primary'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'>"
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entries View</h3>");
			sb.append("</div></div>");
			sb.append("</div>");

			sb.append("<div class='col-md-12 col-xs-12'><div class='form-group'>");

			sb.append("<label class = 'col-sm-2 control-label'><font color='red'>*</font>From Date (Result Entry) : </label>");
			sb.append("<div class='col-sm-2'><input type = 'text' name = 'strFromDate' id= 'strFromDateId'/>");
			sb.append("</div>");

			sb.append("<label class = 'col-sm-2 control-label'><font color='red'>*</font>To Date (Result Entry) : </label>");
			sb.append("<div class='col-sm-2'><input type = 'text' name = 'strToDate' id= 'strToDateId'/>");
			sb.append("</div>");
			
			sb.append("<label class = 'col-sm-1 control-label'>Hospital : </label>");
			sb.append("<div class='col-sm-2'><select name='strPatHospCode' id='strPatHospCodeId' class=form-control select_group product style= 'height: 27;font-size: 13px;'>");
			sb.append(strHospitalList);
			sb.append("</select></div>");
			
			sb.append("<div class='col-sm-1'>");
			//sb.append("<input type='button' class='btn btn-success' onclick = 'getEntryList();'>Go");
			sb.append("<a href='#' style= 'padding:1px 6px;' class='btn btn-success' onclick='getEntryList();'><span>Go</span></a> ");
			sb.append("</div><br/>");

			sb.append("</div>");

			sb.append("<div class='box box-solid box-primary' style='margin-bottom:0px'>");
			sb.append("<div class='box-header' style='padding: 3px 0 3px 10px;'> "
					+ "<h3 class='box-title' style='font-size: 15px;'>Offline Result Entry List</h3>");
			sb.append("</div></div>");

			sb.append("<div class='table-responsive'>");
			sb.append("<table id = 'resultEntriesListTable' class='table-bordered'><thead>");
			sb.append("<tr>");
			sb.append("<th scope='col' width = '5%'>#</th>");
			sb.append("<th scope='col' width = '17%' style= 'text-align:left;'>Hospital Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Reg. No.</th>");
			sb.append("<th scope='col' width = '15%'>Name</th>");
			sb.append("<th scope='col' width = '12%' style= 'text-align:center;'>Mobile No.</th>");
			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Sample Collection Date</th>");
			sb.append("<th scope='col' width = '13%' style= 'text-align:center;'>Result Entry Date</th>");
			sb.append("<th scope='col' width = '9%' style= 'text-align:center;'>Lab 3Report</th></thead>");
			sb.append("<tbody>");

			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					sb.append("<tr>");
					sb.append("<td>" + slno++ + "</td>");
					sb.append("<td>" + ws.getString(8) + "</td>");
					sb.append("<td align='center'>" + ws.getString(1) + "</td>");
					sb.append("<td>" + ws.getString(2) + "</td>");
					sb.append("<td align='center'>" + ws.getString(4) + "</td>");
					sb.append("<td align='center'>" + ws.getString(6) + "</td>");
					sb.append("<td align='center'>" + ws.getString(7) + "</td>");
					sb.append("<td align='center'><a href='#' class='btn btn-success' onclick = 'view_Print_Slip(this,\"" + ws.getString(3)
							+ "\");'><span>View</span></a></td>"); //class='glyphicon glyphicon-download-alt'
					// sb.append("<td><button type='submit' class='btn btn-success' onclick =
					// 'view_Print_Slip(this,"+ws.getString(3)+");'>View/Print</button></td>");
				}
			}
			/*
			 * else { sb.append("<tr>");
			 * sb.append("<td>No result Entries to show</td></tr>"); }
			 */
			sb.append("</tbody><table></div></div>");
			sb.append("<div style='padding: 2px 0 3px 3px; display: block;'><span style='font-weight: bold; color: red;'>NOTE: By Default the Table shows Result Entries of the Last Week.");
			sb.append("</span></div>");
			sb.append("<div class = 'col-sm-12' style='text-align:center'>");
			sb.append("<button type='submit' class='btn btn-warning' onclick = 'cancelFunc();'>Cancel</button>");
			sb.append("</div>");
			sb.append("</div>");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
public static String printSlipTestWise(InvOfflineResultEntryVO vo) {
	System.out.println("printslip7++++++");

	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = null;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Date date = new Date();
	String prevTestCode = "";
	try {

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
			sb.append("<label>Print Date-Time:" + dateFormat.format(date) + "</label>");
			sb.append("<br></br><br></br><br></br>");
			sb.append("</div>");

			sb.append("</div>");

			// Printing the Patient's Details.
			sb.append("<div style='border: 1px solid black; border-radius: 25px; padding: 15px;'>");
			sb.append("<table width='100%' style='font-size: 12px;'> ");
			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Reg. Number: </b></label></td><td width= '23%'><b>" + vo.getPatCRNo()
					+ "</b></td>");
			sb.append("<td width= '25%'><label><b>Collection Centre: </b></label></td><td width= '25%'>"
					+ ws.getString(7) + "</td>");

			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Patient Name: </b></label></td><td width= '23%'>"+ WordUtils.capitalizeFully(ws.getString(1)) + "</td>");
			sb.append("<td width= '25%'><label><b>Sample Collection Date: </b></label></td><td width= '25%'><b>"
					+ ws.getString(9) + "</b></td>");
			sb.append("</tr>");

			sb.append("<tr>");
			sb.append("<td width= '23%'><label><b>Age / Sex: </b></label></td><td width= '23%'>" + ws.getString(3)
					+ " " + ws.getString(4) + " / " + ws.getString(2) + "</td>");
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

		while (ws.next()) {
			
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
		
		sb.append("<div style='float:right'><img src='"+vo.getStrUserSign()+"' width='150px' height='68px'/><p><b> Signature of the Pathologist</b></p></div>");
		//sb.append("<div class='footer' style='padding-top: 10px; border-top: 1px solid #ddd; font-size:13px; color: #333; margin-top: 20px; text-align: center;'>This is Computer-generated Test Report. Signature not required.</div>");
		sb.append("<div style= 'position: fixed; bottom: 9px; width: 100%; border-top: 1px solid #ddd; font-size:09px; color: #333;'>Test results relate only to item received. All reports need clinical correlation. Kindly discuss if necessary. No part of the report can be reproduced without written permission of the laboratory.<br></br><b>this is computer generated report. Signature not required.</b></div>");
		sb.append("</div>");
		sb.append("</body></html>");

	} catch (Exception e) {

		e.printStackTrace();
	}
	return sb.toString();
}

public static String getDuplicatePatientDtl(InvOfflineResultEntryVO vo) {
	System.out.println("printslip8++++++");

	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = null;
	
	try {
		
		sb.append("<div class= 'modal-body'> <table id = 'duplicatePatientListTableId'>");
		sb.append("<tr>");
		sb.append("<th style='width:5%;font-family: helvetica;padding: 1px;font-size: 12px;'></th>");
		sb.append("<th style='width:25%;font-family: helvetica;padding: 1px;font-size: 12px;'>Patient Name</th>");
		sb.append("<th style='width:15%;font-family: helvetica;padding: 1px;font-size: 12px;'>Age/Sex</th>");
		sb.append("<th style='width:25%;font-family: helvetica;padding: 1px;font-size: 12px;'>Father/Spouse Name</th>");
		sb.append("<th style='width:15%;font-family: helvetica;padding: 1px;font-size: 12px;'>Mobile No.</th>");
		sb.append("<th style='width:5%;font-family: helvetica;padding: 1px;font-size: 12px;'></th>");
		sb.append("</tr>");
		
		ws= vo.getDupPatListWS();
		String radioBtn =""; 
		while(ws.next()) {
			radioBtn = ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"$"+ws.getString(6)+"$"+ws.getString(7)+"$"+ws.getString(9);
			sb.append("<tr>");
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><input type='radio' id='dupPatid' name='dupPat' value='"+radioBtn+"' checked></td>"); //"+i+"
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(2)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(4)+ " "+ws.getString(5)+" / "+ws.getString(3)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(7)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'>"+ws.getString(6)+"</td>");
			sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' id='dupPatGoid' name='dupPatGo' value='"+radioBtn+"' onclick = 'switchToAlreadyRegistered();'><span>Go</span></a></td>"); //"+i+"
			sb.append("</tr>");
		}
		
		sb.append("</table></div>");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return sb.toString();
}

public static String getAllPatList(InvOfflineResultEntryVO vo) {
	System.out.println("printslip9+++++++");
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
			radioBtn = ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"$"+ws.getString(6)+"$"+ws.getString(11)+"$"+ws.getString(12)+"$"+ws.getString(7);
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
		sb.append("<td style= 'font-family: helvetica;padding: 1px;font-size: 12px;'><a href='#' class='btn btn-success' style='height:25px;padding: 3px 6px;font-size: 12px;' id='multiPatGoid' name='multiPatGo' onclick = 'getPatDtl();'><span>Go</span></a>");  //value='"+i+"'
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

public static String getAllPatListResultEntry(InvOfflineResultEntryVO vo) {
	System.out.println("printslip10+++++");
	
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

}