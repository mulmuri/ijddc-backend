package uos.urbanscience.ijddc.exception.httpstatus;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}