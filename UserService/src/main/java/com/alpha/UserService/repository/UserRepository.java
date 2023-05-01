package com.alpha.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.UserService.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
