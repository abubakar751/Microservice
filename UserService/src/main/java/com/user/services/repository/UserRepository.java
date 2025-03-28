package com.user.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.user.services.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
