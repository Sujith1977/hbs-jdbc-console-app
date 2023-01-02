package com.HBS.entities;

import java.util.Date;

public class Bill {

	private long bill_id;
	private Date bill_date;
	private Booking booking;
	private Customer customer;

	public Bill(long bill_id, Date bill_date, Booking booking, Customer customer) {
		super();
		this.bill_id = bill_id;
		this.bill_date = bill_date;
		this.booking = booking;
		this.customer = customer;
	}

	public long getBill_id() {
		return bill_id;
	}

	public void setBill_id(long bill_id) {
		this.bill_id = bill_id;
	}

	public Date getBill_date() {
		return bill_date;
	}

	public void setBill_date(Date bill_date) {
		this.bill_date = bill_date;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Bill [bill_id=" + bill_id + ", bill_date=" + bill_date + ", booking=" + booking + ", customer="
				+ customer + "]";
	}

}
