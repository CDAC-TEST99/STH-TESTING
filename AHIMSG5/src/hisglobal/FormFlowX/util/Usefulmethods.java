package hisglobal.FormFlowX.util;



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
import org.json.JSONException;
import org.json.JSONObject;

import hisglobal.FormFlowX.dao.FormFlowXDAO;
import hisglobal.transactionmgnt.HisDAO;


public class Usefulmethods {

	public static String realPath;

	public static String serviceServerDtl=null;
	public static String serviceuserName=null;
	public static String servicePassword=null;
	public static String fileName="config.Configuration";
	private static final boolean isCallByHisUtilitiesWebService=false;
	
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
		//System.out.println("query =" + query);
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
	FormFlowXDAO objQMSDAO= new FormFlowXDAO();
	try{
		
		String queryfilename=  "hisglobal.FormFlowX.FormFlowXQuery";
		String []arr=serviceName.split("/");
		String key=arr[arr.length-1];
		String str=Usefulmethods.getQuery(queryfilename, key);
		if(str!=null && !str.equals("")) {
			//#serviceNameForProcedure={"procedureType":"dml", "procedureName":"procedureNamehere"}
			JSONObject jsonobj= new JSONObject(str);
			if(jsonobj.has("procedureType") && jsonobj.has("procedureName") ) {
				String procedureType=jsonobj.getString("procedureType");
				String procedureName= jsonobj.getString("procedureName");
				if(procedureType.equalsIgnoreCase("query")) {
					objDataJson=objQMSDAO.getDataByProcedure( procedureName,  filtervo);
					/*
					 * if(serviceName.equals("/getData/getGenderListBhavishya")) {
					 * System.out.println("/getData/getGenderListBhavishya response>>"
					 * +objDataJson.toString() ); }
					 */
					
				}
				else if(procedureType.equalsIgnoreCase("dml")) {
					objDataJson=objQMSDAO.callDMLProcedure( procedureName,  filtervo);
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
		try {
			objDataJson.put("message", "ERROR") ;
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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

public static String generateOTP(int length) {
    // Define the characters from which the OTP will be generated
    String characters = "0123456789";
    
    // Create a Random object
    Random random = new Random();
    
    // Initialize a StringBuilder to store the OTP
    StringBuilder otp = new StringBuilder();
    
    // Generate random digits and append them to the OTP
    for (int i = 0; i < length; i++) {
        int index = random.nextInt(characters.length());
        otp.append(characters.charAt(index));
    }
    
    // Convert the StringBuilder to a String and return the OTP
    return otp.toString();
}


}


