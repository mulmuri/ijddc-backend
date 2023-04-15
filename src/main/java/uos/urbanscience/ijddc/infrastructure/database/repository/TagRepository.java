package uos.urbanscience.ijddc.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uos.urbanscience.ijddc.infrastructure.database.entity.Tag;
import uos.urbanscience.ijddc.infrastructure.database.entity.TagId;

@Repository
public interface TagRepository extends JpaRepository<Tag, TagId> {

}
