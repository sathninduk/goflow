package service.ride;

import model.Driver;
import model.VehicleType;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.util.ArrayList;

// This class is used to check if a car driver is available or not
public class SearchOtherDriver implements SearchDriver {
    @Override
    public boolean driverAvailable() { // check if driver is available

        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl(); // create object of IVehicleTypeService
        VehicleType vehicleTypeBike = iVehicleTypeService.getVehicleTypeByName("Bike"); // get vehicle type by name
        VehicleType vehicleTypeCar = iVehicleTypeService.getVehicleTypeByName("Car"); // get vehicle type by name
        VehicleType vehicleTypeTuk = iVehicleTypeService.getVehicleTypeByName("Tuk"); // get vehicle type by name

        int bikeId = vehicleTypeBike.getVehicle_id(); // get vehicle id
        int carId = vehicleTypeCar.getVehicle_id(); // get vehicle id
        int tukId = vehicleTypeTuk.getVehicle_id(); // get vehicle id

        // create object of IDriverService
        IDriverService iDriverService = new DriverServiceImpl();
        ArrayList<Driver> driver = iDriverService.getDrivers(); // get drivers

        for (int i = 0; i < driver.size(); i++) { // iterate through drivers
            // if driver vehicle type is bike or car or tuk
            if (driver.get(i).getVehicleType() == bikeId || driver.get(i).getVehicleType() == carId || driver.get(i).getVehicleType() == tukId) {
                driver.remove(i); // remove driver
                i--; // decrement i
            }
        }

        // if driver is not empty
        if (!driver.isEmpty()) {
            return true;
        } else { // if driver is empty
            return false;
        }

    }
}
