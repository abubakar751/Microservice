package com.hotel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.hotel.entity.HotelServices;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;
@Service
public class HotelServiceImpl implements HotelService {
@Autowired
 private HotelRepository hotelRepository;
	@Override
	public  HotelServices createHotel(HotelServices hotelServices) {
		return 	hotelRepository.save(hotelServices);
	
	}

	@Override
	public List<HotelServices> getAllHotel() {
	return  hotelRepository.findAll();
		
	}

	@Override
	public HotelServices getHotelById(String hotelId) {
	return	hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceAccessException("Given Id not found on server"));
		
	}

	@Override
	public void deleteHotel(String hotelId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelServices updateHotel(HotelServices hotelServices, String hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
