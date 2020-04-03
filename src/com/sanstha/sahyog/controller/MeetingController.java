package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sanstha.sahyog.dao.EnquiryDao;
import com.sanstha.sahyog.dao.MeetingDeskDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.Enquiry;
import com.sanstha.sahyog.model.Meeting;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class RegisterContorller
 */
@WebServlet("/meeting")
@MultipartConfig(maxFileSize = 100*1024*1024)
public class MeetingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeetingController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MeetingDeskDao meetingDao= new MeetingDeskDao();
		//Get all meeting details
		List<Meeting> meetingList;
		String type = request.getParameter("type");
		try {
			meetingList = meetingDao.getAllMeetings();
			request.setAttribute("MEETING_LIST", meetingList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if("nonadmin".equals(type)){
			String adminJsp = "/meeting.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
			dispatcher.include(request,response);
		}else{
			String adminJsp = "/adminMeeting.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
			dispatcher.include(request,response);
		}
	
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MeetingDeskDao meetingDao= new MeetingDeskDao();
		Meeting meeting = new Meeting();

		String type = request.getParameter("type");
		try {
			if("upload".equals(type)){
				long fileSizeLimit = 150000;
				String fileType = request.getParameter("fileType");
				Part file = request.getPart("uploadFile");
				String meetingId = request.getParameter("meetingId");
				long fileSize = file.getSize();
				boolean imageStatus = false;
					if(null != file && fileSize > 0){
						String fileName = getFileName(file);
						if(null!=fileName && !fileName.contains(".pdf")){
							request.setAttribute("MESSAGE", "NOTPDF");
						}else if(fileSize/1024 <= fileSizeLimit){
							imageStatus = meetingDao.saveMeetingDocs(file,fileName,fileType,meetingId);
						}else{
							request.setAttribute("MESSAGE", "EXCEED");
						}
					}else{
						request.setAttribute("MESSAGE", "FILENOTFOUND");
					}
			}else{
				meeting.setMeetingDate(request.getParameter("meetdate"));
				meeting.setMeetingTime(request.getParameter("hours")+":"+request.getParameter("minute")+" "+request.getParameter("periods"));
				meeting.setTopic(request.getParameter("meettopic"));
				meeting.setVenue(request.getParameter("meetvenue"));
				long nextRegNum = 000;
				//Get next meeting number
				nextRegNum = meetingDao.getNextMeetNumber();
				String meetingId = "SANMEET"+nextRegNum;

				meeting.setMeetingId(meetingId);
				meeting.setId(nextRegNum);
				//Save meeting info
				boolean isSave = meetingDao.saveMeetings(meeting);
				if(isSave) {
					request.setAttribute("MESSAGE", "SAVED");
					request.setAttribute("MEETING_ID", meetingId);
				}else {
					request.setAttribute("MESSAGE", "NOT_SAVED");
				}
			}
			//Get all meeting details
			List<Meeting> meetingList = meetingDao.getAllMeetings();
			request.setAttribute("MEETING_LIST", meetingList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		String adminJsp = "/adminMeeting.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
	}

	 private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	}
}
