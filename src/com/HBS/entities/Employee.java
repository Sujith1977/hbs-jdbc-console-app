package com.HBS.entities;

import java.util.Date;
import java.util.List;

public class Employee {
	private long ssn;
	private String employee_f_name;
	private String employee_l_name;
	private char employee_gender;
	private double employee_emoluments;
	private Date employee_dateOfBirth;
	private Date employe_dateOfJoining;
	private String employee_address;
	private Hotel hotel;
	private List<Booking> bookings;

	public Employee(String employee_f_name, String employee_l_name, char employee_gender, Date employee_dateOfBirth,
			Hotel hotel) {
		super();
		this.employee_f_name = employee_f_name;
		this.employee_l_name = employee_l_name;
		this.employee_gender = employee_gender;
		this.employee_dateOfBirth = employee_dateOfBirth;
		this.hotel = hotel;
	}

	public Employee() {
		super();
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getEmployee_f_name() {
		return employee_f_name;
	}

	public void setEmployee_f_name(String employee_f_name) {
		this.employee_f_name = employee_f_name;
	}

	public String getEmployee_l_name() {
		return employee_l_name;
	}

	public void setEmployee_l_name(String employee_l_name) {
		this.employee_l_name = employee_l_name;
	}

	public char getEmployee_gender() {
		return employee_gender;
	}

	public void setEmployee_gender(char employee_gender) {
		this.employee_gender = employee_gender;
	}

	public double getEmployee_emoluments() {
		return employee_emoluments;
	}

	public void setEmployee_emoluments(double employee_emoluments) {
		this.employee_emoluments = employee_emoluments;
	}

	public Date getEmployee_dateOfBirth() {
		return employee_dateOfBirth;
	}

	public void setEmployee_dateOfBirth(Date employee_dateOfBirth) {
		this.employee_dateOfBirth = employee_dateOfBirth;
	}

	public Date getEmploye_dateOfJoining() {
		return employe_dateOfJoining;
	}

	public void setEmploye_dateOfJoining(Date employe_dateOfJoining) {
		this.employe_dateOfJoining = employe_dateOfJoining;
	}

	public String getEmployee_address() {
		return employee_address;
	}

	public void setEmployee_address(String employee_address) {
		this.employee_address = employee_address;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Employee [ssn=" + ssn + ", employee_f_name=" + employee_f_name + ", employee_l_name=" + employee_l_name
				+ ", employee_gender=" + employee_gender + ", hotel=" + hotel + "]";
	}
}
