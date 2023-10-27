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

    // get ride by id
    Ride getRideByID(int id);

    // check if ride exists
    boolean checkRideExists(int id);

    // get rides by status and vehicle type
    ArrayList<Ride> getRidesByStatusAndVehicle(String status, VehicleType vehicleTypeIn);

    // get rides by rider
    ArrayList<Ride> getRideByRider(Rider rider);

    // update rides status
    void updateRideStatus(int id, String status, Driver driver);

    // remove ride
    void removeRide(int id);
}
