package new_opd.transaction.controller.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import redisCache.RedisPatQueueList;

@WebServlet("/sse")
public class SSEServlet_old extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private static JSONObject queueJson= new JSONObject();
	private static boolean isRedisException=false;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/event-stream");
		response.setCharacterEncoding("UTF-8");
 
		PrintWriter out = response.getWriter();
		String currentDate=  getCurrentDate();
		
		while (true) {
			
			String encdata = request.getParameter("encdata");
			String JsonData="";
			if(encdata!=null)
				JsonData =new String(Base64.getDecoder().decode(encdata));
			
			JSONArray objarrRespose= new JSONArray();
		    
			try {
				JSONArray objarr= new JSONArray(JsonData);
				
				if(objarr.length()>0) {
					for(int i=0;i<objarr.length();i++) {
						JSONObject obj= objarr.getJSONObject(i);
						String departmentUnitCode= obj.getString("departmentunitcode");
						String hospitalCode= obj.getString("hospitalCode");
						String key ="qms_"+ hospitalCode+"_"+departmentUnitCode + "_" + currentDate;
						String strjson="";
						if(isRedisException==false) {
							strjson =RedisPatQueueList.getPatientQueueList(key);
						}
						/*
						 * else { //System.out.println("Redis server not working");
						 * strjson=queueJson.getString(key).toString(); }
						 */
						if(strjson!=null)
							obj.put("queueNoJson", strjson);
						objarrRespose.put(obj);
					}
				 
					out.write("data: " + objarrRespose.toString() + "\n\n");

					out.flush();
					
				}
				
			}catch(Exception e ) {
				e.printStackTrace();
			} 
			 
			
			try {
				Thread.sleep(5000); // Check every 5 second
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void addDataForDisplayBoard(String hospitalCode, String deptUnitCode, String queueJsonData) {
		String currentDate=  getCurrentDate();
		String key ="qms_"+ hospitalCode+"_"+deptUnitCode + "_" + currentDate;
		//System.out.println("data added for key "+key+" >> " + queueJsonData);
		if(isRedisException==false) {
			try {
	 		RedisPatQueueList.putPatientQueueList(key, queueJsonData);
			}catch(Exception e) {
				System.out.println("Redis server not working");
				isRedisException=true;					
			}
		}
		/*
		 * if(isRedisException) { try { queueJson.put(key, queueJsonData); } catch
		 * (JSONException e1) { // TODO Auto-generated catch block e1.printStackTrace();
		 * } }
		 */
		
	}
	public static void addDataForSMS(String hospitalCode, String deptUnitCode, String queueJsonData) {
		String currentDate=  getCurrentDate();
		String key ="smsqueue_"+ hospitalCode+"_"+deptUnitCode + "_" + currentDate;
		//System.out.println("data added for key "+key+" >> " + queueJsonData);
 		RedisPatQueueList.putPatientQueueList(key, queueJsonData);
	}
	public static String getCurrentDate() {
		 LocalDate currentDate = LocalDate.now();

	        // Define the desired date format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	        // Format the current date to the desired format
	        String formattedDate = currentDate.format(formatter);
	        return formattedDate;
	}
}
