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
import new_investigation.vo.PatientDiagnosisReportVO;
import hisglobal.vo.UserVO;
import new_investigation.InvestigationConfig;

public class PatientDiagnosisReportDAO extends DataAccessObject 
{

	public PatientDiagnosisReportDAO(TransactionContext _tx)
	{
		super(_tx);
		// TODO Auto-generated constructor stub
	}


	
	public List<PatientDiagnosisReportVO> AjaxGetLabList(PatientDiagnosisReportVO vo, UserVO userVO) {
		
		String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
		String queryKey="SELECT.LAB_COMBO_NEW.HIVT_LABORATORY_MST";
		String query="";
		
		ResultSet rs=null;
		Connection conn=super.getTransactionContext().getConnection();
		
		Map populateMap= new HashMap();
		Sequence sq= new Sequence();
		List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
		
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
					PatientDiagnosisReportVO vo2 = new PatientDiagnosisReportVO();
					HelperMethods.populateVOfrmRS(vo2, rs);
					
					listPatientDiagnosisReportVO.add(vo2);
				}
			}
			
		}
		catch (Exception e)
		{		 		
			 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
		 }
		
		return listPatientDiagnosisReportVO;
	}


	
public List<PatientDiagnosisReportVO> AjaxGetMachineList(PatientDiagnosisReportVO vo, UserVO userVO) {
	
	String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
	String queryKey="SELECT.LABTEST.HIVT_LABTEST_MST";
	String query="";
	
	ResultSet rs=null;
	Connection conn=super.getTransactionContext().getConnection();
	
	Map populateMap= new HashMap();
	Sequence sq= new Sequence();
	List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
	
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
				PatientDiagnosisReportVO vo2 = new PatientDiagnosisReportVO();
				HelperMethods.populateVOfrmRS(vo2, rs);
				
				listPatientDiagnosisReportVO.add(vo2);
			}
		}
		
	}
	catch (Exception e)
	{		 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }
	
	return listPatientDiagnosisReportVO;
}





public List<PatientDiagnosisReportVO> AjaxGetMachineTestReportList(PatientDiagnosisReportVO vo, UserVO userVO) {
	
	String filename= InvestigationConfig.QUERY_FILE_FOR_INVESTIGATION_REPORTSDAO;
	
	String queryKey0="SELECT.LIST_FOR_PATIENT_HISTORY_REPORT";
	
	String query="";
	
	ResultSet rs=null;
	Connection conn=super.getTransactionContext().getConnection();
	
	Map populateMap= new HashMap();
	Sequence sq= new Sequence();
	List<PatientDiagnosisReportVO> listPatientDiagnosisReportVO=new ArrayList<PatientDiagnosisReportVO>();
	
	try 
	{	 
		
		query = HelperMethodsDAO.getQuery(filename, queryKey0);
		
		if(vo.getTestCode().equalsIgnoreCase("")||vo.getTestCode().equals(null) || vo.getTestCode().equalsIgnoreCase("1")) 
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
		populateMap.put(sq.next(),userVO.getHospitalCode() );
		populateMap.put(sq.next(), vo.getLabCode());

		populateMap.put(sq.next(), vo.getFromDate());
		populateMap.put(sq.next(), vo.getToDate());
		populateMap.put(sq.next(),userVO.getHospitalCode() );
		populateMap.put(sq.next(), vo.getLabCode());
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
				PatientDiagnosisReportVO vo2 = new PatientDiagnosisReportVO();
				HelperMethods.populateVOfrmRS(vo2, rs);
				
				listPatientDiagnosisReportVO.add(vo2);
			}
		}
		
	}
	catch (Exception e)
	{		 		
		 throw new HisDataAccessException("HisDataAccessException:: "+e);			 
	 }
	
	return listPatientDiagnosisReportVO;
}

}
