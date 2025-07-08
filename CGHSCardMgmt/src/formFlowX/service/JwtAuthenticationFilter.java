package formFlowX.service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
import org.json.JSONObject;
import io.jsonwebtoken.*;
import hisglobal.utility.Usefulmethods;

public class JwtAuthenticationFilter implements Filter {

    private static final String SECRET_KEY = "MySuperSecretKey123";
    private static final long EXPIRATION_TIME_MS = 3 * 60 * 1000;

    public void init(FilterConfig filterConfig) {}
    public void destroy() {}

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpReq = (HttpServletRequest) request;
        HttpServletResponse httpRes = (HttpServletResponse) response;
        String authHeader = httpReq.getHeader("Authorization");
        String uri = httpReq.getRequestURI();

        // Step 1: Authenticate user and return token
        if (uri.contains("/restful/parliament/token") || uri.contains("/restful/nha/tms/v1.0/benificary/token") ||uri.contains("/restful/ogd/v1/details/token")) {
            if (authHeader == null || !authHeader.startsWith("Basic ")) {
                unauthorized(httpRes, "Missing or invalid Authorization header.");
                return;
            }

            String[] credentials = new String(Base64.getDecoder().decode(authHeader.substring(6))).split(":", 2);
            if (credentials.length != 2) {
                unauthorized(httpRes, "Invalid credentials format.");
                return;
            }

            String username = credentials[0];
            String password = credentials[1];

            if (!authHeader.startsWith("Bearer ")) {
            if (authenticateUser(username, password)) {
                String token = generateJwtToken(username);
                storeToken(username, token);
                httpRes.setContentType("application/json");
                httpRes.getWriter().write("{\"token\": \"" + token + "\"}");
            } else {
                unauthorized(httpRes, "Authentication failed.");
            }
            return;
        }
       
            
            
        }
        // Step 2: Validate token
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            unauthorized(httpRes, "Missing or invalid Bearer token.");
            return;
        }

        String token = authHeader.substring(7);
        if (!validateToken(token)) {
            unauthorized(httpRes, "Invalid or expired token.");
            return;
        }

        String username = getUsernameFromToken(token);
        String endpoint = httpReq.getRequestURI();

        // Step 3: Check hit limit
        if (!checkAndUpdateHitLimit(username, endpoint)) {
            httpRes.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
            httpRes.getWriter().write("API daily hit limit reached for this endpoint.");
            return;
        }

        chain.doFilter(request, response);
    }

    private void unauthorized(HttpServletResponse res, String message) throws IOException {
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        res.getWriter().write(message);
    }

    private boolean authenticateUser(String username, String password) {
        try {
            JSONObject input = new JSONObject();
            input.put("username", username);
            input.put("password", password);

            JSONObject result = Usefulmethods.getDataByProcedureForAPI("cardmgmt.pkg_AuthenticationFilter.authenticate_user", input);
            return result != null && "SUCCESS".equalsIgnoreCase(result.optString("message"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String generateJwtToken(String username) {
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + EXPIRATION_TIME_MS))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    private void storeToken(String username, String token) {
        try {
            JSONObject input = new JSONObject();
            input.put("username", username);
            input.put("token", token);
            input.put("expiry", new java.sql.Timestamp(System.currentTimeMillis() + EXPIRATION_TIME_MS).toString());

            Usefulmethods.callDMLProcedureForAPI("cardmgmt.pkg_AuthenticationFilter.store_token", input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean validateToken(String token) {
        try {
            JSONObject input = new JSONObject();
            input.put("token", token);

            JSONObject result = Usefulmethods.getDataByProcedureForAPI("cardmgmt.pkg_AuthenticationFilter.validate_token", input);
            if (result != null && "SUCCESS".equalsIgnoreCase(result.optString("message"))) {
                Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
                return claims.getExpiration().after(new Date());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private String getUsernameFromToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private  boolean checkAndUpdateHitLimit(String username, String endpoint) {
        try {
            JSONObject input = new JSONObject();
            input.put("username", username);
            input.put("endpoint", endpoint);

            JSONObject result = Usefulmethods.getDataByProcedureForAPI("cardmgmt.pkg_AuthenticationFilter.check_hit_limit", input);
            return result != null && "SUCCESS".equalsIgnoreCase(result.optString("message"));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

