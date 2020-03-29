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
 * Servlet implementation class DeleteController
 */
@WebServlet("/delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
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
		boolean isDeleted = false;
		RegistrationDao register= new RegistrationDao();
		String sessionUser = (String)session.getAttribute("LOGGEDIN");
		Map<String,Object> result = new HashMap<String,Object>();
		if(sessionUser.equals(currentUser)) {
			
			String userId = null;
			if(null != request.getParameter("userId")) {
				userId = request.getParameter("userId");
			}
			
			try {
				
				isDeleted = register.deleteUserDetails(userId);
				if(isDeleted) {
					result.put("VALID", "yes");
				}else {
					result.put("VALID", "no");
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
