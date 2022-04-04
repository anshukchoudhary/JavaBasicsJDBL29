import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class jdbcExamples {

	public static void main(String[] args) throws SQLException {
		//go ahead and create conenction with RDBMS - mysql,oracle,postgre
		Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/studentdatatest","root","");
		Statement stmnt = connection.createStatement();
		stmnt.execute("create table lect5_studentsDet(id int primary key,name varchar(40))");
		System.out.println("table was created successfully");
		
		

	}

}
