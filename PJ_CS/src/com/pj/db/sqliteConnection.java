package com.pj.db;

import java.sql.*;
import javax.swing.*;


public class sqliteConnection {
	Connection conn=null;
		
	public static Connection dbConnection(){
		try{
			//	SQLite
		//	Class.forName("org.sqlite.JDBC");
		//	Connection conn=DriverManager.getConnection("jdbc:sqlite:D:\\wichita\\database\\dbTimeTable.sqlite");
		//	JOptionPane.showMessageDialog(null, "Connection Successful");
		
			//MySQL
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/dbtimetable", "root", "pjcs");
			
			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}

/*
import java.sql.Connection;
import java.sql.DriverManager;


public class sqliteConnection {
	
	public static Connection dbConnection(){
		Connection connect = null;
		
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connect =  DriverManager.getConnection("" +
			"jdbc:sqlserver:");
			if(connect != null){
				System.out.println("Database Connected.");
			} else {
				System.out.println("Database Connect Failed.");
			}
			return connect;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return connect;
		}
		
	}
	
}
*/