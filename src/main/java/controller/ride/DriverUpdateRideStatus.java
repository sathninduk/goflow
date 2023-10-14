package controller.ride;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Ride;
import service.ride.IRideService;
import service.ride.RideServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class DriverUpdateRideStatus
 */
public class DriverUpdateRideStatus extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverUpdateRideStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        IRideService iRideService = new RideServiceImpl();
        boolean rideExists = iRideService.checkRideExists(Integer.parseInt(request.getParameter("id")));

        if (rideExists) {
            // update
            iRideService.updateRideStatus(Integer.parseInt(request.getParameter("id")), request.getParameter("status"));
            // redirect
            String redirectURL = "./DriverRideStatus?id=" + request.getParameter("id");
            response.sendRedirect(redirectURL);
        } else {
            // redirect
            String redirectURL = "./DriverRinging";
            response.sendRedirect(redirectURL);
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
