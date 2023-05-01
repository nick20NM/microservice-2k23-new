package com.alpha.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super("resource not found");
	}

	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	

	
}
