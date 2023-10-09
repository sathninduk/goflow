package controller.ride;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.City;
import model.Rider;
import service.city.CityServiceImpl;
import service.city.ICityService;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Servlet implementation class AddRide
 */
public class AddRide extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRide() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String step = request.getParameter("step");

        if (Objects.equals(step, "type")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Ride/AddRideType.jsp");
            dispatcher.forward(request, response);
        } else if (Objects.equals(step, "end")) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Ride/AddRideEnd.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Ride/AddRideStart.jsp");
            dispatcher.forward(request, response);
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
