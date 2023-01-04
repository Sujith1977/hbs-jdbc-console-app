package com.HBS.dao;

import java.sql.SQLException;

import com.HBS.dto.CustomerDTO;

public interface IHBSCustomerDAO {

	// Start of getBookingsOfACustomerInAHotel method
	CustomerDTO getBookingsOfACustomerInAHotel(long hotelID, long customerID) throws SQLException;
	// End of getBookingsOfACustomerInAHotel method

	// Start of getCustomersHavingLaundryServiceInBooking method
	CustomerDTO getCustomersHavingLaundryServiceInBooking(long serviceID) throws SQLException;
	// End of getCustomersHavingLaundryServiceInBooking method

}