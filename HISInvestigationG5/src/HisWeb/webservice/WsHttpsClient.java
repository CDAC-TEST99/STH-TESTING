package HisWeb.webservice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;




import com.google.gson.Gson;

import hisglobal.utility.Base64Utils;
import HisWeb.vo.DataVO;
import HisWeb.vo.Filter;
import HisWeb.vo.LabReportDataVO;
 

public class WsHttpsClient {

	
	public DataVO postAndGet(String url, String userName,String password, Filter objFilter) throws Exception {

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
		
		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestProperty("Content-Type", "text/plain");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
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

		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "text/plain");
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
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
		System.out.println("before try");
		try {

			java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
			 object = new URL( url);

			HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
			con.setDoOutput(true);
			con.setDoInput(true);
			// con.setRequestProperty("Content-Type", "text/plain");
			con.setRequestProperty("Accept", "text/plain");
			con.setRequestMethod("GET");

			SSLSocketFactory sslSocketFactory = createSslSocketFactory();
			con.setSSLSocketFactory(sslSocketFactory);
			
			
			if (userName != null && userName.trim().length() > 0) {
				con.setRequestProperty(
						"Authorization",
						"Basic "
								+ Base64Utils.encode((userName + ":" + password)));
			}
			System.out.println("inside try");

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
				//System.out.println("" + sb.toString());
			} else {
				System.out.println(con.getResponseMessage());
				
			}

		} catch (Exception e) {
			System.out.println("Inside catch");
			throw e ;
		}
		
		return sb.toString();
	}

	/*public void post(String url, String requestContent, String userName,
			String password) throws Exception {

	 	java.lang.System.setProperty("https.protocols", "TLSv1.2");
		URL object = new URL( url);

		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "text/xml");
		// con.setRequestProperty("Accept", "text/plain");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
		if (userName != null && userName.trim().length() > 0) {
			con.setRequestProperty(
					"Authorization",
					"Basic "+ String.valueOf(Base64.encode((userName + ":" + password).getBytes())));
		}

		OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
		wr.write(requestContent.toString());
		wr.flush();

		int HttpResult = con.getResponseCode();

		//System.out.println("\nURL url:-->" + url);
		//System.out.println("\nResponse Code :--> " + HttpResult);

	}*/
	
	
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
		
		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Accept", "text/plain");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
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

	private static SSLSocketFactory createSslSocketFactory() throws Exception {

		TrustManager[] byPassTrustManagers = new TrustManager[] { new X509TrustManager() {
			@Override
			public void checkClientTrusted(X509Certificate[] x509Certificates,
					String s) {

			}

			@Override
			public void checkServerTrusted(X509Certificate[] x509Certificates,
					String s) {

			}

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return new X509Certificate[0];
			}

		} };
		SSLContext sslContext = SSLContext.getInstance("TLS");
		sslContext.init(null, byPassTrustManagers, new SecureRandom());
		return sslContext.getSocketFactory();
	}
	
	
	public static String  postAndGetInJson(String url, String requestContent,
			String userName, String password) throws Exception {

		java.lang.System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
		
		LabReportDataVO labReportDataVO = new LabReportDataVO();
		
		URL object = new URL( url);

		HttpsURLConnection con = (HttpsURLConnection) object.openConnection();
		con.setDoOutput(true);
		con.setDoInput(true);
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestMethod("POST");

		SSLSocketFactory sslSocketFactory = createSslSocketFactory();
		con.setSSLSocketFactory(sslSocketFactory);
		
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
			System.out.println("" + sb.toString());
		} else {
			System.out.println(con.getResponseMessage());
		}
		
		
	

		return sb.toString();

	}
	/* public static void main(String[] args) {
		 
		 DataVO VO=new DataVO();
		 List <String>heading= new ArrayList<String>();
		 List <String>dataType= new ArrayList<String>();
		 
		 String data="";
		 heading.add(" State");
		 heading.add(" Edl(count in nos.)");
		 
		 List<String[]> dataValue= new ArrayList<String[]>();
		 
		 String [] arr={"Andhra Pradesh", "521"};
		 dataValue.add(arr);
		 
		 String [] arr1={"Bihar", "306"};
		 dataValue.add(arr1);
		 
		 dataType.add("string");
		 dataType.add("numeric");
		 
		 VO.setDataHeading(heading);
		 VO.setDataType(dataType);
		 VO.setDataValue(dataValue);
		 VO.setPrintQuery("serviceName==Statewise EDL Count query--select s.cwhstr_state_name AS STATE,\ndecode(s.cwhnum_state_id,72,\n(select COUNT(distinct EDL.cwhnum_drug_id) from dwh.cwht_unmap_edl_dtl EDL where edl.cwhnum_state_id = s.cwhnum_state_id and cwhnum_drug_id is not null\nand cwhnum_state_group_id not in(101025,101026,101027,101028,101029,101030,101031,101032) and cwhnum_state_group_id >= 101000 and cwhnum_state_group_id <= 101040\nand lower(cwhnum_state_itembrand_name) not  like '%surgical%' and lower(cwhnum_state_itembrand_name) not like '%suture%'\n)\n,(select COUNT(distinct EDL.cwhnum_drug_id) from dwh.cwht_unmap_edl_dtl EDL where edl.cwhnum_state_id = s.cwhnum_state_id and cwhnum_drug_id is not null)) AS \"EDL(Count In Nos.)\"\nfrom dwh.cwht_state_mst s\nwhere s.gnum_isvalid=1\nGROUP BY s.cwhnum_state_id, STATE order by STATE");
		 
		 try{
				Gson gson = new Gson();
				data = gson.toJson(VO, DataVO.class);
				}
				catch(Exception e){
					e.printStackTrace();				
				}
		 
		 //System.out.println("data--->" +data);
		// String data="{\"dataHeading\":[\" State\",\" Edl(count in nos.)\"],\"dataType\":[\"string\",\"numeric\"],\"dataValue\":[{\"item\":[\"Andhra Pradesh\",521]},{\"item\":[\"Bihar\",306]},{\"item\":[\"Gujarat\",570]},{\"item\":[\"Himachal Pradesh\",364]},{\"item\":[\"Jammu And Kashmir\",313]},{\"item\":[\"Jharkhand\",77]},{\"item\":[\"Madhya Pradesh\",237]},{\"item\":[\"Maharashtra\",638]},{\"item\":[\"Manipur\",225]},{\"item\":[\"Meghalaya\",292]},{\"item\":[\"Punjab\",197]},{\"item\":[\"Rajasthan\",563]},{\"item\":[\"Telangana\",622]},{\"item\":[\"Uttarakhand\",576]},{\"item\":[\"Uttar Pradesh\",233]}],\"printQuery\":\"serviceName==Statewise EDL Count query--select s.cwhstr_state_name AS STATE,\ndecode(s.cwhnum_state_id,72,\n(select COUNT(distinct EDL.cwhnum_drug_id) from dwh.cwht_unmap_edl_dtl EDL where edl.cwhnum_state_id = s.cwhnum_state_id and cwhnum_drug_id is not null\nand cwhnum_state_group_id not in(101025,101026,101027,101028,101029,101030,101031,101032) and cwhnum_state_group_id >= 101000 and cwhnum_state_group_id <= 101040\nand lower(cwhnum_state_itembrand_name) not  like '%surgical%' and lower(cwhnum_state_itembrand_name) not like '%suture%'\n)\n,(select COUNT(distinct EDL.cwhnum_drug_id) from dwh.cwht_unmap_edl_dtl EDL where edl.cwhnum_state_id = s.cwhnum_state_id and cwhnum_drug_id is not null)) AS \"EDL(Count In Nos.)\"\nfrom dwh.cwht_state_mst s\nwhere s.gnum_isvalid=1\nGROUP BY s.cwhnum_state_id, STATE order by STATE\"}";
		 
		 try{
				Gson gson = new Gson();
				VO = gson.fromJson(data, DataVO.class);
				}
				catch(Exception e){
					e.printStackTrace();
				}
		 //System.out.println(VO.getDataHeading());
	}
	 */
}
