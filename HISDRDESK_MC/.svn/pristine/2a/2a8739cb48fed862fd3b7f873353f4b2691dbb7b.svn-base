package HisWeb.dao;

import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.sql.rowset.WebRowSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import hisglobal.backutil.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

public class EHRDetailsDAO {
	
	public static String getPatinetEHRDtls(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(key.equalsIgnoreCase("hrstr_json_data")) {
                		JSONParser parser = new JSONParser();
                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	
	public static String getPatinetEHRDtlsNew(String mode,String crno, String episodeCode, String entrydate, String hosp_code, String strIsPrescribedSaveFlg) {
    	/* Get EHR Details */
    	String err = "";
    	//String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
    	
    	String strProcName = "{call Pkg_Mms_View.proc_issue_to_pat_dtl(?,?,? ,?,?,? ,?,?,? ,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;/// 
        try {
        	//System.out.println("crno  "+crno + " mode "+mode );
        	
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtlsNew()");
            procIndex1 = dao.setProcedure(strProcName);
           // dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
          //  procIndex1 = dao.setProcedure(strProcName);
            dao.setProcInValue(procIndex1, "modeval", "5",1);
            dao.setProcInValue(procIndex1, "hosp_code", "",2);
            dao.setProcInValue(procIndex1, "seatId", "",3);
            dao.setProcInValue(procIndex1, "crno", "",4);
            dao.setProcInValue(procIndex1, "p_date", "",5);
            dao.setProcInValue(procIndex1, "itemCat", "0",6);
            dao.setProcInValue(procIndex1, "drugIds", "0",7);
            dao.setProcInValue(procIndex1, "issueNo", "0",8);
            dao.setProcOutValue(procIndex1, "err", 1,9);
            dao.setProcOutValue(procIndex1, "resultset", 2,10);
            //dao.executeProcedureByPosition(procIndex1);
            
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
			//System.out.println("crno     "+  crno + " mode "+mode +"  < strIsPrescribedSaveFlg--> "+strIsPrescribedSaveFlg);
			
			if(strIsPrescribedSaveFlg == "0"){   
 				
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(key.equalsIgnoreCase("hrstr_json_data")) {
                		JSONParser parser = new JSONParser();
                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          }
          
          else {
        	  if (ws != null && ws.size() > 0) {
                  while (ws.next()) {
                	  int j=0;
                    	status="1";
                    	JSONObject js=new JSONObject();
                    	for (int i=1;i<=length;i++)
                    	{
                    		String key=columnlist.get(i-1);
                    		String value=ws.getString(i);
                    		if(key.equalsIgnoreCase("hrstr_json_data")) {
                    		JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                    		}else {
                    			js.put(key, value);
                    		}
                    		
                    	}
                    	jsonolist.add(js) ;               	
                    	
                    }
                  //ja.put(jsonolist);
                  }
        	  
        	  
         
			}
          
          
          //System.out.println("jsonolist"+jsonolist);
          
         
          mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static String getVitalDtlsDtls(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_vital_dtls(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		JSONParser parser = new JSONParser();
                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, json);
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          mainObj.put("status", status);
          mainObj.put("VitalDtls", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getVitalDtlsDtls()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String getPatientEHRDtlsForPastPrescription(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		if(key.equalsIgnoreCase("hrstr_json_data")){
                			JSONParser parser = new JSONParser();
                			//System.out.println("value>>>>>" + value);
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}
                		else{
                			js.put(key, value);
                		}
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          //mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          JSONParser parser = new JSONParser();
  		//org.json.simple.JSONObject json1 = (org.json.simple.JSONObject) parser.parse(getPatientEHRDtlsForTemplatePrescription(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code));
          mainObj.put("Template",getPatientEHRDtlsForTemplatePrescription(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code, "0") );
          
          mainObj.put("PaptientDoc",getPatientEHRDtlsForTemplatePrescription1(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code, "0") );
         // mainObj.
          ja.put(mainObj);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String getIpdPatEHRDtlsForPastPrescription(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code , String admNo) {
    	/* Get IPD EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_ipddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("getIpdPatEHRDtlsForPastPrescription crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcInValue(procIndex1, "admno", admNo,8);
            dao.setProcOutValue(procIndex1, "err", 1,9);
            dao.setProcOutValue(procIndex1, "resultset", 2,10);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		if(key.equalsIgnoreCase("hrstr_json_data")){
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}
                		else{
                			js.put(key, value);
                		}
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          //mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          JSONParser parser = new JSONParser();
  		//org.json.simple.JSONObject json1 = (org.json.simple.JSONObject) parser.parse(getPatientEHRDtlsForTemplatePrescription(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code));
          mainObj.put("Template",getPatientEHRDtlsForTemplatePrescription(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code, admNo) );
          
          mainObj.put("PaptientDoc",getPatientEHRDtlsForTemplatePrescription1(mode, crno, episodeCode, visitNo, seatId, entrydate, hosp_code, admNo) );
         // mainObj.
          ja.put(mainObj);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String getPatientEHRDtlsForInvDrug(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.proc_prev_dtl(?,?,?,?, ?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);            
            dao.setProcInValue(procIndex1, "modeval", mode,1);
			dao.setProcInValue(procIndex1, "hosp_code",hosp_code,2);
			dao.setProcInValue(procIndex1, "seat_id",  "",3);
			dao.setProcInValue(procIndex1, "deptCode", "",4);
			dao.setProcInValue(procIndex1, "episodecode", episodeCode,5);
			dao.setProcInValue(procIndex1, "puk", crno,6);
			dao.setProcOutValue(procIndex1, "err", 1,7);
			dao.setProcOutValue(procIndex1, "resultset", 2,8);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		if(key.equalsIgnoreCase("hrstr_json_data")){
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}
                		else{
                			js.put(key, value);
                		}
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          //mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          ja.put(mainObj);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static ArrayList<JSONObject> getPatientEHRDtlsForTemplatePrescription(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code, String admNo) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 ="";
    	if(admNo.equals("0"))
    		proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
    	else
    		proc_name1 = "{call pkg_ipddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "6",1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            if(admNo.equals("0"))
            {
            	dao.setProcOutValue(procIndex1, "err", 1,8);
            	dao.setProcOutValue(procIndex1, "resultset", 2,9);
            }
            else
            {
            	dao.setProcInValue(procIndex1, "admno", admNo,8);
            	dao.setProcOutValue(procIndex1, "err", 1,9);
            	dao.setProcOutValue(procIndex1, "resultset", 2,10);
            }
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	//status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		js.put(key, value);
                		
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
            
              }
         
          mainObj.put("pat_details", jsonolist);
          
          ja.put(mainObj);
           if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return jsonolist ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return jsonolist;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	
	public static ArrayList<JSONObject> getPatientEHRDtlsForTemplatePrescription1(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code, String admNo) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "";
    	if(admNo.equals("0"))
    		proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
    	else
    		proc_name1 = "{call pkg_ipddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "8",1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            if(admNo.equals("0"))
            {
            	dao.setProcOutValue(procIndex1, "err", 1,8);
            	dao.setProcOutValue(procIndex1, "resultset", 2,9);
            }
            else
            {
            	dao.setProcInValue(procIndex1, "admno", admNo,8);
            	dao.setProcOutValue(procIndex1, "err", 1,9);
            	dao.setProcOutValue(procIndex1, "resultset", 2,10);
            }
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	//status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		js.put(key, value);
                		
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
            
              }
         
          mainObj.put("pat_details", jsonolist);
          
          ja.put(mainObj);
           if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return jsonolist ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return jsonolist;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }

	
	public static ArrayList<JSONObject> getAdmissionAdvice(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "7",1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				 //System.out.println("lengthb:::::::::"+length);
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	//status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		js.put(key, value);
                		
                		j++;
                	}
                	//System.out.println(js.toString());	
                	jsonolist.add(js) ;
                	
                }
            
              }
         
          if(ws != null){
        		ws.close();
        		ws = null;
        	}          
          //System.out.println(jsonolist);
             return jsonolist ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return jsonolist;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }

	public static String getPatVitalDataDtlsForDetailedPrescription(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		if(j%2 != 0){
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}
                		else{
                			js.put(key, value);
                		}
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
              
              }

          mainObj.put("pat_vital_details", jsonolist);
          
          ja.put(mainObj);
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatVitalDataDtlsForDetailedPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	public static String getIpdPatVitalDataDtlsForDtlPrescription(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code, String admNo) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_ipddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("getIpdPatVitalDataDtlsForDtlPrescription crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcInValue(procIndex1, "admno", admNo,8);
            dao.setProcOutValue(procIndex1, "err", 1,9);
            dao.setProcOutValue(procIndex1, "resultset", 2,10);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		if(j%2 != 0){
                			JSONParser parser = new JSONParser();
                    		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                    		js.put(key, json);
                		}
                		else{
                			js.put(key, value);
                		}
                		j++;
                	}

                	jsonolist.add(js) ;
                	
                }
              
              }

          mainObj.put("pat_vital_details", jsonolist);
          
          ja.put(mainObj);
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
             return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatVitalDataDtlsForDetailedPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	public static String getHospitalHeaderName(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
		String strproc_name = "{call pkg_opdDrDesk_view.proc_dept_dtl(?,?,?,?,?,?,?)}";
		HisDAO dao = null;
		HisUtil util = null;

		int nProcIndex = 0 ,length=0;

		String strErr = "";
		WebRowSet ws = null;
		 JSONObject mainObj = new JSONObject();
	        
		 JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();

		try {
			util = new HisUtil("OPDDRDRDESk",
					"DoctorDeskDAO()");
			dao = new HisDAO("MMS",
					"transactions.DoctorDeskDAO..setItemCatValues()");
			
			nProcIndex = dao.setProcedure(strproc_name);
			dao.setProcInValue(nProcIndex, "modeval", "8",1);
			dao.setProcInValue(nProcIndex, "hosp_code", hosp_code,2);
			dao.setProcInValue(nProcIndex, "seat_id", "0",3);
			dao.setProcInValue(nProcIndex, "deptCode", "",4);
			dao.setProcInValue(nProcIndex, "Room_No", "",5);
			dao.setProcOutValue(nProcIndex, "err", 1,6);
			dao.setProcOutValue(nProcIndex, "resultset", 2,7);
			dao.executeProcedureByPosition(nProcIndex);

			strErr = dao.getString(nProcIndex, "err");

			if(strErr.equals(""))
			{
				ws = dao.getWebRowSet(nProcIndex, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		//if(key.equalsIgnoreCase("HRSTR_JSON")){
                			JSONParser parser = new JSONParser();
                			if(value!=null) {
                			//	org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                				js.put(key, value);
                			}else {
                				js.put(key, "{}");
                			}
                    		
                    		
						/*
						 * } else { js.put(key, value); }
						 */
                		j++;
                	
                	}
                	jsonolist.add(js) ;
                	
                }
              
              }

          mainObj.put("pat_vital_details", jsonolist);
          
          ja.put(mainObj);
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}    
             //System.out.println(jsonolist.toString());
             return jsonolist.toString();
        }
        catch (Exception e) {
        	e.printStackTrace();
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatVitalDataDtlsForDetailedPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
	}
		


	
	public static String getpdfForDigiLocaker(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "5",1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		//if(key.equalsIgnoreCase("HRSTR_JSON")){
                			JSONParser parser = new JSONParser();
                			if(value!=null) {
                				
                				if(key.equalsIgnoreCase("HRSTR_JSON") || key.equalsIgnoreCase("VITAL_DATA") ){
                				org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                				js.put(key, json);
                			}else {
                				js.put(key, value);
                			}
                				
                			}else {
                				js.put(key, "{}");
                			}
                    		
                    		
						/*
						 * } else { js.put(key, value); }
						 */
                		j++;
                	
                	}
                	jsonolist.add(js) ;
                	
                }
              
              }

          mainObj.put("pat_vital_details", jsonolist);
          
          ja.put(mainObj);
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}    
             //System.out.println(jsonolist.toString());
             return jsonolist.toString();
        }
        catch (Exception e) {
        	e.printStackTrace();
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatVitalDataDtlsForDetailedPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }
	
	
	public static String getPatUmidData(String mode,String crno,  String hosp_code) {
    	/* Get EHR Details */
    	String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_Details(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JsonObject jsonObject3 = null,jsonObject4=null;
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         JsonArrayBuilder arrayBuilder =null;
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatUmidData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", "",3);
            dao.setProcInValue(procIndex1, "visitNo", "",4);
            dao.setProcInValue(procIndex1, "seatId", "",5);
            dao.setProcInValue(procIndex1, "entrydate", "",6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {
            	  int j=0;
                	status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		if(key.equalsIgnoreCase("umid_data")) {
                		JSONParser parser = new JSONParser();
                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
                		js.put(key, json);
                		}else {
                			js.put(key, value);
                		}
                		
                	}
                	jsonolist.add(js) ;               	
                	
                }
              //ja.put(jsonolist);
              }
          //System.out.println("jsonolist"+jsonolist);
          
         
          mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
     	 
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
            return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","EHRDetailsDAO.getPatUmidData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }

