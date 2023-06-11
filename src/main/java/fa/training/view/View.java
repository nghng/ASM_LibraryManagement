package fa.training.view;

import fa.training.model.Book;
import fa.training.model.Magazine;
import fa.training.model.Publication;
import fa.training.service.BookService;
import fa.training.utils.Validator;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class View {
    private static View instance;

    public static View getInstance() {
        if (instance == null) {
            instance = new View();
        }
        return instance;
    }

    public int menu() {
        System.out.println("");

        System.out.println("===== LIBRARY MANAGEMENT SYSTEM =====");

        System.out.println("1. Add a book.");
        System.out.println("2. Add a magazine.");
        System.out.println("3. Display books and magazines.");
        System.out.println("4. Add author to book.");
        System.out.println("5. Display top 10 of magazines by volume.");
        System.out.println("6. Search book by (isbn, author, publisher).");
        System.out.println("0. Exit.");
        System.out.println("======================================");
        System.out.println("Please choose function you'd like to do:");
        return Validator.getInstance().validateChooseMenu(0, 6);
    }

    public int subMenu() {
        System.out.println();

        System.out.println("   1. Search book by isbn");
        System.out.println("   2. Search book by author");
        System.out.println("   3. Search book by publisher");
        System.out.println("   4. Exit");
        System.out.println("Please choose function you'd like to do: ");

        return Validator.getInstance().validateChooseMenu(1, 4);
    }

    public Book inputBook(List<Publication> publicationList) {
        String isbn = BookService.getInstance().checkInputISBN(publicationList);

        Set<String> author = Validator.getInstance().validationAuthor("Author: ");

        String publicationPlace = Validator.getInstance().validateStringInput("Publication Place: ");

        String publisher = Validator.getInstance().validateStringInput("Publisher: ");

        LocalDate publicationDate = Validator.getInstance().validateDate("Publication Date: (dd/MM/YYYY)");

        return new Book(publicationDate.getYear(), publisher, publicationDate, isbn, author, publicationPlace);
    }

    public Magazine inputMagazine() {
        String author = Validator.getInstance().validateStringInput("Author: ");

        Integer volume = Validator.getInstance().validateIntInput("Volume: ");

        Integer edition = Validator.getInstance().validateIntInput("Edition: ");

        String publisher = Validator.getInstance().validateStringInput("Publisher: ");

        LocalDate publicationDate = Validator.getInstance().validateDate("Publication Date: ");

        return new Magazine(publicationDate.getYear(), publisher, publicationDate, author, volume, edition);
    }
}
