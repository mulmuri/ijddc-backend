package uos.urbanscience.ijddc.domain.value.policy;

import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReviewerPolicy {

    private static List<PaperStatus> getAll() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.assigned,
                PaperStatus.reviewed,
                PaperStatus.polishing,
                PaperStatus.confirmed,
                PaperStatus.rejected,
                PaperStatus.issued
        ));
    }

    private static ArrayList<PaperStatus> getWaiting() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.reviewed
        ));
    }

    private static ArrayList<PaperStatus> getActionRequired() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.assigned
        ));
    }

    private static ArrayList<PaperStatus> getFinished() {
        return new ArrayList<PaperStatus> (Arrays.asList(
                PaperStatus.polishing,
                PaperStatus.confirmed,
                PaperStatus.rejected,
                PaperStatus.issued
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
