package new_investigation.transactions.dao;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import org.apache.poi.util.SystemOutLogger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.exceptions.HisDataAccessException;
import hisglobal.persistence.HelperMethodsDAO;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.Entry;
import hisglobal.vo.UserVO;


public class NEWOfflineResultEntryServiceDAO 
{




public  String  getOfflineLabTestData(JSONObject objFilterJson) {
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String resultDataJson=null;	
	
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.OFFLINE.DATA.FOR.ABDM";
	String query="";
	
	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	
	
	
	
	try{
		hisDao = new HisDAO("Investigation", "offline Result entry");
		query=query.replaceAll(":"+"patCrno", "'"+objFilterJson.getString("patCrno")+"'");
		query=query.replaceAll(":"+"patEpisodeCode", objFilterJson.getString("patEpisodeCode"));
		query=query.replaceAll(":"+"patEpisodeVisitNo", objFilterJson.getString("patEpisodeVisitNo"));
		query=query.replaceAll(":"+"patCrno", objFilterJson.getString("patCrno"));
		query=query.replaceAll(":"+"hospitalCode", objFilterJson.getString("hospitalCode"));
		
		System.out.println("query-----"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		
		resultDataJson=HelperMethodsDAO.getAlOfJsonObjectsInv(rs);
		System.out.println("resultDataJson---" + resultDataJson);
	 
	} catch (Exception e) {
		resultDataJson="[]";
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}

	}
	
	return resultDataJson;
	
}

public List<Entry> getDepartmentUnitList(UserVO userVO) {
	
	
	List<Entry> lstDepartmentVO=new ArrayList<Entry>();
	
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String resultDataJson=null;	
	
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.OFFLINE.OPD.DEPARTMENT.UNIT.LIST";
	String query="";
	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	
	
	
	
	try{
		hisDao = new HisDAO("Investigation", "offline Result entry");
		query=query.replaceAll(":"+"hosp_code", userVO.getHospitalCode());
		query=query.replaceAll(":"+"seat_id", userVO.getSeatId());
		
		System.out.println("query-----"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		
		lstDepartmentVO=HelperMethodsDAO.getAlOfEntryObjects(rs);
		
	 
	} catch (Exception e) {
		lstDepartmentVO=null;
		e.printStackTrace();
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}

	}
	
	return lstDepartmentVO;
	
}

public String getCurrentDate() {
	String currentDate= null;
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String query="";	
	
	
	
	try{
		hisDao = new HisDAO("Investigation", "offline Result entry");
		query="select to_char(now(),'dd-Mon-yyyy')";
		
		
		//System.out.println("query-----"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		if(rs.next()) {
			currentDate=rs.getString(1);
		}
		
	 
	} catch (Exception e) {
		currentDate=null;
		e.printStackTrace();
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}

	}
	
	return currentDate;
}

public String getPatientListPageData(JSONObject objFilter) {
	String result= "[]";
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String query="";	
	
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.OFFLINE.OPD.PATIENT.LIST";
	
	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	
	
	
	try{
		hisDao = new HisDAO("Investigation", "offline Result entry");
		
		query=query.replaceAll(":"+"hosp_code", objFilter.getString("hospitalCode"));
		query=query.replaceAll(":"+"seatId", objFilter.getString("seatId"));		
		query=query.replaceAll(":"+"fromDate", objFilter.getString("fromDate"));
		query=query.replaceAll(":"+"toDate", objFilter.getString("toDate"));
		query=query.replaceAll(":"+"patDeptUnitCode", objFilter.getString("patDeptUnitCode").equals("ALL")?"%":objFilter.getString("patDeptUnitCode"));
		
		System.out.println("query-----"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		
		result=HelperMethodsDAO.getAlOfJsonObjectsInv(rs);
	 
	} catch (Exception e) {
		result= "[]";
		e.printStackTrace();
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}
}
	return result;
}

public String getEpisodeListData(JSONObject objFilter) {
	String result= "[]";
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String query="";	
	String condition="";
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.OFFLINE.PATIENT.EPISODE.LIST";
	String queryKeyCondition = "SELECT.OFFLINE.PATIENT.EPISODE.LIST.CONDITION";
	
	
	try
	{
		query = HelperMethodsDAO.getQuery(filename, queryKey);
		condition= HelperMethodsDAO.getQuery(filename, queryKeyCondition);
	}
	catch (Exception e)
	{
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	
	
	
	
	try{
		hisDao = new HisDAO("Investigation", "offline Result entry");
		
		query=query.replaceAll(":"+"hospitalCode", objFilter.getString("hospitalCode"));
		//query=query.replaceAll(":"+"patCRNO", objFilter.getString("patCRNO"));
		
		System.out.println("testcr"+objFilter.getString("patCrNO"));
		query=query.replaceAll(":"+"patCrNO","'"+ objFilter.getString("patCrNO")+"'");
	
		if(objFilter.has("episodeCode")) {
			condition=condition.replaceAll(":"+"episodeCode", objFilter.getString("episodeCode"));
			condition=condition.replaceAll(":"+"visitNo", objFilter.getString("visitNo"));
			query=query+" " + condition;
			//{"patCRNO":"100012300001128","episodeCode":"23311001","seatId":"21210005","hospitalCode":"2010001","visitNo":"1"}
		}
		System.out.println("query-----"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		
		result=HelperMethodsDAO.getAlOfJsonObjectsInv(rs);
	 
	} catch (Exception e) {
		result= "[]";
		e.printStackTrace();
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}
}
	return result;
}



public  String  EpisodeTestDtl(JSONObject objFilter) {
	HisDAO hisDao = null;
	WebRowSet rs = null;
	String resultDataJson=null;	
	
	String filename= "new_investigation.transactions.investigationTransactionsamplecollQuery";
	String queryKey = "SELECT.EPISODE.TEST.DTL";
	String query="";
	
	try
	{ 	System.out.println("patCrNO>>>0");
		query = HelperMethodsDAO.getQuery(filename, queryKey);
	}
	catch (Exception e)
	{  e.printStackTrace();
		throw new HisDataAccessException("HelperMethodsDAO.loadPropertiesFile(filename)OR getting query out of property file" + e);
	}
	System.out.println("patCrNO>>>1");
	
	try{
		System.out.println("patCrNO>>>1");
		hisDao = new HisDAO("Investigation", "offline Result entry");
		System.out.println("patCrNO>>>2");
		query=query.replaceAll(":"+"patCrNO", objFilter.getString("patCrNO"));
		System.out.println("patCrNO>>>"+ objFilter.getString("patCrNO"));
		query=query.replaceAll(":"+"episodeCode", objFilter.getString("episodeCode"));
		System.out.println("episodeCode>>>"+ objFilter.getString("episodeCode"));
		query=query.replaceAll(":"+"visitNo", objFilter.getString("visitNo"));
		System.out.println("visitNo>>"+ objFilter.getString("visitNo"));
		query=query.replaceAll(":"+"hospitalCode", objFilter.getString("hospitalCode"));
		System.out.println("hospitalCode>>"+ objFilter.getString("hospitalCode"));
		System.out.println("query---45--"+ query);
		int qryIndex = hisDao.setQuery(query);
		rs = hisDao.executeQry(qryIndex);
		
		resultDataJson=HelperMethodsDAO.getAlOfJsonObjectsInv(rs);
		System.out.println("resultDataJson---" + resultDataJson);
	 
	} catch (Exception e) {
		resultDataJson="[]";
		
	} finally {

		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}

	}
	
	return resultDataJson;
	
}

}


