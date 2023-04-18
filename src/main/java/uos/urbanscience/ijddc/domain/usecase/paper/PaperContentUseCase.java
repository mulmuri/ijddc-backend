package uos.urbanscience.ijddc.domain.usecase.paper;

import uos.urbanscience.ijddc.domain.port.in.PaperContentPort;
import uos.urbanscience.ijddc.domain.service.paper.PaperContentService;
import uos.urbanscience.ijddc.domain.service.paper.PaperStatusService;
import uos.urbanscience.ijddc.domain.service.paperauth.PaperAuthService;
import uos.urbanscience.ijddc.domain.exception.AuthorizationFailedException;
import uos.urbanscience.ijddc.domain.value.paper.Paper;
import uos.urbanscience.ijddc.domain.value.policy.PaperStatus;
import uos.urbanscience.ijddc.domain.value.user.User;

public class PaperContentUseCase implements PaperContentPort {

    PaperAuthService paperAuthService;
    PaperContentService paperContentService;
    PaperStatusService paperStatusService;

    public PaperContentUseCase(PaperAuthService paperAuthService, PaperContentService paperContentService) {
        this.paperAuthService = paperAuthService;
        this.paperContentService = paperContentService;
    }

    public long createPaper(Paper paper, User user) {
        if (!paperAuthService.isWriteable(user)) {
            throw new AuthorizationFailedException("not accessible");
        }

        return paperContentService.createPaper(paper, user);
    }

    public void updatePaper(Paper paper, User user) {
        PaperStatus paperStatus = paperStatusService.getPaperStatus(paper.getPaperId());

        if (!paperAuthService.isUpdatable(paper.getAuthorId(), paperStatus, user)) {
            throw new AuthorizationFailedException("failed to update paper");
        }

        paperContentService.updatePaper(paper);
    }

    public void deletePaper(long paperId, User user) {
        Paper paper = paperContentService.readPaper();

        if (!paperAuthService.isDeletable(paper.getAuthorId(), paper.getStatus(), user)) {
            throw new AuthorizationFailedException("failed to delete paper");
        }

        paperContentService.deletePaper(paperId);
    }

    public Paper readPaper(long paperId, User user) {
        Paper paper = paperContentService.readPaper();

        if (!paperAuthService.isReadable(paperId,  paper.getAuthorId(), paper.getStatus(), user)) {
            throw new AuthorizationFailedException("failed to fetch paper");
        };

        paperContentService.readPaper();
    }
}
