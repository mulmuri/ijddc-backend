package uos.urbanscience.ijddc.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uos.urbanscience.ijddc.infrastructure.database.entity.PaperIssued;

@Repository
public interface PaperIssuedRepository extends JpaRepository<PaperIssued, Long> {

}