	public static ArrayList<JSONObject> getPatientEHRInvestigationDtl(String modval, String crNo, String episodeCode, String visitNo,
			String seatId, String entrydate, String hosp_code) {
		
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_inv_dup_dtl(?,?,?,?,? ,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        JSONObject mainObj = new JSONObject();
         
         JSONArray ja = new JSONArray();
         ArrayList<String> columnlist = new ArrayList<String>();
         ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
         int length=0;
        try {
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatientEHRInvestigationDtl");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", "1",1);
            dao.setProcInValue(procIndex1, "crno", crNo,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				 //System.out.println("lengthb:::::::::"+length);
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
          if (ws != null && ws.size() > 0) {
        	  
              while (ws.next()) {
            	    int j=0;
                	//status="1";
                	JSONObject js=new JSONObject();
                	for (int i=1;i<=length;i++)
                	{
                		String key=columnlist.get(i-1);
                		String value=ws.getString(i);
                		
                		js.put(key, value);
                		
                		j++;
                	}
                	System.out.println(js.toString());	
                	jsonolist.add(js) ;
                	
                }
            
              }
         
          if(ws != null){
        		ws.close();
        		ws = null;
        	}          
          //System.out.println(jsonolist);
             return jsonolist ;
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatientEHRDtlsForPastPrescription()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return jsonolist;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
    }


	public static String getInternalReferralPatientData(String departmentCode, String departmentUnitCode,String hosp_code) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_Internal_Referral_Patient_Dt(?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray jsonolist = new JSONArray();
         int length=0;
        try {
        	
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getInternalReferralPatientData()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "departmentCode", departmentCode,1);
            dao.setProcInValue(procIndex1, "departmentUnitCode", departmentUnitCode,2);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,3);
            dao.setProcOutValue(procIndex1, "err", 1,4);
            dao.setProcOutValue(procIndex1, "resultset", 2,5);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				jsonolist=printJSONObject(ws);
			}
          
         
          mainObj.put("status", status);
          mainObj.put("pat_details", jsonolist);
          if(ws != null){
       		ws.close();
       		ws = null;
          }          
          return mainObj.toString();
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getInternalReferralPatientData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return mainObj.toString();
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
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


	public static JSONObject getCRNoWiseExternalReferralData(String modVal, String crNo, 
			String episodeCode, String visitNo, String seatId,
			String hosp_code,String referStatus) {
		String err = "";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_CRNo_Wise_External_Referral_Data(?,?,?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        
         
         String status="0";
         JSONObject mainObj = new JSONObject();
         
         JSONArray jsonolist = new JSONArray();         
        try {
        	
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.getCRNoWiseExternalReferralData()");
            procIndex1 = dao.setProcedure(proc_name1);
            int i=1;
            dao.setProcInValue(procIndex1, "modVal", modVal,i++);
            dao.setProcInValue(procIndex1, "crNo", crNo,i++);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,i++);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,i++);
            dao.setProcInValue(procIndex1, "seatId", seatId,i++);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,i++);
            dao.setProcInValue(procIndex1, "referStatus", referStatus,i++);
            dao.setProcOutValue(procIndex1, "err", 1,i++);
            dao.setProcOutValue(procIndex1, "resultset", 2,i++);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				jsonolist=printJSONObject(ws);
				status="1";
			}
          
         
          mainObj.put("status", status);
          mainObj.put("data", jsonolist);
          if(ws != null){
       		ws.close();
       		ws = null;
          }          
         
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","EHRDetailsDAO.getCRNoWiseExternalReferralData()-->", e.getMessage() + "-->" + e);
            e.printStackTrace(); 
            try {
				mainObj.put("status", "0");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        return mainObj;
	}
	
public static List<String> get_pat_prescription_html_details(String mode,String crno, String episodeCode, String visitNo, String seatId, String entrydate, String hosp_code, int pmode) {
    	
		//System.out.println("inside EHRDetailsDAO.get_pat_prescription_html_details");
		
    	String err = "";
    	String htmlbase64="";
    	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_prescription_html_details(?,?,?,?,?,?,?,?,?)}";
        int procIndex1 = 0;
        HisDAO dao = null;
        WebRowSet ws = null;
        List<String> lst= new ArrayList<String>();
        
