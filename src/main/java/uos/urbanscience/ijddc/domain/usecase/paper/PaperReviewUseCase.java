package uos.urbanscience.ijddc.domain.usecase.paper;

import jakarta.transaction.Transactional;
import uos.urbanscience.ijddc.domain.port.in.PaperReviewPort;
\import uos.urbanscience.ijddc.domain.service.paper.PaperStatusService;
import uos.urbanscience.ijddc.domain.service.review.PaperReviewService;
import uos.urbanscience.ijddc.domain.value.policy.PaperStatus;
import uos.urbanscience.ijddc.domain.value.review.Review;
import uos.urbanscience.ijddc.domain.value.review.ReviewStatus;
import uos.urbanscience.ijddc.exception.invalid.InvalidPaperStatusException;
import uos.urbanscience.ijddc.exception.service.UnknownEnumException;

import java.util.List;

public class PaperReviewUseCase implements PaperReviewPort {

    private PaperStatusService paperStatusService;
    private PaperReviewService paperReviewService;

    @Transactional
    public void submitPaper(long userId, long paperId) {
        PaperStatus status = paperStatusService.getPaperStatus(paperId);
        switch (status) {
            case writing, polishing -> paperStatusService.setPaperStatus(paperId, PaperStatus.submitted);
            default -> throw new InvalidPaperStatusException();
        }
    }

    public void denyPaper(long paperId) {

        PaperStatus status = paperStatusService.getPaperStatus(paperId);
        switch (status) {
            case submitted -> paperStatusService.setPaperStatus(paperId, PaperStatus.denied);
            default -> throw new InvalidPaperStatusException();
        }
    }

    @Transactional
    public void assignPaper(long paperId, List<Long> reviewerIdList) {

        for (long reviewerId: reviewerIdList) {
            paperReviewService.assignPaperReviewToReviewer(paperId, reviewerId);
        }

        paperStatusService.setPaperStatus(paperId, PaperStatus.assigned);
    }

    @Transactional
    public void submitReview(long reviewerId, long paperId, Review review) {
        // check all review is submitted

        if (paperReviewService.checkAllReviewSubmitted(paperId)) {
            paperStatusService.setPaperStatus(paperId, PaperStatus.reviewed);
        }
    }

    public void confirmPaper(long paperId, ReviewStatus status) {

        switch (status) {
            case Accept -> paperStatusService.setPaperStatus(paperId, PaperStatus.confirmed);
            case Revision -> paperStatusService.setPaperStatus(paperId, PaperStatus.polishing);
            case Reject -> paperStatusService.setPaperStatus(paperId, PaperStatus.rejected);
            default -> throw new UnknownEnumException(status);
        }
    }
}
