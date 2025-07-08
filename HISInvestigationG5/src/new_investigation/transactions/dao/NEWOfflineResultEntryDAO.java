package new_investigation.transactions.dao;

/**
 * @author : C-DAC, Noida
 * Module  : HISInvestigationG5
 */


import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.hisconfig.Config;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.persistence.JDBCTransactionContext;
import hisglobal.persistence.Procedure;
import hisglobal.presentation.WebUTIL;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.Sequence;
import hisglobal.vo.UserVO;
import hisglobal.vo.ValueObject;
import javax.sql.rowset.WebRowSet;

import org.codehaus.jettison.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import new_investigation.InvestigationConfig;
import new_investigation.vo.NEWOfflineResultEntryVO;
import new_investigation.vo.LabTestVO;
import new_investigation.vo.SampleCollectionCumAcceptanceVO;


public class NEWOfflineResultEntryDAO extends DataAccessObject //implements InvestigationEssentialDAOi
{
	public NEWOfflineResultEntryDAO(JDBCTransactionContext _tx)
	{
		super(_tx);
	}
	
	
	
		
	/*  ## 		Modification Log							
 		##		Modify Date				:19thFeb'15 
 		##		Reason	(CR/PRS)		:Sample Collection Process :: get 
 		##		Modify By				:Sheeldarshi */
		public  List<NEWOfflineResultEntryVO> getSampleCollectionArea(UserVO _UserVO)
		{
			String query = "";		
			Map populateMAP = new HashMap();
			ResultSet rs = null;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.SAMPLE_COLLECTION_AREA.HIVT_COLLECTION_AREA_MST";
			Sequence sq = new Sequence();

			List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
			populateMAP.put(sq.next(),  _UserVO.getHospitalCode());
			populateMAP.put(sq.next(), InvestigationConfig.MODULE_ID_INVESTIGATION);
		//	populateMAP.put(sq.next(), _UserVO.getUserSeatId());
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			populateMAP.put(sq.next(), _UserVO.getUserSeatId());
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
						populateMAP);
				rs.beforeFirst();
				
				 if (!rs.next())
		            {
		                throw new HisRecordNotFoundException("No Sample Collection Area Found");
		            }
		            else
		            {
		                rs.beforeFirst();
		                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
		                NEWOfflineResultEntryVO InvSampleCollectionVO=null;
		                while (rs.next()) {
		                	InvSampleCollectionVO=new NEWOfflineResultEntryVO();
		                    HelperMethods.populateVOfrmRS(InvSampleCollectionVO, rs);
		                    lstInvSampleCollectionVO.add(InvSampleCollectionVO);
               }
		            }
			}
			catch (HisRecordNotFoundException e)
			{

				throw new HisRecordNotFoundException(e.getMessage());
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("" + e);
			}
			return lstInvSampleCollectionVO;

		}
		public  List<NEWOfflineResultEntryVO> getPatList(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO _UserVO)
		{
			String query = "";		
			Map populateMAP = new HashMap();
			ResultSet rs = null;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.SAMPLE_PATIENT_LIST.HIVT_REQUISITION_HEADER";
			String queryKeyIPDWARD = "SELECT.SAMPLE_PATIENT_LIST.HIVT_REQUISITION_HEADER_IPD_WARD";
			Sequence sq = new Sequence();
			
			String iswardforccolection="";
			String wardcode="0";
			String wardtype="";
			
			if(objSampleCollectionVO.getWardCode()==null)
			{
			 iswardforccolection=iswardforcollectionarea(objSampleCollectionVO.getSampleAreaCode(),_UserVO.getHospitalCode());
			
			 if(iswardforccolection!=null && !iswardforccolection.equals(""))
			{
		    
		     wardtype=iswardforccolection.split("#")[0];
			
			if(wardtype.equals("2"))
			{
				wardcode=iswardforccolection.split("#")[1];
				
			}
			
		   }
			
			}
			Date dateInstance = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateInstance);
			cal.add(Calendar.DATE, -1);
			Date date = cal.getTime();
			String dateBefore7Days = WebUTIL.getCustomisedSysDate(date, "dd-MMM-yyyy");
			//System.out.println("dateBefore7Days : "+dateBefore7Days);
			String condition1=" and HRGNUM_PUK= "+"'"+objSampleCollectionVO.getPatCRNo()+"'";
			//String condition1=" and HRGNUM_PUK= "+objSampleCollectionVO.getPatCRNo();
			//String condition2=" AND (TRUNC(hivdt_entry_date) >= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))  AND (TRUNC(hivdt_entry_date) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))";
			String condition2=" AND (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(\'"+dateBefore7Days+"\','DD-Mon-YYYY')))  AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))";
				String condition3="and  (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getFromDate()+"\','DD-Mon-YYYY'))) AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getToDate()+"\','DD-Mon-YYYY')))";
				String condition4="and  EXISTS ( SELECT 1 FROM HIVT_COLLECTION_AREA_MST z WHERE z.gnum_area_code ="+objSampleCollectionVO.getSampleAreaCode()+"  and z.hipnum_ward_code=A.hipnum_wardcode and z.gnum_hospital_code=a.gnum_hospital_code and gnum_isvalid=1)";
	        //String orderBy=" order by gnum_test_code,hgnum_group_code,hivdt_entry_date desc";
         	String orderBy=" order by hivdt_entry_date desc";
				List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
			//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			//populateMAP.put(sq.next(),_UserVO.getSeatId());
			//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			//put(sq.next(), objSampleCollectionVO.getFromDate());
			//populateMAP.put(sq.next(), objSampleCollectionVO.getToDate());
			if(objSampleCollectionVO.getWardCode()==null)
			{
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			
			populateMAP.put(sq.next(), objSampleCollectionVO.getSampleAreaCode());
			}
			populateMAP.put(sq.next(), InvestigationConfig.MODULE_ID_INVESTIGATION);
			populateMAP.put(sq.next(), _UserVO.getUserSeatId());
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
			/*populateMAP.put(sq.next(), InvestigationConfig.REQUISTION_DTL_UPDATE_RESCHEDULED_STATUS);*/
			try
			{
				
				if(objSampleCollectionVO.getWardCode()==null )
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				else
					query = HelperMethodsDAO.getQuery(filename, queryKeyIPDWARD);		
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				if(objSampleCollectionVO.getPatCRNo()!=null&&!objSampleCollectionVO.getPatCRNo().equals(""))
				{
					/*PRASHANT SMC deisabled in case of cr no. input given from to date is not need*/
					//if(objSampleCollectionVO.getFromDate()!=null)
					//query+=condition3;
					
					query+=condition1;
				}
				else if(objSampleCollectionVO.getFromDate()!=null&&!objSampleCollectionVO.getFromDate().equals("")&&objSampleCollectionVO.getToDate()!=null&&!objSampleCollectionVO.getToDate().equals(""))
				{
					query+=condition3;
				}
				else
				{
					 query+=condition2;
				}
				
				if(wardtype.equals("2") )
				{
					
					query+=condition4;
				}
				
				if(objSampleCollectionVO.getWardCode()!=null)
				{
					
					query+=" and a.HIPNUM_WARDCODE="+objSampleCollectionVO.getWardCode()+" ";

				}
				/*
				if(objSampleCollectionVO.getWardCode()!=null && !objSampleCollectionVO.getWardCode().equals(""))
				{
					
					query+=condition4;
				}*/
				query+=orderBy;
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
						populateMAP);
				rs.beforeFirst();
				
				 if (!rs.next())
		            {
		                throw new HisRecordNotFoundException("No Patient List  Found");
		            }
		            else
		            {
		                rs.beforeFirst();
		                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
		                NEWOfflineResultEntryVO InvSampleCollectionVO=null;
		                while (rs.next()) {
		                	InvSampleCollectionVO=new NEWOfflineResultEntryVO();
		                    HelperMethods.populateVOfrmRS(InvSampleCollectionVO, rs);
		                    //added by krishnan nema on 26-02-2019
		                    int billStatus = 0; //1 for not billed, 2 for partially billed, 3 for fully billed
		                    if(InvSampleCollectionVO.getIsBilled()!=null && InvSampleCollectionVO.getIsBilled().contains("##")){
		                    	int billedTestCount = 0;
	                    		int unbilledTestCount = 0;
		                    	String billArray[] = InvSampleCollectionVO.getIsBilled().split("##");
		                    	for(int p = 0; p<billArray.length; p++){
		                    		String billNo = billArray[p].replace("^", "#").split("#")[0];
		                    		if(billNo!=null && !billNo.equals("0")){
		                    			billedTestCount++;
		                    		}else{
		                    			unbilledTestCount++;
		                    		}
		                    	}
		                    	
		                    	if(billedTestCount == billArray.length){
		                    		billStatus = 3;
		                    	}
		                    	if(billedTestCount > 0 && billedTestCount < billArray.length){
		                    		billStatus = 2;
		                    	}
		                    	if(unbilledTestCount == billArray.length){
		                    		billStatus = 1;
		                    	}
		                    }else{
		                    	if(InvSampleCollectionVO.getIsBilled()!=null)
		                    	{
		                    	String billNo = InvSampleCollectionVO.getIsBilled().replace("^", "#").split("#")[0];
		                    	if(billNo!=null && !billNo.equals("0")){
		                    		billStatus = 3;
		                    	}else{
		                    		billStatus = 1;
		                    	}
		                    }
		                    }
		                    	
		                    if(billStatus == 1){
		                    	InvSampleCollectionVO.setBillDtl("Not Billed");
		                    }else if(billStatus == 2){
		                    	InvSampleCollectionVO.setBillDtl("Patially Billed");
		                    }else if(billStatus == 3){
		                    	InvSampleCollectionVO.setBillDtl("Billed");
		                    }
		                    
		                    
		                    lstInvSampleCollectionVO.add(InvSampleCollectionVO);
		                }
		            }
			}
			catch (HisRecordNotFoundException e)
			{

				//throw new HisRecordNotFoundException(e.getMessage());
			}
			catch (Exception e)
			{
				e.printStackTrace();
				throw new HisDataAccessException("" + e);
			}
			return lstInvSampleCollectionVO;

		}
		//End:Sheeldarshi
		
		
		public static String getFTPDtl() {
			
			String strProcName = "{? = call pkg_inv_fun.fun_get_config_dtl(?,?)}";
			int nProcIndex = 0;
			String val = "";

			HisDAO daoObj = null;
			
			try 
			{
				daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setFunction(strProcName);
				
				daoObj.setFuncInValue(nProcIndex, 2, "FTP");
				daoObj.setFuncInValue(nProcIndex, 3, "0");
				daoObj.setFuncOutValue(nProcIndex, 1);

				daoObj.executeFunction(nProcIndex);
				val = daoObj.getFuncString(nProcIndex);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
			return val;
		}

		
		public static String getFTPDtlSignFile() {
			
			String strProcName = "{? = call pkg_inv_fun.fun_get_config_dtl(?,?)}";
			int nProcIndex = 0;
			String val = "";
			HisDAO daoObj = null;
			
			try 
			{
				daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setFunction(strProcName);
				
				daoObj.setFuncInValue(nProcIndex, 2, "FTPUserSign");
				daoObj.setFuncInValue(nProcIndex, 3, "0");
				daoObj.setFuncOutValue(nProcIndex, 1);

				daoObj.executeFunction(nProcIndex);
				val = daoObj.getFuncString(nProcIndex);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
			return val;
		}

		
		
		
		public void getOfflineTestDetail(NEWOfflineResultEntryVO vo,UserVO _UserVO,String mode) {
		
			WebRowSet webRs = null;
			HisDAO daoObj = null;
			String strProcName = "{call pkg_inv_view.proc_offline_result_entry_new(?,?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String strErr = "";
			try 
			{
				daoObj = new HisDAO("Registration","EssentialDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "p_mode", mode,1);
				daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
				System.out.println("p_crno"+vo.getPatCRNo());
				daoObj.setProcInValue(nProcIndex, "p_hosp_code", _UserVO.getHospitalCode(),3);
				daoObj.setProcInValue(nProcIndex, "p_module_id", InvestigationConfig.MODULE_ID_INVESTIGATION,4);
			    daoObj.setProcInValue(nProcIndex, "p_seat_id", _UserVO.getUserSeatId(),5);
				daoObj.setProcOutValue(nProcIndex, "err", 1,6);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
				
			
				daoObj.executeProcedureByPosition(nProcIndex);

				strErr = daoObj.getString(nProcIndex, "err");

				if (strErr == null)
					strErr = "";

				webRs = daoObj.getWebRowSet(nProcIndex, "resultset");
				if (strErr.equals("")) {
					vo.setOfflineTestWS(webRs);

				} else {
					throw new Exception(strErr);
				}
			} 
			catch (Exception e) 
			{
				if (e.getClass() == HisRecordNotFoundException.class) 
				{
					throw new HisRecordNotFoundException(e.getMessage());
				} 
				else
					throw new HisDataAccessException("GlobalDAO:getHospitalDetail:HelperMethods :: " + e);
			} 
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}		
			
		}
		
		
		/*public void onlineReqResultEntry(String  onlineReqJson, UserVO userVO)  {
			
			
			HisDAO daoObj = null;
			String strProcName = "{call pkg_inv_dml.proc_update_hivt_requisition_dtl(?,?,?,?,?,?)}";
			int nProcIndex = 0;
			String strErr = "";
			try 
			{
				 System.out.println("nandini13");
				daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
				daoObj.setProcInValue(nProcIndex, "hospitalCode", vo.getHospitalCode(),2);
				daoObj.setProcInValue(nProcIndex, "reqNo", vo.getRequisitionNo(),3);
			    daoObj.setProcInValue(nProcIndex, "labcode", vo.getLabCode(),4);
			    daoObj.setProcInValue(nProcIndex, "testcode", vo.getTestCode(),5);
			    daoObj.setProcInValue(nProcIndex, "req_dtl_status", InvestigationConfig.REQ_DTL_STATUS,6);
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);

				//strErr = daoObj.getString(nProcIndex, "err");

			}
				catch (Exception e)
				{
					 e.printStackTrace();
					 vo.setStrMsgString("NEWOfflineResultEntryDAO.onlineReqResultEntry() --> "+ e.getMessage());
					 vo.setStrMsgType("1");
				}
				finally {
					if (daoObj != null) {
						daoObj.free();
						daoObj = null;
					}
				}
			}
			*/
		
		
			public void onlineReqResultEntry(String  onlineReqJson, UserVO userVO)  {
			
			
			HisDAO daoObj = null;
			String query ="UPDATE HIVT_REQUISITION_DTL SET HIVNUM_REQDTL_STATUS=26, hivtdt_dept_res_print_date= now() "
					       + " where  hrgnum_puk_reqd =? "
					       + " and HIVNUM_REQ_NO=? and gnum_test_code=? and gnum_lab_code=?";
			int qryIndex = 0;
			String strErr = "";
			try 
			{
				JSONArray arr= new JSONArray(onlineReqJson);
				System.out.println(">>onlineReqJson>>"+onlineReqJson);
				daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
				
				
				for(int j=0;j<arr.length();j++) {
					int i=1;
					qryIndex = daoObj.setQuery(query);
					
					JSONObject obj= arr.getJSONObject(j);
					//daoObj.setQryValue(qryIndex, i++, userVO.getSeatId());
					//System.out.println(">>getUserSeatId>>"+userVO.getSeatId());
				///	daoObj.setQryValue(qryIndex, i++, userVO.getHospitalCode());
					//System.out.println(">>getHospitalCode34>>"+userVO.getHospitalCode());
				//	System.out.println(">>obj.getString(\"patCRNo45\")>>"+obj.getString("patCRNo"));
					daoObj.setQryValue(qryIndex, i++, obj.getString("patCRNo"));
					System.out.println(">>CRNO>>"+obj.getString("patCRNo"));
					///System.out.print("qryIndex"+qryIndex);
					daoObj.setQryValue(qryIndex, i++, obj.getString("hivnum_req_no"));
					daoObj.setQryValue(qryIndex, i++, obj.getString("gnum_test_code"));
					daoObj.setQryValue(qryIndex, i++, obj.getString("gnum_lab_code"));
				
					
					daoObj.execute(qryIndex, 0);
					
					System.out.print("qryIndex nandini"+qryIndex);
				}
				
				
				daoObj.fire();
				
			}
				catch (Exception e)
				{
					 e.printStackTrace();
					
				}
				finally {
					if (daoObj != null) {
						daoObj.free();
						daoObj = null;
					}
				}
			}
			
			
		
		public void getHospitalList(NEWOfflineResultEntryVO invresultentryvo) {

			HisDAO daoObj = null;
			WebRowSet ws, rs = null;
			NEWOfflineResultEntryVO voSampleCollection=null;

			List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
			String strProcName = "{call pkg_inv_view.proc_offline_result_entry(?,?,?,?,?,?)}";
			int nProcIndex = 0;

			String strErr = "";

			daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO.getHospitalList()");
			try
			{
				daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "p_mode", "3",1);
				daoObj.setProcInValue(nProcIndex, "p_hosp_code", invresultentryvo.getStrParentHospitalCode(),2);
				daoObj.setProcInValue(nProcIndex, "p_module_id", "",3);
				daoObj.setProcInValue(nProcIndex, "p_seat_id", "",4);
				daoObj.setProcOutValue(nProcIndex, "err", 1,5);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				//ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				rs = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
				{
					 if (!rs.next())
			            {
			                throw new HisRecordNotFoundException("No Patient List  Found");
			            }
			            else
			            {
			                rs.beforeFirst();
			                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
			                while (rs.next()) {
			                	voSampleCollection=new NEWOfflineResultEntryVO();
			                	HelperMethods.populateVOfrmRS(voSampleCollection, rs);
			                	 lstInvSampleCollectionVO.add(voSampleCollection);
			                }
			            }
					 //invresultentryvo.setStrHospitalListWS(ws);
				}
					
				else 
					throw new Exception(strErr);
			} catch (Exception e) {
				invresultentryvo.setStrMsgString("NEWOfflineResultEntryDAO.getHospitalList() --> "+ e.getMessage());
				invresultentryvo.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}

		
		public static String getUserSignFileName(NEWOfflineResultEntryVO vo) {
			
			String strProcName = "{? = call pkg_inv_fun.fun_get_user_sign_file(?,?)}";
			int nProcIndex = 0;
			String val = "";

			HisDAO daoObj = null;
			
			try 
			{
				daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setFunction(strProcName);
				
				daoObj.setFuncInValue(nProcIndex, 2, vo.getStrParentHospitalCode());
				daoObj.setFuncInValue(nProcIndex, 3, vo.getSeatId());
				daoObj.setFuncOutValue(nProcIndex, 1);

				daoObj.executeFunction(nProcIndex);
				val = daoObj.getFuncString(nProcIndex);
				vo.setStrUserSignFileName(val);
				
			}catch(Exception e) {
				
				e.printStackTrace();
			}
			finally 
			{
				if (daoObj != null) 
				{
					daoObj.free();
					daoObj = null;
				}
			}
			return val;
		}
		
		public void insertOffllineResultEntry(NEWOfflineResultEntryVO vo) {
			
			HisDAO daoObj = null;
			String strProcName = "";
			int nProcIndex = 0;
			
			String strCrNo=new String();
			int funcIndex=0;
			
			try {
					//Generate CR Number.
				    System.out.println("nandini13");
					daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
					funcIndex = daoObj.setFunction("{? = call lab.pkg_inv_fun.fun_gen_result_seq_no(?)}");
					
					daoObj.setFuncInValue(funcIndex, 2, vo.getStrPatHospCode());
					daoObj.setFuncOutValue(funcIndex,1);
					 
					daoObj.executeFuncForNumeric(funcIndex);
					strCrNo = daoObj.getFuncNumeric(funcIndex);
					  
					 //vo.setSamplecoldate("7-Sept-2022");
					// vo.setResultDate("7-Sept-2022");
					//vo.setPatCRNo(strCrNo);
					
					String strDate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
					String strFileName = vo.getPatCRNo()+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())+ ".pdf";
					vo.setStrPatFileName(strFileName);
					System.out.println("strFileName"+strFileName);
					vo.setSamplecoldate(strDate);
					vo.setResultDate(strDate);
					//Save Patient's Details
					System.out.println("nandini14");
					//daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
					strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
					daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the request is sent.
					daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
					System.out.println("getPatCRNo::\t"+vo.getPatCRNo());
					daoObj.setProcInValue(nProcIndex, "patageunit", vo.getStrPatAgeUnit(),4); 
					daoObj.setProcInValue(nProcIndex, "patname", vo.getPatName(),5);
					daoObj.setProcInValue(nProcIndex, "patgendercode", vo.getPatGenderCode().toUpperCase().substring(0,1),6);
					daoObj.setProcInValue(nProcIndex, "patage", vo.getPatAge(),7);
					System.out.println("getPatAge::\t"+vo.getPatAge());
					daoObj.setProcInValue(nProcIndex, "pataddress", vo.getPatAddress(),8);
					daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
					System.out.println("vo.getPatMobileNo()::\t"+vo.getPatMobileNo());
					daoObj.setProcInValue(nProcIndex, "patguardianname", vo.getPatGuardianName(),10);
					daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),11);
					System.out.println("vo.requisitiondate()::\t"+vo.getSamplecoldate());
					daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),12);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),13);
					daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),14);
					daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),15);
					//patEpisodeCode", vo2.getPatEpisodeCode  patvisitno
			
			       // daoObj.setProcInValue(nProcIndex, "episodeCode", vo.getPatEpisodeCode(),16);
			         System.out.println("episodecode>>"+vo.getPatEpisodeCode());
			 
			          //daoObj.setProcInValue(nProcIndex, "visitNo", vo.getPatVisitNo(),17);
			            
			              System.out.println("visitno12>>>"+vo.getPatvisitno());
			
					daoObj.setProcOutValue(nProcIndex, "err",1,16);
					
					daoObj.execute(nProcIndex , 1);
					System.out.println("23");
					//Save Tests' Details
					//if(vo.getStrHiddenValue()!=null) {
					 for (int i=0; i<vo.getStrHiddenValue().length;i++)
					{
						if(!vo.getStrHiddenValue()[i].equals("0"))
						{
						    String codes[] = vo.getStrHiddenValue()[i].replace("^", "#").split("#");

						    String labCode = codes[0];
						    String testCode = codes[1];
						    String parameterCode = codes[2];
						    
							strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_result_dtl_new(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,? )}"; 
							nProcIndex = daoObj.setProcedure(strProcName);
							daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
							daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the req is sent.
							daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
							daoObj.setProcInValue(nProcIndex, "labcode", labCode,4);
							System.out.println("labCode"+labCode);
							daoObj.setProcInValue(nProcIndex, "testcode", testCode,5);
							System.out.println("testCode"+testCode);
							daoObj.setProcInValue(nProcIndex, "parametercode", parameterCode,6);
							System.out.println("parameterCode"+parameterCode);
							daoObj.setProcInValue(nProcIndex, "testcodeval", vo.getStrTestResult()[i],7); 
							System.out.println("vo.getStrTestResult()::\t"+vo.getStrTestResult());
							daoObj.setProcInValue(nProcIndex, "refrange", vo.getStrRefRangeVal()[i],8);
							System.out.println("vo.getStrRefRangeVal()::\t"+vo.getStrRefRangeVal());
							daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
							daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),10);
							daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),11);
							daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),12);
							daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),13);
							daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),14);
					
					       //daoObj.setProcInValue(nProcIndex, "episodeCode", vo.getPatEpisodeCode(),15);
					        System.out.println("vo.getPatEpisodeCode>>>"+vo.getPatEpisodeCode());
					 
					       // daoObj.setProcInValue(nProcIndex, "visitNo", vo.getPatVisitNo(),16);
					
					         System.out.println("VisitNo>>>"+vo.getPatVisitNo());
					
							daoObj.setProcOutValue(nProcIndex, "err",1,15);
							daoObj.setProcOutValue(nProcIndex, "req_no",1,16);
							
							
							daoObj.execute(nProcIndex , 1);
						}
					}
					 	
					 synchronized (daoObj) 
						{
						 daoObj.fire();
						}
					 
					 
					 String req_no = daoObj.getString(nProcIndex, "req_no");
					 
					 System.out.println("new request no is >> "+req_no);
					 
					 
					 vo.setRequisitionNo(req_no);
					 
					 
					 
					 
				}
			//}
			catch (Exception e)
			{
				 e.printStackTrace();
				 vo.setStrMsgString("NEWOfflineResultEntryDAO.insertOffllineResultEntry() --> "+ e.getMessage());
				 vo.setStrMsgType("1");
			}
			finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}
		
	/*	
		
		public void insertOffllineResultEntry(NEWOfflineResultEntryVO vo) {
			
			HisDAO daoObj = null;
			String strProcName = "";
			int nProcIndex = 0;
			int nProcIndex1 =0 ;
			String strCrNo=new String();
			int funcIndex=0;
			
			try {
					//Generate CR Number.
				System.out.println("nandini13");
					daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
					funcIndex = daoObj.setFunction("{? = call pkg_inv_fun.fun_gen_result_seq_no(?)}");
					
					daoObj.setFuncInValue(funcIndex, 2, vo.getStrPatHospCode());
					daoObj.setFuncOutValue(funcIndex,1);
					 
					daoObj.executeFuncForNumeric(funcIndex);
					strCrNo = daoObj.getFuncNumeric(funcIndex);
					 ResultSet rs = null;
					 //vo.setSamplecoldate("7-Sept-2022");
					// vo.setResultDate("7-Sept-2022");
					//vo.setPatCRNo(strCrNo);
					
					String strDate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
					String strFileName = vo.getPatCRNo()+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())+ ".pdf";
					vo.setStrPatFileName(strFileName);
					System.out.println("strFileName"+strFileName);
					vo.setSamplecoldate(strDate);
					vo.setResultDate(strDate);
					//Save Patient's Details
					System.out.println("nandini14");
					//daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
					strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
					daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the request is sent.
					daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
					System.out.println("getPatCRNo::\t"+vo.getPatCRNo());
					daoObj.setProcInValue(nProcIndex, "patageunit", vo.getStrPatAgeUnit(),4); 
					daoObj.setProcInValue(nProcIndex, "patname", vo.getPatName(),5);
					daoObj.setProcInValue(nProcIndex, "patgendercode", vo.getPatGenderCode().toUpperCase().substring(0,1),6);
					daoObj.setProcInValue(nProcIndex, "patage", vo.getPatAge(),7);
					System.out.println("getPatAge::\t"+vo.getPatAge());
					daoObj.setProcInValue(nProcIndex, "pataddress", vo.getPatAddress(),8);
					daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
					System.out.println("vo.getPatMobileNo()::\t"+vo.getPatMobileNo());
					daoObj.setProcInValue(nProcIndex, "patguardianname", vo.getPatGuardianName(),10);
					daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),11);
					System.out.println("vo.requisitiondate()::\t"+vo.getSamplecoldate());
					daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),12);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),13);
					daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),14);
					daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),15);
					daoObj.setProcOutValue(nProcIndex, "err",1,16);
					
					daoObj.execute(nProcIndex , 1);
					System.out.println("23");
					//Save Tests' Details
					//if(vo.getStrHiddenValue()!=null) {
					
					
					 for (int i=0; i<vo.getStrHiddenValue().length;i++)
					{
						if(!vo.getStrHiddenValue()[i].equals("0"))
						{
						    String codes[] = vo.getStrHiddenValue()[i].replace("^", "#").split("#");

						    String labCode = codes[0];
						    String testCode = codes[1];
						    String parameterCode = codes[2];
						    ///String billNo=codes[3];
						    
							strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_result_dtl_new(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,? )}"; 
							nProcIndex1 = daoObj.setProcedure(strProcName);
							daoObj.setProcInValue(nProcIndex1, "hmode", "1",1);
							daoObj.setProcInValue(nProcIndex1, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the req is sent.
							daoObj.setProcInValue(nProcIndex1, "crno", vo.getPatCRNo(),3);
							daoObj.setProcInValue(nProcIndex1, "labcode", labCode,4);
							System.out.println("labCode"+labCode);
							daoObj.setProcInValue(nProcIndex1, "testcode", testCode,5);
							System.out.println("testCode"+testCode);
							daoObj.setProcInValue(nProcIndex1, "parametercode", parameterCode,6);
							System.out.println("parameterCode"+parameterCode);
							daoObj.setProcInValue(nProcIndex1, "testcodeval", vo.getStrTestResult()[i],7); 
							System.out.println("vo.getStrTestResult()::\t"+vo.getStrTestResult());
							daoObj.setProcInValue(nProcIndex1, "refrange", vo.getStrRefRangeVal()[i],8);
							System.out.println("vo.getStrRefRangeVal()::\t"+vo.getStrRefRangeVal());
							daoObj.setProcInValue(nProcIndex1, "patmobileno", vo.getPatMobileNo(),9);
							daoObj.setProcInValue(nProcIndex1, "requisitiondate", vo.getSamplecoldate(),10);
							daoObj.setProcInValue(nProcIndex1, "resultdate", vo.getResultDate(),11);
							daoObj.setProcInValue(nProcIndex1, "seatid", vo.getSeatId(),12);
							daoObj.setProcInValue(nProcIndex1, "pat_file_name", vo.getStrPatFileName(),13);
							daoObj.setProcInValue(nProcIndex1, "parent_hosp_code", vo.getStrParentHospitalCode(),14);
							//daoObj.setProcInValue(nProcIndex1, "billno", billNo,15);
							System.out.println("billnonandini>>");
							daoObj.setProcOutValue(nProcIndex1, "err",1,15);
							daoObj.setProcOutValue(nProcIndex1, "req_no",1,16);								
							daoObj.execute(nProcIndex1 , 1);
						}
					}
					 	
					 synchronized (daoObj) 
						{
						 daoObj.fire();
						}
					 
					 String req_no = daoObj.getString(nProcIndex1, "req_no");
					 
					 System.out.println("new request 1no is >> "+req_no);
					 
					 
					 vo.setRequisitionNo(req_no);
					 
					 
					 
					 
				}
			//}
			catch (Exception e)
			{
				 e.printStackTrace();
				 vo.setStrMsgString("NEWOfflineResultEntryDAO.insertOffllineResultEntry() --> "+ e.getMessage());
				 vo.setStrMsgType("1");
			}
			finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		} */
		
		
		
