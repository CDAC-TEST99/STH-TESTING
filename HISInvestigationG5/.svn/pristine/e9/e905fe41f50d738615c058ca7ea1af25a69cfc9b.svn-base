package new_investigation.transactions.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sql.rowset.WebRowSet;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.vo.UserVO;
import new_investigation.InvestigationConfig;
import new_investigation.vo.InvOfflineResultEntryVO;

public class InvOfflineResultEntryDAO {	
	
public void getOfflineTestDetail(InvOfflineResultEntryVO vo,UserVO _UserVO) {
		
		WebRowSet webRs = null;
		HisDAO daoObj = null;
		String strProcName = "{call pkg_inv_view.proc_offline_result_entry(?,?,?,?,?,?)}";
		int nProcIndex = 0;
		String strErr = "";
		try 
		{
			daoObj = new HisDAO("Registration","EssentialDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", _UserVO.getHospitalCode(),2);
			daoObj.setProcInValue(nProcIndex, "p_module_id", InvestigationConfig.MODULE_ID_INVESTIGATION,3);
			daoObj.setProcInValue(nProcIndex, "p_seat_id", _UserVO.getUserSeatId(),4);
			daoObj.setProcOutValue(nProcIndex, "err", 1,5);
			daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
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

//Added By Deepti to Insert the offline result Entry records. 18.01.2021
public void insertOffllineResultEntry(InvOfflineResultEntryVO vo) {
	
	HisDAO daoObj = null;
	String strProcName = "";
	int nProcIndex = 0;
	
	String strCrNo=new String();
	int funcIndex=0;
	
	try {
			//Generate CR Number.
			
			daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
			funcIndex = daoObj.setFunction("{? = call pkg_inv_fun.fun_gen_result_seq_no(?)}");
			
			daoObj.setFuncInValue(funcIndex, 2, vo.getStrPatHospCode());
			daoObj.setFuncOutValue(funcIndex,1);
			
			daoObj.executeFuncForNumeric(funcIndex);
			strCrNo = daoObj.getFuncNumeric(funcIndex);
			
			vo.setPatCRNo(strCrNo);
			
			String strDate = new SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
			String strFileName = vo.getPatCRNo()+ strDate+ ".pdf";
			vo.setStrPatFileName(strFileName);
			
			//Save Patient's Details
			
			//daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
			strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)}";
			nProcIndex = daoObj.setProcedure(strProcName);
			daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
			daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrPatHospCode(),2); //Hospital Code of the hospital from where the request is sent.
			daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
			daoObj.setProcInValue(nProcIndex, "patageunit", vo.getStrPatAgeUnit(),4); 
			daoObj.setProcInValue(nProcIndex, "patname", vo.getPatName(),5);
			daoObj.setProcInValue(nProcIndex, "patgendercode", vo.getPatGenderCode(),6);
			daoObj.setProcInValue(nProcIndex, "patage", vo.getStrPatAge(),7);
			daoObj.setProcInValue(nProcIndex, "pataddress", vo.getPatAdd(),8);
			daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
			daoObj.setProcInValue(nProcIndex, "patguardianname", vo.getPatGuardianName(),10);
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
				    
					strProcName="{call pkg_inv_dml.proc_hivt_offline_patient_result_dtl(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,?)}"; 
					nProcIndex = daoObj.setProcedure(strProcName);
					daoObj.setProcInValue(nProcIndex, "hmode", "1",1);
					daoObj.setProcInValue(nProcIndex, "hcode", vo.getStrPatHospCode(),2); //Hospital Code of the hospital from where the req is sent.
					daoObj.setProcInValue(nProcIndex, "crno", vo.getPatCRNo(),3);
					daoObj.setProcInValue(nProcIndex, "labcode", labCode,4);      
					daoObj.setProcInValue(nProcIndex, "testcode", testCode,5);
					daoObj.setProcInValue(nProcIndex, "parametercode", parameterCode,6);
					daoObj.setProcInValue(nProcIndex, "testcodeval", vo.getStrTestResult()[i],7); 
					daoObj.setProcInValue(nProcIndex, "refrange", vo.getStrRefRangeVal()[i],8);
					daoObj.setProcInValue(nProcIndex, "patmobileno", vo.getPatMobileNo(),9);
					daoObj.setProcInValue(nProcIndex, "requisitiondate", vo.getSamplecoldate(),10);
					daoObj.setProcInValue(nProcIndex, "resultdate", vo.getResultDate(),11);
					daoObj.setProcInValue(nProcIndex, "seatid", vo.getSeatId(),12);
					daoObj.setProcInValue(nProcIndex, "pat_file_name", vo.getStrPatFileName(),13);
					daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),14);
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
	catch (Exception e)
	{
		 e.printStackTrace();
		 vo.setStrMsgString("InvOfflineResultEntryDAO.insertOffllineResultEntry() --> "+ e.getMessage());
		 vo.setStrMsgType("1");
	}
	finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

