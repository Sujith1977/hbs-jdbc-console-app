package com.HBS.dto;

import com.HBS.entities.Hotel;
import com.HBS.entities.Room;

public class RoomDTO {

	private Room room;
	private int noOfBookings;
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public RoomDTO() {
		super();
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public int getNoOfBookings() {
		return noOfBookings;
	}

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	@Override
	public String toString() {
		return "RoomDTO [room=" + room + ", noOfBookings=" + noOfBookings + "]";
	}

}
