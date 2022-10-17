package com.ty.hmsappapi.exception;

public class IdnotFoundException extends RuntimeException {
	private String message="Given id doesnt exist";

	public String getMessage() {
		return message;
	}
	public IdnotFoundException() {
		
	}
	public IdnotFoundException(String message) {
		this.message = message;
	}
}
