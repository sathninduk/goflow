package model;

// This class is used to create VehicleType object
public class VehicleType {

    // attributes
    private int vehicle_id;
    private String name;
    private float rate;

    // default constructor
    public VehicleType() {
    }

    // parameterized constructor
    public VehicleType(int vehicle_id, String name, float rate) {
        this.vehicle_id = vehicle_id;
        this.name = name;
        this.rate = rate;
    }

    // getters and setters
    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getRate() {
        return this.rate;
    }

    // toString method
    public String toString() {
        return "Vehicle ID = " + this.vehicle_id + "\n" + "Vehicle Name = " + this.name + "\n" + "Rate = " + this.rate;
    }
}