public void insertOffllineResultEntryBilling(NEWOfflineResultEntryVO vo) {
			
			HisDAO daoObj = null;
			String strProcName = "";
			int nProcIndex = 0;
			int nProcIndex1 =0 ;
			String strCrNo=new String();
			int funcIndex=0;
			
			try {
					//Generate CR Number.
				System.out.println("nandini13");
					daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
					funcIndex = daoObj.setFunction("{? = call pkg_inv_fun.fun_gen_result_seq_no(?)}");
					
					daoObj.setFuncInValue(funcIndex, 2, vo.getStrPatHospCode());
					daoObj.setFuncOutValue(funcIndex,1);
					 
					daoObj.executeFuncForNumeric(funcIndex);
					strCrNo = daoObj.getFuncNumeric(funcIndex);
					 ResultSet rs = null;
					 //vo.setSamplecoldate("7-Sept-2022");
					// vo.setResultDate("7-Sept-2022");
					//vo.setPatCRNo(strCrNo);
					
					String strDate = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());
					String strFileName = vo.getPatCRNo()+ new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date())+ ".pdf";
					vo.setStrPatFileName(strFileName);
					System.out.println("strFileName"+strFileName);
					vo.setSamplecoldate(strDate);
					vo.setResultDate(strDate);
					//Save Patient's Details
					System.out.println("nandini14");
					//daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
					strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
					daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the request is sent.
					daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
					System.out.println("getPatCRNo::\t"+vo.getPatCRNo());
					daoObj.setProcInValue(nProcIndex, "patageunit", vo.getStrPatAgeUnit(),4); 
					daoObj.setProcInValue(nProcIndex, "patname", vo.getPatName(),5);
					daoObj.setProcInValue(nProcIndex, "patgendercode", vo.getPatGenderCode().toUpperCase().substring(0,1),6);
					daoObj.setProcInValue(nProcIndex, "patage", vo.getPatAge(),7);
					System.out.println("getPatAge::\t"+vo.getPatAge());
					daoObj.setProcInValue(nProcIndex, "pataddress", vo.getPatAddress(),8);
					daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
					System.out.println("vo.getPatMobileNo()::\t"+vo.getPatMobileNo());
					daoObj.setProcInValue(nProcIndex, "patguardianname", vo.getPatGuardianName(),10);
					daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),11);
					System.out.println("vo.requisitiondate()::\t"+vo.getSamplecoldate());
					daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),12);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),13);
					daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),14);
					daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),15);
					daoObj.setProcOutValue(nProcIndex, "err",1,16);
					
					daoObj.execute(nProcIndex , 1);
					System.out.println("23");
					//Save Tests' Details
					//if(vo.getStrHiddenValue()!=null) {
					
					
					 for (int i=0; i<vo.getStrHiddenValue().length;i++)
					{
						if(!vo.getStrHiddenValue()[i].equals("0"))
						{
						    String codes[] = vo.getStrHiddenValue()[i].replace("^", "#").split("#");

						    String labCode = codes[0];
						    String testCode = codes[1];
						    String parameterCode = codes[2];
						    String billNo=codes[3];
						    
							strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_result_dtl_billing(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,? ,?)}"; 
							nProcIndex1 = daoObj.setProcedure(strProcName);
							daoObj.setProcInValue(nProcIndex1, "hmode", "1",1);
							daoObj.setProcInValue(nProcIndex1, "hcode", vo.getStrParentHospitalCode(),2); //Hospital Code of the hospital from where the req is sent.
							daoObj.setProcInValue(nProcIndex1, "crno", vo.getPatCRNo(),3);
							daoObj.setProcInValue(nProcIndex1, "labcode", labCode,4);
							System.out.println("labCode"+labCode);
							daoObj.setProcInValue(nProcIndex1, "testcode", testCode,5);
							System.out.println("testCode"+testCode);
							daoObj.setProcInValue(nProcIndex1, "parametercode", parameterCode,6);
							System.out.println("parameterCode"+parameterCode);
							daoObj.setProcInValue(nProcIndex1, "testcodeval", vo.getStrTestResult()[i],7); 
							System.out.println("vo.getStrTestResult()::\t"+vo.getStrTestResult());
							daoObj.setProcInValue(nProcIndex1, "refrange", vo.getStrRefRangeVal()[i],8);
							System.out.println("vo.getStrRefRangeVal()::\t"+vo.getStrRefRangeVal());
							daoObj.setProcInValue(nProcIndex1, "patmobileno", vo.getPatMobileNo(),9);
							daoObj.setProcInValue(nProcIndex1, "requisitiondate", vo.getSamplecoldate(),10);
							daoObj.setProcInValue(nProcIndex1, "resultdate", vo.getResultDate(),11);
							daoObj.setProcInValue(nProcIndex1, "seatid", vo.getSeatId(),12);
							daoObj.setProcInValue(nProcIndex1, "pat_file_name", vo.getStrPatFileName(),13);
							daoObj.setProcInValue(nProcIndex1, "parent_hosp_code", vo.getStrParentHospitalCode(),14);
							daoObj.setProcInValue(nProcIndex1, "billno", billNo,15);					
							System.out.println("billno>>"+billNo);
							daoObj.setProcOutValue(nProcIndex1, "err",1,16);
							daoObj.setProcOutValue(nProcIndex1, "req_no",1,17);								
							daoObj.execute(nProcIndex1 , 1);
						}
					}
					 	
					 synchronized (daoObj) 
						{
						 daoObj.fire();
						}
					 
					 String req_no = daoObj.getString(nProcIndex1, "req_no");
					 
					 System.out.println("new request 1no is >> "+req_no);
					 
					 
					 vo.setRequisitionNo(req_no);
					 
					 
					 
					 
				}
			//}
			catch (Exception e)
			{
				 e.printStackTrace();
				 vo.setStrMsgString("NEWOfflineResultEntryDAO.insertOffllineResultEntry() --> "+ e.getMessage());
				 vo.setStrMsgType("1");
			}
			finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		}

		
		
		
		
		
		
		public void getOffllineResultEntryPatientData(NEWOfflineResultEntryVO vo) {
			
			HisDAO daoObj = null;
			WebRowSet ws = null;
			
			
			String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?, ?,?)}";
			int nProcIndex = 0;

			String strErr = "";

			daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO.getOffllineResultEntryData()");
			try
			{
				daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
				
				if(vo.getPatCRNo()==""|| vo.getPatCRNo()==null || vo.getPatCRNo().equalsIgnoreCase("") )
					daoObj.setProcInValue(nProcIndex, "p_crno", "0",2);
				else
					daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
				
				if(vo.getPatMobNo()==""|| vo.getPatMobNo()==null || vo.getPatMobNo().equalsIgnoreCase("") )
					 daoObj.setProcInValue(nProcIndex, "p_mobno", "0",3);
				else
					daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
				
				daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),4);
				
				if(vo.getStrParentHospitalCode()==""|| vo.getStrParentHospitalCode()==null || vo.getStrParentHospitalCode().equalsIgnoreCase("") )
					 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
				else
					daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrParentHospitalCode(),5);
				
				if(vo.getRequisitionNo()==""|| vo.getRequisitionNo()==null || vo.getRequisitionNo().equalsIgnoreCase(""))
					daoObj.setProcInValue(nProcIndex, "p_requisitionNo", "0",6);
				else
					daoObj.setProcInValue(nProcIndex, "p_requisitionNo", vo.getRequisitionNo(),6);
				
				System.out.println("RequisitionNo :) >>>"+vo.getRequisitionNo());
				
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,8);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null || strErr.equals(""))
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");
				
				if (strErr.equals("")) 
					vo.setStrPatientDtlWS(ws);
				else {
					throw new Exception(strErr);
				}
				
				if(ws.size()>0) {
					
				}
				else {
					vo.setStrMsgType("2");
					vo.setStrMsgString("No Record Found !");
				}
						
			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("NEWOfflineResultEntryDAO.getOffllineResultEntryPatientData() --> "+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
			
		}

		public void getOffllineResultEntryPatientTestData(NEWOfflineResultEntryVO vo) {

			HisDAO daoObj = null;
			WebRowSet ws = null;
			
			String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?, ?,?)}";
			int nProcIndex = 0;

  			String strErr = "";

 			daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO.getOffllineResultEntryData()");
			try
			{
				daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO");
				nProcIndex = daoObj.setProcedure(strProcName);
				
				daoObj.setProcInValue(nProcIndex, "p_mode", "2",1);
				
				if(vo.getPatCRNo()==""|| vo.getPatCRNo()==null || vo.getPatCRNo().equalsIgnoreCase(""))
					daoObj.setProcInValue(nProcIndex, "p_crno", "0",2);
				else
					daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
				
				if(vo.getPatMobNo()==""|| vo.getPatMobNo()==null || vo.getPatMobNo().equalsIgnoreCase(""))
					 daoObj.setProcInValue(nProcIndex, "p_mobno", "0",3);
				else
					daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
						
				daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),4);
				
				if(vo.getStrParentHospitalCode()==""|| vo.getStrParentHospitalCode()==null || vo.getStrParentHospitalCode().equalsIgnoreCase("") )
					 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
				else
					daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrParentHospitalCode(),5);
				
				if(vo.getRequisitionNo()==""|| vo.getRequisitionNo()==null || vo.getRequisitionNo().equalsIgnoreCase(""))
					daoObj.setProcInValue(nProcIndex, "p_requisitionNo", "0",6);
				else
					daoObj.setProcInValue(nProcIndex, "p_requisitionNo", vo.getRequisitionNo(),6);
				System.out.println("RequisitionNo :( >>>"+vo.getRequisitionNo());
				
				daoObj.setProcOutValue(nProcIndex, "err", 1,7);
				daoObj.setProcOutValue(nProcIndex, "resultset", 2,8);
				daoObj.executeProcedureByPosition(nProcIndex);
				strErr = daoObj.getString(nProcIndex, "err");
				if (strErr == null)
					strErr = "";
				ws = daoObj.getWebRowSet(nProcIndex, "resultset");

				if (strErr.equals("")) 
					{vo.setStrPatientTestListWS(ws);
					ws.beforeFirst();
					  while (ws.next()) {
					System.out.println("Nandini  + "+ws.getString(9));
					  }
					
					}
				else 
					throw new Exception(strErr);
			} catch (Exception e) {
				e.printStackTrace();
				vo.setStrMsgString("NEWOfflineResultEntryDAO.getOffllineResultEntryPatientTestData() --> "+ e.getMessage());
				vo.setStrMsgType("1");
			} finally {
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			}
		 }

		
		
		public  List<NEWOfflineResultEntryVO> getBilledPatList(String reqNo,String reqType,UserVO _UserVO)
		{
			String query = "";		
			Map populateMAP = new HashMap();
			ResultSet rs = null;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.BILLING_PAT_LIST.HIVT_REQUISITION_DTLS";
			Sequence sq = new Sequence();
			
			NEWOfflineResultEntryVO voSampleCollection=null;

			List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
			
		//	populateMAP.put(sq.next(), reqType);
			populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
			populateMAP.put(sq.next(), InvestigationConfig.REQUISTION_DTL_UPDATE_RESCHEDULED_STATUS);
			populateMAP.put(sq.next(), reqNo);
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
						populateMAP);
				rs.beforeFirst();
				
				 if (!rs.next())
		            {
		                throw new HisRecordNotFoundException("No Patient List  Found");
		            }
		            else
		            {
		                rs.beforeFirst();
		                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
		                while (rs.next()) {
		                	voSampleCollection=new NEWOfflineResultEntryVO();
		                	HelperMethods.populateVOfrmRS(voSampleCollection, rs);
		                	 lstInvSampleCollectionVO.add(voSampleCollection);
		                }
		            }
			}
			catch (HisRecordNotFoundException e)
			{

			//	throw new HisRecordNotFoundException(e.getMessage());
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("" + e);
			}
			return lstInvSampleCollectionVO;

		}
		
		public List<String> getStaffDetails(String crNo,UserVO _UserVO)
		{
			String query = "";		
			Map populateMAP = new HashMap();
			ResultSet rs = null;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.STAFF_DETAILS_LIST.HRGT_PATIENT_ID_DTL";
			Sequence sq = new Sequence();
			
			NEWOfflineResultEntryVO voSampleCollection=null;

			List<String> staffDetails =null;
			
			populateMAP.put(sq.next(), crNo);
			populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
						populateMAP);
				rs.beforeFirst();
				
				 if (!rs.next())
		         {
		                //throw new HisRecordNotFoundException("No Staff Details Found");
		         }
		         else
		         {
		                rs.beforeFirst();
		                staffDetails=new ArrayList<String>();
		                while (rs.next()){
		                	//System.out.println("rs.getString(1) : "+rs.getString(1)+" rs.getString(2) : "+rs.getString(2)+" rs.getString(3) : "+rs.getString(3));
		                	staffDetails.add(rs.getString(1));
		                	staffDetails.add(rs.getString(2));
		                	staffDetails.add(rs.getString(3));
		                }
		          }
			}
			catch (HisRecordNotFoundException e)
			{

				throw new HisRecordNotFoundException(e.getMessage());
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("" + e);
			}
			return staffDetails;

		}
		
		
		
		public List getUOMCombo(UserVO _UserVO)
		{
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			List uomCombo=new ArrayList();
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey="SELECT.UOM_COMBO.HIVT_UOM_MST";
			
			Sequence sq= new Sequence();
			Connection conn=super.getTransactionContext().getConnection();
			
			//populateMap.put(sq.next(), _UserVO.getHospitalCode());
			try
			{
				query = HelperMethodsDAO.getQuery(filename,queryKey);
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException();
				}
				else
				{
					rs.beforeFirst();
					uomCombo=HelperMethodsDAO.getAlOfEntryObjects(rs);
				}
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException();	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }	
			return uomCombo;
		}
		
		
		public List getContainerCombo(UserVO _UserVO)
		{
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			List containerCombo=new ArrayList();
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey="SELECT.CONTAINER_COMBO.HIVT_CONTAINER_MST";
			
			Sequence sq= new Sequence();
			Connection conn=super.getTransactionContext().getConnection();
			
			//populateMap.put(sq.next(), _UserVO.getHospitalCode());
			try
			{
				query = HelperMethodsDAO.getQuery(filename,queryKey);
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException();
				}
				else
				{
					rs.beforeFirst();
					containerCombo=HelperMethodsDAO.getAlOfEntryObjects(rs);
				}
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException();	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }	
			return containerCombo;
		}
		
		
		public String generateSampleNoSequence(String sampleCode,String labCode,UserVO userVO)
		{
			String sampleNo=""; 
			String errorMsg="";
			ResultSet rs=null;
			
			System.out.println("calling generateSampleNoSequence");
			
			try
			{
				
				System.out.println("start calling generateSampleNoSequence");

				Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_GENERATE_SAMPLENO);
				strProc.addInParameter(1,Types.VARCHAR,userVO.getHospitalCode());
				strProc.addInParameter(2,Types.VARCHAR,sampleCode);
				strProc.addInParameter(3,Types.VARCHAR,labCode);
				strProc.setReturnType(Types.VARCHAR);
				return	sampleNo = (String)strProc.execute(super.getTransactionContext().getConnection());
				
			}
			catch (HisRecordNotFoundException e)
			{
				throw new HisRecordNotFoundException("No Record Found");
			}
			
			
			
		}
		// Not in Use form 27th-May-2015
		public void insertSampleNoSequenceInMaintainer(String sampleCode,String labCode,String sequence,String yymmdd, UserVO _userVO) {

			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="INSERT.SAMPLENO.SYS_SAMPLE_MAINTAINER";

			
			try {
				query = HelperMethodsDAO.getQuery(filename, queryKey);

			} catch (Exception e) {
				throw new HisApplicationExecutionException(
						"HelperMethodsDAO.loadPropertiesFile(filename) OR getting query out of property file"
								+ e);
			}

			try {
				
				populateMAP.put(sq.next(),labCode);
				populateMAP.put(sq.next(),sampleCode);
				populateMAP.put(sq.next(),_userVO.getHospitalCode());
				populateMAP.put(sq.next(),sequence);
				populateMAP.put(sq.next(),yymmdd);
				
	        	
	            	
			} catch (Exception e) {
				throw new HisApplicationExecutionException(
						"IcdGroupMasterDAO.populateMAP::" + e);
			}
			try {

				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext()
						.getConnection(), query, populateMAP);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new HisDataAccessException("Exception While insertion in SYS_REQUISITION_MAINTAINER Table");
			}

		}
		
		//Not in Use from 27th-May-2015
		public void 
