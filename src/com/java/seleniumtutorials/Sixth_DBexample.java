package com.java.seleniumtutorials;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sixth_DBexample {
	
	private Connection connection;
	private static Statement statement;
	private static ResultSet rs;
	
	@BeforeClass
	public void setUp() {
		String databaseURL = "jdbc:mysql://localhost:3306/Employee";
		String user = "root";
		String password = "root1";
		connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to database...");
			connection = DriverManager.getConnection(databaseURL,user,password);
			if(connection!=null) {
				System.out.println("Connected to database...");
		}
	} catch(SQLException ex) {
		ex.printStackTrace();
	} catch (ClassNotFoundException ex) {
		ex.printStackTrace();			
		}
	}
	
	@Test
	public void getEmpDataBase() {
		System.out.println("Connection established");
		try {
			String query = "select * from emp";
			statement = connection.createStatement();
			rs = statement.executeQuery(query);
			
			while(rs.next()) {  //get data from result set
				int EmpId = rs.getInt("empid");  //rs.getInt[0]
				Double EmpSal= rs.getDouble("salary");
				String EmpName = rs.getString("name");
	                System.out.println(EmpId+"\t"+EmpName+"\t"+EmpSal);
	            }
	        } catch (SQLException ex) {
	           ex.printStackTrace();
	        }
	    }

	    @AfterClass
	    public void tearDown() {
	      if (connection != null) {
	                try {
	                    System.out.println("Closing Database Connection...");
	                    connection.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
			}
		}
	}
}
