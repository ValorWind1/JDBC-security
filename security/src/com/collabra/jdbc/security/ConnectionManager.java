package com.collabra.jdbc.security;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectionManager {

		
		static final String URL = "jdbc:mysql://localhost:3306/testdb?serverTimezone=EST5EDT";
		static final String USERNAME ="root";
		static final String PASSWORD = "Dl113311";
		
		
		public static Connection getConnection() {
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				System.out.println("Connection was made");
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return conn;
		}
		
public static void main(String[] args) throws SQLException {
	Connection conn = ConnectionManager.getConnection();
	//we did some stuff here
	
	Statement state = conn.createStatement();
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Type name of the city you're looking for: ");
	
	String name = sc.nextLine();
	// this line will show sensetive information 
//	String query = String.format("SELECT * FROM city WHERE name = '%s'", name );
	// this line will hide information after input 
	String query = String.format("SELECT * FROM city WHERE name = 'x' OR 'a'='a'");
	
	state.execute(query);
	
	System.out.println(query);
	
	
	try {
		conn.close();
		System.out.println("connection was closed");
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
}
	

}

