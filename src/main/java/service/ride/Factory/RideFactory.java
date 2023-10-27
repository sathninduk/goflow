package service.ride.Factory;

import model.ActiveRide;
import model.PendingRide;
import model.Ride;

public class RideFactory { // RideFactory class
    public Ride getRide(String rideType) { // getRide method
        if (rideType == null) {
            return null;
        }
        if (rideType.equalsIgnoreCase("ACTIVE")) { // if rideType is ACTIVE
            return new ActiveRide();
        } else if (rideType.equalsIgnoreCase("PENDING")) { // if rideType is PENDING
            return new PendingRide();
        }
        return null;
    }
}
