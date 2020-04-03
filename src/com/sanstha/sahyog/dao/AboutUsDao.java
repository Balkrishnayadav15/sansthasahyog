package com.sanstha.sahyog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sanstha.sahyog.util.DBUtil;

public class AboutUsDao {

	public List<Map<String,String>> getAboutUsType(String type) {
		Connection conn=null;
		PreparedStatement stmt=null;
		List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
		Map<String,String> infoMap = null;
		String query = "select * from aboutUs  where about_type = ? order by id asc";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			stmt.setString(1, type);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				infoMap = new LinkedHashMap<String,String>();
				infoMap.put("header", rs.getString("header"));
				infoMap.put("body", rs.getString("about_body"));
				infoMap.put("type", rs.getString("about_type"));
				infoMap.put("id", rs.getString("id"));
				mapList.add(infoMap);
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
		return mapList;
	}
	
public boolean saveAboutUs(String header,String body, String type) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
      
        try {

        	conn = DBUtil.getConnection();
        	stmt = conn.prepareStatement("insert into aboutUs(header,about_body,about_type) values(?,?,?)");
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

	public boolean updateAboutUs(String header, String body, String type, String id) {
		Connection conn=null;
		PreparedStatement stmt=null;
	
		try {
	
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("update aboutUs set header = ?,about_body=?,about_type=? where id = ?");
			stmt.setString(1, header);
			stmt.setString(2, body);
			stmt.setString(3, type);
			stmt.setLong(4, Long.parseLong(id));
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

	public boolean deleteAboutUs(String id) {
		Connection conn=null;
		PreparedStatement stmt=null;
	
		try {
	
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("DELETE FROM aboutUs  where id = ?");
			stmt.setLong(1, Long.parseLong(id));
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
