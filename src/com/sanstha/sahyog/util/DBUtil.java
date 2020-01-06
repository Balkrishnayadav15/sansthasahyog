package com.sanstha.sahyog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class DBUtil {

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
	
	public static Connection mySqlConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
                .getConnection("jdbc:mysql://mysql3000.mochahost.com/sansthas_sahyog", "sansthas_admin", "sansthasahyog");
		return conn;
	}
}
