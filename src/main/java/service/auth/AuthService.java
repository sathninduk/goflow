package service.auth;

import model.Driver;
import model.Rider;
import service.driver.DriverServiceImpl;
import service.driver.IDriverService;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;
import util.Md5;

public class AuthService implements IAuthService {
    public AuthService() {
    }

    public boolean login(String email, String password, String role) {

        if (role.equals("Admin")) {

            String hashedPassword = Md5.generate(password);
            return email.equals("admin@admin.com") && hashedPassword.equals("d722dbcb93d6ca952b49928b37cac8e1");

        } else if (role.equals("Rider")) {

            IRiderService iRiderService = new RiderServiceImpl();
            Rider rider = iRiderService.getRiderByEmail(email);

            String dbUname = rider.getEmail();
            String dbPwd = rider.getPassword();

            String hashedPassword = Md5.generate(password);

            return email.equals(dbUname) && hashedPassword.equals(dbPwd);

        } else if (role.equals("Driver")) {

            IDriverService iDriverService = new DriverServiceImpl();
            Driver driver = iDriverService.getDriverByEmail(email);

            String dbUname = driver.getEmail();
            String dbPwd = driver.getPassword();

            String hashedPassword = Md5.generate(password);

            return email.equals(dbUname) && hashedPassword.equals(dbPwd);

        } else {
            return false;
        }

    }
}