eSampleNoSequenceInMaintainer(String sequence,String sampleCode,String labCode,UserVO _UserVO)
		{
			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="UPDATE.SAMPLENO.SYS_SAMPLE_MAINTAINER";
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				populateMAP.put(sq.next(),sequence);
				populateMAP.put(sq.next(),labCode);
				populateMAP.put(sq.next(),sampleCode);
				populateMAP.put(sq.next(), _UserVO.getHospitalCode());
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
			}
			try
			{
				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
			}
		}
		
		// Commented By:- Anant Patel Dated:- 29th-May-2015
		// Reason:-Query Moved to Package'pkg_inv_dml.proc_insert_reqisition_header' from properties file
		
		/*public void updateRequisitionHeader(String mobileNo,String emailId,String patAddress,String reqNo,UserVO _UserVO)
		{
			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="UPDATE.PATDTLS.HIVT_REQUISITION_HEADER";
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				populateMAP.put(sq.next(),mobileNo);
				populateMAP.put(sq.next(),emailId);
				populateMAP.put(sq.next(),patAddress);
				populateMAP.put(sq.next(), _UserVO.getHospitalCode());
				populateMAP.put(sq.next(), reqNo);
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
			}
			try
			{
				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
			}
		}*/
		//In use from 29th-May-2015 Added By Anant Patel Dated:-29th-May-2015
		public void updateRequisitionHeader(String mobileNo,String emailId,String patAddress,String reqNo,UserVO _UserVO,String patcatcode)
		{	
			try
			{ 
				Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_UPDATE_REQUSITION_HEADER);
				strProc.addInParameter(1,Types.VARCHAR,InvestigationConfig.SAMPLE_COLLECTION_MODE);
				strProc.addInParameter(2,Types.VARCHAR,reqNo);
				strProc.addInParameter(3,Types.VARCHAR,null);
				strProc.addInParameter(4,Types.VARCHAR,_UserVO.getHospitalCode());
				strProc.addInParameter(5,Types.VARCHAR,null);
				strProc.addInParameter(6,Types.VARCHAR,null);
				strProc.addInParameter(7,Types.VARCHAR,null);
				strProc.addInParameter(8,Types.VARCHAR,null);
				strProc.addInParameter(9,Types.VARCHAR,null);
				strProc.addInParameter(10,Types.VARCHAR,null);
				strProc.addInParameter(11,Types.VARCHAR,null);
				strProc.addInParameter(12,Types.VARCHAR,null);
				strProc.addInParameter(13,Types.VARCHAR,null);
				strProc.addInParameter(14,Types.VARCHAR,null);
				strProc.addInParameter(15,Types.VARCHAR,null);
				strProc.addInParameter(16,Types.VARCHAR,null);
				strProc.addInParameter(17,Types.VARCHAR,null);
				strProc.addInParameter(18,Types.VARCHAR,null);
				strProc.addInParameter(19,Types.VARCHAR,null);
				strProc.addInParameter(20,Types.VARCHAR,null);
				strProc.addInParameter(21,Types.VARCHAR,patAddress);
				strProc.addInParameter(22,Types.VARCHAR,null);
				strProc.addInParameter(23,Types.VARCHAR,mobileNo);
				strProc.addInParameter(24,Types.VARCHAR,emailId);
				strProc.addInParameter(25,Types.VARCHAR,null);
				strProc.addInParameter(26,Types.VARCHAR,null);
				strProc.addInParameter(27,Types.VARCHAR,null);
				strProc.addInParameter(28,Types.VARCHAR,null);
				strProc.addInParameter(29,Types.VARCHAR,null);
				strProc.addInParameter(30,Types.VARCHAR,null);
				strProc.addInParameter(31,Types.VARCHAR,null);
				strProc.addInParameter(32,Types.VARCHAR,null);
				strProc.addInParameter(33,Types.VARCHAR,null);
				strProc.addInParameter(34,Types.VARCHAR,null);
				strProc.addInParameter(35,Types.VARCHAR,null);
				strProc.addInParameter(36,Types.VARCHAR,null);
				strProc.addInParameter(37,Types.VARCHAR,null);
				strProc.addInParameter(38,Types.VARCHAR,null);
				strProc.addInParameter(39,Types.VARCHAR,null);
				strProc.addInParameter(40,Types.VARCHAR,null);
				strProc.addInParameter(41,Types.VARCHAR,null);
				strProc.addInParameter(42,Types.VARCHAR,null);
				strProc.addInParameter(43,Types.VARCHAR,null);
				strProc.addInParameter(44,Types.VARCHAR,null);
				strProc.addInParameter(45,Types.VARCHAR,Config.IS_VALID_ACTIVE);
				strProc.addInParameter(46,Types.VARCHAR,null);
				strProc.addInParameter(47, Types.VARCHAR,patcatcode);
				strProc.addInParameter(48, Types.VARCHAR,null);
				strProc.addInOutParameter(49,Types.VARCHAR,"");
				strProc.execute(super.getTransactionContext().getConnection());
			}
			catch (HisDataAccessException e)
			{
				throw new HisDataAccessException();
			}
			
		}
		
		// Commented By:- Anant Patel Dated:- 28th-May-2015
	   //   Reason:-Query Moved to Package'pkg_inv_dml.proc_insert_reqisition_dtl from properties file'
		/*public void updateRequisitionDtl(NEWOfflineResultEntryVO voSample,UserVO _UserVO)
		{
			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="UPDATE.REQDTLS.HIVT_REQUISITION_DTLS";
			try
			{
				query = HelperMethodsDAO.getQuery(filename, queryKey);
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				populateMAP.put(sq.next(),voSample.getReqDtlStatus());
				populateMAP.put(sq.next(),voSample.getSampleNo());
				populateMAP.put(sq.next(),voSample.getBillNo());
				populateMAP.put(sq.next(),voSample.getTempSampleNo());
				populateMAP.put(sq.next(), _UserVO.getSeatId());
				populateMAP.put(sq.next(),voSample.getSampleAreaCode());
				populateMAP.put(sq.next(),voSample.getDefaultUOMCode());
				populateMAP.put(sq.next(),voSample.getDefaultContainerCode());
				populateMAP.put(sq.next(),voSample.getSampleQnty());
				populateMAP.put(sq.next(), _UserVO.getHospitalCode());
				populateMAP.put(sq.next(), voSample.getRequisitionDNo());
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
			}
			try
			{
				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
			}
		}*/
		
		//In use from 28th-May-2015 Added By Anant Patel Dated:-28th-May-2015
		public void updateRequisitionDtl(NEWOfflineResultEntryVO voSample,UserVO userVO)
		{
			String sampleNo=""; 
			String errorMsg="";
			ResultSet rs=null;
			try
			{
				Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_INSERT_REQUSITION_DTL);
				strProc.addInParameter(1,Types.VARCHAR,InvestigationConfig.SAMPLE_COLLECTION_MODE);
				strProc.addInParameter(2,Types.VARCHAR,userVO.getHospitalCode());
				strProc.addInParameter(3,Types.VARCHAR,voSample.getRequisitionDNo());
				strProc.addInParameter(4,Types.VARCHAR,null);
				strProc.addInParameter(5,Types.VARCHAR,null);
				strProc.addInParameter(6,Types.VARCHAR,null);
				strProc.addInParameter(7,Types.VARCHAR,null);
				strProc.addInParameter(8,Types.VARCHAR,null);
				strProc.addInParameter(9,Types.VARCHAR,null);
				strProc.addInParameter(10,Types.VARCHAR,voSample.getReqDtlStatus());
				strProc.addInParameter(11,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(12,Types.VARCHAR,null);
				strProc.addInParameter(13,Types.VARCHAR,voSample.getTempSampleNo());
				strProc.addInParameter(14,Types.VARCHAR,null);
				strProc.addInParameter(15,Types.VARCHAR,null);
				strProc.addInParameter(16,Types.VARCHAR,null);
				strProc.addInParameter(17,Types.VARCHAR,voSample.getBillNo());
				strProc.addInParameter(18,Types.VARCHAR,null);
				strProc.addInParameter(19,Types.VARCHAR,null);
				strProc.addInParameter(20,Types.VARCHAR,null);
				strProc.addInParameter(21,Types.VARCHAR,null);
				strProc.addInParameter(22,Types.VARCHAR,null);
				strProc.addInParameter(23,Types.VARCHAR,null);
				strProc.addInParameter(24,Types.VARCHAR,null);
				strProc.addInParameter(25,Types.VARCHAR,null);
				strProc.addInParameter(26,Types.VARCHAR,null);
				strProc.addInParameter(27,Types.VARCHAR,null);
				strProc.addInParameter(28,Types.VARCHAR,null);
				strProc.addInParameter(29,Types.VARCHAR,null);
				strProc.addInParameter(30,Types.VARCHAR,null);
				strProc.addInParameter(31,Types.VARCHAR,null);
				strProc.addInParameter(32,Types.VARCHAR,null);
				strProc.addInParameter(33,Types.VARCHAR,InvestigationConfig.SAMPLE_ACCEPTED);
				strProc.addInParameter(34,Types.VARCHAR,null);
				strProc.addInParameter(35,Types.VARCHAR,voSample.getDefaultmachineCode());
				strProc.addInParameter(36,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(37,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(38,Types.VARCHAR,voSample.getSampleAreaCode());
				strProc.addInParameter(39,Types.VARCHAR,null);
				strProc.addInParameter(40,Types.VARCHAR,null);
				strProc.addInParameter(41,Types.VARCHAR,InvestigationConfig.SAMPLE_RECEIVED);
				strProc.addInParameter(42,Types.VARCHAR,voSample.getSampleNo());
				strProc.addInParameter(43,Types.VARCHAR,voSample.getDefaultUOMCode());
				strProc.addInParameter(44,Types.VARCHAR,voSample.getSampleQnty());
				strProc.addInParameter(45,Types.VARCHAR,voSample.getDefaultContainerCode());
				strProc.addInParameter(46,Types.VARCHAR,null);
				strProc.addInParameter(47,Types.VARCHAR,null);
				
				strProc.addInOutParameter(48,Types.VARCHAR ,"");
				strProc.addInParameter(49,Types.VARCHAR ,voSample.getPatCategoryCode()==null?"":voSample.getPatCategoryCode());

				strProc.execute(super.getTransactionContext().getConnection());
				
			}
			catch (HisRecordNotFoundException e)
			{
				throw new HisRecordNotFoundException("No Record Found");
			}
			
		}
		// Commented By:- Anant Patel Dated:- 28th-May-2015
	   //  Reason:-Query Moved to Package'pkg_inv_dml.proc_insert_sample_dtl from properties file'
		/*public void insertSampleDtl(NEWOfflineResultEntryVO voSample, UserVO _userVO) {

			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="INSERT.SAMPLEDTLS.HIVT_SAMPLE_DTL";

			
			try {
				query = HelperMethodsDAO.getQuery(filename, queryKey);

			} catch (Exception e) {
				throw new HisApplicationExecutionException(
						"HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file"
								+ e);
			}

			try {
				
				populateMAP.put(sq.next(),voSample.getSampleNo());
				populateMAP.put(sq.next(),_userVO.getHospitalCode());
				populateMAP.put(sq.next(),voSample.getRequisitionDNo());
				populateMAP.put(sq.next(),voSample.getSampleAreaCode());
				populateMAP.put(sq.next(),_userVO.getSeatId());
				populateMAP.put(sq.next(),voSample.getPrintStatus());
				populateMAP.put(sq.next(),voSample.getSampleQnty());
				populateMAP.put(sq.next(),voSample.getSampleCode());
				populateMAP.put(sq.next(),voSample.getDefaultUOMCode());
				populateMAP.put(sq.next(),voSample.getDefaultContainerCode());
				populateMAP.put(sq.next(),voSample.getTypeOfComponent());
				populateMAP.put(sq.next(),_userVO.getSeatId());
				populateMAP.put(sq.next(),(voSample.getSampleStatusCode()==null?"1":voSample.getSampleStatusCode()));
				populateMAP.put(sq.next(),(voSample.getTempSampleNo()==null?"0":voSample.getTempSampleNo()));
				
			} catch (Exception e) {
				throw new HisApplicationExecutionException(
						"IcdGroupMasterDAO.populateMAP::" + e);
			}
			try {

				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext()
						.getConnection(), query, populateMAP);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				throw new HisDataAccessException("Exception While insertion in HIVT_SAMPLE_DTL Table");
			}

		}*/
		
		// In use from 28th-May-2015 Added By:- Anant Patel Date:-28th-May-2015
		public void insertSampleDtl(NEWOfflineResultEntryVO voSample, UserVO userVO)
		{
			String sampleNo=""; 
			String errorMsg="";
			ResultSet rs=null;
			try
			{
				Connection conn=super.getTransactionContext().getConnection();
				Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_INSERT_SAMPLE_DTL);
				strProc.addInParameter(1,Types.VARCHAR,InvestigationConfig.SAMPLE_COLLECTION_MODE);
				strProc.addInParameter(2,Types.VARCHAR,voSample.getSampleNo());
				strProc.addInParameter(3,Types.VARCHAR,userVO.getHospitalCode());
				strProc.addInParameter(4,Types.VARCHAR,voSample.getRequisitionDNo());
				strProc.addInParameter(5,Types.VARCHAR,"");
				strProc.addInParameter(6,Types.VARCHAR,voSample.getSampleAreaCode());
				strProc.addInParameter(7,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(8,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(9,Types.VARCHAR,"");
				strProc.addInParameter(10,Types.VARCHAR,null);
				strProc.addInParameter(11,Types.VARCHAR,null);
				strProc.addInParameter(12,Types.VARCHAR,voSample.getPrintStatus());
				strProc.addInParameter(13,Types.VARCHAR,voSample.getSampleQnty());
				strProc.addInParameter(14,Types.VARCHAR,voSample.getSampleCode());
				strProc.addInParameter(15,Types.VARCHAR,voSample.getDefaultUOMCode());
				strProc.addInParameter(16,Types.VARCHAR,voSample.getDefaultContainerCode());
				strProc.addInParameter(17,Types.VARCHAR,voSample.getTempSampleNo());
				strProc.addInParameter(18,Types.VARCHAR,null);
				strProc.addInParameter(19,Types.VARCHAR,voSample.getTypeOfComponent());
				strProc.addInParameter(20,Types.VARCHAR,userVO.getSeatId());
				strProc.addInParameter(21,Types.VARCHAR,InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
				strProc.addInParameter(22,Types.VARCHAR,(voSample.getTempSampleNo()==null?"0":voSample.getTempSampleNo()));
				strProc.addInOutParameter(23,Types.VARCHAR ,"");
				strProc.execute(conn);
			
			}
				
			//	int nProcedureIndex;
				//String strDBErr;
				/*try
				{
					
					HisDAO hisDAO_p=new HisDAO("sampleCollection", "sampleCollectionDAO"); 
					
					nProcedureIndex = hisDAO_p.setProcedure(InvestigationConfig.PROCEDURE_INSERT_SAMPLE_DTL_HMODE_1);
*/
					// Setting and Registering In and Out Parameters 
				/*	hisDAO_p.setProcInValue(nProcedureIndex, "hmode", InvestigationConfig.SAMPLE_COLLECTION_MODE,1);
					hisDAO_p.setProcInValue(nProcedureIndex, "sampleno", voSample.getSampleNo(),2);
					hisDAO_p.setProcInValue(nProcedureIndex, "hcode", userVO.getHospitalCode(),3);
					hisDAO_p.setProcInValue(nProcedureIndex, "reqdno",voSample.getRequisitionDNo(),4);
					hisDAO_p.setProcInValue(nProcedureIndex, "packing_list_no", null,5);
					hisDAO_p.setProcInValue(nProcedureIndex, "sample_col_area_code", voSample.getSampleAreaCode(),6);
					hisDAO_p.setProcInValue(nProcedureIndex, "collection_seatid", userVO.getSeatId(),7);
					hisDAO_p.setProcInValue(nProcedureIndex, "acceptance_seatid",userVO.getSeatId(),8);
					hisDAO_p.setProcInValue(nProcedureIndex, "sam_rejection_saetid", null,9);
					hisDAO_p.setProcInValue(nProcedureIndex, "samp_rejection_action", null,10);
					hisDAO_p.setProcInValue(nProcedureIndex, "sam_rejection_reason", null,11);
					hisDAO_p.setProcInValue(nProcedureIndex, "printstatus",voSample.getPrintStatus(),12);
					hisDAO_p.setProcInValue(nProcedureIndex, "collected_vol", voSample.getSampleQnty(),13);
					hisDAO_p.setProcInValue(nProcedureIndex, "samplecode", voSample.getSampleCode(),14);
					hisDAO_p.setProcInValue(nProcedureIndex, "uom_code",voSample.getDefaultUOMCode(),15);
					hisDAO_p.setProcInValue(nProcedureIndex, "container_code", voSample.getDefaultContainerCode(),16);
					hisDAO_p.setProcInValue(nProcedureIndex, "daily_no", voSample.getTempSampleNo(),17);
					hisDAO_p.setProcInValue(nProcedureIndex, "accession_no", null,18);
					hisDAO_p.setProcInValue(nProcedureIndex, "typeofcomponent", voSample.getTypeOfComponent(),19);
					hisDAO_p.setProcInValue(nProcedureIndex, "seatid", userVO.getSeatId(),20);
					hisDAO_p.setProcInValue(nProcedureIndex, "sam_status_code",(voSample.getTempSampleNo()==null?"0":voSample.getTempSampleNo()),21);
					hisDAO_p.setProcInValue(nProcedureIndex, "temp_sample_no", (voSample.getTempSampleNo()==null?"0":voSample.getTempSampleNo()),22);
							
					hisDAO_p.setProcOutValue(nProcedureIndex, "err", 1,23);*/ // varchar

					// Executing Procedure 
					//hisDAO_p.executeProcedureByPosition(nProcedureIndex);

					// Getting out parameters not in case of Batch Processing 
//					strDBErr = hisDAO_p.getString(nProcedureIndex, "err");
		//
//					// If Database Error Occurs, No farther processing is required. 
//					if (strDBErr != null && !strDBErr.equals(""))
//					{
//						throw new Exception("Data Base Error:" + strDBErr);
//					}
			//	}
				catch (Exception e)
				{
					e.printStackTrace();
					throw new HisDataAccessException("samplecoll.dml()::hisDAO_p.execute" + InvestigationConfig.PROCEDURE_INSERT_SAMPLE_DTL 
							+ ") -> " + e.getMessage());
				}

				
				
				
				
		//}
			/*catch (HisRecordNotFoundException e)
			{
				throw new HisRecordNotFoundException("No Record Found");
			}*/
			
		}
		
		
		
		public boolean checkSampleNoDuplicacy(NEWOfflineResultEntryVO voSample,UserVO _UserVO)
		{
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			int count=0;
			boolean isTempSampleNoPresent=false;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey="SELECT.TEMP_SAMPLE_NO.HIVT_SAMPLE_DTL";
			
			Sequence sq= new Sequence();
			Connection conn=super.getTransactionContext().getConnection();
			
			populateMap.put(sq.next(), voSample.getSampleAreaCode());
			
			populateMap.put(sq.next(), voSample.getTempSampleNo());
			
			//populateMap.put(sq.next(), _UserVO.getHospitalCode());
			try
			{
				query = HelperMethodsDAO.getQuery(filename,queryKey);
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException();
				}
				else
				{
					//rs.beforeFirst();
					count=rs.getInt(1);
					if(count>0)
						isTempSampleNoPresent=true;
				}
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException();	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }	
			return isTempSampleNoPresent;
		}
		
		
		
		//Check Auto Generation of Sample No 
		
		
		public List<NEWOfflineResultEntryVO> checkAutoGenFormate(NEWOfflineResultEntryVO voSample,UserVO _UserVO)
		{
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			List<String> Formate=new ArrayList<String>();
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_SAMPLENO_CONF_MST1";
			String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_COLAREA_SAMNO_CONFIG_MST";
			   
			
			if (voSample.getPatType()==null)
				voSample.setPatType("1");
			else if(voSample.getPatType().equals("3") || voSample.getPatType().equals("4"))
				voSample.setPatType("1");
			else
				;
			
			
			Connection conn=super.getTransactionContext().getConnection();
			try
			{
				if(voSample.getTempSampleNo().equals("1"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				}
				if(voSample.getTempSampleNo().equals("2"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey1);
				}
				
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}

			System.out.println("Query ---------> " + query);
			Sequence sq = new Sequence();
			try
			{
				if(voSample.getTempSampleNo().equals("1"))
				{
					populateMap.put(sq.next(),voSample.getLabCode());
					populateMap.put(sq.next(),voSample.getTestCode());
					populateMap.put(sq.next(),voSample.getPatType());
					populateMap.put(sq.next(),_UserVO.getHospitalCode());

				} 
				if(voSample.getTempSampleNo().equals("2"))
				{
					populateMap.put(sq.next(),voSample.getLabCode());
					populateMap.put(sq.next(),voSample.getConfigArea());
					populateMap.put(sq.next(),voSample.getPatType());
					populateMap.put(sq.next(),_UserVO.getHospitalCode());

				} 
				
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			List<NEWOfflineResultEntryVO> listNEWOfflineResultEntryVO = new ArrayList<NEWOfflineResultEntryVO>();
			ValueObject[] valueObjects = null;
			
			try
			{
				 
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMap);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException("No Patient Record");
				}
				else
				{
					rs.beforeFirst();
					valueObjects = HelperMethods.populateVOfrmRS(NEWOfflineResultEntryVO.class, rs);
					//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
				//	for (int i = 0; i < valueObjects.length; i++)
				//	{
						//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
						listNEWOfflineResultEntryVO.add((NEWOfflineResultEntryVO)valueObjects[0]);
					//}
				}
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException();	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }	
			return listNEWOfflineResultEntryVO;
		}
		public List<NEWOfflineResultEntryVO> getSampleCollAutoSampleNOConfig(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO)
		{
			ResultSet rs = null;
			String query = "";
			Map populateMAP = new HashMap();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_SAMPLENO_CONF_MST1";
			String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_COLAREA_SAMNO_CONFIG_MST";
			   
			if (NEWOfflineResultEntryVO.getPatType()==null)
				NEWOfflineResultEntryVO.setPatType("1");
			else if(NEWOfflineResultEntryVO.getPatType().equals("3") || NEWOfflineResultEntryVO.getPatType().equals("4"))
				NEWOfflineResultEntryVO.setPatType("1");
			else
				;
			
			
			try
			{
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				}
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey1);
				}
				
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}

			System.out.println("Query ---------> " + query);
			Sequence sq = new Sequence();
			try
			{
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
				{
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getLabCode());
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getTestCode());
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getPatType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());

				} 
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
				{
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getLabCode());
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getConfigArea());
				populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getPatType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());

				} 
				
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("DailyPatientDAO.populateMAP::" + e);
			}
			 
			List<NEWOfflineResultEntryVO> listNEWOfflineResultEntryVO = new ArrayList<NEWOfflineResultEntryVO>();
			ValueObject[] valueObjects = null;
			
			try
			{
				 
				rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException("No Patient Record");
				}
				else
				{
					rs.beforeFirst();
					valueObjects = HelperMethods.populateVOfrmRS(NEWOfflineResultEntryVO.class, rs);
					//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
				//	for (int i = 0; i < valueObjects.length; i++)
				//	{
						//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
						listNEWOfflineResultEntryVO.add((NEWOfflineResultEntryVO)valueObjects[0]);
					//}
				}
			}
			catch (Exception e)
			{
				if (e.getClass() == HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException(e.getMessage());	
				}
				else return listNEWOfflineResultEntryVO;
			}
			return listNEWOfflineResultEntryVO;
		}	
		public String generateSampleNoDateSequence(String subLength,UserVO userVO)
		{
			String sequence_Hash_yyymmdd=""; 
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey="SELECT.SAMPLEACC.LABNODATEGEN.FROM.DUAL";
			Sequence sq = new Sequence();
			Connection conn=super.getTransactionContext().getConnection();
			try
			{
				query = HelperMethodsDAO.getQuery(filename,queryKey);
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			try
			{
				 
				populateMap.put(sq.next(), subLength);
				
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("BloodBankEssentialDAO.populateMAP::" + e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
				
				if (!rs.next())
				{
					throw new HisRecordNotFoundException("");
				}
				else
				{
					sequence_Hash_yyymmdd=rs.getString(1);
					
				}
				
				
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException(e.getMessage());	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }
			return sequence_Hash_yyymmdd;
		}
				  
 
		public void updateSampleCollInhivtsamplenoconfmst1(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
		{
			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="UPDATE.SAMPLECOllDETAIL.HIVT_SAMPLENO_CONF_MS";
			String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.HIVT_COLAREA_SAMNO_CONFIG_MST";
			
			try
			{
				if(voSamColl.getTempSampleNo().equals("1"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				}
				if(voSamColl.getTempSampleNo().equals("2"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey1);
				}
			}
			catch (Exception e) 
			{
				throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                                WHERE hivnum_packing_list_no=?
                     **/
				if(voSamColl.getTempSampleNo().equals("1"))
				{
					populateMAP.put(sq.next(),finalDate);
					populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
					
				populateMAP.put(sq.next(),voSamColl.getConfigLab());
				populateMAP.put(sq.next(),voSamColl.getConfigTest());
				populateMAP.put(sq.next(),voSamColl.getConfigType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());
				populateMAP.put(sq.next(),voSamColl.getConfigSeq());


				}
				
				if(voSamColl.getTempSampleNo().equals("2"))
				{
				populateMAP.put(sq.next(),finalDate);
				populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
				populateMAP.put(sq.next(),voSamColl.getConfigLab());
				populateMAP.put(sq.next(),voSamColl.getConfigArea());
				populateMAP.put(sq.next(),voSamColl.getConfigType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());
				populateMAP.put(sq.next(),voSamColl.getConfigSeq());


				}
				
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
			}
			try
			{
				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
			}
		}


		
		
		public void updateSampleCollInhivtsamplenoconfmst1ResetLabNO(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
		{
			String query = "";
			Map populateMAP = new HashMap();
			Sequence sq = new Sequence();
			String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey ="UPDATE.SAMPLECOllDETAIL.RESET.RUNNING.NO.HIVT_SAMPLENO_CONF_MS";
			String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.RESET.RUNNING.NO.HIVT_COLAREA_SAMNO_CONFIG_MST";
			
			try
			{
				if(voSamColl.getTempSampleNo().equals("1"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				}
				if(voSamColl.getTempSampleNo().equals("2"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey1);
				}
			}
			catch (Exception e) 
			{
				throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}
			try
			{
				/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                                WHERE hivnum_packing_list_no=?
                     **/
				if(voSamColl.getTempSampleNo().equals("1"))
				{
					 
				populateMAP.put(sq.next(),voSamColl.getConfigLab());
				populateMAP.put(sq.next(),voSamColl.getConfigTest());
				populateMAP.put(sq.next(),voSamColl.getConfigType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());
				populateMAP.put(sq.next(),voSamColl.getConfigSeq());


				}
				
				if(voSamColl.getTempSampleNo().equals("2"))
				{
				 
				populateMAP.put(sq.next(),voSamColl.getConfigLab());
				populateMAP.put(sq.next(),voSamColl.getConfigArea());
				populateMAP.put(sq.next(),voSamColl.getConfigType());
				populateMAP.put(sq.next(),_UserVO.getHospitalCode());
				populateMAP.put(sq.next(),voSamColl.getConfigSeq());


				}
				
			}
			catch (Exception e)
			{
				throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
			}
			try
			{
				HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
			}
		}

		public String checkAutoGenFormateRunningLabNo(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO)
		{
			String query="";
			Map populateMap= new HashMap();
			ResultSet rs=null;
			String Formate="";
			String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
			String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_SAMPLENO_CONF_MST1";
			String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_COLAREA_SAMNO_CONFIG_MST";
			   
			Connection conn=super.getTransactionContext().getConnection();
			try
			{
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey);
				}
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
				{
				
				query = HelperMethodsDAO.getQuery(filename, queryKey1);
				}
				
			}
			catch (Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
			}

			System.out.println("Query ---------> " + query);
			Sequence sq = new Sequence();
			try
			{
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
				{
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigTest());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
					populateMap.put(sq.next(),_UserVO.getHospitalCode());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


				} 
				if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
				{
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigArea());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
					populateMap.put(sq.next(),_UserVO.getHospitalCode());
					populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


				} 
				
			}
			catch(Exception e)
			{
				throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
			}
			try
			{
				rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
				if (!rs.next())
				{
					//throw new HisRecordNotFoundException();
				}
				else
				{
					rs.beforeFirst();
					if(rs.next())
					{
						Formate=rs.getString(1);
 					}
				}
			}
			catch(Exception e)
			{
				if(e.getClass()==HisRecordNotFoundException.class)
				{
					throw new HisRecordNotFoundException();	
				}
				else			 		
				 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
			 }	
			return Formate;
		}
		
		




public  List<NEWOfflineResultEntryVO> getBilledPatListForRaisingCumCollection(LabTestVO voLabTest,String reqType,UserVO _UserVO)
{
	String query = "";		
	Map populateMAP = new HashMap();
	ResultSet rs = null;
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.BILLING_DETAILS.BILL_FUNCTION";
	Sequence sq = new Sequence();
	
	NEWOfflineResultEntryVO voSampleCollection=null;

	List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
	
	
					
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	populateMAP.put(sq.next(), voLabTest.getTestGroupType());
	populateMAP.put(sq.next(), voLabTest.getTestCode());
	populateMAP.put(sq.next(), voLabTest.getTestCode());
	populateMAP.put(sq.next(), voLabTest.getLabCode());
	populateMAP.put(sq.next(), voLabTest.getTestGroupCode());
	populateMAP.put(sq.next(), voLabTest.getLabCode());
	populateMAP.put(sq.next(), voLabTest.getTestGroupCode());
	populateMAP.put(sq.next(), voLabTest.getTestCode());
	populateMAP.put(sq.next(), reqType);
	populateMAP.put(sq.next(), voLabTest.getTestGroupType());
	populateMAP.put(sq.next(), voLabTest.getReqNo());
	
	
/*	populateMAP.put(sq.next(), reqType);
	populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
	populateMAP.put(sq.next(), reqNo);
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	populateMAP.put(sq.next(), reqdno);*/
	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
				populateMAP);
		rs.beforeFirst();
		
		 if (!rs.next())
            {
                throw new HisRecordNotFoundException("No Patient List  Found");
            }
            else
            {
                rs.beforeFirst();
                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
                while (rs.next()) {
                	voSampleCollection=new NEWOfflineResultEntryVO();
                	HelperMethods.populateVOfrmRS(voSampleCollection, rs);
                	 lstInvSampleCollectionVO.add(voSampleCollection);
                }
            }
	}
	catch (HisRecordNotFoundException e)
	{

		throw new HisRecordNotFoundException(e.getMessage());
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("" + e);
	}
	return lstInvSampleCollectionVO;

}

