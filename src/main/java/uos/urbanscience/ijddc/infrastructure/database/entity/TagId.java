package uos.urbanscience.ijddc.infrastructure.database.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class TagId implements Serializable {
    @Column(name = "paper_id")
    private Long paperId;

    @Column(name = "keyword")
    private String keyword;
}
