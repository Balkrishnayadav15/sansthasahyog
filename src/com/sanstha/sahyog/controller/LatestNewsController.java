package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sanstha.sahyog.dao.DashBoardDao;
import com.sanstha.sahyog.dao.LoginDao;
import com.sanstha.sahyog.util.ResponseUtility;

@WebServlet("/latestNews")
public class LatestNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LatestNewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String header = request.getParameter("newsHeader");
		String body = request.getParameter("newsBody");
		
		DashBoardDao latestDAo = new DashBoardDao();
		boolean isNewsUploaded = latestDAo.saveLatestPageNews(header, body);
		if(isNewsUploaded) {
			request.setAttribute("HEADER_IMG", "SAVED");
		}
		
		String adminJsp = "/latestNews.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
	}
}
