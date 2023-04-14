package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "volumn")
@Getter
@Setter

public class Archive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "volumn_id")
    private Long archiveId;

    private String title;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
}
