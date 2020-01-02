package com.sanstha.sahyog.util;

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
}
