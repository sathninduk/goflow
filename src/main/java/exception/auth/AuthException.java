package exception.auth;

// This class is used to throw an exception if the user is not authenticated
public class AuthException extends Exception {
    public AuthException(String message) { // end constructor
        super(message);
    }
}
