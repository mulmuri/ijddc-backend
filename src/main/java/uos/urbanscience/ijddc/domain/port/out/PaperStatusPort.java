package uos.urbanscience.ijddc.domain.port.out;

import uos.urbanscience.ijddc.domain.value.policy.PaperStatus;

public interface PaperStatusPort {
    PaperStatus getPaperStatus(long paperId);
    void setPaperStatus(long paperId, PaperStatus status);
}
