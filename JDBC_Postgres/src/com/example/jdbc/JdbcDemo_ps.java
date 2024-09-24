package com.example.jdbc;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo_ps {

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
		
//		int personId = 101;
//		String lastName = "Smith";
//		String firstName = "John";
//		String city = "Atlanta";
		
		String url ="jdbc:postgresql://localhost:5432/demo";
		String uname = "postgres";
		String pass = "257257";
		
//		String sql = "insert into person values (?,?,?,?)";
		
		Class.forName("org.postgresql.Driver"); //optional - for loading and registering
		Connection con = DriverManager.getConnection(url,uname, pass);
		System.out.println("Connection Established...");
		
//		java.sql.Statement stmt = con.createStatement();		
			
		PreparedStatement pstmt = con.prepareStatement("insert into person values (?,?,?,?)");
		
		PreparedStatement pstmt1 = con.prepareStatement("select * from person where fname = ? and lname = ?");
		pstmt.setInt(1, 130);
		pstmt.setString(2, "Lu");
		pstmt.setString(3, "Kim");
		pstmt.setString(4, "Maryland");
		
		pstmt.execute();
		
		pstmt1.setString(1, "John");
		pstmt1.setString(2, "Smith");
		
		ResultSet rSet = pstmt1.executeQuery();		
		
		while(rSet.next()) {
			System.out.print(rSet.getInt(1)+" - ");
			System.out.print(rSet.getString(2)+" - ");
			System.out.print(rSet.getString(3)+ " - ");
			System.out.println(rSet.getString(4));
		}
		
		//Callable Statement
		
		con.close();
		System.out.println("Connection Closed...");
	}

}
