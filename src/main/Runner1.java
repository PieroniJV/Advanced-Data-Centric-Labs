package main;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Runner1 {

	public static void main(String[] args) {

		MysqlDataSource mysqlDS = new MysqlDataSource();
		mysqlDS.setURL("jdbc:mysql://localhost:3306/salespersondb");
		mysqlDS.setUser("root");
		mysqlDS.setPassword("root");
		
		try {
			Connection conn = mysqlDS.getConnection();
			Statement myStmt = conn.createStatement();
			String query = "SELECT * from  salesperson_table;";

			ResultSet rs = myStmt.executeQuery(query);
			
			Scanner in = new Scanner(System.in);
			
			System.out.println("Enter commission: ");
			double userCommission = in.nextDouble();
			
			while (rs.next()) {
				String sid = rs.getString("sid");
				String fname = rs.getString("fname");
				String lname = rs.getString("surname");
				//String dob = rs.getString("dob");
				//String city = rs.getString("city");
				double commission = rs.getDouble("commission");
				
				if (userCommission >= commission) {
					System.out.print("SID = " + sid + ", ");
					System.out.print("First Name = " + fname + ", ");
					System.out.print("Last Name = " + lname + ", ");
					//System.out.print("DOB = " + dob + ", ");
					//System.out.print("City = " + city + ", ");
					System.out.println("Comission = " + commission + ", ");					
				}
			}
			in.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}
}
