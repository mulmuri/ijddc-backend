package uos.urbanscience.ijddc.infrastructure.database.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tag")
@Getter
@Setter

public class Tag {
    @EmbeddedId
    private TagId id;
}
