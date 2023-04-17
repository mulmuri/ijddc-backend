package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "paper")
@Getter
@Setter

public class Paper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paperId;

    private Long publisherId;
    private Short status;

    @Column(name = "abstract")
    private String paperAbstract;

    private String reference;
    private String author;
    private String pages;
    private String title;
    private String doi;
}
