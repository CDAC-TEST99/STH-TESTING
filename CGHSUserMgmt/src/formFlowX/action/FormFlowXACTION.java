package formFlowX.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import formFlowX.fb.FormFlowXCommonFB;
import formFlowX.util.FormFlowXUTIL;
import formFlowX.vo.FormFlowXUserVO;
import hisglobal.utility.Usefulmethods;

@SuppressWarnings("serial")
public class FormFlowXACTION extends MainServlet {

	private static final String fileName = "formFlowX.action.masterUI";

	public static void FirstCall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().removeAttribute("OBJUSER");
		CallMasterPage(request, response);
	}

	public static void CallMasterPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FormFlowXCommonFB fb = new FormFlowXCommonFB(request);
		FormFlowXUTIL.initABHA(fb, request, response);
		String masterKey = fb.getMasterkey();
		if (masterKey == null) {
			masterKey = Usefulmethods.getQuery(fileName, "defaultmasterkey");
		}

		if (fb.getIsGlobal() == null || fb.getIsGlobal().equals(""))
			fb.setIsGlobal("0");
		/*
		 * if(fb.getAbdmMode().equals("appointment") ) fb.setIsGlobal("1");
		 */

		FormFlowXUserVO objuser = FormFlowXUTIL.getUserVO(request, fb);

		if (objuser == null) {
			masterKey = "sessionExpired";
		}

		String page = Usefulmethods.getQuery(fileName, masterKey);
		forwardToPage(request, response, fb, page);

	}

	public static void callService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FormFlowXCommonFB fb = new FormFlowXCommonFB(request);
		FormFlowXUTIL.CallService(fb, request, response);
		if (fb.getFileUploadFlag().equals("1")) {
			FormFlowXUTIL.renameTempFileOnGlobalFtp(request, response);
			HttpSession session = request.getSession();
			Map<String, String> params = new HashMap<String, String>();
			session.setAttribute("FileMap", params);
			
		}
	}

	public static void fileUpload(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();

		if (session.getAttribute("FileMap") == null) {

			Map<String, String> params = new HashMap<String, String>();
			session.setAttribute("FileMap", params);

		}
		FormFlowXUTIL.fileUpload(request, response);

	}

	public static void fileTempDownload(final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		try {
			FormFlowXUTIL.downloadFileFromTempFTP(request, response);
		} catch (Exception e2) {
			try {
				response.getWriter().append("<div style='text-align:center'><h1>File Not Found<h1></div>");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
