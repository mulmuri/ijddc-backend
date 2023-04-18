package uos.urbanscience.ijddc.domain.value.paper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uos.urbanscience.ijddc.domain.value.policy.PaperStatus;

@AllArgsConstructor
@Getter @Setter
public class Paper {
    private Long paperId;
    private String publisher;
    private String author;
    private long authorId;
    private String title;
    private String reference;

    private String pages;
    private String pdfurl;
    private PaperStatus status;
}
