package com.alpha.RatingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.RatingService.entity.Rating;
import com.alpha.RatingService.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	// create rating
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	
	// get all ratings
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		return ResponseEntity.ok(ratingService.getAllRatings());
	}
	
	// get all ratings by user id
	@GetMapping("/users/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@PathVariable String userId){
		return ResponseEntity.ok(ratingService.getAllRatingsByUserId(userId));
	}
	
	// get all ratings by hotel id
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotelId(@PathVariable String hotelId){
		return ResponseEntity.ok(ratingService.getAllRatingsByHotelId(hotelId));
	}
	
	// update rating by id
	@PutMapping("/{ratingId}")
	public ResponseEntity<Rating> updateRatingById(@PathVariable String ratingId, @RequestBody Rating updatedRating){
		return ResponseEntity.ok(ratingService.updateRatingById(ratingId, updatedRating));
	}
	
	// get rating by id
	@GetMapping("/{ratingId}")
	public ResponseEntity<Rating> getRatingById(@PathVariable String ratingId){
		return ResponseEntity.ok(ratingService.getRatingById(ratingId));
	}
	
	// delete rating by id
	@DeleteMapping("/{ratingId}")
	public ResponseEntity<String> deleteRatingById(@PathVariable String ratingId){
		ratingService.deleteRatingById(ratingId);
		return ResponseEntity.ok("rating deleted with id: "+ratingId);
	}
}
