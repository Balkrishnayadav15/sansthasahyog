// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:05:36 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DAOTransactionFactory.java

package com.sanstha.sahyog.ca.fea.daoservices;

import javax.sql.DataSource;

import com.sanstha.sahyog.ca.fea.daoservices.impl.DefaultDAOTransaction;

// Referenced classes of package com.cisco.ca.fea.daoservices:
//            DAOServicesFactory, DAOTransaction

public class DAOTransactionFactory
{

    public DAOTransactionFactory()
    {
    }

    public static DAOTransaction create(DataSource ds)
    {
        return new DefaultDAOTransaction(DAOServicesFactory.create(ds));
    }
}