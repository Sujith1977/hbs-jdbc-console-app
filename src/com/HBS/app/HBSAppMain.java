package com.HBS.app;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.HBS.dao.IHBSCustomerDAO;
import com.HBS.dao.IHBSEmployeeDAO;
import com.HBS.dao.IHBSHotelDAO;
import com.HBS.dto.CustomerDTO;
import com.HBS.dto.EmployeeDTO;
import com.HBS.dto.HotelDTO;
import com.HBS.dto.RoomDTO;
import com.HBS.entities.Booking;
import com.HBS.entities.Customer;
import com.HBS.entities.Employee;
import com.HBS.entities.Hotel;
import com.HBS.entities.Room;
import com.HBS.entities.Service;
import com.HBS.util.HBSEmployeeDAOFactory;
import com.HBS.utils.HBSCustomerDAOFactory;
import com.HBS.utils.HBSHotelDAOFactory;
import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;
import com.mysql.cj.x.protobuf.Mysqlx.Ok;

public class HBSAppMain {
	public static void main(String[] args) {

		System.out.println(
				"Welcome to Hotel Booking App where you can find details of a hotel of your choice and other allied information");
		Scanner actionInput = null;
		int choice = 0;
		boolean isRunning = true;

		try {
			while (true) {
				if (isRunning == false) {
					break;
				}
				System.out.println("Enter choice: ");
				System.out.println("1. query");
				System.out.println("2. exit");
				actionInput = new Scanner(System.in);
				if (actionInput.hasNextLine()) {
					choice = Integer.parseInt(actionInput.nextLine());
				}

				switch (choice) {

				case 1:
					Scanner queryInput = null;
					int selectedQuery = 0;
					queryInput = selectQueryMethods();
					selectedQuery = Integer.parseInt(queryInput.nextLine());

					if (selectedQuery == 1) {
						System.out.println("enter the id of the hotel");
						long hotelID = Integer.parseInt(queryInput.nextLine());
						testGetCustomersOfAHotel(hotelID);
					} else if (selectedQuery == 2) {
						System.out.println("enter the id of laundry service");
						long laundryServiceID = Integer.parseInt(queryInput.nextLine());
						testGetHotelsProvidingLaundryService(laundryServiceID);
					} else if (selectedQuery == 3) {
						System.out.println("enter the id of the hotel");
						long hotelID = Integer.parseInt(queryInput.nextLine());
						testGetRoomOfAHotelWithHighestBooking(hotelID);
					} else if (selectedQuery == 4) {
						System.out.println("enter the id of the hotel");
						long hotelID = Integer.parseInt(queryInput.nextLine());
						System.out.println("enter the id of the customer");
						long customerID = Integer.parseInt(queryInput.nextLine());
						testGetBookingsOfACustomerInAHotel(hotelID, customerID);
					} else if (selectedQuery == 5) {
						testGetHotelWithHighestNumberOfCustomers();
					} else if (selectedQuery == 6) {
						System.out.println("enter the id of laundry service");
						long laundryServiceID = Integer.parseInt(queryInput.nextLine());
						testGetCustomersHavingLaundryServiceInBooking(laundryServiceID);
					} else if (selectedQuery == 7) {
						System.out.println("enter the id of the hotel");
						long hotelID = Integer.parseInt(queryInput.nextLine());
						testGetEmployeeWithHighestBookingInAHotel(hotelID);
					} else if (selectedQuery == 8) {
						testGetHotelHavingSecondHighestBooking();
					} else {
						System.out.println("exited from query select option...");
						break;
					}
					break;

				case 2:
					System.out.println("Thank you, visit again");
					isRunning = false;
					break;
				}

			}

		} finally {
			actionInput.close();
		}

//		testGetCustomersOfAHotel();
//		testGetHotelsProvidingLaundryService();
//		testGetRoomOfAHotelWithHighestBooking();
//		testGetBookingsOfACustomerInAHotel();
//		testGetHotelWithHighestNumberOfCustomers();
//		testGetCustomersHavingLaundryServiceInBooking();
//		testGetEmployeeWithHighestBookingInAHotel();
//		testGetHotelHavingSecondHighestBooking();
	}

