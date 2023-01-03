package com.HBS.dto;

import java.util.List;

import com.HBS.entities.Hotel;
import com.HBS.entities.Service;

public class HotelDTO {
	private List<Hotel> hotels;
	private Service service;
	private int noOfCustomers;
	private int noOfBookings;

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public int getNoOfCustomers() {
		return noOfCustomers;
	}

	public void setNoOfCustomers(int noOfCustomers) {
		this.noOfCustomers = noOfCustomers;
	}

	public int getNoOfBookings() {
		return noOfBookings;
	}

	public void setNoOfBookings(int noOfBookings) {
		this.noOfBookings = noOfBookings;
	}

	@Override
	public String toString() {
		return "HotelDTO [hotel=" + hotels + ", service=" + service + "]";
	}

}