        if(entrydate==null|| entrydate.equals("null") || entrydate.trim().equals("0") || entrydate.trim().equals("")) {
        	entrydate="0";
        }
         
        try {
        	
        	//System.out.println("crno::::::::::::::"+crno);
            dao = new HisDAO("WebServices", "EHRDetailsDAO.get_pat_prescription_html_details()");
            procIndex1 = dao.setProcedure(proc_name1);
            dao.setProcInValue(procIndex1, "modeval", mode,1);
            dao.setProcInValue(procIndex1, "crno", crno,2);
            dao.setProcInValue(procIndex1, "episodeCode", episodeCode,3);
            dao.setProcInValue(procIndex1, "visitNo", visitNo,4);
            dao.setProcInValue(procIndex1, "seatId", seatId,5);
            dao.setProcInValue(procIndex1, "entrydate", entrydate,6);
            dao.setProcInValue(procIndex1, "hosp_code", hosp_code,7);
            dao.setProcOutValue(procIndex1, "err", 1,8);
            dao.setProcOutValue(procIndex1, "resultset", 2,9);
            //dao.executeProcedureByPosition(procIndex1);
            
            dao.executeProcedureByPosition(procIndex1);
            err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");				
				
			}
		//	System.out.println("");
          if (ws != null && ws.size() > 0) {
              while (ws.next()) {       
            	  if(pmode==1) {
            	  htmlbase64= ws.getString(1);
            	  }
            	  else {
            		  htmlbase64= ws.getString(2);
            	  }
            	  lst.add(htmlbase64);
                }
           //   System.out.println("inside lst.size====" + lst.size());
              }
         
        
             if(ws != null){
        		ws.close();
        		ws = null;
        	}          
           
        }
        catch (Exception e) {
        	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
            e.printStackTrace();
            return null;
        }
        finally {
        	if (dao != null) {
                dao.free();
                dao = null;
            }
        }
        return lst;
    }


