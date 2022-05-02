
package com.example.minor.project.demominorproject1may;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	@PostMapping("/book")
	public void createBook(@RequestBody Book book) {

		bookService.createBook(book);
	}

	@GetMapping("/book/all")
	public List<Book> getBook() {
		return bookService.getAllBook();
	}

	@PutMapping("/book/update")
	public void updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
	}



}
