package model;

public class VehicleType {
    private int vehicle_id;
    private String name;
    private float rate;

    public VehicleType() {
    }

    public VehicleType(int vehicle_id, String name, float rate) {
        this.vehicle_id = vehicle_id;
        this.name = name;
        this.rate = rate;
    }

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

    public String toString() {
        return "Vehicle ID = " + this.vehicle_id + "\n" + "Vehicle Name = " + this.name + "\n" + "Rate = " + this.rate;
    }
}

