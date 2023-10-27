package service.auth;

// This interface is used to authenticate the user
public interface IAuthService {

    // login method
    boolean login(String email, String password, String role);
}
