package alert;

import hisglobal.utility.HisUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlertClient
 */

public class AlertClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlertClient() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
	//	System.out.println("Älert Mode >>>>>>>>>>>>>>>>>>>>>> "+request.getParameter("mode"));
		
		
		if ("myAlrts".equals(request.getParameter("mode"))) {

			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) { /* report an error */
			}

			
			String responseContent = "";
			try{
				responseContent = postRequest("alertDetails/myAlerts" , jb.toString());
			}catch(Exception e){
				System.out.print("AlertClient >> alertDetails/myAlerts  >> ");
				System.err.println(e);
			}
			  
			 
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(responseContent);

		}
		
		
		if ("alrtDetails".equals(request.getParameter("mode"))) {

			StringBuffer jb = new StringBuffer();
			String line = null;
		
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) { /* report an error */
			}

			String responseContent = "";
			try{
				responseContent = postRequest("alertDetails" , jb.toString());
			}catch(Exception e){
				System.out.print("AlertClient >> alertDetails >> ");	
				System.err.println(e);
			}
			  
			
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(responseContent);

		}
		
		if ("update".equals(request.getParameter("mode"))) {

			StringBuffer jb = new StringBuffer();
			String line = null;
			try {
				BufferedReader reader = request.getReader();
				while ((line = reader.readLine()) != null)
					jb.append(line);
			} catch (Exception e) { /* report an error */
			}

			
			 
						 
			String responseContent = "";
			try{
				responseContent =  postRequest("alertDetails/update" , jb.toString());
			}catch(Exception e){
				System.out.print("AlertClient >> alertDetails/update >> ");	
				System.err.println(e);
			}
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(responseContent);

		}

	}

	private String postRequest(String url , String requestContent) throws IOException {

		String baseUrl = HisUtil.getParameterFromHisPathXML("ALERT_BASE_URL");

		URL object = new URL(baseUrl +url );

		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestContent.toString());
		wr.flush();

		// display what returns the POST request

		StringBuilder sb = new StringBuilder("");
		
		int HttpResult = con.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					con.getInputStream(), "utf-8"));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			//System.out.println("" + sb.toString());
		} else {
			//System.out.println(con.getResponseMessage());
		}

		return sb.toString();
		
	}

}
