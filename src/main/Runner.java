package main;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Runner {

	public static void main(String[] args) throws SQLException {		

		MysqlDataSource mysqlDS = new MysqlDataSource();
		Connection conn = mysqlDS.getConnection();
		
		mysqlDS.setURL("jdbc:mysql://localhost:3306/salespersondb");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");

		Statement myStmt = conn.createStatement();
		String query = "SELECT * from  salesperson_table;";
		
		myStmt.executeQuery(query);

		
	}

}
