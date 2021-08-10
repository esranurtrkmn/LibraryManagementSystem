package twisercity.library.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import twisercity.library.entities.concretes.Book;

public interface BookRepository extends JpaRepository<Book,Integer>{

	List<Book> findByBookAuthor(String bookAuthor);
}
