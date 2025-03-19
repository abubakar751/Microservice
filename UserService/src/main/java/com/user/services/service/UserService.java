package com.user.services.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.user.services.entity.Rating;
import com.user.services.entity.User;
import com.user.services.entity.UserHotel;
import com.user.services.exception.ResourceNotFoundException;
import com.user.services.repository.UserRepository;
@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;
	@Autowired
    private RestTemplate restTemplate;
	
	@Override
	public User saveData(User user) {
		return repository.save(user);
	}
	@Override
	public User getDataById(String userId) {
	    User user = repository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + userId));

	    Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/hotel/" + user.getUserId(), Rating[].class);
	    
	    if (ratings != null && ratings.length > 0) {
	        Rating rating = ratings[0];  
	        UserHotel hotel = restTemplate.getForObject("http://HOTELSERVICE/hotels/" + rating.getHotelId(), UserHotel.class);
	        
	        
	        user.setHotels(Collections.singletonList(hotel));
	        user.setRating(Collections.singletonList(rating));
	    }

	    return user;
	}



	@Override
	public List<User> getAllData() {// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User updateData(String userId ,User user) {
		
		 User orElseThrow = repository.findById(userId).orElseThrow(() -> new ResourceAccessException("Id not found"));
		 user.setUserId(orElseThrow.getUserId());
	return	 repository.save(user);
	}

	@Override
	public void deleteData(String userId) {
		 User orElseThrow = repository.findById(userId).orElseThrow(()->new ResourceAccessException("Id Not fround"));
		 repository.delete(orElseThrow);
		
	}

	
	

}
