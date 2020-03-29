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
@WebServlet("/approve")
public class ApproveStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveStatusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentUser = request.getParameter("currentUser");
		String operation = request.getParameter("operation");
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		User user = null;
		RegistrationDao register= new RegistrationDao();
		String sessionUser = (String)session.getAttribute("LOGGEDIN");
		Map<String,Object> result = new HashMap<String,Object>();
		if(sessionUser.equals(currentUser)) {
			result.put("VALID", "yes");
			user = new User();
			
			if(null != request.getParameter("userId")) {
				user.setRegisterId(request.getParameter("userId"));
			}
			if(null != currentUser) {
				user.setUpdatedBy(currentUser);
			}
			
			try {
				
				user = register.approveUserStatus(user,operation);
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
