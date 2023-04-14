package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paper_review")
@Getter
@Setter

public class PaperReview {
    @EmbeddedId
    private TagId id;

    private String message;
    private short grade;
}
