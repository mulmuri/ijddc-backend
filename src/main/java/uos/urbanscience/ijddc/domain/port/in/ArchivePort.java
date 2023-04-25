package uos.urbanscience.ijddc.domain.port.in;

import java.util.List;

public interface ArchivePort {
    void publishArchive(List paperIdList);
}
