package com.sanstha.sahyog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.User;

@WebServlet("/downloadUsers")                  
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 2067115822080269398L;
	
    

	
	public void init() throws ServletException {
		// Do nothing
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegistrationDao register= new RegistrationDao();

		try {
			String columnsString;
			String[] columns = null;
			if(null != request.getParameter("selectedUser")){
				columns = request.getParameter("selectedUser").split(",");
			}
			
			//Get all user from database
			List<User> allUser = register.downloadAllUser();

			
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "attachment; filename=AllUserList.xls");
			Workbook workbook = createExcel(columns,allUser);
			workbook.write(response.getOutputStream());
		} catch (Exception e) {
			throw new ServletException("Exception in DownLoad Excel Servlet", e);
		}
	}

	
	
	private Workbook createExcel(String [] columns, List<User> users) {
		 // Create a Workbook
		HSSFWorkbook workbook = new HSSFWorkbook();

        /* CreationHelper helps us create instances of various things like DataFormat, 
           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
        CreationHelper createHelper = workbook.getCreationHelper();

        // Create a Sheet
        Sheet sheet = workbook.createSheet("Users");

        // Create a Font for styling header cells
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLUE.getIndex());

        // Create a CellStyle with the font
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells
        for(int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
            cell.setCellStyle(headerCellStyle);
        }

       /* // Create Cell Style for formatting Date
        CellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
*/
        // Create Other rows and cells with employees data
        int rowNum = 1;
        for(User user: users) {
            Row row = sheet.createRow(rowNum++);
            for(int i = 0; i < columns.length; i++) {
            	if(columns[i].equals("User Id")){
            		row.createCell(i).setCellValue(user.getRegisterId());
            	}
            	if(columns[i].equals("Institute Name")){
            		row.createCell(i).setCellValue(user.getSchoolName());
            	}
            	if(columns[i].equals("Institute Address")){
            		row.createCell(i).setCellValue(user.getSchoolAddress());
            	}
            	if(columns[i].equals("Institute Established Year")){
            		row.createCell(i).setCellValue(user.geteYear());
            	}
            	if(columns[i].equals("User Type")){
            		row.createCell(i).setCellValue(user.getUserType());
            	}
            	if(columns[i].equals("User Name")){
            		row.createCell(i).setCellValue(user.getName());
            	}
            	if(columns[i].equals("Gender")){
            		row.createCell(i).setCellValue(user.getGender());
            	}
            	if(columns[i].equals("Residential Address")){
            		row.createCell(i).setCellValue(user.getAddress());
            	}
            	if(columns[i].equals("Mobile")){
            		row.createCell(i).setCellValue(user.getMobile());
            	}
            	if(columns[i].equals("Date Of Birth")){
            		row.createCell(i).setCellValue(user.getDateOfBirth());
            	}
            	if(columns[i].equals("Pincode")){
            		row.createCell(i).setCellValue(user.getPincode());
            	}
            	if(columns[i].equals("Emaild Id")){
            		row.createCell(i).setCellValue(user.getEmail());
            	}
            	if(columns[i].equals("Registration Fees")){
            		row.createCell(i).setCellValue(user.getRegisterFees());
            	}
            	if(columns[i].equals("Status")){
            		row.createCell(i).setCellValue(user.getStatus());
            	}
            	if(columns[i].equals("Dise Code")){
            		row.createCell(i).setCellValue(user.getDise_code());
            	}
            	if(columns[i].equals("Affiliation Code")){
            		row.createCell(i).setCellValue(user.getAffilition_code());
            	}
            }
        }

		// Resize all columns to fit the content size
        for(int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

		return workbook;
	}
	
	public void destroy() {
		// do nothing.
	}
}

 