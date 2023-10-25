package controller.ride;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import jakarta.servlet.http.HttpSession;
import service.ride.IRideService;
import service.ride.RideServiceImpl;

/**
 * Servlet implementation class DeleteRide
 */
public class DeleteRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRide() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get ride id
		int id = Integer.parseInt(request.getParameter("id"));

		// delete ride
		IRideService iRideService = new RideServiceImpl();
		iRideService.removeRide(id);

		HttpSession session = request.getSession();
		session.removeAttribute("ride_id");

		// redirect
		if (request.getParameter("source").equals("cancel")) {
			String redirectURL = "./AddRide?type=start";
			response.sendRedirect(redirectURL);
		} else {
			String redirectURL = "./RidesHistory";
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
