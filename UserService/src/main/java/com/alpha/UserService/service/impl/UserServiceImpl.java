package com.alpha.UserService.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alpha.UserService.entity.Rating;
import com.alpha.UserService.entity.User;
import com.alpha.UserService.exception.ResourceNotFoundException;
import com.alpha.UserService.repository.UserRepository;
import com.alpha.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User createUser(User user) {
//		String id = UUID.randomUUID().toString(); // private String id in User entity
//		user.setId(id);
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long userId) {
		// get user from database
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+userId));
		// fetch ratings of above user using RATING-SERVICE
		// http://localhost:3030/ratings/users/1
		ArrayList<Rating> rating = restTemplate.getForObject("http://localhost:3030/ratings/users/"+user.getUserId(), ArrayList.class);
		logger.info("{} ", rating);
		user.setRating(rating);
		return user;
	}

}
