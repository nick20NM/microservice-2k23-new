package com.alpha.RatingService.service;

import java.util.List;

import com.alpha.RatingService.entity.Rating;

public interface RatingService {

	// create rating
	Rating createRating(Rating rating);
	
	// get all ratings
	List<Rating> getAllRatings();
	
	// get all ratings by user id
	List<Rating> getAllRatingsByUserId(String userId);
	
	// get all ratings by hotel id
	List<Rating> getAllRatingsByHotelId(String hotelId);
	
	// get rating by id
	Rating getRatingById(String ratingId);
	
	// update rating by id
	Rating updateRatingById(String ratingId, Rating updatedRating);
	
	// delete rating by id
	void deleteRatingById(String ratingId);
}
