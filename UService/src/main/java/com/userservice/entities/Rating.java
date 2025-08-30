package com.userservice.entities;

import lombok.Data;

@Data
public class Rating {
	private String  ratingId;
	private String userId;
	private String hotelId;
	private String feedback;
	private int rating;
	private Hotel hotel;	

}
