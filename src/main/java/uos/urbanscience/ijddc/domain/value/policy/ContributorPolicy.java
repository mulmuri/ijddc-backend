package uos.urbanscience.ijddc.domain.value.policy;

import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContributorPolicy {

    private static List<PaperStatus> getAll() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.writing,
                PaperStatus.submitted,
                PaperStatus.denied,
                PaperStatus.assigned,
                PaperStatus.reviewed,
                PaperStatus.polishing,
                PaperStatus.confirmed,
                PaperStatus.rejected,
                PaperStatus.issued
        ));
    }

    private static List<PaperStatus> getWaiting() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.submitted,
                PaperStatus.assigned,
                PaperStatus.reviewed,
                PaperStatus.confirmed
        ));
    }

    private static List<PaperStatus> getActionRequired() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.writing,
                PaperStatus.polishing
        ));
    }

    private static List<PaperStatus> getFinished() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.rejected,
                PaperStatus.issued,
                PaperStatus.denied
        ));
    }

    protected static List<PaperStatus> getByGroupStatus(PaperGroupStatus status) {
        return switch (status) {
            case actionRequired -> getActionRequired();
            case finished -> getFinished();
            case waiting -> getWaiting();
            case all -> getAll();
            default -> throw new UnknownEnumException(status);
        };
    }
}
