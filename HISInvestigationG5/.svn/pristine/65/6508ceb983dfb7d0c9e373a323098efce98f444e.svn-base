package HisWeb.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import hisglobal.utility.Base64Utils;
import HisWeb.vo.DataVO;
import HisWeb.vo.Filter;
import HisWeb.vo.LabReportDataVO;

public class WsHttpClient {

	
	public DataVO postAndGet(String url, String userName,String password, Filter objFilter) throws Exception {

		DataVO objDataVO = new DataVO();
	 	
		URL object = new URL( url);
		String json="";
		try{
			Gson gson = new Gson();
			json = gson.toJson(objFilter, Filter.class);
			}
			catch(Exception e){
				e.printStackTrace();				
			}
		
		//System.out.println("json--" + json);
		
		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestProperty("Content-Type", "text/plain");
		con.setRequestMethod("POST");

		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "+ String.valueOf(Base64Utils.encode((userName + ":" + password))));
		}

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		
		 
		StringBuilder sb = new StringBuilder("");
		int HttpResult = con.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			
			String line = null;
			
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			//System.out.println(" res >> " + sb.toString());
			
			if(sb!=null && sb.length()>0){
				try{
					Gson gson = new Gson();
					objDataVO = gson.fromJson(sb.toString(), DataVO.class);
					}
					catch(Exception e){
						
						e.printStackTrace();
					}
			}			
			
		} else {
			//System.out.println(con.getResponseMessage());
			
		}

		//System.out.println("\nURL url:-->" + url);
		//System.out.println("\nResponse Code :--> " + HttpResult);
		
		
		
		return objDataVO;

	}
	
	public static String postAndGet(String url, String requestContent,
			String userName, String password) throws Exception {

		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		URL object = new URL( url);

		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "text/plain");
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestMethod("POST");

		
		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "
							+ String.valueOf(Base64Utils.encode((userName + ":" + password))));
		}

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

	public static String get(String url, String userName, String password)
			throws Exception {
		StringBuilder sb = new StringBuilder("");
		URL object = null;
		System.out.println("Inside http");
		try {

			
			 object = new URL( url);

			HttpURLConnection con = (HttpURLConnection) object.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			//con.setRequestProperty("Content-Type", "text/plain");
			//con.setRequestProperty("Accept", "text/plain");
			con.setRequestMethod("GET");

			System.out.println("before if");
			
			if (userName != null && userName.trim().length() > 0) {
				con.setRequestProperty(
						"Authorization",
						"Basic "
								+ Base64Utils.encode((userName + ":" + password)));
			}

			con.connect();
			int responseCode = con.getResponseCode();

			//System.out.println("\nURL GlobalVariable:-->" + url);
			//System.out.println("\nResponse Code :--> " + responseCode);

			int HttpResult = con.getResponseCode();
			if (HttpResult == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						con.getInputStream(), "utf-8"));
				String line = null;
				while ((line = br.readLine()) != null) {
					sb.append(line);
				}
				br.close();
				System.out.println("inside if");
			} else {
				//System.out.println(con.getResponseMessage());
				
			}

		} catch (Exception e) {

			throw e ;
		}
		System.out.println("before return");
		return sb.toString();
	}


	
	public DataVO post(String url, String userName,String password, Filter objFilter) throws Exception {

		DataVO objDataVO = new DataVO();
	 	java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		URL object = new URL( url);
		String json="";
		try{
			Gson gson = new Gson();
			json = gson.toJson(objFilter, Filter.class);
			}
			catch(Exception e){
				e.printStackTrace();				
			}
		
		//System.out.println("json--" + json);
		
		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestMethod("POST");
		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "+ String.valueOf(Base64Utils.encode((userName + ":" + password))));
		}

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(json.toString());
		wr.flush();
		StringBuilder sb = new StringBuilder("");
		int HttpResult = con.getResponseCode();
		if (HttpResult == HttpURLConnection.HTTP_OK) {
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			
			String line = null;
			
			
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			br.close();
			//System.out.println("" + sb.toString());
			
			if(sb!=null && sb.length()>0){
				try{
				Gson gson = new Gson();
				objDataVO = gson.fromJson(sb.toString(), DataVO.class);
				}
				catch(Exception e){
					e.printStackTrace();					
				}
			}			
			
		} else {
			//System.out.println(con.getResponseMessage());
			
		}

		//System.out.println("\nURL url:-->" + url);
		//System.out.println("\nResponse Code :--> " + HttpResult);
		return objDataVO;

	}
	
	
	public static String  postAndGetInJson(String url, String requestContent,
			String userName, String password) throws Exception {

		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		LabReportDataVO labReportDataVO = new LabReportDataVO();
		
		URL object = new URL( url);

		HttpURLConnection con = (HttpURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");

		
		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "
							+ String.valueOf(Base64Utils.encode((userName + ":" + password))));
		}

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestContent);
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
			System.out.println("" + sb.toString());
		} else {
			System.out.println(con.getResponseMessage());
		}

		
		
		return sb.toString();

	}

	
	
}
