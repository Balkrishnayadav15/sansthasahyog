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

import com.sanstha.sahyog.dao.RegistrationDao;
import com.sanstha.sahyog.model.SmsModel;
import com.sanstha.sahyog.util.ResponseUtility;
import com.sanstha.sahyog.util.SendSMS;

/**
 * Servlet implementation class SendSMSController
 */
@WebServlet("/sendsms")
public class SendSMSController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendSMSController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		PrintWriter writer = response.getWriter();
		RegistrationDao dao = new RegistrationDao();
		SendSMS sendSms = new SendSMS();
		Map<String,Object> result = new HashMap<String,Object>();
		SmsModel smsModel = new SmsModel();
		smsModel.setUserMessage("Thank you "+userName+" for Registing yourself with Shayog Ashasakiya Vidhalay Sangh.Your Registion number is "+userId+". Please visit our site www.sasnthasahyog.com"); 
		boolean isSmsSend = sendSms.sendMessage(smsModel);
		if(isSmsSend) {
			dao.updateSmsStatus(Long.parseLong(userId));
			result.put("VALID", "yes");
		}else {
			result.put("VALID", "no");
		}
		String jsonStr = ResponseUtility.objectToString(result); 
		writer.println(jsonStr);
		writer.close();
	}

}
