package twisercity.library.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import twisercity.library.business.abstracts.BookService;
import twisercity.library.core.utilities.results.DataResult;
import twisercity.library.core.utilities.results.Result;
import twisercity.library.entities.concretes.Book;

@RestController
@RequestMapping("/api/book")
public class BookController {

	private BookService bookService;

	@Autowired
	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Book book) {
		return this.bookService.add(book);
	}
	
	@GetMapping("/getall")
    public DataResult<List<Book>> getAll() {
       return this.bookService.getAll();
    }
	
	@GetMapping("/findbyauthor")
	public DataResult<List<Book>> findByBookAuthor(@RequestParam String bookAuthor){
		return this.bookService.findByBookAuthor(bookAuthor);
	}
	
	@GetMapping("/countbybooktitle")
	public int countByBookTitle(@RequestParam String bookTitle){
		return this.bookService.countByBookTitle(bookTitle);
	}
	
	@GetMapping("/countbooktitledistinct")
	public int countBookTitle(){
		return this.bookService.countBookTitle();
	}

	
	
}
