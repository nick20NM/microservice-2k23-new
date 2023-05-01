package com.alpha.HotelService.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.HotelService.payload.ApiResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
//		String message = e.getMessage();
//		ApiResponse response = ApiResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
//		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
//	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> resourceNotFoundExceptionHandler(ResourceNotFoundException e){
		Map<String, Object> response=new HashMap<>();
		response.put("message", e.getMessage());
		response.put("success", true);
		response.put("status", HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
