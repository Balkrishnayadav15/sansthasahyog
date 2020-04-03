<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  
    import="java.util.*, com.sanstha.sahyog.model.*,java.io.ByteArrayOutputStream,
    java.io.InputStream,java.sql.*,com.sanstha.sahyog.util.DBUtil,com.sanstha.sahyog.model.Gallery,javax.servlet.http.Part,
    com.sanstha.sahyog.dao.*
    "
%>

<%

DashBoardDao dashBoard = new DashBoardDao();
Map<String,Object> homePageMap = dashBoard.getAllHomePageData();
request.setAttribute("HOMEPAGE_MAP", homePageMap);

String homeJsp = "/sansthaSahyog.jsp";
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(homeJsp);
dispatcher.include(request,response);

%>