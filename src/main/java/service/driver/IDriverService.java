package service.driver;

import model.Driver;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface IDriverService {
    Logger log = Logger.getLogger(IDriverService.class.getName());

    void addDriver(Driver driver);

    Driver getDriverByID(int id);

    Driver getDriverByEmail(String email);

    ArrayList<Driver> getDrivers();

    ArrayList<Driver> getDriversByVehicleType(int vehicleTypeId);

    Driver updateDriver(int id, Driver driver);

    void removeDriver(int id);
}
