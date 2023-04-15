package uos.urbanscience.ijddc.domain.port;

import uos.urbanscience.ijddc.domain.value.paper.PaperSummary;

import java.util.ArrayList;

public interface PaperListPersistance {
    ArrayList<PaperSummary> findPaperListByUser(Long userId);
    ArrayList<PaperSummary> findPaperListByStatus(String[] status);
    ArrayList<PaperSummary> findPaperListByUserStatus(Long userId, String[] status);
}
