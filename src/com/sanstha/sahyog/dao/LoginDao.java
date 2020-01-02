package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.util.ConnectionUtil;

public class LoginDao {

	 public boolean isValidUser(String userId, String password) {
		 Connection conn=null;
	        PreparedStatement stmt=null;
	        DAOServices services = DAOUtil.getServices();
	        try {
	            conn = services.borrowConnection();
	            String query = "select * from cspuser where user_id=? and password = ?";
	            stmt = conn.prepareStatement(query);
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
	                ConnectionUtil.closeQuietly(stmt);
	            } finally {
	                services.returnConnection(conn);
	            }
	        }
	        return false;
	 } 
	 public void getScheduleControlDetails(String serviceName)
		{
			Connection conn=null;
	        PreparedStatement stmt=null;
	        DAOServices services = DAOUtil.getServices();
	        try {
	            conn = services.borrowConnection();
	            String query = "select to_char(last_published_date,'dd-MM-YYYY HH24:MI:SS'),to_char((SYSTIMESTAMP AT TIME ZONE 'GMT'),'dd-MM-YYYY HH24:MI:SS'), RUNNING,to_char(DATE_STATUS_UPDATED,'dd-MM-YYYY HH24:MI:SS') from CSC_ISIS_SCHEDULE_CONTROL where SERVICE_TYPE=?";
	            stmt = conn.prepareStatement(query);
	            stmt.setString(1, serviceName);
	            ResultSet bundleRs = stmt.executeQuery();
	            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	            dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
	            while(bundleRs.next()) {
	            	System.out.print("bundleRs.getString(1)"+bundleRs.getString(1));
				}

	        }catch(Exception e) {
	        	e.printStackTrace();
	        } finally  {
	            try {
	                ConnectionUtil.closeQuietly(stmt);
	            } finally {
	                services.returnConnection(conn);
	            }
	        }
			
			
			
		}
}
