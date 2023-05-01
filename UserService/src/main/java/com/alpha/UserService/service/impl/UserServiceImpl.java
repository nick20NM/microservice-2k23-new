package com.alpha.UserService.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.UserService.entity.Hotel;
import com.alpha.UserService.entity.Rating;
import com.alpha.UserService.entity.User;
import com.alpha.UserService.exception.ResourceNotFoundException;
import com.alpha.UserService.external.services.HotelService;
import com.alpha.UserService.repository.UserRepository;
import com.alpha.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {
		String userId = UUID.randomUUID().toString(); // private String userId in User entity
		user.setUserId(userId);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(String userId) {
		// get user from database
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+userId));
		// fetch ratings of above user using RATING-SERVICE
		// http://localhost:3030/ratings/users/1
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);
		logger.info("{} ", ratingsOfUser);
		
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		
		List<Rating> ratingList = ratings.stream().map(rating -> {
			// api call to hotel service to get the hotel
			// http://localhost:2020/hotels/20
			
			// using RestTemplate class
//			System.out.println(rating.getHotelId());
//			ResponseEntity<Hotel> entity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//			logger.info("response status code: {} ", entity.getStatusCode());
//			Hotel hotel = entity.getBody();
			
			// using Feign Client
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
			
			// set the hotel to rating
			rating.setHotel(hotel);
			
			// return the rating
			return rating;
		}).collect(Collectors.toList());
		
		
		user.setRating(ratingList);
		return user;
	}

}