public void insertSampleDtlRaisingCumCollection(LabTestVO voSample, UserVO userVO)
{
	String sampleNo=""; 
	String errorMsg="";
	ResultSet rs=null;
	try
	{
		Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_INSERT_SAMPLE_DTL);
		strProc.addInParameter(1,Types.VARCHAR,InvestigationConfig.SAMPLE_COLLECTION_MODE);
		strProc.addInParameter(2,Types.VARCHAR,voSample.getSampleNo());
		strProc.addInParameter(3,Types.VARCHAR,userVO.getHospitalCode());
		strProc.addInParameter(4,Types.VARCHAR,voSample.getReqDno());
		strProc.addInParameter(5,Types.VARCHAR,null);
		strProc.addInParameter(6,Types.VARCHAR,voSample.getSampleAreaCode());
		strProc.addInParameter(7,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(8,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(9,Types.VARCHAR,null);
		strProc.addInParameter(10,Types.VARCHAR,null);
		strProc.addInParameter(11,Types.VARCHAR,null);
		strProc.addInParameter(12,Types.VARCHAR,voSample.getPrintStatus());  
		strProc.addInParameter(13,Types.VARCHAR,voSample.getContainerVolume());
		strProc.addInParameter(14,Types.VARCHAR,voSample.getSampleCode());
		strProc.addInParameter(15,Types.VARCHAR,voSample.getUomCode());
		strProc.addInParameter(16,Types.VARCHAR,voSample.getContainerCode());
		strProc.addInParameter(17,Types.VARCHAR,voSample.getTempSampleNo());
		strProc.addInParameter(18,Types.VARCHAR,null);
		strProc.addInParameter(19,Types.VARCHAR,voSample.getTypeOfComponent());
		strProc.addInParameter(20,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(21,Types.VARCHAR,InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
		strProc.addInParameter(22,Types.VARCHAR,(voSample.getTempSampleNo()==null?"0":voSample.getTempSampleNo()));
		strProc.addInOutParameter(23,Types.VARCHAR ,"");
		strProc.execute(super.getTransactionContext().getConnection());
		
	}
	catch (HisRecordNotFoundException e)
	{
		throw new HisRecordNotFoundException("No Record Found");
	}
	
}



public List<LabTestVO> checkAutoGenFormateRaisingCumCollection(LabTestVO voSample,UserVO _UserVO)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	List<String> Formate=new ArrayList<String>();
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_SAMPLENO_CONF_MST1";
	String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_COLAREA_SAMNO_CONFIG_MST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		if(voSample.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSample.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(voSample.getTempSampleNo().equals("1"))
		{
			populateMap.put(sq.next(),voSample.getLabCode());
			populateMap.put(sq.next(),voSample.getTestCode());
			populateMap.put(sq.next(),voSample.getPatType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
		} 
		if(voSample.getTempSampleNo().equals("2"))
		{
			populateMap.put(sq.next(),voSample.getLabCode());
			populateMap.put(sq.next(),voSample.getSampleAreaCode());
			populateMap.put(sq.next(),voSample.getPatType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());

		} 
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	List<LabTestVO> listLabTestVO = new ArrayList<LabTestVO>();
	ValueObject[] valueObjects = null;
	
	try
	{
		 
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException("No Patient Record");
		}
		else
		{
			rs.beforeFirst();
			valueObjects = HelperMethods.populateVOfrmRS(LabTestVO.class, rs);
			//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
		//	for (int i = 0; i < valueObjects.length; i++)
		//	{
				//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
			listLabTestVO.add((LabTestVO)valueObjects[0]);
			//}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return listLabTestVO;
}


public void updateSampleCollInhivtsamplenoconfmst1ResetLabNORaisingCumCollection(LabTestVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query = "";
	Map populateMAP = new HashMap();
	Sequence sq = new Sequence();
	String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey ="UPDATE.SAMPLECOllDETAIL.RESET.RUNNING.NO.HIVT_SAMPLENO_CONF_MS";
	String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.RESET.RUNNING.NO.HIVT_COLAREA_SAMNO_CONFIG_MST";
	
	try
	{
		if(voSamColl.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
	}
	catch (Exception e) 
	{
		throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                        WHERE hivnum_packing_list_no=?
             **/
		if(voSamColl.getTempSampleNo().equals("1"))
		{
			 
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		 
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
	}
	try
	{
		HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
	}
}


public void updateSampleCollInhivtsamplenoconfmst1RaisingCumCollection(LabTestVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query = "";
	Map populateMAP = new HashMap();
	Sequence sq = new Sequence();
	String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey ="UPDATE.SAMPLECOllDETAIL.HIVT_SAMPLENO_CONF_MS";
	String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.HIVT_COLAREA_SAMNO_CONFIG_MST";
	
	try
	{
		if(voSamColl.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
	}
	catch (Exception e) 
	{
		throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                        WHERE hivnum_packing_list_no=?
             **/
		if(voSamColl.getTempSampleNo().equals("1"))
		{
			populateMAP.put(sq.next(),finalDate);
			populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
			
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		populateMAP.put(sq.next(),finalDate);
		populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
 		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
	}
	try
	{
		HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
	}
}


public String checkAutoGenFormateRunningLabNoRaisingCumCollection(LabTestVO NEWOfflineResultEntryVO, UserVO _UserVO)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_SAMPLENO_CONF_MST1";
	String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_COLAREA_SAMNO_CONFIG_MST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigTest());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


		} 
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigArea());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


		} 
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}



public void updateRequisitionDtlRaiseCumColl(LabTestVO voSample,UserVO userVO)
{
	String sampleNo=""; 
	String errorMsg="";
	ResultSet rs=null;
	try
	{
		Procedure strProc=new Procedure(InvestigationConfig.PROCEDURE_INSERT_REQUSITION_DTL);
		strProc.addInParameter(1,Types.VARCHAR,InvestigationConfig.SAMPLE_COLLECTION_MODE);
		strProc.addInParameter(2,Types.VARCHAR,userVO.getHospitalCode());
		strProc.addInParameter(3,Types.VARCHAR,voSample.getRequisitionDNo());
		strProc.addInParameter(4,Types.VARCHAR,null);
		strProc.addInParameter(5,Types.VARCHAR,null);
		strProc.addInParameter(6,Types.VARCHAR,null);
		strProc.addInParameter(7,Types.VARCHAR,null);
		strProc.addInParameter(8,Types.VARCHAR,null);
		strProc.addInParameter(9,Types.VARCHAR,null);
		strProc.addInParameter(10,Types.VARCHAR,"3");
		strProc.addInParameter(11,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(12,Types.VARCHAR,null);
		strProc.addInParameter(13,Types.VARCHAR,voSample.getTempSampleNo());
		strProc.addInParameter(14,Types.VARCHAR,null);
		strProc.addInParameter(15,Types.VARCHAR,null);
		strProc.addInParameter(16,Types.VARCHAR,null);
		strProc.addInParameter(17,Types.VARCHAR,"0");//bill no
		strProc.addInParameter(18,Types.VARCHAR,null);
		strProc.addInParameter(19,Types.VARCHAR,null);
		strProc.addInParameter(20,Types.VARCHAR,null);
		strProc.addInParameter(21,Types.VARCHAR,null);
		strProc.addInParameter(22,Types.VARCHAR,null);
		strProc.addInParameter(23,Types.VARCHAR,null);
		strProc.addInParameter(24,Types.VARCHAR,null);
		strProc.addInParameter(25,Types.VARCHAR,null);
		strProc.addInParameter(26,Types.VARCHAR,null);
		strProc.addInParameter(27,Types.VARCHAR,null);
		strProc.addInParameter(28,Types.VARCHAR,null);
		strProc.addInParameter(29,Types.VARCHAR,null);
		strProc.addInParameter(30,Types.VARCHAR,null);
		strProc.addInParameter(31,Types.VARCHAR,null);
		strProc.addInParameter(32,Types.VARCHAR,null);
		strProc.addInParameter(33,Types.VARCHAR,InvestigationConfig.SAMPLE_ACCEPTED);
		strProc.addInParameter(34,Types.VARCHAR,null);
		strProc.addInParameter(35,Types.VARCHAR,null);
		strProc.addInParameter(36,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(37,Types.VARCHAR,userVO.getSeatId());
		strProc.addInParameter(38,Types.VARCHAR,voSample.getSampleAreaCode());
		strProc.addInParameter(39,Types.VARCHAR,null);
		strProc.addInParameter(40,Types.VARCHAR,null);
		strProc.addInParameter(41,Types.VARCHAR,InvestigationConfig.SAMPLE_RECEIVED);
		strProc.addInParameter(42,Types.VARCHAR,voSample.getSampleNo());
		strProc.addInParameter(43,Types.VARCHAR,voSample.getUomCode());
		strProc.addInParameter(44,Types.VARCHAR,voSample.getSampleQnty());
		strProc.addInParameter(45,Types.VARCHAR,voSample.getContainerCode());
		strProc.addInParameter(46,Types.VARCHAR,null);
		strProc.addInParameter(47,Types.VARCHAR,null);
		strProc.addInOutParameter(48,Types.VARCHAR ,"");
		strProc.addInParameter(49,Types.VARCHAR ,null);
		strProc.execute(super.getTransactionContext().getConnection());
		

	}
	catch (HisRecordNotFoundException e)
	{
		throw new HisRecordNotFoundException("No Record Found");
	}
	
}



public  List<NEWOfflineResultEntryVO> getPatListBarcode(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO _UserVO)
{
	String query = "";		
	Map populateMAP = new HashMap();
	ResultSet rs = null;
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_PATIENT_LIST.HIVT_REQUISITION_HEADER_BARCODE";
	Sequence sq = new Sequence();
	
	String condition1=" and HRGNUM_PUK= "+objSampleCollectionVO.getPatCRNo();
	 String condition2=" AND (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))  AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY'))) ";
		String condition3="and  (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getFromDate()+"\','DD-Mon-YYYY'))) AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getToDate()+"\','DD-Mon-YYYY'))) ";
		String condition4="and  EXISTS ( SELECT 1 FROM HIVT_COLLECTION_AREA_MST z WHERE z.gnum_area_code ="+objSampleCollectionVO.getSampleAreaCode()+"  and z.hipnum_ward_code=A.hipnum_wardcode and z.gnum_hospital_code=a.gnum_hospital_code and gnum_isvalid=1)";

		
		List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
		List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO1 =null;

	//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	//populateMAP.put(sq.next(),_UserVO.getSeatId());
	//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
String iswardforccolection=iswardforcollectionarea(objSampleCollectionVO.getSampleAreaCode(),_UserVO.getHospitalCode());

String wardtype=iswardforccolection.split("#")[0];
String wardcode="";
if(wardtype.equals("2"))
{
	wardcode=iswardforccolection.split("#")[1];
	
}

	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	//put(sq.next(), objSampleCollectionVO.getFromDate());
	//populateMAP.put(sq.next(), objSampleCollectionVO.getToDate());
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	//populateMAP.put(sq.next(), objSampleCollectionVO.getSampleAreaCode());
	populateMAP.put(sq.next(), InvestigationConfig.MODULE_ID_INVESTIGATION);
	populateMAP.put(sq.next(), _UserVO.getUserSeatId());
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_PACKING_LIST);
	populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_ACCEPTANCE);
	populateMAP.put(sq.next(), "6");
	populateMAP.put(sq.next(), "17");

	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		if(objSampleCollectionVO.getPatCRNo()!=null&&!objSampleCollectionVO.getPatCRNo().equals(""))
		{
			/*PRASHANT SMC deisabled in case of cr no. input given from to date is not need*/
			//query+=condition3+condition1+"";
			query+=condition1+"";
		}
		else if(objSampleCollectionVO.getFromDate()!=null&&!objSampleCollectionVO.getFromDate().equals("")&&objSampleCollectionVO.getToDate()!=null&&!objSampleCollectionVO.getToDate().equals(""))
		{
			query+=condition3;
		}
		else
		{
			 query+=condition2;
		}
		
		if(wardtype.equals("2"))
		{
			
			query+=condition4;
		}
		
		query+="order by gnum_test_code,hgnum_group_code,hivdt_entry_date desc";
		
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
				populateMAP);
		rs.beforeFirst();
		
		 if (!rs.next())
            {
                throw new HisRecordNotFoundException("No Patient List  Found");
            }
            else
            {
                rs.beforeFirst();
                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
                NEWOfflineResultEntryVO InvSampleCollectionVO=null;
                while (rs.next()) {
                	InvSampleCollectionVO=new NEWOfflineResultEntryVO();
                    HelperMethods.populateVOfrmRS(InvSampleCollectionVO, rs);
                    lstInvSampleCollectionVO.add(InvSampleCollectionVO);
                }
            }
	}
	catch (HisRecordNotFoundException e)
	{

		throw new HisRecordNotFoundException(e.getMessage());
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("" + e);
	}
	
	Map<String,NEWOfflineResultEntryVO> mpp=new LinkedHashMap<String,NEWOfflineResultEntryVO>();
	
	List<LabTestVO> sugartest=gettestforsugar();
	List<LabTestVO> machinetest=gettestformachine();

	
	
	
	if(lstInvSampleCollectionVO!=null && lstInvSampleCollectionVO.size()>0)
	{
		lstInvSampleCollectionVO1=new ArrayList<NEWOfflineResultEntryVO>();
		String key="";
		
		
		for(int k=0;k<lstInvSampleCollectionVO.size();k++)
		{
			NEWOfflineResultEntryVO voo=lstInvSampleCollectionVO.get(k);
		
			String newkey=voo.getRequisitionNo()+"#"+voo.getTempSampleNo();
			boolean flg=false;
			
			if(sugartest!=null && sugartest.size()>0)
			{
				for(int k1=0;k1<sugartest.size();k1++)
				{
					LabTestVO vo=sugartest.get(k1);
					
					if(vo.getTestCode().equals(voo.getTestCode()))
					{
						newkey=voo.getRequisitionNo()+"#"+voo.getTempSampleNo()+vo.getSugartestcode();
						voo.setSugarTestCode(vo.getSugartestcode());
						mpp.put(newkey, voo);
						flg=true;
					}
				}
				
			}
			
			

			  if(machinetest!=null && machinetest.size()>0)
			  { 
				  for(int k1=0;k1<machinetest.size();k1++)
				  {
					  LabTestVO vo=machinetest.get(k1);
			  
			  if(vo.getTestCode().equals(voo.getTestCode()))
			  {
				  
			  newkey=voo.getRequisitionNo()+"#"+voo.getTempSampleNo()+"#"+vo.
			  getSugartestcode(); voo.setSugarTestCode(vo.getSugartestcode());
			  mpp.put(newkey, voo); flg=true; } }
			  
			  }
			  
			
		
			//bhubneswer start
//			boolean fl=false;
//			if(machinetest!=null && machinetest.size()>0)
//			{
//				for(int k1=0;k1<machinetest.size();k1++)
//				{
//					LabTestVO vo=machinetest.get(k1);
//					
//					newkey=voo.getRequisitionNo()+"#"+voo.getTempSampleNo();
//					
//					if(mpp.containsKey(newkey))
//					{
//						NEWOfflineResultEntryVO voadd=(NEWOfflineResultEntryVO)mpp.get(newkey);
//						String machie_symnbol="";
//						
//						if(vo.getTestCode().equals(voo.getTestCode()))
//						{
//						if(voadd.getSugarTestCode()!=null && !voadd.getSugarTestCode().equals(""))
//						{
//							machie_symnbol=voadd.getSugarTestCode() ;
//						
//						      if(!machie_symnbol.contains(vo.getSugartestcode()))
//						    voo.setSugarTestCode(machie_symnbol+","+vo.getSugartestcode());
//						      else		
//						    	  voo.setSugarTestCode(machie_symnbol); 
//						
//						      mpp.put(newkey, voo);
//						
//						}
//						else
//						{
//							  voo.setSugarTestCode(vo.getSugartestcode()); 
//								
//						      mpp.put(newkey, voo);
//						}
//						
//						}
//						flg=true;
//						//break;
//					}
//					else
//					{
//						if(vo.getTestCode().equals(voo.getTestCode()))
//						{
//						if(vo.getSugartestcode()!=null && !vo.getSugartestcode().equals(""))
//                        voo.setSugarTestCode(vo.getSugartestcode());
//						}
//						
//						mpp.put(newkey, voo);
//						flg=true;
//						//break;
//					}
//					
//					
//					
//				}
//				
//			}
			//bhubneswer end
			
			if(flg==false)
			{
				newkey=voo.getRequisitionNo()+"#"+voo.getTempSampleNo()+"#"+"";
			
				mpp.put(newkey, voo);
			}
			
			/*if(key.equals(voo.getRequisitionNo()+"#"+voo.getTempSampleNo()))
			{
			
			}
			else
			{
				 key=voo.getRequisitionNo()+"#"+voo.getTempSampleNo();	
				 lstInvSampleCollectionVO1.add(voo);
			}*/
			
		}
		
	}

	
	  if(mpp!=null && mpp.size()>0)
	  {
		  Iterator itr=mpp.keySet().iterator();
		  
		  while(itr.hasNext())//for(int i=0;i<size;i++)
			{
			  
				String keys=(String)itr.next();
				NEWOfflineResultEntryVO voo=mpp.get(keys);
				lstInvSampleCollectionVO1.add(voo);
			}
		  
	  }
	  
	  
	  
	 
	  
	  
	  
	
	return lstInvSampleCollectionVO1;

}




public List getmachineCombo(UserVO _UserVO)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	List containerCombo=new ArrayList();
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey="SELECT.MACHINE_COMBO.HMIT_MACHINE_MST";
	
	Sequence sq= new Sequence();
	Connection conn=super.getTransactionContext().getConnection();
	
	populateMap.put(sq.next(), _UserVO.getHospitalCode());
	try
	{
		query = HelperMethodsDAO.getQuery(filename,queryKey);
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			containerCombo=HelperMethodsDAO.getAlOfEntryObjects(rs);
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return containerCombo;
}



public String iswardforcollectionarea(String collareacode,String hospitalcode)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.WARDCODE.HIVT_COLLECTION_AREA_MST";
	///String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_COLAREA_SAMNO_CONFIG_MST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		
			populateMap.put(sq.next(),collareacode);
			populateMap.put(sq.next(),hospitalcode);
		

	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}




public   String getcollectionareafromward(String wardcode,String hospitalcode)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.COLLECTIONAREACODE.HIVT_COLLECTION_AREA_MST";
	///String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_COLAREA_SAMNO_CONFIG_MST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		
			populateMap.put(sq.next(),hospitalcode);
			populateMap.put(sq.next(),wardcode);
		

	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}


