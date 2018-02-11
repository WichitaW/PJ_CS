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
			
			//SQLServer
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn=DriverManager.getConnection("jdbc:sqlserver://SQLSERVER;databaseName=dbTimeTable");

			return conn;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
