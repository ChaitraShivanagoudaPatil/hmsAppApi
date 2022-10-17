package com.ty.hmsappapi.exception;

public class InvalidCredentialsException extends RuntimeException {
	private String message = "Invalid credentials";

	public InvalidCredentialsException() {
	}

	public InvalidCredentialsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
