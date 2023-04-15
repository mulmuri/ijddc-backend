package uos.urbanscience.ijddc.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uos.urbanscience.ijddc.infrastructure.database.entity.PaperReview;
import uos.urbanscience.ijddc.infrastructure.database.entity.PaperReviewId;

@Repository
public interface PaperReviewRepository extends JpaRepository<PaperReview, PaperReviewId> {

}
