package com.alpha.RatingService.service;

import java.util.List;

import com.alpha.RatingService.entity.Rating;

public interface RatingService {

	// create rating
	Rating createRating(Rating rating);
	
	// get all ratings
	List<Rating> getAllRatings();
	
	// get all ratings by user id
	List<Rating> getAllRatingsByUserId(long userId);
	
	// get all ratings by hotel id
	List<Rating> getAllRatingsByHotelId(long hotelId);
}
