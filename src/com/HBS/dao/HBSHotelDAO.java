package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.HBS.entities.Customer;
import com.HBS.entities.Hotel;
import com.HBS.entities.Room;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSHotelDAO {
	static IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getCustomersOfAHotel method
	public static List<Customer> getCustomersOfAHotel(long hotelID) throws SQLException {
		String getCustomersQuery = "SELECT c.customer_id, c.customer_f_name, c.customer_l_name, c.customer_city, c.customer_state, c.customer_phone_no, c.customer_email_id FROM customer c INNER JOIN hotel_customer hc ON c.customer_id = hc.customer_id WHERE hc.hotel_id = "
				+ hotelID;
		List<Customer> customers = new ArrayList<Customer>();
		try (Connection connection = hbsDbConnectionUtil.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(getCustomersQuery);) {

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getLong(1));
				customer.setCustomer_f_name(resultSet.getString(2));
				customer.setCustomer_l_name(resultSet.getString(3));
				customer.setCustomer_city(resultSet.getString(4));
				customer.setCustomer_state(resultSet.getString(5));
				customer.setCustomer_phone_no(resultSet.getString(6));
				customer.setCustomer_email_id(resultSet.getString(7));
				customers.add(customer);
			}
		}
		return customers;
	} // End of getCustomersOfAHotel method
	
	// Start of getHotelsProvidingLaundryService method
		public static List<Hotel> getHotelsProvidingLaundryService(long serviceID) throws SQLException {
			String getHotelsQuery = "SELECT h.hotel_id, h.hotel_name, h.hotel_type, h.hotel_rating, h.hotel_desc, h.hotel_city, h.hotel_state, h.hotel_phone_no, h.hotel_email_id FROM hotel h INNER JOIN hotel_service hs ON h.hotel_id = hs.hotel_id WHERE hs.service_id = "
					+ serviceID;
			List<Hotel> hotels = new ArrayList<Hotel>();
			try (Connection connection = hbsDbConnectionUtil.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(getHotelsQuery);) {
				while (resultSet.next()) {
					Hotel hotel = new Hotel();
					hotel.setHotel_id(resultSet.getLong(1));
					hotel.setHotel_name(resultSet.getString(2));
					hotel.setHotel_type(resultSet.getString(3));
					hotel.setHotel_rating(resultSet.getString(4).charAt(0));
					hotel.setHotel_desc(resultSet.getString(5));
					hotel.setHotel_city(resultSet.getString(6));
					hotel.setHotel_state(resultSet.getString(7));
					hotel.setHotel_phone_no(resultSet.getString(8));
					hotel.setHotel_email_id(resultSet.getString(9));
					hotels.add(hotel);
				}
			}
			return hotels;
		} // End of getHotelsProvidingLaundryService method
		
		// Start of getRoomOfAHotelWithHighestBooking method
		public static List<Object> getRoomOfAHotelWithHighestBooking(long hotelID) throws SQLException {
			String getRoomQuery = "SELECT r.room_id, r.room_type, r.room_desc, count(r.room_id) noOfBookings FROM room r inner join booking b ON r.room_id = b.room_id WHERE b.hotel_id = " + hotelID + " GROUP BY r.room_id ORDER BY count(r.room_id) DESC LIMIT 1";
			Room room = new Room();
			int noOfBookings = 0;
			try (Connection connection = hbsDbConnectionUtil.getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(getRoomQuery);) {
				if (resultSet.next()) {				
					room.setRoom_id(resultSet.getLong(1));
					room.setRoom_type(resultSet.getString(2));
					room.setRoom_desc(resultSet.getString(3));
					noOfBookings = resultSet.getInt(4);
				}
			}
			return Arrays.asList(room, noOfBookings, hotelID);
		} // End of getRoomOfAHotelWithHighestBooking method
		
		// Start of getHotelWithHighestNumberOfCustomers method
				public static List<Object> getHotelWithHighestNumberOfCustomers() throws SQLException {
					String getHotelQuery = "SELECT h.hotel_id, h.hotel_name, count(hc.customer_id) noOfCustomers FROM hotel h INNER JOIN hotel_customer hc ON h.hotel_id = hc.hotel_id GROUP BY h.hotel_id ORDER BY count(hc.customer_id) desc limit 1";

					Hotel hotel = new Hotel();
					int noOfCustomers = 0;
					try (Connection connection = hbsDbConnectionUtil.getConnection();
							Statement statement = connection.createStatement();
							ResultSet resultSet = statement.executeQuery(getHotelQuery);) {
						while (resultSet.next()) {
							hotel.setHotel_id(resultSet.getLong(1));
							hotel.setHotel_name(resultSet.getString(2));
							noOfCustomers = resultSet.getInt(3);
						}
					}
					return Arrays.asList(hotel, noOfCustomers);

}
				// Start of getHotelHavingSecondHighestBooking method
				public static List<Object> getHotelHavingSecondHighestBooking() throws SQLException{
					Hotel hotel = new Hotel();
					int noOfBookings = 0;
					String getHotelQuery = "SELECT h.hotel_id, h.hotel_name, count(b.booking_id) totalBookings FROM booking b INNER JOIN hotel h ON b.hotel_id = h.hotel_id GROUP BY h.hotel_id ORDER BY count(b.booking_id) DESC LIMIT 1,1";
					
					try (Connection connection = hbsDbConnectionUtil.getConnection();
							Statement statement = connection.createStatement();
							ResultSet resultSet = statement.executeQuery(getHotelQuery);) {
						while (resultSet.next()) {
							hotel.setHotel_id(resultSet.getLong(1));
							hotel.setHotel_name(resultSet.getString(2));
							noOfBookings = resultSet.getInt(3);
						}
					}
					return Arrays.asList(hotel, noOfBookings);
					
				}
				// End of getHotelHavingSecondHighestBooking method
}
