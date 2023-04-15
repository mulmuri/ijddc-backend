package uos.urbanscience.ijddc.domain.port;

import uos.urbanscience.ijddc.domain.value.paper.PaperSummary;

import java.util.ArrayList;

public interface PaperListKeywordPersistance {
    ArrayList<PaperSummary> findPaperListByKeywordUser();
    ArrayList<PaperSummary> findPaperListByKeywordStatus();
    ArrayList<PaperSummary> findPaperListByKeywordUserStatus();
}
