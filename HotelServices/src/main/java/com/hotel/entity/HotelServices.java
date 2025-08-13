package com.hotel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="Hotel_Service")
public class HotelServices {
	@Id
	private String  hotelId;
	private String name;
    private String location;
	private String about;

}
