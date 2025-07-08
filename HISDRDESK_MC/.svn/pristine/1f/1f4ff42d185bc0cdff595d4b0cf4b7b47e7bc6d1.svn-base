package new_opd.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sql.rowset.WebRowSet;

import com.google.gson.Gson;

import HisWeb.bo.PathCareLabMCResponseObject;
import HisWeb.bo.PathCareLabsHandOverObject;
import HisWeb.bo.PathCareLabsHandOverObject.PatientDataHandOverObject;
import HisWeb.bo.PathCareLabsHandOverObject.PatientDataHandOverObject.InvestigationTestWiseHandOverDetailsObject;
import hisglobal.backutil.HisUtil;
import hisglobal.transactionmgnt.HisDAO;
import new_opd.transaction.controller.fb.MCPathLabSampleHandoverDetailFB;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MCPathLabSampleHandoverDetailMcNewDAO {
	
	private static final String BASE_URL = "http://pclacc.pathcarelabs.com/PathcareAAP/CronJob/API/AAmaadmiapi.aspx";	//"	PATH CARE LAB URL FOR WEBSERVICES
	private static final String USER_NAME = "";	
	private static final String PASSWORD = 	"";


	
	public static PathCareLabsHandOverObject saveSampleHandoverDtls(MCPathLabSampleHandoverDetailFB fb) throws Exception {

		HisDAO dao = null;

		String storeId = "";
		String storeName = "";
		//System.out.println("INSIDE SAVE DAO");
		
		PatientDataHandOverObject patientHandOverData = null;
		List <PatientDataHandOverObject> patientHandOverDataList =null;
		String crNo ="0", prevCrNo="0";
		String patName =null;
		String patGender =null;
		String patAge =null;
		String hosp_code =null;
		String hospName = null;
		String EpisodeCode = null;
		String mobNo = null;
		String strRequisitionNo = null;
		String handOverTo = null;
		String handOverDateTime = null;
		String handOverPersonMobile = null;
		String strReqDate = null;
		
		String testCode = null;
		String testName = null;
		String vialNo = null;
		String json = null;
		int nVialWiseTestsPerPatient=0;
		String strVialWiseTestsPerPatient[]=null;
		HisUtil hisutil = null;
		List<InvestigationTestWiseHandOverDetailsObject> testCodeArrList =null;
		String strAPIErrorMsg="";
		PathCareLabsHandOverObject pathCareLabHandOverObj =null;
			try {
				pathCareLabHandOverObj = new PathCareLabsHandOverObject();
				
				hisutil = new HisUtil("DrDesk", "opdDrDeskDao");
				
				dao = new HisDAO("", "");
				
				String proc_name6="{call pkg_inv_dml.Dml_mc_pathlab_dtl(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?, ?)}"; //18 values --By Vivek Aggarwal as on 04-Sep-2023
				int procIndex6 =0;
				procIndex6 = dao.setProcedure(proc_name6);
				
				
				handOverTo = fb.getStrHandoverToDet();
				handOverDateTime = hisutil.getASDate("dd-MMM-yyyy HH:mm:ss"); //fb.getStrDte()+" " +fb.getStrTime();
				handOverPersonMobile = fb.getStrHandoverToMob();
				
				//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate
				if (fb.getStrHiddenValues() != null && fb.getStrHiddenValues().length>0)
				{		
					// Lab TestCode,TestName, vialNo(PathCareLab Webservice)
					patientHandOverDataList = new ArrayList<PatientDataHandOverObject>();//
					
					for (int z = 0; z < fb.getStrHiddenValues().length; z++) {
						
//						System.out.println("Hidden Val "+ fb.getStrHiddenValues()[z]);
//						System.out.println("DATE "+fb.getStrDte());
//						System.out.println("TIME "+fb.getStrTime());
//						System.out.println("DATE AND TIME >>>>>> "+ fb.getStrDte() + " " + fb.getStrTime());
//						System.out.println("details >>>>> "+fb.getStrHandoverToDet());
//						System.out.println("remarks >>>>> "+fb.getStrRemarks());
//						System.out.println("remarks >>>>> "+fb.getStrHandoverToMob());
						
						nVialWiseTestsPerPatient = fb.getStrHiddenValues()[z].split("\\#").length; // No. of Tests per Vial per Patient
//						strVialWiseTestsPerPatient = new String[nVialWiseTestsPerPatient];
						strVialWiseTestsPerPatient = fb.getStrHiddenValues()[z].split("\\#");
						
//						crNo = fb.getStrHiddenValues()[z].split("\\^")[2];
//						patName =fb.getStrHiddenValues()[z].split("\\^")[5];
//						patGender =fb.getStrHiddenValues()[z].split("\\^")[7].split("\\/")[0];
//						patAge =fb.getStrHiddenValues()[z].split("\\^")[7].split("\\/")[1];
//						hosp_code =fb.getStrHiddenValues()[z].split("\\^")[3];
//						hospName = fb.getStrHiddenValues()[z].split("\\^")[9];
//						EpisodeCode = fb.getStrHiddenValues()[z].split("\\^")[11];
//						mobNo = fb.getStrHiddenValues()[z].split("\\^")[6];
						
//						strRequisitionNo = fb.getStrHiddenValues()[z].split("\\^")[1];
//						strReqDate = fb.getStrHiddenValues()[z].split("\\^")[10];						
//						testCode = fb.getStrHiddenValues()[z].split("\\^")[4];
//						testName = fb.getStrHiddenValues()[z].split("\\^")[8];
//						vialNo = fb.getStrHiddenValues()[z].split("\\^")[0];
						
//						System.out.println("testCodeArrList::"+new Gson().toJson(testCodeArrList));
						crNo = fb.getStrHiddenValues()[z].split("\\^")[2];
							
						if(!crNo.equalsIgnoreCase(prevCrNo))						
						{
							if(z>0) // greater than first record, then call API for previous patient
							{
								//crNo, patName, gender, age, facilityId,mohallaClinicName, episodeCode,mobNo, handOverTo, handOverDateTime, handOverPersonMobile, List<InvestigationTestWiseDetailsObject> testCodeArr
								patientHandOverData = new PatientDataHandOverObject(prevCrNo, patName, patGender, patAge, hosp_code, hospName, EpisodeCode, mobNo, handOverTo, handOverDateTime, handOverPersonMobile, testCodeArrList);
								patientHandOverDataList.add(patientHandOverData);
							}
							testCodeArrList = new ArrayList<InvestigationTestWiseHandOverDetailsObject>();
						}
						
						for(int p=0; p< nVialWiseTestsPerPatient; p++)
						{
							crNo = strVialWiseTestsPerPatient[p].split("\\^")[2];
							patName =strVialWiseTestsPerPatient[p].split("\\^")[5];
							patGender =strVialWiseTestsPerPatient[p].split("\\^")[7].split("\\/")[0];
							patAge =strVialWiseTestsPerPatient[p].split("\\^")[7].split("\\/")[1];
							hosp_code =strVialWiseTestsPerPatient[p].split("\\^")[3];
							hospName = strVialWiseTestsPerPatient[p].split("\\^")[9];
							EpisodeCode = strVialWiseTestsPerPatient[p].split("\\^")[11];
							mobNo = strVialWiseTestsPerPatient[p].split("\\^")[6];
							
							strRequisitionNo = strVialWiseTestsPerPatient[p].split("\\^")[1];
							strReqDate = strVialWiseTestsPerPatient[p].split("\\^")[10];
							testCode = strVialWiseTestsPerPatient[p].split("\\^")[4];
							testName = strVialWiseTestsPerPatient[p].split("\\^")[8];
							vialNo = strVialWiseTestsPerPatient[p].split("\\^")[0];
						
							testCodeArrList.add(new InvestigationTestWiseHandOverDetailsObject(strRequisitionNo, strReqDate, testCode,testName,vialNo));
							
							dao.setProcInValue(procIndex6, "p_modval", "3", 1);
							dao.setProcInValue(procIndex6, "p_hospCode", hosp_code, 2);
							dao.setProcInValue(procIndex6, "p_hospName", "0", 3);
							dao.setProcInValue(procIndex6, "p_crNo", crNo, 4);
							dao.setProcInValue(procIndex6, "p_patient_name", "0", 5);
							dao.setProcInValue(procIndex6, "p_age", "0", 6);
							dao.setProcInValue(procIndex6, "p_mobNo", "0", 7);
							dao.setProcInValue(procIndex6, "p_gender", "0", 8);
							dao.setProcInValue(procIndex6, "p_episode_code", "0", 9);
							dao.setProcInValue(procIndex6, "p_reqDate", "0", 10);
							dao.setProcInValue(procIndex6, "p_reqNo", strRequisitionNo, 11);
							dao.setProcInValue(procIndex6, "p_visitNo", "0", 12);
							dao.setProcInValue(procIndex6, "p_testCode", testCode, 13);
							dao.setProcInValue(procIndex6, "p_testName", "0", 14);
							dao.setProcInValue(procIndex6, "p_vialNo", vialNo, 15);
							dao.setProcInValue(procIndex6, "p_handover_to", handOverTo, 16);
							dao.setProcInValue(procIndex6, "p_handover_datetime", handOverDateTime, 17); //fb.getStrDte()+" " +fb.getStrTime()
							dao.setProcInValue(procIndex6, "p_handover_person_mobile", handOverPersonMobile, 18);
							dao.setProcOutValue(procIndex6, "err", 1, 19);
							// dao.executeProcedure(procIndex1);
							dao.execute(procIndex6, 1);
						}
						
							prevCrNo = crNo;
					}
					
								//For Last Record
								//crNo, patName, gender, age, facilityId,mohallaClinicName, episodeCode,mobNo, handOverTo, handOverDateTime, handOverPersonMobile, List<InvestigationTestWiseDetailsObject> testCodeArr
								patientHandOverData = new PatientDataHandOverObject(crNo, patName, patGender, patAge, hosp_code, hospName, EpisodeCode, mobNo, handOverTo, handOverDateTime, handOverPersonMobile, testCodeArrList);
								patientHandOverDataList.add(patientHandOverData);
				}
								
				synchronized (dao) {
					dao.fire();
					if (dao != null) {
						dao.free();
						dao = null;
					}								
				}
					//Set value before Path Care Lab Webservice	Call				//By Vivek Aggarwal 12-Sep-2023
					pathCareLabHandOverObj.setPatientHandOverData(patientHandOverDataList);
//					System.out.println("Call PATHLAB API on Handover::"+pathCareLabHandOverObj.patientHandOverData.get(0).getCrNo());
			} catch (Exception e) {
				//e.printStackTrace();
				fb.setStrErrMsg("Error Occured, Please Contact System Administrator");
				fb.setStrMsgType("1");
				throw e;
			} finally {
				if (dao != null) {
					dao.free();
					dao = null;
				}
			}
			return pathCareLabHandOverObj;
		}
	
	public void callPathService(MCPathLabSampleHandoverDetailFB fb,PathCareLabsHandOverObject pathCareLabHandOverObj) throws Exception {
		
		String strIsValid = "1";//false
		HisDAO dao = null;
		
		String json = null;
		String strAPIErrorMsg="";
		String responseCode;
		try {				
			//Path Care Lab Webservice					//By Vivek Aggarwal 12-Sep-2023	
				
						json = 	new Gson().toJson(pathCareLabHandOverObj);	
 				//System.out.println("pathCareLabHandOverObj::"+json);
						  
				///WebService
				PathCareLabMCResponseObject message = null;
				String value="";
				Response response=null;
				String uri = BASE_URL;//	"add Lab Wise Details in Path Care Lab "
				OkHttpClient client = new OkHttpClient().newBuilder()
						.connectTimeout(30, TimeUnit.SECONDS)
	                    .writeTimeout(30, TimeUnit.SECONDS)
	                    .readTimeout(30, TimeUnit.SECONDS)
						.build();
				MediaType mediaType = MediaType.parse("application/json");																				
				RequestBody body = RequestBody.create(mediaType, json);
				Request request1 = new Request.Builder()
				  .url(uri)
				  .method("POST", body)
				  .addHeader("Content-Type", "application/json")
				  .addHeader("Cookie", "ASP.NET_SessionId=r1bwnuigyrjl1e55x0u1di55")
				  .build();
 				///System.out.println("Call PATHLAB API on Handover::"+pathCareLabHandOverObj.patientHandOverData.get(0).getCrNo());						
				response = client.newCall(request1).execute();
				value = response.body().string();	
				responseCode = String.valueOf(response.code());
				
				//System.out.println("responseCode >> "+responseCode+"  ,   response value >> "+value);
				 
				message = new Gson().fromJson(value, PathCareLabMCResponseObject.class);
				
				
				response.close();
//				System.out.println("Call PATHLAB API on Handover::Response Close::"+pathCareLabHandOverObj.patientHandOverData.get(0).getCrNo());
				
				if (message == null	|| (message != null && !message.getSuccess().equalsIgnoreCase("true")) )
				{	

					if(message==null) 
					{
//							 vo.setStrMsgType("1"); 
//							 vo.setStrMsgString("WebService Failed!!!");													
						strAPIErrorMsg = "WebService Failed(Not Connecting to PathLab URL)!!!";
					}
					else {
						strAPIErrorMsg	= message.getMsg();
					}
					
					strAPIErrorMsg	= strAPIErrorMsg + ", responseCode::"+responseCode;
					throw new Exception("Error Occured :: Msg ::" + strAPIErrorMsg);
				}	
				else
				{
					strIsValid = "0";//true
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				fb.setStrNormalMsg("Data Saved Successfully but Not Sent to Path Care Lab as Web API failed!!!");
			}
			finally {
					try {
						 String strQuery = "";
						 dao = new HisDAO("MMS Transactions", "OfflineIssueIndentTransDAO");
//						 System.out.println("Entry in table hivt_punjab_pending_api_list::strAPIErrorMsg::"+strAPIErrorMsg+"::CRNo::"+pathCareLabHandOverObj.patientHandOverData.get(0).getCrNo());
						 strQuery = "insert into hivt_punjab_pending_api_list(hstnum_pk,hrgnum_cr_no,json_string,gdt_entry_date,gnum_isvalid,hrgnum_web_service_type,hrgstr_error_msg) "
									+ "values(coalesce((select max(hstnum_pk)+1 from hivt_punjab_pending_api_list),1),?,?,sysdate(),"+strIsValid+",2,?)";
							int nqryIndex = dao.setQuery(strQuery);
							dao.setQryValue(nqryIndex, 1, pathCareLabHandOverObj.patientHandOverData.get(0).getCrNo());
							dao.setQryValue(nqryIndex, 2, json);
							dao.setQryValue(nqryIndex, 3, strAPIErrorMsg);
							
							dao.execute(nqryIndex,0);
							dao.fire(); 
					 }
					 catch (Exception e) {
						e.printStackTrace();
						throw e;
					}	
					finally {
						if (dao != null) {
							dao.free();
							dao = null;
						}
					}
					pathCareLabHandOverObj=null;
			}
	}

	public static void getPatientsDtl(MCPathLabSampleHandoverDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_inv_view.proc_get_aac_path_lab_details(?,?,?,?,?,	?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "MCPathLabSampleHandoverDetailMcNewDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "3", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", fbObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "p_crno", "0", 3);
			daoObj.setProcInValue(nProcIndex, "p_reqno", "0", 4);
			daoObj.setProcInValue(nProcIndex, "p_reqdate", fbObj.getStrPresDate()==null||fbObj.getStrPresDate().trim().equals("")?"0":fbObj.getStrPresDate(), 5);
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
			fbObj.setStrMsgString("MCPathLabSampleHandoverDetailMcNewDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	
	public static void getPatientsDtlForWebservicesSent(MCPathLabSampleHandoverDetailFB fbObj) {

		HisDAO daoObj = null;
		WebRowSet ws = null;
		String strProcName = "{call pkg_inv_view.proc_get_aac_path_lab_details(?,?,?,?,?,	?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try {
			daoObj = new HisDAO("MC", "MCPathLabSampleHandoverDetailMcNewDAO");
			nProcIndex = daoObj.setProcedure(strProcName);

			daoObj.setProcInValue(nProcIndex, "p_modval", "5", 1);
			daoObj.setProcInValue(nProcIndex, "p_hospcode", fbObj.getStrHospitalCode(), 2);
			daoObj.setProcInValue(nProcIndex, "p_crno", "0", 3);
			daoObj.setProcInValue(nProcIndex, "p_reqno", fbObj.getStrDeskCombo(), 4);
			daoObj.setProcInValue(nProcIndex, "p_reqdate", fbObj.getStrPresDate()==null||fbObj.getStrPresDate().trim().equals("")?"0":fbObj.getStrPresDate(), 5);
			daoObj.setProcInValue(nProcIndex, "p_visitno", fbObj.getStrAPIStatus(), 6);
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
			fbObj.setStrMsgString("MCPathLabSampleHandoverDetailMcNewDAO.getPatientsDtl() --> " + e.getMessage());
			fbObj.setStrMsgType("1");

		} finally {
			if (daoObj != null) {
				daoObj.free();
				daoObj = null;
			}
		}
	}
	
	
	public static String resendFailedWebservices(MCPathLabSampleHandoverDetailFB fb) throws Exception {

		String BASE_URL1 = "http://pclacc.pathcarelabs.com/PathcareAAP/CronJob/API/AAmaadmiBooking.aspx"; // Dr Desk
		String BASE_URL2 = "http://pclacc.pathcarelabs.com/PathcareAAP/CronJob/API/AAmaadmiapi.aspx"; // HandOver Details
		
		HisDAO dao = null;

		String uri ="";
		//System.out.println("INSIDE SAVE DAO");
		
		String crNo ="0", pkKey="0";
		String json = null;
		String json2 = null;
			try {
				dao = new HisDAO("", "");
//				String proc_name6="{call pkg_inv_dml.Dml_mc_pathlab_dtl(?,?,?,?,? ,?,?,?,?,?, ?,?,?,?,?, ?,?,?, ?)}"; //18 values --By Vivek Aggarwal as on 04-Sep-2023
//				int procIndex6 =0;
//				procIndex6 = dao.setProcedure(proc_name6);
				//vialNo,reqNo,crNo,hospcode,testCode,  pat_name,mobile_no,gender_code||''/''||age,test_name,hosp_name,reqDate
				if (fb.getStrHiddenValues() != null && fb.getStrHiddenValues().length>0)
				{		
					for (int z = 0; z < fb.getStrHiddenValues().length; z++) {
						// Call WebService	
							crNo = "0";
//							hosp_code ="0";
									String strIsValid = "1";//false
									try {				
										//Path Care Lab Webservice					//By Vivek Aggarwal 12-Sep-2023	
											
													json = 	fb.getStrHiddenValues()[z];
												json2 = fb.getStrCheckALL()[z];
												crNo =  fb.getStrCheckALL()[z].split("\\^")[0];
												pkKey =  fb.getStrCheckALL()[z].split("\\^")[1];
										//	System.out.println("json::"+json);
										//	System.out.println("2VALUEs"+fb.getStrHidden_JSON());
										//	System.out.println("PK + CR >>"+json2);
										//	System.out.println("fb.getStrComboDrDesk()::"+fb.getStrDeskCombo());		  
											
											///WebService
											PathCareLabMCResponseObject message = null;
											String responseCode="";
											String value="";
											Response response=null;
											
											if(fb.getStrDeskCombo().equals("1")) {
												 uri = BASE_URL1 ;
											}
											else {
												 uri= BASE_URL2;
											}
											
										//	System.out.println("uri::"+uri);
										//	System.out.println("fb.getStrDeskCombo()::"+fb.getStrDeskCombo());
										//	System.out.println("crNo::"+crNo);
										//	System.out.println("pkKey::"+pkKey);
										//	
											
											
											OkHttpClient client = new OkHttpClient().newBuilder().build();
											MediaType mediaType = MediaType.parse("application/json");																				
											RequestBody body = RequestBody.create(mediaType, json);
											Request request1 = new Request.Builder()
											  .url(uri)
											  .method("POST", body)
											  .addHeader("Content-Type", "application/json")
											  .addHeader("Cookie", "ASP.NET_SessionId=r1bwnuigyrjl1e55x0u1di55")
											  .build();
										//	System.out.println("Call PATHLAB API on Handover::Response Start::"+crNo);
											response = client.newCall(request1).execute();
											value = response.body().string();		
											message = new Gson().fromJson(value, PathCareLabMCResponseObject.class);
											responseCode = String.valueOf(response.code());
											
											response.close();
										//	System.out.println("Call PATHLAB API on Handover::Response Close::"+crNo);
											
											if (message == null	|| (message != null && !message.getSuccess().equalsIgnoreCase("true")) )
											{	
											//	System.out.println("First if::message::"+message);
												if(message==null) 
												{
					//							 vo.setStrMsgType("1"); 
					//							 vo.setStrMsgString("WebService Failed!!!");
												//	System.out.println("Second if::message::"+message);
													message.setMsg("WebService Failed!!! Not Connecting!!!");
												}
												else
												{
													//System.out.println("message.getSuccess()::"+message.getSuccess());
													//System.out.println("message.getMsg()::"+message.getMsg());
												}
												
												throw new Exception("Error Occured :: Msg ::WebService Failed!!!" + message.getMsg());
											}	
											else
											{
												try {
													 String strQuery = "";
													 dao = new HisDAO("MMS Transactions", "OfflineIssueIndentTransDAO");
													 strQuery = "update hivt_punjab_pending_api_list set gnum_isvalid = 0 where gnum_isvalid = 1 and hrgnum_web_service_type = ? and hrgnum_cr_no = ? and hstnum_pk = ?";
													 int nqryIndex = dao.setQuery(strQuery);
														dao.setQryValue(nqryIndex, 1, fb.getStrDeskCombo());
														dao.setQryValue(nqryIndex, 2, crNo);
														dao.setQryValue(nqryIndex, 3, pkKey);
														dao.execute(nqryIndex,0);
														dao.fire(); 
												 }
												 catch (Exception e) {
													e.printStackTrace();
							//						vo.setStrMsgType("1");
												}
												 finally 
												{
													if (dao != null) 
													{
														dao.free();
														dao = null;
													}
												}
											}
											
										} catch (Exception e) {
											e.printStackTrace();
										}
					
					}	
								
				}
				
				//System.out.println("INSIDE DAO saveForWebServicesSent");
				
				
//				"{ "patientHandOverData": [ { "crNo": "860012300054591", "patName": "Test Three", "gender": "M", "age": "22 Yr", "facilityId": "3786001",
//				"mohallaClinicName": "AAP Clinic Mohali", "episodeCode": "14711001", "mobNo": "8989889898", "reqNo": "8600110076230911100002", "handOverTo":"ajaabb", 
//				"handOverDateTime":"09/11/2023 18:55:00", "handOverPersonMobile" : "6547457454", "reqDate": "09/11/2023 10:53:19", 
//				"testCode_arr": [        {                "testCode": "10820",        "vialNo": "tt2",        "testName": "Platelet Count () "        }     ]    }  ]}"

			} catch (Exception e) {
				//e.printStackTrace();

				throw e;

			} finally {

				if (dao != null) {

					dao.free();
					dao = null;

				}

			}
			return "DATA INSERTED SUCCESSFULLY";
		}
	
	
}
