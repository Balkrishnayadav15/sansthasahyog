package com.sanstha.sahyog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.dao.DAOUtil;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {

	public static Connection getOracleConnection() throws SQLException {
		DAOServices services = null;
		try {
			
			services = DAOUtil.getServices();
			
		} catch (Exception e) {
			throw e;
		}
		return services.borrowConnection();
	}
	
	public static Connection getMySqlConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
                .getConnection("jdbc:mysql://mysql3000.mochahost.com/sansthas_sahyog", "sansthas_admin", "sansthasahyog");
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
	
	public static DataSource getDataSource() throws SQLException {
		OracleDataSource oracleDS = null;
		try {
			oracleDS = new OracleDataSource();
			oracleDS.setURL("jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=TCP)(HOST=dbs-dev-vm-2009.cisco.com)(PORT=1524))(CONNECT_DATA=(SERVICE_NAME=SHOPDEV.CISCO.COM)(Server=Dedicated)))");
			oracleDS.setUser("SECURITY_ALERT");
			oracleDS.setPassword("EFNB7L5J");
		} catch (SQLException e) {
			throw e;
		}
		return oracleDS;
	}
}