public static JSONObject getPreviousPatientReviewData(String crNo, String episodeCode, String visitNo, String seatId,
		String hosp_code) {
	String err = "";
	String proc_name1 = "{call pkg_opddrdesk_view.get_CRNo_Wise_Previous_Patient_Review_Data(?,?,?,?,?,?,?)}";
    int procIndex1 = 0;
    HisDAO dao = null;
    WebRowSet ws = null;
    
     
     String status="0";
     JSONObject mainObj = new JSONObject();
     
     JSONArray jsonolist = new JSONArray();         
    try {
    	
    	//System.out.println("crno::::::::::::::"+crno);
        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPreviousPatientReviewData()");
        procIndex1 = dao.setProcedure(proc_name1);
        int i=1;
        dao.setProcInValue(procIndex1, "crNo", crNo,i++);
        dao.setProcInValue(procIndex1, "episodeCode", episodeCode,i++);
        dao.setProcInValue(procIndex1, "visitNo", visitNo,i++);
        dao.setProcInValue(procIndex1, "seatId", seatId,i++);
        dao.setProcInValue(procIndex1, "hosp_code", hosp_code,i++);        
        dao.setProcOutValue(procIndex1, "err", 1,i++);
        dao.setProcOutValue(procIndex1, "resultset", 2,i++);
        
        dao.executeProcedureByPosition(procIndex1);
        err=dao.getString(procIndex1, "err");
		if(err.equals(""))
		{
			ws = dao.getWebRowSet(procIndex1, "resultset");
			jsonolist=printJSONObject(ws);
			status="1";
		}
      
     
      mainObj.put("status", status);
      mainObj.put("data", jsonolist);
      if(ws != null){
   		ws.close();
   		ws = null;
      }          
     
    }
    catch (Exception e) {
    	HisException eObj = new HisException("OPD Ver-2.0","EHRDetailsDAO.getPreviousPatientReviewData()-->", e.getMessage() + "-->" + e);
        e.printStackTrace(); 
        try {
			mainObj.put("status", "0");
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    finally {
    	if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    return mainObj;
}

public static String getBendataFromPoolSmartQMS(String departmentCode, String departmentUnitCode,String hosp_code) {
	String err = "";
	String proc_name1 = "{call appointment.pkg_online_queue_dtl.getbendata_frm_pool(?,?,?,?,?)}";
    int procIndex1 = 0;
    HisDAO dao = null;
    WebRowSet ws = null;
     
     String status="0";
     JSONObject mainObj = new JSONObject();
     
     JSONArray jsonolist = new JSONArray();
     
    try {
    	
    	//System.out.println("crno::::::::::::::"+crno);
        dao = new HisDAO("WebServices", "EHRDetailsDAO.getBendataFromPool()");
        procIndex1 = dao.setProcedure(proc_name1);
        int indx=1;
        dao.setProcInValue(procIndex1, "modevalue", "1",indx++);
        dao.setProcInValue(procIndex1, "hospitalcode", hosp_code,indx++);
        dao.setProcInValue(procIndex1, "deptunitid", departmentUnitCode,indx++);        
        dao.setProcOutValue(procIndex1, "err", 1,indx++);
        dao.setProcOutValue(procIndex1, "resultset", 2,indx++);
        
        dao.executeProcedureByPosition(procIndex1);
        err=dao.getString(procIndex1, "err");
		if(err.equals(""))
		{
			ws = dao.getWebRowSet(procIndex1, "resultset");
			jsonolist=printJSONObject(ws);
			status="1";
			mainObj.put("pat_details", jsonolist);
		}
       
             
     
    }
    catch (Exception e) {
    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getBendataFromPool()-->", e.getMessage() + "-->" + e);
        e.printStackTrace();
        status="0";
        
    }
    finally {
    	try {
			mainObj.put("status", status);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(ws != null){
    	   		try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	   		ws = null;
    	      }  
    	if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    return mainObj.toString();
}


public static String getBendataFromPoolWithoutSmartQMS(String departmentCode, String departmentUnitCode,String hosp_code) {
	String err = "";
	String proc_name1 = "{call pkg_opdDrDesk_view_primary.Proc_PickFromPoolWithoutSmartQUeue(?,?,?,?,?)}";
    int procIndex1 = 0;
    HisDAO dao = null;
    WebRowSet ws = null;
     
     String status="0";
     JSONObject mainObj = new JSONObject();
     
     JSONArray jsonolist = new JSONArray();
     
    try {
    	
    	//System.out.println("crno::::::::::::::"+crno);
        dao = new HisDAO("WebServices", "EHRDetailsDAO.getBendataFromPool()");
        procIndex1 = dao.setProcedure(proc_name1);
        int indx=1;
        dao.setProcInValue(procIndex1, "modevalue", "1",indx++);
        dao.setProcInValue(procIndex1, "hospitalcode", hosp_code,indx++);
        dao.setProcInValue(procIndex1, "deptunitid", departmentUnitCode,indx++);        
        dao.setProcOutValue(procIndex1, "err", 1,indx++);
        dao.setProcOutValue(procIndex1, "resultset", 2,indx++);
        
        dao.executeProcedureByPosition(procIndex1);
        err=dao.getString(procIndex1, "err");
		if(err.equals(""))
		{
			ws = dao.getWebRowSet(procIndex1, "resultset");
			jsonolist=printJSONObject(ws);
			status="1";
			mainObj.put("pat_details", jsonolist);
		}
       
             
     
    }
    catch (Exception e) {
    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getBendataFromPool()-->", e.getMessage() + "-->" + e);
        e.printStackTrace();
        status="0";
        
    }
    finally {
    	try {
			mainObj.put("status", status);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(ws != null){
    	   		try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	   		ws = null;
    	      }  
    	if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    return mainObj.toString();
}


public static JSONObject getSectionBookmarks(String jsonData) {
	String err = "";
	String proc_name1 = "{call opd.pkg_opddrdesk_view.get_section_wise_bookmark(?,?,?,?,?,?)}";
    int procIndex1 = 0;
    HisDAO dao = null;
    WebRowSet ws = null;
    /*
    (p_modeval character varying DEFAULT NULL::character varying, 
    		p_seatId character varying, p_hospital_code character varying, p_bookmark_ids character varying, 
    		OUT err character varying, INOUT resultset refcursor)
     */
     String status="ERROR";
     JSONObject mainObj = new JSONObject();
     
     
     
    try {
    	JSONObject parajson = new JSONObject(jsonData);
    	JSONArray jsonolist = new JSONArray();
    	//System.out.println("crno::::::::::::::"+crno);
        dao = new HisDAO("WebServices", "EHRDetailsDAO.getSectionBookmarks()");
        procIndex1 = dao.setProcedure(proc_name1);
        int indx=1;
        dao.setProcInValue(procIndex1, "p_modeval", parajson.getString("mode"),indx++);
        dao.setProcInValue(procIndex1, "p_seatId", parajson.getString("seatTd") ,indx++);
        dao.setProcInValue(procIndex1, "p_hospital_code", parajson.getString("hospitalCode") ,indx++);
        dao.setProcInValue(procIndex1, "p_bookmark_ids", parajson.getString("bookmarkTypeIds") ,indx++);
        dao.setProcOutValue(procIndex1, "err", 1,indx++);
        dao.setProcOutValue(procIndex1, "resultset", 2,indx++);
        
        dao.executeProcedureByPosition(procIndex1);
        err=dao.getString(procIndex1, "err");
		if(err.equals(""))
		{
			ws = dao.getWebRowSet(procIndex1, "resultset");
			jsonolist=printJSONObject(ws);
			status="SUCCESS";
			mainObj.put("data", jsonolist);
		}
       
             
     
    }
    catch (Exception e) {
    	HisException eObj = new HisException("OPD Ver-2.0","EHRDetailsDAO.getSectionBookmarks()-->", e.getMessage() + "-->" + e);
        e.printStackTrace();
        status="ERROR";
        
    }
    finally {
    	try {
			mainObj.put("status", status);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 if(ws != null){
    	   		try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	   		ws = null;
    	      }  
    	if (dao != null) {
            dao.free();
            dao = null;
        }
    }
    return mainObj;
}


public static String getPatinetEHRAllDtls(String mode,String crno) {
	/* Get EHR Details */
	String err = "";
	String proc_name1 = "{call pkg_opddrdesk_view.get_pat_ehr_all_Details(?,?,?,?)}";
    int procIndex1 = 0;
    HisDAO dao = null;
    WebRowSet ws = null;
    JsonObject jsonObject3 = null,jsonObject4=null;
     
     String status="0";
     JSONObject mainObj = new JSONObject();
     
     JSONArray ja = new JSONArray();
     JsonArrayBuilder arrayBuilder =null;
     ArrayList<String> columnlist = new ArrayList<String>();
     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
     int length=0;
    try {
    	
    	////System.out.println("crno::::::::::::::"+crno);
        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
        procIndex1 = dao.setProcedure(proc_name1);
        dao.setProcInValue(procIndex1, "modeval", mode,1);
        dao.setProcInValue(procIndex1, "crno", crno,2);
        dao.setProcOutValue(procIndex1, "err", 1,3);
        dao.setProcOutValue(procIndex1, "resultset", 2,4);
        //dao.executeProcedureByPosition(procIndex1);
        
        dao.executeProcedureByPosition(procIndex1);
        err=dao.getString(procIndex1, "err");
		if(err.equals(""))
		{
			ws = dao.getWebRowSet(procIndex1, "resultset");
			 length=	ws.getMetaData().getColumnCount();
			for(int i=1;i<=length;i++)
			{
				columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
			}
			
		}
      if (ws != null && ws.size() > 0) {
          while (ws.next()) {
        	  int j=0;
            	status="1";
            	JSONObject js=new JSONObject();
            	for (int i=1;i<=length;i++)
            	{
            		String key=columnlist.get(i-1);
            		String value=ws.getString(i);
            		if(key.equalsIgnoreCase("hrstr_json_data")) {
            		JSONParser parser = new JSONParser();
            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
            		js.put(key, json);
            		}else {
            			js.put(key, value);
            		}
            		
            	}
            	jsonolist.add(js) ;               	
            	
            }
          //ja.put(jsonolist);
          }
      ////System.out.println("jsonolist"+jsonolist);
      
     
      mainObj.put("status", status);
      mainObj.put("pat_details", jsonolist);
      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
 	 
    
         if(ws != null){
    		ws.close();
    		ws = null;
    	}          
        return mainObj.toString();
    }
    catch (Exception e) {
    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
        e.printStackTrace();
        return mainObj.toString();
    }
    finally {
    	if (dao != null) {
            dao.free();
            dao = null;
        }
    }
}

	
	public static String getBenDetailsDAO(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_ben_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        //dao.executeProcedureByPosition(procIndex1);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	          while (ws.next()) {
	        	  int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		if(key.equalsIgnoreCase("hrstr_json_data")) {
	            		JSONParser parser = new JSONParser();
	            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	            		js.put(key, json);
	            		}else {
	            			js.put(key, value);
	            		}
	            		
	            	}
	            	jsonolist.add(js) ;               	
	            	
	            }
	          //ja.put(jsonolist);
	          }
	      ////System.out.println("jsonolist"+jsonolist);
	      
	     
	      mainObj.put("status", status);
	      mainObj.put("pat_details", jsonolist);
	      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
	 	 
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	        return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	}
	
	public static String getPatVitalDataDtlsForEMR(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_ben_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	    	  
	          while (ws.next()) {
	        	    int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		
	            		////System.out.println("Key: " + key + ", Value: " + value);
	            		if(j%2 != 0){
	            			JSONParser parser = new JSONParser();
	                		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	                		js.put(key, json);
	                		////System.out.println("Parsed JSON for key: " + key);
	            		}
	            		else{
	            			js.put(key, value);
	            		}
	            		j++;
	            	}
	
	            	jsonolist.add(js) ;
	            	
	            }
	          
	          }
	
	      mainObj.put("pat_vital_details", jsonolist);
	      
	      ja.put(mainObj);
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	         return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatVitalDataDtlsForDetailedPrescription()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	    
	
	}
	
	public static String getPatINVDataForEMRDAO(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_investigation_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        //dao.executeProcedureByPosition(procIndex1);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	          while (ws.next()) {
	        	  int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		if(key.equalsIgnoreCase("hrstr_json_data")) {
	            		JSONParser parser = new JSONParser();
	            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	            		js.put(key, json);
	            		}else {
	            			js.put(key, value);
	            		}
	            		
	            	}
	            	jsonolist.add(js) ;               	
	            	
	            }
	          //ja.put(jsonolist);
	          }
	      ////System.out.println("jsonolist"+jsonolist);
	      
	     
	      mainObj.put("status", status);
	      mainObj.put("pat_details", jsonolist);
	      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
	 	 
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	        return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	}
	
	public static String getPatReffDataForEMRDAO(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_Refferal_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        //dao.executeProcedureByPosition(procIndex1);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	          while (ws.next()) {
	        	  int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		if(key.equalsIgnoreCase("hrstr_json_data")) {
	            		JSONParser parser = new JSONParser();
	            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	            		js.put(key, json);
	            		}else {
	            			js.put(key, value);
	            		}
	            		
	            	}
	            	jsonolist.add(js) ;               	
	            	
	            }
	          //ja.put(jsonolist);
	          }
	      ////System.out.println("jsonolist"+jsonolist);
	      
	     
	      mainObj.put("status", status);
	      mainObj.put("pat_reff_details", jsonolist);
	      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
	 	 
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	        return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	}
	
	public static String getDepartmentUnitForEMR(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_Refferal_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        //dao.executeProcedureByPosition(procIndex1);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	          while (ws.next()) {
	        	  int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		if(key.equalsIgnoreCase("hrstr_json_data")) {
	            		JSONParser parser = new JSONParser();
	            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	            		js.put(key, json);
	            		}else {
	            			js.put(key, value);
	            		}
	            		
	            	}
	            	jsonolist.add(js) ;               	
	            	
	            }
	          //ja.put(jsonolist);
	          }
	      ////System.out.println("jsonolist"+jsonolist);
	      
	     
	      mainObj.put("status", status);
	      mainObj.put("pat_reff_details", jsonolist);
	      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
	 	 
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	        return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	}
	
	public static String getDrugDTLSEMR(String mode,String crno) {
		/* Get EHR Details */
		String err = "";
		String proc_name1 = "{call emr.pkg_ehr_services.get_pat_all_drugs_details(?,?,?,?)}";
	    int procIndex1 = 0;
	    HisDAO dao = null;
	    WebRowSet ws = null;
	    JsonObject jsonObject3 = null,jsonObject4=null;
	     
	     String status="0";
	     JSONObject mainObj = new JSONObject();
	     
	     JSONArray ja = new JSONArray();
	     JsonArrayBuilder arrayBuilder =null;
	     ArrayList<String> columnlist = new ArrayList<String>();
	     ArrayList<JSONObject> jsonolist = new ArrayList<JSONObject>();
	     int length=0;
	    try {
	    	
	    	////System.out.println("crno::::::::::::::"+crno);
	        dao = new HisDAO("WebServices", "EHRDetailsDAO.getPatinetEHRDtls()");
	        procIndex1 = dao.setProcedure(proc_name1);
	        dao.setProcInValue(procIndex1, "modeval", mode,1);
	        dao.setProcInValue(procIndex1, "crno", crno,2);
	        dao.setProcOutValue(procIndex1, "err", 1,3);
	        dao.setProcOutValue(procIndex1, "resultset", 2,4);
	        //dao.executeProcedureByPosition(procIndex1);
	        
	        dao.executeProcedureByPosition(procIndex1);
	        err=dao.getString(procIndex1, "err");
			if(err.equals(""))
			{
				ws = dao.getWebRowSet(procIndex1, "resultset");
				 length=	ws.getMetaData().getColumnCount();
				for(int i=1;i<=length;i++)
				{
					columnlist.add(ws.getMetaData().getColumnName(i).toUpperCase());
				}
				
			}
	      if (ws != null && ws.size() > 0) {
	          while (ws.next()) {
	        	  int j=0;
	            	status="1";
	            	JSONObject js=new JSONObject();
	            	for (int i=1;i<=length;i++)
	            	{
	            		String key=columnlist.get(i-1);
	            		String value=ws.getString(i);
	            		if(key.equalsIgnoreCase("hrstr_json_data")) {
	            		JSONParser parser = new JSONParser();
	            		org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(value);
	            		js.put(key, json);
	            		}else {
	            			js.put(key, value);
	            		}
	            		
	            	}
	            	jsonolist.add(js) ;               	
	            	
	            }
	          //ja.put(jsonolist);
	          }
	      ////System.out.println("jsonolist"+jsonolist);
	      
	     
	      mainObj.put("status", status);
	      mainObj.put("pat_all_drug_details", jsonolist);
	      //jsonObject3 =  Json.createObjectBuilder().add("status", status).add("pat_dealis", Json.createArrayBuilder().add(jsonolist.toString())).build();
	 	 
	    
	         if(ws != null){
	    		ws.close();
	    		ws = null;
	    	}          
	        return mainObj.toString();
	    }
	    catch (Exception e) {
	    	HisException eObj = new HisException("OPD Ver-2.0","getPatinetEHRDtls.getPatinetEHRDtls()-->", e.getMessage() + "-->" + e);
	        e.printStackTrace();
	        return mainObj.toString();
	    }
	    finally {
	    	if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }
	}
	

	public static JSONObject updateReferralDisableSatatus(String crNo, String episodeCode,
			String strReffralExtId,String refID, String disableStatus, String disableRemark ) {
		
		System.out.println("Input JSON: \n"); 
	    JSONObject response = new JSONObject();
	    // Updated stored procedure name and parameters
	    String strproc_name = "{call pkg_opddesk_dml.update_Referral_Disable_Satatus(?,?,?,?,?,?,?)}";
	    HisDAO dao = null;
	    int nProcIndex = 0;
	    String strErr = "";
	    try {
	    	
	        // Initialize DAO
	        dao = new HisDAO("DRDESK", "updateReferralDisableSatatus");

	        nProcIndex = dao.setProcedure(strproc_name);
	        
	            dao.setProcInValue(nProcIndex, "crNo", crNo,1);
	            dao.setProcInValue(nProcIndex, "episodeCode", episodeCode,2);
	            dao.setProcInValue(nProcIndex, "refID", refID,3);
	            dao.setProcInValue(nProcIndex, "disableStatus", disableStatus,4);
	            dao.setProcInValue(nProcIndex, "strReffralExtId", strReffralExtId,5);
	            dao.setProcInValue(nProcIndex, "disableRemark", disableRemark,6);
	            dao.setProcOutValue(nProcIndex, "err", 1,7);                                      
	
	        dao.executeProcedureByPosition(nProcIndex);

	        // Retrieve the error message from the procedure
	        strErr = dao.getString(nProcIndex, "err");

	        // Check for errors
	        if (strErr != null && !strErr.equals("")) {
	            throw new Exception(strErr);

	        }
	        response.put("message", "1");
	        
	    } catch (Exception _Err) {
	        // Log the exception
	        new HisException("OPD Lite", "updateReferralDisableSatatus -->", _Err.getMessage() + "-->" + _Err);
	        _Err.printStackTrace();

	        // Error response
	        try {
	            response.put("message", "problem while saving!");
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	    } finally {
	        // Clean up DAO resources
	        if (dao != null) {
	            dao.free();
	            dao = null;
	        }
	    }

	    return response;
	}
}
