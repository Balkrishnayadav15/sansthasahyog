package com.sanstha.sahyog.model;

import java.util.ArrayList;
import java.util.List;

public class Meeting {

	private long id;
	private String meetingId;
	private String meetingTime;
	private String meetingDate;
	private String venue;
	private String topic;
	private List<String> attendanceSName;
	private List<String> confiPaperName;
	private List<String> nonConfiPaperName;
	private String docType;
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(String meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getVenue() {
		return venue;
	}
	public void setVenue(String venue) {
		this.venue = venue;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public List<String> getAttendanceSName() {
		return attendanceSName;
	}
	public void setAttendanceSName(List<String> attendanceSName) {
		this.attendanceSName = attendanceSName;
	}
	public List<String> getConfiPaperName() {
		return confiPaperName;
	}
	public void setConfiPaperName(List<String> confiPaperName) {
		this.confiPaperName = confiPaperName;
	}
	public List<String> getNonConfiPaperName() {
		return nonConfiPaperName;
	}
	public void setNonConfiPaperName(List<String> nonConfiPaperName) {
		this.nonConfiPaperName = nonConfiPaperName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDocType() {
		return docType;
	}
	public void setDocType(String docType) {
		this.docType = docType;
	}
	public Meeting(){}
	public Meeting(long id, String meetingId, String meetingTime, String meetingDate, String venue, String topic,
			List<String> attendanceSName, List<String> confiPaperName, List<String> nonConfiPaperName,String docType, String status) {
		super();
		
		if(meetingId != null) { this.meetingId = meetingId; }else { this.meetingId = "";}
		if(meetingTime != null) { this.meetingTime = meetingTime; }else { this.meetingTime = "";}
		if(meetingDate != null) { this.meetingDate = meetingDate; }else { this.meetingDate = "";}
		if(venue != null) { this.venue = venue; }else { this.venue = "";}
		if(topic != null) { this.topic = topic; }else { this.topic = "";}
		if(attendanceSName != null) { this.attendanceSName = attendanceSName; }else { this.attendanceSName = new ArrayList<String>();}
		if(confiPaperName != null) { this.confiPaperName = confiPaperName; }else { this.confiPaperName =  new ArrayList<String>();}
		if(nonConfiPaperName != null) { this.nonConfiPaperName = nonConfiPaperName; }else { this.nonConfiPaperName =  new ArrayList<String>();}
		if(nonConfiPaperName != null) { this.nonConfiPaperName = nonConfiPaperName; }else { this.nonConfiPaperName =  new ArrayList<String>();}
		if(status != null) { this.status = status; }else { this.status = "";}
		if(docType != null) { this.docType = docType; }else { this.docType = "";}
		this.id = id;
	}
	
	
}
