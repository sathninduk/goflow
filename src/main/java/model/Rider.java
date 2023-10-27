package model;

// This class is used to store rider information
public class Rider {

	// attributes
	private int id;
    private String name;
    private String email;
    private String password;
    private String tel;

	// default constructor
    public Rider() {
    	
    }

	// parameterized constructor
    public Rider(int uid, String name, String email, String password, String tel) {
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
	        return "Rider ID = " + this.id + "\n" + "Rider Name = " + this.name + "\n" + "Email = " + this.email + "\n" + "Telephone = " + this.tel;
	 }
    
   
}
