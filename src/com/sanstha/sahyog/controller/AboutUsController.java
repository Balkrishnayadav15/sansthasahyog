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

import com.sanstha.sahyog.dao.AboutUsDao;
import com.sanstha.sahyog.dao.DashBoardDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.Gallery;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/aboutUs")
@MultipartConfig(maxFileSize = 16177216)
public class AboutUsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AboutUsController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		String method = req.getParameter("_method");
		AboutUsDao aboutDao= new AboutUsDao();
		
		 if("DELETE".equals(method)){
				String id = req.getParameter("id");
				boolean isAbout = aboutDao.deleteAboutUs(id);
				if(isAbout) {
					req.setAttribute("DELETED", "DELETED");
				}
		 }	
		String redirect = req.getParameter("redirect"); 
		try {
			List<Map<String,String>> aboutUsType = aboutDao.getAboutUsType(type);
			req.setAttribute("ABOUT-US", aboutUsType);
			req.setAttribute("TYPE", type);
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if("admin".equals(redirect)){
			String adminJsp = "/adminAbout.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
			dispatcher.include(req,resp);
		}else{
			String adminJsp = "/about.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
			dispatcher.include(req,resp);
		}
		

	}

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("_method");
		String type = request.getParameter("type");
		AboutUsDao aboutDao= new AboutUsDao();
		
		if("PUT".equals(method)){
			String header = request.getParameter("header");
			String body = request.getParameter("body");
			String id = request.getParameter("id");
			boolean isAbout = aboutDao.updateAboutUs(header, body, type,id);
			if(isAbout) {
				request.setAttribute("EDITED", "EDITED");
			}
		}else if("DELETE".equals(method)){
			String id = request.getParameter("id");
			boolean isAbout = aboutDao.deleteAboutUs(id);
			if(isAbout) {
				request.setAttribute("DELETED", "DELETED");
			}
		}else{
			String header = request.getParameter("header");
			String body = request.getParameter("body");
			boolean isAbout = aboutDao.saveAboutUs(header, body, type);
			if(isAbout) {
				request.setAttribute("ABOUT_US_SAVE", "SAVED");
			}
		}
		List<Map<String,String>> aboutUsType = aboutDao.getAboutUsType(type);
		request.setAttribute("ABOUT-US", aboutUsType);
		request.setAttribute("TYPE", type);
		
		
		String adminJsp = "/adminAbout.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
		
		
	}

	
}
