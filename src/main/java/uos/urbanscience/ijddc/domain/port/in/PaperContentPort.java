package uos.urbanscience.ijddc.domain.port.in;

import uos.urbanscience.ijddc.domain.value.paper.Paper;
import uos.urbanscience.ijddc.domain.value.user.User;

public interface PaperContentPort {
    public long createPaper(Paper paper, User user);
    public void updatePaper(Paper paper, User user);
    public void deletePaper(long paperId, User user);
    public Paper readPaper(long paperId, User user);
}
