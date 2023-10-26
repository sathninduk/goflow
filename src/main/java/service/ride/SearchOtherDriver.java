package service.ride;

import model.Driver;
import model.VehicleType;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.vehicleType.IVehicleTypeService;
import service.vehicleType.IVehicleTypeServiceImpl;

import java.util.ArrayList;

public class SearchOtherDriver implements SearchDriver {
    @Override
    public boolean driverAvailable() {

        IVehicleTypeService iVehicleTypeService = new IVehicleTypeServiceImpl();
        VehicleType vehicleTypeBike = iVehicleTypeService.getVehicleTypeByName("Bike");
        VehicleType vehicleTypeCar = iVehicleTypeService.getVehicleTypeByName("Car");
        VehicleType vehicleTypeTuk = iVehicleTypeService.getVehicleTypeByName("Tuk");

        int bikeId = vehicleTypeBike.getVehicle_id();
        int carId = vehicleTypeCar.getVehicle_id();
        int tukId = vehicleTypeTuk.getVehicle_id();

        IDriverService iDriverService = new DriverServiceImpl();
        ArrayList<Driver> driver = iDriverService.getDrivers();

        for (int i = 0; i < driver.size(); i++) {
            if (driver.get(i).getVehicleType() == bikeId || driver.get(i).getVehicleType() == carId || driver.get(i).getVehicleType() == tukId) {
                driver.remove(i);
                i--;
            }
        }

        if (!driver.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
