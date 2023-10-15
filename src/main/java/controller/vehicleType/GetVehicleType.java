package controller.vehicleType;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Rider;
import model.VehicleType;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class GetVehicleType
 */
public class GetVehicleType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVehicleType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		String vehicleTypeID = request.getParameter("vehicleTypeID");

		IVehicleTypeService iRiderService = new IVehicleTypeServiceImpl();
		VehicleType vehicleType = iRiderService.getVehicleTypeByID(Integer.parseInt(vehicleTypeID));

		request.setAttribute("vehicleType", vehicleType);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/VehicleType/GetVehicleType.jsp");
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
