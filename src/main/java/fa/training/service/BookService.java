package fa.training.service;

import fa.training.model.Book;
import fa.training.model.Publication;
import fa.training.repository.IBookRepository;
import fa.training.repository.impl.BookRepositoryImpl;
import fa.training.utils.Validator;
import fa.training.view.View;

import java.util.List;

public class BookService {
    private static BookService instance;
    public static IBookRepository bookRepository = new BookRepositoryImpl();

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }

    public Boolean isExistISBN(List<Publication> publications, String isbn) {
        return publications.stream()
                .anyMatch(p -> (p instanceof Book) && ((Book) p).getIsbn().equals(isbn));

    }

    public String checkInputISBN(List<Publication> publications) {
        String isbn = Validator.getInstance().validateISBN("ISBN: ");
        Boolean isExistISBN;
        do {
            isExistISBN = isExistISBN(publications, isbn);
            if (isExistISBN) {
                System.out.println("ISBN already existed");
                System.out.println("Please enter again: ");
                isbn = Validator.getInstance().validateISBN("ISBN");
            }
        } while (isExistISBN);

        return isbn;
    }

    public void addBook(List<Publication> publications) {
        Book book = View.getInstance().inputBook(publications);
        System.out.println(bookRepository.addBook(publications, book) ? "Add Success" : "Add Fail");
    }

    public void addAuthorToBook(List<Publication> publications) {
        String isbn = Validator.getInstance().validateISBN("ISBN");
        System.out.println(bookRepository.addAuthorToBook(publications, isbn));
    }

    public void findBookByISBN(List<Publication> publications) {
        String isbn = Validator.getInstance().validateISBN("Input ISBN");
        Book book = bookRepository.findByISBN(publications, isbn);
        System.out.println(book == null ? "There is no ISBN matched the record" : book);
    }

    public void findBookByAuthor(List<Publication> publications){
        String author = Validator.getInstance().validateStringInput("Input author name: ");
        List<Book> books = bookRepository.findByAuthor(publications, author);
        if (books.isEmpty()) {
            System.out.println("There is no book that matches the input author.");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void findBookByPublisher(List<Publication> publications){
        String publisher = Validator.getInstance().validateStringInput("Input publisher ");
        List<Book> books = bookRepository.findByPublisher(publications, publisher);
        if(books.isEmpty()){
            System.out.println("There is no book that matches the input publisher.");
        }else {
            books.forEach(System.out::println);
        }
    }
}
