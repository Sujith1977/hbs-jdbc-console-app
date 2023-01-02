package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HBSDatabaseConnectionParametersUtil {
	private final static String FILE_NAME = "db.config";
	private static final String DATABASE_URL = getDbProperties(FILE_NAME).getProperty("databaseUrl");
	private static final String USERNAME = getDbProperties(FILE_NAME).getProperty("userName");
	private static final String PASSWORD = getDbProperties(FILE_NAME).getProperty("password");
	
	private static Properties getDbProperties(String fileName) {
		Properties properties = new Properties();
		
		// Create the class loader for loading the class in the classpath
		ClassLoader HBSDbClassLoader = HBSDatabaseConnectionUtil.class.getClassLoader();
		
		// get the resource as an input stream
		InputStream inputStream = HBSDbClassLoader.getResourceAsStream(fileName);
		
		// load the input stream into the properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return the properties object		
		return properties;
	}

	public static String getDatabaseUrl() {
		return DATABASE_URL;
	}

	public static String getUsername() {
		return USERNAME;
	}

	public static String getPassword() {
		return PASSWORD;
	}
}
