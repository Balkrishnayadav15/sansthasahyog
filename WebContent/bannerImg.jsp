<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.*, com.sanstha.sahyog.model.*,java.io.ByteArrayOutputStream,
    java.io.InputStream,java.sql.*,com.sanstha.sahyog.util.DBUtil,com.sanstha.sahyog.model.Gallery,javax.servlet.http.Part
    "
%>

<%

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
            request.setAttribute("BANNER_IMG", glList);
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

%>