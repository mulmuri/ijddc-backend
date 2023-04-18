package uos.urbanscience.ijddc.domain.service.paperquery;

import uos.urbanscience.ijddc.domain.value.paper.PaperSummary;
import uos.urbanscience.ijddc.domain.value.policy.ContributorPolicy;
import uos.urbanscience.ijddc.domain.port.PaperListPersistance;

import java.util.ArrayList;

public class ContributorPaperSearchService extends PaperSearchService {
    PaperListPersistance db;
    ContributorPolicy policy;

    public ContributorPaperSearchService() {

    }

    public ArrayList<PaperSummary> QueryPaperAll() {
        ArrayList<String> statusList = new ArrayList<String>();
        policy.get();
        return new ArrayList<PaperSummary>();
    }
}
