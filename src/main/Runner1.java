package main;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

// Question 1 Part 1
public class Runner1 {

	public static void main(String[] args) {

		// Declaring MySql credentials
		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/salespersondb");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");

		try {
			// Trying to establish connection with MySql database
			Connection conn = mysqlDS.getConnection();
			Statement myStmt = conn.createStatement();

			// Querying MySql
			String query = "SELECT * from  salesperson_table;";
			ResultSet rs = myStmt.executeQuery(query);

			// For Question 1 Part 2, User enters a commission value
			Scanner in = new Scanner(System.in);
			System.out.println("Enter commission: ");
			double userCommission = in.nextDouble();

			// Loop through Database results, For Q1P2, it only prints out values where
			// commission is same or lower than the input
			while (rs.next()) {
				String sid = rs.getString("sid");
				String fname = rs.getString("fname");
				String lname = rs.getString("surname");
				// String dob = rs.getString("dob");
				// String city = rs.getString("city");
				double commission = rs.getDouble("commission");

				// Q1P2 only
				if (userCommission >= commission) {
					System.out.print("SID = " + sid + ", ");
					System.out.print("First Name = " + fname + ", ");
					System.out.print("Last Name = " + lname + ", ");
					// System.out.print("DOB = " + dob + ", ");
					// System.out.print("City = " + city + ", ");
					System.out.println("Comission = " + commission + ", ");
				}
			}
			// Close Scanner
			in.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// main
}// class