///added by krishnan nema on 25042019
public  List<NEWOfflineResultEntryVO> getPatListSampleColAdvance(NEWOfflineResultEntryVO objSampleCollectionVO,UserVO _UserVO)
{
	String query = "";		
	Map populateMAP = new HashMap();
	ResultSet rs = null;
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_PATIENT_LIST.HIVT_REQUISITION_HEADER";
	String queryKeyIPDWARD = "SELECT.SAMPLE_PATIENT_LIST.HIVT_REQUISITION_HEADER_IPD_WARD";
	Sequence sq = new Sequence();
	
	String iswardforccolection="";
	String wardcode="";
	String wardtype="";
	
	if(objSampleCollectionVO.getWardCode()==null)
	{
	 iswardforccolection=iswardforcollectionarea(objSampleCollectionVO.getSampleAreaCode(),_UserVO.getHospitalCode());
	
	 if(iswardforccolection!=null && !iswardforccolection.equals(""))
	{
    
     wardtype=iswardforccolection.split("#")[0];
     
	
	if(wardtype.equals("2"))
	{
		wardcode=iswardforccolection.split("#")[1];
		
	}
	}
	
	}
	Date dateInstance = new Date();
	Calendar cal = Calendar.getInstance();
	cal.setTime(dateInstance);
	cal.add(Calendar.DATE, -7);
	Date date = cal.getTime();
	String dateBefore7Days = WebUTIL.getCustomisedSysDate(date, "dd-MMM-yyyy");
	//System.out.println("dateBefore7Days : "+dateBefore7Days);

	String condition1=" and HRGNUM_PUK= "+objSampleCollectionVO.getPatCRNo();
	//String condition2=" AND (TRUNC(hivdt_entry_date) >= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))  AND (TRUNC(hivdt_entry_date) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))";
//	String condition2=" AND (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(\'"+dateBefore7Days+"\','DD-Mon-YYYY')))  AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))";
	String condition2=" AND (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))  AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(SYSDATE,'DD-Mon-YYYY')))";
		String condition3="and  (TRUNC(HIVDT_REQUISITION_DATE) >= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getFromDate()+"\','DD-Mon-YYYY'))) AND (TRUNC(HIVDT_REQUISITION_DATE) <= TRUNC(TO_DATE(\'"+objSampleCollectionVO.getToDate()+"\','DD-Mon-YYYY')))";
		String condition4="and  EXISTS ( SELECT 1 FROM HIVT_COLLECTION_AREA_MST z WHERE z.gnum_area_code ="+objSampleCollectionVO.getSampleAreaCode()+"  and z.hipnum_ward_code=A.hipnum_wardcode and z.gnum_hospital_code=a.gnum_hospital_code and gnum_isvalid=1)";
String orderBy=" order by gnum_test_code,hgnum_group_code,hivdt_entry_date desc";
		List<NEWOfflineResultEntryVO> lstInvSampleCollectionVO =null;
	//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	//populateMAP.put(sq.next(),_UserVO.getSeatId());
	//populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	//put(sq.next(), objSampleCollectionVO.getFromDate());
	//populateMAP.put(sq.next(), objSampleCollectionVO.getToDate());
	if(objSampleCollectionVO.getWardCode()==null)
	{
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	
	populateMAP.put(sq.next(), objSampleCollectionVO.getSampleAreaCode());
	}
	populateMAP.put(sq.next(), InvestigationConfig.MODULE_ID_INVESTIGATION);
	populateMAP.put(sq.next(), _UserVO.getUserSeatId());
	populateMAP.put(sq.next(), _UserVO.getHospitalCode());
	populateMAP.put(sq.next(), InvestigationConfig.REQUISITION_DTL_STATUS_SAMPLE_BASED);
	/*populateMAP.put(sq.next(), InvestigationConfig.REQUISTION_DTL_UPDATE_RESCHEDULED_STATUS);*/
	try
	{
		
		if(objSampleCollectionVO.getWardCode()==null )
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		else
			query = HelperMethodsDAO.getQuery(filename, queryKeyIPDWARD);		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		if(objSampleCollectionVO.getPatCRNo()!=null&&!objSampleCollectionVO.getPatCRNo().equals(""))
		{
			//if(objSampleCollectionVO.getFromDate()!=null)
			//query+=condition3;
			
			query+=condition1;
		}
		else if(objSampleCollectionVO.getFromDate()!=null&&!objSampleCollectionVO.getFromDate().equals("")&&objSampleCollectionVO.getToDate()!=null&&!objSampleCollectionVO.getToDate().equals(""))
		{
			query+=condition3;
		}
		else
		{
			 query+=condition2;
		}
		
		if(wardtype.equals("2") )
		{
			
			query+=condition4;
		}
		
		if(objSampleCollectionVO.getWardCode()!=null)
		{
			
			query+=" and a.HIPNUM_WARDCODE="+objSampleCollectionVO.getWardCode()+" ";

		}
		/*
		if(objSampleCollectionVO.getWardCode()!=null && !objSampleCollectionVO.getWardCode().equals(""))
		{
			
			query+=condition4;
		}*/
		query+=orderBy;
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query,
				populateMAP);
		rs.beforeFirst();
		
		 if (!rs.next())
            {
                throw new HisRecordNotFoundException("No Patient List  Found");
            }
            else
            {
                rs.beforeFirst();
                lstInvSampleCollectionVO=new ArrayList<NEWOfflineResultEntryVO>();
                NEWOfflineResultEntryVO InvSampleCollectionVO=null;
                while (rs.next()) {
                	InvSampleCollectionVO=new NEWOfflineResultEntryVO();
                    HelperMethods.populateVOfrmRS(InvSampleCollectionVO, rs);
                    //added by krishnan nema on 26-02-2019
                    int billStatus = 0; //1 for not billed, 2 for partially billed, 3 for fully billed
                    if(InvSampleCollectionVO.getIsBilled().contains("##")){
                    	int billedTestCount = 0;
                		int unbilledTestCount = 0;
                    	String billArray[] = InvSampleCollectionVO.getIsBilled().split("##");
                    	for(int p = 0; p<billArray.length; p++){
                    		String billNo = billArray[p].replace("^", "#").split("#")[0];
                    		if(billNo!=null && !billNo.equals("0")){
                    			billedTestCount++;
                    		}else{
                    			unbilledTestCount++;
                    		}
                    	}
                    	
                    	if(billedTestCount == billArray.length){
                    		billStatus = 3;
                    	}
                    	if(billedTestCount > 0 && billedTestCount < billArray.length){
                    		billStatus = 2;
                    	}
                    	if(unbilledTestCount == billArray.length){
                    		billStatus = 1;
                    	}
                    }else{
                    	String billNo = InvSampleCollectionVO.getIsBilled().replace("^", "#").split("#")[0];
                    	if(billNo!=null && !billNo.equals("0")){
                    		billStatus = 3;
                    	}else{
                    		billStatus = 1;
                    	}
                    }
                    	
                    if(billStatus == 1){
                    	InvSampleCollectionVO.setBillDtl("Not Billed");
                    }else if(billStatus == 2){
                    	InvSampleCollectionVO.setBillDtl("Patially Billed");
                    }else if(billStatus == 3){
                    	InvSampleCollectionVO.setBillDtl("Billed");
                    }
                    
                    
                    lstInvSampleCollectionVO.add(InvSampleCollectionVO);
                }
            }
	}
	catch (HisRecordNotFoundException e)
	{

		throw new HisRecordNotFoundException(e.getMessage());
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("" + e);
	}
	return lstInvSampleCollectionVO;

}




