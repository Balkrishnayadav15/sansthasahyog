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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanstha.sahyog.dao.LoginDao;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		session.setAttribute("LOGGEDIN", userId);
		ObjectMapper Obj = new ObjectMapper();
		Map result = new HashMap();
		PrintWriter writer = response.getWriter();
		LoginDao login = new LoginDao();
		boolean isValidUser = login.isValidUser(userId, password);
		if(isValidUser) {
			//response.sendRedirect("admin.jsp");
			result.put("VALID", "yes");
		}else {
			result.put("VALID", "no");
		}
		String jsonStr = Obj.writeValueAsString(result); 
		writer.println(jsonStr);
		writer.close();
	}
}
