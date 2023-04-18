package uos.urbanscience.ijddc.domain.service.paper;

import uos.urbanscience.ijddc.domain.value.paper.Paper;
import uos.urbanscience.ijddc.domain.value.user.User;

public class PaperContentService {

    public long createPaper(Paper paper, User user) {
        paper.setAuthorId(user.getUserId());
    }

    public long getPaperWriterId() {

    }

    public Paper readPaper() {

    }

    public void updatePaper(Paper paper) {

    }

    public void deletePaper(long paperId) {

    }
}
