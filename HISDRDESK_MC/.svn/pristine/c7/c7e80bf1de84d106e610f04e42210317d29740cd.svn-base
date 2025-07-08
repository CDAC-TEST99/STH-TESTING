package HisWeb.webservice;

import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/opdqms")
public class OPDQMS {
	
	private static JSONObject jsonQueue = new JSONObject();
	
	
	@POST
	@Path("/displayFromQueue")   
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })	
	public Response displayFromQueue(String JsonData ) throws JSONException, ParseException{
		boolean status=false;
		JSONArray objarrRespose= new JSONArray();
		
		try {
			JSONArray objarr= new JSONArray(JsonData);
			
			if(objarr.length()>0) {
				for(int i=0;i<objarr.length();i++) {
					JSONObject obj= objarr.getJSONObject(i);
					String departmentUnitCode= obj.getString("departmentUnitCode");
					String hospitalCode= obj.getString("hospitalCode");
					String key=hospitalCode+"_"+departmentUnitCode;
					String strjson =jsonQueue.getString(key);
					obj.put("queueNoJson", strjson);
					objarrRespose.put(obj);
				}
				status=true;
			}
			
		}catch(Exception e ) {
			
		}
		
		
		
		
		if(status) {
		 return Response.ok()
	               .entity(objarrRespose.toString())
	               .header("Access-Control-Allow-Origin", "*")
	               .build();
		}
		else {
			return Response
	                .status(Response.Status.BAD_REQUEST)	                
	                .build();			 
		}
	}
	
	
	public static String callPatient(String JsonData ) throws JSONException, ParseException{
		
		
		JSONObject resultObject= new JSONObject();
		resultObject.put("status", "ERROR");
		try {
			JSONObject inputJson= new JSONObject(JsonData);
			String  departmentUnitCode= inputJson.getString("departmentUnitCode");
			
			String hospitalCode= inputJson.getString("hospitalCode");
			String key=hospitalCode+"_"+departmentUnitCode;
			
			String  queueNoJson= inputJson.getString("queueNoJson");
			jsonQueue.put(key, queueNoJson);
			
			resultObject.put("status", "SUCCESS");
			
		}catch(Exception e ) {
			
		}
		
		
		return resultObject.toString();
		
	}
}