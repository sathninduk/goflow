package controller.auth;

import exception.auth.AuthException;
import exception.common.EmptyInputsException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Driver;
import service.auth.AuthService;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;

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

        // get inputs
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // exception - empty inputs
            if (email.isEmpty() || password.isEmpty())
                throw new EmptyInputsException("Empty email or password");

            // auth service object
            AuthService authService = new AuthService();

            // check authentication
            if (authService.login(email, password, "Driver")) { // authenticated

                // get driver object
                IDriverService iDriverService = new DriverServiceImpl();
                Driver driver = iDriverService.getDriverByEmail(email);

                // set session
                HttpSession session = request.getSession(true);
                session.setAttribute("username", email);
                session.setAttribute("id", driver.getID());
                session.setAttribute("vehicleType", driver.getVehicleType());
                session.setAttribute("role", "Driver");

                // redirect to driver home
                response.sendRedirect("./DriverRinging");

            } else // not authenticated
                throw new AuthException("Invalid email or password");

        } catch (AuthException e) { // not authenticated exception
            response.sendRedirect("./DriverLogin?flag=invalid"); // redirect to login with invalid flag
            e.printStackTrace();
        } catch (EmptyInputsException e) { // empty inputs exception
            response.sendRedirect("./DriverLogin"); // redirect to login
            e.printStackTrace();
        } finally {
            System.out.println("Login attempt by driver"); // log
        }

    }
}
