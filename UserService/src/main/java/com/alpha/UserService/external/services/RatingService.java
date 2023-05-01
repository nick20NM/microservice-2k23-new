package com.alpha.UserService.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alpha.UserService.entity.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	// POST
	@PostMapping("/ratings")
	Rating createRating(Rating rating);
	
	// GET ALL
	@GetMapping("/ratings")
	List<Rating> getAllRatings();
	
	// GET rating by id
	@GetMapping("/ratings/{ratingId}")
	ResponseEntity<Rating> getRatingById(@PathVariable String ratingId);
	
	// PUT
	@PutMapping("/ratings/{ratingId}")
	ResponseEntity<Rating> updateRatingById(@PathVariable String ratingId, Rating updatedRating);
	
	// DELETE
	@DeleteMapping("/ratings/{ratingId}")
	ResponseEntity<String> deleteRatingById(@PathVariable String ratingId);
	
}
