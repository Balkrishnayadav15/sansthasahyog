package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.util.ConnectionUtil;
import com.sanstha.sahyog.util.DBUtil;

public class LoginDao {

	 public boolean isValidUser(String userId, String password) {
		    Connection conn=null;
	        PreparedStatement stmt=null;
	        String query = "select * from `user` WHERE `user-id`=? and `password` = ?";
	       // DAOServices services = DAOUtil.getServices();
	        try{
	           // conn = services.borrowConnection();
	           conn = DBUtil.mySqlConnection();
       		   stmt= conn.prepareStatement(query);

	            stmt.setString(1, userId);
	            stmt.setString(2, password);
	            ResultSet bundleRs = stmt.executeQuery();
	            if(bundleRs.next()) {
	            	return true;
				}

	        }catch(Exception e) {
	        	e.printStackTrace();
	        } /*finally  {
	            try {
	                ConnectionUtil.closeQuietly(stmt);
	            } finally {
	                services.returnConnection(conn);
	            }
	        }*/
	        return false;
	 } 
	 
}
