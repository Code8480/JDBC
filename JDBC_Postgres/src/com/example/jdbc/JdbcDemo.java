package com.example.jdbc;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {

	public static void main(String[] args) throws Exception {
		
		// TODO Auto-generated method stub
		/*
		 * import Package 
		 * load and register 
		 * create connection 
		 * create statement 
		 * execute statement 
		 * process results 
		 */		
		
		String url ="jdbc:postgresql://localhost:5432/demo";
		String uname = "postgres";
		String pass = "257257";
//		String sql = "select fname from person where personId = 101";
//		String sql = "select * from person";
//		String sql = "insert into person values (115,'Smith','Peter','Metro')";				
		
		Class.forName("org.postgresql.Driver"); //optional - for loading and registering
		Connection con = DriverManager.getConnection(url,uname, pass);
		System.out.println("Connection Established...");
		
		java.sql.Statement stmt = con.createStatement();		
//		int rows = stmt.executeUpdate(sql);
//		System.out.println("Rows updated: "+rows);
		ResultSet rSet = stmt.executeQuery("select * from person");		
	
		
//		boolean status = stmt.execute(sql);
//		System.out.println(" "+status);		

		
		while(rSet.next()) {
			System.out.print(rSet.getInt(1)+" - ");
			System.out.print(rSet.getString(2)+" - ");
			System.out.print(rSet.getString(3)+ " - ");
			System.out.println(rSet.getString(4));
		}
		
		con.close();
		System.out.println("Connection Closed...");
	}

}
