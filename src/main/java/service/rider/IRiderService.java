package service.rider;

import model.Rider;
import java.util.ArrayList;
import java.util.logging.Logger;

public interface IRiderService {
	Logger log = Logger.getLogger(IRiderService.class.getName());

	void addRider(Rider rider);

	Rider getRiderByID(int id);

	Rider getRiderByEmail(String email);

	ArrayList<Rider> getRiders();

	Rider updateRider(int id, Rider rider);

	void removeRider(int id);
}
