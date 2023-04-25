package uos.urbanscience.ijddc.exception.invalid;


public class InvalidPaperStatusException extends RuntimeException {

    public InvalidPaperStatusException() {
        super("invalid paper status switching");
    }
}
