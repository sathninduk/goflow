package service.auth;

import model.Rider;
import service.rider.IRiderService;
import service.rider.RiderServiceImpl;
import util.Md5;

public class AuthService implements IAuthService{
    public AuthService() {
    }

    public boolean login(String email, String password) {

        IRiderService iRiderService = new RiderServiceImpl();
        Rider rider = iRiderService.getRiderByEmail(email);

        String dbUname = rider.getEmail();
        String dbPwd = rider.getPassword();

        String hashedPassword = Md5.generate(password);

        return email.equals(dbUname) && hashedPassword.equals(dbPwd);
    }
}
