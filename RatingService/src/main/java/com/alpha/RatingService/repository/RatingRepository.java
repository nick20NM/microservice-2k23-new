package com.alpha.RatingService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alpha.RatingService.entity.Rating;

public interface RatingRepository extends MongoRepository<Rating, Long> {

	// custom finder methods
	List<Rating> findByUserId(long userId);
	List<Rating> findByHotelId(long hotelId);
}
