package com.exampleSqlIntergation.demoSql.controller;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleSqlIntergation.demoSql.models.BModel;
import com.exampleSqlIntergation.demoSql.service.BService;

@RestController
public class BController {

	@Autowired
	BService bService;

	private static Logger logger = LoggerFactory.getLogger(BController.class);

	// http://localhost:8080/book/insert?price=106&name=ravi&authorName=hcVerma
	@PostMapping("book/insert")
	public void insertBook(@RequestParam("price") int price, @RequestParam("name") String name,
			@RequestParam("authorName") String authorName) throws SQLException {

		BModel book = BModel.builder().price(price).name(name).authorName(authorName).build();

		bService.insert(book);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
	@PutMapping("book/update")
	public void updateBook(@RequestBody BModel bModel) throws SQLException {
		bService.updateBook(bModel);

	}

	@DeleteMapping("book/delete")
	public void deleteBook(@RequestParam("id") int id) throws SQLException {
		bService.deleteBook(id);

	}
	
	@GetMapping("book/getById")
	public BModel getBook(@RequestParam("id") int id) throws SQLException {
		return bService.getBook(id);

	}*/
	
	
	
	
	///////////////////////
	//JPA - java persistence api
	//has the contracts such as get,save,flush etc whose implementation is provided by hibernate
	

}
