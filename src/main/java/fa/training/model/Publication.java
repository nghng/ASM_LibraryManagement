package fa.training.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class Publication {

    private Integer publicationYear;

    private String publisher;

    private LocalDate publicationDate;

    public Publication(Integer publicationYear, String publisher, LocalDate publicationDate) {
        this.publicationYear = publicationYear;
        this.publisher = publisher;
        this.publicationDate = publicationDate;
    }

    public Publication() {
    }


    protected abstract void display();
}
