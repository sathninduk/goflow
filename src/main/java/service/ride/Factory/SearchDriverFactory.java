package service.ride.Factory;

import service.ride.*;

public class SearchDriverFactory { // SearchDriverFactory class
    public SearchDriver getSearchDriver(String vehicleType) { // getSearchDriver method
        if (vehicleType.equals("Tuk")) { // if vehicleType is Tuk
            return new SearchTukDriver();
        } else if (vehicleType.equals("Car")) { // if vehicleType is Car
            return new SearchCarDriver();
        } else if (vehicleType.equals("Bike")) { // if vehicleType is Bike
            return new SearchBikeDriver();
        } else { // if vehicleType is Other
            return new SearchOtherDriver();
        }
    }
}
