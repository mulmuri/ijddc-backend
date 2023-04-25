package uos.urbanscience.ijddc.domain.value.user;


import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

public class UserRole {
    private final int memberDigit = 0;
    private final int managerDigit = 1;
    private final int contributorDigit = 2;
    private final int reviewerDigit = 3;
    private final int editorDigit = 4;

    private int code;
    public UserRole(int code) {
        this.code = code;
    }

    public boolean hasRole(Role role) {
        switch (role) {
            case member:      return (code & (1 << memberDigit)) != 0;
            case manager:     return (code & (1 << managerDigit)) != 0;
            case contributor: return (code & (1 << contributorDigit)) != 0;
            case reviewer:    return (code & (1 << reviewerDigit)) != 0;
            case editor:      return (code & (1 << editorDigit)) != 0;
            default: throw new UnknownEnumException(role);
        }
    }

    public int ToCode() {
        return code;
    }

    public static UserRole Default() {
        return new UserRole(1);
    }


}
