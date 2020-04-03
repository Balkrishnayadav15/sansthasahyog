package com.sanstha.sahyog.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanstha.sahyog.dao.MeetingDeskDao;

@WebServlet(description = "Download File From The Server", urlPatterns = { "/downloadFile" })
public class FileDownloadController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static int BUFFER_SIZE = 1024 * 100;
	public static final String UPLOAD_DIR = "uploadedFiles";

	/***** This Method Is Called By The Servlet Container To Process A 'GET' Request *****/
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		handleRequest(request, response);
	}

	public void handleRequest(HttpServletRequest request, HttpServletResponse response){

		/***** Get The Absolute Path Of The File To Be Downloaded *****/
		String fileName = request.getParameter("fileName");
		String meetingId = request.getParameter("meetingId");
		String fileType = request.getParameter("fileType");
		
		OutputStream outStream = null;

		/**** Setting The Content Attributes For The Response Object ****/
		String mimeType = "application/octet-stream";
		response.setContentType(mimeType);

		/**** Setting The Headers For The Response Object ****/
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", fileName);
		response.setHeader(headerKey, headerValue);
		MeetingDeskDao meetingDao = new MeetingDeskDao();
		try {

			/**** Get The Output Stream Of The Response ****/
			//outStream = meetingDao.downloadFile(fileName,meetingId,fileType);
			 // For big BLOB data.
	           Blob fileData = meetingDao.downloadFile(fileName,meetingId,fileType);
	           InputStream is = fileData.getBinaryStream();
	 
	           byte[] bytes = new byte[1024];
	           int bytesRead;
	 
	           while ((bytesRead = is.read(bytes)) != -1) {
	               // Write image data to Response.
	               response.getOutputStream().write(bytes, 0, bytesRead);
	           }
	           is.close();
	 
		} catch(Exception ioExObj) {
			System.out.println("Exception While Performing The I/O Operation?= " + ioExObj.getMessage());
		} finally {             

		/*	try {
				outStream.flush();
				if (outStream != null) {
					outStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
		}
	} /*else {

	 *//***** Set Response Content Type *****//*
			response.setContentType("text/html");

	  *//***** Print The Response *****//*
			response.getWriter().println("<h3>File "+ fileName +" Is Not Present .....!</h3>");
		}*/

}

