package fa.training.model;

import lombok.Data;

import java.util.Objects;

@Data
public class YearAndPublisher {

    private Integer publicationYear;

    private String publisher;

    public YearAndPublisher(Integer publicationYear, String publisher) {
        super();
        this.publicationYear = publicationYear;
        this.publisher = publisher;
    }

    @Override
    public int hashCode() {
        return Objects.hash(publicationYear, publisher);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        YearAndPublisher other = (YearAndPublisher) obj;
        return Objects.equals(publicationYear, other.publicationYear) && Objects.equals(publisher, other.publisher);
    }

    @Override
    public String toString() {
        return "YearAndPublisher [publicationYear=" + publicationYear + ", publisher=" + publisher + "]";
    }

}
