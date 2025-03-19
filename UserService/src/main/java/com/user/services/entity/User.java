package com.user.services.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class User {
	@Id
	private String userId;
	private String name;
	private String email;
	private String about;
	@Transient
	private List<Rating> rating;
	@Transient
	private List<UserHotel> hotels;
	public List<UserHotel> getHotels() {
		return hotels;
	}
	public void setHotels(List<UserHotel> hotels) {
		this.hotels = hotels;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
	
	public User(String userId, String name, String email, String about, List<Rating> rating, List<UserHotel> hotels) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.about = about;
		this.rating = rating;
		this.hotels = hotels;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", about=" + about + ", rating="
				+ rating + ", hotels=" + hotels + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}

	
	

}
