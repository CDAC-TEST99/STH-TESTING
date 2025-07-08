package application.filters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 * Wrap multipart request in order to make uploaded files accessible 
 * to the {@link net.mymam.ui.Upload Upload} component. 
 
 * <p/> 
 * See section "How do I support file uploads" in <i>Core Java Server Faces</i>, 3rd Edition. 
 
 * <p/> 
 * TODO: Maybe replace with BalusC's servlet 3.0-based implementation, 
 * http://balusc.blogspot.de/2009/12/uploading-files-in-servlet-30.html 
 * 
 * @author fstab 
 */ 
public class UploadMultipartRequestWrapperAHIMS extends HttpServletRequestWrapper { 
 
    private Map<String, List<String>> formParameters = new HashMap(); 
    private Map<String, List<FileItem>> fileParameters = new HashMap(); 
 
    public UploadMultipartRequestWrapperAHIMS(HttpServletRequest request, ServletFileUpload upload) throws ServletException { 
        super(request); 
        try { 
            List<FileItem> fileItems = upload.parseRequest(request); 
            for (int i = 0; i < fileItems.size(); i++) { 
                FileItem item = (FileItem) fileItems.get(i); 
                if (item.isFormField()) { 
                    addParameter(item.getFieldName(), item.getString(), formParameters); 
                } else { 
                    addParameter(item.getFieldName(), item, fileParameters); 
                } 
            } 
        } catch (FileUploadException e) { 
            // Request timed out 
            ServletException servletException = new ServletException(); 
            servletException.initCause(e); 
            throw servletException; 
        } 
    } 
 
    // Add FileItems to fileParameters, and Strings to formParameters. 
    private <T> void addParameter(String key, T value, Map<String, List<T>> map) { 
        if (map.containsKey(key)) { 
            map.get(key).add(value); 
        } else { 
            List<T> values = new ArrayList<T>(); 
            values.add(value); 
            map.put(key, values); 
        } 
    } 
 
    @Override 
    public String getParameter(String name) { 
        if (formParameters.containsKey(name)) { 
            List<String> values = formParameters.get(name); 
            if (values.isEmpty()) { 
                return ""; 
            } 
            else { 
            	 return cleanXSS(values.get(0)); 
            } 
        } else { 
        	 
        	String value = super.getParameter(name);
        	if (value == null) {
    			return null;
    		}
    		return cleanXSS(value);
        
        } 
    } 
 
    @Override 
    public Map getParameterMap() { 
        Map<String, String[]> map = new HashMap(); 
        for (String formParam : formParameters.keySet()) { 
            map.put(formParam, formParameters.get(formParam).toArray(new String[] {})); 
        } 
        map.putAll(super.getParameterMap()); 
        return Collections.unmodifiableMap(map); 
    } 
 
    @Override 
    public Enumeration getParameterNames() { 
        Set<String> paramNames = new LinkedHashSet<String>(); 
        paramNames.addAll(formParameters.keySet()); 
        Enumeration<String> original = super.getParameterNames(); 
        while (original.hasMoreElements()) { 
            paramNames.add(original.nextElement()); 
        } 
        return Collections.enumeration(paramNames); 
    } 
 
    @Override 
    public String[] getParameterValues(String name) { 
        if (formParameters.containsKey(name)) { 
            List<String> values = formParameters.get(name); 
            List<String> encodedValues = new ArrayList<String>();
            if (values.isEmpty()) { 
                return new String[] {}; 
            } 
            else { 
            	for (int i = 0; i < values.size(); i++) 
        		{			
            		encodedValues.add(cleanXSS(values.get(i)));
        		}
                return encodedValues.toArray(new String[values.size()]); 
            } 
        } else { 
        	
        	String[] values = super.getParameterValues(name);
    		if (values == null) {
    			return null;
    		}
    		int count = values.length;
    		
    		String[] encodedValues = new String[count];
    		for (int i = 0; i < count; i++) 
    		{			
    			encodedValues[i] = cleanXSS(values[i]);
    		}
    		return encodedValues;
        	
        	
           // return super.getParameterValues(name); 
        } 
    }  
 
    /**
     * Get the file parameter from a multipart request. 
     * 
     * @param name the {@link net.mymam.ui.Upload Upload} component's client id. 
     * @return the {@link FileItem} representing the file in the request. 
     */ 
    public FileItem getFileItem(String name) { 
        if (fileParameters.containsKey(name)) { 
            List<FileItem> items = fileParameters.get(name); 
            // We assume that each request has only one file item. 
            // This is configurable in jQuery's file upload plugin with 'singleFileUploads=true'. 
            // One file per request is the default configuration in 'jquery.fileupload.js'. 
            if ( items.size() != 1 ) { 
                throw new UnsupportedOperationException("Cannot handle multiple files in a single request."); 
            } 
            return items.get(0); 
        } else { 
            return null; 
        } 
    } 
    
