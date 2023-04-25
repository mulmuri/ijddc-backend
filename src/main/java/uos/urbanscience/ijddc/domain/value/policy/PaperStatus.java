package uos.urbanscience.ijddc.domain.value.policy;

import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

public enum PaperStatus {
    writing(0, "writing"),
    cancelled(1, "cancelled"),
    submitted(2, "submitted"),
    denied(3, "denied"),
    assigned(4, "assigned"),
    reviewed(5, "reviewed"),
    polishing(6, "polishing"),
    confirmed(7, "confirmed"),
    rejected(8, "rejected"),
    issued(9, "issued");

    private final int id;
    private final String name;

    private PaperStatus(int number, String name) {
        this.id = number;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public int toCode() {
        return this.id;
    }

    public static PaperStatus fromId(int id) {
        for (PaperStatus status : values()) {
            if (status.id == id) {
                return status;
            }
        }

        throw new UnknownEnumException();
    }
}
