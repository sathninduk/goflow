package model;

// This class is used to store the details of a city
public class City {

    // attributes
    private int id;
    private String name;
    private float latitude;
    private float longitude;

    // default constructor
    public City() {

    }

    // parameterized constructor
    public City(int id, String name, float latitude, float longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // getters and setters
    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    // toString method
    public String toString() {
        return "City ID = " + this.id + "\n" + "Driver Name = " + this.name + "\n" + "Latitude = " + this.latitude + "\n" + "Longitude = " + this.longitude;
    }
}
