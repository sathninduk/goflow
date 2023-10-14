package service.ride;

import model.Ride;
import service.rider.IRiderService;

import java.util.ArrayList;
import java.util.logging.Logger;

public interface IRideService {
    Logger log = Logger.getLogger(IRiderService.class.getName());

    int addRide(Ride ride);

    Ride getRideByID(int id);

    boolean checkRideExists(int id);

    ArrayList<Ride> getRides();

    ArrayList<Ride> getRidesByStatus(String status);

    Ride updateRide(int id, Ride ride);

    Ride updateRideStatus(int id, String status);

    void removeRide(int id);
}
