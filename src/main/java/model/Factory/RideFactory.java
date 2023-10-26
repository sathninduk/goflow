package model.Factory;

import model.ActiveRide;
import model.PendingRide;
import model.Ride;

public class RideFactory {
    public Ride getRide(String rideType) {
        if (rideType == null) {
            return null;
        }
        if (rideType.equalsIgnoreCase("ACTIVE")) {
            return new ActiveRide();
        } else if (rideType.equalsIgnoreCase("PENDING")) {
            return new PendingRide();
        }
        return null;
    }
}
