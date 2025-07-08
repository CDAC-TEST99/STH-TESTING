package formFlowX.action;



import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


    
public class MainServlet extends HttpServlet 
{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void init(ServletConfig config) throws ServletException
	{
		
		super.init(config);
	}
		
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException
	{
		//System.out.println("in the doget of loginaction");
		this.doPost(request,response);
	}    
   
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException
	{
		try	{
			String hmode =	request.getParameter("hmode");
			if(hmode==null) {
				hmode="FirstCall";// FirstCall
			}
			Method[] classMethods = this.getClass().getMethods();
			int indx=-1;
			for (int i = 0; i < classMethods.length; i++) {
				if(classMethods[i].getName().equals(hmode)) {
					
					indx=i;
					break;
				}	
			}
			if(indx!=-1)
				classMethods[indx].invoke(this, new Object[] { request, response});
			else
				throw new ServletException("Method not found named -- "+ hmode);
				
			
			
			
		}
		catch(Exception e){	
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}	
	public static void forwardToPage(HttpServletRequest request,HttpServletResponse response,Object fb,  String page) throws ServletException, IOException{
		request.setAttribute("FORMBEAN", fb); 
		RequestDispatcher rd = null;
		rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	public static void initBean(Object fb, HttpServletRequest request){
		Map < String,String > mpVariableNames = new HashMap < String,String > ();
		Class cls1 = fb.getClass();
		Method[] cls1Methods = cls1.getMethods();
		String val="";
		String parameterName="";
		try {
					
			for (int i = 0; i < cls1Methods.length; i++) {
				
				if (cls1Methods[i].getName().indexOf("set") == 0) {
					String beanVariableName=cls1Methods[i].getName().substring(3).toLowerCase();
					//System.out.println("method==" + beanVariableName);
					mpVariableNames.put(beanVariableName,(i+"").trim());
				}
			}
		
		
		Enumeration requestParameters=request.getParameterNames();		 
		while(requestParameters.hasMoreElements()){
			String nextElement=(String)requestParameters.nextElement();
			 parameterName=nextElement.toString().toLowerCase();	
			//System.out.println("parameterName==" + parameterName+  " in mpVariableNames===" + mpVariableNames.containsKey(parameterName) );
			boolean isStringArray=false;
			if(parameterName.contains("[]")){
				parameterName=parameterName.replace("[]", "").trim();
				isStringArray=true;
			}
			
			if(mpVariableNames.containsKey(parameterName)){
				
				  int indx= Integer.parseInt(mpVariableNames.get(parameterName));
				  String requestDataArray[] = request.getParameterValues(nextElement);
				  if(isStringArray){
					  String[] parameterValue=requestDataArray;
					  cls1Methods[indx].invoke(fb, new Object[] { parameterValue });
				  }
				  else{
					  String parameterValue=requestDataArray[0];
					  val=parameterValue;
					  Class[] parameterTypes = cls1Methods[indx].getParameterTypes();
					  Class classobject=parameterTypes[0];
					  if(classobject.getName().equals("[Ljava.lang.String;")){
						  String[] arr= new String[1];
						  arr[0]=parameterValue;
						  cls1Methods[indx].invoke(fb, new Object[] { arr });
					  }
					  else{
						  cls1Methods[indx].invoke(fb, new Object[] { parameterValue });  
					  }
					 // System.out.println("parameterName===" + parameterName + " val==" + val);
				  }
			}
		}
		}catch(Exception e) {
			System.out.println("parameterName===" + parameterName + " val==" + val);
			e.printStackTrace();
		}
	}
	
}//end of class
