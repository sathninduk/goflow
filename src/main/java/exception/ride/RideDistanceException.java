package exception.ride;

// This class is used to throw an exception if the distance is less than 1
public class RideDistanceException extends Exception {
    public RideDistanceException(String message) {
        super(message);
    } // end constructor
}
