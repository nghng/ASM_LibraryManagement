package fa.training.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class Book extends Publication {

    private String isbn;

    private Set<String> author;

    private String publicationPlace;


    public Book(Integer publicationYear, String publisher, LocalDate publicationDate, String isbn, Set<String> author, String publicationPlace) {
        super(publicationYear, publisher, publicationDate);
        this.isbn = isbn;
        this.author = author;
        this.publicationPlace = publicationPlace;
    }





    @Override
    protected void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Book{" + "publicationYear : " + getPublicationYear() +
                ", publisher : " + getPublisher() +
                ", publicationDate: " + getPublicationDate() + " " +
                "isbn='" + isbn + '\'' +
                ", author=" + author +
                ", publicationPlace='" + publicationPlace + '\'' +
                '}' + "\n";
    }
}
