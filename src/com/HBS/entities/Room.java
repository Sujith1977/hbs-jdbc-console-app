package com.HBS.entities;

import java.util.List;

public class Room {
	private long room_id;
	private String room_type;
	private String room_desc;
	private int room_service_no;
	private double room_rent;
	private Hotel hotel;
	private List<Booking> bookings;

	public Room(String room_type, String room_desc, double room_rent, Hotel hotel) {
		super();
		this.room_type = room_type;
		this.room_desc = room_desc;
		this.room_rent = room_rent;
		this.hotel = hotel;
	}

	public Room() {
		super();
	}

	public long getRoom_id() {
		return room_id;
	}

	public void setRoom_id(long room_id) {
		this.room_id = room_id;
	}

	public String getRoom_type() {
		return room_type;
	}

	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}

	public String getRoom_desc() {
		return room_desc;
	}

	public void setRoom_desc(String room_desc) {
		this.room_desc = room_desc;
	}

	public int getRoom_service_no() {
		return room_service_no;
	}

	public void setRoom_service_no(int room_service_no) {
		this.room_service_no = room_service_no;
	}

	public double getRoom_rent() {
		return room_rent;
	}

	public void setRoom_rent(double room_rent) {
		this.room_rent = room_rent;
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
		return "Room [room_id=" + room_id + ", room_type=" + room_type + ", room_desc=" + room_desc
				+ ", room_service_no=" + room_service_no + ", room_rent=" + room_rent + ", hotel=" + hotel
				+ ", bookings=" + bookings + "]";
	}

}
