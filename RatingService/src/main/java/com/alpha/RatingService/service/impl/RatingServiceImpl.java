package com.alpha.RatingService.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alpha.RatingService.entity.Rating;
import com.alpha.RatingService.exception.ResourceNotFoundException;
import com.alpha.RatingService.repository.RatingRepository;
import com.alpha.RatingService.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public Rating createRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRatings() {
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getAllRatingsByUserId(String userId) {
		return ratingRepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingsByHotelId(String hotelId) {
		return ratingRepository.findByHotelId(hotelId);
	}

	@Override
	public Rating getRatingById(String ratingId) {
		return ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating not found with id: "+ratingId));
	}

	@Override
	public Rating updateRatingById(String ratingId, Rating updatedRating) {
		
		// get rating from database
		Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating not found with id: "+ratingId));
		
		// set/update rating
		rating.setUserId(updatedRating.getUserId());
		rating.setHotelId(updatedRating.getHotelId());
		rating.setRating(updatedRating.getRating());
		rating.setFeedback(updatedRating.getFeedback());
		
		// save rating
		return ratingRepository.save(rating);
	}

	@Override
	public void deleteRatingById(String ratingId) {
		Rating rating = ratingRepository.findById(ratingId).orElseThrow(() -> new ResourceNotFoundException("rating not found with id: "+ratingId));
		ratingRepository.delete(rating);
	}

}
