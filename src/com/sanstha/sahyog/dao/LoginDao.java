package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.util.ConnectionUtil;
import com.sanstha.sahyog.util.DBUtil;

public class LoginDao {

	 public boolean isValidUser(String userId, String password) {
		    Connection conn=null;
	        PreparedStatement stmt=null;
	        //Mysql query
	        //String query = "select * from `user` WHERE `user-id`=? and `password` = ?";
	        
	        //Oracle query
            String query = "select * from cspuser where user_id=? and password = ?";
	        try{
	           // 
	           conn = DBUtil.getConnection();
       		   stmt= conn.prepareStatement(query);

	            stmt.setString(1, userId);
	            stmt.setString(2, password);
	            ResultSet bundleRs = stmt.executeQuery();
	            if(bundleRs.next()) {
	            	return true;
				}

	        }catch(Exception e) {
	        	e.printStackTrace();
	        } finally  {
		           try {
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
	        return false;
	 } 
	 
}
