package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paper_issued")
@Getter
@Setter

public class PaperIssued {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long issuedNo;

    private Long paperId;
    @Column(name = "volumn_id")
    private Long archiveId;
}
