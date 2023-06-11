package fa.training.repository;

import fa.training.model.Book;
import fa.training.model.Publication;

import java.util.List;

public interface IBookRepository {
	boolean addBook(List<Publication> publications, Book book);

	String addAuthorToBook(List<Publication> publications,String isbn);

	Book findByISBN(List<Publication> publications, String isbn);

	List<Book> findByAuthor(List<Publication> publications, String author);

	List<Book> findByPublisher(List<Publication> publications, String publisher);
}
