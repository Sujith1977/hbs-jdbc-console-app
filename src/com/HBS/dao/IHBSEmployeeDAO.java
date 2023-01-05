package com.HBS.dao;

import java.sql.SQLException;

import com.HBS.dto.EmployeeDTO;

public interface IHBSEmployeeDAO {

	// Start of getEmployeeWithHighestBookingInAHotel method
	EmployeeDTO getEmployeeWithHighestBookingInAHotel(long hotelID) throws SQLException;
	// End of getEmployeeWithHighestBookingInAHotel method

}