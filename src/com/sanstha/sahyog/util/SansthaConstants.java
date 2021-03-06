package com.sanstha.sahyog.util;

public class SansthaConstants {

		  /**
		   The caller references the constants using <tt>Consts.EMPTY_STRING</tt>, 
		   and so on. Thus, the caller should be prevented from constructing objects of 
		   this class, by declaring this private constructor. 
		  */
		  private SansthaConstants(){
		    //this prevents even the native class from 
		    //calling this ctor as well :
		    throw new AssertionError();
		  }
		 
		  
		 // public static final String SMSAPIKEY = "apikey=" + "lpXhe48AzEg-PCJFsjgurcu6EA1T96iyhyYbRncKQt";
		  public static final String SMSAPIKEY = "apikey=" + "lpXhe48AzEg-Q5zjQ6An30ARGBEOaVk1nQaSsjHzPL";
		  public static final String MESSAGE = " TEST MESSAGE"; // const in case if the message is FIXED like // REG SUCCESSFULL THANKS... 

	
}
