package com.HBS.utils;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public class HBSDatabaseConnectionUtil implements IHBSDatabaseConnectionUtil {

	// start of getConnection method
	@Override
	public Connection getConnection() throws SQLTimeoutException, SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(HBSDatabaseConnectionParametersUtil.getDatabaseUrl(), HBSDatabaseConnectionParametersUtil.getUsername(), HBSDatabaseConnectionParametersUtil.getPassword());
		 
		return connection;
	}// End of getConnnection method

}
