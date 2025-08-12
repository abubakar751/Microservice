package com.userservice.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="User_Micro")
@Data
public class UserService {
	@Id
private String userId;
private String name;
private String email;
private String abut;
@Transient
private List<Rating> ratings;

}
