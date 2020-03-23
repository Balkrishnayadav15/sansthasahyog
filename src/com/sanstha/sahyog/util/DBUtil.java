package com.sanstha.sahyog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBUtil {

	
	public static Connection getMySqlConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://mysql3000.mochahost.com/sansthas_sahyog", "sansthas_admin", "sansthasahyog");
		//Local host
		//Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sansthas_sahyog", "root", "");
		return conn;
	}
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		
		//Get Oracle connection
		//conn = getOracleConnection();
		
		//Get mysql connection
		conn = getMySqlConnection();
				
		return conn;
		
	}
	
	public static void closeConnection() {
		
	}
	
}
