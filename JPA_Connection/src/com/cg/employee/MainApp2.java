package com.cg.employee;


	import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Types;
import java.util.Scanner;

	public class MainApp2 {
	public static void main(String[] args) {
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection(url,"system","orcl11g");		
			con.setAutoCommit(false);
					PreparedStatement s1=con.prepareStatement("UPDATE employee SET salary=salary+100 WHERE eno=1002");	//inherits Prepared Statement
					PreparedStatement s2=con.prepareStatement("UPDATE employee SET salary=salary-100 WHERE eno=1001");	//inherits Prepared Statement
					PreparedStatement s3=con.prepareStatement("DELETE employee WHERE eno=1003");	//inherits Prepared Statement

					s1.executeUpdate();
					s2.executeUpdate();
					Savepoint svpt=con.setSavepoint(); //selective rollback above that point
					//after all transaction savepoint will be rolled back
					
					s3.executeUpdate();

					con.rollback(svpt);
					
					System.out.println("Done");
					con.commit();
					
			s1.close();
			s2.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		try {
			con.rollback();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
		} 

	}
	}


