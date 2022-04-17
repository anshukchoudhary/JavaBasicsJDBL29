package com.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.models.Book;
import com.book.repos.BookRepo;


@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	
	public void save(Book book){
		
		//we want to insert book
		// write logic suppose u want to manipulate data after that send the object to dao to be inserted to db
		bookRepo.insertBook(book);//call will go to repo 
		
		
	}
	

}
