// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:06:59 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DBConfigProperties.java

package com.sanstha.sahyog.ca.fea.db.properties;

import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

import com.sanstha.sahyog.ca.fea.db.exception.NotFoundException;

// Referenced classes of package com.cisco.ca.fea.db.properties:
//            UtilLib

public final class DBConfigProperties
{

    public static String getPropertiesFileName()
    {
        String myLife = System.getProperty("cisco.life");
        System.out.println((new StringBuilder("Cisco Life: [")).append(myLife).append("]").toString());
        String myFileName = "dbConfig.properties";
        if(myLife != null)
            if(myLife.equals("prod"))
                myFileName = "dbConfig_prod.properties";
            else
            if(myLife.equals("stage"))
                myFileName = "dbConfig_stage.properties";
            else
            if(myLife.equals("dev"))
                myFileName = "dbConfig_dev.properties";
            else
            if(myLife.equals("lt"))
                myFileName = "dbConfig_lt.properties";
            else
            if(myLife.equals("dr"))
                myFileName = "dbConfig_dr.properties";
        return myFileName;
    }

    private DBConfigProperties()
        throws NotFoundException
    {
        String myFileName = "dbConfig.properties";
        String myLife = System.getProperty("cisco.life");
        System.out.println((new StringBuilder("Cisco Life: [")).append(myLife).append("]").toString());
        if(myLife != null)
            if(myLife.equals("prod"))
                myFileName = "dbConfig_prod.properties";
            else
            if(myLife.equals("stage"))
                myFileName = "dbConfig_stage.properties";
            else
            if(myLife.equals("dev"))
                myFileName = "dbConfig_dev.properties";
            else
            if(myLife.equals("lt"))
                myFileName = "dbConfig_lt.properties";
            else
            if(myLife.equals("dr"))
                myFileName = "dbConfig_dr.properties";
        System.out.println((new StringBuilder("Using Properties File: [")).append(myFileName).append("]").toString());
        cProperties = UtilLib.getPropertiesFromFileOnClasspath(myFileName);
    }

    public static synchronized String getCachedProperty(String aPropertyName)
        throws NotFoundException
    {
        if(cSingleton == null)
            cSingleton = new DBConfigProperties();
        String myPropertyValue = cProperties.getProperty(aPropertyName);
        if(myPropertyValue == null)
            throw new NotFoundException((new StringBuilder(String.valueOf(aPropertyName))).append(" property not found in ").append("GSEIT.properties").toString());
        else
            return myPropertyValue;
    }

    public static synchronized Enumeration getCachedPropertyNames()
        throws NotFoundException
    {
        if(cSingleton == null)
            cSingleton = new DBConfigProperties();
        return cProperties.propertyNames();
    }

    public static int getCachedPropertyAsInt(String aPropertyName)
        throws NotFoundException, NumberFormatException
    {
        String myStringPropertyValue = getCachedProperty(aPropertyName);
        int myResult = -1;
        try
        {
            myResult = Integer.parseInt(myStringPropertyValue);
        }
        catch(NumberFormatException nfe)
        {
            throw new NumberFormatException((new StringBuilder(String.valueOf(aPropertyName))).append(" does not have a numeric value in ").append("GSEIT.properties").toString());
        }
        return myResult;
    }

    public static synchronized void forcePropertiesReload()
    {
        cSingleton = null;
    }

    public static synchronized Properties getProperties()
        throws NotFoundException
    {
        if(cSingleton == null)
            cSingleton = new DBConfigProperties();
        return cProperties;
    }

    public static String[] getCachedPropertyAsStringArray(String aPropertyName)
        throws NotFoundException, NumberFormatException
    {
        String myStringPropertyValue = getCachedProperty(aPropertyName);
        String myResult[] = null;
        if(myStringPropertyValue.indexOf(",") != -1)
        {
            StringTokenizer myTokenizer = new StringTokenizer(myStringPropertyValue, ",");
            int myIndex = 0;
            myResult = new String[myTokenizer.countTokens()];
            while(myTokenizer.hasMoreElements()) 
                myResult[myIndex++] = myTokenizer.nextToken().trim();
        } else
        {
            myResult = new String[1];
            myResult[0] = myStringPropertyValue;
        }
        return myResult;
    }


    private static Properties cProperties = null;
    private static DBConfigProperties cSingleton = null;
    private static Logger cLogger = Logger.getLogger(DBConfigProperties.class);

}