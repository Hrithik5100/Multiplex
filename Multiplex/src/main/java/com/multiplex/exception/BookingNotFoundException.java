package com.multiplex.exception;

public class BookingNotFoundException extends Exception{
	private String message;
	public BookingNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	public BookingNotFoundException() {
		
	}

}
