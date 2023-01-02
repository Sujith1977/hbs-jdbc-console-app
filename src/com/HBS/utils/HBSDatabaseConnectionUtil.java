package com.HBS.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HBSDatabaseConnectionUtil implements IHBSDatabaseConnectionUtil {

	// start of getConnection method
	@Override
	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(HBSDatabaseConnectionParametersUtil.getDatabaseUrl(), HBSDatabaseConnectionParametersUtil.getUsername(), HBSDatabaseConnectionParametersUtil.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}// End of getConnnection method

}
