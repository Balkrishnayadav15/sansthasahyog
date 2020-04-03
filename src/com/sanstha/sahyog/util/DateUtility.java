package com.sanstha.sahyog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	public static String ifDateIsOld(String date) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yyyy");
		Date formateChangeDate = format1.parse(date);
		String newFomate= format2.format(formateChangeDate);
		
	    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(newFomate);  
	    Date todayDate = new Date();
	    
	    if(date1.before(todayDate)){
	    	return "Y";
	    }else{
	    	return "N";
	    }
	}
}
