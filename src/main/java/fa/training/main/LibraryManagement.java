package fa.training.main;

import fa.training.model.Book;
import fa.training.model.Magazine;
import fa.training.model.Publication;
import fa.training.service.BookService;
import fa.training.service.MagazineService;
import fa.training.service.PublicationService;
import fa.training.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LibraryManagement {
    public static List<Publication> publications = new ArrayList<>();

    static void initData() {
        Book book1 = new Book(2001, "Hung",
                LocalDate.of(2001, 10, 01), "0-596-52067-9",
                new HashSet<>(Arrays.asList("John Doe", "Jane Smith")), "dqw");
        Book book2 = new Book(2002, "Hung 2",
                LocalDate.of(2002, 11, 03), "678-3-16-1234",
                new HashSet<>(Arrays.asList("John Doe", "Jane Smith")), "dqw");
        Book book3 = new Book(12, "Hung",
                LocalDate.of(2001, 10, 01), "678-3-16-325",
                new HashSet<>(Arrays.asList("John Doe", "Jane Smith")), "dqw");
        Book book4 = new Book(12, "Hung",
                LocalDate.of(2001, 10, 01), "678-3-16-436",
                new HashSet<>(Arrays.asList("John Doe", "Jane Smith")), "dqw");

        publications.addAll(List.of(book1, book2, book3, book4));


        Magazine magazine1 = new Magazine(2001, "Hung",
                LocalDate.of(2001, 10, 01), "who 1", 10, 2);
        Magazine magazine2 = new Magazine(2002, "Hung",
                LocalDate.of(2002, 10, 01), "who 2", 13, 2);
        Magazine magazine3 = new Magazine(2003, "Hung",
                LocalDate.of(2003, 10, 01), "who 3", 10, 2);
        Magazine magazine4 = new Magazine(2004, "Hung",
                LocalDate.of(2004, 10, 01), "who 4", 20, 2);

        publications.addAll(List.of(magazine1, magazine2, magazine3, magazine4));
    }

    public static void main(String[] args) {
        initData();
        while (true) {
            int choice = View.getInstance().menu();
            switch (choice) {
                case 1:
                    BookService.getInstance().addBook(publications);
                    break;
                case 2:
                    MagazineService.getInstance().addMagazine(publications);
                    break;
                case 3:
                    PublicationService.getInstance().displayMagazineAndBookHavingTheSamePublicationYearAndPublisher(publications);
                    break;
                case 4:
                    BookService.getInstance().addAuthorToBook(publications);
                    break;
                case 5:
                    MagazineService.getInstance().findTopNVolumeMagazine(publications, 10);
                    break;
                case 6:
                    subMenuSearch();
                case 0:
                    return;
                default:
                    break;
            }
        }


    }

    public static void subMenuSearch() {
        while (true) {
            int choice = View.getInstance().subMenu();
            switch (choice) {
                case 1:
                    BookService.getInstance().findBookByISBN(publications);
                    break;
                case 2:
                    BookService.getInstance().findBookByAuthor(publications);
                    break;
                case 3:
                    BookService.getInstance().findBookByPublisher(publications);
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }

    }
}
