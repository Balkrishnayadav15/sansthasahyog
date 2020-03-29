package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanstha.sahyog.dao.EnquiryDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.Enquiry;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class RegisterContorller
 */
@WebServlet("/enquiry")
public class EnquiryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnquiryController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//Getting Enquriy Details
			EnquiryDao enquiry= new EnquiryDao();
			List<Enquiry> allEnquiry = enquiry.getAllEnquires();
			request.setAttribute("ALL_ENQUIRY", allEnquiry);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String adminJsp = "/enquiry.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		PrintWriter writer = response.getWriter();
		Enquiry user = null;
		EnquiryDao enquiry= new EnquiryDao();
		//String sessionUser = (String)session.getAttribute("LOGGEDIN");
		Map<String,Object> result = new HashMap<String,Object>();
		//if(sessionUser.equals(currentUser)) {
			user = new Enquiry();
			
			if(null != request.getParameter("name")) {
				user.setName(request.getParameter("name"));
			}
			if(null != request.getParameter("schoolName")) {
				user.setSchoolName(request.getParameter("schoolName"));
			}
			if(null != request.getParameter("address")) {
				user.setAddress(request.getParameter("address"));
			}
			if(null != request.getParameter("email")) {
				user.setEmailid(request.getParameter("email"));
			}
			if(null != request.getParameter("mobile")) {
				user.setMobileNo(request.getParameter("mobile"));
			}
			
			
			long nextRegNum = 000;
			try {
				nextRegNum = enquiry.getNextEnNumber();
				
				String userId = "ENQ";
				userId = userId+String.format("%03d", nextRegNum);
				
				user.setId(nextRegNum);
				user.setEnquiryId(userId);
				user = enquiry.saveEnquiryDetails(user);
				if(null != user) {
					result.put("VALID", "yes");
				}else {
					result.put("USER", null);
				}
			} catch (Exception e) {
				result.put("REG_ID_ISSUE", "yes");
				e.printStackTrace();
			}
			
		
		String jsonStr = ResponseUtility.objectToString(result); 
		writer.println(jsonStr);
		writer.close();
	}

}
