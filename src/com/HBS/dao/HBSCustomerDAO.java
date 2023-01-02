package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.HBS.entities.Booking;
import com.HBS.entities.Customer;
import com.HBS.entities.Room;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSCustomerDAO {
	static IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getBookingsOfACustomerInAHotel method
	public static List<Object> getBookingsOfACustomerInAHotel(long hotelID, long customerID) throws SQLException {
		String getBookingsQuery = "SELECT b.booking_id, b.room_id, b.booking_start_date, b.booking_vacate_date FROM booking b INNER JOIN customer c ON b.customer_id = c.customer_id WHERE c.customer_id = "
				+ customerID + " AND b.hotel_id = " + hotelID;
		long roomID = 0;
		List<Booking> bookings = new ArrayList<Booking>();
		try (Connection connection = hbsDbConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(getBookingsQuery);) {
			while (resultSet.next()) {
				Booking booking = new Booking();
				Room room = new Room();
				booking.setBooking_id(resultSet.getLong(1));
				room.setRoom_id(resultSet.getLong(2));
				booking.setRoom(room);
				booking.setBooking_start_date(resultSet.getDate(3));
				booking.setBooking_vacate_date(resultSet.getDate(4));
				bookings.add(booking);
			}
		}
		return Arrays.asList(bookings, hotelID, customerID, roomID);
	}
	// End of getBookingsOfACustomerInAHotel method
	
	// Start of getCustomersHavingLaundryServiceInBooking method
		public static List<Customer> getCustomersHavingLaundryServiceInBooking(long serviceID) throws SQLException {
			String getCustomersQuery = "SELECT c.customer_id, c.customer_f_name, c.customer_l_name from customer c inner join booking b on c.customer_id = b.customer_id inner join booking_service bs on bs.booking_id = b.booking_id where bs.service_id = " + serviceID;
			List<Customer> customers = new ArrayList<Customer>();
			try (Connection connection = hbsDbConnectionUtil.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(getCustomersQuery);) {
				while (resultSet.next()) {
					Customer customer = new Customer();
					customer.setCustomer_id(resultSet.getInt(1));
					customer.setCustomer_f_name(resultSet.getString(2));
					customer.setCustomer_l_name(resultSet.getString(3));
					customers.add(customer);
				}
			}
			return customers;
		}
		// End of getCustomersHavingLaundryServiceInBooking method
	
}
