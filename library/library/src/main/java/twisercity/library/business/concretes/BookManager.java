package twisercity.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twisercity.library.business.abstracts.BookService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.SuccessDataResult;
import twisercity.library.dataAccess.abstracts.BookRepository;
import twisercity.library.entities.concretes.Book;

@Service
public class BookManager implements BookService{

	private BookRepository bookRepo;
	
	
	@Autowired
	public BookManager(BookRepository bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}



	@Override
	public DataResult<List<Book>> getAll() {
		return new SuccessDataResult<List<Book>>(this.bookRepo.findAll(),"Kitaplar listelendi");
	}
	
	

}
