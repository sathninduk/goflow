package controller.ride;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Ride;
import model.Rider;
import model.VehicleType;
import service.ride.IRideService;
import service.ride.RideServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class RiderViewRideStatus
 */
public class RiderViewRideStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RiderViewRideStatus() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		Ride ride = new Ride();

		ride.setStart_latitude(Float.parseFloat(request.getParameter("start_latitude")));
		ride.setStart_longitude(Float.parseFloat(request.getParameter("start_longitude")));
		ride.setEnd_latitude(Float.parseFloat(request.getParameter("end_latitude")));
		ride.setEnd_longitude(Float.parseFloat(request.getParameter("end_longitude")));
		ride.setDistance(Float.parseFloat(request.getParameter("distance")));
		ride.setFare(Float.parseFloat(request.getParameter("fare")));

		// -- vehicle type
		VehicleType vehicleType = new VehicleType();
		vehicleType.setVehicle_id(Integer.parseInt(request.getParameter("vehicleType_id")));
		ride.setVehicleType(vehicleType);

		// -- rider
		HttpSession session = request.getSession();
		Rider rider = new Rider();
		rider.setID((Integer) session.getAttribute("id"));
		ride.setRider(rider);

		IRideService iRideService = new RideServiceImpl();
		int rideId = iRideService.addRide(ride);

		// -- set attribute
		request.setAttribute("ride_id", rideId);

		// redirect
		String redirectURL = "./RiderRideStatus?id=" + rideId;
		response.sendRedirect(redirectURL);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
