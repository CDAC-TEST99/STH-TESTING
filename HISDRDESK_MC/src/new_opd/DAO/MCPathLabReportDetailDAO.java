package new_opd.DAO;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import new_opd.transaction.controller.fb.MCPathLabReportDetailFB;


public class MCPathLabReportDetailDAO {

	/*
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

					
//					  if(i>0) { if(3%(i)==0) { if(j>1)
//					  sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>"); }
//					  }else sb.append("<div class='row'  id='1-chunk' >");
					 

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

					
//					  if(i>0) { if(3%(i)==0) { if(j>1) sb.append("</div>"); j++; }} else
//					  sb.append("</div>");
					 
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
	
	
	public static void saveIssueDtls(MCPathLabReportDetailFB fb) throws Exception {

		HisDAO dao = null;

		String storeId = "";
		String storeName = "";

		try {

			dao = new HisDAO("", "");
			String query = "";

			if (fb.getStrDrugDetailsHidden() != null)
				for (int i = 0; i < fb.getStrDrugDetailsHidden().length; i++) {

					// 0.store_id, 1.item_id, 2.store_name, 3.item_name, 4.itembrand_id, 5.batch_no,
					// 6.expiry_date, 7.manuf_date, 8.inhand_qty, 9.hstnum_rate, 10.hstnum_saleprice
					// , 11.qty unit ,
					// 12.rate unit , 13.qty unit name, 14.request qty, 15.issue qty
					String[] drugDtls = fb.getStrDrugDetailsHidden()[i].split("\\^");

					
					String strExpiry = "";
					String strManuf = "";
					
					if(drugDtls[6].trim().length() > 4) {
						strExpiry = "to_date(? , 'dd/Mon/yyyy')";
						strManuf = "to_date(? , 'dd/Mon/yyyy')";
					}else {
						
						strExpiry = "null";
						strManuf = "null";
						
					}
					
					 
					
					
					  query = " INSERT INTO ahiscl.sstt_eaushadhi_issue_item_dtl("
							+ "	hstnum_store_id, hststr_store_name, hstnum_issue_no, hstnum_item_id, hstnum_itembrand_id, hststr_batch_sl_no, "
							+ "	hststr_item_name, gnum_hospital_code, hstdt_issue_date, hstnum_rate, hstnum_rate_unitid, "
							+ "	hstnum_issue_qty, hstnum_issueqty_unitid, hstnum_inhand_qty, hstnum_inhand_qty_unitid, "
							+ "	hstnum_unit_name,  gstr_remarks, gnum_isvalid, "
							+ "	hrgnum_puk, gdt_entry_date , hstdt_manuf_date, hstdt_expiry_date)"
							+ "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, "
							+" ?, 1, ?, sysdate , "+ strManuf+","+strExpiry+" )";
					
					
					int queryIndex = dao.setQuery(query);

					storeId = drugDtls[0];
					storeName = drugDtls[2];

					dao.setQryValue(queryIndex, 1, drugDtls[0]); // hstnum_store_id
					dao.setQryValue(queryIndex, 2, drugDtls[2]); // hststr_store_name
					dao.setQryValue(queryIndex, 3, fb.getStrIssueNo()); // hstnum_issue_no
					dao.setQryValue(queryIndex, 4, drugDtls[1]); // hstnum_item_id
					dao.setQryValue(queryIndex, 5, drugDtls[4]); // hstnum_itembrand_id
					dao.setQryValue(queryIndex, 6, drugDtls[5]); // hststr_batch_sl_no
					dao.setQryValue(queryIndex, 7, drugDtls[3]); // hststr_item_name
					dao.setQryValue(queryIndex, 8, fb.getStrHospitalCode()); // gnum_hospital_code
					dao.setQryValue(queryIndex, 9, drugDtls[9]); // hstnum_rate
					dao.setQryValue(queryIndex, 10, drugDtls[12]); // hstnum_rate_unitid
					dao.setQryValue(queryIndex, 11, drugDtls[15]); // hstnum_issue_qty
					dao.setQryValue(queryIndex, 12, drugDtls[11]); // hstnum_issueqty_unitid
					dao.setQryValue(queryIndex, 13, drugDtls[8]); // hstnum_inhand_qty
					dao.setQryValue(queryIndex, 14, drugDtls[11]); // hstnum_inhand_qty_unitid
					dao.setQryValue(queryIndex, 15, drugDtls[13]); // hstnum_inhand_qty_unitid
					dao.setQryValue(queryIndex, 16, drugDtls[16]); // gstr_remarks
					dao.setQryValue(queryIndex, 17, fb.getStrCrNo()); // HRGNUM_PUK
					
					if(! "null".equals(strManuf)) {
						dao.setQryValue(queryIndex, 18, "01/" + drugDtls[7]); // hstdt_manuf_date
						dao.setQryValue(queryIndex, 19, "27/" + drugDtls[6]); // hstdt_expiry_date
					}
					
				 
					dao.execute(queryIndex, 0);

				}

			String query2 = "INSERT INTO ahiscl.sstt_eaushadhi_issue_dtl("
					+ "	hstnum_store_id, hststr_store_name, hstnum_issue_no, gnum_hospital_code, sstnum_item_cat_no, "
					+ "	hstdt_issue_date, hrgnum_puk, hstdt_financial_start_date, hstdt_financial_end_date, "
					+ "	gdt_entry_date, gnum_seatid, gnum_isvalid)"
					+ "	VALUES (?, ?, ?, ?, 10, sysdate, ?, to_date(?,'dd-Mon-yyyy'), to_date(?,'dd-Mon-yyyy'), sysdate, ?, 1)";

			int queryIndex = dao.setQuery(query2);

			dao.setQryValue(queryIndex, 1, storeId); // hstnum_store_id
			dao.setQryValue(queryIndex, 2, storeName); // hstnum_store_id
			dao.setQryValue(queryIndex, 3, fb.getStrIssueNo()); // hstnum_issue_no
			dao.setQryValue(queryIndex, 4, fb.getStrHospitalCode()); // gnum_hospital_code
			dao.setQryValue(queryIndex, 5, fb.getStrCrNo()); // HRGNUM_PUK

			dao.setQryValue(queryIndex, 6, getFinancialYearStartDate()); // hstdt_financial_start_date
			dao.setQryValue(queryIndex, 7, getFinancialYearEndDate()); // hstdt_financial_end_date
			dao.setQryValue(queryIndex, 8, fb.getStrSeatId()); // gnum_seatid

			dao.execute(queryIndex, 0);
			
			
			String query3 = "update hrgt_daily_patient_dtl "
					+ "set hstnum_is_issued_to_patient = 1, hstdt_issue_to_patient_date = sysdate"
					+ " where gnum_isvalid = 1 and gnum_hospital_code = ? and hrgnum_puk = ? "
					+ "AND trunc(gdt_entry_date) = trunc(decode(?,null,sysdate,to_date(?))) "
					+ "and hrgnum_is_confirmed = 2 "
					+ "AND hgnum_deptunitcode IN (select hgnum_deptunitcode from hgbt_unit_mst "
					+ "								where gnum_isvalid=1 and hgnum_isgeneral in (1,2,3) "
					+ "								and gnum_hospital_code = ?)";

			int queryIndex1 = dao.setQuery(query3);
			
			String presDate = fb.getStrPresDate().equals("")?null:fb.getStrPresDate();

			dao.setQryValue(queryIndex1, 1, fb.getStrHospitalCode()); // gnum_hospital_code
			dao.setQryValue(queryIndex1, 2, fb.getStrCrNo()); // HRGNUM_PUK
			dao.setQryValue(queryIndex1, 3, presDate); // prescription Date
			dao.setQryValue(queryIndex1, 4, presDate); // prescription Date
			dao.setQryValue(queryIndex1, 5, fb.getStrHospitalCode()); // gnum_hospital_code

			dao.execute(queryIndex1, 0);

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
	
	
	public static void getPatientsDtl(MCPathLabReportDetailFB fbObj) {
		 
		HisDAO daoObj = null;
		WebRowSet ws = null;

		
		
		String strProcName = "{call pkg_inv_view.proc_get_aac_path_lab_details(?,?,?,?, ?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "IssueToPatientTransMcDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "4", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", fbObj.getStrHospitalCode(), 2);
			//daoObj.setProcInValue(nProcIndex, "seatid", fbObj.getStrSeatId(), 3);
			daoObj.setProcInValue(nProcIndex, "p_crno", "0", 3);
			daoObj.setProcInValue(nProcIndex, "p_reqno", "0", 4);
			daoObj.setProcInValue(nProcIndex, "p_reqdate", fbObj.getStrPresDate()==null||fbObj.getStrPresDate().trim().equals("")?"0":fbObj.getStrPresDate(), 5);//Handover Date
//			System.out.println("fbObj.getStrPresDate()>>>"+fbObj.getStrPresDate());
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
			fbObj.setStrMsgString("IssueToPatientTransMcDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static void saveHardCopyRecdDetails(MCPathLabReportDetailFB fb) throws Exception {

		HisDAO dao = null;
		try {
			dao = new HisDAO("", "");
			String proc_name6="{call pkg_inv_dml.Dml_mc_pathlab_dtl(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}"; //19 values --By Vivek Aggarwal as on 26-Sep-2023
			int procIndex6 =0;
					procIndex6 = dao.setProcedure(proc_name6);
					
					for(int z=0; z<fb.getStrIsHardCopyRecd().length;z++)
					{
						//crNo^requisitionNo^fileName^isHardCopyRecd(the saved one)^strTestCodes
//						System.out.println("str::"+fb.getStrHiddenDtl()[z]);
						dao.setProcInValue(procIndex6, "p_modval", "4", 1);
						dao.setProcInValue(procIndex6, "p_hospCode", fb.getStrHospitalCode(), 2);
						dao.setProcInValue(procIndex6, "p_hospName", "0", 3);
						dao.setProcInValue(procIndex6, "p_crNo", fb.getStrHiddenDtl()[z].split("\\^")[0], 4);
						dao.setProcInValue(procIndex6, "p_patient_name", "0", 5);
						dao.setProcInValue(procIndex6, "p_age", fb.getStrIsHardCopyRecd()[z], 6); // sending hardcopy_recd_flag in p_age
						dao.setProcInValue(procIndex6, "p_mobNo", "0", 7);
						dao.setProcInValue(procIndex6, "p_gender", "0", 8);
						dao.setProcInValue(procIndex6, "p_episode_code", "0", 9);
						dao.setProcInValue(procIndex6, "p_reqDate", "0", 10);
						dao.setProcInValue(procIndex6, "p_reqNo", fb.getStrHiddenDtl()[z].split("\\^")[1], 11);
						dao.setProcInValue(procIndex6, "p_visitNo", "0", 12);
						dao.setProcInValue(procIndex6, "p_testCode", fb.getStrHiddenDtl()[z].split("\\^")[4], 13); 
						dao.setProcInValue(procIndex6, "p_testName", "0", 14);
						dao.setProcInValue(procIndex6, "p_vialNo", fb.getStrHiddenDtl()[z].split("\\^")[2], 15);// sending fileName in p_vialNo
						dao.setProcInValue(procIndex6, "p_handover_to", "0", 16);
						dao.setProcInValue(procIndex6, "p_handover_datetime", "0", 17);
						dao.setProcInValue(procIndex6, "p_handover_person_mobile", "0", 18);
						
						dao.setProcOutValue(procIndex6, "err", 1, 19);

						// dao.executeProcedure(procIndex1);
						dao.execute(procIndex6, 1);
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
	public static void getPresDtls(MCPathLabReportDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call Pkg_Mms_View.proc_issue_to_pat_dtl(?,?,?,?,?,	?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "IssueToPatientTransMcDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "modval", "2", 1);
			daoObj.setProcInValue(nProcIndex, "hosp_code", fbObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "seatid", fbObj.getStrSeatId(), 3);
			daoObj.setProcInValue(nProcIndex, "crNo", fbObj.getStrCrNo(), 4);
			daoObj.setProcInValue(nProcIndex, "p_date", fbObj.getStrPresDate()==null||fbObj.getStrPresDate().trim().equals("")?"0":fbObj.getStrPresDate(), 5);
			
			daoObj.setProcOutValue(nProcIndex, "err", 1, 6);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2, 7);

			daoObj.executeProcedureByPosition(nProcIndex);

			strErr = daoObj.getString(nProcIndex, "err");

			if (strErr == null)
				strErr = "";

			if (strErr.equals("")) {

				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				fbObj.setStrPresDtlsWs(ws);

			} else {
				throw new Exception(strErr);
			}

		} catch (Exception e) {
			e.printStackTrace();
			fbObj.setStrMsgString("IssueToPatientTransMcDAO.getPresDtls() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}*/
	
	
	
	

}
