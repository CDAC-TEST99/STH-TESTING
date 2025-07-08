package new_investigation.reports.bo;


import hisglobal.exceptions.HisApplicationExecutionException;
import hisglobal.exceptions.HisDataAccessException;
import hisglobal.exceptions.HisException;
import hisglobal.exceptions.HisRecordNotFoundException;
import hisglobal.persistence.JDBCTransactionContext;
import hisglobal.vo.UserVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import new_investigation.reports.dao.PatientDiagnosisReportDAO;
import new_investigation.vo.PatientDiagnosisReportVO;

public class PatientDiagnosisReportBO 
{

public Map AjaxGetLabList(PatientDiagnosisReportVO vo, UserVO userVO) {
		
		JDBCTransactionContext tx = new JDBCTransactionContext();
		Map<String, List<PatientDiagnosisReportVO>> mp=new HashMap<String, List<PatientDiagnosisReportVO>>();
		List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
		
		try {
			tx.begin();
			PatientDiagnosisReportDAO PatientDiagnosisReportDAO = new PatientDiagnosisReportDAO (tx);
			
			listPatientDiagnosisReportVO=PatientDiagnosisReportDAO.AjaxGetLabList(vo, userVO);
			
			mp.put("labList", listPatientDiagnosisReportVO);
			
		}
		catch (HisRecordNotFoundException e)
		{
			//tx.rollback();
			throw new HisRecordNotFoundException(e.getMessage());
		}
		catch (HisApplicationExecutionException e)
		{
			//tx.rollback();
			System.out.println(e.getMessage());
			throw new HisApplicationExecutionException();
		}
		catch (HisDataAccessException e)
		{
			//tx.rollback();
			System.out.println(e.getMessage());
			throw new HisDataAccessException();
		}
		catch (HisException e)
		{
			//tx.rollback();
			System.out.println(e.getMessage());
			throw new HisException();
		}
		catch (Exception e)
		{
			//tx.rollback();
			System.out.println(e.getMessage());
			throw new HisApplicationExecutionException();
		}
		finally
		{
			tx.close();
		}
		return mp;
	}


	

public Map AjaxGetMachineList(PatientDiagnosisReportVO vo, UserVO userVO) {
	
	JDBCTransactionContext tx = new JDBCTransactionContext();
	Map<String, List<PatientDiagnosisReportVO>> mp=new HashMap<String, List<PatientDiagnosisReportVO>>();
	List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
	
	try {
		tx.begin();
		PatientDiagnosisReportDAO PatientDiagnosisReportDAO = new PatientDiagnosisReportDAO (tx);
		
		listPatientDiagnosisReportVO=PatientDiagnosisReportDAO.AjaxGetMachineList(vo, userVO);
		
		mp.put("machineList", listPatientDiagnosisReportVO);
		
	}
	catch (HisRecordNotFoundException e)
	{
		//tx.rollback();
		throw new HisRecordNotFoundException(e.getMessage());
	}
	catch (HisApplicationExecutionException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisApplicationExecutionException();
	}
	catch (HisDataAccessException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisDataAccessException();
	}
	catch (HisException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisException();
	}
	catch (Exception e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisApplicationExecutionException();
	}
	finally
	{
		tx.close();
	}
	return mp;
}


public Map AjaxGetMachineTestReportList(PatientDiagnosisReportVO vo, UserVO userVO) {
	
	JDBCTransactionContext tx = new JDBCTransactionContext();
	Map<String, List<PatientDiagnosisReportVO>> mp=new HashMap<String, List<PatientDiagnosisReportVO>>();
	List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
	
	try {
		tx.begin();
		PatientDiagnosisReportDAO PatientDiagnosisReportDAO = new PatientDiagnosisReportDAO (tx);
		
		listPatientDiagnosisReportVO=PatientDiagnosisReportDAO.AjaxGetMachineTestReportList(vo, userVO);
		
		mp.put("machineTestList", listPatientDiagnosisReportVO);
		
	}
	catch (HisRecordNotFoundException e)
	{
		//tx.rollback();
		throw new HisRecordNotFoundException(e.getMessage());
	}
	catch (HisApplicationExecutionException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisApplicationExecutionException();
	}
	catch (HisDataAccessException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisDataAccessException();
	}
	catch (HisException e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisException();
	}
	catch (Exception e)
	{
		//tx.rollback();
		System.out.println(e.getMessage());
		throw new HisApplicationExecutionException();
	}
	finally
	{
		tx.close();
	}
	return mp;
}

}




