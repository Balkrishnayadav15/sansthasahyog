// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:07:17 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   UtilLib.java

package com.sanstha.sahyog.ca.fea.db.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import com.sanstha.sahyog.ca.fea.db.exception.NotFoundException;

public final class UtilLib
{

    private UtilLib()
    {
    }

    public static Properties getPropertiesFromFile(String aFileName)
        throws NotFoundException
    {
        return getPropertiesFromFile(aFileName, false);
    }

    public static Properties getPropertiesFromFile(String aFileName, boolean aAnywhereOnClasspathFlag)
        throws NotFoundException
    {
        InputStream myIS = null;
        if(aAnywhereOnClasspathFlag)
            myIS = (new UtilLib()).getClass().getResourceAsStream((new StringBuilder("/")).append(aFileName).toString());
        else
            try
            {
                myIS = new FileInputStream(aFileName);
            }
            catch(FileNotFoundException fnfe)
            {
                throw new NotFoundException((new StringBuilder("Can't find properties file ")).append(aFileName).toString());
            }
        Properties myResultProperties = new Properties();
        try
        {
            myResultProperties.load(myIS);
        }
        catch(Exception e)
        {
            throw new NotFoundException((new StringBuilder("Can't read the properties file. Make sure ")).append(aFileName).append(" is in the CLASSPATH").toString());
        }
        return myResultProperties;
    }

    public static Properties getPropertiesFromFileOnClasspath(String aFileName)
        throws NotFoundException
    {
        return getPropertiesFromFile(aFileName, true);
    }
}