//Added by Deepti to get the list of Hospitals from the hierarchy 18.01.2021
public void getHospitalList(InvOfflineResultEntryVO invresultentryvo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry(?,?,?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getHospitalList()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
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
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			invresultentryvo.setStrHospitalListWS(ws);
		else 
			throw new Exception(strErr);
	} catch (Exception e) {
		invresultentryvo.setStrMsgString("InvOfflineResultEntryDAO.getHospitalList() --> "+ e.getMessage());
		invresultentryvo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

/* public void getHospitalList_viewPage(OfflineResultEntryVO invresultentryvo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry(?,?,?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getHospitalList_viewPage()");
	try
	{
		
		
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "3",1);
		daoObj.setProcInValue(nProcIndex, "p_hosp_code", invresultentryvo.getHospitalcode(),2);
		daoObj.setProcInValue(nProcIndex, "p_module_id", "",3);
		daoObj.setProcInValue(nProcIndex, "p_seat_id", "",4);
		daoObj.setProcOutValue(nProcIndex, "err", 1,5);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			invresultentryvo.setStrHospitalListWS(ws);
		else 
			throw new Exception(strErr);
		
	} catch (Exception e) {
		invresultentryvo.setStrMsgString("InvOfflineResultEntryDAO.getHospitalList_viewPage() --> "+ e.getMessage());
		invresultentryvo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}  */


public void getOffllineResultEntryPatientData(InvOfflineResultEntryVO vo) {
	
	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?,?, ?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
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
		
		if(vo.getStrPatHospCode()==""|| vo.getStrPatHospCode()==null || vo.getStrPatHospCode().equalsIgnoreCase("") )
			 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
		else
			daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrPatHospCode(),5);
		
		
		if(vo.getRequisitionNo()==""|| vo.getRequisitionNo()==null || vo.getRequisitionNo().equalsIgnoreCase(""))
			daoObj.setProcInValue(nProcIndex, "p_requisitionNo", "0",6);
		else
			daoObj.setProcInValue(nProcIndex, "p_requisitionNo", vo.getRequisitionNo(),6);
		
		System.out.println("nandini >>>"+vo.getRequisitionNo());
		
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
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientData() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
}

public void getOffllineResultEntryPatientTestData(InvOfflineResultEntryVO vo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?,?, ?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
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
		
		if(vo.getStrPatHospCode()==""|| vo.getStrPatHospCode()==null || vo.getStrPatHospCode().equalsIgnoreCase("") )
			 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
		else
			daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrPatHospCode(),5);
		
		if(vo.getRequisitionNo()==""|| vo.getRequisitionNo()==null || vo.getRequisitionNo().equalsIgnoreCase(""))
			daoObj.setProcInValue(nProcIndex, "p_requisitionNo", "0",6);
		else
			daoObj.setProcInValue(nProcIndex, "p_requisitionNo", vo.getRequisitionNo(),6);
		System.out.println("nandini >>>"+vo.getRequisitionNo());
	
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,7);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,8);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			vo.setStrPatientTestListWS(ws);
		else 
			throw new Exception(strErr);
	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientTestData() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
 }

