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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DashBoardDao {

	
	public Map<String,Object> getAllHomePageData(){
		Connection conn=null;
		PreparedStatement newsStmt = null, galleryStmt= null, bannerStmt=null;
		Map<String,Object> homeMap = new HashMap<String,Object>();
		try {

			conn = DBUtil.getConnection();

			//Get Latest News Data
			Map<String,String> news = new HashMap<String,String>();
			newsStmt = conn.prepareStatement("select * from information where id = 1");
			ResultSet rs = newsStmt.executeQuery();
			while(rs.next()) {
				news.put("header", rs.getString("header"));
				news.put("body", rs.getString("body"));
			}
			homeMap.put("LATEST_NEWS", news);

			//Get Gallery data
			List<Gallery> glList = new ArrayList<Gallery>();
			galleryStmt = conn.prepareStatement("select * from gallery");
			ResultSet rsGallery = galleryStmt.executeQuery();
			while(rsGallery.next()) {
				long image_id = rsGallery.getLong("id");
				String galleryImg_id = rsGallery.getString("image_id");
				Blob blob = rsGallery.getBlob("photo");
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
			homeMap.put("GALLERY_IMG", glList);

			//Get Banner Images data
			List<Gallery> bannerList = new ArrayList<Gallery>();
			String query = "select * from banner";

			bannerStmt = conn.prepareStatement(query);
			ResultSet rsBanner = bannerStmt.executeQuery();
			while(rsBanner.next()) {
				long image_id = rsBanner.getLong("id");
				String galleryImg_id = rsBanner.getString("image_id");
				Blob blob = rsBanner.getBlob("photo");
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
				bannerList.add(gl);

			}
			homeMap.put("BANNER_IMG", bannerList);


		}catch(Exception e) {
			e.printStackTrace();
		}finally  {
			try {
				newsStmt.close();
				galleryStmt.close();
				bannerStmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return homeMap;

	}
	public String saveGalleryImages(Part image,String name) {
			
		 	Connection conn=null;
	        PreparedStatement stmt=null,checkStmt = null;
	        boolean isFilePresent = false;
	        String savedStatus = "";
	        try {
	        	conn = DBUtil.getConnection();
	        	
	        	//check file is already present or not
	        	
	        	checkStmt = conn.prepareStatement("select count(1) from gallery where image_id = ?");
	        	checkStmt.setString(1, name);
	        	ResultSet rs = checkStmt.executeQuery();
	            while(rs.next()) {
	            	 if(rs.getLong(1) > 0){
	            		 isFilePresent = false;
	            		 savedStatus = "duplicate";
	            	 }else{
	            		 isFilePresent = true;
	            	 }
				}

	            //Insert image into database
	        	if(isFilePresent){
		        	stmt = conn.prepareStatement("insert into gallery(image_id, photo) values(?,?)");
					InputStream is = image.getInputStream();
					stmt.setString(1, name);
					stmt.setBlob(2, is);
					int row = stmt.executeUpdate();
		            if(row == 1) {
		            	savedStatus = "saved";
		            }
	        	}
	        }catch(Exception e) {
	        	e.printStackTrace();
	        	savedStatus = "server";
	        }finally  {
		           try {
			        if(isFilePresent){
						stmt.close();
		        	}
					checkStmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        }
		return savedStatus;
	}
	
	public long getNextGalleryImgNumber() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
	    PreparedStatement stmt=null;
	    String query = "select max(id) from gallery";
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
	    String query = "select * from gallery where image_id = ?";
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
	    String query = "select * from gallery";
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
		String query = "select image_id from gallery order by id desc";
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
            stmt = conn.prepareStatement("delete from gallery where image_id = ?");
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
	
	public boolean saveLatestPageNews(String header,String body) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
      
        try {

        	conn = DBUtil.getConnection();
        	stmt = conn.prepareStatement("update information set header = ?,body = ? where id = ?");
			stmt.setString(1, header);
			stmt.setString(2, body);
			stmt.setLong(3, 1);
			
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
	
	public Map<String,String> getLatestNewContent() {
		Connection conn=null;
		PreparedStatement stmt=null;
		Map<String,String> news = new HashMap<String,String>();
		String query = "select * from information where id = 1";
		try {
			conn = DBUtil.getConnection();
			stmt = conn.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				news.put("header", rs.getString("header"));
				news.put("body", rs.getString("body"));
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
	
}
