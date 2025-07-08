package new_opd.DAO;

import java.util.Calendar;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import new_opd.transaction.controller.fb.MCPathLabSampleDrawnDetailFB;

public class MCPathLabSampleDrawnDetailDAO {

	public static String getPreviousIssueDtls(String hospitalCode, String crNo) {

		StringBuffer sb = new StringBuffer();

		HisDAO dao = null;

		try {

			dao = new HisDAO("", "");
			String query = " SELECT hstnum_issue_no , to_char(hstdt_issue_date,'dd-Mon-yyyy HH:mi')  , hstnum_store_id , hststr_store_name  "
					+ " FROM ahiscl.sstt_eaushadhi_issue_dtl where gnum_isvalid = 1 " + " and gnum_hospital_code = ? "
					+ " and hrgnum_puk = ? " + " order by hstdt_issue_date desc ";

			int queryIndex = dao.setQuery(query);

			dao.setQryValue(queryIndex, 1, hospitalCode);
			dao.setQryValue(queryIndex, 2, crNo);

			WebRowSet ws = dao.executeQry(queryIndex);

			int i = 0, j = 1;

			if (ws != null && ws.size() > 0) {
				sb.append("<div class='row'>");

				sb.append(
						"<div class='col-sm-1'><i class='fas fa-angle-double-left' onclick='nxtChunk(\"prev\")'></i></div>");
				sb.append("<div class='col-sm-10' id='chunks'>");

				while (ws.next()) {

					if (i == 0) {
						sb.append("<div class='row'  id='0-chunk' >");
					}
					if (i == (3 * j)) {
						sb.append("<div class='row'  id='" + j + "-chunk' style='display:none;'>");
						j++;
					}

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1)
					 * sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>"); }
					 * }else sb.append("<div class='row'  id='1-chunk' >");
					 */

					sb.append("<div class='col-sm-4'>");
					String strIssueNo = ws.getString(1);
					String strIssueDate = ws.getString(2);
					String strIssueSoreID = ws.getString(3);
					String strIssueSore = ws.getString(4);
					if (strIssueNo == null)
						strIssueNo = "----";
					if (strIssueDate == null)
						strIssueDate = "----";

					sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo" + i + "' value=" + strIssueNo
							+ " >");
					sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID" + i + "' value="
							+ strIssueSoreID + " >");
					sb.append(
							"<p align='center'><i class='fa fa-folder fa-2x' style='color:bisque' onclick='callIssuePop(this)'></i></p>");
					sb.append(
							"<a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:rgba(75,75,75, 0.7)' onClick='getIssuePopUp(this, \""
									+ i + "\" );'><p align='center'>");
					sb.append(strIssueNo + "</p><p align='center'>" + strIssueDate + "</p><p align='center'>"
							+ strIssueSore);
					sb.append("</p></a>");
					sb.append("</div>");

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1) sb.append("</div>"); j++; }} else
					 * sb.append("</div>");
					 */
					// if(ws.size()>=((3*j)-1))
					if (i == ((3 * j) - 1)) {
						sb.append("</div>");

					} else {
						if (i == (ws.size() - 1))
							sb.append("</div>");
					}

					i++;

				}
				sb.append(
						"</div><div class='col-sm-1'><i class='fas fa-angle-double-right' onclick='nxtChunk(\"nxt\")'></i></div>");

				sb.append("</div>");
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' align='center' colspan='4'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");
				sb.append("</table>");

			}

		} catch (Exception e) {
			e.printStackTrace();
			;
			throw new HisException("Issue Transaction", "IssueTransHLP .getIssueDetails() -->", e.getMessage());

		}

		return sb.toString();
	}

	
	public static String getIssueItemDtls(String hospitalCode , String issueNo) {
		
		HisDAO dao = null;
		StringBuffer sb = new StringBuffer();
		
		String previousItem = "";
		String previousUnit = "";
		String itemDetails = "";
		float qtyTotal = 0.0f;
		
		try {

			dao = new HisDAO("", "");
			String query = " select hststr_item_name , hststr_batch_sl_no ,  hstnum_issue_qty , hstnum_unit_name" + 
								" 	FROM ahiscl.sstt_eaushadhi_issue_item_dtl " + 
								"	where gnum_isvalid = 1 " + 
								"	and gnum_hospital_code = ? " + 
								"	and hstnum_issue_no = ? " + 
								"	order by hststr_item_name" ;
								
		
			int queryIndex = dao.setQuery(query);
			dao.setQryValue(queryIndex, 1, hospitalCode);
			dao.setQryValue(queryIndex, 2, issueNo);

			WebRowSet ws = dao.executeQry(queryIndex);

			  if (ws != null && ws.size() > 0) 
			  {
				  sb.append("<table width='100%' class='table'><tr><td><div style='text-align:left'>Issue Item Details</div></td><td ><div style='text-align:left'>"
				  		+ " <button type=\"button\" class=\" btn btn-info btn-circle\" id=\"printCardfrmTopbtnID\" onclick=\"printIssueVoucher();\" "
				  		+ " style=\"padding: .175rem .35rem; line-height: 0.8\" tabindex=\"0\"><i class=\"fa fa-print fa-bolder\" aria-hidden=\"true\" "
				  		+ " title=\"Print Issue Voucher\" style=\"font-size: 16px;\"></i></button></div></td></tr></table>");
			  }else {
				  sb.append("<div>Issue Item Details</div>");
			  }
  
			   sb.append("<table width='100%' class='table'>");
			   sb.append("<thead>");
			   sb.append("<tr>");
			   sb.append("<th scope=\"col\" >Drug Name</th>");
			   sb.append("<th scope=\"col\" >Batch</th>");
			   sb.append("<th scope=\"col\" >Issue Qty.</th>");
			   sb.append("</tr></thead>");
			   sb.append("<tbody>");
		 
				  
					  if (ws != null && ws.size() != 0) 
					  {				     	
						while(ws.next())
		                 {
						    	
										String strItemName     = ws.getString(1).trim();
										String strBatch     = ws.getString(2).trim();
										String  strIssueQty = ws.getString(3).trim(); 
										String  strIssueQtyUnit = ws.getString(4).trim(); 
									  
										if(!previousItem.equals(strItemName)) {
											
											if(previousItem.trim().length() > 0) {
												
												if(itemDetails.length() > 0) {
													itemDetails = itemDetails+"@@"+previousItem+"^"+qtyTotal+" "+previousUnit;
												}else {
													itemDetails = previousItem+"^"+qtyTotal+" "+previousUnit;
												}
											
												qtyTotal = 0f;
											}											

											qtyTotal = qtyTotal + Float.parseFloat(strIssueQty);
											previousItem = strItemName;
											previousUnit = strIssueQtyUnit;
											
											
											
										}else {
											
											qtyTotal = qtyTotal + Float.parseFloat(strIssueQty);
										 		
										}
										
			  						    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
			  						  if(strBatch == null || strBatch.equals("")) strBatch = "-----";
			  					    if(strIssueQty == null || strIssueQty.equals("")) strIssueQty = "0";
			  	  				        if(strIssueQtyUnit == null || strIssueQtyUnit.equals("")) strIssueQtyUnit = "-----";
			  	  				       
									    sb.append("<tr>");
									    sb.append("<td  width='55%'>");
									    sb.append(strItemName);
									    sb.append("</td>");
									    sb.append("<td width='20%'>");
									    sb.append(strBatch);
									    sb.append("</td>");
									    sb.append("<td width='25%'>");
									    sb.append(strIssueQty +" "+strIssueQtyUnit);
									    sb.append("</td>");
									    sb.append("</tr>");
			  	                      
			  				        }
						
						 if(itemDetails.length() > 0) {
								itemDetails = itemDetails+"@@"+previousItem+"^"+qtyTotal+" "+previousUnit;
							}else {
								itemDetails = previousItem+"^"+qtyTotal+" "+previousUnit;
							}
						
						  sb.append("</tbody></table><input type='hidden' id='itemDetailsHiddenForPrint' name='itemDetailsHiddenForPrint' value='"+itemDetails+"' >");
						 					 						  
							  }	
					
					      else
					      {
					    	  sb.append("<tr><td><font color='red'>No Matching Record Found</font></td></tr>");
			 			     
					      } 	 
				    
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new HisException("Issue Transaction", "IssueTransHLP .getIssueDetails() -->", e.getMessage());

		}

		return sb.toString();
			
	}
	
	
	public static void saveVialDtls(MCPathLabSampleDrawnDetailFB fb) throws Exception {

		HisDAO dao = null;
		try {
			dao = new HisDAO("", "");
			String proc_name6="{call pkg_inv_dml.Dml_mc_pathlab_dtl(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}"; //19 values --By Vivek Aggarwal as on 04-Sep-2023
			int procIndex6 =0;
			if (fb.getStrVialNo() != null && fb.getStrVialNo().length>0)
			{
				for (int z = 0; z < fb.getStrVialNo().length; z++) {
					procIndex6 = dao.setProcedure(proc_name6);
					dao.setProcInValue(procIndex6, "p_modval", "2", 1);
					dao.setProcInValue(procIndex6, "p_hospCode", fb.getStrHiddenOtherDtl().split("\\^")[1], 2);
					dao.setProcInValue(procIndex6, "p_hospName", "0", 3);
					dao.setProcInValue(procIndex6, "p_crNo", fb.getStrHiddenOtherDtl().split("\\^")[0], 4);
					dao.setProcInValue(procIndex6, "p_patient_name", "0", 5);
					dao.setProcInValue(procIndex6, "p_age", "0", 6);
					dao.setProcInValue(procIndex6, "p_mobNo", "0", 7);
					dao.setProcInValue(procIndex6, "p_gender", "0", 8);
					dao.setProcInValue(procIndex6, "p_episode_code", "0", 9);
					dao.setProcInValue(procIndex6, "p_reqDate", fb.getStrHiddenOtherDtl().split("\\^")[3], 10);
					dao.setProcInValue(procIndex6, "p_reqNo", fb.getStrHiddenOtherDtl().split("\\^")[2], 11);
					dao.setProcInValue(procIndex6, "p_visitNo", "0", 12);
					dao.setProcInValue(procIndex6, "p_testCode", fb.getStrTestCode()[z].split("\\^")[0], 13); // testCode^ContainerId
					dao.setProcInValue(procIndex6, "p_testName", "0", 14);
					//System.out.println("strVialNo::"+fb.getStrVialSeries()+fb.getStrVialNo()[z]);
					dao.setProcInValue(procIndex6, "p_vialNo",fb.getStrVialNo()[z], 15);
					dao.setProcInValue(procIndex6, "p_handover_to", "0", 16);
					dao.setProcInValue(procIndex6, "p_handover_datetime", "0", 17);
					dao.setProcInValue(procIndex6, "p_handover_person_mobile", "0", 18);
					
					dao.setProcOutValue(procIndex6, "err", 1, 19);

					// dao.executeProcedure(procIndex1);
					dao.execute(procIndex6, 1);
				}
			}
			
			dao.fire();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	/*
	private static String getFinancialYearStartDate() {

		int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		int CurrentMonth = (Calendar.getInstance().get(Calendar.MONTH) + 1);
		String financiyalYearFrom = "";

		if (CurrentMonth < 4) {
			financiyalYearFrom = "01-Apr-" + (CurrentYear - 1);

		} else {
			financiyalYearFrom = "01-Apr-" + (CurrentYear);

		}
		return financiyalYearFrom;
	}

	private static String getFinancialYearEndDate() {

		int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
		int CurrentMonth = (Calendar.getInstance().get(Calendar.MONTH) + 1);

		String financiyalYearTo = "";
		if (CurrentMonth < 4) {

			financiyalYearTo = "31-Mar-" + (CurrentYear);
		} else {

			financiyalYearTo = "31-Mar-" + (CurrentYear + 1);
		}

		return financiyalYearTo;
	}
	*/
	
	
	public static void getPatientsDtl(MCPathLabSampleDrawnDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Inv_View.proc_get_aac_path_lab_details(?,?,?,?,?,	?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "MCPathLabSampleDrawnDetailDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "1", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", fbObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "p_crno", "0" , 3);//fbObj.getStrSeatId()
			daoObj.setProcInValue(nProcIndex, "p_reqno", "0", 4);
			daoObj.setProcInValue(nProcIndex, "p_reqDate", fbObj.getStrVisitDate()==null||fbObj.getStrVisitDate().trim().equals("")?"0":fbObj.getStrVisitDate(), 5);
			daoObj.setProcInValue(nProcIndex, "p_visitno", "0", 6);
			daoObj.setProcInValue(nProcIndex, "p_testcode", "0", 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				fbObj.setStrPatDtlsWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fbObj.setStrMsgString("MCPathLabSampleDrawnDetailDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	public static void getPrescribedTestDtl(MCPathLabSampleDrawnDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Inv_View.proc_get_aac_path_lab_details(?,?,?,?,?,	?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "MCPathLabSampleDrawnDetailDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", fbObj.getStrHiddenOtherDtl().split("\\^")[1], 2);
			daoObj.setProcInValue(nProcIndex, "p_crno", fbObj.getStrHiddenOtherDtl().split("\\^")[0] , 3);//fbObj.getStrSeatId()
			daoObj.setProcInValue(nProcIndex, "p_reqno", fbObj.getStrHiddenOtherDtl().split("\\^")[2], 4);
			daoObj.setProcInValue(nProcIndex, "p_reqDate", fbObj.getStrHiddenOtherDtl().split("\\^")[3], 5);
			daoObj.setProcInValue(nProcIndex, "p_visitno", "0", 6);
			daoObj.setProcInValue(nProcIndex, "p_testcode", "0", 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				fbObj.setStrPatTestDtlsWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fbObj.setStrMsgString("MCPathLabSampleDrawnDetailDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void checkDuplicateVial(MCPathLabSampleDrawnDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Inv_View.proc_get_aac_path_lab_details(?,?,?,?,?,	?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "MCPathLabSampleDrawnDetailDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "6", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", "0", 2);
			daoObj.setProcInValue(nProcIndex, "p_crno", "0" , 3);//fbObj.getStrSeatId()
			daoObj.setProcInValue(nProcIndex, "p_reqno", "0", 4);
			daoObj.setProcInValue(nProcIndex, "p_reqDate", "0", 5);
			daoObj.setProcInValue(nProcIndex, "p_visitno", "0", 6);
			//System.out.println("DAOOO"+ fbObj.getStrCompleteVial());
			daoObj.setProcInValue(nProcIndex, "p_testcode", fbObj.getStrCompleteVial(), 7);
			daoObj.setProcOutValue(nProcIndex, "err", 1, 8);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 9);

			daoObj.executeProcedureByPosition(nProcIndex);
			//System.out.println("FORMBEAN +"+fbObj.getCurrentVialNo());
			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				fbObj.setStrPatTestDtlsWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fbObj.setStrMsgString("MCPathLabSampleDrawnDetailDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}

}
