package hislogin.transactions.action;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

    public void init(FilterConfig filterConfig) {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
      //  HttpServletResponse httpResponse = (HttpServletResponse) response;
        String requestURI = httpRequest.getRequestURI();

        // Only apply encoding if it's not static resources
        if (!requestURI.endsWith(".css") && !requestURI.endsWith(".js")
                && !requestURI.endsWith(".png") && !requestURI.endsWith(".jpg")
                && !requestURI.endsWith(".jpeg") && !requestURI.endsWith(".gif")
                && !requestURI.endsWith(".woff") && !requestURI.endsWith(".ttf")) {
            
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
        }

        chain.doFilter(request, response);
    }

    public void destroy() {}
}
