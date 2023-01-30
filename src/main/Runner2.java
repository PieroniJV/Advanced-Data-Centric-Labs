
package main;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

// Question 2 Part 1
public class Runner2 {

	public static void main(String[] args) {

		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/salespersondb2p2");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");

		try {
			Connection conn = mysqlDS.getConnection();
			Statement myStmt = conn.createStatement();
			String query = "SELECT sp.sid, sp.fname, sp.surname, ct.name, spc.commission FROM salesperson_table sp INNER JOIN salesperson_city_table spc ON sp.sid = spc.sid INNER JOIN city_table ct ON spc.cid = ct.cid;";

			ResultSet rs = myStmt.executeQuery(query);
			
			//continue here
			while (rs.next()) {
				String sid = rs.getString("sid");
				String fname = rs.getString("fname");
				String lname = rs.getString("surname");
				// String dob = rs.getString("dob");
				// String city = rs.getString("city");
				
				System.out.print("SID = " + sid + ", ");
				System.out.print("First Name = " + fname + ", ");
				System.out.print("Last Name = " + lname + ", ");
				// System.out.print("DOB = " + dob + ", ");
				// System.out.print("City = " + city + ", ");

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// main

}// class

