package model;

 import java.util.Date;

 // This class is used to create Ride object
public class PendingRide extends Ride {

    // default constructor
    public PendingRide() {
        super();
    }

    // parameterized constructor
    public PendingRide(int rideId, float start_latitude, float start_longitude, float end_latitude, float end_longitude, VehicleType vehicleType, float distance, float fare, Date date_time, Rider rider, String status) {
    	super(rideId, start_latitude, start_longitude, end_latitude, end_longitude, vehicleType, distance, fare, date_time, rider, status);
    }
}
