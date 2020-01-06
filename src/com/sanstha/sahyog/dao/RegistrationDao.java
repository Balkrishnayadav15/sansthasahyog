package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.util.ConnectionUtil;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.DBUtil;

public class RegistrationDao {

	public User saveUserDetails(User user) {
		
		 	Connection conn=null;
	        PreparedStatement stmt=null;
	        DAOServices services = DAOUtil.getServices();
	       // try {
	        try {
	            //conn = services.borrowConnection();
	        	 conn = DBUtil.mySqlConnection();
	            stmt = conn.prepareStatement(generateInsert(user));
	            stmt.setLong(1, user.getRegisterId());
	            stmt.setString(2, user.getName());
	            stmt.setString(3, user.getUserType());
	            stmt.setString(4, user.getGender());
	            stmt.setString(5, user.getAddress());
	            stmt.setString(6, user.getMobile());
	            stmt.setString(7, user.getDateOfBirth());
	            stmt.setString(8, user.getPincode());
	            stmt.setString(9, user.getEmail());
	            stmt.setString(10,user.getRegisterFees());
	            stmt.setString(11,user.getSchoolName() );
	            stmt.setString(12,user.getSchoolAddress() );
	            stmt.setString(13,user.geteYear() );
	            stmt.setString(14,user.getCreatedBy());
	            int row = stmt.executeUpdate();
	            if(row == 1) {
	            	return user;
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
		return null;
	}
	
	
	
	
	
	
	
	private String generateInsert(User user) {
		return "INSERT INTO Registration (REGISTRATION_ID, Name, user_type,gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees,"
				+ "Institue_name,Institue_address,Established_year,CREATED_BY) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
	}
	
	public long getNextRegistrationNumber() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        DAOServices services = DAOUtil.getServices();
        String query = "select max(REGISTRATION_ID) from Registration";
        //try {
        try {
	        	 conn = DBUtil.mySqlConnection();
	           
	            stmt = conn.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	nextRegNum = rs.getLong(1);
				}

        }catch(Exception e) {
        	throw e;
        } /*finally  {
            try {
                ConnectionUtil.closeQuietly(stmt);
            } finally {
                services.returnConnection(conn);
            }
        }*/
        return nextRegNum+1;
	}
	
	public List<User> getAllUser() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        DAOServices services = DAOUtil.getServices();
        List<User> userList = new ArrayList<User>();
        User user = null;
        String query = "select REGISTRATION_ID,Institue_name,Institue_address,Established_year, user_type, Name, gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees," + 
        		"CREATED_BY from Registration order by name asc ";
     
        try  {
            //conn = services.borrowConnection();
        	 conn = DBUtil.mySqlConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new User(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),null,null,null);
            	userList.add(user);
			}
        }catch(Exception e) {
        	throw e;
        } /*finally  {
            try {
                ConnectionUtil.closeQuietly(stmt);
            } finally {
                services.returnConnection(conn);
            }
        }*/
        return userList;
	}
	
}
