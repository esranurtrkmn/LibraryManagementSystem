package twisercity.library.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import twisercity.library.business.abstracts.BookService;
import twisercity.library.core.utilities.results.DataResult;
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
	
	@GetMapping("/getall")
    public DataResult<List<Book>> getAll() {
       return this.bookService.getAll();
    }
	
}
