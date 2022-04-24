package com.exampleSqlIntergation.demoSql;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BService {

	@Autowired
	BRepository bRepository;

	public void save(BModel book) throws SQLException {

		// we want to insert book
		// write logic suppose u want to manipulate data after that send the
		// object to dao to be inserted to db
		bRepository.insert(book);// call will go to repo

	}

	/////////////////////////////////////////////////////////////////////////////////

	public void updateBook(BModel book) throws SQLException {

		// we want to insert book
		// write logic suppose u want to manipulate data after that send the
		// object to dao to be inserted to db
		bRepository.update(book);// call will go to repo

	}

	public void deleteBook(int bookId) throws SQLException {
		// Book book = get(id);
		// we want to insert book
		// write logic suppose u want to manipulate data after that send the
		// object to dao to be inserted to db
		bRepository.delete(bookId);// call will go to repo

	}
	
	public BModel getBook(int bookId) throws SQLException {
		return bRepository.getBookById(bookId);

	}
	
	
	
	
}
