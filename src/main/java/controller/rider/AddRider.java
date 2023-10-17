package controller.rider;

// himaya


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Rider;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;

/**
 * Servlet implementation class AddRider
 */
public class AddRider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRider() {
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
		
		Rider rider = new Rider();
		
		rider.setName(request.getParameter("name"));
		rider.setEmail(request.getParameter("email"));
		rider.setPassword(request.getParameter("password"));
		rider.setTel(request.getParameter("tel"));
		
		IRiderService iEmployeeService = new RiderServiceImpl();
        iEmployeeService.addRider(rider);
        
        request.setAttribute("msg", "Rider added successfully");
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Rider/Notification.jsp");
		dispatcher.forward(request, response);
	}

}
