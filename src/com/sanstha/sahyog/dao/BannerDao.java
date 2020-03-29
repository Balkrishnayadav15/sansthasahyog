package com.sanstha.sahyog.dao;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.Part;

import com.sanstha.sahyog.model.Gallery;
import com.sanstha.sahyog.util.DBUtil;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
public class BannerDao {

	public boolean saveGalleryImages(Part image) {
			
		 	Connection conn=null;
	        PreparedStatement stmt=null;
	      
	        String imgId = "IMG";
	        try {
	        	long nextId = getNextGalleryImgNumber();
	  	        imgId = imgId+String.format("%03d", nextId);

	        	conn = DBUtil.getConnection();
	        	stmt = conn.prepareStatement("insert into banner(id, image_id, photo) values(?,?,?)");
				InputStream is = image.getInputStream();
				stmt.setLong(1, nextId);
				stmt.setString(2, imgId);
				stmt.setBlob(3, is);
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
	
	public long getNextGalleryImgNumber() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
	    PreparedStatement stmt=null;
	    String query = "select max(id) from banner";
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
	
	public Gallery getImageById(String id) throws Exception{
		Connection conn=null;
	    PreparedStatement stmt=null;
	    Gallery gl = null;
	    String query = "select * from banner where image_id = ?";
	    try {
	        	 conn = DBUtil.getConnection();
	            stmt = conn.prepareStatement(query);
	            stmt.setString(1, id);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	long image_id = rs.getLong("id");
	                String galleryImg_id = rs.getString("image_id");
	                Blob blob = rs.getBlob("photo");
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                 
	                gl = new Gallery(image_id, galleryImg_id, base64Image);
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
	    return gl;
	}
	
	public List<Gallery> getAllGalleryImage() throws Exception{
		Connection conn=null;
	    PreparedStatement stmt=null;
	    List<Gallery> glList = new ArrayList<Gallery>();
	    String query = "select * from banner";
	    try {
	        	 conn = DBUtil.getConnection();
	            stmt = conn.prepareStatement(query);
	            ResultSet rs = stmt.executeQuery();
	            while(rs.next()) {
	            	long image_id = rs.getLong("id");
	                String galleryImg_id = rs.getString("image_id");
	                Blob blob = rs.getBlob("photo");
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	                 
	                 
	                inputStream.close();
	                outputStream.close();
	                 
	                Gallery gl = new Gallery(image_id, galleryImg_id, base64Image);
	                glList.add(gl);
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
	    return glList;
	}

	public List<String> getAllImageIds() {
		Connection conn=null;
		PreparedStatement stmt=null;
		List<String> glList = new ArrayList<String>();
		String query = "select image_id from banner order by id desc";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String galleryImg_id = rs.getString("image_id");
				glList.add(galleryImg_id);
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
		return glList;
	}
	
	public boolean deleteGalleryImage(String imgId) {
		Connection conn=null;
        PreparedStatement stmt=null;
        try {
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("delete from banner where image_id = ?");
            stmt.setString(1, imgId);
            
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
