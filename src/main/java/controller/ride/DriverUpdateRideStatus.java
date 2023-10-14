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

		response.setContentType("text/html");
		request.setAttribute("id", request.getParameter("id"));

		IRideService iRideService = new RideServiceImpl();
		Ride ride = iRideService.updateRideStatus(Integer.parseInt(request.getParameter("id")), "wait_pickup");

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Ride/DriverUpdateRideStatus.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
