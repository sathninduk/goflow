package service.driver;

import model.Driver;
import java.util.ArrayList;
import java.util.logging.Logger;

// This is the interface for the DriverService class
public interface IDriverService {

    // logger object
    Logger log = Logger.getLogger(IDriverService.class.getName());

    // add driver method
    void addDriver(Driver driver);

    // get driver by id method
    Driver getDriverByID(int id);

    // get driver by email method
    Driver getDriverByEmail(String email);

    // get all drivers method
    ArrayList<Driver> getDrivers();

    // get drivers by vehicle type method
    ArrayList<Driver> getDriversByVehicleType(int vehicleTypeId);

    // update driver method
    Driver updateDriver(int id, Driver driver);

    // remove driver method
    void removeDriver(int id);
}
