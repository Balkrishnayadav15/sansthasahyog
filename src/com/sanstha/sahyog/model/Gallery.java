package com.sanstha.sahyog.model;

import java.sql.Blob;

public class Gallery {

	private long id ;
	private String image_id;
	//private Blob image;
	private byte[] image; 
	 private String base64Image;
     
	    public String getBase64Image() {
	        return base64Image;
	    }
	 
	    public void setBase64Image(String base64Image) {
	        this.base64Image = base64Image;
	    }
	    
	    
	public Gallery(long id, String image_id, String base64Image) {
		super();
		this.id = id;
		this.image_id = image_id;
		this.base64Image = base64Image;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getImage_id() {
		return image_id;
	}
	public void setImage_id(String image_id) {
		this.image_id = image_id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
}