public List<LabTestVO> gettestforsugar()
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	List<String> Formate=new ArrayList<String>();
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SUGAR_TEST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	List<LabTestVO> listLabTestVO = new ArrayList<LabTestVO>();
	ValueObject[] valueObjects = null;
	
	try
	{
		 
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException("No Patient Record");
		}
		else
		{
			rs.beforeFirst();
			valueObjects = HelperMethods.populateVOfrmRS(LabTestVO.class, rs);
			//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
			for (int i = 0; i < valueObjects.length; i++)
			{
				//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
				
			listLabTestVO.add((LabTestVO)valueObjects[i]);
			}
			
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return listLabTestVO;
}



public List<LabTestVO> gettestformachine()
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	List<String> Formate=new ArrayList<String>();
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.MACHINE_TEST";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	List<LabTestVO> listLabTestVO = new ArrayList<LabTestVO>();
	ValueObject[] valueObjects = null;
	
	try
	{
		 
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException("No Patient Record");
		}
		else
		{
			rs.beforeFirst();
			valueObjects = HelperMethods.populateVOfrmRS(LabTestVO.class, rs);
			//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
			for (int i = 0; i < valueObjects.length; i++)
			{
				//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
				
			listLabTestVO.add((LabTestVO)valueObjects[i]);
			}
			
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return listLabTestVO;
}





