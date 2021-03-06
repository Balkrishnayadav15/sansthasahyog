package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentUser = request.getParameter("currentUser");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		User user = null;
		RegistrationDao register= new RegistrationDao();
		String sessionUser = (String)session.getAttribute("LOGGEDIN");
		Map<String,Object> result = new HashMap<String,Object>();
		if(sessionUser.equals(currentUser)) {
			result.put("VALID", "yes");
			user = new User();
			
			if(null != request.getParameter("schoolName")) {
				user.setSchoolName(request.getParameter("schoolName"));
			}
			if(null != request.getParameter("schoolAddress")) {
				user.setSchoolAddress(request.getParameter("schoolAddress"));
			}
			if(null != request.getParameter("eYear")) {
				user.seteYear(request.getParameter("eYear"));
			}
			if(null != request.getParameter("userType")) {
				user.setUserType(request.getParameter("userType"));
			}
			if(null != request.getParameter("name")) {
				user.setName(request.getParameter("name"));
			}
			if(null != request.getParameter("gender")) {
				user.setGender(request.getParameter("gender"));
			}
			if(null != request.getParameter("address")) {
				user.setAddress(request.getParameter("address"));
			}
			if(null != request.getParameter("mobile")) {
				user.setMobile(request.getParameter("mobile"));
			}
			if(null != request.getParameter("dateofbirth")) {
				user.setDateOfBirth(request.getParameter("dateofbirth"));
			}
			if(null != request.getParameter("pincode")) {
				user.setPincode(request.getParameter("pincode"));
			}
			if(null != request.getParameter("email")) {
				user.setEmail(request.getParameter("email"));
			}
			if(null != request.getParameter("userId")) {
				user.setRegisterId(request.getParameter("userId"));
			}
			if(null != currentUser) {
				user.setUpdatedBy(currentUser);
			}
			
			try {
				
				user = register.updateUserDetails(user);
				if(null != user) {
					result.put("USER", user);
				}else {
					result.put("USER", null);
				}
			} catch (Exception e) {
				result.put("REG_ID_ISSUE", "yes");
				e.printStackTrace();
			}
			
		}else {
			result.put("VALID", "no");
		}
		String jsonStr = ResponseUtility.objectToString(result); 
		writer.println(jsonStr);
		writer.close();
	}

}
