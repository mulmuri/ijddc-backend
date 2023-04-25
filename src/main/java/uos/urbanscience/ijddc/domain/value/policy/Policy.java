package uos.urbanscience.ijddc.domain.value.policy;

import uos.urbanscience.ijddc.domain.value.user.Role;
import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

import java.util.List;

public class Policy {

    public static List<PaperStatus> get(Role role, PaperGroupStatus status) {
        return switch (role) {
            case contributor -> ContributorPolicy.getByGroupStatus(status);
            case reviewer -> ReviewerPolicy.getByGroupStatus(status);
            case editor -> EditorPolicy.getByGroupStatus(status);
            default -> throw new UnknownEnumException(role);
        };
    }
}
