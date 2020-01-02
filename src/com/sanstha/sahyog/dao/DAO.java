/* $Id: DAO.java,v 1.13 2011-09-28 06:25:55 pahir Exp $ */
package com.sanstha.sahyog.dao;

import java.io.Writer;
import java.net.URLEncoder;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sanstha.sahyog.ca.fea.daoservices.DAOTransaction;

import oracle.jdbc.driver.OracleTypes;
import oracle.sql.CLOB;


/**
 * Data access objects base class. It contains methods common to all data access
 * objects.
 *
 * @author dkellam
 */
public class DAO {
	 private Log log = LogFactory.getLog(this.getClass());

    // --------------------------------------------------------- Public Methods

    /**
     * Close all database resources. Exceptions will be caught and ignored.
     *
     * @param conn
     *            The Connection to close.
     * @param stmt
     *            The Statement to close.
     * @param rset
     *            The ResultSet to close.
     */
    public void closeAll(Connection conn, Statement stmt, ResultSet rset) {
        try {
            rset.close();
        } catch (Throwable t) {
        }

        ;

        try {
            stmt.close();
        } catch (Throwable t) {
        }

        ;

        try {
            conn.close();
        } catch (Throwable t) {
        }

        ;
    }

    /**
     * Close all database resources. Exceptions will be caught and ignored.
     *
     * @param stmt
     *            The Statement to close.
     * @param rset
     *            The ResultSet to close.
     */
    public void closeAll(Statement stmt, ResultSet rset) {
        try {
            rset.close();
        } catch (Throwable t) {
        }

        ;

        try {
            stmt.close();
        } catch (Throwable t) {
        }

        ;
    }

    /**
     * Close database connection. Exceptions will be caught and ignored.
     *
     * @param conn
     *            The Connection to close.
     */
    public void close(Connection conn) {
        try {
            conn.close();
        } catch (Throwable t) {
        }

        ;
    }

    public long parseEstDates(String isisDate){
        
    	String dateFormat = "yyyy-MM-dd HH:mm:ss.SSS"; 
        
    	if(isisDate.length() == 21){
             dateFormat =              "yyyy-MM-dd HH:mm:ss.S";
    	 }else if(isisDate.length() == 22){
             dateFormat = 
             "yyyy-MM-dd HH:mm:ss.SS";
    	 }else if(isisDate.length() == 23){
             dateFormat = "yyyy-MM-dd HH:mm:ss.SSS";
    	 }else if(isisDate.length() == 24){
             dateFormat =             "yyyy-MM-dd HH:mm:ss.SSSS";
    	 }else if(isisDate.length() == 25){
             dateFormat =              "yyyy-MM-dd HH:mm:ss.SSSSS";
    	 }
    	
         // As the ISIS will always give date in EST without appending EST.         
         TimeZone tz = TimeZone.getTimeZone("America/New_York");
         Calendar cal = parseDate(isisDate, tz, dateFormat);

         return cal.getTimeInMillis();
    }
    
    /**
     * Create a Calendar instance from ISO 8601 String, timezone
     * 
     * @param cal
     *            describes the date
     * @param tz
     *            which timezone for this instance
     * @return a Calendar if possible, else null
     */
    public Calendar parseDate(String cal, TimeZone tz, String format) {
     Calendar ret = Calendar.getInstance();
     
     SimpleDateFormat df = new SimpleDateFormat(format);
     df.setTimeZone(tz);
     try {
      ret.setTime(df.parse(cal));
     } catch (ParseException e) {
      return ret;
     }
     //Taking case of the offset if the Servers are in different timezone than EST.
     ret.add(Calendar.HOUR_OF_DAY, -(TimeZone.getDefault().getRawOffset() - tz.getRawOffset())/(1000*60*60));
     
     return ret;
    }



    /*
    * This method uses temporary clob to create the CLOB object.
    */
    public CLOB getCLOB(String clobData, DAOTransaction services) {
           if (clobData == null) {
                return null;
            } else if (clobData.trim().equalsIgnoreCase("")) {
                return null;
            }
        
        CallableStatement stmt = null;
        oracle.sql.CLOB tempClob = null;
        java.sql.Connection conn = null;

        try {
            conn = services.borrowConnection();
        } catch (SQLException e1) {
            log.error(e1);
            return null;
        }

        try {
            try {
                stmt = conn.prepareCall(
                        "{ call DBMS_LOB.CREATETEMPORARY(?, TRUE)}");
                stmt.registerOutParameter(1, OracleTypes.CLOB);
                stmt.execute();
                tempClob = (CLOB) stmt.getObject(1);

                //  create a new temporary CLOB

                //tempClob = (oracle.sql.CLOB)CLOB.createTemporary(conn, true, CLOB.DURATION_SESSION);
                // Open the temporary CLOB in readwrite mode to enable writing
                tempClob.open(CLOB.MODE_READWRITE);

                // Get the output stream to write
                Writer tempClobWriter = tempClob.getCharacterOutputStream();
                // Write the data into the temporary CLOB
                tempClobWriter.write(clobData);

                // Flush and close the stream
                tempClobWriter.flush();

                tempClobWriter.close();

                // Close the temporary CLOB
                tempClob.close();
            } catch (Exception exp) {
                // Free CLOB object
                log.debug("Exception in temp Clob------------------->" + exp);

                try {
                    tempClob.freeTemporary();
                } catch (SQLException e) {
                    log.error(e);
                }

                return null;
            }

            return tempClob;
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Throwable e) {
                }
            }
        }
    }

	public String clobToStringUTF(String xmlData) {
		String clobString = "";
		try {
			if (xmlData != null) {
				clobString = URLEncoder.encode(xmlData, "UTF-8");
			}
		} catch (Exception e) {
			log.error(e);
		}
		return clobString;
	}
}
