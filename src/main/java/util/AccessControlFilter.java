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

            // public
            "/",
            "/DriverLogin",
            "/RiderLogin",
            "/DriverRegister",
            "/RiderRegister",
            "/Login",
            "/Register",
            "/AddRider",
            "/AddDriver",
            "/DriverRegister",
            "/RiderRegister",
            "/AdminLogin",
            "/index.jsp",

            // css
            "/public/css/styles.css",
            "/public/css/styles_home.css",

            // scripts
            "/public/js/scripts.js",
            "/public/js/location.js",
            "/public/js/validation/loginValidation.js",
            "/public/js/validation/rideValidation.js",

            // images
            "/public/images/GoFlow-Logo.png",
            "/public/images/GoFlow_White.png",
            "/public/images/Hero-img.jpg",
            "/public/images/map_icon.png",

            // fonts
            "/public/fonts/Gabarito/Gabarito-VariableFont_wght.ttf",


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
