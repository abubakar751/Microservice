package com.hotel.service;

import com.hotel.entity.Hotel;

import com.hotel.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
  private HotelRepository hotelRepository;

    // Save a new hotel
    public Hotel saveHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    // Get a hotel by its ID
    public Hotel getHotelById(String id) {
        Optional<Hotel> hotel = hotelRepository.findById(id);
        return hotel.orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
    }

    // Get all hotels
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    // Update an existing hotel
    public Hotel updateHotel(String id, Hotel hotel) {
        if (hotelRepository.existsById(id)) {
            hotel.setId(id);
            return hotelRepository.save(hotel);
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }

    // Delete a hotel by its ID
    public void deleteHotel(String id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
        } else {
            throw new RuntimeException("Hotel not found with id: " + id);
        }
    }
}
