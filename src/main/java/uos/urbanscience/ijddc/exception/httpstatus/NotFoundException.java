package uos.urbanscience.ijddc.exception.httpstatus;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}