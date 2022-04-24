package com.exampleSqlIntergation.demoSql.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.exampleSqlIntergation.demoSql.models.BModel;

@Repository
public class BRepository {

	private static Logger logger = LoggerFactory.getLogger(BRepository.class);

	private Connection connection;

	BRepository() throws SQLException {
		logger.info("inside BRepository constuctor ");

		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy_db", "root", "");
		createTable();
	}

	private void createTable() throws SQLException {

		String sqlQuery = "Create table IF NOT EXISTS hcVerma_book_autoIncr2(id int primary Key auto_increment, name varchar(30), price int, authorName varchar(30))";

		// Connection connection =
		// DriverManager.getConnection("jdbc:mysql://localhost:3306/dummy_db",
		// "root", "");

		Statement statement = connection.createStatement();

		statement.execute(sqlQuery);

	}

	// http://localhost:8080/book/insert?price=100&name="ravi"&authorName="hcVerma
	//http://localhost:8080/book/insert?price=1006&name=HarrisonMedicine&authorName=Andy
	public void insert(BModel book) throws SQLException {

		logger.info("inside BRepository constuctor insert method ");

		// String sql = "insert into hcVerma_book(id,name,price,authorName)
		// values(21,'PhysicsTheory',3000,'HcVerma2')"; //static query are
		// generally compiled at compile time itself

		String sql = "insert into hcVerma_book_autoIncr2(name,price,authorName) values(?,?,?)";

		PreparedStatement stmnt = connection.prepareStatement(sql);

		// new filed name createddate
		stmnt.setString(1, book.getName());
		stmnt.setInt(2, book.getPrice());
		stmnt.setString(3, book.getAuthorName());

		stmnt.execute(); // --- will return true only when some result set is
							// there if not then return false

		// stmnt.executeUpdate() //---- it returns the no of records updated

		// stmnt.executeQuery() // -- gives the result set mainly with select
		// query

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void update(BModel book) throws SQLException {

		logger.info("inside BRepository constuctor update method ");

		String sql = "update hcVerma_book_autoIncr2 set price=?, name=?,authorName=?" + "where id=?";

		PreparedStatement stmnt = connection.prepareStatement(sql);

		// new filed name createddate
		stmnt.setString(2, book.getName());
		stmnt.setInt(1, book.getPrice());
		stmnt.setString(3, book.getAuthorName());
		stmnt.setInt(4, book.getId());

		int noOfRecords = stmnt.executeUpdate();
		logger.info("no of updated records  " + noOfRecords);

	}

	public void delete(int id) throws SQLException {

		logger.info("inside BRepository  delete method ");

		String sql = "delete from hcVerma_book_autoIncr2 where id=?";

		PreparedStatement stmnt = connection.prepareStatement(sql);

		// new filed name createddate

		stmnt.setInt(1, id);

		int noOfRecords = stmnt.executeUpdate();
		
		//BModel book = getBookById(id);
		logger.info("no of updated records  " + noOfRecords);

	}
	
	
	public BModel getBookById(int id) throws SQLException {

		logger.info("inside BRepository  getBooById method ");

		String sql = "select * from hcVerma_book_autoIncr2 where id=?";

		PreparedStatement stmnt = connection.prepareStatement(sql);

		// new filed name createddate

		stmnt.setInt(1, id);

		ResultSet resultSet =   stmnt.executeQuery();
		
		//BModel book = getBookById(id);
		logger.info("ID  " + resultSet.getInt(id));
		
		logger.info("ID  " + resultSet.getInt("name"));
		
		int bookId = resultSet.getInt("id");
		String name = resultSet.getString("name");
		String authorName = resultSet.getString("authorName");
		
		
		BModel book = BModel.builder().id(bookId).name(name).authorName(authorName).build();
		
		return book;
	}
	
	
	
	
	

}
