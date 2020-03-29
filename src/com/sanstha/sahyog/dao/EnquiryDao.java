package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sanstha.sahyog.model.Enquiry;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.DBUtil;

public class EnquiryDao {

	public long getNextEnNumber() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
        PreparedStatement stmt=null;
        String query = "select max(id) from EnquiryUser";
        try {
	        	 conn = DBUtil.getConnection();
	            stmt = conn.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	nextRegNum = rs.getLong(1);
				}

        }catch(Exception e) {
        	throw e;
        } finally  {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
     }
        return nextRegNum+001;
	}
	
	public Enquiry saveEnquiryDetails(Enquiry user) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
        
        try {
        	String insertQuery = "insert into EnquiryUser(id,enquiryId, username,schoolname,address,emailid,mobile,status) values(?,?,?,?,?,?,?,?)";
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(insertQuery);
            stmt.setLong(1, user.getId());
            stmt.setString(2,user.getEnquiryId());
            stmt.setString(3, user.getName());
            stmt.setString(4, user.getSchoolName());
            stmt.setString(5, user.getAddress());
            stmt.setString(6, user.getEmailid());
            stmt.setString(7, user.getMobileNo());
            stmt.setString(8, "Pending");

          
            int row = stmt.executeUpdate();
            if(row == 1) {
            	return user;
            }
        }catch(Exception e) {
        	e.printStackTrace();
        }finally  {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
	return null;
}
	public List<Enquiry> getAllEnquires() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        List<Enquiry> userList = new ArrayList<Enquiry>();
        Enquiry user = null;
        String query = "select id, username,schoolname,address,emailid,mobile,enquiryId from EnquiryUser where status = 'Pending' order by id asc ";
     
        try  {
        	 conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new Enquiry(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
            	userList.add(user);
			}
        }catch(Exception e) {
        	throw e;
        } finally  {
	           try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
     }
        return userList;
	}
	

	public String updateStatus(String enquiryId) {
		
	 	Connection conn=null;
	    PreparedStatement stmt=null;
	    try {
	    	conn = DBUtil.getConnection();
	    	String updateStatusQuery = "UPDATE EnquiryUser SET status = ? WHERE enquiryId = ?";
	        stmt = conn.prepareStatement(updateStatusQuery);
	        //if(operation.equals("approve")){
	            stmt.setString(1, "Rejected");
	       // }else{
	       //     stmt.setString(1, "Rejected");
	       // }
	        stmt.setString(2,enquiryId);
	        
	        int row = stmt.executeUpdate();
	        if(row == 1) {
	        	return enquiryId;
	        }
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }finally  {
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
