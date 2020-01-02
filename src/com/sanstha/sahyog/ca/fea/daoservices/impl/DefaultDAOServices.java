// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 3:59:39 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DefaultDAOServices.java

package com.sanstha.sahyog.ca.fea.daoservices.impl;


import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.util.ConnectionUtil;

public class DefaultDAOServices
    implements DAOServices
{

    public DefaultDAOServices(DataSource dataSource)
    {
        this.dataSource = dataSource;
    }

    public Connection borrowConnection()
        throws SQLException
    {
        return dataSource.getConnection();
    }

    public void returnConnection(Connection conn)
    {
        ConnectionUtil.closeQuietly(conn);
    }

    public Connection getNativeConnection(Connection conn)
    {
       
        return conn;
    }

    private DataSource dataSource;
}