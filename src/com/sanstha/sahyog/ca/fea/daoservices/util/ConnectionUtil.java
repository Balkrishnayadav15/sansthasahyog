// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:03:03 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ConnectionUtil.java

package com.sanstha.sahyog.ca.fea.daoservices.util;

import java.io.PrintStream;
import java.sql.*;
import oracle.jdbc.driver.OracleConnection;
import org.apache.log4j.Logger;

public class ConnectionUtil
{

    public ConnectionUtil()
    {
    }

    public static void close(ResultSet rset)
        throws SQLException
    {
        if(rset != null)
            rset.close();
    }

    public static void closeQuietly(ResultSet rset)
    {
        try
        {
            close(rset);
        }
        catch(SQLException sqlexception) { }
    }

    public static void close(Statement stmt)
        throws SQLException
    {
        if(stmt != null)
            stmt.close();
    }

    public static void closeQuietly(Statement stmt)
    {
        try
        {
            close(stmt);
        }
        catch(SQLException sqlexception) { }
    }

    public static void close(Connection conn)
        throws SQLException
    {
        if(conn != null)
            if(!(conn instanceof OracleConnection))
            {
                if(conn != null)
                    conn.close();
                cLogger.debug("Connection returned to pool");
            } else
            {
                throw new SQLException("You should NOT pass a native connection to the returnConnection method!");
            }
    }

    public static void closeQuietly(Connection conn)
    {
        try
        {
            close(conn);
        }
        catch(SQLException sqlexception) { }
    }

    public static void close(Connection conn, Statement stmt, ResultSet rset)
        throws SQLException
    {
        SQLException exception = null;
        try
        {
            close(rset);
        }
        catch(SQLException e)
        {
            exception = e;
        }
        try
        {
            close(stmt);
        }
        catch(SQLException e)
        {
            if(exception == null)
                exception = e;
            else
                exception.setNextException(e);
        }
        try
        {
            close(conn);
        }
        catch(SQLException e)
        {
            if(exception == null)
                exception = e;
            else
                exception.setNextException(e);
        }
        if(exception != null)
            throw exception;
        else
            return;
    }

    public static void closeQuietly(Connection conn, Statement stmt, ResultSet rset)
    {
        closeQuietly(rset);
        closeQuietly(stmt);
        closeQuietly(conn);
    }

    public static void printStackTraceWithNested(SQLException e)
    {
        e.printStackTrace();
        if(e.getNextException() != null)
        {
            System.err.println("Next SQLException:");
            printStackTraceWithNested(e.getNextException());
        }
    }

    private static Logger cLogger = Logger.getLogger(ConnectionUtil.class);

}