package com.alpha.UserService;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.alpha.UserService.entity.Rating;
import com.alpha.UserService.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {
	
	@Autowired
	private RatingService ratingService;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceApplicationTests.class);

//	@Test
//	void contextLoads() {
//	}
	
	// createRating() test
//	@Test
//	void testCreateRating() {
//		Rating rating = Rating.builder()
//				.userId("100")
//				.hotelId("100")
//				.rating(10)
//				.feedback("feedback")
//				.build();
//		Rating savedRating = ratingService.createRating(rating);
//		System.out.println("savedRating="+savedRating);
//	}
	
	// getAllRatings() test
//	@Test
//	void testGetAllRatings() {
//		List<Rating> ratings = ratingService.getAllRatings();
////		System.out.println("ratings="+ratings);
//		logger.info("ratings= {} "+ratings);
//	}
	
//	// getRatingById() test
//	@Test
//	void testGetRatingById() {
//		String ratingId="645000602e9bb1530d0063fb";
//		ResponseEntity<Rating> responseEntity = ratingService.getRatingById(ratingId);
//		responseEntity.getBody();
//		responseEntity.getStatusCode();
//		logger.info("responseEntity= {} "+responseEntity);
//	}
	
	// updateRatingById() test
//	@Test
//	void testUpdateRatingById() {
//		String ratingId="645000602e9bb1530d0063fb";
//		Rating updatedRating = Rating.builder()
//				.userId("updated 100")
//				.hotelId("updated 100")
//				.rating(5)
//				.feedback("updated feedback")
//				.build();
//		ResponseEntity<Rating> responseEntity = ratingService.updateRatingById(ratingId, updatedRating );
//		responseEntity.getBody();
//		responseEntity.getStatusCode();
//		logger.info("responseEntity= {} "+responseEntity);
//	}
	
	@Test
	void testDeleteRatingById() {
		String ratingId="645000602e9bb1530d0063fb";
		ResponseEntity<String> responseEntity = ratingService.deleteRatingById(ratingId);
		responseEntity.getBody();
		responseEntity.getStatusCode();
		logger.info("responseEntity= {} "+responseEntity);
	}
	
	

}
