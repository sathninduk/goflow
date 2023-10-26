package model;

import java.util.Date;

public class Ride {
    private int rideId;
    private float start_latitude;
    private float start_longitude;
    private float end_latitude;
    private float end_longitude;
    private VehicleType vehicleType;
    private float distance;
    private float fare;
    private Date date_time;

    //
    private Rider rider;
    private Driver driver;
    private String status;

    public Ride() {
        this.rideId = 0;
        this.start_latitude = 0;
        this.start_longitude = 0;
        this.end_latitude = 0;
        this.end_longitude = 0;
        this.vehicleType = null;
        this.distance = 0;
        this.fare = 0;
        this.date_time = null;
        this.rider = null;
        this.driver = null;
        this.status = null;
    }

    public Ride(int rideId, float start_latitude, float start_longitude, float end_latitude, float end_longitude, VehicleType vehicleType, float distance, float fare, Date date_time, Rider rider, Driver driver, String status) {
    	this.rideId = rideId;
    	this.start_latitude = start_latitude;
    	this.start_longitude = start_longitude;
    	this.end_latitude = end_latitude;
    	this.end_longitude = end_longitude;
    	this.vehicleType = vehicleType;
    	this.distance = distance;
    	this.fare = fare;
    	this.date_time = date_time;
    	this.rider = rider;
    	this.driver = driver;
    	this.status = status;
    }

    public int getRideId() {
    	return this.rideId;
    }

    public void setRideId(int rideId) {
        this.rideId = rideId;
    }

    public float getStart_latitude() {
    	return this.start_latitude;
    }

    public void setStart_latitude(float start_latitude) {
    	this.start_latitude = start_latitude;
    }

    public float getStart_longitude() {
    	return this.start_longitude;
    }

    public void setStart_longitude(float start_longitude) {
    	this.start_longitude = start_longitude;
    }

    public float getEnd_latitude() {
    	return this.end_latitude;
    }

    public void setEnd_latitude(float end_latitude) {
    	this.end_latitude = end_latitude;
    }

    public float getEnd_longitude() {
    	return this.end_longitude;
    }

    public void setEnd_longitude(float end_longitude) {
    	this.end_longitude = end_longitude;
    }

    public VehicleType getVehicleType() {
    	return this.vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
    	this.vehicleType = vehicleType;
    }

    public float getDistance() {
    	return this.distance;
    }

    public void setDistance(float distance) {
    	this.distance = distance;
    }

    public float getFare() {
    	return this.fare;
    }

    public void setFare(float fare) {
    	this.fare = fare;
    }

    public Date getDate_time() {
    	return this.date_time;
    }

    public void setDate_time(Date date_time) {
    	this.date_time = date_time;
    }

    public Rider getRider() {
    	return this.rider;
    }

    public void setRider(Rider rider) {
    	this.rider = rider;
    }

    public Driver getDriver() {
    	return this.driver;
    }

    public void setDriver(Driver driver) {
    	this.driver = driver;
    }

    public String getStatus() {
    	return this.status;
    }

    public void setStatus(String status) {
    	this.status = status;
    }



}
