package controller.driver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Driver;
import service.driver.IDriverService;
import service.driver.DriverServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class AddDriver
 */
public class AddDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDriver() {
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

		Driver driver = new Driver();

		driver.setName(request.getParameter("name"));
		driver.setEmail(request.getParameter("email"));
		driver.setVehicleType(Integer.parseInt(request.getParameter("vehicleType")));
		driver.setPassword(request.getParameter("password"));
		driver.setTel(request.getParameter("tel"));

		IDriverService iDriverService = new DriverServiceImpl();
		iDriverService.addDriver(driver);

		request.setAttribute("msg", "Driver added successfully");

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Driver/Notification.jsp");
		dispatcher.forward(request, response);
	}

}
