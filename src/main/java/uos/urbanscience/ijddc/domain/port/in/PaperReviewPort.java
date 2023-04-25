package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.review.ReviewStatus;

import java.util.List;

public interface PaperReviewPort {
    void submitPaper(long userId, long paperId);
    void denyPaper(long paperId);
    void assignPaper(long userId, List<Long> reviewerIdList);
    void confirmPaper(long paperId, ReviewStatus status);
}
