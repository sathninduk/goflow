package service.ride;

import model.Driver;
import model.Ride;
import model.Rider;
import model.VehicleType;
import service.rider.IRiderService;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IRideService {
    Logger log = Logger.getLogger(IRiderService.class.getName());

    int addRide(Ride ride);

    Ride getRideByID(int id);

    boolean checkRideExists(int id);

    ArrayList<Ride> getRides();

    ArrayList<Ride> getRidesByStatusAndVehicle(String status, VehicleType vehicleTypeIn);

    ArrayList<Ride> getRideByRider(Rider rider);

    Ride updateRide(int id, Ride ride);

    void updateRideStatus(int id, String status, Driver driver);

    void removeRide(int id);
}
