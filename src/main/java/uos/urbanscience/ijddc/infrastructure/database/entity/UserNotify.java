package uos.urbanscience.ijddc.infrastructure.database.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_info")
@Getter
@Setter

public class UserNotify {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long notifyId;
    private Long userId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    private String message;
    private String link;
}
