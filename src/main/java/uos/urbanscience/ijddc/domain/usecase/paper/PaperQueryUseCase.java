package uos.urbanscience.ijddc.domain.usecase.paper;

import uos.urbanscience.ijddc.domain.value.policy.PaperGroupStatus;
import uos.urbanscience.ijddc.domain.value.paper.PaperSummary;
import uos.urbanscience.ijddc.domain.value.user.Role;

import java.util.List;

public class PaperQueryUseCase {

    public List<PaperSummary> queryPaperList(Role role, long userId, String keyword, PaperGroupStatus status) {
        
    }

    public List<PaperSummary> queryPublicPaperList(long archiveId, String keyword) {

    }

}
