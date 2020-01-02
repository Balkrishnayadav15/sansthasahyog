// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:00:10 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DefaultDAOTransaction.java

package com.sanstha.sahyog.ca.fea.daoservices.impl;


import java.sql.*;

import com.sanstha.sahyog.ca.fea.daoservices.DAOServices;
import com.sanstha.sahyog.ca.fea.daoservices.DAOTransaction;

public class DefaultDAOTransaction
    implements DAOTransaction
{

    public DefaultDAOTransaction(DAOServices daoServices)
    {
        this.daoServices = daoServices;
    }

    public void beginTransaction()
        throws SQLException
    {
        conn = daoServices.borrowConnection();
    }

    public void commit()
        throws SQLException
    {
        conn.commit();
    }

    public void rollback()
        throws SQLException
    {
        conn.rollback();
    }

    public void endTransaction()
        throws SQLException
    {
        daoServices.returnConnection(conn);
    }

    public Connection borrowConnection()
        throws SQLException
    {
        return conn;
    }

    public void returnConnection(Connection connection1)
    {
    }

    public Connection getNativeConnection(Connection conn)
    {
        return daoServices.getNativeConnection(conn);
    }

    public void rollback(Savepoint savepoint)
        throws SQLException
    {
        conn.rollback(savepoint);
    }

    public void releaseSavepoint(Savepoint savepoint)
        throws SQLException
    {
        conn.releaseSavepoint(savepoint);
    }

    public Savepoint setSavepoint()
        throws SQLException
    {
        return conn.setSavepoint();
    }

    public Savepoint setSavepoint(String name)
        throws SQLException
    {
        return conn.setSavepoint(name);
    }

    private DAOServices daoServices;
    private Connection conn;
}