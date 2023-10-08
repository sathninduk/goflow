package controller.ride;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.City;
import service.city.CityServiceImpl;
import service.city.ICityService;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ListCity
 */
public class ListCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");

		String cityString = request.getParameter("city");
		ICityService cityService = new CityServiceImpl();
		ArrayList<City> cityList = cityService.getCitiesBySearch(cityString);

		Gson gson = new Gson();
		String cityListJson = gson.toJson(cityList);

		response.getWriter().append(cityListJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
