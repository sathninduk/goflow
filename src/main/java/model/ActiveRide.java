package model;

import java.util.Date;

public class ActiveRide extends Ride {

    private Driver driver;

    public ActiveRide() {
        super();
        this.driver = null;
    }

    public ActiveRide(int rideId, float start_latitude, float start_longitude, float end_latitude, float end_longitude, VehicleType vehicleType, float distance, float fare, Date date_time, Rider rider, Driver driver, String status) {
    	super(rideId, start_latitude, start_longitude, end_latitude, end_longitude, vehicleType, distance, fare, date_time, rider, status);
    	this.driver = driver;
    }

    public Driver getDriver() {
    	return this.driver;
    }

    public void setDriver(Driver driver) {
    	this.driver = driver;
    }
}
