package com.sanstha.sahyog.model;

/*
 * Used to send SMS  
 */
public class SmsModel {

	private String userMessage;
	private long mobNum;
	private String messageSender;
	
	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}
	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	/**
	 * @return the mobNum
	 */
	public long getMobNum() {
		return mobNum;
	}
	/**
	 * @param mobNum the mobNum to set
	 */
	public void setMobNum(long mobNum) {
		this.mobNum = mobNum;
	}
	/**
	 * @return the messageSender
	 */
	public String getMessageSender() {
		return messageSender;
	}
	/**
	 * @param messageSender the messageSender to set
	 */
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	} 
	
	
	
}
