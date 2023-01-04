package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.HBS.dao.IHBSCustomerDAO;

public class HBSCustomerDAOFactory {

	public static IHBSCustomerDAO getHBSCustomerDAO() {

		IHBSCustomerDAO hbsCustomerDAO = null;
		Class<?> CustomerDAOClass = null;
		String customerDAOObjectName = createHBSCustomerDAO();
		// access the class using Class.forName() method
		try {
			CustomerDAOClass = Class.forName(customerDAOObjectName);
		} catch (LinkageError e) {
			System.out.println("Dependency on HBSCustomerDAO class not resolvable");
			e.getMessage();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be located");
			e.getMessage();
			e.printStackTrace();
		}
		// create an object of HBSCustomerDAO using the newInstance method
		try {
			hbsCustomerDAO = (IHBSCustomerDAO) CustomerDAOClass.getDeclaredConstructor().newInstance();
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

		return hbsCustomerDAO;
	}

	private static String createHBSCustomerDAO() {
		String customerDAOObjectName = null;

		// Create a properties object
		Properties properties = new Properties();

		// Create the class loader for loading the class in the class path
		ClassLoader HBSCustomerDAOClassLoader = HBSCustomerDAOFactory.class.getClassLoader();

		// get the resource as an input stream
		InputStream inputStream = HBSCustomerDAOClassLoader.getResourceAsStream("dao.config");

		// load the input stream into the properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the property value
		customerDAOObjectName = properties.getProperty("customerDAO");

		// return the property value
		return customerDAOObjectName;
	}
}
