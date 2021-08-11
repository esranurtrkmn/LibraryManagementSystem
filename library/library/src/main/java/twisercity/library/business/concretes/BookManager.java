package twisercity.library.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twisercity.library.business.abstracts.BookService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.core.utilities.results.SuccessDataResult;
import twisercity.library.core.utilities.results.SuccessResult;
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



	@Override
	public Result add(Book book) {
		
		this.bookRepo.save(book);
		return new SuccessResult("Kitap bilgisi eklendi.");
	}



	@Override
	public DataResult<List<Book>> findByBookAuthor(String bookAuthor) {
		
		return new SuccessDataResult<List<Book>>(this.bookRepo.findByBookAuthor(bookAuthor),"Kitaplar yazarlara göre sıralandı.");
	}



	@Override
	public DataResult<List<Book>> findByBookTitleCount() {
		
		return new SuccessDataResult<List<Book>>(this.bookRepo.findByBookTitleCount(),"Kitaplar başlık sayısı hesaplandı.");

	}

	@Override
	public DataResult<List<Book>> findByBookAuthorCount() {
		
		
		return new SuccessDataResult<List<Book>>(this.bookRepo.findByBookAuthorCount(),"Yazar sayısı hesaplandı.");
		
	}



	
	

}
