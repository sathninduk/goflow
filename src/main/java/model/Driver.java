package model;

// This class is used to store driver information
public class Driver {

    // attributes
    private int id;
    private String name;
    private String email;
    private int vehicleType;
    private String password;
    private String tel;

    // default constructor
    public Driver() {

    }

    // parameterized constructor
    public Driver(int uid, String name, String email, String password, String tel) {
        this.id = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    // getters and setters
    public int getID() {
        return id;
    }

    public void setID(int uid) {
        this.id = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(int vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    // toString method
    public String toString() {
        return "Driver ID = " + this.id + "\n" + "Driver Name = " + this.name + "\n" + "Email = " + this.email + "\n" + "Telephone = " + this.tel;
    }


}
