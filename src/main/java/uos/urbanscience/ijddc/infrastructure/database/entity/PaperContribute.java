package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "paper_contribute")
@Getter
@Setter

public class PaperContribute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paperId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submittedAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date publishedAt;
}
