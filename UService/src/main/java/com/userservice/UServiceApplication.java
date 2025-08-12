package com.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UServiceApplication.class, args);
		System.out.println("UService Run Successfully");
	}

}
