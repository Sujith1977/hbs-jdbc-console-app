package com.HBS.utils;

import java.io.IOException;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

//this class supplies objects of type HBSDatabaseConnectionUtil through getDB() method
public class DatabaseConnectionFactory {

	// this method creates an object of type IHBSDatabaseConnectionUtil
	public static IHBSDatabaseConnectionUtil getDB() {
		IHBSDatabaseConnectionUtil dbConnectionUtil = null;
		Class<?> dbClass = null;
		String dbConnectionObjectName = getDbConnectionObjectName();

		// Create class from class name of HBSDatabaseConnectionUtil using Class.forName
		try {
			dbClass = Class.forName(dbConnectionObjectName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Create an instance of the above created class using newInstance method
		try {
			dbConnectionUtil = (IHBSDatabaseConnectionUtil) dbClass.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		// return the instance
		return dbConnectionUtil;
	}

	private static String getDbConnectionObjectName() {
		String dbConnectionObjectName = null;

		// Create a properties object
		Properties properties = new Properties();

		// Create the class loader for loading the class in the classpath
		ClassLoader DBClassLoader = DatabaseConnectionFactory.class.getClassLoader();

		// get the resource as an inputstream
		InputStream inputStream = DBClassLoader.getResourceAsStream("dbConnectionObject.config");

		// load the inputstream into the properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the property value
		dbConnectionObjectName = properties.getProperty("connectionObject");

		// return the property value
		return dbConnectionObjectName;
	}

}
