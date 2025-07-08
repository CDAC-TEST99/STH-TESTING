package new_opd.transaction.controller.data;



import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.ResultSetMetaData;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.config.HISConfig;
import hisglobal.presentation.ControllerDATA;
import hisglobal.vo.UserVO;
import new_opd.bo.DoctorDeskBO;
import new_opd.transaction.controller.fb.OPDQMSFB;
import new_opd.vo.DoctorDeskVO;

public class OPDQMSDATA extends ControllerDATA {
	
	
	public static void getDeptDtlData(OPDQMSFB formBean,
			HttpServletRequest request) {
		DoctorDeskVO vo=null;
		DoctorDeskBO bo=null;
		Map<String, String> DeptCmb=null;
		request.getSession().removeAttribute("deptJsonArr");	
		try
		{
			vo=new DoctorDeskVO();
			bo=new DoctorDeskBO();
			String HsopitalCode=(String) request.getSession().getAttribute("HOSPITAL_CODE");
			String SeatId=(String) request.getSession().getAttribute("SEATID");
			vo.setStrHospitalCode(HsopitalCode);
			vo.setStrSeatId(SeatId);
			
			bo.getDeptForQMS(vo);
		
			if(vo.getStrMsgType().equals("1"))
			{
				throw new Exception();
			}
			
				DeptCmb=new LinkedHashMap<String, String>();
				if(vo.getStrDeptWb().size()>0)
				{
					String deptJsonArr= printJSONObject(vo.getStrDeptWb());
					request.getSession().setAttribute("deptJsonArr", deptJsonArr);		
					/*while (vo.getStrDeptWb().next()) {
						DeptCmb.put(vo.getStrDeptWb().getString(1), vo.getStrDeptWb().getString(2));
						
					}*/
				}
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
	
	public static void writeInResponse(HttpServletResponse response,	String strResult, boolean isJson) {
		try {
			response.flushBuffer();
			if (isJson)
				response.setContentType("application/json");
			response.setHeader("Cache-Control", "no-cache");
			PrintWriter writer = response.getWriter();
			writer.write(strResult);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String printJSONObject(WebRowSet ws ) throws Exception {
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
	  		    // System.out.println(e.getMessage());
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
	    return arr.toString();
	  }

}

