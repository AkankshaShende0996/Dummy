package com.cg.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MainApp {
public static void main(String[] args) {
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection(url,"system","orcl11g");
		Scanner scan=new Scanner(System.in);
				
				System.out.println("Enter employee gender");
				String gender=scan.nextLine();
				/*System.out.println("Enter name");
				String name=scan.nextLine();
				System.out.println("Enter gender");
				String gender=scan.nextLine();
				System.out.println("Enter age");
				int age=Integer.parseInt(scan.nextLine());
				System.out.println("Enter salary");
				double sal=Double.parseDouble(scan.nextLine());
				*/
				PreparedStatement stat=con.prepareStatement("DELETE employee WHERE gender=?");	
				stat.setString(1,gender );
				/*stat.setString(2, name);
				stat.setString(3, gender);
				stat.setInt(4, age);
				stat.setDouble(5, sal);*/
				int result=stat.executeUpdate(); //how many rows manipulated //only for insert,delete,update
				System.out.println("Row deleted "+result);
				
		stat.close();
		con.close();
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	catch (SQLException e) {
		System.out.println(e.getMessage());
	} 

}
}

