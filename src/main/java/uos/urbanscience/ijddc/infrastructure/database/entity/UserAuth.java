package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_auth")
@Getter
@Setter

public class UserAuth {
    @Id
    private String email;
    private String password;
    private Long userId;
    private Integer role;
}
