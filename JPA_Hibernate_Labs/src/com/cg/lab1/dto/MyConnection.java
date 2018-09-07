package com.cg.lab1.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.cg.lab1.exception.Lab_1_Exception;

public class MyConnection 
{
	public static Connection getConnection() throws Lab_1_Exception
	{
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(url,"system","orcl11g");
		} catch (ClassNotFoundException e) {
			throw new Lab_1_Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Lab_1_Exception(e.getMessage());
		}
	}
	
	
	
}
