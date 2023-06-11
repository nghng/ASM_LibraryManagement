package fa.training.repository.impl;

import fa.training.model.Book;
import fa.training.model.Publication;
import fa.training.repository.IBookRepository;
import fa.training.utils.Validator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookRepositoryImpl implements IBookRepository {

    @Override
    public boolean addBook(List<Publication> publications, Book book) {
        return publications.add(book);
    }

    @Override
    public Book findByISBN(List<Publication> publications, String isbn) {

        for (Publication publication : publications) {
            if ((publication instanceof Book) && ((Book) publication).getIsbn().equals(isbn)) {
                return (Book) publication;
            }
        }
        return null;
    }

    @Override
    public List<Book> findByAuthor(List<Publication> publications, String author) {
        List<Book> books = publications.stream()
                .filter(p -> p instanceof Book && ((Book) p).getAuthor().contains(author))
                .map(p -> (Book) p)
                .sorted(Comparator.comparing(Book::getIsbn).reversed()
                        .thenComparing(Comparator.comparing(Book::getPublicationDate).reversed()))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public List<Book> findByPublisher(List<Publication> publications, String publisher) {
        List<Book> books = publications.stream()
                .filter(p -> p instanceof Book && ((Book) p).getPublisher().equals(publisher))
                .map(p -> (Book) p)
                .sorted(Comparator.comparing(Book::getIsbn).reversed()
                        .thenComparing(Comparator.comparing(Book::getPublicationDate).reversed()))
                .collect(Collectors.toList());
        return books;
    }

    @Override
    public String addAuthorToBook(List<Publication> publications, String isbn) {
        String author = Validator.getInstance().validateStringInput("Input Author: ");

        for (int i = 0; i < publications.size(); i++) {
            if (!(publications.get(i) instanceof Book))
                continue;

            Book book = (Book) publications.get(i);

            if (!book.getIsbn().equals(isbn))
                continue;
            while (book.getAuthor().contains(author)) {
                System.out.println("Author existed");
                author = Validator.getInstance().validateStringInput("Input Author: ");
            }

            book.getAuthor().add(author);
            return "Add author successfully";

        }
        return "ISBN does not exist";
    }

}
