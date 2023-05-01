package com.alpha.UserService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.UserService.entity.User;
import com.alpha.UserService.exception.ResourceNotFoundException;
import com.alpha.UserService.repository.UserRepository;
import com.alpha.UserService.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
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
		return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found with id: "+userId));
	}

}
