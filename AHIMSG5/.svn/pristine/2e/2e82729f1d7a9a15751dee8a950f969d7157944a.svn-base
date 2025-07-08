package hisglobal.FormFlowX.dao;

import java.sql.SQLException;
import java.util.Date;

import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.FormFlowX.util.Usefulmethods;
import hisglobal.transactionmgnt.HisDAO;

public class FormFlowXDAO {

	public JSONObject getDataByProcedure(String procedureName, JSONObject objFilterJson)	 {

		String callString=null;

		String printquery=null;
		String errMsgCode=null;
		JSONObject objDataJson = null;
		JSONArray arrData = new JSONArray();

		HisDAO hisDao = null;
		WebRowSet ws = null;
		String errMsg=null;
		try {

			hisDao = new HisDAO("ABDM QMS", procedureName);

			if (objFilterJson != null && objFilterJson.length() > 0) {
				objDataJson = new JSONObject(objFilterJson.toString());
			} else {
				objDataJson = new JSONObject();
			}

			
			int procIndex = hisDao.setProcedure("{call " + procedureName + "(?,?,?,?,?)}");

			hisDao.setProcInValue(procIndex, "strFilterJson", (objFilterJson != null ? objFilterJson.toString() : null));
			hisDao.setProcOutValue(procIndex, "p_resultset", 2);
			hisDao.setProcOutValue(procIndex, "p_prntqry", 1);
			hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1);
			hisDao.setProcOutValue(procIndex, "p_ErrCode", 1);

			callString = "declare";
			callString += "\n p_resultset refcursor;";
			callString += "\n p_prntqry character varying;";
			callString += "\n p_ErrMsg character varying;";
			callString += "\n p_ErrCode character varying;";
			callString += "\n begin";
			callString += "\n" + procedureName + "(";

			callString += objFilterJson != null ? "'" + objFilterJson.toString() + "'," : "null";

			callString += "p_resultset,";
			callString += "p_prntqry,";
			callString += "p_ErrMsg,";
			callString += "p_ErrCode);";
			callString += "\ndbms_output.put_line('p_prntqry--' || p_prntqry);";
			callString += "\ndbms_output.put_line('p_ErrMsg--' || p_ErrMsg);";
			callString += "\ndbms_output.put_line('p_ErrCode--' || p_ErrCode);";
			callString += "\n end;";
			
			objDataJson.put("calledqueryOrfunction", callString);
			long startTime = System.currentTimeMillis();
			
			
			hisDao.executeProcedure(procIndex);
			
			 printquery  = hisDao.getString(procIndex, "p_prntqry");
			errMsg  = hisDao.getString(procIndex, "p_ErrMsg");
			 errMsgCode  = hisDao.getString(procIndex, "p_ErrCode");
			
			ws = hisDao.getWebRowSet(procIndex, "p_resultset");
			long endTime = System.currentTimeMillis();
			arrData = Usefulmethods.printJSONObject(ws);

			
			objDataJson.put("timestamp", (new Date()));
			objDataJson.put("data", arrData);

			if (arrData.length() == 0) {
				objDataJson.put("message", "No Data Found !");
			}
			else {
				if(StringUtils.isEmpty(errMsg))
						objDataJson.put("message", "SUCCESS");
				else
					objDataJson.put("message", errMsg);				
			}
			 
			
			String Execution_time_in_milisec = (endTime - startTime) + "";
			objDataJson.put("Execution_time_in_milisec", Execution_time_in_milisec);
			//objDataJson.put("printquery", printquery);
			//System.out.println("query --" + printquery);
			objDataJson.put("errMsgCode", errMsgCode);
			

		} catch (Exception e) {
			System.out.println(callString);
			System.out.println("query --" + printquery);
			System.out.println("p_ErrMsg --" + errMsg);
			System.out.println("errMsgCode --" + errMsgCode);
		
			System.out.println(e.getMessage());
			if(errMsg==null) {
				try {
					objDataJson.put("message", "Problem while getting record !");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("errMsgCode --" + e.getMessage());
				
			}
			e.printStackTrace();
			System.out.println("Exception in DataWebServiceDAO.getDataByProcedure--> "+ e.getMessage());
				
		} finally {

			if (ws != null) {
				try {
					ws.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ws = null;
			}

			if (hisDao != null) {
				hisDao.free();
				hisDao = null;
			}

		}

		return objDataJson;
	}
	
	

	public JSONObject callDMLProcedure(String procedureName, JSONObject objInputJson) throws Exception {
		
		
		JSONObject objDataJson = null;
		HisDAO hisDao = null;
		String callString=null;
		try {
			hisDao = new HisDAO("AHIMSG5", procedureName);
			if (objInputJson != null) {
				if (objInputJson != null && objInputJson.length() > 0) {
					objDataJson = new JSONObject(objInputJson.toString());
					;
				} else {
					objDataJson = new JSONObject();
				}
				
				int procIndex = hisDao.setProcedure("{call " + procedureName + "(?,?,?,?)}");
				
				hisDao.setProcInValue(procIndex, "inputJson", (objInputJson != null ? objInputJson.toString() : null));
				hisDao.setProcOutValue(procIndex, "p_ReturnValue", 1);
				hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1);
				hisDao.setProcOutValue(procIndex, "p_ErrCode", 1);
				

				 callString = "declare";
				callString += "\n p_ReturnValue character varying;";
				callString += "\n p_ErrMsg character varying;";
				callString += "\n p_ErrCode character varying;";
				callString += "\n begin";
				callString += "\n" + procedureName + "(";

				callString += "'" + objInputJson.toString() + "',";
				
				callString += "p_ReturnValue,";
				callString += "p_ErrMsg,";
				callString += "p_ErrCode);";

				callString += "\ndbms_output.put_line('p_ErrMsg--' || p_ErrMsg);";
				callString += "\ndbms_output.put_line('p_ErrCode--' || p_ErrCode);";
				callString += "\n end;";
				objDataJson.put("calledqueryOrfunction", callString);

				long startTime = System.currentTimeMillis();
				
				
				hisDao.executeProcedure(procIndex);
				String returnValue = hisDao.getString(procIndex, "p_ReturnValue");
				String errMsg  = hisDao.getString(procIndex, "p_ErrMsg");
				String errMsgCode  = hisDao.getString(procIndex, "p_ErrCode");

				
				long endTime = System.currentTimeMillis();

				String Execution_time_in_milisec = (endTime - startTime) + "";
				objDataJson.put("Execution_time_in_milisec", Execution_time_in_milisec);
				objDataJson.put("errMsgCode", errMsgCode);
				objDataJson.put("message", errMsg);
				objDataJson.put("returnValue", returnValue);
				

			}

			// System.out.println("serviceName=="+serviceName+" query--" + fetchQuery);

		} catch (Exception e) {
			e.printStackTrace();
			//System.out.println("serviceName=="+serviceName)
			System.out.println(callString);
			
			System.out.println("Exception in DataWebServiceDAO.callDMLProcedure--> "+ e.getMessage());
		} finally {

			if (hisDao != null) {
				hisDao.free();
				hisDao = null;
			}

		}

		return objDataJson;

	}
	

	
	
	
}