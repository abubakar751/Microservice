package com.hotel.controller;

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

import com.hotel.entity.HotelServices;
import com.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private HotelService service;
	@PostMapping("/save")
	ResponseEntity<HotelServices>	saveHotel(@RequestBody HotelServices hotelServices) {
	return ResponseEntity.status(HttpStatus.CREATED) .body( service.createHotel(hotelServices));
}
	@GetMapping("/All")
	ResponseEntity< List<HotelServices>> getAllHotels(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getAllHotel());
	}

	@GetMapping("/get/{hotelId}")
	ResponseEntity<HotelServices> getHotel(@PathVariable("hotelId") String hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.getHotelById(hotelId));
	}
}
