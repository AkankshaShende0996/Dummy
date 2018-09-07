package com.cg.lab1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.cg.lab1.dto.MyConnection;
import com.cg.lab1.exception.Lab_1_Exception;


public class Lab_1_Dao {
public void removeElements (List l1,List l2) throws Lab_1_Exception
{
	Connection con=MyConnection.getConnection();
	PreparedStatement pre=con.prepareStatement(IQueryMapper.);
}
}
