// Decompiled by DJ v3.7.7.81 Copyright 2004 Atanas Neshkov  Date: 12/15/2015 4:05:06 PM
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   DAOServicesFactory.java

package com.sanstha.sahyog.ca.fea.daoservices;

import javax.sql.DataSource;

import com.sanstha.sahyog.ca.fea.daoservices.impl.DefaultDAOServices;

// Referenced classes of package com.cisco.ca.fea.daoservices:
//            DAOServices

public class DAOServicesFactory
{

    public DAOServicesFactory()
    {
    }

    public static DAOServices create(DataSource ds)
    {
        return new DefaultDAOServices(ds);
    }
}