public void viewResultEntriesList(InvOfflineResultEntryVO vo) {
	
	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_view_list(?,?,?, ?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.viewResultEntriesList()");
	try
	{   System.out.println("viewResultEntriesList");
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
		daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getHospitalcode(),2);
		
		if (vo.getStrFromDate().equalsIgnoreCase(""))
		{
			daoObj.setProcInValue(nProcIndex, "from_date", "",3);
			daoObj.setProcInValue(nProcIndex, "to_date", "",4);
		}
		else
		{
			daoObj.setProcInValue(nProcIndex, "from_date", vo.getStrFromDate(),3);
			daoObj.setProcInValue(nProcIndex, "to_date", vo.getStrToDate(),4);
		}
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,5);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,6);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			vo.setStrResultEntryListWS(ws);
		else 
			throw new Exception(strErr);
		
	} catch (Exception e) {
		vo.setStrMsgString("InvOfflineResultEntryDAO.viewResultEntriesList() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
}

//Function Added By Deepti to get the Result Entry List for viewing/Printing at SDHs etc.  

public void viewResultEntriesListForReportView(InvOfflineResultEntryVO vo) {
	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_view_list(?,?,?, ?,?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.viewResultEntriesList()");
	try
	{ 
		System.out.println("viewResultEntriesListForReportView");
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "2",1);
		daoObj.setProcInValue(nProcIndex, "hosp_code", vo.getHospitalcode(),2);
		daoObj.setProcInValue(nProcIndex, "pat_crno", vo.getPatCRNo(),3);
		System.out.println("vo.getPatCRNo()>>"+vo.getPatCRNo());
		
		if (vo.getStrFromDate().equalsIgnoreCase(""))
		{
			daoObj.setProcInValue(nProcIndex, "from_date", "",4);
			daoObj.setProcInValue(nProcIndex, "to_date", "",5);
		}
		else
		{
			daoObj.setProcInValue(nProcIndex, "from_date", vo.getStrFromDate(),4);
			daoObj.setProcInValue(nProcIndex, "to_date", vo.getStrToDate(),5);
		}
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,6);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,7);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null)
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			vo.setStrResultEntryListWS(ws);
		else 
			throw new Exception(strErr);
		
	} catch (Exception e) {
		vo.setStrMsgString("InvOfflineResultEntryDAO.viewResultEntriesListForReportView() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

//Added By Deepti to Insert the offline result Entry records for Already Registered Patients. 01.02.2021
public void insertAlreadyRegPat(InvOfflineResultEntryVO vo) {
	
	HisDAO daoObj = null;
	String strProcName = "";
	int nProcIndex = 0;
	try {
		
		daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
		
		String strDate = new SimpleDateFormat("dd-MMM-yyyyHH-mm-SS").format(new Date());
		String strFileName = vo.getPatCRNo()+ strDate+ ".pdf";
		vo.setStrPatFileName(strFileName);
		
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
		vo.setStrMsgString("InvOfflineResultEntryDAO.insertAlreadyRegPat() --> "+ e.getMessage());
		 vo.setStrMsgType("1");
	}
	finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

public static String getFTPDtl() {
	
	String strProcName = "{? = call pkg_inv_fun.fun_get_config_dtl(?,?)}";
	int nProcIndex = 0;
	String val = "";

	HisDAO daoObj = null;
	
	try 
	{
		daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
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
		daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
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

public static String getUserSignFileName(InvOfflineResultEntryVO vo) {
	
	String strProcName = "{? = call pkg_inv_fun.fun_get_user_sign_file(?,?)}";
	int nProcIndex = 0;
	String val = "";

	HisDAO daoObj = null;
	
	try 
	{
		daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
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

public void getOffllineResultEntryPatientDataForView(InvOfflineResultEntryVO vo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?, ?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "3",1);
		
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
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientDataForView() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
	
}

public void getOffllineResultEntryPatientTestDataForView(InvOfflineResultEntryVO vo) {
	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data(?,?,?, ?,?,?, ?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "4",1);
		
		if(vo.getPatCRNo()==""|| vo.getPatCRNo()==null || vo.getPatCRNo().equalsIgnoreCase(""))
			daoObj.setProcInValue(nProcIndex, "p_crno", "0",2);
		else
			daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
		
		if(vo.getPatMobNo()==""|| vo.getPatMobNo()==null || vo.getPatMobNo().equalsIgnoreCase(""))
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
		if (strErr == null)
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");

		if (strErr.equals("")) 
			vo.setStrPatientTestListWS(ws);
		else 
			throw new Exception(strErr);
	} catch (Exception e) {
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientTestDataForView() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

public static String isDuplicacyReqd(InvOfflineResultEntryVO vo) {
	String strProcName = "{? = call pkg_inv_fun.fun_get_config_dtl(?,?)}";
	int nProcIndex = 0;
	String val = "";
	HisDAO daoObj = null;
	
	try 
	{
		daoObj = new HisDAO("Investigation","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setFunction(strProcName);
		
		daoObj.setFuncInValue(nProcIndex, 2, "IsDuplicacyChecked");
		daoObj.setFuncInValue(nProcIndex, 3, vo.getStrPatHospCode());
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

public void getDuplicatePatientDtl(InvOfflineResultEntryVO vo) {
	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_duplicate_patient_data(?,?,?, ?,?,?, ?,?,?, ?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getDuplicatePatientDtl()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "1",1);
		daoObj.setProcInValue(nProcIndex, "p_patname", vo.getPatName(),2);
		daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
		daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrParentHospitalCode(),4);
		daoObj.setProcInValue(nProcIndex, "p_gendercode", vo.getPatGenderCode(),5);
		daoObj.setProcInValue(nProcIndex, "p_age", vo.getStrPatAge(),6);
		daoObj.setProcInValue(nProcIndex, "p_ageunit", vo.getStrPatAgeUnit(),7);
		daoObj.setProcInValue(nProcIndex, "p_father_spouse", vo.getPatGuardianName(),8);
		daoObj.setProcInValue(nProcIndex, "p_cr_no", "",9);
		daoObj.setProcInValue(nProcIndex, "p_parent_hosp_code", "",10);
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,11);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,12);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null || strErr.equals(""))
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
		if (strErr.equals("")) 
			vo.setDupPatListWS(ws);
		else {
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("InvOfflineResultEntryDAO.getDuplicatePatientDtl() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
}

public void getOffllineResultEntryPatientCount(InvOfflineResultEntryVO vo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_print_data1(?,?,?, ?,?,?, ?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryData()");
	try
	{
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "5",1);
		
		if(vo.getPatCRNo()==""|| vo.getPatCRNo()==null || vo.getPatCRNo().equalsIgnoreCase("") ) 
			daoObj.setProcInValue(nProcIndex, "p_crno", "0",2);
		else {
			System.out.println("Prashant_else cr ++++++"+vo.getPatCRNo());
			daoObj.setProcInValue(nProcIndex, "p_crno", vo.getPatCRNo(),2);
		}
		if(vo.getPatMobNo()==""|| vo.getPatMobNo()==null || vo.getPatMobNo().equalsIgnoreCase("") ) 
			
			 daoObj.setProcInValue(nProcIndex, "p_mobno", "0",3);
		else {
			System.out.println("Prashant_else mob++++++"+vo.getPatMobNo());
			daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
		}
		daoObj.setProcInValue(nProcIndex, "parent_hosp_code", vo.getStrParentHospitalCode(),4);
		
		if(vo.getStrPatHospCode()==""|| vo.getStrPatHospCode()==null || vo.getStrPatHospCode().equalsIgnoreCase("") )
			 daoObj.setProcInValue(nProcIndex, "p_hospcode", "0",5);
		else
			daoObj.setProcInValue(nProcIndex, "p_hospcode", vo.getStrPatHospCode(),5);
		daoObj.setProcInValue(nProcIndex, "p_requisitionno","0",6);
		daoObj.setProcOutValue(nProcIndex, "err", 1,7);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,8);
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
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientDataForView() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}

}

public void getOffllineResultEntryPatientDataForViewPg(InvOfflineResultEntryVO vo) {

	HisDAO daoObj = null;
	WebRowSet ws = null;
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_duplicate_patient_data(?,?,?, ?,?,?, ?,?,?, ?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryPatientDataForViewPg()");
	try
	{
		System.out.println("getOffllineResultEntryPatientDataForViewPg");
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "2",1);
		daoObj.setProcInValue(nProcIndex, "p_patname", vo.getPatName(),2);
		daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
		daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrPatHospCode(),4);
		daoObj.setProcInValue(nProcIndex, "p_gendercode", vo.getPatGenderCode(),5);
		daoObj.setProcInValue(nProcIndex, "p_age", vo.getStrPatAge(),6);
		daoObj.setProcInValue(nProcIndex, "p_ageunit", vo.getStrPatAgeUnit(),7);
		daoObj.setProcInValue(nProcIndex, "p_father_spouse", vo.getPatGuardianName(),8);
		daoObj.setProcInValue(nProcIndex, "p_cr_no", vo.getPatCRNo(),9);
		daoObj.setProcInValue(nProcIndex, "p_parent_hosp_code", vo.getStrParentHospitalCode(),10);
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,11);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,12);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null || strErr.equals(""))
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
		if (strErr.equals("")) 
			vo.setStrPatientDtlWS(ws); 
		else {
			vo.setStrPatientTestListWS(null);
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientDataForViewPg() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}

}

public void getOffllineResultEntryPatientTestDataForViewPg(InvOfflineResultEntryVO vo) {
	HisDAO daoObj = null;
	WebRowSet ws = null;
	String strProcName = "{call pkg_inv_view.proc_offline_result_entry_duplicate_patient_data(?,?,?, ?,?,?, ?,?,?, ?,?,?)}";
	int nProcIndex = 0;

	String strErr = "";

	daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO.getOffllineResultEntryPatientTestDataForViewPg()");
	try
	{System.out.println("getOffllineResultEntryPatientTestDataForViewPg");
		daoObj = new HisDAO("Offline Result Entry","InvOfflineResultEntryDAO");
		nProcIndex = daoObj.setProcedure(strProcName);
		
		daoObj.setProcInValue(nProcIndex, "p_mode", "3",1);
		daoObj.setProcInValue(nProcIndex, "p_patname", vo.getPatName(),2);
		daoObj.setProcInValue(nProcIndex, "p_mobno", vo.getPatMobNo(),3);
		daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrPatHospCode(),4);
		daoObj.setProcInValue(nProcIndex, "p_gendercode", vo.getPatGenderCode(),5);
		daoObj.setProcInValue(nProcIndex, "p_age", vo.getStrPatAge(),6);
		daoObj.setProcInValue(nProcIndex, "p_ageunit", vo.getStrPatAgeUnit(),7);
		daoObj.setProcInValue(nProcIndex, "p_father_spouse", vo.getPatGuardianName(),8);
		daoObj.setProcInValue(nProcIndex, "p_cr_no", vo.getPatCRNo(),9);
		daoObj.setProcInValue(nProcIndex, "p_parent_hosp_code", vo.getStrParentHospitalCode(),10);
		
		daoObj.setProcOutValue(nProcIndex, "err", 1,11);
		daoObj.setProcOutValue(nProcIndex, "resultset", 2,12);
		daoObj.executeProcedureByPosition(nProcIndex);
		strErr = daoObj.getString(nProcIndex, "err");
		if (strErr == null || strErr.equals(""))
			strErr = "";
		ws = daoObj.getWebRowSet(nProcIndex, "resultset");
		
		if (strErr.equals("")) 
			vo.setStrPatientTestListWS(ws);  
		else {
			vo.setStrPatientTestListWS(null);
			throw new Exception(strErr);
		}

	} catch (Exception e) {
		e.printStackTrace();
		vo.setStrMsgString("InvOfflineResultEntryDAO.getOffllineResultEntryPatientTestDataForViewPg() --> "+ e.getMessage());
		vo.setStrMsgType("1");
	} finally {
		if (daoObj != null) {
			daoObj.free();
			daoObj = null;
		}
	}
	
}
	
	
}
