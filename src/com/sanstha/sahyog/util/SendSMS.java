package com.sanstha.sahyog.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sanstha.sahyog.model.SmsModel;

/*
 * Used to send SMS messages
 */
public class SendSMS {

	public static void main(String[] args) {
		
		SendSMS testSms = new SendSMS();
		testSms.sendMessage(null);
		
	}
	
	public boolean sendMessage(SmsModel smsDetails){
		
		try {
			// Construct data
			String apiKey = SansthaConstants.SMSAPIKEY;
			String message = "&message="+"Thank you Vijay Dubey for Registring yourself with Shayog Ashasakiya Vidhalay Sangh.Your Registion number is 101. Please visit our site : www.sasnthasahyog.com";//smsDetails.getUserMessage();
			//String sender = "&sender=" + "SansthaSahyog";  //smsDetails.getMessageSender();
			String numbers = "&numbers=" + "919977866588"; //smsDetails.getMobNum();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message;// + sender;
			
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println("-->rest-->"+ stringBuffer.toString());
			return true;
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return false;
		}
		
	}
	
}
