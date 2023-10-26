package service.ride;

import model.Driver;
import model.VehicleType;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.util.ArrayList;

public class SearchBikeDriver implements SearchDriver {

    @Override
    public boolean driverAvailable() {

        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
        VehicleType vehicleType = iVehicleTypeService.getVehicleTypeByName("Bike");

        IDriverService iDriverService = new DriverServiceImpl();
        ArrayList<Driver> driver = iDriverService.getDriversByVehicleType(vehicleType.getVehicle_id());

        if (!driver.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
}
