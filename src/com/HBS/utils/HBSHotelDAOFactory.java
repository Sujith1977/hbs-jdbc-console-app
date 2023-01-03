package com.HBS.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import com.HBS.dao.IHBSHotelDAO;

public class HBSHotelDAOFactory {
	public static IHBSHotelDAO getHBSHotelDAO() {
		IHBSHotelDAO hbsHotelDAO = null;
		Class<?> HotelDAOClass = null;
		String hotelDAOObjectName = createHBSHotelDAO();
		// access the class using Class.forName() method
		try {
			HotelDAOClass = Class.forName(hotelDAOObjectName);
		} catch (LinkageError e) {
			System.out.println("Dependency on HBSHotelDAO class not resolvable");
			e.getMessage();
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Class cannot be located");
			e.getMessage();
			e.printStackTrace();
		}
		// create an object of HBSHotelDAO using the newInstance method
		try {
			hbsHotelDAO = (IHBSHotelDAO) HotelDAOClass.getDeclaredConstructor().newInstance();
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

		return hbsHotelDAO;
	}

	private static String createHBSHotelDAO() {
		String hotelDAOObjectName = null;

		// Create a properties object
		Properties properties = new Properties();

		// Create the class loader for loading the class in the class path
		ClassLoader HBSHotelDAOClassLoader = HBSHotelDAOFactory.class.getClassLoader();

		// get the resource as an input stream
		InputStream inputStream = HBSHotelDAOClassLoader.getResourceAsStream("dao.config");

		// load the input stream into the properties
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the property value
		hotelDAOObjectName = properties.getProperty("hotelDAO");

		// return the property value
		return hotelDAOObjectName;
	}

}
