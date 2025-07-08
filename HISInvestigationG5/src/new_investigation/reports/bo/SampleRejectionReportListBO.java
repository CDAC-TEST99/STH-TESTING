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

import new_investigation.reports.dao.SampleRejectionReportListDAO;
import new_investigation.vo.SampleRejectionReportListVO;

public class SampleRejectionReportListBO 
{

public Map AjaxGetLabList(SampleRejectionReportListVO vo, UserVO userVO) {
		
		JDBCTransactionContext tx = new JDBCTransactionContext();
		Map<String, List<SampleRejectionReportListVO>> mp=new HashMap<String, List<SampleRejectionReportListVO>>();
		List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
		
		try {
			tx.begin();
			SampleRejectionReportListDAO SampleRejectionReportListDAO = new SampleRejectionReportListDAO (tx);
			
			listSampleRejectionReportListVO=SampleRejectionReportListDAO.AjaxGetLabList(vo, userVO);
			
			mp.put("labList", listSampleRejectionReportListVO);
			
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


	

public Map AjaxGetMachineList(SampleRejectionReportListVO vo, UserVO userVO) {
	
	JDBCTransactionContext tx = new JDBCTransactionContext();
	Map<String, List<SampleRejectionReportListVO>> mp=new HashMap<String, List<SampleRejectionReportListVO>>();
	List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
	
	try {
		tx.begin();
		SampleRejectionReportListDAO SampleRejectionReportListDAO = new SampleRejectionReportListDAO (tx);
		
		listSampleRejectionReportListVO=SampleRejectionReportListDAO.AjaxGetMachineList(vo, userVO);
		
		mp.put("machineList", listSampleRejectionReportListVO);
		
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


public Map AjaxGetMachineTestReportList(SampleRejectionReportListVO vo, UserVO userVO) {
	
	JDBCTransactionContext tx = new JDBCTransactionContext();
	Map<String, List<SampleRejectionReportListVO>> mp=new HashMap<String, List<SampleRejectionReportListVO>>();
	List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
	
	try {
		tx.begin();
		SampleRejectionReportListDAO SampleRejectionReportListDAO = new SampleRejectionReportListDAO (tx);
		
		listSampleRejectionReportListVO=SampleRejectionReportListDAO.AjaxGetMachineTestReportList(vo, userVO);
		
		mp.put("machineTestList", listSampleRejectionReportListVO);
		
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