public List<NEWOfflineResultEntryVO> getSampleCollAutoSampleNOConfigtestwise(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO)
{
	ResultSet rs = null;
	String query = "";
	Map populateMAP = new HashMap();
	String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_SAMPLENO_CONF_MST1_TESTWISE";
	String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_COLAREA_SAMNO_CONFIG_MST_TESTWISE";
	   
	if (NEWOfflineResultEntryVO.getPatType()==null)
		NEWOfflineResultEntryVO.setPatType("1");
	else if(NEWOfflineResultEntryVO.getPatType().equals("3") || NEWOfflineResultEntryVO.getPatType().equals("4"))
		NEWOfflineResultEntryVO.setPatType("1");
	else
		;
	
	
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getLabCode());
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getTestCode());
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getPatType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());

		} 
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getLabCode());
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getConfigArea());
		populateMAP.put(sq.next(),NEWOfflineResultEntryVO.getPatType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());

		} 
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("DailyPatientDAO.populateMAP::" + e);
	}
	 
	List<NEWOfflineResultEntryVO> listNEWOfflineResultEntryVO = new ArrayList<NEWOfflineResultEntryVO>();
	ValueObject[] valueObjects = null;
	
	try
	{
		 
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMAP);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException("No Patient Record");
		}
		else
		{
			rs.beforeFirst();
			valueObjects = HelperMethods.populateVOfrmRS(NEWOfflineResultEntryVO.class, rs);
			//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
		//	for (int i = 0; i < valueObjects.length; i++)
		//	{
				//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
				listNEWOfflineResultEntryVO.add((NEWOfflineResultEntryVO)valueObjects[0]);
			//}
		}
	}
	catch (Exception e)
	{
		if (e.getClass() == HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException(e.getMessage());	
		}
		else return listNEWOfflineResultEntryVO;
	}
	return listNEWOfflineResultEntryVO;
}	




public String getsamplebarcodeconfig(UserVO userVO)
{
	String config="0"; 
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey="SELECT.ISSAMPLEBARCODE.DUPLICATE.PRINT.HIVT_REPORT_DB_MST";
	Sequence sq = new Sequence();
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		query = HelperMethodsDAO.getQuery(filename,queryKey);
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		 
		populateMap.put(sq.next(), userVO.getHospitalCode());
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("BloodBankEssentialDAO.populateMAP::" + e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		
		if (!rs.next())
		{
			throw new HisRecordNotFoundException("");
		}
		else
		{
			config=rs.getString(1);
		
			if(config==null || config.equals(""))
			{
				config="0";
			}
			
		}
		
		
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException(e.getMessage());	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }
	return config;
}





public List<NEWOfflineResultEntryVO> checkAutoGenFormateDATEWISE(NEWOfflineResultEntryVO voSample,UserVO _UserVO) // first time null ajax issue added by chandan on 22oct2019
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	List<String> Formate=new ArrayList<String>();
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_SAMPLENO_CONF_MST1_DATEWISE";
	String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.HIVT_COLAREA_SAMNO_CONFIG_MST_DATEWISE";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		if(voSample.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSample.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(voSample.getTempSampleNo().equals("1"))
		{
			populateMap.put(sq.next(),voSample.getLabCode());
			populateMap.put(sq.next(),voSample.getTestCode());
			populateMap.put(sq.next(),voSample.getPatType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
		} 
		if(voSample.getTempSampleNo().equals("2"))
		{
			populateMap.put(sq.next(),voSample.getLabCode());
			populateMap.put(sq.next(),voSample.getSampleAreaCode());
			populateMap.put(sq.next(),voSample.getPatType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());

		} 
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	List<NEWOfflineResultEntryVO> listLabTestVO = new ArrayList<NEWOfflineResultEntryVO>();
	ValueObject[] valueObjects = null;
	
	try
	{
		 
		rs = HelperMethodsDAO.executeQuery(super.getTransactionContext().getConnection(), query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException("No Patient Record");
		}
		else
		{
			rs.beforeFirst();
			valueObjects = HelperMethods.populateVOfrmRS(NEWOfflineResultEntryVO.class, rs);
			//dailyPatientVOs = new PatientDetailVO[valueObjects.length];
		//	for (int i = 0; i < valueObjects.length; i++)
		//	{
				//dailyPatientVOs[i] = (PatientDetailVO) valueObjects[i];
			listLabTestVO.add((NEWOfflineResultEntryVO)valueObjects[0]);
			//}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return listLabTestVO;
}


public String isAutoGenFormateRunningLabNofree(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO)
{
	String query="";
	Map populateMap= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_SAMPLENO_CONF_MST1_ISSYNC";
	String queryKey1 = "SELECT.SAMPLE_COLL_DETAIL_AUTOGEN_SAMPLENO.AJAX.CHECK.HIVT_COLAREA_SAMNO_CONFIG_MST_ISYSNC";
	   
	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigTest());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


		} 
		if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigLab());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigArea());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigType());
			populateMap.put(sq.next(),_UserVO.getHospitalCode());
			populateMap.put(sq.next(),NEWOfflineResultEntryVO.getConfigSeq());


		} 
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMap);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}



public String pkgcheckAutoGenFormateRunningLabNo(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO) {
    String reqNo = "";
    String errorMsg = "";
    ResultSet rs = null;
    
    try {
      Procedure strProc = null;
     
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
      strProc = new Procedure("pkg_inv_unique_sample_no_generation.generate_sampleno_conf_mst");
	
      strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
      strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigTest());
      strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
      strProc.addInParameter(4,12,_UserVO.getHospitalCode());
      strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
      strProc.setReturnType(12);
      
		}
      
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
    	  
    	  strProc = new Procedure("pkg_inv_unique_sample_no_generation.generate_sampleno_coll_area_mst");
    		
          strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
          strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigArea());
          strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
          strProc.addInParameter(4,12,_UserVO.getHospitalCode());
          strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
          strProc.setReturnType(12);
          
		}
      //strProc.addInParameter(1, 12, userVO.getHospitalCode());
      //strProc.addInParameter(2, 12, labCode);
      //strProc.setReturnType(12);
     
    
	
      
      return reqNo = (String)strProc.execute(getTransactionContext().getConnection());
    
    }
    catch (HisRecordNotFoundException e) {
      
      throw new HisRecordNotFoundException("No Record Found");
    } 
  }




public void updateSampleCollInhivtsamplenoconfmst1_issync(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query = "";
	Map populateMAP = new HashMap();
	Sequence sq = new Sequence();
	String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey ="UPDATE.SAMPLECOllDETAIL.HIVT_SAMPLENO_CONF_MS_ISYSYNC";
	String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.HIVT_COLAREA_SAMNO_CONFIG_MST_ISYSYNC";
	
	try
	{
		if(voSamColl.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
	}
	catch (Exception e) 
	{
		throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                        WHERE hivnum_packing_list_no=?
             **/
		if(voSamColl.getTempSampleNo().equals("1"))
		{
			populateMAP.put(sq.next(),finalDate);
			populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
			
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		populateMAP.put(sq.next(),finalDate);
		populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
	}
	try
	{
		HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
	}
}



public String pkgcheckAutoGenFormateRunningLabNo_testwise(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO) {
    String reqNo = "";
    String errorMsg = "";
    ResultSet rs = null;
    
    try {
      Procedure strProc = null;
     
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
      strProc = new Procedure("pkg_inv_unique_sample_no_generation.generate_sampleno_conf_mst_testwise");
	
      strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
      strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigTest());
      strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
      strProc.addInParameter(4,12,_UserVO.getHospitalCode());
      strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
      strProc.setReturnType(12);
      
		}
      
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
    	  
    	  strProc = new Procedure("pkg_inv_unique_sample_no_generation.generate_sampleno_coll_area_mst_testwise");
    		
          strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
          strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigArea());
          strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
          strProc.addInParameter(4,12,_UserVO.getHospitalCode());
          strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
          strProc.setReturnType(12);
          
		}
      //strProc.addInParameter(1, 12, userVO.getHospitalCode());
      //strProc.addInParameter(2, 12, labCode);
      //strProc.setReturnType(12);
     
    
	
      
      return reqNo = (String)strProc.execute(getTransactionContext().getConnection());
    
    }
    catch (HisRecordNotFoundException e) {
      
      throw new HisRecordNotFoundException("No Record Found");
    } 
  }




public  String checkAutoGenFormateRunningLabNo_isysnc(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO) {
    String reqNo = "";
    String errorMsg = "";
    ResultSet rs = null;
    
    try {
      Procedure strProc = null;
     
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
      strProc = new Procedure("pkg_inv_unique_sample_no_generation.check_samplno_conf_mst_issync");
	
      strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
      strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigTest());
      strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
      strProc.addInParameter(4,12,_UserVO.getHospitalCode());
      strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
      strProc.setReturnType(12);
      
		}
      
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
    	  
    	  strProc = new Procedure("pkg_inv_unique_sample_no_generation.check_samplno_collarea_mst_issync");
    		
          strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
          strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigArea());
          strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
          strProc.addInParameter(4,12,_UserVO.getHospitalCode());
          strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
          strProc.setReturnType(12);
          
		}
      //strProc.addInParameter(1, 12, userVO.getHospitalCode());
      //strProc.addInParameter(2, 12, labCode);
      //strProc.setReturnType(12);
     
    
	
      
      return reqNo = (String)strProc.execute(getTransactionContext().getConnection());
    
    }
    catch (HisRecordNotFoundException e) {
      
      throw new HisRecordNotFoundException("No Record Found");
    } 
  }




