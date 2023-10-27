package exception.common;

// This class is used to throw an exception if the inputs are empty
public class EmptyInputsException extends Exception {
    public EmptyInputsException(String message) { // end constructor
        super(message);
    }
}
