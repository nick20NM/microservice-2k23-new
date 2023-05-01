package com.alpha.HotelService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.HotelService.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
