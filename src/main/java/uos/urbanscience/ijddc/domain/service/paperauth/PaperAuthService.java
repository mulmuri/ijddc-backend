package uos.urbanscience.ijddc.domain.service.paperauth;

import uos.urbanscience.ijddc.domain.value.policy.*;
import uos.urbanscience.ijddc.domain.value.user.Role;
import uos.urbanscience.ijddc.domain.value.user.User;

public class PaperAuthService {

    private final ReviewAuthService reviewAuthService;

    public PaperAuthService(ReviewAuthService reviewAuthService) {
        this.reviewAuthService = reviewAuthService;
    }

    public boolean isReadable(long paperId, long writerId, PaperStatus paperStatus, User user) {

        if (paperStatus == PaperStatus.issued) {
            return true;
        }

        if (user.hasRole(Role.contributor)) {
            if (writerId == user.getUserId()) {
                return true;
            }
        }

        if (user.hasRole(Role.reviewer)) {
            if (Policy.get(Role.reviewer, PaperGroupStatus.all).contains(paperStatus) && reviewAuthService.isReviewer(paperId, user.getUserId())) {
                return true;
            }
        }

        if (user.hasRole(Role.editor)) {
            if (Policy.get(Role.reviewer, PaperGroupStatus.all).contains(paperStatus)) {
                return true;
            }
        }

        return false;
    }

    public boolean isWriteable(User user) {
        return (user.hasRole(Role.contributor));
    }

    public boolean isDeletable(long writerId, PaperStatus paperStatus, User user) {
        return (writerId == user.getUserId() && paperStatus == PaperStatus.writing);
    }

    public boolean isUpdatable(long writerId, PaperStatus paperStatus, User user) {
        return (writerId == user.getUserId() && Policy.get(Role.contributor, PaperGroupStatus.actionRequired).contains(paperStatus));
    }
}
