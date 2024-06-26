package controller.ride;

import exception.common.EmptyInputsException;
import exception.ride.RideDistanceException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.ride.Factory.RideFactory;
import model.Ride;
import model.Rider;
import model.VehicleType;
import service.ride.Factory.SearchDriverFactory;
import service.ride.IRideService;
import service.ride.RideServiceImpl;
import service.ride.SearchDriver;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

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

        try {

            // validate inputs
            if (request.getParameter("start_latitude").isEmpty() || request.getParameter("start_longitude").isEmpty()
                    || request.getParameter("end_latitude").isEmpty() || request.getParameter("end_longitude").isEmpty()
                    || request.getParameter("distance").isEmpty() || request.getParameter("fare").isEmpty()
                    || request.getParameter("vehicleType_id").isEmpty()) {
                throw new EmptyInputsException("All fields are required"); // check empty inputs
            } else if (Float.parseFloat(request.getParameter("distance")) < 1.0) {
                throw new RideDistanceException("Distance cannot be less than 1 km"); // check distance - min
            } else if (Float.parseFloat(request.getParameter("distance")) > 500.0) {
                throw new RideDistanceException("Distance cannot be greater than 500 km"); // check distance - max
            }

            // get vehicle type (object) from id
            IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
            VehicleType vehicleTypeForCheck = iVehicleTypeService.getVehicleTypeByID(Integer.parseInt(request.getParameter("vehicleType_id")));

            // check driver availability for the particular vehicle type
            SearchDriverFactory searchDriverFactory = new SearchDriverFactory(); // factory pattern
            SearchDriver searchDriver = searchDriverFactory.getSearchDriver(vehicleTypeForCheck.getName()); // get search driver object

            if (!searchDriver.driverAvailable()) { // check driver availability
                response.sendRedirect("./AddRide?type=start&flag=unavailable"); // redirect to dashboard with unavailable flag
                return;
            }

            // create ride object
            RideFactory rideFactory = new RideFactory(); // factory pattern
            Ride ride = rideFactory.getRide("PENDING"); // get pending ride object

            // set ride object
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

        } catch (EmptyInputsException e) {
            response.sendRedirect("./AddRide?type=start&flag=empty"); // redirect to dashboard with empty flag
            e.printStackTrace();
        } catch (RideDistanceException e) {
            response.sendRedirect("./AddRide?type=start&flag=distance"); // redirect to dashboard with distance flag
            e.printStackTrace();
        } finally {
            System.out.println("Ride attempt by a rider"); // log
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
