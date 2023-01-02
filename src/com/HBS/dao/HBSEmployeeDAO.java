package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.HBS.entities.Booking;
import com.HBS.entities.Employee;
import com.HBS.entities.Room;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSEmployeeDAO {
	static IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getEmployeeWithHighestBookingInAHotel method
	public static List<Object> getEmployeeWithHighestBookingInAHotel(long hotelID) throws SQLException {
		String getEmployeeQuery = "SELECT e.ssn, e.employee_f_name, e.employee_l_name, count(b.booking_id) noOfBookings FROM employee e INNER JOIN booking b ON e.ssn = b.ssn WHERE b.hotel_id = " + hotelID + "  GROUP BY e.employee_f_name, e.employee_l_name ORDER BY count(b.booking_id) DESC LIMIT 1"; 

		Employee employee = new Employee();
		int noOfBookings = 0;
		try (Connection connection = hbsDbConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(getEmployeeQuery);) {
			while (resultSet.next()) {
				employee.setSsn(resultSet.getLong(1));
				employee.setEmployee_f_name(resultSet.getString(2));
				employee.setEmployee_l_name(resultSet.getString(3));
				noOfBookings = resultSet.getInt(4);
			}
		}
		return Arrays.asList(employee, hotelID, noOfBookings);

	}
	// End of getEmployeeWithHighestBookingInAHotel method
}
