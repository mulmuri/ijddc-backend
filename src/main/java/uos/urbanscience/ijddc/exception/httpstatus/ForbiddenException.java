package uos.urbanscience.ijddc.exception.httpstatus;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String message) {
        super(message);
    }
}