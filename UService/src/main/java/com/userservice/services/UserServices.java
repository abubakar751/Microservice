package com.userservice.services;

import java.util.List;
import com.userservice.entities.UserService;

public interface UserServices {
UserService saveUser(UserService service);
List<UserService> getAllUser();
UserService getUser(String userId);
void deleteUser(String userId);
UserService updateUser(UserService  service,String userId);
}
