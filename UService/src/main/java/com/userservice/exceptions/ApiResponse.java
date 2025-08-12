package com.userservice.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ApiResponse {
private String massage;
private boolean success;
private HttpStatus status;
}
