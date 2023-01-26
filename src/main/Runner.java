package main;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Runner {

	public static void main(String[] args) throws SQLException {	
		
		System.out.println(" hello");

		MysqlDataSource mysqlDS = new MysqlDataSource();
		Connection conn = mysqlDS.getConnection();
		
		mysqlDS.setURL("jdbc:mysql://localhost:3306/salespersondb");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");

		Statement myStmt = conn.createStatement();
		String query = "SELECT * from  salesperson_table;";		
		
		ResultSet rs = myStmt.executeQuery(query);
		
		while (rs.next()) {
			int sid = rs.getInt("sid");
			String fname = rs.getString("fname");
			String lname = rs.getString("surname");
			Date dob = rs.getDate("dob");
			String city = rs.getString("city");
			String comission = rs.getString("comission");
			
			System.out.print("SID = " + sid + ", ");
			System.out.println("First Name = " + fname + ", ");
			System.out.println("Last Name = " + lname + ", ");
			System.out.println("DOB = " + dob + ", ");
			System.out.println("City = " + city + ", ");
			System.out.println("Comission = " + comission + ", ");
		}		
	}
}
