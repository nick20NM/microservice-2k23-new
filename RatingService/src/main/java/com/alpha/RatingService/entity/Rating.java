package com.alpha.RatingService.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Rating {

	@Id
	private String ratingId;
	private long userId;
	private long hotelId;
	private int rating;
	private String feedback;
}
