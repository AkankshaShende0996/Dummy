package com.cg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MainApp {
public static void main(String[] args) {
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	try {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter gender");
		String g=scan.nextLine();
		
		//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());   //does the same work as the below line
		//remove class not found exception for above command
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(url,"system","orcl11g");
		
		//Statement stat=con.createStatement();
		//ResultSet rs=stat.executeQuery("SELECT * FROM Employee");
		
		PreparedStatement stat=con.prepareStatement("SELECT * FROM employee WHERE gender=?");
		stat.setString(1, g); //set the parameter //1:positional parameter since only one ?
		ResultSet rs=stat.executeQuery();
		
		
		while(rs.next()) //record in ResultSet
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "
					+rs.getString("gender")+" "+rs.getInt(4)+" "+rs.getDouble(5)); 
			//1:employee id
			//2:Employee name
			//gender : column name can 
		}
		stat.close();
		rs.close();
		con.close();
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	} 

}
}
