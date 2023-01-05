package com.HBS.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.HBS.dto.EmployeeDTO;
import com.HBS.entities.Employee;
import com.HBS.entities.Hotel;
import com.HBS.utils.DatabaseConnectionFactory;
import com.HBS.utils.IHBSDatabaseConnectionUtil;

public class HBSEmployeeDAO implements IHBSEmployeeDAO {
	static IHBSDatabaseConnectionUtil hbsDbConnectionUtil = DatabaseConnectionFactory.getDB();

	// Start of getEmployeeWithHighestBookingInAHotel method
	@Override
	public EmployeeDTO getEmployeeWithHighestBookingInAHotel(long hotelID) throws SQLException {
		String getEmployeeQuery = "SELECT e.ssn, e.employee_f_name, e.employee_l_name, count(b.booking_id) noOfBookings FROM employee e INNER JOIN booking b ON e.ssn = b.ssn WHERE b.hotel_id = "
				+ hotelID + "  GROUP BY e.employee_f_name, e.employee_l_name ORDER BY count(b.booking_id) DESC LIMIT 1";

		EmployeeDTO employeeDTO = new EmployeeDTO();
		List<Employee> employees = new ArrayList<Employee>();
		Hotel hotel = new Hotel();
		int noOfBookings = 0;
		Connection connection = null;
		try {
			connection = hbsDbConnectionUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(getEmployeeQuery);
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setSsn(resultSet.getLong(1));

				String employeeFirstName = resultSet.getString(2);
				if (!resultSet.wasNull()) {
					employee.setEmployee_f_name(employeeFirstName);
				} else {
					employee.setEmployee_f_name(" ");
				}

				String employeeLastName = resultSet.getString(3);
				if (!resultSet.wasNull()) {
					employee.setEmployee_l_name(employeeLastName);
				} else {
					employee.setEmployee_l_name(" ");
				}

				String hotelNameQuery = "SELECT hotel_name FROM Hotel WHERE hotel_id = " + hotelID;
				Statement stmt = connection.createStatement();
				ResultSet rsHotel = stmt.executeQuery(hotelNameQuery);
				while (rsHotel.next()) {
					String hotelName = rsHotel.getString(1);
					if (!resultSet.wasNull()) {
						hotel.setHotel_name(hotelName);
					}
				}

				employees.add(employee);
				noOfBookings = resultSet.getInt(4);

			}
			employeeDTO.setEmployees(employees);
			employeeDTO.setNoOfBookings(noOfBookings);
			employeeDTO.setHotel(hotel);

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

		return employeeDTO;

	}
	// End of getEmployeeWithHighestBookingInAHotel method
}
