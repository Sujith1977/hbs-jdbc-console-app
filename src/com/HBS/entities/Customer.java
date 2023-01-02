package com.HBS.entities;

import java.util.List;

public class Customer {
	private long customer_id;
	private String customer_f_name;
	private String customer_l_name;
	private String customer_city;
	private String customer_state;
	private String customer_phone_no;
	private String customer_email_id;
	private List<Booking> bookings;
	private List<Bill> bills;
	private List<Hotel> hotels;
	
	public Customer() {
		super();
	}

	public Customer(String customer_f_name, String customer_l_name, String customer_city, String customer_state, String customer_phone_no, String customer_email_id) {
		super();
		this.customer_f_name = customer_f_name;
		this.customer_l_name = customer_l_name;
		this.customer_city = customer_city;
		this.customer_state = customer_state;
		this.customer_phone_no = customer_phone_no;
		this.customer_email_id = customer_email_id;
	}

	public long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_f_name() {
		return customer_f_name;
	}

	public void setCustomer_f_name(String customer_f_name) {
		this.customer_f_name = customer_f_name;
	}

	public String getCustomer_l_name() {
		return customer_l_name;
	}

	public void setCustomer_l_name(String customer_l_name) {
		this.customer_l_name = customer_l_name;
	}

	public String getCustomer_city() {
		return customer_city;
	}

	public void setCustomer_city(String customer_city) {
		this.customer_city = customer_city;
	}

	public String getCustomer_state() {
		return customer_state;
	}

	public void setCustomer_state(String customer_state) {
		this.customer_state = customer_state;
	}

	public String getCustomer_phone_no() {
		return customer_phone_no;
	}

	public void setCustomer_phone_no(String customer_phone_no) {
		this.customer_phone_no = customer_phone_no;
	}

	public String getCustomer_email_id() {
		return customer_email_id;
	}

	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_f_name=" + customer_f_name + ", customer_l_name="
				+ customer_l_name + ", customer_city=" + customer_city + ", customer_state=" + customer_state
				+ ", customer_phone_no=" + customer_phone_no + ", customer_email_id=" + customer_email_id
				+ ", bookings=" + bookings + ", hotels=" + hotels + "]";
	}

}
