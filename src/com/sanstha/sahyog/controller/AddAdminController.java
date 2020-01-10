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

import com.sanstha.sahyog.dao.LoginDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class AddAdminController
 */
@WebServlet("/addAdmin")
public class AddAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminController() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userType = request.getParameter("userType");
		
		Map result = new HashMap();
		PrintWriter writer = response.getWriter();
		LoginDao login = new LoginDao();
		RegistrationDao register = new RegistrationDao();
		String isUser = login.isValidUser(userId, password);
		if(null != isUser) {
			result.put("VALID", "no");
		}else {
			
			result.put("VALID", "yes");
			register.saveAdminDetails(userId,password,userType);
		}
		String jsonStr = ResponseUtility.objectToString(result); 
		writer.println(jsonStr);
		writer.close();
	}

}
