package controller.vehicleType;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VehicleType;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class UpdateVehicleType
 */
public class UpdateVehicleType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateVehicleType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");

		VehicleType vehicleType = new VehicleType();

		String vehicleTypeID = request.getParameter("vehicleTypeID");

		vehicleType.setVehicle_id(Integer.parseInt(vehicleTypeID));

		vehicleType.setName(request.getParameter("name"));
		vehicleType.setRate(Float.parseFloat(request.getParameter("rate")));

		IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
		iVehicleTypeService.updateVehicleType(Integer.parseInt(vehicleTypeID), vehicleType);

		request.setAttribute("msg", "VehicleType updated successfully");

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VehicleType/Notification.jsp");
		dispatcher.forward(request, response);
	}

}
