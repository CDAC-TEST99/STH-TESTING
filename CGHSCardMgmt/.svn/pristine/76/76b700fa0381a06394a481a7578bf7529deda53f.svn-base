package application.filters;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import hisglobal.security.SecurityUtil;




public class SecurityFilter implements Filter{
	private static Set<String> keys = new HashSet<String>();

	static {
		keys.add("uservalue");
		keys.add("varssoticketgrantingticket");
		keys.add("hmode");
		// keys.add("billmoduleid");
		// keys.add("usermode");
		

		
	}

	
	private static final String TOKEN_KEY = "fhttf";

	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		String strURI = ((HttpServletRequest) request).getRequestURI();

	 System.out.println(" AHIMSG5  >> " + strURI);

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

			  System.out.println(" ffvf forwareded >> "+strURI);

		 System.out.println("forward2....");
			// Forward as-it-is
			chain.doFilter(request, response);
		} else {
 
			String fHTokenVal = "";

			List<ParamObjectAHIMS> paramMap = null;
			UploadMultipartRequestWrapperAHIMS multipartRequest = null;

			boolean isMultiPart = ServletFileUpload.isMultipartContent((HttpServletRequest) request);
 
			if (isMultiPart) {

			 	System.out.println("above getParamsFromMultipartForm :: " + request.getParameter("hmode"));

				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(1024);
				factory.setRepository(new File("/"));

				ServletFileUpload upload = new ServletFileUpload(factory);
				multipartRequest = new UploadMultipartRequestWrapperAHIMS((HttpServletRequest) request, upload);

				//paramMap = getParamsFromMultipartForm(request)(multipartRequest);
				paramMap = getParamsFromMultipartForm(multipartRequest);

				 System.out.println("below getParamsFromMultipartForm :: " + request.getParameter("hmode"));

			} else {

				if (paramMap == null) {

					// System.out.println("above getParamsFromSimpleForm :: " + request.getParameter("hmode"));

					paramMap = getParamsFromSimpleForm((HttpServletRequest) request);

					 //System.out.println("below getParamsFromSimpleForm :: " + request.getParameter("hmode"));

				}

			}

			StringBuffer sb = new StringBuffer("");

			if (paramMap != null && paramMap.size() > 0) {

				Collections.sort(paramMap, new Comparator<ParamObjectAHIMS>() {

					@Override
					public int compare(ParamObjectAHIMS s1, ParamObjectAHIMS s2) {

						return s1.getName().toLowerCase().toString().compareTo(s2.getName().toLowerCase().toString());
					}

				});

				for (ParamObjectAHIMS paramObject : paramMap) {

					 System.out.println("key : " + paramObject.getName() +
					  " value : " + paramObject.getValue());

					 // System.out.println("ParamMapsize in AHIMSG5 filter>>"+paramMap.size());
					  //System.out.println("Param name in in AHIMSG5 filter.."+paramObject.getName());

					  if (TOKEN_KEY.equalsIgnoreCase(paramObject.getName())) {
							fHTokenVal = paramObject.getValue();
						} else {

							String val = paramObject.getValue().replaceAll("undefined", "");

							val = val.replaceAll(" ", "_");

							val = val.replaceAll("\\r?\\n", "_");
 
							sb.append(val);

						}

				}

			}

			  System.out.println("string :: " + sb.toString());

			String fToken = sb.toString().isEmpty() ? "" : SecurityUtil.getMd5Hash(sb.toString());

		 	System.out.println("AHIMSG5 Server Token :: " + fToken);

		System.out.println("AHIMSG5 Browser Token  :: " + fHTokenVal);

			if (fToken.equals(fHTokenVal)) {

				if (isMultiPart) {
					
					 System.out.println("multipartRequest hmode before invoke next filter :: "
					 + multipartRequest.getParameter("hmode"));

					chain.doFilter(multipartRequest, response);

				} else {
					 System.out.println("request hmode before invoke next filter :: "
					 + request.getParameter("hmode"));

					chain.doFilter(request, response);

				}

			} else {

				HttpServletResponse res = (HttpServletResponse) response;

				res.setContentType("text/html");
				PrintWriter pw = res.getWriter();
				System.out.println("pw>>"+pw);
				pw.write("<html><body><h1>Form Data Tampered</h1></body></html>");

			}

			// pass the request along the filter chain
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	private static List<ParamObjectAHIMS> getParamsFromSimpleForm(HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObjectAHIMS> paramMap = new ArrayList<ParamObjectAHIMS>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			 System.out.println(" param name is " + paramName);
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

	private static List<ParamObjectAHIMS> getParamsFromMultipartForm(HttpServletRequest request) {

		Enumeration<String> paramNames = request.getParameterNames();

		List<ParamObjectAHIMS> paramMap = new ArrayList<ParamObjectAHIMS>();

		while (paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			 System.out.println(" param name is " + paramName);
			if (!keys.contains(paramName.toLowerCase())) {

				String[] paramValues = request.getParameterValues(paramName);
				if (paramValues.length == 1) {
					String paramValue = paramValues[0];
					if (paramValue.length() > 0)
						// paramValue= "108";
						System.out.println(paramName + "  >>  " + paramValue);
					paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValue));

				} else {
					for (int i = 0; i < paramValues.length; i++) {
						if (!("hmode".equalsIgnoreCase(paramName) && i == 0))
							paramMap.add(new ParamObjectAHIMS(paramName.toLowerCase(), paramValues[i]));

						System.out.println(paramName + "  >>  " + paramValues[i]);

					}

				}

			}

		}

		return paramMap;
	}


}
