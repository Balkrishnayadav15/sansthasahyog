// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:05:21 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DAOTransaction.java

package com.sanstha.sahyog.ca.fea.daoservices;

import java.sql.SQLException;
import java.sql.Savepoint;

// Referenced classes of package com.cisco.ca.fea.daoservices:
//            DAOServices

public interface DAOTransaction
    extends DAOServices
{

    public abstract void beginTransaction()
        throws SQLException;

    public abstract void commit()
        throws SQLException;

    public abstract void rollback()
        throws SQLException;

    public abstract void rollback(Savepoint savepoint)
        throws SQLException;

    public abstract void releaseSavepoint(Savepoint savepoint)
        throws SQLException;

    public abstract Savepoint setSavepoint()
        throws SQLException;

    public abstract Savepoint setSavepoint(String s)
        throws SQLException;

    public abstract void endTransaction()
        throws SQLException;
}