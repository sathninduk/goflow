package util;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AccessControlFilter implements Filter {

    private final String[] excludedUrls = {
            "/",
            "/login.jsp",
            "/index.jsp",
            "/public/css/styles.css",
            "/public/js/scripts.js",
            "/public/js/location.js",
            "/public/images/GoFlow-Logo.png",
            "/public/fonts/Gabarito/Gabarito-VariableFont_wght.ttf",

            "/AddRide",
            "/ListCity"
    };

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        // Check if the request matches an excluded URL
        for (String excludedUrl : excludedUrls) {
            if (requestURI.matches(httpRequest.getContextPath() + excludedUrl)) {
                chain.doFilter(request, response);  // Allow access
                return;
            }
        }

        HttpSession session = httpRequest.getSession(false);
        String loginURI = httpRequest.getContextPath() + "/Login";

        // Allow access to the login page without authentication
        boolean isLoginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean isLoggedIn = session != null && session.getAttribute("username") != null;

        if (isLoginRequest || isLoggedIn) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/Login");
        }
    }

    // Other methods for filter lifecycle management (init, destroy)
    // These can be left empty for this example
    public void init(FilterConfig fConfig) throws ServletException {}
    public void destroy() {}
}
