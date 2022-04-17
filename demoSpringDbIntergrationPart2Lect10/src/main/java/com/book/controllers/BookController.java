package com.book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.models.Book;
import com.book.services.BookService;

@RestController
public class BookController {
	// find the significant 5 upgrade that was done from spring to spring boot

	@Autowired
	BookService bookService;

	@GetMapping("/book/get")
	public Book getBookById(@RequestParam("id") int id) {
		Book book = new Book(11, "Word power", "Normal Lewis", 400, "publisher12", 1234);

		return book;
	}

	@PostMapping("book/insert")
	public void insertBook(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("authorName") String authorName) {

		Book book = Book.builder().id(id).name(name).author(authorName).build(); // using
																					// lombok

		bookService.save(book);//call will go to service 

		// normal way to fill java object
		Book book2 = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(authorName);

	}

}
