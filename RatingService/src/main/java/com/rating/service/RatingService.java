package com.rating.service;

import com.rating.entity.Rating;

import com.rating.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // Save a new rating
    public Rating saveRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    // Get a rating by its ID
    public Rating getRatingById(String ratingId) {
        Optional<Rating> rating = ratingRepository.findById(ratingId);
        return rating.orElseThrow(() -> new RuntimeException("Rating not found with id: " + ratingId));
    }

    // Get all ratings
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    // Update an existing rating
    public Rating updateRating(String ratingId, Rating rating) {
        if (ratingRepository.existsById(ratingId)) {
            rating.setRatingId(ratingId);
            return ratingRepository.save(rating);
        } else {
            throw new RuntimeException("Rating not found with id: " + ratingId);
        }
    }

    // Delete a rating by its ID
    public void deleteRating(String ratingId) {
        if (ratingRepository.existsById(ratingId)) {
            ratingRepository.deleteById(ratingId);
        } else {
            throw new RuntimeException("Rating not found with id: " + ratingId);
        }
    }

    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    // Method to get all ratings by a particular user
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

}
