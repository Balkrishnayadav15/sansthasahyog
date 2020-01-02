
package com.sanstha.sahyog.ca.fea.daoservices;

import java.sql.Connection;
import java.sql.SQLException;

public interface DAOServices
{

    public abstract Connection borrowConnection()
        throws SQLException;

    public abstract void returnConnection(Connection connection);

    public abstract Connection getNativeConnection(Connection connection);
}