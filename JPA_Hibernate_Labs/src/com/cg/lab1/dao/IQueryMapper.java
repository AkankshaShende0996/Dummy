package com.cg.lab1.dao;

public class IQueryMapper {
public static String INSERT_QUERY="INSERT INTO EMPLOYEE VALUES(empSeq1.nextval,?,?,?,?)";
public static String GET_EMP_CODE="SELECT MAX(ENO) FROM EMPLOYE";
}

