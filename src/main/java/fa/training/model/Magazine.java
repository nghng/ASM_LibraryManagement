package fa.training.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Magazine extends Publication {

    private String author;

    private Integer volume;

    private Integer edition;

    public Integer getVolume() {
        return volume;
    }

    public Magazine(Integer publicationYear, String publisher, LocalDate publicationDate, String author, Integer volume, Integer edition) {
        super(publicationYear, publisher, publicationDate);
        this.author = author;
        this.volume = volume;
        this.edition = edition;
    }

    public Magazine(Integer publicationYear, String publisher, LocalDate publicationDate) {
        super(publicationYear, publisher, publicationDate);
    }



    @Override
    public String toString() {
        return "Magazine{" + "publicationYear : " + getPublicationYear() +
                ", publisher : " + getPublisher() +
                ", publicationDate: " + getPublicationDate() + " " +
                "author='" + author + '\'' +
                ", volume=" + volume +
                ", edition=" + edition +
                '}' + "\n";
    }

    @Override
    protected void display() {
        System.out.println(this);
    }

}
