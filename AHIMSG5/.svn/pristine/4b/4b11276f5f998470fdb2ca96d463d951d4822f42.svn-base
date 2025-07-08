package application.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import hisglobal.utility.SecurityUtil;

/**
 * Servlet Filter implementation class FormFieldValidationFilter
 */

public class FormFieldValidationFilterAHIMS implements Filter {

	//private static List<String> availableMenus = null;
	private static Set<String> keys = new HashSet<String>();

	static {

		keys.add("varssoticketgrantingticket");
		keys.add("f_codes");

	}

	private static final String TOKEN_KEY = "fhttf";
	private static final String CSRF_KEY = "x-auth-token";
	private static final String CSRF_MAP = "csrfMap";

	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Default constructor.
	 */
	public FormFieldValidationFilterAHIMS() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */

	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest objRequest = (HttpServletRequest) request;

		String strURI = objRequest.getRequestURI();
         // System.out.println("strURI"+strURI);
          
		if (strURI.contains("refreshHomeUserDesk") || strURI.contains("logoutLogin") || strURI.contains("initLogin")  || strURI.contains(".js") 
				|| strURI.equalsIgnoreCase("Login") || strURI.contains("captchaLogin") 
				|| strURI.contains("captchaLgnFtr") || strURI.contains("/services/restful")
				|| strURI.contains("/alert/") || strURI.contains("reloadManualDtlUserDesk")||
				strURI.contains("downloadManualUserDesk")||strURI.contains("LabRptRegistrationServlet.lab")||strURI.contains("LabRptRegistrationoldServlet.lab")||strURI.contains("saveAddUpdateMobileNoLgnFtr")
				|| strURI.contains("MmsCNT.cnt") || strURI.contains("saveForgetPasswordLgnFtr") || 
				strURI.contains("validateForgetPasswordLgnFtr")||strURI.contains("SENDOTPLgnFtr")||strURI.contains("RESENDOTPLgnFtr")||strURI.contains("VALIDATEOTPLgnFtr")||
				strURI.contains("SENDOTPFgtPwdLgnFtr")||strURI.contains("RESENDOTPFgtPwdLgnFtr")
				||strURI.contains("VALIDATEOTPFgtPwdLgnFtr")||strURI.contains("CHECKLOGINIDLgnFtr")
				||strURI.contains("logMenuDtlUserDesk") ||strURI.contains("snomedct") 
				
				) {
		  

			chain.doFilter(request, response);

			return;
		} else {

			String fHTokenVal = "";

			List<ParamObjectAHIMS> paramMap = null;

			boolean isMultiPart = ServletFileUpload.isMultipartContent((HttpServletRequest) request);

			if (isMultiPart) {

				// String filePath = new NhsrcUtil()
				// .getParameterFromHisPathXML("TMP_FILE_PATH");
				/*
				 * DiskFileItemFactory factory = new DiskFileItemFactory();
				 * factory.setSizeThreshold(1024); factory.setRepository(new File(filePath));
				 * 
				 * ServletFileUpload upload = new ServletFileUpload(factory); multipartRequest =
				 * new UploadMultipartRequestWrapper( (HttpServletRequest) request, upload);
				 */

				try {
					//paramMap = getParamsFromMultipartForm((HttpServletRequest) request);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				if (paramMap == null && getErrorMessage() != null) {

					HttpServletResponse res = (HttpServletResponse) response;

					res.setContentType("text/html");
					PrintWriter pw = res.getWriter();
					pw.write("<html><head><title>Error</title></head><body><h1> " + getErrorMessage()
							+ " </h1></body></html>");

					return;

				}

			} else {

				if (paramMap == null) {
					 // System.out.println("above getParamsFromSimpleForm :: "
//							  + request.getParameter("hmode"));
					paramMap = getParamsFromSimpleForm((HttpServletRequest) request);
					
					 //System.out.println("below getParamsFromSimpleForm :: "
//							  + request.getParameter("hmode"));
				}

			}
			// for (ParamObjectAHIMS obj : paramMap) {
			if (paramMap != null && paramMap.size() > 2) {
				
				

				if (paramMap.stream().filter(a -> a.getName().equals(CSRF_KEY)).collect(Collectors.toList()).size() > 0) {

				//	String csrfParamValue = paramMap.get(0).getName();
					String csrfValue = paramMap.stream().filter(a -> a.getName().equals(CSRF_KEY)).collect(Collectors.toList()).get(0).getValue();

					String sessionCsrfValue = "_";
					 
					if (objRequest.getSession().getAttribute(CSRF_KEY) != null) {

						sessionCsrfValue = objRequest.getSession().getAttribute(CSRF_KEY).toString();
					}
					 //System.out.println("csrf session key available >> " + csrfValue + " == " + sessionCsrfValue);
					if (!csrfValue.equals(sessionCsrfValue)) {
						HttpServletResponse res = (HttpServletResponse) response;
						res.setContentType("text/html");
						PrintWriter pw = res.getWriter();
						pw.write(
								"<html><head><title>Error</title></head><body><h1> Please refresh and try again!! </h1></body></html>");
						return;
					}  
				}
				
				
				
				if (CSRF_KEY.equals(paramMap.get(0).getName())) {

					String csrfParamValue = paramMap.get(0).getValue();
					String csrfValue = csrfParamValue.split("#")[1];

					String sessionCsrfValue = "_";
					Map<String, String> csrfMap = null;
					if (objRequest.getSession().getAttribute(CSRF_MAP) != null) {

						csrfMap = (Map<String, String>) objRequest.getSession().getAttribute(CSRF_MAP);
						sessionCsrfValue = csrfMap.get(csrfParamValue.split("#")[0]);
					}
					  System.out.println("csrf session key available >> " + csrfValue + " == " + sessionCsrfValue);
					if (!csrfValue.equals(sessionCsrfValue)) {
						HttpServletResponse res = (HttpServletResponse) response;
						res.setContentType("text/html");
						PrintWriter pw = res.getWriter();
						pw.write(
								"<html><head><title>Error</title></head><body><h1> Please refresh and try again!! </h1></body></html>");
						return;
					} else {
						if (csrfMap != null)
							csrfMap.remove(csrfParamValue.split("#")[0]);
					}
				}
			}
			  //System.out.println("paramMap"+paramMap.size());
			if (paramMap != null && paramMap.size() > 2) {
				// for (ParamObjectAHIMS ParamObjectAHIMS : paramMap) {
         
				if (!TOKEN_KEY.equalsIgnoreCase(paramMap.get(0).getName())) {
					// chain.doFilter(request, response);
					StringBuffer sb = new StringBuffer("");
					if (paramMap != null && paramMap.size() > 2) {

						Collections.sort(paramMap, new Comparator<ParamObjectAHIMS>() {

							@Override
							public int compare(ParamObjectAHIMS s1, ParamObjectAHIMS s2) {

								return s1.getName().toLowerCase().toString()
										.compareTo(s2.getName().toLowerCase().toString());
							}

						});
						// Collections.sort(paramMap,
						// (s1, s2) ->
						// s1.getName().toLowerCase().compareTo(s2.getName().toLowerCase()));
						for (ParamObjectAHIMS ParamObjectAHIMS : paramMap) {

						 	//System.out.println("key : " + ParamObjectAHIMS.getName() + "  value :  " + ParamObjectAHIMS.getValue());
							if (TOKEN_KEY.equalsIgnoreCase(ParamObjectAHIMS.getName())) {
								fHTokenVal = ParamObjectAHIMS.getValue();

							} else {
								String val = ParamObjectAHIMS.getValue().replaceAll(" ", "_");
								val = val.replaceAll("\\r?\\n", "_");
								val = val.replaceAll("undefined", "");

								sb.append(val);
							}

						}
					}
					 // System.out.println("string :: " + sb.toString());

					String fToken = sb.toString().isEmpty() ? "" : SecurityUtil.getMd5Hash(sb.toString());

					//System.out.println("Server Token  :: " + fToken);

					//System.out.println("browser token :: " + fHTokenVal);

					if (fToken.equals(fHTokenVal)) {

						chain.doFilter(request, response);
					} else {

						HttpServletResponse res = (HttpServletResponse) response;
						res.setContentType("text/html");
						PrintWriter pw = res.getWriter();
						pw.write(
								"<html><head><title>Error</title></head><body><h1>Form Data Tampered</h1></body></html>");
					}
				}
				// }
			} else {
				chain.doFilter(request, response);

			}
		}

