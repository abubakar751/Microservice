package com.userservice.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.userservice.entities.Hotel;
import com.userservice.entities.Rating;
import com.userservice.entities.UserService;
import com.userservice.repository.UserRepository;
import com.userservice.services.UserServices;

@Service
public class ImplUserServices implements UserServices {
	@Autowired
	private UserRepository repository;
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public UserService saveUser(UserService service) {
		return repository.save(service);
	}

	@Override
	public List<UserService> getAllUser() {

		return repository.findAll();
	}

	@Override
public UserService getUser(String userId) {

    // 1. User nikalna DB se
    UserService userService = repository.findById(userId)
            .orElseThrow(() -> new ResourceAccessException("Given Id not found on server"));

    // 2. Rating service call
    String url = "http://localhost:1003/rating/userid/" + userId;
    Rating[] ratings = restTemplate.getForObject(url, Rating[].class);

    // 3. Har rating ke liye hotel service call
    List<Rating> ratingList = Arrays.stream(ratings).map(rating -> {
        Hotel hotel = restTemplate.getForObject(
                "http://localhost:1002/hotel/get/" + rating.getHotelId(),
                Hotel.class
        );
        rating.setHotel(hotel);
        return rating;
    }).collect(Collectors.toList());

    // 4. Rating list ko user me set karna
    userService.setRatings(ratingList);

    return userService;
}

	@Override
	public void deleteUser(String userId) {
		repository.findById(userId).get();

	}

	@Override
	public UserService updateUser(UserService service, String userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
