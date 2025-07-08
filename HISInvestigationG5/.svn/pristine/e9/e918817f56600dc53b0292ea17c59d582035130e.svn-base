package new_investigation.reports.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hisglobal.exceptions.HisDataAccessException;
import hisglobal.persistence.DataAccessObject;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.persistence.TransactionContext;
import hisglobal.utility.HelperMethods;
import hisglobal.utility.Sequence;
import new_investigation.vo.SampleRejectionReportListVO;
import hisglobal.vo.UserVO;
import new_investigation.InvestigationConfig;

public class SampleRejectionReportListDAO extends DataAccessObject 
{

	public SampleRejectionReportListDAO(TransactionContext _tx)
	{
		super(_tx);
		// TODO Auto-generated constructor stub
	}


	
	public List<SampleRejectionReportListVO> AjaxGetLabList(SampleRejectionReportListVO vo, UserVO userVO) {
		
		String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
		String queryKey="SELECT.LAB_COMBO_NEW.HIVT_LABORATORY_MST";
		String query="";
		
		ResultSet rs=null;
		Connection conn=super.getTransactionContext().getConnection();
		
		Map populateMap= new HashMap();
		Sequence sq= new Sequence();
		List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
		
		try 
		{
			query = HelperMethodsDAO.getQuery(filename, queryKey);
		}
		catch(Exception e)
		{
			throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
		}
		
		
		try
		{
			populateMap.put(sq.next(), userVO.getHospitalCode());
			populateMap.put(sq.next(), InvestigationConfig.MODULE_ID_INVESTIGATION);
			populateMap.put(sq.next(),userVO.getUserSeatId());
			populateMap.put(sq.next(), userVO.getHospitalCode());
			
			rs=HelperMethodsDAO.executeQuery(conn, query, populateMap);
			
			if(!rs.next()) { }
			else {
				rs.beforeFirst();
				while(rs.next()) {
					SampleRejectionReportListVO vo2 = new SampleRejectionReportListVO();
					HelperMethods.populateVOfrmRS(vo2, rs);
					
					listSampleRejectionReportListVO.add(vo2);
				}
			}
			
		}
		catch (Exception e)
		{		 		
			 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
		 }
		
		return listSampleRejectionReportListVO;
	}


	
public List<SampleRejectionReportListVO> AjaxGetMachineList(SampleRejectionReportListVO vo, UserVO userVO) {
	
	String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
	String queryKey="SELECT.LABTEST.HIVT_LABTEST_MST";
	String query="";
	
	ResultSet rs=null;
	Connection conn=super.getTransactionContext().getConnection();
	
	Map populateMap= new HashMap();
	Sequence sq= new Sequence();
	List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
	
	try 
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	
	
	try
	{
		populateMap.put(sq.next(), userVO.getHospitalCode());
	    populateMap.put(sq.next(), vo.getLabCode());
		
		rs=HelperMethodsDAO.executeQuery(conn, query, populateMap);
		
		if(!rs.next()) { }
		else {
			rs.beforeFirst();
			while(rs.next()) {
				SampleRejectionReportListVO vo2 = new SampleRejectionReportListVO();
				HelperMethods.populateVOfrmRS(vo2, rs);
				
				listSampleRejectionReportListVO.add(vo2);
			}
		}
		
	}
	catch (Exception e)
	{		 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }
	
	return listSampleRejectionReportListVO;
}





public List<SampleRejectionReportListVO> AjaxGetMachineTestReportList(SampleRejectionReportListVO vo, UserVO userVO) {
	
	String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
	
	String queryKey0="SELECT.LIST_FOR_SAMPLE_REJECTION";
	
	String query="";
	
	ResultSet rs=null;
	Connection conn=super.getTransactionContext().getConnection();
	
	Map populateMap= new HashMap();
	Sequence sq= new Sequence();
	List<SampleRejectionReportListVO> listSampleRejectionReportListVO=new ArrayList<SampleRejectionReportListVO>();
	
	try 
	{	 
		
		query = HelperMethodsDAO.getQuery(filename, queryKey0);
		if( userVO.getHospitalCode().equalsIgnoreCase("") ||userVO.getHospitalCode().equals(null))
		{
			
		}
		else {
			query=query+"AND a.gnum_hospital_code ="+userVO.getHospitalCode();
		}
		if(vo.getLabCode().equalsIgnoreCase("")||vo.getLabCode().equals(null)) 
		{
		}
		else {
			query=query+"AND a.gnum_lab_code ="+vo.getLabCode();
		}
		if(vo.getTestCode().equalsIgnoreCase("")||vo.getTestCode().equals(null)) 
		{
		}
		else {
			query=query+"AND a.gnum_test_code ="+vo.getTestCode();
		}
	
	}
	catch(Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file::"+e);
	}
	
	
	try
	{
		populateMap.put(sq.next(), vo.getFromDate());
		populateMap.put(sq.next(), vo.getToDate());
		try {
		rs=HelperMethodsDAO.executeQuery(conn, query, populateMap);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		if(!rs.next()) { }
		else {
			rs.beforeFirst();
			while(rs.next()) {
				SampleRejectionReportListVO vo2 = new SampleRejectionReportListVO();
				HelperMethods.populateVOfrmRS(vo2, rs);
				
				listSampleRejectionReportListVO.add(vo2);
			}
		}
		
	}
	catch (Exception e)
	{		 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }
	
	return listSampleRejectionReportListVO;
}

}
