package uos.urbanscience.ijddc.exception.service;

public class UnknownEnumException extends RuntimeException {
    public <E extends Enum<E>> UnknownEnumException(E enumValue) {
        super(String.format("Unknown enum: %s", enumValue.toString()));
    }

    public UnknownEnumException() {
        super("enum not found");
    }
}