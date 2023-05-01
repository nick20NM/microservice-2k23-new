package com.alpha.UserService.service;

import java.util.List;

import com.alpha.UserService.entity.User;

public interface UserService {

	// create/save user
	User createUser(User user);

	// get all users
	List<User> getAllUsers();

	// get user by id
	User getUserById(String userId);
}
