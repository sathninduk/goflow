package model;

import java.util.Date;

// This class is used to create Ride object
public class ActiveRide extends Ride {

    // attributes
    private Driver driver; // driver

    // default constructor
    public ActiveRide() {
        super();
        this.driver = null;
    }

    // parameterized constructor
    public ActiveRide(int rideId, float start_latitude, float start_longitude, float end_latitude, float end_longitude, VehicleType vehicleType, float distance, float fare, Date date_time, Rider rider, Driver driver, String status) {
    	super(rideId, start_latitude, start_longitude, end_latitude, end_longitude, vehicleType, distance, fare, date_time, rider, status);
    	this.driver = driver;
    }

    // getters and setters
    public Driver getDriver() {
    	return this.driver;
    }

    public void setDriver(Driver driver) {
    	this.driver = driver;
    }
}
