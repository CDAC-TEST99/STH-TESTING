
package hisglobal.security;

import java.text.ParseException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.json.JSONArray;
import org.json.JSONObject;

import hisglobal.utility.Base64Utils;




/**
* The Class RequestWrapper.
*/
public final class RequestWrapper extends HttpServletRequestWrapper  {
	private static final String TOKEN_KEY = "dbfhttf";

	/**
	 * Instantiates a new request wrapper.
	 * 
	 * @param servletRequest
	 *            the servlet request
	 * @throws ParseException 
	 * @throws IllegalStateException 
	 * @throws Exception 
	 */
	public RequestWrapper(HttpServletRequest servletRequest)  
	{
		super(servletRequest);
		
		Enumeration requestheaderNames = servletRequest.getHeaderNames();
		//System.out.println("header--" + requestheaderNames);
		while (requestheaderNames.hasMoreElements())
		{
			String nextElement = (String) requestheaderNames.nextElement();
			//System.out.println(nextElement);
			String requestDataArray = servletRequest.getHeader(nextElement);
			//System.out.println(requestDataArray);
			cleanXSS(requestDataArray);
		}
		
		
		Enumeration requestParameters = servletRequest.getParameterNames();
		while (requestParameters.hasMoreElements())
		{
			String nextElement = (String) requestParameters.nextElement();
			String requestDataArray[] = servletRequest.getParameterValues(nextElement);
			if (requestDataArray.length != 0) 
				for (int i = 0; i < requestDataArray.length; i++)
					if (requestDataArray[i]!=null &&  !requestDataArray[i].trim().equals(""))
					{
						cleanXSS(requestDataArray[i]);
					}
		
		}
		
		
		checkTemparedData(servletRequest);
		
	}
	/**
	 * Clean xss.
	 * 
	 * @param value
	 *            the value
	 * @return the string
	 */
	private String cleanXSS(String value) 
	{
		
		//System.out.println(" RequestWrapper value :: "+value);
		
		Pattern scriptPattern = null;
		Matcher m = null;
		 //System.out.println("Two"+value);
		// You'll need to remove the spaces from the html entities below
		  //value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		  //value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
		//System.out.println("before"+value);
		  value = value.replaceAll("'", "");
		  //System.out.println("after"+value);
		  //value = value.replaceAll("'", "& #39;");
		  //value = value.replaceAll("eval\\((.*)\\)", "");
		  //value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
		  //value = value.replaceAll("script", "");
		  value = value.replaceAll("confirm", "").replaceAll("prompt", "").replaceAll("alert", "");

		// Avoid null characters
		value = value.replaceAll("", "");
		

		//System.out.println("Value Befor Pattern Match-->>"+value);
		
		// Avoid anything between script tags
		scriptPattern = Pattern.compile("<script>(.*?)</script>",Pattern.CASE_INSENSITIVE);
		m = scriptPattern.matcher(value);
		//value = scriptPattern.matcher(value).replaceAll("");
		
		if (m.find()) 
		{
			//System.out.println("Match Found--In Request Wrapper-1->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("1 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		/*scriptPattern = Pattern.compile("<[a-z]+>",Pattern.CASE_INSENSITIVE);*/
		scriptPattern = Pattern.compile("<.*>",Pattern.CASE_INSENSITIVE);
		m = scriptPattern.matcher(value);
		//value = scriptPattern.matcher(value).replaceAll("");
		
		if (m.find()) {
			if (!value.toLowerCase().startsWith("<table")){
				System.out.println("2 Illegal Value--" + value );
				throw new IllegalStateException("Illegal Activity Not Allowed !!");
			}
		}
		
		
		// Filter for 3 or more consecutive meta characters
		scriptPattern = Pattern.compile("[!@#\\$+()\\[\\]%\\^&*]{3,}");
		m = scriptPattern.matcher(value);		
		if (m.find()) {
			String temp = new String(value);
			temp = temp.replace("$$$", "")
					   .replace("^^^", "")
					   .replace("@@@", "")
					   .replace("###", "");
			m = scriptPattern.matcher(temp);
			if (m.find()) {
				System.out.println("3 Illegal Value--" + value );
				throw new IllegalStateException("Illegal Activity Not Allowed !!");
			}
		}

		// Avoid anything in a src='...' type of expression
		// scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",
		// Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");

		// scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"",
		// Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		// value = scriptPattern.matcher(value).replaceAll("");

		// Remove any lonesome </script> tag
		scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-2->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("4 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		// Remove any lonesome <script ...> tag
		scriptPattern = Pattern.compile("<script(.*?)>",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-2->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("5 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid eval(...) expressions
		scriptPattern = Pattern.compile("eval\\((.*?)\\)",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-3->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("6 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid expression(...) expressions
		scriptPattern = Pattern.compile("expression\\((.*?)\\)",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-4->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("7 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid javascript:... expressions
		scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper5->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("8 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid vbscript:... expressions
		scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-6->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("9 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}

		// Avoid onload= expressions
		scriptPattern = Pattern.compile("onload(.*?)=",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		//value = scriptPattern.matcher(value).replaceAll("");
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-7->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("10 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		scriptPattern = Pattern.compile("onblur(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		 m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-8->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("11 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		scriptPattern = Pattern.compile("onClick(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		
		
		m = scriptPattern.matcher(value);
		
		
		//onclick="setPARAMETERChildPresentation(this,event,'2','yes');"
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			
			//scriptPattern.
			System.out.println("12 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onmouseover(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("13 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onmousedown(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("14 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onchange(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("15 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("ondblclick(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("16 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onfocus(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("17 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onkeydown(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("18 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onkeyup(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("19 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onmouseout(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("20 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onmouseup(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("21 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onmousemover(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");
			System.out.println("22 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		scriptPattern = Pattern.compile("onselect(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		
		m = scriptPattern.matcher(value);
		if (m.find( )) 
		{
			//System.out.println("Match Found--In Request Wrapper-9->");
			//value = scriptPattern.matcher(value).replaceAll("");	
			System.out.println("23 Illegal Value--" + value );
			throw new IllegalStateException("Illegal Activity Not Allowed !!");
		}
		
		//System.out.println("Three Final Value ASASAS-->>"+value);
		
		return value;
	}
	
	

	String[] arrBypassParameter={"org.apache.struts.taglib.html.TOKEN","selectedDataFont"};
	String[] arrBypassParameterValue={};
	String[] arrreplaceParameterValue={/*"undefined"," ","\\r?\\n"*/};
	private void checkTemparedData(HttpServletRequest servletRequest) 
	{
		//System.out.println("inside HISUtilities checkTemparedData");
		//StringBuffer sb = new StringBuffer("");	
		//sb.append("[");
		if(servletRequest.getMethod().equals("GET"))
			 return;
		
		boolean isTempared=false;
		Enumeration requestParameters = servletRequest.getParameterNames();
		
		List<String> list = Collections.list(requestParameters);
		Collections.sort(list);
		JSONArray jsonArrayA= new JSONArray();// for json generated at server end
		String fHTokenVal=null;
		int countParameter=0;
		String oneParameter=null;
		//while(requestParameters.hasMoreElements()){
		 for (String  parameter :list) {
			countParameter++;
			//String parameter = (String) requestParameters.nextElement();
			oneParameter=parameter;
			String[] values = servletRequest.getParameterValues(parameter);
			int count = values.length;
			if(bypassString(arrBypassParameter,parameter)){
				continue;
			}
			
			if (values!=null && count>0){
				for (int i = 0; i < count; i++){
	
					if (values[i]!=null)
					{
						if(bypassString(arrBypassParameterValue,values[i])){
							continue;
						}
						
						JSONObject  objectA= new JSONObject();
						//System.out.println("parameter in HISUtilities==" + parameter);
						if (TOKEN_KEY.equalsIgnoreCase(parameter)) {
							fHTokenVal = values[i];		
							objectA.put("name", parameter);
							objectA.put("value", "");					
						}
						else{
							//System.out.println("parameter=="+ parameter + "value=="+values[i]);
							if(!parameter.contains("[]")) {
								objectA.put("name", parameter);
								objectA.put("value", values[i]);
							}
							else {
								
								parameter=parameter.replace("[]","");
								//System.out.println("parameter=="+ parameter + "value=="+values[i]);
								objectA.put("name", parameter);
								objectA.put("value", values[i]);
								/*if(values[i].length()>0) {
									String str="";
									String []arr=values[i];
									for(int x=0;x<values[i].length();x++) {
										str+= +",";
									}
									
									objectA.put("name", parameter);
									objectA.put("value", str);
								}*/
								
								
							}

						}	
						jsonArrayA.put(objectA);
					}
					
				}
			}
		}
		
		// String fToken=null;
	//	System.out.println("request method=="+ servletRequest.getMethod());
		//System.out.println(TOKEN_KEY+ "fHTokenVal IN HISUtilities-->"+fHTokenVal);
		
		if(jsonArrayA!=null && jsonArrayA.length()>0&& fHTokenVal==null){
			System.out.println("DataService war jsonArrayA==" + jsonArrayA+"\njsonArrayA.length()==" +jsonArrayA.length()+"\n fHTokenVal=====" +fHTokenVal);
			 throw new IllegalStateException("key tempared!");
		 }
				 
		 
		 if(jsonArrayA != null && jsonArrayA.length() > 0){
			try {
				fHTokenVal=fHTokenVal.replaceAll("dbfhttf","");
				fHTokenVal=Base64Utils.decode(fHTokenVal);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				System.out.println("DataService war fHTokenVal=====" +fHTokenVal);
				throw new IllegalStateException("key tempared!");
				
			}
			
			JSONArray jsonArrayB=null;// for json generated at client end 
			
			if(fHTokenVal!=null && !fHTokenVal.equals("")){
				 JSONArray jsonArrayBTemp= new JSONArray(fHTokenVal);
				 //System.out.println("jsonArrayBTemp===" + jsonArrayBTemp.toString());
				 jsonArrayB = new JSONArray();
				for(int j = 0; j < jsonArrayBTemp.length(); j++){
					JSONObject  objectB = (JSONObject) jsonArrayBTemp.get(j);
					//System.out.println("objectB==="+ objectB.toString());
					String nameB = objectB.getString("name");
					if(bypassString(arrBypassParameter,nameB)){
						continue;
					}
					try{
						String valueB=objectB.getString("value");
					}catch(Exception e){
						objectB.put("value", "Exception val");							
					}
					
					if (TOKEN_KEY.equalsIgnoreCase(nameB)) {
						objectB.put("value", "");
					}
					
					jsonArrayB.put(objectB);
				}
				jsonArrayBTemp=null;
				 
				
				 
			}
			
			if(jsonArrayA!=null && jsonArrayB!=null && isTempared==false){
				String temparedParameter="";
				String valueServer="";
				String valueBrowser="";
				
				for(int i = 0; i < jsonArrayB.length(); i++)
				{
					JSONObject  objectB = (JSONObject) jsonArrayB.get(i);
					String nameB = objectB.getString("name");
					//System.out.println("nameB==" + nameB);
					String valueB = objectB.getString("value");
					
					boolean foundinA=false;
					//if(nameA.equals("varHintAnswer"))
						//System.out.println("nameB--" + nameB + " valueB-" + valueB);
					//int cnt=-1;
					// if more than one parameter with same name then checking again for tempared value
						temparedParameter=nameB;
						valueBrowser=valueB;
						isTempared=true;
					for(int j = 0; j < jsonArrayA.length(); j++){
						JSONObject  objectA = (JSONObject) jsonArrayA.get(j);
						String nameA = objectA.getString("name");
						String valueA = objectA.getString("value");	
						//if(nameA.equals("varHintAnswer"))
							//System.out.println("    valueB== "+ valueB + " nameA.equals(nameB) ==" + nameA.equals(nameB) +" valueA.equals(valueB)=="+ valueA.equals(valueB) );						
							if(nameA.equals(nameB)){
								foundinA=true;
								if(valueA.equals(valueB)){
									isTempared=false;													
									//System.out.println("isTempared in for --"+ isTempared);
									break;
								}
								else{
									valueServer=valueA;									
								}									
							}												
						} // for j ends
					
					if(valueBrowser.equals("null"))
						valueBrowser="";
					if(foundinA==false &&   !valueBrowser.trim().equals("")){
						System.out.println("jsonArrayA --" + jsonArrayA.toString());
						System.out.println("jsonArrayB--"+ jsonArrayB.toString());
						System.out.println("temparedParameter--"+ temparedParameter + " valueServer- Not found valueBrowser--"+ valueBrowser);
						isTempared=true;		
						break;
					}
					if(isTempared){
						System.out.println("jsonArrayA --" + jsonArrayA.toString());
						System.out.println("jsonArrayB--"+ jsonArrayB.toString());
						System.out.println("temparedParameter--"+ temparedParameter + " valueServer-"+ valueServer + " valueBrowser--"+ valueBrowser);
						break;
					}
				} // for i ends
			}
		}
		//System.out.println("isTempared---" + isTempared);
		if(isTempared){			
			throw new IllegalStateException("Form Data tempared!");
		}	
	//	System.out.println("Form data ok");
	}
	
	 

	private boolean bypassString(String [] arr, String compareValue){
		boolean flag=false;
		if(arr!=null || arr.length!=0){
			for(int i=0;i<arr.length;i++){
				if(arr[i].equals(compareValue)){
					flag=true;
					break;
				}
			}
		}
		else
			flag=true;
		
		return flag;
		
	}	

		 
	
	
}


