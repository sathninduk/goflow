package service.ride;

import model.Driver;
import model.VehicleType;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.util.ArrayList;

// This class is used to check if a bike driver is available or not
public class SearchBikeDriver implements SearchDriver {

    @Override
    public boolean driverAvailable() { // check if driver is available

        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl(); // create object of IVehicleTypeService
        VehicleType vehicleType = iVehicleTypeService.getVehicleTypeByName("Bike"); // get vehicle type by name

        IDriverService iDriverService = new DriverServiceImpl(); // create object of IDriverService
        // get drivers by vehicle type
        ArrayList<Driver> driver = iDriverService.getDriversByVehicleType(vehicleType.getVehicle_id());

        if (!driver.isEmpty()) { // if driver is not empty
            return true;
        } else { // if driver is empty
            return false;
        }

    }
}
