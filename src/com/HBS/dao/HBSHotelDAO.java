package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.HBS.dto.HotelDTO;
import com.HBS.dto.RoomDTO;
import com.HBS.entities.Customer;
import com.HBS.entities.Hotel;
import com.HBS.entities.Room;
import com.HBS.entities.Service;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSHotelDAO implements IHBSHotelDAO {

	IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getCustomersOfAHotel method
	@Override
	public List<Customer> getCustomersOfAHotel(long hotelID) throws SQLException {
		String getCustomersQuery = "SELECT c.customer_id, c.customer_f_name, c.customer_l_name, c.customer_city, c.customer_state, c.customer_phone_no, c.customer_email_id FROM customer c INNER JOIN hotel_customer hc ON c.customer_id = hc.customer_id WHERE hc.hotel_id = "
				+ hotelID;
		List<Customer> customers = new ArrayList<Customer>();
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getCustomersQuery);

			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(resultSet.getLong(1));

				String customerFirstName = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					customer.setCustomer_f_name(customerFirstName);
				} else {
					customer.setCustomer_f_name(" ");
				}

				String customerLastName = resultSet.getString(3);
				if (!resultSet.wasNull()) {
					customer.setCustomer_l_name(customerLastName);
				} else {
					customer.setCustomer_l_name(" ");
				}

				String customerCity = resultSet.getString(4);
				if (!resultSet.wasNull()) {
					customer.setCustomer_city(customerCity);
				} else {
					customer.setCustomer_city(" ");
				}

				String customerState = resultSet.getString(5);
				if (!resultSet.wasNull()) {
					customer.setCustomer_state(customerState);
				} else {
					customer.setCustomer_state(" ");
				}

				String customerPhoneNo = resultSet.getString(6);
				if (!resultSet.wasNull()) {
					customer.setCustomer_phone_no(customerPhoneNo);
				} else {
					customer.setCustomer_phone_no(" ");
				}

				String customerEmailId = resultSet.getString(7);
				if (!resultSet.wasNull()) {
					customer.setCustomer_email_id(customerEmailId);
				} else {
					customer.setCustomer_email_id(" ");
				}
				customers.add(customer);
			}
		} catch (SQLTimeoutException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("timeout value exceeded ");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("database access error or the url is null");
		} finally {
			connection.close();
		}

		return customers;

	} // End of getCustomersOfAHotel method

	// Start of getHotelsProvidingLaundryService method
	@Override
	public HotelDTO getHotelsProvidingLaundryService(long serviceID) throws SQLException {
		String getHotelsQuery = "SELECT h.hotel_id, h.hotel_name, h.hotel_type, h.hotel_rating, h.hotel_desc, h.hotel_city, h.hotel_state, h.hotel_phone_no, h.hotel_email_id FROM hotel h INNER JOIN hotel_service hs ON h.hotel_id = hs.hotel_id WHERE hs.service_id = "
				+ serviceID;

		List<Hotel> hotels = new ArrayList<Hotel>();
		HotelDTO hotelDTO = new HotelDTO();
		Service service = new Service();
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getHotelsQuery);

			while (resultSet.next()) {
				Hotel hotel = new Hotel();

				hotel.setHotel_id(resultSet.getLong(1));

				String hotelName = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					hotel.setHotel_name(hotelName);
				} else {
					hotel.setHotel_name(" ");
				}

				String hotelType = resultSet.getString(3);
				if (!resultSet.wasNull()) {
					hotel.setHotel_type(hotelType);
				} else {
					hotel.setHotel_type(" ");
				}

				char hotelRating = resultSet.getString(4).charAt(0);
				if (!resultSet.wasNull()) {
					hotel.setHotel_rating(hotelRating);
				} else {
					hotel.setHotel_rating(' ');
				}

				String hotelDesc = resultSet.getString(5);
				if (!resultSet.wasNull()) {
					hotel.setHotel_desc(hotelDesc);
				} else {
					hotel.setHotel_desc(" ");
				}

				String hotelCity = resultSet.getString(6);
				if (!resultSet.wasNull()) {
					hotel.setHotel_city(hotelCity);
				} else {
					hotel.setHotel_city(" ");
				}

				String hotelState = resultSet.getString(7);
				if (!resultSet.wasNull()) {
					hotel.setHotel_state(hotelState);
				} else {
					hotel.setHotel_state(" ");
				}

				String hotelPhoneNo = resultSet.getString(8);
				if (!resultSet.wasNull()) {
					hotel.setHotel_phone_no(hotelPhoneNo);
				} else {
					hotel.setHotel_phone_no(" ");
				}

				String hotelEmailId = resultSet.getString(9);
				if (!resultSet.wasNull()) {
					hotel.setHotel_email_id(hotelEmailId);
				} else {
					hotel.setHotel_email_id(" ");
				}

				hotels.add(hotel);
			}
			String getServiceTypequery = "SELECT service_type FROM Service WHERE service_id = " + serviceID;
			ResultSet rs = statement.executeQuery(getServiceTypequery);
			if (rs.next()) {
				String serviceType = rs.getString(1);
				if (!rs.wasNull()) {
					service.setService_type(serviceType);
				} else {
					service.setService_type(" ");
				}
			}

		} catch (SQLTimeoutException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("timeout value exceeded ");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("database access error or the url is null");
		} finally {
			connection.close();
		}
		hotelDTO.setHotels(hotels);
		hotelDTO.setService(service);
		return hotelDTO;
	} // End of getHotelsProvidingLaundryService method

	// Start of getRoomOfAHotelWithHighestBooking method
	@Override
	public RoomDTO getRoomOfAHotelWithHighestBooking(long hotelID) throws SQLException {
		String getRoomQuery = "SELECT r.room_id, r.room_type, r.room_desc, count(r.room_id) noOfBookings FROM room r inner join booking b ON r.room_id = b.room_id WHERE b.hotel_id = "
				+ hotelID + " GROUP BY r.room_id ORDER BY count(r.room_id) DESC LIMIT 1";
		Room room = new Room();
		Hotel hotel = new Hotel();
		RoomDTO roomDTO = new RoomDTO();
		int noOfBookings = 0;
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getRoomQuery);

			if (resultSet.next()) {
				room.setRoom_id(resultSet.getLong(1));

				String roomType = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					room.setRoom_type(roomType);
				} else {
					room.setRoom_type(" ");
				}

				String roomDesc = resultSet.getString(3);
				if (!resultSet.wasNull()) {
					room.setRoom_desc(roomDesc);
				} else {
					room.setRoom_desc(" ");
				}

				noOfBookings = resultSet.getInt(4);
				if (resultSet.wasNull()) {
					noOfBookings = 0;
				}

				hotel.setHotel_id(hotelID);

				String getHotelNamequery = "SELECT hotel_name FROM Hotel WHERE hotel_id = " + hotelID;
				ResultSet rs = statement.executeQuery(getHotelNamequery);
				if (rs.next()) {
					String hotelName = rs.getString(1);
					if (!rs.wasNull()) {
						hotel.setHotel_name(hotelName);
					} else {
						hotel.setHotel_name(" ");
					}
				}				
			}

			roomDTO.setRoom(room);
			roomDTO.setNoOfBookings(noOfBookings);
			roomDTO.setHotel(hotel);

		} catch (SQLTimeoutException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("timeout value exceeded ");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("database access error or the url is null");
		} finally {
			connection.close();
		}

		return roomDTO;
	} // End of getRoomOfAHotelWithHighestBooking method

	// Start of getHotelWithHighestNumberOfCustomers method
	@Override
	public HotelDTO getHotelWithHighestNumberOfCustomers() throws SQLException {
		String getHotelQuery = "SELECT h.hotel_id, h.hotel_name, count(hc.customer_id) noOfCustomers FROM hotel h INNER JOIN hotel_customer hc ON h.hotel_id = hc.hotel_id GROUP BY h.hotel_id ORDER BY count(hc.customer_id) desc limit 1";

		Hotel hotel = new Hotel();
		List<Hotel> hotels = new ArrayList<Hotel>();
		HotelDTO hotelDTO = new HotelDTO();
		int noOfCustomers = 0;
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getHotelQuery);
		
			while (resultSet.next()) {
				
				hotel.setHotel_id(resultSet.getLong(1));
				
				String hotelName = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					hotel.setHotel_name(hotelName);
				}
				else {
					hotel.setHotel_name(" ");
				}
				
				noOfCustomers = resultSet.getInt(3);
				if (resultSet.wasNull()) {
					noOfCustomers = 0;
				}
			}
			hotels.add(hotel);
			hotelDTO.setHotels(hotels);
			hotelDTO.setNoOfCustomers(noOfCustomers);
		} catch (SQLTimeoutException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("timeout value exceeded ");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("database access error or the url is null");
		} finally {
			connection.close();
		}
		return hotelDTO;

	}

	// Start of getHotelHavingSecondHighestBooking method
	@Override
	public HotelDTO getHotelHavingSecondHighestBooking() throws SQLException {
		
		String getHotelQuery = "SELECT h.hotel_id, h.hotel_name, count(b.booking_id) totalBookings FROM booking b INNER JOIN hotel h ON b.hotel_id = h.hotel_id GROUP BY h.hotel_id ORDER BY count(b.booking_id) DESC LIMIT 1,1";
		HotelDTO hotelDTO = new HotelDTO();
		Hotel hotel = new Hotel();		
		List<Hotel> hotels = new ArrayList<Hotel>();
		int noOfBookings = 0;
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getHotelQuery);
			while (resultSet.next()) {
				hotel.setHotel_id(resultSet.getLong(1));
				
				String hotelName = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					hotel.setHotel_name(hotelName);
				}
				else {
					hotel.setHotel_name(" ");
				}
				
				noOfBookings = resultSet.getInt(3);
				if (resultSet.wasNull()) {
					noOfBookings = 0;
				}
			}
			hotels.add(hotel);
			hotelDTO.setHotels(hotels);
			hotelDTO.setNoOfBookings(noOfBookings);
		} catch (SQLTimeoutException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("timeout value exceeded ");
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println("database access error or the url is null");
		} finally {
			connection.close();
		}
		return hotelDTO;

	}
	// End of getHotelHavingSecondHighestBooking method
}
