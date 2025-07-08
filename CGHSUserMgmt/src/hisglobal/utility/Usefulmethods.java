package hisglobal.utility;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Clob;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;

import hisglobal.transactionmgnt.HisDAO;


public class Usefulmethods {

	public static String realPath;

	public static String serviceServerDtl=null;
	public static String serviceuserName=null;
	public static String servicePassword=null;
	public static String fileName="config.Configuration";
	
	public static void writeInResponse(HttpServletResponse response,
			String strResult, boolean isJson) {
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

	public static String clobStringConversion(Clob clb) throws Exception {
		StringBuffer str = new StringBuffer(5000);
		String strng = null;
		String resultStr = null;
		BufferedReader bufferRead = null;

		try {
			if (clb == null) {
				System.out.println("clb is null");
				return null;
			}
			bufferRead = new BufferedReader(clb.getCharacterStream());

			while ((strng = bufferRead.readLine()) != null)
				str.append(strng);

			resultStr = str.toString();

		} catch (Exception e) {
			resultStr = null;
			e.printStackTrace();
		} finally {
			if (bufferRead != null) {
				try {
					bufferRead.close();
					bufferRead = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (clb != null) {
				clb = null;
			}
		}
		return resultStr;
	}

	public static String populateQuery(String query, List<String> condition)
			throws SQLException {
		if (condition != null) {
			for (String entryObj : condition) {
				query = query.replaceFirst("\\?", entryObj);
			}
		}
		System.out.println("query =" + query);
		return query;
	}

	public static String getQuery(String _filename, String _queryKey)
			 {
		ResourceBundle rb=null;
		try {
			rb = loadPropertiesFile(_filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("_queryKey"+_queryKey);
		String query = rb.getString(_queryKey).trim();
		// System.out.println("query in getQuery(String _filename,String _queryKey):: "+query);
		return query;
	}

	public static ResourceBundle loadPropertiesFile(String _fileName)
			throws Exception {
		// System.out.println("fileName::::::::::::::::::::::::::::");
		String BUNDLE_NAME = _fileName;
		// System.out.println("fileName"+_fileName);
		ResourceBundle rb = ResourceBundle.getBundle(BUNDLE_NAME);
		try {

		} catch (MissingResourceException e) {
		}

		return rb;
	}

	
	public static void populate(Object obj1, Object obj2) {// data from object2
															// is populated into
															// obj1
		// getter of object2 is called
		// setter of object1 is called

		Class cls2 = obj2.getClass();

		Method[] cls2Methods = cls2.getMethods();

		HashMap mpGettersInCls2 = new HashMap();
		for (int i = 0; i < cls2Methods.length; i++) {
			if (cls2Methods[i].getName().indexOf("get") == 0) {// if the method
																// name starts
																// with set
				mpGettersInCls2.put(cls2Methods[i].getName().substring(3),
						new Integer(i));
			}
		}

		Class cls1 = obj1.getClass();
		Method[] cls1Methods = cls1.getMethods();

		try {
			for (int i = 0; i < cls1Methods.length; i++) {
				// System.out.println("cls1Methods[i].getName().indexOf(set):  "+cls1Methods[i].getName().indexOf("set"));
				if (cls1Methods[i].getName().indexOf("set") == 0) {// if the
																	// method
																	// name
																	// starts
																	// with set
					if (mpGettersInCls2.containsKey(cls1Methods[i].getName()
							.substring(3))) {
						// System.out.println("pos2 of "+i);
						int idx = ((Integer) mpGettersInCls2.get(cls1Methods[i]
								.getName().substring(3))).intValue();
						// System.out.println("pos3 of "+i+" cls1Methods[i].getName():  "+cls1Methods[i].getName()+"  cls2Methods[idx].getName():  "+cls2Methods[idx].getName());
						Object str = cls2Methods[idx].invoke(obj2, null);
						// System.out.println("pos4 of "+i +"  str: "+ str);
						try{
						cls1Methods[i].invoke(obj1, new Object[] { str });
						}
						catch(Exception e){
							continue;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("after populate ");
	}

	/*
	 * public static String getFolderStrusture(int status) { return realPath; }
	 */
	public static String getFolderStrusture(int status) {

		String location = "";
		java.io.File dirName = null;
		String fileSeparator = null;
		try {
			
			location=getFolderStrustureBasedOnOS();
			fileSeparator = "/";
			dirName = new java.io.File(location);
			if (!dirName.exists()) {
				dirName.mkdirs();
			}
			location = location + fileSeparator;
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			dirName = null;
		}
		
		return location;

	}

	// for pagination
	public static String settingthepageStringForMasters(int block, int page,
			int recordPerPage, int pagesPerBlock, int recordcount) {
		String Str = "<div id='div_pagination'>";

		int TotalNopages = (recordcount % recordPerPage == 0) ? recordcount
				/ recordPerPage : recordcount / recordPerPage + 1;
		int totalNoBlock = (TotalNopages % pagesPerBlock == 0) ? TotalNopages
				/ pagesPerBlock : TotalNopages / pagesPerBlock + 1;

		// System.out.println("TotalNopages  ="+TotalNopages+"  totalNoBlock="+totalNoBlock+" block="+block+" page="+page
		// + " recordPerPage="+recordPerPage + " pagesPerBlock=" +
		// pagesPerBlock);
		int intpageNo = (((block * pagesPerBlock) - pagesPerBlock) + 1);
		int finalpageNo = ((((block * pagesPerBlock) - pagesPerBlock) + 1) + pagesPerBlock) - 1;
		if (block > 1) {
			int prevPageNo = intpageNo - 1;
			Str += Str += "<a id='ACRPAGINATION_" + prevPageNo + "_"
					+ (block - 1)
					+ "' style='color:blue;cursor:pointer' >Prev</a>";
		}

		if (finalpageNo > TotalNopages)
			finalpageNo = TotalNopages;
		for (int i = intpageNo; i <= finalpageNo; i++) {
			if (i == page) {
				Str += "&nbsp;<a id='ACRPAGINATION_" + i + "_" + block
						+ "' style='color:red;cursor:default;'>" + i + "</a>";
			} else
				Str += "&nbsp;<a id='ACRPAGINATION_" + i + "_" + block
						+ "' style='color:blue;cursor:pointer;'>" + i + "</a>";

		}
		if (totalNoBlock != 0 && block != totalNoBlock) {
			int nextpageNo = finalpageNo + 1;
			if (nextpageNo > TotalNopages)
				nextpageNo = TotalNopages;

			Str += "&nbsp;<a id='ACRPAGINATION_" + nextpageNo + "_"
					+ (block + 1)
					+ "' style='color:blue;cursor:pointer;'>next</a>";
		}
		Str += "</div>";
		// System.out.println("Str   ="+Str);
		return Str;
	}

	/* function for getting image file as byte array */
	public byte[] getBytesFromFile(String filePath) {
		byte[] bytes = null;
		try {
			File file = new File(filePath);
			InputStream is = new FileInputStream(file);

			// Get the size of the file
			long length = file.length();

			if (length > Long.MAX_VALUE) {
				// File is too large
			}

			// Create the byte array to hold the data
			bytes = new byte[(int) length];

			// Read in the bytes
			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			// Ensure all the bytes have been read in
			if (offset < bytes.length) {
				throw new IOException("Could not completely read file "
						+ file.getName());
			}

			// Close the input stream and return bytes
			is.close();
		} catch (FileNotFoundException ex) {
			System.out.println("FileNotFoundException : " + ex);
		} catch (IOException ioe) {
			System.out.println("IOException : " + ioe);
		}
		return bytes;
	}

	public static Map sortMapByComparator(Map unsortMap) {
		Map sortedMap = new LinkedHashMap();
		if (unsortMap != null && unsortMap.size() > 0) {
			List list = new LinkedList(unsortMap.entrySet());
			// sort list based on comparator
			Collections.sort(list, new Comparator() {
				public int compare(Object o1, Object o2) {
					return ((Comparable) ((Map.Entry) (o1)).getValue())
							.compareTo(((Map.Entry) (o2)).getValue());
				}
			});
			// put sorted list into map again
			// LinkedHashMap make sure order in which keys were inserted

			for (Iterator it = list.iterator(); it.hasNext();) {
				Map.Entry entry = (Map.Entry) it.next();
				sortedMap.put(entry.getKey(), entry.getValue());

			}
		}
		// printMap(sortedMap);
		return sortedMap;
	}




	public static void deletePreviousbackupFile(String backupPath){
		File dest = null;
		try{
			dest = new File(backupPath);
			if (dest.exists()) {
				try {
					FileUtils.deleteDirectory(dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}catch(Exception e){			
			e.printStackTrace();
		}
		finally{
			dest=null;
		}
		
	}

	public static String decode(String s) {
		
		if(s!=null && !s.trim().equals(""))
			return new String( Base64Utils.base64Decode(s) );
		else
			return s;
	}

	public static String encode(String s) {
		if(s!=null && !s.trim().equals(""))
			return Base64Utils.base64Encode(s.getBytes());
		else
			return "";
	}


	public static void viewFileFromFTP(String ftpPath_p, String ftpFileName_p,	HttpServletResponse response) throws IOException {

		InputStream io = null;
		OutputStream os = response.getOutputStream();
	 
		try {

			
			String ftpFileName = decode(ftpFileName_p);
			String ftpPath = decode(ftpPath_p)+"/"+ftpFileName;
			System.out.println("ftpPath===" + ftpPath);
			
			String ext = ftpFileName.substring(ftpFileName.lastIndexOf("."),
					ftpFileName.length());

			URL urlftp = new URL(ftpPath);
			URLConnection urlc = urlftp.openConnection();
			io = urlc.getInputStream();

			 

			if (ext.equalsIgnoreCase(".JPG") || ext.equalsIgnoreCase(".JPEG")
					|| ext.equalsIgnoreCase(".GIF")) {
				response.setContentType("image/jpg");
			} else {
				response.setContentType("application/octet-stream");
			}

			response.setHeader("Content-Disposition", "attachment;filename=\""
					+ ftpFileName + "\"");


			byte[] buffer = new byte[1024];
			int bytesRead = 0;
			while ((bytesRead = io.read(buffer)) != -1) {

				os.write(buffer, 0, bytesRead);
			}
			 
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (io != null)
				io.close();
			os.close();
		 
			io = null;
			os = null;

		}

	}
	
	
	

	public static String getFolderStrustureBasedOnOS() {

		String location = "";
		try {
			java.util.Properties p = null;
			p = System.getProperties();
			// ...Checking the Operating System
			String filename = "config.Configuration";
			if (p.getProperty("os.name").indexOf("Windows") == -1) {
				// in case of Linux
				location = Usefulmethods.getQuery(filename, "XMLLOCATIONLINUX");
				
			} else {
				location = Usefulmethods.getQuery(filename,	"XMLLOCATIONWINDOWS");
				
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} 
		
		return location;

	}
	public static void setEmptyToNull(Object obj)
	{
		Class cls = obj.getClass();
		Method[] clsMethods = cls.getMethods();
		String arg[]=new String[]{""};
		List <String> methodList=new ArrayList<String>();
		for (int i = 0; i < clsMethods.length; i++)
		{
			if (clsMethods[i].getName().indexOf("get") == 0)
			{
				try
				{
					if (clsMethods[i].invoke(obj, null) == "")
					{
						Class returnType=clsMethods[i].getReturnType();
						//System.out.println(clsMethods[i].getDeclaringClass());
						if (returnType==String.class && clsMethods[i].getDeclaringClass()==cls) {
							setNull(obj, clsMethods[i].getName().substring(3));
						}	
					}
				}// end try
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}// end if getname
		}// end of for
		
	}
	public static void setNull(Object obj,String methodName)
	{
		Class cls = obj.getClass();
		Method[] clsMethods = cls.getMethods();
		String arg[]=new String[]{null};
		for (int i = 0; i < clsMethods.length; i++)
		{
			if (clsMethods[i].getName().indexOf("set") == 0)
			{
				try
				{
					//System.out.println("Method Name : " + clsMethods[i].getName());
					if (clsMethods[i].getName().substring(3).equalsIgnoreCase(methodName))
					{
						clsMethods[i].invoke(obj, arg);
						
					}
				}// end try
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}// end for
		
	}
public static boolean checkForSelectQueryOnly(String query){
	boolean flag=true;
	String arr[]={"UPDATE(.*?)TABLE","UPDATE(.*?)VIEW","DELETE(.*?)FROM", "INSERT(.*?)INTO", 
			"CREATE(.*?)TABLE","CREATE(.*?)VIEW", "CREATE(.*?)PROCEDURE", "CREATE(.*?)FUNCTION", "CREATE(.*?)PROCEDURE","CREATE(.*?)PACKAGE","CREATE(.*?)USER",
			"DROP(.*?)TABLE","DROP(.*?)VIEW", "DROP(.*?)PROCEDURE", "DROP(.*?)FUNCTION", "DROP(.*?)PROCEDURE","DROP(.*?)PACKAGE","DROP(.*?)USER",
			"ALTER(.*?)TABLE","ALTER(.*?)VIEW", "ALTER(.*?)PROCEDURE", "ALTER(.*?)FUNCTION", "ALTER(.*?)PROCEDURE","ALTER(.*?)PACKAGE","ALTER(.*?)USER",
			"TRUNCATE"};
	String []qrysplit=null;
	try{
		
		if(query!=null && !query.trim().equals("")){
			for(int i=0;i<arr.length;i++){
				Pattern scriptPattern =  Pattern.compile(arr[i],Pattern.CASE_INSENSITIVE);
				Matcher m =  scriptPattern.matcher(query);
				if (m.find()) 
				{
					flag=false;
					break;
				}
			}
		}		
		
	}catch(Exception e){
		flag=false;
		e.printStackTrace();
	}
	return flag;
}


public static String initCapString(final String input) {
    // Initialize the output to the length of the input since we know it and the
    // output and input will be the same size.
    StringBuilder output = new StringBuilder(input.length());
    // This defaults to true because we assume the beginning of the
    // string also counts as whitespace. This is to make sure the
    // first word gets capitalized as well.
    boolean lastCharacterWasWhitespace = true;

    for(int i = 0; i < input.length(); i++) {
        char currentCharacter = input.charAt(i);

        if(lastCharacterWasWhitespace && Character.isLowerCase(currentCharacter)) {
            currentCharacter = Character.toTitleCase(currentCharacter);
        }

        output.append(currentCharacter);

        lastCharacterWasWhitespace = Character.isWhitespace(currentCharacter);
    }

    return output.toString();
}
public static String getHeadingDisplayStyle(final String colName, final  String headingDisplayStyle ){
	String result="";
	if(headingDisplayStyle==null ||headingDisplayStyle.equals("asPerDataFromQuery"))
		result=colName;
	else if(headingDisplayStyle.equals("initCapitalLetter"))
		result= initCapString(colName);
	else if(headingDisplayStyle.equals("allCapitalLetter"))
		result=(colName.toUpperCase());
	return result;
}
public static String ConvertStringArrayToString(String []arr, String separater){
	String result=null;
	if(arr!=null && arr.length>0){
		result="";
		for(int i=0;i<arr.length;i++){
			result+=arr[i]+ separater;
		}
		// removing last separater
		if(result.length()>0)
			result=result.substring(0,result.length()-1);
		
	}
	return result;
}
public String getClassToJSON(Object obj1){
	String json="";
	try{
		Gson gson = new Gson();
		json = gson.toJson(obj1);
		
		}
		catch(Exception e){
			e.printStackTrace();				
			json=null;
		}
	return json;
}
public static String checkIfOneDashboardForExist(HttpServletRequest request){
	String dashboardFor=null;
	
		
	try{		
		String dashboardForstr=getQuery("config.Configuration", "DASHBOARD_FOR");
		String[] arr= dashboardForstr.split(",");
		if(arr.length==1){
			dashboardFor=Base64Utils.encode(arr[0]);
			request.getSession().setAttribute("DASHBOARD_FOR",arr[0]);
		}
		
	}catch(Exception e){			
		e.printStackTrace();
		dashboardFor=null;
	}
	finally{
	
	}
	return dashboardFor;
	
}

public static  String  SetAllignment(String s)
{
	try
    {
        Integer.parseInt(s);
        return "right";
    } catch (Exception ei)
    {
    	try{
    		Float.parseFloat(s);
    		return "right";
    	}
    	catch(Exception  ef ){
    		return "left";
    	}
    }
}

public static Date lastdate = null;
/*
public static void removeAllPrviousDateObjectsFromCache(){
	
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 String date=sdf.format(new Date());
	 try {
		 if(lastdate==null)
			 lastdate = sdf.parse(date);
		// System.out.println("lastdate--" + lastdate);
		 Date date2 = sdf.parse(date);
		 if (lastdate.compareTo(date2) < 0) {
            //System.out.println("lastdate--"+lastdate +" is before current Date --"+ date2);
            lastdate=date2;
            DashBoardEssensialManager.getInstance().removeAllFromDashBoard();
            DashBoardDataManager.getInstance().removeAllFromDashBoardDataObj();
	     }		
		 
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/


// new added function for data process

public static String convertObjectToJson(Object obj){
	String json=null;
	Gson gson = new Gson();
	try{
		if(obj!=null){
		try{
		json=gson.toJson(obj, Object.class);
		
		}catch(Exception e){
			e.printStackTrace();
			json=null;
		}
	}
	else
		json=null;
	}
	catch(Exception e){
		e.printStackTrace();
		json=null;
	}
	return json;
}
/*public String callService(Filter filtervo,String serviceName){
	String json="";
	try{
		
		if(isCallByHisUtilitiesWebService) {
			if(serviceServerDtl==null){
				serviceServerDtl=Usefulmethods.getQuery(fileName, "INTERNAL_DATASERVICE_URL");
				serviceuserName=Usefulmethods.getQuery(fileName, "INTERNAL_DATASERVICE_USER");
				servicePassword=Usefulmethods.getQuery(fileName, "INTERNAL_DATASERVICE_PASSWORD");
			}
			
			final String uri =serviceServerDtl +"/CGHSUserMgmt/services/restful"+ serviceName;
			
			if(uri.contains("https")){
				//System.out.println("https uri--"+ uri);
				WsHttpsClient objWsHttpsClient= new WsHttpsClient();
				json=objWsHttpsClient.postAndGet(uri, serviceuserName, servicePassword, filtervo);				
			}
			else{
				WsHttpClient objWsHttpClient= new WsHttpClient();
				json=objWsHttpClient.postAndGet(uri, serviceuserName, servicePassword, filtervo);					
			}
		}
		else {
			// calling directly without webservice
			
			String []arr=serviceName.replace("/", "#").split("#");
			serviceName=arr[arr.length-1];
			DataVO objDataVO= new DataVO();
			DataServiceVO objDataServiceVO=DataWebServiceDATA.getServiceConfigurationDetails(serviceName);
			if(objDataServiceVO==null) {
				objDataVO.setMsg("Problem In service");
				System.out.println("serviceName--- " +serviceName +" not found!");
			}else {
				if(objDataServiceVO.getModeOfQuery().equals("query") || objDataServiceVO.getModeOfQuery().equals("procedure")|| objDataServiceVO.getModeOfQuery().equals("function")){
					objDataVO=DataWebServiceDATA.QueryForData(filtervo, objDataServiceVO);
				}
				else {
					objDataVO=DataWebServiceDATA.DMLForData(filtervo, objDataServiceVO);
				}
			}
			try{
				if(objDataVO.getResultJSON()!=null && objDataVO.getResultJSON()!="") {
					json=	objDataVO.getResultJSON();
				}
				else {
					Gson gson = new Gson();
					json = gson.toJson(objDataVO, DataVO.class);
				}
			}
			catch(Exception e){
				e.printStackTrace();	
				json="{\"msg\":\"ERROR\"}";
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		json="{\"msg\":\"ERROR\"}";
	}
	return json;
}*/

public  WebRowSet executeQuery( String _query) throws Exception {
	
	HisDAO hisDao = null;
	WebRowSet rs = null;
		
	
	
	try{
		hisDao = new HisDAO("Master", "Data Service Master");
		int qryIndex = hisDao.setQuery(_query);
		rs = hisDao.executeQry(qryIndex);
		
		
	 
	 
	} catch (Exception e) {
		e.printStackTrace();
     	System.out.println("Exception in Usefulmethods.executeQuery--> "+ e.getMessage());
	} finally {

		

		if (hisDao != null) {
			hisDao.free();
			hisDao = null;
		}

	}
	

	
	
	
	return rs;
}
public static String randomString( int len )
{
	final String AB = "0123456789A1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z";
	Random rnd = new Random();
	StringBuilder sb = new StringBuilder( len );
   for( int i = 0; i < len; i++ ) 
      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
   return sb.toString();
}



public static JSONArray printJSONObject(CachedRowSet ws ) throws Exception {
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
  		     System.out.println(e.getMessage());
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

public JSONObject callService(JSONObject filtervo,String serviceName){
	JSONObject objDataJson = new JSONObject();
	
	try{
		
		String queryfilename=  "formFlowX.regQuery";
		String []arr=serviceName.split("/");
		String key=arr[arr.length-1];
		String str=Usefulmethods.getQuery(queryfilename, key);
		if(str!=null && !str.equals("")) {
			
		//	System.out.println(str);
			
			//#serviceNameForProcedure={"procedureType":"dml", "procedureName":"procedureNamehere"}
			JSONObject jsonobj= new JSONObject(str.trim());
			if(jsonobj.has("procedureType") && jsonobj.has("procedureName") ) {
				String procedureType=jsonobj.getString("procedureType");
				String procedureName= jsonobj.getString("procedureName");
				if(procedureType.equalsIgnoreCase("query")) {
					objDataJson=getDataByProcedure( procedureName,  filtervo);
				}
				else if(procedureType.equalsIgnoreCase("dml")) {
					objDataJson=callDMLProcedure( procedureName,  filtervo);
				}
				else {
					objDataJson.put("message", "ERROR : Procedure type or  procedure name Not Valid") ;
				}
			}
		}
		else {
			objDataJson.put("message", "ERROR : procedure key not found") ;			
		}
	
	}catch(Exception e){
		e.printStackTrace();
		objDataJson.put("message", "ERROR") ;
	}finally{
		if(objDataJson.has("calledqueryOrfunction"))
			objDataJson.remove("calledqueryOrfunction");
		if(objDataJson.has("printquery"))
			objDataJson.remove("printquery");
		
		if(objDataJson.has("Execution_time_in_milisec"))
			objDataJson.remove("Execution_time_in_milisec");
		if(objDataJson.has("seatId"))
			objDataJson.remove("seatId");
		if(objDataJson.has("hospitalCode"))
			objDataJson.remove("hospitalCode");
		
		
		
	}
	return objDataJson;
}
public static String validateServiceData(String filters) {
	JSONObject objFilterJson=null;
	
	try {
		objFilterJson=new JSONObject(filters);
		}catch(Exception e) {
			return "Please provide valid filters for getting data!";
		}
		if(!objFilterJson.has("serviceName")) {
			return "Please provide serviceName!";
		}
		if(!objFilterJson.has("processName")) {
			return "Please provide processName!";
		}
		
		if(!objFilterJson.has("seatId")) {
			return "Please provide  seatId!";
		}
		if(!objFilterJson.has("hospitalCode")) {
			return "Please provide  hospitalCode!";
		}
	return "SUCCESS";
}
public static String logABHAError(JSONObject inputData, JSONObject responseJson) {
	
	String logType="1";
	String strResponse=responseJson.toString();
		
	if(strResponse.toUpperCase().contains("ERROR") || strResponse.contains("{\"responseCode\":404}")|| strResponse.contains("{\"responseCode\":400}")|| strResponse.contains("{\"responseCode\":504}")|| 
			strResponse.contains("\"HttpStatus\":500") ||strResponse.contains("\"isSuccess\":0")   || strResponse.contains("{\"status\":\"0\"}") 
					||strResponse.contains("{\"responseCode\":500}") ) {
		inputData.put("logtype", "1");
		logType="1";
	}
	else {
		inputData.put("logtype", "2");
		logType="2";
	}
		
			
	try {
		Usefulmethods objUsefulmethods = new Usefulmethods();
		objUsefulmethods.callService(inputData, "/DMLSAVE/dmlServiceFailLog");
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("ERROR: Problem in saving logs");
	}
	return logType;	
	
}



public JSONObject getDataByProcedure(String procedureName, JSONObject objFilterJson)	 {

	JSONObject objDataJson = null;
	JSONArray arrData = new JSONArray();

	HisDAO hisDao = null;
	WebRowSet ws = null;
	String errMsg=null;
	String configfilename=  "config.Configuration";

	try {
		String debugMode=Usefulmethods.getQuery(configfilename, "MODE_DEBUG");

		hisDao = new HisDAO("CGHSUserMgmt", procedureName);

		if (objFilterJson != null && objFilterJson.length() > 0) {
			objDataJson = new JSONObject(objFilterJson.toString());
		} else {
			objDataJson = new JSONObject();
		}

		
		int procIndex = hisDao.setProcedure("{call " + procedureName + "(?,?,?,?,?)}");

		hisDao.setProcInValue(procIndex, "strFilterJson", (objFilterJson != null ? objFilterJson.toString() : null),1);
		hisDao.setProcOutValue(procIndex, "p_resultset", 2,2);
		hisDao.setProcOutValue(procIndex, "p_prntqry", 1,3);
		hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1,4);
		hisDao.setProcOutValue(procIndex, "p_ErrCode", 1,5);

		
			String callString = "declare";
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
		if(debugMode.equals("ON")) {
			System.out.println(callString);
		}
		objDataJson.put("calledqueryOrfunction", callString);
		
		long startTime = System.currentTimeMillis();
		
		
		hisDao.executeProcedureByPosition(procIndex);
		
		String printquery  = hisDao.getString(procIndex, "p_prntqry");
		errMsg  = hisDao.getString(procIndex, "p_ErrMsg");
		String errMsgCode  = hisDao.getString(procIndex, "p_ErrCode");
		
		ws = hisDao.getWebRowSet(procIndex, "p_resultset");
		long endTime = System.currentTimeMillis();
		arrData = Usefulmethods.printJSONObject(ws);

		
		objDataJson.put("timestamp", (new Date()));
		objDataJson.put("data", arrData);

		if (arrData.length() == 0) {
			objDataJson.put("message", "No Data Found !");
		}
		else
			objDataJson.put("message", "SUCCESS");
		 
		
		String Execution_time_in_milisec = (endTime - startTime) + "";
		objDataJson.put("Execution_time_in_milisec", Execution_time_in_milisec);
		objDataJson.put("printquery", printquery);
		objDataJson.put("message", errMsg);
		objDataJson.put("errMsgCode", errMsgCode);
		System.out.println("query --" + printquery);
		System.out.println("p_ErrMsg --" + errMsg);
		System.out.println("errMsgCode --" + errMsgCode);
		

	} catch (Exception e) {
		System.out.println(e.getMessage());
		if(errMsg==null) {
			objDataJson.put("message", "Problem while getting record !");
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
	String configfilename=  "config.Configuration";

	try {
		String debugMode=Usefulmethods.getQuery(configfilename, "MODE_DEBUG");
		hisDao = new HisDAO("CGHSUserMgmt", procedureName);
		if (objInputJson != null) {
			if (objInputJson != null && objInputJson.length() > 0) {
				objDataJson = new JSONObject(objInputJson.toString());
				;
			} else {
				objDataJson = new JSONObject();
			}
			
			int procIndex = hisDao.setProcedure("{call " + procedureName + "(?,?,?,?)}");
			
			hisDao.setProcInValue(procIndex, "inputJson", (objInputJson != null ? objInputJson.toString() : null),1);
			hisDao.setProcOutValue(procIndex, "p_ReturnValue", 1,2);
			hisDao.setProcOutValue(procIndex, "p_ErrMsg", 1,3);
			hisDao.setProcOutValue(procIndex, "p_ErrCode", 1,4);
			
			
				String callString = "declare";
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
				if(debugMode.equals("ON")) {	
					System.out.println(callString);
				}
				objDataJson.put("calledqueryOrfunction", callString);
			long startTime = System.currentTimeMillis();
			
			
			hisDao.executeProcedureByPosition(procIndex);
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


