package service.rider;

import model.Rider;
import java.util.ArrayList;
import java.util.logging.Logger;

// This is the interface for the RiderService class
public interface IRiderService {

	// logger object
	Logger log = Logger.getLogger(IRiderService.class.getName());

	void addRider(Rider rider); // add rider method

	Rider getRiderByID(int id); // get rider by id method

	Rider getRiderByEmail(String email); // get rider by email method

	ArrayList<Rider> getRiders(); // get all riders method

	Rider updateRider(int id, Rider rider); // update rider method

	void removeRider(int id); // remove rider method
}
