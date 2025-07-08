package HisWeb.dao;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeSet;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;




import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class SearchEMRUtilDao {
	
public static String getSearchEmrDtls(String JsonData) throws JSONException {

		
		
		/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_emr_search_dtl(?,?,?,?,  ?,?,?,?  ,?,?,? ,?,?,?  ,?,?,?,? , ?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONObject jsonObj = new JSONObject();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
         TreeSet<String> TesthashSet=new TreeSet<>();
         TreeSet<String> DrughashSet=new TreeSet<>();
         TreeSet<String> DiagnosishashSet=new TreeSet<>();
         TreeSet<String> CheifComplainthashSet=new TreeSet<>();
         TreeSet<String> PukhashSet=new TreeSet<>();
         HashMap<String, Integer>  TestHashMap=new HashMap<>();
         //Has
        try {
        	JSONObject object = new JSONObject(JsonData);
        	String SearchPara=	(String) object.get("searchPara")==null ? "" : (String) object.get("searchPara") ;	
        	//System.out.println("SearchPara::::::::::: "+SearchPara );
   		 	String DateChk=(String) object.get("strIsDataFilterByDate")==null ? "" : (String) object.get("strIsDataFilterByDate");
   		    String strFromDate=(String) object.get("strIsDataFilterByDate")==null ? "" : (String) object.get("strFromDate");
   		    String strToDate=(String) object.get("strToDate")==null ? "" : (String) object.get("strToDate") ;
   		 	
   		    
   		    String strAgeChkVal=(String) object.get("strAgeChkVal")==null ? "" : (String) object.get("strAgeChkVal");
		    String strFromAge=(String) object.get("strFromAge")==null ? "" : (String) object.get("strFromAge");
		    String strToAge=(String) object.get("strToAge")==null ? "" : (String) object.get("strToAge") ;
		 	
		    String strChkGenderVal=(String) object.get("strChkGenderVal")==null ? "" : (String) object.get("strChkGenderVal");
		    String strGenderVal=(String) object.get("strGender")==null ? "" : (String) object.get("strGender");
		    
		    String strDeptCode=(String) object.get("strDeptCode")==null ? "" : (String) object.get("strDeptCode");
		    String strChkDeptCodeVal=(String) object.get("strChkDeptCodeVal")==null ? "" : (String) object.get("strChkDeptCodeVal");
		    String strVital=(String) object.get("strVitalVal")==null ? "" : (String) object.get("strVitalVal");
		    
   		 	
   			/*String episodeCode=(String) object.get("episodeCode")==null ? "" : (String) object.get("episodeCode") ;
   			String hospitalCode=(String) object.get("hospitalCode")==null ? "" : (String) object.get("hospitalCode") ;
   			String visitNo=(String) object.get("visitNo")==null ? "" : (String) object.get("visitNo") ;
        	////System.out.println("crno::::::::::::::"+crno);
*/            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
          
			procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1",1);
			dao.setProcInValue(procIndex1, "hosp_code", "",2);
			dao.setProcInValue(procIndex1, "seat_id", "",3);
			dao.setProcInValue(procIndex1, "deptCode", "" ,4);
			dao.setProcInValue(procIndex1, "Room_No", JsonData,5);
			dao.setProcInValue(procIndex1, "prev_date", SearchPara,6);
			dao.setProcInValue(procIndex1, "date_chk", DateChk,7);
			dao.setProcInValue(procIndex1, "strFromDate", strFromDate,8);
			dao.setProcInValue(procIndex1, "strToDate", strToDate,9);
			
			dao.setProcInValue(procIndex1, "strAgeChkVal", strAgeChkVal,10);
			dao.setProcInValue(procIndex1, "strFromAge", strFromAge,11);
			dao.setProcInValue(procIndex1, "strToAge", strToAge,12);
			
			dao.setProcInValue(procIndex1, "strChkGenderVal", strChkGenderVal,13);
			dao.setProcInValue(procIndex1, "strGender", strGenderVal,14);
			
			
			dao.setProcInValue(procIndex1, "strChkDeptCodeVal", strChkDeptCodeVal,15);
			dao.setProcInValue(procIndex1, "strDeptCode", strDeptCode,16);
			dao.setProcInValue(procIndex1, "strVital", strVital,17);
			
			
			
			dao.setProcOutValue(procIndex1, "err", 1,18);
			dao.setProcOutValue(procIndex1, "resultset", 2,19);
			
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 
				
				if(ws.size() >0 && ws !=null){
					
					while(ws.next()){
						TesthashSet = getTestHashset(ws.getString("Test") ,TesthashSet ,TestHashMap);
					}
					//System.out.println("FinaTesthashSet"+TesthashSet.toString());
					ws.beforeFirst();
					while(ws.next()){
						DrughashSet = getDrugHashset(ws.getString("drug") ,DrughashSet);
					}
					//System.out.println("FinaDrughashSet"+DrughashSet.toString());
					ws.beforeFirst();
					while(ws.next()){
						DiagnosishashSet = getDiagnosisHashset(ws.getString("Diagnosis") ,DiagnosishashSet);
					}
					//System.out.println("FinalDiagnosishashSet"+DiagnosishashSet.toString());
					
					ws.beforeFirst();
					while(ws.next()){
						CheifComplainthashSet = getChiefCompaintHashset(ws.getString("chiefcomplaint") ,CheifComplainthashSet);
					}
					//System.out.println("FinalCheifComplainthashSet"+CheifComplainthashSet.toString());
					
					ws.beforeFirst();
					while(ws.next()){
						PukhashSet.add(ws.getString("PUK"));  //	(ws.getString("PUK") ,CheifComplainthashSet);
					}
					//System.out.println("PukhashSet"+PukhashSet.toString());
				}
             
              }
			jsonObj.put("DrugJson", DrughashSet);
			jsonObj.put("TestJson", TesthashSet);
			jsonObj.put("DiagnosisJson", DiagnosishashSet);
			jsonObj.put("chiefComplainthashSet", CheifComplainthashSet);
			jsonObj.put("crhashSet", PukhashSet);
         
      /*    mainObj.put("status", "1");
          mainObj.put("VitalDtls", jsonolist);*/
         
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return jsonObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","SearchEMRUtilDao.getSearchEmrDtls()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            mainObj.put("status", "2");
            mainObj.put("VitalDtls", "");
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }

private static TreeSet<String> getTestHashset(String JsonArrayString ,TreeSet<String> hashSet , HashMap<String, Integer> hashmap) throws JSONException {
	
	 JSONArray jsonArray = new JSONArray(JsonArrayString);
	
	 //System.out.println("Size Of JsonArray"+jsonArray.length());
	
	 if(jsonArray.length() > 0 && jsonArray!=null){
		
		 for(int i=0 ;i< jsonArray.length() ;i++){
			 hashSet.add(((String)((JSONObject)(jsonArray.get(i))).getString("TestName")).toUpperCase()) ;
		 }
	//System.out.println("Hash Set"+hashSet);	 
	 }
	return hashSet;
}
private static TreeSet<String> getDrugHashset(String JsonArrayString ,TreeSet<String> hashSet) throws JSONException {
	
	 JSONArray jsonArray = new JSONArray(JsonArrayString);
	
	 //System.out.println("Size Of JsonArray"+jsonArray.length());
	
	 if(jsonArray.length() > 0 && jsonArray!=null){
		
		 for(int i=0 ;i< jsonArray.length() ;i++){
			 hashSet.add(((String)((JSONObject)(jsonArray.get(i))).getString("DrugName")).toUpperCase()) ;
		 }
	//System.out.println("Hash Set"+hashSet);	 
	 }
	return hashSet;
}
private static TreeSet<String> getDiagnosisHashset(String JsonArrayString ,TreeSet<String> hashSet) throws JSONException {
	
	 JSONArray jsonArray = new JSONArray(JsonArrayString);
	
	 //System.out.println("Size Of JsonArray"+jsonArray.length());
	
	 if(jsonArray.length() > 0 && jsonArray!=null){
		
		 for(int i=0 ;i< jsonArray.length() ;i++){
			 hashSet.add(((String)((JSONObject)(jsonArray.get(i))).getString("DiagnosisName")).toUpperCase()) ;
		 }
	//System.out.println("Hash Set"+hashSet);	 
	 }
	return hashSet;
}
private static TreeSet<String> getChiefCompaintHashset(String JsonArrayString ,TreeSet<String> hashSet) throws JSONException {
	
	 JSONArray jsonArray = new JSONArray(JsonArrayString);
	
	 //System.out.println("Size Of JsonArray"+jsonArray.length());
	
	 if(jsonArray.length() > 0 && jsonArray!=null){
		
		 for(int i=0 ;i< jsonArray.length() ;i++){
			 hashSet.add(((String)((JSONObject)(jsonArray.get(i))).getString("VisitReasonName")).toUpperCase()) ;
		 }
	//System.out.println("Hash Set"+hashSet);	 
	 }
	return hashSet;
}


public static String getDeptDtl(HttpServletRequest request) {
	String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
	HisDAO dao = null;
	HisUtil util = null;
	String cmb="";
	int nProcIndex = 0;
	HisUtil hisutil = null;
	String strErr = "";
	WebRowSet wsResult = null;

	try {
		hisutil = new HisUtil("OPD Ver-2.0", "getDeptDtlData");
		
		String HsopitalCode=(String) request.getSession().getAttribute("HOSPITAL_CODE");

		util = new HisUtil("OPDDRDRDESk",
				"DoctorDeskDAO()");
		dao = new HisDAO("MMS",
				"transactions.DoctorDeskDAO..setItemCatValues()");
		
		nProcIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nProcIndex, "modeval", "5",1);
		dao.setProcInValue(nProcIndex, "hosp_code", HsopitalCode,2);
		dao.setProcInValue(nProcIndex, "seat_id",  "0",3);
		dao.setProcInValue(nProcIndex, "deptCode", "",4);
		dao.setProcInValue(nProcIndex, "Room_No", "",5);
		dao.setProcOutValue(nProcIndex, "err", 1,6);
		dao.setProcOutValue(nProcIndex, "resultset", 2,7);
		dao.executeProcedureByPosition(nProcIndex);

		strErr = dao.getString(nProcIndex, "err");

		wsResult = dao.getWebRowSet(nProcIndex, "resultset");
		//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
		if (strErr == null || strErr.equals(""))
		{
			if (wsResult != null && wsResult.size() > 0) {
				cmb = hisutil.getOptionValue(wsResult, "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
		}
		else
			throw new Exception(strErr);
	} catch (Exception _Err) {
		
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			hisutil= null;
		}
		util = null;
		wsResult = null;
		hisutil = null;
	}
	
	return cmb;
}

public static String getSearchParaDtl(HttpServletRequest request) {
	String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
	HisDAO dao = null;
	HisUtil util = null;
	String cmb="";
	int nProcIndex = 0;
	HisUtil hisutil = null;
	String strErr = "";
	WebRowSet wsResult = null;

	try {
		hisutil = new HisUtil("OPD Ver-2.0", "getSearchParaDtl");
		
		String HsopitalCode=(String) request.getSession().getAttribute("HOSPITAL_CODE");

		util = new HisUtil("OPDDRDRDESk",
				"DoctorDeskDAO()");
		dao = new HisDAO("MMS",
				"transactions.DoctorDeskDAO..setItemCatValues()");
		
		nProcIndex = dao.setProcedure(strproc_name);
		dao.setProcInValue(nProcIndex, "modeval", "6",1);
		dao.setProcInValue(nProcIndex, "hosp_code", HsopitalCode,2);
		dao.setProcInValue(nProcIndex, "seat_id",  "0",3);
		dao.setProcInValue(nProcIndex, "deptCode", "",4);
		dao.setProcInValue(nProcIndex, "Room_No", "",5);
		dao.setProcOutValue(nProcIndex, "err", 1,6);
		dao.setProcOutValue(nProcIndex, "resultset", 2,7);
		dao.executeProcedureByPosition(nProcIndex);

		strErr = dao.getString(nProcIndex, "err");

		wsResult = dao.getWebRowSet(nProcIndex, "resultset");
		//System.out.println("getDeptDtl wsResult::::::::::::"+wsResult.size());
		if (strErr == null || strErr.equals(""))
		{
			if (wsResult != null && wsResult.size() > 0) {
				cmb = hisutil.getOptionValue(wsResult, "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
		}
		else
			throw new Exception(strErr);
	} catch (Exception _Err) {
		
	} finally {
		if (dao != null) {
			dao.free();
			dao = null;
			hisutil= null;
		}
		util = null;
		wsResult = null;
		hisutil = null;
	}
	
	return cmb;
}


public static JSONArray getLabHistoryDao(String crno) {
    JSONArray response = new JSONArray();
    String strproc_name = "{call pkg_opdDrDesk_view.get_pat_lab_Details(?,?,?)}";
    HisDAO dao = null;
    int nProcIndex = 0;
    String strErr = "";
    WebRowSet wsResult = null;

    try {
        dao = new HisDAO("DRDESK", "DoctorDeskDAO.getEMRDetailsDao()");

        nProcIndex = dao.setProcedure(strproc_name);
        dao.setProcInValue(nProcIndex, "crno", crno, 1);
        dao.setProcOutValue(nProcIndex, "err", 1, 2);
        dao.setProcOutValue(nProcIndex, "resultset", 2, 3);
        dao.executeProcedureByPosition(nProcIndex);

        strErr = dao.getString(nProcIndex, "err");
        if (strErr == null || strErr.equals("")) {
            wsResult = dao.getWebRowSet(nProcIndex, "resultset");
        } else {
            throw new Exception(strErr);
        }

    } catch (Exception _Err) {
        new HisException("OPD Ver-2.0", "DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
        _Err.printStackTrace();
    } finally {
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }

    if (wsResult != null) {
        try {
            response = printJSONObject(wsResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Print the response data
    //System.out.println("EMR Details Response: " + response.toString());

    return response;
}
public static JSONArray getReferralHistoryDao(String crno) {
    JSONArray response = new JSONArray();
    String strproc_name = "{call pkg_opdDrDesk_view.get_pat_referral_Details(?,?,?)}";
    HisDAO dao = null;
    int nProcIndex = 0;
    String strErr = "";
    WebRowSet wsResult = null;

    try {
        dao = new HisDAO("DRDESK", "DoctorDeskDAO.getEMRDetailsDao()");

        nProcIndex = dao.setProcedure(strproc_name);
        dao.setProcInValue(nProcIndex, "crno", crno, 1);
        dao.setProcOutValue(nProcIndex, "err", 1, 2);
        dao.setProcOutValue(nProcIndex, "resultset", 2, 3);
        dao.executeProcedureByPosition(nProcIndex);

        strErr = dao.getString(nProcIndex, "err");
        if (strErr == null || strErr.equals("")) {
            wsResult = dao.getWebRowSet(nProcIndex, "resultset");
        } else {
            throw new Exception(strErr);
        }

    } catch (Exception _Err) {
        new HisException("OPD Ver-2.0", "DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
        _Err.printStackTrace();
    } finally {
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }

    if (wsResult != null) {
        try {
            response = printJSONObject(wsResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Print the response data
    //System.out.println("EMR Details Response: " + response.toString());

    return response;
}

public static JSONArray getMedicalHistoryDao(String crno) {
    JSONArray response = new JSONArray();
    String strproc_name = "{call pkg_opdDrDesk_view.get_pat_medical_Details(?,?,?)}";
    HisDAO dao = null;
    int nProcIndex = 0;
    String strErr = "";
    WebRowSet wsResult = null;

    try {
        dao = new HisDAO("DRDESK", "DoctorDeskDAO.getEMRDetailsDao()");

        nProcIndex = dao.setProcedure(strproc_name);
        dao.setProcInValue(nProcIndex, "crno", crno, 1);
        dao.setProcOutValue(nProcIndex, "err", 1, 2);
        dao.setProcOutValue(nProcIndex, "resultset", 2, 3);
        dao.executeProcedureByPosition(nProcIndex);

        strErr = dao.getString(nProcIndex, "err");
        if (strErr == null || strErr.equals("")) {
            wsResult = dao.getWebRowSet(nProcIndex, "resultset");
        } else {
            throw new Exception(strErr);
        }

    } catch (Exception _Err) {
        new HisException("OPD Ver-2.0", "DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
        _Err.printStackTrace();
    } finally {
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }

    if (wsResult != null) {
        try {
            response = printJSONObject(wsResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Print the response data
    //System.out.println("EMR Details Response: " + response.toString());

    return response;
}

public static JSONArray getBenShortNameDAO(String crno) {
    JSONArray response = new JSONArray();
    String strproc_name = "{call pkg_opdDrDesk_view.get_pat_short_name(?,?,?)}";
    HisDAO dao = null;
    int nProcIndex = 0;
    String strErr = "";
    WebRowSet wsResult = null;

    try {
        dao = new HisDAO("DRDESK", "DoctorDeskDAO.getEMRDetailsDao()");

        nProcIndex = dao.setProcedure(strproc_name);
        dao.setProcInValue(nProcIndex, "crno", crno, 1);
        dao.setProcOutValue(nProcIndex, "err", 1, 2);
        dao.setProcOutValue(nProcIndex, "resultset", 2, 3);
        dao.executeProcedureByPosition(nProcIndex);

        strErr = dao.getString(nProcIndex, "err");
        if (strErr == null || strErr.equals("")) {
            wsResult = dao.getWebRowSet(nProcIndex, "resultset");
        } else {
            throw new Exception(strErr);
        }

    } catch (Exception _Err) {
        new HisException("OPD Ver-2.0", "DoctorDeskDAO.callNextPatient()-->", _Err.getMessage() + "-->" + _Err);
        _Err.printStackTrace();
    } finally {
        if (dao != null) {
            dao.free();
            dao = null;
        }
    }

    if (wsResult != null) {
        try {
            response = printJSONObject(wsResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Print the response data
    //System.out.println("EMR Details Response: " + response.toString());

    return response;
}

	public static JSONArray printJSONObject(WebRowSet ws ) throws Exception {
		JSONArray arr = new JSONArray();
	    try {
	    if(ws!=null) {
		  
		    
		    ResultSetMetaData rsmd = ws.getMetaData() ;
	    	int colCount = rsmd.getColumnCount();
	    	while (ws.next()){
	    		JSONObject jsonObject = new JSONObject();
	    		  try {
	  		    	Field changeMap = jsonObject.getClass().getDeclaredField("map");
	  		    	changeMap.setAccessible(true);
	  		    	changeMap.set(jsonObject, new LinkedHashMap<>());
	  		    	changeMap.setAccessible(false);
	  		    } catch (IllegalAccessException | NoSuchFieldException e) {
	  		     //System.out.println(e.getMessage());
	  		    }
	    		for (int i=1;i<=rsmd.getColumnCount();i++){
	    			
	    			String key=rsmd.getColumnName(i).trim();
	    			if(key.equals("?column?")){
	    				key="column_"+i;
	    			}
					String value=ws.getString(i)==null?"":ws.getString(i);
					jsonObject.put(key, value);
	    		}
	    		arr.put(jsonObject);
	    	}		    
	    }
	    }catch(Exception e) {
	    	throw e;
	    }
	    finally {
	    	if(ws!=null) {
	    		ws.close();
	    		ws=null;
	    	}
	    }
	    return arr;
	  }
}
