package uos.urbanscience.ijddc.exception.httpstatus;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}