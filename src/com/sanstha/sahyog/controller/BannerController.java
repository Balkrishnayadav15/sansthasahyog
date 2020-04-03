package com.sanstha.sahyog.controller;

import java.io.IOException;
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
import javax.servlet.http.Part;

import com.sanstha.sahyog.dao.BannerDao;
import com.sanstha.sahyog.model.Gallery;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/banner")
@MultipartConfig(maxFileSize = 100*1024*1024)
public class BannerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BannerController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String imageId = req.getParameter("imageId");
		String reqType = req.getParameter("reqType");
		BannerDao galleryDao= new BannerDao();
		
		try {
			if(null != reqType && reqType.equals("delete")){
				boolean isDelete = galleryDao.deleteGalleryImage(imageId);
				if(isDelete){
					req.setAttribute("IS_IMG_DELETE", "YES");
					req.setAttribute("DEL_IMAGE_ID", imageId);
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

		String adminJsp = "/banner.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(req,resp);

	}

	private void getAllIdsNImage(HttpServletRequest req, String imageId, BannerDao galleryDao,String reqType) throws Exception {
		Gallery gl;
		//Get all image ids
		List<String> imageIdList = galleryDao.getAllImageIds();
		req.setAttribute("GALLERY_IMG_IDS", imageIdList);
		//Get image by image id
		if(null != imageId && !imageId.equals("")){
			if("delete".equals(reqType) && imageIdList.size() > 0){
				imageId = imageIdList.get(0);
			}
			gl = galleryDao.getImageById(imageId);
			req.setAttribute("GALLERY_IMG", gl);
		}else{
			if(null != imageIdList && imageIdList.size() > 0){
				imageId = imageIdList.get(0);
				gl = galleryDao.getImageById(imageId);
				req.setAttribute("GALLERY_IMG", gl);
			}
		}
		req.setAttribute("IMAGE_ID", imageId);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Part part = request.getPart("image");
		Map<String,Object> result = new HashMap<String,Object>();
		BannerDao galleryDao= new BannerDao();
		long fileSizeLimit = 500;
		try {
			long fileSize = part.getSize();
			if(null != part && fileSize > 0){
				
				if(fileSize/1024 <= fileSizeLimit){
					String imageStatus = "";
					String imageName = getFileName(part);
					imageStatus = galleryDao.saveGalleryImages(part,imageName);
					getAllIdsNImage(request, null, galleryDao,null);
					request.setAttribute("IS_IMG_SAVED", imageStatus);
				}else{
					getAllIdsNImage(request, null, galleryDao,null);
					request.setAttribute("FileSize", "EXCEED");
				}
			}else{
				getAllIdsNImage(request, null, galleryDao,null);
				request.setAttribute("IMAGENOTFOUND", "IMAGENOTFOUND");
			}	
		} catch (Exception e) {
			result.put("REG_ID_ISSUE", "yes");
			e.printStackTrace();
		}

		String adminJsp = "/banner.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(adminJsp);
		dispatcher.include(request,response);
	}
	 private String getFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        System.out.println("content-disposition header= "+contentDisp);
	        String[] tokens = contentDisp.split(";");
	        for (String token : tokens) {
	            if (token.trim().startsWith("filename")) {
	                return token.substring(token.indexOf("=") + 2, token.length()-1);
	            }
	        }
	        return "";
	}
}