package com.HBS.app;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.HBS.dao.HBSCustomerDAO;
import com.HBS.dao.HBSEmployeeDAO;
import com.HBS.dao.HBSHotelDAO;
import com.HBS.entities.Booking;
import com.HBS.entities.Customer;
import com.HBS.entities.Employee;
import com.HBS.entities.Hotel;
import com.HBS.entities.Room;

public class HBSAppMain {
	public static void main(String[] args) {
		testGetCustomersOfAHotel();
		testGetHotelsProvidingLaundryService();
		testGetRoomOfAHotelWithHighestBooking();
		testGetBookingsOfACustomerInAHotel();
		testGetHotelWithHighestNumberOfCustomers();
		testGetCustomersHavingLaundryServiceInBooking();
		testGetEmployeeWithHighestBookingInAHotel();
		testGetHotelHavingSecondHighestBooking();
	}

	// Start of testGetCustomersOfAHotel method
	private static void testGetCustomersOfAHotel() {
		try {
			List<Customer> customers = HBSHotelDAO.getCustomersOfAHotel(1);
			long index = 0;
			System.out.println("Total number of existing customers in the given hotel: " + customers.size());
			System.out.println("----------------------------------");
			for (Customer c : customers) {
				index++;
				System.out.println("Customer Record " + index);
				System.out.println("\t" + "id: " + c.getCustomer_id());
				System.out.println("\t" + "first name: " + c.getCustomer_f_name());
				System.out.println("\t" + "last name: " + c.getCustomer_l_name());
				System.out.println("\t" + "city: " + c.getCustomer_city());
				System.out.println("\t" + "state: " + c.getCustomer_state());
				System.out.println("\t" + "phone no: " + c.getCustomer_phone_no());
				System.out.println("\t" + "email id: " + c.getCustomer_email_id());
				System.out.println("----------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetCustomersOfAHotel method

	// Start of testGetHotelsProvidingLaundryService method
	private static void testGetHotelsProvidingLaundryService() {
		try {
			List<Hotel> hotels = HBSHotelDAO.getHotelsProvidingLaundryService(201);
			long index = 0;
			System.out.println("Total number of hotels currently providing laundry service: " + hotels.size());
			System.out.println("----------------------------------");
			for (Hotel h : hotels) {
				index++;
				System.out.println("Hotel Record " + index);
				System.out.println("\t" + "id: " + h.getHotel_id());
				System.out.println("\t" + "name: " + h.getHotel_name());
				System.out.println("\t" + "type: " + h.getHotel_type());
				System.out.println("\t" + "rating: " + h.getHotel_rating());
				System.out.println("\t" + "description: " + h.getHotel_desc());
				System.out.println("\t" + "city: " + h.getHotel_city());
				System.out.println("\t" + "state: " + h.getHotel_state());
				System.out.println("\t" + "phone no: " + h.getHotel_phone_no());
				System.out.println("\t" + "state: " + h.getHotel_email_id());
				System.out.println("----------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetHotelsProvidingLaundryService method

	// Start of testGetRoomOfAHotelWithHighestBooking method
	private static void testGetRoomOfAHotelWithHighestBooking() {
		try {
			List<Object> roomInfo = HBSHotelDAO.getRoomOfAHotelWithHighestBooking(1);
			Room room = (Room) roomInfo.get(0);
			int noOfBookings = (int) roomInfo.get(1);
			long roomHotelID = (long) roomInfo.get(2);
			System.out
					.println("Details of room with highest number of bookings in the specified hotel is given below:");
			System.out.println("----------------------------------");
			System.out.println("room id: " + room.getRoom_id());
			System.out.println("hotel id: " + roomHotelID);
			System.out.println("type: " + room.getRoom_type());
			System.out.println("description: " + room.getRoom_desc());
			System.out.println("total no of bookings: " + noOfBookings);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetRoomOfAHotelWithHighestBooking method

	// Start of testGetBookingsOfACustomerInAHotel method
	private static void testGetBookingsOfACustomerInAHotel() {
		try {
			List<Object> bookingInfo = HBSCustomerDAO.getBookingsOfACustomerInAHotel(1, 301);
			List<Booking> bookings = (List<Booking>) bookingInfo.get(0);
			long bookingHotelID = (long) bookingInfo.get(1);
			long bookingCustomerID = (long) bookingInfo.get(2);
			int index = 0;
			System.out.println("Total number of bookings made by the given customer in the specified hotel is: "
					+ bookings.size());
			System.out.println("----------------------------------");
			System.out.println("hotel ID: " + bookingHotelID);
			System.out.println("customer ID: " + bookingCustomerID);
			System.out.println("----------------------------------");
			for (Booking b : bookings) {
				index++;
				System.out.println("Booking Record " + index);
				System.out.println("\t" + "booking id: " + b.getBooking_id());
				System.out.println("\t" + "room id: " + b.getRoom().getRoom_id());
				System.out.println("\t" + "booking start date: " + b.getBooking_start_date());
				System.out.println("\t" + "booking vacate date: " + b.getBooking_vacate_date());
				System.out.println("----------------------------------");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetBookingsOfACustomerInAHotel method

	// Start of testGetHotelWithHighestNumberOfCustomers method
	private static void testGetHotelWithHighestNumberOfCustomers() {
		try {
			List<Object> hotelInfo = HBSHotelDAO.getHotelWithHighestNumberOfCustomers();
			Hotel hotel = (Hotel) hotelInfo.get(0);
			int noOfCustomers = (int) hotelInfo.get(1);
			System.out.println("Details of hotel with highest number of customers is given below:");
			System.out.println("----------------------------------");
			System.out.println("hotel id: " + hotel.getHotel_id());
			System.out.println("hotel name: " + hotel.getHotel_name());
			System.out.println("total no of customers: " + noOfCustomers);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetHotelWithHighestNumberOfCustomers method

	// Start of testGetCustomersHavingLaundryServiceInBooking method
	private static void testGetCustomersHavingLaundryServiceInBooking() {

		try {
			List<Customer> customers = HBSCustomerDAO.getCustomersHavingLaundryServiceInBooking(201);
			long index = 0;
			System.out.println("Total no of customers having laundry service in booking is: " + customers.size());
			System.out.println("----------------------------------");
			for (Customer c : customers) {
				index++;
				System.out.println("Customer Record " + index);
				System.out.println("\t" + "id: " + c.getCustomer_id());
				System.out.println("\t" + "first name: " + c.getCustomer_f_name());
				System.out.println("\t" + "last name: " + c.getCustomer_l_name());
				System.out.println("----------------------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// End of testGetCustomersHavingLaundryServiceInBooking method

	// Start of testGetEmployeeWithHighestBookingInAHotel method
	private static void testGetEmployeeWithHighestBookingInAHotel() {

		try {
			List<Object> employeeInfo = HBSEmployeeDAO.getEmployeeWithHighestBookingInAHotel(1);
			Employee employee = (Employee) employeeInfo.get(0);
			long hotelID = (long) employeeInfo.get(1);
			int noOfBookings = (int) employeeInfo.get(2);
			System.out.println(
					"Details of the employee with highest number of bookings in the specified hotel is given below:");
			System.out.println("----------------------------------");
			System.out.println("given hotel id is: " + hotelID);
			System.out.println("\t" + "employee id: " + employee.getSsn());
			System.out.println("\t" + "employee first name: " + employee.getEmployee_f_name());
			System.out.println("\t" + "employee last name: " + employee.getEmployee_l_name());
			System.out.println("\t" + "total no of bookings taken: " + noOfBookings);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// End of testGetEmployeeWithHighestBookingInAHotel method

	// Start of getHotelHavingSecondHighestBooking method
	private static void testGetHotelHavingSecondHighestBooking() {
		try {
			List<Object> hotelInfo = HBSHotelDAO.getHotelHavingSecondHighestBooking();
			Hotel hotel = (Hotel) hotelInfo.get(0);
			int noOfBookings = (int) hotelInfo.get(1);
			System.out.println("Details of hotel with second highest number of bookings is given below:");
			System.out.println("----------------------------------");
			System.out.println("hotel id: " + hotel.getHotel_id());
			System.out.println("hotel name: " + hotel.getHotel_name());
			System.out.println("total no of bookings: " + noOfBookings);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	// End of getHotelHavingSecondHighestBooking method
}
