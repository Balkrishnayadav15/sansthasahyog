package com.sanstha.sahyog.model;

public class User {

	public long registerId;
	public String schoolName;
	public String schoolAddress;
	public String eYear;
	public String userType;
	public String name;
	public String gender;
	public String address;
	public String mobile;
	public String dateOfBirth;
	public String pincode;
	public String email;
	public String registerFees;
	public String createdBy;
	public String updatedBy;
	public String createdDate;
	public String updatedDate;
	public String smsSend;
	public String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolAddress() {
		return schoolAddress;
	}
	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}
	public String geteYear() {
		return eYear;
	}
	public void seteYear(String eYear) {
		this.eYear = eYear;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegisterFees() {
		return registerFees;
	}
	public void setRegisterFees(String registerFees) {
		this.registerFees = registerFees;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getRegisterId() {
		return registerId;
	}
	public void setRegisterId(long registerId) {
		this.registerId = registerId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	public String getSmsSend() {
		return smsSend;
	}
	public void setSmsSend(String smsSend) {
		this.smsSend = smsSend;
	}
	public User(long registerId, String schoolName, String schoolAddress, String eYear, String userType, String name,
			String gender, String address, String mobile, String dateOfBirth, String pincode, String email,
			String registerFees, String createdBy, String updatedBy, String createdDate, String updatedDate,String smsSend) {
		super();
		this.registerId = registerId;
		if(schoolName != null) { this.schoolName = schoolName; }else { this.schoolName = "";}
		if(schoolAddress != null) {this.schoolAddress = schoolAddress;}else { this.schoolAddress = "";}
		if(eYear != null) {this.eYear = eYear;}else { this.eYear = "";}
		if(userType != null) {this.userType = userType;}else { this.userType = "";}
		if(name != null) {this.name = name;}else { this.name = "";}
		if(gender != null) {this.gender = gender;}else { this.gender = "";}
		if(address != null) {this.address = address;}else { this.address = "";}
		if(mobile != null) {this.mobile = mobile;}else { this.mobile = "";}
		if(dateOfBirth != null) {this.dateOfBirth = dateOfBirth;}else { this.dateOfBirth = "";}
		if(pincode != null) {this.pincode = pincode;}else { this.pincode = "";}
		if(email != null) {this.email = email;}else { this.email = "";}
		if(registerFees != null) {this.registerFees = registerFees;}else { this.registerFees = "";}
		if(createdBy != null) {this.createdBy = createdBy;}else { this.createdBy = "";}
		if(updatedBy != null) {this.updatedBy = updatedBy;}else { this.updatedBy = "";}
		if(createdDate != null) {this.createdDate = createdDate;}else { this.createdDate = "";}
		if(updatedDate != null) {this.updatedDate = updatedDate;}else { this.updatedDate = "";}
		if(smsSend != null) {this.smsSend = updatedDate;}else { this.smsSend = "";}
	}
	
	public User() {}
	
}
