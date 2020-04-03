package com.sanstha.sahyog.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.Part;

import com.sanstha.sahyog.model.Gallery;
import com.sanstha.sahyog.model.Meeting;
import com.sanstha.sahyog.util.DBUtil;
import com.sanstha.sahyog.util.DateUtility;

public class MeetingDeskDao {

	public long getNextMeetNumber() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
        PreparedStatement stmt=null;
        String query = "select max(id) from meetingDesk";
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
	
	public boolean saveMeetings(Meeting meeting) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
        
        try {
        	String insertQuery = "insert into meetingDesk(meetingId, venue,topic,meetingDate,meetingTime) values(?,?,?,?,?) ";
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(insertQuery);
            stmt.setString(1, meeting.getMeetingId());
            stmt.setString(2,meeting.getVenue());
            stmt.setString(3, meeting.getTopic());
            stmt.setString(4, meeting.getMeetingDate());
            stmt.setString(5, meeting.getMeetingTime());
          
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
	public List<Meeting> getAllMeetings() throws Exception {
		Connection conn=null;
        PreparedStatement stmt=null;
        List<Meeting> meetingList = new ArrayList<Meeting>();
        Meeting meeting = null;
        String query = "select md.id,md.meetingId,md.meetingTime,md.meetingDate,md.venue, md.topic, group_concat(mds.attendName) as attendName,group_concat(mds.confiName) as confiName,group_concat(mds.nonConfiName) as nonConfiName "+
        		"from meetingDesk md "+
        		"left outer join meetingDocs mds "+
        		"on md.meetingId = mds.meetingId "+
        		"group by md.meetingId order by id asc";
       
        try  {
        	conn = DBUtil.getConnection();
        	stmt = conn.prepareStatement(query);
        	ResultSet rs = stmt.executeQuery();
        	while(rs.next()) { 
        		
        		 	List<String> attendanceSNameL = new ArrayList<String>();
        	        List<String> confPaperNameL = new ArrayList<String>();
        	        List<String> nonConfPaperNameL = new ArrayList<String>();
        		
        			String attendance = rs.getString("attendName");
        			if(null != attendance){
        				String str1[] = attendance.split(",");
        				attendanceSNameL = Arrays.asList(str1);
        			}
        			
        			String confidential = rs.getString("confiName");
        			if(null != confidential){
        				String str2[] = confidential.split(",");
        				confPaperNameL = Arrays.asList(str2);
        			}
        			
        			String nonConfidential = rs.getString("nonConfiName");
        			if(null != nonConfidential){
        				String str3[] = nonConfidential.split(",");
        				nonConfPaperNameL = Arrays.asList(str3);
        			}
        			String status = null;
        		if(null != rs.getString("meetingDate") && !"".equals(rs.getString("meetingDate"))){
        			status = DateUtility.ifDateIsOld(rs.getString("meetingDate"));	
        		}
        		meeting = new Meeting(rs.getLong(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),attendanceSNameL,confPaperNameL,nonConfPaperNameL,null,status);
        		meetingList.add(meeting);
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
        return meetingList;
	}
	
	public boolean saveMeetingDocs(Part docs,String docName,String docType, String meetingId) {

		Connection conn=null;
		PreparedStatement stmt=null;
		boolean isSave = false;
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement("insert into meetingDocs(meetingId, attendName,confiName,nonConfiName, document,docType) values(?,?,?,?,?,?)");
			InputStream is = docs.getInputStream();
			stmt.setString(1, meetingId);
			if("attendance".equals(docType)){
				stmt.setString(2, docName);
				stmt.setString(3, null);
				stmt.setString(4, null);
				stmt.setBlob(5, is);
				stmt.setString(6, docType);
			}else if("confidential".equals(docType)){
				stmt.setString(2, null);
				stmt.setString(3, docName);
				stmt.setString(4, null);
				stmt.setBlob(5, is);
				stmt.setString(6, docType);
			}else if("nonConfidential".equals(docType)){
				stmt.setString(2, null);
				stmt.setString(3, null);
				stmt.setString(4, docName);
				stmt.setBlob(5, is);
				stmt.setString(6, docType);
			}
			int row = stmt.executeUpdate();
			if(row == 1) {
				isSave = true;
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
		return isSave;
	}
	public Blob downloadFile(String fileName, String meetingId, String fileType) throws Exception{
		Connection conn=null;
	    PreparedStatement stmt=null;
	    String query = "select document from meetingDocs where meetingId=? and docType = ?";
	    OutputStream outputStream = new ByteArrayOutputStream();
	    Blob blob = null;
	    try {
	        	conn = DBUtil.getConnection();
	            stmt = conn.prepareStatement(query);
	            stmt.setString(1, meetingId);
	            stmt.setString(2, fileType);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	                blob = rs.getBlob("document");
	               /* InputStream inputStream = blob.getBinaryStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }*/
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
	    return blob;
	}
}
