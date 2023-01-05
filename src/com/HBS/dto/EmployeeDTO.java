package com.HBS.dto;

import java.util.List;

import com.HBS.entities.Employee;
import com.HBS.entities.Hotel;

public class EmployeeDTO {
	List<Employee> employees;
	Hotel hotel;
	int noOfBookings;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getNoOfBookings() {
		return noOfBookings;
	}

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [employees=" + employees + ", hotel=" + hotel + ", noOfBookings=" + noOfBookings + "]";
	}

}
