package uos.urbanscience.ijddc.infrastructure.database.repository;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uos.urbanscience.ijddc.infrastructure.database.entity.UserAuth;

@Repository
public interface UserAuthRepository extends JpaRepository<UserAuth, Long> {

}
