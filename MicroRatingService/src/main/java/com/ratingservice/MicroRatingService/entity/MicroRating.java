package com.ratingservice.MicroRatingService.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="MicroRating")

public class MicroRating {
	@Id
	
	private String  ratingId;
	private String userId;
	private String hotelId;
	private String feedback;
	private int rating;
}
