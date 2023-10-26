package service.ride.Factory;

import service.ride.*;

public class SearchDriverFactory {
    public SearchDriver getSearchDriver(String vehicleType) {
        if (vehicleType.equals("Tuk")) {
            return new SearchTukDriver();
        } else if (vehicleType.equals("Car")) {
            return new SearchCarDriver();
        } else if (vehicleType.equals("Bike")) {
            return new SearchBikeDriver();
        } else {
            return new SearchOtherDriver();
        }
    }
}
