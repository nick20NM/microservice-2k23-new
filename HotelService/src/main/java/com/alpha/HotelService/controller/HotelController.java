package com.alpha.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.HotelService.entity.Hotel;
import com.alpha.HotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	// create hotel
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
	}
	
	// get hotel by id
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable long hotelId){
		return ResponseEntity.ok(hotelService.getHotelById(hotelId));
	}
	
	// get all hotels
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotels(){
		return ResponseEntity.ok(hotelService.getAllHotels());
	}
}
