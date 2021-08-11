package twisercity.library.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import twisercity.library.entities.concretes.Book;
import twisercity.library.entities.concretes.Reservation;

public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByBookAuthor(String bookAuthor);
	
	@Query("SELECT COUNT(DISTINCT bookTitle) FROM Book ")
	List<Book> findByBookTitleCount();
	
	@Query("SELECT COUNT(DISTINCT bookAuthor) FROM Book")
	List<Book> findByBookAuthorCount();
}
