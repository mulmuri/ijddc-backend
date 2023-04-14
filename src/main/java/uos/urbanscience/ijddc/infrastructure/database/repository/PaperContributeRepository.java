package uos.urbanscience.ijddc.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uos.urbanscience.ijddc.infrastructure.database.entity.PaperContribute;

@Repository
public interface PaperContributeRepository extends JpaRepository<PaperContribute, Long> {
}
