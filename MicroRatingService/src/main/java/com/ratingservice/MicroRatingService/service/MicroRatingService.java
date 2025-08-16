package com.ratingservice.MicroRatingService.service;

import java.util.List;

import com.ratingservice.MicroRatingService.entity.MicroRating;

public interface MicroRatingService {
	MicroRating createRating(MicroRating microRating);
	List<MicroRating> getAllRating();
	List<MicroRating> getRatingByUserId(String userId);
	List<MicroRating> getRatingByHotelId(String hotelId);
	

}
