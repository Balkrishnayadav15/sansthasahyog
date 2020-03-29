package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sanstha.sahyog.dao.EnquiryDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.Enquiry;
import com.sanstha.sahyog.model.User;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationDao register= new RegistrationDao();
	
		try {
			//Get all user with completed status
			List<User> allUser = register.getAllUser();
			request.setAttribute("ALL_USER", allUser);
			
			//Get all user with Pending status
			List<User> pendingUsers = register.getAllPendingUser();
			request.setAttribute("PENDING_USER", pendingUsers);
			
			//Get all user with Pending status
			List<User> rejectedUsers = register.getAllRejectedUser();
			request.setAttribute("REJECTED_USER", rejectedUsers);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String adminJsp = "/admin.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
