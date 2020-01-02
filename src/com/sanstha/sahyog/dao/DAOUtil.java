package com.sanstha.sahyog.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.DAOServicesFactory;
import com.sanstha.sahyog.ca.fea.daoservices.DAOTransaction;
import com.sanstha.sahyog.ca.fea.daoservices.DAOTransactionFactory;
import com.sanstha.sahyog.util.DBUtil;



/**
 * This class initializes the connection pool and is then used for getting a
 * DAOServices object.
 *
 * @author strilok
 */
public class DAOUtil
{
	// The Log instance for this class.
	 private static final Logger LOGGER = LoggerFactory.getLogger(DAOUtil.class);

	
	 /**
	 * This method returns a DAOServices object.
	 *
	 * @return
	 */
	public static DAOServices getServices()
	{
		return DAOServicesFactory.create(getDataSource());
	}

	/**
	 *
	 * @return
	 */
	public static DAOTransaction getTransaction()
	{
		return DAOTransactionFactory.create(getDataSource());
	}
	
	/**
     * get Datasource
     * @param none
     * @return Datasource
     */
    public static DataSource getDataSource() {    	
    	DataSource ds=null;
       try {
    	   		ds = DBUtil.getDataSource();
    	   		//This datasource is basically coming from Apache library
    	       //ds= DataSourceManager.getDataSource(defaultPool);
    	       /** For Local Deployment uncomment below line and comment above line* */
    	       // ds= DBConnection.getPooler(defaultPool);
	} catch (SQLException e) {		
		e.printStackTrace();
	}
       return ds;
    }  
}
