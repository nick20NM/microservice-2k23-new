package com.alpha.HotelService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.HotelService.entity.Hotel;
import com.alpha.HotelService.exception.ResourceNotFoundException;
import com.alpha.HotelService.repository.HotelRepository;
import com.alpha.HotelService.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelById(long hotelId) {
		return hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel not found with id: "+hotelId));
	}

	@Override
	public List<Hotel> getAllHotels() {
		return hotelRepository.findAll();
	}

}
