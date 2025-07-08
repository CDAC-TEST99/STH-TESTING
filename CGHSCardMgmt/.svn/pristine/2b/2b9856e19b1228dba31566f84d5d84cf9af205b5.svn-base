package thirdpartyservices.sercurity;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;

public class ThirdPartySecureFilter implements Filter {

	private static final String Auth_Header_Prefix = "Basic ";

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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		if (response instanceof HttpServletResponse) {
			HttpServletResponse alteredResponse = ((HttpServletResponse) response);
			addCorsHeader(alteredResponse);
		}

		// Get request and response objects, we will need to pass them down the filter
		// chain later on
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpServletResponse httpresponse = (HttpServletResponse) response;

		if (httprequest.getRequestURI().contains("/services/restful/bharatkosh/v1/")) {
			// Check Authorization header and return a 401 if invalid
			String authHeader = httprequest.getHeader(HttpHeaders.AUTHORIZATION);

			try {
				if (authHeader != null && authHeader.startsWith(Auth_Header_Prefix)) {
					String authToken = authHeader.replaceFirst(Auth_Header_Prefix, "");
					String decodedString = new String(Base64.getDecoder().decode(authToken));
					StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
					String userName = tokenizer.nextToken();
					String password = tokenizer.nextToken();
					if (!"user".equals(userName) || !"password".equals(password)) {
						httpresponse.setStatus(401);
						return;										
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
				httpresponse.setStatus(401);
				return;										
			}
		}
		chain.doFilter(request, response);
	}
	
    private void addCorsHeader(HttpServletResponse response){
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }

}