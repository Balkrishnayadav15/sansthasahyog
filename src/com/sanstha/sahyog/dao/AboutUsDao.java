package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.sanstha.sahyog.util.DBUtil;

public class AboutUsDao {

	public Map<String,String> getAboutUsType(String type) {
		Connection conn=null;
		PreparedStatement stmt=null;
		Map<String,String> news = new HashMap<String,String>();
		String query = "select * from aboutUs  where about_type = ?";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				news.put("header", rs.getString("header"));
				news.put("body", rs.getString("about_body"));
				news.put("type", rs.getString("about_type"));
			}

		}catch(Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally  {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return news;
	}
	
public boolean saveAboutUs(String header,String body, String type) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
      
        try {

        	conn = DBUtil.getConnection();
        	stmt = conn.prepareStatement("update aboutUs set header = ?,about_body = ? where about_type = ?");
			stmt.setString(1, header);
			stmt.setString(2, body);
			stmt.setString(3, type);
			
			int row = stmt.executeUpdate();
            if(row == 1) {
            	return true;
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
	return false;
	}
}
