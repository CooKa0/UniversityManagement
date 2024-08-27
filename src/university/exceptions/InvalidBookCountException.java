package university.exceptions;

public class InvalidBookCountException extends RuntimeException {
    public InvalidBookCountException(String message) {
        super(message);
    }
}