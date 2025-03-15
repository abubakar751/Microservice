package com.user.services.service;

import java.util.List;

import com.user.services.entity.User;

public interface IUserService {
	User saveData(User user);
	User getDataById(String userId);
	List<User> getAllData();
	User updateData(String userId, User user);
	void deleteData(String userId);

}
