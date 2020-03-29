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

import com.sanstha.sahyog.dao.DashBoardDao;
import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.Gallery;
import com.sanstha.sahyog.model.User;
import com.sanstha.sahyog.util.ResponseUtility;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/gallery")
@MultipartConfig(maxFileSize = 16177216)
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GalleryController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String imageId = req.getParameter("imageId");
		String reqType = req.getParameter("reqType");
		DashBoardDao galleryDao= new DashBoardDao();
		
		try {
			if(null != reqType && reqType.equals("delete")){
				boolean isDelete = galleryDao.deleteGalleryImage(imageId);
				if(isDelete){
					//getAllIdsNImage(req, imageId, galleryDao);
					req.setAttribute("IS_IMG_DELETE", "YES");
				}
				getAllIdsNImage(req, imageId, galleryDao,reqType);
			}else if(null != reqType && reqType.equals("view")){
				getAllIdsNImage(req, imageId, galleryDao,reqType);
			}else{
				getAllIdsNImage(req, null, galleryDao,reqType);
			}
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String adminJsp = "/gallery.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(req,resp);

	}

	private void getAllIdsNImage(HttpServletRequest req, String imageId, DashBoardDao galleryDao,String reqType) throws Exception {
		Gallery gl;
		//Get all image ids
		List<String> imageIdList = galleryDao.getAllImageIds();
		req.setAttribute("GALLERY_IMG_IDS", imageIdList);
		//Get image by image id
		if(null != imageId && !imageId.equals("")){
			if("delete".equals(reqType)){
				imageId = imageIdList.get(0);
			}
			gl = galleryDao.getImageById(imageId);
			req.setAttribute("GALLERY_IMG", gl);
		}else{
			if(null != imageIdList){
				imageId = imageIdList.get(0);
				gl = galleryDao.getImageById(imageId);
				req.setAttribute("GALLERY_IMG", gl);
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part part = request.getPart("image");
		if(null != part){}
		System.out.println("dff");
		Map<String,Object> result = new HashMap<String,Object>();
		PrintWriter writer = response.getWriter();
		boolean user = false;
		DashBoardDao galleryDao= new DashBoardDao();
		
		try {
			user = galleryDao.saveGalleryImages(part);
			getAllIdsNImage(request, null, galleryDao,null);
			request.setAttribute("IS_IMG_SAVED", "YES");
			if(user) {
				result.put("VALID", "yes");
			}else {
				result.put("VALID", "no");
			}
		} catch (Exception e) {
			result.put("REG_ID_ISSUE", "yes");
			e.printStackTrace();
		}


		String adminJsp = "/gallery.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);

		
		
	}

}
