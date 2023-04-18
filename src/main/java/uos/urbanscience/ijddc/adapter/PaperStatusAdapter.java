package uos.urbanscience.ijddc.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import uos.urbanscience.ijddc.domain.port.out.PaperStatusPort;
import uos.urbanscience.ijddc.domain.value.policy.PaperStatus;
import uos.urbanscience.ijddc.infrastructure.database.repository.PaperRepository;
import uos.urbanscience.ijddc.exception.httpstatus.NotFoundException;

public class PaperStatusAdapter implements PaperStatusPort {

    private final PaperRepository paperRepository;

    @Autowired
    public PaperStatusAdapter(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public PaperStatus getPaperStatus(long paperId) {
        int code = paperRepository.getStatusById(paperId).orElseThrow(() -> new  NotFoundException("paper not found"));
        return PaperStatus.fromId(code);
    }

    public void setPaperStatus(long paperId, PaperStatus status) {
        paperRepository.updateStatusById(Short.valueOf((short) status.toCode()), paperId);
    }
}
