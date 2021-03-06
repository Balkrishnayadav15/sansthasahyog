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

import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.DBUtil;

public class RegistrationDao {
	
	public User updateUserDetails(User user) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
        try {
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(generateUpdate(user));
           
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getUserType());
            stmt.setString(3, user.getGender());
            stmt.setString(4, user.getAddress());
            stmt.setString(5, user.getMobile());
            stmt.setString(6, user.getDateOfBirth());
            stmt.setString(7, user.getPincode());
            stmt.setString(8, user.getEmail());
            stmt.setString(9,user.getSchoolName() );
            stmt.setString(10,user.getSchoolAddress() );
            stmt.setString(11,user.geteYear() );
            stmt.setString(12,user.getUpdatedBy());
            stmt.setString(13, user.getRegisterId());
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
	private String generateUpdate(User user) {
		return "UPDATE Registration SET  Name = ?, user_type = ?,gender = ?,Residential_Address = ?,Mobile_number = ?,Date_of_birth = ?,Pincode = ?,Email_id = ?," +
				 "Institue_name = ?,Institue_address = ?,Established_year = ?,MODIFIED_BY=? WHERE REGISTRATION_ID = ?";
		
		
		
	}

	public User saveUserDetails(User user) {
		
		 	Connection conn=null;
	        PreparedStatement stmt=null;
	        
	        Date date = Calendar.getInstance().getTime();  
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
	        String todaysDate = dateFormat.format(date);  
	        
	        try {
	        	conn = DBUtil.getConnection();
	            stmt = conn.prepareStatement(generateInsert(user));
	            stmt.setString(1, user.getRegisterId());
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
	            stmt.setString(15, "No");
	            stmt.setString(16,"Pending");
	            stmt.setString(17,todaysDate);
	            stmt.setString(18,"");
	            stmt.setString(19,"");
	            stmt.setLong(20,user.getId());
	            stmt.setString(21,user.getAffilition_code());
	            stmt.setString(22,user.getDise_code());
	            
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
	
	private String generateInsert(User user) {
		return "INSERT INTO Registration (REGISTRATION_ID, Name, user_type,gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees,"
				+ "Institue_name,Institue_address,Established_year,CREATED_BY,SMS_SEND,status,CREATED_DATE,MODIFIED_DATE,MODIFIED_BY,id,affil_code,dise_code) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
	}
	
	public long getNextRegistrationNumber() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
        PreparedStatement stmt=null;
        String query = "select max(id) from Registration";
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
	
	public List<User> getAllPendingUser() throws Exception {
		long nextRegNum = 000;
		Connection conn=null;
        PreparedStatement stmt=null;
        List<User> userList = new ArrayList<User>();
        User user = null;
        String query = "select REGISTRATION_ID,Institue_name,Institue_address,Established_year, user_type, Name, gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees," + 
        		" CREATED_BY,sms_send,status,affil_code,dise_code from Registration where status='Pending' order by id asc ";
     
        try  {
        	 conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),null,null,null,rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
	
	public List<User> getAllRejectedUser() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        List<User> userList = new ArrayList<User>();
        User user = null;
        String query = "select REGISTRATION_ID,Institue_name,Institue_address,Established_year, user_type, Name, gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees," + 
        		" CREATED_BY,sms_send,status,affil_code,dise_code from Registration where status='Rejected' order by id asc ";
     
        try  {
        	 conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),null,null,null,rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
	
	public List<User> getAllUser() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        List<User> userList = new ArrayList<User>();
        User user = null;
        String query = "select REGISTRATION_ID,Institue_name,Institue_address,Established_year, user_type, Name, gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees," + 
        		" CREATED_BY,sms_send,status,affil_code,dise_code from Registration where status = 'Approved' order by id asc ";
     
        try  {
        	 conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),null,null,null,rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
	
	public List<User> downloadAllUser() throws Exception {
		long nextRegNum = 0;
		Connection conn=null;
        PreparedStatement stmt=null;
        List<User> userList = new ArrayList<User>();
        User user = null;
        String query = "select REGISTRATION_ID,Institue_name,Institue_address,Established_year, user_type, Name, gender,Residential_Address,Mobile_number,Date_of_birth,Pincode,Email_id,Registration_fees," + 
        		" CREATED_BY,sms_send,status,affil_code,dise_code  from Registration where status = 'Approved' order by id asc ";
     
        try  {
        	 conn = DBUtil.getConnection();
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
            	user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),
            			rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12),rs.getString(13),rs.getString(14),null,null,null,rs.getString(15),rs.getString(16),rs.getString(17),rs.getString(18));
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
	public boolean deleteUserDetails(String userId) {
		Connection conn=null;
        PreparedStatement stmt=null;
        try {
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("delete from Registration where REGISTRATION_ID = ?");
            stmt.setString(1, userId);
            
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
	
	public boolean updateSmsStatus(String userId) {
		Connection conn=null;
        PreparedStatement stmt=null;
        try {
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("UPDATE Registration SET  sms_send = ? where REGISTRATION_ID = ?");
            stmt.setString(1, "Yes");
            stmt.setString(2, userId);
            
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
	public boolean saveAdminDetails(String user, String password, String userType) {
		
	 	Connection conn=null;
        PreparedStatement stmt=null;
        try {
        	conn = DBUtil.getConnection();
            stmt = conn.prepareStatement("INSERT INTO user (user_id,EMAIL_ID, password,USER_TYPE,FIRST_NAME,LAST_NAME) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, user);
            stmt.setString(2, user);
            stmt.setString(3, password);
            stmt.setString(4, userType);
            stmt.setString(5, user);
            stmt.setString(6, user);
            
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

public List<User> getAllAdminUser() throws Exception{
	Connection conn=null;
    PreparedStatement stmt=null;
    List<User> adminUser = new ArrayList<User>();
    User user = null;
    String query = "select user_id,user_type,password from user";
 
    try  {
    	 conn = DBUtil.getConnection();
        stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
        	user = new User();
        	user.setName(rs.getString(1));
        	user.setUserType(rs.getString(2));
        	user.setPassword(rs.getString(3));
        	adminUser.add(user);
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
    return adminUser;
}


public List<String> getAllUserIds() throws Exception{
	Connection conn=null;
    PreparedStatement stmt=null;
    List<String> adminUser = new ArrayList<String>();
    User user = null;
    String query = "SELECT REGISTRATION_ID FROM Registration WHERE REGISTRATION_ID NOT IN ( SELECT user_id FROM user) and status = 'Approved' ";
 
    try  {
    	 conn = DBUtil.getConnection();
        stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
        	adminUser.add(rs.getString(1));
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
    return adminUser;
}

public User approveUserStatus(User user, String operation) {
	
 	Connection conn=null;
    PreparedStatement stmt=null;
    try {
    	conn = DBUtil.getConnection();
    	String updateStatusQuery = "UPDATE Registration SET status = ?,MODIFIED_BY=? WHERE REGISTRATION_ID = ?";
        stmt = conn.prepareStatement(updateStatusQuery);
        if(operation.equals("approve")){
            stmt.setString(1, "Approved");
        }else{
            stmt.setString(1, "Rejected");
        }
        stmt.setString(2,user.getUpdatedBy());
        stmt.setString(3, user.getRegisterId());
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
}
