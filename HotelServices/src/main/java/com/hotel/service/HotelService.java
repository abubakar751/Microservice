package com.hotel.service;

import java.util.List;

import com.hotel.entity.HotelServices;

public interface HotelService {
	HotelServices createHotel(HotelServices hotelServices);
	List<HotelServices> getAllHotel();
	HotelServices getHotelById(String hotelId);
	void deleteHotel(String hotelId);
	HotelServices updateHotel(HotelServices hotelServices,String hotelId);

}
