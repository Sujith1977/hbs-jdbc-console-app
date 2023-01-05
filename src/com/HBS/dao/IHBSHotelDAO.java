package com.HBS.dao;

import java.sql.SQLException;
import java.util.List;

import com.HBS.dto.CustomerDTO;
import com.HBS.dto.HotelDTO;
import com.HBS.dto.RoomDTO;
import com.HBS.entities.Customer;
import com.HBS.entities.Hotel;

public interface IHBSHotelDAO {

	// Start of getCustomersOfAHotel method
	CustomerDTO getCustomersOfAHotel(long hotelID) throws SQLException; // End of getCustomersOfAHotel method

	// Start of getHotelsProvidingLaundryService method
	HotelDTO getHotelsProvidingLaundryService(long serviceID) throws SQLException; // End of getHotelsProvidingLaundryService method

	// Start of getRoomOfAHotelWithHighestBooking method
	RoomDTO getRoomOfAHotelWithHighestBooking(long hotelID) throws SQLException; // End of getRoomOfAHotelWithHighestBooking method

	// Start of getHotelWithHighestNumberOfCustomers method
	HotelDTO getHotelWithHighestNumberOfCustomers() throws SQLException;

	// Start of getHotelHavingSecondHighestBooking method
	HotelDTO getHotelHavingSecondHighestBooking() throws SQLException;
	// End of getHotelHavingSecondHighestBooking method

}