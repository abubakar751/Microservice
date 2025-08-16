package com.ratingservice.MicroRatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ratingservice.MicroRatingService.entity.MicroRating;

@Repository
public interface RatingRepository extends JpaRepository<MicroRating,String> {
	List<MicroRating> findRatingByUserId(String userId);
	List<MicroRating> findRatingByHotelId(String hotelId);
}
