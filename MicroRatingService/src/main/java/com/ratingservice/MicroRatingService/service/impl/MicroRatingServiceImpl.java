package com.ratingservice.MicroRatingService.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ratingservice.MicroRatingService.entity.MicroRating;
import com.ratingservice.MicroRatingService.repository.RatingRepository;
import com.ratingservice.MicroRatingService.service.MicroRatingService;

@Service
public class MicroRatingServiceImpl implements MicroRatingService {
	@Autowired
private RatingRepository ratingRepository;
	@Override
	public MicroRating createRating(MicroRating microRating) {
MicroRating save = ratingRepository.save(microRating);
		return save;
	}

	@Override
	public List<MicroRating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<MicroRating> getRatingByUserId(String ratingId) {
		
		return ratingRepository.findRatingByUserId(ratingId);
	}

	@Override
	public List<MicroRating> getRatingByHotelId(String ratingId) {
		
		return ratingRepository.findRatingByHotelId(ratingId);
	}

}
