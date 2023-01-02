package com.HBS.entities;

import java.util.Date;
import java.util.List;

public class Booking {

	private long booking_id;
	private Date booking_start_date;
	private Date booking_vacate_date;
	private Hotel hotel;
	private Room room;
	private Customer customer;
	private Employee employee;
	private Bill bill;
	private List<Service> services;

	public Booking(Date booking_start_date, Date booking_vacate_date, Hotel hotel, Room room, Customer customer) {
		super();
		this.booking_start_date = booking_start_date;
		this.booking_vacate_date = booking_vacate_date;
		this.hotel = hotel;
		this.room = room;
		this.customer = customer;
	}

	public Booking() {
		super();
	}

	public long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(long booking_id) {
		this.booking_id = booking_id;
	}

	public Date getBooking_start_date() {
		return booking_start_date;
	}

	public void setBooking_start_date(Date booking_start_date) {
		this.booking_start_date = booking_start_date;
	}

	public Date getBooking_vacate_date() {
		return booking_vacate_date;
	}

	public void setBooking_vacate_date(Date booking_vacate_date) {
		this.booking_vacate_date = booking_vacate_date;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_start_date=" + booking_start_date
				+ ", booking_vacate_date=" + booking_vacate_date + ", hotel=" + hotel + ", room=" + room + ", customer="
				+ customer + ", bill=" + bill + "]";
	}

}
