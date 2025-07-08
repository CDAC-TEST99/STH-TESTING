package HisWeb.dao;

import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.json.JsonObject;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;

public class opdDrDeskDao {

	public static void SaveDrugAdviceData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_OpdDesk_dml.proc_insert_drdesk_data(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?, ?,?)}";
		
		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("DrugCodeCat "+object.get("DrugCodeCat"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			//JSONArray DrugObjArray = (JSONArray) object.get("DrugCodeCat");
			
			JSONArray DrugObjArray = (JSONArray) object.get("DrugJsonArray");
			
			
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");

			if (DrugObjArray != null && DrugObjArray.length()>0) {
				
				for (int i = 0; i < DrugObjArray.length(); i++) {
					
					
					JSONObject drugObj= DrugObjArray.getJSONObject(i);
					
					JSONArray arrStatusWiseQty= drugObj.getJSONArray("drugDispenceStatusWiseQty");
					for (int j = 0; j < arrStatusWiseQty.length(); j++) {
						int indx=1;
						JSONObject statusJson= arrStatusWiseQty.getJSONObject(j);
						procIndex1 = dao.setProcedure(proc_name1);
						dao.setProcInValue(procIndex1, "modval", "1", indx++);
						dao.setProcInValue(procIndex1, "puk", Crno, indx++);
						dao.setProcInValue(procIndex1, "episodecode", EpisodeCode, indx++);
						dao.setProcInValue(procIndex1, "slno", String.valueOf(i + 1), indx++);
						dao.setProcInValue(procIndex1, "admno", String.valueOf(i), indx++);
						dao.setProcInValue(procIndex1, "visitno", EpisodeVisitNo, indx++);
						
						dao.setProcInValue(procIndex1, "itemid", drugObj.getString("drugId") , indx++);
	
						dao.setProcInValue(procIndex1, "doseid", drugObj.getString("drugDosageId"), indx++);
	
						dao.setProcInValue(procIndex1, "seatid", seatId, indx++);
	
						dao.setProcInValue(procIndex1, "doseName", drugObj.getString("drugDosage"), indx++);
	
						dao.setProcInValue(procIndex1, "routeid", "0", indx++);
	
						dao.setProcInValue(procIndex1, "frqid", drugObj.getString("drugFrequencyId"), indx++);
	
						dao.setProcInValue(procIndex1, "days", drugObj.getString("drugDays"), indx++);
	
						dao.setProcInValue(procIndex1, "startdate", drugObj.getString("drugStartDate"), indx++);
	
						dao.setProcInValue(procIndex1, "endDate", drugObj.getString("drugStartDate"), indx++);
	
						dao.setProcInValue(procIndex1, "remarks", drugObj.getString("drugInstructions"), indx++);
	
						dao.setProcInValue(procIndex1, "itemName", drugObj.getString("drugName"), indx++);
	
						dao.setProcInValue(procIndex1, "hospcode", hosp_code, indx++);
	
						dao.setProcInValue(procIndex1, "empid", "0", indx++);
							
					
						dao.setProcInValue(procIndex1, "doseqty", statusJson.getString("statusQty"), indx++);
	
						dao.setProcInValue(procIndex1, "brandId", drugObj.getString("drugBrandId"), indx++);
	
						dao.setProcInValue(procIndex1, "itemtypeid", drugObj.getString("itemTypeId"), indx++);
	
						dao.setProcInValue(procIndex1, "frequencyname", drugObj.getString("drugFrequency"), indx++);
	
						dao.setProcInValue(procIndex1, "adminname", "", indx++);
	
						dao.setProcInValue(procIndex1, "deptunitcode", PatCompleteGeneralDtl.split("#")[5], indx++);
						dao.setProcInValue(procIndex1, "deptcode", PatCompleteGeneralDtl.split("#")[6], indx++);
						
						dao.setProcInValue(procIndex1, "prgid", drugObj.getString("programId"), indx++);
						
						dao.setProcInValue(procIndex1, "avlstock", drugObj.getString("drugQuan"), indx++);
						
						dao.setProcInValue(procIndex1, "drugstatus", statusJson.getString("status"), indx++);
					
						dao.setProcOutValue(procIndex1, "err", 1, indx++);
	
						dao.execute(procIndex1, 1);
					}// for j ends here

				}// for i end here

			}

		} catch (Exception e) {
			throw e;
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void SaveInvData(String JsonData, HisDAO dao) throws Exception {

//		String err = "";
		String proc_name3 = "{call pkg_inv_dml.proc_insert_hivt_reqisition_header(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";// hivt_requisition_header,hivt_requisition_header_new
		String proc_name1 = "{call pkg_inv_dml.proc_insert_hivt_requisition_dtl(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}"; // hivt_requisition_dtl,hivt_requisition_dtl_new
		String proc_name2 = "{? = call pkg_inv_unique_no_generation.generate_save_requisitionno(?, ?)}";

		int procIndex1 = 0;
//        int procIndex2 = 0;
		int procIndex3 = 0;

		int funcIndex = 0;
		String strRequisitionNo = "";

		String strRequisitionDNo = "";

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("DrugCodeCat "+object.get("DrugCodeCat"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("pat_Name"+object.get("pat_Name"));
			// System.out.println("patGender"+object.get("patGender"));
			// System.out.println("patAge"+object.get("patAge"));
			// System.out.println("patCat"+object.get("patCat"));
			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			// String hospName = (String) object.get("hospName");
			String patName = (String) object.get("pat_Name");
			String patGender = (String) object.get("patGender");
			String patAge = (String) object.get("patAge");
			// String patMob = "1";
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			JSONArray InvesObjArray = (JSONArray) object.get("InvTestCode");
			StringBuffer sb = new StringBuffer();
			JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			String strInvestgationNote = (String) object.get("strInvestgationNote");

			if (ReasonOfVisit != null) {

				for (int i = 0; i < ReasonOfVisit.length(); i++) {
					sb.append((ReasonOfVisit.get(i).toString().split("\\^")[1]).replaceAll(";", "") + ";");
				}
			}
			/*
			 * int index =Arrays.asList(InvesObjArray).indexOf("0^0^0^0^0");
			 * System.out.println("Index Value "+index);
			 */
			HashMap<String, List> map = null;
			HashMap<String, List> bldMap = null;
			List<String> l1 = null;

			map = new HashMap<String, List>();
			// if(InvesObjArray.length() > 0 ){
			if (InvesObjArray != null && InvesObjArray.length() > 0) {
				for (int j = 0; j < InvesObjArray.length(); j++) {
					// System.out.println(InvesObjArray.get(j));
					// System.out.println(InvesObjArray.get(j) != null);
					// System.out.println(!InvesObjArray.get(j).toString().trim().equals("null"));

					if (InvesObjArray.get(j) != null && !InvesObjArray.get(j).toString().trim().equals("null")) {

						String tmpInv = (String) InvesObjArray.get(j);
						String labCode = tmpInv.split("\\^")[1];
						// System.out.println("labCode1:::"+labCode);
						l1 = new ArrayList<String>();
						for (int k = 0; k < InvesObjArray.length(); k++) {
							if (InvesObjArray.get(k) != null
									&& !InvesObjArray.get(k).toString().trim().equals("null")) {

								String tmpInv1 = (String) InvesObjArray.get(k);
								// System.out.println("labCode2:::"+labCode);

								if (labCode.equalsIgnoreCase(tmpInv1.split("\\^")[1])) {
									l1.add(tmpInv1.split("\\^")[0] + "^" + tmpInv1.split("\\^")[2] + "^"
											+ tmpInv1.split("\\^")[3] + "^" + tmpInv1.split("\\^")[6] + "^"
											+ tmpInv1.split("\\^")[7] + "^" + tmpInv1.split("\\^")[5]);
								}
							}

						}
						map.put(labCode, l1);
					}

				}
				// System.out.println("MAP::::::::::::\n"+map);
				// System.out.println("List:::::::::::\n"+l1);

				if (map != null) {
					bldMap = new HashMap<>();

					for (Map.Entry m : map.entrySet()) {
						funcIndex = dao.setFunction(proc_name2);
						dao.setFuncInValue(funcIndex, 2, hosp_code);
						dao.setFuncInValue(funcIndex, 3, m.getKey().toString());
						dao.setFuncOutValue(funcIndex, 1);
						dao.executeFunction(funcIndex);
						strRequisitionNo = dao.getFuncString(funcIndex);

						bldMap.put(strRequisitionNo, (ArrayList<?>) m.getValue());
						// System.out.println("RequisitionNo::::::::"+strRequisitionNo);
						// System.out.println("Array List :::: "+m.getValue());

						procIndex3 = dao.setProcedure(proc_name3);
						dao.setProcInValue(procIndex3, "hmode", "4", 1);
						dao.setProcInValue(procIndex3, "req_no", strRequisitionNo, 2);

						dao.setProcInValue(procIndex3, "puk_no", Crno, 3);
						dao.setProcInValue(procIndex3, "hcode", hosp_code, 4);
						// dao.setProcInValue(procIndex3, "visitno",
						// PatCompleteGeneralDtl.split("#")[4],5);
						dao.setProcInValue(procIndex3, "visitno", EpisodeVisitNo, 5);
						dao.setProcInValue(procIndex3, "labcode", m.getKey().toString(), 6);

						dao.setProcInValue(procIndex3, "isconfidential", "0", 7);
						dao.setProcInValue(procIndex3, "reqheader_status", "1", 8);
						dao.setProcInValue(procIndex3, "seatid", seatId, 9);
						dao.setProcInValue(procIndex3, "episode_code", EpisodeCode, 10);
						dao.setProcInValue(procIndex3, "patname", patName, 11);
						dao.setProcInValue(procIndex3, "requisition_type", "1", 12);

						dao.setProcInValue(procIndex3, "dob", "", 13);
						dao.setProcInValue(procIndex3, "visit_date", PatCompleteGeneralDtl.split("#")[7], 14);
						dao.setProcInValue(procIndex3, "isactual_dob", "", 15);
						dao.setProcInValue(procIndex3, "ordered_by_doc", "", 16);

						dao.setProcInValue(procIndex3, "gender_code", patGender, 17);
						dao.setProcInValue(procIndex3, "req_raised_through", "7", 18);
						dao.setProcInValue(procIndex3, "age", patAge, 19);
						dao.setProcInValue(procIndex3, "admno", "", 20);
						dao.setProcInValue(procIndex3, "address", "", 21);
						dao.setProcInValue(procIndex3, "wardcode", "", 22);

						dao.setProcInValue(procIndex3, "mobile_no", "", 23);
						dao.setProcInValue(procIndex3, "email_id", "", 24);
						dao.setProcInValue(procIndex3, "room_code", "", 25);
						dao.setProcInValue(procIndex3, "bed_code", "", 26);
						dao.setProcInValue(procIndex3, "mlc_no", "", 27);
						dao.setProcInValue(procIndex3, "bed_name", "", 28);

						dao.setProcInValue(procIndex3, "room_name", "", 29);
						dao.setProcInValue(procIndex3, "ward_name", "", 30);
						dao.setProcInValue(procIndex3, "dept_name", PatCompleteGeneralDtl.split("#")[8], 31);
						dao.setProcInValue(procIndex3, "request_del_seatid", "", 32);
						dao.setProcInValue(procIndex3, "unit_name", PatCompleteGeneralDtl.split("#")[9], 33);
						dao.setProcInValue(procIndex3, "dept_code", PatCompleteGeneralDtl.split("#")[6], 34);

						dao.setProcInValue(procIndex3, "deptunitcode", PatCompleteGeneralDtl.split("#")[5], 35);
						dao.setProcInValue(procIndex3, "isautomated_request", "", 36);
						dao.setProcInValue(procIndex3, "ordered_by_doc_name", "", 37);
						dao.setProcInValue(procIndex3, "reffered_hospital_code", "", 38);
						dao.setProcInValue(procIndex3, "reffered_dept_unit_name", "", 39);
						dao.setProcInValue(procIndex3, "reffered_lab_code", "", 40);
						dao.setProcInValue(procIndex3, "ext_hosporlab_name", "", 41);

						dao.setProcInValue(procIndex3, "ext_crnumber", "", 42);
						dao.setProcInValue(procIndex3, "bill_no", "", 43);
						dao.setProcInValue(procIndex3, "delete_reason", "", 44);
						dao.setProcInValue(procIndex3, "isvalid", "1", 45);
						dao.setProcInValue(procIndex3, "req_date", "", 46);
						dao.setProcInValue(procIndex3, "hgnum_patient_cat_code", "", 47);
						dao.setProcInValue(procIndex3, "visit_reason", sb.toString() + "" + strInvestgationNote, 48);
						dao.setProcOutValue(procIndex3, "err", 1, 49);
						dao.execute(procIndex3, 1);

						ArrayList<String> TestCodeList = (ArrayList<String>) m.getValue();
						if (TestCodeList != null) {

							for (int i = 0; i < TestCodeList.size(); i++) {

								procIndex1 = dao.setProcedure(proc_name1);
								dao.setProcInValue(procIndex1, "hmode", "5", 1);
								dao.setProcInValue(procIndex1, "hcode", hosp_code, 2);
								if (i < 9) {
									strRequisitionDNo = strRequisitionNo + "0" + (i + 1);
								} else {
									strRequisitionDNo = strRequisitionNo + (i + 1);
								}
								dao.setProcInValue(procIndex1, "reqdno", strRequisitionDNo, 3);
								dao.setProcInValue(procIndex1, "isappointment", "0", 4);
								dao.setProcInValue(procIndex1, "labcode", m.getKey().toString(), 5);
								dao.setProcInValue(procIndex1, "testcode", TestCodeList.get(i).split("\\^")[0], 6);

								dao.setProcInValue(procIndex1, "isconfidential", "0", 7);
								dao.setProcInValue(procIndex1, "prioritycode", "1", 8);
								dao.setProcInValue(procIndex1, "resultseatid", "", 9);
								String staus = "";
								// System.out.println("test Code,
								// Value"+TestCodeList.get(i).split("\\^")[0]+","+TestCodeList.get(i).split("\\^")[5]);
								if (TestCodeList.get(i).split("\\^")[1].equalsIgnoreCase("-1")
										|| TestCodeList.get(i).split("\\^")[1].equalsIgnoreCase("0")) {
									staus = "5";
								} else {
									staus = "2";
								}

								dao.setProcInValue(procIndex1, "req_dtl_status", staus, 10);
								dao.setProcInValue(procIndex1, "seatid", seatId, 11);
								dao.setProcInValue(procIndex1, "app_ref_no", "", 12);

								dao.setProcInValue(procIndex1, "temp_sample_no", "", 13);
								if (TestCodeList.get(i).split("\\^")[3].equals("1")) {
									dao.setProcInValue(procIndex1, "groupcode",
											TestCodeList.get(i).split("\\^")[4].substring(5, 9), 14);
									dao.setProcInValue(procIndex1, "grouptype", "1", 15);

								} else {
									dao.setProcInValue(procIndex1, "groupcode", "", 14);
									dao.setProcInValue(procIndex1, "grouptype", "", 15);
								}

								dao.setProcInValue(procIndex1, "cancellation_seat_id", "", 16);

								dao.setProcInValue(procIndex1, "billno", "", 17);
								dao.setProcInValue(procIndex1, "res_val_seat_id", "", 18);
								dao.setProcInValue(procIndex1, "res_re_val_seat_id", "", 19);
								dao.setProcInValue(procIndex1, "samplecode", TestCodeList.get(i).split("\\^")[1], 20);
								dao.setProcInValue(procIndex1, "res_print_seat_id", "", 21);
								dao.setProcInValue(procIndex1, "daily_lab_no", "", 22);

								dao.setProcInValue(procIndex1, "pat_rejection_reason", "", 23);
								dao.setProcInValue(procIndex1, "res_modify_seat_id", "", 24);
								dao.setProcInValue(procIndex1, "pat_rejection_action", "", 25);
								dao.setProcInValue(procIndex1, "reschedule_seat_id", "", 26);
								dao.setProcInValue(procIndex1, "work_order_seq", "", 27);
								dao.setProcInValue(procIndex1, "sam_rejection_action", "", 28);

								dao.setProcInValue(procIndex1, "sam_rejection_reason", "", 29);
								dao.setProcInValue(procIndex1, "test_delete_seat_id", "", 30);
								dao.setProcInValue(procIndex1, "type_of_component", "", 31);
								dao.setProcInValue(procIndex1, "req_no", strRequisitionNo, 32);
								dao.setProcInValue(procIndex1, "is_accepted", "", 33);
								dao.setProcInValue(procIndex1, "packing_list_no", "", 34);

								dao.setProcInValue(procIndex1, "machinecode", "", 35);
								dao.setProcInValue(procIndex1, "acceptance_seat_id", "", 36);
								dao.setProcInValue(procIndex1, "collection_seat_id", "", 37);
								dao.setProcInValue(procIndex1, "sample_col_area_code", "", 38);
								dao.setProcInValue(procIndex1, "appointment_time", "", 39);
								dao.setProcInValue(procIndex1, "packing_list_seat_id", "", 40);
								dao.setProcInValue(procIndex1, "is_sample_received", "", 41);

								dao.setProcInValue(procIndex1, "sample_no", "", 42);
								dao.setProcInValue(procIndex1, "uomcode", "", 43);
								dao.setProcInValue(procIndex1, "collected_vol", "", 44);
								dao.setProcInValue(procIndex1, "container_code", "", 45);
								dao.setProcInValue(procIndex1, "appointment_date", "", 46);
								dao.setProcInValue(procIndex1, "priority_all", "", 47);
								dao.setProcOutValue(procIndex1, "err", 1, 48);
								dao.setProcInValue(procIndex1, "site", "", 49);
								// dao.executeProcedure(procIndex1);
								dao.execute(procIndex1, 1);

							}
						}
					}

					/* Billing */

					// System.out.println("bldMap"+bldMap);
					/*
					 * if (bldMap != null) {
					 * 
					 * testsb=new StringBuffer(); testQtysb=new StringBuffer(); testGrpsb=new
					 * StringBuffer(); testGrpQtysb=new StringBuffer();
					 * 
					 * 
					 * for (Map.Entry bldMap1 : bldMap.entrySet()) { String reqNo =
					 * bldMap1.getKey().toString();
					 * 
					 * ArrayList<String> BLDgenerationLogic = (ArrayList) bldMap1.getValue();
					 * ArrayList<String> tariffList = new ArrayList<String>(); int temprpt = 0; for
					 * (int tempbld = 0; tempbld < BLDgenerationLogic.size(); tempbld++) { if
					 * (BLDgenerationLogic.get(tempbld).split("\\^")[3].equals("1")) { if (tempbld
					 * == 0) tariffList.add(BLDgenerationLogic.get(tempbld).split("\\^")[4]); else {
					 * if (!tariffList.contains(BLDgenerationLogic.get(tempbld).split("\\^")[4]))
					 * tariffList.add(BLDgenerationLogic.get(tempbld).split("\\^")[4]); }
					 * 
					 * if (BLDgenerationLogic.get(0).split("\\^")[2].equalsIgnoreCase("BLD")) { if
					 * (temprpt == 0) { strBillingstrRequisitionNo = strBillingstrRequisitionNo +
					 * reqNo + "|BLD"; temprpt++; } else { strBillingstrRequisitionNo =
					 * strBillingstrRequisitionNo + "|BLD"; // temprpt++; }
					 * 
					 * } else { strBillingstrRequisitionNo = strBillingstrRequisitionNo + reqNo; } }
					 * else { // testQtysb += ("1" + "^"); String TestCode =
					 * BLDgenerationLogic.get(tempbld).split("\\^")[0]; // testsb += (TestCode +
					 * "#1^");
					 * 
					 * if (BLDgenerationLogic.get(0).split("\\^")[2].equalsIgnoreCase("BLD")) { if
					 * (temprpt == 0) { strBillingstrRequisitionNo = strBillingstrRequisitionNo +
					 * reqNo + "|BLD"; temprpt++; } else { strBillingstrRequisitionNo =
					 * strBillingstrRequisitionNo + "|BLD"; // temprpt++; }
					 * 
					 * } else { strBillingstrRequisitionNo = strBillingstrRequisitionNo + reqNo; } }
					 * }
					 * 
					 * strBillingstrRequisitionNo = strBillingstrRequisitionNo + "!";
					 * 
					 * 
					 * if (tariffList.size() > 0) { for (String t : tariffList) { testGrpQtysb +=
					 * ("1" + "^"); testGrpsb += (t + "#1^"); }
					 * 
					 * }
					 * 
					 * } }
					 */

					/*
					 * if(testsb!=null && !testsb.isEmpty() && testsb.split("^").length>0) { for
					 * (int q = 0; q < testsb.split("^").length; q++) { procIndex4 =
					 * dao.setProcedure(proc_name4); dao.setProcInValue(procIndex4, "modval", "1",
					 * 1); dao.setProcInValue(procIndex4, "gnum_dept_code",
					 * PatCompleteGeneralDtl.split("#")[6], 2); if
					 * (PatCompleteGeneralDtl.split("#")[11] != null &&
					 * !PatCompleteGeneralDtl.split("#")[11].trim().equals("null"))
					 * dao.setProcInValue(procIndex4,
					 * "sblnum_chargetype_id",PatCompleteGeneralDtl.split("#")[11], 3); else
					 * dao.setProcInValue(procIndex4, "sblnum_chargetype_id", "1", 3);
					 * dao.setProcInValue(procIndex4, "sblnum_service_id", "1", 4);
					 * dao.setProcInValue(procIndex4, "gstr_req_no", strBillingstrRequisitionNo, 5);
					 * dao.setProcInValue(procIndex4, "gnum_treatment_cat",
					 * PatCompleteGeneralDtl.split("#")[10], 6); //
					 * System.out.println("gnum_treatment_cat"+PatCompleteGeneralDtl.split("#")[10])
					 * ; // System.out.println("testsb.toString().substring(0,
					 * testsb.toString().length() // - 1)"+testsb.toString().substring(0,
					 * testsb.toString().length() - 1)); dao.setProcInValue(procIndex4,
					 * "hrgnum_episode_code", EpisodeCode, 7); dao.setProcInValue(procIndex4,
					 * "hrgnum_puk", Crno, 8); dao.setProcInValue(procIndex4,
					 * "gstr_tariff",testsb.toString().substring(0, testsb.toString().length() - 1),
					 * 9); dao.setProcInValue(procIndex4,
					 * "gstr_reqqty",testQtysb.toString().substring(0, testQtysb.toString().length()
					 * - 1), 10); dao.setProcInValue(procIndex4, "hblstr_patient_name", "0", 11); //
					 * dao.setProcInValue(procIndex4, "app_ref_no", "",12);
					 * 
					 * dao.setProcInValue(procIndex4, "hblstr_pat_address", "0", 12);
					 * dao.setProcInValue(procIndex4, "hblstr_contact_no", "0", 13);
					 * dao.setProcInValue(procIndex4, "age", "0", 14);
					 * dao.setProcInValue(procIndex4, "ageunit", "0", 15);
					 * 
					 * dao.setProcInValue(procIndex4, "gender", "0", 16);
					 * dao.setProcInValue(procIndex4, "refdoctor", "0", 17);
					 * dao.setProcInValue(procIndex4, "refdoccontactno", "0", 18);
					 * dao.setProcInValue(procIndex4, "gnum_seatid", seatId, 19);
					 * dao.setProcInValue(procIndex4, "hosp_code", hosp_code, 20);
					 * dao.setProcInValue(procIndex4, "ward_code", "0", 21);
					 * 
					 * dao.setProcInValue(procIndex4, "admno", "0", 22); //
					 * dao.setProcInValue(procIndex4, "visitno", //
					 * PatCompleteGeneralDtl.split("#")[4],23); dao.setProcInValue(procIndex4,
					 * "visitno", EpisodeVisitNo, 23); dao.setProcOutValue(procIndex4, "err", 1,
					 * 24);
					 * 
					 * // dao.executeProcedure(procIndex1); dao.execute(procIndex4, 1); } }
					 * if(testGrpsb!=null && !testGrpsb.isEmpty() && testGrpsb.split("^").length>0)
					 * { for (int q = 0; q < testGrpsb.split("^").length; q++) { procIndex5 =
					 * dao.setProcedure(proc_name5); dao.setProcInValue(procIndex5, "modval", "1",
					 * 1); dao.setProcInValue(procIndex5, "gnum_dept_code",
					 * PatCompleteGeneralDtl.split("#")[6], 2); if
					 * (PatCompleteGeneralDtl.split("#")[11] != null &&
					 * !PatCompleteGeneralDtl.split("#")[11].trim().equals("null"))
					 * dao.setProcInValue(procIndex5, "sblnum_chargetype_id",
					 * PatCompleteGeneralDtl.split("#")[11], 3); else dao.setProcInValue(procIndex5,
					 * "sblnum_chargetype_id", "1", 3); dao.setProcInValue(procIndex5,
					 * "sblnum_service_id", "4", 4); dao.setProcInValue(procIndex5, "gstr_req_no",
					 * strBillingstrRequisitionNo, 5); dao.setProcInValue(procIndex5,
					 * "gnum_treatment_cat", PatCompleteGeneralDtl.split("#")[10], 6); //
					 * System.out.println("gnum_treatment_cat"+PatCompleteGeneralDtl.split("#")[10])
					 * ; // System.out.println("testsb.toString().substring(0,
					 * testsb.toString().length() // - 1)"+testsb.toString().substring(0,
					 * testsb.toString().length() - 1)); dao.setProcInValue(procIndex5,
					 * "hrgnum_episode_code", EpisodeCode, 7); dao.setProcInValue(procIndex5,
					 * "hrgnum_puk", Crno, 8); dao.setProcInValue(procIndex5, "gstr_tariff",
					 * testGrpsb.toString().substring(0, testGrpsb.toString().length() - 1), 9);
					 * dao.setProcInValue(procIndex5, "gstr_reqqty",
					 * testGrpQtysb.toString().substring(0, testGrpQtysb.toString().length() - 1),
					 * 10); dao.setProcInValue(procIndex5, "hblstr_patient_name", "0", 11); //
					 * dao.setProcInValue(procIndex4, "app_ref_no", "",12);
					 * 
					 * dao.setProcInValue(procIndex5, "hblstr_pat_address", "0", 12);
					 * dao.setProcInValue(procIndex5, "hblstr_contact_no", "0", 13);
					 * dao.setProcInValue(procIndex5, "age", "0", 14);
					 * dao.setProcInValue(procIndex5, "ageunit", "0", 15);
					 * 
					 * dao.setProcInValue(procIndex5, "gender", "0", 16);
					 * dao.setProcInValue(procIndex5, "refdoctor", "0", 17);
					 * dao.setProcInValue(procIndex5, "refdoccontactno", "0", 18);
					 * dao.setProcInValue(procIndex5, "gnum_seatid", seatId, 19);
					 * dao.setProcInValue(procIndex5, "hosp_code", hosp_code, 20);
					 * dao.setProcInValue(procIndex5, "ward_code", "0", 21);
					 * 
					 * dao.setProcInValue(procIndex5, "admno", "0", 22); //
					 * dao.setProcInValue(procIndex4, "visitno", //
					 * PatCompleteGeneralDtl.split("#")[4],23); dao.setProcInValue(procIndex5,
					 * "visitno", EpisodeVisitNo, 23); dao.setProcOutValue(procIndex5, "err", 1,
					 * 24);
					 * 
					 * // dao.executeProcedure(procIndex1); dao.execute(procIndex5, 1); } }
					 */

				}

			}

		} catch (Exception e) {

			throw e;
		}

	}

	public static void SaveGenralData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_OpdDesk_dml.proc_hrgt_episode_diagnosis_dml(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			JSONArray Diagnosis = (JSONArray) object.get("Diagnosis");
			// String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			if (Diagnosis != null) {

				for (int i = 0; i < Diagnosis.length(); i++) {

					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "p_mode", "1", 1);
					dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
					dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 3);
					// dao.setProcInValue(procIndex1, "p_visit_no",
					// PatCompleteGeneralDtl.split("#")[4],4);
					dao.setProcInValue(procIndex1, "p_visit_no", EpisodeVisitNo, 4);
					dao.setProcInValue(procIndex1, "p_admissionno", "0", 5);
					String tmp[] = Diagnosis.getString(i).split("\\^");
					String diagnostictypecode = tmp[0].split("#")[1];
					if (diagnostictypecode != null && !diagnostictypecode.equals("11")
							&& !diagnostictypecode.equals("12") && !diagnostictypecode.equals("14"))
						dao.setProcInValue(procIndex1, "p_diagnostictypecode", "11", 6);
					else
						dao.setProcInValue(procIndex1, "p_diagnostictypecode", diagnostictypecode, 6);
					// String tmpArray[]=tmp.split("&&");*/
					// System.out.println("Diagnosis Code"+tmp[0].split("#")[0]);
					dao.setProcInValue(procIndex1, "p_diagnosticcode", tmp[0].split("#")[0], 7);
					dao.setProcInValue(procIndex1, "p_seat_id", seatId, 8);
					dao.setProcInValue(procIndex1, "p_isvalid", "1", 9);
					dao.setProcInValue(procIndex1, "p_episodedate", "", 10);
					dao.setProcInValue(procIndex1, "p_remarks", "", 11);
					// System.out.println(tmp[0] +"fffffffffffffffffffff"+tmp[0].split("#")[2]);
					dao.setProcInValue(procIndex1, "p_diagnosiscode_type", tmp[0].split("#")[2], 12);

					dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 13);
					dao.setProcInValue(procIndex1, "p_isrepeat", "0", 14);
					dao.setProcInValue(procIndex1, "p_diseasesiteid", "", 15);
					dao.setProcInValue(procIndex1, "p_diagnostic_name", tmp[1].split("#")[0], 16);

					dao.setProcInValue(procIndex1, "p_diagnostictypename", tmp[1].split("#")[1], 17);
					dao.setProcInValue(procIndex1, "p_disease_site", "", 18);
					dao.setProcInValue(procIndex1, "p_source", String.valueOf(i), 19);
					dao.setProcInValue(procIndex1, "p_somedicdmapped", "", 20);

					dao.setProcOutValue(procIndex1, "err", 1, 21);
					dao.execute(procIndex1, 1);
					
				}
			}

		} catch (Exception e) {

			throw e;
		}

	}

	public static void SaveVisitReasonData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_OpdDesk_dml.proc_hrgt_episode_dtl(?,?,?,?,?, ?,?,?,?,?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			// String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			// String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			StringBuffer sb = new StringBuffer();
			StringBuffer sb1 = new StringBuffer();
			if (ReasonOfVisit != null) {

				for (int i = 0; i < ReasonOfVisit.length(); i++) {
					sb.append((ReasonOfVisit.get(i).toString().split("\\^")[1]).replaceAll(";", "") + ",");
					sb1.append((ReasonOfVisit.get(i).toString().split("\\^")[0]).replaceAll(";", "") + "#");
				}
			}
			if (ReasonOfVisit.length() > 0) {

				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_crno", Crno, 2);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
				dao.setProcInValue(procIndex1, "p_visitreason", sb.toString(), 4);
				dao.setProcInValue(procIndex1, "p_snomedpt", sb.toString(), 5);
				dao.setProcInValue(procIndex1, "p_snomedcid", sb1.toString(), 6);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 7);
				// dao.setProcInValue(procIndex1, "p_visitno",
				// PatCompleteGeneralDtl.split("#")[4],8);
				dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 8);
				dao.setProcInValue(procIndex1, "p_isvalid", "1", 9);

				dao.setProcOutValue(procIndex1, "err", 1, 10);
				dao.execute(procIndex1, 1);
			}

		} catch (Exception e) {
			throw e;

		}

	}

	public static void FollowUpDTL(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_OpdDesk_dml.proc_save_pat_follow_up_dtl(?,?,?,?,?, ?,?,?,?,? ,?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			// String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			// JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			// String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			JSONArray FOLLOWUPDTL = (JSONArray) object.get("FOLLOW_UP");
			// StringBuffer sb = new StringBuffer();

			if (FOLLOWUPDTL.length() > 0) {
				JSONObject FollowupJson = (JSONObject) FOLLOWUPDTL.get(0);
				JSONArray arr = (JSONArray) FollowupJson.get("Planned_Visit");
				String progressNote = (String) FollowupJson.get("progressNote");

				// System.out.println("arr"+arr);
				JSONObject temp = (JSONObject) arr.get(0);
				

				// JSONObject temp1=(JSONObject) arr.get(0);
				// System.out.println("plannedVisitDays"+temp.get("plannedVisitSos"));
			//	dao = new HisDAO("OPD DR DESK DAO", "FollowUpDTL.save()");
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
				dao.setProcInValue(procIndex1, "p_visitreason", "", 4);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
				// dao.setProcInValue(procIndex1, "p_visitno",
				// PatCompleteGeneralDtl.split("#")[4],6);
				dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 6);
				dao.setProcInValue(procIndex1, "p_is_open", "1", 7);
				dao.setProcInValue(procIndex1, "p_is_confirm", "1", 8);
				dao.setProcInValue(procIndex1, "p_visitnotes", progressNote, 9);
				dao.setProcInValue(procIndex1, "p_visitdate", temp.getString("plannedVisitDate"), 10);
				dao.setProcOutValue(procIndex1, "err", 1, 11);
				dao.execute(procIndex1, 1);
			}

		} catch (Exception e) {

			throw e;

		}

	}

	public static void SaveEHRData(String JsonData, HisDAO dao) {

		String proc_name1 = "{call pkg_OpdDesk_dml.hrgt_ehrjson_dtl(?,?,?,?,?, ?,?,?,?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			// JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			// String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			// StringBuffer sb = new StringBuffer();

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
			// dao.setProcInValue(procIndex1, "p_visitno",
			// PatCompleteGeneralDtl.split("#")[4],6);
			dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 6);
			dao.setProcInValue(procIndex1, "p_json", JsonData, 7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);

			dao.setProcOutValue(procIndex1, "err", 1, 9);
			dao.execute(procIndex1, 1);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public static void saveProcdureData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call ahis_service_area.saveservicerequisitionofflinenew(?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?,?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			JSONArray strClinicalProcedure = (JSONArray) object.get("strClinicalProcedure");
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");

			if (strClinicalProcedure != null) {

				for (int i = 0; i < strClinicalProcedure.length(); i++) {

					String tmp = (String) strClinicalProcedure.get(i);

					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "modval", "1", 1);
					dao.setProcInValue(procIndex1, "hospcode", hosp_code, 2);
					dao.setProcInValue(procIndex1, "patcrnum", Crno, 3);
					dao.setProcInValue(procIndex1, "sareacode", (tmp.split("#")[5]).split("\\^")[0], 4);
					dao.setProcInValue(procIndex1, "deptcode", PatCompleteGeneralDtl.split("#")[6], 5);
					
					dao.setProcInValue(procIndex1, "proc_code", (tmp.split("#")[1]).split("\\^")[0].trim(), 6);
					dao.setProcInValue(procIndex1, "procdate", "", 7);
					dao.setProcInValue(procIndex1, "proctime", "", 8);
					dao.setProcInValue(procIndex1, "apptstatus", "1", 9);
					dao.setProcInValue(procIndex1, "appno", "1", 10);
					
					dao.setProcInValue(procIndex1, "reqstatusraised", "1", 11);
					dao.setProcInValue(procIndex1, "seatid", seatId, 12);
					dao.setProcInValue(procIndex1, "episodecode", EpisodeCode, 13);
					dao.setProcInValue(procIndex1, "visitno", EpisodeVisitNo, 14);
					dao.setProcInValue(procIndex1, "remarks", (tmp.split("#")[4]), 15);
					
					dao.setProcInValue(procIndex1, "paraflag", "1", 16);
					dao.setProcOutValue(procIndex1, "err", 1, 17);
					dao.setProcInValue(procIndex1, "servicereqno", "1010101", 18);
					dao.setProcInValue(procIndex1, "admissionno", "0", 19);
					dao.setProcInValue(procIndex1, "wardcode", "0", 20);
					
					dao.setProcInValue(procIndex1, "tariffid", (tmp.split("#")[1]).split("\\^")[0], 21);
					dao.setProcInValue(procIndex1, "quantity", "1", 22);
					dao.setProcInValue(procIndex1, "count", "0", 23);
					
					dao.execute(procIndex1, 1);

				}

			}

		} catch (Exception e) {
			throw e;

		}
	}

	/*public static void saveReferPatientDetails(String JsonData, HisDAO dao) throws Exception {

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");
			// StringBuffer sb = new StringBuffer();
			JSONArray strRefferalDept = (JSONArray) object.get("strReferal");
			int length = ((JSONArray) object.get("strReferal")).length();

			for (int i = 0; i < length; i++) {
				JSONObject strjsonObj = (JSONObject) strRefferalDept.get(i);
				String reftype = (String) strjsonObj.get("strreferralType");
				if (reftype.equalsIgnoreCase("1") || reftype.equalsIgnoreCase("2") || reftype.equalsIgnoreCase("3")) {
					String proc_name1 = "{call pkg_OpdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "p_mode", "1", 1);
					dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
					dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
					dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
					dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
					dao.setProcInValue(procIndex1, "from_dept", "", 6);
					dao.setProcInValue(procIndex1, "from_deptunit", "", 7);

					dao.setProcInValue(procIndex1, "to_dept",
							((String) (strjsonObj.get("strReffralDeptDone"))).split("#")[0], 8);
					dao.setProcInValue(procIndex1, "to_deptunit",
							((String) (strjsonObj.get("strReffralDeptDone"))).split("#")[1], 9);
					dao.setProcInValue(procIndex1, "p_visitno", visitNo, 10);
					dao.setProcInValue(procIndex1, "to_ip_address", "", 11);
					dao.setProcInValue(procIndex1, "remarks", (String) strjsonObj.get("strReffralReason"), 12);
					dao.setProcInValue(procIndex1, "isref_out", (String) strjsonObj.get("strreferralType"), 13);
					dao.setProcInValue(procIndex1, "p_json", JsonData, 14);
					dao.setProcOutValue(procIndex1, "err", 1, 15);
					dao.execute(procIndex1, 1);
				} else if (reftype.equalsIgnoreCase("4")) {
					String proc_name1 = "{call pkg_OpdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "p_mode", "2", 1);
					dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
					dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
					dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
					dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
					dao.setProcInValue(procIndex1, "from_dept", "", 6);
					dao.setProcInValue(procIndex1, "from_deptunit", "", 7);

					dao.setProcInValue(procIndex1, "to_dept",
							((String) (strjsonObj.get("strExternalDepartmentcode"))).split("#")[0], 8);
					dao.setProcInValue(procIndex1, "to_deptunit",
							((String) (strjsonObj.get("strExternalDepartmentcode"))).split("#")[1], 9);
					dao.setProcInValue(procIndex1, "p_visitno", visitNo, 10);
					dao.setProcInValue(procIndex1, "to_ip_address", strjsonObj.toString(), 11);
					dao.setProcInValue(procIndex1, "remarks", (String) strjsonObj.get("strReffralReason"), 12);
					dao.setProcInValue(procIndex1, "isref_out", (String) strjsonObj.get("strreferralType"), 13);
					dao.setProcInValue(procIndex1, "p_json", JsonData, 14);
					dao.setProcOutValue(procIndex1, "err", 1, 15);
					dao.execute(procIndex1, 1);

				} else if (reftype.equalsIgnoreCase("5")) {
					String proc_name1 = "{call pkg_OpdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
					procIndex1 = dao.setProcedure(proc_name1);
					dao.setProcInValue(procIndex1, "p_mode", "3", 1);
					dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
					dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
					dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
					dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
					dao.setProcInValue(procIndex1, "from_dept", "", 6);
					dao.setProcInValue(procIndex1, "from_deptunit", "", 7);

					dao.setProcInValue(procIndex1, "to_dept",
							((String) (strjsonObj.get("strExternalDepartmentcode"))).split("#")[0], 8);
					dao.setProcInValue(procIndex1, "to_deptunit",
							((String) (strjsonObj.get("strExternalDepartmentcode"))).split("#")[1], 9);
					dao.setProcInValue(procIndex1, "p_visitno", visitNo, 10);
					dao.setProcInValue(procIndex1, "to_ip_address", "", 11);
					dao.setProcInValue(procIndex1, "remarks", strjsonObj.toString(), 12);
					dao.setProcInValue(procIndex1, "isref_out", (String) strjsonObj.get("strreferralType"), 13);
					dao.setProcInValue(procIndex1, "p_json", JsonData, 14);
					dao.setProcOutValue(procIndex1, "err", 1, 15);
					dao.execute(procIndex1, 1);

				}
			}

		} catch (Exception e) {
			throw e;
		}
	}*/

	public static String SaveVitalData(String JsonData) {
		// System.out.println("method called SaveVitalData===>");
		 
		String proc_name1 = "{call pkg_OpdDesk_dml.Dml_Vital_dtls(?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?)}";

		int procIndex1 = 0;
		HisDAO dao = null;
		try {

			JSONObject object = new JSONObject(JsonData);
			String[] strPatdtls = ((String) object.get("strPatdtls")).split("\\^");
		 
			String strWeight = (String) object.get("strWeight") == null ? "" : (String) object.get("strWeight");
			String strHeight = (String) object.get("strHeight") == null ? "" : (String) object.get("strHeight");
			String strBmid = (String) object.get("strBmid") == null ? "" : (String) object.get("strBmid");
			String strTempreature = (String) object.get("strTempreature") == null ? ""
					: (String) object.get("strTempreature");

			String strrespRate = (String) object.get("strrespRate") == null ? "" : (String) object.get("strrespRate");
			String strhaemoglobin = (String) object.get("strhaemoglobin") == null ? ""
					: (String) object.get("strhaemoglobin");
			String strdiastolic = (String) object.get("strdiastolic") == null ? ""
					: (String) object.get("strdiastolic");
			String strsystolic = (String) object.get("strsystolic") == null ? "" : (String) object.get("strsystolic");

			String strfasting = (String) object.get("strfasting") == null ? "" : (String) object.get("strfasting");
			String strRateId = (String) object.get("strRateId") == null ? "" : (String) object.get("strRateId");
			String strhba1c = (String) object.get("strhba1c") == null ? "" : (String) object.get("strhba1c");
			String strsymptoms = (String) object.get("strsymptoms") == null ? "" : (String) object.get("strsymptoms");

			dao = new HisDAO("OPD DR DESK DAO", "vitalSave.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", strPatdtls[1], 2);
			dao.setProcInValue(procIndex1, "p_hospcode", strPatdtls[4], 3);
			dao.setProcInValue(procIndex1, "p_seatId", strPatdtls[7], 4);
			dao.setProcInValue(procIndex1, "p_episodecode", strPatdtls[2], 5);
			dao.setProcInValue(procIndex1, "p_visitno", strPatdtls[3], 6);

			dao.setProcInValue(procIndex1, "strWeight", strWeight, 7);
			dao.setProcInValue(procIndex1, "strHeight", strHeight, 8);
			dao.setProcInValue(procIndex1, "strBmid", strBmid, 9);
			dao.setProcInValue(procIndex1, "strTempreature", strTempreature, 10);
			dao.setProcInValue(procIndex1, "strrespRate", strrespRate, 11);
			dao.setProcInValue(procIndex1, "strhaemoglobin", strhaemoglobin, 12);
			dao.setProcInValue(procIndex1, "strdiastolic", strdiastolic, 13);

			dao.setProcInValue(procIndex1, "strsystolic", strsystolic, 14);
			dao.setProcInValue(procIndex1, "strfasting", strfasting, 15);
			dao.setProcInValue(procIndex1, "strRateId", strRateId, 16);
			dao.setProcInValue(procIndex1, "strhba1c", strhba1c, 17);
			dao.setProcInValue(procIndex1, "strsymptoms", strsymptoms, 18);

			dao.setProcInValue(procIndex1, "p_json", JsonData, 19);
			// System.out.println("jsondata-->"+ JsonData);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 20);

			dao.setProcOutValue(procIndex1, "err", 1, 21);
			dao.executeProcedureByPosition(procIndex1);

			return "1";
		} catch (Exception e) {
			  new HisException("OPD Ver-2.0", "opdDrDeskDao.SaveVitalData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return "0";
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static String savePrecriptionProfileData(String JsonData) {

	 
		String proc_name1 = "{call pkg_OpdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?)}";

		int procIndex1 = 0;
		 
		HisDAO dao = null;
	  

		try {

			JSONObject object = new JSONObject(JsonData);
			Integer strProfileId = (Integer) object.get("strProfileId");
			Integer strStatus = (Integer) object.get("strStatus");

			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "3", 1);
			dao.setProcInValue(procIndex1, "p_puk", "", 2);
			dao.setProcInValue(procIndex1, "p_hospcode", String.valueOf(strProfileId), 3);
			dao.setProcInValue(procIndex1, "p_seatId", String.valueOf(strStatus), 4);
			dao.setProcInValue(procIndex1, "p_episodecode", "", 5);
			dao.setProcInValue(procIndex1, "p_visitno", "", 6);
			dao.setProcInValue(procIndex1, "p_json", JsonData, 7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);

			dao.setProcOutValue(procIndex1, "err", 1, 9);
			dao.executeProcedureByPosition(procIndex1);

			return "1";
		} catch (Exception e) {
			  new HisException("OPD Ver-2.0", "opdDrDeskDao.SavePrescriptionBookMarkData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return "0";
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static String SaveEMRVitalData(String JsonData) {

	 

		String proc_name1 = "{call pkg_emr_dtl.sync_pat_vitals_from_oplite(?,?,?,?,?, ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,   ?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?, ?,?,?,?)}";
		// System.out.println("method called SaveEMRVitalData===>");
		int procIndex1 = 0;
		HisDAO dao = null;
		try {

			JSONObject object = new JSONObject(JsonData);
			String[] strPatdtls = ((String) object.get("strPatdtls")).split("\\^");
		 
			String strWeight = (String) object.get("strWeight") == null ? "" : (String) object.get("strWeight");
			String strHeight = (String) object.get("strHeight") == null ? "" : (String) object.get("strHeight");
			String strBmid = (String) object.get("strBmid") == null ? "" : (String) object.get("strBmid");
			String strTempreature = (String) object.get("strTempreature") == null ? ""
					: (String) object.get("strTempreature");

			String strrespRate = (String) object.get("strrespRate") == null ? "" : (String) object.get("strrespRate");
			String strhaemoglobin = (String) object.get("strhaemoglobin") == null ? ""
					: (String) object.get("strhaemoglobin");
			/*
			 * String strdiastolic = (String) object.get("strdiastolic") == null ? "" :
			 * (String) object.get("strdiastolic");
			 */
			String strsystolic = (String) object.get("strsystolic") == null ? "" : (String) object.get("strsystolic");

			String strfasting = (String) object.get("strfasting") == null ? "" : (String) object.get("strfasting");
			String strRateId = (String) object.get("strRateId") == null ? "" : (String) object.get("strRateId");
			String strhba1c = (String) object.get("strhba1c") == null ? "" : (String) object.get("strhba1c");
			String strsymptoms = (String) object.get("strsymptoms") == null ? "" : (String) object.get("strsymptoms");

			String strpulseRate = (String) object.get("strpulseRate") == null ? ""
					: (String) object.get("strpulseRate");
			String strbloodGroup = (String) object.get("strbloodGroup") == null ? ""
					: (String) object.get("strbloodGroup");
			String strmuac = (String) object.get("strmuac") == null ? "" : (String) object.get("strmuac");
			String strcurcumference = (String) object.get("strcurcumference") == null ? ""
					: (String) object.get("strcurcumference");

			/*
			 * String strbmiErrmsg = (String) object.get("strbmiErrmsg") == null ? "" :
			 * (String) object.get("strbmiErrmsg");
			 */
			String strtemperatureErrmsg = (String) object.get("strtemperatureErrmsg") == null ? ""
					: (String) object.get("strtemperatureErrmsg");
			String strrespRateErrmsg = (String) object.get("strrespRateErrmsg") == null ? ""
					: (String) object.get("strrespRateErrmsg");
			/*
			 * String strhaemoglobinErrmsg = (String) object.get("strhaemoglobinErrmsg") ==
			 * null ? "" : (String) object.get("strhaemoglobinErrmsg");
			 */

			String strbpErrmsg = (String) object.get("strbpErrmsg") == null ? "" : (String) object.get("strbpErrmsg");
			String strfastingErrmsg = (String) object.get("strfastingErrmsg") == null ? ""
					: (String) object.get("strfastingErrmsg");
			/*
			 * String strppRateErrmsg = (String) object.get("strppRateErrmsg") == null ? ""
			 * : (String) object.get("strppRateErrmsg");
			 */
			String strhba1cErrmsg = (String) object.get("strhba1cErrmsg") == null ? ""
					: (String) object.get("strhba1cErrmsg");
			/* <!-- ----------------------added for cancer screening--------------- --> */
			// String strcancerScreening=(String) object.get("strcancerScreening")==null ?
			// "" : (String) object.get("strcancerScreening") ;

			/*
			 * String strcancerScreening =
			 * object.get("strcancerScreening").toString().replaceAll("[\\[\\]]", "")
			 * .replaceAll("\"", "");
			 */

			dao = new HisDAO("OPD DR DESK DAO", "emrsave.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "pmode", "1", 1);
			dao.setProcInValue(procIndex1, "puk", strPatdtls[1], 2);
			dao.setProcInValue(procIndex1, "episode_code", strPatdtls[2], 3);
			dao.setProcInValue(procIndex1, "visit_no", strPatdtls[3], 4);
			dao.setProcInValue(procIndex1, "seq_no", "", 5);
			dao.setProcInValue(procIndex1, "hospital_code", strPatdtls[4], 6);

			dao.setProcInValue(procIndex1, "weight_val", strWeight, 7);
			dao.setProcInValue(procIndex1, "height_val", strHeight, 8);
			dao.setProcInValue(procIndex1, "bmi_val", strBmid, 9);
			dao.setProcInValue(procIndex1, "bmi_class", strTempreature, 10);
			dao.setProcInValue(procIndex1, "hoplstr_bmi_classname", strtemperatureErrmsg, 11);
			dao.setProcInValue(procIndex1, "temp_val", strTempreature, 12);
			dao.setProcInValue(procIndex1, "istemphigh", "0", 13);

			dao.setProcInValue(procIndex1, "rr_val", strrespRate, 14);
			dao.setProcInValue(procIndex1, "isrrabnormal", "0", 15);
			dao.setProcInValue(procIndex1, "hoplstr_rr_classname", strrespRateErrmsg, 16);
			dao.setProcInValue(procIndex1, "hb_val", strhaemoglobin, 17);
			dao.setProcInValue(procIndex1, "ishbabnormal", "0", 18);

			dao.setProcInValue(procIndex1, "bpsy_val", strsystolic, 19);
			dao.setProcInValue(procIndex1, "bpdiasy_val", strfasting, 20);
			dao.setProcInValue(procIndex1, "bpclass", strbpErrmsg, 21);
			dao.setProcInValue(procIndex1, "hoplstr_bp_classname", strbpErrmsg, 22);
			dao.setProcInValue(procIndex1, "sugarfast_val", strfasting, 23);
			dao.setProcInValue(procIndex1, "sugarpp_val", strRateId, 24);
			dao.setProcInValue(procIndex1, "diabeticclass", strbpErrmsg, 25);
			dao.setProcInValue(procIndex1, "hoplstr_diabetic_classname", strfastingErrmsg, 26);
			dao.setProcInValue(procIndex1, "hba1c_val", strhba1c, 27);
			dao.setProcInValue(procIndex1, "hba1c_class", strhba1cErrmsg, 28);

			dao.setProcInValue(procIndex1, "hoplstr_hba1cclassname", strhba1cErrmsg, 29);
			dao.setProcInValue(procIndex1, "hoplstr_sympinfo_val", strsymptoms, 30);
			dao.setProcInValue(procIndex1, "gnum_isvalid", "1", 31);
			dao.setProcInValue(procIndex1, "gnum_seat_id", strPatdtls[7], 32);
			dao.setProcInValue(procIndex1, "gnum_lstmod_seat_id", "", 33);
			dao.setProcInValue(procIndex1, "hopldt_entry_date", "", 34);
			dao.setProcInValue(procIndex1, "hopldt_lstmod_date", "", 35);
			dao.setProcInValue(procIndex1, "hoplstr_chronic_vitals", "", 36);
			dao.setProcInValue(procIndex1, "hoplstr_tempreture_classname", "", 37);
			dao.setProcInValue(procIndex1, "hoplstr_sugarpp_classname", "", 38);

			dao.setProcInValue(procIndex1, "hoplstr_json_data", JsonData, 39);
			dao.setProcInValue(procIndex1, "pulse_rate", strpulseRate, 40);
			dao.setProcInValue(procIndex1, "hoplstr_blood_group", strbloodGroup, 41);
			dao.setProcInValue(procIndex1, "curcumference_val", strcurcumference, 42);

			dao.setProcInValue(procIndex1, "muac_val", strmuac, 43);
			/* <!-- ----------------------added for cancer screening--------------- --> */
			// dao.setProcInValue(procIndex1, "hoplstr_cancer_screening",
			// strcancerScreening,44);
			// System.out.println("cancer screening" + strcancerScreening);
			dao.setProcOutValue(procIndex1, "err", 1, 44);
			dao.executeProcedureByPosition(procIndex1);

			return "1";
		} catch (Exception e) {
		  new HisException("OPD Ver-2.0", "opdDrDeskDao.SaveEMRVitalData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return "0";
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}

	}

	public static String getModifyVitalData(String JsonData) throws JSONException {

		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call pkg_opddrdesk_view.get_vital_dtls(?,?,?,?,? ,?,?,?,?)}";
		int procIndex1 = 0;
		HisDAO dao = null;
		WebRowSet ws = null;

	 
		JSONObject mainObj = new JSONObject();
 
		ArrayList<String> columnlist = new ArrayList<String>();
		ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
		int length = 0;
		try {
			JSONObject object = new JSONObject(JsonData);
			String CR_No = (String) object.get("CR_No") == null ? "" : (String) object.get("CR_No");
			String episodeCode = (String) object.get("episodeCode") == null ? "" : (String) object.get("episodeCode");
			String hospitalCode = (String) object.get("hospitalCode") == null ? ""
					: (String) object.get("hospitalCode");
			String visitNo = (String) object.get("visitNo") == null ? "" : (String) object.get("visitNo");
			// System.out.println("crno::::::::::::::"+crno);
			dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", "1", 1);
			dao.setProcInValue(procIndex1, "crno", CR_No, 2);
			dao.setProcInValue(procIndex1, "episodeCode", episodeCode, 3);
			dao.setProcInValue(procIndex1, "visitNo", visitNo, 4);
			dao.setProcInValue(procIndex1, "seatId", "", 5);
			dao.setProcInValue(procIndex1, "entrydate", "", 6);
			dao.setProcInValue(procIndex1, "hosp_code", hospitalCode, 7);
			dao.setProcOutValue(procIndex1, "err", 1, 8);
			dao.setProcOutValue(procIndex1, "resultset", 2, 9);
			// dao.executeProcedureByPosition(procIndex1);

			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				length = ws.getMetaData().getColumnCount();
				for (int i = 1; i <= length; i++) {
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}

			}
			if (ws != null && ws.size() > 0) {
				while (ws.next()) {
					 
					JSONObject js = new JSONObject();
					for (int i = 1; i <= length; i++) {
						String key = columnlist.get(i - 1);
						String value = ws.getString(i);
						// JSONParser parser = new JSONParser();
						// org.json.simple.JSONObject json = (org.json.simple.JSONObject)
						// parser.parse(value);
						js.put(key, value);

					}
					jsonolist.add(js);

				}

			}

			mainObj.put("status", "1");
			mainObj.put("VitalDtls", jsonolist);

			if (ws != null) {
				ws.close();
				ws = null;
			}
			return mainObj.toString();
		} catch (Exception e) {
		  new HisException("OPD Ver-2.0", "opdDrDeskDao.getModifyVitalData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			mainObj.put("status", "2");
			mainObj.put("VitalDtls", "");
			return mainObj.toString();
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void SaveGenralDataFormattedData(String JsonData) {

	 
		String proc_name1 = "{call pkg_OpdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?)}";

		int procIndex1 = 0;
		 
		HisDAO dao = null;
	 
		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			/*
			 * System.out.println("Diagnosis "+object.get("Diagnosis"));
			 * System.out.println("CR_No"+object.get("CR_No"));
			 * System.out.println("episodeCode"+object.get("episodeCode"));
			 */

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("EpisodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("EpisodeVisitNo");
			/*
			 * JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
			 */
		 

			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
			dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 6);
			dao.setProcInValue(procIndex1, "p_json", JsonData, 7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);

			dao.setProcOutValue(procIndex1, "err", 1, 9);
			dao.executeProcedureByPosition(procIndex1);

			return;
		} catch (Exception e) {
			  new HisException("OPD Ver-2.0", "opdDrDeskDao.SaveGenralDataFormattedData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return;
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void SavePrescriptionBookMarkData(String JsonData) {

	 
		String proc_name1 = "{call pkg_OpdDesk_dml.hopl_emr_dtl(?,?,?,?,?, ?,?,?,?)}";

		int procIndex1 = 0;
	 
		HisDAO dao = null;
	 

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			/*
			 * System.out.println("Diagnosis "+object.get("Diagnosis"));
			 * System.out.println("CR_No"+object.get("CR_No"));
			 * System.out.println("episodeCode"+object.get("episodeCode"));
			 */

			// String Crno=(String) object.get("CR_No");
			// String EpisodeCode=(String) object.get("EpisodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			// String EpisodeVisitNo=(String) object.get("EpisodeVisitNo");
			/*
			 * JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
			 */
		 

			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "2", 1);
			dao.setProcInValue(procIndex1, "p_puk", "", 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
			dao.setProcInValue(procIndex1, "p_episodecode", "", 5);
			dao.setProcInValue(procIndex1, "p_visitno", "", 6);
			dao.setProcInValue(procIndex1, "p_json", JsonData, 7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);

			dao.setProcOutValue(procIndex1, "err", 1, 9);
			dao.executeProcedureByPosition(procIndex1);

			return;
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.SavePrescriptionBookMarkData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return;
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void SavePrescriptionBookMarkDataFromPB(String JsonData, String DeptUnitName) {

		 
		String proc_name1 = "{call pkg_OpdDesk_dml.hopl_prescriptionbookmark_dtl(?,?,?,?,?, ?,?,?,?,?,?,?)}";

		int procIndex1 = 0;
	 
		HisDAO dao = null;
	  
		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			/*
			 * System.out.println("Diagnosis "+object.get("Diagnosis"));
			 * System.out.println("CR_No"+object.get("CR_No"));
			 * System.out.println("episodeCode"+object.get("episodeCode"));
			 */

			// String Crno=(String) object.get("CR_No");
			// String EpisodeCode=(String) object.get("EpisodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			// String EpisodeVisitNo=(String) object.get("EpisodeVisitNo");
			/*
			 * JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
			 */
			 

			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "2", 1);
			dao.setProcInValue(procIndex1, "p_puk", "", 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
			dao.setProcInValue(procIndex1, "p_episodecode", "", 5);
			dao.setProcInValue(procIndex1, "p_visitno", "", 6);
			dao.setProcInValue(procIndex1, "p_json", JsonData, 7);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);
			dao.setProcInValue(procIndex1, "p_profiletype", "2", 9); // p_deptunitcode character varying, p_deptcode
																		// character varying,
			dao.setProcInValue(procIndex1, "p_deptunitcode", DeptUnitName.split("#")[1], 10);
			dao.setProcInValue(procIndex1, "p_deptcode", DeptUnitName.split("#")[0], 11);

			dao.setProcOutValue(procIndex1, "err", 1, 12);
			dao.executeProcedureByPosition(procIndex1);

			return;
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.SavePrescriptionBookMarkData()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return;
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void SaveEConsultancyData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_webservices.update_request_status(?,?,?,?,?, ?,?,?)}";

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			// String Crno = (String) object.get("CR_No");
			// String EpisodeCode = (String) object.get("episodeCode");
			// String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			// JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			// StringBuffer sb = new StringBuffer();

			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode_val", "1", 1);
			dao.setProcInValue(procIndex1, "p_req_id", PatCompleteGeneralDtl.split("#")[19], 2);
			dao.setProcInValue(procIndex1, "p_hosp_code", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_req_status", "3", 4);
			dao.setProcInValue(procIndex1, "p_cons_id", "", 5);
			dao.setProcInValue(procIndex1, "p_cons_name", "", 6);
			dao.setProcInValue(procIndex1, "p_cons_mob_no", "", 7);
			dao.setProcOutValue(procIndex1, "err", 1, 8);

			dao.execute(procIndex1, 1);

		} catch (Exception e) {

			throw e;
		}

	}

	public static void SaveAllergyData(String JsonData, HisDAO dao) throws Exception {

		int procIndex1 = 0;

		String strSensivityName = null, strAllergySytmptomsCode = null, strAllergysiteName = null,
				strAllergyRemarks = null, strSensivityCode = null, strAllergyNameCode = null,
				strAllergySytmptomsName = null, strAllergyName = null, stDurationTime = null, strAllergysiteCode = null;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("strDrugAllergy "+object.get("strDrugAllergy"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			// String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");

			JSONArray strDrugAllergy = (JSONArray) object.get("strDrugAllergy");
			int length = ((JSONArray) object.get("strDrugAllergy")).length();

			for (int i = 0; i < length; i++) {

				JSONObject strjsonObj = (JSONObject) strDrugAllergy.get(i);

				strSensivityName = (String) strjsonObj.get("strSensivityName") == null ? ""
						: (String) strjsonObj.get("strSensivityName");
				strAllergySytmptomsCode = (String) strjsonObj.get("strAllergySytmptomsCode") == null ? ""
						: (String) strjsonObj.get("strAllergySytmptomsCode");
				strAllergysiteName = (String) strjsonObj.get("strAllergysiteName") == null ? ""
						: (String) strjsonObj.get("strAllergysiteName");
				strAllergyRemarks = (String) strjsonObj.get("strAllergyRemarks") == null ? ""
						: (String) strjsonObj.get("strAllergyRemarks");
				strSensivityCode = (String) strjsonObj.get("strSensivityCode") == null ? ""
						: (String) strjsonObj.get("strSensivityCode");
				strAllergyNameCode = (String) strjsonObj.get("strAllergyNameCode") == null ? ""
						: (String) strjsonObj.get("strAllergyNameCode");
				strAllergySytmptomsName = (String) strjsonObj.get("strAllergySytmptomsName") == null ? ""
						: (String) strjsonObj.get("strAllergySytmptomsName");
				strAllergyName = (String) strjsonObj.get("strAllergyName") == null ? ""
						: ((String) strjsonObj.get("strAllergyName")).replace(";", "");
				;
				stDurationTime = (String) strjsonObj.get("stDurationTime") == null ? ""
						: (String) strjsonObj.get("stDurationTime");
				strAllergysiteCode = (String) strjsonObj.get("strAllergysiteCode") == null ? ""
						: (String) strjsonObj.get("strAllergysiteCode");

				String proc_name1 = "{call pkg_OpdDesk_dml.proc_hpmrt_pat_allergy_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
				dao.setProcInValue(procIndex1, "p_allergy_name", strAllergyName, 3);
				dao.setProcInValue(procIndex1, "p_allergy_type_code", strSensivityName, 4);
				dao.setProcInValue(procIndex1, "p_effective_frm", "", 5);
				dao.setProcInValue(procIndex1, "p_allergy_type", strSensivityName, 6);
				dao.setProcInValue(procIndex1, "p_allergy_id", strAllergyNameCode, 7);
				dao.setProcInValue(procIndex1, "p_isvalid", "1", 8);
				dao.setProcInValue(procIndex1, "p_seatid", seatId, 9);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 10);
				dao.setProcInValue(procIndex1, "p_duration_date", stDurationTime, 11);
				dao.setProcInValue(procIndex1, "p_entry_mode", "3", 12);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 13);
				dao.setProcInValue(procIndex1, "p_admission_no", "", 14);
				dao.setProcInValue(procIndex1, "p_sensitivity", strSensivityCode, 15);
				dao.setProcInValue(procIndex1, "p_symtom_desc", strAllergySytmptomsName + "^" + strAllergySytmptomsCode,
						16);
				dao.setProcInValue(procIndex1, "p_allergy_site", strAllergysiteName + "^" + strAllergysiteCode, 17);
				dao.setProcInValue(procIndex1, "p_advice", strAllergyRemarks, 18);
				dao.setProcOutValue(procIndex1, "err", 1, 19);
				dao.execute(procIndex1, 1);

			}

		} catch (Exception e) {
			throw e;
		}
	}

	public static void SaveChronicData(String JsonData, HisDAO dao) throws Exception {

		int procIndex1 = 0;
		 

		String strCronicDiseaseName = null, strCronicDiseaseId = null, strCronicDiseaseDuration = null,
				strCronicDiseaseRemarks = null;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("strDrugAllergy "+object.get("strChronicDisease"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");

		 
			JSONArray strChronicDisease = (JSONArray) object.get("strChronicDisease");
			int length = ((JSONArray) object.get("strChronicDisease")).length();

			for (int i = 0; i < length; i++) {

				JSONObject strjsonObj = (JSONObject) strChronicDisease.get(i);

				strCronicDiseaseName = (String) strjsonObj.get("CronicDiseaseName") == null ? ""
						: ((String) strjsonObj.get("CronicDiseaseName")).replace(";", "");
				strCronicDiseaseId = (String) strjsonObj.get("CronicDiseaseId") == null ? ""
						: (String) strjsonObj.get("CronicDiseaseId");
				strCronicDiseaseDuration = (String) strjsonObj.get("CronicDiseaseDuration") == null ? ""
						: (String) strjsonObj.get("CronicDiseaseDuration");
				strCronicDiseaseRemarks = (String) strjsonObj.get("CronicDiseaseRemarks") == null ? ""
						: (String) strjsonObj.get("CronicDiseaseRemarks");

				String proc_name1 = "{call pkg_OpdDesk_dml.proc_hpmrt_pat_alerts_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
				dao.setProcInValue(procIndex1, "p_disease_name", strCronicDiseaseName, 3);
				dao.setProcInValue(procIndex1, "p_disease_code", strCronicDiseaseId, 4);
				dao.setProcInValue(procIndex1, "p_effective_frm", "", 5);
				dao.setProcInValue(procIndex1, "p_advice", strCronicDiseaseRemarks, 6);
				dao.setProcInValue(procIndex1, "p_duration_date", strCronicDiseaseDuration, 7);
				dao.setProcInValue(procIndex1, "p_visitno", visitNo, 8);
				dao.setProcInValue(procIndex1, "p_isvalid", "1", 9);
				dao.setProcInValue(procIndex1, "p_admission_no", "", 10);
				dao.setProcInValue(procIndex1, "p_seatid", seatId, 11);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 12);
				dao.setProcInValue(procIndex1, "p_entry_mode", "3", 13);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 14);
				dao.setProcOutValue(procIndex1, "err", 1, 15);
				dao.execute(procIndex1, 1);

			}

		} catch (Exception e) {
			throw e;
		}
	}

	public static void SaveHistoryOfPresentIllNess(String JsonData,HisDAO dao) throws Exception {

	 
		int procIndex1 = 0;
		 

		String strpastHistory = null, strpersonalHistory = null, strfamilyHistory = null, strtreatmentHistory = null,
				strsurgicalHistory = null;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("strDrugAllergy "+object.get("strChronicDisease"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");

		 
			// JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
			// int length=((JSONArray) object.get("strCompleteHistory")).length();
		 

			String strHistoryOfPresentIllNess = (String) object.get("strHistoryOfPresentIllNess") == null ? ""
					: (String) object.get("strHistoryOfPresentIllNess");
			JSONObject strjsonObj = (JSONObject) object.get("strCompleteHistory");

			strpastHistory = (String) strjsonObj.get("strpastHistory") == null ? ""
					: ((String) strjsonObj.get("strpastHistory")).replace(";", "");
			strpersonalHistory = (String) strjsonObj.get("strpersonalHistory") == null ? ""
					: (String) strjsonObj.get("strpersonalHistory");
			strfamilyHistory = (String) strjsonObj.get("strfamilyHistory") == null ? ""
					: (String) strjsonObj.get("strfamilyHistory");
			strtreatmentHistory = (String) strjsonObj.get("strtreatmentHistory") == null ? ""
					: (String) strjsonObj.get("strtreatmentHistory");
			strsurgicalHistory = (String) strjsonObj.get("strsurgicalHistory") == null ? ""
					: (String) strjsonObj.get("strsurgicalHistory");

			String proc_name1 = "{call pkg_OpdDesk_dml.proc_ehrt_pat_hpi_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 4);
			dao.setProcInValue(procIndex1, "p_visitno", visitNo, 5);
			dao.setProcInValue(procIndex1, "p_record_date", "", 6);
			dao.setProcInValue(procIndex1, "p_slno", "1", 7);
			dao.setProcInValue(procIndex1, "p_admission_no", "", 8);
			dao.setProcInValue(procIndex1, "p_hpi", strHistoryOfPresentIllNess, 9);
			dao.setProcInValue(procIndex1, "p_personal_history", strpersonalHistory, 10);
			dao.setProcInValue(procIndex1, "p_family_history", strfamilyHistory, 11);
			dao.setProcInValue(procIndex1, "p_treatment_history", strtreatmentHistory, 12);
			dao.setProcInValue(procIndex1, "p_surgical_history", strsurgicalHistory, 13);
			dao.setProcInValue(procIndex1, "p_drug_addiction_history", "", 14);
			dao.setProcInValue(procIndex1, "p_menstrual_obstetrics_history", "", 15);
			dao.setProcInValue(procIndex1, "p_birth_history", "", 16);
			dao.setProcInValue(procIndex1, "p_development_history", "", 17);
			dao.setProcInValue(procIndex1, "p_immunization_history", "", 18);
			dao.setProcInValue(procIndex1, "p_nutrition_history", "", 19);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 20);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 21);
			dao.setProcInValue(procIndex1, "p_entry_source", "3", 22);
			dao.setProcInValue(procIndex1, "p_past_history", strpastHistory, 23);
			dao.setProcInValue(procIndex1, "p_other_relevant_history", "", 24);

			dao.setProcOutValue(procIndex1, "err", 1, 25);

			dao.execute(procIndex1,1);
 

		} catch (Exception e) {
			 throw e;
		}  
	}

	public static void SaveCompleteHistoryData(String JsonData, HisDAO dao) throws Exception {

		 

		int procIndex1 = 0;
		 

		String strpastHistory = null, strpersonalHistory = null, strfamilyHistory = null, strtreatmentHistory = null,
				strsurgicalHistory = null;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("strDrugAllergy "+object.get("strChronicDisease"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");

		 
			// JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
			// int length=((JSONArray) object.get("strCompleteHistory")).length();
		//	dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");

			// String strHistoryOfPresentIllNess=(String)
			// object.get("strHistoryOfPresentIllNess")==null ? "" : (String)
			// object.get("strHistoryOfPresentIllNess") ;
			JSONObject strjsonObj = (JSONObject) object.get("strCompleteHistory");

			strpastHistory = (String) strjsonObj.get("strpastHistory") == null ? ""
					: ((String) strjsonObj.get("strpastHistory")).replace(";", "");
			strpersonalHistory = (String) strjsonObj.get("strpersonalHistory") == null ? ""
					: (String) strjsonObj.get("strpersonalHistory");
			strfamilyHistory = (String) strjsonObj.get("strfamilyHistory") == null ? ""
					: (String) strjsonObj.get("strfamilyHistory");
			strtreatmentHistory = (String) strjsonObj.get("strtreatmentHistory") == null ? ""
					: (String) strjsonObj.get("strtreatmentHistory");
			strsurgicalHistory = (String) strjsonObj.get("strsurgicalHistory") == null ? ""
					: (String) strjsonObj.get("strsurgicalHistory");

			String proc_name1 = "{call pkg_OpdDesk_dml.proc_ehrt_pat_cln_history_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 4);
			dao.setProcInValue(procIndex1, "p_visitno", visitNo, 5);
			dao.setProcInValue(procIndex1, "p_record_date", "", 6);
			dao.setProcInValue(procIndex1, "p_slno", "1", 7);
			dao.setProcInValue(procIndex1, "p_admission_no", "", 8);
			dao.setProcInValue(procIndex1, "p_personal_history", strpersonalHistory, 9);
			dao.setProcInValue(procIndex1, "p_family_history", strfamilyHistory, 10);
			dao.setProcInValue(procIndex1, "p_treatment_history", strtreatmentHistory, 11);
			dao.setProcInValue(procIndex1, "p_surgical_history", strsurgicalHistory, 12);
			dao.setProcInValue(procIndex1, "p_drug_addiction_history", "", 13);
			dao.setProcInValue(procIndex1, "p_menstrual_obstetrics_history", "", 14);
			dao.setProcInValue(procIndex1, "p_birth_history", "", 15);
			dao.setProcInValue(procIndex1, "p_development_history", "", 16);
			dao.setProcInValue(procIndex1, "p_immunization_history", "", 17);
			dao.setProcInValue(procIndex1, "p_nutrition_history", "", 18);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 19);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 20);
			dao.setProcInValue(procIndex1, "p_entry_source", "3", 21);
			dao.setProcInValue(procIndex1, "p_past_history", strpastHistory, 22);
			dao.setProcInValue(procIndex1, "p_other_relevant_history", "", 23);

			dao.setProcOutValue(procIndex1, "err", 1, 24);

			dao.execute(procIndex1,1);
 

		} catch (Exception e) {
			 throw e;
		}  
	}

	public static void SaveExamniationData(String JsonData, HisDAO dao) throws Exception {

		 

		int procIndex1 = 0;
		 

		// "strSystematicExamniation":{"strcvs":"","strrs":"","strcns":"","strpA":"","strotherExamn":"","strmuscularExamn":"","strLocalExamn":""}

		String strcvs = null, strrs = null, strcns = null, strpA = null, strotherExamn = null, strmuscularExamn = null;
			 

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("strDrugAllergy "+object.get("strChronicDisease"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));

			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");

	 
			// JSONArray strCompleteHistory =(JSONArray) object.get("strCompleteHistory");
			// int length=((JSONArray) object.get("strCompleteHistory")).length();
		 

			JSONObject strjsonObj = (JSONObject) object.get("strSystematicExamniation");

			strcvs = (String) strjsonObj.get("strcvs") == null ? ""
					: ((String) strjsonObj.get("strcvs")).replace(";", "");
			strrs = (String) strjsonObj.get("strrs") == null ? "" : (String) strjsonObj.get("strrs");
			strcns = (String) strjsonObj.get("strcns") == null ? "" : (String) strjsonObj.get("strcns");
			strpA = (String) strjsonObj.get("strpA") == null ? "" : (String) strjsonObj.get("strpA");
			strotherExamn = (String) strjsonObj.get("strotherExamn") == null ? ""
					: (String) strjsonObj.get("strotherExamn");
			strmuscularExamn = (String) strjsonObj.get("strmuscularExamn") == null ? ""
					: (String) strjsonObj.get("strmuscularExamn");
			/*
			 * strLocalExamn = (String) strjsonObj.get("strLocalExamn") == null ? "" :
			 * (String) strjsonObj.get("strLocalExamn");
			 */

			String proc_name1 = "{call pkg_OpdDesk_dml.proc_ehrt_pat_sys_exam_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "p_mode", "1", 1);
			dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 4);
			dao.setProcInValue(procIndex1, "p_visitno", visitNo, 5);
			dao.setProcInValue(procIndex1, "p_record_date", "", 6);
			dao.setProcInValue(procIndex1, "p_slno", "1", 7);
			dao.setProcInValue(procIndex1, "p_admission_no", "", 8);
			dao.setProcInValue(procIndex1, "p_g_p_exam", "", 9);
			dao.setProcInValue(procIndex1, "p_chest_exam", "", 10);
			dao.setProcInValue(procIndex1, "p_cvs_exam", strcvs, 11);
			dao.setProcInValue(procIndex1, "p_rs_exam", strrs, 12);
			dao.setProcInValue(procIndex1, "p_cns_exam", strcns, 13);
			dao.setProcInValue(procIndex1, "p_muscskel_exam", "", 14);
			dao.setProcInValue(procIndex1, "p_abdomen_exam", "", 15);
			dao.setProcInValue(procIndex1, "p_gi_sys_exam", "", 16);
			dao.setProcInValue(procIndex1, "p_p_a_exam", strpA, 17);
			dao.setProcInValue(procIndex1, "p_developmental_exam", strotherExamn, 18);
			dao.setProcInValue(procIndex1, "p_muscular_exam", strmuscularExamn, 19);
			dao.setProcInValue(procIndex1, "p_isvalid", "1", 20);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 21);
			dao.setProcInValue(procIndex1, "p_entry_source", "3", 22);

			dao.setProcOutValue(procIndex1, "err", 1, 23);

			dao.execute(procIndex1,1);

			 

		} catch (Exception e) {
			 throw e;
		}  
	}

	public static String saveOfflinePatCountDtl(String JsonData) {

	 
		String proc_name1 = "{call pkg_OpdDesk_dml.proc_insert_offlinepatcount_data(?,?,?,?,?, ?,?,?,?,?,?)}";

		int procIndex1 = 0;
		HisDAO dao = null;

		try {

			JSONObject object = new JSONObject(JsonData);

			String deptCode = (String) object.get("deptCode");
			String deptUnitCode = (String) object.get("deptUnitCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("strHospitalCode");
			String visitedPatCount = (String) object.get("visitedPatCount");
			String totalPatCount = (String) object.get("totalPatCount");
			String offlinePatientCount = (String) object.get("strOfflinePatientCount");
			String opdDate = (String) object.get("opdDate");

			dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "1", 1);
			dao.setProcInValue(procIndex1, "deptCode", deptCode, 2);
			dao.setProcInValue(procIndex1, "deptUnitCode", deptUnitCode, 3);
			dao.setProcInValue(procIndex1, "seatId", seatId, 4);
			dao.setProcInValue(procIndex1, "hosp_code", hosp_code, 5);
			dao.setProcInValue(procIndex1, "visitedPatCount", visitedPatCount, 6);
			dao.setProcInValue(procIndex1, "totalPatCount", totalPatCount, 7);
			dao.setProcInValue(procIndex1, "offlinePatientCount", offlinePatientCount, 8);
			dao.setProcInValue(procIndex1, "isvalid", "1", 9);
			dao.setProcInValue(procIndex1, "opdDate", opdDate, 10);

			dao.setProcOutValue(procIndex1, "err", 1, 11);
			dao.executeProcedureByPosition(procIndex1);

			return "1";
		} catch (Exception e) {
		  new HisException("OPD Ver-2.0", "opdDrDeskDao.saveOfflinePatCountDtl()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			return "0";
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
	}

	public static void saveClinicalProcedure(String JsonData, HisDAO dao) throws Exception {
		 
		String strProcName1 = "{call pkg_opddesk_dml.SaveServiceRequisitionOfflineNew1(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)}";

		int nInsertedIndex1 = 0;
	 
		try {
			JSONObject object = new JSONObject(JsonData);
			// System.out.println("saveClinicalProcedure JsonData" + JsonData);
			/*
			 * System.out.println("CR_No" + object.get("CR_No"));
			 * System.out.println("episodeCode" + object.get("episodeCode"));
			 * System.out.println("seatId" + object.get("seatId"));
			 * System.out.println("hosp_code" + object.get("hosp_code"));
			 */
			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo = (String) object.get("episodeVisitNo");
			String admissionNo = "";
			JSONArray strClinicalProcedure = (JSONArray) object.get("strClinicalProcedure");
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			if (strClinicalProcedure != null) {

				for (int i = 0; i < strClinicalProcedure.length(); i++) {

					String tmp = (String) strClinicalProcedure.get(i);
					String tmpArray[] = tmp.split("\\#");

				//	dao = new HisDAO("OPD DR DESK DAO", "opdDrDeskDao.save()");
					nInsertedIndex1 = dao.setProcedure(strProcName1);
					dao.setProcInValue(nInsertedIndex1, "modval", "1", 1);
					dao.setProcInValue(nInsertedIndex1, "hospcode", hosp_code, 2);
					dao.setProcInValue(nInsertedIndex1, "patcrnum", Crno, 3);
					dao.setProcInValue(nInsertedIndex1, "sareacode", tmpArray[5].split("\\^")[0], 4);
					dao.setProcInValue(nInsertedIndex1, "deptcode", PatCompleteGeneralDtl.split("\\#")[6], 5);
					dao.setProcInValue(nInsertedIndex1, "proc_code", tmpArray[1].split("\\^")[0], 6);
					dao.setProcInValue(nInsertedIndex1, "procdate", PatCompleteGeneralDtl.split("\\#")[7].trim(), 7);
					// if(service_Req_dtlVO.getServiceTimeHr()[x]==null ||
					// service_Req_dtlVO.getServiceTimeHr()[x].equals(""))
					// {
					dao.setProcInValue(nInsertedIndex1, "proctime", "00:00", 8);
					// }
					/*
					 * else { dao.setProcInValue(nInsertedIndex1, "proctime",
					 * service_Req_dtlVO.getServiceTimeHr()[x]+":"+service_Req_dtlVO.
					 * getServiceTimeMin()[x], 8); }
					 */

					dao.setProcInValue(nInsertedIndex1, "apptstatus", "0", 9);
					dao.setProcInValue(nInsertedIndex1, "appno", "0", 10);
					dao.setProcInValue(nInsertedIndex1, "reqstatusraised", "0", 11);
					dao.setProcInValue(nInsertedIndex1, "seatid", seatId, 12);
					dao.setProcInValue(nInsertedIndex1, "episodecode", EpisodeCode, 13);
					dao.setProcInValue(nInsertedIndex1, "visitno", EpisodeVisitNo, 14);
					dao.setProcInValue(nInsertedIndex1, "remarks", tmpArray[4].trim(), 15);
					dao.setProcInValue(nInsertedIndex1, "paraflag", "0", 16);
					dao.setProcOutValue(nInsertedIndex1, "err", 1, 17);
					dao.setProcInValue(nInsertedIndex1, "serviceReqNo", "0", 18);
					dao.setProcInValue(nInsertedIndex1, "admissionNo", admissionNo, 19);
					dao.setProcInValue(nInsertedIndex1, "wardCode", "", 20);
					dao.setProcInValue(nInsertedIndex1, "tariffId", tmpArray[1].split("\\^")[0], 21);
					dao.setProcInValue(nInsertedIndex1, "quantity", "1", 22);
					dao.setProcInValue(nInsertedIndex1, "count", "0", 23);
					dao.execute(nInsertedIndex1,1);

				}
			}
			 
		} catch (Exception e) {
			 throw e;
		}  
	}

	public static String getAllPreviousVitalDtls(String JsonData) {

		JSONObject mainObj = new JSONObject();
		HisDAO dao = null;
		WebRowSet ws = null;

		JSONObject object = null;
		try {
			object = new JSONObject(JsonData);

			String mode = "1";
			String crno = (String) object.get("CR_No") == null ? "" : (String) object.get("CR_No");
			String episodeCode = (String) object.get("episodeCode") == null ? "" : (String) object.get("episodeCode");
			String visitNo = (String) object.get("visitNo") == null ? "" : (String) object.get("visitNo");
			String seatId = "";
			String entrydate = "";
			String hosp_code = (String) object.get("hospitalCode") == null ? "" : (String) object.get("hospitalCode");

			/* Get EHR Details */
			String err = "";
			String proc_name1 = "{call pkg_opddrdesk_view.get_all_previous_vital_dtls(?,?,?,?,? ,?,?,?,?)}";
			int procIndex1 = 0;

			String status = "0";

			JSONArray arr = new JSONArray();
			 
		 

			// System.out.println("crno::::::::::::::"+crno);
			dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modeval", mode, 1);
			dao.setProcInValue(procIndex1, "crno", crno, 2);
			dao.setProcInValue(procIndex1, "episodeCode", episodeCode, 3);
			dao.setProcInValue(procIndex1, "visitNo", visitNo, 4);
			dao.setProcInValue(procIndex1, "seatId", seatId, 5);
			dao.setProcInValue(procIndex1, "entrydate", entrydate, 6);
			dao.setProcInValue(procIndex1, "hosp_code", hosp_code, 7);
			dao.setProcOutValue(procIndex1, "err", 1, 8);
			dao.setProcOutValue(procIndex1, "resultset", 2, 9);
			// dao.executeProcedureByPosition(procIndex1);

			dao.executeProcedureByPosition(procIndex1);
			err = dao.getString(procIndex1, "err");
			if (err.equals("")) {
				ws = dao.getWebRowSet(procIndex1, "resultset");
				status = "1";
			}
			if (ws != null && ws.size() > 0) {
				arr = printJSONObject(ws);
				// System.out.println("arr>>>>>" + arr);
			}
			mainObj.put("status", status);
			mainObj.put("VitalDtls", arr);
			if (ws != null) {
				ws.close();
				ws = null;
			}
			return mainObj.toString();

		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "getPatinetEHRDtls.getVitalDtlsDtls()-->",
					e.getMessage() + "-->" + e);
			e.printStackTrace();
			try {
				mainObj.put("status", "0");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			return mainObj.toString();
		}

		finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return mainObj.toString();
	}

	public static JSONArray printJSONObject(WebRowSet ws) throws Exception {
		JSONArray arr = new JSONArray();
		try {
			if (ws != null) {

				ResultSetMetaData rsmd = ws.getMetaData();
				int colCount = rsmd.getColumnCount();
				while (ws.next()) {
					JSONObject jsonObject = new JSONObject();
					try {
						Field changeMap = jsonObject.getClass().getDeclaredField("map");
						changeMap.setAccessible(true);
						changeMap.set(jsonObject, new LinkedHashMap<>());
						changeMap.setAccessible(false);
					} catch (IllegalAccessException | NoSuchFieldException e) {
						System.out.println(e.getMessage());
					}
					for (int i = 1; i <= colCount; i++) {

						String key = rsmd.getColumnName(i).trim();
						if (key.equals("?column?")) {
							key = "column_" + i;
						}
						String value = ws.getString(i) == null ? "" : ws.getString(i);
						jsonObject.put(key, value);
					}
					arr.put(jsonObject);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (ws != null) {
				ws.close();
				ws = null;
			}
		}
		return arr;
	}
	
	public static boolean deletePreviousDataData(String JsonData, HisDAO dao) throws Exception {

		//deletePreviousData(p_puk character varying, p_hospcode character varying, p_seatid character varying, 
		//		p_episodecode character varying, p_visitno character varying, OUT err character varying) IS 
		String proc_name1 = "{call pkg_OpdDesk_dml.deletePreviousData(?,?,?,?,?,?)}";
		boolean flag=false;
		int procIndex1 = 0;
	 
		

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			/*
			 * System.out.println("Diagnosis "+object.get("Diagnosis"));
			 * System.out.println("CR_No"+object.get("CR_No"));
			 * System.out.println("episodeCode"+object.get("episodeCode"));
			 */

			 String Crno=(String) object.get("CR_No");
			 String EpisodeCode=(String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			 String EpisodeVisitNo=(String) object.get("episodeVisitNo");
			/*
			 * JSONArray ReasonOfVisit =(JSONArray) object.get("ReasonOfVisit");
			 */
		 

			
			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "p_puk", Crno, 1);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 2);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 3);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 4);
			dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 5);
			dao.setProcOutValue(procIndex1, "err", 1, 6);
			
			dao.execute(procIndex1, 1);
			
			 
		} catch (Exception e) {
			 throw e;
		} 
		return flag;
	}
	
	public static void saveReferPatientDetails(String JsonData, HisDAO dao) throws Exception {

		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			// System.out.println("JsonData"+JsonData);
			// System.out.println("Diagnosis "+object.get("Diagnosis"));
			// System.out.println("CR_No"+object.get("CR_No"));
			// System.out.println("episodeCode"+object.get("episodeCode"));
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			String fromDept= PatCompleteGeneralDtl.split("\\#")[6];
			String fromDeptUnit= PatCompleteGeneralDtl.split("\\#")[5];
			String Crno = (String) object.get("CR_No");
			String EpisodeCode = (String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String visitNo = (String) object.get("episodeVisitNo");
			// String strRefrealRemaks=(String) object.get("strReffralReason");
			// StringBuffer sb = new StringBuffer();
			JSONArray strRefferalDept = (JSONArray) object.get("strReferal");
			int length = ((JSONArray) object.get("strReferal")).length();

			for (int i = 0; i < length; i++) {
				JSONObject strjsonObj = (JSONObject) strRefferalDept.get(i);
				String proc_name1 = "{call pkg_OpdDesk_dml.patient_referal_confirmation_flag(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_puk", Crno, 2);
				dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 3);
				dao.setProcInValue(procIndex1, "p_seatId", seatId, 4);
				dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 5);
				dao.setProcInValue(procIndex1, "from_dept", fromDept, 6);
				dao.setProcInValue(procIndex1, "from_deptunit", fromDeptUnit, 7);
				dao.setProcInValue(procIndex1, "to_dept",((String) (strjsonObj.get("strReffralDeptDone"))).split("#")[0], 8);
				dao.setProcInValue(procIndex1, "to_deptunit",((String) (strjsonObj.get("strReffralDeptDone"))).split("#")[1], 9);
				dao.setProcInValue(procIndex1, "p_visitno", visitNo, 10);
				dao.setProcInValue(procIndex1, "to_ip_address", "", 11);
				dao.setProcInValue(procIndex1, "remarks", (String) strjsonObj.get("strReffralReason"), 12);
				dao.setProcInValue(procIndex1, "isref_out","1", 13);
				dao.setProcInValue(procIndex1, "p_json", JsonData, 14);
				dao.setProcOutValue(procIndex1, "err", 1, 15);
				dao.execute(procIndex1, 1);
				
			}

		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void saveExternalRefferral(String JsonData, HisDAO dao) throws Exception {

		//deletePreviousData(p_puk character varying, p_hospcode character varying, p_seatid character varying, 
		//		p_episodecode character varying, p_visitno character varying, OUT err character varying) IS 
		String proc_name1 = "{call pkg_OpdDesk_dml.proc_save_external_refferral(?,?,?,?,?,?,?,?,?)}";
	 
		int procIndex1 = 0;
	 
		

		try {

			JSONObject object = new JSONObject(JsonData);
			String Crno=(String) object.get("CR_No");
			String EpisodeCode=(String) object.get("episodeCode");
			String seatId = (String) object.get("seatId");
			String hosp_code = (String) object.get("hosp_code");
			String EpisodeVisitNo=(String) object.get("episodeVisitNo");
			String PatCompleteGeneralDtl = (String) object.get("PatCompleteGeneralDtl");
			String deptcode=PatCompleteGeneralDtl.split("#")[6];
			String deptunitcode=PatCompleteGeneralDtl.split("#")[5];
			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "p_puk", Crno, 1);
			dao.setProcInValue(procIndex1, "p_hospcode", hosp_code, 2);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 3);
			dao.setProcInValue(procIndex1, "p_episodecode", EpisodeCode, 4);
			dao.setProcInValue(procIndex1, "p_visitno", EpisodeVisitNo, 5);
			dao.setProcInValue(procIndex1, "strjson", JsonData, 6);
			dao.setProcInValue(procIndex1, "p_deptCode", deptcode, 7);
			dao.setProcInValue(procIndex1, "p_deptUnitCode", deptunitcode, 8);
			dao.setProcOutValue(procIndex1, "err", 1, 9);
			 
			dao.execute(procIndex1, 1);
			
		} catch (Exception e) {
			 throw e;
		} 
		 
	}

	public static boolean ReferralVisitStamping(String JsonData) {
		
		HisDAO dao=null;
		String proc_name1 = "{call pkg_opddesk_dml.proc_refferral_visit_stamp(?,?,?,?,?,?,?,?,?)}";
		boolean flag=false;
		int procIndex1 = 0;
		System.out.println("ReferralVisitStamping JsonData>>>" + JsonData);
		 dao = new HisDAO("WebServices", "opdDrDeskDao.ReferralVisitStamping()");

		try {

			JSONObject object = new JSONObject(JsonData);
			String Crno=(String) object.get("CR_No");
			String episodeCode=(String) object.get("episodeCode");
			String visitNo=(String) object.get("visitNo");
			String refSno=(String) object.get("refSno");
			String toDeptCode=(String) object.get("to_dept_code");
			String toDeptUnitCode=(String) object.get("to_deptunitcode");
			String seatId = (String) object.get("seatId");
			String hospitalCode = (String) object.get("hospitalCode");
						
			procIndex1 = dao.setProcedure(proc_name1);
			
			dao.setProcInValue(procIndex1, "p_puk", Crno, 1);
			dao.setProcInValue(procIndex1, "p_episodecode", episodeCode, 2);
			dao.setProcInValue(procIndex1, "p_visitno", visitNo, 3);
			dao.setProcInValue(procIndex1, "p_refSno", refSno, 4);
			dao.setProcInValue(procIndex1, "p_toDeptCode", toDeptCode, 5);
			dao.setProcInValue(procIndex1, "p_toDeptUnitCode", toDeptUnitCode, 6);
			dao.setProcInValue(procIndex1, "p_seatid", seatId, 7);
			dao.setProcInValue(procIndex1, "p_hospcode", hospitalCode, 8);
			dao.setProcOutValue(procIndex1, "err", 1, 9);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			if(StringUtils.isBlank(errMsg))
				flag=true;
			else {
				flag=false;
				//System.out.println("ReferralVisitStamping errMsg>>>>" + errMsg);
			}
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.ReferralVisitStamping()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();
			flag=false;
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return flag;
		
		
	}

	public static JSONObject blockReleaseStoreQuantity(JSONObject object) {
		HisDAO dao=null;
		String proc_name1 = "{call pharmacy_final.pkg_mms_drdesk_dtl.dml_block_qty_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
		int procIndex1 = 0;
		//System.out.println("blockReleaseStoreQuantity JsonData>>>" + jsonData);
		dao = new HisDAO("WebServices", "opdDrDeskDao.blockReleaseStoreQuantity()");
		JSONObject resultObject = new JSONObject();
		
		try {
			resultObject.put("status", "ERROR");
						
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "modeval", object.getString("modeVal"), i++);
			dao.setProcInValue(procIndex1, "hospital_code", object.getString("hospitalCode"), i++);
			dao.setProcInValue(procIndex1, "benid", object.getString("CR_No"), i++);
			dao.setProcInValue(procIndex1, "episodecode", object.getString("EpisodeCode"), i++);
			dao.setProcInValue(procIndex1, "visitno", object.getString("VisitNo"), i++);
			dao.setProcInValue(procIndex1, "brandid", object.getString("drugBrandId"), i++);
			dao.setProcInValue(procIndex1, "prgid", object.getString("programId"), i++);
			dao.setProcInValue(procIndex1, "avlstock", object.getString("drugQuan"), i++);
			dao.setProcInValue(procIndex1, "presqty", object.getString("patientDrugQuantity"), i++);
			dao.setProcInValue(procIndex1, "drugstatus", object.getString("drugStatus"), i++);
			dao.setProcInValue(procIndex1, "seatid", object.getString("seatId"), i++);
			
			dao.setProcOutValue(procIndex1, "issuestatus", 1, i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			String issuestatus  = dao.getString(procIndex1, "issuestatus");
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");
				resultObject.put("issuestatus", issuestatus);
			}
			/*
			 * else { System.out.println("blockReleaseStoreQuantity errMsg>>>>" + errMsg); }
			 */
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.blockReleaseStoreQuantity()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;
	}
	
	
	public static void drugFinalSaveDtl(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pharmacy_final.pkg_mms_drdesk_dtl.dml_drdesk_drug_final_save_dtl(?,?,?,?,?,?,?,?)}";
	
		int procIndex1 = 0;

		try {

			JSONObject object = new JSONObject(JsonData);
			
			int indx=1;
			
		
			
			
			procIndex1 = dao.setProcedure(proc_name1);
			dao.setProcInValue(procIndex1, "modval", "1", indx++);
			dao.setProcInValue(procIndex1, "hospcode", object.getString("hosp_code"), indx++);
			dao.setProcInValue(procIndex1, "benid", object.getString("CR_No"), indx++);
			dao.setProcInValue(procIndex1, "episodecode", object.getString("episodeCode"), indx++);
			dao.setProcInValue(procIndex1, "visitno", object.getString("episodeVisitNo"), indx++);
			dao.setProcInValue(procIndex1, "seatid", object.getString("seatId"), indx++);
			dao.setProcInValue(procIndex1, "ismodify", object.getString("isModify"), indx++);
			dao.setProcOutValue(procIndex1, "err", 1, indx++);

			dao.execute(procIndex1, 1);
			

		} catch (Exception e) {
			throw e;
		}

	}


	
	public static JSONObject savePatientReview(String jsonData) {
		HisDAO dao=null;
		String proc_name1 = "{call opd.pkg_opddesk_dml.proc_save_patient_review(?,?,?,?,?,?,?,?,?)}";
		
		int procIndex1 = 0;
		//System.out.println("savePatientReview JsonData>>>" + jsonData);
		dao = new HisDAO("WebServices", "opdDrDeskDao.savePatientReview()");
		JSONObject resultObject = new JSONObject();

			
		try {
			resultObject.put("status", "ERROR");
			JSONObject object = new JSONObject(jsonData);
						
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "p_puk", object.getString("CR_No"), i++);
			dao.setProcInValue(procIndex1, "p_episodecode", object.getString("episodeCode"), i++);
			dao.setProcInValue(procIndex1, "p_visitno",object.getString("visitNo") , i++);
			dao.setProcInValue(procIndex1, "p_review_status", object.getString("reviewStatus"), i++);
			dao.setProcInValue(procIndex1, "p_remarks", object.getString("reviewRemarks"), i++);
			dao.setProcInValue(procIndex1, "p_review_given_by_name", object.getString("reviewGivenBy"), i++);
			dao.setProcInValue(procIndex1, "p_seatid", object.getString("seatId"), i++);
			dao.setProcInValue(procIndex1, "p_hospcode", object.getString("hospitalCode"), i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");			
			}
			/*
			 * else { System.out.println("savePatientReview errMsg>>>>" + errMsg); }
			 */
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.savePatientReview()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;
	}
	
	public static JSONObject AcceptPatientFromPoolSmartQMS(String jsonData) {
		HisDAO dao=null;
		String proc_name1 = "{call appointment.pkg_online_queue_dtl.save_bendata_dr_pool(?,?,?,?,?,?)}";
		
		
		
		int procIndex1 = 0;
		
		dao = new HisDAO("WebServices", "opdDrDeskDao.AcceptPatientFromPool()");
		JSONObject resultObject = new JSONObject();

			
		try {
			resultObject.put("status", "ERROR");
			JSONObject object = new JSONObject(jsonData);
						
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "modevalue", "1", i++);
			dao.setProcInValue(procIndex1, "hospitalcode", object.getString("hospitalcode"), i++);
			dao.setProcInValue(procIndex1, "deptunitid",object.getString("deptunitid") , i++);
			dao.setProcInValue(procIndex1, "internalqueueno", object.getString("internalqueueno"), i++);
			dao.setProcInValue(procIndex1, "queuesymbol", object.getString("queuesymbol"), i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");			
			}
			/*
			 * else { System.out.println("savePatientReview errMsg>>>>" + errMsg); }
			 */
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.AcceptPatientFromPool()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;
	}
	

	public static void SaveFollowUpVisitReasonData(String JsonData, HisDAO dao) throws Exception {

		String proc_name1 = "{call pkg_OpdDesk_dml.proc_save_pat_visit_dtl(?,?,?, ?,?,?, ?,?,?)}";

		int procIndex1 = 0;

		try {

			
			JSONObject object = new JSONObject(JsonData);
			JSONArray ReasonOfVisit = (JSONArray) object.get("ReasonOfVisit");
			
			JSONArray FOLLOWUPDTL = (JSONArray) object.get("FOLLOW_UP");
			
			StringBuffer snomedpt = new StringBuffer();
			StringBuffer snomedcid = new StringBuffer();
			String plannedVisitDays=null;
			String plannedVisitDate=null;
			String progressNote=null;
			if (ReasonOfVisit != null) {
				for (int i = 0; i < ReasonOfVisit.length(); i++) {
					snomedpt.append((ReasonOfVisit.get(i).toString().split("\\^")[1]).replaceAll(";", "") + ",");
					snomedcid.append((ReasonOfVisit.get(i).toString().split("\\^")[0]).replaceAll(";", "") + "#");
				}
			}
			
			if (FOLLOWUPDTL.length() > 0) {
				JSONObject FollowupJson = (JSONObject) FOLLOWUPDTL.get(0);
				JSONArray arr = (JSONArray) FollowupJson.get("Planned_Visit");
				progressNote = (String) FollowupJson.get("progressNote");

				// System.out.println("arr"+arr);
				JSONObject temp = (JSONObject) arr.get(0);
				plannedVisitDays=temp.getString("plannedVisitDays");
				plannedVisitDate=temp.getString("plannedVisitDate");
			}
		

				procIndex1 = dao.setProcedure(proc_name1);
				dao.setProcInValue(procIndex1, "p_mode", "1", 1);
				dao.setProcInValue(procIndex1, "p_visitreason", snomedpt.toString(), 2);
				dao.setProcInValue(procIndex1, "p_snomedpt", snomedpt.toString(), 3);
				dao.setProcInValue(procIndex1, "p_snomedcid", snomedcid.toString(), 4);
				dao.setProcInValue(procIndex1, "p_plannedVisitDays", plannedVisitDays, 5);
				dao.setProcInValue(procIndex1, "p_plannedVisitDate", plannedVisitDate, 6);
				dao.setProcInValue(procIndex1, "p_progressNote", progressNote, 7);
				dao.setProcInValue(procIndex1, "p_str_json", JsonData, 8);
				dao.setProcOutValue(procIndex1, "err", 1, 9);
				dao.execute(procIndex1, 1);
			/*
			 * String errMsg = dao.getString(procIndex1, "err");
			 * if(StringUtils.isBlank(errMsg)) { System.out.println("errMsg>>>" + errMsg); }
			 */

		} catch (Exception e) {
			throw e;

		}

	}

	public static JSONObject saveSectionBookmark( String jsonData) {
		HisDAO dao=null;
		String proc_name1 = "{call opd.pkg_opddesk_dml.proc_dml_section_bookmark(?,?,?,?,?,?,?,?)}";
		
		
		int procIndex1 = 0;
		//System.out.println("savePatientReview JsonData>>>" + jsonData);
		dao = new HisDAO("WebServices", "opdDrDeskDao.saveSectionBookmark()");
		JSONObject resultObject = new JSONObject();

			
		try {
			resultObject.put("status", "ERROR");
			JSONObject object = new JSONObject(jsonData);
						
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "p_modval", object.getString("mode"), i++);
			dao.setProcInValue(procIndex1, "p_seatid", object.getString("seatTd"), i++);
			dao.setProcInValue(procIndex1, "p_hospcode", object.getString("hospitalCode"), i++);
			dao.setProcInValue(procIndex1, "p_bookmark_type_id", object.getString("bookmarkTypeId"), i++);
			dao.setProcInValue(procIndex1, "p_bookmark_sno", object.getString("sectionSno"), i++);
			dao.setProcInValue(procIndex1, "p_bookmark_tag_name", object.getString("sectionTemplateName"), i++);			
			dao.setProcInValue(procIndex1, "p_bookmarkjsonstr", object.getString("sectionjson"), i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");			
			}
			/*
			 * else { System.out.println("savePatientReview errMsg>>>>" + errMsg); }
			 */
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.savePatientReview()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;

	}

	public static JSONObject UpdateQueueStatus_For_Withoutsmartqueue(String jsonData) {
		HisDAO dao=null;
		String proc_name1 = "{call opd.pkg_opddesk_dml.proc_UpdateQueueStatus_For_Withoutsmartqueue(?,?)}";
		
		int procIndex1 = 0;
		System.out.println("AcceptPatientFromPoolWithoutSmartQMS JsonData>>>" + jsonData);
		dao = new HisDAO("WebServices", "opdDrDeskDao.proc_AcceptPatientWithoutSmartQueue()");
		JSONObject resultObject = new JSONObject();

		

		try {
			resultObject.put("status", "ERROR");
			
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "strJsonText", jsonData, i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");			
			}
		
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.proc_AcceptPatientWithoutSmartQueue()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;
	}
	
	public static JSONObject UpdateQueueStatus_For_WithoutsmartqueueForApt(String jsonData) {
		HisDAO dao=null;
		String proc_name1 = "{call opd.pkg_opddesk_dml.proc_UpdateQueueStatus_For_WithoutsmartqueueForApt(?,?)}";
		
		int procIndex1 = 0;
		System.out.println("UpdateQueueStatus_For_WithoutsmartqueueForApt JsonData>>>" + jsonData);
		dao = new HisDAO("WebServices", "opdDrDeskDao.proc_AcceptPatientWithoutSmartQueueForApt()");
		JSONObject resultObject = new JSONObject();

		

		try {
			resultObject.put("status", "ERROR");
			
			procIndex1 = dao.setProcedure(proc_name1);
			int i=1;
			dao.setProcInValue(procIndex1, "strJsonText", jsonData, i++);
			dao.setProcOutValue(procIndex1, "err", 1, i++);
			dao.executeProcedureByPosition(procIndex1);
			String errMsg  = dao.getString(procIndex1, "err");
			
			if(StringUtils.isBlank(errMsg)) {
				resultObject.put("status", "SUCCESS");			
			}
		
		} catch (Exception e) {
			 new HisException("OPD Ver-2.0", "opdDrDeskDao.proc_AcceptPatientWithoutSmartQueueForApt()-->",e.getMessage() + "-->" + e);
			e.printStackTrace();			
		} 
		 finally {
	        	if (dao != null) {
	                dao.free();
	                dao = null;
	            }
	        }
		return resultObject;
	}
	
	public static String get_stock_qty(JSONObject object) {
		HisDAO dao=null;
		String strAvailableQty="0";
		try {
			dao = new HisDAO("WebServices", "get_stock_qty");
			// config_dtl (modval NUMBER, hosp_code NUMBER, paramname VARCHAR2)
			String strFuncName = "{? = call pharmacy_final.pkg_mms_drdesk_dtl.get_stock_qty (?, ?, ?, ?)}";
			// FUNCTION get_groupNameAndId_dtl (modeval NUMBER, hosp_code
			// NUMBER, itemId NUMBER)
			int nFuncIndex = dao.setFunction(strFuncName);
			dao.setFuncInValue(nFuncIndex, 2, "1");
			dao.setFuncInValue(nFuncIndex, 3, object.getString("seatId"));
			dao.setFuncInValue(nFuncIndex, 4, object.getString("hospitalCode"));
			dao.setFuncInValue(nFuncIndex, 5, object.getString("drugBrandId"));
			dao.setFuncOutValue(nFuncIndex, 1);
			dao.executeFunction(nFuncIndex);
			strAvailableQty = dao.getFuncString(nFuncIndex);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
		}
		return strAvailableQty;
	}
  	
}
