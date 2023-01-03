package com.HBS.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

public interface IHBSDatabaseConnectionUtil {

	Connection getConnection() throws SQLTimeoutException, SQLException;

}