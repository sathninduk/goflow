package service.ride;

import model.Driver;
import model.VehicleType;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.util.ArrayList;

// This class is used to check if a tuk driver is available or not
public class SearchTukDriver implements SearchDriver {

    @Override
    public boolean driverAvailable() { // check if driver is available

        // create object of IVehicleTypeService
        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
        VehicleType vehicleType = iVehicleTypeService.getVehicleTypeByName("Tuk"); // get vehicle type by name

        // create object of IDriverService
        IDriverService iDriverService = new DriverServiceImpl();
        // get drivers by vehicle type
        ArrayList<Driver> driver = iDriverService.getDriversByVehicleType(vehicleType.getVehicle_id());

        if (!driver.isEmpty()) { // if driver is not empty
            return true;
        } else { // if driver is empty
            return false;
        }

    }

}
