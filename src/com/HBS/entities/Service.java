package com.HBS.entities;

import java.util.List;

public class Service {
	private long service_id;
	private String service_type;
	private String service_desc;
	List<Hotel> hotels;
	List<Booking> bookings;

	public Service(String service_type, String service_desc) {
		super();
		this.service_type = service_type;
		this.service_desc = service_desc;
	}

	public Service() {
		super();
	}

	public long getService_id() {
		return service_id;
	}

	public void setService_id(long service_id) {
		this.service_id = service_id;
	}

	public String getService_type() {
		return service_type;
	}

	public void setService_type(String service_type) {
		this.service_type = service_type;
	}

	public String getService_desc() {
		return service_desc;
	}

	public void setService_desc(String service_desc) {
		this.service_desc = service_desc;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Service [service_id=" + service_id + ", service_type=" + service_type + ", service_desc=" + service_desc
				+ ", hotels=" + hotels + ", bookings=" + bookings + "]";
	}

}