		// pass the request along the filter chain

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private List<ParamObjectAHIMS> getParamsFromSimpleForm(HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObjectAHIMS> paramMap = new ArrayList<ParamObjectAHIMS>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			// System.out.println(" param name is " + paramName);
			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)
						// paramValue= "108";

						paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
							paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValues[i]));
					}

				}

			}

		}

		return paramMap;
	}

	private List<ParamObjectAHIMS> getParamsFromMultipartForm(HttpServletRequest request) throws Exception {

		// MultiReadHttpServletRequest request = new
		// MultiReadHttpServletRequest(request_p);

		List<ParamObjectAHIMS> paramMap = new ArrayList<ParamObjectAHIMS>();

		if (request.getParameterNames() != null) {

			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				// System.out.println(" param name is " + paramName);
				if (!keys.contains(paramName.toLowerCase())) {

					String[] paramValues = request.getParameterValues(paramName);
					if (paramValues.length == 1) {
						String paramValue = paramValues[0];
						if (paramValue.length() > 0)
							// paramValue= "108";
							//System.out.println(paramName + "  >>  " + paramValue);
						paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValue));

					} else {
						for (int i = 0; i < paramValues.length; i++) {
							if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
								paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValues[i]));
 
						}

					}

				}

			}

		}

		return paramMap;
	}

}
