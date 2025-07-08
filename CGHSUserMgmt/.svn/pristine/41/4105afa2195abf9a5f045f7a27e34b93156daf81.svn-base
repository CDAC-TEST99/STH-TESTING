package hisglobal.security;




import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class CrossScriptingFilter.
 */
public class CrossScriptingFilter implements Filter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException{
		// System.out.println("ONE");
			HttpServletRequest objRequest = (HttpServletRequest) request;
			String strURI = objRequest.getRequestURI(); 
			String hmode=	objRequest.getParameter("hmode");
			if(hmode!=null && hmode.equals("fileUpload")) 
				chain.doFilter(request,response);			
			else
				chain.doFilter(new RequestWrapper((HttpServletRequest) request),response);

	}

}