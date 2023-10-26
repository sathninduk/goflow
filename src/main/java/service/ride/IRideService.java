package service.ride;

import model.Driver;
import model.Ride;
import model.Rider;
import model.VehicleType;
import service.rider.IRiderService;

import java.util.ArrayList;
import java.util.logging.Logger;

// interface - Data access object of Ride
public interface IRideService {

    // Java logger
    Logger log = Logger.getLogger(IRiderService.class.getName());

    // add a ride
    int addRide(Ride ride);

    Ride getRideByID(int id);

    boolean checkRideExists(int id);

    ArrayList<Ride> getRidesByStatusAndVehicle(String status, VehicleType vehicleTypeIn);

    ArrayList<Ride> getRideByRider(Rider rider);

    void updateRideStatus(int id, String status, Driver driver);

    void removeRide(int id);
}
