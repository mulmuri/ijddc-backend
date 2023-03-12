package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "user_email")
@Getter
@Setter

public class UserEmail {
    @Id
    private String email;
    private boolean conversation;
}
