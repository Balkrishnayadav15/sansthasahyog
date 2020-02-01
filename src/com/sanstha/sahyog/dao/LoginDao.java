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

	 public String isValidUser(String userId, String password) {
		    Connection conn=null;
	        PreparedStatement stmt=null;
	        //Mysql query
	        String query = "select user_type from `user` WHERE `user_id`=? and `password` = ?";
	        
	        //Oracle query
            //String query = "select user_type from cspuser where user_id=? and password = ?";
	        try{
	           // 
	           conn = DBUtil.getConnection();
       		   stmt= conn.prepareStatement(query);

	            stmt.setString(1, userId);
	            stmt.setString(2, password);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	return rs.getString("user_type");
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
	        return null;
	 } 
	 
}
