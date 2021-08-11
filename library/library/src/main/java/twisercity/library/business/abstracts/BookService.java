package twisercity.library.business.abstracts;

import java.util.List;

import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Book;

public interface BookService {

	public DataResult<List<Book>> getAll();
	
	public DataResult<List<Book>> findByBookAuthor(String bookAuthor);
	
	int countByBookTitle(String bookTitle);
	
	int countBookTitle();
	
	public Result add(Book book);
	
	
}
