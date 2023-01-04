package com.HBS.dto;

import java.util.List;

import com.HBS.entities.Booking;
import com.HBS.entities.Customer;
import com.HBS.entities.Hotel;
import com.HBS.entities.Service;

public class CustomerDTO {
	List<Booking> bookings;
	Hotel hotel;
	Service service;
	List<Customer> customers;

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "CustomerDTO [bookings=" + bookings + ", hotel=" + hotel + ", service=" + service + ", customers="
				+ customers + "]";
	}

}
