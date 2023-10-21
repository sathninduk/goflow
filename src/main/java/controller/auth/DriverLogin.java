package controller.auth;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Driver;
import model.Rider;
import service.auth.AuthService;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.rider.IRiderService;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class DriverLogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Auth/DriverLogin.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        AuthService authService = new AuthService();

        if (authService.login(email, password, "Driver")) {

            IDriverService iDriverService = new DriverServiceImpl();
            Driver drive = iDriverService.getDriverByEmail(email);

            HttpSession session = request.getSession(true);
            session.setAttribute("username", email);
            session.setAttribute("id", drive.getID());
            session.setAttribute("vehicleType", drive.getVehicleType());
            session.setAttribute("role", "Driver");

            response.sendRedirect("./DriverRinging");

//            request.setAttribute("msg", "Logged in successfully");
//            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Auth/Notification.jsp");
//            dispatcher.forward(request, response);
        } else {
            response.sendRedirect("./DriverLogin");
        }

    }
}
