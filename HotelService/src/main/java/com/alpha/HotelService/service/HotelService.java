package com.alpha.HotelService.service;

import java.util.List;

import com.alpha.HotelService.entity.Hotel;

public interface HotelService {

	// create hotel
	Hotel createHotel(Hotel hotel);
	
	// get hotel by id
	Hotel getHotelById(long hotelId);
	
	// get all hotels
	List<Hotel> getAllHotels();
}
