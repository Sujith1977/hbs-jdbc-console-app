package com.HBS.entities;

import java.util.List;

public class Hotel {
	private long hotel_id;
	private String hotel_name;
	private String hotel_type;
	private char hotel_rating;
	private String hotel_desc;
	private String hotel_city;
	private String hotel_state;
	private String hotel_phone_no;
	private String hotel_email_id;
	private long pincode;
	private List<Room> rooms;
	private List<Customer> customers;
	private List<Service> services;
	private List<Employee> employees;
	private List<Booking> bookings;

	public Hotel(String hotel_name, String hotel_type, char hotel_rating, String hotel_desc, String hotel_city,
			String hotel_state, String hotel_phone_no, String hotel_email_id) {
		super();
		this.hotel_name = hotel_name;
		this.hotel_type = hotel_type;
		this.hotel_rating = hotel_rating;
		this.hotel_desc = hotel_desc;
		this.hotel_city = hotel_city;
		this.hotel_state = hotel_state;
		this.hotel_phone_no = hotel_phone_no;
		this.hotel_email_id = hotel_email_id;
	}

	public Hotel() {
		super();
	}

	public long getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(long hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_type() {
		return hotel_type;
	}

	public void setHotel_type(String hotel_type) {
		this.hotel_type = hotel_type;
	}

	public char getHotel_rating() {
		return hotel_rating;
	}

	public void setHotel_rating(char hotel_rating) {
		this.hotel_rating = hotel_rating;
	}

	public String getHotel_desc() {
		return hotel_desc;
	}

	public void setHotel_desc(String hotel_desc) {
		this.hotel_desc = hotel_desc;
	}

	public String getHotel_city() {
		return hotel_city;
	}

	public void setHotel_city(String hotel_city) {
		this.hotel_city = hotel_city;
	}

	public String getHotel_state() {
		return hotel_state;
	}

	public void setHotel_state(String hotel_state) {
		this.hotel_state = hotel_state;
	}

	public String getHotel_phone_no() {
		return hotel_phone_no;
	}

	public void setHotel_phone_no(String hotel_phone_no) {
		this.hotel_phone_no = hotel_phone_no;
	}

	public String getHotel_email_id() {
		return hotel_email_id;
	}

	public void setHotel_email_id(String hotel_email_id) {
		this.hotel_email_id = hotel_email_id;
	}

	public long getPincode() {
		return pincode;
	}

	public void setPincode(long pincode) {
		this.pincode = pincode;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	@Override
	public String toString() {
		return "Hotel [id=" + hotel_id + ", hotel_name=" + hotel_name + ", hotel_type=" + hotel_type + ", hotel_rating="
				+ hotel_rating + ", hotel_desc=" + hotel_desc + ", hotel_city=" + hotel_city + ", hotel_state="
				+ hotel_state + ", hotel_phone_no=" + hotel_phone_no + ", hotel_email_id=" + hotel_email_id
				+ ", pincode=" + pincode + "]";
	}

}
