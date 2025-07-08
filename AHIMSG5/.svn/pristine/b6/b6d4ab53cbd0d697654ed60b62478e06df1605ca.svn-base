package hisglobal.FormFlowX.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.FormFlowX.fb.FormFlowXCommonFB;
import hisglobal.FormFlowX.util.FormFlowXCommonUTIL;
import hisglobal.FormFlowX.util.Usefulmethods;
import hisglobal.FormFlowX.vo.FormFlowXUserVO;


@SuppressWarnings("serial")
public class FormFlowXACTION extends MainServlet  {
		private static final String fileName="hisglobal.FormFlowX.action.masterUI";
	
	public static void FirstCall(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	
		CallMasterPage(request, response);
	}
	public static void CallMasterPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		FormFlowXCommonFB fb= new FormFlowXCommonFB(request) ;
		
		String masterKey=fb.getMasterkey();
		if(masterKey==null){
			 masterKey=Usefulmethods.getQuery(fileName, "defaultmasterkey");			
		}
		
		if(fb.getIsGlobal()==null || fb.getIsGlobal().equals(""))
			fb.setIsGlobal("0");
		
		FormFlowXUserVO objuser =FormFlowXCommonUTIL.getUserVO(request,fb);
		
		if(objuser==null) {
			masterKey="sessionExpired";
		}
		
		String page=Usefulmethods.getQuery(fileName, masterKey);
		forwardToPage(request, response,fb, page);		
		
	}
	
	public static void callService(HttpServletRequest request,HttpServletResponse response) throws Exception{
		FormFlowXCommonFB fb= new FormFlowXCommonFB(request) ;
		FormFlowXCommonUTIL.CallService(fb, request, response);
	}
	
	public static void getReport(HttpServletRequest request,HttpServletResponse response) throws Exception{
		//System.out.println("getreport >>> "+request.getAttribute("serviceName"));
		FormFlowXCommonFB fb= new FormFlowXCommonFB(request) ;
		//System.out.println("format >>"+fb.getFormat());
		
		//System.out.println("input data >>>  "+fb.getInputData()+"service name >>>>> "+fb.getServiceName());
		FormFlowXCommonUTIL.callGenerateReportService(fb, request, response);
	}
	
public static void viewImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//System.out.println("view image test");
		
	FormFlowXCommonUTIL.viewImage(request, response);
		
		
		
		
	}
}
