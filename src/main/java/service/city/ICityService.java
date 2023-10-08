package service.city;

import java.util.ArrayList;
import model.City;

public interface ICityService {
    City getCityByID(int id);
    City getCityByName(String name);
    ArrayList<City> getCities();
    ArrayList<City> getCitiesBySearch(String cityString);
}
