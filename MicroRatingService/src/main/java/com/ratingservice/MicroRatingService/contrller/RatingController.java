package com.ratingservice.MicroRatingService.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratingservice.MicroRatingService.entity.MicroRating;
import com.ratingservice.MicroRatingService.service.MicroRatingService;

@RequestMapping("/rating")
@RestController
public class RatingController {
	@Autowired
	private MicroRatingService service;

	@PostMapping("/save")
	public ResponseEntity<MicroRating> create(@RequestBody MicroRating microRating) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createRating(microRating));
	}

	@GetMapping("/all")
	public ResponseEntity<List<MicroRating>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllRating());
	}
	@GetMapping("/userid/{userId}")
	public ResponseEntity<List<MicroRating>> getByUserId(@PathVariable("userId") String userId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByUserId(userId));
	}
	@GetMapping("/hotelid/{hotelId}")
	public ResponseEntity<List<MicroRating>> getByHotelId(@PathVariable("hotelId") String hotelId) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getRatingByHotelId(hotelId));
	}
}