public void updateSampleCollInhivtsamplenoconfmst1_issyncforsamesampleno(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query = "";
	Map populateMAP = new HashMap();
	Sequence sq = new Sequence();
	String filename = "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey ="UPDATE.SAMPLECOllDETAIL.HIVT_SAMPLENO_CONF_MS_ISYSYNC_SAMESAMPLENO";
	String queryKey1 ="UPDATE.SAMPLECOLLDETAIL.HIVT_COLAREA_SAMNO_CONFIG_MST_ISYSYNC_SAMESAMPLENO";
	
	try
	{
		if(voSamColl.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
	}
	catch (Exception e) 
	{
		throw new HisApplicationExecutionException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	try
	{
		/**hivbl_list_status=?, updateSampleCollInhivtsamplenoconfmst1ResetLabNO
                        WHERE hivnum_packing_list_no=?
             **/
		if(voSamColl.getTempSampleNo().equals("1"))
		{
			
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		//populateMAP.put(sq.next(),finalDate);
		//populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
	}
	catch (Exception e)
	{
		throw new HisApplicationExecutionException("CellGroupingValidationDAO.populateMAP::" + e);
	}
	try
	{
		HelperMethodsDAO.excecuteUpdate(super.getTransactionContext().getConnection(), query, populateMAP);
	}
	catch (Exception e)
	{
		System.out.println(e.getMessage());
		throw new HisDataAccessException("HelperMethodsDAO.getResultset" + e);
	}
}




public  String checkAutoGenFormateRunningLabNo_New(NEWOfflineResultEntryVO NEWOfflineResultEntryVO, UserVO _UserVO) {
    String reqNo = "";
    String errorMsg = "";
    ResultSet rs = null;
    
    try {
      Procedure strProc = null;
     
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("1"))
		{
      strProc = new Procedure("pkg_inv_unique_sample_no_generation.getsamplenocongif");
	
      strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
      strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigTest());
      strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
      strProc.addInParameter(4,12,_UserVO.getHospitalCode());
      strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
      strProc.setReturnType(12);
      
		}
      
      if(NEWOfflineResultEntryVO.getTempSampleNo().equals("2"))
		{
    	  
    	  strProc = new Procedure("pkg_inv_unique_sample_no_generation.getsamplenocongif");
    		
          strProc.addInParameter(1,12,NEWOfflineResultEntryVO.getConfigLab());
          strProc.addInParameter(2,12,NEWOfflineResultEntryVO.getConfigArea());
          strProc.addInParameter(3,12,NEWOfflineResultEntryVO.getConfigType());
          strProc.addInParameter(4,12,_UserVO.getHospitalCode());
          strProc.addInParameter(5,12,NEWOfflineResultEntryVO.getConfigSeq());
          strProc.setReturnType(12);
          
		}
      //strProc.addInParameter(1, 12, userVO.getHospitalCode());
      //strProc.addInParameter(2, 12, labCode);
      //strProc.setReturnType(12);
     
    
	
      
      return reqNo = (String)strProc.execute(getTransactionContext().getConnection());
    
    }
    catch (HisRecordNotFoundException e) {
      
      throw new HisRecordNotFoundException("No Record Found");
    } 
  }



public String getlabcongiNewSampleGene(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query="";
	Map populateMAP= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.LABWISE.FORMAT.SAMPLENOGEN";
	String queryKey1 = "SELECT.LABWISE.FORMAT.SAMPLENOGEN_COLLAREA";

	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
		if(voSamColl.getTempSampleNo().equals("1"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
		if(voSamColl.getTempSampleNo().equals("1"))
		{
			//populateMAP.put(sq.next(),finalDate);
		//	populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
			
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		//populateMAP.put(sq.next(),finalDate);
	//	populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMAP);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}





public String getTestcongiNewSampleGene(NEWOfflineResultEntryVO voSamColl,String finalDate, UserVO _UserVO)
{
	String query="";
	Map populateMAP= new HashMap();
	ResultSet rs=null;
	String Formate="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.TESTWISE.FORMAT.SAMPLENOGEN";
	//String queryKey1 = "SELECT.TESTWISE.FORMAT.SAMPLENOGEN";

	Connection conn=super.getTransactionContext().getConnection();
	try
	{
		
			/*
			 * if(voSamColl.getTempSampleNo().equals("1")) {
			 */
		
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		/*}
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		
		query = HelperMethodsDAO.getQuery(filename, queryKey1);
		}*/
		
		
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}

	System.out.println("Query ---------> " + query);
	Sequence sq = new Sequence();
	try
	{
			/*
			 * if(voSamColl.getTempSampleNo().equals("1")) {
			 */
		//	populateMAP.put(sq.next(),finalDate);
		//	populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
			
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigTest());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		/*}
		
		if(voSamColl.getTempSampleNo().equals("2"))
		{
		populateMAP.put(sq.next(),finalDate);
		populateMAP.put(sq.next(),voSamColl.getTemparorySampleNO());
		populateMAP.put(sq.next(),voSamColl.getConfigLab());
		populateMAP.put(sq.next(),voSamColl.getConfigArea());
		populateMAP.put(sq.next(),voSamColl.getConfigType());
		populateMAP.put(sq.next(),_UserVO.getHospitalCode());
		populateMAP.put(sq.next(),voSamColl.getConfigSeq());


		}*/
		
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	try
	{
		rs = HelperMethodsDAO.executeQuery(conn, query, populateMAP);
		if (!rs.next())
		{
			//throw new HisRecordNotFoundException();
		}
		else
		{
			rs.beforeFirst();
			if(rs.next())
			{
				Formate=rs.getString(1);
				}
		}
	}
	catch(Exception e)
	{
		if(e.getClass()==HisRecordNotFoundException.class)
		{
			throw new HisRecordNotFoundException();	
		}
		else			 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }	
	return Formate;
}



public NEWOfflineResultEntryVO AjaxBilledUnbilledDetails(NEWOfflineResultEntryVO vo, UserVO userVO) {
	
	
	String filename=InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_TRACKING_REPORTSDAO;
	String queryKey1="SELECT_INV_BILLED_UNBILLED_DTL_BASED_ON_CRNO";
			
	String query1="";


	ResultSet rs=null;
	Connection conn=super.getTransactionContext().getConnection();
	
	Map populateMap = new HashMap();
	Sequence sq = new Sequence();
	NEWOfflineResultEntryVO vo2 = new NEWOfflineResultEntryVO();
	String wardcode="";
	try
	{
	
			query1 = HelperMethodsDAO.getQuery(filename, queryKey1);

			
			
			
			String iswardforccolection="";
			String wardtype="";
			
			if(vo.getSampleAreaCode()!=null)
			{
			 iswardforccolection=iswardforcollectionarea(vo.getSampleAreaCode(),userVO.getHospitalCode());
			
			 if(iswardforccolection!=null && !iswardforccolection.equals(""))
			{
		    
		     wardtype=iswardforccolection.split("#")[0];
		     
			
			if(wardtype.equals("2"))
			{
				wardcode=iswardforccolection.split("#")[1];
				
			}
			}
			
			}


String condition4="";

			if(wardcode.equals(""))
			{

condition4="AND GNUM_LAB_CODE IN ( SELECT GNUM_LAB_CODE FROM HIVT_LAB_COLLECTION_AREA_MST WHERE GNUM_ISVALID = 1 AND gnum_hospital_Code  = "+userVO.getHospitalCode()+" AND GNUM_AREA_CODE = "+vo.getSampleAreaCode()+" ) order by hgnum_group_code,hivt_entry_date desc";	
			}
			else
			{

	condition4="and  EXISTS ( SELECT 1 FROM HIVT_COLLECTION_AREA_MST z WHERE z.gnum_area_code ="+vo.getSampleAreaCode()+"  and z.hipnum_ward_code=a.hipnum_wardcode_reqd and z.gnum_hospital_code="+userVO.getHospitalCode()+" and gnum_isvalid=1) order by hgnum_group_code,hivt_entry_date desc";

			}
			
			query1=query1+condition4;
			
	
	
	} 

	catch (Exception e) {
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	
	try
	{	
		
		




		
			populateMap.put(sq.next(), vo.getCrNo());

		rs = HelperMethodsDAO.executeQuery(conn, query1, populateMap);
		
		if(!rs.next()) { }
		else {
			rs.beforeFirst();
			while(rs.next()) {
				HelperMethods.populateVOfrmRS(vo2, rs);
			}
		}
		
		
	}
	
	catch (Exception e)
	{		 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	}
	return vo2;
}



//
//public List<NEWOfflineResultEntryVO> getSampleCollectionArea(UserVO _UserVO) {
//	// TODO Auto-generated method stub
//	return null;
//}


public void insertAlreadyRegPat(NEWOfflineResultEntryVO vo) {
	
	HisDAO daoObj = null;
	String strProcName = "";
	int nProcIndex = 0;
	try {
		
		daoObj = new HisDAO("Investigation","NEWOfflineResultEntryDAO");
		
		String strDate = new SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
		String strFileName = vo.getPatCRNo()+ strDate+ ".pdf";
		vo.setStrPatFileName(strFileName);
		System.out.println("nandini1");
		//Save Patient's Details
		strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
		nProcIndex = daoObj.setProcedure(strProcName);
		daoObj.setProcInValue(nProcIndex, "hmode", "2",1);
		daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrPatHospCode(),2); //Hospital Code of the hospital from where the request is sent.
		daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
		daoObj.setProcInValue(nProcIndex, "patageunit", "-",4); 
		daoObj.setProcInValue(nProcIndex, "patname", "-",5);
		daoObj.setProcInValue(nProcIndex, "patgendercode", "0",6);
		daoObj.setProcInValue(nProcIndex, "patage", "-",7);
		daoObj.setProcInValue(nProcIndex, "pataddress", "-",8);
		daoObj.setProcInValue(nProcIndex, "patmobileno", "0",9);
		daoObj.setProcInValue(nProcIndex, "patguardianname", "-",10);
		daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),11);
		daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),12);
		daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),13);
		daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),14);
		daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),15);
		daoObj.setProcOutValue(nProcIndex, "err",1,16);
		
		daoObj.execute(nProcIndex , 1);
		
		//Save Tests' Details

		 for (int i=0; i<vo.getStrHiddenValue().length;i++)
			{
				if(!vo.getStrHiddenValue()[i].equals("0"))
				{
				    String codes[] = vo.getStrHiddenValue()[i].replace("^", "#").split("#");

				    String labCode = codes[0];
				    String testCode = codes[1];
				    String parameterCode = codes[2];
				    
					strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_result_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?)}";
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
					daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrPatHospCode(),2); //Hospital Code of the hospital from where the request is sent.
					daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
					daoObj.setProcInValue(nProcIndex, "labcode", labCode,4);      
					daoObj.setProcInValue(nProcIndex, "testcode", testCode,5);
					daoObj.setProcInValue(nProcIndex, "parametercode", parameterCode,6);
					daoObj.setProcInValue(nProcIndex, "testcodeval", vo.getStrTestResult()[i],7); 
					daoObj.setProcInValue(nProcIndex, "refrange", vo.getStrRefRangeVal()[i],8);
					daoObj.setProcInValue(nProcIndex, "patmobileno", "",9);  // Not required as its already saved.
					daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),10);
					daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),11);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),12);
					daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),13);
					daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),14);
					daoObj.setProcOutValue(nProcIndex, "err",1,15);
					
					daoObj.execute(nProcIndex, 1);
				}
			}
		 synchronized (daoObj) {
			 daoObj.fire();
			
		}
		
	}catch(Exception e) {
		
		e.printStackTrace();
		vo.setStrMsgString("NEWOfflineResultEntryDAO.insertAlreadyRegPat() --> "+ e.getMessage());
		 vo.setStrMsgType("1");
	}
	finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}



public void getOffllineResultEntryPatientCount(NEWOfflineResultEntryVO vo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?, ?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","NEWOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "5",1);
		
		if(vo.getPatCRNo()==""|| vo.getPatCRNo()==null || vo.getPatCRNo().equalsIgnoreCase("") )
			daoObj.setProcInValue(nProcIndex, "p_crno", "0",2);
		else
			daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
		
		if(vo.getPatMobNo()==""|| vo.getPatMobNo()==null || vo.getPatMobNo().equalsIgnoreCase("") )
			 daoObj.setProcInValue(nProcIndex, "p_mobno", "0",3);
		else
			daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
		
		daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),4);
		
		if(vo.getStrPatHospCode()==""|| vo.getStrPatHospCode()==null || vo.getStrPatHospCode().equalsIgnoreCase("") )
			 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
		else
			daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrPatHospCode(),5);
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,6);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null || strErr.equals(""))
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
		if (strErr.equals("")) 
			vo.setPatientListWS(ws);
		else {
			throw new Exception(strErr);
		}
		
		if(ws.size()>0) {
			
			
		}
		else {
			vo.setStrMsgType("2");
			vo.setStrMsgString("No Record Found !");
		}
				
	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("NEWOfflineResultEntryDAO.getOffllineResultEntryPatientDataForView() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}

}



//
//public static String insertImageData(String ImageData, String DeptValue)
//			throws JSONException {
//		
//		String err = "";
//		String query = "{call PKG_WEBSERVICES.insert_image_data_ftp(?,?,?,?  ,?,?,?,? , ?,?,?,? ,?,?,?,?,?)}";
////		int procIndex1 = 0;
////		HisDAO dao = null;
//		
//		ResultSet ws=null;
//		Connection con=null;
//		CallableStatement stmt=null;
//		
//		JSONObject mainObj = new JSONObject();
//		try {
//
//			String temp = DeptValue.replaceAll("\\^", "#");
//			String val[] = temp.split("#");
//
//			// save prescription to ftp
//			String path = FTPUtility.writeBase64ToFTP(val[0], val[5], val[1],
//					val[3], val[11], ImageData);
//			
//			
//			if (path.equalsIgnoreCase("No Path Found")) {
//				return mainObj.put("status", "0").toString();
//			} else {
////				dao = new HisDAO("WebServices",
////						"walletWebserviceDao.getwalletDataSummary()");
////				procIndex1 = dao.setProcedure(proc_name1);
////				dao.setProcInValue(procIndex1, "modeval", "1", 1);
////				dao.setProcInValue(procIndex1, "crno", val[0], 2);
////				dao.setProcInValue(procIndex1, "episodecode", val[1], 3);
////				dao.setProcInValue(procIndex1, "visitno", val[3], 4);
////				dao.setProcInValue(procIndex1, "deptcode", val[2], 5);
////				dao.setProcInValue(procIndex1, "deptunitcode", val[4], 6);
////				dao.setProcInValue(procIndex1, "hsop_code", val[5], 7);
////				dao.setProcInValue(procIndex1, "pat_name", val[9], 8);
////				dao.setProcInValue(procIndex1, "dept_name", val[7], 9);
////				dao.setProcInValue(procIndex1, "dept_unit_name", val[6], 10);
////				dao.setProcInValue(procIndex1, "pat_address", val[8], 11);
////				
////				// 343058
////				dao.setProcInValue(procIndex1, "episode_date", val[10], 12);
////
////				dao.setProcInValue(procIndex1, "page_count", val[11], 13);
////
////				dao.setProcInValue(procIndex1, "imagedata", path, 14);
////				
////				dao.setProcInValue(procIndex1, "bytearray", ImageData, 15);
////				dao.setProcOutValue(procIndex1, "err", 1, 16);
////				// dao.setProcOutValue(procIndex1, "resultset", 2,5);
////				dao.executeProcedureByPosition(procIndex1);
////				err = dao.getString(procIndex1, "err");
//
//				
//				
//				
//			//	con = GlobalUtils.getNimsConnection();
////				System.out.println(con);
//				con.setAutoCommit(false);
//				 stmt = con.prepareCall(query);
////				System.out.println(stmt);
//
//				stmt.setString(1, "1");
//				stmt.setString(2,  val[0]);
//				stmt.setString(3,  val[1]);
//				stmt.setString(4,  val[3]);
//				
//				stmt.setString(5,val[2]);
//				stmt.setString(6,  val[4]);
//				stmt.setString(7,  val[5]);
//				
//				
//				stmt.setString(8,val[9]);
//				stmt.setString(9,  val[7]);
//				stmt.setString(10,  val[6]);
//				
//				stmt.setString(11, val[8]);
//				stmt.setString(12,  val[10]);
//				stmt.setString(13,  val[11]);
//				
//				stmt.setString(14, path);
//				stmt.setString(15, ImageData);
//				stmt.setString(16, val[12]);
//				System.out.println("0 : "+val[0]);
//				System.out.println("1 : "+val[1]);
//				System.out.println("2 : "+val[2]);
//				System.out.println("3 : "+val[3]);
//				System.out.println(" 4: "+val[4]);
//				System.out.println(" 5: "+val[5]);
//				System.out.println(" 6: "+val[6]);
//				System.out.println(" 7: "+val[7]);
//				System.out.println(" 8: "+val[8]);
//				System.out.println("9 : "+val[9]);
//				System.out.println("10 : "+val[10]);
//				System.out.println("11 : "+val[11]);
//				System.out.println("12 : "+val[12]);
//		
//				System.out.println("path : "+path);
//				//System.out.println("ImageData : "+ImageData);
//				
//				
//				stmt.registerOutParameter(17, java.sql.Types.VARCHAR);
//					
//				System.out.println("result status "+stmt.executeUpdate());
//				con.commit();
//				System.out.println("DATA INSERTED SUCCESSFULLY ");
//
//				return mainObj.put("status", "1").toString();
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			return mainObj.put("status", "0").toString();
//		} finally {
//			if (stmt != null) {
//				try {
//					stmt.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	


}


