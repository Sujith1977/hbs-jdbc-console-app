package com.HBS.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.HBS.dao.IHBSEmployeeDAO;

public class HBSEmployeeDAOFactory {

	public static IHBSEmployeeDAO getHBSEmployeeDAO() {

		IHBSEmployeeDAO hbsEmployeeDAO = null;
		Class<?> EmployeeDAOClass = null;
		String employeeDAOObjectName = createHBSEmployeeDAO();
		// access the class using Class.forName() method
		try {
			EmployeeDAOClass = Class.forName(employeeDAOObjectName);
		} catch (LinkageError e) {
			System.out.println("Dependency on HBSEmployeeDAO class not resolvable");
			e.getMessage();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be located");
			e.getMessage();
			e.printStackTrace();
		}
		// create an object of HBSEmployeeDAO using the newInstance method
		try {
			hbsEmployeeDAO = (IHBSEmployeeDAO) EmployeeDAOClass.getDeclaredConstructor().newInstance();
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
		// return the object

		return hbsEmployeeDAO;
	}

	private static String createHBSEmployeeDAO() {
		String employeeDAOObjectName = null;

		// Create a properties object
		Properties properties = new Properties();

		// Create the class loader for loading the class in the class path
		ClassLoader HBSEmployeeDAOClassLoader = HBSEmployeeDAOFactory.class.getClassLoader();

		// get the resource as an input stream
		InputStream inputStream = HBSEmployeeDAOClassLoader.getResourceAsStream("dao.config");

		// load the input stream into the properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the property value
		employeeDAOObjectName = properties.getProperty("employeeDAO");

		// return the property value
		return employeeDAOObjectName;
	}

}
