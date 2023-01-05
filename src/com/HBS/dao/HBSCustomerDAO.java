package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.HBS.dto.CustomerDTO;
import com.HBS.entities.Booking;
import com.HBS.entities.Customer;
import com.HBS.entities.Hotel;
import com.HBS.entities.Room;
import com.HBS.entities.Service;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSCustomerDAO implements IHBSCustomerDAO {
	static IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getBookingsOfACustomerInAHotel method
	@Override
	public CustomerDTO getBookingsOfACustomerInAHotel(long hotelID, long customerID) throws SQLException {
		String getBookingsQuery = "SELECT b.booking_id, b.room_id, b.booking_start_date, b.booking_vacate_date FROM booking b INNER JOIN customer c ON b.customer_id = c.customer_id WHERE c.customer_id = "
				+ customerID + " AND b.hotel_id = " + hotelID;
		CustomerDTO customerDTO = new CustomerDTO();
		List<Booking> bookings = new ArrayList<Booking>();
		Connection connection = null;

		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getBookingsQuery);
			Booking booking = new Booking();
			Room room = new Room();
			Hotel hotel = new Hotel();
			List<Customer> customers = new ArrayList<Customer>();
			while (resultSet.next()) {
				booking.setBooking_id(resultSet.getLong(1));
				room.setRoom_id(resultSet.getLong(2));
				booking.setRoom(room);
				Date bookingStartDate = resultSet.getDate(3);
				if (!resultSet.wasNull()) {
					booking.setBooking_start_date(bookingStartDate);
				} else {
					booking.setBooking_start_date(new Date(0));
				}

				Date bookingVacateDate = resultSet.getDate(4);
				if (!resultSet.wasNull()) {
					booking.setBooking_vacate_date(bookingVacateDate);
				} else {
					booking.setBooking_vacate_date(new Date(0));
				}
				bookings.add(booking);
			}

			String getHotelQuery = "SELECT hotel_name FROM Hotel WHERE hotel_id = " + hotelID;
			ResultSet rsHotel = statement.executeQuery(getHotelQuery);
			while (rsHotel.next()) {
				hotel.setHotel_id(hotelID);
				String hotelName = rsHotel.getString(1);
				if (!rsHotel.wasNull()) {
					hotel.setHotel_name(hotelName);
				} else {
					hotel.setHotel_name(" ");
				}
			}

			String getCustomerQuery = "SELECT customer_f_name, customer_l_name FROM Customer WHERE customer_id = "
					+ customerID;
			Customer customer = new Customer();
			ResultSet rsCustomer = statement.executeQuery(getCustomerQuery);
			if (rsCustomer.next()) {
				customer.setCustomer_id(customerID);
				String customerFirstName = rsCustomer.getString(1);
				if (!rsCustomer.wasNull()) {
					customer.setCustomer_f_name(customerFirstName);
				} else {
					customer.setCustomer_f_name(" ");
				}
				String customerLastName = rsCustomer.getString(2);
				if (!rsCustomer.wasNull()) {
					customer.setCustomer_l_name(customerLastName);
				} else {
					customer.setCustomer_l_name(" ");
				}
				
			} else {
				customer.setCustomer_id(0);
			}
			
			customers.add(customer);

			customerDTO.setBookings(bookings);
			customerDTO.setHotel(hotel);
			customerDTO.setCustomers(customers);

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
		return customerDTO;
	}
	// End of getBookingsOfACustomerInAHotel method

	// Start of getCustomersHavingLaundryServiceInBooking method
	@Override
	public CustomerDTO getCustomersHavingLaundryServiceInBooking(long serviceID) throws SQLException {
		String getCustomersQuery = "SELECT c.customer_id, c.customer_f_name, c.customer_l_name from customer c inner join booking b on c.customer_id = b.customer_id inner join booking_service bs on bs.booking_id = b.booking_id where bs.service_id = "
				+ serviceID;
		CustomerDTO customerDTO = new CustomerDTO();
		List<Customer> customers = new ArrayList<Customer>();
		Service service = new Service();
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rsCustomer = statement.executeQuery(getCustomersQuery);
			while (rsCustomer.next()) {
				Customer customer = new Customer();
				customer.setCustomer_id(rsCustomer.getInt(1));

				String customerFirstName = rsCustomer.getString(2);
				if (!rsCustomer.wasNull()) {
					customer.setCustomer_f_name(customerFirstName);
				} else {
					customer.setCustomer_f_name(" ");
				}

				String customerLastName = rsCustomer.getString(3);
				if (!rsCustomer.wasNull()) {
					customer.setCustomer_l_name(customerLastName);
				} else {
					customer.setCustomer_l_name(" ");
				}

				customers.add(customer);
			}

			String getServiceQuery = "SELECT service_type FROM Service WHERE service_id = " + serviceID;
			ResultSet rsService = statement.executeQuery(getServiceQuery);
			while (rsService.next()) {
				String serviceType = rsService.getString(1);
				if (!rsService.wasNull()) {
					service.setService_type(serviceType);
				} else {
					service.setService_type(" ");
				}
			}

			customerDTO.setCustomers(customers);
			customerDTO.setService(service);

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
		return customerDTO;
	}
}

// End of getCustomersHavingLaundryServiceInBooking method
