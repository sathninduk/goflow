package controller.rider;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Rider;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;

import java.io.IOException;

/**
 * Servlet implementation class UpdateRider
 */
public class UpdateRider extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateRider() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		Rider rider = new Rider();
		
		String riderID = request.getParameter("riderID");
		
		rider.setID(Integer.parseInt(riderID));
		
		rider.setName(request.getParameter("name"));
		rider.setEmail(request.getParameter("email"));
		rider.setTel(request.getParameter("tel"));
		
		IRiderService iEmployeeService = new RiderServiceImpl();
        iEmployeeService.updateRider(Integer.parseInt(riderID), rider);
        
        request.setAttribute("msg", "Rider updated successfully");
        
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Common/Notification.jsp");
		dispatcher.forward(request, response);
	}

}
