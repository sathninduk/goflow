package service.city;

import java.util.ArrayList;
import model.City;

// This is the interface for the CityService class
public interface ICityService {
    City getCityByID(int id); // get city by id method
    City getCityByName(String name); // get city by name method
    ArrayList<City> getCities(); // get all cities method
    ArrayList<City> getCitiesBySearch(String cityString); // get cities by searching method
}
