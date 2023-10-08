package model;

public class Driver {

    private int id;
    private String name;
    private String email;
    private String password;
    private String tel;

    public Driver() {

    }

    public Driver(int uid, String name, String email, String password, String tel) {
        this.id = uid;
        this.name = name;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

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

    public String toString() {
        return "Driver ID = " + this.id + "\n" + "Driver Name = " + this.name + "\n" + "Email = " + this.email + "\n" + "Telephone = " + this.tel;
    }


}
