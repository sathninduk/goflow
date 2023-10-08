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
 * Servlet implementation class GetDriver
 */
public class GetDriver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetDriver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String driverID = request.getParameter("driverID");

		IDriverService iDriverService = new DriverServiceImpl();
		Driver driver = iDriverService.getDriverByID(Integer.parseInt(driverID));

		//System.out.println(driver);
		request.setAttribute("driver", driver);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Driver/GetDriver.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
