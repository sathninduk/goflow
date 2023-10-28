package controller.vehicleType;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VehicleType;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class AddVehicleType
 */
public class AddVehicleType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request,response);
		response.setContentType( "text/html" );
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VehicleType/AddVehicleType.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");

			VehicleType vehicleType = new VehicleType();

			vehicleType.setName(request.getParameter("name"));
			vehicleType.setRate(Float.parseFloat(request.getParameter("rate")));

			IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
			iVehicleTypeService.addVehicleType(vehicleType);

			request.setAttribute("msg", "VehicleType added successfully");

			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/VehicleType/Notification.jsp");
			dispatcher.forward(request, response);
	}

}
