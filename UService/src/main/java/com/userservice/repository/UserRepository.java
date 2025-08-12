package com.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userservice.entities.UserService;

@Repository
public interface UserRepository extends JpaRepository<UserService, String> {

}
