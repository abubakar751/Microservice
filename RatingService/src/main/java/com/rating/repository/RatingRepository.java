package com.rating.repository;

import com.rating.entity.Rating;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

	List<Rating> findByHotelId(String hotelId);

	List<Rating> findByUserId(String userId);
}