	private static Scanner selectQueryMethods() {
		System.out.println("select from the following queries");
		System.out.println("1. testGetCustomersOfAHotel");
		System.out.println("2. testGetHotelsProvidingLaundryService");
		System.out.println("3. testGetRoomOfAHotelWithHighestBooking");
		System.out.println("4. testGetBookingsOfACustomerInAHotel");
		System.out.println("5. testGetHotelWithHighestNumberOfCustomers");
		System.out.println("6. testGetCustomersHavingLaundryServiceInBooking");
		System.out.println("7. testGetEmployeeWithHighestBookingInAHotel(");
		System.out.println("8. testGetHotelHavingSecondHighestBooking");
		System.out.println("9. exit");
		Scanner queryInput = null;
		queryInput = new Scanner(System.in);
		return queryInput;
	}

	// Start of testGetCustomersOfAHotel method
	private static void testGetCustomersOfAHotel(long hotelID) {
		try {
			IHBSHotelDAO hbsHotelDAO = HBSHotelDAOFactory.getHBSHotelDAO();
			CustomerDTO customerInfo = hbsHotelDAO.getCustomersOfAHotel(hotelID);
			int index = 0;
			List<Customer> customers = customerInfo.getCustomers();
			String hotelName = customerInfo.getHotel().getHotel_name();
			if (hotelName == null) {
				System.out.println("hotel with the given id does not exist. try again...");
				return;
			} else {
				System.out.println("This method provide details of customers in a given hotel");
				System.out.println("Total number of existing customers in the specified hotel is: " + customers.size());
				System.out.println("hotel name: " + hotelName);
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
			}

		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	// End of testGetCustomersOfAHotel method

// Start of testGetHotelsProvidingLaundryService method
	private static void testGetHotelsProvidingLaundryService(long serviceID) {
		try {
			IHBSHotelDAO hbsHotelDAO = HBSHotelDAOFactory.getHBSHotelDAO();
			HotelDTO hotelInfo = hbsHotelDAO.getHotelsProvidingLaundryService(serviceID);
			int index = 0;
			List<Hotel> hotels = hotelInfo.getHotels();
			String serviceType = hotelInfo.getService().getService_type();
			if (serviceType == null) {
				System.out.println("given service id not correct. try again...");
				return;
			} else {
				System.out.println("This method gives details of hotels that provide an optional laundry service");

				System.out.println("Total number of hotels are: " + hotels.size());
				System.out.println("----------------------------------");
				System.out.println("Service type: " + serviceType);
				for (Hotel hotel : hotels) {
					index++;
					System.out.println("Hotel Record " + index);
					System.out.println("\t" + "id: " + hotel.getHotel_id());
					System.out.println("\t" + "name: " + hotel.getHotel_name());
					System.out.println("\t" + "type: " + hotel.getHotel_type());
					System.out.println("\t" + "rating: " + hotel.getHotel_rating());
					System.out.println("\t" + "description: " + hotel.getHotel_desc());
					System.out.println("\t" + "city: " + hotel.getHotel_city());
					System.out.println("\t" + "state: " + hotel.getHotel_state());
					System.out.println("\t" + "phone no: " + hotel.getHotel_phone_no());
					System.out.println("\t" + "state: " + hotel.getHotel_email_id());
					System.out.println("----------------------------------");
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// End of testGetHotelsProvidingLaundryService method

	// Start of testGetRoomOfAHotelWithHighestBooking method
	private static void testGetRoomOfAHotelWithHighestBooking(long hotelID) {
		try {
			IHBSHotelDAO hbsHotelDAO = HBSHotelDAOFactory.getHBSHotelDAO();
			RoomDTO roomInfo = hbsHotelDAO.getRoomOfAHotelWithHighestBooking(hotelID);
			Room room = roomInfo.getRoom();
			int noOfBookings = roomInfo.getNoOfBookings();
			String roomHotelName = roomInfo.getHotel().getHotel_name();
			if (roomHotelName == null) {
				System.out.println("hotel with the given id does not exist. try again...");
				return;
			} else {
				System.out.println("This method provides details of room of a specific hotel with highest booking");
				System.out.println("Details of the room are given below:");
				System.out.println("----------------------------------");
				System.out.println("room id: " + room.getRoom_id());
				System.out.println("hotel name: " + roomHotelName);
				System.out.println("type: " + room.getRoom_type());
				System.out.println("description: " + room.getRoom_desc());
				System.out.println("total no of bookings: " + noOfBookings);
				System.out.println("----------------------------------");
			}

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	// End of testGetRoomOfAHotelWithHighestBooking method

	// Start of testGetBookingsOfACustomerInAHotel method
	private static void testGetBookingsOfACustomerInAHotel(long hotelID, long customerID) {
		try {
			IHBSCustomerDAO hbsCustomerDAO = HBSCustomerDAOFactory.getHBSCustomerDAO();
			CustomerDTO customerInfo = hbsCustomerDAO.getBookingsOfACustomerInAHotel(hotelID, customerID);
			List<Booking> bookings = customerInfo.getBookings();
			String bookingHotelName = customerInfo.getHotel().getHotel_name();
			if (bookingHotelName == null) {
				System.out.println("hotel with given id does not exist. try again");
				return;
			} else {
				List<Customer> customers = customerInfo.getCustomers();
				for (Customer c : customers) {
					if (c.getCustomer_id() == 0) {
						System.out.println("given customer id does not exist. try again");
						return;
					}
					else {
						String customerFirstName = c.getCustomer_f_name();
						System.out.println(customerFirstName);
						String customerLastName = c.getCustomer_l_name();
						System.out.println(customerLastName);
						if ((customerFirstName == null) || (customerLastName == null)) {
							System.out.println("given customer id does not exist. try again");
							return;
						} else {
							System.out.println("customer name: " + customerFirstName + " " + customerLastName);
						}
					}
			
					int index = 0;
					System.out.println(
							"This method prints the total number of bookings made by a given customer in a given hotel");
					System.out.println("Total number of bookings are: " + bookings.size());
					System.out.println("----------------------------------");
					System.out.println("hotel name: " + bookingHotelName);

					System.out.println("----------------------------------");
					for (Booking booking : bookings) {
						index++;
						System.out.println("Booking Record " + index);
						System.out.println("\t" + "booking id: " + booking.getBooking_id());
						System.out.println("\t" + "room id: " + booking.getRoom().getRoom_id());
						System.out.println("\t" + "booking start date: " + booking.getBooking_start_date());
						System.out.println("\t" + "booking vacate date: " + booking.getBooking_vacate_date());
						System.out.println("----------------------------------");

					}
				}

			}
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	// End of testGetBookingsOfACustomerInAHotel method

	// Start of testGetHotelWithHighestNumberOfCustomers method
	private static void testGetHotelWithHighestNumberOfCustomers() {
		try {
			IHBSHotelDAO hbsHotelDAO = HBSHotelDAOFactory.getHBSHotelDAO();
			HotelDTO hotelInfo = hbsHotelDAO.getHotelWithHighestNumberOfCustomers();
			List<Hotel> hotels = hotelInfo.getHotels();
			int noOfCustomers = hotelInfo.getNoOfCustomers();
			System.out.println("This method prints details of hotel with highest no of customers");
			System.out.println("Details of the hotel is given below:");
			System.out.println("----------------------------------");
			for (Hotel hotel : hotels) {
				System.out.println("hotel id: " + hotel.getHotel_id());
				System.out.println("hotel name: " + hotel.getHotel_name());
			}
			System.out.println("total no of customers: " + noOfCustomers);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
	}
	// End of testGetHotelWithHighestNumberOfCustomers method

	// Start of testGetCustomersHavingLaundryServiceInBooking method
	private static void testGetCustomersHavingLaundryServiceInBooking(long serviceID) {
		try {
			IHBSCustomerDAO hbsCustomerDAO = HBSCustomerDAOFactory.getHBSCustomerDAO();
			CustomerDTO customerInfo = hbsCustomerDAO.getCustomersHavingLaundryServiceInBooking(serviceID);
			List<Customer> customers = customerInfo.getCustomers();
			String serviceType = customerInfo.getService().getService_type();
			if (serviceType == null) {
				System.out.println("given service id not correct. try again...");
				return;
			} else {
				int index = 0;
				System.out.println("This method gives details of customers who have availed laundry service while booking");
				System.out.println("Service type: " + serviceType);
				System.out.println("Total no of customers are: " + customers.size());
				System.out.println("----------------------------------");
				for (Customer c : customers) {
					index++;
					System.out.println("Customer Record " + index);
					System.out.println("\t" + "id: " + c.getCustomer_id());
					System.out.println("\t" + "first name: " + c.getCustomer_f_name());
					System.out.println("\t" + "last name: " + c.getCustomer_l_name());
					System.out.println("----------------------------------");
				}
			}
		
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
	// End of testGetCustomersHavingLaundryServiceInBooking method

	// Start of testGetEmployeeWithHighestBookingInAHotel method
	private static void testGetEmployeeWithHighestBookingInAHotel(long hotelID) {

		try {
			IHBSEmployeeDAO hbsEmployeeDAO = HBSEmployeeDAOFactory.getHBSEmployeeDAO();
			EmployeeDTO employeeInfo = hbsEmployeeDAO.getEmployeeWithHighestBookingInAHotel(hotelID);
			List<Employee> employees = employeeInfo.getEmployees();
			String hotelName = employeeInfo.getHotel().getHotel_name();
			if (hotelName == null) {
				System.out.println("hotel with the given id does not exist");
				return;
			}
			int noOfBookings = employeeInfo.getNoOfBookings();

			System.out
					.println("This method prints details of employee who have taken highest booking in a given hotel");
			System.out.println("Details of the employee is given below:");
			System.out.println("----------------------------------");
			System.out.println("hotel name: " + hotelName);
			for (Employee employee : employees) {
				System.out.println("\t" + "employee id: " + employee.getSsn());
				System.out.println("\t" + "employee first name: " + employee.getEmployee_f_name());
				System.out.println("\t" + "employee last name: " + employee.getEmployee_l_name());
				System.out.println("\t" + "total no of bookings taken: " + noOfBookings);
			}

			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
	// End of testGetEmployeeWithHighestBookingInAHotel method

	// Start of getHotelHavingSecondHighestBooking method
	private static void testGetHotelHavingSecondHighestBooking() {
		try {
			IHBSHotelDAO hbsHotelDAO = HBSHotelDAOFactory.getHBSHotelDAO();
			HotelDTO hotelInfo = hbsHotelDAO.getHotelHavingSecondHighestBooking();
			List<Hotel> hotels = hotelInfo.getHotels();
			int noOfBookings = hotelInfo.getNoOfBookings();
			System.out.println("This methiod provides details of hotes with second highest no of bookings");
			System.out.println("Details of hotel is given below:");
			System.out.println("----------------------------------");

			for (Hotel hotel : hotels) {
				System.out.println("hotel id: " + hotel.getHotel_id());
				System.out.println("hotel name: " + hotel.getHotel_name());
			}
			System.out.println("total no of bookings: " + noOfBookings);
			System.out.println("----------------------------------");

		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}

	}
	// End of getHotelHavingSecondHighestBooking method
}