    public String cleanXSS(String value) 
	{
		Pattern scriptPattern = null;
		Matcher m = null;
		try 
		{
			 // System.out.println("Before ->>"+value);
			
			// You'll need to remove the spaces from the html entities below
			  value = value.replaceAll("<html></html>", "");		
			  if(!value.contains("<script>"))
			  {	  
			      value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
			  }
			//  value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
			  value = value.replaceAll("'", "");
			//  value = value.replaceAll("'", "& #39;");
			  value = value.replaceAll("eval\\((.*)\\)", "");
			  value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']","\"\"");
			  value = value.replaceAll("(?i)script", "");
			  value = value.replaceAll("(?i)confirm", "").replaceAll("(?i)prompt", "")
					.replaceAll("(?i)alert", "");
			  
			 
			  
			 // System.out.println("Before 2.1->>"+value);
			  
			  
			// Avoid anything between script tags
				/*scriptPattern = Pattern.compile("<html>(.*?)</html>",Pattern.CASE_INSENSITIVE);
				            m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-1->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity[<html></html>] Not Allowed !!");
				}
				// Avoid anything between <> tags when script is not written between tags
				scriptPattern = Pattern.compile("& lt;(.*?)& gt;",Pattern.CASE_INSENSITIVE);
				            m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					System.out.println("Match Found--In Request Wrapper-1->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity[<html></html>] Not Allowed !!");
				}*/
				
				// Avoid anything between <> tags when script is  written between tags
				scriptPattern = Pattern.compile("<(.*?)>",Pattern.CASE_INSENSITIVE);
				            m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
			//		System.out.println("Match Found--In Request Wrapper-1->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity[<html></html>] Not Allowed !!");
				}
			  
			
			// Avoid anything between script tags
			scriptPattern = Pattern.compile("<script>(.*?)</script>",Pattern.CASE_INSENSITIVE);
			            m = scriptPattern.matcher(value);
			if (m.find( )) 
			{
				//System.out.println("Match Found--In Request Wrapper-1->");
				value = scriptPattern.matcher(value).replaceAll("");	
				throw new IllegalStateException("Illigal Activity[<script></script>] Not Allowed !!");
			}
			

			  // Avoid anything in a src='...' type of expression
			    scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
                        m = scriptPattern.matcher(value);
			if (m.find( )) 
				{
			//		System.out.println("Match Found--In Request Wrapper-2->");
				//value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
			}
			 
				scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
							m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-4->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}


				
				scriptPattern = Pattern.compile("<script(.*?)>",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
               				m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-5->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}

			

			// Avoid eval(...) expressions
				scriptPattern = Pattern.compile("eval\\((.*?)\\)",Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);			
							m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-6->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}

				// Avoid expression(...) expressions
				scriptPattern = Pattern.compile("expression\\((.*?)\\)",
						Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);		
	            			m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-7->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}
			
			

				// Avoid javascript:... expressions
				scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);			
							m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-8->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}

				// Avoid vbscript:... expressions
				scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
							m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-9->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}

				// Avoid onload= expressions
				scriptPattern = Pattern.compile("onload(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				
				 m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-10->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}
				scriptPattern = Pattern.compile("onblur(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				
				 m = scriptPattern.matcher(value);
				if (m.find( )) 
				{
					//System.out.println("Match Found--In Request Wrapper-11->");
					value = scriptPattern.matcher(value).replaceAll("");	
					throw new IllegalStateException("Illigal Activity Not Allowed !!");
				}
				scriptPattern = Pattern.compile("onClick(.*?)=",	Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
				
			//	m = scriptPattern.matcher(value);
			//	if (m.find( )) 
			//	{
					//System.out.println("Match Found--In Request Wrapper-12->");
			//		value = scriptPattern.matcher(value).replaceAll("");	
			//		throw new IllegalStateException("Illigal Activity Not Allowed !!");
			//	}

				//value = value.replaceAll("& lt;", "<").replaceAll("& gt;", ">");

		//	System.out.println("Final Value ASASAS-{cleanXSS}->>"+value);
				
								
			return value;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new IllegalStateException(e.getMessage());
		}
		
	}
}